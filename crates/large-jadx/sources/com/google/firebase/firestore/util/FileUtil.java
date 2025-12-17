package com.google.firebase.firestore.util;

import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* loaded from: classes2.dex */
public class FileUtil {

    private static class DefaultFileDeleter {
        public static void delete(File file) {
            try {
                Files.deleteIfExists(file.toPath());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to delete file ");
                stringBuilder.append(file);
                file = ": ";
                stringBuilder.append(file);
                stringBuilder.append(th);
                file = stringBuilder.toString();
                IOException iOException = new IOException(file);
                throw iOException;
            }
        }
    }

    private static class LegacyFileDeleter {
        public static void delete(File file) {
            boolean delete;
            if (file.delete() == null) {
                if (file.exists() != null) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to delete file ");
                stringBuilder.append(file);
                IOException iOException = new IOException(stringBuilder.toString());
                throw iOException;
            }
        }
    }
    public static void delete(File file) {
        if (Build.VERSION.SDK_INT >= 26) {
            FileUtil.DefaultFileDeleter.delete(file);
        } else {
            FileUtil.LegacyFileDeleter.delete(file);
        }
    }
}
