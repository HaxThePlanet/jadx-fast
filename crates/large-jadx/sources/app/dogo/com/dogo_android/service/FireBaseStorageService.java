package app.dogo.com.dogo_android.service;

import android.net.Uri;
import com.google.android.gms.tasks.j;
import com.google.firebase.storage.FileDownloadTask.TaskSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata.Builder;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.UploadTask.TaskSnapshot;
import i.b.a0;
import i.b.c0;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.j.b;
import kotlin.b0.k.a.k;
import kotlin.d0.d.n;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.w.a;

/* compiled from: FireBaseStorageService.kt */
@Metadata(d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001:\u000234B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016J&\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J\u001c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u001a2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u0018\u0010\u001f\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J<\u0010 \u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\"0!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003J\u001c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J \u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cJ.\u0010.\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u0014002\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065", d2 = {"Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "", "challengeBucketName", "", "examBucketName", "(Ljava/lang/String;Ljava/lang/String;)V", "defaultBucket", "Lcom/google/firebase/storage/FirebaseStorage;", "challengesBucket", "examBucket", "(Lcom/google/firebase/storage/FirebaseStorage;Lcom/google/firebase/storage/FirebaseStorage;Lcom/google/firebase/storage/FirebaseStorage;)V", "challengeRef", "Lcom/google/firebase/storage/StorageReference;", "examRef", "storageRef", "downloadFile", "", "remotePath", "Lapp/dogo/com/dogo_android/enums/StoragePath;", "localPath", "Landroid/net/Uri;", "listener", "Lkotlin/Function0;", "downloadLogic", "reference", "fetchDownloadUri", "Lcom/google/android/gms/tasks/Task;", "bucket", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "getReference", "path", "getStorageReference", "uploadExamVideo", "Lkotlinx/coroutines/flow/Flow;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "executor", "Ljava/util/concurrent/Executor;", "uri", "dogId", "trickId", "examId", "uploadFile", "Lio/reactivex/Single;", "uploadLocalFileToRemote", "Lcom/google/firebase/storage/UploadTask;", "localFileUri", "uploadLogic", "successListener", "Lcom/google/android/gms/tasks/OnSuccessListener;", "failListener", "Lcom/google/android/gms/tasks/OnFailureListener;", "DownloadStatus", "StorageBucket", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l2, reason: from kotlin metadata */
public final class FireBaseStorageService {

    /* renamed from: a, reason: from kotlin metadata */
    private final StorageReference challengeRef;
    /* renamed from: b, reason: from kotlin metadata */
    private final StorageReference examRef;
    /* renamed from: c, reason: from kotlin metadata */
    private final StorageReference storageRef;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "T", "", "()V", "Error", "Progress", "Success", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus$Success;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus$Error;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus$Progress;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a<out T> {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "", "(Ljava/lang/String;I)V", "DEFAULT_BUCKET", "CHALLENGE_BUCKET", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        CHALLENGE_BUCKET,
        DEFAULT_BUCKET;
        private static final /* synthetic */ l2.b[] $values() {
            app.dogo.com.dogo_android.service.l2.b[] arr = new l2.b[2];
            return new l2.b[] { FireBaseStorageService_StorageBucket.DEFAULT_BUCKET, FireBaseStorageService_StorageBucket.CHALLENGE_BUCKET };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class c {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[FireBaseStorageService_StorageBucket.values().length];
            iArr[FireBaseStorageService_StorageBucket.CHALLENGE_BUCKET.ordinal()] = 1;
            iArr[FireBaseStorageService_StorageBucket.DEFAULT_BUCKET.ordinal()] = 2;
            l2.c.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "Landroid/net/Uri;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.service.FireBaseStorageService$uploadExamVideo$1", f = "FireBaseStorageService.kt", l = 122, m = "invokeSuspend")
    static final class d extends k implements kotlin.d0.c.p<kotlinx.coroutines.channels.q<? super l2.a<? extends Uri>>, kotlin.b0.d<? super kotlin.w>, Object> {

        final /* synthetic */ String $dogId;
        final /* synthetic */ String $examId;
        final /* synthetic */ Executor $executor;
        final /* synthetic */ String $trickId;
        final /* synthetic */ Uri $uri;
        private /* synthetic */ Object L$0;
        int label;
        private static final void e(kotlinx.coroutines.channels.q qVar, UploadTask.TaskSnapshot taskSnapshot) {
            ChannelResult.i(qVar.u(new FireBaseStorageService_DownloadStatus_Progress((int)(long)100 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount())));
        }

        private static final void f(kotlinx.coroutines.channels.q qVar, Exception exc) {
            qVar.u(new FireBaseStorageService_DownloadStatus_Error(exc));
            final Throwable th = null;
            kotlinx.coroutines.internal.w.a.a(qVar, th, 1, th);
        }

        private static final void m(kotlinx.coroutines.channels.q qVar, UploadTask.TaskSnapshot taskSnapshot) {
            qVar.u(new FireBaseStorageService_DownloadStatus_Success(taskSnapshot.getUploadSessionUri()));
            Throwable th = null;
            kotlinx.coroutines.internal.w.a.a(qVar, th, 1, th);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0 && this.label == i) {
                q.b(object);
                return w.a;
            }
            q.b(object);
            str = "video/mp4";
            l2.this.storageRef.child(this.$dogId).child(this.$trickId).child(n.o(this.$examId, ".mp4")).putFile(this.$uri, new StorageMetadata.Builder().setContentType(str).build()).addOnProgressListener(this.$executor, new r0(l$02)).addOnFailureListener(this.$executor, new s0(l$02)).addOnSuccessListener(this.$executor, new t0(l$02));
            this.label = i;
            kotlin.d0.c.a aVar = null;
            if (kotlinx.coroutines.internal.o.b(l$02, aVar, this, i, aVar) == obj2) {
                return obj2;
            }
        }

        d(String str, String str2, String str3, Uri uri, Executor executor, kotlin.b0.d<? super l2.d> dVar) {
            this.$dogId = str;
            this.$trickId = str2;
            this.$examId = str3;
            this.$uri = uri;
            this.$executor = executor;
            super(2, dVar);
        }

        public static /* synthetic */ void n(kotlinx.coroutines.channels.q qVar, UploadTask.TaskSnapshot taskSnapshot) {
            l2.d.e(qVar, taskSnapshot);
        }

        public static /* synthetic */ void o(kotlinx.coroutines.channels.q qVar, Exception exc) {
            l2.d.f(qVar, exc);
        }

        public static /* synthetic */ void q(kotlinx.coroutines.channels.q qVar, UploadTask.TaskSnapshot taskSnapshot) {
            l2.d.m(qVar, taskSnapshot);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(kotlinx.coroutines.channels.q<? super l2.a<? extends Uri>> qVar, kotlin.b0.d<? super kotlin.w> dVar) {
            return (l2.d)create(qVar, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<kotlin.w> create(Object object, kotlin.b0.d<?> dVar) {
            dVar = new l2.d(l2.this, this.$dogId, this.$trickId, this.$examId, this.$uri, this.$executor, dVar);
            dVar.L$0 = object;
            return dVar;
        }
    }
    public l2(FirebaseStorage firebaseStorage, FirebaseStorage firebaseStorage2, FirebaseStorage firebaseStorage3) {
        n.f(firebaseStorage, "defaultBucket");
        n.f(firebaseStorage2, "challengesBucket");
        n.f(firebaseStorage3, "examBucket");
        super();
        StorageReference reference = firebaseStorage.getReference();
        n.e(reference, "defaultBucket.reference");
        this.challengeRef = reference;
        StorageReference reference2 = firebaseStorage2.getReference();
        n.e(reference2, "challengesBucket.reference");
        this.examRef = reference2;
        StorageReference reference3 = firebaseStorage3.getReference();
        n.e(reference3, "examBucket.reference");
        this.storageRef = reference3;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ StorageReference getReference(l2 path) {
        return path.storageRef;
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final void downloadFile(StorageReference remotePath, Uri localPath, kotlin.d0.c.a<kotlin.w> listener) {
        remotePath.getFile(localPath).addOnSuccessListener(new p0(listener)).addOnFailureListener(q0.a);
    }

    /* renamed from: d, reason: from kotlin metadata */
    private static final void fetchDownloadUri(kotlin.d0.c.a remotePath, FileDownloadTask.TaskSnapshot bucket) {
        n.f(remotePath, "$listener");
        remotePath.invoke();
    }

    private static final void e(Exception exc) {
        a.d(exc);
    }

    private final StorageReference g(app.dogo.com.dogo_android.k.p pVar) {
        StorageReference child = this.challengeRef.child(pVar.getPath());
        n.e(child, "storageRef.child(path.path)");
        return child;
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final StorageReference getStorageReference(String remotePath, l2.b bucket) throws NoWhenBranchMatchedException {
        StorageReference challengeRef2;
        int i2 = l2.c.a[bucket.ordinal()];
        int i = 1;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                StorageReference child = challengeRef2.child(remotePath);
                n.e(child, "reference.child(remotePath)");
                return child;
            }
        }
    }

    private static final void q(l2 l2Var, app.dogo.com.dogo_android.k.p pVar, Uri uri, c0 c0Var) {
        n.f(l2Var, "this$0");
        n.f(pVar, "$remotePath");
        n.f(uri, "$localPath");
        n.f(c0Var, "emitter");
        l2Var.u(l2Var.g(pVar), uri, new l0(c0Var), new n0(c0Var));
    }

    private static final void r(c0 c0Var, Uri uri) {
        n.f(c0Var, "$emitter");
        c0Var.onSuccess(uri);
    }

    private static final void s(c0 c0Var, Exception exc) {
        n.f(c0Var, "$emitter");
        c0Var.a(exc);
    }

    private final void u(StorageReference storageReference, Uri uri, com.google.android.gms.tasks.g<Uri> gVar, com.google.android.gms.tasks.f fVar) {
        final UploadTask file = storageReference.putFile(uri);
        n.e(file, "reference.putFile(localPath)");
        file.continueWithTask(new m0(storageReference)).addOnFailureListener(fVar).addOnSuccessListener(gVar);
    }

    private static final j v(StorageReference storageReference, j jVar) {
        n.f(storageReference, "$reference");
        if (!jVar.isSuccessful()) {
            Exception exception = jVar.getException();
            n.d(exception);
            throw exception;
        } else {
            return storageReference.getDownloadUrl();
        }
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void downloadLogic(app.dogo.com.dogo_android.k.p reference, Uri localPath, kotlin.d0.c.a<kotlin.w> listener) {
        n.f(reference, "remotePath");
        n.f(localPath, "localPath");
        n.f(listener, "listener");
        downloadFile(g(reference), localPath, listener);
    }

    public final j<Uri> f(String str, l2.b bVar) {
        n.f(str, "remotePath");
        n.f(bVar, "bucket");
        j downloadUrl = getStorageReference(str, bVar).getDownloadUrl();
        n.e(downloadUrl, "getStorageReference(remotePath, bucket).downloadUrl");
        return downloadUrl;
    }

    /* renamed from: o, reason: from kotlin metadata */
    public final kotlinx.coroutines.b3.d<l2.a<Uri>> uploadExamVideo(Executor executor, Uri uri, String dogId, String trickId, String examId) {
        n.f(executor, "executor");
        n.f(uri, "uri");
        n.f(dogId, "dogId");
        n.f(trickId, "trickId");
        n.f(examId, "examId");
        l2.d dVar = new l2.d(this, dogId, trickId, examId, uri, executor, null);
        return kotlinx.coroutines.flow.f.a(dVar);
    }

    public final a0<Uri> p(app.dogo.com.dogo_android.k.p pVar, Uri uri) {
        n.f(pVar, "remotePath");
        n.f(uri, "localPath");
        final a0 a0Var = a0.create(new o0(this, pVar, uri));
        n.e(a0Var, "create { emitter ->\n            val reference = getReference(remotePath)\n            uploadLogic(\n                reference,\n                localPath,\n                successListener = {\n                    emitter.onSuccess(it)\n                },\n                failListener = {\n                    emitter.tryOnError(it)\n                }\n            )\n        }");
        return a0Var;
    }

    /* renamed from: t, reason: from kotlin metadata */
    public final UploadTask uploadLocalFileToRemote(Uri localFileUri, String remotePath, l2.b bucket) {
        n.f(remotePath, "remotePath");
        n.f(bucket, "bucket");
        n.d(localFileUri);
        final UploadTask file = getStorageReference(remotePath, bucket).putFile(localFileUri);
        n.e(file, "storageReference.putFile(localFileUri!!)");
        return file;
    }

    public l2(String str, String str2) {
        final FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        n.e(firebaseStorage, "getInstance()");
        n.d(str);
        final FirebaseStorage firebaseStorage2 = FirebaseStorage.getInstance(str);
        n.e(firebaseStorage2, "getInstance(challengeBucketName!!)");
        n.d(str2);
        final FirebaseStorage firebaseStorage3 = FirebaseStorage.getInstance(str2);
        n.e(firebaseStorage3, "getInstance(examBucketName!!)");
        this(firebaseStorage, firebaseStorage2, firebaseStorage3);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static /* synthetic */ void uploadFile(c0 remotePath, Uri localPath) {
        FireBaseStorageService.r(remotePath, localPath);
    }

    public static /* synthetic */ j j(StorageReference storageReference, j jVar) {
        return FireBaseStorageService.v(storageReference, jVar);
    }

    public static /* synthetic */ void k(c0 c0Var, Exception exc) {
        FireBaseStorageService.s(c0Var, exc);
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static /* synthetic */ void uploadLogic(l2 reference, app.dogo.com.dogo_android.k.p localPath, Uri successListener, c0 failListener) {
        FireBaseStorageService.q(reference, localPath, successListener, failListener);
    }

    public static /* synthetic */ void m(kotlin.d0.c.a aVar, FileDownloadTask.TaskSnapshot taskSnapshot) {
        FireBaseStorageService.fetchDownloadUri(aVar, taskSnapshot);
    }

    public static /* synthetic */ void n(Exception exc) {
        FireBaseStorageService.e(exc);
    }
}
