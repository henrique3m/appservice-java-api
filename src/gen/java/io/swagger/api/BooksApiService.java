package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Book;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-06-25T15:20:54.704Z")
public abstract class BooksApiService {
    public abstract Response deleteBook(String isbn,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBookByIsbn(String isbn,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBooks(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBooksByAuthor(String author,SecurityContext securityContext) throws NotFoundException;
    public abstract Response insertBook(Book book,SecurityContext securityContext) throws NotFoundException;
}
