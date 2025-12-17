package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons.Filled;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin.Companion;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.ImageVector.Builder;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_arrowForward", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowForward", "Landroidx/compose/material/icons/Icons$Filled;", "getArrowForward$annotations", "(Landroidx/compose/material/icons/Icons$Filled;)V", "getArrowForward", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrowForwardKt {

    private static ImageVector _arrowForward;
    static {
    }

    public static final ImageVector getArrowForward(Icons.Filled $this$ArrowForward) {
        if (ArrowForwardKt._arrowForward != null) {
            ImageVector _arrowForward2 = ArrowForwardKt._arrowForward;
            Intrinsics.checkNotNull(_arrowForward2);
            return _arrowForward2;
        }
        int i17 = 0;
        int i18 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Filled.ArrowForward", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i16 = 0;
        int i20 = 0;
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i26);
        final int i34 = 1065353216;
        int i22 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i27 = 0;
        PathBuilder builder4 = pathBuilder;
        int i36 = 0;
        final int i42 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1094713344, 1082130432);
        builder4.lineToRelative(-1078691103, 1068792545);
        builder4.lineTo(1098996777, 1093664768);
        builder4.horizontalLineTo(1082130432);
        builder4.verticalLineToRelative(1073741824);
        builder4.horizontalLineToRelative(1094891602);
        builder4.lineToRelative(-1062039716, 1085464904);
        builder4.lineTo(1094713344, 1101004800);
        builder4.lineToRelative(1090519040, -1056964608);
        builder4.close();
        ArrowForwardKt._arrowForward = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i26, 1065353216, i34, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i34, 0, 0, 0, 14336, 0).build();
        ImageVector _arrowForward3 = ArrowForwardKt._arrowForward;
        Intrinsics.checkNotNull(_arrowForward3);
        return _arrowForward3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Filled.ArrowForward", replaceWith = @ReplaceWith(...))
    public static void getArrowForward$annotations(Icons.Filled icons$Filled) {
    }
}
