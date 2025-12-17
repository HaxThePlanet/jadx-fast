package kotlin.reflect.jvm.internal.impl.protobuf;

/* loaded from: classes3.dex */
public interface o extends kotlin.reflect.jvm.internal.impl.protobuf.p {

    public interface a extends java.lang.Cloneable, kotlin.reflect.jvm.internal.impl.protobuf.p {
        @Override // java.lang.Cloneable
        public abstract kotlin.reflect.jvm.internal.impl.protobuf.o build();

        @Override // java.lang.Cloneable
        public abstract kotlin.reflect.jvm.internal.impl.protobuf.o.a j0(kotlin.reflect.jvm.internal.impl.protobuf.e e, kotlin.reflect.jvm.internal.impl.protobuf.f f2);
    }
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public abstract void a(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream);

    public abstract kotlin.reflect.jvm.internal.impl.protobuf.q<? extends kotlin.reflect.jvm.internal.impl.protobuf.o> getParserForType();

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public abstract int getSerializedSize();

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public abstract kotlin.reflect.jvm.internal.impl.protobuf.o.a newBuilderForType();

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public abstract kotlin.reflect.jvm.internal.impl.protobuf.o.a toBuilder();
}
