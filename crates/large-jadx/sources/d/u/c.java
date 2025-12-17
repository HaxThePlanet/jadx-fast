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

/* loaded from: classes.dex */
public class c extends d.u.o {

    private static final String[] e0;
    private static final Property<Drawable, PointF> f0;
    private static final Property<d.u.c.k, PointF> g0;
    private static final Property<d.u.c.k, PointF> h0;
    private static final Property<View, PointF> i0;
    private static final Property<View, PointF> j0;
    private static final Property<View, PointF> k0;
    private static d.u.k l0;
    private int[] b0;
    private boolean c0 = false;
    private boolean d0 = false;

    class a extends AnimatorListenerAdapter {

        final ViewGroup a;
        final BitmapDrawable b;
        final View c;
        final float d;
        a(d.u.c c, ViewGroup viewGroup2, BitmapDrawable bitmapDrawable3, View view4, float f5) {
            this.a = viewGroup2;
            this.b = bitmapDrawable3;
            this.c = view4;
            this.d = f5;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            f0.b(this.a).b(this.b);
            f0.g(this.c, this.d);
        }
    }

    static class b extends Property<Drawable, PointF> {

        private Rect a;
        b(Class class, String string2) {
            super(class, string2);
            Rect obj1 = new Rect();
            this.a = obj1;
        }

        @Override // android.util.Property
        public PointF a(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect2 = this.a;
            PointF obj3 = new PointF((float)left, (float)top);
            return obj3;
        }

        @Override // android.util.Property
        public void b(Drawable drawable, PointF pointF2) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable.setBounds(this.a);
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((Drawable)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((Drawable)object, (PointF)object2);
        }
    }

