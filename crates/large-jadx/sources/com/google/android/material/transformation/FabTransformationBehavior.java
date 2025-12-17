package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d.h.l.u;
import f.c.a.e.f;
import f.c.a.e.m.a;
import f.c.a.e.m.b;
import f.c.a.e.m.c;
import f.c.a.e.m.d;
import f.c.a.e.m.e;
import f.c.a.e.m.h;
import f.c.a.e.m.i;
import f.c.a.e.m.j;
import f.c.a.e.q.a;
import f.c.a.e.q.c;
import f.c.a.e.q.d;
import f.c.a.e.q.d.d;
import f.c.a.e.q.d.e;
import f.c.a.e.w.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
@Deprecated
public abstract class FabTransformationBehavior extends com.google.android.material.transformation.ExpandableTransformationBehavior {

    private final Rect c;
    private final RectF d;
    private final RectF e;
    private final int[] f;
    private float g;
    private float h;

    class a extends AnimatorListenerAdapter {

        final boolean a;
        final View b;
        final View c;
        a(com.google.android.material.transformation.FabTransformationBehavior fabTransformationBehavior, boolean z2, View view3, View view4) {
            this.a = z2;
            this.b = view3;
            this.c = view4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i;
            boolean obj2;
            if (!this.a) {
                this.b.setVisibility(4);
                this.c.setAlpha(1065353216);
                this.c.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            int i;
            boolean obj2;
            if (this.a) {
                this.b.setVisibility(0);
                this.c.setAlpha(0);
                this.c.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        final View a;
        b(com.google.android.material.transformation.FabTransformationBehavior fabTransformationBehavior, View view2) {
            this.a = view2;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        final d a;
        final Drawable b;
        c(com.google.android.material.transformation.FabTransformationBehavior fabTransformationBehavior, d d2, Drawable drawable3) {
            this.a = d2;
            this.b = drawable3;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(0);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.b);
        }
    }

    class d extends AnimatorListenerAdapter {

        final d a;
        d(com.google.android.material.transformation.FabTransformationBehavior fabTransformationBehavior, d d2) {
            this.a = d2;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            d.e obj2 = this.a.getRevealInfo();
            obj2.c = 2139095039;
            this.a.setRevealInfo(obj2);
        }
    }

    protected static class e {

        public h a;
        public j b;
    }
    public FabTransformationBehavior() {
        super();
        Rect rect = new Rect();
        this.c = rect;
        RectF rectF = new RectF();
        this.d = rectF;
        RectF rectF2 = new RectF();
        this.e = rectF2;
        this.f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        Rect obj1 = new Rect();
        this.c = obj1;
        obj1 = new RectF();
        this.d = obj1;
        obj1 = new RectF();
        this.e = obj1;
        this.f = new int[2];
    }

    private ViewGroup B(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup)view;
        }
        return null;
    }

    private ViewGroup g(View view) {
        boolean z;
        View viewById = view.findViewById(f.M);
        if (viewById != null) {
            return B(viewById);
        }
        if (!view instanceof b && view instanceof a) {
            if (view instanceof a) {
            }
            return B(view);
        }
        return B((ViewGroup)view.getChildAt(0));
    }

    private void h(View view, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e2, i i3, i i4, float f5, float f6, float f7, float f8, RectF rectF9) {
        Rect obj4 = this.c;
        view.getWindowVisibleDisplayFrame(obj4);
        final RectF obj5 = this.d;
        obj5.set(obj4);
        obj4 = this.e;
        p(view, obj4);
        obj4.offset(o(e2, i3, f5, f7), o(e2, i4, f6, f8));
        obj4.intersect(obj5);
        rectF9.set(obj4);
    }

    private void i(View view, RectF rectF2) {
        p(view, rectF2);
        rectF2.offset(this.g, this.h);
    }

