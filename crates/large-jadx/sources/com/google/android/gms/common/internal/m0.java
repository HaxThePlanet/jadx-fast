package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.e.a;
import com.google.android.gms.tasks.k;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class m0 implements e.a {

    final e a;
    final k b;
    final com.google.android.gms.common.internal.q.a c;
    m0(e e, k k2, com.google.android.gms.common.internal.q.a q$a3, com.google.android.gms.common.internal.p0 p04) {
        this.a = e;
        this.b = k2;
        this.c = a3;
        super();
    }

    @Override // com.google.android.gms.common.api.e$a
    public final void a(Status status) {
        if (status.n2()) {
            this.b.c(this.c.a(this.a.b(0, obj2)));
        }
        this.b.b(b.a(status));
    }
}
