package app.dogo.com.dogo_android.dogcreation.h;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.h.sb;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.h0.g1;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import com.theartofdev.edmodo.cropper.d;
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
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0008\u0010 \u001a\u00020\u0011H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationPictureBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarViewModel;", "viewModel$delegate", "goToNextScreen", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends Fragment {

    private sb a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {

        final app.dogo.com.dogo_android.dogcreation.h.e this$0;
        a(app.dogo.com.dogo_android.dogcreation.h.e e) {
            this.this$0 = e;
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
    public static final class b extends p implements a<g> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public b(Fragment fragment, a a2, a a3) {
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
    public static final class c extends p implements a<app.dogo.com.dogo_android.dogcreation.h.g> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.dogcreation.h.g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.dogcreation.h.e this$0;
        d(app.dogo.com.dogo_android.dogcreation.h.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object dogProfile;
            String str;
            Object[] arr = new Object[1];
            dogProfile = e.B1(this.this$0).l();
            str = "";
            if (dogProfile == null) {
            } else {
                dogProfile = dogProfile.getId();
                if (dogProfile == null) {
                } else {
                    str = dogProfile;
                }
            }
            return b.b(str);
        }
    }
    static {
    }

    public e() {
        super();
        final int i = 0;
        e.b bVar = new e.b(this, i, i);
        this.b = j.a(m.NONE, bVar);
        e.d dVar = new e.d(this);
        e.c cVar = new e.c(this, i, dVar);
        this.c = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final g B1(app.dogo.com.dogo_android.dogcreation.h.e e) {
        return e.D1();
    }

    public static final app.dogo.com.dogo_android.dogcreation.h.g C1(app.dogo.com.dogo_android.dogcreation.h.e e) {
        return e.E1();
    }

    private final g D1() {
        return (g)this.b.getValue();
    }

    private final app.dogo.com.dogo_android.dogcreation.h.g E1() {
        return (g)this.c.getValue();
    }

    private final void F1() {
        b bVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            bVar = new b();
            g1.n(activity, bVar);
        }
    }

    public static void G1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        e.L1(e, view2);
    }

    public static void H1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        e.K1(e, view2);
    }

    public static void I1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        e.N1(e, view2);
    }

    public static void J1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        e.M1(e, view2);
    }

    private static final void K1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        Object obj0;
        boolean obj1;
        n.f(e, "this$0");
        if (!obj1 instanceof y.b) {
            if (obj0 instanceof DogCreationActivity != null) {
            } else {
                obj0 = 0;
            }
            if (obj0 == null) {
            } else {
                obj0.C();
            }
        }
    }

    private static final void L1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        n.f(e, "this$0");
        final androidx.fragment.app.e obj0 = e.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void M1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        n.f(e, "this$0");
        e.F1();
    }

    private static final void N1(app.dogo.com.dogo_android.dogcreation.h.e e, View view2) {
        n.f(e, "this$0");
        e.F1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        int obj2;
        int obj3;
        Intent obj4;
        super.onActivityResult(i, i2, intent3);
        if (i == 203) {
            obj2 = d.b(intent3);
            if (i2 != -1) {
                if (i2 != 204) {
                } else {
                    a.d(obj2.c());
                }
            } else {
                obj2 = obj2.g();
                n.e(obj2, "resultUri");
                E1().t(obj2);
                obj2 = E1().p();
                if (obj2 != null) {
                    E1().u(obj2);
                } else {
                    obj2 = getActivity();
                    if (obj2 == null) {
                    } else {
                        g1.g0(obj2, 2131886123);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        int name;
        n.f(layoutInflater, "inflater");
        int obj7 = 0;
        sb obj5 = sb.T(layoutInflater, viewGroup2, obj7);
        n.e(obj5, "inflate(inflater, container, false)");
        this.a = obj5;
        String obj6 = "binding";
        final int i = 0;
        if (obj5 == null) {
        } else {
            obj5.V(E1());
            obj5 = this.a;
            if (obj5 == null) {
            } else {
                Object[] arr = new Object[1];
                DogProfile dogProfile = D1().l();
                if (dogProfile == null) {
                    name = i;
                } else {
                    name = dogProfile.getName();
                }
                arr[obj7] = name;
                obj5.Q.setText(getString(2131886456, arr));
                obj5 = this.a;
                if (obj5 == null) {
                } else {
                    obj5.M(getViewLifecycleOwner());
                    obj5 = this.a;
                    if (obj5 == null) {
                    } else {
                        obj5 = obj5.w();
                        n.e(obj5, "binding.root");
                        return obj5;
                    }
                    n.w(obj6);
                    throw i;
                }
                n.w(obj6);
                throw i;
            }
            n.w(obj6);
            throw i;
        }
        n.w(obj6);
        throw i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        DogProfile activity;
        boolean z;
        super.onResume();
        if (D1().l() == null) {
            if (activity instanceof DogCreationActivity != null) {
            } else {
                activity = 0;
            }
            if (activity == null) {
            } else {
                activity.y();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.a aVar2 = new e.a(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, aVar2, 2, 0);
        sb obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            b bVar = new b(this);
            obj7.O.setOnClickListener(bVar);
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                a aVar = new a(this);
                obj7.R.setNavigationOnClickListener(aVar);
                obj7 = this.a;
                if (obj7 == null) {
                } else {
                    d dVar = new d(this);
                    obj7.S.setOnClickListener(dVar);
                    obj7 = this.a;
                    if (obj7 == null) {
                    } else {
                        obj8 = new c(this);
                        obj7.P.setOnClickListener(obj8);
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
