package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Landroidx/compose/material3/RangeSliderLogic;", "", "state", "Landroidx/compose/material3/RangeSliderState;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getEndInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getStartInteractionSource", "getState", "()Landroidx/compose/material3/RangeSliderState;", "activeInteraction", "draggingStart", "", "captureThumb", "", "posX", "", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "compareOffsets", "", "eventX", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RangeSliderLogic {

    private final MutableInteractionSource endInteractionSource;
    private final MutableInteractionSource startInteractionSource;
    private final androidx.compose.material3.RangeSliderState state;
    public RangeSliderLogic(androidx.compose.material3.RangeSliderState state, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource) {
        super();
        this.state = state;
        this.startInteractionSource = startInteractionSource;
        this.endInteractionSource = endInteractionSource;
    }

    public final MutableInteractionSource activeInteraction(boolean draggingStart) {
        MutableInteractionSource startInteractionSource;
        startInteractionSource = draggingStart ? this.startInteractionSource : this.endInteractionSource;
        return startInteractionSource;
    }

    public final void captureThumb(boolean draggingStart, float posX, Interaction interaction, CoroutineScope scope) {
        float rawOffsetStart$material3_release;
        androidx.compose.material3.RangeSliderState state2 = this.state;
        if (draggingStart) {
            rawOffsetStart$material3_release = state2.getRawOffsetStart$material3_release();
        } else {
            rawOffsetStart$material3_release = state2.getRawOffsetEnd$material3_release();
        }
        this.state.onDrag$material3_release(draggingStart, posX - rawOffsetStart$material3_release);
        RangeSliderLogic.captureThumb.1 anon = new RangeSliderLogic.captureThumb.1(this, draggingStart, interaction, 0);
        BuildersKt.launch$default(scope, 0, 0, (Function2)anon, 3, 0);
    }

    public final int compareOffsets(float eventX) {
        return Float.compare(Math.abs(rawOffsetStart$material3_release -= eventX), Math.abs(rawOffsetEnd$material3_release -= eventX));
    }

    public final MutableInteractionSource getEndInteractionSource() {
        return this.endInteractionSource;
    }

    public final MutableInteractionSource getStartInteractionSource() {
        return this.startInteractionSource;
    }

    public final androidx.compose.material3.RangeSliderState getState() {
        return this.state;
    }
}
