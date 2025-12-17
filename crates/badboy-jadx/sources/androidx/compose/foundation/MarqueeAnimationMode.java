package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/MarqueeAnimationMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class MarqueeAnimationMode {

    public static final androidx.compose.foundation.MarqueeAnimationMode.Companion Companion;
    private static final int Immediately;
    private static final int WhileFocused;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\n", d2 = {"Landroidx/compose/foundation/MarqueeAnimationMode$Companion;", "", "()V", "Immediately", "Landroidx/compose/foundation/MarqueeAnimationMode;", "getImmediately-ZbEOnfQ", "()I", "I", "WhileFocused", "getWhileFocused-ZbEOnfQ", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getImmediately-ZbEOnfQ() {
            return MarqueeAnimationMode.access$getImmediately$cp();
        }

        public final int getWhileFocused-ZbEOnfQ() {
            return MarqueeAnimationMode.access$getWhileFocused$cp();
        }
    }
    static {
        MarqueeAnimationMode.Companion companion = new MarqueeAnimationMode.Companion(0);
        MarqueeAnimationMode.Companion = companion;
        MarqueeAnimationMode.Immediately = MarqueeAnimationMode.constructor-impl(0);
        MarqueeAnimationMode.WhileFocused = MarqueeAnimationMode.constructor-impl(1);
    }

    private MarqueeAnimationMode(int value) {
        super();
        this.value = value;
    }

    public static final int access$getImmediately$cp() {
        return MarqueeAnimationMode.Immediately;
    }

    public static final int access$getWhileFocused$cp() {
        return MarqueeAnimationMode.WhileFocused;
    }

    public static final androidx.compose.foundation.MarqueeAnimationMode box-impl(int i) {
        MarqueeAnimationMode marqueeAnimationMode = new MarqueeAnimationMode(i);
        return marqueeAnimationMode;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof MarqueeAnimationMode) {
            return i3;
        }
        if (i != (MarqueeAnimationMode)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static String toString-impl(int arg0) {
        String str;
        if (MarqueeAnimationMode.equals-impl0(arg0, MarqueeAnimationMode.Immediately)) {
            str = "Immediately";
            return str;
        } else {
            if (!MarqueeAnimationMode.equals-impl0(arg0, MarqueeAnimationMode.WhileFocused)) {
            } else {
                str = "WhileFocused";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("invalid value: ").append(arg0).toString().toString());
        throw illegalStateException;
    }

    public boolean equals(Object object) {
        return MarqueeAnimationMode.equals-impl(this.value, object);
    }

    public int hashCode() {
        return MarqueeAnimationMode.hashCode-impl(this.value);
    }

    public String toString() {
        return MarqueeAnimationMode.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
