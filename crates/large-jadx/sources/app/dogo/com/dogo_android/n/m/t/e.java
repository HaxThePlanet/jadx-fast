package app.dogo.com.dogo_android.n.m.t;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.h.gg;
import app.dogo.com.dogo_android.n.m.n;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.n.m.u.m;
import app.dogo.com.dogo_android.r.k;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.t.i0.b;
import app.dogo.com.dogo_android.u.m.w;
import app.dogo.com.dogo_android.util.customview.TrickRatingBar;
import app.dogo.com.dogo_android.util.customview.TrickRatingBar.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.g.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.m0.b;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m;
import app.dogo.com.dogo_android.x.b.c;
import app.dogo.com.dogo_android.x.d.c;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.r.d;
import app.dogo.com.dogo_android.y.s.k;
import app.dogo.com.dogo_android.y.u.e;
import f.d.a.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.y.p;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickFragment2;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentRateTrickV2Binding;", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickScreen2;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2;", "viewModel$delegate", "continueProgramTrainingFlow", "", "continueTrickFlow", "rateResults", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults;", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupProgramScreenChain", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$ProgramPlan;", "setupTimeMetricsScreenChain", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends b<gg, app.dogo.com.dogo_android.n.m.t.f> {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/tricks/rate/RateTrickFragment2$onViewCreated$4", "Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "onRatingClick", "", "newRating", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements TrickRatingBar.a {

        final app.dogo.com.dogo_android.n.m.t.e a;
        b(app.dogo.com.dogo_android.n.m.t.e e) {
            this.a = e;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.customview.TrickRatingBar$a
        public void a(int i) {
            this.a.I1().v().postValue(Integer.valueOf(i));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public c(Fragment fragment, a a2, a a3) {
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
    public static final class d extends p implements a<app.dogo.com.dogo_android.n.m.t.g> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.n.m.t.g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.n.m.t.e this$0;
        e(app.dogo.com.dogo_android.n.m.t.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[4];
            String str = "trick_details";
            return b.b((f)this.this$0.C1().b(), (f)this.this$0.C1().a(), str, Long.valueOf((f)this.this$0.C1().c()));
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, gg> {

        public static final app.dogo.com.dogo_android.n.m.t.e.a a;
        static {
            e.a aVar = new e.a();
            e.a.a = aVar;
        }

        a() {
            super(3, gg.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentRateTrickV2Binding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final gg l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return gg.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public e() {
        super(e.a.a);
        final int i = 0;
        e.c cVar = new e.c(this, i, i);
        this.v = j.a(m.NONE, cVar);
        e.e eVar = new e.e(this);
        e.d dVar = new e.d(this, i, eVar);
        this.w = j.a(m.SYNCHRONIZED, dVar);
    }

    private final void G1() {
        m mVar = new m((f)C1().b().d(), (f)C1().getFragmentParentReturnTag(), (f)C1().getFragmentParentReturnTag(), "lesson");
        g1.n(getActivity(), mVar);
    }

    private final void H1(app.dogo.com.dogo_android.n.m.t.g.a g$a) {
        androidx.fragment.app.e activity;
        Object fragmentParentReturnTag;
        int i;
        String tag;
        String fragmentParentReturnTag2;
        boolean obj6;
        n nVar = (f)C1().b();
        fragmentParentReturnTag = new ArrayList();
        fragmentParentReturnTag.addAll(Q1(a));
        if (nVar instanceof n.b) {
            fragmentParentReturnTag.addAll(P1((n.b)nVar));
        }
        activity = 0;
        i = 1;
        if (n.b((f)C1().getFragmentParentReturnTag(), j3.U0.a()) && I1().I()) {
            obj6 = I1().I() ? i : activity;
        } else {
        }
        if (obj6 != null) {
            obj6 = new k((f)C1().getTag(), (f)C1().getFragmentParentReturnTag());
            fragmentParentReturnTag.add(obj6);
        }
        if (fragmentParentReturnTag.size() > i) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.n(activity, (j)p.X(g.Companion.a(fragmentParentReturnTag)));
            }
        } else {
            if (fragmentParentReturnTag.size() == i) {
                obj6 = getActivity();
                if (obj6 == null) {
                } else {
                    g1.n(obj6, (j)p.X(fragmentParentReturnTag));
                }
            } else {
                obj6 = getActivity();
                if (obj6 == null) {
                } else {
                    g1.d(obj6, (f)C1().getFragmentParentReturnTag(), activity, 2, 0);
                }
            }
        }
    }

    public static void J1(app.dogo.com.dogo_android.n.m.t.e e, Long long2) {
        e.N1(e, long2);
    }

    public static void K1(app.dogo.com.dogo_android.n.m.t.e e, app.dogo.com.dogo_android.n.m.t.g.a g$a2) {
        e.O1(e, a2);
    }

    public static void L1(app.dogo.com.dogo_android.n.m.t.e e, View view2) {
        e.M1(e, view2);
    }

    private static final void M1(app.dogo.com.dogo_android.n.m.t.e e, View view2) {
        n.f(e, "this$0");
        final androidx.fragment.app.e obj0 = e.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void N1(app.dogo.com.dogo_android.n.m.t.e e, Long long2) {
        Object bVar;
        long longValue;
        n.f(e, "this$0");
        final androidx.fragment.app.e obj3 = e.getActivity();
        if (obj3 == null) {
        } else {
            n.e(long2, "articleId");
            bVar = new b(long2.longValue(), obj2);
            g1.q(obj3, bVar);
        }
    }

    private static final void O1(app.dogo.com.dogo_android.n.m.t.e e, app.dogo.com.dogo_android.n.m.t.g.a g$a2) {
        Object str;
        n.f(e, "this$0");
        if ((f)e.C1().b().b() != null) {
            e.G1();
        } else {
            n.e(a2, "it");
            e.H1(a2);
        }
    }

    private final List<j> P1(n.b n$b) {
        Object value;
        int illegalStateException;
        boolean z;
        boolean programId;
        e lessonId;
        Object fragmentParentReturnTag;
        String fragmentParentReturnTag2;
        int i;
        int i2;
        k obj9;
        ArrayList arrayList = new ArrayList();
        if (I1().J(b.h().getProgramId())) {
            illegalStateException = b.a();
            if (illegalStateException != null) {
                programId = new w("variations_unlocked", illegalStateException, b.c(), (f)C1().getFragmentParentReturnTag());
                arrayList.add(programId);
            }
        } else {
            if (getSharedViewModel().m0()) {
                if (getSharedViewModel().n0()) {
                    getSharedViewModel().h0();
                    lessonId = 0;
                    if (value instanceof y.c) {
                    } else {
                        value = lessonId;
                    }
                    if (value == null) {
                        illegalStateException = lessonId;
                    } else {
                    }
                    if (illegalStateException != null) {
                        lessonId = new d(illegalStateException, b.h(), (f)C1().a(), (f)C1().getFragmentParentReturnTag());
                    } else {
                        illegalStateException = new IllegalStateException("No exam found in session object");
                        a.d(illegalStateException);
                    }
                } else {
                    lessonId = new e(b.h(), getSharedViewModel().L(), (f)C1().getFragmentParentReturnTag());
                }
                if (lessonId != null) {
                    arrayList.add(lessonId);
                }
            }
        }
        if (b.g()) {
            super(b.h().getLessonId(), b.h().getProgramId(), (f)C1().getFragmentParentReturnTag(), 0, 0);
            arrayList.add(obj9);
        }
        return arrayList;
    }

    private final List<j> Q1(app.dogo.com.dogo_android.n.m.t.g.a g$a) {
        String source;
        int fragmentParentReturnTag2;
        boolean todayGoalAchieved;
        int fragmentParentReturnTag;
        c cVar;
        String str;
        Object obj7;
        ArrayList arrayList = new ArrayList();
        if (a instanceof g.a.b) {
            if (!getSharedViewModel().Q() && a.b().isTodayGoalAchieved()) {
                if (a.b().isTodayGoalAchieved()) {
                } else {
                    fragmentParentReturnTag2 = 0;
                }
            } else {
            }
            DogProfile dogProfile = getSharedViewModel().I();
            if (dogProfile == null) {
                fragmentParentReturnTag = cVar;
            } else {
                fragmentParentReturnTag = dogProfile.getName();
            }
            if (fragmentParentReturnTag == 0) {
                n.e(getString(2131887192), "getString(R.string.reminder_daily_training_your_dog)");
            }
            if (fragmentParentReturnTag2 != 0) {
                cVar = new c(a.b(), fragmentParentReturnTag, (f)C1().getSource(), (f)C1().getFragmentParentReturnTag());
            } else {
                if (todayGoalAchieved2 ^= fragmentParentReturnTag2 != 0) {
                    Object value = I1().v().getValue();
                    n.d(value);
                    cVar = new c((f)C1().getSource(), p.b(value), a.b(), (f)C1().getFragmentParentReturnTag());
                }
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return getSharedViewModel();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return I1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.n.m.t.g I1() {
        return (g)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public l getSharedViewModel() {
        return (l)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onAttach(Context context) {
        androidx.fragment.app.e obj2;
        n.f(context, "context");
        super.onAttach(context);
        if (obj2 instanceof a0) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2.F();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        c obj4 = new c(this);
        obj3.S.setNavigationOnClickListener(obj4);
        obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        a aVar = new a(this);
        I1().x().observe(obj4, aVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        b bVar = new b(this);
        I1().t().observe(obj4, bVar);
        obj4 = new e.b(this);
        obj3.U.setOnClickEventListener(obj4);
        obj3.U.setInitialRating(I1().u());
    }
}
