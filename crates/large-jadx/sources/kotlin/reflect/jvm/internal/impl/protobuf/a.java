package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;

/* loaded from: classes3.dex */
public abstract class a implements kotlin.reflect.jvm.internal.impl.protobuf.o {

    protected int memoizedHashCode = 0;

    public static abstract class a implements kotlin.reflect.jvm.internal.impl.protobuf.o.a {
        protected static kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException c(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
            UninitializedMessageException uninitializedMessageException = new UninitializedMessageException(o);
            return uninitializedMessageException;
        }

        public abstract BuilderType b(kotlin.reflect.jvm.internal.impl.protobuf.e e, kotlin.reflect.jvm.internal.impl.protobuf.f f2);

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o$a
        public kotlin.reflect.jvm.internal.impl.protobuf.o.a j0(kotlin.reflect.jvm.internal.impl.protobuf.e e, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
            return b(e, f2);
        }
    }
    public a() {
        super();
        final int i = 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException b() {
        UninitializedMessageException uninitializedMessageException = new UninitializedMessageException(this);
        return uninitializedMessageException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void c(OutputStream outputStream) {
        final int serializedSize = getSerializedSize();
        final kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream obj3 = CodedOutputStream.J(outputStream, CodedOutputStream.u(i += serializedSize));
        obj3.o0(serializedSize);
        a(obj3);
        obj3.I();
    }
}
