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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B'\u0012\u0010\u0010\u0003\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u0011J \u0010\u0014\u001a\u00020\u000f2\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J \u0010\u0017\u001a\u00020\u000f2\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u00022\n\u0010\u0019\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J\u0008\u0010\u001a\u001a\u00020\u0011H\u0016J \u0010\u001b\u001a\u00020\u001c2\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0011R\u001e\u0010\n\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationListAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/SortedFlexibleAdapterWrapper;", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "items", "", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "itemType", "Ljava/lang/Class;", "getItemType", "()Ljava/lang/Class;", "loadingCellState", "", "addItems", "", "itemTypeList", "addLoadingCell", "areSortedContentsTheSame", "oldItem", "newItem", "areSortedItemsTheSame", "item1", "item2", "clearList", "compareSortedItems", "", "removeItemById", "notificationId", "", "removeLoadingCell", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends v<b0<?>> {

    private boolean c;
    public i(List<? extends b0<?>> list, f f2, q q3) {
        n.f(list, "items");
        n.f(f2, "messageBroadcaster");
        n.f(q3, "parentTag");
        super(list, f2, q3);
        x();
    }

    public void c(List<? extends b0<?>> list) {
        n.f(list, "itemTypeList");
        super.c(list);
        z();
    }

    public boolean e(b0<?> b0, b0<?> b02) {
        n.f(b0, "oldItem");
        n.f(b02, "newItem");
        return b0.isContentSame(b02);
    }

    public boolean f(b0<?> b0, b0<?> b02) {
        n.f(b0, "item1");
        n.f(b02, "item2");
        return n.b(b0, b02);
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    public void g() {
        super.g();
        this.c = false;
    }

    public int h(b0<?> b0, b0<?> b02) {
        boolean z;
        int obj3;
        n.f(b0, "oldItem");
        n.f(b02, "newItem");
        if (b0 instanceof a && b02 instanceof a) {
            if (b02 instanceof a) {
                obj3 = n.i((a)b0.g(), obj1);
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    public Class<b0<?>> p() {
        return b0.class;
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    public final void x() {
        boolean z;
        int i;
        if (!this.c) {
            BlankScreenCell blankScreenCell = new BlankScreenCell(0);
            b(blankScreenCell);
            this.c = true;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    public final void y(String string) {
        int i;
        boolean next;
        n.f(string, "notificationId");
        List list = k().F0();
        n.e(list, "exposeAdapter().currentItems");
        Iterator iterator = list.iterator();
        i = 0;
        for (b0 next2 : iterator) {
            i++;
        }
        i = -1;
        if (i >= 0) {
            s(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.v
    public final void z() {
        boolean z;
        int i;
        if (this.c) {
            BlankScreenCell blankScreenCell = new BlankScreenCell(0);
            r(blankScreenCell);
            this.c = false;
        }
    }
}
