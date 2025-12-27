package app.dogo.com.dogo_android.u;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.k7;
import app.dogo.com.dogo_android.h.m7;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: SpecialProgramExercisesAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BasicTrickHolder", "Callback", "CellTypes", "DefaultViewHolder", "TrickWithVariationHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class SpecialProgramExercisesAdapter extends RecyclerView.h<i.d> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final j callbacks;
    private final c b = new i$h();

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$Callback;", "", "onCoreTrickSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: N, reason: from kotlin metadata */
        void onCoreTrickSelected(TrickItem item);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$CellTypes;", "", "(Ljava/lang/String;I)V", "TRICK_WITH_VARIATION", "BASIC_TRICK", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private enum c {

        BASIC_TRICK,
        TRICK_WITH_VARIATION;
        private static final /* synthetic */ i.c[] $values() {
            app.dogo.com.dogo_android.u.i.c[] arr = new i.c[2];
            return new i.c[] { SpecialProgramExercisesAdapter_CellTypes.TRICK_WITH_VARIATION, SpecialProgramExercisesAdapter_CellTypes.BASIC_TRICK };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[SpecialProgramExercisesAdapter_CellTypes.values().length];
            iArr[SpecialProgramExercisesAdapter_CellTypes.TRICK_WITH_VARIATION.ordinal()] = 1;
            iArr[SpecialProgramExercisesAdapter_CellTypes.BASIC_TRICK.ordinal()] = 2;
            app.dogo.com.dogo_android.specialprograms.i.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class d extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding binding;
        public d(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "binding");
            super(viewDataBinding.w());
            this.binding = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.binding;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$BasicTrickHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends i.d {

        private final k7 b;
        final /* synthetic */ i c;
        public a(k7 k7Var) {
            n.f(iVar, "this$0");
            n.f(k7Var, "bind");
            this.c = iVar;
            super(k7Var);
            this.b = k7Var;
            k7Var.O.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.b(iVar, this));
        }

        private static final void b(i iVar, i.a aVar, View view) {
            n.f(iVar, "this$0");
            n.f(aVar, "this$1");
            iVar.callbacks.onCoreTrickSelected((TrickItemWithVariations)iVar.getItemCount().get(aVar.getAdapterPosition()).getCoreTrick());
        }

        @Override // app.dogo.com.dogo_android.u.i$d
        public final k7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, i.a aVar, View view) {
            SpecialProgramExercisesAdapter_BasicTrickHolder.b(iVar, aVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$TrickWithVariationHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseWithVariationsBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseWithVariationsBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseWithVariationsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends i.d {

        private final m7 b;
        final /* synthetic */ i c;
        public e(m7 m7Var) {
            n.f(iVar, "this$0");
            n.f(m7Var, "bind");
            this.c = iVar;
            super(m7Var);
            this.b = m7Var;
            m7Var.Q.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.c(iVar, this));
        }

        private static final void b(i iVar, i.e eVar, View view) {
            n.f(iVar, "this$0");
            n.f(eVar, "this$1");
            iVar.callbacks.onCoreTrickSelected((TrickItemWithVariations)iVar.getItemCount().get(eVar.getAdapterPosition()).getCoreTrick());
        }

        @Override // app.dogo.com.dogo_android.u.i$d
        public final m7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, i.e eVar, View view) {
            SpecialProgramExercisesAdapter_TrickWithVariationHolder.b(iVar, eVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends TrickItemWithVariations>> {

        final /* synthetic */ Object a;
        final /* synthetic */ i b;
        public h(Object object, Object object2, i iVar) {
            this.a = object;
            this.b = iVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends TrickItemWithVariations> oldValue, List<? extends TrickItemWithVariations> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.specialprograms.i.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.p<TrickItemWithVariations, TrickItemWithVariations, Boolean> {

        public static final i.g a = new i$g();
        @Override // kotlin.d0.d.p
        public final boolean a(TrickItemWithVariations trickItemWithVariations, TrickItemWithVariations trickItemWithVariations2) {
            n.f(trickItemWithVariations, "o");
            n.f(trickItemWithVariations2, "n");
            return n.b(trickItemWithVariations.getCoreTrick().getId(), trickItemWithVariations2.getCoreTrick().getId());
        }


        g() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        SpecialProgramExercisesAdapter.c = new l[] { c0.f(new t(c0.b(SpecialProgramExercisesAdapter.class), "items", "getItems()Ljava/util/List;")) };
    }

    public i(j jVar) {
        n.f(jVar, "callbacks");
        super();
        this.callbacks = jVar;
        List list = p.g();
        app.dogo.com.dogo_android.u.i.h delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ j getItemViewType(i position) {
        return position.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<TrickItemWithVariations> getItemCount() {
        return (List)this.b.getValue(this, SpecialProgramExercisesAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.u.i.c tRICK_WITH_VARIATION2;
        i = !(TrickItemWithVariations)getItemCount().get(i).getVariations().isEmpty() ? SpecialProgramExercisesAdapter_CellTypes.TRICK_WITH_VARIATION : SpecialProgramExercisesAdapter_CellTypes.BASIC_TRICK;
        return (!(TrickItemWithVariations)getItemCount().get(i).getVariations().isEmpty() ? SpecialProgramExercisesAdapter_CellTypes.TRICK_WITH_VARIATION : SpecialProgramExercisesAdapter_CellTypes.BASIC_TRICK);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(i.d holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof SpecialProgramExercisesAdapter_TrickWithVariationHolder) {
            Object holder2 = holder;
            holder2.c().W((TrickItemWithVariations)getItemCount().get(position));
            holder2.c().V(this.callbacks);
        } else {
            if (holder instanceof SpecialProgramExercisesAdapter_BasicTrickHolder) {
                (SpecialProgramExercisesAdapter_BasicTrickHolder)holder.c().V((TrickItemWithVariations)getItemCount().get(position).getCoreTrick());
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public i.d onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.u.i.a specialProgramExercisesAdapter_BasicTrickHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = app.dogo.com.dogo_android.specialprograms.i.f.a[SpecialProgramExercisesAdapter_CellTypes.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                k7 k7Var = k7.T(from, parent, z);
                n.e(k7Var, str2);
                specialProgramExercisesAdapter_BasicTrickHolder = new SpecialProgramExercisesAdapter_BasicTrickHolder(this, k7Var);
                return specialProgramExercisesAdapter_BasicTrickHolder;
            }
        }
        m7 m7Var = m7.T(from, parent, z);
        n.e(m7Var, str2);
        app.dogo.com.dogo_android.u.i.e specialProgramExercisesAdapter_TrickWithVariationHolder = new SpecialProgramExercisesAdapter_TrickWithVariationHolder(this, m7Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<TrickItemWithVariations> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, SpecialProgramExercisesAdapter.c[0], list);
    }
}
