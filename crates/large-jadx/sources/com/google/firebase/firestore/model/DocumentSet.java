package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class DocumentSet implements Iterable<com.google.firebase.firestore.model.Document> {

    private final ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, com.google.firebase.firestore.model.Document> keyIndex;
    private final ImmutableSortedSet<com.google.firebase.firestore.model.Document> sortedSet;
    private DocumentSet(ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, com.google.firebase.firestore.model.Document> immutableSortedMap, ImmutableSortedSet<com.google.firebase.firestore.model.Document> immutableSortedSet2) {
        super();
        this.keyIndex = immutableSortedMap;
        this.sortedSet = immutableSortedSet2;
    }

    static int b(Comparator comparator, com.google.firebase.firestore.model.Document document2, com.google.firebase.firestore.model.Document document3) {
        int obj0;
        if (comparator.compare(document2, document3) == 0) {
            obj0 = Document.KEY_COMPARATOR.compare(document2, document3);
        }
        return obj0;
    }

    public static com.google.firebase.firestore.model.DocumentSet emptySet(Comparator<com.google.firebase.firestore.model.Document> comparator) {
        b bVar = new b(comparator);
        ImmutableSortedSet immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), bVar);
        DocumentSet obj4 = new DocumentSet(DocumentCollections.emptyDocumentMap(), immutableSortedSet);
        return obj4;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.model.DocumentSet add(com.google.firebase.firestore.model.Document document) {
        com.google.firebase.firestore.model.DocumentSet remove = remove(document.getKey());
        DocumentSet documentSet = new DocumentSet(remove.keyIndex.insert(document.getKey(), document), remove.sortedSet.insert(document));
        return documentSet;
    }

    @Override // java.lang.Iterable
    public boolean contains(com.google.firebase.firestore.model.DocumentKey documentKey) {
        return this.keyIndex.containsKey(documentKey);
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.DocumentSet> obj;
        int equals;
        Class class;
        Object next;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (DocumentSet.class != object.getClass()) {
            } else {
                if (size() != (DocumentSet)object.size()) {
                    return i2;
                }
                Iterator iterator = iterator();
                for (Document next3 : iterator) {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.model.Document getDocument(com.google.firebase.firestore.model.DocumentKey documentKey) {
        return (Document)this.keyIndex.get(documentKey);
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.model.Document getFirstDocument() {
        return (Document)this.sortedSet.getMinEntry();
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.model.Document getLastDocument() {
        return (Document)this.sortedSet.getMaxEntry();
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.model.Document getPredecessor(com.google.firebase.firestore.model.DocumentKey documentKey) {
        Object obj = this.keyIndex.get(documentKey);
        if ((Document)obj == null) {
        } else {
            return (Document)this.sortedSet.getPredecessorEntry((Document)obj);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key not contained in DocumentSet: ");
        stringBuilder.append(documentKey);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i3;
        int i;
        int i2;
        final Iterator iterator = iterator();
        i3 = 0;
        for (Document next2 : iterator) {
            i6 += i;
        }
        return i3;
    }

    @Override // java.lang.Iterable
    public int indexOf(com.google.firebase.firestore.model.DocumentKey documentKey) {
        Object obj2 = this.keyIndex.get(documentKey);
        if ((Document)obj2 == null) {
            return -1;
        }
        return this.sortedSet.indexOf((Document)obj2);
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        return this.keyIndex.isEmpty();
    }

    public Iterator<com.google.firebase.firestore.model.Document> iterator() {
        return this.sortedSet.iterator();
    }

    @Override // java.lang.Iterable
    public com.google.firebase.firestore.model.DocumentSet remove(com.google.firebase.firestore.model.DocumentKey documentKey) {
        Object obj = this.keyIndex.get(documentKey);
        if ((Document)obj == null) {
            return this;
        }
        DocumentSet documentSet = new DocumentSet(this.keyIndex.remove(documentKey), this.sortedSet.remove((Document)obj));
        return documentSet;
    }

    @Override // java.lang.Iterable
    public int size() {
        return this.keyIndex.size();
    }

    public List<com.google.firebase.firestore.model.Document> toList() {
        Object next;
        ArrayList arrayList = new ArrayList(size());
        Iterator iterator = iterator();
        for (Document next : iterator) {
            arrayList.add(next);
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public String toString() {
        int i;
        Object next;
        String str;
        StringBuilder stringBuilder = new StringBuilder("[");
        Iterator iterator = iterator();
        i = 1;
        while (iterator.hasNext()) {
            if (i != 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append((Document)iterator.next());
            i = 0;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
