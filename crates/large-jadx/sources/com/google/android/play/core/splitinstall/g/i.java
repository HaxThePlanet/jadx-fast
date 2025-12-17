package com.google.android.play.core.splitinstall.g;

import com.google.android.play.core.splitinstall.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class i implements com.google.android.play.core.splitinstall.g.o {

    public final Integer a;
    public final int b;
    public final int c;
    public final Long d;
    public final Long e;
    public final List f;
    public final List g;
    public i(Integer integer, int i2, int i3, Long long4, Long long5, List list6, List list7) {
        super();
        this.a = integer;
        this.b = i2;
        this.c = i3;
        this.d = long4;
        this.e = long5;
        this.f = list6;
        this.g = list7;
    }

    @Override // com.google.android.play.core.splitinstall.g.o
    public final d a(d d) {
        int intValue;
        Object num;
        d dVar;
        int i5;
        long longValue2;
        int i4;
        int i3;
        long longValue;
        int i;
        List list;
        int i2;
        List list2;
        ArrayList arrayList;
        ArrayList arrayList2;
        final Object obj = this;
        Integer num2 = obj.a;
        num = obj.d;
        Long num3 = obj.e;
        final List list3 = obj.f;
        List list4 = obj.g;
        int i9 = a.p;
        if (d == null) {
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            dVar = d.b(0, 0, 0, 0, obj13, 0, obj15);
        } else {
            dVar = d;
        }
        if (num2 == null) {
            intValue = dVar.h();
        } else {
            intValue = num2.intValue();
        }
        if (num == null) {
            longValue2 = dVar.a();
        } else {
            longValue2 = num.longValue();
        }
        if (num3 == null) {
            longValue = dVar.j();
        } else {
            longValue = num3.longValue();
        }
        if (list3 == null) {
            list = num;
        } else {
            list = list3;
        }
        if (list4 == null) {
            list2 = num;
        } else {
            list2 = list4;
        }
        return d.b(intValue, obj.b, obj.c, longValue2, list3, longValue, dVar);
    }
}
