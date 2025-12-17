package net.time4j.g1.z;

import net.time4j.engine.ChronoException;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
class a extends ChronoException {

    private static final long serialVersionUID = -4315329288187364457L;
    a(p<?> p) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Duplicate element parsed with different values: ");
        stringBuilder.append(p.name());
        super(stringBuilder.toString());
    }
}
