package br.com.curso.infrastructure.domain;

import org.springframework.hateoas.RepresentationModel;

public class UserModel <T> extends RepresentationModel<UserModel<T>> {


    private T content;


}