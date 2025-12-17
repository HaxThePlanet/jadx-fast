package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/input/KeyboardCapitalization;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class KeyboardCapitalization {

    private static final int Characters;
    public static final androidx.compose.ui.text.input.KeyboardCapitalization.Companion Companion;
    private static final int None;
    private static final int Sentences;
    private static final int Unspecified;
    private static final int Words;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0010\u0010\u0002\u001a\u0004\u0008\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/ui/text/input/KeyboardCapitalization$Companion;", "", "()V", "Characters", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCharacters-IUNYP9k$annotations", "getCharacters-IUNYP9k", "()I", "I", "None", "getNone-IUNYP9k$annotations", "getNone-IUNYP9k", "Sentences", "getSentences-IUNYP9k$annotations", "getSentences-IUNYP9k", "Unspecified", "getUnspecified-IUNYP9k$annotations", "getUnspecified-IUNYP9k", "Words", "getWords-IUNYP9k$annotations", "getWords-IUNYP9k", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCharacters-IUNYP9k$annotations() {
        }

        public static void getNone-IUNYP9k$annotations() {
        }

        public static void getSentences-IUNYP9k$annotations() {
        }

        public static void getUnspecified-IUNYP9k$annotations() {
        }

        public static void getWords-IUNYP9k$annotations() {
        }

        public final int getCharacters-IUNYP9k() {
            return KeyboardCapitalization.access$getCharacters$cp();
        }

        public final int getNone-IUNYP9k() {
            return KeyboardCapitalization.access$getNone$cp();
        }

        public final int getSentences-IUNYP9k() {
            return KeyboardCapitalization.access$getSentences$cp();
        }

        public final int getUnspecified-IUNYP9k() {
            return KeyboardCapitalization.access$getUnspecified$cp();
        }

        public final int getWords-IUNYP9k() {
            return KeyboardCapitalization.access$getWords$cp();
        }
    }
    static {
        KeyboardCapitalization.Companion companion = new KeyboardCapitalization.Companion(0);
        KeyboardCapitalization.Companion = companion;
        KeyboardCapitalization.Unspecified = KeyboardCapitalization.constructor-impl(-1);
        KeyboardCapitalization.None = KeyboardCapitalization.constructor-impl(0);
        KeyboardCapitalization.Characters = KeyboardCapitalization.constructor-impl(1);
        KeyboardCapitalization.Words = KeyboardCapitalization.constructor-impl(2);
        KeyboardCapitalization.Sentences = KeyboardCapitalization.constructor-impl(3);
    }

    private KeyboardCapitalization(int value) {
        super();
        this.value = value;
    }

    public static final int access$getCharacters$cp() {
        return KeyboardCapitalization.Characters;
    }

    public static final int access$getNone$cp() {
        return KeyboardCapitalization.None;
    }

    public static final int access$getSentences$cp() {
        return KeyboardCapitalization.Sentences;
    }

    public static final int access$getUnspecified$cp() {
        return KeyboardCapitalization.Unspecified;
    }

    public static final int access$getWords$cp() {
        return KeyboardCapitalization.Words;
    }

    public static final androidx.compose.ui.text.input.KeyboardCapitalization box-impl(int i) {
        KeyboardCapitalization keyboardCapitalization = new KeyboardCapitalization(i);
        return keyboardCapitalization;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof KeyboardCapitalization) {
            return i3;
        }
        if (i != (KeyboardCapitalization)object2.unbox-impl()) {
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
        str = KeyboardCapitalization.equals-impl0(arg0, KeyboardCapitalization.Unspecified) ? "Unspecified" : equals-impl02 ? "None" : equals-impl03 ? "Characters" : equals-impl04 ? "Words" : equals-impl05 ? "Sentences" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return KeyboardCapitalization.equals-impl(this.value, object);
    }

    public int hashCode() {
        return KeyboardCapitalization.hashCode-impl(this.value);
    }

    public String toString() {
        return KeyboardCapitalization.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
