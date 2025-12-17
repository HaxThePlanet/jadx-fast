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
        int i13;
        int traceInProgress2;
        Object shape4;
        int defaultsInvalid;
        Object shape3;
        int i;
        int i5;
        Object obj3;
        int $composer2;
        boolean traceInProgress;
        Object $composer3;
        int $dirty3;
        int tonalElevation3;
        float tonalElevation2;
        Object $dirty4;
        int i8;
        int i2;
        int i6;
        int $dirty;
        Object obj2;
        float f;
        float f4;
        Object obj;
        float modifier2;
        int i9;
        Object colors2;
        Object colors-dgg9oW8;
        int changed;
        Object obj4;
        Composer $composer4;
        Composer shape2;
        int changed2;
        float containerColor-0d7_KjU;
        int i11;
        int anon;
        int i14;
        int $dirty2;
        int i7;
        float f2;
        float f3;
        int i3;
        int i15;
        Composer composer;
        int i16;
        int i4;
        int i10;
        Object obj30;
        obj3 = inputField;
        final boolean z = expanded;
        final Object obj5 = onExpandedChange;
        final Object obj7 = content;
        final int i43 = $changed;
        final int i44 = i12;
        $composer2 = $composer.startRestartGroup(1209217899);
        ComposerKt.sourceInformation($composer2, "C(DockedSearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp)287@13410L11,288@13471L8,296@13752L38,300@13946L831,293@13658L1119,325@14815L27,325@14783L59:SearchBar.android.kt#uh7d8r");
        $dirty3 = $changed;
        if (i44 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i43 & 6 == 0) {
                i8 = $composer2.changedInstance(obj3) ? 4 : 2;
                $dirty3 |= i8;
            }
        }
        if (i44 & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (i43 & 48 == 0) {
                i2 = $composer2.changed(z) ? 32 : 16;
                $dirty3 |= i2;
            }
        }
        if (i44 & 4 != 0) {
            $dirty3 |= 384;
        } else {
            if (i43 & 384 == 0) {
                i6 = $composer2.changedInstance(obj5) ? 256 : 128;
                $dirty3 |= i6;
            }
        }
        $dirty = i44 & 8;
        if ($dirty != 0) {
            $dirty3 |= 3072;
            obj = modifier;
        } else {
            if (i43 & 3072 == 0) {
                i9 = $composer2.changed(modifier) ? 2048 : 1024;
                $dirty3 |= i9;
            } else {
                obj = modifier;
            }
        }
        if (i43 & 24576 == 0) {
            if (i44 & 16 == 0) {
                changed = $composer2.changed(shape) ? 16384 : 8192;
            } else {
                colors2 = shape;
            }
            $dirty3 |= changed;
        } else {
            colors2 = shape;
        }
        if (i48 &= i43 == 0) {
            if (i44 & 32 == 0) {
                changed2 = $composer2.changed(colors) ? 131072 : 65536;
            } else {
                obj4 = colors;
            }
            $dirty3 |= changed2;
        } else {
            obj4 = colors;
        }
        i3 = i44 & 64;
        int i52 = 1572864;
        if (i3 != 0) {
            $dirty3 |= i52;
            containerColor-0d7_KjU = tonalElevation;
        } else {
            if (i52 &= i43 == 0) {
                i11 = $composer2.changed(tonalElevation) ? 1048576 : 524288;
                $dirty3 |= i11;
            } else {
                containerColor-0d7_KjU = tonalElevation;
            }
        }
        anon = i44 & 128;
        i15 = 12582912;
        if (anon != 0) {
            $dirty3 |= i15;
            f = shadowElevation;
        } else {
            if (i43 & i15 == 0) {
                i14 = $composer2.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty3 |= i14;
            } else {
                f = shadowElevation;
            }
        }
        int i54 = 100663296;
        if (i44 & 256 != 0) {
            $dirty3 |= i54;
        } else {
            if (i43 & i54 == 0) {
                i13 = $composer2.changedInstance(obj7) ? 67108864 : 33554432;
                $dirty3 |= i13;
            }
        }
        $dirty2 = $dirty3;
        if (i18 &= $dirty3 == 38347922) {
            if (!$composer2.getSkipping()) {
                $composer2.startDefaults();
                int i34 = -458753;
                i7 = -57345;
                if (i43 & 1 != 0) {
                    if ($composer2.getDefaultsInvalid()) {
                        if ($dirty != 0) {
                            obj = defaultsInvalid;
                        }
                        if (i44 & 16 != 0) {
                            shape3 = SearchBarDefaults.INSTANCE.getDockedShape($composer2, 6);
                            $dirty = $dirty2 & i7;
                        } else {
                            shape3 = colors2;
                            $dirty = $dirty2;
                        }
                        if (i44 & 32 != 0) {
                            i7 = $composer2;
                            $composer2 = i10;
                            colors-dgg9oW8 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, containerColor-0d7_KjU, 0, $dirty2, i7);
                            $composer4 = i7;
                            $dirty &= i34;
                        } else {
                            $composer4 = $composer2;
                            $composer2 = anon;
                            colors-dgg9oW8 = colors;
                        }
                        if (i3 != 0) {
                            tonalElevation2 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                        } else {
                            tonalElevation2 = tonalElevation;
                        }
                        if ($composer2 != 0) {
                            colors2 = shape3;
                            shape4 = searchBarColors2;
                            f3 = $composer2;
                            f2 = tonalElevation2;
                            tonalElevation3 = $dirty;
                        } else {
                            colors2 = shape3;
                            shape4 = searchBarColors;
                            f2 = tonalElevation2;
                            tonalElevation3 = $dirty;
                            f3 = f;
                        }
                    } else {
                        $composer2.skipToGroupEnd();
                        if (i44 & 16 != 0) {
                            $dirty2 = i;
                        }
                        if (i44 & 32 != 0) {
                            tonalElevation3 = i25;
                            f3 = f;
                            shape4 = obj4;
                            f2 = containerColor-0d7_KjU;
                            $composer4 = $composer2;
                        } else {
                            f3 = f;
                            shape4 = obj4;
                            f2 = containerColor-0d7_KjU;
                            tonalElevation3 = $dirty2;
                            $composer4 = $composer2;
                        }
                    }
                } else {
                }
                $composer4.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1209217899, tonalElevation3, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:292)");
                }
                SearchBar_androidKt.DockedSearchBar.1 anon2 = new SearchBar_androidKt.DockedSearchBar.1(obj3, z, shape4, obj7);
                composer = $composer4;
                Object $composer5 = colors2;
                SurfaceKt.Surface-T9BRK9s(SizeKt.width-3ABfNKs(ZIndexModifierKt.zIndex(obj, 1065353216), SearchBar_androidKt.SearchBarMinWidth), $composer5, shape4.getContainerColor-0d7_KjU(), anon, ColorSchemeKt.contentColorFor-ek8zF_U(shape4.getContainerColor-0d7_KjU(), f, $composer4), i7, f2, f3, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(878471280, true, anon2, $composer4, 54), composer);
                shape2 = composer;
                ComposerKt.sourceInformationMarkerStart(shape2, -994322031, "CC(remember):SearchBar.android.kt#9igjgp");
                if (tonalElevation3 & 896 == 256) {
                } else {
                    i5 = 0;
                }
                Composer composer2 = shape2;
                int i33 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i41 = 0;
                if (i5 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        containerColor-0d7_KjU = 0;
                        anon = new SearchBar_androidKt.DockedSearchBar.2.1(obj5);
                        composer2.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(shape2);
                BackHandlerKt.BackHandler(z, (Function0)anon, shape2, i21 &= 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj30;
                $dirty2 = tonalElevation3;
                $composer3 = obj;
                f4 = f2;
                modifier2 = f3;
                $dirty4 = colors2;
            } else {
                $composer2.skipToGroupEnd();
                obj2 = obj4;
                shape2 = $composer2;
                $composer3 = obj;
                modifier2 = f;
                f4 = containerColor-0d7_KjU;
                $dirty4 = colors2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = shape2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SearchBar_androidKt.DockedSearchBar.3(inputField, z, obj5, $composer3, $dirty4, obj2, f4, modifier2, obj7, i43, i44);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(...))
    public static final void DockedSearchBar-eWTbjVg(String query, Function1<? super String, Unit> onQueryChange, Function1<? super String, Unit> onSearch, boolean active, Function1<? super Boolean, Unit> onActiveChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj8;
        Object obj4;
        Object obj11;
        Object obj2;
        float f4;
        float f5;
        Object obj3;
        int modifier3;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier4;
        boolean traceInProgress;
        int i19;
        int leadingIcon2;
        boolean traceInProgress2;
        int $dirty;
        int $dirty1;
        Object $dirty13;
        int i9;
        int i11;
        Object obj6;
        Object obj7;
        int shadowElevation3;
        boolean z2;
        boolean modifier2;
        Object obj14;
        Object obj;
        Object shape2;
        Object obj9;
        Object obj12;
        int i4;
        Composer $dirty2;
        int dockedShape;
        boolean z;
        int tonalElevation2;
        float f;
        Shape shadowElevation2;
        float f3;
        int i28;
        Object obj13;
        androidx.compose.material3.SearchBarColors searchBarColors;
        float $composer3;
        int $composer2;
        Object obj5;
        float f2;
        Object obj10;
        int colors2;
        Object placeholder2;
        int i16;
        int i25;
        int i26;
        int changed4;
        Object i3;
        int i;
        Function1 i29;
        int changed;
        int $dirty12;
        int i21;
        boolean i6;
        int i23;
        int i22;
        int i7;
        int enabled2;
        boolean $dirty15;
        int $dirty14;
        int i17;
        int i12;
        int i27;
        int i24;
        int changed2;
        int i18;
        Composer composer2;
        int i10;
        int i13;
        int i14;
        int i5;
        int i15;
        int i2;
        int i8;
        int changed3;
        ScopeUpdateScope scopeUpdateScope;
        Composer composer;
        int obj51;
        int i30 = $changed;
        int i40 = $changed1;
        i19 = i20;
        Composer restartGroup = $composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation(restartGroup, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)818@37222L11,819@37283L8,826@37565L591,825@37527L894:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i19 & 1 != 0) {
            $dirty |= 6;
            obj13 = query;
        } else {
            if (i30 & 6 == 0) {
                i9 = restartGroup.changed(query) ? 4 : 2;
                $dirty |= i9;
            } else {
                obj13 = query;
            }
        }
        if (i19 & 2 != 0) {
            $dirty |= 48;
            obj5 = onQueryChange;
        } else {
            if (i30 & 48 == 0) {
                i11 = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty |= i11;
            } else {
                obj5 = onQueryChange;
            }
        }
        if (i19 & 4 != 0) {
            $dirty |= 384;
            obj6 = onSearch;
        } else {
            if (i30 & 384 == 0) {
                i16 = restartGroup.changedInstance(onSearch) ? 256 : 128;
                $dirty |= i16;
            } else {
                obj6 = onSearch;
            }
        }
        changed = 1024;
        if (i19 & 8 != 0) {
            $dirty |= 3072;
            z2 = active;
        } else {
            if (i30 & 3072 == 0) {
                i25 = restartGroup.changed(active) ? i : changed;
                $dirty |= i25;
            } else {
                z2 = active;
            }
        }
        i22 = 8192;
        if (i19 & 16 != 0) {
            $dirty |= 24576;
            obj = onActiveChange;
        } else {
            if (i30 & 24576 == 0) {
                i7 = restartGroup.changedInstance(onActiveChange) ? i21 : i22;
                $dirty |= i7;
            } else {
                obj = onActiveChange;
            }
        }
        int i88 = i19 & 32;
        i27 = 65536;
        i24 = 196608;
        if (i88 != 0) {
            $dirty |= i24;
            obj12 = modifier;
        } else {
            if (i30 & i24 == 0) {
                i18 = restartGroup.changed(modifier) ? i17 : i27;
                $dirty |= i18;
            } else {
                obj12 = modifier;
            }
        }
        int i89 = i19 & 64;
        i10 = 1572864;
        if (i89 != 0) {
            $dirty |= i10;
            z = enabled;
        } else {
            if (i30 & i10 == 0) {
                i13 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty |= i13;
            } else {
                z = enabled;
            }
        }
        i28 = i19 & 128;
        i14 = 12582912;
        if (i28 != 0) {
            $dirty |= i14;
            obj10 = placeholder;
        } else {
            if (i30 & i14 == 0) {
                i5 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                obj10 = placeholder;
            }
        }
        leadingIcon2 = i19 & 256;
        i15 = 100663296;
        if (leadingIcon2 != 0) {
            $dirty |= i15;
            obj8 = leadingIcon;
        } else {
            if (i30 & i15 == 0) {
                i15 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i15;
            } else {
                obj8 = leadingIcon;
            }
        }
        int i31 = i19 & 512;
        int i90 = 805306368;
        if (i31 != 0) {
            $dirty |= i90;
            i2 = i31;
            obj4 = trailingIcon;
        } else {
            if ($changed & i90 == 0) {
                i2 = i31;
                i8 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i8;
            } else {
                i2 = i31;
                obj4 = trailingIcon;
            }
        }
        if (i40 & 6 == 0) {
            if (i19 & 1024 == 0) {
                i26 = restartGroup.changed(shape) ? 4 : 2;
            } else {
                obj11 = shape;
            }
            $dirty1 |= i26;
        } else {
            obj11 = shape;
        }
        if (i40 & 48 == 0) {
            if (i19 & 2048 == 0) {
                changed2 = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj2 = colors;
            }
            $dirty1 |= changed2;
        } else {
            obj2 = colors;
        }
        int i76 = i19 & 4096;
        if (i76 != 0) {
            $dirty1 |= 384;
            f4 = tonalElevation;
        } else {
            if (i40 & 384 == 0) {
                i13 = restartGroup.changed(tonalElevation) ? 256 : 128;
                $dirty1 |= i13;
            } else {
                f4 = tonalElevation;
            }
        }
        int i77 = i19 & 8192;
        if (i77 != 0) {
            $dirty1 |= 3072;
            f5 = shadowElevation;
        } else {
            if (i40 & 3072 == 0) {
                if (restartGroup.changed(shadowElevation)) {
                } else {
                    i = changed;
                }
                $dirty1 |= i;
            } else {
                f5 = shadowElevation;
            }
        }
        shadowElevation3 = i19 & 16384;
        if (shadowElevation3 != 0) {
            $dirty1 |= 24576;
            obj3 = interactionSource;
        } else {
            if (i40 & 24576 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i21 = i22;
                }
                $dirty1 |= i21;
            } else {
                obj3 = interactionSource;
            }
        }
        if (i19 & i85 != 0) {
            $dirty12 = $dirty16;
            $dirty13 = content;
        } else {
            if (i40 & i24 == 0) {
                if (restartGroup.changedInstance(content)) {
                } else {
                    i17 = i27;
                }
                $dirty12 = obj51 | i17;
            } else {
                $dirty13 = content;
                $dirty12 = obj51;
            }
        }
        if ($dirty & i6 == 306783378 && $dirty12 & i35 == 74898) {
            if ($dirty12 & i35 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i41 = 6;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i88 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = obj12;
                            }
                            i6 = i89 != 0 ? obj12 : z;
                            if (i28 != 0) {
                                obj10 = obj12;
                            }
                            leadingIcon2 = leadingIcon2 != 0 ? 0 : leadingIcon;
                            i22 = i2 != 0 ? obj12 : trailingIcon;
                            if (i19 & 1024 != 0) {
                                $dirty14 = $dirty17;
                                $dirty12 = dockedShape;
                            } else {
                                $dirty14 = $dirty12;
                                $dirty12 = shape;
                            }
                            if (i19 & 2048 != 0) {
                                i12 = shadowElevation3;
                                $composer2 = i83;
                                $dirty = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, shadowElevation3, 0, obj, restartGroup);
                                $dirty14 &= -113;
                            } else {
                                i12 = shadowElevation3;
                                $dirty2 = restartGroup;
                                $composer2 = $dirty;
                                $dirty = colors;
                            }
                            if (i76 != 0) {
                                $dirty13 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                $dirty13 = tonalElevation;
                            }
                            if (i77 != 0) {
                                shadowElevation3 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation3 = shadowElevation;
                            }
                            if (i12 != 0) {
                                i27 = leadingIcon2;
                                f = $dirty13;
                                f3 = shadowElevation3;
                                changed2 = i79;
                                i17 = obj10;
                                obj9 = $dirty12;
                                i24 = i22;
                                obj14 = modifier4;
                                placeholder2 = $dirty;
                                modifier3 = $dirty14;
                                $dirty15 = i6;
                            } else {
                                changed2 = interactionSource;
                                obj14 = modifier4;
                                i27 = leadingIcon2;
                                f = $dirty13;
                                f3 = shadowElevation3;
                                i17 = obj10;
                                obj9 = $dirty12;
                                i24 = i22;
                                modifier3 = $dirty14;
                                placeholder2 = $dirty;
                                $dirty15 = i6;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i19 & 1024 != 0) {
                                $dirty12 &= -15;
                            }
                            if (i19 & 2048 != 0) {
                                modifier3 = $dirty12 & -113;
                                i27 = leadingIcon;
                                i24 = trailingIcon;
                                obj9 = shape;
                                f3 = shadowElevation;
                                changed2 = interactionSource;
                                obj14 = obj12;
                                $dirty15 = z;
                                $dirty2 = restartGroup;
                                i17 = obj10;
                                placeholder2 = colors;
                                f = tonalElevation;
                                $composer2 = $dirty;
                            } else {
                                i27 = leadingIcon;
                                i24 = trailingIcon;
                                obj9 = shape;
                                f3 = shadowElevation;
                                changed2 = interactionSource;
                                obj14 = obj12;
                                $dirty15 = z;
                                $dirty2 = restartGroup;
                                i17 = obj10;
                                modifier3 = $dirty12;
                                placeholder2 = colors;
                                f = tonalElevation;
                                $composer2 = $dirty;
                            }
                        }
                    } else {
                    }
                    $dirty2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1299054533, $composer2, modifier3, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:825)");
                    }
                    SearchBar_androidKt.DockedSearchBar.4 anon = new SearchBar_androidKt.DockedSearchBar.4(placeholder2, obj13, onQueryChange, onSearch, active, onActiveChange, $dirty15, i17, i27, i24, changed2);
                    Composer $dirty4 = $dirty2;
                    androidx.compose.material3.SearchBarColors $composer4 = placeholder2;
                    i23 = i49;
                    SearchBar_androidKt.DockedSearchBar-EQC0FA8((Function2)ComposableLambdaKt.rememberComposableLambda(-303118761, true, anon, $dirty2, 54), active, onActiveChange, obj14, obj9, $composer4, f, f3, content, $dirty4, i48 | leadingIcon2, 0);
                    composer2 = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj7 = obj14;
                    $composer3 = f;
                    f2 = f3;
                    searchBarColors = searchBarColors2;
                    modifier2 = $dirty15;
                    i4 = i27;
                    tonalElevation2 = i24;
                    colors2 = changed2;
                    enabled2 = modifier3;
                    shadowElevation2 = obj9;
                    shape2 = i17;
                } else {
                    restartGroup.skipToGroupEnd();
                    shadowElevation2 = shape;
                    searchBarColors = colors;
                    f2 = shadowElevation;
                    i23 = $dirty;
                    obj7 = obj12;
                    modifier2 = z;
                    composer2 = restartGroup;
                    shape2 = obj10;
                    enabled2 = $dirty12;
                    i4 = leadingIcon;
                    tonalElevation2 = trailingIcon;
                    $composer3 = tonalElevation;
                    colors2 = interactionSource;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.DockedSearchBar.5(query, onQueryChange, onSearch, active, onActiveChange, obj7, modifier2, shape2, i4, tonalElevation2, shadowElevation2, searchBarColors, $composer3, f2, colors2, content, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(...))
    public static final void SearchBar-WuY5d9Q(String query, Function1<? super String, Unit> onQueryChange, Function1<? super String, Unit> onSearch, boolean active, Function1<? super Boolean, Unit> onActiveChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj8;
        Object obj11;
        Object obj4;
        Object obj13;
        float f;
        float f2;
        Object obj3;
        boolean modifier2;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier3;
        int traceInProgress2;
        int i16;
        int leadingIcon2;
        boolean traceInProgress;
        int $dirty;
        int $dirty14;
        Object $dirty1;
        Object tonalElevation2;
        int i;
        int i11;
        Object obj9;
        Object obj6;
        float shadowElevation2;
        boolean z3;
        boolean modifier4;
        Object windowInsets4;
        Object windowInsets2;
        Object obj5;
        Object shape3;
        Shape shape2;
        Object obj2;
        int i9;
        int inputFieldShape;
        Composer $dirty2;
        boolean z2;
        int tonalElevation3;
        float f5;
        Object shadowElevation3;
        int i10;
        float f3;
        Object obj;
        Object windowInsets3;
        WindowInsets windowInsets5;
        Object obj10;
        float f4;
        float $composer3;
        int $composer2;
        Object obj12;
        Object obj7;
        int i28;
        int i23;
        int i12;
        int changed;
        int colors2;
        androidx.compose.material3.SearchBarColors searchBarColors;
        int changed3;
        int i15;
        int $dirty12;
        int i6;
        int i29;
        int i19;
        int i18;
        int i17;
        int i2;
        int $dirty13;
        int i4;
        int enabled2;
        int i7;
        boolean z;
        int i3;
        int i27;
        int changed2;
        int i20;
        int i24;
        Composer composer;
        int i8;
        int i14;
        int i13;
        int i25;
        int i5;
        int i22;
        int i26;
        int changed4;
        ScopeUpdateScope scopeUpdateScope;
        Composer composer2;
        int obj53;
        int i30 = $changed;
        int i43 = $changed1;
        i16 = i21;
        Composer restartGroup = $composer.startRestartGroup(1001512593);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)737@34012L15,738@34077L8,741@34258L12,746@34418L591,745@34386L925:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i16 & 1 != 0) {
            $dirty |= 6;
            obj = query;
        } else {
            if (i30 & 6 == 0) {
                i = restartGroup.changed(query) ? 4 : 2;
                $dirty |= i;
            } else {
                obj = query;
            }
        }
        if (i16 & 2 != 0) {
            $dirty |= 48;
            obj10 = onQueryChange;
        } else {
            if (i30 & 48 == 0) {
                i11 = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty |= i11;
            } else {
                obj10 = onQueryChange;
            }
        }
        if (i16 & 4 != 0) {
            $dirty |= 384;
            obj9 = onSearch;
        } else {
            if (i30 & 384 == 0) {
                i28 = restartGroup.changedInstance(onSearch) ? 256 : 128;
                $dirty |= i28;
            } else {
                obj9 = onSearch;
            }
        }
        int i94 = 1024;
        if (i16 & 8 != 0) {
            $dirty |= 3072;
            z3 = active;
        } else {
            if (i30 & 3072 == 0) {
                i23 = restartGroup.changed(active) ? changed3 : i94;
                $dirty |= i23;
            } else {
                z3 = active;
            }
        }
        i18 = 16384;
        if (i16 & 16 != 0) {
            $dirty |= 24576;
            obj5 = onActiveChange;
        } else {
            if (i30 & 24576 == 0) {
                i17 = restartGroup.changedInstance(onActiveChange) ? i18 : i6;
                $dirty |= i17;
            } else {
                obj5 = onActiveChange;
            }
        }
        $dirty13 = i16 & 32;
        i3 = 65536;
        i27 = 196608;
        if ($dirty13 != 0) {
            $dirty |= i27;
            obj2 = modifier;
        } else {
            if (i30 & i27 == 0) {
                i20 = restartGroup.changed(modifier) ? i4 : i3;
                $dirty |= i20;
            } else {
                obj2 = modifier;
            }
        }
        i24 = i16 & 64;
        int i96 = 1572864;
        if (i24 != 0) {
            $dirty |= i96;
            z2 = enabled;
        } else {
            if (i30 & i96 == 0) {
                i14 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty |= i14;
            } else {
                z2 = enabled;
            }
        }
        i10 = i16 & 128;
        i13 = 12582912;
        if (i10 != 0) {
            $dirty |= i13;
            obj12 = placeholder;
        } else {
            if (i30 & i13 == 0) {
                i25 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i25;
            } else {
                obj12 = placeholder;
            }
        }
        leadingIcon2 = i16 & 256;
        i5 = 100663296;
        if (leadingIcon2 != 0) {
            $dirty |= i5;
            obj8 = leadingIcon;
        } else {
            if (i30 & i5 == 0) {
                i5 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i5;
            } else {
                obj8 = leadingIcon;
            }
        }
        int i31 = i16 & 512;
        int i97 = 805306368;
        if (i31 != 0) {
            $dirty |= i97;
            i22 = i31;
            obj11 = trailingIcon;
        } else {
            if ($changed & i97 == 0) {
                i22 = i31;
                i26 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i26;
            } else {
                i22 = i31;
                obj11 = trailingIcon;
            }
        }
        if (i43 & 6 == 0) {
            if (i16 & 1024 == 0) {
                i12 = restartGroup.changed(shape) ? 4 : 2;
            } else {
                obj4 = shape;
            }
            $dirty14 |= i12;
        } else {
            obj4 = shape;
        }
        if (i43 & 48 == 0) {
            if (i16 & 2048 == 0) {
                i8 = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj13 = colors;
            }
            $dirty14 |= i8;
        } else {
            obj13 = colors;
        }
        int i83 = i16 & 4096;
        if (i83 != 0) {
            $dirty14 |= 384;
            f = tonalElevation;
        } else {
            if (i43 & 384 == 0) {
                i14 = restartGroup.changed(tonalElevation) ? 256 : 128;
                $dirty14 |= i14;
            } else {
                f = tonalElevation;
            }
        }
        shadowElevation2 = i16 & 8192;
        if (shadowElevation2 != 0) {
            $dirty14 |= 3072;
            f2 = shadowElevation;
        } else {
            if (i43 & 3072 == 0) {
                if (restartGroup.changed(shadowElevation)) {
                } else {
                    changed3 = i94;
                }
                $dirty14 |= changed3;
            } else {
                f2 = shadowElevation;
            }
        }
        if (i43 & 24576 == 0) {
            if (i16 & 16384 == 0) {
                if (restartGroup.changed(windowInsets)) {
                    i6 = i18;
                }
            } else {
                obj3 = windowInsets;
            }
            $dirty14 |= i6;
        } else {
            obj3 = windowInsets;
        }
        i15 = i16 & i93;
        if (i15 != 0) {
            $dirty12 = $dirty15;
            $dirty1 = interactionSource;
        } else {
            if (i43 & i27 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i4 = i3;
                }
                $dirty12 = obj53 | i4;
            } else {
                $dirty1 = interactionSource;
                $dirty12 = obj53;
            }
        }
        if (i16 & i3 != 0) {
            $dirty12 |= i96;
            tonalElevation2 = content;
        } else {
            if (i43 & i96 == 0) {
                i29 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty12 |= i29;
            } else {
                tonalElevation2 = content;
            }
        }
        if ($dirty & i19 == 306783378 && $dirty12 & i35 == 599186) {
            if ($dirty12 & i35 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i44 = 6;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if ($dirty13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = obj2;
                            }
                            i19 = i24 != 0 ? obj2 : z2;
                            if (i10 != 0) {
                                obj12 = obj2;
                            }
                            leadingIcon2 = leadingIcon2 != 0 ? 0 : leadingIcon;
                            i18 = i22 != 0 ? obj2 : trailingIcon;
                            if (i16 & 1024 != 0) {
                                $dirty13 = $dirty16;
                                $dirty12 = inputFieldShape;
                            } else {
                                $dirty13 = $dirty12;
                                $dirty12 = shape;
                            }
                            if (i16 & 2048 != 0) {
                                i7 = shadowElevation2;
                                $composer2 = i90;
                                $dirty = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, shadowElevation2, 0, obj5, restartGroup);
                                $dirty13 &= -113;
                            } else {
                                i7 = shadowElevation2;
                                $dirty2 = restartGroup;
                                $composer2 = $dirty;
                                $dirty = colors;
                            }
                            if (i83 != 0) {
                                tonalElevation2 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = tonalElevation;
                            }
                            if (i7 != 0) {
                                shadowElevation2 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = shadowElevation;
                            }
                            if (i16 & 16384 != 0) {
                                windowInsets4 = SearchBarDefaults.INSTANCE.getWindowInsets($dirty2, i44);
                                $dirty13 &= obj5;
                            } else {
                                windowInsets4 = windowInsets;
                            }
                            if (i15 != 0) {
                                i27 = leadingIcon2;
                                searchBarColors = $dirty;
                                f5 = tonalElevation2;
                                f3 = shadowElevation2;
                                windowInsets5 = windowInsets4;
                                i24 = i88;
                                i3 = obj12;
                                shape2 = $dirty12;
                                z = i19;
                                changed2 = i18;
                                windowInsets2 = modifier3;
                                modifier2 = $dirty13;
                            } else {
                                i24 = interactionSource;
                                i27 = leadingIcon2;
                                searchBarColors = $dirty;
                                f5 = tonalElevation2;
                                f3 = shadowElevation2;
                                windowInsets5 = windowInsets4;
                                i3 = obj12;
                                shape2 = $dirty12;
                                z = i19;
                                changed2 = i18;
                                windowInsets2 = modifier3;
                                modifier2 = $dirty13;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i16 & 1024 != 0) {
                                $dirty12 &= -15;
                            }
                            if (i16 & 2048 != 0) {
                                $dirty12 &= -113;
                            }
                            if (i16 & 16384 != 0) {
                                modifier2 = $dirty12 & i39;
                                i27 = leadingIcon;
                                changed2 = trailingIcon;
                                shape2 = shape;
                                searchBarColors = colors;
                                f3 = shadowElevation;
                                windowInsets5 = windowInsets;
                                i24 = interactionSource;
                                windowInsets2 = obj2;
                                z = z2;
                                $dirty2 = restartGroup;
                                i3 = obj12;
                                f5 = tonalElevation;
                                $composer2 = $dirty;
                            } else {
                                i27 = leadingIcon;
                                changed2 = trailingIcon;
                                shape2 = shape;
                                searchBarColors = colors;
                                f3 = shadowElevation;
                                windowInsets5 = windowInsets;
                                i24 = interactionSource;
                                windowInsets2 = obj2;
                                z = z2;
                                $dirty2 = restartGroup;
                                i3 = obj12;
                                modifier2 = $dirty12;
                                f5 = tonalElevation;
                                $composer2 = $dirty;
                            }
                        }
                    } else {
                    }
                    $dirty2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1001512593, $composer2, modifier2, "androidx.compose.material3.SearchBar (SearchBar.android.kt:745)");
                    }
                    SearchBar_androidKt.SearchBar.4 anon = new SearchBar_androidKt.SearchBar.4(searchBarColors, query, obj10, onSearch, active, onActiveChange, z, i3, i27, changed2, i24);
                    Composer $dirty4 = $dirty2;
                    androidx.compose.material3.SearchBarColors $composer4 = searchBarColors;
                    i2 = i53;
                    SearchBar_androidKt.SearchBar-Y92LkZI((Function2)ComposableLambdaKt.rememberComposableLambda(-1158111311, true, anon, $dirty2, 54), active, onActiveChange, windowInsets2, shape2, $composer4, f5, f3, windowInsets5, content, $dirty4, i52 | leadingIcon2, 0);
                    composer = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj6 = windowInsets2;
                    f4 = f5;
                    $composer3 = f3;
                    obj7 = windowInsets5;
                    windowInsets3 = searchBarColors2;
                    modifier4 = z;
                    i9 = i27;
                    tonalElevation3 = changed2;
                    colors2 = i24;
                    enabled2 = modifier2;
                    shadowElevation3 = shape2;
                    shape3 = i3;
                } else {
                    restartGroup.skipToGroupEnd();
                    shadowElevation3 = shape;
                    windowInsets3 = colors;
                    f4 = tonalElevation;
                    colors2 = interactionSource;
                    i2 = $dirty;
                    obj6 = obj2;
                    modifier4 = z2;
                    composer = restartGroup;
                    shape3 = obj12;
                    enabled2 = $dirty12;
                    i9 = leadingIcon;
                    tonalElevation3 = trailingIcon;
                    $composer3 = shadowElevation;
                    obj7 = windowInsets;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.SearchBar.5(query, onQueryChange, onSearch, active, onActiveChange, obj6, modifier4, shape3, i9, tonalElevation3, shadowElevation3, windowInsets3, f4, $composer3, obj7, colors2, content, $changed, $changed1, i16);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void SearchBar-Y92LkZI(Function2<? super Composer, ? super Integer, Unit> inputField, boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj3;
        boolean traceInProgress2;
        int modifier4;
        Object mutableFloatStateOf;
        Object obj15;
        Object mutableStateOf$default2;
        Object it$iv2;
        Object obj;
        int i10;
        int defaultsInvalid;
        Object modifier2;
        int $dirty3;
        Object $dirty2;
        int windowInsets3;
        boolean traceInProgress;
        boolean $this$cache$iv;
        int invalid$iv;
        int i;
        int i22;
        int i4;
        Object str;
        Object tonalElevation3;
        Object tonalElevation4;
        Object $this$cache$iv2;
        Object i12;
        int i11;
        int i18;
        Object currentBackEvent;
        int shadowElevation2;
        int $i$f$cache;
        int inputFieldShape;
        Object obj2;
        Object obj4;
        int it$iv;
        int i20;
        int i21;
        Object obj6;
        float $dirty5;
        Object obj13;
        int modifier3;
        float $composer2;
        int changed;
        Object obj9;
        Object obj14;
        Object obj11;
        Composer shape2;
        int changed2;
        float f2;
        Object obj16;
        String colors3;
        androidx.compose.material3.SearchBar_androidKt.SearchBar.2.1 i19;
        int i7;
        Object empty2;
        int empty;
        float tonalElevation2;
        float f;
        Object obj8;
        Object shadowElevation3;
        float f3;
        Object i14;
        Composer.Companion companion;
        Object mutableStateOf$default;
        androidx.compose.material3.SearchBar_androidKt.SearchBar.2.1 anon;
        int i15;
        int i9;
        Object mutatorMutex;
        int i8;
        Object i6;
        Object $dirty;
        int changed3;
        int i2;
        int colors2;
        Function1 i3;
        Object tonalElevation5;
        int $dirty4;
        Object firstBackEvent;
        float f4;
        Object i5;
        Object obj7;
        Function3 windowInsets2;
        Object obj10;
        Composer composer;
        Object obj5;
        int i23;
        int i16;
        int i17;
        Object obj12;
        Object obj33;
        Object obj34;
        Object obj35;
        int obj36;
        $this$cache$iv = expanded;
        i19 = $changed;
        final int i107 = i13;
        Composer restartGroup = $composer.startRestartGroup(1444649673);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp,9)171@8255L15,172@8320L8,175@8501L12,178@8596L64,179@8689L43,180@8758L51,181@8837L51,183@8919L638,183@8894L663,199@9582L27,200@9656L1062,200@9614L1104,226@10724L458:SearchBar.android.kt#uh7d8r");
        $dirty3 = $changed;
        if (i107 & 1 != 0) {
            $dirty3 |= 6;
            obj8 = inputField;
        } else {
            if (i19 & 6 == 0) {
                i22 = restartGroup.changedInstance(inputField) ? 4 : 2;
                $dirty3 |= i22;
            } else {
                obj8 = inputField;
            }
        }
        if (i107 & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (i19 & 48 == 0) {
                i4 = restartGroup.changed($this$cache$iv) ? 32 : 16;
                $dirty3 |= i4;
            }
        }
        if (i107 & 4 != 0) {
            $dirty3 |= 384;
            str = onExpandedChange;
        } else {
            if (i19 & 384 == 0) {
                i18 = restartGroup.changedInstance(onExpandedChange) ? 256 : 128;
                $dirty3 |= i18;
            } else {
                str = onExpandedChange;
            }
        }
        shadowElevation2 = i107 & 8;
        if (shadowElevation2 != 0) {
            $dirty3 |= 3072;
            obj2 = modifier;
        } else {
            if (i19 & 3072 == 0) {
                i21 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty3 |= i21;
            } else {
                obj2 = modifier;
            }
        }
        if (i19 & 24576 == 0) {
            if (i107 & 16 == 0) {
                changed = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                obj6 = shape;
            }
            $dirty3 |= changed;
        } else {
            obj6 = shape;
        }
        if (i97 &= i19 == 0) {
            if (i107 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj9 = colors;
            }
            $dirty3 |= changed2;
        } else {
            obj9 = colors;
        }
        i14 = i107 & 64;
        int i100 = 1572864;
        if (i14 != 0) {
            $dirty3 |= i100;
            f2 = tonalElevation;
        } else {
            if (i100 &= i19 == 0) {
                i15 = restartGroup.changed(tonalElevation) ? 1048576 : 524288;
                $dirty3 |= i15;
            } else {
                f2 = tonalElevation;
            }
        }
        shadowElevation3 = i107 & 128;
        i9 = 12582912;
        if (shadowElevation3 != 0) {
            $dirty3 |= i9;
            tonalElevation2 = shadowElevation;
        } else {
            if (i19 & i9 == 0) {
                i8 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty3 |= i8;
            } else {
                tonalElevation2 = shadowElevation;
            }
        }
        if (i19 & i110 == 0) {
            if (i107 & 256 == 0) {
                changed3 = restartGroup.changed(windowInsets) ? 67108864 : 33554432;
            } else {
                tonalElevation3 = windowInsets;
            }
            $dirty3 |= changed3;
        } else {
            tonalElevation3 = windowInsets;
        }
        i2 = 805306368;
        if (i107 & 512 != 0) {
            $dirty3 |= i2;
            obj3 = content;
        } else {
            if (i19 & i2 == 0) {
                i2 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty3 |= i2;
            } else {
                obj3 = content;
            }
        }
        colors2 = $dirty3;
        if ($dirty3 & i112 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                windowInsets3 = -458753;
                $dirty4 = -57345;
                if (i19 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (shadowElevation2 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        i20 = 6;
                        if (i107 & 16 != 0) {
                            colors2 = inputFieldShape;
                            $dirty4 = obj6;
                        } else {
                            $dirty4 = colors2;
                            colors2 = obj6;
                        }
                        int i84 = i107 & 32;
                        if (i84 != 0) {
                            windowInsets3 = f4;
                            i7 = 256;
                            str = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, i84, 0, obj6, restartGroup);
                            $dirty4 &= i6;
                        } else {
                            windowInsets3 = i20;
                            i7 = 256;
                            str = colors;
                        }
                        if (i14 != 0) {
                            tonalElevation3 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                        } else {
                            tonalElevation3 = tonalElevation;
                        }
                        if (shadowElevation3 != 0) {
                            shadowElevation2 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                        } else {
                            shadowElevation2 = tonalElevation2;
                        }
                        if (i107 & 256 != 0) {
                            obj13 = modifier2;
                            obj10 = windowInsets3;
                            obj16 = str;
                            f = tonalElevation3;
                            f3 = shadowElevation2;
                            modifier4 = obj2;
                            obj11 = colors2;
                        } else {
                            obj10 = windowInsets;
                            obj13 = modifier2;
                            obj16 = str;
                            f = tonalElevation3;
                            f3 = shadowElevation2;
                            obj11 = colors2;
                            modifier4 = $dirty4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i107 & 16 != 0) {
                            colors2 = i10;
                        }
                        if (i107 & 32 != 0) {
                            colors2 &= windowInsets3;
                        }
                        if (i107 & 256 != 0) {
                            modifier4 = colors2 & i53;
                            obj10 = tonalElevation3;
                            f3 = tonalElevation2;
                            i7 = 256;
                            f = f2;
                            obj16 = obj9;
                            obj11 = obj6;
                            obj13 = obj2;
                        } else {
                            obj10 = tonalElevation3;
                            f3 = tonalElevation2;
                            modifier4 = colors2;
                            i7 = 256;
                            f = f2;
                            obj16 = obj9;
                            obj11 = obj6;
                            obj13 = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444649673, modifier4, -1, "androidx.compose.material3.SearchBar (SearchBar.android.kt:177)");
                }
                String str3 = "CC(remember):SearchBar.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626005896, str3);
                int i55 = 0;
                Composer composer4 = restartGroup;
                $i$f$cache = 0;
                Object rememberedValue = composer4.rememberedValue();
                int i108 = 0;
                int i111 = modifier4;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    colors2 = $this$cache$iv ? 1065353216 : 0;
                    obj33 = i55;
                    obj34 = $i$f$cache;
                    composer4.updateRememberedValue(AnimatableKt.Animatable$default(colors2, 0, 2, 0));
                } else {
                    obj33 = i55;
                    obj34 = $i$f$cache;
                    $dirty2 = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626008851, str3);
                int i57 = 0;
                Composer composer5 = restartGroup;
                int i81 = 0;
                Object rememberedValue2 = composer5.rememberedValue();
                int i102 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i50 = 0;
                    composer5.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(2143289344));
                } else {
                    mutableFloatStateOf = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626011067, str3);
                invalid$iv = 0;
                Composer composer6 = restartGroup;
                int i82 = 0;
                Object rememberedValue3 = composer6.rememberedValue();
                int i103 = 0;
                obj34 = mutableFloatStateOf;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    obj35 = i48;
                    obj36 = invalid$iv;
                    invalid$iv = 0;
                    composer6.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(invalid$iv, invalid$iv, 2, invalid$iv));
                } else {
                    obj36 = invalid$iv;
                    obj15 = rememberedValue3;
                }
                $this$cache$iv2 = obj15;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626013595, str3);
                Composer composer2 = restartGroup;
                int i83 = 0;
                Object rememberedValue4 = composer2.rememberedValue();
                int i104 = 0;
                obj35 = i28;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj36 = i46;
                    firstBackEvent = $this$cache$iv2;
                    $this$cache$iv2 = 0;
                    composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default($this$cache$iv2, $this$cache$iv2, 2, $this$cache$iv2));
                } else {
                    firstBackEvent = $this$cache$iv2;
                    mutableStateOf$default2 = rememberedValue4;
                }
                Object $i$f$cache2 = mutableStateOf$default2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626016806, str3);
                anon = 1;
                i = i111 & 112 == 32 ? anon : i12;
                Composer composer3 = restartGroup;
                i3 = 0;
                it$iv2 = composer3.rememberedValue();
                i5 = 0;
                if (changedInstance |= i == 0) {
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        obj7 = 0;
                        obj33 = obj13;
                        obj35 = obj16;
                        modifier3 = i111;
                        $dirty = obj5;
                        colors3 = str3;
                        obj34 = obj11;
                        it$iv2 = new SearchBar_androidKt.SearchBar.1.1($dirty2, expanded, obj34, firstBackEvent, (MutableState)$i$f$cache2, 0);
                        composer3.updateRememberedValue((Function2)it$iv2);
                    } else {
                        obj33 = obj13;
                        obj35 = obj16;
                        modifier3 = i111;
                        $dirty = it$iv2;
                        colors3 = str3;
                        str = obj34;
                        obj34 = obj11;
                        shape2 = composer3;
                        $this$cache$iv = expanded;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(Boolean.valueOf(expanded), (Function2)it$iv2, restartGroup, i62 &= 14);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626037411, colors3);
                Composer composer7 = restartGroup;
                int i86 = 0;
                Object rememberedValue5 = composer7.rememberedValue();
                int i105 = 0;
                obj36 = i32;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    int i33 = 0;
                    mutatorMutex = new MutatorMutex();
                    composer7.updateRememberedValue(mutatorMutex);
                } else {
                    obj = rememberedValue5;
                }
                Object obj20 = obj;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626040814, colors3);
                i11 = modifier3 & 896 == 256 ? anon : 0;
                Composer composer8 = restartGroup;
                int i87 = 0;
                Object rememberedValue6 = composer8.rememberedValue();
                f2 = 0;
                if (changedInstance2 |= i11 == 0) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        int i106 = 0;
                        anon = new SearchBar_androidKt.SearchBar.2.1((MutatorMutex)obj20, str, $dirty2, onExpandedChange, firstBackEvent, $i$f$cache2, 0);
                        obj12 = obj20;
                        composer8.updateRememberedValue((Function2)anon);
                    } else {
                        i19 = rememberedValue6;
                        obj12 = obj20;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                PredictiveBackHandlerKt.PredictiveBackHandler($this$cache$iv, (Function2)i19, restartGroup, i36 &= 14, 0);
                i9 = obj33;
                changed3 = obj34;
                Object obj21 = obj35;
                f4 = f3;
                shadowElevation3 = firstBackEvent;
                obj7 = obj10;
                float firstBackEvent2 = f;
                SearchBar_androidKt.SearchBarImpl-j1jLAyQ($dirty2, str, shadowElevation3, $i$f$cache2, i9, obj8, changed3, obj21, firstBackEvent2, f4, obj7, content, restartGroup, i43 | i77, i45 | i79, 0);
                tonalElevation5 = shadowElevation3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                currentBackEvent = changed3;
                obj4 = obj21;
                $composer2 = f4;
                obj14 = obj7;
                colors2 = modifier3;
                $dirty5 = f5;
                tonalElevation4 = i9;
            } else {
                restartGroup.skipToGroupEnd();
                obj14 = tonalElevation3;
                tonalElevation4 = obj2;
                obj4 = obj18;
                currentBackEvent = obj6;
                composer = restartGroup;
                $dirty5 = f2;
                $composer2 = tonalElevation2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SearchBar_androidKt.SearchBar.3(inputField, $this$cache$iv, onExpandedChange, tonalElevation4, currentBackEvent, obj4, $dirty5, $composer2, obj14, content, $changed, i107);
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
        int i7;
        Object derivedStateOf;
        int rememberComposableLambda;
        int i4;
        int i5;
        int $dirty2;
        Object colors-dgg9oW8;
        Shape colors3;
        Object shape2;
        Object surface3;
        Object obj4;
        float f3;
        float colors2;
        float tonalElevation3;
        Object tonalElevation2;
        int i18;
        int i15;
        int i9;
        int i22;
        int i10;
        int inputFieldShape;
        float shadowElevation2;
        Object shadowElevation3;
        Object defaultInputFieldShape;
        int i;
        boolean changedInstance2;
        Object windowInsets3;
        float windowInsets2;
        Object shadowElevation4;
        float f;
        Object $composer2;
        Object windowInsets4;
        Object obj;
        Object rememberedValue;
        int changed3;
        int i19;
        int i25;
        int changedInstance;
        float f2;
        int i8;
        int i24;
        int i2;
        Object obj5;
        float f4;
        Object obj2;
        Object animatedShape;
        Composer $this$cache$iv;
        int i23;
        int empty;
        Object obj6;
        int i21;
        int fullScreenShape;
        int i12;
        int i20;
        int surface;
        androidx.compose.runtime.internal.ComposableLambda surface2;
        int $dirty1;
        int changed;
        int i11;
        int shape3;
        int companion;
        int changed2;
        int i17;
        int i13;
        int i14;
        Composer composer;
        int i6;
        int $dirty;
        int i3;
        boolean changed4;
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
        $dirty2 = $changed;
        if (i76 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (empty & 6 == 0) {
                if (empty & 8 == 0) {
                    changedInstance2 = restartGroup.changed(traceInProgress);
                } else {
                    changedInstance2 = restartGroup.changedInstance(traceInProgress);
                }
                i18 = changedInstance2 ? 4 : 2;
                $dirty2 |= i18;
            }
        }
        if (i76 & 2 != 0) {
            $dirty2 |= 48;
            obj5 = finalBackProgress;
        } else {
            if (empty & 48 == 0) {
                i15 = restartGroup.changed(finalBackProgress) ? 32 : 16;
                $dirty2 |= i15;
            } else {
                obj5 = finalBackProgress;
            }
        }
        if (i76 & 4 != 0) {
            $dirty2 |= 384;
            obj2 = firstBackEvent;
        } else {
            if (empty & 384 == 0) {
                i9 = restartGroup.changed(firstBackEvent) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj2 = firstBackEvent;
            }
        }
        if (i76 & 8 != 0) {
            $dirty2 |= 3072;
            obj6 = currentBackEvent;
        } else {
            if (empty & 3072 == 0) {
                i22 = restartGroup.changed(currentBackEvent) ? 2048 : 1024;
                $dirty2 |= i22;
            } else {
                obj6 = currentBackEvent;
            }
        }
        i10 = i76 & 16;
        if (i10 != 0) {
            $dirty2 |= 24576;
            windowInsets3 = modifier;
        } else {
            if (empty & 24576 == 0) {
                i21 = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty2 |= i21;
            } else {
                windowInsets3 = modifier;
            }
        }
        i12 = 196608;
        if (i76 & 32 != 0) {
            $dirty2 |= i12;
            obj3 = inputField;
        } else {
            if (empty & i12 == 0) {
                i12 = restartGroup.changedInstance(inputField) ? 131072 : 65536;
                $dirty2 |= i12;
            } else {
                obj3 = inputField;
            }
        }
        i20 = 1572864;
        if (empty & i20 == 0) {
            if (i76 & 64 == 0) {
                changed = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj4 = shape;
            }
            $dirty2 |= changed;
        } else {
            obj4 = shape;
        }
        i11 = 12582912;
        if (empty & i11 == 0) {
            if (i76 & 128 == 0) {
                changed2 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                shadowElevation4 = colors;
            }
            $dirty2 |= changed2;
        } else {
            shadowElevation4 = colors;
        }
        int i49 = i76 & 256;
        int i81 = 100663296;
        if (i49 != 0) {
            $dirty2 |= i81;
            i17 = i49;
            f3 = tonalElevation;
        } else {
            if (empty & i81 == 0) {
                i17 = i49;
                i13 = restartGroup.changed(tonalElevation) ? 67108864 : 33554432;
                $dirty2 |= i13;
            } else {
                i17 = i49;
                f3 = tonalElevation;
            }
        }
        int i50 = i76 & 512;
        int i84 = 805306368;
        if (i50 != 0) {
            $dirty2 |= i84;
            i14 = i50;
            colors2 = shadowElevation;
        } else {
            if (empty & i84 == 0) {
                i14 = i50;
                i6 = restartGroup.changed(shadowElevation) ? 536870912 : 268435456;
                $dirty2 |= i6;
            } else {
                i14 = i50;
                colors2 = shadowElevation;
            }
        }
        if ($changed1 & 6 == 0) {
            if (i76 & 1024 == 0) {
                shape3 = restartGroup.changed(windowInsets) ? 4 : 2;
            } else {
                windowInsets4 = windowInsets;
            }
            $dirty1 |= shape3;
        } else {
            windowInsets4 = windowInsets;
        }
        if (i76 & 2048 != 0) {
            $dirty1 |= 48;
        } else {
            if ($changed1 & 48 == 0) {
                $dirty = restartGroup.changedInstance(obj8) ? 32 : 16;
                $dirty1 |= $dirty;
            }
        }
        if (i69 &= $dirty2 == 306783378 && $dirty1 & 19 == 18) {
            if ($dirty1 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i24 = 6;
                    if (empty & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = windowInsets3;
                            }
                            if (i76 & 64 != 0) {
                                shape3 = inputFieldShape;
                                $dirty = $dirty2;
                            } else {
                                shape3 = shape;
                                $dirty = $dirty2;
                            }
                            if (i76 & 128 != 0) {
                                inputFieldShape = i24;
                                obj31 = modifier2;
                                modifier3 = changed4;
                                colors-dgg9oW8 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, inputFieldShape, 0, shadowElevation4, restartGroup);
                                $dirty &= colors2;
                            } else {
                                obj31 = modifier2;
                                modifier3 = i24;
                                colors-dgg9oW8 = colors;
                            }
                            if (i17 != 0) {
                                tonalElevation3 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation3 = tonalElevation;
                            }
                            if (i14 != 0) {
                                shadowElevation2 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = shadowElevation;
                            }
                            if (i76 & 1024 != 0) {
                                f = shadowElevation2;
                                windowInsets4 = windowInsets5;
                                i7 = $dirty1;
                                i2 = $dirty;
                                shadowElevation3 = obj31;
                                windowInsets2 = tonalElevation3;
                                tonalElevation2 = colors-dgg9oW8;
                                colors3 = shape3;
                            } else {
                                windowInsets4 = windowInsets;
                                windowInsets2 = tonalElevation3;
                                f = shadowElevation2;
                                i7 = $dirty1;
                                i2 = $dirty;
                                shadowElevation3 = obj31;
                                tonalElevation2 = colors-dgg9oW8;
                                colors3 = shape3;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i76 & 64 != 0) {
                                $dirty2 &= i4;
                            }
                            if (i76 & 128 != 0) {
                                $dirty2 &= i5;
                            }
                            if (i76 & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            f = colors2;
                            tonalElevation2 = obj7;
                            i2 = $dirty2;
                            shadowElevation3 = windowInsets3;
                            i7 = $dirty1;
                            colors3 = shape;
                            windowInsets2 = tonalElevation;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj31 = shadowElevation3;
                        obj33 = windowInsets4;
                        ComposerKt.traceEventStart(-440333505, i2, i7, "androidx.compose.material3.SearchBarImpl (SearchBar.android.kt:867)");
                    } else {
                        obj31 = shadowElevation3;
                        obj33 = windowInsets4;
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
                        SearchBar_androidKt.SearchBarImpl.useFullScreenShape.2.1 anon3 = new SearchBar_androidKt.SearchBarImpl.useFullScreenShape.2.1(traceInProgress);
                        obj34.updateRememberedValue(SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)anon3));
                    } else {
                        $this$cache$iv = obj34;
                        obj36 = rememberedValue;
                    }
                    Object $this$cache$iv2 = rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1567240190, str3);
                    if (i73 ^= i20 > 1048576) {
                        if (!restartGroup.changed(colors3)) {
                            i19 = i2 & i20 == 1048576 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer3 = restartGroup;
                    int i78 = 0;
                    Object rememberedValue2 = composer3.rememberedValue();
                    int i80 = 0;
                    if (obj35 | i19 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            if (Intrinsics.areEqual(colors3, defaultInputFieldShape)) {
                                shape3 = colors3;
                                obj37 = defaultInputFieldShape;
                                defaultInputFieldShape = new SearchBar_androidKt.SearchBarImpl.animatedShape.1.1((Density)consume, traceInProgress);
                                shape2 = new GenericShape((Function3)defaultInputFieldShape);
                            } else {
                                obj37 = defaultInputFieldShape;
                                shape2 = SearchBar_androidKt.SearchBarImpl_j1jLAyQ$lambda$9($this$cache$iv2) ? fullScreenShape : shape3;
                            }
                            composer3.updateRememberedValue(shape2);
                        } else {
                            shape3 = colors3;
                            obj37 = defaultInputFieldShape;
                            shape2 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    SearchBar_androidKt.SearchBarImpl.surface.1 anon2 = new SearchBar_androidKt.SearchBarImpl.surface.1((Shape)shape2, tonalElevation2, windowInsets2, f);
                    surface3 = ComposableLambdaKt.rememberComposableLambda(-170534294, true, anon2, restartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1567206741, str3);
                    i = 0;
                    Composer composer2 = restartGroup;
                    int i70 = 0;
                    Object rememberedValue3 = composer2.rememberedValue();
                    int i79 = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj39 = i35;
                        surface2 = surface3;
                        surface3 = new SearchBar_androidKt.SearchBarImpl.showContent.2.1(traceInProgress);
                        composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)surface3));
                    } else {
                        surface2 = surface3;
                        derivedStateOf = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.startReplaceGroup(-1567201454);
                    ComposerKt.sourceInformation(restartGroup, "908@40729L215");
                    if (SearchBar_androidKt.SearchBarImpl_j1jLAyQ$lambda$12((State)derivedStateOf)) {
                        SearchBar_androidKt.SearchBarImpl.wrappedContent.1 anon = new SearchBar_androidKt.SearchBarImpl.wrappedContent.1(traceInProgress, tonalElevation2, obj8);
                        i25 = rememberComposableLambda;
                    } else {
                        i25 = rememberComposableLambda;
                    }
                    restartGroup.endReplaceGroup();
                    i10 = obj31;
                    i20 = obj37;
                    i3 = i2;
                    WindowInsets tonalElevation4 = obj33;
                    Composer $dirty4 = restartGroup;
                    obj6 = obj35;
                    SearchBar_androidKt.SearchBarLayout(traceInProgress, finalBackProgress, firstBackEvent, obj6, i10, tonalElevation4, inputField, surface2, i25, $dirty4, i34 | i47);
                    composer = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    animatedShape = tonalElevation4;
                    obj = surface;
                    f2 = i11;
                    $composer2 = shape3;
                    f4 = i17;
                    windowInsets3 = i10;
                } else {
                    restartGroup.skipToGroupEnd();
                    f2 = tonalElevation;
                    i3 = $dirty2;
                    f4 = colors2;
                    composer = restartGroup;
                    animatedShape = windowInsets4;
                    $composer2 = shape;
                    obj = shadowElevation4;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.SearchBarImpl.1(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, windowInsets3, inputField, $composer2, obj, f2, f4, animatedShape, obj8, $changed, $changed1, i76);
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
        boolean traceInProgress;
        Object empty2;
        Object unconsumedInsets;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object $changed$iv;
        Object $i$f$Layout;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int $dirty3;
        Object $dirty;
        int i2;
        Object str;
        Object mutableWindowInsets;
        int i4;
        Object rememberedValue;
        Integer valueOf;
        Integer currentCompositionLocalMap2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        int changedInstance2;
        boolean changedInstance;
        int $composer$iv;
        Object it$iv2;
        int empty;
        Object anon;
        int i17;
        int i12;
        int $dirty2;
        Composer composer;
        Integer currentCompositionLocalMap3;
        Composer composer6;
        Object currentCompositionLocalMap;
        int valueOf2;
        int i27;
        int i6;
        int i18;
        int i19;
        int i24;
        Modifier materializeModifier;
        boolean traceInProgress2;
        Object i20;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        int materialized$iv$iv;
        Composer composer3;
        Object maybeCachedBoxMeasurePolicy3;
        Object obj;
        int obj6;
        Composer composer4;
        Object maybeCachedBoxMeasurePolicy2;
        int iNSTANCE;
        int i;
        int i3;
        Object obj3;
        int i25;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        int i22;
        Object currentCompositeKeyHash2;
        Object obj5;
        int i16;
        kotlin.jvm.functions.Function0 function0;
        int i9;
        int i21;
        int i23;
        Composer composer2;
        int i5;
        int companion;
        Object obj2;
        Object it$iv;
        int invalid$iv;
        int i7;
        int i13;
        int i11;
        int i14;
        int i10;
        int i29;
        Alignment alignment;
        int currentCompositeKeyHash;
        Object obj4;
        int i26;
        int i15;
        kotlin.jvm.functions.Function0 function02;
        BoxScopeInstance boxScopeInstance;
        int i8;
        Composer $composer2;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier3;
        Composer composer7;
        int i28;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Composer composer5;
        Modifier modifier4;
        Modifier modifier2;
        int obj57;
        $i$f$Layout = animationProgress;
        maybeCachedBoxMeasurePolicy = modifier;
        materialized$iv$iv = windowInsets;
        obj = inputField;
        obj6 = surface;
        final int i98 = $changed;
        traceInProgress = 70029564;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBarLayout)P(!1,3,4,2,6,8,5,7)945@42029L34,950@42191L120,965@42827L5009,946@42068L5768:SearchBar.android.kt#uh7d8r");
        if (i98 & 6 == 0) {
            if (i98 & 8 == 0) {
                changedInstance = restartGroup.changed($i$f$Layout);
            } else {
                changedInstance = restartGroup.changedInstance($i$f$Layout);
            }
            i2 = changedInstance != null ? 4 : 2;
            $dirty3 |= i2;
        }
        if (i98 & 48 == 0) {
            i3 = restartGroup.changed(finalBackProgress) ? 32 : 16;
            $dirty3 |= i3;
        } else {
            str = finalBackProgress;
        }
        if (i98 & 384 == 0) {
            i22 = restartGroup.changed(firstBackEvent) ? 256 : 128;
            $dirty3 |= i22;
        } else {
            obj3 = firstBackEvent;
        }
        if (i98 & 3072 == 0) {
            i16 = restartGroup.changed(currentBackEvent) ? 2048 : 1024;
            $dirty3 |= i16;
        } else {
            currentCompositeKeyHash2 = currentBackEvent;
        }
        if (i98 & 24576 == 0) {
            i27 = restartGroup.changed(maybeCachedBoxMeasurePolicy) ? 16384 : 8192;
            $dirty3 |= i27;
        }
        if (i80 &= i98 == 0) {
            i6 = restartGroup.changed(materialized$iv$iv) ? 131072 : 65536;
            $dirty3 |= i6;
        }
        if (i81 &= i98 == 0) {
            i18 = restartGroup.changedInstance(obj) ? 1048576 : 524288;
            $dirty3 |= i18;
        }
        if (i82 &= i98 == 0) {
            i19 = restartGroup.changedInstance(obj6) ? 8388608 : 4194304;
            $dirty3 |= i19;
        }
        if (i83 &= i98 == 0) {
            i24 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
            $dirty3 |= i24;
        }
        if (i84 &= $dirty3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty3, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:941)");
                }
                String str5 = "CC(remember):SearchBar.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660147884, str5);
                Composer composer10 = restartGroup;
                int i105 = 0;
                it$iv2 = composer10.rememberedValue();
                int i108 = 0;
                int i110 = i31;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    companion = i39;
                    it$iv = it$iv2;
                    mutableWindowInsets = new MutableWindowInsets(0, 1, 0);
                    composer10.updateRememberedValue(mutableWindowInsets);
                } else {
                    i = 1;
                    mutableWindowInsets = it$iv;
                }
                unconsumedInsets = mutableWindowInsets;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660142614, str5);
                empty = i64 &= $dirty3 == 131072 ? 1 : 0;
                Composer composer11 = restartGroup;
                int i106 = 0;
                i23 = 0;
                Object rememberedValue6 = composer11.rememberedValue();
                int i111 = 0;
                if (empty == 0) {
                    invalid$iv = empty;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv2;
                        anon = new SearchBar_androidKt.SearchBarLayout.1.1((MutableWindowInsets)unconsumedInsets, materialized$iv$iv);
                        composer11.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue6;
                    }
                } else {
                    invalid$iv = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660117373, str5);
                if ($dirty3 & 14 != 4) {
                    if ($dirty3 & 8 != 0 && restartGroup.changedInstance($i$f$Layout)) {
                        if (restartGroup.changedInstance($i$f$Layout)) {
                            i4 = 1;
                        } else {
                            i4 = i23;
                        }
                    } else {
                    }
                } else {
                }
                i17 = $dirty3 & 7168 == 2048 ? 1 : i23;
                i12 = $dirty3 & 112 == 32 ? 1 : i23;
                composer2 = $dirty3 & 896 == 256 ? 1 : i23;
                Composer composer12 = restartGroup;
                int i104 = 0;
                rememberedValue = composer12.rememberedValue();
                int i107 = 0;
                if (i48 |= composer2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i21 = 0;
                        obj5 = rememberedValue;
                        i25 = i69;
                        unconsumedInsets = new SearchBar_androidKt.SearchBarLayout.2.1($i$f$Layout, unconsumedInsets, currentCompositeKeyHash2, finalBackProgress, obj3);
                        composer12.updateRememberedValue((MeasurePolicy)unconsumedInsets);
                    } else {
                        i25 = $dirty3;
                        obj5 = rememberedValue;
                        $dirty = unconsumedInsets;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i32 = i23;
                materializeModifier = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, materializeModifier);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i23);
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(restartGroup, WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(ZIndexModifierKt.zIndex(maybeCachedBoxMeasurePolicy, 1065353216), (Function1)anon), materialized$iv$iv));
                i72 |= 6;
                kotlin.jvm.functions.Function0 function03 = constructor;
                i16 = 0;
                i9 = i32;
                i21 = i40;
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
                int i112 = 0;
                obj2 = $dirty;
                Updater.set-impl(constructor-impl, (MeasurePolicy)rememberedValue, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf = 0;
                Composer composer13 = constructor-impl;
                int i114 = 0;
                if (!composer13.getInserting()) {
                    i11 = valueOf;
                    i14 = valueOf2;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer13;
                    }
                } else {
                    i11 = valueOf;
                    i14 = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                $dirty3 = restartGroup;
                i5 = i34;
                ComposerKt.sourceInformationMarkerStart($dirty3, 36789781, "C955@42396L85,956@42494L119:SearchBar.android.kt#uh7d8r");
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Surface");
                int i74 = 1;
                int i113 = 390;
                int i115 = 0;
                i13 = i50;
                maybeCachedBoxMeasurePolicy = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($dirty3, 733328855, maybeCachedBoxMeasurePolicy);
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i74);
                int i120 = 0;
                Alignment alignment2 = topStart;
                ComposerKt.sourceInformationMarkerStart($dirty3, -1323940314, materializeModifier);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($dirty3, 0);
                currentCompositionLocalMap2 = $dirty3.getCurrentCompositionLocalMap();
                int i121 = i74;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($dirty3, layoutId);
                Modifier modifier5 = layoutId;
                kotlin.jvm.functions.Function0 function06 = constructor4;
                int i123 = 0;
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
                int i129 = 0;
                modifier3 = materializeModifier4;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i132 = 0;
                Composer composer16 = constructor-impl2;
                int i136 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer16;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = $dirty3;
                int i87 = 0;
                int i130 = i38;
                $changed$iv = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $changed$iv);
                BoxScopeInstance iNSTANCE4 = BoxScopeInstance.INSTANCE;
                i134 |= 6;
                int i138 = 0;
                modifier2 = materializeModifier2;
                Composer materialized$iv$iv2 = composer18;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 1442016074, "C955@42470L9:SearchBar.android.kt#uh7d8r");
                obj6.invoke(materialized$iv$iv2, Integer.valueOf(i53 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                $dirty3.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                ComposerKt.sourceInformationMarkerEnd($dirty3);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "InputField");
                int i75 = 1;
                companion = i88;
                ComposerKt.sourceInformationMarkerStart($dirty3, 733328855, maybeCachedBoxMeasurePolicy);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, i75);
                i10 = 0;
                alignment = i75;
                ComposerKt.sourceInformationMarkerStart($dirty3, -1323940314, materializeModifier);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($dirty3, 0);
                currentCompositionLocalMap3 = $dirty3.getCurrentCompositionLocalMap();
                obj4 = topStart3;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($dirty3, layoutId2);
                i15 = layoutId2;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                i26 = 0;
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
                int i125 = 0;
                map = i96;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i131 = 0;
                Composer composer17 = constructor-impl3;
                int i137 = 0;
                if (!composer17.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer17;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = $dirty3;
                obj6 = 0;
                ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i127 |= 6;
                composer7 = 0;
                i28 = i58;
                modifier4 = materializeModifier3;
                materialized$iv$iv = composer15;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1442132231, "C957@42587L12:SearchBar.android.kt#uh7d8r");
                obj.invoke(materialized$iv$iv, Integer.valueOf(i59 &= 14));
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
                    i7 = i77;
                    ComposerKt.sourceInformationMarkerStart($dirty3, 733328855, maybeCachedBoxMeasurePolicy);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    i29 = 0;
                    alignment = topStart2;
                    ComposerKt.sourceInformationMarkerStart($dirty3, -1323940314, materializeModifier);
                    currentCompositionLocalMap = $dirty3.getCurrentCompositionLocalMap();
                    obj57 = currentCompositeKeyHash3;
                    obj4 = layoutId3;
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
                    int i109 = 0;
                    function02 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, true), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i122 = 0;
                    Composer composer14 = constructor-impl4;
                    int i128 = 0;
                    if (!composer14.getInserting()) {
                        $composer2 = $dirty3;
                        map = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(obj57))) {
                            composer14.updateRememberedValue(Integer.valueOf(obj57));
                            constructor-impl4.apply(Integer.valueOf(obj57), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer14;
                        }
                    } else {
                        $composer2 = $dirty3;
                        map = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier($dirty3, layoutId3), ComposeUiNode.Companion.getSetModifier());
                    $dirty3 = $composer2;
                    $composer$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty3, -2146769399, $changed$iv);
                    i93 |= 6;
                    composer2 = $dirty3;
                    i26 = 0;
                    boxScopeInstance = iNSTANCE2;
                    i8 = i42;
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
                i25 = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SearchBar_androidKt.SearchBarLayout.4(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, modifier, windowInsets, obj, surface, content, i98);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (layoutDirection != null) {
            i4 = 1;
            i2 = Float.compare(obj12, i6) == 0 ? i4 : i5;
            if (i2 != 0) {
            } else {
                i = layoutDirection.getSwipeEdge() == 0 ? i4 : i3;
                if (progress == LayoutDirection.Ltr) {
                    i3 = i4;
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
