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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_delete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Delete", "Landroidx/compose/material/icons/Icons$Filled;", "getDelete", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DeleteKt {

    private static ImageVector _delete;
    static {
    }

    public static final ImageVector getDelete(Icons.Filled $this$Delete) {
        if (DeleteKt._delete != null) {
            ImageVector _delete2 = DeleteKt._delete;
            Intrinsics.checkNotNull(_delete2);
            return _delete2;
        }
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Delete", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i13 = 0;
        int i17 = 0;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        int i19 = 1065353216;
        int i25 = 0;
        final int i26 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i53 = 0;
        int i20 = 1086324736;
        final int i54 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Delete__u24lambda_u241 = builder4;
        $this$_get_Delete__u24lambda_u241.moveTo(i20, 1100480512);
        final int i50 = 1073741824;
        builder4.curveToRelative(0, 1066192077, 1063675494, 1073741824, i50, 1073741824);
        $this$_get_Delete__u24lambda_u241.horizontalLineToRelative(1090519040);
        int i43 = 0;
        builder4.curveToRelative(1066192077, i43, 1073741824, -1083808154, i50, -1073741824);
        $this$_get_Delete__u24lambda_u241.verticalLineTo(1088421888);
        $this$_get_Delete__u24lambda_u241.horizontalLineTo(i20);
        $this$_get_Delete__u24lambda_u241.verticalLineToRelative(1094713344);
        $this$_get_Delete__u24lambda_u241.close();
        $this$_get_Delete__u24lambda_u241.moveTo(1100480512, 1082130432);
        $this$_get_Delete__u24lambda_u241.horizontalLineToRelative(-1067450368);
        int i23 = -1082130432;
        $this$_get_Delete__u24lambda_u241.lineToRelative(i23, i23);
        $this$_get_Delete__u24lambda_u241.horizontalLineToRelative(-1063256064);
        $this$_get_Delete__u24lambda_u241.lineToRelative(i23, 1065353216);
        $this$_get_Delete__u24lambda_u241.horizontalLineTo(1084227584);
        $this$_get_Delete__u24lambda_u241.verticalLineToRelative(1073741824);
        $this$_get_Delete__u24lambda_u241.horizontalLineToRelative(1096810496);
        $this$_get_Delete__u24lambda_u241.verticalLineTo(1082130432);
        $this$_get_Delete__u24lambda_u241.close();
        DeleteKt._delete = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i19, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i19, 0, 0, i43, 14336, 0).build();
        ImageVector _delete3 = DeleteKt._delete;
        Intrinsics.checkNotNull(_delete3);
        return _delete3;
    }
}
