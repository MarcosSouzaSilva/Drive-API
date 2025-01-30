package br.com.curso.infrastructure.in.util;

import br.com.curso.exceptions.CustomerCreationException;
import br.com.curso.exceptions.UserNotFoundException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidLicensePlateException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidPhoneNumberException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.InvalidVinException;
import br.com.curso.exceptions.InvalidYearException;
import br.com.curso.exceptions.UserCreationException;
import br.com.curso.exceptions.VehicleCreationException;
import br.com.curso.exceptions.VehicleInvalidException;
import br.com.curso.exceptions.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleIdentifierNotFoundException() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND);
        errorResponse.put("error", "Not Found");
        errorResponse.put("message", ErrorCodeEnum.A0001.getMessage());
        errorResponse.put("path", "/api/v1/user/createUser");

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequestOfEmail () {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0002.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTaxIdException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequestOfTaxId() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0003.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequestOfPassword() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0004.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidYearException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequestOfYear() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0005.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserCreationException.class)
    public ResponseEntity<Map<String, Object>> handleUserCreationException() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0006.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerCreationException.class)
    public ResponseEntity<Map<String, Object>> handleCustomerCreationException() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0007.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidLicensePlateException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequestOfLicensePlate() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0008.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidVinException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequestOfVin() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A0009.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequestOfPhoneNumber() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A00010.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VehicleCreationException.class)
    public ResponseEntity<Map<String, Object>> handleVehicleCreationException() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A00011.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(VehicleInvalidException.class)
    public ResponseEntity<Map<String, Object>> handleVehicleInvalidException() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", ErrorCodeEnum.A00012.getMessage());
        errorResponse.put("path", "/api/v1/customer/createCustomer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }



}