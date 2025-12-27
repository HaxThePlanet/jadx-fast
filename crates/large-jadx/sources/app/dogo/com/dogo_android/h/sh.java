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

/* compiled from: LayoutBitingProgramCertificateCombinedBinding.java */
/* loaded from: classes.dex */
public abstract class sh extends ViewDataBinding {

    public final ConstraintLayout O;
    public final qh P;
    public final yh Q;
    protected SpecialProgramOverviewItem R;
    protected j S;
    protected sh(Object object, View view, int i, ConstraintLayout constraintLayout, qh qhVar, ImageView imageView, yh yhVar) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = qhVar;
        this.Q = yhVar;
    }

    public static sh T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sh.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sh U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sh)ViewDataBinding.z(layoutInflater, 2131558738, viewGroup, z, object);
    }
}
