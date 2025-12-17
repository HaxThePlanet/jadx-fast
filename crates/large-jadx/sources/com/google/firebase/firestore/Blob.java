package com.google.firebase.firestore;

import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.j;

/* loaded from: classes2.dex */
public class Blob implements Comparable<com.google.firebase.firestore.Blob> {

    private final j bytes;
    private Blob(j j) {
        super();
        this.bytes = j;
    }

    public static com.google.firebase.firestore.Blob fromByteString(j j) {
        Preconditions.checkNotNull(j, "Provided ByteString must not be null.");
        Blob blob = new Blob(j);
        return blob;
    }

    public static com.google.firebase.firestore.Blob fromBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Provided bytes array must not be null.");
        Blob blob = new Blob(j.s(bArr));
        return blob;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.firestore.Blob blob) {
        return Util.compareByteStrings(this.bytes, blob.bytes);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((Blob)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        boolean bytes;
        Object obj2;
        if (object instanceof Blob && this.bytes.equals(object.bytes)) {
            obj2 = this.bytes.equals(object.bytes) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return this.bytes.hashCode();
    }

    @Override // java.lang.Comparable
    public j toByteString() {
        return this.bytes;
    }

    @Override // java.lang.Comparable
    public byte[] toBytes() {
        return this.bytes.O();
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Blob { bytes=");
        stringBuilder.append(Util.toDebugString(this.bytes));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
