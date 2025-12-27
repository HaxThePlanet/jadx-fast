package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.k.e;

/* compiled from: CellDogLogTypeBinding.java */
/* loaded from: classes.dex */
public abstract class s1 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    protected e R;
    protected Boolean S;
    protected s1(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = textView;
    }

    public static s1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s1)ViewDataBinding.z(layoutInflater, 2131558480, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(Boolean boolean);
}
