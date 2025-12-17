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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_person", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Person", "Landroidx/compose/material/icons/Icons$Rounded;", "getPerson", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PersonKt {

    private static ImageVector _person;
    static {
    }

    public static final ImageVector getPerson(Icons.Rounded $this$Person) {
        if (PersonKt._person != null) {
            ImageVector _person2 = PersonKt._person;
            Intrinsics.checkNotNull(_person2);
            return _person2;
        }
        String str = "Rounded.Person";
        int i8 = 0;
        int i9 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i7 = 0;
        int i11 = 0;
        int i21 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i21);
        int i13 = 1065353216;
        int i18 = 0;
        final int i19 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i25 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i63 = 0;
        int i14 = 1094713344;
        final int i64 = i;
        PathBuilder $i$f$materialIcon = builder4;
        $i$f$materialIcon.moveTo(i14, i14);
        int i37 = 0;
        builder4.curveToRelative(1074622628, i37, 1082130432, -1075503432, 1082130432, -1065353216);
        final ImageVector.Builder builder5 = builder;
        int $this$_get_Person__u24lambda_u241 = -1065353216;
        $i$f$materialIcon.reflectiveCurveToRelative(-1075503432, $this$_get_Person__u24lambda_u241, $this$_get_Person__u24lambda_u241, $this$_get_Person__u24lambda_u241);
        int i16 = 1071980216;
        final String str3 = str;
        int name$iv = 1082130432;
        $i$f$materialIcon.reflectiveCurveToRelative($this$_get_Person__u24lambda_u241, i16, $this$_get_Person__u24lambda_u241, name$iv);
        $i$f$materialIcon.reflectiveCurveToRelative(i16, name$iv, name$iv, name$iv);
        $i$f$materialIcon.close();
        int i2 = 1096810496;
        $i$f$materialIcon.moveTo(1094713344, i2);
        builder4.curveToRelative(-1070931640, i37, -1056964608, 1068205343, -1056964608, 1082130432);
        $i$f$materialIcon.verticalLineToRelative(1065353216);
        int i56 = 1065353216;
        builder4.curveToRelative(0, 1057803469, 1055286886, 1065353216, i56, 1065353216);
        $i$f$materialIcon.horizontalLineToRelative(i2);
        builder4.curveToRelative(1057803469, 0, 1065353216, -1092196762, i56, -1082130432);
        $i$f$materialIcon.verticalLineToRelative(-1082130432);
        int i36 = 0;
        builder4.curveToRelative(i36, -1070973583, -1062564004, -1065353216, -1056964608, -1065353216);
        $i$f$materialIcon.close();
        PersonKt._person = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i21, 1065353216, i13, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i13, 0, i36, 0, 14336, 0).build();
        ImageVector _person3 = PersonKt._person;
        Intrinsics.checkNotNull(_person3);
        return _person3;
    }
}
