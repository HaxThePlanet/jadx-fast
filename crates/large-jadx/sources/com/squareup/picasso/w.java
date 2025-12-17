package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class w {

    private static final long u;
    int a;
    long b;
    int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List<com.squareup.picasso.e0> g;
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
    public final com.squareup.picasso.t.f t;

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
        private List<com.squareup.picasso.e0> o;
        private Bitmap.Config p;
        private com.squareup.picasso.t.f q;
        b(Uri uri, int i2, Bitmap.Config bitmap$Config3) {
            super();
            this.a = uri;
            this.b = i2;
            this.p = config3;
        }

        public com.squareup.picasso.w a() {
            boolean z3;
            com.squareup.picasso.t.f nORMAL;
            boolean z;
            boolean z2;
            final Object obj = this;
            z3 = obj.h;
            if (z3) {
                if (obj.f) {
                } else {
                }
                IllegalStateException illegalStateException = new IllegalStateException("Center crop and center inside can not be used together.");
                throw illegalStateException;
            }
            if (obj.f && obj.d == 0) {
                if (obj.d == 0) {
                    if (obj.e == 0) {
                    } else {
                    }
                    IllegalStateException illegalStateException3 = new IllegalStateException("Center crop requires calling resize with positive width and height.");
                    throw illegalStateException3;
                }
            }
            if (z3 && obj.d == 0) {
                if (obj.d == 0) {
                    if (obj.e == 0) {
                    } else {
                    }
                    IllegalStateException illegalStateException2 = new IllegalStateException("Center inside requires calling resize with positive width and height.");
                    throw illegalStateException2;
                }
            }
            if (obj.q == null) {
                obj.q = t.f.NORMAL;
            }
            super(obj.a, obj.b, obj.c, obj.o, obj.d, obj.e, obj.f, obj.h, obj.g, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.p, obj.q, 0);
            return wVar;
        }

        public com.squareup.picasso.w.b b(int i) {
            if (this.h) {
            } else {
                this.f = true;
                this.g = i;
                return this;
            }
            IllegalStateException obj2 = new IllegalStateException("Center crop can not be used after calling centerInside");
            throw obj2;
        }

        boolean c() {
            int i;
            Uri uri;
            if (this.a == null) {
                if (this.b != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        boolean d() {
            int i;
            int i2;
            if (this.d == 0) {
                if (this.e != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public com.squareup.picasso.w.b e(int i, int i2) {
            if (i < 0) {
            } else {
                if (i2 < 0) {
                } else {
                    if (i2 == 0) {
                        if (i == 0) {
                        } else {
                        }
                        IllegalArgumentException obj1 = new IllegalArgumentException("At least one dimension has to be positive number.");
                        throw obj1;
                    }
                    this.d = i;
                    this.e = i2;
                    return this;
                }
                obj1 = new IllegalArgumentException("Height must be positive number or 0.");
                throw obj1;
            }
            obj1 = new IllegalArgumentException("Width must be positive number or 0.");
            throw obj1;
        }

        public com.squareup.picasso.w.b f(com.squareup.picasso.e0 e0) {
            Object arrayList;
            int i;
            if (e0 == null) {
            } else {
                if (e0.key() == null) {
                } else {
                    if (this.o == null) {
                        arrayList = new ArrayList(2);
                        this.o = arrayList;
                    }
                    this.o.add(e0);
                    return this;
                }
                IllegalArgumentException obj3 = new IllegalArgumentException("Transformation key must not be null.");
                throw obj3;
            }
            obj3 = new IllegalArgumentException("Transformation must not be null.");
            throw obj3;
        }
    }
    static {
        w.u = TimeUnit.SECONDS.toNanos(5);
    }

    private w(Uri uri, int i2, String string3, List<com.squareup.picasso.e0> list4, int i5, int i6, boolean z7, boolean z8, int i9, boolean z10, float f11, float f12, float f13, boolean z14, boolean z15, Bitmap.Config bitmap$Config16, com.squareup.picasso.t.f t$f17) {
        int unmodifiableList;
        final Object obj = this;
        super();
        obj.d = uri;
        obj.e = i2;
        obj.f = string3;
        if (list4 == null) {
            obj.g = 0;
        } else {
            obj.g = Collections.unmodifiableList(list4);
        }
        obj.h = i5;
        obj.i = i6;
        obj.j = z7;
        obj.l = z8;
        obj.k = i9;
        obj.m = z10;
        obj.n = f11;
        obj.o = f12;
        obj.p = f13;
        obj.q = z14;
        obj.r = z15;
        obj.s = config16;
        obj.t = f17;
    }

    w(Uri uri, int i2, String string3, List list4, int i5, int i6, boolean z7, boolean z8, int i9, boolean z10, float f11, float f12, float f13, boolean z14, boolean z15, Bitmap.Config bitmap$Config16, com.squareup.picasso.t.f t$f17, com.squareup.picasso.w.a w$a18) {
        super(uri, i2, string3, list4, i5, i6, z7, z8, i9, z10, f11, f12, f13, z14, z15, config16, f17);
    }

    String a() {
        Uri uri = this.d;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.e);
    }

    boolean b() {
        int i;
        i = this.g != null ? 1 : 0;
        return i;
    }

    public boolean c() {
        int i2;
        int i;
        if (this.h == 0) {
            if (this.i != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    String d() {
        nanoTime -= l;
        int i3 = 43;
        if (Long.compare(i, l2) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(g());
            stringBuilder.append(i3);
            stringBuilder.append(TimeUnit.NANOSECONDS.toSeconds(i));
            stringBuilder.append('s');
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(g());
        stringBuilder2.append(i3);
        stringBuilder2.append(TimeUnit.NANOSECONDS.toMillis(i));
        stringBuilder2.append("ms");
        return stringBuilder2.toString();
    }

    boolean e() {
        int i;
        boolean cmp;
        int i2;
        if (!c()) {
            if (Float.compare(f, i2) != 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    boolean f() {
        int i;
        boolean z;
        if (!e()) {
            if (b()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    String g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[R");
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString() {
        int i;
        List iterator;
        String str3;
        int i2;
        boolean str4;
        boolean str;
        boolean cmp;
        boolean str2;
        Bitmap.Config config;
        String next;
        StringBuilder stringBuilder = new StringBuilder("Request{");
        i = this.e;
        if (i > 0) {
            stringBuilder.append(i);
        } else {
            stringBuilder.append(this.d);
        }
        iterator = this.g;
        final int i5 = 32;
        if (iterator != null && !iterator.isEmpty()) {
            if (!iterator.isEmpty()) {
                iterator = this.g.iterator();
                for (e0 next2 : iterator) {
                    stringBuilder.append(i5);
                    stringBuilder.append(next2.key());
                }
            }
        }
        int i6 = 41;
        if (this.f != null) {
            stringBuilder.append(" stableKey(");
            stringBuilder.append(this.f);
            stringBuilder.append(i6);
        }
        final int i7 = 44;
        if (this.h > 0) {
            stringBuilder.append(" resize(");
            stringBuilder.append(this.h);
            stringBuilder.append(i7);
            stringBuilder.append(this.i);
            stringBuilder.append(i6);
        }
        if (this.j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.l) {
            stringBuilder.append(" centerInside");
        }
        stringBuilder.append(" rotation(");
        stringBuilder.append(this.n);
        if (Float.compare(f, i8) != 0 && this.q) {
            stringBuilder.append(" rotation(");
            stringBuilder.append(this.n);
            if (this.q) {
                stringBuilder.append(" @ ");
                stringBuilder.append(this.o);
                stringBuilder.append(i7);
                stringBuilder.append(this.p);
            }
            stringBuilder.append(i6);
        }
        if (this.r) {
            stringBuilder.append(" purgeable");
        }
        if (this.s != null) {
            stringBuilder.append(i5);
            stringBuilder.append(this.s);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
