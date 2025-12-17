package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.u.m.y.g;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class og extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    public final app.dogo.com.dogo_android.h.wh R;
    public final MaterialButton S;
    public final MaterialButton T;
    public final Space U;
    public final MaterialToolbar V;
    protected g W;
    protected og(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ImageView imageView6, TextView textView7, Guideline guideline8, app.dogo.com.dogo_android.h.wh wh9, MaterialButton materialButton10, MaterialButton materialButton11, Space space12, Guideline guideline13, MaterialToolbar materialToolbar14) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = imageView6;
        this.Q = textView7;
        this.R = wh9;
        this.S = materialButton10;
        this.T = materialButton11;
        this.U = space12;
        this.V = materialToolbar14;
    }

    public static app.dogo.com.dogo_android.h.og T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return og.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.og U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (og)ViewDataBinding.z(layoutInflater, 2131558714, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);
}
