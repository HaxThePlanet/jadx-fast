package com.skydoves.balloon;

import android.content.Context;
import android.graphics.Typeface;
import android.text.method.MovementMethod;
import kotlin.d0.d.n;

/* compiled from: TextForm.kt */
/* loaded from: classes2.dex */
public final class y {

    private final java.lang.CharSequence a;
    private final float b;
    private final int c;
    private final boolean d;
    private final MovementMethod e;
    private final int f;
    private final Typeface g;
    private final int h;

    public static final class a {

        public java.lang.CharSequence a = "";
        public float b = 12f;
        public int c = -1;
        public boolean d;
        public MovementMethod e;
        public int f;
        public Typeface g;
        public int h = 17;
        public a(Context context) {
            n.f(context, "context");
            super();
        }

        public final y a() {
            return new y(this);
        }

        public final y.a b(java.lang.CharSequence charSequence) {
            n.f(charSequence, "value");
            this.a = charSequence;
            return this;
        }

        public final y.a c(int i) {
            this.c = i;
            return this;
        }

        public final y.a d(int i) {
            this.h = i;
            return this;
        }

        public final y.a e(boolean z) {
            this.d = z;
            return this;
        }

        public final y.a f(float f) {
            this.b = f;
            return this;
        }

        public final y.a g(int i) {
            this.f = i;
            return this;
        }

        public final y.a h(Typeface typeface) {
            this.g = typeface;
            return this;
        }
    }
    public y(y.a aVar) {
        n.f(aVar, "builder");
        super();
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public final MovementMethod a() {
        return this.e;
    }

    public final java.lang.CharSequence b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.h;
    }

    public final boolean e() {
        return this.d;
    }

    public final float f() {
        return this.b;
    }

    public final int g() {
        return this.f;
    }

    public final Typeface h() {
        return this.g;
    }
}
