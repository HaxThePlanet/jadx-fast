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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_home", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Home", "Landroidx/compose/material/icons/Icons$Outlined;", "getHome", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HomeKt {

    private static ImageVector _home;
    static {
    }

    public static final ImageVector getHome(Icons.Outlined $this$Home) {
        if (HomeKt._home != null) {
            ImageVector _home2 = HomeKt._home;
            Intrinsics.checkNotNull(_home2);
            return _home2;
        }
        int i25 = 0;
        int i26 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Home", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i24 = 0;
        int i28 = 0;
        int i34 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i34);
        final int i42 = 1065353216;
        int i30 = 0;
        int i32 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i35 = 0;
        PathBuilder builder4 = pathBuilder;
        int i44 = 0;
        final int i50 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1094713344, 1085674619);
        int i15 = 1084227584;
        builder4.lineToRelative(i15, 1083179008);
        builder4.verticalLineTo(1099956224);
        builder4.horizontalLineToRelative(-1073741824);
        builder4.verticalLineToRelative(-1061158912);
        builder4.horizontalLineTo(1091567616);
        builder4.verticalLineToRelative(1086324736);
        builder4.horizontalLineTo(1088421888);
        builder4.verticalLineToRelative(-1057363067);
        builder4.lineToRelative(i15, -1064304640);
        int i16 = 1094713344;
        builder4.moveTo(i16, 1077936128);
        int i12 = 1073741824;
        builder4.lineTo(i12, i16);
        builder4.horizontalLineToRelative(1077936128);
        builder4.verticalLineToRelative(1090519040);
        builder4.horizontalLineToRelative(1086324736);
        builder4.verticalLineToRelative(-1061158912);
        builder4.horizontalLineToRelative(i12);
        int i21 = 1086324736;
        builder4.verticalLineToRelative(i21);
        builder4.horizontalLineToRelative(i21);
        builder4.verticalLineToRelative(-1056964608);
        int i22 = 1077936128;
        builder4.horizontalLineToRelative(i22);
        builder4.lineTo(1094713344, i22);
        builder4.close();
        HomeKt._home = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i34, 1065353216, i42, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i42, 0, 0, 0, 14336, 0).build();
        ImageVector _home3 = HomeKt._home;
        Intrinsics.checkNotNull(_home3);
        return _home3;
    }
}
