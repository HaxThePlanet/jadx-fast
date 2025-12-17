package com.google.firebase.storage;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.d;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class StorageTask<ResultT extends com.google.firebase.storage.StorageTask.ProvideError>  extends com.google.firebase.storage.ControllableTask<ResultT> {

    static final int INTERNAL_STATE_CANCELED = 256;
    static final int INTERNAL_STATE_CANCELING = 32;
    static final int INTERNAL_STATE_FAILURE = 64;
    static final int INTERNAL_STATE_IN_PROGRESS = 4;
    static final int INTERNAL_STATE_NOT_STARTED = 1;
    static final int INTERNAL_STATE_PAUSED = 16;
    static final int INTERNAL_STATE_PAUSING = 8;
    static final int INTERNAL_STATE_QUEUED = 2;
    static final int INTERNAL_STATE_SUCCESS = 128;
    static final int STATES_CANCELED = 256;
    static final int STATES_COMPLETE = 448;
    static final int STATES_FAILURE = 64;
    static final int STATES_INPROGRESS = -465;
    static final int STATES_PAUSED = 16;
    static final int STATES_SUCCESS = 128;
    private static final String TAG = "StorageTask";
    private static final HashMap<Integer, HashSet<Integer>> ValidTaskInitiatedStateChanges;
    private static final HashMap<Integer, HashSet<Integer>> ValidUserInitiatedStateChanges;
    final com.google.firebase.storage.TaskListenerImpl<d, ResultT> cancelManager;
    final com.google.firebase.storage.TaskListenerImpl<e<ResultT>, ResultT> completeListener;
    private volatile int currentState = 1;
    final com.google.firebase.storage.TaskListenerImpl<f, ResultT> failureManager;
    private ResultT finalResult;
    final com.google.firebase.storage.TaskListenerImpl<com.google.firebase.storage.OnPausedListener<? super ResultT>, ResultT> pausedManager;
    final com.google.firebase.storage.TaskListenerImpl<com.google.firebase.storage.OnProgressListener<? super ResultT>, ResultT> progressManager;
    final com.google.firebase.storage.TaskListenerImpl<g<? super ResultT>, ResultT> successManager;
    protected final Object syncObject;

    protected interface ProvideError {
        public abstract Exception getError();
    }

    public class SnapshotBase implements com.google.firebase.storage.StorageTask.ProvideError {

        private final Exception error;
        final com.google.firebase.storage.StorageTask this$0;
        public SnapshotBase(com.google.firebase.storage.StorageTask storageTask, Exception exception2) {
            com.google.firebase.storage.StorageTask obj1;
            Exception obj2;
            this.this$0 = storageTask;
            super();
            if (exception2 == null) {
                if (storageTask.isCanceled() != null) {
                    this.error = StorageException.fromErrorStatus(Status.B);
                } else {
                    if (storageTask.getInternalState() == 64) {
                        this.error = StorageException.fromErrorStatus(Status.z);
                    } else {
                        this.error = 0;
                    }
                }
            } else {
                this.error = exception2;
            }
        }

        @Override // com.google.firebase.storage.StorageTask$ProvideError
        public Exception getError() {
            return this.error;
        }

        @Override // com.google.firebase.storage.StorageTask$ProvideError
        public com.google.firebase.storage.StorageReference getStorage() {
            return getTask().getStorage();
        }

        public com.google.firebase.storage.StorageTask<ResultT> getTask() {
            return this.this$0;
        }
    }
    static {
        HashMap hashMap = new HashMap();
        StorageTask.ValidUserInitiatedStateChanges = hashMap;
        HashMap hashMap2 = new HashMap();
        StorageTask.ValidTaskInitiatedStateChanges = hashMap2;
        int i = 1;
        Integer valueOf = Integer.valueOf(i);
        final int i4 = 2;
        Integer valueOf3 = Integer.valueOf(i4);
        Integer[] arr4 = new Integer[i4];
        Integer valueOf5 = 16;
        final int i7 = 0;
        arr4[i7] = valueOf5;
        Integer valueOf6 = 256;
        arr4[i] = valueOf6;
        HashSet hashSet6 = new HashSet(Arrays.asList(arr4));
        hashMap.put(valueOf, hashSet6);
        Integer[] arr5 = new Integer[i4];
        Integer valueOf7 = 8;
        arr5[i7] = valueOf7;
        Integer valueOf8 = 32;
        arr5[i] = valueOf8;
        HashSet hashSet7 = new HashSet(Arrays.asList(arr5));
        hashMap.put(valueOf3, hashSet7);
        Integer valueOf2 = 4;
        Integer[] arr6 = new Integer[i4];
        arr6[i7] = valueOf7;
        arr6[i] = valueOf8;
        HashSet hashSet8 = new HashSet(Arrays.asList(arr6));
        hashMap.put(valueOf2, hashSet8);
        Integer[] arr7 = new Integer[i4];
        arr7[i7] = valueOf3;
        arr7[i] = valueOf6;
        HashSet hashSet9 = new HashSet(Arrays.asList(arr7));
        hashMap.put(valueOf5, hashSet9);
        Integer valueOf4 = 64;
        Integer[] arr10 = new Integer[i4];
        arr10[i7] = valueOf3;
        arr10[i] = valueOf6;
        HashSet hashSet10 = new HashSet(Arrays.asList(arr10));
        hashMap.put(valueOf4, hashSet10);
        Integer[] arr8 = new Integer[i4];
        arr8[i7] = valueOf3;
        arr8[i] = valueOf4;
        HashSet hashSet = new HashSet(Arrays.asList(arr8));
        hashMap2.put(valueOf, hashSet);
        int i2 = 3;
        Integer[] arr9 = new Integer[i2];
        arr9[i7] = valueOf2;
        arr9[i] = valueOf4;
        Integer valueOf9 = 128;
        arr9[i4] = valueOf9;
        HashSet hashSet2 = new HashSet(Arrays.asList(arr9));
        hashMap2.put(valueOf3, hashSet2);
        Integer[] arr3 = new Integer[i2];
        arr3[i7] = valueOf2;
        arr3[i] = valueOf4;
        arr3[i4] = valueOf9;
        HashSet hashSet3 = new HashSet(Arrays.asList(arr3));
        hashMap2.put(valueOf2, hashSet3);
        Integer[] arr2 = new Integer[i2];
        arr2[i7] = valueOf5;
        arr2[i] = valueOf4;
        arr2[i4] = valueOf9;
        HashSet hashSet4 = new HashSet(Arrays.asList(arr2));
        hashMap2.put(valueOf7, hashSet4);
        Integer[] arr = new Integer[i2];
        arr[i7] = valueOf6;
        arr[i] = valueOf4;
        arr[i4] = valueOf9;
        HashSet hashSet5 = new HashSet(Arrays.asList(arr));
        hashMap2.put(valueOf8, hashSet5);
    }

    protected StorageTask() {
        super();
        Object object = new Object();
        this.syncObject = object;
        l lVar = new l(this);
        TaskListenerImpl taskListenerImpl = new TaskListenerImpl(this, 128, lVar);
        this.successManager = taskListenerImpl;
        h hVar = new h(this);
        TaskListenerImpl taskListenerImpl2 = new TaskListenerImpl(this, 64, hVar);
        this.failureManager = taskListenerImpl2;
        f fVar = new f(this);
        TaskListenerImpl taskListenerImpl3 = new TaskListenerImpl(this, 448, fVar);
        this.completeListener = taskListenerImpl3;
        g gVar = new g(this);
        TaskListenerImpl taskListenerImpl4 = new TaskListenerImpl(this, 256, gVar);
        this.cancelManager = taskListenerImpl4;
        TaskListenerImpl taskListenerImpl5 = new TaskListenerImpl(this, -465, p.a);
        this.progressManager = taskListenerImpl5;
        TaskListenerImpl taskListenerImpl6 = new TaskListenerImpl(this, 16, b.a);
        this.pausedManager = taskListenerImpl6;
        int i = 1;
    }

    private void a(c c, k k2, j j3) {
        try {
            if (!k2.a().isComplete()) {
            }
            k2.c(c.then(this));
            k2.b(c);
        }
    }

    private void c(c c, k k2, b b3, j j4) {
        Object obj2;
        boolean obj4;
        try {
            Object obj1 = c.then(this);
            if (!k2.a().isComplete() && (j)obj1 == null) {
            }
            if ((j)obj1 == null) {
            }
            obj1 = new NullPointerException("Continuation returned null");
            k2.b(obj1);
            Objects.requireNonNull(k2);
            obj4 = new c(k2);
            (j)obj1.addOnSuccessListener(obj4);
            Objects.requireNonNull(k2);
            obj4 = new q(k2);
            obj1.addOnFailureListener(obj4);
            Objects.requireNonNull(b3);
            obj2 = new a(b3);
            obj1.addOnCanceledListener(obj2);
            k2.b(c);
        }
    }

    private <ContinuationResultT> j<ContinuationResultT> continueWithImpl(Executor executor, c<ResultT, ContinuationResultT> c2) {
        k kVar = new k();
        i iVar = new i(this, c2, kVar);
        this.completeListener.addListener(0, executor, iVar);
        return kVar.a();
    }

    private <ContinuationResultT> j<ContinuationResultT> continueWithTaskImpl(Executor executor, c<ResultT, j<ContinuationResultT>> c2) {
        b bVar = new b();
        k kVar = new k(bVar.b());
        k kVar2 = new k(this, c2, kVar, bVar);
        this.completeListener.addListener(0, executor, kVar2);
        return kVar.a();
    }

    private void e() {
        try {
            run();
            ensureFinalState();
            ensureFinalState();
            throw th;
        }
    }

    private void ensureFinalState() {
        boolean tryChangeState;
        int i;
        i = 0;
        if (!isComplete() && !isPaused() && getInternalState() != 2 && !tryChangeState(256, i)) {
            if (!isPaused()) {
                if (getInternalState() != 2) {
                    i = 0;
                    if (!tryChangeState(256, i)) {
                        tryChangeState(64, i);
                    }
                }
            }
        }
    }

    private void g(g g, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        StorageTaskManager.getInstance().unRegister(this);
        g.onSuccess(provideError2);
    }

    private ResultT getFinalResult() {
        com.google.firebase.storage.StorageTask.ProvideError finalResult;
        com.google.firebase.storage.StorageTask.ProvideError finalResult2 = this.finalResult;
        if (finalResult2 != null) {
            return finalResult2;
        }
        if (!isComplete()) {
            return 0;
        }
        if (this.finalResult == null) {
            this.finalResult = snapState();
        }
        return this.finalResult;
    }

    private String getStateString(int i) {
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16 && i != 32 && i != 64 && i != 128 && i != 256) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 64) {
                                    if (i != 128) {
                                        if (i != 256) {
                                            return "Unknown Internal State!";
                                        }
                                        return "INTERNAL_STATE_CANCELED";
                                    }
                                    return "INTERNAL_STATE_SUCCESS";
                                }
                                return "INTERNAL_STATE_FAILURE";
                            }
                            return "INTERNAL_STATE_CANCELING";
                        }
                        return "INTERNAL_STATE_PAUSED";
                    }
                    return "INTERNAL_STATE_PAUSING";
                }
                return "INTERNAL_STATE_IN_PROGRESS";
            }
            return "INTERNAL_STATE_QUEUED";
        }
        return "INTERNAL_STATE_NOT_STARTED";
    }

    private String getStateString(int[] iArr) {
        int i;
        String str;
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 0;
        i = i2;
        while (i < iArr.length) {
            stringBuilder.append(getStateString(iArr[i]));
            stringBuilder.append(", ");
            i++;
        }
        return stringBuilder.substring(i2, obj6 += -2);
    }

    private void i(f f, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        StorageTaskManager.getInstance().unRegister(this);
        f.onFailure(provideError2.getError());
    }

    private void k(e e, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        StorageTaskManager.getInstance().unRegister(this);
        e.onComplete(this);
    }

    private void m(d d, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        StorageTaskManager.getInstance().unRegister(this);
        d.onCanceled();
    }

    static void o(i i, k k2, b b3, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError4) {
        try {
            final j obj0 = i.then(provideError4);
            Objects.requireNonNull(k2);
            c obj3 = new c(k2);
            obj0.addOnSuccessListener(obj3);
            Objects.requireNonNull(k2);
            obj3 = new q(k2);
            obj0.addOnFailureListener(obj3);
            Objects.requireNonNull(b3);
            a obj1 = new a(b3);
            obj0.addOnCanceledListener(obj1);
            k2.b(i);
            b3 = i.getCause();
            b3 = b3 instanceof Exception;
            i = i.getCause();
            k2.b((Exception)i);
        }
        k2.b(i);
    }

    private <ContinuationResultT> j<ContinuationResultT> successTaskImpl(Executor executor, i<ResultT, ContinuationResultT> i2) {
        b bVar = new b();
        k kVar = new k(bVar.b());
        e eVar = new e(i2, kVar, bVar);
        this.successManager.addListener(0, executor, eVar);
        return kVar.a();
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnCanceledListener(Activity activity, d d2) {
        return addOnCanceledListener(activity, d2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnCanceledListener(d d) {
        return addOnCanceledListener(d);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnCanceledListener(Executor executor, d d2) {
        return addOnCanceledListener(executor, d2);
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnCanceledListener(Activity activity, d d2) {
        r.j(d2);
        r.j(activity);
        this.cancelManager.addListener(activity, 0, d2);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnCanceledListener(d d) {
        r.j(d);
        final int i = 0;
        this.cancelManager.addListener(i, i, d);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnCanceledListener(Executor executor, d d2) {
        r.j(d2);
        r.j(executor);
        this.cancelManager.addListener(0, executor, d2);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnCompleteListener(Activity activity, e e2) {
        return addOnCompleteListener(activity, e2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnCompleteListener(e e) {
        return addOnCompleteListener(e);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnCompleteListener(Executor executor, e e2) {
        return addOnCompleteListener(executor, e2);
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnCompleteListener(Activity activity, e<ResultT> e2) {
        r.j(e2);
        r.j(activity);
        this.completeListener.addListener(activity, 0, e2);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnCompleteListener(e<ResultT> e) {
        r.j(e);
        final int i = 0;
        this.completeListener.addListener(i, i, e);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnCompleteListener(Executor executor, e<ResultT> e2) {
        r.j(e2);
        r.j(executor);
        this.completeListener.addListener(0, executor, e2);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnFailureListener(Activity activity, f f2) {
        return addOnFailureListener(activity, f2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnFailureListener(f f) {
        return addOnFailureListener(f);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnFailureListener(Executor executor, f f2) {
        return addOnFailureListener(executor, f2);
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnFailureListener(Activity activity, f f2) {
        r.j(f2);
        r.j(activity);
        this.failureManager.addListener(activity, 0, f2);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnFailureListener(f f) {
        r.j(f);
        final int i = 0;
        this.failureManager.addListener(i, i, f);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnFailureListener(Executor executor, f f2) {
        r.j(f2);
        r.j(executor);
        this.failureManager.addListener(0, executor, f2);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public com.google.firebase.storage.ControllableTask addOnPausedListener(Activity activity, com.google.firebase.storage.OnPausedListener onPausedListener2) {
        return addOnPausedListener(activity, onPausedListener2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public com.google.firebase.storage.ControllableTask addOnPausedListener(com.google.firebase.storage.OnPausedListener onPausedListener) {
        return addOnPausedListener(onPausedListener);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public com.google.firebase.storage.ControllableTask addOnPausedListener(Executor executor, com.google.firebase.storage.OnPausedListener onPausedListener2) {
        return addOnPausedListener(executor, onPausedListener2);
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnPausedListener(Activity activity, com.google.firebase.storage.OnPausedListener<? super ResultT> onPausedListener2) {
        r.j(onPausedListener2);
        r.j(activity);
        this.pausedManager.addListener(activity, 0, onPausedListener2);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnPausedListener(com.google.firebase.storage.OnPausedListener<? super ResultT> onPausedListener) {
        r.j(onPausedListener);
        final int i = 0;
        this.pausedManager.addListener(i, i, onPausedListener);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnPausedListener(Executor executor, com.google.firebase.storage.OnPausedListener<? super ResultT> onPausedListener2) {
        r.j(onPausedListener2);
        r.j(executor);
        this.pausedManager.addListener(0, executor, onPausedListener2);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public com.google.firebase.storage.CancellableTask addOnProgressListener(Activity activity, com.google.firebase.storage.OnProgressListener onProgressListener2) {
        return addOnProgressListener(activity, onProgressListener2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public com.google.firebase.storage.CancellableTask addOnProgressListener(com.google.firebase.storage.OnProgressListener onProgressListener) {
        return addOnProgressListener(onProgressListener);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public com.google.firebase.storage.CancellableTask addOnProgressListener(Executor executor, com.google.firebase.storage.OnProgressListener onProgressListener2) {
        return addOnProgressListener(executor, onProgressListener2);
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnProgressListener(Activity activity, com.google.firebase.storage.OnProgressListener<? super ResultT> onProgressListener2) {
        r.j(onProgressListener2);
        r.j(activity);
        this.progressManager.addListener(activity, 0, onProgressListener2);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnProgressListener(com.google.firebase.storage.OnProgressListener<? super ResultT> onProgressListener) {
        r.j(onProgressListener);
        final int i = 0;
        this.progressManager.addListener(i, i, onProgressListener);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnProgressListener(Executor executor, com.google.firebase.storage.OnProgressListener<? super ResultT> onProgressListener2) {
        r.j(onProgressListener2);
        r.j(executor);
        this.progressManager.addListener(0, executor, onProgressListener2);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnSuccessListener(Activity activity, g g2) {
        return addOnSuccessListener(activity, g2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnSuccessListener(g g) {
        return addOnSuccessListener(g);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public j addOnSuccessListener(Executor executor, g g2) {
        return addOnSuccessListener(executor, g2);
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnSuccessListener(Activity activity, g<? super ResultT> g2) {
        r.j(activity);
        r.j(g2);
        this.successManager.addListener(activity, 0, g2);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnSuccessListener(g<? super ResultT> g) {
        r.j(g);
        final int i = 0;
        this.successManager.addListener(i, i, g);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> addOnSuccessListener(Executor executor, g<? super ResultT> g2) {
        r.j(executor);
        r.j(g2);
        this.successManager.addListener(0, executor, g2);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public void b(c c, k k2, j j3) {
        a(c, k2, j3);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean cancel() {
        int[] iArr = new int[2];
        iArr = new int[]{256, 32};
        return tryChangeState(iArr, true);
    }

    public <ContinuationResultT> j<ContinuationResultT> continueWith(c<ResultT, ContinuationResultT> c) {
        return continueWithImpl(0, c);
    }

    public <ContinuationResultT> j<ContinuationResultT> continueWith(Executor executor, c<ResultT, ContinuationResultT> c2) {
        return continueWithImpl(executor, c2);
    }

    public <ContinuationResultT> j<ContinuationResultT> continueWithTask(c<ResultT, j<ContinuationResultT>> c) {
        return continueWithTaskImpl(0, c);
    }

    public <ContinuationResultT> j<ContinuationResultT> continueWithTask(Executor executor, c<ResultT, j<ContinuationResultT>> c2) {
        return continueWithTaskImpl(executor, c2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public void d(c c, k k2, b b3, j j4) {
        c(c, k2, b3, j4);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public void f() {
        e();
    }

    @Override // com.google.firebase.storage.ControllableTask
    public Exception getException() {
        if (getFinalResult() == null) {
            return null;
        }
        return getFinalResult().getError();
    }

    @Override // com.google.firebase.storage.ControllableTask
    int getInternalState() {
        return this.currentState;
    }

    public ResultT getResult() {
        if (getFinalResult() == null) {
        } else {
            Exception error = getFinalResult().getError();
            if (error != null) {
            } else {
                return getFinalResult();
            }
            RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException(error);
            throw runtimeExecutionException;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public <X extends Throwable> ResultT getResult(Class<X> class) {
        if (getFinalResult() == null) {
        } else {
            if (class.isInstance(getFinalResult().getError())) {
            } else {
                Exception obj2 = getFinalResult().getError();
                if (obj2 != null) {
                } else {
                    return getFinalResult();
                }
                RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException(obj2);
                throw runtimeExecutionException;
            }
            throw (Throwable)class.cast(getFinalResult().getError());
        }
        obj2 = new IllegalStateException();
        throw obj2;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public Object getResult() {
        return getResult();
    }

    @Override // com.google.firebase.storage.ControllableTask
    public Object getResult(Class class) {
        return getResult(class);
    }

    @Override // com.google.firebase.storage.ControllableTask
    Runnable getRunnable() {
        j jVar = new j(this);
        return jVar;
    }

    public ResultT getSnapshot() {
        return snapState();
    }

    @Override // com.google.firebase.storage.ControllableTask
    abstract com.google.firebase.storage.StorageReference getStorage();

    @Override // com.google.firebase.storage.ControllableTask
    Object getSyncObject() {
        return this.syncObject;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public void h(g g, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        g(g, provideError2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isCanceled() {
        int i;
        i = getInternalState() == 256 ? 1 : 0;
        return i;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isComplete() {
        int i;
        i = internalState &= 448 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isInProgress() {
        int i;
        i = internalState &= -465 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isPaused() {
        int i;
        i = internalState &= 16 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isSuccessful() {
        int i;
        i = internalState &= 128 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public void j(f f, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        i(f, provideError2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public void l(e e, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        k(e, provideError2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public void n(d d, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        m(d, provideError2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    protected void onCanceled() {
    }

    @Override // com.google.firebase.storage.ControllableTask
    protected void onFailure() {
    }

    @Override // com.google.firebase.storage.ControllableTask
    protected void onPaused() {
    }

    @Override // com.google.firebase.storage.ControllableTask
    protected void onProgress() {
    }

    @Override // com.google.firebase.storage.ControllableTask
    protected void onQueued() {
    }

    @Override // com.google.firebase.storage.ControllableTask
    protected void onSuccess() {
    }

    public <ContinuationResultT> j<ContinuationResultT> onSuccessTask(i<ResultT, ContinuationResultT> i) {
        return successTaskImpl(0, i);
    }

    public <ContinuationResultT> j<ContinuationResultT> onSuccessTask(Executor executor, i<ResultT, ContinuationResultT> i2) {
        return successTaskImpl(executor, i2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean pause() {
        int[] iArr = new int[2];
        iArr = new int[]{16, 8};
        return tryChangeState(iArr, true);
    }

    @Override // com.google.firebase.storage.ControllableTask
    boolean queue() {
        final int i3 = 0;
        if (tryChangeState(2, i3)) {
            schedule();
            return 1;
        }
        return i3;
    }

    public com.google.firebase.storage.StorageTask<ResultT> removeOnCanceledListener(d d) {
        r.j(d);
        this.cancelManager.removeListener(d);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> removeOnCompleteListener(e<ResultT> e) {
        r.j(e);
        this.completeListener.removeListener(e);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> removeOnFailureListener(f f) {
        r.j(f);
        this.failureManager.removeListener(f);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> removeOnPausedListener(com.google.firebase.storage.OnPausedListener<? super ResultT> onPausedListener) {
        r.j(onPausedListener);
        this.pausedManager.removeListener(onPausedListener);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> removeOnProgressListener(com.google.firebase.storage.OnProgressListener<? super ResultT> onProgressListener) {
        r.j(onProgressListener);
        this.progressManager.removeListener(onProgressListener);
        return this;
    }

    public com.google.firebase.storage.StorageTask<ResultT> removeOnSuccessListener(g<? super ResultT> g) {
        r.j(g);
        this.successManager.removeListener(g);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    void resetState() {
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean resume() {
        final int i3 = 1;
        if (tryChangeState(2, i3)) {
            resetState();
            schedule();
            return i3;
        }
        return 0;
    }

    @Override // com.google.firebase.storage.ControllableTask
    abstract void run();

    @Override // com.google.firebase.storage.ControllableTask
    abstract void schedule();

    ResultT snapState() {
        final Object syncObject = this.syncObject;
        return snapStateImpl();
        synchronized (syncObject) {
            syncObject = this.syncObject;
            return snapStateImpl();
        }
    }

    abstract ResultT snapStateImpl();

    @Override // com.google.firebase.storage.ControllableTask
    boolean tryChangeState(int i, boolean z2) {
        int[] iArr = new int[1];
        return tryChangeState(iArr, z2);
    }

    @Override // com.google.firebase.storage.ControllableTask
    boolean tryChangeState(int[] iArr, boolean z2) {
        HashMap validUserInitiatedStateChanges;
        int i2;
        int stringBuilder;
        int length;
        int i3;
        int i;
        Object contains;
        Integer valueOf;
        com.google.firebase.storage.StorageTaskManager obj9;
        boolean obj10;
        validUserInitiatedStateChanges = z2 ? StorageTask.ValidUserInitiatedStateChanges : StorageTask.ValidTaskInitiatedStateChanges;
        final Object syncObject = this.syncObject;
        final int i4 = 0;
        i3 = i4;
        synchronized (syncObject) {
            while (i3 < iArr.length) {
                i = iArr[i3];
                contains = validUserInitiatedStateChanges.get(Integer.valueOf(getInternalState()));
                i3++;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("unable to change internal state to: ");
            stringBuilder2.append(getStateString(iArr));
            stringBuilder2.append(" isUser: ");
            stringBuilder2.append(z2);
            stringBuilder2.append(" from state:");
            stringBuilder2.append(getStateString(this.currentState));
            Log.w("StorageTask", stringBuilder2.toString());
            return i4;
        }
    }
}
