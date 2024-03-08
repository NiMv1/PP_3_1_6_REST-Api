package ru.NiMv.Service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.NiMv.model.User;

public class ApiService {
    private String sessionId;
    private final String baseUrl = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate = new RestTemplate();

    public void getSessionId() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class);
        sessionId = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
    }

    public String saveUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.COOKIE, sessionId);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.POST, request, String.class);
        return response.getBody();
    }

    public String updateUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.COOKIE, sessionId);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.PUT, request, String.class);
        return response.getBody();
    }

    public String deleteUser(Long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.COOKIE, sessionId);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/" + userId, HttpMethod.DELETE, request, String.class);
        return response.getBody();
    }
}
