package io.simplersoftware.updatebranchprotection.service;

/*
 * The Issue service interface for all operation performed on an issue
 * Implemented by IssueServiceImpl
 * */
public interface IssueService {

    // create a new issue with only title and body
    void createNewIssue(String title, String body, String repoOwner, String repoName);
}
