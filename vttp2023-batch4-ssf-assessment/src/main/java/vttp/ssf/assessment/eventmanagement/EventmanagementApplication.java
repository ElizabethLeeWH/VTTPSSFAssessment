package vttp.ssf.assessment.eventmanagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{
	@Autowired
	RedisRepository redisRepo;

	@Autowired
	DatabaseService databaseService;

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Event> events = databaseService.readFile("static/events.json");
		events.forEach(System.out::println);
		for(Event e: events){
			redisRepo.saveRecord(e);
		}
		// System.out.println(events);

		
		// Map<String, Event> mapList = redisRepo.getAll();
		// System.out.println(mapList);
		
		// throw new UnsupportedOperationException("Unimplemented method 'run'");
	}


}
