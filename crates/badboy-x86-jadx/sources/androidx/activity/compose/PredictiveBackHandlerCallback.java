package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00127\u0010\u0006\u001a3\u0008\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007¢\u0006\u0002\u0010\u0010J\u0008\u0010\u001d\u001a\u00020\u000eH\u0016J\u0008\u0010\u001e\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\tH\u0016J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003RM\u0010\u0006\u001a3\u0008\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001c¨\u0006#", d2 = {"Landroidx/activity/compose/PredictiveBackHandlerCallback;", "Landroidx/activity/OnBackPressedCallback;", "enabled", "", "onBackScope", "Lkotlinx/coroutines/CoroutineScope;", "currentOnBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "", "(ZLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)V", "getCurrentOnBack", "()Lkotlin/jvm/functions/Function2;", "setCurrentOnBack", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "isActive", "onBackInstance", "Landroidx/activity/compose/OnBackInstance;", "getOnBackScope", "()Lkotlinx/coroutines/CoroutineScope;", "setOnBackScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "handleOnBackCancelled", "handleOnBackPressed", "handleOnBackProgressed", "backEvent", "handleOnBackStarted", "setIsEnabled", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PredictiveBackHandlerCallback extends OnBackPressedCallback {

    private Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> currentOnBack;
    private boolean isActive;
    private androidx.activity.compose.OnBackInstance onBackInstance;
    private CoroutineScope onBackScope;
    public PredictiveBackHandlerCallback(boolean enabled, CoroutineScope onBackScope, Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> currentOnBack) {
        super(enabled);
        this.onBackScope = onBackScope;
        this.currentOnBack = currentOnBack;
    }

    public final Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> getCurrentOnBack() {
        return this.currentOnBack;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final CoroutineScope getOnBackScope() {
        return this.onBackScope;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackCancelled() {
        super.handleOnBackCancelled();
        androidx.activity.compose.OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            onBackInstance.cancel();
        }
        androidx.activity.compose.OnBackInstance onBackInstance2 = this.onBackInstance;
        final int i = 0;
        if (onBackInstance2 == null) {
        } else {
            onBackInstance2.setPredictiveBack(i);
        }
        this.isActive = i;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        androidx.activity.compose.OnBackInstance onBackInstance;
        int i;
        boolean predictiveBack;
        Function2 currentOnBack;
        Object obj;
        androidx.activity.compose.OnBackInstance onBackInstance2 = this.onBackInstance;
        i = 0;
        if (onBackInstance2 != null && !onBackInstance2.isPredictiveBack()) {
            i = 0;
            if (!onBackInstance2.isPredictiveBack()) {
                onBackInstance2.cancel();
                this.onBackInstance = 0;
            }
        }
        int i2 = 0;
        if (this.onBackInstance == null) {
            onBackInstance = new OnBackInstance(this.onBackScope, i2, this.currentOnBack, (OnBackPressedCallback)this);
            this.onBackInstance = onBackInstance;
        }
        androidx.activity.compose.OnBackInstance onBackInstance3 = this.onBackInstance;
        if (onBackInstance3 != null) {
            onBackInstance3.close();
        }
        androidx.activity.compose.OnBackInstance onBackInstance4 = this.onBackInstance;
        if (onBackInstance4 == null) {
        } else {
            onBackInstance4.setPredictiveBack(i2);
        }
        this.isActive = i2;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackProgressed(BackEventCompat backEvent) {
        Object onBackInstance;
        super.handleOnBackProgressed(backEvent);
        onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            ChannelResult.box-impl(onBackInstance.send-JP2dKIU(backEvent));
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackStarted(BackEventCompat backEvent) {
        boolean onBackInstance;
        CoroutineScope onBackScope;
        Function2 currentOnBack;
        Object obj;
        super.handleOnBackStarted(backEvent);
        androidx.activity.compose.OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.cancel();
        }
        final int i = 1;
        if (isEnabled()) {
            onBackInstance = new OnBackInstance(this.onBackScope, i, this.currentOnBack, (OnBackPressedCallback)this);
            this.onBackInstance = onBackInstance;
        }
        this.isActive = i;
    }

    public final void setCurrentOnBack(Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> <set-?>) {
        this.currentOnBack = <set-?>;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void setIsEnabled(boolean enabled) {
        boolean onBackInstance;
        onBackInstance = this.onBackInstance;
        if (!enabled && !this.isActive && isEnabled() && onBackInstance != null) {
            if (!this.isActive) {
                if (isEnabled()) {
                    onBackInstance = this.onBackInstance;
                    if (onBackInstance != null) {
                        onBackInstance.cancel();
                    }
                }
            }
        }
        setEnabled(enabled);
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void setOnBackScope(CoroutineScope <set-?>) {
        this.onBackScope = <set-?>;
    }
}
