package com.bumptech.glide.r.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.i;
import com.bumptech.glide.r.d;
import com.bumptech.glide.t.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
@Deprecated
public abstract class i<T extends View, Z>  extends com.bumptech.glide.r.k.a<Z> {

    private static int x;
    protected final T a;
    private final com.bumptech.glide.r.k.i.a b;
    private View.OnAttachStateChangeListener c;
    private boolean v;
    private boolean w;

    static final class a {

        static Integer e;
        private final View a;
        private final List<com.bumptech.glide.r.k.g> b;
        boolean c;
        private com.bumptech.glide.r.k.i.a.a d;
        a(View view) {
            super();
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.a = view;
        }

        private static int c(Context context) {
            Integer num;
            Integer obj1;
            if (i.a.e == null) {
                obj1 = context.getSystemService("window");
                k.d((WindowManager)obj1);
                Point point = new Point();
                (WindowManager)obj1.getDefaultDisplay().getSize(point);
                i.a.e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return i.a.e.intValue();
        }

        private int e(int i, int i2, int i3) {
            boolean layoutRequested;
            boolean obj3;
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            final int i5 = 0;
            if (this.c && this.a.isLayoutRequested()) {
                if (this.a.isLayoutRequested()) {
                    return i5;
                }
            }
            i -= i3;
            if (obj3 > 0) {
                return obj3;
            }
            final String obj4 = "ViewTarget";
            if (!this.a.isLayoutRequested() && i2 == -2 && Log.isLoggable(obj4, 4)) {
                if (i2 == -2) {
                    obj4 = "ViewTarget";
                    if (Log.isLoggable(obj4, 4)) {
                        Log.i(obj4, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                    }
                    return i.a.c(this.a.getContext());
                }
            }
            return i5;
        }

        private int f() {
            int height;
            android.view.ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            height = layoutParams != null ? layoutParams.height : 0;
            return e(this.a.getHeight(), height, paddingTop += paddingBottom);
        }

        private int g() {
            int width;
            android.view.ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            width = layoutParams != null ? layoutParams.width : 0;
            return e(this.a.getWidth(), width, paddingLeft += paddingRight);
        }

        private boolean h(int i) {
            int i2;
            int obj2;
            if (i <= 0) {
                if (i == Integer.MIN_VALUE) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        private boolean i(int i, int i2) {
            boolean obj1;
            if (h(i) && h(i2)) {
                obj1 = h(i2) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        private void j(int i, int i2) {
            List next;
            ArrayList arrayList = new ArrayList(this.b);
            Iterator iterator = arrayList.iterator();
            for (g next : iterator) {
                next.f(i, i2);
            }
        }

        void a() {
            if (this.b.isEmpty()) {
            }
            int i = g();
            final int i2 = f();
            if (!i(i, i2)) {
            }
            j(i, i2);
            b();
        }

        void b() {
            boolean alive;
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = 0;
            this.b.clear();
        }

        void d(com.bumptech.glide.r.k.g g) {
            boolean aVar;
            Object obj4;
            int i = g();
            final int i2 = f();
            if (i(i, i2)) {
                g.f(i, i2);
            }
            if (!this.b.contains(g)) {
                this.b.add(g);
            }
            if (this.d == null) {
                aVar = new i.a.a(this);
                this.d = aVar;
                this.a.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }

        void k(com.bumptech.glide.r.k.g g) {
            this.b.remove(g);
        }
    }
    static {
        i.x = i.a;
    }

    public i(T t) {
        super();
        k.d(t);
        this.a = (View)t;
        i.a aVar = new i.a(t);
        this.b = aVar;
    }

    private Object c() {
        return this.a.getTag(i.x);
    }

    private void d() {
        View.OnAttachStateChangeListener list;
        View z;
        list = this.c;
        if (list != null) {
            if (this.w) {
            } else {
                this.a.addOnAttachStateChangeListener(list);
                this.w = true;
            }
        }
    }

    private void e() {
        View.OnAttachStateChangeListener list;
        View z;
        list = this.c;
        if (list != null) {
            if (!this.w) {
            } else {
                this.a.removeOnAttachStateChangeListener(list);
                this.w = false;
            }
        }
    }

    private void f(Object object) {
        this.a.setTag(i.x, object);
    }

    @Override // com.bumptech.glide.r.k.a
    public d getRequest() {
        Object obj;
        boolean z;
        obj = c();
        if (obj != null) {
            if (!obj instanceof d) {
            } else {
                return obj;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            throw illegalArgumentException;
        }
        obj = 0;
    }

    @Override // com.bumptech.glide.r.k.a
    public void getSize(com.bumptech.glide.r.k.g g) {
        this.b.d(g);
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
    public void removeCallback(com.bumptech.glide.r.k.g g) {
        this.b.k(g);
    }

    @Override // com.bumptech.glide.r.k.a
    public void setRequest(d d) {
        f(d);
    }

    @Override // com.bumptech.glide.r.k.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Target for: ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
