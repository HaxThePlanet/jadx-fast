package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardActions.Companion;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.KeyboardOptions.Companion;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000®\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0087\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u00132\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010'\u001a\u00020(2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a\u0093\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u00132\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010.\u001a\u00020&2\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010/\u001a\u0087\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u00132\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010'\u001a\u00020(2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a\u0093\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u00132\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010.\u001a\u00020&2\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001aÁ\u0001\u00102\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0002\u0008\u00192\u0019\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f¢\u0006\u0002\u0008\u00192\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0006\u0010$\u001a\u00020\u00132\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u000b0\u000f2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0002\u0008\u00192\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\u0010=\u001aZ\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\u0008G\u0010H\u001aZ\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\u0008O\u0010H\u001a&\u0010P\u001a\u00020\u0011*\u00020\u00112\u0006\u0010Q\u001a\u0002092\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\u0008R\u0010S\u001a|\u0010T\u001a\u00020\u000b*\u00020U2\u0006\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020&2\u0008\u0010X\u001a\u0004\u0018\u00010Y2\u0008\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020Y2\u0008\u0010\\\u001a\u0004\u0018\u00010Y2\u0008\u0010]\u001a\u0004\u0018\u00010Y2\u0006\u0010^\u001a\u00020Y2\u0006\u00106\u001a\u0002072\u0006\u0010$\u001a\u00020\u00132\u0006\u0010F\u001a\u0002072\u0006\u0010_\u001a\u00020`2\u0006\u0010;\u001a\u00020<H\u0002\u001a\u0014\u0010a\u001a\u00020&*\u00020&2\u0006\u0010b\u001a\u00020&H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006c", d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "Landroidx/compose/ui/unit/TextUnit;", "getOutlinedTextFieldTopPadding", "()J", "J", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "border", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-O3s9Psw", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "substractConstraintSafely", "from", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OutlinedTextFieldKt {

    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding;
    private static final long OutlinedTextFieldTopPadding;
    static {
        final int i3 = 0;
        OutlinedTextFieldKt.OutlinedTextFieldInnerPadding = Dp.constructor-impl((float)i);
        OutlinedTextFieldKt.OutlinedTextFieldTopPadding = TextUnitKt.getSp(8);
    }

    public static final void OutlinedTextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj14;
        Object obj2;
        boolean z6;
        Object obj18;
        Object obj10;
        Object obj4;
        boolean z4;
        int i78;
        int i4;
        Object obj12;
        Object obj;
        int $dirty12;
        Object $dirty16;
        Object $dirty13;
        Object endRestartGroup;
        int $dirty4;
        int $dirty5;
        int defaultsInvalid;
        int traceInProgress;
        int rememberedValue;
        Object value2;
        Modifier padding-qDBjuR0$default;
        int $composer3;
        Object $dirty2;
        int $dirty;
        int $dirty3;
        int i63;
        int i6;
        int colors2;
        int default;
        int $dirty17;
        boolean z2;
        int $dirty15;
        Object $dirty14;
        Composer $composer2;
        boolean z;
        Object obj9;
        Object obj7;
        Object obj17;
        boolean field2;
        String enabled3;
        int i16;
        int i31;
        int outlinedTextFieldShape;
        Object enabled2;
        boolean readOnly2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i39;
        Object readOnly3;
        int i17;
        Object obj19;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
        TextStyle merge;
        int i74;
        Object obj13;
        KeyboardOptions i77;
        int keyboardOptions2;
        Object visualTransformation4;
        Object shape3;
        int keyboardActions2;
        int i79;
        int field3;
        int i64;
        VisualTransformation singleLine2;
        int z7;
        int i22;
        KeyboardOptions maxLines2;
        Object obj16;
        int obj3;
        KeyboardActions minLines2;
        Object obj5;
        VisualTransformation i29;
        int visualTransformation2;
        int i72;
        int i50;
        int i44;
        int i73;
        int i58;
        int i25;
        int i21;
        int changed;
        int i65;
        int changed6;
        int i13;
        long $i$a$TakeOrElseDxMtmZcOutlinedTextFieldKt$OutlinedTextField$textColor$2;
        int i75;
        int i49;
        int i40;
        int companion;
        Shape shape2;
        int i60;
        int i23;
        int $dirty1;
        Object field;
        int i37;
        int i30;
        int i66;
        TextStyle textStyle3;
        int i11;
        int i32;
        int i19;
        int i15;
        int changed3;
        int i76;
        int i35;
        int i45;
        int i26;
        int i;
        int i52;
        int i33;
        int changed7;
        int changed5;
        int i2;
        int changed2;
        int i57;
        int i34;
        int i7;
        int i71;
        int i10;
        int i43;
        int i55;
        int i53;
        int i59;
        boolean changed4;
        int i56;
        int i3;
        int i5;
        int i20;
        int i46;
        int i18;
        int i12;
        int i61;
        int i28;
        int i27;
        int i70;
        int i41;
        int i54;
        Composer composer;
        Composer composer2;
        int i68;
        int i67;
        int i36;
        int i47;
        boolean z5;
        boolean z3;
        Object obj8;
        int i8;
        Object obj20;
        Object obj6;
        int i48;
        int obj15;
        int i42;
        VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions3;
        int i9;
        int i14;
        int i62;
        int textStyle2;
        Shape obj11;
        int i38;
        int i69;
        int i51;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions3;
        Object obj74;
        int obj75;
        int obj76;
        int obj77;
        int obj78;
        int obj79;
        int obj80;
        int obj81;
        int obj82;
        int obj83;
        int obj84;
        Shape obj85;
        androidx.compose.material.TextFieldColors obj86;
        boolean obj87;
        Object obj88;
        TextStyle obj89;
        Object obj90;
        int obj92;
        int i80 = $changed;
        int i91 = $changed1;
        traceInProgress = i24;
        Composer restartGroup = $composer.startRestartGroup(237745923);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)351@17754L7,364@18398L22,365@18470L25,375@18903L7,392@19562L38,401@19929L20,409@20271L930,378@18959L2248:OutlinedTextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty15 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty |= 6;
            obj9 = value;
        } else {
            if (i80 & 6 == 0) {
                i17 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i17;
            } else {
                obj9 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty |= 48;
            obj19 = onValueChange;
        } else {
            if (i80 & 48 == 0) {
                i79 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i79;
            } else {
                obj19 = onValueChange;
            }
        }
        i64 = traceInProgress & 4;
        if (i64 != 0) {
            $dirty |= 384;
            obj5 = modifier;
        } else {
            if (i80 & 384 == 0) {
                i72 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i72;
            } else {
                obj5 = modifier;
            }
        }
        i50 = traceInProgress & 8;
        changed = 1024;
        if (i50 != 0) {
            $dirty |= 3072;
            field2 = enabled;
        } else {
            if (i80 & 3072 == 0) {
                i40 = restartGroup.changed(enabled) ? i73 : changed;
                $dirty |= i40;
            } else {
                field2 = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty |= 24576;
            readOnly2 = readOnly;
        } else {
            if (i80 & 24576 == 0) {
                i11 = restartGroup.changed(readOnly) ? 16384 : i60;
                $dirty |= i11;
            } else {
                readOnly2 = readOnly;
            }
        }
        if (i80 & i183 == 0) {
            if (traceInProgress & 32 == 0) {
                changed3 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj13 = textStyle;
            }
            $dirty |= changed3;
        } else {
            obj13 = textStyle;
        }
        i76 = traceInProgress & 64;
        i35 = 1572864;
        i2 = 524288;
        if (i76 != 0) {
            $dirty |= i35;
            visualTransformation4 = label;
        } else {
            if (i80 & i35 == 0) {
                i57 = restartGroup.changedInstance(label) ? 1048576 : i2;
                $dirty |= i57;
            } else {
                visualTransformation4 = label;
            }
        }
        i22 = traceInProgress & 128;
        i34 = 12582912;
        if (i22 != 0) {
            $dirty |= i34;
            obj16 = placeholder;
        } else {
            if (i80 & i34 == 0) {
                i71 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i71;
            } else {
                obj16 = placeholder;
            }
        }
        int i81 = traceInProgress & 256;
        int i193 = 100663296;
        if (i81 != 0) {
            $dirty |= i193;
            i10 = i81;
            obj14 = leadingIcon;
        } else {
            if ($changed & i193 == 0) {
                i10 = i81;
                i43 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i43;
            } else {
                i10 = i81;
                obj14 = leadingIcon;
            }
        }
        int i82 = traceInProgress & 512;
        int i195 = 805306368;
        if (i82 != 0) {
            $dirty |= i195;
            i55 = i82;
            obj2 = trailingIcon;
        } else {
            if ($changed & i195 == 0) {
                i55 = i82;
                i53 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i53;
            } else {
                i55 = i82;
                obj2 = trailingIcon;
            }
        }
        int i83 = traceInProgress & 1024;
        if (i83 != 0) {
            $dirty15 |= 6;
            i59 = i83;
            z6 = isError;
        } else {
            if (i91 & 6 == 0) {
                i59 = i83;
                i37 = restartGroup.changed(isError) ? 4 : 2;
                $dirty15 |= i37;
            } else {
                i59 = i83;
                z6 = isError;
            }
        }
        int i84 = traceInProgress & 2048;
        if (i84 != 0) {
            $dirty15 |= 48;
            i30 = i84;
            obj18 = visualTransformation;
        } else {
            if (i91 & 48 == 0) {
                i30 = i84;
                changed2 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty15 |= changed2;
            } else {
                i30 = i84;
                obj18 = visualTransformation;
            }
        }
        int i85 = traceInProgress & 4096;
        if (i85 != 0) {
            $dirty15 |= 384;
            i19 = i85;
            obj10 = keyboardOptions;
        } else {
            i19 = i85;
            if (i91 & 384 == 0) {
                i57 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty15 |= i57;
            } else {
                obj10 = keyboardOptions;
            }
        }
        if (i91 & 3072 == 0) {
            if (traceInProgress & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i73 = changed;
                }
            } else {
                obj4 = keyboardActions;
            }
            $dirty15 |= i73;
        } else {
            obj4 = keyboardActions;
        }
        int i88 = traceInProgress & 16384;
        if (i88 != 0) {
            $dirty15 |= 24576;
            i58 = i88;
            z4 = singleLine;
        } else {
            i58 = i88;
            if (i91 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i60 = 16384;
                }
                $dirty15 |= i60;
            } else {
                z4 = singleLine;
            }
        }
        if (i91 & i173 == 0) {
            if (traceInProgress & i174 == 0) {
                i65 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i78 = maxLines;
            }
            $dirty15 |= i65;
        } else {
            i78 = maxLines;
        }
        i13 = traceInProgress & i175;
        if (i13 != 0) {
            $dirty15 |= i35;
            i4 = minLines;
        } else {
            if (i91 & i35 == 0) {
                i60 = restartGroup.changed(minLines) ? 1048576 : i2;
                $dirty15 |= i60;
            } else {
                i4 = minLines;
            }
        }
        i23 = traceInProgress & i179;
        if (i23 != 0) {
            $dirty15 |= i34;
            obj12 = interactionSource;
        } else {
            if (i91 & i34 == 0) {
                i35 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty15 |= i35;
            } else {
                obj12 = interactionSource;
            }
        }
        if (i91 & i186 == 0) {
            if (traceInProgress & i189 == 0) {
                i45 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj = shape;
            }
            $dirty15 |= i45;
        } else {
            obj = shape;
        }
        if (i91 & i187 == 0) {
            if (traceInProgress & i2 == 0) {
                obj92 = $dirty15;
                i33 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj92 = $dirty15;
                $dirty14 = colors;
            }
            $dirty12 = i26;
        } else {
            $dirty14 = colors;
            $dirty12 = obj92;
        }
        obj92 = $dirty;
        if ($dirty & i == 306783378 && i93 &= $dirty12 == 306783378) {
            if (i93 &= $dirty12 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i111 = 6;
                    int i114 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i64 != 0) {
                                $dirty4 = Modifier.Companion;
                            } else {
                                $dirty4 = obj5;
                            }
                            z5 = i50 != 0 ? field2 : field2;
                            z3 = companion != 0 ? field2 : readOnly2;
                            if (traceInProgress & 32 != 0) {
                                readOnly2 = 6;
                                i64 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj8 = default;
                                i8 = i16;
                            } else {
                                i50 = default;
                                i8 = obj92;
                                obj8 = obj13;
                            }
                            obj20 = i76 != 0 ? default : visualTransformation4;
                            obj6 = i22 != 0 ? default : obj16;
                            i48 = i10 != 0 ? default : leadingIcon;
                            obj15 = i55 != 0 ? default : trailingIcon;
                            i42 = i59 != 0 ? default : isError;
                            if (i30 != 0) {
                                visualTransformation3 = default;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i19 != 0) {
                                keyboardOptions3 = default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (traceInProgress & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty17 = $dirty18;
                                $dirty13 = keyboardActions3;
                            } else {
                                $dirty17 = $dirty12;
                                $dirty13 = keyboardActions;
                            }
                            i9 = i58 != 0 ? i16 : singleLine;
                            if (i133 &= traceInProgress != 0) {
                                i31 = i9 != 0 ? i114 : 0x7fffffff /* Unknown resource */;
                                $dirty17 &= i50;
                                i14 = i31;
                            } else {
                                i14 = maxLines;
                            }
                            i62 = i13 != 0 ? i31 : minLines;
                            textStyle2 = i23 != 0 ? i31 : interactionSource;
                            if (i134 &= traceInProgress != 0) {
                                obj11 = outlinedTextFieldShape;
                                i38 = $dirty17;
                            } else {
                                obj11 = shape;
                                i38 = $dirty17;
                            }
                            if (traceInProgress & i2 != 0) {
                                int i148 = i114;
                                int i157 = i135;
                                int i163 = i157;
                                int i166 = i158;
                                i50 = i166;
                                i13 = i50;
                                i23 = i13;
                                i19 = i23;
                                i = i19;
                                changed2 = i;
                                i34 = changed2;
                                i10 = i34;
                                i59 = i10;
                                i56 = i59;
                                i5 = i56;
                                i46 = i5;
                                i12 = i46;
                                i28 = i12;
                                i70 = i28;
                                i54 = i70;
                                int i207 = i205;
                                composer = restartGroup;
                                int $composer5 = i51;
                                $composer2 = composer;
                                shape3 = $dirty13;
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = i131;
                                field2 = z5;
                                readOnly2 = z3;
                                $dirty16 = obj8;
                                $composer3 = i8;
                                i29 = visualTransformation3;
                                i77 = keyboardOptions3;
                                field3 = i9;
                                z7 = i14;
                                obj3 = i62;
                                obj7 = outlinedTextFieldColors-dx8h9Zs;
                                colors2 = i42;
                            } else {
                                $composer2 = restartGroup;
                                int $composer4 = i114;
                                obj7 = colors;
                                shape3 = $dirty13;
                                field2 = z5;
                                readOnly2 = z3;
                                $dirty16 = obj8;
                                $composer3 = i8;
                                colors2 = i42;
                                i29 = visualTransformation3;
                                i77 = keyboardOptions3;
                                field3 = i9;
                                z7 = i14;
                                obj3 = i62;
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = i38;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty5 = traceInProgress & 32 != 0 ? obj92 & default : obj92;
                            if (traceInProgress & 8192 != 0) {
                                $dirty12 &= -7169;
                            }
                            if (i161 &= traceInProgress != 0) {
                                $dirty12 &= default;
                            }
                            if (i99 &= traceInProgress != 0) {
                                $dirty12 &= i63;
                            }
                            if (traceInProgress & i2 != 0) {
                                $dirty12 &= i6;
                            }
                            i48 = leadingIcon;
                            obj15 = trailingIcon;
                            colors2 = isError;
                            field3 = singleLine;
                            z7 = maxLines;
                            textStyle2 = interactionSource;
                            obj11 = shape;
                            obj7 = colors;
                            $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = $dirty12;
                            $composer2 = restartGroup;
                            $dirty16 = obj13;
                            obj20 = visualTransformation4;
                            obj6 = obj16;
                            i77 = keyboardOptions;
                            shape3 = keyboardActions;
                            obj3 = minLines;
                            $composer3 = $dirty5;
                            $dirty4 = obj5;
                            i29 = visualTransformation;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj87 = readOnly2;
                        ComposerKt.traceEventStart(237745923, $composer3, $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:366)");
                    } else {
                        obj87 = readOnly2;
                    }
                    if (textStyle2 == 0) {
                        $composer2.startReplaceGroup(-579730026);
                        ComposerKt.sourceInformation($composer2, "368@18581L39");
                        ComposerKt.sourceInformationMarkerStart($composer2, 674035692, "CC(remember):OutlinedTextField.kt#9igjgp");
                        readOnly2 = $composer2;
                        int i171 = 0;
                        obj74 = i97;
                        rememberedValue = readOnly2.rememberedValue();
                        i13 = 0;
                        $dirty1 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i154 = 0;
                            readOnly2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                        i25 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                    } else {
                        $dirty1 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                        $composer2.startReplaceGroup(674035041);
                        $composer2.endReplaceGroup();
                        i25 = textStyle2;
                    }
                    $composer2.startReplaceGroup(674040799);
                    ComposerKt.sourceInformation($composer2, "*371@18768L18");
                    i66 = 0;
                    i15 = Long.compare($i$a$TakeOrElseDxMtmZcOutlinedTextFieldKt$OutlinedTextField$textColor$2, i184) != 0 ? 1 : 0;
                    if (i15 != 0) {
                    } else {
                        int i176 = 0;
                        obj74 = value2;
                        $this$takeOrElse_u2dDxMtmZc$iv = $i$a$TakeOrElseDxMtmZcOutlinedTextFieldKt$OutlinedTextField$textColor$2;
                    }
                    $composer2.endReplaceGroup();
                    long l = $this$takeOrElse_u2dDxMtmZc$iv;
                    textStyle3 = new TextStyle(l, i76, 0, i2, 0, 0, 0, 0, 0, 0, i59, 0, 0, 0, 0, i20, 0, 0, 0, 0, 0, 0, i70, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    long l2 = l;
                    merge = $dirty16.merge(textStyle3);
                    i39 = 0;
                    i75 = 0;
                    obj76 = field2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (obj20 != null) {
                        obj74 = i147;
                        obj89 = merge;
                        padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SemanticsModifierKt.semantics((Modifier)Modifier.Companion, true, (Function1)OutlinedTextFieldKt.OutlinedTextField.7.INSTANCE), 0, (Density)consume.toDp-GaN1DYA(OutlinedTextFieldKt.OutlinedTextFieldTopPadding), 0, 0, 13, 0);
                    } else {
                        obj89 = merge;
                        padding-qDBjuR0$default = Modifier.Companion;
                    }
                    i151 &= 112;
                    obj90 = consume;
                    SolidColor solidColor = new SolidColor((Color)obj7.cursorColor(colors2, $composer2, i139 |= i152).getValue().unbox-impl(), i152, 0);
                    obj74 = anon;
                    obj80 = colors2;
                    obj86 = obj7;
                    super(value, obj76, field3, i29, i25, obj80, obj20, obj6, i48, obj15, obj11, obj86);
                    boolean z8 = obj76;
                    boolean z9 = obj87;
                    i69 = $dirty1;
                    Composer $dirty110 = $composer2;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics($dirty4.then(padding-qDBjuR0$default), colors2, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), z8, z9, obj89, i77, shape3, field3, z7, obj3, i29, 0, i25, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-1001528775, true, obj74, $composer2, 54), $dirty110, i106 | i127, i109 | i129, 4096);
                    composer2 = $dirty110;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation2 = field3;
                    singleLine2 = visualTransformation5;
                    obj17 = obj88;
                    field = $dirty12;
                    i52 = $composer3;
                    z2 = z8;
                    z = z9;
                    i44 = z7;
                    i21 = obj3;
                    enabled2 = obj20;
                    readOnly3 = obj6;
                    i74 = i48;
                    i49 = textStyle2;
                    shape2 = obj11;
                    $dirty2 = $dirty4;
                    maxLines2 = i77;
                    minLines2 = shape3;
                    keyboardOptions2 = obj15;
                    keyboardActions2 = i42;
                } else {
                    restartGroup.skipToGroupEnd();
                    i74 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i44 = maxLines;
                    i21 = minLines;
                    i49 = interactionSource;
                    shape2 = shape;
                    i52 = obj92;
                    i69 = $dirty12;
                    composer2 = restartGroup;
                    field = $dirty14;
                    z2 = field2;
                    z = readOnly2;
                    obj17 = obj13;
                    enabled2 = visualTransformation4;
                    readOnly3 = obj16;
                    $dirty2 = obj5;
                    keyboardOptions2 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation2 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.10(value, onValueChange, $dirty2, z2, z, obj17, enabled2, readOnly3, i74, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation2, i44, i21, i49, shape2, field, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void OutlinedTextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj17;
        Object obj21;
        boolean z7;
        Object obj22;
        Object obj6;
        Object obj3;
        boolean z6;
        int i;
        Object obj7;
        Object obj13;
        int keyboardActions2;
        Object $dirty15;
        Object endRestartGroup;
        int modifier4;
        int defaultsInvalid;
        Object modifier2;
        int i9;
        int i51;
        int i24;
        int i32;
        Object outlinedTextFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer2;
        int $dirty2;
        int $dirty;
        int $dirty13;
        int this_$iv;
        int $dirty1;
        boolean z4;
        int $dirty14;
        Object $dirty12;
        boolean z5;
        Object obj9;
        Object obj20;
        Object modifier3;
        boolean invalid$iv;
        int outlinedTextFieldShape;
        Object enabled2;
        boolean z2;
        Object readOnly2;
        int i10;
        Object obj14;
        Object obj16;
        int textStyle2;
        Object obj12;
        Object obj11;
        int label2;
        Object rememberedValue;
        Object obj2;
        int placeholder2;
        int i45;
        int i42;
        int consume;
        VisualTransformation leadingIcon2;
        int i27;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11;
        KeyboardOptions trailingIcon2;
        Object obj8;
        int i55;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation2;
        int visualTransformation3;
        int i2;
        KeyboardOptions keyboardOptions4;
        int keyboardOptions2;
        int i29;
        int i28;
        KeyboardActions keyboardActions4;
        Object keyboardActions3;
        int changed4;
        int i43;
        Shape singleLine2;
        int i36;
        int i21;
        Object maxLines2;
        int i6;
        int i30;
        int i48;
        int i41;
        int i44;
        int changed3;
        int i54;
        Object i14;
        int changed5;
        int i40;
        int i5;
        int i18;
        Object obj;
        int colors2;
        int i31;
        int i19;
        int i4;
        int i57;
        int i38;
        int changed6;
        int i8;
        int changed;
        int i16;
        int i46;
        int i20;
        int i25;
        int i35;
        int i53;
        int i26;
        int i56;
        boolean changed2;
        int i49;
        int i7;
        int i11;
        int i22;
        int i52;
        Composer $composer3;
        int i3;
        int i34;
        int i50;
        int i33;
        boolean z3;
        boolean z;
        Object obj15;
        int i47;
        Object obj5;
        Object obj18;
        int i17;
        int i37;
        int i15;
        Object obj10;
        KeyboardOptions keyboardOptions3;
        int i13;
        int i12;
        Object obj19;
        Object obj4;
        int i39;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions5;
        KeyboardActions obj73;
        int obj74;
        int obj75;
        int obj76;
        int obj77;
        int obj78;
        int obj79;
        int obj80;
        int obj81;
        int obj90;
        int i58 = $changed;
        int i69 = $changed1;
        i32 = i23;
        outlinedTextFieldColors-dx8h9Zs = $composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation(outlinedTextFieldColors-dx8h9Zs, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)449@21584L7,460@22138L39,461@22216L22,462@22288L25,464@22322L416:OutlinedTextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty14 = $changed1;
        if (i32 & 1 != 0) {
            $dirty2 |= 6;
            obj9 = value;
        } else {
            if (i58 & 6 == 0) {
                i10 = outlinedTextFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty2 |= i10;
            } else {
                obj9 = value;
            }
        }
        if (i32 & 2 != 0) {
            $dirty2 |= 48;
            obj14 = onValueChange;
        } else {
            if (i58 & 48 == 0) {
                i45 = outlinedTextFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i45;
            } else {
                obj14 = onValueChange;
            }
        }
        consume = i32 & 4;
        if (consume != 0) {
            $dirty2 |= 384;
            str = modifier;
        } else {
            if (i58 & 384 == 0) {
                i2 = outlinedTextFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                str = modifier;
            }
        }
        int i143 = i32 & 8;
        changed4 = 1024;
        if (i143 != 0) {
            $dirty2 |= 3072;
            invalid$iv = enabled;
        } else {
            if (i58 & 3072 == 0) {
                i36 = outlinedTextFieldColors-dx8h9Zs.changed(enabled) ? i29 : changed4;
                $dirty2 |= i36;
            } else {
                invalid$iv = enabled;
            }
        }
        int i147 = i32 & 16;
        i48 = 8192;
        if (i147 != 0) {
            $dirty2 |= 24576;
            z2 = readOnly;
        } else {
            if (i58 & 24576 == 0) {
                i18 = outlinedTextFieldColors-dx8h9Zs.changed(readOnly) ? i6 : i48;
                $dirty2 |= i18;
            } else {
                z2 = readOnly;
            }
        }
        int i151 = 196608;
        i57 = 65536;
        i38 = 131072;
        if (i58 & i151 == 0) {
            if (i32 & 32 == 0) {
                changed6 = outlinedTextFieldColors-dx8h9Zs.changed(textStyle) ? i38 : i57;
            } else {
                obj12 = textStyle;
            }
            $dirty2 |= changed6;
        } else {
            obj12 = textStyle;
        }
        i8 = i32 & 64;
        final int i160 = 1572864;
        if (i8 != 0) {
            $dirty2 |= i160;
            rememberedValue = label;
        } else {
            if (i58 & i160 == 0) {
                i16 = outlinedTextFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= i16;
            } else {
                rememberedValue = label;
            }
        }
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 = i32 & 128;
        final int i154 = 12582912;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 != 0) {
            $dirty2 |= i154;
            obj8 = placeholder;
        } else {
            if (i58 & i154 == 0) {
                i20 = outlinedTextFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i20;
            } else {
                obj8 = placeholder;
            }
        }
        int i59 = i32 & 256;
        int i155 = 100663296;
        if (i59 != 0) {
            $dirty2 |= i155;
            i25 = i59;
            obj17 = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i25 = i59;
                i35 = outlinedTextFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i35;
            } else {
                i25 = i59;
                obj17 = leadingIcon;
            }
        }
        int i60 = i32 & 512;
        int i157 = 805306368;
        if (i60 != 0) {
            $dirty2 |= i157;
            i53 = i60;
            obj21 = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                i53 = i60;
                i26 = outlinedTextFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i26;
            } else {
                i53 = i60;
                obj21 = trailingIcon;
            }
        }
        int i61 = i32 & 1024;
        if (i61 != 0) {
            $dirty14 |= 6;
            i56 = i61;
            z7 = isError;
        } else {
            if (i69 & 6 == 0) {
                i56 = i61;
                i40 = outlinedTextFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty14 |= i40;
            } else {
                i56 = i61;
                z7 = isError;
            }
        }
        int i62 = i32 & 2048;
        if (i62 != 0) {
            $dirty14 |= 48;
            i5 = i62;
            obj22 = visualTransformation;
        } else {
            if (i69 & 48 == 0) {
                i5 = i62;
                changed = outlinedTextFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty14 |= changed;
            } else {
                i5 = i62;
                obj22 = visualTransformation;
            }
        }
        int i63 = i32 & 4096;
        if (i63 != 0) {
            $dirty14 |= 384;
            i19 = i63;
            obj6 = keyboardOptions;
        } else {
            i19 = i63;
            if (i69 & 384 == 0) {
                i16 = outlinedTextFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty14 |= i16;
            } else {
                obj6 = keyboardOptions;
            }
        }
        if (i69 & 3072 == 0) {
            if (i32 & 8192 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i29 = changed4;
                }
            } else {
                obj3 = keyboardActions;
            }
            $dirty14 |= i29;
        } else {
            obj3 = keyboardActions;
        }
        int i66 = i32 & 16384;
        if (i66 != 0) {
            $dirty14 |= 24576;
            i28 = i66;
            z6 = singleLine;
        } else {
            i28 = i66;
            if (i69 & 24576 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i6 = i48;
                }
                $dirty14 |= i6;
            } else {
                z6 = singleLine;
            }
        }
        int i146 = i32 & i145;
        if (i146 != 0) {
            $dirty14 |= i151;
            i = maxLines;
        } else {
            if (i69 & i151 == 0) {
                i6 = outlinedTextFieldColors-dx8h9Zs.changed(maxLines) ? i38 : i57;
                $dirty14 |= i6;
            } else {
                i = maxLines;
            }
        }
        i30 = i32 & i57;
        if (i30 != 0) {
            $dirty14 |= i160;
            obj7 = interactionSource;
        } else {
            if (i69 & i160 == 0) {
                i48 = outlinedTextFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty14 |= i48;
            } else {
                obj7 = interactionSource;
            }
        }
        if (i69 & i154 == 0) {
            if (i32 & i38 == 0) {
                i41 = outlinedTextFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj13 = shape;
            }
            $dirty14 |= i41;
        } else {
            obj13 = shape;
        }
        int i152 = 262144;
        if (i69 & i155 == 0) {
            if (i32 & i152 == 0) {
                obj90 = $dirty14;
                i44 = outlinedTextFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty14;
                $dirty12 = colors;
            }
            keyboardActions2 = i54;
        } else {
            $dirty12 = colors;
            keyboardActions2 = obj90;
        }
        obj90 = $dirty2;
        if ($dirty2 & i14 == 306783378 && i71 &= keyboardActions2 == 38347922) {
            if (i71 &= keyboardActions2 == 38347922) {
                if (!outlinedTextFieldColors-dx8h9Zs.getSkipping()) {
                    outlinedTextFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (outlinedTextFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = str;
                            }
                            z3 = i143 != 0 ? $dirty : invalid$iv;
                            z = i147 != 0 ? $dirty : z2;
                            if (i32 & 32 != 0) {
                                int i129 = 6;
                                z2 = 0;
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj15 = this_$iv;
                                i47 = invalid$iv;
                            } else {
                                i47 = obj90;
                                obj15 = obj12;
                            }
                            obj5 = i8 != 0 ? this_$iv : rememberedValue;
                            obj18 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 != 0 ? this_$iv : obj8;
                            i17 = i25 != 0 ? this_$iv : leadingIcon;
                            i37 = i53 != 0 ? this_$iv : trailingIcon;
                            i15 = i56 != 0 ? this_$iv : isError;
                            if (i5 != 0) {
                                obj10 = this_$iv;
                            } else {
                                obj10 = visualTransformation;
                            }
                            if (i19 != 0) {
                                keyboardOptions3 = this_$iv;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i32 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty1 = $dirty16;
                                $dirty15 = keyboardActions5;
                            } else {
                                $dirty1 = keyboardActions2;
                                $dirty15 = keyboardActions;
                            }
                            i13 = i28 != 0 ? invalid$iv : singleLine;
                            i12 = i146 != 0 ? invalid$iv : maxLines;
                            if (i30 != 0) {
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 674149516, "CC(remember):OutlinedTextField.kt#9igjgp");
                                int i128 = 0;
                                z2 = outlinedTextFieldColors-dx8h9Zs;
                                obj12 = 0;
                                rememberedValue = z2.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i140 = 0;
                                    z2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj19 = invalid$iv;
                            } else {
                                obj19 = interactionSource;
                            }
                            if (i32 & i38 != 0) {
                                obj4 = outlinedTextFieldShape;
                                i39 = $dirty1;
                            } else {
                                obj4 = shape;
                                i39 = $dirty1;
                            }
                            if (i32 & i152 != 0) {
                                keyboardActions4 = $dirty15;
                                obj20 = modifier2;
                                obj = outlinedTextFieldColors-dx8h9Zs;
                                keyboardActions2 = $dirty13;
                                invalid$iv = z3;
                                z2 = z;
                                obj16 = obj15;
                                modifier4 = i47;
                                obj11 = obj5;
                                obj2 = obj18;
                                i42 = i17;
                                i27 = i37;
                                i55 = i15;
                                visualTransformation2 = obj10;
                                keyboardOptions4 = keyboardOptions3;
                                i43 = i13;
                                i21 = i12;
                                i14 = obj19;
                                i5 = obj4;
                            } else {
                                $composer3 = outlinedTextFieldColors-dx8h9Zs;
                                obj = colors;
                                keyboardActions4 = $dirty15;
                                obj20 = modifier2;
                                invalid$iv = z3;
                                z2 = z;
                                obj16 = obj15;
                                modifier4 = i47;
                                obj11 = obj5;
                                obj2 = obj18;
                                i42 = i17;
                                i27 = i37;
                                i55 = i15;
                                visualTransformation2 = obj10;
                                keyboardOptions4 = keyboardOptions3;
                                i43 = i13;
                                i21 = i12;
                                i14 = obj19;
                                i5 = obj4;
                                keyboardActions2 = i39;
                            }
                        } else {
                            outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty13 = i32 & 32 != 0 ? obj90 & i9 : obj90;
                            if (i32 & 8192 != 0) {
                                keyboardActions2 &= -7169;
                            }
                            if (i32 & i38 != 0) {
                                keyboardActions2 &= i51;
                            }
                            if (i32 & i152 != 0) {
                                keyboardActions2 &= i24;
                            }
                            i42 = leadingIcon;
                            i27 = trailingIcon;
                            keyboardOptions4 = keyboardOptions;
                            keyboardActions4 = keyboardActions;
                            i43 = singleLine;
                            i21 = maxLines;
                            i14 = interactionSource;
                            i5 = shape;
                            $composer3 = outlinedTextFieldColors-dx8h9Zs;
                            modifier4 = $dirty13;
                            obj = $dirty12;
                            obj16 = obj12;
                            obj11 = rememberedValue;
                            obj2 = obj8;
                            obj20 = str;
                            i55 = isError;
                            visualTransformation2 = visualTransformation;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-288998816, modifier4, keyboardActions2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:463)");
                    }
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, obj20, invalid$iv, z2, obj16, obj11, obj2, i42, i27, i55, visualTransformation2, keyboardOptions4, keyboardActions4, i43, i21, 1, i14, i5, obj, $composer3, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i4 = modifier4;
                    $composer2 = obj20;
                    z4 = invalid$iv;
                    z5 = z2;
                    modifier3 = obj16;
                    enabled2 = obj11;
                    readOnly2 = obj2;
                    textStyle2 = i42;
                    label2 = i27;
                    placeholder2 = i55;
                    leadingIcon2 = visualTransformation2;
                    trailingIcon2 = keyboardOptions4;
                    isError2 = keyboardActions4;
                    visualTransformation3 = i43;
                    keyboardOptions2 = i21;
                    keyboardActions3 = i14;
                    singleLine2 = i5;
                    maxLines2 = obj;
                    colors2 = keyboardActions2;
                } else {
                    outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions2 = maxLines;
                    keyboardActions3 = interactionSource;
                    singleLine2 = shape;
                    i4 = obj90;
                    $composer3 = outlinedTextFieldColors-dx8h9Zs;
                    maxLines2 = $dirty12;
                    z4 = invalid$iv;
                    z5 = z2;
                    modifier3 = obj12;
                    enabled2 = rememberedValue;
                    readOnly2 = obj8;
                    $composer2 = str;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation3 = singleLine;
                    colors2 = keyboardActions2;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.12(value, onValueChange, $composer2, z4, z5, modifier3, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation3, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, $changed, $changed1, i32);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void OutlinedTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj19;
        Object obj13;
        boolean z;
        Object obj15;
        Object obj16;
        Object obj10;
        boolean z5;
        int i76;
        int i36;
        Object obj8;
        Object obj;
        int modifier2;
        int i29;
        int defaultsInvalid;
        Object endRestartGroup;
        int i28;
        int traceInProgress;
        int rememberedValue;
        long color-0d7_KjU;
        Modifier density;
        int $composer2;
        androidx.compose.runtime.ProvidableCompositionLocal localDensity;
        Object colors2;
        int $dirty2;
        Object $dirty3;
        String textStyle2;
        int i34;
        int outlinedTextFieldShape;
        boolean $dirty;
        int $dirty13;
        Object $dirty12;
        Composer $composer3;
        boolean z6;
        Object obj14;
        int obj6;
        Object obj2;
        boolean str;
        int localTextStyle;
        Object enabled2;
        boolean readOnly2;
        int i15;
        Object readOnly3;
        int i30;
        Object obj5;
        Object obj12;
        int i46;
        Object obj3;
        KeyboardOptions i71;
        int keyboardOptions3;
        Object visualTransformation3;
        Object shape2;
        int keyboardActions2;
        int i85;
        int field2;
        int i7;
        VisualTransformation singleLine2;
        int z3;
        KeyboardOptions maxLines2;
        Object obj7;
        int textStyle3;
        KeyboardActions minLines2;
        Object obj9;
        VisualTransformation i70;
        int visualTransformation2;
        int i21;
        int i60;
        int i39;
        int i84;
        int i52;
        int i32;
        int i78;
        int changed;
        int i73;
        int i41;
        int l2;
        int i;
        int i42;
        int i44;
        int companion;
        Shape shape3;
        int i72;
        int i13;
        int i74;
        Object field;
        int i43;
        int i58;
        int i20;
        int i83;
        int changed2;
        int i33;
        int i64;
        int i86;
        int $dirty1;
        int $dirty14;
        int changed3;
        int i75;
        int changed7;
        int i8;
        int changed4;
        int $dirty15;
        int i45;
        int changed5;
        int i59;
        int i68;
        int i69;
        int i53;
        int i61;
        int i9;
        int i81;
        int i4;
        boolean changed6;
        int i11;
        int i47;
        int i10;
        int i25;
        int i65;
        int i35;
        int i31;
        Composer composer2;
        Composer composer;
        int i55;
        int i79;
        int i37;
        int i82;
        boolean z2;
        boolean z4;
        Object obj11;
        int i38;
        Object obj20;
        Object obj21;
        int i56;
        int obj18;
        int i17;
        VisualTransformation visualTransformation4;
        KeyboardOptions keyboardOptions2;
        Object obj22;
        int i77;
        int i88;
        int i62;
        int obj4;
        Shape obj17;
        int textStyle4;
        long l;
        int i26;
        int i67;
        int i2;
        int i51;
        int i27;
        int i23;
        int i66;
        int i54;
        int i57;
        int i48;
        int i5;
        int i87;
        int i12;
        int i49;
        int i18;
        int i3;
        int i19;
        int i50;
        int i6;
        int i40;
        int i80;
        int i22;
        int i14;
        int i89;
        int i16;
        ScopeUpdateScope scopeUpdateScope;
        int i63;
        int obj106;
        int obj107;
        float obj108;
        int obj109;
        int obj110;
        int obj111;
        int obj112;
        Object obj113;
        Object obj114;
        int obj115;
        int obj116;
        Shape obj117;
        androidx.compose.material.TextFieldColors obj118;
        boolean obj119;
        TextStyle obj120;
        Object obj121;
        Object obj122;
        int obj124;
        int i90 = $changed;
        int i109 = $changed1;
        traceInProgress = i24;
        Composer restartGroup = $composer.startRestartGroup(-621914704);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)142@7875L7,155@8525L22,156@8597L25,166@9030L7,183@9689L38,192@10056L20,200@10398L925,169@9086L2243:OutlinedTextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty13 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty2 |= 6;
            obj14 = value;
        } else {
            if (i90 & 6 == 0) {
                i30 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i30;
            } else {
                obj14 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty2 |= 48;
            obj5 = onValueChange;
        } else {
            if (i90 & 48 == 0) {
                i85 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i85;
            } else {
                obj5 = onValueChange;
            }
        }
        i7 = traceInProgress & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            obj9 = modifier;
        } else {
            if (i90 & 384 == 0) {
                i21 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i21;
            } else {
                obj9 = modifier;
            }
        }
        int i175 = traceInProgress & 8;
        i78 = 1024;
        if (i175 != 0) {
            $dirty2 |= 3072;
            str = enabled;
        } else {
            if (i90 & 3072 == 0) {
                i44 = restartGroup.changed(enabled) ? i39 : i78;
                $dirty2 |= i44;
            } else {
                str = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty2 |= 24576;
            readOnly2 = readOnly;
        } else {
            if (i90 & 24576 == 0) {
                i43 = restartGroup.changed(readOnly) ? 16384 : 8192;
                $dirty2 |= i43;
            } else {
                readOnly2 = readOnly;
            }
        }
        final int i212 = 196608;
        if (i90 & i212 == 0) {
            if (traceInProgress & 32 == 0) {
                changed2 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj3 = textStyle;
            }
            $dirty2 |= changed2;
        } else {
            obj3 = textStyle;
        }
        i33 = traceInProgress & 64;
        i64 = 1572864;
        int i189 = 524288;
        if (i33 != 0) {
            $dirty2 |= i64;
            visualTransformation3 = label;
        } else {
            if (i90 & i64 == 0) {
                changed7 = restartGroup.changedInstance(label) ? 1048576 : i189;
                $dirty2 |= changed7;
            } else {
                visualTransformation3 = label;
            }
        }
        int i171 = traceInProgress & 128;
        int i195 = 12582912;
        if (i171 != 0) {
            $dirty2 |= i195;
            obj7 = placeholder;
        } else {
            if (i90 & i195 == 0) {
                i69 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i69;
            } else {
                obj7 = placeholder;
            }
        }
        int i91 = traceInProgress & 256;
        int i197 = 100663296;
        if (i91 != 0) {
            $dirty2 |= i197;
            i53 = i91;
            obj19 = leadingIcon;
        } else {
            if ($changed & i197 == 0) {
                i53 = i91;
                i61 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i61;
            } else {
                i53 = i91;
                obj19 = leadingIcon;
            }
        }
        int i92 = traceInProgress & 512;
        int i200 = 805306368;
        if (i92 != 0) {
            $dirty2 |= i200;
            i9 = i92;
            obj13 = trailingIcon;
        } else {
            if ($changed & i200 == 0) {
                i9 = i92;
                i81 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i81;
            } else {
                i9 = i92;
                obj13 = trailingIcon;
            }
        }
        int i93 = traceInProgress & 1024;
        if (i93 != 0) {
            $dirty13 |= 6;
            i4 = i93;
            z = isError;
        } else {
            if (i109 & 6 == 0) {
                i4 = i93;
                i72 = restartGroup.changed(isError) ? 4 : 2;
                $dirty13 |= i72;
            } else {
                i4 = i93;
                z = isError;
            }
        }
        int i94 = traceInProgress & 2048;
        if (i94 != 0) {
            $dirty13 |= 48;
            i13 = i94;
            obj15 = visualTransformation;
        } else {
            if (i109 & 48 == 0) {
                i13 = i94;
                changed3 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty13 |= changed3;
            } else {
                i13 = i94;
                obj15 = visualTransformation;
            }
        }
        int i95 = traceInProgress & 4096;
        if (i95 != 0) {
            $dirty13 |= 384;
            i20 = i95;
            obj16 = keyboardOptions;
        } else {
            i20 = i95;
            if (i109 & 384 == 0) {
                changed7 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty13 |= changed7;
            } else {
                obj16 = keyboardOptions;
            }
        }
        int i97 = traceInProgress & 8192;
        if (i97 != 0) {
            $dirty13 |= 3072;
            i75 = i97;
            obj10 = keyboardActions;
        } else {
            i75 = i97;
            if (i109 & 3072 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i39 = i78;
                }
                $dirty13 |= i39;
            } else {
                obj10 = keyboardActions;
            }
        }
        int i98 = traceInProgress & 16384;
        if (i98 != 0) {
            $dirty13 |= 24576;
            i84 = i98;
            z5 = singleLine;
        } else {
            i84 = i98;
            if (i109 & 24576 == 0) {
                i78 = restartGroup.changed(singleLine) ? 16384 : 8192;
                $dirty13 |= i78;
            } else {
                z5 = singleLine;
            }
        }
        if (i109 & i212 == 0) {
            if (traceInProgress & i179 == 0) {
                i73 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i76 = maxLines;
            }
            $dirty13 |= i73;
        } else {
            i76 = maxLines;
        }
        i41 = traceInProgress & i180;
        if (i41 != 0) {
            $dirty13 |= i64;
            i36 = minLines;
        } else {
            if (i109 & i64 == 0) {
                i64 = restartGroup.changed(minLines) ? 1048576 : i189;
                $dirty13 |= i64;
            } else {
                i36 = minLines;
            }
        }
        i86 = traceInProgress & i187;
        if (i86 != 0) {
            $dirty13 |= i195;
            obj8 = interactionSource;
        } else {
            if (i109 & i195 == 0) {
                changed7 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty13 |= changed7;
            } else {
                obj8 = interactionSource;
            }
        }
        if (i109 & i191 == 0) {
            if (traceInProgress & i192 == 0) {
                i8 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj = shape;
            }
            $dirty13 |= i8;
        } else {
            obj = shape;
        }
        if (i109 & i193 == 0) {
            if (traceInProgress & i189 == 0) {
                obj124 = $dirty13;
                i45 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty13;
                $dirty12 = colors;
            }
            $dirty15 = obj124 | i45;
        } else {
            $dirty12 = colors;
            $dirty15 = obj124;
        }
        if ($dirty2 & i59 == 306783378 && $dirty15 & i106 == 306783378) {
            if ($dirty15 & i106 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    obj124 = -458753;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj9;
                            }
                            z2 = i175 != 0 ? str : str;
                            z4 = companion != 0 ? str : readOnly2;
                            if (traceInProgress & 32 != 0) {
                                readOnly2 = 6;
                                i7 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj11 = $dirty12;
                                i38 = $dirty2;
                            } else {
                                obj11 = obj3;
                                i38 = $dirty2;
                            }
                            obj20 = i33 != 0 ? $dirty2 : visualTransformation3;
                            obj21 = i171 != 0 ? $dirty2 : obj7;
                            i56 = i53 != 0 ? $dirty2 : leadingIcon;
                            obj18 = i9 != 0 ? $dirty2 : trailingIcon;
                            i17 = i4 != 0 ? $dirty2 : isError;
                            if (i13 != 0) {
                                visualTransformation4 = $dirty2;
                            } else {
                                visualTransformation4 = visualTransformation;
                            }
                            if (i20 != 0) {
                                keyboardOptions2 = $dirty2;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (i75 != 0) {
                                obj22 = $dirty2;
                            } else {
                                obj22 = keyboardActions;
                            }
                            i77 = i84 != 0 ? $dirty2 : singleLine;
                            if (i131 &= traceInProgress != 0) {
                                i34 = i77 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                $dirty15 &= obj124;
                                i88 = i34;
                            } else {
                                i88 = maxLines;
                            }
                            i62 = i41 != 0 ? i34 : minLines;
                            obj4 = i86 != 0 ? i34 : interactionSource;
                            if (i132 &= traceInProgress != 0) {
                                obj17 = outlinedTextFieldShape;
                                textStyle4 = $dirty15;
                            } else {
                                obj17 = shape;
                                textStyle4 = $dirty15;
                            }
                            if (traceInProgress & i189 != 0) {
                                composer2 = restartGroup;
                                int $composer5 = i63;
                                $composer3 = composer2;
                                obj12 = outlinedTextFieldColors-dx8h9Zs;
                                $composer2 = i151;
                                str = z2;
                                readOnly2 = z4;
                                $dirty3 = obj11;
                                i28 = i38;
                                obj6 = i17;
                                i70 = visualTransformation4;
                                i71 = keyboardOptions2;
                                shape2 = obj22;
                                field2 = i77;
                                z3 = i88;
                                textStyle3 = i62;
                            } else {
                                $composer3 = restartGroup;
                                int $composer4 = 1;
                                obj12 = colors;
                                str = z2;
                                readOnly2 = z4;
                                $dirty3 = obj11;
                                i28 = i38;
                                obj6 = i17;
                                i70 = visualTransformation4;
                                i71 = keyboardOptions2;
                                shape2 = obj22;
                                field2 = i77;
                                z3 = i88;
                                textStyle3 = i62;
                                $composer2 = textStyle4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (traceInProgress & 32 != 0) {
                                $dirty2 &= obj124;
                            }
                            if (i100 &= traceInProgress != 0) {
                                $dirty15 &= obj124;
                            }
                            if (i102 &= traceInProgress != 0) {
                                $dirty15 &= i29;
                            }
                            if (traceInProgress & i189 != 0) {
                                i56 = leadingIcon;
                                obj18 = trailingIcon;
                                obj6 = isError;
                                field2 = singleLine;
                                z3 = maxLines;
                                obj4 = interactionSource;
                                obj17 = shape;
                                obj12 = colors;
                                $composer3 = restartGroup;
                                i28 = $dirty2;
                                $dirty3 = obj3;
                                obj20 = visualTransformation3;
                                obj21 = obj7;
                                i71 = keyboardOptions;
                                shape2 = keyboardActions;
                                textStyle3 = minLines;
                                $composer2 = i105;
                                modifier2 = obj9;
                                i70 = visualTransformation;
                            } else {
                                i56 = leadingIcon;
                                obj18 = trailingIcon;
                                obj6 = isError;
                                field2 = singleLine;
                                z3 = maxLines;
                                obj4 = interactionSource;
                                obj17 = shape;
                                obj12 = colors;
                                $composer3 = restartGroup;
                                i28 = $dirty2;
                                $dirty3 = obj3;
                                obj20 = visualTransformation3;
                                obj21 = obj7;
                                modifier2 = obj9;
                                $composer2 = $dirty15;
                                i70 = visualTransformation;
                                i71 = keyboardOptions;
                                shape2 = keyboardActions;
                                textStyle3 = minLines;
                            }
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj119 = readOnly2;
                        ComposerKt.traceEventStart(-621914704, i28, $composer2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:157)");
                    } else {
                        obj119 = readOnly2;
                    }
                    if (obj4 == null) {
                        $composer3.startReplaceGroup(-589524042);
                        ComposerKt.sourceInformation($composer3, "159@8708L39");
                        ComposerKt.sourceInformationMarkerStart($composer3, 673719756, "CC(remember):OutlinedTextField.kt#9igjgp");
                        readOnly2 = $composer3;
                        int i177 = 0;
                        obj106 = i114;
                        rememberedValue = readOnly2.rememberedValue();
                        i41 = 0;
                        $dirty1 = $composer2;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i116 = 0;
                            readOnly2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $composer2 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                        i52 = $composer2;
                    } else {
                        $dirty1 = $composer2;
                        $composer3.startReplaceGroup(673719105);
                        $composer3.endReplaceGroup();
                        i52 = obj4;
                    }
                    $composer3.startReplaceGroup(673724863);
                    ComposerKt.sourceInformation($composer3, "*162@8895L18");
                    color-0d7_KjU = $dirty3.getColor-0d7_KjU();
                    int i155 = 0;
                    i74 = 0;
                    i83 = Long.compare(l2, i185) != 0 ? 1 : 0;
                    if (i83 != 0) {
                    } else {
                        l2 = 0;
                        obj106 = color-0d7_KjU;
                        color-0d7_KjU = (Color)obj12.textColor(str, $composer3, companion | i74).getValue().unbox-impl();
                    }
                    $composer3.endReplaceGroup();
                    textStyle4 = new TextStyle(color-0d7_KjU, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    i15 = 0;
                    i = 0;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (obj20 != null) {
                        Modifier semantics = SemanticsModifierKt.semantics((Modifier)Modifier.Companion, true, (Function1)OutlinedTextFieldKt.OutlinedTextField.1.INSTANCE);
                        int i157 = 0;
                        obj122 = consume;
                        density = PaddingKt.padding-qDBjuR0$default(semantics, 0, (Density)consume.toDp-GaN1DYA(OutlinedTextFieldKt.OutlinedTextFieldTopPadding), 0, 0, 13, 0);
                    } else {
                        obj122 = consume;
                        density = Modifier.Companion;
                    }
                    obj112 = obj6;
                    obj108 = str;
                    SolidColor solidColor = new SolidColor((Color)obj12.cursorColor(obj6, $composer3, i118 |= i159).getValue().unbox-impl(), str, 0);
                    obj106 = anon;
                    obj118 = obj12;
                    super(value, obj108, field2, i70, i52, obj112, obj20, obj21, i56, obj18, obj17, obj118);
                    boolean z7 = obj108;
                    boolean z8 = obj119;
                    Composer composer3 = $composer3;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier2.then(density), obj6, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), $composer3, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), z7, z8, $dirty3.merge(textStyle4), i71, shape2, field2, z3, textStyle3, i70, 0, i52, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(1710364390, true, obj106, $composer3, 54), composer3, i127 | i148, i130 | i149, 4096);
                    composer = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation2 = field2;
                    singleLine2 = visualTransformation5;
                    field = field3;
                    $dirty = z7;
                    z6 = z8;
                    i60 = z3;
                    i32 = textStyle3;
                    $dirty15 = $dirty1;
                    obj2 = obj11;
                    enabled2 = obj20;
                    readOnly3 = obj21;
                    i46 = i56;
                    i42 = obj4;
                    shape3 = obj17;
                    colors2 = modifier2;
                    $dirty14 = i28;
                    maxLines2 = i71;
                    minLines2 = shape2;
                    keyboardOptions3 = obj18;
                    keyboardActions2 = i17;
                } else {
                    restartGroup.skipToGroupEnd();
                    i46 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i60 = maxLines;
                    i32 = minLines;
                    i42 = interactionSource;
                    shape3 = shape;
                    composer = restartGroup;
                    $dirty14 = $dirty2;
                    field = $dirty12;
                    $dirty = str;
                    z6 = readOnly2;
                    obj2 = obj3;
                    enabled2 = visualTransformation3;
                    readOnly3 = obj7;
                    colors2 = obj9;
                    keyboardOptions3 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation2 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.4(value, onValueChange, colors2, $dirty, z6, obj2, enabled2, readOnly3, i46, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation2, i60, i32, i42, shape3, field, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void OutlinedTextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj23;
        Object obj;
        boolean z6;
        Object obj22;
        Object obj7;
        Object obj14;
        boolean z4;
        int i40;
        Object obj17;
        Object obj12;
        int textStyle2;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier2;
        Object modifier3;
        int i45;
        int i4;
        int enabled2;
        boolean enabled4;
        int i8;
        Object $composer3;
        Object outlinedTextFieldColors-dx8h9Zs;
        boolean traceInProgress;
        int $dirty;
        boolean $dirty2;
        int outlinedTextFieldShape;
        int $dirty13;
        Object $dirty12;
        boolean z;
        Object obj10;
        Object modifier4;
        Object obj11;
        boolean z5;
        Object enabled3;
        int i19;
        boolean z3;
        Object readOnly2;
        int i47;
        Object obj21;
        int textStyle3;
        Object obj16;
        Object rememberedValue;
        int label2;
        Object obj3;
        Object obj4;
        int placeholder2;
        Object obj15;
        int i53;
        VisualTransformation leadingIcon2;
        int i51;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5;
        KeyboardOptions trailingIcon2;
        int i42;
        Object obj5;
        KeyboardActions isError2;
        int i14;
        Object obj6;
        int visualTransformation3;
        VisualTransformation visualTransformation2;
        int i6;
        int keyboardOptions3;
        KeyboardOptions keyboardOptions2;
        int i11;
        int i;
        Object keyboardActions4;
        KeyboardActions keyboardActions2;
        int changed4;
        Shape singleLine2;
        int i41;
        int i26;
        Object maxLines2;
        int i17;
        int i34;
        int i15;
        int i7;
        int i5;
        int i48;
        int changed3;
        int $dirty1;
        int changed;
        int i25;
        int i16;
        int i43;
        int colors2;
        Object obj19;
        int i22;
        int i27;
        int i35;
        int i10;
        int i50;
        int changed2;
        int i12;
        int changed5;
        int i13;
        int changed7;
        int i21;
        int i54;
        int i31;
        int i24;
        int i39;
        int i55;
        int i52;
        boolean changed6;
        int i49;
        int i33;
        int i18;
        int i32;
        int i46;
        Composer $composer2;
        int i30;
        int i28;
        int i3;
        int i20;
        boolean z2;
        int i44;
        Object obj20;
        Object obj9;
        int i9;
        int i37;
        int i2;
        Object obj2;
        Object obj18;
        KeyboardActions keyboardActions3;
        int i36;
        int i29;
        Object obj13;
        Object obj8;
        int i38;
        ScopeUpdateScope scopeUpdateScope;
        Object obj71;
        int obj88;
        int i56 = $changed;
        int i71 = $changed1;
        i8 = i23;
        outlinedTextFieldColors-dx8h9Zs = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation(outlinedTextFieldColors-dx8h9Zs, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)240@11690L7,251@12250L39,252@12328L22,253@12400L25,255@12434L416:OutlinedTextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty13 = $changed1;
        if (i8 & 1 != 0) {
            $dirty |= 6;
            obj10 = value;
        } else {
            if (i56 & 6 == 0) {
                i47 = outlinedTextFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty |= i47;
            } else {
                obj10 = value;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
            obj21 = onValueChange;
        } else {
            if (i56 & 48 == 0) {
                i53 = outlinedTextFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i53;
            } else {
                obj21 = onValueChange;
            }
        }
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 = i8 & 4;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 != 0) {
            $dirty |= 384;
            obj6 = modifier;
        } else {
            if (i56 & 384 == 0) {
                i6 = outlinedTextFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj6 = modifier;
            }
        }
        int i140 = i8 & 8;
        changed4 = 1024;
        if (i140 != 0) {
            $dirty |= 3072;
            z5 = enabled;
        } else {
            if (i56 & 3072 == 0) {
                i26 = outlinedTextFieldColors-dx8h9Zs.changed(enabled) ? i11 : changed4;
                $dirty |= i26;
            } else {
                z5 = enabled;
            }
        }
        int i144 = i8 & 16;
        i7 = 8192;
        if (i144 != 0) {
            $dirty |= 24576;
            z3 = readOnly;
        } else {
            if (i56 & 24576 == 0) {
                i43 = outlinedTextFieldColors-dx8h9Zs.changed(readOnly) ? i34 : i7;
                $dirty |= i43;
            } else {
                z3 = readOnly;
            }
        }
        int i149 = 196608;
        int i152 = 65536;
        i50 = 131072;
        if (i56 & i149 == 0) {
            if (i8 & 32 == 0) {
                changed2 = outlinedTextFieldColors-dx8h9Zs.changed(textStyle) ? i50 : i152;
            } else {
                rememberedValue = textStyle;
            }
            $dirty |= changed2;
        } else {
            rememberedValue = textStyle;
        }
        i12 = i8 & 64;
        final int i159 = 1572864;
        if (i12 != 0) {
            $dirty |= i159;
            obj4 = label;
        } else {
            if (i56 & i159 == 0) {
                changed7 = outlinedTextFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty |= changed7;
            } else {
                obj4 = label;
            }
        }
        int i136 = i8 & 128;
        final int i153 = 12582912;
        if (i136 != 0) {
            $dirty |= i153;
            obj5 = placeholder;
        } else {
            if (i56 & i153 == 0) {
                i54 = outlinedTextFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i54;
            } else {
                obj5 = placeholder;
            }
        }
        int i57 = i8 & 256;
        int i154 = 100663296;
        if (i57 != 0) {
            $dirty |= i154;
            i31 = i57;
            obj23 = leadingIcon;
        } else {
            if ($changed & i154 == 0) {
                i31 = i57;
                i24 = outlinedTextFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i24;
            } else {
                i31 = i57;
                obj23 = leadingIcon;
            }
        }
        int i58 = i8 & 512;
        int i156 = 805306368;
        if (i58 != 0) {
            $dirty |= i156;
            i39 = i58;
            obj = trailingIcon;
        } else {
            if ($changed & i156 == 0) {
                i39 = i58;
                i55 = outlinedTextFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i55;
            } else {
                i39 = i58;
                obj = trailingIcon;
            }
        }
        int i59 = i8 & 1024;
        if (i59 != 0) {
            $dirty13 |= 6;
            i52 = i59;
            z6 = isError;
        } else {
            if (i71 & 6 == 0) {
                i52 = i59;
                i25 = outlinedTextFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty13 |= i25;
            } else {
                i52 = i59;
                z6 = isError;
            }
        }
        int i60 = i8 & 2048;
        if (i60 != 0) {
            $dirty13 |= 48;
            i16 = i60;
            obj22 = visualTransformation;
        } else {
            if (i71 & 48 == 0) {
                i16 = i60;
                changed5 = outlinedTextFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty13 |= changed5;
            } else {
                i16 = i60;
                obj22 = visualTransformation;
            }
        }
        int i61 = i8 & 4096;
        if (i61 != 0) {
            $dirty13 |= 384;
            i27 = i61;
            obj7 = keyboardOptions;
        } else {
            i27 = i61;
            if (i71 & 384 == 0) {
                changed7 = outlinedTextFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty13 |= changed7;
            } else {
                obj7 = keyboardOptions;
            }
        }
        int i63 = i8 & 8192;
        if (i63 != 0) {
            $dirty13 |= 3072;
            i13 = i63;
            obj14 = keyboardActions;
        } else {
            i13 = i63;
            if (i71 & 3072 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i11 = changed4;
                }
                $dirty13 |= i11;
            } else {
                obj14 = keyboardActions;
            }
        }
        int i64 = i8 & 16384;
        if (i64 != 0) {
            $dirty13 |= 24576;
            i = i64;
            z4 = singleLine;
        } else {
            i = i64;
            if (i71 & 24576 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i34 = i7;
                }
                $dirty13 |= i34;
            } else {
                z4 = singleLine;
            }
        }
        int i143 = i8 & i142;
        if (i143 != 0) {
            $dirty13 |= i149;
            i40 = maxLines;
        } else {
            if (i71 & i149 == 0) {
                i34 = outlinedTextFieldColors-dx8h9Zs.changed(maxLines) ? i50 : i152;
                $dirty13 |= i34;
            } else {
                i40 = maxLines;
            }
        }
        i15 = i8 & i152;
        if (i15 != 0) {
            $dirty13 |= i159;
            obj17 = interactionSource;
        } else {
            if (i71 & i159 == 0) {
                i7 = outlinedTextFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty13 |= i7;
            } else {
                obj17 = interactionSource;
            }
        }
        if (i71 & i153 == 0) {
            if (i8 & i50 == 0) {
                i5 = outlinedTextFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj12 = shape;
            }
            $dirty13 |= i5;
        } else {
            obj12 = shape;
        }
        int i150 = 262144;
        if (i71 & i154 == 0) {
            if (i8 & i150 == 0) {
                obj88 = $dirty13;
                i48 = outlinedTextFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj88 = $dirty13;
                $dirty12 = colors;
            }
            $dirty1 = obj88 | i48;
        } else {
            $dirty12 = colors;
            $dirty1 = obj88;
        }
        if ($dirty & i10 == 306783378 && $dirty1 & i68 == 38347922) {
            if ($dirty1 & i68 == 38347922) {
                if (!outlinedTextFieldColors-dx8h9Zs.getSkipping()) {
                    outlinedTextFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (outlinedTextFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj6;
                            }
                            enabled4 = i140 != 0 ? 1 : z5;
                            z2 = i144 != 0 ? z5 : z3;
                            if (i8 & 32 != 0) {
                                z3 = 6;
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 = 0;
                                obj71 = modifier2;
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                modifier3 = outlinedTextFieldColors-dx8h9Zs.consume((CompositionLocal)TextKt.getLocalTextStyle());
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                i44 = $dirty;
                            } else {
                                obj71 = modifier2;
                                modifier3 = rememberedValue;
                                i44 = $dirty;
                            }
                            obj20 = i12 != 0 ? $dirty : obj4;
                            obj9 = i136 != 0 ? $dirty : obj5;
                            i9 = i31 != 0 ? $dirty : leadingIcon;
                            i37 = i39 != 0 ? $dirty : trailingIcon;
                            i2 = i52 != 0 ? $dirty : isError;
                            if (i16 != 0) {
                                obj2 = $dirty;
                            } else {
                                obj2 = visualTransformation;
                            }
                            if (i27 != 0) {
                                obj18 = $dirty;
                            } else {
                                obj18 = keyboardOptions;
                            }
                            if (i13 != 0) {
                                keyboardActions3 = $dirty;
                            } else {
                                keyboardActions3 = keyboardActions;
                            }
                            i36 = i != 0 ? $dirty : singleLine;
                            i29 = i143 != 0 ? $dirty : maxLines;
                            if (i15 != 0) {
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 673833100, "CC(remember):OutlinedTextField.kt#9igjgp");
                                int i121 = 0;
                                i19 = outlinedTextFieldColors-dx8h9Zs;
                                z3 = 0;
                                rememberedValue = i19.rememberedValue();
                                obj4 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i135 = 0;
                                    i19.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj13 = $dirty;
                            } else {
                                obj13 = interactionSource;
                            }
                            if (i8 & i50 != 0) {
                                obj8 = outlinedTextFieldShape;
                                i38 = $dirty1;
                            } else {
                                obj8 = shape;
                                i38 = $dirty1;
                            }
                            if (i8 & i150 != 0) {
                                obj11 = obj71;
                                obj16 = modifier3;
                                z5 = enabled4;
                                obj19 = outlinedTextFieldColors-dx8h9Zs;
                                enabled2 = $dirty;
                                z3 = z2;
                                textStyle2 = i44;
                                obj3 = obj20;
                                obj15 = obj9;
                                i51 = i9;
                                i42 = i37;
                                i14 = i2;
                                visualTransformation2 = obj2;
                                keyboardOptions2 = obj18;
                                keyboardActions2 = keyboardActions3;
                                i41 = i36;
                                i17 = i29;
                                $dirty1 = obj13;
                                i16 = obj8;
                            } else {
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                obj11 = obj71;
                                obj19 = colors;
                                obj16 = modifier3;
                                z5 = enabled4;
                                z3 = z2;
                                textStyle2 = i44;
                                obj3 = obj20;
                                obj15 = obj9;
                                i51 = i9;
                                i42 = i37;
                                i14 = i2;
                                visualTransformation2 = obj2;
                                keyboardOptions2 = obj18;
                                keyboardActions2 = keyboardActions3;
                                i41 = i36;
                                i17 = i29;
                                $dirty1 = obj13;
                                i16 = obj8;
                                enabled2 = i38;
                            }
                        } else {
                            outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                            if (i8 & 32 != 0) {
                                $dirty &= i45;
                            }
                            if (i8 & i50 != 0) {
                                $dirty1 &= i4;
                            }
                            if (i8 & i150 != 0) {
                                i51 = leadingIcon;
                                i42 = trailingIcon;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActions2 = keyboardActions;
                                i41 = singleLine;
                                i17 = maxLines;
                                $dirty1 = interactionSource;
                                i16 = shape;
                                enabled2 = i67;
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                textStyle2 = $dirty;
                                obj19 = $dirty12;
                                obj16 = rememberedValue;
                                obj3 = obj4;
                                obj15 = obj5;
                                obj11 = obj6;
                                i14 = isError;
                                visualTransformation2 = visualTransformation;
                            } else {
                                i51 = leadingIcon;
                                i42 = trailingIcon;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActions2 = keyboardActions;
                                i41 = singleLine;
                                i17 = maxLines;
                                i16 = shape;
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                textStyle2 = $dirty;
                                obj19 = $dirty12;
                                obj16 = rememberedValue;
                                obj3 = obj4;
                                obj15 = obj5;
                                obj11 = obj6;
                                enabled2 = $dirty1;
                                i14 = isError;
                                visualTransformation2 = visualTransformation;
                                $dirty1 = interactionSource;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2099955827, textStyle2, enabled2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:254)");
                    }
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, obj11, z5, z3, obj16, obj3, obj15, i51, i42, i14, visualTransformation2, keyboardOptions2, keyboardActions2, i41, i17, 1, $dirty1, i16, obj19, $composer2, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i35 = enabled2;
                    $composer3 = obj11;
                    $dirty2 = z5;
                    z = z3;
                    modifier4 = obj16;
                    enabled3 = obj3;
                    readOnly2 = obj15;
                    textStyle3 = i51;
                    label2 = i42;
                    placeholder2 = i14;
                    leadingIcon2 = visualTransformation2;
                    trailingIcon2 = keyboardOptions2;
                    isError2 = keyboardActions2;
                    visualTransformation3 = i41;
                    keyboardOptions3 = i17;
                    keyboardActions4 = $dirty1;
                    singleLine2 = i16;
                    maxLines2 = obj19;
                    colors2 = textStyle2;
                } else {
                    outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle3 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions3 = maxLines;
                    keyboardActions4 = interactionSource;
                    singleLine2 = shape;
                    $composer2 = outlinedTextFieldColors-dx8h9Zs;
                    colors2 = $dirty;
                    maxLines2 = $dirty12;
                    $dirty2 = z5;
                    z = z3;
                    modifier4 = rememberedValue;
                    enabled3 = obj4;
                    readOnly2 = obj5;
                    $composer3 = obj6;
                    i35 = $dirty1;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation3 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.6(value, onValueChange, $composer3, $dirty2, z, modifier4, enabled3, readOnly2, textStyle3, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine2, maxLines2, $changed, $changed1, i8);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, boolean singleLine, float animationProgress, Function1<? super Size, Unit> onLabelMeasured, Function2<? super Composer, ? super Integer, Unit> border, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int i30;
        int i21;
        int i9;
        int i5;
        int traceInProgress;
        boolean traceInProgress2;
        int i32;
        Object it$iv;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        Integer valueOf;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Object obj;
        Object valueOf4;
        Object maybeCachedBoxMeasurePolicy2;
        Composer composer2;
        int $composer$iv2;
        Composer composer3;
        int valueOf2;
        Integer valueOf7;
        Integer valueOf5;
        int materialized$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object $composer$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        boolean currentCompositionLocalMap;
        Object maybeCachedBoxMeasurePolicy;
        int $changed$iv2;
        Object materialized$iv$iv2;
        androidx.compose.ui.Modifier.Companion $this$coerceAtLeast_u2dYgX7TsA$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Modifier padding-qDBjuR0$default;
        Object iNSTANCE;
        Object $this$dp$iv;
        int then;
        boolean currentCompositionLocalMap2;
        int i14;
        int i33;
        int i23;
        int i10;
        int $dirty;
        Object $i$f$cache2;
        boolean currentCompositionLocalMap4;
        Modifier materializeModifier;
        Composer composer;
        Integer valueOf6;
        Composer composer5;
        int restartGroup;
        Integer valueOf3;
        int $dirty1;
        Composer composer4;
        Object maybeCachedBoxMeasurePolicy3;
        int i6;
        int i19;
        int i8;
        int i7;
        int i20;
        int i28;
        int i22;
        int i3;
        int i11;
        int i;
        Object companion;
        int $i$f$cache;
        int currentCompositeKeyHash;
        int i24;
        kotlin.jvm.functions.Function0 function0;
        int i12;
        Composer composer6;
        int i27;
        int i13;
        Object obj2;
        Composer composer8;
        int i15;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        int i31;
        Modifier modifier3;
        int i16;
        int i26;
        int i35;
        int $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1;
        int i17;
        int currentCompositeKeyHash2;
        int currentCompositeKeyHash3;
        float f2;
        Alignment alignment;
        int $changed$iv;
        float f;
        int i25;
        int i34;
        Modifier modifier2;
        kotlin.jvm.functions.Function0 function02;
        int i2;
        int i18;
        Composer composer9;
        int localMap$iv$iv2;
        int i29;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer7;
        int i4;
        Object obj66;
        Object obj3 = modifier;
        valueOf4 = textField;
        $composer$iv2 = placeholder;
        materialized$iv$iv = label;
        $composer$iv = leading;
        maybeCachedBoxMeasurePolicy = trailing;
        $changed$iv2 = singleLine;
        padding-qDBjuR0$default = animationProgress;
        iNSTANCE = onLabelMeasured;
        $this$dp$iv = border;
        final Object obj4 = paddingValues;
        int i95 = $changed;
        restartGroup = $composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)508@23459L239,516@23746L7,517@23758L2308:OutlinedTextField.kt#jmzs0o");
        if (i95 & 6 == 0) {
            i6 = restartGroup.changed(obj3) ? 4 : 2;
            $dirty |= i6;
        }
        if (i95 & 48 == 0) {
            i19 = restartGroup.changedInstance(valueOf4) ? 32 : 16;
            $dirty |= i19;
        }
        if (i95 & 384 == 0) {
            i30 = restartGroup.changedInstance($composer$iv2) ? 256 : 128;
            $dirty |= i30;
        }
        if (i95 & 3072 == 0) {
            i21 = restartGroup.changedInstance(materialized$iv$iv) ? 2048 : 1024;
            $dirty |= i21;
        }
        if (i95 & 24576 == 0) {
            i9 = restartGroup.changedInstance($composer$iv) ? 16384 : 8192;
            $dirty |= i9;
        }
        if (i37 &= i95 == 0) {
            i5 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy) ? 131072 : 65536;
            $dirty |= i5;
        }
        if (i38 &= i95 == 0) {
            i7 = restartGroup.changed($changed$iv2) ? 1048576 : 524288;
            $dirty |= i7;
        }
        if (i95 & i125 == 0) {
            i20 = restartGroup.changed(padding-qDBjuR0$default) ? 8388608 : 4194304;
            $dirty |= i20;
        }
        if (i95 & i126 == 0) {
            i28 = restartGroup.changedInstance(iNSTANCE) ? 67108864 : 33554432;
            $dirty |= i28;
        }
        if (i95 & i127 == 0) {
            i22 = restartGroup.changedInstance($this$dp$iv) ? 536870912 : 268435456;
            $dirty |= i22;
        }
        if ($changed1 & 6 == 0) {
            i3 = restartGroup.changed(obj4) ? 4 : 2;
            $dirty1 |= i3;
        }
        if ($dirty & i11 == 306783378 && $dirty1 & 3 == 2) {
            if ($dirty1 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2049536174, $dirty, $dirty1, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:507)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1860606082, "CC(remember):OutlinedTextField.kt#9igjgp");
                    int i124 = 1;
                    i8 = $dirty;
                    i32 = i41 &= $dirty == 67108864 ? i124 : 0;
                    i33 = i8 & i97 == 1048576 ? i124 : 0;
                    i23 = i8 & i99 == 8388608 ? i124 : 0;
                    i10 = $dirty1 & 14 == 4 ? i124 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache2 = 0;
                    it$iv = composer13.rememberedValue();
                    int i128 = 0;
                    if (i44 |= i10 == 0) {
                        $i$f$cache = $i$f$cache2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache2 = 0;
                            companion = it$iv;
                            it$iv = new OutlinedTextFieldMeasurePolicy(iNSTANCE, $changed$iv2, padding-qDBjuR0$default, obj4);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            companion = it$iv;
                        }
                    } else {
                        $i$f$cache = $i$f$cache2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i106 = 0;
                    int i129 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    $changed$iv2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv2);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap4 = restartGroup.getCurrentCompositionLocalMap();
                    materialized$iv$iv2 = ComposedModifierKt.materializeModifier(restartGroup, obj3);
                    kotlin.jvm.functions.Function0 function03 = constructor2;
                    i24 = 0;
                    iNSTANCE = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, iNSTANCE);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function03);
                    } else {
                        factory$iv$iv = function03;
                        restartGroup.useNode();
                    }
                    function0 = factory$iv$iv;
                    Composer constructor-impl = Updater.constructor-impl(restartGroup);
                    int i131 = 0;
                    i13 = i102;
                    composer8 = restartGroup;
                    Updater.set-impl(constructor-impl, (MeasurePolicy)(OutlinedTextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf3 = 0;
                    Composer composer14 = constructor-impl;
                    i15 = 0;
                    if (!composer14.getInserting()) {
                        localMap$iv = currentCompositionLocalMap4;
                        i31 = valueOf3;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer5 = composer14;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap4;
                        i31 = valueOf3;
                    }
                    Updater.set-impl(constructor-impl, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    i14 = composer8;
                    materializeModifier = 0;
                    i27 = i62;
                    ComposerKt.sourceInformationMarkerStart(i14, -988650720, "C525@24262L8,564@25710L182:OutlinedTextField.kt#jmzs0o");
                    $this$dp$iv.invoke(i14, Integer.valueOf(i63 &= 14));
                    restartGroup = "C73@3429L9:Box.kt#2w3rfo";
                    int i132 = 48;
                    String str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier3 = materialized$iv$iv2;
                    if ($composer$iv != null) {
                        i14.startReplaceGroup(-988654503);
                        ComposerKt.sourceInformation(i14, "528@24323L219");
                        Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        i26 = i132;
                        i35 = 0;
                        $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1 = materializeModifier;
                        ComposerKt.sourceInformationMarkerStart(i14, 733328855, str2);
                        int i118 = 0;
                        i17 = $dirty1;
                        maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i118);
                        currentCompositeKeyHash3 = 0;
                        alignment = center2;
                        ComposerKt.sourceInformationMarkerStart(i14, -1323940314, $changed$iv2);
                        $changed$iv = ComposablesKt.getCurrentCompositeKeyHash(i14, 0);
                        currentCompositionLocalMap2 = i14.getCurrentCompositionLocalMap();
                        i25 = i118;
                        modifier2 = then3;
                        kotlin.jvm.functions.Function0 function07 = constructor5;
                        i34 = 0;
                        ComposerKt.sourceInformationMarkerStart(i14, -692256719, iNSTANCE);
                        if (!applier5 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i14.startReusableNode();
                        if (i14.getInserting()) {
                            i14.createNode(function07);
                        } else {
                            factory$iv$iv$iv3 = function07;
                            i14.useNode();
                        }
                        function02 = factory$iv$iv$iv3;
                        Composer constructor-impl4 = Updater.constructor-impl(i14);
                        int i150 = 0;
                        Updater.set-impl(constructor-impl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i155 = 0;
                        Composer composer18 = constructor-impl4;
                        int i156 = 0;
                        if (!composer18.getInserting()) {
                            localMap$iv$iv = currentCompositionLocalMap2;
                            measurePolicy = maybeCachedBoxMeasurePolicy3;
                            if (!Intrinsics.areEqual(composer18.rememberedValue(), Integer.valueOf($changed$iv))) {
                                composer18.updateRememberedValue(Integer.valueOf($changed$iv));
                                constructor-impl4.apply(Integer.valueOf($changed$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer4 = composer18;
                            }
                        } else {
                            localMap$iv$iv = currentCompositionLocalMap2;
                            measurePolicy = maybeCachedBoxMeasurePolicy3;
                        }
                        Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier(i14, then3), ComposeUiNode.Companion.getSetModifier());
                        Composer composer12 = i14;
                        ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, restartGroup);
                        $dirty1 = BoxScopeInstance.INSTANCE;
                        i152 |= 6;
                        localMap$iv$iv2 = 0;
                        i29 = i73;
                        i4 = i94;
                        $this$dp$iv = composer9;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, 1888671661, "C532@24515L9:OutlinedTextField.kt#jmzs0o");
                        $composer$iv.invoke($this$dp$iv, Integer.valueOf(i74 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer12);
                        i14.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        i14.endReplaceGroup();
                    } else {
                        $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1 = materializeModifier;
                        i17 = $dirty1;
                        i14.startReplaceGroup(-988413292);
                        i14.endReplaceGroup();
                    }
                    if (maybeCachedBoxMeasurePolicy != null) {
                        i14.startReplaceGroup(-988370729);
                        ComposerKt.sourceInformation(i14, "536@24609L221");
                        Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(i14, 733328855, str2);
                        valueOf6 = 0;
                        i35 = 0;
                        ComposerKt.sourceInformationMarkerStart(i14, -1323940314, $changed$iv2);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(i14, 0);
                        currentCompositionLocalMap = i14.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = center;
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(i14, then2);
                        $changed$iv = then2;
                        kotlin.jvm.functions.Function0 function05 = constructor3;
                        alignment = 0;
                        ComposerKt.sourceInformationMarkerStart(i14, -692256719, iNSTANCE);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i14.startReusableNode();
                        if (i14.getInserting()) {
                            i14.createNode(function05);
                        } else {
                            factory$iv$iv$iv2 = function05;
                            i14.useNode();
                        }
                        i25 = factory$iv$iv$iv2;
                        Composer constructor-impl2 = Updater.constructor-impl(i14);
                        int i142 = 0;
                        i2 = i92;
                        Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf6), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i148 = 0;
                        Composer composer17 = constructor-impl2;
                        int i154 = 0;
                        if (!composer17.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                            i29 = valueOf6;
                            if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer = composer17;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                            i29 = valueOf6;
                        }
                        Updater.set-impl(constructor-impl2, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        Composer composer11 = i14;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, restartGroup);
                        materializeModifier = BoxScopeInstance.INSTANCE;
                        i144 |= 6;
                        i18 = 0;
                        composer9 = i69;
                        measurePolicy = materializeModifier4;
                        materialized$iv$iv2 = function02;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 1888956396, "C540@24802L10:OutlinedTextField.kt#jmzs0o");
                        maybeCachedBoxMeasurePolicy.invoke(materialized$iv$iv2, Integer.valueOf(i70 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer11);
                        i14.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        i14.endReplaceGroup();
                    } else {
                        i14.startReplaceGroup(-988127596);
                        i14.endReplaceGroup();
                    }
                    float startPadding = PaddingKt.calculateStartPadding(obj4, (LayoutDirection)consume);
                    float endPadding = PaddingKt.calculateEndPadding(obj4, consume);
                    if (leading != null) {
                        int i91 = 0;
                        int i115 = 0;
                        materializeModifier = 0;
                        f2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        f2 = startPadding;
                    }
                    if (maybeCachedBoxMeasurePolicy != null) {
                        int i90 = 0;
                        int i113 = 0;
                        materializeModifier = 0;
                        f = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        f = endPadding;
                    }
                    padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, f2, 0, f, 0, 10, 0);
                    if ($composer$iv2 != null) {
                        i14.startReplaceGroup(-987369863);
                        ComposerKt.sourceInformation(i14, "561@25623L59");
                        $composer$iv2.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), i14, Integer.valueOf(i110 &= 112));
                        i14.endReplaceGroup();
                    } else {
                        i14.startReplaceGroup(-987282412);
                        i14.endReplaceGroup();
                    }
                    $dirty1 = 384;
                    i19 = 0;
                    obj2 = consume;
                    ComposerKt.sourceInformationMarkerStart(i14, 733328855, str2);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i124);
                    i35 = 0;
                    currentCompositeKeyHash2 = topStart;
                    ComposerKt.sourceInformationMarkerStart(i14, -1323940314, $changed$iv2);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(i14, 0);
                    currentCompositionLocalMap3 = i14.getCurrentCompositionLocalMap();
                    alignment = startPadding;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(i14, LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default));
                    i25 = endPadding;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    $changed$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(i14, -692256719, iNSTANCE);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i14.startReusableNode();
                    if (i14.getInserting()) {
                        i14.createNode(function06);
                    } else {
                        factory$iv$iv$iv = function06;
                        i14.useNode();
                    }
                    i34 = factory$iv$iv$iv;
                    Composer constructor-impl3 = Updater.constructor-impl(i14);
                    int i145 = 0;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i149 = 0;
                    Composer composer16 = constructor-impl3;
                    int i153 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap3;
                        i29 = maybeCachedBoxMeasurePolicy2;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = composer16;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap3;
                        i29 = maybeCachedBoxMeasurePolicy2;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = i14;
                    $composer$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, restartGroup);
                    maybeCachedBoxMeasurePolicy = BoxScopeInstance.INSTANCE;
                    i147 |= 6;
                    i18 = 0;
                    composer9 = i48;
                    measurePolicy = materializeModifier3;
                    materialized$iv$iv = i2;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1890012907, "C568@25867L11:OutlinedTextField.kt#jmzs0o");
                    valueOf4.invoke(materialized$iv$iv, Integer.valueOf(i49 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    i14.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i14);
                    ComposerKt.sourceInformationMarkerEnd(i14);
                    ComposerKt.sourceInformationMarkerEnd(i14);
                    if (label != null) {
                        i14.startReplaceGroup(-987052578);
                        ComposerKt.sourceInformation(i14, "572@25943L54");
                        Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label");
                        valueOf2 = 6;
                        materialized$iv$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(i14, 733328855, str2);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        $dirty = 0;
                        ComposerKt.sourceInformationMarkerStart(i14, -1323940314, $changed$iv2);
                        $changed$iv2 = ComposablesKt.getCurrentCompositeKeyHash(i14, 0);
                        i19 = topStart2;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(i14, layoutId);
                        companion = layoutId;
                        kotlin.jvm.functions.Function0 function04 = constructor;
                        i11 = 0;
                        ComposerKt.sourceInformationMarkerStart(i14, -692256719, iNSTANCE);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i14.startReusableNode();
                        if (i14.getInserting()) {
                            i14.createNode(function04);
                        } else {
                            factory$iv$iv$iv4 = function04;
                            i14.useNode();
                        }
                        Composer constructor-impl5 = Updater.constructor-impl(i14);
                        int i130 = 0;
                        i35 = factory$iv$iv$iv4;
                        Updater.set-impl(constructor-impl5, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, i14.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i133 = 0;
                        Composer composer15 = constructor-impl5;
                        int i137 = 0;
                        if (!composer15.getInserting()) {
                            $changed$iv = valueOf2;
                            if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf($changed$iv2))) {
                                composer15.updateRememberedValue(Integer.valueOf($changed$iv2));
                                constructor-impl5.apply(Integer.valueOf($changed$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer3 = composer15;
                            }
                        } else {
                            $changed$iv = valueOf2;
                        }
                        Updater.set-impl(constructor-impl5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        valueOf4 = i14;
                        $composer$iv2 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf4, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i121 |= 6;
                        composer6 = valueOf4;
                        i15 = 0;
                        i16 = i55;
                        currentCompositeKeyHash2 = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart(valueOf4, 1890132815, "C572@25988L7:OutlinedTextField.kt#jmzs0o");
                        label.invoke(valueOf4, Integer.valueOf(i56 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(valueOf4);
                        ComposerKt.sourceInformationMarkerEnd(valueOf4);
                        i14.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        ComposerKt.sourceInformationMarkerEnd(i14);
                        i14.endReplaceGroup();
                    } else {
                        obj = label;
                        i14.startReplaceGroup(-986969932);
                        i14.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(i14);
                    composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj = materialized$iv$iv;
                    i8 = $dirty;
                    composer8 = restartGroup;
                    i17 = $dirty1;
                }
            } else {
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer8.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new OutlinedTextFieldKt.OutlinedTextFieldLayout.2(modifier, textField, placeholder, obj, leading, trailing, singleLine, animationProgress, onLabelMeasured, border, obj4, $changed, $changed1);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final int access$calculateHeight-O3s9Psw(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        return OutlinedTextFieldKt.calculateHeight-O3s9Psw(leadingPlaceableHeight, trailingPlaceableHeight, textFieldPlaceableHeight, labelPlaceableHeight, placeholderPlaceableHeight, animationProgress, constraints, density, paddingValues);
    }

    public static final int access$calculateWidth-O3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        return OutlinedTextFieldKt.calculateWidth-O3s9Psw(leadingPlaceableWidth, trailingPlaceableWidth, textFieldPlaceableWidth, labelPlaceableWidth, placeholderPlaceableWidth, animationProgress, constraints, density, paddingValues);
    }

    public static final float access$getOutlinedTextFieldInnerPadding$p() {
        return OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
    }

    public static final void access$place(Placeable.PlacementScope $receiver, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        OutlinedTextFieldKt.place($receiver, height, width, leadingPlaceable, trailingPlaceable, textFieldPlaceable, labelPlaceable, placeholderPlaceable, borderPlaceable, animationProgress, singleLine, density, layoutDirection, paddingValues);
    }

    public static final int access$substractConstraintSafely(int $receiver, int from) {
        return OutlinedTextFieldKt.substractConstraintSafely($receiver, from);
    }

    private static final int calculateHeight-O3s9Psw(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        topPadding-D9Ej5fM *= paddingValues;
        return Math.max(Constraints.getMinHeight-impl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(i8 += i7))));
    }

    private static final int calculateWidth-O3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int i9 = 0;
        return Math.max(i4 += trailingPlaceableWidth, Math.max(MathKt.roundToInt(i7 *= animationProgress), Constraints.getMinWidth-impl(constraints)));
    }

    public static final long getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldKt.OutlinedTextFieldTopPadding;
    }

    public static final Modifier outlineCutout-12SF9DM(Modifier $this$outlineCutout_u2d12SF9DM, long labelSize, PaddingValues paddingValues) {
        OutlinedTextFieldKt.outlineCutout.1 anon = new OutlinedTextFieldKt.outlineCutout.1(labelSize, paddingValues, obj4);
        return DrawModifierKt.drawWithContent($this$outlineCutout_u2d12SF9DM, (Function1)anon);
    }

    private static final void place(Placeable.PlacementScope $this$place, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Alignment.Vertical centerVertically;
        int align3;
        int height2;
        int i7;
        Placeable.PlacementScope roundToInt;
        int i8;
        Placeable height3;
        int i11;
        int align;
        int i5;
        int i12;
        int i3;
        Placeable.PlacementScope placementScope2;
        Placeable.PlacementScope placementScope;
        Placeable placeable;
        Placeable placeable2;
        int i4;
        int widthOrZero;
        int align2;
        int i;
        int i13;
        int i2;
        int i14;
        int i9;
        int i6;
        int i10;
        final int i15 = height;
        final float f = animationProgress;
        int roundToInt2 = MathKt.roundToInt(topPadding-D9Ej5fM *= density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i15), 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i15), 0, 4, 0);
        }
        if (labelPlaceable != null) {
            placeable = labelPlaceable;
            centerVertically = 0;
            if (singleLine) {
                height2 = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i15);
            } else {
                height2 = roundToInt2;
            }
            if (leadingPlaceable == null) {
                i8 = 0;
            } else {
                i22 *= height3;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable, roundToInt + roundToInt3, MathHelpersKt.lerp(height2, -i20, f), 0, 4, 0);
        }
        if (singleLine) {
            align3 = Alignment.Companion.getCenterVertically().align(textFieldPlaceable.getHeight(), i15);
        } else {
            align3 = roundToInt2;
        }
        i = Math.max(align3, heightOrZero /= 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i, 0, 4, 0);
        int i19 = i;
        if (placeholderPlaceable != null) {
            placeable2 = placeholderPlaceable;
            i7 = 0;
            if (singleLine) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i15);
            } else {
                roundToInt = roundToInt2;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable2, TextFieldImplKt.widthOrZero(leadingPlaceable), Math.max(roundToInt, heightOrZero2 /= 2), 0, 4, 0);
        }
        Placeable.PlacementScope.place-70tqf50$default($this$place, borderPlaceable, IntOffset.Companion.getZero-nOcc-ac(), i, 0, 2);
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
