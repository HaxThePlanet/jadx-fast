package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
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
import app.dogo.com.dogo_android.util.n0.f;
import app.dogo.com.dogo_android.util.n0.f.b;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class EntryFilterItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    private f adapter;
    private app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder holder;
    private String id;
    private boolean visible = false;
    private app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel vm;

    static final class ViewHolder extends b {

        f adapter;
        private a1 holderBinding;
        int oriinalHeight;
        final RecyclerView.q params;
        private g0 uvm;
        private app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel vm;
        public ViewHolder(View view, e e2) {
            super(view, e2);
            this.oriinalHeight = layoutParams.height;
            this.holderBinding = a1.T(view);
            RecyclerView.q qVar = new RecyclerView.q(-1, -2);
            this.params = qVar;
            int i2 = 0;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), i2, i2);
            obj4.P.setLayoutManager(linearLayoutManager);
            this.uvm = e2.n2();
            this.holderBinding.V(e2.l2());
            this.holderBinding.W(e2.n2());
        }

        private void a(app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel entryFilterViewModel, int i2) {
            Object fVar;
            ChallengeFilterItem.FilterTypes filterTypes;
            g0 obj3;
            fVar = this.adapter.O0(i2);
            if ((f.b)fVar != null) {
                entryFilterViewModel.removeFilter((f.b)fVar.g(), fVar.i());
                this.adapter.removeItem(i2);
                this.uvm.g2();
            }
        }

        static a1 access$000(app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder entryFilterItem$ViewHolder) {
            return viewHolder.holderBinding;
        }

        @Override // h.a.c.b
        public void b(app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel entryFilterViewModel, int i2) {
            a(entryFilterViewModel, i2);
        }

        @Override // h.a.c.b
        public void setVisibility(boolean z) {
            int obj2;
            obj2 = z ? 0 : 8;
            this.holderBinding.w().setVisibility(obj2);
        }

        @Override // h.a.c.b
        public void setVm(app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel entryFilterViewModel) {
            this.vm = entryFilterViewModel;
            this.holderBinding.X(entryFilterViewModel);
            b bVar = new b(this, entryFilterViewModel);
            f fVar = new f(entryFilterViewModel.getConvertedList(entryFilterViewModel.getList()), bVar);
            this.adapter = fVar;
            obj4.P.setAdapter(fVar);
        }

        @Override // h.a.c.b
        public void show(boolean z) {
            this.vm.toggleHideHeightAnimation(z, this.holderBinding.w(), 200, this.oriinalHeight);
        }
    }
    public EntryFilterItem(String string) {
        super(0);
        this.id = string;
        setSelectable(false);
        EntryFilterViewModel obj2 = new EntryFilterViewModel();
        this.vm = obj2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (EntryFilterItem.ViewHolder)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder entryFilterItem$ViewHolder2, int i3, List list4) {
        viewHolder2.setVm(this.vm);
        this.holder = viewHolder2;
        this.adapter = viewHolder2.adapter;
        viewHolder2.setVisibility(this.visible);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeChallenge(ChallengeModel challengeModel) {
        this.vm.setModel(challengeModel);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder createViewHolder(View view, b b2) {
        boolean obj2;
        Object obj3;
        EntryFilterItem.ViewHolder viewHolder = new EntryFilterItem.ViewHolder(view, (e)b2);
        if (!this.visible) {
            obj2 = viewHolder.itemView.getLayoutParams();
            obj2.height = 0;
            viewHolder.itemView.setLayoutParams(obj2);
        }
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryFilterItem) {
            return this.id.equals(object.id);
        }
        return 0;
    }

    public Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> getFilters() {
        return this.vm.getList();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public float getHeight() {
        app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder holder = this.holder;
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
        return 2131558471;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getPosition() {
        app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder holder = this.holder;
        if (holder != null) {
            int[] iArr = new int[2];
            holder.getContentView().getLocationInWindow(iArr);
            return iArr[1];
        }
        return 0;
    }

    public Set<ChallengeFilterItem.FilterTypes> getPossibleFilters() {
        boolean featuredEnabled;
        final Set possibleFilters = ChallengeFilterItem.FilterTypes.getPossibleFilters();
        if (!this.vm.featuredEnabled()) {
            possibleFilters.remove(ChallengeFilterItem.FilterTypes.FEATURED);
        }
        return possibleFilters;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void hide() {
        int visibility;
        visibility = this.holder;
        final int i = 0;
        if (visibility != null) {
            this.visible = i;
            visibility = this.holder;
            if (visibility.itemView.getVisibility() == 0 && visibility != null) {
                this.visible = i;
                visibility = this.holder;
                if (visibility != null) {
                    visibility.show(i);
                }
            }
        } else {
            this.visible = i;
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

    public void refreshCell(Set<ChallengeFilterItem.FilterTypes> set) {
        Object convertedList;
        int i;
        this.vm.setPossibleFilters(set);
        final f obj3 = this.adapter;
        if (obj3 != null) {
            app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel view = this.vm;
            obj3.Z1(view.getConvertedList(view.getList()), true);
        }
    }

    public void setFilters(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map, Set<ChallengeFilterItem.FilterTypes> set2) {
        Object adapter;
        Object obj2;
        Object obj3;
        this.vm.setFilters(map);
        if (this.adapter != null) {
            this.vm.setPossibleFilters(set2);
            this.adapter.Y1(this.vm.getConvertedList(map));
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void show() {
        int visibility;
        visibility = this.holder;
        final int i = 1;
        if (visibility != null) {
            this.visible = i;
            visibility = this.holder;
            if (visibility.itemView.getVisibility() != 0 && visibility != null) {
                this.visible = i;
                visibility = this.holder;
                if (visibility != null) {
                    visibility.show(i);
                }
            }
        } else {
            this.visible = i;
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3) {
        unbindViewHolder(b, (EntryFilterItem.ViewHolder)e02, i3);
    }

    public void unbindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder entryFilterItem$ViewHolder2, int i3) {
    }
}
