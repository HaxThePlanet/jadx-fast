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
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: SpecialProgramCertificateFragment.kt */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0008\u0010\u001e\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSpecialProgramCertificateBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "saveCertificate", "url", "", "setupClicks", "shareCertificate", "uri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class SpecialProgramCertificateFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private og binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ e a;
        public final void onChanged(T t) {
            n.e(t, "it");
            this.a.N1(t);
        }

        public a() {
            this.a = eVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(SpecialProgramCertificateViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { e.this.onResume().component1(), e.this.onResume().b() });
        }

        c() {
            super(0);
        }
    }
    public e() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.biting.certificate.e.b(this, null, new app.dogo.com.dogo_android.specialprograms.biting.certificate.e.c(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ f saveCertificate(e url) {
        return url.onResume();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ void onViewCreated(e view, Uri savedInstanceState) {
        view.N1(savedInstanceState);
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final f onResume() {
        return (SpecialProgramCertificateScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final g E1() {
        return (SpecialProgramCertificateViewModel)this.b.getValue();
    }

    private static final void I1(e eVar, View view) {
        n.f(eVar, "this$0");
        final androidx.fragment.app.e activity = eVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* renamed from: J1, reason: from kotlin metadata */
    private final void shareCertificate(String uri) {
        try {
            final Intent intent = new Intent("android.intent.action.VIEW");
            str = "application/pdf";
            intent.setDataAndType(Uri.parse(uri), str);
            startActivity(Intent.createChooser(intent, ""));
        } catch (Exception e) {
            androidx.fragment.app.e activity = getActivity();
        }
    }

    private final void K1() throws a {
        int i = 0;
        final String str = "binding";
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.T.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.certificate.c(this));
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.S.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.certificate.a(this));
                return;
            }
        }
    }

    private static final void L1(e eVar, View view) {
        n.f(eVar, "this$0");
        if (eVar.E1().i().isCertificateUnlocked()) {
            eVar.E1().p();
            if (eVar.binding == null) {
                n.w("binding");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                str = "binding.certificateReal";
                n.e(binding2.P, str);
                eVar.E1().saveBitmapToExternalFile(binding2.P);
            }
        }
    }

    private static final void M1(e eVar, View view) {
        int i = 0;
        n.f(eVar, "this$0");
        view = eVar.E1().j().getValue() instanceof LoadResult_Success ? (oadResult_Success)eVar.E1().j().getValue() : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                String certificatePdfUrl = component1.getCertificatePdfUrl();
                if (certificatePdfUrl != null) {
                    eVar.E1().o();
                    eVar.shareCertificate(certificatePdfUrl);
                }
            }
        }
    }

    private final void N1(Uri uri) {
        try {
            final Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.addFlags(1);
            str = "image/png";
            intent.setType(str);
            startActivity(intent);
        } catch (java.io.FileNotFoundException fileNotFound) {
            a.d(fileNotFound);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        og ogVar = og.T(inflater, container, false);
        n.e(ogVar, "inflate(inflater, container, false)");
        this.binding = ogVar;
        int i = 0;
        String str4 = "binding";
        if (ogVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ogVar.V(E1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.M(getViewLifecycleOwner());
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    View view = this.binding.w();
                    n.e(view, "binding.root");
                    return view;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity = null;
        super.onResume();
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.V.setNavigationOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.certificate.b(this));
            K1();
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            E1().k().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.specialprograms.biting.certificate.e.a(this));
            return;
        }
    }


    public static /* synthetic */ void F1(e eVar, View view) {
        SpecialProgramCertificateFragment.M1(eVar, view);
    }

    public static /* synthetic */ void G1(e eVar, View view) {
        SpecialProgramCertificateFragment.I1(eVar, view);
    }

    public static /* synthetic */ void H1(e eVar, View view) {
        SpecialProgramCertificateFragment.L1(eVar, view);
    }
}
