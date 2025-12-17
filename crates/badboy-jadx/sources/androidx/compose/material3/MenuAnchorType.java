package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u000cHÖ\u0001¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/material3/MenuAnchorType;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class MenuAnchorType {

    public static final androidx.compose.material3.MenuAnchorType.Companion Companion;
    private static final String PrimaryEditable;
    private static final String PrimaryNotEditable;
    private static final String SecondaryEditable;
    private final String name;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/material3/MenuAnchorType$Companion;", "", "()V", "PrimaryEditable", "Landroidx/compose/material3/MenuAnchorType;", "getPrimaryEditable-Mg6Rgbw", "()Ljava/lang/String;", "Ljava/lang/String;", "PrimaryNotEditable", "getPrimaryNotEditable-Mg6Rgbw", "SecondaryEditable", "getSecondaryEditable-Mg6Rgbw", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final String getPrimaryEditable-Mg6Rgbw() {
            return MenuAnchorType.access$getPrimaryEditable$cp();
        }

        public final String getPrimaryNotEditable-Mg6Rgbw() {
            return MenuAnchorType.access$getPrimaryNotEditable$cp();
        }

        public final String getSecondaryEditable-Mg6Rgbw() {
            return MenuAnchorType.access$getSecondaryEditable$cp();
        }
    }
    static {
        MenuAnchorType.Companion companion = new MenuAnchorType.Companion(0);
        MenuAnchorType.Companion = companion;
        MenuAnchorType.PrimaryNotEditable = MenuAnchorType.constructor-impl("PrimaryNotEditable");
        MenuAnchorType.PrimaryEditable = MenuAnchorType.constructor-impl("PrimaryEditable");
        MenuAnchorType.SecondaryEditable = MenuAnchorType.constructor-impl("SecondaryEditable");
    }

    private MenuAnchorType(String name) {
        super();
        this.name = name;
    }

    public static final String access$getPrimaryEditable$cp() {
        return MenuAnchorType.PrimaryEditable;
    }

    public static final String access$getPrimaryNotEditable$cp() {
        return MenuAnchorType.PrimaryNotEditable;
    }

    public static final String access$getSecondaryEditable$cp() {
        return MenuAnchorType.SecondaryEditable;
    }

    public static final androidx.compose.material3.MenuAnchorType box-impl(String string) {
        MenuAnchorType menuAnchorType = new MenuAnchorType(string);
        return menuAnchorType;
    }

    private static String constructor-impl(String string) {
        return string;
    }

    public static boolean equals-impl(String string, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof MenuAnchorType) {
            return i2;
        }
        if (!Intrinsics.areEqual(string, (MenuAnchorType)object2.unbox-impl())) {
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

    public static String toString-impl(String arg0) {
        return arg0;
    }

    public boolean equals(Object object) {
        return MenuAnchorType.equals-impl(this.name, object);
    }

    public int hashCode() {
        return MenuAnchorType.hashCode-impl(this.name);
    }

    public String toString() {
        return MenuAnchorType.toString-impl(this.name);
    }

    public final String unbox-impl() {
        return this.name;
    }
}
