package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellProgramExamAvailableHeaderBinding.java */
/* loaded from: classes.dex */
public abstract class e4 extends ViewDataBinding {

    public final TextView O;
    protected Boolean P;
    protected e4(Object object, View view, int i, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
    }

    public static e4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return e4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static e4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (e4)ViewDataBinding.z(layoutInflater, 2131558513, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Boolean boolean);
}
