package app.dogo.com.dogo_android.u.n.p.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.o1;
import app.dogo.com.dogo_android.h.s1;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.util.n0.i;
import app.dogo.com.dogo_android.util.n0.i.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0005#$%&'B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000fR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\u0008\u0012\u0004\u0012\u00020\t`\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "items", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "initialSelection", "", "isNewLog", "", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;Ljava/util/List;Ljava/lang/String;Z)V", "getInitialSelection", "()Ljava/lang/String;", "()Z", "selectedTags", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedTags", "()Ljava/util/ArrayList;", "getItemCount", "", "getItemViewType", "position", "handleAddingNewLog", "", "tagId", "handleEditingExistingLog", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "CellHolder", "DividerHolder", "Holder", "ItemTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends RecyclerView.h<app.dogo.com.dogo_android.u.n.p.l.j.d> {

    private final app.dogo.com.dogo_android.u.n.p.l.j.a a;
    private final List<i> b;
    private final String c;
    private final boolean d;
    private final ArrayList<String> e;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\u0008\u0012\u0004\u0012\u00020\u0006`\u0007H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "", "onTagSelected", "", "types", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void C0(ArrayList<String> arrayList);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u0000 \u00052\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$ItemTypes;", "", "(Ljava/lang/String;I)V", "ITEM", "DIVIDER", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum e {

        ITEM,
        DIVIDER;
        private static final app.dogo.com.dogo_android.u.n.p.l.j.e[] $values() {
            app.dogo.com.dogo_android.u.n.p.l.j.e[] arr = new j.e[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[j.e.DIVIDER.ordinal()] = 1;
            iArr[j.e.ITEM.ordinal()] = 2;
            j.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$CellHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.u.n.p.l.j.d {

        private final s1 b;
        final app.dogo.com.dogo_android.u.n.p.l.j c;
        public b(app.dogo.com.dogo_android.u.n.p.l.j j, s1 s12) {
            n.f(j, "this$0");
            n.f(s12, "binding");
            this.c = j;
            super(s12);
            this.b = s12;
            f fVar = new f(j, this);
            s12.w().setOnClickListener(fVar);
        }

        private static final void b(app.dogo.com.dogo_android.u.n.p.l.j j, app.dogo.com.dogo_android.u.n.p.l.j.b j$b2, View view3) {
            String obj3;
            n.f(j, "this$0");
            n.f(b2, "this$1");
            obj3 = j.g(j).get(b2.getBindingAdapterPosition());
            if (j.n()) {
                j.h(j, (i.b)obj3.a().getTagId());
            } else {
                j.i(j, obj3.a().getTagId());
            }
            j.notifyItemChanged(b2.getBindingAdapterPosition(), 0);
            j.f(j).C0(j.j());
        }

        public static void d(app.dogo.com.dogo_android.u.n.p.l.j j, app.dogo.com.dogo_android.u.n.p.l.j.b j$b2, View view3) {
            j.b.b(j, b2, view3);
        }

        @Override // app.dogo.com.dogo_android.u.n.p.l.j$d
        public final s1 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$DividerHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogDividerBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogDividerBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogDividerBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.u.n.p.l.j.d {
        public c(app.dogo.com.dogo_android.u.n.p.l.j j, o1 o12) {
            n.f(j, "this$0");
            n.f(o12, "binding");
            super(o12);
        }
    }
    public j(app.dogo.com.dogo_android.u.n.p.l.j.a j$a, List<? extends i> list2, String string3, boolean z4) {
        ArrayList obj2;
        n.f(a, "callback");
        n.f(list2, "items");
        super();
        this.a = a;
        this.b = list2;
        this.c = string3;
        this.d = z4;
        obj2 = new ArrayList();
        this.e = obj2;
        if (string3 == null) {
        } else {
            j().add(string3);
        }
    }

    public static final app.dogo.com.dogo_android.u.n.p.l.j.a f(app.dogo.com.dogo_android.u.n.p.l.j j) {
        return j.a;
    }

    public static final List g(app.dogo.com.dogo_android.u.n.p.l.j j) {
        return j.b;
    }

    public static final void h(app.dogo.com.dogo_android.u.n.p.l.j j, String string2) {
        j.l(string2);
    }

    public static final void i(app.dogo.com.dogo_android.u.n.p.l.j j, String string2) {
        j.m(string2);
    }

    private final void l(String string) {
        ArrayList list;
        if (this.e.contains(string)) {
            this.e.remove(string);
        } else {
            this.e.add(string);
        }
    }

    private final void m(String string) {
        Integer valueOf;
        Iterator iterator;
        int i;
        int i2;
        boolean next;
        Object next2;
        boolean z;
        Iterator iterator2 = this.e.iterator();
        for (String next4 : iterator2) {
            iterator = this.b.iterator();
            i = 0;
            i2 = i;
            while (iterator.hasNext()) {
                next2 = iterator.next();
                if (next2 instanceof i.b && n.b((i.b)(i)next2.a().getTagId(), next4)) {
                } else {
                }
                next = i;
                i2++;
                if (n.b((i.b)next2.a().getTagId(), next4)) {
                } else {
                }
                next = 1;
            }
            i2 = -1;
            notifyItemChanged(i2, Integer.valueOf(i));
            next2 = iterator.next();
            if (next2 instanceof i.b && n.b((i.b)(i)next2.a().getTagId(), next4)) {
            } else {
            }
            next = i;
            if (next != 0) {
            } else {
            }
            i2++;
            if (n.b((i.b)next2.a().getTagId(), next4)) {
            } else {
            }
            next = 1;
        }
        this.e.clear();
        this.e.add(string);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return j.e.Companion.a((i)this.b.get(i)).ordinal();
    }

    public final ArrayList<String> j() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final boolean n() {
        return this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void o(app.dogo.com.dogo_android.u.n.p.l.j.d j$d, int i2) {
        boolean z;
        ArrayList list;
        e eVar;
        int obj5;
        n.f(d, "holder");
        if (d instanceof j.b) {
            obj5 = this.b.get(i2);
            Object obj = d;
            (j.b)obj.c().V((i.b)obj5.a());
            obj.c().W(Boolean.valueOf(this.e.contains(obj5.a().getTagId())));
        }
        d.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        o((j.d)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return p(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.p.l.j.d p(ViewGroup viewGroup, int i2) {
        String str;
        int i;
        ViewDataBinding obj4;
        app.dogo.com.dogo_android.u.n.p.l.j.d obj5;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj5 = j.f.a[j.e.values()[i2].ordinal()];
        final int i3 = 0;
        if (obj5 != 1) {
            if (obj5 != 2) {
            } else {
                obj4 = s1.T(from, viewGroup, i3);
                n.e(obj4, "inflate(inflater, parent, false)");
                obj5 = new j.b(this, obj4);
                return obj5;
            }
            obj4 = new NoWhenBranchMatchedException();
            throw obj4;
        }
        obj4 = o1.T(from, viewGroup, i3);
        n.e(obj4, "inflate(\n                    inflater,\n                    parent,\n                    false\n                )");
        obj5 = new j.c(this, obj4);
    }
}
