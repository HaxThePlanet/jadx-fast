package androidx.compose.ui.window;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u000c\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r", d2 = {"Landroidx/compose/ui/window/Api33Impl;", "", "()V", "createBackCallback", "Landroid/window/OnBackInvokedCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "maybeRegisterBackCallback", "view", "Landroid/view/View;", "backCallback", "maybeUnregisterBackCallback", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api33Impl {

    public static final androidx.compose.ui.window.Api33Impl INSTANCE;
    public static void $r8$lambda$QxR1fHW2BVZfkrdJXE2ixZLqD_w(Function0 function0) {
        Api33Impl.createBackCallback$lambda$0(function0);
    }

    static {
        Api33Impl api33Impl = new Api33Impl();
        Api33Impl.INSTANCE = api33Impl;
    }

    @JvmStatic
    public static final OnBackInvokedCallback createBackCallback(Function0<Unit> onDismissRequest) {
        Api33Impl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new Api33Impl$$ExternalSyntheticLambda0(onDismissRequest);
        return externalSyntheticLambda0;
    }

    private static final void createBackCallback$lambda$0(Function0 $onDismissRequest) {
        if ($onDismissRequest != null) {
            $onDismissRequest.invoke();
        }
    }

    @JvmStatic
    public static final void maybeRegisterBackCallback(View view, Object backCallback) {
        boolean onBackInvokedDispatcher;
        Object obj;
        int i;
        onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
        if (backCallback instanceof OnBackInvokedCallback != null && onBackInvokedDispatcher != null) {
            onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcher != null) {
                onBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback)backCallback);
            }
        }
    }

    @JvmStatic
    public static final void maybeUnregisterBackCallback(View view, Object backCallback) {
        boolean onBackInvokedDispatcher;
        Object obj;
        onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
        if (backCallback instanceof OnBackInvokedCallback != null && onBackInvokedDispatcher != null) {
            onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcher != null) {
                onBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback)backCallback);
            }
        }
    }
}
