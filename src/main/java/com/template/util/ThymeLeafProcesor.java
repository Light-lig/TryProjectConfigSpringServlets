package com.template.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.template.entities.Book;
import com.template.services.BookService;

@Component
public class ThymeLeafProcesor {


	private TemplateEngine templateEngine;
	
	public ThymeLeafProcesor(TemplateEngine templateEngine,
			BookService bookService
			) {
		this.templateEngine = templateEngine;
	}
	
	public void processTemplates(HttpServletRequest request, 
							HttpServletResponse response, 
							Map<String, Object> variables, 
							ServletContext servletContext,
							String view
			) throws IOException {
		// Crea un contexto para Thymeleaf
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariables(variables);
		// Procesa el template y lo pasa al response
		response.setContentType("text/html");
		templateEngine.process(view, context, response.getWriter());
	}
	
}
