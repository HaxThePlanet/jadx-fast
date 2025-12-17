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
public abstract class o5 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected ProgramExam Q;
    protected o5(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout6, TextView textView7) {
        super(object, view2, i3);
        this.O = imageView5;
        this.P = textView7;
    }

    public static app.dogo.com.dogo_android.h.o5 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return o5.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.o5 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (o5)ViewDataBinding.z(layoutInflater, 2131558531, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
