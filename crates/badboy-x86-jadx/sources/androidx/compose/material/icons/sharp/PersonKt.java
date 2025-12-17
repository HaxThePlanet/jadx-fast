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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_person", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Person", "Landroidx/compose/material/icons/Icons$Sharp;", "getPerson", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PersonKt {

    private static ImageVector _person;
    static {
    }

    public static final ImageVector getPerson(Icons.Sharp $this$Person) {
        if (PersonKt._person != null) {
            ImageVector _person2 = PersonKt._person;
            Intrinsics.checkNotNull(_person2);
            return _person2;
        }
        String str = "Sharp.Person";
        int i11 = 0;
        int i12 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i10 = 0;
        int i14 = 0;
        int i20 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i20);
        final int i28 = 1065353216;
        int i16 = 0;
        int i18 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i21 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i50 = 0;
        final int i51 = i;
        int $i$f$materialIcon = 1094713344;
        builder4.moveTo($i$f$materialIcon, $i$f$materialIcon);
        int i34 = 0;
        PathBuilder builder5 = builder4;
        builder5.curveToRelative(1074622628, i34, 1082130432, -1075503432, 1082130432, -1065353216);
        final ImageVector.Builder builder6 = builder;
        int $this$_get_Person__u24lambda_u241 = -1065353216;
        builder4.reflectiveCurveToRelative(-1075503432, $this$_get_Person__u24lambda_u241, $this$_get_Person__u24lambda_u241, $this$_get_Person__u24lambda_u241);
        int i3 = 1071980216;
        final String str3 = str;
        int name$iv = 1082130432;
        builder4.reflectiveCurveToRelative($this$_get_Person__u24lambda_u241, i3, $this$_get_Person__u24lambda_u241, name$iv);
        builder4.reflectiveCurveToRelative(i3, name$iv, name$iv, name$iv);
        builder4.close();
        builder4.moveTo(1094713344, 1096810496);
        int i46 = -1056964608;
        builder5.curveToRelative(-1070931640, i34, -1056964608, 1068205343, i46, 1082130432);
        builder4.verticalLineToRelative(1073741824);
        builder4.horizontalLineToRelative(1098907648);
        builder4.verticalLineToRelative(-1073741824);
        int i33 = 0;
        builder5.curveToRelative(i33, -1070973583, -1062564004, -1065353216, i46, -1065353216);
        builder5.close();
        PersonKt._person = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i20, 1065353216, i28, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i28, 0, i33, 0, 14336, 0).build();
        ImageVector _person3 = PersonKt._person;
        Intrinsics.checkNotNull(_person3);
        return _person3;
    }
}
