package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* loaded from: classes.dex */
public abstract class g4 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected ProgramExam Q;
    protected g4(Object object, View view2, int i3, ImageView imageView4, TextView textView5, TextView textView6) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.g4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return g4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (g4)ViewDataBinding.z(layoutInflater, 2131558514, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
