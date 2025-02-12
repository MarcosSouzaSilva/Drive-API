package br.com.curso.infrastructure.in.controllers;

import br.com.curso.domain.Vehicle;
import br.com.curso.infrastructure.domain.entity.VehicleEntity;
import br.com.curso.infrastructure.in.service.VehicleService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping("/createVehicle")
    public VehicleEntity createVehicle(@RequestHeader("Authorization") String authorization, @RequestBody Vehicle vehicle) throws Exception {
        return service.createVehicle(authorization, vehicle);
    }

}