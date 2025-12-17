package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0014H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/foundation/text/SecureTextFieldController;", "", "obfuscationMaskState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/State;)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "getCodepointTransformation", "()Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "focusChangeModifier", "Landroidx/compose/ui/Modifier;", "getFocusChangeModifier", "()Landroidx/compose/ui/Modifier;", "passwordInputTransformation", "Landroidx/compose/foundation/text/PasswordInputTransformation;", "getPasswordInputTransformation", "()Landroidx/compose/foundation/text/PasswordInputTransformation;", "resetTimerSignal", "Lkotlinx/coroutines/channels/Channel;", "", "observeHideEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleHide", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SecureTextFieldController {

    public static final int $stable = 8;
    private final CodepointTransformation codepointTransformation;
    private final Modifier focusChangeModifier;
    private final State<Character> obfuscationMaskState;
    private final androidx.compose.foundation.text.PasswordInputTransformation passwordInputTransformation;
    private final Channel<Unit> resetTimerSignal;
    public static int $r8$lambda$wjxjT7beRmVJ3_Qp45r4KrJUPx4(androidx.compose.foundation.text.SecureTextFieldController secureTextFieldController, int i2, int i3) {
        return SecureTextFieldController.codepointTransformation$lambda$0(secureTextFieldController, i2, i3);
    }

    static {
        final int i = 8;
    }

    public SecureTextFieldController(State<Character> obfuscationMaskState) {
        super();
        this.obfuscationMaskState = obfuscationMaskState;
        SecureTextFieldController.passwordInputTransformation.1 anon = new SecureTextFieldController.passwordInputTransformation.1(this);
        PasswordInputTransformation passwordInputTransformation = new PasswordInputTransformation((Function0)anon);
        this.passwordInputTransformation = passwordInputTransformation;
        SecureTextFieldController$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SecureTextFieldController$$ExternalSyntheticLambda0(this);
        this.codepointTransformation = externalSyntheticLambda0;
        SecureTextFieldController.focusChangeModifier.1 anon2 = new SecureTextFieldController.focusChangeModifier.1(this);
        this.focusChangeModifier = FocusChangedModifierKt.onFocusChanged((Modifier)Modifier.Companion, (Function1)anon2);
        int i = 0;
        this.resetTimerSignal = ChannelKt.Channel$default(Integer.MAX_VALUE, i, i, 6, i);
    }

    public static final void access$scheduleHide(androidx.compose.foundation.text.SecureTextFieldController $this) {
        $this.scheduleHide();
    }

    private static final int codepointTransformation$lambda$0(androidx.compose.foundation.text.SecureTextFieldController this$0, int codepointIndex, int codepoint) {
        char charValue;
        if (codepointIndex == this$0.passwordInputTransformation.getRevealCodepointIndex$foundation_release()) {
            charValue = codepoint;
        } else {
            charValue = (Character)this$0.obfuscationMaskState.getValue().charValue();
        }
        return charValue;
    }

    private final void scheduleHide() {
        boolean passwordInputTransformation;
        if (ChannelResult.isFailure-impl(this.resetTimerSignal.trySend-JP2dKIU(Unit.INSTANCE))) {
            this.passwordInputTransformation.hide();
        }
    }

    public final CodepointTransformation getCodepointTransformation() {
        return this.codepointTransformation;
    }

    public final Modifier getFocusChangeModifier() {
        return this.focusChangeModifier;
    }

    public final androidx.compose.foundation.text.PasswordInputTransformation getPasswordInputTransformation() {
        return this.passwordInputTransformation;
    }

    public final Object observeHideEvents(Continuation<? super Unit> $completion) {
        SecureTextFieldController.observeHideEvents.2 anon = new SecureTextFieldController.observeHideEvents.2(this, 0);
        Object collectLatest = FlowKt.collectLatest(FlowKt.consumeAsFlow((ReceiveChannel)this.resetTimerSignal), (Function2)anon, $completion);
        if (collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collectLatest;
        }
        return Unit.INSTANCE;
    }
}
