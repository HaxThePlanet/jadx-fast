package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008)\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00132\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010!\u001a\u00020\u00042\u0008\u0008\u0002\u0010\"\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$JR\u0010%\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010 \u001a\u00020\u00132\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010!\u001a\u00020\u00042\u0008\u0008\u0002\u0010\"\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J\u009c\u0002\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00180,¢\u0006\u0002\u0008-2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u0002002\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001a2\u0015\u0008\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\u0008-2\u0015\u0008\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\u0008-2\u0015\u0008\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\u0008-2\u0015\u0008\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\u0008-2\u0015\u0008\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\u0008-2\u0015\u0008\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\u0008-2\u0015\u0008\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\u0008-2\u0008\u0008\u0002\u0010 \u001a\u00020\u00132\u0008\u0008\u0002\u00108\u001a\u0002092\u0013\u0008\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00180,¢\u0006\u0002\u0008-H\u0007¢\u0006\u0002\u0010;J\r\u0010 \u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010<JÂ\u0003\u0010 \u001a\u00020\u00132\u0008\u0008\u0002\u0010=\u001a\u00020>2\u0008\u0008\u0002\u0010?\u001a\u00020>2\u0008\u0008\u0002\u0010@\u001a\u00020>2\u0008\u0008\u0002\u0010A\u001a\u00020>2\u0008\u0008\u0002\u0010B\u001a\u00020>2\u0008\u0008\u0002\u0010C\u001a\u00020>2\u0008\u0008\u0002\u0010D\u001a\u00020>2\u0008\u0008\u0002\u0010E\u001a\u00020>2\u0008\u0008\u0002\u0010F\u001a\u00020>2\u0008\u0008\u0002\u0010G\u001a\u00020>2\n\u0008\u0002\u0010H\u001a\u0004\u0018\u00010I2\u0008\u0008\u0002\u0010J\u001a\u00020>2\u0008\u0008\u0002\u0010K\u001a\u00020>2\u0008\u0008\u0002\u0010L\u001a\u00020>2\u0008\u0008\u0002\u0010M\u001a\u00020>2\u0008\u0008\u0002\u0010N\u001a\u00020>2\u0008\u0008\u0002\u0010O\u001a\u00020>2\u0008\u0008\u0002\u0010P\u001a\u00020>2\u0008\u0008\u0002\u0010Q\u001a\u00020>2\u0008\u0008\u0002\u0010R\u001a\u00020>2\u0008\u0008\u0002\u0010S\u001a\u00020>2\u0008\u0008\u0002\u0010T\u001a\u00020>2\u0008\u0008\u0002\u0010U\u001a\u00020>2\u0008\u0008\u0002\u0010V\u001a\u00020>2\u0008\u0008\u0002\u0010W\u001a\u00020>2\u0008\u0008\u0002\u0010X\u001a\u00020>2\u0008\u0008\u0002\u0010Y\u001a\u00020>2\u0008\u0008\u0002\u0010Z\u001a\u00020>2\u0008\u0008\u0002\u0010[\u001a\u00020>2\u0008\u0008\u0002\u0010\\\u001a\u00020>2\u0008\u0008\u0002\u0010]\u001a\u00020>2\u0008\u0008\u0002\u0010^\u001a\u00020>2\u0008\u0008\u0002\u0010_\u001a\u00020>2\u0008\u0008\u0002\u0010`\u001a\u00020>2\u0008\u0008\u0002\u0010a\u001a\u00020>2\u0008\u0008\u0002\u0010b\u001a\u00020>2\u0008\u0008\u0002\u0010c\u001a\u00020>2\u0008\u0008\u0002\u0010d\u001a\u00020>2\u0008\u0008\u0002\u0010e\u001a\u00020>2\u0008\u0008\u0002\u0010f\u001a\u00020>2\u0008\u0008\u0002\u0010g\u001a\u00020>2\u0008\u0008\u0002\u0010h\u001a\u00020>2\u0008\u0008\u0002\u0010i\u001a\u00020>H\u0007ø\u0001\u0000¢\u0006\u0004\u0008j\u0010kJ8\u00108\u001a\u0002092\u0008\u0008\u0002\u0010l\u001a\u00020\u00042\u0008\u0008\u0002\u0010m\u001a\u00020\u00042\u0008\u0008\u0002\u0010n\u001a\u00020\u00042\u0008\u0008\u0002\u0010o\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008p\u0010qR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00148AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006r", d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "Container", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "focusedBorderThickness", "unfocusedBorderThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "ContainerBox", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OutlinedTextFieldDefaults {

    public static final int $stable;
    private static final float FocusedBorderThickness;
    public static final androidx.compose.material3.OutlinedTextFieldDefaults INSTANCE;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float UnfocusedBorderThickness;
    static {
        OutlinedTextFieldDefaults outlinedTextFieldDefaults = new OutlinedTextFieldDefaults();
        OutlinedTextFieldDefaults.INSTANCE = outlinedTextFieldDefaults;
        int i5 = 0;
        OutlinedTextFieldDefaults.MinHeight = Dp.constructor-impl((float)i);
        int i6 = 0;
        OutlinedTextFieldDefaults.MinWidth = Dp.constructor-impl((float)i2);
        int i7 = 0;
        OutlinedTextFieldDefaults.UnfocusedBorderThickness = Dp.constructor-impl((float)i3);
        int i8 = 0;
        OutlinedTextFieldDefaults.FocusedBorderThickness = Dp.constructor-impl((float)i4);
    }

    public static PaddingValues contentPadding-a9UjIt4$default(androidx.compose.material3.OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
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
        return outlinedTextFieldDefaults.contentPadding-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public final void Container-4EFweAY(boolean enabled, boolean isError, InteractionSource interactionSource, Modifier modifier, androidx.compose.material3.TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed, int i11) {
        Object anon;
        Object obj2;
        boolean z;
        boolean booleanValue;
        int modifier2;
        boolean traceInProgress;
        int defaultsInvalid;
        int $dirty3;
        Object $dirty2;
        Object $dirty;
        int i;
        int i4;
        int i8;
        Object focusedBorderThickness2;
        float colors3;
        Object colors2;
        Object obj3;
        Object unfocusedBorderThickness3;
        float shape4;
        Object shape3;
        float $composer2;
        int i5;
        Object focusedBorderThickness3;
        float f2;
        int changed3;
        Object obj;
        int containerColor;
        Object unfocusedBorderThickness2;
        int changed4;
        float f3;
        Composer composer;
        Object obj4;
        int changed2;
        float f;
        int i9;
        int changed;
        int i2;
        int anon2;
        int i7;
        int shape2;
        Composer composer2;
        int i6;
        int i3;
        Object obj24;
        int obj29;
        obj2 = this;
        z = enabled;
        final boolean z2 = isError;
        anon = interactionSource;
        final int i36 = $changed;
        final int i37 = i11;
        Composer restartGroup = $composer.startRestartGroup(1035477640);
        ComposerKt.sourceInformation(restartGroup, "C(Container)P(1,4,3,5!1,6,2:c#ui.unit.Dp,7:c#ui.unit.Dp)772@39024L8,773@39083L5,777@39264L25,779@39335L222,788@39599L198,792@39806L153:TextFieldDefaults.kt#uh7d8r");
        $dirty3 = $changed;
        if (i37 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i36 & 6 == 0) {
                i = restartGroup.changed(z) ? 4 : 2;
                $dirty3 |= i;
            }
        }
        if (i37 & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (i36 & 48 == 0) {
                i4 = restartGroup.changed(z2) ? 32 : 16;
                $dirty3 |= i4;
            }
        }
        if (i37 & 4 != 0) {
            $dirty3 |= 384;
        } else {
            if (i36 & 384 == 0) {
                i8 = restartGroup.changed(anon) ? 256 : 128;
                $dirty3 |= i8;
            }
        }
        int i22 = i37 & 8;
        if (i22 != 0) {
            $dirty3 |= 3072;
            obj3 = modifier;
        } else {
            if (i36 & 3072 == 0) {
                i5 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty3 |= i5;
            } else {
                obj3 = modifier;
            }
        }
        if (i36 & 24576 == 0) {
            if (i37 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                focusedBorderThickness3 = colors;
            }
            $dirty3 |= changed3;
        } else {
            focusedBorderThickness3 = colors;
        }
        if (i38 &= i36 == 0) {
            if (i37 & 32 == 0) {
                changed4 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj = shape;
            }
            $dirty3 |= changed4;
        } else {
            obj = shape;
        }
        if (i42 &= i36 == 0) {
            if (i37 & 64 == 0) {
                changed2 = restartGroup.changed(focusedBorderThickness) ? 1048576 : 524288;
            } else {
                f3 = focusedBorderThickness;
            }
            $dirty3 |= changed2;
        } else {
            f3 = focusedBorderThickness;
        }
        if (i45 &= i36 == 0) {
            if (i37 & 128 == 0) {
                changed = restartGroup.changed(unfocusedBorderThickness) ? 8388608 : 4194304;
            } else {
                f = unfocusedBorderThickness;
            }
            $dirty3 |= changed;
        } else {
            f = unfocusedBorderThickness;
        }
        shape2 = 100663296;
        if (i37 & 256 != 0) {
            $dirty3 |= shape2;
        } else {
            if (i36 & shape2 == 0) {
                i2 = restartGroup.changed(obj2) ? 67108864 : 33554432;
                $dirty3 |= i2;
            }
        }
        if (i48 &= $dirty3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i59 = -3670017;
                int i61 = -458753;
                int i62 = -57345;
                obj29 = -29360129;
                if (i36 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj3;
                        }
                        if (i37 & 16 != 0) {
                            colors2 = obj2.colors(restartGroup, i24 &= 14);
                            $dirty3 &= i62;
                        } else {
                            colors2 = focusedBorderThickness3;
                        }
                        if (i37 & 32 != 0) {
                            shape3 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, 6);
                            $dirty3 &= i61;
                        } else {
                            shape3 = obj;
                        }
                        if (i37 & 64 != 0) {
                            focusedBorderThickness3 = OutlinedTextFieldDefaults.FocusedBorderThickness;
                            $dirty3 &= i59;
                        } else {
                            focusedBorderThickness3 = f3;
                        }
                        if (i37 & 128 != 0) {
                            i9 = $dirty4;
                            $dirty = colors2;
                            obj4 = shape3;
                            colors3 = focusedBorderThickness3;
                            shape4 = unfocusedBorderThickness4;
                            unfocusedBorderThickness2 = modifier2;
                        } else {
                            unfocusedBorderThickness2 = modifier2;
                            obj4 = shape3;
                            shape4 = f;
                            i9 = $dirty3;
                            $dirty = colors2;
                            colors3 = focusedBorderThickness3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i37 & 16 != 0) {
                            $dirty3 &= i62;
                        }
                        if (i37 & 32 != 0) {
                            $dirty3 &= i61;
                        }
                        if (i37 & 64 != 0) {
                            $dirty3 &= i59;
                        }
                        if (i37 & 128 != 0) {
                            $dirty = focusedBorderThickness3;
                            colors3 = f3;
                            obj4 = obj;
                            unfocusedBorderThickness2 = obj3;
                            shape4 = f;
                            i9 = modifier2;
                        } else {
                            colors3 = f3;
                            obj4 = obj;
                            unfocusedBorderThickness2 = obj3;
                            shape4 = f;
                            i9 = $dirty3;
                            $dirty = focusedBorderThickness3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035477640, i9, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:776)");
                }
                booleanValue = (Boolean)FocusInteractionKt.collectIsFocusedAsState(anon, restartGroup, i16 &= 14).getValue().booleanValue();
                int modifier3 = 0;
                int i12 = 0;
                z = obj7;
                composer2 = restartGroup;
                int $composer3 = i13;
                obj2 = obj24;
                anon2 = new OutlinedTextFieldDefaults.Container.1(SingleValueAnimationKt.animateColorAsState-euL9pac($dirty.containerColor-XeAY9LY$material3_release(z, z2, booleanValue), obj4, (AnimationSpec)AnimationSpecKt.tween$default(150, modifier3, i12, 6, i12), 0, 0, composer2, 48));
                TextFieldDefaults.sam.androidx_compose_ui_graphics_ColorProducer.0 anon3 = new TextFieldDefaults.sam.androidx_compose_ui_graphics_ColorProducer.0((Function0)anon2);
                BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(obj2, (BorderStroke)TextFieldImplKt.animateBorderStrokeAsState-NuRrP5Q(z, z2, booleanValue, $dirty, colors3, shape4, restartGroup, i32 |= i55).getValue(), z), (ColorProducer)anon3, z), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                containerColor = anon;
                $composer2 = colors3;
                f2 = shape4;
                unfocusedBorderThickness3 = z;
                focusedBorderThickness2 = $dirty;
                $dirty2 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                containerColor = $dirty3;
                $dirty2 = obj3;
                unfocusedBorderThickness3 = obj5;
                composer = restartGroup;
                $composer2 = f4;
                focusedBorderThickness2 = focusedBorderThickness3;
                f2 = f;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new OutlinedTextFieldDefaults.Container.2(this, enabled, z2, interactionSource, $dirty2, focusedBorderThickness2, unfocusedBorderThickness3, $composer2, f2, i36, i37);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to OutlinedTextFieldDefaults.Container", replaceWith = @ReplaceWith(...))
    public final void ContainerBox-nbWgWpA(boolean enabled, boolean isError, InteractionSource interactionSource, androidx.compose.material3.TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        boolean i5;
        int $dirty;
        boolean traceInProgress;
        boolean z;
        int i9;
        boolean z2;
        int i8;
        Object obj;
        Object obj2;
        int i6;
        Object colors3;
        Object colors2;
        int changed;
        Object shape2;
        float shape3;
        int changed3;
        float focusedBorderThickness3;
        float focusedBorderThickness2;
        Composer restartGroup;
        int changed4;
        float unfocusedBorderThickness2;
        int changed2;
        int i4;
        Composer composer;
        int skipping;
        int defaultsInvalid;
        int i2;
        int iNSTANCE;
        int str;
        int i3;
        int i;
        int i7;
        int i11;
        boolean z3;
        int obj26;
        traceInProgress2 = this;
        final int i57 = $changed;
        final int i58 = i10;
        i5 = 1461761386;
        restartGroup = $composer.startRestartGroup(i5);
        ComposerKt.sourceInformation(restartGroup, "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)1174@62656L8,1175@62715L5,1179@62864L348:TextFieldDefaults.kt#uh7d8r");
        $dirty = $changed;
        if (i58 & 1 != 0) {
            $dirty |= 6;
            z = enabled;
        } else {
            if (i57 & 6 == 0) {
                i9 = restartGroup.changed(enabled) ? 4 : 2;
                $dirty |= i9;
            } else {
                z = enabled;
            }
        }
        if (i58 & 2 != 0) {
            $dirty |= 48;
            z2 = isError;
        } else {
            if (i57 & 48 == 0) {
                i8 = restartGroup.changed(isError) ? 32 : 16;
                $dirty |= i8;
            } else {
                z2 = isError;
            }
        }
        if (i58 & 4 != 0) {
            $dirty |= 384;
            obj = interactionSource;
        } else {
            if (i57 & 384 == 0) {
                i6 = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj = interactionSource;
            }
        }
        if (i57 & 3072 == 0) {
            if (i58 & 8 == 0) {
                changed = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                colors3 = colors;
            }
            $dirty |= changed;
        } else {
            colors3 = colors;
        }
        if (i57 & 24576 == 0) {
            if (i58 & 16 == 0) {
                changed3 = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                shape2 = shape;
            }
            $dirty |= changed3;
        } else {
            shape2 = shape;
        }
        if (i32 &= i57 == 0) {
            if (i58 & 32 == 0) {
                changed4 = restartGroup.changed(focusedBorderThickness) ? 131072 : 65536;
            } else {
                focusedBorderThickness3 = focusedBorderThickness;
            }
            $dirty |= changed4;
        } else {
            focusedBorderThickness3 = focusedBorderThickness;
        }
        if (i35 &= i57 == 0) {
            if (i58 & 64 == 0) {
                changed2 = restartGroup.changed(unfocusedBorderThickness) ? 1048576 : 524288;
            } else {
                unfocusedBorderThickness2 = unfocusedBorderThickness;
            }
            $dirty |= changed2;
        } else {
            unfocusedBorderThickness2 = unfocusedBorderThickness;
        }
        int i59 = 12582912;
        if (i58 & 128 != 0) {
            $dirty |= i59;
        } else {
            if (i57 & i59 == 0) {
                i4 = restartGroup.changed(traceInProgress2) ? 8388608 : 4194304;
                $dirty |= i4;
            }
        }
        if (i38 &= $dirty == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -3670017;
                int i61 = -458753;
                i11 = -57345;
                if (i57 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i58 & 8 != 0) {
                            colors3 = traceInProgress2.colors(restartGroup, i43 &= 14);
                            $dirty &= -7169;
                        }
                        if (i58 & 16 != 0) {
                            obj26 = i;
                            shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, 6);
                            $dirty &= i11;
                        } else {
                            obj26 = i;
                        }
                        if (i58 & 32 != 0) {
                            focusedBorderThickness3 = OutlinedTextFieldDefaults.FocusedBorderThickness;
                            $dirty &= i61;
                        }
                        if (i58 & 64 != 0) {
                            unfocusedBorderThickness2 = OutlinedTextFieldDefaults.UnfocusedBorderThickness;
                            i3 = $dirty;
                        } else {
                            i3 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i58 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i58 & 16 != 0) {
                            $dirty &= i11;
                        }
                        if (i58 & 32 != 0) {
                            $dirty &= i61;
                        }
                        i3 = i58 & 64 != 0 ? $dirty : $dirty;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1179)");
                }
                traceInProgress2.Container-4EFweAY(z, z2, obj, (Modifier)Modifier.Companion, colors3, shape2, focusedBorderThickness3, unfocusedBorderThickness2, restartGroup, i20 |= i55, 0);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i3 = $dirty;
                obj2 = colors3;
                colors2 = shape2;
                shape3 = focusedBorderThickness3;
                composer = restartGroup;
                focusedBorderThickness2 = unfocusedBorderThickness2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new OutlinedTextFieldDefaults.ContainerBox.1(this, enabled, isError, interactionSource, obj2, colors2, shape3, focusedBorderThickness2, i57, i58);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final void DecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, androidx.compose.material3.TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> container, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj11;
        Object obj8;
        Object obj10;
        Object i37;
        Object obj3;
        Object obj9;
        Object obj12;
        Object obj4;
        Object obj5;
        int traceInProgress;
        int $dirty12;
        int i8;
        int defaultsInvalid;
        boolean isError3;
        Object endRestartGroup;
        int i25;
        Object contentPadding2;
        Object $dirty13;
        int colors2;
        boolean traceInProgress2;
        int placeholder2;
        int str;
        Object $composer2;
        int $dirty;
        int $dirty1;
        Object obj7;
        Object obj;
        int i12;
        boolean prefix4;
        boolean z;
        int leadingIcon2;
        int leadingIcon3;
        Object suffix3;
        int i20;
        Object obj2;
        int i34;
        int supportingText4;
        int trailingIcon2;
        int i15;
        int i36;
        Object obj6;
        boolean label2;
        int isError4;
        int i26;
        int i3;
        int i6;
        boolean z2;
        Object obj13;
        int contentPadding3;
        int i14;
        int i9;
        Object supportingText2;
        int supportingText3;
        int changedInstance3;
        int i;
        Object isError2;
        PaddingValues container2;
        int changed;
        int i4;
        int i2;
        Composer prefix2;
        int prefix3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int suffix2;
        int i33;
        int i16;
        int i31;
        int i19;
        int i22;
        int i18;
        int i11;
        int i32;
        int i28;
        int i23;
        int i7;
        Composer composer;
        int i10;
        int i5;
        int i27;
        int i38;
        int changedInstance2;
        int i13;
        int i17;
        int i29;
        int i30;
        int i24;
        int i35;
        boolean changedInstance;
        ScopeUpdateScope scopeUpdateScope;
        PaddingValues obj41;
        int obj42;
        int obj43;
        int obj44;
        int obj45;
        int obj46;
        int obj47;
        int obj52;
        $dirty13 = this;
        boolean z5 = enabled;
        Object obj14 = interactionSource;
        int i39 = $changed;
        int i55 = $changed1;
        str = i21;
        $composer2 = $composer.startRestartGroup(-350442135);
        ComposerKt.sourceInformation($composer2, "C(DecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)870@44562L8,872@44674L408,885@45099L709:TextFieldDefaults.kt#uh7d8r");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (str & 1 != 0) {
            $dirty |= 6;
            obj7 = value;
        } else {
            if (i39 & 6 == 0) {
                i20 = $composer2.changed(value) ? 4 : 2;
                $dirty |= i20;
            } else {
                obj7 = value;
            }
        }
        if (str & 2 != 0) {
            $dirty |= 48;
            obj2 = innerTextField;
        } else {
            if (i39 & 48 == 0) {
                i3 = $composer2.changedInstance(innerTextField) ? 32 : 16;
                $dirty |= i3;
            } else {
                obj2 = innerTextField;
            }
        }
        changedInstance3 = 128;
        if (str & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i39 & 384 == 0) {
                i6 = $composer2.changed(z5) ? i14 : changedInstance3;
                $dirty |= i6;
            }
        }
        suffix2 = 1024;
        if (str & 8 != 0) {
            $dirty |= 3072;
            z2 = singleLine;
        } else {
            if (i39 & 3072 == 0) {
                i33 = $composer2.changed(singleLine) ? i4 : suffix2;
                $dirty |= i33;
            } else {
                z2 = singleLine;
            }
        }
        i11 = 16384;
        if (str & 16 != 0) {
            $dirty |= 24576;
            obj = visualTransformation;
        } else {
            if (i39 & 24576 == 0) {
                i16 = $composer2.changed(visualTransformation) ? i11 : i18;
                $dirty |= i16;
            } else {
                obj = visualTransformation;
            }
        }
        i28 = 196608;
        if (str & 32 != 0) {
            $dirty |= i28;
        } else {
            if (i39 & i28 == 0) {
                i31 = $composer2.changed(obj14) ? 131072 : 65536;
                $dirty |= i31;
            }
        }
        i19 = str & 64;
        i7 = 1572864;
        if (i19 != 0) {
            $dirty |= i7;
            z = isError;
        } else {
            if (i39 & i7 == 0) {
                i27 = $composer2.changed(isError) ? 1048576 : 524288;
                $dirty |= i27;
            } else {
                z = isError;
            }
        }
        trailingIcon2 = str & 128;
        final int i132 = 12582912;
        if (trailingIcon2 != 0) {
            $dirty |= i132;
            obj6 = label;
        } else {
            if (i39 & i132 == 0) {
                i13 = $composer2.changedInstance(label) ? 8388608 : 4194304;
                $dirty |= i13;
            } else {
                obj6 = label;
            }
        }
        int i40 = str & 256;
        int i133 = 100663296;
        if (i40 != 0) {
            $dirty |= i133;
            i17 = i40;
            obj11 = placeholder;
        } else {
            if ($changed & i133 == 0) {
                i17 = i40;
                i29 = $composer2.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty |= i29;
            } else {
                i17 = i40;
                obj11 = placeholder;
            }
        }
        int i41 = str & 512;
        int i135 = 805306368;
        if (i41 != 0) {
            $dirty |= i135;
            i30 = i41;
            obj8 = leadingIcon;
        } else {
            if ($changed & i135 == 0) {
                i30 = i41;
                i24 = $composer2.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty |= i24;
            } else {
                i30 = i41;
                obj8 = leadingIcon;
            }
        }
        int i42 = str & 1024;
        if (i42 != 0) {
            $dirty1 |= 6;
            i35 = i42;
            obj10 = trailingIcon;
        } else {
            if (i55 & 6 == 0) {
                i35 = i42;
                i10 = $composer2.changedInstance(trailingIcon) ? 4 : 2;
                $dirty1 |= i10;
            } else {
                i35 = i42;
                obj10 = trailingIcon;
            }
        }
        int i43 = str & 2048;
        if (i43 != 0) {
            $dirty1 |= 48;
            i5 = i43;
            i37 = prefix;
        } else {
            if (i55 & 48 == 0) {
                i5 = i43;
                i27 = $composer2.changedInstance(prefix) ? 32 : 16;
                $dirty1 |= i27;
            } else {
                i5 = i43;
                i37 = prefix;
            }
        }
        int i44 = str & 4096;
        if (i44 != 0) {
            $dirty1 |= 384;
            i38 = i44;
            obj3 = suffix;
        } else {
            i38 = i44;
            if (i55 & 384 == 0) {
                if ($composer2.changedInstance(suffix)) {
                } else {
                    i14 = changedInstance3;
                }
                $dirty1 |= i14;
            } else {
                obj3 = suffix;
            }
        }
        int i46 = str & 8192;
        if (i46 != 0) {
            $dirty1 |= 3072;
            i9 = i46;
            obj9 = supportingText;
        } else {
            i9 = i46;
            if (i55 & 3072 == 0) {
                if ($composer2.changedInstance(supportingText)) {
                } else {
                    i4 = suffix2;
                }
                $dirty1 |= i4;
            } else {
                obj9 = supportingText;
            }
        }
        if (i55 & 24576 == 0) {
            if (str & 16384 == 0) {
                if ($composer2.changed(colors)) {
                    i18 = i11;
                }
            } else {
                obj12 = colors;
            }
            $dirty1 |= i18;
        } else {
            obj12 = colors;
        }
        if (i55 & i28 == 0) {
            if (str & i117 == 0) {
                i = $composer2.changed(contentPadding) ? 131072 : 65536;
            } else {
                obj4 = contentPadding;
            }
            $dirty1 |= i;
        } else {
            obj4 = contentPadding;
        }
        int i116 = str & i115;
        if (i116 != 0) {
            $dirty1 |= i7;
            obj5 = container;
        } else {
            if (i55 & i7 == 0) {
                i4 = $composer2.changedInstance(container) ? 1048576 : 524288;
                $dirty1 |= i4;
            } else {
                obj5 = container;
            }
        }
        if (str & i118 != 0) {
            $dirty1 |= i132;
        } else {
            if (i55 & i132 == 0) {
                i2 = $composer2.changed($dirty13) ? 8388608 : 4194304;
                $dirty1 |= i2;
            }
        }
        if ($dirty & i119 == 306783378 && i53 &= $dirty1 == 4793490) {
            if (i53 &= $dirty1 == 4793490) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if ($changed & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            isError3 = i19 != 0 ? 0 : z;
                            if (trailingIcon2 != 0) {
                                obj6 = colors2;
                            }
                            placeholder2 = i17 != 0 ? 0 : placeholder;
                            leadingIcon3 = i30 != 0 ? 0 : leadingIcon;
                            trailingIcon2 = i35 != 0 ? 0 : trailingIcon;
                            prefix3 = i5 != 0 ? 0 : prefix;
                            suffix2 = i38 != 0 ? 0 : suffix;
                            supportingText3 = i9 != 0 ? 0 : supportingText;
                            obj52 = placeholder2;
                            if (str & 16384 != 0) {
                                colors2 = $dirty13.colors($composer2, i57 &= 14);
                                $dirty1 &= i19;
                            } else {
                                colors2 = colors;
                            }
                            if (str & i129 != 0) {
                                contentPadding2 = OutlinedTextFieldDefaults.contentPadding-a9UjIt4$default($dirty13, 0, 0, 0, 0, 15, 0);
                                $dirty1 &= i22;
                            } else {
                                contentPadding2 = contentPadding;
                            }
                            if (i116 != 0) {
                                OutlinedTextFieldDefaults.DecorationBox.1 contentPadding4 = new OutlinedTextFieldDefaults.DecorationBox.1(z5, isError3, obj14, colors2);
                                obj13 = obj41;
                                i25 = $dirty1;
                                $dirty1 = leadingIcon3;
                                obj7 = trailingIcon2;
                                i34 = supportingText3;
                                i12 = prefix3;
                                leadingIcon2 = suffix2;
                                supportingText2 = i19;
                                prefix2 = $composer2;
                                $composer2 = obj6;
                                label2 = z6;
                                isError2 = rememberComposableLambda;
                                $dirty12 = obj52;
                            } else {
                                obj13 = obj41;
                                $dirty12 = obj52;
                                i25 = $dirty1;
                                $dirty1 = leadingIcon3;
                                obj7 = trailingIcon2;
                                i34 = supportingText3;
                                i12 = prefix3;
                                leadingIcon2 = suffix2;
                                supportingText2 = i19;
                                prefix2 = $composer2;
                                $composer2 = obj6;
                                label2 = isError6;
                                isError2 = container;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (str & 16384 != 0) {
                                $dirty1 &= i8;
                            }
                            if (i49 &= str != 0) {
                                $dirty1 = leadingIcon;
                                obj7 = trailingIcon;
                                i12 = prefix;
                                i34 = supportingText;
                                supportingText2 = colors;
                                obj13 = contentPadding;
                                isError2 = container;
                                i25 = i52;
                                prefix2 = $composer2;
                                $composer2 = obj6;
                                $dirty12 = placeholder;
                                label2 = z;
                                leadingIcon2 = suffix;
                            } else {
                                $dirty12 = placeholder;
                                obj7 = trailingIcon;
                                i12 = prefix;
                                i34 = supportingText;
                                supportingText2 = colors;
                                obj13 = contentPadding;
                                isError2 = container;
                                prefix2 = $composer2;
                                i25 = $dirty1;
                                $composer2 = obj6;
                                $dirty1 = leadingIcon;
                                label2 = z;
                                leadingIcon2 = suffix;
                            }
                        }
                    } else {
                    }
                    prefix2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, $dirty, i25, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:884)");
                    }
                    i23 = i25;
                    i32 = $dirty;
                    $dirty = i56;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, $composer2, $dirty, $dirty1, obj7, i12, leadingIcon2, i34, singleLine, z5, label2, obj14, obj13, supportingText2, isError2, prefix2, i68 | i99, i76 | i112, 0);
                    composer = prefix2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    isError4 = i12;
                    prefix4 = z4;
                    i15 = $dirty1;
                    i36 = obj7;
                    i26 = leadingIcon2;
                    composableLambda = isError2;
                    suffix3 = $composer2;
                    container2 = obj13;
                    contentPadding3 = i34;
                    supportingText4 = colors2;
                } else {
                    $composer2.skipToGroupEnd();
                    supportingText4 = placeholder;
                    i15 = leadingIcon;
                    i36 = trailingIcon;
                    i26 = suffix;
                    contentPadding3 = supportingText;
                    supportingText2 = colors;
                    container2 = contentPadding;
                    composableLambda = container;
                    composer = $composer2;
                    i32 = $dirty;
                    i23 = $dirty1;
                    prefix4 = z;
                    suffix3 = obj6;
                    isError4 = prefix;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldDefaults.DecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, prefix4, suffix3, supportingText4, i15, i36, isError4, i26, contentPadding3, supportingText2, container2, composableLambda, $changed, $changed1, i21);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final androidx.compose.material3.TextFieldColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -471651810;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)921@46417L11,921@46429L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:921)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, i3 &= 112);
    }

    public final androidx.compose.material3.TextFieldColors colors-0hiis_0(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i50, int i51) {
        int companion3;
        int companion8;
        int companion4;
        Color.Companion companion10;
        int companion7;
        int companion12;
        int companion11;
        int companion5;
        int companion2;
        int companion6;
        int companion;
        int companion9;
        int unspecified-0d7_KjU27;
        boolean traceInProgress;
        int i2;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU17;
        int unspecified-0d7_KjU7;
        int unspecified-0d7_KjU14;
        int unspecified-0d7_KjU22;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU21;
        int unspecified-0d7_KjU8;
        long unspecified-0d7_KjU3;
        int unspecified-0d7_KjU9;
        int i;
        int unspecified-0d7_KjU2;
        long unspecified-0d7_KjU5;
        int unspecified-0d7_KjU23;
        int unspecified-0d7_KjU19;
        int unspecified-0d7_KjU18;
        int unspecified-0d7_KjU28;
        int unspecified-0d7_KjU13;
        int unspecified-0d7_KjU20;
        int unspecified-0d7_KjU25;
        int unspecified-0d7_KjU15;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU10;
        int unspecified-0d7_KjU31;
        int unspecified-0d7_KjU16;
        int unspecified-0d7_KjU26;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU29;
        int unspecified-0d7_KjU24;
        long unspecified-0d7_KjU12;
        int unspecified-0d7_KjU30;
        int i4;
        long l30;
        long l41;
        long l7;
        long l34;
        long l35;
        long l24;
        long l20;
        long l36;
        long l28;
        long l8;
        int i3;
        long l31;
        long l12;
        long l15;
        long l37;
        long l2;
        long l19;
        long l17;
        long l42;
        long l9;
        long l;
        long l5;
        long l10;
        long l29;
        long l38;
        long l22;
        long l13;
        long l14;
        long l39;
        long l32;
        long l11;
        long l25;
        long l3;
        long l6;
        long l40;
        long l21;
        long l4;
        long l23;
        long l18;
        long l33;
        long l26;
        long l27;
        long l16;
        final Composer composer = obj178;
        int i5 = obj184;
        int i6 = obj185;
        int i7 = 1767617725;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)1023@53240L11,1023@53252L30:TextFieldDefaults.kt#uh7d8r");
        if (i5 & 1 != 0) {
            l30 = unspecified-0d7_KjU4;
        } else {
            l30 = focusedTextColor;
        }
        if (i5 & 2 != 0) {
            l41 = unspecified-0d7_KjU17;
        } else {
            l41 = disabledTextColor;
        }
        if (i5 & 4 != 0) {
            l7 = unspecified-0d7_KjU7;
        } else {
            l7 = focusedContainerColor;
        }
        if (i5 & 8 != 0) {
            l34 = unspecified-0d7_KjU14;
        } else {
            l34 = disabledContainerColor;
        }
        if (i5 & 16 != 0) {
            l35 = unspecified-0d7_KjU22;
        } else {
            l35 = cursorColor;
        }
        if (i5 & 32 != 0) {
            l24 = unspecified-0d7_KjU;
        } else {
            l24 = selectionColors;
        }
        if (i5 & 64 != 0) {
            l20 = unspecified-0d7_KjU21;
        } else {
            l20 = unfocusedBorderColor;
        }
        if (i5 & 128 != 0) {
            l36 = unspecified-0d7_KjU8;
        } else {
            l36 = errorBorderColor;
        }
        if (i5 & 256 != 0) {
            l28 = unspecified-0d7_KjU3;
        } else {
            l28 = unfocusedLeadingIconColor;
        }
        if (i5 & 512 != 0) {
            l8 = unspecified-0d7_KjU9;
        } else {
            l8 = errorLeadingIconColor;
        }
        i3 = i5 & 1024 != 0 ? i : unfocusedTrailingIconColor;
        if (i5 & 2048 != 0) {
            l31 = unspecified-0d7_KjU2;
        } else {
            l31 = disabledTrailingIconColor;
        }
        if (i5 & 4096 != 0) {
            l12 = unspecified-0d7_KjU5;
        } else {
            l12 = focusedLabelColor;
        }
        if (i5 & 8192 != 0) {
            l15 = unspecified-0d7_KjU23;
        } else {
            l15 = disabledLabelColor;
        }
        if (i5 & 16384 != 0) {
            l37 = unspecified-0d7_KjU19;
        } else {
            l37 = focusedPlaceholderColor;
        }
        if (i11 &= i5 != 0) {
            l2 = unspecified-0d7_KjU18;
        } else {
            l2 = disabledPlaceholderColor;
        }
        if (i12 &= i5 != 0) {
            l19 = unspecified-0d7_KjU28;
        } else {
            l19 = focusedSupportingTextColor;
        }
        if (i13 &= i5 != 0) {
            l17 = unspecified-0d7_KjU13;
        } else {
            l17 = disabledSupportingTextColor;
        }
        if (i14 &= i5 != 0) {
            l42 = unspecified-0d7_KjU20;
        } else {
            l42 = focusedPrefixColor;
        }
        if (i15 &= i5 != 0) {
            l9 = unspecified-0d7_KjU25;
        } else {
            l9 = disabledPrefixColor;
        }
        if (i16 &= i5 != 0) {
            l = unspecified-0d7_KjU15;
        } else {
            l = focusedSuffixColor;
        }
        if (i17 &= i5 != 0) {
            l5 = unspecified-0d7_KjU6;
        } else {
            l5 = disabledSuffixColor;
        }
        if (i18 &= i5 != 0) {
            l10 = unspecified-0d7_KjU10;
        } else {
            l10 = $composer;
        }
        if (i19 &= i5 != 0) {
            l29 = unspecified-0d7_KjU31;
        } else {
            l29 = $changed1;
        }
        if (i20 &= i5 != 0) {
            l38 = unspecified-0d7_KjU16;
        } else {
            l38 = $changed3;
        }
        if (i21 &= i5 != 0) {
            l22 = unspecified-0d7_KjU26;
        } else {
            l22 = i50;
        }
        if (i22 &= i5 != 0) {
            l13 = unspecified-0d7_KjU11;
        } else {
            l13 = obj144;
        }
        if (i23 &= i5 != 0) {
            l14 = unspecified-0d7_KjU29;
        } else {
            l14 = obj146;
        }
        if (i24 &= i5 != 0) {
            l39 = unspecified-0d7_KjU24;
        } else {
            l39 = obj148;
        }
        if (i25 &= i5 != 0) {
            l32 = unspecified-0d7_KjU12;
        } else {
            l32 = obj150;
        }
        if (i5 &= unspecified-0d7_KjU30 != 0) {
            l11 = unspecified-0d7_KjU30;
        } else {
            l11 = obj152;
        }
        if (i6 & 1 != 0) {
            l25 = unspecified-0d7_KjU30;
        } else {
            l25 = obj154;
        }
        if (i6 & 2 != 0) {
            l3 = unspecified-0d7_KjU30;
        } else {
            l3 = obj156;
        }
        if (i6 & 4 != 0) {
            l6 = unspecified-0d7_KjU30;
        } else {
            l6 = obj158;
        }
        if (i6 & 8 != 0) {
            l40 = unspecified-0d7_KjU30;
        } else {
            l40 = obj160;
        }
        if (i6 & 16 != 0) {
            l21 = unspecified-0d7_KjU30;
        } else {
            l21 = obj162;
        }
        if (i6 & 32 != 0) {
            l4 = unspecified-0d7_KjU30;
        } else {
            l4 = obj164;
        }
        if (i6 & 64 != 0) {
            l23 = unspecified-0d7_KjU30;
        } else {
            l23 = obj166;
        }
        if (i6 & 128 != 0) {
            l18 = unspecified-0d7_KjU30;
        } else {
            l18 = obj168;
        }
        if (i6 & 256 != 0) {
            l33 = unspecified-0d7_KjU30;
        } else {
            l33 = obj170;
        }
        if (i6 & 512 != 0) {
            l26 = unspecified-0d7_KjU30;
        } else {
            l26 = obj172;
        }
        if (i6 & 1024 != 0) {
            l27 = unspecified-0d7_KjU30;
        } else {
            l27 = obj174;
        }
        if (i6 & 2048 != 0) {
            l16 = unspecified-0d7_KjU27;
        } else {
            l16 = obj176;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, obj179, obj180, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1023)");
        } else {
            i2 = obj179;
            i4 = obj180;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, i9 &= 112).copy-ejIjP34(l30, obj8, l41, obj10, l7, obj12, l34, obj14, l35, obj16, l24, obj18, l20, obj20, l36, obj22, l28, obj24, l8, obj26, i3, l31, obj29, l12, obj31, l15, obj33, l37, obj35, l2, obj37, l19, obj39, l17, obj41, l42, obj43, l9, obj45, l, obj47, l5, obj49);
    }

    public final PaddingValues contentPadding-a9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.PaddingValues-a9UjIt4(start, top, end, bottom);
    }

    public final androidx.compose.material3.TextFieldColors getDefaultOutlinedTextFieldColors(androidx.compose.material3.ColorScheme $this$defaultOutlinedTextFieldColors, Composer $composer, int $changed) {
        androidx.compose.material3.TextFieldColors defaultOutlinedTextFieldColorsCached$material3_release;
        boolean traceInProgress;
        String str;
        String $i$f$getCurrent;
        int i9;
        androidx.compose.material3.TextFieldColors textFieldColors;
        long token20;
        long token22;
        long copy-wmQWz5c$default8;
        long token4;
        int i29;
        long transparent-0d7_KjU2;
        int i4;
        long transparent-0d7_KjU3;
        int i20;
        long transparent-0d7_KjU4;
        long transparent-0d7_KjU;
        long token15;
        long token12;
        Object $changed$iv;
        long token21;
        long token28;
        long copy-wmQWz5c$default4;
        long token19;
        int i2;
        long token25;
        int i27;
        long token14;
        int i21;
        long copy-wmQWz5c$default7;
        long token27;
        int i5;
        long token18;
        int i7;
        long token9;
        int i6;
        long copy-wmQWz5c$default9;
        long token5;
        int i10;
        long token2;
        int i8;
        long token6;
        int i14;
        long copy-wmQWz5c$default3;
        long token26;
        int i24;
        long token17;
        int i12;
        long token29;
        int i22;
        long copy-wmQWz5c$default6;
        long token23;
        int i3;
        long token24;
        int i30;
        long token7;
        int i25;
        long copy-wmQWz5c$default2;
        long token3;
        int i26;
        long token8;
        int i18;
        long token11;
        int i13;
        long copy-wmQWz5c$default;
        long token;
        int i16;
        long token16;
        int i11;
        long token13;
        int i15;
        long copy-wmQWz5c$default5;
        long token10;
        int i17;
        int i23;
        int i28;
        int i19;
        int i;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultOutlinedTextFieldColors;
        final Composer composer = $composer;
        int i31 = -292363577;
        ComposerKt.sourceInformationMarkerStart(composer, i31, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i31, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1071)");
        } else {
            i9 = $changed;
        }
        composer.startReplaceGroup(1540400102);
        ComposerKt.sourceInformation(composer, "*1086@57012L7");
        if (colorScheme.getDefaultOutlinedTextFieldColorsCached$material3_release() == null) {
            i20 = 0;
            i29 = 0;
            i4 = 0;
            int i38 = i33;
            int i39 = i34;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            i21 = 0;
            i2 = 0;
            i27 = 0;
            i6 = 0;
            i5 = 0;
            i7 = 0;
            i14 = 0;
            i10 = 0;
            i8 = 0;
            i22 = 0;
            i24 = 0;
            i12 = 0;
            i25 = 0;
            i3 = 0;
            i30 = 0;
            i13 = 0;
            i26 = 0;
            i18 = 0;
            i15 = 0;
            i16 = 0;
            i11 = 0;
            i17 = 0;
            textFieldColors = new TextFieldColors(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor()), obj8, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputColor()), obj10, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), obj12, 1052938076, i29, 0, i4, 14), obj12, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor()), i29, Color.Companion.getTransparent-0d7_KjU(), i4, Color.Companion.getTransparent-0d7_KjU(), i20, Color.Companion.getTransparent-0d7_KjU(), obj20, Color.Companion.getTransparent-0d7_KjU(), obj22, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getCaretColor()), obj24, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor()), obj26, (TextSelectionColors)composer.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), obj29, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), obj31, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), obj33, 1039516303, i2, 0, i27, 14), obj33, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), i2, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), i27, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), i21, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), obj41, 1052938076, i5, 0, i7, 14), obj41, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), i5, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), i7, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), i6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), obj49, 1052938076, i10, 0, i8, 14), obj49, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), i10, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), i8, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), i14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), obj57, 1052938076, i24, 0, i12, 14), obj57, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), i24, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), i12, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), i22, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), obj65, 1052938076, i3, 0, i30, 14), obj65, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), i3, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), i30, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), i25, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor()), obj73, 1052938076, i26, 0, i18, 14), obj73, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), i26, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), i18, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), i13, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), obj81, 1052938076, i16, 0, i11, 14), obj81, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), i16, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), i11, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), i15, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), obj89, 1052938076, i17, 0, 0, 14), obj89, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), i17, 0);
            str = 0;
            colorScheme.setDefaultOutlinedTextFieldColorsCached$material3_release(textFieldColors);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedTextFieldColorsCached$material3_release;
    }

    public final float getFocusedBorderThickness-D9Ej5fM() {
        return OutlinedTextFieldDefaults.FocusedBorderThickness;
    }

    public final float getMinHeight-D9Ej5fM() {
        return OutlinedTextFieldDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return OutlinedTextFieldDefaults.MinWidth;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1066756961;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C729@37132L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:729)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final float getUnfocusedBorderThickness-D9Ej5fM() {
        return OutlinedTextFieldDefaults.UnfocusedBorderThickness;
    }
}
