package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.q;
import app.dogo.com.dogo_android.h.wm;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.util.n0.e;
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.List;

/* compiled from: SponsorBannerItem.java */
/* loaded from: classes.dex */
public class SponsorBannerItem extends EntryItem<SponsorBannerItem.ViewHolder, EntrySortingTabItem> {

    private SponsorBannerItem.ViewHolder holder;
    private String id;
    private ChallengeModel model;
    private SponsorBannerViewModel vm;

    static final class ViewHolder extends h.a.c.b {

        private app.dogo.com.dogo_android.h.g0 holderBinding;
        private final FrameLayout layout;
        final RecyclerView.q params = new RecyclerView$q(-1, -2);
        private app.dogo.com.dogo_android.a0.g.f.g0 uvm;
        private SponsorBannerViewModel vm = new SponsorBannerViewModel();
        public ViewHolder(View view, e eVar) {
            super(view, eVar);
            this.holderBinding = g0.T(view);
            app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel sponsorBannerViewModel3 = new SponsorBannerViewModel();
            this.uvm = eVar.n2();
            this.layout = this.holderBinding.Q;
            RecyclerView.q qVar = new RecyclerView.q(-1, -2);
            this.holderBinding.X(this.vm);
            this.holderBinding.R.T(this.vm);
            this.holderBinding.V(this.uvm);
            this.holderBinding.W(eVar.l2());
        }

        static /* synthetic */ app.dogo.com.dogo_android.h.g0 access$000(SponsorBannerItem.ViewHolder viewHolder) {
            return viewHolder.holderBinding;
        }

        @Override // h.a.c.b
        public void Layout_hide() {
            this.params.height = 0;
            this.layout.setLayoutParams(this.params);
            this.holderBinding.Q.setVisibility(8);
        }

        @Override // h.a.c.b
        public SponsorBannerViewModel getVm() {
            return this.vm;
        }

        @Override // h.a.c.b
        public void setModel(ChallengeModel challengeModel) {
            this.vm.setModel(challengeModel);
        }

        @Override // h.a.c.b
        public void show() {
            this.params.height = -2;
            this.layout.setLayoutParams(this.params);
            this.holderBinding.Q.setVisibility(0);
        }
    }
    public SponsorBannerItem(String str) {
        super(null);
        this.id = str;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeChallenge(ChallengeModel challengeModel) {
        this.model = challengeModel;
        if (this.vm != null) {
            this.vm.changeModel(challengeModel);
            if (this.holder != null) {
                if (this.vm.isBannerVisible()) {
                    this.holder.show();
                } else {
                    this.holder.Layout_hide();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof SponsorBannerItem) {
            return this.id.equals(object.id);
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public float getHeight() {
        if (this.holder != null) {
            return (float)this.holder.holderBinding.w().getHeight();
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getPosition() {
        if (this.holder != null) {
            int[] iArr = new int[2];
            this.holder.getContentView().getLocationOnScreen(iArr);
            if (this.vm != null) {
                return iArr[1];
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b bVar, SponsorBannerItem.ViewHolder viewHolder, int i, List list) {
        viewHolder.setModel(this.model);
        app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel vm = viewHolder.getVm();
        this.vm = vm;
        this.holder = viewHolder;
        if (vm.isBannerVisible()) {
            viewHolder.show();
        } else {
            viewHolder.Layout_hide();
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public SponsorBannerItem.ViewHolder createViewHolder(View view, h.a.b.b bVar) {
        return new SponsorBannerItem.ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(h.a.b.b<f> bVar, SponsorBannerItem.ViewHolder viewHolder, int i) {
        final app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel sponsorBannerViewModel = null;
        this.vm = sponsorBannerViewModel;
        this.holder = sponsorBannerViewModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_challenge_banner_item;
    }
}
