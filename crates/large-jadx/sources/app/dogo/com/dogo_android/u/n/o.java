package app.dogo.com.dogo_android.u.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.u3;
import app.dogo.com.dogo_android.h.w3;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "EmptyCellViewHolder", "ReminderCellTypes", "ReminderCellViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends RecyclerView.h<app.dogo.com.dogo_android.u.n.o.b> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.u.n.o.a a;
    private final c b;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;", "", "onNewReminderSelection", "", "onReminderEnableToggle", "item", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "newState", "", "onReminderSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void S0();

        public abstract void k1(PottyRemindersItem pottyRemindersItem, boolean z2);

        public abstract void w1(PottyRemindersItem pottyRemindersItem);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$ReminderCellTypes;", "", "(Ljava/lang/String;I)V", "EMPTY_CELL", "REMINDER_CELL", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static enum d {

        EMPTY_CELL,
        REMINDER_CELL;
        private static final app.dogo.com.dogo_android.u.n.o.d[] $values() {
            app.dogo.com.dogo_android.u.n.o.d[] arr = new o.d[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[o.d.EMPTY_CELL.ordinal()] = 1;
            iArr[o.d.REMINDER_CELL.ordinal()] = 2;
            o.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "binding");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$EmptyCellViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewNewReminderBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter;Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewNewReminderBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewNewReminderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.u.n.o.b {

        final app.dogo.com.dogo_android.u.n.o b;
        public c(app.dogo.com.dogo_android.u.n.o o, u3 u32) {
            n.f(o, "this$0");
            n.f(u32, "bind");
            this.b = o;
            super(u32);
            g gVar = new g(o);
            a().w().setOnClickListener(gVar);
        }

        private static final void b(app.dogo.com.dogo_android.u.n.o o, View view2) {
            n.f(o, "this$0");
            o.f(o).S0();
        }

        public static void c(app.dogo.com.dogo_android.u.n.o o, View view2) {
            o.c.b(o, view2);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$ReminderCellViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewReminderBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter;Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewReminderBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewReminderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.u.n.o.b {

        private final w3 b;
        final app.dogo.com.dogo_android.u.n.o c;
        public e(app.dogo.com.dogo_android.u.n.o o, w3 w32) {
            n.f(o, "this$0");
            n.f(w32, "bind");
            this.c = o;
            super(w32);
            this.b = w32;
            i iVar = new i(o, this);
            a().w().setOnClickListener(iVar);
            h hVar = new h(o, this);
            w32.P.setOnCheckedChangeListener(hVar);
        }

        private static final void b(app.dogo.com.dogo_android.u.n.o o, app.dogo.com.dogo_android.u.n.o.e o$e2, View view3) {
            n.f(o, "this$0");
            n.f(e2, "this$1");
            o.f(o).w1((PottyRemindersItem)o.g().get(e2.getAdapterPosition()));
        }

        private static final void c(app.dogo.com.dogo_android.u.n.o o, app.dogo.com.dogo_android.u.n.o.e o$e2, CompoundButton compoundButton3, boolean z4) {
            Object obj0;
            n.f(o, "this$0");
            n.f(e2, "this$1");
            Object obj1 = o.g().get(e2.getAdapterPosition());
            if (z4 != (PottyRemindersItem)obj1.isActive()) {
                obj1.setActive(z4);
                o.f(o).k1(obj1, z4);
            }
        }

        public static void e(app.dogo.com.dogo_android.u.n.o o, app.dogo.com.dogo_android.u.n.o.e o$e2, CompoundButton compoundButton3, boolean z4) {
            o.e.c(o, e2, compoundButton3, z4);
        }

        public static void f(app.dogo.com.dogo_android.u.n.o o, app.dogo.com.dogo_android.u.n.o.e o$e2, View view3) {
            o.e.b(o, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.u.n.o$b
        public final w3 d() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends PottyRemindersItem>> {

        final Object a;
        final app.dogo.com.dogo_android.u.n.o b;
        public h(Object object, Object object2, app.dogo.com.dogo_android.u.n.o o3) {
            this.a = object;
            this.b = o3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends PottyRemindersItem> list2, List<? extends PottyRemindersItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.u.n.o obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, o.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements p<PottyRemindersItem, PottyRemindersItem, Boolean> {

        public static final app.dogo.com.dogo_android.u.n.o.g a;
        static {
            o.g gVar = new o.g();
            o.g.a = gVar;
        }

        g() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(PottyRemindersItem pottyRemindersItem, PottyRemindersItem pottyRemindersItem2) {
            n.f(pottyRemindersItem, "o");
            n.f(pottyRemindersItem2, "n");
            return n.b(pottyRemindersItem.getReminderId(), pottyRemindersItem2.getReminderId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((PottyRemindersItem)object, (PottyRemindersItem)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(o.class), "items", "getItems()Ljava/util/List;");
        o.c = arr;
    }

    public o(app.dogo.com.dogo_android.u.n.o.a o$a) {
        n.f(a, "callback");
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        o.h hVar = new o.h(obj2, obj2, this);
        this.b = hVar;
    }

    public static final app.dogo.com.dogo_android.u.n.o.a f(app.dogo.com.dogo_android.u.n.o o) {
        return o.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<PottyRemindersItem> g() {
        return (List)this.b.getValue(this, o.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return size++;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.u.n.o.d obj2;
        obj2 = i <= p.i(g()) ? o.d.REMINDER_CELL : o.d.EMPTY_CELL;
        return obj2.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.n.o.b o$b, int i2) {
        boolean z;
        List list;
        Object obj;
        int obj5;
        n.f(b, "holder");
        if (b instanceof o.e) {
            Object obj2 = b;
            (o.e)obj2.d().V((PottyRemindersItem)g().get(i2));
            w3Var.P.setChecked((PottyRemindersItem)g().get(i2).isActive());
        }
        b.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.o.b i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.u.n.o.b obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = o.f.a[o.d.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = w3.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new o.e(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = u3.T(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new o.c(this, obj5);
    }

    public final void j(List<PottyRemindersItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, o.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((o.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
