package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.a;
import com.bumptech.glide.t.c;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class j implements d<InputStream> {

    static final j.b y = new j$a();
    private final com.bumptech.glide.load.m.g a;
    private final int b;
    private final j.b c;
    private HttpURLConnection v;
    private InputStream w;
    private volatile boolean x;

    interface b {
        HttpURLConnection a(URL url);
    }

    private static class a implements j.b {
        a() {
            super();
        }

        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection)(URLConnection)FirebasePerfUrlConnection.instrument(url.openConnection());
        }
    }

    public j(com.bumptech.glide.load.m.g gVar, int i) {
        this(gVar, i, j.y);
    }

    private HttpURLConnection c(URL url, Map<String, String> map) throws HttpException {
        final boolean z = false;
        try {
            final HttpURLConnection httpURLConnection = this.c.a(url);
        } catch (java.io.IOException ioException) {
            map = new HttpException("URL.openConnection threw", r0, ioException);
            throw map;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            httpURLConnection.addRequestProperty((String)item.getKey(), (String)item.getValue());
        }
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.b);
        httpURLConnection.setUseCaches(z);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(z);
        return httpURLConnection;
    }

    private static int f(HttpURLConnection httpURLConnection) {
        String str2;
        try {
        } catch (java.io.IOException ioException) {
            int str = 3;
            str2 = "HttpUrlFetcher";
            str = Log.isLoggable(str2, str);
        }
        return httpURLConnection.getResponseCode();
    }

    private InputStream g(HttpURLConnection httpURLConnection) throws HttpException {
        boolean loggable;
        String contentEncoding;
        String str = "HttpUrlFetcher";
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.w = c.c(httpURLConnection.getInputStream(), (long)httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(str, 3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str4 = "Got non empty content encoding: ";
                    contentEncoding = httpURLConnection.getContentEncoding();
                    str2 = str4 + contentEncoding;
                    Log.d(str, str2);
                }
                this.w = httpURLConnection.getInputStream();
            }
        } catch (java.io.IOException ioException) {
            httpURLConnection = j.f(httpURLConnection);
            throw new HttpException("Failed to obtain InputStream", httpURLConnection, ioException);
        }
        return this.w;
    }

    private static boolean h(int i) {
        boolean z = true;
        i = i / 100 == 2 ? 1 : 0;
        return (i / 100 == 2 ? 1 : 0);
    }

    private static boolean i(int i) {
        boolean z = true;
        i = i / 100 == 3 ? 1 : 0;
        return (i / 100 == 3 ? 1 : 0);
    }

    private InputStream j(URL url, int i, URL url2, Map<String, String> map) throws java.net.URISyntaxException, HttpException {
        int i3 = -1;
        i = 5;
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!", i3);
        } else {
            if (url2 != null) {
                try {
                    throw new HttpException("In re-direct loop", i3);
                } catch (java.io.IOException ioException) {
                    url2 = j.f(this.v);
                    map = "Failed to connect or obtain data";
                    i = new HttpException(map, url2, ioException);
                    throw i;
                }
            }
            HttpURLConnection httpURLConnection4 = c(ioException, map);
            this.v = httpURLConnection4;
            try {
                httpURLConnection4.connect();
                this.w = this.v.getInputStream();
            } catch (java.io.IOException ioException) {
                url2 = j.f(this.v);
                map = "Failed to connect or obtain data";
                i = new HttpException(map, url2, ioException);
                throw i;
            }
            if (this.x) {
                return null;
            }
            int i6 = j.f(this.v);
            if (j.h(i6)) {
                return g(this.v);
            }
            if (j.i(i6)) {
                String headerField = this.v.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new HttpException("Received empty or null redirect url", i6);
                } else {
                    try {
                    } catch (java.net.MalformedURLException malformedURL) {
                        map = new StringBuilder();
                        map.append("Bad redirect url: ");
                        map.append(str);
                        map = map.toString();
                        i = new HttpException(map, url2, malformedURL);
                        throw i;
                    }
                    b();
                    return j(new URL(ioException, headerField), i + 1, malformedURL, map);
                }
            }
            if (i6 == i3) {
                throw new HttpException(i6);
            }
            try {
                throw new HttpException(this.v.getResponseMessage(), i6);
            } catch (java.io.IOException ioException) {
                map = "Failed to get a response message";
                i = new HttpException(map, url2, ioException);
                throw i;
            }
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        if (this.w != null) {
            try {
                this.w.close();
            } catch (java.io.IOException unused) {
                this.v.disconnect();
                this.v = null;
                return;
            }
        }
    }

    public void cancel() {
        this.x = true;
    }

    public a d() {
        return a.REMOTE;
    }

    public void e(h hVar, d.a<? super InputStream> aVar) {
        double d;
        int stringBuilder2;
        int str4;
        StringBuilder stringBuilder;
        str = "Finished http url fetcher fetch in ";
        final String str3 = "HttpUrlFetcher";
        try {
            aVar.f(j(this.a.h(), 0, null, this.a.e()));
        } catch (Throwable th) {
        }
        if (Log.isLoggable(str3, 2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(g.a(g.b()));
            Log.v(str3, stringBuilder.toString());
        }
    }

    j(com.bumptech.glide.load.m.g gVar, int i, j.b bVar) {
        super();
        this.a = gVar;
        this.b = i;
        this.c = bVar;
    }
}
