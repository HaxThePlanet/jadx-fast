package com.google.firebase.firestore;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.DocumentViewChange.Type;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DocumentChange {

    private final com.google.firebase.firestore.QueryDocumentSnapshot document;
    private final int newIndex;
    private final int oldIndex;
    private final com.google.firebase.firestore.DocumentChange.Type type;

    public static enum Type {

        ADDED,
        MODIFIED,
        REMOVED;
    }
    DocumentChange(com.google.firebase.firestore.QueryDocumentSnapshot queryDocumentSnapshot, com.google.firebase.firestore.DocumentChange.Type documentChange$Type2, int i3, int i4) {
        super();
        this.type = type2;
        this.document = queryDocumentSnapshot;
        this.oldIndex = i3;
        this.newIndex = i4;
    }

    static List<com.google.firebase.firestore.DocumentChange> changesFromSnapshot(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, com.google.firebase.firestore.MetadataChanges metadataChanges2, ViewSnapshot viewSnapshot3) {
        DocumentSet oldDocuments;
        Iterator iterator;
        Object aDDED;
        boolean next;
        int comparator;
        DocumentViewChange.Type eXCLUDE;
        Object mETADATA;
        int indexOf;
        Object documentChange;
        com.google.firebase.firestore.DocumentChange.Type rEMOVED;
        int i;
        Object[] arr;
        com.google.firebase.firestore.MetadataChanges obj14;
        ArrayList arrayList = new ArrayList();
        final int i2 = -1;
        final int i3 = 1;
        final int i4 = 0;
        if (viewSnapshot3.getOldDocuments().isEmpty()) {
            obj14 = 0;
            oldDocuments = viewSnapshot3.getChanges().iterator();
            iterator = i4;
            while (oldDocuments.hasNext()) {
                Object next2 = oldDocuments.next();
                eXCLUDE = (DocumentViewChange)next2.getDocument();
                if (next2.getType() == DocumentViewChange.Type.ADDED) {
                } else {
                }
                comparator = i4;
                Assert.hardAssert(comparator, "Invalid added event for first snapshot", new Object[i4]);
                if (obj14 != null) {
                } else {
                }
                obj14 = i3;
                Assert.hardAssert(obj14, "Got added events in wrong order", new Object[i4]);
                obj14 = new DocumentChange(QueryDocumentSnapshot.fromDocument(firebaseFirestore, eXCLUDE, viewSnapshot3.isFromCache(), viewSnapshot3.getMutatedKeys().contains(eXCLUDE.getKey())), DocumentChange.Type.ADDED, i2, iterator);
                arrayList.add(obj14);
                obj14 = eXCLUDE;
                iterator = indexOf;
                if (viewSnapshot3.getQuery().comparator().compare(obj14, eXCLUDE) < 0) {
                } else {
                }
                obj14 = i4;
                comparator = i3;
            }
        } else {
            oldDocuments = viewSnapshot3.getOldDocuments();
            iterator = viewSnapshot3.getChanges().iterator();
            while (iterator.hasNext()) {
                aDDED = iterator.next();
                if (metadataChanges2 == MetadataChanges.EXCLUDE && (DocumentViewChange)aDDED.getType() == DocumentViewChange.Type.METADATA) {
                } else {
                }
                Document document = aDDED.getDocument();
                aDDED = DocumentChange.getType(aDDED);
                String str2 = "Index for document not found";
                if (aDDED != DocumentChange.Type.ADDED) {
                } else {
                }
                indexOf = i2;
                if (aDDED != DocumentChange.Type.REMOVED) {
                } else {
                }
                eXCLUDE = i2;
                documentChange = new DocumentChange(QueryDocumentSnapshot.fromDocument(firebaseFirestore, document, viewSnapshot3.isFromCache(), viewSnapshot3.getMutatedKeys().contains(document.getKey())), aDDED, indexOf, eXCLUDE);
                arrayList.add(documentChange);
                if (oldDocuments.add(document).indexOf(document.getKey()) >= 0) {
                } else {
                }
                rEMOVED = i4;
                Assert.hardAssert(rEMOVED, str2, new Object[i4]);
                rEMOVED = i3;
                if (oldDocuments.indexOf(document.getKey()) >= 0) {
                } else {
                }
                i = i4;
                Assert.hardAssert(i, str2, new Object[i4]);
                oldDocuments = oldDocuments.remove(document.getKey());
                i = i3;
                if (aDDED.getType() == DocumentViewChange.Type.METADATA) {
                } else {
                }
            }
        }
        return arrayList;
    }

    private static com.google.firebase.firestore.DocumentChange.Type getType(DocumentViewChange documentViewChange) {
        int i;
        int i2 = DocumentChange.1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[documentViewChange.getType().ordinal()];
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                    } else {
                        return DocumentChange.Type.REMOVED;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown view change type: ");
                    stringBuilder.append(documentViewChange.getType());
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
            }
            return DocumentChange.Type.MODIFIED;
        }
        return DocumentChange.Type.ADDED;
    }

    public boolean equals(Object object) {
        boolean oldIndex;
        int i;
        com.google.firebase.firestore.DocumentChange.Type oldIndex2;
        Object obj4;
        i = 0;
        if (object instanceof DocumentChange && this.type.equals(object.type) && this.document.equals(object.document) && this.oldIndex == object.oldIndex && this.newIndex == object.newIndex) {
            if (this.type.equals(object.type)) {
                if (this.document.equals(object.document)) {
                    if (this.oldIndex == object.oldIndex) {
                        if (this.newIndex == object.newIndex) {
                            i = 1;
                        }
                    }
                }
            }
        }
        return i;
    }

    public com.google.firebase.firestore.QueryDocumentSnapshot getDocument() {
        return this.document;
    }

    public int getNewIndex() {
        return this.newIndex;
    }

    public int getOldIndex() {
        return this.oldIndex;
    }

    public com.google.firebase.firestore.DocumentChange.Type getType() {
        return this.type;
    }

    public int hashCode() {
        return i6 += newIndex;
    }
}
