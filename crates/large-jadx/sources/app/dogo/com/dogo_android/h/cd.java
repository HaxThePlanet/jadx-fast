package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.Article;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentFaqDetailBinding.java */
/* loaded from: classes.dex */
public abstract class cd extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final MaterialToolbar Q;
    protected Article R;
    protected cd(Object object, View view, int i, TextView textView, TextView textView2, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
        this.Q = materialToolbar;
    }

    public static cd T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return cd.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static cd U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (cd)ViewDataBinding.z(layoutInflater, 2131558668, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Article article);
}
