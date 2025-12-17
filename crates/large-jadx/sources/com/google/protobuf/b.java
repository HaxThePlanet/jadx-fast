package com.google.protobuf;

import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class b<MessageType extends com.google.protobuf.t0>  implements com.google.protobuf.d1<MessageType> {

    private static final com.google.protobuf.q a;
    static {
        b.a = q.b();
    }

    private MessageType e(MessageType messagetype) {
        boolean initialized;
        if (messagetype != null) {
            if (!messagetype.isInitialized()) {
            } else {
            }
            com.google.protobuf.InvalidProtocolBufferException exc2 = f(messagetype).a();
            exc2.k(messagetype);
            throw exc2;
        }
        return messagetype;
    }

    private com.google.protobuf.UninitializedMessageException f(MessageType messagetype) {
        if (messagetype instanceof a) {
            return (a)messagetype.newUninitializedMessageException();
        }
        UninitializedMessageException uninitializedMessageException = new UninitializedMessageException(messagetype);
        return uninitializedMessageException;
    }

    @Override // com.google.protobuf.d1
    public Object a(com.google.protobuf.j j, com.google.protobuf.q q2) {
        return g(j, q2);
    }

    @Override // com.google.protobuf.d1
    public Object b(InputStream inputStream) {
        return i(inputStream);
    }

    @Override // com.google.protobuf.d1
    public Object c(com.google.protobuf.k k, com.google.protobuf.q q2) {
        return h(k, q2);
    }

    public MessageType g(com.google.protobuf.j j, com.google.protobuf.q q2) {
        final com.google.protobuf.t0 obj1 = k(j, q2);
        e(obj1);
        return obj1;
    }

    public MessageType h(com.google.protobuf.k k, com.google.protobuf.q q2) {
        final Object obj1 = d(k, q2);
        e((t0)obj1);
        return obj1;
    }

    public MessageType i(InputStream inputStream) {
        return j(inputStream, b.a);
    }

    public MessageType j(InputStream inputStream, com.google.protobuf.q q2) {
        final com.google.protobuf.t0 obj1 = l(inputStream, q2);
        e(obj1);
        return obj1;
    }

    public MessageType k(com.google.protobuf.j j, com.google.protobuf.q q2) {
        try {
            final com.google.protobuf.k obj2 = j.E();
            obj2.a(0);
            return (t0)d(obj2, q2);
            j.k(q2);
            throw j;
            throw j;
        } catch (com.google.protobuf.InvalidProtocolBufferException invalidProtocolBuffer) {
        }
    }

    public MessageType l(InputStream inputStream, com.google.protobuf.q q2) {
        final com.google.protobuf.k obj2 = k.f(inputStream);
        obj2.a(0);
        return (t0)d(obj2, q2);
    }
}
