package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements androidx.appcompat.widget.c0 {

    private androidx.appcompat.widget.c0.a a;
    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // android.widget.LinearLayout
    protected boolean fitSystemWindows(Rect rect) {
        final androidx.appcompat.widget.c0.a aVar = this.a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.widget.LinearLayout
    public void setOnFitSystemWindowsListener(androidx.appcompat.widget.c0.a c0$a) {
        this.a = a;
    }
}
