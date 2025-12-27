package com.bumptech.glide.load.m;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class g implements f {

    private final h b;
    private final URL c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;
    private int h;
    public g(URL url) {
        this(url, h.a);
    }

    private byte[] d() throws java.io.UnsupportedEncodingException {
        if (this.g == null) {
            this.g = c().getBytes(f.a);
        }
        return this.g;
    }

    private String f() {
        String url;
        if (TextUtils.isEmpty(this.e)) {
            if (TextUtils.isEmpty(this.d)) {
                k.d(this.c);
                url = url2.toString();
            }
            str = "@#&=*+-_.,:!?()/~'%;$";
            this.e = Uri.encode(url, str);
        }
        return this.e;
    }

    private URL g() throws java.net.MalformedURLException {
        if (this.f == null) {
            this.f = new URL(f());
        }
        return this.f;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String url;
        if (this.d == null) {
            k.d(this.c);
            url = url2.toString();
        }
        return url;
    }

    public Map<String, String> e() {
        return this.b.a();
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = false;
        equals = object instanceof g;
        int i = 0;
        if (object instanceof g) {
            if (c().equals(object.c())) {
                if (this.b.equals(object.b)) {
                    int i2 = 1;
                }
            }
        }
        return z;
    }

    public URL h() {
        return g();
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.h == 0) {
            int i4 = c().hashCode();
            this.h = i4;
            i = (i4 * 31) + this.b.hashCode();
            this.h = i;
        }
        return this.h;
    }

    @Override // java.lang.Object
    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.a);
    }

    public g(URL url, h hVar) {
        super();
        k.d(url);
        this.c = url;
        this.d = null;
        k.d(hVar);
        this.b = hVar;
    }

    public g(String str, h hVar) {
        super();
        this.c = null;
        k.b(str);
        this.d = str;
        k.d(hVar);
        this.b = hVar;
    }
}
