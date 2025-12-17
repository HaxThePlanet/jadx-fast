package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.EventManager.ListenOptions;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.UserData.ParsedSetData;
import com.google.firebase.firestore.core.UserData.ParsedUpdateData;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class DocumentReference {

    private final com.google.firebase.firestore.FirebaseFirestore firestore;
    private final DocumentKey key;
    DocumentReference(DocumentKey documentKey, com.google.firebase.firestore.FirebaseFirestore firebaseFirestore2) {
        super();
        this.key = (DocumentKey)Preconditions.checkNotNull(documentKey);
        this.firestore = firebaseFirestore2;
    }

    private void a(com.google.firebase.firestore.EventListener eventListener, ViewSnapshot viewSnapshot2, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException3) {
        DocumentKey contains;
        int i;
        Object firestore;
        com.google.firebase.firestore.DocumentSnapshot obj7;
        int obj8;
        final int i2 = 0;
        if (firebaseFirestoreException3 != null) {
            eventListener.onEvent(i2, firebaseFirestoreException3);
        }
        obj8 = 1;
        int i3 = 0;
        i = viewSnapshot2 != null ? obj8 : i3;
        Assert.hardAssert(i, "Got event without value or error set", new Object[i3]);
        if (viewSnapshot2.getDocuments().size() <= obj8) {
        } else {
            obj8 = i3;
        }
        Assert.hardAssert(obj8, "Too many documents returned on a document query", new Object[i3]);
        obj8 = viewSnapshot2.getDocuments().getDocument(this.key);
        if (obj8 != null) {
            obj7 = DocumentSnapshot.fromDocument(this.firestore, obj8, viewSnapshot2.isFromCache(), viewSnapshot2.getMutatedKeys().contains(obj8.getKey()));
        } else {
            obj7 = DocumentSnapshot.fromNoDocument(this.firestore, this.key, viewSnapshot2.isFromCache());
        }
        eventListener.onEvent(obj7, i2);
    }

    private com.google.firebase.firestore.ListenerRegistration addSnapshotListenerInternal(Executor executor, EventManager.ListenOptions eventManager$ListenOptions2, Activity activity3, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.DocumentSnapshot> eventListener4) {
        b bVar = new b(this, eventListener4);
        AsyncEventListener obj5 = new AsyncEventListener(executor, bVar);
        ListenerRegistrationImpl obj3 = new ListenerRegistrationImpl(this.firestore.getClient(), this.firestore.getClient().listen(asQuery(), listenOptions2, obj5), obj5);
        return ActivityScope.bind(activity3, obj3);
    }

    private Query asQuery() {
        return Query.atPath(this.key.getPath());
    }

    private com.google.firebase.firestore.DocumentSnapshot c(j j) {
        Object obj7;
        final Object obj = obj7;
        if (obj != null && (Document)obj.hasLocalMutations()) {
            obj7 = obj.hasLocalMutations() ? 1 : 0;
        } else {
        }
        super(this.firestore, this.key, obj, 1, obj7);
        return obj7;
    }

    static void e(k k, k k2, com.google.firebase.firestore.Source source3, com.google.firebase.firestore.DocumentSnapshot documentSnapshot4, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException5) {
        com.google.firebase.firestore.FirebaseFirestoreException obj2;
        Object obj3;
        Object obj4;
        final String str = "Failed to register a listener for a single document";
        if (firebaseFirestoreException5 != null) {
            k.b(firebaseFirestoreException5);
        }
        final int obj5 = 0;
        (ListenerRegistration)m.a(k2.a()).remove();
        if (!documentSnapshot4.exists() && documentSnapshot4.getMetadata().isFromCache()) {
            if (documentSnapshot4.getMetadata().isFromCache()) {
                obj2 = new FirebaseFirestoreException("Failed to get document because the client is offline.", FirebaseFirestoreException.Code.UNAVAILABLE);
                k.b(obj2);
            } else {
                if (documentSnapshot4.exists() && documentSnapshot4.getMetadata().isFromCache() && source3 == Source.SERVER) {
                    if (documentSnapshot4.getMetadata().isFromCache()) {
                        if (source3 == Source.SERVER) {
                            obj2 = new FirebaseFirestoreException("Failed to get document from server. (However, this document does exist in the local cache. Run again without setting source to SERVER to retrieve the cached document.)", FirebaseFirestoreException.Code.UNAVAILABLE);
                            k.b(obj2);
                        } else {
                            try {
                                k.c(documentSnapshot4);
                                k2 = Thread.currentThread();
                                k2.interrupt();
                                k2 = new Object[firebaseFirestoreException5];
                                k = Assert.fail(k, obj0, k2);
                                throw k;
                                k2 = new Object[firebaseFirestoreException5];
                                k = Assert.fail(k, obj0, k2);
                                throw k;
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
    }

    static com.google.firebase.firestore.DocumentReference forPath(ResourcePath resourcePath, com.google.firebase.firestore.FirebaseFirestore firebaseFirestore2) {
        if (length %= 2 != 0) {
        } else {
            DocumentReference documentReference = new DocumentReference(DocumentKey.fromPath(resourcePath), firebaseFirestore2);
            return documentReference;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid document reference. Document references must have an even number of segments, but ");
        stringBuilder.append(resourcePath.canonicalString());
        stringBuilder.append(" has ");
        stringBuilder.append(resourcePath.length());
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    private j<com.google.firebase.firestore.DocumentSnapshot> getViaSnapshotListener(com.google.firebase.firestore.Source source) {
        k kVar = new k();
        k kVar2 = new k();
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        int i = 1;
        listenOptions.includeDocumentMetadataChanges = i;
        listenOptions.includeQueryMetadataChanges = i;
        listenOptions.waitForSyncWhenOnline = i;
        c cVar = new c(kVar, kVar2, source);
        kVar2.c(addSnapshotListenerInternal(Executors.DIRECT_EXECUTOR, listenOptions, 0, cVar));
        return kVar.a();
    }

    private static EventManager.ListenOptions internalOptions(com.google.firebase.firestore.MetadataChanges metadataChanges) {
        int i;
        int i2;
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        final com.google.firebase.firestore.MetadataChanges iNCLUDE = MetadataChanges.INCLUDE;
        final int i3 = 0;
        i2 = metadataChanges == iNCLUDE ? i : i3;
        listenOptions.includeDocumentMetadataChanges = i2;
        if (metadataChanges == iNCLUDE) {
        } else {
            i = i3;
        }
        listenOptions.includeQueryMetadataChanges = i;
        listenOptions.waitForSyncWhenOnline = i3;
        return listenOptions;
    }

    private j<Void> update(UserData.ParsedUpdateData userData$ParsedUpdateData) {
        return this.firestore.getClient().write(Collections.singletonList(parsedUpdateData.toMutation(this.key, Precondition.exists(true)))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Activity activity, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.DocumentSnapshot> eventListener2) {
        return addSnapshotListener(activity, MetadataChanges.EXCLUDE, eventListener2);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Activity activity, com.google.firebase.firestore.MetadataChanges metadataChanges2, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.DocumentSnapshot> eventListener3) {
        Preconditions.checkNotNull(activity, "Provided activity must not be null.");
        Preconditions.checkNotNull(metadataChanges2, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener3, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(Executors.DEFAULT_CALLBACK_EXECUTOR, DocumentReference.internalOptions(metadataChanges2), activity, eventListener3);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(com.google.firebase.firestore.EventListener<com.google.firebase.firestore.DocumentSnapshot> eventListener) {
        return addSnapshotListener(MetadataChanges.EXCLUDE, eventListener);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(com.google.firebase.firestore.MetadataChanges metadataChanges, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.DocumentSnapshot> eventListener2) {
        return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, metadataChanges, eventListener2);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Executor executor, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.DocumentSnapshot> eventListener2) {
        return addSnapshotListener(executor, MetadataChanges.EXCLUDE, eventListener2);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Executor executor, com.google.firebase.firestore.MetadataChanges metadataChanges2, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.DocumentSnapshot> eventListener3) {
        Preconditions.checkNotNull(executor, "Provided executor must not be null.");
        Preconditions.checkNotNull(metadataChanges2, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener3, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(executor, DocumentReference.internalOptions(metadataChanges2), 0, eventListener3);
    }

    public void b(com.google.firebase.firestore.EventListener eventListener, ViewSnapshot viewSnapshot2, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException3) {
        a(eventListener, viewSnapshot2, firebaseFirestoreException3);
    }

    public com.google.firebase.firestore.CollectionReference collection(String string) {
        Preconditions.checkNotNull(string, "Provided collection path must not be null.");
        CollectionReference collectionReference = new CollectionReference((ResourcePath)this.key.getPath().append(ResourcePath.fromString(string)), this.firestore);
        return collectionReference;
    }

    public com.google.firebase.firestore.DocumentSnapshot d(j j) {
        return c(j);
    }

    public j<Void> delete() {
        DeleteMutation deleteMutation = new DeleteMutation(this.key, Precondition.NONE);
        return this.firestore.getClient().write(Collections.singletonList(deleteMutation)).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    public boolean equals(Object object) {
        int i;
        boolean firestore;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof DocumentReference == null) {
            return i2;
        }
        if (this.key.equals(object.key) && this.firestore.equals(object.firestore)) {
            if (this.firestore.equals(object.firestore)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public j<com.google.firebase.firestore.DocumentSnapshot> get() {
        return get(Source.DEFAULT);
    }

    public j<com.google.firebase.firestore.DocumentSnapshot> get(com.google.firebase.firestore.Source source) {
        if (source == Source.CACHE) {
            d dVar = new d(this);
            return this.firestore.getClient().getDocumentFromLocalCache(this.key).continueWith(Executors.DIRECT_EXECUTOR, dVar);
        }
        return getViaSnapshotListener(source);
    }

    public com.google.firebase.firestore.FirebaseFirestore getFirestore() {
        return this.firestore;
    }

    public String getId() {
        return this.key.getPath().getLastSegment();
    }

    DocumentKey getKey() {
        return this.key;
    }

    public com.google.firebase.firestore.CollectionReference getParent() {
        CollectionReference collectionReference = new CollectionReference((ResourcePath)this.key.getPath().popLast(), this.firestore);
        return collectionReference;
    }

    public String getPath() {
        return this.key.getPath().canonicalString();
    }

    public int hashCode() {
        return i2 += i4;
    }

    public j<Void> set(Object object) {
        return set(object, SetOptions.OVERWRITE);
    }

    public j<Void> set(Object object, com.google.firebase.firestore.SetOptions setOptions2) {
        com.google.firebase.firestore.UserDataReader userDataReader;
        UserData.ParsedSetData obj3;
        Object obj4;
        Preconditions.checkNotNull(object, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions2, "Provided options must not be null.");
        if (setOptions2.isMerge()) {
            obj3 = this.firestore.getUserDataReader().parseMergeData(object, setOptions2.getFieldMask());
        } else {
            obj3 = this.firestore.getUserDataReader().parseSetData(object);
        }
        return this.firestore.getClient().write(Collections.singletonList(obj3.toMutation(this.key, Precondition.NONE))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    public j<Void> update(com.google.firebase.firestore.FieldPath fieldPath, Object object2, Object... object3Arr3) {
        return update(this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, object2, object3Arr3)));
    }

    public j<Void> update(String string, Object object2, Object... object3Arr3) {
        return update(this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, string, object2, object3Arr3)));
    }

    public j<Void> update(Map<String, Object> map) {
        return update(this.firestore.getUserDataReader().parseUpdateData(map));
    }
}
