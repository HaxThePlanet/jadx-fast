package net.time4j.tz.model;

import java.util.Comparator;
import net.time4j.engine.m;
import net.time4j.h0;

/* compiled from: RuleComparator.java */
/* loaded from: classes3.dex */
enum k implements Comparator<d> {

    INSTANCE;
    @Override // java.lang.Enum
    public int compare(d dVar, d dVar2) {
        int i;
        int i2 = 2000;
        if (dVar.b(i2).P(dVar2.b(i2)) == 0) {
            i = dVar.f().p0(dVar2.f());
        }
        return i;
    }
}
