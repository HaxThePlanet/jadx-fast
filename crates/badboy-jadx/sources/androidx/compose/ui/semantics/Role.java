package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Role {

    private static final int Button;
    private static final int Checkbox;
    public static final androidx.compose.ui.semantics.Role.Companion Companion;
    private static final int DropdownList;
    private static final int Image;
    private static final int RadioButton;
    private static final int Switch;
    private static final int Tab;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/ui/semantics/Role$Companion;", "", "()V", "Button", "Landroidx/compose/ui/semantics/Role;", "getButton-o7Vup1c", "()I", "I", "Checkbox", "getCheckbox-o7Vup1c", "DropdownList", "getDropdownList-o7Vup1c", "Image", "getImage-o7Vup1c", "RadioButton", "getRadioButton-o7Vup1c", "Switch", "getSwitch-o7Vup1c", "Tab", "getTab-o7Vup1c", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getButton-o7Vup1c() {
            return Role.access$getButton$cp();
        }

        public final int getCheckbox-o7Vup1c() {
            return Role.access$getCheckbox$cp();
        }

        public final int getDropdownList-o7Vup1c() {
            return Role.access$getDropdownList$cp();
        }

        public final int getImage-o7Vup1c() {
            return Role.access$getImage$cp();
        }

        public final int getRadioButton-o7Vup1c() {
            return Role.access$getRadioButton$cp();
        }

        public final int getSwitch-o7Vup1c() {
            return Role.access$getSwitch$cp();
        }

        public final int getTab-o7Vup1c() {
            return Role.access$getTab$cp();
        }
    }
    static {
        Role.Companion companion = new Role.Companion(0);
        Role.Companion = companion;
        Role.Button = Role.constructor-impl(0);
        Role.Checkbox = Role.constructor-impl(1);
        Role.Switch = Role.constructor-impl(2);
        Role.RadioButton = Role.constructor-impl(3);
        Role.Tab = Role.constructor-impl(4);
        Role.Image = Role.constructor-impl(5);
        Role.DropdownList = Role.constructor-impl(6);
    }

    private Role(int value) {
        super();
        this.value = value;
    }

    public static final int access$getButton$cp() {
        return Role.Button;
    }

    public static final int access$getCheckbox$cp() {
        return Role.Checkbox;
    }

    public static final int access$getDropdownList$cp() {
        return Role.DropdownList;
    }

    public static final int access$getImage$cp() {
        return Role.Image;
    }

    public static final int access$getRadioButton$cp() {
        return Role.RadioButton;
    }

    public static final int access$getSwitch$cp() {
        return Role.Switch;
    }

    public static final int access$getTab$cp() {
        return Role.Tab;
    }

    public static final androidx.compose.ui.semantics.Role box-impl(int i) {
        Role role = new Role(i);
        return role;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof Role) {
            return i3;
        }
        if (i != (Role)object2.unbox-impl()) {
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
        str = Role.equals-impl0(arg0, Role.Button) ? "Button" : equals-impl02 ? "Checkbox" : equals-impl03 ? "Switch" : equals-impl04 ? "RadioButton" : equals-impl05 ? "Tab" : equals-impl06 ? "Image" : equals-impl07 ? "DropdownList" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return Role.equals-impl(this.value, object);
    }

    public int hashCode() {
        return Role.hashCode-impl(this.value);
    }

    public String toString() {
        return Role.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
