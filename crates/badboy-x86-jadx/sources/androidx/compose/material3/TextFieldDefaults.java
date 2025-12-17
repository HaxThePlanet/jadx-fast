package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u00087\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\\\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020\u001f2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00152\u0008\u0008\u0002\u0010-\u001a\u00020\u00042\u0008\u0008\u0002\u0010.\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u00100J7\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001f2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u00102J¦\u0002\u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020$07¢\u0006\u0002\u000882\u0006\u0010%\u001a\u00020&2\u0006\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010'\u001a\u00020&2\u0015\u0008\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\u000882\u0015\u0008\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\u000882\u0015\u0008\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\u000882\u0015\u0008\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\u000882\u0015\u0008\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\u000882\u0015\u0008\u0002\u0010A\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\u000882\u0015\u0008\u0002\u0010B\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\u000882\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00152\u0008\u0008\u0002\u0010,\u001a\u00020\u001f2\u0008\u0008\u0002\u0010C\u001a\u00020D2\u0013\u0008\u0002\u0010E\u001a\r\u0012\u0004\u0012\u00020$07¢\u0006\u0002\u00088H\u0007¢\u0006\u0002\u0010FJ\r\u0010,\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010GJÂ\u0003\u0010,\u001a\u00020\u001f2\u0008\u0008\u0002\u0010H\u001a\u00020I2\u0008\u0008\u0002\u0010J\u001a\u00020I2\u0008\u0008\u0002\u0010K\u001a\u00020I2\u0008\u0008\u0002\u0010L\u001a\u00020I2\u0008\u0008\u0002\u0010M\u001a\u00020I2\u0008\u0008\u0002\u0010N\u001a\u00020I2\u0008\u0008\u0002\u0010O\u001a\u00020I2\u0008\u0008\u0002\u0010P\u001a\u00020I2\u0008\u0008\u0002\u0010Q\u001a\u00020I2\u0008\u0008\u0002\u0010R\u001a\u00020I2\n\u0008\u0002\u0010S\u001a\u0004\u0018\u00010T2\u0008\u0008\u0002\u0010U\u001a\u00020I2\u0008\u0008\u0002\u0010V\u001a\u00020I2\u0008\u0008\u0002\u0010W\u001a\u00020I2\u0008\u0008\u0002\u0010X\u001a\u00020I2\u0008\u0008\u0002\u0010Y\u001a\u00020I2\u0008\u0008\u0002\u0010Z\u001a\u00020I2\u0008\u0008\u0002\u0010[\u001a\u00020I2\u0008\u0008\u0002\u0010\\\u001a\u00020I2\u0008\u0008\u0002\u0010]\u001a\u00020I2\u0008\u0008\u0002\u0010^\u001a\u00020I2\u0008\u0008\u0002\u0010_\u001a\u00020I2\u0008\u0008\u0002\u0010`\u001a\u00020I2\u0008\u0008\u0002\u0010a\u001a\u00020I2\u0008\u0008\u0002\u0010b\u001a\u00020I2\u0008\u0008\u0002\u0010c\u001a\u00020I2\u0008\u0008\u0002\u0010d\u001a\u00020I2\u0008\u0008\u0002\u0010e\u001a\u00020I2\u0008\u0008\u0002\u0010f\u001a\u00020I2\u0008\u0008\u0002\u0010g\u001a\u00020I2\u0008\u0008\u0002\u0010h\u001a\u00020I2\u0008\u0008\u0002\u0010i\u001a\u00020I2\u0008\u0008\u0002\u0010j\u001a\u00020I2\u0008\u0008\u0002\u0010k\u001a\u00020I2\u0008\u0008\u0002\u0010l\u001a\u00020I2\u0008\u0008\u0002\u0010m\u001a\u00020I2\u0008\u0008\u0002\u0010n\u001a\u00020I2\u0008\u0008\u0002\u0010o\u001a\u00020I2\u0008\u0008\u0002\u0010p\u001a\u00020I2\u0008\u0008\u0002\u0010q\u001a\u00020I2\u0008\u0008\u0002\u0010r\u001a\u00020I2\u0008\u0008\u0002\u0010s\u001a\u00020I2\u0008\u0008\u0002\u0010t\u001a\u00020IH\u0007ø\u0001\u0000¢\u0006\u0004\u0008u\u0010vJ8\u0010w\u001a\u00020D2\u0008\u0008\u0002\u0010x\u001a\u00020\u00042\u0008\u0008\u0002\u0010y\u001a\u00020\u00042\u0008\u0008\u0002\u0010z\u001a\u00020\u00042\u0008\u0008\u0002\u0010{\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008|\u0010}J8\u0010~\u001a\u00020D2\u0008\u0008\u0002\u0010x\u001a\u00020\u00042\u0008\u0008\u0002\u0010z\u001a\u00020\u00042\u0008\u0008\u0002\u0010y\u001a\u00020\u00042\u0008\u0008\u0002\u0010{\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008\u007f\u0010}J<\u0010\u0080\u0001\u001a\u00020D2\u0008\u0008\u0002\u0010x\u001a\u00020\u00042\u0008\u0008\u0002\u0010z\u001a\u00020\u00042\u0008\u0008\u0002\u0010y\u001a\u00020\u00042\u0008\u0008\u0002\u0010{\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0005\u0008\u0081\u0001\u0010}J<\u0010\u0082\u0001\u001a\u00020D2\u0008\u0008\u0002\u0010x\u001a\u00020\u00042\u0008\u0008\u0002\u0010z\u001a\u00020\u00042\u0008\u0008\u0002\u0010y\u001a\u00020\u00042\u0008\u0008\u0002\u0010{\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0005\u0008\u0083\u0001\u0010}J<\u0010\u0084\u0001\u001a\u00020D2\u0008\u0008\u0002\u0010x\u001a\u00020\u00042\u0008\u0008\u0002\u0010y\u001a\u00020\u00042\u0008\u0008\u0002\u0010z\u001a\u00020\u00042\u0008\u0008\u0002\u0010{\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0005\u0008\u0085\u0001\u0010}J<\u0010\u0086\u0001\u001a\u00020D2\u0008\u0008\u0002\u0010x\u001a\u00020\u00042\u0008\u0008\u0002\u0010z\u001a\u00020\u00042\u0008\u0008\u0002\u0010y\u001a\u00020\u00042\u0008\u0008\u0002\u0010{\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0005\u0008\u0087\u0001\u0010}JM\u0010\u0088\u0001\u001a\u00020+*\u00020+2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001f2\u0008\u0008\u0002\u0010-\u001a\u00020\u00042\u0008\u0008\u0002\u0010.\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u0089\u0001\u0010\u008a\u0001R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u000c\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0010\u0010\u0002\u001a\u0004\u0008\u0011\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00158GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0016\u0010\u0002\u001a\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u0002\u001a\u0004\u0008\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0018R\u0018\u0010\u001e\u001a\u00020\u001f*\u00020 8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u008b\u0001", d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape$annotations", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "shape", "getShape", "defaultTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "Container", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "ContainerBox", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDefaults {

    public static final int $stable;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final androidx.compose.material3.TextFieldDefaults INSTANCE;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;
    static {
        TextFieldDefaults textFieldDefaults = new TextFieldDefaults();
        TextFieldDefaults.INSTANCE = textFieldDefaults;
        int i5 = 0;
        TextFieldDefaults.MinHeight = Dp.constructor-impl((float)i);
        int i6 = 0;
        TextFieldDefaults.MinWidth = Dp.constructor-impl((float)i2);
        int i7 = 0;
        TextFieldDefaults.UnfocusedIndicatorThickness = Dp.constructor-impl((float)i3);
        int i8 = 0;
        TextFieldDefaults.FocusedIndicatorThickness = Dp.constructor-impl((float)i4);
        TextFieldDefaults.UnfocusedBorderThickness = TextFieldDefaults.UnfocusedIndicatorThickness;
        TextFieldDefaults.FocusedBorderThickness = TextFieldDefaults.FocusedIndicatorThickness;
    }

    public static PaddingValues contentPaddingWithLabel-a9UjIt4$default(androidx.compose.material3.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 2 != 0) {
            obj2 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 4 != 0) {
            obj3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if (i6 &= 8 != 0) {
            obj4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.contentPaddingWithLabel-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public static PaddingValues contentPaddingWithoutLabel-a9UjIt4$default(androidx.compose.material3.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 2 != 0) {
            obj2 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 4 != 0) {
            obj3 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 &= 8 != 0) {
            obj4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.contentPaddingWithoutLabel-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(...))
    public static void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(...))
    public static void getFocusedBorderThickness-D9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(...))
    public static void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(...))
    public static void getUnfocusedBorderThickness-D9Ej5fM$annotations() {
    }

    public static Modifier indicatorLine-gv0btCI$default(androidx.compose.material3.TextFieldDefaults textFieldDefaults, Modifier modifier2, boolean z3, boolean z4, InteractionSource interactionSource5, androidx.compose.material3.TextFieldColors textFieldColors6, float f7, float f8, int i9, Object object10) {
        float f;
        float f2;
        float obj14;
        f = i9 & 16 != 0 ? obj14 : f7;
        f2 = i9 & 32 != 0 ? obj14 : f8;
        return textFieldDefaults.indicatorLine-gv0btCI(modifier2, z3, z4, interactionSource5, textFieldColors6, f, f2);
    }

    public static PaddingValues outlinedTextFieldPadding-a9UjIt4$default(androidx.compose.material3.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 2 != 0) {
            obj2 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 4 != 0) {
            obj3 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 &= 8 != 0) {
            obj4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.outlinedTextFieldPadding-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public static PaddingValues supportingTextPadding-a9UjIt4$material3_release$default(androidx.compose.material3.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        int obj5;
        int obj6;
        if (i6 & 1 != 0) {
            obj1 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 2 != 0) {
            obj2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if (i6 & 4 != 0) {
            obj3 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 &= 8 != 0) {
            obj5 = 0;
            obj4 = Dp.constructor-impl((float)obj4);
        }
        return textFieldDefaults.supportingTextPadding-a9UjIt4$material3_release(obj1, obj2, obj3, obj4);
    }

    public static PaddingValues textFieldWithLabelPadding-a9UjIt4$default(androidx.compose.material3.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 2 != 0) {
            obj2 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 4 != 0) {
            obj3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if (i6 &= 8 != 0) {
            obj4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.textFieldWithLabelPadding-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public static PaddingValues textFieldWithoutLabelPadding-a9UjIt4$default(androidx.compose.material3.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 2 != 0) {
            obj2 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 & 4 != 0) {
            obj3 = TextFieldImplKt.getTextFieldPadding();
        }
        if (i6 &= 8 != 0) {
            obj4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.textFieldWithoutLabelPadding-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public final void Container-4EFweAY(boolean enabled, boolean isError, InteractionSource interactionSource, Modifier modifier, androidx.compose.material3.TextFieldColors colors, Shape shape, float focusedIndicatorLineThickness, float unfocusedIndicatorLineThickness, Composer $composer, int $changed, int i11) {
        Object traceInProgress2;
        boolean indicatorLine-gv0btCI;
        int defaultsInvalid;
        int colors3;
        int colors2;
        int shape4;
        Object $dirty2;
        boolean z2;
        boolean z3;
        Object obj3;
        Object $composer2;
        int $dirty4;
        Object $dirty3;
        float $dirty;
        int i2;
        int i4;
        int i7;
        Object unfocusedIndicatorLineThickness2;
        float f;
        Object obj2;
        float modifier2;
        int i6;
        Object obj5;
        float shape3;
        int changed4;
        Object obj4;
        Composer composer;
        int shape2;
        int changed2;
        float f2;
        boolean traceInProgress;
        int changed3;
        float str;
        int changed;
        int i3;
        int i;
        int i5;
        int i8;
        Composer composer2;
        int i9;
        int i10;
        boolean z;
        int i12;
        Object obj;
        int obj27;
        int obj32;
        traceInProgress2 = this;
        z2 = enabled;
        z3 = isError;
        obj3 = interactionSource;
        final int i30 = $changed;
        final int i31 = i11;
        Composer restartGroup = $composer.startRestartGroup(-818661242);
        ComposerKt.sourceInformation(restartGroup, "C(Container)P(1,4,3,5!1,6,2:c#ui.unit.Dp,7:c#ui.unit.Dp)105@4681L8,106@4732L5,110@4933L25,112@5006L198,116@5213L496:TextFieldDefaults.kt#uh7d8r");
        $dirty4 = $changed;
        if (i31 & 1 != 0) {
            $dirty4 |= 6;
        } else {
            if (i30 & 6 == 0) {
                i2 = restartGroup.changed(z2) ? 4 : 2;
                $dirty4 |= i2;
            }
        }
        if (i31 & 2 != 0) {
            $dirty4 |= 48;
        } else {
            if (i30 & 48 == 0) {
                i4 = restartGroup.changed(z3) ? 32 : 16;
                $dirty4 |= i4;
            }
        }
        if (i31 & 4 != 0) {
            $dirty4 |= 384;
        } else {
            if (i30 & 384 == 0) {
                i7 = restartGroup.changed(obj3) ? 256 : 128;
                $dirty4 |= i7;
            }
        }
        int i26 = i31 & 8;
        if (i26 != 0) {
            $dirty4 |= 3072;
            obj2 = modifier;
        } else {
            if (i30 & 3072 == 0) {
                i6 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty4 |= i6;
            } else {
                obj2 = modifier;
            }
        }
        if (i30 & 24576 == 0) {
            if (i31 & 16 == 0) {
                changed4 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj5 = colors;
            }
            $dirty4 |= changed4;
        } else {
            obj5 = colors;
        }
        if (i32 &= i30 == 0) {
            if (i31 & 32 == 0) {
                changed2 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj4 = shape;
            }
            $dirty4 |= changed2;
        } else {
            obj4 = shape;
        }
        if (i35 &= i30 == 0) {
            if (i31 & 64 == 0) {
                changed3 = restartGroup.changed(focusedIndicatorLineThickness) ? 1048576 : 524288;
            } else {
                f2 = focusedIndicatorLineThickness;
            }
            $dirty4 |= changed3;
        } else {
            f2 = focusedIndicatorLineThickness;
        }
        if (i40 &= i30 == 0) {
            if (i31 & 128 == 0) {
                changed = restartGroup.changed(unfocusedIndicatorLineThickness) ? 8388608 : 4194304;
            } else {
                str = unfocusedIndicatorLineThickness;
            }
            $dirty4 |= changed;
        } else {
            str = unfocusedIndicatorLineThickness;
        }
        i8 = 100663296;
        if (i31 & 256 != 0) {
            $dirty4 |= i8;
        } else {
            if (i30 & i8 == 0) {
                i3 = restartGroup.changed(traceInProgress2) ? 67108864 : 33554432;
                $dirty4 |= i3;
            }
        }
        if (i43 &= $dirty4 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i45 = -3670017;
                int i46 = -458753;
                int i47 = -57345;
                obj32 = -29360129;
                if (i30 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i31 & 16 != 0) {
                            $dirty4 &= i47;
                            obj5 = colors3;
                        }
                        if (i31 & 32 != 0) {
                            $dirty4 &= i46;
                            obj4 = colors2;
                        }
                        if (i31 & 64 != 0) {
                            $dirty4 &= i45;
                            f2 = shape4;
                        }
                        if (i31 & 128 != 0) {
                            f = unfocusedIndicatorThickness;
                            $dirty2 = obj4;
                            shape2 = $dirty6;
                            $dirty = f2;
                        } else {
                            $dirty2 = obj4;
                            f = str;
                            shape2 = $dirty4;
                            $dirty = f2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i31 & 16 != 0) {
                            $dirty4 &= i47;
                        }
                        if (i31 & 32 != 0) {
                            $dirty4 &= i46;
                        }
                        if (i31 & 64 != 0) {
                            $dirty4 &= i45;
                        }
                        if (i31 & 128 != 0) {
                            shape2 = i19;
                            $dirty2 = $dirty5;
                            $dirty = f2;
                            f = str;
                        } else {
                            $dirty2 = obj4;
                            f = str;
                            shape2 = $dirty4;
                            $dirty = f2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-818661242, shape2, -1, "androidx.compose.material3.TextFieldDefaults.Container (TextFieldDefaults.kt:109)");
                }
                boolean booleanValue = (Boolean)FocusInteractionKt.collectIsFocusedAsState(obj3, restartGroup, i37 &= 14).getValue().booleanValue();
                boolean z4 = booleanValue;
                int $dirty7 = 0;
                int i22 = 0;
                i12 = obj27;
                composer2 = restartGroup;
                z = z4;
                TextFieldDefaults.Container.1 anon = new TextFieldDefaults.Container.1(SingleValueAnimationKt.animateColorAsState-euL9pac(obj5.containerColor-XeAY9LY$material3_release(z2, z3, z4), booleanValue, (AnimationSpec)AnimationSpecKt.tween$default(150, $dirty7, i22, 6, i22), 0, 0, composer2, 48));
                TextFieldDefaults.sam.androidx_compose_ui_graphics_ColorProducer.0 anon2 = new TextFieldDefaults.sam.androidx_compose_ui_graphics_ColorProducer.0((Function0)anon);
                Object obj7 = obj5;
                BoxKt.Box(this.indicatorLine-gv0btCI(TextFieldImplKt.textFieldBackground(obj2, (ColorProducer)anon2, $dirty2), enabled, isError, obj3, obj7, $dirty, f), composer2, $dirty7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty3 = obj7;
                $composer2 = obj2;
                modifier2 = f3;
                shape3 = f;
                unfocusedIndicatorLineThickness2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i12 = $dirty4;
                $dirty3 = obj5;
                unfocusedIndicatorLineThickness2 = obj4;
                shape3 = str;
                composer = restartGroup;
                $composer2 = obj2;
                modifier2 = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TextFieldDefaults.Container.2(this, enabled, isError, interactionSource, $composer2, $dirty3, unfocusedIndicatorLineThickness2, modifier2, shape3, i30, i31);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TextFieldDefaults.Container", replaceWith = @ReplaceWith(...))
    public final void ContainerBox(boolean enabled, boolean isError, InteractionSource interactionSource, androidx.compose.material3.TextFieldColors colors, Shape shape, Composer $composer, int $changed, int i8) {
        int traceInProgress2;
        Object restartGroup;
        int $dirty;
        int i;
        int i3;
        int i9;
        int i2;
        Object shape2;
        boolean traceInProgress;
        int changed;
        int i7;
        boolean skipping;
        int iNSTANCE;
        int defaultsInvalid;
        int i10;
        Object obj;
        int i11;
        Object obj3;
        boolean z;
        int i6;
        boolean z2;
        Object obj5;
        androidx.compose.ui.Modifier.Companion companion;
        Object obj2;
        Object obj4;
        float focusedIndicatorThickness;
        float unfocusedIndicatorThickness;
        Composer composer;
        int i4;
        int i5;
        final int i31 = $changed;
        traceInProgress2 = 918564008;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ContainerBox)P(1,3,2)590@32311L5,592@32334L368:TextFieldDefaults.kt#uh7d8r");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
            z = enabled;
        } else {
            if (i31 & 6 == 0) {
                i = restartGroup.changed(enabled) ? 4 : 2;
                $dirty |= i;
            } else {
                z = enabled;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
            z2 = isError;
        } else {
            if (i31 & 48 == 0) {
                i3 = restartGroup.changed(isError) ? 32 : 16;
                $dirty |= i3;
            } else {
                z2 = isError;
            }
        }
        if (i8 & 4 != 0) {
            $dirty |= 384;
            obj5 = interactionSource;
        } else {
            if (i31 & 384 == 0) {
                i9 = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty |= i9;
            } else {
                obj5 = interactionSource;
            }
        }
        if (i8 & 8 != 0) {
            $dirty |= 3072;
            obj2 = colors;
        } else {
            if (i31 & 3072 == 0) {
                i2 = restartGroup.changed(colors) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                obj2 = colors;
            }
        }
        if (i31 & 24576 == 0) {
            if (i8 & 16 == 0) {
                changed = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                shape2 = shape;
            }
            $dirty |= changed;
        } else {
            shape2 = shape;
        }
        int i30 = 196608;
        if (i8 & 32 != 0) {
            $dirty |= i30;
            obj3 = this;
        } else {
            if (i31 & i30 == 0) {
                i7 = restartGroup.changed(this) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                obj3 = this;
            }
        }
        if (i27 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i10 = -57345;
                if (i31 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i8 & 16 != 0) {
                            $dirty &= i10;
                            obj4 = shape2;
                        } else {
                            obj4 = shape2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 16 != 0) {
                            $dirty &= i10;
                            obj4 = shape2;
                        } else {
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:592)");
                }
                obj3.Container-4EFweAY(z, z2, obj5, (Modifier)Modifier.Companion, obj2, obj4, TextFieldDefaults.FocusedIndicatorThickness, TextFieldDefaults.UnfocusedIndicatorThickness, restartGroup, i17 | shape2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj4;
                i6 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                obj = shape2;
                i6 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TextFieldDefaults.ContainerBox.1(this, enabled, isError, interactionSource, colors, obj, i31, i8);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final void DecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, Shape shape, androidx.compose.material3.TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> container, Composer $composer, int $changed, int $changed1, int i22) {
        Object obj8;
        Object obj4;
        Object obj17;
        Object obj18;
        Object obj23;
        Object obj6;
        Object obj14;
        Object obj9;
        Object obj;
        Object obj13;
        boolean traceInProgress;
        Object endRestartGroup;
        int i28;
        int i29;
        int defaultsInvalid;
        int placeholder4;
        Object colors3;
        Object obj21;
        Object obj22;
        Object contentPadding2;
        int shape2;
        boolean traceInProgress2;
        int i10;
        Composer restartGroup;
        int $dirty;
        int $dirty1;
        Object obj7;
        boolean z3;
        boolean z2;
        Object obj20;
        Object obj2;
        int i26;
        Object obj19;
        int obj12;
        Object obj10;
        int colors2;
        boolean z4;
        int isError3;
        int i30;
        boolean z;
        int obj15;
        int leadingIcon3;
        int leadingIcon2;
        Object obj3;
        int label2;
        int i21;
        int i20;
        int i15;
        int prefix2;
        Object obj5;
        int changed3;
        int i24;
        int changed2;
        int i11;
        Object obj16;
        int anon;
        int changed;
        int i25;
        int i23;
        Object isError2;
        int trailingIcon3;
        boolean trailingIcon2;
        int suffix2;
        Object obj11;
        int supportingText3;
        int supportingText2;
        int i31;
        int i27;
        int placeholder2;
        int placeholder3;
        int i6;
        int i4;
        int i32;
        Composer composer;
        int i17;
        int i19;
        int i14;
        int i5;
        int changedInstance;
        int i2;
        int changedInstance2;
        int i9;
        int i7;
        int i12;
        int i16;
        int i3;
        int i;
        int i8;
        int i18;
        int i13;
        boolean changedInstance3;
        ScopeUpdateScope scopeUpdateScope;
        Shape obj42;
        int obj43;
        int obj44;
        int obj45;
        int obj46;
        Shape obj47;
        int obj48;
        obj22 = this;
        int i33 = $changed;
        int i71 = $changed1;
        i10 = i22;
        restartGroup = $composer.startRestartGroup(289640444);
        ComposerKt.sourceInformation(restartGroup, "C(DecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)256@13034L5,257@13075L8,264@13325L428,277@13770L707:TextFieldDefaults.kt#uh7d8r");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            obj7 = value;
        } else {
            if (i33 & 6 == 0) {
                i26 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i26;
            } else {
                obj7 = value;
            }
        }
        if (i10 & 2 != 0) {
            $dirty |= 48;
            obj19 = innerTextField;
        } else {
            if (i33 & 48 == 0) {
                i30 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty |= i30;
            } else {
                obj19 = innerTextField;
            }
        }
        if (i10 & 4 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i33 & 384 == 0) {
                i21 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i21;
            } else {
                z = enabled;
            }
        }
        i25 = 1024;
        if (i10 & 8 != 0) {
            $dirty |= 3072;
            z3 = singleLine;
        } else {
            if (i33 & 3072 == 0) {
                i20 = restartGroup.changed(singleLine) ? changed3 : i25;
                $dirty |= i20;
            } else {
                z3 = singleLine;
            }
        }
        supportingText3 = 16384;
        if (i10 & 16 != 0) {
            $dirty |= 24576;
            obj20 = visualTransformation;
        } else {
            if (i33 & 24576 == 0) {
                i31 = restartGroup.changed(visualTransformation) ? supportingText3 : suffix2;
                $dirty |= i31;
            } else {
                obj20 = visualTransformation;
            }
        }
        i6 = 196608;
        i17 = 65536;
        if (i10 & 32 != 0) {
            $dirty |= i6;
            obj10 = interactionSource;
        } else {
            if (i33 & i6 == 0) {
                i19 = restartGroup.changed(interactionSource) ? 131072 : i17;
                $dirty |= i19;
            } else {
                obj10 = interactionSource;
            }
        }
        i5 = i10 & 64;
        changedInstance = 1572864;
        if (i5 != 0) {
            $dirty |= changedInstance;
            z4 = isError;
        } else {
            if (i33 & changedInstance == null) {
                changedInstance2 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty |= changedInstance2;
            } else {
                z4 = isError;
            }
        }
        int i113 = i10 & 128;
        i7 = 12582912;
        if (i113 != 0) {
            $dirty |= i7;
            obj3 = label;
        } else {
            if (i33 & i7 == 0) {
                i16 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty |= i16;
            } else {
                obj3 = label;
            }
        }
        int i34 = i10 & 256;
        int i131 = 100663296;
        if (i34 != 0) {
            $dirty |= i131;
            i3 = i34;
            obj8 = placeholder;
        } else {
            if ($changed & i131 == 0) {
                i3 = i34;
                i = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty |= i;
            } else {
                i3 = i34;
                obj8 = placeholder;
            }
        }
        int i35 = i10 & 512;
        int i133 = 805306368;
        if (i35 != 0) {
            $dirty |= i133;
            i8 = i35;
            obj4 = leadingIcon;
        } else {
            if ($changed & i133 == 0) {
                i8 = i35;
                i18 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty |= i18;
            } else {
                i8 = i35;
                obj4 = leadingIcon;
            }
        }
        int i36 = i10 & 1024;
        if (i36 != 0) {
            $dirty1 |= 6;
            i13 = i36;
            obj17 = trailingIcon;
        } else {
            if (i71 & 6 == 0) {
                i13 = i36;
                i15 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty1 |= i15;
            } else {
                i13 = i36;
                obj17 = trailingIcon;
            }
        }
        int i37 = i10 & 2048;
        if (i37 != 0) {
            $dirty1 |= 48;
            prefix2 = i37;
            obj18 = prefix;
        } else {
            if (i71 & 48 == 0) {
                prefix2 = i37;
                changedInstance = restartGroup.changedInstance(prefix) ? 32 : 16;
                $dirty1 |= changedInstance;
            } else {
                prefix2 = i37;
                obj18 = prefix;
            }
        }
        int i38 = i10 & 4096;
        if (i38 != 0) {
            $dirty1 |= 384;
            placeholder2 = i38;
            obj23 = suffix;
        } else {
            placeholder2 = i38;
            if (i71 & 384 == 0) {
                changedInstance2 = restartGroup.changedInstance(suffix) ? 256 : 128;
                $dirty1 |= changedInstance2;
            } else {
                obj23 = suffix;
            }
        }
        int i40 = i10 & 8192;
        if (i40 != 0) {
            $dirty1 |= 3072;
            i2 = i40;
            obj6 = supportingText;
        } else {
            i2 = i40;
            if (i71 & 3072 == 0) {
                if (restartGroup.changedInstance(supportingText)) {
                } else {
                    changed3 = i25;
                }
                $dirty1 |= changed3;
            } else {
                obj6 = supportingText;
            }
        }
        if (i71 & 24576 == 0) {
            if (i10 & 16384 == 0) {
                if (restartGroup.changed(shape)) {
                    suffix2 = supportingText3;
                }
            } else {
                obj14 = shape;
            }
            $dirty1 |= suffix2;
        } else {
            obj14 = shape;
        }
        if (i71 & i6 == 0) {
            if (i10 & i125 == 0) {
                i24 = restartGroup.changed(colors) ? 131072 : i17;
            } else {
                obj9 = colors;
            }
            $dirty1 |= i24;
        } else {
            obj9 = colors;
        }
        if (i71 & i126 == 0) {
            if (i10 & i17 == 0) {
                i11 = restartGroup.changed(contentPadding) ? 1048576 : 524288;
            } else {
                obj = contentPadding;
            }
            $dirty1 |= i11;
        } else {
            obj = contentPadding;
        }
        anon = i10 & i127;
        if (anon != 0) {
            $dirty1 |= i7;
            obj13 = container;
        } else {
            if (i71 & i7 == 0) {
                i25 = restartGroup.changedInstance(container) ? 8388608 : 4194304;
                $dirty1 |= i25;
            } else {
                obj13 = container;
            }
        }
        if (i10 & i128 != 0) {
            $dirty1 |= i131;
        } else {
            if (i71 & i131 == 0) {
                i23 = restartGroup.changed(obj22) ? 67108864 : 33554432;
                $dirty1 |= i23;
            }
        }
        if ($dirty & i129 == 306783378 && i43 &= $dirty1 == 38347922) {
            if (i43 &= $dirty1 == 38347922) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i5 != 0) {
                                z4 = defaultsInvalid;
                            }
                            if (i113 != 0) {
                                obj3 = defaultsInvalid;
                            }
                            placeholder4 = i3 != 0 ? 0 : placeholder;
                            leadingIcon2 = i8 != 0 ? 0 : leadingIcon;
                            trailingIcon3 = i13 != 0 ? 0 : trailingIcon;
                            prefix2 = prefix2 != 0 ? 0 : prefix;
                            suffix2 = placeholder2 != 0 ? 0 : suffix;
                            supportingText2 = i2 != 0 ? 0 : supportingText;
                            if (i10 & 16384 != 0) {
                                placeholder3 = placeholder4;
                                shape2 = TextFieldDefaults.INSTANCE.getShape(restartGroup, 6);
                                $dirty1 &= placeholder4;
                            } else {
                                placeholder3 = placeholder4;
                                shape2 = shape;
                            }
                            if (i48 &= i10 != 0) {
                                colors3 = obj22.colors(restartGroup, i50 &= 14);
                                $dirty1 &= i6;
                            } else {
                                colors3 = colors;
                            }
                            if (i10 & i17 != 0) {
                                if (obj3 == null) {
                                    contentPadding2 = TextFieldDefaults.contentPaddingWithoutLabel-a9UjIt4$default(obj22, 0, 0, 0, 0, 15, 0);
                                } else {
                                    contentPadding2 = TextFieldDefaults.contentPaddingWithLabel-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                }
                                $dirty1 &= i4;
                            } else {
                                contentPadding2 = contentPadding;
                            }
                            if (anon != 0) {
                                obj46 = colors3;
                                obj47 = shape2;
                                obj42 = anon;
                                super(z, z4, obj10, obj46, obj47);
                                trailingIcon2 = z4;
                                isError3 = i69;
                                i6 = rememberComposableLambda;
                                obj22 = $dirty1;
                                obj2 = obj3;
                                obj15 = prefix2;
                                label2 = supportingText2;
                                obj12 = placeholder3;
                                supportingText3 = obj42;
                                obj21 = obj47;
                                placeholder2 = field3;
                                colors2 = leadingIcon2;
                                leadingIcon3 = suffix2;
                            } else {
                                trailingIcon2 = z4;
                                isError3 = colors4;
                                obj21 = obj47;
                                i6 = container;
                                obj22 = $dirty1;
                                obj2 = obj3;
                                obj15 = prefix2;
                                label2 = supportingText2;
                                obj12 = placeholder3;
                                supportingText3 = obj42;
                                placeholder2 = colors5;
                                colors2 = leadingIcon2;
                                leadingIcon3 = suffix2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i10 & 16384 != 0) {
                                $dirty1 &= i28;
                            }
                            if (i44 &= i10 != 0) {
                                $dirty1 &= i29;
                            }
                            if (i10 & i17 != 0) {
                                obj12 = placeholder;
                                colors2 = leadingIcon;
                                obj15 = prefix;
                                leadingIcon3 = suffix;
                                placeholder2 = colors;
                                supportingText3 = contentPadding;
                                i6 = container;
                                obj22 = i47;
                                trailingIcon2 = z4;
                                obj2 = obj3;
                                isError3 = trailingIcon;
                                label2 = supportingText;
                                obj21 = shape;
                            } else {
                                obj12 = placeholder;
                                colors2 = leadingIcon;
                                obj15 = prefix;
                                leadingIcon3 = suffix;
                                obj21 = shape;
                                placeholder2 = colors;
                                supportingText3 = contentPadding;
                                i6 = container;
                                obj22 = $dirty1;
                                trailingIcon2 = z4;
                                obj2 = obj3;
                                isError3 = trailingIcon;
                                label2 = supportingText;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(289640444, $dirty, obj22, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:276)");
                    }
                    int i114 = 6;
                    i9 = $dirty;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, obj7, innerTextField, visualTransformation, obj2, obj12, colors2, isError3, obj15, leadingIcon3, label2, z3, enabled, trailingIcon2, interactionSource, supportingText3, placeholder2, i6, restartGroup, i59 | i90, i67 | i103, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj42;
                    i14 = obj22;
                    z2 = trailingIcon2;
                    isError2 = supportingText3;
                    obj16 = placeholder2;
                    obj11 = i6;
                } else {
                    restartGroup.skipToGroupEnd();
                    obj12 = placeholder;
                    colors2 = leadingIcon;
                    obj15 = prefix;
                    leadingIcon3 = suffix;
                    obj5 = shape;
                    obj16 = colors;
                    isError2 = contentPadding;
                    obj11 = container;
                    composer = restartGroup;
                    i9 = $dirty;
                    i14 = $dirty1;
                    z2 = z4;
                    obj2 = obj3;
                    isError3 = trailingIcon;
                    label2 = supportingText;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldDefaults.DecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z2, obj2, obj12, colors2, isError3, obj15, leadingIcon3, label2, obj5, obj16, isError2, obj11, $changed, $changed1, i10);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final androidx.compose.material3.TextFieldColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 831731228;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)336@16080L11,336@16092L22:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:336)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, i3 &= 112);
    }

    public final androidx.compose.material3.TextFieldColors colors-0hiis_0(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i50, int i51) {
        int companion11;
        int companion12;
        int companion3;
        Color.Companion companion5;
        int companion2;
        int companion;
        int companion10;
        int companion4;
        int companion8;
        int companion7;
        int companion6;
        int companion9;
        int unspecified-0d7_KjU9;
        boolean traceInProgress;
        int i3;
        int unspecified-0d7_KjU7;
        int unspecified-0d7_KjU12;
        int unspecified-0d7_KjU8;
        int unspecified-0d7_KjU20;
        int unspecified-0d7_KjU18;
        int unspecified-0d7_KjU26;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU16;
        long unspecified-0d7_KjU19;
        int unspecified-0d7_KjU29;
        int i2;
        int unspecified-0d7_KjU30;
        long unspecified-0d7_KjU31;
        int unspecified-0d7_KjU28;
        int unspecified-0d7_KjU14;
        int unspecified-0d7_KjU23;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU10;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU24;
        int unspecified-0d7_KjU21;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU3;
        int unspecified-0d7_KjU13;
        int unspecified-0d7_KjU17;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU27;
        int unspecified-0d7_KjU25;
        long unspecified-0d7_KjU22;
        int unspecified-0d7_KjU15;
        int i;
        long l8;
        long l13;
        long l22;
        long l27;
        long l;
        long l4;
        long l36;
        long l16;
        long l40;
        long l41;
        int i4;
        long l37;
        long l32;
        long l6;
        long l10;
        long l24;
        long l20;
        long l28;
        long l11;
        long l5;
        long l23;
        long l14;
        long l42;
        long l31;
        long l38;
        long l33;
        long l15;
        long l2;
        long l25;
        long l3;
        long l35;
        long l26;
        long l39;
        long l9;
        long l12;
        long l19;
        long l34;
        long l30;
        long l17;
        long l21;
        long l18;
        long l7;
        long l29;
        final Composer composer = obj178;
        int i5 = obj184;
        int i6 = obj185;
        int i7 = 1513344955;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,32,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)438@22922L11,438@22934L22:TextFieldDefaults.kt#uh7d8r");
        if (i5 & 1 != 0) {
            l8 = unspecified-0d7_KjU7;
        } else {
            l8 = focusedTextColor;
        }
        if (i5 & 2 != 0) {
            l13 = unspecified-0d7_KjU12;
        } else {
            l13 = disabledTextColor;
        }
        if (i5 & 4 != 0) {
            l22 = unspecified-0d7_KjU8;
        } else {
            l22 = focusedContainerColor;
        }
        if (i5 & 8 != 0) {
            l27 = unspecified-0d7_KjU20;
        } else {
            l27 = disabledContainerColor;
        }
        if (i5 & 16 != 0) {
            l = unspecified-0d7_KjU18;
        } else {
            l = cursorColor;
        }
        if (i5 & 32 != 0) {
            l4 = unspecified-0d7_KjU26;
        } else {
            l4 = selectionColors;
        }
        if (i5 & 64 != 0) {
            l36 = unspecified-0d7_KjU2;
        } else {
            l36 = unfocusedIndicatorColor;
        }
        if (i5 & 128 != 0) {
            l16 = unspecified-0d7_KjU16;
        } else {
            l16 = errorIndicatorColor;
        }
        if (i5 & 256 != 0) {
            l40 = unspecified-0d7_KjU19;
        } else {
            l40 = unfocusedLeadingIconColor;
        }
        if (i5 & 512 != 0) {
            l41 = unspecified-0d7_KjU29;
        } else {
            l41 = errorLeadingIconColor;
        }
        i4 = i5 & 1024 != 0 ? i2 : unfocusedTrailingIconColor;
        if (i5 & 2048 != 0) {
            l37 = unspecified-0d7_KjU30;
        } else {
            l37 = disabledTrailingIconColor;
        }
        if (i5 & 4096 != 0) {
            l32 = unspecified-0d7_KjU31;
        } else {
            l32 = focusedLabelColor;
        }
        if (i5 & 8192 != 0) {
            l6 = unspecified-0d7_KjU28;
        } else {
            l6 = disabledLabelColor;
        }
        if (i5 & 16384 != 0) {
            l10 = unspecified-0d7_KjU14;
        } else {
            l10 = focusedPlaceholderColor;
        }
        if (i11 &= i5 != 0) {
            l24 = unspecified-0d7_KjU23;
        } else {
            l24 = disabledPlaceholderColor;
        }
        if (i12 &= i5 != 0) {
            l20 = unspecified-0d7_KjU6;
        } else {
            l20 = focusedSupportingTextColor;
        }
        if (i13 &= i5 != 0) {
            l28 = unspecified-0d7_KjU10;
        } else {
            l28 = disabledSupportingTextColor;
        }
        if (i14 &= i5 != 0) {
            l11 = unspecified-0d7_KjU11;
        } else {
            l11 = focusedPrefixColor;
        }
        if (i15 &= i5 != 0) {
            l5 = unspecified-0d7_KjU4;
        } else {
            l5 = disabledPrefixColor;
        }
        if (i16 &= i5 != 0) {
            l23 = unspecified-0d7_KjU24;
        } else {
            l23 = focusedSuffixColor;
        }
        if (i17 &= i5 != 0) {
            l14 = unspecified-0d7_KjU21;
        } else {
            l14 = disabledSuffixColor;
        }
        if (i18 &= i5 != 0) {
            l42 = unspecified-0d7_KjU;
        } else {
            l42 = $composer;
        }
        if (i19 &= i5 != 0) {
            l31 = unspecified-0d7_KjU3;
        } else {
            l31 = $changed1;
        }
        if (i20 &= i5 != 0) {
            l38 = unspecified-0d7_KjU13;
        } else {
            l38 = $changed3;
        }
        if (i21 &= i5 != 0) {
            l33 = unspecified-0d7_KjU17;
        } else {
            l33 = i50;
        }
        if (i22 &= i5 != 0) {
            l15 = unspecified-0d7_KjU5;
        } else {
            l15 = obj144;
        }
        if (i23 &= i5 != 0) {
            l2 = unspecified-0d7_KjU27;
        } else {
            l2 = obj146;
        }
        if (i24 &= i5 != 0) {
            l25 = unspecified-0d7_KjU25;
        } else {
            l25 = obj148;
        }
        if (i25 &= i5 != 0) {
            l3 = unspecified-0d7_KjU22;
        } else {
            l3 = obj150;
        }
        if (i5 &= unspecified-0d7_KjU15 != 0) {
            l35 = unspecified-0d7_KjU15;
        } else {
            l35 = obj152;
        }
        if (i6 & 1 != 0) {
            l26 = unspecified-0d7_KjU15;
        } else {
            l26 = obj154;
        }
        if (i6 & 2 != 0) {
            l39 = unspecified-0d7_KjU15;
        } else {
            l39 = obj156;
        }
        if (i6 & 4 != 0) {
            l9 = unspecified-0d7_KjU15;
        } else {
            l9 = obj158;
        }
        if (i6 & 8 != 0) {
            l12 = unspecified-0d7_KjU15;
        } else {
            l12 = obj160;
        }
        if (i6 & 16 != 0) {
            l19 = unspecified-0d7_KjU15;
        } else {
            l19 = obj162;
        }
        if (i6 & 32 != 0) {
            l34 = unspecified-0d7_KjU15;
        } else {
            l34 = obj164;
        }
        if (i6 & 64 != 0) {
            l30 = unspecified-0d7_KjU15;
        } else {
            l30 = obj166;
        }
        if (i6 & 128 != 0) {
            l17 = unspecified-0d7_KjU15;
        } else {
            l17 = obj168;
        }
        if (i6 & 256 != 0) {
            l21 = unspecified-0d7_KjU15;
        } else {
            l21 = obj170;
        }
        if (i6 & 512 != 0) {
            l18 = unspecified-0d7_KjU15;
        } else {
            l18 = obj172;
        }
        if (i6 & 1024 != 0) {
            l7 = unspecified-0d7_KjU15;
        } else {
            l7 = obj174;
        }
        if (i6 & 2048 != 0) {
            l29 = unspecified-0d7_KjU9;
        } else {
            l29 = obj176;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, obj179, obj180, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:438)");
        } else {
            i3 = obj179;
            i = obj180;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, i9 &= 112).copy-ejIjP34(l8, obj8, l13, obj10, l22, obj12, l27, obj14, l, obj16, l4, obj18, l36, obj20, l16, obj22, l40, obj24, l41, obj26, i4, l37, obj29, l32, obj31, l6, obj33, l10, obj35, l24, obj37, l20, obj39, l28, obj41, l11, obj43, l5, obj45, l23, obj47, l14, obj49);
    }

    public final PaddingValues contentPaddingWithLabel-a9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.PaddingValues-a9UjIt4(start, top, end, bottom);
    }

    public final PaddingValues contentPaddingWithoutLabel-a9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.PaddingValues-a9UjIt4(start, top, end, bottom);
    }

    public final androidx.compose.material3.TextFieldColors getDefaultTextFieldColors(androidx.compose.material3.ColorScheme $this$defaultTextFieldColors, Composer $composer, int $changed) {
        androidx.compose.material3.TextFieldColors defaultTextFieldColorsCached$material3_release;
        boolean traceInProgress;
        String str;
        String $i$f$getCurrent;
        int i5;
        androidx.compose.material3.TextFieldColors textFieldColors;
        long token19;
        long token10;
        long copy-wmQWz5c$default5;
        long token16;
        int i30;
        long token3;
        int i25;
        long token9;
        int i3;
        long token8;
        long token33;
        long token15;
        long token12;
        Object $changed$iv;
        long token27;
        long token32;
        long copy-wmQWz5c$default9;
        long token4;
        int i27;
        long token6;
        int i17;
        long token13;
        int i2;
        long copy-wmQWz5c$default6;
        long token30;
        int i11;
        long token;
        int i8;
        long token25;
        int i12;
        long copy-wmQWz5c$default;
        long token26;
        int i22;
        long token22;
        int i20;
        long token20;
        int i6;
        long copy-wmQWz5c$default4;
        long token14;
        int i26;
        long token31;
        int i28;
        long token11;
        int i24;
        long copy-wmQWz5c$default7;
        long token21;
        int i4;
        long token5;
        int i7;
        long token18;
        int i14;
        long copy-wmQWz5c$default2;
        long token23;
        int i19;
        long token29;
        int i;
        long token7;
        int i9;
        long copy-wmQWz5c$default8;
        long token2;
        int i21;
        long token24;
        int i15;
        long token17;
        int i29;
        long copy-wmQWz5c$default3;
        long token28;
        int i13;
        int i16;
        int i23;
        int i18;
        int i10;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultTextFieldColors;
        final Composer composer = $composer;
        int i31 = 1341970309;
        ComposerKt.sourceInformationMarkerStart(composer, i31, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i31, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:486)");
        } else {
            i5 = $changed;
        }
        composer.startReplaceGroup(27085453);
        ComposerKt.sourceInformation(composer, "*501@26788L7");
        if (colorScheme.getDefaultTextFieldColorsCached$material3_release() == null) {
            i3 = 0;
            i30 = 0;
            i25 = 0;
            int i37 = i33;
            int i38 = i34;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            i2 = 0;
            i27 = 0;
            i17 = 0;
            i12 = 0;
            i11 = 0;
            i8 = 0;
            i6 = 0;
            i22 = 0;
            i20 = 0;
            i24 = 0;
            i26 = 0;
            i28 = 0;
            i14 = 0;
            i4 = 0;
            i7 = 0;
            i9 = 0;
            i19 = 0;
            i = 0;
            i29 = 0;
            i21 = 0;
            i15 = 0;
            i13 = 0;
            textFieldColors = new TextFieldColors(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusInputColor()), obj8, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputColor()), obj10, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), obj12, FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), i30, 0, i25, 14), obj12, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorInputColor()), i30, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), i25, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), i3, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), obj20, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), obj22, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getCaretColor()), obj24, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor()), obj26, (TextSelectionColors)composer.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor()), obj29, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor()), obj31, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor()), obj33, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorOpacity(), i27, 0, i17, 14), obj33, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor()), i27, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), i17, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLeadingIconColor()), i2, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), obj41, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), i11, 0, i8, 14), obj41, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), i11, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), i8, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getTrailingIconColor()), i12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), obj49, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), i22, 0, i20, 14), obj49, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), i22, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLabelColor()), i20, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLabelColor()), i6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor()), obj57, FilledTextFieldTokens.INSTANCE.getDisabledLabelOpacity(), i26, 0, i28, 14), obj57, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLabelColor()), i26, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), i28, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), i24, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), obj65, FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), i4, 0, i7, 14), obj65, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), i4, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor()), i7, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getSupportingColor()), i14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor()), obj73, FilledTextFieldTokens.INSTANCE.getDisabledSupportingOpacity(), i19, 0, i, 14), obj73, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor()), i19, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), i, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), i9, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), obj81, FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), i21, 0, i15, 14), obj81, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), i21, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), i15, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), i29, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), obj89, FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), i13, 0, 0, 14), obj89, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), i13, 0);
            str = 0;
            colorScheme.setDefaultTextFieldColorsCached$material3_release(textFieldColors);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldColorsCached$material3_release;
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 611926497;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C621@33346L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:621)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getShape($composer, $changed & 14);
    }

    public final float getFocusedBorderThickness-D9Ej5fM() {
        return TextFieldDefaults.FocusedBorderThickness;
    }

    public final float getFocusedIndicatorThickness-D9Ej5fM() {
        return TextFieldDefaults.FocusedIndicatorThickness;
    }

    public final float getMinHeight-D9Ej5fM() {
        return TextFieldDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return TextFieldDefaults.MinWidth;
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -584749279;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C613@33100L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:613)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return OutlinedTextFieldDefaults.INSTANCE.getShape($composer, 6);
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1941327459;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C60@2756L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:60)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final float getUnfocusedBorderThickness-D9Ej5fM() {
        return TextFieldDefaults.UnfocusedBorderThickness;
    }

    public final float getUnfocusedIndicatorThickness-D9Ej5fM() {
        return TextFieldDefaults.UnfocusedIndicatorThickness;
    }

    public final Modifier indicatorLine-gv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, boolean enabled, boolean isError, InteractionSource interactionSource, androidx.compose.material3.TextFieldColors colors, float focusedIndicatorLineThickness, float unfocusedIndicatorLineThickness) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        boolean z;
        boolean z2;
        InteractionSource interactionSource2;
        androidx.compose.material3.TextFieldColors field;
        float f2;
        float f;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new TextFieldDefaults.indicatorLine-gv0btCI$$inlined.debugInspectorInfo.1(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        TextFieldDefaults.indicatorLine.2 anon = new TextFieldDefaults.indicatorLine.2(interactionSource, enabled, isError, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness);
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, noInspectorInfo, (Function3)anon);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(...))
    public final PaddingValues outlinedTextFieldPadding-a9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.contentPadding-a9UjIt4(start, top, end, bottom);
    }

    public final PaddingValues supportingTextPadding-a9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.PaddingValues-a9UjIt4(start, top, end, bottom);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(...))
    public final PaddingValues textFieldWithLabelPadding-a9UjIt4(float start, float end, float top, float bottom) {
        return contentPaddingWithLabel-a9UjIt4(start, end, top, bottom);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(...))
    public final PaddingValues textFieldWithoutLabelPadding-a9UjIt4(float start, float top, float end, float bottom) {
        return contentPaddingWithoutLabel-a9UjIt4(start, top, end, bottom);
    }
}
