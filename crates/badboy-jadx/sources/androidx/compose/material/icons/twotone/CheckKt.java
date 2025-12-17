package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons.TwoTone;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_check", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Check", "Landroidx/compose/material/icons/Icons$TwoTone;", "getCheck", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckKt {

    private static ImageVector _check;
    static {
    }

    public static final ImageVector getCheck(Icons.TwoTone $this$Check) {
        if (CheckKt._check != null) {
            ImageVector _check2 = CheckKt._check;
            Intrinsics.checkNotNull(_check2);
            return _check2;
        }
        int i15 = 0;
        int i16 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Check", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i18 = 0;
        int i24 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i24);
        final int i32 = 1065353216;
        int i20 = 0;
        int i22 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i25 = 0;
        PathBuilder builder4 = pathBuilder;
        int i34 = 0;
        final int i40 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1091567616, 1098996777);
        builder4.lineTo(1083871068, 1094713344);
        builder4.lineToRelative(-1078607217, 1068792545);
        builder4.lineTo(1091567616, 1100480512);
        builder4.lineTo(1101529088, 1088421888);
        int i6 = -1078691103;
        builder4.lineToRelative(i6, i6);
        builder4.lineTo(1091567616, 1098996777);
        builder4.close();
        CheckKt._check = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i24, 1065353216, i32, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i32, 0, 0, 0, 14336, 0).build();
        ImageVector _check3 = CheckKt._check;
        Intrinsics.checkNotNull(_check3);
        return _check3;
    }
}
