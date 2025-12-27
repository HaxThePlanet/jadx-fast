package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;

/* compiled from: LayoutSpecialProgramExerciseBinding.java */
/* loaded from: classes.dex */
public abstract class sm extends ViewDataBinding {

    protected SpecialProgramOverviewItem O;
    protected j P;
    protected sm(Object object, View view, int i, TextView textView) {
        super(object, view, i);
    }

    public static sm T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sm.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sm U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sm)ViewDataBinding.z(layoutInflater, 2131558803, viewGroup, z, object);
    }
}
