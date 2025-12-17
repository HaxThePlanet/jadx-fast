package app.dogo.com.dogo_android.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.e.j;
import app.dogo.com.dogo_android.f.j.c;
import app.dogo.com.dogo_android.f.k.g;
import app.dogo.com.dogo_android.f.m.d;
import app.dogo.com.dogo_android.f.n.d;
import app.dogo.com.dogo_android.g.g0.j;
import app.dogo.com.dogo_android.h.ua;
import app.dogo.com.dogo_android.h.yi;
import app.dogo.com.dogo_android.n.m.n.a;
import app.dogo.com.dogo_android.n.m.u.m;
import app.dogo.com.dogo_android.q.p.y;
import app.dogo.com.dogo_android.r.k;
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
import app.dogo.com.dogo_android.u.n.m;
import app.dogo.com.dogo_android.u.n.p.i;
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.u.n.r.g;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.k0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.x.c.h;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.o.w;
import app.dogo.com.dogo_android.y.s.k;
import app.dogo.com.dogo_android.y.w.n;
import app.dogo.com.dogo_android.y.y.g;
import app.dogo.com.dogo_android.y.z.f;
import d.h.l.x;
import f.d.a.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.e0.a;
import kotlin.h;
import kotlin.h0.g;
import kotlin.j;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0008\u0010$\u001a\u00020\u001cH\u0016J\u0008\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0008\u0010'\u001a\u00020\u001cH\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010.\u001a\u00020\u001cH\u0016J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0008\u00103\u001a\u0004\u0018\u0001042\u0008\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209H\u0016J\u0008\u0010:\u001a\u00020\u001cH\u0016J\u0008\u0010;\u001a\u00020\u001cH\u0016J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020*H\u0016J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020*H\u0016J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010A\u001a\u00020\u001cH\u0016J\u0008\u0010B\u001a\u00020\u001cH\u0016J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020*H\u0016J\u0010\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020MH\u0016J\u0008\u0010O\u001a\u00020\u001cH\u0016J\u0008\u0010P\u001a\u00020\u001cH\u0016J\u0008\u0010Q\u001a\u00020\u001cH\u0016J\u0008\u0010R\u001a\u00020\u001cH\u0016J\u0010\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001eH\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001eH\u0016J\u0010\u0010V\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020YH\u0016J\u001a\u0010Z\u001a\u00020\u001c2\u0006\u0010[\u001a\u0002002\u0008\u00105\u001a\u0004\u0018\u000106H\u0016J\u0008\u0010\\\u001a\u00020\u001cH\u0002J\u0018\u0010]\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0008\u0010^\u001a\u00020\u001cH\u0016J\u0010\u0010_\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010`\u001a\u00020\u001c2\u0006\u0010[\u001a\u0002002\u0006\u0010a\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001a\u0010\u0010\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006c", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/util/interfaces/DogProfileBarCallback;", "Lapp/dogo/com/dogo_android/dashboard/DashboardCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDashboardBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dashboard/DashboardScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dashboard/DashboardScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "trainingMetricsTooltipAnimator", "Landroid/animation/ValueAnimator;", "trainingMetricsTooltipOriginalHeight", "", "Ljava/lang/Integer;", "viewModel", "Lapp/dogo/com/dogo_android/dashboard/DashboardViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dashboard/DashboardViewModel;", "viewModel$delegate", "animateTrainingMetricsTooltip", "", "tooltipBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardMetricTooltipBinding;", "willBeVisible", "", "createNewDogProfile", "profile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "goToClicker", "goToContactUs", "goToDogProfilePreview", "goToMobileInbox", "onCalendarSelected", "action", "", "onCheckmarkButtonSelected", "checkmarked", "onCheckmarkCardSelected", "onClosePressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onExamCardSelected", "examItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "onExploreTricksSelected", "onInfoSelected", "onOtherTrainingProgramsSelected", "source", "onProgramOverviewSelected", "programId", "onReadHowSelected", "onResubscribeSelected", "onResume", "onReviewProgramSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onReviewRecommendedProgramSelected", "onScheduleSelected", "pottyProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "onSpecialCardSelected", "onStartLessonSelected", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "onStartNextLessonSelected", "onStartQuestionnaireSelected", "onStartWorkoutSelected", "onStop", "onSubscriptionSelected", "onTimeMetricTooltipTap", "tooltip", "onToggleMetricTooltipTap", "onTrackerSelected", "onTrickSelected", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "setOpenedTrickPosition", "setupTooltipAnimation", "switchDogButton", "updateDogProfile", "updateLayoutParamsHeight", "height", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends Fragment implements e, app.dogo.com.dogo_android.g.o {

    public static final app.dogo.com.dogo_android.g.p.a Companion;
    private ua a;
    private final h b;
    private final h c;
    private ValueAnimator v;
    private Integer w;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardFragment$Companion;", "", "()V", "METRIC_TOOLTIP_CONTENT_THRESHOLD", "", "PROGRAM", "", "SCHEDULE_CARD", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\n", d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnStart$$inlined$addListener$default$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements Animator.AnimatorListener {

        final yi a;
        final app.dogo.com.dogo_android.g.p b;
        public c(yi yi, app.dogo.com.dogo_android.g.p p2) {
            this.a = yi;
            this.b = p2;
            super();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
            n.f(animator, "animator");
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator) {
            n.f(animator, "animator");
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            n.f(animator, "animator");
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator) {
            String str;
            int i;
            int obj4;
            n.f(animator, "animator");
            obj4 = this.a.w();
            str = "tooltipBinding.root";
            n.e(obj4, str);
            final int i2 = 0;
            obj4 = obj4.getVisibility() == 8 ? 1 : i2;
            if (obj4 != null) {
                i = this.a.w();
                n.e(i, str);
                p.B1(this.b, i, i2);
                str = 0;
                this.a.w().setAlpha(str);
                obj4.O.setAlpha(str);
                obj4.P.setAlpha(str);
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<View, ViewDataBinding> {

        public static final app.dogo.com.dogo_android.g.p.b a;
        static {
            p.b bVar = new p.b();
            p.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((View)object);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public d(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements a<app.dogo.com.dogo_android.g.r> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.g.r invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(r.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        p.a aVar = new p.a(0);
        p.Companion = aVar;
    }

    public p() {
        super();
        final int i = 0;
        p.e eVar = new p.e(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, eVar);
        p.d dVar = new p.d(this, i, i);
        this.c = j.a(m.NONE, dVar);
    }

    public static final void B1(app.dogo.com.dogo_android.g.p p, View view2, int i3) {
        p.P1(view2, i3);
    }

    private final void C1(yi yi, boolean z2) {
        Object valueOf;
        Integer measureSpec2;
        int measureSpec;
        String next;
        int i;
        int i2;
        valueOf = yi.w();
        n.e(valueOf, "tooltipBinding.root");
        measureSpec2 = valueOf.getHeight();
        if (this.w == null && measureSpec2 == 0) {
            measureSpec2 = valueOf.getHeight();
            if (measureSpec2 == 0) {
                ua uaVar = this.a;
                if (uaVar == null) {
                } else {
                    android.widget.LinearLayout linearLayout = uaVar.R;
                    n.e(linearLayout, "binding.orderedCards");
                    Iterator iterator = x.b(linearLayout).iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        i2 = 0;
                        if ((View)next.getVisibility() == 0) {
                        } else {
                        }
                        i = i2;
                        i = 1;
                    }
                    NoSuchElementException obj6 = new NoSuchElementException("Sequence contains no element matching the predicate.");
                    throw obj6;
                }
                n.w("binding");
                throw 0;
            }
            P1(valueOf, measureSpec2);
            valueOf = Integer.valueOf(measureSpec2);
            this.w = valueOf;
        }
        N1(yi, z2);
    }

    private final app.dogo.com.dogo_android.g.q D1() {
        return (q)k1.a(this);
    }

    private final app.dogo.com.dogo_android.g.r E1() {
        return (r)this.b.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.g.p p, yi yi2, boolean z3, ValueAnimator valueAnimator4) {
        p.O1(p, yi2, z3, valueAnimator4);
    }

    public static void G1(app.dogo.com.dogo_android.g.p p, y y2) {
        p.J1(p, y2);
    }

    public static void H1(app.dogo.com.dogo_android.g.p p, String string2) {
        p.L1(p, string2);
    }

    public static void I1(app.dogo.com.dogo_android.g.p p, Boolean boolean2) {
        p.K1(p, boolean2);
    }

    private static final void J1(app.dogo.com.dogo_android.g.p p, y y2) {
        app.dogo.com.dogo_android.g.r rVar;
        Object obj1;
        DogProfile obj2;
        n.f(p, "this$0");
        obj2 = p.getSharedViewModel().I();
        if (obj2 == null) {
        } else {
            if (p.E1().D(obj2.getId())) {
                p.E1().N();
            }
        }
    }

    private static final void K1(app.dogo.com.dogo_android.g.p p, Boolean boolean2) {
        Object obj1;
        n.f(p, "this$0");
        n.e(boolean2, "isShown");
        if (boolean2.booleanValue()) {
            p.E1().p0();
        }
    }

    private static final void L1(app.dogo.com.dogo_android.g.p p, String string2) {
        d dVar;
        String str2;
        String str;
        Object obj4;
        n.f(p, "this$0");
        androidx.fragment.app.e activity = p.getActivity();
        if (activity == null) {
        } else {
            n.e(string2, "it");
            dVar = new d(p.E1().J(string2), string2, p.D1().getTag());
            g1.o(activity, dVar);
        }
    }

    private final void M1() {
        boolean horizontalScrollOffset;
        int i;
        app.dogo.com.dogo_android.g.p.b next;
        boolean z;
        ua uaVar = this.a;
        i = 0;
        if (uaVar == null) {
        } else {
            android.widget.LinearLayout linearLayout = uaVar.R;
            n.e(linearLayout, "binding.orderedCards");
            Iterator iterator = i.v(x.b(linearLayout), p.b.a).iterator();
            for (Object next : iterator) {
            }
            next = i;
            if (next instanceof ij) {
                i = next;
            }
            if (i == 0) {
            } else {
                horizontalScrollOffset = i.O;
                if (horizontalScrollOffset == null) {
                } else {
                    E1().P(horizontalScrollOffset.computeHorizontalScrollOffset());
                }
            }
        }
        n.w("binding");
        throw i;
    }

    private final void N1(yi yi, boolean z2) {
        int i;
        Object dVar;
        int i2;
        int intValue;
        int i3;
        int i4;
        int i6 = 0;
        i3 = z2 ? 1065353216 : i2;
        View view2 = yi.w();
        n.e(view2, "tooltipBinding.root");
        int i8 = 1;
        i4 = view2.getVisibility() == 0 ? i8 : i6;
        if (i4 != 0) {
            Integer num = this.w;
            if (num == null) {
                intValue = i6;
            } else {
                intValue = num.intValue();
            }
            i2 = i / f;
        }
        ValueAnimator valueAnimator = this.v;
        if (valueAnimator == null) {
        } else {
            valueAnimator.cancel();
        }
        float[] fArr = new float[2];
        fArr[i6] = i2;
        fArr[i8] = i3;
        ValueAnimator float = ValueAnimator.ofFloat(fArr);
        float.setDuration(1000);
        n.e(float, "");
        p.c cVar = new p.c(yi, this);
        float.addListener(cVar);
        dVar = w.a;
        this.v = float;
        if (float == null) {
        } else {
            dVar = new d(this, yi, z2);
            float.addUpdateListener(dVar);
        }
        final ValueAnimator obj7 = this.v;
        if (obj7 == null) {
        } else {
            obj7.start();
        }
    }

    private static final void O1(app.dogo.com.dogo_android.g.p p, yi yi2, boolean z3, ValueAnimator valueAnimator4) {
        int i;
        int cmp2;
        int cmp;
        int intValue;
        int obj4;
        int obj6;
        n.f(p, "this$0");
        n.f(yi2, "$tooltipBinding");
        n.f(valueAnimator4, "valueAnimator");
        Object obj7 = valueAnimator4.getAnimatedValue();
        Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.Float");
        obj7 = (Float)obj7.floatValue();
        int i2 = 1060320051;
        if (Float.compare(obj7, i2) < 0) {
            i = 0;
        } else {
            i3 /= cmp;
        }
        Integer num = p.w;
        final int i5 = 0;
        if (num == null) {
            intValue = i5;
        } else {
            intValue = num.intValue();
        }
        f *= obj7;
        yi2.P.setAlpha(i);
        yi2.O.setAlpha(i);
        yi2.w().setAlpha(obj7);
        obj7 = yi2.w();
        n.e(obj7, "tooltipBinding.root");
        p.P1(obj7, a.b(i4));
        obj4 = 8;
        obj7 = 1084227584;
        if (z3 == 0 && Float.compare(i4, obj7) < 0) {
            if (Float.compare(i4, obj7) < 0) {
                yi2.w().setVisibility(obj4);
            }
        }
        if (z3 != 0 && yi2.w().getVisibility() == obj4 && Float.compare(i4, obj7) > 0) {
            if (yi2.w().getVisibility() == obj4) {
                if (Float.compare(i4, obj7) > 0) {
                    yi2.w().setVisibility(i5);
                }
            }
        }
    }

    private final void P1(View view, int i2) {
        final android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = g.b(i2, 1);
        view.setLayoutParams(layoutParams);
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void A() {
        ua uaVar = this.a;
        if (uaVar == null) {
        } else {
            uaVar.S.w().setVisibility(8);
            E1().R();
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void A1(ProgramDescriptionItem programDescriptionItem) {
        j nVar;
        Object obj;
        int i5;
        String str2;
        int i4;
        int i;
        String tag;
        int i3;
        int i2;
        f fVar;
        String str;
        String cardBackgroundColor;
        app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem;
        int i7;
        int i6;
        String tag2;
        String str3;
        int i9;
        int i8;
        n.f(programDescriptionItem, "item");
        E1().l0();
        if (!programDescriptionItem.getShouldOpenProgramOverview()) {
            super(1, programDescriptionItem.getId(), 0, 0, D1().getTag(), 12, 0);
        } else {
            super(programDescriptionItem.getId(), programDescriptionItem.getCardBackgroundColor(), programDescriptionItem.getOverviewItem(), 0, 0, D1().getTag(), "dashboard", 24, 0);
        }
        g1.n(getActivity(), nVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void B(String string) {
        Object gVar;
        String tag;
        n.f(string, "action");
        E1().i0(string);
        final androidx.fragment.app.e obj3 = getActivity();
        if (obj3 == null) {
        } else {
            gVar = new g(D1().getTag());
            g1.n(obj3, gVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(DogProfile dogProfile) {
        Object yVar;
        int i3;
        int i;
        int i2;
        n.f(dogProfile, "profile");
        E1().b0();
        androidx.fragment.app.e obj5 = getActivity();
        if (obj5 == null) {
        } else {
            i2 = 0;
            yVar = new y(0, i2, 3, i2);
            g1.n(obj5, yVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F(ProgramDescriptionItem programDescriptionItem) {
        f fVar;
        String str;
        String cardBackgroundColor;
        app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem;
        int i2;
        int i3;
        String tag;
        String str2;
        int i4;
        int i;
        Object obj12;
        n.f(programDescriptionItem, "item");
        E1().l0();
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            super(programDescriptionItem.getId(), programDescriptionItem.getCardBackgroundColor(), programDescriptionItem.getOverviewItem(), 0, 1, D1().getTag(), "dashboard", 8, 0);
            g1.n(activity, obj12);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F0(PottyProgramProgress pottyProgramProgress) {
        Object iVar;
        String tag;
        String str;
        n.f(pottyProgramProgress, "pottyProgress");
        E1().m0("schedule");
        androidx.fragment.app.e obj4 = getActivity();
        if (obj4 == null) {
        } else {
            iVar = new i("dashboard", D1().getTag());
            g1.n(obj4, iVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void L0(String string) {
        Object oVar;
        app.dogo.com.dogo_android.g.r obj3;
        n.f(string, "programId");
        final String str4 = "dashboard";
        if (n.b(string, "id_potty_program")) {
            m mVar = new m(str4);
            g1.n(getActivity(), mVar);
            E1().m0("program");
        } else {
            if (n.b(string, "id_nipping_program")) {
                oVar = new o(str4);
                g1.n(getActivity(), oVar);
                E1().Z();
            } else {
                a.f("Selected unsupported special program", new Object[0]);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void O(String string) {
        Object iVar;
        String tag;
        String str;
        n.f(string, "action");
        E1().i0(string);
        final androidx.fragment.app.e obj4 = getActivity();
        if (obj4 == null) {
        } else {
            iVar = new i("dashboard", D1().getTag());
            g1.n(obj4, iVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T(ProgramLessonItem programLessonItem) {
        n.f(programLessonItem, "lessonItem");
        E1().e0();
        super(programLessonItem.getProgramSaveInfo().getLessonId(), programLessonItem.getProgramSaveInfo().getProgramId(), D1().getTag(), 0, 0, 24, 0);
        g1.n(getActivity(), obj11);
    }

    @Override // androidx.fragment.app.Fragment
    public void V0() {
        androidx.fragment.app.e activity;
        j jVar;
        String str;
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            jVar = new j("dashboard");
            g1.n(activity, jVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0(boolean z) {
        Object iVar;
        int str2;
        String str;
        int i4;
        int i5;
        int i;
        int i3;
        int i2;
        h hVar;
        String obj10;
        obj10 = z ? "add_checkmarked" : "add_empty";
        E1().i0(obj10);
        obj10 = getActivity();
        if (obj10 == null) {
        } else {
            i4 = 0;
            iVar = new i("dashboard", i4, 2, i4);
            g1.n(obj10, iVar);
        }
        obj10 = getActivity();
        if (obj10 == null) {
        } else {
            super("dashboard", 0, 0, 0, 0, 30, 0);
            g1.n(obj10, hVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z(ProgramExamSummary programExamSummary) {
        n.f(programExamSummary, "examItem");
        E1().c0();
        super(programExamSummary.getProgramSaveInfo(), D1().getTag(), "dashboard", 0, 8, 0);
        g1.n(getActivity(), wVar2);
    }

    @Override // androidx.fragment.app.Fragment
    public void a0() {
        E1().k0();
        super("dashboard", D1().getTag(), 1, 0, 8, 0);
        g1.n(getActivity(), subscriptionPlanScreen2);
    }

    @Override // androidx.fragment.app.Fragment
    public void b0() {
        androidx.fragment.app.e activity;
        String str;
        String str2;
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.l0("dog_select", "dashboard");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c() {
        E1().n0();
        g1.n(getActivity(), l.H(getSharedViewModel(), "dashboard", D1().getTag(), false, 0, 12, 0));
    }

    @Override // androidx.fragment.app.Fragment
    public void d(String string) {
        n.f(string, "source");
        E1().d0(string);
        g gVar = new g(D1().getTag(), 0, 2, 0);
        g1.n(getActivity(), gVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void f1() {
        E1().r0();
        c cVar = new c("dashboard");
        g1.n(getActivity(), cVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void g0() {
        int activity;
        UnlockHelplineScreen unlockHelplineScreen;
        Object sharedViewModel;
        String str;
        activity = E1().U();
        if (activity == null) {
        } else {
            E1().a0();
            if (activity.booleanValue()) {
                unlockHelplineScreen = new UnlockHelplineScreen("dashboard", D1().getTag());
                g1.n(getActivity(), unlockHelplineScreen);
            } else {
                ua uaVar = this.a;
                if (uaVar == null) {
                } else {
                    android.widget.ImageView view = eiVar.R;
                    n.e(view, "binding.currentDogView.contactUsBadge");
                    view.setVisibility(8);
                    activity = E1().K() > 0 ? 1 : 0;
                    getSharedViewModel().openZendeskScreen(E1().E(), activity);
                }
            }
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void j(TrickItem trickItem) {
        androidx.fragment.app.e activity;
        Object sharedViewModel;
        Object aVar;
        String tag;
        int str;
        int i;
        int i3;
        int i2;
        Object obj9;
        n.f(trickItem, "trick");
        E1().j0(trickItem.getId());
        if (trickItem.getLocked()) {
            g1.n(getActivity(), l.H(getSharedViewModel(), "library", D1().getTag(), false, 0, 12, 0));
        } else {
            aVar = new n.a(trickItem);
            sharedViewModel = new m(aVar, D1().getTag(), D1().getTag(), "dashboard");
            g1.n(getActivity(), sharedViewModel);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l0(yi yi) {
        n.f(yi, "tooltip");
        C1(yi, E1().Y());
    }

    @Override // androidx.fragment.app.Fragment
    public void m() {
        Object dogProfile;
        androidx.fragment.app.e activity;
        j jVar;
        String str;
        String tag;
        dogProfile = getSharedViewModel().I();
        if (dogProfile == null) {
        } else {
            jVar = new j(j1.w0(dogProfile.getName()), dogProfile.getId(), D1().getTag());
            g1.n(getActivity(), jVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void m0() {
        E1().q0();
        d dVar = new d();
        g1.n(getActivity(), dVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void o(DogProfile dogProfile) {
        androidx.fragment.app.e activity;
        String str;
        int i;
        Object obj4;
        n.f(dogProfile, "profile");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.z0(dogProfile.getId(), dogProfile.getName(), 11103);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ua obj2 = ua.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.Y(E1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.W(this);
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2.X(getSharedViewModel());
                        obj2 = this.a;
                        if (obj2 == null) {
                        } else {
                            obj2.M(getViewLifecycleOwner());
                            obj2 = this.a;
                            if (obj2 == null) {
                            } else {
                                obj2 = obj2.w();
                                n.e(obj2, "binding.root");
                                return obj2;
                            }
                            n.w(obj4);
                            throw obj3;
                        }
                        n.w(obj4);
                        throw obj3;
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
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
    public void onViewCreated(View view, Bundle bundle2) {
        androidx.fragment.app.e activity;
        int i;
        String str;
        int i3;
        int i2;
        int i4;
        androidx.fragment.app.e obj8;
        boolean obj9;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        int i5 = 0;
        if (obj8 instanceof a0) {
        } else {
            obj8 = i5;
        }
        if (obj8 == null) {
        } else {
            obj8.p0();
        }
        if (E1().V()) {
            E1().Q();
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.H(activity, 0, "lesson", 0, 5, 0);
            }
        }
        if (E1().G()) {
            obj8 = getActivity();
            if (obj8 == null) {
            } else {
                obj9 = new k(D1().getTag(), i5, 2, i5);
                g1.n(obj8, obj9);
            }
            E1().S();
        }
        e eVar = new e(this);
        getSharedViewModel().E().observe(getViewLifecycleOwner(), eVar);
        obj9 = getViewLifecycleOwner();
        String str3 = "viewLifecycleOwner";
        n.e(obj9, str3);
        g gVar = new g(this);
        E1().I().observe(obj9, gVar);
        obj9 = getViewLifecycleOwner();
        n.e(obj9, str3);
        f fVar = new f(this);
        E1().H().observe(obj9, fVar);
        E1().O();
    }

    @Override // androidx.fragment.app.Fragment
    public void p1() {
        E1().s0();
        g gVar = new g(D1().getTag());
        g1.n(getActivity(), gVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void r0(DogProfile dogProfile) {
        androidx.fragment.app.e activity;
        int i;
        Object obj3;
        n.f(dogProfile, "profile");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.w0(dogProfile.getId(), 11103);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void s() {
        E1().h0();
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.p(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void u0(yi yi) {
        n.f(yi, "tooltip");
        E1().g0();
        E1().Y();
        h hVar = new h(D1().getTag());
        g1.n(getActivity(), hVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void u1(String string) {
        Object iVar;
        int str;
        String str2;
        int i3;
        int i;
        int i2;
        int i4;
        int i5;
        h hVar;
        n.f(string, "action");
        E1().i0(string);
        androidx.fragment.app.e obj10 = getActivity();
        if (obj10 == null) {
        } else {
            i3 = 0;
            iVar = new i("dashboard", i3, 2, i3);
            g1.n(obj10, iVar);
        }
        obj10 = getActivity();
        if (obj10 == null) {
        } else {
            super("dashboard", 0, 0, 0, 0, 30, 0);
            g1.n(obj10, hVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void x0(String string) {
        Object mVar;
        String str;
        n.f(string, "programId");
        final androidx.fragment.app.e obj3 = getActivity();
        if (obj3 == null) {
        } else {
            mVar = new m("dashboard");
            g1.n(obj3, mVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y0(ProgramLessonItem programLessonItem) {
        int lessonId;
        n.f(programLessonItem, "lessonItem");
        E1().f0(programLessonItem.getProgramSaveInfo().getLessonId());
        ProgramLessonItem.LessonPositionData nextLessonPositionData = programLessonItem.getNextLessonPositionData();
        if (nextLessonPositionData == null) {
            lessonId = 0;
        } else {
            lessonId = nextLessonPositionData.getLessonId();
        }
        super(lessonId, programLessonItem.getProgramSaveInfo().getProgramId(), D1().getTag(), 0, 0, 24, 0);
        g1.n(getActivity(), obj11);
    }
}
