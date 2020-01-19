package io.simplersoftware.updatebranchprotection.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.simplersoftware.updatebranchprotection.message.ResponseProtectionMessage;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MentionNotifyServiceImpl implements NotifyService {

    @Value("${GITHUB.BRANCH.PROTECTION.TOKEN}")
    private String token;
    @Value("${BRANCH.PROTECTION.NOTIFICATION.RECEIVER}")
    private String notificationReceiver;
    @Autowired
    private IssueService issueService;

    // Notify the organisation's admin when a branch is protected through a mention in an issue within the repo
    @Override
    public void notifyBranchProtected(String repoName, String repoOwner, ResponseProtectionMessage protection) {

        String issueTitle = "New Repo Created - " + repoName + " - Master Branch Successfully protected";
        String issueBody = "@" + notificationReceiver + "\n" + protection.toString();
        
        issueService.createNewIssue(issueTitle, issueBody, repoOwner, repoName);
    }
}
