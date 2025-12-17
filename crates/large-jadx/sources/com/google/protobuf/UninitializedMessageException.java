package com.google.protobuf;

import java.util.List;

/* loaded from: classes2.dex */
public class UninitializedMessageException extends RuntimeException {

    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields = null;
    public UninitializedMessageException(com.google.protobuf.t0 t0) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        int obj1 = 0;
    }

    @Override // java.lang.RuntimeException
    public com.google.protobuf.InvalidProtocolBufferException a() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(getMessage());
        return invalidProtocolBufferException;
    }
}
