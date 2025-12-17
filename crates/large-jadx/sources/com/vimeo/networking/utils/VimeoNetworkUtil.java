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

/* loaded from: classes2.dex */
public class VimeoNetworkUtil {

    private static Gson mGson;
    public static void cancelCalls(ArrayList<Call> arrayList) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList);
        VimeoNetworkUtil.1 anon = new VimeoNetworkUtil.1(copyOnWriteArrayList);
        Thread obj2 = new Thread(anon);
        obj2.start();
    }

    public static CacheControl.Builder getCacheControlBuilder(CacheControl cacheControl) {
        int maxAgeSeconds;
        int maxStaleSeconds;
        int minFreshSeconds;
        int sECONDS2;
        TimeUnit sECONDS;
        CacheControl.Builder builder = new CacheControl.Builder();
        sECONDS2 = -1;
        if (cacheControl.maxAgeSeconds() > sECONDS2) {
            builder.maxAge(cacheControl.maxAgeSeconds(), TimeUnit.SECONDS);
        }
        if (cacheControl.maxStaleSeconds() > sECONDS2) {
            builder.maxStale(cacheControl.maxStaleSeconds(), TimeUnit.SECONDS);
        }
        if (cacheControl.minFreshSeconds() > sECONDS2) {
            builder.minFresh(cacheControl.minFreshSeconds(), TimeUnit.SECONDS);
        }
        if (cacheControl.noCache()) {
            builder.noCache();
        }
        if (cacheControl.noStore()) {
            builder.noStore();
        }
        if (cacheControl.noTransform()) {
            builder.noTransform();
        }
        if (cacheControl.onlyIfCached()) {
            builder.onlyIfCached();
        }
        return builder;
    }

    public static Gson getGson() {
        Gson mGson;
        if (VimeoNetworkUtil.mGson == null) {
            VimeoNetworkUtil.mGson = VimeoNetworkUtil.getGsonBuilder().create();
        }
        return VimeoNetworkUtil.mGson;
    }

    public static GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Stag.Factory factory = new Stag.Factory();
        return gsonBuilder.registerTypeAdapterFactory(factory).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    }

    public static Map<String, String> getSimpleQueryMap(String string) {
        int i2;
        String decode2;
        int i;
        String decode;
        final String str = "UTF-8";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] obj8 = string.split("\\?")[1].split("&");
        final int i4 = 0;
        i2 = i4;
        while (i2 < obj8.length) {
            String str4 = obj8[i2];
            int indexOf = str4.indexOf("=");
            linkedHashMap.put(URLDecoder.decode(str4.substring(i4, indexOf), str), URLDecoder.decode(str4.substring(indexOf++), str));
            i2++;
        }
        return linkedHashMap;
    }
}
