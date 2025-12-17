package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.g.a;
import androidx.activity.g.b;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.b;
import androidx.activity.result.c;
import androidx.activity.result.d;
import androidx.activity.result.e;
import androidx.activity.result.f.a;
import androidx.core.app.a;
import androidx.core.app.b;
import androidx.core.app.f;
import androidx.core.content.a;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0.b;
import androidx.lifecycle.i;
import androidx.lifecycle.i0;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.j.c;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import androidx.savedstate.c;
import androidx.savedstate.d;
import d.t.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends f implements q, j0, i, c, androidx.activity.f, d {

    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final a mContextAwareHelper;
    private g0.b mDefaultFactory;
    private final s mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final androidx.activity.OnBackPressedDispatcher mOnBackPressedDispatcher;
    final b mSavedStateRegistryController;
    private i0 mViewModelStore;

    class a implements Runnable {

        final androidx.activity.ComponentActivity a;
        a(androidx.activity.ComponentActivity componentActivity) {
            this.a = componentActivity;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.activity.ComponentActivity activity;
            String equals;
            String str;
            try {
                ComponentActivity.access$001(this.a);
                equals = th.getMessage();
                equals = TextUtils.equals(equals, "Can not perform this action after onSaveInstanceState");
                if (equals == null) {
                } else {
                }
                throw th;
            }
        }
    }

    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static final class d {

        Object a;
        i0 b;
    }

    class b extends ActivityResultRegistry {

        final androidx.activity.ComponentActivity i;
        b(androidx.activity.ComponentActivity componentActivity) {
            this.i = componentActivity;
            super();
        }

        public <I, O> void f(int i, a<I, O> a2, I i3, b b4) {
            boolean extra;
            int i5;
            Intent intent;
            int i6;
            int i2;
            int i4;
            Bundle bundle;
            Object obj10;
            Object obj11;
            Bundle obj12;
            final androidx.activity.ComponentActivity activity = this.i;
            androidx.activity.result.f.a.a aVar = a2.b(activity, i3);
            if (aVar != null) {
                obj10 = new Handler(Looper.getMainLooper());
                obj11 = new ComponentActivity.b.a(this, i, aVar);
                obj10.post(obj11);
            }
            obj10 = a2.a(activity, i3);
            if (obj10.getExtras() != null && obj10.getExtras().getClassLoader() == null) {
                if (obj10.getExtras().getClassLoader() == null) {
                    obj10.setExtrasClassLoader(activity.getClassLoader());
                }
            }
            obj11 = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
            i5 = 0;
            if (obj10.hasExtra(obj11)) {
                obj10.removeExtra(obj11);
                bundle = obj12;
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(obj10.getAction())) {
                    if (obj10.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS") == null) {
                        obj10 = new String[0];
                    }
                    a.s(activity, obj10, i);
                } else {
                    if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(obj10.getAction())) {
                        obj10 = obj10.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                        a.x(activity, (e)obj10.d(), i, obj10.a(), obj10.b(), obj10.c(), 0, bundle);
                    } else {
                        a.w(activity, obj10, i, bundle);
                    }
                }
            } else {
                if (b4 != null) {
                } else {
                    bundle = i5;
                }
            }
            b4.a();
            throw i5;
        }
    }
    public ComponentActivity() {
        int sDK_INT;
        int immLeaksCleaner;
        j lifecycle;
        androidx.activity.ComponentActivity.3 anon;
        super();
        a aVar = new a();
        this.mContextAwareHelper = aVar;
        s sVar = new s(this);
        this.mLifecycleRegistry = sVar;
        this.mSavedStateRegistryController = b.a(this);
        ComponentActivity.a aVar3 = new ComponentActivity.a(this);
        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(aVar3);
        this.mOnBackPressedDispatcher = onBackPressedDispatcher;
        AtomicInteger atomicInteger = new AtomicInteger();
        this.mNextLocalRequestCode = atomicInteger;
        ComponentActivity.b bVar2 = new ComponentActivity.b(this);
        this.mActivityResultRegistry = bVar2;
        if (getLifecycle() == null) {
        } else {
            sDK_INT = Build.VERSION.SDK_INT;
            immLeaksCleaner = 19;
            if (sDK_INT >= immLeaksCleaner) {
                anon = new ComponentActivity.3(this);
                getLifecycle().a(anon);
            }
            ComponentActivity.4 anon2 = new ComponentActivity.4(this);
            getLifecycle().a(anon2);
            ComponentActivity.5 anon3 = new ComponentActivity.5(this);
            getLifecycle().a(anon3);
            if (immLeaksCleaner <= sDK_INT && sDK_INT <= 23) {
                if (sDK_INT <= 23) {
                    immLeaksCleaner = new ImmLeaksCleaner(this);
                    getLifecycle().a(immLeaksCleaner);
                }
            }
            b bVar3 = new b(this);
            getSavedStateRegistry().d("android:support:activity-result", bVar3);
            a aVar2 = new a(this);
            addOnContextAvailableListener(aVar2);
        }
        IllegalStateException illegalStateException = new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        throw illegalStateException;
    }

    public ComponentActivity(int i) {
        super();
        this.mContentLayoutId = i;
    }

    static void access$001(androidx.activity.ComponentActivity componentActivity) {
        super.onBackPressed();
    }

    private Bundle e() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    private void g(Context context) {
        Object mActivityResultRegistry;
        Bundle obj2 = getSavedStateRegistry().a("android:support:activity-result");
        if (obj2 != null) {
            this.mActivityResultRegistry.g(obj2);
        }
    }

    private void initViewTreeOwners() {
        k0.a(getWindow().getDecorView(), this);
        l0.a(getWindow().getDecorView(), this);
        d.a(getWindow().getDecorView(), this);
    }

    @Override // androidx.core.app.f
    public void addContentView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams2);
    }

    @Override // androidx.core.app.f
    public final void addOnContextAvailableListener(b b) {
        this.mContextAwareHelper.a(b);
    }

    @Override // androidx.core.app.f
    void ensureViewModelStore() {
        Object lastNonConfigurationInstance;
        i0 mViewModelStore;
        lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (this.mViewModelStore == null && (ComponentActivity.d)lastNonConfigurationInstance != null) {
            lastNonConfigurationInstance = getLastNonConfigurationInstance();
            if ((ComponentActivity.d)(ComponentActivity.d)lastNonConfigurationInstance != null) {
                this.mViewModelStore = lastNonConfigurationInstance.b;
            }
            if (this.mViewModelStore == null) {
                mViewModelStore = new i0();
                this.mViewModelStore = mViewModelStore;
            }
        }
    }

    @Override // androidx.core.app.f
    public Bundle f() {
        return e();
    }

    @Override // androidx.core.app.f
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.core.app.f
    public g0.b getDefaultViewModelProviderFactory() {
        g0.b mDefaultFactory;
        android.app.Application application;
        Bundle extras;
        if (getApplication() == null) {
        } else {
            if (this.mDefaultFactory == null) {
                if (getIntent() != null) {
                    extras = getIntent().getExtras();
                } else {
                    extras = 0;
                }
                mDefaultFactory = new d0(getApplication(), this, extras);
                this.mDefaultFactory = mDefaultFactory;
            }
            return this.mDefaultFactory;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        throw illegalStateException;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        Object obj;
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        obj = (ComponentActivity.d)lastNonConfigurationInstance != null ? lastNonConfigurationInstance.a : 0;
        return obj;
    }

    @Override // androidx.core.app.f
    public j getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.core.app.f
    public final androidx.activity.OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.core.app.f
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.core.app.f
    public i0 getViewModelStore() {
        if (getApplication() == null) {
        } else {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        throw illegalStateException;
    }

    @Override // androidx.core.app.f
    public void h(Context context) {
        g(context);
    }

    @Deprecated
    protected void onActivityResult(int i, int i2, Intent intent3) {
        if (!this.mActivityResultRegistry.b(i, i2, intent3)) {
            super.onActivityResult(i, i2, intent3);
        }
    }

    @Override // androidx.core.app.f
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.d();
    }

    @Override // androidx.core.app.f
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.c(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        b0.g(this);
        final int obj2 = this.mContentLayoutId;
        if (obj2 != null) {
            setContentView(obj2);
        }
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
        boolean sDK_INT;
        Intent extra;
        Intent intent = new Intent();
        if (!this.mActivityResultRegistry.b(i, -1, intent.putExtra("androidx.activity.result.contract.extra.PERMISSIONS", string2Arr2).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", i3Arr3)) && Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 23) {
                super.onRequestPermissionsResult(i, string2Arr2, i3Arr3);
            }
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // androidx.core.app.f
    public final Object onRetainNonConfigurationInstance() {
        i0 mViewModelStore;
        Object lastNonConfigurationInstance;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (this.mViewModelStore == null && (ComponentActivity.d)lastNonConfigurationInstance != null) {
            lastNonConfigurationInstance = getLastNonConfigurationInstance();
            if ((ComponentActivity.d)(ComponentActivity.d)lastNonConfigurationInstance != null) {
                mViewModelStore = lastNonConfigurationInstance.b;
            }
        }
        if (mViewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            if (onRetainCustomNonConfigurationInstance == null) {
                return null;
            }
        }
        ComponentActivity.d dVar = new ComponentActivity.d();
        dVar.a = onRetainCustomNonConfigurationInstance;
        dVar.b = mViewModelStore;
        return dVar;
    }

    @Override // androidx.core.app.f
    protected void onSaveInstanceState(Bundle bundle) {
        boolean cREATED;
        j lifecycle = getLifecycle();
        if (lifecycle instanceof s) {
            (s)lifecycle.o(j.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
    }

    @Override // androidx.core.app.f
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> c<I> registerForActivityResult(a<I, O> a, ActivityResultRegistry activityResultRegistry2, b<O> b3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("activity_rq#");
        stringBuilder.append(this.mNextLocalRequestCode.getAndIncrement());
        return activityResultRegistry2.j(stringBuilder.toString(), this, a, b3);
    }

    public final <I, O> c<I> registerForActivityResult(a<I, O> a, b<O> b2) {
        return registerForActivityResult(a, this.mActivityResultRegistry, b2);
    }

    @Override // androidx.core.app.f
    public final void removeOnContextAvailableListener(b b) {
        this.mContextAwareHelper.e(b);
    }

    @Override // androidx.core.app.f
    public void reportFullyDrawn() {
        boolean str;
        int sDK_INT;
        try {
            if (a.d()) {
            }
            a.a("reportFullyDrawn() for ComponentActivity");
            sDK_INT = Build.VERSION.SDK_INT;
            final int i = 19;
            if (sDK_INT > i) {
            } else {
            }
            super.reportFullyDrawn();
            if (sDK_INT == i && a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
            }
            if (a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
            }
            super.reportFullyDrawn();
            a.b();
            a.b();
            throw th;
        }
    }

    @Override // androidx.core.app.f
    public void setContentView(int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    @Override // androidx.core.app.f
    public void setContentView(View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    @Override // androidx.core.app.f
    public void setContentView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams2);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle3) {
        super.startActivityForResult(intent, i2, bundle3);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent3, int i4, int i5, int i6) {
        super.startIntentSenderForResult(intentSender, i2, intent3, i4, i5, i6);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent3, int i4, int i5, int i6, Bundle bundle7) {
        super.startIntentSenderForResult(intentSender, i2, intent3, i4, i5, i6, bundle7);
    }
}
