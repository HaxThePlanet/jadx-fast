package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import d.a.a;

/* loaded from: classes.dex */
public class q extends RatingBar {

    private final androidx.appcompat.widget.o a;
    public q(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.I);
    }

    public q(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        o0.a(this, getContext());
        o obj1 = new o(this);
        this.a = obj1;
        obj1.c(attributeSet2, i3);
    }

    @Override // android.widget.RatingBar
    protected void onMeasure(int i, int i2) {
        int i3;
        int obj2;
        Bitmap obj3;
        super.onMeasure(i, i2);
        obj3 = this.a.b();
        synchronized (this) {
            try {
                setMeasuredDimension(View.resolveSizeAndState(obj3 *= numStars, i, 0), getMeasuredHeight());
                throw i;
            }
        }
    }
}
