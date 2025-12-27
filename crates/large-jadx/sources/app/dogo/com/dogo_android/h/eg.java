package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.e0.e;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentProgramTrickTryBinding.java */
/* loaded from: classes.dex */
public abstract class eg extends ViewDataBinding {

    public final TextView O;
    public final MaterialButton P;
    public final TextView Q;
    public final TextView R;
    public final ImageView S;
    protected e T;
    protected eg(Object object, View view, int i, TextView textView, TextView textView2, ImageView imageView, MaterialButton materialButton, TextView textView3, TextView textView4, TextView textView5, ImageView imageView2) {
        super(object, view, i);
        this.O = textView;
        this.P = materialButton;
        this.Q = textView3;
        this.R = textView4;
        this.S = imageView2;
    }

    public static eg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return eg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static eg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (eg)ViewDataBinding.z(layoutInflater, 2131558709, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}
