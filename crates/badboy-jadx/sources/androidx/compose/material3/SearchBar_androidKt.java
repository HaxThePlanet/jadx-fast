package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¾\u0001\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a\u0091\u0001\u0010,\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\u000802\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u00109\u001a\u00020:2\u0008\u0008\u0002\u0010;\u001a\u00020\u00152\u0008\u0008\u0002\u0010<\u001a\u00020\u00152\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\u00080¢\u0006\u0002\u0008?H\u0007ø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u001a\u0089\u0002\u0010,\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001a2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0006\u0010E\u001a\u0002022\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u0010G\u001a\u0002022\u0015\u0008\u0002\u0010H\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\u000802\u0015\u0008\u0002\u0010I\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\u000802\u0015\u0008\u0002\u0010J\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\u000802\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u00109\u001a\u00020:2\u0008\u0008\u0002\u0010;\u001a\u00020\u00152\u0008\u0008\u0002\u0010<\u001a\u00020\u00152\n\u0008\u0002\u0010K\u001a\u0004\u0018\u00010L2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\u00080¢\u0006\u0002\u0008?H\u0007ø\u0001\u0000¢\u0006\u0004\u0008M\u0010N\u001a\u009b\u0001\u0010O\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\u000802\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u00109\u001a\u00020:2\u0008\u0008\u0002\u0010;\u001a\u00020\u00152\u0008\u0008\u0002\u0010<\u001a\u00020\u00152\u0008\u0008\u0002\u0010P\u001a\u00020Q2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\u00080¢\u0006\u0002\u0008?H\u0007ø\u0001\u0000¢\u0006\u0004\u0008R\u0010S\u001a\u0093\u0002\u0010O\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001a2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0006\u0010E\u001a\u0002022\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u0010G\u001a\u0002022\u0015\u0008\u0002\u0010H\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\u000802\u0015\u0008\u0002\u0010I\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\u000802\u0015\u0008\u0002\u0010J\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\u000802\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u00109\u001a\u00020:2\u0008\u0008\u0002\u0010;\u001a\u00020\u00152\u0008\u0008\u0002\u0010<\u001a\u00020\u00152\u0008\u0008\u0002\u0010P\u001a\u00020Q2\n\u0008\u0002\u0010K\u001a\u0004\u0018\u00010L2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\u00080¢\u0006\u0002\u0008?H\u0007ø\u0001\u0000¢\u0006\u0004\u0008T\u0010U\u001a»\u0001\u0010V\u001a\u00020-2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Y0X2\u0006\u0010Z\u001a\u00020[2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u000e\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u0008\u0008\u0002\u00105\u001a\u0002062\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\u000802\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u00109\u001a\u00020:2\u0008\u0008\u0002\u0010;\u001a\u00020\u00152\u0008\u0008\u0002\u0010<\u001a\u00020\u00152\u0008\u0008\u0002\u0010P\u001a\u00020Q2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\u00080¢\u0006\u0002\u0008?H\u0001ø\u0001\u0000¢\u0006\u0004\u0008`\u0010a\u001a\u0094\u0001\u0010b\u001a\u00020-2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Y0X2\u0006\u0010Z\u001a\u00020[2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u000e\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u0006\u00105\u001a\u0002062\u0006\u0010P\u001a\u00020Q2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\u000802\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\u000802\u0013\u0010=\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\u00080H\u0003¢\u0006\u0002\u0010d\u001a\"\u0010e\u001a\u00020\u00072\u0008\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007H\u0002\u001aD\u0010g\u001a\u00020\u00012\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00012\u0008\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010k\u001a\u00020l2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\u0008n\u0010o\u001aN\u0010p\u001a\u00020\u00012\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00012\u0008\u0010_\u001a\u0004\u0018\u00010^2\u0008\u0010\\\u001a\u0004\u0018\u00010^2\u0006\u0010q\u001a\u00020\u00012\u0006\u0010r\u001a\u00020\u00012\u0006\u0010m\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\u0008s\u0010t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u0016\u0010\u0017\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0015X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0018\u0012\u0004\u0008\u001e\u0010\u001f\"\u0010\u0010 \u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0010\u0010!\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0016\u0010\"\u001a\u00020\u0015X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008#\u0010\u0017\"\u000e\u0010$\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010%\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0010\u0010&\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u000e\u0010'\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010(\u001a\u00020\u0015X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008)\u0010\u0017\"\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006u²\u0006\n\u0010v\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u0010w\u001a\u000202X\u008a\u0084\u0002", d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "AnimationPredictiveBackExitFloatSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "DockedExpandedTableMaxHeightScreenRatio", "DockedExpandedTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedExpandedTableMinHeight", "()F", "F", "LayoutIdInputField", "", "LayoutIdSearchContent", "LayoutIdSurface", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMinScale", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "DockedSearchBar", "", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "query", "onQueryChange", "onSearch", "active", "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "calculatePredictiveBackOffsetX", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "material3_release", "useFullScreenShape", "showContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SearchBar_androidKt {

    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing = null;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec = null;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec = null;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing = null;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec = null;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec = null;
    private static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec = null;
    private static final EnterTransition DockedEnterTransition = null;
    private static final ExitTransition DockedExitTransition = null;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedExpandedTableMinHeight = 0f;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarCornerRadius = 0f;
    private static final float SearchBarIconOffsetX = 0f;
    private static final float SearchBarMaxWidth = 0f;
    private static final float SearchBarMinWidth = 0f;
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMaxOffsetY = 0f;
    private static final float SearchBarPredictiveBackMinMargin = 0f;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding;
    private static final androidx.compose.material3.TextFieldColors UnspecifiedTextFieldColors;
    static {
        TextSelectionColors textSelectionColors = new TextSelectionColors(Color.Companion.getUnspecified-0d7_KjU(), obj23, Color.Companion.getUnspecified-0d7_KjU(), obj25, 0);
        TextFieldColors textFieldColors = new TextFieldColors(Color.Companion.getUnspecified-0d7_KjU(), obj2, Color.Companion.getUnspecified-0d7_KjU(), obj4, Color.Companion.getUnspecified-0d7_KjU(), obj6, Color.Companion.getUnspecified-0d7_KjU(), obj8, Color.Companion.getUnspecified-0d7_KjU(), obj10, Color.Companion.getUnspecified-0d7_KjU(), obj12, Color.Companion.getUnspecified-0d7_KjU(), obj14, Color.Companion.getUnspecified-0d7_KjU(), obj16, Color.Companion.getUnspecified-0d7_KjU(), obj18, Color.Companion.getUnspecified-0d7_KjU(), obj20, textSelectionColors, Color.Companion.getUnspecified-0d7_KjU(), obj23, Color.Companion.getUnspecified-0d7_KjU(), obj25, Color.Companion.getUnspecified-0d7_KjU(), obj27, Color.Companion.getUnspecified-0d7_KjU(), obj29, Color.Companion.getUnspecified-0d7_KjU(), obj31, Color.Companion.getUnspecified-0d7_KjU(), obj33, Color.Companion.getUnspecified-0d7_KjU(), obj35, Color.Companion.getUnspecified-0d7_KjU(), obj37, Color.Companion.getUnspecified-0d7_KjU(), obj39, Color.Companion.getUnspecified-0d7_KjU(), obj41, Color.Companion.getUnspecified-0d7_KjU(), obj43, Color.Companion.getUnspecified-0d7_KjU(), obj45, Color.Companion.getUnspecified-0d7_KjU(), obj47, Color.Companion.getUnspecified-0d7_KjU(), obj49, Color.Companion.getUnspecified-0d7_KjU(), obj51, Color.Companion.getUnspecified-0d7_KjU(), obj53, Color.Companion.getUnspecified-0d7_KjU(), obj55, Color.Companion.getUnspecified-0d7_KjU(), obj57, Color.Companion.getUnspecified-0d7_KjU(), obj59, Color.Companion.getUnspecified-0d7_KjU(), obj61, Color.Companion.getUnspecified-0d7_KjU(), obj63, Color.Companion.getUnspecified-0d7_KjU(), obj65, Color.Companion.getUnspecified-0d7_KjU(), obj67, Color.Companion.getUnspecified-0d7_KjU(), obj69, Color.Companion.getUnspecified-0d7_KjU(), obj71, Color.Companion.getUnspecified-0d7_KjU(), obj73, Color.Companion.getUnspecified-0d7_KjU(), obj75, Color.Companion.getUnspecified-0d7_KjU(), obj77, Color.Companion.getUnspecified-0d7_KjU(), obj79, Color.Companion.getUnspecified-0d7_KjU(), obj81, Color.Companion.getUnspecified-0d7_KjU(), obj83, Color.Companion.getUnspecified-0d7_KjU(), obj85, 0);
        SearchBar_androidKt.UnspecifiedTextFieldColors = textFieldColors;
        int i18 = 0;
        SearchBar_androidKt.SearchBarCornerRadius = Dp.constructor-impl(inputFieldHeight-D9Ej5fM / f8);
        int i9 = 0;
        SearchBar_androidKt.DockedExpandedTableMinHeight = Dp.constructor-impl((float)i);
        int i10 = 0;
        SearchBar_androidKt.SearchBarMinWidth = Dp.constructor-impl((float)i2);
        int i11 = 0;
        SearchBar_androidKt.SearchBarMaxWidth = Dp.constructor-impl((float)i3);
        int i12 = 0;
        SearchBar_androidKt.SearchBarVerticalPadding = Dp.constructor-impl((float)i4);
        int i13 = 0;
        SearchBar_androidKt.SearchBarIconOffsetX = Dp.constructor-impl((float)i5);
        int i14 = 0;
        SearchBar_androidKt.SearchBarPredictiveBackMinMargin = Dp.constructor-impl((float)i6);
        int i15 = 0;
        SearchBar_androidKt.SearchBarPredictiveBackMaxOffsetY = Dp.constructor-impl((float)i7);
        SearchBar_androidKt.AnimationEnterEasing = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        int i16 = 1065353216;
        int i19 = 0;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(i19, i16, i19, i16);
        SearchBar_androidKt.AnimationExitEasing = cubicBezierEasing;
        int i17 = 600;
        int i22 = 100;
        SearchBar_androidKt.AnimationEnterFloatSpec = (FiniteAnimationSpec)AnimationSpecKt.tween(i17, i22, (Easing)SearchBar_androidKt.AnimationEnterEasing);
        int i24 = 350;
        SearchBar_androidKt.AnimationExitFloatSpec = (FiniteAnimationSpec)AnimationSpecKt.tween(i24, i22, (Easing)SearchBar_androidKt.AnimationExitEasing);
        int i28 = 2;
        int i30 = 0;
        SearchBar_androidKt.AnimationPredictiveBackExitFloatSpec = (FiniteAnimationSpec)AnimationSpecKt.tween$default(i24, 0, (Easing)SearchBar_androidKt.AnimationExitEasing, i28, i30);
        SearchBar_androidKt.AnimationEnterSizeSpec = (FiniteAnimationSpec)AnimationSpecKt.tween(i17, i22, (Easing)SearchBar_androidKt.AnimationEnterEasing);
        SearchBar_androidKt.AnimationExitSizeSpec = (FiniteAnimationSpec)AnimationSpecKt.tween(i24, i22, (Easing)SearchBar_androidKt.AnimationExitEasing);
        SearchBar_androidKt.DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(SearchBar_androidKt.AnimationEnterFloatSpec, i19, i28, i30).plus(EnterExitTransitionKt.expandVertically$default(SearchBar_androidKt.AnimationEnterSizeSpec, 0, false, 0, 14, 0));
        SearchBar_androidKt.DockedExitTransition = EnterExitTransitionKt.fadeOut$default(SearchBar_androidKt.AnimationExitFloatSpec, i19, i28, i30).plus(EnterExitTransitionKt.shrinkVertically$default(SearchBar_androidKt.AnimationExitSizeSpec, 0, false, 0, 14, 0));
    }

    public static final void DockedSearchBar-EQC0FA8(Function2<? super Composer, ? super Integer, Unit> inputField, boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        int i7;
        int traceInProgress;
        Object shape3;
        int defaultsInvalid;
        Object shape2;
        int i14;
        int i6;
        Object obj;
        int $composer3;
        boolean traceInProgress2;
        Object $composer2;
        int $dirty2;
        int tonalElevation2;
        float tonalElevation3;
        Object $dirty4;
        int i16;
        int i8;
        int i3;
        int $dirty;
        Object obj3;
        float f;
        float f3;
        Object obj2;
        float modifier2;
        int i11;
        Object colors2;
        Object colors-dgg9oW8;
        int changed2;
        Object obj4;
        Composer $composer4;
        Composer shape4;
        int changed;
        float containerColor-0d7_KjU;
        int i13;
        int anon;
        int i9;
        int $dirty3;
        int i10;
        float f2;
        float f4;
        int i;
        int i15;
        Composer composer;
        int i4;
        int i5;
        int i2;
        Object obj30;
        obj = inputField;
        final boolean z = expanded;
        final Object obj5 = onExpandedChange;
        final Object obj7 = content;
        final int i43 = $changed;
        final int i44 = i12;
        $composer3 = $composer.startRestartGroup(1209217899);
        ComposerKt.sourceInformation($composer3, "C(DockedSearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp)287@13410L11,288@13471L8,296@13752L38,300@13946L831,293@13658L1119,325@14815L27,325@14783L59:SearchBar.android.kt#uh7d8r");
        $dirty2 = $changed;
        if (i44 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i43 & 6 == 0) {
                i16 = $composer3.changedInstance(obj) ? 4 : 2;
                $dirty2 |= i16;
            }
        }
        if (i44 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i43 & 48 == 0) {
                i8 = $composer3.changed(z) ? 32 : 16;
                $dirty2 |= i8;
            }
        }
        if (i44 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i43 & 384 == 0) {
                i3 = $composer3.changedInstance(obj5) ? 256 : 128;
                $dirty2 |= i3;
            }
        }
        $dirty = i44 & 8;
        if ($dirty != 0) {
            $dirty2 |= 3072;
            obj2 = modifier;
        } else {
            if (i43 & 3072 == 0) {
                i11 = $composer3.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i11;
            } else {
                obj2 = modifier;
            }
        }
        if (i43 & 24576 == 0) {
            if (i44 & 16 == 0) {
                changed2 = $composer3.changed(shape) ? 16384 : 8192;
            } else {
                colors2 = shape;
            }
            $dirty2 |= changed2;
        } else {
            colors2 = shape;
        }
        if (i48 &= i43 == 0) {
            if (i44 & 32 == 0) {
                changed = $composer3.changed(colors) ? 131072 : 65536;
            } else {
                obj4 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj4 = colors;
        }
        i = i44 & 64;
        int i52 = 1572864;
        if (i != 0) {
            $dirty2 |= i52;
            containerColor-0d7_KjU = tonalElevation;
        } else {
            if (i52 &= i43 == 0) {
                i13 = $composer3.changed(tonalElevation) ? 1048576 : 524288;
                $dirty2 |= i13;
            } else {
                containerColor-0d7_KjU = tonalElevation;
            }
        }
        anon = i44 & 128;
        i15 = 12582912;
        if (anon != 0) {
            $dirty2 |= i15;
            f = shadowElevation;
        } else {
            if (i43 & i15 == 0) {
                i9 = $composer3.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty2 |= i9;
            } else {
                f = shadowElevation;
            }
        }
        int i54 = 100663296;
        if (i44 & 256 != 0) {
            $dirty2 |= i54;
        } else {
            if (i43 & i54 == 0) {
                i7 = $composer3.changedInstance(obj7) ? 67108864 : 33554432;
                $dirty2 |= i7;
            }
        }
        $dirty3 = $dirty2;
        if (i18 &= $dirty2 == 38347922) {
            if (!$composer3.getSkipping()) {
                $composer3.startDefaults();
                int i34 = -458753;
                i10 = -57345;
                if (i43 & 1 != 0) {
                    if ($composer3.getDefaultsInvalid()) {
                        if ($dirty != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i44 & 16 != 0) {
                            shape2 = SearchBarDefaults.INSTANCE.getDockedShape($composer3, 6);
                            $dirty = $dirty3 & i10;
                        } else {
                            shape2 = colors2;
                            $dirty = $dirty3;
                        }
                        if (i44 & 32 != 0) {
                            i10 = $composer3;
                            $composer3 = i2;
                            colors-dgg9oW8 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, containerColor-0d7_KjU, 0, $dirty3, i10);
                            $composer4 = i10;
                            $dirty &= i34;
                        } else {
                            $composer4 = $composer3;
                            $composer3 = anon;
                            colors-dgg9oW8 = colors;
                        }
                        if (i != 0) {
                            tonalElevation3 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                        } else {
                            tonalElevation3 = tonalElevation;
                        }
                        if ($composer3 != 0) {
                            colors2 = shape2;
                            shape3 = searchBarColors2;
                            f4 = $composer3;
                            f2 = tonalElevation3;
                            tonalElevation2 = $dirty;
                        } else {
                            colors2 = shape2;
                            shape3 = searchBarColors;
                            f2 = tonalElevation3;
                            tonalElevation2 = $dirty;
                            f4 = f;
                        }
                    } else {
                        $composer3.skipToGroupEnd();
                        if (i44 & 16 != 0) {
                            $dirty3 = i14;
                        }
                        if (i44 & 32 != 0) {
                            tonalElevation2 = i25;
                            f4 = f;
                            shape3 = obj4;
                            f2 = containerColor-0d7_KjU;
                            $composer4 = $composer3;
                        } else {
                            f4 = f;
                            shape3 = obj4;
                            f2 = containerColor-0d7_KjU;
                            tonalElevation2 = $dirty3;
                            $composer4 = $composer3;
                        }
                    }
                } else {
                }
                $composer4.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1209217899, tonalElevation2, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:292)");
                }
                SearchBar_androidKt.DockedSearchBar.1 anon2 = new SearchBar_androidKt.DockedSearchBar.1(obj, z, shape3, obj7);
                composer = $composer4;
                Object $composer5 = colors2;
                SurfaceKt.Surface-T9BRK9s(SizeKt.width-3ABfNKs(ZIndexModifierKt.zIndex(obj2, 1065353216), SearchBar_androidKt.SearchBarMinWidth), $composer5, shape3.getContainerColor-0d7_KjU(), anon, ColorSchemeKt.contentColorFor-ek8zF_U(shape3.getContainerColor-0d7_KjU(), f, $composer4), i10, f2, f4, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(878471280, true, anon2, $composer4, 54), composer);
                shape4 = composer;
                ComposerKt.sourceInformationMarkerStart(shape4, -994322031, "CC(remember):SearchBar.android.kt#9igjgp");
                if (tonalElevation2 & 896 == 256) {
                } else {
                    i6 = 0;
                }
                Composer composer2 = shape4;
                int i33 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i41 = 0;
                if (i6 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        containerColor-0d7_KjU = 0;
                        anon = new SearchBar_androidKt.DockedSearchBar.2.1(obj5);
                        composer2.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(shape4);
                BackHandlerKt.BackHandler(z, (Function0)anon, shape4, i21 &= 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj30;
                $dirty3 = tonalElevation2;
                $composer2 = obj2;
                f3 = f2;
                modifier2 = f4;
                $dirty4 = colors2;
            } else {
                $composer3.skipToGroupEnd();
                obj3 = obj4;
                shape4 = $composer3;
                $composer2 = obj2;
                modifier2 = f;
                f3 = containerColor-0d7_KjU;
                $dirty4 = colors2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = shape4.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SearchBar_androidKt.DockedSearchBar.3(inputField, z, obj5, $composer2, $dirty4, obj3, f3, modifier2, obj7, i43, i44);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(...))
    public static final void DockedSearchBar-eWTbjVg(String query, Function1<? super String, Unit> onQueryChange, Function1<? super String, Unit> onSearch, boolean active, Function1<? super Boolean, Unit> onActiveChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj2;
        Object obj5;
        Object obj7;
        Object obj3;
        float f3;
        float f;
        Object obj6;
        int modifier3;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier2;
        boolean traceInProgress;
        int i8;
        int leadingIcon2;
        boolean traceInProgress2;
        int $dirty2;
        int $dirty15;
        Object $dirty12;
        int i26;
        int i3;
        Object obj4;
        Object obj9;
        int shadowElevation2;
        boolean z2;
        boolean modifier4;
        Object obj13;
        Object obj14;
        Object shape2;
        Object obj;
        Object obj11;
        int i9;
        Composer $dirty;
        int dockedShape;
        boolean z;
        int tonalElevation2;
        float f2;
        Shape shadowElevation3;
        float f5;
        int i21;
        Object obj10;
        androidx.compose.material3.SearchBarColors searchBarColors;
        float $composer3;
        int $composer2;
        Object obj8;
        float f4;
        Object obj12;
        int colors2;
        Object placeholder2;
        int i4;
        int i25;
        int i5;
        int changed2;
        Object i10;
        int i7;
        Function1 i17;
        int changed4;
        int $dirty1;
        int i11;
        boolean i12;
        int i2;
        int i14;
        int i28;
        int enabled2;
        boolean $dirty13;
        int $dirty14;
        int i29;
        int i6;
        int i24;
        int i13;
        int changed;
        int i15;
        Composer composer;
        int i27;
        int i18;
        int i;
        int i22;
        int i19;
        int i23;
        int i16;
        int changed3;
        ScopeUpdateScope scopeUpdateScope;
        Composer composer2;
        int obj51;
        int i30 = $changed;
        int i40 = $changed1;
        i8 = i20;
        Composer restartGroup = $composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation(restartGroup, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)818@37222L11,819@37283L8,826@37565L591,825@37527L894:SearchBar.android.kt#uh7d8r");
        $dirty2 = $changed;
        if (i8 & 1 != 0) {
            $dirty2 |= 6;
            obj10 = query;
        } else {
            if (i30 & 6 == 0) {
                i26 = restartGroup.changed(query) ? 4 : 2;
                $dirty2 |= i26;
            } else {
                obj10 = query;
            }
        }
        if (i8 & 2 != 0) {
            $dirty2 |= 48;
            obj8 = onQueryChange;
        } else {
            if (i30 & 48 == 0) {
                i3 = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                obj8 = onQueryChange;
            }
        }
        if (i8 & 4 != 0) {
            $dirty2 |= 384;
            obj4 = onSearch;
        } else {
            if (i30 & 384 == 0) {
                i4 = restartGroup.changedInstance(onSearch) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                obj4 = onSearch;
            }
        }
        changed4 = 1024;
        if (i8 & 8 != 0) {
            $dirty2 |= 3072;
            z2 = active;
        } else {
            if (i30 & 3072 == 0) {
                i25 = restartGroup.changed(active) ? i7 : changed4;
                $dirty2 |= i25;
            } else {
                z2 = active;
            }
        }
        i14 = 8192;
        if (i8 & 16 != 0) {
            $dirty2 |= 24576;
            obj14 = onActiveChange;
        } else {
            if (i30 & 24576 == 0) {
                i28 = restartGroup.changedInstance(onActiveChange) ? i11 : i14;
                $dirty2 |= i28;
            } else {
                obj14 = onActiveChange;
            }
        }
        int i88 = i8 & 32;
        i24 = 65536;
        i13 = 196608;
        if (i88 != 0) {
            $dirty2 |= i13;
            obj11 = modifier;
        } else {
            if (i30 & i13 == 0) {
                i15 = restartGroup.changed(modifier) ? i29 : i24;
                $dirty2 |= i15;
            } else {
                obj11 = modifier;
            }
        }
        int i89 = i8 & 64;
        i27 = 1572864;
        if (i89 != 0) {
            $dirty2 |= i27;
            z = enabled;
        } else {
            if (i30 & i27 == 0) {
                i18 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty2 |= i18;
            } else {
                z = enabled;
            }
        }
        i21 = i8 & 128;
        i = 12582912;
        if (i21 != 0) {
            $dirty2 |= i;
            obj12 = placeholder;
        } else {
            if (i30 & i == 0) {
                i22 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i22;
            } else {
                obj12 = placeholder;
            }
        }
        leadingIcon2 = i8 & 256;
        i19 = 100663296;
        if (leadingIcon2 != 0) {
            $dirty2 |= i19;
            obj2 = leadingIcon;
        } else {
            if (i30 & i19 == 0) {
                i19 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i19;
            } else {
                obj2 = leadingIcon;
            }
        }
        int i31 = i8 & 512;
        int i90 = 805306368;
        if (i31 != 0) {
            $dirty2 |= i90;
            i23 = i31;
            obj5 = trailingIcon;
        } else {
            if ($changed & i90 == 0) {
                i23 = i31;
                i16 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i16;
            } else {
                i23 = i31;
                obj5 = trailingIcon;
            }
        }
        if (i40 & 6 == 0) {
            if (i8 & 1024 == 0) {
                i5 = restartGroup.changed(shape) ? 4 : 2;
            } else {
                obj7 = shape;
            }
            $dirty15 |= i5;
        } else {
            obj7 = shape;
        }
        if (i40 & 48 == 0) {
            if (i8 & 2048 == 0) {
                changed = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj3 = colors;
            }
            $dirty15 |= changed;
        } else {
            obj3 = colors;
        }
        int i76 = i8 & 4096;
        if (i76 != 0) {
            $dirty15 |= 384;
            f3 = tonalElevation;
        } else {
            if (i40 & 384 == 0) {
                i18 = restartGroup.changed(tonalElevation) ? 256 : 128;
                $dirty15 |= i18;
            } else {
                f3 = tonalElevation;
            }
        }
        int i77 = i8 & 8192;
        if (i77 != 0) {
            $dirty15 |= 3072;
            f = shadowElevation;
        } else {
            if (i40 & 3072 == 0) {
                if (restartGroup.changed(shadowElevation)) {
                } else {
                    i7 = changed4;
                }
                $dirty15 |= i7;
            } else {
                f = shadowElevation;
            }
        }
        shadowElevation2 = i8 & 16384;
        if (shadowElevation2 != 0) {
            $dirty15 |= 24576;
            obj6 = interactionSource;
        } else {
            if (i40 & 24576 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i11 = i14;
                }
                $dirty15 |= i11;
            } else {
                obj6 = interactionSource;
            }
        }
        if (i8 & i85 != 0) {
            $dirty1 = $dirty16;
            $dirty12 = content;
        } else {
            if (i40 & i13 == 0) {
                if (restartGroup.changedInstance(content)) {
                } else {
                    i29 = i24;
                }
                $dirty1 = obj51 | i29;
            } else {
                $dirty12 = content;
                $dirty1 = obj51;
            }
        }
        if ($dirty2 & i12 == 306783378 && $dirty1 & i35 == 74898) {
            if ($dirty1 & i35 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i41 = 6;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i88 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj11;
                            }
                            i12 = i89 != 0 ? obj11 : z;
                            if (i21 != 0) {
                                obj12 = obj11;
                            }
                            leadingIcon2 = leadingIcon2 != 0 ? 0 : leadingIcon;
                            i14 = i23 != 0 ? obj11 : trailingIcon;
                            if (i8 & 1024 != 0) {
                                $dirty14 = $dirty17;
                                $dirty1 = dockedShape;
                            } else {
                                $dirty14 = $dirty1;
                                $dirty1 = shape;
                            }
                            if (i8 & 2048 != 0) {
                                i6 = shadowElevation2;
                                $composer2 = i83;
                                $dirty2 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, shadowElevation2, 0, obj14, restartGroup);
                                $dirty14 &= -113;
                            } else {
                                i6 = shadowElevation2;
                                $dirty = restartGroup;
                                $composer2 = $dirty2;
                                $dirty2 = colors;
                            }
                            if (i76 != 0) {
                                $dirty12 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                $dirty12 = tonalElevation;
                            }
                            if (i77 != 0) {
                                shadowElevation2 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = shadowElevation;
                            }
                            if (i6 != 0) {
                                i24 = leadingIcon2;
                                f2 = $dirty12;
                                f5 = shadowElevation2;
                                changed = i79;
                                i29 = obj12;
                                obj = $dirty1;
                                i13 = i14;
                                obj13 = modifier2;
                                placeholder2 = $dirty2;
                                modifier3 = $dirty14;
                                $dirty13 = i12;
                            } else {
                                changed = interactionSource;
                                obj13 = modifier2;
                                i24 = leadingIcon2;
                                f2 = $dirty12;
                                f5 = shadowElevation2;
                                i29 = obj12;
                                obj = $dirty1;
                                i13 = i14;
                                modifier3 = $dirty14;
                                placeholder2 = $dirty2;
                                $dirty13 = i12;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i8 & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            if (i8 & 2048 != 0) {
                                modifier3 = $dirty1 & -113;
                                i24 = leadingIcon;
                                i13 = trailingIcon;
                                obj = shape;
                                f5 = shadowElevation;
                                changed = interactionSource;
                                obj13 = obj11;
                                $dirty13 = z;
                                $dirty = restartGroup;
                                i29 = obj12;
                                placeholder2 = colors;
                                f2 = tonalElevation;
                                $composer2 = $dirty2;
                            } else {
                                i24 = leadingIcon;
                                i13 = trailingIcon;
                                obj = shape;
                                f5 = shadowElevation;
                                changed = interactionSource;
                                obj13 = obj11;
                                $dirty13 = z;
                                $dirty = restartGroup;
                                i29 = obj12;
                                modifier3 = $dirty1;
                                placeholder2 = colors;
                                f2 = tonalElevation;
                                $composer2 = $dirty2;
                            }
                        }
                    } else {
                    }
                    $dirty.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1299054533, $composer2, modifier3, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:825)");
                    }
                    SearchBar_androidKt.DockedSearchBar.4 anon = new SearchBar_androidKt.DockedSearchBar.4(placeholder2, obj10, onQueryChange, onSearch, active, onActiveChange, $dirty13, i29, i24, i13, changed);
                    Composer $dirty4 = $dirty;
                    androidx.compose.material3.SearchBarColors $composer4 = placeholder2;
                    i2 = i49;
                    SearchBar_androidKt.DockedSearchBar-EQC0FA8((Function2)ComposableLambdaKt.rememberComposableLambda(-303118761, true, anon, $dirty, 54), active, onActiveChange, obj13, obj, $composer4, f2, f5, content, $dirty4, i48 | leadingIcon2, 0);
                    composer = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj9 = obj13;
                    $composer3 = f2;
                    f4 = f5;
                    searchBarColors = searchBarColors2;
                    modifier4 = $dirty13;
                    i9 = i24;
                    tonalElevation2 = i13;
                    colors2 = changed;
                    enabled2 = modifier3;
                    shadowElevation3 = obj;
                    shape2 = i29;
                } else {
                    restartGroup.skipToGroupEnd();
                    shadowElevation3 = shape;
                    searchBarColors = colors;
                    f4 = shadowElevation;
                    i2 = $dirty2;
                    obj9 = obj11;
                    modifier4 = z;
                    composer = restartGroup;
                    shape2 = obj12;
                    enabled2 = $dirty1;
                    i9 = leadingIcon;
                    tonalElevation2 = trailingIcon;
                    $composer3 = tonalElevation;
                    colors2 = interactionSource;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.DockedSearchBar.5(query, onQueryChange, onSearch, active, onActiveChange, obj9, modifier4, shape2, i9, tonalElevation2, shadowElevation3, searchBarColors, $composer3, f4, colors2, content, $changed, $changed1, i8);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(...))
    public static final void SearchBar-WuY5d9Q(String query, Function1<? super String, Unit> onQueryChange, Function1<? super String, Unit> onSearch, boolean active, Function1<? super Boolean, Unit> onActiveChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj9;
        Object obj3;
        Object obj6;
        Object obj13;
        float f3;
        float f2;
        Object obj8;
        boolean modifier3;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier4;
        int traceInProgress2;
        int i2;
        int leadingIcon2;
        boolean traceInProgress;
        int $dirty;
        int $dirty13;
        Object $dirty1;
        Object tonalElevation2;
        int i16;
        int i;
        Object obj12;
        Object obj2;
        float shadowElevation3;
        boolean z;
        boolean modifier2;
        Object windowInsets2;
        Object windowInsets3;
        Object obj11;
        Object shape3;
        Shape shape2;
        Object obj4;
        int i17;
        int inputFieldShape;
        Composer $dirty2;
        boolean z2;
        int tonalElevation3;
        float f5;
        Object shadowElevation2;
        int i6;
        float f4;
        Object obj10;
        Object windowInsets4;
        WindowInsets windowInsets5;
        Object obj5;
        float f;
        float $composer2;
        int $composer3;
        Object obj7;
        Object obj;
        int i7;
        int i26;
        int i11;
        int changed4;
        int colors2;
        androidx.compose.material3.SearchBarColors searchBarColors;
        int changed2;
        int i22;
        int $dirty12;
        int i5;
        int i25;
        int i8;
        int i28;
        int i27;
        int i19;
        int $dirty14;
        int i15;
        int enabled2;
        int i9;
        boolean z3;
        int i24;
        int i20;
        int changed;
        int i23;
        int i12;
        Composer composer;
        int i29;
        int i18;
        int i3;
        int i4;
        int i14;
        int i13;
        int i10;
        int changed3;
        ScopeUpdateScope scopeUpdateScope;
        Composer composer2;
        int obj53;
        int i30 = $changed;
        int i43 = $changed1;
        i2 = i21;
        Composer restartGroup = $composer.startRestartGroup(1001512593);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)737@34012L15,738@34077L8,741@34258L12,746@34418L591,745@34386L925:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i2 & 1 != 0) {
            $dirty |= 6;
            obj10 = query;
        } else {
            if (i30 & 6 == 0) {
                i16 = restartGroup.changed(query) ? 4 : 2;
                $dirty |= i16;
            } else {
                obj10 = query;
            }
        }
        if (i2 & 2 != 0) {
            $dirty |= 48;
            obj5 = onQueryChange;
        } else {
            if (i30 & 48 == 0) {
                i = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty |= i;
            } else {
                obj5 = onQueryChange;
            }
        }
        if (i2 & 4 != 0) {
            $dirty |= 384;
            obj12 = onSearch;
        } else {
            if (i30 & 384 == 0) {
                i7 = restartGroup.changedInstance(onSearch) ? 256 : 128;
                $dirty |= i7;
            } else {
                obj12 = onSearch;
            }
        }
        int i94 = 1024;
        if (i2 & 8 != 0) {
            $dirty |= 3072;
            z = active;
        } else {
            if (i30 & 3072 == 0) {
                i26 = restartGroup.changed(active) ? changed2 : i94;
                $dirty |= i26;
            } else {
                z = active;
            }
        }
        i28 = 16384;
        if (i2 & 16 != 0) {
            $dirty |= 24576;
            obj11 = onActiveChange;
        } else {
            if (i30 & 24576 == 0) {
                i27 = restartGroup.changedInstance(onActiveChange) ? i28 : i5;
                $dirty |= i27;
            } else {
                obj11 = onActiveChange;
            }
        }
        $dirty14 = i2 & 32;
        i24 = 65536;
        i20 = 196608;
        if ($dirty14 != 0) {
            $dirty |= i20;
            obj4 = modifier;
        } else {
            if (i30 & i20 == 0) {
                i23 = restartGroup.changed(modifier) ? i15 : i24;
                $dirty |= i23;
            } else {
                obj4 = modifier;
            }
        }
        i12 = i2 & 64;
        int i96 = 1572864;
        if (i12 != 0) {
            $dirty |= i96;
            z2 = enabled;
        } else {
            if (i30 & i96 == 0) {
                i18 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty |= i18;
            } else {
                z2 = enabled;
            }
        }
        i6 = i2 & 128;
        i3 = 12582912;
        if (i6 != 0) {
            $dirty |= i3;
            obj7 = placeholder;
        } else {
            if (i30 & i3 == 0) {
                i4 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i4;
            } else {
                obj7 = placeholder;
            }
        }
        leadingIcon2 = i2 & 256;
        i14 = 100663296;
        if (leadingIcon2 != 0) {
            $dirty |= i14;
            obj9 = leadingIcon;
        } else {
            if (i30 & i14 == 0) {
                i14 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i14;
            } else {
                obj9 = leadingIcon;
            }
        }
        int i31 = i2 & 512;
        int i97 = 805306368;
        if (i31 != 0) {
            $dirty |= i97;
            i13 = i31;
            obj3 = trailingIcon;
        } else {
            if ($changed & i97 == 0) {
                i13 = i31;
                i10 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i10;
            } else {
                i13 = i31;
                obj3 = trailingIcon;
            }
        }
        if (i43 & 6 == 0) {
            if (i2 & 1024 == 0) {
                i11 = restartGroup.changed(shape) ? 4 : 2;
            } else {
                obj6 = shape;
            }
            $dirty13 |= i11;
        } else {
            obj6 = shape;
        }
        if (i43 & 48 == 0) {
            if (i2 & 2048 == 0) {
                i29 = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj13 = colors;
            }
            $dirty13 |= i29;
        } else {
            obj13 = colors;
        }
        int i83 = i2 & 4096;
        if (i83 != 0) {
            $dirty13 |= 384;
            f3 = tonalElevation;
        } else {
            if (i43 & 384 == 0) {
                i18 = restartGroup.changed(tonalElevation) ? 256 : 128;
                $dirty13 |= i18;
            } else {
                f3 = tonalElevation;
            }
        }
        shadowElevation3 = i2 & 8192;
        if (shadowElevation3 != 0) {
            $dirty13 |= 3072;
            f2 = shadowElevation;
        } else {
            if (i43 & 3072 == 0) {
                if (restartGroup.changed(shadowElevation)) {
                } else {
                    changed2 = i94;
                }
                $dirty13 |= changed2;
            } else {
                f2 = shadowElevation;
            }
        }
        if (i43 & 24576 == 0) {
            if (i2 & 16384 == 0) {
                if (restartGroup.changed(windowInsets)) {
                    i5 = i28;
                }
            } else {
                obj8 = windowInsets;
            }
            $dirty13 |= i5;
        } else {
            obj8 = windowInsets;
        }
        i22 = i2 & i93;
        if (i22 != 0) {
            $dirty12 = $dirty15;
            $dirty1 = interactionSource;
        } else {
            if (i43 & i20 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i15 = i24;
                }
                $dirty12 = obj53 | i15;
            } else {
                $dirty1 = interactionSource;
                $dirty12 = obj53;
            }
        }
        if (i2 & i24 != 0) {
            $dirty12 |= i96;
            tonalElevation2 = content;
        } else {
            if (i43 & i96 == 0) {
                i25 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty12 |= i25;
            } else {
                tonalElevation2 = content;
            }
        }
        if ($dirty & i8 == 306783378 && $dirty12 & i35 == 599186) {
            if ($dirty12 & i35 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i44 = 6;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if ($dirty14 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = obj4;
                            }
                            i8 = i12 != 0 ? obj4 : z2;
                            if (i6 != 0) {
                                obj7 = obj4;
                            }
                            leadingIcon2 = leadingIcon2 != 0 ? 0 : leadingIcon;
                            i28 = i13 != 0 ? obj4 : trailingIcon;
                            if (i2 & 1024 != 0) {
                                $dirty14 = $dirty16;
                                $dirty12 = inputFieldShape;
                            } else {
                                $dirty14 = $dirty12;
                                $dirty12 = shape;
                            }
                            if (i2 & 2048 != 0) {
                                i9 = shadowElevation3;
                                $composer3 = i90;
                                $dirty = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, shadowElevation3, 0, obj11, restartGroup);
                                $dirty14 &= -113;
                            } else {
                                i9 = shadowElevation3;
                                $dirty2 = restartGroup;
                                $composer3 = $dirty;
                                $dirty = colors;
                            }
                            if (i83 != 0) {
                                tonalElevation2 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = tonalElevation;
                            }
                            if (i9 != 0) {
                                shadowElevation3 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation3 = shadowElevation;
                            }
                            if (i2 & 16384 != 0) {
                                windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets($dirty2, i44);
                                $dirty14 &= obj11;
                            } else {
                                windowInsets2 = windowInsets;
                            }
                            if (i22 != 0) {
                                i20 = leadingIcon2;
                                searchBarColors = $dirty;
                                f5 = tonalElevation2;
                                f4 = shadowElevation3;
                                windowInsets5 = windowInsets2;
                                i12 = i88;
                                i24 = obj7;
                                shape2 = $dirty12;
                                z3 = i8;
                                changed = i28;
                                windowInsets3 = modifier4;
                                modifier3 = $dirty14;
                            } else {
                                i12 = interactionSource;
                                i20 = leadingIcon2;
                                searchBarColors = $dirty;
                                f5 = tonalElevation2;
                                f4 = shadowElevation3;
                                windowInsets5 = windowInsets2;
                                i24 = obj7;
                                shape2 = $dirty12;
                                z3 = i8;
                                changed = i28;
                                windowInsets3 = modifier4;
                                modifier3 = $dirty14;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i2 & 1024 != 0) {
                                $dirty12 &= -15;
                            }
                            if (i2 & 2048 != 0) {
                                $dirty12 &= -113;
                            }
                            if (i2 & 16384 != 0) {
                                modifier3 = $dirty12 & i39;
                                i20 = leadingIcon;
                                changed = trailingIcon;
                                shape2 = shape;
                                searchBarColors = colors;
                                f4 = shadowElevation;
                                windowInsets5 = windowInsets;
                                i12 = interactionSource;
                                windowInsets3 = obj4;
                                z3 = z2;
                                $dirty2 = restartGroup;
                                i24 = obj7;
                                f5 = tonalElevation;
                                $composer3 = $dirty;
                            } else {
                                i20 = leadingIcon;
                                changed = trailingIcon;
                                shape2 = shape;
                                searchBarColors = colors;
                                f4 = shadowElevation;
                                windowInsets5 = windowInsets;
                                i12 = interactionSource;
                                windowInsets3 = obj4;
                                z3 = z2;
                                $dirty2 = restartGroup;
                                i24 = obj7;
                                modifier3 = $dirty12;
                                f5 = tonalElevation;
                                $composer3 = $dirty;
                            }
                        }
                    } else {
                    }
                    $dirty2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1001512593, $composer3, modifier3, "androidx.compose.material3.SearchBar (SearchBar.android.kt:745)");
                    }
                    SearchBar_androidKt.SearchBar.4 anon = new SearchBar_androidKt.SearchBar.4(searchBarColors, query, obj5, onSearch, active, onActiveChange, z3, i24, i20, changed, i12);
                    Composer $dirty4 = $dirty2;
                    androidx.compose.material3.SearchBarColors $composer4 = searchBarColors;
                    i19 = i53;
                    SearchBar_androidKt.SearchBar-Y92LkZI((Function2)ComposableLambdaKt.rememberComposableLambda(-1158111311, true, anon, $dirty2, 54), active, onActiveChange, windowInsets3, shape2, $composer4, f5, f4, windowInsets5, content, $dirty4, i52 | leadingIcon2, 0);
                    composer = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj2 = windowInsets3;
                    f = f5;
                    $composer2 = f4;
                    obj = windowInsets5;
                    windowInsets4 = searchBarColors2;
                    modifier2 = z3;
                    i17 = i20;
                    tonalElevation3 = changed;
                    colors2 = i12;
                    enabled2 = modifier3;
                    shadowElevation2 = shape2;
                    shape3 = i24;
                } else {
                    restartGroup.skipToGroupEnd();
                    shadowElevation2 = shape;
                    windowInsets4 = colors;
                    f = tonalElevation;
                    colors2 = interactionSource;
                    i19 = $dirty;
                    obj2 = obj4;
                    modifier2 = z2;
                    composer = restartGroup;
                    shape3 = obj7;
                    enabled2 = $dirty12;
                    i17 = leadingIcon;
                    tonalElevation3 = trailingIcon;
                    $composer2 = shadowElevation;
                    obj = windowInsets;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.SearchBar.5(query, onQueryChange, onSearch, active, onActiveChange, obj2, modifier2, shape3, i17, tonalElevation3, shadowElevation2, windowInsets4, f, $composer2, obj, colors2, content, $changed, $changed1, i2);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void SearchBar-Y92LkZI(Function2<? super Composer, ? super Integer, Unit> inputField, boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj5;
        boolean traceInProgress2;
        int modifier2;
        Object $i$a$CacheSearchBar_androidKt$SearchBar$finalBackProgress$1;
        Object obj11;
        Object mutableStateOf$default;
        Object it$iv;
        Object $i$a$CacheSearchBar_androidKt$SearchBar$mutatorMutex$1;
        int i14;
        int defaultsInvalid;
        Object modifier4;
        int $dirty;
        Object $dirty4;
        int windowInsets3;
        boolean traceInProgress;
        boolean $this$cache$iv;
        int invalid$iv;
        int i4;
        int i12;
        int i2;
        Object str;
        Object tonalElevation4;
        Object tonalElevation3;
        Object $this$cache$iv2;
        Object i19;
        int i21;
        int i3;
        Object currentBackEvent;
        int shadowElevation2;
        int $i$f$cache;
        int inputFieldShape;
        Object obj10;
        Object obj15;
        int it$iv2;
        int i22;
        int i20;
        Object obj2;
        float $dirty5;
        Object obj14;
        int modifier3;
        float $composer2;
        int changed;
        Object obj3;
        Object obj;
        Object obj13;
        Composer shape2;
        int changed2;
        float f2;
        Object obj4;
        String colors3;
        androidx.compose.material3.SearchBar_androidKt.SearchBar.2.1 $i$a$CacheSearchBar_androidKt$SearchBar$2;
        int i18;
        Object empty;
        int empty2;
        float tonalElevation5;
        float f3;
        Object obj7;
        Object shadowElevation3;
        float f4;
        Object i7;
        Composer.Companion companion;
        Object mutableStateOf$default2;
        androidx.compose.material3.SearchBar_androidKt.SearchBar.2.1 anon;
        int i15;
        int i16;
        Object mutatorMutex;
        int i9;
        Object i10;
        Object $dirty2;
        int changed3;
        int i11;
        int colors2;
        Function1 i5;
        Object tonalElevation2;
        int $dirty3;
        Object firstBackEvent;
        float f;
        Object i6;
        Object obj12;
        Function3 windowInsets2;
        Object obj8;
        Composer composer;
        Object obj9;
        int i;
        int i17;
        int i8;
        Object obj6;
        Object obj33;
        Object obj34;
        Object obj35;
        int obj36;
        $this$cache$iv = expanded;
        $i$a$CacheSearchBar_androidKt$SearchBar$2 = $changed;
        final int i104 = i13;
        Composer restartGroup = $composer.startRestartGroup(1444649673);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp,9)171@8255L15,172@8320L8,175@8501L12,178@8596L64,179@8689L43,180@8758L51,181@8837L51,183@8919L638,183@8894L663,199@9582L27,200@9656L1062,200@9614L1104,226@10724L458:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i104 & 1 != 0) {
            $dirty |= 6;
            obj7 = inputField;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 6 == 0) {
                i12 = restartGroup.changedInstance(inputField) ? 4 : 2;
                $dirty |= i12;
            } else {
                obj7 = inputField;
            }
        }
        if (i104 & 2 != 0) {
            $dirty |= 48;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 48 == 0) {
                i2 = restartGroup.changed($this$cache$iv) ? 32 : 16;
                $dirty |= i2;
            }
        }
        if (i104 & 4 != 0) {
            $dirty |= 384;
            str = onExpandedChange;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 384 == 0) {
                i3 = restartGroup.changedInstance(onExpandedChange) ? 256 : 128;
                $dirty |= i3;
            } else {
                str = onExpandedChange;
            }
        }
        shadowElevation2 = i104 & 8;
        if (shadowElevation2 != 0) {
            $dirty |= 3072;
            obj10 = modifier;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 3072 == 0) {
                i20 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i20;
            } else {
                obj10 = modifier;
            }
        }
        if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 24576 == 0) {
            if (i104 & 16 == 0) {
                changed = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                obj2 = shape;
            }
            $dirty |= changed;
        } else {
            obj2 = shape;
        }
        if (i94 &= $i$a$CacheSearchBar_androidKt$SearchBar$2 == 0) {
            if (i104 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj3 = colors;
            }
            $dirty |= changed2;
        } else {
            obj3 = colors;
        }
        i7 = i104 & 64;
        int i97 = 1572864;
        if (i7 != 0) {
            $dirty |= i97;
            f2 = tonalElevation;
        } else {
            if (i97 &= $i$a$CacheSearchBar_androidKt$SearchBar$2 == 0) {
                i15 = restartGroup.changed(tonalElevation) ? 1048576 : 524288;
                $dirty |= i15;
            } else {
                f2 = tonalElevation;
            }
        }
        shadowElevation3 = i104 & 128;
        i16 = 12582912;
        if (shadowElevation3 != 0) {
            $dirty |= i16;
            tonalElevation5 = shadowElevation;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & i16 == 0) {
                i9 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty |= i9;
            } else {
                tonalElevation5 = shadowElevation;
            }
        }
        if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & i107 == 0) {
            if (i104 & 256 == 0) {
                changed3 = restartGroup.changed(windowInsets) ? 67108864 : 33554432;
            } else {
                tonalElevation4 = windowInsets;
            }
            $dirty |= changed3;
        } else {
            tonalElevation4 = windowInsets;
        }
        i11 = 805306368;
        if (i104 & 512 != 0) {
            $dirty |= i11;
            obj5 = content;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & i11 == 0) {
                i11 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i11;
            } else {
                obj5 = content;
            }
        }
        colors2 = $dirty;
        if ($dirty & i109 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                windowInsets3 = -458753;
                $dirty3 = -57345;
                if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (shadowElevation2 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = obj10;
                        }
                        i22 = 6;
                        if (i104 & 16 != 0) {
                            colors2 = inputFieldShape;
                            $dirty3 = obj2;
                        } else {
                            $dirty3 = colors2;
                            colors2 = obj2;
                        }
                        int i81 = i104 & 32;
                        if (i81 != 0) {
                            windowInsets3 = f;
                            i18 = 256;
                            str = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, i81, 0, obj2, restartGroup);
                            $dirty3 &= i10;
                        } else {
                            windowInsets3 = i22;
                            i18 = 256;
                            str = colors;
                        }
                        if (i7 != 0) {
                            tonalElevation4 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                        } else {
                            tonalElevation4 = tonalElevation;
                        }
                        if (shadowElevation3 != 0) {
                            shadowElevation2 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                        } else {
                            shadowElevation2 = tonalElevation5;
                        }
                        if (i104 & 256 != 0) {
                            obj14 = modifier4;
                            obj8 = windowInsets3;
                            obj4 = str;
                            f3 = tonalElevation4;
                            f4 = shadowElevation2;
                            modifier2 = obj10;
                            obj13 = colors2;
                        } else {
                            obj8 = windowInsets;
                            obj14 = modifier4;
                            obj4 = str;
                            f3 = tonalElevation4;
                            f4 = shadowElevation2;
                            obj13 = colors2;
                            modifier2 = $dirty3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i104 & 16 != 0) {
                            colors2 = i14;
                        }
                        if (i104 & 32 != 0) {
                            colors2 &= windowInsets3;
                        }
                        if (i104 & 256 != 0) {
                            modifier2 = colors2 & i50;
                            obj8 = tonalElevation4;
                            f4 = tonalElevation5;
                            i18 = 256;
                            f3 = f2;
                            obj4 = obj3;
                            obj13 = obj2;
                            obj14 = obj10;
                        } else {
                            obj8 = tonalElevation4;
                            f4 = tonalElevation5;
                            modifier2 = colors2;
                            i18 = 256;
                            f3 = f2;
                            obj4 = obj3;
                            obj13 = obj2;
                            obj14 = obj10;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444649673, modifier2, -1, "androidx.compose.material3.SearchBar (SearchBar.android.kt:177)");
                }
                String str3 = "CC(remember):SearchBar.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626005896, str3);
                int i52 = 0;
                Composer composer4 = restartGroup;
                $i$f$cache = 0;
                Object rememberedValue = composer4.rememberedValue();
                int i105 = 0;
                int i108 = modifier2;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    colors2 = $this$cache$iv ? 1065353216 : 0;
                    obj33 = i52;
                    obj34 = $i$f$cache;
                    composer4.updateRememberedValue(AnimatableKt.Animatable$default(colors2, 0, 2, 0));
                } else {
                    obj33 = i52;
                    obj34 = $i$f$cache;
                    $dirty4 = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626008851, str3);
                int i54 = 0;
                Composer composer5 = restartGroup;
                int i78 = 0;
                Object rememberedValue2 = composer5.rememberedValue();
                int i99 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i47 = 0;
                    composer5.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(2143289344));
                } else {
                    $i$a$CacheSearchBar_androidKt$SearchBar$finalBackProgress$1 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626011067, str3);
                invalid$iv = 0;
                Composer composer6 = restartGroup;
                int i79 = 0;
                Object rememberedValue3 = composer6.rememberedValue();
                int i100 = 0;
                obj34 = $i$a$CacheSearchBar_androidKt$SearchBar$finalBackProgress$1;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    obj35 = i46;
                    obj36 = invalid$iv;
                    invalid$iv = 0;
                    composer6.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(invalid$iv, invalid$iv, 2, invalid$iv));
                } else {
                    obj36 = invalid$iv;
                    obj11 = rememberedValue3;
                }
                $this$cache$iv2 = obj11;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626013595, str3);
                Composer composer2 = restartGroup;
                int i80 = 0;
                Object rememberedValue4 = composer2.rememberedValue();
                int i101 = 0;
                obj35 = i27;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj36 = i45;
                    firstBackEvent = $this$cache$iv2;
                    $this$cache$iv2 = 0;
                    composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default($this$cache$iv2, $this$cache$iv2, 2, $this$cache$iv2));
                } else {
                    firstBackEvent = $this$cache$iv2;
                    mutableStateOf$default = rememberedValue4;
                }
                Object $i$f$cache2 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626016806, str3);
                anon = 1;
                i4 = i108 & 112 == 32 ? anon : i19;
                Composer composer3 = restartGroup;
                i5 = 0;
                it$iv = composer3.rememberedValue();
                i6 = 0;
                if (changedInstance |= i4 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj12 = 0;
                        obj33 = obj14;
                        obj35 = obj4;
                        modifier3 = i108;
                        $dirty2 = obj9;
                        colors3 = str3;
                        obj34 = obj13;
                        it$iv = new SearchBar_androidKt.SearchBar.1.1($dirty4, expanded, obj34, firstBackEvent, (MutableState)$i$f$cache2, 0);
                        composer3.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj33 = obj14;
                        obj35 = obj4;
                        modifier3 = i108;
                        $dirty2 = it$iv;
                        colors3 = str3;
                        str = obj34;
                        obj34 = obj13;
                        shape2 = composer3;
                        $this$cache$iv = expanded;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(Boolean.valueOf(expanded), (Function2)it$iv, restartGroup, i59 &= 14);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626037411, colors3);
                Composer composer7 = restartGroup;
                int i83 = 0;
                Object rememberedValue5 = composer7.rememberedValue();
                int i102 = 0;
                obj36 = i31;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    int i32 = 0;
                    mutatorMutex = new MutatorMutex();
                    composer7.updateRememberedValue(mutatorMutex);
                } else {
                    $i$a$CacheSearchBar_androidKt$SearchBar$mutatorMutex$1 = rememberedValue5;
                }
                Object obj19 = $i$a$CacheSearchBar_androidKt$SearchBar$mutatorMutex$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626040814, colors3);
                i21 = modifier3 & 896 == 256 ? anon : 0;
                Composer composer8 = restartGroup;
                int i84 = 0;
                Object rememberedValue6 = composer8.rememberedValue();
                f2 = 0;
                if (changedInstance2 |= i21 == 0) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        int i103 = 0;
                        anon = new SearchBar_androidKt.SearchBar.2.1((MutatorMutex)obj19, str, $dirty4, onExpandedChange, firstBackEvent, $i$f$cache2, 0);
                        obj6 = obj19;
                        composer8.updateRememberedValue((Function2)anon);
                    } else {
                        $i$a$CacheSearchBar_androidKt$SearchBar$2 = rememberedValue6;
                        obj6 = obj19;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                PredictiveBackHandlerKt.PredictiveBackHandler($this$cache$iv, (Function2)$i$a$CacheSearchBar_androidKt$SearchBar$2, restartGroup, i35 &= 14, 0);
                i16 = obj33;
                changed3 = obj34;
                Object obj20 = obj35;
                f = f4;
                shadowElevation3 = firstBackEvent;
                obj12 = obj8;
                float firstBackEvent2 = f3;
                SearchBar_androidKt.SearchBarImpl-j1jLAyQ($dirty4, str, shadowElevation3, $i$f$cache2, i16, obj7, changed3, obj20, firstBackEvent2, f, obj12, content, restartGroup, i42 | i74, i44 | i76, 0);
                tonalElevation2 = shadowElevation3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                currentBackEvent = changed3;
                obj15 = obj20;
                $composer2 = f;
                obj = obj12;
                colors2 = modifier3;
                $dirty5 = f5;
                tonalElevation3 = i16;
            } else {
                restartGroup.skipToGroupEnd();
                obj = tonalElevation4;
                tonalElevation3 = obj10;
                obj15 = obj17;
                currentBackEvent = obj2;
                composer = restartGroup;
                $dirty5 = f2;
                $composer2 = tonalElevation5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SearchBar_androidKt.SearchBar.3(inputField, $this$cache$iv, onExpandedChange, tonalElevation3, currentBackEvent, obj15, $dirty5, $composer2, obj, content, $changed, i104);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void SearchBarImpl-j1jLAyQ(Animatable<Float, AnimationVector1D> animationProgress, MutableFloatState finalBackProgress, MutableState<BackEventCompat> firstBackEvent, MutableState<BackEventCompat> currentBackEvent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> inputField, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        Object traceInProgress;
        Object endRestartGroup;
        Object obj3;
        boolean skipping;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int i23;
        Object derivedStateOf;
        int rememberComposableLambda;
        int i6;
        int i11;
        int $dirty;
        Object colors-dgg9oW8;
        Shape colors3;
        Object shape3;
        Object surface3;
        Object obj5;
        float f4;
        float colors2;
        float tonalElevation2;
        Object tonalElevation3;
        int i25;
        int i10;
        int i14;
        int i18;
        int i9;
        int inputFieldShape;
        float shadowElevation4;
        Object shadowElevation2;
        Object defaultInputFieldShape;
        int i4;
        boolean changedInstance2;
        Object windowInsets3;
        float windowInsets4;
        Object shadowElevation3;
        float f2;
        Object $composer2;
        Object windowInsets2;
        Object obj6;
        Object rememberedValue;
        int changed3;
        int i7;
        int i12;
        int changedInstance;
        float f3;
        int i2;
        int i24;
        int i21;
        Object obj;
        float f;
        Object obj4;
        Object animatedShape;
        Composer $this$cache$iv;
        int i19;
        int empty;
        Object obj2;
        int i13;
        int fullScreenShape;
        int i22;
        int i8;
        int surface2;
        androidx.compose.runtime.internal.ComposableLambda surface;
        int $dirty1;
        int changed4;
        int i3;
        int shape2;
        int companion;
        int changed;
        int i15;
        int i17;
        int i5;
        Composer composer;
        int i;
        int $dirty2;
        int i20;
        boolean changed2;
        ScopeUpdateScope scopeUpdateScope;
        androidx.compose.ui.Modifier.Companion obj31;
        Object obj33;
        Object obj34;
        Object obj35;
        Object obj36;
        Object obj37;
        int obj39;
        traceInProgress = animationProgress;
        final Object obj8 = content;
        empty = $changed;
        final int i76 = i16;
        Composer restartGroup = $composer.startRestartGroup(-440333505);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBarImpl)P(!1,4,5,3,7,6,9!1,10:c#ui.unit.Dp,8:c#ui.unit.Dp,11)861@38824L15,862@38889L8,865@39070L12,868@39168L7,870@39228L15,871@39295L15,872@39341L101,876@39475L666,892@40180L333,903@40538L99,916@40970L362:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i76 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (empty & 6 == 0) {
                if (empty & 8 == 0) {
                    changedInstance2 = restartGroup.changed(traceInProgress);
                } else {
                    changedInstance2 = restartGroup.changedInstance(traceInProgress);
                }
                i25 = changedInstance2 ? 4 : 2;
                $dirty |= i25;
            }
        }
        if (i76 & 2 != 0) {
            $dirty |= 48;
            obj = finalBackProgress;
        } else {
            if (empty & 48 == 0) {
                i10 = restartGroup.changed(finalBackProgress) ? 32 : 16;
                $dirty |= i10;
            } else {
                obj = finalBackProgress;
            }
        }
        if (i76 & 4 != 0) {
            $dirty |= 384;
            obj4 = firstBackEvent;
        } else {
            if (empty & 384 == 0) {
                i14 = restartGroup.changed(firstBackEvent) ? 256 : 128;
                $dirty |= i14;
            } else {
                obj4 = firstBackEvent;
            }
        }
        if (i76 & 8 != 0) {
            $dirty |= 3072;
            obj2 = currentBackEvent;
        } else {
            if (empty & 3072 == 0) {
                i18 = restartGroup.changed(currentBackEvent) ? 2048 : 1024;
                $dirty |= i18;
            } else {
                obj2 = currentBackEvent;
            }
        }
        i9 = i76 & 16;
        if (i9 != 0) {
            $dirty |= 24576;
            windowInsets3 = modifier;
        } else {
            if (empty & 24576 == 0) {
                i13 = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty |= i13;
            } else {
                windowInsets3 = modifier;
            }
        }
        i22 = 196608;
        if (i76 & 32 != 0) {
            $dirty |= i22;
            obj3 = inputField;
        } else {
            if (empty & i22 == 0) {
                i22 = restartGroup.changedInstance(inputField) ? 131072 : 65536;
                $dirty |= i22;
            } else {
                obj3 = inputField;
            }
        }
        i8 = 1572864;
        if (empty & i8 == 0) {
            if (i76 & 64 == 0) {
                changed4 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj5 = shape;
            }
            $dirty |= changed4;
        } else {
            obj5 = shape;
        }
        i3 = 12582912;
        if (empty & i3 == 0) {
            if (i76 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                shadowElevation3 = colors;
            }
            $dirty |= changed;
        } else {
            shadowElevation3 = colors;
        }
        int i49 = i76 & 256;
        int i81 = 100663296;
        if (i49 != 0) {
            $dirty |= i81;
            i15 = i49;
            f4 = tonalElevation;
        } else {
            if (empty & i81 == 0) {
                i15 = i49;
                i17 = restartGroup.changed(tonalElevation) ? 67108864 : 33554432;
                $dirty |= i17;
            } else {
                i15 = i49;
                f4 = tonalElevation;
            }
        }
        int i50 = i76 & 512;
        int i84 = 805306368;
        if (i50 != 0) {
            $dirty |= i84;
            i5 = i50;
            colors2 = shadowElevation;
        } else {
            if (empty & i84 == 0) {
                i5 = i50;
                i = restartGroup.changed(shadowElevation) ? 536870912 : 268435456;
                $dirty |= i;
            } else {
                i5 = i50;
                colors2 = shadowElevation;
            }
        }
        if ($changed1 & 6 == 0) {
            if (i76 & 1024 == 0) {
                shape2 = restartGroup.changed(windowInsets) ? 4 : 2;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty1 |= shape2;
        } else {
            windowInsets2 = windowInsets;
        }
        if (i76 & 2048 != 0) {
            $dirty1 |= 48;
        } else {
            if ($changed1 & 48 == 0) {
                $dirty2 = restartGroup.changedInstance(obj8) ? 32 : 16;
                $dirty1 |= $dirty2;
            }
        }
        if (i69 &= $dirty == 306783378 && $dirty1 & 19 == 18) {
            if ($dirty1 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i24 = 6;
                    if (empty & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = windowInsets3;
                            }
                            if (i76 & 64 != 0) {
                                shape2 = inputFieldShape;
                                $dirty2 = $dirty;
                            } else {
                                shape2 = shape;
                                $dirty2 = $dirty;
                            }
                            if (i76 & 128 != 0) {
                                inputFieldShape = i24;
                                obj31 = modifier2;
                                modifier3 = changed2;
                                colors-dgg9oW8 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, inputFieldShape, 0, shadowElevation3, restartGroup);
                                $dirty2 &= colors2;
                            } else {
                                obj31 = modifier2;
                                modifier3 = i24;
                                colors-dgg9oW8 = colors;
                            }
                            if (i15 != 0) {
                                tonalElevation2 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = tonalElevation;
                            }
                            if (i5 != 0) {
                                shadowElevation4 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation4 = shadowElevation;
                            }
                            if (i76 & 1024 != 0) {
                                f2 = shadowElevation4;
                                windowInsets2 = windowInsets5;
                                i23 = $dirty1;
                                i21 = $dirty2;
                                shadowElevation2 = obj31;
                                windowInsets4 = tonalElevation2;
                                tonalElevation3 = colors-dgg9oW8;
                                colors3 = shape2;
                            } else {
                                windowInsets2 = windowInsets;
                                windowInsets4 = tonalElevation2;
                                f2 = shadowElevation4;
                                i23 = $dirty1;
                                i21 = $dirty2;
                                shadowElevation2 = obj31;
                                tonalElevation3 = colors-dgg9oW8;
                                colors3 = shape2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i76 & 64 != 0) {
                                $dirty &= i6;
                            }
                            if (i76 & 128 != 0) {
                                $dirty &= i11;
                            }
                            if (i76 & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            f2 = colors2;
                            tonalElevation3 = obj7;
                            i21 = $dirty;
                            shadowElevation2 = windowInsets3;
                            i23 = $dirty1;
                            colors3 = shape;
                            windowInsets4 = tonalElevation;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj31 = shadowElevation2;
                        obj33 = windowInsets2;
                        ComposerKt.traceEventStart(-440333505, i21, i23, "androidx.compose.material3.SearchBarImpl (SearchBar.android.kt:867)");
                    } else {
                        obj31 = shadowElevation2;
                        obj33 = windowInsets2;
                    }
                    int i77 = 0;
                    obj34 = i62;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i63 = 6;
                    defaultInputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(restartGroup, i63);
                    String str3 = "CC(remember):SearchBar.android.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1567245043, str3);
                    obj34 = restartGroup;
                    companion = 0;
                    obj35 = i65;
                    rememberedValue = obj34.rememberedValue();
                    int i82 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj36 = rememberedValue;
                        obj37 = i74;
                        SearchBar_androidKt.SearchBarImpl.useFullScreenShape.2.1 $i$a$CacheSearchBar_androidKt$SearchBarImpl$useFullScreenShape$2 = new SearchBar_androidKt.SearchBarImpl.useFullScreenShape.2.1(traceInProgress);
                        obj34.updateRememberedValue(SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)$i$a$CacheSearchBar_androidKt$SearchBarImpl$useFullScreenShape$2));
                    } else {
                        $this$cache$iv = obj34;
                        obj36 = rememberedValue;
                    }
                    Object $this$cache$iv2 = rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1567240190, str3);
                    if (i73 ^= i8 > 1048576) {
                        if (!restartGroup.changed(colors3)) {
                            i7 = i21 & i8 == 1048576 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer3 = restartGroup;
                    int i78 = 0;
                    Object rememberedValue2 = composer3.rememberedValue();
                    int i80 = 0;
                    if (obj35 | i7 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            if (Intrinsics.areEqual(colors3, defaultInputFieldShape)) {
                                shape2 = colors3;
                                obj37 = defaultInputFieldShape;
                                defaultInputFieldShape = new SearchBar_androidKt.SearchBarImpl.animatedShape.1.1((Density)consume, traceInProgress);
                                shape3 = new GenericShape((Function3)defaultInputFieldShape);
                            } else {
                                obj37 = defaultInputFieldShape;
                                shape3 = SearchBar_androidKt.SearchBarImpl_j1jLAyQ$lambda$9($this$cache$iv2) ? fullScreenShape : shape2;
                            }
                            composer3.updateRememberedValue(shape3);
                        } else {
                            shape2 = colors3;
                            obj37 = defaultInputFieldShape;
                            shape3 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    SearchBar_androidKt.SearchBarImpl.surface.1 anon2 = new SearchBar_androidKt.SearchBarImpl.surface.1((Shape)shape3, tonalElevation3, windowInsets4, f2);
                    surface3 = ComposableLambdaKt.rememberComposableLambda(-170534294, true, anon2, restartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1567206741, str3);
                    i4 = 0;
                    Composer composer2 = restartGroup;
                    int i70 = 0;
                    Object rememberedValue3 = composer2.rememberedValue();
                    int i79 = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj39 = i35;
                        surface = surface3;
                        surface3 = new SearchBar_androidKt.SearchBarImpl.showContent.2.1(traceInProgress);
                        composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)surface3));
                    } else {
                        surface = surface3;
                        derivedStateOf = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.startReplaceGroup(-1567201454);
                    ComposerKt.sourceInformation(restartGroup, "908@40729L215");
                    if (SearchBar_androidKt.SearchBarImpl_j1jLAyQ$lambda$12((State)derivedStateOf)) {
                        SearchBar_androidKt.SearchBarImpl.wrappedContent.1 anon = new SearchBar_androidKt.SearchBarImpl.wrappedContent.1(traceInProgress, tonalElevation3, obj8);
                        i12 = rememberComposableLambda;
                    } else {
                        i12 = rememberComposableLambda;
                    }
                    restartGroup.endReplaceGroup();
                    i9 = obj31;
                    i8 = obj37;
                    i20 = i21;
                    WindowInsets tonalElevation4 = obj33;
                    Composer $dirty4 = restartGroup;
                    obj2 = obj35;
                    SearchBar_androidKt.SearchBarLayout(traceInProgress, finalBackProgress, firstBackEvent, obj2, i9, tonalElevation4, inputField, surface, i12, $dirty4, i34 | i47);
                    composer = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    animatedShape = tonalElevation4;
                    obj6 = surface2;
                    f3 = i3;
                    $composer2 = shape2;
                    f = i15;
                    windowInsets3 = i9;
                } else {
                    restartGroup.skipToGroupEnd();
                    f3 = tonalElevation;
                    i20 = $dirty;
                    f = colors2;
                    composer = restartGroup;
                    animatedShape = windowInsets2;
                    $composer2 = shape;
                    obj6 = shadowElevation3;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.SearchBarImpl.1(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, windowInsets3, inputField, $composer2, obj6, f3, f, animatedShape, obj8, $changed, $changed1, i76);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$12(State<Boolean> $showContent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$showContent$delegate.getValue().booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$9(State<Boolean> $useFullScreenShape$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$useFullScreenShape$delegate.getValue().booleanValue();
    }

    private static final void SearchBarLayout(Animatable<Float, AnimationVector1D> animationProgress, MutableFloatState finalBackProgress, MutableState<BackEventCompat> firstBackEvent, MutableState<BackEventCompat> currentBackEvent, Modifier modifier, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> inputField, Function2<? super Composer, ? super Integer, Unit> surface, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        boolean traceInProgress2;
        Object $i$a$CacheSearchBar_androidKt$SearchBarLayout$unconsumedInsets$1;
        Object unconsumedInsets;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object $changed$iv;
        Object $i$f$Layout;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int $dirty3;
        Object $dirty2;
        int i15;
        Object str;
        Object mutableWindowInsets;
        int i25;
        Object rememberedValue;
        Integer valueOf;
        Integer currentCompositionLocalMap4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        int changedInstance;
        boolean changedInstance2;
        int $composer$iv;
        Object it$iv;
        int empty;
        Object $i$a$CacheSearchBar_androidKt$SearchBarLayout$1;
        int i7;
        int i27;
        int $dirty;
        Composer composer5;
        Integer currentCompositionLocalMap2;
        Composer composer3;
        Object currentCompositionLocalMap3;
        int valueOf2;
        int i26;
        int i12;
        int i18;
        int i3;
        int i14;
        Modifier materializeModifier;
        boolean traceInProgress;
        Object i5;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy2;
        int materialized$iv$iv;
        Composer composer2;
        Object maybeCachedBoxMeasurePolicy;
        Object obj2;
        int obj3;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy3;
        int iNSTANCE;
        int i22;
        int i;
        Object obj;
        int i20;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i28;
        Object currentCompositeKeyHash2;
        Object obj5;
        int i19;
        kotlin.jvm.functions.Function0 function0;
        int i24;
        int i13;
        int i21;
        Composer composer6;
        int i2;
        int companion;
        Object obj4;
        Object it$iv2;
        int invalid$iv;
        int i17;
        int i9;
        int $i$f$setImpl;
        int i6;
        int i10;
        int i11;
        Alignment alignment;
        int currentCompositeKeyHash;
        Object obj6;
        int i8;
        int i16;
        kotlin.jvm.functions.Function0 function02;
        BoxScopeInstance boxScopeInstance;
        int i23;
        Composer $composer2;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier3;
        Composer composer7;
        int i4;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Composer composer4;
        Modifier modifier2;
        Modifier modifier4;
        int obj57;
        $i$f$Layout = animationProgress;
        maybeCachedBoxMeasurePolicy2 = modifier;
        materialized$iv$iv = windowInsets;
        obj2 = inputField;
        obj3 = surface;
        final int i95 = $changed;
        traceInProgress2 = 70029564;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBarLayout)P(!1,3,4,2,6,8,5,7)945@42029L34,950@42191L120,965@42827L5009,946@42068L5768:SearchBar.android.kt#uh7d8r");
        if (i95 & 6 == 0) {
            if (i95 & 8 == 0) {
                changedInstance2 = restartGroup.changed($i$f$Layout);
            } else {
                changedInstance2 = restartGroup.changedInstance($i$f$Layout);
            }
            i15 = changedInstance2 ? 4 : 2;
            $dirty3 |= i15;
        }
        if (i95 & 48 == 0) {
            i = restartGroup.changed(finalBackProgress) ? 32 : 16;
            $dirty3 |= i;
        } else {
            str = finalBackProgress;
        }
        if (i95 & 384 == 0) {
            i28 = restartGroup.changed(firstBackEvent) ? 256 : 128;
            $dirty3 |= i28;
        } else {
            obj = firstBackEvent;
        }
        if (i95 & 3072 == 0) {
            i19 = restartGroup.changed(currentBackEvent) ? 2048 : 1024;
            $dirty3 |= i19;
        } else {
            currentCompositeKeyHash2 = currentBackEvent;
        }
        if (i95 & 24576 == 0) {
            i26 = restartGroup.changed(maybeCachedBoxMeasurePolicy2) ? 16384 : 8192;
            $dirty3 |= i26;
        }
        if (i77 &= i95 == 0) {
            i12 = restartGroup.changed(materialized$iv$iv) ? 131072 : 65536;
            $dirty3 |= i12;
        }
        if (i78 &= i95 == 0) {
            i18 = restartGroup.changedInstance(obj2) ? 1048576 : 524288;
            $dirty3 |= i18;
        }
        if (i79 &= i95 == 0) {
            i3 = restartGroup.changedInstance(obj3) ? 8388608 : 4194304;
            $dirty3 |= i3;
        }
        if (i80 &= i95 == 0) {
            i14 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
            $dirty3 |= i14;
        }
        if (i81 &= $dirty3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty3, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:941)");
                }
                String str5 = "CC(remember):SearchBar.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660147884, str5);
                Composer composer10 = restartGroup;
                int i102 = 0;
                it$iv = composer10.rememberedValue();
                int i105 = 0;
                int i107 = i30;
                if (it$iv == Composer.Companion.getEmpty()) {
                    companion = i38;
                    it$iv2 = it$iv;
                    mutableWindowInsets = new MutableWindowInsets(0, 1, 0);
                    composer10.updateRememberedValue(mutableWindowInsets);
                } else {
                    i22 = 1;
                    mutableWindowInsets = it$iv2;
                }
                unconsumedInsets = mutableWindowInsets;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660142614, str5);
                empty = i62 &= $dirty3 == 131072 ? 1 : 0;
                Composer composer11 = restartGroup;
                int i103 = 0;
                i21 = 0;
                Object rememberedValue6 = composer11.rememberedValue();
                int i108 = 0;
                if (empty == 0) {
                    invalid$iv = empty;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv2;
                        $i$a$CacheSearchBar_androidKt$SearchBarLayout$1 = new SearchBar_androidKt.SearchBarLayout.1.1((MutableWindowInsets)unconsumedInsets, materialized$iv$iv);
                        composer11.updateRememberedValue((Function1)$i$a$CacheSearchBar_androidKt$SearchBarLayout$1);
                    } else {
                        $i$a$CacheSearchBar_androidKt$SearchBarLayout$1 = rememberedValue6;
                    }
                } else {
                    invalid$iv = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660117373, str5);
                if ($dirty3 & 14 != 4) {
                    if ($dirty3 & 8 != 0 && restartGroup.changedInstance($i$f$Layout)) {
                        if (restartGroup.changedInstance($i$f$Layout)) {
                            i25 = 1;
                        } else {
                            i25 = i21;
                        }
                    } else {
                    }
                } else {
                }
                i7 = $dirty3 & 7168 == 2048 ? 1 : i21;
                i27 = $dirty3 & 112 == 32 ? 1 : i21;
                composer6 = $dirty3 & 896 == 256 ? 1 : i21;
                Composer composer12 = restartGroup;
                int i101 = 0;
                rememberedValue = composer12.rememberedValue();
                int i104 = 0;
                if (i47 |= composer6 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i13 = 0;
                        obj5 = rememberedValue;
                        i20 = i67;
                        unconsumedInsets = new SearchBar_androidKt.SearchBarLayout.2.1($i$f$Layout, unconsumedInsets, currentCompositeKeyHash2, finalBackProgress, obj);
                        composer12.updateRememberedValue((MeasurePolicy)unconsumedInsets);
                    } else {
                        i20 = $dirty3;
                        obj5 = rememberedValue;
                        $dirty2 = unconsumedInsets;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i31 = i21;
                materializeModifier = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, materializeModifier);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i21);
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(restartGroup, WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(ZIndexModifierKt.zIndex(maybeCachedBoxMeasurePolicy2, 1065353216), (Function1)$i$a$CacheSearchBar_androidKt$SearchBarLayout$1), materialized$iv$iv));
                i70 |= 6;
                kotlin.jvm.functions.Function0 function03 = constructor;
                i19 = 0;
                i24 = i31;
                i13 = i39;
                $i$f$Layout = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $i$f$Layout);
                if (!applier instanceof Applier) {
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
                int i109 = 0;
                obj4 = $dirty2;
                Updater.set-impl(constructor-impl, (MeasurePolicy)rememberedValue, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf = 0;
                Composer composer13 = constructor-impl;
                int i111 = 0;
                if (!composer13.getInserting()) {
                    $i$f$setImpl = valueOf;
                    i6 = valueOf2;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer13;
                    }
                } else {
                    $i$f$setImpl = valueOf;
                    i6 = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                $dirty3 = restartGroup;
                i2 = i33;
                ComposerKt.sourceInformationMarkerStart($dirty3, 36789781, "C955@42396L85,956@42494L119:SearchBar.android.kt#uh7d8r");
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Surface");
                int i72 = 1;
                int i110 = 390;
                int i112 = 0;
                i9 = i49;
                maybeCachedBoxMeasurePolicy2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($dirty3, 733328855, maybeCachedBoxMeasurePolicy2);
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i72);
                int i117 = 0;
                Alignment alignment2 = topStart;
                ComposerKt.sourceInformationMarkerStart($dirty3, -1323940314, materializeModifier);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($dirty3, 0);
                currentCompositionLocalMap4 = $dirty3.getCurrentCompositionLocalMap();
                int i118 = i72;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($dirty3, layoutId);
                Modifier modifier5 = layoutId;
                kotlin.jvm.functions.Function0 function06 = constructor4;
                int i120 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty3, -692256719, $i$f$Layout);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $dirty3.startReusableNode();
                if ($dirty3.getInserting()) {
                    $dirty3.createNode(function06);
                } else {
                    factory$iv$iv$iv2 = function06;
                    $dirty3.useNode();
                }
                kotlin.jvm.functions.Function0 function07 = factory$iv$iv$iv2;
                Composer constructor-impl2 = Updater.constructor-impl($dirty3);
                int i126 = 0;
                modifier3 = materializeModifier4;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i129 = 0;
                Composer composer16 = constructor-impl2;
                int i133 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap4;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer16;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap4;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = $dirty3;
                int i84 = 0;
                int i127 = i37;
                $changed$iv = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $changed$iv);
                BoxScopeInstance iNSTANCE4 = BoxScopeInstance.INSTANCE;
                i131 |= 6;
                int i135 = 0;
                modifier4 = materializeModifier2;
                Composer materialized$iv$iv2 = composer18;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 1442016074, "C955@42470L9:SearchBar.android.kt#uh7d8r");
                obj3.invoke(materialized$iv$iv2, Integer.valueOf(i51 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                $dirty3.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "InputField");
                int i73 = 1;
                companion = i85;
                ComposerKt.sourceInformationMarkerStart($dirty3, 733328855, maybeCachedBoxMeasurePolicy2);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, i73);
                i10 = 0;
                alignment = i73;
                ComposerKt.sourceInformationMarkerStart($dirty3, -1323940314, materializeModifier);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($dirty3, 0);
                currentCompositionLocalMap2 = $dirty3.getCurrentCompositionLocalMap();
                obj6 = topStart3;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($dirty3, layoutId2);
                i16 = layoutId2;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty3, -692256719, $i$f$Layout);
                if (!applier4 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $dirty3.startReusableNode();
                if ($dirty3.getInserting()) {
                    $dirty3.createNode(function05);
                } else {
                    factory$iv$iv$iv3 = function05;
                    $dirty3.useNode();
                }
                function02 = factory$iv$iv$iv3;
                Composer constructor-impl3 = Updater.constructor-impl($dirty3);
                int i122 = 0;
                map = i93;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i128 = 0;
                Composer composer17 = constructor-impl3;
                int i134 = 0;
                if (!composer17.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer17;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = $dirty3;
                obj3 = 0;
                ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i124 |= 6;
                composer7 = 0;
                i4 = i56;
                modifier2 = materializeModifier3;
                materialized$iv$iv = composer15;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1442132231, "C957@42587L12:SearchBar.android.kt#uh7d8r");
                obj2.invoke(materialized$iv$iv, Integer.valueOf(i57 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                $dirty3.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                $dirty3.startReplaceGroup(-1107184481);
                ComposerKt.sourceInformation($dirty3, "*960@42668L127");
                if (content == null) {
                    $composer2 = $dirty3;
                } else {
                    Modifier layoutId3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Content");
                    iNSTANCE = 390;
                    companion = 0;
                    i17 = i75;
                    ComposerKt.sourceInformationMarkerStart($dirty3, 733328855, maybeCachedBoxMeasurePolicy2);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    i11 = 0;
                    alignment = topStart2;
                    ComposerKt.sourceInformationMarkerStart($dirty3, -1323940314, materializeModifier);
                    currentCompositionLocalMap3 = $dirty3.getCurrentCompositionLocalMap();
                    obj57 = currentCompositeKeyHash3;
                    obj6 = layoutId3;
                    kotlin.jvm.functions.Function0 function04 = constructor2;
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty3, -692256719, $i$f$Layout);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $dirty3.startReusableNode();
                    if ($dirty3.getInserting()) {
                        $dirty3.createNode(function04);
                    } else {
                        factory$iv$iv$iv = function04;
                        $dirty3.useNode();
                    }
                    Composer constructor-impl4 = Updater.constructor-impl($dirty3);
                    int i106 = 0;
                    function02 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, true), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i119 = 0;
                    Composer composer14 = constructor-impl4;
                    int i125 = 0;
                    if (!composer14.getInserting()) {
                        $composer2 = $dirty3;
                        map = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(obj57))) {
                            composer14.updateRememberedValue(Integer.valueOf(obj57));
                            constructor-impl4.apply(Integer.valueOf(obj57), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer14;
                        }
                    } else {
                        $composer2 = $dirty3;
                        map = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier($dirty3, layoutId3), ComposeUiNode.Companion.getSetModifier());
                    $dirty3 = $composer2;
                    $composer$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty3, -2146769399, $changed$iv);
                    i90 |= 6;
                    composer6 = $dirty3;
                    i8 = 0;
                    boxScopeInstance = iNSTANCE2;
                    i23 = i41;
                    ComposerKt.sourceInformationMarkerStart($dirty3, 1302856683, "C961@42768L9:SearchBar.android.kt#uh7d8r");
                    content.invoke($dirty3, 0);
                    ComposerKt.sourceInformationMarkerEnd($dirty3);
                    ComposerKt.sourceInformationMarkerEnd($dirty3);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Unit iNSTANCE3 = Unit.INSTANCE;
                    $changed$iv = Unit.INSTANCE;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i20 = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SearchBar_androidKt.SearchBarLayout.4(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, modifier, windowInsets, obj2, surface, content, i95);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$SearchBarLayout(Animatable animationProgress, MutableFloatState finalBackProgress, MutableState firstBackEvent, MutableState currentBackEvent, Modifier modifier, WindowInsets windowInsets, Function2 inputField, Function2 surface, Function2 content, Composer $composer, int $changed) {
        SearchBar_androidKt.SearchBarLayout(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, modifier, windowInsets, inputField, surface, content, $composer, $changed);
    }

    public static final float access$calculatePredictiveBackMultiplier(BackEventCompat currentBackEvent, float progress, float finalBackProgress) {
        return SearchBar_androidKt.calculatePredictiveBackMultiplier(currentBackEvent, progress, finalBackProgress);
    }

    public static final int access$calculatePredictiveBackOffsetX-rOvwMX4(long constraints, int minMargin, BackEventCompat currentBackEvent, LayoutDirection layoutDirection, float progress, float predictiveBackMultiplier) {
        return SearchBar_androidKt.calculatePredictiveBackOffsetX-rOvwMX4(constraints, minMargin, currentBackEvent, layoutDirection, progress, predictiveBackMultiplier);
    }

    public static final int access$calculatePredictiveBackOffsetY-dzo92Q0(long constraints, int minMargin, BackEventCompat currentBackEvent, BackEventCompat firstBackEvent, int height, int maxOffsetY, float predictiveBackMultiplier) {
        return SearchBar_androidKt.calculatePredictiveBackOffsetY-dzo92Q0(constraints, minMargin, currentBackEvent, firstBackEvent, height, maxOffsetY, predictiveBackMultiplier);
    }

    public static final FiniteAnimationSpec access$getAnimationEnterFloatSpec$p() {
        return SearchBar_androidKt.AnimationEnterFloatSpec;
    }

    public static final FiniteAnimationSpec access$getAnimationExitFloatSpec$p() {
        return SearchBar_androidKt.AnimationExitFloatSpec;
    }

    public static final FiniteAnimationSpec access$getAnimationPredictiveBackExitFloatSpec$p() {
        return SearchBar_androidKt.AnimationPredictiveBackExitFloatSpec;
    }

    public static final EnterTransition access$getDockedEnterTransition$p() {
        return SearchBar_androidKt.DockedEnterTransition;
    }

    public static final ExitTransition access$getDockedExitTransition$p() {
        return SearchBar_androidKt.DockedExitTransition;
    }

    public static final float access$getSearchBarCornerRadius$p() {
        return SearchBar_androidKt.SearchBarCornerRadius;
    }

    public static final float access$getSearchBarIconOffsetX$p() {
        return SearchBar_androidKt.SearchBarIconOffsetX;
    }

    public static final float access$getSearchBarMaxWidth$p() {
        return SearchBar_androidKt.SearchBarMaxWidth;
    }

    public static final float access$getSearchBarPredictiveBackMaxOffsetY$p() {
        return SearchBar_androidKt.SearchBarPredictiveBackMaxOffsetY;
    }

    public static final float access$getSearchBarPredictiveBackMinMargin$p() {
        return SearchBar_androidKt.SearchBarPredictiveBackMinMargin;
    }

    public static final androidx.compose.material3.TextFieldColors access$getUnspecifiedTextFieldColors$p() {
        return SearchBar_androidKt.UnspecifiedTextFieldColors;
    }

    private static final float calculatePredictiveBackMultiplier(BackEventCompat currentBackEvent, float progress, float finalBackProgress) {
        int i;
        boolean naN;
        if (currentBackEvent == null) {
        } else {
            if (Float.isNaN(finalBackProgress)) {
                i = 1065353216;
            } else {
                if (Float.compare(finalBackProgress, i) <= 0) {
                } else {
                    i = progress / finalBackProgress;
                }
            }
        }
        return i;
    }

    private static final int calculatePredictiveBackOffsetX-rOvwMX4(long constraints, int minMargin, BackEventCompat currentBackEvent, LayoutDirection layoutDirection, float progress, float predictiveBackMultiplier) {
        int i4;
        int i2;
        int i3;
        int i;
        int i5 = 0;
        if (layoutDirection != null) {
            i = 1;
            i2 = Float.compare(obj12, i6) == 0 ? i : i5;
            if (i2 != 0) {
            } else {
                i4 = layoutDirection.getSwipeEdge() == 0 ? i : i3;
                if (progress == LayoutDirection.Ltr) {
                    i3 = i;
                }
            }
            return MathKt.roundToInt(i13 *= f5);
        }
        return i5;
    }

    private static final int calculatePredictiveBackOffsetY-dzo92Q0(long constraints, int minMargin, BackEventCompat currentBackEvent, BackEventCompat firstBackEvent, int height, int maxOffsetY, float predictiveBackMultiplier) {
        int i;
        int i2 = 0;
        if (height != 0 && firstBackEvent != null) {
            if (firstBackEvent != null) {
                i = Float.compare(obj14, i3) == 0 ? 1 : i2;
                if (i != 0) {
                }
                touchY -= touchY2;
                return MathKt.roundToInt(i11 *= signum);
            }
        }
        return i2;
    }

    public static final float getDockedExpandedTableMinHeight() {
        return SearchBar_androidKt.DockedExpandedTableMinHeight;
    }

    private static void getSearchBarCornerRadius$annotations() {
    }

    public static final float getSearchBarMinWidth() {
        return SearchBar_androidKt.SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBar_androidKt.SearchBarVerticalPadding;
    }
}
