package no.haagensoftware.postnordsample.controllers;

/**
 * Created by jhsmbp on 16/12/15.
 */
public abstract class PostNordControllerBase {
    private PostNordControllerBase controllerCallback;

    public abstract void setupUi();
    public abstract void update();

    public PostNordControllerBase getControllerCallback() {
        return controllerCallback;
    }

    public void setControllerCallback(PostNordControllerBase controllerCallback) {
        this.controllerCallback = controllerCallback;
    }
}
