package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.d;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.l;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class LoadBundleTask extends j<com.google.firebase.firestore.LoadBundleTaskProgress> {

    private final k<com.google.firebase.firestore.LoadBundleTaskProgress> completionSource;
    private final j<com.google.firebase.firestore.LoadBundleTaskProgress> delegate;
    private final Object lock;
    private final Queue<com.google.firebase.firestore.LoadBundleTask.ManagedListener> progressListeners;
    private com.google.firebase.firestore.LoadBundleTaskProgress snapshot;

    private static class ManagedListener {

        Executor executor;
        com.google.firebase.firestore.OnProgressListener<com.google.firebase.firestore.LoadBundleTaskProgress> listener;
        ManagedListener(Executor executor, com.google.firebase.firestore.OnProgressListener<com.google.firebase.firestore.LoadBundleTaskProgress> onProgressListener2) {
            Executor obj1;
            super();
            if (executor != null) {
            } else {
                obj1 = l.a;
            }
            this.executor = obj1;
            this.listener = onProgressListener2;
        }

        private void a(com.google.firebase.firestore.LoadBundleTaskProgress loadBundleTaskProgress) {
            this.listener.onProgress(loadBundleTaskProgress);
        }

        public void b(com.google.firebase.firestore.LoadBundleTaskProgress loadBundleTaskProgress) {
            a(loadBundleTaskProgress);
        }

        public boolean equals(Object object) {
            Class class;
            Class class2;
            if (this == object) {
                return 1;
            }
            if (object != null && getClass() != object.getClass()) {
                if (getClass() != object.getClass()) {
                }
                return this.listener.equals(object.listener);
            }
            return 0;
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void invokeAsync(com.google.firebase.firestore.LoadBundleTaskProgress loadBundleTaskProgress) {
            m mVar = new m(this, loadBundleTaskProgress);
            this.executor.execute(mVar);
        }
    }
    public LoadBundleTask() {
        super();
        Object object = new Object();
        this.lock = object;
        this.snapshot = LoadBundleTaskProgress.INITIAL;
        k kVar = new k();
        this.completionSource = kVar;
        this.delegate = kVar.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.progressListeners = arrayDeque;
    }

    private void a(com.google.firebase.firestore.OnProgressListener onProgressListener) {
        removeOnProgressListener(onProgressListener);
    }

    private void removeOnProgressListener(com.google.firebase.firestore.OnProgressListener<com.google.firebase.firestore.LoadBundleTaskProgress> onProgressListener) {
        final Object lock = this.lock;
        LoadBundleTask.ManagedListener managedListener = new LoadBundleTask.ManagedListener(0, onProgressListener);
        this.progressListeners.remove(managedListener);
        return;
        synchronized (lock) {
            lock = this.lock;
            managedListener = new LoadBundleTask.ManagedListener(0, onProgressListener);
            this.progressListeners.remove(managedListener);
        }
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnCanceledListener(Activity activity, d d2) {
        return this.delegate.addOnCanceledListener(activity, d2);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnCanceledListener(d d) {
        return this.delegate.addOnCanceledListener(d);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnCanceledListener(Executor executor, d d2) {
        return this.delegate.addOnCanceledListener(executor, d2);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnCompleteListener(Activity activity, e<com.google.firebase.firestore.LoadBundleTaskProgress> e2) {
        return this.delegate.addOnCompleteListener(activity, e2);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnCompleteListener(e<com.google.firebase.firestore.LoadBundleTaskProgress> e) {
        return this.delegate.addOnCompleteListener(e);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnCompleteListener(Executor executor, e<com.google.firebase.firestore.LoadBundleTaskProgress> e2) {
        return this.delegate.addOnCompleteListener(executor, e2);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnFailureListener(Activity activity, f f2) {
        return this.delegate.addOnFailureListener(activity, f2);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnFailureListener(f f) {
        return this.delegate.addOnFailureListener(f);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnFailureListener(Executor executor, f f2) {
        return this.delegate.addOnFailureListener(executor, f2);
    }

    public com.google.firebase.firestore.LoadBundleTask addOnProgressListener(Activity activity, com.google.firebase.firestore.OnProgressListener<com.google.firebase.firestore.LoadBundleTaskProgress> onProgressListener2) {
        LoadBundleTask.ManagedListener managedListener = new LoadBundleTask.ManagedListener(0, onProgressListener2);
        Object lock = this.lock;
        this.progressListeners.add(managedListener);
        l lVar = new l(this, onProgressListener2);
        a.a(activity).b(lVar);
        return this;
        synchronized (lock) {
            managedListener = new LoadBundleTask.ManagedListener(0, onProgressListener2);
            lock = this.lock;
            this.progressListeners.add(managedListener);
            lVar = new l(this, onProgressListener2);
            a.a(activity).b(lVar);
            return this;
        }
    }

    public com.google.firebase.firestore.LoadBundleTask addOnProgressListener(com.google.firebase.firestore.OnProgressListener<com.google.firebase.firestore.LoadBundleTaskProgress> onProgressListener) {
        LoadBundleTask.ManagedListener managedListener = new LoadBundleTask.ManagedListener(0, onProgressListener);
        final Object obj3 = this.lock;
        this.progressListeners.add(managedListener);
        return this;
        synchronized (obj3) {
            managedListener = new LoadBundleTask.ManagedListener(0, onProgressListener);
            obj3 = this.lock;
            this.progressListeners.add(managedListener);
            return this;
        }
    }

    public com.google.firebase.firestore.LoadBundleTask addOnProgressListener(Executor executor, com.google.firebase.firestore.OnProgressListener<com.google.firebase.firestore.LoadBundleTaskProgress> onProgressListener2) {
        LoadBundleTask.ManagedListener managedListener = new LoadBundleTask.ManagedListener(executor, onProgressListener2);
        final Object obj2 = this.lock;
        this.progressListeners.add(managedListener);
        return this;
        synchronized (obj2) {
            managedListener = new LoadBundleTask.ManagedListener(executor, onProgressListener2);
            obj2 = this.lock;
            this.progressListeners.add(managedListener);
            return this;
        }
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnSuccessListener(Activity activity, g<? super com.google.firebase.firestore.LoadBundleTaskProgress> g2) {
        return this.delegate.addOnSuccessListener(activity, g2);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnSuccessListener(g<? super com.google.firebase.firestore.LoadBundleTaskProgress> g) {
        return this.delegate.addOnSuccessListener(g);
    }

    public j<com.google.firebase.firestore.LoadBundleTaskProgress> addOnSuccessListener(Executor executor, g<? super com.google.firebase.firestore.LoadBundleTaskProgress> g2) {
        return this.delegate.addOnSuccessListener(executor, g2);
    }

    @Override // com.google.android.gms.tasks.j
    public void b(com.google.firebase.firestore.OnProgressListener onProgressListener) {
        a(onProgressListener);
    }

    public <TContinuationResult> j<TContinuationResult> continueWith(c<com.google.firebase.firestore.LoadBundleTaskProgress, TContinuationResult> c) {
        return this.delegate.continueWith(c);
    }

    public <TContinuationResult> j<TContinuationResult> continueWith(Executor executor, c<com.google.firebase.firestore.LoadBundleTaskProgress, TContinuationResult> c2) {
        return this.delegate.continueWith(executor, c2);
    }

    public <TContinuationResult> j<TContinuationResult> continueWithTask(c<com.google.firebase.firestore.LoadBundleTaskProgress, j<TContinuationResult>> c) {
        return this.delegate.continueWithTask(c);
    }

    public <TContinuationResult> j<TContinuationResult> continueWithTask(Executor executor, c<com.google.firebase.firestore.LoadBundleTaskProgress, j<TContinuationResult>> c2) {
        return this.delegate.continueWithTask(executor, c2);
    }

    @Override // com.google.android.gms.tasks.j
    public Exception getException() {
        return this.delegate.getException();
    }

    @Override // com.google.android.gms.tasks.j
    public com.google.firebase.firestore.LoadBundleTaskProgress getResult() {
        return (LoadBundleTaskProgress)this.delegate.getResult();
    }

    public <X extends Throwable> com.google.firebase.firestore.LoadBundleTaskProgress getResult(Class<X> class) {
        return (LoadBundleTaskProgress)this.delegate.getResult(class);
    }

    @Override // com.google.android.gms.tasks.j
    public Object getResult() {
        return getResult();
    }

    @Override // com.google.android.gms.tasks.j
    public Object getResult(Class class) {
        return getResult(class);
    }

    @Override // com.google.android.gms.tasks.j
    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    @Override // com.google.android.gms.tasks.j
    public boolean isComplete() {
        return this.delegate.isComplete();
    }

    @Override // com.google.android.gms.tasks.j
    public boolean isSuccessful() {
        return this.delegate.isSuccessful();
    }

    public <TContinuationResult> j<TContinuationResult> onSuccessTask(i<com.google.firebase.firestore.LoadBundleTaskProgress, TContinuationResult> i) {
        return this.delegate.onSuccessTask(i);
    }

    public <TContinuationResult> j<TContinuationResult> onSuccessTask(Executor executor, i<com.google.firebase.firestore.LoadBundleTaskProgress, TContinuationResult> i2) {
        return this.delegate.onSuccessTask(executor, i2);
    }

    @Override // com.google.android.gms.tasks.j
    public void setException(Exception exception) {
        int documentsLoaded;
        Object lock = this.lock;
        super(this.snapshot.getDocumentsLoaded(), this.snapshot.getTotalDocuments(), this.snapshot.getBytesLoaded(), obj5, this.snapshot.getTotalBytes(), obj7, exception, LoadBundleTaskProgress.TaskState.ERROR);
        this.snapshot = loadBundleTaskProgress;
        Iterator iterator = this.progressListeners.iterator();
        synchronized (lock) {
            for (LoadBundleTask.ManagedListener documentsLoaded : iterator) {
                documentsLoaded.invokeAsync(loadBundleTaskProgress);
            }
            try {
                this.progressListeners.clear();
                this.completionSource.b(exception);
                throw exception;
            }
        }
    }

    @Override // com.google.android.gms.tasks.j
    public void setResult(com.google.firebase.firestore.LoadBundleTaskProgress loadBundleTaskProgress) {
        Object[] next;
        com.google.firebase.firestore.LoadBundleTaskProgress snapshot;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected success, but was ");
        stringBuilder.append(loadBundleTaskProgress.getTaskState());
        Assert.hardAssert(loadBundleTaskProgress.getTaskState().equals(LoadBundleTaskProgress.TaskState.SUCCESS), stringBuilder.toString(), new Object[0]);
        Object lock = this.lock;
        this.snapshot = loadBundleTaskProgress;
        Iterator iterator = this.progressListeners.iterator();
        synchronized (lock) {
            for (LoadBundleTask.ManagedListener next : iterator) {
                next.invokeAsync(this.snapshot);
            }
            this.progressListeners.clear();
            this.completionSource.c(loadBundleTaskProgress);
        }
    }

    @Override // com.google.android.gms.tasks.j
    public void updateProgress(com.google.firebase.firestore.LoadBundleTaskProgress loadBundleTaskProgress) {
        Object next;
        final Object lock = this.lock;
        this.snapshot = loadBundleTaskProgress;
        Iterator iterator = this.progressListeners.iterator();
        synchronized (lock) {
            for (LoadBundleTask.ManagedListener next : iterator) {
                next.invokeAsync(loadBundleTaskProgress);
            }
            try {
                throw loadBundleTaskProgress;
            }
        }
    }
}
