package com.spark.app;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dao.ContactRepository;
import service.UserService;

@EnableConfigurationProperties
@EnableJpaRepositories("dao")
@EntityScan("entities")
@ComponentScan(basePackages = "controller")
@SpringBootApplication
@ComponentScan(basePackages = { "service", "controller", "dao", "dto", "security" })
@EnableAutoConfiguration
@EnableWebMvc

public class ContactManagementApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	UserService userService;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// contactRepository.save(new Contact("az", "azeza", df.parse("29/01/1992"),
		// "201548", "image"));
		// contactRepository.save(new Contact("sc", "ali", df.parse("20/05/1990"),
		// "201548", "image"));
		// contactRepository.save(new Contact("cqdd", "daijobo", df.parse("11/12/1989"),
		// "201548", "image"));
		// contactRepository.save(new Contact("azed", "hello", df.parse("14/03/1992"),
		// "201548", "image"));
		// contactRepository.save(new Contact("qsdqd", "rchayd", df.parse("29/01/1992"),
		// "201548", "image"));
		// contactRepository.save(new Contact("aze", "ali", df.parse("20/05/1990"),
		// "201548", "image"));
		// contactRepository.save(new Contact("eaea", "aze", df.parse("11/12/1989"),
		// "201548", "image"));
		// contactRepository.save(new Contact("dcvv", "zzz", df.parse("14/03/1992"),
		// "201548", "image"));
		//
		// User admin = new User();
		// admin.setUsername("admin");
		// admin.setPassword("admin");
		// admin.setEmail("admin@email.com");
		// admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
		//
		// userService.signup(admin);
		//
		// User client = new User();
		// client.setUsername("client");
		// client.setPassword("client");
		// client.setEmail("client@email.com");
		// client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
		//
		// userService.signup(client);

		// contactRepository.findAll().forEach(contact -> {
		// System.out.println(contact.getFirstName() + " " + contact.getLastName());
		// });
	}
}
