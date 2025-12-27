package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.g2;
import app.dogo.com.dogo_android.model.LiteDogProfile;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder;
import app.dogo.com.dogo_android.util.e0.o;
import h.a.b.b;
import h.a.b.h.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeProfileTitleItem.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001#B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000cJ:\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00072\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J$\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0008\u0010!\u001a\u00020\u0007H\u0016J\u0008\u0010\"\u001a\u00020\u0007H\u0016R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "participationCount", "", "totalVoteCount", "badgeList", "", "", "(Lapp/dogo/com/dogo_android/model/LiteDogProfile;IILjava/util/List;)V", "id", "getId", "()Ljava/lang/String;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "payload", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "hashCode", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class ChallengeProfileTitleItem extends EntryItem<g.a, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    /* renamed from: a, reason: from kotlin metadata */
    private final LiteDogProfile badgeList;
    /* renamed from: b, reason: from kotlin metadata */
    private final int dogProfile;
    /* renamed from: c, reason: from kotlin metadata */
    private final int participationCount;
    /* renamed from: d, reason: from kotlin metadata */
    private final List<String> totalVoteCount;

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J,\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016J\u0008\u0010\u0018\u001a\u00020\u000cH\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryViewHolder;", "view", "Landroid/view/View;", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellEntryProfileTitleItemBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleObservable;", "onUserView", "", "viewed", "", "setModel", "model", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "participantCount", "", "totalVoteCount", "badgeList", "", "", "updateView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends EntryViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final g2 holderBinding;
        private final h b = new h(0, 1, 0);
        public a(View view, b<?> bVar) {
            n.f(view, "view");
            n.f(bVar, "adapter");
            super(view, bVar);
            final g2 g2Var = g2.T(view);
            n.e(g2Var, "bind(view)");
            this.holderBinding = g2Var;
            android.content.res.Resources resources = null;
            g2Var.V(new ChallengeProfileTitleObservable(resources, 1, resources));
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        /* renamed from: d, reason: from kotlin metadata */
        public final void setModel(LiteDogProfile model, int participantCount, int totalVoteCount, List<String> badgeList) {
            n.f(model, "model");
            n.f(badgeList, "badgeList");
            this.b.setModel(model, participantCount, totalVoteCount, badgeList);
            this.holderBinding.p();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.b.notifyChangeAll();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean viewed) {
        }
    }
    public g(LiteDogProfile liteDogProfile, int i, int i2, List<String> list) {
        n.f(liteDogProfile, "dogProfile");
        n.f(list, "badgeList");
        super(null);
        this.badgeList = liteDogProfile;
        this.dogProfile = i;
        this.participationCount = i2;
        this.totalVoteCount = list;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void e(b<f<RecyclerView.e0>> bVar, g.a aVar, int i, List<Object> list) {
        n.f(bVar, "adapter");
        n.f(aVar, "holder");
        n.f(list, "payload");
        aVar.setModel(this.badgeList, this.dogProfile, this.participationCount, this.totalVoteCount);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* operator */ public boolean equals(Object other) {
        if (other instanceof ChallengeProfileTitleItem) {
            return n.b(this.badgeList.getId(), other.badgeList.getId());
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public g.a f(View view, b<f<RecyclerView.e0>> bVar) {
        n.f(view, "view");
        n.f(bVar, "adapter");
        return new ChallengeProfileTitleItem_ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.badgeList.getId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int hashCode() {
        return (this.badgeList.hashCode() * 31) + this.dogProfile * 31 + this.participationCount;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_entry_profile_title_item;
    }
}
