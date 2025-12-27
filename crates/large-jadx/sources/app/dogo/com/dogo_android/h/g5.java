package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* compiled from: CellProgramLessonLockedItemBinding.java */
/* loaded from: classes.dex */
public abstract class g5 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected ProgramLesson Q;
    protected g5(Object object, View view, int i, TextView textView, Guideline guideline, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
    }

    public static g5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g5)ViewDataBinding.z(layoutInflater, 2131558527, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramLesson programLesson);
}
