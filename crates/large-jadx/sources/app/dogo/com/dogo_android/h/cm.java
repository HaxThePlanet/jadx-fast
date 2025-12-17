package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;

/* loaded from: classes.dex */
public abstract class cm extends ViewDataBinding {

    public final ImageView O;
    public final ProgressBar P;
    public final TextView Q;
    protected ProgramExamSummary R;
    protected cm(Object object, View view2, int i3, ImageView imageView4, TextView textView5, ImageView imageView6, ProgressBar progressBar7, TextView textView8) {
        super(object, view2, i3);
        this.O = imageView6;
        this.P = progressBar7;
        this.Q = textView8;
    }

    public static app.dogo.com.dogo_android.h.cm T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return cm.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.cm U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (cm)ViewDataBinding.z(layoutInflater, 2131558796, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExamSummary programExamSummary);
}
