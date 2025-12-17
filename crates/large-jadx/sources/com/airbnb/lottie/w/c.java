package com.airbnb.lottie.w;

import com.airbnb.lottie.y.d;

/* loaded from: classes.dex */
public enum c {

    JSON(".json"),
    ZIP(".zip");

    public final String extension;
    public static com.airbnb.lottie.w.c forFile(String string) {
        int i;
        com.airbnb.lottie.w.c cVar;
        boolean endsWith;
        com.airbnb.lottie.w.c[] values = c.values();
        i = 0;
        while (i < values.length) {
            cVar = values[i];
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find correct extension for ");
        stringBuilder.append(string);
        d.c(stringBuilder.toString());
        return c.JSON;
    }

    @Override // java.lang.Enum
    public String tempExtension() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".temp");
        stringBuilder.append(this.extension);
        return stringBuilder.toString();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
