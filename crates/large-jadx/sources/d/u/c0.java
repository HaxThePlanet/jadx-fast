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

/* loaded from: classes.dex */
class c0 implements d.u.e0 {

    protected d.u.c0.a a;

    static class a extends ViewGroup {

        ViewGroup a;
        View b;
        ArrayList<Drawable> c = null;
        d.u.c0 v;
        private boolean w;
        static {
            try {
                Class[] arr = new Class[3];
                Class tYPE = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", tYPE, tYPE, Rect.class);
            }
        }

        a(Context context, ViewGroup viewGroup2, View view3, d.u.c0 c04) {
            super(context);
            int obj1 = 0;
            this.a = viewGroup2;
            this.b = view3;
            setRight(viewGroup2.getWidth());
            setBottom(viewGroup2.getHeight());
            viewGroup2.addView(this);
            this.v = c04;
        }

        private void c() {
            if (this.w) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            throw illegalStateException;
        }

        private void d() {
            ArrayList childCount;
            if (getChildCount() == 0) {
                childCount = this.c;
                if (childCount != null) {
                    if (childCount.size() == 0) {
                        this.w = true;
                        this.a.removeView(this);
                    }
                } else {
                }
            }
        }

        private void e(int[] iArr) {
            int i = 2;
            int[] iArr3 = new int[i];
            int[] iArr2 = new int[i];
            this.a.getLocationOnScreen(iArr3);
            this.b.getLocationOnScreen(iArr2);
            int i5 = 0;
            iArr[i5] = i7 -= i9;
            int i6 = 1;
            iArr[i6] = i2 -= i4;
        }

        @Override // android.view.ViewGroup
        public void a(Drawable drawable) {
            ArrayList arrayList;
            boolean contains;
            c();
            if (this.c == null) {
                arrayList = new ArrayList();
                this.c = arrayList;
            }
            if (!this.c.contains(drawable)) {
                this.c.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        @Override // android.view.ViewGroup
        public void b(View view) {
            boolean parent2;
            ViewParent parent;
            ViewGroup parent3;
            int i2;
            int i3;
            int i;
            c();
            parent2 = view.getParent();
            if (parent4 instanceof ViewGroup && parent2 != this.a && (ViewGroup)parent2.getParent() != null && u.Q(parent2)) {
                parent2 = view.getParent();
                if ((ViewGroup)parent2 != this.a) {
                    if ((ViewGroup)parent2.getParent() != null) {
                        if (u.Q(parent2)) {
                            int i4 = 2;
                            int[] iArr2 = new int[i4];
                            int[] iArr = new int[i4];
                            parent2.getLocationOnScreen(iArr2);
                            this.a.getLocationOnScreen(iArr);
                            int i6 = 0;
                            u.W(view, i8 -= i7);
                            i3 = 1;
                            u.X(view, i5 -= parent3);
                        }
                    }
                }
                parent2.removeView(view);
                if (view.getParent() != null) {
                    parent2.removeView(view);
                }
            }
            super.addView(view);
        }

        @Override // android.view.ViewGroup
        protected void dispatchDraw(Canvas canvas) {
            int size;
            int width;
            int i;
            int i2 = 2;
            int[] iArr2 = new int[i2];
            int[] iArr = new int[i2];
            this.a.getLocationOnScreen(iArr2);
            this.b.getLocationOnScreen(iArr);
            i = 0;
            int i9 = 1;
            canvas.translate((float)i7, (float)i4);
            Rect rect = new Rect(i, i, this.b.getWidth(), this.b.getHeight());
            canvas.clipRect(rect);
            super.dispatchDraw(canvas);
            ArrayList list = this.c;
            if (list == null) {
                size = i;
            } else {
                size = list.size();
            }
            while (i < size) {
                (Drawable)this.c.get(i).draw(canvas);
                i++;
            }
        }

        @Override // android.view.ViewGroup
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return 0;
        }

        @Override // android.view.ViewGroup
        public void f(Drawable drawable) {
            ArrayList list;
            list = this.c;
            if (list != null) {
                list.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(0);
                d();
            }
        }

        @Override // android.view.ViewGroup
        public void g(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect2) {
            ViewGroup view;
            boolean z;
            int i;
            int i2;
            view = 0;
            i = 1;
            rect2.offset(iArr[view], iArr[i]);
            if (this.a != null && view2 instanceof ViewGroup) {
                view = 0;
                i = 1;
                rect2.offset(iArr[view], iArr[i]);
                if (view2 instanceof ViewGroup) {
                    iArr[view] = view;
                    iArr[i] = view;
                    int[] iArr2 = new int[2];
                    e(iArr2);
                    rect2.offset(iArr2[view], iArr2[i]);
                    return super.invalidateChildInParent(iArr, rect2);
                }
                invalidate(rect2);
            }
            return null;
        }

        @Override // android.view.ViewGroup
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.ViewGroup
        protected boolean verifyDrawable(Drawable drawable) {
            boolean verifyDrawable;
            Drawable obj2;
            if (!super.verifyDrawable(drawable)) {
                verifyDrawable = this.c;
                if (verifyDrawable != null && verifyDrawable.contains(drawable)) {
                    if (verifyDrawable.contains(drawable)) {
                        obj2 = 1;
                    } else {
                        obj2 = 0;
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }
    }
    c0(Context context, ViewGroup viewGroup2, View view3) {
        super();
        c0.a aVar = new c0.a(context, viewGroup2, view3, this);
        this.a = aVar;
    }

    static d.u.c0 e(View view) {
        int i;
        View childAt;
        boolean z;
        final ViewGroup view2 = c0.f(view);
        if (view2 != null) {
            i = 0;
            while (i < view2.getChildCount()) {
                childAt = view2.getChildAt(i);
                i++;
            }
            x xVar = new x(view2.getContext(), view2, view);
            return xVar;
        }
        return null;
    }

    static ViewGroup f(View view) {
        boolean z;
        int i;
        int i2;
        Object obj2;
        while (obj2 != null) {
            if (parent instanceof ViewGroup) {
            }
            obj2 = obj2.getParent();
        }
        return null;
    }

    @Override // d.u.e0
    public void a(Drawable drawable) {
        this.a.a(drawable);
    }

    @Override // d.u.e0
    public void b(Drawable drawable) {
        this.a.f(drawable);
    }
}
