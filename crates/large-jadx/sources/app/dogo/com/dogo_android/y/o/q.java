package app.dogo.com.dogo_android.y.o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.m2;
import app.dogo.com.dogo_android.h.o2;
import app.dogo.com.dogo_android.h.y1;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "EmptyHolder", "HistoryHolder", "Holder", "PendingHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q extends RecyclerView.h<app.dogo.com.dogo_android.y.o.q.d> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.y.o.q.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "", "onLeaveFeedbackPressed", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "onRetakeExamPressed", "onShowExamVideoPressed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void i(ProgramExam programExam);

        public abstract void l1(ProgramExam programExam);

        public abstract void q1(ProgramExam programExam);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramExam.Status.PENDING.ordinal()] = 1;
            iArr[ProgramExam.Status.APPROVED.ordinal()] = 2;
            iArr[ProgramExam.Status.REJECTED.ordinal()] = 3;
            q.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$EmptyHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.y.o.q.d {
        public b(app.dogo.com.dogo_android.y.o.q q, y1 y12) {
            n.f(q, "this$0");
            n.f(y12, "binding");
            super(y12);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$HistoryHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellExamHistoryBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;Lapp/dogo/com/dogo_android/databinding/CellExamHistoryBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellExamHistoryBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.y.o.q.d {

        private final m2 b;
        final app.dogo.com.dogo_android.y.o.q c;
        public c(app.dogo.com.dogo_android.y.o.q q, m2 m22) {
            n.f(q, "this$0");
            n.f(m22, "binding");
            this.c = q;
            super(m22);
            this.b = m22;
            a aVar = new a(q, this);
            m22.W.setOnClickListener(aVar);
            b bVar = new b(q, this);
            m22.P.setOnClickListener(bVar);
            c cVar = new c(q, this);
            m22.V.setOnClickListener(cVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.c q$c2, View view3) {
            Object obj0;
            Object obj1;
            n.f(q, "this$0");
            n.f(c2, "this$1");
            app.dogo.com.dogo_android.y.o.q.a obj2 = q.f(q);
            if (obj2 == null) {
            } else {
                obj2.l1((ProgramExam)q.g().get(c2.getAdapterPosition()));
            }
        }

        private static final void c(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.c q$c2, View view3) {
            Object obj0;
            Object obj1;
            n.f(q, "this$0");
            n.f(c2, "this$1");
            app.dogo.com.dogo_android.y.o.q.a obj2 = q.f(q);
            if (obj2 == null) {
            } else {
                obj2.i((ProgramExam)q.g().get(c2.getAdapterPosition()));
            }
        }

        private static final void d(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.c q$c2, View view3) {
            n.f(q, "this$0");
            n.f(c2, "this$1");
            Object obj3 = q.g().get(c2.getAdapterPosition());
            (ProgramExam)obj3.setUserFeedbackSubmitted(true);
            q.notifyItemChanged(c2.getAdapterPosition());
            final app.dogo.com.dogo_android.y.o.q.a obj1 = q.f(q);
            if (obj1 == null) {
            } else {
                obj1.q1(obj3);
            }
        }

        public static void f(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.c q$c2, View view3) {
            q.c.b(q, c2, view3);
        }

        public static void g(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.c q$c2, View view3) {
            q.c.c(q, c2, view3);
        }

        public static void h(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.c q$c2, View view3) {
            q.c.d(q, c2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.o.q$d
        public final m2 e() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$PendingHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellExamHistoryPendingBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;Lapp/dogo/com/dogo_android/databinding/CellExamHistoryPendingBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellExamHistoryPendingBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.y.o.q.d {

        private final o2 b;
        final app.dogo.com.dogo_android.y.o.q c;
        public e(app.dogo.com.dogo_android.y.o.q q, o2 o22) {
            n.f(q, "this$0");
            n.f(o22, "binding");
            this.c = q;
            super(o22);
            this.b = o22;
            d dVar = new d(q, this);
            o22.w().setOnClickListener(dVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.e q$e2, View view3) {
            Object obj0;
            Object obj1;
            n.f(q, "this$0");
            n.f(e2, "this$1");
            app.dogo.com.dogo_android.y.o.q.a obj2 = q.f(q);
            if (obj2 == null) {
            } else {
                obj2.i((ProgramExam)q.g().get(e2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.e q$e2, View view3) {
            q.e.b(q, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.o.q$d
        public final o2 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends ProgramExam>> {

        final Object a;
        final app.dogo.com.dogo_android.y.o.q b;
        public h(Object object, Object object2, app.dogo.com.dogo_android.y.o.q q3) {
            this.a = object;
            this.b = q3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends ProgramExam> list2, List<? extends ProgramExam> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.y.o.q obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, q.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements p<ProgramExam, ProgramExam, Boolean> {

        public static final app.dogo.com.dogo_android.y.o.q.g a;
        static {
            q.g gVar = new q.g();
            q.g.a = gVar;
        }

        g() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(ProgramExam programExam, ProgramExam programExam2) {
            Object obj3;
            Object obj4;
            n.f(programExam, "o");
            n.f(programExam2, "n");
            if (n.b(programExam.getTrickId(), programExam2.getTrickId()) && programExam.getStatus() == programExam2.getStatus()) {
                obj3 = programExam.getStatus() == programExam2.getStatus() ? 1 : 0;
            } else {
            }
            return obj3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((ProgramExam)object, (ProgramExam)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(q.class), "list", "getList()Ljava/util/List;");
        q.c = arr;
    }

    public q() {
        final int i = 0;
        super(i, 1, i);
    }

    public q(app.dogo.com.dogo_android.y.o.q.a q$a) {
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        q.h hVar = new q.h(obj2, obj2, this);
        this.b = hVar;
    }

    public q(app.dogo.com.dogo_android.y.o.q.a q$a, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.y.o.q.a f(app.dogo.com.dogo_android.y.o.q q) {
        return q.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<ProgramExam> g() {
        return (List)this.b.getValue(this, q.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramExam)g().get(i).getStatus().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.y.o.q.d q$d, int i2) {
        o2 o2Var;
        List list;
        Object obj4;
        n.f(d, "holder");
        if (d instanceof q.e) {
            (q.e)d.c().V((ProgramExam)g().get(i2));
        } else {
            if (d instanceof q.c) {
                (q.c)d.e().V((ProgramExam)g().get(i2));
            }
        }
        d.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.o.q.d i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.y.o.q.d obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = q.f.a[ProgramExam.Status.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
                if (obj6 != 3) {
                    obj5 = y1.T(from, viewGroup, i3);
                    n.e(obj5, str2);
                    obj6 = new q.b(this, obj5);
                } else {
                    obj5 = m2.T(from, viewGroup, i3);
                    n.e(obj5, str2);
                    obj6 = new q.c(this, obj5);
                }
            } else {
                obj5 = m2.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new q.c(this, obj5);
            }
        } else {
            obj5 = o2.T(from, viewGroup, i3);
            n.e(obj5, str2);
            obj6 = new q.e(this, obj5);
        }
        return obj6;
    }

    public final void j(List<ProgramExam> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, q.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((q.d)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
