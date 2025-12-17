package com.facebook.internal;

import java.util.EnumSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u0000 \n2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\u000b", d2 = {"Lcom/facebook/internal/SmartLoginOption;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "None", "Enabled", "RequireConfirm", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public enum a0 {

    None(false, /* unknown */),
    Enabled(false, /* unknown */),
    RequireConfirm(false, /* unknown */);

    private final long value;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0007R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lcom/facebook/internal/SmartLoginOption$Companion;", "", "()V", "ALL", "Ljava/util/EnumSet;", "Lcom/facebook/internal/SmartLoginOption;", "parseOptions", "bitmask", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final EnumSet<com.facebook.internal.a0> a(long l) {
            Object next;
            int cmp;
            int i;
            EnumSet noneOf = EnumSet.noneOf(a0.class);
            Iterator iterator = a0.access$getALL$cp().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (Long.compare(i2, i) != 0) {
                }
                noneOf.add(next);
            }
            n.e(noneOf, "result");
            return noneOf;
        }
    }
    public static final EnumSet access$getALL$cp() {
        return a0.ALL;
    }

    public static final EnumSet<com.facebook.internal.a0> parseOptions(long l) {
        return a0.Companion.a(l);
    }

    @Override // java.lang.Enum
    public final long getValue() {
        return this.value;
    }
}
