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

/* compiled from: LoggingInterceptor.java */
/* loaded from: classes2.dex */
public class LoggingInterceptor implements Interceptor {
    private boolean shouldLogVerbose() {
        boolean z = true;
        int r0 = ClientLogger.getLogLevel().ordinal() <= Vimeo.LogLevel.VERBOSE.ordinal() ? 1 : 0;
        return (ClientLogger.getLogLevel().ordinal() <= Vimeo.LogLevel.VERBOSE.ordinal() ? 1 : 0);
    }

    private String toPrettyFormat(String str) {
        boolean empty;
        String json;
        if (str == null || str.isEmpty()) {
            json = "";
        } else {
            try {
                json = new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(str).getAsJsonObject());
            } catch (Exception unused) {
                str = "Error making body pretty response/request";
                ClientLogger.e(str);
            }
        }
        return json;
    }

    private void verboseLogLongJson(String str) {
        int i = 0;
        int length;
        final String prettyFormat = toPrettyFormat(str);
        i = 0;
        while (i <= prettyFormat.length() / 1000) {
            i = i + 1;
            length = i * 1000;
            ClientLogger.v(prettyFormat.substring(i * 1000, length));
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        if (ClientLogger.getLogLevel().ordinal() <= Vimeo.LogLevel.DEBUG.ordinal()) {
            Request request2 = chain.request();
            HttpUrl httpUrl = request2.url();
            ClientLogger.d("--------- REQUEST ---------");
            StringBuilder stringBuilder3 = new StringBuilder();
            String str17 = "METHOD: ";
            String method = request2.method();
            str10 = str17 + method;
            ClientLogger.d(str10);
            StringBuilder stringBuilder4 = new StringBuilder();
            String str18 = "ENDPOINT: ";
            String encodedPath = httpUrl.encodedPath();
            str11 = str18 + encodedPath;
            ClientLogger.d(str11);
            try {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str20 = "QUERY: ";
                String query = httpUrl.query();
                str13 = str20 + query;
                ClientLogger.v(str13);
                ClientLogger.v("--------- REQUEST BODY ---------");
                f fVar = new f();
                request2.newBuilder().build().body().writeTo(fVar);
                verboseLogLongJson(fVar.r1());
                ClientLogger.v("--------- REQUEST BODY END ---------");
            } catch (Exception e) {
                ClientLogger.e("Exception in LoggingInterceptor", e);
            }
            ClientLogger.d("--------- REQUEST END ---------");
            Response proceed2 = chain.proceed(request2);
            ClientLogger.d("--------- RESPONSE ---------");
            StringBuilder stringBuilder = new StringBuilder();
            String encodedPath2 = httpUrl.encodedPath();
            str2 = str18 + encodedPath2;
            ClientLogger.d(str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            String str4 = "STATUS CODE: ";
            int code = proceed2.code();
            str3 = str4 + code;
            ClientLogger.d(str3);
            Object[] arr = new Object[1];
            ClientLogger.d(String.format("REQUEST TIME: %.1fms", new Object[] { Double.valueOf((double)(System.nanoTime() - System.nanoTime()) / 1000000d) }));
            String string = proceed2.body().string();
            if (shouldLogVerbose()) {
                ClientLogger.v("--------- RESPONSE BODY ---------");
                verboseLogLongJson(string);
                ClientLogger.v("--------- RESPONSE BODY END ---------");
            }
            ClientLogger.d("--------- RESPONSE END ---------");
            return proceed2.newBuilder().body(ResponseBody.create(proceed2.body().contentType(), string)).build();
        }
        return chain.proceed(chain.request());
    }
}
