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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_place", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Place", "Landroidx/compose/material/icons/Icons$Filled;", "getPlace", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceKt {

    private static ImageVector _place;
    static {
    }

    public static final ImageVector getPlace(Icons.Filled $this$Place) {
        if (PlaceKt._place != null) {
            ImageVector _place2 = PlaceKt._place;
            Intrinsics.checkNotNull(_place2);
            return _place2;
        }
        String str = "Filled.Place";
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        int i19 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i19);
        final int i29 = 1065353216;
        int i15 = 0;
        int i17 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i20 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i58 = 0;
        final int i59 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1094713344, 1073741824);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1090655355, 1073741824, 1084227584, 1084500214, 1084227584, 1091567616);
        int i33 = 0;
        builder6.curveToRelative(i33, 1084751872, 1088421888, 1095761920, 1088421888, 1095761920);
        PathBuilder builder = builder6;
        final String str3 = str;
        int name$iv = 1088421888;
        builder.reflectiveCurveToRelative(name$iv, -1057488896, name$iv, -1051721728);
        builder6.curveToRelative(i33, -1065898476, -1069002260, -1059061760, -1059061760, -1059061760);
        builder.close();
        builder.moveTo(1094713344, 1094189056);
        int i39 = 0;
        builder6.curveToRelative(-1078942761, i39, -1071644672, -1081123799, -1071644672, -1071644672);
        int i4 = 1066359849;
        int i7 = -1071644672;
        int i25 = 1075838976;
        builder.reflectiveCurveToRelative(i4, i7, i25, i7);
        builder.reflectiveCurveToRelative(i25, i4, i25, i25);
        builder.reflectiveCurveToRelative(-1081123799, i25, i7, i25);
        builder.close();
        PlaceKt._place = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i19, 1065353216, i29, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i29, 0, 0, i39, 14336, 0).build();
        ImageVector _place3 = PlaceKt._place;
        Intrinsics.checkNotNull(_place3);
        return _place3;
    }
}
