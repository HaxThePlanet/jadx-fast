package app.dogo.com.dogo_android.u.m.y;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.h.og;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
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
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0008\u0010\u001e\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSpecialProgramCertificateBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "saveCertificate", "url", "", "setupClicks", "shareCertificate", "uri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends Fragment {

    private og a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.u.m.y.e a;
        public a(app.dogo.com.dogo_android.u.m.y.e e) {
            this.a = e;
            super();
        }

        public final void onChanged(T t) {
            n.e((Uri)t, "it");
            e.C1(this.a, t);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.u.m.y.g> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.m.y.g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.u.m.y.e this$0;
        c(app.dogo.com.dogo_android.u.m.y.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(e.B1(this.this$0).a(), e.B1(this.this$0).b());
        }
    }
    static {
    }

    public e() {
        super();
        e.c cVar = new e.c(this);
        e.b bVar = new e.b(this, 0, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final app.dogo.com.dogo_android.u.m.y.f B1(app.dogo.com.dogo_android.u.m.y.e e) {
        return e.D1();
    }

    public static final void C1(app.dogo.com.dogo_android.u.m.y.e e, Uri uri2) {
        e.N1(uri2);
    }

    private final app.dogo.com.dogo_android.u.m.y.f D1() {
        return (f)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.m.y.g E1() {
        return (g)this.b.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.u.m.y.e e, View view2) {
        e.M1(e, view2);
    }

    public static void G1(app.dogo.com.dogo_android.u.m.y.e e, View view2) {
        e.I1(e, view2);
    }

    public static void H1(app.dogo.com.dogo_android.u.m.y.e e, View view2) {
        e.L1(e, view2);
    }

    private static final void I1(app.dogo.com.dogo_android.u.m.y.e e, View view2) {
        n.f(e, "this$0");
        final androidx.fragment.app.e obj0 = e.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private final void J1(String string) {
        int i;
        String str;
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(string), "application/pdf");
            startActivity(Intent.createChooser(intent, ""));
            androidx.fragment.app.e activity = getActivity();
            if (activity == null) {
            } else {
            }
            g1.g0(activity, 2131886123);
            a.d(string);
        }
    }

    private final void K1() {
        og ogVar = this.a;
        int i = 0;
        final String str = "binding";
        if (ogVar == null) {
        } else {
            c cVar = new c(this);
            ogVar.T.setOnClickListener(cVar);
            og ogVar2 = this.a;
            if (ogVar2 == null) {
            } else {
                a aVar = new a(this);
                ogVar2.S.setOnClickListener(aVar);
            }
            n.w(str);
            throw i;
        }
        n.w(str);
        throw i;
    }

    private static final void L1(app.dogo.com.dogo_android.u.m.y.e e, View view2) {
        String str;
        Object obj1;
        boolean obj2;
        n.f(e, "this$0");
        if (e.E1().i().isCertificateUnlocked()) {
            e.E1().p();
            obj1 = e.a;
            if (obj1 == null) {
            } else {
                obj1 = obj1.P;
                n.e(obj1, "binding.certificateReal");
                e.E1().m(obj1);
            }
            n.w("binding");
            throw 0;
        }
    }

    private static final void M1(app.dogo.com.dogo_android.u.m.y.e e, View view2) {
        app.dogo.com.dogo_android.u.m.y.g gVar;
        int obj2;
        n.f(e, "this$0");
        if (obj2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((CertificateInfo)obj2 == null) {
            } else {
                obj2 = (CertificateInfo)obj2.getCertificatePdfUrl();
                if (obj2 == null) {
                } else {
                    e.E1().o();
                    e.J1(obj2);
                }
            }
        }
    }

    private final void N1(Uri uri) {
        String obj3;
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.addFlags(1);
            intent.setType("image/png");
            startActivity(intent);
            a.d(uri);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        og obj2 = og.T(layoutInflater, viewGroup2, false);
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
        og obj2 = this.a;
        if (obj2 == null) {
        } else {
            b obj3 = new b(this);
            obj2.V.setNavigationOnClickListener(obj3);
            K1();
            obj3 = getViewLifecycleOwner();
            n.e(obj3, "viewLifecycleOwner");
            e.a aVar = new e.a(this);
            E1().k().observe(obj3, aVar);
        }
        n.w("binding");
        throw 0;
    }
}
