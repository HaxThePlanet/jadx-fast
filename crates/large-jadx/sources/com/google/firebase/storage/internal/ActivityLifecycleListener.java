package com.google.firebase.storage.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ActivityLifecycleListener {

    private static final com.google.firebase.storage.internal.ActivityLifecycleListener instance;
    private final Map<Object, com.google.firebase.storage.internal.ActivityLifecycleListener.LifecycleEntry> cookieMap;
    private final Object sync;

    private static class LifecycleEntry {

        private final Activity activity;
        private final Object cookie;
        private final Runnable runnable;
        public LifecycleEntry(Activity activity, Runnable runnable2, Object object3) {
            super();
            this.activity = activity;
            this.runnable = runnable2;
            this.cookie = object3;
        }

        public boolean equals(Object object) {
            boolean runnable2;
            int i;
            Object runnable;
            Object obj4;
            if (!object instanceof ActivityLifecycleListener.LifecycleEntry) {
                return 0;
            }
            if (object.cookie.equals(this.cookie) && object.runnable == this.runnable && object.activity == this.activity) {
                if (object.runnable == this.runnable) {
                    if (object.activity == this.activity) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        public Activity getActivity() {
            return this.activity;
        }

        public Object getCookie() {
            return this.cookie;
        }

        public Runnable getRunnable() {
            return this.runnable;
        }

        public int hashCode() {
            return this.cookie.hashCode();
        }
    }

    private static class OnStopCallback extends LifecycleCallback {

        private static final String TAG = "StorageOnStopCallback";
        private final List<com.google.firebase.storage.internal.ActivityLifecycleListener.LifecycleEntry> listeners;
        private OnStopCallback(i i) {
            super(i);
            ArrayList obj2 = new ArrayList();
            this.listeners = obj2;
            this.mLifecycleFragment.q("StorageOnStopCallback", this);
        }

        public static com.google.firebase.storage.internal.ActivityLifecycleListener.OnStopCallback getInstance(Activity activity) {
            LifecycleCallback onStopCallback;
            h hVar = new h(activity);
            final i obj2 = LifecycleCallback.getFragment(hVar);
            if ((ActivityLifecycleListener.OnStopCallback)obj2.i0("StorageOnStopCallback", ActivityLifecycleListener.OnStopCallback.class) == null) {
                onStopCallback = new ActivityLifecycleListener.OnStopCallback(obj2);
            }
            return onStopCallback;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void addEntry(com.google.firebase.storage.internal.ActivityLifecycleListener.LifecycleEntry activityLifecycleListener$LifecycleEntry) {
            final List listeners = this.listeners;
            this.listeners.add(lifecycleEntry);
            return;
            synchronized (listeners) {
                listeners = this.listeners;
                this.listeners.add(lifecycleEntry);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            ArrayList arrayList;
            List listeners;
            String str;
            List listeners2 = this.listeners;
            arrayList = new ArrayList(this.listeners);
            this.listeners.clear();
            Iterator iterator = arrayList.iterator();
            synchronized (listeners2) {
                listeners2 = this.listeners;
                arrayList = new ArrayList(this.listeners);
                this.listeners.clear();
                iterator = arrayList.iterator();
            }
            while (iterator.hasNext()) {
                arrayList = iterator.next();
                if ((ActivityLifecycleListener.LifecycleEntry)arrayList != null) {
                }
                Log.d("StorageOnStopCallback", "removing subscription from activity.");
                (ActivityLifecycleListener.LifecycleEntry)arrayList.getRunnable().run();
                ActivityLifecycleListener.getInstance().removeCookie(arrayList.getCookie());
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void removeEntry(com.google.firebase.storage.internal.ActivityLifecycleListener.LifecycleEntry activityLifecycleListener$LifecycleEntry) {
            final List listeners = this.listeners;
            this.listeners.remove(lifecycleEntry);
            return;
            synchronized (listeners) {
                listeners = this.listeners;
                this.listeners.remove(lifecycleEntry);
            }
        }
    }
    static {
        ActivityLifecycleListener activityLifecycleListener = new ActivityLifecycleListener();
        ActivityLifecycleListener.instance = activityLifecycleListener;
    }

    private ActivityLifecycleListener() {
        super();
        HashMap hashMap = new HashMap();
        this.cookieMap = hashMap;
        Object object = new Object();
        this.sync = object;
    }

    public static com.google.firebase.storage.internal.ActivityLifecycleListener getInstance() {
        return ActivityLifecycleListener.instance;
    }

    public void removeCookie(Object object) {
        Object cookieMap;
        final Object sync = this.sync;
        final Object obj3 = this.cookieMap.get(object);
        synchronized (sync) {
            ActivityLifecycleListener.OnStopCallback.getInstance((ActivityLifecycleListener.LifecycleEntry)obj3.getActivity()).removeEntry(obj3);
        }
    }

    public void runOnActivityStopped(Activity activity, Object object2, Runnable runnable3) {
        final Object sync = this.sync;
        ActivityLifecycleListener.LifecycleEntry lifecycleEntry = new ActivityLifecycleListener.LifecycleEntry(activity, runnable3, object2);
        ActivityLifecycleListener.OnStopCallback.getInstance(activity).addEntry(lifecycleEntry);
        this.cookieMap.put(object2, lifecycleEntry);
        return;
        synchronized (sync) {
            sync = this.sync;
            lifecycleEntry = new ActivityLifecycleListener.LifecycleEntry(activity, runnable3, object2);
            ActivityLifecycleListener.OnStopCallback.getInstance(activity).addEntry(lifecycleEntry);
            this.cookieMap.put(object2, lifecycleEntry);
        }
    }
}
