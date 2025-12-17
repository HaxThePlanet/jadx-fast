package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.ObjectEncoder;

/* loaded from: classes2.dex */
public final class b implements ObjectEncoder {

    public static final com.google.firebase.encoders.proto.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        ProtobufEncoder.Builder.a(object, (ObjectEncoderContext)object2);
        throw 0;
    }
}
