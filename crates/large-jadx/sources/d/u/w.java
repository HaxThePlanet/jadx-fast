package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

/* compiled from: TranslationAnimationCreator.java */
/* loaded from: classes.dex */
class w {

    private static class a extends AnimatorListenerAdapter implements o.f {

        private final View a;
        private final View b;
        private final int c;
        private final int d;
        private int[] e;
        private float f;
        private float g;
        private final float h;
        private final float i;
        a(View view, View view2, int i, int i2, float f, float f2) {
            super();
            this.b = view;
            this.a = view2;
            this.c = i - Math.round(view.getTranslationX());
            this.d = i2 - Math.round(view.getTranslationY());
            this.h = f;
            this.i = f2;
            i = j.e;
            Object tag = view2.getTag(i);
            this.e = tag;
            if (tag != null) {
                tag = null;
                view2.setTag(j.e, tag);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            if (this.e == null) {
                this.e = new int[2];
            }
            this.e[0] = Math.round((float)this.c + this.b.getTranslationX());
            this.e[1] = Math.round((float)this.d + this.b.getTranslationY());
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
        public void onTransitionEnd(o oVar) {
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
            oVar.S(this);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionCancel(o oVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionPause(o oVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionResume(o oVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionStart(o oVar) {
        }
    }
    static Animator a(View view, u uVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, o oVar) {
        float f62;
        float f52;
        Object uVar22 = uVar;
        final float translationX = view.getTranslationX();
        final float translationY = view.getTranslationY();
        Object tag = uVar22.b.getTag(j.e);
        int i9 = 1;
        final int i10 = 0;
        if (tag != null) {
            f52 = (float)(tag[i10] - i) + translationX;
            f62 = (float)(tag[i9] - i2) + translationY;
        } else {
            f52 = f;
            f62 = f2;
        }
        view.setTranslationX(f52);
        view.setTranslationY(f62);
        if (f52 == f3) {
            if (uVar22.b == f4) {
                return null;
            }
        }
        int i13 = 2;
        final PropertyValuesHolder[] arr = new PropertyValuesHolder[i13];
        final float[] fArr2 = new float[i13];
        fArr2[i10] = f52;
        fArr2[i9] = f3;
        arr[i10] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, fArr2);
        float[] fArr = new float[i13];
        fArr[i10] = f62;
        fArr[i9] = f4;
        arr[i9] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, fArr);
        ObjectAnimator propertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, arr);
        w.a aVar = new w.a(view, view2, i, i2, translationX, translationY);
        oVar.a(aVar);
        propertyValuesHolder.addListener(aVar);
        a.a(propertyValuesHolder, aVar);
        propertyValuesHolder.setInterpolator(timeInterpolator);
        return propertyValuesHolder;
    }
}
