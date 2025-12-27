package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: CellRecommendedProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class s6 extends ViewDataBinding {

    public final CardView O;
    public final ImageView P;
    public final TextView Q;
    public final Button R;
    public final TextView S;
    public final TextView T;
    protected ProgramDescriptionItem U;
    protected s6(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, CardView cardView, CardView cardView2, ImageView imageView3, TextView textView2, TextView textView3, Button button, ImageView imageView4, TextView textView4, TextView textView5, TextView textView6) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = cardView;
        object2.P = imageView3;
        object2.Q = textView2;
        object2.R = button;
        object2.S = textView4;
        object2.T = textView6;
    }

    public static s6 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s6.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s6)ViewDataBinding.z(layoutInflater, 2131558546, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}
