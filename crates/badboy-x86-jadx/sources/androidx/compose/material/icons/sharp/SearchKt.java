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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$Sharp;", "getSearch", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SearchKt {

    private static ImageVector _search;
    static {
    }

    public static final ImageVector getSearch(Icons.Sharp $this$Search) {
        if (SearchKt._search != null) {
            ImageVector _search2 = SearchKt._search;
            Intrinsics.checkNotNull(_search2);
            return _search2;
        }
        String str = "Sharp.Search";
        int i17 = 0;
        int i18 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i16 = 0;
        int i20 = 0;
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i26);
        final int i41 = 1065353216;
        int i22 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i27 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i72 = 0;
        final int i73 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1098383360, 1096810496);
        builder5.horizontalLineToRelative(-1085653647);
        builder5.lineToRelative(-1097901015, -1098236559);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1098288988, 1095332004, 1098907648, 1093780111, 1098907648, 1092091904);
        builder6.curveTo(1098907648, 1086135992, 1095856292, 1077936128, 1092091904, 1077936128);
        PathBuilder builder = builder6;
        int i5 = 1077936128;
        int i31 = 1086135992;
        final String str3 = str;
        int name$iv = 1092091904;
        builder.reflectiveCurveTo(i5, i31, i5, name$iv);
        int i6 = 1098907648;
        builder.reflectiveCurveTo(i31, i6, name$iv, i6);
        builder6.curveToRelative(1070470267, 0, 1078313615, -1089009091, 1082612777, -1077348925);
        builder.lineToRelative(1049247089, 1049582633);
        builder.verticalLineToRelative(1061830001);
        builder.lineToRelative(1084227584, 1084206612);
        builder.lineTo(1101261701, 1100480512);
        builder.lineToRelative(-1063277036, -1063256064);
        builder.close();
        builder.moveTo(name$iv, 1096810496);
        builder6.curveTo(1088442860, 1096810496, 1084227584, 1094702858, 1084227584, 1092091904);
        int i13 = 1088442860;
        int i36 = 1084227584;
        builder.reflectiveCurveTo(i13, i36, name$iv, i36);
        int i37 = 1096810496;
        builder.reflectiveCurveTo(i37, i13, i37, name$iv);
        builder.reflectiveCurveTo(1094702858, i37, name$iv, i37);
        builder.close();
        SearchKt._search = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i26, 1065353216, i41, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i41, 0, 0, 0, 14336, 0).build();
        ImageVector _search3 = SearchKt._search;
        Intrinsics.checkNotNull(_search3);
        return _search3;
    }
}
