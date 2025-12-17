package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aV\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u0003\"\u0004\u0008\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\u0008\u001a\u0002H\u00032\u0017\u0010\t\u001a\u0013\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\u0008\u000b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000c\u001a^\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u0003\"\u0004\u0008\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\u0008\u001a\u0002H\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\u0008\u000b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000f¨\u0006\u0010", d2 = {"registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "I", "O", "Landroidx/activity/result/ActivityResultCaller;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "callback", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/activity/result/ActivityResultRegistry;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultCallerKt {
    public static void $r8$lambda$ENwgic5h6novaYdTi_z5SNX1ZBE(Function1 function1, Object object2) {
        ActivityResultCallerKt.registerForActivityResult$lambda$0(function1, object2);
    }

    public static void $r8$lambda$p6fMCAr3kK9mRhAhUUFoxiKf_xU(Function1 function1, Object object2) {
        ActivityResultCallerKt.registerForActivityResult$lambda$1(function1, object2);
    }

    public static final <I, O> androidx.activity.result.ActivityResultLauncher<Unit> registerForActivityResult(androidx.activity.result.ActivityResultCaller $this$registerForActivityResult, ActivityResultContract<I, O> contract, I input, androidx.activity.result.ActivityResultRegistry registry, Function1<O, Unit> callback) {
        Intrinsics.checkNotNullParameter($this$registerForActivityResult, "<this>");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ActivityResultCallerKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ActivityResultCallerKt$$ExternalSyntheticLambda0(callback);
        ActivityResultCallerLauncher activityResultCallerLauncher = new ActivityResultCallerLauncher($this$registerForActivityResult.registerForActivityResult(contract, registry, externalSyntheticLambda0), contract, input);
        return (ActivityResultLauncher)activityResultCallerLauncher;
    }

    public static final <I, O> androidx.activity.result.ActivityResultLauncher<Unit> registerForActivityResult(androidx.activity.result.ActivityResultCaller $this$registerForActivityResult, ActivityResultContract<I, O> contract, I input, Function1<O, Unit> callback) {
        Intrinsics.checkNotNullParameter($this$registerForActivityResult, "<this>");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ActivityResultCallerKt$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ActivityResultCallerKt$$ExternalSyntheticLambda1(callback);
        ActivityResultCallerLauncher activityResultCallerLauncher = new ActivityResultCallerLauncher($this$registerForActivityResult.registerForActivityResult(contract, externalSyntheticLambda1), contract, input);
        return (ActivityResultLauncher)activityResultCallerLauncher;
    }

    private static final void registerForActivityResult$lambda$0(Function1 $callback, Object it) {
        $callback.invoke(it);
    }

    private static final void registerForActivityResult$lambda$1(Function1 $callback, Object it) {
        $callback.invoke(it);
    }
}
