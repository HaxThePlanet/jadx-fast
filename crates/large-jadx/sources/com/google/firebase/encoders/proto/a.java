package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.ObjectEncoder;

/* loaded from: classes2.dex */
public final class a implements ObjectEncoder {

    public static final com.google.firebase.encoders.proto.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        ProtobufDataEncoderContext.a((Map.Entry)object, (ObjectEncoderContext)object2);
    }
}
