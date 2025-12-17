package app.dogo.com.dogo_android.y.o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.a;
import app.dogo.com.dogo_android.h.am;
import app.dogo.com.dogo_android.h.cm;
import app.dogo.com.dogo_android.h.e4;
import app.dogo.com.dogo_android.h.g4;
import app.dogo.com.dogo_android.h.i4;
import app.dogo.com.dogo_android.h.k4;
import app.dogo.com.dogo_android.h.m4;
import app.dogo.com.dogo_android.h.o4;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
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
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\n !\"#$%&'()B#\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "isDogPremium", "", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Z)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AvailableHeaderHolder", "Callbacks", "CertificateHolder", "ExamHistoryCardHolder", "Holder", "LockedHolder", "PremiumLockedHolder", "ProgressHolder", "ReadyHolder", "UnavailableHeaderHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u extends RecyclerView.h<app.dogo.com.dogo_android.y.o.u.e> implements a {

    static final l<Object>[] e;
    private final app.dogo.com.dogo_android.y.o.u.b a;
    private final ProgramExamSummary b;
    private final boolean c;
    private final c d;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "", "listLoaded", "", "onCertificatePressed", "onExamHistoryPressed", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "isDogPremium", "", "onLockedItemPressed", "onPremiumLockedExamPressed", "onRecordExamPressed", "onShowExamVideoPressed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void E(ProgramExam programExam);

        public abstract void H0();

        public abstract void M0(ProgramExam programExam, boolean z2);

        public abstract void e1(ProgramExam programExam);

        public abstract void h();

        public abstract void i(ProgramExam programExam);

        public abstract void o0(ProgramExam programExam);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class k {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramExam.Status.LOCKED.ordinal()] = 1;
            iArr[ProgramExam.Status.READY.ordinal()] = 2;
            iArr[ProgramExam.Status.PREMIUM_LOCKED.ordinal()] = 3;
            iArr[ProgramExam.Status.PENDING.ordinal()] = 4;
            iArr[ProgramExam.Status.APPROVED.ordinal()] = 5;
            iArr[ProgramExam.Status.REJECTED.ordinal()] = 6;
            iArr[ProgramExam.Status.AVAILABLE_HEADER.ordinal()] = 7;
            iArr[ProgramExam.Status.UNAVAILABLE_HEADER.ordinal()] = 8;
            iArr[ProgramExam.Status.PROGRESS_HEADER.ordinal()] = 9;
            iArr[ProgramExam.Status.CERTIFICATE_HEADER.ordinal()] = 10;
            u.k.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class e extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public e(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$AvailableHeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamAvailableHeaderBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamAvailableHeaderBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamAvailableHeaderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends app.dogo.com.dogo_android.y.o.u.e {

        private final e4 b;
        public a(app.dogo.com.dogo_android.y.o.u u, e4 e42) {
            n.f(u, "this$0");
            n.f(e42, "binding");
            super(e42);
            this.b = e42;
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final e4 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$CertificateHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateCompletedBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateCompletedBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateCompletedBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.y.o.u.e {

        private final am b;
        final app.dogo.com.dogo_android.y.o.u c;
        public c(app.dogo.com.dogo_android.y.o.u u, am am2) {
            n.f(u, "this$0");
            n.f(am2, "binding");
            this.c = u;
            super(am2);
            this.b = am2;
            g gVar = new g(u);
            (Button)am2.w().findViewById(a.a).setOnClickListener(gVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.u u, View view2) {
            n.f(u, "this$0");
            final app.dogo.com.dogo_android.y.o.u.b obj0 = u.f(u);
            if (obj0 == null) {
            } else {
                obj0.H0();
            }
        }

        public static void d(app.dogo.com.dogo_android.y.o.u u, View view2) {
            u.c.b(u, view2);
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final am c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$ExamHistoryCardHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamPendingCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamPendingCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamPendingCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.y.o.u.e {

        private final i4 b;
        final app.dogo.com.dogo_android.y.o.u c;
        public d(app.dogo.com.dogo_android.y.o.u u, i4 i42) {
            n.f(u, "this$0");
            n.f(i42, "binding");
            this.c = u;
            super(i42);
            this.b = i42;
            i iVar = new i(u, this);
            i42.P.setOnClickListener(iVar);
            h hVar = new h(u, this);
            i42.O.setOnClickListener(hVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.d u$d2, View view3) {
            Object obj0;
            Object obj1;
            n.f(u, "this$0");
            n.f(d2, "this$1");
            app.dogo.com.dogo_android.y.o.u.b obj2 = u.f(u);
            if (obj2 == null) {
            } else {
                obj2.i((ProgramExam)u.h().get(d2.getAdapterPosition()));
            }
        }

        private static final void c(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.d u$d2, View view3) {
            List list;
            Object obj1;
            Object obj2;
            n.f(u, "this$0");
            n.f(d2, "this$1");
            app.dogo.com.dogo_android.y.o.u.b obj3 = u.f(u);
            if (obj3 == null) {
            } else {
                obj3.M0((ProgramExam)u.h().get(d2.getAdapterPosition()), u.g(u));
            }
        }

        public static void e(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.d u$d2, View view3) {
            u.d.c(u, d2, view3);
        }

        public static void f(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.d u$d2, View view3) {
            u.d.b(u, d2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final i4 d() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$LockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamLockedCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamLockedCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamLockedCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends app.dogo.com.dogo_android.y.o.u.e {

        private final g4 b;
        final app.dogo.com.dogo_android.y.o.u c;
        public f(app.dogo.com.dogo_android.y.o.u u, g4 g42) {
            n.f(u, "this$0");
            n.f(g42, "binding");
            this.c = u;
            super(g42);
            this.b = g42;
            j jVar = new j(u, this);
            g42.w().setOnClickListener(jVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.f u$f2, View view3) {
            Object obj0;
            Object obj1;
            n.f(u, "this$0");
            n.f(f2, "this$1");
            app.dogo.com.dogo_android.y.o.u.b obj2 = u.f(u);
            if (obj2 == null) {
            } else {
                obj2.e1((ProgramExam)u.h().get(f2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.f u$f2, View view3) {
            u.f.b(u, f2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final g4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$PremiumLockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamPremiumLockedBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamPremiumLockedBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamPremiumLockedBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class g extends app.dogo.com.dogo_android.y.o.u.e {

        private final k4 b;
        final app.dogo.com.dogo_android.y.o.u c;
        public g(app.dogo.com.dogo_android.y.o.u u, k4 k42) {
            n.f(u, "this$0");
            n.f(k42, "binding");
            this.c = u;
            super(k42);
            this.b = k42;
            k kVar = new k(u, this);
            k42.w().setOnClickListener(kVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.g u$g2, View view3) {
            Object obj0;
            Object obj1;
            n.f(u, "this$0");
            n.f(g2, "this$1");
            app.dogo.com.dogo_android.y.o.u.b obj2 = u.f(u);
            if (obj2 == null) {
            } else {
                obj2.E((ProgramExam)u.h().get(g2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.g u$g2, View view3) {
            u.g.b(u, g2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final k4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$ProgressHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateInProgressBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateInProgressBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateInProgressBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class h extends app.dogo.com.dogo_android.y.o.u.e {

        private final cm b;
        final app.dogo.com.dogo_android.y.o.u c;
        public h(app.dogo.com.dogo_android.y.o.u u, cm cm2) {
            n.f(u, "this$0");
            n.f(cm2, "binding");
            this.c = u;
            super(cm2);
            this.b = cm2;
            l lVar = new l(u);
            cm2.w().setOnClickListener(lVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.u u, View view2) {
            n.f(u, "this$0");
            final app.dogo.com.dogo_android.y.o.u.b obj0 = u.f(u);
            if (obj0 == null) {
            } else {
                obj0.H0();
            }
        }

        public static void d(app.dogo.com.dogo_android.y.o.u u, View view2) {
            u.h.b(u, view2);
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final cm c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$ReadyHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamReadyCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamReadyCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamReadyCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class i extends app.dogo.com.dogo_android.y.o.u.e {

        private final m4 b;
        final app.dogo.com.dogo_android.y.o.u c;
        public i(app.dogo.com.dogo_android.y.o.u u, m4 m42) {
            n.f(u, "this$0");
            n.f(m42, "binding");
            this.c = u;
            super(m42);
            this.b = m42;
            m mVar = new m(u, this);
            m42.w().setOnClickListener(mVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.i u$i2, View view3) {
            Object obj0;
            Object obj1;
            n.f(u, "this$0");
            n.f(i2, "this$1");
            app.dogo.com.dogo_android.y.o.u.b obj2 = u.f(u);
            if (obj2 == null) {
            } else {
                obj2.o0((ProgramExam)u.h().get(i2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.i u$i2, View view3) {
            u.i.b(u, i2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final m4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$UnavailableHeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamUnavailableHeaderBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamUnavailableHeaderBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamUnavailableHeaderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class j extends app.dogo.com.dogo_android.y.o.u.e {
        public j(app.dogo.com.dogo_android.y.o.u u, o4 o42) {
            n.f(u, "this$0");
            n.f(o42, "binding");
            super(o42);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class m extends b<List<? extends ProgramExam>> {

        final Object a;
        final app.dogo.com.dogo_android.y.o.u b;
        public m(Object object, Object object2, app.dogo.com.dogo_android.y.o.u u3) {
            this.a = object;
            this.b = u3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends ProgramExam> list2, List<? extends ProgramExam> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.y.o.u obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, u.l.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class l extends p implements p<ProgramExam, ProgramExam, Boolean> {

        public static final app.dogo.com.dogo_android.y.o.u.l a;
        static {
            u.l lVar = new u.l();
            u.l.a = lVar;
        }

        l() {
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
        t tVar = new t(c0.b(u.class), "list", "getList()Ljava/util/List;");
        u.e = arr;
    }

    public u(app.dogo.com.dogo_android.y.o.u.b u$b, ProgramExamSummary programExamSummary2, boolean z3) {
        super();
        this.a = b;
        this.b = programExamSummary2;
        this.c = z3;
        a obj1 = a.a;
        obj1 = p.g();
        u.m obj2 = new u.m(obj1, obj1, this);
        this.d = obj2;
    }

    public static final app.dogo.com.dogo_android.y.o.u.b f(app.dogo.com.dogo_android.y.o.u u) {
        return u.a;
    }

    public static final boolean g(app.dogo.com.dogo_android.y.o.u u) {
        return u.c;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return h().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramExam)h().get(i).getStatus().ordinal();
    }

    public final List<ProgramExam> h() {
        return (List)this.d.getValue(this, u.e[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void i(app.dogo.com.dogo_android.y.o.u.e u$e, int i2) {
        g4 valueOf;
        List list;
        Object obj4;
        n.f(e, "holder");
        if (e instanceof u.f) {
            (u.f)e.c().V((ProgramExam)h().get(i2));
        } else {
            if (e instanceof u.i) {
                (u.i)e.c().V((ProgramExam)h().get(i2));
            } else {
                if (e instanceof u.d) {
                    (u.d)e.d().V((ProgramExam)h().get(i2));
                } else {
                    if (e instanceof u.g) {
                        (u.g)e.c().V((ProgramExam)h().get(i2));
                    } else {
                        if (e instanceof u.h) {
                            (u.h)e.c().V(this.b);
                        } else {
                            if (e instanceof u.c) {
                                (u.c)e.c().V(this.b);
                            } else {
                                if (e instanceof u.a) {
                                    (u.a)e.b().V(Boolean.valueOf(this.c));
                                }
                            }
                        }
                    }
                }
            }
        }
        e.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.o.u.e j(ViewGroup viewGroup, int i2) {
        ViewDataBinding obj4;
        app.dogo.com.dogo_android.y.o.u.e obj5;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        String str2 = "inflate(inflater, parent, false)";
        final int i = 0;
        switch (obj5) {
            case 1:
                obj4 = g4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.f(this, obj4);
                break;
            case 2:
                obj4 = m4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.i(this, obj4);
                break;
            case 3:
                obj4 = k4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.g(this, obj4);
                break;
            case 4:
                obj4 = i4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.d(this, obj4);
                break;
            case 5:
                obj4 = i4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.d(this, obj4);
                break;
            case 6:
                obj4 = i4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.d(this, obj4);
                break;
            case 7:
                obj4 = e4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.a(this, obj4);
                break;
            case 8:
                obj4 = o4.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.j(this, obj4);
                break;
            case 9:
                obj4 = cm.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.h(this, obj4);
                break;
            case 10:
                obj4 = am.T(from, viewGroup, i);
                n.e(obj4, str2);
                obj5 = new u.c(this, obj4);
                break;
            default:
                obj4 = new NoWhenBranchMatchedException();
                throw obj4;
        }
        return obj5;
    }

    public final void l(List<ProgramExam> list) {
        n.f(list, "<set-?>");
        this.d.setValue(this, u.e[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        i((u.e)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return j(viewGroup, i2);
    }
}
