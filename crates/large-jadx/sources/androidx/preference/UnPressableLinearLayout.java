package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class UnPressableLinearLayout extends LinearLayout {
    public UnPressableLinearLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // android.widget.LinearLayout
    protected void dispatchSetPressed(boolean z) {
    }
}
