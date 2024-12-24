package ru.axalit.graalvm.sharedlib.lib;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class AxDemoControllerJNI {

    static {
        try {
            // Путь к вашей DLL
            String libName = "app-name.dll";

            // Копируем DLL из ресурсов во временную директорию
            InputStream in = AxDemoControllerJNI.class.getResourceAsStream("/" + libName);
            Path tempFile = Files.createTempFile(libName, null);
            tempFile.toFile().deleteOnExit();  // Удаляем файл при завершении программы

            try (FileOutputStream out = new FileOutputStream(tempFile.toFile())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            // Загружаем библиотеку
            System.load(tempFile.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static native long createIsolate(); // ОБЯЗАТЕЛЬНО
    public static native int add(long isolateThread, int a, int b);

}
