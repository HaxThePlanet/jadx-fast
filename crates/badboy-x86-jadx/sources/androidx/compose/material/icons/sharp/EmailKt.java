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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_email", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Email", "Landroidx/compose/material/icons/Icons$Sharp;", "getEmail", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EmailKt {

    private static ImageVector _email;
    static {
    }

    public static final ImageVector getEmail(Icons.Sharp $this$Email) {
        if (EmailKt._email != null) {
            ImageVector _email2 = EmailKt._email;
            Intrinsics.checkNotNull(_email2);
            return _email2;
        }
        int i19 = 0;
        int i20 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Email", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
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
        int $this$_get_Email__u24lambda_u241 = 1082130432;
        builder4.moveTo(1102053376, $this$_get_Email__u24lambda_u241);
        builder4.lineTo(1073741824, $this$_get_Email__u24lambda_u241);
        builder4.verticalLineToRelative(1098907648);
        builder4.horizontalLineToRelative(1101004800);
        builder4.lineTo(1102053376, $this$_get_Email__u24lambda_u241);
        builder4.close();
        builder4.moveTo(1101004800, 1090519040);
        int i14 = -1056964608;
        builder4.lineToRelative(i14, 1084227584);
        builder4.lineToRelative(i14, -1063256064);
        builder4.lineTo(1082130432, 1086324736);
        int i16 = 1090519040;
        builder4.lineToRelative(i16, 1084227584);
        builder4.lineToRelative(i16, -1063256064);
        builder4.verticalLineToRelative(1073741824);
        builder4.close();
        EmailKt._email = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i36, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i36, 0, 0, 0, 14336, 0).build();
        ImageVector _email3 = EmailKt._email;
        Intrinsics.checkNotNull(_email3);
        return _email3;
    }
}
