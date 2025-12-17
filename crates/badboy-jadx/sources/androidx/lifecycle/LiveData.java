package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes5.dex */
public abstract class LiveData<T>  {

    static final Object NOT_SET = null;
    static final int START_VERSION = -1;
    int mActiveCount = 0;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<androidx.lifecycle.Observer<? super T>, androidx.lifecycle.LiveData.ObserverWrapper<T>> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    private abstract class ObserverWrapper {

        boolean mActive;
        int mLastVersion = -1;
        final androidx.lifecycle.Observer<? super T> mObserver;
        final androidx.lifecycle.LiveData this$0;
        ObserverWrapper(androidx.lifecycle.LiveData liveData, androidx.lifecycle.Observer observer2) {
            this.this$0 = liveData;
            super();
            final int obj1 = -1;
            this.mObserver = observer2;
        }

        void activeStateChanged(boolean newActive) {
            boolean mActive;
            int i;
            if (newActive == this.mActive) {
            }
            this.mActive = newActive;
            i = this.mActive ? 1 : -1;
            this.this$0.changeActiveCounter(i);
            if (this.mActive) {
                this.this$0.dispatchingValue(this);
            }
        }

        void detachObserver() {
        }

        boolean isAttachedTo(androidx.lifecycle.LifecycleOwner owner) {
            return 0;
        }

        abstract boolean shouldBeActive();
    }

    private class AlwaysActiveObserver extends androidx.lifecycle.LiveData.ObserverWrapper<T> {

        final androidx.lifecycle.LiveData this$0;
        AlwaysActiveObserver(androidx.lifecycle.LiveData liveData, androidx.lifecycle.Observer observer2) {
            this.this$0 = liveData;
            super(liveData, observer2);
        }

        @Override // androidx.lifecycle.LiveData$ObserverWrapper
        boolean shouldBeActive() {
            return 1;
        }
    }

    class LifecycleBoundObserver extends androidx.lifecycle.LiveData.ObserverWrapper<T> implements androidx.lifecycle.LifecycleEventObserver {

        final androidx.lifecycle.LifecycleOwner mOwner;
        final androidx.lifecycle.LiveData this$0;
        LifecycleBoundObserver(androidx.lifecycle.LiveData this$0, androidx.lifecycle.LifecycleOwner owner, androidx.lifecycle.Observer observer3) {
            this.this$0 = this$0;
            super(this$0, observer3);
            this.mOwner = owner;
        }

        @Override // androidx.lifecycle.LiveData$ObserverWrapper
        void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData$ObserverWrapper
        boolean isAttachedTo(androidx.lifecycle.LifecycleOwner owner) {
            int i;
            i = this.mOwner == owner ? 1 : 0;
            return i;
        }

        @Override // androidx.lifecycle.LiveData$ObserverWrapper
        public void onStateChanged(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event) {
            androidx.lifecycle.Lifecycle.State currentState;
            int prevState;
            androidx.lifecycle.Lifecycle lifecycle;
            if (this.mOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                this.this$0.removeObserver(this.mObserver);
            }
            prevState = 0;
            while (prevState != currentState) {
                prevState = currentState;
                activeStateChanged(shouldBeActive());
                currentState = this.mOwner.getLifecycle().getCurrentState();
            }
        }

