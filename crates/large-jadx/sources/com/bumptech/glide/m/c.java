package com.bumptech.glide.m;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
final class c {

    static final Charset a;
    static {
        c.a = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
    }

    static void b(File file) {
        int i;
        File file2;
        boolean delete;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
        } else {
            i = 0;
            while (i < listFiles.length) {
                file2 = listFiles[i];
                if (file2.isDirectory() != null) {
                }
                i++;
                c.b(file2);
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("not a readable directory: ");
        stringBuilder2.append(file);
        IOException iOException = new IOException(stringBuilder2.toString());
        throw iOException;
    }
}
