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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.w;

/* compiled from: EntryPhotoItem.java */
/* loaded from: classes.dex */
public class EntryPhotoItem extends EntryItem<EntryPhotoItem.ViewHolder, EntrySortingTabItem> implements PhotoEntryGroup {

    private String id;
    private boolean isPremium;
    private ChallengeEntryModel model;

    public static class ViewHolder extends EntryViewHolder {

        private c2 holderBinding;
        private g0 uvm;
        private EntryPhotoObservable vm = new EntryPhotoObservable();
        public ViewHolder(View view, e eVar) {
            super(view, eVar);
            this.holderBinding = c2.T(view);
            app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoObservable entryPhotoObservable4 = new EntryPhotoObservable();
            this.uvm = eVar.n2();
            this.holderBinding.W(this.vm);
            this.holderBinding.O.T(this.vm);
            this.holderBinding.O.U(eVar.l2());
            this.holderBinding.V(eVar.l2());
            setupEntryCell(this.holderBinding, eVar);
            setupCommentField(this.holderBinding.O, this.vm, eVar.l2());
            this.vm.setParentTag(eVar.d2().getTag());
            this.holderBinding.O.S.c(new EntryPhotoItem.ViewHolder.AnonymousClass1(this));
        }

        static /* synthetic */ EntryPhotoObservable access$000(EntryPhotoItem.ViewHolder viewHolder) {
            return viewHolder.vm;
        }

        private /* synthetic */ w d(int i, e eVar) {
            if (this.vm.onDeleteRequest(i)) {
                eVar.removeItem(getAdapterPosition());
            } else {
                eVar.notifyItemChanged(getAdapterPosition());
            }
            return null;
        }

        private kotlin.d0.c.a<w> deleteConfirmed(e eVar, int i) {
            return new n(this, i, eVar);
        }

        private /* synthetic */ void f(e eVar, c2 c2Var, View view) {
            if (this.vm.isAllowedToVote()) {
                this.vm.setUserEntryId(eVar.m2());
                if (this.vm.simpleLike(System.currentTimeMillis(), c2Var.O.S.getCurrentItem())) {
                    showLikeAnimation(c2Var.O.Q);
                    this.uvm.X2(this.vm.getModel(), eVar.l2());
                }
            }
        }

        private /* synthetic */ w h(e eVar, String str) {
            if (!this.vm.isUserAdmin()) {
                eVar.removeItem(getBindingAdapterPosition());
            }
            return null;
        }

        private /* synthetic */ void j(e eVar, View view) {
            if (this.vm.isCurrentUserEntriesAuthor()) {
                showDeleteDialog(view, eVar, this.vm.getPagePosition());
            } else {
                if (!this.uvm.G()) {
                    String documentId = this.vm.getModel().getDocumentId();
                    if (documentId != null) {
                        App.o().logEvent(E_Challenges.B);
                        app.dogo.com.dogo_android.util.extensionfunction.g1.launchLogInActivity(app.dogo.com.dogo_android.util.extensionfunction.i1.getContentUriFromFile(view.getContext()), documentId, new l(this, eVar));
                    }
                }
            }
        }

        private /* synthetic */ void l(e eVar, c2 c2Var, View view) {
            if (this.vm.isAllowedToVote()) {
                this.vm.setUserEntryId(eVar.m2());
                this.vm.toggleLike(System.currentTimeMillis(), c2Var.O.S.getCurrentItem());
                this.uvm.X2(this.vm.getModel(), eVar.l2());
            }
        }

        private /* synthetic */ void n(c2 c2Var, View view) {
            this.vm.toggleFeatured(c2Var.O.S.getCurrentItem());
        }

        private void setupEntryCell(c2 c2Var, e eVar) {
            c2Var.O.S.setOnClickListener(new k(this, eVar, c2Var));
            c2Var.O.f0.setOnClickListener(new p(this, eVar));
            c2Var.O.b0.setOnClickListener(new o(this, eVar, c2Var));
            c2Var.O.Z.setOnClickListener(new m(this, c2Var));
            updateFeaturedStarVisibility(this.vm, this.holderBinding.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public String getId() {
            String str;
            h.a.b.h.f fVar = this.mAdapter.O0(getBindingAdapterPosition());
            if (fVar != null) {
                str = fVar.getId();
            } else {
                str = "";
            }
            return str;
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
            this.vm.onUserView();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void setModel(ChallengeEntryModel challengeEntryModel, int i, boolean z) {
            if (!this.vm.isModelTheSame(challengeEntryModel)) {
                clearCommentField();
            }
            this.vm.setModel(challengeEntryModel, z);
            this.vm.setCurrentPosition(i);
            this.vm.update();
            this.holderBinding.O.S.setAdapter(new EntryImagePagerAdapter(challengeEntryModel));
            notifyCommentViewChange();
            updateFeaturedStarVisibility(this.vm, this.holderBinding.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        void showDeleteDialog(View view, e eVar, int i) {
            app.dogo.com.dogo_android.util.extensionfunction.f1.showInputDialog(app.dogo.com.dogo_android.util.extensionfunction.i1.getContentUriFromFile(view.getContext()), deleteConfirmed(eVar, i));
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.vm.notifyChangeAll();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ w e(int i, e eVar) {
            return d(i, eVar);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void g(e eVar, c2 c2Var, View view) {
            f(eVar, c2Var, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ w i(e eVar, String str) {
            return h(eVar, str);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void k(e eVar, View view) {
            j(eVar, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void m(e eVar, c2 c2Var, View view) {
            l(eVar, c2Var, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void o(c2 c2Var, View view) {
            n(c2Var, view);
        }
    }
    public EntryPhotoItem(ChallengeEntryModel challengeEntryModel, String str, boolean z) {
        super(null);
        this.id = str;
        this.model = challengeEntryModel;
        this.isPremium = z;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeCommentCountBy(int i) {
        this.model.updateCommentCount(i);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryPhotoItem) {
            return this.id.equals(object.id);
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isItemOlderThen(EntryItem entryItem) {
        boolean z2 = false;
        int i = 0;
        z = entryItem instanceof EntryPhotoItem;
        int i2 = 0;
        if (entryItem instanceof EntryPhotoItem) {
            i = 0;
            if (this.model.getDate() != null) {
                long seconds2 = this.model.getDate().getSeconds();
            } else {
            }
            if (entryItem.model.getDate() != null) {
                long seconds = entryItem.model.getDate().getSeconds();
            }
            if (i < i) {
                int i3 = 1;
            }
        }
        return z2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setAllPhotoLikes(Map<String, Boolean> map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            setLikeStateForPhoto((String)item.getKey(), (Boolean)item.getValue().booleanValue());
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setLikeState(boolean z) {
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
    public void setLikeStateForPhoto(String str, boolean z) {
        if (this.model.getLikeStateForImage(str) != z) {
            this.model.setLikeStateForImage(str, z);
            if (z) {
                int i = 1;
                this.model.incrementVotes(i);
            } else {
                i = -1;
                this.model.incrementVotes(i);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b bVar, EntryPhotoItem.ViewHolder viewHolder, int i, List list) {
        viewHolder.setModel(this.model, bVar.k2() + i, this.isPremium);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public EntryPhotoItem.ViewHolder createViewHolder(View view, h.a.b.b bVar) {
        return new EntryPhotoItem.ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_entry_photo_item;
    }
}
