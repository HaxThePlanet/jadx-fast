package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008(\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\u00102\u0008\u0008\u0002\u0010\"\u001a\u00020\u00062\u0008\u0008\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\u0008+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\u0008\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u00103\u001a\u0002042\u0013\u0008\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\u0008+H\u0007¢\u0006\u0002\u00106Já\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\u0008+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\u0008\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0008\u0008\u0002\u0010!\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u00103\u001a\u0002042\u0013\u0008\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\u0008+H\u0007¢\u0006\u0002\u00107JÂ\u0001\u00108\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\u0008+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\u0008\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00109JÌ\u0001\u00108\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\u0008+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\u0008\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0015\u0008\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\u0008+2\u0008\u0008\u0002\u0010!\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u0010:Jä\u0001\u0010;\u001a\u00020 2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020=2\u0008\u0008\u0002\u0010?\u001a\u00020=2\u0008\u0008\u0002\u0010@\u001a\u00020=2\u0008\u0008\u0002\u0010A\u001a\u00020=2\u0008\u0008\u0002\u0010B\u001a\u00020=2\u0008\u0008\u0002\u0010C\u001a\u00020=2\u0008\u0008\u0002\u0010D\u001a\u00020=2\u0008\u0008\u0002\u0010E\u001a\u00020=2\u0008\u0008\u0002\u0010F\u001a\u00020=2\u0008\u0008\u0002\u0010G\u001a\u00020=2\u0008\u0008\u0002\u0010H\u001a\u00020=2\u0008\u0008\u0002\u0010I\u001a\u00020=2\u0008\u0008\u0002\u0010J\u001a\u00020=2\u0008\u0008\u0002\u0010K\u001a\u00020=2\u0008\u0008\u0002\u0010L\u001a\u00020=2\u0008\u0008\u0002\u0010M\u001a\u00020=2\u0008\u0008\u0002\u0010N\u001a\u00020=2\u0008\u0008\u0002\u0010O\u001a\u00020=2\u0008\u0008\u0002\u0010P\u001a\u00020=2\u0008\u0008\u0002\u0010Q\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\u0008R\u0010SJ:\u0010T\u001a\u0002042\u0008\u0008\u0002\u0010U\u001a\u00020\u00062\u0008\u0008\u0002\u0010V\u001a\u00020\u00062\u0008\u0008\u0002\u0010W\u001a\u00020\u00062\u0008\u0008\u0002\u0010X\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010ZJä\u0001\u0010[\u001a\u00020 2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020=2\u0008\u0008\u0002\u0010?\u001a\u00020=2\u0008\u0008\u0002\u0010@\u001a\u00020=2\u0008\u0008\u0002\u0010A\u001a\u00020=2\u0008\u0008\u0002\u0010\\\u001a\u00020=2\u0008\u0008\u0002\u0010]\u001a\u00020=2\u0008\u0008\u0002\u0010^\u001a\u00020=2\u0008\u0008\u0002\u0010_\u001a\u00020=2\u0008\u0008\u0002\u0010F\u001a\u00020=2\u0008\u0008\u0002\u0010G\u001a\u00020=2\u0008\u0008\u0002\u0010H\u001a\u00020=2\u0008\u0008\u0002\u0010I\u001a\u00020=2\u0008\u0008\u0002\u0010J\u001a\u00020=2\u0008\u0008\u0002\u0010K\u001a\u00020=2\u0008\u0008\u0002\u0010L\u001a\u00020=2\u0008\u0008\u0002\u0010M\u001a\u00020=2\u0008\u0008\u0002\u0010N\u001a\u00020=2\u0008\u0008\u0002\u0010O\u001a\u00020=2\u0008\u0008\u0002\u0010P\u001a\u00020=2\u0008\u0008\u0002\u0010Q\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\u0008`\u0010SJ:\u0010a\u001a\u0002042\u0008\u0008\u0002\u0010U\u001a\u00020\u00062\u0008\u0008\u0002\u0010W\u001a\u00020\u00062\u0008\u0008\u0002\u0010V\u001a\u00020\u00062\u0008\u0008\u0002\u0010X\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008b\u0010ZJ:\u0010c\u001a\u0002042\u0008\u0008\u0002\u0010U\u001a\u00020\u00062\u0008\u0008\u0002\u0010V\u001a\u00020\u00062\u0008\u0008\u0002\u0010W\u001a\u00020\u00062\u0008\u0008\u0002\u0010X\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008d\u0010ZJJ\u0010e\u001a\u00020f*\u00020f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010g\u001a\u00020\u00062\u0008\u0008\u0002\u0010h\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008i\u0010jR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u000c\u0010\u0008R\u0019\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u000e\u0010\u0008R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0016\u0010\u0008R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006k", d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "border", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDefaults {

    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    private static final float FocusedBorderThickness = 0f;
    public static final androidx.compose.material.TextFieldDefaults INSTANCE = null;
    public static final float IconOpacity = 0.54f;
    private static final float MinHeight = 0f;
    private static final float MinWidth = 0f;
    private static final float UnfocusedBorderThickness = 0f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    static {
        TextFieldDefaults textFieldDefaults = new TextFieldDefaults();
        TextFieldDefaults.INSTANCE = textFieldDefaults;
        int i5 = 0;
        TextFieldDefaults.MinHeight = Dp.constructor-impl((float)i);
        int i6 = 0;
        TextFieldDefaults.MinWidth = Dp.constructor-impl((float)i2);
        int i7 = 0;
        TextFieldDefaults.UnfocusedBorderThickness = Dp.constructor-impl((float)i3);
        int i8 = 0;
        TextFieldDefaults.FocusedBorderThickness = Dp.constructor-impl((float)i4);
    }

    public static Modifier indicatorLine-gv0btCI$default(androidx.compose.material.TextFieldDefaults textFieldDefaults, Modifier modifier2, boolean z3, boolean z4, InteractionSource interactionSource5, androidx.compose.material.TextFieldColors textFieldColors6, float f7, float f8, int i9, Object object10) {
        float f;
        float f2;
        float obj14;
        f = i9 & 16 != 0 ? obj14 : f7;
        f2 = i9 & 32 != 0 ? obj14 : f8;
        return textFieldDefaults.indicatorLine-gv0btCI(modifier2, z3, z4, interactionSource5, textFieldColors6, f, f2);
    }

    public static PaddingValues outlinedTextFieldPadding-a9UjIt4$default(androidx.compose.material.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
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

    public static PaddingValues textFieldWithLabelPadding-a9UjIt4$default(androidx.compose.material.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
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
            obj3 = TextFieldKt.getFirstBaselineOffset();
        }
        if (i6 &= 8 != 0) {
            obj4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.textFieldWithLabelPadding-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public static PaddingValues textFieldWithoutLabelPadding-a9UjIt4$default(androidx.compose.material.TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
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

    public final void BorderBox-nbWgWpA(boolean enabled, boolean isError, InteractionSource interactionSource, androidx.compose.material.TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed, int i10) {
        State anon;
        boolean traceInProgress;
        int $dirty;
        int i2;
        int i7;
        int i8;
        int i;
        Object outlinedTextFieldShape;
        Object obj2;
        int changed2;
        float focusedBorderThickness2;
        boolean traceInProgress2;
        Object obj3;
        int changed3;
        float unfocusedBorderThickness2;
        float f3;
        int changed;
        int i9;
        int skipping;
        int i4;
        int defaultsInvalid;
        int i5;
        float f4;
        boolean z2;
        Composer composer;
        boolean z;
        int i6;
        Object obj;
        Object i3;
        float f2;
        float f;
        Composer composer2;
        int i11;
        final Object obj4 = this;
        final int i39 = $changed;
        final int i40 = i10;
        anon = 943754022;
        traceInProgress = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(traceInProgress, "C(BorderBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)332@12464L22,336@12648L203,344@12860L47:TextFieldDefaults.kt#jmzs0o");
        $dirty = $changed;
        if (i40 & 1 != 0) {
            $dirty |= 6;
            z2 = enabled;
        } else {
            if (i39 & 6 == 0) {
                i2 = traceInProgress.changed(enabled) ? 4 : 2;
                $dirty |= i2;
            } else {
                z2 = enabled;
            }
        }
        if (i40 & 2 != 0) {
            $dirty |= 48;
            z = isError;
        } else {
            if (i39 & 48 == 0) {
                i7 = traceInProgress.changed(isError) ? 32 : 16;
                $dirty |= i7;
            } else {
                z = isError;
            }
        }
        if (i40 & 4 != 0) {
            $dirty |= 384;
            obj = interactionSource;
        } else {
            if (i39 & 384 == 0) {
                i8 = traceInProgress.changed(interactionSource) ? 256 : 128;
                $dirty |= i8;
            } else {
                obj = interactionSource;
            }
        }
        if (i40 & 8 != 0) {
            $dirty |= 3072;
            obj2 = colors;
        } else {
            if (i39 & 3072 == 0) {
                i = traceInProgress.changed(colors) ? 2048 : 1024;
                $dirty |= i;
            } else {
                obj2 = colors;
            }
        }
        if (i39 & 24576 == 0) {
            if (i40 & 16 == 0) {
                changed2 = traceInProgress.changed(shape) ? 16384 : 8192;
            } else {
                outlinedTextFieldShape = shape;
            }
            $dirty |= changed2;
        } else {
            outlinedTextFieldShape = shape;
        }
        if (i19 &= i39 == 0) {
            if (i40 & 32 == 0) {
                changed3 = traceInProgress.changed(focusedBorderThickness) ? 131072 : 65536;
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            $dirty |= changed3;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        if (i29 &= i39 == 0) {
            if (i40 & 64 == 0) {
                changed = traceInProgress.changed(unfocusedBorderThickness) ? 1048576 : 524288;
            } else {
                unfocusedBorderThickness2 = unfocusedBorderThickness;
            }
            $dirty |= changed;
        } else {
            unfocusedBorderThickness2 = unfocusedBorderThickness;
        }
        int i41 = 12582912;
        if (i40 & 128 != 0) {
            $dirty |= i41;
        } else {
            if (i39 & i41 == 0) {
                i9 = traceInProgress.changed(obj4) ? 8388608 : 4194304;
                $dirty |= i9;
            }
        }
        if (i34 &= $dirty == 4793490) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i42 = -3670017;
                int i43 = -458753;
                int i44 = -57345;
                if (i39 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (i40 & 16 != 0) {
                            outlinedTextFieldShape = obj4.getOutlinedTextFieldShape(traceInProgress, i38 &= 14);
                            $dirty &= i44;
                        }
                        if (i40 & 32 != 0) {
                            focusedBorderThickness2 = TextFieldDefaults.FocusedBorderThickness;
                            $dirty &= i43;
                        }
                        if (i40 & 64 != 0) {
                            $dirty &= i42;
                            f2 = focusedBorderThickness2;
                            f = unfocusedBorderThickness2;
                        } else {
                            f2 = focusedBorderThickness2;
                            f = unfocusedBorderThickness2;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i40 & 16 != 0) {
                            $dirty &= i44;
                        }
                        if (i40 & 32 != 0) {
                            $dirty &= i43;
                        }
                        if (i40 & 64 != 0) {
                            $dirty &= i42;
                            f2 = focusedBorderThickness2;
                            f = unfocusedBorderThickness2;
                        } else {
                            f2 = focusedBorderThickness2;
                            f = unfocusedBorderThickness2;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, $dirty, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:335)");
                }
                composer2 = traceInProgress;
                BoxKt.Box(BorderKt.border((Modifier)Modifier.Companion, (BorderStroke)TextFieldDefaultsKt.access$animateBorderStrokeAsState-NuRrP5Q(z2, z, obj, obj2, f2, f, composer2, i16 | i27).getValue(), outlinedTextFieldShape), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f2;
                f4 = f;
                i6 = $dirty;
                obj3 = outlinedTextFieldShape;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                f4 = unfocusedBorderThickness2;
                f3 = focusedBorderThickness2;
                i6 = $dirty;
                obj3 = outlinedTextFieldShape;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new TextFieldDefaults.BorderBox.1(obj4, enabled, isError, interactionSource, colors, obj3, f3, f4, i39, i40);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final void OutlinedTextFieldDecorationBox(String value, Function2 innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Function2 border, Composer $composer, int $changed, int $changed1, int i18) {
        boolean traceInProgress2;
        Object endRestartGroup;
        int defaultsInvalid;
        boolean isError2;
        int isError3;
        Object $dirty14;
        Object obj10;
        Object obj3;
        Object obj16;
        Object obj11;
        Object obj12;
        Object obj4;
        int changed;
        String $dirty1;
        Object outlinedTextFieldPadding-a9UjIt4$default;
        Function2 rememberComposableLambda;
        boolean traceInProgress;
        boolean i16;
        boolean $dirty16;
        int $dirty2;
        VisualTransformation i7;
        int i40;
        boolean z2;
        boolean $composer2;
        int $dirty3;
        boolean label2;
        Object $dirty11;
        Object $dirty4;
        int $dirty15;
        Object placeholder2;
        int i10;
        int $dirty13;
        int $dirty12;
        Object obj8;
        int leadingIcon2;
        int obj9;
        Object obj6;
        int trailingIcon2;
        int obj;
        boolean z;
        int i39;
        int i11;
        Object obj5;
        Object obj13;
        Object obj2;
        int $dirty18;
        Object obj7;
        Object obj14;
        int i20;
        Composer i12;
        int changedInstance;
        int $dirty;
        int i29;
        int i31;
        int i26;
        int i13;
        int i5;
        int i2;
        int i21;
        int $dirty6;
        int i42;
        int i46;
        boolean changed2;
        int i6;
        int $dirty8;
        int i43;
        int i14;
        int i25;
        int i23;
        int i;
        int i37;
        boolean $dirty5;
        int i22;
        int i32;
        int i35;
        int i17;
        int $dirty17;
        int i4;
        int i41;
        int i45;
        int $dirty9;
        int i34;
        int i15;
        int i19;
        int $dirty10;
        int i44;
        Composer composer2;
        Composer composer;
        int i3;
        int i30;
        int i38;
        int i33;
        Object obj15;
        int i24;
        int i28;
        int i9;
        int $dirty7;
        int i36;
        int i27;
        int i8;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj65;
        i16 = $changed;
        $dirty16 = $changed1;
        i7 = i18;
        $composer2 = $composer.startRestartGroup(-1280721485);
        ComposerKt.sourceInformation($composer2, "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)756@34416L25,758@34552L78,773@35068L22,761@34639L549:TextFieldDefaults.kt#jmzs0o");
        $dirty3 = $changed;
        $dirty15 = $changed1;
        if (i7 & 1 != 0) {
            $dirty3 |= 6;
            obj8 = value;
        } else {
            if (i16 & 6 == 0) {
                i11 = $composer2.changed(value) ? 4 : 2;
                $dirty3 |= i11;
            } else {
                obj8 = value;
            }
        }
        if (i7 & 2 != 0) {
            $dirty3 |= 48;
            obj5 = innerTextField;
        } else {
            if (i16 & 48 == 0) {
                i20 = $composer2.changedInstance(innerTextField) ? 32 : 16;
                $dirty3 |= i20;
            } else {
                obj5 = innerTextField;
            }
        }
        $dirty = 128;
        if (i7 & 4 != 0) {
            $dirty3 |= 384;
        } else {
            if (i16 & 384 == 0) {
                i40 = $composer2.changed(enabled) ? changedInstance : $dirty;
                $dirty3 |= i40;
            }
        }
        i26 = 2048;
        if (i7 & 8 != 0) {
            $dirty3 |= 3072;
            z2 = singleLine;
        } else {
            if (i16 & 3072 == 0) {
                i13 = $composer2.changed(singleLine) ? i26 : i29;
                $dirty3 |= i13;
            } else {
                z2 = singleLine;
            }
        }
        i42 = 8192;
        if (i7 & 16 != 0) {
            $dirty3 |= 24576;
            obj6 = visualTransformation;
        } else {
            if (i16 & 24576 == 0) {
                i5 = $composer2.changed(visualTransformation) ? $dirty6 : i42;
                $dirty3 |= i5;
            } else {
                obj6 = visualTransformation;
            }
        }
        int i116 = 196608;
        if (i7 & 32 != 0) {
            $dirty3 |= i116;
        } else {
            if (i16 & i116 == 0) {
                i2 = $composer2.changed(interactionSource) ? 131072 : 65536;
                $dirty3 |= i2;
            }
        }
        i21 = i7 & 64;
        i46 = 1572864;
        if (i21 != 0) {
            $dirty3 |= i46;
            z = isError;
        } else {
            if (i16 & i46 == 0) {
                i6 = $composer2.changed(isError) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                z = isError;
            }
        }
        $dirty18 = i7 & 128;
        $dirty8 = 12582912;
        if ($dirty18 != 0) {
            $dirty3 |= $dirty8;
            obj7 = label;
        } else {
            if (i16 & $dirty8 == 0) {
                i43 = $composer2.changedInstance(label) ? 8388608 : 4194304;
                $dirty3 |= i43;
            } else {
                obj7 = label;
            }
        }
        int i62 = i7 & 256;
        int i119 = 100663296;
        if (i62 != 0) {
            $dirty3 |= i119;
            i14 = i62;
            obj10 = placeholder;
        } else {
            if (i16 & i119 == 0) {
                i14 = i62;
                i25 = $composer2.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty3 |= i25;
            } else {
                i14 = i62;
                obj10 = placeholder;
            }
        }
        int i63 = i7 & 512;
        int i121 = 805306368;
        if (i63 != 0) {
            $dirty3 |= i121;
            i23 = i63;
            obj3 = leadingIcon;
        } else {
            if (i16 & i121 == 0) {
                i23 = i63;
                i = $composer2.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty3 |= i;
            } else {
                i23 = i63;
                obj3 = leadingIcon;
            }
        }
        int i64 = i7 & 1024;
        if (i64 != 0) {
            $dirty15 |= 6;
            i37 = i64;
            obj16 = trailingIcon;
        } else {
            if ($dirty16 & 6 == 0) {
                i37 = i64;
                i46 = $composer2.changedInstance(trailingIcon) ? 4 : 2;
                $dirty15 |= i46;
            } else {
                i37 = i64;
                obj16 = trailingIcon;
            }
        }
        if ($dirty16 & 48 == 0) {
            if (i7 & 2048 == 0) {
                i6 = $composer2.changed(colors) ? 32 : 16;
            } else {
                obj11 = colors;
            }
            $dirty15 |= i6;
        } else {
            obj11 = colors;
        }
        if ($dirty16 & 384 == 0) {
            if (i7 & 4096 == 0) {
                if ($composer2.changed(contentPadding)) {
                } else {
                    changedInstance = $dirty;
                }
            } else {
                obj12 = contentPadding;
            }
            $dirty15 |= changedInstance;
        } else {
            obj12 = contentPadding;
        }
        rememberComposableLambda = i7 & 8192;
        if (rememberComposableLambda != 0) {
            $dirty15 |= 3072;
            obj4 = border;
        } else {
            if ($dirty16 & 3072 == 0) {
                if ($composer2.changedInstance(border)) {
                    i29 = i26;
                }
                $dirty15 |= i29;
            } else {
                obj4 = border;
            }
        }
        if (i7 & 16384 != 0) {
            $dirty15 |= 24576;
        } else {
            if ($dirty16 & 24576 == 0) {
                if ($composer2.changed(this)) {
                } else {
                    $dirty6 = i42;
                }
                $dirty15 |= $dirty6;
            }
        }
        $dirty1 = $dirty15;
        if ($dirty110 &= $dirty3 == 306783378 && $dirty1 & 9363 == 9362) {
            if ($dirty1 & 9363 == 9362) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (i16 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            isError2 = i21 != 0 ? 0 : z;
                            obj15 = $dirty18 != 0 ? i10 : obj7;
                            i24 = i14 != 0 ? i10 : placeholder;
                            i28 = i23 != 0 ? i10 : leadingIcon;
                            i9 = i37 != 0 ? i10 : trailingIcon;
                            if (i7 & 2048 != 0) {
                                int i101 = rememberComposableLambda;
                                composer = $composer2;
                                obj7 = i106;
                                changedInstance = obj7;
                                i29 = changedInstance;
                                i21 = i29;
                                i42 = i21;
                                i6 = i42;
                                i14 = i6;
                                i37 = i14;
                                i32 = i37;
                                i17 = i32;
                                i4 = i17;
                                i45 = i4;
                                i34 = i45;
                                i19 = i34;
                                i44 = i19;
                                i36 = i132;
                                i27 = i133;
                                obj65 = isError2;
                                i8 = i134;
                                isError3 = i18;
                                $composer2 = composer;
                                $dirty13 = $dirty1;
                                $dirty11 = rememberComposableLambda;
                            } else {
                                obj65 = isError2;
                                i27 = rememberComposableLambda;
                                isError3 = i7;
                                i8 = $dirty3;
                                $dirty11 = colors;
                                $dirty13 = $dirty7;
                            }
                            if (isError3 & 4096 != 0) {
                                z = obj65;
                                outlinedTextFieldPadding-a9UjIt4$default = TextFieldDefaults.outlinedTextFieldPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                $dirty13 &= -897;
                            } else {
                                $dirty14 = this;
                                z = obj65;
                                outlinedTextFieldPadding-a9UjIt4$default = contentPadding;
                            }
                            if (i27 != 0) {
                                TextFieldDefaults.OutlinedTextFieldDecorationBox.3 anon = new TextFieldDefaults.OutlinedTextFieldDecorationBox.3(enabled, z, interactionSource, $dirty11);
                                obj2 = outlinedTextFieldPadding-a9UjIt4$default;
                                obj14 = rememberComposableLambda;
                                obj13 = $dirty11;
                                $dirty1 = $dirty13;
                                $dirty4 = obj15;
                                $dirty12 = i24;
                                obj9 = i28;
                                obj = i9;
                            } else {
                                i16 = enabled;
                                z2 = interactionSource;
                                obj14 = border;
                                obj2 = outlinedTextFieldPadding-a9UjIt4$default;
                                obj13 = $dirty11;
                                $dirty1 = $dirty13;
                                $dirty4 = obj15;
                                $dirty12 = i24;
                                obj9 = i28;
                                obj = i9;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (i7 & 2048 != 0) {
                                $dirty1 &= -113;
                            }
                            if (i7 & 4096 != 0) {
                                i16 = enabled;
                                z2 = interactionSource;
                                $dirty12 = placeholder;
                                obj9 = leadingIcon;
                                obj = trailingIcon;
                                obj13 = colors;
                                obj2 = contentPadding;
                                $dirty1 = i49;
                                i8 = $dirty3;
                                $dirty4 = obj7;
                                $dirty14 = this;
                                obj14 = border;
                            } else {
                                $dirty14 = this;
                                i16 = enabled;
                                z2 = interactionSource;
                                $dirty12 = placeholder;
                                obj9 = leadingIcon;
                                obj = trailingIcon;
                                obj13 = colors;
                                obj2 = contentPadding;
                                i8 = $dirty3;
                                $dirty4 = obj7;
                                obj14 = border;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i8, $dirty1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:761)");
                    } else {
                        $dirty2 = i8;
                    }
                    i31 = $dirty1;
                    i22 = $dirty2;
                    i12 = $composer2;
                    $composer2 = z;
                    this.OutlinedTextFieldDecorationBox(value, innerTextField, i16, singleLine, visualTransformation, z2, $composer2, $dirty4, $dirty12, obj9, obj, $dirty14.getOutlinedTextFieldShape($composer2, i72 &= 14), obj13, obj2, obj14, i12, i57 | i88, i61 | i96, 0);
                    composer2 = i12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i39 = obj;
                    trailingIcon2 = obj9;
                    leadingIcon2 = $dirty12;
                    placeholder2 = $dirty4;
                    label2 = $composer2;
                } else {
                    $composer2.skipToGroupEnd();
                    leadingIcon2 = placeholder;
                    trailingIcon2 = leadingIcon;
                    obj13 = colors;
                    obj2 = contentPadding;
                    i31 = $dirty1;
                    composer2 = $composer2;
                    i22 = $dirty3;
                    label2 = z;
                    placeholder2 = obj7;
                    i39 = trailingIcon;
                    obj14 = border;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldDefaults.OutlinedTextFieldDecorationBox.4(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, label2, placeholder2, leadingIcon2, trailingIcon2, i39, obj13, obj2, obj14, $changed, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final void OutlinedTextFieldDecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> border, Composer $composer, int $changed, int $changed1, int i19) {
        Object obj7;
        Object obj12;
        Object obj10;
        Object obj4;
        Object i14;
        Object obj13;
        Object obj14;
        int contentPadding2;
        Object endRestartGroup;
        int defaultsInvalid;
        boolean isError5;
        int isError4;
        Object contentPadding3;
        boolean traceInProgress;
        Composer composer2;
        int rememberComposableLambda;
        boolean traceInProgress2;
        int outlinedTextFieldShape;
        int i45;
        boolean z3;
        Object obj11;
        int $dirty;
        int i38;
        Object restartGroup;
        int $dirty13;
        int $dirty1;
        Object obj6;
        boolean z2;
        Object obj3;
        Object obj;
        boolean field2;
        int isError3;
        int i42;
        Object obj8;
        int i46;
        int i2;
        int $dirty9;
        Object obj9;
        Shape shape2;
        int i43;
        boolean z;
        androidx.compose.material.TextFieldColors field;
        PaddingValues isError2;
        boolean z4;
        int i8;
        int changedInstance2;
        int i9;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int $dirty7;
        int i39;
        PaddingValues i40;
        int $dirty12;
        androidx.compose.material.TextFieldColors i18;
        int i6;
        int i16;
        int i7;
        int border2;
        Object obj2;
        int $dirty3;
        int i28;
        int i20;
        int i29;
        int i31;
        int $dirty4;
        int i32;
        int i33;
        int i34;
        int i36;
        int $dirty10;
        int $dirty5;
        int i5;
        int i47;
        boolean changedInstance;
        int i26;
        int $dirty11;
        int i27;
        int i21;
        int i44;
        int $dirty8;
        int i35;
        int i13;
        int i3;
        int $dirty2;
        int i17;
        int i4;
        int i41;
        Composer composer3;
        Composer composer;
        int $dirty6;
        int i10;
        int i22;
        int i30;
        Object obj5;
        int i25;
        int i37;
        int i23;
        Shape shape3;
        int i24;
        int i;
        int i11;
        int i12;
        int i15;
        ScopeUpdateScope scopeUpdateScope;
        Object obj67;
        int obj68;
        int obj69;
        int obj70;
        int obj71;
        int obj72;
        int obj73;
        boolean obj76;
        traceInProgress = this;
        int i48 = $changed;
        int i63 = $changed1;
        i45 = i19;
        restartGroup = $composer.startRestartGroup(-920823490);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldDecorationBox)P(13,4,3,11,14,5,6,7,9,8,12,10,1,2)669@31256L22,670@31314L25,672@31450L85,676@31552L628:TextFieldDefaults.kt#jmzs0o");
        $dirty13 = $changed;
        $dirty1 = $changed1;
        if (i45 & 1 != 0) {
            $dirty13 |= 6;
            obj6 = value;
        } else {
            if (i48 & 6 == 0) {
                i42 = restartGroup.changed(value) ? 4 : 2;
                $dirty13 |= i42;
            } else {
                obj6 = value;
            }
        }
        if (i45 & 2 != 0) {
            $dirty13 |= 48;
            obj8 = innerTextField;
        } else {
            if (i48 & 48 == 0) {
                i43 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty13 |= i43;
            } else {
                obj8 = innerTextField;
            }
        }
        if (i45 & 4 != 0) {
            $dirty13 |= 384;
            z = enabled;
        } else {
            if (i48 & 384 == 0) {
                i39 = restartGroup.changed(enabled) ? 256 : changedInstance2;
                $dirty13 |= i39;
            } else {
                z = enabled;
            }
        }
        i40 = i45 & 8;
        i18 = 2048;
        if (i40 != 0) {
            $dirty13 |= 3072;
            z3 = singleLine;
        } else {
            if (i48 & 3072 == 0) {
                i6 = restartGroup.changed(singleLine) ? i18 : $dirty12;
                $dirty13 |= i6;
            } else {
                z3 = singleLine;
            }
        }
        i20 = 8192;
        if (i45 & 16 != 0) {
            $dirty13 |= 24576;
            obj3 = visualTransformation;
        } else {
            if (i48 & 24576 == 0) {
                i16 = restartGroup.changed(visualTransformation) ? i28 : i20;
                $dirty13 |= i16;
            } else {
                obj3 = visualTransformation;
            }
        }
        i29 = 196608;
        if (i45 & 32 != 0) {
            $dirty13 |= i29;
            obj11 = interactionSource;
        } else {
            if (i48 & i29 == 0) {
                i7 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty13 |= i7;
            } else {
                obj11 = interactionSource;
            }
        }
        $dirty3 = i45 & 64;
        i31 = 1572864;
        if ($dirty3 != 0) {
            $dirty13 |= i31;
            field2 = isError;
        } else {
            if (i48 & i31 == 0) {
                i32 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty13 |= i32;
            } else {
                field2 = isError;
            }
        }
        $dirty9 = i45 & 128;
        i33 = 12582912;
        if ($dirty9 != 0) {
            $dirty13 |= i33;
            obj9 = label;
        } else {
            if (i48 & i33 == 0) {
                i34 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty13 |= i34;
            } else {
                obj9 = label;
            }
        }
        i8 = i45 & 256;
        i36 = 100663296;
        if (i8 != 0) {
            $dirty13 |= i36;
            obj7 = placeholder;
        } else {
            if (i48 & i36 == 0) {
                i36 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty13 |= i36;
            } else {
                obj7 = placeholder;
            }
        }
        int i49 = i45 & 512;
        int i137 = 805306368;
        if (i49 != 0) {
            $dirty13 |= i137;
            $dirty10 = i49;
            obj12 = leadingIcon;
        } else {
            if ($changed & i137 == 0) {
                $dirty10 = i49;
                i5 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty13 |= i5;
            } else {
                $dirty10 = i49;
                obj12 = leadingIcon;
            }
        }
        int i50 = i45 & 1024;
        if (i50 != 0) {
            $dirty1 |= 6;
            i47 = i50;
            obj10 = trailingIcon;
        } else {
            if (i63 & 6 == 0) {
                i47 = i50;
                i31 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty1 |= i31;
            } else {
                i47 = i50;
                obj10 = trailingIcon;
            }
        }
        if (i63 & 48 == 0) {
            if (i45 & 2048 == 0) {
                i32 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj4 = shape;
            }
            $dirty1 |= i32;
        } else {
            obj4 = shape;
        }
        if (i63 & 384 == 0) {
            if (i45 & 4096 == 0) {
                if (restartGroup.changed(colors)) {
                    changedInstance2 = 256;
                }
            } else {
                i14 = colors;
            }
            $dirty1 |= changedInstance2;
        } else {
            i14 = colors;
        }
        if (i63 & 3072 == 0) {
            if (i45 & 8192 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    $dirty12 = i18;
                }
            } else {
                obj13 = contentPadding;
            }
            $dirty1 |= $dirty12;
        } else {
            obj13 = contentPadding;
        }
        i38 = i45 & 16384;
        if (i38 != 0) {
            $dirty1 |= 24576;
            obj14 = border;
        } else {
            if (i63 & 24576 == 0) {
                if (restartGroup.changedInstance(border)) {
                } else {
                    i28 = i20;
                }
                $dirty1 |= i28;
            } else {
                obj14 = border;
            }
        }
        if (i45 & i130 != 0) {
            $dirty1 |= i29;
        } else {
            if (i63 & i29 == 0) {
                i9 = restartGroup.changed(traceInProgress) ? 131072 : 65536;
                $dirty1 |= i9;
            }
        }
        if ($dirty13 & $dirty7 == 306783378 && i60 &= $dirty1 == 74898) {
            if (i60 &= $dirty1 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            isError5 = $dirty3 != 0 ? 0 : field2;
                            obj5 = $dirty9 != 0 ? rememberComposableLambda : obj9;
                            i25 = i8 != 0 ? rememberComposableLambda : placeholder;
                            i37 = $dirty10 != 0 ? rememberComposableLambda : leadingIcon;
                            i23 = i47 != 0 ? rememberComposableLambda : trailingIcon;
                            if (i45 & 2048 != 0) {
                                $dirty1 &= -113;
                                shape3 = outlinedTextFieldShape;
                            } else {
                                shape3 = shape;
                            }
                            if (i45 & 4096 != 0) {
                                composer = restartGroup;
                                obj9 = $dirty1;
                                i8 = i124;
                                i18 = i8;
                                i28 = -920823490;
                                i29 = i132;
                                i32 = i28;
                                i34 = i29;
                                i47 = i32;
                                i26 = i34;
                                i27 = i47;
                                i44 = i26;
                                i35 = i27;
                                i3 = i44;
                                i17 = i35;
                                i41 = i3;
                                i24 = i147;
                                i12 = i149;
                                obj76 = isError5;
                                i15 = i11;
                                rememberComposableLambda = traceInProgress.outlinedTextFieldColors-dx8h9Zs(0, i45, 0, restartGroup, 0, $dirty1, 0, obj3, 0, obj8, 0, obj9, 0, i8, 0, i40, 0, i18, 0, i28, 0, i29, 0, i32, 0, i34);
                                composer2 = composer;
                                $dirty1 = isError4 & -897;
                            } else {
                                obj76 = isError5;
                                i24 = i38;
                                composer2 = restartGroup;
                                i15 = $dirty13;
                                isError4 = $dirty1;
                                rememberComposableLambda = colors;
                            }
                            if (i45 & 8192 != 0) {
                                contentPadding3 = TextFieldDefaults.outlinedTextFieldPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                $dirty1 &= -7169;
                            } else {
                                contentPadding3 = contentPadding;
                            }
                            if (i24 != 0) {
                                obj69 = obj76;
                                obj71 = rememberComposableLambda;
                                obj67 = anon;
                                obj72 = shape3;
                                super(enabled, obj69, interactionSource, obj71, obj72);
                                i40 = contentPadding3;
                                obj2 = rememberComposableLambda;
                                i18 = i38;
                                $dirty12 = restartGroup;
                                contentPadding2 = $dirty1;
                                z4 = z6;
                                obj = obj5;
                                isError3 = i25;
                                i46 = i37;
                                i2 = i23;
                            } else {
                                obj2 = border;
                                i40 = contentPadding3;
                                i18 = i38;
                                $dirty12 = restartGroup;
                                contentPadding2 = $dirty1;
                                z4 = isError6;
                                obj = obj5;
                                isError3 = i25;
                                i46 = i37;
                                i2 = i23;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i45 & 2048 != 0) {
                                $dirty1 &= -113;
                            }
                            if (i45 & 4096 != 0) {
                                $dirty1 &= -897;
                            }
                            if (i45 & 8192 != 0) {
                                contentPadding2 = $dirty1 & -7169;
                                i46 = leadingIcon;
                                i2 = trailingIcon;
                                $dirty12 = shape;
                                i18 = colors;
                                i40 = contentPadding;
                                obj2 = border;
                                composer2 = restartGroup;
                                i15 = $dirty13;
                                z4 = field2;
                                obj = obj9;
                                isError3 = placeholder;
                            } else {
                                i46 = leadingIcon;
                                i2 = trailingIcon;
                                $dirty12 = shape;
                                i18 = colors;
                                i40 = contentPadding;
                                obj2 = border;
                                composer2 = restartGroup;
                                i15 = $dirty13;
                                contentPadding2 = $dirty1;
                                z4 = field2;
                                obj = obj9;
                                isError3 = placeholder;
                            }
                        }
                    } else {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-920823490, i15, contentPadding2, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:675)");
                    } else {
                        $dirty = i15;
                    }
                    i28 = composer2;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, obj, isError3, i46, i2, singleLine, enabled, z4, interactionSource, i40, $dirty12, i18, obj2, i28, i73 | i101, rememberComposableLambda | i111);
                    composer3 = i28;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z4;
                    isError2 = i40;
                    shape2 = $dirty12;
                    field = i18;
                    composableLambda = obj2;
                    border2 = contentPadding2;
                } else {
                    restartGroup.skipToGroupEnd();
                    i46 = leadingIcon;
                    i2 = trailingIcon;
                    field = colors;
                    isError2 = contentPadding;
                    composableLambda = border;
                    composer3 = restartGroup;
                    $dirty = $dirty13;
                    border2 = $dirty1;
                    z2 = field2;
                    obj = obj9;
                    isError3 = placeholder;
                    shape2 = shape;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = $dirty;
            endRestartGroup = new TextFieldDefaults.OutlinedTextFieldDecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z2, obj, isError3, i46, i2, shape2, field, isError2, composableLambda, $changed, $changed1, i45);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty5 = $dirty;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final void TextFieldDecorationBox(String value, Function2 innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Composer $composer, int $changed, int $changed1, int i17) {
        boolean traceInProgress;
        Object endRestartGroup;
        int defaultsInvalid;
        int $dirty2;
        androidx.compose.material.TextFieldDefaults $dirty12;
        Object obj;
        Object obj12;
        Object obj6;
        Object obj5;
        Object obj3;
        int changed;
        int contentPadding2;
        PaddingValues textFieldWithLabelPadding-a9UjIt4$default;
        int textFieldColors-dx8h9Zs;
        int i12;
        boolean traceInProgress2;
        int $dirty3;
        int $dirty;
        boolean z;
        Object obj7;
        int $dirty4;
        int $dirty13;
        int i42;
        Object colors2;
        androidx.compose.material.TextFieldColors field;
        Object obj9;
        boolean label2;
        int i22;
        Object $dirty1;
        boolean i23;
        Object placeholder2;
        int i39;
        int i;
        Object obj10;
        int leadingIcon2;
        int i20;
        int trailingIcon2;
        int i5;
        Object obj4;
        int obj8;
        int i4;
        boolean z2;
        Object obj11;
        PaddingValues obj13;
        int i43;
        Composer restartGroup;
        int i40;
        int i6;
        int i33;
        int i46;
        int i37;
        int i31;
        int i19;
        int i41;
        int i3;
        int i44;
        int changed2;
        int i38;
        int i21;
        int i28;
        int i24;
        int i30;
        int i2;
        int i45;
        boolean changedInstance;
        int i25;
        int i32;
        int i34;
        int i26;
        int i7;
        int i10;
        int i15;
        int i8;
        Composer composer2;
        Composer composer;
        int i29;
        int i9;
        int i13;
        int i11;
        boolean z3;
        Object obj2;
        int i35;
        int i27;
        int i14;
        int i16;
        int i36;
        int i18;
        ScopeUpdateScope scopeUpdateScope;
        int obj64;
        int i53 = $changed;
        textFieldColors-dx8h9Zs = $changed1;
        $dirty3 = i17;
        restartGroup = $composer.startRestartGroup(1171040065);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)714@32930L17,733@33577L14,721@33156L508:TextFieldDefaults.kt#jmzs0o");
        $dirty4 = $changed;
        $dirty13 = $changed1;
        if ($dirty3 & 1 != 0) {
            $dirty4 |= 6;
            colors2 = value;
        } else {
            if (i53 & 6 == 0) {
                i = restartGroup.changed(value) ? 4 : 2;
                $dirty4 |= i;
            } else {
                colors2 = value;
            }
        }
        if ($dirty3 & 2 != 0) {
            $dirty4 |= 48;
            obj10 = innerTextField;
        } else {
            if (i53 & 48 == 0) {
                i4 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty4 |= i4;
            } else {
                obj10 = innerTextField;
            }
        }
        if ($dirty3 & 4 != 0) {
            $dirty4 |= 384;
            z2 = enabled;
        } else {
            if (i53 & 384 == 0) {
                i6 = restartGroup.changed(enabled) ? 256 : i40;
                $dirty4 |= i6;
            } else {
                z2 = enabled;
            }
        }
        i33 = $dirty3 & 8;
        int i111 = 2048;
        if (i33 != 0) {
            $dirty4 |= 3072;
            z = singleLine;
        } else {
            if (i53 & 3072 == 0) {
                i31 = restartGroup.changed(singleLine) ? i111 : i46;
                $dirty4 |= i31;
            } else {
                z = singleLine;
            }
        }
        if ($dirty3 & 16 != 0) {
            $dirty4 |= 24576;
            obj9 = visualTransformation;
        } else {
            if (i53 & 24576 == 0) {
                i19 = restartGroup.changed(visualTransformation) ? 16384 : 8192;
                $dirty4 |= i19;
            } else {
                obj9 = visualTransformation;
            }
        }
        int i113 = 196608;
        if ($dirty3 & 32 != 0) {
            $dirty4 |= i113;
            obj7 = interactionSource;
        } else {
            if (i53 & i113 == 0) {
                i41 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty4 |= i41;
            } else {
                obj7 = interactionSource;
            }
        }
        i3 = $dirty3 & 64;
        i44 = 1572864;
        if (i3 != 0) {
            $dirty4 |= i44;
            i23 = isError;
        } else {
            if (i53 & i44 == 0) {
                i38 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty4 |= i38;
            } else {
                i23 = isError;
            }
        }
        int i107 = $dirty3 & 128;
        i21 = 12582912;
        if (i107 != 0) {
            $dirty4 |= i21;
            obj4 = label;
        } else {
            if (i53 & i21 == 0) {
                i28 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty4 |= i28;
            } else {
                obj4 = label;
            }
        }
        i43 = $dirty3 & 256;
        i24 = 100663296;
        if (i43 != 0) {
            $dirty4 |= i24;
            obj = placeholder;
        } else {
            if (i53 & i24 == 0) {
                i24 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty4 |= i24;
            } else {
                obj = placeholder;
            }
        }
        int i54 = $dirty3 & 512;
        int i116 = 805306368;
        if (i54 != 0) {
            $dirty4 |= i116;
            i30 = i54;
            obj12 = leadingIcon;
        } else {
            if ($changed & i116 == 0) {
                i30 = i54;
                i2 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty4 |= i2;
            } else {
                i30 = i54;
                obj12 = leadingIcon;
            }
        }
        int i55 = $dirty3 & 1024;
        if (i55 != 0) {
            $dirty13 |= 6;
            i45 = i55;
            obj6 = trailingIcon;
        } else {
            if (textFieldColors-dx8h9Zs & 6 == 0) {
                i45 = i55;
                i44 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty13 |= i44;
            } else {
                i45 = i55;
                obj6 = trailingIcon;
            }
        }
        if (textFieldColors-dx8h9Zs & 48 == 0) {
            if ($dirty3 & 2048 == 0) {
                i38 = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj5 = colors;
            }
            $dirty13 |= i38;
        } else {
            obj5 = colors;
        }
        if (textFieldColors-dx8h9Zs & 384 == 0) {
            if ($dirty3 & 4096 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    i40 = 256;
                }
            } else {
                obj3 = contentPadding;
            }
            $dirty13 |= i40;
        } else {
            obj3 = contentPadding;
        }
        if ($dirty3 & 8192 != 0) {
            $dirty13 |= 3072;
        } else {
            if (textFieldColors-dx8h9Zs & 3072 == 0 && restartGroup.changed(this)) {
                if (restartGroup.changed(obj14)) {
                    i46 = i111;
                }
                $dirty13 |= i46;
            }
        }
        contentPadding2 = $dirty13;
        if ($dirty15 &= $dirty4 == 306783378 && contentPadding2 & 1171 == 1170) {
            if (contentPadding2 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            z3 = i3 != 0 ? defaultsInvalid : i23;
                            obj2 = i107 != 0 ? defaultsInvalid : obj4;
                            i35 = i43 != 0 ? defaultsInvalid : placeholder;
                            i27 = i30 != 0 ? defaultsInvalid : leadingIcon;
                            i14 = i45 != 0 ? defaultsInvalid : trailingIcon;
                            if ($dirty3 & 2048 != 0) {
                                composer = restartGroup;
                                i16 = i129;
                                i18 = i49;
                                $dirty2 = i17;
                                restartGroup = composer;
                                i22 = contentPadding2;
                                field = textFieldColors-dx8h9Zs;
                            } else {
                                $dirty2 = $dirty3;
                                i18 = $dirty4;
                                i22 = obj64;
                                field = colors;
                            }
                            if ($dirty2 & 4096 != 0) {
                                if (obj2 == null) {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithoutLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                } else {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                }
                                obj13 = textFieldWithLabelPadding-a9UjIt4$default;
                                contentPadding2 = textFieldColors-dx8h9Zs;
                                obj11 = field;
                                colors2 = z3;
                                $dirty1 = obj2;
                                i39 = i35;
                                i20 = i27;
                                i5 = i14;
                            } else {
                                $dirty12 = this;
                                obj13 = contentPadding;
                                obj11 = field;
                                contentPadding2 = i22;
                                colors2 = z3;
                                $dirty1 = obj2;
                                i39 = i35;
                                i20 = i27;
                                i5 = i14;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if ($dirty3 & 2048 != 0) {
                                contentPadding2 &= -113;
                            }
                            if ($dirty3 & 4096 != 0) {
                                i20 = leadingIcon;
                                i5 = trailingIcon;
                                obj11 = colors;
                                obj13 = contentPadding;
                                contentPadding2 = i52;
                                i18 = $dirty4;
                                colors2 = i23;
                                $dirty1 = obj4;
                                $dirty12 = this;
                                i39 = placeholder;
                            } else {
                                $dirty12 = this;
                                i20 = leadingIcon;
                                i5 = trailingIcon;
                                obj11 = colors;
                                obj13 = contentPadding;
                                i18 = $dirty4;
                                colors2 = i23;
                                $dirty1 = obj4;
                                i39 = placeholder;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i18, contentPadding2, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:721)");
                    } else {
                        $dirty = i18;
                    }
                    i37 = contentPadding2;
                    i36 = $dirty;
                    $dirty12.TextFieldDecorationBox(value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, colors2, $dirty1, i39, i20, i5, $dirty12.getTextFieldShape(restartGroup, i63 &= 14), obj11, obj13, restartGroup, i73 | i92, i76 | i98, 0);
                    composer2 = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj8 = i5;
                    trailingIcon2 = i20;
                    leadingIcon2 = i39;
                    placeholder2 = $dirty1;
                    label2 = colors2;
                } else {
                    restartGroup.skipToGroupEnd();
                    leadingIcon2 = placeholder;
                    trailingIcon2 = leadingIcon;
                    obj11 = colors;
                    obj13 = contentPadding;
                    i37 = contentPadding2;
                    i36 = $dirty4;
                    label2 = i23;
                    placeholder2 = obj4;
                    composer2 = restartGroup;
                    obj8 = trailingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldDefaults.TextFieldDecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, label2, placeholder2, leadingIcon2, trailingIcon2, obj8, obj11, obj13, $changed, $changed1, i17);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final void TextFieldDecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Composer $composer, int $changed, int $changed1, int i18) {
        Object obj3;
        Object obj10;
        Object obj7;
        Object obj5;
        Object i38;
        Object obj4;
        int changed;
        int contentPadding2;
        int defaultsInvalid;
        boolean isError4;
        int isError3;
        PaddingValues textFieldWithLabelPadding-a9UjIt4$default;
        Object endRestartGroup;
        Object traceInProgress;
        boolean traceInProgress2;
        int i34;
        int textFieldColors-dx8h9Zs;
        int $dirty2;
        int textFieldShape;
        int i24;
        boolean z;
        Object obj8;
        Composer restartGroup;
        int $dirty4;
        int $dirty16;
        Object obj9;
        boolean z4;
        Object obj6;
        Object obj;
        boolean $dirty6;
        int i21;
        int i7;
        Object obj2;
        int i5;
        int i39;
        int $dirty17;
        Object obj12;
        Shape shape3;
        int i27;
        boolean z2;
        androidx.compose.material.TextFieldColors field;
        boolean z3;
        int i20;
        PaddingValues isError2;
        int $dirty12;
        int i42;
        Object i3;
        int $dirty3;
        androidx.compose.material.TextFieldColors i22;
        int i28;
        int colors2;
        int i8;
        int i9;
        int i26;
        int i15;
        int i23;
        Composer composer2;
        int $dirty7;
        int i32;
        int changed2;
        int i19;
        int i31;
        int $dirty14;
        int i16;
        int i36;
        int i41;
        int i17;
        boolean changedInstance;
        int $dirty13;
        int i30;
        int i2;
        int i25;
        int $dirty18;
        int i10;
        int i37;
        int i33;
        int $dirty15;
        int i29;
        int i6;
        int i43;
        int $dirty1;
        int i;
        Composer composer;
        int i11;
        int $dirty5;
        int $dirty;
        int i4;
        int i12;
        Object obj11;
        int i44;
        int i35;
        int i45;
        Shape shape2;
        int i13;
        int i40;
        int i46;
        int i14;
        ScopeUpdateScope scopeUpdateScope;
        androidx.compose.material.TextFieldDefaults obj67;
        int obj68;
        int obj69;
        int obj70;
        int obj71;
        int obj72;
        int obj73;
        boolean obj75;
        traceInProgress = this;
        int i47 = $changed;
        int i78 = $changed1;
        i24 = i18;
        restartGroup = $composer.startRestartGroup(-1391531252);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldDecorationBox)P(12,3,2,10,13,4,5,6,8,7,11,9)573@25758L14,574@25808L17,582@26042L624:TextFieldDefaults.kt#jmzs0o");
        $dirty4 = $changed;
        $dirty16 = $changed1;
        if (i24 & 1 != 0) {
            $dirty4 |= 6;
            obj9 = value;
        } else {
            if (i47 & 6 == 0) {
                i7 = restartGroup.changed(value) ? 4 : 2;
                $dirty4 |= i7;
            } else {
                obj9 = value;
            }
        }
        if (i24 & 2 != 0) {
            $dirty4 |= 48;
            obj2 = innerTextField;
        } else {
            if (i47 & 48 == 0) {
                i27 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty4 |= i27;
            } else {
                obj2 = innerTextField;
            }
        }
        if (i24 & 4 != 0) {
            $dirty4 |= 384;
            z2 = enabled;
        } else {
            if (i47 & 384 == 0) {
                i42 = restartGroup.changed(enabled) ? 256 : $dirty12;
                $dirty4 |= i42;
            } else {
                z2 = enabled;
            }
        }
        i3 = i24 & 8;
        i28 = 2048;
        if (i3 != 0) {
            $dirty4 |= 3072;
            z = singleLine;
        } else {
            if (i47 & 3072 == 0) {
                i8 = restartGroup.changed(singleLine) ? i28 : $dirty3;
                $dirty4 |= i8;
            } else {
                z = singleLine;
            }
        }
        $dirty7 = 8192;
        if (i24 & 16 != 0) {
            $dirty4 |= 24576;
            obj6 = visualTransformation;
        } else {
            if (i47 & 24576 == 0) {
                i9 = restartGroup.changed(visualTransformation) ? i23 : $dirty7;
                $dirty4 |= i9;
            } else {
                obj6 = visualTransformation;
            }
        }
        final int i144 = 196608;
        if (i24 & 32 != 0) {
            $dirty4 |= i144;
            obj8 = interactionSource;
        } else {
            if (i47 & i144 == 0) {
                i26 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty4 |= i26;
            } else {
                obj8 = interactionSource;
            }
        }
        i15 = i24 & 64;
        i32 = 1572864;
        if (i15 != 0) {
            $dirty4 |= i32;
            $dirty6 = isError;
        } else {
            if (i47 & i32 == 0) {
                i19 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty4 |= i19;
            } else {
                $dirty6 = isError;
            }
        }
        $dirty17 = i24 & 128;
        i31 = 12582912;
        if ($dirty17 != 0) {
            $dirty4 |= i31;
            obj12 = label;
        } else {
            if (i47 & i31 == 0) {
                $dirty14 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty4 |= $dirty14;
            } else {
                obj12 = label;
            }
        }
        i20 = i24 & 256;
        i16 = 100663296;
        if (i20 != 0) {
            $dirty4 |= i16;
            obj3 = placeholder;
        } else {
            if (i47 & i16 == 0) {
                i16 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty4 |= i16;
            } else {
                obj3 = placeholder;
            }
        }
        int i48 = i24 & 512;
        int i131 = 805306368;
        if (i48 != 0) {
            $dirty4 |= i131;
            i36 = i48;
            obj10 = leadingIcon;
        } else {
            if ($changed & i131 == 0) {
                i36 = i48;
                i41 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty4 |= i41;
            } else {
                i36 = i48;
                obj10 = leadingIcon;
            }
        }
        int i49 = i24 & 1024;
        if (i49 != 0) {
            $dirty16 |= 6;
            i17 = i49;
            obj7 = trailingIcon;
        } else {
            if (i78 & 6 == 0) {
                i17 = i49;
                i32 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty16 |= i32;
            } else {
                i17 = i49;
                obj7 = trailingIcon;
            }
        }
        if (i78 & 48 == 0) {
            if (i24 & 2048 == 0) {
                i19 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj5 = shape;
            }
            $dirty16 |= i19;
        } else {
            obj5 = shape;
        }
        if (i78 & 384 == 0) {
            if (i24 & 4096 == 0) {
                if (restartGroup.changed(colors)) {
                    $dirty12 = 256;
                }
            } else {
                i38 = colors;
            }
            $dirty16 |= $dirty12;
        } else {
            i38 = colors;
        }
        if (i78 & 3072 == 0) {
            if (i24 & 8192 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    $dirty3 = i28;
                }
            } else {
                obj4 = contentPadding;
            }
            $dirty16 |= $dirty3;
        } else {
            obj4 = contentPadding;
        }
        if (i24 & 16384 != 0) {
            $dirty16 |= 24576;
        } else {
            if (i78 & 24576 == 0) {
                if (restartGroup.changed(traceInProgress)) {
                } else {
                    i23 = $dirty7;
                }
                $dirty16 |= i23;
            }
        }
        if (i53 &= $dirty4 == 306783378 && $dirty16 & 9363 == 9362) {
            if ($dirty16 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            isError4 = i15 != 0 ? 0 : $dirty6;
                            obj11 = $dirty17 != 0 ? textFieldColors-dx8h9Zs : obj12;
                            i44 = i20 != 0 ? textFieldColors-dx8h9Zs : placeholder;
                            i35 = i36 != 0 ? textFieldColors-dx8h9Zs : leadingIcon;
                            i45 = i17 != 0 ? textFieldColors-dx8h9Zs : trailingIcon;
                            if (i24 & 2048 != 0) {
                                $dirty16 &= -113;
                                shape2 = textFieldShape;
                            } else {
                                shape2 = shape;
                            }
                            if (i24 & 4096 != 0) {
                                Composer composer3 = restartGroup;
                                obj12 = i119;
                                i20 = obj12;
                                i28 = i125;
                                changed2 = i28;
                                composer = composer3;
                                i31 = i128;
                                i36 = i31;
                                changedInstance = i36;
                                i30 = changedInstance;
                                i25 = i30;
                                i10 = i25;
                                i33 = i10;
                                i29 = i33;
                                i43 = i29;
                                i = i43;
                                i40 = i142;
                                obj75 = isError4;
                                i14 = i46;
                                textFieldColors-dx8h9Zs = traceInProgress.textFieldColors-dx8h9Zs(0, i24, 0, restartGroup, 0, $dirty16, 0, obj6, 0, obj2, 0, obj12, 0, i20, 0, i3, 0, i28, 0, composer3, 0, changed2, 0, i31, 0, i36);
                                composer2 = composer;
                                $dirty16 = isError3 & -897;
                            } else {
                                obj75 = isError4;
                                composer2 = restartGroup;
                                i14 = $dirty4;
                                isError3 = $dirty16;
                                textFieldColors-dx8h9Zs = colors;
                            }
                            if (i24 & 8192 != 0) {
                                if (obj11 == null) {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithoutLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                } else {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                }
                                z3 = obj75;
                                i3 = textFieldWithLabelPadding-a9UjIt4$default;
                                contentPadding2 = traceInProgress;
                                i22 = textFieldColors-dx8h9Zs;
                                obj = obj11;
                                i21 = i44;
                                i5 = i35;
                                i39 = i45;
                                $dirty3 = shape2;
                            } else {
                                i3 = contentPadding;
                                z3 = obj75;
                                i22 = textFieldColors-dx8h9Zs;
                                contentPadding2 = $dirty16;
                                obj = obj11;
                                i21 = i44;
                                i5 = i35;
                                i39 = i45;
                                $dirty3 = shape2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i24 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            if (i24 & 4096 != 0) {
                                $dirty16 &= -897;
                            }
                            if (i24 & 8192 != 0) {
                                contentPadding2 = $dirty16 & -7169;
                                i5 = leadingIcon;
                                i39 = trailingIcon;
                                $dirty3 = shape;
                                i22 = colors;
                                i3 = contentPadding;
                                composer2 = restartGroup;
                                i14 = $dirty4;
                                z3 = $dirty6;
                                obj = obj12;
                                i21 = placeholder;
                            } else {
                                i5 = leadingIcon;
                                i39 = trailingIcon;
                                $dirty3 = shape;
                                i22 = colors;
                                i3 = contentPadding;
                                composer2 = restartGroup;
                                i14 = $dirty4;
                                contentPadding2 = $dirty16;
                                z3 = $dirty6;
                                obj = obj12;
                                i21 = placeholder;
                            }
                        }
                    } else {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1391531252, i14, contentPadding2, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:581)");
                    } else {
                        $dirty2 = i14;
                    }
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, obj, i21, i5, i39, singleLine, enabled, z3, interactionSource, i3, $dirty3, i22, 0, composer2, i71 | i100, i77 | obj8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    isError2 = i3;
                    shape3 = $dirty3;
                    field = i22;
                    colors2 = contentPadding2;
                } else {
                    restartGroup.skipToGroupEnd();
                    i5 = leadingIcon;
                    i39 = trailingIcon;
                    field = colors;
                    isError2 = contentPadding;
                    composer2 = restartGroup;
                    $dirty2 = $dirty4;
                    colors2 = $dirty16;
                    z4 = $dirty6;
                    obj = obj12;
                    i21 = placeholder;
                    shape3 = shape;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            endRestartGroup = new TextFieldDefaults.TextFieldDecorationBox.1(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z4, obj, i21, i5, i39, shape3, field, isError2, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty = $dirty2;
        }
    }

    public final float getFocusedBorderThickness-D9Ej5fM() {
        return TextFieldDefaults.FocusedBorderThickness;
    }

    public final float getMinHeight-D9Ej5fM() {
        return TextFieldDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return TextFieldDefaults.MinWidth;
    }

    public final Shape getOutlinedTextFieldShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1899109048;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C242@8708L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:242)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Shape)MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall();
    }

    public final Shape getTextFieldShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1117199624;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C233@8406L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:233)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Shape)CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall(), 0, 0, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, 0);
    }

    public final float getUnfocusedBorderThickness-D9Ej5fM() {
        return TextFieldDefaults.UnfocusedBorderThickness;
    }

    public final Modifier indicatorLine-gv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, boolean enabled, boolean isError, InteractionSource interactionSource, androidx.compose.material.TextFieldColors colors, float focusedIndicatorLineThickness, float unfocusedIndicatorLineThickness) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        boolean z;
        boolean z2;
        InteractionSource interactionSource2;
        androidx.compose.material.TextFieldColors field;
        float f;
        float f2;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new TextFieldDefaults.indicatorLine-gv0btCI$$inlined.debugInspectorInfo.1(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        TextFieldDefaults.indicatorLine.2 anon = new TextFieldDefaults.indicatorLine.2(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness);
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, noInspectorInfo, (Function3)anon);
    }

    public final androidx.compose.material.TextFieldColors outlinedTextFieldColors-dx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i26) {
        int disabled3;
        boolean traceInProgress;
        int copy-wmQWz5c$default3;
        int iNSTANCE;
        int companion;
        int colors5;
        int colors;
        int high2;
        int disabled2;
        int disabled6;
        androidx.compose.material.Colors colors4;
        int i28;
        float disabled;
        int i13;
        int disabled4;
        int colors2;
        int high;
        int medium2;
        int disabled5;
        int colors3;
        int medium;
        int copy-wmQWz5c$default2;
        int i20;
        int i35;
        int i22;
        int i7;
        long l3;
        Object consume2;
        String copy-wmQWz5c$default;
        Object consume;
        long l;
        long unbox-impl;
        long transparent-0d7_KjU;
        long cursorColor2;
        float floatValue;
        int i9;
        long errorCursorColor2;
        int i32;
        int i10;
        long focusedBorderColor2;
        int i12;
        int i19;
        long unfocusedBorderColor3;
        long errorBorderColor2;
        int i14;
        int i11;
        long unfocusedBorderColor2;
        int i31;
        int i;
        long l4;
        int i3;
        long leadingIconColor4;
        long leadingIconColor2;
        int i33;
        long leadingIconColor3;
        int i15;
        int i4;
        long errorLeadingIconColor2;
        int i34;
        long trailingIconColor4;
        long trailingIconColor2;
        int i18;
        long trailingIconColor3;
        int i21;
        int i17;
        long errorTrailingIconColor2;
        int i16;
        long l2;
        long focusedLabelColor2;
        int i25;
        long unfocusedLabelColor4;
        long unfocusedLabelColor2;
        int i29;
        int i8;
        long unfocusedLabelColor3;
        int i6;
        int i5;
        long errorLabelColor2;
        int i27;
        long placeholderColor2;
        int i23;
        long l5;
        int i2;
        int i30;
        int i24;
        long obj53;
        float obj55;
        int obj56;
        int obj57;
        int obj58;
        int obj59;
        int obj60;
        final Composer composer = obj95;
        int i36 = obj99;
        int i37 = 1762667317;
        ComposerKt.sourceInformationMarkerStart(composer, i37, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)453@18100L7,453@18131L7,454@18204L8,456@18310L6,457@18374L6,459@18450L6,459@18491L4,461@18562L6,461@18605L8,462@18700L8,463@18759L6,465@18833L6,466@18962L8,469@19091L6,470@19222L8,471@19287L6,473@19362L6,473@19403L4,474@19461L6,474@19496L6,475@19579L8,476@19637L6,477@19699L6,477@19734L6,478@19820L8:TextFieldDefaults.kt#jmzs0o");
        if (i36 & 1 != 0) {
            int i45 = 6;
            int i46 = 0;
            int i48 = 2023513938;
            copy-wmQWz5c$default = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i48, copy-wmQWz5c$default);
            ComposerKt.sourceInformationMarkerEnd(composer);
            i35 = 6;
            int i47 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i48, copy-wmQWz5c$default);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l3 = copy-wmQWz5c$default3;
        } else {
            l3 = textColor;
        }
        i22 = 6;
        if (i36 & 2 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = backgroundColor;
        }
        if (i36 & 4 != 0) {
            l2 = transparent-0d7_KjU;
        } else {
            l2 = errorCursorColor;
        }
        if (i36 & 8 != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i22).getPrimary-0d7_KjU();
        } else {
            cursorColor2 = unfocusedBorderColor;
        }
        if (i36 & 16 != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i22).getError-0d7_KjU();
        } else {
            errorCursorColor2 = errorBorderColor;
        }
        if (i36 & 32 != 0) {
            focusedBorderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i22).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i22), 0, 0, 0, 14);
        } else {
            focusedBorderColor2 = disabledLeadingIconColor;
        }
        if (i36 & 64 != 0) {
            unfocusedBorderColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i22).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i22), 0, 0, 0, 14);
        } else {
            unfocusedBorderColor3 = trailingIconColor;
        }
        if (i36 & 128 != 0) {
            obj53 = unfocusedBorderColor3;
            unfocusedBorderColor2 = obj53;
            l4 = unfocusedBorderColor3;
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor3;
            l4 = errorTrailingIconColor;
        }
        if (i36 & 256 != 0) {
            errorBorderColor2 = MaterialTheme.INSTANCE.getColors(composer, i22).getError-0d7_KjU();
        } else {
            errorBorderColor2 = unfocusedLabelColor;
        }
        if (i36 & 512 != 0) {
            leadingIconColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i22).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconColor4 = errorLabelColor;
        }
        if (i36 & 1024 != 0) {
            obj53 = leadingIconColor4;
            leadingIconColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i22), 0, 0, 0, 14);
            leadingIconColor3 = obj53;
        } else {
            leadingIconColor3 = leadingIconColor4;
            leadingIconColor2 = disabledPlaceholderColor;
        }
        errorLeadingIconColor2 = i36 & 2048 != 0 ? leadingIconColor3 : $changed;
        if (i36 & 4096 != 0) {
            trailingIconColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i22).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor4 = $changed2;
        }
        if (i36 & 8192 != 0) {
            obj53 = trailingIconColor4;
            trailingIconColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i22), 0, 0, 0, 14);
            trailingIconColor3 = obj53;
        } else {
            trailingIconColor3 = trailingIconColor4;
            trailingIconColor2 = obj79;
        }
        if (i36 & 16384 != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, i22).getError-0d7_KjU();
        } else {
            errorTrailingIconColor2 = obj81;
        }
        if (i39 &= i36 != 0) {
            focusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i22).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i22), 0, 0, 0, 14);
        } else {
            focusedLabelColor2 = obj83;
        }
        if (i40 &= i36 != 0) {
            unfocusedLabelColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i22).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i22), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor4 = obj85;
        }
        if (i41 &= i36 != 0) {
            obj53 = unfocusedLabelColor4;
            unfocusedLabelColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i22), 0, 0, 0, 14);
            unfocusedLabelColor3 = obj53;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor4;
            unfocusedLabelColor2 = obj87;
        }
        if (i42 &= i36 != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, i22).getError-0d7_KjU();
        } else {
            errorLabelColor2 = obj89;
        }
        if (i43 &= i36 != 0) {
            placeholderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i22).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i22), 0, 0, 0, 14);
        } else {
            placeholderColor2 = obj91;
        }
        if (i36 &= copy-wmQWz5c$default2 != 0) {
            l5 = copy-wmQWz5c$default2;
        } else {
            l5 = obj93;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i37, obj96, obj97, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:480)");
        } else {
            i20 = obj96;
            i7 = obj97;
        }
        long l7 = l3;
        DefaultTextFieldColors textColor2 = new DefaultTextFieldColors(l7, copy-wmQWz5c$default, l, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i32, focusedBorderColor2, i12, unfocusedBorderColor2, i14, errorBorderColor2, i31, l4, i3, leadingIconColor3, obj23, leadingIconColor2, i15, errorLeadingIconColor2, i34, trailingIconColor3, obj29, trailingIconColor2, i21, errorTrailingIconColor2, i16, l2, obj35, focusedLabelColor2, obj37, unfocusedLabelColor3, i29, unfocusedLabelColor2, i6, errorLabelColor2, i27, placeholderColor2, obj45, l5, i2, 0);
        long l6 = l7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (TextFieldColors)textColor2;
    }

    public final PaddingValues outlinedTextFieldPadding-a9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.PaddingValues-a9UjIt4(start, top, end, bottom);
    }

    public final androidx.compose.material.TextFieldColors textFieldColors-dx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i26) {
        int disabled2;
        boolean traceInProgress;
        int copy-wmQWz5c$default;
        int iNSTANCE;
        int colors;
        int colors5;
        int colors6;
        int high2;
        int i24;
        int disabled5;
        androidx.compose.material.Colors colors3;
        int i10;
        float disabled3;
        int i11;
        int disabled4;
        int colors4;
        int high;
        int medium;
        int disabled;
        int colors2;
        int medium2;
        int copy-wmQWz5c$default3;
        int i27;
        int i14;
        int i34;
        int i2;
        long l;
        Object consume;
        String copy-wmQWz5c$default4;
        Object consume2;
        long l4;
        long unbox-impl;
        long copy-wmQWz5c$default2;
        long cursorColor2;
        float floatValue;
        int i28;
        long errorCursorColor2;
        int i35;
        int i13;
        long focusedIndicatorColor2;
        int i3;
        int i29;
        long unfocusedIndicatorColor3;
        long errorIndicatorColor2;
        int i25;
        int i20;
        long unfocusedIndicatorColor2;
        int i36;
        int i21;
        long l2;
        int i30;
        long leadingIconColor3;
        long leadingIconColor2;
        int i4;
        long leadingIconColor4;
        int i31;
        int i18;
        long errorLeadingIconColor2;
        int i19;
        long trailingIconColor4;
        long trailingIconColor3;
        int i7;
        long trailingIconColor2;
        int i17;
        int i12;
        long errorTrailingIconColor2;
        int i8;
        long l3;
        long focusedLabelColor2;
        int i32;
        long unfocusedLabelColor2;
        long unfocusedLabelColor3;
        int i33;
        int i6;
        long unfocusedLabelColor4;
        int i22;
        int i16;
        long errorLabelColor2;
        int i9;
        long placeholderColor2;
        int i15;
        long l5;
        int i23;
        int i5;
        int i;
        long obj53;
        float obj55;
        int obj56;
        int obj57;
        int obj58;
        int obj59;
        int obj60;
        final Composer composer = obj95;
        int i37 = obj99;
        int i38 = 231892599;
        ComposerKt.sourceInformationMarkerStart(composer, i38, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)395@14784L7,395@14815L7,396@14888L8,397@14946L6,398@15039L6,399@15103L6,401@15182L6,401@15223L4,403@15297L6,404@15449L8,405@15511L6,407@15585L6,408@15714L8,411@15843L6,412@15974L8,413@16039L6,415@16114L6,415@16155L4,416@16213L6,416@16248L6,417@16331L8,418@16389L6,419@16451L6,419@16486L6,420@16572L8:TextFieldDefaults.kt#jmzs0o");
        if (i37 & 1 != 0) {
            int i46 = 6;
            int i47 = 0;
            int i49 = 2023513938;
            copy-wmQWz5c$default4 = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i49, copy-wmQWz5c$default4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            i14 = 6;
            int i48 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i49, copy-wmQWz5c$default4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l = copy-wmQWz5c$default;
        } else {
            l = textColor;
        }
        i34 = 6;
        if (i37 & 2 != 0) {
            l4 = copy-wmQWz5c$default4;
        } else {
            l4 = backgroundColor;
        }
        if (i37 & 4 != 0) {
            l3 = copy-wmQWz5c$default2;
        } else {
            l3 = errorCursorColor;
        }
        if (i37 & 8 != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i34).getPrimary-0d7_KjU();
        } else {
            cursorColor2 = unfocusedIndicatorColor;
        }
        if (i37 & 16 != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i34).getError-0d7_KjU();
        } else {
            errorCursorColor2 = errorIndicatorColor;
        }
        if (i37 & 32 != 0) {
            focusedIndicatorColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i34).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i34), 0, 0, 0, 14);
        } else {
            focusedIndicatorColor2 = disabledLeadingIconColor;
        }
        if (i37 & 64 != 0) {
            unfocusedIndicatorColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i34).getOnSurface-0d7_KjU(), disabledTextColor, 1054280253, 0, 0, 0, 14);
        } else {
            unfocusedIndicatorColor3 = trailingIconColor;
        }
        if (i37 & 128 != 0) {
            obj53 = unfocusedIndicatorColor3;
            unfocusedIndicatorColor2 = obj53;
            l2 = unfocusedIndicatorColor3;
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor3;
            l2 = errorTrailingIconColor;
        }
        if (i37 & 256 != 0) {
            errorIndicatorColor2 = MaterialTheme.INSTANCE.getColors(composer, i34).getError-0d7_KjU();
        } else {
            errorIndicatorColor2 = unfocusedLabelColor;
        }
        if (i37 & 512 != 0) {
            leadingIconColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i34).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconColor3 = errorLabelColor;
        }
        if (i37 & 1024 != 0) {
            obj53 = leadingIconColor3;
            leadingIconColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i34), 0, 0, 0, 14);
            leadingIconColor4 = obj53;
        } else {
            leadingIconColor4 = leadingIconColor3;
            leadingIconColor2 = disabledPlaceholderColor;
        }
        errorLeadingIconColor2 = i37 & 2048 != 0 ? leadingIconColor4 : $changed;
        if (i37 & 4096 != 0) {
            trailingIconColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i34).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor4 = $changed2;
        }
        if (i37 & 8192 != 0) {
            obj53 = trailingIconColor4;
            trailingIconColor3 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i34), 0, 0, 0, 14);
            trailingIconColor2 = obj53;
        } else {
            trailingIconColor2 = trailingIconColor4;
            trailingIconColor3 = obj79;
        }
        if (i37 & 16384 != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, i34).getError-0d7_KjU();
        } else {
            errorTrailingIconColor2 = obj81;
        }
        if (i40 &= i37 != 0) {
            focusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i34).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i34), 0, 0, 0, 14);
        } else {
            focusedLabelColor2 = obj83;
        }
        if (i41 &= i37 != 0) {
            unfocusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i34).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i34), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor2 = obj85;
        }
        if (i42 &= i37 != 0) {
            obj53 = unfocusedLabelColor2;
            unfocusedLabelColor3 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i34), 0, 0, 0, 14);
            unfocusedLabelColor4 = obj53;
        } else {
            unfocusedLabelColor4 = unfocusedLabelColor2;
            unfocusedLabelColor3 = obj87;
        }
        if (i43 &= i37 != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, i34).getError-0d7_KjU();
        } else {
            errorLabelColor2 = obj89;
        }
        if (i44 &= i37 != 0) {
            placeholderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i34).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i34), 0, 0, 0, 14);
        } else {
            placeholderColor2 = obj91;
        }
        if (i37 &= copy-wmQWz5c$default3 != 0) {
            l5 = copy-wmQWz5c$default3;
        } else {
            l5 = obj93;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i38, obj96, obj97, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:422)");
        } else {
            i27 = obj96;
            i2 = obj97;
        }
        long l7 = l;
        DefaultTextFieldColors textColor2 = new DefaultTextFieldColors(l7, copy-wmQWz5c$default4, l4, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i35, focusedIndicatorColor2, i3, unfocusedIndicatorColor2, i25, errorIndicatorColor2, i36, l2, i30, leadingIconColor4, obj23, leadingIconColor2, i31, errorLeadingIconColor2, i19, trailingIconColor2, obj29, trailingIconColor3, i17, errorTrailingIconColor2, i8, l3, obj35, focusedLabelColor2, obj37, unfocusedLabelColor4, i33, unfocusedLabelColor3, i22, errorLabelColor2, i9, placeholderColor2, obj45, l5, i23, 0);
        long l6 = l7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (TextFieldColors)textColor2;
    }

    public final PaddingValues textFieldWithLabelPadding-a9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.PaddingValues-a9UjIt4(start, top, end, bottom);
    }

    public final PaddingValues textFieldWithoutLabelPadding-a9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.PaddingValues-a9UjIt4(start, top, end, bottom);
    }
}
