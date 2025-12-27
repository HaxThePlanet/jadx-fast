package d.u;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: RectEvaluator.java */
/* loaded from: classes.dex */
class k implements TypeEvaluator<Rect> {

    private Rect a;
    k() {
        super();
    }

    public Rect a(float f, Rect rect, Rect rect2) {
        int i = left2 + (int)(float)(rect2.left - left2) * f;
        int i4 = top2 + (int)(float)(rect2.top - top2) * f;
        int i7 = right2 + (int)(float)(rect2.right - right2) * f;
        int i11 = bottom2 + (int)(float)(rect2.bottom - bottom2) * f;
        if (this.a == null) {
            return new Rect(i, i4, i7, i11);
        }
        this.a.set(i, i4, i7, i11);
        return this.a;
    }
}
