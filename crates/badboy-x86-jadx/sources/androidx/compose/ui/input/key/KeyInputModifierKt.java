package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\u0006", d2 = {"onKeyEvent", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyInputModifierKt {
    public static final Modifier onKeyEvent(Modifier $this$onKeyEvent, Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onKeyEvent) {
        KeyInputElement keyInputElement = new KeyInputElement(onKeyEvent, 0);
        return $this$onKeyEvent.then((Modifier)keyInputElement);
    }

    public static final Modifier onPreviewKeyEvent(Modifier $this$onPreviewKeyEvent, Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onPreviewKeyEvent) {
        KeyInputElement keyInputElement = new KeyInputElement(0, onPreviewKeyEvent);
        return $this$onPreviewKeyEvent.then((Modifier)keyInputElement);
    }
}
