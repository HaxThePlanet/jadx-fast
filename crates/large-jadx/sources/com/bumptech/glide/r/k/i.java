package com.bumptech.glide.r.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.i;
import com.bumptech.glide.r.d;
import com.bumptech.glide.t.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class i<T extends View, Z> extends a<Z> {

    private static int x;
    protected final T a;
    private final i.a b = new i$a();
    private View.OnAttachStateChangeListener c;
    private boolean v;
    private boolean w;

    static final class a {

        static Integer e;
        private final View a;
        private final List<g> b = new ArrayList<>();
        boolean c;
        private i.a.a d;
        a(View view) {
            super();
            final ArrayList arrayList = new ArrayList();
            this.a = view;
        }

        private static int c(Context context) {
            if (i.a.e == null) {
                Object systemService = context.getSystemService("window");
                k.d(systemService);
                Point point = new Point();
                systemService.getDefaultDisplay().getSize(point);
                i.a.e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return i.a.e.intValue();
        }

        private int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            final int i5 = 0;
            if (this.c && this.a.isLayoutRequested()) {
                return i5;
            }
            i -= i3;
            if (i6 > 0) {
                return i6;
            }
            if (!this.a.isLayoutRequested() && i2 == -2) {
                final String str2 = "ViewTarget";
                if (Log.isLoggable(str2, 4)) {
                    Log.i(str2, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                }
                return i.a.c(this.a.getContext());
            }
            return i5;
        }

        private int f() {
            int height2 = 0;
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            int r1 = layoutParams != null ? layoutParams.height : 0;
            return this.e(this.a.getHeight(), (layoutParams != null ? layoutParams.height : 0), this.a.getPaddingTop() + this.a.getPaddingBottom());
        }

        private int g() {
            int width2 = 0;
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            int r1 = layoutParams != null ? layoutParams.width : 0;
            return this.e(this.a.getWidth(), (layoutParams != null ? layoutParams.width : 0), this.a.getPaddingLeft() + this.a.getPaddingRight());
        }

        private boolean i(int i, int i2) {
            boolean z2 = false;
            i = h(i) && this.h(i2) ? 1 : 0;
            return (h(i) && this.h(i2) ? 1 : 0);
        }

        private void j(int i, int i2) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                (g)it.next().f(i, i2);
            }
        }

        void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int i = g();
            final int i2 = f();
            if (!i(i, i2)) {
                return;
            }
            j(i, i2);
            b();
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        void d(g gVar) {
            boolean contains;
            int i = g();
            final int i2 = f();
            if (i(i, i2)) {
                gVar.f(i, i2);
                return;
            }
            if (!this.b.contains(gVar)) {
                this.b.add(gVar);
            }
            if (this.d == null) {
                com.bumptech.glide.r.k.i.a.a aVar2 = new i.a.a(this);
                this.d = aVar2;
                this.a.getViewTreeObserver().addOnPreDrawListener(aVar2);
            }
        }

        void k(g gVar) {
            this.b.remove(gVar);
        }

        private boolean h(int i) {
            int i2 = -2147483648;
            boolean z = false;
            if (i > 0 || i == Integer.MIN_VALUE) {
                int i4 = 1;
            }
            return z;
        }
    }
    static {
        i.x = i.a;
    }

    public i(T t) {
        super();
        k.d(t);
        this.a = (View)t;
        com.bumptech.glide.r.k.i.a aVar = new i.a(t);
    }

    private Object c() {
        return this.a.getTag(i.x);
    }

    private void d() {
    }

    private void e() {
    }

    private void f(Object object) {
        this.a.setTag(i.x, object);
    }

    @Override // com.bumptech.glide.r.k.a
    public d getRequest() {
        Object obj = null;
        obj = c();
        if (obj != null) {
            z = obj instanceof d;
            if (!(obj instanceof d)) {
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            } else {
                return obj;
            }
        }
        int i = 0;
    }

    @Override // com.bumptech.glide.r.k.a
    public void getSize(g gVar) {
        this.b.d(gVar);
    }

    @Override // com.bumptech.glide.r.k.a
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.b.b();
        if (!this.v) {
            e();
        }
    }

    @Override // com.bumptech.glide.r.k.a
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        d();
    }

    @Override // com.bumptech.glide.r.k.a
    public void removeCallback(g gVar) {
        this.b.k(gVar);
    }

    @Override // com.bumptech.glide.r.k.a
    public void setRequest(d dVar) {
        f(dVar);
    }

    @Override // com.bumptech.glide.r.k.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Target for: ";
        str = str2 + this.a;
        return str;
    }
}
