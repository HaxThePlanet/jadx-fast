package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 &2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001b\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001b\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u000fJ\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00132\u0008\u0010\n\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u000fJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u000fJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010\u000fJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020!H\u0017¢\u0006\u0004\u0008\"\u0010#J\u0016\u0010$\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008%\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006'", d2 = {"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "compareTo", "", "other", "compareTo-0680j_4", "(FF)I", "div", "div-0680j_4", "(FF)F", "div-u2uoSUM", "(FI)F", "equals", "", "", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(F)I", "minus", "minus-5rwHm24", "plus", "plus-5rwHm24", "times", "times-u2uoSUM", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "unaryMinus", "unaryMinus-D9Ej5fM", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Dp implements Comparable<androidx.compose.ui.unit.Dp> {

    public static final androidx.compose.ui.unit.Dp.Companion Companion;
    private static final float Hairline;
    private static final float Infinity;
    private static final float Unspecified;
    private final float value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000f", d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getHairline-D9Ej5fM$annotations() {
        }

        public static void getInfinity-D9Ej5fM$annotations() {
        }

        public static void getUnspecified-D9Ej5fM$annotations() {
        }

        public final float getHairline-D9Ej5fM() {
            return Dp.access$getHairline$cp();
        }

        public final float getInfinity-D9Ej5fM() {
            return Dp.access$getInfinity$cp();
        }

        public final float getUnspecified-D9Ej5fM() {
            return Dp.access$getUnspecified$cp();
        }
    }
    static {
        Dp.Companion companion = new Dp.Companion(0);
        Dp.Companion = companion;
        Dp.Hairline = Dp.constructor-impl(0);
        Dp.Infinity = Dp.constructor-impl(2139095040);
        Dp.Unspecified = Dp.constructor-impl(2143289344);
    }

    private Dp(float value) {
        super();
        this.value = value;
    }

    public static final float access$getHairline$cp() {
        return Dp.Hairline;
    }

    public static final float access$getInfinity$cp() {
        return Dp.Infinity;
    }

    public static final float access$getUnspecified$cp() {
        return Dp.Unspecified;
    }

    public static final androidx.compose.ui.unit.Dp box-impl(float f) {
        Dp dpVar = new Dp(f);
        return dpVar;
    }

    public static int compareTo-0680j_4(float arg0, float other) {
        return Float.compare(arg0, other);
    }

    public static float constructor-impl(float f) {
        return f;
    }

    public static final float div-0680j_4(float arg0, float other) {
        final int i = 0;
        return arg0 / other;
    }

    public static final float div-u2uoSUM(float arg0, float other) {
        final int i = 0;
        return Dp.constructor-impl(arg0 / other);
    }

    public static final float div-u2uoSUM(float arg0, int other) {
        final int i = 0;
        return Dp.constructor-impl(arg0 / f);
    }

    public static boolean equals-impl(float f, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof Dp) {
            return i2;
        }
        if (Float.compare(f, (Dp)object2.unbox-impl()) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(float f, float f2) {
        int i;
        i = Float.compare(f, f2) == 0 ? 1 : 0;
        return i;
    }

    public static int hashCode-impl(float f) {
        return Float.hashCode(f);
    }

    public static final float minus-5rwHm24(float arg0, float other) {
        final int i = 0;
        return Dp.constructor-impl(arg0 - other);
    }

    public static final float plus-5rwHm24(float arg0, float other) {
        final int i = 0;
        return Dp.constructor-impl(arg0 + other);
    }

    public static final float times-u2uoSUM(float arg0, float other) {
        final int i = 0;
        return Dp.constructor-impl(arg0 * other);
    }

    public static final float times-u2uoSUM(float arg0, int other) {
        final int i = 0;
        return Dp.constructor-impl(f *= arg0);
    }

    public static String toString-impl(float arg0) {
        String string;
        int str;
        str = 0;
        if (Float.isNaN(arg0)) {
            string = "Dp.Unspecified";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append(arg0).append(".dp").toString();
        }
        return string;
    }

    public static final float unaryMinus-D9Ej5fM(float arg0) {
        final int i = 0;
        return Dp.constructor-impl(-arg0);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return compareTo-0680j_4((Dp)other.unbox-impl());
    }

    @Override // java.lang.Comparable
    public int compareTo-0680j_4(float other) {
        return Dp.compareTo-0680j_4(this.value, other);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return Dp.equals-impl(this.value, object);
    }

    @Override // java.lang.Comparable
    public final float getValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return Dp.hashCode-impl(this.value);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return Dp.toString-impl(this.value);
    }

    @Override // java.lang.Comparable
    public final float unbox-impl() {
        return this.value;
    }
}
