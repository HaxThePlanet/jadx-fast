package app.dogo.com.dogo_android.welcome_v2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.o6;
import app.dogo.com.dogo_android.h.q6;
import app.dogo.com.dogo_android.repository.domain.SurveyAnswer;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u0000 '2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0007%&'()*+B#\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u001c\u0010\u001c\u001a\u00020\u000c2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u001c\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020\u000c2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "items", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "swipeCallback", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;", "selectionCallback", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;)V", "animateButtonAndSwipeLeft", "", "button", "Landroid/widget/Button;", "isLastCard", "", "animateButtonAndSwipeRight", "getCurrentTime", "", "getItemCount", "", "getItemViewType", "position", "getQuestionId", "", "isClickDebounceOver", "clickTimestamp", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetButton", "view", "setupAnimationButton", "AnswerSelectCallback", "CardType", "Companion", "Holder", "SwipeCallback", "ThreeAnswerCardHolder", "TwoAnswerCardHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c0 extends RecyclerView.h<app.dogo.com.dogo_android.welcome_v2.c0.d> {

    public static final app.dogo.com.dogo_android.welcome_v2.c0.c Companion;
    private final List<SurveyQuestion> a;
    private final app.dogo.com.dogo_android.welcome_v2.c0.e b;
    private final app.dogo.com.dogo_android.welcome_v2.c0.a c;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H&¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "", "onCardAnswerSelect", "", "questionId", "", "answerId", "isLastCard", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void P0(String string, String string2, boolean z3);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$CardType;", "", "(Ljava/lang/String;I)V", "TWO_ANSWERS", "THREE_ANSWERS", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        TWO_ANSWERS,
        THREE_ANSWERS;
        private static final app.dogo.com.dogo_android.welcome_v2.c0.b[] $values() {
            app.dogo.com.dogo_android.welcome_v2.c0.b[] arr = new c0.b[2];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Companion;", "", "()V", "BUTTON_ANIMATION_LENGTH", "", "BUTTON_CLICK_TIMEOUT_LENGTH", "NEGATIVE_ANSWER_INDEX", "", "POSITIVE_ANSWER_INDEX", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        public c(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;", "", "swipeCardLeft", "", "swipeCardRight", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface e {
        public abstract void a();

        public abstract void b();
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class h {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[c0.b.TWO_ANSWERS.ordinal()] = 1;
            iArr[c0.b.THREE_ANSWERS.ordinal()] = 2;
            c0.h.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0008\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/welcome_v2/CardStackAdapter$setupAnimationButton$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class i implements Animator.AnimatorListener {

        final app.dogo.com.dogo_android.welcome_v2.c0 a;
        final Button b;
        i(app.dogo.com.dogo_android.welcome_v2.c0 c0, Button button2) {
            this.a = c0;
            this.b = button2;
            super();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c0.l(this.a, this.b);
            if (animator == null) {
            } else {
                animator.removeAllListeners();
            }
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.l(this.a, this.b);
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

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "isLastCard", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class d extends RecyclerView.e0 {

        private final ViewDataBinding a;
        final app.dogo.com.dogo_android.welcome_v2.c0 b;
        public d(app.dogo.com.dogo_android.welcome_v2.c0 c0, ViewDataBinding viewDataBinding2) {
            n.f(c0, "this$0");
            n.f(viewDataBinding2, "bind");
            this.b = c0;
            super(viewDataBinding2.w());
            this.a = viewDataBinding2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final boolean b() {
            int i;
            if (getAdapterPosition() == itemCount -= i) {
            } else {
                i = 0;
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$ThreeAnswerCardHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardThreeBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardThreeBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardThreeBinding;", "buttonClickTimestamp", "", "setupButton", "", "button", "Landroid/widget/Button;", "answerIndex", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends app.dogo.com.dogo_android.welcome_v2.c0.d {

        private final o6 c;
        private long d;
        final app.dogo.com.dogo_android.welcome_v2.c0 e;
        public f(app.dogo.com.dogo_android.welcome_v2.c0 c0, o6 o62) {
            n.f(c0, "this$0");
            n.f(o62, "binding");
            this.e = c0;
            super(c0, o62);
            this.c = o62;
            Button obj2 = o62.O;
            n.e(obj2, "binding.firstButton");
            e(obj2, 0);
            obj2 = o62.R;
            n.e(obj2, "binding.secondButton");
            e(obj2, 1);
            obj2 = o62.S;
            n.e(obj2, "binding.thirdButton");
            e(obj2, 2);
        }

        public static void d(app.dogo.com.dogo_android.welcome_v2.c0.f c0$f, app.dogo.com.dogo_android.welcome_v2.c0 c02, int i3, Button button4, View view5) {
            c0.f.f(f, c02, i3, button4, view5);
        }

        private final void e(Button button, int i2) {
            c cVar = new c(this, this.e, i2, button);
            button.setOnClickListener(cVar);
        }

        private static final void f(app.dogo.com.dogo_android.welcome_v2.c0.f c0$f, app.dogo.com.dogo_android.welcome_v2.c0 c02, int i3, Button button4, View view5) {
            boolean z;
            long l;
            Object obj2;
            int obj4;
            SurveyQuestion obj6;
            n.f(f, "this$0");
            n.f(c02, "this$1");
            n.f(button4, "$button");
            obj6 = f.c().T();
            if (obj6 != null && c0.j(c02, f.d)) {
                if (c0.j(c02, f.d)) {
                    f.d = c0.h(c02);
                    c0.i(c02).P0(obj6.getId(), (SurveyAnswer)obj6.getAnswers().get(i3).getId(), f.b());
                    c0.f(c02, button4, f.b());
                }
            }
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.c0$d
        public final o6 c() {
            return this.c;
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JP\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u000b0\u0011H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$TwoAnswerCardHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardTwoBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardTwoBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardTwoBinding;", "buttonClickTimestamp", "", "setupButton", "", "button", "Landroid/widget/Button;", "answerIndex", "", "cardAnimation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "lastCard", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class g extends app.dogo.com.dogo_android.welcome_v2.c0.d {

        private final q6 c;
        private long d;
        final app.dogo.com.dogo_android.welcome_v2.c0 e;
        public g(app.dogo.com.dogo_android.welcome_v2.c0 c0, q6 q62) {
            n.f(c0, "this$0");
            n.f(q62, "binding");
            this.e = c0;
            super(c0, q62);
            this.c = q62;
            Button button = q62.O;
            n.e(button, "binding.negativeButton");
            c0.g.a aVar = new c0.g.a(c0);
            e(button, 1, aVar);
            final Button obj5 = q62.Q;
            n.e(obj5, "binding.positiveButton");
            c0.g.b bVar = new c0.g.b(c0);
            e(obj5, 0, bVar);
        }

        public static void d(app.dogo.com.dogo_android.welcome_v2.c0.g c0$g, app.dogo.com.dogo_android.welcome_v2.c0 c02, int i3, p p4, Button button5, View view6) {
            c0.g.f(g, c02, i3, p4, button5, view6);
        }

        private final void e(Button button, int i2, p<? super Button, ? super Boolean, w> p3) {
            super(this, this.e, i2, p3, button);
            button.setOnClickListener(dVar2);
        }

        private static final void f(app.dogo.com.dogo_android.welcome_v2.c0.g c0$g, app.dogo.com.dogo_android.welcome_v2.c0 c02, int i3, p p4, Button button5, View view6) {
            boolean z;
            Object obj2;
            Object obj3;
            int obj4;
            SurveyQuestion obj7;
            n.f(g, "this$0");
            n.f(c02, "this$1");
            n.f(p4, "$cardAnimation");
            n.f(button5, "$button");
            obj7 = g.c().T();
            if (obj7 != null && c0.j(c02, g.d)) {
                if (c0.j(c02, g.d)) {
                    g.d = c0.h(c02);
                    c0.i(c02).P0(obj7.getId(), (SurveyAnswer)obj7.getAnswers().get(i3).getId(), g.b());
                    p4.invoke(button5, Boolean.valueOf(g.b()));
                }
            }
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.c0$d
        public final q6 c() {
            return this.c;
        }
    }
    static {
        c0.c cVar = new c0.c(0);
        c0.Companion = cVar;
    }

    public c0(List<SurveyQuestion> list, app.dogo.com.dogo_android.welcome_v2.c0.e c0$e2, app.dogo.com.dogo_android.welcome_v2.c0.a c0$a3) {
        n.f(list, "items");
        n.f(e2, "swipeCallback");
        n.f(a3, "selectionCallback");
        super();
        this.a = list;
        this.b = e2;
        this.c = a3;
    }

    public static final void f(app.dogo.com.dogo_android.welcome_v2.c0 c0, Button button2, boolean z3) {
        c0.m(button2, z3);
    }

    public static final void g(app.dogo.com.dogo_android.welcome_v2.c0 c0, Button button2, boolean z3) {
        c0.n(button2, z3);
    }

    public static final long h(app.dogo.com.dogo_android.welcome_v2.c0 c0) {
        return c0.o();
    }

    public static final app.dogo.com.dogo_android.welcome_v2.c0.a i(app.dogo.com.dogo_android.welcome_v2.c0 c0) {
        return c0.c;
    }

    public static final boolean j(app.dogo.com.dogo_android.welcome_v2.c0 c0, long l2) {
        return c0.q(l2);
    }

    public static final void l(app.dogo.com.dogo_android.welcome_v2.c0 c0, Button button2) {
        c0.u(button2);
    }

    private final void m(Button button, boolean z2) {
        Object obj1;
        v(button);
        if (!z2) {
            this.b.a();
        }
    }

    private final void n(Button button, boolean z2) {
        Object obj1;
        v(button);
        if (!z2) {
            this.b.b();
        }
    }

    private final long o() {
        return System.currentTimeMillis();
    }

    private final boolean q(long l) {
        int obj3;
        obj3 = Long.compare(i, obj3) > 0 ? 1 : 0;
        return obj3;
    }

    public static void r(Button button, ValueAnimator valueAnimator2) {
        c0.w(button, valueAnimator2);
    }

    private final void u(Button button) {
        button.setTextColor(button.getResources().getColor(2131099767, 0));
        button.setBackgroundTintList(ColorStateList.valueOf(a.d(button.getContext(), 2131100361)));
    }

    private final void v(Button button) {
        Context context = button.getContext();
        button.setTextColor(context.getColor(2131100379));
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        Object[] arr = new Object[2];
        ValueAnimator object = ValueAnimator.ofObject(argbEvaluator, Integer.valueOf(a.d(context, 2131100361)), Integer.valueOf(a.d(context, 2131100352)));
        object.setDuration(300);
        b bVar = new b(button);
        object.addUpdateListener(bVar);
        c0.i iVar = new c0.i(this, button);
        object.addListener(iVar);
        object.start();
        getItemCount();
    }

    private static final void w(Button button, ValueAnimator valueAnimator2) {
        n.f(button, "$button");
        Object obj2 = valueAnimator2.getAnimatedValue();
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        button.setBackgroundTintList(ColorStateList.valueOf((Integer)obj2.intValue()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.welcome_v2.c0.b obj2;
        obj2 = (SurveyQuestion)this.a.get(i).getAnswer3Text() != null ? c0.b.THREE_ANSWERS : c0.b.TWO_ANSWERS;
        return obj2.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        s((c0.d)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return t(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final String p(int i) {
        String str;
        Object obj2;
        obj2 = p.a0(this.a, i);
        str = "";
        if ((SurveyQuestion)obj2 == null) {
        } else {
            obj2 = (SurveyQuestion)obj2.getId();
            if (obj2 == null) {
            } else {
                str = obj2;
            }
        }
        return str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void s(app.dogo.com.dogo_android.welcome_v2.c0.d c0$d, int i2) {
        q6 q6Var;
        List list;
        Object obj4;
        n.f(d, "holder");
        if (d instanceof c0.g) {
            (c0.g)d.c().W((SurveyQuestion)this.a.get(i2));
        } else {
            if (d instanceof c0.f) {
                (c0.f)d.c().W((SurveyQuestion)this.a.get(i2));
            }
        }
        d.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.welcome_v2.c0.d t(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.welcome_v2.c0.d obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = c0.h.a[c0.b.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = o6.U(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new c0.f(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = q6.U(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new c0.g(this, obj5);
    }
}
