package app.dogo.com.dogo_android.u;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.o7;
import app.dogo.com.dogo_android.h.q7;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
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

/* compiled from: SpecialProgramVariationAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "CellTypes", "DefaultViewHolder", "LockedVariationViewHolder", "VariationViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class SpecialProgramVariationAdapter extends RecyclerView.h<l.c> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final l.a callbacks;
    private final c b = new l$h();

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;", "", "onLockedTrickSelected", "", "onVariationTrickSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: Y, reason: from kotlin metadata */
        void onLockedTrickSelected();

        /* renamed from: p0, reason: from kotlin metadata */
        void onVariationTrickSelected(TrickItem item);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$CellTypes;", "", "(Ljava/lang/String;I)V", "VARIATION", "LOCKED_VARIATION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private enum b {

        LOCKED_VARIATION,
        VARIATION;
        private static final /* synthetic */ l.b[] $values() {
            app.dogo.com.dogo_android.u.l.b[] arr = new l.b[2];
            return new l.b[] { SpecialProgramVariationAdapter_CellTypes.VARIATION, SpecialProgramVariationAdapter_CellTypes.LOCKED_VARIATION };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[SpecialProgramVariationAdapter_CellTypes.values().length];
            iArr[SpecialProgramVariationAdapter_CellTypes.LOCKED_VARIATION.ordinal()] = 1;
            iArr[SpecialProgramVariationAdapter_CellTypes.VARIATION.ordinal()] = 2;
            app.dogo.com.dogo_android.specialprograms.l.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$LockedVariationViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramLockedVariationsBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramLockedVariationsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramLockedVariationsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends l.c {

        private final o7 b;
        final /* synthetic */ l c;
        public d(o7 o7Var) {
            n.f(lVar, "this$0");
            n.f(o7Var, "binding");
            this.c = lVar;
            super(o7Var);
            this.b = o7Var;
            a().w().setOnClickListener(new app.dogo.com.dogo_android.specialprograms.d(lVar));
        }

        private static final void b(l lVar, View view) {
            n.f(lVar, "this$0");
            lVar.callbacks.onLockedTrickSelected();
        }

        @Override // app.dogo.com.dogo_android.u.l$c
        public final o7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(l lVar, View view) {
            SpecialProgramVariationAdapter_LockedVariationViewHolder.b(lVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$VariationViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramVariationsBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramVariationsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramVariationsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends l.c {

        private final q7 b;
        final /* synthetic */ l c;
        public e(q7 q7Var) {
            n.f(lVar, "this$0");
            n.f(q7Var, "binding");
            this.c = lVar;
            super(q7Var);
            this.b = q7Var;
            a().w().setOnClickListener(new app.dogo.com.dogo_android.specialprograms.e(lVar, this));
        }

        private static final void b(l lVar, l.e eVar, View view) {
            n.f(lVar, "this$0");
            n.f(eVar, "this$1");
            lVar.callbacks.onVariationTrickSelected((TrickItem)lVar.getItemCount().get(eVar.getAdapterPosition()));
        }

        @Override // app.dogo.com.dogo_android.u.l$c
        public final q7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(l lVar, l.e eVar, View view) {
            SpecialProgramVariationAdapter_VariationViewHolder.b(lVar, eVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends TrickItem>> {

        final /* synthetic */ Object a;
        final /* synthetic */ l b;
        public h(Object object, Object object2, l lVar) {
            this.a = object;
            this.b = lVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends TrickItem> oldValue, List<? extends TrickItem> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.specialprograms.l.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.p<TrickItem, TrickItem, Boolean> {

        public static final l.g a = new l$g();
        @Override // kotlin.d0.d.p
        public final boolean a(TrickItem trickItem, TrickItem trickItem2) {
            n.f(trickItem, "o");
            n.f(trickItem2, "n");
            return n.b(trickItem.getId(), trickItem2.getId());
        }


        g() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        SpecialProgramVariationAdapter.c = new l[] { c0.f(new t(c0.b(SpecialProgramVariationAdapter.class), "items", "getItems()Ljava/util/List;")) };
    }

    public l(l.a aVar) {
        n.f(aVar, "callbacks");
        super();
        this.callbacks = aVar;
        List list = p.g();
        app.dogo.com.dogo_android.u.l.h delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ l.a getItemViewType(l position) {
        return position.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<TrickItem> getItemCount() {
        return (List)this.b.getValue(this, SpecialProgramVariationAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.u.l.b lOCKED_VARIATION2;
        i = (TrickItem)getItemCount().get(i).getLocked() ? SpecialProgramVariationAdapter_CellTypes.LOCKED_VARIATION : SpecialProgramVariationAdapter_CellTypes.VARIATION;
        return ((TrickItem)getItemCount().get(i).getLocked() ? SpecialProgramVariationAdapter_CellTypes.LOCKED_VARIATION : SpecialProgramVariationAdapter_CellTypes.VARIATION);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(l.c holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof SpecialProgramVariationAdapter_LockedVariationViewHolder) {
            (SpecialProgramVariationAdapter_LockedVariationViewHolder)holder.c().V((TrickItem)getItemCount().get(position));
        } else {
            if (holder instanceof SpecialProgramVariationAdapter_VariationViewHolder) {
                (SpecialProgramVariationAdapter_VariationViewHolder)holder.c().V((TrickItem)getItemCount().get(position));
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public l.c onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.u.l.e specialProgramVariationAdapter_VariationViewHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = app.dogo.com.dogo_android.specialprograms.l.f.a[SpecialProgramVariationAdapter_CellTypes.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                q7 q7Var = q7.T(from, parent, z);
                n.e(q7Var, str2);
                specialProgramVariationAdapter_VariationViewHolder = new SpecialProgramVariationAdapter_VariationViewHolder(this, q7Var);
                return specialProgramVariationAdapter_VariationViewHolder;
            }
        }
        o7 o7Var = o7.T(from, parent, z);
        n.e(o7Var, str2);
        app.dogo.com.dogo_android.u.l.d specialProgramVariationAdapter_LockedVariationViewHolder = new SpecialProgramVariationAdapter_LockedVariationViewHolder(this, o7Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, SpecialProgramVariationAdapter.c[0], list);
    }
}
