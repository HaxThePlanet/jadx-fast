package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: FragmentEmptyBinding.java */
/* loaded from: classes.dex */
public abstract class sc extends ViewDataBinding {
    protected sc(Object object, View view, int i) {
        super(object, view, i);
    }

    public static sc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sc)ViewDataBinding.z(layoutInflater, 2131558663, viewGroup, z, object);
    }
}
