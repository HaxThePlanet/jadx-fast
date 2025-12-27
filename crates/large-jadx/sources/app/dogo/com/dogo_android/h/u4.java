package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;

/* compiled from: CellProgramLessonCardBinding.java */
/* loaded from: classes.dex */
public abstract class u4 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    protected LessonCardItem T;
    protected u4(Object object, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = textView;
        this.R = textView2;
        this.S = textView3;
    }

    public static u4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return u4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static u4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (u4)ViewDataBinding.z(layoutInflater, 2131558521, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LessonCardItem lessonCardItem);
}
