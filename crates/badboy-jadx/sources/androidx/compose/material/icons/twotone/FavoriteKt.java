package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons.TwoTone;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_favorite", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Favorite", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFavorite", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FavoriteKt {

    private static ImageVector _favorite;
    static {
    }

    public static final ImageVector getFavorite(Icons.TwoTone $this$Favorite) {
        if (FavoriteKt._favorite != null) {
            ImageVector _favorite2 = FavoriteKt._favorite;
            Intrinsics.checkNotNull(_favorite2);
            return _favorite2;
        }
        int i8 = 0;
        int i10 = 0;
        ImageVector.Builder builder4 = new ImageVector.Builder("TwoTone.Favorite", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i7 = 0;
        int i12 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        final int i40 = 0;
        final int i43 = 1065353216;
        final int i44 = 1065353216;
        int i17 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i27 = 0;
        PathBuilder builder9 = pathBuilder2;
        int i160 = 0;
        final int i161 = i;
        builder9.moveTo(1099169792, 1084227584);
        PathBuilder builder10 = builder9;
        builder10.curveToRelative(-1077600584, 0, -1069379748, 1065185444, -1067198710, 1075251773);
        PathBuilder builder = builder10;
        builder.horizontalLineToRelative(-1074832343);
        builder10.curveTo(1093182423, 1086303764, 1091609559, 1084227584, 1089470464, 1084227584);
        builder10.curveTo(1085276160, 1084227584, 1082130432, 1087373312, 1082130432, 1091043328);
        builder10.curveToRelative(0, 1077474755, 1078523331, 1085779476, 1090309325, 1092668621);
        int i3 = 1036831949;
        builder.lineToRelative(i3, i3);
        builder.lineToRelative(1036831949, -1110651699);
        builder10.curveTo(1099358536, 1097062154, 1101004800, 1094073713, 1101004800, 1091043328);
        int i52 = 0;
        builder10.curveToRelative(i52, -1073741824, -1077936128, -1067450368, -1067450368, -1067450368);
        builder10.close();
        int i71 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder4, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1050253722, i40, 1050253722, i43, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i44, 0, i52, i71, 14336, 0);
        ImageVector.Builder builder2 = builder13;
        int i5 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), 0, 0);
        int i9 = 0;
        int i13 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i19 = 0;
        PathBuilder builder6 = pathBuilder;
        int i28 = 0;
        ImageVector.Builder builder12 = builder2;
        builder6.moveTo(1099169792, 1077936128);
        PathBuilder builder11 = builder6;
        builder11.curveToRelative(-1075922862, i71, -1067827855, 1062165545, -1064304640, 1074119311);
        builder11.curveTo(1093570396, 1081333514, 1091819274, 1077936128, 1089470464, 1077936128);
        builder11.curveTo(1083011236, 1077936128, 1073741824, 1085108388, 1073741824, 1091043328);
        builder11.curveToRelative(0, 1081207685, 1079613850, 1088128287, 1091095757, 1094230999);
        PathBuilder builder3 = builder11;
        builder3.lineTo(1094713344, 1101712589);
        builder3.lineToRelative(1069128090, -1079446077);
        builder11.curveTo(1100270797, 1098236559, 1102053376, 1095006945, 1102053376, 1091043328);
        builder11.curveTo(1102053376, 1085108388, 1100784599, 1077936128, 1099169792, 1077936128);
        builder3.close();
        builder3.moveTo(1094818202, 1100244582);
        int i23 = -1110651699;
        builder3.lineToRelative(i23, 1036831949);
        builder3.lineToRelative(i23, i23);
        builder11.curveTo(1088715489, 1097062154, 1082130432, 1094073713, 1082130432, 1091043328);
        builder11.curveTo(1082130432, 1087373312, 1085276160, 1084227584, 1089470464, 1084227584);
        builder11.curveToRelative(1069883064, 0, 1078103900, 1065185444, 1080326881, 1075251773);
        builder3.horizontalLineToRelative(1072651305);
        builder11.curveTo(1096244265, 1086303764, 1097817129, 1084227584, 1099169792, 1084227584);
        builder11.curveToRelative(1073741824, 0, 1080033280, 1069547520, 1080033280, 1080033280);
        int i64 = 0;
        builder11.curveToRelative(i64, 1077474755, -1068960317, 1085779476, -1057174323, 1092668621);
        builder11.close();
        FavoriteKt._favorite = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i40, 1065353216, i43, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i44, 0, i64, 0, 14336, 0).build();
        ImageVector _favorite3 = FavoriteKt._favorite;
        Intrinsics.checkNotNull(_favorite3);
        return _favorite3;
    }
}
