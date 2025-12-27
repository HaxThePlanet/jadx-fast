package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.n.j;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentCertificateDetailBinding.java */
/* loaded from: classes.dex */
public abstract class ca extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    public final ea R;
    public final ProgressBar S;
    public final TextView T;
    public final MaterialButton U;
    public final MaterialButton V;
    public final Space W;
    public final Toolbar X;
    protected j Y;
    protected ca(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, Guideline guideline, ea eaVar, ProgressBar progressBar, TextView textView3, MaterialButton materialButton, MaterialButton materialButton2, Space space, Guideline guideline2, Toolbar toolbar) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = textView;
        object2.P = imageView2;
        object2.Q = textView2;
        object2.R = eaVar;
        object2.S = progressBar;
        object2.T = textView3;
        object2.U = materialButton;
        object2.V = materialButton2;
        object2.W = space;
        object2.X = toolbar;
    }

    public static ca U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ca.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ca V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ca)ViewDataBinding.z(layoutInflater, 2131558629, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public j T() {
        return this.Y;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l lVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(j jVar);
}
