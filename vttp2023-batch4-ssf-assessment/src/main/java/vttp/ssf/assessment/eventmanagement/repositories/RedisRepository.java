package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.Resource;
import vttp.ssf.assessment.eventmanagement.Utils;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Repository
public class RedisRepository {
	
	@Autowired @Qualifier(Utils.BEAN_REDIS)
	private RedisTemplate<String, String> template;

	// @Autowired
	// DatabaseService databaseService;

	// String fileName = "static/events.json";
	// private String hashRef = "events";
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
	
	// @Resource(name = "eventBean")
	// private HashOperations<String, String, Event> hOps;

	//Task 2
	public void saveRecord(String key, List<Event> e){
		// try{
		// 	String eventJson = objMap.writeValueAsString(e);
		// 	hOps.put(hashRef, e.getEventName(), eventJson);
		// 	System.out.print(hOps);
		// } catch (JsonProcessingException err){
		// 	System.err.println();
		// }
		ListOperations<String, String> list = template.opsForList();
		e.stream()
			.forEach(e1 -> {
				String rec = "%d,%s,%d,%d,%d".formatted(e1.getEventId(), e1.getEventName(), e1.getEventSize(), e1.getEventDate(), e1.getParticipants());
				list.leftPush(key, rec);
			});
	}

	// public List<Event> getEvent(String name) {
	// 	ListOperations<String, String> list = template.opsForList();
	// 	Long size = list.size(name);
	// 	List<Item> cart = new LinkedList<>();
	// 	for (String i: list.range(name, 0, size)) {
	// 		String[] terms = i.split(",");
	// 		Item item = new Item();
	// 		item.setName(terms[Utils.F_NAME]);
	// 		item.setQuantity(
	// 			Integer.parseInt(terms[Utils.F_QUANTITY]));
	// 		cart.add(item);
	// 	}
	// 	return cart;
	// }
	// public Map<String, Event> getAll() {
	// 	return hOps.entries(hashRef);
	// }

	// //Task 3
	// public Integer getNumberOfEvents() {
	// 	Integer numberOfEvents = Integer.parseInt(hOps.size(hashRef).toString());
	// 	return numberOfEvents;
	// }

	// // Task 4
	// public Event getEvent(Integer index) {
	// 	Event event = hOps.get(hashRef, index);
	// 	return event;
	// }
}
