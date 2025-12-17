package app.dogo.com.dogo_android.u.m;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.aa;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.n.m.s.h;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.j;
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
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentBitingProgramVariationsUnlockedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goToNextScreen", "", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onVariationSelected", "variation", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u extends Fragment implements app.dogo.com.dogo_android.u.m.v.a {

    private aa a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {

        final app.dogo.com.dogo_android.u.m.u this$0;
        a(app.dogo.com.dogo_android.u.m.u u) {
            this.this$0 = u;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            Object obj2;
            n.f(d, "$this$addCallback");
            obj2 = u.B1(this.this$0).b();
            app.dogo.com.dogo_android.u.m.u this$0 = this.this$0;
            if (obj2 != null) {
                u.C1(this$0, obj2);
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

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.u.m.x> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.m.x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(x.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.u.m.u this$0;
        c(app.dogo.com.dogo_android.u.m.u u) {
            this.this$0 = u;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b((w)k1.a(this.this$0).f());
        }
    }
    static {
    }

    public u() {
        super();
        u.c cVar = new u.c(this);
        u.b bVar = new u.b(this, 0, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final app.dogo.com.dogo_android.u.m.w B1(app.dogo.com.dogo_android.u.m.u u) {
        return u.D1();
    }

    public static final void C1(app.dogo.com.dogo_android.u.m.u u, j j2) {
        u.F1(j2);
    }

    private final app.dogo.com.dogo_android.u.m.w D1() {
        return (w)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.m.x E1() {
        return (x)this.b.getValue();
    }

    private final void F1(j j) {
        app.dogo.com.dogo_android.u.m.w activity2;
        androidx.fragment.app.e activity;
        String fragmentReturnTag;
        j jVar;
        int i2;
        int i;
        int i3;
        if (D1().a()) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.f(activity, D1().getFragmentReturnTag(), j, false, 4, 0);
            }
        } else {
            activity2 = getActivity();
            if (activity2 == null) {
            } else {
                g1.n(activity2, j);
            }
        }
    }

    public static void G1(app.dogo.com.dogo_android.u.m.u u, View view2) {
        u.I1(u, view2);
    }

    public static void H1(app.dogo.com.dogo_android.u.m.u u, View view2) {
        u.J1(u, view2);
    }

    private static final void I1(app.dogo.com.dogo_android.u.m.u u, View view2) {
        n.f(u, "this$0");
        final androidx.fragment.app.e obj0 = u.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void J1(app.dogo.com.dogo_android.u.m.u u, View view2) {
        n.f(u, "this$0");
        final androidx.fragment.app.e obj0 = u.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k0(TrickItem trickItem) {
        String fragmentReturnTag;
        Object variationId;
        String fragmentReturnTag2;
        Object source;
        int i2;
        int i3;
        int i4;
        int i;
        int i5;
        int i6;
        int i7;
        n.b bVar;
        Object obj13;
        n.f(trickItem, "variation");
        E1().n(trickItem.getVariationId());
        source = D1().b();
        if (source == null) {
            fragmentReturnTag = 0;
        } else {
            fragmentReturnTag = source.getTag();
        }
        if (fragmentReturnTag == null) {
            fragmentReturnTag = D1().getFragmentReturnTag();
        }
        if (source != null) {
            variationId = getActivity();
            if (variationId == null) {
            } else {
                g1.f(variationId, D1().getFragmentReturnTag(), source, false, 4, 0);
            }
        }
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            super(p.b(trickItem), D1().e(), 0, 0, 0, 28, 0);
            fragmentReturnTag2 = new h(bVar, D1().getTag(), fragmentReturnTag, D1().getSource());
            g1.n(activity, fragmentReturnTag2);
        }
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        aa obj2 = aa.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(E1());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        u.a aVar = new u.a(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, aVar, 2, 0);
        E1().m();
        aa obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            i iVar = new i(this);
            obj7.P.setOnClickListener(iVar);
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                obj8 = new j(this);
                obj7.T.setNavigationOnClickListener(obj8);
            }
            n.w(str2);
            throw obj8;
        }
        n.w(str2);
        throw obj8;
    }
}
