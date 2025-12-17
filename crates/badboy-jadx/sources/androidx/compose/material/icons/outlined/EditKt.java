package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons.Outlined;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_edit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Edit", "Landroidx/compose/material/icons/Icons$Outlined;", "getEdit", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditKt {

    private static ImageVector _edit;
    static {
    }

    public static final ImageVector getEdit(Icons.Outlined $this$Edit) {
        if (EditKt._edit != null) {
            ImageVector _edit2 = EditKt._edit;
            Intrinsics.checkNotNull(_edit2);
            return _edit2;
        }
        int i23 = 0;
        int i24 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.Edit", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i22 = 0;
        int i26 = 0;
        int i32 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i32);
        final int i44 = 1065353216;
        int i28 = 0;
        int i30 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i33 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i69 = 0;
        final int i70 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1096873411, 1091588588);
        int i2 = 1064011039;
        builder5.lineToRelative(i2, i2);
        int i8 = 1100480512;
        builder5.lineTo(1086156964, i8);
        builder5.lineTo(1084227584, i8);
        builder5.verticalLineToRelative(-1083472609);
        builder5.lineToRelative(1091630531, -1055853117);
        builder5.moveTo(1099777966, 1077936128);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1098907648, 0, -1090351268, 1036831949, -1087163597, 1049918177);
        PathBuilder builder = builder6;
        int i37 = -1075167887;
        builder.lineToRelative(i37, 1072315761);
        int i12 = 1081081856;
        builder.lineToRelative(i12, i12);
        builder.lineToRelative(1072315761, i37);
        builder6.curveToRelative(1053273620, -1094210028, 1053273620, -1081962660, 0, -1078691103);
        int i14 = -1072315761;
        builder.lineToRelative(i14, i14);
        builder6.curveToRelative(-1102263091, -1102263091, -1092196762, -1097565471, -1086995825, -1097565471);
        builder.close();
        builder.moveTo(1096873411, 1086723195);
        int i39 = 1077936128;
        builder.lineTo(i39, 1099563008);
        builder.lineTo(i39, 1101529088);
        builder.horizontalLineToRelative(1081081856);
        builder.lineTo(1099856609, 1092553277);
        int i20 = -1066401792;
        builder.lineToRelative(i20, i20);
        builder.close();
        EditKt._edit = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i32, 1065353216, i44, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i44, 0, 0, 0, 14336, 0).build();
        ImageVector _edit3 = EditKt._edit;
        Intrinsics.checkNotNull(_edit3);
        return _edit3;
    }
}
