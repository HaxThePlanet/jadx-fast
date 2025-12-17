package com.google.firebase.firestore.core;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class ActivityScope {

    private static final String FRAGMENT_TAG = "FirestoreOnStopObserverFragment";
    private static final String SUPPORT_FRAGMENT_TAG = "FirestoreOnStopObserverSupportFragment";

    private static class CallbackList {

        private final List<Runnable> callbacks;
        private CallbackList() {
            super();
            ArrayList arrayList = new ArrayList();
            this.callbacks = arrayList;
        }

        CallbackList(com.google.firebase.firestore.core.ActivityScope.1 activityScope$1) {
            super();
        }

        void add(Runnable runnable) {
            this.callbacks.add(runnable);
            return;
            synchronized (this) {
                this.callbacks.add(runnable);
            }
        }

        void run() {
            Object next;
            Iterator iterator = this.callbacks.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((Runnable)next != null) {
                }
                (Runnable)next.run();
            }
        }
    }

    public static class StopListenerFragment extends Fragment {

        com.google.firebase.firestore.core.ActivityScope.CallbackList callbacks;
        public StopListenerFragment() {
            super();
            ActivityScope.CallbackList callbackList = new ActivityScope.CallbackList(0);
            this.callbacks = callbackList;
        }

        @Override // android.app.Fragment
        public void onStop() {
            super.onStop();
            final com.google.firebase.firestore.core.ActivityScope.CallbackList callbacks = this.callbacks;
            ActivityScope.CallbackList callbackList = new ActivityScope.CallbackList(0);
            this.callbacks = callbackList;
            this.callbacks.run();
            return;
            synchronized (callbacks) {
                super.onStop();
                callbacks = this.callbacks;
                callbackList = new ActivityScope.CallbackList(0);
                this.callbacks = callbackList;
                this.callbacks.run();
            }
        }
    }

    public static class StopListenerSupportFragment extends Fragment {

        com.google.firebase.firestore.core.ActivityScope.CallbackList callbacks;
        public StopListenerSupportFragment() {
            super();
            ActivityScope.CallbackList callbackList = new ActivityScope.CallbackList(0);
            this.callbacks = callbackList;
        }

        @Override // androidx.fragment.app.Fragment
        public void onStop() {
            super.onStop();
            final com.google.firebase.firestore.core.ActivityScope.CallbackList callbacks = this.callbacks;
            ActivityScope.CallbackList callbackList = new ActivityScope.CallbackList(0);
            this.callbacks = callbackList;
            this.callbacks.run();
            return;
            synchronized (callbacks) {
                super.onStop();
                callbacks = this.callbacks;
                callbackList = new ActivityScope.CallbackList(0);
                this.callbacks = callbackList;
                this.callbacks.run();
            }
        }
    }
    static void a(Activity activity, Runnable runnable2) {
        Object stopListenerFragment;
        boolean fragmentByTag;
        FragmentManager obj3;
        final String str = "FirestoreOnStopObserverFragment";
        stopListenerFragment = ActivityScope.castFragment(ActivityScope.StopListenerFragment.class, activity.getFragmentManager().findFragmentByTag(str), str);
        if ((ActivityScope.StopListenerFragment)stopListenerFragment != null) {
            if ((ActivityScope.StopListenerFragment)stopListenerFragment.isRemoving()) {
                stopListenerFragment = new ActivityScope.StopListenerFragment();
                activity.getFragmentManager().beginTransaction().add(stopListenerFragment, str).commitAllowingStateLoss();
                activity.getFragmentManager().executePendingTransactions();
            }
        } else {
        }
        stopListenerFragment.callbacks.add(runnable2);
    }

    static void b(e e, Runnable runnable2) {
        Object stopListenerSupportFragment;
        boolean removing;
        n obj3;
        final String str = "FirestoreOnStopObserverSupportFragment";
        stopListenerSupportFragment = ActivityScope.castFragment(ActivityScope.StopListenerSupportFragment.class, e.getSupportFragmentManager().k0(str), str);
        if ((ActivityScope.StopListenerSupportFragment)stopListenerSupportFragment != null) {
            if ((ActivityScope.StopListenerSupportFragment)stopListenerSupportFragment.isRemoving()) {
                stopListenerSupportFragment = new ActivityScope.StopListenerSupportFragment();
                removing = e.getSupportFragmentManager().n();
                removing.d(stopListenerSupportFragment, str);
                removing.h();
                e.getSupportFragmentManager().g0();
            }
        } else {
        }
        stopListenerSupportFragment.callbacks.add(runnable2);
    }

    public static ListenerRegistration bind(Activity activity, ListenerRegistration listenerRegistration2) {
        com.google.firebase.firestore.core.d0 d0Var;
        if (activity != null) {
            if (activity instanceof e) {
                Objects.requireNonNull(listenerRegistration2);
                d0Var = new d0(listenerRegistration2);
                ActivityScope.onFragmentActivityStopCallOnce((e)activity, d0Var);
            } else {
                Objects.requireNonNull(listenerRegistration2);
                d0Var = new d0(listenerRegistration2);
                ActivityScope.onActivityStopCallOnce(activity, d0Var);
            }
        }
        return listenerRegistration2;
    }

    private static <T> T castFragment(Class<T> class, Object object2, String string3) {
        if (object2 == null) {
            return 0;
        }
        return class.cast(object2);
    }

    private static void onActivityStopCallOnce(Activity activity, Runnable runnable2) {
        Assert.hardAssert(z ^= 1, "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        a aVar = new a(activity, runnable2);
        activity.runOnUiThread(aVar);
    }

    private static void onFragmentActivityStopCallOnce(e e, Runnable runnable2) {
        b bVar = new b(e, runnable2);
        e.runOnUiThread(bVar);
    }
}
