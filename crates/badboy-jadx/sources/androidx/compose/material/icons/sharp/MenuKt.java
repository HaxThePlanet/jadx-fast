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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_menu", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Menu", "Landroidx/compose/material/icons/Icons$Sharp;", "getMenu", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {

    private static ImageVector _menu;
    static {
    }

    public static final ImageVector getMenu(Icons.Sharp $this$Menu) {
        if (MenuKt._menu != null) {
            ImageVector _menu2 = MenuKt._menu;
            Intrinsics.checkNotNull(_menu2);
            return _menu2;
        }
        int i17 = 0;
        int i18 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Menu", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i16 = 0;
        int i20 = 0;
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i26);
        final int i34 = 1065353216;
        int i22 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i27 = 0;
        PathBuilder builder4 = pathBuilder;
        int i36 = 0;
        final int i42 = i;
        int $i$f$materialIcon = 1077936128;
        final ImageVector.Builder builder5 = builder;
        int $this$_get_Menu__u24lambda_u241 = 1099956224;
        builder4.moveTo($i$f$materialIcon, $this$_get_Menu__u24lambda_u241);
        builder4.horizontalLineToRelative($this$_get_Menu__u24lambda_u241);
        builder4.verticalLineToRelative(-1073741824);
        builder4.lineTo($i$f$materialIcon, 1098907648);
        builder4.verticalLineToRelative(1073741824);
        builder4.close();
        builder4.moveTo($i$f$materialIcon, 1095761920);
        builder4.horizontalLineToRelative(1099956224);
        builder4.verticalLineToRelative(-1073741824);
        builder4.lineTo($i$f$materialIcon, 1093664768);
        builder4.verticalLineToRelative(1073741824);
        builder4.close();
        int i14 = 1086324736;
        builder4.moveTo($i$f$materialIcon, i14);
        builder4.verticalLineToRelative(1073741824);
        builder4.horizontalLineToRelative(1099956224);
        builder4.lineTo(1101529088, i14);
        builder4.lineTo(1077936128, i14);
        builder4.close();
        MenuKt._menu = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i26, 1065353216, i34, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i34, 0, 0, 0, 14336, 0).build();
        ImageVector _menu3 = MenuKt._menu;
        Intrinsics.checkNotNull(_menu3);
        return _menu3;
    }
}
