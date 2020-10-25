package tw.edu.nccu.recommendation.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * Controller的類別位置
	 */
	protected static final String CTL_PACKAGE = "tw.edu.nccu.recommendation.ctl";
	
	/** 
	* Swagger容器配置設定
	* @return Docket
	*/
	@Bean
	public Docket createQueryRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName("Query API")
				.select()
				.apis(RequestHandlerSelectors.basePackage(CTL_PACKAGE))
				.paths(PathSelectors.any())
				.build();
	}

	/** 
	* Swagger頁面上的說明 
	* @return ApiInfo
	*/
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("產品推薦微服務  RESTful APIs")
				.description("產品推薦 微服務 RESTful APIs ....... ")
				.version("1.0")
				.build();
	}
}
