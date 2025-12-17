package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;
import java.util.Map;

/* loaded from: classes2.dex */
final class f extends i {

    final Map b;
    final o c;
    final com.google.android.play.core.assetpacks.t v;
    f(com.google.android.play.core.assetpacks.t t, o o2, Map map3, o o4) {
        this.v = t;
        this.b = map3;
        this.c = o4;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            o oVar = new o(this.v, this.c);
            (i2)t.r(this.v).e().X(t.t(this.v), t.o(this.b), oVar);
            h hVar = t.q();
            int runtimeException = 0;
            runtimeException = new Object[runtimeException];
            hVar.c(th, "syncPacks", runtimeException);
            hVar = this.c;
            runtimeException = new RuntimeException(th);
            hVar.d(runtimeException);
        }
    }
}
