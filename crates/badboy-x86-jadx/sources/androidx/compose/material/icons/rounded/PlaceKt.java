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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_place", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Place", "Landroidx/compose/material/icons/Icons$Rounded;", "getPlace", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceKt {

    private static ImageVector _place;
    static {
    }

    public static final ImageVector getPlace(Icons.Rounded $this$Place) {
        if (PlaceKt._place != null) {
            ImageVector _place2 = PlaceKt._place;
            Intrinsics.checkNotNull(_place2);
            return _place2;
        }
        int i4 = 0;
        int i5 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Place", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i3 = 0;
        int i7 = 0;
        int i13 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i13);
        final int i21 = 1065353216;
        int i9 = 0;
        int i11 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i14 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i80 = 0;
        final int i81 = i;
        final ImageVector.Builder builder7 = builder2;
        int $this$_get_Place__u24lambda_u241 = 1094713344;
        builder5.moveTo($this$_get_Place__u24lambda_u241, 1073741824);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1064933786, 0, -1056964608, 1078858875, -1056964608, 1090728755);
        builder6.curveToRelative(0, 1078691103, 1075629261, 1088254116, 1089134920, 1093905940);
        builder6.curveToRelative(1052938076, 1051260355, 1064514355, 1051260355, 1068121457, 0);
        builder6.curveTo(1099720294, 1099494851, 1101004800, 1096160379, 1101004800, 1092825907);
        builder6.curveTo(1101004800, 1084688957, 1099012506, 1073741824, 1094713344, 1073741824);
        PathBuilder builder = builder6;
        builder.close();
        builder.moveTo($this$_get_Place__u24lambda_u241, $this$_get_Place__u24lambda_u241);
        int i77 = -1073741824;
        builder6.curveToRelative(-1081291571, 0, -1073741824, -1083808154, -1073741824, i77);
        int i70 = 1073741824;
        builder6.curveToRelative(0, -1081291571, 1063675494, -1073741824, i70, i77);
        builder6.curveToRelative(1066192077, 0, 1073741824, 1063675494, i70, 1073741824);
        builder6.curveTo(1096810496, 1093769626, 1095866778, 1094713344, 1094713344, 1094713344);
        builder6.close();
        PlaceKt._place = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i13, 1065353216, i21, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i21, 0, 0, 0, 14336, 0).build();
        ImageVector _place3 = PlaceKt._place;
        Intrinsics.checkNotNull(_place3);
        return _place3;
    }
}
