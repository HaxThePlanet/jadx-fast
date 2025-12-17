package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0013", d2 = {"Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getName", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class DeviceFontFamilyName {

    private final String name;
    private DeviceFontFamilyName(String name) {
        super();
        this.name = name;
    }

    public static final androidx.compose.ui.text.font.DeviceFontFamilyName box-impl(String string) {
        DeviceFontFamilyName deviceFontFamilyName = new DeviceFontFamilyName(string);
        return deviceFontFamilyName;
    }

    public static String constructor-impl(String name) {
        int i;
        i = (CharSequence)name.length() > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return name;
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("name may not be empty".toString());
        throw illegalArgumentException;
    }

    public static boolean equals-impl(String string, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof DeviceFontFamilyName) {
            return i2;
        }
        if (!Intrinsics.areEqual(string, (DeviceFontFamilyName)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(String string, String string2) {
        return Intrinsics.areEqual(string, string2);
    }

    public static int hashCode-impl(String string) {
        return string.hashCode();
    }

    public static String toString-impl(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DeviceFontFamilyName(name=").append(string).append(')').toString();
    }

    public boolean equals(Object object) {
        return DeviceFontFamilyName.equals-impl(this.name, object);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return DeviceFontFamilyName.hashCode-impl(this.name);
    }

    public String toString() {
        return DeviceFontFamilyName.toString-impl(this.name);
    }

    public final String unbox-impl() {
        return this.name;
    }
}
