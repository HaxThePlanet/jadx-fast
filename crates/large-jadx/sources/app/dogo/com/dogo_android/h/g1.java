package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;

/* compiled from: CellCustomerExperienceBinding.java */
/* loaded from: classes.dex */
public abstract class g1 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final TextView P;
    public final TextView Q;
    protected CustomerExperience R;
    protected g1(Object object, View view, int i, AppCompatImageView appCompatImageView, TextView textView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, TextView textView2) {
        super(object, view, i);
        this.O = appCompatImageView;
        this.P = textView;
        this.Q = textView2;
    }

    public static g1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g1)ViewDataBinding.z(layoutInflater, 2131558474, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(CustomerExperience customerExperience);
}
