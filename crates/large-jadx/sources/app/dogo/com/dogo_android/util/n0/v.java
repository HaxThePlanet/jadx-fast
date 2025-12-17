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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u001b\u0008&\u0018\u0000*\u000c\u0008\u0000\u0010\u0001*\u0006\u0012\u0002\u0008\u00030\u00022\u00020\u0003B#\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0003J\u001d\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0000H&¢\u0006\u0002\u0010+J\u001d\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H&¢\u0006\u0002\u0010+J\u0008\u0010/\u001a\u00020 H\u0016J\u0006\u00100\u001a\u00020 J\u001d\u00101\u001a\u00020\u00102\u0006\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0000H&¢\u0006\u0002\u00102J\u001d\u00103\u001a\u00020\u00102\u0006\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00102J\u000e\u00104\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0002J\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cJ\u0015\u00106\u001a\u0004\u0018\u00018\u00002\u0006\u00107\u001a\u00020\u0010¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u0010¢\u0006\u0002\u00108J\u0013\u0010:\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u000e\u0010;\u001a\u00020 2\u0006\u00107\u001a\u00020\u0010J\u0016\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0010J\u0014\u0010<\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005J\u000e\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020(J\u0015\u0010A\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0014\u0010B\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005R\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cX\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cX\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/SortedFlexibleAdapterWrapper;", "ItemType", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "", "items", "", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/BaseFlexibleAdapter;", "getAdapter", "()Lapp/dogo/com/dogo_android/util/recycle_views/BaseFlexibleAdapter;", "itemCount", "", "getItemCount", "()I", "itemTouchHelperCallback", "Leu/davidea/flexibleadapter/helpers/ItemTouchHelperCallback;", "getItemTouchHelperCallback", "()Leu/davidea/flexibleadapter/helpers/ItemTouchHelperCallback;", "itemType", "Ljava/lang/Class;", "getItemType", "()Ljava/lang/Class;", "sortedList", "Landroidx/recyclerview/widget/SortedList;", "getSortedList", "()Landroidx/recyclerview/widget/SortedList;", "addItem", "", "item", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)V", "addItems", "itemTypeList", "addListener", "listener", "areSortedContentsTheSame", "", "oldItem", "newItem", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)Z", "areSortedItemsTheSame", "item1", "item2", "clearList", "clearListeners", "compareSortedItems", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)I", "compareSortedItemsMainOrder", "createSortedList", "exposeAdapter", "getAdapterItem", "position", "(I)Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "getSortedItem", "removeItem", "removeItemAt", "removeItems", "from", "count", "setSwipeEnabled", "state", "updateItem", "updateItems", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class v<ItemType extends b0<?>>  {

    private final app.dogo.com.dogo_android.util.n0.d<ItemType> a;
    private final z<ItemType> b;

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\t*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016¨\u0006\u001c", d2 = {"app/dogo/com/dogo_android/util/recycle_views/SortedFlexibleAdapterWrapper$createSortedList$1", "Landroidx/recyclerview/widget/SortedList$Callback;", "areContentsTheSame", "", "oldItem", "newItem", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)Z", "areItemsTheSame", "item1", "item2", "compare", "", "o1", "o2", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)I", "getChangePayload", "", "(Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;)Ljava/lang/Object;", "onChanged", "", "position", "count", "payload", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends z.a<ItemType> {

        final app.dogo.com.dogo_android.util.n0.v<ItemType> a;
        a(app.dogo.com.dogo_android.util.n0.v<ItemType> v) {
            this.a = v;
            super();
        }

        @Override // androidx.recyclerview.widget.z$a
        public boolean a(Object object, Object object2) {
            return d((b0)object, (b0)object2);
        }

        @Override // androidx.recyclerview.widget.z$a
        public boolean b(Object object, Object object2) {
            return e((b0)object, (b0)object2);
        }

        @Override // androidx.recyclerview.widget.z$a
        public Object c(Object object, Object object2) {
            g((b0)object, (b0)object2);
            return object2;
        }

        @Override // androidx.recyclerview.widget.z$a
        public int compare(Object object, Object object2) {
            return f((b0)object, (b0)object2);
        }

        public boolean d(ItemType itemtype, ItemType itemtype2) {
            n.f(itemtype, "oldItem");
            n.f(itemtype2, "newItem");
            return this.a.e(itemtype, itemtype2);
        }

        public boolean e(ItemType itemtype, ItemType itemtype2) {
            n.f(itemtype, "item1");
            n.f(itemtype2, "item2");
            return this.a.f(itemtype, itemtype2);
        }

        public int f(ItemType itemtype, ItemType itemtype2) {
            n.f(itemtype, "o1");
            n.f(itemtype2, "o2");
            return v.a(this.a, itemtype, itemtype2);
        }

        public Object g(ItemType itemtype, ItemType itemtype2) {
            return itemtype2;
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onChanged(int i, int i2, Object object3) {
            Class class;
            Object obj2;
            boolean obj3;
            if (object3 != null && this.a.p().isAssignableFrom(object3.getClass())) {
                if (this.a.p().isAssignableFrom(object3.getClass())) {
                    this.a.l().b2((b0)object3);
                } else {
                    this.a.l().c2((f)this.a.q().f(i), object3);
                }
            } else {
            }
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onInserted(int i, int i2) {
            int i4;
            Object obj;
            int i3;
            z zVar;
            ArrayList arrayList = new ArrayList();
            if (i2 > 0) {
                i4 = 0;
                i3 = i4 + 1;
                arrayList.add((b0)this.a.q().f(i4 += i));
                while (i3 >= i2) {
                    i4 = i3;
                    i3 = i4 + 1;
                    arrayList.add((b0)this.a.q().f(i4 += i));
                }
            }
            this.a.l().Z(i, arrayList);
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onMoved(int i, int i2) {
            int i3;
            i3 = i > 1 ? i + -1 : 0;
            this.a.l().n().q1(i3);
            this.a.l().v1(i, i2);
        }

        @Override // androidx.recyclerview.widget.z$a
        public void onRemoved(int i, int i2) {
            this.a.l().G1(i, i2);
        }
    }
    public v(List<? extends ItemType> list, f f2, q q3) {
        n.f(list, "items");
        n.f(f2, "messageBroadcaster");
        n.f(q3, "parentTag");
        super();
        d dVar = new d(list, f2, q3);
        this.a = dVar;
        this.b = j();
    }

    public static final int a(app.dogo.com.dogo_android.util.n0.v v, b0 b02, b0 b03) {
        return v.i(b02, b03);
    }

    private final int i(ItemType itemtype, ItemType itemtype2) {
        int compare;
        if (Integer.compare(itemtype2.getSortingPriority(), itemtype.getSortingPriority()) == 0) {
            compare = h(itemtype, itemtype2);
        }
        return compare;
    }

    private final z<ItemType> j() {
        v.a aVar = new v.a(this);
        z zVar = new z(p(), aVar);
        return zVar;
    }

    public void b(ItemType itemtype) {
        int indexOf;
        z zVar;
        n.f(itemtype, "item");
        indexOf = this.a.F0().indexOf(itemtype);
        if (indexOf >= 0) {
            this.b.n(indexOf, itemtype);
        } else {
            this.b.a(itemtype);
        }
    }

    public void c(List<? extends ItemType> list) {
        String next;
        n.f(list, "itemTypeList");
        final Iterator obj2 = list.iterator();
        for (b0 next : obj2) {
            b(next);
        }
    }

    public final void d(Object object) {
        n.f(object, "listener");
        this.a.a0(object);
    }

    public abstract boolean e(ItemType itemtype, ItemType itemtype2);

    public abstract boolean f(ItemType itemtype, ItemType itemtype2);

    public void g() {
        this.b.d();
    }

    public abstract int h(ItemType itemtype, ItemType itemtype2);

    public final app.dogo.com.dogo_android.util.n0.d<ItemType> k() {
        return this.a;
    }

    protected final app.dogo.com.dogo_android.util.n0.d<ItemType> l() {
        return this.a;
    }

    public final ItemType m(int i) {
        return (b0)this.a.O0(i);
    }

    public final int n() {
        return this.b.l();
    }

    public final a o() {
        a aVar = this.a.Q0();
        n.e(aVar, "adapter.itemTouchHelperCallback");
        return aVar;
    }

    public abstract Class<ItemType> p();

    protected final z<ItemType> q() {
        return this.b;
    }

    public final void r(ItemType itemtype) {
        n.f(itemtype, "item");
        this.b.h(itemtype);
    }

    public final void s(int i) {
        this.b.j(i);
    }

    public final void t(List<? extends ItemType> list) {
        String next;
        z zVar;
        n.f(list, "itemTypeList");
        final Iterator obj3 = list.iterator();
        for (b0 next : obj3) {
            this.b.h(next);
        }
    }

    public final void u(boolean z) {
        this.a.P1(z);
    }

    public void v(ItemType itemtype) {
        z zVar;
        n.f(itemtype, "item");
        int indexOf = this.a.F0().indexOf(itemtype);
        if (indexOf >= 0) {
            this.b.n(indexOf, itemtype);
        }
    }

    public final void w(List<? extends ItemType> list) {
        String next;
        n.f(list, "itemTypeList");
        final Iterator obj2 = list.iterator();
        for (b0 next : obj2) {
            v(next);
        }
    }
}
