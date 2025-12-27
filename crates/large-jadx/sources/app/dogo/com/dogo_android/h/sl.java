package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;

/* compiled from: LayoutPottyOverviewArticlesBinding.java */
/* loaded from: classes.dex */
public abstract class sl extends ViewDataBinding {

    protected SpecialProgramOverviewItem O;
    protected j P;
    protected sl(Object object, View view, int i, TextView textView) {
        super(object, view, i);
    }

    public static sl T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sl.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sl U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sl)ViewDataBinding.z(layoutInflater, 2131558791, viewGroup, z, object);
    }
}
