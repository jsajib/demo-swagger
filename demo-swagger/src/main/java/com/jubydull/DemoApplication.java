package com.jubydull;

import com.jubydull.web.enums.ResponseCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@EnableSwagger2
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.consumes(getContentType())
				.produces(getContentType())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getGlobalResponseMessages())
				.globalResponseMessage(RequestMethod.POST, getGlobalResponseMessages())
				.globalResponseMessage(RequestMethod.DELETE, getGlobalResponseMessages())
				.globalResponseMessage(RequestMethod.PUT, getGlobalResponseMessages())
				.globalResponseMessage(RequestMethod.PATCH, getGlobalResponseMessages())
				.globalResponseMessage(RequestMethod.OPTIONS, getGlobalResponseMessages());
	}

	private Set<String> getContentType() {
		return new HashSet<>(Arrays.asList("application/json"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("REST API")
				.description("REST API Documentation Test")
				.version("1.0")
				.contact(new Contact("Md", "Jubydull", "Akber"))
				.license("All right reserved to Me")
				.build();
	}

	private List<ResponseMessage> getGlobalResponseMessages() {
		return new ArrayList<>(Arrays.asList(new ResponseMessageBuilder().code(ResponseCode.OPERATION_SUCCESSFUL.getCode()).message(ResponseCode.OPERATION_SUCCESSFUL.toString()).responseModel(new ModelRef(ResponseCode.OPERATION_SUCCESSFUL.toString())).build(),
				new ResponseMessageBuilder().code(ResponseCode.RECORD_NOT_FOUND.getCode()).message(ResponseCode.RECORD_NOT_FOUND.toString()).responseModel(new ModelRef(ResponseCode.RECORD_NOT_FOUND.toString())).build(),
				new ResponseMessageBuilder().code(ResponseCode.AUTHENTICATION_FAILED.getCode()).message(ResponseCode.AUTHENTICATION_FAILED.toString()).responseModel(new ModelRef(ResponseCode.AUTHENTICATION_FAILED.toString())).build(),
				new ResponseMessageBuilder().code(ResponseCode.INVALID_ARGUMENT.getCode()).message(ResponseCode.INVALID_ARGUMENT.toString()).responseModel(new ModelRef(ResponseCode.INVALID_ARGUMENT.toString())).build(),
				new ResponseMessageBuilder().code(ResponseCode.DATABASE_ERROR.getCode()).message(ResponseCode.DATABASE_ERROR.toString()).responseModel(new ModelRef(ResponseCode.DATABASE_ERROR.toString())).build(),
				new ResponseMessageBuilder().code(ResponseCode.RUNTIME_ERROR.getCode()).message(ResponseCode.RUNTIME_ERROR.toString()).responseModel(new ModelRef(ResponseCode.RUNTIME_ERROR.toString())).build(),
				new ResponseMessageBuilder().code(ResponseCode.REMOTE_ERROR.getCode()).message(ResponseCode.REMOTE_ERROR.toString()).responseModel(new ModelRef(ResponseCode.REMOTE_ERROR.toString())).build(),
				new ResponseMessageBuilder().code(ResponseCode.INTERNAL_CONNECTION_ERROR.getCode()).message(ResponseCode.INTERNAL_CONNECTION_ERROR.toString()).responseModel(new ModelRef(ResponseCode.INTERNAL_CONNECTION_ERROR.toString())).build()
		));
	}
}
