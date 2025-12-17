package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

/* loaded from: classes.dex */
class w {

    private static class a extends AnimatorListenerAdapter implements d.u.o.f {

        private final View a;
        private final View b;
        private final int c;
        private final int d;
        private int[] e;
        private float f;
        private float g;
        private final float h;
        private final float i;
        a(View view, View view2, int i3, int i4, float f5, float f6) {
            Object obj4;
            super();
            this.b = view;
            this.a = view2;
            this.c = i3 -= round;
            this.d = i4 -= obj2;
            this.h = f5;
            this.i = f6;
            int obj2 = j.e;
            obj4 = view2.getTag(obj2);
            this.e = (int[])obj4;
            if (obj4 != null) {
                view2.setTag(obj2, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            int[] obj4;
            if (this.e == null) {
                this.e = new int[2];
            }
            this.e[0] = Math.round(f += translationX);
            this.e[1] = Math.round(f2 += translationY);
            this.a.setTag(j.e, this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationPause(Animator animator) {
            this.f = this.b.getTranslationX();
            this.g = this.b.getTranslationY();
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationResume(Animator animator) {
            this.b.setTranslationX(this.f);
            this.b.setTranslationY(this.g);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionCancel(d.u.o o) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionEnd(d.u.o o) {
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
            o.S(this);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionPause(d.u.o o) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionResume(d.u.o o) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionStart(d.u.o o) {
        }
    }
    static Animator a(View view, d.u.u u2, int i3, int i4, float f5, float f6, float f7, float f8, TimeInterpolator timeInterpolator9, d.u.o o10) {
        int i;
        int i2;
        int cmp;
        Object obj = view;
        Object obj3 = u2;
        final float translationX = view.getTranslationX();
        final float translationY = view.getTranslationY();
        Object tag = obj3.b.getTag(j.e);
        int i9 = 1;
        final int i10 = 0;
        if ((int[])tag != null) {
            f2 += translationX;
            f += translationY;
        } else {
            i2 = f5;
            i = f6;
        }
        view.setTranslationX(i2);
        view.setTranslationY(i);
        if (Float.compare(i2, f7) == 0 && Float.compare(i, f8) == 0) {
            if (Float.compare(i, f8) == 0) {
                return null;
            }
        }
        int i17 = 2;
        final PropertyValuesHolder[] arr = new PropertyValuesHolder[i17];
        final float[] fArr2 = new float[i17];
        fArr2[i10] = i2;
        fArr2[i9] = f7;
        arr[i10] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, fArr2);
        float[] fArr = new float[i17];
        fArr[i10] = i;
        fArr[i9] = f8;
        arr[i9] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, fArr);
        ObjectAnimator propertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, arr);
        super(view, obj3.b, round += i3, round2 += i4, translationX, translationY);
        o10.a(aVar);
        propertyValuesHolder.addListener(aVar);
        a.a(propertyValuesHolder, aVar);
        propertyValuesHolder.setInterpolator(timeInterpolator9);
        return propertyValuesHolder;
    }
}
