package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellProgramOverviewTrickCardBinding.java */
/* loaded from: classes.dex */
public abstract class y5 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected TrickItem Q;
    protected y5(Object object, View view, int i, ImageView imageView, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
    }

    public static y5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y5)ViewDataBinding.z(layoutInflater, 2131558536, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
