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

/* compiled from: DrawableExtension.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final /* synthetic */ int a(Drawable drawable) {
        int intrinsicHeight = 0;
        if (drawable != null) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
        }
        return intrinsicHeight;
    }

    public static final /* synthetic */ int b(Drawable[] drawableArr) {
        n.f(drawableArr, "$this$getIntrinsicHeight");
        return g.b(b.a(drawableArr[0]), b.a(drawableArr[2]));
    }

    public static final /* synthetic */ int c(Drawable[] drawableArr) {
        n.f(drawableArr, "$this$getSumOfIntrinsicWidth");
        return b.d(drawableArr[0]) + b.d(drawableArr[2]);
    }

    public static final /* synthetic */ int d(Drawable drawable) {
        int intrinsicWidth = 0;
        if (drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        } else {
            intrinsicWidth = 0;
        }
        return intrinsicWidth;
    }

    public static final /* synthetic */ boolean e(Drawable[] drawableArr) {
        boolean z = false;
        Object obj;
        Object obj2;
        n.f(drawableArr, "$this$isExistHorizontalDrawable");
        if (drawableArr[0] == null) {
            int i = 2;
            if (drawableArr[i] != null) {
                int i3 = 1;
            }
        }
        return z;
    }

    public static final /* synthetic */ Drawable f(Drawable drawable, Context context, Integer integer, Integer integer2) {
        BitmapDrawable bitmapDrawable;
        n.f(drawable, "$this$resize");
        str = "context";
        n.f(context, str);
        if (integer != null && integer2 != null) {
            Bitmap bitmap = Bitmap.createBitmap(integer.intValue(), integer2.intValue(), Bitmap.Config.ARGB_8888);
            int i = 0;
            drawable.setBounds(i, i, integer.intValue(), integer2.intValue());
            drawable.draw(new Canvas(bitmap));
            bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        }
        return bitmapDrawable;
    }

    public static final /* synthetic */ Drawable g(Drawable drawable, Integer integer) {
        str = "$this$tint";
        n.f(drawable, str);
        if (integer != null) {
            a.o(a.r(drawable), ColorStateList.valueOf(integer.intValue()));
        }
        return drawable;
    }
}
