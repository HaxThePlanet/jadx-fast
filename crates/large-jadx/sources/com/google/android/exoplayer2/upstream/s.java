package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.o;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class s extends com.google.android.exoplayer2.upstream.h implements com.google.android.exoplayer2.upstream.HttpDataSource {

    private final boolean e;
    private final int f;
    private final int g;
    private final String h;
    private final com.google.android.exoplayer2.upstream.HttpDataSource.b i;
    private final com.google.android.exoplayer2.upstream.HttpDataSource.b j;
    private final boolean k;
    private o<String> l;
    private com.google.android.exoplayer2.upstream.n m;
    private HttpURLConnection n;
    private InputStream o;
    private boolean p;
    private int q;
    private long r;
    private long s;

    static class a {
    }

    public static final class b implements com.google.android.exoplayer2.upstream.HttpDataSource.a {

        private final com.google.android.exoplayer2.upstream.HttpDataSource.b a;
        private com.google.android.exoplayer2.upstream.b0 b;
        private o<String> c;
        private String d;
        private int e = 8000;
        private int f = 8000;
        private boolean g;
        private boolean h;
        public b() {
            super();
            HttpDataSource.b bVar = new HttpDataSource.b();
            this.a = bVar;
            int i = 8000;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource$a
        public com.google.android.exoplayer2.upstream.HttpDataSource a() {
            return b();
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource$a
        public com.google.android.exoplayer2.upstream.l a() {
            return b();
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource$a
        public com.google.android.exoplayer2.upstream.s b() {
            super(this.d, this.e, this.f, this.g, this.a, this.c, this.h, 0);
            com.google.android.exoplayer2.upstream.b0 b0Var = this.b;
            if (b0Var != null) {
                sVar2.d(b0Var);
            }
            return sVar2;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource$a
        public com.google.android.exoplayer2.upstream.s.b c(com.google.android.exoplayer2.upstream.b0 b0) {
            this.b = b0;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource$a
        public com.google.android.exoplayer2.upstream.s.b d(String string) {
            this.d = string;
            return this;
        }
    }
    private s(String string, int i2, int i3, boolean z4, com.google.android.exoplayer2.upstream.HttpDataSource.b httpDataSource$b5, o<String> o6, boolean z7) {
        super(1);
        this.h = string;
        this.f = i2;
        this.g = i3;
        this.e = z4;
        this.i = b5;
        this.l = o6;
        HttpDataSource.b obj2 = new HttpDataSource.b();
        this.j = obj2;
        this.k = z7;
    }

    s(String string, int i2, int i3, boolean z4, com.google.android.exoplayer2.upstream.HttpDataSource.b httpDataSource$b5, o o6, boolean z7, com.google.android.exoplayer2.upstream.s.a s$a8) {
        super(string, i2, i3, z4, b5, o6, z7);
    }

    private void r() {
        HttpURLConnection connection;
        String str;
        String str2;
        connection = this.n;
        if (connection != null) {
            connection.disconnect();
            this.n = 0;
        }
        try {
        }
    }

    private URL s(URL uRL, String string2, com.google.android.exoplayer2.upstream.n n3) {
        boolean equals2;
        boolean equals;
        String obj7;
        final int i = 1;
        final int i2 = 2001;
        if (string2 == null) {
        } else {
            URL url = new URL(uRL, string2);
            obj7 = url.getProtocol();
            if (!"https".equals(obj7) && !"http".equals(obj7)) {
                if (!"http".equals(obj7)) {
                    String str = "Unsupported protocol redirect: ";
                    obj7 = String.valueOf(obj7);
                    if (obj7.length() != 0) {
                        obj7 = str.concat(obj7);
                    } else {
                        try {
                            obj7 = new String(str);
                            HttpDataSource.HttpDataSourceException obj6 = new HttpDataSource.HttpDataSourceException(obj7, n3, i2, i);
                            throw obj6;
                        }
                        return url;
                    }
                }
            }
        }
        obj6 = new HttpDataSource.HttpDataSourceException("Null location redirect", n3, i2, i);
        throw obj6;
    }

    private static boolean t(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection u(com.google.android.exoplayer2.upstream.n n) {
        boolean z2;
        int i;
        URL url;
        URL responseCode;
        int headerField;
        byte[] bArr2;
        int i3;
        long l3;
        int i2;
        boolean z;
        URL url2;
        long l2;
        Map map;
        long l;
        URL url3;
        int i4;
        byte[] bArr;
        int i5;
        Map map2;
        long l4;
        long l5;
        final Object obj3 = this;
        Object obj4 = n;
        responseCode = new URL(obj4.a.toString());
        headerField = obj4.c;
        bArr2 = obj4.d;
        final boolean z6 = obj4.d(1);
        if (!obj3.e && !obj3.k) {
            if (!obj3.k) {
                return this.v(responseCode, headerField, bArr2, obj4.f, obj5, obj4.g, obj7, z6);
            }
        }
        final int i20 = 0;
        url2 = responseCode;
        i2 = headerField;
        bArr = bArr2;
        i = i20;
        int i12 = i + 1;
        while (i <= 20) {
            int i18 = i2;
            url3 = url2;
            HttpURLConnection connection = this.v(url2, i2, bArr, l, l3, l2, i12, z6);
            responseCode = connection.getResponseCode();
            headerField = connection.getHeaderField("Location");
            bArr2 = 303;
            i3 = 301;
            l3 = 300L;
            int i11 = 302;
            connection.disconnect();
            url2 = url;
            i2 = i18;
            i = i16;
            l = l4;
            l2 = l5;
            i4 = 1;
            i12 = i + 1;
            connection.disconnect();
            if (obj3.k && responseCode == i11) {
            } else {
            }
            z = i20;
            if (z == 0) {
            } else {
            }
            i2 = i18;
            url2 = url;
            bArr = 0;
            i2 = 1;
            if (responseCode == i11) {
            } else {
            }
            z = 1;
        }
        StringBuilder stringBuilder = new StringBuilder(31);
        stringBuilder.append("Too many redirects: ");
        stringBuilder.append(i12);
        NoRouteToHostException noRouteToHostException = new NoRouteToHostException(stringBuilder.toString());
        HttpDataSource.HttpDataSourceException httpDataSourceException = new HttpDataSource.HttpDataSourceException(noRouteToHostException, obj4, 2001, 1);
        throw httpDataSourceException;
    }

    private HttpURLConnection v(URL uRL, int i2, byte[] b3Arr3, long l4, long l5, boolean z6, boolean z7, Map<String, String> map8) {
        HashMap hashMap;
        Object bVar;
        Map key;
        Object obj4;
        String obj6;
        long obj7;
        final HttpURLConnection obj3 = x(uRL);
        obj3.setConnectTimeout(this.f);
        obj3.setReadTimeout(this.g);
        hashMap = new HashMap();
        bVar = this.i;
        if (bVar != null) {
            hashMap.putAll(bVar.a());
        }
        hashMap.putAll(this.j.a());
        hashMap.putAll(obj12);
        Iterator obj12 = hashMap.entrySet().iterator();
        for (Map.Entry next2 : obj12) {
            obj3.setRequestProperty((String)next2.getKey(), (String)next2.getValue());
        }
        obj6 = v.a(l4, l5);
        if (obj6 != null) {
            obj3.setRequestProperty("Range", obj6);
        }
        obj6 = this.h;
        if (obj6 != null) {
            obj3.setRequestProperty("User-Agent", obj6);
        }
        obj6 = map8 != null ? "gzip" : "identity";
        obj3.setRequestProperty("Accept-Encoding", obj6);
        obj3.setInstanceFollowRedirects(obj11);
        obj6 = b3Arr3 != null ? 1 : 0;
        obj3.setDoOutput(obj6);
        obj3.setRequestMethod(n.c(i2));
        if (b3Arr3 != null) {
            obj3.setFixedLengthStreamingMode(b3Arr3.length);
            obj3.connect();
            obj4 = obj3.getOutputStream();
            obj4.write(b3Arr3);
            obj4.close();
        } else {
            obj3.connect();
        }
        return obj3;
    }

    private static void w(HttpURLConnection httpURLConnection, long l2) {
        int cmp;
        int arr;
        InputStream obj2;
        int obj3;
        int obj4;
        cmp = p0.a;
        if (httpURLConnection != null && cmp >= 19) {
            cmp = p0.a;
            if (cmp >= 19) {
                if (cmp > 20) {
                } else {
                    obj2 = httpURLConnection.getInputStream();
                    if (Long.compare(l2, i) == 0) {
                        if (obj2.read() == -1) {
                        }
                    } else {
                        if (Long.compare(l2, cmp) <= 0) {
                        }
                    }
                    obj3 = obj2.getClass().getName();
                    if (!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(obj3)) {
                        if ("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(obj3)) {
                            obj3 = obj2.getClass().getSuperclass();
                            g.e(obj3);
                            cmp = 0;
                            obj3 = (Class)obj3.getDeclaredMethod("unexpectedEndOfInput", new Class[cmp]);
                            obj3.setAccessible(true);
                            obj3.invoke(obj2, new Object[cmp]);
                        }
                    } else {
                    }
                }
            }
        }
    }

    private int y(byte[] bArr, int i2, int i3) {
        long l;
        int cmp;
        long l2;
        int obj9;
        if (i3 == 0) {
            return 0;
        }
        l = this.r;
        final int i5 = -1;
        l -= l4;
        if (Long.compare(l, i4) != 0 && Long.compare(i, i6) == 0) {
            l -= l4;
            if (Long.compare(i, i6) == 0) {
                return i5;
            }
            obj9 = (int)l;
        }
        InputStream inputStream = this.o;
        p0.i(inputStream);
        int obj7 = (InputStream)inputStream.read(bArr, i2, obj9);
        if (obj7 == i5) {
            return i5;
        }
        this.s = obj8 += l3;
        n(obj7);
        return obj7;
    }

    private void z(long l, com.google.android.exoplayer2.upstream.n n2) {
        int read;
        long l2;
        int i;
        int obj8;
        int i2 = 0;
        if (Long.compare(l, i2) == 0) {
        }
        int i4 = 4096;
        while (Long.compare(obj8, i2) > 0) {
            InputStream inputStream = this.o;
            p0.i(inputStream);
            read = (InputStream)inputStream.read(new byte[i4], 0, (int)l4);
            i = 1;
            obj8 -= l2;
            n(read);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long c(com.google.android.exoplayer2.upstream.n n) {
        int i;
        byte[] bArr;
        int dataSourceException;
        com.google.android.exoplayer2.upstream.n httpDataSourceException;
        Object gZIPInputStream;
        int cmp2;
        boolean z;
        String str;
        int headerField;
        o apply;
        int i2;
        int cmp;
        long l;
        this.m = n;
        i = 0;
        this.s = i;
        this.r = i;
        p(n);
        int i4 = 1;
        HttpURLConnection connection = u(n);
        this.n = connection;
        this.q = connection.getResponseCode();
        int i5 = this.q;
        str = "Content-Range";
        headerField = 200;
        i2 = -1;
        if (i5 >= headerField) {
            if (i5 > 299) {
            } else {
                String contentType = connection.getContentType();
                apply = this.l;
                if (apply != null) {
                    if (!apply.apply(contentType)) {
                    } else {
                    }
                    r();
                    HttpDataSource.InvalidContentTypeException invalidContentTypeException = new HttpDataSource.InvalidContentTypeException(contentType, n);
                    throw invalidContentTypeException;
                }
                headerField = n.f;
                if (this.q == headerField && Long.compare(headerField, i) != 0) {
                    headerField = n.f;
                    if (Long.compare(headerField, i) != 0) {
                        i = headerField;
                    }
                }
                z = s.t(connection);
                if (!z) {
                    headerField = n.g;
                    if (Long.compare(headerField, i2) != 0) {
                        try {
                            this.r = headerField;
                            str = v.b(connection.getHeaderField("Content-Length"), connection.getHeaderField(str));
                            if (Long.compare(str, i2) != 0) {
                            }
                            i2 = str - i;
                            this.r = i2;
                            this.r = n.g;
                            int i6 = 2000;
                            this.o = connection.getInputStream();
                            if (z) {
                            }
                            gZIPInputStream = new GZIPInputStream(this.o);
                            this.o = gZIPInputStream;
                            this.p = i4;
                            q(n);
                            z(i, httpDataSourceException);
                            return this.r;
                            r();
                            httpDataSourceException = th instanceof HttpDataSource.HttpDataSourceException;
                            if (httpDataSourceException != null) {
                            }
                            throw (HttpDataSource.HttpDataSourceException)th;
                            httpDataSourceException = new HttpDataSource.HttpDataSourceException(th, n, obj5, obj2);
                            throw httpDataSourceException;
                            r();
                            httpDataSourceException = new HttpDataSource.HttpDataSourceException(th, n, obj5, obj2);
                            throw httpDataSourceException;
                            int i10 = 416;
                            this.p = i4;
                            q(n);
                            long l3 = n.g;
                            if (Long.compare(l3, i2) != 0) {
                            }
                            i = l3;
                        } catch (java.io.IOException ioException) {
                        }
                        InputStream errorStream = connection.getErrorStream();
                        if (errorStream != null) {
                            bArr = p0.G0(errorStream);
                        } else {
                            bArr = p0.f;
                        }
                        r();
                        if (this.q == i10) {
                            dataSourceException = new DataSourceException(2008);
                        } else {
                            dataSourceException = 0;
                        }
                        super(this.q, connection.getResponseMessage(), dataSourceException, connection.getHeaderFields(), n, bArr);
                        throw invalidResponseCodeException;
                    } else {
                    }
                } else {
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public void close() {
        InputStream inputStream;
        Throwable th;
        Object httpDataSourceException;
        int i;
        int cmp;
        final InputStream inputStream2 = this.o;
        if (inputStream2 != null) {
            long l = this.r;
            if (Long.compare(l, i) == 0) {
                try {
                    i = l - l2;
                    s.w(this.n, i);
                    inputStream2.close();
                    com.google.android.exoplayer2.upstream.n nVar = this.m;
                    p0.i(nVar);
                    long l3 = 3L;
                    httpDataSourceException = new HttpDataSource.HttpDataSourceException(th, (n)nVar, 2000, l3);
                    throw httpDataSourceException;
                    this.o = 0;
                    r();
                    if (this.p) {
                    }
                    this.p = false;
                    o();
                    this.o = inputStream;
                    r();
                    inputStream = this.p;
                    if (inputStream == null) {
                    } else {
                    }
                    this.p = obj0;
                    o();
                    throw th;
                } catch (java.io.IOException ioException) {
                } catch (Throwable th1) {
                }
            } else {
            }
        }
    }

    public Map<String, List<String>> h() {
        Map headerFields;
        HttpURLConnection connection = this.n;
        if (connection == null) {
            headerFields = Collections.emptyMap();
        } else {
            headerFields = connection.getHeaderFields();
        }
        return headerFields;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public Uri l() {
        int parse;
        HttpURLConnection connection = this.n;
        if (connection == null) {
            parse = 0;
        } else {
            parse = Uri.parse(connection.getURL().toString());
        }
        return parse;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return y(bArr, i2, i3);
            i2 = this.m;
            p0.i(i2);
            i3 = 2;
            bArr = HttpDataSource.HttpDataSourceException.b(bArr, (n)i2, i3);
            throw bArr;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    HttpURLConnection x(URL uRL) {
        return (HttpURLConnection)(URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection());
    }
}
