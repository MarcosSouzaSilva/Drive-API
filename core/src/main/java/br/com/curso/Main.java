package br.com.curso;

import br.com.curso.domain.Customer;
import br.com.curso.domain.User;
import br.com.curso.domain.Vehicle;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidLicensePlateException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidPhoneNumberException;
import br.com.curso.exceptions.InvalidVinException;

public class Main {

    public static void main(String[] args) throws InvalidCredentialsException, InvalidEmailException, InvalidLicensePlateException, InvalidVinException, InvalidPhoneNumberException {

        User s = new User();

        Vehicle ss = new Vehicle();

        Customer customer = new Customer();

        s.setPassword("Mark133@");
        s.setEmail("usuario@dominio.com");

        ss.setLicensePlate("BEE4R22");

        ss.setVin("1HGCM82633A123456");

        customer.setPhoneNumber("+55 1198765-4321");

        System.out.println(s.getPassword());
        System.out.println(s.getEmail());
        System.out.println(ss.getLicensePlate());
        System.out.println(ss.getVin());
        System.out.println(customer.getPhoneNumber());

    }
}