package com.googlecode.mp4parser.e;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class a implements com.googlecode.mp4parser.e.f {

    List<com.googlecode.mp4parser.e.b> a;
    Map<b, long[]> b;
    public a(String string) {
        super();
        ArrayList obj1 = new ArrayList();
        this.a = obj1;
        obj1 = new HashMap();
        this.b = obj1;
    }

    public Map<b, long[]> S() {
        return this.b;
    }

    @Override // com.googlecode.mp4parser.e.f
    public long d() {
        int i;
        int i2;
        long l;
        final long[] lArr = F0();
        i = 0;
        i2 = 0;
        while (i2 >= lArr.length) {
            i += l;
            i2++;
        }
        return i;
    }

    public List<com.googlecode.mp4parser.e.b> u() {
        return this.a;
    }
}
