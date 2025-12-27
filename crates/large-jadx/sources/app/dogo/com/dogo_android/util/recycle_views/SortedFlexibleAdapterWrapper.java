package app.dogo.com.dogo_android.util.n0;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z;
import androidx.recyclerview.widget.z.a;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.b0;
import app.dogo.com.dogo_android.util.k0.f;
import h.a.b.b;
import h.a.b.e;
import h.a.b.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SortedFlexibleAdapterWrapper.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u001b\u0008&\u0018\u0000*\u000c\u0008\u0000\u0010\u0001*\u0006\u0012\u0002\u0008\u00030\u00022\u00020\u0003B#\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0003J\u001d\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0000H&¢\u0006\u0002\u0010+J\u001d\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H&¢\u0006\u0002\u0010+J\u0008\u0010/\u001a\u00020 H\u0016J\u0006\u00100\u001a\u00020 J\u001d\u00101\u001a\u00020\u00102\u0006\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0000H&¢\u0006\u0002\u00102J\u001d\u00103\u001a\u00020\u00102\u0006\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00102J\u000e\u00104\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0002J\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cJ\u0015\u00106\u001a\u0004\u0018\u00018\u00002\u0006\u00107\u001a\u00020\u0010¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u0010¢\u0006\u0002\u00108J\u0013\u0010:\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u000e\u0010;\u001a\u00020 2\u0006\u00107\u001a\u00020\u0010J\u0016\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0010J\u0014\u0010<\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005J\u000e\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020(J\u0015\u0010A\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0014\u0010B\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005R\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cX\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cX\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/SortedFlexibleAdapterWrapper;", "ItemType", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "", "items", "", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/BaseFlexibleAdapter;", "getAdapter", "()Lapp/dogo/com/dogo_android/util/recycle_views/BaseFlexibleAdapter;", "itemCount", "", "getItemCount", "()I", "itemTouchHelperCallback", "Leu/davidea/flexibleadapter/helpers/ItemTouchHelperCallback;", "getItemTouchHelperCallback", "()Leu/davidea/flexibleadapter/helpers/ItemTouchHelperCallback;", "itemType", "Ljava/lang/Class;", "getItemType", "()Ljava/lang/Class;", "sortedList", "Landroidx/recyclerview/widget/SortedList;", "getSortedList", "()Landroidx/recyclerview/widget/SortedList;", "addItem", "", "item", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)V", "addItems", "itemTypeList", "addListener", "listener", "areSortedContentsTheSame", "", "oldItem", "newItem", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)Z", "areSortedItemsTheSame", "item1", "item2", "clearList", "clearListeners", "compareSortedItems", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)I", "compareSortedItemsMainOrder", "createSortedList", "exposeAdapter", "getAdapterItem", "position", "(I)Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "getSortedItem", "removeItem", "removeItemAt", "removeItems", "from", "count", "setSwipeEnabled", "state", "updateItem", "updateItems", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v, reason: from kotlin metadata */
public abstract class SortedFlexibleAdapterWrapper<ItemType extends b0<?>> {

