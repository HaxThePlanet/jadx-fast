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

/* loaded from: classes3.dex */
final class e implements m, Serializable {

    private static final long serialVersionUID = 1374714021808040253L;
    private final p offset;
    e(p p) {
        super();
        this.offset = p;
    }

    @Override // net.time4j.tz.m
    public q a(a a, g g2) {
        return null;
    }

    @Override // net.time4j.tz.m
    public p b() {
        return this.offset;
    }

    public List<p> c(a a, g g2) {
        return Collections.singletonList(this.offset);
    }

    @Override // net.time4j.tz.m
    public q d(f f) {
        return null;
    }

    @Override // net.time4j.tz.m
    public boolean e() {
        return 0;
    }

    @Override // net.time4j.tz.m
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (object instanceof e) {
            return this.offset.equals(object.offset);
        }
        return 0;
    }

    @Override // net.time4j.tz.m
    public int hashCode() {
        return this.offset.hashCode();
    }

    @Override // net.time4j.tz.m
    public boolean isEmpty() {
        return 1;
    }

    @Override // net.time4j.tz.m
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EmptyTransitionModel=");
        stringBuilder.append(this.offset.a());
        return stringBuilder.toString();
    }
}
