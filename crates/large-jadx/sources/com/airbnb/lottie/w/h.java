package com.airbnb.lottie.w;

import android.util.Pair;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class h {

    private final g a;
    private final f b;
    public h(g gVar, f fVar) {
        super();
        this.a = gVar;
        this.b = fVar;
    }

    private com.airbnb.lottie.d a(String str, String str2) throws IOException {
        l lVar;
        final int i = 0;
        if (str2 == null) {
            return null;
        }
        Pair pair = this.a.a(str);
        if (pair == null) {
            return i;
        }
        if ((c)pair.first == c.ZIP) {
            lVar = e.s(new ZipInputStream(second2), str);
        } else {
            lVar = e.i(second2, str);
        }
        if (lVar.b() != null) {
            return (d)lVar.b();
        }
        return i;
    }

    private l<com.airbnb.lottie.d> b(String str, String str2) {
        boolean z = true;
        StringBuilder stringBuilder = new StringBuilder();
        String str7 = "Fetching ";
        str6 = str7 + str;
        d.a(str6);
        try {
            com.airbnb.lottie.w.d dVar = this.b.a(str);
            l lVar2 = d(str, dVar.T0(), dVar.D0(), str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Completed fetch from network. Success: ");
            int r2 = lVar2.b() != null ? 1 : 0;
            stringBuilder2.append((lVar2.b() != null ? 1 : 0));
            d.a(stringBuilder2.toString());
        } catch (java.io.IOException ioException) {
            d.d(str4, ioException);
        }
        try {
        } catch (java.io.IOException ioException) {
            d.d(str4, ioException);
        }
        return lVar2;
    }

    private l<com.airbnb.lottie.d> d(String str, InputStream inputStream, String str2, String str3) {
        l lVar;
        String str5;
        com.airbnb.lottie.w.c jSON2;
        if (str2 == null) {
            str5 = "application/json";
        }
        str2 = "application/zip";
        if (!str5.contains(str2)) {
            str2 = ".lottie";
            if (str.split("\\?")[0].endsWith(str2)) {
                d.a("Handling zip response.");
                jSON2 = c.ZIP;
                lVar = f(str, inputStream, str3);
            } else {
                d.a("Received json response.");
                jSON2 = c.JSON;
                lVar = e(str, inputStream, str3);
            }
        }
        if (str3 != null && lVar.b() != null) {
            this.a.e(str, jSON2);
        }
        return lVar;
    }

    private l<com.airbnb.lottie.d> e(String str, InputStream inputStream, String str2) throws java.io.FileNotFoundException {
        if (str2 == null) {
            return e.i(inputStream, null);
        }
        return e.i(new FileInputStream(new File(this.a.f(str, inputStream, c.JSON).getAbsolutePath())), str);
    }

    private l<com.airbnb.lottie.d> f(String str, InputStream inputStream, String str2) throws IOException, java.io.FileNotFoundException {
        if (str2 == null) {
            return e.s(new ZipInputStream(inputStream), null);
        }
        return e.s(new ZipInputStream(new FileInputStream(this.a.f(str, inputStream, c.ZIP))), str);
    }

    public l<com.airbnb.lottie.d> c(String str, String str2) {
        com.airbnb.lottie.d dVar = a(str, str2);
        if (dVar != null) {
            return new l(dVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = "Animation for ";
        String str5 = " not found in cache. Fetching from network.";
        str3 = str4 + str + str5;
        d.a(str3);
        return b(str, str2);
    }
}
