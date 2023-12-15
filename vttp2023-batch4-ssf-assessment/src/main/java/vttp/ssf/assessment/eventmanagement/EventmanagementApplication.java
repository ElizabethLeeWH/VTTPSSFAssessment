package vttp.ssf.assessment.eventmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{
	// @Autowired
	// RedisRepository redisRepo;

	@Autowired
	DatabaseService databaseService;

	@Autowired @Qualifier(Utils.BEAN_REDIS)
	private RedisTemplate<String, String> template;

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// databaseService.readFile("static/events.json");
		// databaseService.readFile("static/events.json").forEach(System.out::println);
		List<Event> events = databaseService.readFile("static/events.json");
		events.forEach(System.out::println);
		System.out.printf(">>> redistemplate: %s\n", template);
		HashOperations<String, String, String> opsHash = template.opsForHash();
		opsHash.put("c001", "name", "fred");
		// for (Event e: events){
		// 	redisRepo.saveRecord("events", e);
		// }
		
		// Map<String, Event> mapList = redisRepo.getAll();
		// System.out.println(mapList);
		
		// throw new UnsupportedOperationException("Unimplemented method 'run'");
	}
	
	//Task 1

}
