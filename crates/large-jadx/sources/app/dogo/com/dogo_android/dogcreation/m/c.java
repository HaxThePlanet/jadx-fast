package app.dogo.com.dogo_android.dogcreation.m;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.dogcreation.h.f;
import app.dogo.com.dogo_android.h.qb;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
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
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0014H\u0016J\u0008\u0010\u001e\u001a\u00020\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/name/DogCreationNameFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationNameBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/name/DogCreationNameViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/name/DogCreationNameViewModel;", "viewModel$delegate", "getNameErrorMessage", "", "name", "goToNextScreen", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    private qb a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.dogcreation.m.c a;
        public a(app.dogo.com.dogo_android.dogcreation.m.c c) {
            this.a = c;
            super();
        }

        public final void onChanged(T t) {
            boolean z;
            Object obj2;
            if (t instanceof y.c) {
                c.B1(this.a).s((DogProfile)(y.c)(y)t.a().getId());
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements y<T> {

        final app.dogo.com.dogo_android.dogcreation.m.c a;
        public b(app.dogo.com.dogo_android.dogcreation.m.c c) {
            this.a = c;
            super();
        }

        public final void onChanged(T t) {
            boolean obj2;
            n.e((Boolean)t, "it");
            if (t.booleanValue()) {
                c.D1(this.a);
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<d, w> {

        final app.dogo.com.dogo_android.dogcreation.m.c this$0;
        c(app.dogo.com.dogo_android.dogcreation.m.c c) {
            this.this$0 = c;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            String str;
            boolean obj2;
            n.f(d, "$this$addCallback");
            if (!obj2 instanceof y.b) {
                obj2 = this.this$0.requireActivity();
                n.e(obj2, "requireActivity()");
                g1.O(obj2);
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<g> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public d(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements a<app.dogo.com.dogo_android.dogcreation.m.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.dogcreation.m.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public c() {
        super();
        final int i = 0;
        c.d dVar = new c.d(this, i, i);
        this.b = j.a(m.NONE, dVar);
        c.e eVar = new c.e(this, i, i);
        this.c = j.a(m.SYNCHRONIZED, eVar);
    }

    public static final g B1(app.dogo.com.dogo_android.dogcreation.m.c c) {
        return c.F1();
    }

    public static final app.dogo.com.dogo_android.dogcreation.m.e C1(app.dogo.com.dogo_android.dogcreation.m.c c) {
        return c.G1();
    }

    public static final void D1(app.dogo.com.dogo_android.dogcreation.m.c c) {
        c.H1();
    }

    private final String E1(String string) {
        String str;
        int obj2;
        obj2 = string.length() == 0 ? 1 : 0;
        if (obj2 != null) {
            n.e(getString(2131887645), "{\n            getString(R.string.user_profile_name_alert)\n        }");
        } else {
            n.e(getString(2131886467), "{\n            getString(R.string.dog_name_too_long)\n        }");
        }
        return obj2;
    }

    private final g F1() {
        return (g)this.b.getValue();
    }

    private final app.dogo.com.dogo_android.dogcreation.m.e G1() {
        return (e)this.c.getValue();
    }

    private final void H1() {
        f fVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            fVar = new f();
            g1.n(activity, fVar);
        }
    }

    public static void I1(app.dogo.com.dogo_android.dogcreation.m.c c, View view2) {
        c.L1(c, view2);
    }

    public static void J1(app.dogo.com.dogo_android.dogcreation.m.c c, View view2) {
        c.K1(c, view2);
    }

    private static final void K1(app.dogo.com.dogo_android.dogcreation.m.c c, View view2) {
        android.content.Context context;
        boolean z;
        Object obj2;
        int obj3;
        n.f(c, "this$0");
        obj3 = c.a;
        if (obj3 == null) {
        } else {
            obj3 = obj3.O.getText().toString();
            if (c.G1().r(obj3)) {
                obj2 = c.F1().l();
                if (obj2 == null) {
                } else {
                    context = obj2.getId();
                }
                c.G1().s(context, obj3);
            } else {
                Toast.makeText(c.getContext(), c.E1(obj3), 1).show();
            }
        }
        n.w("binding");
        throw 0;
    }

    private static final void L1(app.dogo.com.dogo_android.dogcreation.m.c c, View view2) {
        n.f(c, "this$0");
        final androidx.fragment.app.e obj0 = c.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        qb obj2 = qb.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(G1());
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

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        k1.c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        qb qbVar = this.a;
        if (qbVar == null) {
        } else {
            EditText editText = qbVar.O;
            n.e(editText, "binding.enterNameField");
            k1.g(this, editText);
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        c.c cVar = new c.c(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, cVar, 2, 0);
        qb obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            b bVar2 = new b(this);
            obj7.P.setOnClickListener(bVar2);
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                obj8 = new a(this);
                obj7.Q.setNavigationOnClickListener(obj8);
                obj8 = getViewLifecycleOwner();
                String str3 = "viewLifecycleOwner";
                n.e(obj8, str3);
                c.a aVar = new c.a(this);
                G1().q().observe(obj8, aVar);
                obj8 = getViewLifecycleOwner();
                n.e(obj8, str3);
                c.b bVar = new c.b(this);
                G1().o().observe(obj8, bVar);
            }
            n.w(str2);
            throw obj8;
        }
        n.w(str2);
        throw obj8;
    }
}
