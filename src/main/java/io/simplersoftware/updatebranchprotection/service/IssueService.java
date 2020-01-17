package io.simplersoftware.updatebranchprotection.service;


public interface IssueService {

    boolean createNewIssue(String title, String body, String repoOwner, String repoName);
}
