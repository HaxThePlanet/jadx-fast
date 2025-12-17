package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.VerifyMutation;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Transaction {

    private static final Executor defaultExecutor;
    private boolean committed;
    private final Datastore datastore;
    private FirebaseFirestoreException lastWriteError;
    private final ArrayList<Mutation> mutations;
    private final HashMap<DocumentKey, SnapshotVersion> readVersions;
    private Set<DocumentKey> writtenDocs;
    static {
        Transaction.defaultExecutor = Transaction.createDefaultExecutor();
    }

    public Transaction(Datastore datastore) {
        super();
        HashMap hashMap = new HashMap();
        this.readVersions = hashMap;
        ArrayList arrayList = new ArrayList();
        this.mutations = arrayList;
        HashSet hashSet = new HashSet();
        this.writtenDocs = hashSet;
        this.datastore = datastore;
    }

    static j a(j j) {
        if (j.isSuccessful()) {
            return m.e(0);
        }
        return m.d(j.getException());
    }

    private j b(j j) {
        boolean successful;
        Object next;
        if (j.isSuccessful()) {
            successful = (List)j.getResult().iterator();
            for (MutableDocument next : successful) {
                recordVersion(next);
            }
        }
        return j;
    }

    private static Executor createDefaultExecutor() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final int i3 = 1;
        final int i2 = 5;
        super(i2, i2, (long)i3, obj4, TimeUnit.SECONDS, linkedBlockingQueue);
        threadPoolExecutor2.allowCoreThreadTimeOut(i3);
        return threadPoolExecutor2;
    }

    private void ensureCommitNotCalled() {
        Assert.hardAssert(committed ^= 1, "A transaction object cannot be used after its update callback has been invoked.", new Object[0]);
    }

    public static Executor getDefaultExecutor() {
        return Transaction.defaultExecutor;
    }

    private Precondition precondition(DocumentKey documentKey) {
        Object obj = this.readVersions.get(documentKey);
        if (!this.writtenDocs.contains(documentKey) && (SnapshotVersion)obj != null) {
            if ((SnapshotVersion)obj != null) {
                return Precondition.updateTime((SnapshotVersion)obj);
            }
        }
        return Precondition.NONE;
    }

    private Precondition preconditionForUpdate(DocumentKey documentKey) {
        boolean obj3;
        Object obj = this.readVersions.get(documentKey);
        if (!this.writtenDocs.contains(documentKey) && (SnapshotVersion)obj != null && (SnapshotVersion)obj != null) {
            if ((SnapshotVersion)obj != null) {
                if ((SnapshotVersion)obj != null) {
                    if ((SnapshotVersion)obj.equals(SnapshotVersion.NONE)) {
                    } else {
                    }
                    obj3 = new FirebaseFirestoreException("Can't update a document that doesn't exist.", FirebaseFirestoreException.Code.INVALID_ARGUMENT);
                    throw obj3;
                }
                return Precondition.updateTime(obj);
            }
        }
        return Precondition.exists(true);
    }

    private void recordVersion(MutableDocument mutableDocument) {
        SnapshotVersion nONE;
        Object readVersions;
        boolean obj4;
        if (mutableDocument.isFoundDocument()) {
            nONE = mutableDocument.getVersion();
            if (this.readVersions.containsKey(mutableDocument.getKey())) {
                if (!(SnapshotVersion)this.readVersions.get(mutableDocument.getKey()).equals(mutableDocument.getVersion())) {
                } else {
                }
                obj4 = new FirebaseFirestoreException("Document version changed between two reads.", FirebaseFirestoreException.Code.ABORTED);
                throw obj4;
            }
            this.readVersions.put(mutableDocument.getKey(), nONE);
        } else {
            if (!mutableDocument.isNoDocument()) {
            } else {
                nONE = SnapshotVersion.NONE;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected document type in transaction: ");
        stringBuilder.append(mutableDocument);
        throw Assert.fail(stringBuilder.toString(), new Object[0]);
    }

    private void write(List<Mutation> list) {
        ensureCommitNotCalled();
        this.mutations.addAll(list);
    }

    public j c(j j) {
        b(j);
        return j;
    }

    public j<Void> commit() {
        Iterator iterator;
        DocumentKey key;
        boolean mutations;
        VerifyMutation verifyMutation;
        Precondition precondition;
        ensureCommitNotCalled();
        FirebaseFirestoreException lastWriteError = this.lastWriteError;
        if (lastWriteError != null) {
            return m.d(lastWriteError);
        }
        HashSet hashSet = new HashSet(this.readVersions.keySet());
        iterator = this.mutations.iterator();
        for (Mutation next2 : iterator) {
            hashSet.remove(next2.getKey());
        }
        Iterator iterator2 = hashSet.iterator();
        for (DocumentKey iterator : iterator2) {
            verifyMutation = new VerifyMutation(iterator, precondition(iterator));
            this.mutations.add(verifyMutation);
        }
        this.committed = true;
        return this.datastore.commit(this.mutations).continueWithTask(Executors.DIRECT_EXECUTOR, x.a);
    }

    public void delete(DocumentKey documentKey) {
        DeleteMutation deleteMutation = new DeleteMutation(documentKey, precondition(documentKey));
        write(Collections.singletonList(deleteMutation));
        this.writtenDocs.add(documentKey);
    }

    public j<List<MutableDocument>> lookup(List<DocumentKey> list) {
        ensureCommitNotCalled();
        if (this.mutations.size() != 0) {
            FirebaseFirestoreException obj3 = new FirebaseFirestoreException("Firestore transactions require all reads to be executed before all writes.", FirebaseFirestoreException.Code.INVALID_ARGUMENT);
            return m.d(obj3);
        }
        y yVar = new y(this);
        return this.datastore.lookup(list).continueWithTask(Executors.DIRECT_EXECUTOR, yVar);
    }

    public void set(DocumentKey documentKey, com.google.firebase.firestore.core.UserData.ParsedSetData userData$ParsedSetData2) {
        write(Collections.singletonList(parsedSetData2.toMutation(documentKey, precondition(documentKey))));
        this.writtenDocs.add(documentKey);
    }

    public void update(DocumentKey documentKey, com.google.firebase.firestore.core.UserData.ParsedUpdateData userData$ParsedUpdateData2) {
        List obj3;
        try {
            write(Collections.singletonList(parsedUpdateData2.toMutation(documentKey, preconditionForUpdate(documentKey))));
            this.lastWriteError = parsedUpdateData2;
            this.writtenDocs.add(documentKey);
        }
    }
}
