package com.google.firebase.storage;

import android.app.Activity;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.r;
import com.google.firebase.storage.internal.ActivityLifecycleListener;
import com.google.firebase.storage.internal.SmartHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class TaskListenerImpl<ListenerTypeT, ResultT extends com.google.firebase.storage.StorageTask.ProvideError>  {

    private final HashMap<ListenerTypeT, SmartHandler> handlerMap;
    private final Queue<ListenerTypeT> listenerQueue;
    private com.google.firebase.storage.TaskListenerImpl.OnRaise<ListenerTypeT, ResultT> onRaise;
    private int targetStates;
    private com.google.firebase.storage.StorageTask<ResultT> task;

    interface OnRaise {
        public abstract void raise(ListenerTypeT listenertypet, ResultT resultt2);
    }
    public TaskListenerImpl(com.google.firebase.storage.StorageTask<ResultT> storageTask, int i2, com.google.firebase.storage.TaskListenerImpl.OnRaise<ListenerTypeT, ResultT> taskListenerImpl$OnRaise3) {
        super();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.listenerQueue = concurrentLinkedQueue;
        HashMap hashMap = new HashMap();
        this.handlerMap = hashMap;
        this.task = storageTask;
        this.targetStates = i2;
        this.onRaise = onRaise3;
    }

    private void a(Object object) {
        removeListener(object);
    }

    private void c(Object object, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        this.onRaise.raise(object, provideError2);
    }

    private void e(Object object, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        this.onRaise.raise(object, provideError2);
    }

    public void addListener(Activity activity, Executor executor2, ListenerTypeT listenertypet3) {
        int i2;
        int mVar;
        int i;
        Object obj7;
        Object obj8;
        r.j(listenertypet3);
        Object syncObject = this.task.getSyncObject();
        final int i4 = 0;
        synchronized (syncObject) {
            i2 = mVar;
            this.listenerQueue.add(listenertypet3);
            SmartHandler smartHandler = new SmartHandler(executor2);
            this.handlerMap.put(listenertypet3, smartHandler);
            if (activity != null && Build.VERSION.SDK_INT >= 17) {
                if (Build.VERSION.SDK_INT >= 17) {
                    if (!activity.isDestroyed()) {
                    } else {
                        mVar = i4;
                    }
                    r.b(mVar, "Activity is already destroyed!");
                }
                mVar = new m(this, listenertypet3);
                ActivityLifecycleListener.getInstance().runOnActivityStopped(activity, listenertypet3, mVar);
            }
            try {
                if (i2 != 0) {
                }
                obj8 = new o(this, listenertypet3, this.task.snapState());
                smartHandler.callBack(obj8);
                throw activity;
            }
        }
    }

    public void b(Object object) {
        a(object);
    }

    public void d(Object object, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        c(object, provideError2);
    }

    public void f(Object object, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError2) {
        e(object, provideError2);
    }

    public int getListenerCount() {
        return Math.max(this.listenerQueue.size(), this.handlerMap.size());
    }

    public void onInternalStateChanged() {
        int snapState;
        int targetStates;
        boolean next;
        Object obj;
        com.google.firebase.storage.n nVar;
        if (internalState &= targetStates != 0) {
            targetStates = this.listenerQueue.iterator();
            while (targetStates.hasNext()) {
                next = targetStates.next();
                obj = this.handlerMap.get(next);
                if ((SmartHandler)obj != null) {
                }
                nVar = new n(this, next, this.task.snapState());
                (SmartHandler)obj.callBack(nVar);
            }
        }
    }

    public void removeListener(ListenerTypeT listenertypet) {
        r.j(listenertypet);
        Object syncObject = this.task.getSyncObject();
        this.handlerMap.remove(listenertypet);
        this.listenerQueue.remove(listenertypet);
        ActivityLifecycleListener.getInstance().removeCookie(listenertypet);
        return;
        synchronized (syncObject) {
            r.j(listenertypet);
            syncObject = this.task.getSyncObject();
            this.handlerMap.remove(listenertypet);
            this.listenerQueue.remove(listenertypet);
            ActivityLifecycleListener.getInstance().removeCookie(listenertypet);
        }
    }
}
