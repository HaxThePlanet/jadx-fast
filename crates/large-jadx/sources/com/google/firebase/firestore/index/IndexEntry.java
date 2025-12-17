package com.google.firebase.firestore.index;

/* loaded from: classes2.dex */
public class IndexEntry {

    private final byte[] arrayValue;
    private final byte[] directionalValue;
    private final String documentName;
    private final int indexId;
    private final String uid;
    public IndexEntry(int i, byte[] b2Arr2, byte[] b3Arr3, String string4, String string5) {
        super();
        this.indexId = i;
        this.arrayValue = b2Arr2;
        this.directionalValue = b3Arr3;
        this.uid = string4;
        this.documentName = string5;
    }

    public byte[] getArrayValue() {
        return this.arrayValue;
    }

    public byte[] getDirectionalValue() {
        return this.directionalValue;
    }

    public String getDocumentName() {
        return this.documentName;
    }

    public int getIndexId() {
        return this.indexId;
    }

    public String getUid() {
        return this.uid;
    }
}
