package aspire.tech.web.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@ComponentScan({"aspire.tech.web.test.controller",
//	"aspire.tecg.web.test.entites",
//	"aspire.tech.web.security",
//	"aspire.tech.web.test.service",
//	"aspire.tech.web.test.repositories"})
@ComponentScan("aspire.tech.web")
@EnableJpaAuditing
public class MiniRedditApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniRedditApplication.class, args);
	}

}

