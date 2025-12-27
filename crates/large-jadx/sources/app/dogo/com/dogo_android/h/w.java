package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;

/* compiled from: CellArticleTagBinding.java */
/* loaded from: classes.dex */
public abstract class w extends ViewDataBinding {

    protected LibraryTag O;
    protected w(Object object, View view, int i) {
        super(object, view, i);
    }

    public static w T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w)ViewDataBinding.z(layoutInflater, 2131558455, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LibraryTag libraryTag);
}
