package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.o;
import java.util.List;

/* loaded from: classes2.dex */
final class o extends com.google.android.play.core.assetpacks.l<List<String>> {

    final com.google.android.play.core.assetpacks.t c;
    o(com.google.android.play.core.assetpacks.t t, o o2) {
        this.c = t;
        super(t, o2);
    }

    public final void x(List<Bundle> list) {
        super.x(list);
        this.a.e(t.v(this.c, list));
    }
}
