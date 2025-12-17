package app.dogo.com.dogo_android.y.n;

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
import app.dogo.com.dogo_android.h.ca;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0016\u0010 \u001a\u00020\u001d2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020#0\"H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\u0008\u0010'\u001a\u00020\u001dH\u0002J\u0008\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentCertificateDetailBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "resetViewModelAndLoadCompletedCertificate", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Success;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "saveCertificate", "url", "", "setupClicks", "setupNavigation", "shareCertificate", "uri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends Fragment {

    private ca a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public a(Fragment fragment, a a2, a a3) {
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
    public static final class b extends p implements a<app.dogo.com.dogo_android.y.n.j> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.n.j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(j.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.y.n.h this$0;
        c(app.dogo.com.dogo_android.y.n.h h) {
            this.this$0 = h;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(h.B1(this.this$0).c(), h.B1(this.this$0).b());
        }
    }
    static {
    }

    public h() {
        super();
        h.c cVar = new h.c(this);
        final int i = 0;
        h.b bVar = new h.b(this, i, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
        h.a aVar = new h.a(this, i, i);
        this.c = j.a(m.NONE, aVar);
    }

    public static final app.dogo.com.dogo_android.y.n.i B1(app.dogo.com.dogo_android.y.n.h h) {
        return h.C1();
    }

    private final app.dogo.com.dogo_android.y.n.i C1() {
        return (i)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.n.j D1() {
        return (j)this.b.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.y.n.h h, Uri uri2) {
        h.J1(h, uri2);
    }

    public static void F1(app.dogo.com.dogo_android.y.n.h h, View view2) {
        h.O1(h, view2);
    }

    public static void G1(app.dogo.com.dogo_android.y.n.h h, View view2) {
        h.P1(h, view2);
    }

    public static void H1(app.dogo.com.dogo_android.y.n.h h, View view2) {
        h.R1(h, view2);
    }

    public static void I1(app.dogo.com.dogo_android.y.n.h h, y y2) {
        h.K1(h, y2);
    }

    private static final void J1(app.dogo.com.dogo_android.y.n.h h, Uri uri2) {
        n.f(h, "this$0");
        n.e(uri2, "it");
        h.S1(uri2);
    }

    private static final void K1(app.dogo.com.dogo_android.y.n.h h, y y2) {
        int str;
        Object i;
        n.f(h, "this$0");
        if (y2 instanceof y.c) {
            str = y2;
        } else {
            str = i;
        }
        if (str == null) {
        } else {
            i = str;
        }
        if (i != null) {
            n.e(y2, "result");
            h.L1((y.c)y2);
        }
    }

    private final void L1(y.c<ProgramExamSummary> y$c) {
        Object obj4;
        ca caVar = this.a;
        final int i = 0;
        final String str = "binding";
        if (caVar == null) {
        } else {
            app.dogo.com.dogo_android.y.n.j jVar = caVar.T();
            if (jVar == null) {
            } else {
                jVar.y((ProgramExamSummary)c.a());
            }
            obj4 = this.a;
            if (obj4 == null) {
            } else {
                obj4.A();
                D1().u();
            }
            n.w(str);
            throw i;
        }
        n.w(str);
        throw i;
    }

    private final void M1(String string) {
        Intent intent;
        Uri parse;
        String obj4;
        try {
            intent = new Intent();
            intent.setDataAndType(Uri.parse(string), "application/pdf");
            startActivity(intent);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            string = Uri.parse(string);
            intent2.setData(string);
            startActivity(intent2);
        }
    }

    private final void N1() {
        ca caVar = this.a;
        int i = 0;
        final String str = "binding";
        if (caVar == null) {
        } else {
            b bVar = new b(this);
            caVar.V.setOnClickListener(bVar);
            ca caVar2 = this.a;
            if (caVar2 == null) {
            } else {
                c cVar = new c(this);
                caVar2.U.setOnClickListener(cVar);
            }
            n.w(str);
            throw i;
        }
        n.w(str);
        throw i;
    }

    private static final void O1(app.dogo.com.dogo_android.y.n.h h, View view2) {
        boolean str;
        Object obj2;
        int obj3;
        n.f(h, "this$0");
        final int i = 0;
        if (obj3 instanceof y.c) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            if (obj3 ^= 1 != 0) {
                h.D1().A();
                obj2 = h.a;
                if (obj2 == null) {
                } else {
                    obj2 = obj2.P;
                    n.e(obj2, "binding.certificateReal");
                    h.D1().w(obj2);
                }
                n.w("binding");
                throw i;
            }
        }
    }

    private static final void P1(app.dogo.com.dogo_android.y.n.h h, View view2) {
        int i;
        int obj2;
        n.f(h, "this$0");
        if (obj2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            if (z ^= 1 != 0) {
                h.D1().z();
                h.M1((CertificateInfo)obj2.a().getCertificatePdfUrl());
            }
        }
    }

    private final void Q1() {
        ca caVar = this.a;
        if (caVar == null) {
        } else {
            d dVar = new d(this);
            caVar.X.setNavigationOnClickListener(dVar);
        }
        n.w("binding");
        throw 0;
    }

    private static final void R1(app.dogo.com.dogo_android.y.n.h h, View view2) {
        n.f(h, "this$0");
        final androidx.fragment.app.e obj0 = h.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private final void S1(Uri uri) {
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

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ca obj2 = ca.U(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(getSharedViewModel());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.X(D1());
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
            activity.p0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        Q1();
        N1();
        androidx.lifecycle.q obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        a aVar = new a(this);
        D1().n().observe(obj4, aVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        e eVar = new e(this);
        D1().l().observe(obj4, eVar);
    }
}
