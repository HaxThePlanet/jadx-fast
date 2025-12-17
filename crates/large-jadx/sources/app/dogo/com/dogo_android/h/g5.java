package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* loaded from: classes.dex */
public abstract class g5 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected ProgramLesson Q;
    protected g5(Object object, View view2, int i3, TextView textView4, Guideline guideline5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView6;
    }

    public static app.dogo.com.dogo_android.h.g5 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return g5.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g5 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (g5)ViewDataBinding.z(layoutInflater, 2131558527, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramLesson programLesson);
}
