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
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import com.google.android.gms.tasks.m;
import i.b.a0;
import i.b.c0;
import i.b.g0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: CertificateDetailViewModel.kt */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0008\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020-J\u0008\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u000200J\u0008\u00102\u001a\u000200H\u0002J\u000e\u00103\u001a\u0002002\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u000200J\u0006\u00107\u001a\u000200R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00150\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150&¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010 R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogName", "", "certificateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetCertificateInfoInteractor;", "programsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "generateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetCertificateInfoInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "getDogName", "()Ljava/lang/String;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "preload", "Lcom/hadilq/liveevent/LiveEvent;", "getPreload", "()Lcom/hadilq/liveevent/LiveEvent;", "getProgramInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "setProgramInfo", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;)V", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "saveToExternalFileLiveData", "Landroid/net/Uri;", "getSaveToExternalFileLiveData", "isExamDataMissing", "", "isProgramFinished", "loadCertificate", "", "loadCertificateIfCompleted", "loadExamData", "saveBitmapToExternalFile", "imageView", "Landroid/widget/ImageView;", "trackSaveTapped", "trackShareTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class CertificateDetailViewModel extends app.dogo.com.dogo_android.util.e0.s {

    /* renamed from: a, reason: from kotlin metadata */
    private ProgramExamSummary certificateInteractor;
    /* renamed from: b, reason: from kotlin metadata */
    private final String connectivityService;
    private final i2 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final v2 generateInteractor;
    private final j3 e;
    private final o3 f;
    private final t2 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final j2 programsInteractor;
    private final CoroutineExceptionHandler i = new j$f();
    private final x<y<CertificateInfo>> j = new x<>();
    /* renamed from: k, reason: from kotlin metadata */
    private final LiveData<y<CertificateInfo>> storageService = new x<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final f.d.a.a<y<ProgramExamSummary>> tracker = new a<>();
    private final f.d.a.a<Uri> m = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            j.this.j.postValue(new LoadResult_Error(th));
            a.d(th);
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<CertificateInfo, w> {
        @Override // kotlin.d0.d.p
        public final void a(CertificateInfo certificateInfo) {
            j.this.j.postValue(new LoadResult_Success(certificateInfo));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {

        public static final j.d a = new j$d();
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(th);
        }


        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Landroid/net/Uri;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.l<Uri, w> {
        @Override // kotlin.d0.d.p
        public final void a(Uri uri) {
            j.this.n().postValue(uri);
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ j a;
        public f(CoroutineExceptionHandler.a exc, j jVar) {
            this.a = jVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.j.postValue(new LoadResult_Error(exception));
            a.d(exception);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.certificate.CertificateDetailViewModel$loadExamData$1", f = "CertificateDetailViewModel.kt", l = 75, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String programId;
            Object obj;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    ProgramExamSummary programExamSummary = (ProgramExamList)obj.getProgramExamSummary();
                    n.d(programExamSummary);
                    j.this.l().postValue(new LoadResult_Success(programExamSummary));
                    return w.a;
                }
            }
            q.b(object);
            j.this.j.postValue(LoadResult_Loading.a);
            if (j.this.programsInteractor.a()) {
                this.label = i;
                if (j.this.generateInteractor.r(j.this.m().getProgramSaveInfo().getDogId(), j.this.m().getProgramSaveInfo().getProgramId(), this) == obj2) {
                    return obj2;
                }
            } else {
                j.this.f.setTrainingReminderUserProperties("program");
                j.this.j.postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        c(d<? super j.c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.j.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.j.c(j.this, dVar);
        }
    }
    public j(ProgramExamSummary programExamSummary, String str, i2 i2Var, v2 v2Var, j3 j3Var, o3 o3Var, t2 t2Var, j2 j2Var) {
        n.f(programExamSummary, "programInfo");
        n.f(str, "dogName");
        n.f(i2Var, "certificateInteractor");
        n.f(v2Var, "programsInteractor");
        n.f(j3Var, "generateInteractor");
        n.f(o3Var, "tracker");
        n.f(t2Var, "storageService");
        n.f(j2Var, "connectivityService");
        super();
        this.certificateInteractor = programExamSummary;
        this.connectivityService = str;
        this.c = i2Var;
        this.generateInteractor = v2Var;
        this.e = j3Var;
        this.f = o3Var;
        this.g = t2Var;
        this.programsInteractor = j2Var;
        final app.dogo.com.dogo_android.y.n.j.f coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
        x xVar = new x();
        f.d.a.a aVar2 = new a();
        f.d.a.a aVar3 = new a();
        if (isExamDataMissing()) {
            v();
        } else {
            u();
        }
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 saveBitmapToExternalFile(j imageView) {
        return imageView.programsInteractor;
    }

    public static final /* synthetic */ v2 i(j jVar) {
        return jVar.generateInteractor;
    }

    public static final /* synthetic */ o3 j(j jVar) {
        return jVar.f;
    }

    public static final /* synthetic */ x k(j jVar) {
        return jVar.j;
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final boolean isExamDataMissing() {
        boolean z = true;
        int r0 = this.certificateInteractor.getActiveExamsCount() == null ? 1 : 0;
        return (this.certificateInteractor.getActiveExamsCount() == null ? 1 : 0);
    }

    private final void s() {
        this.j.postValue(LoadResult_Loading.a);
        if (!this.programsInteractor.a()) {
            this.f.setTrainingReminderUserProperties("program");
            this.j.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            a0 observable2 = this.c.b(this.certificateInteractor.getProgramSaveInfo().getProgramId(), this.certificateInteractor.getProgramSaveInfo().getDogId()).flatMap(new kotlinx.coroutines.g(this)).subscribeOn(a.b()).observeOn(a.b());
            n.e(observable2, "certificateInteractor.getCertificateInfo(programInfo.programSaveInfo.programId, programInfo.programSaveInfo.dogId)\n                    .flatMap {\n                        if (it.certificateImageUrl.isBlank() || it.certificatePdfUrl.isBlank()) {\n                            generateInteractor.getCertificateInfo(programInfo.programSaveInfo.programId, programInfo.programSaveInfo.dogId)\n                        } else {\n                            Single.just(it)\n                        }\n                    }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new kotlinx.coroutines.j.a(this), new kotlinx.coroutines.j.b(this)));
        }
    }

    private static final g0 t(j jVar, CertificateInfo certificateInfo) {
        a0 just;
        n.f(jVar, "this$0");
        n.f(certificateInfo, "it");
        if (!l.z(certificateInfo.getCertificateImageUrl())) {
            if (l.z(certificateInfo.getCertificatePdfUrl())) {
                just = jVar.e.a(jVar.m().getProgramSaveInfo().getProgramId(), jVar.m().getProgramSaveInfo().getDogId());
            } else {
                str = "{\n                            Single.just(it)\n                        }";
                n.e(a0.just(certificateInfo), str);
            }
        }
        return just;
    }

    private final void v() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.i, dVar, new kotlinx.coroutines.j.c(this, dVar), 2, null);
    }

    private static final void x(j jVar, ImageView imageView, c0 c0Var) {
        n.f(jVar, "this$0");
        n.f(imageView, "$imageView");
        n.f(c0Var, "it");
        try {
            c0Var.onSuccess((Uri)m.a(jVar.g.a(jVar.g.d(imageView))));
        } catch (Exception e) {
            a.d(e);
            c0Var.a(e);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        this.f.logEvent(E_Certificate.a);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String getDogName() {
        return this.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<CertificateInfo>> getResult() {
        return this.storageService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<ProgramExamSummary>> l() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramExamSummary m() {
        return this.certificateInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Uri> n() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.certificateInteractor.allExamsCompleted();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        if (this.certificateInteractor.allExamsCompleted()) {
            s();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(ImageView imageView) {
        n.f(imageView, "imageView");
        a0 observable2 = a0.create(new kotlinx.coroutines.f(this, imageView)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "create<Uri> {\n                try {\n                    val uri = Tasks.await(storageService.asyncSaveBitmapToExternalFile(storageService.getBitmap(imageView)))\n                    it.onSuccess(uri)\n                } catch (e: Exception) {\n                    Timber.e(e)\n                    it.tryOnError(e)\n                }\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, kotlinx.coroutines.j.d.a, new kotlinx.coroutines.j.e(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(ProgramExamSummary programExamSummary) {
        n.f(programExamSummary, "<set-?>");
        this.certificateInteractor = programExamSummary;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        this.f.logEvent(E_Certificate.b);
    }

    public static /* synthetic */ void q(j jVar, ImageView imageView, c0 c0Var) {
        CertificateDetailViewModel.x(jVar, imageView, c0Var);
    }

    public static /* synthetic */ g0 r(j jVar, CertificateInfo certificateInfo) {
        return CertificateDetailViewModel.t(jVar, certificateInfo);
    }
}
