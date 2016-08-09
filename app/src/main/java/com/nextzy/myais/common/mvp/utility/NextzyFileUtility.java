package com.nextzy.myais.common.mvp.utility;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Akexorcist on 8/9/16 AD.
 */
public class NextzyFileUtility {
    private static NextzyFileUtility util;

    public static NextzyFileUtility getInstance() {
        if (util == null) {
            util = new NextzyFileUtility();
        }
        return util;
    }

    public void writeToSD(String message, String filename) {
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + filename + ".txt");
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fileOutputStream);
            myOutWriter.append(message);
            myOutWriter.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean copyFileToStorage(String fromPath, String toPath) {
        try {
            int byteRead;
            File oldFile = new File(fromPath);
            if (oldFile.exists()) {
                InputStream inputStream = new FileInputStream(fromPath);
                FileOutputStream fileOutputStream = new FileOutputStream(toPath);
                byte[] buffer = new byte[1444];
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteRead);
                }
                inputStream.close();
                fileOutputStream.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
