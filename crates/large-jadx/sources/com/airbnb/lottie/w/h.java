package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import com.airbnb.lottie.y.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class h {

    private final com.airbnb.lottie.w.g a;
    private final com.airbnb.lottie.w.f b;
    public h(com.airbnb.lottie.w.g g, com.airbnb.lottie.w.f f2) {
        super();
        this.a = g;
        this.b = f2;
    }

    private d a(String string, String string2) {
        Object zipInputStream;
        l obj4;
        final int i = 0;
        if (string2 == null) {
            return i;
        }
        android.util.Pair obj5 = this.a.a(string);
        if (obj5 == null) {
            return i;
        }
        obj5 = obj5.second;
        if ((c)obj5.first == c.ZIP) {
            zipInputStream = new ZipInputStream((InputStream)obj5);
            obj4 = e.s(zipInputStream, string);
        } else {
            obj4 = e.i(obj5, string);
        }
        if (obj4.b() != null) {
            return (d)obj4.b();
        }
        return i;
    }

    private l<d> b(String string, String string2) {
        int i;
        String obj6;
        final String str = "LottieFetchResult close failed ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fetching ");
        stringBuilder.append(string);
        d.a(stringBuilder.toString());
        int i2 = 0;
        com.airbnb.lottie.w.d dVar = this.b.a(string);
        if (dVar.isSuccessful()) {
            l obj5 = d(string, dVar.T0(), dVar.D0(), string2);
            obj6 = new StringBuilder();
            obj6.append("Completed fetch from network. Success: ");
            i = obj5.b() != null ? 1 : 0;
            obj6.append(i);
            d.a(obj6.toString());
            if (dVar != null) {
                dVar.close();
            }
            return obj5;
        }
        obj6 = new IllegalArgumentException(dVar.l());
        obj5 = new l(obj6);
        if (dVar != null) {
            dVar.close();
        }
        return obj5;
    }

    private l<d> d(String string, InputStream inputStream2, String string3, String string4) {
        String str;
        l obj3;
        String obj4;
        Object obj5;
        if (string3 == null) {
            obj4 = "application/json";
        }
        if (!obj4.contains("application/zip")) {
            if (string.split("\\?")[0].endsWith(".lottie")) {
                d.a("Handling zip response.");
                obj4 = c.ZIP;
                obj3 = f(string, inputStream2, string4);
            } else {
                d.a("Received json response.");
                obj4 = c.JSON;
                obj3 = e(string, inputStream2, string4);
            }
        } else {
        }
        if (string4 != null && obj3.b() != null) {
            if (obj3.b() != null) {
                this.a.e(string, obj4);
            }
        }
        return obj3;
    }

    private l<d> e(String string, InputStream inputStream2, String string3) {
        if (string3 == null) {
            return e.i(inputStream2, 0);
        }
        File file = new File(this.a.f(string, inputStream2, c.JSON).getAbsolutePath());
        FileInputStream obj4 = new FileInputStream(file);
        return e.i(obj4, string);
    }

    private l<d> f(String string, InputStream inputStream2, String string3) {
        if (string3 == null) {
            ZipInputStream obj2 = new ZipInputStream(inputStream2);
            return e.s(obj2, 0);
        }
        FileInputStream fileInputStream = new FileInputStream(this.a.f(string, inputStream2, c.ZIP));
        ZipInputStream obj4 = new ZipInputStream(fileInputStream);
        return e.s(obj4, string);
    }

    public l<d> c(String string, String string2) {
        d dVar = a(string, string2);
        if (dVar != null) {
            l obj3 = new l(dVar);
            return obj3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animation for ");
        stringBuilder.append(string);
        stringBuilder.append(" not found in cache. Fetching from network.");
        d.a(stringBuilder.toString());
        return b(string, string2);
    }
}
