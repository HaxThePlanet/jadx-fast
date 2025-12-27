package net.time4j.tz.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;
import net.time4j.tz.m;
import net.time4j.tz.p;
import net.time4j.tz.q;

/* compiled from: EmptyTransitionModel.java */
/* loaded from: classes3.dex */
final class e implements m, Serializable {

    private static final long serialVersionUID = 1374714021808040253L;
    private final p offset;
    e(p pVar) {
        super();
        this.offset = pVar;
    }

    public p b() {
        return this.offset;
    }

    public List<p> c(a aVar, g gVar) {
        return Collections.singletonList(this.offset);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof e) {
            return this.offset.equals(object.offset);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.offset.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "EmptyTransitionModel=";
        String str3 = this.offset.a();
        str = str2 + str3;
        return str;
    }

    public q a(a aVar, g gVar) {
        return null;
    }

    public q d(f fVar) {
        return null;
    }

    public boolean e() {
        return false;
    }

    public boolean isEmpty() {
        return true;
    }
}
