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

/* compiled from: CellProgramLessonUnlockedItemBinding.java */
/* loaded from: classes.dex */
public abstract class k5 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected ProgramLesson Q;
    protected k5(Object object, View view, int i, TextView textView, Guideline guideline, ImageView imageView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
    }

    public static k5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k5)ViewDataBinding.z(layoutInflater, 2131558529, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramLesson programLesson);
}
