package io.simplersoftware.updatebranchprotection.service;

import io.simplersoftware.updatebranchprotection.message.RequestProtectionMessage;
import io.simplersoftware.updatebranchprotection.message.ResponseProtectionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MentionNotifyServiceImpl implements NotifyService {

    @Value("${GITHUB_PAT_UPDATE_BRANCH_PROTECTION}")
    private String token;

    @Autowired
    private IssueService issueService;

    @Override
    public void notifyBranchProtected(String repoName, String repoOwner, ResponseProtectionMessage protection) {

        String issueTopic = "New Repo Created - " + repoName + " - Master Branch Successfully protected";
        String issueBody = "@simpler-software \n" + protection.toString();

        issueService.createNewIssue(issueTopic, issueBody, repoOwner, repoName);
        System.out.println(protection);
    }

}
