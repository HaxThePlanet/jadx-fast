package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.InstallationResponse.ResponseCode;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.TokenResult.ResponseCode;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class FirebaseInstallations implements com.google.firebase.installations.FirebaseInstallationsApi {

    private static final String API_KEY_VALIDATION_MSG = "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String APP_ID_VALIDATION_MSG = "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String AUTH_ERROR_MSG = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.";
    private static final String CHIME_FIREBASE_APP_NAME = "CHIME_ANDROID_SDK";
    private static final int CORE_POOL_SIZE = 0;
    private static final long KEEP_ALIVE_TIME_IN_SECONDS = 30L;
    private static final String LOCKFILE_NAME_GENERATE_FID = "generatefid.lock";
    private static final int MAXIMUM_POOL_SIZE = 1;
    private static final String PROJECT_ID_VALIDATION_MSG = "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final ThreadFactory THREAD_FACTORY;
    private static final Object lockGenerateFid;
    private final ExecutorService backgroundExecutor;
    private String cachedFid;
    private final com.google.firebase.installations.RandomFidGenerator fidGenerator;
    private Set<FidListener> fidListeners;
    private final FirebaseApp firebaseApp;
    private final IidStore iidStore;
    private final List<com.google.firebase.installations.StateListener> listeners;
    private final Object lock;
    private final ExecutorService networkExecutor;
    private final PersistedInstallation persistedInstallation;
    private final FirebaseInstallationServiceClient serviceClient;
    private final com.google.firebase.installations.Utils utils;
    static {
        Object object = new Object();
        FirebaseInstallations.lockGenerateFid = object;
        FirebaseInstallations.1 anon = new FirebaseInstallations.1();
        FirebaseInstallations.THREAD_FACTORY = anon;
    }

    FirebaseInstallations(FirebaseApp firebaseApp, Provider<UserAgentPublisher> provider2, Provider<HeartBeatInfo> provider3) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(0, 1, 30, obj4, TimeUnit.SECONDS, linkedBlockingQueue, FirebaseInstallations.THREAD_FACTORY);
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp.getApplicationContext(), provider2, provider3);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp);
        IidStore iidStore = new IidStore(firebaseApp);
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        super(threadPoolExecutor3, firebaseApp, firebaseInstallationServiceClient, persistedInstallation, Utils.getInstance(), iidStore, randomFidGenerator);
    }

    FirebaseInstallations(ExecutorService executorService, FirebaseApp firebaseApp2, FirebaseInstallationServiceClient firebaseInstallationServiceClient3, PersistedInstallation persistedInstallation4, com.google.firebase.installations.Utils utils5, IidStore iidStore6, com.google.firebase.installations.RandomFidGenerator randomFidGenerator7) {
        final Object obj = this;
        super();
        Object object = new Object();
        obj.lock = object;
        HashSet hashSet = new HashSet();
        obj.fidListeners = hashSet;
        ArrayList arrayList = new ArrayList();
        obj.listeners = arrayList;
        obj.firebaseApp = firebaseApp2;
        obj.serviceClient = firebaseInstallationServiceClient3;
        obj.persistedInstallation = persistedInstallation4;
        obj.utils = utils5;
        obj.iidStore = iidStore6;
        obj.fidGenerator = randomFidGenerator7;
        obj.backgroundExecutor = executorService;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(0, 1, 30, obj5, TimeUnit.SECONDS, linkedBlockingQueue, FirebaseInstallations.THREAD_FACTORY);
        obj.networkExecutor = threadPoolExecutor2;
    }

    private void a(boolean z) {
        doNetworkCallIfNecessary(z);
    }

    static Set access$000(com.google.firebase.installations.FirebaseInstallations firebaseInstallations) {
        return firebaseInstallations.fidListeners;
    }

    private j<com.google.firebase.installations.InstallationTokenResult> addGetAuthTokenListener() {
        k kVar = new k();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.utils, kVar);
        addStateListeners(getAuthTokenListener);
        return kVar.a();
    }

    private j<String> addGetIdListener() {
        k kVar = new k();
        GetIdListener getIdListener = new GetIdListener(kVar);
        addStateListeners(getIdListener);
        return kVar.a();
    }

    private void addStateListeners(com.google.firebase.installations.StateListener stateListener) {
        final Object lock = this.lock;
        this.listeners.add(stateListener);
        return;
        synchronized (lock) {
            lock = this.lock;
            this.listeners.add(stateListener);
        }
    }

    private void c() {
        doRegistrationOrRefresh(false);
    }

    private Void deleteFirebaseInstallationId() {
        boolean serviceClient;
        String apiKey;
        String firebaseInstallationId;
        String projectIdentifier;
        String refreshToken;
        final int i = 0;
        updateCacheFid(i);
        PersistedInstallationEntry multiProcessSafePrefs = getMultiProcessSafePrefs();
        if (multiProcessSafePrefs.isRegistered()) {
            this.serviceClient.deleteFirebaseInstallation(getApiKey(), multiProcessSafePrefs.getFirebaseInstallationId(), getProjectIdentifier(), multiProcessSafePrefs.getRefreshToken());
        }
        insertOrUpdatePrefs(multiProcessSafePrefs.withNoGeneratedFid());
        return i;
    }

    private void doNetworkCallIfNecessary(boolean z) {
        boolean firebaseInstallationId;
        com.google.firebase.installations.FirebaseInstallationsException.Status notGenerated;
        boolean unregistered;
        PersistedInstallationEntry obj3;
        PersistedInstallationEntry multiProcessSafePrefs = getMultiProcessSafePrefs();
        if (!multiProcessSafePrefs.isErrored()) {
            if (multiProcessSafePrefs.isUnregistered()) {
                obj3 = registerFidWithServer(multiProcessSafePrefs);
            } else {
                if (z == null && this.utils.isAuthTokenExpired(multiProcessSafePrefs)) {
                    try {
                        if (this.utils.isAuthTokenExpired(multiProcessSafePrefs)) {
                        }
                        obj3 = fetchAuthTokenFromServer(multiProcessSafePrefs);
                        obj3 = registerFidWithServer(multiProcessSafePrefs);
                        insertOrUpdatePrefs(obj3);
                        updateFidListener(multiProcessSafePrefs, obj3);
                        if (obj3.isRegistered()) {
                        }
                        updateCacheFid(obj3.getFirebaseInstallationId());
                        if (obj3.isErrored()) {
                        } else {
                        }
                        obj3 = new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG);
                        triggerOnException(obj3);
                        if (obj3.isNotGenerated()) {
                        } else {
                        }
                        obj3 = new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.");
                        triggerOnException(obj3);
                        triggerOnStateReached(obj3);
                        triggerOnException(z);
                    }
                }
            }
        } else {
        }
    }

    private final void doRegistrationOrRefresh(boolean z) {
        PersistedInstallationEntry prefsWithGeneratedIdMultiProcessSafe;
        if (z) {
            prefsWithGeneratedIdMultiProcessSafe = getPrefsWithGeneratedIdMultiProcessSafe().withClearedAuthToken();
        }
        triggerOnStateReached(prefsWithGeneratedIdMultiProcessSafe);
        a aVar = new a(this, z);
        this.networkExecutor.execute(aVar);
    }

    private void e(boolean z) {
        doRegistrationOrRefresh(z);
    }

    private PersistedInstallationEntry fetchAuthTokenFromServer(PersistedInstallationEntry persistedInstallationEntry) {
        final String projectIdentifier = getProjectIdentifier();
        TokenResult authToken = this.serviceClient.generateAuthToken(getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), projectIdentifier, persistedInstallationEntry.getRefreshToken());
        int i4 = FirebaseInstallations.3.$SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode[authToken.getResponseCode().ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 != 2) {
                if (i4 != 3) {
                } else {
                    updateCacheFid(0);
                    return persistedInstallationEntry.withNoGeneratedFid();
                }
                FirebaseInstallationsException obj7 = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
                throw obj7;
            }
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        }
        return persistedInstallationEntry.withAuthToken(authToken.getToken(), authToken.getTokenExpirationTimestamp(), projectIdentifier);
    }

    public static Void g(com.google.firebase.installations.FirebaseInstallations firebaseInstallations) {
        return firebaseInstallations.deleteFirebaseInstallationId();
    }

    private String getCacheFid() {
        return this.cachedFid;
        synchronized (this) {
            return this.cachedFid;
        }
    }

    public static com.google.firebase.installations.FirebaseInstallations getInstance() {
        return FirebaseInstallations.getInstance(FirebaseApp.getInstance());
    }

    public static com.google.firebase.installations.FirebaseInstallations getInstance(FirebaseApp firebaseApp) {
        int i;
        i = firebaseApp != null ? 1 : 0;
        r.b(i, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations)firebaseApp.get(FirebaseInstallationsApi.class);
    }

    private PersistedInstallationEntry getMultiProcessSafePrefs() {
        Throwable th;
        final Object lockGenerateFid = FirebaseInstallations.lockGenerateFid;
        com.google.firebase.installations.CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), "generatefid.lock");
        synchronized (lockGenerateFid) {
            acquire.releaseAndClose();
            return this.persistedInstallation.readPersistedInstallationEntryValue();
        }
    }

    private PersistedInstallationEntry getPrefsWithGeneratedIdMultiProcessSafe() {
        Throwable th;
        PersistedInstallationEntry persistedInstallationEntryValue;
        boolean existingIidOrCreateFid;
        PersistedInstallation persistedInstallation;
        final Object lockGenerateFid = FirebaseInstallations.lockGenerateFid;
        com.google.firebase.installations.CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), "generatefid.lock");
        persistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
        synchronized (lockGenerateFid) {
            persistedInstallationEntryValue = this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntryValue.withUnregisteredFid(readExistingIidOrCreateFid(persistedInstallationEntryValue)));
            if (acquire != null) {
                try {
                    acquire.releaseAndClose();
                    return persistedInstallationEntryValue;
                    if (th2 == null) {
                    } else {
                    }
                    th2.releaseAndClose();
                    throw th;
                    throw th2;
                } catch (Throwable th) {
                }
            }
        }
    }

    private void insertOrUpdatePrefs(PersistedInstallationEntry persistedInstallationEntry) {
        final Object lockGenerateFid = FirebaseInstallations.lockGenerateFid;
        com.google.firebase.installations.CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), "generatefid.lock");
        this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
        synchronized (lockGenerateFid) {
            acquire.releaseAndClose();
        }
    }

    private void preConditionChecks() {
        final String str = "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
        r.g(getApplicationId(), str);
        r.g(getProjectIdentifier(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String str3 = "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.";
        r.g(getApiKey(), str3);
        r.b(Utils.isValidAppIdFormat(getApplicationId()), str);
        r.b(Utils.isValidApiKeyFormat(getApiKey()), str3);
    }

    private String readExistingIidOrCreateFid(PersistedInstallationEntry persistedInstallationEntry) {
        boolean defaultApp;
        boolean obj3;
        if (!this.firebaseApp.getName().equals("CHIME_ANDROID_SDK")) {
            if (this.firebaseApp.isDefaultApp() && !persistedInstallationEntry.shouldAttemptMigration()) {
                if (!persistedInstallationEntry.shouldAttemptMigration()) {
                }
            }
            return this.fidGenerator.createRandomFid();
        } else {
        }
        if (TextUtils.isEmpty(this.iidStore.readIid())) {
            obj3 = this.fidGenerator.createRandomFid();
        }
        return obj3;
    }

    private PersistedInstallationEntry registerFidWithServer(PersistedInstallationEntry persistedInstallationEntry) {
        String firebaseInstallationId;
        int token;
        int i;
        if (persistedInstallationEntry.getFirebaseInstallationId() != null && persistedInstallationEntry.getFirebaseInstallationId().length() == 11) {
            if (persistedInstallationEntry.getFirebaseInstallationId().length() == 11) {
                token = this.iidStore.readToken();
            } else {
                token = 0;
            }
        } else {
        }
        final int i5 = token;
        InstallationResponse firebaseInstallation = this.serviceClient.createFirebaseInstallation(getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), getApplicationId(), i5);
        int i3 = FirebaseInstallations.3.$SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode[firebaseInstallation.getResponseCode().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
            } else {
                return persistedInstallationEntry.withFisError("BAD CONFIG");
            }
            FirebaseInstallationsException obj11 = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
            throw obj11;
        }
        return persistedInstallationEntry.withRegisteredFid(firebaseInstallation.getFid(), firebaseInstallation.getRefreshToken(), this.utils.currentTimeInSecs(), i5, firebaseInstallation.getAuthToken().getToken());
    }

    private void triggerOnException(Exception exception) {
        boolean onException;
        final Object lock = this.lock;
        Iterator iterator = this.listeners.iterator();
        synchronized (lock) {
            while (iterator.hasNext()) {
                if ((StateListener)iterator.next().onException(exception)) {
                }
                iterator.remove();
            }
        }
    }

    private void triggerOnStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        boolean onStateReached;
        final Object lock = this.lock;
        Iterator iterator = this.listeners.iterator();
        synchronized (lock) {
            while (iterator.hasNext()) {
                if ((StateListener)iterator.next().onStateReached(persistedInstallationEntry)) {
                }
                iterator.remove();
            }
        }
    }

    private void updateCacheFid(String string) {
        this.cachedFid = string;
        return;
        synchronized (this) {
            this.cachedFid = string;
        }
    }

    private void updateFidListener(PersistedInstallationEntry persistedInstallationEntry, PersistedInstallationEntry persistedInstallationEntry2) {
        String firebaseInstallationId2;
        String firebaseInstallationId;
        boolean obj3;
        synchronized (this) {
            try {
                if (!persistedInstallationEntry.getFirebaseInstallationId().equals(persistedInstallationEntry2.getFirebaseInstallationId())) {
                }
                obj3 = this.fidListeners.iterator();
                for (FidListener firebaseInstallationId2 : obj3) {
                    firebaseInstallationId2.onFidChanged(persistedInstallationEntry2.getFirebaseInstallationId());
                }
                (FidListener)obj3.next().onFidChanged(persistedInstallationEntry2.getFirebaseInstallationId());
                throw persistedInstallationEntry;
            }
        }
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public void b(boolean z) {
        a(z);
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public void d() {
        c();
    }

    public j<Void> delete() {
        d dVar = new d(this);
        return m.c(this.backgroundExecutor, dVar);
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public void f(boolean z) {
        e(z);
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    String getApiKey() {
        return this.firebaseApp.getOptions().getApiKey();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    String getApplicationId() {
        return this.firebaseApp.getOptions().getApplicationId();
    }

    public j<String> getId() {
        preConditionChecks();
        String cacheFid = getCacheFid();
        if (cacheFid != null) {
            return m.e(cacheFid);
        }
        b bVar = new b(this);
        this.backgroundExecutor.execute(bVar);
        return addGetIdListener();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    String getName() {
        return this.firebaseApp.getName();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    String getProjectIdentifier() {
        return this.firebaseApp.getOptions().getProjectId();
    }

    public j<com.google.firebase.installations.InstallationTokenResult> getToken(boolean z) {
        preConditionChecks();
        c cVar = new c(this, z);
        this.backgroundExecutor.execute(cVar);
        return addGetAuthTokenListener();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public FidListenerHandle registerFidListener(FidListener fidListener) {
        this.fidListeners.add(fidListener);
        FirebaseInstallations.2 anon = new FirebaseInstallations.2(this, fidListener);
        return anon;
        synchronized (this) {
            this.fidListeners.add(fidListener);
            anon = new FirebaseInstallations.2(this, fidListener);
            return anon;
        }
    }
}
