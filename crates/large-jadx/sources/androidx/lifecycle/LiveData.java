package androidx.lifecycle;

import d.b.a.a.a;
import d.b.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes.dex */
public abstract class LiveData<T>  {

    static final Object NOT_SET;
    int mActiveCount = 0;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private b<androidx.lifecycle.y<? super T>, androidx.lifecycle.LiveData.c<T>> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    class a implements Runnable {

        final androidx.lifecycle.LiveData a;
        a(androidx.lifecycle.LiveData liveData) {
            this.a = liveData;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object mDataLock = liveData.mDataLock;
            liveData4.mPendingData = LiveData.NOT_SET;
            this.a.setValue(liveData3.mPendingData);
            return;
            synchronized (mDataLock) {
                mDataLock = liveData.mDataLock;
                liveData4.mPendingData = LiveData.NOT_SET;
                this.a.setValue(liveData3.mPendingData);
            }
        }
    }

    private abstract class c {

        final androidx.lifecycle.y<? super T> a;
        boolean b;
        int c = -1;
        final androidx.lifecycle.LiveData v;
        c(androidx.lifecycle.LiveData liveData, androidx.lifecycle.y y2) {
            this.v = liveData;
            super();
            final int obj1 = -1;
            this.a = y2;
        }

        void e(boolean z) {
            int obj2;
            if (z == this.b) {
            }
            this.b = z;
            obj2 = z ? 1 : -1;
            this.v.changeActiveCounter(obj2);
            if (this.b) {
                this.v.dispatchingValue(this);
            }
        }

        void f() {
        }

        boolean g(androidx.lifecycle.q q) {
            return 0;
        }

        abstract boolean h();
    }

    private class b extends androidx.lifecycle.LiveData.c<T> {
        b(androidx.lifecycle.LiveData liveData, androidx.lifecycle.y y2) {
            super(liveData, y2);
        }

        @Override // androidx.lifecycle.LiveData$c
        boolean h() {
            return 1;
        }
    }

    class LifecycleBoundObserver extends androidx.lifecycle.LiveData.c<T> implements androidx.lifecycle.n {

        final androidx.lifecycle.q w;
        final androidx.lifecycle.LiveData x;
        LifecycleBoundObserver(androidx.lifecycle.LiveData liveData, androidx.lifecycle.q q2, androidx.lifecycle.y y3) {
            this.x = liveData;
            super(liveData, y3);
            this.w = q2;
        }

        @Override // androidx.lifecycle.LiveData$c
        public void c(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2) {
            androidx.lifecycle.j.c cVar;
            androidx.lifecycle.j.c obj2;
            int obj3;
            if (this.w.getLifecycle().b() == j.c.DESTROYED) {
                this.x.removeObserver(this.a);
            }
            obj3 = 0;
            while (obj3 != obj2) {
                e(h());
                obj3 = obj2;
                obj2 = cVar;
            }
        }

