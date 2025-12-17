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
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u001b\u001c\u001d\u001eB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tricks", "getTricks", "()Ljava/util/List;", "setTricks", "(Ljava/util/List;)V", "tricks$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "LargeTrickHolder", "SmallTrickHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends RecyclerView.h<app.dogo.com.dogo_android.y.d0.n.b> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.y.d0.n.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "", "onItemSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void R(TrickItem trickItem);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$LargeTrickHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingLargeTrickBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingLargeTrickBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingLargeTrickBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.y.d0.n.b {

        private final i6 b;
        final app.dogo.com.dogo_android.y.d0.n c;
        public c(app.dogo.com.dogo_android.y.d0.n n, i6 i62) {
            n.f(n, "this$0");
            n.f(i62, "binding");
            this.c = n;
            super(i62);
            this.b = i62;
            f fVar = new f(n, this);
            i62.w().setOnClickListener(fVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.d0.n n, app.dogo.com.dogo_android.y.d0.n.c n$c2, View view3) {
            Object obj1;
            String obj2;
            n.f(n, "this$0");
            n.f(c2, "this$1");
            final app.dogo.com.dogo_android.y.d0.n.a obj0 = n.f(n);
            if (obj0 == null) {
            } else {
                obj1 = c2.c().T();
                n.d(obj1);
                n.e(obj1, "binding.trick!!");
                obj0.R(obj1);
            }
        }

        public static void d(app.dogo.com.dogo_android.y.d0.n n, app.dogo.com.dogo_android.y.d0.n.c n$c2, View view3) {
            n.c.b(n, c2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.d0.n$b
        public final i6 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$SmallTrickHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingSmallTrickBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingSmallTrickBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramTrainingSmallTrickBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.y.d0.n.b {

        private final k6 b;
        final app.dogo.com.dogo_android.y.d0.n c;
        public d(app.dogo.com.dogo_android.y.d0.n n, k6 k62) {
            n.f(n, "this$0");
            n.f(k62, "binding");
            this.c = n;
            super(k62);
            this.b = k62;
            g gVar = new g(n, this);
            k62.w().setOnClickListener(gVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.d0.n n, app.dogo.com.dogo_android.y.d0.n.d n$d2, View view3) {
            Object obj1;
            String obj2;
            n.f(n, "this$0");
            n.f(d2, "this$1");
            final app.dogo.com.dogo_android.y.d0.n.a obj0 = n.f(n);
            if (obj0 == null) {
            } else {
                obj1 = d2.c().T();
                n.d(obj1);
                n.e(obj1, "binding.trick!!");
                obj0.R(obj1);
            }
        }

        public static void d(app.dogo.com.dogo_android.y.d0.n n, app.dogo.com.dogo_android.y.d0.n.d n$d2, View view3) {
            n.d.b(n, d2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.d0.n$b
        public final k6 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends TrickItem>> {

        final Object a;
        final app.dogo.com.dogo_android.y.d0.n b;
        public e(Object object, Object object2, app.dogo.com.dogo_android.y.d0.n n3) {
            this.a = object;
            this.b = n3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends TrickItem> list2, List<? extends TrickItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.y.d0.n obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, n.f.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements p<TrickItem, TrickItem, Boolean> {

        public static final app.dogo.com.dogo_android.y.d0.n.f a;
        static {
            n.f fVar = new n.f();
            n.f.a = fVar;
        }

        f() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(TrickItem trickItem, TrickItem trickItem2) {
            n.f(trickItem, "o");
            n.f(trickItem2, "n");
            return n.b(trickItem.getId(), trickItem2.getId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((TrickItem)object, (TrickItem)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(n.class), "tricks", "getTricks()Ljava/util/List;");
        n.c = arr;
    }

    public n() {
        final int i = 0;
        super(i, 1, i);
    }

    public n(app.dogo.com.dogo_android.y.d0.n.a n$a) {
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        n.e eVar = new n.e(obj2, obj2, this);
        this.b = eVar;
    }

    public n(app.dogo.com.dogo_android.y.d0.n.a n$a, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.y.d0.n.a f(app.dogo.com.dogo_android.y.d0.n n) {
        return n.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<TrickItem> g() {
        return (List)this.b.getValue(this, n.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.y.d0.n.b n$b, int i2) {
        i6 i6Var;
        List list;
        Object obj4;
        n.f(b, "holder");
        if (b instanceof n.c) {
            (n.c)b.c().W((TrickItem)g().get(i2));
        } else {
            if (b instanceof n.d) {
                (n.d)b.c().W((TrickItem)g().get(i2));
            }
        }
        b.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.d0.n.b i(ViewGroup viewGroup, int i2) {
        int i;
        app.dogo.com.dogo_android.y.d0.n.b dVar;
        ViewDataBinding obj5;
        n.f(viewGroup, "parent");
        LayoutInflater obj6 = LayoutInflater.from(viewGroup.getContext());
        final int i3 = 0;
        final int i4 = 1;
        i = g().size() == i4 ? i4 : i3;
        final String str = "inflate(inflater, parent, false)";
        if (i == i4) {
            obj5 = i6.U(obj6, viewGroup, i3);
            n.e(obj5, str);
            dVar = new n.c(this, obj5);
            return dVar;
        } else {
            if (i != 0) {
            } else {
                obj5 = k6.U(obj6, viewGroup, i3);
                n.e(obj5, str);
                dVar = new n.d(this, obj5);
            }
        }
        obj5 = new NoWhenBranchMatchedException();
        throw obj5;
    }

    public final void j(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, n.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((n.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
