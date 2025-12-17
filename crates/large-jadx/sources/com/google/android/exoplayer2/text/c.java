package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;
import android.text.SpannedString;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.g;
import com.google.common.base.k;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes2.dex */
public final class c {

    public static final com.google.android.exoplayer2.text.c r;
    public final java.lang.CharSequence a;
    public final Layout.Alignment b;
    public final Layout.Alignment c;
    public final Bitmap d;
    public final float e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;
    public final float j;
    public final float k;
    public final boolean l;
    public final int m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;

    static class a {
    }

    public static final class b {

        private java.lang.CharSequence a;
        private Bitmap b;
        private Layout.Alignment c;
        private Layout.Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private int j;
        private float k;
        private float l;
        private float m;
        private boolean n;
        private int o;
        private int p;
        private float q;
        public b() {
            super();
            int i = 0;
            this.a = i;
            this.b = i;
            this.c = i;
            this.d = i;
            int i2 = -8388609;
            this.e = i2;
            final int i5 = Integer.MIN_VALUE;
            this.f = i5;
            this.g = i5;
            this.h = i2;
            this.i = i5;
            this.j = i5;
            this.k = i2;
            this.l = i2;
            this.m = i2;
            this.n = false;
            this.o = -16777216;
            this.p = i5;
        }

        private b(com.google.android.exoplayer2.text.c c) {
            super();
            this.a = c.a;
            this.b = c.d;
            this.c = c.b;
            this.d = c.c;
            this.e = c.e;
            this.f = c.f;
            this.g = c.g;
            this.h = c.h;
            this.i = c.i;
            this.j = c.n;
            this.k = c.o;
            this.l = c.j;
            this.m = c.k;
            this.n = c.l;
            this.o = c.m;
            this.p = c.p;
            this.q = c.q;
        }

        b(com.google.android.exoplayer2.text.c c, com.google.android.exoplayer2.text.c.a c$a2) {
            super(c);
        }

        public com.google.android.exoplayer2.text.c a() {
            final Object obj = this;
            super(obj.a, obj.c, obj.d, obj.b, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.o, obj.p, obj.q, 0);
            return cVar3;
        }

        public com.google.android.exoplayer2.text.c.b b() {
            this.n = false;
            return this;
        }

        @Pure
        public int c() {
            return this.g;
        }

        @Pure
        public int d() {
            return this.i;
        }

        @Pure
        public java.lang.CharSequence e() {
            return this.a;
        }

        public com.google.android.exoplayer2.text.c.b f(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b g(float f) {
            this.m = f;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b h(float f, int i2) {
            this.e = f;
            this.f = i2;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b i(int i) {
            this.g = i;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b j(Layout.Alignment layout$Alignment) {
            this.d = alignment;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b k(float f) {
            this.h = f;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b l(int i) {
            this.i = i;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b m(float f) {
            this.q = f;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b n(float f) {
            this.l = f;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b o(java.lang.CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b p(Layout.Alignment layout$Alignment) {
            this.c = alignment;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b q(float f, int i2) {
            this.k = f;
            this.j = i2;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b r(int i) {
            this.p = i;
            return this;
        }

        public com.google.android.exoplayer2.text.c.b s(int i) {
            this.o = i;
            this.n = true;
            return this;
        }
    }
    static {
        c.b bVar = new c.b();
        bVar.o("");
        c.r = bVar.a();
        com.google.android.exoplayer2.text.a aVar = a.a;
    }

    private c(java.lang.CharSequence charSequence, Layout.Alignment layout$Alignment2, Layout.Alignment layout$Alignment3, Bitmap bitmap4, float f5, int i6, int i7, float f8, int i9, int i10, float f11, float f12, float f13, boolean z14, int i15, int i16, float f17) {
        SpannedString valueOf;
        int i;
        final Object obj = this;
        Object obj2 = charSequence;
        final Bitmap bitmap = bitmap4;
        super();
        if (obj2 == null) {
            g.e(bitmap4);
        } else {
            i = bitmap == null ? 1 : 0;
            g.a(i);
        }
        if (obj2 instanceof Spanned) {
            obj.a = SpannedString.valueOf(charSequence);
        } else {
            if (obj2 != null) {
                obj.a = charSequence.toString();
            } else {
                obj.a = null;
            }
        }
        obj.b = alignment2;
        obj.c = alignment3;
        obj.d = bitmap;
        obj.e = f5;
        obj.f = i6;
        obj.g = i7;
        obj.h = f8;
        obj.i = i9;
        obj.j = f12;
        obj.k = f13;
        obj.l = z14;
        obj.m = i15;
        obj.n = i10;
        obj.o = f11;
        obj.p = i16;
        obj.q = f17;
    }

    c(java.lang.CharSequence charSequence, Layout.Alignment layout$Alignment2, Layout.Alignment layout$Alignment3, Bitmap bitmap4, float f5, int i6, int i7, float f8, int i9, int i10, float f11, float f12, float f13, boolean z14, int i15, int i16, float f17, com.google.android.exoplayer2.text.c.a c$a18) {
        super(charSequence, alignment2, alignment3, bitmap4, f5, i6, i7, f8, i9, i10, f11, f12, f13, z14, i15, i16, f17);
    }

    public com.google.android.exoplayer2.text.c.b a() {
        c.b bVar = new c.b(this, 0);
        return bVar;
    }

    public boolean equals(Object object) {
        int i;
        Bitmap sameAs;
        Class<com.google.android.exoplayer2.text.c> obj;
        Object charSequence;
        Class class;
        int obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (c.class != object.getClass()) {
            } else {
                if (TextUtils.equals(this.a, object.a) && this.b == object.b && this.c == object.c) {
                    if (this.b == object.b) {
                        if (this.c == object.c) {
                            sameAs = this.d;
                            if (sameAs == null) {
                                if (object.d == null) {
                                    if (Float.compare(f, charSequence) == 0) {
                                        if (this.f == object.f) {
                                            if (this.g == object.g) {
                                                if (Float.compare(f2, charSequence) == 0) {
                                                    if (this.i == object.i) {
                                                        if (Float.compare(f3, charSequence) == 0) {
                                                            if (Float.compare(f4, charSequence) == 0) {
                                                                if (this.l == object.l) {
                                                                    if (this.m == object.m) {
                                                                        if (this.n == object.n) {
                                                                            if (Float.compare(f5, charSequence) == 0) {
                                                                                if (this.p == object.p) {
                                                                                    if (Float.compare(sameAs, obj5) == 0) {
                                                                                    } else {
                                                                                        i = i2;
                                                                                    }
                                                                                } else {
                                                                                }
                                                                            } else {
                                                                            }
                                                                        } else {
                                                                        }
                                                                    } else {
                                                                    }
                                                                } else {
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                                charSequence = object.d;
                                if (charSequence != null && sameAs.sameAs(charSequence) && Float.compare(f, charSequence) == 0 && this.f == object.f && this.g == object.g && Float.compare(f2, charSequence) == 0 && this.i == object.i && Float.compare(f3, charSequence) == 0 && Float.compare(f4, charSequence) == 0 && this.l == object.l && this.m == object.m && this.n == object.n && Float.compare(f5, charSequence) == 0 && this.p == object.p && Float.compare(sameAs, obj5) == 0) {
                                    if (sameAs.sameAs(charSequence)) {
                                    } else {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        Object[] arr = new Object[17];
        return k.b(this.a, this.b, this.c, this.d, Float.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Float.valueOf(this.h), Integer.valueOf(this.i), Float.valueOf(this.j), Float.valueOf(this.k), Boolean.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Float.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.q));
    }
}
