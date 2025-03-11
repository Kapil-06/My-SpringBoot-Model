package com.theskyit.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.servlet.http.HttpSession;

public class SessionTracker {
	
	private static final ConcurrentHashMap<String, Set<HttpSession>> adminSessions = new ConcurrentHashMap<>();

    // Add session to tracker
    public static void addSession(String username, HttpSession session) {
        adminSessions.computeIfAbsent(username, k -> new HashSet<>()).add(session);
    }

    // Remove session from tracker
    public static void removeSession(String username, HttpSession session) {
        if (adminSessions.containsKey(username)) {
            adminSessions.get(username).remove(session);
            if (adminSessions.get(username).isEmpty()) {
                adminSessions.remove(username);
            }
        }
    }
    
    // Invalidate all sessions for a user
    public static void invalidateAllSessions(String username) {
        if (adminSessions.containsKey(username)) {
            for (HttpSession session : adminSessions.get(username)) {
                session.invalidate(); // Invalidate session
            }
            adminSessions.remove(username);
        }
    }
}
