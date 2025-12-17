package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class w6 extends ViewDataBinding {

    public final CheckedTextView O;
    protected String P;
    protected w6(Object object, View view2, int i3, CheckedTextView checkedTextView4) {
        super(object, view2, i3);
        this.O = checkedTextView4;
    }

    public static app.dogo.com.dogo_android.h.w6 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return w6.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w6 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (w6)ViewDataBinding.z(layoutInflater, 2131558548, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);
}
