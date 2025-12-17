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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_dateRange", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DateRange", "Landroidx/compose/material/icons/Icons$Sharp;", "getDateRange", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateRangeKt {

    private static ImageVector _dateRange;
    static {
    }

    public static final ImageVector getDateRange(Icons.Sharp $this$DateRange) {
        if (DateRangeKt._dateRange != null) {
            ImageVector _dateRange2 = DateRangeKt._dateRange;
            Intrinsics.checkNotNull(_dateRange2);
            return _dateRange2;
        }
        int i34 = 0;
        int i35 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.DateRange", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i33 = 0;
        int i37 = 0;
        int i43 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i43);
        final int i51 = 1065353216;
        int i39 = 0;
        int i41 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i44 = 0;
        PathBuilder builder4 = pathBuilder;
        int i53 = 0;
        final int i59 = i;
        final ImageVector.Builder builder5 = builder;
        int $this$_get_DateRange__u24lambda_u241 = 1093664768;
        builder4.moveTo(1091567616, $this$_get_DateRange__u24lambda_u241);
        builder4.lineTo(1088421888, $this$_get_DateRange__u24lambda_u241);
        int i3 = 1073741824;
        builder4.verticalLineToRelative(i3);
        builder4.horizontalLineToRelative(i3);
        builder4.verticalLineToRelative(-1073741824);
        builder4.close();
        builder4.moveTo(1095761920, $this$_get_DateRange__u24lambda_u241);
        int i6 = -1073741824;
        builder4.horizontalLineToRelative(i6);
        int i22 = 1073741824;
        builder4.verticalLineToRelative(i22);
        builder4.horizontalLineToRelative(i22);
        builder4.verticalLineToRelative(i6);
        builder4.close();
        builder4.moveTo(1099431936, 1093664768);
        int i8 = -1073741824;
        builder4.horizontalLineToRelative(i8);
        int i24 = 1073741824;
        builder4.verticalLineToRelative(i24);
        builder4.horizontalLineToRelative(i24);
        builder4.verticalLineToRelative(i8);
        builder4.close();
        builder4.moveTo(1101529088, 1082130432);
        builder4.horizontalLineToRelative(-1069547520);
        int i26 = 1073741824;
        builder4.lineTo(1099956224, i26);
        builder4.horizontalLineToRelative(-1073741824);
        builder4.verticalLineToRelative(i26);
        int i13 = 1090519040;
        builder4.lineTo(i13, 1082130432);
        int i28 = 1073741824;
        builder4.lineTo(i13, i28);
        builder4.lineTo(1086324736, i28);
        builder4.verticalLineToRelative(i28);
        int i29 = 1082130432;
        builder4.lineTo(1077936128, i29);
        int i16 = 1099956224;
        builder4.verticalLineToRelative(i16);
        builder4.horizontalLineToRelative(i16);
        builder4.lineTo(1101529088, i29);
        builder4.close();
        int i30 = 1101004800;
        builder4.moveTo(1100480512, i30);
        int i19 = 1084227584;
        builder4.lineTo(i19, i30);
        builder4.lineTo(i19, 1091567616);
        builder4.horizontalLineToRelative(1096810496);
        builder4.verticalLineToRelative(1093664768);
        builder4.close();
        DateRangeKt._dateRange = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i43, 1065353216, i51, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i51, 0, 0, 0, 14336, 0).build();
        ImageVector _dateRange3 = DateRangeKt._dateRange;
        Intrinsics.checkNotNull(_dateRange3);
        return _dateRange3;
    }
}
