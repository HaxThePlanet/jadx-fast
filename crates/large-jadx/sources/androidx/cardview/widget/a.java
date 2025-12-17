package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: classes.dex */
class a extends androidx.cardview.widget.c {

    class a implements androidx.cardview.widget.g.a {
        a(androidx.cardview.widget.a a) {
            super();
        }

        @Override // androidx.cardview.widget.g$a
        public void a(Canvas canvas, RectF rectF2, float f3, Paint paint4) {
            canvas.drawRoundRect(rectF2, f3, f3, paint4);
        }
    }
    @Override // androidx.cardview.widget.c
    public void j() {
        a.a aVar = new a.a(this);
        g.r = aVar;
    }
}
