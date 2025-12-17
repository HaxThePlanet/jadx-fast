package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.e.g;
import d.e.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends androidx.preference.Preference {

    final g<String, Long> L;
    private List<androidx.preference.Preference> M;
    public PreferenceGroup(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet2, int i3, int i4) {
        int obj3;
        boolean obj4;
        super(context, attributeSet2, i3, i4);
        g gVar = new g();
        this.L = gVar;
        Handler handler = new Handler();
        ArrayList arrayList = new ArrayList();
        this.M = arrayList;
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.s0, i3, i4);
        obj3 = f.u0;
        g.b(obj2, obj3, obj3, true);
        obj3 = f.t0;
        if (obj2.hasValue(obj3)) {
            C(g.d(obj2, obj3, obj3, Integer.MAX_VALUE));
        }
        obj2.recycle();
    }

    @Override // androidx.preference.Preference
    public androidx.preference.Preference A(int i) {
        return (Preference)this.M.get(i);
    }

    @Override // androidx.preference.Preference
    public int B() {
        return this.M.size();
    }

    @Override // androidx.preference.Preference
    public void C(int i) {
        int str;
        int obj2;
        if (i != Integer.MAX_VALUE && !o()) {
            if (!o()) {
                obj2 = new StringBuilder();
                obj2.append(getClass().getSimpleName());
                obj2.append(" should have a key defined if it contains an expandable preference");
                Log.e("PreferenceGroup", obj2.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public void s(boolean z) {
        int i;
        androidx.preference.Preference preference;
        super.s(z);
        i = 0;
        while (i < B()) {
            A(i).v(this, z);
            i++;
        }
    }
}
