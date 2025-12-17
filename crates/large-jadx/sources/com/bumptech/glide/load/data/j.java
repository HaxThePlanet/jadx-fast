package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.m.g;
import com.bumptech.glide.t.c;
import com.bumptech.glide.t.g;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public class j implements com.bumptech.glide.load.data.d<InputStream> {

    static final com.bumptech.glide.load.data.j.b y;
    private final g a;
    private final int b;
    private final com.bumptech.glide.load.data.j.b c;
    private HttpURLConnection v;
    private InputStream w;
    private volatile boolean x;

    interface b {
        public abstract HttpURLConnection a(URL uRL);
    }

    private static class a implements com.bumptech.glide.load.data.j.b {
        @Override // com.bumptech.glide.load.data.j$b
        public HttpURLConnection a(URL uRL) {
            return (HttpURLConnection)(URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection());
        }
    }
    static {
        j.a aVar = new j.a();
        j.y = aVar;
    }

    public j(g g, int i2) {
        super(g, i2, j.y);
    }

    j(g g, int i2, com.bumptech.glide.load.data.j.b j$b3) {
        super();
        this.a = g;
        this.b = i2;
        this.c = b3;
    }

    private HttpURLConnection c(URL uRL, Map<String, String> map2) {
        com.bumptech.glide.load.data.j.b value;
        Object key;
        final int i = 0;
        final HttpURLConnection obj4 = this.c.a(uRL);
        Iterator obj5 = map2.entrySet().iterator();
        try {
            for (Map.Entry next2 : obj5) {
                obj4.addRequestProperty((String)next2.getKey(), (String)next2.getValue());
            }
            Object next2 = obj5.next();
            obj4.addRequestProperty((String)(Map.Entry)next2.getKey(), (String)next2.getValue());
            obj4.setConnectTimeout(this.b);
            obj4.setReadTimeout(this.b);
            obj4.setUseCaches(i);
            obj4.setDoInput(true);
            obj4.setInstanceFollowRedirects(i);
            return obj4;
            map2 = new HttpException("URL.openConnection threw", obj0, uRL);
            throw map2;
        }
    }

    private static int f(HttpURLConnection httpURLConnection) {
        String str;
        try {
            return httpURLConnection.getResponseCode();
            int str2 = 3;
            str = "HttpUrlFetcher";
            str2 = Log.isLoggable(str, str2);
            if (str2 != null) {
            }
            str2 = "Failed to get a response code";
            Log.d(str, str2, httpURLConnection);
            httpURLConnection = -1;
            return httpURLConnection;
        }
    }

    private InputStream g(HttpURLConnection httpURLConnection) {
        InputStream inputStream2;
        InputStream inputStream;
        long contentEncoding;
        String str = "HttpUrlFetcher";
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.w = c.c(httpURLConnection.getInputStream(), (long)contentLength);
        } else {
            try {
                if (Log.isLoggable(str, 3)) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Got non empty content encoding: ");
                stringBuilder.append(httpURLConnection.getContentEncoding());
                Log.d(str, stringBuilder.toString());
                this.w = httpURLConnection.getInputStream();
                return this.w;
                httpURLConnection = j.f(httpURLConnection);
                HttpException httpException = new HttpException("Failed to obtain InputStream", httpURLConnection, th);
                throw httpException;
            }
        }
    }

    private static boolean h(int i) {
        int obj1;
        obj1 = i /= 100 == 2 ? 1 : 0;
        return obj1;
    }

    private static boolean i(int i) {
        int obj1;
        obj1 = i /= 100 == 3 ? 1 : 0;
        return obj1;
    }

    private InputStream j(URL uRL, int i2, URL uRL3, Map<String, String> map4) {
        int uRI;
        boolean obj5;
        int i = -1;
        if (i2 >= 5) {
        } else {
            if (uRL3 != null) {
                if (uRL.toURI().equals(uRL3.toURI())) {
                } else {
                }
                obj5 = new HttpException("In re-direct loop", i);
                throw obj5;
            }
            obj5 = c(uRL, map4);
            this.v = obj5;
            obj5.connect();
            this.w = this.v.getInputStream();
            if (this.x) {
                try {
                    return null;
                    obj5 = j.f(this.v);
                    if (j.h(obj5)) {
                    }
                    return g(this.v);
                    if (j.i(obj5)) {
                    }
                    String headerField = this.v.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                    } else {
                    }
                    URL url = new URL(uRL, headerField);
                    b();
                    return j(url, i2++, uRL, map4);
                    map4 = new StringBuilder();
                    map4.append("Bad redirect url: ");
                    map4.append(obj0);
                    map4 = map4.toString();
                    i2 = new HttpException(map4, uRL3, uRL);
                    throw i2;
                    HttpException obj3 = new HttpException("Received empty or null redirect url", obj5);
                    throw obj3;
                    if (obj5 == i) {
                    }
                    obj3 = new HttpException(obj5);
                    throw obj3;
                    obj3 = new HttpException(this.v.getResponseMessage(), obj5);
                    throw obj3;
                    map4 = "Failed to get a response message";
                    i2 = new HttpException(map4, uRL3, uRL);
                    throw i2;
                    uRL3 = this.v;
                    uRL3 = j.f(uRL3);
                    map4 = "Failed to connect or obtain data";
                    i2 = new HttpException(map4, uRL3, uRL);
                    throw i2;
                    obj3 = new HttpException("Too many (> 5) redirects!", i);
                    throw obj3;
                } catch (java.io.IOException ioException) {
                }
            }
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.w;
        if (inputStream != null) {
            inputStream.close();
        }
        HttpURLConnection connection = this.v;
        if (connection != null) {
            connection.disconnect();
        }
        try {
            this.v = 0;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.x = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public a d() {
        return a.REMOTE;
    }

    public void e(h h, com.bumptech.glide.load.data.d.a<? super InputStream> d$a2) {
        double d;
        long l;
        int stringBuilder;
        Throwable th;
        InputStream inputStream;
        int str;
        int i;
        String obj9;
        StringBuilder obj10;
        final String str2 = "HttpUrlFetcher";
        a2.f(j(this.a.h(), 0, 0, this.a.e()));
        if (Log.isLoggable(str2, 2)) {
            obj10 = new StringBuilder();
            obj10.append("Finished http url fetcher fetch in ");
            obj10.append(g.a(g.b()));
            Log.v(str2, obj10.toString());
        }
    }
}
