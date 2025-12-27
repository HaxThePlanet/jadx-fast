package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import d.h.l.u;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class c extends o {

    private static final String[] e0;
    private static final Property<Drawable, PointF> f0 = new c$b<>();
    private static final Property<c.k, PointF> g0 = new c$c<>();
    private static final Property<c.k, PointF> h0 = new c$d<>();
    private static final Property<View, PointF> i0 = new c$e<>();
    private static final Property<View, PointF> j0 = new c$f<>();
    private static final Property<View, PointF> k0 = new c$g<>();
    private static k l0;
    private int[] b0;
    private boolean c0 = false;
    private boolean d0 = false;

    class a extends AnimatorListenerAdapter {

        final /* synthetic */ ViewGroup a;
        final /* synthetic */ BitmapDrawable b;
        final /* synthetic */ View c;
        final /* synthetic */ float d;
        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.a = viewGroup;
            this.b = bitmapDrawable;
            this.c = view;
            this.d = f;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            f0.b(this.a).b(this.b);
            f0.g(this.c, this.d);
        }
    }

    static class b extends Property<Drawable, PointF> {

        private Rect a = new Rect();
        b(Class cls, String str) {
            super(cls, str);
            final Rect rect = new Rect();
        }

        @Override // android.util.Property
        public PointF a(Drawable drawable) {
            drawable.copyBounds(this.a);
            return new PointF((float)rect2.left, (float)rect2.top);
        }

        @Override // android.util.Property
        public void b(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    static class c extends Property<c.k, PointF> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void b(c.k kVar, PointF pointF) {
            kVar.c(pointF);
        }

        @Override // android.util.Property
        public PointF a(c.k kVar) {
            return null;
        }
    }

    static class d extends Property<c.k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void b(c.k kVar, PointF pointF) {
            kVar.a(pointF);
        }

        @Override // android.util.Property
        public PointF a(c.k kVar) {
            return null;
        }
    }

    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void b(View view, PointF pointF) {
            f0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }

        @Override // android.util.Property
        public PointF a(View view) {
            return null;
        }
    }

    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void b(View view, PointF pointF) {
            f0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }

        @Override // android.util.Property
        public PointF a(View view) {
            return null;
        }
    }

    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void b(View view, PointF pointF) {
            int rounded = Math.round(pointF.x);
            int rounded2 = Math.round(pointF.y);
            f0.f(view, rounded, rounded2, view.getWidth() + rounded, view.getHeight() + rounded2);
        }

        @Override // android.util.Property
        public PointF a(View view) {
            return null;
        }
    }

    class h extends AnimatorListenerAdapter {

        final /* synthetic */ c.k a;
        private c.k mViewBounds;
        h(c.k kVar) {
            this.a = kVar;
            super();
            this.mViewBounds = kVar;
        }
    }

    class i extends AnimatorListenerAdapter {

        private boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ Rect c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        i(View view, Rect rect, int i, int i2, int i3, int i4) {
            this.b = view;
            this.c = rect;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                u.r0(this.b, this.c);
                f0.f(this.b, this.d, this.e, this.f, this.g);
            }
        }
    }

    private static class k {

        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;
        k(View view) {
            super();
            this.e = view;
        }

        private void b() {
            f0.f(this.e, this.a, this.b, this.c, this.d);
            int i = 0;
            this.f = i;
            this.g = i;
        }

        void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                b();
            }
        }
    }

    class j extends p {

        boolean a = false;
        final /* synthetic */ ViewGroup b;
        j(ViewGroup viewGroup) {
            this.b = viewGroup;
            super();
        }

        @Override // d.u.p
        public void onTransitionCancel(o oVar) {
            a0.c(this.b, false);
            this.a = true;
        }

        @Override // d.u.p
        public void onTransitionEnd(o oVar) {
            if (!this.a) {
                boolean z2 = false;
                a0.c(this.b, z2);
            }
            oVar.S(this);
        }

        @Override // d.u.p
        public void onTransitionPause(o oVar) {
            a0.c(this.b, false);
        }

        @Override // d.u.p
        public void onTransitionResume(o oVar) {
            a0.c(this.b, true);
        }
    }
    static {
        c.e0 = new String[] { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
        c.l0 = new k();
    }

    public c() {
        super();
        this.b0 = new int[2];
    }

    private void h0(u uVar) {
        android.view.ViewParent parent;
        String str;
        if (u.R(uVar.b) || uVar.b.getWidth() == 0 || uVar.b.getHeight() != 0) {
            uVar.a.put("android:changeBounds:bounds", new Rect(uVar.b.getLeft(), uVar.b.getTop(), uVar.b.getRight(), uVar.b.getBottom()));
            str = "android:changeBounds:parent";
            uVar.a.put(str, uVar.b.getParent());
            if (this.d0) {
                uVar.b.getLocationInWindow(this.b0);
                uVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.b0[0]));
                str = "android:changeBounds:windowY";
                uVar.a.put(str, Integer.valueOf(this.b0[1]));
            }
            if (this.c0) {
                uVar.a.put("android:changeBounds:clip", u.u(uVar.b));
            }
        }
    }

    private boolean i0(View view, View view2) {
        boolean z2 = true;
        View view3;
        z2 = true;
        if (this.d0) {
            d.u.u uVar = w(view, true);
            int i = 0;
            if (uVar != null || view != view2) {
            }
        }
        return z2;
    }

    @Override // d.u.o
    public String[] G() {
        return c.e0;
    }

    @Override // d.u.o
    public void f(u uVar) {
        h0(uVar);
    }

    @Override // d.u.o
    public void j(u uVar) {
        h0(uVar);
    }

    @Override // d.u.o
    public Animator n(ViewGroup viewGroup, u uVar, u uVar2) {
        Animator animator;
        int value2 = 0;
        Rect rect;
        Object viewGroup2;
        Object obj = null;
        int i2 = 0;
        boolean equals;
        int top2;
        float f2;
        int left2;
        View view;
        int i3;
        Object obj2 = null;
        float f3;
        boolean equals2;
        final Object viewGroup5 = this;
        Object uVar22 = uVar;
        Object uVar32 = uVar2;
        return null;
    }
}
