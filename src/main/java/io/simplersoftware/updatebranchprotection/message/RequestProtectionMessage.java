package io.simplersoftware.updatebranchprotection.message;

import io.simplersoftware.updatebranchprotection.message.model.RequiredPullRequestReviews;
import io.simplersoftware.updatebranchprotection.message.model.RequiredStatusChange;
import io.simplersoftware.updatebranchprotection.message.model.Restrictions;

public class RequestProtectionMessage {

    private RequiredStatusChange required_status_checks;
    private boolean enforce_admins;
    private RequiredPullRequestReviews required_pull_request_reviews;
    private Restrictions restrictions;

    public RequestProtectionMessage(RequiredStatusChange required_status_checks, boolean enforce_admins, RequiredPullRequestReviews required_pull_request_reviews, Restrictions restrictions) {
        this.required_status_checks = required_status_checks;
        this.enforce_admins = enforce_admins;
        this.required_pull_request_reviews = required_pull_request_reviews;
        this.restrictions = restrictions;
    }

    public RequiredStatusChange getRequired_status_checks() {
        return required_status_checks;
    }

    public void setRequired_status_checks(RequiredStatusChange required_status_checks) {
        this.required_status_checks = required_status_checks;
    }

    public boolean isEnforce_admins() {
        return enforce_admins;
    }

    public void setEnforce_admins(boolean enforce_admins) {
        this.enforce_admins = enforce_admins;
    }

    public RequiredPullRequestReviews getRequired_pull_request_reviews() {
        return required_pull_request_reviews;
    }

    public void setRequired_pull_request_reviews(RequiredPullRequestReviews required_pull_request_reviews) {
        this.required_pull_request_reviews = required_pull_request_reviews;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public String toString() {
        return "RequestProtectionMessage{" +
                "required_status_checks=" + required_status_checks +
                ", enforce_admins=" + enforce_admins +
                ", required_pull_request_reviews=" + required_pull_request_reviews +
                ", restrictions=" + restrictions +
                '}';
    }
}