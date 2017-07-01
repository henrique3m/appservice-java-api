package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Book;

import java.util.List;
import io.swagger.api.NotFoundException;
import java.util.ArrayList;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-06-25T15:20:54.704Z")
public class BooksApiServiceImpl extends BooksApiService {

    private static ArrayList<Book> books = null;

    private ArrayList<Book> loadBooks()
    {
        if (books == null) {
            books = new ArrayList<Book>();
            books.add(new Book("978-1476792194", "The Third Wife: A Novel", "Lisa Jewell", "Atria Books", new Integer(2016)));
		    books.add(new Book("978-1472229953", "The Letter", "Lisa Jewell", "Headline", new Integer(2016)));
		    books.add(new Book("978-1451645859", "Ordinary Grace ", "William Kent Krueger", "Atria Books", new Integer(2014)));				  
        }

        return books;
    }

    @Override
    public Response deleteBook(String isbn, SecurityContext securityContext) throws NotFoundException {
        ArrayList<Book> list = loadBooks();
        Book ret = null;

         for(int i=0; i<list.size(); i++)
         {
             ret = list.get(i);
             if(ret.getIsbn().equals(isbn))  {
            	 list.remove(i);
                return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Livro excluido!")).build();
             }
         }
        
        return Response.status(Response.Status.NOT_FOUND).entity("Book not found with ISBN: " + isbn).build();
    }
    @Override
    public Response getBookByIsbn(String isbn, SecurityContext securityContext) throws NotFoundException {
        ArrayList<Book> list = loadBooks();
        Book ret = null;

         for(int i=0; i<list.size(); i++)
         {
             ret = list.get(i);
             if(ret.getIsbn().equals(isbn))
                return Response.ok().entity(ret).build();
         }
        
        return Response.status(Response.Status.NOT_FOUND).entity("Book not found with ISBN: " + isbn).build();
    }
    @Override
    public Response getBooks(SecurityContext securityContext) throws NotFoundException {
        ArrayList<Book> list = loadBooks();
        return Response.ok().entity(list).build();
    }
    @Override
    public Response getBooksByAuthor(String author, SecurityContext securityContext) throws NotFoundException {        
        ArrayList<Book> list = loadBooks();
        ArrayList<Book> ret = null;        
         for(int i=0; i<list.size(); i++)
         {
             if(list.get(i).getAuthor().equals(author))            	 
             {
            	 if (ret == null)
            		 ret = new ArrayList<Book>();
            	 ret.add( list.get(i));
             }
         }
         if (ret == null)
        	 return Response.status(Response.Status.NOT_FOUND).entity("Books not found with Author: " + author).build();
         return Response.ok().entity(ret).build();         
    }
    @Override
    public Response insertBook(Book book, SecurityContext securityContext) throws NotFoundException {
        ArrayList<Book> list = loadBooks();
        list.add(book);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Livro inserido!")).build();
    }
}
