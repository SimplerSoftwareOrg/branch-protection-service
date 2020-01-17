package io.simplersoftware.updatebranchprotection.message.model;

public class EnabledFlag {

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "EnabledFlag{" +
                "enabled=" + enabled +
                '}';
    }
}
