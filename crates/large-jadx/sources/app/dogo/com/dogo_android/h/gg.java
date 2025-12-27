package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.n.m.t.g;

/* compiled from: FragmentRateTrickV2Binding.java */
/* loaded from: classes.dex */
public abstract class gg extends ViewDataBinding {

    public final Button O;
    public final Button P;
    public final om Q;
    protected g R;
    protected gg(Object object, View view, int i, Button button, Button button2, ImageView imageView, om omVar, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = button2;
        this.Q = omVar;
    }

    public static gg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return gg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static gg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (gg)ViewDataBinding.z(layoutInflater, 2131558710, viewGroup, z, object);
    }
}
