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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_thumbUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUp", "Landroidx/compose/material/icons/Icons$Rounded;", "getThumbUp", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThumbUpKt {

    private static ImageVector _thumbUp;
    static {
    }

    public static final ImageVector getThumbUp(Icons.Rounded $this$ThumbUp) {
        if (ThumbUpKt._thumbUp != null) {
            ImageVector _thumbUp2 = ThumbUpKt._thumbUp;
            Intrinsics.checkNotNull(_thumbUp2);
            return _thumbUp2;
        }
        String str = "Rounded.ThumbUp";
        int i15 = 0;
        int i16 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i18 = 0;
        int i24 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i24);
        final int i36 = 1065353216;
        int i20 = 0;
        int i22 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i25 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i94 = 0;
        final int i95 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1095887749, 1073993482);
        builder5.lineTo(1089638236, 1089680179);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1094881116, 1052602532, -1089176863, 1063339950, -1089176863, 1068792545);
        PathBuilder builder = builder6;
        builder.verticalLineTo(1100480512);
        builder6.curveToRelative(0, 1066192077, 1063675494, 1073741824, 1073741824, 1073741824);
        builder.horizontalLineToRelative(1091567616);
        builder6.curveToRelative(1061997773, 0, 1069715292, -1091190129, 1072399647, -1080368824);
        builder.lineToRelative(1079026647, -1057782497);
        builder6.curveTo(1103070495, 1092825907, 1102310277, 1090519040, 1101183058, 1090519040);
        builder.horizontalLineToRelative(-1061892915);
        builder.lineToRelative(1064514355, -1064136868);
        builder6.curveToRelative(1036831949, -1090519040, -1119040307, -1082046546, -1093538939, -1079026647);
        builder6.curveToRelative(-1089009091, -1089176863, -1077684470, -1089176863, -1073280451, 1008981770);
        builder.close();
        builder.moveTo(1077936128, 1101529088);
        int i92 = -1073741824;
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, 1073741824, i92);
        builder.verticalLineToRelative(-1056964608);
        int i46 = 0;
        builder6.curveToRelative(i46, -1081291571, -1083808154, -1073741824, -1073741824, i92);
        final String str3 = str;
        int name$iv = -1073741824;
        builder.reflectiveCurveToRelative(name$iv, 1063675494, name$iv, 1073741824);
        builder.verticalLineToRelative(1090519040);
        builder6.curveToRelative(i46, 1066192077, 1063675494, 1073741824, 1073741824, 1073741824);
        builder6.close();
        ThumbUpKt._thumbUp = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i24, 1065353216, i36, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i36, 0, i46, 0, 14336, 0).build();
        ImageVector _thumbUp3 = ThumbUpKt._thumbUp;
        Intrinsics.checkNotNull(_thumbUp3);
        return _thumbUp3;
    }
}
