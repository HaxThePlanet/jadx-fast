package com.google.firebase.firestore;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class QuerySnapshot implements Iterable<com.google.firebase.firestore.QueryDocumentSnapshot> {

    private List<com.google.firebase.firestore.DocumentChange> cachedChanges;
    private com.google.firebase.firestore.MetadataChanges cachedChangesMetadataState;
    private final com.google.firebase.firestore.FirebaseFirestore firestore;
    private final com.google.firebase.firestore.SnapshotMetadata metadata;
    private final com.google.firebase.firestore.Query originalQuery;
    private final ViewSnapshot snapshot;

    private class QuerySnapshotIterator implements Iterator<com.google.firebase.firestore.QueryDocumentSnapshot> {

        private final Iterator<Document> it;
        final com.google.firebase.firestore.QuerySnapshot this$0;
        QuerySnapshotIterator(com.google.firebase.firestore.QuerySnapshot querySnapshot, Iterator iterator2) {
            this.this$0 = querySnapshot;
            super();
            this.it = iterator2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public com.google.firebase.firestore.QueryDocumentSnapshot next() {
            return QuerySnapshot.access$000(this.this$0, (Document)this.it.next());
        }

        @Override // java.util.Iterator
        public Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("QuerySnapshot does not support remove().");
            throw unsupportedOperationException;
        }
    }
    QuerySnapshot(com.google.firebase.firestore.Query query, ViewSnapshot viewSnapshot2, com.google.firebase.firestore.FirebaseFirestore firebaseFirestore3) {
        super();
        this.originalQuery = (Query)Preconditions.checkNotNull(query);
        this.snapshot = (ViewSnapshot)Preconditions.checkNotNull(viewSnapshot2);
        this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(firebaseFirestore3);
        SnapshotMetadata obj1 = new SnapshotMetadata(viewSnapshot2.hasPendingWrites(), viewSnapshot2.isFromCache());
        this.metadata = obj1;
    }

    static com.google.firebase.firestore.QueryDocumentSnapshot access$000(com.google.firebase.firestore.QuerySnapshot querySnapshot, Document document2) {
        return querySnapshot.convertDocument(document2);
    }

    private com.google.firebase.firestore.QueryDocumentSnapshot convertDocument(Document document) {
        return QueryDocumentSnapshot.fromDocument(this.firestore, document, this.snapshot.isFromCache(), this.snapshot.getMutatedKeys().contains(document.getKey()));
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        int i;
        boolean metadata;
        Object originalQuery;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof QuerySnapshot) {
            return i2;
        }
        if (this.firestore.equals(object.firestore) && this.originalQuery.equals(object.originalQuery) && this.snapshot.equals(object.snapshot) && this.metadata.equals(object.metadata)) {
            if (this.originalQuery.equals(object.originalQuery)) {
                if (this.snapshot.equals(object.snapshot)) {
                    if (this.metadata.equals(object.metadata)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public List<com.google.firebase.firestore.DocumentChange> getDocumentChanges() {
        return getDocumentChanges(MetadataChanges.EXCLUDE);
    }

    public List<com.google.firebase.firestore.DocumentChange> getDocumentChanges(com.google.firebase.firestore.MetadataChanges metadataChanges) {
        boolean excludesMetadataChanges;
        Object cachedChangesMetadataState;
        ViewSnapshot snapshot;
        if (MetadataChanges.INCLUDE.equals(metadataChanges)) {
            if (this.snapshot.excludesMetadataChanges()) {
            } else {
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("To include metadata changes with your document changes, you must also pass MetadataChanges.INCLUDE to addSnapshotListener().");
            throw obj3;
        }
        if (this.cachedChanges != null) {
            if (this.cachedChangesMetadataState != metadataChanges) {
                this.cachedChanges = Collections.unmodifiableList(DocumentChange.changesFromSnapshot(this.firestore, metadataChanges, this.snapshot));
                this.cachedChangesMetadataState = metadataChanges;
            }
        } else {
        }
        return this.cachedChanges;
    }

    public List<com.google.firebase.firestore.DocumentSnapshot> getDocuments() {
        com.google.firebase.firestore.QueryDocumentSnapshot convertDocument;
        ArrayList arrayList = new ArrayList(this.snapshot.getDocuments().size());
        Iterator iterator = this.snapshot.getDocuments().iterator();
        for (Document next2 : iterator) {
            arrayList.add(convertDocument(next2));
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.SnapshotMetadata getMetadata() {
        return this.metadata;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.Query getQuery() {
        return this.originalQuery;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        return i6 += i10;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        return this.snapshot.getDocuments().isEmpty();
    }

    public Iterator<com.google.firebase.firestore.QueryDocumentSnapshot> iterator() {
        QuerySnapshot.QuerySnapshotIterator querySnapshotIterator = new QuerySnapshot.QuerySnapshotIterator(this, this.snapshot.getDocuments().iterator());
        return querySnapshotIterator;
    }

    @Override // java.lang.Iterable
    public int size() {
        return this.snapshot.getDocuments().size();
    }

    public <T> List<T> toObjects(Class<T> class) {
        return toObjects(class, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public <T> List<T> toObjects(Class<T> class, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        Object object;
        Preconditions.checkNotNull(class, "Provided POJO type must not be null.");
        ArrayList arrayList = new ArrayList();
        final Iterator iterator = iterator();
        for (DocumentSnapshot next2 : iterator) {
            arrayList.add(next2.toObject(class, serverTimestampBehavior2));
        }
        return arrayList;
    }
}
