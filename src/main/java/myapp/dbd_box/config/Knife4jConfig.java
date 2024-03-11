package myapp.dbd_box.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@EnableSwagger2
@EnableKnife4j
@Configuration
public class Knife4jConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("测试")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("myapp.dbd_box.controller"))
                .paths(PathSelectors.any())
                .build()
                .protocols(Collections.singleton("https")); // 添加这一行以支持HTTPS

        return docket;
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("DBD-BOX-api")
                .description("DBD-BOX接口文档")
                .termsOfServiceUrl("beooto.top")
                .contact("zuiyanmenglong@gmail.com")
                .version("1.0")
                .build();
    }
}

