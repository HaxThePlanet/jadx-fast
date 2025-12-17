package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.h.a2;
import app.dogo.com.dogo_android.h.sk;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.n0.d;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.l;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import com.google.firebase.Timestamp;
import h.a.b.b;
import h.a.b.h.a;
import java.util.List;
import kotlin.w;

/* loaded from: classes.dex */
public class EntryOldPhotoItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements app.dogo.com.dogo_android.model.entry_list_item_models.PhotoEntryGroup {

    private boolean filtered;
    private String id;
    private boolean isPremium;
    private ChallengeEntryModel model;

    final class ViewHolder extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder {

        private a2 holderBinding;
        final app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem this$0;
        private g0 uvm;
        private app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoObservable vm;
        public ViewHolder(app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem entryOldPhotoItem, View view2, e e3) {
            this.this$0 = entryOldPhotoItem;
            super(view2, e3);
            this.holderBinding = a2.T(view2);
            EntryOldPhotoObservable obj4 = new EntryOldPhotoObservable();
            this.vm = obj4;
            this.uvm = e3.n2();
            this.holderBinding.V(this.vm);
            obj4.O.T(this.vm);
            obj4.O.U(e3.l2());
            setupEntryCell(this.holderBinding, e3);
            setupCommentField(obj4.O, this.vm, e3.l2());
            this.vm.setParentTag(e3.d2());
            EntryOldPhotoItem.ViewHolder.1 obj5 = new EntryOldPhotoItem.ViewHolder.1(this, entryOldPhotoItem);
            obj4.S.c(obj5);
        }

        static app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoObservable access$000(app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder entryOldPhotoItem$ViewHolder) {
            return viewHolder.vm;
        }

        private void d(e e, a2 a22, View view3) {
            long currentTimeMillis;
            int currentItem;
            a0 obj4;
            Object obj5;
            boolean obj6;
            this.vm.setUserEntryId(e.m2());
            if (this.vm.isAllowedToVote() && this.vm.simpleLike(System.currentTimeMillis(), obj1)) {
                this.vm.setUserEntryId(e.m2());
                if (this.vm.simpleLike(System.currentTimeMillis(), obj1)) {
                    showLikeAnimation(obj5.Q);
                    this.uvm.X2(this.vm.getModel(), e.l2());
                }
            }
        }

        private w f(e e, String string2) {
            boolean obj2;
            if (!this.vm.isUserAdmin()) {
                e.removeItem(getBindingAdapterPosition());
            }
            return null;
        }

        private void h(e e, View view2) {
            boolean currentUserEntriesAuthor;
            app.dogo.com.dogo_android.model.entry_list_item_models.g gVar;
            app.dogo.com.dogo_android.w.t2 t2Var;
            Object obj4;
            int obj5;
            if (this.vm.isCurrentUserEntriesAuthor()) {
                e.l2().t0(2131886293);
            } else {
                currentUserEntriesAuthor = this.vm.getEntryId();
                if (currentUserEntriesAuthor != null) {
                    App.o().c(u.B);
                    gVar = new g(this, e);
                    g1.Y(i1.a(view2.getContext()), currentUserEntriesAuthor, gVar);
                }
            }
        }

        private void j(e e, a2 a22, View view3) {
            long currentTimeMillis;
            a0 obj3;
            Object obj4;
            boolean obj5;
            if (this.vm.isAllowedToVote()) {
                this.vm.setUserEntryId(e.m2());
                this.vm.toggleLike(System.currentTimeMillis(), obj1);
                this.uvm.X2(this.vm.getModel(), e.l2());
            }
        }

        private void l(a2 a2, View view2) {
            this.vm.toggleFeatured(obj1.S.getCurrentItem());
        }

        private void setupEntryCell(a2 a2, e e2) {
            e eVar = new e(this, e2, a2);
            skVar.S.setOnClickListener(eVar);
            d dVar = new d(this, e2);
            skVar2.f0.setOnClickListener(dVar);
            c cVar = new c(this, e2, a2);
            skVar3.b0.setOnClickListener(cVar);
            f fVar = new f(this, a2);
            obj4.Z.setOnClickListener(fVar);
            updateFeaturedStarVisibility(this.vm, obj4.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void e(e e, a2 a22, View view3) {
            d(e, a22, view3);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public w g(e e, String string2) {
            return f(e, string2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void i(e e, View view2) {
            h(e, view2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void k(e e, a2 a22, View view3) {
            j(e, a22, view3);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void m(a2 a2, View view2) {
            l(a2, view2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void setModel(ChallengeEntryModel challengeEntryModel, int i2, boolean z3, boolean z4) {
            if (!this.vm.isModelTheSame(challengeEntryModel)) {
                clearCommentField();
            }
            this.vm.setModel(challengeEntryModel, i2, z3, z4);
            this.vm.update();
            l obj4 = new l(challengeEntryModel);
            obj3.S.setAdapter(obj4);
            notifyCommentViewChange();
            updateFeaturedStarVisibility(this.vm, obj3.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.vm.notifyChangeAll();
        }
    }
    public EntryOldPhotoItem(ChallengeEntryModel challengeEntryModel, String string2, boolean z3, boolean z4) {
        super(0);
        this.id = string2;
        this.model = challengeEntryModel;
        this.filtered = z3;
        this.isPremium = z4;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (EntryOldPhotoItem.ViewHolder)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder entryOldPhotoItem$ViewHolder2, int i3, List list4) {
        viewHolder2.setModel(this.model, obj4 += -6, this.filtered, this.isPremium);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeCommentCountBy(int i) {
        this.model.updateCommentCount(i);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder createViewHolder(View view, b b2) {
        EntryOldPhotoItem.ViewHolder viewHolder = new EntryOldPhotoItem.ViewHolder(this, view, (e)b2);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryOldPhotoItem) {
            return this.id.equals(object.id);
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558485;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isItemOlderThen(app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem entryItem) {
        Timestamp date2;
        boolean date;
        int i;
        int seconds;
        int seconds2;
        Object obj7;
        i = 0;
        if (entryItem instanceof EntryOldPhotoItem) {
            if (this.model.getDate() != null) {
                seconds2 = this.model.getDate().getSeconds();
            } else {
                seconds2 = seconds;
            }
            if (entryItem.model.getDate() != null) {
                seconds = entryItem.model.getDate().getSeconds();
            }
            if (Long.compare(seconds2, seconds) < 0) {
                i = 1;
            }
        }
        return i;
    }
}
