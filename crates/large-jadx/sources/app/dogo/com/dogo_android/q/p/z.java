package app.dogo.com.dogo_android.q.p;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ec;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogEditGenderBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class z extends Fragment {

    private ec a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.q.p.b0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.q.p.b0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(b0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.q.p.z this$0;
        b(app.dogo.com.dogo_android.q.p.z z) {
            this.this$0 = z;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(z.B1(this.this$0).a());
        }
    }
    static {
    }

    public z() {
        super();
        z.b bVar = new z.b(this);
        z.a aVar = new z.a(this, 0, bVar);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    public static final app.dogo.com.dogo_android.q.p.a0 B1(app.dogo.com.dogo_android.q.p.z z) {
        return z.C1();
    }

    private final app.dogo.com.dogo_android.q.p.a0 C1() {
        return (a0)k1.a(this);
    }

    private final app.dogo.com.dogo_android.q.p.b0 D1() {
        return (b0)this.b.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.q.p.z z, View view2) {
        z.I1(z, view2);
    }

    public static void F1(app.dogo.com.dogo_android.q.p.z z, Boolean boolean2) {
        z.J1(z, boolean2);
    }

    public static void G1(app.dogo.com.dogo_android.q.p.z z, View view2) {
        z.H1(z, view2);
    }

    private static final void H1(app.dogo.com.dogo_android.q.p.z z, View view2) {
        n.f(z, "this$0");
        z.D1().o();
    }

    private static final void I1(app.dogo.com.dogo_android.q.p.z z, View view2) {
        n.f(z, "this$0");
        final androidx.fragment.app.e obj0 = z.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void J1(app.dogo.com.dogo_android.q.p.z z, Boolean boolean2) {
        Object activity;
        int i3;
        String str;
        int i4;
        int i2;
        int i;
        Object obj6;
        boolean obj7;
        n.f(z, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue() && !z.D1().isUserSignedIn()) {
            if (!z.D1().isUserSignedIn()) {
                activity = z.getActivity();
                if (activity == null) {
                } else {
                    g1.H(activity, 0, "dog_edit", 0, 5, 0);
                }
            }
            obj6 = z.getActivity();
            if (obj6 == null) {
            } else {
                g1.O(obj6);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        int obj10 = 0;
        ec obj8 = ec.T(layoutInflater, viewGroup2, obj10);
        n.e(obj8, "inflate(inflater, container, false)");
        this.a = obj8;
        int obj9 = 0;
        final String str = "binding";
        if (obj8 == null) {
        } else {
            obj8.W(D1());
            obj8 = this.a;
            if (obj8 == null) {
            } else {
                Object[] arr = new Object[1];
                final Resources resources2 = getResources();
                n.e(resources2, "resources");
                arr[obj10] = j1.W0(C1().a().getName(), resources2);
                obj8.V(getResources().getString(2131886453, arr));
                obj8 = this.a;
                if (obj8 == null) {
                } else {
                    obj8.M(getViewLifecycleOwner());
                    obj8 = this.a;
                    if (obj8 == null) {
                    } else {
                        obj8 = obj8.w();
                        n.e(obj8, "binding.root");
                        return obj8;
                    }
                    n.w(str);
                    throw obj9;
                }
                n.w(str);
                throw obj9;
            }
            n.w(str);
            throw obj9;
        }
        n.w(str);
        throw obj9;
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
        ec obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            l lVar = new l(this);
            obj3.P.setOnClickListener(lVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new j(this);
                obj3.R.setNavigationOnClickListener(obj4);
                obj4 = getViewLifecycleOwner();
                n.e(obj4, "viewLifecycleOwner");
                k kVar = new k(this);
                D1().l().observe(obj4, kVar);
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}
