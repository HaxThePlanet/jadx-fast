package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006", d2 = {"nestedScroll", "Landroidx/compose/ui/Modifier;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NestedScrollModifierKt {
    public static final Modifier nestedScroll(Modifier $this$nestedScroll, androidx.compose.ui.input.nestedscroll.NestedScrollConnection connection, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher dispatcher) {
        NestedScrollElement nestedScrollElement = new NestedScrollElement(connection, dispatcher);
        return $this$nestedScroll.then((Modifier)nestedScrollElement);
    }

    public static Modifier nestedScroll$default(Modifier modifier, androidx.compose.ui.input.nestedscroll.NestedScrollConnection nestedScrollConnection2, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher nestedScrollDispatcher3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return NestedScrollModifierKt.nestedScroll(modifier, nestedScrollConnection2, obj2);
    }
}
