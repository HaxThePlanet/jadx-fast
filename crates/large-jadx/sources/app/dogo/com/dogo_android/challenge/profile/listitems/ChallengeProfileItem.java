package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.h.e2;
import app.dogo.com.dogo_android.h.sk;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.n0.d;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import h.a.b.b;
import h.a.b.h.f;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeProfileItem.kt */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0014\u0012\u0008\u0012\u00060\u0002R\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008JD\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u000c\u0010\u0017\u001a\u0008\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J,\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014H\u0016J\u0013\u0010 \u001a\u00020\u00102\u0008\u0010!\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0008\u0010\"\u001a\u00020\u0019H\u0016J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Lapp/dogo/com/dogo_android/model/ChallengeModel;)V", "getEntryModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "id", "", "getId", "()Ljava/lang/String;", "isPremium", "", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "setLikeState", "state", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ChallengeProfileItem extends EntryItem<e.a, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    /* renamed from: a, reason: from kotlin metadata */
    private final ChallengeEntryModel challengeModel;
    private final ChallengeModel b;
    /* renamed from: c, reason: from kotlin metadata */
    private final boolean isPremium;

    @Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\u000c2\u0006\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001e\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0008\u0010\u001b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;", "(Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem;Landroid/view/View;Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellEntryProfileItemBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileObservable;", "onUserView", "", "viewed", "", "setModel", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "isPremium", "setupEntryCell", "binding", "showDeleteDialog", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "position", "", "updateView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends EntryViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final e2 holderBinding;
        private final f b;
        public a(View view, app.dogo.com.dogo_android.d.d.q qVar) {
            final Object eVar3 = this;
            Object qVar32 = qVar;
            n.f(eVar, "this$0");
            n.f(qVar32, "adapter");
            super(view, qVar32);
            n.d(view);
            e2 e2Var = e2.T(view);
            n.e(e2Var, "bind(view!!)");
            eVar3.holderBinding = e2Var;
            super(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
            eVar3.b = challengeProfileObservable;
            e2Var.W(challengeProfileObservable);
            e2Var.V(qVar.l2());
            e2Var.O.T(challengeProfileObservable);
            e2Var.O.U(qVar.l2());
            eVar3.setupEntryCell(e2Var, qVar32);
            eVar3.setupCommentField(e2Var.O, challengeProfileObservable, qVar.l2());
            challengeProfileObservable.setParentTag(qVar.d2().getTag());
            e2Var.O.S.c(new ChallengeProfileItem_ViewHolder_1(eVar3));
        }

        /* renamed from: d, reason: from kotlin metadata */
        public static final /* synthetic */ f onUserView(e.a viewed) {
            return viewed.b;
        }

        /* renamed from: j, reason: from kotlin metadata */
        private final void setupEntryCell(e2 binding, app.dogo.com.dogo_android.d.d.q adapter) {
            binding.O.S.setOnClickListener(new app.dogo.com.dogo_android.challenge.profile.listitems.a(this, adapter, binding));
            binding.O.f0.setOnClickListener(new app.dogo.com.dogo_android.challenge.profile.listitems.d(this, adapter));
            binding.O.b0.setOnClickListener(new app.dogo.com.dogo_android.challenge.profile.listitems.c(this, adapter, binding));
            binding.O.Z.setOnClickListener(new app.dogo.com.dogo_android.challenge.profile.listitems.b(this, binding));
            updateFeaturedStarVisibility(this.b, this.holderBinding.O);
        }

        private static final void k(e.a aVar, app.dogo.com.dogo_android.d.d.q qVar, e2 e2Var, View view) {
            n.f(aVar, "this$0");
            n.f(qVar, "$adapter");
            n.f(e2Var, "$binding");
            if (aVar.b.isAllowedToVote()) {
                aVar.b.setUserEntryId(qVar.A2(aVar.b.i()));
                if (aVar.b.simpleLike(System.currentTimeMillis(), e2Var.O.S.getCurrentItem())) {
                    aVar.showLikeAnimation(e2Var.O.Q);
                    aVar.b.p(qVar.l2());
                    aVar.b.o(qVar.l2());
                }
            }
        }

        private static final void l(e.a aVar, app.dogo.com.dogo_android.d.d.q qVar, View view) {
            n.f(aVar, "this$0");
            n.f(qVar, "$adapter");
            n.f(view, "view");
            if (aVar.b.isCurrentUserEntriesAuthor()) {
                aVar.showDeleteDialog(view, qVar, aVar.b.getPagePosition());
            } else {
                String entryId = aVar.b.getEntryId();
                n.e(entryId, "entryId");
                i = !l.z(entryId);
                if (!l.z(entryId) != 0) {
                    App.INSTANCE.r().logEvent(E_Challenges.B);
                    androidx.fragment.app.e contentUriFromFile = app.dogo.com.dogo_android.util.extensionfunction.i1.getContentUriFromFile(view.getContext());
                    if (contentUriFromFile != null) {
                        app.dogo.com.dogo_android.util.extensionfunction.g1.launchLogInActivity(contentUriFromFile, entryId, new app.dogo.com.dogo_android.challenge.profile.listitems.e.a.b(aVar, qVar));
                    }
                }
            }
        }

        private static final void m(e.a aVar, app.dogo.com.dogo_android.d.d.q qVar, e2 e2Var, View view) {
            n.f(aVar, "this$0");
            n.f(qVar, "$adapter");
            n.f(e2Var, "$binding");
            if (aVar.b.isAllowedToVote()) {
                aVar.b.setUserEntryId(qVar.getUserEntryId(aVar.b.i()));
                aVar.b.toggleLike(System.currentTimeMillis(), e2Var.O.S.getCurrentItem());
                if (aVar.b.getLikeState()) {
                    aVar.b.p(qVar.l2());
                    aVar.b.o(qVar.l2());
                }
            }
        }

        private static final void n(e.a aVar, e2 e2Var, View view) {
            n.f(aVar, "this$0");
            n.f(e2Var, "$binding");
            aVar.b.toggleFeatured(e2Var.O.S.getCurrentItem());
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public final void i(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel, boolean z) {
            n.f(challengeEntryModel, "entryModel");
            this.b.n(challengeEntryModel, challengeModel, z);
            this.b.m();
            if (!this.b.isModelTheSame(challengeEntryModel)) {
                clearCommentField();
            }
            this.holderBinding.O.S.setAdapter(new EntryImagePagerAdapter(challengeEntryModel, false, 2, null));
            updateFeaturedStarVisibility(this.b, this.holderBinding.O);
            notifyCommentViewChange();
            this.holderBinding.p();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public final void showDeleteDialog(View view, e eVar, int i) {
            n.f(view, "view");
            str = "adapter";
            n.f(eVar, str);
            androidx.fragment.app.e contentUriFromFile = app.dogo.com.dogo_android.util.extensionfunction.i1.getContentUriFromFile(view.getContext());
            if (contentUriFromFile != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.showInputDialog(contentUriFromFile, new app.dogo.com.dogo_android.challenge.profile.listitems.e.a.c(this, i, eVar));
            }
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.b.notifyChangeAll();
        }

        public static /* synthetic */ void e(e.a aVar, app.dogo.com.dogo_android.d.d.q qVar, e2 e2Var, View view) {
            ChallengeProfileItem_ViewHolder.k(aVar, qVar, e2Var, view);
        }

        /* renamed from: f, reason: from kotlin metadata */
        public static /* synthetic */ void setModel(e.a entryModel, e2 challengeModel, View isPremium) {
            ChallengeProfileItem_ViewHolder.n(entryModel, challengeModel, isPremium);
        }

        public static /* synthetic */ void g(e.a aVar, app.dogo.com.dogo_android.d.d.q qVar, e2 e2Var, View view) {
            ChallengeProfileItem_ViewHolder.m(aVar, qVar, e2Var, view);
        }

        /* renamed from: h, reason: from kotlin metadata */
        public static /* synthetic */ void showDeleteDialog(e.a view, app.dogo.com.dogo_android.d.d.q adapter, View position) {
            ChallengeProfileItem_ViewHolder.l(view, adapter, position);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
        }
    }
    public e(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel) {
        n.f(challengeEntryModel, "entryModel");
        n.f(challengeModel, "challengeModel");
        super(null);
        this.challengeModel = challengeEntryModel;
        this.b = challengeModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void e(b<f<RecyclerView.e0>> bVar, e.a aVar, int i, List<Object> list) {
        if (aVar != null) {
            aVar.i(this.challengeModel, this.b, this.isPremium);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* operator */ public boolean equals(Object other) {
        if (other instanceof ChallengeProfileItem) {
            return n.b(this.challengeModel.getDocumentId(), other.challengeModel.getDocumentId());
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public e.a f(View view, b<f<RecyclerView.e0>> bVar) {
        Objects.requireNonNull(bVar, "null cannot be cast to non-null type app.dogo.com.dogo_android.challenge.profile.ChallengeProfileListAdapter");
        return new ChallengeProfileItem_ViewHolder(this, view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* renamed from: g, reason: from kotlin metadata */
    public final ChallengeEntryModel getLayoutRes() {
        return this.challengeModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.challengeModel.getDocumentId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_entry_profile_item;
    }
}
