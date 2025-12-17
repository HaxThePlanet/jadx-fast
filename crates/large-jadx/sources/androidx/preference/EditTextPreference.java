package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.e.g;

/* loaded from: classes.dex */
public class EditTextPreference extends androidx.preference.DialogPreference {

    private String M;

    public static final class a implements androidx.preference.Preference.c<androidx.preference.EditTextPreference> {

        private static androidx.preference.EditTextPreference.a a;
        public static androidx.preference.EditTextPreference.a b() {
            androidx.preference.EditTextPreference.a aVar;
            if (EditTextPreference.a.a == null) {
                aVar = new EditTextPreference.a();
                EditTextPreference.a.a = aVar;
            }
            return EditTextPreference.a.a;
        }

        @Override // androidx.preference.Preference$c
        public java.lang.CharSequence a(androidx.preference.Preference preference) {
            return c((EditTextPreference)preference);
        }

        @Override // androidx.preference.Preference$c
        public java.lang.CharSequence c(androidx.preference.EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty(editTextPreference.A())) {
                return editTextPreference.e().getString(e.a);
            }
            return editTextPreference.A();
        }
    }
    public EditTextPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.d, 16842898));
    }

    public EditTextPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        boolean obj3;
        super(context, attributeSet2, i3, i4);
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.u, i3, i4);
        obj3 = f.v;
        if (g.b(obj2, obj3, obj3, false)) {
            x(EditTextPreference.a.b());
        }
        obj2.recycle();
    }

    @Override // androidx.preference.DialogPreference
    public String A() {
        return this.M;
    }

    @Override // androidx.preference.DialogPreference
    protected Object u(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // androidx.preference.DialogPreference
    public boolean y() {
        int i;
        boolean empty;
        if (!TextUtils.isEmpty(this.M)) {
            if (super.y()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
