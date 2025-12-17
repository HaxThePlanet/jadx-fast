package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class z<MessageType extends com.google.protobuf.z<MessageType, BuilderType>, BuilderType extends com.google.protobuf.z.a<MessageType, BuilderType>>  extends com.google.protobuf.a<MessageType, BuilderType> {

    private static Map<Object, com.google.protobuf.z<?, ?>> defaultInstanceMap;
    protected int memoizedSerializedSize = -1;
    protected com.google.protobuf.t1 unknownFields;

    public static enum f {

        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER;
    }

    static final class d implements com.google.protobuf.v.b<com.google.protobuf.z.d> {

        final com.google.protobuf.c0.d<?> a;
        final int b;
        final com.google.protobuf.y1.b c;
        final boolean v;
        final boolean w;
        d(com.google.protobuf.c0.d<?> c0$d, int i2, com.google.protobuf.y1.b y1$b3, boolean z4, boolean z5) {
            super();
            this.a = d;
            this.b = i2;
            this.c = b3;
            this.v = z4;
            this.w = z5;
        }

        @Override // com.google.protobuf.v$b
        public int a(com.google.protobuf.z.d z$d) {
            return i -= obj2;
        }

        @Override // com.google.protobuf.v$b
        public boolean b() {
            return this.v;
        }

        public com.google.protobuf.c0.d<?> c() {
            return this.a;
        }

        @Override // com.google.protobuf.v$b
        public int compareTo(Object object) {
            return a((z.d)object);
        }

        @Override // com.google.protobuf.v$b
        public com.google.protobuf.y1.b d() {
            return this.c;
        }

        @Override // com.google.protobuf.v$b
        public com.google.protobuf.y1.c g() {
            return this.c.getJavaType();
        }

        @Override // com.google.protobuf.v$b
        public int getNumber() {
            return this.b;
        }

        @Override // com.google.protobuf.v$b
        public boolean isPacked() {
            return this.w;
        }

        @Override // com.google.protobuf.v$b
        public com.google.protobuf.t0.a l(com.google.protobuf.t0.a t0$a, com.google.protobuf.t0 t02) {
            return (z.a)a.mergeFrom((z)t02);
        }
    }

    public static class e extends com.google.protobuf.o<ContainingType, Type> {

        final ContainingType a;
        final Type b;
        final com.google.protobuf.t0 c;
        final com.google.protobuf.z.d d;
        e(ContainingType containingtype, Type type2, com.google.protobuf.t0 t03, com.google.protobuf.z.d z$d4, Class class5) {
            super();
            if (containingtype == null) {
            } else {
                if (d4.d() == y1.b.MESSAGE) {
                    if (t03 == null) {
                    } else {
                    }
                    IllegalArgumentException obj2 = new IllegalArgumentException("Null messageDefaultInstance");
                    throw obj2;
                }
                this.a = containingtype;
                this.b = type2;
                this.c = t03;
                this.d = d4;
            }
            obj2 = new IllegalArgumentException("Null containingTypeDefaultInstance");
            throw obj2;
        }

        @Override // com.google.protobuf.o
        public com.google.protobuf.y1.b b() {
            return this.d.d();
        }

        @Override // com.google.protobuf.o
        public com.google.protobuf.t0 c() {
            return this.c;
        }

        @Override // com.google.protobuf.o
        public int d() {
            return this.d.getNumber();
        }

        @Override // com.google.protobuf.o
        public boolean e() {
            return dVar.v;
        }
    }

    protected static class b extends com.google.protobuf.b<T> {

        private final T b;
        public b(T t) {
            super();
            this.b = t;
        }

        @Override // com.google.protobuf.b
        public Object d(com.google.protobuf.k k, com.google.protobuf.q q2) {
            return m(k, q2);
        }

        public T m(com.google.protobuf.k k, com.google.protobuf.q q2) {
            return z.parsePartialFrom(this.b, k, q2);
        }
    }

    public static abstract class a extends com.google.protobuf.a.a<MessageType, BuilderType> {

        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;
        protected a(MessageType messagetype) {
            super();
            this.defaultInstance = messagetype;
            this.instance = (z)messagetype.dynamicMethod(z.f.NEW_MUTABLE_INSTANCE);
            int obj2 = 0;
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            g1.a().e(messagetype).a(messagetype, messagetype2);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0 build() {
            return build();
        }

        public final MessageType build() {
            com.google.protobuf.z partial = buildPartial();
            if (!partial.isInitialized()) {
            } else {
                return partial;
            }
            throw a.a.newUninitializedMessageException(partial);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0 buildPartial() {
            return buildPartial();
        }

        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0.a clear() {
            return clear();
        }

        public final BuilderType clear() {
            this.instance = (z)this.instance.dynamicMethod(z.f.NEW_MUTABLE_INSTANCE);
            return this;
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.a.a clone() {
            return clone();
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0.a clone() {
            return clone();
        }

        public BuilderType clone() {
            com.google.protobuf.z.a builderForType = getDefaultInstanceForType().newBuilderForType();
            builderForType.mergeFrom(buildPartial());
            return builderForType;
        }

        @Override // com.google.protobuf.a$a
        public Object clone() {
            return clone();
        }

        @Override // com.google.protobuf.a$a
        protected final void copyOnWrite() {
            boolean isBuilt;
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        @Override // com.google.protobuf.a$a
        protected void copyOnWriteInternal() {
            Object dynamicMethod = this.instance.dynamicMethod(z.f.NEW_MUTABLE_INSTANCE);
            mergeFromInstance((z)dynamicMethod, this.instance);
            this.instance = dynamicMethod;
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0 getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.google.protobuf.a$a
        protected com.google.protobuf.a.a internalMergeFrom(com.google.protobuf.a a) {
            return internalMergeFrom((z)a);
        }

        protected BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        @Override // com.google.protobuf.a$a
        public final boolean isInitialized() {
            return z.isInitialized(this.instance, false);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.a.a mergeFrom(com.google.protobuf.k k, com.google.protobuf.q q2) {
            return mergeFrom(k, q2);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.a.a mergeFrom(byte[] bArr, int i2, int i3) {
            return mergeFrom(bArr, i2, i3);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.a.a mergeFrom(byte[] bArr, int i2, int i3, com.google.protobuf.q q4) {
            return mergeFrom(bArr, i2, i3, q4);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0.a mergeFrom(com.google.protobuf.k k, com.google.protobuf.q q2) {
            return mergeFrom(k, q2);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0.a mergeFrom(byte[] bArr, int i2, int i3) {
            return mergeFrom(bArr, i2, i3);
        }

        @Override // com.google.protobuf.a$a
        public com.google.protobuf.t0.a mergeFrom(byte[] bArr, int i2, int i3, com.google.protobuf.q q4) {
            return mergeFrom(bArr, i2, i3, q4);
        }

        public BuilderType mergeFrom(com.google.protobuf.k k, com.google.protobuf.q q2) {
            copyOnWrite();
            g1.a().e(this.instance).e(this.instance, l.P(k), q2);
            return this;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr, int i2, int i3) {
            return mergeFrom(bArr, i2, i3, q.b());
        }

        public BuilderType mergeFrom(byte[] bArr, int i2, int i3, com.google.protobuf.q q4) {
            copyOnWrite();
            f.b bVar = new f.b(q4);
            g1.a().e(this.instance).f(this.instance, bArr, i2, i2 + i3, bVar);
            return this;
        }
    }

    public static abstract class c extends com.google.protobuf.z<MessageType, BuilderType> implements com.google.protobuf.u0 {

        protected com.google.protobuf.v<com.google.protobuf.z.d> extensions;
        public c() {
            super();
            this.extensions = v.h();
        }

        com.google.protobuf.v<com.google.protobuf.z.d> b() {
            boolean z;
            if (this.extensions.o()) {
                this.extensions = this.extensions.b();
            }
            return this.extensions;
        }

        @Override // com.google.protobuf.z
        public com.google.protobuf.t0 getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.z
        public com.google.protobuf.t0.a newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.z
        public com.google.protobuf.t0.a toBuilder() {
            return super.toBuilder();
        }
    }
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        z.defaultInstanceMap = concurrentHashMap;
    }

    public z() {
        super();
        this.unknownFields = t1.c();
        int i = -1;
    }

    static com.google.protobuf.z.e access$000(com.google.protobuf.o o) {
        return z.checkIsLite(o);
    }

    private static <MessageType extends com.google.protobuf.z.c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>, T> com.google.protobuf.z.e<MessageType, T> checkIsLite(com.google.protobuf.o<MessageType, T> o) {
        if (!o.a()) {
        } else {
            return (z.e)o;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Expected a lite extension.");
        throw obj1;
    }

    private static <T extends com.google.protobuf.z<T, ?>> T checkMessageInitialized(T t) {
        boolean initialized;
        if (t != null) {
            if (!t.isInitialized()) {
            } else {
            }
            com.google.protobuf.InvalidProtocolBufferException exc = t.newUninitializedMessageException().a();
            exc.k(t);
            throw exc;
        }
        return t;
    }

    protected static com.google.protobuf.c0.a emptyBooleanList() {
        return h.l();
    }

    protected static com.google.protobuf.c0.b emptyDoubleList() {
        return n.l();
    }

    protected static com.google.protobuf.c0.f emptyFloatList() {
        return x.l();
    }

    protected static com.google.protobuf.c0.g emptyIntList() {
        return b0.i();
    }

    protected static com.google.protobuf.c0.i emptyLongList() {
        return k0.l();
    }

    protected static <E> com.google.protobuf.c0.j<E> emptyProtobufList() {
        return h1.g();
    }

    private final void ensureUnknownFieldsInitialized() {
        com.google.protobuf.t1 unknownFields;
        if (this.unknownFields == t1.c()) {
            this.unknownFields = t1.n();
        }
    }

    static <T extends com.google.protobuf.z<?, ?>> T getDefaultInstance(Class<T> class) {
        Object defaultInstanceForType;
        String defaultInstanceMap;
        java.lang.ClassLoader classLoader;
        if ((z)z.defaultInstanceMap.get(class) == null) {
            Class.forName(class.getName(), true, class.getClassLoader());
            defaultInstanceForType = z.defaultInstanceMap.get(class);
        }
        if (defaultInstanceForType == null) {
            defaultInstanceForType = (z)w1.l(class).getDefaultInstanceForType();
            if (defaultInstanceForType == null) {
            } else {
                z.defaultInstanceMap.put(class, defaultInstanceForType);
            }
            IllegalStateException obj3 = new IllegalStateException();
            throw obj3;
        }
        return defaultInstanceForType;
    }

    static Method getMethodOrDie(Class class, String string2, Class... class3Arr3) {
        try {
            return class.getMethod(string2, class3Arr3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Generated message class \"");
            class = class.getName();
            stringBuilder.append(class);
            class = "\" missing method \"";
            stringBuilder.append(class);
            stringBuilder.append(string2);
            class = "\".";
            stringBuilder.append(class);
            class = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(class, class3Arr3);
            throw runtimeException;
        }
    }

    static Object invokeOrDie(Method method, Object object2, Object... object3Arr3) {
        try {
            return method.invoke(object2, object3Arr3);
            method = method.getCause();
            object2 = method instanceof RuntimeException;
            object2 = method instanceof Error;
            if (object2 != null) {
            }
            throw (Error)method;
        }
        throw (RuntimeException)method;
    }

    protected static final <T extends com.google.protobuf.z<T, ?>> boolean isInitialized(T t, boolean z2) {
        int i;
        com.google.protobuf.z.f obj3;
        byte byteValue = (Byte)t.dynamicMethod(z.f.GET_MEMOIZED_IS_INITIALIZED).byteValue();
        i = 1;
        if (byteValue == i) {
            return i;
        }
        if (byteValue == 0) {
            return 0;
        }
        boolean z = g1.a().e(t).d(t);
        if (z2 != null) {
            i = z ? t : 0;
            t.dynamicMethod(z.f.SET_MEMOIZED_IS_INITIALIZED, i);
        }
        return z;
    }

    protected static com.google.protobuf.c0.a mutableCopy(com.google.protobuf.c0.a c0$a) {
        int i;
        int size = a.size();
        i = size == 0 ? 10 : size * 2;
        return a.c(i);
    }

    protected static com.google.protobuf.c0.b mutableCopy(com.google.protobuf.c0.b c0$b) {
        int i;
        int size = b.size();
        i = size == 0 ? 10 : size * 2;
        return b.c(i);
    }

    protected static com.google.protobuf.c0.f mutableCopy(com.google.protobuf.c0.f c0$f) {
        int i;
        int size = f.size();
        i = size == 0 ? 10 : size * 2;
        return f.c(i);
    }

    protected static com.google.protobuf.c0.g mutableCopy(com.google.protobuf.c0.g c0$g) {
        int i;
        int size = g.size();
        i = size == 0 ? 10 : size * 2;
        return g.c(i);
    }

    protected static com.google.protobuf.c0.i mutableCopy(com.google.protobuf.c0.i c0$i) {
        int i2;
        int size = i.size();
        i2 = size == 0 ? 10 : size * 2;
        return i.c(i2);
    }

    protected static <E> com.google.protobuf.c0.j<E> mutableCopy(com.google.protobuf.c0.j<E> c0$j) {
        int i;
        int size = j.size();
        i = size == 0 ? 10 : size * 2;
        return j.c(i);
    }

    protected static Object newMessageInfo(com.google.protobuf.t0 t0, String string2, Object[] object3Arr3) {
        i1 i1Var = new i1(t0, string2, object3Arr3);
        return i1Var;
    }

    public static <ContainingType extends com.google.protobuf.t0, Type> com.google.protobuf.z.e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, com.google.protobuf.t0 t02, com.google.protobuf.c0.d<?> c0$d3, int i4, com.google.protobuf.y1.b y1$b5, boolean z6, Class class7) {
        super(d3, i4, b5, 1, z6);
        super(containingtype, Collections.emptyList(), t02, dVar, class7);
        return eVar2;
    }

    public static <ContainingType extends com.google.protobuf.t0, Type> com.google.protobuf.z.e<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type2, com.google.protobuf.t0 t03, com.google.protobuf.c0.d<?> c0$d4, int i5, com.google.protobuf.y1.b y1$b6, Class class7) {
        super(d4, i5, b6, 0, 0);
        super(containingtype, type2, t03, dVar4, class7);
        return eVar2;
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream2) {
        return z.checkMessageInitialized(z.parsePartialDelimitedFrom(t, inputStream2, q.b()));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream2, com.google.protobuf.q q3) {
        return z.checkMessageInitialized(z.parsePartialDelimitedFrom(t, inputStream2, q3));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, com.google.protobuf.j j2) {
        return z.checkMessageInitialized(z.parseFrom(t, j2, q.b()));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, com.google.protobuf.j j2, com.google.protobuf.q q3) {
        return z.checkMessageInitialized(z.parsePartialFrom(t, j2, q3));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, com.google.protobuf.k k2) {
        return z.parseFrom(t, k2, q.b());
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, com.google.protobuf.k k2, com.google.protobuf.q q3) {
        return z.checkMessageInitialized(z.parsePartialFrom(t, k2, q3));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, InputStream inputStream2) {
        return z.checkMessageInitialized(z.parsePartialFrom(t, k.f(inputStream2), q.b()));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, InputStream inputStream2, com.google.protobuf.q q3) {
        return z.checkMessageInitialized(z.parsePartialFrom(t, k.f(inputStream2), q3));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer2) {
        return z.parseFrom(t, byteBuffer2, q.b());
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer2, com.google.protobuf.q q3) {
        return z.checkMessageInitialized(z.parseFrom(t, k.i(byteBuffer2), q3));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, byte[] b2Arr2) {
        return z.checkMessageInitialized(z.parsePartialFrom(t, b2Arr2, 0, b2Arr2.length, q.b()));
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parseFrom(T t, byte[] b2Arr2, com.google.protobuf.q q3) {
        return z.checkMessageInitialized(z.parsePartialFrom(t, b2Arr2, 0, b2Arr2.length, q3));
    }

    private static <T extends com.google.protobuf.z<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream2, com.google.protobuf.q q3) {
        try {
            int read = inputStream2.read();
            if (read == -1) {
            }
            return 0;
            a.a.a aVar = new a.a.a(inputStream2, k.y(read, inputStream2));
            final com.google.protobuf.k obj3 = k.f(aVar);
            obj3.a(0);
            return z.parsePartialFrom(t, obj3, q3);
            inputStream2.k(t);
            throw inputStream2;
            inputStream2 = new InvalidProtocolBufferException(t);
            throw inputStream2;
            inputStream2 = t.a();
            if (inputStream2 == null) {
            } else {
            }
            inputStream2 = new InvalidProtocolBufferException(t);
            t = inputStream2;
            throw t;
        } catch (com.google.protobuf.InvalidProtocolBufferException invalidProtocolBuffer) {
        }
    }

    private static <T extends com.google.protobuf.z<T, ?>> T parsePartialFrom(T t, com.google.protobuf.j j2, com.google.protobuf.q q3) {
        try {
            final com.google.protobuf.k obj1 = j2.E();
            obj1.a(0);
            return z.parsePartialFrom(t, obj1, q3);
            j2.k(t);
            throw j2;
            throw t;
        } catch (com.google.protobuf.InvalidProtocolBufferException invalidProtocolBuffer) {
        }
    }

    protected static <T extends com.google.protobuf.z<T, ?>> T parsePartialFrom(T t, com.google.protobuf.k k2) {
        return z.parsePartialFrom(t, k2, q.b());
    }

    static <T extends com.google.protobuf.z<T, ?>> T parsePartialFrom(T t, com.google.protobuf.k k2, com.google.protobuf.q q3) {
        final Object obj1 = t.dynamicMethod(z.f.NEW_MUTABLE_INSTANCE);
        com.google.protobuf.l1 l1Var = g1.a().e((z)obj1);
        l1Var.e(obj1, l.P(k2), q3);
        l1Var.c(obj1);
        return obj1;
    }

    static <T extends com.google.protobuf.z<T, ?>> T parsePartialFrom(T t, byte[] b2Arr2, int i3, int i4, com.google.protobuf.q q5) {
        final Object obj7 = t.dynamicMethod(z.f.NEW_MUTABLE_INSTANCE);
        final com.google.protobuf.l1 l1Var2 = g1.a().e((z)obj7);
        f.b bVar = new f.b(q5);
        l1Var2.f(obj7, b2Arr2, i3, i3 + i4, bVar);
        l1Var2.c(obj7);
        if (obj7.memoizedHashCode != 0) {
        } else {
            return obj7;
        }
        RuntimeException obj8 = new RuntimeException();
        throw obj8;
    }

    private static <T extends com.google.protobuf.z<T, ?>> T parsePartialFrom(T t, byte[] b2Arr2, com.google.protobuf.q q3) {
        return z.checkMessageInitialized(z.parsePartialFrom(t, b2Arr2, 0, b2Arr2.length, q3));
    }

    protected static <T extends com.google.protobuf.z<?, ?>> void registerDefaultInstance(Class<T> class, T t2) {
        z.defaultInstanceMap.put(class, t2);
    }

    @Override // com.google.protobuf.a
    Object buildMessageInfo() {
        return dynamicMethod(z.f.BUILD_MESSAGE_INFO);
    }

    protected final <MessageType extends com.google.protobuf.z<MessageType, BuilderType>, BuilderType extends com.google.protobuf.z.a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (z.a)dynamicMethod(z.f.NEW_BUILDER);
    }

    protected final <MessageType extends com.google.protobuf.z<MessageType, BuilderType>, BuilderType extends com.google.protobuf.z.a<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return createBuilder().mergeFrom(messagetype);
    }

    @Override // com.google.protobuf.a
    protected Object dynamicMethod(com.google.protobuf.z.f z$f) {
        final int i = 0;
        return dynamicMethod(f, i, i);
    }

    @Override // com.google.protobuf.a
    protected Object dynamicMethod(com.google.protobuf.z.f z$f, Object object2) {
        return dynamicMethod(f, object2, 0);
    }

    @Override // com.google.protobuf.a
    protected abstract Object dynamicMethod(com.google.protobuf.z.f z$f, Object object2, Object object3);

    @Override // com.google.protobuf.a
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object == null) {
            return i;
        }
        if (getClass() != object.getClass()) {
            return i;
        }
        return g1.a().e(this).g(this, (z)object);
    }

    @Override // com.google.protobuf.a
    public com.google.protobuf.t0 getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public final MessageType getDefaultInstanceForType() {
        return (z)dynamicMethod(z.f.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.a
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    public final com.google.protobuf.d1<MessageType> getParserForType() {
        return (d1)dynamicMethod(z.f.GET_PARSER);
    }

    @Override // com.google.protobuf.a
    public int getSerializedSize() {
        int memoizedSerializedSize;
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = g1.a().e(this).h(this);
        }
        return this.memoizedSerializedSize;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int memoizedHashCode = this.memoizedHashCode;
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int i = g1.a().e(this).j(this);
        this.memoizedHashCode = i;
        return i;
    }

    @Override // com.google.protobuf.a
    public final boolean isInitialized() {
        return z.isInitialized(this, true);
    }

    @Override // com.google.protobuf.a
    protected void makeImmutable() {
        g1.a().e(this).c(this);
    }

    @Override // com.google.protobuf.a
    protected void mergeLengthDelimitedField(int i, com.google.protobuf.j j2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.k(i, j2);
    }

    @Override // com.google.protobuf.a
    protected final void mergeUnknownFields(com.google.protobuf.t1 t1) {
        this.unknownFields = t1.m(this.unknownFields, t1);
    }

    @Override // com.google.protobuf.a
    protected void mergeVarintField(int i, int i2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.l(i, i2);
    }

    @Override // com.google.protobuf.a
    public com.google.protobuf.t0.a newBuilderForType() {
        return newBuilderForType();
    }

    public final BuilderType newBuilderForType() {
        return (z.a)dynamicMethod(z.f.NEW_BUILDER);
    }

    @Override // com.google.protobuf.a
    protected boolean parseUnknownField(int i, com.google.protobuf.k k2) {
        if (y1.b(i) == 4) {
            return 0;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.i(i, k2);
    }

    @Override // com.google.protobuf.a
    void setMemoizedSerializedSize(int i) {
        this.memoizedSerializedSize = i;
    }

    @Override // com.google.protobuf.a
    public com.google.protobuf.t0.a toBuilder() {
        return toBuilder();
    }

    public final BuilderType toBuilder() {
        Object dynamicMethod = dynamicMethod(z.f.NEW_BUILDER);
        (z.a)dynamicMethod.mergeFrom(this);
        return dynamicMethod;
    }

    @Override // com.google.protobuf.a
    public String toString() {
        return v0.e(this, super.toString());
    }

    @Override // com.google.protobuf.a
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) {
        g1.a().e(this).b(this, m.P(codedOutputStream));
    }
}
