package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import d.a.a;

/* loaded from: classes.dex */
public class r extends SeekBar {

    private final androidx.appcompat.widget.s a;
    public r(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.K);
    }

    public r(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        o0.a(this, getContext());
        s obj1 = new s(this);
        this.a = obj1;
        obj1.c(attributeSet2, i3);
    }

    @Override // android.widget.SeekBar
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.h();
    }

    @Override // android.widget.SeekBar
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.i();
    }

    @Override // android.widget.SeekBar
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.g(canvas);
        return;
        synchronized (this) {
            super.onDraw(canvas);
            this.a.g(canvas);
        }
    }
}
