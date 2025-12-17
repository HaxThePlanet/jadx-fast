package com.skydoves.balloon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import kotlin.d0.d.n;
import kotlin.e0.a;

/* loaded from: classes2.dex */
public final class m {

    private final Drawable a;
    private Integer b;
    private final com.skydoves.balloon.n c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public static final class a {

        public Drawable a;
        public Integer b;
        public com.skydoves.balloon.n c;
        public int d;
        public int e;
        public int f;
        public int g = -1;
        public a(Context context) {
            n.f(context, "context");
            super();
            this.c = n.START;
            float obj4 = (float)obj4;
            Resources system = Resources.getSystem();
            final String str2 = "Resources.getSystem()";
            n.e(system, str2);
            final int i2 = 1;
            this.d = a.b(TypedValue.applyDimension(i2, obj4, system.getDisplayMetrics()));
            Resources system2 = Resources.getSystem();
            n.e(system2, str2);
            this.e = a.b(TypedValue.applyDimension(i2, obj4, system2.getDisplayMetrics()));
            Resources system3 = Resources.getSystem();
            n.e(system3, str2);
            this.f = a.b(TypedValue.applyDimension(i2, (float)obj4, system3.getDisplayMetrics()));
            obj4 = -1;
        }

        public final com.skydoves.balloon.m a() {
            m mVar = new m(this);
            return mVar;
        }

        public final com.skydoves.balloon.m.a b(Drawable drawable) {
            this.a = drawable;
            return this;
        }

        public final com.skydoves.balloon.m.a c(com.skydoves.balloon.n n) {
            n.f(n, "value");
            this.c = n;
            return this;
        }

        public final com.skydoves.balloon.m.a d(int i) {
            this.g = i;
            return this;
        }

        public final com.skydoves.balloon.m.a e(int i) {
            this.e = i;
            return this;
        }

        public final com.skydoves.balloon.m.a f(int i) {
            this.f = i;
            return this;
        }

        public final com.skydoves.balloon.m.a g(int i) {
            this.d = i;
            return this;
        }
    }
    public m(com.skydoves.balloon.m.a m$a) {
        n.f(a, "builder");
        super();
        this.a = a.a;
        this.b = a.b;
        this.c = a.c;
        this.d = a.d;
        this.e = a.e;
        this.f = a.f;
        this.g = a.g;
    }

    public final Drawable a() {
        return this.a;
    }

    public final Integer b() {
        return this.b;
    }

    public final int c() {
        return this.g;
    }

    public final com.skydoves.balloon.n d() {
        return this.c;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.d;
    }
}
