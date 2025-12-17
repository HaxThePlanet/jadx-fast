package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class SeekBarPreference extends androidx.preference.Preference {

    int L;
    private int M;
    private int N;
    boolean O;
    boolean P;
    public SeekBarPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, c.h);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.y0, i3, i4);
        final int obj4 = 0;
        this.L = obj2.getInt(f.B0, obj4);
        A(obj2.getInt(f.z0, 100));
        B(obj2.getInt(f.C0, obj4));
        this.O = obj2.getBoolean(f.A0, true);
        obj2.getBoolean(f.D0, obj4);
        this.P = obj2.getBoolean(f.E0, obj4);
        obj2.recycle();
    }

    @Override // androidx.preference.Preference
    public final void A(int i) {
        int obj2;
        int i2 = this.L;
        if (i < i2) {
            obj2 = i2;
        }
        if (obj2 != this.M) {
            this.M = obj2;
            r();
        }
    }

    @Override // androidx.preference.Preference
    public final void B(int i) {
        int i2;
        int i3;
        int obj3;
        if (i != this.N) {
            this.N = Math.min(i4 -= i3, Math.abs(i));
            r();
        }
    }

    @Override // androidx.preference.Preference
    protected Object u(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }
}
