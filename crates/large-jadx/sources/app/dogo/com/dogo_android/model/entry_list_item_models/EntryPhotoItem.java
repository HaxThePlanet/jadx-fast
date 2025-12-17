package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.h.c2;
import app.dogo.com.dogo_android.h.sk;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.util.h0.f1;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.w;

/* loaded from: classes.dex */
public class EntryPhotoItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements app.dogo.com.dogo_android.model.entry_list_item_models.PhotoEntryGroup {

    private String id;
    private boolean isPremium;
    private ChallengeEntryModel model;

    public static class ViewHolder extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder {

        private c2 holderBinding;
        private g0 uvm;
        private app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoObservable vm;
        public ViewHolder(View view, e e2) {
            super(view, e2);
            this.holderBinding = c2.T(view);
            EntryPhotoObservable obj3 = new EntryPhotoObservable();
            this.vm = obj3;
            this.uvm = e2.n2();
            this.holderBinding.W(this.vm);
            obj3.O.T(this.vm);
            obj3.O.U(e2.l2());
            this.holderBinding.V(e2.l2());
            setupEntryCell(this.holderBinding, e2);
            setupCommentField(obj3.O, this.vm, e2.l2());
            this.vm.setParentTag(e2.d2().getTag());
            EntryPhotoItem.ViewHolder.1 obj4 = new EntryPhotoItem.ViewHolder.1(this);
            obj3.S.c(obj4);
        }

        static app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoObservable access$000(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder entryPhotoItem$ViewHolder) {
            return viewHolder.vm;
        }

        private w d(int i, e e2) {
            int obj2;
            if (this.vm.onDeleteRequest(i)) {
                e2.removeItem(getAdapterPosition());
            } else {
                e2.notifyItemChanged(getAdapterPosition());
            }
            return null;
        }

        private a<w> deleteConfirmed(e e, int i2) {
            n nVar = new n(this, i2, e);
            return nVar;
        }

        private void f(e e, c2 c22, View view3) {
            long currentTimeMillis;
            int currentItem;
            app.dogo.com.dogo_android.util.e0.a0 obj4;
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

        private w h(e e, String string2) {
            boolean obj2;
            if (!this.vm.isUserAdmin()) {
                e.removeItem(getBindingAdapterPosition());
            }
            return null;
        }

        private void j(e e, View view2) {
            int pagePosition;
            app.dogo.com.dogo_android.model.entry_list_item_models.l lVar;
            app.dogo.com.dogo_android.w.t2 t2Var;
            Object obj5;
            if (this.vm.isCurrentUserEntriesAuthor()) {
                showDeleteDialog(view2, e, this.vm.getPagePosition());
            } else {
                pagePosition = this.vm.getModel().getDocumentId();
                if (!this.uvm.G() && pagePosition != null) {
                    pagePosition = this.vm.getModel().getDocumentId();
                    if (pagePosition != null) {
                        App.o().c(u.B);
                        lVar = new l(this, e);
                        g1.Y(i1.a(view2.getContext()), pagePosition, lVar);
                    }
                }
            }
        }

        private void l(e e, c2 c22, View view3) {
            long currentTimeMillis;
            app.dogo.com.dogo_android.util.e0.a0 obj3;
            Object obj4;
            boolean obj5;
            if (this.vm.isAllowedToVote()) {
                this.vm.setUserEntryId(e.m2());
                this.vm.toggleLike(System.currentTimeMillis(), obj1);
                this.uvm.X2(this.vm.getModel(), e.l2());
            }
        }

        private void n(c2 c2, View view2) {
            this.vm.toggleFeatured(obj1.S.getCurrentItem());
        }

        private void setupEntryCell(c2 c2, e e2) {
            k kVar = new k(this, e2, c2);
            skVar.S.setOnClickListener(kVar);
            p pVar = new p(this, e2);
            skVar2.f0.setOnClickListener(pVar);
            o oVar = new o(this, e2, c2);
            skVar3.b0.setOnClickListener(oVar);
            m mVar = new m(this, c2);
            obj4.Z.setOnClickListener(mVar);
            updateFeaturedStarVisibility(this.vm, obj4.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public w e(int i, e e2) {
            return d(i, e2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void g(e e, c2 c22, View view3) {
            f(e, c22, view3);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public String getId() {
            String str;
            h.a.b.h.f fVar = this.mAdapter.O0(getBindingAdapterPosition());
            if ((EntryPhotoItem)fVar != null) {
                str = (EntryPhotoItem)fVar.getId();
            } else {
                str = "";
            }
            return str;
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public w i(e e, String string2) {
            return h(e, string2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void k(e e, View view2) {
            j(e, view2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void m(e e, c2 c22, View view3) {
            l(e, c22, view3);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void o(c2 c2, View view2) {
            n(c2, view2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
            this.vm.onUserView();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void setModel(ChallengeEntryModel challengeEntryModel, int i2, boolean z3) {
            if (!this.vm.isModelTheSame(challengeEntryModel)) {
                clearCommentField();
            }
            this.vm.setModel(challengeEntryModel, z3);
            this.vm.setCurrentPosition(i2);
            this.vm.update();
            l obj4 = new l(challengeEntryModel);
            obj3.S.setAdapter(obj4);
            notifyCommentViewChange();
            updateFeaturedStarVisibility(this.vm, obj3.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        void showDeleteDialog(View view, e e2, int i3) {
            f1.O(i1.a(view.getContext()), deleteConfirmed(e2, i3));
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.vm.notifyChangeAll();
        }
    }
    public EntryPhotoItem(ChallengeEntryModel challengeEntryModel, String string2, boolean z3) {
        super(0);
        this.id = string2;
        this.model = challengeEntryModel;
        this.isPremium = z3;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (EntryPhotoItem.ViewHolder)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder entryPhotoItem$ViewHolder2, int i3, List list4) {
        viewHolder2.setModel(this.model, obj1 += i3, this.isPremium);
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
    public app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder createViewHolder(View view, b b2) {
        EntryPhotoItem.ViewHolder viewHolder = new EntryPhotoItem.ViewHolder(view, (e)b2);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryPhotoItem) {
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
        return 2131558486;
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
        if (entryItem instanceof EntryPhotoItem) {
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

    public void setAllPhotoLikes(Map<String, Boolean> map) {
        boolean booleanValue;
        Object key;
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            setLikeStateForPhoto((String)next2.getKey(), (Boolean)next2.getValue().booleanValue());
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setLikeState(boolean z) {
        boolean userLiked;
        boolean obj2;
        if (this.model.hasUserLiked() != z) {
            this.model.setUserLiked(z);
            if (z) {
                this.model.incrementVotes(1);
            } else {
                this.model.incrementVotes(-1);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setLikeStateForPhoto(String string, boolean z2) {
        boolean likeStateForImage;
        Object obj2;
        boolean obj3;
        if (this.model.getLikeStateForImage(string) != z2) {
            this.model.setLikeStateForImage(string, z2);
            if (z2) {
                this.model.incrementVotes(1);
            } else {
                this.model.incrementVotes(-1);
            }
        }
    }
}
