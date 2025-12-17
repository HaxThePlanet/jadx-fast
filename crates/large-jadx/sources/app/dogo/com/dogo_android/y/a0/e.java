package app.dogo.com.dogo_android.y.a0;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.a6;
import app.dogo.com.dogo_android.h.c6;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 \"2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u001f !\"#$%B/\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000c\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0008\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "answers", "", "", "correctAnswerIndex", "", "question", "(Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;Ljava/util/List;ILjava/lang/String;)V", "correctAnswer", "getCorrectAnswer", "()Ljava/lang/String;", "", "animator", "Landroid/animation/Animator;", "getAnswer", "adapterPosition", "getItemCount", "getItemViewType", "position", "incorrectAnswer", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAnswer", "AnswerAnimation", "AnswerItem", "Callbacks", "Companion", "DefaultViewHolder", "DescriptionItem", "types", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends RecyclerView.h<app.dogo.com.dogo_android.y.a0.e.e> {

    public static final app.dogo.com.dogo_android.y.a0.e.d Companion;
    private final app.dogo.com.dogo_android.y.a0.e.c a;
    private final List<String> b;
    private final int c;
    private final String d;
    private final String e;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0008\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$AnswerAnimation;", "Landroid/animation/Animator$AnimatorListener;", "()V", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (animator == null) {
            } else {
                animator.removeAllListeners();
            }
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "", "onCorrectItemSelected", "", "onIncorrectItemSelected", "item", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface c {
        public abstract void V();

        public abstract void c1(String string);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Companion;", "", "()V", "ITEM_OFFSET", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d {
        public d(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[e.h.Header.ordinal()] = 1;
            e.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$types;", "", "(Ljava/lang/String;I)V", "Header", "Answer", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum h {

        Header,
        Answer;
        private static final app.dogo.com.dogo_android.y.a0.e.h[] $values() {
            app.dogo.com.dogo_android.y.a0.e.h[] arr = new e.h[2];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$AnswerItem;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionAnswerItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionAnswerItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionAnswerItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.y.a0.e.e {

        private final a6 b;
        final app.dogo.com.dogo_android.y.a0.e c;
        public b(app.dogo.com.dogo_android.y.a0.e e, a6 a62) {
            n.f(e, "this$0");
            n.f(a62, "binding");
            this.c = e;
            super(a62);
            this.b = a62;
            a aVar = new a(this, e);
            a62.w().setOnClickListener(aVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.a0.e.b e$b, app.dogo.com.dogo_android.y.a0.e e2, View view3) {
            Object bVar;
            int i;
            Object resources;
            Object obj3;
            Animator obj5;
            n.f(b, "this$0");
            n.f(e2, "this$1");
            int i2 = 0;
            view3.setOnClickListener(i2);
            obj5.O.setTextColor(App.Companion.b().getResources().getColor(2131100379, i2));
            bVar = "null cannot be cast to non-null type android.animation.AnimatorSet";
            if (n.b(e.f(e2, b.getAdapterPosition()), e2.j())) {
                obj5 = AnimatorInflater.loadAnimator(b.c().w().getContext(), 2130837537);
                Objects.requireNonNull(obj5, bVar);
                (AnimatorSet)obj5.setTarget(obj3.P);
                obj3 = new e.b.a(e2);
                obj5.addListener(obj3);
                obj5.start();
            } else {
                obj5 = e.g(e2);
                if (obj5 == null) {
                } else {
                    obj5.c1(e.f(e2, b.getAdapterPosition()));
                }
                obj5 = AnimatorInflater.loadAnimator(b.c().w().getContext(), 2130837538);
                Objects.requireNonNull(obj5, bVar);
                (AnimatorSet)obj5.setTarget(a6Var.P);
                bVar = new e.b.b(e2, b);
                obj5.addListener(bVar);
                obj5.start();
            }
        }

        public static void d(app.dogo.com.dogo_android.y.a0.e.b e$b, app.dogo.com.dogo_android.y.a0.e e2, View view3) {
            e.b.b(b, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.a0.e$e
        public final a6 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DescriptionItem;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends app.dogo.com.dogo_android.y.a0.e.e {

        private final c6 b;
        public f(app.dogo.com.dogo_android.y.a0.e e, c6 c62) {
            n.f(e, "this$0");
            n.f(c62, "binding");
            super(c62);
            this.b = c62;
        }

        @Override // app.dogo.com.dogo_android.y.a0.e$e
        public final c6 b() {
            return this.b;
        }
    }
    static {
        e.d dVar = new e.d(0);
        e.Companion = dVar;
    }

    public e(app.dogo.com.dogo_android.y.a0.e.c e$c, List<String> list2, int i3, String string4) {
        n.f(list2, "answers");
        n.f(string4, "question");
        super();
        this.a = c;
        this.b = list2;
        this.c = i3;
        this.d = string4;
        this.e = (String)list2.get(i3);
    }

    public static final String f(app.dogo.com.dogo_android.y.a0.e e, int i2) {
        return e.i(i2);
    }

    public static final app.dogo.com.dogo_android.y.a0.e.c g(app.dogo.com.dogo_android.y.a0.e e) {
        return e.a;
    }

    private final String i(int i) {
        return (String)this.b.get(i--);
    }

    private final void o(int i) {
        this.b.remove(i--);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return size++;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        int obj1;
        if (i == 0) {
            obj1 = e.h.Header.ordinal();
        } else {
            obj1 = e.h.Answer.ordinal();
        }
        return obj1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void h(Animator animator) {
        final app.dogo.com.dogo_android.y.a0.e.c cVar = this.a;
        if (cVar == null) {
        } else {
            cVar.V();
        }
        if (animator == null) {
        } else {
            animator.removeAllListeners();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final String j() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void l(int i, Animator animator2) {
        int i2;
        int obj2;
        o(i);
        notifyItemRemoved(i);
        if (i >= 0 && this.b.size() < 2) {
            o(i);
            notifyItemRemoved(i);
            if (this.b.size() < 2) {
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V();
                }
            }
            if (animator2 == null) {
            } else {
                animator2.removeAllListeners();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void m(app.dogo.com.dogo_android.y.a0.e.e e$e, int i2) {
        String str;
        List list;
        TextView obj4;
        n.f(e, "holder");
        if (e instanceof e.f) {
            obj4.O.setText(this.d);
        } else {
            if (e instanceof e.b) {
                a6Var.O.setText((CharSequence)this.b.get(i2--));
            }
        }
        e.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.a0.e.e n(ViewGroup viewGroup, int i2) {
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.y.a0.e.e obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        String str2 = "inflate(inflater, parent, false)";
        final int i = 0;
        if (e.g.a[e.h.values()[i2].ordinal()] == 1) {
            obj5 = c6.T(from, viewGroup, i);
            n.e(obj5, str2);
            obj6 = new e.f(this, obj5);
        } else {
            obj5 = a6.T(from, viewGroup, i);
            n.e(obj5, str2);
            obj6 = new e.b(this, obj5);
        }
        return obj6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        m((e.e)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return n(viewGroup, i2);
    }
}
