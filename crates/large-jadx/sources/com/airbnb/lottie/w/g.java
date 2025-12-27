package com.airbnb.lottie.w;

import android.util.Pair;
import com.airbnb.lottie.y.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class g {

    private final e a;
    public g(e eVar) {
        super();
        this.a = eVar;
    }

    private static String b(String str, c cVar, boolean z) {
        String tempExtension;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lottie_cache_");
        stringBuilder.append(str.replaceAll("\\W+", ""));
        if (z) {
            tempExtension = cVar.tempExtension();
        } else {
        }
        stringBuilder.append(tempExtension);
        return stringBuilder.toString();
    }

    private File c(String str) {
        final boolean z = false;
        File file = new File(d(), g.b(str, c.JSON, z));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), g.b(str, c.ZIP, z));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File file = this.a.a();
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    Pair<c, InputStream> a(String str) {
        com.airbnb.lottie.w.c jSON2;
        try {
            final File file = c(str);
        } catch (java.io.FileNotFoundException unused) {
            return obj;
        }
        if (file == null) {
            return null;
        }
        try {
        } catch (java.io.FileNotFoundException unused) {
            return obj;
        }
        com.airbnb.lottie.w.c obj = file.getAbsolutePath().endsWith(".zip") ? c.ZIP : c.JSON;
        StringBuilder stringBuilder = new StringBuilder();
        final String str3 = "Cache hit for ";
        String str4 = " at ";
        String absolutePath2 = file.getAbsolutePath();
        str5 = str3 + str + str4 + absolutePath2;
        d.a(str3 + str + str4 + absolutePath2);
        return new Pair(jSON2, new FileInputStream(file));
    }

    void e(String str, c cVar) {
        File file = new File(d(), g.b(str, cVar, true));
        File file3 = new File(file.getAbsolutePath().replace(".temp", ""));
        StringBuilder stringBuilder = new StringBuilder();
        String str5 = "Copying temp file to real file (";
        String str6 = ")";
        str2 = str5 + file3 + str6;
        d.a(str2);
        if (file.renameTo(file3) == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str2 = "Unable to rename cache file ";
            String absolutePath2 = file.getAbsolutePath();
            String str9 = " to ";
            String absolutePath3 = file3.getAbsolutePath();
            String str10 = ".";
            str8 = str2 + absolutePath2 + str9 + absolutePath3 + str10;
            d.c(str8);
        }
    }

    File f(String str, InputStream inputStream, c cVar) {
        final File file2 = new File(d(), g.b(str, cVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
        } catch (Throwable th) {
        }
        try {
            byte[] bArr = new byte[1024];
            int bytesRead = inputStream.read(bArr);
            while (bytesRead != -1) {
                int i = 0;
                fileOutputStream.write(bArr, i, bytesRead);
                bytesRead = inputStream.read(bArr);
            }
            fileOutputStream.flush();
        } catch (Throwable th) {
        }
        try {
            fileOutputStream.close();
        } catch (Throwable th) {
        }
        inputStream.close();
        return file2;
    }
}
