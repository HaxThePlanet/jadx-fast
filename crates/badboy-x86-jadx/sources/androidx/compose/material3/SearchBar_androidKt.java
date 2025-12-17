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
        int i6;
        int traceInProgress;
        Object shape3;
        int defaultsInvalid;
        Object shape2;
        int i16;
        int i7;
        Object obj;
        int $composer2;
        boolean traceInProgress2;
        Object $composer4;
        int $dirty;
        int tonalElevation2;
        float tonalElevation3;
        Object $dirty3;
        int i14;
        int i3;
        int i;
        int $dirty4;
        Object obj3;
        float f4;
        float f2;
        Object obj2;
        float modifier2;
        int i2;
        Object colors2;
        Object colors-dgg9oW8;
        int changed;
        Object obj4;
        Composer $composer3;
        Composer shape4;
        int changed2;
        float containerColor-0d7_KjU;
        int i8;
        int anon;
        int i5;
        int $dirty2;
        int i4;
        float f;
        float f3;
        int i9;
        int i15;
        Composer composer;
        int i11;
        int i13;
        int i10;
        Object obj30;
        obj = inputField;
        final boolean z = expanded;
        final Object obj5 = onExpandedChange;
        final Object obj7 = content;
        final int i43 = $changed;
        final int i44 = i12;
        $composer2 = $composer.startRestartGroup(1209217899);
        ComposerKt.sourceInformation($composer2, "C(DockedSearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp)287@13410L11,288@13471L8,296@13752L38,300@13946L831,293@13658L1119,325@14815L27,325@14783L59:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i44 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i43 & 6 == 0) {
                i14 = $composer2.changedInstance(obj) ? 4 : 2;
                $dirty |= i14;
            }
        }
        if (i44 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i43 & 48 == 0) {
                i3 = $composer2.changed(z) ? 32 : 16;
                $dirty |= i3;
            }
        }
        if (i44 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i43 & 384 == 0) {
                i = $composer2.changedInstance(obj5) ? 256 : 128;
                $dirty |= i;
            }
        }
        $dirty4 = i44 & 8;
        if ($dirty4 != 0) {
            $dirty |= 3072;
            obj2 = modifier;
        } else {
            if (i43 & 3072 == 0) {
                i2 = $composer2.changed(modifier) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                obj2 = modifier;
            }
        }
        if (i43 & 24576 == 0) {
            if (i44 & 16 == 0) {
                changed = $composer2.changed(shape) ? 16384 : 8192;
            } else {
                colors2 = shape;
            }
            $dirty |= changed;
        } else {
            colors2 = shape;
        }
        if (i48 &= i43 == 0) {
            if (i44 & 32 == 0) {
                changed2 = $composer2.changed(colors) ? 131072 : 65536;
            } else {
                obj4 = colors;
            }
            $dirty |= changed2;
        } else {
            obj4 = colors;
        }
        i9 = i44 & 64;
        int i52 = 1572864;
        if (i9 != 0) {
            $dirty |= i52;
            containerColor-0d7_KjU = tonalElevation;
        } else {
            if (i52 &= i43 == 0) {
                i8 = $composer2.changed(tonalElevation) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                containerColor-0d7_KjU = tonalElevation;
            }
        }
        anon = i44 & 128;
        i15 = 12582912;
        if (anon != 0) {
            $dirty |= i15;
            f4 = shadowElevation;
        } else {
            if (i43 & i15 == 0) {
                i5 = $composer2.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                f4 = shadowElevation;
            }
        }
        int i54 = 100663296;
        if (i44 & 256 != 0) {
            $dirty |= i54;
        } else {
            if (i43 & i54 == 0) {
                i6 = $composer2.changedInstance(obj7) ? 67108864 : 33554432;
                $dirty |= i6;
            }
        }
        $dirty2 = $dirty;
        if (i18 &= $dirty == 38347922) {
            if (!$composer2.getSkipping()) {
                $composer2.startDefaults();
                int i34 = -458753;
                i4 = -57345;
                if (i43 & 1 != 0) {
                    if ($composer2.getDefaultsInvalid()) {
                        if ($dirty4 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i44 & 16 != 0) {
                            shape2 = SearchBarDefaults.INSTANCE.getDockedShape($composer2, 6);
                            $dirty4 = $dirty2 & i4;
                        } else {
                            shape2 = colors2;
                            $dirty4 = $dirty2;
                        }
                        if (i44 & 32 != 0) {
                            i4 = $composer2;
                            $composer2 = i10;
                            colors-dgg9oW8 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, containerColor-0d7_KjU, 0, $dirty2, i4);
                            $composer3 = i4;
                            $dirty4 &= i34;
                        } else {
                            $composer3 = $composer2;
                            $composer2 = anon;
                            colors-dgg9oW8 = colors;
                        }
                        if (i9 != 0) {
                            tonalElevation3 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                        } else {
                            tonalElevation3 = tonalElevation;
                        }
                        if ($composer2 != 0) {
                            colors2 = shape2;
                            shape3 = searchBarColors2;
                            f3 = $composer2;
                            f = tonalElevation3;
                            tonalElevation2 = $dirty4;
                        } else {
                            colors2 = shape2;
                            shape3 = searchBarColors;
                            f = tonalElevation3;
                            tonalElevation2 = $dirty4;
                            f3 = f4;
                        }
                    } else {
                        $composer2.skipToGroupEnd();
                        if (i44 & 16 != 0) {
                            $dirty2 = i16;
                        }
                        if (i44 & 32 != 0) {
                            tonalElevation2 = i25;
                            f3 = f4;
                            shape3 = obj4;
                            f = containerColor-0d7_KjU;
                            $composer3 = $composer2;
                        } else {
                            f3 = f4;
                            shape3 = obj4;
                            f = containerColor-0d7_KjU;
                            tonalElevation2 = $dirty2;
                            $composer3 = $composer2;
                        }
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1209217899, tonalElevation2, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:292)");
                }
                SearchBar_androidKt.DockedSearchBar.1 anon2 = new SearchBar_androidKt.DockedSearchBar.1(obj, z, shape3, obj7);
                composer = $composer3;
                Object $composer5 = colors2;
                SurfaceKt.Surface-T9BRK9s(SizeKt.width-3ABfNKs(ZIndexModifierKt.zIndex(obj2, 1065353216), SearchBar_androidKt.SearchBarMinWidth), $composer5, shape3.getContainerColor-0d7_KjU(), anon, ColorSchemeKt.contentColorFor-ek8zF_U(shape3.getContainerColor-0d7_KjU(), f4, $composer3), i4, f, f3, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(878471280, true, anon2, $composer3, 54), composer);
                shape4 = composer;
                ComposerKt.sourceInformationMarkerStart(shape4, -994322031, "CC(remember):SearchBar.android.kt#9igjgp");
                if (tonalElevation2 & 896 == 256) {
                } else {
                    i7 = 0;
                }
                Composer composer2 = shape4;
                int i33 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i41 = 0;
                if (i7 == 0) {
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
                $dirty2 = tonalElevation2;
                $composer4 = obj2;
                f2 = f;
                modifier2 = f3;
                $dirty3 = colors2;
            } else {
                $composer2.skipToGroupEnd();
                obj3 = obj4;
                shape4 = $composer2;
                $composer4 = obj2;
                modifier2 = f4;
                f2 = containerColor-0d7_KjU;
                $dirty3 = colors2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = shape4.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SearchBar_androidKt.DockedSearchBar.3(inputField, z, obj5, $composer4, $dirty3, obj3, f2, modifier2, obj7, i43, i44);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(...))
    public static final void DockedSearchBar-eWTbjVg(String query, Function1<? super String, Unit> onQueryChange, Function1<? super String, Unit> onSearch, boolean active, Function1<? super Boolean, Unit> onActiveChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj3;
        Object obj10;
        Object obj9;
        Object obj4;
        float f2;
        float f5;
        Object obj12;
        int modifier3;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier4;
        boolean traceInProgress;
        int i29;
        int leadingIcon2;
        boolean traceInProgress2;
        int $dirty2;
        int $dirty13;
        Object $dirty12;
        int i7;
        int i17;
        Object obj6;
        Object obj13;
        int shadowElevation3;
        boolean z2;
        boolean modifier2;
        Object obj14;
        Object obj5;
        Object shape2;
        Object obj7;
        Object obj2;
        int i5;
        Composer $dirty;
        int dockedShape;
        boolean z;
        int tonalElevation2;
        float f;
        Shape shadowElevation2;
        float f4;
        int i15;
        Object obj8;
        androidx.compose.material3.SearchBarColors searchBarColors;
        float $composer2;
        int $composer3;
        Object obj;
        float f3;
        Object obj11;
        int colors2;
        Object placeholder2;
        int i13;
        int i12;
        int i4;
        int changed4;
        Object i6;
        int i;
        Function1 i24;
        int changed2;
        int $dirty1;
        int i8;
        boolean i14;
        int i27;
        int i2;
        int i28;
        int enabled2;
        boolean $dirty15;
        int $dirty14;
        int i19;
        int i3;
        int i22;
        int i18;
        int changed;
        int i9;
        Composer composer2;
        int i23;
        int i16;
        int i26;
        int i25;
        int i10;
        int i11;
        int i21;
        int changed3;
        ScopeUpdateScope scopeUpdateScope;
        Composer composer;
        int obj51;
        int i30 = $changed;
        int i40 = $changed1;
        i29 = i20;
        Composer restartGroup = $composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation(restartGroup, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)818@37222L11,819@37283L8,826@37565L591,825@37527L894:SearchBar.android.kt#uh7d8r");
        $dirty2 = $changed;
        if (i29 & 1 != 0) {
            $dirty2 |= 6;
            obj8 = query;
        } else {
            if (i30 & 6 == 0) {
                i7 = restartGroup.changed(query) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                obj8 = query;
            }
        }
        if (i29 & 2 != 0) {
            $dirty2 |= 48;
            obj = onQueryChange;
        } else {
            if (i30 & 48 == 0) {
                i17 = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty2 |= i17;
            } else {
                obj = onQueryChange;
            }
        }
        if (i29 & 4 != 0) {
            $dirty2 |= 384;
            obj6 = onSearch;
        } else {
            if (i30 & 384 == 0) {
                i13 = restartGroup.changedInstance(onSearch) ? 256 : 128;
                $dirty2 |= i13;
            } else {
                obj6 = onSearch;
            }
        }
        changed2 = 1024;
        if (i29 & 8 != 0) {
            $dirty2 |= 3072;
            z2 = active;
        } else {
            if (i30 & 3072 == 0) {
                i12 = restartGroup.changed(active) ? i : changed2;
                $dirty2 |= i12;
            } else {
                z2 = active;
            }
        }
        i2 = 8192;
        if (i29 & 16 != 0) {
            $dirty2 |= 24576;
            obj5 = onActiveChange;
        } else {
            if (i30 & 24576 == 0) {
                i28 = restartGroup.changedInstance(onActiveChange) ? i8 : i2;
                $dirty2 |= i28;
            } else {
                obj5 = onActiveChange;
            }
        }
        int i88 = i29 & 32;
        i22 = 65536;
        i18 = 196608;
        if (i88 != 0) {
            $dirty2 |= i18;
            obj2 = modifier;
        } else {
            if (i30 & i18 == 0) {
                i9 = restartGroup.changed(modifier) ? i19 : i22;
                $dirty2 |= i9;
            } else {
                obj2 = modifier;
            }
        }
        int i89 = i29 & 64;
        i23 = 1572864;
        if (i89 != 0) {
            $dirty2 |= i23;
            z = enabled;
        } else {
            if (i30 & i23 == 0) {
                i16 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty2 |= i16;
            } else {
                z = enabled;
            }
        }
        i15 = i29 & 128;
        i26 = 12582912;
        if (i15 != 0) {
            $dirty2 |= i26;
            obj11 = placeholder;
        } else {
            if (i30 & i26 == 0) {
                i25 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i25;
            } else {
                obj11 = placeholder;
            }
        }
        leadingIcon2 = i29 & 256;
        i10 = 100663296;
        if (leadingIcon2 != 0) {
            $dirty2 |= i10;
            obj3 = leadingIcon;
        } else {
            if (i30 & i10 == 0) {
                i10 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i10;
            } else {
                obj3 = leadingIcon;
            }
        }
        int i31 = i29 & 512;
        int i90 = 805306368;
        if (i31 != 0) {
            $dirty2 |= i90;
            i11 = i31;
            obj10 = trailingIcon;
        } else {
            if ($changed & i90 == 0) {
                i11 = i31;
                i21 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i21;
            } else {
                i11 = i31;
                obj10 = trailingIcon;
            }
        }
        if (i40 & 6 == 0) {
            if (i29 & 1024 == 0) {
                i4 = restartGroup.changed(shape) ? 4 : 2;
            } else {
                obj9 = shape;
            }
            $dirty13 |= i4;
        } else {
            obj9 = shape;
        }
        if (i40 & 48 == 0) {
            if (i29 & 2048 == 0) {
                changed = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj4 = colors;
            }
            $dirty13 |= changed;
        } else {
            obj4 = colors;
        }
        int i76 = i29 & 4096;
        if (i76 != 0) {
            $dirty13 |= 384;
            f2 = tonalElevation;
        } else {
            if (i40 & 384 == 0) {
                i16 = restartGroup.changed(tonalElevation) ? 256 : 128;
                $dirty13 |= i16;
            } else {
                f2 = tonalElevation;
            }
        }
        int i77 = i29 & 8192;
        if (i77 != 0) {
            $dirty13 |= 3072;
            f5 = shadowElevation;
        } else {
            if (i40 & 3072 == 0) {
                if (restartGroup.changed(shadowElevation)) {
                } else {
                    i = changed2;
                }
                $dirty13 |= i;
            } else {
                f5 = shadowElevation;
            }
        }
        shadowElevation3 = i29 & 16384;
        if (shadowElevation3 != 0) {
            $dirty13 |= 24576;
            obj12 = interactionSource;
        } else {
            if (i40 & 24576 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i8 = i2;
                }
                $dirty13 |= i8;
            } else {
                obj12 = interactionSource;
            }
        }
        if (i29 & i85 != 0) {
            $dirty1 = $dirty16;
            $dirty12 = content;
        } else {
            if (i40 & i18 == 0) {
                if (restartGroup.changedInstance(content)) {
                } else {
                    i19 = i22;
                }
                $dirty1 = obj51 | i19;
            } else {
                $dirty12 = content;
                $dirty1 = obj51;
            }
        }
        if ($dirty2 & i14 == 306783378 && $dirty1 & i35 == 74898) {
            if ($dirty1 & i35 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i41 = 6;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i88 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = obj2;
                            }
                            i14 = i89 != 0 ? obj2 : z;
                            if (i15 != 0) {
                                obj11 = obj2;
                            }
                            leadingIcon2 = leadingIcon2 != 0 ? 0 : leadingIcon;
                            i2 = i11 != 0 ? obj2 : trailingIcon;
                            if (i29 & 1024 != 0) {
                                $dirty14 = $dirty17;
                                $dirty1 = dockedShape;
                            } else {
                                $dirty14 = $dirty1;
                                $dirty1 = shape;
                            }
                            if (i29 & 2048 != 0) {
                                i3 = shadowElevation3;
                                $composer3 = i83;
                                $dirty2 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, shadowElevation3, 0, obj5, restartGroup);
                                $dirty14 &= -113;
                            } else {
                                i3 = shadowElevation3;
                                $dirty = restartGroup;
                                $composer3 = $dirty2;
                                $dirty2 = colors;
                            }
                            if (i76 != 0) {
                                $dirty12 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                $dirty12 = tonalElevation;
                            }
                            if (i77 != 0) {
                                shadowElevation3 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation3 = shadowElevation;
                            }
                            if (i3 != 0) {
                                i22 = leadingIcon2;
                                f = $dirty12;
                                f4 = shadowElevation3;
                                changed = i79;
                                i19 = obj11;
                                obj7 = $dirty1;
                                i18 = i2;
                                obj14 = modifier4;
                                placeholder2 = $dirty2;
                                modifier3 = $dirty14;
                                $dirty15 = i14;
                            } else {
                                changed = interactionSource;
                                obj14 = modifier4;
                                i22 = leadingIcon2;
                                f = $dirty12;
                                f4 = shadowElevation3;
                                i19 = obj11;
                                obj7 = $dirty1;
                                i18 = i2;
                                modifier3 = $dirty14;
                                placeholder2 = $dirty2;
                                $dirty15 = i14;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i29 & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            if (i29 & 2048 != 0) {
                                modifier3 = $dirty1 & -113;
                                i22 = leadingIcon;
                                i18 = trailingIcon;
                                obj7 = shape;
                                f4 = shadowElevation;
                                changed = interactionSource;
                                obj14 = obj2;
                                $dirty15 = z;
                                $dirty = restartGroup;
                                i19 = obj11;
                                placeholder2 = colors;
                                f = tonalElevation;
                                $composer3 = $dirty2;
                            } else {
                                i22 = leadingIcon;
                                i18 = trailingIcon;
                                obj7 = shape;
                                f4 = shadowElevation;
                                changed = interactionSource;
                                obj14 = obj2;
                                $dirty15 = z;
                                $dirty = restartGroup;
                                i19 = obj11;
                                modifier3 = $dirty1;
                                placeholder2 = colors;
                                f = tonalElevation;
                                $composer3 = $dirty2;
                            }
                        }
                    } else {
                    }
                    $dirty.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1299054533, $composer3, modifier3, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:825)");
                    }
                    SearchBar_androidKt.DockedSearchBar.4 anon = new SearchBar_androidKt.DockedSearchBar.4(placeholder2, obj8, onQueryChange, onSearch, active, onActiveChange, $dirty15, i19, i22, i18, changed);
                    Composer $dirty4 = $dirty;
                    androidx.compose.material3.SearchBarColors $composer4 = placeholder2;
                    i27 = i49;
                    SearchBar_androidKt.DockedSearchBar-EQC0FA8((Function2)ComposableLambdaKt.rememberComposableLambda(-303118761, true, anon, $dirty, 54), active, onActiveChange, obj14, obj7, $composer4, f, f4, content, $dirty4, i48 | leadingIcon2, 0);
                    composer2 = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj13 = obj14;
                    $composer2 = f;
                    f3 = f4;
                    searchBarColors = searchBarColors2;
                    modifier2 = $dirty15;
                    i5 = i22;
                    tonalElevation2 = i18;
                    colors2 = changed;
                    enabled2 = modifier3;
                    shadowElevation2 = obj7;
                    shape2 = i19;
                } else {
                    restartGroup.skipToGroupEnd();
                    shadowElevation2 = shape;
                    searchBarColors = colors;
                    f3 = shadowElevation;
                    i27 = $dirty2;
                    obj13 = obj2;
                    modifier2 = z;
                    composer2 = restartGroup;
                    shape2 = obj11;
                    enabled2 = $dirty1;
                    i5 = leadingIcon;
                    tonalElevation2 = trailingIcon;
                    $composer2 = tonalElevation;
                    colors2 = interactionSource;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.DockedSearchBar.5(query, onQueryChange, onSearch, active, onActiveChange, obj13, modifier2, shape2, i5, tonalElevation2, shadowElevation2, searchBarColors, $composer2, f3, colors2, content, $changed, $changed1, i29);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(...))
    public static final void SearchBar-WuY5d9Q(String query, Function1<? super String, Unit> onQueryChange, Function1<? super String, Unit> onSearch, boolean active, Function1<? super Boolean, Unit> onActiveChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj11;
        Object obj7;
        Object obj3;
        Object obj;
        float f2;
        float f4;
        Object obj6;
        boolean modifier3;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier4;
        int traceInProgress;
        int i14;
        int leadingIcon2;
        boolean traceInProgress2;
        int $dirty;
        int $dirty12;
        Object $dirty14;
        Object tonalElevation2;
        int i;
        int i29;
        Object obj9;
        Object obj5;
        float shadowElevation3;
        boolean z;
        boolean modifier2;
        Object windowInsets5;
        Object windowInsets4;
        Object obj2;
        Object shape3;
        Shape shape2;
        Object obj4;
        int i6;
        int inputFieldShape;
        Composer $dirty2;
        boolean z2;
        int tonalElevation3;
        float f3;
        Object shadowElevation2;
        int i3;
        float f;
        Object obj10;
        Object windowInsets3;
        WindowInsets windowInsets2;
        Object obj12;
        float f5;
        float $composer3;
        int $composer2;
        Object obj13;
        Object obj8;
        int i4;
        int i26;
        int i2;
        int changed3;
        int colors2;
        androidx.compose.material3.SearchBarColors searchBarColors;
        int changed2;
        int i8;
        int $dirty1;
        int i24;
        int i23;
        int i20;
        int i17;
        int i5;
        int i15;
        int $dirty13;
        int i27;
        int enabled2;
        int i9;
        boolean z3;
        int i7;
        int i19;
        int changed;
        int i18;
        int i10;
        Composer composer;
        int i12;
        int i11;
        int i16;
        int i22;
        int i13;
        int i25;
        int i28;
        int changed4;
        ScopeUpdateScope scopeUpdateScope;
        Composer composer2;
        int obj53;
        int i30 = $changed;
        int i43 = $changed1;
        i14 = i21;
        Composer restartGroup = $composer.startRestartGroup(1001512593);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)737@34012L15,738@34077L8,741@34258L12,746@34418L591,745@34386L925:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i14 & 1 != 0) {
            $dirty |= 6;
            obj10 = query;
        } else {
            if (i30 & 6 == 0) {
                i = restartGroup.changed(query) ? 4 : 2;
                $dirty |= i;
            } else {
                obj10 = query;
            }
        }
        if (i14 & 2 != 0) {
            $dirty |= 48;
            obj12 = onQueryChange;
        } else {
            if (i30 & 48 == 0) {
                i29 = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty |= i29;
            } else {
                obj12 = onQueryChange;
            }
        }
        if (i14 & 4 != 0) {
            $dirty |= 384;
            obj9 = onSearch;
        } else {
            if (i30 & 384 == 0) {
                i4 = restartGroup.changedInstance(onSearch) ? 256 : 128;
                $dirty |= i4;
            } else {
                obj9 = onSearch;
            }
        }
        int i94 = 1024;
        if (i14 & 8 != 0) {
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
        i17 = 16384;
        if (i14 & 16 != 0) {
            $dirty |= 24576;
            obj2 = onActiveChange;
        } else {
            if (i30 & 24576 == 0) {
                i5 = restartGroup.changedInstance(onActiveChange) ? i17 : i24;
                $dirty |= i5;
            } else {
                obj2 = onActiveChange;
            }
        }
        $dirty13 = i14 & 32;
        i7 = 65536;
        i19 = 196608;
        if ($dirty13 != 0) {
            $dirty |= i19;
            obj4 = modifier;
        } else {
            if (i30 & i19 == 0) {
                i18 = restartGroup.changed(modifier) ? i27 : i7;
                $dirty |= i18;
            } else {
                obj4 = modifier;
            }
        }
        i10 = i14 & 64;
        int i96 = 1572864;
        if (i10 != 0) {
            $dirty |= i96;
            z2 = enabled;
        } else {
            if (i30 & i96 == 0) {
                i11 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty |= i11;
            } else {
                z2 = enabled;
            }
        }
        i3 = i14 & 128;
        i16 = 12582912;
        if (i3 != 0) {
            $dirty |= i16;
            obj13 = placeholder;
        } else {
            if (i30 & i16 == 0) {
                i22 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i22;
            } else {
                obj13 = placeholder;
            }
        }
        leadingIcon2 = i14 & 256;
        i13 = 100663296;
        if (leadingIcon2 != 0) {
            $dirty |= i13;
            obj11 = leadingIcon;
        } else {
            if (i30 & i13 == 0) {
                i13 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i13;
            } else {
                obj11 = leadingIcon;
            }
        }
        int i31 = i14 & 512;
        int i97 = 805306368;
        if (i31 != 0) {
            $dirty |= i97;
            i25 = i31;
            obj7 = trailingIcon;
        } else {
            if ($changed & i97 == 0) {
                i25 = i31;
                i28 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i28;
            } else {
                i25 = i31;
                obj7 = trailingIcon;
            }
        }
        if (i43 & 6 == 0) {
            if (i14 & 1024 == 0) {
                i2 = restartGroup.changed(shape) ? 4 : 2;
            } else {
                obj3 = shape;
            }
            $dirty12 |= i2;
        } else {
            obj3 = shape;
        }
        if (i43 & 48 == 0) {
            if (i14 & 2048 == 0) {
                i12 = restartGroup.changed(colors) ? 32 : 16;
            } else {
                obj = colors;
            }
            $dirty12 |= i12;
        } else {
            obj = colors;
        }
        int i83 = i14 & 4096;
        if (i83 != 0) {
            $dirty12 |= 384;
            f2 = tonalElevation;
        } else {
            if (i43 & 384 == 0) {
                i11 = restartGroup.changed(tonalElevation) ? 256 : 128;
                $dirty12 |= i11;
            } else {
                f2 = tonalElevation;
            }
        }
        shadowElevation3 = i14 & 8192;
        if (shadowElevation3 != 0) {
            $dirty12 |= 3072;
            f4 = shadowElevation;
        } else {
            if (i43 & 3072 == 0) {
                if (restartGroup.changed(shadowElevation)) {
                } else {
                    changed2 = i94;
                }
                $dirty12 |= changed2;
            } else {
                f4 = shadowElevation;
            }
        }
        if (i43 & 24576 == 0) {
            if (i14 & 16384 == 0) {
                if (restartGroup.changed(windowInsets)) {
                    i24 = i17;
                }
            } else {
                obj6 = windowInsets;
            }
            $dirty12 |= i24;
        } else {
            obj6 = windowInsets;
        }
        i8 = i14 & i93;
        if (i8 != 0) {
            $dirty1 = $dirty15;
            $dirty14 = interactionSource;
        } else {
            if (i43 & i19 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i27 = i7;
                }
                $dirty1 = obj53 | i27;
            } else {
                $dirty14 = interactionSource;
                $dirty1 = obj53;
            }
        }
        if (i14 & i7 != 0) {
            $dirty1 |= i96;
            tonalElevation2 = content;
        } else {
            if (i43 & i96 == 0) {
                i23 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty1 |= i23;
            } else {
                tonalElevation2 = content;
            }
        }
        if ($dirty & i20 == 306783378 && $dirty1 & i35 == 599186) {
            if ($dirty1 & i35 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i44 = 6;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if ($dirty13 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = obj4;
                            }
                            i20 = i10 != 0 ? obj4 : z2;
                            if (i3 != 0) {
                                obj13 = obj4;
                            }
                            leadingIcon2 = leadingIcon2 != 0 ? 0 : leadingIcon;
                            i17 = i25 != 0 ? obj4 : trailingIcon;
                            if (i14 & 1024 != 0) {
                                $dirty13 = $dirty16;
                                $dirty1 = inputFieldShape;
                            } else {
                                $dirty13 = $dirty1;
                                $dirty1 = shape;
                            }
                            if (i14 & 2048 != 0) {
                                i9 = shadowElevation3;
                                $composer2 = i90;
                                $dirty = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, shadowElevation3, 0, obj2, restartGroup);
                                $dirty13 &= -113;
                            } else {
                                i9 = shadowElevation3;
                                $dirty2 = restartGroup;
                                $composer2 = $dirty;
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
                            if (i14 & 16384 != 0) {
                                windowInsets5 = SearchBarDefaults.INSTANCE.getWindowInsets($dirty2, i44);
                                $dirty13 &= obj2;
                            } else {
                                windowInsets5 = windowInsets;
                            }
                            if (i8 != 0) {
                                i19 = leadingIcon2;
                                searchBarColors = $dirty;
                                f3 = tonalElevation2;
                                f = shadowElevation3;
                                windowInsets2 = windowInsets5;
                                i10 = i88;
                                i7 = obj13;
                                shape2 = $dirty1;
                                z3 = i20;
                                changed = i17;
                                windowInsets4 = modifier4;
                                modifier3 = $dirty13;
                            } else {
                                i10 = interactionSource;
                                i19 = leadingIcon2;
                                searchBarColors = $dirty;
                                f3 = tonalElevation2;
                                f = shadowElevation3;
                                windowInsets2 = windowInsets5;
                                i7 = obj13;
                                shape2 = $dirty1;
                                z3 = i20;
                                changed = i17;
                                windowInsets4 = modifier4;
                                modifier3 = $dirty13;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i14 & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            if (i14 & 2048 != 0) {
                                $dirty1 &= -113;
                            }
                            if (i14 & 16384 != 0) {
                                modifier3 = $dirty1 & i39;
                                i19 = leadingIcon;
                                changed = trailingIcon;
                                shape2 = shape;
                                searchBarColors = colors;
                                f = shadowElevation;
                                windowInsets2 = windowInsets;
                                i10 = interactionSource;
                                windowInsets4 = obj4;
                                z3 = z2;
                                $dirty2 = restartGroup;
                                i7 = obj13;
                                f3 = tonalElevation;
                                $composer2 = $dirty;
                            } else {
                                i19 = leadingIcon;
                                changed = trailingIcon;
                                shape2 = shape;
                                searchBarColors = colors;
                                f = shadowElevation;
                                windowInsets2 = windowInsets;
                                i10 = interactionSource;
                                windowInsets4 = obj4;
                                z3 = z2;
                                $dirty2 = restartGroup;
                                i7 = obj13;
                                modifier3 = $dirty1;
                                f3 = tonalElevation;
                                $composer2 = $dirty;
                            }
                        }
                    } else {
                    }
                    $dirty2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1001512593, $composer2, modifier3, "androidx.compose.material3.SearchBar (SearchBar.android.kt:745)");
                    }
                    SearchBar_androidKt.SearchBar.4 anon = new SearchBar_androidKt.SearchBar.4(searchBarColors, query, obj12, onSearch, active, onActiveChange, z3, i7, i19, changed, i10);
                    Composer $dirty4 = $dirty2;
                    androidx.compose.material3.SearchBarColors $composer4 = searchBarColors;
                    i15 = i53;
                    SearchBar_androidKt.SearchBar-Y92LkZI((Function2)ComposableLambdaKt.rememberComposableLambda(-1158111311, true, anon, $dirty2, 54), active, onActiveChange, windowInsets4, shape2, $composer4, f3, f, windowInsets2, content, $dirty4, i52 | leadingIcon2, 0);
                    composer = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = windowInsets4;
                    f5 = f3;
                    $composer3 = f;
                    obj8 = windowInsets2;
                    windowInsets3 = searchBarColors2;
                    modifier2 = z3;
                    i6 = i19;
                    tonalElevation3 = changed;
                    colors2 = i10;
                    enabled2 = modifier3;
                    shadowElevation2 = shape2;
                    shape3 = i7;
                } else {
                    restartGroup.skipToGroupEnd();
                    shadowElevation2 = shape;
                    windowInsets3 = colors;
                    f5 = tonalElevation;
                    colors2 = interactionSource;
                    i15 = $dirty;
                    obj5 = obj4;
                    modifier2 = z2;
                    composer = restartGroup;
                    shape3 = obj13;
                    enabled2 = $dirty1;
                    i6 = leadingIcon;
                    tonalElevation3 = trailingIcon;
                    $composer3 = shadowElevation;
                    obj8 = windowInsets;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.SearchBar.5(query, onQueryChange, onSearch, active, onActiveChange, obj5, modifier2, shape3, i6, tonalElevation3, shadowElevation2, windowInsets3, f5, $composer3, obj8, colors2, content, $changed, $changed1, i14);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void SearchBar-Y92LkZI(Function2<? super Composer, ? super Integer, Unit> inputField, boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj2;
        boolean traceInProgress2;
        int modifier4;
        Object $i$a$CacheSearchBar_androidKt$SearchBar$finalBackProgress$1;
        Object obj5;
        Object mutableStateOf$default2;
        Object it$iv;
        Object $i$a$CacheSearchBar_androidKt$SearchBar$mutatorMutex$1;
        int i2;
        int defaultsInvalid;
        Object modifier3;
        int $dirty;
        Object $dirty2;
        int windowInsets2;
        boolean traceInProgress;
        boolean $this$cache$iv2;
        int invalid$iv;
        int i19;
        int i10;
        int i22;
        Object str;
        Object tonalElevation5;
        Object tonalElevation4;
        Object $this$cache$iv;
        Object i7;
        int i18;
        int i8;
        Object currentBackEvent;
        int shadowElevation2;
        int $i$f$cache;
        int inputFieldShape;
        Object obj15;
        Object obj12;
        int it$iv2;
        int i6;
        int i5;
        Object obj14;
        float $dirty5;
        Object obj13;
        int modifier2;
        float $composer2;
        int changed3;
        Object obj4;
        Object obj9;
        Object obj11;
        Composer shape2;
        int changed2;
        float f4;
        Object obj;
        String colors3;
        androidx.compose.material3.SearchBar_androidKt.SearchBar.2.1 $i$a$CacheSearchBar_androidKt$SearchBar$2;
        int i;
        Object empty2;
        int empty;
        float tonalElevation2;
        float f;
        Object obj3;
        Object shadowElevation3;
        float f3;
        Object i11;
        Composer.Companion companion;
        Object mutableStateOf$default;
        androidx.compose.material3.SearchBar_androidKt.SearchBar.2.1 anon;
        int i3;
        int i21;
        Object mutatorMutex;
        int i17;
        Object i12;
        Object $dirty3;
        int changed;
        int i14;
        int colors2;
        Function1 i15;
        Object tonalElevation3;
        int $dirty4;
        Object firstBackEvent;
        float f2;
        Object i20;
        Object obj10;
        Function3 windowInsets3;
        Object obj8;
        Composer composer;
        Object obj6;
        int i9;
        int i16;
        int i4;
        Object obj7;
        Object obj33;
        Object obj34;
        Object obj35;
        int obj36;
        $this$cache$iv2 = expanded;
        $i$a$CacheSearchBar_androidKt$SearchBar$2 = $changed;
        final int i104 = i13;
        Composer restartGroup = $composer.startRestartGroup(1444649673);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp,9)171@8255L15,172@8320L8,175@8501L12,178@8596L64,179@8689L43,180@8758L51,181@8837L51,183@8919L638,183@8894L663,199@9582L27,200@9656L1062,200@9614L1104,226@10724L458:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i104 & 1 != 0) {
            $dirty |= 6;
            obj3 = inputField;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 6 == 0) {
                i10 = restartGroup.changedInstance(inputField) ? 4 : 2;
                $dirty |= i10;
            } else {
                obj3 = inputField;
            }
        }
        if (i104 & 2 != 0) {
            $dirty |= 48;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 48 == 0) {
                i22 = restartGroup.changed($this$cache$iv2) ? 32 : 16;
                $dirty |= i22;
            }
        }
        if (i104 & 4 != 0) {
            $dirty |= 384;
            str = onExpandedChange;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 384 == 0) {
                i8 = restartGroup.changedInstance(onExpandedChange) ? 256 : 128;
                $dirty |= i8;
            } else {
                str = onExpandedChange;
            }
        }
        shadowElevation2 = i104 & 8;
        if (shadowElevation2 != 0) {
            $dirty |= 3072;
            obj15 = modifier;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 3072 == 0) {
                i5 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                obj15 = modifier;
            }
        }
        if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 24576 == 0) {
            if (i104 & 16 == 0) {
                changed3 = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                obj14 = shape;
            }
            $dirty |= changed3;
        } else {
            obj14 = shape;
        }
        if (i94 &= $i$a$CacheSearchBar_androidKt$SearchBar$2 == 0) {
            if (i104 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj4 = colors;
            }
            $dirty |= changed2;
        } else {
            obj4 = colors;
        }
        i11 = i104 & 64;
        int i97 = 1572864;
        if (i11 != 0) {
            $dirty |= i97;
            f4 = tonalElevation;
        } else {
            if (i97 &= $i$a$CacheSearchBar_androidKt$SearchBar$2 == 0) {
                i3 = restartGroup.changed(tonalElevation) ? 1048576 : 524288;
                $dirty |= i3;
            } else {
                f4 = tonalElevation;
            }
        }
        shadowElevation3 = i104 & 128;
        i21 = 12582912;
        if (shadowElevation3 != 0) {
            $dirty |= i21;
            tonalElevation2 = shadowElevation;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & i21 == 0) {
                i17 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty |= i17;
            } else {
                tonalElevation2 = shadowElevation;
            }
        }
        if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & i107 == 0) {
            if (i104 & 256 == 0) {
                changed = restartGroup.changed(windowInsets) ? 67108864 : 33554432;
            } else {
                tonalElevation5 = windowInsets;
            }
            $dirty |= changed;
        } else {
            tonalElevation5 = windowInsets;
        }
        i14 = 805306368;
        if (i104 & 512 != 0) {
            $dirty |= i14;
            obj2 = content;
        } else {
            if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & i14 == 0) {
                i14 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i14;
            } else {
                obj2 = content;
            }
        }
        colors2 = $dirty;
        if ($dirty & i109 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                windowInsets2 = -458753;
                $dirty4 = -57345;
                if ($i$a$CacheSearchBar_androidKt$SearchBar$2 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (shadowElevation2 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj15;
                        }
                        i6 = 6;
                        if (i104 & 16 != 0) {
                            colors2 = inputFieldShape;
                            $dirty4 = obj14;
                        } else {
                            $dirty4 = colors2;
                            colors2 = obj14;
                        }
                        int i81 = i104 & 32;
                        if (i81 != 0) {
                            windowInsets2 = f2;
                            i = 256;
                            str = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, i81, 0, obj14, restartGroup);
                            $dirty4 &= i12;
                        } else {
                            windowInsets2 = i6;
                            i = 256;
                            str = colors;
                        }
                        if (i11 != 0) {
                            tonalElevation5 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                        } else {
                            tonalElevation5 = tonalElevation;
                        }
                        if (shadowElevation3 != 0) {
                            shadowElevation2 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                        } else {
                            shadowElevation2 = tonalElevation2;
                        }
                        if (i104 & 256 != 0) {
                            obj13 = modifier3;
                            obj8 = windowInsets2;
                            obj = str;
                            f = tonalElevation5;
                            f3 = shadowElevation2;
                            modifier4 = obj15;
                            obj11 = colors2;
                        } else {
                            obj8 = windowInsets;
                            obj13 = modifier3;
                            obj = str;
                            f = tonalElevation5;
                            f3 = shadowElevation2;
                            obj11 = colors2;
                            modifier4 = $dirty4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i104 & 16 != 0) {
                            colors2 = i2;
                        }
                        if (i104 & 32 != 0) {
                            colors2 &= windowInsets2;
                        }
                        if (i104 & 256 != 0) {
                            modifier4 = colors2 & i50;
                            obj8 = tonalElevation5;
                            f3 = tonalElevation2;
                            i = 256;
                            f = f4;
                            obj = obj4;
                            obj11 = obj14;
                            obj13 = obj15;
                        } else {
                            obj8 = tonalElevation5;
                            f3 = tonalElevation2;
                            modifier4 = colors2;
                            i = 256;
                            f = f4;
                            obj = obj4;
                            obj11 = obj14;
                            obj13 = obj15;
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
                int i52 = 0;
                Composer composer4 = restartGroup;
                $i$f$cache = 0;
                Object rememberedValue = composer4.rememberedValue();
                int i105 = 0;
                int i108 = modifier4;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    colors2 = $this$cache$iv2 ? 1065353216 : 0;
                    obj33 = i52;
                    obj34 = $i$f$cache;
                    composer4.updateRememberedValue(AnimatableKt.Animatable$default(colors2, 0, 2, 0));
                } else {
                    obj33 = i52;
                    obj34 = $i$f$cache;
                    $dirty2 = rememberedValue;
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
                    obj5 = rememberedValue3;
                }
                $this$cache$iv = obj5;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626013595, str3);
                Composer composer2 = restartGroup;
                int i80 = 0;
                Object rememberedValue4 = composer2.rememberedValue();
                int i101 = 0;
                obj35 = i27;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj36 = i45;
                    firstBackEvent = $this$cache$iv;
                    $this$cache$iv = 0;
                    composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default($this$cache$iv, $this$cache$iv, 2, $this$cache$iv));
                } else {
                    firstBackEvent = $this$cache$iv;
                    mutableStateOf$default2 = rememberedValue4;
                }
                Object $i$f$cache2 = mutableStateOf$default2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 626016806, str3);
                anon = 1;
                i19 = i108 & 112 == 32 ? anon : i7;
                Composer composer3 = restartGroup;
                i15 = 0;
                it$iv = composer3.rememberedValue();
                i20 = 0;
                if (changedInstance |= i19 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj10 = 0;
                        obj33 = obj13;
                        obj35 = obj;
                        modifier2 = i108;
                        $dirty3 = obj6;
                        colors3 = str3;
                        obj34 = obj11;
                        it$iv = new SearchBar_androidKt.SearchBar.1.1($dirty2, expanded, obj34, firstBackEvent, (MutableState)$i$f$cache2, 0);
                        composer3.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj33 = obj13;
                        obj35 = obj;
                        modifier2 = i108;
                        $dirty3 = it$iv;
                        colors3 = str3;
                        str = obj34;
                        obj34 = obj11;
                        shape2 = composer3;
                        $this$cache$iv2 = expanded;
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
                i18 = modifier2 & 896 == 256 ? anon : 0;
                Composer composer8 = restartGroup;
                int i84 = 0;
                Object rememberedValue6 = composer8.rememberedValue();
                f4 = 0;
                if (changedInstance2 |= i18 == 0) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        int i103 = 0;
                        anon = new SearchBar_androidKt.SearchBar.2.1((MutatorMutex)obj19, str, $dirty2, onExpandedChange, firstBackEvent, $i$f$cache2, 0);
                        obj7 = obj19;
                        composer8.updateRememberedValue((Function2)anon);
                    } else {
                        $i$a$CacheSearchBar_androidKt$SearchBar$2 = rememberedValue6;
                        obj7 = obj19;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                PredictiveBackHandlerKt.PredictiveBackHandler($this$cache$iv2, (Function2)$i$a$CacheSearchBar_androidKt$SearchBar$2, restartGroup, i35 &= 14, 0);
                i21 = obj33;
                changed = obj34;
                Object obj20 = obj35;
                f2 = f3;
                shadowElevation3 = firstBackEvent;
                obj10 = obj8;
                float firstBackEvent2 = f;
                SearchBar_androidKt.SearchBarImpl-j1jLAyQ($dirty2, str, shadowElevation3, $i$f$cache2, i21, obj3, changed, obj20, firstBackEvent2, f2, obj10, content, restartGroup, i42 | i74, i44 | i76, 0);
                tonalElevation3 = shadowElevation3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                currentBackEvent = changed;
                obj12 = obj20;
                $composer2 = f2;
                obj9 = obj10;
                colors2 = modifier2;
                $dirty5 = f5;
                tonalElevation4 = i21;
            } else {
                restartGroup.skipToGroupEnd();
                obj9 = tonalElevation5;
                tonalElevation4 = obj15;
                obj12 = obj17;
                currentBackEvent = obj14;
                composer = restartGroup;
                $dirty5 = f4;
                $composer2 = tonalElevation2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SearchBar_androidKt.SearchBar.3(inputField, $this$cache$iv2, onExpandedChange, tonalElevation4, currentBackEvent, obj12, $dirty5, $composer2, obj9, content, $changed, i104);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void SearchBarImpl-j1jLAyQ(Animatable<Float, AnimationVector1D> animationProgress, MutableFloatState finalBackProgress, MutableState<BackEventCompat> firstBackEvent, MutableState<BackEventCompat> currentBackEvent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> inputField, Shape shape, androidx.compose.material3.SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        Object traceInProgress;
        Object endRestartGroup;
        Object obj;
        boolean skipping;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int i17;
        Object derivedStateOf;
        int rememberComposableLambda;
        int i14;
        int i24;
        int $dirty2;
        Object colors-dgg9oW8;
        Shape colors2;
        Object shape2;
        Object surface;
        Object obj2;
        float f4;
        float colors3;
        float tonalElevation2;
        Object tonalElevation3;
        int i12;
        int i21;
        int i;
        int i13;
        int i3;
        int inputFieldShape;
        float shadowElevation2;
        Object shadowElevation3;
        Object defaultInputFieldShape;
        int i20;
        boolean changedInstance;
        Object windowInsets4;
        float windowInsets2;
        Object shadowElevation4;
        float f2;
        Object $composer2;
        Object windowInsets3;
        Object obj3;
        Object rememberedValue;
        int changed3;
        int i25;
        int i19;
        int changedInstance2;
        float f3;
        int i9;
        int i22;
        int i18;
        Object obj4;
        float f;
        Object obj5;
        Object animatedShape;
        Composer $this$cache$iv;
        int i10;
        int empty;
        Object obj6;
        int i4;
        int fullScreenShape;
        int i5;
        int i6;
        int surface3;
        androidx.compose.runtime.internal.ComposableLambda surface2;
        int $dirty1;
        int changed;
        int i7;
        int shape3;
        int companion;
        int changed2;
        int i11;
        int i23;
        int i2;
        Composer composer;
        int i8;
        int $dirty;
        int i15;
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
                    changedInstance = restartGroup.changed(traceInProgress);
                } else {
                    changedInstance = restartGroup.changedInstance(traceInProgress);
                }
                i12 = changedInstance != null ? 4 : 2;
                $dirty2 |= i12;
            }
        }
        if (i76 & 2 != 0) {
            $dirty2 |= 48;
            obj4 = finalBackProgress;
        } else {
            if (empty & 48 == 0) {
                i21 = restartGroup.changed(finalBackProgress) ? 32 : 16;
                $dirty2 |= i21;
            } else {
                obj4 = finalBackProgress;
            }
        }
        if (i76 & 4 != 0) {
            $dirty2 |= 384;
            obj5 = firstBackEvent;
        } else {
            if (empty & 384 == 0) {
                i = restartGroup.changed(firstBackEvent) ? 256 : 128;
                $dirty2 |= i;
            } else {
                obj5 = firstBackEvent;
            }
        }
        if (i76 & 8 != 0) {
            $dirty2 |= 3072;
            obj6 = currentBackEvent;
        } else {
            if (empty & 3072 == 0) {
                i13 = restartGroup.changed(currentBackEvent) ? 2048 : 1024;
                $dirty2 |= i13;
            } else {
                obj6 = currentBackEvent;
            }
        }
        i3 = i76 & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            windowInsets4 = modifier;
        } else {
            if (empty & 24576 == 0) {
                i4 = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                windowInsets4 = modifier;
            }
        }
        i5 = 196608;
        if (i76 & 32 != 0) {
            $dirty2 |= i5;
            obj = inputField;
        } else {
            if (empty & i5 == 0) {
                i5 = restartGroup.changedInstance(inputField) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                obj = inputField;
            }
        }
        i6 = 1572864;
        if (empty & i6 == 0) {
            if (i76 & 64 == 0) {
                changed = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj2 = shape;
            }
            $dirty2 |= changed;
        } else {
            obj2 = shape;
        }
        i7 = 12582912;
        if (empty & i7 == 0) {
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
            i11 = i49;
            f4 = tonalElevation;
        } else {
            if (empty & i81 == 0) {
                i11 = i49;
                i23 = restartGroup.changed(tonalElevation) ? 67108864 : 33554432;
                $dirty2 |= i23;
            } else {
                i11 = i49;
                f4 = tonalElevation;
            }
        }
        int i50 = i76 & 512;
        int i84 = 805306368;
        if (i50 != 0) {
            $dirty2 |= i84;
            i2 = i50;
            colors3 = shadowElevation;
        } else {
            if (empty & i84 == 0) {
                i2 = i50;
                i8 = restartGroup.changed(shadowElevation) ? 536870912 : 268435456;
                $dirty2 |= i8;
            } else {
                i2 = i50;
                colors3 = shadowElevation;
            }
        }
        if ($changed1 & 6 == 0) {
            if (i76 & 1024 == 0) {
                shape3 = restartGroup.changed(windowInsets) ? 4 : 2;
            } else {
                windowInsets3 = windowInsets;
            }
            $dirty1 |= shape3;
        } else {
            windowInsets3 = windowInsets;
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
                    i22 = 6;
                    if (empty & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i3 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = windowInsets4;
                            }
                            if (i76 & 64 != 0) {
                                shape3 = inputFieldShape;
                                $dirty = $dirty2;
                            } else {
                                shape3 = shape;
                                $dirty = $dirty2;
                            }
                            if (i76 & 128 != 0) {
                                inputFieldShape = i22;
                                obj31 = modifier2;
                                modifier3 = changed4;
                                colors-dgg9oW8 = SearchBarDefaults.INSTANCE.colors-dgg9oW8(0, inputFieldShape, 0, shadowElevation4, restartGroup);
                                $dirty &= colors3;
                            } else {
                                obj31 = modifier2;
                                modifier3 = i22;
                                colors-dgg9oW8 = colors;
                            }
                            if (i11 != 0) {
                                tonalElevation2 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = tonalElevation;
                            }
                            if (i2 != 0) {
                                shadowElevation2 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = shadowElevation;
                            }
                            if (i76 & 1024 != 0) {
                                f2 = shadowElevation2;
                                windowInsets3 = windowInsets5;
                                i17 = $dirty1;
                                i18 = $dirty;
                                shadowElevation3 = obj31;
                                windowInsets2 = tonalElevation2;
                                tonalElevation3 = colors-dgg9oW8;
                                colors2 = shape3;
                            } else {
                                windowInsets3 = windowInsets;
                                windowInsets2 = tonalElevation2;
                                f2 = shadowElevation2;
                                i17 = $dirty1;
                                i18 = $dirty;
                                shadowElevation3 = obj31;
                                tonalElevation3 = colors-dgg9oW8;
                                colors2 = shape3;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i76 & 64 != 0) {
                                $dirty2 &= i14;
                            }
                            if (i76 & 128 != 0) {
                                $dirty2 &= i24;
                            }
                            if (i76 & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            f2 = colors3;
                            tonalElevation3 = obj7;
                            i18 = $dirty2;
                            shadowElevation3 = windowInsets4;
                            i17 = $dirty1;
                            colors2 = shape;
                            windowInsets2 = tonalElevation;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj31 = shadowElevation3;
                        obj33 = windowInsets3;
                        ComposerKt.traceEventStart(-440333505, i18, i17, "androidx.compose.material3.SearchBarImpl (SearchBar.android.kt:867)");
                    } else {
                        obj31 = shadowElevation3;
                        obj33 = windowInsets3;
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
                    if (i73 ^= i6 > 1048576) {
                        if (!restartGroup.changed(colors2)) {
                            i25 = i18 & i6 == 1048576 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer3 = restartGroup;
                    int i78 = 0;
                    Object rememberedValue2 = composer3.rememberedValue();
                    int i80 = 0;
                    if (obj35 | i25 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            if (Intrinsics.areEqual(colors2, defaultInputFieldShape)) {
                                shape3 = colors2;
                                obj37 = defaultInputFieldShape;
                                defaultInputFieldShape = new SearchBar_androidKt.SearchBarImpl.animatedShape.1.1((Density)consume, traceInProgress);
                                shape2 = new GenericShape((Function3)defaultInputFieldShape);
                            } else {
                                obj37 = defaultInputFieldShape;
                                shape2 = SearchBar_androidKt.SearchBarImpl_j1jLAyQ$lambda$9($this$cache$iv2) ? fullScreenShape : shape3;
                            }
                            composer3.updateRememberedValue(shape2);
                        } else {
                            shape3 = colors2;
                            obj37 = defaultInputFieldShape;
                            shape2 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    SearchBar_androidKt.SearchBarImpl.surface.1 anon2 = new SearchBar_androidKt.SearchBarImpl.surface.1((Shape)shape2, tonalElevation3, windowInsets2, f2);
                    surface = ComposableLambdaKt.rememberComposableLambda(-170534294, true, anon2, restartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1567206741, str3);
                    i20 = 0;
                    Composer composer2 = restartGroup;
                    int i70 = 0;
                    Object rememberedValue3 = composer2.rememberedValue();
                    int i79 = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj39 = i35;
                        surface2 = surface;
                        surface = new SearchBar_androidKt.SearchBarImpl.showContent.2.1(traceInProgress);
                        composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)surface));
                    } else {
                        surface2 = surface;
                        derivedStateOf = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.startReplaceGroup(-1567201454);
                    ComposerKt.sourceInformation(restartGroup, "908@40729L215");
                    if (SearchBar_androidKt.SearchBarImpl_j1jLAyQ$lambda$12((State)derivedStateOf)) {
                        SearchBar_androidKt.SearchBarImpl.wrappedContent.1 anon = new SearchBar_androidKt.SearchBarImpl.wrappedContent.1(traceInProgress, tonalElevation3, obj8);
                        i19 = rememberComposableLambda;
                    } else {
                        i19 = rememberComposableLambda;
                    }
                    restartGroup.endReplaceGroup();
                    i3 = obj31;
                    i6 = obj37;
                    i15 = i18;
                    WindowInsets tonalElevation4 = obj33;
                    Composer $dirty4 = restartGroup;
                    obj6 = obj35;
                    SearchBar_androidKt.SearchBarLayout(traceInProgress, finalBackProgress, firstBackEvent, obj6, i3, tonalElevation4, inputField, surface2, i19, $dirty4, i34 | i47);
                    composer = $dirty4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    animatedShape = tonalElevation4;
                    obj3 = surface3;
                    f3 = i7;
                    $composer2 = shape3;
                    f = i11;
                    windowInsets4 = i3;
                } else {
                    restartGroup.skipToGroupEnd();
                    f3 = tonalElevation;
                    i15 = $dirty2;
                    f = colors3;
                    composer = restartGroup;
                    animatedShape = windowInsets3;
                    $composer2 = shape;
                    obj3 = shadowElevation4;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SearchBar_androidKt.SearchBarImpl.1(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, windowInsets4, inputField, $composer2, obj3, f3, f, animatedShape, obj8, $changed, $changed1, i76);
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
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Object $changed$iv;
        Object $i$f$Layout;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        int $dirty2;
        Object $dirty;
        int i2;
        Object str;
        Object mutableWindowInsets;
        int i23;
        Object rememberedValue;
        Integer valueOf2;
        Integer currentCompositionLocalMap4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int changedInstance2;
        boolean changedInstance;
        int $composer$iv;
        Object it$iv2;
        int empty;
        Object $i$a$CacheSearchBar_androidKt$SearchBarLayout$1;
        int i24;
        int i5;
        int $dirty3;
        Composer composer6;
        Integer currentCompositionLocalMap3;
        Composer composer5;
        Object currentCompositionLocalMap2;
        int valueOf;
        int i8;
        int i22;
        int i15;
        int i16;
        int i17;
        Modifier materializeModifier;
        boolean traceInProgress;
        Object i14;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy2;
        int materialized$iv$iv;
        Composer composer2;
        Object maybeCachedBoxMeasurePolicy3;
        Object obj;
        int obj6;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy;
        int iNSTANCE;
        int i12;
        int i28;
        Object obj4;
        int i3;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i18;
        Object currentCompositeKeyHash2;
        Object obj3;
        int i26;
        kotlin.jvm.functions.Function0 function02;
        int i7;
        int i19;
        int i20;
        Composer composer3;
        int i27;
        int companion;
        Object obj2;
        Object it$iv;
        int invalid$iv;
        int i21;
        int i25;
        int $i$f$setImpl;
        int i9;
        int i10;
        int i11;
        Alignment alignment;
        int currentCompositeKeyHash;
        Object obj5;
        int i13;
        int i4;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        int i6;
        Composer $composer2;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier3;
        Composer composer7;
        int i;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer4;
        Modifier modifier4;
        Modifier modifier2;
        int obj57;
        $i$f$Layout = animationProgress;
        maybeCachedBoxMeasurePolicy2 = modifier;
        materialized$iv$iv = windowInsets;
        obj = inputField;
        obj6 = surface;
        final int i95 = $changed;
        traceInProgress2 = 70029564;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(SearchBarLayout)P(!1,3,4,2,6,8,5,7)945@42029L34,950@42191L120,965@42827L5009,946@42068L5768:SearchBar.android.kt#uh7d8r");
        if (i95 & 6 == 0) {
            if (i95 & 8 == 0) {
                changedInstance = restartGroup.changed($i$f$Layout);
            } else {
                changedInstance = restartGroup.changedInstance($i$f$Layout);
            }
            i2 = changedInstance != null ? 4 : 2;
            $dirty2 |= i2;
        }
        if (i95 & 48 == 0) {
            i28 = restartGroup.changed(finalBackProgress) ? 32 : 16;
            $dirty2 |= i28;
        } else {
            str = finalBackProgress;
        }
        if (i95 & 384 == 0) {
            i18 = restartGroup.changed(firstBackEvent) ? 256 : 128;
            $dirty2 |= i18;
        } else {
            obj4 = firstBackEvent;
        }
        if (i95 & 3072 == 0) {
            i26 = restartGroup.changed(currentBackEvent) ? 2048 : 1024;
            $dirty2 |= i26;
        } else {
            currentCompositeKeyHash2 = currentBackEvent;
        }
        if (i95 & 24576 == 0) {
            i8 = restartGroup.changed(maybeCachedBoxMeasurePolicy2) ? 16384 : 8192;
            $dirty2 |= i8;
        }
        if (i77 &= i95 == 0) {
            i22 = restartGroup.changed(materialized$iv$iv) ? 131072 : 65536;
            $dirty2 |= i22;
        }
        if (i78 &= i95 == 0) {
            i15 = restartGroup.changedInstance(obj) ? 1048576 : 524288;
            $dirty2 |= i15;
        }
        if (i79 &= i95 == 0) {
            i16 = restartGroup.changedInstance(obj6) ? 8388608 : 4194304;
            $dirty2 |= i16;
        }
        if (i80 &= i95 == 0) {
            i17 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
            $dirty2 |= i17;
        }
        if (i81 &= $dirty2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:941)");
                }
                String str5 = "CC(remember):SearchBar.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660147884, str5);
                Composer composer10 = restartGroup;
                int i102 = 0;
                it$iv2 = composer10.rememberedValue();
                int i105 = 0;
                int i107 = i30;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    companion = i38;
                    it$iv = it$iv2;
                    mutableWindowInsets = new MutableWindowInsets(0, 1, 0);
                    composer10.updateRememberedValue(mutableWindowInsets);
                } else {
                    i12 = 1;
                    mutableWindowInsets = it$iv;
                }
                unconsumedInsets = mutableWindowInsets;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -660142614, str5);
                empty = i62 &= $dirty2 == 131072 ? 1 : 0;
                Composer composer11 = restartGroup;
                int i103 = 0;
                i20 = 0;
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
                if ($dirty2 & 14 != 4) {
                    if ($dirty2 & 8 != 0 && restartGroup.changedInstance($i$f$Layout)) {
                        if (restartGroup.changedInstance($i$f$Layout)) {
                            i23 = 1;
                        } else {
                            i23 = i20;
                        }
                    } else {
                    }
                } else {
                }
                i24 = $dirty2 & 7168 == 2048 ? 1 : i20;
                i5 = $dirty2 & 112 == 32 ? 1 : i20;
                composer3 = $dirty2 & 896 == 256 ? 1 : i20;
                Composer composer12 = restartGroup;
                int i101 = 0;
                rememberedValue = composer12.rememberedValue();
                int i104 = 0;
                if (i47 |= composer3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i19 = 0;
                        obj3 = rememberedValue;
                        i3 = i67;
                        unconsumedInsets = new SearchBar_androidKt.SearchBarLayout.2.1($i$f$Layout, unconsumedInsets, currentCompositeKeyHash2, finalBackProgress, obj4);
                        composer12.updateRememberedValue((MeasurePolicy)unconsumedInsets);
                    } else {
                        i3 = $dirty2;
                        obj3 = rememberedValue;
                        $dirty = unconsumedInsets;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i31 = i20;
                materializeModifier = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, materializeModifier);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i20);
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(restartGroup, WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(ZIndexModifierKt.zIndex(maybeCachedBoxMeasurePolicy2, 1065353216), (Function1)$i$a$CacheSearchBar_androidKt$SearchBarLayout$1), materialized$iv$iv));
                i70 |= 6;
                kotlin.jvm.functions.Function0 function03 = constructor;
                i26 = 0;
                i7 = i31;
                i19 = i39;
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
                function02 = factory$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i109 = 0;
                obj2 = $dirty;
                Updater.set-impl(constructor-impl, (MeasurePolicy)rememberedValue, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf2 = 0;
                Composer composer13 = constructor-impl;
                int i111 = 0;
                if (!composer13.getInserting()) {
                    $i$f$setImpl = valueOf2;
                    i9 = valueOf;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer13;
                    }
                } else {
                    $i$f$setImpl = valueOf2;
                    i9 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                $dirty2 = restartGroup;
                i27 = i33;
                ComposerKt.sourceInformationMarkerStart($dirty2, 36789781, "C955@42396L85,956@42494L119:SearchBar.android.kt#uh7d8r");
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Surface");
                int i72 = 1;
                int i110 = 390;
                int i112 = 0;
                i25 = i49;
                maybeCachedBoxMeasurePolicy2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($dirty2, 733328855, maybeCachedBoxMeasurePolicy2);
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i72);
                int i117 = 0;
                Alignment alignment2 = topStart;
                ComposerKt.sourceInformationMarkerStart($dirty2, -1323940314, materializeModifier);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($dirty2, 0);
                currentCompositionLocalMap4 = $dirty2.getCurrentCompositionLocalMap();
                int i118 = i72;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($dirty2, layoutId);
                Modifier modifier5 = layoutId;
                kotlin.jvm.functions.Function0 function06 = constructor4;
                int i120 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty2, -692256719, $i$f$Layout);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $dirty2.startReusableNode();
                if ($dirty2.getInserting()) {
                    $dirty2.createNode(function06);
                } else {
                    factory$iv$iv$iv3 = function06;
                    $dirty2.useNode();
                }
                kotlin.jvm.functions.Function0 function07 = factory$iv$iv$iv3;
                Composer constructor-impl2 = Updater.constructor-impl($dirty2);
                int i126 = 0;
                modifier3 = materializeModifier4;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i129 = 0;
                Composer composer16 = constructor-impl2;
                int i133 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap4;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer16;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap4;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = $dirty2;
                int i84 = 0;
                int i127 = i37;
                $changed$iv = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $changed$iv);
                BoxScopeInstance iNSTANCE4 = BoxScopeInstance.INSTANCE;
                i131 |= 6;
                int i135 = 0;
                modifier2 = materializeModifier2;
                Composer materialized$iv$iv2 = composer18;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 1442016074, "C955@42470L9:SearchBar.android.kt#uh7d8r");
                obj6.invoke(materialized$iv$iv2, Integer.valueOf(i51 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                $dirty2.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "InputField");
                int i73 = 1;
                companion = i85;
                ComposerKt.sourceInformationMarkerStart($dirty2, 733328855, maybeCachedBoxMeasurePolicy2);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, i73);
                i10 = 0;
                alignment = i73;
                ComposerKt.sourceInformationMarkerStart($dirty2, -1323940314, materializeModifier);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($dirty2, 0);
                currentCompositionLocalMap3 = $dirty2.getCurrentCompositionLocalMap();
                obj5 = topStart3;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($dirty2, layoutId2);
                i4 = layoutId2;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty2, -692256719, $i$f$Layout);
                if (!applier4 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $dirty2.startReusableNode();
                if ($dirty2.getInserting()) {
                    $dirty2.createNode(function05);
                } else {
                    factory$iv$iv$iv = function05;
                    $dirty2.useNode();
                }
                function0 = factory$iv$iv$iv;
                Composer constructor-impl3 = Updater.constructor-impl($dirty2);
                int i122 = 0;
                map = i93;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i128 = 0;
                Composer composer17 = constructor-impl3;
                int i134 = 0;
                if (!composer17.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap3;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer17;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap3;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = $dirty2;
                obj6 = 0;
                ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i124 |= 6;
                composer7 = 0;
                i = i56;
                modifier4 = materializeModifier3;
                materialized$iv$iv = composer15;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1442132231, "C957@42587L12:SearchBar.android.kt#uh7d8r");
                obj.invoke(materialized$iv$iv, Integer.valueOf(i57 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                $dirty2.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                $dirty2.startReplaceGroup(-1107184481);
                ComposerKt.sourceInformation($dirty2, "*960@42668L127");
                if (content == null) {
                    $composer2 = $dirty2;
                } else {
                    Modifier layoutId3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Content");
                    iNSTANCE = 390;
                    companion = 0;
                    i21 = i75;
                    ComposerKt.sourceInformationMarkerStart($dirty2, 733328855, maybeCachedBoxMeasurePolicy2);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    i11 = 0;
                    alignment = topStart2;
                    ComposerKt.sourceInformationMarkerStart($dirty2, -1323940314, materializeModifier);
                    currentCompositionLocalMap2 = $dirty2.getCurrentCompositionLocalMap();
                    obj57 = currentCompositeKeyHash3;
                    obj5 = layoutId3;
                    kotlin.jvm.functions.Function0 function04 = constructor2;
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty2, -692256719, $i$f$Layout);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $dirty2.startReusableNode();
                    if ($dirty2.getInserting()) {
                        $dirty2.createNode(function04);
                    } else {
                        factory$iv$iv$iv2 = function04;
                        $dirty2.useNode();
                    }
                    Composer constructor-impl4 = Updater.constructor-impl($dirty2);
                    int i106 = 0;
                    function0 = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, true), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i119 = 0;
                    Composer composer14 = constructor-impl4;
                    int i125 = 0;
                    if (!composer14.getInserting()) {
                        $composer2 = $dirty2;
                        map = currentCompositionLocalMap2;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(obj57))) {
                            composer14.updateRememberedValue(Integer.valueOf(obj57));
                            constructor-impl4.apply(Integer.valueOf(obj57), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer5 = composer14;
                        }
                    } else {
                        $composer2 = $dirty2;
                        map = currentCompositionLocalMap2;
                    }
                    Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier($dirty2, layoutId3), ComposeUiNode.Companion.getSetModifier());
                    $dirty2 = $composer2;
                    $composer$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty2, -2146769399, $changed$iv);
                    i90 |= 6;
                    composer3 = $dirty2;
                    i13 = 0;
                    boxScopeInstance = iNSTANCE2;
                    i6 = i41;
                    ComposerKt.sourceInformationMarkerStart($dirty2, 1302856683, "C961@42768L9:SearchBar.android.kt#uh7d8r");
                    content.invoke($dirty2, 0);
                    ComposerKt.sourceInformationMarkerEnd($dirty2);
                    ComposerKt.sourceInformationMarkerEnd($dirty2);
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
                i3 = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SearchBar_androidKt.SearchBarLayout.4(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, modifier, windowInsets, obj, surface, content, i95);
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
        int i3;
        int i;
        int i2;
        int i5 = 0;
        if (layoutDirection != null) {
            i2 = 1;
            i3 = Float.compare(obj12, i6) == 0 ? i2 : i5;
            if (i3 != 0) {
            } else {
                i4 = layoutDirection.getSwipeEdge() == 0 ? i2 : i;
                if (progress == LayoutDirection.Ltr) {
                    i = i2;
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
