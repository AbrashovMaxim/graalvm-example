package ru.axalit.graalvm.javafx.sharedlib.display;

public class AxDemoLaunch {

    public static void main(String[] args) {
        try {
            System.out.println("\n\tAXALIT [GRAALVM + JAVAFX] - DEMO LAUNCH\n\n");
            AxDemoApplication.launch(AxDemoApplication.class, args);
        } catch (Exception e) {
            System.out.println("\n\tAXALIT [GRAALVM + JAVAFX] - DEMO LAUNCH FAILED\n\n");
            e.printStackTrace();
        }
    }

}
