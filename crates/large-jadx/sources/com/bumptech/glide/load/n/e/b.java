package com.bumptech.glide.load.n.e;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import androidx.core.content.a;
import androidx.core.content.e.f;
import d.a.k.a.a;
import d.a.o.d;

/* loaded from: classes.dex */
public final class b {

    private static volatile boolean a = true;
    static {
    }

    public static Drawable a(Context context, int i2, Resources.Theme resources$Theme3) {
        return b.c(context, context, i2, theme3);
    }

    public static Drawable b(Context context, Context context2, int i3) {
        return b.c(context, context2, i3, 0);
    }

    private static Drawable c(Context context, Context context2, int i3, Resources.Theme resources$Theme4) {
        String obj1;
        Resources.Theme obj4;
        try {
            if (b.a) {
            }
            return b.e(context2, i3, theme4);
            context = context.getPackageName();
            context = context.equals(context2.getPackageName());
            if (context != null) {
            } else {
            }
            context = a.f(context2, i3);
            return context;
            throw theme4;
            context = null;
            b.a = context;
        }
        obj4 = context2.getTheme();
        return b.d(context2, i3, obj4);
    }

    private static Drawable d(Context context, int i2, Resources.Theme resources$Theme3) {
        return f.f(context.getResources(), i2, theme3);
    }

    private static Drawable e(Context context, int i2, Resources.Theme resources$Theme3) {
        d dVar;
        Object obj1;
        if (theme3 != null) {
            dVar = new d(context, theme3);
            obj1 = dVar;
        }
        return a.d(obj1, i2);
    }
}
