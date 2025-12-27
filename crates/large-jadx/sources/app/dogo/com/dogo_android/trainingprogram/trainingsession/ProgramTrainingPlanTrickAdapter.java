package app.dogo.com.dogo_android.y.d0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.i6;
import app.dogo.com.dogo_android.h.k6;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: ProgramTrainingPlanTrickAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u001b\u001c\u001d\u001eB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tricks", "getTricks", "()Ljava/util/List;", "setTricks", "(Ljava/util/List;)V", "tricks$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "LargeTrickHolder", "SmallTrickHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class ProgramTrainingPlanTrickAdapter extends RecyclerView.h<n.b> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final n.a callbacks;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "", "onItemSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: R, reason: from kotlin metadata */
        void onItemSelected(TrickItem item);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$LargeTrickHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingLargeTrickBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingLargeTrickBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingLargeTrickBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends n.b {

        private final i6 b;
        final /* synthetic */ n c;
        public c(i6 i6Var) {
            n.f(nVar, "this$0");
            n.f(i6Var, "binding");
            this.c = nVar;
            super(i6Var);
            this.b = i6Var;
            i6Var.w().setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.trainingsession.f(nVar, this));
        }

        private static final void b(n nVar, n.c cVar, View view) {
            n.f(nVar, "this$0");
            str = "this$1";
            n.f(cVar, str);
            final app.dogo.com.dogo_android.y.d0.n.a aVar = nVar.callbacks;
            if (aVar != null) {
                TrickItem trickItem = cVar.c().T();
                n.d(trickItem);
                str = "binding.trick!!";
                n.e(trickItem, str);
                aVar.onItemSelected(trickItem);
            }
        }

        @Override // app.dogo.com.dogo_android.y.d0.n$b
        public final i6 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n nVar, n.c cVar, View view) {
            ProgramTrainingPlanTrickAdapter_LargeTrickHolder.b(nVar, cVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$SmallTrickHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingSmallTrickBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingSmallTrickBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingSmallTrickBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends n.b {

        private final k6 b;
        final /* synthetic */ n c;
        public d(k6 k6Var) {
            n.f(nVar, "this$0");
            n.f(k6Var, "binding");
            this.c = nVar;
            super(k6Var);
            this.b = k6Var;
            k6Var.w().setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.trainingsession.g(nVar, this));
        }

        private static final void b(n nVar, n.d dVar, View view) {
            n.f(nVar, "this$0");
            str = "this$1";
            n.f(dVar, str);
            final app.dogo.com.dogo_android.y.d0.n.a aVar = nVar.callbacks;
            if (aVar != null) {
                TrickItem trickItem = dVar.c().T();
                n.d(trickItem);
                str = "binding.trick!!";
                n.e(trickItem, str);
                aVar.onItemSelected(trickItem);
            }
        }

        @Override // app.dogo.com.dogo_android.y.d0.n$b
        public final k6 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n nVar, n.d dVar, View view) {
            ProgramTrainingPlanTrickAdapter_SmallTrickHolder.b(nVar, dVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends TrickItem>> {

        final /* synthetic */ Object a;
        final /* synthetic */ n b;
        public e(Object object, Object object2, n nVar) {
            this.a = object;
            this.b = nVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends TrickItem> oldValue, List<? extends TrickItem> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.trainingprogram.trainingsession.n.f.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.p<TrickItem, TrickItem, Boolean> {

        public static final n.f a = new n$f();
        @Override // kotlin.d0.d.p
        public final boolean a(TrickItem trickItem, TrickItem trickItem2) {
            n.f(trickItem, "o");
            n.f(trickItem2, "n");
            return n.b(trickItem.getId(), trickItem2.getId());
        }


        f() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        ProgramTrainingPlanTrickAdapter.c = new l[] { c0.f(new t(c0.b(ProgramTrainingPlanTrickAdapter.class), "tricks", "getTricks()Ljava/util/List;")) };
    }

    public n(n.a aVar) {
        super();
        this.callbacks = aVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public static final /* synthetic */ n.a f(n nVar) {
        return nVar.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<TrickItem> getItemCount() {
        return (List)this.b.getValue(this, ProgramTrainingPlanTrickAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(n.b holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof ProgramTrainingPlanTrickAdapter_LargeTrickHolder) {
            (ProgramTrainingPlanTrickAdapter_LargeTrickHolder)holder.c().W((TrickItem)getItemCount().get(position));
        } else {
            if (holder instanceof ProgramTrainingPlanTrickAdapter_SmallTrickHolder) {
                (ProgramTrainingPlanTrickAdapter_SmallTrickHolder)holder.c().W((TrickItem)getItemCount().get(position));
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public n.b onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        int i;
        app.dogo.com.dogo_android.y.d0.n.d programTrainingPlanTrickAdapter_SmallTrickHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        final boolean z = false;
        i = 1;
        int r0 = getItemCount().size() == i ? i : z;
        final String str = "inflate(inflater, parent, false)";
        if (i == i) {
            i6 i6Var = i6.U(from, parent, z);
            n.e(i6Var, str);
            app.dogo.com.dogo_android.y.d0.n.c programTrainingPlanTrickAdapter_LargeTrickHolder = new ProgramTrainingPlanTrickAdapter_LargeTrickHolder(this, i6Var);
            return programTrainingPlanTrickAdapter_SmallTrickHolder;
        } else {
            if (i == 0) {
                k6 k6Var = k6.U(from, parent, z);
                n.e(k6Var, str);
                programTrainingPlanTrickAdapter_SmallTrickHolder = new ProgramTrainingPlanTrickAdapter_SmallTrickHolder(this, k6Var);
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, ProgramTrainingPlanTrickAdapter.c[0], list);
    }

    public /* synthetic */ n(n.a aVar, int i, g gVar) {
        app.dogo.com.dogo_android.y.d0.n.a aVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(aVar2);
    }

    public n() {
        final app.dogo.com.dogo_android.y.d0.n.a aVar = null;
        this(aVar, 1, aVar);
    }
}
