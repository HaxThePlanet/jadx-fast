package com.google.android.gms.internal.measurement;

import android.net.Uri;
import d.e.a;
import d.e.g;

/* loaded from: classes2.dex */
public final class m6 {

    private static final a<String, Uri> a;
    static {
        a aVar = new a();
        m6.a = aVar;
    }

    public static Uri a(String string) {
        String string2;
        Object parse;
        String str;
        int length;
        final Class<com.google.android.gms.internal.measurement.m6> obj5 = m6.class;
        final String str2 = "com.google.android.gms.measurement";
        final a aVar = m6.a;
        synchronized (obj5) {
            String valueOf = String.valueOf(Uri.encode(str2));
            str = "content://com.google.android.gms.phenotype/";
            if (valueOf.length() != 0) {
                string2 = str.concat(valueOf);
            } else {
                try {
                    string2 = new String(str);
                    aVar.put(str2, Uri.parse(string2));
                    return parse;
                    throw th;
                }
            }
        }
    }
}
