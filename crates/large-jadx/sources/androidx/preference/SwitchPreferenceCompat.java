package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.core.content.e.g;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends androidx.preference.TwoStatePreference {

    private final androidx.preference.SwitchPreferenceCompat.a Q;
    private java.lang.CharSequence R;
    private java.lang.CharSequence S;

    private class a implements CompoundButton.OnCheckedChangeListener {

        final androidx.preference.SwitchPreferenceCompat a;
        a(androidx.preference.SwitchPreferenceCompat switchPreferenceCompat) {
            this.a = switchPreferenceCompat;
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
    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, c.i);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        SwitchPreferenceCompat.a aVar = new SwitchPreferenceCompat.a(this);
        this.Q = aVar;
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.Q0, i3, i4);
        E(g.o(obj2, f.Y0, f.R0));
        D(g.o(obj2, f.X0, f.S0));
        G(g.o(obj2, f.a1, f.U0));
        F(g.o(obj2, f.Z0, f.V0));
        C(g.b(obj2, f.W0, f.T0, false));
        obj2.recycle();
    }

    @Override // androidx.preference.TwoStatePreference
    public void F(java.lang.CharSequence charSequence) {
        this.S = charSequence;
        r();
    }

    @Override // androidx.preference.TwoStatePreference
    public void G(java.lang.CharSequence charSequence) {
        this.R = charSequence;
        r();
    }
}
