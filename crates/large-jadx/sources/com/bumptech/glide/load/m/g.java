package com.bumptech.glide.load.m;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public class g implements f {

    private final com.bumptech.glide.load.m.h b;
    private final URL c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;
    private int h;
    public g(String string) {
        super(string, h.a);
    }

    public g(String string, com.bumptech.glide.load.m.h h2) {
        super();
        this.c = 0;
        k.b(string);
        this.d = string;
        k.d(h2);
        this.b = (h)h2;
    }

    public g(URL uRL) {
        super(uRL, h.a);
    }

    public g(URL uRL, com.bumptech.glide.load.m.h h2) {
        super();
        k.d(uRL);
        this.c = (URL)uRL;
        this.d = 0;
        k.d(h2);
        this.b = (h)h2;
    }

    private byte[] d() {
        byte[] bytes;
        java.nio.charset.Charset charset;
        if (this.g == null) {
            this.g = c().getBytes(f.a);
        }
        return this.g;
    }

    private String f() {
        String string;
        boolean encode;
        String str;
        if (TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.d)) {
            if (TextUtils.isEmpty(this.d)) {
                URL url = this.c;
                k.d(url);
                string = (URL)url.toString();
            }
            this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    private URL g() {
        URL url;
        String str;
        if (this.f == null) {
            url = new URL(f());
            this.f = url;
        }
        return this.f;
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    @Override // com.bumptech.glide.load.f
    public String c() {
        String string;
        if (this.d != null) {
        } else {
            URL url = this.c;
            k.d(url);
            string = (URL)url.toString();
        }
        return string;
    }

    public Map<String, String> e() {
        return this.b.a();
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object object) {
        boolean equals;
        int i;
        String str;
        Object obj4;
        i = 0;
        if (object instanceof g && c().equals((g)object.c()) && this.b.equals(object.b)) {
            if (c().equals((g)object.c())) {
                if (this.b.equals(object.b)) {
                    i = 1;
                }
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.load.f
    public URL h() {
        return g();
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        int i;
        int i2;
        if (this.h == 0) {
            int i4 = c().hashCode();
            this.h = i4;
            this.h = i5 += i2;
        }
        return this.h;
    }

    @Override // com.bumptech.glide.load.f
    public String toString() {
        return c();
    }
}
