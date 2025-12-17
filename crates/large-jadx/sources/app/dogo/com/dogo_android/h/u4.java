package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;

/* loaded from: classes.dex */
public abstract class u4 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    protected LessonCardItem T;
    protected u4(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView7, TextView textView8, TextView textView9) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = textView7;
        this.R = textView8;
        this.S = textView9;
    }

    public static app.dogo.com.dogo_android.h.u4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return u4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.u4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (u4)ViewDataBinding.z(layoutInflater, 2131558521, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LessonCardItem lessonCardItem);
}
