package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

//This is used to configure the api so that we cannot do "PUT","POST","DELETE", any apis when live on server
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer
{
	
	@Override
	
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		
		//disable properties for put post delete for products
		config.getExposureConfiguration()
				.forDomainType(Product.class)
				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	
		//disable properties for put post delete for productCategory
				config.getExposureConfiguration()
						.forDomainType(ProductCategory.class)
						.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
						.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

	
	}

}
