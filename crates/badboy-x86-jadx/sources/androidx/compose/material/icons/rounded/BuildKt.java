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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$Rounded;", "getBuild", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BuildKt {

    private static ImageVector _build;
    static {
    }

    public static final ImageVector getBuild(Icons.Rounded $this$Build) {
        if (BuildKt._build != null) {
            ImageVector _build2 = BuildKt._build;
            Intrinsics.checkNotNull(_build2);
            return _build2;
        }
        int i9 = 0;
        int i10 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Build", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i8 = 0;
        int i12 = 0;
        int i18 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i18);
        final int i30 = 1065353216;
        int i14 = 0;
        int i16 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i19 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i84 = 0;
        final int i85 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1094807716, 1077558641);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1092700078, 1063675494, 1088568689, 1056629064, 1083493581, 1070973583);
        PathBuilder builder = builder6;
        builder.lineTo(1090812641, 1084856730);
        builder6.curveToRelative(1053273620, 1053273620, 1053273620, 1065520988, 0, 1068792545);
        builder.lineTo(1087771771, 1090833613);
        builder6.curveToRelative(-1094210028, 1053609165, -1081962660, 1053609165, -1078691103, 0);
        builder.lineTo(1070805811, 1083535524);
        builder6.curveTo(1056293519, 1088631603, 1063507722, 1092710564, 1077516698, 1094818202);
        builder6.curveToRelative(1072567419, 1072567419, 1083346780, 1075209830, 1088191201, 1069379748);
        int i5 = 1090435154;
        builder.lineToRelative(i5, i5);
        int i38 = 1065604874;
        builder6.curveToRelative(i38, 1065604874, 1076635894, 1065604874, 1080914084, 0);
        builder6.curveToRelative(i38, -1081878774, 1065604874, -1070847754, 0, -1066569564);
        builder.lineTo(1096328151, 1092511334);
        builder6.curveToRelative(1064011039, -1072315761, 1054951342, -1063046349, -1078355558, -1059082732);
        builder6.close();
        BuildKt._build = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i18, 1065353216, i30, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i30, 0, 0, 0, 14336, 0).build();
        ImageVector _build3 = BuildKt._build;
        Intrinsics.checkNotNull(_build3);
        return _build3;
    }
}
