package io.swagger.api.factories;

import io.swagger.api.BooksApiService;
import io.swagger.api.impl.BooksApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-06-25T15:20:54.704Z")
public class BooksApiServiceFactory {
    private final static BooksApiService service = new BooksApiServiceImpl();

    public static BooksApiService getBooksApi() {
        return service;
    }
}
