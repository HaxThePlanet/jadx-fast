package com.airbnb.lottie.t.b;

import android.graphics.Path;
import com.airbnb.lottie.y.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes.dex */
public class b {

    private List<s> a = new ArrayList<>();
    public b() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    void a(s sVar) {
        this.a.add(sVar);
    }

    public void b(Path path) {
        int i;
        i = this.a.size() - 1;
        while (this.a >= 0) {
            h.b(path, (s)this.a.get(i));
            i = i - 1;
        }
    }
}
