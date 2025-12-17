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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ApprovedHolder", "EmptyCell", "Holder", "LockedHolder", "PendingHolder", "RejectedHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends RecyclerView.h<app.dogo.com.dogo_android.y.w.k.c> {

    private final List<ProgramExam> a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramExam.Status.LOCKED.ordinal()] = 1;
            iArr[ProgramExam.Status.READY.ordinal()] = 2;
            iArr[ProgramExam.Status.PENDING.ordinal()] = 3;
            iArr[ProgramExam.Status.REJECTED.ordinal()] = 4;
            iArr[ProgramExam.Status.APPROVED.ordinal()] = 5;
            k.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$ApprovedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamApprovedGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamApprovedGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamApprovedGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends app.dogo.com.dogo_android.y.w.k.c {

        private final o5 b;
        public a(app.dogo.com.dogo_android.y.w.k k, o5 o52) {
            n.f(k, "this$0");
            n.f(o52, "binding");
            super(o52);
            this.b = o52;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final o5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$EmptyCell;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellEmptyBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.y.w.k.c {
        public b(app.dogo.com.dogo_android.y.w.k k, y1 y12) {
            n.f(k, "this$0");
            n.f(y12, "binding");
            super(y12);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$LockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamLockedGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamLockedGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamLockedGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.y.w.k.c {

        private final s5 b;
        public d(app.dogo.com.dogo_android.y.w.k k, s5 s52) {
            n.f(k, "this$0");
            n.f(s52, "binding");
            super(s52);
            this.b = s52;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final s5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$PendingHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamReadyGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamReadyGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamReadyGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.y.w.k.c {

        private final u5 b;
        public e(app.dogo.com.dogo_android.y.w.k k, u5 u52) {
            n.f(k, "this$0");
            n.f(u52, "binding");
            super(u52);
            this.b = u52;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final u5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$RejectedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamRejectedGridItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonListExamGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamRejectedGridItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamRejectedGridItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends app.dogo.com.dogo_android.y.w.k.c {

        private final w5 b;
        public f(app.dogo.com.dogo_android.y.w.k k, w5 w52) {
            n.f(k, "this$0");
            n.f(w52, "binding");
            super(w52);
            this.b = w52;
        }

        @Override // app.dogo.com.dogo_android.y.w.k$c
        public final w5 b() {
            return this.b;
        }
    }
    public k(List<ProgramExam> list) {
        n.f(list, "list");
        super();
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void f(app.dogo.com.dogo_android.y.w.k.c k$c, int i2) {
        s5 s5Var;
        List list;
        Object obj4;
        n.f(c, "holder");
        if (c instanceof k.a) {
            (k.a)c.b().V((ProgramExam)this.a.get(i2));
        } else {
            if (c instanceof k.d) {
                (k.d)c.b().V((ProgramExam)this.a.get(i2));
            } else {
                if (c instanceof k.e) {
                    (k.e)c.b().V((ProgramExam)this.a.get(i2));
                } else {
                    if (c instanceof k.f) {
                        (k.f)c.b().V((ProgramExam)this.a.get(i2));
                    }
                }
            }
        }
        c.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.w.k.c g(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.y.w.k.c obj6;
        n.f(viewGroup, "parent");
        obj5 = LayoutInflater.from(viewGroup.getContext());
        obj6 = k.g.a[ProgramExam.Status.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, null, false)";
        final int i3 = 0;
        final int i4 = 0;
        if (obj6 != 1) {
            if (obj6 != 2 && obj6 != 3) {
                if (obj6 != 3) {
                    if (obj6 != 4) {
                        if (obj6 != 5) {
                            obj5 = y1.T(obj5, i4, i3);
                            n.e(obj5, str2);
                            obj6 = new k.b(this, obj5);
                        } else {
                            obj5 = o5.T(obj5, i4, i3);
                            n.e(obj5, str2);
                            obj6 = new k.a(this, obj5);
                        }
                    } else {
                        obj5 = w5.T(obj5, i4, i3);
                        n.e(obj5, str2);
                        obj6 = new k.f(this, obj5);
                    }
                } else {
                    obj5 = u5.T(obj5, i4, i3);
                    n.e(obj5, str2);
                    obj6 = new k.e(this, obj5);
                }
            } else {
            }
        } else {
            obj5 = s5.T(obj5, i4, i3);
            n.e(obj5, str2);
            obj6 = new k.d(this, obj5);
        }
        return obj6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramExam)this.a.get(i).getStatus().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        f((k.c)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return g(viewGroup, i2);
    }
}
