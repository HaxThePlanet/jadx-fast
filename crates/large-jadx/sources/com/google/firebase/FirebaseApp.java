package com.google.firebase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.j;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.d.a;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.m;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.ComponentRuntime.Builder;
import com.google.firebase.components.Lazy;
import com.google.firebase.internal.DataCollectionConfigStorage;
import d.e.a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class FirebaseApp {

    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    static final Map<String, com.google.firebase.FirebaseApp> INSTANCES = null;
    private static final String KOTLIN = "kotlin";
    private static final Object LOCK = null;
    private static final String LOG_TAG = "FirebaseApp";
    private static final Executor UI_EXECUTOR;
    private final Context applicationContext;
    private final AtomicBoolean automaticResourceManagementEnabled;
    private final List<com.google.firebase.FirebaseApp.BackgroundStateChangeListener> backgroundStateChangeListeners;
    private final ComponentRuntime componentRuntime;
    private final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
    private final AtomicBoolean deleted;
    private final List<com.google.firebase.FirebaseAppLifecycleListener> lifecycleListeners;
    private final String name;
    private final com.google.firebase.FirebaseOptions options;

    public interface BackgroundStateChangeListener {
        public abstract void onBackgroundStateChanged(boolean z);
    }

    private static class UiExecutor implements Executor {

        private static final Handler HANDLER;
        static {
            Handler handler = new Handler(Looper.getMainLooper());
            FirebaseApp.UiExecutor.HANDLER = handler;
        }

        UiExecutor(com.google.firebase.FirebaseApp.1 firebaseApp$1) {
            super();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            FirebaseApp.UiExecutor.HANDLER.post(runnable);
        }
    }

    private static class UserUnlockReceiver extends BroadcastReceiver {

        private static AtomicReference<com.google.firebase.FirebaseApp.UserUnlockReceiver> INSTANCE;
        private final Context applicationContext;
        static {
            AtomicReference atomicReference = new AtomicReference();
            FirebaseApp.UserUnlockReceiver.INSTANCE = atomicReference;
        }

        public UserUnlockReceiver(Context context) {
            super();
            this.applicationContext = context;
        }

        static void access$200(Context context) {
            FirebaseApp.UserUnlockReceiver.ensureReceiverRegistered(context);
        }

        private static void ensureReceiverRegistered(Context context) {
            Object userUnlockReceiver;
            boolean compareAndSet;
            int str;
            userUnlockReceiver = new FirebaseApp.UserUnlockReceiver(context);
            if (FirebaseApp.UserUnlockReceiver.INSTANCE.get() == null && FirebaseApp.UserUnlockReceiver.INSTANCE.compareAndSet(0, userUnlockReceiver)) {
                userUnlockReceiver = new FirebaseApp.UserUnlockReceiver(context);
                if (FirebaseApp.UserUnlockReceiver.INSTANCE.compareAndSet(0, userUnlockReceiver)) {
                    compareAndSet = new IntentFilter("android.intent.action.USER_UNLOCKED");
                    context.registerReceiver(userUnlockReceiver, compareAndSet);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            Object next;
            final Object obj2 = FirebaseApp.access$300();
            Iterator obj3 = FirebaseApp.INSTANCES.values().iterator();
            synchronized (obj2) {
                for (FirebaseApp next : obj3) {
                    FirebaseApp.access$400(next);
                }
                unregister();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void unregister() {
            this.applicationContext.unregisterReceiver(this);
        }
    }

    private static class GlobalBackgroundStateListener implements d.a {

        private static AtomicReference<com.google.firebase.FirebaseApp.GlobalBackgroundStateListener> INSTANCE;
        static {
            AtomicReference atomicReference = new AtomicReference();
            FirebaseApp.GlobalBackgroundStateListener.INSTANCE = atomicReference;
        }

        static void access$100(Context context) {
            FirebaseApp.GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(context);
        }

        private static void ensureBackgroundStateListenerRegistered(Context context) {
            boolean globalBackgroundStateListener;
            boolean compareAndSet;
            int i;
            Object obj3;
            if (l.a()) {
                if (!applicationContext instanceof Application) {
                } else {
                    globalBackgroundStateListener = new FirebaseApp.GlobalBackgroundStateListener();
                    if (FirebaseApp.GlobalBackgroundStateListener.INSTANCE.get() == null && FirebaseApp.GlobalBackgroundStateListener.INSTANCE.compareAndSet(0, globalBackgroundStateListener)) {
                        globalBackgroundStateListener = new FirebaseApp.GlobalBackgroundStateListener();
                        if (FirebaseApp.GlobalBackgroundStateListener.INSTANCE.compareAndSet(0, globalBackgroundStateListener)) {
                            d.c((Application)context.getApplicationContext());
                            d.b().a(globalBackgroundStateListener);
                        }
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.d$a
        public void onBackgroundStateChanged(boolean z) {
            Collection values;
            boolean z2;
            final Object obj = FirebaseApp.access$300();
            ArrayList arrayList = new ArrayList(FirebaseApp.INSTANCES.values());
            Iterator iterator = arrayList.iterator();
            synchronized (obj) {
                while (iterator.hasNext()) {
                    values = iterator.next();
                    if (FirebaseApp.access$500((FirebaseApp)values).get()) {
                    }
                    FirebaseApp.access$600(values, z);
                }
            }
        }
    }
    static {
        Object object = new Object();
        FirebaseApp.LOCK = object;
        FirebaseApp.UiExecutor uiExecutor = new FirebaseApp.UiExecutor(0);
        FirebaseApp.UI_EXECUTOR = uiExecutor;
        a aVar = new a();
        FirebaseApp.INSTANCES = aVar;
    }

    protected FirebaseApp(Context context, String string2, com.google.firebase.FirebaseOptions firebaseOptions3) {
        super();
        int i = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i);
        this.automaticResourceManagementEnabled = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        this.deleted = atomicBoolean2;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.backgroundStateChangeListeners = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.lifecycleListeners = copyOnWriteArrayList2;
        r.j(context);
        this.applicationContext = (Context)context;
        r.f(string2);
        this.name = string2;
        r.j(firebaseOptions3);
        this.options = (FirebaseOptions)firebaseOptions3;
        FirebaseCommonRegistrar firebaseCommonRegistrar = new FirebaseCommonRegistrar();
        this.componentRuntime = ComponentRuntime.builder(FirebaseApp.UI_EXECUTOR).addLazyComponentRegistrars(ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discoverLazy()).addComponentRegistrar(firebaseCommonRegistrar).addComponent(Component.of(context, Context.class, new Class[i])).addComponent(Component.of(this, FirebaseApp.class, new Class[i])).addComponent(Component.of(firebaseOptions3, FirebaseOptions.class, new Class[i])).build();
        a obj6 = new a(this, context);
        Lazy obj5 = new Lazy(obj6);
        this.dataCollectionConfigStorage = obj5;
    }

    private DataCollectionConfigStorage a(Context context) {
        DataCollectionConfigStorage dataCollectionConfigStorage = new DataCollectionConfigStorage(context, getPersistenceKey(), (Publisher)this.componentRuntime.get(Publisher.class));
        return dataCollectionConfigStorage;
    }

    static Object access$300() {
        return FirebaseApp.LOCK;
    }

    static void access$400(com.google.firebase.FirebaseApp firebaseApp) {
        firebaseApp.initializeAllApis();
    }

    static AtomicBoolean access$500(com.google.firebase.FirebaseApp firebaseApp) {
        return firebaseApp.automaticResourceManagementEnabled;
    }

    static void access$600(com.google.firebase.FirebaseApp firebaseApp, boolean z2) {
        firebaseApp.notifyBackgroundStateChangeListeners(z2);
    }

    private void checkNotDeleted() {
        r.n(z ^= 1, "FirebaseApp was deleted");
    }

    public static void clearInstancesForTest() {
        final Object lOCK = FirebaseApp.LOCK;
        FirebaseApp.INSTANCES.clear();
        return;
        synchronized (lOCK) {
            lOCK = FirebaseApp.LOCK;
            FirebaseApp.INSTANCES.clear();
        }
    }

    private static List<String> getAllAppNames() {
        String name;
        ArrayList arrayList = new ArrayList();
        final Object lOCK = FirebaseApp.LOCK;
        Iterator iterator = FirebaseApp.INSTANCES.values().iterator();
        synchronized (lOCK) {
            for (FirebaseApp next2 : iterator) {
                arrayList.add(next2.getName());
            }
            Collections.sort(arrayList);
            return arrayList;
        }
    }

    public static List<com.google.firebase.FirebaseApp> getApps(Context context) {
        final Object obj2 = FirebaseApp.LOCK;
        ArrayList arrayList = new ArrayList(FirebaseApp.INSTANCES.values());
        return arrayList;
        synchronized (obj2) {
            obj2 = FirebaseApp.LOCK;
            arrayList = new ArrayList(FirebaseApp.INSTANCES.values());
            return arrayList;
        }
    }

    public static com.google.firebase.FirebaseApp getInstance() {
        final Object lOCK = FirebaseApp.LOCK;
        Object obj = FirebaseApp.INSTANCES.get("[DEFAULT]");
        synchronized (lOCK) {
            return (FirebaseApp)obj;
        }
    }

    public static com.google.firebase.FirebaseApp getInstance(String string) {
        String string2;
        boolean stringBuilder;
        String str;
        final Object lOCK = FirebaseApp.LOCK;
        Object obj = FirebaseApp.INSTANCES.get(FirebaseApp.normalize(string));
        synchronized (lOCK) {
            return (FirebaseApp)obj;
        }
    }

    public static String getPersistenceKey(String string, com.google.firebase.FirebaseOptions firebaseOptions2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c.e(string.getBytes(Charset.defaultCharset())));
        stringBuilder.append("+");
        stringBuilder.append(c.e(firebaseOptions2.getApplicationId().getBytes(Charset.defaultCharset())));
        return stringBuilder.toString();
    }

    private void initializeAllApis() {
        Object applicationContext;
        String defaultApp;
        String name;
        defaultApp = "FirebaseApp";
        if (z ^= 1 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            stringBuilder.append(getName());
            Log.i(defaultApp, stringBuilder.toString());
            FirebaseApp.UserUnlockReceiver.access$200(this.applicationContext);
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Device unlocked: initializing all Firebase APIs for app ");
            stringBuilder2.append(getName());
            Log.i(defaultApp, stringBuilder2.toString());
            this.componentRuntime.initializeEagerComponents(isDefaultApp());
        }
    }

    public static com.google.firebase.FirebaseApp initializeApp(Context context) {
        final Object lOCK = FirebaseApp.LOCK;
        synchronized (lOCK) {
            return FirebaseApp.getInstance();
        }
    }

    public static com.google.firebase.FirebaseApp initializeApp(Context context, com.google.firebase.FirebaseOptions firebaseOptions2) {
        return FirebaseApp.initializeApp(context, firebaseOptions2, "[DEFAULT]");
    }

    public static com.google.firebase.FirebaseApp initializeApp(Context context, com.google.firebase.FirebaseOptions firebaseOptions2, String string3) {
        int i;
        Context obj5;
        FirebaseApp.GlobalBackgroundStateListener.access$100(context);
        final String obj7 = FirebaseApp.normalize(string3);
        if (context.getApplicationContext() == null) {
        } else {
            obj5 = context.getApplicationContext();
        }
        Object lOCK = FirebaseApp.LOCK;
        final Map iNSTANCES = FirebaseApp.INSTANCES;
        synchronized (lOCK) {
            i = 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FirebaseApp name ");
            stringBuilder.append(obj7);
            stringBuilder.append(" already exists!");
            r.n(i, stringBuilder.toString());
            r.k(obj5, "Application context cannot be null.");
            FirebaseApp firebaseApp = new FirebaseApp(obj5, obj7, firebaseOptions2);
            iNSTANCES.put(obj7, firebaseApp);
            firebaseApp.initializeAllApis();
            return firebaseApp;
        }
    }

    private static String normalize(String string) {
        return string.trim();
    }

    private void notifyBackgroundStateChangeListeners(boolean z) {
        String next;
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator iterator = this.backgroundStateChangeListeners.iterator();
        for (FirebaseApp.BackgroundStateChangeListener next : iterator) {
            next.onBackgroundStateChanged(z);
        }
    }

    private void notifyOnAppDeleted() {
        Object next;
        String name;
        com.google.firebase.FirebaseOptions options;
        Iterator iterator = this.lifecycleListeners.iterator();
        for (FirebaseAppLifecycleListener next : iterator) {
            next.onDeleted(this.name, this.options);
        }
    }

    public void addBackgroundStateChangeListener(com.google.firebase.FirebaseApp.BackgroundStateChangeListener firebaseApp$BackgroundStateChangeListener) {
        boolean z;
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.get() && d.b().d()) {
            if (d.b().d()) {
                backgroundStateChangeListener.onBackgroundStateChanged(true);
            }
        }
        this.backgroundStateChangeListeners.add(backgroundStateChangeListener);
    }

    public void addLifecycleEventListener(com.google.firebase.FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        r.j(firebaseAppLifecycleListener);
        this.lifecycleListeners.add(firebaseAppLifecycleListener);
    }

    public DataCollectionConfigStorage b(Context context) {
        return a(context);
    }

    public void delete() {
        if (!this.deleted.compareAndSet(false, true)) {
        }
        Object lOCK = FirebaseApp.LOCK;
        FirebaseApp.INSTANCES.remove(this.name);
        notifyOnAppDeleted();
        return;
        synchronized (lOCK) {
            lOCK = FirebaseApp.LOCK;
            FirebaseApp.INSTANCES.remove(this.name);
            notifyOnAppDeleted();
        }
    }

    public boolean equals(Object object) {
        if (!object instanceof FirebaseApp) {
            return 0;
        }
        return this.name.equals((FirebaseApp)object.getName());
    }

    public <T> T get(Class<T> class) {
        checkNotDeleted();
        return this.componentRuntime.get(class);
    }

    public Context getApplicationContext() {
        checkNotDeleted();
        return this.applicationContext;
    }

    public String getName() {
        checkNotDeleted();
        return this.name;
    }

    public com.google.firebase.FirebaseOptions getOptions() {
        checkNotDeleted();
        return this.options;
    }

    public String getPersistenceKey() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c.e(getName().getBytes(Charset.defaultCharset())));
        stringBuilder.append("+");
        stringBuilder.append(c.e(getOptions().getApplicationId().getBytes(Charset.defaultCharset())));
        return stringBuilder.toString();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    void initializeAllComponents() {
        this.componentRuntime.initializeAllComponentsForTests();
    }

    public boolean isDataCollectionDefaultEnabled() {
        checkNotDeleted();
        return (DataCollectionConfigStorage)this.dataCollectionConfigStorage.get().isEnabled();
    }

    public boolean isDefaultApp() {
        return "[DEFAULT]".equals(getName());
    }

    public void removeBackgroundStateChangeListener(com.google.firebase.FirebaseApp.BackgroundStateChangeListener firebaseApp$BackgroundStateChangeListener) {
        checkNotDeleted();
        this.backgroundStateChangeListeners.remove(backgroundStateChangeListener);
    }

    public void removeLifecycleEventListener(com.google.firebase.FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        r.j(firebaseAppLifecycleListener);
        this.lifecycleListeners.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        boolean compareAndSet;
        int obj3;
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.compareAndSet(z ^ 1, z)) {
            compareAndSet = d.b().d();
            if (z != 0 && compareAndSet != null) {
                if (compareAndSet != null) {
                    notifyBackgroundStateChangeListeners(true);
                } else {
                    if (z == 0 && compareAndSet != null) {
                        if (compareAndSet != null) {
                            notifyBackgroundStateChangeListeners(false);
                        }
                    }
                }
            } else {
            }
        }
    }

    public void setDataCollectionDefaultEnabled(Boolean boolean) {
        checkNotDeleted();
        (DataCollectionConfigStorage)this.dataCollectionConfigStorage.get().setEnabled(boolean);
    }

    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z));
    }

    public String toString() {
        p.a aVar = p.c(this);
        aVar.a("name", this.name);
        aVar.a("options", this.options);
        return aVar.toString();
    }
}
