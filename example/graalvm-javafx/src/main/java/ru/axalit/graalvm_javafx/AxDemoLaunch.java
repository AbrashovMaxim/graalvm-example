package ru.axalit.graalvm_javafx;

public class AxDemoLaunch {

    public static void main(String[] args) {
        try {
            System.out.println("\n\tAXALIT DEMO LAUNCH\n\n");
            AxDemoApplication.launch(AxDemoApplication.class, args);
        } catch (Exception e) {
            System.out.println("\n\tAXALIT DEMO LAUNCH FAILED\n\n");
            e.printStackTrace();
        }
    }

}
