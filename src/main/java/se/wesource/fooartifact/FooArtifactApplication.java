package se.wesource.fooartifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import se.wesource.otherspringbootservice.service.OtherService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {FooArtifactApplication.class, OtherService.class})
public class FooArtifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooArtifactApplication.class, args);
	}
}
