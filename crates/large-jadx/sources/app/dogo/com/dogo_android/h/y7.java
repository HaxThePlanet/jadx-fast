package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;

/* compiled from: CellWelcomeSlideBinding.java */
/* loaded from: classes.dex */
public abstract class y7 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final TextView Q;
    protected WelcomeSlide R;
    protected y7(Object object, View view, int i, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
        this.Q = textView3;
    }

    public static y7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y7)ViewDataBinding.z(layoutInflater, 2131558563, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(WelcomeSlide welcomeSlide);
}
