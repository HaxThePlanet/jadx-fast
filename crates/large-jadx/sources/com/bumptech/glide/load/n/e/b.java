package com.bumptech.glide.load.n.e;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import androidx.core.content.e.f;
import d.a.o.d;

/* compiled from: DrawableDecoderCompat.java */
/* loaded from: classes.dex */
public final class b {

    private static volatile boolean a = true;
    public static Drawable a(Context context, int i, Resources.Theme theme) {
        return b.c(context, context, i, theme);
    }

    public static Drawable b(Context context, Context context2, int i) {
        return b.c(context, context2, i, null);
    }

    private static Drawable c(Context context, Context context2, int i, Resources.Theme theme) {
        try {
        } catch (java.lang.IllegalStateException ise) {
            context = context.getPackageName();
            context = context.equals(context2.getPackageName());
        } catch (java.lang.NoClassDefFoundError unused) {
            context = null;
            b.a = context;
        } catch (android.content.res.Resources.NotFoundException unused) {
            theme = context2.getTheme();
            return b.d(context2, i, theme);
        }
        return b.e(context2, i, theme);
    }

    private static Drawable d(Context context, int i, Resources.Theme theme) {
        return f.f(context.getResources(), i, theme);
    }

    private static Drawable e(Context context, int i, Resources.Theme theme) {
        Object obj;
        if (theme != null) {
        }
        return a.d(obj, i);
    }

}
