package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellTrickNumberBubbleBinding.java */
/* loaded from: classes.dex */
public abstract class u7 extends ViewDataBinding {

    public final TextView O;
    protected String P;
    protected u7(Object object, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
    }

    public static u7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return u7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static u7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (u7)ViewDataBinding.z(layoutInflater, 2131558561, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
