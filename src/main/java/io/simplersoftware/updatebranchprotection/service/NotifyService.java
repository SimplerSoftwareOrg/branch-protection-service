package io.simplersoftware.updatebranchprotection.service;

import io.simplersoftware.updatebranchprotection.message.ResponseProtectionMessage;

public interface NotifyService {

    public void notifyBranchProtected(String repoName, String repoOwner, ResponseProtectionMessage protection);

}
