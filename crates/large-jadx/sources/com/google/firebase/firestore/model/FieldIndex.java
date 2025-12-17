package com.google.firebase.firestore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class FieldIndex {

    private final String collectionGroup;
    private final int indexId;
    private final List<com.google.firebase.firestore.model.FieldIndex.Segment> segments;
    private final com.google.firebase.firestore.model.SnapshotVersion version;

    public static abstract class Segment {
        public abstract com.google.firebase.firestore.model.FieldPath getFieldPath();

        public abstract com.google.firebase.firestore.model.FieldIndex.Segment.Kind getKind();

        public String toString() {
            Object[] arr = new Object[2];
            return String.format("Segment{fieldPath=%s, kind=%s}", getFieldPath(), getKind());
        }
    }
    public FieldIndex(String string) {
        super(string, -1);
    }

    public FieldIndex(String string, int i2) {
        super();
        this.collectionGroup = string;
        ArrayList obj1 = new ArrayList();
        this.segments = obj1;
        this.indexId = i2;
        this.version = SnapshotVersion.NONE;
    }

    FieldIndex(String string, int i2, List<com.google.firebase.firestore.model.FieldIndex.Segment> list3, com.google.firebase.firestore.model.SnapshotVersion snapshotVersion4) {
        super();
        this.collectionGroup = string;
        this.segments = list3;
        this.indexId = i2;
        this.version = snapshotVersion4;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.FieldIndex> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (FieldIndex.class != object.getClass()) {
            } else {
                if (!this.segments.equals(object.segments)) {
                    return i;
                }
                if (!this.version.equals(object.version)) {
                    return i;
                }
            }
            return this.collectionGroup.equals(object.collectionGroup);
        }
        return i;
    }

    public Iterable<com.google.firebase.firestore.model.FieldIndex.Segment> getArraySegments() {
        Object next;
        boolean equals;
        com.google.firebase.firestore.model.FieldIndex.Segment.Kind cONTAINS;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.segments.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((FieldIndex.Segment)next.getKind().equals(FieldIndex.Segment.Kind.CONTAINS)) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public String getCollectionGroup() {
        return this.collectionGroup;
    }

    public Iterable<com.google.firebase.firestore.model.FieldIndex.Segment> getDirectionalSegments() {
        Object next;
        boolean equals;
        com.google.firebase.firestore.model.FieldIndex.Segment.Kind oRDERED;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.segments.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((FieldIndex.Segment)next.getKind().equals(FieldIndex.Segment.Kind.ORDERED)) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public int getIndexId() {
        return this.indexId;
    }

    public com.google.firebase.firestore.model.FieldIndex.Segment getSegment(int i) {
        return (FieldIndex.Segment)this.segments.get(i);
    }

    public com.google.firebase.firestore.model.SnapshotVersion getVersion() {
        return this.version;
    }

    public int hashCode() {
        return i4 += i7;
    }

    public int segmentCount() {
        return this.segments.size();
    }

    public String toString() {
        Object[] arr = new Object[3];
        return String.format("FieldIndex{collectionGroup='%s', segments=%s, version=%s}", this.collectionGroup, this.segments, this.version);
    }

    public com.google.firebase.firestore.model.FieldIndex withAddedField(com.google.firebase.firestore.model.FieldPath fieldPath, com.google.firebase.firestore.model.FieldIndex.Segment.Kind fieldIndex$Segment$Kind2) {
        ArrayList arrayList = new ArrayList(this.segments);
        AutoValue_FieldIndex_Segment autoValue_FieldIndex_Segment = new AutoValue_FieldIndex_Segment(fieldPath, kind2);
        arrayList.add(autoValue_FieldIndex_Segment);
        FieldIndex obj4 = new FieldIndex(this.collectionGroup, this.indexId, arrayList, this.version);
        return obj4;
    }

    public com.google.firebase.firestore.model.FieldIndex withVersion(com.google.firebase.firestore.model.SnapshotVersion snapshotVersion) {
        FieldIndex fieldIndex = new FieldIndex(this.collectionGroup, this.indexId, this.segments, snapshotVersion);
        return fieldIndex;
    }
}
