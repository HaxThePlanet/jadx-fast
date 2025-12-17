package app.dogo.com.dogo_android.service;

import android.net.Uri;
import app.dogo.com.dogo_android.k.p;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.b3.d;
import kotlinx.coroutines.b3.f;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.channels.w;
import kotlinx.coroutines.channels.w.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001:\u000234B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016J&\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J\u001c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u001a2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u0018\u0010\u001f\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J<\u0010 \u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\"0!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003J\u001c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J \u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cJ.\u0010.\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u0014002\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065", d2 = {"Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "", "challengeBucketName", "", "examBucketName", "(Ljava/lang/String;Ljava/lang/String;)V", "defaultBucket", "Lcom/google/firebase/storage/FirebaseStorage;", "challengesBucket", "examBucket", "(Lcom/google/firebase/storage/FirebaseStorage;Lcom/google/firebase/storage/FirebaseStorage;Lcom/google/firebase/storage/FirebaseStorage;)V", "challengeRef", "Lcom/google/firebase/storage/StorageReference;", "examRef", "storageRef", "downloadFile", "", "remotePath", "Lapp/dogo/com/dogo_android/enums/StoragePath;", "localPath", "Landroid/net/Uri;", "listener", "Lkotlin/Function0;", "downloadLogic", "reference", "fetchDownloadUri", "Lcom/google/android/gms/tasks/Task;", "bucket", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "getReference", "path", "getStorageReference", "uploadExamVideo", "Lkotlinx/coroutines/flow/Flow;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "executor", "Ljava/util/concurrent/Executor;", "uri", "dogId", "trickId", "examId", "uploadFile", "Lio/reactivex/Single;", "uploadLocalFileToRemote", "Lcom/google/firebase/storage/UploadTask;", "localFileUri", "uploadLogic", "successListener", "Lcom/google/android/gms/tasks/OnSuccessListener;", "failListener", "Lcom/google/android/gms/tasks/OnFailureListener;", "DownloadStatus", "StorageBucket", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l2 {

    private final StorageReference a;
    private final StorageReference b;
    private final StorageReference c;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "T", "", "()V", "Error", "Progress", "Success", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus$Success;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus$Error;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus$Progress;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "", "(Ljava/lang/String;I)V", "DEFAULT_BUCKET", "CHALLENGE_BUCKET", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        DEFAULT_BUCKET,
        CHALLENGE_BUCKET;
        private static final app.dogo.com.dogo_android.service.l2.b[] $values() {
            app.dogo.com.dogo_android.service.l2.b[] arr = new l2.b[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class c {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[l2.b.CHALLENGE_BUCKET.ordinal()] = 1;
            iArr[l2.b.DEFAULT_BUCKET.ordinal()] = 2;
            l2.c.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "Landroid/net/Uri;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.service.FireBaseStorageService$uploadExamVideo$1", f = "FireBaseStorageService.kt", l = 122, m = "invokeSuspend")
    static final class d extends k implements p<q<? super app.dogo.com.dogo_android.service.l2.a<? extends Uri>>, d<? super w>, Object> {

        final String $dogId;
        final String $examId;
        final Executor $executor;
        final String $trickId;
        final Uri $uri;
        private Object L$0;
        int label;
        final app.dogo.com.dogo_android.service.l2 this$0;
        d(app.dogo.com.dogo_android.service.l2 l2, String string2, String string3, String string4, Uri uri5, Executor executor6, d<? super app.dogo.com.dogo_android.service.l2.d> d7) {
            this.this$0 = l2;
            this.$dogId = string2;
            this.$trickId = string3;
            this.$examId = string4;
            this.$uri = uri5;
            this.$executor = executor6;
            super(2, d7);
        }

        private static final void e(q q, UploadTask.TaskSnapshot uploadTask$TaskSnapshot2) {
            l2.a.b bVar = new l2.a.b((int)i3);
            i.i(q.u(bVar));
        }

        private static final void f(q q, Exception exception2) {
            l2.a.a aVar = new l2.a.a(exception2);
            q.u(aVar);
            final int obj2 = 0;
            w.a.a(q, obj2, 1, obj2);
        }

        private static final void m(q q, UploadTask.TaskSnapshot uploadTask$TaskSnapshot2) {
            l2.a.c cVar = new l2.a.c(taskSnapshot2.getUploadSessionUri());
            q.u(cVar);
            int obj2 = 0;
            w.a.a(q, obj2, 1, obj2);
        }

        public static void n(q q, UploadTask.TaskSnapshot uploadTask$TaskSnapshot2) {
            l2.d.e(q, taskSnapshot2);
        }

        public static void o(q q, Exception exception2) {
            l2.d.f(q, exception2);
        }

        public static void q(q q, UploadTask.TaskSnapshot uploadTask$TaskSnapshot2) {
            l2.d.m(q, taskSnapshot2);
        }

        public final Object c(q<? super app.dogo.com.dogo_android.service.l2.a<? extends Uri>> q, d<? super w> d2) {
            return (l2.d)create(q, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.this$0, this.$dogId, this.$trickId, this.$examId, this.$uri, this.$executor, d2);
            dVar3.L$0 = object;
            return dVar3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((q)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            Executor $executor;
            app.dogo.com.dogo_android.service.t0 t0Var;
            String str;
            Object obj7;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
            }
            q.b(object);
            obj7 = this.L$0;
            StorageMetadata.Builder builder = new StorageMetadata.Builder();
            r0 r0Var = new r0((q)obj7);
            s0 s0Var = new s0(obj7);
            t0Var = new t0(obj7);
            l2.a(this.this$0).child(this.$dogId).child(this.$trickId).child(n.o(this.$examId, ".mp4")).putFile(this.$uri, builder.setContentType("video/mp4").build()).addOnProgressListener(this.$executor, r0Var).addOnFailureListener(this.$executor, s0Var).addOnSuccessListener(this.$executor, t0Var);
            this.label = i;
            label = 0;
            if (o.b(obj7, label, this, i, label) == obj) {
                return obj;
            }
        }
    }
    public l2(FirebaseStorage firebaseStorage, FirebaseStorage firebaseStorage2, FirebaseStorage firebaseStorage3) {
        n.f(firebaseStorage, "defaultBucket");
        n.f(firebaseStorage2, "challengesBucket");
        n.f(firebaseStorage3, "examBucket");
        super();
        StorageReference obj2 = firebaseStorage.getReference();
        n.e(obj2, "defaultBucket.reference");
        this.a = obj2;
        obj2 = firebaseStorage2.getReference();
        n.e(obj2, "challengesBucket.reference");
        this.b = obj2;
        obj2 = firebaseStorage3.getReference();
        n.e(obj2, "examBucket.reference");
        this.c = obj2;
    }

    public l2(String string, String string2) {
        final FirebaseStorage instance = FirebaseStorage.getInstance();
        n.e(instance, "getInstance()");
        n.d(string);
        final FirebaseStorage obj3 = FirebaseStorage.getInstance(string);
        n.e(obj3, "getInstance(challengeBucketName!!)");
        n.d(string2);
        final FirebaseStorage obj4 = FirebaseStorage.getInstance(string2);
        n.e(obj4, "getInstance(examBucketName!!)");
        super(instance, obj3, obj4);
    }

    public static final StorageReference a(app.dogo.com.dogo_android.service.l2 l2) {
        return l2.c;
    }

    private final void c(StorageReference storageReference, Uri uri2, a<w> a3) {
        p0 obj2 = new p0(a3);
        storageReference.getFile(uri2).addOnSuccessListener(obj2).addOnFailureListener(q0.a);
    }

    private static final void d(a a, FileDownloadTask.TaskSnapshot fileDownloadTask$TaskSnapshot2) {
        n.f(a, "$listener");
        a.invoke();
    }

    private static final void e(Exception exception) {
        a.d(exception);
    }

    private final StorageReference g(p p) {
        StorageReference obj2 = this.a.child(p.getPath());
        n.e(obj2, "storageRef.child(path.path)");
        return obj2;
    }

    private final StorageReference h(String string, app.dogo.com.dogo_android.service.l2.b l2$b2) {
        int i;
        StorageReference obj3;
        obj3 = l2.c.a[b2.ordinal()];
        if (obj3 != 1) {
            if (obj3 != 2) {
            } else {
                obj3 = this.a;
                StorageReference obj2 = obj3.child(string);
                n.e(obj2, "reference.child(remotePath)");
                return obj2;
            }
            obj2 = new NoWhenBranchMatchedException();
            throw obj2;
        }
        obj3 = this.b;
    }

    public static void i(c0 c0, Uri uri2) {
        l2.r(c0, uri2);
    }

    public static j j(StorageReference storageReference, j j2) {
        return l2.v(storageReference, j2);
    }

    public static void k(c0 c0, Exception exception2) {
        l2.s(c0, exception2);
    }

    public static void l(app.dogo.com.dogo_android.service.l2 l2, p p2, Uri uri3, c0 c04) {
        l2.q(l2, p2, uri3, c04);
    }

    public static void m(a a, FileDownloadTask.TaskSnapshot fileDownloadTask$TaskSnapshot2) {
        l2.d(a, taskSnapshot2);
    }

    public static void n(Exception exception) {
        l2.e(exception);
    }

    private static final void q(app.dogo.com.dogo_android.service.l2 l2, p p2, Uri uri3, c0 c04) {
        n.f(l2, "this$0");
        n.f(p2, "$remotePath");
        n.f(uri3, "$localPath");
        n.f(c04, "emitter");
        l0 l0Var = new l0(c04);
        n0 n0Var = new n0(c04);
        l2.u(l2.g(p2), uri3, l0Var, n0Var);
    }

    private static final void r(c0 c0, Uri uri2) {
        n.f(c0, "$emitter");
        c0.onSuccess(uri2);
    }

    private static final void s(c0 c0, Exception exception2) {
        n.f(c0, "$emitter");
        c0.a(exception2);
    }

    private final void u(StorageReference storageReference, Uri uri2, g<Uri> g3, f f4) {
        final UploadTask obj3 = storageReference.putFile(uri2);
        n.e(obj3, "reference.putFile(localPath)");
        m0 m0Var = new m0(storageReference);
        obj3.continueWithTask(m0Var).addOnFailureListener(f4).addOnSuccessListener(g3);
    }

    private static final j v(StorageReference storageReference, j j2) {
        n.f(storageReference, "$reference");
        if (!j2.isSuccessful()) {
        } else {
            return storageReference.getDownloadUrl();
        }
        Exception obj1 = j2.getException();
        n.d(obj1);
        throw obj1;
    }

    public final void b(p p, Uri uri2, a<w> a3) {
        n.f(p, "remotePath");
        n.f(uri2, "localPath");
        n.f(a3, "listener");
        c(g(p), uri2, a3);
    }

    public final j<Uri> f(String string, app.dogo.com.dogo_android.service.l2.b l2$b2) {
        n.f(string, "remotePath");
        n.f(b2, "bucket");
        j obj2 = h(string, b2).getDownloadUrl();
        n.e(obj2, "getStorageReference(remotePath, bucket).downloadUrl");
        return obj2;
    }

    public final d<app.dogo.com.dogo_android.service.l2.a<Uri>> o(Executor executor, Uri uri2, String string3, String string4, String string5) {
        n.f(executor, "executor");
        n.f(uri2, "uri");
        n.f(string3, "dogId");
        n.f(string4, "trickId");
        n.f(string5, "examId");
        super(this, string3, string4, string5, uri2, executor, 0);
        return f.a(dVar);
    }

    public final a0<Uri> p(p p, Uri uri2) {
        n.f(p, "remotePath");
        n.f(uri2, "localPath");
        o0 o0Var = new o0(this, p, uri2);
        final a0 obj2 = a0.create(o0Var);
        n.e(obj2, "create { emitter ->\n            val reference = getReference(remotePath)\n            uploadLogic(\n                reference,\n                localPath,\n                successListener = {\n                    emitter.onSuccess(it)\n                },\n                failListener = {\n                    emitter.tryOnError(it)\n                }\n            )\n        }");
        return obj2;
    }

    public final UploadTask t(Uri uri, String string2, app.dogo.com.dogo_android.service.l2.b l2$b3) {
        n.f(string2, "remotePath");
        n.f(b3, "bucket");
        n.d(uri);
        final UploadTask obj2 = h(string2, b3).putFile(uri);
        n.e(obj2, "storageReference.putFile(localFileUri!!)");
        return obj2;
    }
}
