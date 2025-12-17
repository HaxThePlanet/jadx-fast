package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class View {

    private boolean current;
    private DocumentSet documentSet;
    private ImmutableSortedSet<DocumentKey> limboDocuments;
    private ImmutableSortedSet<DocumentKey> mutatedKeys;
    private final com.google.firebase.firestore.core.Query query;
    private com.google.firebase.firestore.core.ViewSnapshot.SyncState syncState;
    private ImmutableSortedSet<DocumentKey> syncedDocuments;

    public static class DocumentChanges {

        final com.google.firebase.firestore.core.DocumentViewChangeSet changeSet;
        final DocumentSet documentSet;
        final ImmutableSortedSet<DocumentKey> mutatedKeys;
        private final boolean needsRefill;
        private DocumentChanges(DocumentSet documentSet, com.google.firebase.firestore.core.DocumentViewChangeSet documentViewChangeSet2, ImmutableSortedSet<DocumentKey> immutableSortedSet3, boolean z4) {
            super();
            this.documentSet = documentSet;
            this.changeSet = documentViewChangeSet2;
            this.mutatedKeys = immutableSortedSet3;
            this.needsRefill = z4;
        }

        DocumentChanges(DocumentSet documentSet, com.google.firebase.firestore.core.DocumentViewChangeSet documentViewChangeSet2, ImmutableSortedSet immutableSortedSet3, boolean z4, com.google.firebase.firestore.core.View.1 view$15) {
            super(documentSet, documentViewChangeSet2, immutableSortedSet3, z4);
        }

        static boolean access$100(com.google.firebase.firestore.core.View.DocumentChanges view$DocumentChanges) {
            return documentChanges.needsRefill;
        }

        public boolean needsRefill() {
            return this.needsRefill;
        }
    }
    public View(com.google.firebase.firestore.core.Query query, ImmutableSortedSet<DocumentKey> immutableSortedSet2) {
        super();
        this.query = query;
        this.syncState = ViewSnapshot.SyncState.NONE;
        this.documentSet = DocumentSet.emptySet(query.comparator());
        this.syncedDocuments = immutableSortedSet2;
        this.limboDocuments = DocumentKey.emptyKeySet();
        this.mutatedKeys = DocumentKey.emptyKeySet();
    }

    private int a(com.google.firebase.firestore.core.DocumentViewChange documentViewChange, com.google.firebase.firestore.core.DocumentViewChange documentViewChange2) {
        int compareIntegers = Util.compareIntegers(View.changeTypeOrder(documentViewChange), View.changeTypeOrder(documentViewChange2));
        documentViewChange.getType().compareTo(documentViewChange2.getType());
        if (compareIntegers != 0) {
            return compareIntegers;
        }
        return this.query.comparator().compare(documentViewChange.getDocument(), documentViewChange2.getDocument());
    }

    private void applyTargetChange(TargetChange targetChange) {
        Iterator iterator;
        boolean insert;
        boolean next;
        boolean remove;
        ImmutableSortedSet syncedDocuments;
        Object[] arr;
        int i;
        boolean obj6;
        if (targetChange) {
            Iterator iterator2 = targetChange.getAddedDocuments().iterator();
            for (DocumentKey next2 : iterator2) {
                this.syncedDocuments = this.syncedDocuments.insert(next2);
            }
            Iterator iterator3 = targetChange.getModifiedDocuments().iterator();
            for (DocumentKey next4 : iterator3) {
                arr = new Object[1];
                Assert.hardAssert(this.syncedDocuments.contains(next4), "Modified document %s not found in view.", next4);
            }
            iterator = targetChange.getRemovedDocuments().iterator();
            for (DocumentKey next3 : iterator) {
                this.syncedDocuments = this.syncedDocuments.remove(next3);
            }
            this.current = targetChange.isCurrent();
        }
    }

    private static int changeTypeOrder(com.google.firebase.firestore.core.DocumentViewChange documentViewChange) {
        int i;
        int i2;
        int i3 = View.1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[documentViewChange.getType().ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                    } else {
                        return 0;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown change type: ");
                    stringBuilder.append(documentViewChange.getType());
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
            }
        }
        return i;
    }

    private boolean shouldBeLimboDoc(DocumentKey documentKey) {
        final int i = 0;
        if (this.syncedDocuments.contains(documentKey)) {
            return i;
        }
        Document obj3 = this.documentSet.getDocument(documentKey);
        if (obj3 == null) {
            return i;
        }
        if (obj3.hasLocalMutations()) {
            return i;
        }
        return 1;
    }

    private boolean shouldWaitForSyncedDocument(Document document, Document document2) {
        int obj1;
        if (document.hasLocalMutations() && document2.hasCommittedMutations() && !document2.hasLocalMutations()) {
            if (document2.hasCommittedMutations()) {
                obj1 = !document2.hasLocalMutations() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    private List<com.google.firebase.firestore.core.LimboDocumentChange> updateLimboDocuments() {
        Object insert;
        boolean limboDocuments;
        int size;
        boolean next;
        boolean limboDocumentChange;
        com.google.firebase.firestore.core.LimboDocumentChange.Type rEMOVED;
        if (!this.current) {
            return Collections.emptyList();
        }
        ImmutableSortedSet limboDocuments2 = this.limboDocuments;
        this.limboDocuments = DocumentKey.emptyKeySet();
        Iterator iterator = this.documentSet.iterator();
        while (iterator.hasNext()) {
            insert = iterator.next();
            if (shouldBeLimboDoc((Document)insert.getKey())) {
            }
            this.limboDocuments = this.limboDocuments.insert(insert.getKey());
        }
        ArrayList arrayList = new ArrayList(size2 += size);
        Iterator iterator2 = limboDocuments2.iterator();
        while (iterator2.hasNext()) {
            size = iterator2.next();
            if (!this.limboDocuments.contains((DocumentKey)size)) {
            }
            limboDocumentChange = new LimboDocumentChange(LimboDocumentChange.Type.REMOVED, size);
            arrayList.add(limboDocumentChange);
        }
        Iterator iterator3 = this.limboDocuments.iterator();
        while (iterator3.hasNext()) {
            next = iterator3.next();
            if (!limboDocuments2.contains((DocumentKey)next)) {
            }
            limboDocumentChange = new LimboDocumentChange(LimboDocumentChange.Type.ADDED, next);
            arrayList.add(limboDocumentChange);
        }
        return arrayList;
    }

    public com.google.firebase.firestore.core.ViewChange applyChanges(com.google.firebase.firestore.core.View.DocumentChanges view$DocumentChanges) {
        return applyChanges(documentChanges, 0);
    }

    public com.google.firebase.firestore.core.ViewChange applyChanges(com.google.firebase.firestore.core.View.DocumentChanges view$DocumentChanges, TargetChange targetChange2) {
        int current;
        int i3;
        com.google.firebase.firestore.core.ViewSnapshot.SyncState sYNCED;
        int viewSnapshot;
        int size;
        com.google.firebase.firestore.core.Query query;
        DocumentSet documentSet;
        int i2;
        ImmutableSortedSet mutatedKeys;
        int i4;
        int i;
        final Object obj = this;
        Object obj2 = documentChanges;
        final int i6 = 1;
        final int i7 = 0;
        Assert.hardAssert(z ^= i6, "Cannot apply changes that need a refill", new Object[i7]);
        obj.documentSet = obj2.documentSet;
        obj.mutatedKeys = obj2.mutatedKeys;
        final List changes = obj2.changeSet.getChanges();
        c0 c0Var = new c0(obj);
        Collections.sort(changes, c0Var);
        obj.applyTargetChange(targetChange2);
        if (obj.limboDocuments.size() == 0 && obj.current) {
            i3 = obj.current ? i6 : i7;
        } else {
        }
        sYNCED = i3 != 0 ? ViewSnapshot.SyncState.SYNCED : ViewSnapshot.SyncState.LOCAL;
        i4 = sYNCED != obj.syncState ? i6 : i7;
        obj.syncState = sYNCED;
        viewSnapshot = 0;
        if (changes.size() == 0) {
            if (i4 != 0) {
                i2 = sYNCED == ViewSnapshot.SyncState.LOCAL ? i6 : i7;
                super(obj.query, obj2.documentSet, obj.documentSet, changes, i2, obj2.mutatedKeys, i4, 0);
            }
        } else {
        }
        ViewChange viewChange = new ViewChange(viewSnapshot, updateLimboDocuments());
        return viewChange;
    }

    public com.google.firebase.firestore.core.ViewChange applyOnlineStateChange(com.google.firebase.firestore.core.OnlineState onlineState) {
        boolean oFFLINE;
        if (this.current && onlineState == OnlineState.OFFLINE) {
            if (onlineState == OnlineState.OFFLINE) {
                this.current = false;
                DocumentViewChangeSet documentViewChangeSet = new DocumentViewChangeSet();
                super(this.documentSet, documentViewChangeSet, this.mutatedKeys, 0, 0);
                return applyChanges(obj7);
            }
        }
        ViewChange obj7 = new ViewChange(0, Collections.emptyList());
        return obj7;
    }

    public int b(com.google.firebase.firestore.core.DocumentViewChange documentViewChange, com.google.firebase.firestore.core.DocumentViewChange documentViewChange2) {
        return a(documentViewChange, documentViewChange2);
    }

    public com.google.firebase.firestore.core.View.DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        return computeDocChanges(immutableSortedMap, 0);
    }

    public com.google.firebase.firestore.core.View.DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap, com.google.firebase.firestore.core.View.DocumentChanges view$DocumentChanges2) {
        int i5;
        com.google.firebase.firestore.core.DocumentViewChangeSet documentViewChangeSet;
        DocumentSet waitForSyncedDocument;
        boolean limitToFirst;
        com.google.firebase.firestore.core.Query query;
        int create;
        Document firstDocument;
        ImmutableSortedSet mutatedKeys;
        boolean limitToFirst3;
        int lastDocument;
        int value;
        long limitToFirst2;
        long l;
        int firstDocument2;
        boolean limitToLast;
        long iterator;
        long committedMutations;
        int i3;
        DocumentSet remove;
        int i;
        Object contains;
        int i2;
        int i4;
        Object localMutations;
        Object key;
        Document document;
        Object value2;
        DocumentSet set;
        final Object obj = this;
        Object obj2 = documentChanges2;
        if (obj2 != null) {
            documentViewChangeSet = obj2.changeSet;
        } else {
            documentViewChangeSet = new DocumentViewChangeSet();
        }
        final com.google.firebase.firestore.core.DocumentViewChangeSet set3 = documentViewChangeSet;
        waitForSyncedDocument = obj2 != null ? obj2.documentSet : obj.documentSet;
        mutatedKeys = obj2 != null ? obj2.mutatedKeys : obj.mutatedKeys;
        if (obj.query.hasLimitToFirst() && Long.compare(l, committedMutations) == 0) {
            if (Long.compare(l, committedMutations) == 0) {
                lastDocument = waitForSyncedDocument.getLastDocument();
            } else {
                lastDocument = 0;
            }
        } else {
        }
        if (obj.query.hasLimitToLast() && Long.compare(l2, committedMutations) == 0) {
            if (Long.compare(l2, committedMutations) == 0) {
                firstDocument2 = waitForSyncedDocument.getFirstDocument();
            } else {
                firstDocument2 = 0;
            }
        } else {
        }
        iterator = immutableSortedMap.iterator();
        remove = waitForSyncedDocument;
        i3 = 0;
        while (iterator.hasNext()) {
            contains = iterator.next();
            key = (Map.Entry)contains.getKey();
            document = waitForSyncedDocument.getDocument((DocumentKey)key);
            if (obj.query.matches((Document)contains.getValue())) {
            } else {
            }
            value = 0;
            if (document != null && obj.mutatedKeys.contains(document.getKey())) {
            } else {
            }
            i = 0;
            if (value != null) {
            } else {
            }
            committedMutations = 0;
            if (document != null && value != null) {
            } else {
            }
            set = waitForSyncedDocument;
            if (document == null && value != null) {
            } else {
            }
            if (document != null) {
            } else {
            }
            i2 = 0;
            if (i2 != 0) {
            }
            waitForSyncedDocument = set;
            if (value != null) {
            } else {
            }
            remove = remove.remove(key);
            waitForSyncedDocument = mutatedKeys.remove(key);
            mutatedKeys = waitForSyncedDocument;
            remove = remove.add(value);
            if (value.hasLocalMutations()) {
            } else {
            }
            waitForSyncedDocument = mutatedKeys.remove(value.getKey());
            waitForSyncedDocument = mutatedKeys.insert(value.getKey());
            if (value == null) {
            } else {
            }
            set3.addChange(DocumentViewChange.create(DocumentViewChange.Type.REMOVED, document));
            if (lastDocument == 0) {
            } else {
            }
            i3 = 1;
            i2 = 1;
            if (firstDocument2 != 0) {
            }
            if (value != null) {
            } else {
            }
            set3.addChange(DocumentViewChange.create(DocumentViewChange.Type.ADDED, value));
            if (value != null) {
            } else {
            }
            set = waitForSyncedDocument;
            if (!document.getData().equals(value.getData())) {
            } else {
            }
            if (i != committedMutations) {
            } else {
            }
            set3.addChange(DocumentViewChange.create(DocumentViewChange.Type.METADATA, value));
            if (!obj.shouldWaitForSyncedDocument(document, value)) {
            } else {
            }
            set3.addChange(DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, value));
            if (lastDocument != 0) {
            } else {
            }
            if (firstDocument2 != 0 && obj.query.comparator().compare(value, firstDocument2) < 0) {
            }
            if (obj.query.comparator().compare(value, firstDocument2) < 0) {
            }
            if (obj.query.comparator().compare(value, lastDocument) <= 0) {
            } else {
            }
            if (!value.hasLocalMutations()) {
            } else {
            }
            committedMutations = 1;
            if (obj.mutatedKeys.contains(value.getKey()) && value.hasCommittedMutations()) {
            } else {
            }
            if (value.hasCommittedMutations()) {
            } else {
            }
            if (obj.mutatedKeys.contains(document.getKey())) {
            } else {
            }
            i = 1;
            value = contains.getValue();
        }
        if (!obj.query.hasLimitToFirst()) {
            if (obj.query.hasLimitToLast()) {
                if (obj.query.hasLimitToFirst()) {
                    limitToFirst2 = obj.query.getLimitToFirst();
                } else {
                    limitToFirst2 = obj.query.getLimitToLast();
                }
                iterator = (long)create;
                while (Long.compare(iterator, value) > 0) {
                    if (obj.query.hasLimitToFirst()) {
                    } else {
                    }
                    firstDocument = remove.getFirstDocument();
                    remove = remove.remove(firstDocument.getKey());
                    mutatedKeys = mutatedKeys.remove(firstDocument.getKey());
                    set3.addChange(DocumentViewChange.create(DocumentViewChange.Type.REMOVED, firstDocument));
                    limitToFirst2 = 1L;
                    firstDocument = remove.getLastDocument();
                }
            }
        } else {
        }
        if (i3 != 0) {
            if (obj2 == null) {
                i5 = 0;
                i4 = 1;
            } else {
                i5 = 0;
                i4 = 0;
            }
        } else {
        }
        Assert.hardAssert(i4, "View was refilled using docs that themselves needed refilling.", new Object[i5]);
        super(remove, set3, mutatedKeys, i3, 0);
        return documentChanges;
    }

    ImmutableSortedSet<DocumentKey> getLimboDocuments() {
        return this.limboDocuments;
    }

    public com.google.firebase.firestore.core.ViewSnapshot.SyncState getSyncState() {
        return this.syncState;
    }

    ImmutableSortedSet<DocumentKey> getSyncedDocuments() {
        return this.syncedDocuments;
    }
}
