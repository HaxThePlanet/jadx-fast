package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;

/* loaded from: classes.dex */
public abstract class c5 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected LessonIntroduction Q;
    protected c5(Object object, View view2, int i3, TextView textView4, TextView textView5) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.c5 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return c5.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c5 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (c5)ViewDataBinding.z(layoutInflater, 2131558525, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(LessonIntroduction lessonIntroduction);
}
