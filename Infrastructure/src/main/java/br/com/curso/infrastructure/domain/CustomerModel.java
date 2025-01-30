


package br.com.curso.infrastructure.domain;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public class CustomerModel<T> extends RepresentationModel<CustomerModel<T>> {


    private T content;



    public CustomerModel(T content) {
        this.content = content;
    }

    public static <T> CustomerModel<T> of(T content) {
        return new CustomerModel<>(content);
    }

    public CustomerModel(Link initialLink, T content) {
        super(initialLink);
        this.content = content;
    }

    public CustomerModel(Iterable<Link> initialLinks, T content) {
        super(initialLinks);
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}