    private final d<ItemType> a = new d<>();
    private final z<ItemType> b;

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\t*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016¨\u0006\u001c", d2 = {"app/dogo/com/dogo_android/util/recycle_views/SortedFlexibleAdapterWrapper$createSortedList$1", "Landroidx/recyclerview/widget/SortedList$Callback;", "areContentsTheSame", "", "oldItem", "newItem", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)Z", "areItemsTheSame", "item1", "item2", "compare", "", "o1", "o2", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)I", "getChangePayload", "", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)Ljava/lang/Object;", "onChanged", "", "position", "count", "payload", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends z.a<ItemType> {

        final /* synthetic */ v<ItemType> a;
        a(v<ItemType> vVar) {
            this.a = vVar;
            super();
        }

        @Override // androidx.recyclerview.widget.z$a
        /* renamed from: d, reason: from kotlin metadata */
        public boolean getChangePayload(ItemType oldItem, ItemType newItem) {
            n.f(oldItem, "oldItem");
            n.f(newItem, "newItem");
            return this.a.e(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.z$a
        /* renamed from: e, reason: from kotlin metadata */
        public boolean onChanged(ItemType position, ItemType count) {
            n.f(position, "item1");
            n.f(count, "item2");
            return this.a.f(position, count);
        }

        @Override // androidx.recyclerview.widget.z$a
        /* renamed from: f, reason: from kotlin metadata */
        public int onInserted(ItemType position, ItemType count) {
            n.f(position, "o1");
            n.f(count, "o2");
            return this.a.i(position, count);
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onChanged(int position, int count, Object payload) {
            if (payload != null) {
                if (this.a.p().isAssignableFrom(payload.getClass())) {
                    this.a.l().b2(payload);
                } else {
                    this.a.l().c2((f)this.a.q().f(position), payload);
                }
            }
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onInserted(int i, int i2) {
            int i3 = 0;
            final ArrayList arrayList = new ArrayList();
            if (i2 > 0) {
                i3 = 0;
                i3 = i3 + 1;
                arrayList.add((app.dogo.com.dogo_android.util.base_classes.b0)this.a.q().f(i3 + i));
                while (i3 >= i2) {
                    i3 = i3 + 1;
                    arrayList.add((app.dogo.com.dogo_android.util.base_classes.b0)this.a.q().f(i3 + i));
                }
            }
            this.a.l().Z(i, arrayList);
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onMoved(int i, int i2) {
            int i3 = 0;
            int r1 = i > 1 ? i - 1 : 0;
            this.a.l().n().q1((i > 1 ? i - 1 : 0));
            this.a.l().v1(i, i2);
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onRemoved(int position, int count) {
            this.a.l().G1(position, count);
        }

        @Override // androidx.recyclerview.widget.z$a
        /* renamed from: g, reason: from kotlin metadata */
        public Object onMoved(ItemType fromPosition, ItemType toPosition) {
            return toPosition;
        }
    }
    public v(List<? extends ItemType> list, f fVar, q qVar) {
        n.f(list, "items");
        n.f(fVar, "messageBroadcaster");
        n.f(qVar, "parentTag");
        super();
        app.dogo.com.dogo_android.util.n0.d dVar = new app.dogo.com.dogo_android.util.recycle_views.d(list, fVar, qVar);
        this.b = clearList();
    }

    public static final /* synthetic */ int a(v vVar, b0 b0Var, b0 b0Var2) {
        return vVar.i(b0Var, b0Var2);
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final int areSortedContentsTheSame(ItemType oldItem, ItemType newItem) {
        int compare;
        if (Integer.compare(newItem.getSortingPriority(), oldItem.getSortingPriority()) == 0) {
            compare = h(oldItem, newItem);
        }
        return compare;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final z<ItemType> clearList() {
        return new z(p(), new SortedFlexibleAdapterWrapper_createSortedList_1(this));
    }

    /* renamed from: b, reason: from kotlin metadata */
    public void addItem(ItemType item) {
        n.f(item, "item");
        int indexOf = this.a.F0().indexOf(item);
        if (indexOf >= 0) {
            this.b.n(indexOf, item);
        } else {
            this.b.a(item);
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    public void addItems(List<? extends ItemType> itemTypeList) {
        item = "itemTypeList";
        n.f(itemTypeList, item);
        final Iterator it = itemTypeList.iterator();
        while (it.hasNext()) {
            b((app.dogo.com.dogo_android.util.base_classes.b0)it.next());
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void addListener(Object listener) {
        n.f(listener, "listener");
        this.a.a0(listener);
    }

    public void g() {
        this.b.d();
    }

    public final d<ItemType> k() {
        return this.a;
    }

    protected final d<ItemType> l() {
        return this.a;
    }

    /* renamed from: m, reason: from kotlin metadata */
    public final ItemType getAdapterItem(int position) {
        return (app.dogo.com.dogo_android.util.base_classes.b0)this.a.O0(position);
    }

    public final int n() {
        return this.b.l();
    }

    public final a o() {
        a aVar = this.a.Q0();
        n.e(aVar, "adapter.itemTouchHelperCallback");
        return aVar;
    }

    protected final z<ItemType> q() {
        return this.b;
    }

    /* renamed from: r, reason: from kotlin metadata */
    public final void getSortedItem(ItemType position) {
        n.f(position, "item");
        this.b.h(position);
    }

    /* renamed from: s, reason: from kotlin metadata */
    public final void removeItem(int item) {
        this.b.j(item);
    }

    /* renamed from: t, reason: from kotlin metadata */
    public final void removeItemAt(List<? extends ItemType> position) {
        item = "itemTypeList";
        n.f(position, item);
        final Iterator it = position.iterator();
        while (it.hasNext()) {
            this.b.h((app.dogo.com.dogo_android.util.base_classes.b0)it.next());
        }
    }

    /* renamed from: u, reason: from kotlin metadata */
    public final void removeItems(boolean itemTypeList) {
        this.a.P1(itemTypeList);
    }

    /* renamed from: v, reason: from kotlin metadata */
    public void setSwipeEnabled(ItemType state) {
        n.f(state, "item");
        int indexOf = this.a.F0().indexOf(state);
        if (indexOf >= 0) {
            this.b.n(indexOf, state);
        }
    }

    /* renamed from: w, reason: from kotlin metadata */
    public final void updateItem(List<? extends ItemType> item) {
        item2 = "itemTypeList";
        n.f(item, item2);
        final Iterator it = item.iterator();
        while (it.hasNext()) {
            v((app.dogo.com.dogo_android.util.base_classes.b0)it.next());
        }
    }

    /* renamed from: e, reason: from kotlin metadata */
    public abstract boolean areSortedItemsTheSame(ItemType item1, ItemType item2);

    /* renamed from: f, reason: from kotlin metadata */
    public abstract boolean compareSortedItems(ItemType oldItem, ItemType newItem);

    /* renamed from: h, reason: from kotlin metadata */
    public abstract int compareSortedItemsMainOrder(ItemType item1, ItemType item2);

    public abstract Class<ItemType> p();
}
