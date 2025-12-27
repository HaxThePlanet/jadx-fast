package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.Article;

/* compiled from: CellFaqListRowBinding.java */
/* loaded from: classes.dex */
public abstract class q2 extends ViewDataBinding {

    protected Article O;
    protected q2(Object object, View view, int i) {
        super(object, view, i);
    }

    public static q2 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q2.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q2 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q2)ViewDataBinding.z(layoutInflater, 2131558493, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Article article);
}
