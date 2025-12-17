package com.skydoves.balloon.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes2.dex */
public final class b {
    public static final int a(Drawable drawable) {
        int obj0;
        if (drawable != null) {
            obj0 = drawable.getIntrinsicHeight();
        } else {
            obj0 = 0;
        }
        return obj0;
    }

    public static final int b(Drawable[] drawableArr) {
        n.f(drawableArr, "$this$getIntrinsicHeight");
        return g.b(b.a(drawableArr[0]), b.a(drawableArr[2]));
    }

    public static final int c(Drawable[] drawableArr) {
        n.f(drawableArr, "$this$getSumOfIntrinsicWidth");
        return i2 += obj2;
    }

    public static final int d(Drawable drawable) {
        int obj0;
        if (drawable != null) {
            obj0 = drawable.getIntrinsicWidth();
        } else {
            obj0 = 0;
        }
        return obj0;
    }

    public static final boolean e(Drawable[] drawableArr) {
        int i;
        int obj;
        Object obj2;
        n.f(drawableArr, "$this$isExistHorizontalDrawable");
        if (drawableArr[0] == null) {
            if (drawableArr[2] != null) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public static final Drawable f(Drawable drawable, Context context2, Integer integer3, Integer integer4) {
        Object bitmap;
        Canvas canvas;
        int i;
        Object obj3;
        Object obj4;
        int obj5;
        int obj6;
        n.f(drawable, "$this$resize");
        n.f(context2, "context");
        if (integer3 != 0 && integer4 != 0) {
            if (integer4 != 0) {
                bitmap = Bitmap.createBitmap(integer3.intValue(), integer4.intValue(), Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmap);
                i = 0;
                drawable.setBounds(i, i, integer3.intValue(), integer4.intValue());
                drawable.draw(canvas);
                obj3 = new BitmapDrawable(context2.getResources(), bitmap);
            }
        }
        return obj3;
    }

    public static final Drawable g(Drawable drawable, Integer integer2) {
        Object str;
        ColorStateList obj2;
        n.f(drawable, "$this$tint");
        if (integer2 != null) {
            a.o(a.r(drawable), ColorStateList.valueOf(integer2.intValue()));
        }
        return drawable;
    }
}
