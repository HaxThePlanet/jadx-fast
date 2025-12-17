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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.b3.d;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0008\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001dJ)\u0010\"\u001a\u00020\u001d2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "videoUri", "Landroid/net/Uri;", "examUploadData", "Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "storageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Landroid/net/Uri;Lapp/dogo/com/dogo_android/exam/ExamUploadData;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "uploadComplete", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getUploadComplete", "()Lcom/hadilq/liveevent/LiveEvent;", "uploadProgress", "Landroidx/lifecycle/MutableLiveData;", "", "getUploadProgress", "()Landroidx/lifecycle/MutableLiveData;", "getVideoUri", "()Landroid/net/Uri;", "startUpload", "", "executor", "Ljava/util/concurrent/Executor;", "trackExamUpload", "trackRetake", "updateState", "state", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;", "examId", "", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService$DownloadStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends s {

    private final Uri a;
    private final g b;
    private final o3 c;
    private final m2 d;
    private final l2 e;
    private final j1 f;
    private final x<Integer> g;
    private final a<y<Boolean>> h;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.exam.playback.ExamPlaybackViewModel", f = "ExamPlaybackViewModel.kt", l = 55, m = "updateState")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.exam.j.i this$0;
        b(app.dogo.com.dogo_android.exam.j.i i, d<? super app.dogo.com.dogo_android.exam.j.i.b> d2) {
            this.this$0 = i;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return i.k(this.this$0, i2, i2, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.exam.playback.ExamPlaybackViewModel$startUpload$1", f = "ExamPlaybackViewModel.kt", l = 76, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final Executor $executor;
        int label;
        final app.dogo.com.dogo_android.exam.j.i this$0;
        a(app.dogo.com.dogo_android.exam.j.i i, Executor executor2, d<? super app.dogo.com.dogo_android.exam.j.i.a> d3) {
            this.this$0 = i;
            this.$executor = executor2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (i.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            i.a obj3 = new i.a(this.this$0, this.$executor, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            app.dogo.com.dogo_android.exam.j.i this$0;
            app.dogo.com.dogo_android.exam.j.i.a.a aVar;
            Executor $executor;
            Uri uri;
            String str3;
            String str2;
            String str;
            Object obj11;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
            }
            q.b(object);
            obj11 = i.i(this.this$0).F(i.h(this.this$0).a(), i.h(this.this$0).e());
            aVar = new i.a.a(this.this$0, obj11);
            this.label = i;
            if (i.j(this.this$0).o(this.$executor, this.this$0.n(), i.h(this.this$0).a(), i.h(this.this$0).e(), obj11).a(aVar, this) == obj) {
                return obj;
            }
        }
    }
    public i(Uri uri, g g2, o3 o33, m2 m24, l2 l25, j1 j16) {
        n.f(uri, "videoUri");
        n.f(g2, "examUploadData");
        n.f(o33, "tracker");
        n.f(m24, "firestoreService");
        n.f(l25, "storageService");
        n.f(j16, "programRepository");
        super();
        this.a = uri;
        this.b = g2;
        this.c = o33;
        this.d = m24;
        this.e = l25;
        this.f = j16;
        x obj2 = new x(0);
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
    }

    public static final g h(app.dogo.com.dogo_android.exam.j.i i) {
        return i.b;
    }

    public static final m2 i(app.dogo.com.dogo_android.exam.j.i i) {
        return i.d;
    }

    public static final l2 j(app.dogo.com.dogo_android.exam.j.i i) {
        return i.e;
    }

    public static final Object k(app.dogo.com.dogo_android.exam.j.i i, l2.a l2$a2, String string3, d d4) {
        return i.r(a2, string3, d4);
    }

    private final void p() {
        n2 n2Var = new n2();
        this.c.d(p0.g.d(u.a(n2Var, this.b.e())));
    }

    private final Object r(l2.a<? extends Uri> l2$a, String string2, d<? super w> d3) {
        boolean bVar;
        int label;
        int label2;
        int i;
        int i2;
        String str2;
        String str;
        a obj9;
        Object obj10;
        Boolean obj11;
        bVar = d3;
        label = bVar.label;
        i = Integer.MIN_VALUE;
        if (d3 instanceof i.b && label & i != 0) {
            bVar = d3;
            label = bVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                bVar.label = label -= i;
            } else {
                bVar = new i.b(this, d3);
            }
        } else {
        }
        final app.dogo.com.dogo_android.exam.j.i.b bVar2 = bVar;
        obj11 = bVar2.result;
        Object obj = b.d();
        label2 = bVar2.label;
        final int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                obj9 = bVar2.L$0;
                q.b(obj11);
                obj9.p();
                obj10 = new y.c(b.a(i3));
                obj9.l().postValue(obj10);
                return w.a;
            }
            obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj9;
        }
        q.b(obj11);
        if (a instanceof l2.a.b) {
            m().postValue(b.c((l2.a.b)a.a()));
        } else {
            if (a instanceof l2.a.a) {
                m().postValue(0);
                obj11 = new y.a((l2.a.a)a.a());
                l().postValue(obj11);
            } else {
                bVar2.L$0 = this;
                bVar2.label = i3;
                if (a instanceof l2.a.c && this.f.z(this.b.a(), this.b.c(), this.b.e(), string2, bVar2) == obj) {
                    bVar2.L$0 = this;
                    bVar2.label = i3;
                    if (this.f.z(this.b.a(), this.b.c(), this.b.e(), string2, bVar2) == obj) {
                        return obj;
                    }
                    obj9 = this;
                }
            }
        }
    }

    public final a<y<Boolean>> l() {
        return this.h;
    }

    public final x<Integer> m() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Uri n() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o(Executor executor) {
        n.f(executor, "executor");
        i.a aVar = new i.a(this, executor, 0);
        k.d(f0.a(this), 0, 0, aVar, 3, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        n2 n2Var = new n2();
        this.c.d(p0.f.d(u.a(n2Var, this.b.e())));
    }
}
