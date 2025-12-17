package app.dogo.com.dogo_android.dogcreation.j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.c0;
import app.dogo.com.dogo_android.h.e0;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\u000f\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "breedList", "getBreedList", "()Ljava/util/List;", "setBreedList", "(Ljava/util/List;)V", "breedList$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BreedHolder", "Callbacks", "CustomHolder", "Holder", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends RecyclerView.h<app.dogo.com.dogo_android.dogcreation.j.i.d> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.dogcreation.j.i.b a;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "", "onAddNewSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "onBreedItemSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void A0(DogBreed dogBreed);

        public abstract void y1(DogBreed dogBreed);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Type;", "", "(Ljava/lang/String;I)V", "BREED", "CUSTOM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static enum e {

        BREED,
        CUSTOM;
        private static final app.dogo.com.dogo_android.dogcreation.j.i.e[] $values() {
            app.dogo.com.dogo_android.dogcreation.j.i.e[] arr = new i.e[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[i.e.BREED.ordinal()] = 1;
            iArr[i.e.CUSTOM.ordinal()] = 2;
            i.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class d extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public d(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$BreedHolder;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellBreedListRowBinding;", "(Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter;Lapp/dogo/com/dogo_android/databinding/CellBreedListRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellBreedListRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends app.dogo.com.dogo_android.dogcreation.j.i.d {

        private final e0 b;
        final app.dogo.com.dogo_android.dogcreation.j.i c;
        public a(app.dogo.com.dogo_android.dogcreation.j.i i, e0 e02) {
            n.f(i, "this$0");
            n.f(e02, "binding");
            this.c = i;
            super(e02);
            this.b = e02;
            a aVar = new a(i, this);
            e02.w().setOnClickListener(aVar);
        }

        private static final void b(app.dogo.com.dogo_android.dogcreation.j.i i, app.dogo.com.dogo_android.dogcreation.j.i.a i$a2, View view3) {
            Object obj0;
            Object obj1;
            n.f(i, "this$0");
            n.f(a2, "this$1");
            app.dogo.com.dogo_android.dogcreation.j.i.b obj2 = i.f(i);
            if (obj2 == null) {
            } else {
                obj2.A0((DogBreed)i.g().get(a2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.dogcreation.j.i i, app.dogo.com.dogo_android.dogcreation.j.i.a i$a2, View view3) {
            i.a.b(i, a2, view3);
        }

        @Override // app.dogo.com.dogo_android.dogcreation.j.i$d
        public final e0 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$CustomHolder;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellBreedListNewBreedRowBinding;", "(Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter;Lapp/dogo/com/dogo_android/databinding/CellBreedListNewBreedRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellBreedListNewBreedRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.dogcreation.j.i.d {

        private final c0 b;
        final app.dogo.com.dogo_android.dogcreation.j.i c;
        public c(app.dogo.com.dogo_android.dogcreation.j.i i, c0 c02) {
            n.f(i, "this$0");
            n.f(c02, "binding");
            this.c = i;
            super(c02);
            this.b = c02;
            b bVar = new b(i, this);
            c02.w().setOnClickListener(bVar);
        }

        private static final void b(app.dogo.com.dogo_android.dogcreation.j.i i, app.dogo.com.dogo_android.dogcreation.j.i.c i$c2, View view3) {
            Object obj0;
            Object obj1;
            n.f(i, "this$0");
            n.f(c2, "this$1");
            app.dogo.com.dogo_android.dogcreation.j.i.b obj2 = i.f(i);
            if (obj2 == null) {
            } else {
                obj2.y1((DogBreed)i.g().get(c2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.dogcreation.j.i i, app.dogo.com.dogo_android.dogcreation.j.i.c i$c2, View view3) {
            i.c.b(i, c2, view3);
        }

        @Override // app.dogo.com.dogo_android.dogcreation.j.i$d
        public final c0 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends DogBreed>> {

        final Object a;
        final app.dogo.com.dogo_android.dogcreation.j.i b;
        public h(Object object, Object object2, app.dogo.com.dogo_android.dogcreation.j.i i3) {
            this.a = object;
            this.b = i3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends DogBreed> list2, List<? extends DogBreed> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.dogcreation.j.i obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, i.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements p<DogBreed, DogBreed, Boolean> {

        public static final app.dogo.com.dogo_android.dogcreation.j.i.g a;
        static {
            i.g gVar = new i.g();
            i.g.a = gVar;
        }

        g() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(DogBreed dogBreed, DogBreed dogBreed2) {
            n.f(dogBreed, "o");
            n.f(dogBreed2, "n");
            return n.b(dogBreed.getId(), dogBreed2.getId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((DogBreed)object, (DogBreed)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(i.class), "breedList", "getBreedList()Ljava/util/List;");
        i.c = arr;
    }

    public i(app.dogo.com.dogo_android.dogcreation.j.i.b i$b) {
        super();
        this.a = b;
        a obj2 = a.a;
        obj2 = p.g();
        i.h hVar = new i.h(obj2, obj2, this);
        this.b = hVar;
    }

    public static final app.dogo.com.dogo_android.dogcreation.j.i.b f(app.dogo.com.dogo_android.dogcreation.j.i i) {
        return i.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<DogBreed> g() {
        return (List)this.b.getValue(this, i.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        int obj2;
        if ((DogBreed)g().get(i).isCustom()) {
            obj2 = i.e.CUSTOM.ordinal();
        } else {
            obj2 = i.e.BREED.ordinal();
        }
        return obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.dogcreation.j.i.d i$d, int i2) {
        c0 c0Var;
        List list;
        Object obj4;
        n.f(d, "holder");
        if (d instanceof i.c) {
            (i.c)d.c().V((DogBreed)g().get(i2));
        } else {
            if (d instanceof i.a) {
                (i.a)d.c().V((DogBreed)g().get(i2));
            }
        }
        d.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.dogcreation.j.i.d i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.dogcreation.j.i.d obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = i.f.a[i.e.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = c0.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new i.c(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = e0.T(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new i.a(this, obj5);
    }

    public final void j(List<DogBreed> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, i.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((i.d)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
