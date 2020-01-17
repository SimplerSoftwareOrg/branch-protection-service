package io.simplersoftware.updatebranchprotection.service;

import io.simplersoftware.updatebranchprotection.message.RequestProtectionMessage;
import io.simplersoftware.updatebranchprotection.message.ResponseProtectionMessage;
import io.simplersoftware.updatebranchprotection.message.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Service
public class MasterBranchServiceImpl implements BranchService {

    @Value("${GITHUB.BRANCH.PROTECTION.TOKEN}")
    private String token;

    @Override
    public ResponseProtectionMessage setDefaultProtection(String repoName, String repoOwner) {

        String url = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/branches/master/protection";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        // A custom header media type as mentioned on the API documentation for the protection endpoint (Developer Preview)
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.valueOf("application/vnd.github.luke-cage-preview+json"));
        headers.setAccept(mediaTypes);

        // Construct the default protection and wrap the body and header into http request entity
        HttpEntity<RequestProtectionMessage> requestEntity = new HttpEntity(createDefaultProtection(), headers);

        // Send http post request using the rest template
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseProtectionMessage> response = restTemplate.exchange(
                url, HttpMethod.PUT, requestEntity, ResponseProtectionMessage.class);

        return response.getBody();
    }

    /*
     * Construct the default protection message
     * strict = true | context = new-repository | min-review = 1 | enforce-admin = false |
     * dismiss-stale-reviews = false | require-owner-review = false | restriction = null | dismissalRestrictions = null
     * */
    private RequestProtectionMessage createDefaultProtection(){

        RequiredStatusChange requiredStatusChange = new RequiredStatusChange(true, new String[]{"new-repository"});
        DismissalRestrictions dismissalRestrictions = new DismissalRestrictions(new String[]{""}, new String[]{""});
        Restrictions restrictions = new Restrictions(new String[]{""}, new String[]{""}, new String[]{""});
        RequiredPullRequestReviews requiredPullRequestReviews = new RequiredPullRequestReviews(dismissalRestrictions, false, false ,1);
        RequestProtectionMessage protectionMassage = new RequestProtectionMessage(requiredStatusChange, false, requiredPullRequestReviews ,restrictions);

        return protectionMassage;
    }

}
