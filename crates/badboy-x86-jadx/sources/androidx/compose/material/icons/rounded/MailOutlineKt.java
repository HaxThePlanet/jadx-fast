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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_mailOutline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MailOutline", "Landroidx/compose/material/icons/Icons$Rounded;", "getMailOutline", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MailOutlineKt {

    private static ImageVector _mailOutline;
    static {
    }

    public static final ImageVector getMailOutline(Icons.Rounded $this$MailOutline) {
        if (MailOutlineKt._mailOutline != null) {
            ImageVector _mailOutline2 = MailOutlineKt._mailOutline;
            Intrinsics.checkNotNull(_mailOutline2);
            return _mailOutline2;
        }
        int i26 = 0;
        int i27 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.MailOutline", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i25 = 0;
        int i29 = 0;
        int i35 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i35);
        final int i43 = 1065353216;
        int i31 = 0;
        int i33 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i36 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i88 = 0;
        final int i89 = i;
        final ImageVector.Builder builder6 = builder;
        int $this$_get_MailOutline__u24lambda_u241 = 1082130432;
        builder4.moveTo(1101004800, $this$_get_MailOutline__u24lambda_u241);
        builder4.lineTo($this$_get_MailOutline__u24lambda_u241, $this$_get_MailOutline__u24lambda_u241);
        int i83 = 1073741824;
        PathBuilder builder5 = builder4;
        builder5.curveToRelative(-1081291571, 0, -1073825710, 1063675494, -1073825710, i83);
        builder4.lineTo(1073741824, 1099956224);
        int i78 = 1073741824;
        builder5.curveToRelative(0, 1066192077, 1063675494, 1073741824, i78, i83);
        builder4.horizontalLineToRelative(1098907648);
        int i84 = -1073741824;
        builder5.curveToRelative(1066192077, 0, 1073741824, -1083808154, i78, i84);
        builder4.lineTo(1102053376, 1086324736);
        builder5.curveToRelative(0, -1081291571, -1083808154, -1073741824, -1073741824, i84);
        builder4.close();
        int i17 = 1099956224;
        builder4.moveTo(1100480512, i17);
        builder4.lineTo(1084227584, i17);
        builder5.curveToRelative(-1089680179, 0, -1082130432, -1092196762, -1082130432, -1082130432);
        builder4.lineTo(1082130432, 1090519040);
        builder4.lineToRelative(1088296059, 1082843464);
        builder5.curveToRelative(1059481190, 1053944709, 1069295862, 1053944709, 1074245140, 0);
        builder4.lineTo(1101004800, 1090519040);
        builder4.verticalLineToRelative(1091567616);
        int i52 = 0;
        builder5.curveToRelative(i52, 1057803469, -1092196762, 1065353216, -1082130432, 1065353216);
        builder4.close();
        builder4.moveTo(1094713344, 1093664768);
        builder4.lineTo(1082130432, 1086324736);
        builder4.horizontalLineToRelative(1098907648);
        builder4.lineToRelative(-1056964608, 1084227584);
        builder4.close();
        MailOutlineKt._mailOutline = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i35, 1065353216, i43, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i43, 0, i52, 0, 14336, 0).build();
        ImageVector _mailOutline3 = MailOutlineKt._mailOutline;
        Intrinsics.checkNotNull(_mailOutline3);
        return _mailOutline3;
    }
}
