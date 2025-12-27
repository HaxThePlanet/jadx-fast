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

/* compiled from: EntryOldPhotoItem.java */
/* loaded from: classes.dex */
public class EntryOldPhotoItem extends EntryItem<EntryOldPhotoItem.ViewHolder, EntrySortingTabItem> implements PhotoEntryGroup {

    private boolean filtered;
    private String id;
    private boolean isPremium;
    private ChallengeEntryModel model;

    final class ViewHolder extends EntryViewHolder {

        private a2 holderBinding;
        private g0 uvm;
        private EntryOldPhotoObservable vm = new EntryOldPhotoObservable();
        public ViewHolder(View view, e eVar) {
            this.this$0 = entryOldPhotoItem;
            super(view, eVar);
            this.holderBinding = a2.T(view);
            app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoObservable entryOldPhotoObservable4 = new EntryOldPhotoObservable();
            this.uvm = eVar.n2();
            this.holderBinding.V(this.vm);
            this.holderBinding.O.T(this.vm);
            this.holderBinding.O.U(eVar.l2());
            setupEntryCell(this.holderBinding, eVar);
            setupCommentField(this.holderBinding.O, this.vm, eVar.l2());
            this.vm.setParentTag(eVar.d2());
            this.holderBinding.O.S.c(new EntryOldPhotoItem.ViewHolder.AnonymousClass1(this, entryOldPhotoItem));
        }

        static /* synthetic */ EntryOldPhotoObservable access$000(EntryOldPhotoItem.ViewHolder viewHolder) {
            return viewHolder.vm;
        }

        private /* synthetic */ void d(e eVar, a2 a2Var, View view) {
            if (this.vm.isAllowedToVote()) {
                this.vm.setUserEntryId(eVar.m2());
                if (this.vm.simpleLike(System.currentTimeMillis(), a2Var.O.S.getCurrentItem())) {
                    showLikeAnimation(a2Var.O.Q);
                    this.uvm.X2(this.vm.getModel(), eVar.l2());
                }
            }
        }

        private /* synthetic */ w f(e eVar, String str) {
            if (!this.vm.isUserAdmin()) {
                eVar.removeItem(getBindingAdapterPosition());
            }
            return null;
        }

        private /* synthetic */ void h(e eVar, View view) {
            if (this.vm.isCurrentUserEntriesAuthor()) {
                int i = 2131886293;
                eVar.l2().t0(i);
            } else {
                String entryId = this.vm.getEntryId();
                if (entryId != null) {
                    App.o().logEvent(E_Challenges.B);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.launchLogInActivity(app.dogo.com.dogo_android.util.extensionfunction.i1.getContentUriFromFile(view.getContext()), entryId, new g(this, eVar));
                }
            }
        }

        private /* synthetic */ void j(e eVar, a2 a2Var, View view) {
            if (this.vm.isAllowedToVote()) {
                this.vm.setUserEntryId(eVar.m2());
                this.vm.toggleLike(System.currentTimeMillis(), a2Var.O.S.getCurrentItem());
                this.uvm.X2(this.vm.getModel(), eVar.l2());
            }
        }

        private /* synthetic */ void l(a2 a2Var, View view) {
            this.vm.toggleFeatured(a2Var.O.S.getCurrentItem());
        }

        private void setupEntryCell(a2 a2Var, e eVar) {
            a2Var.O.S.setOnClickListener(new e(this, eVar, a2Var));
            a2Var.O.f0.setOnClickListener(new d(this, eVar));
            a2Var.O.b0.setOnClickListener(new c(this, eVar, a2Var));
            a2Var.O.Z.setOnClickListener(new f(this, a2Var));
            updateFeaturedStarVisibility(this.vm, this.holderBinding.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void setModel(ChallengeEntryModel challengeEntryModel, int i, boolean z, boolean z2) {
            if (!this.vm.isModelTheSame(challengeEntryModel)) {
                clearCommentField();
            }
            this.vm.setModel(challengeEntryModel, i, z, z2);
            this.vm.update();
            this.holderBinding.O.S.setAdapter(new EntryImagePagerAdapter(challengeEntryModel));
            notifyCommentViewChange();
            updateFeaturedStarVisibility(this.vm, this.holderBinding.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.vm.notifyChangeAll();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void e(e eVar, a2 a2Var, View view) {
            d(eVar, a2Var, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ w g(e eVar, String str) {
            return f(eVar, str);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void i(e eVar, View view) {
            h(eVar, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void k(e eVar, a2 a2Var, View view) {
            j(eVar, a2Var, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void m(a2 a2Var, View view) {
            l(a2Var, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
        }
    }
    public EntryOldPhotoItem(ChallengeEntryModel challengeEntryModel, String str, boolean z, boolean z2) {
        super(null);
        this.id = str;
        this.model = challengeEntryModel;
        this.filtered = z;
        this.isPremium = z2;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeCommentCountBy(int i) {
        this.model.updateCommentCount(i);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryOldPhotoItem) {
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
        z = entryItem instanceof EntryOldPhotoItem;
        int i2 = 0;
        if (entryItem instanceof EntryOldPhotoItem) {
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
    public void bindViewHolder(b bVar, EntryOldPhotoItem.ViewHolder viewHolder, int i, List list) {
        viewHolder.setModel(this.model, viewHolder.getAdapterPosition() - 6, this.filtered, this.isPremium);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public EntryOldPhotoItem.ViewHolder createViewHolder(View view, b bVar) {
        return new EntryOldPhotoItem.ViewHolder(this, view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_entry_old_photo_item;
    }
}
