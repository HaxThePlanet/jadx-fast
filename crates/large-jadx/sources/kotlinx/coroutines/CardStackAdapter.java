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
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: CardStackAdapter.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u0000 '2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0007%&'()*+B#\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u001c\u0010\u001c\u001a\u00020\u000c2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u001c\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020\u000c2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "items", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "swipeCallback", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;", "selectionCallback", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;)V", "animateButtonAndSwipeLeft", "", "button", "Landroid/widget/Button;", "isLastCard", "", "animateButtonAndSwipeRight", "getCurrentTime", "", "getItemCount", "", "getItemViewType", "position", "getQuestionId", "", "isClickDebounceOver", "clickTimestamp", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetButton", "view", "setupAnimationButton", "AnswerSelectCallback", "CardType", "Companion", "Holder", "SwipeCallback", "ThreeAnswerCardHolder", "TwoAnswerCardHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c0, reason: from kotlin metadata */
public final class CardStackAdapter extends RecyclerView.h<c0.d> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final c0.c INSTANCE = new c0$c(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final List<SurveyQuestion> items;
    /* renamed from: b, reason: from kotlin metadata */
    private final c0.e selectionCallback;
    /* renamed from: c, reason: from kotlin metadata */
    private final c0.a swipeCallback;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H&¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "", "onCardAnswerSelect", "", "questionId", "", "answerId", "isLastCard", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: P0, reason: from kotlin metadata */
        void onCardAnswerSelect(String questionId, String answerId, boolean isLastCard);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$CardType;", "", "(Ljava/lang/String;I)V", "TWO_ANSWERS", "THREE_ANSWERS", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        THREE_ANSWERS,
        TWO_ANSWERS;
        private static final /* synthetic */ c0.b[] $values() {
            app.dogo.com.dogo_android.welcome_v2.c0.b[] arr = new c0.b[2];
            return new c0.b[] { CardStackAdapter_CardType.TWO_ANSWERS, CardStackAdapter_CardType.THREE_ANSWERS };
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Companion;", "", "()V", "BUTTON_ANIMATION_LENGTH", "", "BUTTON_CLICK_TIMEOUT_LENGTH", "NEGATIVE_ANSWER_INDEX", "", "POSITIVE_ANSWER_INDEX", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        private c() {
            super();
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;", "", "swipeCardLeft", "", "swipeCardRight", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface e {
        /* renamed from: a, reason: from kotlin metadata */
        void swipeCardLeft();

        void b();
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class h {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[CardStackAdapter_CardType.values().length];
            iArr[CardStackAdapter_CardType.TWO_ANSWERS.ordinal()] = 1;
            iArr[CardStackAdapter_CardType.THREE_ANSWERS.ordinal()] = 2;
            kotlinx.coroutines.c0.h.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0008\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/welcome_v2/CardStackAdapter$setupAnimationButton$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class i implements Animator.AnimatorListener {

        final /* synthetic */ c0 a;
        final /* synthetic */ Button b;
        i(Button button) {
            this.a = c0Var;
            this.b = button;
            super();
        }

        public void onAnimationCancel(Animator animator) {
            this.a.resetButton(this.b);
            if (animator != null) {
                animator.removeAllListeners();
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.a.resetButton(this.b);
            if (animator != null) {
                animator.removeAllListeners();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "isLastCard", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class d extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        final /* synthetic */ c0 b;
        public d(ViewDataBinding viewDataBinding) {
            n.f(c0Var, "this$0");
            n.f(viewDataBinding, "bind");
            this.b = c0Var;
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        /* renamed from: a, reason: from kotlin metadata */
        public final ViewDataBinding isLastCard() {
            return this.bind;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final boolean b() {
            boolean z = true;
            if (getAdapterPosition() != this.b.getItemCount() - 1) {
                int i3 = 0;
            }
            return z;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$ThreeAnswerCardHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardThreeBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardThreeBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardThreeBinding;", "buttonClickTimestamp", "", "setupButton", "", "button", "Landroid/widget/Button;", "answerIndex", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends c0.d {

        private final o6 c;
        /* renamed from: d, reason: from kotlin metadata */
        private long buttonClickTimestamp;
        final /* synthetic */ c0 e;
        public f(o6 o6Var) {
            n.f(c0Var, "this$0");
            n.f(o6Var, "binding");
            this.e = c0Var;
            super(c0Var, o6Var);
            this.c = o6Var;
            n.e(o6Var.O, "binding.firstButton");
            setupButton(o6Var.O, 0);
            n.e(o6Var.R, "binding.secondButton");
            setupButton(o6Var.R, 1);
            n.e(o6Var.S, "binding.thirdButton");
            setupButton(o6Var.S, 2);
        }

        /* renamed from: e, reason: from kotlin metadata */
        private final void setupButton(Button button, int answerIndex) {
            button.setOnClickListener(new kotlinx.coroutines.c(this, this.e, answerIndex, button));
        }

        private static final void f(c0.f fVar, c0 c0Var, int i, Button button, View view) {
            n.f(fVar, "this$0");
            n.f(c0Var, "this$1");
            n.f(button, "$button");
            SurveyQuestion surveyQuestion = fVar.c().T();
            if (surveyQuestion != null) {
                if (c0Var.isClickDebounceOver(fVar.buttonClickTimestamp, l)) {
                    fVar.buttonClickTimestamp = c0Var.getCurrentTime();
                    c0Var.swipeCallback.onCardAnswerSelect(surveyQuestion.getId(), (SurveyAnswer)surveyQuestion.getAnswers().get(i).getId(), fVar.b());
                    c0Var.onBindViewHolder(button, fVar.b());
                }
            }
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.c0$d
        public final o6 c() {
            return this.c;
        }

        public static /* synthetic */ void d(c0.f fVar, c0 c0Var, int i, Button button, View view) {
            CardStackAdapter_ThreeAnswerCardHolder.f(fVar, c0Var, i, button, view);
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JP\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u000b0\u0011H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$TwoAnswerCardHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$Holder;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardTwoBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardTwoBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellQuestionaireCardTwoBinding;", "buttonClickTimestamp", "", "setupButton", "", "button", "Landroid/widget/Button;", "answerIndex", "", "cardAnimation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "lastCard", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class g extends c0.d {

        private final q6 c;
        /* renamed from: d, reason: from kotlin metadata */
        private long buttonClickTimestamp;
        final /* synthetic */ c0 e;
        public g(q6 q6Var) {
            n.f(c0Var, "this$0");
            n.f(q6Var, "binding");
            this.e = c0Var;
            super(c0Var, q6Var);
            this.c = q6Var;
            n.e(q6Var.O, "binding.negativeButton");
            setupButton(q6Var.O, 1, new kotlinx.coroutines.c0.g.a(c0Var));
            n.e(q6Var.Q, "binding.positiveButton");
            setupButton(q6Var.Q, 0, new kotlinx.coroutines.c0.g.b(c0Var));
        }

        /* renamed from: e, reason: from kotlin metadata */
        private final void setupButton(Button button, int answerIndex, kotlin.d0.c.p<? super Button, ? super Boolean, w> cardAnimation) {
            kotlinx.coroutines.d dVar = new kotlinx.coroutines.d(this, this.e, answerIndex, cardAnimation, button);
            button.setOnClickListener(dVar);
        }

        private static final void f(c0.g gVar, c0 c0Var, int i, kotlin.d0.c.p pVar, Button button, View view) {
            n.f(gVar, "this$0");
            n.f(c0Var, "this$1");
            n.f(pVar, "$cardAnimation");
            n.f(button, "$button");
            SurveyQuestion surveyQuestion = gVar.c().T();
            if (surveyQuestion != null) {
                if (c0Var.isClickDebounceOver(gVar.buttonClickTimestamp, l)) {
                    gVar.buttonClickTimestamp = c0Var.getCurrentTime();
                    c0Var.swipeCallback.onCardAnswerSelect(surveyQuestion.getId(), (SurveyAnswer)surveyQuestion.getAnswers().get(i).getId(), gVar.b());
                    pVar.invoke(button, Boolean.valueOf(gVar.b()));
                }
            }
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.c0$d
        public final q6 c() {
            return this.c;
        }

        public static /* synthetic */ void d(c0.g gVar, c0 c0Var, int i, kotlin.d0.c.p pVar, Button button, View view) {
            CardStackAdapter_TwoAnswerCardHolder.f(gVar, c0Var, i, pVar, button, view);
        }
    }
    public c0(List<SurveyQuestion> list, c0.e eVar, c0.a aVar) {
        n.f(list, "items");
        n.f(eVar, "swipeCallback");
        n.f(aVar, "selectionCallback");
        super();
        this.items = list;
        this.selectionCallback = eVar;
        this.swipeCallback = aVar;
    }

    public static final /* synthetic */ void f(c0 c0Var, Button button, boolean z) {
        c0Var.onBindViewHolder(button, z);
    }

    public static final /* synthetic */ void g(c0 c0Var, Button button, boolean z) {
        c0Var.onCreateViewHolder(button, z);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ long getItemViewType(c0 position) {
        return position.getCurrentTime();
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ c0.a getQuestionId(c0 position) {
        return position.swipeCallback;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ boolean animateButtonAndSwipeLeft(c0 button, long isLastCard) {
        return button.isClickDebounceOver(isLastCard);
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final /* synthetic */ void animateButtonAndSwipeRight(c0 button, Button isLastCard) {
        button.resetButton(isLastCard);
    }

    /* renamed from: m, reason: from kotlin metadata */
    private final void onBindViewHolder(Button holder, boolean position) {
        setupAnimationButton(holder);
        if (!position) {
            this.selectionCallback.swipeCardLeft();
        }
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void onCreateViewHolder(Button parent, boolean viewType) {
        setupAnimationButton(parent);
        if (!viewType) {
            this.selectionCallback.b();
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /* renamed from: q, reason: from kotlin metadata */
    private final boolean isClickDebounceOver(long clickTimestamp) {
        boolean z = true;
        long l = getCurrentTime() - clickTimestamp;
        clickTimestamp = l > 1500 ? 1 : 0;
        return (l > 1500 ? 1 : 0);
    }

    /* renamed from: u, reason: from kotlin metadata */
    private final void resetButton(Button view) throws android.content.res.Resources.NotFoundException {
        view.setTextColor(view.getResources().getColor(2131099767, null));
        view.setBackgroundTintList(ColorStateList.valueOf(a.d(view.getContext(), 2131100361)));
    }

    /* renamed from: v, reason: from kotlin metadata */
    private final void setupAnimationButton(Button button) {
        Context context = button.getContext();
        button.setTextColor(context.getColor(2131100379));
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        Object[] arr = new Object[2];
        ValueAnimator object = ValueAnimator.ofObject(argbEvaluator, new Object[] { Integer.valueOf(a.d(context, 2131100361)), Integer.valueOf(a.d(context, 2131100352)) });
        object.setDuration(300L);
        object.addUpdateListener(new kotlinx.coroutines.b(button));
        object.addListener(new CardStackAdapter_setupAnimationButton_2(this, button));
        object.start();
        getItemCount();
    }

    private static final void w(Button button, ValueAnimator valueAnimator) {
        n.f(button, "$button");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        button.setBackgroundTintList(ColorStateList.valueOf(animatedValue.intValue()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.welcome_v2.c0.b tHREE_ANSWERS2;
        i = (SurveyQuestion)this.items.get(i).getAnswer3Text() != null ? CardStackAdapter_CardType.THREE_ANSWERS : CardStackAdapter_CardType.TWO_ANSWERS;
        return ((SurveyQuestion)this.items.get(i).getAnswer3Text() != null ? CardStackAdapter_CardType.THREE_ANSWERS : CardStackAdapter_CardType.TWO_ANSWERS);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final String p(int i) {
        String i2;
        Object obj = p.a0(this.items, i);
        i2 = "";
        if (obj != null) {
            i2 = obj.getId();
            if (i2 != null) {
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void s(c0.d dVar, int i) {
        n.f(dVar, "holder");
        if (dVar instanceof CardStackAdapter_TwoAnswerCardHolder) {
            (CardStackAdapter_TwoAnswerCardHolder)dVar.c().W((SurveyQuestion)this.items.get(i));
        } else {
            if (dVar instanceof CardStackAdapter_ThreeAnswerCardHolder) {
                (CardStackAdapter_ThreeAnswerCardHolder)dVar.c().W((SurveyQuestion)this.items.get(i));
            }
        }
        dVar.isLastCard().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public c0.d t(ViewGroup viewGroup, int i) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.welcome_v2.c0.f cardStackAdapter_ThreeAnswerCardHolder;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i3 = kotlinx.coroutines.c0.h.a[CardStackAdapter_CardType.values()[i].ordinal()];
        i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i3 != 1) {
            i = 2;
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                o6 o6Var = o6.U(from, viewGroup, z);
                n.e(o6Var, str2);
                cardStackAdapter_ThreeAnswerCardHolder = new CardStackAdapter_ThreeAnswerCardHolder(this, o6Var);
                return cardStackAdapter_ThreeAnswerCardHolder;
            }
        }
        q6 q6Var = q6.U(from, viewGroup, z);
        n.e(q6Var, str2);
        app.dogo.com.dogo_android.welcome_v2.c0.g cardStackAdapter_TwoAnswerCardHolder = new CardStackAdapter_TwoAnswerCardHolder(this, q6Var);
    }


    public static /* synthetic */ void r(Button button, ValueAnimator valueAnimator) {
        CardStackAdapter.w(button, valueAnimator);
    }
}
