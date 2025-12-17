package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public abstract class g0 extends ViewDataBinding {

    public final View O;
    public final View P;
    public final FrameLayout Q;
    public final app.dogo.com.dogo_android.h.wm R;
    protected SponsorBannerViewModel S;
    protected g0 T;
    protected a0 U;
    protected g0(Object object, View view2, int i3, View view4, View view5, FrameLayout frameLayout6, app.dogo.com.dogo_android.h.wm wm7) {
        super(object, view2, i3);
        this.O = view4;
        this.P = view5;
        this.Q = frameLayout6;
        this.R = wm7;
    }

    public static app.dogo.com.dogo_android.h.g0 T(View view) {
        return g0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g0 U(View view, Object object2) {
        return (g0)ViewDataBinding.k(object2, view, 2131558461);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g0 g0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(SponsorBannerViewModel sponsorBannerViewModel);
}
