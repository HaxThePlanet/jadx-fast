package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;

/* loaded from: classes.dex */
public abstract class sh extends ViewDataBinding {

    public final ConstraintLayout O;
    public final app.dogo.com.dogo_android.h.qh P;
    public final app.dogo.com.dogo_android.h.yh Q;
    protected SpecialProgramOverviewItem R;
    protected j S;
    protected sh(Object object, View view2, int i3, ConstraintLayout constraintLayout4, app.dogo.com.dogo_android.h.qh qh5, ImageView imageView6, app.dogo.com.dogo_android.h.yh yh7) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = qh5;
        this.Q = yh7;
    }

    public static app.dogo.com.dogo_android.h.sh T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return sh.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.sh U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (sh)ViewDataBinding.z(layoutInflater, 2131558738, viewGroup2, z3, object4);
    }
}
