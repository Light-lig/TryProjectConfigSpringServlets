package com.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.template.servlets.IndexServlet;

@ComponentScan(basePackages = "com.template")
public class AppConfig {
	@Bean
	public TemplateEngine templateEngine() {
        // Crear un resolver para Thymeleaf
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/"); // Directorio donde se encuentran los templates
        templateResolver.setSuffix(".html"); // Sufijo de los templates
        templateResolver.setTemplateMode("HTML"); // Tipo de template

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
	
	@Bean
	public IndexServlet indexServlet() {
		return new IndexServlet();
	}
}
