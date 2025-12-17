package f.c.a.e.o;

import android.graphics.Canvas;
import android.os.Build.VERSION;

/* loaded from: classes2.dex */
public class a {
    public static int a(Canvas canvas, float f2, float f3, float f4, float f5, int i6) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f2, f3, f4, f5, i6);
        }
        return canvas.saveLayerAlpha(f2, f3, f4, f5, i6, 31);
    }
}
