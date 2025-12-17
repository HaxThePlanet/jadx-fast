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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_exitToApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ExitToApp", "Landroidx/compose/material/icons/Icons$Outlined;", "getExitToApp$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getExitToApp", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExitToAppKt {

    private static ImageVector _exitToApp;
    static {
    }

    public static final ImageVector getExitToApp(Icons.Outlined $this$ExitToApp) {
        if (ExitToAppKt._exitToApp != null) {
            ImageVector _exitToApp2 = ExitToAppKt._exitToApp;
            Intrinsics.checkNotNull(_exitToApp2);
            return _exitToApp2;
        }
        int i22 = 0;
        int i23 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.ExitToApp", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i21 = 0;
        int i25 = 0;
        int i31 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i31);
        final int i45 = 1065353216;
        int i27 = 0;
        int i29 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i72 = 0;
        final int i73 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1092710564, 1098477732);
        builder5.lineTo(1094189056, 1099431936);
        int i11 = -1063256064;
        builder5.lineToRelative(1084227584, i11);
        builder5.lineToRelative(i11, i11);
        builder5.lineToRelative(-1078691103, 1068792545);
        builder5.lineTo(1095415890, 1093664768);
        builder5.horizontalLineTo(1077936128);
        builder5.verticalLineToRelative(1073741824);
        builder5.horizontalLineToRelative(1092270162);
        builder5.lineToRelative(-1071309128, 1076216463);
        builder5.close();
        builder5.moveTo(1100480512, 1077936128);
        builder5.horizontalLineTo(1084227584);
        int i70 = 1073741824;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1081207685, 0, -1073741824, 1063675494, -1073741824, i70);
        PathBuilder builder = builder6;
        builder.verticalLineToRelative(1082130432);
        builder.horizontalLineToRelative(1073741824);
        int i37 = 1084227584;
        builder.verticalLineTo(i37);
        int i19 = 1096810496;
        builder.horizontalLineToRelative(i19);
        builder.verticalLineToRelative(i19);
        builder.horizontalLineTo(i37);
        builder.verticalLineToRelative(-1065353216);
        builder.horizontalLineTo(1077936128);
        builder.verticalLineToRelative(1082130432);
        int i68 = 1073741824;
        builder6.curveToRelative(0, 1066192077, 1063507722, 1073741824, i68, i70);
        builder.horizontalLineToRelative(i19);
        int i71 = -1073741824;
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, i68, i71);
        builder.verticalLineTo(1084227584);
        int i51 = 0;
        builder6.curveToRelative(i51, -1081291571, -1083808154, -1073741824, -1073741824, i71);
        builder6.close();
        ExitToAppKt._exitToApp = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i31, 1065353216, i45, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i45, 0, i51, 0, 14336, 0).build();
        ImageVector _exitToApp3 = ExitToAppKt._exitToApp;
        Intrinsics.checkNotNull(_exitToApp3);
        return _exitToApp3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.ExitToApp", replaceWith = @ReplaceWith(...))
    public static void getExitToApp$annotations(Icons.Outlined icons$Outlined) {
    }
}
