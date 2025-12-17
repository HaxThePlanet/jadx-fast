package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class b<MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.o>  implements kotlin.reflect.jvm.internal.impl.protobuf.q<MessageType> {
    static {
        f.c();
    }

    private MessageType e(MessageType messagetype) {
        boolean initialized;
        if (messagetype != null) {
            if (!messagetype.isInitialized()) {
            } else {
            }
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException exc2 = f(messagetype).a();
            exc2.i(messagetype);
            throw exc2;
        }
        return messagetype;
    }

    private kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException f(MessageType messagetype) {
        if (messagetype instanceof a) {
            return (a)messagetype.b();
        }
        UninitializedMessageException uninitializedMessageException = new UninitializedMessageException(messagetype);
        return uninitializedMessageException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public Object a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        return h(inputStream, f2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public Object c(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        return g(inputStream, f2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public Object d(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        return i(d, f2);
    }

    public MessageType g(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        final kotlin.reflect.jvm.internal.impl.protobuf.o obj1 = j(inputStream, f2);
        e(obj1);
        return obj1;
    }

    public MessageType h(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        final kotlin.reflect.jvm.internal.impl.protobuf.o obj1 = k(inputStream, f2);
        e(obj1);
        return obj1;
    }

    public MessageType i(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        final kotlin.reflect.jvm.internal.impl.protobuf.o obj1 = l(d, f2);
        e(obj1);
        return obj1;
    }

    public MessageType j(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        try {
            int read = inputStream.read();
            if (read == -1) {
            }
            return 0;
            a.a.a aVar = new a.a.a(inputStream, e.B(read, inputStream));
            return k(aVar, f2);
            inputStream = inputStream.getMessage();
            f2 = new InvalidProtocolBufferException(inputStream);
            throw f2;
        }
    }

    public MessageType k(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        final kotlin.reflect.jvm.internal.impl.protobuf.e obj2 = e.g(inputStream);
        obj2.a(0);
        return (o)b(obj2, f2);
    }

    public MessageType l(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        try {
            final kotlin.reflect.jvm.internal.impl.protobuf.e obj2 = d.v();
            obj2.a(0);
            return (o)b(obj2, f2);
            d.i(f2);
            throw d;
            throw d;
        } catch (kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException invalidProtocolBuffer) {
        }
    }
}
