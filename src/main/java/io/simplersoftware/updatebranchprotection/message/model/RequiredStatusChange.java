package io.simplersoftware.updatebranchprotection.message.model;

import java.util.Arrays;

public class RequiredStatusChange {

    private boolean strict;
    private String[] contexts;

    public RequiredStatusChange(boolean strict, String[] contexts) {
        this.strict = strict;
        this.contexts = contexts;
    }

    public RequiredStatusChange() {
    }

    public boolean isStrict() {
        return strict;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    public String[] getContexts() {
        return contexts;
    }

    public void setContexts(String[] contexts) {
        this.contexts = contexts;
    }

    @Override
    public String toString() {
        return "RequiredStatusChange{" +
                "strict=" + strict +
                ", contexts=" + Arrays.toString(contexts) +
                '}';
    }
}
