package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellWorkoutTrickBinding.java */
/* loaded from: classes.dex */
public abstract class a8 extends ViewDataBinding {

    public final CardView O;
    public final TextView P;
    public final TextView Q;
    public final ImageView R;
    protected TrickItem S;
    protected a8(Object object, View view, int i, CardView cardView, TextView textView, TextView textView2, ImageView imageView) {
        super(object, view, i);
        this.O = cardView;
        this.P = textView;
        this.Q = textView2;
        this.R = imageView;
    }

    public static a8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return a8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static a8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (a8)ViewDataBinding.z(layoutInflater, 2131558564, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
