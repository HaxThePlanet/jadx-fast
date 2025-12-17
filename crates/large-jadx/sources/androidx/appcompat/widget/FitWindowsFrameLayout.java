package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements androidx.appcompat.widget.c0 {

    private androidx.appcompat.widget.c0.a a;
    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // android.widget.FrameLayout
    protected boolean fitSystemWindows(Rect rect) {
        final androidx.appcompat.widget.c0.a aVar = this.a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.widget.FrameLayout
    public void setOnFitSystemWindowsListener(androidx.appcompat.widget.c0.a c0$a) {
        this.a = a;
    }
}
