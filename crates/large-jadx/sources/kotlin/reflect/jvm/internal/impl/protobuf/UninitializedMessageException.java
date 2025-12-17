package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {

    private final List<String> missingFields = null;
    public UninitializedMessageException(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        int obj1 = 0;
    }

    @Override // java.lang.RuntimeException
    public kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException a() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(getMessage());
        return invalidProtocolBufferException;
    }
}
