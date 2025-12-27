package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request.java */
/* loaded from: classes2.dex */
public final class w {

    private static final long u = 0L;
    int a;
    long b;
    int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List<e0> g;
    public final int h;
    public final int i;
    public final boolean j;
    public final int k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;
    public final boolean q;
    public final boolean r;
    public final Bitmap.Config s;
    public final t.f t;

    static class a {
    }

    public static final class b {

        private Uri a;
        private int b;
        private String c;
        private int d;
        private int e;
        private boolean f;
        private int g;
        private boolean h;
        private boolean i;
        private float j;
        private float k;
        private float l;
        private boolean m;
        private boolean n;
        private List<e0> o;
        private Bitmap.Config p;
        private t.f q;
        b(Uri uri, int i, Bitmap.Config config) {
            super();
            this.a = uri;
            this.b = i;
            this.p = config;
        }

        public w a() {
            final Object obj = this;
            if (obj.h) {
                if (obj.f) {
                    throw new IllegalStateException("Center crop and center inside can not be used together.");
                }
            }
            if (obj.f && obj.d == 0) {
                if (obj.e == 0) {
                    throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
                }
            }
            if (obj.h && obj.d == 0) {
                if (obj.e == 0) {
                    throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
                }
            }
            if (obj.q == null) {
                obj.q = t.f.NORMAL;
            }
            w wVar = new w(obj.a, obj.b, obj.c, obj.o, obj.d, obj.e, obj.f, obj.h, obj.g, obj.i, obj.j, obj.k, obj.l, z2, z3, config, fVar, null);
            return wVar;
        }

        public w.b b(int i) {
            if (this.h) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            } else {
                this.f = true;
                this.g = i;
                return this;
            }
        }

        boolean c() {
            boolean z = false;
            if (this.a != null || this.b != 0) {
                int i3 = 1;
            }
            return z;
        }

        boolean d() {
            boolean z = false;
            if (this.d != 0 || this.e != 0) {
                int i3 = 1;
            }
            return z;
        }

        public w.b e(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else {
                if (i2 < 0) {
                    throw new IllegalArgumentException("Height must be positive number or 0.");
                } else {
                    this.d = i;
                    this.e = i2;
                    return this;
                }
            }
        }

        public w.b f(e0 e0Var) {
            if (e0Var == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else {
                if (e0Var.key() == null) {
                    throw new IllegalArgumentException("Transformation key must not be null.");
                } else {
                    if (this.o == null) {
                        int i = 2;
                        this.o = new ArrayList(i);
                    }
                    this.o.add(e0Var);
                    return this;
                }
            }
        }
    }
    static {
        w.u = TimeUnit.SECONDS.toNanos(5L);
    }

    /* synthetic */ w(Uri uri, int i, String str, List list, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, float f, float f2, float f3, boolean z4, boolean z5, Bitmap.Config config, t.f fVar, w.a aVar) {
        this(uri, i, str, list, i2, i3, z, z2, i4, z3, f, f2, f3, z4, z5, config, fVar);
    }

    String a() {
        if (this.d != null) {
            return String.valueOf(this.d.getPath());
        }
        return Integer.toHexString(this.e);
    }

    boolean b() {
        boolean z = true;
        int r0 = this.g != null ? 1 : 0;
        return (this.g != null ? 1 : 0);
    }

    public boolean c() {
        boolean z = false;
        if (this.h != 0 || this.i != 0) {
            int i3 = 1;
        }
        return z;
    }

    String d() {
        long l = System.nanoTime() - this.b;
        long l3 = w.u;
        char c = '+';
        if (l > w.u) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = g();
            long seconds = TimeUnit.NANOSECONDS.toSeconds(l);
            str = str4 + c + seconds + 115;
            return str;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str5 = g();
        long millis = TimeUnit.NANOSECONDS.toMillis(l);
        String str2 = "ms";
        str3 = str5 + c + millis + str2;
        return str3;
    }

    boolean e() {
        boolean z2 = false;
        float f = 0;
        if (!c()) {
            f = 0.0f;
            if (this.n != 0.0f) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z2;
    }

    boolean f() {
        boolean z2 = false;
        if (e() || this.b()) {
            int i2 = 1;
        }
        return z2;
    }

    String g() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "[R";
        str = str2 + this.a + 93;
        return str;
    }

    public String toString() {
        boolean z3;
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.e > 0) {
            stringBuilder.append(this.e);
        } else {
            stringBuilder.append(this.d);
        }
        final char c = ' ';
        if (this.g != null && !this.g.isEmpty()) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                stringBuilder.append(c);
                stringBuilder.append((e0)it.next().key());
            }
        }
        char c2 = ')';
        if (this.f != null) {
            stringBuilder.append(" stableKey(");
            stringBuilder.append(this.f);
            stringBuilder.append(c2);
        }
        final char c3 = ',';
        if (this.h > 0) {
            stringBuilder.append(" resize(");
            stringBuilder.append(this.h);
            stringBuilder.append(c3);
            stringBuilder.append(this.i);
            stringBuilder.append(c2);
        }
        if (this.j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.l) {
            stringBuilder.append(" centerInside");
        }
        if (this.n != 0) {
            stringBuilder.append(" rotation(");
            stringBuilder.append(this.n);
            if (this.q) {
                stringBuilder.append(" @ ");
                stringBuilder.append(this.o);
                stringBuilder.append(c3);
                stringBuilder.append(this.p);
            }
            stringBuilder.append(c2);
        }
        if (this.r) {
            stringBuilder.append(" purgeable");
        }
        if (this.s != null) {
            stringBuilder.append(c);
            stringBuilder.append(this.s);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private w(Uri uri, int i, String str, List<e0> list, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, float f, float f2, float f3, boolean z4, boolean z5, Bitmap.Config config, t.f fVar) {
        final Object uri3 = this;
        super();
        uri3.d = uri;
        uri3.e = i;
        uri3.f = str;
        if (list == null) {
            List unmodifiable = null;
            uri3.g = unmodifiable;
        } else {
            uri3.g = Collections.unmodifiableList(list);
        }
        uri3.h = i2;
        uri3.i = i3;
        uri3.j = z;
        uri3.l = z2;
        uri3.k = i4;
        uri3.m = z3;
        uri3.n = f;
        uri3.o = f2;
        uri3.p = f3;
        uri3.q = z4;
        uri3.r = z5;
        uri3.s = config;
        uri3.t = fVar;
    }
}
