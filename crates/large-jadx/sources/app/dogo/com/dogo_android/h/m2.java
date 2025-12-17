package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* loaded from: classes.dex */
public abstract class m2 extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final ImageView S;
    public final TextView T;
    public final TextView U;
    public final View V;
    public final Button W;
    public final TextView X;
    public final TextView Y;
    protected ProgramExam Z;
    protected m2(Object object, View view2, int i3, Barrier barrier4, TextView textView5, ImageView imageView6, ImageView imageView7, TextView textView8, TextView textView9, CardView cardView10, ImageView imageView11, TextView textView12, TextView textView13, View view14, ImageView imageView15, Button button16, TextView textView17, TextView textView18, TextView textView19) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = textView5;
        obj.P = imageView7;
        obj.Q = textView8;
        obj.R = textView9;
        obj.S = imageView11;
        obj.T = textView12;
        obj.U = textView13;
        obj.V = view14;
        obj.W = button16;
        obj.X = textView18;
        obj.Y = textView19;
    }

    public static app.dogo.com.dogo_android.h.m2 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return m2.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m2 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (m2)ViewDataBinding.z(layoutInflater, 2131558491, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
