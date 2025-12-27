package com.googlecode.mp4parser.e;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AbstractTrack.java */
/* loaded from: classes2.dex */
public abstract class a implements f {

    List<b> a = new ArrayList<>();
    Map<b, long[]> b = new HashMap<>();
    public a(String str) {
        super();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
    }

    public Map<b, long[]> S() {
        return this.b;
    }

    public long d() {
        int i = 0;
        int i2 = 0;
        final long[] lArr = F0();
        i = 0;
        i2 = 0;
        for (long l : lArr) {
            i = i + l;
        }
        return i;
    }

    public List<b> u() {
        return this.a;
    }
}
