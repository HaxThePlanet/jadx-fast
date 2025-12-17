package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.n.j;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class ca extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    public final app.dogo.com.dogo_android.h.ea R;
    public final ProgressBar S;
    public final TextView T;
    public final MaterialButton U;
    public final MaterialButton V;
    public final Space W;
    public final Toolbar X;
    protected j Y;
    protected ca(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ImageView imageView6, TextView textView7, Guideline guideline8, app.dogo.com.dogo_android.h.ea ea9, ProgressBar progressBar10, TextView textView11, MaterialButton materialButton12, MaterialButton materialButton13, Space space14, Guideline guideline15, Toolbar toolbar16) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = textView4;
        obj.P = imageView6;
        obj.Q = textView7;
        obj.R = ea9;
        obj.S = progressBar10;
        obj.T = textView11;
        obj.U = materialButton12;
        obj.V = materialButton13;
        obj.W = space14;
        obj.X = toolbar16;
    }

    public static app.dogo.com.dogo_android.h.ca U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ca.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ca V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ca)ViewDataBinding.z(layoutInflater, 2131558629, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public j T() {
        return this.Y;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l l);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(j j);
}
