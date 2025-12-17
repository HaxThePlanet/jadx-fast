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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_phone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Phone", "Landroidx/compose/material/icons/Icons$Filled;", "getPhone", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PhoneKt {

    private static ImageVector _phone;
    static {
    }

    public static final ImageVector getPhone(Icons.Filled $this$Phone) {
        if (PhoneKt._phone != null) {
            ImageVector _phone2 = PhoneKt._phone;
            Intrinsics.checkNotNull(_phone2);
            return _phone2;
        }
        int i8 = 0;
        int i9 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Filled.Phone", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i7 = 0;
        int i11 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i13 = 0;
        int i15 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i18 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i91 = 0;
        final int i92 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1087624970, 1093444567);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1069044204, 1077223096, 1081123799, 1084521185, 1087562056, 1087562056);
        PathBuilder builder = builder6;
        int i22 = 1074580685;
        builder.lineToRelative(i22, -1072902963);
        builder6.curveToRelative(1049247089, -1098236559, 1059816735, -1095216660, 1065520988, -1099578737);
        builder6.curveToRelative(1066359849, 1052602532, 1075125944, 1058139013, 1080326881, 1058139013);
        int i85 = 1065353216;
        builder6.curveToRelative(1057803469, 0, 1065353216, 1055286886, 1065353216, i85);
        builder.verticalLineTo(1101004800);
        builder6.curveToRelative(0, 1057803469, -1092196762, 1065353216, -1082130432, i85);
        builder6.curveToRelative(-1055507087, 0, -1048051712, -1057782497, -1048051712, -1048051712);
        int i79 = 1065353216;
        builder6.curveToRelative(0, -1089680179, 1055286886, -1082130432, i79, -1082130432);
        builder.horizontalLineToRelative(1080033280);
        builder6.curveToRelative(1057803469, 0, 1065353216, 1055286886, i79, 1065353216);
        builder6.curveToRelative(0, 1067450368, 1045220557, 1075629261, 1058139013, 1080326881);
        builder6.curveToRelative(1038174126, 1051931443, 1022739087, 1060991140, -1098907648, 1065520988);
        builder.lineToRelative(-1072902963, i22);
        builder.close();
        PhoneKt._phone = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, 0, 0, 14336, 0).build();
        ImageVector _phone3 = PhoneKt._phone;
        Intrinsics.checkNotNull(_phone3);
        return _phone3;
    }
}
