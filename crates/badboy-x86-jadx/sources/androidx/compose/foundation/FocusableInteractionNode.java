package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction.Focus;
import androidx.compose.foundation.interaction.FocusInteraction.Unfocus;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J\u000e\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u0008J\u0010\u0010\u000f\u001a\u00020\u000c2\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u0010\u001a\u00020\u000c*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/FocusableInteractionNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "focusedInteraction", "Landroidx/compose/foundation/interaction/FocusInteraction$Focus;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "disposeInteractionSource", "", "setFocus", "isFocused", "update", "emitWithFallback", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusableInteractionNode extends Modifier.Node {

    private FocusInteraction.Focus focusedInteraction;
    private MutableInteractionSource interactionSource;
    private final boolean shouldAutoInvalidate;
    public FocusableInteractionNode(MutableInteractionSource interactionSource) {
        super();
        this.interactionSource = interactionSource;
    }

    private final void disposeInteractionSource() {
        int i;
        FocusInteraction.Focus focusedInteraction;
        int i2;
        FocusInteraction.Unfocus unfocus;
        FocusInteraction.Unfocus unfocus2;
        MutableInteractionSource interactionSource = this.interactionSource;
        i = 0;
        focusedInteraction = this.focusedInteraction;
        if (interactionSource != null && focusedInteraction != null) {
            i = 0;
            focusedInteraction = this.focusedInteraction;
            if (focusedInteraction != null) {
                i2 = 0;
                unfocus = new FocusInteraction.Unfocus(focusedInteraction);
                interactionSource.tryEmit((Interaction)unfocus);
            }
        }
        this.focusedInteraction = 0;
    }

    private final void emitWithFallback(MutableInteractionSource $this$emitWithFallback, Interaction interaction) {
        int onCompletion;
        int i4;
        androidx.compose.foundation.FocusableInteractionNode.emitWithFallback.handler.1 coroutineScope;
        int i3;
        int i5;
        androidx.compose.foundation.FocusableInteractionNode.emitWithFallback.1 anon;
        int i2;
        int i;
        if (isAttached()) {
            kotlin.coroutines.CoroutineContext.Element context = getCoroutineScope().getCoroutineContext().get((CoroutineContext.Key)Job.Key);
            i4 = 0;
            if ((Job)context != null) {
                coroutineScope = new FocusableInteractionNode.emitWithFallback.handler.1($this$emitWithFallback, interaction);
                onCompletion = (Job)context.invokeOnCompletion((Function1)coroutineScope);
            } else {
                onCompletion = i4;
            }
            FocusableInteractionNode.emitWithFallback.1 anon2 = new FocusableInteractionNode.emitWithFallback.1($this$emitWithFallback, interaction, onCompletion, i4);
            BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon2, 3, 0);
        } else {
            $this$emitWithFallback.tryEmit(interaction);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFocus(boolean isFocused) {
        int i2;
        FocusInteraction.Focus focus;
        FocusInteraction.Focus focusedInteraction;
        int i;
        FocusInteraction.Unfocus unfocus;
        FocusInteraction.Unfocus unfocus2;
        final MutableInteractionSource interactionSource = this.interactionSource;
        if (interactionSource != null) {
            i2 = 0;
            focus = 0;
            if (isFocused) {
                FocusInteraction.Focus focusedInteraction2 = this.focusedInteraction;
                if (focusedInteraction2 != null) {
                    i = 0;
                    unfocus = new FocusInteraction.Unfocus(focusedInteraction2);
                    emitWithFallback(interactionSource, (Interaction)unfocus);
                    this.focusedInteraction = focus;
                }
                focus = new FocusInteraction.Focus();
                emitWithFallback(interactionSource, (Interaction)focus);
                this.focusedInteraction = focus;
            } else {
                focusedInteraction = this.focusedInteraction;
                if (focusedInteraction != null) {
                    i = 0;
                    unfocus = new FocusInteraction.Unfocus(focusedInteraction);
                    emitWithFallback(interactionSource, (Interaction)unfocus);
                    this.focusedInteraction = focus;
                }
            }
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void update(MutableInteractionSource interactionSource) {
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
    }
}
