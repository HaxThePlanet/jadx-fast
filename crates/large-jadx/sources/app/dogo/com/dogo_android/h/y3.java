package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellPottyTrackerOverviewBinding.java */
/* loaded from: classes.dex */
public abstract class y3 extends ViewDataBinding {

    protected Integer O;
    protected y3(Object object, View view, int i) {
        super(object, view, i);
    }

    public static y3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y3)ViewDataBinding.z(layoutInflater, 2131558510, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Integer integer);
}
