package br.com.curso.usecases;

import br.com.curso.domain.Vehicle;
import br.com.curso.exceptions.InvalidLicensePlateException;
import br.com.curso.exceptions.InvalidVinException;
import br.com.curso.exceptions.InvalidYearException;
import br.com.curso.exceptions.VehicleCreationException;
import br.com.curso.exceptions.enums.ErrorCodeEnum;

import java.util.Calendar;
import java.util.regex.Pattern;

public class CreateVehicleUseCaseImpl implements CreateVehicleUseCase {

    Pattern patternLicensePlate = Pattern.compile("^[A-Z]{3}-?[0-9]{3}$|^[A-Z]{3}[0-9][A-Z0-9][A-Z0-9]{2}$|^[A-Z]{1,2}$");

    Pattern patternVin = Pattern.compile("^[A-HJ-NPR-Z0-9]{17}$");

    @Override
    public Vehicle createVehicle(Vehicle vehicle) throws VehicleCreationException, InvalidVinException, InvalidLicensePlateException, InvalidYearException {

        if (vehicle == null) throw new VehicleCreationException();

        validateVin(vehicle.getVin());
        validateLicensePlate(vehicle.getLicensePlate());
        validateYear(vehicle.getYear());

        return vehicle;
    }


    private void validateVin(String vin) throws InvalidVinException {
        if (!patternVin.matcher(vin).matches()) {
            throw new InvalidVinException();
        }
    }

    private void validateLicensePlate(String licensePlate) throws InvalidLicensePlateException {
        if (!patternLicensePlate.matcher(licensePlate).matches()) {
            throw new InvalidLicensePlateException();
        }
    }

    private void validateYear(int year) throws InvalidYearException {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > currentYear + 1) {
            throw new InvalidYearException();
        }
    }
}
