package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014", d2 = {"Landroidx/compose/ui/text/font/FontLoadingStrategy;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class FontLoadingStrategy {

    private static final int Async;
    private static final int Blocking;
    public static final androidx.compose.ui.text.font.FontLoadingStrategy.Companion Companion;
    private static final int OptionalLocal;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/font/FontLoadingStrategy$Companion;", "", "()V", "Async", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getAsync-PKNRLFQ", "()I", "I", "Blocking", "getBlocking-PKNRLFQ", "OptionalLocal", "getOptionalLocal-PKNRLFQ", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getAsync-PKNRLFQ() {
            return FontLoadingStrategy.access$getAsync$cp();
        }

        public final int getBlocking-PKNRLFQ() {
            return FontLoadingStrategy.access$getBlocking$cp();
        }

        public final int getOptionalLocal-PKNRLFQ() {
            return FontLoadingStrategy.access$getOptionalLocal$cp();
        }
    }
    static {
        FontLoadingStrategy.Companion companion = new FontLoadingStrategy.Companion(0);
        FontLoadingStrategy.Companion = companion;
        FontLoadingStrategy.Blocking = FontLoadingStrategy.constructor-impl(0);
        FontLoadingStrategy.OptionalLocal = FontLoadingStrategy.constructor-impl(1);
        FontLoadingStrategy.Async = FontLoadingStrategy.constructor-impl(2);
    }

    private FontLoadingStrategy(int value) {
        super();
        this.value = value;
    }

    public static final int access$getAsync$cp() {
        return FontLoadingStrategy.Async;
    }

    public static final int access$getBlocking$cp() {
        return FontLoadingStrategy.Blocking;
    }

    public static final int access$getOptionalLocal$cp() {
        return FontLoadingStrategy.OptionalLocal;
    }

    public static final androidx.compose.ui.text.font.FontLoadingStrategy box-impl(int i) {
        FontLoadingStrategy fontLoadingStrategy = new FontLoadingStrategy(i);
        return fontLoadingStrategy;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof FontLoadingStrategy) {
            return i3;
        }
        if (i != (FontLoadingStrategy)object2.unbox-impl()) {
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
        String string;
        int i;
        if (FontLoadingStrategy.equals-impl0(arg0, FontLoadingStrategy.Blocking)) {
            string = "Blocking";
        } else {
            if (FontLoadingStrategy.equals-impl0(arg0, FontLoadingStrategy.OptionalLocal)) {
                string = "Optional";
            } else {
                if (FontLoadingStrategy.equals-impl0(arg0, FontLoadingStrategy.Async)) {
                    string = "Async";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    string = stringBuilder.append("Invalid(value=").append(arg0).append(')').toString();
                }
            }
        }
        return string;
    }

    public boolean equals(Object object) {
        return FontLoadingStrategy.equals-impl(this.value, object);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return FontLoadingStrategy.hashCode-impl(this.value);
    }

    public String toString() {
        return FontLoadingStrategy.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
