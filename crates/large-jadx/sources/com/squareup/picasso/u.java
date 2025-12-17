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
import android.widget.ImageView;

/* loaded from: classes2.dex */
final class u extends BitmapDrawable {

    private static final Paint h;
    private final boolean a;
    private final float b;
    private final com.squareup.picasso.t.e c;
    Drawable d;
    long e;
    boolean f = true;
    int g = 255;
    static {
        Paint paint = new Paint();
        u.h = paint;
    }

    u(Context context, Bitmap bitmap2, Drawable drawable3, com.squareup.picasso.t.e t$e4, boolean z5, boolean z6) {
        int obj2;
        super(context.getResources(), bitmap2);
        int obj3 = 255;
        this.a = z6;
        this.b = obj2.density;
        this.c = e4;
        if (e4 != t.e.MEMORY && !z5) {
            obj2 = !z5 ? obj3 : 0;
        } else {
        }
        if (obj2 != null) {
            this.d = drawable3;
            this.e = SystemClock.uptimeMillis();
        }
    }

    private void a(Canvas canvas) {
        final Paint paint = u.h;
        paint.setColor(-1);
        int i7 = 0;
        canvas.drawPath(u.b(i7, i7, (int)i2), paint);
        paint.setColor(eVar.debugColor);
        canvas.drawPath(u.b(i7, i7, (int)i4), paint);
    }

    private static Path b(int i, int i2, int i3) {
        Path path = new Path();
        final float f = (float)i;
        final float f2 = (float)i2;
        path.moveTo(f, f2);
        path.lineTo((float)obj3, f2);
        path.lineTo(f, (float)obj4);
        return path;
    }

    static void c(ImageView imageView, Context context2, Bitmap bitmap3, com.squareup.picasso.t.e t$e4, boolean z5, boolean z6) {
        boolean z;
        final Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            (Animatable)drawable.stop();
        }
        super(context2, bitmap3, drawable, e4, z5, z6);
        imageView.setImageDrawable(uVar2);
    }

    static void d(ImageView imageView, Drawable drawable2) {
        Drawable obj0;
        imageView.setImageDrawable(drawable2);
        if (obj1 instanceof Animatable) {
            (Animatable)imageView.getDrawable().start();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void draw(Canvas canvas) {
        int z;
        int cmp;
        long l;
        if (!this.f) {
            super.draw(canvas);
        } else {
            f /= i5;
            if (Float.compare(i2, i6) >= 0) {
                this.f = false;
                this.d = 0;
                super.draw(canvas);
            } else {
                Drawable drawable = this.d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int)cmp);
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
        final Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void setAlpha(int i) {
        this.g = i;
        final Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void setColorFilter(ColorFilter colorFilter) {
        final Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