    static class c extends Property<d.u.c.k, PointF> {
        c(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public PointF a(d.u.c.k c$k) {
            return null;
        }

        @Override // android.util.Property
        public void b(d.u.c.k c$k, PointF pointF2) {
            k.c(pointF2);
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((c.k)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((c.k)object, (PointF)object2);
        }
    }

    static class d extends Property<d.u.c.k, PointF> {
        d(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public PointF a(d.u.c.k c$k) {
            return null;
        }

        @Override // android.util.Property
        public void b(d.u.c.k c$k, PointF pointF2) {
            k.a(pointF2);
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((c.k)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((c.k)object, (PointF)object2);
        }
    }

    static class e extends Property<View, PointF> {
        e(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public PointF a(View view) {
            return null;
        }

        @Override // android.util.Property
        public void b(View view, PointF pointF2) {
            f0.f(view, view.getLeft(), view.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (PointF)object2);
        }
    }

    static class f extends Property<View, PointF> {
        f(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public PointF a(View view) {
            return null;
        }

        @Override // android.util.Property
        public void b(View view, PointF pointF2) {
            f0.f(view, Math.round(pointF2.x), Math.round(pointF2.y), view.getRight(), view.getBottom());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (PointF)object2);
        }
    }

    static class g extends Property<View, PointF> {
        g(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public PointF a(View view) {
            return null;
        }

        @Override // android.util.Property
        public void b(View view, PointF pointF2) {
            int round = Math.round(pointF2.x);
            int obj5 = Math.round(pointF2.y);
            f0.f(view, round, obj5, width += round, height += obj5);
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (PointF)object2);
        }
    }

    class h extends AnimatorListenerAdapter {

        final d.u.c.k a;
        private d.u.c.k mViewBounds;
        h(d.u.c c, d.u.c.k c$k2) {
            this.a = k2;
            super();
            this.mViewBounds = k2;
        }
    }

    class i extends AnimatorListenerAdapter {

        private boolean a;
        final View b;
        final Rect c;
        final int d;
        final int e;
        final int f;
        final int g;
        i(d.u.c c, View view2, Rect rect3, int i4, int i5, int i6, int i7) {
            this.b = view2;
            this.c = rect3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i2;
            int i4;
            int i;
            int i3;
            boolean obj5;
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
            obj2++;
            this.g = obj2;
            if (this.f == obj2) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            obj2++;
            this.f = obj2;
            if (obj2 == this.g) {
                b();
            }
        }
    }

    class j extends d.u.p {

        boolean a = false;
        final ViewGroup b;
        j(d.u.c c, ViewGroup viewGroup2) {
            this.b = viewGroup2;
            super();
            final int obj1 = 0;
        }

        @Override // d.u.p
        public void onTransitionCancel(d.u.o o) {
            a0.c(this.b, false);
            this.a = true;
        }

        @Override // d.u.p
        public void onTransitionEnd(d.u.o o) {
            boolean z;
            int i;
            if (!this.a) {
                a0.c(this.b, false);
            }
            o.S(this);
        }

        @Override // d.u.p
        public void onTransitionPause(d.u.o o) {
            a0.c(this.b, false);
        }

        @Override // d.u.p
        public void onTransitionResume(d.u.o o) {
            a0.c(this.b, true);
        }
    }
    static {
        c.e0 = /* result */;
        c.b bVar = new c.b(PointF.class, "boundsOrigin");
        c.f0 = bVar;
        String str5 = "topLeft";
        c.c cVar = new c.c(PointF.class, str5);
        c.g0 = cVar;
        String str8 = "bottomRight";
        c.d dVar = new c.d(PointF.class, str8);
        c.h0 = dVar;
        c.e eVar = new c.e(PointF.class, str8);
        c.i0 = eVar;
        c.f fVar = new c.f(PointF.class, str5);
        c.j0 = fVar;
        c.g gVar = new c.g(PointF.class, "position");
        c.k0 = gVar;
        k kVar = new k();
        c.l0 = kVar;
    }

    public c() {
        super();
        this.b0 = new int[2];
        int i2 = 0;
    }

    private void h0(d.u.u u) {
        Object view;
        boolean height;
        boolean z;
        Object valueOf;
        String str;
        int top;
        int right;
        int bottom;
        Object obj8;
        view = u.b;
        if (!u.R(view) && view.getWidth() == 0) {
            if (view.getWidth() == 0) {
                Rect rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                u.a.put("android:changeBounds:bounds", rect);
                u.a.put("android:changeBounds:parent", u.b.getParent());
                if (view.getHeight() != 0 && this.d0) {
                    rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    u.a.put("android:changeBounds:bounds", rect);
                    u.a.put("android:changeBounds:parent", u.b.getParent());
                    if (this.d0) {
                        u.b.getLocationInWindow(this.b0);
                        u.a.put("android:changeBounds:windowX", Integer.valueOf(this.b0[0]));
                        u.a.put("android:changeBounds:windowY", Integer.valueOf(this.b0[1]));
                    }
                    if (this.c0) {
                        u.a.put("android:changeBounds:clip", u.u(view));
                    }
                }
            } else {
            }
        } else {
        }
    }

    private boolean i0(View view, View view2) {
        boolean z;
        int i2;
        int i;
        View obj4;
        if (this.d0) {
            z = w(view, true);
            if (z == null && view == view2) {
                if (view == view2) {
                } else {
                    i2 = i;
                }
            } else {
            }
        }
        return i2;
    }

    @Override // d.u.o
    public String[] G() {
        return c.e0;
    }

    @Override // d.u.o
    public void f(d.u.u u) {
        h0(u);
    }

    @Override // d.u.o
    public void j(d.u.u u) {
        h0(u);
    }

    @Override // d.u.o
    public Animator n(ViewGroup viewGroup, d.u.u u2, d.u.u u3) {
        int intValue2;
        int i4;
        Object animator;
        int intValue3;
        ObjectAnimator i2;
        Object kVar;
        boolean parent;
        int intValue;
        Object rect;
        int jVar;
        int intValue4;
        Property i3;
        int i;
        String str;
        boolean animatorSet;
        Map map;
        int left;
        int left2;
        Object view2;
        View view3;
        int object;
        int top2;
        int top;
        int iVar;
        int right;
        int bottom;
        View view;
        boolean equals;
        final Object obj12 = this;
        Object obj = u2;
        Object obj3 = u3;
        if (obj != null) {
            if (obj3 == null) {
            } else {
                String str4 = "android:changeBounds:parent";
                Object obj7 = obj.a.get(str4);
                Object obj10 = obj3.a.get(str4);
                if ((ViewGroup)obj7 != null) {
                    if ((ViewGroup)obj10 == null) {
                    } else {
                        view2 = obj3.b;
                        if (obj12.i0((ViewGroup)obj7, (ViewGroup)obj10)) {
                            String str5 = "android:changeBounds:bounds";
                            Object obj9 = obj.a.get(str5);
                            Object obj11 = obj3.a.get(str5);
                            left = obj9.left;
                            left2 = obj11.left;
                            top2 = obj9.top;
                            top = obj11.top;
                            iVar = obj9.right;
                            right = obj11.right;
                            intValue4 = obj9.bottom;
                            bottom = obj11.bottom;
                            map = iVar - left;
                            intValue = intValue4 - top2;
                            object = right - left2;
                            str = bottom - top;
                            view = view2;
                            String str6 = "android:changeBounds:clip";
                            intValue2 = obj.a.get(str6);
                            view2 = obj5;
                            if (map != null) {
                                if (intValue == 0) {
                                    if (object != null && str != null) {
                                        if (str != null) {
                                            if (left == left2) {
                                                if (top2 != top) {
                                                    intValue3 = 1;
                                                } else {
                                                    intValue3 = 0;
                                                }
                                            } else {
                                            }
                                            if (iVar == right) {
                                                if (intValue4 != bottom) {
                                                    intValue3++;
                                                }
                                            } else {
                                            }
                                        } else {
                                            intValue3 = 0;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                            if ((Rect)intValue2 != null) {
                                if ((Rect)intValue2.equals((Rect)view2)) {
                                    if (intValue2 == null && view2 != null) {
                                        if (view2 != null) {
                                            intValue3++;
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                            if (intValue3 > 0) {
                                final Object obj19 = view2;
                                final Object obj20 = intValue2;
                                i4 = 2;
                                if (!obj12.c0) {
                                    view3 = view;
                                    f0.f(view3, left, top2, iVar, intValue4);
                                    if (intValue3 == i4) {
                                        if (map == object && intValue == str) {
                                            if (intValue == str) {
                                                animator = f.a(view3, c.k0, y().a((float)left, (float)top2, (float)left2, (float)top));
                                            } else {
                                                kVar = new c.k(view3);
                                                animatorSet = new AnimatorSet();
                                                Animator[] arr2 = new Animator[i4];
                                                arr2[0] = f.a(kVar, c.g0, y().a((float)left, (float)top2, (float)left2, (float)top));
                                                arr2[1] = f.a(kVar, c.h0, y().a((float)iVar, (float)intValue4, (float)right, (float)bottom));
                                                animatorSet.playTogether(arr2);
                                                c.h hVar = new c.h(obj12, kVar);
                                                animatorSet.addListener(hVar);
                                                animator = animatorSet;
                                            }
                                        } else {
                                        }
                                    } else {
                                        if (left == left2) {
                                            if (top2 != top) {
                                                animator = f.a(view3, c.j0, y().a((float)left, (float)top2, (float)left2, (float)top));
                                            } else {
                                                animator = f.a(view3, c.i0, y().a((float)iVar, (float)intValue4, (float)right, (float)bottom));
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                    view3 = view;
                                    f0.f(view3, left, top2, i10 += left, i15 += top2);
                                    if (left == left2) {
                                        if (top2 != top) {
                                            top2 = i2;
                                        } else {
                                            top2 = 0;
                                        }
                                    } else {
                                    }
                                    if (obj20 == null) {
                                        i = 0;
                                        kVar = new Rect(i, i, map, intValue);
                                    } else {
                                        i = 0;
                                        kVar = obj20;
                                    }
                                    if (obj19 == null) {
                                        rect = new Rect(i, i, object, str);
                                    } else {
                                        rect = obj19;
                                    }
                                    if (!kVar.equals(rect)) {
                                        u.r0(view3, kVar);
                                        Object[] arr = new Object[i4];
                                        arr[i] = kVar;
                                        arr[1] = rect;
                                        object = ObjectAnimator.ofObject(view3, "clipBounds", c.l0, arr);
                                        super(this, view3, obj19, left2, top, right, bottom);
                                        object.addListener(iVar);
                                        jVar = object;
                                    } else {
                                        jVar = 0;
                                    }
                                    animator = t.c(top2, jVar);
                                }
                                if (parent2 instanceof ViewGroup) {
                                    parent = view3.getParent();
                                    a0.c((ViewGroup)parent, true);
                                    jVar = new c.j(obj12, parent);
                                    obj12.a(jVar);
                                }
                                return animator;
                            }
                            return null;
                        } else {
                            String str3 = "android:changeBounds:windowX";
                            intValue = (Integer)obj.a.get(str3).intValue();
                            str = "android:changeBounds:windowY";
                            intValue2 = (Integer)obj.a.get(str).intValue();
                            intValue4 = (Integer)obj3.a.get(str3).intValue();
                            intValue3 = (Integer)obj3.a.get(str).intValue();
                            if (intValue == intValue4 && intValue2 != intValue3) {
                                if (intValue2 != intValue3) {
                                }
                            }
                        }
                    }
                    viewGroup.getLocationInWindow(obj12.b0);
                    Bitmap bitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmap);
                    view2.draw(canvas);
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmap);
                    f0.g(view2, 0);
                    f0.b(viewGroup).a(bitmapDrawable2);
                    int[] iArr2 = obj12.b0;
                    int i18 = 0;
                    int i20 = 1;
                    android.animation.PropertyValuesHolder[] arr3 = new PropertyValuesHolder[i20];
                    arr3[i18] = i.a(c.f0, y().a((float)i12, (float)i6, (float)i14, (float)i9));
                    ObjectAnimator propertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable2, arr3);
                    super(this, viewGroup, bitmapDrawable2, view2, f0.c(view2));
                    propertyValuesHolder2.addListener(aVar2);
                    return propertyValuesHolder2;
                }
            }
            return null;
        }
        return null;
    }
}
