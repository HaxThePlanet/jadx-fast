package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.core.content.e.g;

/* loaded from: classes.dex */
public class SwitchPreference extends androidx.preference.TwoStatePreference {

    private final androidx.preference.SwitchPreference.a Q;
    private java.lang.CharSequence R;
    private java.lang.CharSequence S;

    private class a implements CompoundButton.OnCheckedChangeListener {

        final androidx.preference.SwitchPreference a;
        a(androidx.preference.SwitchPreference switchPreference) {
            this.a = switchPreference;
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
    public SwitchPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.j, 16843629));
    }

    public SwitchPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        SwitchPreference.a aVar = new SwitchPreference.a(this);
        this.Q = aVar;
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.F0, i3, i4);
        E(g.o(obj2, f.N0, f.G0));
        D(g.o(obj2, f.M0, f.H0));
        G(g.o(obj2, f.P0, f.J0));
        F(g.o(obj2, f.O0, f.K0));
        C(g.b(obj2, f.L0, f.I0, false));
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
