package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;

/* loaded from: classes2.dex */
public final class c implements ValueEncoder {

    public static final com.google.firebase.encoders.json.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    @Override // com.google.firebase.encoders.ValueEncoder
    public final void encode(Object object, Object object2) {
        JsonDataEncoderBuilder.c((Boolean)object, (ValueEncoderContext)object2);
    }
}
