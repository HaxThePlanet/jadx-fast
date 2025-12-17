package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000c\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f", d2 = {"Landroidx/compose/ui/node/CanFocusChecker;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "value", "", "canFocus", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "canFocusValue", "Ljava/lang/Boolean;", "isCanFocusSet", "reset", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CanFocusChecker implements FocusProperties {

    public static final androidx.compose.ui.node.CanFocusChecker INSTANCE;
    private static Boolean canFocusValue;
    static {
        CanFocusChecker canFocusChecker = new CanFocusChecker();
        CanFocusChecker.INSTANCE = canFocusChecker;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        Boolean canFocusValue = CanFocusChecker.canFocusValue;
        final int i = 0;
        if (canFocusValue == null) {
        } else {
            return canFocusValue.booleanValue();
        }
        int i2 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("canFocus is read before it is written");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final boolean isCanFocusSet() {
        int i;
        i = CanFocusChecker.canFocusValue != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void reset() {
        CanFocusChecker.canFocusValue = 0;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean value) {
        CanFocusChecker.canFocusValue = Boolean.valueOf(value);
    }
}
