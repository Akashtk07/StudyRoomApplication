package com.VigyanshalaMeetingpoint;

import com.VigyanshalaMeetingpoint.Entity.User;
import com.VigyanshalaMeetingpoint.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VigyanshalaMeetingPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigyanshalaMeetingPointApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	){
		return args ->{
			service.register((User.builder()
					.username("ak")
					.email("ak@gmail.com")
					.password("pass")
					.build()));

			service.register(User.builder()
							.username("Akash")
							.email("akash123@gmail.com")
							.password("pass")
					.build());

			service.register(User.builder()
					.username("Abhijeet")
					.email("Abhi1000@gmail.com")
					.password("abhi")
					.build());

			service.register(User.builder()
					.username("Unmesh")
					.email("Unmesh1000@gmail.com")
					.password("unmesh")
					.build());
			
		};



	}
}
