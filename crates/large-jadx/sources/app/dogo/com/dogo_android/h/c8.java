package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellWorkoutTrickCardBinding.java */
/* loaded from: classes.dex */
public abstract class c8 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected TrickItem Q;
    protected c8(Object object, View view, int i, ImageView imageView, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
    }

    public static c8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return c8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static c8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (c8)ViewDataBinding.z(layoutInflater, 2131558565, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
