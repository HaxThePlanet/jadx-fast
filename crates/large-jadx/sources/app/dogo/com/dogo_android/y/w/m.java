package app.dogo.com.dogo_android.y.w;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.c.a;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.qf;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.n;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.n.i;
import app.dogo.com.dogo_android.y.o.w;
import app.dogo.com.dogo_android.y.s.k;
import app.dogo.com.dogo_android.y.y.g;
import f.c.a.e.s.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010*\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonsListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListViewModel;", "viewModel$delegate", "listLoaded", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onExamItemPressed", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onItemSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "onLockedItemPressed", "activeLessonIndex", "", "onViewCreated", "view", "showLessonIntroduction", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends Fragment implements app.dogo.com.dogo_android.y.w.l.b {

    public static final app.dogo.com.dogo_android.y.w.m.a Companion;
    private qf a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListFragment$Companion;", "", "()V", "LESSON_LIST_ITEM_NUMBER_FOR_POP_UP_SHOW", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public b(Fragment fragment, a a2, a a3) {
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
    public static final class c extends p implements a<app.dogo.com.dogo_android.y.w.o> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.w.o invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(o.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.y.w.m this$0;
        d(app.dogo.com.dogo_android.y.w.m m) {
            this.this$0 = m;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(m.B1(this.this$0).e());
        }
    }
    static {
        m.a aVar = new m.a(0);
        m.Companion = aVar;
    }

    public m() {
        super();
        final int i = 0;
        m.b bVar = new m.b(this, i, i);
        this.b = j.a(m.NONE, bVar);
        m.d dVar = new m.d(this);
        m.c cVar = new m.c(this, i, dVar);
        this.c = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final app.dogo.com.dogo_android.y.w.n B1(app.dogo.com.dogo_android.y.w.m m) {
        return m.C1();
    }

    private final app.dogo.com.dogo_android.y.w.n C1() {
        return (n)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.w.o D1() {
        return (o)this.c.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        m.L1(m, view2);
    }

    public static void F1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        m.K1(m, view2);
    }

    public static void G1(app.dogo.com.dogo_android.y.w.m m, DialogInterface dialogInterface2, int i3) {
        m.J1(m, dialogInterface2, i3);
    }

    public static void H1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        m.M1(m, view2);
    }

    public static void I1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        m.N1(m, view2);
    }

    private static final void J1(app.dogo.com.dogo_android.y.w.m m, DialogInterface dialogInterface2, int i3) {
        n.f(m, "this$0");
        m.D1().y();
        g1.n(m.getActivity(), l.H(m.getSharedViewModel(), "program_lesson_list", m.C1().getTag(), false, 0, 12, 0));
    }

    private static final void K1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        n.f(m, "this$0");
        final androidx.fragment.app.e obj0 = m.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void L1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        n.f(m, "this$0");
        g gVar = new g(m.C1().getFragmentParentReturnTag(), m.C1().c());
        g1.f(m.getActivity(), m.C1().getFragmentParentReturnTag(), gVar, false, 4, 0);
    }

    private static final void M1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        l sharedViewModel;
        String str;
        String tag;
        int i;
        int i4;
        int i2;
        int i3;
        Object obj7;
        Object obj8;
        n.f(m, "this$0");
        if (m.getSharedViewModel().I() != null) {
            g1.n(m.getActivity(), l.H(m.getSharedViewModel(), "program_lesson_list", m.C1().getTag(), false, 0, 12, 0));
        }
    }

    private static final void N1(app.dogo.com.dogo_android.y.w.m m, View view2) {
        Object value;
        i iVar2;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary examSumamry;
        String str;
        String str2;
        int i;
        int i3;
        int i2;
        i iVar;
        Object obj9;
        Object obj10;
        n.f(m, "this$0");
        obj10 = m.getSharedViewModel().I();
        if (obj10 == null) {
        } else {
            if (value instanceof y.c) {
            } else {
                value = 0;
            }
            if (value == null) {
            } else {
                value = value.a();
                if ((Program)value == null) {
                } else {
                    super((Program)value.getExamSumamry(), j1.w0(obj10.getName()), "program_lesson_list", 0, 8, 0);
                    g1.n(m.getActivity(), iVar);
                }
            }
        }
    }

    private final void O1() {
        boolean bundle;
        c lESSON_INTRODUCTION_DIALOG;
        if (!D1().m()) {
            D1().s();
            D1().w();
            bundle = new Bundle();
            k1.e(this, c.LESSON_INTRODUCTION_DIALOG, bundle);
        }
    }

    private final l getSharedViewModel() {
        return (l)this.b.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void W0(int i) {
        D1().x();
        b bVar = new b(requireContext());
        f0 f0Var = f0.a;
        String string = getString(2131887589);
        n.e(string, "getString(R.string.training_program_lesson_locked_alert)");
        int i6 = 1;
        final Object[] arr = new Object[i6];
        arr[0] = Integer.valueOf(i);
        String obj6 = String.format(string, Arrays.copyOf(arr, i6));
        n.e(obj6, "java.lang.String.format(format, *args)");
        h hVar = new h(this);
        bVar.x(obj6).D(2131887097, hVar).A(2131886691, 0).o();
    }

    @Override // androidx.fragment.app.Fragment
    public void d0(ProgramLesson programLesson) {
        boolean premiumLocked;
        boolean lessonUnlocked;
        int itemNumber;
        app.dogo.com.dogo_android.y.w.n sharedViewModel;
        int nVar;
        Object str;
        String lessonId;
        String programId;
        String fragmentParentReturnTag;
        boolean i2;
        boolean i;
        Object obj9;
        n.f(programLesson, "item");
        if (getSharedViewModel().I() != null) {
            if (C1().f() && programLesson.isPremiumLocked()) {
                if (programLesson.isPremiumLocked()) {
                    g1.n(getActivity(), l.H(getSharedViewModel(), "program_lesson_list", C1().getTag(), false, 0, 12, 0));
                } else {
                    if (programLesson.isLessonUnlocked() && programLesson.getItemNumber() == 2 && D1().v()) {
                        if (programLesson.getItemNumber() == 2) {
                            if (D1().v()) {
                                D1().t();
                                itemNumber = getActivity();
                                if (itemNumber == null) {
                                } else {
                                    nVar = new n(q2.a.LESSON_LIST_SECOND_ITEM.getTag());
                                    g1.X(itemNumber, nVar);
                                }
                            }
                        }
                        super(programLesson.getProgramSaveInfo().getLessonId(), programLesson.getProgramSaveInfo().getProgramId(), C1().getFragmentParentReturnTag(), C1().c(), C1().d());
                        g1.n(getActivity(), obj9);
                    }
                    O1();
                }
            } else {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h() {
        D1().u(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        qf obj2 = qf.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.X(D1());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.W(Boolean.valueOf(z ^= 1));
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2.V(this);
                        obj2 = this.a;
                        if (obj2 == null) {
                        } else {
                            return obj2.W;
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
    public void onViewCreated(View view, Bundle bundle2) {
        int i;
        androidx.fragment.app.e obj3;
        boolean obj4;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        D1().r();
        obj3 = this.a;
        obj4 = "binding";
        i = 0;
        if (obj3 == null) {
        } else {
            g gVar = new g(this);
            obj3.Y.setNavigationOnClickListener(gVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                f fVar = new f(this);
                obj3.P.setOnClickListener(fVar);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    i iVar = new i(this);
                    obj3.Z.setOnClickListener(iVar);
                    obj3 = this.a;
                    if (obj3 == null) {
                    } else {
                        obj4 = new j(this);
                        obj3.O.w().setOnClickListener(obj4);
                        if (!D1().q()) {
                            obj3 = getActivity();
                            if (obj3 instanceof a0) {
                                i = obj3;
                            }
                            if (i == 0) {
                            } else {
                                i.F();
                            }
                        } else {
                            obj3 = getActivity();
                            if (obj3 instanceof a0) {
                                i = obj3;
                            }
                            if (i == 0) {
                            } else {
                                i.p0();
                            }
                        }
                    }
                    n.w(obj4);
                    throw i;
                }
                n.w(obj4);
                throw i;
            }
            n.w(obj4);
            throw i;
        }
        n.w(obj4);
        throw i;
    }

    @Override // androidx.fragment.app.Fragment
    public void z1(ProgramSaveInfo programSaveInfo) {
        n.f(programSaveInfo, "saveInfo");
        super(programSaveInfo, C1().getTag(), "lesson", 0, 8, 0);
        g1.n(getActivity(), wVar2);
    }
}
