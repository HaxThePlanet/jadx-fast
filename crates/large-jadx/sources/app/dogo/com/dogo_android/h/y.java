package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellBitingTrickVariationBinding.java */
/* loaded from: classes.dex */
public abstract class y extends ViewDataBinding {

    public final TextView O;
    protected TrickItem P;
    protected y(Object object, View view, int i, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static y T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y)ViewDataBinding.z(layoutInflater, 2131558456, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
