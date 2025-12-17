package app.dogo.com.dogo_android.y.u;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.of;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.o.w;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlin.y.p;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001d2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0008\u0010&\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonExamUnlockedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedViewModel;", "viewModel$delegate", "goToExamList", "", "goToNextScreen", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpExamsText", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends Fragment {

    private of a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {

        final app.dogo.com.dogo_android.y.u.d this$0;
        a(app.dogo.com.dogo_android.y.u.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            Object obj2;
            n.f(d, "$this$addCallback");
            obj2 = d.B1(this.this$0).b();
            app.dogo.com.dogo_android.y.u.d this$0 = this.this$0;
            if (obj2 != null) {
                d.C1(this$0, obj2);
            } else {
                obj2 = this$0.getActivity();
                if (obj2 == null) {
                } else {
                    g1.O(obj2);
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<TrickItem, java.lang.CharSequence> {

        public static final app.dogo.com.dogo_android.y.u.d.b a;
        static {
            d.b bVar = new d.b();
            d.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(TrickItem trickItem) {
            n.f(trickItem, "it");
            return trickItem.getName();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((TrickItem)object);
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
    public static final class d extends p implements a<app.dogo.com.dogo_android.y.u.f> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.u.f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.y.u.d this$0;
        e(app.dogo.com.dogo_android.y.u.d d) {
            this.this$0 = d;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(Boolean.valueOf(d.B1(this.this$0).e()), d.B1(this.this$0).f().getLessonId());
        }
    }
    static {
    }

    public d() {
        super();
        d.e eVar = new d.e(this);
        final int i = 0;
        d.d dVar = new d.d(this, i, eVar);
        this.b = j.a(m.SYNCHRONIZED, dVar);
        d.c cVar = new d.c(this, i, i);
        this.c = j.a(m.NONE, cVar);
    }

    public static final app.dogo.com.dogo_android.y.u.e B1(app.dogo.com.dogo_android.y.u.d d) {
        return d.D1();
    }

    public static final void C1(app.dogo.com.dogo_android.y.u.d d, j j2) {
        d.G1(j2);
    }

    private final app.dogo.com.dogo_android.y.u.e D1() {
        return (e)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.u.f E1() {
        return (f)this.b.getValue();
    }

    private final void F1() {
        String fragmentReturnTag;
        androidx.fragment.app.e activity;
        String fragmentReturnTag2;
        j jVar;
        int i;
        int i4;
        int i6;
        String str;
        int i2;
        int i5;
        int i3;
        jVar = D1().b();
        if (jVar == null) {
            fragmentReturnTag = 0;
        } else {
            fragmentReturnTag = jVar.getTag();
        }
        if (fragmentReturnTag == null) {
            fragmentReturnTag = D1().getFragmentReturnTag();
        }
        if (jVar != null) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.f(activity, D1().getFragmentReturnTag(), jVar, false, 4, 0);
            }
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 == null) {
        } else {
            super(D1().f(), fragmentReturnTag, "lesson_exam_unlocked", 0, 8, 0);
            g1.n(activity2, fragmentReturnTag2);
        }
    }

    private final void G1(j j) {
        app.dogo.com.dogo_android.y.u.e activity;
        androidx.fragment.app.e activity2;
        String fragmentReturnTag;
        j jVar;
        int i2;
        int i;
        int i3;
        if (D1().a()) {
            activity2 = getActivity();
            if (activity2 == null) {
            } else {
                g1.f(activity2, D1().getFragmentReturnTag(), j, false, 4, 0);
            }
        } else {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.n(activity, j);
            }
        }
    }

    public static void H1(app.dogo.com.dogo_android.y.u.d d, View view2) {
        d.M1(d, view2);
    }

    public static void I1(app.dogo.com.dogo_android.y.u.d d, View view2) {
        d.K1(d, view2);
    }

    public static void J1(app.dogo.com.dogo_android.y.u.d d, View view2) {
        d.L1(d, view2);
    }

    private static final void K1(app.dogo.com.dogo_android.y.u.d d, View view2) {
        n.f(d, "this$0");
        d.E1().i();
        final androidx.fragment.app.e obj0 = d.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void L1(app.dogo.com.dogo_android.y.u.d d, View view2) {
        n.f(d, "this$0");
        d.E1().n();
        d.F1();
    }

    private static final void M1(app.dogo.com.dogo_android.y.u.d d, View view2) {
        n.f(d, "this$0");
        d.E1().m();
        g1.n(d.getActivity(), l.H(d.getSharedViewModel(), "lesson_exam_unlocked", d.D1().getTag(), false, 0, 12, 0));
    }

    private final void N1() {
        int value;
        String str2;
        java.util.List list;
        String str3;
        String str4;
        String str;
        int i;
        int i3;
        app.dogo.com.dogo_android.y.u.d.b bVar;
        int i2;
        int i4;
        final int i5 = 0;
        if (value instanceof y.c) {
        } else {
            value = i5;
        }
        if (value == null) {
            list = i5;
        } else {
        }
        if (list == null) {
            str2 = i5;
        } else {
            str2 = p.h0(list, "”, “", "“", "”", 0, 0, d.b.a, 24, 0);
        }
        Object[] arr = new Object[1];
        String string = getResources().getString(2131886532, str2);
        n.e(string, "resources.getString(R.string.exam_is_unlocked, text)");
        of ofVar = this.a;
        if (ofVar == null) {
        } else {
            ofVar.O.setText(string);
        }
        n.w("binding");
        throw i5;
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        of obj2 = of.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(E1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    return obj2.w();
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
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        d.a aVar = new d.a(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, aVar, 2, 0);
        N1();
        of obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            b bVar = new b(this);
            obj7.Q.setOnClickListener(bVar);
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                c cVar = new c(this);
                obj7.T.setOnClickListener(cVar);
                obj7 = this.a;
                if (obj7 == null) {
                } else {
                    obj8 = new a(this);
                    obj7.S.setOnClickListener(obj8);
                    E1().j();
                }
                n.w(str2);
                throw obj8;
            }
            n.w(str2);
            throw obj8;
        }
        n.w(str2);
        throw obj8;
    }
}
