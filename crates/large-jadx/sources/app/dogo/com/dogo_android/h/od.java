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

/* loaded from: classes.dex */
public abstract class od extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final ImageView Q;
    public final Button R;
    public final OneTenRadioGroup S;
    public final MaterialButton T;
    protected n U;
    protected od(Object object, View view2, int i3, TextView textView4, TextView textView5, Guideline guideline6, TextView textView7, ImageView imageView8, Button button9, OneTenRadioGroup oneTenRadioGroup10, Guideline guideline11, MaterialButton materialButton12) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView5;
        this.Q = imageView8;
        this.R = button9;
        this.S = oneTenRadioGroup10;
        this.T = materialButton12;
    }

    public static app.dogo.com.dogo_android.h.od T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return od.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.od U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (od)ViewDataBinding.z(layoutInflater, 2131558674, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n n);
}
