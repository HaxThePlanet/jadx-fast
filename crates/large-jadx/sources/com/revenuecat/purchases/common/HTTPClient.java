package com.revenuecat.purchases.common;

import android.os.Build.VERSION;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.j0;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\u0008:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\u0005\u0010\nJ\u0017\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u000c\u0010\u000fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u0017\u0010\u0018J?\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\u0008\u001e\u0010\u001fJ!\u0010!\u001a\u00020 *\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002¢\u0006\u0004\u0008!\u0010\"J6\u0010&\u001a\u0004\u0018\u00010\u0001\"\u0006\u0008\u0000\u0010#\u0018\u0001*\u0004\u0018\u00010\u00012\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00010$H\u0082\u0008¢\u0006\u0004\u0008&\u0010'J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\u0008*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008,\u0010-JK\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020\u000b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\u00080\u00101J\r\u00102\u001a\u00020\u0016¢\u0006\u0004\u00082\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00085\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00088\u00109¨\u0006<", d2 = {"Lcom/revenuecat/purchases/common/HTTPClient;", "", "Ljava/io/InputStream;", "inputStream", "Ljava/io/BufferedReader;", "buffer", "(Ljava/io/InputStream;)Ljava/io/BufferedReader;", "Ljava/io/OutputStream;", "outputStream", "Ljava/io/BufferedWriter;", "(Ljava/io/OutputStream;)Ljava/io/BufferedWriter;", "", "readFully", "(Ljava/io/InputStream;)Ljava/lang/String;", "reader", "(Ljava/io/BufferedReader;)Ljava/lang/String;", "Ljava/net/HttpURLConnection;", "connection", "getInputStream", "(Ljava/net/HttpURLConnection;)Ljava/io/InputStream;", "writer", "body", "Lkotlin/w;", "writeFully", "(Ljava/io/BufferedWriter;Ljava/lang/String;)V", "", "authenticationHeaders", "urlPath", "", "refreshETag", "getHeaders", "(Ljava/util/Map;Ljava/lang/String;Z)Ljava/util/Map;", "Lorg/json/JSONObject;", "convert", "(Ljava/util/Map;)Lorg/json/JSONObject;", "T", "Lkotlin/Function1;", "ifSuccess", "tryCast", "(Ljava/lang/Object;Lkotlin/d0/c/l;)Ljava/lang/Object;", "Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "request", "getConnection", "(Lcom/revenuecat/purchases/common/networking/HTTPRequest;)Ljava/net/HttpURLConnection;", "getXPlatformHeader", "()Ljava/lang/String;", "path", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "performRequest", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Z)Lcom/revenuecat/purchases/common/networking/HTTPResult;", "clearCaches", "()V", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "eTagManager", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "Lcom/revenuecat/purchases/common/AppConfig;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "<init>", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/networking/ETagManager;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class HTTPClient {

    private final com.revenuecat.purchases.common.AppConfig appConfig;
    private final ETagManager eTagManager;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            HTTPClient.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[Store.AMAZON.ordinal()] = 1;
        }
    }
    public HTTPClient(com.revenuecat.purchases.common.AppConfig appConfig, ETagManager eTagManager2) {
        n.f(appConfig, "appConfig");
        n.f(eTagManager2, "eTagManager");
        super();
        this.appConfig = appConfig;
        this.eTagManager = eTagManager2;
    }

    private final BufferedReader buffer(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        return bufferedWriter;
    }

    private final JSONObject convert(Map<String, ? extends Object> map) {
        int convert;
        Object key;
        boolean z;
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(map.size()));
        Iterator obj5 = map.entrySet().iterator();
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            convert = next2.getValue();
            if (convert instanceof Map != null) {
            }
            linkedHashMap.put((Map.Entry)next2.getKey(), convert);
            convert = convert((Map)convert);
        }
        obj5 = new JSONObject(linkedHashMap);
        return obj5;
    }

    private final HttpURLConnection getConnection(HTTPRequest hTTPRequest) {
        Object iterator;
        Object value;
        boolean next;
        Object key;
        Object obj5;
        Object instrument = FirebasePerfUrlConnection.instrument(hTTPRequest.getFullURL().openConnection());
        Objects.requireNonNull((URLConnection)instrument, "null cannot be cast to non-null type java.net.HttpURLConnection");
        iterator = hTTPRequest.getHeaders().entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            (HttpURLConnection)instrument.addRequestProperty((String)next2.getKey(), (String)next2.getValue());
        }
        obj5 = hTTPRequest.getBody();
        if (obj5 != null) {
            instrument.setDoOutput(true);
            instrument.setRequestMethod("POST");
            OutputStream outputStream = instrument.getOutputStream();
            n.e(outputStream, "os");
            obj5 = obj5.toString();
            n.e(obj5, "body.toString()");
            writeFully(buffer(outputStream), obj5);
        }
        return instrument;
    }

    private final Map<String, String> getHeaders(Map<String, String> map, String string2, boolean z3) {
        String str;
        kotlin.o[] arr = new o[9];
        str = this.appConfig.getFinishTransactions() ? "false" : "true";
        return MapExtensionsKt.filterNotNullValues(j0.o(j0.o(j0.k(u.a("Content-Type", "application/json"), u.a("X-Platform", getXPlatformHeader()), u.a("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor()), u.a("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion()), u.a("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT)), u.a("X-Version", "4.3.1"), u.a("X-Client-Locale", this.appConfig.getLanguageTag()), u.a("X-Client-Version", this.appConfig.getVersionName()), u.a("X-Observer-Mode-Enabled", str)), map), this.eTagManager.getETagHeader$common_release(string2, z3)));
    }

    private final InputStream getInputStream(HttpURLConnection httpURLConnection) {
        InputStream obj1;
        try {
            obj1 = httpURLConnection.getInputStream();
            httpURLConnection = httpURLConnection.getErrorStream();
            return obj1;
        }
    }

    private final String getXPlatformHeader() {
        String str;
        str = HTTPClient.WhenMappings.$EnumSwitchMapping$0[this.appConfig.getStore().ordinal()] != 1 ? "android" : "amazon";
        return str;
    }

    public static HTTPResult performRequest$default(com.revenuecat.purchases.common.HTTPClient hTTPClient, String string2, Map map3, Map map4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        return hTTPClient.performRequest(string2, map3, map4, obj4);
    }

    private final String readFully(BufferedReader bufferedReader) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            line = bufferedReader.readLine();
        }
        final String obj3 = stringBuilder.toString();
        n.e(obj3, "sb.toString()");
        return obj3;
    }

    private final String readFully(InputStream inputStream) {
        return readFully(buffer(inputStream));
    }

    private final <T> Object tryCast(Object object, l<? super T, ? extends Object> l2) {
        n.l(3, "T");
        throw 0;
    }

    private final void writeFully(BufferedWriter bufferedWriter, String string2) {
        bufferedWriter.write(string2);
        bufferedWriter.flush();
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$common_release();
    }

    public final HTTPResult performRequest(String string, Map<String, ? extends Object> map2, Map<String, String> map3, boolean z4) {
        int fully;
        int convert;
        final Object obj2 = this;
        Object obj = string;
        Map map = map2;
        final Object obj3 = map3;
        String str2 = "java.lang.String.format(this, *args)";
        n.f(obj, "path");
        n.f(obj3, "authenticationHeaders");
        if (map != null) {
            convert = obj2.convert(map);
        } else {
            convert = fully;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/v1");
        stringBuilder.append(obj);
        final String string2 = stringBuilder.toString();
        URL url = new URL(obj2.appConfig.getBaseURL(), string2);
        HTTPRequest hTTPRequest = new HTTPRequest(url, obj2.getHeaders(obj3, string2, z4), convert);
        final HttpURLConnection connection = obj2.getConnection(hTTPRequest);
        InputStream inputStream = obj2.getInputStream(connection);
        com.revenuecat.purchases.common.LogIntent dEBUG = LogIntent.DEBUG;
        int i3 = 2;
        Object[] arr2 = new Object[i3];
        int i7 = 0;
        arr2[i7] = connection.getRequestMethod();
        int i6 = 1;
        arr2[i6] = obj;
        String format2 = String.format("API request started: %s %s", Arrays.copyOf(arr2, i3));
        n.e(format2, str2);
        LogWrapperKt.log(dEBUG, format2);
        int responseCode = connection.getResponseCode();
        if (inputStream != null) {
            fully = obj2.readFully(inputStream);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        connection.disconnect();
        int i2 = 3;
        Object[] arr = new Object[i2];
        arr[i7] = connection.getRequestMethod();
        arr[i6] = obj;
        arr[i3] = Integer.valueOf(responseCode);
        String format = String.format("API request completed with status: %s %s %s", Arrays.copyOf(arr, i2));
        n.e(format, str2);
        LogWrapperKt.log(dEBUG, format);
        if (fully == 0) {
        } else {
            HTTPResult hTTPResultFromCacheOrBackend$common_release = obj2.eTagManager.getHTTPResultFromCacheOrBackend$common_release(responseCode, fully, connection, string2, z4);
            if (hTTPResultFromCacheOrBackend$common_release == null) {
                LogWrapperKt.log(LogIntent.WARNING, "We were expecting to be able to return a cached response, but we can't find it. Retrying call with a new ETag");
                return obj2.performRequest(obj, map, obj3, i6);
            }
            return hTTPResultFromCacheOrBackend$common_release;
        }
        IOException iOException = new IOException("HTTP Response payload is null");
        throw iOException;
    }
}
