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
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: PottyReminderListAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "EmptyCellViewHolder", "ReminderCellTypes", "ReminderCellViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class PottyReminderListAdapter extends RecyclerView.h<o.b> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final o.a callback;
    private final c b = new o$h();

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;", "", "onNewReminderSelection", "", "onReminderEnableToggle", "item", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "newState", "", "onReminderSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: S0, reason: from kotlin metadata */
        void onNewReminderSelection();

        /* renamed from: k1, reason: from kotlin metadata */
        void onReminderEnableToggle(PottyRemindersItem item, boolean newState);

        /* renamed from: w1, reason: from kotlin metadata */
        void onReminderSelected(PottyRemindersItem item);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$ReminderCellTypes;", "", "(Ljava/lang/String;I)V", "EMPTY_CELL", "REMINDER_CELL", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private enum d {

        EMPTY_CELL,
        REMINDER_CELL;
        private static final /* synthetic */ o.d[] $values() {
            app.dogo.com.dogo_android.u.n.o.d[] arr = new o.d[2];
            return new o.d[] { PottyReminderListAdapter_ReminderCellTypes.EMPTY_CELL, PottyReminderListAdapter_ReminderCellTypes.REMINDER_CELL };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[PottyReminderListAdapter_ReminderCellTypes.values().length];
            iArr[PottyReminderListAdapter_ReminderCellTypes.EMPTY_CELL.ordinal()] = 1;
            iArr[PottyReminderListAdapter_ReminderCellTypes.REMINDER_CELL.ordinal()] = 2;
            kotlinx.coroutines.o.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding binding;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "binding");
            super(viewDataBinding.w());
            this.binding = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.binding;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$EmptyCellViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewNewReminderBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter;Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewNewReminderBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewNewReminderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends o.b {

        final /* synthetic */ o b;
        public c(u3 u3Var) {
            n.f(oVar, "this$0");
            n.f(u3Var, "bind");
            this.b = oVar;
            super(u3Var);
            a().w().setOnClickListener(new kotlinx.coroutines.g(oVar));
        }

        private static final void b(o oVar, View view) {
            n.f(oVar, "this$0");
            oVar.callback.onNewReminderSelection();
        }

        public static /* synthetic */ void c(o oVar, View view) {
            PottyReminderListAdapter_EmptyCellViewHolder.b(oVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$ReminderCellViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewReminderBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter;Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewReminderBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewReminderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends o.b {

        private final w3 b;
        final /* synthetic */ o c;
        public e(w3 w3Var) {
            n.f(oVar, "this$0");
            n.f(w3Var, "bind");
            this.c = oVar;
            super(w3Var);
            this.b = w3Var;
            a().w().setOnClickListener(new kotlinx.coroutines.i(oVar, this));
            w3Var.P.setOnCheckedChangeListener(new kotlinx.coroutines.h(oVar, this));
        }

        private static final void b(o oVar, o.e eVar, View view) {
            n.f(oVar, "this$0");
            n.f(eVar, "this$1");
            oVar.callback.onReminderSelected((PottyRemindersItem)oVar.getItemCount().get(eVar.getAdapterPosition()));
        }

        private static final void c(o oVar, o.e eVar, CompoundButton compoundButton, boolean z) {
            n.f(oVar, "this$0");
            n.f(eVar, "this$1");
            Object item = oVar.getItemCount().get(eVar.getAdapterPosition());
            if (z != item.isActive()) {
                item.setActive(z);
                oVar.callback.onReminderEnableToggle(item, z);
            }
        }

        @Override // app.dogo.com.dogo_android.u.n.o$b
        public final w3 d() {
            return this.b;
        }

        public static /* synthetic */ void e(o oVar, o.e eVar, CompoundButton compoundButton, boolean z) {
            PottyReminderListAdapter_ReminderCellViewHolder.c(oVar, eVar, compoundButton, z);
        }

        public static /* synthetic */ void f(o oVar, o.e eVar, View view) {
            PottyReminderListAdapter_ReminderCellViewHolder.b(oVar, eVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends PottyRemindersItem>> {

        final /* synthetic */ Object a;
        final /* synthetic */ o b;
        public h(Object object, Object object2, o oVar) {
            this.a = object;
            this.b = oVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends PottyRemindersItem> oldValue, List<? extends PottyRemindersItem> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.o.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.p<PottyRemindersItem, PottyRemindersItem, Boolean> {

        public static final o.g a = new o$g();
        @Override // kotlin.d0.d.p
        public final boolean a(PottyRemindersItem pottyRemindersItem, PottyRemindersItem pottyRemindersItem2) {
            n.f(pottyRemindersItem, "o");
            n.f(pottyRemindersItem2, "n");
            return n.b(pottyRemindersItem.getReminderId(), pottyRemindersItem2.getReminderId());
        }


        g() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        PottyReminderListAdapter.c = new l[] { c0.f(new t(c0.b(PottyReminderListAdapter.class), "items", "getItems()Ljava/util/List;")) };
    }

    public o(o.a aVar) {
        n.f(aVar, "callback");
        super();
        this.callback = aVar;
        List list = p.g();
        app.dogo.com.dogo_android.u.n.o.h delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ o.a getItemViewType(o position) {
        return position.callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<PottyRemindersItem> getItemCount() {
        return (List)this.b.getValue(this, PottyReminderListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.u.n.o.d rEMINDER_CELL2;
        i = i <= p.i(getItemCount()) ? PottyReminderListAdapter_ReminderCellTypes.REMINDER_CELL : PottyReminderListAdapter_ReminderCellTypes.EMPTY_CELL;
        return (i <= p.i(getItemCount()) ? PottyReminderListAdapter_ReminderCellTypes.REMINDER_CELL : PottyReminderListAdapter_ReminderCellTypes.EMPTY_CELL);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(o.b holder, int position) {
        n.f(holder, "holder");
        z = holder instanceof PottyReminderListAdapter_ReminderCellViewHolder;
        if (holder instanceof PottyReminderListAdapter_ReminderCellViewHolder) {
            Object holder2 = holder;
            holder2.d().V((PottyRemindersItem)getItemCount().get(position));
            holder2.d().P.setChecked((PottyRemindersItem)getItemCount().get(position).isActive());
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public o.b onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.u.n.o.e pottyReminderListAdapter_ReminderCellViewHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = kotlinx.coroutines.o.f.a[PottyReminderListAdapter_ReminderCellTypes.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                w3 w3Var = w3.T(from, parent, z);
                n.e(w3Var, str2);
                pottyReminderListAdapter_ReminderCellViewHolder = new PottyReminderListAdapter_ReminderCellViewHolder(this, w3Var);
                return pottyReminderListAdapter_ReminderCellViewHolder;
            }
        }
        u3 u3Var = u3.T(from, parent, z);
        n.e(u3Var, str2);
        app.dogo.com.dogo_android.u.n.o.c pottyReminderListAdapter_EmptyCellViewHolder = new PottyReminderListAdapter_EmptyCellViewHolder(this, u3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<PottyRemindersItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, PottyReminderListAdapter.c[0], list);
    }
}
