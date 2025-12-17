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
import app.dogo.com.dogo_android.inappmessaging.k;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public abstract class md extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final Button Q;
    public final Button R;
    protected k S;
    protected md(Object object, View view2, int i3, TextView textView4, TextView textView5, Guideline guideline6, ImageView imageView7, Button button8, TextInputLayout textInputLayout9, Guideline guideline10, Button button11) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView5;
        this.Q = button8;
        this.R = button11;
    }

    public static app.dogo.com.dogo_android.h.md T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return md.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.md U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (md)ViewDataBinding.z(layoutInflater, 2131558673, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k k);
}
