package ru.axalit.graalvm.sharedlib.test;

public class AxDemoLaunch {

    public static void main(String[] args) {
        long isolate = AxDemoJNIController.createIsolate();

        System.out.println("ПРОВЕРКА 150 + 150 = " + AxDemoJNIController.add(isolate, 150, 150));
    }

}
