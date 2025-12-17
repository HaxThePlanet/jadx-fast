package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\u0008\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012R1\u0010\t\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00038V@VX\u0096\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/ui/input/InputModeManagerImpl;", "Landroidx/compose/ui/input/InputModeManager;", "initialInputMode", "Landroidx/compose/ui/input/InputMode;", "onRequestInputModeChange", "Lkotlin/Function1;", "", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "inputMode", "getInputMode-aOaMEAU", "()I", "setInputMode-iuPiT84", "(I)V", "inputMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestInputMode", "requestInputMode-iuPiT84", "(I)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InputModeManagerImpl implements androidx.compose.ui.input.InputModeManager {

    public static final int $stable;
    private final MutableState inputMode$delegate;
    private final Function1<androidx.compose.ui.input.InputMode, Boolean> onRequestInputModeChange;
    static {
    }

    private InputModeManagerImpl(int initialInputMode, Function1<? super androidx.compose.ui.input.InputMode, Boolean> onRequestInputModeChange) {
        super();
        this.onRequestInputModeChange = onRequestInputModeChange;
        final int i = 0;
        this.inputMode$delegate = SnapshotStateKt.mutableStateOf$default(InputMode.box-impl(initialInputMode), i, 2, i);
    }

    public InputModeManagerImpl(int i, Function1 function12, DefaultConstructorMarker defaultConstructorMarker3) {
        super(i, function12);
    }

    @Override // androidx.compose.ui.input.InputModeManager
    public int getInputMode-aOaMEAU() {
        final int i = 0;
        final int i2 = 0;
        return (InputMode)(State)this.inputMode$delegate.getValue().unbox-impl();
    }

    @Override // androidx.compose.ui.input.InputModeManager
    public boolean requestInputMode-iuPiT84(int inputMode) {
        return (Boolean)this.onRequestInputModeChange.invoke(InputMode.box-impl(inputMode)).booleanValue();
    }

    @Override // androidx.compose.ui.input.InputModeManager
    public void setInputMode-iuPiT84(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.inputMode$delegate.setValue(InputMode.box-impl(<set-?>));
    }
}
