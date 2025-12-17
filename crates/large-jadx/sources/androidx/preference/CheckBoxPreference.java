package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.core.content.e.g;

/* loaded from: classes.dex */
public class CheckBoxPreference extends androidx.preference.TwoStatePreference {

    private final androidx.preference.CheckBoxPreference.a Q;

    private class a implements CompoundButton.OnCheckedChangeListener {

        final androidx.preference.CheckBoxPreference a;
        a(androidx.preference.CheckBoxPreference checkBoxPreference) {
            this.a = checkBoxPreference;
            super();
        }

        @Override // android.widget.CompoundButton$OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (!this.a.a(Boolean.valueOf(z2))) {
                compoundButton.setChecked(z2 ^= 1);
            }
            this.a.B(z2);
        }
    }
    public CheckBoxPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.a, 16842895));
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        CheckBoxPreference.a aVar = new CheckBoxPreference.a(this);
        this.Q = aVar;
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.a, i3, i4);
        E(g.o(obj2, f.g, f.b));
        D(g.o(obj2, f.f, f.c));
        C(g.b(obj2, f.e, f.d, false));
        obj2.recycle();
    }
}
