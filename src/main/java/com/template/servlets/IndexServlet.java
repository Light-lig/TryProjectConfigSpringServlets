package com.template.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thymeleaf.TemplateEngine;

import com.template.entities.Book;
import com.template.services.BookService;
import com.template.util.ThymeLeafProcesor;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

	private BookService bookService;
	private ThymeLeafProcesor processor;

	@Override
	public void init() throws ServletException {
		// Inicializa el contexto de Spring
	    ServletContext servletContext = getServletContext();
	    AnnotationConfigApplicationContext context = 
	        (AnnotationConfigApplicationContext) servletContext.getAttribute("springContext");
	    this.bookService = context.getBean(BookService.class);
	    this.processor = context.getBean(ThymeLeafProcesor.class);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Object> respuesta = new HashMap<>();
		
		List<Book> libros = bookService.getBooks();

		respuesta.put("message", "Hola, bienvenido a nuestra página");
		respuesta.put("books", libros);
		
		processor.processTemplates(request, response, respuesta, getServletContext(),"index");
	}
}
