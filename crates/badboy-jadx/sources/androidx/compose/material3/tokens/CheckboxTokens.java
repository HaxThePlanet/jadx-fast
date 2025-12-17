package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u00081\n\u0002\u0018\u0002\n\u0002\u0008(\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0019\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0013R\u0019\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008#\u0010\u0006R\u0011\u0010$\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u0013R\u0011\u0010&\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u0013R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008)\u0010\u0006R\u0011\u0010*\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u0013R\u0011\u0010,\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u0013R\u0011\u0010.\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u0013R\u0019\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00081\u0010\u0006R\u0011\u00102\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u0013R\u0011\u00104\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010\u0013R\u0019\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00087\u0010\u0006R\u0011\u00108\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\u0013R\u0011\u0010:\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010\u0013R\u0019\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008=\u0010\u0006R\u0011\u0010>\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010\u0013R\u0019\u0010@\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008A\u0010\u0006R\u0011\u0010B\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010\u0013R\u0011\u0010D\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010\u0013R\u0019\u0010F\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008G\u0010\u0006R\u0011\u0010H\u001a\u00020I¢\u0006\u0008\n\u0000\u001a\u0004\u0008J\u0010KR\u0019\u0010L\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008M\u0010\u0006R\u000e\u0010N\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010O\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010\u0013R\u0019\u0010Q\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008R\u0010\u0006R\u0011\u0010S\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010\u0013R\u0019\u0010U\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008V\u0010\u0006R\u0011\u0010W\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008X\u0010\u0013R\u0019\u0010Y\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008Z\u0010\u0006R\u0011\u0010[\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\\\u0010\u0013R\u0011\u0010]\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008^\u0010\u0013R\u0019\u0010_\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008`\u0010\u0006R\u0011\u0010a\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008b\u0010\u0013R\u0019\u0010c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008d\u0010\u0006R\u0011\u0010e\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008f\u0010\u0013R\u0019\u0010g\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008h\u0010\u0006R\u0011\u0010i\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008j\u0010\u0013R\u0019\u0010k\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008l\u0010\u0006R\u0011\u0010m\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008n\u0010\u0013R\u0019\u0010o\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008p\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006q", d2 = {"Landroidx/compose/material3/tokens/CheckboxTokens;", "", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getContainerShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ContainerWidth", "getContainerWidth-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "SelectedContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getSelectedContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "SelectedDisabledContainerColor", "getSelectedDisabledContainerColor", "SelectedDisabledContainerOpacity", "", "SelectedDisabledContainerOutlineWidth", "getSelectedDisabledContainerOutlineWidth-D9Ej5fM", "SelectedDisabledIconColor", "getSelectedDisabledIconColor", "SelectedErrorContainerColor", "getSelectedErrorContainerColor", "SelectedErrorFocusContainerColor", "getSelectedErrorFocusContainerColor", "SelectedErrorFocusIconColor", "getSelectedErrorFocusIconColor", "SelectedErrorFocusOutlineWidth", "getSelectedErrorFocusOutlineWidth-D9Ej5fM", "SelectedErrorHoverContainerColor", "getSelectedErrorHoverContainerColor", "SelectedErrorHoverIconColor", "getSelectedErrorHoverIconColor", "SelectedErrorHoverOutlineWidth", "getSelectedErrorHoverOutlineWidth-D9Ej5fM", "SelectedErrorIconColor", "getSelectedErrorIconColor", "SelectedErrorPressedContainerColor", "getSelectedErrorPressedContainerColor", "SelectedErrorPressedIconColor", "getSelectedErrorPressedIconColor", "SelectedErrorPressedOutlineWidth", "getSelectedErrorPressedOutlineWidth-D9Ej5fM", "SelectedFocusContainerColor", "getSelectedFocusContainerColor", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedFocusOutlineWidth", "getSelectedFocusOutlineWidth-D9Ej5fM", "SelectedHoverContainerColor", "getSelectedHoverContainerColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedHoverOutlineWidth", "getSelectedHoverOutlineWidth-D9Ej5fM", "SelectedIconColor", "getSelectedIconColor", "SelectedOutlineWidth", "getSelectedOutlineWidth-D9Ej5fM", "SelectedPressedContainerColor", "getSelectedPressedContainerColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "SelectedPressedOutlineWidth", "getSelectedPressedOutlineWidth-D9Ej5fM", "StateLayerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getStateLayerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedDisabledContainerOpacity", "UnselectedDisabledOutlineColor", "getUnselectedDisabledOutlineColor", "UnselectedDisabledOutlineWidth", "getUnselectedDisabledOutlineWidth-D9Ej5fM", "UnselectedErrorFocusOutlineColor", "getUnselectedErrorFocusOutlineColor", "UnselectedErrorFocusOutlineWidth", "getUnselectedErrorFocusOutlineWidth-D9Ej5fM", "UnselectedErrorHoverOutlineColor", "getUnselectedErrorHoverOutlineColor", "UnselectedErrorHoverOutlineWidth", "getUnselectedErrorHoverOutlineWidth-D9Ej5fM", "UnselectedErrorOutlineColor", "getUnselectedErrorOutlineColor", "UnselectedErrorPressedOutlineColor", "getUnselectedErrorPressedOutlineColor", "UnselectedErrorPressedOutlineWidth", "getUnselectedErrorPressedOutlineWidth-D9Ej5fM", "UnselectedFocusOutlineColor", "getUnselectedFocusOutlineColor", "UnselectedFocusOutlineWidth", "getUnselectedFocusOutlineWidth-D9Ej5fM", "UnselectedHoverOutlineColor", "getUnselectedHoverOutlineColor", "UnselectedHoverOutlineWidth", "getUnselectedHoverOutlineWidth-D9Ej5fM", "UnselectedOutlineColor", "getUnselectedOutlineColor", "UnselectedOutlineWidth", "getUnselectedOutlineWidth-D9Ej5fM", "UnselectedPressedOutlineColor", "getUnselectedPressedOutlineColor", "UnselectedPressedOutlineWidth", "getUnselectedPressedOutlineWidth-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CheckboxTokens {

    public static final int $stable = 0;
    private static final float ContainerHeight = 0f;
    private static final RoundedCornerShape ContainerShape = null;
    private static final float ContainerWidth = 0f;
    public static final androidx.compose.material3.tokens.CheckboxTokens INSTANCE = null;
    private static final float IconSize = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedDisabledContainerColor = null;
    public static final float SelectedDisabledContainerOpacity = 0.38f;
    private static final float SelectedDisabledContainerOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedDisabledIconColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorFocusContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorFocusIconColor = null;
    private static final float SelectedErrorFocusOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorHoverContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorHoverIconColor = null;
    private static final float SelectedErrorHoverOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorIconColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorPressedContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedErrorPressedIconColor = null;
    private static final float SelectedErrorPressedOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedFocusContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedFocusIconColor = null;
    private static final float SelectedFocusOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedHoverContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedHoverIconColor = null;
    private static final float SelectedHoverOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedIconColor = null;
    private static final float SelectedOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedPressedContainerColor = null;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedPressedIconColor = null;
    private static final float SelectedPressedOutlineWidth = 0f;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens StateLayerShape = null;
    private static final float StateLayerSize = 0f;
    public static final float UnselectedDisabledContainerOpacity = 0.38f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedDisabledOutlineColor;
    private static final float UnselectedDisabledOutlineWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedErrorFocusOutlineColor;
    private static final float UnselectedErrorFocusOutlineWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedErrorHoverOutlineColor;
    private static final float UnselectedErrorHoverOutlineWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedErrorOutlineColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedErrorPressedOutlineColor;
    private static final float UnselectedErrorPressedOutlineWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedFocusOutlineColor;
    private static final float UnselectedFocusOutlineWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedHoverOutlineColor;
    private static final float UnselectedHoverOutlineWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedOutlineColor;
    private static final float UnselectedOutlineWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedPressedOutlineColor;
    private static final float UnselectedPressedOutlineWidth;
    static {
        CheckboxTokens checkboxTokens = new CheckboxTokens();
        CheckboxTokens.INSTANCE = checkboxTokens;
        int i9 = 0;
        CheckboxTokens.ContainerHeight = Dp.constructor-impl((float)l);
        int i10 = 0;
        CheckboxTokens.ContainerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)l2));
        int i11 = 0;
        CheckboxTokens.ContainerWidth = Dp.constructor-impl((float)l3);
        int i12 = 0;
        CheckboxTokens.IconSize = Dp.constructor-impl((float)l4);
        CheckboxTokens.SelectedContainerColor = ColorSchemeKeyTokens.Primary;
        CheckboxTokens.SelectedDisabledContainerColor = ColorSchemeKeyTokens.OnSurface;
        int i13 = 0;
        CheckboxTokens.SelectedDisabledContainerOutlineWidth = Dp.constructor-impl((float)i);
        CheckboxTokens.SelectedDisabledIconColor = ColorSchemeKeyTokens.Surface;
        CheckboxTokens.SelectedErrorContainerColor = ColorSchemeKeyTokens.Error;
        CheckboxTokens.SelectedErrorFocusContainerColor = ColorSchemeKeyTokens.Error;
        CheckboxTokens.SelectedErrorFocusIconColor = ColorSchemeKeyTokens.OnError;
        int i14 = 0;
        CheckboxTokens.SelectedErrorFocusOutlineWidth = Dp.constructor-impl((float)i2);
        CheckboxTokens.SelectedErrorHoverContainerColor = ColorSchemeKeyTokens.Error;
        CheckboxTokens.SelectedErrorHoverIconColor = ColorSchemeKeyTokens.OnError;
        int i15 = 0;
        CheckboxTokens.SelectedErrorHoverOutlineWidth = Dp.constructor-impl((float)i3);
        CheckboxTokens.SelectedErrorIconColor = ColorSchemeKeyTokens.OnError;
        CheckboxTokens.SelectedErrorPressedContainerColor = ColorSchemeKeyTokens.Error;
        CheckboxTokens.SelectedErrorPressedIconColor = ColorSchemeKeyTokens.OnError;
        int i16 = 0;
        CheckboxTokens.SelectedErrorPressedOutlineWidth = Dp.constructor-impl((float)i4);
        CheckboxTokens.SelectedFocusContainerColor = ColorSchemeKeyTokens.Primary;
        CheckboxTokens.SelectedFocusIconColor = ColorSchemeKeyTokens.OnPrimary;
        int i17 = 0;
        CheckboxTokens.SelectedFocusOutlineWidth = Dp.constructor-impl((float)i5);
        CheckboxTokens.SelectedHoverContainerColor = ColorSchemeKeyTokens.Primary;
        CheckboxTokens.SelectedHoverIconColor = ColorSchemeKeyTokens.OnPrimary;
        int i18 = 0;
        CheckboxTokens.SelectedHoverOutlineWidth = Dp.constructor-impl((float)i6);
        CheckboxTokens.SelectedIconColor = ColorSchemeKeyTokens.OnPrimary;
        int i19 = 0;
        CheckboxTokens.SelectedOutlineWidth = Dp.constructor-impl((float)i7);
        CheckboxTokens.SelectedPressedContainerColor = ColorSchemeKeyTokens.Primary;
        CheckboxTokens.SelectedPressedIconColor = ColorSchemeKeyTokens.OnPrimary;
        int i20 = 0;
        CheckboxTokens.SelectedPressedOutlineWidth = Dp.constructor-impl((float)i8);
        CheckboxTokens.StateLayerShape = ShapeKeyTokens.CornerFull;
        int i21 = 0;
        CheckboxTokens.StateLayerSize = Dp.constructor-impl((float)l5);
        CheckboxTokens.UnselectedDisabledOutlineColor = ColorSchemeKeyTokens.OnSurface;
        int i22 = 0;
        CheckboxTokens.UnselectedDisabledOutlineWidth = Dp.constructor-impl((float)l6);
        CheckboxTokens.UnselectedErrorFocusOutlineColor = ColorSchemeKeyTokens.Error;
        int i23 = 0;
        CheckboxTokens.UnselectedErrorFocusOutlineWidth = Dp.constructor-impl((float)l7);
        CheckboxTokens.UnselectedErrorHoverOutlineColor = ColorSchemeKeyTokens.Error;
        int i24 = 0;
        CheckboxTokens.UnselectedErrorHoverOutlineWidth = Dp.constructor-impl((float)l8);
        CheckboxTokens.UnselectedErrorOutlineColor = ColorSchemeKeyTokens.Error;
        CheckboxTokens.UnselectedErrorPressedOutlineColor = ColorSchemeKeyTokens.Error;
        int i25 = 0;
        CheckboxTokens.UnselectedErrorPressedOutlineWidth = Dp.constructor-impl((float)l9);
        CheckboxTokens.UnselectedFocusOutlineColor = ColorSchemeKeyTokens.OnSurface;
        int i26 = 0;
        CheckboxTokens.UnselectedFocusOutlineWidth = Dp.constructor-impl((float)l10);
        CheckboxTokens.UnselectedHoverOutlineColor = ColorSchemeKeyTokens.OnSurface;
        int i27 = 0;
        CheckboxTokens.UnselectedHoverOutlineWidth = Dp.constructor-impl((float)l11);
        CheckboxTokens.UnselectedOutlineColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        int i28 = 0;
        CheckboxTokens.UnselectedOutlineWidth = Dp.constructor-impl((float)l12);
        CheckboxTokens.UnselectedPressedOutlineColor = ColorSchemeKeyTokens.OnSurface;
        int i29 = 0;
        CheckboxTokens.UnselectedPressedOutlineWidth = Dp.constructor-impl((float)l13);
    }

    public final float getContainerHeight-D9Ej5fM() {
        return CheckboxTokens.ContainerHeight;
    }

    public final RoundedCornerShape getContainerShape() {
        return CheckboxTokens.ContainerShape;
    }

    public final float getContainerWidth-D9Ej5fM() {
        return CheckboxTokens.ContainerWidth;
    }

    public final float getIconSize-D9Ej5fM() {
        return CheckboxTokens.IconSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedContainerColor() {
        return CheckboxTokens.SelectedContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedDisabledContainerColor() {
        return CheckboxTokens.SelectedDisabledContainerColor;
    }

    public final float getSelectedDisabledContainerOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedDisabledContainerOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedDisabledIconColor() {
        return CheckboxTokens.SelectedDisabledIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorContainerColor() {
        return CheckboxTokens.SelectedErrorContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorFocusContainerColor() {
        return CheckboxTokens.SelectedErrorFocusContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorFocusIconColor() {
        return CheckboxTokens.SelectedErrorFocusIconColor;
    }

    public final float getSelectedErrorFocusOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedErrorFocusOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorHoverContainerColor() {
        return CheckboxTokens.SelectedErrorHoverContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorHoverIconColor() {
        return CheckboxTokens.SelectedErrorHoverIconColor;
    }

    public final float getSelectedErrorHoverOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedErrorHoverOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorIconColor() {
        return CheckboxTokens.SelectedErrorIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorPressedContainerColor() {
        return CheckboxTokens.SelectedErrorPressedContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedErrorPressedIconColor() {
        return CheckboxTokens.SelectedErrorPressedIconColor;
    }

    public final float getSelectedErrorPressedOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedErrorPressedOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedFocusContainerColor() {
        return CheckboxTokens.SelectedFocusContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return CheckboxTokens.SelectedFocusIconColor;
    }

    public final float getSelectedFocusOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedFocusOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedHoverContainerColor() {
        return CheckboxTokens.SelectedHoverContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return CheckboxTokens.SelectedHoverIconColor;
    }

    public final float getSelectedHoverOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedHoverOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedIconColor() {
        return CheckboxTokens.SelectedIconColor;
    }

    public final float getSelectedOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedPressedContainerColor() {
        return CheckboxTokens.SelectedPressedContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return CheckboxTokens.SelectedPressedIconColor;
    }

    public final float getSelectedPressedOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.SelectedPressedOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getStateLayerShape() {
        return CheckboxTokens.StateLayerShape;
    }

    public final float getStateLayerSize-D9Ej5fM() {
        return CheckboxTokens.StateLayerSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedDisabledOutlineColor() {
        return CheckboxTokens.UnselectedDisabledOutlineColor;
    }

    public final float getUnselectedDisabledOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedDisabledOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedErrorFocusOutlineColor() {
        return CheckboxTokens.UnselectedErrorFocusOutlineColor;
    }

    public final float getUnselectedErrorFocusOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedErrorFocusOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedErrorHoverOutlineColor() {
        return CheckboxTokens.UnselectedErrorHoverOutlineColor;
    }

    public final float getUnselectedErrorHoverOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedErrorHoverOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedErrorOutlineColor() {
        return CheckboxTokens.UnselectedErrorOutlineColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedErrorPressedOutlineColor() {
        return CheckboxTokens.UnselectedErrorPressedOutlineColor;
    }

    public final float getUnselectedErrorPressedOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedErrorPressedOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedFocusOutlineColor() {
        return CheckboxTokens.UnselectedFocusOutlineColor;
    }

    public final float getUnselectedFocusOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedFocusOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedHoverOutlineColor() {
        return CheckboxTokens.UnselectedHoverOutlineColor;
    }

    public final float getUnselectedHoverOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedHoverOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedOutlineColor() {
        return CheckboxTokens.UnselectedOutlineColor;
    }

    public final float getUnselectedOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedOutlineWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedPressedOutlineColor() {
        return CheckboxTokens.UnselectedPressedOutlineColor;
    }

    public final float getUnselectedPressedOutlineWidth-D9Ej5fM() {
        return CheckboxTokens.UnselectedPressedOutlineWidth;
    }
}
