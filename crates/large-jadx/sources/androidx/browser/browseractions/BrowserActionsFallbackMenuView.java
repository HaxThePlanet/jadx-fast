package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import d.c.a;

/* loaded from: classes.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {

    private final int a;
    private final int b;
    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        this.a = getResources().getDimensionPixelOffset(a.b);
        this.b = getResources().getDimensionPixelOffset(a.a);
    }

    @Override // android.widget.LinearLayout
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(obj2 -= i4, this.b), 1073741824), i2);
    }
}
