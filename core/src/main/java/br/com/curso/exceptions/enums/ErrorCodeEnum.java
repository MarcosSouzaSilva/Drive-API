package br.com.curso.exceptions.enums;

public enum ErrorCodeEnum {


    A0001("User not found. Try again."),
    A0002("Invalid email. Try again."),
    A0003("Invalid Tax ID. Try again."),
    A0004("Invalid credentials"),
    A0005("Invalid year. Try again."),
    A0006("Error creating your account. Check the information and try again."),
    A0007("Error creating your customer account. Check the information and try again."),
    A0008("Invalid license plate. Try again."),
    A0009("Invalid car VIN. Try again."),
    A00010("Invalid phone number. Try again."),
    A00011("Error creating your vehicle. Check the information and try again."),
    A00012("Invalid vehicle. Try again.");

    private final String message;

    ErrorCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;

    }


}