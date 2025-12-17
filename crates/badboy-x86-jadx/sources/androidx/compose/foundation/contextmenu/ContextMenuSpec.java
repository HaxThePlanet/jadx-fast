package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\u00080\u00101R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0019\u0010\"\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008#\u0010\u000fR\u0019\u0010$\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008%\u0010\u000fR\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008+\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00062", d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuSpec;", "", "()V", "ContainerWidthMax", "Landroidx/compose/ui/unit/Dp;", "getContainerWidthMax-D9Ej5fM", "()F", "F", "ContainerWidthMin", "getContainerWidthMin-D9Ej5fM", "CornerRadius", "getCornerRadius-D9Ej5fM", "FontSize", "Landroidx/compose/ui/unit/TextUnit;", "getFontSize-XSAIIZE", "()J", "J", "FontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "HorizontalPadding", "getHorizontalPadding-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LabelHorizontalTextAlignment", "Landroidx/compose/ui/text/style/TextAlign;", "getLabelHorizontalTextAlignment-e0LSkKk", "()I", "I", "LabelVerticalTextAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "getLabelVerticalTextAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "LetterSpacing", "getLetterSpacing-XSAIIZE", "LineHeight", "getLineHeight-XSAIIZE", "ListItemHeight", "getListItemHeight-D9Ej5fM", "MenuContainerElevation", "getMenuContainerElevation-D9Ej5fM", "VerticalPadding", "getVerticalPadding-D9Ej5fM", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "textStyle-8_81llA", "(J)Landroidx/compose/ui/text/TextStyle;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuSpec {

    public static final int $stable;
    private static final float ContainerWidthMax;
    private static final float ContainerWidthMin;
    private static final float CornerRadius;
    private static final long FontSize;
    private static final FontWeight FontWeight;
    private static final float HorizontalPadding;
    public static final androidx.compose.foundation.contextmenu.ContextMenuSpec INSTANCE;
    private static final float IconSize;
    private static final int LabelHorizontalTextAlignment;
    private static final Alignment.Vertical LabelVerticalTextAlignment;
    private static final long LetterSpacing;
    private static final long LineHeight;
    private static final float ListItemHeight;
    private static final float MenuContainerElevation;
    private static final float VerticalPadding;
    static {
        ContextMenuSpec contextMenuSpec = new ContextMenuSpec();
        ContextMenuSpec.INSTANCE = contextMenuSpec;
        int i12 = 0;
        ContextMenuSpec.ContainerWidthMin = Dp.constructor-impl((float)i);
        int i13 = 0;
        ContextMenuSpec.ContainerWidthMax = Dp.constructor-impl((float)i2);
        int i14 = 0;
        ContextMenuSpec.ListItemHeight = Dp.constructor-impl((float)i3);
        int i15 = 0;
        ContextMenuSpec.MenuContainerElevation = Dp.constructor-impl((float)i4);
        int i16 = 0;
        ContextMenuSpec.CornerRadius = Dp.constructor-impl((float)i5);
        ContextMenuSpec.LabelVerticalTextAlignment = Alignment.Companion.getCenterVertically();
        ContextMenuSpec.LabelHorizontalTextAlignment = TextAlign.Companion.getStart-e0LSkKk();
        int i17 = 0;
        ContextMenuSpec.HorizontalPadding = Dp.constructor-impl((float)i6);
        int i18 = 0;
        ContextMenuSpec.VerticalPadding = Dp.constructor-impl((float)i7);
        int i19 = 0;
        ContextMenuSpec.IconSize = Dp.constructor-impl((float)i8);
        ContextMenuSpec.FontSize = TextUnitKt.getSp(14);
        ContextMenuSpec.FontWeight = FontWeight.Companion.getMedium();
        ContextMenuSpec.LineHeight = TextUnitKt.getSp(20);
        ContextMenuSpec.LetterSpacing = TextUnitKt.getSp(1036831949);
    }

    public final float getContainerWidthMax-D9Ej5fM() {
        return ContextMenuSpec.ContainerWidthMax;
    }

    public final float getContainerWidthMin-D9Ej5fM() {
        return ContextMenuSpec.ContainerWidthMin;
    }

    public final float getCornerRadius-D9Ej5fM() {
        return ContextMenuSpec.CornerRadius;
    }

    public final long getFontSize-XSAIIZE() {
        return ContextMenuSpec.FontSize;
    }

    public final FontWeight getFontWeight() {
        return ContextMenuSpec.FontWeight;
    }

    public final float getHorizontalPadding-D9Ej5fM() {
        return ContextMenuSpec.HorizontalPadding;
    }

    public final float getIconSize-D9Ej5fM() {
        return ContextMenuSpec.IconSize;
    }

    public final int getLabelHorizontalTextAlignment-e0LSkKk() {
        return ContextMenuSpec.LabelHorizontalTextAlignment;
    }

    public final Alignment.Vertical getLabelVerticalTextAlignment() {
        return ContextMenuSpec.LabelVerticalTextAlignment;
    }

    public final long getLetterSpacing-XSAIIZE() {
        return ContextMenuSpec.LetterSpacing;
    }

    public final long getLineHeight-XSAIIZE() {
        return ContextMenuSpec.LineHeight;
    }

    public final float getListItemHeight-D9Ej5fM() {
        return ContextMenuSpec.ListItemHeight;
    }

    public final float getMenuContainerElevation-D9Ej5fM() {
        return ContextMenuSpec.MenuContainerElevation;
    }

    public final float getVerticalPadding-D9Ej5fM() {
        return ContextMenuSpec.VerticalPadding;
    }

    public final TextStyle textStyle-8_81llA(long color) {
        TextStyle textStyle = new TextStyle(color, obj2, ContextMenuSpec.FontSize, obj4, ContextMenuSpec.FontWeight, 0, 0, 0, 0, ContextMenuSpec.LetterSpacing, obj11, 0, 0, 0, 0, obj16, 0, 0, 0, ContextMenuSpec.LabelHorizontalTextAlignment, 0, ContextMenuSpec.LineHeight, obj23, 0, 0, 0, 0, 0, 0, 16613240, 0);
        return textStyle;
    }
}
