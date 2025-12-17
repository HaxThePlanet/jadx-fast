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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_favorite", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Favorite", "Landroidx/compose/material/icons/Icons$Rounded;", "getFavorite", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FavoriteKt {

    private static ImageVector _favorite;
    static {
    }

    public static final ImageVector getFavorite(Icons.Rounded $this$Favorite) {
        if (FavoriteKt._favorite != null) {
            ImageVector _favorite2 = FavoriteKt._favorite;
            Intrinsics.checkNotNull(_favorite2);
            return _favorite2;
        }
        int i6 = 0;
        int i7 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Favorite", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i5 = 0;
        int i9 = 0;
        int i15 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i15);
        final int i24 = 1065353216;
        int i11 = 0;
        int i13 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i16 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i72 = 0;
        final int i73 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1096128922, 1101072957);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1086156964, 1060152279, -1074329027, 1060152279, -1070847754, -1138501878);
        PathBuilder builder = builder6;
        int i20 = -1110651699;
        builder.lineToRelative(-1109309522, i20);
        builder6.curveTo(1084856730, 1098142188, 1072651305, 1094881116, 1073741824, 1090812641);
        builder6.curveToRelative(1031127695, -1076258406, 1064178811, -1068163400, 1075167887, -1064745042);
        int i62 = 1089806008;
        builder6.curveToRelative(1076426179, -1075419546, 1086115021, -1082801521, i62, 1066192077);
        builder6.curveToRelative(1071728558, -1073490166, 1084269527, -1069925007, i62, -1081291571);
        builder6.curveToRelative(1068792545, 1064682127, 1074916229, 1076216463, 1075167887, 1082738606);
        builder6.curveToRelative(1041194025, 1081627116, -1068289229, 1088400916, -1056387891, 1094461686);
        builder.lineToRelative(i20, 1035489772);
        builder.close();
        FavoriteKt._favorite = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i15, 1065353216, i24, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i24, 0, 0, 0, 14336, 0).build();
        ImageVector _favorite3 = FavoriteKt._favorite;
        Intrinsics.checkNotNull(_favorite3);
        return _favorite3;
    }
}
