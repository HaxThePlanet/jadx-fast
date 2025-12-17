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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_favoriteBorder", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FavoriteBorder", "Landroidx/compose/material/icons/Icons$Outlined;", "getFavoriteBorder", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FavoriteBorderKt {

    private static ImageVector _favoriteBorder;
    static {
    }

    public static final ImageVector getFavoriteBorder(Icons.Outlined $this$FavoriteBorder) {
        if (FavoriteBorderKt._favoriteBorder != null) {
            ImageVector _favoriteBorder2 = FavoriteBorderKt._favoriteBorder;
            Intrinsics.checkNotNull(_favoriteBorder2);
            return _favoriteBorder2;
        }
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.FavoriteBorder", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i15 = 0;
        int i17 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i20 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i109 = 0;
        final int i110 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1099169792, 1077936128);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1075922862, 0, -1067827855, 1062165545, -1064304640, 1074119311);
        builder6.curveTo(1093570396, 1081333514, 1091819274, 1077936128, 1089470464, 1077936128);
        builder6.curveTo(1083011236, 1077936128, 1073741824, 1085108388, 1073741824, 1091043328);
        builder6.curveToRelative(0, 1081207685, 1079613850, 1088128287, 1091095757, 1094230999);
        PathBuilder builder = builder6;
        builder.lineTo(1094713344, 1101712589);
        builder.lineToRelative(1069128090, -1079446077);
        builder6.curveTo(1100270797, 1098236559, 1102053376, 1095006945, 1102053376, 1091043328);
        builder6.curveTo(1102053376, 1085108388, 1100784599, 1077936128, 1099169792, 1077936128);
        builder.close();
        builder.moveTo(1094818202, 1100244582);
        builder.lineToRelative(-1110651699, 1036831949);
        int i6 = -1110651699;
        builder.lineToRelative(i6, i6);
        builder6.curveTo(1088715489, 1097062154, 1082130432, 1094073713, 1082130432, 1091043328);
        builder6.curveTo(1082130432, 1087373312, 1085276160, 1084227584, 1089470464, 1084227584);
        builder6.curveToRelative(1069883064, 0, 1078103900, 1065185444, 1080326881, 1075251773);
        builder.horizontalLineToRelative(1072651305);
        builder6.curveTo(1096244265, 1086303764, 1097817129, 1084227584, 1099169792, 1084227584);
        builder6.curveToRelative(1073741824, 0, 1080033280, 1069547520, 1080033280, 1080033280);
        int i45 = 0;
        builder6.curveToRelative(i45, 1077474755, -1068960317, 1085779476, -1057174323, 1092668621);
        builder6.close();
        FavoriteBorderKt._favoriteBorder = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, i45, 0, 14336, 0).build();
        ImageVector _favoriteBorder3 = FavoriteBorderKt._favoriteBorder;
        Intrinsics.checkNotNull(_favoriteBorder3);
        return _favoriteBorder3;
    }
}
