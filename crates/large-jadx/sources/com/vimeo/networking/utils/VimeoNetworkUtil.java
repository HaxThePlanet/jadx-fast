package com.vimeo.networking.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vimeo.stag.generated.Stag.Factory;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import retrofit2.Call;

/* compiled from: VimeoNetworkUtil.java */
/* loaded from: classes2.dex */
public class VimeoNetworkUtil {

    private static Gson mGson;
    public static void cancelCalls(ArrayList<Call> arrayList) throws java.lang.IllegalThreadStateException {
        new Thread(new VimeoNetworkUtil.AnonymousClass1(new CopyOnWriteArrayList(arrayList))).start();
    }

    public static CacheControl.Builder getCacheControlBuilder(CacheControl cacheControl) {
        TimeUnit sECONDS2;
        final CacheControl.Builder cacheControl_Builder = new CacheControl_Builder();
        int i = -1;
        if (cacheControl.maxAgeSeconds() > i) {
            cacheControl_Builder.maxAge(cacheControl.maxAgeSeconds(), TimeUnit.SECONDS);
        }
        if (cacheControl.maxStaleSeconds() > i) {
            cacheControl_Builder.maxStale(cacheControl.maxStaleSeconds(), TimeUnit.SECONDS);
        }
        if (cacheControl.minFreshSeconds() > i) {
            cacheControl_Builder.minFresh(cacheControl.minFreshSeconds(), TimeUnit.SECONDS);
        }
        if (cacheControl.noCache()) {
            cacheControl_Builder.noCache();
        }
        if (cacheControl.noStore()) {
            cacheControl_Builder.noStore();
        }
        if (cacheControl.noTransform()) {
            cacheControl_Builder.noTransform();
        }
        if (cacheControl.onlyIfCached()) {
            cacheControl_Builder.onlyIfCached();
        }
        return cacheControl_Builder;
    }

    public static Gson getGson() {
        if (VimeoNetworkUtil.mGson == null) {
            VimeoNetworkUtil.mGson = VimeoNetworkUtil.getGsonBuilder().create();
        }
        return VimeoNetworkUtil.mGson;
    }

    public static GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(new Stag.Factory()).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    }

    public static Map<String, String> getSimpleQueryMap(String str) {
        int i;
        final String str2 = "UTF-8";
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            String[] parts2 = str.split("\\?")[1].split("&");
            i = 0;
            String str5 = parts2[i];
            int indexOf = str5.indexOf("=");
            i2 = indexOf + 1;
            linkedHashMap.put(URLDecoder.decode(str5.substring(i, indexOf), str2), URLDecoder.decode(str5.substring(i2), str2));
        } catch (java.io.UnsupportedEncodingException unsupportedEncoding) {
            unsupportedEncoding.printStackTrace();
            return obj;
        }
        return linkedHashMap;
    }
}
