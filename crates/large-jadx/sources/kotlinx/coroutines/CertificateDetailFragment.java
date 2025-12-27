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
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: CertificateDetailFragment.kt */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0016\u0010 \u001a\u00020\u001d2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020#0\"H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\u0008\u0010'\u001a\u00020\u001dH\u0002J\u0008\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentCertificateDetailBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "resetViewModelAndLoadCompletedCertificate", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Success;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "saveCertificate", "url", "", "setupClicks", "setupNavigation", "shareCertificate", "uri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class CertificateDetailFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private ca binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public a(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<j> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(CertificateDetailViewModel.class), this.$parameters);
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
            return org.koin.core.parameter.b.b(new Object[] { h.this.onResume().c(), h.this.onResume().component1() });
        }

        c() {
            super(0);
        }
    }
    public h() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.h.b(this, aVar2, new kotlinx.coroutines.h.c(this)));
        this.c = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.h.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ i resetViewModelAndLoadCompletedCertificate(h result) {
        return result.onResume();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final i onResume() {
        return (CertificateDetailScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final j D1() {
        return (CertificateDetailViewModel)this.b.getValue();
    }

    private static final void J1(h hVar, Uri uri) {
        n.f(hVar, "this$0");
        n.e(uri, "it");
        hVar.S1(uri);
    }

    private static final void K1(h hVar, y yVar) {
        int i;
        Object component1;
        n.f(hVar, "this$0");
        Object yVar22 = yVar instanceof LoadResult_Success ? (LoadResult_Success)yVar22 : i;
        if (i != 0) {
        }
        if (component1 != null) {
            n.e(yVar, "result");
            hVar.saveCertificate(yVar);
        }
    }

    /* renamed from: L1, reason: from kotlin metadata */
    private final void saveCertificate(y.c<ProgramExamSummary> url) {
        final int i = 0;
        final String str = "binding";
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            app.dogo.com.dogo_android.y.n.j jVar = this.binding.T();
            if (jVar != null) {
                jVar.y((ProgramExamSummary)url.component1());
            }
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.A();
                D1().u();
                return;
            }
        }
    }

    /* renamed from: M1, reason: from kotlin metadata */
    private final void shareCertificate(String uri) {
        try {
            Intent intent = new Intent();
            intent.setDataAndType(Uri.parse(uri), "application/pdf");
            startActivity(intent);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            uri = Uri.parse(uri);
            intent2.setData(uri);
            startActivity(intent2);
        }
    }

    private final void N1() throws c {
        int i = 0;
        final String str = "binding";
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.V.setOnClickListener(new kotlinx.coroutines.b(this));
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.U.setOnClickListener(new kotlinx.coroutines.c(this));
                return;
            }
        }
    }

    private static final void O1(h hVar, View view) {
        int i;
        n.f(hVar, "this$0");
        z = hVar.D1().getResult().getValue() instanceof LoadResult_Success;
        i = 0;
        view = hVar.D1().getResult().getValue() instanceof oadResult_Success ? (oadResult_Success)hVar.D1().getResult().getValue() : i;
        if (i != 0) {
            i = !l.z((CertificateInfo)i.component1().getCertificateImageUrl());
            if (!l.z(i.component1().getCertificateImageUrl()) != 0) {
                hVar.D1().A();
                if (hVar.binding == null) {
                    n.w("binding");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    n.e(binding2.P, "binding.certificateReal");
                    hVar.D1().w(binding2.P);
                }
            }
        }
    }

    private static final void P1(h hVar, View view) {
        int i2 = 0;
        n.f(hVar, "this$0");
        view = hVar.D1().getResult().getValue() instanceof LoadResult_Success ? (oadResult_Success)hVar.D1().getResult().getValue() : 0;
        if (i2 != 0) {
            i = !l.z((CertificateInfo)i2.component1().getCertificatePdfUrl());
            if (!l.z(i2.component1().getCertificatePdfUrl()) != 0) {
                hVar.D1().z();
                hVar.shareCertificate((CertificateInfo)i2.component1().getCertificatePdfUrl());
            }
        }
    }

    private final void Q1() {
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.X.setNavigationOnClickListener(new kotlinx.coroutines.d(this));
            return;
        }
    }

    private static final void R1(h hVar, View view) {
        n.f(hVar, "this$0");
        final androidx.fragment.app.e activity = hVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void S1(Uri uri) {
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

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ca caVar = ca.U(inflater, container, false);
        n.e(caVar, "inflate(inflater, container, false)");
        this.binding = caVar;
        int i = 0;
        String str3 = "binding";
        if (caVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            caVar.W(getSharedViewModel());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.X(D1());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.binding.w();
                    }
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
            activity.p0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        Q1();
        N1();
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str2);
        D1().n().observe(viewLifecycleOwner, new kotlinx.coroutines.a(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str2);
        D1().l().observe(viewLifecycleOwner2, new kotlinx.coroutines.e(this));
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(h view, Uri savedInstanceState) {
        CertificateDetailFragment.J1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(h hVar, View view) {
        CertificateDetailFragment.O1(hVar, view);
    }

    public static /* synthetic */ void G1(h hVar, View view) {
        CertificateDetailFragment.P1(hVar, view);
    }

    public static /* synthetic */ void H1(h hVar, View view) {
        CertificateDetailFragment.R1(hVar, view);
    }

    public static /* synthetic */ void I1(h hVar, y yVar) {
        CertificateDetailFragment.K1(hVar, yVar);
    }
}
