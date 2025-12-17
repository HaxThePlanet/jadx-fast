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
public abstract class i4 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final ImageView S;
    public final ImageView T;
    protected ProgramExam U;
    protected i4(Object object, View view2, int i3, ConstraintLayout constraintLayout4, ImageView imageView5, TextView textView6, TextView textView7, ImageView imageView8, ImageView imageView9, ImageView imageView10) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = imageView5;
        this.Q = textView6;
        this.R = textView7;
        this.S = imageView8;
        this.T = imageView9;
    }

    public static app.dogo.com.dogo_android.h.i4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return i4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.i4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (i4)ViewDataBinding.z(layoutInflater, 2131558515, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
