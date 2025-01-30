package br.com.curso.usecases;

import br.com.curso.domain.Vehicle;
import br.com.curso.exceptions.InvalidLicensePlateException;
import br.com.curso.exceptions.InvalidVinException;
import br.com.curso.exceptions.InvalidYearException;
import br.com.curso.exceptions.VehicleCreationException;

public interface CreateVehicleUseCase {

     Vehicle createVehicle(Vehicle vehicle) throws VehicleCreationException, InvalidVinException, InvalidLicensePlateException, InvalidYearException;

}