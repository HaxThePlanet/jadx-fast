package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a<MessageType extends com.google.protobuf.a<MessageType, BuilderType>, BuilderType extends com.google.protobuf.a.a<MessageType, BuilderType>>  implements com.google.protobuf.t0 {

    protected int memoizedHashCode = 0;

    public static abstract class a implements com.google.protobuf.t0.a {
        @Deprecated
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection2) {
            a.a.addAll(iterable, (List)collection2);
        }

        protected static <T> void addAll(Iterable<T> iterable, List<? super T> list2) {
            boolean z;
            boolean next;
            int i;
            boolean z2;
            Object obj3;
            List obj4;
            c0.a(iterable);
            if (iterable instanceof i0) {
                z = list2;
                obj4 = list2.size();
                obj3 = (i0)iterable.k().iterator();
                while (obj3.hasNext()) {
                    next = obj3.next();
                    if (next == null) {
                        break;
                    } else {
                    }
                    if (next instanceof j) {
                    } else {
                    }
                    (i0)z.add((String)next);
                    z.T((j)next);
                }
            } else {
                if (iterable instanceof e1) {
                    list2.addAll((Collection)iterable);
                } else {
                    a.a.addAllCheckingNulls(iterable, list2);
                }
            }
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list2) {
            boolean z;
            int next;
            int i;
            int size;
            if (list2 instanceof ArrayList != null && iterable instanceof Collection != null) {
                if (iterable instanceof Collection != null) {
                    (ArrayList)list2.ensureCapacity(size5 += size);
                }
            }
            int size2 = list2.size();
            Iterator obj3 = iterable.iterator();
            while (obj3.hasNext()) {
                next = obj3.next();
                if (next == 0) {
                    break;
                } else {
                }
                list2.add(next);
            }
        }

        private String getReadingExceptionMessage(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reading ");
            stringBuilder.append(getClass().getName());
            stringBuilder.append(" from a ");
            stringBuilder.append(string);
            stringBuilder.append(" threw an IOException (should never happen).");
            return stringBuilder.toString();
        }

        protected static com.google.protobuf.UninitializedMessageException newUninitializedMessageException(com.google.protobuf.t0 t0) {
            UninitializedMessageException uninitializedMessageException = new UninitializedMessageException(t0);
            return uninitializedMessageException;
        }

        public abstract BuilderType clone();

        @Override // com.google.protobuf.t0$a
        public abstract com.google.protobuf.t0.a clone();

        @Override // com.google.protobuf.t0$a
        public abstract Object clone();

        protected abstract BuilderType internalMergeFrom(MessageType messagetype);

        @Override // com.google.protobuf.t0$a
        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, q.b());
        }

        @Override // com.google.protobuf.t0$a
        public boolean mergeDelimitedFrom(InputStream inputStream, com.google.protobuf.q q2) {
            int read = inputStream.read();
            if (read == -1) {
                return 0;
            }
            a.a.a aVar = new a.a.a(inputStream, k.y(read, inputStream));
            mergeFrom(aVar, q2);
            return 1;
        }

        public BuilderType mergeFrom(com.google.protobuf.j j) {
            try {
                final com.google.protobuf.k obj3 = j.E();
                mergeFrom(obj3);
                obj3.a(0);
                return this;
                String readingExceptionMessage = "ByteString";
                readingExceptionMessage = getReadingExceptionMessage(readingExceptionMessage);
                RuntimeException runtimeException = new RuntimeException(readingExceptionMessage, j);
                throw runtimeException;
                throw j;
            }
        }

        public BuilderType mergeFrom(com.google.protobuf.j j, com.google.protobuf.q q2) {
            try {
                final com.google.protobuf.k obj2 = j.E();
                mergeFrom(obj2, q2);
                obj2.a(0);
                return this;
                String readingExceptionMessage = "ByteString";
                readingExceptionMessage = getReadingExceptionMessage(readingExceptionMessage);
                q2 = new RuntimeException(readingExceptionMessage, j);
                throw q2;
                throw j;
            }
        }

        public BuilderType mergeFrom(com.google.protobuf.k k) {
            return mergeFrom(k, q.b());
        }

        public abstract BuilderType mergeFrom(com.google.protobuf.k k, com.google.protobuf.q q2);

        public BuilderType mergeFrom(com.google.protobuf.t0 t0) {
            if (!getDefaultInstanceForType().getClass().isInstance(t0)) {
            } else {
                return internalMergeFrom((a)t0);
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
            throw obj2;
        }

        public BuilderType mergeFrom(InputStream inputStream) {
            final com.google.protobuf.k obj2 = k.f(inputStream);
            mergeFrom(obj2);
            obj2.a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, com.google.protobuf.q q2) {
            final com.google.protobuf.k obj1 = k.f(inputStream);
            mergeFrom(obj1, q2);
            obj1.a(0);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr) {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public abstract BuilderType mergeFrom(byte[] bArr, int i2, int i3);

        public abstract BuilderType mergeFrom(byte[] bArr, int i2, int i3, com.google.protobuf.q q4);

        public BuilderType mergeFrom(byte[] bArr, com.google.protobuf.q q2) {
            return mergeFrom(bArr, 0, bArr.length, q2);
        }

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(com.google.protobuf.j j) {
            return mergeFrom(j);
        }

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(com.google.protobuf.j j, com.google.protobuf.q q2) {
            return mergeFrom(j, q2);
        }

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(com.google.protobuf.k k) {
            return mergeFrom(k);
        }

        @Override // com.google.protobuf.t0$a
        public abstract com.google.protobuf.t0.a mergeFrom(com.google.protobuf.k k, com.google.protobuf.q q2);

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(com.google.protobuf.t0 t0) {
            return mergeFrom(t0);
        }

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(InputStream inputStream) {
            return mergeFrom(inputStream);
        }

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(InputStream inputStream, com.google.protobuf.q q2) {
            return mergeFrom(inputStream, q2);
        }

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(byte[] bArr) {
            return mergeFrom(bArr);
        }

        @Override // com.google.protobuf.t0$a
        public abstract com.google.protobuf.t0.a mergeFrom(byte[] bArr, int i2, int i3);

        @Override // com.google.protobuf.t0$a
        public abstract com.google.protobuf.t0.a mergeFrom(byte[] bArr, int i2, int i3, com.google.protobuf.q q4);

        @Override // com.google.protobuf.t0$a
        public com.google.protobuf.t0.a mergeFrom(byte[] bArr, com.google.protobuf.q q2) {
            return mergeFrom(bArr, q2);
        }
    }
    public a() {
        super();
        final int i = 0;
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection2) {
        a.a.addAll(iterable, (List)collection2);
    }

    protected static <T> void addAll(Iterable<T> iterable, List<? super T> list2) {
        a.a.addAll(iterable, list2);
    }

    protected static void checkByteStringIsUtf8(com.google.protobuf.j j) {
        if (!j.B()) {
        } else {
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Byte string is not UTF-8.");
        throw obj1;
    }

    private String getSerializingExceptionMessage(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Serializing ");
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" to a ");
        stringBuilder.append(string);
        stringBuilder.append(" threw an IOException (should never happen).");
        return stringBuilder.toString();
    }

    @Override // com.google.protobuf.t0
    int getMemoizedSerializedSize() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // com.google.protobuf.t0
    int getSerializedSize(com.google.protobuf.l1 l1) {
        int memoizedSerializedSize;
        if (getMemoizedSerializedSize() == -1) {
            setMemoizedSerializedSize(l1.h(this));
        }
        return memoizedSerializedSize;
    }

    @Override // com.google.protobuf.t0
    com.google.protobuf.UninitializedMessageException newUninitializedMessageException() {
        UninitializedMessageException uninitializedMessageException = new UninitializedMessageException(this);
        return uninitializedMessageException;
    }

    @Override // com.google.protobuf.t0
    void setMemoizedSerializedSize(int i) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // com.google.protobuf.t0
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            final com.google.protobuf.CodedOutputStream outputStream = CodedOutputStream.h0(bArr);
            writeTo(outputStream);
            outputStream.d();
            return bArr;
            String serializingExceptionMessage = "byte array";
            serializingExceptionMessage = getSerializingExceptionMessage(serializingExceptionMessage);
            RuntimeException runtimeException = new RuntimeException(serializingExceptionMessage, th);
            throw runtimeException;
        }
    }

    @Override // com.google.protobuf.t0
    public com.google.protobuf.j toByteString() {
        try {
            com.google.protobuf.j.g gVar = j.D(getSerializedSize());
            writeTo(gVar.b());
            return gVar.a();
            String serializingExceptionMessage = "ByteString";
            serializingExceptionMessage = getSerializingExceptionMessage(serializingExceptionMessage);
            RuntimeException runtimeException = new RuntimeException(serializingExceptionMessage, th);
            throw runtimeException;
        }
    }

    @Override // com.google.protobuf.t0
    public void writeDelimitedTo(OutputStream outputStream) {
        final int serializedSize = getSerializedSize();
        final com.google.protobuf.CodedOutputStream obj3 = CodedOutputStream.g0(outputStream, CodedOutputStream.J(i += serializedSize));
        obj3.N0(serializedSize);
        writeTo(obj3);
        obj3.d0();
    }

    @Override // com.google.protobuf.t0
    public void writeTo(OutputStream outputStream) {
        final com.google.protobuf.CodedOutputStream obj2 = CodedOutputStream.g0(outputStream, CodedOutputStream.J(getSerializedSize()));
        writeTo(obj2);
        obj2.d0();
    }
}
