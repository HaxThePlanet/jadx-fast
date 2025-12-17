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
        float f2;
        float f;
        float obj14;
        f2 = i9 & 16 != 0 ? obj14 : f7;
        f = i9 & 32 != 0 ? obj14 : f8;
        return textFieldDefaults.indicatorLine-gv0btCI(modifier2, z3, z4, interactionSource5, textFieldColors6, f2, f);
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
        int i3;
        int i;
        int i5;
        int i6;
        Object outlinedTextFieldShape;
        Object obj3;
        int changed;
        float focusedBorderThickness2;
        boolean traceInProgress2;
        Object obj;
        int changed3;
        float unfocusedBorderThickness2;
        float f;
        int changed2;
        int i11;
        int skipping;
        int i4;
        int defaultsInvalid;
        int i2;
        float f2;
        boolean z2;
        Composer composer;
        boolean z;
        int i7;
        Object obj2;
        Object i8;
        float f3;
        float f4;
        Composer composer2;
        int i9;
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
                i3 = traceInProgress.changed(enabled) ? 4 : 2;
                $dirty |= i3;
            } else {
                z2 = enabled;
            }
        }
        if (i40 & 2 != 0) {
            $dirty |= 48;
            z = isError;
        } else {
            if (i39 & 48 == 0) {
                i = traceInProgress.changed(isError) ? 32 : 16;
                $dirty |= i;
            } else {
                z = isError;
            }
        }
        if (i40 & 4 != 0) {
            $dirty |= 384;
            obj2 = interactionSource;
        } else {
            if (i39 & 384 == 0) {
                i5 = traceInProgress.changed(interactionSource) ? 256 : 128;
                $dirty |= i5;
            } else {
                obj2 = interactionSource;
            }
        }
        if (i40 & 8 != 0) {
            $dirty |= 3072;
            obj3 = colors;
        } else {
            if (i39 & 3072 == 0) {
                i6 = traceInProgress.changed(colors) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                obj3 = colors;
            }
        }
        if (i39 & 24576 == 0) {
            if (i40 & 16 == 0) {
                changed = traceInProgress.changed(shape) ? 16384 : 8192;
            } else {
                outlinedTextFieldShape = shape;
            }
            $dirty |= changed;
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
                changed2 = traceInProgress.changed(unfocusedBorderThickness) ? 1048576 : 524288;
            } else {
                unfocusedBorderThickness2 = unfocusedBorderThickness;
            }
            $dirty |= changed2;
        } else {
            unfocusedBorderThickness2 = unfocusedBorderThickness;
        }
        int i41 = 12582912;
        if (i40 & 128 != 0) {
            $dirty |= i41;
        } else {
            if (i39 & i41 == 0) {
                i11 = traceInProgress.changed(obj4) ? 8388608 : 4194304;
                $dirty |= i11;
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
                            f3 = focusedBorderThickness2;
                            f4 = unfocusedBorderThickness2;
                        } else {
                            f3 = focusedBorderThickness2;
                            f4 = unfocusedBorderThickness2;
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
                            f3 = focusedBorderThickness2;
                            f4 = unfocusedBorderThickness2;
                        } else {
                            f3 = focusedBorderThickness2;
                            f4 = unfocusedBorderThickness2;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, $dirty, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:335)");
                }
                composer2 = traceInProgress;
                BoxKt.Box(BorderKt.border((Modifier)Modifier.Companion, (BorderStroke)TextFieldDefaultsKt.access$animateBorderStrokeAsState-NuRrP5Q(z2, z, obj2, obj3, f3, f4, composer2, i16 | i27).getValue(), outlinedTextFieldShape), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f = f3;
                f2 = f4;
                i7 = $dirty;
                obj = outlinedTextFieldShape;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                f2 = unfocusedBorderThickness2;
                f = focusedBorderThickness2;
                i7 = $dirty;
                obj = outlinedTextFieldShape;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new TextFieldDefaults.BorderBox.1(obj4, enabled, isError, interactionSource, colors, obj, f, f2, i39, i40);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final void OutlinedTextFieldDecorationBox(String value, Function2 innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Function2 border, Composer $composer, int $changed, int $changed1, int i18) {
        boolean traceInProgress;
        Object endRestartGroup;
        int defaultsInvalid;
        boolean isError2;
        int isError3;
        Object $dirty13;
        Object obj14;
        Object obj11;
        Object obj16;
        Object obj2;
        Object obj4;
        Object obj9;
        int changed;
        String $dirty15;
        Object outlinedTextFieldPadding-a9UjIt4$default;
        Function2 rememberComposableLambda;
        boolean traceInProgress2;
        boolean i32;
        boolean $dirty9;
        int $dirty16;
        VisualTransformation i17;
        int i24;
        boolean z2;
        boolean $composer2;
        int $dirty18;
        boolean label2;
        Object $dirty3;
        Object $dirty8;
        int $dirty1;
        Object placeholder2;
        int i42;
        int $dirty12;
        int $dirty14;
        Object obj13;
        int leadingIcon2;
        int obj12;
        Object obj3;
        int trailingIcon2;
        int obj;
        boolean z;
        int i20;
        int i40;
        Object obj6;
        Object obj10;
        Object obj15;
        int $dirty6;
        Object obj5;
        Object obj7;
        int i4;
        Composer i11;
        int changedInstance;
        int $dirty;
        int i3;
        int i34;
        int i30;
        int i37;
        int i43;
        int i36;
        int i8;
        int $dirty11;
        int i21;
        int i14;
        boolean changed2;
        int i31;
        int $dirty5;
        int i22;
        int i28;
        int i44;
        int i33;
        int i23;
        int i27;
        boolean $dirty2;
        int i7;
        int i38;
        int i45;
        int i5;
        int $dirty7;
        int i29;
        int i15;
        int i6;
        int $dirty10;
        int i39;
        int i41;
        int i46;
        int $dirty17;
        int i12;
        Composer composer;
        Composer composer2;
        int i35;
        int i25;
        int i16;
        int i19;
        Object obj8;
        int i13;
        int i;
        int i2;
        int $dirty4;
        int i26;
        int i10;
        int i9;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj65;
        i32 = $changed;
        $dirty9 = $changed1;
        i17 = i18;
        $composer2 = $composer.startRestartGroup(-1280721485);
        ComposerKt.sourceInformation($composer2, "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)756@34416L25,758@34552L78,773@35068L22,761@34639L549:TextFieldDefaults.kt#jmzs0o");
        $dirty18 = $changed;
        $dirty1 = $changed1;
        if (i17 & 1 != 0) {
            $dirty18 |= 6;
            obj13 = value;
        } else {
            if (i32 & 6 == 0) {
                i40 = $composer2.changed(value) ? 4 : 2;
                $dirty18 |= i40;
            } else {
                obj13 = value;
            }
        }
        if (i17 & 2 != 0) {
            $dirty18 |= 48;
            obj6 = innerTextField;
        } else {
            if (i32 & 48 == 0) {
                i4 = $composer2.changedInstance(innerTextField) ? 32 : 16;
                $dirty18 |= i4;
            } else {
                obj6 = innerTextField;
            }
        }
        $dirty = 128;
        if (i17 & 4 != 0) {
            $dirty18 |= 384;
        } else {
            if (i32 & 384 == 0) {
                i24 = $composer2.changed(enabled) ? changedInstance : $dirty;
                $dirty18 |= i24;
            }
        }
        i30 = 2048;
        if (i17 & 8 != 0) {
            $dirty18 |= 3072;
            z2 = singleLine;
        } else {
            if (i32 & 3072 == 0) {
                i37 = $composer2.changed(singleLine) ? i30 : i3;
                $dirty18 |= i37;
            } else {
                z2 = singleLine;
            }
        }
        i21 = 8192;
        if (i17 & 16 != 0) {
            $dirty18 |= 24576;
            obj3 = visualTransformation;
        } else {
            if (i32 & 24576 == 0) {
                i43 = $composer2.changed(visualTransformation) ? $dirty11 : i21;
                $dirty18 |= i43;
            } else {
                obj3 = visualTransformation;
            }
        }
        int i116 = 196608;
        if (i17 & 32 != 0) {
            $dirty18 |= i116;
        } else {
            if (i32 & i116 == 0) {
                i36 = $composer2.changed(interactionSource) ? 131072 : 65536;
                $dirty18 |= i36;
            }
        }
        i8 = i17 & 64;
        i14 = 1572864;
        if (i8 != 0) {
            $dirty18 |= i14;
            z = isError;
        } else {
            if (i32 & i14 == 0) {
                i31 = $composer2.changed(isError) ? 1048576 : 524288;
                $dirty18 |= i31;
            } else {
                z = isError;
            }
        }
        $dirty6 = i17 & 128;
        $dirty5 = 12582912;
        if ($dirty6 != 0) {
            $dirty18 |= $dirty5;
            obj5 = label;
        } else {
            if (i32 & $dirty5 == 0) {
                i22 = $composer2.changedInstance(label) ? 8388608 : 4194304;
                $dirty18 |= i22;
            } else {
                obj5 = label;
            }
        }
        int i62 = i17 & 256;
        int i119 = 100663296;
        if (i62 != 0) {
            $dirty18 |= i119;
            i28 = i62;
            obj14 = placeholder;
        } else {
            if (i32 & i119 == 0) {
                i28 = i62;
                i44 = $composer2.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty18 |= i44;
            } else {
                i28 = i62;
                obj14 = placeholder;
            }
        }
        int i63 = i17 & 512;
        int i121 = 805306368;
        if (i63 != 0) {
            $dirty18 |= i121;
            i33 = i63;
            obj11 = leadingIcon;
        } else {
            if (i32 & i121 == 0) {
                i33 = i63;
                i23 = $composer2.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty18 |= i23;
            } else {
                i33 = i63;
                obj11 = leadingIcon;
            }
        }
        int i64 = i17 & 1024;
        if (i64 != 0) {
            $dirty1 |= 6;
            i27 = i64;
            obj16 = trailingIcon;
        } else {
            if ($dirty9 & 6 == 0) {
                i27 = i64;
                i14 = $composer2.changedInstance(trailingIcon) ? 4 : 2;
                $dirty1 |= i14;
            } else {
                i27 = i64;
                obj16 = trailingIcon;
            }
        }
        if ($dirty9 & 48 == 0) {
            if (i17 & 2048 == 0) {
                i31 = $composer2.changed(colors) ? 32 : 16;
            } else {
                obj2 = colors;
            }
            $dirty1 |= i31;
        } else {
            obj2 = colors;
        }
        if ($dirty9 & 384 == 0) {
            if (i17 & 4096 == 0) {
                if ($composer2.changed(contentPadding)) {
                } else {
                    changedInstance = $dirty;
                }
            } else {
                obj4 = contentPadding;
            }
            $dirty1 |= changedInstance;
        } else {
            obj4 = contentPadding;
        }
        rememberComposableLambda = i17 & 8192;
        if (rememberComposableLambda != 0) {
            $dirty1 |= 3072;
            obj9 = border;
        } else {
            if ($dirty9 & 3072 == 0) {
                if ($composer2.changedInstance(border)) {
                    i3 = i30;
                }
                $dirty1 |= i3;
            } else {
                obj9 = border;
            }
        }
        if (i17 & 16384 != 0) {
            $dirty1 |= 24576;
        } else {
            if ($dirty9 & 24576 == 0) {
                if ($composer2.changed(this)) {
                } else {
                    $dirty11 = i21;
                }
                $dirty1 |= $dirty11;
            }
        }
        $dirty15 = $dirty1;
        if ($dirty110 &= $dirty18 == 306783378 && $dirty15 & 9363 == 9362) {
            if ($dirty15 & 9363 == 9362) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (i32 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            isError2 = i8 != 0 ? 0 : z;
                            obj8 = $dirty6 != 0 ? i42 : obj5;
                            i13 = i28 != 0 ? i42 : placeholder;
                            i = i33 != 0 ? i42 : leadingIcon;
                            i2 = i27 != 0 ? i42 : trailingIcon;
                            if (i17 & 2048 != 0) {
                                int i101 = rememberComposableLambda;
                                composer2 = $composer2;
                                obj5 = i106;
                                changedInstance = obj5;
                                i3 = changedInstance;
                                i8 = i3;
                                i21 = i8;
                                i31 = i21;
                                i28 = i31;
                                i27 = i28;
                                i38 = i27;
                                i5 = i38;
                                i29 = i5;
                                i6 = i29;
                                i39 = i6;
                                i46 = i39;
                                i12 = i46;
                                i26 = i132;
                                i10 = i133;
                                obj65 = isError2;
                                i9 = i134;
                                isError3 = i18;
                                $composer2 = composer2;
                                $dirty12 = $dirty15;
                                $dirty3 = rememberComposableLambda;
                            } else {
                                obj65 = isError2;
                                i10 = rememberComposableLambda;
                                isError3 = i17;
                                i9 = $dirty18;
                                $dirty3 = colors;
                                $dirty12 = $dirty4;
                            }
                            if (isError3 & 4096 != 0) {
                                z = obj65;
                                outlinedTextFieldPadding-a9UjIt4$default = TextFieldDefaults.outlinedTextFieldPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                $dirty12 &= -897;
                            } else {
                                $dirty13 = this;
                                z = obj65;
                                outlinedTextFieldPadding-a9UjIt4$default = contentPadding;
                            }
                            if (i10 != 0) {
                                TextFieldDefaults.OutlinedTextFieldDecorationBox.3 anon = new TextFieldDefaults.OutlinedTextFieldDecorationBox.3(enabled, z, interactionSource, $dirty3);
                                obj15 = outlinedTextFieldPadding-a9UjIt4$default;
                                obj7 = rememberComposableLambda;
                                obj10 = $dirty3;
                                $dirty15 = $dirty12;
                                $dirty8 = obj8;
                                $dirty14 = i13;
                                obj12 = i;
                                obj = i2;
                            } else {
                                i32 = enabled;
                                z2 = interactionSource;
                                obj7 = border;
                                obj15 = outlinedTextFieldPadding-a9UjIt4$default;
                                obj10 = $dirty3;
                                $dirty15 = $dirty12;
                                $dirty8 = obj8;
                                $dirty14 = i13;
                                obj12 = i;
                                obj = i2;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (i17 & 2048 != 0) {
                                $dirty15 &= -113;
                            }
                            if (i17 & 4096 != 0) {
                                i32 = enabled;
                                z2 = interactionSource;
                                $dirty14 = placeholder;
                                obj12 = leadingIcon;
                                obj = trailingIcon;
                                obj10 = colors;
                                obj15 = contentPadding;
                                $dirty15 = i49;
                                i9 = $dirty18;
                                $dirty8 = obj5;
                                $dirty13 = this;
                                obj7 = border;
                            } else {
                                $dirty13 = this;
                                i32 = enabled;
                                z2 = interactionSource;
                                $dirty14 = placeholder;
                                obj12 = leadingIcon;
                                obj = trailingIcon;
                                obj10 = colors;
                                obj15 = contentPadding;
                                i9 = $dirty18;
                                $dirty8 = obj5;
                                obj7 = border;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i9, $dirty15, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:761)");
                    } else {
                        $dirty16 = i9;
                    }
                    i34 = $dirty15;
                    i7 = $dirty16;
                    i11 = $composer2;
                    $composer2 = z;
                    this.OutlinedTextFieldDecorationBox(value, innerTextField, i32, singleLine, visualTransformation, z2, $composer2, $dirty8, $dirty14, obj12, obj, $dirty13.getOutlinedTextFieldShape($composer2, i72 &= 14), obj10, obj15, obj7, i11, i57 | i88, i61 | i96, 0);
                    composer = i11;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i20 = obj;
                    trailingIcon2 = obj12;
                    leadingIcon2 = $dirty14;
                    placeholder2 = $dirty8;
                    label2 = $composer2;
                } else {
                    $composer2.skipToGroupEnd();
                    leadingIcon2 = placeholder;
                    trailingIcon2 = leadingIcon;
                    obj10 = colors;
                    obj15 = contentPadding;
                    i34 = $dirty15;
                    composer = $composer2;
                    i7 = $dirty18;
                    label2 = z;
                    placeholder2 = obj5;
                    i20 = trailingIcon;
                    obj7 = border;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldDefaults.OutlinedTextFieldDecorationBox.4(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, label2, placeholder2, leadingIcon2, trailingIcon2, i20, obj10, obj15, obj7, $changed, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final void OutlinedTextFieldDecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> border, Composer $composer, int $changed, int $changed1, int i19) {
        Object obj6;
        Object obj4;
        Object obj10;
        Object obj5;
        Object i9;
        Object obj3;
        Object obj2;
        int contentPadding3;
        Object endRestartGroup;
        int defaultsInvalid;
        boolean isError2;
        int isError4;
        Object contentPadding2;
        boolean traceInProgress;
        Composer composer3;
        int rememberComposableLambda;
        boolean traceInProgress2;
        int outlinedTextFieldShape;
        int i38;
        boolean z2;
        Object obj8;
        int $dirty10;
        int i5;
        Object restartGroup;
        int $dirty13;
        int $dirty12;
        Object obj9;
        boolean z3;
        Object obj;
        Object obj13;
        boolean field;
        int isError5;
        int i39;
        Object obj12;
        int i21;
        int i27;
        int $dirty3;
        Object obj14;
        Shape shape3;
        int i18;
        boolean z;
        androidx.compose.material.TextFieldColors field2;
        PaddingValues isError3;
        boolean z4;
        int i10;
        int changedInstance;
        int i6;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int $dirty2;
        int i32;
        PaddingValues i12;
        int $dirty1;
        androidx.compose.material.TextFieldColors i45;
        int i40;
        int i31;
        int i24;
        int border2;
        Object obj11;
        int $dirty9;
        int i29;
        int i36;
        int i20;
        int i16;
        int $dirty11;
        int i41;
        int i17;
        int i25;
        int i37;
        int $dirty;
        int $dirty5;
        int i22;
        int i46;
        boolean changedInstance2;
        int i7;
        int $dirty6;
        int i23;
        int i28;
        int i33;
        int $dirty4;
        int i8;
        int i11;
        int i30;
        int $dirty8;
        int i13;
        int i26;
        int i43;
        Composer composer2;
        Composer composer;
        int $dirty7;
        int i14;
        int i2;
        int i3;
        Object obj7;
        int i47;
        int i44;
        int i4;
        Shape shape2;
        int i;
        int i35;
        int i34;
        int i42;
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
        i38 = i19;
        restartGroup = $composer.startRestartGroup(-920823490);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldDecorationBox)P(13,4,3,11,14,5,6,7,9,8,12,10,1,2)669@31256L22,670@31314L25,672@31450L85,676@31552L628:TextFieldDefaults.kt#jmzs0o");
        $dirty13 = $changed;
        $dirty12 = $changed1;
        if (i38 & 1 != 0) {
            $dirty13 |= 6;
            obj9 = value;
        } else {
            if (i48 & 6 == 0) {
                i39 = restartGroup.changed(value) ? 4 : 2;
                $dirty13 |= i39;
            } else {
                obj9 = value;
            }
        }
        if (i38 & 2 != 0) {
            $dirty13 |= 48;
            obj12 = innerTextField;
        } else {
            if (i48 & 48 == 0) {
                i18 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty13 |= i18;
            } else {
                obj12 = innerTextField;
            }
        }
        if (i38 & 4 != 0) {
            $dirty13 |= 384;
            z = enabled;
        } else {
            if (i48 & 384 == 0) {
                i32 = restartGroup.changed(enabled) ? 256 : changedInstance;
                $dirty13 |= i32;
            } else {
                z = enabled;
            }
        }
        i12 = i38 & 8;
        i45 = 2048;
        if (i12 != 0) {
            $dirty13 |= 3072;
            z2 = singleLine;
        } else {
            if (i48 & 3072 == 0) {
                i40 = restartGroup.changed(singleLine) ? i45 : $dirty1;
                $dirty13 |= i40;
            } else {
                z2 = singleLine;
            }
        }
        i36 = 8192;
        if (i38 & 16 != 0) {
            $dirty13 |= 24576;
            obj = visualTransformation;
        } else {
            if (i48 & 24576 == 0) {
                i31 = restartGroup.changed(visualTransformation) ? i29 : i36;
                $dirty13 |= i31;
            } else {
                obj = visualTransformation;
            }
        }
        i20 = 196608;
        if (i38 & 32 != 0) {
            $dirty13 |= i20;
            obj8 = interactionSource;
        } else {
            if (i48 & i20 == 0) {
                i24 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty13 |= i24;
            } else {
                obj8 = interactionSource;
            }
        }
        $dirty9 = i38 & 64;
        i16 = 1572864;
        if ($dirty9 != 0) {
            $dirty13 |= i16;
            field = isError;
        } else {
            if (i48 & i16 == 0) {
                i41 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty13 |= i41;
            } else {
                field = isError;
            }
        }
        $dirty3 = i38 & 128;
        i17 = 12582912;
        if ($dirty3 != 0) {
            $dirty13 |= i17;
            obj14 = label;
        } else {
            if (i48 & i17 == 0) {
                i25 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty13 |= i25;
            } else {
                obj14 = label;
            }
        }
        i10 = i38 & 256;
        i37 = 100663296;
        if (i10 != 0) {
            $dirty13 |= i37;
            obj6 = placeholder;
        } else {
            if (i48 & i37 == 0) {
                i37 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty13 |= i37;
            } else {
                obj6 = placeholder;
            }
        }
        int i49 = i38 & 512;
        int i137 = 805306368;
        if (i49 != 0) {
            $dirty13 |= i137;
            $dirty = i49;
            obj4 = leadingIcon;
        } else {
            if ($changed & i137 == 0) {
                $dirty = i49;
                i22 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty13 |= i22;
            } else {
                $dirty = i49;
                obj4 = leadingIcon;
            }
        }
        int i50 = i38 & 1024;
        if (i50 != 0) {
            $dirty12 |= 6;
            i46 = i50;
            obj10 = trailingIcon;
        } else {
            if (i63 & 6 == 0) {
                i46 = i50;
                i16 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty12 |= i16;
            } else {
                i46 = i50;
                obj10 = trailingIcon;
            }
        }
        if (i63 & 48 == 0) {
            if (i38 & 2048 == 0) {
                i41 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj5 = shape;
            }
            $dirty12 |= i41;
        } else {
            obj5 = shape;
        }
        if (i63 & 384 == 0) {
            if (i38 & 4096 == 0) {
                if (restartGroup.changed(colors)) {
                    changedInstance = 256;
                }
            } else {
                i9 = colors;
            }
            $dirty12 |= changedInstance;
        } else {
            i9 = colors;
        }
        if (i63 & 3072 == 0) {
            if (i38 & 8192 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    $dirty1 = i45;
                }
            } else {
                obj3 = contentPadding;
            }
            $dirty12 |= $dirty1;
        } else {
            obj3 = contentPadding;
        }
        i5 = i38 & 16384;
        if (i5 != 0) {
            $dirty12 |= 24576;
            obj2 = border;
        } else {
            if (i63 & 24576 == 0) {
                if (restartGroup.changedInstance(border)) {
                } else {
                    i29 = i36;
                }
                $dirty12 |= i29;
            } else {
                obj2 = border;
            }
        }
        if (i38 & i130 != 0) {
            $dirty12 |= i20;
        } else {
            if (i63 & i20 == 0) {
                i6 = restartGroup.changed(traceInProgress) ? 131072 : 65536;
                $dirty12 |= i6;
            }
        }
        if ($dirty13 & $dirty2 == 306783378 && i60 &= $dirty12 == 74898) {
            if (i60 &= $dirty12 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            isError2 = $dirty9 != 0 ? 0 : field;
                            obj7 = $dirty3 != 0 ? rememberComposableLambda : obj14;
                            i47 = i10 != 0 ? rememberComposableLambda : placeholder;
                            i44 = $dirty != 0 ? rememberComposableLambda : leadingIcon;
                            i4 = i46 != 0 ? rememberComposableLambda : trailingIcon;
                            if (i38 & 2048 != 0) {
                                $dirty12 &= -113;
                                shape2 = outlinedTextFieldShape;
                            } else {
                                shape2 = shape;
                            }
                            if (i38 & 4096 != 0) {
                                composer = restartGroup;
                                obj14 = $dirty12;
                                i10 = i124;
                                i45 = i10;
                                i29 = -920823490;
                                i20 = i132;
                                i41 = i29;
                                i25 = i20;
                                i46 = i41;
                                i7 = i25;
                                i23 = i46;
                                i33 = i7;
                                i8 = i23;
                                i30 = i33;
                                i13 = i8;
                                i43 = i30;
                                i = i147;
                                i42 = i149;
                                obj76 = isError2;
                                i15 = i34;
                                rememberComposableLambda = traceInProgress.outlinedTextFieldColors-dx8h9Zs(0, i38, 0, restartGroup, 0, $dirty12, 0, obj, 0, obj12, 0, obj14, 0, i10, 0, i12, 0, i45, 0, i29, 0, i20, 0, i41, 0, i25);
                                composer3 = composer;
                                $dirty12 = isError4 & -897;
                            } else {
                                obj76 = isError2;
                                i = i5;
                                composer3 = restartGroup;
                                i15 = $dirty13;
                                isError4 = $dirty12;
                                rememberComposableLambda = colors;
                            }
                            if (i38 & 8192 != 0) {
                                contentPadding2 = TextFieldDefaults.outlinedTextFieldPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                $dirty12 &= -7169;
                            } else {
                                contentPadding2 = contentPadding;
                            }
                            if (i != 0) {
                                obj69 = obj76;
                                obj71 = rememberComposableLambda;
                                obj67 = anon;
                                obj72 = shape2;
                                super(enabled, obj69, interactionSource, obj71, obj72);
                                i12 = contentPadding2;
                                obj11 = rememberComposableLambda;
                                i45 = i5;
                                $dirty1 = restartGroup;
                                contentPadding3 = $dirty12;
                                z4 = z6;
                                obj13 = obj7;
                                isError5 = i47;
                                i21 = i44;
                                i27 = i4;
                            } else {
                                obj11 = border;
                                i12 = contentPadding2;
                                i45 = i5;
                                $dirty1 = restartGroup;
                                contentPadding3 = $dirty12;
                                z4 = isError6;
                                obj13 = obj7;
                                isError5 = i47;
                                i21 = i44;
                                i27 = i4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i38 & 2048 != 0) {
                                $dirty12 &= -113;
                            }
                            if (i38 & 4096 != 0) {
                                $dirty12 &= -897;
                            }
                            if (i38 & 8192 != 0) {
                                contentPadding3 = $dirty12 & -7169;
                                i21 = leadingIcon;
                                i27 = trailingIcon;
                                $dirty1 = shape;
                                i45 = colors;
                                i12 = contentPadding;
                                obj11 = border;
                                composer3 = restartGroup;
                                i15 = $dirty13;
                                z4 = field;
                                obj13 = obj14;
                                isError5 = placeholder;
                            } else {
                                i21 = leadingIcon;
                                i27 = trailingIcon;
                                $dirty1 = shape;
                                i45 = colors;
                                i12 = contentPadding;
                                obj11 = border;
                                composer3 = restartGroup;
                                i15 = $dirty13;
                                contentPadding3 = $dirty12;
                                z4 = field;
                                obj13 = obj14;
                                isError5 = placeholder;
                            }
                        }
                    } else {
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-920823490, i15, contentPadding3, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:675)");
                    } else {
                        $dirty10 = i15;
                    }
                    i29 = composer3;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, obj13, isError5, i21, i27, singleLine, enabled, z4, interactionSource, i12, $dirty1, i45, obj11, i29, i73 | i101, rememberComposableLambda | i111);
                    composer2 = i29;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z4;
                    isError3 = i12;
                    shape3 = $dirty1;
                    field2 = i45;
                    composableLambda = obj11;
                    border2 = contentPadding3;
                } else {
                    restartGroup.skipToGroupEnd();
                    i21 = leadingIcon;
                    i27 = trailingIcon;
                    field2 = colors;
                    isError3 = contentPadding;
                    composableLambda = border;
                    composer2 = restartGroup;
                    $dirty10 = $dirty13;
                    border2 = $dirty12;
                    z3 = field;
                    obj13 = obj14;
                    isError5 = placeholder;
                    shape3 = shape;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = $dirty10;
            endRestartGroup = new TextFieldDefaults.OutlinedTextFieldDecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z3, obj13, isError5, i21, i27, shape3, field2, isError3, composableLambda, $changed, $changed1, i38);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty5 = $dirty10;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final void TextFieldDecorationBox(String value, Function2 innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Composer $composer, int $changed, int $changed1, int i17) {
        boolean traceInProgress;
        Object endRestartGroup;
        int defaultsInvalid;
        int $dirty2;
        androidx.compose.material.TextFieldDefaults $dirty1;
        Object obj7;
        Object obj3;
        Object obj11;
        Object obj12;
        Object obj4;
        int changed2;
        int contentPadding2;
        PaddingValues textFieldWithLabelPadding-a9UjIt4$default;
        int textFieldColors-dx8h9Zs;
        int i43;
        boolean traceInProgress2;
        int $dirty;
        int $dirty3;
        boolean z3;
        Object obj13;
        int $dirty4;
        int $dirty12;
        int i9;
        Object colors2;
        androidx.compose.material.TextFieldColors field;
        Object obj8;
        boolean label2;
        int i25;
        Object $dirty13;
        boolean i32;
        Object placeholder2;
        int i35;
        int i14;
        Object obj;
        int leadingIcon2;
        int i13;
        int trailingIcon2;
        int i33;
        Object obj5;
        int obj10;
        int i23;
        boolean z;
        Object obj2;
        PaddingValues obj6;
        int i41;
        Composer restartGroup;
        int i39;
        int i5;
        int i12;
        int i22;
        int i20;
        int i40;
        int i4;
        int i28;
        int i30;
        int i11;
        int changed;
        int i8;
        int i15;
        int i;
        int i26;
        int i24;
        int i29;
        int i27;
        boolean changedInstance;
        int i16;
        int i38;
        int i18;
        int i31;
        int i3;
        int i19;
        int i2;
        int i42;
        Composer composer2;
        Composer composer;
        int i6;
        int i34;
        int i37;
        int i36;
        boolean z2;
        Object obj9;
        int i44;
        int i10;
        int i7;
        int i45;
        int i46;
        int i21;
        ScopeUpdateScope scopeUpdateScope;
        int obj64;
        int i53 = $changed;
        textFieldColors-dx8h9Zs = $changed1;
        $dirty = i17;
        restartGroup = $composer.startRestartGroup(1171040065);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)714@32930L17,733@33577L14,721@33156L508:TextFieldDefaults.kt#jmzs0o");
        $dirty4 = $changed;
        $dirty12 = $changed1;
        if ($dirty & 1 != 0) {
            $dirty4 |= 6;
            colors2 = value;
        } else {
            if (i53 & 6 == 0) {
                i14 = restartGroup.changed(value) ? 4 : 2;
                $dirty4 |= i14;
            } else {
                colors2 = value;
            }
        }
        if ($dirty & 2 != 0) {
            $dirty4 |= 48;
            obj = innerTextField;
        } else {
            if (i53 & 48 == 0) {
                i23 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty4 |= i23;
            } else {
                obj = innerTextField;
            }
        }
        if ($dirty & 4 != 0) {
            $dirty4 |= 384;
            z = enabled;
        } else {
            if (i53 & 384 == 0) {
                i5 = restartGroup.changed(enabled) ? 256 : i39;
                $dirty4 |= i5;
            } else {
                z = enabled;
            }
        }
        i12 = $dirty & 8;
        int i111 = 2048;
        if (i12 != 0) {
            $dirty4 |= 3072;
            z3 = singleLine;
        } else {
            if (i53 & 3072 == 0) {
                i40 = restartGroup.changed(singleLine) ? i111 : i22;
                $dirty4 |= i40;
            } else {
                z3 = singleLine;
            }
        }
        if ($dirty & 16 != 0) {
            $dirty4 |= 24576;
            obj8 = visualTransformation;
        } else {
            if (i53 & 24576 == 0) {
                i4 = restartGroup.changed(visualTransformation) ? 16384 : 8192;
                $dirty4 |= i4;
            } else {
                obj8 = visualTransformation;
            }
        }
        int i113 = 196608;
        if ($dirty & 32 != 0) {
            $dirty4 |= i113;
            obj13 = interactionSource;
        } else {
            if (i53 & i113 == 0) {
                i28 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty4 |= i28;
            } else {
                obj13 = interactionSource;
            }
        }
        i30 = $dirty & 64;
        i11 = 1572864;
        if (i30 != 0) {
            $dirty4 |= i11;
            i32 = isError;
        } else {
            if (i53 & i11 == 0) {
                i8 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty4 |= i8;
            } else {
                i32 = isError;
            }
        }
        int i107 = $dirty & 128;
        i15 = 12582912;
        if (i107 != 0) {
            $dirty4 |= i15;
            obj5 = label;
        } else {
            if (i53 & i15 == 0) {
                i = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty4 |= i;
            } else {
                obj5 = label;
            }
        }
        i41 = $dirty & 256;
        i26 = 100663296;
        if (i41 != 0) {
            $dirty4 |= i26;
            obj7 = placeholder;
        } else {
            if (i53 & i26 == 0) {
                i26 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty4 |= i26;
            } else {
                obj7 = placeholder;
            }
        }
        int i54 = $dirty & 512;
        int i116 = 805306368;
        if (i54 != 0) {
            $dirty4 |= i116;
            i24 = i54;
            obj3 = leadingIcon;
        } else {
            if ($changed & i116 == 0) {
                i24 = i54;
                i29 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty4 |= i29;
            } else {
                i24 = i54;
                obj3 = leadingIcon;
            }
        }
        int i55 = $dirty & 1024;
        if (i55 != 0) {
            $dirty12 |= 6;
            i27 = i55;
            obj11 = trailingIcon;
        } else {
            if (textFieldColors-dx8h9Zs & 6 == 0) {
                i27 = i55;
                i11 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty12 |= i11;
            } else {
                i27 = i55;
                obj11 = trailingIcon;
            }
        }
        if (textFieldColors-dx8h9Zs & 48 == 0) {
            if ($dirty & 2048 == 0) {
                i8 = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj12 = colors;
            }
            $dirty12 |= i8;
        } else {
            obj12 = colors;
        }
        if (textFieldColors-dx8h9Zs & 384 == 0) {
            if ($dirty & 4096 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    i39 = 256;
                }
            } else {
                obj4 = contentPadding;
            }
            $dirty12 |= i39;
        } else {
            obj4 = contentPadding;
        }
        if ($dirty & 8192 != 0) {
            $dirty12 |= 3072;
        } else {
            if (textFieldColors-dx8h9Zs & 3072 == 0 && restartGroup.changed(this)) {
                if (restartGroup.changed(obj14)) {
                    i22 = i111;
                }
                $dirty12 |= i22;
            }
        }
        contentPadding2 = $dirty12;
        if ($dirty15 &= $dirty4 == 306783378 && contentPadding2 & 1171 == 1170) {
            if (contentPadding2 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            z2 = i30 != 0 ? defaultsInvalid : i32;
                            obj9 = i107 != 0 ? defaultsInvalid : obj5;
                            i44 = i41 != 0 ? defaultsInvalid : placeholder;
                            i10 = i24 != 0 ? defaultsInvalid : leadingIcon;
                            i7 = i27 != 0 ? defaultsInvalid : trailingIcon;
                            if ($dirty & 2048 != 0) {
                                composer = restartGroup;
                                i45 = i129;
                                i21 = i49;
                                $dirty2 = i17;
                                restartGroup = composer;
                                i25 = contentPadding2;
                                field = textFieldColors-dx8h9Zs;
                            } else {
                                $dirty2 = $dirty;
                                i21 = $dirty4;
                                i25 = obj64;
                                field = colors;
                            }
                            if ($dirty2 & 4096 != 0) {
                                if (obj9 == null) {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithoutLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                } else {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                }
                                obj6 = textFieldWithLabelPadding-a9UjIt4$default;
                                contentPadding2 = textFieldColors-dx8h9Zs;
                                obj2 = field;
                                colors2 = z2;
                                $dirty13 = obj9;
                                i35 = i44;
                                i13 = i10;
                                i33 = i7;
                            } else {
                                $dirty1 = this;
                                obj6 = contentPadding;
                                obj2 = field;
                                contentPadding2 = i25;
                                colors2 = z2;
                                $dirty13 = obj9;
                                i35 = i44;
                                i13 = i10;
                                i33 = i7;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if ($dirty & 2048 != 0) {
                                contentPadding2 &= -113;
                            }
                            if ($dirty & 4096 != 0) {
                                i13 = leadingIcon;
                                i33 = trailingIcon;
                                obj2 = colors;
                                obj6 = contentPadding;
                                contentPadding2 = i52;
                                i21 = $dirty4;
                                colors2 = i32;
                                $dirty13 = obj5;
                                $dirty1 = this;
                                i35 = placeholder;
                            } else {
                                $dirty1 = this;
                                i13 = leadingIcon;
                                i33 = trailingIcon;
                                obj2 = colors;
                                obj6 = contentPadding;
                                i21 = $dirty4;
                                colors2 = i32;
                                $dirty13 = obj5;
                                i35 = placeholder;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i21, contentPadding2, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:721)");
                    } else {
                        $dirty3 = i21;
                    }
                    i20 = contentPadding2;
                    i46 = $dirty3;
                    $dirty1.TextFieldDecorationBox(value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, colors2, $dirty13, i35, i13, i33, $dirty1.getTextFieldShape(restartGroup, i63 &= 14), obj2, obj6, restartGroup, i73 | i92, i76 | i98, 0);
                    composer2 = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj10 = i33;
                    trailingIcon2 = i13;
                    leadingIcon2 = i35;
                    placeholder2 = $dirty13;
                    label2 = colors2;
                } else {
                    restartGroup.skipToGroupEnd();
                    leadingIcon2 = placeholder;
                    trailingIcon2 = leadingIcon;
                    obj2 = colors;
                    obj6 = contentPadding;
                    i20 = contentPadding2;
                    i46 = $dirty4;
                    label2 = i32;
                    placeholder2 = obj5;
                    composer2 = restartGroup;
                    obj10 = trailingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldDefaults.TextFieldDecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, label2, placeholder2, leadingIcon2, trailingIcon2, obj10, obj2, obj6, $changed, $changed1, i17);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final void TextFieldDecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Composer $composer, int $changed, int $changed1, int i18) {
        Object obj10;
        Object obj5;
        Object obj6;
        Object obj;
        Object i6;
        Object obj3;
        int changed2;
        int contentPadding2;
        int defaultsInvalid;
        boolean isError3;
        int isError4;
        PaddingValues textFieldWithLabelPadding-a9UjIt4$default;
        Object endRestartGroup;
        Object traceInProgress;
        boolean traceInProgress2;
        int i2;
        int textFieldColors-dx8h9Zs;
        int $dirty7;
        int textFieldShape;
        int i40;
        boolean z4;
        Object obj2;
        Composer restartGroup;
        int $dirty3;
        int $dirty15;
        Object obj4;
        boolean z3;
        Object obj8;
        Object obj11;
        boolean $dirty5;
        int i26;
        int i43;
        Object obj7;
        int i19;
        int i24;
        int $dirty12;
        Object obj9;
        Shape shape2;
        int i20;
        boolean z;
        androidx.compose.material.TextFieldColors field;
        boolean z2;
        int i35;
        PaddingValues isError2;
        int $dirty17;
        int i38;
        Object i44;
        int $dirty2;
        androidx.compose.material.TextFieldColors i9;
        int i17;
        int colors2;
        int i36;
        int i34;
        int i8;
        int i27;
        int i25;
        Composer composer;
        int $dirty6;
        int i28;
        int changed;
        int i29;
        int i;
        int $dirty16;
        int i45;
        int i4;
        int i32;
        int i10;
        boolean changedInstance;
        int $dirty13;
        int i15;
        int i37;
        int i7;
        int $dirty18;
        int i13;
        int i39;
        int i14;
        int $dirty14;
        int i3;
        int i21;
        int i30;
        int $dirty1;
        int i22;
        Composer composer2;
        int i23;
        int $dirty;
        int $dirty4;
        int i41;
        int i42;
        Object obj12;
        int i11;
        int i31;
        int i33;
        Shape shape3;
        int i16;
        int i46;
        int i12;
        int i5;
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
        i40 = i18;
        restartGroup = $composer.startRestartGroup(-1391531252);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldDecorationBox)P(12,3,2,10,13,4,5,6,8,7,11,9)573@25758L14,574@25808L17,582@26042L624:TextFieldDefaults.kt#jmzs0o");
        $dirty3 = $changed;
        $dirty15 = $changed1;
        if (i40 & 1 != 0) {
            $dirty3 |= 6;
            obj4 = value;
        } else {
            if (i47 & 6 == 0) {
                i43 = restartGroup.changed(value) ? 4 : 2;
                $dirty3 |= i43;
            } else {
                obj4 = value;
            }
        }
        if (i40 & 2 != 0) {
            $dirty3 |= 48;
            obj7 = innerTextField;
        } else {
            if (i47 & 48 == 0) {
                i20 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty3 |= i20;
            } else {
                obj7 = innerTextField;
            }
        }
        if (i40 & 4 != 0) {
            $dirty3 |= 384;
            z = enabled;
        } else {
            if (i47 & 384 == 0) {
                i38 = restartGroup.changed(enabled) ? 256 : $dirty17;
                $dirty3 |= i38;
            } else {
                z = enabled;
            }
        }
        i44 = i40 & 8;
        i17 = 2048;
        if (i44 != 0) {
            $dirty3 |= 3072;
            z4 = singleLine;
        } else {
            if (i47 & 3072 == 0) {
                i36 = restartGroup.changed(singleLine) ? i17 : $dirty2;
                $dirty3 |= i36;
            } else {
                z4 = singleLine;
            }
        }
        $dirty6 = 8192;
        if (i40 & 16 != 0) {
            $dirty3 |= 24576;
            obj8 = visualTransformation;
        } else {
            if (i47 & 24576 == 0) {
                i34 = restartGroup.changed(visualTransformation) ? i25 : $dirty6;
                $dirty3 |= i34;
            } else {
                obj8 = visualTransformation;
            }
        }
        final int i144 = 196608;
        if (i40 & 32 != 0) {
            $dirty3 |= i144;
            obj2 = interactionSource;
        } else {
            if (i47 & i144 == 0) {
                i8 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty3 |= i8;
            } else {
                obj2 = interactionSource;
            }
        }
        i27 = i40 & 64;
        i28 = 1572864;
        if (i27 != 0) {
            $dirty3 |= i28;
            $dirty5 = isError;
        } else {
            if (i47 & i28 == 0) {
                i29 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty3 |= i29;
            } else {
                $dirty5 = isError;
            }
        }
        $dirty12 = i40 & 128;
        i = 12582912;
        if ($dirty12 != 0) {
            $dirty3 |= i;
            obj9 = label;
        } else {
            if (i47 & i == 0) {
                $dirty16 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty3 |= $dirty16;
            } else {
                obj9 = label;
            }
        }
        i35 = i40 & 256;
        i45 = 100663296;
        if (i35 != 0) {
            $dirty3 |= i45;
            obj10 = placeholder;
        } else {
            if (i47 & i45 == 0) {
                i45 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty3 |= i45;
            } else {
                obj10 = placeholder;
            }
        }
        int i48 = i40 & 512;
        int i131 = 805306368;
        if (i48 != 0) {
            $dirty3 |= i131;
            i4 = i48;
            obj5 = leadingIcon;
        } else {
            if ($changed & i131 == 0) {
                i4 = i48;
                i32 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty3 |= i32;
            } else {
                i4 = i48;
                obj5 = leadingIcon;
            }
        }
        int i49 = i40 & 1024;
        if (i49 != 0) {
            $dirty15 |= 6;
            i10 = i49;
            obj6 = trailingIcon;
        } else {
            if (i78 & 6 == 0) {
                i10 = i49;
                i28 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty15 |= i28;
            } else {
                i10 = i49;
                obj6 = trailingIcon;
            }
        }
        if (i78 & 48 == 0) {
            if (i40 & 2048 == 0) {
                i29 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj = shape;
            }
            $dirty15 |= i29;
        } else {
            obj = shape;
        }
        if (i78 & 384 == 0) {
            if (i40 & 4096 == 0) {
                if (restartGroup.changed(colors)) {
                    $dirty17 = 256;
                }
            } else {
                i6 = colors;
            }
            $dirty15 |= $dirty17;
        } else {
            i6 = colors;
        }
        if (i78 & 3072 == 0) {
            if (i40 & 8192 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    $dirty2 = i17;
                }
            } else {
                obj3 = contentPadding;
            }
            $dirty15 |= $dirty2;
        } else {
            obj3 = contentPadding;
        }
        if (i40 & 16384 != 0) {
            $dirty15 |= 24576;
        } else {
            if (i78 & 24576 == 0) {
                if (restartGroup.changed(traceInProgress)) {
                } else {
                    i25 = $dirty6;
                }
                $dirty15 |= i25;
            }
        }
        if (i53 &= $dirty3 == 306783378 && $dirty15 & 9363 == 9362) {
            if ($dirty15 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            isError3 = i27 != 0 ? 0 : $dirty5;
                            obj12 = $dirty12 != 0 ? textFieldColors-dx8h9Zs : obj9;
                            i11 = i35 != 0 ? textFieldColors-dx8h9Zs : placeholder;
                            i31 = i4 != 0 ? textFieldColors-dx8h9Zs : leadingIcon;
                            i33 = i10 != 0 ? textFieldColors-dx8h9Zs : trailingIcon;
                            if (i40 & 2048 != 0) {
                                $dirty15 &= -113;
                                shape3 = textFieldShape;
                            } else {
                                shape3 = shape;
                            }
                            if (i40 & 4096 != 0) {
                                Composer composer3 = restartGroup;
                                obj9 = i119;
                                i35 = obj9;
                                i17 = i125;
                                changed = i17;
                                composer2 = composer3;
                                i = i128;
                                i4 = i;
                                changedInstance = i4;
                                i15 = changedInstance;
                                i7 = i15;
                                i13 = i7;
                                i14 = i13;
                                i3 = i14;
                                i30 = i3;
                                i22 = i30;
                                i46 = i142;
                                obj75 = isError3;
                                i5 = i12;
                                textFieldColors-dx8h9Zs = traceInProgress.textFieldColors-dx8h9Zs(0, i40, 0, restartGroup, 0, $dirty15, 0, obj8, 0, obj7, 0, obj9, 0, i35, 0, i44, 0, i17, 0, composer3, 0, changed, 0, i, 0, i4);
                                composer = composer2;
                                $dirty15 = isError4 & -897;
                            } else {
                                obj75 = isError3;
                                composer = restartGroup;
                                i5 = $dirty3;
                                isError4 = $dirty15;
                                textFieldColors-dx8h9Zs = colors;
                            }
                            if (i40 & 8192 != 0) {
                                if (obj12 == null) {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithoutLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                } else {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                }
                                z2 = obj75;
                                i44 = textFieldWithLabelPadding-a9UjIt4$default;
                                contentPadding2 = traceInProgress;
                                i9 = textFieldColors-dx8h9Zs;
                                obj11 = obj12;
                                i26 = i11;
                                i19 = i31;
                                i24 = i33;
                                $dirty2 = shape3;
                            } else {
                                i44 = contentPadding;
                                z2 = obj75;
                                i9 = textFieldColors-dx8h9Zs;
                                contentPadding2 = $dirty15;
                                obj11 = obj12;
                                i26 = i11;
                                i19 = i31;
                                i24 = i33;
                                $dirty2 = shape3;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i40 & 2048 != 0) {
                                $dirty15 &= -113;
                            }
                            if (i40 & 4096 != 0) {
                                $dirty15 &= -897;
                            }
                            if (i40 & 8192 != 0) {
                                contentPadding2 = $dirty15 & -7169;
                                i19 = leadingIcon;
                                i24 = trailingIcon;
                                $dirty2 = shape;
                                i9 = colors;
                                i44 = contentPadding;
                                composer = restartGroup;
                                i5 = $dirty3;
                                z2 = $dirty5;
                                obj11 = obj9;
                                i26 = placeholder;
                            } else {
                                i19 = leadingIcon;
                                i24 = trailingIcon;
                                $dirty2 = shape;
                                i9 = colors;
                                i44 = contentPadding;
                                composer = restartGroup;
                                i5 = $dirty3;
                                contentPadding2 = $dirty15;
                                z2 = $dirty5;
                                obj11 = obj9;
                                i26 = placeholder;
                            }
                        }
                    } else {
                    }
                    composer.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1391531252, i5, contentPadding2, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:581)");
                    } else {
                        $dirty7 = i5;
                    }
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, obj11, i26, i19, i24, singleLine, enabled, z2, interactionSource, i44, $dirty2, i9, 0, composer, i71 | i100, i77 | obj2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    isError2 = i44;
                    shape2 = $dirty2;
                    field = i9;
                    colors2 = contentPadding2;
                } else {
                    restartGroup.skipToGroupEnd();
                    i19 = leadingIcon;
                    i24 = trailingIcon;
                    field = colors;
                    isError2 = contentPadding;
                    composer = restartGroup;
                    $dirty7 = $dirty3;
                    colors2 = $dirty15;
                    z3 = $dirty5;
                    obj11 = obj9;
                    i26 = placeholder;
                    shape2 = shape;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = $dirty7;
            endRestartGroup = new TextFieldDefaults.TextFieldDecorationBox.1(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z3, obj11, i26, i19, i24, shape2, field, isError2, $changed, $changed1, i40);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty4 = $dirty7;
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
        int disabled5;
        boolean traceInProgress;
        int copy-wmQWz5c$default2;
        int iNSTANCE;
        int companion;
        int colors5;
        int colors4;
        int high2;
        int disabled4;
        int disabled;
        androidx.compose.material.Colors colors2;
        int i12;
        float disabled2;
        int i20;
        int disabled3;
        int colors;
        int high;
        int medium2;
        int disabled6;
        int colors3;
        int medium;
        int copy-wmQWz5c$default3;
        int i5;
        int i17;
        int i3;
        int i;
        long l;
        Object consume2;
        String copy-wmQWz5c$default;
        Object consume;
        long l4;
        long unbox-impl;
        long transparent-0d7_KjU;
        long cursorColor2;
        float floatValue;
        int i9;
        long errorCursorColor2;
        int i7;
        int i4;
        long focusedBorderColor2;
        int i6;
        int i15;
        long unfocusedBorderColor3;
        long errorBorderColor2;
        int i18;
        int i24;
        long unfocusedBorderColor2;
        int i14;
        int i16;
        long l2;
        int i25;
        long leadingIconColor2;
        long leadingIconColor3;
        int i30;
        long leadingIconColor4;
        int i35;
        int i31;
        long errorLeadingIconColor2;
        int i8;
        long trailingIconColor4;
        long trailingIconColor3;
        int i34;
        long trailingIconColor2;
        int i11;
        int i22;
        long errorTrailingIconColor2;
        int i10;
        long l5;
        long focusedLabelColor2;
        int i23;
        long unfocusedLabelColor2;
        long unfocusedLabelColor4;
        int i19;
        int i21;
        long unfocusedLabelColor3;
        int i32;
        int i27;
        long errorLabelColor2;
        int i33;
        long placeholderColor2;
        int i2;
        long l3;
        int i28;
        int i13;
        int i29;
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
            i17 = 6;
            int i47 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i48, copy-wmQWz5c$default);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l = copy-wmQWz5c$default2;
        } else {
            l = textColor;
        }
        i3 = 6;
        if (i36 & 2 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = backgroundColor;
        }
        if (i36 & 4 != 0) {
            l5 = transparent-0d7_KjU;
        } else {
            l5 = errorCursorColor;
        }
        if (i36 & 8 != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i3).getPrimary-0d7_KjU();
        } else {
            cursorColor2 = unfocusedBorderColor;
        }
        if (i36 & 16 != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i3).getError-0d7_KjU();
        } else {
            errorCursorColor2 = errorBorderColor;
        }
        if (i36 & 32 != 0) {
            focusedBorderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i3), 0, 0, 0, 14);
        } else {
            focusedBorderColor2 = disabledLeadingIconColor;
        }
        if (i36 & 64 != 0) {
            unfocusedBorderColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
        } else {
            unfocusedBorderColor3 = trailingIconColor;
        }
        if (i36 & 128 != 0) {
            obj53 = unfocusedBorderColor3;
            unfocusedBorderColor2 = obj53;
            l2 = unfocusedBorderColor3;
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor3;
            l2 = errorTrailingIconColor;
        }
        if (i36 & 256 != 0) {
            errorBorderColor2 = MaterialTheme.INSTANCE.getColors(composer, i3).getError-0d7_KjU();
        } else {
            errorBorderColor2 = unfocusedLabelColor;
        }
        if (i36 & 512 != 0) {
            leadingIconColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconColor2 = errorLabelColor;
        }
        if (i36 & 1024 != 0) {
            obj53 = leadingIconColor2;
            leadingIconColor3 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
            leadingIconColor4 = obj53;
        } else {
            leadingIconColor4 = leadingIconColor2;
            leadingIconColor3 = disabledPlaceholderColor;
        }
        errorLeadingIconColor2 = i36 & 2048 != 0 ? leadingIconColor4 : $changed;
        if (i36 & 4096 != 0) {
            trailingIconColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor4 = $changed2;
        }
        if (i36 & 8192 != 0) {
            obj53 = trailingIconColor4;
            trailingIconColor3 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
            trailingIconColor2 = obj53;
        } else {
            trailingIconColor2 = trailingIconColor4;
            trailingIconColor3 = obj79;
        }
        if (i36 & 16384 != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, i3).getError-0d7_KjU();
        } else {
            errorTrailingIconColor2 = obj81;
        }
        if (i39 &= i36 != 0) {
            focusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i3), 0, 0, 0, 14);
        } else {
            focusedLabelColor2 = obj83;
        }
        if (i40 &= i36 != 0) {
            unfocusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i3), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor2 = obj85;
        }
        if (i41 &= i36 != 0) {
            obj53 = unfocusedLabelColor2;
            unfocusedLabelColor4 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
            unfocusedLabelColor3 = obj53;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor2;
            unfocusedLabelColor4 = obj87;
        }
        if (i42 &= i36 != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, i3).getError-0d7_KjU();
        } else {
            errorLabelColor2 = obj89;
        }
        if (i43 &= i36 != 0) {
            placeholderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i3), 0, 0, 0, 14);
        } else {
            placeholderColor2 = obj91;
        }
        if (i36 &= copy-wmQWz5c$default3 != 0) {
            l3 = copy-wmQWz5c$default3;
        } else {
            l3 = obj93;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i37, obj96, obj97, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:480)");
        } else {
            i5 = obj96;
            i = obj97;
        }
        long l7 = l;
        DefaultTextFieldColors textColor2 = new DefaultTextFieldColors(l7, copy-wmQWz5c$default, l4, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i7, focusedBorderColor2, i6, unfocusedBorderColor2, i18, errorBorderColor2, i14, l2, i25, leadingIconColor4, obj23, leadingIconColor3, i35, errorLeadingIconColor2, i8, trailingIconColor2, obj29, trailingIconColor3, i11, errorTrailingIconColor2, i10, l5, obj35, focusedLabelColor2, obj37, unfocusedLabelColor3, i19, unfocusedLabelColor4, i32, errorLabelColor2, i33, placeholderColor2, obj45, l3, i28, 0);
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
        int disabled;
        boolean traceInProgress;
        int copy-wmQWz5c$default;
        int iNSTANCE;
        int colors;
        int colors3;
        int colors6;
        int high;
        int i2;
        int disabled4;
        androidx.compose.material.Colors colors5;
        int i13;
        float disabled2;
        int i12;
        int disabled3;
        int colors2;
        int high2;
        int medium2;
        int disabled5;
        int colors4;
        int medium;
        int copy-wmQWz5c$default2;
        int i20;
        int i19;
        int i27;
        int i25;
        long l;
        Object consume;
        String copy-wmQWz5c$default3;
        Object consume2;
        long l3;
        long unbox-impl;
        long copy-wmQWz5c$default4;
        long cursorColor2;
        float floatValue;
        int i9;
        long errorCursorColor2;
        int i3;
        int i28;
        long focusedIndicatorColor2;
        int i33;
        int i5;
        long unfocusedIndicatorColor3;
        long errorIndicatorColor2;
        int i23;
        int i6;
        long unfocusedIndicatorColor2;
        int i14;
        int i35;
        long l4;
        int i7;
        long leadingIconColor3;
        long leadingIconColor2;
        int i11;
        long leadingIconColor4;
        int i8;
        int i4;
        long errorLeadingIconColor2;
        int i36;
        long trailingIconColor4;
        long trailingIconColor2;
        int i30;
        long trailingIconColor3;
        int i32;
        int i15;
        long errorTrailingIconColor2;
        int i21;
        long l2;
        long focusedLabelColor2;
        int i10;
        long unfocusedLabelColor2;
        long unfocusedLabelColor3;
        int i16;
        int i31;
        long unfocusedLabelColor4;
        int i22;
        int i34;
        long errorLabelColor2;
        int i17;
        long placeholderColor2;
        int i24;
        long l5;
        int i29;
        int i;
        int i18;
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
            copy-wmQWz5c$default3 = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i49, copy-wmQWz5c$default3);
            ComposerKt.sourceInformationMarkerEnd(composer);
            i19 = 6;
            int i48 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i49, copy-wmQWz5c$default3);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l = copy-wmQWz5c$default;
        } else {
            l = textColor;
        }
        i27 = 6;
        if (i37 & 2 != 0) {
            l3 = copy-wmQWz5c$default3;
        } else {
            l3 = backgroundColor;
        }
        if (i37 & 4 != 0) {
            l2 = copy-wmQWz5c$default4;
        } else {
            l2 = errorCursorColor;
        }
        if (i37 & 8 != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i27).getPrimary-0d7_KjU();
        } else {
            cursorColor2 = unfocusedIndicatorColor;
        }
        if (i37 & 16 != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i27).getError-0d7_KjU();
        } else {
            errorCursorColor2 = errorIndicatorColor;
        }
        if (i37 & 32 != 0) {
            focusedIndicatorColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i27).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i27), 0, 0, 0, 14);
        } else {
            focusedIndicatorColor2 = disabledLeadingIconColor;
        }
        if (i37 & 64 != 0) {
            unfocusedIndicatorColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i27).getOnSurface-0d7_KjU(), disabledTextColor, 1054280253, 0, 0, 0, 14);
        } else {
            unfocusedIndicatorColor3 = trailingIconColor;
        }
        if (i37 & 128 != 0) {
            obj53 = unfocusedIndicatorColor3;
            unfocusedIndicatorColor2 = obj53;
            l4 = unfocusedIndicatorColor3;
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor3;
            l4 = errorTrailingIconColor;
        }
        if (i37 & 256 != 0) {
            errorIndicatorColor2 = MaterialTheme.INSTANCE.getColors(composer, i27).getError-0d7_KjU();
        } else {
            errorIndicatorColor2 = unfocusedLabelColor;
        }
        if (i37 & 512 != 0) {
            leadingIconColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i27).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconColor3 = errorLabelColor;
        }
        if (i37 & 1024 != 0) {
            obj53 = leadingIconColor3;
            leadingIconColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i27), 0, 0, 0, 14);
            leadingIconColor4 = obj53;
        } else {
            leadingIconColor4 = leadingIconColor3;
            leadingIconColor2 = disabledPlaceholderColor;
        }
        errorLeadingIconColor2 = i37 & 2048 != 0 ? leadingIconColor4 : $changed;
        if (i37 & 4096 != 0) {
            trailingIconColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i27).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor4 = $changed2;
        }
        if (i37 & 8192 != 0) {
            obj53 = trailingIconColor4;
            trailingIconColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i27), 0, 0, 0, 14);
            trailingIconColor3 = obj53;
        } else {
            trailingIconColor3 = trailingIconColor4;
            trailingIconColor2 = obj79;
        }
        if (i37 & 16384 != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, i27).getError-0d7_KjU();
        } else {
            errorTrailingIconColor2 = obj81;
        }
        if (i40 &= i37 != 0) {
            focusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i27).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i27), 0, 0, 0, 14);
        } else {
            focusedLabelColor2 = obj83;
        }
        if (i41 &= i37 != 0) {
            unfocusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i27).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i27), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor2 = obj85;
        }
        if (i42 &= i37 != 0) {
            obj53 = unfocusedLabelColor2;
            unfocusedLabelColor3 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i27), 0, 0, 0, 14);
            unfocusedLabelColor4 = obj53;
        } else {
            unfocusedLabelColor4 = unfocusedLabelColor2;
            unfocusedLabelColor3 = obj87;
        }
        if (i43 &= i37 != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, i27).getError-0d7_KjU();
        } else {
            errorLabelColor2 = obj89;
        }
        if (i44 &= i37 != 0) {
            placeholderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i27).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i27), 0, 0, 0, 14);
        } else {
            placeholderColor2 = obj91;
        }
        if (i37 &= copy-wmQWz5c$default2 != 0) {
            l5 = copy-wmQWz5c$default2;
        } else {
            l5 = obj93;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i38, obj96, obj97, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:422)");
        } else {
            i20 = obj96;
            i25 = obj97;
        }
        long l7 = l;
        DefaultTextFieldColors textColor2 = new DefaultTextFieldColors(l7, copy-wmQWz5c$default3, l3, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i3, focusedIndicatorColor2, i33, unfocusedIndicatorColor2, i23, errorIndicatorColor2, i14, l4, i7, leadingIconColor4, obj23, leadingIconColor2, i8, errorLeadingIconColor2, i36, trailingIconColor3, obj29, trailingIconColor2, i32, errorTrailingIconColor2, i21, l2, obj35, focusedLabelColor2, obj37, unfocusedLabelColor4, i16, unfocusedLabelColor3, i22, errorLabelColor2, i17, placeholderColor2, obj45, l5, i29, 0);
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
