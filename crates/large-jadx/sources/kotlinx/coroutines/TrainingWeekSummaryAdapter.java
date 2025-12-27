package app.dogo.com.dogo_android.g;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.k1;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: TrainingWeekSummaryAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001\u001bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryCallback;", "(Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryCallback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c0, reason: from kotlin metadata */
public final class TrainingWeekSummaryAdapter extends RecyclerView.h<c0.a> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final d0 callback;
    private final c b = new c0$c();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDashboardWeekSumaryDayBinding;", "(Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryAdapter;Lapp/dogo/com/dogo_android/databinding/CellDashboardWeekSumaryDayBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDashboardWeekSumaryDayBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends RecyclerView.e0 {

        private final k1 a;
        public a(k1 k1Var) {
            n.f(c0Var, "this$0");
            n.f(k1Var, "binding");
            super(k1Var.w());
            this.a = k1Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final k1 a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class c extends b<List<? extends TrainingTimeMetrics.TrainingTimeDay>> {

        final /* synthetic */ Object a;
        final /* synthetic */ c0 b;
        public c(Object object, Object object2, c0 c0Var) {
            this.a = object;
            this.b = c0Var;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends TrainingTimeMetrics.TrainingTimeDay> oldValue, List<? extends TrainingTimeMetrics.TrainingTimeDay> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.c0.b.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.p<TrainingTimeMetrics.TrainingTimeDay, TrainingTimeMetrics.TrainingTimeDay, Boolean> {

        public static final c0.b a = new c0$b();
        @Override // kotlin.d0.d.p
        public final boolean a(TrainingTimeMetrics.TrainingTimeDay trainingTimeDay, TrainingTimeMetrics.TrainingTimeDay trainingTimeDay2) {
            n.f(trainingTimeDay, "o");
            n.f(trainingTimeDay2, "n");
            return n.b(trainingTimeDay.getDate(), trainingTimeDay2.getDate());
        }


        b() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        TrainingWeekSummaryAdapter.c = new l[] { c0.f(new t(c0.b(TrainingWeekSummaryAdapter.class), "list", "getList()Ljava/util/List;")) };
    }

    public c0(d0 d0Var) {
        n.f(d0Var, "callback");
        super();
        this.callback = d0Var;
        List list = p.g();
        app.dogo.com.dogo_android.g.c0.c delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: f, reason: from kotlin metadata */
    public final List<TrainingTimeMetrics.TrainingTimeDay> getItemCount() {
        return (List)this.b.getValue(this, TrainingWeekSummaryAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public void onBindViewHolder(c0.a holder, int position) {
        n.f(holder, "holder");
        holder.a().V((TrainingTimeMetrics_TrainingTimeDay)getItemCount().get(position));
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public c0.a onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final k1 k1Var = k1.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(k1Var, "inflate(inflater, parent, false)");
        return new TrainingWeekSummaryAdapter_Holder(this, k1Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void i(List<TrainingTimeMetrics.TrainingTimeDay> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, TrainingWeekSummaryAdapter.c[0], list);
    }
}
