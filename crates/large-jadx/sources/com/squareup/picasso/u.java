package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/* compiled from: PicassoDrawable.java */
/* loaded from: classes2.dex */
final class u extends BitmapDrawable {

    private static final Paint h = new Paint();
    private final boolean a;
    private final float b;
    private final t.e c;
    Drawable d;
    long e;
    boolean f = true;
    int g = 255;

    u(Context context, Bitmap bitmap, Drawable drawable, t.e eVar, boolean z, boolean z2) {
        int i = 0;
        super(context.getResources(), bitmap);
        this.a = z2;
        this.b = context.getResources().getDisplayMetrics().density;
        this.c = eVar;
        context = eVar != t.e.MEMORY && !z ? 1 : 0;
        if (t.e.MEMORY != 0) {
            this.d = drawable;
            this.e = SystemClock.uptimeMillis();
        }
    }

    private void a(Canvas canvas) {
        final Paint paint = u.h;
        paint.setColor(-1);
        int i5 = 0;
        canvas.drawPath(u.b(i5, i5, (int)(this.b * 16f)), paint);
        paint.setColor(this.c.debugColor);
        canvas.drawPath(u.b(i5, i5, (int)(this.b * 15f)), paint);
    }

    private static Path b(int i, int i2, int i3) {
        final Path path = new Path();
        final float f = (float)i;
        final float f2 = (float)i2;
        path.moveTo(f, f2);
        path.lineTo((float)(i + i3), f2);
        path.lineTo(f, (float)(i2 + i3));
        return path;
    }

    static void c(ImageView imageView, Context context, Bitmap bitmap, t.e eVar, boolean z, boolean z2) {
        final Drawable drawable = imageView.getDrawable();
        z = drawable instanceof Animatable;
        if (drawable instanceof Animatable) {
            (Animatable)drawable.stop();
        }
        u uVar = new u(context, bitmap, drawable, eVar, z, z2);
        imageView.setImageDrawable(uVar);
    }

    static void d(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            (Animatable)imageView.getDrawable().start();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void draw(Canvas canvas) {
        if (!this.f) {
            super.draw(canvas);
        } else {
            float f2 = (float)(SystemClock.uptimeMillis() - this.e) / 200f;
            if (this.f >= 1065353216) {
                this.f = false;
                Drawable drawable = null;
                this.d = drawable;
                super.draw(canvas);
            } else {
                if (this.d != null) {
                    this.d.draw(canvas);
                }
                super.setAlpha((int)(float)this.g * f2);
                super.draw(canvas);
                super.setAlpha(this.g);
            }
        }
        if (this.a) {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable
    protected void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void setAlpha(int i) {
        this.g = i;
        if (this.d != null) {
            this.d.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.d != null) {
            this.d.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
