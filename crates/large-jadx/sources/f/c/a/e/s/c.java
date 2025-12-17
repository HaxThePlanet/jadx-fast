package f.c.a.e.s;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import com.google.android.material.internal.l;
import f.c.a.e.d;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class c {
    public static Rect a(Context context, int i2, int i3) {
        int dimensionPixelSize;
        int i;
        int obj7;
        int obj8;
        int obj9;
        obj8 = l.h(context, 0, l.S1, i2, i3, new int[0]);
        obj8.recycle();
        if (Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
            if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                dimensionPixelSize = obj9;
                obj9 = i;
            }
        }
        obj7 = new Rect(obj9, obj8.getDimensionPixelSize(l.W1, context.getResources().getDimensionPixelSize(d.J)), dimensionPixelSize, obj8.getDimensionPixelSize(l.T1, context.getResources().getDimensionPixelSize(d.G)));
        return obj7;
    }

    public static InsetDrawable b(Drawable drawable, Rect rect2) {
        super(drawable, rect2.left, rect2.top, rect2.right, rect2.bottom);
        return insetDrawable2;
    }
}
