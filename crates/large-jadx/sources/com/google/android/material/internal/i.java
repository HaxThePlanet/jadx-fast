package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import f.c.a.e.a0.d;
import f.c.a.e.a0.f;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class i {

    private final TextPaint a;
    private final f b;
    private float c;
    private boolean d = true;
    private WeakReference<com.google.android.material.internal.i.b> e;
    private d f;

    public interface b {
        public abstract void a();

        public abstract int[] getState();

        public abstract boolean onStateChange(int[] iArr);
    }

    class a extends f {

        final com.google.android.material.internal.i a;
        a(com.google.android.material.internal.i i) {
            this.a = i;
            super();
        }

        @Override // f.c.a.e.a0.f
        public void a(int i) {
            i.a(this.a, true);
            Object obj2 = i.b(this.a).get();
            if ((i.b)obj2 != null) {
                (i.b)obj2.a();
            }
        }

        @Override // f.c.a.e.a0.f
        public void b(Typeface typeface, boolean z2) {
            if (z2) {
            }
            i.a(this.a, true);
            Object obj1 = i.b(this.a).get();
            if ((i.b)obj1 != null) {
                (i.b)obj1.a();
            }
        }
    }
    public i(com.google.android.material.internal.i.b i$b) {
        super();
        TextPaint textPaint = new TextPaint(1);
        this.a = textPaint;
        i.a aVar = new i.a(this);
        this.b = aVar;
        WeakReference weakReference = new WeakReference(0);
        this.e = weakReference;
        g(b);
    }

    static boolean a(com.google.android.material.internal.i i, boolean z2) {
        i.d = z2;
        return z2;
    }

    static WeakReference b(com.google.android.material.internal.i i) {
        return i.e;
    }

    private float c(java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    public d d() {
        return this.f;
    }

    public TextPaint e() {
        return this.a;
    }

    public float f(String string) {
        if (!this.d) {
            return this.c;
        }
        float obj2 = c(string);
        this.c = obj2;
        this.d = false;
        return obj2;
    }

    public void g(com.google.android.material.internal.i.b i$b) {
        WeakReference weakReference = new WeakReference(b);
        this.e = weakReference;
    }

    public void h(d d, Context context2) {
        Object dVar;
        Object state;
        f fVar2;
        Object fVar;
        Object obj3;
        Context obj4;
        this.f = d;
        d.o(context2, this.a, this.b);
        state = this.e.get();
        if (this.f != d && d != null && (i.b)state != null) {
            this.f = d;
            if (d != null) {
                d.o(context2, this.a, this.b);
                state = this.e.get();
                if ((i.b)(i.b)state != null) {
                    fVar.drawableState = (i.b)(i.b)state.getState();
                }
                d.n(context2, this.a, this.b);
                this.d = true;
            }
            obj3 = this.e.get();
            if ((i.b)obj3 != null) {
                (i.b)obj3.a();
                obj3.onStateChange(obj3.getState());
            }
        }
    }

    public void i(boolean z) {
        this.d = z;
    }

    public void j(Context context) {
        this.f.n(context, this.a, this.b);
    }
}
