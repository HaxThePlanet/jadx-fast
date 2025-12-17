package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.TextView;
import d.u.o;
import d.u.u;
import java.util.Map;

/* loaded from: classes2.dex */
public class j extends o {

    class a implements ValueAnimator.AnimatorUpdateListener {

        final TextView a;
        a(com.google.android.material.internal.j j, TextView textView2) {
            this.a = textView2;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float obj2 = (Float)valueAnimator.getAnimatedValue().floatValue();
            this.a.setScaleX(obj2);
            this.a.setScaleY(obj2);
        }
    }
    private void h0(u u) {
        Object valueOf;
        boolean str;
        Object obj3;
        valueOf = u.b;
        if (valueOf instanceof TextView != null) {
            u.a.put("android:textscale:scale", Float.valueOf((TextView)valueOf.getScaleX()));
        }
    }

    @Override // d.u.o
    public void f(u u) {
        h0(u);
    }

    @Override // d.u.o
    public void j(u u) {
        h0(u);
    }

    @Override // d.u.o
    public Animator n(ViewGroup viewGroup, u u2, u u3) {
        boolean z;
        String str;
        Object obj;
        int floatValue;
        int obj5;
        Object obj6;
        Object obj7;
        if (u2 != null && u3 != null && view instanceof TextView != null) {
            if (u3 != null) {
                if (view instanceof TextView != null) {
                    z = u3.b;
                    if (z instanceof TextView == null) {
                    } else {
                        obj6 = u2.a;
                        obj7 = u3.a;
                        str = "android:textscale:scale";
                        if (obj6.get(str) != null) {
                            obj6 = (Float)obj6.get(str).floatValue();
                        } else {
                            obj6 = floatValue;
                        }
                        if (obj7.get(str) != null) {
                            floatValue = (Float)obj7.get(str).floatValue();
                        }
                        if (Float.compare(obj6, floatValue) == 0) {
                            return null;
                        }
                        obj5 = new float[2];
                        obj6 = new j.a(this, (TextView)z);
                        ValueAnimator.ofFloat(obj6, floatValue).addUpdateListener(obj6);
                    }
                }
            }
        }
        return obj5;
    }
}
