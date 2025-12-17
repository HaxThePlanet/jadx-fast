package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016", d2 = {"Landroidx/compose/ui/text/style/BaselineShift;", "", "multiplier", "", "constructor-impl", "(F)F", "getMultiplier", "()F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class BaselineShift {

    public static final androidx.compose.ui.text.style.BaselineShift.Companion Companion;
    private static final float None;
    private static final float Subscript;
    private static final float Superscript;
    private final float multiplier;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000f", d2 = {"Landroidx/compose/ui/text/style/BaselineShift$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/style/BaselineShift;", "getNone-y9eOQZs$annotations", "getNone-y9eOQZs", "()F", "F", "Subscript", "getSubscript-y9eOQZs$annotations", "getSubscript-y9eOQZs", "Superscript", "getSuperscript-y9eOQZs$annotations", "getSuperscript-y9eOQZs", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getNone-y9eOQZs$annotations() {
        }

        public static void getSubscript-y9eOQZs$annotations() {
        }

        public static void getSuperscript-y9eOQZs$annotations() {
        }

        public final float getNone-y9eOQZs() {
            return BaselineShift.access$getNone$cp();
        }

        public final float getSubscript-y9eOQZs() {
            return BaselineShift.access$getSubscript$cp();
        }

        public final float getSuperscript-y9eOQZs() {
            return BaselineShift.access$getSuperscript$cp();
        }
    }
    static {
        BaselineShift.Companion companion = new BaselineShift.Companion(0);
        BaselineShift.Companion = companion;
        BaselineShift.Superscript = BaselineShift.constructor-impl(1056964608);
        BaselineShift.Subscript = BaselineShift.constructor-impl(-1090519040);
        BaselineShift.None = BaselineShift.constructor-impl(0);
    }

    private BaselineShift(float multiplier) {
        super();
        this.multiplier = multiplier;
    }

    public static final float access$getNone$cp() {
        return BaselineShift.None;
    }

    public static final float access$getSubscript$cp() {
        return BaselineShift.Subscript;
    }

    public static final float access$getSuperscript$cp() {
        return BaselineShift.Superscript;
    }

    public static final androidx.compose.ui.text.style.BaselineShift box-impl(float f) {
        BaselineShift baselineShift = new BaselineShift(f);
        return baselineShift;
    }

    public static float constructor-impl(float f) {
        return f;
    }

    public static boolean equals-impl(float f, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof BaselineShift) {
            return i2;
        }
        if (Float.compare(f, (BaselineShift)object2.unbox-impl()) != 0) {
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

    public static String toString-impl(float f) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BaselineShift(multiplier=").append(f).append(')').toString();
    }

    public boolean equals(Object object) {
        return BaselineShift.equals-impl(this.multiplier, object);
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public int hashCode() {
        return BaselineShift.hashCode-impl(this.multiplier);
    }

    public String toString() {
        return BaselineShift.toString-impl(this.multiplier);
    }

    public final float unbox-impl() {
        return this.multiplier;
    }
}
