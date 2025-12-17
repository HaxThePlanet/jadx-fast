package com.google.android.gms.internal.firebase-auth-api;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.firebase.auth.internal.zzai;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class tl extends AsyncTask<Void, Void, com.google.android.gms.internal.firebase-auth-api.sl> {

    private static final a f;
    private final String a;
    private final String b;
    private final WeakReference<com.google.android.gms.internal.firebase-auth-api.vl> c;
    private final Uri.Builder d;
    private final String e;
    static {
        a aVar = new a("FirebaseAuth", /* result */);
        tl.f = aVar;
    }

    public tl(String string, String string2, Intent intent3, com.google.android.gms.internal.firebase-auth-api.vl vl4) {
        super();
        r.f(string);
        this.a = string;
        r.f(string2);
        r.j(intent3);
        String stringExtra = intent3.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        r.f(stringExtra);
        Uri.Builder upon = Uri.parse(vl4.zzc(stringExtra)).buildUpon();
        r.j(string2);
        upon.appendPath("getProjectConfig").appendQueryParameter("key", stringExtra).appendQueryParameter("androidPackageName", string).appendQueryParameter("sha1Cert", (String)string2);
        this.b = upon.build().toString();
        WeakReference weakReference = new WeakReference(vl4);
        this.c = weakReference;
        this.d = vl4.zzb(intent3, string, string2);
        this.e = intent3.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    private final void a(com.google.android.gms.internal.firebase-auth-api.sl sl) {
        int i;
        boolean empty;
        int obj4;
        Object obj = this.c.get();
        if (sl != null) {
            i = sl.c();
            obj4 = sl.d();
        } else {
            obj4 = i;
        }
        if ((vl)obj == null) {
            tl.f.c("An error has occurred: the handler reference has returned null.", new Object[0]);
        }
        empty = this.d;
        if (!TextUtils.isEmpty(i) && empty != null) {
            empty = this.d;
            if (empty != null) {
                empty.authority(i);
                (vl)obj.zzf(this.d.build(), this.a);
            }
        }
        obj.zze(this.a, zzai.zza(obj4));
    }

    private static byte[] b(InputStream inputStream, int i2) {
        int read;
        int i;
        ByteArrayOutputStream obj4 = new ByteArrayOutputStream();
        byte[] bArr = new byte[128];
        read = inputStream.read(bArr);
        while (read == -1) {
            obj4.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        obj4.close();
        return obj4.toByteArray();
    }

    @Override // android.os.AsyncTask
    protected final Object doInBackground(Object[] objectArr) {
        com.google.android.gms.internal.firebase-auth-api.sl i;
        Object iterator;
        HttpURLConnection connection;
        a soVar;
        a endsWith;
        String responseCode;
        String stringBuilder;
        StringBuilder stringBuilder2;
        int i2;
        String obj7;
        if (!TextUtils.isEmpty(this.e)) {
            i = sl.a(this.e);
        } else {
            obj7 = 0;
            URL url = new URL(this.b);
            Object obj2 = this.c.get();
            connection = (vl)obj2.zzd(url);
            connection.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setConnectTimeout(60000);
            pm pmVar = new pm(obj2.zza(), nm.a().b());
            pmVar.a(connection);
            int responseCode2 = connection.getResponseCode();
            stringBuilder = 128;
            if (responseCode2 != 200) {
                if (connection.getResponseCode() >= 400) {
                    InputStream errorStream = connection.getErrorStream();
                    if (errorStream == null) {
                        iterator = "WEB_INTERNAL_ERROR:Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again.";
                    } else {
                        responseCode = new String(tl.b(errorStream, stringBuilder));
                        iterator = km.a(responseCode, String.class);
                    }
                } else {
                    iterator = i;
                }
                Object[] arr = new Object[2];
                arr[obj7] = iterator;
                arr[1] = Integer.valueOf(responseCode2);
                tl.f.c(String.format("Error getting project config. Failed with %s %s", arr), new Object[obj7]);
                i = sl.b(iterator);
            } else {
                soVar = new so();
                endsWith = new String(tl.b(connection.getInputStream(), stringBuilder));
                soVar.a(endsWith);
                iterator = soVar.b().iterator();
                for (String soVar : iterator) {
                }
            }
        }
        return i;
    }

    @Override // android.os.AsyncTask
    protected final void onCancelled(Object object) {
        a(0);
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Object object) {
        a((sl)object);
    }
}
