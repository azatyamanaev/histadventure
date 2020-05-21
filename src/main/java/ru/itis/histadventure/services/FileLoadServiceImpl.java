package ru.itis.histadventure.services;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Random;

@Component
public class FileLoadServiceImpl implements FileLoadService {
    private static String path = File.separator + "home" + File.separator + "monitor" + File.separator + "Рабочий стол" + File.separator + "yamanaev11-802(workdr)"
            + File.separator + "JavaLab" + File.separator + "wp" + File.separator + "web" + File.separator + "WEB-INF" + File.separator + "storage";
    private static String pathTo = File.separator + "home" + File.separator + "monitor" + File.separator + "Рабочий стол" + File.separator + "yamanaev11-802(workdr)"
            + File.separator + "JavaLab" + File.separator + "wp" + File.separator + "web" + File.separator + "WEB-INF" + File.separator + "images";

    @Override
    public void uploadFile(MultipartFile multipartFile) {
        try {
            String name;
            byte[] bytes = multipartFile.getBytes();
            name = "file" + new Random().nextInt(1000000);
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void downloadFile(String filename) {
        String name = filename.substring(10);
        File file1 = new File(path + File.separator + name);
        File file2 = new File(pathTo + File.separator + name);
        try {
            FileInputStream fileInputStream = new FileInputStream(file1);
            byte[] bytes = fileInputStream.readAllBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file2));
            stream.write(bytes);
            stream.flush();
            stream.close();
            fileInputStream.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
