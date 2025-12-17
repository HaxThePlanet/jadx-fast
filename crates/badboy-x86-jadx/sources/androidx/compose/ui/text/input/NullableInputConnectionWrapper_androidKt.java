package androidx.compose.ui.text.input;

import android.os.Build.VERSION;
import android.view.inputmethod.InputConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\u0007", d2 = {"NullableInputConnectionWrapper", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NullableInputConnectionWrapper_androidKt {
    public static final androidx.compose.ui.text.input.NullableInputConnectionWrapper NullableInputConnectionWrapper(InputConnection delegate, Function1<? super androidx.compose.ui.text.input.NullableInputConnectionWrapper, Unit> onConnectionClosed) {
        androidx.compose.ui.text.input.NullableInputConnectionWrapperApi25 connection;
        if (Build.VERSION.SDK_INT >= 34) {
            connection = new NullableInputConnectionWrapperApi34(delegate, onConnectionClosed);
        } else {
            connection = new NullableInputConnectionWrapperApi25(delegate, onConnectionClosed);
        }
        return connection;
    }
}
