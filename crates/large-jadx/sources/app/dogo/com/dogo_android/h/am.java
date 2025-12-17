package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;

/* loaded from: classes.dex */
public abstract class am extends ViewDataBinding {

    public final ImageView O;
    protected ProgramExamSummary P;
    protected am(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ImageView imageView6, Guideline guideline7, Button button8, TextView textView9) {
        super(object, view2, i3);
        this.O = imageView5;
    }

    public static app.dogo.com.dogo_android.h.am T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return am.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.am U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (am)ViewDataBinding.z(layoutInflater, 2131558795, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExamSummary programExamSummary);
}
