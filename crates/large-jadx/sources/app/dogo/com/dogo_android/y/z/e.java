package app.dogo.com.dogo_android.y.z;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.h.uf;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.subscription.SubscriptionScreenKey;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.a0.g;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.s.k;
import app.dogo.com.dogo_android.y.w.n;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0014\u001a\u00020\u0015H\u0082Pø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0008\u0010(\u001a\u00020\u0015H\u0016J\u001a\u0010)\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0008\u0010*\u001a\u00020\u0015H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewViewModel;", "viewModel$delegate", "autoScrollFeaturesList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFullViewVisible", "", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "showLessonIntroduction", "startLessonFlow", "lessonId", "", "startQuestionFlow", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends Fragment {

    public static final app.dogo.com.dogo_android.y.z.e.a Companion;
    private uf a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewFragment$Companion;", "", "()V", "DELAY_BETWEEN_SCROLL_MS", "", "DIRECTION_RIGHT", "", "SCROLL_DX", "SUBSCRIPTION_REQUEST_CODE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewFragment", f = "ProgramOverviewFragment.kt", l = 133, m = "autoScrollFeaturesList")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.y.z.e this$0;
        b(app.dogo.com.dogo_android.y.z.e e, d<? super app.dogo.com.dogo_android.y.z.e.b> d2) {
            this.this$0 = e;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return e.B1(this.this$0, this);
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
    public static final class e extends p implements a<app.dogo.com.dogo_android.y.z.g> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.z.g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<a> {

        final app.dogo.com.dogo_android.y.z.e this$0;
        f(app.dogo.com.dogo_android.y.z.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(e.C1(this.this$0).d(), e.C1(this.this$0).e());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewFragment$onViewCreated$1", f = "ProgramOverviewFragment.kt", l = 51, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.z.e this$0;
        c(app.dogo.com.dogo_android.y.z.e e, d<? super app.dogo.com.dogo_android.y.z.e.c> d2) {
            this.this$0 = e;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (e.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            e.c obj2 = new e.c(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj4;
            Object obj = b.d();
            final int label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.label = i;
            if (e.B1(this.this$0, this) == obj) {
                return obj;
            }
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.Companion = aVar;
    }

    public e() {
        super();
        e.f fVar = new e.f(this);
        final int i = 0;
        e.e eVar = new e.e(this, i, fVar);
        this.b = j.a(m.SYNCHRONIZED, eVar);
        e.d dVar = new e.d(this, i, i);
        this.c = j.a(m.NONE, dVar);
    }

    public static final Object B1(app.dogo.com.dogo_android.y.z.e e, d d2) {
        return e.D1(d2);
    }

    public static final app.dogo.com.dogo_android.y.z.f C1(app.dogo.com.dogo_android.y.z.e e) {
        return e.E1();
    }

    private final Object D1(d<? super w> d) {
        boolean bVar;
        int label;
        int i4;
        Object l$0;
        int i2;
        int i;
        boolean scrollHorizontally;
        int i3;
        Object obj7;
        bVar = d;
        label = bVar.label;
        i4 = Integer.MIN_VALUE;
        if (d instanceof e.b && label & i4 != 0) {
            bVar = d;
            label = bVar.label;
            i4 = Integer.MIN_VALUE;
            if (label & i4 != 0) {
                bVar.label = label -= i4;
            } else {
                bVar = new e.b(this, d);
            }
        } else {
        }
        obj7 = bVar.result;
        Object obj = b.d();
        int label2 = bVar.label;
        int i5 = 1;
        if (label2 != 0) {
            if (label2 != i5) {
            } else {
                l$0 = bVar.L$0;
                q.b(obj7);
                obj7 = l$0.a;
                while (obj7 != null) {
                    obj7 = obj7.Z;
                    n.e(obj7, "binding.programTricksList");
                    if (obj7.canScrollHorizontally(i5)) {
                    }
                    bVar.L$0 = l$0;
                    bVar.label = i5;
                    obj7 = l$0.a;
                    obj7.u1(5, 0);
                }
                n.w("binding");
                throw 0;
            }
            obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj7;
        }
        q.b(obj7);
        l$0 = this;
    }

    private final app.dogo.com.dogo_android.y.z.f E1() {
        return (f)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.z.g F1() {
        return (g)this.b.getValue();
    }

    public static void G1(app.dogo.com.dogo_android.y.z.e e, y y2) {
        e.K1(e, y2);
    }

    public static void H1(app.dogo.com.dogo_android.y.z.e e) {
        e.L1(e);
    }

    public static void I1(app.dogo.com.dogo_android.y.z.e e, View view2) {
        e.J1(e, view2);
    }

    private static final void J1(app.dogo.com.dogo_android.y.z.e e, View view2) {
        n.f(e, "this$0");
        e.F1().C();
        final androidx.fragment.app.e obj0 = e.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void K1(app.dogo.com.dogo_android.y.z.e e, y y2) {
        boolean z;
        boolean programStarted;
        Object obj3;
        n.f(e, "this$0");
        if (y2 instanceof y.c) {
            z = y2;
            if (e.F1().v() && !(ProgramLessonItem)(y.c)z.a().getProgramStarted()) {
                z = y2;
                if (!(ProgramLessonItem)(y.c)z.a().getProgramStarted()) {
                    e.O1((ProgramLessonItem)z.a().getProgramSaveInfo(), (ProgramLessonItem)z.a());
                } else {
                    e.N1((ProgramLessonItem)(y.c)y2.a().getProgramSaveInfo().getLessonId());
                }
            } else {
            }
        }
    }

    private static final void L1(app.dogo.com.dogo_android.y.z.e e) {
        boolean fullViewVisible;
        boolean fullViewVisible3;
        boolean fullViewVisible2;
        int str2;
        String str;
        Object obj5;
        n.f(e, "this$0");
        final int i = 1;
        str2 = 0;
        final String str4 = "binding";
        if (!e.F1().p()) {
            uf ufVar = e.a;
            if (ufVar == null) {
            } else {
                androidx.appcompat.widget.AppCompatImageView view = ufVar.Q;
                n.e(view, "binding.certificatePreview");
                if (e.isFullViewVisible(view)) {
                    e.F1().y(i);
                }
            }
            n.w(str4);
            throw str2;
        }
        if (!e.F1().q()) {
            uf ufVar2 = e.a;
            if (ufVar2 == null) {
            } else {
                android.widget.LinearLayout linearLayout = ufVar2.U;
                n.e(linearLayout, "binding.dogSkillsList");
                if (e.isFullViewVisible(linearLayout)) {
                    e.F1().z(i);
                }
            }
            n.w(str4);
            throw str2;
        }
        if (!e.F1().u()) {
            uf ufVar3 = e.a;
            if (ufVar3 == null) {
            } else {
                android.widget.LinearLayout linearLayout2 = ufVar3.g0;
                n.e(linearLayout2, "binding.userSkillsList");
                if (e.isFullViewVisible(linearLayout2)) {
                    e.F1().B(i);
                }
            }
            n.w(str4);
            throw str2;
        }
    }

    private final void M1() {
        boolean bundle;
        c lESSON_INTRODUCTION_DIALOG;
        if (!F1().r()) {
            F1().A();
            F1().D();
            bundle = new Bundle();
            k1.e(this, c.LESSON_INTRODUCTION_DIALOG, bundle);
        }
    }

    private final void N1(String string) {
        super(string, E1().d(), E1().getFragmentParentReturnTag(), E1().a(), E1().b());
        g1.n(getActivity(), kVar);
        M1();
    }

    private final void O1(ProgramSaveInfo programSaveInfo, ProgramLessonItem programLessonItem2) {
        getSharedViewModel().d0(programLessonItem2.getTrainingSession());
        super(0, programSaveInfo.getProgramId(), E1().a(), E1().b(), E1().getFragmentParentReturnTag());
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            activity.onBackPressed();
        }
        g1.n(getActivity(), nVar);
        super(programLessonItem2.getQuestion(), programSaveInfo, nVar.getTag(), 1, programLessonItem2.getTrainingSession());
        g1.n(getActivity(), gVar2);
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    private final boolean isFullViewVisible(View view) {
        Rect rect;
        int obj4;
        rect = new Rect();
        uf ufVar = this.a;
        if (ufVar == null) {
        } else {
            ufVar.b0.getDrawingRect(rect);
            float f = view.getY();
            if (Float.compare(f2, f) < 0 && Float.compare(rect, obj4) > 0) {
                obj4 = Float.compare(rect, obj4) > 0 ? 1 : 0;
            } else {
            }
            return obj4;
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        int obj1;
        int obj2;
        super.onActivityResult(i, i2, intent3);
        if (i == 1571571) {
            obj1 = "";
            if (intent3 == null) {
            } else {
                obj2 = intent3.getParcelableExtra("SCREEN_KEY");
                if ((SubscriptionScreenKey)obj2 == null) {
                } else {
                    obj2 = (SubscriptionScreenKey)obj2.getLessonId();
                    if (obj2 == null) {
                    } else {
                        obj1 = obj2;
                    }
                }
            }
            N1(obj1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        uf obj2 = uf.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(F1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.V(E1().c());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2 = obj2.a0;
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity;
        super.onResume();
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        int obj8 = 0;
        e.c cVar2 = new e.c(this, obj8);
        k.d(r.a(this), 0, 0, cVar2, 3, 0);
        uf obj9 = this.a;
        String str2 = "binding";
        if (obj9 == null) {
        } else {
            c cVar = new c(this);
            obj9.S.setOnClickListener(cVar);
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            a aVar = new a(this);
            F1().s().observe(viewLifecycleOwner, aVar);
            obj9 = this.a;
            if (obj9 == null) {
            } else {
                obj9 = new b(this);
                obj9.b0.getViewTreeObserver().addOnScrollChangedListener(obj9);
            }
            n.w(str2);
            throw obj8;
        }
        n.w(str2);
        throw obj8;
    }
}
