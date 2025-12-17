package com.airbnb.lottie.w;

import android.util.Pair;
import com.airbnb.lottie.y.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class g {

    private final com.airbnb.lottie.w.e a;
    public g(com.airbnb.lottie.w.e e) {
        super();
        this.a = e;
    }

    private static String b(String string, com.airbnb.lottie.w.c c2, boolean z3) {
        String obj3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lottie_cache_");
        stringBuilder.append(string.replaceAll("\\W+", ""));
        if (z3) {
            obj3 = c2.tempExtension();
        } else {
            obj3 = c2.extension;
        }
        stringBuilder.append(obj3);
        return stringBuilder.toString();
    }

    private File c(String string) {
        final int i = 0;
        File file = new File(d(), g.b(string, c.JSON, i));
        if (file.exists() != null) {
            return file;
        }
        File file2 = new File(d(), g.b(string, c.ZIP, i));
        if (file2.exists() != null) {
            return file2;
        }
        return null;
    }

    private File d() {
        File file = this.a.a();
        if (file.isFile() != null) {
            file.delete();
        }
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    Pair<com.airbnb.lottie.w.c, InputStream> a(String string) {
        com.airbnb.lottie.w.c jSON;
        final File file = c(string);
        if (file == null) {
            try {
                return 0;
                FileInputStream fileInputStream = new FileInputStream(file);
                if (file.getAbsolutePath().endsWith(".zip") != null) {
                } else {
                }
                jSON = c.ZIP;
                jSON = c.JSON;
            } catch (java.io.FileNotFoundException fileNotFound) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cache hit for ");
            stringBuilder.append(string);
            stringBuilder.append(" at ");
            stringBuilder.append(file.getAbsolutePath());
            d.a(stringBuilder.toString());
            Pair obj6 = new Pair(jSON, fileInputStream);
            return obj6;
        }
    }

    void e(String string, com.airbnb.lottie.w.c c2) {
        String string2;
        boolean obj4;
        Object obj5;
        obj5 = new File(d(), g.b(string, c2, true));
        File file2 = new File(obj5.getAbsolutePath().replace(".temp", ""));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Copying temp file to real file (");
        stringBuilder.append(file2);
        stringBuilder.append(")");
        d.a(stringBuilder.toString());
        if (obj5.renameTo(file2) == null) {
            obj4 = new StringBuilder();
            obj4.append("Unable to rename cache file ");
            obj4.append(obj5.getAbsolutePath());
            obj4.append(" to ");
            obj4.append(file2.getAbsolutePath());
            obj4.append(".");
            d.c(obj4.toString());
        }
    }

    File f(String string, InputStream inputStream2, com.airbnb.lottie.w.c c3) {
        int read;
        int i;
        File obj6 = new File(d(), g.b(string, c3, true));
        FileOutputStream obj4 = new FileOutputStream(obj6);
        byte[] bArr = new byte[1024];
        read = inputStream2.read(bArr);
        while (read != -1) {
            obj4.write(bArr, 0, read);
            read = inputStream2.read(bArr);
        }
        obj4.flush();
        obj4.close();
        inputStream2.close();
        return obj6;
    }
}
