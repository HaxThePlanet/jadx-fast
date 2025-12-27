package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.q;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.h.a1;
import app.dogo.com.dogo_android.model.ChallengeFilterItem;
import app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.f.b;
import h.a.b.h.a;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: EntryFilterItem.java */
/* loaded from: classes.dex */
public class EntryFilterItem extends EntryItem<EntryFilterItem.ViewHolder, EntrySortingTabItem> {

    private app.dogo.com.dogo_android.util.n0.f adapter;
    private EntryFilterItem.ViewHolder holder;
    private String id;
    private boolean visible = false;
    private EntryFilterViewModel vm = new EntryFilterViewModel();

    static final class ViewHolder extends h.a.c.b {

        app.dogo.com.dogo_android.util.n0.f adapter;
        private a1 holderBinding;
        int oriinalHeight;
        final RecyclerView.q params = new RecyclerView$q(-1, -2);
        private g0 uvm;
        private EntryFilterViewModel vm;
        public ViewHolder(View view, e eVar) {
            super(view, eVar);
            this.oriinalHeight = view.getLayoutParams().height;
            this.holderBinding = a1.T(view);
            RecyclerView.q qVar = new RecyclerView.q(-1, -2);
            int i2 = 0;
            this.holderBinding.P.setLayoutManager(new LinearLayoutManager(view.getContext(), i2, i2));
            this.uvm = eVar.n2();
            this.holderBinding.V(eVar.l2());
            this.holderBinding.W(eVar.n2());
        }

        private /* synthetic */ void a(EntryFilterViewModel entryFilterViewModel, int i) {
            h.a.b.h.f fVar = this.adapter.O0(i);
            if (fVar != null) {
                entryFilterViewModel.removeFilter(fVar.g(), fVar.i());
                this.adapter.removeItem(i);
                this.uvm.g2();
            }
        }

        static /* synthetic */ a1 access$000(EntryFilterItem.ViewHolder viewHolder) {
            return viewHolder.holderBinding;
        }

        @Override // h.a.c.b
        public void setVisibility(boolean z) {
            int i = 0;
            z = z ? 0 : 8;
            this.holderBinding.w().setVisibility((z ? 0 : 8));
        }

        @Override // h.a.c.b
        public void setVm(EntryFilterViewModel entryFilterViewModel) {
            this.vm = entryFilterViewModel;
            this.holderBinding.X(entryFilterViewModel);
            app.dogo.com.dogo_android.util.n0.f fVar = new app.dogo.com.dogo_android.util.recycle_views.f(entryFilterViewModel.getConvertedList(entryFilterViewModel.getList()), new b(this, entryFilterViewModel));
            this.adapter = fVar;
            this.holderBinding.P.setAdapter(fVar);
        }

        @Override // h.a.c.b
        public void show(boolean z) {
            this.vm.toggleHideHeightAnimation(z, this.holderBinding.w(), 200, this.oriinalHeight);
        }

        @Override // h.a.c.b
        public /* synthetic */ void b(EntryFilterViewModel entryFilterViewModel, int i) {
            a(entryFilterViewModel, i);
        }
    }
    public EntryFilterItem(String str) {
        super(null);
        this.id = str;
        setSelectable(false);
        final app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel entryFilterViewModel = new EntryFilterViewModel();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeChallenge(ChallengeModel challengeModel) {
        this.vm.setModel(challengeModel);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryFilterItem) {
            return this.id.equals(object.id);
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> getFilters() {
        return this.vm.getList();
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
            this.holder.getContentView().getLocationInWindow(iArr);
            return iArr[1];
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public Set<ChallengeFilterItem.FilterTypes> getPossibleFilters() {
        final Set possibleFilters = ChallengeFilterItem_FilterTypes.getPossibleFilters();
        if (!this.vm.featuredEnabled()) {
            possibleFilters.remove(ChallengeFilterItem_FilterTypes.FEATURED);
        }
        return possibleFilters;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void hide() {
        final boolean z = false;
        if (this.holder == null) {
            this.visible = z;
        } else {
            if (holder2.itemView.getVisibility() == 0) {
                this.visible = z;
                if (this.holder != null) {
                    this.holder.show(z);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isFilterLisEmpty() {
        return this.vm.isListEmpty();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isVisible() {
        return this.visible;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void refreshCell(Set<ChallengeFilterItem.FilterTypes> set) {
        this.vm.setPossibleFilters(set);
        if (this.adapter != null) {
            boolean z = true;
            this.adapter.Z1(this.vm.getConvertedList(this.vm.getList()), z);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setFilters(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map, Set<ChallengeFilterItem.FilterTypes> set) {
        this.vm.setFilters(map);
        if (this.adapter != null) {
            this.vm.setPossibleFilters(set);
            this.adapter.Y1(this.vm.getConvertedList(map));
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void show() {
        final boolean z = true;
        if (this.holder == null) {
            this.visible = z;
        } else {
            if (holder2.itemView.getVisibility() != 0) {
                this.visible = z;
                if (this.holder != null) {
                    this.holder.show(z);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b bVar, EntryFilterItem.ViewHolder viewHolder, int i, List list) {
        viewHolder.setVm(this.vm);
        this.holder = viewHolder;
        this.adapter = viewHolder.adapter;
        viewHolder.setVisibility(this.visible);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public EntryFilterItem.ViewHolder createViewHolder(View view, h.a.b.b bVar) {
        final app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder viewHolder = new EntryFilterItem.ViewHolder(view, bVar);
        if (!this.visible) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            layoutParams.height = 0;
            viewHolder.itemView.setLayoutParams(layoutParams);
        }
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_challenge_filter_row;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(h.a.b.b<h.a.b.h.f> bVar, EntryFilterItem.ViewHolder viewHolder, int i) {
    }
}
