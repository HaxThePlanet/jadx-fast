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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_edit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Edit", "Landroidx/compose/material/icons/Icons$Sharp;", "getEdit", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditKt {

    private static ImageVector _edit;
    static {
    }

    public static final ImageVector getEdit(Icons.Sharp $this$Edit) {
        if (EditKt._edit != null) {
            ImageVector _edit2 = EditKt._edit;
            Intrinsics.checkNotNull(_edit2);
            return _edit2;
        }
        int i19 = 0;
        int i20 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Edit", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i18 = 0;
        int i22 = 0;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        final int i36 = 1065353216;
        int i24 = 0;
        int i26 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i29 = 0;
        PathBuilder builder4 = pathBuilder;
        int i38 = 0;
        final int i44 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1077936128, 1099563008);
        builder4.verticalLineTo(1101529088);
        builder4.horizontalLineToRelative(1081081856);
        builder4.lineTo(1099856609, 1092553277);
        int i5 = -1066401792;
        builder4.lineToRelative(i5, i5);
        builder4.lineTo(1077936128, 1099563008);
        builder4.close();
        builder4.moveTo(1101744046, 1087037768);
        int i8 = -1066401792;
        builder4.lineToRelative(i8, i8);
        builder4.lineToRelative(-1071518843, 1076006748);
        int i10 = 1081081856;
        builder4.lineToRelative(i10, i10);
        builder4.lineToRelative(1075964805, -1071476900);
        builder4.close();
        EditKt._edit = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i36, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i36, 0, 0, 0, 14336, 0).build();
        ImageVector _edit3 = EditKt._edit;
        Intrinsics.checkNotNull(_edit3);
        return _edit3;
    }
}
