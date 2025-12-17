package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.e.g;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends androidx.preference.DialogPreference {
    public MultiSelectListPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.b, 16842897));
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        HashSet hashSet = new HashSet();
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.C, i3, i4);
        g.q(obj2, f.F, f.D);
        g.q(obj2, f.G, f.E);
        obj2.recycle();
    }

    @Override // androidx.preference.DialogPreference
    protected Object u(TypedArray typedArray, int i2) {
        int i;
        String string;
        final java.lang.CharSequence[] obj4 = typedArray.getTextArray(i2);
        HashSet obj5 = new HashSet();
        i = 0;
        while (i < obj4.length) {
            obj5.add(obj4[i].toString());
            i++;
        }
        return obj5;
    }
}
