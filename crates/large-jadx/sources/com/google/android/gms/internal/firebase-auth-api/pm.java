package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public final class pm {

    private final Context a;
    private com.google.android.gms.internal.firebase-auth-api.fn b;
    private final String c;
    private boolean d = false;
    private String e;
    public pm(Context context, String string2) {
        super();
        r.j(context);
        this.a = context.getApplicationContext();
        Object[] obj3 = new Object[2];
        this.c = String.format("Android/%s/%s", "Fallback", string2);
    }

    public final void a(URLConnection uRLConnection) {
        String string;
        int i;
        com.google.android.gms.internal.firebase-auth-api.fn fnVar;
        StringBuilder stringBuilder;
        String packageName;
        if (this.d) {
            String str2 = this.c;
            stringBuilder = new StringBuilder(length += 19);
            stringBuilder.append(str2);
            stringBuilder.append("/FirebaseUI-Android");
            string = stringBuilder.toString();
        } else {
            String str4 = this.c;
            stringBuilder = new StringBuilder(length2 += 21);
            stringBuilder.append(str4);
            stringBuilder.append("/FirebaseCore-Android");
            string = stringBuilder.toString();
        }
        if (this.b == null) {
            stringBuilder = this.a;
            fnVar = new fn(stringBuilder, stringBuilder.getPackageName());
            this.b = fnVar;
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.b.b());
        uRLConnection.setRequestProperty("X-Android-Cert", this.b.a());
        uRLConnection.setRequestProperty("Accept-Language", qm.a());
        uRLConnection.setRequestProperty("X-Client-Version", string);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.e);
        this.e = 0;
    }

    public final void b(String string) {
        this.d = obj1 ^= 1;
    }

    public final void c(String string) {
        this.e = string;
    }
}
