package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellVariationTipBinding.java */
/* loaded from: classes.dex */
public abstract class w7 extends ViewDataBinding {

    public final TextView O;
    protected String P;
    protected w7(Object object, View view, int i, ImageView imageView, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static w7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w7)ViewDataBinding.z(layoutInflater, 2131558562, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
