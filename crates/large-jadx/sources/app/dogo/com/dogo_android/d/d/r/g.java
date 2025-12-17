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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001#B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000cJ:\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00072\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J$\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0008\u0010!\u001a\u00020\u0007H\u0016J\u0008\u0010\"\u001a\u00020\u0007H\u0016R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "participationCount", "", "totalVoteCount", "badgeList", "", "", "(Lapp/dogo/com/dogo_android/model/LiteDogProfile;IILjava/util/List;)V", "id", "getId", "()Ljava/lang/String;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "payload", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "hashCode", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends EntryItem<app.dogo.com.dogo_android.d.d.r.g.a, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    private final LiteDogProfile a;
    private final int b;
    private final int c;
    private final List<String> d;

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J,\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016J\u0008\u0010\u0018\u001a\u00020\u000cH\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryViewHolder;", "view", "Landroid/view/View;", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellEntryProfileTitleItemBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleObservable;", "onUserView", "", "viewed", "", "setModel", "model", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "participantCount", "", "totalVoteCount", "badgeList", "", "", "updateView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends EntryViewHolder {

        private final g2 a;
        private final app.dogo.com.dogo_android.d.d.r.h b;
        public a(View view, b<?> b2) {
            n.f(view, "view");
            n.f(b2, "adapter");
            super(view, b2);
            final g2 obj3 = g2.T(view);
            n.e(obj3, "bind(view)");
            this.a = obj3;
            int i = 0;
            h obj4 = new h(i, 1, i);
            this.b = obj4;
            obj3.V(obj4);
        }

        public final void d(LiteDogProfile liteDogProfile, int i2, int i3, List<String> list4) {
            n.f(liteDogProfile, "model");
            n.f(list4, "badgeList");
            this.b.c(liteDogProfile, i2, i3, list4);
            this.a.p();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.b.notifyChangeAll();
        }
    }
    public g(LiteDogProfile liteDogProfile, int i2, int i3, List<String> list4) {
        n.f(liteDogProfile, "dogProfile");
        n.f(list4, "badgeList");
        super(0);
        this.a = liteDogProfile;
        this.b = i2;
        this.c = i3;
        this.d = list4;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (g.a)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<RecyclerView.e0>> b, app.dogo.com.dogo_android.d.d.r.g.a g$a2, int i3, List<Object> list4) {
        n.f(b, "adapter");
        n.f(a2, "holder");
        n.f(list4, "payload");
        a2.d(this.a, this.b, this.c, this.d);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof g) {
            return n.b(this.a.getId(), object.a.getId());
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.d.r.g.a f(View view, b<f<RecyclerView.e0>> b2) {
        n.f(view, "view");
        n.f(b2, "adapter");
        g.a aVar = new g.a(view, b2);
        return aVar;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.a.getId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558488;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int hashCode() {
        return i4 += i7;
    }
}
