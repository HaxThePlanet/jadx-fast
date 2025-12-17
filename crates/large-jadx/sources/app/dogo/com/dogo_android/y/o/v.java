package app.dogo.com.dogo_android.y.o;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.mf;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.n.i;
import app.dogo.com.dogo_android.y.p.d;
import app.dogo.com.dogo_android.y.x.d;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0008\u0010\u0017\u001a\u00020\u0016H\u0002J\u0008\u0010\u0018\u001a\u00020\u0016H\u0016J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\u0016H\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u00100\u001a\u00020\u0016H\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020!2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0002J\u0008\u00105\u001a\u00020\u0016H\u0002J\u0010\u00106\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonExamListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListViewModel;", "viewModel$delegate", "goBack", "", "goToCertificate", "listLoaded", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCertificatePressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onExamHistoryPressed", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "isDogPremium", "", "onLockedItemPressed", "onPremiumLockedExamPressed", "onRecordExamPressed", "onResume", "onShowExamVideoPressed", "onViewCreated", "view", "recordVideo", "setupObservers", "videoPlayback", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v extends Fragment implements app.dogo.com.dogo_android.y.o.u.b {

    private final h a;
    private final h b;
    private mf c;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final app.dogo.com.dogo_android.y.o.v this$0;
        a(app.dogo.com.dogo_android.y.o.v v) {
            this.this$0 = v;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            v.C1(this.this$0).z();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.y.o.v this$0;
        b(app.dogo.com.dogo_android.y.o.v v) {
            this.this$0 = v;
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
    public static final class d extends p implements a<app.dogo.com.dogo_android.y.o.x> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.o.x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(x.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.y.o.v this$0;
        e(app.dogo.com.dogo_android.y.o.v v) {
            this.this$0 = v;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(v.B1(this.this$0).d(), Boolean.valueOf(n.b(v.B1(this.this$0).e(), "lesson_exam_unlocked")));
        }
    }
    static {
    }

    public v() {
        super();
        final int i = 0;
        v.c cVar = new v.c(this, i, i);
        this.a = j.a(m.NONE, cVar);
        v.e eVar = new v.e(this);
        v.d dVar = new v.d(this, i, eVar);
        this.b = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final app.dogo.com.dogo_android.y.o.w B1(app.dogo.com.dogo_android.y.o.v v) {
        return v.D1();
    }

    public static final app.dogo.com.dogo_android.y.o.x C1(app.dogo.com.dogo_android.y.o.v v) {
        return v.E1();
    }

    private final app.dogo.com.dogo_android.y.o.w D1() {
        return (w)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.o.x E1() {
        return (x)this.b.getValue();
    }

    private final void F1() {
        Object name;
        i iVar2;
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        androidx.fragment.app.e activity;
        i iVar;
        final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = E1().r();
        if (programExamSummary == null) {
        } else {
            name = getSharedViewModel().I();
            if (name == null) {
            } else {
                super(programExamSummary, j1.w0(name.getName()), "lesson_exam_list", 0, 8, 0);
                g1.n(getActivity(), iVar);
            }
        }
    }

    public static void G1(app.dogo.com.dogo_android.y.o.v v, View view2) {
        v.J1(v, view2);
    }

    public static void H1(app.dogo.com.dogo_android.y.o.v v, Throwable throwable2) {
        v.N1(v, throwable2);
    }

    public static void I1(app.dogo.com.dogo_android.y.o.v v, ProgramExamList programExamList2) {
        v.M1(v, programExamList2);
    }

    private static final void J1(app.dogo.com.dogo_android.y.o.v v, View view2) {
        n.f(v, "this$0");
        v.goBack();
    }

    private final void K1(ProgramExam programExam) {
        app.dogo.com.dogo_android.model.Exam exam;
        Object obj3;
        E1().A(programExam);
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.s0(activity, E1().p(programExam), programExam.getProgramSaveInfo());
        }
    }

    private final void L1() {
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str);
        p pVar = new p(this);
        E1().q().observe(viewLifecycleOwner, pVar);
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str);
        o oVar = new o(this);
        E1().s().observe(viewLifecycleOwner2, oVar);
    }

    private static final void M1(app.dogo.com.dogo_android.y.o.v v, ProgramExamList programExamList2) {
        boolean programExamSummary2;
        d dVar;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary;
        Object obj3;
        String obj4;
        n.f(v, "this$0");
        if (v.D1().c() && programExamList2.getProgramExamSummary() != null) {
            if (programExamList2.getProgramExamSummary() != null) {
                v.D1().f(false);
                dVar = new d(programExamList2.getProgramExamSummary(), programExamList2.getDogProfile().getName(), v.D1().getTag());
                g1.o(v.getActivity(), dVar);
            }
        }
    }

    private static final void N1(app.dogo.com.dogo_android.y.o.v v, Throwable throwable2) {
        n.f(v, "this$0");
        n.e(throwable2, "it");
        v.a aVar = new v.a(v);
        v.b bVar = new v.b(v);
        f1.W(v, throwable2, aVar, bVar);
    }

    private final void O1(ProgramExam programExam) {
        androidx.fragment.app.e activity;
        app.dogo.com.dogo_android.y.o.x xVar;
        Object obj3;
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.v0(E1().p(programExam));
        }
    }

    private final l getSharedViewModel() {
        return (l)this.a.getValue();
    }

    private final void goBack() {
        requireActivity().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    public void E(ProgramExam programExam) {
        n.f(programExam, "item");
        E1().A(programExam);
        g1.n(getActivity(), l.H(getSharedViewModel(), "lesson_exam_list", D1().getTag(), false, 0, 12, 0));
    }

    @Override // androidx.fragment.app.Fragment
    public void H0() {
        F1();
    }

    @Override // androidx.fragment.app.Fragment
    public void M0(ProgramExam programExam, boolean z2) {
        n.f(programExam, "item");
        E1().E(programExam);
        E1().A(programExam);
        D1().f(n.b(programExam.getHasNewUpdates(), Boolean.TRUE));
        super(D1().d(), programExam.getName(), programExam.getTrickId(), z2, 0, 16, 0);
        g1.n(getActivity(), sVar2);
    }

    @Override // androidx.fragment.app.Fragment
    public void e1(ProgramExam programExam) {
        n.f(programExam, "item");
        E1().F(programExam);
        Toast.makeText(getContext(), 2131886544, 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void h() {
        E1().B(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void i(ProgramExam programExam) {
        int i;
        n.f(programExam, "item");
        i = programExam.getVideoUrl().length() > 0 ? 1 : 0;
        if (i != 0) {
            O1(programExam);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(ProgramExam programExam) {
        androidx.fragment.app.e activity;
        d dVar;
        app.dogo.com.dogo_android.model.Exam exam;
        n.f(programExam, "item");
        E1().G(programExam);
        E1().A(programExam);
        if (!E1().w()) {
            E1().C();
            dVar = new d(programExam, E1().p(programExam));
            g1.n(getActivity(), dVar);
        } else {
            K1(programExam);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        int obj1;
        super.onActivityResult(i, i2, intent3);
        if (i == 11102 && i2 == -1) {
            if (i2 == -1) {
                E1().x();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        mf obj2 = mf.T(getLayoutInflater(), viewGroup2, false);
        n.e(obj2, "inflate(layoutInflater, container, false)");
        this.c = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.c;
            if (obj2 == null) {
            } else {
                obj2.W(E1());
                obj2 = this.c;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.c;
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        E1().x();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        int obj3;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        mf obj2 = this.c;
        if (obj2 == null) {
        } else {
            n nVar = new n(this);
            obj2.Q.setNavigationOnClickListener(nVar);
            obj2 = getActivity();
            if (obj2 instanceof a0) {
                obj3 = obj2;
            }
            if (obj3 == null) {
            } else {
                obj3.F();
            }
            L1();
        }
        n.w("binding");
        throw 0;
    }
}
