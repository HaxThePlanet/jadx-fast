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

/* compiled from: FragmentInnAppFeedbackBinding.java */
/* loaded from: classes.dex */
public abstract class md extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final Button Q;
    public final Button R;
    protected k S;
    protected md(Object object, View view, int i, TextView textView, TextView textView2, Guideline guideline, ImageView imageView, Button button, TextInputLayout textInputLayout, Guideline guideline2, Button button2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
        this.Q = button;
        this.R = button2;
    }

    public static md T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return md.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static md U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (md)ViewDataBinding.z(layoutInflater, 2131558673, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k kVar);
}