        @Override // androidx.lifecycle.LiveData$c
        void f() {
            this.w.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData$c
        boolean g(androidx.lifecycle.q q) {
            int obj2;
            obj2 = this.w == q ? 1 : 0;
            return obj2;
        }

        @Override // androidx.lifecycle.LiveData$c
        boolean h() {
            return this.w.getLifecycle().b().isAtLeast(j.c.STARTED);
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
        b bVar = new b();
        this.mObservers = bVar;
        int i = 0;
        Object nOT_SET = LiveData.NOT_SET;
        this.mPendingData = nOT_SET;
        LiveData.a aVar = new LiveData.a(this);
        this.mPostValueRunnable = aVar;
        this.mData = nOT_SET;
        this.mVersion = -1;
    }

    public LiveData(T t) {
        super();
        Object object = new Object();
        this.mDataLock = object;
        b bVar = new b();
        this.mObservers = bVar;
        this.mPendingData = LiveData.NOT_SET;
        LiveData.a aVar = new LiveData.a(this);
        this.mPostValueRunnable = aVar;
        this.mData = t;
        this.mVersion = 0;
    }

    static void assertMainThread(String string) {
        if (!a.e().b()) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot invoke ");
        stringBuilder.append(string);
        stringBuilder.append(" on a background thread");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    private void considerNotify(androidx.lifecycle.LiveData.c<T> liveData.c) {
        if (!liveData.c.b) {
        }
        if (!liveData.c.h()) {
            liveData.c.e(false);
        }
        final int mVersion = this.mVersion;
        if (liveData.c.c >= mVersion) {
        }
        liveData.c.c = mVersion;
        liveData.c.a.onChanged(this.mData);
    }

    void changeActiveCounter(int i) {
        int mActiveCount;
        int i3;
        boolean z;
        int mActiveCount2;
        int i2;
        this.mActiveCount = i += mActiveCount;
        if (this.mChangingActiveState) {
        }
        int obj5 = 1;
        this.mChangingActiveState = obj5;
        z = 0;
        mActiveCount2 = this.mActiveCount;
        while (mActiveCount != mActiveCount2) {
            if (mActiveCount == 0 && mActiveCount2 > 0) {
            } else {
            }
            i2 = z;
            if (mActiveCount > 0 && mActiveCount2 == 0) {
            } else {
            }
            i3 = z;
            if (i2 != 0) {
            } else {
            }
            if (i3 != 0) {
            }
            mActiveCount = mActiveCount2;
            z = 0;
            mActiveCount2 = this.mActiveCount;
            onInactive();
            onActive();
            if (mActiveCount2 == 0) {
            } else {
            }
            i3 = obj5;
            if (mActiveCount2 > 0) {
            } else {
            }
            i2 = obj5;
        }
        this.mChangingActiveState = z;
    }

    void dispatchingValue(androidx.lifecycle.LiveData.c<T> liveData.c) {
        boolean mDispatchingValue;
        int mDispatchInvalidated;
        boolean mDispatchInvalidated2;
        androidx.lifecycle.LiveData.c obj4;
        mDispatchInvalidated = 1;
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = mDispatchInvalidated;
        }
        this.mDispatchingValue = mDispatchInvalidated;
        mDispatchingValue = false;
        this.mDispatchInvalidated = mDispatchingValue;
        do {
            mDispatchingValue = false;
            this.mDispatchInvalidated = mDispatchingValue;
            mDispatchInvalidated = this.mObservers.g();
            while (mDispatchInvalidated.hasNext()) {
                considerNotify((LiveData.c)(Map.Entry)mDispatchInvalidated.next().getValue());
                if (!this.mDispatchInvalidated) {
                }
            }
            if (this.mDispatchInvalidated != 0) {
            }
            considerNotify((LiveData.c)(Map.Entry)mDispatchInvalidated.next().getValue());
            if (!this.mDispatchInvalidated) {
            }
            considerNotify(obj4);
            obj4 = 0;
        } while (obj4 != null);
        this.mDispatchingValue = mDispatchingValue;
    }

    public T getValue() {
        Object mData = this.mData;
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

    public void observe(androidx.lifecycle.q q, androidx.lifecycle.y<? super T> y2) {
        b mObservers;
        LiveData.assertMainThread("observe");
        if (q.getLifecycle().b() == j.c.DESTROYED) {
        }
        LiveData.LifecycleBoundObserver lifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, q, y2);
        Object obj4 = this.mObservers.l(y2, lifecycleBoundObserver);
        if ((LiveData.c)obj4 != null) {
            if (!(LiveData.c)obj4.g(q)) {
            } else {
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            throw obj3;
        }
        if (obj4 != null) {
        }
        q.getLifecycle().a(lifecycleBoundObserver);
    }

    public void observeForever(androidx.lifecycle.y<? super T> y) {
        LiveData.assertMainThread("observeForever");
        LiveData.b bVar = new LiveData.b(this, y);
        Object obj3 = this.mObservers.l(y, bVar);
        if (obj3 instanceof LiveData.LifecycleBoundObserver) {
        } else {
            if ((LiveData.c)obj3 != null) {
            }
            bVar.e(true);
        }
        obj3 = new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        throw obj3;
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
                a.e().c(this.mPostValueRunnable);
                throw t;
            }
        }
    }

    public void removeObserver(androidx.lifecycle.y<? super T> y) {
        LiveData.assertMainThread("removeObserver");
        final Object obj2 = this.mObservers.m(y);
        if ((LiveData.c)obj2 == null) {
        }
        (LiveData.c)obj2.f();
        obj2.e(false);
    }

    protected void setValue(T t) {
        LiveData.assertMainThread("setValue");
        this.mVersion = mVersion++;
        this.mData = t;
        dispatchingValue(0);
    }
}
