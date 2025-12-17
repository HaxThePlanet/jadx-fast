package com.vimeo.networking.logging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.vimeo.networking.Vimeo.LogLevel;
import l.f;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public class LoggingInterceptor implements Interceptor {
    private boolean shouldLogVerbose() {
        int i;
        i = ClientLogger.getLogLevel().ordinal() <= Vimeo.LogLevel.VERBOSE.ordinal() ? 1 : 0;
        return i;
    }

    private String toPrettyFormat(String string) {
        Gson create;
        String obj2;
        if (string != null && !string.isEmpty()) {
            if (!string.isEmpty()) {
                JsonParser jsonParser = new JsonParser();
                GsonBuilder gsonBuilder = new GsonBuilder();
                obj2 = gsonBuilder.setPrettyPrinting().create().toJson(jsonParser.parse(string).getAsJsonObject());
            } else {
                obj2 = "";
            }
        } else {
        }
        return obj2;
    }

    private void verboseLogLongJson(String string) {
        int i;
        String substring;
        int length;
        int length2;
        final String obj5 = toPrettyFormat(string);
        i = 0;
        while (i <= length3 /= 1000) {
            if (i * 1000 > obj5.length()) {
            }
            ClientLogger.v(obj5.substring(i * 1000, length));
            length = obj5.length();
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        boolean logVerbose;
        RequestBody logVerbose2;
        Object encodedPath;
        Request request = chain.request();
        HttpUrl httpUrl = request.url();
        ClientLogger.d("--------- REQUEST ---------");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("METHOD: ");
        stringBuilder3.append(request.method());
        ClientLogger.d(stringBuilder3.toString());
        StringBuilder stringBuilder4 = new StringBuilder();
        String str11 = "ENDPOINT: ";
        stringBuilder4.append(str11);
        stringBuilder4.append(httpUrl.encodedPath());
        ClientLogger.d(stringBuilder4.toString());
        if (ClientLogger.getLogLevel().ordinal() <= Vimeo.LogLevel.DEBUG.ordinal() && request.body() != null && shouldLogVerbose()) {
            request = chain.request();
            httpUrl = request.url();
            ClientLogger.d("--------- REQUEST ---------");
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("METHOD: ");
            stringBuilder3.append(request.method());
            ClientLogger.d(stringBuilder3.toString());
            stringBuilder4 = new StringBuilder();
            str11 = "ENDPOINT: ";
            stringBuilder4.append(str11);
            stringBuilder4.append(httpUrl.encodedPath());
            ClientLogger.d(stringBuilder4.toString());
            if (request.body() != null) {
                if (shouldLogVerbose()) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("QUERY: ");
                    stringBuilder5.append(httpUrl.query());
                    ClientLogger.v(stringBuilder5.toString());
                    ClientLogger.v("--------- REQUEST BODY ---------");
                    encodedPath = new f();
                    request.newBuilder().build().body().writeTo(encodedPath);
                    verboseLogLongJson(encodedPath.r1());
                    ClientLogger.v("--------- REQUEST BODY END ---------");
                }
            }
            ClientLogger.d("--------- REQUEST END ---------");
            Response obj9 = chain.proceed(request);
            ClientLogger.d("--------- RESPONSE ---------");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str11);
            stringBuilder.append(httpUrl.encodedPath());
            ClientLogger.d(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("STATUS CODE: ");
            stringBuilder2.append(obj9.code());
            ClientLogger.d(stringBuilder2.toString());
            Object[] arr = new Object[1];
            ClientLogger.d(String.format("REQUEST TIME: %.1fms", Double.valueOf(d /= l)));
            String string3 = obj9.body().string();
            if (shouldLogVerbose()) {
                ClientLogger.v("--------- RESPONSE BODY ---------");
                verboseLogLongJson(string3);
                ClientLogger.v("--------- RESPONSE BODY END ---------");
            }
            ClientLogger.d("--------- RESPONSE END ---------");
            return obj9.newBuilder().body(ResponseBody.create(obj9.body().contentType(), string3)).build();
        }
        return chain.proceed(chain.request());
    }
}
