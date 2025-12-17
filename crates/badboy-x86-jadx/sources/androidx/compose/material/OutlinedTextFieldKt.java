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
        Object obj11;
        boolean z5;
        Object obj;
        Object obj8;
        Object obj6;
        boolean z2;
        int i17;
        int i11;
        Object obj7;
        Object obj3;
        int $dirty17;
        Object $dirty14;
        Object $dirty13;
        Object endRestartGroup;
        int $dirty5;
        int $dirty3;
        int defaultsInvalid;
        int traceInProgress;
        int rememberedValue;
        Object value2;
        Modifier padding-qDBjuR0$default;
        int $composer2;
        Object $dirty2;
        int $dirty;
        int $dirty4;
        int i6;
        int i3;
        int colors2;
        int default;
        int $dirty16;
        boolean z7;
        int $dirty1;
        Object $dirty15;
        Composer $composer3;
        boolean z3;
        Object obj17;
        Object obj19;
        Object obj5;
        boolean field3;
        String enabled3;
        int i44;
        int i67;
        int outlinedTextFieldShape;
        Object enabled2;
        boolean readOnly2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i25;
        Object readOnly3;
        int i46;
        Object obj15;
        int i68;
        TextStyle merge;
        int i62;
        Object obj9;
        KeyboardOptions i36;
        int keyboardOptions3;
        Object visualTransformation2;
        Object shape2;
        int keyboardActions3;
        int i63;
        int field;
        int i53;
        VisualTransformation singleLine2;
        int z;
        int i13;
        KeyboardOptions maxLines2;
        Object obj4;
        int obj2;
        KeyboardActions minLines2;
        Object obj18;
        VisualTransformation i28;
        int visualTransformation4;
        int i64;
        int i56;
        int i14;
        int i74;
        int i31;
        int i80;
        int i16;
        int changed6;
        int i33;
        int changed;
        int i47;
        long unbox-impl;
        int i9;
        int i51;
        int i37;
        int companion;
        Shape shape3;
        int i59;
        int i79;
        int $dirty12;
        Object field2;
        int i75;
        int i70;
        int i12;
        TextStyle textStyle2;
        int i26;
        int i18;
        int i35;
        int i73;
        int changed7;
        int i22;
        int i29;
        int i66;
        int i71;
        int i77;
        int i21;
        int i65;
        int changed2;
        int changed5;
        int i38;
        int changed3;
        int i54;
        int i30;
        int i72;
        int i60;
        int i40;
        int i61;
        int i69;
        int i20;
        int i7;
        boolean changed4;
        int i19;
        int i4;
        int i39;
        int i55;
        int i43;
        int i15;
        int i45;
        int i48;
        int i2;
        int i32;
        int i41;
        int i58;
        int i76;
        Composer composer2;
        Composer composer;
        int i52;
        int i10;
        int i;
        int i49;
        boolean z4;
        boolean z6;
        Object obj10;
        int i78;
        Object obj12;
        Object obj20;
        int i8;
        int obj13;
        int i5;
        VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions2;
        int i57;
        int i50;
        int i42;
        int textStyle3;
        Shape obj16;
        int i34;
        int i27;
        int i23;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions2;
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
        int i81 = $changed;
        int i92 = $changed1;
        traceInProgress = i24;
        Composer restartGroup = $composer.startRestartGroup(237745923);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)351@17754L7,364@18398L22,365@18470L25,375@18903L7,392@19562L38,401@19929L20,409@20271L930,378@18959L2248:OutlinedTextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty |= 6;
            obj17 = value;
        } else {
            if (i81 & 6 == 0) {
                i46 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i46;
            } else {
                obj17 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty |= 48;
            obj15 = onValueChange;
        } else {
            if (i81 & 48 == 0) {
                i63 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i63;
            } else {
                obj15 = onValueChange;
            }
        }
        i53 = traceInProgress & 4;
        if (i53 != 0) {
            $dirty |= 384;
            obj18 = modifier;
        } else {
            if (i81 & 384 == 0) {
                i64 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i64;
            } else {
                obj18 = modifier;
            }
        }
        i56 = traceInProgress & 8;
        changed6 = 1024;
        if (i56 != 0) {
            $dirty |= 3072;
            field3 = enabled;
        } else {
            if (i81 & 3072 == 0) {
                i37 = restartGroup.changed(enabled) ? i74 : changed6;
                $dirty |= i37;
            } else {
                field3 = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty |= 24576;
            readOnly2 = readOnly;
        } else {
            if (i81 & 24576 == 0) {
                i26 = restartGroup.changed(readOnly) ? 16384 : i59;
                $dirty |= i26;
            } else {
                readOnly2 = readOnly;
            }
        }
        if (i81 & i185 == 0) {
            if (traceInProgress & 32 == 0) {
                changed7 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj9 = textStyle;
            }
            $dirty |= changed7;
        } else {
            obj9 = textStyle;
        }
        i22 = traceInProgress & 64;
        i29 = 1572864;
        i38 = 524288;
        if (i22 != 0) {
            $dirty |= i29;
            visualTransformation2 = label;
        } else {
            if (i81 & i29 == 0) {
                i54 = restartGroup.changedInstance(label) ? 1048576 : i38;
                $dirty |= i54;
            } else {
                visualTransformation2 = label;
            }
        }
        i13 = traceInProgress & 128;
        i30 = 12582912;
        if (i13 != 0) {
            $dirty |= i30;
            obj4 = placeholder;
        } else {
            if (i81 & i30 == 0) {
                i60 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i60;
            } else {
                obj4 = placeholder;
            }
        }
        int i82 = traceInProgress & 256;
        int i195 = 100663296;
        if (i82 != 0) {
            $dirty |= i195;
            i40 = i82;
            obj14 = leadingIcon;
        } else {
            if ($changed & i195 == 0) {
                i40 = i82;
                i61 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i61;
            } else {
                i40 = i82;
                obj14 = leadingIcon;
            }
        }
        int i83 = traceInProgress & 512;
        int i197 = 805306368;
        if (i83 != 0) {
            $dirty |= i197;
            i69 = i83;
            obj11 = trailingIcon;
        } else {
            if ($changed & i197 == 0) {
                i69 = i83;
                i20 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i20;
            } else {
                i69 = i83;
                obj11 = trailingIcon;
            }
        }
        int i84 = traceInProgress & 1024;
        if (i84 != 0) {
            $dirty1 |= 6;
            i7 = i84;
            z5 = isError;
        } else {
            if (i92 & 6 == 0) {
                i7 = i84;
                i75 = restartGroup.changed(isError) ? 4 : 2;
                $dirty1 |= i75;
            } else {
                i7 = i84;
                z5 = isError;
            }
        }
        int i85 = traceInProgress & 2048;
        if (i85 != 0) {
            $dirty1 |= 48;
            i70 = i85;
            obj = visualTransformation;
        } else {
            if (i92 & 48 == 0) {
                i70 = i85;
                changed3 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= changed3;
            } else {
                i70 = i85;
                obj = visualTransformation;
            }
        }
        int i86 = traceInProgress & 4096;
        if (i86 != 0) {
            $dirty1 |= 384;
            i35 = i86;
            obj8 = keyboardOptions;
        } else {
            i35 = i86;
            if (i92 & 384 == 0) {
                i54 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty1 |= i54;
            } else {
                obj8 = keyboardOptions;
            }
        }
        if (i92 & 3072 == 0) {
            if (traceInProgress & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i74 = changed6;
                }
            } else {
                obj6 = keyboardActions;
            }
            $dirty1 |= i74;
        } else {
            obj6 = keyboardActions;
        }
        int i89 = traceInProgress & 16384;
        if (i89 != 0) {
            $dirty1 |= 24576;
            i31 = i89;
            z2 = singleLine;
        } else {
            i31 = i89;
            if (i92 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i59 = 16384;
                }
                $dirty1 |= i59;
            } else {
                z2 = singleLine;
            }
        }
        if (i92 & i175 == 0) {
            if (traceInProgress & i176 == 0) {
                i33 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i17 = maxLines;
            }
            $dirty1 |= i33;
        } else {
            i17 = maxLines;
        }
        i47 = traceInProgress & i177;
        if (i47 != 0) {
            $dirty1 |= i29;
            i11 = minLines;
        } else {
            if (i92 & i29 == 0) {
                i59 = restartGroup.changed(minLines) ? 1048576 : i38;
                $dirty1 |= i59;
            } else {
                i11 = minLines;
            }
        }
        i79 = traceInProgress & i181;
        if (i79 != 0) {
            $dirty1 |= i30;
            obj7 = interactionSource;
        } else {
            if (i92 & i30 == 0) {
                i29 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty1 |= i29;
            } else {
                obj7 = interactionSource;
            }
        }
        if (i92 & i188 == 0) {
            if (traceInProgress & i191 == 0) {
                i66 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj3 = shape;
            }
            $dirty1 |= i66;
        } else {
            obj3 = shape;
        }
        if (i92 & i189 == 0) {
            if (traceInProgress & i38 == 0) {
                obj92 = $dirty1;
                i65 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj92 = $dirty1;
                $dirty15 = colors;
            }
            $dirty17 = i71;
        } else {
            $dirty15 = colors;
            $dirty17 = obj92;
        }
        obj92 = $dirty;
        if ($dirty & i77 == 306783378 && i94 &= $dirty17 == 306783378) {
            if (i94 &= $dirty17 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i113 = 6;
                    int i116 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i53 != 0) {
                                $dirty5 = Modifier.Companion;
                            } else {
                                $dirty5 = obj18;
                            }
                            z4 = i56 != 0 ? field3 : field3;
                            z6 = companion != 0 ? field3 : readOnly2;
                            if (traceInProgress & 32 != 0) {
                                readOnly2 = 6;
                                i53 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj10 = default;
                                i78 = i44;
                            } else {
                                i56 = default;
                                i78 = obj92;
                                obj10 = obj9;
                            }
                            obj12 = i22 != 0 ? default : visualTransformation2;
                            obj20 = i13 != 0 ? default : obj4;
                            i8 = i40 != 0 ? default : leadingIcon;
                            obj13 = i69 != 0 ? default : trailingIcon;
                            i5 = i7 != 0 ? default : isError;
                            if (i70 != 0) {
                                visualTransformation3 = default;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i35 != 0) {
                                keyboardOptions2 = default;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (traceInProgress & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty16 = $dirty18;
                                $dirty13 = keyboardActions2;
                            } else {
                                $dirty16 = $dirty17;
                                $dirty13 = keyboardActions;
                            }
                            i57 = i31 != 0 ? i44 : singleLine;
                            if (i135 &= traceInProgress != 0) {
                                i67 = i57 != 0 ? i116 : 0x7fffffff /* Unknown resource */;
                                $dirty16 &= i56;
                                i50 = i67;
                            } else {
                                i50 = maxLines;
                            }
                            i42 = i47 != 0 ? i67 : minLines;
                            textStyle3 = i79 != 0 ? i67 : interactionSource;
                            if (i136 &= traceInProgress != 0) {
                                obj16 = outlinedTextFieldShape;
                                i34 = $dirty16;
                            } else {
                                obj16 = shape;
                                i34 = $dirty16;
                            }
                            if (traceInProgress & i38 != 0) {
                                int i150 = i116;
                                int i159 = i137;
                                int i165 = i159;
                                int i168 = i160;
                                i56 = i168;
                                i47 = i56;
                                i79 = i47;
                                i35 = i79;
                                i77 = i35;
                                changed3 = i77;
                                i30 = changed3;
                                i40 = i30;
                                i7 = i40;
                                i19 = i7;
                                i39 = i19;
                                i43 = i39;
                                i45 = i43;
                                i2 = i45;
                                i41 = i2;
                                i76 = i41;
                                int i209 = i207;
                                composer2 = restartGroup;
                                int $composer5 = i23;
                                $composer3 = composer2;
                                shape2 = $dirty13;
                                i68 = i133;
                                field3 = z4;
                                readOnly2 = z6;
                                $dirty14 = obj10;
                                $composer2 = i78;
                                i28 = visualTransformation3;
                                i36 = keyboardOptions2;
                                field = i57;
                                z = i50;
                                obj2 = i42;
                                obj19 = outlinedTextFieldColors-dx8h9Zs;
                                colors2 = i5;
                            } else {
                                $composer3 = restartGroup;
                                int $composer4 = i116;
                                obj19 = colors;
                                shape2 = $dirty13;
                                field3 = z4;
                                readOnly2 = z6;
                                $dirty14 = obj10;
                                $composer2 = i78;
                                colors2 = i5;
                                i28 = visualTransformation3;
                                i36 = keyboardOptions2;
                                field = i57;
                                z = i50;
                                obj2 = i42;
                                i68 = i34;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty3 = traceInProgress & 32 != 0 ? obj92 & default : obj92;
                            if (traceInProgress & 8192 != 0) {
                                $dirty17 &= -7169;
                            }
                            if (i163 &= traceInProgress != 0) {
                                $dirty17 &= default;
                            }
                            if (i101 &= traceInProgress != 0) {
                                $dirty17 &= i6;
                            }
                            if (traceInProgress & i38 != 0) {
                                $dirty17 &= i3;
                            }
                            i8 = leadingIcon;
                            obj13 = trailingIcon;
                            colors2 = isError;
                            field = singleLine;
                            z = maxLines;
                            textStyle3 = interactionSource;
                            obj16 = shape;
                            obj19 = colors;
                            i68 = $dirty17;
                            $composer3 = restartGroup;
                            $dirty14 = obj9;
                            obj12 = visualTransformation2;
                            obj20 = obj4;
                            i36 = keyboardOptions;
                            shape2 = keyboardActions;
                            obj2 = minLines;
                            $composer2 = $dirty3;
                            $dirty5 = obj18;
                            i28 = visualTransformation;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj87 = readOnly2;
                        ComposerKt.traceEventStart(237745923, $composer2, i68, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:366)");
                    } else {
                        obj87 = readOnly2;
                    }
                    if (textStyle3 == 0) {
                        $composer3.startReplaceGroup(-579730026);
                        ComposerKt.sourceInformation($composer3, "368@18581L39");
                        ComposerKt.sourceInformationMarkerStart($composer3, 674035692, "CC(remember):OutlinedTextField.kt#9igjgp");
                        readOnly2 = $composer3;
                        int i173 = 0;
                        obj74 = i99;
                        rememberedValue = readOnly2.rememberedValue();
                        i47 = 0;
                        $dirty12 = i68;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i156 = 0;
                            readOnly2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            i68 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                        i80 = i68;
                    } else {
                        $dirty12 = i68;
                        $composer3.startReplaceGroup(674035041);
                        $composer3.endReplaceGroup();
                        i80 = textStyle3;
                    }
                    $composer3.startReplaceGroup(674040799);
                    ComposerKt.sourceInformation($composer3, "*371@18768L18");
                    i12 = 0;
                    i73 = Long.compare(unbox-impl, i186) != 0 ? 1 : 0;
                    if (i73 != 0) {
                    } else {
                        int i178 = 0;
                        obj74 = value2;
                        $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                    }
                    $composer3.endReplaceGroup();
                    long l = $this$takeOrElse_u2dDxMtmZc$iv;
                    textStyle2 = new TextStyle(l, i22, 0, i38, 0, 0, 0, 0, 0, 0, i7, 0, 0, 0, 0, i55, 0, 0, 0, 0, 0, 0, i41, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    long l2 = l;
                    merge = $dirty14.merge(textStyle2);
                    i25 = 0;
                    i9 = 0;
                    obj76 = field3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (obj12 != null) {
                        obj74 = i149;
                        obj89 = merge;
                        padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SemanticsModifierKt.semantics((Modifier)Modifier.Companion, true, (Function1)OutlinedTextFieldKt.OutlinedTextField.7.INSTANCE), 0, (Density)consume.toDp-GaN1DYA(OutlinedTextFieldKt.OutlinedTextFieldTopPadding), 0, 0, 13, 0);
                    } else {
                        obj89 = merge;
                        padding-qDBjuR0$default = Modifier.Companion;
                    }
                    i153 &= 112;
                    obj90 = consume;
                    SolidColor solidColor = new SolidColor((Color)obj19.cursorColor(colors2, $composer3, i141 |= i154).getValue().unbox-impl(), i154, 0);
                    obj74 = anon;
                    obj80 = colors2;
                    obj86 = obj19;
                    super(value, obj76, field, i28, i80, obj80, obj12, obj20, i8, obj13, obj16, obj86);
                    boolean z8 = obj76;
                    boolean z9 = obj87;
                    i27 = $dirty12;
                    Composer $dirty110 = $composer3;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics($dirty5.then(padding-qDBjuR0$default), colors2, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), $composer3, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), z8, z9, obj89, i36, shape2, field, z, obj2, i28, 0, i80, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-1001528775, true, obj74, $composer3, 54), $dirty110, i108 | i129, i111 | i131, 4096);
                    composer = $dirty110;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation4 = field;
                    singleLine2 = visualTransformation5;
                    obj5 = obj88;
                    field2 = $dirty17;
                    i21 = $composer2;
                    z7 = z8;
                    z3 = z9;
                    i14 = z;
                    i16 = obj2;
                    enabled2 = obj12;
                    readOnly3 = obj20;
                    i62 = i8;
                    i51 = textStyle3;
                    shape3 = obj16;
                    $dirty2 = $dirty5;
                    maxLines2 = i36;
                    minLines2 = shape2;
                    keyboardOptions3 = obj13;
                    keyboardActions3 = i5;
                } else {
                    restartGroup.skipToGroupEnd();
                    i62 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i14 = maxLines;
                    i16 = minLines;
                    i51 = interactionSource;
                    shape3 = shape;
                    i21 = obj92;
                    i27 = $dirty17;
                    composer = restartGroup;
                    field2 = $dirty15;
                    z7 = field3;
                    z3 = readOnly2;
                    obj5 = obj9;
                    enabled2 = visualTransformation2;
                    readOnly3 = obj4;
                    $dirty2 = obj18;
                    keyboardOptions3 = trailingIcon;
                    keyboardActions3 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation4 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.10(value, onValueChange, $dirty2, z7, z3, obj5, enabled2, readOnly3, i62, keyboardOptions3, keyboardActions3, singleLine2, maxLines2, minLines2, visualTransformation4, i14, i16, i51, shape3, field2, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void OutlinedTextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj13;
        Object obj18;
        boolean z7;
        Object obj3;
        Object obj21;
        Object obj12;
        boolean z;
        int i54;
        Object obj2;
        Object obj11;
        int keyboardActions2;
        Object $dirty14;
        Object endRestartGroup;
        int modifier4;
        int defaultsInvalid;
        Object modifier3;
        int i10;
        int i39;
        int i7;
        int i43;
        Object outlinedTextFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer3;
        int $dirty2;
        int $dirty;
        int $dirty15;
        int this_$iv;
        int $dirty13;
        boolean z5;
        int $dirty12;
        Object $dirty1;
        boolean z2;
        Object obj14;
        Object obj4;
        Object modifier2;
        boolean invalid$iv;
        int outlinedTextFieldShape;
        Object enabled2;
        boolean z6;
        Object readOnly2;
        int i52;
        Object obj;
        Object obj19;
        int textStyle2;
        Object obj5;
        Object obj15;
        int label2;
        Object rememberedValue;
        Object obj10;
        int placeholder2;
        int i5;
        int i48;
        int consume;
        VisualTransformation leadingIcon2;
        int i2;
        int i47;
        KeyboardOptions trailingIcon2;
        Object obj16;
        int i3;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation2;
        int visualTransformation3;
        int i8;
        KeyboardOptions keyboardOptions3;
        int keyboardOptions2;
        int i49;
        int i56;
        KeyboardActions keyboardActions4;
        Object keyboardActions5;
        int changed;
        int i38;
        Shape singleLine2;
        int i36;
        int i53;
        Object maxLines2;
        int i20;
        int i25;
        int i15;
        int i24;
        int i11;
        int changed2;
        int i29;
        Object i31;
        int changed4;
        int i30;
        int i33;
        int i32;
        Object obj8;
        int colors2;
        int i12;
        int i58;
        int i21;
        int i55;
        int i41;
        int changed5;
        int i44;
        int changed3;
        int i28;
        int i34;
        int i26;
        int i40;
        int i27;
        int i46;
        int i13;
        int i57;
        boolean changed6;
        int i16;
        int i18;
        int i37;
        int i35;
        int i14;
        Composer $composer2;
        int i;
        int i51;
        int i17;
        int i6;
        boolean z3;
        boolean z4;
        Object obj22;
        int i4;
        Object obj20;
        Object obj7;
        int i9;
        int i50;
        int i19;
        Object obj17;
        KeyboardOptions keyboardOptions4;
        int i42;
        int i45;
        Object obj6;
        Object obj9;
        int i22;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions3;
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
        int i59 = $changed;
        int i70 = $changed1;
        i43 = i23;
        outlinedTextFieldColors-dx8h9Zs = $composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation(outlinedTextFieldColors-dx8h9Zs, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)449@21584L7,460@22138L39,461@22216L22,462@22288L25,464@22322L416:OutlinedTextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if (i43 & 1 != 0) {
            $dirty2 |= 6;
            obj14 = value;
        } else {
            if (i59 & 6 == 0) {
                i52 = outlinedTextFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty2 |= i52;
            } else {
                obj14 = value;
            }
        }
        if (i43 & 2 != 0) {
            $dirty2 |= 48;
            obj = onValueChange;
        } else {
            if (i59 & 48 == 0) {
                i5 = outlinedTextFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj = onValueChange;
            }
        }
        consume = i43 & 4;
        if (consume != 0) {
            $dirty2 |= 384;
            str = modifier;
        } else {
            if (i59 & 384 == 0) {
                i8 = outlinedTextFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                str = modifier;
            }
        }
        int i144 = i43 & 8;
        changed = 1024;
        if (i144 != 0) {
            $dirty2 |= 3072;
            invalid$iv = enabled;
        } else {
            if (i59 & 3072 == 0) {
                i36 = outlinedTextFieldColors-dx8h9Zs.changed(enabled) ? i49 : changed;
                $dirty2 |= i36;
            } else {
                invalid$iv = enabled;
            }
        }
        int i148 = i43 & 16;
        i15 = 8192;
        if (i148 != 0) {
            $dirty2 |= 24576;
            z6 = readOnly;
        } else {
            if (i59 & 24576 == 0) {
                i32 = outlinedTextFieldColors-dx8h9Zs.changed(readOnly) ? i20 : i15;
                $dirty2 |= i32;
            } else {
                z6 = readOnly;
            }
        }
        int i152 = 196608;
        i55 = 65536;
        i41 = 131072;
        if (i59 & i152 == 0) {
            if (i43 & 32 == 0) {
                changed5 = outlinedTextFieldColors-dx8h9Zs.changed(textStyle) ? i41 : i55;
            } else {
                obj5 = textStyle;
            }
            $dirty2 |= changed5;
        } else {
            obj5 = textStyle;
        }
        i44 = i43 & 64;
        final int i161 = 1572864;
        if (i44 != 0) {
            $dirty2 |= i161;
            rememberedValue = label;
        } else {
            if (i59 & i161 == 0) {
                i28 = outlinedTextFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= i28;
            } else {
                rememberedValue = label;
            }
        }
        i47 = i43 & 128;
        final int i155 = 12582912;
        if (i47 != 0) {
            $dirty2 |= i155;
            obj16 = placeholder;
        } else {
            if (i59 & i155 == 0) {
                i26 = outlinedTextFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i26;
            } else {
                obj16 = placeholder;
            }
        }
        int i60 = i43 & 256;
        int i156 = 100663296;
        if (i60 != 0) {
            $dirty2 |= i156;
            i40 = i60;
            obj13 = leadingIcon;
        } else {
            if ($changed & i156 == 0) {
                i40 = i60;
                i27 = outlinedTextFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i27;
            } else {
                i40 = i60;
                obj13 = leadingIcon;
            }
        }
        int i61 = i43 & 512;
        int i158 = 805306368;
        if (i61 != 0) {
            $dirty2 |= i158;
            i46 = i61;
            obj18 = trailingIcon;
        } else {
            if ($changed & i158 == 0) {
                i46 = i61;
                i13 = outlinedTextFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i13;
            } else {
                i46 = i61;
                obj18 = trailingIcon;
            }
        }
        int i62 = i43 & 1024;
        if (i62 != 0) {
            $dirty12 |= 6;
            i57 = i62;
            z7 = isError;
        } else {
            if (i70 & 6 == 0) {
                i57 = i62;
                i30 = outlinedTextFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty12 |= i30;
            } else {
                i57 = i62;
                z7 = isError;
            }
        }
        int i63 = i43 & 2048;
        if (i63 != 0) {
            $dirty12 |= 48;
            i33 = i63;
            obj3 = visualTransformation;
        } else {
            if (i70 & 48 == 0) {
                i33 = i63;
                changed3 = outlinedTextFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= changed3;
            } else {
                i33 = i63;
                obj3 = visualTransformation;
            }
        }
        int i64 = i43 & 4096;
        if (i64 != 0) {
            $dirty12 |= 384;
            i58 = i64;
            obj21 = keyboardOptions;
        } else {
            i58 = i64;
            if (i70 & 384 == 0) {
                i28 = outlinedTextFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty12 |= i28;
            } else {
                obj21 = keyboardOptions;
            }
        }
        if (i70 & 3072 == 0) {
            if (i43 & 8192 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i49 = changed;
                }
            } else {
                obj12 = keyboardActions;
            }
            $dirty12 |= i49;
        } else {
            obj12 = keyboardActions;
        }
        int i67 = i43 & 16384;
        if (i67 != 0) {
            $dirty12 |= 24576;
            i56 = i67;
            z = singleLine;
        } else {
            i56 = i67;
            if (i70 & 24576 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i20 = i15;
                }
                $dirty12 |= i20;
            } else {
                z = singleLine;
            }
        }
        int i147 = i43 & i146;
        if (i147 != 0) {
            $dirty12 |= i152;
            i54 = maxLines;
        } else {
            if (i70 & i152 == 0) {
                i20 = outlinedTextFieldColors-dx8h9Zs.changed(maxLines) ? i41 : i55;
                $dirty12 |= i20;
            } else {
                i54 = maxLines;
            }
        }
        i25 = i43 & i55;
        if (i25 != 0) {
            $dirty12 |= i161;
            obj2 = interactionSource;
        } else {
            if (i70 & i161 == 0) {
                i15 = outlinedTextFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty12 |= i15;
            } else {
                obj2 = interactionSource;
            }
        }
        if (i70 & i155 == 0) {
            if (i43 & i41 == 0) {
                i24 = outlinedTextFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj11 = shape;
            }
            $dirty12 |= i24;
        } else {
            obj11 = shape;
        }
        int i153 = 262144;
        if (i70 & i156 == 0) {
            if (i43 & i153 == 0) {
                obj90 = $dirty12;
                i11 = outlinedTextFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty12;
                $dirty1 = colors;
            }
            keyboardActions2 = i29;
        } else {
            $dirty1 = colors;
            keyboardActions2 = obj90;
        }
        obj90 = $dirty2;
        if ($dirty2 & i31 == 306783378 && i72 &= keyboardActions2 == 38347922) {
            if (i72 &= keyboardActions2 == 38347922) {
                if (!outlinedTextFieldColors-dx8h9Zs.getSkipping()) {
                    outlinedTextFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (outlinedTextFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = str;
                            }
                            z3 = i144 != 0 ? $dirty : invalid$iv;
                            z4 = i148 != 0 ? $dirty : z6;
                            if (i43 & 32 != 0) {
                                int i130 = 6;
                                z6 = 0;
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj22 = this_$iv;
                                i4 = invalid$iv;
                            } else {
                                i4 = obj90;
                                obj22 = obj5;
                            }
                            obj20 = i44 != 0 ? this_$iv : rememberedValue;
                            obj7 = i47 != 0 ? this_$iv : obj16;
                            i9 = i40 != 0 ? this_$iv : leadingIcon;
                            i50 = i46 != 0 ? this_$iv : trailingIcon;
                            i19 = i57 != 0 ? this_$iv : isError;
                            if (i33 != 0) {
                                obj17 = this_$iv;
                            } else {
                                obj17 = visualTransformation;
                            }
                            if (i58 != 0) {
                                keyboardOptions4 = this_$iv;
                            } else {
                                keyboardOptions4 = keyboardOptions;
                            }
                            if (i43 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty13 = $dirty16;
                                $dirty14 = keyboardActions3;
                            } else {
                                $dirty13 = keyboardActions2;
                                $dirty14 = keyboardActions;
                            }
                            i42 = i56 != 0 ? invalid$iv : singleLine;
                            i45 = i147 != 0 ? invalid$iv : maxLines;
                            if (i25 != 0) {
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 674149516, "CC(remember):OutlinedTextField.kt#9igjgp");
                                int i129 = 0;
                                z6 = outlinedTextFieldColors-dx8h9Zs;
                                obj5 = 0;
                                rememberedValue = z6.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i141 = 0;
                                    z6.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    i47 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj6 = invalid$iv;
                            } else {
                                obj6 = interactionSource;
                            }
                            if (i43 & i41 != 0) {
                                obj9 = outlinedTextFieldShape;
                                i22 = $dirty13;
                            } else {
                                obj9 = shape;
                                i22 = $dirty13;
                            }
                            if (i43 & i153 != 0) {
                                keyboardActions4 = $dirty14;
                                obj4 = modifier3;
                                obj8 = outlinedTextFieldColors-dx8h9Zs;
                                keyboardActions2 = $dirty15;
                                invalid$iv = z3;
                                z6 = z4;
                                obj19 = obj22;
                                modifier4 = i4;
                                obj15 = obj20;
                                obj10 = obj7;
                                i48 = i9;
                                i2 = i50;
                                i3 = i19;
                                visualTransformation2 = obj17;
                                keyboardOptions3 = keyboardOptions4;
                                i38 = i42;
                                i53 = i45;
                                i31 = obj6;
                                i33 = obj9;
                            } else {
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                obj8 = colors;
                                keyboardActions4 = $dirty14;
                                obj4 = modifier3;
                                invalid$iv = z3;
                                z6 = z4;
                                obj19 = obj22;
                                modifier4 = i4;
                                obj15 = obj20;
                                obj10 = obj7;
                                i48 = i9;
                                i2 = i50;
                                i3 = i19;
                                visualTransformation2 = obj17;
                                keyboardOptions3 = keyboardOptions4;
                                i38 = i42;
                                i53 = i45;
                                i31 = obj6;
                                i33 = obj9;
                                keyboardActions2 = i22;
                            }
                        } else {
                            outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty15 = i43 & 32 != 0 ? obj90 & i10 : obj90;
                            if (i43 & 8192 != 0) {
                                keyboardActions2 &= -7169;
                            }
                            if (i43 & i41 != 0) {
                                keyboardActions2 &= i39;
                            }
                            if (i43 & i153 != 0) {
                                keyboardActions2 &= i7;
                            }
                            i48 = leadingIcon;
                            i2 = trailingIcon;
                            keyboardOptions3 = keyboardOptions;
                            keyboardActions4 = keyboardActions;
                            i38 = singleLine;
                            i53 = maxLines;
                            i31 = interactionSource;
                            i33 = shape;
                            $composer2 = outlinedTextFieldColors-dx8h9Zs;
                            modifier4 = $dirty15;
                            obj8 = $dirty1;
                            obj19 = obj5;
                            obj15 = rememberedValue;
                            obj10 = obj16;
                            obj4 = str;
                            i3 = isError;
                            visualTransformation2 = visualTransformation;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-288998816, modifier4, keyboardActions2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:463)");
                    }
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, obj4, invalid$iv, z6, obj19, obj15, obj10, i48, i2, i3, visualTransformation2, keyboardOptions3, keyboardActions4, i38, i53, 1, i31, i33, obj8, $composer2, i82 | i106, i91 | i119, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i21 = modifier4;
                    $composer3 = obj4;
                    z5 = invalid$iv;
                    z2 = z6;
                    modifier2 = obj19;
                    enabled2 = obj15;
                    readOnly2 = obj10;
                    textStyle2 = i48;
                    label2 = i2;
                    placeholder2 = i3;
                    leadingIcon2 = visualTransformation2;
                    trailingIcon2 = keyboardOptions3;
                    isError2 = keyboardActions4;
                    visualTransformation3 = i38;
                    keyboardOptions2 = i53;
                    keyboardActions5 = i31;
                    singleLine2 = i33;
                    maxLines2 = obj8;
                    colors2 = keyboardActions2;
                } else {
                    outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions2 = maxLines;
                    keyboardActions5 = interactionSource;
                    singleLine2 = shape;
                    i21 = obj90;
                    $composer2 = outlinedTextFieldColors-dx8h9Zs;
                    maxLines2 = $dirty1;
                    z5 = invalid$iv;
                    z2 = z6;
                    modifier2 = obj5;
                    enabled2 = rememberedValue;
                    readOnly2 = obj16;
                    $composer3 = str;
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
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.12(value, onValueChange, $composer3, z5, z2, modifier2, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation3, keyboardOptions2, keyboardActions5, singleLine2, maxLines2, $changed, $changed1, i43);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void OutlinedTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj7;
        Object obj16;
        boolean z;
        Object obj20;
        Object obj9;
        Object obj15;
        boolean z5;
        int i80;
        int i20;
        Object obj17;
        Object obj10;
        int modifier2;
        int i88;
        int defaultsInvalid;
        Object endRestartGroup;
        int i75;
        int traceInProgress;
        int rememberedValue;
        long color-0d7_KjU;
        Modifier density;
        int $composer2;
        androidx.compose.runtime.ProvidableCompositionLocal localDensity;
        Object colors2;
        int $dirty3;
        Object $dirty;
        String textStyle3;
        int i35;
        int outlinedTextFieldShape;
        boolean $dirty2;
        int $dirty15;
        Object $dirty12;
        Composer $composer3;
        boolean z3;
        Object obj5;
        int obj11;
        Object obj8;
        boolean str;
        int localTextStyle;
        Object enabled2;
        boolean readOnly2;
        int i86;
        Object readOnly3;
        int i6;
        Object obj22;
        Object obj;
        int i13;
        Object obj18;
        KeyboardOptions i54;
        int keyboardOptions3;
        Object visualTransformation3;
        Object shape2;
        int keyboardActions2;
        int i84;
        int field2;
        int i7;
        VisualTransformation singleLine2;
        int z6;
        KeyboardOptions maxLines2;
        Object obj14;
        int textStyle2;
        KeyboardActions minLines2;
        Object obj21;
        VisualTransformation i19;
        int visualTransformation4;
        int i39;
        int i14;
        int i30;
        int i4;
        int i78;
        int i71;
        int i48;
        int changed;
        int i70;
        int i62;
        int l;
        int i87;
        int i82;
        int i17;
        int companion;
        Shape shape3;
        int i25;
        int i38;
        int i18;
        Object field;
        int i15;
        int i26;
        int i36;
        int i5;
        int changed7;
        int i74;
        int i27;
        int i28;
        int $dirty13;
        int $dirty1;
        int changed2;
        int i21;
        int changed5;
        int i31;
        int changed4;
        int $dirty14;
        int i40;
        int changed6;
        int i16;
        int i79;
        int i44;
        int i11;
        int i12;
        int i10;
        int i72;
        int i22;
        boolean changed3;
        int i55;
        int i37;
        int i49;
        int i65;
        int i83;
        int i85;
        int i51;
        Composer composer;
        Composer composer2;
        int i66;
        int i63;
        int i67;
        int i41;
        boolean z2;
        boolean z4;
        Object obj12;
        int i3;
        Object obj6;
        Object obj19;
        int i64;
        int obj3;
        int i47;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        Object obj2;
        int i59;
        int i2;
        int i77;
        int obj4;
        Shape obj13;
        int textStyle4;
        long l2;
        int i;
        int i8;
        int i42;
        int i89;
        int i56;
        int i29;
        int i32;
        int i76;
        int i23;
        int i57;
        int i52;
        int i58;
        int i43;
        int i60;
        int i34;
        int i69;
        int i53;
        int i73;
        int i68;
        int i9;
        int i50;
        int i33;
        int i45;
        int i81;
        int i61;
        ScopeUpdateScope scopeUpdateScope;
        int i46;
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
        $dirty3 = $changed;
        $dirty15 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty3 |= 6;
            obj5 = value;
        } else {
            if (i90 & 6 == 0) {
                i6 = restartGroup.changed(value) ? 4 : 2;
                $dirty3 |= i6;
            } else {
                obj5 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty3 |= 48;
            obj22 = onValueChange;
        } else {
            if (i90 & 48 == 0) {
                i84 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty3 |= i84;
            } else {
                obj22 = onValueChange;
            }
        }
        i7 = traceInProgress & 4;
        if (i7 != 0) {
            $dirty3 |= 384;
            obj21 = modifier;
        } else {
            if (i90 & 384 == 0) {
                i39 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i39;
            } else {
                obj21 = modifier;
            }
        }
        int i175 = traceInProgress & 8;
        i48 = 1024;
        if (i175 != 0) {
            $dirty3 |= 3072;
            str = enabled;
        } else {
            if (i90 & 3072 == 0) {
                i17 = restartGroup.changed(enabled) ? i30 : i48;
                $dirty3 |= i17;
            } else {
                str = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else {
            if (i90 & 24576 == 0) {
                i15 = restartGroup.changed(readOnly) ? 16384 : 8192;
                $dirty3 |= i15;
            } else {
                readOnly2 = readOnly;
            }
        }
        final int i212 = 196608;
        if (i90 & i212 == 0) {
            if (traceInProgress & 32 == 0) {
                changed7 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj18 = textStyle;
            }
            $dirty3 |= changed7;
        } else {
            obj18 = textStyle;
        }
        i74 = traceInProgress & 64;
        i27 = 1572864;
        int i189 = 524288;
        if (i74 != 0) {
            $dirty3 |= i27;
            visualTransformation3 = label;
        } else {
            if (i90 & i27 == 0) {
                changed5 = restartGroup.changedInstance(label) ? 1048576 : i189;
                $dirty3 |= changed5;
            } else {
                visualTransformation3 = label;
            }
        }
        int i171 = traceInProgress & 128;
        int i195 = 12582912;
        if (i171 != 0) {
            $dirty3 |= i195;
            obj14 = placeholder;
        } else {
            if (i90 & i195 == 0) {
                i44 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty3 |= i44;
            } else {
                obj14 = placeholder;
            }
        }
        int i91 = traceInProgress & 256;
        int i197 = 100663296;
        if (i91 != 0) {
            $dirty3 |= i197;
            i11 = i91;
            obj7 = leadingIcon;
        } else {
            if ($changed & i197 == 0) {
                i11 = i91;
                i12 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty3 |= i12;
            } else {
                i11 = i91;
                obj7 = leadingIcon;
            }
        }
        int i92 = traceInProgress & 512;
        int i200 = 805306368;
        if (i92 != 0) {
            $dirty3 |= i200;
            i10 = i92;
            obj16 = trailingIcon;
        } else {
            if ($changed & i200 == 0) {
                i10 = i92;
                i72 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty3 |= i72;
            } else {
                i10 = i92;
                obj16 = trailingIcon;
            }
        }
        int i93 = traceInProgress & 1024;
        if (i93 != 0) {
            $dirty15 |= 6;
            i22 = i93;
            z = isError;
        } else {
            if (i109 & 6 == 0) {
                i22 = i93;
                i25 = restartGroup.changed(isError) ? 4 : 2;
                $dirty15 |= i25;
            } else {
                i22 = i93;
                z = isError;
            }
        }
        int i94 = traceInProgress & 2048;
        if (i94 != 0) {
            $dirty15 |= 48;
            i38 = i94;
            obj20 = visualTransformation;
        } else {
            if (i109 & 48 == 0) {
                i38 = i94;
                changed2 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty15 |= changed2;
            } else {
                i38 = i94;
                obj20 = visualTransformation;
            }
        }
        int i95 = traceInProgress & 4096;
        if (i95 != 0) {
            $dirty15 |= 384;
            i36 = i95;
            obj9 = keyboardOptions;
        } else {
            i36 = i95;
            if (i109 & 384 == 0) {
                changed5 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty15 |= changed5;
            } else {
                obj9 = keyboardOptions;
            }
        }
        int i97 = traceInProgress & 8192;
        if (i97 != 0) {
            $dirty15 |= 3072;
            i21 = i97;
            obj15 = keyboardActions;
        } else {
            i21 = i97;
            if (i109 & 3072 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i30 = i48;
                }
                $dirty15 |= i30;
            } else {
                obj15 = keyboardActions;
            }
        }
        int i98 = traceInProgress & 16384;
        if (i98 != 0) {
            $dirty15 |= 24576;
            i4 = i98;
            z5 = singleLine;
        } else {
            i4 = i98;
            if (i109 & 24576 == 0) {
                i48 = restartGroup.changed(singleLine) ? 16384 : 8192;
                $dirty15 |= i48;
            } else {
                z5 = singleLine;
            }
        }
        if (i109 & i212 == 0) {
            if (traceInProgress & i179 == 0) {
                i70 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i80 = maxLines;
            }
            $dirty15 |= i70;
        } else {
            i80 = maxLines;
        }
        i62 = traceInProgress & i180;
        if (i62 != 0) {
            $dirty15 |= i27;
            i20 = minLines;
        } else {
            if (i109 & i27 == 0) {
                i27 = restartGroup.changed(minLines) ? 1048576 : i189;
                $dirty15 |= i27;
            } else {
                i20 = minLines;
            }
        }
        i28 = traceInProgress & i187;
        if (i28 != 0) {
            $dirty15 |= i195;
            obj17 = interactionSource;
        } else {
            if (i109 & i195 == 0) {
                changed5 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty15 |= changed5;
            } else {
                obj17 = interactionSource;
            }
        }
        if (i109 & i191 == 0) {
            if (traceInProgress & i192 == 0) {
                i31 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj10 = shape;
            }
            $dirty15 |= i31;
        } else {
            obj10 = shape;
        }
        if (i109 & i193 == 0) {
            if (traceInProgress & i189 == 0) {
                obj124 = $dirty15;
                i40 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty15;
                $dirty12 = colors;
            }
            $dirty14 = obj124 | i40;
        } else {
            $dirty12 = colors;
            $dirty14 = obj124;
        }
        if ($dirty3 & i16 == 306783378 && $dirty14 & i106 == 306783378) {
            if ($dirty14 & i106 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    obj124 = -458753;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj21;
                            }
                            z2 = i175 != 0 ? str : str;
                            z4 = companion != 0 ? str : readOnly2;
                            if (traceInProgress & 32 != 0) {
                                readOnly2 = 6;
                                i7 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj12 = $dirty12;
                                i3 = $dirty3;
                            } else {
                                obj12 = obj18;
                                i3 = $dirty3;
                            }
                            obj6 = i74 != 0 ? $dirty3 : visualTransformation3;
                            obj19 = i171 != 0 ? $dirty3 : obj14;
                            i64 = i11 != 0 ? $dirty3 : leadingIcon;
                            obj3 = i10 != 0 ? $dirty3 : trailingIcon;
                            i47 = i22 != 0 ? $dirty3 : isError;
                            if (i38 != 0) {
                                visualTransformation2 = $dirty3;
                            } else {
                                visualTransformation2 = visualTransformation;
                            }
                            if (i36 != 0) {
                                keyboardOptions2 = $dirty3;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (i21 != 0) {
                                obj2 = $dirty3;
                            } else {
                                obj2 = keyboardActions;
                            }
                            i59 = i4 != 0 ? $dirty3 : singleLine;
                            if (i131 &= traceInProgress != 0) {
                                i35 = i59 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                $dirty14 &= obj124;
                                i2 = i35;
                            } else {
                                i2 = maxLines;
                            }
                            i77 = i62 != 0 ? i35 : minLines;
                            obj4 = i28 != 0 ? i35 : interactionSource;
                            if (i132 &= traceInProgress != 0) {
                                obj13 = outlinedTextFieldShape;
                                textStyle4 = $dirty14;
                            } else {
                                obj13 = shape;
                                textStyle4 = $dirty14;
                            }
                            if (traceInProgress & i189 != 0) {
                                composer = restartGroup;
                                int $composer5 = i46;
                                $composer3 = composer;
                                obj = outlinedTextFieldColors-dx8h9Zs;
                                $composer2 = i151;
                                str = z2;
                                readOnly2 = z4;
                                $dirty = obj12;
                                i75 = i3;
                                obj11 = i47;
                                i19 = visualTransformation2;
                                i54 = keyboardOptions2;
                                shape2 = obj2;
                                field2 = i59;
                                z6 = i2;
                                textStyle2 = i77;
                            } else {
                                $composer3 = restartGroup;
                                int $composer4 = 1;
                                obj = colors;
                                str = z2;
                                readOnly2 = z4;
                                $dirty = obj12;
                                i75 = i3;
                                obj11 = i47;
                                i19 = visualTransformation2;
                                i54 = keyboardOptions2;
                                shape2 = obj2;
                                field2 = i59;
                                z6 = i2;
                                textStyle2 = i77;
                                $composer2 = textStyle4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (traceInProgress & 32 != 0) {
                                $dirty3 &= obj124;
                            }
                            if (i100 &= traceInProgress != 0) {
                                $dirty14 &= obj124;
                            }
                            if (i102 &= traceInProgress != 0) {
                                $dirty14 &= i88;
                            }
                            if (traceInProgress & i189 != 0) {
                                i64 = leadingIcon;
                                obj3 = trailingIcon;
                                obj11 = isError;
                                field2 = singleLine;
                                z6 = maxLines;
                                obj4 = interactionSource;
                                obj13 = shape;
                                obj = colors;
                                $composer3 = restartGroup;
                                i75 = $dirty3;
                                $dirty = obj18;
                                obj6 = visualTransformation3;
                                obj19 = obj14;
                                i54 = keyboardOptions;
                                shape2 = keyboardActions;
                                textStyle2 = minLines;
                                $composer2 = i105;
                                modifier2 = obj21;
                                i19 = visualTransformation;
                            } else {
                                i64 = leadingIcon;
                                obj3 = trailingIcon;
                                obj11 = isError;
                                field2 = singleLine;
                                z6 = maxLines;
                                obj4 = interactionSource;
                                obj13 = shape;
                                obj = colors;
                                $composer3 = restartGroup;
                                i75 = $dirty3;
                                $dirty = obj18;
                                obj6 = visualTransformation3;
                                obj19 = obj14;
                                modifier2 = obj21;
                                $composer2 = $dirty14;
                                i19 = visualTransformation;
                                i54 = keyboardOptions;
                                shape2 = keyboardActions;
                                textStyle2 = minLines;
                            }
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj119 = readOnly2;
                        ComposerKt.traceEventStart(-621914704, i75, $composer2, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:157)");
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
                        i62 = 0;
                        $dirty13 = $composer2;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i116 = 0;
                            readOnly2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $composer2 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                        i78 = $composer2;
                    } else {
                        $dirty13 = $composer2;
                        $composer3.startReplaceGroup(673719105);
                        $composer3.endReplaceGroup();
                        i78 = obj4;
                    }
                    $composer3.startReplaceGroup(673724863);
                    ComposerKt.sourceInformation($composer3, "*162@8895L18");
                    color-0d7_KjU = $dirty.getColor-0d7_KjU();
                    int i155 = 0;
                    i18 = 0;
                    i5 = Long.compare(l, i185) != 0 ? 1 : 0;
                    if (i5 != 0) {
                    } else {
                        l = 0;
                        obj106 = color-0d7_KjU;
                        color-0d7_KjU = (Color)obj.textColor(str, $composer3, companion | i18).getValue().unbox-impl();
                    }
                    $composer3.endReplaceGroup();
                    textStyle4 = new TextStyle(color-0d7_KjU, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    i86 = 0;
                    i87 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (obj6 != null) {
                        Modifier semantics = SemanticsModifierKt.semantics((Modifier)Modifier.Companion, true, (Function1)OutlinedTextFieldKt.OutlinedTextField.1.INSTANCE);
                        int i157 = 0;
                        obj122 = consume;
                        density = PaddingKt.padding-qDBjuR0$default(semantics, 0, (Density)consume.toDp-GaN1DYA(OutlinedTextFieldKt.OutlinedTextFieldTopPadding), 0, 0, 13, 0);
                    } else {
                        obj122 = consume;
                        density = Modifier.Companion;
                    }
                    obj112 = obj11;
                    obj108 = str;
                    SolidColor solidColor = new SolidColor((Color)obj.cursorColor(obj11, $composer3, i118 |= i159).getValue().unbox-impl(), str, 0);
                    obj106 = anon;
                    obj118 = obj;
                    super(value, obj108, field2, i19, i78, obj112, obj6, obj19, i64, obj3, obj13, obj118);
                    boolean z7 = obj108;
                    boolean z8 = obj119;
                    Composer composer3 = $composer3;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier2.then(density), obj11, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), $composer3, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), z7, z8, $dirty.merge(textStyle4), i54, shape2, field2, z6, textStyle2, i19, 0, i78, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(1710364390, true, obj106, $composer3, 54), composer3, i127 | i148, i130 | i149, 4096);
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation4 = field2;
                    singleLine2 = visualTransformation5;
                    field = field3;
                    $dirty2 = z7;
                    z3 = z8;
                    i14 = z6;
                    i71 = textStyle2;
                    $dirty14 = $dirty13;
                    obj8 = obj12;
                    enabled2 = obj6;
                    readOnly3 = obj19;
                    i13 = i64;
                    i82 = obj4;
                    shape3 = obj13;
                    colors2 = modifier2;
                    $dirty1 = i75;
                    maxLines2 = i54;
                    minLines2 = shape2;
                    keyboardOptions3 = obj3;
                    keyboardActions2 = i47;
                } else {
                    restartGroup.skipToGroupEnd();
                    i13 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i14 = maxLines;
                    i71 = minLines;
                    i82 = interactionSource;
                    shape3 = shape;
                    composer2 = restartGroup;
                    $dirty1 = $dirty3;
                    field = $dirty12;
                    $dirty2 = str;
                    z3 = readOnly2;
                    obj8 = obj18;
                    enabled2 = visualTransformation3;
                    readOnly3 = obj14;
                    colors2 = obj21;
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
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.4(value, onValueChange, colors2, $dirty2, z3, obj8, enabled2, readOnly3, i13, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation4, i14, i71, i82, shape3, field, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void OutlinedTextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj5;
        Object obj23;
        boolean z6;
        Object obj6;
        Object obj9;
        Object obj10;
        boolean z2;
        int i49;
        Object obj7;
        Object obj15;
        int textStyle2;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier4;
        Object modifier2;
        int i3;
        int i11;
        int enabled3;
        boolean enabled4;
        int i42;
        Object $composer3;
        Object outlinedTextFieldColors-dx8h9Zs;
        boolean traceInProgress;
        int $dirty2;
        boolean $dirty;
        int outlinedTextFieldShape;
        int $dirty1;
        Object $dirty12;
        boolean z3;
        Object obj3;
        Object modifier3;
        Object obj13;
        boolean z5;
        Object enabled2;
        int i25;
        boolean z4;
        Object readOnly2;
        int i56;
        Object obj;
        int textStyle3;
        Object obj8;
        Object rememberedValue;
        int label2;
        Object obj12;
        Object obj21;
        int placeholder2;
        Object obj17;
        int i18;
        VisualTransformation leadingIcon2;
        int i19;
        int i50;
        KeyboardOptions trailingIcon2;
        int i43;
        Object obj19;
        KeyboardActions isError2;
        int i55;
        Object obj2;
        int visualTransformation2;
        VisualTransformation visualTransformation3;
        int i2;
        int keyboardOptions3;
        KeyboardOptions keyboardOptions2;
        int i36;
        int i37;
        Object keyboardActions3;
        KeyboardActions keyboardActions4;
        int changed7;
        Shape singleLine2;
        int i6;
        int i;
        Object maxLines2;
        int i21;
        int i47;
        int i5;
        int i20;
        int i14;
        int i48;
        int changed6;
        int $dirty13;
        int changed3;
        int i38;
        int i8;
        int i41;
        int colors2;
        Object obj11;
        int i29;
        int i44;
        int i45;
        int i28;
        int i10;
        int changed4;
        int i33;
        int changed;
        int i34;
        int changed2;
        int i9;
        int i22;
        int i26;
        int i17;
        int i32;
        int i12;
        int i46;
        boolean changed5;
        int i51;
        int i13;
        int i30;
        int i4;
        int i40;
        Composer $composer2;
        int i24;
        int i16;
        int i7;
        int i35;
        boolean z;
        int i53;
        Object obj20;
        Object obj18;
        int i52;
        int i27;
        int i54;
        Object obj14;
        Object obj4;
        KeyboardActions keyboardActions2;
        int i31;
        int i39;
        Object obj22;
        Object obj16;
        int i15;
        ScopeUpdateScope scopeUpdateScope;
        Object obj71;
        int obj88;
        int i57 = $changed;
        int i72 = $changed1;
        i42 = i23;
        outlinedTextFieldColors-dx8h9Zs = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation(outlinedTextFieldColors-dx8h9Zs, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)240@11690L7,251@12250L39,252@12328L22,253@12400L25,255@12434L416:OutlinedTextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty1 = $changed1;
        if (i42 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = value;
        } else {
            if (i57 & 6 == 0) {
                i56 = outlinedTextFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty2 |= i56;
            } else {
                obj3 = value;
            }
        }
        if (i42 & 2 != 0) {
            $dirty2 |= 48;
            obj = onValueChange;
        } else {
            if (i57 & 48 == 0) {
                i18 = outlinedTextFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i18;
            } else {
                obj = onValueChange;
            }
        }
        i50 = i42 & 4;
        if (i50 != 0) {
            $dirty2 |= 384;
            obj2 = modifier;
        } else {
            if (i57 & 384 == 0) {
                i2 = outlinedTextFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                obj2 = modifier;
            }
        }
        int i141 = i42 & 8;
        changed7 = 1024;
        if (i141 != 0) {
            $dirty2 |= 3072;
            z5 = enabled;
        } else {
            if (i57 & 3072 == 0) {
                i = outlinedTextFieldColors-dx8h9Zs.changed(enabled) ? i36 : changed7;
                $dirty2 |= i;
            } else {
                z5 = enabled;
            }
        }
        int i145 = i42 & 16;
        i20 = 8192;
        if (i145 != 0) {
            $dirty2 |= 24576;
            z4 = readOnly;
        } else {
            if (i57 & 24576 == 0) {
                i41 = outlinedTextFieldColors-dx8h9Zs.changed(readOnly) ? i47 : i20;
                $dirty2 |= i41;
            } else {
                z4 = readOnly;
            }
        }
        int i150 = 196608;
        int i153 = 65536;
        i10 = 131072;
        if (i57 & i150 == 0) {
            if (i42 & 32 == 0) {
                changed4 = outlinedTextFieldColors-dx8h9Zs.changed(textStyle) ? i10 : i153;
            } else {
                rememberedValue = textStyle;
            }
            $dirty2 |= changed4;
        } else {
            rememberedValue = textStyle;
        }
        i33 = i42 & 64;
        final int i160 = 1572864;
        if (i33 != 0) {
            $dirty2 |= i160;
            obj21 = label;
        } else {
            if (i57 & i160 == 0) {
                changed2 = outlinedTextFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= changed2;
            } else {
                obj21 = label;
            }
        }
        int i137 = i42 & 128;
        final int i154 = 12582912;
        if (i137 != 0) {
            $dirty2 |= i154;
            obj19 = placeholder;
        } else {
            if (i57 & i154 == 0) {
                i22 = outlinedTextFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i22;
            } else {
                obj19 = placeholder;
            }
        }
        int i58 = i42 & 256;
        int i155 = 100663296;
        if (i58 != 0) {
            $dirty2 |= i155;
            i26 = i58;
            obj5 = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i26 = i58;
                i17 = outlinedTextFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                i26 = i58;
                obj5 = leadingIcon;
            }
        }
        int i59 = i42 & 512;
        int i157 = 805306368;
        if (i59 != 0) {
            $dirty2 |= i157;
            i32 = i59;
            obj23 = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                i32 = i59;
                i12 = outlinedTextFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i12;
            } else {
                i32 = i59;
                obj23 = trailingIcon;
            }
        }
        int i60 = i42 & 1024;
        if (i60 != 0) {
            $dirty1 |= 6;
            i46 = i60;
            z6 = isError;
        } else {
            if (i72 & 6 == 0) {
                i46 = i60;
                i38 = outlinedTextFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty1 |= i38;
            } else {
                i46 = i60;
                z6 = isError;
            }
        }
        int i61 = i42 & 2048;
        if (i61 != 0) {
            $dirty1 |= 48;
            i8 = i61;
            obj6 = visualTransformation;
        } else {
            if (i72 & 48 == 0) {
                i8 = i61;
                changed = outlinedTextFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= changed;
            } else {
                i8 = i61;
                obj6 = visualTransformation;
            }
        }
        int i62 = i42 & 4096;
        if (i62 != 0) {
            $dirty1 |= 384;
            i44 = i62;
            obj9 = keyboardOptions;
        } else {
            i44 = i62;
            if (i72 & 384 == 0) {
                changed2 = outlinedTextFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty1 |= changed2;
            } else {
                obj9 = keyboardOptions;
            }
        }
        int i64 = i42 & 8192;
        if (i64 != 0) {
            $dirty1 |= 3072;
            i34 = i64;
            obj10 = keyboardActions;
        } else {
            i34 = i64;
            if (i72 & 3072 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i36 = changed7;
                }
                $dirty1 |= i36;
            } else {
                obj10 = keyboardActions;
            }
        }
        int i65 = i42 & 16384;
        if (i65 != 0) {
            $dirty1 |= 24576;
            i37 = i65;
            z2 = singleLine;
        } else {
            i37 = i65;
            if (i72 & 24576 == 0) {
                if (outlinedTextFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i47 = i20;
                }
                $dirty1 |= i47;
            } else {
                z2 = singleLine;
            }
        }
        int i144 = i42 & i143;
        if (i144 != 0) {
            $dirty1 |= i150;
            i49 = maxLines;
        } else {
            if (i72 & i150 == 0) {
                i47 = outlinedTextFieldColors-dx8h9Zs.changed(maxLines) ? i10 : i153;
                $dirty1 |= i47;
            } else {
                i49 = maxLines;
            }
        }
        i5 = i42 & i153;
        if (i5 != 0) {
            $dirty1 |= i160;
            obj7 = interactionSource;
        } else {
            if (i72 & i160 == 0) {
                i20 = outlinedTextFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty1 |= i20;
            } else {
                obj7 = interactionSource;
            }
        }
        if (i72 & i154 == 0) {
            if (i42 & i10 == 0) {
                i14 = outlinedTextFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj15 = shape;
            }
            $dirty1 |= i14;
        } else {
            obj15 = shape;
        }
        int i151 = 262144;
        if (i72 & i155 == 0) {
            if (i42 & i151 == 0) {
                obj88 = $dirty1;
                i48 = outlinedTextFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj88 = $dirty1;
                $dirty12 = colors;
            }
            $dirty13 = obj88 | i48;
        } else {
            $dirty12 = colors;
            $dirty13 = obj88;
        }
        if ($dirty2 & i28 == 306783378 && $dirty13 & i69 == 38347922) {
            if ($dirty13 & i69 == 38347922) {
                if (!outlinedTextFieldColors-dx8h9Zs.getSkipping()) {
                    outlinedTextFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (outlinedTextFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (i50 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = obj2;
                            }
                            enabled4 = i141 != 0 ? 1 : z5;
                            z = i145 != 0 ? z5 : z4;
                            if (i42 & 32 != 0) {
                                z4 = 6;
                                i50 = 0;
                                obj71 = modifier4;
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                modifier2 = outlinedTextFieldColors-dx8h9Zs.consume((CompositionLocal)TextKt.getLocalTextStyle());
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                i53 = $dirty2;
                            } else {
                                obj71 = modifier4;
                                modifier2 = rememberedValue;
                                i53 = $dirty2;
                            }
                            obj20 = i33 != 0 ? $dirty2 : obj21;
                            obj18 = i137 != 0 ? $dirty2 : obj19;
                            i52 = i26 != 0 ? $dirty2 : leadingIcon;
                            i27 = i32 != 0 ? $dirty2 : trailingIcon;
                            i54 = i46 != 0 ? $dirty2 : isError;
                            if (i8 != 0) {
                                obj14 = $dirty2;
                            } else {
                                obj14 = visualTransformation;
                            }
                            if (i44 != 0) {
                                obj4 = $dirty2;
                            } else {
                                obj4 = keyboardOptions;
                            }
                            if (i34 != 0) {
                                keyboardActions2 = $dirty2;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            i31 = i37 != 0 ? $dirty2 : singleLine;
                            i39 = i144 != 0 ? $dirty2 : maxLines;
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(outlinedTextFieldColors-dx8h9Zs, 673833100, "CC(remember):OutlinedTextField.kt#9igjgp");
                                int i122 = 0;
                                i25 = outlinedTextFieldColors-dx8h9Zs;
                                z4 = 0;
                                rememberedValue = i25.rememberedValue();
                                obj21 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i136 = 0;
                                    i25.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    i50 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(outlinedTextFieldColors-dx8h9Zs);
                                obj22 = $dirty2;
                            } else {
                                obj22 = interactionSource;
                            }
                            if (i42 & i10 != 0) {
                                obj16 = outlinedTextFieldShape;
                                i15 = $dirty13;
                            } else {
                                obj16 = shape;
                                i15 = $dirty13;
                            }
                            if (i42 & i151 != 0) {
                                obj13 = obj71;
                                obj8 = modifier2;
                                z5 = enabled4;
                                obj11 = outlinedTextFieldColors-dx8h9Zs;
                                enabled3 = $dirty2;
                                z4 = z;
                                textStyle2 = i53;
                                obj12 = obj20;
                                obj17 = obj18;
                                i19 = i52;
                                i43 = i27;
                                i55 = i54;
                                visualTransformation3 = obj14;
                                keyboardOptions2 = obj4;
                                keyboardActions4 = keyboardActions2;
                                i6 = i31;
                                i21 = i39;
                                $dirty13 = obj22;
                                i8 = obj16;
                            } else {
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                obj13 = obj71;
                                obj11 = colors;
                                obj8 = modifier2;
                                z5 = enabled4;
                                z4 = z;
                                textStyle2 = i53;
                                obj12 = obj20;
                                obj17 = obj18;
                                i19 = i52;
                                i43 = i27;
                                i55 = i54;
                                visualTransformation3 = obj14;
                                keyboardOptions2 = obj4;
                                keyboardActions4 = keyboardActions2;
                                i6 = i31;
                                i21 = i39;
                                $dirty13 = obj22;
                                i8 = obj16;
                                enabled3 = i15;
                            }
                        } else {
                            outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                            if (i42 & 32 != 0) {
                                $dirty2 &= i3;
                            }
                            if (i42 & i10 != 0) {
                                $dirty13 &= i11;
                            }
                            if (i42 & i151 != 0) {
                                i19 = leadingIcon;
                                i43 = trailingIcon;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActions4 = keyboardActions;
                                i6 = singleLine;
                                i21 = maxLines;
                                $dirty13 = interactionSource;
                                i8 = shape;
                                enabled3 = i68;
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                textStyle2 = $dirty2;
                                obj11 = $dirty12;
                                obj8 = rememberedValue;
                                obj12 = obj21;
                                obj17 = obj19;
                                obj13 = obj2;
                                i55 = isError;
                                visualTransformation3 = visualTransformation;
                            } else {
                                i19 = leadingIcon;
                                i43 = trailingIcon;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActions4 = keyboardActions;
                                i6 = singleLine;
                                i21 = maxLines;
                                i8 = shape;
                                $composer2 = outlinedTextFieldColors-dx8h9Zs;
                                textStyle2 = $dirty2;
                                obj11 = $dirty12;
                                obj8 = rememberedValue;
                                obj12 = obj21;
                                obj17 = obj19;
                                obj13 = obj2;
                                enabled3 = $dirty13;
                                i55 = isError;
                                visualTransformation3 = visualTransformation;
                                $dirty13 = interactionSource;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2099955827, textStyle2, enabled3, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:254)");
                    }
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, obj13, z5, z4, obj8, obj12, obj17, i19, i43, i55, visualTransformation3, keyboardOptions2, keyboardActions4, i6, i21, 1, $dirty13, i8, obj11, $composer2, i82 | i106, i91 | i119, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i45 = enabled3;
                    $composer3 = obj13;
                    $dirty = z5;
                    z3 = z4;
                    modifier3 = obj8;
                    enabled2 = obj12;
                    readOnly2 = obj17;
                    textStyle3 = i19;
                    label2 = i43;
                    placeholder2 = i55;
                    leadingIcon2 = visualTransformation3;
                    trailingIcon2 = keyboardOptions2;
                    isError2 = keyboardActions4;
                    visualTransformation2 = i6;
                    keyboardOptions3 = i21;
                    keyboardActions3 = $dirty13;
                    singleLine2 = i8;
                    maxLines2 = obj11;
                    colors2 = textStyle2;
                } else {
                    outlinedTextFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle3 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions3 = maxLines;
                    keyboardActions3 = interactionSource;
                    singleLine2 = shape;
                    $composer2 = outlinedTextFieldColors-dx8h9Zs;
                    colors2 = $dirty2;
                    maxLines2 = $dirty12;
                    $dirty = z5;
                    z3 = z4;
                    modifier3 = rememberedValue;
                    enabled2 = obj21;
                    readOnly2 = obj19;
                    $composer3 = obj2;
                    i45 = $dirty13;
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
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextField.6(value, onValueChange, $composer3, $dirty, z3, modifier3, enabled2, readOnly2, textStyle3, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions3, keyboardActions3, singleLine2, maxLines2, $changed, $changed1, i42);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, boolean singleLine, float animationProgress, Function1<? super Size, Unit> onLabelMeasured, Function2<? super Composer, ? super Integer, Unit> border, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int i34;
        int i26;
        int i32;
        int i36;
        int traceInProgress;
        boolean traceInProgress2;
        int i7;
        Object it$iv;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Integer valueOf2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Object obj2;
        Object valueOf3;
        Object maybeCachedBoxMeasurePolicy2;
        Composer composer2;
        int $composer$iv;
        Composer composer;
        int valueOf6;
        Integer valueOf7;
        Integer valueOf4;
        int materialized$iv$iv2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        Object $composer$iv2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        boolean currentCompositionLocalMap4;
        Object maybeCachedBoxMeasurePolicy;
        int $changed$iv;
        Object materialized$iv$iv;
        androidx.compose.ui.Modifier.Companion $this$coerceAtLeast_u2dYgX7TsA$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Modifier padding-qDBjuR0$default;
        Object iNSTANCE;
        Object $this$dp$iv;
        int then;
        boolean currentCompositionLocalMap3;
        int i3;
        int i8;
        int i24;
        int i27;
        int $dirty;
        Object $i$f$cache2;
        boolean currentCompositionLocalMap2;
        Modifier materializeModifier;
        Composer composer8;
        Integer valueOf5;
        Composer composer5;
        int restartGroup;
        Integer valueOf;
        int $dirty1;
        Composer composer6;
        Object maybeCachedBoxMeasurePolicy3;
        int i9;
        int i2;
        int i21;
        int i35;
        int i22;
        int i10;
        int i11;
        int i29;
        int i20;
        int i30;
        Object companion;
        int $i$f$cache;
        int currentCompositeKeyHash;
        int i19;
        kotlin.jvm.functions.Function0 function0;
        int i33;
        Composer composer3;
        int i5;
        int i4;
        Object obj;
        Composer composer9;
        int i12;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        int i15;
        Modifier modifier3;
        int i;
        int i13;
        int i14;
        int i16;
        int i28;
        int currentCompositeKeyHash3;
        int currentCompositeKeyHash2;
        float f;
        Alignment alignment;
        int $changed$iv2;
        float f2;
        int i6;
        int i18;
        Modifier modifier2;
        kotlin.jvm.functions.Function0 function02;
        int i25;
        int i17;
        Composer composer7;
        int localMap$iv$iv;
        int i23;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer4;
        int i31;
        Object obj66;
        Object obj3 = modifier;
        valueOf3 = textField;
        $composer$iv = placeholder;
        materialized$iv$iv2 = label;
        $composer$iv2 = leading;
        maybeCachedBoxMeasurePolicy = trailing;
        $changed$iv = singleLine;
        padding-qDBjuR0$default = animationProgress;
        iNSTANCE = onLabelMeasured;
        $this$dp$iv = border;
        final Object obj4 = paddingValues;
        int i98 = $changed;
        restartGroup = $composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)508@23459L239,516@23746L7,517@23758L2308:OutlinedTextField.kt#jmzs0o");
        if (i98 & 6 == 0) {
            i9 = restartGroup.changed(obj3) ? 4 : 2;
            $dirty |= i9;
        }
        if (i98 & 48 == 0) {
            i2 = restartGroup.changedInstance(valueOf3) ? 32 : 16;
            $dirty |= i2;
        }
        if (i98 & 384 == 0) {
            i34 = restartGroup.changedInstance($composer$iv) ? 256 : 128;
            $dirty |= i34;
        }
        if (i98 & 3072 == 0) {
            i26 = restartGroup.changedInstance(materialized$iv$iv2) ? 2048 : 1024;
            $dirty |= i26;
        }
        if (i98 & 24576 == 0) {
            i32 = restartGroup.changedInstance($composer$iv2) ? 16384 : 8192;
            $dirty |= i32;
        }
        if (i38 &= i98 == 0) {
            i36 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy) ? 131072 : 65536;
            $dirty |= i36;
        }
        if (i39 &= i98 == 0) {
            i35 = restartGroup.changed($changed$iv) ? 1048576 : 524288;
            $dirty |= i35;
        }
        if (i98 & i129 == 0) {
            i22 = restartGroup.changed(padding-qDBjuR0$default) ? 8388608 : 4194304;
            $dirty |= i22;
        }
        if (i98 & i130 == 0) {
            i10 = restartGroup.changedInstance(iNSTANCE) ? 67108864 : 33554432;
            $dirty |= i10;
        }
        if (i98 & i131 == 0) {
            i11 = restartGroup.changedInstance($this$dp$iv) ? 536870912 : 268435456;
            $dirty |= i11;
        }
        if ($changed1 & 6 == 0) {
            i29 = restartGroup.changed(obj4) ? 4 : 2;
            $dirty1 |= i29;
        }
        if ($dirty & i20 == 306783378 && $dirty1 & 3 == 2) {
            if ($dirty1 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2049536174, $dirty, $dirty1, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:507)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1860606082, "CC(remember):OutlinedTextField.kt#9igjgp");
                    int i128 = 1;
                    i21 = $dirty;
                    i7 = i42 &= $dirty == 67108864 ? i128 : 0;
                    i8 = i21 & i100 == 1048576 ? i128 : 0;
                    i24 = i21 & i102 == 8388608 ? i128 : 0;
                    i27 = $dirty1 & 14 == 4 ? i128 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache2 = 0;
                    it$iv = composer13.rememberedValue();
                    int i132 = 0;
                    if (i45 |= i27 == 0) {
                        $i$f$cache = $i$f$cache2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache2 = 0;
                            companion = it$iv;
                            it$iv = new OutlinedTextFieldMeasurePolicy(iNSTANCE, $changed$iv, padding-qDBjuR0$default, obj4);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            companion = it$iv;
                        }
                    } else {
                        $i$f$cache = $i$f$cache2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i109 = 0;
                    int i133 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    $changed$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                    materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, obj3);
                    kotlin.jvm.functions.Function0 function03 = constructor2;
                    i19 = 0;
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
                    int i135 = 0;
                    i4 = i105;
                    composer9 = restartGroup;
                    Updater.set-impl(constructor-impl, (MeasurePolicy)(OutlinedTextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf = 0;
                    Composer composer14 = constructor-impl;
                    i12 = 0;
                    if (!composer14.getInserting()) {
                        localMap$iv = currentCompositionLocalMap2;
                        i15 = valueOf;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer5 = composer14;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap2;
                        i15 = valueOf;
                    }
                    Updater.set-impl(constructor-impl, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    i3 = composer9;
                    materializeModifier = 0;
                    i5 = i63;
                    ComposerKt.sourceInformationMarkerStart(i3, -988650720, "C525@24262L8,564@25710L182:OutlinedTextField.kt#jmzs0o");
                    $this$dp$iv.invoke(i3, Integer.valueOf(i64 &= 14));
                    restartGroup = "C73@3429L9:Box.kt#2w3rfo";
                    int i136 = 48;
                    String str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier3 = materialized$iv$iv;
                    if ($composer$iv2 != null) {
                        i3.startReplaceGroup(-988654503);
                        ComposerKt.sourceInformation(i3, "528@24323L219");
                        Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        i13 = i136;
                        i14 = 0;
                        i16 = materializeModifier;
                        ComposerKt.sourceInformationMarkerStart(i3, 733328855, str2);
                        int i122 = 0;
                        i28 = $dirty1;
                        maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i122);
                        currentCompositeKeyHash2 = 0;
                        alignment = center2;
                        ComposerKt.sourceInformationMarkerStart(i3, -1323940314, $changed$iv);
                        $changed$iv2 = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                        currentCompositionLocalMap3 = i3.getCurrentCompositionLocalMap();
                        i6 = i122;
                        modifier2 = then3;
                        kotlin.jvm.functions.Function0 function07 = constructor5;
                        i18 = 0;
                        ComposerKt.sourceInformationMarkerStart(i3, -692256719, iNSTANCE);
                        if (!applier5 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i3.startReusableNode();
                        if (i3.getInserting()) {
                            i3.createNode(function07);
                        } else {
                            factory$iv$iv$iv3 = function07;
                            i3.useNode();
                        }
                        function02 = factory$iv$iv$iv3;
                        Composer constructor-impl4 = Updater.constructor-impl(i3);
                        int i154 = 0;
                        Updater.set-impl(constructor-impl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i159 = 0;
                        Composer composer18 = constructor-impl4;
                        int i160 = 0;
                        if (!composer18.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap3;
                            measurePolicy = maybeCachedBoxMeasurePolicy3;
                            if (!Intrinsics.areEqual(composer18.rememberedValue(), Integer.valueOf($changed$iv2))) {
                                composer18.updateRememberedValue(Integer.valueOf($changed$iv2));
                                constructor-impl4.apply(Integer.valueOf($changed$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer6 = composer18;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap3;
                            measurePolicy = maybeCachedBoxMeasurePolicy3;
                        }
                        Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier(i3, then3), ComposeUiNode.Companion.getSetModifier());
                        Composer composer12 = i3;
                        ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, restartGroup);
                        $dirty1 = BoxScopeInstance.INSTANCE;
                        i156 |= 6;
                        localMap$iv$iv = 0;
                        i23 = i74;
                        i31 = i97;
                        $this$dp$iv = composer7;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, 1888671661, "C532@24515L9:OutlinedTextField.kt#jmzs0o");
                        $composer$iv2.invoke($this$dp$iv, Integer.valueOf(i75 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer12);
                        i3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        i3.endReplaceGroup();
                    } else {
                        i16 = materializeModifier;
                        i28 = $dirty1;
                        i3.startReplaceGroup(-988413292);
                        i3.endReplaceGroup();
                    }
                    if (maybeCachedBoxMeasurePolicy != null) {
                        i3.startReplaceGroup(-988370729);
                        ComposerKt.sourceInformation(i3, "536@24609L221");
                        Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(i3, 733328855, str2);
                        valueOf5 = 0;
                        i14 = 0;
                        ComposerKt.sourceInformationMarkerStart(i3, -1323940314, $changed$iv);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                        currentCompositionLocalMap4 = i3.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash2 = center;
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(i3, then2);
                        $changed$iv2 = then2;
                        kotlin.jvm.functions.Function0 function05 = constructor3;
                        alignment = 0;
                        ComposerKt.sourceInformationMarkerStart(i3, -692256719, iNSTANCE);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i3.startReusableNode();
                        if (i3.getInserting()) {
                            i3.createNode(function05);
                        } else {
                            factory$iv$iv$iv4 = function05;
                            i3.useNode();
                        }
                        i6 = factory$iv$iv$iv4;
                        Composer constructor-impl2 = Updater.constructor-impl(i3);
                        int i146 = 0;
                        i25 = i95;
                        Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf5), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i152 = 0;
                        Composer composer17 = constructor-impl2;
                        int i158 = 0;
                        if (!composer17.getInserting()) {
                            localMap$iv$iv = currentCompositionLocalMap4;
                            i23 = valueOf5;
                            if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer8 = composer17;
                            }
                        } else {
                            localMap$iv$iv = currentCompositionLocalMap4;
                            i23 = valueOf5;
                        }
                        Updater.set-impl(constructor-impl2, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        Composer composer11 = i3;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, restartGroup);
                        materializeModifier = BoxScopeInstance.INSTANCE;
                        i148 |= 6;
                        i17 = 0;
                        composer7 = i70;
                        measurePolicy = materializeModifier4;
                        materialized$iv$iv = function02;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1888956396, "C540@24802L10:OutlinedTextField.kt#jmzs0o");
                        maybeCachedBoxMeasurePolicy.invoke(materialized$iv$iv, Integer.valueOf(i71 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer11);
                        i3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        i3.endReplaceGroup();
                    } else {
                        i3.startReplaceGroup(-988127596);
                        i3.endReplaceGroup();
                    }
                    float startPadding = PaddingKt.calculateStartPadding(obj4, (LayoutDirection)consume);
                    float endPadding = PaddingKt.calculateEndPadding(obj4, consume);
                    if (leading != null) {
                        int i93 = 0;
                        int i118 = 0;
                        materializeModifier = 0;
                        f = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        f = startPadding;
                    }
                    if (maybeCachedBoxMeasurePolicy != null) {
                        int i91 = 0;
                        int i116 = 0;
                        materializeModifier = 0;
                        f2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        f2 = endPadding;
                    }
                    padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, f, 0, f2, 0, 10, 0);
                    if ($composer$iv != null) {
                        i3.startReplaceGroup(-987369863);
                        ComposerKt.sourceInformation(i3, "561@25623L59");
                        $composer$iv.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), i3, Integer.valueOf(i113 &= 112));
                        i3.endReplaceGroup();
                    } else {
                        i3.startReplaceGroup(-987282412);
                        i3.endReplaceGroup();
                    }
                    $dirty1 = 384;
                    i2 = 0;
                    obj = consume;
                    ComposerKt.sourceInformationMarkerStart(i3, 733328855, str2);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i128);
                    i14 = 0;
                    currentCompositeKeyHash3 = topStart;
                    ComposerKt.sourceInformationMarkerStart(i3, -1323940314, $changed$iv);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                    currentCompositionLocalMap = i3.getCurrentCompositionLocalMap();
                    alignment = startPadding;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(i3, LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default));
                    i6 = endPadding;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    $changed$iv2 = 0;
                    ComposerKt.sourceInformationMarkerStart(i3, -692256719, iNSTANCE);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i3.startReusableNode();
                    if (i3.getInserting()) {
                        i3.createNode(function06);
                    } else {
                        factory$iv$iv$iv2 = function06;
                        i3.useNode();
                    }
                    i18 = factory$iv$iv$iv2;
                    Composer constructor-impl3 = Updater.constructor-impl(i3);
                    int i149 = 0;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i153 = 0;
                    Composer composer16 = constructor-impl3;
                    int i157 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap;
                        i23 = maybeCachedBoxMeasurePolicy2;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = composer16;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap;
                        i23 = maybeCachedBoxMeasurePolicy2;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = i3;
                    $composer$iv2 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, restartGroup);
                    maybeCachedBoxMeasurePolicy = BoxScopeInstance.INSTANCE;
                    i151 |= 6;
                    i17 = 0;
                    composer7 = i49;
                    measurePolicy = materializeModifier3;
                    materialized$iv$iv2 = i25;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 1890012907, "C568@25867L11:OutlinedTextField.kt#jmzs0o");
                    valueOf3.invoke(materialized$iv$iv2, Integer.valueOf(i50 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    i3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    if (label != null) {
                        i3.startReplaceGroup(-987052578);
                        ComposerKt.sourceInformation(i3, "572@25943L54");
                        Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label");
                        valueOf6 = 6;
                        materialized$iv$iv2 = 0;
                        ComposerKt.sourceInformationMarkerStart(i3, 733328855, str2);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        $dirty = 0;
                        ComposerKt.sourceInformationMarkerStart(i3, -1323940314, $changed$iv);
                        $changed$iv = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                        i2 = topStart2;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(i3, layoutId);
                        companion = layoutId;
                        kotlin.jvm.functions.Function0 function04 = constructor;
                        i20 = 0;
                        ComposerKt.sourceInformationMarkerStart(i3, -692256719, iNSTANCE);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i3.startReusableNode();
                        if (i3.getInserting()) {
                            i3.createNode(function04);
                        } else {
                            factory$iv$iv$iv = function04;
                            i3.useNode();
                        }
                        Composer constructor-impl5 = Updater.constructor-impl(i3);
                        int i134 = 0;
                        i14 = factory$iv$iv$iv;
                        Updater.set-impl(constructor-impl5, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, i3.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i137 = 0;
                        Composer composer15 = constructor-impl5;
                        int i141 = 0;
                        if (!composer15.getInserting()) {
                            $changed$iv2 = valueOf6;
                            if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf($changed$iv))) {
                                composer15.updateRememberedValue(Integer.valueOf($changed$iv));
                                constructor-impl5.apply(Integer.valueOf($changed$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer = composer15;
                            }
                        } else {
                            $changed$iv2 = valueOf6;
                        }
                        Updater.set-impl(constructor-impl5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        valueOf3 = i3;
                        $composer$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf3, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i125 |= 6;
                        composer3 = valueOf3;
                        i12 = 0;
                        i = i56;
                        currentCompositeKeyHash3 = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart(valueOf3, 1890132815, "C572@25988L7:OutlinedTextField.kt#jmzs0o");
                        label.invoke(valueOf3, Integer.valueOf(i57 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(valueOf3);
                        ComposerKt.sourceInformationMarkerEnd(valueOf3);
                        i3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        ComposerKt.sourceInformationMarkerEnd(i3);
                        i3.endReplaceGroup();
                    } else {
                        obj2 = label;
                        i3.startReplaceGroup(-986969932);
                        i3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    composer9.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj2 = materialized$iv$iv2;
                    i21 = $dirty;
                    composer9 = restartGroup;
                    i28 = $dirty1;
                }
            } else {
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer9.endRestartGroup();
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
        int height3;
        int i4;
        Placeable.PlacementScope roundToInt;
        int i11;
        Placeable height2;
        int i12;
        int align2;
        int i10;
        int i5;
        int i3;
        Placeable.PlacementScope placementScope;
        Placeable.PlacementScope placementScope2;
        Placeable placeable2;
        Placeable placeable;
        int i6;
        int widthOrZero;
        int align;
        int i13;
        int i2;
        int i9;
        int i8;
        int i7;
        int i;
        int i14;
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
                height3 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i15);
            } else {
                height3 = roundToInt2;
            }
            if (leadingPlaceable == null) {
                i11 = 0;
            } else {
                i22 *= height2;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable2, roundToInt + roundToInt3, MathHelpersKt.lerp(height3, -i20, f), 0, 4, 0);
        }
        if (singleLine) {
            align3 = Alignment.Companion.getCenterVertically().align(textFieldPlaceable.getHeight(), i15);
        } else {
            align3 = roundToInt2;
        }
        i13 = Math.max(align3, heightOrZero /= 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i13, 0, 4, 0);
        int i19 = i13;
        if (placeholderPlaceable != null) {
            placeable = placeholderPlaceable;
            i4 = 0;
            if (singleLine) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i15);
            } else {
                roundToInt = roundToInt2;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable, TextFieldImplKt.widthOrZero(leadingPlaceable), Math.max(roundToInt, heightOrZero2 /= 2), 0, 4, 0);
        }
        Placeable.PlacementScope.place-70tqf50$default($this$place, borderPlaceable, IntOffset.Companion.getZero-nOcc-ac(), i13, 0, 2);
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
