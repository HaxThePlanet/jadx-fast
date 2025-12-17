package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons.Sharp;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_place", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Place", "Landroidx/compose/material/icons/Icons$Sharp;", "getPlace", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceKt {

    private static ImageVector _place;
    static {
    }

    public static final ImageVector getPlace(Icons.Sharp $this$Place) {
        if (PlaceKt._place != null) {
            ImageVector _place2 = PlaceKt._place;
            Intrinsics.checkNotNull(_place2);
            return _place2;
        }
        String str = "Sharp.Place";
        int i7 = 0;
        int i8 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i6 = 0;
        int i10 = 0;
        int i16 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i16);
        final int i24 = 1065353216;
        int i12 = 0;
        int i14 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i17 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i59 = 0;
        final int i60 = i;
        int $i$f$materialIcon = 1094713344;
        builder4.moveTo($i$f$materialIcon, $i$f$materialIcon);
        int i33 = 0;
        PathBuilder builder5 = builder4;
        builder5.curveToRelative(-1081291571, i33, -1073741824, -1083808154, -1073741824, -1073741824);
        int i2 = 1063675494;
        final ImageVector.Builder builder6 = builder;
        int $this$_get_Place__u24lambda_u241 = -1073741824;
        final String str3 = str;
        int name$iv = 1073741824;
        builder4.reflectiveCurveToRelative(i2, $this$_get_Place__u24lambda_u241, name$iv, $this$_get_Place__u24lambda_u241);
        builder4.reflectiveCurveToRelative(name$iv, i2, name$iv, name$iv);
        builder4.reflectiveCurveToRelative(-1083808154, name$iv, $this$_get_Place__u24lambda_u241, name$iv);
        builder4.close();
        builder4.moveTo(1094713344, name$iv);
        builder5.curveToRelative(-1064933786, i33, -1056964608, 1078858875, -1056964608, 1090728755);
        int i52 = 1090519040;
        builder5.curveToRelative(0, 1079278305, 1076552008, 1088946176, i52, 1094503629);
        builder5.curveToRelative(1084919644, -1064199782, 1090519040, -1056461292, i52, -1052980019);
        builder5.curveTo(1101004800, 1084688957, 1099012506, 1073741824, 1094713344, 1073741824);
        builder5.close();
        PlaceKt._place = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i16, 1065353216, i24, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i24, 0, 0, 0, 14336, 0).build();
        ImageVector _place3 = PlaceKt._place;
        Intrinsics.checkNotNull(_place3);
        return _place3;
    }
}
