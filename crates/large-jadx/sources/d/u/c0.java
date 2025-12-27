package d.u;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import d.h.l.u;
import java.util.ArrayList;

/* compiled from: ViewOverlayApi14.java */
/* loaded from: classes.dex */
class c0 implements e0 {

    protected c0.a a = new c0$a();

    static class a extends ViewGroup {

        ViewGroup a;
        View b;
        ArrayList<Drawable> c = null;
        c0 v;
        private boolean w;
        static {
            try {
                Class[] arr = new Class[3];
                Class tYPE2 = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { tYPE2, tYPE2, Rect.class });
            } catch (java.lang.NoSuchMethodException unused) {
                return;
            }
        }

        a(Context context, ViewGroup viewGroup, View view, c0 c0Var) {
            super(context);
            this.a = viewGroup;
            this.b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.v = c0Var;
        }

        private void c() {
            if (this.w) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0 && this.c != null && this.c.size() == 0) {
                this.w = true;
                this.a.removeView(this);
            }
        }

        private void e(int[] iArr) {
            int i = 2;
            int[] iArr3 = new int[i];
            int[] iArr2 = new int[i];
            this.a.getLocationOnScreen(iArr3);
            this.b.getLocationOnScreen(iArr2);
            int i5 = 0;
            iArr[i5] = iArr2[i5] - iArr3[i5];
            int i6 = 1;
            iArr[i6] = iArr2[i6] - iArr3[i6];
        }

        @Override // android.view.ViewGroup
        public void a(Drawable drawable) {
            c();
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (!this.c.contains(drawable)) {
                this.c.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        @Override // android.view.ViewGroup
        public void b(View view) {
            int i;
            int i2 = 1;
            int i3;
            c();
            z = view.getParent() instanceof ViewGroup;
            if (view.getParent() instanceof ViewGroup) {
                ViewParent parent3 = view.getParent();
                if (parent3 != this.a && parent3.getParent() != null && u.Q(parent3)) {
                    int i4 = 2;
                    int[] iArr2 = new int[i4];
                    int[] iArr = new int[i4];
                    parent3.getLocationOnScreen(iArr2);
                    this.a.getLocationOnScreen(iArr);
                    int i7 = 0;
                    i3 = iArr2[i7] - iArr[i7];
                    u.W(view, i3);
                    i2 = 1;
                    i = iArr2[i2] - iArr[i2];
                    u.X(view, i);
                }
                parent3.removeView(view);
                if (view.getParent() != null) {
                    parent3.removeView(view);
                }
            }
            super.addView(view);
        }

        @Override // android.view.ViewGroup
        protected void dispatchDraw(Canvas canvas) {
            int size;
            int i = 2;
            int[] iArr2 = new int[i];
            int[] iArr = new int[i];
            this.a.getLocationOnScreen(iArr2);
            this.b.getLocationOnScreen(iArr);
            size = 0;
            int i8 = 1;
            canvas.translate((float)(iArr[size] - iArr2[size]), (float)(iArr[i8] - iArr2[i8]));
            canvas.clipRect(new Rect(size, size, this.b.getWidth(), this.b.getHeight()));
            super.dispatchDraw(canvas);
            if (this.c == null) {
            } else {
                size = this.c.size();
            }
            while (this.b < this.c) {
                (Drawable)this.c.get(size).draw(canvas);
                size = size + 1;
            }
        }

        @Override // android.view.ViewGroup
        public void f(Drawable drawable) {
            if (this.c != null) {
                this.c.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        @Override // android.view.ViewGroup
        public void g(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.a != null) {
                int i3 = 0;
                int i = 1;
                rect.offset(iArr[i3], iArr[i]);
                z = this.a instanceof ViewGroup;
                if (this.a instanceof ViewGroup) {
                    iArr[i3] = i3;
                    iArr[i] = i3;
                    int[] iArr2 = new int[2];
                    e(iArr2);
                    rect.offset(iArr2[i3], iArr2[i]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }

        @Override // android.view.ViewGroup
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup
        protected boolean verifyDrawable(Drawable drawable) {
            boolean verifyDrawable;
            boolean z = false;
            if (super.verifyDrawable(drawable) || this.c != null) {
                int i2 = 1;
            } else {
                if (!(this.c.contains(drawable))) {
                    int i = 0;
                }
            }
            return z;
        }

        @Override // android.view.ViewGroup
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }
    }
    c0(Context context, ViewGroup viewGroup, View view) {
        super();
        final d.u.c0.a aVar = new c0.a(context, viewGroup, view, this);
    }

    static c0 e(View view) {
        int i = 0;
        final ViewGroup viewGroup = c0.f(view);
        if (viewGroup != null) {
            i = 0;
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                z = childAt instanceof c0.a;
                if (childAt instanceof c0.a) {
                    return childAt.v;
                }
            }
            return new x(viewGroup.getContext(), viewGroup, view);
        }
        return null;
    }

    static ViewGroup f(View view) {
        ViewParent parent;
        while (parent != null) {
            int i2 = 16908290;
            if (parent.getId() == 16908290) {
            }
        }
        return null;
    }

    public void a(Drawable drawable) {
        this.a.a(drawable);
    }

    public void b(Drawable drawable) {
        this.a.f(drawable);
    }
}
