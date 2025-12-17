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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_add", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Add", "Landroidx/compose/material/icons/Icons$Sharp;", "getAdd", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AddKt {

    private static ImageVector _add;
    static {
    }

    public static final ImageVector getAdd(Icons.Sharp $this$Add) {
        if (AddKt._add != null) {
            ImageVector _add2 = AddKt._add;
            Intrinsics.checkNotNull(_add2);
            return _add2;
        }
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Add", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        int i19 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i19);
        final int i27 = 1065353216;
        int i15 = 0;
        int i17 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i20 = 0;
        PathBuilder builder4 = pathBuilder;
        int i29 = 0;
        final int i35 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1100480512, 1095761920);
        int i2 = -1061158912;
        builder4.horizontalLineToRelative(i2);
        builder4.verticalLineToRelative(1086324736);
        int i6 = -1073741824;
        builder4.horizontalLineToRelative(i6);
        builder4.verticalLineToRelative(i2);
        int i3 = 1084227584;
        builder4.horizontalLineTo(i3);
        builder4.verticalLineToRelative(i6);
        int i7 = 1086324736;
        builder4.horizontalLineToRelative(i7);
        builder4.verticalLineTo(i3);
        int i4 = 1073741824;
        builder4.horizontalLineToRelative(i4);
        builder4.verticalLineToRelative(i7);
        builder4.horizontalLineToRelative(i7);
        builder4.verticalLineToRelative(i4);
        builder4.close();
        AddKt._add = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i19, 1065353216, i27, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i27, 0, 0, 0, 14336, 0).build();
        ImageVector _add3 = AddKt._add;
        Intrinsics.checkNotNull(_add3);
        return _add3;
    }
}
