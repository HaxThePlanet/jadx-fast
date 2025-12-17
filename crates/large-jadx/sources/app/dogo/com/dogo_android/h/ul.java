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

/* loaded from: classes.dex */
public abstract class ul extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ej O;
    public final app.dogo.com.dogo_android.h.cj P;
    public final app.dogo.com.dogo_android.h.qj Q;
    protected SpecialProgramOverviewItem R;
    protected k S;
    protected List<Boolean> T;
    protected ul(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ej ej4, TextView textView5, app.dogo.com.dogo_android.h.cj cj6, app.dogo.com.dogo_android.h.qj qj7, TextView textView8) {
        super(object, view2, i3);
        this.O = ej4;
        this.P = cj6;
        this.Q = qj7;
    }

    public static app.dogo.com.dogo_android.h.ul T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ul.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ul U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ul)ViewDataBinding.z(layoutInflater, 2131558792, viewGroup2, z3, object4);
    }
}
