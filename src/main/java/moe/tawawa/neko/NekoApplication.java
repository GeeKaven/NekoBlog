package moe.tawawa.neko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NekoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NekoApplication.class, args);
	}

}
