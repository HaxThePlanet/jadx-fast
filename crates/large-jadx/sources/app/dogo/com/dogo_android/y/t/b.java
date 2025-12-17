package app.dogo.com.dogo_android.y.t;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.g.q;
import app.dogo.com.dogo_android.h.kf;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.w.n;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.b;
import nl.dionsegijn.konfetti.e.b;
import nl.dionsegijn.konfetti.e.c;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonCompleteBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends Fragment {

    private kf a;
    private final h b;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteFragment$onViewCreated$2", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {

        final app.dogo.com.dogo_android.y.t.b c;
        a(app.dogo.com.dogo_android.y.t.b b) {
            this.c = b;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            Object nVar;
            Object qVar;
            String fragmentReturnTag2;
            n nVar2;
            int i;
            int i5;
            int i4;
            int i3;
            String fragmentReturnTag;
            int i6;
            int i2;
            if (b.B1(this.c).a()) {
                qVar = this.c.getActivity();
                if (qVar == null) {
                } else {
                    i = 0;
                    nVar2 = nVar;
                    super(i, b.B1(this.c).c().getProgramSaveInfo().getProgramId(), 1, 0, b.B1(this.c).getFragmentReturnTag(), 9, 0);
                    g1.f(qVar, b.B1(this.c).getFragmentReturnTag(), nVar2, i, 4, 0);
                }
            } else {
                if (b.B1(this.c).b()) {
                    nVar = this.c.getActivity();
                    if (nVar == null) {
                    } else {
                        qVar = new q();
                        g1.b(nVar, qVar);
                    }
                } else {
                    nVar = this.c.getActivity();
                    if (nVar == null) {
                    } else {
                        g1.O(nVar);
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.y.t.d> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.t.d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(d.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.y.t.b this$0;
        c(app.dogo.com.dogo_android.y.t.b b) {
            this.this$0 = b;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(b.B1(this.this$0).c());
        }
    }
    static {
    }

    public b() {
        super();
        b.c cVar = new b.c(this);
        b.b bVar = new b.b(this, 0, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final app.dogo.com.dogo_android.y.t.c B1(app.dogo.com.dogo_android.y.t.b b) {
        return b.C1();
    }

    private final app.dogo.com.dogo_android.y.t.c C1() {
        return (c)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.t.d D1() {
        return (d)this.b.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.y.t.b b, View view2) {
        b.F1(b, view2);
    }

    private static final void F1(app.dogo.com.dogo_android.y.t.b b, View view2) {
        n.f(b, "this$0");
        b.D1().j();
        b.requireActivity().onBackPressed();
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
        int obj4 = 0;
        kf obj2 = kf.T(layoutInflater, viewGroup2, obj4);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        final String str = "binding";
        if (obj2 == null) {
        } else {
            obj2.w().measure(obj4, obj4);
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                return obj2.w();
            }
            n.w(str);
            throw obj3;
        }
        n.w(str);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        kf obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            obj7.V(D1());
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                obj7.M(getViewLifecycleOwner());
                obj7 = this.a;
                if (obj7 == null) {
                } else {
                    a aVar2 = new a(this);
                    obj7.O.setOnClickListener(aVar2);
                    obj7 = this.a;
                    if (obj7 == null) {
                    } else {
                        kf kfVar = this.a;
                        if (kfVar == null) {
                        } else {
                            obj8 = kfVar.R.a();
                            int i = 1;
                            int[] iArr = new int[i];
                            int i7 = a.d(requireContext(), 2131100336);
                            int i11 = 0;
                            iArr[i11] = i7;
                            obj8.a(iArr);
                            obj8.h(0, i7);
                            int i8 = 1090519040;
                            obj8.k(1084227584, i8);
                            obj8.i(i);
                            obj8.l(6000);
                            b[] arr2 = new b[i];
                            arr2[i11] = b.a;
                            obj8.b(arr2);
                            c[] arr = new c[i];
                            c cVar = new c(18, 1140457472);
                            arr[i11] = cVar;
                            obj8.c(arr);
                            int i6 = -1027080192;
                            obj8.j(0, Float.valueOf((float)obj7), i6, Float.valueOf(i6));
                            obj8.o(30, Long.MAX_VALUE);
                            D1().i();
                            b.a aVar = new b.a(this);
                            requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), aVar);
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
            n.w(str2);
            throw obj8;
        }
        n.w(str2);
        throw obj8;
    }
}
