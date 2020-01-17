package io.simplersoftware.updatebranchprotection.message;

import io.simplersoftware.updatebranchprotection.message.model.EnabledFlag;
import io.simplersoftware.updatebranchprotection.message.model.RequiredPullRequestReviews;
import io.simplersoftware.updatebranchprotection.message.model.RequiredStatusChange;
import io.simplersoftware.updatebranchprotection.message.model.Restrictions;

public class ResponseProtectionMessage {

    private String url;
    private RequiredStatusChange required_status_checks;
    private Restrictions restrictions;
    private RequiredPullRequestReviews required_pull_request_reviews;
    private EnabledFlag enforce_admins;
    private EnabledFlag allow_force_pushes;
    private EnabledFlag allow_deletions;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RequiredStatusChange getRequired_status_checks() {
        return required_status_checks;
    }

    public void setRequired_status_checks(RequiredStatusChange required_status_checks) {
        this.required_status_checks = required_status_checks;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public RequiredPullRequestReviews getRequired_pull_request_reviews() {
        return required_pull_request_reviews;
    }

    public void setRequired_pull_request_reviews(RequiredPullRequestReviews required_pull_request_reviews) {
        this.required_pull_request_reviews = required_pull_request_reviews;
    }

    public EnabledFlag isEnforce_admins() {
        return enforce_admins;
    }

    public void setEnforce_admins(EnabledFlag enforce_admins) {
        this.enforce_admins = enforce_admins;
    }

    public EnabledFlag isAllow_force_pushes() {
        return allow_force_pushes;
    }

    public void setAllow_force_pushes(EnabledFlag allow_force_pushes) {
        this.allow_force_pushes = allow_force_pushes;
    }

    public EnabledFlag isAllow_deletions() {
        return allow_deletions;
    }

    public void setAllow_deletions(EnabledFlag allow_deletions) {
        this.allow_deletions = allow_deletions;
    }

    @Override
    public String toString() {
        return "ResponseProtectionMessage{" +
                "url='" + url + '\'' +
                ", required_status_checks=" + required_status_checks +
                ", restrictions=" + restrictions +
                ", required_pull_request_reviews=" + required_pull_request_reviews +
                ", enforce_admins=" + enforce_admins.toString() +
                ", allow_force_pushes=" + allow_force_pushes.toString() +
                ", allow_deletions=" + allow_deletions.toString() +
                '}';
    }
}
