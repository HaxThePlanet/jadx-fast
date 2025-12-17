package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;

/* loaded from: classes2.dex */
public final class a implements ObjectEncoder {

    public static final com.google.firebase.encoders.json.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        JsonDataEncoderBuilder.a(object, (ObjectEncoderContext)object2);
        throw 0;
    }
}
