package com.google.android.play.core.splitinstall;

import android.app.Activity;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.splitinstall.g.a;
import com.google.android.play.core.tasks.d;
import java.io.File;
import java.util.Set;

/* loaded from: classes2.dex */
final class l0 implements com.google.android.play.core.splitinstall.a {

    private final n1<com.google.android.play.core.splitinstall.i> a;
    private final n1<a> b;
    private final n1<File> c;
    l0(n1<com.google.android.play.core.splitinstall.i> n1, n1<a> n12, n1<File> n13) {
        super();
        this.a = n1;
        this.b = n12;
        this.c = n13;
    }

    private final com.google.android.play.core.splitinstall.a f() {
        Object obj;
        if (this.c.zza() == null) {
            obj = this.a.zza();
        } else {
            obj = this.b.zza();
        }
        return obj;
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final boolean a(com.google.android.play.core.splitinstall.d d, Activity activity2, int i3) {
        return f().a(d, activity2, i3);
    }

    public final d<Integer> b(com.google.android.play.core.splitinstall.c c) {
        return f().b(c);
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void c(com.google.android.play.core.splitinstall.e e) {
        f().c(e);
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void d(com.google.android.play.core.splitinstall.e e) {
        f().d(e);
    }

    public final Set<String> e() {
        return f().e();
    }
}
