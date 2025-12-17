package com.google.firebase.firestore;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.FirebaseAppCheckTokenProvider;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldIndex.Segment.Kind;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.remote.FirestoreChannel;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ByteBufferInputStream;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Logger.Level;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.inject.Deferred;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseFirestore {

    private static final String TAG = "FirebaseFirestore";
    private final CredentialsProvider<String> appCheckProvider;
    private final AsyncQueue asyncQueue;
    private final CredentialsProvider<User> authProvider;
    private volatile FirestoreClient client;
    private final Context context;
    private final DatabaseId databaseId;
    private EmulatedServiceSettings emulatorSettings;
    private final FirebaseApp firebaseApp;
    private final com.google.firebase.firestore.FirebaseFirestore.InstanceRegistry instanceRegistry;
    private final GrpcMetadataProvider metadataProvider;
    private final String persistenceKey;
    private com.google.firebase.firestore.FirebaseFirestoreSettings settings;
    private final com.google.firebase.firestore.UserDataReader userDataReader;

    public interface InstanceRegistry {
        public abstract void remove(String string);
    }
    FirebaseFirestore(Context context, DatabaseId databaseId2, String string3, CredentialsProvider<User> credentialsProvider4, CredentialsProvider<String> credentialsProvider5, AsyncQueue asyncQueue6, FirebaseApp firebaseApp7, com.google.firebase.firestore.FirebaseFirestore.InstanceRegistry firebaseFirestore$InstanceRegistry8, GrpcMetadataProvider grpcMetadataProvider9) {
        super();
        this.context = (Context)Preconditions.checkNotNull(context);
        this.databaseId = (DatabaseId)Preconditions.checkNotNull((DatabaseId)Preconditions.checkNotNull(databaseId2));
        UserDataReader obj1 = new UserDataReader(databaseId2);
        this.userDataReader = obj1;
        this.persistenceKey = (String)Preconditions.checkNotNull(string3);
        this.authProvider = (CredentialsProvider)Preconditions.checkNotNull(credentialsProvider4);
        this.appCheckProvider = (CredentialsProvider)Preconditions.checkNotNull(credentialsProvider5);
        this.asyncQueue = (AsyncQueue)Preconditions.checkNotNull(asyncQueue6);
        this.firebaseApp = firebaseApp7;
        this.instanceRegistry = instanceRegistry8;
        this.metadataProvider = grpcMetadataProvider9;
        obj1 = new FirebaseFirestoreSettings.Builder();
        this.settings = obj1.build();
    }

    static void a(Runnable runnable, Void void2, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException3) {
        int obj3;
        int obj2 = 0;
        obj3 = firebaseFirestoreException3 == null ? 1 : obj2;
        Assert.hardAssert(obj3, "snapshots-in-sync listeners should never get errors.", new Object[obj2]);
        runnable.run();
    }

    private com.google.firebase.firestore.ListenerRegistration addSnapshotsInSyncListener(Executor executor, Activity activity2, Runnable runnable3) {
        ensureClientConfigured();
        f fVar = new f(runnable3);
        AsyncEventListener obj4 = new AsyncEventListener(executor, fVar);
        this.client.addSnapshotsInSyncListener(obj4);
        i obj2 = new i(this, obj4);
        return ActivityScope.bind(activity2, obj2);
    }

    private void b(AsyncEventListener asyncEventListener) {
        asyncEventListener.mute();
        this.client.removeSnapshotsInSyncListener(asyncEventListener);
    }

    private void d(k k) {
        FirestoreClient terminated;
        int i;
        try {
            if (this.client != null) {
            }
            if (!this.client.isTerminated()) {
            } else {
            }
            FirebaseFirestoreException firebaseFirestoreException = new FirebaseFirestoreException("Persistence cannot be cleared while the firestore instance is running.", FirebaseFirestoreException.Code.FAILED_PRECONDITION);
            throw firebaseFirestoreException;
            SQLitePersistence.clearPersistence(this.context, this.databaseId, this.persistenceKey);
            k.c(0);
            k.b(th);
        }
    }

    private void ensureClientConfigured() {
        if (this.client != null) {
        }
        DatabaseId databaseId = this.databaseId;
        synchronized (databaseId) {
        }
    }

    private com.google.firebase.firestore.Query f(j j) {
        Object obj2 = j.getResult();
        if ((Query)obj2 != null) {
            Query query = new Query((Query)obj2, this);
            return query;
        }
        return null;
    }

    public static com.google.firebase.firestore.FirebaseFirestore getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance == null) {
        } else {
            return FirebaseFirestore.getInstance(instance, "(default)");
        }
        IllegalStateException illegalStateException = new IllegalStateException("You must call FirebaseApp.initializeApp first.");
        throw illegalStateException;
    }

    public static com.google.firebase.firestore.FirebaseFirestore getInstance(FirebaseApp firebaseApp) {
        return FirebaseFirestore.getInstance(firebaseApp, "(default)");
    }

    private static com.google.firebase.firestore.FirebaseFirestore getInstance(FirebaseApp firebaseApp, String string2) {
        Preconditions.checkNotNull(firebaseApp, "Provided FirebaseApp must not be null.");
        Object obj1 = firebaseApp.get(FirestoreMultiDbComponent.class);
        Preconditions.checkNotNull((FirestoreMultiDbComponent)obj1, "Firestore component is not present.");
        return obj1.get(string2);
    }

    private Object h(com.google.firebase.firestore.Transaction.Function transaction$Function, Transaction transaction2) {
        Transaction transaction = new Transaction(transaction2, this);
        return function.apply(transaction);
    }

    private j j(Executor executor, com.google.firebase.firestore.Transaction.Function transaction$Function2, Transaction transaction3) {
        j jVar = new j(this, function2, transaction3);
        return m.c(executor, jVar);
    }

    private com.google.firebase.firestore.FirebaseFirestoreSettings mergeEmulatorSettings(com.google.firebase.firestore.FirebaseFirestoreSettings firebaseFirestoreSettings, EmulatedServiceSettings emulatedServiceSettings2) {
        boolean equals;
        String str;
        String str2;
        if (emulatedServiceSettings2 == null) {
            return firebaseFirestoreSettings;
        }
        int i = 0;
        if (!"firestore.googleapis.com".equals(firebaseFirestoreSettings.getHost())) {
            Logger.warn("FirebaseFirestore", "Host has been set in FirebaseFirestoreSettings and useEmulator, emulator host will be used.", new Object[i]);
        }
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder(firebaseFirestoreSettings);
        StringBuilder obj5 = new StringBuilder();
        obj5.append(emulatedServiceSettings2.getHost());
        obj5.append(":");
        obj5.append(emulatedServiceSettings2.getPort());
        return builder.setHost(obj5.toString()).setSslEnabled(i).build();
    }

    static com.google.firebase.firestore.FirebaseFirestore newInstance(Context context, FirebaseApp firebaseApp2, Deferred<InternalAuthProvider> deferred3, Deferred<InternalAppCheckTokenProvider> deferred4, String string5, com.google.firebase.firestore.FirebaseFirestore.InstanceRegistry firebaseFirestore$InstanceRegistry6, GrpcMetadataProvider grpcMetadataProvider7) {
        String projectId = firebaseApp2.getOptions().getProjectId();
        if (projectId == null) {
        } else {
            String str = string5;
            AsyncQueue asyncQueue = new AsyncQueue();
            Deferred deferred = deferred3;
            FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider = new FirebaseAuthCredentialsProvider(deferred3);
            Deferred deferred2 = deferred4;
            FirebaseAppCheckTokenProvider firebaseAppCheckTokenProvider = new FirebaseAppCheckTokenProvider(deferred4);
            super(context, DatabaseId.forDatabase(projectId, string5), firebaseApp2.getName(), firebaseAuthCredentialsProvider, firebaseAppCheckTokenProvider, asyncQueue, firebaseApp2, instanceRegistry6, grpcMetadataProvider7);
            return firebaseFirestore;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
        throw illegalArgumentException;
    }

    private <ResultT> j<ResultT> runTransaction(com.google.firebase.firestore.Transaction.Function<ResultT> transaction$Function, Executor executor2) {
        ensureClientConfigured();
        g gVar = new g(this, executor2, function);
        return this.client.transaction(gVar);
    }

    static void setClientLanguage(String string) {
        FirestoreChannel.setClientLanguage(string);
    }

    public static void setLoggingEnabled(boolean z) {
        Logger.Level obj0;
        if (z) {
            Logger.setLogLevel(Logger.Level.DEBUG);
        } else {
            Logger.setLogLevel(Logger.Level.WARN);
        }
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotsInSyncListener(Activity activity, Runnable runnable2) {
        return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, activity, runnable2);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotsInSyncListener(Runnable runnable) {
        return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, runnable);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotsInSyncListener(Executor executor, Runnable runnable2) {
        return addSnapshotsInSyncListener(executor, 0, runnable2);
    }

    public com.google.firebase.firestore.WriteBatch batch() {
        ensureClientConfigured();
        WriteBatch writeBatch = new WriteBatch(this);
        return writeBatch;
    }

    public void c(AsyncEventListener asyncEventListener) {
        b(asyncEventListener);
    }

    public j<Void> clearPersistence() {
        k kVar = new k();
        h hVar = new h(this, kVar);
        this.asyncQueue.enqueueAndForgetEvenAfterShutdown(hVar);
        return kVar.a();
    }

    public com.google.firebase.firestore.CollectionReference collection(String string) {
        Preconditions.checkNotNull(string, "Provided collection path must not be null.");
        ensureClientConfigured();
        CollectionReference collectionReference = new CollectionReference(ResourcePath.fromString(string), this);
        return collectionReference;
    }

    public com.google.firebase.firestore.Query collectionGroup(String string) {
        Preconditions.checkNotNull(string, "Provided collection ID must not be null.");
        if (string.contains("/")) {
        } else {
            ensureClientConfigured();
            Query query2 = new Query(ResourcePath.EMPTY, string);
            Query query = new Query(query2, this);
            return query;
        }
        Object[] arr = new Object[1];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Invalid collectionId '%s'. Collection IDs must not contain '/'.", string));
        throw illegalArgumentException;
    }

    j<Void> configureIndices(String string) {
        String str;
        JSONObject jSONObject;
        int optJSONArray;
        FieldIndex fieldIndex;
        int i;
        int cONTAINS;
        FieldPath serverFormat;
        String str2;
        String str3;
        boolean obj11;
        str = "indexes";
        ensureClientConfigured();
        ArrayList arrayList = new ArrayList();
        jSONObject = new JSONObject(string);
        if (jSONObject.has(str)) {
            obj11 = jSONObject.getJSONArray(str);
            str = 0;
            jSONObject = str;
            while (jSONObject < obj11.length()) {
                JSONObject jSONObject2 = obj11.getJSONObject(jSONObject);
                fieldIndex = new FieldIndex(jSONObject2.getString("collectionGroup"));
                optJSONArray = jSONObject2.optJSONArray("fields");
                i = str;
                while (optJSONArray != null) {
                    if (i < optJSONArray.length()) {
                    }
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    serverFormat = FieldPath.fromServerFormat(jSONObject3.getString("fieldPath"));
                    if ("CONTAINS".equals(jSONObject3.optString("arrayConfig"))) {
                    } else {
                    }
                    fieldIndex = fieldIndex.withAddedField(serverFormat, FieldIndex.Segment.Kind.ORDERED);
                    arrayList.add(fieldIndex);
                    i++;
                    fieldIndex = fieldIndex.withAddedField(serverFormat, FieldIndex.Segment.Kind.CONTAINS);
                }
                jSONObject++;
                if (i < optJSONArray.length()) {
                }
                jSONObject3 = optJSONArray.getJSONObject(i);
                serverFormat = FieldPath.fromServerFormat(jSONObject3.getString("fieldPath"));
                if ("CONTAINS".equals(jSONObject3.optString("arrayConfig"))) {
                } else {
                }
                fieldIndex = fieldIndex.withAddedField(serverFormat, FieldIndex.Segment.Kind.ORDERED);
                arrayList.add(fieldIndex);
                i++;
                fieldIndex = fieldIndex.withAddedField(serverFormat, FieldIndex.Segment.Kind.CONTAINS);
            }
        }
        return this.client.configureIndices(arrayList);
    }

    public j<Void> disableNetwork() {
        ensureClientConfigured();
        return this.client.disableNetwork();
    }

    public com.google.firebase.firestore.DocumentReference document(String string) {
        Preconditions.checkNotNull(string, "Provided document path must not be null.");
        ensureClientConfigured();
        return DocumentReference.forPath(ResourcePath.fromString(string), this);
    }

    public void e(k k) {
        d(k);
    }

    public j<Void> enableNetwork() {
        ensureClientConfigured();
        return this.client.enableNetwork();
    }

    public com.google.firebase.firestore.Query g(j j) {
        return f(j);
    }

    public FirebaseApp getApp() {
        return this.firebaseApp;
    }

    AsyncQueue getAsyncQueue() {
        return this.asyncQueue;
    }

    FirestoreClient getClient() {
        return this.client;
    }

    DatabaseId getDatabaseId() {
        return this.databaseId;
    }

    public com.google.firebase.firestore.FirebaseFirestoreSettings getFirestoreSettings() {
        return this.settings;
    }

    public j<com.google.firebase.firestore.Query> getNamedQuery(String string) {
        ensureClientConfigured();
        e eVar = new e(this);
        return this.client.getNamedQuery(string).continueWith(eVar);
    }

    com.google.firebase.firestore.UserDataReader getUserDataReader() {
        return this.userDataReader;
    }

    public Object i(com.google.firebase.firestore.Transaction.Function transaction$Function, Transaction transaction2) {
        return h(function, transaction2);
    }

    public j k(Executor executor, com.google.firebase.firestore.Transaction.Function transaction$Function2, Transaction transaction3) {
        return j(executor, function2, transaction3);
    }

    public com.google.firebase.firestore.LoadBundleTask loadBundle(InputStream inputStream) {
        ensureClientConfigured();
        LoadBundleTask loadBundleTask = new LoadBundleTask();
        this.client.loadBundle(inputStream, loadBundleTask);
        return loadBundleTask;
    }

    public com.google.firebase.firestore.LoadBundleTask loadBundle(ByteBuffer byteBuffer) {
        ByteBufferInputStream byteBufferInputStream = new ByteBufferInputStream(byteBuffer);
        return loadBundle(byteBufferInputStream);
    }

    public com.google.firebase.firestore.LoadBundleTask loadBundle(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return loadBundle(byteArrayInputStream);
    }

    public j<Void> runBatch(com.google.firebase.firestore.WriteBatch.Function writeBatch$Function) {
        final com.google.firebase.firestore.WriteBatch batch = batch();
        function.apply(batch);
        return batch.commit();
    }

    public <TResult> j<TResult> runTransaction(com.google.firebase.firestore.Transaction.Function<TResult> transaction$Function) {
        Preconditions.checkNotNull(function, "Provided transaction update function must not be null.");
        return runTransaction(function, Transaction.getDefaultExecutor());
    }

    public void setFirestoreSettings(com.google.firebase.firestore.FirebaseFirestoreSettings firebaseFirestoreSettings) {
        FirestoreClient client;
        com.google.firebase.firestore.FirebaseFirestoreSettings obj3 = mergeEmulatorSettings(firebaseFirestoreSettings, this.emulatorSettings);
        DatabaseId databaseId = this.databaseId;
        Preconditions.checkNotNull(obj3, "Provided settings must not be null.");
        synchronized (databaseId) {
            if (!this.settings.equals(obj3)) {
            } else {
                this.settings = obj3;
            }
            obj3 = new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
            throw obj3;
        }
    }

    public j<Void> terminate() {
        this.instanceRegistry.remove(getDatabaseId().getDatabaseId());
        ensureClientConfigured();
        return this.client.terminate();
    }

    public void useEmulator(String string, int i2) {
        if (this.client != null) {
        } else {
            EmulatedServiceSettings emulatedServiceSettings = new EmulatedServiceSettings(string, i2);
            this.emulatorSettings = emulatedServiceSettings;
            this.settings = mergeEmulatorSettings(this.settings, emulatedServiceSettings);
        }
        IllegalStateException obj2 = new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
        throw obj2;
    }

    void validateReference(com.google.firebase.firestore.DocumentReference documentReference) {
        Preconditions.checkNotNull(documentReference, "Provided DocumentReference must not be null.");
        if (documentReference.getFirestore() != this) {
        } else {
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Provided document reference is from a different Cloud Firestore instance.");
        throw obj2;
    }

    public j<Void> waitForPendingWrites() {
        return this.client.waitForPendingWrites();
    }
}
