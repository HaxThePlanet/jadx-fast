package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellChallengeDogSelectRowBinding.java */
/* loaded from: classes.dex */
public abstract class q0 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    protected q0(Object object, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView3;
        this.Q = textView;
    }

    public static q0 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q0.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q0 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q0)ViewDataBinding.z(layoutInflater, 2131558466, viewGroup, z, object);
    }
}
