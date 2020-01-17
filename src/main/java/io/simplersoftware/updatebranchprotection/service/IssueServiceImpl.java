package io.simplersoftware.updatebranchprotection.service;

import io.simplersoftware.updatebranchprotection.message.RequestIssueMessage;
import io.simplersoftware.updatebranchprotection.message.RequestProtectionMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IssueServiceImpl implements IssueService {

    @Value("${GITHUB.BRANCH.PROTECTION.TOKEN}")
    private String token;

    @Override
    public void createNewIssue(String title, String body, String repoOwner, String repoName) {

        String url = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/issues";

        // Instantiate http header and add the bearer token to the header
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        // Create the request message and wrap into http request entity
        RequestIssueMessage issueMessage = new RequestIssueMessage(title, body);
        HttpEntity<RequestIssueMessage> requestEntity = new HttpEntity(issueMessage, headers);

        // Send http post request using the rest template
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }

}