package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;

/* loaded from: classes.dex */
public abstract class sl extends ViewDataBinding {

    protected SpecialProgramOverviewItem O;
    protected j P;
    protected sl(Object object, View view2, int i3, TextView textView4) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.sl T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return sl.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.sl U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (sl)ViewDataBinding.z(layoutInflater, 2131558791, viewGroup2, z3, object4);
    }
}
