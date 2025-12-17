package app.dogo.com.dogo_android.y.n;

import android.net.Uri;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.a.i2;
import app.dogo.com.dogo_android.s.a.j3;
import app.dogo.com.dogo_android.s.a.v2;
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
import i.b.g0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0008\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020-J\u0008\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u000200J\u0008\u00102\u001a\u000200H\u0002J\u000e\u00103\u001a\u0002002\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u000200J\u0006\u00107\u001a\u000200R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00150\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150&¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010 R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogName", "", "certificateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetCertificateInfoInteractor;", "programsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "generateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetCertificateInfoInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "getDogName", "()Ljava/lang/String;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "preload", "Lcom/hadilq/liveevent/LiveEvent;", "getPreload", "()Lcom/hadilq/liveevent/LiveEvent;", "getProgramInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "setProgramInfo", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;)V", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "saveToExternalFileLiveData", "Landroid/net/Uri;", "getSaveToExternalFileLiveData", "isExamDataMissing", "", "isProgramFinished", "loadCertificate", "", "loadCertificateIfCompleted", "loadExamData", "saveBitmapToExternalFile", "imageView", "Landroid/widget/ImageView;", "trackSaveTapped", "trackShareTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends s {

    private ProgramExamSummary a;
    private final String b;
    private final i2 c;
    private final v2 d;
    private final j3 e;
    private final o3 f;
    private final t2 g;
    private final j2 h;
    private final CoroutineExceptionHandler i;
    private final x<y<CertificateInfo>> j;
    private final LiveData<y<CertificateInfo>> k;
    private final a<y<ProgramExamSummary>> l;
    private final a<Uri> m;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.y.n.j this$0;
        a(app.dogo.com.dogo_android.y.n.j j) {
            this.this$0 = j;
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
            j.k(this.this$0).postValue(aVar);
            a.d(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<CertificateInfo, w> {

        final app.dogo.com.dogo_android.y.n.j this$0;
        b(app.dogo.com.dogo_android.y.n.j j) {
            this.this$0 = j;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(CertificateInfo certificateInfo) {
            y.c cVar = new y.c(certificateInfo);
            j.k(this.this$0).postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((CertificateInfo)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Throwable, w> {

        public static final app.dogo.com.dogo_android.y.n.j.d a;
        static {
            j.d dVar = new j.d();
            j.d.a = dVar;
        }

        d() {
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
    static final class e extends p implements l<Uri, w> {

        final app.dogo.com.dogo_android.y.n.j this$0;
        e(app.dogo.com.dogo_android.y.n.j j) {
            this.this$0 = j;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(Uri uri) {
            this.this$0.n().postValue(uri);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((Uri)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.n.j a;
        public f(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.n.j j2) {
            this.a = j2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            j.k(this.a).postValue(aVar);
            a.d(throwable2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.certificate.CertificateDetailViewModel$loadExamData$1", f = "CertificateDetailViewModel.kt", l = 75, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.n.j this$0;
        c(app.dogo.com.dogo_android.y.n.j j, d<? super app.dogo.com.dogo_android.y.n.j.c> d2) {
            this.this$0 = j;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (j.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            j.c obj2 = new j.c(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            Object unknownHostException;
            int dogId;
            String programId;
            Object obj5;
            Object obj = b.d();
            dogId = this.label;
            final int i = 1;
            if (dogId != 0) {
                if (dogId != i) {
                } else {
                    q.b(object);
                    obj5 = (ProgramExamList)obj5.getProgramExamSummary();
                    n.d(obj5);
                    unknownHostException = new y.c(obj5);
                    this.this$0.l().postValue(unknownHostException);
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            j.k(this.this$0).postValue(y.b.a);
            if (!j.h(this.this$0).a()) {
                j.j(this.this$0).s("program");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                j.k(this.this$0).postValue(aVar);
            } else {
                this.label = i;
                if (j.i(this.this$0).r(this.this$0.m().getProgramSaveInfo().getDogId(), this.this$0.m().getProgramSaveInfo().getProgramId(), this) == obj) {
                    return obj;
                }
            }
        }
    }
    public j(ProgramExamSummary programExamSummary, String string2, i2 i23, v2 v24, j3 j35, o3 o36, t2 t27, j2 j28) {
        n.f(programExamSummary, "programInfo");
        n.f(string2, "dogName");
        n.f(i23, "certificateInteractor");
        n.f(v24, "programsInteractor");
        n.f(j35, "generateInteractor");
        n.f(o36, "tracker");
        n.f(t27, "storageService");
        n.f(j28, "connectivityService");
        super();
        this.a = programExamSummary;
        this.b = string2;
        this.c = i23;
        this.d = v24;
        this.e = j35;
        this.f = o36;
        this.g = t27;
        this.h = j28;
        j.f obj3 = new j.f(CoroutineExceptionHandler.r, this);
        this.i = obj3;
        x obj2 = new x();
        this.j = obj2;
        this.k = obj2;
        obj2 = new a();
        this.l = obj2;
        obj2 = new a();
        this.m = obj2;
        if (o()) {
            v();
        } else {
            u();
        }
    }

    public static final j2 h(app.dogo.com.dogo_android.y.n.j j) {
        return j.h;
    }

    public static final v2 i(app.dogo.com.dogo_android.y.n.j j) {
        return j.d;
    }

    public static final o3 j(app.dogo.com.dogo_android.y.n.j j) {
        return j.f;
    }

    public static final x k(app.dogo.com.dogo_android.y.n.j j) {
        return j.j;
    }

    private final boolean o() {
        int i;
        i = this.a.getActiveExamsCount() == null ? 1 : 0;
        return i;
    }

    public static void q(app.dogo.com.dogo_android.y.n.j j, ImageView imageView2, c0 c03) {
        j.x(j, imageView2, c03);
    }

    public static g0 r(app.dogo.com.dogo_android.y.n.j j, CertificateInfo certificateInfo2) {
        return j.t(j, certificateInfo2);
    }

    private final void s() {
        Object disposable;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.y.n.j.b bVar;
        this.j.postValue(y.b.a);
        if (!this.h.a()) {
            this.f.s("program");
            unknownHostException = new UnknownHostException();
            aVar = new y.a(unknownHostException);
            this.j.postValue(aVar);
        } else {
            g gVar = new g(this);
            a0 observeOn = this.c.b(this.a.getProgramSaveInfo().getProgramId(), this.a.getProgramSaveInfo().getDogId()).flatMap(gVar).subscribeOn(a.b()).observeOn(a.b());
            n.e(observeOn, "certificateInteractor.getCertificateInfo(programInfo.programSaveInfo.programId, programInfo.programSaveInfo.dogId)\n                    .flatMap {\n                        if (it.certificateImageUrl.isBlank() || it.certificatePdfUrl.isBlank()) {\n                            generateInteractor.getCertificateInfo(programInfo.programSaveInfo.programId, programInfo.programSaveInfo.dogId)\n                        } else {\n                            Single.just(it)\n                        }\n                    }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            unknownHostException = new j.a(this);
            bVar = new j.b(this);
            getDisposable().b(a.g(observeOn, unknownHostException, bVar));
        }
    }

    private static final g0 t(app.dogo.com.dogo_android.y.n.j j, CertificateInfo certificateInfo2) {
        boolean programId;
        a0 obj1;
        Object obj2;
        n.f(j, "this$0");
        n.f(certificateInfo2, "it");
        if (!l.z(certificateInfo2.getCertificateImageUrl())) {
            if (l.z(certificateInfo2.getCertificatePdfUrl())) {
                obj1 = j.e.a(j.m().getProgramSaveInfo().getProgramId(), j.m().getProgramSaveInfo().getDogId());
            } else {
                n.e(a0.just(certificateInfo2), "{\n                            Single.just(it)\n                        }");
            }
        } else {
        }
        return obj1;
    }

    private final void v() {
        final int i = 0;
        j.c cVar = new j.c(this, i);
        k.d(f0.a(this), this.i, i, cVar, 2, 0);
    }

    private static final void x(app.dogo.com.dogo_android.y.n.j j, ImageView imageView2, c0 c03) {
        Object obj1;
        n.f(j, "this$0");
        n.f(imageView2, "$imageView");
        n.f(c03, "it");
        obj1 = j.g;
        c03.onSuccess((Uri)m.a(obj1.a(obj1.d(imageView2))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        this.f.d(s.a);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String getDogName() {
        return this.b;
    }

    public final LiveData<y<CertificateInfo>> getResult() {
        return this.k;
    }

    public final a<y<ProgramExamSummary>> l() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramExamSummary m() {
        return this.a;
    }

    public final a<Uri> n() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.a.allExamsCompleted();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        if (this.a.allExamsCompleted()) {
            s();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(ImageView imageView) {
        n.f(imageView, "imageView");
        f fVar = new f(this, imageView);
        a0 obj4 = a0.create(fVar).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj4, "create<Uri> {\n                try {\n                    val uri = Tasks.await(storageService.asyncSaveBitmapToExternalFile(storageService.getBitmap(imageView)))\n                    it.onSuccess(uri)\n                } catch (e: Exception) {\n                    Timber.e(e)\n                    it.tryOnError(e)\n                }\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        j.e eVar = new j.e(this);
        getDisposable().b(a.g(obj4, j.d.a, eVar));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(ProgramExamSummary programExamSummary) {
        n.f(programExamSummary, "<set-?>");
        this.a = programExamSummary;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        this.f.d(s.b);
    }
}
