package vttp.ssf.assessment.eventmanagement.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {
    
    //Task 1
    public List<Event> readFile(String fileName) throws IOException{
        List<Event> events = new ArrayList<>();

        Resource resource = new ClassPathResource(fileName);
        InputStream is = resource.getInputStream();
        JsonReader jr = Json.createReader(is);
        JsonArray ja = jr.readArray();

        for(JsonValue jsonVal: ja){
            JsonObject obj = jsonVal.asJsonObject();
            Event e = new Event();
            e.setEventId(Integer.parseInt(obj.get("eventId").toString()));
            e.setEventName(obj.getString("eventName", ""));
            e.setEventSize(Integer.parseInt(obj.get("eventSize").toString()));
            e.setEventDate(Long.parseLong(obj.get("eventDate").toString()));
            e.setParticipants(Integer.parseInt(obj.get("participants").toString()));
            // Integer eventId = Integer.parseInt(obj.get("eventId").toString());
            // String eventName = obj.getString("eventName", "");
            // Integer eventSize = Integer.parseInt(obj.get("eventSize").toString());
            // Long eventDate = Long.parseLong(obj.get("eventDate").toString());
            // Integer participants = Integer.parseInt(obj.get("participants").toString());
            // events.add(new Event(eventId, eventName, eventSize, eventDate, participants));
            events.add(e);
        }
        return events;   
    }

}
