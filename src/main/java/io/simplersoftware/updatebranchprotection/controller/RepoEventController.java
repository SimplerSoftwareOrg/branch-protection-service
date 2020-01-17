package io.simplersoftware.updatebranchprotection.controller;

import io.simplersoftware.updatebranchprotection.message.RepositoryEventMessage;
import io.simplersoftware.updatebranchprotection.message.ResponseProtectionMessage;
import io.simplersoftware.updatebranchprotection.service.BranchService;
import io.simplersoftware.updatebranchprotection.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoEventController {

    @Autowired
    private BranchService branchService;
    @Autowired
    private NotifyService notifyService;

    /*
    * Endpoint listening on the repository webhook events
    * receives all repository events and filters them based on the action
    * */
    @PostMapping("/repo/event")
    public void filterEvents(@RequestBody RepositoryEventMessage eventMessage) {

        // If the action received in the repo event is created then start the default master branch protection process
        if (eventMessage.getAction().equals("created")) {
            protectMasterBranch(eventMessage);
        }
    }

    /*
     * Default master branch protection process
     * */
    private void protectMasterBranch(RepositoryEventMessage eventMessage){

        // Extract repo name and owner values from the event message
        String repoName = eventMessage.getRepository().getName();
        String repoOwner = eventMessage.getRepository().getOwner().getLogin();

        // Call the setDefaultProtection on the master branch service
        // If successful then call the notifyBranchProtected on the mention notification service.
        // Implementation details can be found in MasterBranchServiceImpl and MentionNotifyServiceImpl classes
        ResponseProtectionMessage protection = branchService.setDefaultProtection(repoName, repoOwner);
        notifyService.notifyBranchProtected(repoName, repoOwner, protection);
    }

}
