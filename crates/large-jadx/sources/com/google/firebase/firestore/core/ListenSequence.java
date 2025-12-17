package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
public class ListenSequence {

    public static final long INVALID = -1L;
    private long previousSequenceNumber;
    public ListenSequence(long l) {
        super();
        this.previousSequenceNumber = l;
    }

    public long next() {
        previousSequenceNumber += i2;
        this.previousSequenceNumber = i;
        return i;
    }
}
