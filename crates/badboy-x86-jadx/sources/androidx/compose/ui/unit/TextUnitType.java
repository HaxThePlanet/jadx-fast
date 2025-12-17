package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u000cHÖ\u0001¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014", d2 = {"Landroidx/compose/ui/unit/TextUnitType;", "", "type", "", "constructor-impl", "(J)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class TextUnitType {

    public static final androidx.compose.ui.unit.TextUnitType.Companion Companion;
    private static final long Em;
    private static final long Sp;
    private static final long Unspecified;
    private final long type;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/ui/unit/TextUnitType$Companion;", "", "()V", "Em", "Landroidx/compose/ui/unit/TextUnitType;", "getEm-UIouoOA", "()J", "J", "Sp", "getSp-UIouoOA", "Unspecified", "getUnspecified-UIouoOA", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getEm-UIouoOA() {
            return TextUnitType.access$getEm$cp();
        }

        public final long getSp-UIouoOA() {
            return TextUnitType.access$getSp$cp();
        }

        public final long getUnspecified-UIouoOA() {
            return TextUnitType.access$getUnspecified$cp();
        }
    }
    static {
        final int i2 = 0;
        TextUnitType.Companion companion = new TextUnitType.Companion(i2);
        TextUnitType.Companion = companion;
        TextUnitType.Unspecified = TextUnitType.constructor-impl(0);
        TextUnitType.Sp = TextUnitType.constructor-impl(4294967296L);
        TextUnitType.Em = TextUnitType.constructor-impl(8589934592L);
    }

    private TextUnitType(long type) {
        super();
        this.type = type;
    }

    public static final long access$getEm$cp() {
        return TextUnitType.Em;
    }

    public static final long access$getSp$cp() {
        return TextUnitType.Sp;
    }

    public static final long access$getUnspecified$cp() {
        return TextUnitType.Unspecified;
    }

    public static final androidx.compose.ui.unit.TextUnitType box-impl(long l) {
        TextUnitType textUnitType = new TextUnitType(l, obj2);
        return textUnitType;
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof TextUnitType) {
            return i2;
        }
        if (Long.compare(l, unbox-impl) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        int i;
        i = Long.compare(l, obj3) == 0 ? 1 : 0;
        return i;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long arg0) {
        String str;
        str = TextUnitType.equals-impl0(arg0, obj3) ? "Unspecified" : equals-impl02 ? "Sp" : equals-impl03 ? "Em" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return TextUnitType.equals-impl(this.type, obj1);
    }

    public int hashCode() {
        return TextUnitType.hashCode-impl(this.type);
    }

    public String toString() {
        return TextUnitType.toString-impl(this.type);
    }

    public final long unbox-impl() {
        return this.type;
    }
}
