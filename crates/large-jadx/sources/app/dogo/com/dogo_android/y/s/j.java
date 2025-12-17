package app.dogo.com.dogo_android.y.s;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.if;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import app.dogo.com.dogo_android.y.a0.g;
import app.dogo.com.dogo_android.y.b0.d;
import app.dogo.com.dogo_android.y.c0.e;
import app.dogo.com.dogo_android.y.d0.m;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.t.c;
import app.dogo.com.dogo_android.y.w.n;
import app.dogo.com.dogo_android.y.y.g;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0016J\u0008\u0010*\u001a\u00020\"H\u0016J\u0018\u0010+\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0008\u0010/\u001a\u00020\"H\u0002J\u0008\u00100\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonViewModel;", "viewModel$delegate", "isLessonNotPassed", "", "lessonStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFullProgramListSelected", "", "nextLessonId", "", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onQuestionCardSelected", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "onResume", "onTaskCardSelected", "onTrainingCardSelected", "onViewCreated", "view", "returnToParent", "setupNavigation", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends Fragment implements app.dogo.com.dogo_android.y.s.i.a {

    private if a;
    private final h b;
    private final h c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramQuestion.Type.ANSWERED.ordinal()] = 1;
            j.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.y.s.j this$0;
        b(app.dogo.com.dogo_android.y.s.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.B1(this.this$0).u();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.y.s.j this$0;
        c(app.dogo.com.dogo_android.y.s.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = this.this$0.getActivity();
            if (activity == null) {
            } else {
                activity.onBackPressed();
            }
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
    public static final class e extends p implements a<app.dogo.com.dogo_android.y.s.l> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.s.l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public j() {
        super();
        final int i = 0;
        j.e eVar = new j.e(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, eVar);
        j.d dVar = new j.d(this, i, i);
        this.c = j.a(m.NONE, dVar);
    }

    public static final app.dogo.com.dogo_android.y.s.l B1(app.dogo.com.dogo_android.y.s.j j) {
        return j.D1();
    }

    private final app.dogo.com.dogo_android.y.s.k C1() {
        return (k)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.s.l D1() {
        return (l)this.b.getValue();
    }

    private final boolean E1(ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus) {
        ProgramLessonItem.ProgramLessonStatus nOT_STARTED;
        int obj2;
        if (programLessonStatus != ProgramLessonItem.ProgramLessonStatus.STARTED) {
            if (programLessonStatus == ProgramLessonItem.ProgramLessonStatus.NOT_STARTED) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public static void F1(app.dogo.com.dogo_android.y.s.j j, y y2) {
        j.N1(j, y2);
    }

    public static void G1(app.dogo.com.dogo_android.y.s.j j, ProgramLessonItem programLessonItem2) {
        j.O1(j, programLessonItem2);
    }

    public static void H1(app.dogo.com.dogo_android.y.s.j j, View view2) {
        j.J1(j, view2);
    }

    public static void I1(app.dogo.com.dogo_android.y.s.j j, y y2) {
        j.K1(j, y2);
    }

    private static final void J1(app.dogo.com.dogo_android.y.s.j j, View view2) {
        n.f(j, "this$0");
        final androidx.fragment.app.e obj0 = j.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void K1(app.dogo.com.dogo_android.y.s.j j, y y2) {
        boolean bVar;
        app.dogo.com.dogo_android.y.s.j.c cVar;
        String str;
        Object obj4;
        n.f(j, "this$0");
        if (y2 instanceof y.a) {
            Exception exception = new Exception((y.a)y2.a());
            obj4 = j.requireContext();
            n.e(obj4, "requireContext()");
            bVar = new j.b(j);
            cVar = new j.c(j);
            f1.m0(j, n.a.i(exception, obj4), bVar, cVar);
        }
    }

    private final void L1() {
        androidx.fragment.app.e activity;
        Object fragmentParentReturnTag;
        int i;
        final int i3 = 0;
        final int i4 = 0;
        if (z ^= 1 != 0) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.d(activity, C1().getFragmentParentReturnTag(), i3, 2, i4);
            }
        } else {
            fragmentParentReturnTag = new g(i4, i3, 3, i4);
            g1.b(getActivity(), fragmentParentReturnTag);
        }
    }

    private final void M1() {
        e eVar = new e(this);
        getSharedViewModel().E().observe(getViewLifecycleOwner(), eVar);
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, "viewLifecycleOwner");
        f fVar = new f(this);
        D1().t().observe(viewLifecycleOwner2, fVar);
    }

    private static final void N1(app.dogo.com.dogo_android.y.s.j j, y y2) {
        boolean z;
        String str;
        Object obj2;
        Object obj3;
        n.f(j, "this$0");
        obj3 = j.getSharedViewModel().I();
        if (obj3 == null) {
        } else {
            if (j.D1().r(obj3.getId())) {
                j.L1();
            } else {
                j.D1().v(obj3.getId(), j.C1().e(), j.C1().f());
            }
        }
    }

    private static final void O1(app.dogo.com.dogo_android.y.s.j j, ProgramLessonItem programLessonItem2) {
        n.f(j, "this$0");
        n.e(programLessonItem2, "it");
        c cVar = new c(programLessonItem2, j.C1().getFragmentParentReturnTag(), j.C1().c(), j.C1().d());
        g1.o(j.getActivity(), cVar);
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void K(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo2) {
        androidx.fragment.app.e activity;
        j jVar;
        ProgramQuestion question;
        Object obj;
        String tag;
        int i4;
        int i3;
        int i;
        int i2;
        j dVar;
        app.dogo.com.dogo_android.y.s.k obj11;
        n.f(programLessonItem, "lessonItem");
        n.f(programSaveInfo2, "programSaveInfo");
        if (j.a.a[programLessonItem.getQuestion().getType().ordinal()] == 1) {
            super(programLessonItem.getQuestion(), programSaveInfo2, C1().getTag(), 0, 0, 24, 0);
            g1.n(getActivity(), dVar);
        } else {
            super(programLessonItem.getQuestion(), programSaveInfo2, C1().getTag(), 0, 0, 24, 0);
            g1.n(getActivity(), dVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void b1(ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus, String string2, ProgramSaveInfo programSaveInfo3) {
        n nVar;
        int i;
        String programId;
        boolean z2;
        boolean z;
        String fragmentParentReturnTag;
        int i2;
        int i3;
        boolean obj9;
        n obj10;
        n.f(programLessonStatus, "lessonStatus");
        n.f(programSaveInfo3, "programSaveInfo");
        D1().y(programLessonStatus);
        if (getSharedViewModel().I() == null) {
        } else {
            if (E1(programLessonStatus) && D1().x()) {
                if (D1().x()) {
                    App.Companion.r().d(q0.c.h());
                    obj9 = getActivity();
                    if (obj9 == null) {
                    } else {
                        f1.d0(obj9, 2131887586);
                    }
                } else {
                    super(0, programSaveInfo3.getProgramId(), C1().c(), C1().d(), C1().getFragmentParentReturnTag(), 1, 0);
                    g1.n(getActivity(), obj10);
                }
            } else {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h1(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo2) {
        n.f(programLessonItem, "lessonItem");
        n.f(programSaveInfo2, "programSaveInfo");
        e eVar = new e(programLessonItem.getTasks(), programSaveInfo2);
        g1.n(getActivity(), eVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void n1(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo2) {
        n.f(programLessonItem, "lessonItem");
        n.f(programSaveInfo2, "programSaveInfo");
        super(programLessonItem.getTrainingSession(), programSaveInfo2, C1().getTag(), 0, 8, 0);
        g1.n(getActivity(), mVar2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        if obj2 = if.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(getSharedViewModel());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.X(D1());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
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
        if obj2 = this.a;
        if (obj2 == null) {
        } else {
            g obj3 = new g(this);
            obj2.P.setNavigationOnClickListener(obj3);
            M1();
            h hVar = new h(this);
            D1().getResult().observe(getViewLifecycleOwner(), hVar);
        }
        n.w("binding");
        throw 0;
    }
}
