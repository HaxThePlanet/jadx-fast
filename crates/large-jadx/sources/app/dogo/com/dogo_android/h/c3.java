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

/* compiled from: CellLibraryProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class c3 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final TextView Q;
    public final CardView R;
    public final ImageView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final TextView W;
    protected ProgramDescriptionItem X;
    protected c3(Object object, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, CardView cardView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Guideline guideline, TextView textView6) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = imageView;
        this.Q = textView;
        this.R = cardView;
        this.S = imageView2;
        this.T = textView2;
        this.U = textView3;
        this.V = textView4;
        this.W = textView6;
    }

    public static c3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return c3.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static c3 V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (c3)ViewDataBinding.z(layoutInflater, 2131558499, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public ProgramDescriptionItem T() {
        return this.X;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(ProgramDescriptionItem programDescriptionItem);
}
