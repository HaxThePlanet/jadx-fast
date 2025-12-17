package com.google.android.play.core.splitinstall.g;

import com.google.android.play.core.splitinstall.f0;
import java.util.List;

/* loaded from: classes2.dex */
final class n implements f0 {

    final List a;
    final List b;
    final long c;
    final boolean d;
    final List e;
    final com.google.android.play.core.splitinstall.g.a f;
    n(com.google.android.play.core.splitinstall.g.a a, List list2, List list3, long l4, boolean z5, List list6) {
        this.f = a;
        this.a = list2;
        this.b = list3;
        this.c = l4;
        this.d = list6;
        this.e = obj7;
        super();
    }

    @Override // com.google.android.play.core.splitinstall.f0
    public final void a(int i) {
        a.l(this.f, 6, i);
    }

    @Override // com.google.android.play.core.splitinstall.f0
    public final void zza() {
        a.g(this.f, this.a, this.b, this.c);
    }

    @Override // com.google.android.play.core.splitinstall.f0
    public final void zzc() {
        com.google.android.play.core.splitinstall.g.a aVar;
        List list2;
        List list;
        List list3;
        long l;
        int i;
        if (!this.d) {
            a.f(this.f, this.e, this.a, this.b, this.c, obj6);
        }
    }
}
