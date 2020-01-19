package io.simplersoftware.updatebranchprotection.message.model;

public class RequiredPullRequestReviews {

    private DismissalRestrictions dismissal_restrictions;
    private boolean dismiss_stale_reviews;
    private boolean require_code_owner_reviews;
    private int required_approving_review_count;

    public RequiredPullRequestReviews(DismissalRestrictions dismissal_restrictions, boolean dismiss_stale_reviews, boolean require_code_owner_reviews, int required_approving_review_count) {
        this.dismissal_restrictions = dismissal_restrictions;
        this.dismiss_stale_reviews = dismiss_stale_reviews;
        this.require_code_owner_reviews = require_code_owner_reviews;
        this.required_approving_review_count = required_approving_review_count;
    }

    public RequiredPullRequestReviews() {
    }

    public DismissalRestrictions getDismissal_restrictions() {
        return dismissal_restrictions;
    }

    public void setDismissal_restrictions(DismissalRestrictions dismissal_restrictions) {
        this.dismissal_restrictions = dismissal_restrictions;
    }

    public boolean isDismiss_stale_reviews() {
        return dismiss_stale_reviews;
    }

    public void setDismiss_stale_reviews(boolean dismiss_stale_reviews) {
        this.dismiss_stale_reviews = dismiss_stale_reviews;
    }

    public boolean isRequire_code_owner_reviews() {
        return require_code_owner_reviews;
    }

    public void setRequire_code_owner_reviews(boolean require_code_owner_reviews) {
        this.require_code_owner_reviews = require_code_owner_reviews;
    }

    public int getRequired_approving_review_count() {
        return required_approving_review_count;
    }

    public void setRequired_approving_review_count(int required_approving_review_count) {
        this.required_approving_review_count = required_approving_review_count;
    }

    @Override
    public String toString() {
        return "RequiredPullRequestReviews{" + '\'' +
                "dismissal_restrictions=" + dismissal_restrictions + '\'' +
                ", dismiss_stale_reviews=" + dismiss_stale_reviews + '\'' +
                ", require_code_owner_reviews=" + require_code_owner_reviews + '\'' +
                ", required_approving_review_count=" + required_approving_review_count + '\'' +
                '}';
    }
}
