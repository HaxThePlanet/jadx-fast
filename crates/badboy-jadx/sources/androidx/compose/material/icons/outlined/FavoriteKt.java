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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_favorite", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Favorite", "Landroidx/compose/material/icons/Icons$Outlined;", "getFavorite", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FavoriteKt {

    private static ImageVector _favorite;
    static {
    }

    public static final ImageVector getFavorite(Icons.Outlined $this$Favorite) {
        if (FavoriteKt._favorite != null) {
            ImageVector _favorite2 = FavoriteKt._favorite;
            Intrinsics.checkNotNull(_favorite2);
            return _favorite2;
        }
        int i7 = 0;
        int i8 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.Favorite", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i6 = 0;
        int i10 = 0;
        int i16 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i16);
        final int i25 = 1065353216;
        int i12 = 0;
        int i14 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i17 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i67 = 0;
        final int i68 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1094713344, 1101712589);
        builder5.lineToRelative(-1078355558, -1079446077);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1085066445, 1098236559, 1073741824, 1095006945, 1073741824, 1091043328);
        builder6.curveTo(1073741824, 1085108388, 1083011236, 1077936128, 1089470464, 1077936128);
        builder6.curveToRelative(1071560786, 0, 1079655793, 1062165545, 1083179008, 1074119311);
        builder6.curveTo(1095856292, 1081333514, 1097607414, 1077936128, 1099169792, 1077936128);
        builder6.curveTo(1100784599, 1077936128, 1102053376, 1085108388, 1102053376, 1091043328);
        int i33 = 0;
        builder6.curveToRelative(i33, 1081207685, -1067869798, 1088128287, -1056387891, 1094230999);
        PathBuilder builder = builder6;
        builder.lineTo(1094713344, 1101712589);
        builder.close();
        FavoriteKt._favorite = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i16, 1065353216, i25, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i25, 0, i33, 0, 14336, 0).build();
        ImageVector _favorite3 = FavoriteKt._favorite;
        Intrinsics.checkNotNull(_favorite3);
        return _favorite3;
    }
}
