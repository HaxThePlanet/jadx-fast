package d.u;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
class k implements TypeEvaluator<Rect> {

    private Rect a;
    @Override // android.animation.TypeEvaluator
    public Rect a(float f, Rect rect2, Rect rect3) {
        int left = rect2.left;
        left += i4;
        int top = rect2.top;
        top += i8;
        int right = rect2.right;
        right += i12;
        int obj6 = rect2.bottom;
        obj6 += obj5;
        Rect obj5 = this.a;
        if (obj5 == null) {
            obj5 = new Rect(i, i5, i9, obj6);
            return obj5;
        }
        obj5.set(i, i5, i9, obj6);
        return this.a;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object object2, Object object3) {
        return a(f, (Rect)object2, (Rect)object3);
    }
}
