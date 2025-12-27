package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellSpecialProgramExerciseBinding.java */
/* loaded from: classes.dex */
public abstract class k7 extends ViewDataBinding {

    public final View O;
    protected TrickItem P;
    protected k7(Object object, View view, int i, View view2) {
        super(object, view, i);
        this.O = view2;
    }

    public static k7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k7)ViewDataBinding.z(layoutInflater, 2131558555, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
