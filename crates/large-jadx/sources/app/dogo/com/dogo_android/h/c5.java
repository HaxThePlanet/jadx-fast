package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;

/* compiled from: CellProgramLessonIntroductionBinding.java */
/* loaded from: classes.dex */
public abstract class c5 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected LessonIntroduction Q;
    protected c5(Object object, View view, int i, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
    }

    public static c5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return c5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static c5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (c5)ViewDataBinding.z(layoutInflater, 2131558525, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LessonIntroduction lessonIntroduction);
}
