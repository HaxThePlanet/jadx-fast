package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;

/* compiled from: CropImageAnimation.java */
/* loaded from: classes2.dex */
final class e extends Animation implements Animation.AnimationListener {

    private final RectF A = new RectF();
    private final float[] B;
    private final float[] C;
    private final ImageView a;
    private final CropOverlayView b;
    private final float[] c;
    private final float[] v;
    private final RectF w = new RectF();
    private final RectF x = new RectF();
    private final float[] y;
    private final float[] z;
    public e(ImageView imageView, CropOverlayView cropOverlayView) {
        super();
        int i = 8;
        this.c = new float[i];
        this.v = new float[i];
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        int i2 = 9;
        this.y = new float[i2];
        this.z = new float[i2];
        RectF rectF3 = new RectF();
        this.B = new float[i];
        this.C = new float[i2];
        this.a = imageView;
        this.b = cropOverlayView;
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    @Override // android.view.animation.Animation
    public void a(float[] fArr, Matrix matrix) {
        final int i = 0;
        System.arraycopy(fArr, i, this.v, i, 8);
        this.x.set(this.b.getCropWindowRect());
        matrix.getValues(this.z);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        int transformation22;
        this.A.left = left2 + (rectF.left - left2) * f;
        this.A.top = top2 + (rectF.top - top2) * f;
        f3 = (rectF.right - right2) * f;
        this.A.right = right2 + f3;
        f2 = (rectF.bottom - bottom2) * f;
        this.A.bottom = bottom2 + f2;
        this.b.setCropWindowRect(this.A);
        transformation22 = 0;
        while (this.b < fArr.length) {
            f4 = (this.v[transformation22] - fArr4[transformation22]) * f;
            f3 = fArr4[transformation22] + f4;
            this.B[transformation22] = f3;
            transformation22 = transformation22 + 1;
        }
        this.b.s(this.B, this.a.getWidth(), this.a.getHeight());
        while (this.A < fArr2.length) {
            height = (this.z[transformation22] - fArr3[transformation22]) * f;
            width = fArr3[transformation22] + height;
            this.C[transformation22] = width;
            transformation22 = transformation22 + 1;
        }
        Matrix imageMatrix = this.a.getImageMatrix();
        imageMatrix.setValues(this.C);
        this.a.setImageMatrix(imageMatrix);
        this.a.invalidate();
        this.b.invalidate();
    }

    @Override // android.view.animation.Animation
    public void b(float[] fArr, Matrix matrix) {
        reset();
        final int i = 0;
        System.arraycopy(fArr, i, this.c, i, 8);
        this.w.set(this.b.getCropWindowRect());
        matrix.getValues(this.y);
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
