package app.dogo.com.dogo_android.y.s;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.i5;
import app.dogo.com.dogo_android.h.u4;
import app.dogo.com.dogo_android.h.y4;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.d0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;

/* compiled from: LessonCardAdapter.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006\u0017\u0018\u0019\u001a\u001b\u001cB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;)V", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "DefaultViewHolder", "HeaderHolder", "QuestionHolder", "TaskHolder", "TrainingHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class LessonCardAdapter extends RecyclerView.h<i.b> implements a {

    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramLessonItem callbacks;
    /* renamed from: b, reason: from kotlin metadata */
    private final i.a lessonItem;
    /* renamed from: c, reason: from kotlin metadata */
    private final List<LessonCardItem> list;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\tH&¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "", "onFullProgramListSelected", "", "lessonStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "nextLessonId", "", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onQuestionCardSelected", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "onTaskCardSelected", "onTrainingCardSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: K, reason: from kotlin metadata */
        void onQuestionCardSelected(ProgramLessonItem lessonItem, ProgramSaveInfo programSaveInfo);

        /* renamed from: b1, reason: from kotlin metadata */
        void onFullProgramListSelected(ProgramLessonItem.ProgramLessonStatus lessonStatus, String nextLessonId, ProgramSaveInfo programSaveInfo);

        /* renamed from: h1, reason: from kotlin metadata */
        void onTaskCardSelected(ProgramLessonItem lessonItem, ProgramSaveInfo programSaveInfo);

        /* renamed from: n1, reason: from kotlin metadata */
        void onTrainingCardSelected(ProgramLessonItem lessonItem, ProgramSaveInfo programSaveInfo);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[LessonCardItem_CardType.values().length];
            iArr[LessonCardItem_CardType.HEADER.ordinal()] = 1;
            iArr[LessonCardItem_CardType.TRAINING.ordinal()] = 2;
            iArr[LessonCardItem_CardType.QUESTION.ordinal()] = 3;
            iArr[LessonCardItem_CardType.TASK.ordinal()] = 4;
            kotlinx.coroutines.i.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$HeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends i.b {

        private final y4 b;
        final /* synthetic */ i c;
        public c(y4 y4Var) {
            n.f(iVar, "this$0");
            n.f(y4Var, "binding");
            this.c = iVar;
            super(y4Var);
            this.b = y4Var;
            y4Var.w().setOnClickListener(new kotlinx.coroutines.a(iVar));
        }

        private static final void b(i iVar, View view) {
            String lessonId = null;
            n.f(iVar, "this$0");
            app.dogo.com.dogo_android.y.s.i.a itemViewType = iVar.lessonItem;
            if (itemViewType != null) {
                ProgramLessonItem.LessonPositionData nextLessonPositionData = iVar.callbacks.getNextLessonPositionData();
                if (nextLessonPositionData == null) {
                    int i = 0;
                } else {
                    lessonId = nextLessonPositionData.getLessonId();
                }
                itemViewType.onFullProgramListSelected(iVar.callbacks.getLessonStatus(), lessonId, iVar.callbacks.getProgramSaveInfo());
            }
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final y4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, View view) {
            LessonCardAdapter_HeaderHolder.b(iVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$QuestionHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends i.b {

        private final u4 b;
        final /* synthetic */ i c;
        public d(u4 u4Var) {
            n.f(iVar, "this$0");
            n.f(u4Var, "binding");
            this.c = iVar;
            super(u4Var);
            this.b = u4Var;
            u4Var.w().setOnClickListener(new kotlinx.coroutines.b(iVar));
        }

        private static final void b(i iVar, View view) {
            n.f(iVar, "this$0");
            app.dogo.com.dogo_android.y.s.i.a itemViewType = iVar.lessonItem;
            if (itemViewType != null) {
                itemViewType.onQuestionCardSelected(iVar.callbacks, iVar.callbacks.getProgramSaveInfo());
            }
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final u4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, View view) {
            LessonCardAdapter_QuestionHolder.b(iVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$TaskHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends i.b {

        private final u4 b;
        final /* synthetic */ i c;
        public e(u4 u4Var) {
            n.f(iVar, "this$0");
            n.f(u4Var, "binding");
            this.c = iVar;
            super(u4Var);
            this.b = u4Var;
            u4Var.w().setOnClickListener(new kotlinx.coroutines.c(iVar));
        }

        private static final void b(i iVar, View view) {
            n.f(iVar, "this$0");
            app.dogo.com.dogo_android.y.s.i.a itemViewType = iVar.lessonItem;
            if (itemViewType != null) {
                itemViewType.onTaskCardSelected(iVar.callbacks, iVar.callbacks.getProgramSaveInfo());
            }
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final u4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, View view) {
            LessonCardAdapter_TaskHolder.b(iVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$TrainingHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonTrainingCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonTrainingCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonTrainingCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends i.b {

        private final i5 b;
        final /* synthetic */ i c;
        public f(i5 i5Var) {
            n.f(iVar, "this$0");
            n.f(i5Var, "binding");
            this.c = iVar;
            super(i5Var);
            this.b = i5Var;
            i5Var.w().setOnClickListener(new kotlinx.coroutines.d(iVar));
        }

        private static final void b(i iVar, View view) {
            n.f(iVar, "this$0");
            app.dogo.com.dogo_android.y.s.i.a itemViewType = iVar.lessonItem;
            if (itemViewType != null) {
                itemViewType.onTrainingCardSelected(iVar.callbacks, iVar.callbacks.getProgramSaveInfo());
            }
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final i5 c() {
            return this.b;
        }

        public static /* synthetic */ void d(i iVar, View view) {
            LessonCardAdapter_TrainingHolder.b(iVar, view);
        }
    }
    public i(ProgramLessonItem programLessonItem, i.a aVar) {
        n.f(programLessonItem, "lessonItem");
        super();
        this.callbacks = programLessonItem;
        this.lessonItem = aVar;
        this.list = programLessonItem.getCardList();
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ i.a getItemViewType(i position) {
        return position.lessonItem;
    }

    public static final /* synthetic */ ProgramLessonItem g(i iVar) {
        return iVar.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (LessonCardItem)this.list.get(i).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(i.b holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof LessonCardAdapter_HeaderHolder) {
            (LessonCardAdapter_HeaderHolder)holder.c().V((LessonCardItem)this.list.get(position));
        } else {
            if (holder instanceof LessonCardAdapter_TrainingHolder) {
                (LessonCardAdapter_TrainingHolder)holder.c().V((LessonCardItem)this.list.get(position));
            } else {
                if (holder instanceof LessonCardAdapter_QuestionHolder) {
                    (LessonCardAdapter_QuestionHolder)holder.c().V((LessonCardItem)this.list.get(position));
                } else {
                    if (holder instanceof LessonCardAdapter_TaskHolder) {
                        (LessonCardAdapter_TaskHolder)holder.c().V((LessonCardItem)this.list.get(position));
                    }
                }
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public i.b onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.y.s.i.f lessonCardAdapter_TrainingHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = kotlinx.coroutines.i.g.a[LessonCardItem_CardType.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                i = 3;
                if (i2 != 3) {
                    i = 4;
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        u4 u4Var = u4.T(from, parent, z);
                        n.e(u4Var, str2);
                        app.dogo.com.dogo_android.y.s.i.e lessonCardAdapter_TaskHolder = new LessonCardAdapter_TaskHolder(this, u4Var);
                    }
                }
                u4 u4Var2 = u4.T(from, parent, z);
                n.e(u4Var2, str2);
                app.dogo.com.dogo_android.y.s.i.d lessonCardAdapter_QuestionHolder = new LessonCardAdapter_QuestionHolder(this, u4Var2);
            } else {
                i5 i5Var = i5.T(from, parent, z);
                n.e(i5Var, str2);
                lessonCardAdapter_TrainingHolder = new LessonCardAdapter_TrainingHolder(this, i5Var);
            }
        } else {
            y4 y4Var = y4.T(from, parent, z);
            n.e(y4Var, str2);
            app.dogo.com.dogo_android.y.s.i.c lessonCardAdapter_HeaderHolder = new LessonCardAdapter_HeaderHolder(this, y4Var);
        }
        return lessonCardAdapter_TrainingHolder;
    }
}
