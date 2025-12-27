package app.dogo.com.dogo_android.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.f.j.c;
import app.dogo.com.dogo_android.h.ei;
import app.dogo.com.dogo_android.h.ij;
import app.dogo.com.dogo_android.h.ua;
import app.dogo.com.dogo_android.h.yi;
import app.dogo.com.dogo_android.n.m.n.a;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen;
import app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen;
import app.dogo.com.dogo_android.u.m.o;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.k0.e;
import d.h.l.x;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import m.a.b.a.d.a.b;

/* compiled from: DashboardFragment.kt */
@Metadata(d1 = "\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0008\u0010$\u001a\u00020\u001cH\u0016J\u0008\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0008\u0010'\u001a\u00020\u001cH\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010.\u001a\u00020\u001cH\u0016J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0008\u00103\u001a\u0004\u0018\u0001042\u0008\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209H\u0016J\u0008\u0010:\u001a\u00020\u001cH\u0016J\u0008\u0010;\u001a\u00020\u001cH\u0016J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020*H\u0016J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020*H\u0016J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010A\u001a\u00020\u001cH\u0016J\u0008\u0010B\u001a\u00020\u001cH\u0016J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020*H\u0016J\u0010\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020MH\u0016J\u0008\u0010O\u001a\u00020\u001cH\u0016J\u0008\u0010P\u001a\u00020\u001cH\u0016J\u0008\u0010Q\u001a\u00020\u001cH\u0016J\u0008\u0010R\u001a\u00020\u001cH\u0016J\u0010\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001eH\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001eH\u0016J\u0010\u0010V\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020YH\u0016J\u001a\u0010Z\u001a\u00020\u001c2\u0006\u0010[\u001a\u0002002\u0008\u00105\u001a\u0004\u0018\u000106H\u0016J\u0008\u0010\\\u001a\u00020\u001cH\u0002J\u0018\u0010]\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0008\u0010^\u001a\u00020\u001cH\u0016J\u0010\u0010_\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010`\u001a\u00020\u001c2\u0006\u0010[\u001a\u0002002\u0006\u0010a\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001a\u0010\u0010\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006c", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/util/interfaces/DogProfileBarCallback;", "Lapp/dogo/com/dogo_android/dashboard/DashboardCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDashboardBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dashboard/DashboardScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dashboard/DashboardScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "trainingMetricsTooltipAnimator", "Landroid/animation/ValueAnimator;", "trainingMetricsTooltipOriginalHeight", "", "Ljava/lang/Integer;", "viewModel", "Lapp/dogo/com/dogo_android/dashboard/DashboardViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dashboard/DashboardViewModel;", "viewModel$delegate", "animateTrainingMetricsTooltip", "", "tooltipBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardMetricTooltipBinding;", "willBeVisible", "", "createNewDogProfile", "profile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "goToClicker", "goToContactUs", "goToDogProfilePreview", "goToMobileInbox", "onCalendarSelected", "action", "", "onCheckmarkButtonSelected", "checkmarked", "onCheckmarkCardSelected", "onClosePressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onExamCardSelected", "examItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "onExploreTricksSelected", "onInfoSelected", "onOtherTrainingProgramsSelected", "source", "onProgramOverviewSelected", "programId", "onReadHowSelected", "onResubscribeSelected", "onResume", "onReviewProgramSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onReviewRecommendedProgramSelected", "onScheduleSelected", "pottyProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "onSpecialCardSelected", "onStartLessonSelected", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "onStartNextLessonSelected", "onStartQuestionnaireSelected", "onStartWorkoutSelected", "onStop", "onSubscriptionSelected", "onTimeMetricTooltipTap", "tooltip", "onToggleMetricTooltipTap", "onTrackerSelected", "onTrickSelected", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "setOpenedTrickPosition", "setupTooltipAnimation", "switchDogButton", "updateDogProfile", "updateLayoutParamsHeight", "height", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public final class DashboardFragment extends Fragment implements e, o {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final p.a INSTANCE = new p$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private ua binding;
    private final kotlin.h b;
    private final kotlin.h c;
    /* renamed from: v, reason: from kotlin metadata */
    private ValueAnimator trainingMetricsTooltipAnimator;
    /* renamed from: w, reason: from kotlin metadata */
    private Integer trainingMetricsTooltipOriginalHeight;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardFragment$Companion;", "", "()V", "METRIC_TOOLTIP_CONTENT_THRESHOLD", "", "PROGRAM", "", "SCHEDULE_CARD", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\n", d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnStart$$inlined$addListener$default$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements Animator.AnimatorListener {

        final /* synthetic */ yi a;
        final /* synthetic */ p b;
        public c(yi yiVar, p pVar) {
            this.a = yiVar;
            this.b = pVar;
            super();
        }

        public void onAnimationStart(Animator animator) {
            int i = 1;
            n.f(animator, "animator");
            View view2 = this.a.w();
            str = "tooltipBinding.root";
            n.e(view2, str);
            i = 0;
            int i2 = 8;
            animator = view2.getVisibility() == 8 ? 1 : i;
            if (this.a != 0) {
                View view = this.a.w();
                n.e(view, "tooltipBinding.root");
                this.b.P1(view, i);
                float f = 0.0f;
                this.a.w().setAlpha(f);
                this.a.O.setAlpha(f);
                this.a.P.setAlpha(f);
            }
        }

        public void onAnimationCancel(Animator animator) {
            n.f(animator, "animator");
        }

        public void onAnimationEnd(Animator animator) {
            n.f(animator, "animator");
        }

        public void onAnimationRepeat(Animator animator) {
            n.f(animator, "animator");
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.l<View, ViewDataBinding> {

        public static final p.b a = new p$b();
        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }


        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public d(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements kotlin.d0.c.a<r> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final r invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DashboardViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public p() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.p.e(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.p.d(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ void onCreateView(p inflater, View container, int savedInstanceState) {
        inflater.P1(container, savedInstanceState);
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final void animateTrainingMetricsTooltip(yi tooltipBinding, boolean willBeVisible) {
        Integer num;
        int measureSpec;
        int measureSpec2;
        int i = 1;
        View view = tooltipBinding.w();
        n.e(view, "tooltipBinding.root");
        measureSpec = view.getHeight();
        if (!(this.trainingMetricsTooltipOriginalHeight != null || measureSpec == 0 || this.binding != null)) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
        N1(tooltipBinding, willBeVisible);
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final q goToClicker() {
        return (DashboardScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final r E1() {
        return (DashboardViewModel)this.b.getValue();
    }

    private static final void J1(p pVar, app.dogo.com.dogo_android.util.e0.y yVar) {
        n.f(pVar, "this$0");
        DogProfile dogProfile = pVar.getSharedViewModel().I();
        if (dogProfile != null) {
            if (pVar.E1().D(dogProfile.getId()) != null) {
                pVar.E1().N();
            }
        }
    }

    private static final void K1(p pVar, Boolean boolean) {
        n.f(pVar, "this$0");
        n.e(boolean, "isShown");
        if (boolean.booleanValue()) {
            pVar.E1().p0();
        }
    }

    private static final void L1(p pVar, String str) {
        n.f(pVar, "this$0");
        androidx.fragment.app.e activity = pVar.getActivity();
        if (activity != null) {
            str3 = "it";
            n.e(str, str3);
            app.dogo.com.dogo_android.util.extensionfunction.g1.o(activity, new DailyWorkoutUnlockedScreen(pVar.E1().J(str), str, pVar.goToClicker().getTag()));
        }
    }

    private final void M1() {
        int i = 0;
        app.dogo.com.dogo_android.g.p.b item;
        boolean z2;
        i = 0;
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            n.e(binding2.R, "binding.orderedCards");
            Iterator it = i.v(x.contains(binding2.R), kotlinx.coroutines.p.b.a).iterator();
            while (it.hasNext()) {
                z2 = (ViewDataBinding)item instanceof ij;
                if (it.next() instanceof ij) {
                    break;
                }
            }
            z = item instanceof ij;
            if (item instanceof ij) {
            }
            if (i != 0) {
                if (i.O != null) {
                    E1().P(i.O.computeHorizontalScrollOffset());
                }
            }
            return;
        }
    }

    private final void N1(yi yiVar, boolean z) {
        int i2 = 0;
        int value;
        value = 0;
        i2 = 0;
        int r3 = z ? 1065353216 : 0;
        View view2 = yiVar.w();
        n.e(view2, "tooltipBinding.root");
        value = 1;
        int r4 = value;
        if (value != null) {
            if (this.trainingMetricsTooltipOriginalHeight == null) {
            } else {
                value = this.trainingMetricsTooltipOriginalHeight.intValue();
            }
            float f3 = (float)(g.b(yiVar.w().getLayoutParams().height, value)) / (float)value;
        }
        if (this.trainingMetricsTooltipAnimator != null) {
            this.trainingMetricsTooltipAnimator.cancel();
        }
        float[] fArr = new float[2];
        ValueAnimator _float = ValueAnimator.ofFloat(new float[] { i2, i2 });
        _float.setDuration(1000L);
        n.e(_float, "");
        _float.addListener(new AnimatorKt_addListener_listener_1(yiVar, this));
        wVar = w.a;
        this.trainingMetricsTooltipAnimator = _float;
        if (_float != null) {
            _float.addUpdateListener(new kotlinx.coroutines.d(this, yiVar, z));
        }
        if (this.trainingMetricsTooltipAnimator != null) {
            this.trainingMetricsTooltipAnimator.start();
        }
    }

    private static final void O1(p pVar, yi yiVar, boolean z, ValueAnimator valueAnimator) {
        float f = 0;
        int value;
        n.f(pVar, "this$0");
        n.f(yiVar, "$tooltipBinding");
        n.f(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float value2 = animatedValue.floatValue();
        float f3 = 0.7f;
        if (value2 < 0.7f) {
            int i = 0;
        } else {
            float f2 = 0.3f;
            f = (value2 - f3) / f2;
        }
        value = 0;
        if (pVar.trainingMetricsTooltipOriginalHeight == null) {
        } else {
            value = pVar.trainingMetricsTooltipOriginalHeight.intValue();
        }
        float f6 = (float)value * value2;
        yiVar.P.setAlpha(f);
        yiVar.O.setAlpha(f);
        yiVar.w().setAlpha(value2);
        View view5 = yiVar.w();
        n.e(view5, "tooltipBinding.root");
        pVar.P1(view5, a.b(f6));
        int cmp2 = 8;
        float f7 = 5f;
        if (!z && pVar.trainingMetricsTooltipOriginalHeight < f7) {
            yiVar.w().setVisibility(cmp2);
        }
        if (z) {
            if (yiVar.w().getVisibility() == cmp2) {
                if (pVar.trainingMetricsTooltipOriginalHeight > f7) {
                    yiVar.w().setVisibility(value);
                }
            }
        }
    }

    private final void P1(View view, int i) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = g.b(i, 1);
        view.setLayoutParams(layoutParams);
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void A() {
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.S.w().setVisibility(8);
            E1().R();
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: A1, reason: from kotlin metadata */
    public void createNewDogProfile(ProgramDescriptionItem profile) {
        app.dogo.com.dogo_android.y.w.n programLessonsListScreen;
        n.f(profile, "item");
        E1().l0();
        if (profile.getShouldOpenProgramOverview() == null) {
            boolean z = true;
            boolean z2 = false;
            boolean z3 = false;
            int i = 12;
            kotlin.d0.d.g gVar = null;
            programLessonsListScreen = new ProgramLessonsListScreen(z, profile.getId(), z2, z3, goToClicker().getTag(), i, gVar);
        } else {
            boolean z4 = false;
            boolean z5 = false;
            int i2 = 24;
            kotlin.d0.d.g gVar2 = null;
            str3 = "dashboard";
            ProgramOverviewScreen programOverviewScreen = new ProgramOverviewScreen(profile.getId(), profile.getCardBackgroundColor(), profile.getOverviewItem(), z4, z5, goToClicker().getTag(), str3, i2, gVar2);
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programLessonsListScreen);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: B, reason: from kotlin metadata */
    public void goToDogProfilePreview(String profile) {
        n.f(profile, "action");
        E1().i0(profile);
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new PottyTrackerOverviewScreen(goToClicker().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: B0, reason: from kotlin metadata */
    public void onCalendarSelected(DogProfile action) {
        str = "profile";
        n.f(action, str);
        E1().b0();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            boolean z = false;
            int i = 3;
            app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewFullscreenScreen(z, profilePreview, i, profilePreview));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: F, reason: from kotlin metadata */
    public void onCheckmarkButtonSelected(ProgramDescriptionItem checkmarked) {
        n.f(checkmarked, "item");
        E1().l0();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            boolean z = false;
            boolean z2 = true;
            int i = 8;
            kotlin.d0.d.g gVar = null;
            str2 = "dashboard";
            ProgramOverviewScreen checkmarked2 = new ProgramOverviewScreen(checkmarked.getId(), checkmarked.getCardBackgroundColor(), checkmarked.getOverviewItem(), z, z2, goToClicker().getTag(), str2, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, checkmarked2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: F0, reason: from kotlin metadata */
    public void onCheckmarkCardSelected(PottyProgramProgress action) {
        n.f(action, "pottyProgress");
        str = "schedule";
        E1().m0(str);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str2 = "dashboard";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str2, goToClicker().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: L0, reason: from kotlin metadata */
    public void onExamCardSelected(String examItem) {
        n.f(examItem, "programId");
        final String str5 = "dashboard";
        if (n.b(examItem, "id_potty_program")) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new PottyProgramOverviewScreen(str5));
            str = "program";
            E1().m0(str);
        } else {
            if (n.b(examItem, "id_nipping_program")) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new BitingProgramOverviewScreen(str5));
                E1().Z();
            } else {
                str = "Selected unsupported special program";
                a.f(str, new Object[0]);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: O, reason: from kotlin metadata */
    public void onOtherTrainingProgramsSelected(String source) {
        n.f(source, "action");
        E1().i0(source);
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "dashboard";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str, goToClicker().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: T, reason: from kotlin metadata */
    public void onProgramOverviewSelected(ProgramLessonItem programId) {
        n.f(programId, "lessonItem");
        E1().e0();
        ProgramLessonScreen programId2 = new ProgramLessonScreen(programId.getProgramSaveInfo().getLessonId(), programId.getProgramSaveInfo().getProgramId(), goToClicker().getTag(), false, false, 24, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programId2);
    }

    @Override // androidx.fragment.app.Fragment
    public void V0() {
        androidx.fragment.app.e activity = null;
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            str = "dashboard";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new ClickerScreen(str));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: Y0, reason: from kotlin metadata */
    public void onReadHowSelected(boolean action) {
        app.dogo.com.dogo_android.u.n.p.i dogLogCalendarScreen;
        int i = 2;
        String str;
        String str2 = null;
        String str5;
        action = action ? "add_checkmarked" : "add_empty";
        this.E1().i0((action ? "add_checkmarked" : "add_empty"));
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            i = 2;
            str = "dashboard";
            str2 = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str, str2, i, str2));
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            String str3 = null;
            String str4 = null;
            int i2 = 30;
            kotlin.d0.d.g gVar = null;
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen("dashboard", null, null, str3, str4, i2, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, dogLogEditScreen);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: Z, reason: from kotlin metadata */
    public void onReviewProgramSelected(ProgramExamSummary item) {
        n.f(item, "examItem");
        E1().c0();
        LessonExamListScreen lessonExamListScreen = new LessonExamListScreen(item.getProgramSaveInfo(), goToClicker().getTag(), "dashboard", false, 8, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), lessonExamListScreen);
    }

    @Override // androidx.fragment.app.Fragment
    public void a0() {
        E1().k0();
        SubscriptionPlanScreen subscriptionPlanScreen = new SubscriptionPlanScreen("dashboard", goToClicker().getTag(), true, null, 8, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), subscriptionPlanScreen);
    }

    @Override // androidx.fragment.app.Fragment
    public void b0() {
        androidx.fragment.app.e activity = null;
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            str = "dog_select";
            str2 = "dashboard";
            activity.l0(str, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c() {
        E1().n0();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), "dashboard", goToClicker().getTag(), false, null, 12, null));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: d, reason: from kotlin metadata */
    public void onReviewRecommendedProgramSelected(String item) {
        n.f(item, "source");
        E1().d0(item);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ProgramListScreen(goToClicker().getTag(), false, 2, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void f1() {
        E1().r0();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new DailyWorkoutInfoScreen("dashboard"));
    }

    @Override // androidx.fragment.app.Fragment
    public void g0() {
        boolean z = false;
        Boolean bool = E1().U();
        if (bool == null) {
            return;
        } else {
            E1().a0();
            if (bool.booleanValue()) {
                str = "dashboard";
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new UnlockHelplineScreen(str, goToClicker().getTag()));
            } else {
                if (this.binding != null) {
                    n.e(binding2.O.R, "binding.currentDogView.contactUsBadge");
                    binding2.O.R.setVisibility(8);
                    int r0 = E1().K() > 0 ? 1 : 0;
                    this.getSharedViewModel().openZendeskScreen(this.E1().E(), (E1().K() > 0 ? 1 : 0));
                }
            }
        }
        n.w("binding");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: j, reason: from kotlin metadata */
    public void onScheduleSelected(TrickItem pottyProgress) {
        n.f(pottyProgress, "trick");
        E1().j0(pottyProgress.getId());
        if (pottyProgress.getLocked()) {
            boolean z = false;
            app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
            int i = 12;
            Object obj = null;
            str = "library";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), str, goToClicker().getTag(), z, profilePreview, i, obj));
        } else {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickDetailsScreen(new TrickDetailsPlan_LibraryPlan(pottyProgress), goToClicker().getTag(), goToClicker().getTag(), "dashboard"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: l0, reason: from kotlin metadata */
    public void onSpecialCardSelected(yi programId) {
        n.f(programId, "tooltip");
        animateTrainingMetricsTooltip(programId, E1().Y());
    }

    @Override // androidx.fragment.app.Fragment
    public void m() {
        DogProfile dogProfile = getSharedViewModel().I();
        if (dogProfile != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new DashboardSurveyScreen(app.dogo.com.dogo_android.util.extensionfunction.j1.w0(dogProfile.getName()), dogProfile.getId(), goToClicker().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void m0() {
        E1().q0();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new SimpleTrickListScreen());
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: o, reason: from kotlin metadata */
    public void onStartLessonSelected(DogProfile lessonItem) {
        androidx.fragment.app.e activity = null;
        n.f(lessonItem, "profile");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            int i = 11103;
            activity.z0(lessonItem.getId(), lessonItem.getName(), i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        ua uaVar = ua.T(layoutInflater, viewGroup, false);
        n.e(uaVar, "inflate(inflater, container, false)");
        this.binding = uaVar;
        int i = 0;
        String str4 = "binding";
        if (uaVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            uaVar.Y(E1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(this);
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.W(this);
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        this.binding.X(getSharedViewModel());
                        if (this.binding == null) {
                            n.w(str4);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            this.binding.M(getViewLifecycleOwner());
                            if (this.binding == null) {
                                n.w(str4);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                View view = this.binding.w();
                                n.e(view, "binding.root");
                                return view;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        E1().N();
        getSharedViewModel().p0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        M1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        androidx.fragment.app.e activity;
        int i = 0;
        androidx.fragment.app.e activity2;
        boolean z3;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        z3 = getActivity() instanceof Navigator;
        String str3 = null;
        view = this.getActivity() instanceof Navigator ? (Navigator)this.getActivity() : str3;
        if (activity2 != null) {
            activity2.p0();
        }
        if (E1().V()) {
            E1().Q();
            activity = getActivity();
            if (activity != null) {
                i = 0;
                app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
                int i2 = 5;
                Object obj = null;
                str = "lesson";
                app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity, i, str, zendeskConfigurationInfo, i2, obj);
            }
        }
        if (E1().G() && activity3 == null) {
            E1().S();
        }
        getSharedViewModel().E().observe(getViewLifecycleOwner(), new kotlinx.coroutines.e(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        String str4 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner2, str4);
        E1().I().observe(viewLifecycleOwner2, new kotlinx.coroutines.g(this));
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str4);
        E1().H().observe(viewLifecycleOwner3, new kotlinx.coroutines.f(this));
        E1().O();
    }

    @Override // androidx.fragment.app.Fragment
    public void p1() {
        E1().s0();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new DailyWorkoutOverviewScreen(goToClicker().getTag()));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: r0, reason: from kotlin metadata */
    public void onStartNextLessonSelected(DogProfile lessonItem) {
        androidx.fragment.app.e activity = null;
        n.f(lessonItem, "profile");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            int i = 11103;
            activity.w0(lessonItem.getId(), i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void s() {
        E1().h0();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.showLoginForZendeskPopUp(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: u0, reason: from kotlin metadata */
    public void onTimeMetricTooltipTap(yi tooltip) {
        n.f(tooltip, "tooltip");
        E1().g0();
        E1().Y();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new MetricsIntroductionInteractionsScreen(goToClicker().getTag()));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: u1, reason: from kotlin metadata */
    public void onToggleMetricTooltipTap(String tooltip) {
        app.dogo.com.dogo_android.g.r rVar;
        int i = 2;
        String str2;
        String str3 = null;
        n.f(tooltip, "action");
        E1().i0(tooltip);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            i = 2;
            str2 = "dashboard";
            str3 = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str2, str3, i, str3));
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            Long l = null;
            app.dogo.com.dogo_android.k.e eVar = null;
            String str4 = null;
            String str5 = null;
            int i2 = 30;
            kotlin.d0.d.g gVar = null;
            str = "dashboard";
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen(str, l, eVar, str4, str5, i2, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, dogLogEditScreen);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: x0, reason: from kotlin metadata */
    public void onTrackerSelected(String pottyProgress) {
        str = "programId";
        n.f(pottyProgress, str);
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str2 = "dashboard";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new PottyProgramOverviewScreen(str2));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: y0, reason: from kotlin metadata */
    public void onTrickSelected(ProgramLessonItem trick) {
        int i = 0;
        n.f(trick, "lessonItem");
        E1().f0(trick.getProgramSaveInfo().getLessonId());
        ProgramLessonItem.LessonPositionData nextLessonPositionData = trick.getNextLessonPositionData();
        if (nextLessonPositionData == null) {
            i = 0;
        } else {
            String lessonId2 = nextLessonPositionData.getLessonId();
        }
        ProgramLessonScreen trick2 = new ProgramLessonScreen(i, trick.getProgramSaveInfo().getProgramId(), goToClicker().getTag(), false, false, 24, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), trick2);
    }

    public static /* synthetic */ void F1(p pVar, yi yiVar, boolean z, ValueAnimator valueAnimator) {
        DashboardFragment.O1(pVar, yiVar, z, valueAnimator);
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(p view, app.dogo.com.dogo_android.util.e0.y savedInstanceState) {
        DashboardFragment.J1(view, savedInstanceState);
    }

    /* renamed from: H1, reason: from kotlin metadata */
    public static /* synthetic */ void setupTooltipAnimation(p tooltipBinding, String willBeVisible) {
        DashboardFragment.L1(tooltipBinding, willBeVisible);
    }

    /* renamed from: I1, reason: from kotlin metadata */
    public static /* synthetic */ void updateLayoutParamsHeight(p view, Boolean height) {
        DashboardFragment.K1(view, height);
    }
}
