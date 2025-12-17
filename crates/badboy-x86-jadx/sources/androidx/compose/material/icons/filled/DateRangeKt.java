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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_dateRange", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DateRange", "Landroidx/compose/material/icons/Icons$Filled;", "getDateRange", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateRangeKt {

    private static ImageVector _dateRange;
    static {
    }

    public static final ImageVector getDateRange(Icons.Filled $this$DateRange) {
        if (DateRangeKt._dateRange != null) {
            ImageVector _dateRange2 = DateRangeKt._dateRange;
            Intrinsics.checkNotNull(_dateRange2);
            return _dateRange2;
        }
        int i32 = 0;
        int i33 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Filled.DateRange", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i31 = 0;
        int i35 = 0;
        int i41 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i41);
        final int i54 = 1065353216;
        int i37 = 0;
        int i39 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i42 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i81 = 0;
        final int i82 = i;
        final ImageVector.Builder builder7 = builder2;
        int $this$_get_DateRange__u24lambda_u241 = 1093664768;
        builder5.moveTo(1091567616, $this$_get_DateRange__u24lambda_u241);
        builder5.lineTo(1088421888, $this$_get_DateRange__u24lambda_u241);
        int i3 = 1073741824;
        builder5.verticalLineToRelative(i3);
        builder5.horizontalLineToRelative(i3);
        builder5.verticalLineToRelative(-1073741824);
        builder5.close();
        builder5.moveTo(1095761920, $this$_get_DateRange__u24lambda_u241);
        int i6 = -1073741824;
        builder5.horizontalLineToRelative(i6);
        int i16 = 1073741824;
        builder5.verticalLineToRelative(i16);
        builder5.horizontalLineToRelative(i16);
        builder5.verticalLineToRelative(i6);
        builder5.close();
        builder5.moveTo(1099431936, 1093664768);
        int i8 = -1073741824;
        builder5.horizontalLineToRelative(i8);
        int i18 = 1073741824;
        builder5.verticalLineToRelative(i18);
        builder5.horizontalLineToRelative(i18);
        builder5.verticalLineToRelative(i8);
        builder5.close();
        builder5.moveTo(1100480512, 1082130432);
        builder5.horizontalLineToRelative(-1082130432);
        int i20 = 1073741824;
        builder5.lineTo(1099956224, i20);
        builder5.horizontalLineToRelative(-1073741824);
        builder5.verticalLineToRelative(i20);
        int i13 = 1090519040;
        builder5.lineTo(i13, 1082130432);
        int i22 = 1073741824;
        builder5.lineTo(i13, i22);
        builder5.lineTo(1086324736, i22);
        builder5.verticalLineToRelative(i22);
        builder5.lineTo(1084227584, 1082130432);
        int i79 = 1073741824;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1081207685, 0, -1073825710, 1063675494, -1073825710, i79);
        PathBuilder builder = builder6;
        builder.lineTo(1077936128, 1101004800);
        int i77 = 1073741824;
        builder6.curveToRelative(0, 1066192077, 1063507722, 1073741824, i77, i79);
        builder.horizontalLineToRelative(1096810496);
        int i80 = -1073741824;
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, i77, i80);
        builder.lineTo(1101529088, 1086324736);
        int i60 = 0;
        builder6.curveToRelative(i60, -1081291571, -1083808154, -1073741824, -1073741824, i80);
        builder.close();
        int i49 = 1101004800;
        builder.moveTo(1100480512, i49);
        int i27 = 1084227584;
        builder.lineTo(i27, i49);
        builder.lineTo(i27, 1091567616);
        builder.horizontalLineToRelative(1096810496);
        builder.verticalLineToRelative(1093664768);
        builder.close();
        DateRangeKt._dateRange = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i41, 1065353216, i54, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i54, 0, i60, 0, 14336, 0).build();
        ImageVector _dateRange3 = DateRangeKt._dateRange;
        Intrinsics.checkNotNull(_dateRange3);
        return _dateRange3;
    }
}
