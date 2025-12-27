package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: CellProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class a4 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final CardView Q;
    public final ImageView R;
    public final TextView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    protected ProgramDescriptionItem W;
    protected a4(Object object, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, CardView cardView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, Guideline guideline, TextView textView5) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = imageView;
        this.Q = cardView;
        this.R = imageView2;
        this.S = textView;
        this.T = textView2;
        this.U = textView3;
        this.V = textView5;
    }

    public static a4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return a4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static a4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (a4)ViewDataBinding.z(layoutInflater, 2131558511, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}
