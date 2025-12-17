package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class n {

    public final Uri a;
    public final long b;
    public final int c;
    public final byte[] d;
    public final Map<String, String> e;
    public final long f;
    public final long g;
    public final String h;
    public final int i;
    public final Object j;

    static class a {
    }

    public static final class b {

        private Uri a;
        private long b;
        private int c;
        private byte[] d;
        private Map<String, String> e;
        private long f;
        private long g;
        private String h;
        private int i;
        private Object j;
        public b() {
            super();
            this.c = 1;
            this.e = Collections.emptyMap();
            this.g = -1;
        }

        private b(com.google.android.exoplayer2.upstream.n n) {
            super();
            this.a = n.a;
            this.b = n.b;
            this.c = n.c;
            this.d = n.d;
            this.e = n.e;
            this.f = n.f;
            this.g = n.g;
            this.h = n.h;
            this.i = n.i;
            this.j = n.j;
        }

        b(com.google.android.exoplayer2.upstream.n n, com.google.android.exoplayer2.upstream.n.a n$a2) {
            super(n);
        }

        public com.google.android.exoplayer2.upstream.n a() {
            final Object obj = this;
            g.i(obj.a, "The uri must be set.");
            super(obj.a, obj.b, obj6, obj.c, obj.d, obj.e, obj.f, obj11, obj.g, obj13, obj.h, obj.i, obj.j, 0);
            return nVar;
        }

        public com.google.android.exoplayer2.upstream.n.b b(int i) {
            this.i = i;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b c(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b d(int i) {
            this.c = i;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b e(Map<String, String> map) {
            this.e = map;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b f(String string) {
            this.h = string;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b g(long l) {
            this.g = l;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b h(long l) {
            this.f = l;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b i(Uri uri) {
            this.a = uri;
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b j(String string) {
            this.a = Uri.parse(string);
            return this;
        }

        public com.google.android.exoplayer2.upstream.n.b k(long l) {
            this.b = l;
            return this;
        }
    }
    private n(Uri uri, long l2, int i3, byte[] b4Arr4, Map<String, String> map5, long l6, long l7, String string8, int i9, Object object10) {
        int length;
        int i5;
        int i2;
        int i6;
        int cmp;
        int i;
        int i4;
        final Object obj = this;
        int i7 = l2;
        i5 = map5;
        final int i10 = l7;
        final int i11 = i9;
        super();
        i4 = 0;
        i = 1;
        final int i13 = 0;
        i2 = Long.compare(i12, i4) >= 0 ? i : i13;
        g.a(i2);
        i6 = Long.compare(i10, i4) >= 0 ? i : i13;
        g.a(i6);
        if (Long.compare(i11, i4) <= 0) {
            if (Long.compare(i11, i4) == 0) {
            } else {
                i = i13;
            }
        }
        g.a(i);
        obj.a = uri;
        obj.b = i7;
        obj.c = b4Arr4;
        if (i5 != 0 && i5.length != 0) {
            if (i5.length != 0) {
            } else {
                i5 = length;
            }
        } else {
        }
        obj.d = i5;
        HashMap hashMap = new HashMap(l6);
        obj.e = Collections.unmodifiableMap(hashMap);
        obj.f = i10;
        obj.g = i11;
        obj.h = obj24;
        obj.i = obj25;
        obj.j = obj26;
    }

    n(Uri uri, long l2, int i3, byte[] b4Arr4, Map map5, long l6, long l7, String string8, int i9, Object object10, com.google.android.exoplayer2.upstream.n.a n$a11) {
        super(uri, l2, i3, b4Arr4, map5, l6, l7, string8, i9, object10, a11, obj12, obj13);
    }

    public n(Uri uri, long l2, long l3) {
        super(uri, 0, obj3, 1, 0, Collections.emptyMap(), l2, obj8, obj18, obj10, 0, 0, 0);
    }

    public static String c(int i) {
        if (i != 1 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return "HEAD";
                }
                IllegalStateException obj1 = new IllegalStateException();
                throw obj1;
            }
            return "POST";
        }
        return "GET";
    }

    public com.google.android.exoplayer2.upstream.n.b a() {
        n.b bVar = new n.b(this, 0);
        return bVar;
    }

    public final String b() {
        return n.c(this.c);
    }

    public boolean d(int i) {
        int obj2;
        obj2 = i2 &= i == i ? 1 : 0;
        return obj2;
    }

    public com.google.android.exoplayer2.upstream.n e(long l) {
        int i;
        final long l2 = this.g;
        if (Long.compare(l2, i) == 0) {
        } else {
            i = l2 - l;
        }
        return f(l, obj7);
    }

    public com.google.android.exoplayer2.upstream.n f(long l, long l2) {
        int cmp;
        final Object obj = this;
        if (Long.compare(l, i) == 0 && Long.compare(l3, obj20) == 0) {
            if (Long.compare(l3, obj20) == 0) {
                return obj;
            }
        }
        super(obj.a, obj.b, obj6, obj.c, obj.d, obj.e, l4 + l, obj11, obj20, obj13, obj.h, obj.i, obj.j);
        return nVar;
    }

    public String toString() {
        String str = b();
        String valueOf = String.valueOf(this.a);
        final String str5 = this.h;
        StringBuilder stringBuilder = new StringBuilder(i3 += length3);
        stringBuilder.append("DataSpec[");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf);
        String str3 = ", ";
        stringBuilder.append(str3);
        stringBuilder.append(this.f);
        stringBuilder.append(str3);
        stringBuilder.append(this.g);
        stringBuilder.append(str3);
        stringBuilder.append(str5);
        stringBuilder.append(str3);
        stringBuilder.append(this.i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
