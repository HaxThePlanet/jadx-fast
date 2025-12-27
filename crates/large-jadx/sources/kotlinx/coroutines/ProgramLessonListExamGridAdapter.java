package app.dogo.com.dogo_android.y.w;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.o5;
import app.dogo.com.dogo_android.h.s5;
import app.dogo.com.dogo_android.h.u5;
import app.dogo.com.dogo_android.h.w5;
import app.dogo.com.dogo_android.h.y1;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramLessonListExamGridAdapter.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ApprovedHolder", "EmptyCell", "Holder", "LockedHolder", "PendingHolder", "RejectedHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class ProgramLessonListExamGridAdapter extends RecyclerView.h<k.c> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<ProgramExam> list;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramExam_Status.values().length];
            iArr[ProgramExam_Status.LOCKED.ordinal()] = 1;
            iArr[ProgramExam_Status.READY.ordinal()] = 2;
            iArr[ProgramExam_Status.PENDING.ordinal()] = 3;
            iArr[ProgramExam_Status.REJECTED.ordinal()] = 4;
            iArr[ProgramExam_Status.APPROVED.ordinal()] = 5;
            kotlinx.coroutines.k.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$ApprovedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamApprovedGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamApprovedGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamApprovedGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends k.c {

        private final o5 b;
        public a(o5 o5Var) {
            n.f(kVar, "this$0");
            n.f(o5Var, "binding");
            super(o5Var);
            this.b = o5Var;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final o5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$EmptyCell;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends k.c {
        public b(y1 y1Var) {
            n.f(kVar, "this$0");
            n.f(y1Var, "binding");
            super(y1Var);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$LockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamLockedGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamLockedGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamLockedGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends k.c {

        private final s5 b;
        public d(s5 s5Var) {
            n.f(kVar, "this$0");
            n.f(s5Var, "binding");
            super(s5Var);
            this.b = s5Var;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final s5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$PendingHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamReadyGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamReadyGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamReadyGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends k.c {

        private final u5 b;
        public e(u5 u5Var) {
            n.f(kVar, "this$0");
            n.f(u5Var, "binding");
            super(u5Var);
            this.b = u5Var;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final u5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$RejectedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamRejectedGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamRejectedGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamRejectedGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends k.c {

        private final w5 b;
        public f(w5 w5Var) {
            n.f(kVar, "this$0");
            n.f(w5Var, "binding");
            super(w5Var);
            this.b = w5Var;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final w5 b() {
            return this.b;
        }
    }
    public k(List<ProgramExam> list) {
        n.f(list, "list");
        super();
        this.list = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: f, reason: from kotlin metadata */
    public void onBindViewHolder(k.c holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof ProgramLessonListExamGridAdapter_ApprovedHolder) {
            (ProgramLessonListExamGridAdapter_ApprovedHolder)holder.b().V((ProgramExam)this.list.get(position));
        } else {
            if (holder instanceof ProgramLessonListExamGridAdapter_LockedHolder) {
                (ProgramLessonListExamGridAdapter_LockedHolder)holder.b().V((ProgramExam)this.list.get(position));
            } else {
                if (holder instanceof ProgramLessonListExamGridAdapter_PendingHolder) {
                    (ProgramLessonListExamGridAdapter_PendingHolder)holder.b().V((ProgramExam)this.list.get(position));
                } else {
                    if (holder instanceof ProgramLessonListExamGridAdapter_RejectedHolder) {
                        (ProgramLessonListExamGridAdapter_RejectedHolder)holder.b().V((ProgramExam)this.list.get(position));
                    }
                }
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public k.c onCreateViewHolder(ViewGroup parent, int viewType) {
        int i = 2;
        app.dogo.com.dogo_android.y.w.k.d programLessonListExamGridAdapter_LockedHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = kotlinx.coroutines.k.g.a[ProgramExam_Status.values()[viewType].ordinal()];
        i = 1;
        final String str2 = "inflate(inflater, null, false)";
        final boolean z = false;
        final ViewGroup viewGroup = null;
        if (i2 == 1) {
            s5 s5Var = s5.T(from, viewGroup, z);
            n.e(s5Var, str2);
            programLessonListExamGridAdapter_LockedHolder = new ProgramLessonListExamGridAdapter_LockedHolder(this, s5Var);
        } else {
            i = 2;
            if (i2 == 2 || i2 == 3) {
                u5 u5Var = u5.T(from, viewGroup, z);
                n.e(u5Var, str2);
                app.dogo.com.dogo_android.y.w.k.e programLessonListExamGridAdapter_PendingHolder = new ProgramLessonListExamGridAdapter_PendingHolder(this, u5Var);
            } else {
                i = 4;
                if (i2 == 4) {
                    w5 w5Var = w5.T(from, viewGroup, z);
                    n.e(w5Var, str2);
                    app.dogo.com.dogo_android.y.w.k.f programLessonListExamGridAdapter_RejectedHolder = new ProgramLessonListExamGridAdapter_RejectedHolder(this, w5Var);
                } else {
                    i = 5;
                    if (i2 != 5) {
                        y1 y1Var = y1.T(from, viewGroup, z);
                        n.e(y1Var, str2);
                        app.dogo.com.dogo_android.y.w.k.b programLessonListExamGridAdapter_EmptyCell = new ProgramLessonListExamGridAdapter_EmptyCell(this, y1Var);
                    } else {
                        o5 o5Var = o5.T(from, viewGroup, z);
                        n.e(o5Var, str2);
                        app.dogo.com.dogo_android.y.w.k.a programLessonListExamGridAdapter_ApprovedHolder = new ProgramLessonListExamGridAdapter_ApprovedHolder(this, o5Var);
                    }
                }
            }
        }
        return programLessonListExamGridAdapter_LockedHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int position) {
        return (ProgramExam)this.list.get(position).getStatus().ordinal();
    }
}
