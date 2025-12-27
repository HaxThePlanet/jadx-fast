package app.dogo.com.dogo_android.d.a;

import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell;
import app.dogo.com.dogo_android.util.n0.d;
import h.a.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeFanListAdapter.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00020\u0001B/\u0012\u0014\u0010\u0003\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0002\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0008\u0010\u0012\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/BaseFlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "items", "", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "endOfList", "", "loadingCellState", "addLoadingCell", "", "addMoreFans", "fanItems", "markEndOfList", "removeLoadingCell", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class ChallengeFanListAdapter extends d<h.a.b.h.f<?>> {

    /* renamed from: F0, reason: from kotlin metadata */
    private boolean endOfList;
    /* renamed from: G0, reason: from kotlin metadata */
    private boolean loadingCellState;
    public k(List<? extends h.a.b.h.f<?>> list, app.dogo.com.dogo_android.util.k0.f fVar, q qVar) {
        super(list, fVar, qVar);
        addLoadingCell();
    }

    /* renamed from: g2, reason: from kotlin metadata */
    private final void addLoadingCell() {
        if (this.endOfList == null && !this.loadingCellState) {
            app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem = null;
            Y(new BlankScreenCell(entrySortingTabItem));
            boolean endOfList2 = true;
            this.endOfList = endOfList2;
        }
    }

    private final void j2() {
        if (this.endOfList != null) {
            removeItem(getItemCount() - 1);
            boolean endOfList2 = false;
            this.endOfList = endOfList2;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    /* renamed from: h2, reason: from kotlin metadata */
    public final void addMoreFans(List<? extends h.a.b.h.f<?>> fanItems) {
        n.f(fanItems, "fanItems");
        Z(getItemCount() - this.endOfList, fanItems);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public final void i2() {
        this.loadingCellState = true;
        j2();
    }
}
