package py.edu.ucsa.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"py.edu.ucsa.rest.api.web.controllers",
										  "py.edu.ucsa.rest.api.core.services"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
