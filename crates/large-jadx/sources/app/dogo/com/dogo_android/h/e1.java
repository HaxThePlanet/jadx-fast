package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellClickerSelectRowBinding.java */
/* loaded from: classes.dex */
public abstract class e1 extends ViewDataBinding {

    public final CheckedTextView O;
    protected String P;
    protected e1(Object object, View view, int i, CheckedTextView checkedTextView) {
        super(object, view, i);
        this.O = checkedTextView;
    }

    public static e1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return e1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static e1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (e1)ViewDataBinding.z(layoutInflater, 2131558473, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
