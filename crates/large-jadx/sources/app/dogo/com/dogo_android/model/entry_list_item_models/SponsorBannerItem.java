package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.q;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.h.g0;
import app.dogo.com.dogo_android.h.wm;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.util.n0.e;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;

/* loaded from: classes.dex */
public class SponsorBannerItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    private app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem.ViewHolder holder;
    private String id;
    private ChallengeModel model;
    private app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel vm;

    static final class ViewHolder extends b {

        private g0 holderBinding;
        private final FrameLayout layout;
        final RecyclerView.q params;
        private g0 uvm;
        private app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel vm;
        public ViewHolder(View view, e e2) {
            super(view, e2);
            this.holderBinding = g0.T(view);
            SponsorBannerViewModel obj3 = new SponsorBannerViewModel();
            this.vm = obj3;
            this.uvm = e2.n2();
            this.layout = obj3.Q;
            obj3 = new RecyclerView.q(-1, -2);
            this.params = obj3;
            this.holderBinding.X(this.vm);
            obj3.R.T(this.vm);
            this.holderBinding.V(this.uvm);
            this.holderBinding.W(e2.l2());
        }

        static g0 access$000(app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem.ViewHolder sponsorBannerItem$ViewHolder) {
            return viewHolder.holderBinding;
        }

        @Override // h.a.c.b
        public void Layout_hide() {
            RecyclerView.q params = this.params;
            params.height = 0;
            this.layout.setLayoutParams(params);
            holderBinding.Q.setVisibility(8);
        }

        @Override // h.a.c.b
        public app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel getVm() {
            return this.vm;
        }

        @Override // h.a.c.b
        public void setModel(ChallengeModel challengeModel) {
            this.vm.setModel(challengeModel);
        }

        @Override // h.a.c.b
        public void show() {
            RecyclerView.q params = this.params;
            params.height = -2;
            this.layout.setLayoutParams(params);
            holderBinding.Q.setVisibility(0);
        }
    }
    public SponsorBannerItem(String string) {
        super(0);
        this.id = string;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (SponsorBannerItem.ViewHolder)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem.ViewHolder sponsorBannerItem$ViewHolder2, int i3, List list4) {
        viewHolder2.setModel(this.model);
        app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel obj1 = viewHolder2.getVm();
        this.vm = obj1;
        this.holder = viewHolder2;
        if (obj1.isBannerVisible()) {
            viewHolder2.show();
        } else {
            viewHolder2.Layout_hide();
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeChallenge(ChallengeModel challengeModel) {
        Object obj2;
        this.model = challengeModel;
        final app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel view = this.vm;
        view.changeModel(challengeModel);
        if (view != null && this.holder != null) {
            view.changeModel(challengeModel);
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
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem.ViewHolder createViewHolder(View view, b b2) {
        SponsorBannerItem.ViewHolder viewHolder = new SponsorBannerItem.ViewHolder(view, (e)b2);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof SponsorBannerItem) {
            return this.id.equals(object.id);
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public float getHeight() {
        app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem.ViewHolder holder = this.holder;
        if (holder != null) {
            return (float)height;
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558461;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getPosition() {
        Object holder;
        int[] iArr;
        holder = this.holder;
        iArr = new int[2];
        holder.getContentView().getLocationOnScreen(iArr);
        if (holder != null && this.vm != null) {
            iArr = new int[2];
            holder.getContentView().getLocationOnScreen(iArr);
            if (this.vm != null) {
                return iArr[1];
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3) {
        unbindViewHolder(b, (SponsorBannerItem.ViewHolder)e02, i3);
    }

    public void unbindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem.ViewHolder sponsorBannerItem$ViewHolder2, int i3) {
        final int obj1 = 0;
        this.vm = obj1;
        this.holder = obj1;
    }
}
