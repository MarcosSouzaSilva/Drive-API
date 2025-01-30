package br.com.curso.infrastructure.domain.entity;


import br.com.curso.domain.Customer;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidPhoneNumberException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @JsonIgnore()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotNull
    @Column(name="name", nullable = false)
    private String name;

    @Setter
    @NotNull
    @Column(name="taxId", unique = true, nullable = false)
    private String taxId; // CPF / CNPJ

    @Setter
    @NotNull
    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Setter
    @NotNull
    @Column(name="phoneNumber", nullable = false)
    private String phoneNumber;

    @Setter
    @NotNull
    @Column(name="address", nullable = false)
    private String address;

    @Setter
    @NotNull
    @Column(name="password", nullable = false)
    private String password;

    @Setter
    @Getter
    @JsonIgnore
    @Column(name="birthDate", nullable = false)
    private LocalDate birthDate = LocalDate.now();

    @Setter
    @Getter
    @JsonIgnore
    @Column(name="createdAt", nullable = false)
    private LocalDate createdAt = LocalDate.now();

    @Transient
    private final Customer customer = new Customer();

    public void setTaxId(String taxId) throws InvalidTaxIdException {
        customer.setTaxId(taxId);
        this.taxId = taxId;
    }

    public void setPhoneNumber(String phoneNumber)  {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws InvalidEmailException {
        customer.setEmail(email);
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setPassword(String password) throws InvalidCredentialsException {
        //customer.setPassword(password);
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxId='" + taxId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", customer=" + customer +
                '}';
    }
}