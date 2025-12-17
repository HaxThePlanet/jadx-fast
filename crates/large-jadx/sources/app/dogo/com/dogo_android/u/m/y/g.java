package app.dogo.com.dogo_android.u.m.y;

import android.net.Uri;
import android.widget.ImageView;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.s.a.j3;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.s;
import com.google.android.gms.tasks.m;
import f.d.a.a;
import i.b.a0;
import i.b.c0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "certificateData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "programId", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "certificateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "getCertificateData", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "getProgramId", "()Ljava/lang/String;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "saveToExternalFileLiveData", "Lcom/hadilq/liveevent/LiveEvent;", "Landroid/net/Uri;", "getSaveToExternalFileLiveData", "()Lcom/hadilq/liveevent/LiveEvent;", "generateCertificate", "", "saveBitmapToExternalFile", "imageView", "Landroid/widget/ImageView;", "trackSaveTapped", "trackShareTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends s {

    private final SpecialProgramOverviewItem.CertificateData a;
    private final String b;
    private final o3 c;
    private final t2 d;
    private final j3 e;
    private final j2 f;
    private final a<Uri> g;
    private final x<y<CertificateInfo>> h;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.u.m.y.g this$0;
        a(app.dogo.com.dogo_android.u.m.y.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            this.this$0.j().postValue(aVar);
            a.d(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<CertificateInfo, w> {

        final app.dogo.com.dogo_android.u.m.y.g this$0;
        b(app.dogo.com.dogo_android.u.m.y.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(CertificateInfo certificateInfo) {
            y.c cVar = new y.c(certificateInfo);
            this.this$0.j().postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((CertificateInfo)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        public static final app.dogo.com.dogo_android.u.m.y.g.c a;
        static {
            g.c cVar = new g.c();
            g.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            a.d(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Landroid/net/Uri;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Uri, w> {

        final app.dogo.com.dogo_android.u.m.y.g this$0;
        d(app.dogo.com.dogo_android.u.m.y.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(Uri uri) {
            this.this$0.k().postValue(uri);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((Uri)object);
            return w.a;
        }
    }
    public g(SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData, String string2, o3 o33, t2 t24, j3 j35, j2 j26) {
        Object str;
        Object obj;
        String certificateImageUrl;
        String certificatePdfUrl;
        int i;
        int i3;
        int i2;
        boolean obj11;
        Object obj12;
        n.f(certificateData, "certificateData");
        n.f(string2, "programId");
        n.f(o33, "tracker");
        n.f(t24, "storageService");
        n.f(j35, "certificateInteractor");
        n.f(j26, "connectivityService");
        super();
        this.a = certificateData;
        this.b = string2;
        this.c = o33;
        this.d = t24;
        this.e = j35;
        this.f = j26;
        a obj10 = new a();
        this.g = obj10;
        obj10 = new x();
        this.h = obj10;
        if (l.z(certificateData.getCertificateImageUrl()) && certificateData.isCertificateUnlocked()) {
            obj11 = certificateData.isCertificateUnlocked() ? 1 : 0;
        } else {
        }
        if (obj11 != null) {
            h();
        } else {
            if (certificateData.isCertificateUnlocked()) {
                super(string2, certificateData.getCertificateImageUrl(), certificateData.getCertificatePdfUrl(), 0, 8, 0);
                obj11 = new y.c(obj12);
                obj10.setValue(obj11);
            }
        }
    }

    private final void h() {
        Object disposable;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.u.m.y.g.b bVar;
        this.h.postValue(y.b.a);
        if (!this.f.a()) {
            this.c.s("special_program_certificate");
            unknownHostException = new UnknownHostException();
            aVar = new y.a(unknownHostException);
            this.h.postValue(aVar);
        } else {
            a0 observeOn = this.e.a(this.b, this.a.getDogId()).subscribeOn(a.b()).observeOn(a.b());
            n.e(observeOn, "certificateInteractor.getCertificateInfo(programId, certificateData.dogId)\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            unknownHostException = new g.a(this);
            bVar = new g.b(this);
            getDisposable().b(a.g(observeOn, unknownHostException, bVar));
        }
    }

    public static void l(app.dogo.com.dogo_android.u.m.y.g g, ImageView imageView2, c0 c03) {
        g.n(g, imageView2, c03);
    }

    private static final void n(app.dogo.com.dogo_android.u.m.y.g g, ImageView imageView2, c0 c03) {
        Object obj1;
        n.f(g, "this$0");
        n.f(imageView2, "$imageView");
        n.f(c03, "it");
        obj1 = g.d;
        c03.onSuccess((Uri)m.a(obj1.a(obj1.d(imageView2))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final SpecialProgramOverviewItem.CertificateData i() {
        return this.a;
    }

    public final x<y<CertificateInfo>> j() {
        return this.h;
    }

    public final a<Uri> k() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m(ImageView imageView) {
        n.f(imageView, "imageView");
        d dVar = new d(this, imageView);
        a0 obj4 = a0.create(dVar).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj4, "create<Uri> {\n                try {\n                    val uri = Tasks.await(storageService.asyncSaveBitmapToExternalFile(storageService.getBitmap(imageView)))\n                    it.onSuccess(uri)\n                } catch (e: Exception) {\n                    Timber.e(e)\n                    it.tryOnError(e)\n                }\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        g.d dVar2 = new g.d(this);
        getDisposable().b(a.g(obj4, g.c.a, dVar2));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.c.d(s.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.c.d(s.a);
    }
}
