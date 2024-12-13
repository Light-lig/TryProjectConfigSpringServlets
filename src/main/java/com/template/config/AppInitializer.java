package com.template.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebListener
public class AppInitializer implements ServletContextListener{


	 @Override
	    public void contextInitialized(ServletContextEvent sce) {
	        // Crear el ApplicationContext de Spring
	        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	        // Almacenar el contexto en el ServletContext
	        ServletContext servletContext = sce.getServletContext();
	        servletContext.setAttribute("springContext", context);
	    }

	    @Override
	    public void contextDestroyed(ServletContextEvent sce) {
	        // Cerrar el contexto de Spring
	        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext)
	                sce.getServletContext().getAttribute("springContext");
	        context.close();
	    }
}
