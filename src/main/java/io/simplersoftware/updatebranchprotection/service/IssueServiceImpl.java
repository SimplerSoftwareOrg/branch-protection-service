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

    @Value("${GITHUB_PAT_UPDATE_BRANCH_PROTECTION}")
    private String token;

    @Override
    public boolean createNewIssue(String title, String body, String repoOwner, String repoName) {
        String url = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/issues";

        RequestIssueMessage issueMessage = new RequestIssueMessage(title, body);
        System.out.println(issueMessage);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<RequestProtectionMessage> requestEntity = new HttpEntity(issueMessage, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        System.out.println(response);
        return true;
    }
}
