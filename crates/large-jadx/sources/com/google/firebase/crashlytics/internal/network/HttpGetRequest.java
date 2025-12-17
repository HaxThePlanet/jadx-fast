package com.google.firebase.crashlytics.internal.network;

import com.google.firebase.crashlytics.internal.Logger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public class HttpGetRequest {

    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private static final String METHOD_GET = "GET";
    private static final int READ_BUFFER_SIZE = 8192;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String url;
    public HttpGetRequest(String string, Map<String, String> map2) {
        super();
        this.url = string;
        this.queryParams = map2;
        HashMap obj1 = new HashMap();
        this.headers = obj1;
    }

    private String createParamsString(Map<String, String> map) {
        Object value2;
        String string;
        Object value3;
        StringBuilder stringBuilder;
        Object value;
        StringBuilder stringBuilder2 = new StringBuilder();
        Iterator obj7 = map.entrySet().iterator();
        Object next = obj7.next();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)(Map.Entry)next.getKey());
        String str = "=";
        stringBuilder.append(str);
        final String str3 = "";
        if (next.getValue() != null) {
            value2 = next.getValue();
        } else {
            value2 = str3;
        }
        stringBuilder.append(value2);
        stringBuilder2.append(stringBuilder.toString());
        while (obj7.hasNext()) {
            Object next3 = obj7.next();
            stringBuilder = new StringBuilder();
            stringBuilder.append("&");
            stringBuilder.append((String)(Map.Entry)next3.getKey());
            stringBuilder.append(str);
            if (next3.getValue() != null) {
            } else {
            }
            value3 = str3;
            stringBuilder.append(value3);
            stringBuilder2.append(stringBuilder.toString());
            value3 = next3.getValue();
        }
        return stringBuilder2.toString();
    }

    private String createUrlWithParams(String string, Map<String, String> map2) {
        boolean stringBuilder;
        String obj4;
        obj4 = createParamsString(map2);
        if (obj4.isEmpty()) {
            return string;
        }
        String str = "?";
        String str2 = "&";
        if (string.contains(str) && !string.endsWith(str2)) {
            str2 = "&";
            if (!string.endsWith(str2)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(obj4);
                obj4 = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(obj4);
            return stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string);
        stringBuilder3.append(str);
        stringBuilder3.append(obj4);
        return stringBuilder3.toString();
    }

    private String readStream(InputStream inputStream) {
        String read;
        int i;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        char[] obj5 = new char[8192];
        StringBuilder stringBuilder = new StringBuilder();
        read = bufferedReader.read(obj5);
        while (read != -1) {
            stringBuilder.append(obj5, 0, read);
            read = bufferedReader.read(obj5);
        }
        return stringBuilder.toString();
    }

    public com.google.firebase.crashlytics.internal.network.HttpResponse execute() {
        int stream;
        Object obj2;
        Throwable th;
        String string;
        String str;
        stream = 0;
        String urlWithParams = createUrlWithParams(this.url, this.queryParams);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GET Request URL: ");
        stringBuilder.append(urlWithParams);
        Logger.getLogger().v(stringBuilder.toString());
        URL url2 = new URL(urlWithParams);
        java.net.URLConnection connection = url2.openConnection();
        int i = 10000;
        (HttpsURLConnection)connection.setReadTimeout(i);
        connection.setConnectTimeout(i);
        connection.setRequestMethod("GET");
        Iterator iterator = this.headers.entrySet().iterator();
        try {
            for (Map.Entry next2 : iterator) {
                connection.addRequestProperty((String)next2.getKey(), (String)next2.getValue());
            }
            Object next2 = iterator.next();
            connection.addRequestProperty((String)(Map.Entry)next2.getKey(), (String)next2.getValue());
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            if (inputStream != null) {
            }
            stream = readStream(inputStream);
            Object obj = obj3;
            if (inputStream != null) {
            }
            inputStream.close();
            if (connection != null) {
            }
            connection.disconnect();
            HttpResponse httpResponse = new HttpResponse(connection.getResponseCode(), stream);
            return httpResponse;
            obj2 = obj;
            if (obj != null) {
            }
            obj.close();
            if (obj2 == null) {
            } else {
            }
            obj2.disconnect();
            throw th;
        } catch (Throwable th) {
        }
    }

    public com.google.firebase.crashlytics.internal.network.HttpGetRequest header(String string, String string2) {
        this.headers.put(string, string2);
        return this;
    }

    public com.google.firebase.crashlytics.internal.network.HttpGetRequest header(Map.Entry<String, String> map$Entry) {
        return header((String)entry.getKey(), (String)entry.getValue());
    }
}
