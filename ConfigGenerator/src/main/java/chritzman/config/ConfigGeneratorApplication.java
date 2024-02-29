package chritzman.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigGeneratorApplication.class, args);
		System.out.println("Hello World");
	}

}
