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
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: LessonExamHistoryAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "EmptyHolder", "HistoryHolder", "Holder", "PendingHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q, reason: from kotlin metadata */
public final class LessonExamHistoryAdapter extends RecyclerView.h<q.d> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final q.a callbacks;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "", "onLeaveFeedbackPressed", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "onRetakeExamPressed", "onShowExamVideoPressed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: i, reason: from kotlin metadata */
        void onLeaveFeedbackPressed(ProgramExam item);

        /* renamed from: l1, reason: from kotlin metadata */
        void onRetakeExamPressed(ProgramExam item);

        /* renamed from: q1, reason: from kotlin metadata */
        void onShowExamVideoPressed(ProgramExam item);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramExam_Status.values().length];
            iArr[ProgramExam_Status.PENDING.ordinal()] = 1;
            iArr[ProgramExam_Status.APPROVED.ordinal()] = 2;
            iArr[ProgramExam_Status.REJECTED.ordinal()] = 3;
            kotlinx.coroutines.q.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class d extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public d(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$EmptyHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends q.d {
        public b(y1 y1Var) {
            n.f(qVar, "this$0");
            n.f(y1Var, "binding");
            super(y1Var);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$HistoryHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellExamHistoryBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;Lapp/dogo/com/dogo_android/databinding/CellExamHistoryBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellExamHistoryBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends q.d {

        private final m2 b;
        final /* synthetic */ q c;
        public c(m2 m2Var) {
            n.f(qVar, "this$0");
            n.f(m2Var, "binding");
            this.c = qVar;
            super(m2Var);
            this.b = m2Var;
            m2Var.W.setOnClickListener(new kotlinx.coroutines.a(qVar, this));
            m2Var.P.setOnClickListener(new kotlinx.coroutines.b(qVar, this));
            m2Var.V.setOnClickListener(new kotlinx.coroutines.c(qVar, this));
        }

        private static final void b(q qVar, q.c cVar, View view) {
            n.f(qVar, "this$0");
            n.f(cVar, "this$1");
            app.dogo.com.dogo_android.y.o.q.a itemViewType = qVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onRetakeExamPressed((ProgramExam)qVar.getItemCount().get(cVar.getAdapterPosition()));
            }
        }

        private static final void c(q qVar, q.c cVar, View view) {
            n.f(qVar, "this$0");
            n.f(cVar, "this$1");
            app.dogo.com.dogo_android.y.o.q.a itemViewType = qVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onLeaveFeedbackPressed((ProgramExam)qVar.getItemCount().get(cVar.getAdapterPosition()));
            }
        }

        private static final void d(q qVar, q.c cVar, View view) {
            n.f(qVar, "this$0");
            n.f(cVar, "this$1");
            Object item = qVar.getItemCount().get(cVar.getAdapterPosition());
            item.setUserFeedbackSubmitted(true);
            qVar.notifyItemChanged(cVar.getAdapterPosition());
            final app.dogo.com.dogo_android.y.o.q.a itemViewType = qVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onShowExamVideoPressed(item);
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.q$d
        public final m2 e() {
            return this.b;
        }

        public static /* synthetic */ void f(q qVar, q.c cVar, View view) {
            LessonExamHistoryAdapter_HistoryHolder.b(qVar, cVar, view);
        }

        public static /* synthetic */ void g(q qVar, q.c cVar, View view) {
            LessonExamHistoryAdapter_HistoryHolder.c(qVar, cVar, view);
        }

        public static /* synthetic */ void h(q qVar, q.c cVar, View view) {
            LessonExamHistoryAdapter_HistoryHolder.d(qVar, cVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$PendingHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellExamHistoryPendingBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter;Lapp/dogo/com/dogo_android/databinding/CellExamHistoryPendingBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellExamHistoryPendingBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends q.d {

        private final o2 b;
        final /* synthetic */ q c;
        public e(o2 o2Var) {
            n.f(qVar, "this$0");
            n.f(o2Var, "binding");
            this.c = qVar;
            super(o2Var);
            this.b = o2Var;
            o2Var.w().setOnClickListener(new kotlinx.coroutines.d(qVar, this));
        }

        private static final void b(q qVar, q.e eVar, View view) {
            n.f(qVar, "this$0");
            n.f(eVar, "this$1");
            app.dogo.com.dogo_android.y.o.q.a itemViewType = qVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onLeaveFeedbackPressed((ProgramExam)qVar.getItemCount().get(eVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.q$d
        public final o2 c() {
            return this.b;
        }

        public static /* synthetic */ void d(q qVar, q.e eVar, View view) {
            LessonExamHistoryAdapter_PendingHolder.b(qVar, eVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends ProgramExam>> {

        final /* synthetic */ Object a;
        final /* synthetic */ q b;
        public h(Object object, Object object2, q qVar) {
            this.a = object;
            this.b = qVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends ProgramExam> oldValue, List<? extends ProgramExam> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.q.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.p<ProgramExam, ProgramExam, Boolean> {

        public static final q.g a = new q$g();
        @Override // kotlin.d0.d.p
        public final boolean a(ProgramExam programExam, ProgramExam programExam2) {
            boolean z2 = false;
            ProgramExam.Status status2;
            n.f(programExam, "o");
            n.f(programExam2, "n");
            if (n.b(programExam.getTrickId(), programExam2.getTrickId())) {
                programExam = programExam.getStatus() == programExam2.getStatus() ? 1 : 0;
            }
            return (programExam.getStatus() == programExam2.getStatus() ? 1 : 0);
        }


        g() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        LessonExamHistoryAdapter.c = new l[] { c0.f(new t(c0.b(LessonExamHistoryAdapter.class), "list", "getList()Ljava/util/List;")) };
    }

    public /* synthetic */ q(q.a aVar, int i, g gVar) {
        app.dogo.com.dogo_android.y.o.q.a aVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(aVar2);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ q.a getItemViewType(q position) {
        return position.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<ProgramExam> getItemCount() {
        return (List)this.b.getValue(this, LessonExamHistoryAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramExam)getItemCount().get(i).getStatus().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(q.d holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof LessonExamHistoryAdapter_PendingHolder) {
            (LessonExamHistoryAdapter_PendingHolder)holder.c().V((ProgramExam)getItemCount().get(position));
        } else {
            if (holder instanceof LessonExamHistoryAdapter_HistoryHolder) {
                (LessonExamHistoryAdapter_HistoryHolder)holder.e().V((ProgramExam)getItemCount().get(position));
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public q.d onCreateViewHolder(ViewGroup parent, int viewType) {
        app.dogo.com.dogo_android.y.o.q.e lessonExamHistoryAdapter_PendingHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = kotlinx.coroutines.q.f.a[ProgramExam_Status.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 == 1) {
            o2 o2Var = o2.T(from, parent, z);
            n.e(o2Var, str2);
            lessonExamHistoryAdapter_PendingHolder = new LessonExamHistoryAdapter_PendingHolder(this, o2Var);
        } else {
            i = 2;
            if (i2 == 2) {
                m2 m2Var2 = m2.T(from, parent, z);
                n.e(m2Var2, str2);
                app.dogo.com.dogo_android.y.o.q.c lessonExamHistoryAdapter_HistoryHolder2 = new LessonExamHistoryAdapter_HistoryHolder(this, m2Var2);
            } else {
                i = 3;
                if (i2 != 3) {
                    y1 y1Var = y1.T(from, parent, z);
                    n.e(y1Var, str2);
                    app.dogo.com.dogo_android.y.o.q.b lessonExamHistoryAdapter_EmptyHolder = new LessonExamHistoryAdapter_EmptyHolder(this, y1Var);
                } else {
                    m2 m2Var = m2.T(from, parent, z);
                    n.e(m2Var, str2);
                    app.dogo.com.dogo_android.y.o.q.c lessonExamHistoryAdapter_HistoryHolder = new LessonExamHistoryAdapter_HistoryHolder(this, m2Var);
                }
            }
        }
        return lessonExamHistoryAdapter_PendingHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<ProgramExam> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, LessonExamHistoryAdapter.c[0], list);
    }

    public q(q.a aVar) {
        super();
        this.callbacks = aVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public q() {
        final app.dogo.com.dogo_android.y.o.q.a aVar = null;
        this(aVar, 1, aVar);
    }
}
