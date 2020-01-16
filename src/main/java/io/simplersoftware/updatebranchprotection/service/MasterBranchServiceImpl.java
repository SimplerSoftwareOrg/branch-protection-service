package io.simplersoftware.updatebranchprotection.service;


import io.simplersoftware.updatebranchprotection.message.RequestProtectionMessage;
import io.simplersoftware.updatebranchprotection.message.model.DismissalRestrictions;
import io.simplersoftware.updatebranchprotection.message.model.RequiredPullRequestReviews;
import io.simplersoftware.updatebranchprotection.message.model.RequiredStatusChange;
import io.simplersoftware.updatebranchprotection.message.model.Restrictions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;


@Service
public class MasterBranchServiceImpl implements BranchService {

    @Value("${GITHUB_PAT_UPDATE_BRANCH_PROTECTION}")
    private String token;

    @Override
    public boolean updateBranchProtection(String repoName, String repoOwner) {

        String url = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/branches/master/protection";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.valueOf("application/vnd.github.luke-cage-preview+json"));
        headers.setAccept(mediaTypes);

        HttpEntity<RequestProtectionMessage> requestEntity = new HttpEntity(createProtection(), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.PUT, requestEntity, String.class);

        return (response.getStatusCodeValue()==200)? true : false;
    }

    private RequestProtectionMessage createProtection(){

        RequiredStatusChange requiredStatusChange = new RequiredStatusChange(true, new String[]{"new-repository"});
        DismissalRestrictions dismissalRestrictions = new DismissalRestrictions(new String[]{"simpler-software"}, new String[]{""});
        Restrictions restrictions = new Restrictions(new String[]{""}, new String[]{""}, new String[]{""});
        RequiredPullRequestReviews requiredPullRequestReviews = new RequiredPullRequestReviews(dismissalRestrictions, false, false ,1);
        RequestProtectionMessage request = new RequestProtectionMessage(requiredStatusChange, false, requiredPullRequestReviews ,restrictions);

        return request;
    }

}
