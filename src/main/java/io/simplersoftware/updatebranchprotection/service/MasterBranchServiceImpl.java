package io.simplersoftware.updatebranchprotection.service;

import io.simplersoftware.updatebranchprotection.message.RequestProtectionMessage;
import io.simplersoftware.updatebranchprotection.message.ResponseProtectionMessage;
import io.simplersoftware.updatebranchprotection.message.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.String;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class MasterBranchServiceImpl implements BranchService {

    @Autowired
    private Environment env;
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

        boolean strict = Boolean.valueOf(env.getProperty("github.branch.default.protection.statusCheck.strict"));
        boolean enforceAdmin = Boolean.valueOf(env.getProperty("github.branch.default.protection.enforceAdmin"));
        int requiredReviews = Integer.valueOf(env.getProperty("github.branch.default.protection.pullRequestReviews.count"));
        String[] contexts = env.getProperty("github.branch.default.protection.statusCheck.contexts").split(",");
        String[] dismissedUsers = env.getProperty("github.branch.default.protection.dismissalRestriction.users").split(",");
        String[] dismissedTeams = env.getProperty("github.branch.default.protection.dismissalRestriction.teams").split(",");
        String[] restrictedUsers = env.getProperty("github.branch.default.protection.Restriction.users").split(",");
        String[] restrictedTeams = env.getProperty("github.branch.default.protection.Restriction.teams").split(",");
        String[] restrictedApps = env.getProperty("github.branch.default.protection.Restriction.apps").split(",");

        RequiredStatusChange requiredStatusChange = new RequiredStatusChange(strict, contexts);
        DismissalRestrictions dismissalRestrictions = new DismissalRestrictions(dismissedUsers, dismissedTeams);
        Restrictions restrictions = new Restrictions(restrictedUsers, restrictedTeams, restrictedApps);
        RequiredPullRequestReviews requiredPullRequestReviews = new RequiredPullRequestReviews(dismissalRestrictions, false, false ,requiredReviews);
        RequestProtectionMessage protectionMassage = new RequestProtectionMessage(requiredStatusChange, enforceAdmin, requiredPullRequestReviews ,restrictions);

        return protectionMassage;
    }

}
