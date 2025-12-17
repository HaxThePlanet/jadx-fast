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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_create", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Create", "Landroidx/compose/material/icons/Icons$Filled;", "getCreate", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CreateKt {

    private static ImageVector _create;
    static {
    }

    public static final ImageVector getCreate(Icons.Filled $this$Create) {
        if (CreateKt._create != null) {
            ImageVector _create2 = CreateKt._create;
            Intrinsics.checkNotNull(_create2);
            return _create2;
        }
        int i17 = 0;
        int i18 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Filled.Create", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i16 = 0;
        int i20 = 0;
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i26);
        final int i35 = 1065353216;
        int i22 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i27 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i53 = 0;
        final int i54 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1077936128, 1099563008);
        builder5.verticalLineTo(1101529088);
        builder5.horizontalLineToRelative(1081081856);
        builder5.lineTo(1099856609, 1092553277);
        int i5 = -1066401792;
        builder5.lineToRelative(i5, i5);
        builder5.lineTo(1077936128, 1099563008);
        builder5.close();
        builder5.moveTo(1101377044, 1088505774);
        int i41 = -1094210028;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1053273620, i41, 1053273620, -1081962660, 0, -1078691103);
        PathBuilder builder = builder6;
        int i11 = -1072315761;
        builder.lineToRelative(i11, i11);
        builder6.curveToRelative(-1094210028, i41, -1081962660, -1094210028, -1078691103, 0);
        int i31 = 1072315761;
        builder.lineToRelative(-1075167887, i31);
        int i13 = 1081081856;
        builder.lineToRelative(i13, i13);
        builder.lineToRelative(i31, -1075167887);
        builder.close();
        CreateKt._create = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i26, 1065353216, i35, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i35, 0, 0, 0, 14336, 0).build();
        ImageVector _create3 = CreateKt._create;
        Intrinsics.checkNotNull(_create3);
        return _create3;
    }
}
