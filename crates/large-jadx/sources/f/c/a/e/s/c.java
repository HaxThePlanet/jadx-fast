package f.c.a.e.s;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import f.c.a.e.d;

/* compiled from: MaterialDialogs.java */
/* loaded from: classes2.dex */
public class c {
    public static Rect a(Context context, int i, int i2) throws android.content.res.Resources.NotFoundException {
        int i32;
        TypedArray typedArray = l.h(context, null, l.S1, i, i2, new int[0]);
        typedArray.recycle();
        if (Build.VERSION.SDK_INT >= 17) {
            int sDK_INT2 = 1;
            if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            }
        }
        return new Rect(i32, typedArray.getDimensionPixelSize(l.W1, context.getResources().getDimensionPixelSize(d.J)), i32, typedArray.getDimensionPixelSize(l.T1, context.getResources().getDimensionPixelSize(d.G)));
    }

    public static InsetDrawable b(Drawable drawable, Rect rect) {
        InsetDrawable insetDrawable = new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
        return insetDrawable;
    }
}
