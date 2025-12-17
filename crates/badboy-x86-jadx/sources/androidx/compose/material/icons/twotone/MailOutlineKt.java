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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_mailOutline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MailOutline", "Landroidx/compose/material/icons/Icons$TwoTone;", "getMailOutline", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MailOutlineKt {

    private static ImageVector _mailOutline;
    static {
    }

    public static final ImageVector getMailOutline(Icons.TwoTone $this$MailOutline) {
        if (MailOutlineKt._mailOutline != null) {
            ImageVector _mailOutline2 = MailOutlineKt._mailOutline;
            Intrinsics.checkNotNull(_mailOutline2);
            return _mailOutline2;
        }
        int i23 = 0;
        int i24 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.MailOutline", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i22 = 0;
        int i26 = 0;
        int i32 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i32);
        final int i40 = 1065353216;
        int i28 = 0;
        int i30 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i33 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i67 = 0;
        final int i68 = i;
        final ImageVector.Builder builder6 = builder;
        int $this$_get_MailOutline__u24lambda_u241 = 1082130432;
        builder4.moveTo(1101004800, $this$_get_MailOutline__u24lambda_u241);
        builder4.lineTo($this$_get_MailOutline__u24lambda_u241, $this$_get_MailOutline__u24lambda_u241);
        int i65 = 1073741824;
        PathBuilder builder5 = builder4;
        builder5.curveToRelative(-1081291571, 0, -1073825710, 1063675494, -1073825710, i65);
        builder4.lineTo(1073741824, 1099956224);
        int i63 = 1073741824;
        builder5.curveToRelative(0, 1066192077, 1063675494, 1073741824, i63, i65);
        builder4.horizontalLineToRelative(1098907648);
        int i66 = -1073741824;
        builder5.curveToRelative(1066192077, 0, 1073741824, -1083808154, i63, i66);
        builder4.lineTo(1102053376, 1086324736);
        int i46 = 0;
        builder5.curveToRelative(i46, -1081291571, -1083808154, -1073741824, -1073741824, i66);
        builder4.close();
        int i4 = 1099956224;
        builder4.moveTo(1101004800, i4);
        int i15 = 1082130432;
        builder4.lineTo(i15, i4);
        int i5 = 1090519040;
        builder4.lineTo(i15, i5);
        builder4.lineToRelative(i5, 1084227584);
        builder4.lineToRelative(i5, -1063256064);
        builder4.verticalLineToRelative(1092616192);
        builder4.close();
        builder4.moveTo(1094713344, 1093664768);
        builder4.lineTo(1082130432, 1086324736);
        builder4.horizontalLineToRelative(1098907648);
        builder4.lineToRelative(-1056964608, 1084227584);
        builder4.close();
        MailOutlineKt._mailOutline = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i32, 1065353216, i40, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i40, 0, i46, 0, 14336, 0).build();
        ImageVector _mailOutline3 = MailOutlineKt._mailOutline;
        Intrinsics.checkNotNull(_mailOutline3);
        return _mailOutline3;
    }
}
