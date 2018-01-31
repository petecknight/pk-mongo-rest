package net.knightech.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private CustomerRepository repository;


    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {


            repository.deleteAll();

            // save a couple of customers
            repository.save(new Customer("Alice", "Smith"));
            repository.save(new Customer("Bob", "Smith"));

            // fetch all customers
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (Customer customer : repository.findAll()) {
                System.out.println(customer);
            }
            System.out.println();

            // fetch an individual customer
            System.out.println("Customer found with findByFirstName('Alice'):");
            System.out.println("--------------------------------");
            System.out.println(repository.findByFirstName("Alice"));

            System.out.println("Customers found with findByLastName('Smith'):");
            System.out.println("--------------------------------");
            for (Customer customer : repository.findByLastName("Smith")) {
                System.out.println(customer);
            }



           /* MongoClientURI uri = new MongoClientURI(
							"mongodb://petecknight:adm1n@cluster0-shard-00-00-ukfqz.mongodb.net:27017,cluster0-shard-00-01-ukfqz.mongodb.net:27017,cluster0-shard-00-02-ukfqz.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");

			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase("test");
*/
		};
	}
}
