package app.dogo.com.dogo_android.exam.j;

import android.net.Uri;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.g;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.service.l2;
import app.dogo.com.dogo_android.service.l2.a;
import app.dogo.com.dogo_android.service.l2.a.a;
import app.dogo.com.dogo_android.service.l2.a.b;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.u2;
import f.d.a.a;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.m0;

/* compiled from: ExamPlaybackViewModel.kt */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0008\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001dJ)\u0010\"\u001a\u00020\u001d2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "videoUri", "Landroid/net/Uri;", "examUploadData", "Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "storageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Landroid/net/Uri;Lapp/dogo/com/dogo_android/exam/ExamUploadData;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "uploadComplete", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getUploadComplete", "()Lcom/hadilq/liveevent/LiveEvent;", "uploadProgress", "Landroidx/lifecycle/MutableLiveData;", "", "getUploadProgress", "()Landroidx/lifecycle/MutableLiveData;", "getVideoUri", "()Landroid/net/Uri;", "startUpload", "", "executor", "Ljava/util/concurrent/Executor;", "trackExamUpload", "trackRetake", "updateState", "state", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "examId", "", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class ExamPlaybackViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final Uri examUploadData;
    /* renamed from: b, reason: from kotlin metadata */
    private final g firestoreService;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 programRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final m2 storageService;
    /* renamed from: e, reason: from kotlin metadata */
    private final l2 tracker;
    private final j1 f;
    private final x<Integer> g = new x<>(0);
    private final a<y<Boolean>> h = new a<>();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.exam.playback.ExamPlaybackViewModel", f = "ExamPlaybackViewModel.kt", l = 55, m = "updateState")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super i.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            l2.a aVar = null;
            return i.this.r(aVar, aVar, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.exam.playback.ExamPlaybackViewModel$startUpload$1", f = "ExamPlaybackViewModel.kt", l = 76, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ Executor $executor;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    return w.a;
                }
            }
            q.b(object);
            String object2 = i.this.storageService.F(i.this.firestoreService.a(), i.this.firestoreService.e());
            this.label = i;
            if (i.this.tracker.o(this.$executor, i.this.n(), i.this.firestoreService.a(), i.this.firestoreService.e(), object2).a(new FlowKt__CollectKt_collect_3(i.this, object2), this) == obj2) {
                return obj2;
            }
        }

        a(Executor executor, kotlin.b0.d<? super i.a> dVar) {
            this.$executor = executor;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.exam.playback.i.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.exam.playback.i.a(i.this, this.$executor, dVar);
        }
    }
    public i(Uri uri, g gVar, o3 o3Var, m2 m2Var, l2 l2Var, j1 j1Var) {
        n.f(uri, "videoUri");
        n.f(gVar, "examUploadData");
        n.f(o3Var, "tracker");
        n.f(m2Var, "firestoreService");
        n.f(l2Var, "storageService");
        n.f(j1Var, "programRepository");
        super();
        this.examUploadData = uri;
        this.firestoreService = gVar;
        this.programRepository = o3Var;
        this.storageService = m2Var;
        this.tracker = l2Var;
        this.f = j1Var;
        x xVar = new x(null);
        a aVar = new a();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ g startUpload(i executor) {
        return executor.firestoreService;
    }

    public static final /* synthetic */ m2 i(i iVar) {
        return iVar.storageService;
    }

    public static final /* synthetic */ l2 j(i iVar) {
        return iVar.tracker;
    }

    public static final /* synthetic */ Object k(i iVar, l2.a aVar, String str, kotlin.b0.d dVar) {
        return iVar.r(aVar, str, dVar);
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final void trackExamUpload() {
        this.programRepository.d(E_Training.g.d(u.a(new EP_TrickId(), this.firestoreService.e())));
    }

    private final Object r(l2.a<? extends Uri> aVar, String str, kotlin.b0.d<? super w> dVar) {
        app.dogo.com.dogo_android.exam.j.i.b bVar;
        int label2;
        int label22;
        int i = -2147483648;
        int i2;
        String str22;
        Object obj;
        z = dVar instanceof app.dogo.com.dogo_android.exam.playback.i.b;
        if (dVar instanceof app.dogo.com.dogo_android.exam.playback.i.b) {
            Object dVar32 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                bVar = new app.dogo.com.dogo_android.exam.playback.i.b(this, dVar);
            }
        }
        final Object obj3 = bVar;
        Object obj2 = b.d();
        final int i3 = 1;
        if (obj3.label != 0) {
            if (obj3.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(obj3.result);
                obj.trackExamUpload();
                obj.l().postValue(new LoadResult_Success(b.a(true)));
                return w.a;
            }
        }
        q.b(obj3.result);
        if (!(aVar instanceof FireBaseStorageService_DownloadStatus_Progress)) {
            if (!(aVar instanceof FireBaseStorageService_DownloadStatus_Error)) {
                if (aVar instanceof FireBaseStorageService_DownloadStatus_Success) {
                    obj3.L$0 = this;
                    obj3.label = i3;
                    if (this.f.z(this.firestoreService.a(), this.firestoreService.c(), this.firestoreService.e(), str, obj3) == obj2) {
                        return obj2;
                    }
                    app.dogo.com.dogo_android.exam.j.i aVar3 = this;
                }
            } else {
                m().postValue(null);
                l().postValue(new LoadResult_Error(aVar.a()));
            }
        } else {
            m().postValue(b.c(aVar.a()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<y<Boolean>> l() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> m() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Uri n() {
        return this.examUploadData;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o(Executor executor) {
        n.f(executor, "executor");
        kotlinx.coroutines.internal.k.d(f0.a(this), null, null, new app.dogo.com.dogo_android.exam.playback.i.a(this, executor, null), 3, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        this.programRepository.d(E_Training.f.d(u.a(new EP_TrickId(), this.firestoreService.e())));
    }
}
