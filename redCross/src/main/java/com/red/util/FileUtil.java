package com.red.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtil {

    public static byte[] filtToByteArray(String path) {
        File file = new File(path);
        byte[] bytes = null;
        FileInputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            bytes = new byte[1024];
            inputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len = 0;
            while ((len = inputStream.read(bytes, 0, bytes.length)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            byte[] resultBytes = byteArrayOutputStream.toByteArray();

            return resultBytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
