package br.com.dansa.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.dansa.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	private final static MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	public void extendsMessageConverter(List<HttpMessageConverter<?>> convertes) {
		convertes.add(new YamlJackson2HttpMessageConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		//VIA EXTENSION .XML OR .JSON
		
		/*
		 * configurer.favorParameter(false) .ignoreAcceptHeader(false) //não vai ignorar
		 * o que vem no header .defaultContentType(MediaType.APPLICATION_JSON) //define
		 * o metiatype como padrão .mediaType("json", MediaType.APPLICATION_JSON)
		 * .mediaType("xml", MediaType.APPLICATION_XML); // aceitará xml, além do json
		 */	
		
		// VIA QUERY PARAM ?mediaType=xml OR ?mediaType=json
		
		/*
		 * configurer.favorPathExtension(false) .favorParameter(true)
		 * .parameterName("mediaType") .ignoreAcceptHeader(false)
		 * .useRegisteredExtensionsOnly(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
		 */
		
		configurer.favorPathExtension(false)
		.favorParameter(false)		
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIA_TYPE_YML);
	}

}
