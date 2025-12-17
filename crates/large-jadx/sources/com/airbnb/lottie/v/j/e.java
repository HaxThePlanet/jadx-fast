package com.airbnb.lottie.v.j;

import android.graphics.PointF;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.i;
import com.airbnb.lottie.t.c.j;
import com.airbnb.lottie.z.a;
import java.util.List;

/* loaded from: classes.dex */
public class e implements com.airbnb.lottie.v.j.m<PointF, PointF> {

    private final List<a<PointF>> a;
    public e(List<a<PointF>> list) {
        super();
        this.a = list;
    }

    @Override // com.airbnb.lottie.v.j.m
    public boolean i() {
        int size;
        int i;
        final int i2 = 1;
        if (this.a.size() == i2 && (a)this.a.get(0).h()) {
            if ((a)this.a.get(i).h()) {
                i = i2;
            }
        }
        return i;
    }

    public a<PointF, PointF> j() {
        if ((a)this.a.get(0).h()) {
            j jVar = new j(this.a);
            return jVar;
        }
        i iVar = new i(this.a);
        return iVar;
    }

    public List<a<PointF>> q() {
        return this.a;
    }
}
