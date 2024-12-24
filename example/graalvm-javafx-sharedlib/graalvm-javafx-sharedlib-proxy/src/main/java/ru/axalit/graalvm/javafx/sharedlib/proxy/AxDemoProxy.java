package ru.axalit.graalvm.javafx.sharedlib.proxy;

public class AxDemoProxy {

    private String nameCamera;


    public AxDemoProxy(String nameCamera) {
        this.nameCamera = nameCamera;
    }


    public String getNameCamera() {
        return nameCamera;
    }
    public void setNameCamera(String nameCamera) {
        this.nameCamera = nameCamera;
    }

}
