package br.com.curso.infrastructure.in.mappers;

import br.com.curso.domain.Vehicle;
import br.com.curso.infrastructure.domain.entity.VehicleEntity;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {






    public VehicleEntity toVehicleEntity(Vehicle vehicle) throws Exception {

        VehicleEntity vehicleEntity = new VehicleEntity();

        vehicleEntity.setLicensePlate(vehicle.getLicensePlate());
        vehicleEntity.setColor(vehicle.getColor());
        vehicleEntity.setBrand(vehicle.getBrand());
        vehicleEntity.setModel(vehicle.getModel());
        vehicleEntity.setVin(vehicle.getVin());
        vehicleEntity.setYear(vehicle.getYear());


        return vehicleEntity;
    }


}