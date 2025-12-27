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
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.Iterator;
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

/* compiled from: ProgramLessonsListAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u0000 \u001e2\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\t\u001c\u001d\u001e\u001f !\"#$B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "lessons", "getLessons", "()Ljava/util/List;", "setLessons", "(Ljava/util/List;)V", "lessons$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ActiveHolder", "Callbacks", "Companion", "CompletedHolder", "ExamCellHolder", "HeaderHolder", "Holder", "LockedHolder", "UnlockedHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class ProgramLessonsListAdapter extends RecyclerView.h<l.g> implements app.dogo.com.dogo_android.util.d0.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final l.c INSTANCE = new l$c(0);
    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final l.b callbacks;
    private final c b;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH&¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "", "listLoaded", "", "onExamItemPressed", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onItemSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "onLockedItemPressed", "activeLessonIndex", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: W0, reason: from kotlin metadata */
        void onExamItemPressed(int saveInfo);

        /* renamed from: d0, reason: from kotlin metadata */
        void onItemSelected(ProgramLesson item);

        /* renamed from: h, reason: from kotlin metadata */
        void listLoaded();

        /* renamed from: z1, reason: from kotlin metadata */
        void onLockedItemPressed(ProgramSaveInfo activeLessonIndex);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Companion;", "", "()V", "SCROLL_DURATION", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        private c() {
            super();
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class j {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramLesson_Type.values().length];
            iArr[ProgramLesson_Type.HEADER.ordinal()] = 1;
            iArr[ProgramLesson_Type.LOCKED.ordinal()] = 2;
            iArr[ProgramLesson_Type.COMPLETED.ordinal()] = 3;
            iArr[ProgramLesson_Type.ACTIVE.ordinal()] = 4;
            iArr[ProgramLesson_Type.EXAM.ordinal()] = 5;
            iArr[ProgramLesson_Type.UNLOCKED.ordinal()] = 6;
            kotlinx.coroutines.l.j.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class g extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public g(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$ActiveHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonActiveItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonActiveItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonActiveItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends l.g {

        private final s4 b;
        final /* synthetic */ l c;
        public a(s4 s4Var) {
            n.f(lVar, "this$0");
            n.f(s4Var, "binding");
            this.c = lVar;
            super(s4Var);
            this.b = s4Var;
            s4Var.w().setOnClickListener(new kotlinx.coroutines.a(lVar, this));
        }

        private static final void b(l lVar, l.a aVar, View view) {
            n.f(lVar, "this$0");
            n.f(aVar, "this$1");
            app.dogo.com.dogo_android.y.w.l.b itemViewType = lVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onItemSelected((ProgramLesson)lVar.getItemCount().get(aVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final s4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(l lVar, l.a aVar, View view) {
            ProgramLessonsListAdapter_ActiveHolder.b(lVar, aVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$CompletedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCompletedItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCompletedItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCompletedItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends l.g {

        private final w4 b;
        final /* synthetic */ l c;
        public d(w4 w4Var) {
            n.f(lVar, "this$0");
            n.f(w4Var, "binding");
            this.c = lVar;
            super(w4Var);
            this.b = w4Var;
            w4Var.w().setOnClickListener(new kotlinx.coroutines.b(lVar, this));
        }

        private static final void b(l lVar, l.d dVar, View view) {
            n.f(lVar, "this$0");
            n.f(dVar, "this$1");
            app.dogo.com.dogo_android.y.w.l.b itemViewType = lVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onItemSelected((ProgramLesson)lVar.getItemCount().get(dVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final w4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(l lVar, l.d dVar, View view) {
            ProgramLessonsListAdapter_CompletedHolder.b(lVar, dVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$ExamCellHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewExamItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends l.g {

        private final q5 b;
        final /* synthetic */ l c;
        public e(q5 q5Var) {
            n.f(lVar, "this$0");
            n.f(q5Var, "binding");
            this.c = lVar;
            super(q5Var);
            this.b = q5Var;
            q5Var.O.setOnClickListener(new kotlinx.coroutines.c(lVar, this));
        }

        private static final void b(l lVar, l.e eVar, View view) {
            n.f(lVar, "this$0");
            n.f(eVar, "this$1");
            app.dogo.com.dogo_android.y.w.l.b itemViewType = lVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onLockedItemPressed((ProgramLesson)lVar.getItemCount().get(eVar.getAdapterPosition()).getProgramSaveInfo());
            }
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final q5 c() {
            return this.b;
        }

        public static /* synthetic */ void d(l lVar, l.e eVar, View view) {
            ProgramLessonsListAdapter_ExamCellHolder.b(lVar, eVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$HeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends l.g {

        private final a5 b;
        public f(a5 a5Var) {
            n.f(lVar, "this$0");
            n.f(a5Var, "binding");
            super(a5Var);
            this.b = a5Var;
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final a5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$LockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonLockedItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonLockedItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonLockedItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class h extends l.g {

        private final g5 b;
        final /* synthetic */ l c;
        public h(g5 g5Var) {
            n.f(lVar, "this$0");
            n.f(g5Var, "binding");
            this.c = lVar;
            super(g5Var);
            this.b = g5Var;
            g5Var.w().setOnClickListener(new kotlinx.coroutines.d(lVar));
        }

        private static final void b(l lVar, View view) {
            int i = 0;
            int itemNumber = 1;
            ProgramLesson.Type aCTIVE2;
            n.f(lVar, "this$0");
            app.dogo.com.dogo_android.y.w.l.b itemViewType = lVar.callbacks;
            if (itemViewType != null) {
                Iterator it = lVar.getItemCount().iterator();
                itemNumber = 1;
                while (it.hasNext()) {
                    int r2 = (ProgramLesson)item.getType() == ProgramLesson_Type.ACTIVE ? 1 : 0;
                    if (itemNumber != 0) {
                        break;
                    }
                }
                i = 0;
                if (i != 0) {
                    itemNumber = i.getItemNumber();
                }
                itemViewType.onExamItemPressed(itemNumber);
            }
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final g5 c() {
            return this.b;
        }

        public static /* synthetic */ void d(l lVar, View view) {
            ProgramLessonsListAdapter_LockedHolder.b(lVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$UnlockedHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonUnlockedItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonUnlockedItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonUnlockedItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class i extends l.g {

        private final k5 b;
        final /* synthetic */ l c;
        public i(k5 k5Var) {
            n.f(lVar, "this$0");
            n.f(k5Var, "binding");
            this.c = lVar;
            super(k5Var);
            this.b = k5Var;
            k5Var.w().setOnClickListener(new kotlinx.coroutines.e(lVar, this));
        }

        private static final void b(l lVar, l.i iVar, View view) {
            n.f(lVar, "this$0");
            n.f(iVar, "this$1");
            app.dogo.com.dogo_android.y.w.l.b itemViewType = lVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onItemSelected((ProgramLesson)lVar.getItemCount().get(iVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.w.l$g
        public final k5 c() {
            return this.b;
        }

        public static /* synthetic */ void d(l lVar, l.i iVar, View view) {
            ProgramLessonsListAdapter_UnlockedHolder.b(lVar, iVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class l extends b<List<? extends ProgramLesson>> {

        final /* synthetic */ Object a;
        final /* synthetic */ l b;
        public l(Object object, Object object2, l lVar) {
            this.a = object;
            this.b = lVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends ProgramLesson> oldValue, List<? extends ProgramLesson> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.l.k.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends kotlin.d0.d.p implements kotlin.d0.c.p<ProgramLesson, ProgramLesson, Boolean> {

        public static final l.k a = new l$k();
        @Override // kotlin.d0.d.p
        public final boolean a(ProgramLesson programLesson, ProgramLesson programLesson2) {
            boolean z = false;
            ProgramLesson.Type type2;
            n.f(programLesson, "o");
            n.f(programLesson2, "n");
            if (programLesson.getItemNumber() == programLesson2.getItemNumber()) {
                programLesson = programLesson.getType() == programLesson2.getType() ? 1 : 0;
            }
            return (programLesson.getType() == programLesson2.getType() ? 1 : 0);
        }


        k() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        ProgramLessonsListAdapter.c = new l[] { c0.f(new t(c0.b(ProgramLessonsListAdapter.class), "lessons", "getLessons()Ljava/util/List;")) };
    }

    public /* synthetic */ l(l.b bVar, int i, g gVar) {
        app.dogo.com.dogo_android.y.w.l.b bVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(bVar2);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ l.b getItemViewType(l position) {
        return position.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<ProgramLesson> getItemCount() {
        return (List)this.b.getValue(this, ProgramLessonsListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramLesson)getItemCount().get(i).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(l.g holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof ProgramLessonsListAdapter_HeaderHolder) {
            (ProgramLessonsListAdapter_HeaderHolder)holder.b().V((ProgramLesson)getItemCount().get(position).getDescription());
        } else {
            if (holder instanceof ProgramLessonsListAdapter_LockedHolder) {
                (ProgramLessonsListAdapter_LockedHolder)holder.c().V((ProgramLesson)getItemCount().get(position));
            } else {
                if (holder instanceof ProgramLessonsListAdapter_ActiveHolder) {
                    (ProgramLessonsListAdapter_ActiveHolder)holder.c().V((ProgramLesson)getItemCount().get(position));
                } else {
                    if (holder instanceof ProgramLessonsListAdapter_CompletedHolder) {
                        (ProgramLessonsListAdapter_CompletedHolder)holder.c().V((ProgramLesson)getItemCount().get(position));
                    } else {
                        if (holder instanceof ProgramLessonsListAdapter_ExamCellHolder) {
                            (ProgramLessonsListAdapter_ExamCellHolder)holder.c().V((ProgramLesson)getItemCount().get(position));
                        } else {
                            if (holder instanceof ProgramLessonsListAdapter_UnlockedHolder) {
                                (ProgramLessonsListAdapter_UnlockedHolder)holder.c().V((ProgramLesson)getItemCount().get(position));
                            }
                        }
                    }
                }
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public l.g onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.y.w.l.f programLessonsListAdapter_HeaderHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        switch (kotlinx.coroutines.l.j.a[ProgramLesson_Type.values()[viewType].ordinal()]) {
            case 1: /* ordinal */
                a5 a5Var = a5.T(from, parent, z);
                n.e(a5Var, str2);
                programLessonsListAdapter_HeaderHolder = new ProgramLessonsListAdapter_HeaderHolder(this, a5Var);
                break;
            case 2: /* ordinal */
                g5 g5Var = g5.T(from, parent, z);
                n.e(g5Var, str2);
                app.dogo.com.dogo_android.y.w.l.h programLessonsListAdapter_LockedHolder = new ProgramLessonsListAdapter_LockedHolder(this, g5Var);
                break;
            case 3: /* ordinal */
                w4 w4Var = w4.T(from, parent, z);
                n.e(w4Var, str2);
                app.dogo.com.dogo_android.y.w.l.d programLessonsListAdapter_CompletedHolder = new ProgramLessonsListAdapter_CompletedHolder(this, w4Var);
                break;
            case 4: /* ordinal */
                s4 s4Var = s4.T(from, parent, z);
                n.e(s4Var, str2);
                app.dogo.com.dogo_android.y.w.l.a programLessonsListAdapter_ActiveHolder = new ProgramLessonsListAdapter_ActiveHolder(this, s4Var);
                break;
            case 5: /* ordinal */
                q5 q5Var = q5.T(from, parent, z);
                n.e(q5Var, str2);
                app.dogo.com.dogo_android.y.w.l.e programLessonsListAdapter_ExamCellHolder = new ProgramLessonsListAdapter_ExamCellHolder(this, q5Var);
                break;
            case 6: /* ordinal */
                k5 k5Var = k5.T(from, parent, z);
                n.e(k5Var, str2);
                app.dogo.com.dogo_android.y.w.l.i programLessonsListAdapter_UnlockedHolder = new ProgramLessonsListAdapter_UnlockedHolder(this, k5Var);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return programLessonsListAdapter_HeaderHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<ProgramLesson> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, ProgramLessonsListAdapter.c[0], list);
    }

    public l(l.b bVar) {
        super();
        this.callbacks = bVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public l() {
        final app.dogo.com.dogo_android.y.w.l.b bVar = null;
        this(bVar, 1, bVar);
    }
}
