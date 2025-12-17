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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$Rounded;", "getSearch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SearchKt {

    private static ImageVector _search;
    static {
    }

    public static final ImageVector getSearch(Icons.Rounded $this$Search) {
        if (SearchKt._search != null) {
            ImageVector _search2 = SearchKt._search;
            Intrinsics.checkNotNull(_search2);
            return _search2;
        }
        String str = "Rounded.Search";
        int i13 = 0;
        int i14 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i12 = 0;
        int i16 = 0;
        int i22 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i22);
        final int i34 = 1065353216;
        int i18 = 0;
        int i20 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i23 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i86 = 0;
        final int i87 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1098383360, 1096810496);
        builder5.horizontalLineToRelative(-1085653647);
        builder5.lineToRelative(-1097901015, -1098236559);
        int i79 = -1062543032;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1067030938, -1078774989, 1072231875, -1068247286, 1069379748, i79);
        builder6.curveToRelative(-1091525673, -1070470267, -1070428324, -1063256064, -1062018744, i79);
        builder6.curveToRelative(-1064870871, -1090183496, -1057405010, 1078103900, -1058495529, 1088988119);
        int i75 = 1084940616;
        builder6.curveToRelative(1051595899, 1077097267, 1076090634, 1084479242, i75, 1085464904);
        builder6.curveToRelative(1073867653, 1051595899, 1081878774, -1097901015, i75, -1078103900);
        PathBuilder builder = builder6;
        builder.lineToRelative(1049247089, 1049582633);
        builder.verticalLineToRelative(1061830001);
        int i7 = 1082654720;
        builder.lineToRelative(i7, i7);
        int i42 = 1053944709;
        builder6.curveToRelative(i42, 1053944709, 1066024305, 1053944709, 1069463634, 0);
        builder6.curveToRelative(i42, -1093538939, 1053944709, -1081459343, 0, -1078020014);
        int i28 = 1096810496;
        builder.lineTo(1098383360, i28);
        builder.close();
        int i9 = 1092091904;
        builder.moveTo(i9, i28);
        builder6.curveTo(1088442860, 1096810496, 1084227584, 1094702858, 1084227584, 1092091904);
        int i29 = 1088442860;
        String str3 = str;
        int name$iv = 1084227584;
        builder.reflectiveCurveTo(i29, name$iv, i9, name$iv);
        int i10 = 1096810496;
        builder.reflectiveCurveTo(i10, i29, i10, i9);
        builder.reflectiveCurveTo(1094702858, i10, i9, i10);
        builder.close();
        SearchKt._search = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i22, 1065353216, i34, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i34, 0, 0, 0, 14336, 0).build();
        ImageVector _search3 = SearchKt._search;
        Intrinsics.checkNotNull(_search3);
        return _search3;
    }
}
