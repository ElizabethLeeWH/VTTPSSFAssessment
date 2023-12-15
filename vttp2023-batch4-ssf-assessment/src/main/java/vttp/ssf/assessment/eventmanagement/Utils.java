package vttp.ssf.assessment.eventmanagement;

import jakarta.servlet.http.HttpSession;
import vttp.ssf.assessment.eventmanagement.models.Event;

import java.util.List;
import java.util.LinkedList;

public class Utils {

   public static final String ATTR_EVENT = "event";

   public static final String BEAN_REDIS = "myredis";

   public static final Integer F_EVENTID = 0;
   public static final String F_EVENTNAME = "";
   public static final Integer F_EVENTSIZE = 0;
   public static final Long F_EVENTDATE = (long) 1;
   public static final Integer F_PARTICIPANTS = 0;


   public static List<Event> getCart(HttpSession sess) {
      List<Event> event = (List<Event>)sess.getAttribute(ATTR_EVENT);
      if (null == event) {
        event = new LinkedList<>();
        sess.setAttribute(ATTR_EVENT, event);
      }
      return event;
   }
   
}