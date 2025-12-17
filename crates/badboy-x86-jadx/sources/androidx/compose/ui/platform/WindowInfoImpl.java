package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR0\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8W@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/platform/WindowInfo;", "()V", "_isWindowFocused", "Landroidx/compose/runtime/MutableState;", "", "value", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A$annotations", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WindowInfoImpl implements androidx.compose.ui.platform.WindowInfo {

    public static final int $stable;
    public static final androidx.compose.ui.platform.WindowInfoImpl.Companion Companion;
    private static final MutableState<PointerKeyboardModifiers> GlobalKeyboardModifiers;
    private final MutableState<Boolean> _isWindowFocused;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/WindowInfoImpl$Companion;", "", "()V", "GlobalKeyboardModifiers", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getGlobalKeyboardModifiers$ui_release", "()Landroidx/compose/runtime/MutableState;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final MutableState<PointerKeyboardModifiers> getGlobalKeyboardModifiers$ui_release() {
            return WindowInfoImpl.access$getGlobalKeyboardModifiers$cp();
        }
    }
    static {
        final int i2 = 0;
        WindowInfoImpl.Companion companion = new WindowInfoImpl.Companion(i2);
        WindowInfoImpl.Companion = companion;
        WindowInfoImpl.GlobalKeyboardModifiers = SnapshotStateKt.mutableStateOf$default(PointerKeyboardModifiers.box-impl(PointerEvent_androidKt.EmptyPointerKeyboardModifiers()), i2, 2, i2);
    }

    public WindowInfoImpl() {
        super();
        final int i2 = 0;
        this._isWindowFocused = SnapshotStateKt.mutableStateOf$default(false, i2, 2, i2);
    }

    public static final MutableState access$getGlobalKeyboardModifiers$cp() {
        return WindowInfoImpl.GlobalKeyboardModifiers;
    }

    public static void getKeyboardModifiers-k7X9c1A$annotations() {
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public int getKeyboardModifiers-k7X9c1A() {
        return (PointerKeyboardModifiers)WindowInfoImpl.GlobalKeyboardModifiers.getValue().unbox-impl();
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public boolean isWindowFocused() {
        return (Boolean)this._isWindowFocused.getValue().booleanValue();
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public void setKeyboardModifiers-5xRPYO0(int value) {
        WindowInfoImpl.GlobalKeyboardModifiers.setValue(PointerKeyboardModifiers.box-impl(value));
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public void setWindowFocused(boolean value) {
        this._isWindowFocused.setValue(Boolean.valueOf(value));
    }
}
