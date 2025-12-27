package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* compiled from: CellProgramLessonActiveItemBinding.java */
/* loaded from: classes.dex */
public abstract class s4 extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    protected ProgramLesson R;
    protected s4(Object object, View view, int i, TextView textView, Guideline guideline, ImageView imageView, ImageView imageView2, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = imageView;
        this.Q = textView2;
    }

    public static s4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s4)ViewDataBinding.z(layoutInflater, 2131558520, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramLesson programLesson);
}
