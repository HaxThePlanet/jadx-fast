package app.dogo.com.dogo_android.q.s;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.w1;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: DogParentsAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0008\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R7\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "(Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;)V", "getCallback", "()Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "dogParents", "getDogParents", "()Ljava/util/List;", "setDogParents", "(Ljava/util/List;)V", "dogParents$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItem", "position", "", "getItemCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "DefaultViewHolder", "DogParentsCallback", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class DogParentsAdapter extends RecyclerView.h<b.a> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    private final b.b a;
    private final c b = new b$d();

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "", "onDelete", "", "dogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: t, reason: from kotlin metadata */
        void onDelete(DogParentUIState.DogParent dogParent);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellDogParentBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellDogParentBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellDogParentBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        private final w1 a;
        public a(w1 w1Var) {
            n.f(w1Var, "bind");
            super(w1Var.w());
            this.a = w1Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final w1 a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends DogParentUIState.DogParent>> {

        final /* synthetic */ Object a;
        final /* synthetic */ b b;
        public d(Object object, Object object2, b bVar) {
            this.a = object;
            this.b = bVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends DogParentUIState.DogParent> oldValue, List<? extends DogParentUIState.DogParent> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.profile.ownerList.b.c.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.p<DogParentUIState.DogParent, DogParentUIState.DogParent, Boolean> {

        public static final b.c a = new b$c();
        @Override // kotlin.d0.d.p
        public final boolean a(DogParentUIState.DogParent dogParent, DogParentUIState.DogParent dogParent2) {
            n.f(dogParent, "o");
            n.f(dogParent2, "n");
            return n.b(dogParent.getId(), dogParent2.getId());
        }


        c() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        DogParentsAdapter.c = new l[] { c0.f(new t(c0.b(DogParentsAdapter.class), "dogParents", "getDogParents()Ljava/util/List;")) };
    }

    public b(b.b bVar) {
        n.f(bVar, "callback");
        super();
        this.a = bVar;
        List list = p.g();
        app.dogo.com.dogo_android.q.s.b.d delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: f, reason: from kotlin metadata */
    public final List<DogParentUIState.DogParent> getItemCount() {
        return (List)this.b.getValue(this, DogParentsAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final DogParentUIState.DogParent getItem(int position) {
        return (DogParentUIState_DogParent)getItemCount().get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(b.a holder, int position) {
        n.f(holder, "holder");
        holder.a().W((DogParentUIState_DogParent)getItemCount().get(position));
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public b.a onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final w1 w1Var = w1.U(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(w1Var, "inflate(inflater, parent, false)");
        return new DogParentsAdapter_DefaultViewHolder(w1Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: j, reason: from kotlin metadata */
    public final void removeItem(List<DogParentUIState.DogParent> position) {
        n.f(position, "<set-?>");
        this.b.setValue(this, DogParentsAdapter.c[0], position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void removeItem(int i) {
        Object item2 = getItemCount().get(i);
        final ArrayList arrayList = new ArrayList();
        Iterator it = getItemCount().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            i2 = !(n.b((DogParentUIState_DogParent)item.getId(), item2.getId()));
        }
        removeItem(arrayList);
        this.a.onDelete(item2);
        notifyItemRemoved(i);
    }
}
