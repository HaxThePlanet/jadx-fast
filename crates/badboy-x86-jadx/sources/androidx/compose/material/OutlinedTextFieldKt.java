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
        Object obj12;
        Object obj13;
        boolean z;
        Object obj15;
        Object obj17;
        Object obj;
        boolean z6;
        int i63;
        int i66;
        Object obj3;
        Object obj9;
        int $dirty12;
        Object $dirty17;
        Object $dirty15;
        Object endRestartGroup;
        int $dirty3;
        int $dirty5;
        int defaultsInvalid;
        int traceInProgress;
        int rememberedValue;
        Object value2;
        Modifier padding-qDBjuR0$default;
        int $composer3;
        Object $dirty4;
        int $dirty;
        int $dirty2;
        int i13;
        int i46;
        int colors2;
        int default;
        int $dirty14;
        boolean z2;
        int $dirty16;
        Object $dirty1;
        Composer $composer2;
        boolean z3;
        Object obj20;
        Object obj5;
        Object obj18;
        boolean field2;
        String enabled3;
        int i3;
        int i23;
        int outlinedTextFieldShape;
        Object enabled2;
        boolean readOnly3;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i77;
        Object readOnly2;
        int i68;
        Object obj19;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
        TextStyle merge;
        int i18;
        Object obj6;
        KeyboardOptions i41;
        int keyboardOptions2;
        Object visualTransformation3;
        Object shape2;
        int keyboardActions2;
        int i;
        int field;
        int i35;
        VisualTransformation singleLine2;
        int z4;
        int i52;
        KeyboardOptions maxLines2;
        Object obj7;
        int obj8;
        KeyboardActions minLines2;
        Object obj2;
        VisualTransformation i69;
        int visualTransformation4;
        int i19;
        int i50;
        int i53;
        int i60;
        int i15;
        int i56;
        int i36;
        int changed6;
        int i48;
        int changed5;
        int i34;
        long $i$a$TakeOrElseDxMtmZcOutlinedTextFieldKt$OutlinedTextField$textColor$2;
        int i4;
        int i70;
        int i54;
        int companion;
        Shape shape3;
        int i74;
        int i28;
        int $dirty13;
        Object field3;
        int i61;
        int i20;
        int i42;
        TextStyle textStyle3;
        int i25;
        int i72;
        int i12;
        int i78;
        int changed7;
        int i49;
        int i75;
        int i62;
        int i6;
        int i21;
        int i11;
        int i14;
        int changed3;
        int changed2;
        int i7;
        int changed4;
        int i59;
        int i30;
        int i9;
        int i17;
        int i8;
        int i37;
        int i43;
        int i26;
        int i76;
        boolean changed;
        int i64;
        int i65;
        int i67;
        int i79;
        int i73;
        int i5;
        int i2;
        int i33;
        int i47;
        int i55;
        int i27;
        int i29;
        int i40;
        Composer composer;
        Composer composer2;
        int i10;
        int i38;
        int i51;
        int i45;
        boolean z5;
        boolean z7;
        Object obj16;
        int i39;
        Object obj10;
        Object obj11;
        int i31;
        int obj14;
        int i32;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions3;
        int i44;
        int i22;
        int i58;
        int textStyle2;
        Shape obj4;
        int i57;
        int i71;
        int i16;
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
        $dirty16 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty |= 6;
            obj20 = value;
        } else {
            if (i80 & 6 == 0) {
                i68 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i68;
            } else {
                obj20 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty |= 48;
            obj19 = onValueChange;
        } else {
            if (i80 & 48 == 0) {
                i = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i;
            } else {
                obj19 = onValueChange;
            }
        }
        i35 = traceInProgress & 4;
        if (i35 != 0) {
            $dirty |= 384;
            obj2 = modifier;
        } else {
            if (i80 & 384 == 0) {
                i19 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i19;
            } else {
                obj2 = modifier;
            }
        }
        i50 = traceInProgress & 8;
        changed6 = 1024;
        if (i50 != 0) {
            $dirty |= 3072;
            field2 = enabled;
        } else {
            if (i80 & 3072 == 0) {
                i54 = restartGroup.changed(enabled) ? i60 : changed6;
                $dirty |= i54;
            } else {
                field2 = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty |= 24576;
            readOnly3 = readOnly;
        } else {
            if (i80 & 24576 == 0) {
                i25 = restartGroup.changed(readOnly) ? 16384 : i74;
                $dirty |= i25;
            } else {
                readOnly3 = readOnly;
            }
        }
        if (i80 & i183 == 0) {
            if (traceInProgress & 32 == 0) {
                changed7 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj6 = textStyle;
            }
            $dirty |= changed7;
        } else {
            obj6 = textStyle;
        }
        i49 = traceInProgress & 64;
        i75 = 1572864;
        i7 = 524288;
        if (i49 != 0) {
            $dirty |= i75;
            visualTransformation3 = label;
        } else {
            if (i80 & i75 == 0) {
                i59 = restartGroup.changedInstance(label) ? 1048576 : i7;
                $dirty |= i59;
            } else {
                visualTransformation3 = label;
            }
        }
        i52 = traceInProgress & 128;
        i30 = 12582912;
        if (i52 != 0) {
            $dirty |= i30;
            obj7 = placeholder;
        } else {
            if (i80 & i30 == 0) {
                i17 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i17;
            } else {
                obj7 = placeholder;
            }
        }
        int i81 = traceInProgress & 256;
        int i193 = 100663296;
        if (i81 != 0) {
            $dirty |= i193;
            i8 = i81;
            obj12 = leadingIcon;
        } else {
            if ($changed & i193 == 0) {
                i8 = i81;
                i37 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i37;
            } else {
                i8 = i81;
                obj12 = leadingIcon;
            }
        }
        int i82 = traceInProgress & 512;
        int i195 = 805306368;
        if (i82 != 0) {
            $dirty |= i195;
            i43 = i82;
            obj13 = trailingIcon;
        } else {
            if ($changed & i195 == 0) {
                i43 = i82;
                i26 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i26;
            } else {
                i43 = i82;
                obj13 = trailingIcon;
            }
        }
        int i83 = traceInProgress & 1024;
        if (i83 != 0) {
            $dirty16 |= 6;
            i76 = i83;
            z = isError;
        } else {
            if (i91 & 6 == 0) {
                i76 = i83;
                i61 = restartGroup.changed(isError) ? 4 : 2;
                $dirty16 |= i61;
            } else {
                i76 = i83;
                z = isError;
            }
        }
        int i84 = traceInProgress & 2048;
        if (i84 != 0) {
            $dirty16 |= 48;
            i20 = i84;
            obj15 = visualTransformation;
        } else {
            if (i91 & 48 == 0) {
                i20 = i84;
                changed4 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty16 |= changed4;
            } else {
                i20 = i84;
                obj15 = visualTransformation;
            }
        }
        int i85 = traceInProgress & 4096;
        if (i85 != 0) {
            $dirty16 |= 384;
            i12 = i85;
            obj17 = keyboardOptions;
        } else {
            i12 = i85;
            if (i91 & 384 == 0) {
                i59 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty16 |= i59;
            } else {
                obj17 = keyboardOptions;
            }
        }
        if (i91 & 3072 == 0) {
            if (traceInProgress & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i60 = changed6;
                }
            } else {
                obj = keyboardActions;
            }
            $dirty16 |= i60;
        } else {
            obj = keyboardActions;
        }
        int i88 = traceInProgress & 16384;
        if (i88 != 0) {
            $dirty16 |= 24576;
            i15 = i88;
            z6 = singleLine;
        } else {
            i15 = i88;
            if (i91 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i74 = 16384;
                }
                $dirty16 |= i74;
            } else {
                z6 = singleLine;
            }
        }
        if (i91 & i173 == 0) {
            if (traceInProgress & i174 == 0) {
                i48 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i63 = maxLines;
            }
            $dirty16 |= i48;
        } else {
            i63 = maxLines;
        }
        i34 = traceInProgress & i175;
        if (i34 != 0) {
            $dirty16 |= i75;
            i66 = minLines;
        } else {
            if (i91 & i75 == 0) {
                i74 = restartGroup.changed(minLines) ? 1048576 : i7;
                $dirty16 |= i74;
            } else {
                i66 = minLines;
            }
        }
        i28 = traceInProgress & i179;
        if (i28 != 0) {
            $dirty16 |= i30;
            obj3 = interactionSource;
        } else {
            if (i91 & i30 == 0) {
                i75 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty16 |= i75;
            } else {
                obj3 = interactionSource;
            }
        }
        if (i91 & i186 == 0) {
            if (traceInProgress & i189 == 0) {
                i62 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj9 = shape;
            }
            $dirty16 |= i62;
        } else {
            obj9 = shape;
        }
        if (i91 & i187 == 0) {
            if (traceInProgress & i7 == 0) {
                obj92 = $dirty16;
                i14 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj92 = $dirty16;
                $dirty1 = colors;
            }
            $dirty12 = i6;
        } else {
            $dirty1 = colors;
            $dirty12 = obj92;
        }
        obj92 = $dirty;
        if ($dirty & i21 == 306783378 && i93 &= $dirty12 == 306783378) {
            if (i93 &= $dirty12 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i111 = 6;
                    int i114 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i35 != 0) {
                                $dirty3 = Modifier.Companion;
                            } else {
                                $dirty3 = obj2;
                            }
                            z5 = i50 != 0 ? field2 : field2;
                            z7 = companion != 0 ? field2 : readOnly3;
                            if (traceInProgress & 32 != 0) {
                                readOnly3 = 6;
                                i35 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj16 = default;
                                i39 = i3;
                            } else {
                                i50 = default;
                                i39 = obj92;
                                obj16 = obj6;
                            }
                            obj10 = i49 != 0 ? default : visualTransformation3;
                            obj11 = i52 != 0 ? default : obj7;
                            i31 = i8 != 0 ? default : leadingIcon;
                            obj14 = i43 != 0 ? default : trailingIcon;
                            i32 = i76 != 0 ? default : isError;
                            if (i20 != 0) {
                                visualTransformation2 = default;
                            } else {
                                visualTransformation2 = visualTransformation;
                            }
                            if (i12 != 0) {
                                keyboardOptions3 = default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (traceInProgress & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty14 = $dirty18;
                                $dirty15 = keyboardActions3;
                            } else {
                                $dirty14 = $dirty12;
                                $dirty15 = keyboardActions;
                            }
                            i44 = i15 != 0 ? i3 : singleLine;
                            if (i133 &= traceInProgress != 0) {
                                i23 = i44 != 0 ? i114 : 0x7fffffff /* Unknown resource */;
                                $dirty14 &= i50;
                                i22 = i23;
                            } else {
                                i22 = maxLines;
                            }
                            i58 = i34 != 0 ? i23 : minLines;
                            textStyle2 = i28 != 0 ? i23 : interactionSource;
                            if (i134 &= traceInProgress != 0) {
                                obj4 = outlinedTextFieldShape;
                                i57 = $dirty14;
                            } else {
                                obj4 = shape;
                                i57 = $dirty14;
                            }
                            if (traceInProgress & i7 != 0) {
                                int i148 = i114;
                                int i157 = i135;
                                int i163 = i157;
                                int i166 = i158;
                                i50 = i166;
                                i34 = i50;
                                i28 = i34;
                                i12 = i28;
                                i21 = i12;
                                changed4 = i21;
                                i30 = changed4;
                                i8 = i30;
                                i76 = i8;
                                i64 = i76;
                                i67 = i64;
                                i73 = i67;
                                i2 = i73;
                                i47 = i2;
                                i27 = i47;
                                i40 = i27;
                                int i207 = i205;
                                composer = restartGroup;
                                int $composer5 = i16;
                                $composer2 = composer;
                                shape2 = $dirty15;
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = i131;
                                field2 = z5;
                                readOnly3 = z7;
                                $dirty17 = obj16;
                                $composer3 = i39;
                                i69 = visualTransformation2;
                                i41 = keyboardOptions3;
                                field = i44;
                                z4 = i22;
                                obj8 = i58;
                                obj5 = outlinedTextFieldColors-dx8h9Zs;
                                colors2 = i32;
                            } else {
                                $composer2 = restartGroup;
                                int $composer4 = i114;
                                obj5 = colors;
                                shape2 = $dirty15;
                                field2 = z5;
                                readOnly3 = z7;
                                $dirty17 = obj16;
                                $composer3 = i39;
                                colors2 = i32;
                                i69 = visualTransformation2;
                                i41 = keyboardOptions3;
                                field = i44;
                                z4 = i22;
                                obj8 = i58;
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = i57;
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
                                $dirty12 &= i13;
                            }
                            if (traceInProgress & i7 != 0) {
                                $dirty12 &= i46;
                            }
                            i31 = leadingIcon;
                            obj14 = trailingIcon;
                            colors2 = isError;
                            field = singleLine;
                            z4 = maxLines;
                            textStyle2 = interactionSource;
                            obj4 = shape;
                            obj5 = colors;
                            $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = $dirty12;
                            $composer2 = restartGroup;
                            $dirty17 = obj6;
                            obj10 = visualTransformation3;
                            obj11 = obj7;
                            i41 = keyboardOptions;
                            shape2 = keyboardActions;
                            obj8 = minLines;
                            $composer3 = $dirty5;
                            $dirty3 = obj2;
                            i69 = visualTransformation;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj87 = readOnly3;
                        ComposerKt.traceEventStart(237745923, $composer3, $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:366)");
                    } else {
                        obj87 = readOnly3;
                    }
                    if (textStyle2 == 0) {
                        $composer2.startReplaceGroup(-579730026);
                        ComposerKt.sourceInformation($composer2, "368@18581L39");
                        ComposerKt.sourceInformationMarkerStart($composer2, 674035692, "CC(remember):OutlinedTextField.kt#9igjgp");
                        readOnly3 = $composer2;
                        int i171 = 0;
                        obj74 = i97;
                        rememberedValue = readOnly3.rememberedValue();
                        i34 = 0;
                        $dirty13 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i154 = 0;
                            readOnly3.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                        i56 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                    } else {
                        $dirty13 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                        $composer2.startReplaceGroup(674035041);
                        $composer2.endReplaceGroup();
                        i56 = textStyle2;
                    }
                    $composer2.startReplaceGroup(674040799);
                    ComposerKt.sourceInformation($composer2, "*371@18768L18");
                    i42 = 0;
                    i78 = Long.compare($i$a$TakeOrElseDxMtmZcOutlinedTextFieldKt$OutlinedTextField$textColor$2, i184) != 0 ? 1 : 0;
                    if (i78 != 0) {
                    } else {
                        int i176 = 0;
                        obj74 = value2;
                        $this$takeOrElse_u2dDxMtmZc$iv = $i$a$TakeOrElseDxMtmZcOutlinedTextFieldKt$OutlinedTextField$textColor$2;
                    }
                    $composer2.endReplaceGroup();
                    long l = $this$takeOrElse_u2dDxMtmZc$iv;
                    textStyle3 = new TextStyle(l, i49, 0, i7, 0, 0, 0, 0, 0, 0, i76, 0, 0, 0, 0, i79, 0, 0, 0, 0, 0, 0, i27, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    long l2 = l;
                    merge = $dirty17.merge(textStyle3);
                    i77 = 0;
                    i4 = 0;
                    obj76 = field2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (obj10 != null) {
                        obj74 = i147;
                        obj89 = merge;
                        padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SemanticsModifierKt.semantics((Modifier)Modifier.Companion, true, (Function1)OutlinedTextFieldKt.OutlinedTextField.7.INSTANCE), 0, (Density)consume.toDp-GaN1DYA(OutlinedTextFieldKt.OutlinedTextFieldTopPadding), 0, 0, 13, 0);
                    } else {
                        obj89 = merge;
                        padding-qDBjuR0$default = Modifier.Companion;
                    }
                    i151 &= 112;
                    obj90 = consume;
                    SolidColor solidColor = new SolidColor((Color)obj5.cursorColor(colors2, $composer2, i139 |= i152).getValue().unbox-impl(), i152, 0);
                    obj74 = anon;
                    obj80 = colors2;
                    obj86 = obj5;
                    super(value, obj76, field, i69, i56, obj80, obj10, obj11, i31, obj14, obj4, obj86);
                    boolean z8 = obj76;
                    boolean z9 = obj87;
                    i71 = $dirty13;
                    Composer $dirty110 = $composer2;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics($dirty3.then(padding-qDBjuR0$default), colors2, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), z8, z9, obj89, i41, shape2, field, z4, obj8, i69, 0, i56, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-1001528775, true, obj74, $composer2, 54), $dirty110, i106 | i127, i109 | i129, 4096);
                    composer2 = $dirty110;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation4 = field;
                    singleLine2 = visualTransformation5;
                    obj18 = obj88;
                    field3 = $dirty12;
                    i11 = $composer3;
                    z2 = z8;
                    z3 = z9;
                    i53 = z4;
                    i36 = obj8;
                    enabled2 = obj10;
                    readOnly2 = obj11;
                    i18 = i31;
                    i70 = textStyle2;
                    shape3 = obj4;
                    $dirty4 = $dirty3;
                    maxLines2 = i41;
                    minLines2 = shape2;
                    keyboardOptions2 = obj14;
                    keyboardActions2 = i32;
                } else {
                    restartGroup.skipToGroupEnd();
                    i18 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i53 = maxLines;
                    i36 = minLines;
                    i70 = interactionSource;
                    shape3 = shape;
                    i11 = obj92;
                    i71 = $dirty12;
                    composer2 = restartGroup;
                    field3 = $dirty1;
                    z2 = field2;
                    z3 = readOnly3;
                    obj18 = obj6;
                    enabled2 = visualTransformation3;
                    readOnly2 = obj7;
                    $dirty4 = obj2;
                    keyboardOptions2 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation4 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.10(value, onValueChange, $dirty4, z2, z3, obj18, enabled2, readOnly2, i18, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation4, i53, i36, i70, shape3, field3, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void OutlinedTextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj4;
        Object obj3;
        boolean z;
        Object obj12;
        Object obj;
        Object obj8;
        boolean z3;
        int i7;
        Object obj13;
        Object obj22;
        int keyboardActions3;
        Object $dirty13;
        Object endRestartGroup;
        int modifier3;
        int defaultsInvalid;
        Object modifier2;
        int i21;
        int i;
        int i49;
        int i33;
        Object outlinedTextFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer3;
        int $dirty2;
        int $dirty;
        int $dirty15;
        int this_$iv;
        int $dirty14;
        boolean z7;
        int $dirty12;
        Object $dirty1;
        boolean z5;
        Object obj7;
        Object obj10;
        Object modifier4;
        boolean invalid$iv;
        int outlinedTextFieldShape;
        Object enabled2;
        boolean z4;
        Object readOnly2;
        int i57;
        Object obj11;
        Object obj17;
        int textStyle2;
        Object obj5;
        Object obj2;
        int label2;
        Object rememberedValue;
        Object obj16;
        int placeholder2;
        int i37;
        int i3;
        int consume;
        VisualTransformation leadingIcon2;
        int i25;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11;
        KeyboardOptions trailingIcon2;
        Object obj19;
        int i2;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation3;
        int visualTransformation2;
        int i55;
        KeyboardOptions keyboardOptions3;
        int keyboardOptions2;
        int i34;
        int i51;
        KeyboardActions keyboardActions5;
        Object keyboardActions4;
        int changed5;
        int i28;
        Shape singleLine2;
        int i20;
        int i45;
        Object maxLines2;
        int i42;
        int i16;
        int i50;
        int i8;
        int i13;
        int changed2;
        int i27;
        Object i9;
        int changed6;
        int i14;
        int i24;
        int i18;
        Object obj21;
        int colors2;
        int i5;
        int i4;
        int i6;
        int i38;
        int i39;
        int changed4;
        int i31;
        int changed;
        int i44;
        int i32;
        int i43;
        int i19;
        int i47;
        int i41;
        int i30;
        int i36;
        boolean changed3;
        int i10;
        int i46;
        int i40;
        int i29;
        int i26;
        Composer $composer2;
        int i35;
        int i54;
        int i11;
        int i17;
        boolean z6;
        boolean z2;
        Object obj15;
        int i56;
        Object obj9;
        Object obj20;
        int i15;
        int i48;
        int i12;
        Object obj14;
        KeyboardOptions keyboardOptions4;
        int i53;
        int i22;
        Object obj18;
        Object obj6;
        int i52;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions2;
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
        i33 = i23;
        outlinedTextFieldColors-dx8h9Zs = $composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation(outlinedTextFieldColors-dx8h9Zs, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)449@21584L7,460@22138L39,461@22216L22,462@22288L25,464@22322L416:OutlinedTextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if (i33 & 1 != 0) {
            $dirty2 |= 6;
            obj7 = value;
        } else {
            if (i58 & 6 == 0) {
                i57 = outlinedTextFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty2 |= i57;
            } else {
                obj7 = value;
            }
        }
        if (i33 & 2 != 0) {
            $dirty2 |= 48;
            obj11 = onValueChange;
        } else {
            if (i58 & 48 == 0) {
                i37 = outlinedTextFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i37;
            } else {
                obj11 = onValueChange;
            }
        }
        consume = i33 & 4;
        if (consume != 0) {
            $dirty2 |= 384;
            str = modifier;
        } else {
            if (i58 & 384 == 0) {
                i55 = outlinedTextFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty2 |= i55;
            } else {
                str = modifier;
            }
        }
        int i143 = i33 & 8;
        changed5 = 1024;
        if (i143 != 0) {
            $dirty2 |= 3072;
            invalid$iv = enabled;
        } else {
            if (i58 & 3072 == 0) {
                i20 = outlinedTextFieldColors-dx8h9Zs.changed(enabled) ? i34 : changed5;
                $dirty2 |= i20;
            } else {
                invalid$iv = enabled;
            }
        }
        int i147 = i33 & 16;
        i50 = 8192;
        if (i147 != 0) {
            $dirty2 |= 24576;
            z4 = readOnly;
        } else {
            if (i58 & 24576 == 0) {
                i18 = outlinedTextFieldColors-dx8h9Zs.changed(readOnly) ? i42 : i50;
                $dirty2 |= i18;
            } else {
                z4 = readOnly;
            }
        }
        int i151 = 196608;
        i38 = 65536;
        i39 = 131072;
        if (i58 & i151 == 0) {
            if (i33 & 32 == 0) {
                changed4 = outlinedTextFieldColors-dx8h9Zs.changed(textStyle) ? i39 : i38;
            } else {
                obj5 = textStyle;
            }
            $dirty2 |= changed4;
        } else {
            obj5 = textStyle;
        }
        i31 = i33 & 64;
        final int i160 = 1572864;
        if (i31 != 0) {
            $dirty2 |= i160;
            rememberedValue = label;
        } else {
            if (i58 & i160 == 0) {
                i44 = outlinedTextFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= i44;
            } else {
                rememberedValue = label;
            }
        }
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 = i33 & 128;
        final int i154 = 12582912;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 != 0) {
            $dirty2 |= i154;
            obj19 = placeholder;
        } else {
            if (i58 & i154 == 0) {
                i43 = outlinedTextFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i43;
            } else {
                obj19 = placeholder;
            }
        }
        int i59 = i33 & 256;
        int i155 = 100663296;
        if (i59 != 0) {
            $dirty2 |= i155;
            i19 = i59;
            obj4 = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i19 = i59;
                i47 = outlinedTextFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i47;
            } else {
                i19 = i59;
                obj4 = leadingIcon;
            }
        }
        int i60 = i33 & 512;
        int i157 = 805306368;
        if (i60 != 0) {
            $dirty2 |= i157;
            i41 = i60;
            obj3 = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                i41 = i60;
                i30 = outlinedTextFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i30;
            } else {
                i41 = i60;
                obj3 = trailingIcon;
            }
        }
        int i61 = i33 & 1024;
        if (i61 != 0) {
            $dirty12 |= 6;
            i36 = i61;
            z = isError;
        } else {
            if (i69 & 6 == 0) {
                i36 = i61;
                i14 = outlinedTextFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty12 |= i14;
            } else {
                i36 = i61;
                z = isError;
            }
        }
        int i62 = i33 & 2048;
        if (i62 != 0) {
            $dirty12 |= 48;
            i24 = i62;
            obj12 = visualTransformation;
        } else {
            if (i69 & 48 == 0) {
                i24 = i62;
                changed = outlinedTextFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= changed;
            } else {
                i24 = i62;
                obj12 = visualTransformation;
            }
        }
        int i63 = i33 & 4096;
        if (i63 != 0) {
            $dirty12 |= 384;
            i4 = i63;
            obj = keyboardOptions;
        } else {
            i4 = i63;
            if (i69 & 384 == 0) {
                i44 = outlinedTextFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty12 |= i44;
            } else {
                obj = keyboardOptions;
            }
        }
        if (i69 & 3072 == 0) {
            if (i33 & 8192 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i34 = changed5;
                }
            } else {
                obj8 = keyboardActions;
            }
            $dirty12 |= i34;
        } else {
            obj8 = keyboardActions;
        }
        int i66 = i33 & 16384;
        if (i66 != 0) {
            $dirty12 |= 24576;
            i51 = i66;
            z3 = singleLine;
        } else {
            i51 = i66;
            if (i69 & 24576 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i42 = i50;
                }
                $dirty12 |= i42;
            } else {
                z3 = singleLine;
            }
        }
        int i146 = i33 & i145;
        if (i146 != 0) {
            $dirty12 |= i151;
            i7 = maxLines;
        } else {
            if (i69 & i151 == 0) {
                i42 = outlinedTextFieldColors-dx8h9Zs.changed(maxLines) ? i39 : i38;
                $dirty12 |= i42;
            } else {
                i7 = maxLines;
            }
        }
        i16 = i33 & i38;
        if (i16 != 0) {
            $dirty12 |= i160;
            obj13 = interactionSource;
        } else {
            if (i69 & i160 == 0) {
                i50 = outlinedTextFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty12 |= i50;
            } else {
                obj13 = interactionSource;
            }
        }
        if (i69 & i154 == 0) {
            if (i33 & i39 == 0) {
                i8 = outlinedTextFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj22 = shape;
            }
            $dirty12 |= i8;
        } else {
            obj22 = shape;
        }
        int i152 = 262144;
        if (i69 & i155 == 0) {
            if (i33 & i152 == 0) {
                obj90 = $dirty12;
                i13 = outlinedTextFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty12;
                $dirty1 = colors;
            }
            keyboardActions3 = i27;
        } else {
            $dirty1 = colors;
            keyboardActions3 = obj90;
        }
        obj90 = $dirty2;
        if ($dirty2 & i9 == 306783378 && i71 &= keyboardActions3 == 38347922) {
            if (i71 &= keyboardActions3 == 38347922) {
                if (!outlinedTextFieldColors-dx8h9Zs.getSkipping()) {
                    outlinedTextFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (outlinedTextFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = str;
                            }
                            z6 = i143 != 0 ? $dirty : invalid$iv;
                            z2 = i147 != 0 ? $dirty : z4;
                            if (i33 & 32 != 0) {
                                int i129 = 6;
                                z4 = 0;
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj15 = this_$iv;
                                i56 = invalid$iv;
                            } else {
                                i56 = obj90;
                                obj15 = obj5;
                            }
                            obj9 = i31 != 0 ? this_$iv : rememberedValue;
                            obj20 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 != 0 ? this_$iv : obj19;
                            i15 = i19 != 0 ? this_$iv : leadingIcon;
                            i48 = i41 != 0 ? this_$iv : trailingIcon;
                            i12 = i36 != 0 ? this_$iv : isError;
                            if (i24 != 0) {
                                obj14 = this_$iv;
                            } else {
                                obj14 = visualTransformation;
                            }
                            if (i4 != 0) {
                                keyboardOptions4 = this_$iv;
                            } else {
                                keyboardOptions4 = keyboardOptions;
                            }
                            if (i33 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty14 = $dirty16;
                                $dirty13 = keyboardActions2;
                            } else {
                                $dirty14 = keyboardActions3;
                                $dirty13 = keyboardActions;
                            }
                            i53 = i51 != 0 ? invalid$iv : singleLine;
                            i22 = i146 != 0 ? invalid$iv : maxLines;
                            if (i16 != 0) {
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 674149516, "CC(remember):OutlinedTextField.kt#9igjgp");
                                int i128 = 0;
                                z4 = outlinedTextFieldColors-dx8h9Zs;
                                obj5 = 0;
                                rememberedValue = z4.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i140 = 0;
                                    z4.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$11 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj18 = invalid$iv;
                            } else {
                                obj18 = interactionSource;
                            }
                            if (i33 & i39 != 0) {
                                obj6 = outlinedTextFieldShape;
                                i52 = $dirty14;
                            } else {
                                obj6 = shape;
                                i52 = $dirty14;
                            }
                            if (i33 & i152 != 0) {
                                keyboardActions5 = $dirty13;
                                obj10 = modifier2;
                                obj21 = outlinedTextFieldColors-dx8h9Zs;
                                keyboardActions3 = $dirty15;
                                invalid$iv = z6;
                                z4 = z2;
                                obj17 = obj15;
                                modifier3 = i56;
                                obj2 = obj9;
                                obj16 = obj20;
                                i3 = i15;
                                i25 = i48;
                                i2 = i12;
                                visualTransformation3 = obj14;
                                keyboardOptions3 = keyboardOptions4;
                                i28 = i53;
                                i45 = i22;
                                i9 = obj18;
                                i24 = obj6;
                            } else {
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                obj21 = colors;
                                keyboardActions5 = $dirty13;
                                obj10 = modifier2;
                                invalid$iv = z6;
                                z4 = z2;
                                obj17 = obj15;
                                modifier3 = i56;
                                obj2 = obj9;
                                obj16 = obj20;
                                i3 = i15;
                                i25 = i48;
                                i2 = i12;
                                visualTransformation3 = obj14;
                                keyboardOptions3 = keyboardOptions4;
                                i28 = i53;
                                i45 = i22;
                                i9 = obj18;
                                i24 = obj6;
                                keyboardActions3 = i52;
                            }
                        } else {
                            outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty15 = i33 & 32 != 0 ? obj90 & i21 : obj90;
                            if (i33 & 8192 != 0) {
                                keyboardActions3 &= -7169;
                            }
                            if (i33 & i39 != 0) {
                                keyboardActions3 &= i;
                            }
                            if (i33 & i152 != 0) {
                                keyboardActions3 &= i49;
                            }
                            i3 = leadingIcon;
                            i25 = trailingIcon;
                            keyboardOptions3 = keyboardOptions;
                            keyboardActions5 = keyboardActions;
                            i28 = singleLine;
                            i45 = maxLines;
                            i9 = interactionSource;
                            i24 = shape;
                            $composer2 = outlinedTextFieldColors-dx8h9Zs;
                            modifier3 = $dirty15;
                            obj21 = $dirty1;
                            obj17 = obj5;
                            obj2 = rememberedValue;
                            obj16 = obj19;
                            obj10 = str;
                            i2 = isError;
                            visualTransformation3 = visualTransformation;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-288998816, modifier3, keyboardActions3, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:463)");
                    }
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, obj10, invalid$iv, z4, obj17, obj2, obj16, i3, i25, i2, visualTransformation3, keyboardOptions3, keyboardActions5, i28, i45, 1, i9, i24, obj21, $composer2, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i6 = modifier3;
                    $composer3 = obj10;
                    z7 = invalid$iv;
                    z5 = z4;
                    modifier4 = obj17;
                    enabled2 = obj2;
                    readOnly2 = obj16;
                    textStyle2 = i3;
                    label2 = i25;
                    placeholder2 = i2;
                    leadingIcon2 = visualTransformation3;
                    trailingIcon2 = keyboardOptions3;
                    isError2 = keyboardActions5;
                    visualTransformation2 = i28;
                    keyboardOptions2 = i45;
                    keyboardActions4 = i9;
                    singleLine2 = i24;
                    maxLines2 = obj21;
                    colors2 = keyboardActions3;
                } else {
                    outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions2 = maxLines;
                    keyboardActions4 = interactionSource;
                    singleLine2 = shape;
                    i6 = obj90;
                    $composer2 = outlinedTextFieldColors-dx8h9Zs;
                    maxLines2 = $dirty1;
                    z7 = invalid$iv;
                    z5 = z4;
                    modifier4 = obj5;
                    enabled2 = rememberedValue;
                    readOnly2 = obj19;
                    $composer3 = str;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation2 = singleLine;
                    colors2 = keyboardActions3;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.12(value, onValueChange, $composer3, z7, z5, modifier4, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions4, singleLine2, maxLines2, $changed, $changed1, i33);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void OutlinedTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj22;
        Object obj12;
        boolean z;
        Object obj19;
        Object obj9;
        Object obj;
        boolean z6;
        int i8;
        int i16;
        Object obj10;
        Object obj6;
        int modifier2;
        int i88;
        int defaultsInvalid;
        Object endRestartGroup;
        int i43;
        int traceInProgress;
        int rememberedValue;
        long color-0d7_KjU;
        Modifier density;
        int $composer2;
        androidx.compose.runtime.ProvidableCompositionLocal localDensity;
        Object colors2;
        int $dirty2;
        Object $dirty3;
        String textStyle3;
        int i49;
        int outlinedTextFieldShape;
        boolean $dirty;
        int $dirty1;
        Object $dirty14;
        Composer $composer3;
        boolean z4;
        Object obj18;
        int obj3;
        Object obj13;
        boolean str;
        int localTextStyle;
        Object enabled2;
        boolean readOnly3;
        int i85;
        Object readOnly2;
        int i45;
        Object obj21;
        Object obj2;
        int i9;
        Object obj14;
        KeyboardOptions i23;
        int keyboardOptions3;
        Object visualTransformation3;
        Object shape2;
        int keyboardActions2;
        int i41;
        int field2;
        int i67;
        VisualTransformation singleLine2;
        int z3;
        KeyboardOptions maxLines2;
        Object obj7;
        int textStyle2;
        KeyboardActions minLines2;
        Object obj20;
        VisualTransformation i46;
        int visualTransformation4;
        int i40;
        int i19;
        int i34;
        int i52;
        int i35;
        int i54;
        int i74;
        int changed6;
        int i11;
        int i80;
        int l;
        int i26;
        int i47;
        int i14;
        int companion;
        Shape shape3;
        int i29;
        int i39;
        int i38;
        Object field;
        int i55;
        int i32;
        int i89;
        int i64;
        int changed;
        int i65;
        int i27;
        int i30;
        int $dirty13;
        int $dirty15;
        int changed5;
        int i3;
        int changed2;
        int i48;
        int changed7;
        int $dirty12;
        int i50;
        int changed4;
        int i83;
        int i81;
        int i7;
        int i44;
        int i60;
        int i15;
        int i66;
        int i21;
        boolean changed3;
        int i36;
        int i17;
        int i72;
        int i62;
        int i58;
        int i31;
        int i63;
        Composer composer;
        Composer composer2;
        int i78;
        int i69;
        int i2;
        int i86;
        boolean z5;
        boolean z2;
        Object obj8;
        int i12;
        Object obj17;
        Object obj11;
        int i61;
        int obj5;
        int i37;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        Object obj15;
        int i56;
        int i71;
        int i79;
        int obj4;
        Shape obj16;
        int textStyle4;
        long l2;
        int i77;
        int i68;
        int i4;
        int i75;
        int i87;
        int i73;
        int i20;
        int i22;
        int i18;
        int i33;
        int i76;
        int i13;
        int i28;
        int i;
        int i70;
        int i5;
        int i6;
        int i82;
        int i57;
        int i53;
        int i51;
        int i10;
        int i59;
        int i42;
        int i84;
        ScopeUpdateScope scopeUpdateScope;
        int i25;
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
        $dirty1 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty2 |= 6;
            obj18 = value;
        } else {
            if (i90 & 6 == 0) {
                i45 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i45;
            } else {
                obj18 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty2 |= 48;
            obj21 = onValueChange;
        } else {
            if (i90 & 48 == 0) {
                i41 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i41;
            } else {
                obj21 = onValueChange;
            }
        }
        i67 = traceInProgress & 4;
        if (i67 != 0) {
            $dirty2 |= 384;
            obj20 = modifier;
        } else {
            if (i90 & 384 == 0) {
                i40 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i40;
            } else {
                obj20 = modifier;
            }
        }
        int i175 = traceInProgress & 8;
        i74 = 1024;
        if (i175 != 0) {
            $dirty2 |= 3072;
            str = enabled;
        } else {
            if (i90 & 3072 == 0) {
                i14 = restartGroup.changed(enabled) ? i34 : i74;
                $dirty2 |= i14;
            } else {
                str = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty2 |= 24576;
            readOnly3 = readOnly;
        } else {
            if (i90 & 24576 == 0) {
                i55 = restartGroup.changed(readOnly) ? 16384 : 8192;
                $dirty2 |= i55;
            } else {
                readOnly3 = readOnly;
            }
        }
        final int i212 = 196608;
        if (i90 & i212 == 0) {
            if (traceInProgress & 32 == 0) {
                changed = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj14 = textStyle;
            }
            $dirty2 |= changed;
        } else {
            obj14 = textStyle;
        }
        i65 = traceInProgress & 64;
        i27 = 1572864;
        int i189 = 524288;
        if (i65 != 0) {
            $dirty2 |= i27;
            visualTransformation3 = label;
        } else {
            if (i90 & i27 == 0) {
                changed2 = restartGroup.changedInstance(label) ? 1048576 : i189;
                $dirty2 |= changed2;
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
                i7 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i7;
            } else {
                obj7 = placeholder;
            }
        }
        int i91 = traceInProgress & 256;
        int i197 = 100663296;
        if (i91 != 0) {
            $dirty2 |= i197;
            i44 = i91;
            obj22 = leadingIcon;
        } else {
            if ($changed & i197 == 0) {
                i44 = i91;
                i60 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i60;
            } else {
                i44 = i91;
                obj22 = leadingIcon;
            }
        }
        int i92 = traceInProgress & 512;
        int i200 = 805306368;
        if (i92 != 0) {
            $dirty2 |= i200;
            i15 = i92;
            obj12 = trailingIcon;
        } else {
            if ($changed & i200 == 0) {
                i15 = i92;
                i66 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i66;
            } else {
                i15 = i92;
                obj12 = trailingIcon;
            }
        }
        int i93 = traceInProgress & 1024;
        if (i93 != 0) {
            $dirty1 |= 6;
            i21 = i93;
            z = isError;
        } else {
            if (i109 & 6 == 0) {
                i21 = i93;
                i29 = restartGroup.changed(isError) ? 4 : 2;
                $dirty1 |= i29;
            } else {
                i21 = i93;
                z = isError;
            }
        }
        int i94 = traceInProgress & 2048;
        if (i94 != 0) {
            $dirty1 |= 48;
            i39 = i94;
            obj19 = visualTransformation;
        } else {
            if (i109 & 48 == 0) {
                i39 = i94;
                changed5 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= changed5;
            } else {
                i39 = i94;
                obj19 = visualTransformation;
            }
        }
        int i95 = traceInProgress & 4096;
        if (i95 != 0) {
            $dirty1 |= 384;
            i89 = i95;
            obj9 = keyboardOptions;
        } else {
            i89 = i95;
            if (i109 & 384 == 0) {
                changed2 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty1 |= changed2;
            } else {
                obj9 = keyboardOptions;
            }
        }
        int i97 = traceInProgress & 8192;
        if (i97 != 0) {
            $dirty1 |= 3072;
            i3 = i97;
            obj = keyboardActions;
        } else {
            i3 = i97;
            if (i109 & 3072 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i34 = i74;
                }
                $dirty1 |= i34;
            } else {
                obj = keyboardActions;
            }
        }
        int i98 = traceInProgress & 16384;
        if (i98 != 0) {
            $dirty1 |= 24576;
            i52 = i98;
            z6 = singleLine;
        } else {
            i52 = i98;
            if (i109 & 24576 == 0) {
                i74 = restartGroup.changed(singleLine) ? 16384 : 8192;
                $dirty1 |= i74;
            } else {
                z6 = singleLine;
            }
        }
        if (i109 & i212 == 0) {
            if (traceInProgress & i179 == 0) {
                i11 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i8 = maxLines;
            }
            $dirty1 |= i11;
        } else {
            i8 = maxLines;
        }
        i80 = traceInProgress & i180;
        if (i80 != 0) {
            $dirty1 |= i27;
            i16 = minLines;
        } else {
            if (i109 & i27 == 0) {
                i27 = restartGroup.changed(minLines) ? 1048576 : i189;
                $dirty1 |= i27;
            } else {
                i16 = minLines;
            }
        }
        i30 = traceInProgress & i187;
        if (i30 != 0) {
            $dirty1 |= i195;
            obj10 = interactionSource;
        } else {
            if (i109 & i195 == 0) {
                changed2 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty1 |= changed2;
            } else {
                obj10 = interactionSource;
            }
        }
        if (i109 & i191 == 0) {
            if (traceInProgress & i192 == 0) {
                i48 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj6 = shape;
            }
            $dirty1 |= i48;
        } else {
            obj6 = shape;
        }
        if (i109 & i193 == 0) {
            if (traceInProgress & i189 == 0) {
                obj124 = $dirty1;
                i50 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty1;
                $dirty14 = colors;
            }
            $dirty12 = obj124 | i50;
        } else {
            $dirty14 = colors;
            $dirty12 = obj124;
        }
        if ($dirty2 & i83 == 306783378 && $dirty12 & i106 == 306783378) {
            if ($dirty12 & i106 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    obj124 = -458753;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i67 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj20;
                            }
                            z5 = i175 != 0 ? str : str;
                            z2 = companion != 0 ? str : readOnly3;
                            if (traceInProgress & 32 != 0) {
                                readOnly3 = 6;
                                i67 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj8 = $dirty14;
                                i12 = $dirty2;
                            } else {
                                obj8 = obj14;
                                i12 = $dirty2;
                            }
                            obj17 = i65 != 0 ? $dirty2 : visualTransformation3;
                            obj11 = i171 != 0 ? $dirty2 : obj7;
                            i61 = i44 != 0 ? $dirty2 : leadingIcon;
                            obj5 = i15 != 0 ? $dirty2 : trailingIcon;
                            i37 = i21 != 0 ? $dirty2 : isError;
                            if (i39 != 0) {
                                visualTransformation2 = $dirty2;
                            } else {
                                visualTransformation2 = visualTransformation;
                            }
                            if (i89 != 0) {
                                keyboardOptions2 = $dirty2;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (i3 != 0) {
                                obj15 = $dirty2;
                            } else {
                                obj15 = keyboardActions;
                            }
                            i56 = i52 != 0 ? $dirty2 : singleLine;
                            if (i131 &= traceInProgress != 0) {
                                i49 = i56 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                $dirty12 &= obj124;
                                i71 = i49;
                            } else {
                                i71 = maxLines;
                            }
                            i79 = i80 != 0 ? i49 : minLines;
                            obj4 = i30 != 0 ? i49 : interactionSource;
                            if (i132 &= traceInProgress != 0) {
                                obj16 = outlinedTextFieldShape;
                                textStyle4 = $dirty12;
                            } else {
                                obj16 = shape;
                                textStyle4 = $dirty12;
                            }
                            if (traceInProgress & i189 != 0) {
                                composer = restartGroup;
                                int $composer5 = i25;
                                $composer3 = composer;
                                obj2 = outlinedTextFieldColors-dx8h9Zs;
                                $composer2 = i151;
                                str = z5;
                                readOnly3 = z2;
                                $dirty3 = obj8;
                                i43 = i12;
                                obj3 = i37;
                                i46 = visualTransformation2;
                                i23 = keyboardOptions2;
                                shape2 = obj15;
                                field2 = i56;
                                z3 = i71;
                                textStyle2 = i79;
                            } else {
                                $composer3 = restartGroup;
                                int $composer4 = 1;
                                obj2 = colors;
                                str = z5;
                                readOnly3 = z2;
                                $dirty3 = obj8;
                                i43 = i12;
                                obj3 = i37;
                                i46 = visualTransformation2;
                                i23 = keyboardOptions2;
                                shape2 = obj15;
                                field2 = i56;
                                z3 = i71;
                                textStyle2 = i79;
                                $composer2 = textStyle4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (traceInProgress & 32 != 0) {
                                $dirty2 &= obj124;
                            }
                            if (i100 &= traceInProgress != 0) {
                                $dirty12 &= obj124;
                            }
                            if (i102 &= traceInProgress != 0) {
                                $dirty12 &= i88;
                            }
                            if (traceInProgress & i189 != 0) {
                                i61 = leadingIcon;
                                obj5 = trailingIcon;
                                obj3 = isError;
                                field2 = singleLine;
                                z3 = maxLines;
                                obj4 = interactionSource;
                                obj16 = shape;
                                obj2 = colors;
                                $composer3 = restartGroup;
                                i43 = $dirty2;
                                $dirty3 = obj14;
                                obj17 = visualTransformation3;
                                obj11 = obj7;
                                i23 = keyboardOptions;
                                shape2 = keyboardActions;
                                textStyle2 = minLines;
                                $composer2 = i105;
                                modifier2 = obj20;
                                i46 = visualTransformation;
                            } else {
                                i61 = leadingIcon;
                                obj5 = trailingIcon;
                                obj3 = isError;
                                field2 = singleLine;
                                z3 = maxLines;
                                obj4 = interactionSource;
                                obj16 = shape;
                                obj2 = colors;
                                $composer3 = restartGroup;
                                i43 = $dirty2;
                                $dirty3 = obj14;
                                obj17 = visualTransformation3;
                                obj11 = obj7;
                                modifier2 = obj20;
                                $composer2 = $dirty12;
                                i46 = visualTransformation;
                                i23 = keyboardOptions;
                                shape2 = keyboardActions;
                                textStyle2 = minLines;
                            }
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj119 = readOnly3;
                        ComposerKt.traceEventStart(-621914704, i43, $composer2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:157)");
                    } else {
                        obj119 = readOnly3;
                    }
                    if (obj4 == null) {
                        $composer3.startReplaceGroup(-589524042);
                        ComposerKt.sourceInformation($composer3, "159@8708L39");
                        ComposerKt.sourceInformationMarkerStart($composer3, 673719756, "CC(remember):OutlinedTextField.kt#9igjgp");
                        readOnly3 = $composer3;
                        int i177 = 0;
                        obj106 = i114;
                        rememberedValue = readOnly3.rememberedValue();
                        i80 = 0;
                        $dirty13 = $composer2;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i116 = 0;
                            readOnly3.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $composer2 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                        i35 = $composer2;
                    } else {
                        $dirty13 = $composer2;
                        $composer3.startReplaceGroup(673719105);
                        $composer3.endReplaceGroup();
                        i35 = obj4;
                    }
                    $composer3.startReplaceGroup(673724863);
                    ComposerKt.sourceInformation($composer3, "*162@8895L18");
                    color-0d7_KjU = $dirty3.getColor-0d7_KjU();
                    int i155 = 0;
                    i38 = 0;
                    i64 = Long.compare(l, i185) != 0 ? 1 : 0;
                    if (i64 != 0) {
                    } else {
                        l = 0;
                        obj106 = color-0d7_KjU;
                        color-0d7_KjU = (Color)obj2.textColor(str, $composer3, companion | i38).getValue().unbox-impl();
                    }
                    $composer3.endReplaceGroup();
                    textStyle4 = new TextStyle(color-0d7_KjU, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    i85 = 0;
                    i26 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (obj17 != null) {
                        Modifier semantics = SemanticsModifierKt.semantics((Modifier)Modifier.Companion, true, (Function1)OutlinedTextFieldKt.OutlinedTextField.1.INSTANCE);
                        int i157 = 0;
                        obj122 = consume;
                        density = PaddingKt.padding-qDBjuR0$default(semantics, 0, (Density)consume.toDp-GaN1DYA(OutlinedTextFieldKt.OutlinedTextFieldTopPadding), 0, 0, 13, 0);
                    } else {
                        obj122 = consume;
                        density = Modifier.Companion;
                    }
                    obj112 = obj3;
                    obj108 = str;
                    SolidColor solidColor = new SolidColor((Color)obj2.cursorColor(obj3, $composer3, i118 |= i159).getValue().unbox-impl(), str, 0);
                    obj106 = anon;
                    obj118 = obj2;
                    super(value, obj108, field2, i46, i35, obj112, obj17, obj11, i61, obj5, obj16, obj118);
                    boolean z7 = obj108;
                    boolean z8 = obj119;
                    Composer composer3 = $composer3;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier2.then(density), obj3, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), $composer3, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), z7, z8, $dirty3.merge(textStyle4), i23, shape2, field2, z3, textStyle2, i46, 0, i35, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(1710364390, true, obj106, $composer3, 54), composer3, i127 | i148, i130 | i149, 4096);
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation4 = field2;
                    singleLine2 = visualTransformation5;
                    field = field3;
                    $dirty = z7;
                    z4 = z8;
                    i19 = z3;
                    i54 = textStyle2;
                    $dirty12 = $dirty13;
                    obj13 = obj8;
                    enabled2 = obj17;
                    readOnly2 = obj11;
                    i9 = i61;
                    i47 = obj4;
                    shape3 = obj16;
                    colors2 = modifier2;
                    $dirty15 = i43;
                    maxLines2 = i23;
                    minLines2 = shape2;
                    keyboardOptions3 = obj5;
                    keyboardActions2 = i37;
                } else {
                    restartGroup.skipToGroupEnd();
                    i9 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i19 = maxLines;
                    i54 = minLines;
                    i47 = interactionSource;
                    shape3 = shape;
                    composer2 = restartGroup;
                    $dirty15 = $dirty2;
                    field = $dirty14;
                    $dirty = str;
                    z4 = readOnly3;
                    obj13 = obj14;
                    enabled2 = visualTransformation3;
                    readOnly2 = obj7;
                    colors2 = obj20;
                    keyboardOptions3 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation4 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.4(value, onValueChange, colors2, $dirty, z4, obj13, enabled2, readOnly2, i9, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation4, i19, i54, i47, shape3, field, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void OutlinedTextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj12;
        Object obj3;
        boolean z3;
        Object obj21;
        Object obj16;
        Object obj20;
        boolean z5;
        int i;
        Object obj7;
        Object obj4;
        int textStyle2;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier2;
        Object modifier4;
        int i42;
        int i6;
        int enabled2;
        boolean enabled3;
        int i43;
        Object $composer3;
        Object outlinedTextFieldColors-dx8h9Zs;
        boolean traceInProgress;
        int $dirty;
        boolean $dirty2;
        int outlinedTextFieldShape;
        int $dirty1;
        Object $dirty12;
        boolean z;
        Object obj18;
        Object modifier3;
        Object obj14;
        boolean z6;
        Object enabled4;
        int i46;
        boolean z2;
        Object readOnly2;
        int i16;
        Object obj9;
        int textStyle3;
        Object obj5;
        Object rememberedValue;
        int label2;
        Object obj23;
        Object obj8;
        int placeholder2;
        Object obj6;
        int i31;
        VisualTransformation leadingIcon2;
        int i30;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5;
        KeyboardOptions trailingIcon2;
        int i27;
        Object obj15;
        KeyboardActions isError2;
        int i32;
        Object obj22;
        int visualTransformation2;
        VisualTransformation visualTransformation3;
        int i21;
        int keyboardOptions3;
        KeyboardOptions keyboardOptions2;
        int i50;
        int i17;
        Object keyboardActions4;
        KeyboardActions keyboardActions3;
        int changed3;
        Shape singleLine2;
        int i5;
        int i35;
        Object maxLines2;
        int i28;
        int i19;
        int i13;
        int i52;
        int i45;
        int i18;
        int changed2;
        int $dirty13;
        int changed;
        int i51;
        int i9;
        int i47;
        int colors2;
        Object obj13;
        int i15;
        int i37;
        int i36;
        int i40;
        int i26;
        int changed6;
        int i3;
        int changed7;
        int i22;
        int changed4;
        int i34;
        int i41;
        int i7;
        int i24;
        int i55;
        int i44;
        int i33;
        boolean changed5;
        int i54;
        int i2;
        int i8;
        int i39;
        int i14;
        Composer $composer2;
        int i11;
        int i48;
        int i29;
        int i53;
        boolean z4;
        int i10;
        Object obj19;
        Object obj10;
        int i12;
        int i38;
        int i25;
        Object obj11;
        Object obj;
        KeyboardActions keyboardActions2;
        int i20;
        int i4;
        Object obj17;
        Object obj2;
        int i49;
        ScopeUpdateScope scopeUpdateScope;
        Object obj71;
        int obj88;
        int i56 = $changed;
        int i71 = $changed1;
        i43 = i23;
        outlinedTextFieldColors-dx8h9Zs = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation(outlinedTextFieldColors-dx8h9Zs, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)240@11690L7,251@12250L39,252@12328L22,253@12400L25,255@12434L416:OutlinedTextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (i43 & 1 != 0) {
            $dirty |= 6;
            obj18 = value;
        } else {
            if (i56 & 6 == 0) {
                i16 = outlinedTextFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty |= i16;
            } else {
                obj18 = value;
            }
        }
        if (i43 & 2 != 0) {
            $dirty |= 48;
            obj9 = onValueChange;
        } else {
            if (i56 & 48 == 0) {
                i31 = outlinedTextFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i31;
            } else {
                obj9 = onValueChange;
            }
        }
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 = i43 & 4;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 != 0) {
            $dirty |= 384;
            obj22 = modifier;
        } else {
            if (i56 & 384 == 0) {
                i21 = outlinedTextFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty |= i21;
            } else {
                obj22 = modifier;
            }
        }
        int i140 = i43 & 8;
        changed3 = 1024;
        if (i140 != 0) {
            $dirty |= 3072;
            z6 = enabled;
        } else {
            if (i56 & 3072 == 0) {
                i35 = outlinedTextFieldColors-dx8h9Zs.changed(enabled) ? i50 : changed3;
                $dirty |= i35;
            } else {
                z6 = enabled;
            }
        }
        int i144 = i43 & 16;
        i52 = 8192;
        if (i144 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else {
            if (i56 & 24576 == 0) {
                i47 = outlinedTextFieldColors-dx8h9Zs.changed(readOnly) ? i19 : i52;
                $dirty |= i47;
            } else {
                z2 = readOnly;
            }
        }
        int i149 = 196608;
        int i152 = 65536;
        i26 = 131072;
        if (i56 & i149 == 0) {
            if (i43 & 32 == 0) {
                changed6 = outlinedTextFieldColors-dx8h9Zs.changed(textStyle) ? i26 : i152;
            } else {
                rememberedValue = textStyle;
            }
            $dirty |= changed6;
        } else {
            rememberedValue = textStyle;
        }
        i3 = i43 & 64;
        final int i159 = 1572864;
        if (i3 != 0) {
            $dirty |= i159;
            obj8 = label;
        } else {
            if (i56 & i159 == 0) {
                changed4 = outlinedTextFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty |= changed4;
            } else {
                obj8 = label;
            }
        }
        int i136 = i43 & 128;
        final int i153 = 12582912;
        if (i136 != 0) {
            $dirty |= i153;
            obj15 = placeholder;
        } else {
            if (i56 & i153 == 0) {
                i41 = outlinedTextFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i41;
            } else {
                obj15 = placeholder;
            }
        }
        int i57 = i43 & 256;
        int i154 = 100663296;
        if (i57 != 0) {
            $dirty |= i154;
            i7 = i57;
            obj12 = leadingIcon;
        } else {
            if ($changed & i154 == 0) {
                i7 = i57;
                i24 = outlinedTextFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i24;
            } else {
                i7 = i57;
                obj12 = leadingIcon;
            }
        }
        int i58 = i43 & 512;
        int i156 = 805306368;
        if (i58 != 0) {
            $dirty |= i156;
            i55 = i58;
            obj3 = trailingIcon;
        } else {
            if ($changed & i156 == 0) {
                i55 = i58;
                i44 = outlinedTextFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i44;
            } else {
                i55 = i58;
                obj3 = trailingIcon;
            }
        }
        int i59 = i43 & 1024;
        if (i59 != 0) {
            $dirty1 |= 6;
            i33 = i59;
            z3 = isError;
        } else {
            if (i71 & 6 == 0) {
                i33 = i59;
                i51 = outlinedTextFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty1 |= i51;
            } else {
                i33 = i59;
                z3 = isError;
            }
        }
        int i60 = i43 & 2048;
        if (i60 != 0) {
            $dirty1 |= 48;
            i9 = i60;
            obj21 = visualTransformation;
        } else {
            if (i71 & 48 == 0) {
                i9 = i60;
                changed7 = outlinedTextFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= changed7;
            } else {
                i9 = i60;
                obj21 = visualTransformation;
            }
        }
        int i61 = i43 & 4096;
        if (i61 != 0) {
            $dirty1 |= 384;
            i37 = i61;
            obj16 = keyboardOptions;
        } else {
            i37 = i61;
            if (i71 & 384 == 0) {
                changed4 = outlinedTextFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty1 |= changed4;
            } else {
                obj16 = keyboardOptions;
            }
        }
        int i63 = i43 & 8192;
        if (i63 != 0) {
            $dirty1 |= 3072;
            i22 = i63;
            obj20 = keyboardActions;
        } else {
            i22 = i63;
            if (i71 & 3072 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i50 = changed3;
                }
                $dirty1 |= i50;
            } else {
                obj20 = keyboardActions;
            }
        }
        int i64 = i43 & 16384;
        if (i64 != 0) {
            $dirty1 |= 24576;
            i17 = i64;
            z5 = singleLine;
        } else {
            i17 = i64;
            if (i71 & 24576 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i19 = i52;
                }
                $dirty1 |= i19;
            } else {
                z5 = singleLine;
            }
        }
        int i143 = i43 & i142;
        if (i143 != 0) {
            $dirty1 |= i149;
            i = maxLines;
        } else {
            if (i71 & i149 == 0) {
                i19 = outlinedTextFieldColors-dx8h9Zs.changed(maxLines) ? i26 : i152;
                $dirty1 |= i19;
            } else {
                i = maxLines;
            }
        }
        i13 = i43 & i152;
        if (i13 != 0) {
            $dirty1 |= i159;
            obj7 = interactionSource;
        } else {
            if (i71 & i159 == 0) {
                i52 = outlinedTextFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty1 |= i52;
            } else {
                obj7 = interactionSource;
            }
        }
        if (i71 & i153 == 0) {
            if (i43 & i26 == 0) {
                i45 = outlinedTextFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj4 = shape;
            }
            $dirty1 |= i45;
        } else {
            obj4 = shape;
        }
        int i150 = 262144;
        if (i71 & i154 == 0) {
            if (i43 & i150 == 0) {
                obj88 = $dirty1;
                i18 = outlinedTextFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj88 = $dirty1;
                $dirty12 = colors;
            }
            $dirty13 = obj88 | i18;
        } else {
            $dirty12 = colors;
            $dirty13 = obj88;
        }
        if ($dirty & i40 == 306783378 && $dirty13 & i68 == 38347922) {
            if ($dirty13 & i68 == 38347922) {
                if (!outlinedTextFieldColors-dx8h9Zs.getSkipping()) {
                    outlinedTextFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (outlinedTextFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj22;
                            }
                            enabled3 = i140 != 0 ? 1 : z6;
                            z4 = i144 != 0 ? z6 : z2;
                            if (i43 & 32 != 0) {
                                z2 = 6;
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 = 0;
                                obj71 = modifier2;
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                modifier4 = outlinedTextFieldColors-dx8h9Zs.consume((CompositionLocal)TextKt.getLocalTextStyle());
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                i10 = $dirty;
                            } else {
                                obj71 = modifier2;
                                modifier4 = rememberedValue;
                                i10 = $dirty;
                            }
                            obj19 = i3 != 0 ? $dirty : obj8;
                            obj10 = i136 != 0 ? $dirty : obj15;
                            i12 = i7 != 0 ? $dirty : leadingIcon;
                            i38 = i55 != 0 ? $dirty : trailingIcon;
                            i25 = i33 != 0 ? $dirty : isError;
                            if (i9 != 0) {
                                obj11 = $dirty;
                            } else {
                                obj11 = visualTransformation;
                            }
                            if (i37 != 0) {
                                obj = $dirty;
                            } else {
                                obj = keyboardOptions;
                            }
                            if (i22 != 0) {
                                keyboardActions2 = $dirty;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            i20 = i17 != 0 ? $dirty : singleLine;
                            i4 = i143 != 0 ? $dirty : maxLines;
                            if (i13 != 0) {
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 673833100, "CC(remember):OutlinedTextField.kt#9igjgp");
                                int i121 = 0;
                                i46 = outlinedTextFieldColors-dx8h9Zs;
                                z2 = 0;
                                rememberedValue = i46.rememberedValue();
                                obj8 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i135 = 0;
                                    i46.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$5 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj17 = $dirty;
                            } else {
                                obj17 = interactionSource;
                            }
                            if (i43 & i26 != 0) {
                                obj2 = outlinedTextFieldShape;
                                i49 = $dirty13;
                            } else {
                                obj2 = shape;
                                i49 = $dirty13;
                            }
                            if (i43 & i150 != 0) {
                                obj14 = obj71;
                                obj5 = modifier4;
                                z6 = enabled3;
                                obj13 = outlinedTextFieldColors-dx8h9Zs;
                                enabled2 = $dirty;
                                z2 = z4;
                                textStyle2 = i10;
                                obj23 = obj19;
                                obj6 = obj10;
                                i30 = i12;
                                i27 = i38;
                                i32 = i25;
                                visualTransformation3 = obj11;
                                keyboardOptions2 = obj;
                                keyboardActions3 = keyboardActions2;
                                i5 = i20;
                                i28 = i4;
                                $dirty13 = obj17;
                                i9 = obj2;
                            } else {
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                obj14 = obj71;
                                obj13 = colors;
                                obj5 = modifier4;
                                z6 = enabled3;
                                z2 = z4;
                                textStyle2 = i10;
                                obj23 = obj19;
                                obj6 = obj10;
                                i30 = i12;
                                i27 = i38;
                                i32 = i25;
                                visualTransformation3 = obj11;
                                keyboardOptions2 = obj;
                                keyboardActions3 = keyboardActions2;
                                i5 = i20;
                                i28 = i4;
                                $dirty13 = obj17;
                                i9 = obj2;
                                enabled2 = i49;
                            }
                        } else {
                            outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                            if (i43 & 32 != 0) {
                                $dirty &= i42;
                            }
                            if (i43 & i26 != 0) {
                                $dirty13 &= i6;
                            }
                            if (i43 & i150 != 0) {
                                i30 = leadingIcon;
                                i27 = trailingIcon;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActions3 = keyboardActions;
                                i5 = singleLine;
                                i28 = maxLines;
                                $dirty13 = interactionSource;
                                i9 = shape;
                                enabled2 = i67;
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                textStyle2 = $dirty;
                                obj13 = $dirty12;
                                obj5 = rememberedValue;
                                obj23 = obj8;
                                obj6 = obj15;
                                obj14 = obj22;
                                i32 = isError;
                                visualTransformation3 = visualTransformation;
                            } else {
                                i30 = leadingIcon;
                                i27 = trailingIcon;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActions3 = keyboardActions;
                                i5 = singleLine;
                                i28 = maxLines;
                                i9 = shape;
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                textStyle2 = $dirty;
                                obj13 = $dirty12;
                                obj5 = rememberedValue;
                                obj23 = obj8;
                                obj6 = obj15;
                                obj14 = obj22;
                                enabled2 = $dirty13;
                                i32 = isError;
                                visualTransformation3 = visualTransformation;
                                $dirty13 = interactionSource;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2099955827, textStyle2, enabled2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:254)");
                    }
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, obj14, z6, z2, obj5, obj23, obj6, i30, i27, i32, visualTransformation3, keyboardOptions2, keyboardActions3, i5, i28, 1, $dirty13, i9, obj13, $composer2, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i36 = enabled2;
                    $composer3 = obj14;
                    $dirty2 = z6;
                    z = z2;
                    modifier3 = obj5;
                    enabled4 = obj23;
                    readOnly2 = obj6;
                    textStyle3 = i30;
                    label2 = i27;
                    placeholder2 = i32;
                    leadingIcon2 = visualTransformation3;
                    trailingIcon2 = keyboardOptions2;
                    isError2 = keyboardActions3;
                    visualTransformation2 = i5;
                    keyboardOptions3 = i28;
                    keyboardActions4 = $dirty13;
                    singleLine2 = i9;
                    maxLines2 = obj13;
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
                    $dirty2 = z6;
                    z = z2;
                    modifier3 = rememberedValue;
                    enabled4 = obj8;
                    readOnly2 = obj15;
                    $composer3 = obj22;
                    i36 = $dirty13;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation2 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.6(value, onValueChange, $composer3, $dirty2, z, modifier3, enabled4, readOnly2, textStyle3, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions3, keyboardActions4, singleLine2, maxLines2, $changed, $changed1, i43);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, boolean singleLine, float animationProgress, Function1<? super Size, Unit> onLabelMeasured, Function2<? super Composer, ? super Integer, Unit> border, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int i24;
        int i30;
        int i15;
        int i10;
        int traceInProgress;
        boolean traceInProgress2;
        int i27;
        Object it$iv;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        Integer valueOf3;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Object obj2;
        Object valueOf2;
        Object maybeCachedBoxMeasurePolicy;
        Composer composer7;
        int $composer$iv;
        Composer composer4;
        int valueOf6;
        Integer valueOf;
        Integer valueOf4;
        int materialized$iv$iv2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object $composer$iv2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        boolean currentCompositionLocalMap3;
        Object maybeCachedBoxMeasurePolicy2;
        int $changed$iv2;
        Object materialized$iv$iv;
        androidx.compose.ui.Modifier.Companion $this$coerceAtLeast_u2dYgX7TsA$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        Modifier padding-qDBjuR0$default;
        Object iNSTANCE;
        Object $this$dp$iv;
        int then;
        boolean currentCompositionLocalMap;
        int i4;
        int i17;
        int i14;
        int i31;
        int $dirty;
        Object $i$f$cache2;
        boolean currentCompositionLocalMap2;
        Modifier materializeModifier;
        Composer composer2;
        Integer valueOf5;
        Composer composer9;
        int restartGroup;
        Integer valueOf7;
        int $dirty1;
        Composer composer3;
        Object maybeCachedBoxMeasurePolicy3;
        int i18;
        int i2;
        int i8;
        int i25;
        int i23;
        int i32;
        int i28;
        int i19;
        int i20;
        int i16;
        Object companion;
        int $i$f$cache;
        int currentCompositeKeyHash;
        int i21;
        kotlin.jvm.functions.Function0 function0;
        int i33;
        Composer composer8;
        int i5;
        int i22;
        Object obj;
        Composer composer;
        int i12;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        int i3;
        Modifier modifier3;
        int i9;
        int i29;
        int i26;
        int $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1;
        int i11;
        int currentCompositeKeyHash2;
        int currentCompositeKeyHash3;
        float f2;
        Alignment alignment;
        int $changed$iv;
        float f;
        int i13;
        int i34;
        Modifier modifier2;
        kotlin.jvm.functions.Function0 function02;
        int i;
        int i7;
        Composer composer5;
        int localMap$iv$iv;
        int i6;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer6;
        int i35;
        Object obj66;
        Object obj3 = modifier;
        valueOf2 = textField;
        $composer$iv = placeholder;
        materialized$iv$iv2 = label;
        $composer$iv2 = leading;
        maybeCachedBoxMeasurePolicy2 = trailing;
        $changed$iv2 = singleLine;
        padding-qDBjuR0$default = animationProgress;
        iNSTANCE = onLabelMeasured;
        $this$dp$iv = border;
        final Object obj4 = paddingValues;
        int i95 = $changed;
        restartGroup = $composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)508@23459L239,516@23746L7,517@23758L2308:OutlinedTextField.kt#jmzs0o");
        if (i95 & 6 == 0) {
            i18 = restartGroup.changed(obj3) ? 4 : 2;
            $dirty |= i18;
        }
        if (i95 & 48 == 0) {
            i2 = restartGroup.changedInstance(valueOf2) ? 32 : 16;
            $dirty |= i2;
        }
        if (i95 & 384 == 0) {
            i24 = restartGroup.changedInstance($composer$iv) ? 256 : 128;
            $dirty |= i24;
        }
        if (i95 & 3072 == 0) {
            i30 = restartGroup.changedInstance(materialized$iv$iv2) ? 2048 : 1024;
            $dirty |= i30;
        }
        if (i95 & 24576 == 0) {
            i15 = restartGroup.changedInstance($composer$iv2) ? 16384 : 8192;
            $dirty |= i15;
        }
        if (i37 &= i95 == 0) {
            i10 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy2) ? 131072 : 65536;
            $dirty |= i10;
        }
        if (i38 &= i95 == 0) {
            i25 = restartGroup.changed($changed$iv2) ? 1048576 : 524288;
            $dirty |= i25;
        }
        if (i95 & i125 == 0) {
            i23 = restartGroup.changed(padding-qDBjuR0$default) ? 8388608 : 4194304;
            $dirty |= i23;
        }
        if (i95 & i126 == 0) {
            i32 = restartGroup.changedInstance(iNSTANCE) ? 67108864 : 33554432;
            $dirty |= i32;
        }
        if (i95 & i127 == 0) {
            i28 = restartGroup.changedInstance($this$dp$iv) ? 536870912 : 268435456;
            $dirty |= i28;
        }
        if ($changed1 & 6 == 0) {
            i19 = restartGroup.changed(obj4) ? 4 : 2;
            $dirty1 |= i19;
        }
        if ($dirty & i20 == 306783378 && $dirty1 & 3 == 2) {
            if ($dirty1 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2049536174, $dirty, $dirty1, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:507)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1860606082, "CC(remember):OutlinedTextField.kt#9igjgp");
                    int i124 = 1;
                    i8 = $dirty;
                    i27 = i41 &= $dirty == 67108864 ? i124 : 0;
                    i17 = i8 & i97 == 1048576 ? i124 : 0;
                    i14 = i8 & i99 == 8388608 ? i124 : 0;
                    i31 = $dirty1 & 14 == 4 ? i124 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache2 = 0;
                    it$iv = composer13.rememberedValue();
                    int i128 = 0;
                    if (i44 |= i31 == 0) {
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
                    currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                    materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, obj3);
                    kotlin.jvm.functions.Function0 function03 = constructor2;
                    i21 = 0;
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
                    i22 = i102;
                    composer = restartGroup;
                    Updater.set-impl(constructor-impl, (MeasurePolicy)(OutlinedTextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf7 = 0;
                    Composer composer14 = constructor-impl;
                    i12 = 0;
                    if (!composer14.getInserting()) {
                        localMap$iv = currentCompositionLocalMap2;
                        i3 = valueOf7;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer9 = composer14;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap2;
                        i3 = valueOf7;
                    }
                    Updater.set-impl(constructor-impl, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    i4 = composer;
                    materializeModifier = 0;
                    i5 = i62;
                    ComposerKt.sourceInformationMarkerStart(i4, -988650720, "C525@24262L8,564@25710L182:OutlinedTextField.kt#jmzs0o");
                    $this$dp$iv.invoke(i4, Integer.valueOf(i63 &= 14));
                    restartGroup = "C73@3429L9:Box.kt#2w3rfo";
                    int i132 = 48;
                    String str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier3 = materialized$iv$iv;
                    if ($composer$iv2 != null) {
                        i4.startReplaceGroup(-988654503);
                        ComposerKt.sourceInformation(i4, "528@24323L219");
                        Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        i29 = i132;
                        i26 = 0;
                        $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1 = materializeModifier;
                        ComposerKt.sourceInformationMarkerStart(i4, 733328855, str2);
                        int i118 = 0;
                        i11 = $dirty1;
                        maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i118);
                        currentCompositeKeyHash3 = 0;
                        alignment = center2;
                        ComposerKt.sourceInformationMarkerStart(i4, -1323940314, $changed$iv2);
                        $changed$iv = ComposablesKt.getCurrentCompositeKeyHash(i4, 0);
                        currentCompositionLocalMap = i4.getCurrentCompositionLocalMap();
                        i13 = i118;
                        modifier2 = then3;
                        kotlin.jvm.functions.Function0 function07 = constructor5;
                        i34 = 0;
                        ComposerKt.sourceInformationMarkerStart(i4, -692256719, iNSTANCE);
                        if (!applier5 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i4.startReusableNode();
                        if (i4.getInserting()) {
                            i4.createNode(function07);
                        } else {
                            factory$iv$iv$iv4 = function07;
                            i4.useNode();
                        }
                        function02 = factory$iv$iv$iv4;
                        Composer constructor-impl4 = Updater.constructor-impl(i4);
                        int i150 = 0;
                        Updater.set-impl(constructor-impl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i155 = 0;
                        Composer composer18 = constructor-impl4;
                        int i156 = 0;
                        if (!composer18.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                            measurePolicy = maybeCachedBoxMeasurePolicy3;
                            if (!Intrinsics.areEqual(composer18.rememberedValue(), Integer.valueOf($changed$iv))) {
                                composer18.updateRememberedValue(Integer.valueOf($changed$iv));
                                constructor-impl4.apply(Integer.valueOf($changed$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer3 = composer18;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                            measurePolicy = maybeCachedBoxMeasurePolicy3;
                        }
                        Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier(i4, then3), ComposeUiNode.Companion.getSetModifier());
                        Composer composer12 = i4;
                        ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, restartGroup);
                        $dirty1 = BoxScopeInstance.INSTANCE;
                        i152 |= 6;
                        localMap$iv$iv = 0;
                        i6 = i73;
                        i35 = i94;
                        $this$dp$iv = composer5;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, 1888671661, "C532@24515L9:OutlinedTextField.kt#jmzs0o");
                        $composer$iv2.invoke($this$dp$iv, Integer.valueOf(i74 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer12);
                        i4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        i4.endReplaceGroup();
                    } else {
                        $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1 = materializeModifier;
                        i11 = $dirty1;
                        i4.startReplaceGroup(-988413292);
                        i4.endReplaceGroup();
                    }
                    if (maybeCachedBoxMeasurePolicy2 != null) {
                        i4.startReplaceGroup(-988370729);
                        ComposerKt.sourceInformation(i4, "536@24609L221");
                        Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(i4, 733328855, str2);
                        valueOf5 = 0;
                        i26 = 0;
                        ComposerKt.sourceInformationMarkerStart(i4, -1323940314, $changed$iv2);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(i4, 0);
                        currentCompositionLocalMap3 = i4.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = center;
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(i4, then2);
                        $changed$iv = then2;
                        kotlin.jvm.functions.Function0 function05 = constructor3;
                        alignment = 0;
                        ComposerKt.sourceInformationMarkerStart(i4, -692256719, iNSTANCE);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i4.startReusableNode();
                        if (i4.getInserting()) {
                            i4.createNode(function05);
                        } else {
                            factory$iv$iv$iv2 = function05;
                            i4.useNode();
                        }
                        i13 = factory$iv$iv$iv2;
                        Composer constructor-impl2 = Updater.constructor-impl(i4);
                        int i142 = 0;
                        i = i92;
                        Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf5), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i148 = 0;
                        Composer composer17 = constructor-impl2;
                        int i154 = 0;
                        if (!composer17.getInserting()) {
                            localMap$iv$iv = currentCompositionLocalMap3;
                            i6 = valueOf5;
                            if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer2 = composer17;
                            }
                        } else {
                            localMap$iv$iv = currentCompositionLocalMap3;
                            i6 = valueOf5;
                        }
                        Updater.set-impl(constructor-impl2, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        Composer composer11 = i4;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, restartGroup);
                        materializeModifier = BoxScopeInstance.INSTANCE;
                        i144 |= 6;
                        i7 = 0;
                        composer5 = i69;
                        measurePolicy = materializeModifier4;
                        materialized$iv$iv = function02;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1888956396, "C540@24802L10:OutlinedTextField.kt#jmzs0o");
                        maybeCachedBoxMeasurePolicy2.invoke(materialized$iv$iv, Integer.valueOf(i70 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer11);
                        i4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        i4.endReplaceGroup();
                    } else {
                        i4.startReplaceGroup(-988127596);
                        i4.endReplaceGroup();
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
                    if (maybeCachedBoxMeasurePolicy2 != null) {
                        int i90 = 0;
                        int i113 = 0;
                        materializeModifier = 0;
                        f = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        f = endPadding;
                    }
                    padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, f2, 0, f, 0, 10, 0);
                    if ($composer$iv != null) {
                        i4.startReplaceGroup(-987369863);
                        ComposerKt.sourceInformation(i4, "561@25623L59");
                        $composer$iv.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), i4, Integer.valueOf(i110 &= 112));
                        i4.endReplaceGroup();
                    } else {
                        i4.startReplaceGroup(-987282412);
                        i4.endReplaceGroup();
                    }
                    $dirty1 = 384;
                    i2 = 0;
                    obj = consume;
                    ComposerKt.sourceInformationMarkerStart(i4, 733328855, str2);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i124);
                    i26 = 0;
                    currentCompositeKeyHash2 = topStart;
                    ComposerKt.sourceInformationMarkerStart(i4, -1323940314, $changed$iv2);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(i4, 0);
                    currentCompositionLocalMap4 = i4.getCurrentCompositionLocalMap();
                    alignment = startPadding;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(i4, LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default));
                    i13 = endPadding;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    $changed$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(i4, -692256719, iNSTANCE);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i4.startReusableNode();
                    if (i4.getInserting()) {
                        i4.createNode(function06);
                    } else {
                        factory$iv$iv$iv3 = function06;
                        i4.useNode();
                    }
                    i34 = factory$iv$iv$iv3;
                    Composer constructor-impl3 = Updater.constructor-impl(i4);
                    int i145 = 0;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i149 = 0;
                    Composer composer16 = constructor-impl3;
                    int i153 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap4;
                        i6 = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer7 = composer16;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap4;
                        i6 = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = i4;
                    $composer$iv2 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, restartGroup);
                    maybeCachedBoxMeasurePolicy2 = BoxScopeInstance.INSTANCE;
                    i147 |= 6;
                    i7 = 0;
                    composer5 = i48;
                    measurePolicy = materializeModifier3;
                    materialized$iv$iv2 = i;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 1890012907, "C568@25867L11:OutlinedTextField.kt#jmzs0o");
                    valueOf2.invoke(materialized$iv$iv2, Integer.valueOf(i49 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    i4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i4);
                    ComposerKt.sourceInformationMarkerEnd(i4);
                    ComposerKt.sourceInformationMarkerEnd(i4);
                    if (label != null) {
                        i4.startReplaceGroup(-987052578);
                        ComposerKt.sourceInformation(i4, "572@25943L54");
                        Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label");
                        valueOf6 = 6;
                        materialized$iv$iv2 = 0;
                        ComposerKt.sourceInformationMarkerStart(i4, 733328855, str2);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        $dirty = 0;
                        ComposerKt.sourceInformationMarkerStart(i4, -1323940314, $changed$iv2);
                        $changed$iv2 = ComposablesKt.getCurrentCompositeKeyHash(i4, 0);
                        i2 = topStart2;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(i4, layoutId);
                        companion = layoutId;
                        kotlin.jvm.functions.Function0 function04 = constructor;
                        i20 = 0;
                        ComposerKt.sourceInformationMarkerStart(i4, -692256719, iNSTANCE);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i4.startReusableNode();
                        if (i4.getInserting()) {
                            i4.createNode(function04);
                        } else {
                            factory$iv$iv$iv = function04;
                            i4.useNode();
                        }
                        Composer constructor-impl5 = Updater.constructor-impl(i4);
                        int i130 = 0;
                        i26 = factory$iv$iv$iv;
                        Updater.set-impl(constructor-impl5, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, i4.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i133 = 0;
                        Composer composer15 = constructor-impl5;
                        int i137 = 0;
                        if (!composer15.getInserting()) {
                            $changed$iv = valueOf6;
                            if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf($changed$iv2))) {
                                composer15.updateRememberedValue(Integer.valueOf($changed$iv2));
                                constructor-impl5.apply(Integer.valueOf($changed$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer4 = composer15;
                            }
                        } else {
                            $changed$iv = valueOf6;
                        }
                        Updater.set-impl(constructor-impl5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        valueOf2 = i4;
                        $composer$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf2, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i121 |= 6;
                        composer8 = valueOf2;
                        i12 = 0;
                        i9 = i55;
                        currentCompositeKeyHash2 = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart(valueOf2, 1890132815, "C572@25988L7:OutlinedTextField.kt#jmzs0o");
                        label.invoke(valueOf2, Integer.valueOf(i56 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(valueOf2);
                        ComposerKt.sourceInformationMarkerEnd(valueOf2);
                        i4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        ComposerKt.sourceInformationMarkerEnd(i4);
                        i4.endReplaceGroup();
                    } else {
                        obj2 = label;
                        i4.startReplaceGroup(-986969932);
                        i4.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(i4);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj2 = materialized$iv$iv2;
                    i8 = $dirty;
                    composer = restartGroup;
                    i11 = $dirty1;
                }
            } else {
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new OutlinedTextFieldKt.OutlinedTextFieldLayout.2(modifier, textField, placeholder, obj2, leading, trailing, singleLine, animationProgress, onLabelMeasured, border, obj4, $changed, $changed1);
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
        int i5;
        Placeable.PlacementScope roundToInt;
        int i11;
        Placeable height3;
        int i9;
        int align2;
        int i;
        int i10;
        int i14;
        Placeable.PlacementScope placementScope2;
        Placeable.PlacementScope placementScope;
        Placeable placeable2;
        Placeable placeable;
        int i8;
        int widthOrZero;
        int align;
        int i6;
        int i7;
        int i13;
        int i12;
        int i4;
        int i2;
        int i3;
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
            placeable2 = labelPlaceable;
            centerVertically = 0;
            if (singleLine) {
                height2 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i15);
            } else {
                height2 = roundToInt2;
            }
            if (leadingPlaceable == null) {
                i11 = 0;
            } else {
                i22 *= height3;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable2, roundToInt + roundToInt3, MathHelpersKt.lerp(height2, -i20, f), 0, 4, 0);
        }
        if (singleLine) {
            align3 = Alignment.Companion.getCenterVertically().align(textFieldPlaceable.getHeight(), i15);
        } else {
            align3 = roundToInt2;
        }
        i6 = Math.max(align3, heightOrZero /= 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i6, 0, 4, 0);
        int i19 = i6;
        if (placeholderPlaceable != null) {
            placeable = placeholderPlaceable;
            i5 = 0;
            if (singleLine) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i15);
            } else {
                roundToInt = roundToInt2;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable, TextFieldImplKt.widthOrZero(leadingPlaceable), Math.max(roundToInt, heightOrZero2 /= 2), 0, 4, 0);
        }
        Placeable.PlacementScope.place-70tqf50$default($this$place, borderPlaceable, IntOffset.Companion.getZero-nOcc-ac(), i6, 0, 2);
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
