package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;

/* loaded from: classes2.dex */
public final class b implements ValueEncoder {

    public static final com.google.firebase.encoders.json.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // com.google.firebase.encoders.ValueEncoder
    public final void encode(Object object, Object object2) {
        JsonDataEncoderBuilder.b((String)object, (ValueEncoderContext)object2);
    }
}