    private Pair<i, i> j(float f, float f2, boolean z3, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e4) {
        i obj2;
        i obj3;
        String obj4;
        final int i = 0;
        if (Float.compare(f, i) != 0) {
            obj2 = Float.compare(f2, i);
            if (obj2 == null) {
                obj2 = e4.a.e("translationXLinear");
                obj3 = e4.a.e("translationYLinear");
            } else {
                if (z3) {
                    if (Float.compare(f2, i) >= 0) {
                        if (!z3 && obj2 > 0) {
                            if (obj2 > 0) {
                                obj2 = e4.a.e("translationXCurveUpwards");
                                obj3 = e4.a.e("translationYCurveUpwards");
                            } else {
                                obj2 = e4.a.e("translationXCurveDownwards");
                                obj3 = e4.a.e("translationYCurveDownwards");
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
        obj4 = new Pair(obj2, obj3);
        return obj4;
    }

    private float k(View view, View view2, j j3) {
        final RectF rectF = this.d;
        final RectF rectF2 = this.e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(-obj3, 0);
        return obj3 -= obj4;
    }

    private float l(View view, View view2, j j3) {
        final RectF rectF = this.d;
        final RectF rectF2 = this.e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(0, -obj3);
        return obj3 -= obj4;
    }

    private float m(View view, View view2, j j3) {
        float obj3;
        float obj4;
        final RectF rectF = this.d;
        final RectF rectF2 = this.e;
        i(view, rectF);
        p(view2, rectF2);
        obj3 &= 7;
        if (obj3 != 1) {
            if (obj3 != 3) {
                if (obj3 != 5) {
                    obj3 = 0;
                } else {
                    obj3 = rectF2.right;
                    obj4 = rectF.right;
                    obj3 -= obj4;
                }
            } else {
                obj3 = rectF2.left;
                obj4 = rectF.left;
            }
        } else {
            obj3 = rectF2.centerX();
            obj4 = rectF.centerX();
        }
        return obj3 += obj4;
    }

    private float n(View view, View view2, j j3) {
        float obj3;
        float obj4;
        final RectF rectF = this.d;
        final RectF rectF2 = this.e;
        i(view, rectF);
        p(view2, rectF2);
        obj3 &= 112;
        if (obj3 != 16) {
            if (obj3 != 48) {
                if (obj3 != 80) {
                    obj3 = 0;
                } else {
                    obj3 = rectF2.bottom;
                    obj4 = rectF.bottom;
                    obj3 -= obj4;
                }
            } else {
                obj3 = rectF2.top;
                obj4 = rectF.top;
            }
        } else {
            obj3 = rectF2.centerY();
            obj4 = rectF.centerY();
        }
        return obj3 += obj4;
    }

    private float o(com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e, i i2, float f3, float f4) {
        i obj9 = e.a.e("expansion");
        return a.a(f3, f4, i2.e().getInterpolation(obj9 /= f));
    }

    private void p(View view, RectF rectF2) {
        int i6 = 0;
        rectF2.set(i6, i6, (float)width, (float)height);
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF2.offsetTo((float)i5, (float)i);
        rectF2.offset((float)i3, (float)obj4);
    }

    private void q(View view, View view2, boolean z3, boolean z4, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e5, List<Animator> list6, List<Animator.AnimatorListener> list7) {
        boolean obj2;
        int obj3;
        Property obj4;
        float[] obj5;
        if (!view2 instanceof ViewGroup) {
        }
        if (view2 instanceof d && c.a == 0) {
            if (c.a == 0) {
            }
        }
        obj2 = g(view2);
        if (obj2 == null) {
        }
        obj3 = 0;
        final int obj8 = 0;
        final int i = 1;
        if (z3 != null) {
            if (!z4) {
                d.a.set(obj2, Float.valueOf(obj3));
            }
            obj4 = new float[i];
            obj4[obj8] = 1065353216;
            obj2 = ObjectAnimator.ofFloat(obj2, d.a, obj4);
        } else {
            obj5 = new float[i];
            obj5[obj8] = obj3;
            obj2 = ObjectAnimator.ofFloat(obj2, d.a, obj5);
        }
        e5.a.e("contentFade").a(obj2);
        list6.add(obj2);
    }

    private void r(View view, View view2, boolean z3, boolean z4, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e5, List<Animator> list6, List<Animator.AnimatorListener> list7) {
        ObjectAnimator obj3;
        int[] obj5;
        int[] obj6;
        if (!view2 instanceof d) {
        }
        obj3 = z(view);
        final int i = 0;
        final int i2 = 1;
        if (z3) {
            if (z4 == null) {
                (d)view2.setCircularRevealScrimColor(obj3);
            }
            obj5 = new int[i2];
            obj5[i] = obj9 &= obj3;
            obj3 = ObjectAnimator.ofInt(view2, d.d.a, obj5);
        } else {
            obj6 = new int[i2];
            obj6[i] = obj3;
            obj3 = ObjectAnimator.ofInt(view2, d.d.a, obj6);
        }
        obj3.setEvaluator(c.b());
        e5.a.e("color").a(obj3);
        list6.add(obj3);
    }

    private void s(View view, View view2, boolean z3, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e4, List<Animator> list5) {
        float f;
        float obj8;
        Pair obj10 = j(m(view, view2, e4.b), n(view, view2, e4.b), z3, e4);
        int i = 1;
        final float[] fArr2 = new float[i];
        if (z3) {
        } else {
            f = this.g;
        }
        final int i2 = 0;
        fArr2[i2] = f;
        ObjectAnimator float = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, fArr2);
        float[] fArr = new float[i];
        if (z3) {
        } else {
            obj8 = this.h;
        }
        fArr[i2] = obj8;
        final ObjectAnimator obj7 = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, fArr);
        (i)obj10.first.a(float);
        (i)obj10.second.a(obj7);
        list5.add(float);
        list5.add(obj7);
    }

    private void t(View view, View view2, boolean z3, boolean z4, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e5, List<Animator> list6, List<Animator.AnimatorListener> list7) {
        ObjectAnimator obj2;
        int obj4;
        float[] obj5;
        int obj8;
        obj8 -= obj2;
        obj2 = 0;
        final int i = 1;
        if (z3 != 0) {
            if (!z4) {
                view2.setTranslationZ(-obj8);
            }
            obj5 = new float[i];
            obj5[obj2] = 0;
            obj2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, obj5);
        } else {
            obj5 = new float[i];
            obj5[obj2] = -obj8;
            obj2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, obj5);
        }
        e5.a.e("elevation").a(obj2);
        list6.add(obj2);
    }

    private void u(View view, View view2, boolean z3, boolean z4, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e5, float f6, float f7, List<Animator> list8, List<Animator.AnimatorListener> list9) {
        Object eVar;
        Object obj2;
        View view3;
        long l;
        float f3;
        int i2;
        int i4;
        int i5;
        float f;
        Object obj;
        Animator animator2;
        float f2;
        int i3;
        Animator animator;
        int i;
        final Object obj6 = this;
        View view4 = view;
        obj = view2;
        Object obj5 = e5;
        if (!obj instanceof d) {
        }
        final Object obj7 = obj;
        float f9 = obj6.k(view4, obj, obj5.b);
        f2 = obj6.l(view4, obj, obj5.b);
        (FloatingActionButton)view4.i(obj6.c);
        i3 = f4 / i6;
        final i iVar = obj5.a.e("expansion");
        if (z3) {
            if (!z4) {
                eVar = new d.e(f9, f2, i3);
                (d)obj7.setRevealInfo(eVar);
            }
            if (z4) {
                i3 = eVar;
            }
            f3 = f2;
            FabTransformationBehavior.d dVar = new FabTransformationBehavior.d(obj6, obj7);
            a.a(obj7, f9, f2, a.b(f9, f3, 0, 0, f6, f7)).addListener(dVar);
            this.x(view2, iVar.c(), f3, (int)f9, (int)f2, i3);
        } else {
            int i10 = (int)f9;
            int i12 = (int)f2;
            view3 = view2;
            i4 = i12;
            f = list8;
            this.x(view3, iVar.c(), obj3, i10, i4, revealInfo2.c);
            this.w(view3, iVar.c(), obj3, iVar.d(), i4, obj5.a.f(), f, i10);
            animator2 = animator;
        }
        iVar.a(animator2);
        list8.add(animator2);
        list9.add(a.b(obj7));
    }

    private void v(View view, View view2, boolean z3, boolean z4, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e5, List<Animator> list6, List<Animator.AnimatorListener> list7) {
        boolean z;
        int i3;
        int i2;
        int i;
        Object obj5;
        Object obj6;
        ObjectAnimator obj7;
        String obj8;
        if (view2 instanceof d) {
            if (view instanceof ImageView == null) {
            } else {
                obj5 = (ImageView)view.getDrawable();
                if (obj5 == null) {
                }
                obj5.mutate();
                i3 = 255;
                i2 = 1;
                i = 0;
                if (z3 != null) {
                    if (z4 == null) {
                        obj5.setAlpha(i3);
                    }
                    obj8 = new int[i2];
                    obj8[i] = i;
                    obj7 = ObjectAnimator.ofInt(obj5, e.b, obj8);
                } else {
                    obj8 = new int[i2];
                    obj8[i] = i3;
                    obj7 = ObjectAnimator.ofInt(obj5, e.b, obj8);
                }
                obj8 = new FabTransformationBehavior.b(this, view2);
                obj7.addUpdateListener(obj8);
                e5.a.e("iconFade").a(obj7);
                list6.add(obj7);
                obj6 = new FabTransformationBehavior.c(this, (d)view2, obj5);
                list7.add(obj6);
            }
        }
    }

    private void w(View view, long l2, long l3, long l4, int i5, int i6, float f7, List<Animator> list8) {
        Object obj3;
        int obj4;
        int obj6;
        int obj8;
        l2 += l4;
        if (Build.VERSION.SDK_INT >= 21 && Long.compare(obj4, i6) < 0) {
            l2 += l4;
            if (Long.compare(obj4, i6) < 0) {
                obj3 = ViewAnimationUtils.createCircularReveal(view, list8, obj11, obj12, obj12);
                obj3.setStartDelay(obj4);
                obj3.setDuration(i6 -= obj4);
                obj13.add(obj3);
            }
        }
    }

    private void x(View view, long l2, int i3, int i4, float f5, List<Animator> list6) {
        int sDK_INT;
        int cmp;
        Object obj4;
        final int i = 21;
        sDK_INT = 0;
        if (Build.VERSION.SDK_INT >= i && Long.compare(l2, sDK_INT) > 0) {
            sDK_INT = 0;
            if (Long.compare(l2, sDK_INT) > 0) {
                obj4 = ViewAnimationUtils.createCircularReveal(view, i4, f5, list6, list6);
                obj4.setStartDelay(sDK_INT);
                obj4.setDuration(l2);
                obj10.add(obj4);
            }
        }
    }

    private void y(View view, View view2, boolean z3, boolean z4, com.google.android.material.transformation.FabTransformationBehavior.e fabTransformationBehavior$e5, List<Animator> list6, List<Animator.AnimatorListener> list7, RectF rectF8) {
        int i4;
        View view3;
        boolean z;
        Object tRANSLATION_Y;
        Object fArr;
        Object obj;
        int i5;
        int i;
        int i2;
        int i3;
        RectF rectF;
        ObjectAnimator float2;
        ObjectAnimator float;
        final int i7 = this;
        View view4 = view;
        view3 = view2;
        z = z3;
        Object obj2 = e5;
        final Object obj3 = list6;
        float f2 = i7.m(view4, view3, obj2.b);
        float f = i7.n(view4, view3, obj2.b);
        Pair pair = i7.j(f2, f, z, obj2);
        final Object obj4 = first;
        final Object obj5 = second;
        i5 = 0;
        i = 1;
        if (z) {
            if (!z4) {
                view3.setTranslationX(-f2);
                view3.setTranslationY(-f);
            }
            float[] fArr4 = new float[i];
            i3 = 0;
            fArr4[i5] = i3;
            float2 = ObjectAnimator.ofFloat(view3, View.TRANSLATION_X, fArr4);
            float[] fArr3 = new float[i];
            fArr3[i5] = i3;
            float = ObjectAnimator.ofFloat(view3, View.TRANSLATION_Y, fArr3);
            this.h(view2, e5, (i)obj4, (i)obj5, -f2, -f, 0, i3, rectF8);
        } else {
            float[] fArr2 = new float[i];
            fArr2[i5] = -f2;
            float2 = ObjectAnimator.ofFloat(view3, View.TRANSLATION_X, fArr2);
            fArr = new float[i];
            fArr[i5] = -f;
            float = ObjectAnimator.ofFloat(view3, View.TRANSLATION_Y, fArr);
        }
        obj4.a(float2);
        obj5.a(float);
        obj3.add(float2);
        obj3.add(float);
    }

    private int z(View view) {
        final ColorStateList list = u.s(view);
        if (list != null) {
            return list.getColorForState(view.getDrawableState(), list.getDefaultColor());
        }
        return 0;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected abstract com.google.android.material.transformation.FabTransformationBehavior.e A(Context context, boolean z2);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet f(View view, View view2, boolean z3, boolean z4) {
        Context translationY;
        int sDK_INT;
        int i;
        int i2;
        View view3;
        boolean z2;
        View view4;
        boolean z;
        com.google.android.material.transformation.FabTransformationBehavior.e eVar;
        ArrayList list2;
        ArrayList list;
        final Object obj = this;
        final boolean z8 = z3;
        final com.google.android.material.transformation.FabTransformationBehavior.e eVar5 = A(view2.getContext(), z8);
        if (z8) {
            obj.g = view.getTranslationX();
            obj.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            this.t(view, view2, z3, z4, eVar5, arrayList, arrayList2);
        }
        RectF rectF2 = obj.d;
        com.google.android.material.transformation.FabTransformationBehavior fabTransformationBehavior = this;
        View view5 = view;
        View view6 = view2;
        boolean z5 = z3;
        ArrayList list4 = arrayList;
        ArrayList list6 = arrayList2;
        fabTransformationBehavior.y(view5, view6, z5, z4, eVar5, list4, list6, rectF2);
        fabTransformationBehavior.s(view5, view6, z5, eVar5, arrayList);
        boolean z7 = z4;
        com.google.android.material.transformation.FabTransformationBehavior.e eVar4 = eVar5;
        fabTransformationBehavior.v(view5, view6, z5, z7, eVar4, list4, list6);
        fabTransformationBehavior.u(view5, view6, z5, z7, eVar4, rectF2.width(), rectF2.height(), arrayList, arrayList2);
        ArrayList list5 = arrayList;
        ArrayList list7 = arrayList2;
        fabTransformationBehavior.r(view5, view6, z5, z7, eVar4, list5, list7);
        fabTransformationBehavior.q(view5, view6, z5, z7, eVar4, list5, list7);
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        FabTransformationBehavior.a aVar = new FabTransformationBehavior.a(this, z8, view2, view);
        animatorSet.addListener(aVar);
        i2 = 0;
        while (i2 < arrayList2.size()) {
            animatorSet.addListener((Animator.AnimatorListener)arrayList2.get(i2));
            i2++;
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3) {
        int i;
        boolean obj2;
        int obj3;
        if (view2.getVisibility() == 8) {
        } else {
            i = 0;
            if (view3 instanceof FloatingActionButton) {
                obj2 = (FloatingActionButton)view3.getExpandedComponentIdHint();
                if (obj2 != null) {
                    if (obj2 == view2.getId()) {
                        i = 1;
                    }
                } else {
                }
            }
            return i;
        }
        obj2 = new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        throw obj2;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public void onAttachedToLayoutParams(CoordinatorLayout.f coordinatorLayout$f) {
        int i;
        if (f.h == 0) {
            f.h = 80;
        }
    }
}
