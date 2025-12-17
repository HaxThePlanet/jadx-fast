package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends androidx.preference.Preference {

    protected boolean L;
    private java.lang.CharSequence M;
    private java.lang.CharSequence N;
    private boolean O;
    private boolean P;
    public TwoStatePreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
    }

    @Override // androidx.preference.Preference
    public boolean A() {
        return this.L;
    }

    @Override // androidx.preference.Preference
    public void B(boolean z) {
        int i;
        boolean z2;
        boolean obj4;
        final int i2 = 1;
        i = this.L != z ? i2 : 0;
        if (i == 0) {
            this.L = z;
            this.O = i2;
            w(z);
            if (!this.O && i != 0) {
                this.L = z;
                this.O = i2;
                w(z);
                if (i != 0) {
                    s(y());
                    r();
                }
            }
        } else {
        }
    }

    @Override // androidx.preference.Preference
    public void C(boolean z) {
        this.P = z;
    }

    @Override // androidx.preference.Preference
    public void D(java.lang.CharSequence charSequence) {
        this.N = charSequence;
        if (!A()) {
            r();
        }
    }

    @Override // androidx.preference.Preference
    public void E(java.lang.CharSequence charSequence) {
        this.M = charSequence;
        if (A()) {
            r();
        }
    }

    @Override // androidx.preference.Preference
    protected Object u(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    @Override // androidx.preference.Preference
    public boolean y() {
        int i2;
        int i;
        final int i3 = 0;
        i2 = this.P ? this.L : !z2 ? i : i3;
        if (i2 == 0) {
            if (super.y()) {
            } else {
                i = i3;
            }
        }
        return i;
    }
}