        @Override // androidx.lifecycle.LiveData$ObserverWrapper
        boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }
    }
    static {
        Object object = new Object();
        LiveData.NOT_SET = object;
    }

    public LiveData() {
        super();
        Object object = new Object();
        this.mDataLock = object;
        SafeIterableMap safeIterableMap = new SafeIterableMap();
        this.mObservers = safeIterableMap;
        int i = 0;
        this.mPendingData = LiveData.NOT_SET;
        LiveData.1 anon = new LiveData.1(this);
        this.mPostValueRunnable = anon;
        this.mData = LiveData.NOT_SET;
        this.mVersion = -1;
    }

    public LiveData(T t) {
        super();
        Object object = new Object();
        this.mDataLock = object;
        SafeIterableMap safeIterableMap = new SafeIterableMap();
        this.mObservers = safeIterableMap;
        this.mPendingData = LiveData.NOT_SET;
        LiveData.1 anon = new LiveData.1(this);
        this.mPostValueRunnable = anon;
        this.mData = t;
        this.mVersion = 0;
    }

    static void assertMainThread(String methodName) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Cannot invoke ").append(methodName).append(" on a background thread").toString());
        throw illegalStateException;
    }

    private void considerNotify(androidx.lifecycle.LiveData.ObserverWrapper<T> liveData.ObserverWrapper) {
        if (!liveData.ObserverWrapper.mActive) {
        }
        if (!liveData.ObserverWrapper.shouldBeActive()) {
            liveData.ObserverWrapper.activeStateChanged(false);
        }
        if (liveData.ObserverWrapper.mLastVersion >= this.mVersion) {
        }
        liveData.ObserverWrapper.mLastVersion = this.mVersion;
        liveData.ObserverWrapper.mObserver.onChanged(this.mData);
    }

    void changeActiveCounter(int change) {
        int previousActiveCount;
        boolean z;
        int i;
        int mActiveCount;
        int mActiveCount2;
        int mActiveCount3;
        previousActiveCount = this.mActiveCount;
        this.mActiveCount = mActiveCount4 += change;
        if (this.mChangingActiveState) {
        }
        int i3 = 1;
        this.mChangingActiveState = i3;
        z = 0;
        while (previousActiveCount != this.mActiveCount) {
            if (previousActiveCount == 0 && this.mActiveCount > 0) {
            } else {
            }
            i = z;
            if (previousActiveCount > 0 && this.mActiveCount == 0) {
            } else {
            }
            mActiveCount2 = z;
            previousActiveCount = mActiveCount3;
            if (i != 0) {
            } else {
            }
            if (mActiveCount2 != 0) {
            }
            z = 0;
            onInactive();
            onActive();
            if (this.mActiveCount == 0) {
            } else {
            }
            mActiveCount2 = i3;
            if (this.mActiveCount > 0) {
            } else {
            }
            i = i3;
        }
        this.mChangingActiveState = z;
    }

    void dispatchingValue(androidx.lifecycle.LiveData.ObserverWrapper<T> liveData.ObserverWrapper) {
        boolean mDispatchingValue;
        int iterator;
        boolean mDispatchInvalidated;
        androidx.lifecycle.LiveData.ObserverWrapper obj4;
        iterator = 1;
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = iterator;
        }
        this.mDispatchingValue = iterator;
        mDispatchingValue = false;
        this.mDispatchInvalidated = mDispatchingValue;
        do {
            mDispatchingValue = false;
            this.mDispatchInvalidated = mDispatchingValue;
            iterator = this.mObservers.iteratorWithAdditions();
            while (iterator.hasNext()) {
                considerNotify((LiveData.ObserverWrapper)(Map.Entry)iterator.next().getValue());
                if (this.mDispatchInvalidated) {
                    break loop_6;
                } else {
                }
            }
            if (this.mDispatchInvalidated != 0) {
            }
            considerNotify((LiveData.ObserverWrapper)(Map.Entry)iterator.next().getValue());
            if (this.mDispatchInvalidated) {
            } else {
            }
            considerNotify(obj4);
            obj4 = 0;
        } while (obj4 != null);
        this.mDispatchingValue = mDispatchingValue;
    }

    public T getValue() {
        final Object mData = this.mData;
        if (mData != LiveData.NOT_SET) {
            return mData;
        }
        return 0;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        int i;
        i = this.mActiveCount > 0 ? 1 : 0;
        return i;
    }

    public boolean hasObservers() {
        int i;
        i = this.mObservers.size() > 0 ? 1 : 0;
        return i;
    }

    public boolean isInitialized() {
        int i;
        i = this.mData != LiveData.NOT_SET ? 1 : 0;
        return i;
    }

    public void observe(androidx.lifecycle.LifecycleOwner owner, androidx.lifecycle.Observer<? super T> observer2) {
        boolean attachedTo;
        LiveData.assertMainThread("observe");
        if (owner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
        }
        LiveData.LifecycleBoundObserver lifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, owner, observer2);
        Object ifAbsent = this.mObservers.putIfAbsent(observer2, lifecycleBoundObserver);
        if ((LiveData.ObserverWrapper)ifAbsent != null) {
            if (!(LiveData.ObserverWrapper)ifAbsent.isAttachedTo(owner)) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            throw illegalArgumentException;
        }
        if (ifAbsent != null) {
        }
        owner.getLifecycle().addObserver(lifecycleBoundObserver);
    }

    public void observeForever(androidx.lifecycle.Observer<? super T> observer) {
        LiveData.assertMainThread("observeForever");
        LiveData.AlwaysActiveObserver alwaysActiveObserver = new LiveData.AlwaysActiveObserver(this, observer);
        Object ifAbsent = this.mObservers.putIfAbsent(observer, alwaysActiveObserver);
        if (ifAbsent instanceof LiveData.LifecycleBoundObserver) {
        } else {
            if ((LiveData.ObserverWrapper)ifAbsent != null) {
            }
            alwaysActiveObserver.activeStateChanged(true);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        throw illegalArgumentException;
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    protected void postValue(T t) {
        int i;
        Object mDataLock = this.mDataLock;
        synchronized (mDataLock) {
            i = 1;
            try {
                this.mPendingData = t;
                if (i == 0) {
                }
                ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
                throw postTask;
            }
        }
    }

    public void removeObserver(androidx.lifecycle.Observer<? super T> observer) {
        LiveData.assertMainThread("removeObserver");
        Object remove = this.mObservers.remove(observer);
        if ((LiveData.ObserverWrapper)remove == null) {
        }
        (LiveData.ObserverWrapper)remove.detachObserver();
        remove.activeStateChanged(false);
    }

    public void removeObservers(androidx.lifecycle.LifecycleOwner owner) {
        Object next;
        boolean attachedTo;
        LiveData.assertMainThread("removeObservers");
        Iterator iterator = this.mObservers.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((LiveData.ObserverWrapper)(Map.Entry)next.getValue().isAttachedTo(owner)) {
            }
            removeObserver((Observer)next.getKey());
        }
    }

    protected void setValue(T t) {
        LiveData.assertMainThread("setValue");
        this.mVersion = mVersion++;
        this.mData = t;
        dispatchingValue(0);
    }
}
