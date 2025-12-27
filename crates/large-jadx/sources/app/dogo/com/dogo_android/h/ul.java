package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.n.k;
import java.util.List;

/* compiled from: LayoutPottyOverviewLogsBinding.java */
/* loaded from: classes.dex */
public abstract class ul extends ViewDataBinding {

    public final ej O;
    public final cj P;
    public final qj Q;
    protected SpecialProgramOverviewItem R;
    protected k S;
    protected List<Boolean> T;
    protected ul(Object object, View view, int i, ej ejVar, TextView textView, cj cjVar, qj qjVar, TextView textView2) {
        super(object, view, i);
        this.O = ejVar;
        this.P = cjVar;
        this.Q = qjVar;
    }

    public static ul T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ul.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ul U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ul)ViewDataBinding.z(layoutInflater, 2131558792, viewGroup, z, object);
    }
}
