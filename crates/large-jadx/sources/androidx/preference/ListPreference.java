package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.e.g;

/* loaded from: classes.dex */
public class ListPreference extends androidx.preference.DialogPreference {

    private java.lang.CharSequence[] M;
    private java.lang.CharSequence[] N;
    private String O;
    private String P;

    public static final class a implements androidx.preference.Preference.c<androidx.preference.ListPreference> {

        private static androidx.preference.ListPreference.a a;
        public static androidx.preference.ListPreference.a b() {
            androidx.preference.ListPreference.a aVar;
            if (ListPreference.a.a == null) {
                aVar = new ListPreference.a();
                ListPreference.a.a = aVar;
            }
            return ListPreference.a.a;
        }

        @Override // androidx.preference.Preference$c
        public java.lang.CharSequence a(androidx.preference.Preference preference) {
            return c((ListPreference)preference);
        }

        @Override // androidx.preference.Preference$c
        public java.lang.CharSequence c(androidx.preference.ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.C())) {
                return listPreference.e().getString(e.a);
            }
            return listPreference.C();
        }
    }
    public ListPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.b, 16842897));
    }

    public ListPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        boolean z;
        super(context, attributeSet2, i3, i4);
        TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, f.w, i3, i4);
        this.M = g.q(styledAttributes, f.z, f.x);
        this.N = g.q(styledAttributes, f.A, f.y);
        int i5 = f.B;
        if (g.b(styledAttributes, i5, i5, false)) {
            x(ListPreference.a.b());
        }
        styledAttributes.recycle();
        final TypedArray obj4 = context.obtainStyledAttributes(attributeSet2, f.H, i3, i4);
        this.P = g.o(obj4, f.p0, f.P);
        obj4.recycle();
    }

    private int D() {
        return A(this.O);
    }

    @Override // androidx.preference.DialogPreference
    public int A(String string) {
        java.lang.CharSequence[] objArr;
        boolean equals;
        objArr = this.N;
        if (string != null && objArr != null) {
            objArr = this.N;
            if (objArr != null) {
                length--;
                while (objArr >= 0) {
                    objArr--;
                }
            }
        }
        return -1;
    }

    @Override // androidx.preference.DialogPreference
    public java.lang.CharSequence[] B() {
        return this.M;
    }

    @Override // androidx.preference.DialogPreference
    public java.lang.CharSequence C() {
        int i;
        java.lang.CharSequence[] objArr;
        int i2 = D();
        objArr = this.M;
        if (i2 >= 0 && objArr != null) {
            objArr = this.M;
            i = objArr != null ? objArr[i2] : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.preference.DialogPreference
    public java.lang.CharSequence k() {
        Object str;
        if (m() != null) {
            return m().a(this);
        }
        java.lang.CharSequence charSequence2 = super.k();
        String str3 = this.P;
        if (str3 == null) {
            return charSequence2;
        }
        Object[] arr = new Object[1];
        if (C() == null) {
            str = "";
        }
        String format = String.format(str3, str);
        if (TextUtils.equals(format, charSequence2)) {
            return charSequence2;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    @Override // androidx.preference.DialogPreference
    protected Object u(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }
}
