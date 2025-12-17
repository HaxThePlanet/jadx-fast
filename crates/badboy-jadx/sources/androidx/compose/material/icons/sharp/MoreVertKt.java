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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_moreVert", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoreVert", "Landroidx/compose/material/icons/Icons$Sharp;", "getMoreVert", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MoreVertKt {

    private static ImageVector _moreVert;
    static {
    }

    public static final ImageVector getMoreVert(Icons.Sharp $this$MoreVert) {
        if (MoreVertKt._moreVert != null) {
            ImageVector _moreVert2 = MoreVertKt._moreVert;
            Intrinsics.checkNotNull(_moreVert2);
            return _moreVert2;
        }
        String str = "Sharp.MoreVert";
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i13 = 0;
        int i17 = 0;
        int i23 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i23);
        final int i35 = 1065353216;
        int i19 = 0;
        int i21 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i24 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i52 = 0;
        final int i53 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1094713344, 1090519040);
        final int i41 = 0;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1066192077, i41, 1073741824, -1083808154, 1073741824, -1073741824);
        PathBuilder builder = builder6;
        int i2 = -1073741824;
        builder.reflectiveCurveToRelative(-1083808154, i2, i2, i2);
        int i29 = 1063675494;
        final String str3 = str;
        int name$iv = 1073741824;
        builder.reflectiveCurveToRelative(i2, i29, i2, name$iv);
        builder.reflectiveCurveToRelative(i29, name$iv, name$iv, name$iv);
        builder.close();
        builder.moveTo(1094713344, 1092616192);
        int i49 = -1073741824;
        int i51 = 1073741824;
        int i39 = -1081291571;
        int i43 = -1073741824;
        int i46 = 1063675494;
        builder6.curveToRelative(i39, i41, i43, i46, i49, i51);
        int i4 = 1073741824;
        builder.reflectiveCurveToRelative(i29, i4, i4, i4);
        int i9 = -1083808154;
        int i30 = -1073741824;
        builder.reflectiveCurveToRelative(i4, i9, i4, i30);
        builder.reflectiveCurveToRelative(i9, i30, i30, i30);
        builder.close();
        builder.moveTo(1094713344, 1098907648);
        builder6.curveToRelative(i39, i41, i43, i46, i49, i51);
        int i11 = 1073741824;
        builder.reflectiveCurveToRelative(1063675494, i11, i11, i11);
        int i7 = -1083808154;
        int i31 = -1073741824;
        builder.reflectiveCurveToRelative(i11, i7, i11, i31);
        builder.reflectiveCurveToRelative(i7, i31, i31, i31);
        builder.close();
        MoreVertKt._moreVert = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i23, 1065353216, i35, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i35, 0, 0, i41, 14336, 0).build();
        ImageVector _moreVert3 = MoreVertKt._moreVert;
        Intrinsics.checkNotNull(_moreVert3);
        return _moreVert3;
    }
}
