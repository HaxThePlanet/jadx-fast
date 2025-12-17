package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0004J\u000c\u0010\u0012\u001a\u00020\u0004*\u00020\u0013H\u0016R+\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/text/PasswordInputTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "scheduleHide", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "revealCodepointIndex", "getRevealCodepointIndex$foundation_release", "()I", "setRevealCodepointIndex", "(I)V", "revealCodepointIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "getScheduleHide", "()Lkotlin/jvm/functions/Function0;", "hide", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PasswordInputTransformation implements InputTransformation {

    public static final int $stable;
    private final MutableIntState revealCodepointIndex$delegate;
    private final Function0<Unit> scheduleHide;
    static {
    }

    public PasswordInputTransformation(Function0<Unit> scheduleHide) {
        super();
        this.scheduleHide = scheduleHide;
        this.revealCodepointIndex$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
    }

    private final void setRevealCodepointIndex(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.revealCodepointIndex$delegate.setIntValue(<set-?>);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final int getRevealCodepointIndex$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.revealCodepointIndex$delegate.getIntValue();
    }

    public final Function0<Unit> getScheduleHide() {
        return this.scheduleHide;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final void hide() {
        setRevealCodepointIndex(-1);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer $this$transformInput) {
        int changeCount;
        int revealCodepointIndex$foundation_release;
        int i;
        long originalRange--jx7JFs;
        int i2 = 0;
        i = 1;
        if ($this$transformInput.getChanges().getChangeCount() == i && TextRange.getLength-impl($this$transformInput.getChanges().getRange--jx7JFs(i2)) == i && TextRange.getLength-impl($this$transformInput.getChanges().getOriginalRange--jx7JFs(i2)) == 0) {
            if (TextRange.getLength-impl($this$transformInput.getChanges().getRange--jx7JFs(i2)) == i) {
                if (TextRange.getLength-impl($this$transformInput.getChanges().getOriginalRange--jx7JFs(i2)) == 0) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
            if ($this$transformInput.hasSelection()) {
            } else {
                int min-impl = TextRange.getMin-impl($this$transformInput.getChanges().getRange--jx7JFs(i2));
                if (getRevealCodepointIndex$foundation_release() != min-impl) {
                    this.scheduleHide.invoke();
                    setRevealCodepointIndex(min-impl);
                }
            }
        }
        setRevealCodepointIndex(-1);
    }
}
