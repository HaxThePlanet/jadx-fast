package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellProgramTrainingSmallTrickBinding.java */
/* loaded from: classes.dex */
public abstract class k6 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final ImageView P;
    public final TextView Q;
    public final AppCompatImageView R;
    protected TrickItem S;
    protected k6(Object object, View view, int i, View view2, AppCompatImageView appCompatImageView, ImageView imageView, TextView textView, AppCompatImageView appCompatImageView2) {
        super(object, view, i);
        this.O = appCompatImageView;
        this.P = imageView;
        this.Q = textView;
        this.R = appCompatImageView2;
    }

    public static k6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k6.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k6 V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k6)ViewDataBinding.z(layoutInflater, 2131558542, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public TrickItem T() {
        return this.S;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrickItem trickItem);
}
