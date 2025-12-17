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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006\u0017\u0018\u0019\u001a\u001b\u001cB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;)V", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "DefaultViewHolder", "HeaderHolder", "QuestionHolder", "TaskHolder", "TrainingHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends RecyclerView.h<app.dogo.com.dogo_android.y.s.i.b> implements a {

    private final ProgramLessonItem a;
    private final app.dogo.com.dogo_android.y.s.i.a b;
    private final List<LessonCardItem> c;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\tH&¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "", "onFullProgramListSelected", "", "lessonStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "nextLessonId", "", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onQuestionCardSelected", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "onTaskCardSelected", "onTrainingCardSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void K(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo2);

        public abstract void b1(ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus, String string2, ProgramSaveInfo programSaveInfo3);

        public abstract void h1(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo2);

        public abstract void n1(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo2);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[LessonCardItem.CardType.HEADER.ordinal()] = 1;
            iArr[LessonCardItem.CardType.TRAINING.ordinal()] = 2;
            iArr[LessonCardItem.CardType.QUESTION.ordinal()] = 3;
            iArr[LessonCardItem.CardType.TASK.ordinal()] = 4;
            i.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$HeaderHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonHeaderCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.y.s.i.b {

        private final y4 b;
        final app.dogo.com.dogo_android.y.s.i c;
        public c(app.dogo.com.dogo_android.y.s.i i, y4 y42) {
            n.f(i, "this$0");
            n.f(y42, "binding");
            this.c = i;
            super(y42);
            this.b = y42;
            a aVar = new a(i);
            y42.w().setOnClickListener(aVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.s.i i, View view2) {
            ProgramLessonItem.ProgramLessonStatus lessonStatus;
            int lessonId;
            Object obj2;
            n.f(i, "this$0");
            app.dogo.com.dogo_android.y.s.i.a obj3 = i.f(i);
            if (obj3 == null) {
            } else {
                ProgramLessonItem.LessonPositionData nextLessonPositionData = i.g(i).getNextLessonPositionData();
                if (nextLessonPositionData == null) {
                    lessonId = 0;
                } else {
                    lessonId = nextLessonPositionData.getLessonId();
                }
                obj3.b1(i.g(i).getLessonStatus(), lessonId, i.g(i).getProgramSaveInfo());
            }
        }

        public static void d(app.dogo.com.dogo_android.y.s.i i, View view2) {
            i.c.b(i, view2);
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final y4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$QuestionHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.y.s.i.b {

        private final u4 b;
        final app.dogo.com.dogo_android.y.s.i c;
        public d(app.dogo.com.dogo_android.y.s.i i, u4 u42) {
            n.f(i, "this$0");
            n.f(u42, "binding");
            this.c = i;
            super(u42);
            this.b = u42;
            b bVar = new b(i);
            u42.w().setOnClickListener(bVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.s.i i, View view2) {
            ProgramLessonItem programLessonItem;
            Object obj1;
            n.f(i, "this$0");
            app.dogo.com.dogo_android.y.s.i.a obj2 = i.f(i);
            if (obj2 == null) {
            } else {
                obj2.K(i.g(i), i.g(i).getProgramSaveInfo());
            }
        }

        public static void d(app.dogo.com.dogo_android.y.s.i i, View view2) {
            i.d.b(i, view2);
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final u4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$TaskHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.y.s.i.b {

        private final u4 b;
        final app.dogo.com.dogo_android.y.s.i c;
        public e(app.dogo.com.dogo_android.y.s.i i, u4 u42) {
            n.f(i, "this$0");
            n.f(u42, "binding");
            this.c = i;
            super(u42);
            this.b = u42;
            c cVar = new c(i);
            u42.w().setOnClickListener(cVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.s.i i, View view2) {
            ProgramLessonItem programLessonItem;
            Object obj1;
            n.f(i, "this$0");
            app.dogo.com.dogo_android.y.s.i.a obj2 = i.f(i);
            if (obj2 == null) {
            } else {
                obj2.h1(i.g(i), i.g(i).getProgramSaveInfo());
            }
        }

        public static void d(app.dogo.com.dogo_android.y.s.i i, View view2) {
            i.e.b(i, view2);
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final u4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$TrainingHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonTrainingCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonTrainingCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonTrainingCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends app.dogo.com.dogo_android.y.s.i.b {

        private final i5 b;
        final app.dogo.com.dogo_android.y.s.i c;
        public f(app.dogo.com.dogo_android.y.s.i i, i5 i52) {
            n.f(i, "this$0");
            n.f(i52, "binding");
            this.c = i;
            super(i52);
            this.b = i52;
            d dVar = new d(i);
            i52.w().setOnClickListener(dVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.s.i i, View view2) {
            ProgramLessonItem programLessonItem;
            Object obj1;
            n.f(i, "this$0");
            app.dogo.com.dogo_android.y.s.i.a obj2 = i.f(i);
            if (obj2 == null) {
            } else {
                obj2.n1(i.g(i), i.g(i).getProgramSaveInfo());
            }
        }

        public static void d(app.dogo.com.dogo_android.y.s.i i, View view2) {
            i.f.b(i, view2);
        }

        @Override // app.dogo.com.dogo_android.y.s.i$b
        public final i5 c() {
            return this.b;
        }
    }
    public i(ProgramLessonItem programLessonItem, app.dogo.com.dogo_android.y.s.i.a i$a2) {
        n.f(programLessonItem, "lessonItem");
        super();
        this.a = programLessonItem;
        this.b = a2;
        this.c = programLessonItem.getCardList();
    }

    public static final app.dogo.com.dogo_android.y.s.i.a f(app.dogo.com.dogo_android.y.s.i i) {
        return i.b;
    }

    public static final ProgramLessonItem g(app.dogo.com.dogo_android.y.s.i i) {
        return i.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (LessonCardItem)this.c.get(i).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.y.s.i.b i$b, int i2) {
        i5 i5Var;
        List list;
        Object obj4;
        n.f(b, "holder");
        if (b instanceof i.c) {
            (i.c)b.c().V((LessonCardItem)this.c.get(i2));
        } else {
            if (b instanceof i.f) {
                (i.f)b.c().V((LessonCardItem)this.c.get(i2));
            } else {
                if (b instanceof i.d) {
                    (i.d)b.c().V((LessonCardItem)this.c.get(i2));
                } else {
                    if (b instanceof i.e) {
                        (i.e)b.c().V((LessonCardItem)this.c.get(i2));
                    }
                }
            }
        }
        b.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.s.i.b i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.y.s.i.b obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = i.g.a[LessonCardItem.CardType.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
                if (obj6 != 3) {
                    if (obj6 != 4) {
                    } else {
                        obj5 = u4.T(from, viewGroup, i3);
                        n.e(obj5, str2);
                        obj6 = new i.e(this, obj5);
                    }
                    obj5 = new NoWhenBranchMatchedException();
                    throw obj5;
                }
                obj5 = u4.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new i.d(this, obj5);
            } else {
                obj5 = i5.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new i.f(this, obj5);
            }
        } else {
            obj5 = y4.T(from, viewGroup, i3);
            n.e(obj5, str2);
            obj6 = new i.c(this, obj5);
        }
        return obj6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((i.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
