package app.dogo.com.dogo_android.u.m.y;

import android.net.Uri;
import android.widget.ImageView;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.s.a.j3;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import com.google.android.gms.tasks.m;
import i.b.a0;
import i.b.c0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: SpecialProgramCertificateViewModel.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "certificateData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "programId", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "certificateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "getCertificateData", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "getProgramId", "()Ljava/lang/String;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "saveToExternalFileLiveData", "Lcom/hadilq/liveevent/LiveEvent;", "Landroid/net/Uri;", "getSaveToExternalFileLiveData", "()Lcom/hadilq/liveevent/LiveEvent;", "generateCertificate", "", "saveBitmapToExternalFile", "imageView", "Landroid/widget/ImageView;", "trackSaveTapped", "trackShareTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class SpecialProgramCertificateViewModel extends app.dogo.com.dogo_android.util.e0.s {

    /* renamed from: a, reason: from kotlin metadata */
    private final SpecialProgramOverviewItem.CertificateData certificateData;
    /* renamed from: b, reason: from kotlin metadata */
    private final String certificateInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 connectivityService;
    private final t2 d;
    private final j3 e;
    private final j2 f;
    /* renamed from: g, reason: from kotlin metadata */
    private final f.d.a.a<Uri> storageService = new a<>();
    /* renamed from: h, reason: from kotlin metadata */
    private final x<y<CertificateInfo>> tracker = new x<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            g.this.j().postValue(new LoadResult_Error(th));
            a.d(th);
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.l<CertificateInfo, w> {
        @Override // kotlin.d0.d.p
        public final void a(CertificateInfo certificateInfo) {
            g.this.j().postValue(new LoadResult_Success(certificateInfo));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.l<Throwable, w> {

        public static final g.c a = new g$c();
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(th);
        }


        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Landroid/net/Uri;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.l<Uri, w> {
        @Override // kotlin.d0.d.p
        public final void a(Uri uri) {
            g.this.k().postValue(uri);
        }

        d() {
            super(1);
        }
    }
    public g(SpecialProgramOverviewItem.CertificateData certificateData, String str, o3 o3Var, t2 t2Var, j3 j3Var, j2 j2Var) {
        int i2 = 0;
        n.f(certificateData, "certificateData");
        n.f(str, "programId");
        n.f(o3Var, "tracker");
        n.f(t2Var, "storageService");
        n.f(j3Var, "certificateInteractor");
        str = "connectivityService";
        n.f(j2Var, str);
        super();
        this.certificateData = certificateData;
        this.certificateInteractor = str;
        this.connectivityService = o3Var;
        this.d = t2Var;
        this.e = j3Var;
        this.f = j2Var;
        f.d.a.a aVar = new a();
        t2Var = l.z(certificateData.getCertificateImageUrl()) && certificateData.isCertificateUnlocked() ? 1 : 0;
        if (i2 != 0) {
            generateCertificate();
        } else {
            if (certificateData.isCertificateUnlocked()) {
                app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = null;
                int i = 8;
                kotlin.d0.d.g gVar = null;
                super(str, certificateData.getCertificateImageUrl(), certificateData.getCertificatePdfUrl(), programExamSummary, i, gVar);
                new x().setValue(new LoadResult_Success(j3Var52));
            }
        }
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final void generateCertificate() {
        this.tracker.postValue(LoadResult_Loading.a);
        if (!this.f.a()) {
            this.connectivityService.setTrainingReminderUserProperties("special_program_certificate");
            this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            a0 observable2 = this.e.a(this.certificateInteractor, this.certificateData.getDogId()).subscribeOn(a.b()).observeOn(a.b());
            n.e(observable2, "certificateInteractor.getCertificateInfo(programId, certificateData.dogId)\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.specialprograms.biting.certificate.g.a(this), new app.dogo.com.dogo_android.specialprograms.biting.certificate.g.b(this)));
        }
    }

    private static final void n(g gVar, ImageView imageView, c0 c0Var) {
        n.f(gVar, "this$0");
        n.f(imageView, "$imageView");
        n.f(c0Var, "it");
        try {
            c0Var.onSuccess((Uri)m.a(gVar.d.a(gVar.d.d(imageView))));
        } catch (Exception e) {
            a.d(e);
            c0Var.a(e);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final SpecialProgramOverviewItem.CertificateData i() {
        return this.certificateData;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<CertificateInfo>> j() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Uri> k() {
        return this.storageService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: m, reason: from kotlin metadata */
    public final void saveBitmapToExternalFile(ImageView imageView) {
        n.f(imageView, "imageView");
        a0 observable2 = a0.create(new app.dogo.com.dogo_android.specialprograms.biting.certificate.d(this, imageView)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "create<Uri> {\n                try {\n                    val uri = Tasks.await(storageService.asyncSaveBitmapToExternalFile(storageService.getBitmap(imageView)))\n                    it.onSuccess(uri)\n                } catch (e: Exception) {\n                    Timber.e(e)\n                    it.tryOnError(e)\n                }\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, app.dogo.com.dogo_android.specialprograms.biting.certificate.g.c.a, new app.dogo.com.dogo_android.specialprograms.biting.certificate.g.d(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.connectivityService.logEvent(E_Certificate.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.connectivityService.logEvent(E_Certificate.a);
    }

    public static /* synthetic */ void l(g gVar, ImageView imageView, c0 c0Var) {
        SpecialProgramCertificateViewModel.n(gVar, imageView, c0Var);
    }
}
