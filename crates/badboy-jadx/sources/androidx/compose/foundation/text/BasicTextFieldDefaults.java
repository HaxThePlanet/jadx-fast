package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/text/BasicTextFieldDefaults;", "", "()V", "CursorBrush", "Landroidx/compose/ui/graphics/SolidColor;", "getCursorBrush", "()Landroidx/compose/ui/graphics/SolidColor;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BasicTextFieldDefaults {

    private static final SolidColor CursorBrush;
    public static final androidx.compose.foundation.text.BasicTextFieldDefaults INSTANCE;
    static {
        BasicTextFieldDefaults basicTextFieldDefaults = new BasicTextFieldDefaults();
        BasicTextFieldDefaults.INSTANCE = basicTextFieldDefaults;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj2, 0);
        BasicTextFieldDefaults.CursorBrush = solidColor;
    }

    public final SolidColor getCursorBrush() {
        return BasicTextFieldDefaults.CursorBrush;
    }
}
