package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellEmptyBinding.java */
/* loaded from: classes.dex */
public abstract class y1 extends ViewDataBinding {
    protected y1(Object object, View view, int i) {
        super(object, view, i);
    }

    public static y1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y1)ViewDataBinding.z(layoutInflater, 2131558483, viewGroup, z, object);
    }
}
