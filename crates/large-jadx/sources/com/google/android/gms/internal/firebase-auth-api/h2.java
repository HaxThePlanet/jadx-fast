package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class h2<KeyFormatProtoT extends com.google.android.gms.internal.firebase-auth-api.y, KeyT>  {

    private final Class<KeyFormatProtoT> a;
    public h2(Class<KeyFormatProtoT> class) {
        super();
        this.a = class;
    }

    public abstract KeyFormatProtoT a(com.google.android.gms.internal.firebase-auth-api.wq wq);

    public final Class<KeyFormatProtoT> b() {
        return this.a;
    }

    public abstract KeyT c(KeyFormatProtoT keyformatprotot);

    public Map<String, com.google.android.gms.internal.firebase-auth-api.g2<KeyFormatProtoT>> d() {
        return Collections.emptyMap();
    }

    public abstract void e(KeyFormatProtoT keyformatprotot);
}
