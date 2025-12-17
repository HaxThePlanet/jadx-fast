package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public final class bk {

    private final int valueOf;
    public bk(int i) {
        super();
        this.valueOf = i;
    }

    private static String AFInAppEventType(HttpURLConnection httpURLConnection, boolean z2) {
        Throwable th;
        int i;
        Throwable th2;
        String line;
        java.io.InputStream obj6;
        final String str = "Could not read connection response from: ";
        int i2 = 0;
        if (z2 != null) {
            obj6 = httpURLConnection.getInputStream();
        } else {
            obj6 = httpURLConnection.getErrorStream();
        }
        if (obj6 == null) {
            return "";
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(obj6);
            obj6 = new BufferedReader(inputStreamReader);
            i = 1;
            line = obj6.readLine();
            while (line != null) {
                if (i == 0) {
                }
                stringBuilder.append(line);
                i = 0;
                line = obj6.readLine();
                stringBuilder.append('\n');
            }
            if (i == 0) {
            }
            stringBuilder.append('\n');
            stringBuilder.append(line);
            i = 0;
            inputStreamReader.close();
            obj6.close();
            return stringBuilder.toString();
            th2 = z2;
            th2 = z2;
            z2 = th;
            th2 = z2;
            z2 = th;
            th2 = th;
            th = stringBuilder2;
            th2 = th;
            th = stringBuilder2;
            th2 = th;
            th = stringBuilder2;
            th2 = th;
            th2 = th;
            StringBuilder stringBuilder2 = new StringBuilder(obj0);
            httpURLConnection = httpURLConnection.getURL();
            httpURLConnection = httpURLConnection.toString();
            stringBuilder2.append(httpURLConnection);
            httpURLConnection = stringBuilder2.toString();
            AFLogger.AFKeystoreWrapper(httpURLConnection, z2);
            throw z2;
            th2 = th;
            stringBuilder2 = new StringBuilder(obj0);
            httpURLConnection = httpURLConnection.getURL();
            httpURLConnection = httpURLConnection.toString();
            stringBuilder2.append(httpURLConnection);
            httpURLConnection = stringBuilder2.toString();
            AFLogger.AFKeystoreWrapper(httpURLConnection, z2);
            throw z2;
            if (th != null) {
            }
            th.close();
        } catch (java.io.IOException ioException) {
        } catch (Exception e1) {
        } catch (Throwable th2) {
        }
        try {
            th2.close();
            throw httpURLConnection;
        }
    }

    public final com.appsflyer.internal.br<String> values(com.appsflyer.internal.x x) {
        byte[] bArr;
        byte[] aFInAppEventParameterName;
        String values;
        int valueOf;
        String str;
        int i;
        byte[] aFInAppEventParameterName2;
        String value;
        boolean bufferedOutputStream;
        int outputStream;
        int length;
        StringBuilder stringBuilder = new StringBuilder("HTTP: url: ");
        stringBuilder.append(x.values);
        AFLogger.values(stringBuilder.toString());
        if (x.AFInAppEventParameterName != null) {
            StringBuilder stringBuilder2 = new StringBuilder("HTTP: data: ");
            values = new String(x.AFInAppEventParameterName);
            stringBuilder2.append(values);
            AFLogger.values(stringBuilder2.toString());
        }
        URL url = new URL(x.values);
        Object instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
        (HttpURLConnection)(URLConnection)instrument.setRequestMethod(x.AFInAppEventType);
        valueOf = this.valueOf;
        int getLevel = x.getLevel;
        if (getLevel != -1) {
            valueOf = getLevel;
        }
        instrument.setConnectTimeout(valueOf);
        instrument.setReadTimeout(valueOf);
        if (x.valueOf) {
            try {
                str = "application/octet-stream";
                str = "application/json";
                instrument.addRequestProperty("Content-Type", str);
                Iterator iterator = x.AFKeystoreWrapper.entrySet().iterator();
                for (Map.Entry next : iterator) {
                    instrument.setRequestProperty((String)next.getKey(), (String)next.getValue());
                }
                Object next = iterator.next();
                instrument.setRequestProperty((String)(Map.Entry)next.getKey(), (String)next.getValue());
                byte[] obj12 = x.AFInAppEventParameterName;
                if (obj12 != null) {
                }
                instrument.setDoOutput(true);
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(obj12.length);
                instrument.setRequestProperty("Content-Length", stringBuilder4.toString());
                bufferedOutputStream = new BufferedOutputStream(instrument.getOutputStream());
                bufferedOutputStream.write(obj12);
                bufferedOutputStream.close();
                bArr = obj5;
                if (bArr == null) {
                } else {
                }
                bArr.close();
                throw x;
                obj12 = instrument.getResponseCode();
                if (obj12 / 100 == 2) {
                } else {
                }
                i = 0;
                final int i6 = i;
                String str6 = bk.AFInAppEventType(instrument, i6);
                String str5 = "HTTP: response code: ";
                StringBuilder stringBuilder3 = new StringBuilder(str5);
                stringBuilder3.append(obj12);
                stringBuilder3.append(" ");
                stringBuilder3.append(instrument.getResponseMessage());
                AFLogger.values(stringBuilder3.toString());
                AFLogger.values("HTTP: response body: ".concat(String.valueOf(str6)));
                bj bjVar2 = new bj(currentTimeMillis2 -= currentTimeMillis, str5);
                HashMap hashMap = new HashMap(instrument.getHeaderFields());
                hashMap.remove(0);
                super(str6, instrument.getResponseCode(), i6, hashMap, bjVar2);
                if (instrument != null) {
                }
                instrument.disconnect();
                return obj12;
                bArr = l;
                bArr = l;
                long l = System.currentTimeMillis();
                l -= bjVar;
                bj bjVar = new bj(l, obj4);
                HttpException httpException = new HttpException(x, bjVar);
                throw httpException;
                if (bArr == null) {
                } else {
                }
                bArr.disconnect();
                throw x;
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        } else {
        }
    }
}
