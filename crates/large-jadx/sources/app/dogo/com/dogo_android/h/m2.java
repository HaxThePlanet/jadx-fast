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

/* compiled from: CellExamHistoryBinding.java */
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
    protected m2(Object object, View view, int i, Barrier barrier, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, CardView cardView, ImageView imageView3, TextView textView4, TextView textView5, View view2, ImageView imageView4, Button button, TextView textView6, TextView textView7, TextView textView8) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = textView;
        object2.P = imageView2;
        object2.Q = textView2;
        object2.R = textView3;
        object2.S = imageView3;
        object2.T = textView4;
        object2.U = textView5;
        object2.V = view2;
        object2.W = button;
        object2.X = textView7;
        object2.Y = textView8;
    }

    public static m2 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m2.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m2 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m2)ViewDataBinding.z(layoutInflater, 2131558491, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
