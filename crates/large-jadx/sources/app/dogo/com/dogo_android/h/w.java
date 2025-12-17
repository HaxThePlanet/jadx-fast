package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;

/* loaded from: classes.dex */
public abstract class w extends ViewDataBinding {

    protected LibraryTag O;
    protected w(Object object, View view2, int i3) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.w T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return w.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (w)ViewDataBinding.z(layoutInflater, 2131558455, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LibraryTag libraryTag);
}
