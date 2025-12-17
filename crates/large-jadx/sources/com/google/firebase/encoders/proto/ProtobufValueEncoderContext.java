package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

/* loaded from: classes2.dex */
class ProtobufValueEncoderContext implements ValueEncoderContext {

    private boolean encoded = false;
    private FieldDescriptor field;
    private final com.google.firebase.encoders.proto.ProtobufDataEncoderContext objEncoderCtx;
    private boolean skipDefault = false;
    ProtobufValueEncoderContext(com.google.firebase.encoders.proto.ProtobufDataEncoderContext protobufDataEncoderContext) {
        super();
        final int i = 0;
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    private void checkNotUsed() {
        if (this.encoded) {
        } else {
            this.encoded = true;
        }
        EncodingException encodingException = new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        throw encodingException;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(double d) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, d, obj5);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(float f) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, f, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(int i) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, i, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(long l) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, l, obj5);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(String string) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, string, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(boolean z) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, z, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(byte[] bArr) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, bArr, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    void resetContext(FieldDescriptor fieldDescriptor, boolean z2) {
        this.encoded = false;
        this.field = fieldDescriptor;
        this.skipDefault = z2;
    }
}
