package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.r1;
import com.google.android.play.core.splitinstall.g.r;
import com.google.android.play.core.splitinstall.g.w;
import java.io.File;

/* loaded from: classes2.dex */
public final class m implements r1<r> {

    private final r1<File> a;
    public m(r1<File> r1) {
        super();
        this.a = r1;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        Object obj = this.a.zza();
        if ((File)obj == null) {
            return null;
        }
        return w.a((File)obj);
    }
}
