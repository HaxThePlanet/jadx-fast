package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.inappmessaging.OneTenRadioGroup;
import app.dogo.com.dogo_android.inappmessaging.n;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentInnAppOneTenBinding.java */
/* loaded from: classes.dex */
public abstract class od extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final ImageView Q;
    public final Button R;
    public final OneTenRadioGroup S;
    public final MaterialButton T;
    protected n U;
    protected od(Object object, View view, int i, TextView textView, TextView textView2, Guideline guideline, TextView textView3, ImageView imageView, Button button, OneTenRadioGroup oneTenRadioGroup, Guideline guideline2, MaterialButton materialButton) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
        this.Q = imageView;
        this.R = button;
        this.S = oneTenRadioGroup;
        this.T = materialButton;
    }

    public static od T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return od.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static od U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (od)ViewDataBinding.z(layoutInflater, 2131558674, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n nVar);
}
