package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;

/* loaded from: classes.dex */
public abstract class s3 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final TextView P;
    protected ArticleWithStatus Q;
    protected s3(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, TextView textView5, AppCompatImageView appCompatImageView6) {
        super(object, view2, i3);
        this.O = appCompatImageView4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.s3 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s3.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s3)ViewDataBinding.z(layoutInflater, 2131558507, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ArticleWithStatus articleWithStatus);
}
