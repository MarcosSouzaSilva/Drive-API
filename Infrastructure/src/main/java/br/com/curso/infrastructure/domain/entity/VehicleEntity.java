package br.com.curso.infrastructure.domain.entity;

import br.com.curso.domain.Vehicle;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidLicensePlateException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.InvalidVinException;
import br.com.curso.exceptions.InvalidYearException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vehicle")
public class VehicleEntity extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private int year;

    @NotNull
    private String licensePlate;

    @NotNull
    private String color;

    @NotNull
    private String vin; // Vehicle Identification Number

    @ManyToOne
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private UserEntity user;

    @Transient
    private final Vehicle vehicle = new Vehicle();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidYearException {
        vehicle.setYear(year);
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) throws InvalidLicensePlateException {
        vehicle.setLicensePlate(licensePlate);
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) throws InvalidVinException {
        vehicle.setVin(vin);
        this.vin = vin;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
