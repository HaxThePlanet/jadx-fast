package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons.Outlined;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_person", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Person", "Landroidx/compose/material/icons/Icons$Outlined;", "getPerson", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PersonKt {

    private static ImageVector _person;
    static {
    }

    public static final ImageVector getPerson(Icons.Outlined $this$Person) {
        if (PersonKt._person != null) {
            ImageVector _person2 = PersonKt._person;
            Intrinsics.checkNotNull(_person2);
            return _person2;
        }
        String str = "Outlined.Person";
        int i21 = 0;
        int i22 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i20 = 0;
        int i24 = 0;
        int i30 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i30);
        final int i38 = 1065353216;
        int i26 = 0;
        int i28 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i31 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i76 = 0;
        final int i77 = i;
        final ImageVector.Builder builder6 = builder;
        builder4.moveTo(1094713344, 1086324736);
        int i71 = 1073741824;
        int i47 = 0;
        PathBuilder builder5 = builder4;
        builder5.curveToRelative(1066192077, i47, 1073741824, 1063675494, 1073741824, i71);
        int i2 = -1083808154;
        int i13 = 1073741824;
        final String str3 = str;
        int name$iv = -1073741824;
        builder4.reflectiveCurveToRelative(i2, i13, name$iv, i13);
        builder4.reflectiveCurveToRelative(name$iv, i2, name$iv, name$iv);
        builder4.reflectiveCurveToRelative(1063675494, name$iv, i13, name$iv);
        int i17 = 0;
        builder4.moveToRelative(i17, 1092616192);
        int i68 = 1086324736;
        builder5.curveToRelative(1076677837, i47, 1085905306, 1067785912, i68, i71);
        builder4.lineTo(1086324736, 1099956224);
        builder5.curveToRelative(1047233823, -1086828052, 1079236362, -1073741824, i68, -1073741824);
        builder4.moveToRelative(i17, -1052770304);
        builder5.curveTo(1092395991, 1082130432, 1090519040, 1085884334, 1090519040, 1090519040);
        int i15 = 1082130432;
        builder4.reflectiveCurveToRelative(1071980216, i15, i15, i15);
        int i8 = -1075503432;
        int i18 = -1065353216;
        builder4.reflectiveCurveToRelative(i15, i8, i15, i18);
        builder4.reflectiveCurveToRelative(i8, i18, i18, i18);
        builder4.close();
        builder4.moveTo(1094713344, 1096810496);
        int i70 = -1056964608;
        builder5.curveToRelative(-1070931640, 0, -1056964608, 1068205343, i70, 1082130432);
        builder4.verticalLineToRelative(1073741824);
        builder4.horizontalLineToRelative(1098907648);
        builder4.verticalLineToRelative(-1073741824);
        int i46 = 0;
        builder5.curveToRelative(i46, -1070973583, -1062564004, -1065353216, i70, -1065353216);
        builder5.close();
        PersonKt._person = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i30, 1065353216, i38, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i38, 0, i46, 0, 14336, 0).build();
        ImageVector _person3 = PersonKt._person;
        Intrinsics.checkNotNull(_person3);
        return _person3;
    }
}
