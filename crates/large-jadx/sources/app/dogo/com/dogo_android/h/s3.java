package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;

/* compiled from: CellPottyOverviewArticleBinding.java */
/* loaded from: classes.dex */
public abstract class s3 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final TextView P;
    protected ArticleWithStatus Q;
    protected s3(Object object, View view, int i, AppCompatImageView appCompatImageView, TextView textView, AppCompatImageView appCompatImageView2) {
        super(object, view, i);
        this.O = appCompatImageView;
        this.P = textView;
    }

    public static s3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s3)ViewDataBinding.z(layoutInflater, 2131558507, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ArticleWithStatus articleWithStatus);
}
