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
        int i8;
        int i5;
        int i;
        int i6;
        Object outlinedTextFieldShape;
        Object obj;
        int changed3;
        float focusedBorderThickness2;
        boolean traceInProgress2;
        Object obj2;
        int changed;
        float unfocusedBorderThickness2;
        float f3;
        int changed2;
        int i3;
        int skipping;
        int i9;
        int defaultsInvalid;
        int i11;
        float f2;
        boolean z;
        Composer composer2;
        boolean z2;
        int i7;
        Object obj3;
        Object i2;
        float f4;
        float f;
        Composer composer;
        int i4;
        final Object obj4 = this;
        final int i39 = $changed;
        final int i40 = i10;
        anon = 943754022;
        traceInProgress = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(traceInProgress, "C(BorderBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)332@12464L22,336@12648L203,344@12860L47:TextFieldDefaults.kt#jmzs0o");
        $dirty = $changed;
        if (i40 & 1 != 0) {
            $dirty |= 6;
            z = enabled;
        } else {
            if (i39 & 6 == 0) {
                i8 = traceInProgress.changed(enabled) ? 4 : 2;
                $dirty |= i8;
            } else {
                z = enabled;
            }
        }
        if (i40 & 2 != 0) {
            $dirty |= 48;
            z2 = isError;
        } else {
            if (i39 & 48 == 0) {
                i5 = traceInProgress.changed(isError) ? 32 : 16;
                $dirty |= i5;
            } else {
                z2 = isError;
            }
        }
        if (i40 & 4 != 0) {
            $dirty |= 384;
            obj3 = interactionSource;
        } else {
            if (i39 & 384 == 0) {
                i = traceInProgress.changed(interactionSource) ? 256 : 128;
                $dirty |= i;
            } else {
                obj3 = interactionSource;
            }
        }
        if (i40 & 8 != 0) {
            $dirty |= 3072;
            obj = colors;
        } else {
            if (i39 & 3072 == 0) {
                i6 = traceInProgress.changed(colors) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                obj = colors;
            }
        }
        if (i39 & 24576 == 0) {
            if (i40 & 16 == 0) {
                changed3 = traceInProgress.changed(shape) ? 16384 : 8192;
            } else {
                outlinedTextFieldShape = shape;
            }
            $dirty |= changed3;
        } else {
            outlinedTextFieldShape = shape;
        }
        if (i19 &= i39 == 0) {
            if (i40 & 32 == 0) {
                changed = traceInProgress.changed(focusedBorderThickness) ? 131072 : 65536;
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            $dirty |= changed;
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
                i3 = traceInProgress.changed(obj4) ? 8388608 : 4194304;
                $dirty |= i3;
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
                            f4 = focusedBorderThickness2;
                            f = unfocusedBorderThickness2;
                        } else {
                            f4 = focusedBorderThickness2;
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
                            f4 = focusedBorderThickness2;
                            f = unfocusedBorderThickness2;
                        } else {
                            f4 = focusedBorderThickness2;
                            f = unfocusedBorderThickness2;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, $dirty, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:335)");
                }
                composer = traceInProgress;
                BoxKt.Box(BorderKt.border((Modifier)Modifier.Companion, (BorderStroke)TextFieldDefaultsKt.access$animateBorderStrokeAsState-NuRrP5Q(z, z2, obj3, obj, f4, f, composer, i16 | i27).getValue(), outlinedTextFieldShape), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f4;
                f2 = f;
                i7 = $dirty;
                obj2 = outlinedTextFieldShape;
            } else {
                traceInProgress.skipToGroupEnd();
                composer2 = traceInProgress;
                f2 = unfocusedBorderThickness2;
                f3 = focusedBorderThickness2;
                i7 = $dirty;
                obj2 = outlinedTextFieldShape;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new TextFieldDefaults.BorderBox.1(obj4, enabled, isError, interactionSource, colors, obj2, f3, f2, i39, i40);
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
        Object $dirty15;
        Object obj4;
        Object obj11;
        Object obj9;
        Object obj14;
        Object obj10;
        Object obj;
        int changed;
        String $dirty14;
        Object outlinedTextFieldPadding-a9UjIt4$default;
        Function2 rememberComposableLambda;
        boolean traceInProgress2;
        boolean i38;
        boolean $dirty11;
        int $dirty5;
        VisualTransformation i23;
        int i37;
        boolean z2;
        boolean $composer2;
        int $dirty6;
        boolean label2;
        Object $dirty2;
        Object $dirty8;
        int $dirty13;
        Object placeholder2;
        int i32;
        int $dirty1;
        int $dirty12;
        Object obj6;
        int leadingIcon2;
        int obj13;
        Object obj5;
        int trailingIcon2;
        int obj16;
        boolean z;
        int i21;
        int i2;
        Object obj12;
        Object obj3;
        Object obj7;
        int $dirty18;
        Object obj8;
        Object obj15;
        int i;
        Composer i4;
        int changedInstance;
        int $dirty16;
        int i20;
        int i30;
        int i8;
        int i41;
        int i33;
        int i13;
        int i42;
        int $dirty4;
        int i45;
        int i22;
        boolean changed2;
        int i24;
        int $dirty9;
        int i31;
        int i19;
        int i3;
        int i43;
        int i5;
        int i25;
        boolean $dirty;
        int i34;
        int i29;
        int i35;
        int i16;
        int $dirty17;
        int i10;
        int i39;
        int i40;
        int $dirty3;
        int i15;
        int i17;
        int i36;
        int $dirty7;
        int i14;
        Composer composer;
        Composer composer2;
        int i26;
        int i44;
        int i6;
        int i7;
        Object obj2;
        int i9;
        int i27;
        int i11;
        int $dirty10;
        int i28;
        int i12;
        int i46;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj65;
        i38 = $changed;
        $dirty11 = $changed1;
        i23 = i18;
        $composer2 = $composer.startRestartGroup(-1280721485);
        ComposerKt.sourceInformation($composer2, "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)756@34416L25,758@34552L78,773@35068L22,761@34639L549:TextFieldDefaults.kt#jmzs0o");
        $dirty6 = $changed;
        $dirty13 = $changed1;
        if (i23 & 1 != 0) {
            $dirty6 |= 6;
            obj6 = value;
        } else {
            if (i38 & 6 == 0) {
                i2 = $composer2.changed(value) ? 4 : 2;
                $dirty6 |= i2;
            } else {
                obj6 = value;
            }
        }
        if (i23 & 2 != 0) {
            $dirty6 |= 48;
            obj12 = innerTextField;
        } else {
            if (i38 & 48 == 0) {
                i = $composer2.changedInstance(innerTextField) ? 32 : 16;
                $dirty6 |= i;
            } else {
                obj12 = innerTextField;
            }
        }
        $dirty16 = 128;
        if (i23 & 4 != 0) {
            $dirty6 |= 384;
        } else {
            if (i38 & 384 == 0) {
                i37 = $composer2.changed(enabled) ? changedInstance : $dirty16;
                $dirty6 |= i37;
            }
        }
        i8 = 2048;
        if (i23 & 8 != 0) {
            $dirty6 |= 3072;
            z2 = singleLine;
        } else {
            if (i38 & 3072 == 0) {
                i41 = $composer2.changed(singleLine) ? i8 : i20;
                $dirty6 |= i41;
            } else {
                z2 = singleLine;
            }
        }
        i45 = 8192;
        if (i23 & 16 != 0) {
            $dirty6 |= 24576;
            obj5 = visualTransformation;
        } else {
            if (i38 & 24576 == 0) {
                i33 = $composer2.changed(visualTransformation) ? $dirty4 : i45;
                $dirty6 |= i33;
            } else {
                obj5 = visualTransformation;
            }
        }
        int i116 = 196608;
        if (i23 & 32 != 0) {
            $dirty6 |= i116;
        } else {
            if (i38 & i116 == 0) {
                i13 = $composer2.changed(interactionSource) ? 131072 : 65536;
                $dirty6 |= i13;
            }
        }
        i42 = i23 & 64;
        i22 = 1572864;
        if (i42 != 0) {
            $dirty6 |= i22;
            z = isError;
        } else {
            if (i38 & i22 == 0) {
                i24 = $composer2.changed(isError) ? 1048576 : 524288;
                $dirty6 |= i24;
            } else {
                z = isError;
            }
        }
        $dirty18 = i23 & 128;
        $dirty9 = 12582912;
        if ($dirty18 != 0) {
            $dirty6 |= $dirty9;
            obj8 = label;
        } else {
            if (i38 & $dirty9 == 0) {
                i31 = $composer2.changedInstance(label) ? 8388608 : 4194304;
                $dirty6 |= i31;
            } else {
                obj8 = label;
            }
        }
        int i62 = i23 & 256;
        int i119 = 100663296;
        if (i62 != 0) {
            $dirty6 |= i119;
            i19 = i62;
            obj4 = placeholder;
        } else {
            if (i38 & i119 == 0) {
                i19 = i62;
                i3 = $composer2.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty6 |= i3;
            } else {
                i19 = i62;
                obj4 = placeholder;
            }
        }
        int i63 = i23 & 512;
        int i121 = 805306368;
        if (i63 != 0) {
            $dirty6 |= i121;
            i43 = i63;
            obj11 = leadingIcon;
        } else {
            if (i38 & i121 == 0) {
                i43 = i63;
                i5 = $composer2.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty6 |= i5;
            } else {
                i43 = i63;
                obj11 = leadingIcon;
            }
        }
        int i64 = i23 & 1024;
        if (i64 != 0) {
            $dirty13 |= 6;
            i25 = i64;
            obj9 = trailingIcon;
        } else {
            if ($dirty11 & 6 == 0) {
                i25 = i64;
                i22 = $composer2.changedInstance(trailingIcon) ? 4 : 2;
                $dirty13 |= i22;
            } else {
                i25 = i64;
                obj9 = trailingIcon;
            }
        }
        if ($dirty11 & 48 == 0) {
            if (i23 & 2048 == 0) {
                i24 = $composer2.changed(colors) ? 32 : 16;
            } else {
                obj14 = colors;
            }
            $dirty13 |= i24;
        } else {
            obj14 = colors;
        }
        if ($dirty11 & 384 == 0) {
            if (i23 & 4096 == 0) {
                if ($composer2.changed(contentPadding)) {
                } else {
                    changedInstance = $dirty16;
                }
            } else {
                obj10 = contentPadding;
            }
            $dirty13 |= changedInstance;
        } else {
            obj10 = contentPadding;
        }
        rememberComposableLambda = i23 & 8192;
        if (rememberComposableLambda != 0) {
            $dirty13 |= 3072;
            obj = border;
        } else {
            if ($dirty11 & 3072 == 0) {
                if ($composer2.changedInstance(border)) {
                    i20 = i8;
                }
                $dirty13 |= i20;
            } else {
                obj = border;
            }
        }
        if (i23 & 16384 != 0) {
            $dirty13 |= 24576;
        } else {
            if ($dirty11 & 24576 == 0) {
                if ($composer2.changed(this)) {
                } else {
                    $dirty4 = i45;
                }
                $dirty13 |= $dirty4;
            }
        }
        $dirty14 = $dirty13;
        if ($dirty110 &= $dirty6 == 306783378 && $dirty14 & 9363 == 9362) {
            if ($dirty14 & 9363 == 9362) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (i38 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            isError2 = i42 != 0 ? 0 : z;
                            obj2 = $dirty18 != 0 ? i32 : obj8;
                            i9 = i19 != 0 ? i32 : placeholder;
                            i27 = i43 != 0 ? i32 : leadingIcon;
                            i11 = i25 != 0 ? i32 : trailingIcon;
                            if (i23 & 2048 != 0) {
                                int i101 = rememberComposableLambda;
                                composer2 = $composer2;
                                obj8 = i106;
                                changedInstance = obj8;
                                i20 = changedInstance;
                                i42 = i20;
                                i45 = i42;
                                i24 = i45;
                                i19 = i24;
                                i25 = i19;
                                i29 = i25;
                                i16 = i29;
                                i10 = i16;
                                i40 = i10;
                                i15 = i40;
                                i36 = i15;
                                i14 = i36;
                                i28 = i132;
                                i12 = i133;
                                obj65 = isError2;
                                i46 = i134;
                                isError3 = i18;
                                $composer2 = composer2;
                                $dirty1 = $dirty14;
                                $dirty2 = rememberComposableLambda;
                            } else {
                                obj65 = isError2;
                                i12 = rememberComposableLambda;
                                isError3 = i23;
                                i46 = $dirty6;
                                $dirty2 = colors;
                                $dirty1 = $dirty10;
                            }
                            if (isError3 & 4096 != 0) {
                                z = obj65;
                                outlinedTextFieldPadding-a9UjIt4$default = TextFieldDefaults.outlinedTextFieldPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                $dirty1 &= -897;
                            } else {
                                $dirty15 = this;
                                z = obj65;
                                outlinedTextFieldPadding-a9UjIt4$default = contentPadding;
                            }
                            if (i12 != 0) {
                                TextFieldDefaults.OutlinedTextFieldDecorationBox.3 anon = new TextFieldDefaults.OutlinedTextFieldDecorationBox.3(enabled, z, interactionSource, $dirty2);
                                obj7 = outlinedTextFieldPadding-a9UjIt4$default;
                                obj15 = rememberComposableLambda;
                                obj3 = $dirty2;
                                $dirty14 = $dirty1;
                                $dirty8 = obj2;
                                $dirty12 = i9;
                                obj13 = i27;
                                obj16 = i11;
                            } else {
                                i38 = enabled;
                                z2 = interactionSource;
                                obj15 = border;
                                obj7 = outlinedTextFieldPadding-a9UjIt4$default;
                                obj3 = $dirty2;
                                $dirty14 = $dirty1;
                                $dirty8 = obj2;
                                $dirty12 = i9;
                                obj13 = i27;
                                obj16 = i11;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (i23 & 2048 != 0) {
                                $dirty14 &= -113;
                            }
                            if (i23 & 4096 != 0) {
                                i38 = enabled;
                                z2 = interactionSource;
                                $dirty12 = placeholder;
                                obj13 = leadingIcon;
                                obj16 = trailingIcon;
                                obj3 = colors;
                                obj7 = contentPadding;
                                $dirty14 = i49;
                                i46 = $dirty6;
                                $dirty8 = obj8;
                                $dirty15 = this;
                                obj15 = border;
                            } else {
                                $dirty15 = this;
                                i38 = enabled;
                                z2 = interactionSource;
                                $dirty12 = placeholder;
                                obj13 = leadingIcon;
                                obj16 = trailingIcon;
                                obj3 = colors;
                                obj7 = contentPadding;
                                i46 = $dirty6;
                                $dirty8 = obj8;
                                obj15 = border;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i46, $dirty14, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:761)");
                    } else {
                        $dirty5 = i46;
                    }
                    i30 = $dirty14;
                    i34 = $dirty5;
                    i4 = $composer2;
                    $composer2 = z;
                    this.OutlinedTextFieldDecorationBox(value, innerTextField, i38, singleLine, visualTransformation, z2, $composer2, $dirty8, $dirty12, obj13, obj16, $dirty15.getOutlinedTextFieldShape($composer2, i72 &= 14), obj3, obj7, obj15, i4, i57 | i88, i61 | i96, 0);
                    composer = i4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i21 = obj16;
                    trailingIcon2 = obj13;
                    leadingIcon2 = $dirty12;
                    placeholder2 = $dirty8;
                    label2 = $composer2;
                } else {
                    $composer2.skipToGroupEnd();
                    leadingIcon2 = placeholder;
                    trailingIcon2 = leadingIcon;
                    obj3 = colors;
                    obj7 = contentPadding;
                    i30 = $dirty14;
                    composer = $composer2;
                    i34 = $dirty6;
                    label2 = z;
                    placeholder2 = obj8;
                    i21 = trailingIcon;
                    obj15 = border;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldDefaults.OutlinedTextFieldDecorationBox.4(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, label2, placeholder2, leadingIcon2, trailingIcon2, i21, obj3, obj7, obj15, $changed, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final void OutlinedTextFieldDecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> border, Composer $composer, int $changed, int $changed1, int i19) {
        Object obj10;
        Object obj9;
        Object obj4;
        Object obj5;
        Object i12;
        Object obj;
        Object obj13;
        int contentPadding3;
        Object endRestartGroup;
        int defaultsInvalid;
        boolean isError5;
        int isError2;
        Object contentPadding2;
        boolean traceInProgress;
        Composer composer;
        int rememberComposableLambda;
        boolean traceInProgress2;
        int outlinedTextFieldShape;
        int i36;
        boolean z;
        Object obj14;
        int $dirty2;
        int i13;
        Object restartGroup;
        int $dirty9;
        int $dirty12;
        Object obj12;
        boolean z2;
        Object obj3;
        Object obj8;
        boolean field;
        int isError3;
        int i33;
        Object obj7;
        int i;
        int i41;
        int $dirty;
        Object obj11;
        Shape shape2;
        int i4;
        boolean z3;
        androidx.compose.material.TextFieldColors field2;
        PaddingValues isError4;
        boolean z4;
        int i35;
        int changedInstance;
        int i17;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int $dirty8;
        int i26;
        PaddingValues i6;
        int $dirty1;
        androidx.compose.material.TextFieldColors i37;
        int i31;
        int i44;
        int i5;
        int border2;
        Object obj2;
        int $dirty10;
        int i43;
        int i38;
        int i24;
        int i27;
        int $dirty11;
        int i34;
        int i7;
        int i39;
        int i2;
        int $dirty4;
        int $dirty5;
        int i18;
        int i28;
        boolean changedInstance2;
        int i42;
        int $dirty7;
        int i29;
        int i30;
        int i3;
        int $dirty13;
        int i47;
        int i14;
        int i40;
        int $dirty6;
        int i22;
        int i23;
        int i10;
        Composer composer2;
        Composer composer3;
        int $dirty3;
        int i15;
        int i45;
        int i8;
        Object obj6;
        int i9;
        int i16;
        int i20;
        Shape shape3;
        int i46;
        int i32;
        int i11;
        int i21;
        int i25;
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
        i36 = i19;
        restartGroup = $composer.startRestartGroup(-920823490);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldDecorationBox)P(13,4,3,11,14,5,6,7,9,8,12,10,1,2)669@31256L22,670@31314L25,672@31450L85,676@31552L628:TextFieldDefaults.kt#jmzs0o");
        $dirty9 = $changed;
        $dirty12 = $changed1;
        if (i36 & 1 != 0) {
            $dirty9 |= 6;
            obj12 = value;
        } else {
            if (i48 & 6 == 0) {
                i33 = restartGroup.changed(value) ? 4 : 2;
                $dirty9 |= i33;
            } else {
                obj12 = value;
            }
        }
        if (i36 & 2 != 0) {
            $dirty9 |= 48;
            obj7 = innerTextField;
        } else {
            if (i48 & 48 == 0) {
                i4 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty9 |= i4;
            } else {
                obj7 = innerTextField;
            }
        }
        if (i36 & 4 != 0) {
            $dirty9 |= 384;
            z3 = enabled;
        } else {
            if (i48 & 384 == 0) {
                i26 = restartGroup.changed(enabled) ? 256 : changedInstance;
                $dirty9 |= i26;
            } else {
                z3 = enabled;
            }
        }
        i6 = i36 & 8;
        i37 = 2048;
        if (i6 != 0) {
            $dirty9 |= 3072;
            z = singleLine;
        } else {
            if (i48 & 3072 == 0) {
                i31 = restartGroup.changed(singleLine) ? i37 : $dirty1;
                $dirty9 |= i31;
            } else {
                z = singleLine;
            }
        }
        i38 = 8192;
        if (i36 & 16 != 0) {
            $dirty9 |= 24576;
            obj3 = visualTransformation;
        } else {
            if (i48 & 24576 == 0) {
                i44 = restartGroup.changed(visualTransformation) ? i43 : i38;
                $dirty9 |= i44;
            } else {
                obj3 = visualTransformation;
            }
        }
        i24 = 196608;
        if (i36 & 32 != 0) {
            $dirty9 |= i24;
            obj14 = interactionSource;
        } else {
            if (i48 & i24 == 0) {
                i5 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty9 |= i5;
            } else {
                obj14 = interactionSource;
            }
        }
        $dirty10 = i36 & 64;
        i27 = 1572864;
        if ($dirty10 != 0) {
            $dirty9 |= i27;
            field = isError;
        } else {
            if (i48 & i27 == 0) {
                i34 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty9 |= i34;
            } else {
                field = isError;
            }
        }
        $dirty = i36 & 128;
        i7 = 12582912;
        if ($dirty != 0) {
            $dirty9 |= i7;
            obj11 = label;
        } else {
            if (i48 & i7 == 0) {
                i39 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty9 |= i39;
            } else {
                obj11 = label;
            }
        }
        i35 = i36 & 256;
        i2 = 100663296;
        if (i35 != 0) {
            $dirty9 |= i2;
            obj10 = placeholder;
        } else {
            if (i48 & i2 == 0) {
                i2 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty9 |= i2;
            } else {
                obj10 = placeholder;
            }
        }
        int i49 = i36 & 512;
        int i137 = 805306368;
        if (i49 != 0) {
            $dirty9 |= i137;
            $dirty4 = i49;
            obj9 = leadingIcon;
        } else {
            if ($changed & i137 == 0) {
                $dirty4 = i49;
                i18 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty9 |= i18;
            } else {
                $dirty4 = i49;
                obj9 = leadingIcon;
            }
        }
        int i50 = i36 & 1024;
        if (i50 != 0) {
            $dirty12 |= 6;
            i28 = i50;
            obj4 = trailingIcon;
        } else {
            if (i63 & 6 == 0) {
                i28 = i50;
                i27 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty12 |= i27;
            } else {
                i28 = i50;
                obj4 = trailingIcon;
            }
        }
        if (i63 & 48 == 0) {
            if (i36 & 2048 == 0) {
                i34 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj5 = shape;
            }
            $dirty12 |= i34;
        } else {
            obj5 = shape;
        }
        if (i63 & 384 == 0) {
            if (i36 & 4096 == 0) {
                if (restartGroup.changed(colors)) {
                    changedInstance = 256;
                }
            } else {
                i12 = colors;
            }
            $dirty12 |= changedInstance;
        } else {
            i12 = colors;
        }
        if (i63 & 3072 == 0) {
            if (i36 & 8192 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    $dirty1 = i37;
                }
            } else {
                obj = contentPadding;
            }
            $dirty12 |= $dirty1;
        } else {
            obj = contentPadding;
        }
        i13 = i36 & 16384;
        if (i13 != 0) {
            $dirty12 |= 24576;
            obj13 = border;
        } else {
            if (i63 & 24576 == 0) {
                if (restartGroup.changedInstance(border)) {
                } else {
                    i43 = i38;
                }
                $dirty12 |= i43;
            } else {
                obj13 = border;
            }
        }
        if (i36 & i130 != 0) {
            $dirty12 |= i24;
        } else {
            if (i63 & i24 == 0) {
                i17 = restartGroup.changed(traceInProgress) ? 131072 : 65536;
                $dirty12 |= i17;
            }
        }
        if ($dirty9 & $dirty8 == 306783378 && i60 &= $dirty12 == 74898) {
            if (i60 &= $dirty12 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            isError5 = $dirty10 != 0 ? 0 : field;
                            obj6 = $dirty != 0 ? rememberComposableLambda : obj11;
                            i9 = i35 != 0 ? rememberComposableLambda : placeholder;
                            i16 = $dirty4 != 0 ? rememberComposableLambda : leadingIcon;
                            i20 = i28 != 0 ? rememberComposableLambda : trailingIcon;
                            if (i36 & 2048 != 0) {
                                $dirty12 &= -113;
                                shape3 = outlinedTextFieldShape;
                            } else {
                                shape3 = shape;
                            }
                            if (i36 & 4096 != 0) {
                                composer3 = restartGroup;
                                obj11 = $dirty12;
                                i35 = i124;
                                i37 = i35;
                                i43 = -920823490;
                                i24 = i132;
                                i34 = i43;
                                i39 = i24;
                                i28 = i34;
                                i42 = i39;
                                i29 = i28;
                                i3 = i42;
                                i47 = i29;
                                i40 = i3;
                                i22 = i47;
                                i10 = i40;
                                i46 = i147;
                                i21 = i149;
                                obj76 = isError5;
                                i25 = i11;
                                rememberComposableLambda = traceInProgress.outlinedTextFieldColors-dx8h9Zs(0, i36, 0, restartGroup, 0, $dirty12, 0, obj3, 0, obj7, 0, obj11, 0, i35, 0, i6, 0, i37, 0, i43, 0, i24, 0, i34, 0, i39);
                                composer = composer3;
                                $dirty12 = isError2 & -897;
                            } else {
                                obj76 = isError5;
                                i46 = i13;
                                composer = restartGroup;
                                i25 = $dirty9;
                                isError2 = $dirty12;
                                rememberComposableLambda = colors;
                            }
                            if (i36 & 8192 != 0) {
                                contentPadding2 = TextFieldDefaults.outlinedTextFieldPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                $dirty12 &= -7169;
                            } else {
                                contentPadding2 = contentPadding;
                            }
                            if (i46 != 0) {
                                obj69 = obj76;
                                obj71 = rememberComposableLambda;
                                obj67 = anon;
                                obj72 = shape3;
                                super(enabled, obj69, interactionSource, obj71, obj72);
                                i6 = contentPadding2;
                                obj2 = rememberComposableLambda;
                                i37 = i13;
                                $dirty1 = restartGroup;
                                contentPadding3 = $dirty12;
                                z4 = z6;
                                obj8 = obj6;
                                isError3 = i9;
                                i = i16;
                                i41 = i20;
                            } else {
                                obj2 = border;
                                i6 = contentPadding2;
                                i37 = i13;
                                $dirty1 = restartGroup;
                                contentPadding3 = $dirty12;
                                z4 = isError6;
                                obj8 = obj6;
                                isError3 = i9;
                                i = i16;
                                i41 = i20;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i36 & 2048 != 0) {
                                $dirty12 &= -113;
                            }
                            if (i36 & 4096 != 0) {
                                $dirty12 &= -897;
                            }
                            if (i36 & 8192 != 0) {
                                contentPadding3 = $dirty12 & -7169;
                                i = leadingIcon;
                                i41 = trailingIcon;
                                $dirty1 = shape;
                                i37 = colors;
                                i6 = contentPadding;
                                obj2 = border;
                                composer = restartGroup;
                                i25 = $dirty9;
                                z4 = field;
                                obj8 = obj11;
                                isError3 = placeholder;
                            } else {
                                i = leadingIcon;
                                i41 = trailingIcon;
                                $dirty1 = shape;
                                i37 = colors;
                                i6 = contentPadding;
                                obj2 = border;
                                composer = restartGroup;
                                i25 = $dirty9;
                                contentPadding3 = $dirty12;
                                z4 = field;
                                obj8 = obj11;
                                isError3 = placeholder;
                            }
                        }
                    } else {
                    }
                    composer.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-920823490, i25, contentPadding3, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:675)");
                    } else {
                        $dirty2 = i25;
                    }
                    i43 = composer;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, obj8, isError3, i, i41, singleLine, enabled, z4, interactionSource, i6, $dirty1, i37, obj2, i43, i73 | i101, rememberComposableLambda | i111);
                    composer2 = i43;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z4;
                    isError4 = i6;
                    shape2 = $dirty1;
                    field2 = i37;
                    composableLambda = obj2;
                    border2 = contentPadding3;
                } else {
                    restartGroup.skipToGroupEnd();
                    i = leadingIcon;
                    i41 = trailingIcon;
                    field2 = colors;
                    isError4 = contentPadding;
                    composableLambda = border;
                    composer2 = restartGroup;
                    $dirty2 = $dirty9;
                    border2 = $dirty12;
                    z2 = field;
                    obj8 = obj11;
                    isError3 = placeholder;
                    shape2 = shape;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = $dirty2;
            endRestartGroup = new TextFieldDefaults.OutlinedTextFieldDecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z2, obj8, isError3, i, i41, shape2, field2, isError4, composableLambda, $changed, $changed1, i36);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty5 = $dirty2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final void TextFieldDecorationBox(String value, Function2 innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Composer $composer, int $changed, int $changed1, int i17) {
        boolean traceInProgress;
        Object endRestartGroup;
        int defaultsInvalid;
        int $dirty4;
        androidx.compose.material.TextFieldDefaults $dirty13;
        Object obj9;
        Object obj5;
        Object obj6;
        Object obj13;
        Object obj7;
        int changed;
        int contentPadding2;
        PaddingValues textFieldWithLabelPadding-a9UjIt4$default;
        int textFieldColors-dx8h9Zs;
        int i34;
        boolean traceInProgress2;
        int $dirty3;
        int $dirty;
        boolean z;
        Object obj10;
        int $dirty2;
        int $dirty12;
        int i8;
        Object colors2;
        androidx.compose.material.TextFieldColors field;
        Object obj8;
        boolean label2;
        int i41;
        Object $dirty1;
        boolean i20;
        Object placeholder2;
        int i26;
        int i27;
        Object obj2;
        int leadingIcon2;
        int i30;
        int trailingIcon2;
        int i9;
        Object obj11;
        int obj;
        int i18;
        boolean z2;
        Object obj12;
        PaddingValues obj3;
        int i37;
        Composer restartGroup;
        int i42;
        int i10;
        int i4;
        int i28;
        int i13;
        int i5;
        int i39;
        int i6;
        int i23;
        int i12;
        int changed2;
        int i38;
        int i40;
        int i21;
        int i43;
        int i19;
        int i15;
        int i35;
        boolean changedInstance;
        int i33;
        int i14;
        int i36;
        int i44;
        int i25;
        int i45;
        int i11;
        int i22;
        Composer composer;
        Composer composer2;
        int i31;
        int i2;
        int i46;
        int i32;
        boolean z3;
        Object obj4;
        int i7;
        int i24;
        int i29;
        int i;
        int i16;
        int i3;
        ScopeUpdateScope scopeUpdateScope;
        int obj64;
        int i53 = $changed;
        textFieldColors-dx8h9Zs = $changed1;
        $dirty3 = i17;
        restartGroup = $composer.startRestartGroup(1171040065);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)714@32930L17,733@33577L14,721@33156L508:TextFieldDefaults.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if ($dirty3 & 1 != 0) {
            $dirty2 |= 6;
            colors2 = value;
        } else {
            if (i53 & 6 == 0) {
                i27 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i27;
            } else {
                colors2 = value;
            }
        }
        if ($dirty3 & 2 != 0) {
            $dirty2 |= 48;
            obj2 = innerTextField;
        } else {
            if (i53 & 48 == 0) {
                i18 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty2 |= i18;
            } else {
                obj2 = innerTextField;
            }
        }
        if ($dirty3 & 4 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i53 & 384 == 0) {
                i10 = restartGroup.changed(enabled) ? 256 : i42;
                $dirty2 |= i10;
            } else {
                z2 = enabled;
            }
        }
        i4 = $dirty3 & 8;
        int i111 = 2048;
        if (i4 != 0) {
            $dirty2 |= 3072;
            z = singleLine;
        } else {
            if (i53 & 3072 == 0) {
                i5 = restartGroup.changed(singleLine) ? i111 : i28;
                $dirty2 |= i5;
            } else {
                z = singleLine;
            }
        }
        if ($dirty3 & 16 != 0) {
            $dirty2 |= 24576;
            obj8 = visualTransformation;
        } else {
            if (i53 & 24576 == 0) {
                i39 = restartGroup.changed(visualTransformation) ? 16384 : 8192;
                $dirty2 |= i39;
            } else {
                obj8 = visualTransformation;
            }
        }
        int i113 = 196608;
        if ($dirty3 & 32 != 0) {
            $dirty2 |= i113;
            obj10 = interactionSource;
        } else {
            if (i53 & i113 == 0) {
                i6 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                obj10 = interactionSource;
            }
        }
        i23 = $dirty3 & 64;
        i12 = 1572864;
        if (i23 != 0) {
            $dirty2 |= i12;
            i20 = isError;
        } else {
            if (i53 & i12 == 0) {
                i38 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty2 |= i38;
            } else {
                i20 = isError;
            }
        }
        int i107 = $dirty3 & 128;
        i40 = 12582912;
        if (i107 != 0) {
            $dirty2 |= i40;
            obj11 = label;
        } else {
            if (i53 & i40 == 0) {
                i21 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty2 |= i21;
            } else {
                obj11 = label;
            }
        }
        i37 = $dirty3 & 256;
        i43 = 100663296;
        if (i37 != 0) {
            $dirty2 |= i43;
            obj9 = placeholder;
        } else {
            if (i53 & i43 == 0) {
                i43 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty2 |= i43;
            } else {
                obj9 = placeholder;
            }
        }
        int i54 = $dirty3 & 512;
        int i116 = 805306368;
        if (i54 != 0) {
            $dirty2 |= i116;
            i19 = i54;
            obj5 = leadingIcon;
        } else {
            if ($changed & i116 == 0) {
                i19 = i54;
                i15 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty2 |= i15;
            } else {
                i19 = i54;
                obj5 = leadingIcon;
            }
        }
        int i55 = $dirty3 & 1024;
        if (i55 != 0) {
            $dirty12 |= 6;
            i35 = i55;
            obj6 = trailingIcon;
        } else {
            if (textFieldColors-dx8h9Zs & 6 == 0) {
                i35 = i55;
                i12 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty12 |= i12;
            } else {
                i35 = i55;
                obj6 = trailingIcon;
            }
        }
        if (textFieldColors-dx8h9Zs & 48 == 0) {
            if ($dirty3 & 2048 == 0) {
                i38 = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj13 = colors;
            }
            $dirty12 |= i38;
        } else {
            obj13 = colors;
        }
        if (textFieldColors-dx8h9Zs & 384 == 0) {
            if ($dirty3 & 4096 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    i42 = 256;
                }
            } else {
                obj7 = contentPadding;
            }
            $dirty12 |= i42;
        } else {
            obj7 = contentPadding;
        }
        if ($dirty3 & 8192 != 0) {
            $dirty12 |= 3072;
        } else {
            if (textFieldColors-dx8h9Zs & 3072 == 0 && restartGroup.changed(this)) {
                if (restartGroup.changed(obj14)) {
                    i28 = i111;
                }
                $dirty12 |= i28;
            }
        }
        contentPadding2 = $dirty12;
        if ($dirty15 &= $dirty2 == 306783378 && contentPadding2 & 1171 == 1170) {
            if (contentPadding2 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            z3 = i23 != 0 ? defaultsInvalid : i20;
                            obj4 = i107 != 0 ? defaultsInvalid : obj11;
                            i7 = i37 != 0 ? defaultsInvalid : placeholder;
                            i24 = i19 != 0 ? defaultsInvalid : leadingIcon;
                            i29 = i35 != 0 ? defaultsInvalid : trailingIcon;
                            if ($dirty3 & 2048 != 0) {
                                composer2 = restartGroup;
                                i = i129;
                                i3 = i49;
                                $dirty4 = i17;
                                restartGroup = composer2;
                                i41 = contentPadding2;
                                field = textFieldColors-dx8h9Zs;
                            } else {
                                $dirty4 = $dirty3;
                                i3 = $dirty2;
                                i41 = obj64;
                                field = colors;
                            }
                            if ($dirty4 & 4096 != 0) {
                                if (obj4 == null) {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithoutLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                } else {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                }
                                obj3 = textFieldWithLabelPadding-a9UjIt4$default;
                                contentPadding2 = textFieldColors-dx8h9Zs;
                                obj12 = field;
                                colors2 = z3;
                                $dirty1 = obj4;
                                i26 = i7;
                                i30 = i24;
                                i9 = i29;
                            } else {
                                $dirty13 = this;
                                obj3 = contentPadding;
                                obj12 = field;
                                contentPadding2 = i41;
                                colors2 = z3;
                                $dirty1 = obj4;
                                i26 = i7;
                                i30 = i24;
                                i9 = i29;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if ($dirty3 & 2048 != 0) {
                                contentPadding2 &= -113;
                            }
                            if ($dirty3 & 4096 != 0) {
                                i30 = leadingIcon;
                                i9 = trailingIcon;
                                obj12 = colors;
                                obj3 = contentPadding;
                                contentPadding2 = i52;
                                i3 = $dirty2;
                                colors2 = i20;
                                $dirty1 = obj11;
                                $dirty13 = this;
                                i26 = placeholder;
                            } else {
                                $dirty13 = this;
                                i30 = leadingIcon;
                                i9 = trailingIcon;
                                obj12 = colors;
                                obj3 = contentPadding;
                                i3 = $dirty2;
                                colors2 = i20;
                                $dirty1 = obj11;
                                i26 = placeholder;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i3, contentPadding2, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:721)");
                    } else {
                        $dirty = i3;
                    }
                    i13 = contentPadding2;
                    i16 = $dirty;
                    $dirty13.TextFieldDecorationBox(value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, colors2, $dirty1, i26, i30, i9, $dirty13.getTextFieldShape(restartGroup, i63 &= 14), obj12, obj3, restartGroup, i73 | i92, i76 | i98, 0);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj = i9;
                    trailingIcon2 = i30;
                    leadingIcon2 = i26;
                    placeholder2 = $dirty1;
                    label2 = colors2;
                } else {
                    restartGroup.skipToGroupEnd();
                    leadingIcon2 = placeholder;
                    trailingIcon2 = leadingIcon;
                    obj12 = colors;
                    obj3 = contentPadding;
                    i13 = contentPadding2;
                    i16 = $dirty2;
                    label2 = i20;
                    placeholder2 = obj11;
                    composer = restartGroup;
                    obj = trailingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldDefaults.TextFieldDecorationBox.2(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, label2, placeholder2, leadingIcon2, trailingIcon2, obj, obj12, obj3, $changed, $changed1, i17);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public final void TextFieldDecorationBox(String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, boolean enabled, boolean singleLine, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material.TextFieldColors colors, PaddingValues contentPadding, Composer $composer, int $changed, int $changed1, int i18) {
        Object obj2;
        Object obj9;
        Object obj3;
        Object obj7;
        Object i2;
        Object obj4;
        int changed2;
        int contentPadding2;
        int defaultsInvalid;
        boolean isError2;
        int isError4;
        PaddingValues textFieldWithLabelPadding-a9UjIt4$default;
        Object endRestartGroup;
        Object traceInProgress2;
        boolean traceInProgress;
        int i38;
        int textFieldColors-dx8h9Zs;
        int $dirty6;
        int textFieldShape;
        int i42;
        boolean z2;
        Object obj10;
        Composer restartGroup;
        int $dirty4;
        int $dirty16;
        Object obj11;
        boolean z;
        Object obj8;
        Object obj6;
        boolean $dirty7;
        int i19;
        int i14;
        Object obj5;
        int i13;
        int i5;
        int $dirty14;
        Object obj12;
        Shape shape3;
        int i30;
        boolean z3;
        androidx.compose.material.TextFieldColors field;
        boolean z4;
        int i20;
        PaddingValues isError3;
        int $dirty18;
        int i32;
        Object i21;
        int $dirty2;
        androidx.compose.material.TextFieldColors i6;
        int i46;
        int colors2;
        int i17;
        int i11;
        int i33;
        int i23;
        int i35;
        Composer composer2;
        int $dirty3;
        int i44;
        int changed;
        int i9;
        int i;
        int $dirty13;
        int i31;
        int i12;
        int i25;
        int i3;
        boolean changedInstance;
        int $dirty1;
        int i24;
        int i41;
        int i16;
        int $dirty17;
        int i7;
        int i34;
        int i39;
        int $dirty15;
        int i10;
        int i26;
        int i22;
        int $dirty12;
        int i15;
        Composer composer;
        int i40;
        int $dirty5;
        int $dirty;
        int i27;
        int i28;
        Object obj;
        int i43;
        int i29;
        int i36;
        Shape shape2;
        int i37;
        int i45;
        int i8;
        int i4;
        ScopeUpdateScope scopeUpdateScope;
        androidx.compose.material.TextFieldDefaults obj67;
        int obj68;
        int obj69;
        int obj70;
        int obj71;
        int obj72;
        int obj73;
        boolean obj75;
        traceInProgress2 = this;
        int i47 = $changed;
        int i78 = $changed1;
        i42 = i18;
        restartGroup = $composer.startRestartGroup(-1391531252);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldDecorationBox)P(12,3,2,10,13,4,5,6,8,7,11,9)573@25758L14,574@25808L17,582@26042L624:TextFieldDefaults.kt#jmzs0o");
        $dirty4 = $changed;
        $dirty16 = $changed1;
        if (i42 & 1 != 0) {
            $dirty4 |= 6;
            obj11 = value;
        } else {
            if (i47 & 6 == 0) {
                i14 = restartGroup.changed(value) ? 4 : 2;
                $dirty4 |= i14;
            } else {
                obj11 = value;
            }
        }
        if (i42 & 2 != 0) {
            $dirty4 |= 48;
            obj5 = innerTextField;
        } else {
            if (i47 & 48 == 0) {
                i30 = restartGroup.changedInstance(innerTextField) ? 32 : 16;
                $dirty4 |= i30;
            } else {
                obj5 = innerTextField;
            }
        }
        if (i42 & 4 != 0) {
            $dirty4 |= 384;
            z3 = enabled;
        } else {
            if (i47 & 384 == 0) {
                i32 = restartGroup.changed(enabled) ? 256 : $dirty18;
                $dirty4 |= i32;
            } else {
                z3 = enabled;
            }
        }
        i21 = i42 & 8;
        i46 = 2048;
        if (i21 != 0) {
            $dirty4 |= 3072;
            z2 = singleLine;
        } else {
            if (i47 & 3072 == 0) {
                i17 = restartGroup.changed(singleLine) ? i46 : $dirty2;
                $dirty4 |= i17;
            } else {
                z2 = singleLine;
            }
        }
        $dirty3 = 8192;
        if (i42 & 16 != 0) {
            $dirty4 |= 24576;
            obj8 = visualTransformation;
        } else {
            if (i47 & 24576 == 0) {
                i11 = restartGroup.changed(visualTransformation) ? i35 : $dirty3;
                $dirty4 |= i11;
            } else {
                obj8 = visualTransformation;
            }
        }
        final int i144 = 196608;
        if (i42 & 32 != 0) {
            $dirty4 |= i144;
            obj10 = interactionSource;
        } else {
            if (i47 & i144 == 0) {
                i33 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty4 |= i33;
            } else {
                obj10 = interactionSource;
            }
        }
        i23 = i42 & 64;
        i44 = 1572864;
        if (i23 != 0) {
            $dirty4 |= i44;
            $dirty7 = isError;
        } else {
            if (i47 & i44 == 0) {
                i9 = restartGroup.changed(isError) ? 1048576 : 524288;
                $dirty4 |= i9;
            } else {
                $dirty7 = isError;
            }
        }
        $dirty14 = i42 & 128;
        i = 12582912;
        if ($dirty14 != 0) {
            $dirty4 |= i;
            obj12 = label;
        } else {
            if (i47 & i == 0) {
                $dirty13 = restartGroup.changedInstance(label) ? 8388608 : 4194304;
                $dirty4 |= $dirty13;
            } else {
                obj12 = label;
            }
        }
        i20 = i42 & 256;
        i31 = 100663296;
        if (i20 != 0) {
            $dirty4 |= i31;
            obj2 = placeholder;
        } else {
            if (i47 & i31 == 0) {
                i31 = restartGroup.changedInstance(placeholder) ? 67108864 : 33554432;
                $dirty4 |= i31;
            } else {
                obj2 = placeholder;
            }
        }
        int i48 = i42 & 512;
        int i131 = 805306368;
        if (i48 != 0) {
            $dirty4 |= i131;
            i12 = i48;
            obj9 = leadingIcon;
        } else {
            if ($changed & i131 == 0) {
                i12 = i48;
                i25 = restartGroup.changedInstance(leadingIcon) ? 536870912 : 268435456;
                $dirty4 |= i25;
            } else {
                i12 = i48;
                obj9 = leadingIcon;
            }
        }
        int i49 = i42 & 1024;
        if (i49 != 0) {
            $dirty16 |= 6;
            i3 = i49;
            obj3 = trailingIcon;
        } else {
            if (i78 & 6 == 0) {
                i3 = i49;
                i44 = restartGroup.changedInstance(trailingIcon) ? 4 : 2;
                $dirty16 |= i44;
            } else {
                i3 = i49;
                obj3 = trailingIcon;
            }
        }
        if (i78 & 48 == 0) {
            if (i42 & 2048 == 0) {
                i9 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj7 = shape;
            }
            $dirty16 |= i9;
        } else {
            obj7 = shape;
        }
        if (i78 & 384 == 0) {
            if (i42 & 4096 == 0) {
                if (restartGroup.changed(colors)) {
                    $dirty18 = 256;
                }
            } else {
                i2 = colors;
            }
            $dirty16 |= $dirty18;
        } else {
            i2 = colors;
        }
        if (i78 & 3072 == 0) {
            if (i42 & 8192 == 0) {
                if (restartGroup.changed(contentPadding)) {
                    $dirty2 = i46;
                }
            } else {
                obj4 = contentPadding;
            }
            $dirty16 |= $dirty2;
        } else {
            obj4 = contentPadding;
        }
        if (i42 & 16384 != 0) {
            $dirty16 |= 24576;
        } else {
            if (i78 & 24576 == 0) {
                if (restartGroup.changed(traceInProgress2)) {
                } else {
                    i35 = $dirty3;
                }
                $dirty16 |= i35;
            }
        }
        if (i53 &= $dirty4 == 306783378 && $dirty16 & 9363 == 9362) {
            if ($dirty16 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            isError2 = i23 != 0 ? 0 : $dirty7;
                            obj = $dirty14 != 0 ? textFieldColors-dx8h9Zs : obj12;
                            i43 = i20 != 0 ? textFieldColors-dx8h9Zs : placeholder;
                            i29 = i12 != 0 ? textFieldColors-dx8h9Zs : leadingIcon;
                            i36 = i3 != 0 ? textFieldColors-dx8h9Zs : trailingIcon;
                            if (i42 & 2048 != 0) {
                                $dirty16 &= -113;
                                shape2 = textFieldShape;
                            } else {
                                shape2 = shape;
                            }
                            if (i42 & 4096 != 0) {
                                Composer composer3 = restartGroup;
                                obj12 = i119;
                                i20 = obj12;
                                i46 = i125;
                                changed = i46;
                                composer = composer3;
                                i = i128;
                                i12 = i;
                                changedInstance = i12;
                                i24 = changedInstance;
                                i16 = i24;
                                i7 = i16;
                                i39 = i7;
                                i10 = i39;
                                i22 = i10;
                                i15 = i22;
                                i45 = i142;
                                obj75 = isError2;
                                i4 = i8;
                                textFieldColors-dx8h9Zs = traceInProgress2.textFieldColors-dx8h9Zs(0, i42, 0, restartGroup, 0, $dirty16, 0, obj8, 0, obj5, 0, obj12, 0, i20, 0, i21, 0, i46, 0, composer3, 0, changed, 0, i, 0, i12);
                                composer2 = composer;
                                $dirty16 = isError4 & -897;
                            } else {
                                obj75 = isError2;
                                composer2 = restartGroup;
                                i4 = $dirty4;
                                isError4 = $dirty16;
                                textFieldColors-dx8h9Zs = colors;
                            }
                            if (i42 & 8192 != 0) {
                                if (obj == null) {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithoutLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                } else {
                                    textFieldWithLabelPadding-a9UjIt4$default = TextFieldDefaults.textFieldWithLabelPadding-a9UjIt4$default(this, 0, 0, 0, 0, 15, 0);
                                }
                                z4 = obj75;
                                i21 = textFieldWithLabelPadding-a9UjIt4$default;
                                contentPadding2 = traceInProgress2;
                                i6 = textFieldColors-dx8h9Zs;
                                obj6 = obj;
                                i19 = i43;
                                i13 = i29;
                                i5 = i36;
                                $dirty2 = shape2;
                            } else {
                                i21 = contentPadding;
                                z4 = obj75;
                                i6 = textFieldColors-dx8h9Zs;
                                contentPadding2 = $dirty16;
                                obj6 = obj;
                                i19 = i43;
                                i13 = i29;
                                i5 = i36;
                                $dirty2 = shape2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i42 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            if (i42 & 4096 != 0) {
                                $dirty16 &= -897;
                            }
                            if (i42 & 8192 != 0) {
                                contentPadding2 = $dirty16 & -7169;
                                i13 = leadingIcon;
                                i5 = trailingIcon;
                                $dirty2 = shape;
                                i6 = colors;
                                i21 = contentPadding;
                                composer2 = restartGroup;
                                i4 = $dirty4;
                                z4 = $dirty7;
                                obj6 = obj12;
                                i19 = placeholder;
                            } else {
                                i13 = leadingIcon;
                                i5 = trailingIcon;
                                $dirty2 = shape;
                                i6 = colors;
                                i21 = contentPadding;
                                composer2 = restartGroup;
                                i4 = $dirty4;
                                contentPadding2 = $dirty16;
                                z4 = $dirty7;
                                obj6 = obj12;
                                i19 = placeholder;
                            }
                        }
                    } else {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1391531252, i4, contentPadding2, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:581)");
                    } else {
                        $dirty6 = i4;
                    }
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, obj6, i19, i13, i5, singleLine, enabled, z4, interactionSource, i21, $dirty2, i6, 0, composer2, i71 | i100, i77 | obj10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z = z4;
                    isError3 = i21;
                    shape3 = $dirty2;
                    field = i6;
                    colors2 = contentPadding2;
                } else {
                    restartGroup.skipToGroupEnd();
                    i13 = leadingIcon;
                    i5 = trailingIcon;
                    field = colors;
                    isError3 = contentPadding;
                    composer2 = restartGroup;
                    $dirty6 = $dirty4;
                    colors2 = $dirty16;
                    z = $dirty7;
                    obj6 = obj12;
                    i19 = placeholder;
                    shape3 = shape;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty6;
            endRestartGroup = new TextFieldDefaults.TextFieldDecorationBox.1(this, value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z, obj6, i19, i13, i5, shape3, field, isError3, $changed, $changed1, i42);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty = $dirty6;
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
        int disabled;
        boolean traceInProgress;
        int copy-wmQWz5c$default3;
        int iNSTANCE;
        int companion;
        int colors2;
        int colors4;
        int high;
        int disabled5;
        int disabled3;
        androidx.compose.material.Colors colors;
        int i22;
        float disabled2;
        int i32;
        int disabled6;
        int colors3;
        int high2;
        int medium2;
        int disabled4;
        int colors5;
        int medium;
        int copy-wmQWz5c$default2;
        int i28;
        int i8;
        int i3;
        int i12;
        long l5;
        Object consume;
        String copy-wmQWz5c$default;
        Object consume2;
        long l4;
        long unbox-impl;
        long transparent-0d7_KjU;
        long cursorColor2;
        float floatValue;
        int i31;
        long errorCursorColor2;
        int i4;
        int i10;
        long focusedBorderColor2;
        int i27;
        int i7;
        long unfocusedBorderColor2;
        long errorBorderColor2;
        int i30;
        int i24;
        long unfocusedBorderColor3;
        int i18;
        int i23;
        long l3;
        int i9;
        long leadingIconColor2;
        long leadingIconColor4;
        int i35;
        long leadingIconColor3;
        int i14;
        int i16;
        long errorLeadingIconColor2;
        int i20;
        long trailingIconColor3;
        long trailingIconColor2;
        int i11;
        long trailingIconColor4;
        int i;
        int i5;
        long errorTrailingIconColor2;
        int i13;
        long l2;
        long focusedLabelColor2;
        int i21;
        long unfocusedLabelColor4;
        long unfocusedLabelColor3;
        int i25;
        int i17;
        long unfocusedLabelColor2;
        int i34;
        int i33;
        long errorLabelColor2;
        int i6;
        long placeholderColor2;
        int i29;
        long l;
        int i15;
        int i19;
        int i2;
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
            i8 = 6;
            int i47 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i48, copy-wmQWz5c$default);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l5 = copy-wmQWz5c$default3;
        } else {
            l5 = textColor;
        }
        i3 = 6;
        if (i36 & 2 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = backgroundColor;
        }
        if (i36 & 4 != 0) {
            l2 = transparent-0d7_KjU;
        } else {
            l2 = errorCursorColor;
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
            unfocusedBorderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
        } else {
            unfocusedBorderColor2 = trailingIconColor;
        }
        if (i36 & 128 != 0) {
            obj53 = unfocusedBorderColor2;
            unfocusedBorderColor3 = obj53;
            l3 = unfocusedBorderColor2;
        } else {
            unfocusedBorderColor3 = unfocusedBorderColor2;
            l3 = errorTrailingIconColor;
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
            leadingIconColor4 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
            leadingIconColor3 = obj53;
        } else {
            leadingIconColor3 = leadingIconColor2;
            leadingIconColor4 = disabledPlaceholderColor;
        }
        errorLeadingIconColor2 = i36 & 2048 != 0 ? leadingIconColor3 : $changed;
        if (i36 & 4096 != 0) {
            trailingIconColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor3 = $changed2;
        }
        if (i36 & 8192 != 0) {
            obj53 = trailingIconColor3;
            trailingIconColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
            trailingIconColor4 = obj53;
        } else {
            trailingIconColor4 = trailingIconColor3;
            trailingIconColor2 = obj79;
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
            unfocusedLabelColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i3).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i3), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor4 = obj85;
        }
        if (i41 &= i36 != 0) {
            obj53 = unfocusedLabelColor4;
            unfocusedLabelColor3 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i3), 0, 0, 0, 14);
            unfocusedLabelColor2 = obj53;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor4;
            unfocusedLabelColor3 = obj87;
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
        if (i36 &= copy-wmQWz5c$default2 != 0) {
            l = copy-wmQWz5c$default2;
        } else {
            l = obj93;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i37, obj96, obj97, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:480)");
        } else {
            i28 = obj96;
            i12 = obj97;
        }
        long l7 = l5;
        DefaultTextFieldColors textColor2 = new DefaultTextFieldColors(l7, copy-wmQWz5c$default, l4, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i4, focusedBorderColor2, i27, unfocusedBorderColor3, i30, errorBorderColor2, i18, l3, i9, leadingIconColor3, obj23, leadingIconColor4, i14, errorLeadingIconColor2, i20, trailingIconColor4, obj29, trailingIconColor2, i, errorTrailingIconColor2, i13, l2, obj35, focusedLabelColor2, obj37, unfocusedLabelColor2, i25, unfocusedLabelColor3, i34, errorLabelColor2, i6, placeholderColor2, obj45, l, i15, 0);
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
        int copy-wmQWz5c$default3;
        int iNSTANCE;
        int colors5;
        int colors;
        int colors3;
        int high2;
        int i15;
        int disabled4;
        androidx.compose.material.Colors colors6;
        int i17;
        float disabled3;
        int i18;
        int disabled5;
        int colors4;
        int high;
        int medium;
        int disabled;
        int colors2;
        int medium2;
        int copy-wmQWz5c$default;
        int i11;
        int i24;
        int i30;
        int i7;
        long l5;
        Object consume2;
        String copy-wmQWz5c$default2;
        Object consume;
        long l;
        long unbox-impl;
        long copy-wmQWz5c$default4;
        long cursorColor2;
        float floatValue;
        int i8;
        long errorCursorColor2;
        int i20;
        int i25;
        long focusedIndicatorColor2;
        int i29;
        int i28;
        long unfocusedIndicatorColor2;
        long errorIndicatorColor2;
        int i36;
        int i9;
        long unfocusedIndicatorColor3;
        int i35;
        int i32;
        long l3;
        int i12;
        long leadingIconColor3;
        long leadingIconColor4;
        int i;
        long leadingIconColor2;
        int i21;
        int i13;
        long errorLeadingIconColor2;
        int i6;
        long trailingIconColor4;
        long trailingIconColor2;
        int i10;
        long trailingIconColor3;
        int i16;
        int i19;
        long errorTrailingIconColor2;
        int i14;
        long l2;
        long focusedLabelColor2;
        int i27;
        long unfocusedLabelColor2;
        long unfocusedLabelColor4;
        int i22;
        int i23;
        long unfocusedLabelColor3;
        int i5;
        int i2;
        long errorLabelColor2;
        int i3;
        long placeholderColor2;
        int i4;
        long l4;
        int i31;
        int i34;
        int i33;
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
            copy-wmQWz5c$default2 = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i49, copy-wmQWz5c$default2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            i24 = 6;
            int i48 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i49, copy-wmQWz5c$default2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l5 = copy-wmQWz5c$default3;
        } else {
            l5 = textColor;
        }
        i30 = 6;
        if (i37 & 2 != 0) {
            l = copy-wmQWz5c$default2;
        } else {
            l = backgroundColor;
        }
        if (i37 & 4 != 0) {
            l2 = copy-wmQWz5c$default4;
        } else {
            l2 = errorCursorColor;
        }
        if (i37 & 8 != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i30).getPrimary-0d7_KjU();
        } else {
            cursorColor2 = unfocusedIndicatorColor;
        }
        if (i37 & 16 != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i30).getError-0d7_KjU();
        } else {
            errorCursorColor2 = errorIndicatorColor;
        }
        if (i37 & 32 != 0) {
            focusedIndicatorColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i30).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i30), 0, 0, 0, 14);
        } else {
            focusedIndicatorColor2 = disabledLeadingIconColor;
        }
        if (i37 & 64 != 0) {
            unfocusedIndicatorColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i30).getOnSurface-0d7_KjU(), disabledTextColor, 1054280253, 0, 0, 0, 14);
        } else {
            unfocusedIndicatorColor2 = trailingIconColor;
        }
        if (i37 & 128 != 0) {
            obj53 = unfocusedIndicatorColor2;
            unfocusedIndicatorColor3 = obj53;
            l3 = unfocusedIndicatorColor2;
        } else {
            unfocusedIndicatorColor3 = unfocusedIndicatorColor2;
            l3 = errorTrailingIconColor;
        }
        if (i37 & 256 != 0) {
            errorIndicatorColor2 = MaterialTheme.INSTANCE.getColors(composer, i30).getError-0d7_KjU();
        } else {
            errorIndicatorColor2 = unfocusedLabelColor;
        }
        if (i37 & 512 != 0) {
            leadingIconColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i30).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconColor3 = errorLabelColor;
        }
        if (i37 & 1024 != 0) {
            obj53 = leadingIconColor3;
            leadingIconColor4 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i30), 0, 0, 0, 14);
            leadingIconColor2 = obj53;
        } else {
            leadingIconColor2 = leadingIconColor3;
            leadingIconColor4 = disabledPlaceholderColor;
        }
        errorLeadingIconColor2 = i37 & 2048 != 0 ? leadingIconColor2 : $changed;
        if (i37 & 4096 != 0) {
            trailingIconColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i30).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor4 = $changed2;
        }
        if (i37 & 8192 != 0) {
            obj53 = trailingIconColor4;
            trailingIconColor2 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i30), 0, 0, 0, 14);
            trailingIconColor3 = obj53;
        } else {
            trailingIconColor3 = trailingIconColor4;
            trailingIconColor2 = obj79;
        }
        if (i37 & 16384 != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, i30).getError-0d7_KjU();
        } else {
            errorTrailingIconColor2 = obj81;
        }
        if (i40 &= i37 != 0) {
            focusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i30).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i30), 0, 0, 0, 14);
        } else {
            focusedLabelColor2 = obj83;
        }
        if (i41 &= i37 != 0) {
            unfocusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i30).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i30), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor2 = obj85;
        }
        if (i42 &= i37 != 0) {
            obj53 = unfocusedLabelColor2;
            unfocusedLabelColor4 = Color.copy-wmQWz5c$default(obj53, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i30), 0, 0, 0, 14);
            unfocusedLabelColor3 = obj53;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor2;
            unfocusedLabelColor4 = obj87;
        }
        if (i43 &= i37 != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, i30).getError-0d7_KjU();
        } else {
            errorLabelColor2 = obj89;
        }
        if (i44 &= i37 != 0) {
            placeholderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i30).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i30), 0, 0, 0, 14);
        } else {
            placeholderColor2 = obj91;
        }
        if (i37 &= copy-wmQWz5c$default != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = obj93;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i38, obj96, obj97, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:422)");
        } else {
            i11 = obj96;
            i7 = obj97;
        }
        long l7 = l5;
        DefaultTextFieldColors textColor2 = new DefaultTextFieldColors(l7, copy-wmQWz5c$default2, l, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i20, focusedIndicatorColor2, i29, unfocusedIndicatorColor3, i36, errorIndicatorColor2, i35, l3, i12, leadingIconColor2, obj23, leadingIconColor4, i21, errorLeadingIconColor2, i6, trailingIconColor3, obj29, trailingIconColor2, i16, errorTrailingIconColor2, i14, l2, obj35, focusedLabelColor2, obj37, unfocusedLabelColor3, i22, unfocusedLabelColor4, i5, errorLabelColor2, i3, placeholderColor2, obj45, l4, i31, 0);
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
