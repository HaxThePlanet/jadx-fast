package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/input/KeyboardType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class KeyboardType {

    private static final int Ascii;
    public static final androidx.compose.ui.text.input.KeyboardType.Companion Companion;
    private static final int Decimal;
    private static final int Email;
    private static final int Number;
    private static final int NumberPassword;
    private static final int Password;
    private static final int Phone;
    private static final int Text;
    private static final int Unspecified;
    private static final int Uri;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008 \u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0010\u0010\u0002\u001a\u0004\u0008\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0016\u0010\u0002\u001a\u0004\u0008\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0019\u0010\u0002\u001a\u0004\u0008\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u001c\u0010\u0002\u001a\u0004\u0008\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010\u0007R$\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\"\u0010\u0002\u001a\u0004\u0008#\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/ui/text/input/KeyboardType$Companion;", "", "()V", "Ascii", "Landroidx/compose/ui/text/input/KeyboardType;", "getAscii-PjHm6EE$annotations", "getAscii-PjHm6EE", "()I", "I", "Decimal", "getDecimal-PjHm6EE$annotations", "getDecimal-PjHm6EE", "Email", "getEmail-PjHm6EE$annotations", "getEmail-PjHm6EE", "Number", "getNumber-PjHm6EE$annotations", "getNumber-PjHm6EE", "NumberPassword", "getNumberPassword-PjHm6EE$annotations", "getNumberPassword-PjHm6EE", "Password", "getPassword-PjHm6EE$annotations", "getPassword-PjHm6EE", "Phone", "getPhone-PjHm6EE$annotations", "getPhone-PjHm6EE", "Text", "getText-PjHm6EE$annotations", "getText-PjHm6EE", "Unspecified", "getUnspecified-PjHm6EE$annotations", "getUnspecified-PjHm6EE", "Uri", "getUri-PjHm6EE$annotations", "getUri-PjHm6EE", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getAscii-PjHm6EE$annotations() {
        }

        public static void getDecimal-PjHm6EE$annotations() {
        }

        public static void getEmail-PjHm6EE$annotations() {
        }

        public static void getNumber-PjHm6EE$annotations() {
        }

        public static void getNumberPassword-PjHm6EE$annotations() {
        }

        public static void getPassword-PjHm6EE$annotations() {
        }

        public static void getPhone-PjHm6EE$annotations() {
        }

        public static void getText-PjHm6EE$annotations() {
        }

        public static void getUnspecified-PjHm6EE$annotations() {
        }

        public static void getUri-PjHm6EE$annotations() {
        }

        public final int getAscii-PjHm6EE() {
            return KeyboardType.access$getAscii$cp();
        }

        public final int getDecimal-PjHm6EE() {
            return KeyboardType.access$getDecimal$cp();
        }

        public final int getEmail-PjHm6EE() {
            return KeyboardType.access$getEmail$cp();
        }

        public final int getNumber-PjHm6EE() {
            return KeyboardType.access$getNumber$cp();
        }

        public final int getNumberPassword-PjHm6EE() {
            return KeyboardType.access$getNumberPassword$cp();
        }

        public final int getPassword-PjHm6EE() {
            return KeyboardType.access$getPassword$cp();
        }

        public final int getPhone-PjHm6EE() {
            return KeyboardType.access$getPhone$cp();
        }

        public final int getText-PjHm6EE() {
            return KeyboardType.access$getText$cp();
        }

        public final int getUnspecified-PjHm6EE() {
            return KeyboardType.access$getUnspecified$cp();
        }

        public final int getUri-PjHm6EE() {
            return KeyboardType.access$getUri$cp();
        }
    }
    static {
        KeyboardType.Companion companion = new KeyboardType.Companion(0);
        KeyboardType.Companion = companion;
        KeyboardType.Unspecified = KeyboardType.constructor-impl(0);
        KeyboardType.Text = KeyboardType.constructor-impl(1);
        KeyboardType.Ascii = KeyboardType.constructor-impl(2);
        KeyboardType.Number = KeyboardType.constructor-impl(3);
        KeyboardType.Phone = KeyboardType.constructor-impl(4);
        KeyboardType.Uri = KeyboardType.constructor-impl(5);
        KeyboardType.Email = KeyboardType.constructor-impl(6);
        KeyboardType.Password = KeyboardType.constructor-impl(7);
        KeyboardType.NumberPassword = KeyboardType.constructor-impl(8);
        KeyboardType.Decimal = KeyboardType.constructor-impl(9);
    }

    private KeyboardType(int value) {
        super();
        this.value = value;
    }

    public static final int access$getAscii$cp() {
        return KeyboardType.Ascii;
    }

    public static final int access$getDecimal$cp() {
        return KeyboardType.Decimal;
    }

    public static final int access$getEmail$cp() {
        return KeyboardType.Email;
    }

    public static final int access$getNumber$cp() {
        return KeyboardType.Number;
    }

    public static final int access$getNumberPassword$cp() {
        return KeyboardType.NumberPassword;
    }

    public static final int access$getPassword$cp() {
        return KeyboardType.Password;
    }

    public static final int access$getPhone$cp() {
        return KeyboardType.Phone;
    }

    public static final int access$getText$cp() {
        return KeyboardType.Text;
    }

    public static final int access$getUnspecified$cp() {
        return KeyboardType.Unspecified;
    }

    public static final int access$getUri$cp() {
        return KeyboardType.Uri;
    }

    public static final androidx.compose.ui.text.input.KeyboardType box-impl(int i) {
        KeyboardType keyboardType = new KeyboardType(i);
        return keyboardType;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof KeyboardType) {
            return i3;
        }
        if (i != (KeyboardType)object2.unbox-impl()) {
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
        str = KeyboardType.equals-impl0(arg0, KeyboardType.Unspecified) ? "Unspecified" : equals-impl02 ? "Text" : equals-impl03 ? "Ascii" : equals-impl04 ? "Number" : equals-impl05 ? "Phone" : equals-impl06 ? "Uri" : equals-impl07 ? "Email" : equals-impl08 ? "Password" : equals-impl09 ? "NumberPassword" : equals-impl010 ? "Decimal" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return KeyboardType.equals-impl(this.value, object);
    }

    public int hashCode() {
        return KeyboardType.hashCode-impl(this.value);
    }

    public String toString() {
        return KeyboardType.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
