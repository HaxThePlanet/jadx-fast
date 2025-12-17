package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u000c\u0010\u0008\u001a\u00020\t*\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"DebugChanges", "", "DefaultDensity", "Landroidx/compose/ui/unit/Density;", "add", "", "Landroidx/compose/ui/node/LayoutNode;", "child", "requireOwner", "Landroidx/compose/ui/node/Owner;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutNodeKt {

    private static final boolean DebugChanges = false;
    private static final Density DefaultDensity;
    static {
        LayoutNodeKt.DefaultDensity = DensityKt.Density$default(1065353216, 0, 2, 0);
    }

    public static final Density access$getDefaultDensity$p() {
        return LayoutNodeKt.DefaultDensity;
    }

    public static final void add(androidx.compose.ui.node.LayoutNode $this$add, androidx.compose.ui.node.LayoutNode child) {
        $this$add.insertAt$ui_release($this$add.getChildren$ui_release().size(), child);
    }

    public static final androidx.compose.ui.node.Owner requireOwner(androidx.compose.ui.node.LayoutNode $this$requireOwner) {
        final androidx.compose.ui.node.Owner owner$ui_release = $this$requireOwner.getOwner$ui_release();
        final int i = 0;
        if (owner$ui_release == null) {
        } else {
            return owner$ui_release;
        }
        int i2 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("LayoutNode should be attached to an owner");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
