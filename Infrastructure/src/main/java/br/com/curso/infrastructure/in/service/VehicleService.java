package br.com.curso.infrastructure.in.service;

import br.com.curso.domain.Vehicle;
import br.com.curso.exceptions.InvalidLicensePlateException;
import br.com.curso.exceptions.InvalidVinException;
import br.com.curso.exceptions.InvalidYearException;
import br.com.curso.exceptions.VehicleCreationException;
import br.com.curso.infrastructure.domain.entity.UserEntity;
import br.com.curso.infrastructure.domain.entity.VehicleEntity;
import br.com.curso.infrastructure.in.mappers.VehicleMapper;
import br.com.curso.infrastructure.out.repository.UserJpaRepository;
import br.com.curso.infrastructure.out.repository.VehicleJpaRepository;
import br.com.curso.usecases.CreateVehicleUseCaseImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import static br.com.curso.infrastructure.in.config.jwt.JwtUtil.extractUsername;

@Service
public class VehicleService {


    private final CreateVehicleUseCaseImpl createVehicleUseCaseImpl;

    private final VehicleMapper customerMapper;

    private final UserJpaRepository userJpaRepository;

    private final VehicleJpaRepository vehicleJpaRepository;

    public VehicleService(CreateVehicleUseCaseImpl createVehicleUseCaseImpl, VehicleMapper customerMapper, UserJpaRepository userJpaRepository, VehicleJpaRepository vehicleJpaRepository) {
        this.createVehicleUseCaseImpl = createVehicleUseCaseImpl;
        this.customerMapper = customerMapper;
        this.userJpaRepository = userJpaRepository;
        this.vehicleJpaRepository = vehicleJpaRepository;
    }


    @Transactional
    public VehicleEntity createVehicle(@RequestHeader("Authorization") String authorization, Vehicle vehicle) throws Exception {

        Vehicle userNew = createVehicleUseCaseImpl.createVehicle(vehicle);

        if (authorization.startsWith("Bearer ")) {

            String tokenValue = authorization.substring(7);

            var extractedToken = extractUsername(tokenValue);

            UserEntity user = userJpaRepository.findByEmail(extractedToken).orElseThrow(VehicleCreationException::new);

            var vehicleEntity = customerMapper.toVehicleEntity(userNew);

            vehicleEntity.setUser(user);

            return vehicleJpaRepository.save(vehicleEntity);
        }

        throw new Exception("The token is invalid");
    }

}