package io.simplersoftware.updatebranchprotection.controller;

import io.simplersoftware.updatebranchprotection.message.RepositoryEventMessage;
import io.simplersoftware.updatebranchprotection.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/repository")
    public void updateBranchProtection(@RequestBody RepositoryEventMessage event) {

        System.out.println(event);

        if (event.getAction().equals("created")) {
            String repoName = event.getRepository().getName();
            String repoOwner = event.getRepository().getOwner().getLogin();
            System.out.println(branchService.updateBranchProtection(repoName, repoOwner ));
        }

    }
}
