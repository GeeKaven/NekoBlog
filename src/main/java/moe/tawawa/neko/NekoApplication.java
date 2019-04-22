package moe.tawawa.neko;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "moe.tawawa.neko.repository")
public class NekoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NekoApplication.class, args);
	}

	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		return objectMapper;
	}
}
