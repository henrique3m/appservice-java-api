package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.BooksApiService;
import io.swagger.api.factories.BooksApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Book;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/books")


@io.swagger.annotations.Api(description = "the books API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-06-25T15:20:54.704Z")
public class BooksApi  {
   private final BooksApiService delegate = BooksApiServiceFactory.getBooksApi();

    @DELETE
    @Path("/{isbn}")
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete book from store", notes = "", response = void.class, tags={ "Book", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })
    public Response deleteBook(@ApiParam(value = "",required=true) @PathParam("isbn") String isbn
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteBook(isbn,securityContext);
    }
    @GET
    @Path("/isbn/{isbn}")
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Get book by ISBN", notes = "", response = Book.class, tags={ "Book", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Book.class) })
    public Response getBookByIsbn(@ApiParam(value = "",required=true) @PathParam("isbn") String isbn
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBookByIsbn(isbn,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Book.class, responseContainer = "List", tags={ "Book", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Book.class, responseContainer = "List") })
    public Response getBooks(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBooks(securityContext);
    }
    @GET
    @Path("/author/{author}")
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Get books by Author", notes = "", response = Book.class, responseContainer = "List", tags={ "Book", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Book.class, responseContainer = "List") })
    public Response getBooksByAuthor(@ApiParam(value = "",required=true) @PathParam("author") String author
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBooksByAuthor(author,securityContext);
    }
    @POST
    
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new book to the store", notes = "", response = void.class, tags={ "Book", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })
    public Response insertBook(@ApiParam(value = "" ) Book book
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.insertBook(book,securityContext);
    }
}
