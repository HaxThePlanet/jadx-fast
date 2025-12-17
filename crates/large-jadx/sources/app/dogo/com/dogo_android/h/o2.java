package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* loaded from: classes.dex */
public abstract class o2 extends ViewDataBinding {

    public final TextView O;
    public final ConstraintLayout P;
    public final ImageView Q;
    public final TextView R;
    public final TextView S;
    public final ImageView T;
    protected ProgramExam U;
    protected o2(Object object, View view2, int i3, TextView textView4, ConstraintLayout constraintLayout5, ImageView imageView6, TextView textView7, TextView textView8, ImageView imageView9) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = constraintLayout5;
        this.Q = imageView6;
        this.R = textView7;
        this.S = textView8;
        this.T = imageView9;
    }

    public static app.dogo.com.dogo_android.h.o2 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return o2.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.o2 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (o2)ViewDataBinding.z(layoutInflater, 2131558492, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
