package com.google.android.material.internal;

import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import d.h.k.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
final class h {

    static final int n = 0;
    private static boolean o;
    private static Constructor<StaticLayout> p;
    private static Object q;
    private java.lang.CharSequence a;
    private final TextPaint b;
    private final int c;
    private int d = 0;
    private int e;
    private Layout.Alignment f;
    private int g = Integer.MAX_VALUE;
    private float h = 0f;
    private float i = 1f;
    private int j = 1065353216;
    private boolean k = true;
    private boolean l;
    private TextUtils.TruncateAt m = null;

    static class a extends Exception {
        a(Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error thrown initializing StaticLayout ");
            stringBuilder.append(throwable.getMessage());
            super(stringBuilder.toString(), throwable);
        }
    }
    static {
        if (Build.VERSION.SDK_INT >= 23) {
            int i = 1;
        }
        int i2 = 0;
    }

    private h(java.lang.CharSequence charSequence, TextPaint textPaint2, int i3) {
        super();
        this.a = charSequence;
        this.b = textPaint2;
        this.c = i3;
        final int obj2 = 0;
        this.e = charSequence.length();
        this.f = Layout.Alignment.ALIGN_NORMAL;
        int obj1 = Integer.MAX_VALUE;
        obj1 = 0;
        obj1 = 1065353216;
        obj1 = h.n;
        obj1 = 1;
        obj1 = 0;
    }

    private void b() {
        int i2;
        Object lTR;
        boolean sDK_INT;
        int i;
        String str;
        Class cls;
        Class class;
        String str2;
        if (h.o) {
        }
        int i4 = 0;
        final int i5 = 1;
        if (this.l && Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 23) {
                i2 = i5;
            } else {
                try {
                    i2 = i4;
                    if (Build.VERSION.SDK_INT >= 18) {
                    } else {
                    }
                    cls = TextDirectionHeuristic.class;
                    if (i2 != 0) {
                    } else {
                    }
                    lTR = TextDirectionHeuristics.RTL;
                    lTR = TextDirectionHeuristics.LTR;
                    h.q = lTR;
                    java.lang.ClassLoader classLoader = h.class.getClassLoader();
                    if (this.l) {
                    } else {
                    }
                    str = "RTL";
                    str = "LTR";
                    Class class2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                    h.q = class2.getField(str).get(class2);
                    cls = class;
                    Class[] arr = new Class[13];
                    arr[i4] = CharSequence.class;
                    Class tYPE = Integer.TYPE;
                    arr[i5] = tYPE;
                    arr[2] = tYPE;
                    arr[3] = TextPaint.class;
                    arr[4] = tYPE;
                    arr[5] = Layout.Alignment.class;
                    arr[6] = cls;
                    Class tYPE2 = Float.TYPE;
                    arr[7] = tYPE2;
                    arr[8] = tYPE2;
                    arr[9] = Boolean.TYPE;
                    arr[10] = TextUtils.TruncateAt.class;
                    arr[11] = tYPE;
                    arr[12] = tYPE;
                    Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(arr);
                    h.p = declaredConstructor;
                    declaredConstructor.setAccessible(i5);
                    h.o = i5;
                    h.a aVar = new h.a(th);
                    throw aVar;
                }
            }
        } else {
        }
    }

    public static com.google.android.material.internal.h c(java.lang.CharSequence charSequence, TextPaint textPaint2, int i3) {
        h hVar = new h(charSequence, textPaint2, i3);
        return hVar;
    }

    public StaticLayout a() {
        Object str;
        boolean aLIGN_OPPOSITE;
        android.text.TextDirectionHeuristic rTL;
        int i2;
        java.lang.CharSequence ellipsize;
        int cmp;
        int i;
        float f;
        TextUtils.TruncateAt truncateAt;
        if (this.a == null) {
            this.a = "";
        }
        int i6 = 0;
        int i4 = Math.max(i6, this.c);
        final int i24 = 1;
        if (this.g == i24) {
            ellipsize = TextUtils.ellipsize(this.a, this.b, (float)i4, this.m);
        }
        int i23 = Math.min(ellipsize.length(), this.e);
        this.e = i23;
        final int i28 = 1065353216;
        final int i29 = 0;
        if (Build.VERSION.SDK_INT >= 23 && this.l && this.g == i24) {
            if (this.l) {
                if (this.g == i24) {
                    this.f = Layout.Alignment.ALIGN_OPPOSITE;
                }
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(ellipsize, this.d, i23, this.b, i4);
            obtain.setAlignment(this.f);
            obtain.setIncludePad(this.k);
            rTL = this.l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            obtain.setTextDirection(rTL);
            TextUtils.TruncateAt truncateAt2 = this.m;
            if (truncateAt2 != null) {
                obtain.setEllipsize(truncateAt2);
            }
            obtain.setMaxLines(this.g);
            float f2 = this.h;
            if (Float.compare(f2, i29) == 0) {
                if (Float.compare(f3, i28) != 0) {
                    obtain.setLineSpacing(f2, this.i);
                }
            } else {
            }
            if (this.g > i24) {
                obtain.setHyphenationFrequency(this.j);
            }
            return obtain.build();
        }
        b();
        Constructor constructor = h.p;
        i.c(constructor);
        Object[] arr = new Object[13];
        arr[i6] = ellipsize;
        arr[i24] = Integer.valueOf(this.d);
        arr[2] = Integer.valueOf(this.e);
        arr[3] = this.b;
        arr[4] = Integer.valueOf(i4);
        arr[5] = this.f;
        Object obj = h.q;
        i.c(obj);
        arr[6] = obj;
        arr[7] = Float.valueOf(i28);
        arr[8] = Float.valueOf(i29);
        arr[9] = Boolean.valueOf(this.k);
        arr[10] = 0;
        arr[11] = Integer.valueOf(i4);
        arr[12] = Integer.valueOf(this.g);
        return (StaticLayout)(Constructor)constructor.newInstance(arr);
    }

    public com.google.android.material.internal.h d(Layout.Alignment layout$Alignment) {
        this.f = alignment;
        return this;
    }

    public com.google.android.material.internal.h e(TextUtils.TruncateAt textUtils$TruncateAt) {
        this.m = truncateAt;
        return this;
    }

    public com.google.android.material.internal.h f(int i) {
        this.j = i;
        return this;
    }

    public com.google.android.material.internal.h g(boolean z) {
        this.k = z;
        return this;
    }

    public com.google.android.material.internal.h h(boolean z) {
        this.l = z;
        return this;
    }

    public com.google.android.material.internal.h i(float f, float f2) {
        this.h = f;
        this.i = f2;
        return this;
    }

    public com.google.android.material.internal.h j(int i) {
        this.g = i;
        return this;
    }
}
