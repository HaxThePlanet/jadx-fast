package com.google.protobuf;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface t0 extends com.google.protobuf.u0 {

    public interface a extends com.google.protobuf.u0, java.lang.Cloneable {
        @Override // com.google.protobuf.u0
        public abstract com.google.protobuf.t0 build();

        @Override // com.google.protobuf.u0
        public abstract com.google.protobuf.t0 buildPartial();

        @Override // com.google.protobuf.u0
        public abstract com.google.protobuf.t0.a mergeFrom(com.google.protobuf.t0 t0);
    }
    public abstract com.google.protobuf.d1<? extends com.google.protobuf.t0> getParserForType();

    @Override // com.google.protobuf.u0
    public abstract int getSerializedSize();

    @Override // com.google.protobuf.u0
    public abstract com.google.protobuf.t0.a newBuilderForType();

    @Override // com.google.protobuf.u0
    public abstract com.google.protobuf.t0.a toBuilder();

    @Override // com.google.protobuf.u0
    public abstract byte[] toByteArray();

    @Override // com.google.protobuf.u0
    public abstract com.google.protobuf.j toByteString();

    @Override // com.google.protobuf.u0
    public abstract void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream);

    @Override // com.google.protobuf.u0
    public abstract void writeTo(OutputStream outputStream);
}
