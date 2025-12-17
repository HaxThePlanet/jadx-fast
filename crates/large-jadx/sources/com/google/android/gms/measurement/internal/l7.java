package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class l7 implements Runnable {

    private final URL a;
    private final String b;
    final com.google.android.gms.measurement.internal.m7 c;
    private final com.google.android.gms.measurement.internal.z4 v;
    public l7(com.google.android.gms.measurement.internal.m7 m7, String string2, URL uRL3, byte[] b4Arr4, Map map5, com.google.android.gms.measurement.internal.z4 z46, byte[] b7Arr7) {
        this.c = m7;
        super();
        r.f(string2);
        r.j(uRL3);
        r.j(z46);
        this.a = uRL3;
        this.v = z46;
        this.b = string2;
    }

    private final void b(int i, Exception exception2, byte[] b3Arr3, Map<String, List<String>> map4) {
        super(this, i, exception2, b3Arr3, map4);
        m7Var.a.a().z(k7Var2);
    }

    @Override // java.lang.Runnable
    final void a(int i, Exception exception2, byte[] b3Arr3, Map map4) {
        z4Var.a.h(this.b, i, exception2, b3Arr3, map4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th3;
        Exception exc;
        Map map;
        Exception exc2;
        int read;
        Throwable th;
        this.c.g();
        int i = 0;
        com.google.android.gms.measurement.internal.m7 m7Var2 = this.c;
        java.net.URLConnection connection = this.a.openConnection();
        if (!connection instanceof HttpURLConnection) {
        } else {
            (HttpURLConnection)connection.setDefaultUseCaches(i);
            m7Var2.a.z();
            connection.setConnectTimeout(60000);
            m7Var2.a.z();
            connection.setReadTimeout(61000);
            connection.setInstanceFollowRedirects(i);
            connection.setDoInput(true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final InputStream inputStream = connection.getInputStream();
            byte[] bArr = new byte[1024];
            read = inputStream.read(bArr);
            while (read > 0) {
                byteArrayOutputStream.write(bArr, i, read);
                read = inputStream.read(bArr);
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (connection != null) {
                try {
                    connection.disconnect();
                    b(connection.getResponseCode(), 0, byteArrayOutputStream.toByteArray(), connection.getHeaderFields());
                    exc2 = obj1;
                    if (exc2 == null) {
                    } else {
                    }
                    exc2.close();
                    throw th2;
                    map = obj1;
                    map = obj1;
                    map = obj1;
                    map = obj1;
                    IOException iOException = new IOException("Failed to obtain HTTP connection");
                    throw iOException;
                    exc = obj1;
                    map = exc;
                    th = th3;
                    th3 = th2;
                    Throwable th2 = th;
                    if (exc == null) {
                    } else {
                    }
                    exc.disconnect();
                    b(th3, obj1, obj1, map);
                    throw th2;
                    exc = obj1;
                    map = exc;
                    th = th3;
                    th3 = th2;
                    th2 = th;
                    if (exc != null) {
                    }
                    exc.disconnect();
                    b(th3, th2, obj1, map);
                } catch (java.io.IOException ioException) {
                } catch (Throwable th1) {
                }
            }
        }
    }
}
