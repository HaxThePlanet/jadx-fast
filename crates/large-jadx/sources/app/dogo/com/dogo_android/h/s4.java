package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* loaded from: classes.dex */
public abstract class s4 extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    protected ProgramLesson R;
    protected s4(Object object, View view2, int i3, TextView textView4, Guideline guideline5, ImageView imageView6, ImageView imageView7, TextView textView8) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = imageView6;
        this.Q = textView8;
    }

    public static app.dogo.com.dogo_android.h.s4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s4)ViewDataBinding.z(layoutInflater, 2131558520, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramLesson programLesson);
}
