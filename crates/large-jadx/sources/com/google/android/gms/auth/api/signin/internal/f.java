package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    private static final a c;
    private final String a;
    private final s b;
    static {
        a aVar = new a("RevokeAccessOperation", new String[0]);
        f.c = aVar;
    }

    public f(String string) {
        super();
        r.f(string);
        this.a = string;
        s obj2 = new s(0);
        this.b = obj2;
    }

    public static e<Status> a(String string) {
        if (string == null) {
            Status obj1 = new Status(4);
            return f.a(obj1, 0);
        }
        f fVar = new f(string);
        obj1 = new Thread(fVar);
        obj1.start();
        return fVar.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status;
        int i;
        Throwable string;
        String string2;
        String concat;
        a i2;
        String valueOf;
        String str;
        Object[] length;
        status = Status.z;
        i = 0;
        String str2 = "https://accounts.google.com/o/oauth2/revoke?token=";
        valueOf = String.valueOf(this.a);
        if (valueOf.length() != 0) {
            concat = str2.concat(valueOf);
        } else {
            valueOf = new String(str2);
            concat = valueOf;
        }
        try {
            URL url = new URL(concat);
            java.net.URLConnection connection = url.openConnection();
            (HttpURLConnection)connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
            } else {
            }
            status = Status.x;
            f.c.c("Unable to revoke access!", new Object[i]);
            StringBuilder stringBuilder = new StringBuilder(26);
            stringBuilder.append("Response Code: ");
            stringBuilder.append(responseCode);
            f.c.a(stringBuilder.toString(), new Object[i]);
            a aVar = f.c;
            string = string.toString();
            string = String.valueOf(string);
            String str4 = "Exception when revoking access: ";
            int length2 = string.length();
            if (length2 != 0) {
            } else {
            }
            string = str4.concat(string);
            string = new String(str4);
            int arr = new Object[arr];
            aVar.c(string, arr);
            aVar = f.c;
            string = string.toString();
            string = String.valueOf(string);
            str4 = "IOException when revoking access: ";
            length2 = string.length();
            if (length2 != 0) {
            } else {
            }
            string = str4.concat(string);
            string = new String(str4);
            arr = new Object[arr];
            aVar.c(string, arr);
            this.b.f(status);
        }
    }
}
