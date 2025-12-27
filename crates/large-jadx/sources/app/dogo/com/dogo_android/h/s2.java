package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellIntervalSelectorBinding.java */
/* loaded from: classes.dex */
public abstract class s2 extends ViewDataBinding {

    public final TextView O;
    protected Long P;
    protected s2(Object object, View view, int i, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static s2 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s2.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s2 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s2)ViewDataBinding.z(layoutInflater, 2131558494, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Long long);
}
