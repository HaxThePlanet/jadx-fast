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

/* compiled from: CellProgramLessonHeaderCardBinding.java */
/* loaded from: classes.dex */
public abstract class y4 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    protected LessonCardItem S;
    protected y4(Object object, View view, int i, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, View view2, ImageView imageView2, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = imageView2;
        this.Q = textView2;
        this.R = textView3;
    }

    public static y4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y4)ViewDataBinding.z(layoutInflater, 2131558523, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LessonCardItem lessonCardItem);
}
