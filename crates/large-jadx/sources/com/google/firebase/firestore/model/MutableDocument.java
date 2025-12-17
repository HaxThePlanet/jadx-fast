package com.google.firebase.firestore.model;

import f.c.e.c.x;

/* loaded from: classes2.dex */
public final class MutableDocument implements com.google.firebase.firestore.model.Document, java.lang.Cloneable {

    private com.google.firebase.firestore.model.MutableDocument.DocumentState documentState;
    private com.google.firebase.firestore.model.MutableDocument.DocumentType documentType;
    private final com.google.firebase.firestore.model.DocumentKey key;
    private com.google.firebase.firestore.model.ObjectValue value;
    private com.google.firebase.firestore.model.SnapshotVersion version;

    private static enum DocumentState {

        HAS_LOCAL_MUTATIONS,
        HAS_COMMITTED_MUTATIONS,
        SYNCED;
    }

    private static enum DocumentType {

        INVALID,
        FOUND_DOCUMENT,
        NO_DOCUMENT,
        UNKNOWN_DOCUMENT;
    }
    private MutableDocument(com.google.firebase.firestore.model.DocumentKey documentKey) {
        super();
        this.key = documentKey;
    }

    private MutableDocument(com.google.firebase.firestore.model.DocumentKey documentKey, com.google.firebase.firestore.model.MutableDocument.DocumentType mutableDocument$DocumentType2, com.google.firebase.firestore.model.SnapshotVersion snapshotVersion3, com.google.firebase.firestore.model.ObjectValue objectValue4, com.google.firebase.firestore.model.MutableDocument.DocumentState mutableDocument$DocumentState5) {
        super();
        this.key = documentKey;
        this.version = snapshotVersion3;
        this.documentType = documentType2;
        this.documentState = documentState5;
        this.value = objectValue4;
    }

    public static com.google.firebase.firestore.model.MutableDocument newFoundDocument(com.google.firebase.firestore.model.DocumentKey documentKey, com.google.firebase.firestore.model.SnapshotVersion snapshotVersion2, com.google.firebase.firestore.model.ObjectValue objectValue3) {
        MutableDocument mutableDocument = new MutableDocument(documentKey);
        return mutableDocument.convertToFoundDocument(snapshotVersion2, objectValue3);
    }

    public static com.google.firebase.firestore.model.MutableDocument newInvalidDocument(com.google.firebase.firestore.model.DocumentKey documentKey) {
        ObjectValue objectValue = new ObjectValue();
        super(documentKey, MutableDocument.DocumentType.INVALID, SnapshotVersion.NONE, objectValue, MutableDocument.DocumentState.SYNCED);
        return mutableDocument2;
    }

    public static com.google.firebase.firestore.model.MutableDocument newNoDocument(com.google.firebase.firestore.model.DocumentKey documentKey, com.google.firebase.firestore.model.SnapshotVersion snapshotVersion2) {
        MutableDocument mutableDocument = new MutableDocument(documentKey);
        return mutableDocument.convertToNoDocument(snapshotVersion2);
    }

    public static com.google.firebase.firestore.model.MutableDocument newUnknownDocument(com.google.firebase.firestore.model.DocumentKey documentKey, com.google.firebase.firestore.model.SnapshotVersion snapshotVersion2) {
        MutableDocument mutableDocument = new MutableDocument(documentKey);
        return mutableDocument.convertToUnknownDocument(snapshotVersion2);
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.MutableDocument clone() {
        super(this.key, this.documentType, this.version, this.value.clone(), this.documentState);
        return mutableDocument2;
    }

    @Override // com.google.firebase.firestore.model.Document
    public Object clone() {
        return clone();
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.MutableDocument convertToFoundDocument(com.google.firebase.firestore.model.SnapshotVersion snapshotVersion, com.google.firebase.firestore.model.ObjectValue objectValue2) {
        this.version = snapshotVersion;
        this.documentType = MutableDocument.DocumentType.FOUND_DOCUMENT;
        this.value = objectValue2;
        this.documentState = MutableDocument.DocumentState.SYNCED;
        return this;
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.MutableDocument convertToNoDocument(com.google.firebase.firestore.model.SnapshotVersion snapshotVersion) {
        this.version = snapshotVersion;
        this.documentType = MutableDocument.DocumentType.NO_DOCUMENT;
        ObjectValue obj1 = new ObjectValue();
        this.value = obj1;
        this.documentState = MutableDocument.DocumentState.SYNCED;
        return this;
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.MutableDocument convertToUnknownDocument(com.google.firebase.firestore.model.SnapshotVersion snapshotVersion) {
        this.version = snapshotVersion;
        this.documentType = MutableDocument.DocumentType.UNKNOWN_DOCUMENT;
        ObjectValue obj1 = new ObjectValue();
        this.value = obj1;
        this.documentState = MutableDocument.DocumentState.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.MutableDocument> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (MutableDocument.class != object.getClass()) {
            } else {
                if (!this.key.equals(object.key)) {
                    return i;
                }
                if (!this.version.equals(object.version)) {
                    return i;
                }
                if (!this.documentType.equals(object.documentType)) {
                    return i;
                }
                if (!this.documentState.equals(object.documentState)) {
                    return i;
                }
            }
            return this.value.equals(object.value);
        }
        return i;
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.ObjectValue getData() {
        return this.value;
    }

    @Override // com.google.firebase.firestore.model.Document
    public x getField(com.google.firebase.firestore.model.FieldPath fieldPath) {
        return getData().get(fieldPath);
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.DocumentKey getKey() {
        return this.key;
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.SnapshotVersion getVersion() {
        return this.version;
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean hasCommittedMutations() {
        return this.documentState.equals(MutableDocument.DocumentState.HAS_COMMITTED_MUTATIONS);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean hasLocalMutations() {
        return this.documentState.equals(MutableDocument.DocumentState.HAS_LOCAL_MUTATIONS);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean hasPendingWrites() {
        int i;
        boolean committedMutations;
        if (!hasLocalMutations()) {
            if (hasCommittedMutations()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.firestore.model.Document
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isFoundDocument() {
        return this.documentType.equals(MutableDocument.DocumentType.FOUND_DOCUMENT);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isNoDocument() {
        return this.documentType.equals(MutableDocument.DocumentType.NO_DOCUMENT);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isUnknownDocument() {
        return this.documentType.equals(MutableDocument.DocumentType.UNKNOWN_DOCUMENT);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isValidDocument() {
        return equals ^= 1;
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.MutableDocument setHasCommittedMutations() {
        this.documentState = MutableDocument.DocumentState.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    @Override // com.google.firebase.firestore.model.Document
    public com.google.firebase.firestore.model.MutableDocument setHasLocalMutations() {
        this.documentState = MutableDocument.DocumentState.HAS_LOCAL_MUTATIONS;
        return this;
    }

    @Override // com.google.firebase.firestore.model.Document
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Document{key=");
        stringBuilder.append(this.key);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", type=");
        stringBuilder.append(this.documentType);
        stringBuilder.append(", documentState=");
        stringBuilder.append(this.documentState);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
