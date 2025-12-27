package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;

/* compiled from: CellLibraryTagBinding.java */
/* loaded from: classes.dex */
public abstract class e3 extends ViewDataBinding {

    protected LibraryTag O;
    protected e3(Object object, View view, int i) {
        super(object, view, i);
    }

    public static e3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return e3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static e3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (e3)ViewDataBinding.z(layoutInflater, 2131558500, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LibraryTag libraryTag);
}
