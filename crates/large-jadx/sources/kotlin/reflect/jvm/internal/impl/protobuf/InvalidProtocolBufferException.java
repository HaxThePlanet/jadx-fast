package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public class InvalidProtocolBufferException extends IOException {

    private kotlin.reflect.jvm.internal.impl.protobuf.o unfinishedMessage = null;
    public InvalidProtocolBufferException(String string) {
        super(string);
        final int obj1 = 0;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException b() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException c() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException d() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException e() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException f() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException g() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException h() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException j() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        return invalidProtocolBufferException;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException k() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        return invalidProtocolBufferException;
    }

    @Override // java.io.IOException
    public kotlin.reflect.jvm.internal.impl.protobuf.o a() {
        return this.unfinishedMessage;
    }

    @Override // java.io.IOException
    public kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException i(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        this.unfinishedMessage = o;
        return this;
    }
}
