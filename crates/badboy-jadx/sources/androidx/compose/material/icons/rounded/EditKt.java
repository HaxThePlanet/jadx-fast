package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons.Rounded;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_edit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Edit", "Landroidx/compose/material/icons/Icons$Rounded;", "getEdit", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditKt {

    private static ImageVector _edit;
    static {
    }

    public static final ImageVector getEdit(Icons.Rounded $this$Edit) {
        if (EditKt._edit != null) {
            ImageVector _edit2 = EditKt._edit;
            Intrinsics.checkNotNull(_edit2);
            return _edit2;
        }
        int i13 = 0;
        int i14 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Edit", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i12 = 0;
        int i16 = 0;
        int i22 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i22);
        final int i34 = 1065353216;
        int i18 = 0;
        int i20 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i23 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i70 = 0;
        final int i71 = i;
        final ImageVector.Builder builder7 = builder;
        builder5.moveTo(1077936128, 1099673108);
        int i2 = 1078103900;
        builder5.verticalLineToRelative(i2);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(0, 1049582633, 1046562734, 1056964608, 1056964608, 1056964608);
        PathBuilder builder2 = builder6;
        builder2.horizontalLineToRelative(i2);
        builder6.curveToRelative(1040522936, 0, 1048911544, -1119040307, 1051931443, -1105618534);
        builder2.lineTo(1099856609, 1092553277);
        int i4 = -1066401792;
        builder2.lineToRelative(i4, i4);
        builder2.lineTo(1078565274, 1099484365);
        builder6.curveToRelative(-1110651699, 1036831949, -1105618534, 1046562734, -1105618534, 1052266988);
        builder2.close();
        builder2.moveTo(1101377044, 1088505774);
        int i46 = -1094210028;
        builder6.curveToRelative(1053273620, i46, 1053273620, -1081962660, 0, -1078691103);
        int i7 = -1072315761;
        builder2.lineToRelative(i7, i7);
        builder6.curveToRelative(-1094210028, i46, -1081962660, -1094210028, -1078691103, 0);
        int i30 = 1072315761;
        builder2.lineToRelative(-1075167887, i30);
        int i9 = 1081081856;
        builder2.lineToRelative(i9, i9);
        builder2.lineToRelative(i30, -1075167887);
        builder2.close();
        EditKt._edit = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i22, 1065353216, i34, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i34, 0, 0, 0, 14336, 0).build();
        ImageVector _edit3 = EditKt._edit;
        Intrinsics.checkNotNull(_edit3);
        return _edit3;
    }
}
