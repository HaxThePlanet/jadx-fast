package net.time4j.g1.z;

import net.time4j.engine.ChronoException;
import net.time4j.engine.p;

/* compiled from: AmbivalentValueException.java */
/* loaded from: classes3.dex */
class a extends ChronoException {

    private static final long serialVersionUID = -4315329288187364457L;
    a(p<?> pVar) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "Duplicate element parsed with different values: ";
        String name = pVar.name();
        str2 = str + name;
        super(str2);
    }
}
