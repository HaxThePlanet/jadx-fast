package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.node.Owner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005J?\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112'\u0010\u0012\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\u0002\u0008\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0003R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "", "initialInterceptor", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "parent", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;)V", "<set-?>", "interceptor", "getInterceptor", "()Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "setInterceptor", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;)V", "interceptor$delegate", "Landroidx/compose/runtime/MutableState;", "textInputSession", "", "owner", "Landroidx/compose/ui/node/Owner;", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/node/Owner;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInterceptor", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ChainedPlatformTextInputInterceptor {

    private final MutableState interceptor$delegate;
    private final androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor parent;
    public ChainedPlatformTextInputInterceptor(androidx.compose.ui.platform.PlatformTextInputInterceptor initialInterceptor, androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor parent) {
        super();
        this.parent = parent;
        int i = 0;
        this.interceptor$delegate = SnapshotStateKt.mutableStateOf$default(initialInterceptor, i, 2, i);
    }

    public static final androidx.compose.ui.platform.PlatformTextInputInterceptor access$getInterceptor(androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor $this) {
        return $this.getInterceptor();
    }

    private final androidx.compose.ui.platform.PlatformTextInputInterceptor getInterceptor() {
        final int i = 0;
        final int i2 = 0;
        return (PlatformTextInputInterceptor)(State)this.interceptor$delegate.getValue();
    }

    private final void setInterceptor(androidx.compose.ui.platform.PlatformTextInputInterceptor <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.interceptor$delegate.setValue(<set-?>);
    }

    public final Object textInputSession(Owner owner, Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function22, Continuation<?> continuation3) {
        boolean anon2;
        int i2;
        int i3;
        androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor label;
        androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor parent;
        androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.textInputSession.2 anon;
        int i;
        Object obj7;
        Object obj9;
        anon2 = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof ChainedPlatformTextInputInterceptor.textInputSession.1 && label2 &= i3 != 0) {
            anon2 = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon2.label = obj9 -= i3;
            } else {
                anon2 = new ChainedPlatformTextInputInterceptor.textInputSession.1(this, continuation3);
            }
        } else {
        }
        obj9 = anon2.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                label = this;
                anon = new ChainedPlatformTextInputInterceptor.textInputSession.2(function22, label, 0);
                anon2.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj9);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        obj7 = new KotlinNothingValueException();
        throw obj7;
    }

    public final void updateInterceptor(androidx.compose.ui.platform.PlatformTextInputInterceptor interceptor) {
        setInterceptor(interceptor);
    }
}
