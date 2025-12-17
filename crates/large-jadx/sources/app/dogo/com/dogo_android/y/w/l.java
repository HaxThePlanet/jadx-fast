package app.dogo.com.dogo_android.y.w;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.a5;
import app.dogo.com.dogo_android.h.g5;
import app.dogo.com.dogo_android.h.k5;
import app.dogo.com.dogo_android.h.q5;
import app.dogo.com.dogo_android.h.s4;
import app.dogo.com.dogo_android.h.w4;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.Iterator;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u0000 \u001e2\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\t\u001c\u001d\u001e\u001f !\"#$B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "lessons", "getLessons", "()Ljava/util/List;", "setLessons", "(Ljava/util/List;)V", "lessons$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ActiveHolder", "Callbacks", "Companion", "CompletedHolder", "ExamCellHolder", "HeaderHolder", "Holder", "LockedHolder", "UnlockedHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends RecyclerView.h<app.dogo.com.dogo_android.y.w.l.g> implements a {

    public static final app.dogo.com.dogo_android.y.w.l.c Companion;
    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.y.w.l.b a;
    private final c b;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH&¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "", "listLoaded", "", "onExamItemPressed", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onItemSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "onLockedItemPressed", "activeLessonIndex", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void W0(int i);

        public abstract void d0(ProgramLesson programLesson);

        public abstract void h();

        public abstract void z1(ProgramSaveInfo programSaveInfo);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Companion;", "", "()V", "SCROLL_DURATION", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        public c(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class j {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramLesson.Type.HEADER.ordinal()] = 1;
            iArr[ProgramLesson.Type.LOCKED.ordinal()] = 2;
            iArr[ProgramLesson.Type.COMPLETED.ordinal()] = 3;
            iArr[ProgramLesson.Type.ACTIVE.ordinal()] = 4;
            iArr[ProgramLesson.Type.EXAM.ordinal()] = 5;
            iArr[ProgramLesson.Type.UNLOCKED.ordinal()] = 6;
            l.j.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class g extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public g(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$ActiveHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonActiveItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonActiveItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonActiveItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends app.dogo.com.dogo_android.y.w.l.g {

        private final s4 b;
        final app.dogo.com.dogo_android.y.w.l c;
        public a(app.dogo.com.dogo_android.y.w.l l, s4 s42) {
            n.f(l, "this$0");
            n.f(s42, "binding");
            this.c = l;
            super(s42);
            this.b = s42;
            a aVar = new a(l, this);
            s42.w().setOnClickListener(aVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.a l$a2, View view3) {
            Object obj0;
            Object obj1;
            n.f(l, "this$0");
            n.f(a2, "this$1");
            app.dogo.com.dogo_android.y.w.l.b obj2 = l.f(l);
            if (obj2 == null) {
            } else {
                obj2.d0((ProgramLesson)l.g().get(a2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.a l$a2, View view3) {
            l.a.b(l, a2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final s4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$CompletedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCompletedItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCompletedItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCompletedItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.y.w.l.g {

        private final w4 b;
        final app.dogo.com.dogo_android.y.w.l c;
        public d(app.dogo.com.dogo_android.y.w.l l, w4 w42) {
            n.f(l, "this$0");
            n.f(w42, "binding");
            this.c = l;
            super(w42);
            this.b = w42;
            b bVar = new b(l, this);
            w42.w().setOnClickListener(bVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.d l$d2, View view3) {
            Object obj0;
            Object obj1;
            n.f(l, "this$0");
            n.f(d2, "this$1");
            app.dogo.com.dogo_android.y.w.l.b obj2 = l.f(l);
            if (obj2 == null) {
            } else {
                obj2.d0((ProgramLesson)l.g().get(d2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.d l$d2, View view3) {
            l.d.b(l, d2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final w4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$ExamCellHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.y.w.l.g {

        private final q5 b;
        final app.dogo.com.dogo_android.y.w.l c;
        public e(app.dogo.com.dogo_android.y.w.l l, q5 q52) {
            n.f(l, "this$0");
            n.f(q52, "binding");
            this.c = l;
            super(q52);
            this.b = q52;
            c cVar = new c(l, this);
            q52.O.setOnClickListener(cVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.e l$e2, View view3) {
            Object obj0;
            Object obj1;
            n.f(l, "this$0");
            n.f(e2, "this$1");
            app.dogo.com.dogo_android.y.w.l.b obj2 = l.f(l);
            if (obj2 == null) {
            } else {
                obj2.z1((ProgramLesson)l.g().get(e2.getAdapterPosition()).getProgramSaveInfo());
            }
        }

        public static void d(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.e l$e2, View view3) {
            l.e.b(l, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final q5 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$HeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends app.dogo.com.dogo_android.y.w.l.g {

        private final a5 b;
        public f(app.dogo.com.dogo_android.y.w.l l, a5 a52) {
            n.f(l, "this$0");
            n.f(a52, "binding");
            super(a52);
            this.b = a52;
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final a5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$LockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonLockedItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonLockedItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonLockedItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class h extends app.dogo.com.dogo_android.y.w.l.g {

        private final g5 b;
        final app.dogo.com.dogo_android.y.w.l c;
        public h(app.dogo.com.dogo_android.y.w.l l, g5 g52) {
            n.f(l, "this$0");
            n.f(g52, "binding");
            this.c = l;
            super(g52);
            this.b = g52;
            d dVar = new d(l);
            g52.w().setOnClickListener(dVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.w.l l, View view2) {
            int next;
            int itemNumber;
            int i;
            ProgramLesson.Type aCTIVE;
            Object obj4;
            n.f(l, "this$0");
            app.dogo.com.dogo_android.y.w.l.b obj5 = l.f(l);
            if (obj5 == null) {
            } else {
                obj4 = l.g().iterator();
                while (obj4.hasNext()) {
                    if ((ProgramLesson)obj4.next().getType() == ProgramLesson.Type.ACTIVE) {
                    } else {
                    }
                    i = 0;
                    i = itemNumber;
                }
                next = 0;
                if ((ProgramLesson)next == 0) {
                } else {
                    itemNumber = (ProgramLesson)next.getItemNumber();
                }
                obj5.W0(itemNumber);
            }
        }

        public static void d(app.dogo.com.dogo_android.y.w.l l, View view2) {
            l.h.b(l, view2);
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final g5 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$UnlockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonUnlockedItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonUnlockedItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonUnlockedItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class i extends app.dogo.com.dogo_android.y.w.l.g {

        private final k5 b;
        final app.dogo.com.dogo_android.y.w.l c;
        public i(app.dogo.com.dogo_android.y.w.l l, k5 k52) {
            n.f(l, "this$0");
            n.f(k52, "binding");
            this.c = l;
            super(k52);
            this.b = k52;
            e eVar = new e(l, this);
            k52.w().setOnClickListener(eVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.i l$i2, View view3) {
            Object obj0;
            Object obj1;
            n.f(l, "this$0");
            n.f(i2, "this$1");
            app.dogo.com.dogo_android.y.w.l.b obj2 = l.f(l);
            if (obj2 == null) {
            } else {
                obj2.d0((ProgramLesson)l.g().get(i2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.i l$i2, View view3) {
            l.i.b(l, i2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final k5 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class l extends b<List<? extends ProgramLesson>> {

        final Object a;
        final app.dogo.com.dogo_android.y.w.l b;
        public l(Object object, Object object2, app.dogo.com.dogo_android.y.w.l l3) {
            this.a = object;
            this.b = l3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends ProgramLesson> list2, List<? extends ProgramLesson> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.y.w.l obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, l.k.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends p implements p<ProgramLesson, ProgramLesson, Boolean> {

        public static final app.dogo.com.dogo_android.y.w.l.k a;
        static {
            l.k kVar = new l.k();
            l.k.a = kVar;
        }

        k() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(ProgramLesson programLesson, ProgramLesson programLesson2) {
            Object obj3;
            Object obj4;
            n.f(programLesson, "o");
            n.f(programLesson2, "n");
            if (programLesson.getItemNumber() == programLesson2.getItemNumber() && programLesson.getType() == programLesson2.getType()) {
                obj3 = programLesson.getType() == programLesson2.getType() ? 1 : 0;
            } else {
            }
            return obj3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((ProgramLesson)object, (ProgramLesson)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(l.class), "lessons", "getLessons()Ljava/util/List;");
        l.c = arr;
        l.c cVar = new l.c(0);
        l.Companion = cVar;
    }

    public l() {
        final int i = 0;
        super(i, 1, i);
    }

    public l(app.dogo.com.dogo_android.y.w.l.b l$b) {
        super();
        this.a = b;
        a obj2 = a.a;
        obj2 = p.g();
        l.l lVar = new l.l(obj2, obj2, this);
        this.b = lVar;
    }

    public l(app.dogo.com.dogo_android.y.w.l.b l$b, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.y.w.l.b f(app.dogo.com.dogo_android.y.w.l l) {
        return l.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<ProgramLesson> g() {
        return (List)this.b.getValue(this, l.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramLesson)g().get(i).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.y.w.l.g l$g, int i2) {
        g5 g5Var;
        List list;
        Object obj4;
        n.f(g, "holder");
        if (g instanceof l.f) {
            (l.f)g.b().V((ProgramLesson)g().get(i2).getDescription());
        } else {
            if (g instanceof l.h) {
                (l.h)g.c().V((ProgramLesson)g().get(i2));
            } else {
                if (g instanceof l.a) {
                    (l.a)g.c().V((ProgramLesson)g().get(i2));
                } else {
                    if (g instanceof l.d) {
                        (l.d)g.c().V((ProgramLesson)g().get(i2));
                    } else {
                        if (g instanceof l.e) {
                            (l.e)g.c().V((ProgramLesson)g().get(i2));
                        } else {
                            if (g instanceof l.i) {
                                (l.i)g.c().V((ProgramLesson)g().get(i2));
                            }
                        }
                    }
                }
            }
        }
        g.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.w.l.g i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj4;
        app.dogo.com.dogo_android.y.w.l.g obj5;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        String str2 = "inflate(inflater, parent, false)";
        final int i4 = 0;
        switch (obj5) {
            case 1:
                obj4 = a5.T(from, viewGroup, i4);
                n.e(obj4, str2);
                obj5 = new l.f(this, obj4);
                break;
            case 2:
                obj4 = g5.T(from, viewGroup, i4);
                n.e(obj4, str2);
                obj5 = new l.h(this, obj4);
                break;
            case 3:
                obj4 = w4.T(from, viewGroup, i4);
                n.e(obj4, str2);
                obj5 = new l.d(this, obj4);
                break;
            case 4:
                obj4 = s4.T(from, viewGroup, i4);
                n.e(obj4, str2);
                obj5 = new l.a(this, obj4);
                break;
            case 5:
                obj4 = q5.T(from, viewGroup, i4);
                n.e(obj4, str2);
                obj5 = new l.e(this, obj4);
                break;
            case 6:
                obj4 = k5.T(from, viewGroup, i4);
                n.e(obj4, str2);
                obj5 = new l.i(this, obj4);
                break;
            default:
                obj4 = new NoWhenBranchMatchedException();
                throw obj4;
        }
        return obj5;
    }

    public final void j(List<ProgramLesson> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, l.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((l.g)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
