package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/text/input/TextObfuscationMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class TextObfuscationMode {

    public static final androidx.compose.foundation.text.input.TextObfuscationMode.Companion Companion;
    private static final int Hidden;
    private static final int RevealLastTyped;
    private static final int Visible;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/text/input/TextObfuscationMode$Companion;", "", "()V", "Hidden", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "getHidden-vTwcZD0", "()I", "I", "RevealLastTyped", "getRevealLastTyped-vTwcZD0", "Visible", "getVisible-vTwcZD0", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getHidden-vTwcZD0() {
            return TextObfuscationMode.access$getHidden$cp();
        }

        public final int getRevealLastTyped-vTwcZD0() {
            return TextObfuscationMode.access$getRevealLastTyped$cp();
        }

        public final int getVisible-vTwcZD0() {
            return TextObfuscationMode.access$getVisible$cp();
        }
    }
    static {
        TextObfuscationMode.Companion companion = new TextObfuscationMode.Companion(0);
        TextObfuscationMode.Companion = companion;
        TextObfuscationMode.Visible = TextObfuscationMode.constructor-impl(0);
        TextObfuscationMode.RevealLastTyped = TextObfuscationMode.constructor-impl(1);
        TextObfuscationMode.Hidden = TextObfuscationMode.constructor-impl(2);
    }

    private TextObfuscationMode(int value) {
        super();
        this.value = value;
    }

    public static final int access$getHidden$cp() {
        return TextObfuscationMode.Hidden;
    }

    public static final int access$getRevealLastTyped$cp() {
        return TextObfuscationMode.RevealLastTyped;
    }

    public static final int access$getVisible$cp() {
        return TextObfuscationMode.Visible;
    }

    public static final androidx.compose.foundation.text.input.TextObfuscationMode box-impl(int i) {
        TextObfuscationMode textObfuscationMode = new TextObfuscationMode(i);
        return textObfuscationMode;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof TextObfuscationMode) {
            return i3;
        }
        if (i != (TextObfuscationMode)object2.unbox-impl()) {
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

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextObfuscationMode(value=").append(i).append(')').toString();
    }

    public boolean equals(Object object) {
        return TextObfuscationMode.equals-impl(this.value, object);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return TextObfuscationMode.hashCode-impl(this.value);
    }

    public String toString() {
        return TextObfuscationMode.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
