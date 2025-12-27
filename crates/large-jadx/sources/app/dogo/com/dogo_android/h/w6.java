package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellRowLanguageRowBinding.java */
/* loaded from: classes.dex */
public abstract class w6 extends ViewDataBinding {

    public final CheckedTextView O;
    protected String P;
    protected w6(Object object, View view, int i, CheckedTextView checkedTextView) {
        super(object, view, i);
        this.O = checkedTextView;
    }

    public static w6 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w6.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w6)ViewDataBinding.z(layoutInflater, 2131558548, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
