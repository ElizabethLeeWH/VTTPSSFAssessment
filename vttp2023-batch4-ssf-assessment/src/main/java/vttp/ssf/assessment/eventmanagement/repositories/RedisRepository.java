package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Resource;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Repository
public class RedisRepository {
	
	@Autowired
	@Resource(name ="createRedisConnection")
	private RedisTemplate<String, Object> template;

	@Autowired
	DatabaseService databaseService;

	private String hashRef = "events";
	// private final ObjectMapper objMap = new ObjectMapper();
	// private List<Event> events;

	// public RedisRepository() throws ParseException {

    //     if (events == null) {
    //         events = new ArrayList<Event>();
    //     }

    //     DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    //     Date dt = df.parse(Long.toString(event.getEventDate()));
	// 	events.add(databaseService.readFile(fileName));
    // }
	
	private HashOperations<String, Integer, Event> hOps;
	//Task 2
	public void saveRecord(Event event){
		hOps = template.opsForHash();
		hOps.put(hashRef, event.getEventId(), event);
	}


	// Task 3
	public Integer getNumberOfEvents() {
		Integer numberOfEvents = Integer.parseInt(hOps.size(hashRef).toString());
		return numberOfEvents;
	}

	// Task 4
	public Event getEvent(Integer index) {
		Event event = hOps.get(hashRef, index);
		return event;
	}

	// public List<Event> listAll() {
	// 	return databaseService.readFile("static/events.json").get(1);
	// }
}
