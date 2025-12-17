package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.Article;

/* loaded from: classes.dex */
public abstract class q2 extends ViewDataBinding {

    protected Article O;
    protected q2(Object object, View view2, int i3) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.q2 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q2.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q2 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q2)ViewDataBinding.z(layoutInflater, 2131558493, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Article article);
}
