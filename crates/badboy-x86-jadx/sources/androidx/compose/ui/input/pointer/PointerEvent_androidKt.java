package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0010\u0008\n\u0002\u0008\u000b\u001a\r\u0010$\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010%\u001a\u0014\u0010&\u001a\u00020'*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)\u001a\u0014\u0010*\u001a\u00020'*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008+\u0010)\u001a\u001c\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010-\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\u0008.\u0010/\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0004\"\u0015\u0010\u0008\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0004\"\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u0004\"\u0015\u0010\u000c\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0004\"\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0004\"\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0004\"\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0004\"\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0004\"\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0004\"\u0015\u0010\u001c\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0004\"\u0015\u0010 \u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008!\u0010\u0004\"\u0015\u0010\"\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008#\u0010\u0004*\u000c\u0008\u0000\u00100\"\u00020'2\u00020'*\u000c\u0008\u0000\u00101\"\u00020'2\u00020'\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00062", d2 = {"areAnyPressed", "", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getAreAnyPressed-aHzCx-E", "(I)Z", "isAltGraphPressed", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "isAltGraphPressed-5xRPYO0", "isAltPressed", "isAltPressed-5xRPYO0", "isBackPressed", "isBackPressed-aHzCx-E", "isCapsLockOn", "isCapsLockOn-5xRPYO0", "isCtrlPressed", "isCtrlPressed-5xRPYO0", "isForwardPressed", "isForwardPressed-aHzCx-E", "isFunctionPressed", "isFunctionPressed-5xRPYO0", "isMetaPressed", "isMetaPressed-5xRPYO0", "isNumLockOn", "isNumLockOn-5xRPYO0", "isPrimaryPressed", "isPrimaryPressed-aHzCx-E", "isScrollLockOn", "isScrollLockOn-5xRPYO0", "isSecondaryPressed", "isSecondaryPressed-aHzCx-E", "isShiftPressed", "isShiftPressed-5xRPYO0", "isSymPressed", "isSymPressed-5xRPYO0", "isTertiaryPressed", "isTertiaryPressed-aHzCx-E", "EmptyPointerKeyboardModifiers", "()I", "indexOfFirstPressed", "", "indexOfFirstPressed-aHzCx-E", "(I)I", "indexOfLastPressed", "indexOfLastPressed-aHzCx-E", "isPressed", "buttonIndex", "isPressed-bNIWhpI", "(II)Z", "NativePointerButtons", "NativePointerKeyboardModifiers", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointerEvent_androidKt {
    public static final int EmptyPointerKeyboardModifiers() {
        return PointerKeyboardModifiers.constructor-impl(0);
    }

    public static final boolean getAreAnyPressed-aHzCx-E(int $this$areAnyPressed) {
        int i;
        i = $this$areAnyPressed != 0 ? 1 : 0;
        return i;
    }

    public static final int indexOfFirstPressed-aHzCx-E(int $this$indexOfFirstPressed_u2daHzCx_u2dE) {
        int index;
        int shifted;
        int i;
        if ($this$indexOfFirstPressed_u2daHzCx_u2dE == 0) {
            return -1;
        }
        index = 0;
        i4 |= i;
        while (shifted & 1 == 0) {
            index++;
            shifted >>>= 1;
        }
        return index;
    }

    public static final int indexOfLastPressed-aHzCx-E(int $this$indexOfLastPressed_u2daHzCx_u2dE) {
        int shifted;
        int index;
        i2 |= i3;
        index = -1;
        while (shifted != 0) {
            index++;
            shifted >>>= 1;
        }
        return index;
    }

    public static final boolean isAltGraphPressed-5xRPYO0(int $this$isAltGraphPressed) {
        return 0;
    }

    public static final boolean isAltPressed-5xRPYO0(int $this$isAltPressed) {
        int i;
        i = $this$isAltPressed & 2 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isBackPressed-aHzCx-E(int $this$isBackPressed) {
        int i;
        i = $this$isBackPressed & 8 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isCapsLockOn-5xRPYO0(int $this$isCapsLockOn) {
        int i;
        i = i2 &= $this$isCapsLockOn != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isCtrlPressed-5xRPYO0(int $this$isCtrlPressed) {
        int i;
        i = $this$isCtrlPressed & 4096 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isForwardPressed-aHzCx-E(int $this$isForwardPressed) {
        int i;
        i = $this$isForwardPressed & 16 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isFunctionPressed-5xRPYO0(int $this$isFunctionPressed) {
        int i;
        i = $this$isFunctionPressed & 8 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isMetaPressed-5xRPYO0(int $this$isMetaPressed) {
        int i;
        i = i2 &= $this$isMetaPressed != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNumLockOn-5xRPYO0(int $this$isNumLockOn) {
        int i;
        i = i2 &= $this$isNumLockOn != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isPressed-bNIWhpI(int $this$isPressed_u2dbNIWhpI, int buttonIndex) {
        int primaryPressed-aHzCx-E;
        int i;
        primaryPressed-aHzCx-E = 0;
        final int i2 = 1;
        switch (buttonIndex) {
            case 0:
                primaryPressed-aHzCx-E = PointerEvent_androidKt.isPrimaryPressed-aHzCx-E($this$isPressed_u2dbNIWhpI);
                break;
            case 1:
                primaryPressed-aHzCx-E = PointerEvent_androidKt.isSecondaryPressed-aHzCx-E($this$isPressed_u2dbNIWhpI);
                break;
            case 2:
                primaryPressed-aHzCx-E = i2;
                break;
            default:
                primaryPressed-aHzCx-E = i2;
        }
        return primaryPressed-aHzCx-E;
    }

    public static final boolean isPrimaryPressed-aHzCx-E(int $this$isPrimaryPressed) {
        int i;
        i = $this$isPrimaryPressed & 33 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isScrollLockOn-5xRPYO0(int $this$isScrollLockOn) {
        int i;
        i = i2 &= $this$isScrollLockOn != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isSecondaryPressed-aHzCx-E(int $this$isSecondaryPressed) {
        int i;
        i = $this$isSecondaryPressed & 66 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isShiftPressed-5xRPYO0(int $this$isShiftPressed) {
        int i;
        i = $this$isShiftPressed & 1 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isSymPressed-5xRPYO0(int $this$isSymPressed) {
        int i;
        i = $this$isSymPressed & 4 != 0 ? 1 : 0;
        return i;
    }

    public static final boolean isTertiaryPressed-aHzCx-E(int $this$isTertiaryPressed) {
        int i;
        i = $this$isTertiaryPressed & 4 != 0 ? 1 : 0;
        return i;
    }
}
