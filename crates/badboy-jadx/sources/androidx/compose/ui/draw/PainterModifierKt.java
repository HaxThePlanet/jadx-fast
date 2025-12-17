package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r¨\u0006\u000e", d2 = {"paint", "Landroidx/compose/ui/Modifier;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PainterModifierKt {
    public static final Modifier paint(Modifier $this$paint, Painter painter, boolean sizeToIntrinsics, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        PainterElement painterElement = new PainterElement(painter, sizeToIntrinsics, alignment, contentScale, alpha, colorFilter);
        return $this$paint.then((Modifier)painterElement);
    }

    public static Modifier paint$default(Modifier modifier, Painter painter2, boolean z3, Alignment alignment4, ContentScale contentScale5, float f6, ColorFilter colorFilter7, int i8, Object object9) {
        int i2;
        Alignment alignment;
        ContentScale contentScale;
        int i;
        int i3;
        int obj9;
        Alignment obj10;
        ContentScale obj11;
        int obj12;
        int obj13;
        i2 = i8 & 2 != 0 ? obj9 : z3;
        if (i8 & 4 != 0) {
            alignment = obj10;
        } else {
            alignment = alignment4;
        }
        if (i8 & 8 != 0) {
            contentScale = obj11;
        } else {
            contentScale = contentScale5;
        }
        i = i8 & 16 != 0 ? obj12 : f6;
        i3 = i8 & 32 != 0 ? obj13 : colorFilter7;
        return PainterModifierKt.paint(modifier, painter2, i2, alignment, contentScale, i, i3);
    }
}
