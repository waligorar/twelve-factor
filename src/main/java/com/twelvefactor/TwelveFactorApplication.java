package com.twelvefactor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.twelvefactor.entity.Customer;
import com.twelvefactor.repository.CustomerRepository;

@SpringBootApplication
public class TwelveFactorApplication {

//	private static final Logger log = LoggerFactory.getLogger(TwelveFactorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TwelveFactorApplication.class, args);
	}
	
//	@Bean
//	@LogExecutionTime
//	public void serve() throws InterruptedException {
//		Thread.sleep(2000);
//	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
			
//			log.info("Customer found with findAll():");
//			log.info("------------------------------");
//			List<Customer> custList = repository.findAll();
//			for (Customer customer : custList) {
//				log.info(customer.toString());
//			}
//			log.info("");
//			
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// 	log.info(bauer.toString());
//			// }
//			log.info("");
			
		};
	}

}
