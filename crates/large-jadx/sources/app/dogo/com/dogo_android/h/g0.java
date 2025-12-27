package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: CellChallengeBannerItemBinding.java */
/* loaded from: classes.dex */
public abstract class g0 extends ViewDataBinding {

    public final View O;
    public final View P;
    public final FrameLayout Q;
    public final wm R;
    protected SponsorBannerViewModel S;
    protected g0 T;
    protected a0 U;
    protected g0(Object object, View view, int i, View view2, View view3, FrameLayout frameLayout, wm wmVar) {
        super(object, view, i);
        this.O = view2;
        this.P = view3;
        this.Q = frameLayout;
        this.R = wmVar;
    }

    public static g0 T(View view) {
        return g0.U(view, f.e());
    }

    @Deprecated
    public static g0 U(View view, Object object) {
        return (g0)ViewDataBinding.k(object, view, 2131558461);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g0 g0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(SponsorBannerViewModel sponsorBannerViewModel);
}
