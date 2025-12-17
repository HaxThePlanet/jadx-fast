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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$Filled;", "getBuild", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BuildKt {

    private static ImageVector _build;
    static {
    }

    public static final ImageVector getBuild(Icons.Filled $this$Build) {
        if (BuildKt._build != null) {
            ImageVector _build2 = BuildKt._build;
            Intrinsics.checkNotNull(_build2);
            return _build2;
        }
        int i9 = 0;
        int i10 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Filled.Build", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i8 = 0;
        int i12 = 0;
        int i18 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i18);
        final int i29 = 1065353216;
        int i14 = 0;
        int i16 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i19 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i72 = 0;
        final int i73 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1102420378, 1100480512);
        int i2 = -1055811174;
        builder5.lineToRelative(i2, i2);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1063675494, -1072483533, 1053609165, -1063256064, -1077936128, -1059271475);
        builder6.curveToRelative(-1073741824, -1073741824, -1063256064, -1072064102, -1058222899, -1079613850);
        PathBuilder builder = builder6;
        int i3 = 1091567616;
        int i23 = 1086324736;
        builder.lineTo(i3, i23);
        builder.lineTo(i23, i3);
        builder.lineTo(1070386381, 1083598438);
        builder6.curveTo(1053609165, 1088631603, 1063675494, 1092721050, 1077516698, 1094818202);
        builder6.curveToRelative(1072902963, 1072902963, 1083388723, 1075419546, 1088212173, 1069547520);
        int i5 = 1091672474;
        builder.lineToRelative(i5, i5);
        builder6.curveToRelative(1053609165, 1053609165, 1065353216, 1053609165, 1068708659, 0);
        builder.lineToRelative(1075000115, -1072483533);
        builder6.curveToRelative(1056964608, -1093874483, 1056964608, -1081291571, 1036831949, -1078774989);
        builder6.close();
        BuildKt._build = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i18, 1065353216, i29, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i29, 0, 0, 0, 14336, 0).build();
        ImageVector _build3 = BuildKt._build;
        Intrinsics.checkNotNull(_build3);
        return _build3;
    }
}
