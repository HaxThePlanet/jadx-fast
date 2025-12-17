package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class v3 implements Runnable {

    private final URL a;
    private final byte[] b;
    private final com.google.android.gms.measurement.internal.s3 c;
    private final String v;
    private final Map<String, String> w;
    final com.google.android.gms.measurement.internal.w3 x;
    public v3(com.google.android.gms.measurement.internal.w3 w3, String string2, URL uRL3, byte[] b4Arr4, Map map5, com.google.android.gms.measurement.internal.s3 s36) {
        this.x = w3;
        super();
        r.f(string2);
        r.j(uRL3);
        r.j(s36);
        this.a = uRL3;
        this.b = b4Arr4;
        this.c = s36;
        this.v = string2;
        this.w = map5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.y4 y4Var;
        Throwable u3Var;
        com.google.android.gms.measurement.internal.u3 u3Var2;
        Throwable th;
        int i;
        Throwable th2;
        int outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th3;
        java.net.URLConnection connection;
        Throwable th5;
        Object iterator;
        byte[] bArr;
        com.google.android.gms.measurement.internal.u3 u3Var3;
        Object value;
        String str2;
        Object length;
        com.google.android.gms.measurement.internal.s3 s3Var;
        Object str;
        int responseCode;
        Throwable valueOf;
        int i2;
        Throwable th4;
        byte[] byteArray;
        Map headerFields;
        Throwable th6;
        int i4;
        int i3;
        String str4 = "Error closing HTTP compressed POST connection output stream. appId";
        this.x.g();
        int i5 = 0;
        i = 0;
        com.google.android.gms.measurement.internal.w3 w3Var3 = this.x;
        connection = this.a.openConnection();
        if (!connection instanceof HttpURLConnection) {
        } else {
            (HttpURLConnection)connection.setDefaultUseCaches(i5);
            w3Var3.a.z();
            connection.setConnectTimeout(60000);
            w3Var3.a.z();
            connection.setReadTimeout(61000);
            connection.setInstanceFollowRedirects(i5);
            outputStream = 1;
            connection.setDoInput(outputStream);
            iterator = this.w;
            if (iterator != null) {
                iterator = iterator.entrySet().iterator();
                for (Map.Entry next : iterator) {
                    connection.addRequestProperty((String)next.getKey(), (String)next.getValue());
                }
            }
            if (this.b != null) {
                bArr = w3Var4.b.e0().Q(this.b);
                length = bArr.length;
                w3Var5.a.b().v().b("Uploading data. size", Integer.valueOf(length));
                connection.setDoOutput(outputStream);
                connection.addRequestProperty("Content-Encoding", "gzip");
                connection.setFixedLengthStreamingMode(length);
                connection.connect();
                outputStream = connection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream inputStream = connection.getInputStream();
                byte[] bArr3 = new byte[1024];
                length = inputStream.read(bArr3);
                while (length > 0) {
                    byteArrayOutputStream.write(bArr3, i5, length);
                    length = inputStream.read(bArr3);
                }
                byteArrayOutputStream.write(bArr3, i5, length);
                if (inputStream != null) {
                }
                inputStream.close();
                if (connection != null) {
                }
                connection.disconnect();
                y4Var = w3Var.a.a();
                super(this.v, this.c, connection.getResponseCode(), 0, byteArrayOutputStream.toByteArray(), connection.getHeaderFields(), 0);
                y4Var.z(u3Var2);
                th5 = th;
                if (th5 == null) {
                } else {
                }
                th5.close();
                throw u3Var;
                th5 = u3Var;
                valueOf = str;
                th6 = i9;
                th5 = u3Var;
                th4 = th5;
                valueOf = str;
                th6 = i9;
                th6 = th;
                valueOf = str;
                th6 = th;
                th4 = th5;
                valueOf = str;
                valueOf = u3Var;
                th6 = th;
                th5 = th2;
                valueOf = u3Var;
                th6 = th;
                th4 = th2;
                IOException iOException = new IOException("Failed to obtain HTTP connection");
                throw iOException;
                th5 = th2;
                valueOf = u3Var;
                th3 = th;
                th6 = th3;
                if (th != null) {
                }
                th.close();
                th = this.x;
                th = th.a;
                th = th.b();
                th = th.r();
                th2 = this.v;
                th2 = q3.z(th2);
                th.c(str3, th2, u3Var);
                if (th3 == null) {
                } else {
                }
                th3.disconnect();
                String str3 = this.x;
                str3 = str3.a;
                str3 = str3.a();
                length = this.v;
                str = this.c;
                th4 = null;
                int i9 = 0;
                i3 = 0;
                value = u3Var;
                super(length, str, valueOf, th4, i9, th6, i3);
                str3.z(u3Var);
                throw th5;
                th5 = th2;
                valueOf = u3Var;
                th3 = th;
                th6 = th3;
                th4 = th5;
                if (th != null) {
                }
                th.close();
                th = this.x;
                th = th.a;
                th = th.b();
                th = th.r();
                th2 = this.v;
                th2 = q3.z(th2);
                th.c(str3, th2, u3Var);
                if (th3 != null) {
                }
                th3.disconnect();
                str3 = this.x;
                str3 = str3.a;
                str3 = str3.a();
                length = this.v;
                str = this.c;
                i9 = 0;
                i3 = 0;
                value = u3Var;
                super(length, str, valueOf, th4, i9, th6, i3);
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        }
    }
}
