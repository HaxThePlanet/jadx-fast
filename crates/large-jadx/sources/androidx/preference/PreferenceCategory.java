package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.e.g;

/* loaded from: classes.dex */
public class PreferenceCategory extends androidx.preference.PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.e, 16842892));
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
    }

    @Override // androidx.preference.PreferenceGroup
    public boolean p() {
        return 0;
    }

    @Override // androidx.preference.PreferenceGroup
    public boolean y() {
        return z ^= 1;
    }
}
