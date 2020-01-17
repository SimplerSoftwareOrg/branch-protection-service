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
public class BranchController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private NotifyService notifyService;

    @PostMapping("/repo/event")
    public void protectMasterBranch(@RequestBody RepositoryEventMessage event) {

        if (event.getAction().equals("created")) {

            String repoName = event.getRepository().getName();
            String repoOwner = event.getRepository().getOwner().getLogin();

            ResponseProtectionMessage protection = branchService.setDefaultProtection(repoName, repoOwner);

            notifyService.notifyBranchProtected(repoName, repoOwner, protection);

        }

    }
}
