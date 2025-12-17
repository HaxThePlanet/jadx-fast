package com.google.android.gms.internal.firebase-auth-api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class en {
    public static void a(String string, com.google.android.gms.internal.firebase-auth-api.lm lm2, com.google.android.gms.internal.firebase-auth-api.cn cn3, Type type4, com.google.android.gms.internal.firebase-auth-api.pm pm5) {
        java.io.InputStream obj3;
        try {
            URL url = new URL(string);
            obj3 = url.openConnection();
            (HttpURLConnection)obj3.setDoOutput(true);
            byte[] obj4 = lm2.zza().getBytes(Charset.defaultCharset());
            int length = obj4.length;
            obj3.setFixedLengthStreamingMode(length);
            obj3.setRequestProperty("Content-Type", "application/json");
            obj3.setConnectTimeout(60000);
            pm5.a(obj3);
            BufferedOutputStream obj7 = new BufferedOutputStream(obj3.getOutputStream(), length);
            obj7.write(obj4, 0, length);
            obj7.close();
            obj4 = obj3.getResponseCode();
            if (en.b(obj4)) {
            } else {
            }
            obj3 = obj3.getInputStream();
            obj3 = obj3.getErrorStream();
            obj7 = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(obj3, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            obj3 = bufferedReader.readLine();
            while (obj3 != null) {
                obj7.append(obj3);
                obj3 = bufferedReader.readLine();
            }
            obj7.append(obj3);
            bufferedReader.close();
            obj3 = obj7.toString();
            if (!en.b(obj4)) {
            }
            cn3.zza((String)km.a(obj3, String.class));
            cn3.b((mm)km.a(obj3, type4));
            obj0.close();
            string.addSuppressed(lm2);
            throw string;
            pm5.close();
            string.addSuppressed(lm2);
            throw string;
            string = string.getMessage();
            cn3.zza(string);
            string = "<<Network Error>>";
            cn3.zza(string);
            string = "TIMEOUT";
            cn3.zza(string);
        } catch (Throwable th) {
        }
    }

    private static final boolean b(int i) {
        int i2;
        if (i >= 200 && i < 300) {
            if (i < 300) {
                return 1;
            }
        }
        return 0;
    }
}
