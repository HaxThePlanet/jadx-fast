package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel;

/* loaded from: classes.dex */
public abstract class wm extends ViewDataBinding {

    protected SponsorBannerViewModel O;
    protected wm(Object object, View view2, int i3) {
        super(object, view2, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(SponsorBannerViewModel sponsorBannerViewModel);
}
