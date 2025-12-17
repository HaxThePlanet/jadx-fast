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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_exitToApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ExitToApp", "Landroidx/compose/material/icons/Icons$Sharp;", "getExitToApp$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getExitToApp", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExitToAppKt {

    private static ImageVector _exitToApp;
    static {
    }

    public static final ImageVector getExitToApp(Icons.Sharp $this$ExitToApp) {
        if (ExitToAppKt._exitToApp != null) {
            ImageVector _exitToApp2 = ExitToAppKt._exitToApp;
            Intrinsics.checkNotNull(_exitToApp2);
            return _exitToApp2;
        }
        int i27 = 0;
        int i28 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.ExitToApp", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i26 = 0;
        int i30 = 0;
        int i36 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i36);
        final int i44 = 1065353216;
        int i32 = 0;
        int i34 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i37 = 0;
        PathBuilder builder4 = pathBuilder;
        int i46 = 0;
        final int i52 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1092710564, 1098477732);
        builder4.lineTo(1094189056, 1099431936);
        int i15 = -1063256064;
        builder4.lineToRelative(1084227584, i15);
        builder4.lineToRelative(i15, i15);
        builder4.lineToRelative(-1078691103, 1068792545);
        builder4.lineTo(1095415890, 1093664768);
        builder4.horizontalLineTo(1077936128);
        builder4.verticalLineToRelative(1073741824);
        builder4.horizontalLineToRelative(1092270162);
        builder4.lineToRelative(-1071309128, 1076216463);
        builder4.close();
        int i21 = 1077936128;
        builder4.moveTo(1101529088, i21);
        builder4.horizontalLineTo(i21);
        builder4.verticalLineToRelative(1086324736);
        builder4.horizontalLineToRelative(1073741824);
        int i23 = 1084227584;
        builder4.verticalLineTo(i23);
        int i10 = 1096810496;
        builder4.horizontalLineToRelative(i10);
        builder4.verticalLineToRelative(i10);
        builder4.horizontalLineTo(i23);
        builder4.verticalLineToRelative(-1065353216);
        int i24 = 1077936128;
        builder4.horizontalLineTo(i24);
        builder4.verticalLineToRelative(1086324736);
        builder4.horizontalLineToRelative(1099956224);
        builder4.verticalLineTo(i24);
        builder4.close();
        ExitToAppKt._exitToApp = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i36, 1065353216, i44, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i44, 0, 0, 0, 14336, 0).build();
        ImageVector _exitToApp3 = ExitToAppKt._exitToApp;
        Intrinsics.checkNotNull(_exitToApp3);
        return _exitToApp3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Sharp.ExitToApp", replaceWith = @ReplaceWith(...))
    public static void getExitToApp$annotations(Icons.Sharp icons$Sharp) {
    }
}
