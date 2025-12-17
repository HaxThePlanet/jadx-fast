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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_place", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Place", "Landroidx/compose/material/icons/Icons$Outlined;", "getPlace", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceKt {

    private static ImageVector _place;
    static {
    }

    public static final ImageVector getPlace(Icons.Outlined $this$Place) {
        if (PlaceKt._place != null) {
            ImageVector _place2 = PlaceKt._place;
            Intrinsics.checkNotNull(_place2);
            return _place2;
        }
        String str = "Outlined.Place";
        int i13 = 0;
        int i14 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i12 = 0;
        int i16 = 0;
        int i22 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i22);
        final int i30 = 1065353216;
        int i18 = 0;
        int i20 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i23 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i83 = 0;
        final int i84 = i;
        int $i$f$materialIcon = 1094713344;
        builder4.moveTo($i$f$materialIcon, $i$f$materialIcon);
        PathBuilder builder5 = builder4;
        builder5.curveToRelative(-1081291571, 0, -1073741824, -1083808154, -1073741824, -1073741824);
        int i2 = 1063675494;
        final ImageVector.Builder builder6 = builder;
        int $this$_get_Place__u24lambda_u241 = -1073741824;
        final String str3 = str;
        int name$iv = 1073741824;
        builder4.reflectiveCurveToRelative(i2, $this$_get_Place__u24lambda_u241, name$iv, $this$_get_Place__u24lambda_u241);
        builder4.reflectiveCurveToRelative(name$iv, i2, name$iv, name$iv);
        builder4.reflectiveCurveToRelative(-1083808154, name$iv, $this$_get_Place__u24lambda_u241, name$iv);
        builder4.close();
        builder4.moveTo(1099956224, 1092825907);
        builder5.curveTo(1099956224, 1087520113, 1098226074, 1082130432, 1094713344, 1082130432);
        int i10 = -1061158912;
        builder4.reflectiveCurveToRelative(i10, 1076132577, i10, 1086744166);
        int i71 = 1086324736;
        builder5.curveToRelative(0, 1075167887, 1073322394, 1085150331, i71, 1091714417);
        builder5.curveToRelative(1082235290, -1066611507, 1086324736, -1059481190, i71, -1055769231);
        builder4.close();
        builder4.moveTo(1094713344, 1073741824);
        builder5.curveToRelative(1082549862, 0, 1090519040, 1078858875, 1090519040, 1090728755);
        int i73 = -1056964608;
        builder5.curveToRelative(0, 1079278305, -1070931640, 1088946176, i73, 1094503629);
        builder5.curveToRelative(-1062564004, -1064199782, -1056964608, -1056461292, i73, -1052980019);
        builder5.curveTo(1082130432, 1084688957, 1090099610, 1073741824, 1094713344, 1073741824);
        builder5.close();
        PlaceKt._place = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i22, 1065353216, i30, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i30, 0, 0, 0, 14336, 0).build();
        ImageVector _place3 = PlaceKt._place;
        Intrinsics.checkNotNull(_place3);
        return _place3;
    }
}
