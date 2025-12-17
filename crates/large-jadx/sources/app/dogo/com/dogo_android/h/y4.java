package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;

/* loaded from: classes.dex */
public abstract class y4 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    protected LessonCardItem S;
    protected y4(Object object, View view2, int i3, ConstraintLayout constraintLayout4, TextView textView5, ImageView imageView6, View view7, ImageView imageView8, TextView textView9, TextView textView10) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = imageView8;
        this.Q = textView9;
        this.R = textView10;
    }

    public static app.dogo.com.dogo_android.h.y4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return y4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (y4)ViewDataBinding.z(layoutInflater, 2131558523, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LessonCardItem lessonCardItem);
}
