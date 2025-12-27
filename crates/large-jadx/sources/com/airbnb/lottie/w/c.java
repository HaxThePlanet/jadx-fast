package com.airbnb.lottie.w;

import com.airbnb.lottie.y.d;

/* compiled from: FileExtension.java */
/* loaded from: classes.dex */
public enum c {

    JSON,
    ZIP;

    public final String extension;
    public static c forFile(String str) {
        int i = 0;
        com.airbnb.lottie.w.c[] values = c.values();
        i = 0;
        for (com.airbnb.lottie.w.c cVar : values) {
            if (str.endsWith(cVar.extension)) {
                return cVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Unable to find correct extension for ";
        str3 = str2 + str;
        d.c(str3);
        return c.JSON;
    }

    @Override // java.lang.Enum
    public String tempExtension() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ".temp";
        str = str2 + this.extension;
        return str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
