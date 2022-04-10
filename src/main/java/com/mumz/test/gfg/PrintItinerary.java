package com.mumz.test.gfg;

import java.util.HashMap;
import java.util.Map;

public class PrintItinerary {

    public static String printItinerary(
            Map<String, String> ticketMap
    ) {
        if (ticketMap == null || ticketMap.isEmpty()) return "None";
        final StringBuilder itinerary = new StringBuilder();
        String startPoint = "";
        for (String start : ticketMap.keySet()) {
            String destination = ticketMap.get(start);
            while(ticketMap.containsKey(destination)){

            }
            for (Map.Entry<String, String> entry : ticketMap.entrySet()) {

            }
        }
        return itinerary.toString();
    }

    public static void main(String[] args) {
        final Map<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Banglore");
        tickets.put("Bombay", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        System.out.println(printItinerary(tickets));
    }
}
