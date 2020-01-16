package io.simplersoftware.updatebranchprotection.service;

import io.simplersoftware.updatebranchprotection.message.RequestProtectionMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentionNotificationServiceImpl implements NotificationService {

    @Value("${GITHUB_PAT_UPDATE_BRANCH_PROTECTION}")
    private String token;

    @Override
    public void notifyBranchProtection(String repoName, String repoOwner) {

        String url = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/issues";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.valueOf("application/vnd.github.luke-cage-preview+json"));
        headers.setAccept(mediaTypes);

        HttpEntity<RequestProtectionMessage> requestEntity = new HttpEntity("", headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, String.class);

        System.out.println(response);
    }

}
