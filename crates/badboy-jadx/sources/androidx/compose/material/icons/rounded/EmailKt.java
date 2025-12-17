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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_email", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Email", "Landroidx/compose/material/icons/Icons$Rounded;", "getEmail", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EmailKt {

    private static ImageVector _email;
    static {
    }

    public static final ImageVector getEmail(Icons.Rounded $this$Email) {
        if (EmailKt._email != null) {
            ImageVector _email2 = EmailKt._email;
            Intrinsics.checkNotNull(_email2);
            return _email2;
        }
        int i12 = 0;
        int i13 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Email", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i11 = 0;
        int i15 = 0;
        int i21 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i21);
        final int i36 = 1065353216;
        int i17 = 0;
        int i19 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i22 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i90 = 0;
        final int i91 = i;
        final ImageVector.Builder builder7 = builder2;
        int $this$_get_Email__u24lambda_u241 = 1082130432;
        builder5.moveTo(1101004800, $this$_get_Email__u24lambda_u241);
        builder5.lineTo($this$_get_Email__u24lambda_u241, $this$_get_Email__u24lambda_u241);
        int i85 = 1073741824;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1081291571, 0, -1073825710, 1063675494, -1073825710, i85);
        PathBuilder builder = builder6;
        builder.lineTo(1073741824, 1099956224);
        int i79 = 1073741824;
        builder6.curveToRelative(0, 1066192077, 1063675494, 1073741824, i79, i85);
        builder.horizontalLineToRelative(1098907648);
        int i86 = -1073741824;
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, i79, i86);
        builder.lineTo(1102053376, 1086324736);
        builder6.curveToRelative(0, -1081291571, -1083808154, -1073741824, -1073741824, i86);
        builder.close();
        builder.moveTo(1100795085, 1090781184);
        builder.lineToRelative(-1058914959, 1083011236);
        builder6.curveToRelative(-1096558838, 1045220557, -1086492508, 1045220557, -1081627116, 0);
        builder.lineTo(1082969293, 1090781184);
        int i88 = -1086828052;
        builder6.curveToRelative(-1098907648, -1104947446, -1093874483, -1092867850, -1093874483, i88);
        int i83 = 1067869798;
        builder6.curveToRelative(0, -1087666913, 1060823368, -1081543229, i83, i88);
        builder.lineTo(1094713344, 1093664768);
        builder.lineToRelative(1087792742, -1064954757);
        int i89 = 1060655596;
        builder6.curveToRelative(1058139013, -1095552205, 1067869798, 1028443341, i83, i89);
        int i47 = 0;
        builder6.curveToRelative(i47, 1049918177, -1105618534, 1057971241, -1093874483, i89);
        builder6.close();
        EmailKt._email = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i21, 1065353216, i36, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i36, 0, i47, 0, 14336, 0).build();
        ImageVector _email3 = EmailKt._email;
        Intrinsics.checkNotNull(_email3);
        return _email3;
    }
}
