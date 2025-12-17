package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes2.dex */
public class InvalidProtocolBufferException extends IOException {

    private static final long serialVersionUID = -1616151763072450476L;
    private com.google.protobuf.t0 unfinishedMessage = null;
    private boolean wasThrownFromInputStream;

    public static class InvalidWireTypeException extends com.google.protobuf.InvalidProtocolBufferException {

        private static final long serialVersionUID = 3283890091615336259L;
        public InvalidWireTypeException(String string) {
            super(string);
        }
    }
    public InvalidProtocolBufferException(IOException iOException) {
        super(iOException.getMessage(), iOException);
        final int obj2 = 0;
    }

    public InvalidProtocolBufferException(String string) {
        super(string);
        final int obj1 = 0;
    }

    static com.google.protobuf.InvalidProtocolBufferException b() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException c() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException d() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException e() {
        InvalidProtocolBufferException.InvalidWireTypeException invalidWireTypeException = new InvalidProtocolBufferException.InvalidWireTypeException("Protocol message tag had invalid wire type.");
        return invalidWireTypeException;
    }

    static com.google.protobuf.InvalidProtocolBufferException f() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException g() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException h() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Failed to parse the message.");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException i() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException l() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        return invalidProtocolBufferException;
    }

    static com.google.protobuf.InvalidProtocolBufferException m() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return invalidProtocolBufferException;
    }

    @Override // java.io.IOException
    boolean a() {
        return this.wasThrownFromInputStream;
    }

    @Override // java.io.IOException
    void j() {
        this.wasThrownFromInputStream = true;
    }

    @Override // java.io.IOException
    public com.google.protobuf.InvalidProtocolBufferException k(com.google.protobuf.t0 t0) {
        this.unfinishedMessage = t0;
        return this;
    }
}
