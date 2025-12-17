package com.google.android.play.core.splitinstall.g;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.c;
import com.google.android.play.core.splitinstall.d;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class h implements com.google.android.play.core.splitinstall.g.o {

    public final c a;
    public h(c c) {
        super();
        this.a = c;
    }

    @Override // com.google.android.play.core.splitinstall.g.o
    public final d a(d d) {
        int i2;
        int i;
        int obj12;
        i2 = a.p;
        if (d != 0) {
            if (!d.d()) {
            } else {
            }
            obj12 = new SplitInstallException(-1);
            throw obj12;
        }
        if (d == 0) {
        } else {
            i += obj12;
        }
        ArrayList arrayList = new ArrayList();
        return d.b(i, 1, 0, 0, obj6, 0, obj8);
    }
}
