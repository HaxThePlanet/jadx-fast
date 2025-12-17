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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_email", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Email", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEmail", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EmailKt {

    private static ImageVector _email;
    static {
    }

    public static final ImageVector getEmail(Icons.TwoTone $this$Email) {
        if (EmailKt._email != null) {
            ImageVector _email2 = EmailKt._email;
            Intrinsics.checkNotNull(_email2);
            return _email2;
        }
        int i5 = 0;
        int i7 = 0;
        ImageVector.Builder builder3 = new ImageVector.Builder("TwoTone.Email", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i4 = 0;
        int i9 = 0;
        int i28 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        int i12 = 1065353216;
        int i24 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i62 = 0;
        int i70 = 0;
        int i88 = i12;
        final int i94 = i;
        PathBuilder $i$f$materialIcon = builder9;
        $i$f$materialIcon.moveTo(1101004800, 1090519040);
        int i30 = -1056964608;
        $i$f$materialIcon.lineToRelative(i30, 1084227584);
        $i$f$materialIcon.lineToRelative(i30, -1063256064);
        $i$f$materialIcon.verticalLineToRelative(1092616192);
        $i$f$materialIcon.horizontalLineToRelative(1098907648);
        $i$f$materialIcon.close();
        int i31 = 1086324736;
        $i$f$materialIcon.moveTo(1101004800, i31);
        $i$f$materialIcon.lineTo(1082130432, i31);
        $i$f$materialIcon.lineToRelative(1090519040, 1084206612);
        $i$f$materialIcon.close();
        int i71 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder3, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1050253722, i28, 1050253722, i12, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i12, 0, 0, i71, 14336, 0);
        ImageVector.Builder builder = builder3;
        int i6 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), 0, 0);
        int i10 = 0;
        int i21 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i26 = 0;
        PathBuilder builder7 = pathBuilder;
        final int i95 = 0;
        final ImageVector.Builder builder10 = builder;
        builder7.moveTo(1082130432, 1101004800);
        builder7.horizontalLineToRelative(1098907648);
        int i92 = -1073741824;
        PathBuilder builder8 = builder7;
        builder8.curveToRelative(1066192077, i71, 1073741824, -1083808154, 1073741824, i92);
        PathBuilder builder2 = builder8;
        builder2.verticalLineTo(1086324736);
        int i90 = -1073741824;
        builder8.curveToRelative(0, -1081291571, -1083808154, -1073741824, i90, i92);
        builder2.horizontalLineTo(1082130432);
        int i93 = 1073741824;
        builder8.curveToRelative(-1081291571, 0, -1073741824, 1063675494, i90, i93);
        builder2.verticalLineToRelative(1094713344);
        int i69 = 0;
        builder8.curveToRelative(i69, 1066192077, 1063675494, 1073741824, 1073741824, i93);
        builder2.close();
        builder2.moveTo(1101004800, 1086324736);
        builder2.lineToRelative(-1056964608, 1084206612);
        int i47 = 1082130432;
        builder2.lineTo(i47, 1086324736);
        builder2.horizontalLineToRelative(1098907648);
        builder2.close();
        int i41 = 1090519040;
        builder2.moveTo(i47, i41);
        builder2.lineToRelative(i41, 1084227584);
        builder2.lineToRelative(i41, -1063256064);
        builder2.verticalLineToRelative(1092616192);
        builder2.horizontalLineTo(1082130432);
        builder2.verticalLineTo(i41);
        builder2.close();
        EmailKt._email = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, i88, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i88, 0, i69, 0, 14336, 0).build();
        ImageVector _email3 = EmailKt._email;
        Intrinsics.checkNotNull(_email3);
        return _email3;
    }
}
