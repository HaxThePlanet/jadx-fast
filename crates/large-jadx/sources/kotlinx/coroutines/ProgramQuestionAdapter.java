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

/* compiled from: ProgramQuestionAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 \"2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u001f !\"#$%B/\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000c\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0008\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "answers", "", "", "correctAnswerIndex", "", "question", "(Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;Ljava/util/List;ILjava/lang/String;)V", "correctAnswer", "getCorrectAnswer", "()Ljava/lang/String;", "", "animator", "Landroid/animation/Animator;", "getAnswer", "adapterPosition", "getItemCount", "getItemViewType", "position", "incorrectAnswer", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAnswer", "AnswerAnimation", "AnswerItem", "Callbacks", "Companion", "DefaultViewHolder", "DescriptionItem", "types", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ProgramQuestionAdapter extends RecyclerView.h<e.e> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final e.d INSTANCE = new e$d(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final e.c answers;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<String> callbacks;
    private final int c;
    /* renamed from: d, reason: from kotlin metadata */
    private final String correctAnswerIndex;
    /* renamed from: e, reason: from kotlin metadata */
    private final String question;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0008\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$AnswerAnimation;", "Landroid/animation/Animator$AnimatorListener;", "()V", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a implements Animator.AnimatorListener {
        public void onAnimationCancel(Animator animator) {
            if (animator != null) {
                animator.removeAllListeners();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "", "onCorrectItemSelected", "", "onIncorrectItemSelected", "item", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface c {
        /* renamed from: V, reason: from kotlin metadata */
        void onCorrectItemSelected();

        /* renamed from: c1, reason: from kotlin metadata */
        void onIncorrectItemSelected(String item);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Companion;", "", "()V", "ITEM_OFFSET", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d {
        private d() {
            super();
        }

        public /* synthetic */ d(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramQuestionAdapter_types.values().length];
            iArr[ProgramQuestionAdapter_types.Header.ordinal()] = 1;
            kotlinx.coroutines.e.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$types;", "", "(Ljava/lang/String;I)V", "Header", "Answer", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum h {

        Answer,
        Header;
        private static final /* synthetic */ e.h[] $values() {
            app.dogo.com.dogo_android.y.a0.e.h[] arr = new e.h[2];
            return new e.h[] { ProgramQuestionAdapter_types.Header, ProgramQuestionAdapter_types.Answer };
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$AnswerItem;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionAnswerItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionAnswerItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionAnswerItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends e.e {

        private final a6 b;
        final /* synthetic */ e c;
        public b(a6 a6Var) {
            n.f(eVar, "this$0");
            n.f(a6Var, "binding");
            this.c = eVar;
            super(a6Var);
            this.b = a6Var;
            a6Var.w().setOnClickListener(new kotlinx.coroutines.a(this, eVar));
        }

        private static final void b(e.b bVar, e eVar, View view) throws android.content.res.Resources.NotFoundException {
            n.f(bVar, "this$0");
            n.f(eVar, "this$1");
            android.view.View.OnClickListener onClickListener = null;
            view.setOnClickListener(onClickListener);
            bVar.c().O.setTextColor(App.INSTANCE.b().getResources().getColor(2131100379, onClickListener));
            str = "null cannot be cast to non-null type android.animation.AnimatorSet";
            if (n.b(eVar.getAnswer(bVar.getAdapterPosition()), eVar.j())) {
                int i = 2130837537;
                Animator animator = AnimatorInflater.loadAnimator(bVar.c().w().getContext(), i);
                Objects.requireNonNull(animator, "null cannot be cast to non-null type android.animation.AnimatorSet");
                animator.setTarget(bVar.c().P);
                animator.addListener(new ProgramQuestionAdapter_AnswerItem_1_1(eVar));
                animator.start();
            } else {
                app.dogo.com.dogo_android.y.a0.e.c correctAnswer = eVar.answers;
                if (correctAnswer != null) {
                    correctAnswer.onIncorrectItemSelected(eVar.getAnswer(bVar.getAdapterPosition()));
                }
                i = 2130837538;
                animator = AnimatorInflater.loadAnimator(bVar.c().w().getContext(), i);
                Objects.requireNonNull(animator, "null cannot be cast to non-null type android.animation.AnimatorSet");
                animator.setTarget(bVar.c().P);
                animator.addListener(new ProgramQuestionAdapter_AnswerItem_1_2(eVar, bVar));
                animator.start();
            }
        }

        @Override // app.dogo.com.dogo_android.y.a0.e$e
        public final a6 c() {
            return this.b;
        }

        public static /* synthetic */ void d(e.b bVar, e eVar, View view) {
            ProgramQuestionAdapter_AnswerItem.b(bVar, eVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DescriptionItem;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionItemBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramQuestionItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends e.e {

        private final c6 b;
        public f(c6 c6Var) {
            n.f(eVar, "this$0");
            n.f(c6Var, "binding");
            super(c6Var);
            this.b = c6Var;
        }

        @Override // app.dogo.com.dogo_android.y.a0.e$e
        public final c6 b() {
            return this.b;
        }
    }
    public e(e.c cVar, List<String> list, int i, String str) {
        n.f(list, "answers");
        n.f(str, "question");
        super();
        this.answers = cVar;
        this.callbacks = list;
        this.c = i;
        this.correctAnswerIndex = str;
        this.question = (String)list.get(i);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ String incorrectAnswer(e adapterPosition, int animator) {
        return adapterPosition.getAnswer(animator);
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final /* synthetic */ e.c correctAnswer(e animator) {
        return animator.answers;
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final String getAnswer(int adapterPosition) {
        return (String)this.callbacks.get(adapterPosition - 1);
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final void getItemViewType(int position) {
        this.callbacks.remove(position - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callbacks.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        int ordinal;
        if (i == 0) {
            ordinal = ProgramQuestionAdapter_types.Header.ordinal();
        } else {
            ordinal = ProgramQuestionAdapter_types.Answer.ordinal();
        }
        return ordinal;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public final void removeAnswer(Animator adapterPosition) {
        if (this.answers != null) {
            this.answers.onCorrectItemSelected();
        }
        if (adapterPosition != null) {
            adapterPosition.removeAllListeners();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final String j() {
        return this.question;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: l, reason: from kotlin metadata */
    public final void onBindViewHolder(int holder, Animator position) {
        int size;
        if (holder >= 0) {
            getItemViewType(holder);
            notifyItemRemoved(holder);
            int i = 2;
            if (this.callbacks.size() < 2) {
                if (this.answers != null) {
                    this.answers.onCorrectItemSelected();
                }
            }
            if (position != null) {
                position.removeAllListeners();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: m, reason: from kotlin metadata */
    public void onCreateViewHolder(e.e parent, int viewType) {
        n.f(parent, "holder");
        if (parent instanceof ProgramQuestionAdapter_DescriptionItem) {
            (ProgramQuestionAdapter_DescriptionItem)parent.b().O.setText(this.correctAnswerIndex);
        } else {
            if (parent instanceof ProgramQuestionAdapter_AnswerItem) {
                (ProgramQuestionAdapter_AnswerItem)parent.c().O.setText((CharSequence)this.callbacks.get(viewType - 1));
            }
        }
        parent.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public e.e n(ViewGroup viewGroup, int i) {
        app.dogo.com.dogo_android.y.a0.e.f programQuestionAdapter_DescriptionItem;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (kotlinx.coroutines.e.g.a[ProgramQuestionAdapter_types.values()[i].ordinal()] == 1) {
            c6 c6Var = c6.T(from, viewGroup, z);
            n.e(c6Var, str2);
            programQuestionAdapter_DescriptionItem = new ProgramQuestionAdapter_DescriptionItem(this, c6Var);
        } else {
            a6 a6Var = a6.T(from, viewGroup, z);
            n.e(a6Var, str2);
            app.dogo.com.dogo_android.y.a0.e.b programQuestionAdapter_AnswerItem = new ProgramQuestionAdapter_AnswerItem(this, a6Var);
        }
        return programQuestionAdapter_DescriptionItem;
    }

}
