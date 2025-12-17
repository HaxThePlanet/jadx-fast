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
public abstract class m4 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    public final ImageView Q;
    protected ProgramExam R;
    protected m4(Object object, View view2, int i3, ImageView imageView4, TextView textView5, TextView textView6, ImageView imageView7, ImageView imageView8) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = textView5;
        this.Q = imageView7;
    }

    public static app.dogo.com.dogo_android.h.m4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return m4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (m4)ViewDataBinding.z(layoutInflater, 2131558517, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
