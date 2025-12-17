package app.dogo.com.dogo_android.q.s;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.w1;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0008\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R7\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "(Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;)V", "getCallback", "()Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "dogParents", "getDogParents", "()Ljava/util/List;", "setDogParents", "(Ljava/util/List;)V", "dogParents$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItem", "position", "", "getItemCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "DefaultViewHolder", "DogParentsCallback", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends RecyclerView.h<app.dogo.com.dogo_android.q.s.b.a> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.q.s.b.b a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "", "onDelete", "", "dogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void t(DogParentUIState.DogParent dogParentUIState$DogParent);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellDogParentBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellDogParentBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellDogParentBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        private final w1 a;
        public a(w1 w1) {
            n.f(w1, "bind");
            super(w1.w());
            this.a = w1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final w1 a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends DogParentUIState.DogParent>> {

        final Object a;
        final app.dogo.com.dogo_android.q.s.b b;
        public d(Object object, Object object2, app.dogo.com.dogo_android.q.s.b b3) {
            this.a = object;
            this.b = b3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends DogParentUIState.DogParent> list2, List<? extends DogParentUIState.DogParent> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.q.s.b obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, b.c.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements p<DogParentUIState.DogParent, DogParentUIState.DogParent, Boolean> {

        public static final app.dogo.com.dogo_android.q.s.b.c a;
        static {
            b.c cVar = new b.c();
            b.c.a = cVar;
        }

        c() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(DogParentUIState.DogParent dogParentUIState$DogParent, DogParentUIState.DogParent dogParentUIState$DogParent2) {
            n.f(dogParent, "o");
            n.f(dogParent2, "n");
            return n.b(dogParent.getId(), dogParent2.getId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((DogParentUIState.DogParent)object, (DogParentUIState.DogParent)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(b.class), "dogParents", "getDogParents()Ljava/util/List;");
        b.c = arr;
    }

    public b(app.dogo.com.dogo_android.q.s.b.b b$b) {
        n.f(b, "callback");
        super();
        this.a = b;
        a obj2 = a.a;
        obj2 = p.g();
        b.d dVar = new b.d(obj2, obj2, this);
        this.b = dVar;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<DogParentUIState.DogParent> f() {
        return (List)this.b.getValue(this, b.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final DogParentUIState.DogParent g(int i) {
        return (DogParentUIState.DogParent)f().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return f().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.q.s.b.a b$a, int i2) {
        n.f(a, "holder");
        a.a().W((DogParentUIState.DogParent)f().get(i2));
        a.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.q.s.b.a i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final w1 obj3 = w1.U(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        b.a aVar = new b.a(obj3);
        return aVar;
    }

    public final void j(List<DogParentUIState.DogParent> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, b.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((b.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void removeItem(int i) {
        Object next;
        int i2;
        String str;
        Object obj = f().get(i);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = f().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z ^= 1 != 0) {
            }
            arrayList.add(next);
        }
        j(arrayList);
        this.a.t(obj);
        notifyItemRemoved(i);
    }
}
