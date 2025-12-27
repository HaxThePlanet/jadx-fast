package app.dogo.com.dogo_android.dogcreation.j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.e0;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: BreedSearchListAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\u000f\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "breedList", "getBreedList", "()Ljava/util/List;", "setBreedList", "(Ljava/util/List;)V", "breedList$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BreedHolder", "Callbacks", "CustomHolder", "Holder", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class BreedSearchListAdapter extends RecyclerView.h<i.d> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    private final i.b a;
    /* renamed from: b, reason: from kotlin metadata */
    private final c callbacks = new i$h();

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "", "onAddNewSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "onBreedItemSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: A0, reason: from kotlin metadata */
        void onAddNewSelected(DogBreed item);

        /* renamed from: y1, reason: from kotlin metadata */
        void onBreedItemSelected(DogBreed item);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Type;", "", "(Ljava/lang/String;I)V", "BREED", "CUSTOM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private enum e {

        BREED,
        CUSTOM;
        private static final /* synthetic */ i.e[] $values() {
            app.dogo.com.dogo_android.dogcreation.j.i.e[] arr = new i.e[2];
            return new i.e[] { BreedSearchListAdapter_Type.BREED, BreedSearchListAdapter_Type.CUSTOM };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[BreedSearchListAdapter_Type.values().length];
            iArr[BreedSearchListAdapter_Type.BREED.ordinal()] = 1;
            iArr[BreedSearchListAdapter_Type.CUSTOM.ordinal()] = 2;
            app.dogo.com.dogo_android.dogcreation.breed.i.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class d extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public d(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$BreedHolder;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellBreedListRowBinding;", "(Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter;Lapp/dogo/com/dogo_android/databinding/CellBreedListRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellBreedListRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends i.d {

        private final e0 b;
        final /* synthetic */ i c;
        public a(e0 e0Var) {
            n.f(iVar, "this$0");
            n.f(e0Var, "binding");
            this.c = iVar;
            super(e0Var);
            this.b = e0Var;
            e0Var.w().setOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.a(iVar, this));
        }

        private static final void b(i iVar, i.a aVar, View view) {
            n.f(iVar, "this$0");
            n.f(aVar, "this$1");
            app.dogo.com.dogo_android.dogcreation.j.i.b itemViewType = iVar.a;
            if (itemViewType != null) {
                itemViewType.onAddNewSelected((DogBreed)iVar.getItemCount().get(aVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.dogcreation.j.i$d
        public final e0 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, i.a aVar, View view) {
            BreedSearchListAdapter_BreedHolder.b(iVar, aVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$CustomHolder;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellBreedListNewBreedRowBinding;", "(Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter;Lapp/dogo/com/dogo_android/databinding/CellBreedListNewBreedRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellBreedListNewBreedRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends i.d {

        private final app.dogo.com.dogo_android.h.c0 b;
        final /* synthetic */ i c;
        public c(app.dogo.com.dogo_android.h.c0 c0Var) {
            n.f(iVar, "this$0");
            n.f(c0Var, "binding");
            this.c = iVar;
            super(c0Var);
            this.b = c0Var;
            c0Var.w().setOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.b(iVar, this));
        }

        private static final void b(i iVar, i.c cVar, View view) {
            n.f(iVar, "this$0");
            n.f(cVar, "this$1");
            app.dogo.com.dogo_android.dogcreation.j.i.b itemViewType = iVar.a;
            if (itemViewType != null) {
                itemViewType.onBreedItemSelected((DogBreed)iVar.getItemCount().get(cVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.dogcreation.j.i$d
        public final app.dogo.com.dogo_android.h.c0 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, i.c cVar, View view) {
            BreedSearchListAdapter_CustomHolder.b(iVar, cVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends DogBreed>> {

        final /* synthetic */ Object a;
        final /* synthetic */ i b;
        public h(Object object, Object object2, i iVar) {
            this.a = object;
            this.b = iVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends DogBreed> oldValue, List<? extends DogBreed> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.dogcreation.breed.i.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.p<DogBreed, DogBreed, Boolean> {

        public static final i.g a = new i$g();
        @Override // kotlin.d0.d.p
        public final boolean a(DogBreed dogBreed, DogBreed dogBreed2) {
            n.f(dogBreed, "o");
            n.f(dogBreed2, "n");
            return n.b(dogBreed.getId(), dogBreed2.getId());
        }


        g() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        BreedSearchListAdapter.c = new l[] { c0.f(new t(c0.b(BreedSearchListAdapter.class), "breedList", "getBreedList()Ljava/util/List;")) };
    }

    public i(i.b bVar) {
        super();
        this.a = bVar;
        List list = p.g();
        final app.dogo.com.dogo_android.dogcreation.j.i.h delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ i.b getItemViewType(i position) {
        return position.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<DogBreed> getItemCount() {
        return (List)this.callbacks.getValue(this, BreedSearchListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        int ordinal;
        if ((DogBreed)getItemCount().get(i).isCustom()) {
            ordinal = BreedSearchListAdapter_Type.CUSTOM.ordinal();
        } else {
            ordinal = BreedSearchListAdapter_Type.BREED.ordinal();
        }
        return ordinal;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(i.d holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof BreedSearchListAdapter_CustomHolder) {
            (BreedSearchListAdapter_CustomHolder)holder.c().V((DogBreed)getItemCount().get(position));
        } else {
            if (holder instanceof BreedSearchListAdapter_BreedHolder) {
                (BreedSearchListAdapter_BreedHolder)holder.c().V((DogBreed)getItemCount().get(position));
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public i.d onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.dogcreation.j.i.c breedSearchListAdapter_CustomHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = app.dogo.com.dogo_android.dogcreation.breed.i.f.a[BreedSearchListAdapter_Type.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                app.dogo.com.dogo_android.h.c0 c0Var = c0.T(from, parent, z);
                n.e(c0Var, str2);
                breedSearchListAdapter_CustomHolder = new BreedSearchListAdapter_CustomHolder(this, c0Var);
                return breedSearchListAdapter_CustomHolder;
            }
        }
        e0 e0Var = e0.T(from, parent, z);
        n.e(e0Var, str2);
        app.dogo.com.dogo_android.dogcreation.j.i.a breedSearchListAdapter_BreedHolder = new BreedSearchListAdapter_BreedHolder(this, e0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<DogBreed> list) {
        n.f(list, "<set-?>");
        this.callbacks.setValue(this, BreedSearchListAdapter.c[0], list);
    }
}
