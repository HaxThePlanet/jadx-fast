package app.dogo.com.dogo_android.y.o;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
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

/* compiled from: LessonExamListAdapter.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\n !\"#$%&'()B#\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "isDogPremium", "", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Z)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AvailableHeaderHolder", "Callbacks", "CertificateHolder", "ExamHistoryCardHolder", "Holder", "LockedHolder", "PremiumLockedHolder", "ProgressHolder", "ReadyHolder", "UnavailableHeaderHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u, reason: from kotlin metadata */
public final class LessonExamListAdapter extends RecyclerView.h<u.e> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] e;
    /* renamed from: a, reason: from kotlin metadata */
    private final u.b callbacks;
    /* renamed from: b, reason: from kotlin metadata */
    private final ProgramExamSummary isDogPremium;
    private final boolean c;
    /* renamed from: d, reason: from kotlin metadata */
    private final c programExamSummary = new u$m();

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "", "listLoaded", "", "onCertificatePressed", "onExamHistoryPressed", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "isDogPremium", "", "onLockedItemPressed", "onPremiumLockedExamPressed", "onRecordExamPressed", "onShowExamVideoPressed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: E, reason: from kotlin metadata */
        void onLockedItemPressed(ProgramExam item);

        /* renamed from: H0, reason: from kotlin metadata */
        void listLoaded();

        /* renamed from: M0, reason: from kotlin metadata */
        void onExamHistoryPressed(ProgramExam item, boolean isDogPremium);

        /* renamed from: e1, reason: from kotlin metadata */
        void onPremiumLockedExamPressed(ProgramExam item);

        void h();

        /* renamed from: i, reason: from kotlin metadata */
        void onRecordExamPressed(ProgramExam item);

        /* renamed from: o0, reason: from kotlin metadata */
        void onShowExamVideoPressed(ProgramExam item);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class k {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramExam_Status.values().length];
            iArr[ProgramExam_Status.LOCKED.ordinal()] = 1;
            iArr[ProgramExam_Status.READY.ordinal()] = 2;
            iArr[ProgramExam_Status.PREMIUM_LOCKED.ordinal()] = 3;
            iArr[ProgramExam_Status.PENDING.ordinal()] = 4;
            iArr[ProgramExam_Status.APPROVED.ordinal()] = 5;
            iArr[ProgramExam_Status.REJECTED.ordinal()] = 6;
            iArr[ProgramExam_Status.AVAILABLE_HEADER.ordinal()] = 7;
            iArr[ProgramExam_Status.UNAVAILABLE_HEADER.ordinal()] = 8;
            iArr[ProgramExam_Status.PROGRESS_HEADER.ordinal()] = 9;
            iArr[ProgramExam_Status.CERTIFICATE_HEADER.ordinal()] = 10;
            kotlinx.coroutines.u.k.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class e extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public e(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$AvailableHeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamAvailableHeaderBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamAvailableHeaderBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamAvailableHeaderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends u.e {

        private final e4 b;
        public a(e4 e4Var) {
            n.f(uVar, "this$0");
            n.f(e4Var, "binding");
            super(e4Var);
            this.b = e4Var;
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final e4 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$CertificateHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateCompletedBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateCompletedBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateCompletedBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends u.e {

        private final am b;
        final /* synthetic */ u c;
        public c(am amVar) {
            n.f(uVar, "this$0");
            n.f(amVar, "binding");
            this.c = uVar;
            super(amVar);
            this.b = amVar;
            (Button)amVar.w().findViewById(a.a).setOnClickListener(new kotlinx.coroutines.g(uVar));
        }

        private static final void b(u uVar, View view) {
            n.f(uVar, "this$0");
            final app.dogo.com.dogo_android.y.o.u.b itemViewType = uVar.callbacks;
            if (itemViewType != null) {
                itemViewType.listLoaded();
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final am c() {
            return this.b;
        }

        public static /* synthetic */ void d(u uVar, View view) {
            LessonExamListAdapter_CertificateHolder.b(uVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$ExamHistoryCardHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamPendingCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamPendingCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamPendingCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends u.e {

        private final i4 b;
        final /* synthetic */ u c;
        public d(i4 i4Var) {
            n.f(uVar, "this$0");
            n.f(i4Var, "binding");
            this.c = uVar;
            super(i4Var);
            this.b = i4Var;
            i4Var.P.setOnClickListener(new kotlinx.coroutines.i(uVar, this));
            i4Var.O.setOnClickListener(new kotlinx.coroutines.h(uVar, this));
        }

        private static final void b(u uVar, u.d dVar, View view) {
            n.f(uVar, "this$0");
            n.f(dVar, "this$1");
            app.dogo.com.dogo_android.y.o.u.b itemViewType = uVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onRecordExamPressed((ProgramExam)uVar.h().get(dVar.getAdapterPosition()));
            }
        }

        private static final void c(u uVar, u.d dVar, View view) {
            n.f(uVar, "this$0");
            n.f(dVar, "this$1");
            app.dogo.com.dogo_android.y.o.u.b itemViewType = uVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onExamHistoryPressed((ProgramExam)uVar.h().get(dVar.getAdapterPosition()), uVar.c);
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final i4 d() {
            return this.b;
        }

        public static /* synthetic */ void e(u uVar, u.d dVar, View view) {
            LessonExamListAdapter_ExamHistoryCardHolder.c(uVar, dVar, view);
        }

        public static /* synthetic */ void f(u uVar, u.d dVar, View view) {
            LessonExamListAdapter_ExamHistoryCardHolder.b(uVar, dVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$LockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamLockedCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamLockedCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamLockedCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends u.e {

        private final g4 b;
        final /* synthetic */ u c;
        public f(g4 g4Var) {
            n.f(uVar, "this$0");
            n.f(g4Var, "binding");
            this.c = uVar;
            super(g4Var);
            this.b = g4Var;
            g4Var.w().setOnClickListener(new kotlinx.coroutines.j(uVar, this));
        }

        private static final void b(u uVar, u.f fVar, View view) {
            n.f(uVar, "this$0");
            n.f(fVar, "this$1");
            app.dogo.com.dogo_android.y.o.u.b itemViewType = uVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onPremiumLockedExamPressed((ProgramExam)uVar.h().get(fVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final g4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(u uVar, u.f fVar, View view) {
            LessonExamListAdapter_LockedHolder.b(uVar, fVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$PremiumLockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamPremiumLockedBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamPremiumLockedBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamPremiumLockedBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class g extends u.e {

        private final k4 b;
        final /* synthetic */ u c;
        public g(k4 k4Var) {
            n.f(uVar, "this$0");
            n.f(k4Var, "binding");
            this.c = uVar;
            super(k4Var);
            this.b = k4Var;
            k4Var.w().setOnClickListener(new kotlinx.coroutines.k(uVar, this));
        }

        private static final void b(u uVar, u.g gVar, View view) {
            n.f(uVar, "this$0");
            n.f(gVar, "this$1");
            app.dogo.com.dogo_android.y.o.u.b itemViewType = uVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onLockedItemPressed((ProgramExam)uVar.h().get(gVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final k4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(u uVar, u.g gVar, View view) {
            LessonExamListAdapter_PremiumLockedHolder.b(uVar, gVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$ProgressHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateInProgressBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateInProgressBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutProgramCertificateInProgressBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class h extends u.e {

        private final cm b;
        final /* synthetic */ u c;
        public h(cm cmVar) {
            n.f(uVar, "this$0");
            n.f(cmVar, "binding");
            this.c = uVar;
            super(cmVar);
            this.b = cmVar;
            cmVar.w().setOnClickListener(new kotlinx.coroutines.l(uVar));
        }

        private static final void b(u uVar, View view) {
            n.f(uVar, "this$0");
            final app.dogo.com.dogo_android.y.o.u.b itemViewType = uVar.callbacks;
            if (itemViewType != null) {
                itemViewType.listLoaded();
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final cm c() {
            return this.b;
        }

        public static /* synthetic */ void d(u uVar, View view) {
            LessonExamListAdapter_ProgressHolder.b(uVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$ReadyHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamReadyCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamReadyCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamReadyCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class i extends u.e {

        private final m4 b;
        final /* synthetic */ u c;
        public i(m4 m4Var) {
            n.f(uVar, "this$0");
            n.f(m4Var, "binding");
            this.c = uVar;
            super(m4Var);
            this.b = m4Var;
            m4Var.w().setOnClickListener(new kotlinx.coroutines.m(uVar, this));
        }

        private static final void b(u uVar, u.i iVar, View view) {
            n.f(uVar, "this$0");
            n.f(iVar, "this$1");
            app.dogo.com.dogo_android.y.o.u.b itemViewType = uVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onShowExamVideoPressed((ProgramExam)uVar.h().get(iVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.o.u$e
        public final m4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(u uVar, u.i iVar, View view) {
            LessonExamListAdapter_ReadyHolder.b(uVar, iVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$UnavailableHeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramExamUnavailableHeaderBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramExamUnavailableHeaderBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramExamUnavailableHeaderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class j extends u.e {
        public j(o4 o4Var) {
            n.f(uVar, "this$0");
            n.f(o4Var, "binding");
            super(o4Var);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class m extends b<List<? extends ProgramExam>> {

        final /* synthetic */ Object a;
        final /* synthetic */ u b;
        public m(Object object, Object object2, u uVar) {
            this.a = object;
            this.b = uVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends ProgramExam> oldValue, List<? extends ProgramExam> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.u.l.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class l extends kotlin.d0.d.p implements kotlin.d0.c.p<ProgramExam, ProgramExam, Boolean> {

        public static final u.l a = new u$l();
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


        l() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        LessonExamListAdapter.e = new l[] { c0.f(new t(c0.b(LessonExamListAdapter.class), "list", "getList()Ljava/util/List;")) };
    }

    public u(u.b bVar, ProgramExamSummary programExamSummary, boolean z) {
        super();
        this.callbacks = bVar;
        this.isDogPremium = programExamSummary;
        this.c = z;
        List list = p.g();
        final app.dogo.com.dogo_android.y.o.u.m delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ u.b getItemViewType(u position) {
        return position.callbacks;
    }

    public static final /* synthetic */ boolean g(u uVar) {
        return uVar.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return h().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramExam)h().get(i).getStatus().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final List<ProgramExam> h() {
        return (List)this.programExamSummary.getValue(this, LessonExamListAdapter.e[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public void onBindViewHolder(u.e holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof LessonExamListAdapter_LockedHolder) {
            (LessonExamListAdapter_LockedHolder)holder.c().V((ProgramExam)h().get(position));
        } else {
            if (holder instanceof LessonExamListAdapter_ReadyHolder) {
                (LessonExamListAdapter_ReadyHolder)holder.c().V((ProgramExam)h().get(position));
            } else {
                if (holder instanceof LessonExamListAdapter_ExamHistoryCardHolder) {
                    (LessonExamListAdapter_ExamHistoryCardHolder)holder.d().V((ProgramExam)h().get(position));
                } else {
                    if (holder instanceof LessonExamListAdapter_PremiumLockedHolder) {
                        (LessonExamListAdapter_PremiumLockedHolder)holder.c().V((ProgramExam)h().get(position));
                    } else {
                        if (holder instanceof LessonExamListAdapter_ProgressHolder) {
                            (LessonExamListAdapter_ProgressHolder)holder.c().V(this.isDogPremium);
                        } else {
                            if (holder instanceof LessonExamListAdapter_CertificateHolder) {
                                (LessonExamListAdapter_CertificateHolder)holder.c().V(this.isDogPremium);
                            } else {
                                if (holder instanceof LessonExamListAdapter_AvailableHeaderHolder) {
                                    (LessonExamListAdapter_AvailableHeaderHolder)holder.b().V(Boolean.valueOf(this.c));
                                }
                            }
                        }
                    }
                }
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: j, reason: from kotlin metadata */
    public u.e onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.y.o.u.d lessonExamListAdapter_ExamHistoryCardHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        switch (kotlinx.coroutines.u.k.a[ProgramExam_Status.values()[viewType].ordinal()]) {
            case 1: /* ordinal */
                g4 g4Var = g4.T(from, parent, z);
                n.e(g4Var, str2);
                app.dogo.com.dogo_android.y.o.u.f lessonExamListAdapter_LockedHolder = new LessonExamListAdapter_LockedHolder(this, g4Var);
                break;
            case 2: /* ordinal */
                m4 m4Var = m4.T(from, parent, z);
                n.e(m4Var, str2);
                app.dogo.com.dogo_android.y.o.u.i lessonExamListAdapter_ReadyHolder = new LessonExamListAdapter_ReadyHolder(this, m4Var);
                break;
            case 3: /* ordinal */
                k4 k4Var = k4.T(from, parent, z);
                n.e(k4Var, str2);
                app.dogo.com.dogo_android.y.o.u.g lessonExamListAdapter_PremiumLockedHolder = new LessonExamListAdapter_PremiumLockedHolder(this, k4Var);
                break;
            case 4: /* ordinal */
                i4 i4Var = i4.T(from, parent, z);
                n.e(i4Var, str2);
                lessonExamListAdapter_ExamHistoryCardHolder = new LessonExamListAdapter_ExamHistoryCardHolder(this, i4Var);
                break;
            case 5: /* ordinal */
                i4Var = i4.T(from, parent, z);
                n.e(i4Var, str2);
                lessonExamListAdapter_ExamHistoryCardHolder = new LessonExamListAdapter_ExamHistoryCardHolder(this, i4Var);
                break;
            case 6: /* ordinal */
                i4Var = i4.T(from, parent, z);
                n.e(i4Var, str2);
                lessonExamListAdapter_ExamHistoryCardHolder = new LessonExamListAdapter_ExamHistoryCardHolder(this, i4Var);
                break;
            case 7: /* ordinal */
                e4 e4Var = e4.T(from, parent, z);
                n.e(e4Var, str2);
                app.dogo.com.dogo_android.y.o.u.a lessonExamListAdapter_AvailableHeaderHolder = new LessonExamListAdapter_AvailableHeaderHolder(this, e4Var);
                break;
            case 8: /* ordinal */
                o4 o4Var = o4.T(from, parent, z);
                n.e(o4Var, str2);
                app.dogo.com.dogo_android.y.o.u.j lessonExamListAdapter_UnavailableHeaderHolder = new LessonExamListAdapter_UnavailableHeaderHolder(this, o4Var);
                break;
            case 9: /* ordinal */
                cm cmVar = cm.T(from, parent, z);
                n.e(cmVar, str2);
                app.dogo.com.dogo_android.y.o.u.h lessonExamListAdapter_ProgressHolder = new LessonExamListAdapter_ProgressHolder(this, cmVar);
                break;
            case 10: /* ordinal */
                am amVar = am.T(from, parent, z);
                n.e(amVar, str2);
                app.dogo.com.dogo_android.y.o.u.c lessonExamListAdapter_CertificateHolder = new LessonExamListAdapter_CertificateHolder(this, amVar);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return lessonExamListAdapter_ExamHistoryCardHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void l(List<ProgramExam> list) {
        n.f(list, "<set-?>");
        this.programExamSummary.setValue(this, LessonExamListAdapter.e[0], list);
    }
}
