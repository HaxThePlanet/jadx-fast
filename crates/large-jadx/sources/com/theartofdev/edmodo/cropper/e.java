package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;

/* loaded from: classes2.dex */
final class e extends Animation implements Animation.AnimationListener {

    private final RectF A;
    private final float[] B;
    private final float[] C;
    private final ImageView a;
    private final com.theartofdev.edmodo.cropper.CropOverlayView b;
    private final float[] c;
    private final float[] v;
    private final RectF w;
    private final RectF x;
    private final float[] y;
    private final float[] z;
    public e(ImageView imageView, com.theartofdev.edmodo.cropper.CropOverlayView cropOverlayView2) {
        super();
        int i = 8;
        this.c = new float[i];
        this.v = new float[i];
        RectF rectF = new RectF();
        this.w = rectF;
        RectF rectF2 = new RectF();
        this.x = rectF2;
        int i2 = 9;
        this.y = new float[i2];
        this.z = new float[i2];
        RectF rectF3 = new RectF();
        this.A = rectF3;
        this.B = new float[i];
        this.C = new float[i2];
        this.a = imageView;
        this.b = cropOverlayView2;
        setDuration(300);
        setFillAfter(true);
        AccelerateDecelerateInterpolator obj4 = new AccelerateDecelerateInterpolator();
        setInterpolator(obj4);
        setAnimationListener(this);
    }

    @Override // android.view.animation.Animation
    public void a(float[] fArr, Matrix matrix2) {
        final int i = 0;
        System.arraycopy(fArr, i, this.v, i, 8);
        this.x.set(this.b.getCropWindowRect());
        matrix2.getValues(this.z);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation2) {
        int i;
        com.theartofdev.edmodo.cropper.CropOverlayView view;
        int i2;
        RectF rectF;
        int width;
        int i3;
        int height;
        int i4;
        int obj7;
        obj7 = this.A;
        RectF rectF2 = this.w;
        float left = rectF2.left;
        rectF = this.x;
        obj7.left = left += i11;
        float top = rectF2.top;
        obj7.top = top += i13;
        float right = rectF2.right;
        obj7.right = right += i3;
        float bottom = rectF2.bottom;
        obj7.bottom = bottom += i2;
        this.b.setCropWindowRect(obj7);
        i = obj7;
        i2 = this.B;
        while (i < i2.length) {
            float[] fArr2 = this.c;
            i2[i] = f4 += i4;
            i++;
            i2 = this.B;
        }
        this.b.s(i2, this.a.getWidth(), this.a.getHeight());
        view = this.C;
        while (obj7 < view.length) {
            float[] fArr = this.y;
            view[obj7] = f2 += height;
            obj7++;
            view = this.C;
        }
        Matrix obj6 = this.a.getImageMatrix();
        obj6.setValues(this.C);
        this.a.setImageMatrix(obj6);
        this.a.invalidate();
        this.b.invalidate();
    }

    @Override // android.view.animation.Animation
    public void b(float[] fArr, Matrix matrix2) {
        reset();
        final int i = 0;
        System.arraycopy(fArr, i, this.c, i, 8);
        this.w.set(this.b.getCropWindowRect());
        matrix2.getValues(this.y);
    }

    @Override // android.view.animation.Animation
    public void onAnimationEnd(Animation animation) {
        this.a.clearAnimation();
    }

    @Override // android.view.animation.Animation
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation
    public void onAnimationStart(Animation animation) {
    }
}
