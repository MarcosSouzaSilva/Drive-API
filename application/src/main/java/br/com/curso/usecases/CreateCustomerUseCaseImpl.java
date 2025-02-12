package br.com.curso.usecases;

import br.com.curso.domain.Customer;
import br.com.curso.exceptions.CustomerCreationException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidPhoneNumberException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.enums.ErrorCodeEnum;

import java.util.regex.Pattern;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    private final Pattern patternPassword = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    private final String regex = "^\\+55\\s?\\(?\\d{2}\\)?\\s?(9?\\d{4})[-\\s]?(\\d{4})$";

    private final Pattern patternPhoneNumber = Pattern.compile(regex);


    @Override
    public Customer createCustomer(Customer customer) throws CustomerCreationException, InvalidCredentialsException, InvalidEmailException, InvalidPhoneNumberException, InvalidTaxIdException {
        if (customer == null) throw new CustomerCreationException(ErrorCodeEnum.A0007.getMessage());

        if (!customer.getPassword().matches(patternPassword.pattern())) throw new InvalidCredentialsException();

        if (!customer.getEmail().matches(patternEmail.pattern())) throw new InvalidEmailException();

        if (!customer.getPhoneNumber().matches(patternPhoneNumber.pattern())) throw new InvalidPhoneNumberException();

        if (!isValid(customer.getTaxId())) throw new InvalidTaxIdException();

        return customer;
    }

    public boolean isValid(String number) throws IllegalArgumentException, InvalidTaxIdException {
        String cleanedNumber = number.replaceAll("\\D", ""); // Remove caracteres não numéricos

        if (cleanedNumber.length() == 11) {
            return isValidCPF(number);
        } else if (cleanedNumber.length() == 14) {
            return isValidCNPJ(number);
        } else {
            throw new InvalidTaxIdException();
        }
    }

    public boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos
        if (cpf.length() != 11 || cpf.matches(cpf.charAt(0) + "{11}")) return false;

        // Cálculo do primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (10 - i) * (cpf.charAt(i) - '0');
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) firstDigit = 0;

        // Cálculo do segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (11 - i) * (cpf.charAt(i) - '0');
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) secondDigit = 0;

        // Verifica se os dígitos calculados são iguais aos informados
        return (cpf.charAt(9) - '0' == firstDigit) && (cpf.charAt(10) - '0' == secondDigit);
    }

    public boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", ""); // Remove caracteres não numéricos
        if (cnpj.length() != 14 || cnpj.matches(cnpj.charAt(0) + "{14}")) return false;

        // Cálculo do primeiro dígito verificador
        int[] weights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) firstDigit = 0;

        // Cálculo do segundo dígito verificador
        weights = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) secondDigit = 0;

        // Verifica se os dígitos calculados são iguais aos informados
        return (cnpj.charAt(12) - '0' == firstDigit) && (cnpj.charAt(13) - '0' == secondDigit);
    }
}