package com.google.firebase.firestore.index;

import com.google.protobuf.j;

/* loaded from: classes2.dex */
public class IndexByteEncoder extends com.google.firebase.firestore.index.DirectionalIndexByteEncoder {

    private final com.google.firebase.firestore.index.OrderedCodeWriter orderedCode;
    public IndexByteEncoder() {
        super();
        OrderedCodeWriter orderedCodeWriter = new OrderedCodeWriter();
        this.orderedCode = orderedCodeWriter;
    }

    @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
    public byte[] getEncodedBytes() {
        return this.orderedCode.encodedBytes();
    }

    @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
    public void reset() {
        this.orderedCode.reset();
    }

    @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
    public void seed(byte[] bArr) {
        this.orderedCode.seed(bArr);
    }

    @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
    public void writeBytes(j j) {
        this.orderedCode.writeBytesAscending(j);
    }

    @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
    public void writeDouble(double d) {
        this.orderedCode.writeDoubleAscending(d);
    }

    @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
    public void writeLong(long l) {
        this.orderedCode.writeSignedLongAscending(l);
    }

    @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
    public void writeString(String string) {
        this.orderedCode.writeUtf8Ascending(string);
    }
}
