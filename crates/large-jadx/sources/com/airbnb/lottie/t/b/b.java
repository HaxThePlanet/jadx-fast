package com.airbnb.lottie.t.b;

import android.graphics.Path;
import com.airbnb.lottie.y.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    private List<com.airbnb.lottie.t.b.s> a;
    public b() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    void a(com.airbnb.lottie.t.b.s s) {
        this.a.add(s);
    }

    public void b(Path path) {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            h.b(path, (s)this.a.get(i));
            i--;
        }
    }
}
