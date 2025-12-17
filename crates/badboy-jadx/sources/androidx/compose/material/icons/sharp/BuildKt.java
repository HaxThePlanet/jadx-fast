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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$Sharp;", "getBuild", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BuildKt {

    private static ImageVector _build;
    static {
    }

    public static final ImageVector getBuild(Icons.Sharp $this$Build) {
        if (BuildKt._build != null) {
            ImageVector _build2 = BuildKt._build;
            Intrinsics.checkNotNull(_build2);
            return _build2;
        }
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Sharp.Build", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        int i19 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i19);
        final int i30 = 1065353216;
        int i15 = 0;
        int i17 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i20 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i61 = 0;
        final int i62 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1094807716, 1077558641);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1092700078, 1063675494, 1088568689, 1056629064, 1083493581, 1070973583);
        PathBuilder builder = builder6;
        int i2 = 1082843464;
        builder.lineToRelative(i2, i2);
        builder.lineToRelative(-1069547520, 1077936128);
        int i4 = -1064640184;
        builder.lineToRelative(i4, i4);
        builder6.curveTo(1056293519, 1088631603, 1063507722, 1092710564, 1077516698, 1094818202);
        builder6.curveToRelative(1072567419, 1072567419, 1083346780, 1075209830, 1088191201, 1069379748);
        int i5 = 1092427448;
        builder.lineToRelative(i5, i5);
        builder.lineToRelative(1080914084, -1066569564);
        builder.lineToRelative(-1055098143, -1055087657);
        builder6.curveToRelative(1064011039, -1072315761, 1054951342, -1063046349, -1078355558, -1059082732);
        builder6.close();
        BuildKt._build = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i19, 1065353216, i30, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i30, 0, 0, 0, 14336, 0).build();
        ImageVector _build3 = BuildKt._build;
        Intrinsics.checkNotNull(_build3);
        return _build3;
    }
}
