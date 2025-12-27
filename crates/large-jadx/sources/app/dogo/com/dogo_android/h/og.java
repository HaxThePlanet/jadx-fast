package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.u.m.y.g;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentSpecialProgramCertificateBinding.java */
/* loaded from: classes.dex */
public abstract class og extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    public final wh R;
    public final MaterialButton S;
    public final MaterialButton T;
    public final Space U;
    public final MaterialToolbar V;
    protected g W;
    protected og(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, Guideline guideline, wh whVar, MaterialButton materialButton, MaterialButton materialButton2, Space space, Guideline guideline2, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = textView;
        this.P = imageView2;
        this.Q = textView2;
        this.R = whVar;
        this.S = materialButton;
        this.T = materialButton2;
        this.U = space;
        this.V = materialToolbar;
    }

    public static og T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return og.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static og U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (og)ViewDataBinding.z(layoutInflater, 2131558714, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);
}
