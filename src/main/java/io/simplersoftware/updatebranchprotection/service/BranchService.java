package io.simplersoftware.updatebranchprotection.service;

import io.simplersoftware.updatebranchprotection.message.ResponseProtectionMessage;

/*
 * The branch service interface for all operation performed on a branch
 * Implemented by MasterBranchServiceImpl
 * */
public interface BranchService {

    // set the branch default protection, returns the protection that was applied on the branch
    ResponseProtectionMessage setDefaultProtection(String repoName, String repoOwner );
}
