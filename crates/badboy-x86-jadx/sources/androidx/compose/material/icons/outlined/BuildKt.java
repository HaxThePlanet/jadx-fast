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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$Outlined;", "getBuild", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BuildKt {

    private static ImageVector _build;
    static {
    }

    public static final ImageVector getBuild(Icons.Outlined $this$Build) {
        if (BuildKt._build != null) {
            ImageVector _build2 = BuildKt._build;
            Intrinsics.checkNotNull(_build2);
            return _build2;
        }
        int i17 = 0;
        int i18 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.Build", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i16 = 0;
        int i20 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i22 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i27 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i120 = 0;
        final int i121 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1102373192, 1100475269);
        int i2 = -1055832146;
        builder5.lineToRelative(i2, i2);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1064178811, -1072315761, 1055286886, -1063046349, -1078439444, -1059061760);
        builder6.curveTo(1092395991, 1058810102, 1086765138, 1053609165, 1080704369, 1074832343);
        PathBuilder builder = builder6;
        builder.lineTo(1089470464, 1086555423);
        builder.lineTo(1086492508, 1089512407);
        builder.lineTo(1074790400, 1080830198);
        builder6.curveTo(1053273620, 1086807081, 1058642330, 1092427448, 1077516698, 1094828687);
        builder6.curveToRelative(1072567419, 1072567419, 1083325809, 1075209830, 1088191201, 1069379748);
        int i6 = 1091682959;
        builder.lineToRelative(i6, i6);
        builder6.curveToRelative(1053273620, 1053273620, 1065520988, 1053273620, 1068792545, 0);
        builder.lineToRelative(1075000115, -1072483533);
        builder6.curveToRelative(1053609165, -1094545572, 1053609165, -1082046546, 0, -1078691103);
        builder.close();
        builder.moveTo(1100800328, 1101314130);
        int i9 = -1055433687;
        builder.lineToRelative(i9, i9);
        builder6.curveToRelative(-1088673546, 1055286886, -1079697736, 1060655596, -1073741824, 1062333317);
        builder6.curveToRelative(-1079110533, 1045220557, -1070428324, -1101592003, -1066066248, -1080033280);
        builder6.curveTo(1079488020, 1092364534, 1077642527, 1091043328, 1077936128, 1088967148);
        int i10 = 1078313615;
        builder.lineToRelative(i10, i10);
        builder.lineToRelative(1082633748, -1064849900);
        int i12 = -1069170033;
        builder.lineToRelative(i12, i12);
        builder6.curveToRelative(1067366482, -1114678231, 1075797033, 1052602532, 1079781622, 1067953684);
        builder6.curveToRelative(1066024305, 1066024305, 1069463634, 1076132577, 1067366482, 1081962660);
        builder6.curveToRelative(-1107967345, 1060487823, -1093203395, 1068457001, -1084143698, 1073406280);
        int i13 = 1092039475;
        builder.lineToRelative(i13, i13);
        builder.lineToRelative(-1084143698, 1063507722);
        builder.close();
        BuildKt._build = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, 0, 0, 14336, 0).build();
        ImageVector _build3 = BuildKt._build;
        Intrinsics.checkNotNull(_build3);
        return _build3;
    }
}
