package app.dogo.com.dogo_android.d.c;

import app.dogo.com.dogo_android.d.c.j.a;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell;
import app.dogo.com.dogo_android.util.e0.b0;
import app.dogo.com.dogo_android.util.k0.f;
import app.dogo.com.dogo_android.util.n0.v;
import h.a.b.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeNotificationListAdapter.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B'\u0012\u0010\u0010\u0003\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u0011J \u0010\u0014\u001a\u00020\u000f2\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J \u0010\u0017\u001a\u00020\u000f2\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u00022\n\u0010\u0019\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J\u0008\u0010\u001a\u001a\u00020\u0011H\u0016J \u0010\u001b\u001a\u00020\u001c2\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0011R\u001e\u0010\n\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationListAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/SortedFlexibleAdapterWrapper;", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "items", "", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "itemType", "Ljava/lang/Class;", "getItemType", "()Ljava/lang/Class;", "loadingCellState", "", "addItems", "", "itemTypeList", "addLoadingCell", "areSortedContentsTheSame", "oldItem", "newItem", "areSortedItemsTheSame", "item1", "item2", "clearList", "compareSortedItems", "", "removeItemById", "notificationId", "", "removeLoadingCell", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class ChallengeNotificationListAdapter extends v<b0<?>> {

    private boolean c;
    public i(List<? extends b0<?>> list, f fVar, q qVar) {
        n.f(list, "items");
        n.f(fVar, "messageBroadcaster");
        n.f(qVar, "parentTag");
        super(list, fVar, qVar);
        x();
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    /* renamed from: c, reason: from kotlin metadata */
    public void addItems(List<? extends b0<?>> itemTypeList) {
        n.f(itemTypeList, "itemTypeList");
        super.addItems(itemTypeList);
        z();
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    /* renamed from: e, reason: from kotlin metadata */
    public boolean areSortedContentsTheSame(b0<?> oldItem, b0<?> newItem) {
        n.f(oldItem, "oldItem");
        n.f(newItem, "newItem");
        return oldItem.isContentSame(newItem);
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    /* renamed from: f, reason: from kotlin metadata */
    public boolean areSortedItemsTheSame(b0<?> item1, b0<?> item2) {
        n.f(item1, "item1");
        n.f(item2, "item2");
        return n.b(item1, item2);
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    /* renamed from: g, reason: from kotlin metadata */
    public void addLoadingCell() {
        super.g();
        this.c = false;
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    /* renamed from: h, reason: from kotlin metadata */
    public int compareSortedItems(b0<?> oldItem, b0<?> newItem) {
        boolean z;
        int i = 0;
        n.f(oldItem, "oldItem");
        n.f(newItem, "newItem");
        z = oldItem instanceof ChallengeNotificationItem;
        if (oldItem instanceof ChallengeNotificationItem) {
            z = newItem instanceof ChallengeNotificationItem;
            if (newItem instanceof ChallengeNotificationItem) {
                i = n.i(oldItem.g(), newItem.g());
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    public final void x() {
        if (!this.c) {
            app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem = null;
            b(new BlankScreenCell(entrySortingTabItem));
            boolean z = true;
            this.c = z;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    /* renamed from: y, reason: from kotlin metadata */
    public final void removeItemById(String notificationId) {
        int i = 0;
        n.f(notificationId, "notificationId");
        List list = k().F0();
        n.e(list, "exposeAdapter().currentItems");
        Iterator it = list.iterator();
        i = 0;
        while (it.hasNext()) {
            if (n.b((app.dogo.com.dogo_android.util.base_classes.b0)it.next().getId(), notificationId)) {
                break;
            }
        }
        i = -1;
        if (i >= 0) {
            removeItem(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    public final void z() {
        if (this.c) {
            app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem = null;
            r(new BlankScreenCell(entrySortingTabItem));
            boolean z = false;
            this.c = z;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    public Class<b0<?>> p() {
        return app.dogo.com.dogo_android.util.base_classes.b0.class;
    }
}
