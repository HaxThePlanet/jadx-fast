package com.google.firebase.remoteconfig;

import com.google.android.gms.common.util.d;
import com.google.firebase.remoteconfig.internal.Personalization;

/* loaded from: classes2.dex */
public final class m implements d {

    public final Personalization a;
    public m(Personalization personalization) {
        super();
        this.a = personalization;
    }

    @Override // com.google.android.gms.common.util.d
    public final void a(Object object, Object object2) {
        this.a.logArmActive((String)object, (ConfigContainer)object2);
    }
}
