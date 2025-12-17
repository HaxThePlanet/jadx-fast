package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.util.Assert;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public final class DocumentKey implements Comparable<com.google.firebase.firestore.model.DocumentKey> {

    private static final Comparator<com.google.firebase.firestore.model.DocumentKey> COMPARATOR = null;
    private static final ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> EMPTY_KEY_SET = null;
    public static final String KEY_FIELD_NAME = "__name__";
    private final com.google.firebase.firestore.model.ResourcePath path;
    static {
        final com.google.firebase.firestore.model.c cVar = c.a;
        DocumentKey.COMPARATOR = cVar;
        ImmutableSortedSet immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), cVar);
        DocumentKey.EMPTY_KEY_SET = immutableSortedSet;
    }

    private DocumentKey(com.google.firebase.firestore.model.ResourcePath resourcePath) {
        super();
        Object[] arr = new Object[1];
        Assert.hardAssert(DocumentKey.isDocumentKey(resourcePath), "Not a document key path: %s", resourcePath);
        this.path = resourcePath;
    }

    public static Comparator<com.google.firebase.firestore.model.DocumentKey> comparator() {
        return DocumentKey.COMPARATOR;
    }

    public static com.google.firebase.firestore.model.DocumentKey empty() {
        return DocumentKey.fromSegments(Collections.emptyList());
    }

    public static ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> emptyKeySet() {
        return DocumentKey.EMPTY_KEY_SET;
    }

    public static com.google.firebase.firestore.model.DocumentKey fromName(String string) {
        int length;
        int i;
        int str;
        String str2;
        com.google.firebase.firestore.model.ResourcePath obj5 = ResourcePath.fromString(string);
        int i4 = 1;
        str = 4;
        final int i5 = 0;
        if (obj5.length() > str && obj5.getSegment(i5).equals("projects") && obj5.getSegment(2).equals("databases") && obj5.getSegment(str).equals("documents")) {
            if (obj5.getSegment(i5).equals("projects")) {
                if (obj5.getSegment(2).equals("databases")) {
                    i = obj5.getSegment(str).equals("documents") ? i4 : i5;
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i4];
        arr[i5] = obj5;
        Assert.hardAssert(i, "Tried to parse an invalid key: %s", arr);
        return DocumentKey.fromPath((ResourcePath)obj5.popFirst(5));
    }

    public static com.google.firebase.firestore.model.DocumentKey fromPath(com.google.firebase.firestore.model.ResourcePath resourcePath) {
        DocumentKey documentKey = new DocumentKey(resourcePath);
        return documentKey;
    }

    public static com.google.firebase.firestore.model.DocumentKey fromPathString(String string) {
        DocumentKey documentKey = new DocumentKey(ResourcePath.fromString(string));
        return documentKey;
    }

    public static com.google.firebase.firestore.model.DocumentKey fromSegments(List<String> list) {
        DocumentKey documentKey = new DocumentKey(ResourcePath.fromSegments(list));
        return documentKey;
    }

    public static boolean isDocumentKey(com.google.firebase.firestore.model.ResourcePath resourcePath) {
        int obj0;
        obj0 = obj0 %= 2 == 0 ? 1 : 0;
        return obj0;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.firestore.model.DocumentKey documentKey) {
        return this.path.compareTo(documentKey.path);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((DocumentKey)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.DocumentKey> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && DocumentKey.class != object.getClass()) {
            if (DocumentKey.class != object.getClass()) {
            }
            return this.path.equals(object.path);
        }
        return 0;
    }

    @Override // java.lang.Comparable
    public String getCollectionGroup() {
        com.google.firebase.firestore.model.ResourcePath path = this.path;
        return path.getSegment(length += -2);
    }

    @Override // java.lang.Comparable
    public com.google.firebase.firestore.model.ResourcePath getPath() {
        return this.path;
    }

    @Override // java.lang.Comparable
    public boolean hasCollectionId(String string) {
        int length;
        List segments;
        Object obj4;
        final int i2 = 2;
        com.google.firebase.firestore.model.ResourcePath path2 = this.path;
        if (this.path.length() >= i2 && (String)path2.segments.get(length2 -= i2).equals(string)) {
            path2 = this.path;
            obj4 = (String)path2.segments.get(length2 -= i2).equals(string) ? 1 : 0;
        } else {
        }
        return obj4;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return this.path.hashCode();
    }

    @Override // java.lang.Comparable
    public String toString() {
        return this.path.toString();
    }
}
