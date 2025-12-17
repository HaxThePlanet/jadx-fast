package app.dogo.com.dogo_android.q.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ac;
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
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBirthdayFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogEditBirthdayBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBirthdayScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBirthdayScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBirthdayViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBirthdayViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends Fragment {

    private ac a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.q.p.r> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.q.p.r invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(r.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.q.p.p this$0;
        b(app.dogo.com.dogo_android.q.p.p p) {
            this.this$0 = p;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(p.B1(this.this$0).a());
        }
    }
    static {
    }

    public p() {
        super();
        p.b bVar = new p.b(this);
        p.a aVar = new p.a(this, 0, bVar);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    public static final app.dogo.com.dogo_android.q.p.q B1(app.dogo.com.dogo_android.q.p.p p) {
        return p.C1();
    }

    private final app.dogo.com.dogo_android.q.p.q C1() {
        return (q)k1.a(this);
    }

    private final app.dogo.com.dogo_android.q.p.r D1() {
        return (r)this.b.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.q.p.p p, View view2) {
        p.I1(p, view2);
    }

    public static void F1(app.dogo.com.dogo_android.q.p.p p, Boolean boolean2) {
        p.J1(p, boolean2);
    }

    public static void G1(app.dogo.com.dogo_android.q.p.p p, View view2) {
        p.H1(p, view2);
    }

    private static final void H1(app.dogo.com.dogo_android.q.p.p p, View view2) {
        long l;
        Object obj2;
        boolean obj3;
        n.f(p, "this$0");
        l = p.D1().l();
        if (p.D1().r(l)) {
            p.D1().s(l);
        } else {
            Toast.makeText(p.getContext(), 2131886451, 1).show();
        }
    }

    private static final void I1(app.dogo.com.dogo_android.q.p.p p, View view2) {
        n.f(p, "this$0");
        final androidx.fragment.app.e obj0 = p.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void J1(app.dogo.com.dogo_android.q.p.p p, Boolean boolean2) {
        Object activity;
        int i3;
        String str;
        int i4;
        int i2;
        int i;
        Object obj6;
        boolean obj7;
        n.f(p, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue() && !p.D1().isUserSignedIn()) {
            if (!p.D1().isUserSignedIn()) {
                activity = p.getActivity();
                if (activity == null) {
                } else {
                    g1.H(activity, 0, "dog_edit", 0, 5, 0);
                }
            }
            obj6 = p.getActivity();
            if (obj6 == null) {
            } else {
                g1.O(obj6);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        int obj9 = 0;
        ac obj7 = ac.T(layoutInflater, viewGroup2, obj9);
        n.e(obj7, "inflate(inflater, container, false)");
        this.a = obj7;
        int obj8 = 0;
        final String str = "binding";
        if (obj7 == null) {
        } else {
            obj7.W(D1());
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                Object[] arr = new Object[1];
                final android.content.res.Resources resources = getResources();
                n.e(resources, "resources");
                arr[obj9] = j1.W0(C1().a().getName(), resources);
                obj7.V(getString(2131886454, arr));
                obj7 = this.a;
                if (obj7 == null) {
                } else {
                    obj7.M(getViewLifecycleOwner());
                    obj7 = this.a;
                    if (obj7 == null) {
                    } else {
                        obj7 = obj7.w();
                        n.e(obj7, "binding.root");
                        return obj7;
                    }
                    n.w(str);
                    throw obj8;
                }
                n.w(str);
                throw obj8;
            }
            n.w(str);
            throw obj8;
        }
        n.w(str);
        throw obj8;
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
        ac obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            c cVar = new c(this);
            obj3.P.setOnClickListener(cVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new a(this);
                obj3.R.setNavigationOnClickListener(obj4);
                obj4 = getViewLifecycleOwner();
                n.e(obj4, "viewLifecycleOwner");
                b bVar = new b(this);
                D1().n().observe(obj4, bVar);
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}
