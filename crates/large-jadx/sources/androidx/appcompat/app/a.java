package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.a.j;
import d.a.o.b;
import d.a.o.b.a;

/* loaded from: classes.dex */
public abstract class a {

    public static class a extends ViewGroup.MarginLayoutParams {

        public int a;
        public a(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.a = 8388627;
        }

        public a(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            final int i = 0;
            this.a = i;
            final TypedArray obj3 = context.obtainStyledAttributes(attributeSet2, j.t);
            this.a = obj3.getInt(j.u, i);
            obj3.recycle();
        }

        public a(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public a(androidx.appcompat.app.a.a a$a) {
            super(a);
            this.a = 0;
            this.a = a.a;
        }
    }

    public interface b {
        public abstract void a(boolean z);
    }

    @Deprecated
    public static abstract class c {
        public abstract java.lang.CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract java.lang.CharSequence d();

        public abstract void e();
    }
    public boolean g() {
        return 0;
    }

    public abstract boolean h();

    public abstract void i(boolean z);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return 0;
    }

    public void m(Configuration configuration) {
    }

    void n() {
    }

    public abstract boolean o(int i, KeyEvent keyEvent2);

    public boolean p(KeyEvent keyEvent) {
        return 0;
    }

    public boolean q() {
        return 0;
    }

    public abstract void r(boolean z);

    public abstract void s(boolean z);

    public abstract void t(boolean z);

    public abstract void u(java.lang.CharSequence charSequence);

    public abstract void v(java.lang.CharSequence charSequence);

    public b w(b.a b$a) {
        return null;
    }
}
