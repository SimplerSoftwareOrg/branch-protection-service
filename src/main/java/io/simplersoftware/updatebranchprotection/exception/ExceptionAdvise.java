package io.simplersoftware.updatebranchprotection.exception;

import io.simplersoftware.updatebranchprotection.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvise extends ResponseEntityExceptionHandler {

    @Autowired
    private IssueService issueService;

    @Autowired
    private Environment env;

    @ExceptionHandler(value = { HttpClientErrorException.class })
    public void handle(Exception exception) {

        String title = "Exception- Failed to protect master branch";
        String body = "@"+ env.getProperty("BRANCH.PROTECTION.NOTIFICATION.RECEIVER") + "\n" + exception.getMessage();
        String repoOwner = "SimplerSoftwareOrg";
        String repoName = "issues";

        try {
            issueService.createNewIssue(title, body, repoOwner, repoName);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
