package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends androidx.preference.ListPreference {

    private final Context Q;
    private final ArrayAdapter R;
    public DropDownPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, c.c);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        this.Q = context;
        this.R = E();
        F();
    }

    private void F() {
        java.lang.CharSequence[] objArr;
        int length;
        int i;
        String string;
        ArrayAdapter arrayAdapter;
        this.R.clear();
        if (B() != null) {
            objArr = B();
            i = 0;
            while (i < objArr.length) {
                this.R.add(objArr[i].toString());
                i++;
            }
        }
    }

    @Override // androidx.preference.ListPreference
    protected ArrayAdapter E() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.Q, 17367049);
        return arrayAdapter;
    }

    @Override // androidx.preference.ListPreference
    protected void r() {
        super.r();
        final ArrayAdapter arrayAdapter = this.R;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
