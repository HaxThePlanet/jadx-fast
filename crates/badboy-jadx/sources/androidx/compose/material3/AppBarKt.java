package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¶\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0083\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\u001a\u008f\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001al\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001ax\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\u001a \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0007\u001a\u007f\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u008e\u0001\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010;\u001a\u00020\u00012\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=\u001a\u007f\u0010>\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0098\u0001\u0010>\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010?\u001a\u00020\u00012\u0008\u0008\u0002\u0010;\u001a\u00020\u00012\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u001a\u007f\u0010B\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0098\u0001\u0010B\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010?\u001a\u00020\u00012\u0008\u0008\u0002\u0010;\u001a\u00020\u00012\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\u0008C\u0010A\u001a\u0092\u0001\u0010D\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0006\u0010;\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\u0008\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\u0008I\u0010J\u001a\u007f\u0010K\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u008e\u0001\u0010K\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001e\u0008\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010;\u001a\u00020\u00012\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u00107\u001a\u0002082\n\u0008\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\u0008L\u0010=\u001a£\u0001\u0010M\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u001c2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010S\u001a\u0002012\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020H2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\u0008[\u0010\\\u001aµ\u0001\u0010]\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010X\u001a\u00020\u00012\u0011\u0010^\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u0006\u0010_\u001a\u00020F2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\u0008\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0006\u0010?\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\u0008\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\u0008`\u0010a\u001a+\u0010b\u001a\u00020/2\u0008\u0008\u0002\u00100\u001a\u0002012\u0008\u0008\u0002\u00102\u001a\u0002012\u0008\u0008\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010c\u001a+\u0010d\u001a\u00020e2\u0008\u0008\u0002\u00100\u001a\u0002012\u0008\u0008\u0002\u00102\u001a\u0002012\u0008\u0008\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010f\u001a>\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020e2\u0006\u0010j\u001a\u0002012\u000e\u0010k\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010l2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010nH\u0082@¢\u0006\u0002\u0010o\u001a>\u0010p\u001a\u00020h2\u0006\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u0002012\u000e\u0010k\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010l2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010nH\u0082@¢\u0006\u0002\u0010q\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\u0008\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0008\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u000c\u001a\u00020\rX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006r²\u0006\n\u0010s\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020\u001cX\u008a\u0084\u0002", d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "scrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "expandedHeight", "CenterAlignedTopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "collapsedHeight", "LargeTopAppBar-oKE7A98", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumTopAppBar", "MediumTopAppBar-oKE7A98", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "SingleRowTopAppBar-cJHQLPU", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "TopAppBar-GHTll3U", "TopAppBarLayout", "scrolledOffset", "Landroidx/compose/material3/ScrolledOffset;", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ScrolledOffset;JJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "TwoRowsTopAppBar-nS6u9G4", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberBottomAppBarState", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settleAppBarBottom", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release", "colorTransitionFraction", "appBarContainerColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AppBarKt {

    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;
    static {
        int i9 = 0;
        int i18 = 0;
        int i19 = 0;
        AppBarKt.BottomAppBarHorizontalPadding = Dp.constructor-impl($this$dp$iv - $this$dp$iv9);
        int i10 = 0;
        int i20 = 0;
        int i21 = 0;
        AppBarKt.BottomAppBarVerticalPadding = Dp.constructor-impl($this$dp$iv2 - $this$dp$iv10);
        int i11 = 0;
        int i22 = 0;
        AppBarKt.FABHorizontalPadding = Dp.constructor-impl($this$dp$iv3 - $i$f$getDp3);
        int i12 = 0;
        int i23 = 0;
        AppBarKt.FABVerticalPadding = Dp.constructor-impl($this$dp$iv4 - $i$f$getDp4);
        int i30 = 1061997773;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(i30, 0, i30, 1041865114);
        AppBarKt.TopTitleAlphaEasing = cubicBezierEasing;
        int i14 = 0;
        AppBarKt.MediumTitleBottomPadding = Dp.constructor-impl((float)i5);
        int i15 = 0;
        AppBarKt.LargeTitleBottomPadding = Dp.constructor-impl((float)i6);
        int i16 = 0;
        AppBarKt.TopAppBarHorizontalPadding = Dp.constructor-impl((float)i7);
        int i17 = 0;
        int i25 = 0;
        AppBarKt.TopAppBarTitleInset = Dp.constructor-impl($this$dp$iv8 - $i$f$getDp5);
    }

    public static final void BottomAppBar-1oL4kX8(Modifier modifier, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        int $dirty3;
        int $dirty;
        int defaultsInvalid;
        int $dirty5;
        Object $composer2;
        int $dirty4;
        int windowInsets2;
        int containerElevation-D9Ej5fM;
        long $dirty2;
        int i3;
        int i6;
        Object obj3;
        boolean traceInProgress;
        long l2;
        int i9;
        long containerColor2;
        float f;
        int changed3;
        long contentColorFor-ek8zF_U;
        Object obj2;
        Object obj6;
        int changed;
        int i11;
        float tonalElevation2;
        int i7;
        long l;
        int containerColor3;
        Object obj4;
        int i2;
        Object obj7;
        int changed2;
        Object obj;
        float i;
        int i13;
        Object i4;
        int i8;
        Object obj5;
        int i12;
        Composer composer2;
        Composer composer;
        int i5;
        int i14;
        int obj33;
        final int i43 = obj34;
        Composer restartGroup = i10.startRestartGroup(-1391700845);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)807@39959L14,808@40001L31,811@40227L12,814@40294L302:AppBar.kt#uh7d8r");
        $dirty4 = obj34;
        i6 = obj35 & 1;
        if (i6 != 0) {
            $dirty4 |= 6;
            obj3 = modifier;
        } else {
            if (i43 & 6 == 0) {
                i9 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty4 |= i9;
            } else {
                obj3 = modifier;
            }
        }
        if (i43 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed3 = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                containerColor2 = containerColor;
            }
            $dirty4 |= changed3;
        } else {
            containerColor2 = containerColor;
        }
        if (i43 & 384 == 0) {
            if (obj35 & 4 == 0) {
                changed = restartGroup.changed(tonalElevation) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty4 |= changed;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        i11 = obj35 & 8;
        if (i11 != 0) {
            $dirty4 |= 3072;
            tonalElevation2 = windowInsets;
        } else {
            if (i43 & 3072 == 0) {
                i7 = restartGroup.changed(windowInsets) ? 2048 : 1024;
                $dirty4 |= i7;
            } else {
                tonalElevation2 = windowInsets;
            }
        }
        int i45 = obj35 & 16;
        if (i45 != 0) {
            $dirty4 |= 24576;
            obj4 = content;
        } else {
            if (i43 & 24576 == 0) {
                i2 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty4 |= i2;
            } else {
                obj4 = content;
            }
        }
        if (i47 &= i43 == 0) {
            if (obj35 & 32 == 0) {
                changed2 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj7 = $composer;
            }
            $dirty4 |= changed2;
        } else {
            obj7 = $composer;
        }
        i = 1572864;
        if (obj35 & 64 != 0) {
            $dirty4 |= i;
            obj = $changed;
        } else {
            if (i43 & i == 0) {
                i13 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty4 |= i13;
            } else {
                obj = $changed;
            }
        }
        obj33 = $dirty4;
        if ($dirty4 & i4 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                containerElevation-D9Ej5fM = -458753;
                if (i43 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        int i36 = 6;
                        if (obj35 & 2 != 0) {
                            containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, i36);
                            $dirty5 = obj33 & -113;
                        } else {
                            $dirty5 = obj33;
                        }
                        if (obj35 & 4 != 0) {
                            obj33 = containerElevation-D9Ej5fM;
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj6, restartGroup);
                            $dirty5 &= -897;
                        } else {
                            obj33 = containerElevation-D9Ej5fM;
                        }
                        if (i11 != 0) {
                            tonalElevation2 = containerElevation-D9Ej5fM;
                        }
                        if (i45 != 0) {
                            obj4 = containerElevation-D9Ej5fM;
                        }
                        if (obj35 & 32 != 0) {
                            obj5 = windowInsets3;
                            obj7 = contentColorFor-ek8zF_U;
                            i4 = obj4;
                            i3 = -1391700845;
                            windowInsets2 = $dirty7;
                            l = containerColor2;
                            $dirty = i;
                            i = tonalElevation2;
                            tonalElevation2 = obj3;
                        } else {
                            windowInsets2 = $dirty5;
                            i4 = obj4;
                            obj5 = obj7;
                            $dirty = i;
                            i3 = -1391700845;
                            l = containerColor2;
                            obj7 = contentColorFor-ek8zF_U;
                            i = tonalElevation2;
                            tonalElevation2 = obj3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty3 = obj35 & 2 != 0 ? obj33 & -113 : obj33;
                        if (obj35 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (obj35 & 32 != 0) {
                            windowInsets2 = $dirty6;
                            i4 = obj4;
                            obj5 = obj7;
                            $dirty = i;
                            i3 = -1391700845;
                            l = containerColor2;
                            obj7 = contentColorFor-ek8zF_U;
                            i = tonalElevation2;
                            tonalElevation2 = obj3;
                        } else {
                            windowInsets2 = $dirty3;
                            i4 = obj4;
                            obj5 = obj7;
                            $dirty = i;
                            i3 = -1391700845;
                            l = containerColor2;
                            obj7 = contentColorFor-ek8zF_U;
                            i = tonalElevation2;
                            tonalElevation2 = obj3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i3, windowInsets2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:814)");
                }
                AppBarKt.BottomAppBar-e-3WI5M(tonalElevation2, l, obj4, obj7, obj, i, i4, obj5, 0, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                containerColor3 = windowInsets2;
                $dirty2 = l3;
                $composer2 = tonalElevation2;
                l2 = obj7;
                f = i;
                obj2 = i4;
                obj6 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                containerColor3 = obj33;
                composer = restartGroup;
                $composer2 = obj3;
                $dirty2 = containerColor2;
                l2 = contentColorFor-ek8zF_U;
                f = tonalElevation2;
                obj2 = obj4;
                obj6 = obj7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.BottomAppBar.4($composer2, $dirty2, i6, l2, containerColor2, f, obj2, obj6, $changed, i43, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void BottomAppBar-Snr_uVM(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, Composer $composer, int $changed, int i11) {
        Object obj5;
        Object obj6;
        int traceInProgress2;
        int contentPadding3;
        int defaultsInvalid;
        int iNSTANCE;
        int containerElevation-D9Ej5fM;
        Object contentPadding2;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int i14;
        boolean traceInProgress;
        Object obj2;
        Object str;
        long l2;
        int i3;
        int windowInsets3;
        Object obj4;
        long l;
        int i10;
        long containerColor2;
        float f2;
        int changed2;
        long contentColorFor-ek8zF_U;
        PaddingValues paddingValues;
        WindowInsets windowInsets2;
        Object obj7;
        int i9;
        int changed;
        Object i2;
        float tonalElevation2;
        int i13;
        long i8;
        int i12;
        int i4;
        int changed3;
        long i5;
        float f;
        Object obj3;
        Object obj;
        int i6;
        Composer composer;
        int i;
        int i7;
        final int i51 = obj38;
        final int i52 = obj39;
        restartGroup = i11.startRestartGroup(2141738945);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)678@33855L14,679@33897L31,682@34123L12,684@34145L355:AppBar.kt#uh7d8r");
        $dirty = obj38;
        if (i52 & 1 != 0) {
            $dirty |= 6;
            obj7 = actions;
        } else {
            if (i51 & 6 == 0) {
                i14 = restartGroup.changedInstance(actions) ? 4 : 2;
                $dirty |= i14;
            } else {
                obj7 = actions;
            }
        }
        int i30 = i52 & 2;
        if (i30 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i51 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                str = modifier;
            }
        }
        windowInsets3 = i52 & 4;
        if (windowInsets3 != 0) {
            $dirty |= 384;
            obj4 = floatingActionButton;
        } else {
            if (i51 & 384 == 0) {
                i10 = restartGroup.changedInstance(floatingActionButton) ? 256 : 128;
                $dirty |= i10;
            } else {
                obj4 = floatingActionButton;
            }
        }
        if (i51 & 3072 == 0) {
            if (i52 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= changed2;
        } else {
            containerColor2 = containerColor;
        }
        if (i51 & 24576 == 0) {
            if (i52 & 16 == 0) {
                changed = restartGroup.changed(tonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty |= changed;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        i2 = i52 & 32;
        int i54 = 196608;
        if (i2 != 0) {
            $dirty |= i54;
            tonalElevation2 = windowInsets;
        } else {
            if (i54 &= i51 == 0) {
                i13 = restartGroup.changed(windowInsets) ? 131072 : 65536;
                $dirty |= i13;
            } else {
                tonalElevation2 = windowInsets;
            }
        }
        i8 = i52 & 64;
        i12 = 1572864;
        if (i8 != 0) {
            $dirty |= i12;
            obj5 = $composer;
        } else {
            if (i51 & i12 == 0) {
                i4 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty |= i4;
            } else {
                obj5 = $composer;
            }
        }
        if (i51 & i56 == 0) {
            if (i52 & 128 == 0) {
                changed3 = restartGroup.changed($changed) ? 8388608 : 4194304;
            } else {
                obj6 = $changed;
            }
            $dirty |= changed3;
        } else {
            obj6 = $changed;
        }
        if ($dirty & i5 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i32 = -29360129;
                int i57 = -57345;
                if (i51 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            str = defaultsInvalid;
                        }
                        if (windowInsets3 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        windowInsets3 = 6;
                        if (i52 & 8 != 0) {
                            containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, windowInsets3);
                            $dirty &= -7169;
                        }
                        if (i52 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj8, restartGroup);
                            $dirty &= i57;
                        }
                        if (i2 != 0) {
                            tonalElevation2 = containerElevation-D9Ej5fM;
                        }
                        if (i8 != 0) {
                            contentPadding2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = $composer;
                        }
                        if (i52 & 128 != 0) {
                            $dirty &= i32;
                            obj3 = contentPadding2;
                            i2 = str;
                            obj = windowInsets3;
                            i8 = containerColor2;
                            i5 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding3 = 2141738945;
                            tonalElevation2 = obj4;
                        } else {
                            obj = $changed;
                            obj3 = contentPadding2;
                            i2 = str;
                            i8 = containerColor2;
                            i5 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding3 = 2141738945;
                            tonalElevation2 = obj4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i52 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i52 & 16 != 0) {
                            $dirty &= i57;
                        }
                        if (i52 & 128 != 0) {
                            obj3 = $composer;
                            obj = $changed;
                            $dirty = i19;
                            i2 = str;
                            i8 = containerColor2;
                            i5 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding3 = 2141738945;
                            tonalElevation2 = obj4;
                        } else {
                            obj3 = $composer;
                            obj = $changed;
                            i2 = str;
                            i8 = containerColor2;
                            i5 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding3 = 2141738945;
                            tonalElevation2 = obj4;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentPadding3, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:684)");
                }
                AppBarKt.BottomAppBar-qhFBPw4(obj7, i2, tonalElevation2, i8, i12, i5, obj19, f, obj3, obj, 0, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = $dirty;
                $dirty2 = i2;
                obj2 = tonalElevation2;
                l2 = i8;
                l = i5;
                f2 = f;
                paddingValues = obj3;
                windowInsets2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                i9 = $dirty;
                $dirty2 = str;
                obj2 = obj4;
                l2 = containerColor2;
                l = contentColorFor-ek8zF_U;
                f2 = tonalElevation2;
                paddingValues = $composer;
                windowInsets2 = $changed;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.BottomAppBar.1(actions, $dirty2, obj2, l2, windowInsets3, l, containerColor2, f2, paddingValues, windowInsets2, i51, i52);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void BottomAppBar-e-3WI5M(Modifier modifier, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, androidx.compose.material3.BottomAppBarScrollBehavior scrollBehavior, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj;
        Object obj6;
        int i9;
        WindowInsets $dirty4;
        int $dirty5;
        int defaultsInvalid;
        int $dirty2;
        Object $composer2;
        int $dirty;
        long l;
        int empty2;
        Object $i$a$CacheAppBarKt$BottomAppBar$appBarDragModifier$2;
        int empty;
        Modifier draggable$default;
        int tonalElevation3;
        int i17;
        float tonalElevation4;
        Object obj3;
        long modifier2;
        int i19;
        long containerColor2;
        int $dirty3;
        float f;
        int i15;
        int i7;
        Object $i$a$CacheAppBarKt$BottomAppBar$5;
        Object empty3;
        int changed3;
        long contentColorFor-ek8zF_U;
        Object obj2;
        int contentColor2;
        Composer i2;
        WindowInsets windowInsets2;
        boolean traceInProgress;
        int changed2;
        int contentPadding2;
        Object contentPadding3;
        float windowInsets3;
        Object anon;
        int i14;
        int i10;
        androidx.compose.ui.graphics.Shape rememberedValue;
        Object obj4;
        int i13;
        int i4;
        int changed;
        long i;
        int i8;
        int tonalElevation2;
        float f2;
        int i21;
        int companion;
        int i5;
        Object rememberDraggableState;
        Composer composer;
        Orientation vertical;
        int companion2;
        int i6;
        int i3;
        int i18;
        Object obj5;
        int i12;
        int i16;
        int i20;
        int obj32;
        int obj33;
        int obj35;
        int obj36;
        int obj37;
        final Object obj8 = $changed;
        final int i59 = obj43;
        final int i60 = obj44;
        Composer restartGroup = i11.startRestartGroup(422438773);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp,3,7,5)860@42630L14,861@42672L31,864@42898L12,896@44292L5,899@44363L596,911@45008L364,891@44025L1347:AppBar.kt#uh7d8r");
        $dirty = obj43;
        tonalElevation3 = i60 & 1;
        if (tonalElevation3 != 0) {
            $dirty |= 6;
            obj3 = modifier;
        } else {
            if (i59 & 6 == 0) {
                i19 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i19;
            } else {
                obj3 = modifier;
            }
        }
        if (i59 & 48 == 0) {
            if (i60 & 2 == 0) {
                changed3 = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= changed3;
        } else {
            containerColor2 = containerColor;
        }
        if (i59 & 384 == 0) {
            if (i60 & 4 == 0) {
                changed2 = restartGroup.changed(tonalElevation) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty |= changed2;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        int i58 = i60 & 8;
        if (i58 != 0) {
            $dirty |= 3072;
            windowInsets3 = windowInsets;
        } else {
            if (i59 & 3072 == 0) {
                i10 = restartGroup.changed(windowInsets) ? 2048 : 1024;
                $dirty |= i10;
            } else {
                windowInsets3 = windowInsets;
            }
        }
        rememberedValue = i60 & 16;
        if (rememberedValue != 0) {
            $dirty |= 24576;
            obj4 = scrollBehavior;
        } else {
            if (i59 & 24576 == 0) {
                i13 = restartGroup.changed(scrollBehavior) ? 16384 : 8192;
                $dirty |= i13;
            } else {
                obj4 = scrollBehavior;
            }
        }
        if (i59 & i64 == 0) {
            if (i60 & 32 == 0) {
                changed = restartGroup.changed(content) ? 131072 : 65536;
            } else {
                obj = content;
            }
            $dirty |= changed;
        } else {
            obj = content;
        }
        i = i60 & 64;
        i8 = 1572864;
        if (i != 0) {
            $dirty |= i8;
            obj6 = $composer;
        } else {
            if (i59 & i8 == 0) {
                i8 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                obj6 = $composer;
            }
        }
        int i65 = 12582912;
        if (i60 & 128 != 0) {
            $dirty |= i65;
        } else {
            if (i59 & i65 == 0) {
                i9 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i9;
            }
        }
        tonalElevation2 = $dirty;
        if (i23 &= $dirty == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                companion = -458753;
                empty2 = 6;
                if (i59 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (tonalElevation3 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i60 & 2 != 0) {
                            containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, empty2);
                            $dirty2 = tonalElevation2 & -113;
                        } else {
                            $dirty2 = tonalElevation2;
                        }
                        if (i60 & 4 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj6, restartGroup);
                            $dirty2 &= -897;
                        }
                        if (i58 != 0) {
                            tonalElevation4 = BottomAppBarDefaults.INSTANCE.getContainerElevation-D9Ej5fM();
                        } else {
                            tonalElevation4 = windowInsets3;
                        }
                        if (rememberedValue != 0) {
                            contentPadding3 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding3 = obj4;
                        }
                        if (i60 & 32 != 0) {
                            windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(restartGroup, empty2);
                            $dirty2 &= companion;
                        } else {
                            windowInsets3 = content;
                        }
                        if (i != 0) {
                            f2 = tonalElevation4;
                            obj4 = containerColor2;
                            tonalElevation3 = rememberedValue;
                            i15 = i65;
                            $dirty3 = $dirty2;
                            i = contentColorFor-ek8zF_U;
                            $dirty4 = windowInsets3;
                            contentColor2 = 422438773;
                        } else {
                            f2 = tonalElevation4;
                            obj4 = containerColor2;
                            i15 = i65;
                            tonalElevation3 = $composer;
                            $dirty3 = $dirty2;
                            i = contentColorFor-ek8zF_U;
                            $dirty4 = windowInsets3;
                            contentColor2 = 422438773;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty5 = i60 & 2 != 0 ? tonalElevation2 & -113 : tonalElevation2;
                        if (i60 & 4 != 0) {
                            $dirty5 &= -897;
                        }
                        if (i60 & 32 != 0) {
                            $dirty5 &= companion;
                        }
                        tonalElevation3 = $composer;
                        f2 = windowInsets3;
                        contentPadding3 = obj4;
                        obj4 = containerColor2;
                        i15 = i65;
                        $dirty3 = $dirty5;
                        i = contentColorFor-ek8zF_U;
                        contentColor2 = 422438773;
                        $dirty4 = content;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentColor2, $dirty3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:867)");
                }
                restartGroup.startReplaceGroup(1393560009);
                ComposerKt.sourceInformation(restartGroup, "874@43358L55,874@43335L78,875@43447L289");
                i2 = 3670016;
                String str3 = "CC(remember):AppBar.kt#9igjgp";
                if (tonalElevation3 != 0 && !tonalElevation3.isPinned()) {
                    if (!tonalElevation3.isPinned()) {
                        obj32 = i15;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1393566103, str3);
                        i7 = $dirty3 & i2 == 1048576 ? 1 : 0;
                        Composer composer3 = restartGroup;
                        int i66 = 0;
                        Object rememberedValue3 = composer3.rememberedValue();
                        int i67 = 0;
                        if (i7 == 0) {
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                anon = new AppBarKt.BottomAppBar.appBarDragModifier.1.1(tonalElevation3);
                                composer3.updateRememberedValue((Function1)anon);
                            } else {
                                anon = rememberedValue3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        empty = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1393569185, str3);
                        i15 = $dirty3 & obj33 == 1048576 ? 1 : empty;
                        i2 = restartGroup;
                        windowInsets3 = 0;
                        rememberedValue = i2.rememberedValue();
                        companion = 0;
                        if (i15 == 0) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                obj36 = i26;
                                obj37 = $dirty3;
                                $i$a$CacheAppBarKt$BottomAppBar$appBarDragModifier$2 = new AppBarKt.BottomAppBar.appBarDragModifier.2.1(tonalElevation3, 0);
                                i2.updateRememberedValue((Function3)$i$a$CacheAppBarKt$BottomAppBar$appBarDragModifier$2);
                            } else {
                                obj37 = $dirty3;
                                $i$a$CacheAppBarKt$BottomAppBar$appBarDragModifier$2 = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        draggable$default = DraggableKt.draggable$default((Modifier)Modifier.Companion, DraggableKt.rememberDraggableState((Function1)anon, restartGroup, empty), Orientation.Vertical, false, 0, false, 0, (Function3)$i$a$CacheAppBarKt$BottomAppBar$appBarDragModifier$2, false, 188, 0);
                    } else {
                        obj37 = $dirty3;
                        obj32 = i15;
                        obj33 = i2;
                        draggable$default = Modifier.Companion;
                    }
                } else {
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1393598804, str3);
                i14 = obj37 & obj33 == 1048576 ? 1 : 0;
                Composer composer2 = restartGroup;
                empty3 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i56 = 0;
                if (i14 == 0) {
                    obj33 = empty3;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        obj35 = $i$f$cache;
                        $i$a$CacheAppBarKt$BottomAppBar$5 = new AppBarKt.BottomAppBar.5.1(tonalElevation3);
                        composer2.updateRememberedValue((Function3)$i$a$CacheAppBarKt$BottomAppBar$5);
                    } else {
                        $i$a$CacheAppBarKt$BottomAppBar$5 = rememberedValue2;
                    }
                } else {
                    obj33 = empty3;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AppBarKt.BottomAppBar.6 anon2 = new AppBarKt.BottomAppBar.6($dirty4, contentPadding3, obj8);
                SurfaceKt.Surface-T9BRK9s(LayoutModifierKt.layout(obj3, (Function3)$i$a$CacheAppBarKt$BottomAppBar$5).then(draggable$default), ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), restartGroup, 6), obj4, i4, i, i65, f2, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1243053520, true, anon2, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = $dirty4;
                $composer2 = obj3;
                obj2 = contentPadding3;
                modifier2 = i;
                f = f2;
                tonalElevation2 = obj37;
                contentPadding2 = tonalElevation3;
                l = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                contentPadding2 = $composer;
                composer = restartGroup;
                $composer2 = obj3;
                l = containerColor2;
                modifier2 = contentColorFor-ek8zF_U;
                f = windowInsets3;
                obj2 = obj4;
                windowInsets2 = content;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = new AppBarKt.BottomAppBar.7($composer2, l, tonalElevation3, modifier2, containerColor2, f, obj2, windowInsets2, contentPadding2, obj8, i59, i60);
            endRestartGroup.updateScope((Function2)$dirty4);
        }
    }

    public static final void BottomAppBar-qhFBPw4(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, androidx.compose.material3.BottomAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i12) {
        Object obj3;
        Object obj2;
        Object obj6;
        int traceInProgress2;
        int contentPadding2;
        int defaultsInvalid;
        int iNSTANCE2;
        int containerElevation-D9Ej5fM;
        Object contentPadding3;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i8;
        int i4;
        long l2;
        Object obj4;
        boolean traceInProgress;
        int i3;
        WindowInsets windowInsets4;
        long l;
        Object obj5;
        int i11;
        long containerColor2;
        float f;
        PaddingValues paddingValues;
        int changed2;
        long contentColorFor-ek8zF_U;
        WindowInsets windowInsets2;
        int i;
        int changed3;
        Object obj;
        int iNSTANCE;
        int modifier2;
        float tonalElevation2;
        int i6;
        int i2;
        int i5;
        int changed;
        int i13;
        int i9;
        PaddingValues i15;
        WindowInsets windowInsets3;
        int i10;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i14;
        int i7;
        final Object obj7 = actions;
        final int i60 = obj39;
        final int i61 = obj40;
        Composer restartGroup = i12.startRestartGroup(-1044837119);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)743@37109L14,744@37151L31,747@37377L12,758@37741L539,750@37455L825:AppBar.kt#uh7d8r");
        $dirty = obj39;
        if (i61 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i60 & 6 == 0) {
                i8 = restartGroup.changedInstance(obj7) ? 4 : 2;
                $dirty |= i8;
            }
        }
        int i30 = i61 & 2;
        if (i30 != 0) {
            $dirty |= 48;
            obj4 = modifier;
        } else {
            if (i60 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                obj4 = modifier;
            }
        }
        windowInsets4 = i61 & 4;
        if (windowInsets4 != 0) {
            $dirty |= 384;
            obj5 = floatingActionButton;
        } else {
            if (i60 & 384 == 0) {
                i11 = restartGroup.changedInstance(floatingActionButton) ? 256 : 128;
                $dirty |= i11;
            } else {
                obj5 = floatingActionButton;
            }
        }
        if (i60 & 3072 == 0) {
            if (i61 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= changed2;
        } else {
            containerColor2 = containerColor;
        }
        if (i60 & 24576 == 0) {
            if (i61 & 16 == 0) {
                changed3 = restartGroup.changed(tonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty |= changed3;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        int i62 = i61 & 32;
        int i63 = 196608;
        if (i62 != 0) {
            $dirty |= i63;
            tonalElevation2 = windowInsets;
        } else {
            if (i63 &= i60 == 0) {
                i6 = restartGroup.changed(windowInsets) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                tonalElevation2 = windowInsets;
            }
        }
        int i65 = i61 & 64;
        i2 = 1572864;
        if (i65 != 0) {
            $dirty |= i2;
            obj3 = scrollBehavior;
        } else {
            if (i60 & i2 == 0) {
                i5 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty |= i5;
            } else {
                obj3 = scrollBehavior;
            }
        }
        int i66 = 12582912;
        if (i60 & i66 == 0) {
            if (i61 & 128 == 0) {
                changed = restartGroup.changed($composer) ? 8388608 : 4194304;
            } else {
                obj2 = $composer;
            }
            $dirty |= changed;
        } else {
            obj2 = $composer;
        }
        int i18 = i61 & 256;
        int i67 = 100663296;
        if (i18 != 0) {
            $dirty |= i67;
            i13 = i18;
            obj6 = $changed;
        } else {
            if (i60 & i67 == 0) {
                i13 = i18;
                i9 = restartGroup.changed($changed) ? 67108864 : 33554432;
                $dirty |= i9;
            } else {
                i13 = i18;
                obj6 = $changed;
            }
        }
        if ($dirty & i15 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i32 = -29360129;
                int i69 = -57345;
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        if (windowInsets4 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        int i53 = 6;
                        if (i61 & 8 != 0) {
                            containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, i53);
                            $dirty &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj9, restartGroup);
                            $dirty &= i69;
                        }
                        if (i62 != 0) {
                            tonalElevation2 = containerElevation-D9Ej5fM;
                        }
                        if (i65 != 0) {
                            contentPadding3 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding3 = scrollBehavior;
                        }
                        if (i61 & 128 != 0) {
                            windowInsets4 = BottomAppBarDefaults.INSTANCE.getWindowInsets(restartGroup, i53);
                            $dirty &= i32;
                        } else {
                            windowInsets4 = $composer;
                        }
                        if (i13 != 0) {
                            i15 = contentPadding3;
                            i10 = i47;
                            obj = obj4;
                            windowInsets3 = windowInsets4;
                            i13 = tonalElevation2;
                            contentPadding2 = i66;
                            i4 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i2 = contentColorFor-ek8zF_U;
                        } else {
                            i10 = $changed;
                            i15 = contentPadding3;
                            obj = obj4;
                            windowInsets3 = windowInsets4;
                            i13 = tonalElevation2;
                            contentPadding2 = i66;
                            i4 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i2 = contentColorFor-ek8zF_U;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            $dirty &= i69;
                        }
                        if (i61 & 128 != 0) {
                            i15 = scrollBehavior;
                            windowInsets3 = $composer;
                            i10 = $changed;
                            $dirty = i29;
                            obj = obj4;
                            i13 = tonalElevation2;
                            contentPadding2 = i66;
                            i4 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i2 = contentColorFor-ek8zF_U;
                        } else {
                            i15 = scrollBehavior;
                            windowInsets3 = $composer;
                            i10 = $changed;
                            obj = obj4;
                            i13 = tonalElevation2;
                            contentPadding2 = i66;
                            i4 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i2 = contentColorFor-ek8zF_U;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i4, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:750)");
                }
                AppBarKt.BottomAppBar.2 anon = new AppBarKt.BottomAppBar.2(obj7, obj5);
                AppBarKt.BottomAppBar-e-3WI5M(obj, tonalElevation2, i65, i2, i66, i13, i15, windowInsets3, i10, (Function3)ComposableLambdaKt.rememberComposableLambda(1566394874, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj;
                l2 = tonalElevation2;
                f = i13;
                paddingValues = i15;
                windowInsets2 = windowInsets3;
                i = i10;
                modifier2 = $dirty;
                $dirty2 = obj5;
                l = i2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                modifier2 = $dirty;
                $composer2 = obj4;
                $dirty2 = obj5;
                l2 = containerColor2;
                l = contentColorFor-ek8zF_U;
                f = tonalElevation2;
                paddingValues = scrollBehavior;
                windowInsets2 = $composer;
                i = $changed;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.BottomAppBar.3(obj7, $composer2, $dirty2, l2, obj4, l, obj5, f, paddingValues, windowInsets2, i, i60, i61);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final androidx.compose.material3.BottomAppBarState BottomAppBarState(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset) {
        BottomAppBarStateImpl bottomAppBarStateImpl = new BottomAppBarStateImpl(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
        return (BottomAppBarState)bottomAppBarStateImpl;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter")
    public static final void CenterAlignedTopAppBar(Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier3;
        int modifier4;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i8;
        Object obj;
        int windowInsets3;
        int windowInsets4;
        boolean traceInProgress;
        Object str;
        Object obj7;
        int i6;
        Object obj6;
        Object obj5;
        Object obj2;
        int i2;
        Object obj9;
        Object obj10;
        Object obj4;
        int modifier2;
        Object actions2;
        int i4;
        Object windowInsets2;
        int changed2;
        Object colors2;
        int changed;
        float topAppBarExpandedHeight-D9Ej5fM;
        Object obj3;
        int i;
        Object i7;
        Object obj8;
        Composer composer;
        int i3;
        int i5;
        final int i37 = $changed;
        restartGroup = $composer.startRestartGroup(-2139286460);
        ComposerKt.sourceInformation(restartGroup, "C(CenterAlignedTopAppBar)P(5,2,3!1,6)269@12968L12,270@13030L30,273@13122L319:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj10 = title;
        } else {
            if (i37 & 6 == 0) {
                i8 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty2 |= i8;
            } else {
                obj10 = title;
            }
        }
        windowInsets3 = i10 & 2;
        if (windowInsets3 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i37 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                str = modifier;
            }
        }
        int i34 = i10 & 4;
        if (i34 != 0) {
            $dirty2 |= 384;
            obj5 = navigationIcon;
        } else {
            if (i37 & 384 == 0) {
                i2 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                obj5 = navigationIcon;
            }
        }
        int i36 = i10 & 8;
        if (i36 != 0) {
            $dirty2 |= 3072;
            obj4 = actions;
        } else {
            if (i37 & 3072 == 0) {
                i4 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                obj4 = actions;
            }
        }
        if (i37 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed2 = restartGroup.changed(windowInsets) ? 16384 : 8192;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= changed2;
        } else {
            windowInsets2 = windowInsets;
        }
        if (i41 &= i37 == 0) {
            if (i10 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed;
        } else {
            colors2 = colors;
        }
        topAppBarExpandedHeight-D9Ej5fM = i10 & 64;
        int i44 = 1572864;
        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
            $dirty2 |= i44;
            obj3 = scrollBehavior;
        } else {
            if (i44 &= i37 == 0) {
                i = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty2 |= i;
            } else {
                obj3 = scrollBehavior;
            }
        }
        if (i46 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i47 = -458753;
                int i48 = -57345;
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (windowInsets3 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = str;
                        }
                        if (i34 != 0) {
                            obj5 = windowInsets3;
                        }
                        if (i36 != 0) {
                            obj4 = windowInsets3;
                        }
                        str = 6;
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                            windowInsets2 = windowInsets4;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 &= i47;
                            colors2 = windowInsets3;
                        }
                        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
                            obj8 = windowInsets3;
                            obj3 = windowInsets2;
                            i7 = colors2;
                            windowInsets2 = obj5;
                            colors2 = obj4;
                            actions2 = modifier3;
                            modifier4 = -2139286460;
                        } else {
                            i7 = colors2;
                            obj8 = obj3;
                            colors2 = obj4;
                            obj3 = windowInsets2;
                            actions2 = modifier3;
                            windowInsets2 = obj5;
                            modifier4 = -2139286460;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 = i13;
                            i7 = colors2;
                            obj8 = obj3;
                            modifier4 = -2139286460;
                            colors2 = obj4;
                            obj3 = windowInsets2;
                            actions2 = str;
                            windowInsets2 = obj5;
                        } else {
                            i7 = colors2;
                            obj8 = obj3;
                            modifier4 = -2139286460;
                            colors2 = obj4;
                            obj3 = windowInsets2;
                            actions2 = str;
                            windowInsets2 = obj5;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier4, $dirty2, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:273)");
                }
                AppBarKt.CenterAlignedTopAppBar-GHTll3U(obj10, actions2, windowInsets2, colors2, TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM(), obj3, i7, obj8, restartGroup, i20 | i29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = $dirty2;
                $dirty = companion;
                obj = windowInsets2;
                obj7 = colors2;
                obj6 = obj3;
                obj2 = i7;
                obj9 = obj8;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = $dirty2;
                $dirty = str;
                obj7 = obj12;
                composer = restartGroup;
                obj = obj5;
                obj6 = windowInsets2;
                obj2 = colors2;
                obj9 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.CenterAlignedTopAppBar.1(title, $dirty, obj, obj7, obj6, obj2, obj9, i37, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void CenterAlignedTopAppBar-GHTll3U(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i11) {
        Object obj3;
        int $dirty5;
        int $dirty4;
        int defaultsInvalid;
        Object modifier3;
        boolean traceInProgress2;
        int $dirty3;
        boolean topAppBarExpandedHeight-D9Ej5fM;
        Object obj4;
        int i4;
        int i2;
        int topAppBarExpandedHeight-D9Ej5fM2;
        int windowInsets2;
        int centerAlignedTopAppBarColors;
        Object obj8;
        Object obj9;
        int $dirty2;
        Object $dirty;
        int i5;
        boolean traceInProgress;
        float f;
        Object str;
        Object obj7;
        int i7;
        Object obj11;
        Object obj6;
        int i;
        int i12;
        Object obj2;
        int modifier2;
        Object obj5;
        float value;
        int i13;
        Object obj10;
        int changed2;
        Object colors2;
        int changed;
        int i8;
        int i9;
        Object i3;
        Object obj;
        int obj12;
        Composer composer;
        int i10;
        int i6;
        final int i50 = $changed;
        final int i51 = i11;
        traceInProgress2 = $composer.startRestartGroup(1952988048);
        ComposerKt.sourceInformation(traceInProgress2, "C(CenterAlignedTopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)328@16080L12,329@16142L30,335@16365L5,332@16234L578:AppBar.kt#uh7d8r");
        $dirty3 = $changed;
        if (i51 & 1 != 0) {
            $dirty3 |= 6;
            obj5 = title;
        } else {
            if (i50 & 6 == 0) {
                i4 = traceInProgress2.changedInstance(title) ? 4 : 2;
                $dirty3 |= i4;
            } else {
                obj5 = title;
            }
        }
        topAppBarExpandedHeight-D9Ej5fM2 = i51 & 2;
        if (topAppBarExpandedHeight-D9Ej5fM2 != 0) {
            $dirty3 |= 48;
            obj9 = modifier;
        } else {
            if (i50 & 48 == 0) {
                i5 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty3 |= i5;
            } else {
                obj9 = modifier;
            }
        }
        int i41 = i51 & 4;
        if (i41 != 0) {
            $dirty3 |= 384;
            str = navigationIcon;
        } else {
            if (i50 & 384 == 0) {
                i7 = traceInProgress2.changedInstance(navigationIcon) ? 256 : 128;
                $dirty3 |= i7;
            } else {
                str = navigationIcon;
            }
        }
        int i48 = i51 & 8;
        if (i48 != 0) {
            $dirty3 |= 3072;
            obj6 = actions;
        } else {
            if (i50 & 3072 == 0) {
                i12 = traceInProgress2.changedInstance(actions) ? 2048 : 1024;
                $dirty3 |= i12;
            } else {
                obj6 = actions;
            }
        }
        int i52 = i51 & 16;
        if (i52 != 0) {
            $dirty3 |= 24576;
            value = expandedHeight;
        } else {
            if (i50 & 24576 == 0) {
                i13 = traceInProgress2.changed(expandedHeight) ? 16384 : 8192;
                $dirty3 |= i13;
            } else {
                value = expandedHeight;
            }
        }
        if (i54 &= i50 == 0) {
            if (i51 & 32 == 0) {
                changed2 = traceInProgress2.changed(windowInsets) ? 131072 : 65536;
            } else {
                obj10 = windowInsets;
            }
            $dirty3 |= changed2;
        } else {
            obj10 = windowInsets;
        }
        if (i57 &= i50 == 0) {
            if (i51 & 64 == 0) {
                changed = traceInProgress2.changed(colors) ? 1048576 : 524288;
            } else {
                colors2 = colors;
            }
            $dirty3 |= changed;
        } else {
            colors2 = colors;
        }
        int i15 = i51 & 128;
        int i60 = 12582912;
        if (i15 != 0) {
            $dirty3 |= i60;
            i8 = i15;
            obj3 = scrollBehavior;
        } else {
            if (i50 & i60 == 0) {
                i8 = i15;
                i9 = traceInProgress2.changed(scrollBehavior) ? 8388608 : 4194304;
                $dirty3 |= i9;
            } else {
                i8 = i15;
                obj3 = scrollBehavior;
            }
        }
        final int obj32 = $dirty3;
        if ($dirty3 & i3 == 4793490) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i62 = -458753;
                int i63 = -3670017;
                int i17 = 6;
                if (i50 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (topAppBarExpandedHeight-D9Ej5fM2 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj9;
                        }
                        if (i41 != 0) {
                            str = topAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i48 != 0) {
                            obj6 = topAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i52 != 0) {
                            value = topAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i51 & 32 != 0) {
                            $dirty2 = obj32 & i62;
                            obj10 = windowInsets2;
                        } else {
                            $dirty2 = obj32;
                        }
                        if (i51 & 64 != 0) {
                            $dirty2 &= i63;
                            colors2 = centerAlignedTopAppBarColors;
                        }
                        if (i8 != 0) {
                            obj2 = modifier3;
                            obj12 = i39;
                            changed = obj6;
                            $dirty5 = value;
                            i3 = obj10;
                            obj = colors2;
                            i2 = 1952988048;
                            colors2 = str;
                        } else {
                            obj12 = scrollBehavior;
                            obj2 = modifier3;
                            changed = obj6;
                            $dirty5 = value;
                            i3 = obj10;
                            obj = colors2;
                            i2 = 1952988048;
                            colors2 = str;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty4 = i51 & 32 != 0 ? obj32 & i62 : obj32;
                        if (i51 & 64 != 0) {
                            $dirty4 &= i63;
                        }
                        obj12 = scrollBehavior;
                        obj2 = obj9;
                        changed = obj6;
                        i3 = obj10;
                        obj = colors2;
                        i2 = 1952988048;
                        $dirty2 = $dirty4;
                        colors2 = str;
                        $dirty5 = value;
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i2, $dirty2, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:332)");
                }
                if (!Dp.equals-impl0($dirty5, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty5, Dp.Companion.getInfinity-D9Ej5fM())) {
                        i8 = topAppBarExpandedHeight-D9Ej5fM;
                    } else {
                        i8 = $dirty5;
                    }
                } else {
                }
                AppBarKt.SingleRowTopAppBar-cJHQLPU(obj2, obj5, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress2, i17), true, colors2, changed, i8, i3, obj, obj12, traceInProgress2, i25 | i38, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f = $dirty5;
                obj4 = obj2;
                obj8 = colors2;
                obj7 = i3;
                obj11 = obj;
                i = obj12;
                modifier2 = $dirty2;
                $dirty = changed;
            } else {
                traceInProgress2.skipToGroupEnd();
                modifier2 = obj32;
                composer = traceInProgress2;
                obj4 = obj9;
                obj8 = str;
                $dirty = obj6;
                f = value;
                obj7 = obj10;
                obj11 = colors2;
                i = scrollBehavior;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = new AppBarKt.CenterAlignedTopAppBar.2(title, obj4, obj8, $dirty, f, obj7, obj11, i, i50, i51);
            endRestartGroup.updateScope((Function2)$dirty5);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final void LargeTopAppBar(Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int i7;
        Object obj2;
        int windowInsets4;
        int windowInsets3;
        boolean traceInProgress2;
        Object str;
        Object obj7;
        int i6;
        Object obj3;
        Object obj8;
        Object obj5;
        int i3;
        Object obj4;
        Object obj;
        Object obj6;
        int modifier4;
        Object actions2;
        int i5;
        Object windowInsets2;
        int changed2;
        Object colors2;
        int changed;
        float largeAppBarCollapsedHeight-D9Ej5fM;
        Object largeAppBarExpandedHeight-D9Ej5fM;
        int i2;
        Object i;
        Object obj9;
        Object obj10;
        Composer composer;
        int i8;
        int i4;
        final int i38 = $changed;
        restartGroup = $composer.startRestartGroup(-474540752);
        ComposerKt.sourceInformation(restartGroup, "C(LargeTopAppBar)P(5,2,3!1,6)541@26855L12,542@26917L22,545@27001L385:AppBar.kt#uh7d8r");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            obj = title;
        } else {
            if (i38 & 6 == 0) {
                i7 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj = title;
            }
        }
        windowInsets4 = i10 & 2;
        if (windowInsets4 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i38 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i6;
            } else {
                str = modifier;
            }
        }
        int i35 = i10 & 4;
        if (i35 != 0) {
            $dirty |= 384;
            obj8 = navigationIcon;
        } else {
            if (i38 & 384 == 0) {
                i3 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty |= i3;
            } else {
                obj8 = navigationIcon;
            }
        }
        int i37 = i10 & 8;
        if (i37 != 0) {
            $dirty |= 3072;
            obj6 = actions;
        } else {
            if (i38 & 3072 == 0) {
                i5 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                obj6 = actions;
            }
        }
        if (i38 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed2 = restartGroup.changed(windowInsets) ? 16384 : 8192;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= changed2;
        } else {
            windowInsets2 = windowInsets;
        }
        if (i42 &= i38 == 0) {
            if (i10 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty |= changed;
        } else {
            colors2 = colors;
        }
        largeAppBarCollapsedHeight-D9Ej5fM = i10 & 64;
        int i45 = 1572864;
        if (largeAppBarCollapsedHeight-D9Ej5fM != 0) {
            $dirty |= i45;
            largeAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
        } else {
            if (i45 &= i38 == 0) {
                i2 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty |= i2;
            } else {
                largeAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
            }
        }
        if (i47 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i48 = -458753;
                int i49 = -57345;
                if (i38 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (windowInsets4 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = str;
                        }
                        if (i35 != 0) {
                            obj8 = windowInsets4;
                        }
                        if (i37 != 0) {
                            obj6 = windowInsets4;
                        }
                        str = 6;
                        if (i10 & 16 != 0) {
                            $dirty &= i49;
                            windowInsets2 = windowInsets3;
                        }
                        if (i10 & 32 != 0) {
                            $dirty &= i48;
                            colors2 = windowInsets4;
                        }
                        if (largeAppBarCollapsedHeight-D9Ej5fM != 0) {
                            obj10 = windowInsets4;
                            i = windowInsets2;
                            obj9 = colors2;
                            windowInsets2 = obj8;
                            colors2 = obj6;
                            actions2 = modifier3;
                            modifier2 = -474540752;
                        } else {
                            i = windowInsets2;
                            obj9 = colors2;
                            obj10 = largeAppBarExpandedHeight-D9Ej5fM;
                            windowInsets2 = obj8;
                            colors2 = obj6;
                            actions2 = modifier3;
                            modifier2 = -474540752;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty &= i49;
                        }
                        if (i10 & 32 != 0) {
                            $dirty = i13;
                            i = windowInsets2;
                            obj9 = colors2;
                            obj10 = largeAppBarExpandedHeight-D9Ej5fM;
                            modifier2 = -474540752;
                            windowInsets2 = obj8;
                            colors2 = obj6;
                            actions2 = str;
                        } else {
                            i = windowInsets2;
                            obj9 = colors2;
                            obj10 = largeAppBarExpandedHeight-D9Ej5fM;
                            modifier2 = -474540752;
                            windowInsets2 = obj8;
                            colors2 = obj6;
                            actions2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:545)");
                }
                AppBarKt.LargeTopAppBar-oKE7A98(obj, actions2, windowInsets2, colors2, TopAppBarDefaults.INSTANCE.getLargeAppBarCollapsedHeight-D9Ej5fM(), TopAppBarDefaults.INSTANCE.getLargeAppBarExpandedHeight-D9Ej5fM(), i, obj9, obj10, restartGroup, i20 | i30, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = $dirty;
                $dirty2 = companion;
                obj2 = windowInsets2;
                obj7 = colors2;
                obj3 = i;
                obj5 = obj9;
                obj4 = obj10;
            } else {
                restartGroup.skipToGroupEnd();
                modifier4 = $dirty;
                $dirty2 = str;
                obj7 = obj12;
                composer = restartGroup;
                obj2 = obj8;
                obj3 = windowInsets2;
                obj5 = colors2;
                obj4 = largeAppBarExpandedHeight-D9Ej5fM;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.LargeTopAppBar.1(title, $dirty2, obj2, obj7, obj3, obj5, obj4, i38, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void LargeTopAppBar-oKE7A98(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i12) {
        Object obj2;
        Object obj8;
        Object obj7;
        boolean windowInsets4;
        int largeAppBarExpandedHeight-D9Ej5fM2;
        Object windowInsets3;
        int $dirty;
        Composer traceInProgress2;
        int $dirty4;
        Object obj9;
        float largeAppBarCollapsedHeight-D9Ej5fM;
        boolean largeAppBarExpandedHeight-D9Ej5fM;
        int i10;
        Object expandedHeight2;
        int $dirty5;
        float $dirty3;
        Object obj10;
        Object $dirty2;
        int modifier2;
        int i3;
        float f4;
        Object colors2;
        boolean traceInProgress;
        Object str;
        float f3;
        int i4;
        Object obj6;
        int i15;
        Object obj4;
        Object obj5;
        int i5;
        int obj3;
        float f2;
        int modifier3;
        Object collapsedHeight2;
        Object obj11;
        int i7;
        int value2;
        float largeTitleBottomPadding;
        int i8;
        int i9;
        int changed;
        int changed2;
        int value;
        int i13;
        int i2;
        Object obj;
        float f;
        float f5;
        WindowInsets windowInsets2;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i14;
        Composer composer;
        int i;
        int i11;
        int i6;
        final int i53 = $changed;
        final int i54 = i12;
        traceInProgress2 = $composer.startRestartGroup(-630005584);
        ComposerKt.sourceInformation(traceInProgress2, "C(LargeTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)610@30747L12,611@30809L22,616@30993L5,617@31064L5,614@30893L943:AppBar.kt#uh7d8r");
        $dirty4 = $changed;
        if (i54 & 1 != 0) {
            $dirty4 |= 6;
            obj11 = title;
        } else {
            if (i53 & 6 == 0) {
                i10 = traceInProgress2.changedInstance(title) ? 4 : 2;
                $dirty4 |= i10;
            } else {
                obj11 = title;
            }
        }
        int i31 = i54 & 2;
        if (i31 != 0) {
            $dirty4 |= 48;
            obj10 = modifier;
        } else {
            if (i53 & 48 == 0) {
                i3 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty4 |= i3;
            } else {
                obj10 = modifier;
            }
        }
        colors2 = i54 & 4;
        if (colors2 != 0) {
            $dirty4 |= 384;
            str = navigationIcon;
        } else {
            if (i53 & 384 == 0) {
                i4 = traceInProgress2.changedInstance(navigationIcon) ? 256 : 128;
                $dirty4 |= i4;
            } else {
                str = navigationIcon;
            }
        }
        i15 = i54 & 8;
        if (i15 != 0) {
            $dirty4 |= 3072;
            obj4 = actions;
        } else {
            if (i53 & 3072 == 0) {
                i5 = traceInProgress2.changedInstance(actions) ? 2048 : 1024;
                $dirty4 |= i5;
            } else {
                obj4 = actions;
            }
        }
        int i52 = i54 & 16;
        if (i52 != 0) {
            $dirty4 |= 24576;
            f2 = collapsedHeight;
        } else {
            if (i53 & 24576 == 0) {
                i7 = traceInProgress2.changed(collapsedHeight) ? 16384 : 8192;
                $dirty4 |= i7;
            } else {
                f2 = collapsedHeight;
            }
        }
        value2 = i54 & 32;
        int i56 = 196608;
        if (value2 != null) {
            $dirty4 |= i56;
            largeTitleBottomPadding = expandedHeight;
        } else {
            if (i56 &= i53 == 0) {
                i8 = traceInProgress2.changed(expandedHeight) ? 131072 : 65536;
                $dirty4 |= i8;
            } else {
                largeTitleBottomPadding = expandedHeight;
            }
        }
        if (i53 & i58 == 0) {
            if (i54 & 64 == 0) {
                changed = traceInProgress2.changed(windowInsets) ? 1048576 : 524288;
            } else {
                obj2 = windowInsets;
            }
            $dirty4 |= changed;
        } else {
            obj2 = windowInsets;
        }
        if (i53 & i59 == 0) {
            if (i54 & 128 == 0) {
                changed2 = traceInProgress2.changed(colors) ? 8388608 : 4194304;
            } else {
                obj8 = colors;
            }
            $dirty4 |= changed2;
        } else {
            obj8 = colors;
        }
        int i18 = i54 & 256;
        int i60 = 100663296;
        if (i18 != 0) {
            $dirty4 |= i60;
            value = i18;
            obj7 = scrollBehavior;
        } else {
            if (i53 & i60 == 0) {
                value = i18;
                i13 = traceInProgress2.changed(scrollBehavior) ? 67108864 : 33554432;
                $dirty4 |= i13;
            } else {
                value = i18;
                obj7 = scrollBehavior;
            }
        }
        final int obj38 = $dirty4;
        if ($dirty4 & i2 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i62 = -3670017;
                int i63 = -29360129;
                int i21 = 6;
                if (i53 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            obj10 = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (colors2 != 0) {
                            str = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i15 != 0) {
                            obj4 = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i52 != 0) {
                            f2 = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (value2 != null) {
                            largeTitleBottomPadding = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i54 & 64 != 0) {
                            windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(traceInProgress2, i21);
                            $dirty5 = obj38 & i62;
                        } else {
                            windowInsets3 = windowInsets;
                            $dirty5 = obj38;
                        }
                        if (i54 & 128 != 0) {
                            colors2 = TopAppBarDefaults.INSTANCE.largeTopAppBarColors(traceInProgress2, i21);
                            $dirty5 &= i63;
                        } else {
                            colors2 = colors;
                        }
                        if (value != null) {
                            windowInsets2 = windowInsets3;
                            topAppBarColors = colors2;
                            i2 = str;
                            i14 = i15;
                            obj = obj4;
                            windowInsets4 = f2;
                            collapsedHeight2 = obj10;
                            modifier2 = $dirty5;
                            $dirty3 = largeTitleBottomPadding;
                        } else {
                            i14 = scrollBehavior;
                            windowInsets2 = windowInsets3;
                            topAppBarColors = colors2;
                            i2 = str;
                            obj = obj4;
                            windowInsets4 = f2;
                            collapsedHeight2 = obj10;
                            modifier2 = $dirty5;
                            $dirty3 = largeTitleBottomPadding;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty = i54 & 64 != 0 ? obj38 & i62 : obj38;
                        if (i54 & 128 != 0) {
                            $dirty &= i63;
                        }
                        modifier2 = $dirty;
                        windowInsets4 = f2;
                        collapsedHeight2 = obj13;
                        windowInsets2 = windowInsets;
                        topAppBarColors = colors;
                        i14 = scrollBehavior;
                        i2 = str;
                        obj = obj4;
                        $dirty3 = largeTitleBottomPadding;
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-630005584, modifier2, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:614)");
                }
                if (!Dp.equals-impl0(windowInsets4, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0(windowInsets4, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f = largeAppBarCollapsedHeight-D9Ej5fM;
                    } else {
                        f = windowInsets4;
                    }
                } else {
                }
                if (!Dp.equals-impl0($dirty3, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty3, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f5 = largeAppBarExpandedHeight-D9Ej5fM;
                    } else {
                        f5 = $dirty3;
                    }
                } else {
                }
                AppBarKt.TwoRowsTopAppBar-nS6u9G4(collapsedHeight2, obj11, TypographyKt.getValue(TopAppBarLargeTokens.INSTANCE.getHeadlineFont(), traceInProgress2, i21), AppBarKt.LargeTitleBottomPadding, title, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress2, i21), i2, obj, f, f5, windowInsets2, topAppBarColors, i14, traceInProgress2, i27 | i42, i30 | i46, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f4 = windowInsets4;
                f3 = $dirty3;
                obj9 = collapsedHeight2;
                expandedHeight2 = i2;
                obj6 = windowInsets2;
                obj5 = topAppBarColors;
                obj3 = i14;
                modifier3 = modifier2;
                $dirty2 = obj;
            } else {
                traceInProgress2.skipToGroupEnd();
                obj6 = windowInsets;
                obj3 = scrollBehavior;
                composer = traceInProgress2;
                obj9 = obj10;
                expandedHeight2 = str;
                $dirty2 = obj4;
                f4 = f2;
                f3 = largeTitleBottomPadding;
                obj5 = colors;
                modifier3 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            windowInsets4 = new AppBarKt.LargeTopAppBar.2(title, obj9, expandedHeight2, $dirty2, f4, f3, obj6, obj5, obj3, i53, i54);
            endRestartGroup.updateScope((Function2)windowInsets4);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final void MediumTopAppBar(Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier3;
        int modifier4;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i2;
        Object obj10;
        int windowInsets3;
        int windowInsets4;
        boolean traceInProgress;
        Object str;
        Object obj6;
        int i6;
        Object obj2;
        Object obj9;
        Object obj;
        int i4;
        Object obj7;
        Object obj4;
        Object obj5;
        int modifier2;
        Object actions2;
        int i;
        Object windowInsets2;
        int changed2;
        Object colors2;
        int changed;
        float mediumAppBarCollapsedHeight-D9Ej5fM;
        Object mediumAppBarExpandedHeight-D9Ej5fM;
        int i5;
        Object i8;
        Object obj8;
        Object obj3;
        Composer composer;
        int i3;
        int i7;
        final int i38 = $changed;
        restartGroup = $composer.startRestartGroup(1805417862);
        ComposerKt.sourceInformation(restartGroup, "C(MediumTopAppBar)P(5,2,3!1,6)396@19336L12,397@19398L23,400@19483L388:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj4 = title;
        } else {
            if (i38 & 6 == 0) {
                i2 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                obj4 = title;
            }
        }
        windowInsets3 = i10 & 2;
        if (windowInsets3 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i38 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                str = modifier;
            }
        }
        int i35 = i10 & 4;
        if (i35 != 0) {
            $dirty2 |= 384;
            obj9 = navigationIcon;
        } else {
            if (i38 & 384 == 0) {
                i4 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                obj9 = navigationIcon;
            }
        }
        int i37 = i10 & 8;
        if (i37 != 0) {
            $dirty2 |= 3072;
            obj5 = actions;
        } else {
            if (i38 & 3072 == 0) {
                i = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i;
            } else {
                obj5 = actions;
            }
        }
        if (i38 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed2 = restartGroup.changed(windowInsets) ? 16384 : 8192;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= changed2;
        } else {
            windowInsets2 = windowInsets;
        }
        if (i42 &= i38 == 0) {
            if (i10 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed;
        } else {
            colors2 = colors;
        }
        mediumAppBarCollapsedHeight-D9Ej5fM = i10 & 64;
        int i45 = 1572864;
        if (mediumAppBarCollapsedHeight-D9Ej5fM != 0) {
            $dirty2 |= i45;
            mediumAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
        } else {
            if (i45 &= i38 == 0) {
                i5 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                mediumAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
            }
        }
        if (i47 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i48 = -458753;
                int i49 = -57345;
                if (i38 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (windowInsets3 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = str;
                        }
                        if (i35 != 0) {
                            obj9 = windowInsets3;
                        }
                        if (i37 != 0) {
                            obj5 = windowInsets3;
                        }
                        str = 6;
                        if (i10 & 16 != 0) {
                            $dirty2 &= i49;
                            windowInsets2 = windowInsets4;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 &= i48;
                            colors2 = windowInsets3;
                        }
                        if (mediumAppBarCollapsedHeight-D9Ej5fM != 0) {
                            obj3 = windowInsets3;
                            i8 = windowInsets2;
                            obj8 = colors2;
                            windowInsets2 = obj9;
                            colors2 = obj5;
                            actions2 = modifier3;
                            modifier4 = 1805417862;
                        } else {
                            i8 = windowInsets2;
                            obj8 = colors2;
                            obj3 = mediumAppBarExpandedHeight-D9Ej5fM;
                            windowInsets2 = obj9;
                            colors2 = obj5;
                            actions2 = modifier3;
                            modifier4 = 1805417862;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i49;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 = i13;
                            i8 = windowInsets2;
                            obj8 = colors2;
                            obj3 = mediumAppBarExpandedHeight-D9Ej5fM;
                            modifier4 = 1805417862;
                            windowInsets2 = obj9;
                            colors2 = obj5;
                            actions2 = str;
                        } else {
                            i8 = windowInsets2;
                            obj8 = colors2;
                            obj3 = mediumAppBarExpandedHeight-D9Ej5fM;
                            modifier4 = 1805417862;
                            windowInsets2 = obj9;
                            colors2 = obj5;
                            actions2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier4, $dirty2, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:400)");
                }
                AppBarKt.MediumTopAppBar-oKE7A98(obj4, actions2, windowInsets2, colors2, TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM(), TopAppBarDefaults.INSTANCE.getMediumAppBarExpandedHeight-D9Ej5fM(), i8, obj8, obj3, restartGroup, i20 | i30, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = $dirty2;
                $dirty = companion;
                obj10 = windowInsets2;
                obj6 = colors2;
                obj2 = i8;
                obj = obj8;
                obj7 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = $dirty2;
                $dirty = str;
                obj6 = obj12;
                composer = restartGroup;
                obj10 = obj9;
                obj2 = windowInsets2;
                obj = colors2;
                obj7 = mediumAppBarExpandedHeight-D9Ej5fM;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.MediumTopAppBar.1(title, $dirty, obj10, obj6, obj2, obj, obj7, i38, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void MediumTopAppBar-oKE7A98(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i12) {
        Object obj6;
        Object obj11;
        Object obj;
        boolean windowInsets3;
        int mediumAppBarExpandedHeight-D9Ej5fM2;
        Object windowInsets4;
        int $dirty5;
        Composer traceInProgress2;
        int $dirty2;
        Object obj4;
        float mediumAppBarCollapsedHeight-D9Ej5fM;
        boolean mediumAppBarExpandedHeight-D9Ej5fM;
        int i6;
        Object expandedHeight2;
        int $dirty4;
        float $dirty3;
        Object obj3;
        Object $dirty;
        int modifier2;
        int i9;
        float f5;
        Object colors2;
        boolean traceInProgress;
        Object str;
        float f3;
        int i14;
        Object obj8;
        int i4;
        Object obj2;
        Object obj5;
        int i2;
        int obj7;
        float f;
        int modifier3;
        Object collapsedHeight2;
        Object obj9;
        int i15;
        int value2;
        float mediumTitleBottomPadding;
        int i5;
        int i8;
        int changed2;
        int changed;
        int value;
        int i11;
        int i7;
        Object obj10;
        float f2;
        float f4;
        WindowInsets windowInsets2;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i;
        Composer composer;
        int i10;
        int i3;
        int i13;
        final int i53 = $changed;
        final int i54 = i12;
        traceInProgress2 = $composer.startRestartGroup(1879191686);
        ComposerKt.sourceInformation(traceInProgress2, "C(MediumTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)465@23246L12,466@23308L23,472@23523L5,473@23594L5,469@23393L947:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i54 & 1 != 0) {
            $dirty2 |= 6;
            obj9 = title;
        } else {
            if (i53 & 6 == 0) {
                i6 = traceInProgress2.changedInstance(title) ? 4 : 2;
                $dirty2 |= i6;
            } else {
                obj9 = title;
            }
        }
        int i31 = i54 & 2;
        if (i31 != 0) {
            $dirty2 |= 48;
            obj3 = modifier;
        } else {
            if (i53 & 48 == 0) {
                i9 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj3 = modifier;
            }
        }
        colors2 = i54 & 4;
        if (colors2 != 0) {
            $dirty2 |= 384;
            str = navigationIcon;
        } else {
            if (i53 & 384 == 0) {
                i14 = traceInProgress2.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                str = navigationIcon;
            }
        }
        i4 = i54 & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            obj2 = actions;
        } else {
            if (i53 & 3072 == 0) {
                i2 = traceInProgress2.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                obj2 = actions;
            }
        }
        int i52 = i54 & 16;
        if (i52 != 0) {
            $dirty2 |= 24576;
            f = collapsedHeight;
        } else {
            if (i53 & 24576 == 0) {
                i15 = traceInProgress2.changed(collapsedHeight) ? 16384 : 8192;
                $dirty2 |= i15;
            } else {
                f = collapsedHeight;
            }
        }
        value2 = i54 & 32;
        int i56 = 196608;
        if (value2 != null) {
            $dirty2 |= i56;
            mediumTitleBottomPadding = expandedHeight;
        } else {
            if (i56 &= i53 == 0) {
                i5 = traceInProgress2.changed(expandedHeight) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                mediumTitleBottomPadding = expandedHeight;
            }
        }
        if (i53 & i58 == 0) {
            if (i54 & 64 == 0) {
                changed2 = traceInProgress2.changed(windowInsets) ? 1048576 : 524288;
            } else {
                obj6 = windowInsets;
            }
            $dirty2 |= changed2;
        } else {
            obj6 = windowInsets;
        }
        if (i53 & i59 == 0) {
            if (i54 & 128 == 0) {
                changed = traceInProgress2.changed(colors) ? 8388608 : 4194304;
            } else {
                obj11 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj11 = colors;
        }
        int i18 = i54 & 256;
        int i60 = 100663296;
        if (i18 != 0) {
            $dirty2 |= i60;
            value = i18;
            obj = scrollBehavior;
        } else {
            if (i53 & i60 == 0) {
                value = i18;
                i11 = traceInProgress2.changed(scrollBehavior) ? 67108864 : 33554432;
                $dirty2 |= i11;
            } else {
                value = i18;
                obj = scrollBehavior;
            }
        }
        final int obj38 = $dirty2;
        if ($dirty2 & i7 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i62 = -3670017;
                int i63 = -29360129;
                int i21 = 6;
                if (i53 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            obj3 = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (colors2 != 0) {
                            str = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i4 != 0) {
                            obj2 = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i52 != 0) {
                            f = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (value2 != null) {
                            mediumTitleBottomPadding = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i54 & 64 != 0) {
                            windowInsets4 = TopAppBarDefaults.INSTANCE.getWindowInsets(traceInProgress2, i21);
                            $dirty4 = obj38 & i62;
                        } else {
                            windowInsets4 = windowInsets;
                            $dirty4 = obj38;
                        }
                        if (i54 & 128 != 0) {
                            colors2 = TopAppBarDefaults.INSTANCE.mediumTopAppBarColors(traceInProgress2, i21);
                            $dirty4 &= i63;
                        } else {
                            colors2 = colors;
                        }
                        if (value != null) {
                            windowInsets2 = windowInsets4;
                            topAppBarColors = colors2;
                            i7 = str;
                            i = i4;
                            obj10 = obj2;
                            windowInsets3 = f;
                            collapsedHeight2 = obj3;
                            modifier2 = $dirty4;
                            $dirty3 = mediumTitleBottomPadding;
                        } else {
                            i = scrollBehavior;
                            windowInsets2 = windowInsets4;
                            topAppBarColors = colors2;
                            i7 = str;
                            obj10 = obj2;
                            windowInsets3 = f;
                            collapsedHeight2 = obj3;
                            modifier2 = $dirty4;
                            $dirty3 = mediumTitleBottomPadding;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty5 = i54 & 64 != 0 ? obj38 & i62 : obj38;
                        if (i54 & 128 != 0) {
                            $dirty5 &= i63;
                        }
                        modifier2 = $dirty5;
                        windowInsets3 = f;
                        collapsedHeight2 = obj13;
                        windowInsets2 = windowInsets;
                        topAppBarColors = colors;
                        i = scrollBehavior;
                        i7 = str;
                        obj10 = obj2;
                        $dirty3 = mediumTitleBottomPadding;
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1879191686, modifier2, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:469)");
                }
                if (!Dp.equals-impl0(windowInsets3, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0(windowInsets3, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f2 = mediumAppBarCollapsedHeight-D9Ej5fM;
                    } else {
                        f2 = windowInsets3;
                    }
                } else {
                }
                if (!Dp.equals-impl0($dirty3, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty3, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f4 = mediumAppBarExpandedHeight-D9Ej5fM;
                    } else {
                        f4 = $dirty3;
                    }
                } else {
                }
                AppBarKt.TwoRowsTopAppBar-nS6u9G4(collapsedHeight2, obj9, TypographyKt.getValue(TopAppBarMediumTokens.INSTANCE.getHeadlineFont(), traceInProgress2, i21), AppBarKt.MediumTitleBottomPadding, title, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress2, i21), i7, obj10, f2, f4, windowInsets2, topAppBarColors, i, traceInProgress2, i27 | i42, i30 | i46, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = windowInsets3;
                f3 = $dirty3;
                obj4 = collapsedHeight2;
                expandedHeight2 = i7;
                obj8 = windowInsets2;
                obj5 = topAppBarColors;
                obj7 = i;
                modifier3 = modifier2;
                $dirty = obj10;
            } else {
                traceInProgress2.skipToGroupEnd();
                obj8 = windowInsets;
                obj7 = scrollBehavior;
                composer = traceInProgress2;
                obj4 = obj3;
                expandedHeight2 = str;
                $dirty = obj2;
                f5 = f;
                f3 = mediumTitleBottomPadding;
                obj5 = colors;
                modifier3 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            windowInsets3 = new AppBarKt.MediumTopAppBar.2(title, obj4, expandedHeight2, $dirty, f5, f3, obj8, obj5, obj7, i53, i54);
            endRestartGroup.updateScope((Function2)windowInsets3);
        }
    }

    private static final void SingleRowTopAppBar-cJHQLPU(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, TextStyle titleTextStyle, boolean centeredTitle, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i13) {
        Modifier draggable$default;
        Object derivedStateOf;
        float coerceAtLeast;
        Object appBarContainerColor$delegate;
        Object it$iv;
        int i20;
        int i2;
        boolean $dirty2;
        int i;
        Object restartGroup;
        int pinned;
        int $dirty3;
        Object modifier2;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        boolean traceInProgress;
        int i22;
        Object anon;
        int i8;
        Modifier f;
        Object str;
        Object rememberedValue;
        long obj2;
        Object obj7;
        int i21;
        Object obj5;
        int i19;
        int i26;
        int i10;
        Object obj;
        Object empty;
        int i17;
        boolean z;
        int empty2;
        int i25;
        Object obj4;
        int i16;
        int i9;
        int i18;
        boolean naN;
        int i14;
        int i11;
        int i23;
        Object obj6;
        Object rememberedValue2;
        int i28;
        Composer composer;
        Composer i4;
        int companion;
        int i27;
        int companion4;
        Object obj3;
        int companion2;
        int i5;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int $dirty;
        float expandedHeightPx;
        State state;
        androidx.compose.ui.Modifier.Companion companion3;
        androidx.compose.foundation.gestures.DraggableState rememberDraggableState;
        Orientation vertical;
        int i24;
        int i15;
        int i6;
        int i29;
        Object obj8;
        int i7;
        int i3;
        int i12;
        final Object obj10 = actions;
        f = expandedHeight;
        obj2 = colors;
        obj7 = scrollBehavior;
        draggable$default = $changed;
        int i33 = i13;
        restartGroup = $composer.startRestartGroup(-342194911);
        ComposerKt.sourceInformation(restartGroup, "C(SingleRowTopAppBar)P(4,7,8,1,5!1,3:c#ui.unit.Dp,9)*1865@85622L7,1866@85690L284,1866@85679L295,1879@86382L321,1887@86744L178,1894@87005L197,1926@88369L1014,1926@88285L1098:AppBar.kt#uh7d8r");
        $dirty3 = $changed;
        rememberComposableLambda = i33 & 1;
        if (rememberComposableLambda != 0) {
            $dirty3 |= 6;
            str = modifier;
        } else {
            if (draggable$default & 6 == 0) {
                i21 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i21;
            } else {
                str = modifier;
            }
        }
        if (i33 & 2 != 0) {
            $dirty3 |= 48;
            obj5 = title;
        } else {
            if (draggable$default & 48 == 0) {
                i10 = restartGroup.changedInstance(title) ? 32 : 16;
                $dirty3 |= i10;
            } else {
                obj5 = title;
            }
        }
        if (i33 & 4 != 0) {
            $dirty3 |= 384;
            obj = titleTextStyle;
        } else {
            if (draggable$default & 384 == 0) {
                i17 = restartGroup.changed(titleTextStyle) ? 256 : 128;
                $dirty3 |= i17;
            } else {
                obj = titleTextStyle;
            }
        }
        if (i33 & 8 != 0) {
            $dirty3 |= 3072;
            z = centeredTitle;
        } else {
            if (draggable$default & 3072 == 0) {
                i25 = restartGroup.changed(centeredTitle) ? 2048 : 1024;
                $dirty3 |= i25;
            } else {
                z = centeredTitle;
            }
        }
        if (i33 & 16 != 0) {
            $dirty3 |= 24576;
            obj4 = navigationIcon;
        } else {
            if (draggable$default & 24576 == 0) {
                i14 = restartGroup.changedInstance(navigationIcon) ? 16384 : 8192;
                $dirty3 |= i14;
            } else {
                obj4 = navigationIcon;
            }
        }
        int i71 = 196608;
        if (i33 & 32 != 0) {
            $dirty3 |= i71;
        } else {
            if (draggable$default & i71 == 0) {
                i11 = restartGroup.changedInstance(obj10) ? 131072 : 65536;
                $dirty3 |= i11;
            }
        }
        int i72 = 1572864;
        if (i33 & 64 != 0) {
            $dirty3 |= i72;
        } else {
            if (draggable$default & i72 == 0) {
                i23 = restartGroup.changed(f) ? 1048576 : 524288;
                $dirty3 |= i23;
            }
        }
        i28 = 12582912;
        if (i33 & 128 != 0) {
            $dirty3 |= i28;
            obj6 = windowInsets;
        } else {
            if (draggable$default & i28 == 0) {
                i28 = restartGroup.changed(windowInsets) ? 8388608 : 4194304;
                $dirty3 |= i28;
            } else {
                obj6 = windowInsets;
            }
        }
        i4 = 100663296;
        if (i33 & 256 != 0) {
            $dirty3 |= i4;
        } else {
            if (draggable$default & i4 == 0) {
                i20 = restartGroup.changed(obj2) ? 67108864 : 33554432;
                $dirty3 |= i20;
            }
        }
        if (i33 & 512 != 0) {
            i2 = 805306368;
            $dirty3 |= i2;
        } else {
        }
        $dirty2 = $dirty3;
        if ($dirty4 &= $dirty2 == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (rememberComposableLambda != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-342194911, $dirty2, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1861)");
                }
                int i49 = 0;
                if (!Float.isNaN(expandedHeight)) {
                    i28 = 0;
                    i4 = Float.compare(naN, i76) == 0 ? 1 : 0;
                    i9 = i4 == 0 ? 1 : 0;
                } else {
                }
                if (i9 == 0) {
                } else {
                    int i73 = 0;
                    int i77 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i51 = 0;
                    coerceAtLeast = RangesKt.coerceAtLeast((Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(f), 0);
                    rememberedValue = "CC(remember):AppBar.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1193658092, rememberedValue);
                    int i43 = 1879048192;
                    int i78 = i43;
                    i22 = $dirty2 & i43 == 536870912 ? 1 : 0;
                    Composer composer5 = restartGroup;
                    int i74 = 0;
                    it$iv = composer5.rememberedValue();
                    companion = 0;
                    if (i22 |= changed5 == 0) {
                        $dirty = $dirty2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $dirty2 = 0;
                            obj3 = it$iv;
                            it$iv = new AppBarKt.SingleRowTopAppBar.2.1(obj7, coerceAtLeast);
                            composer5.updateRememberedValue((Function0)it$iv);
                        } else {
                            obj3 = it$iv;
                        }
                    } else {
                        $dirty = $dirty2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.SideEffect((Function0)it$iv, restartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1193635911, rememberedValue);
                    i = $dirty & i78 == 536870912 ? 1 : 0;
                    Composer composer3 = restartGroup;
                    int i67 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    int i75 = 0;
                    if (i == 0) {
                        expandedHeightPx = coerceAtLeast;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            companion = expandedHeightPx2;
                            AppBarKt.SingleRowTopAppBar.colorTransitionFraction.2.1 $i$a$CacheAppBarKt$SingleRowTopAppBar$colorTransitionFraction$2 = new AppBarKt.SingleRowTopAppBar.colorTransitionFraction.2.1(obj7);
                            composer3.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)$i$a$CacheAppBarKt$SingleRowTopAppBar$colorTransitionFraction$2));
                        } else {
                            derivedStateOf = rememberedValue3;
                        }
                    } else {
                        expandedHeightPx = coerceAtLeast;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    state = derivedStateOf;
                    rememberedValue2 = 0;
                    i8 = rememberedValue2;
                    Composer composer6 = restartGroup;
                    int i32 = 536870912;
                    Composer composer4 = composer6;
                    AppBarKt.SingleRowTopAppBar.actionsRow.1 anon2 = new AppBarKt.SingleRowTopAppBar.actionsRow.1(obj10);
                    empty2 = 1;
                    androidx.compose.runtime.internal.ComposableLambda composableLambda2 = rememberComposableLambda2;
                    composer4.startReplaceGroup(-1193605157);
                    ComposerKt.sourceInformation(composer4, "1908@87542L55,1908@87519L78,1909@87631L283");
                    if (obj7 != null && !obj7.isPinned()) {
                        if (!obj7.isPinned()) {
                            ComposerKt.sourceInformationMarkerStart(composer4, -1193599057, rememberedValue);
                            i19 = $dirty & i78 == i32 ? empty2 : 0;
                            empty = composer4;
                            i18 = 0;
                            rememberedValue2 = empty.rememberedValue();
                            i27 = 0;
                            if (i19 == 0) {
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    empty2 = 0;
                                    anon = new AppBarKt.SingleRowTopAppBar.appBarDragModifier.1.1(obj7);
                                    empty.updateRememberedValue((Function1)anon);
                                } else {
                                    anon = rememberedValue2;
                                }
                            } else {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            int i59 = 0;
                            ComposerKt.sourceInformationMarkerStart(composer4, -1193595981, rememberedValue);
                            i8 = $dirty & i78 == i32 ? 1 : i59;
                            Composer composer2 = composer4;
                            pinned = 0;
                            rememberedValue = composer2.rememberedValue();
                            i26 = 0;
                            if (i8 == 0) {
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    empty = 0;
                                    empty2 = new AppBarKt.SingleRowTopAppBar.appBarDragModifier.2.1(obj7, 0);
                                    composer2.updateRememberedValue((Function3)empty2);
                                } else {
                                    empty2 = rememberedValue;
                                }
                            } else {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            draggable$default = DraggableKt.draggable$default((Modifier)Modifier.Companion, DraggableKt.rememberDraggableState((Function1)anon, composer4, i59), Orientation.Vertical, false, 0, false, 0, (Function3)empty2, false, 188, 0);
                        } else {
                            draggable$default = Modifier.Companion;
                        }
                    } else {
                    }
                    composer4.endReplaceGroup();
                    obj = title;
                    AppBarKt.SingleRowTopAppBar.3 anon3 = new AppBarKt.SingleRowTopAppBar.3(windowInsets, expandedHeight, obj7, obj2, obj, titleTextStyle, centeredTitle, navigationIcon, (Function2)composableLambda2);
                    composableLambda = composableLambda2;
                    i4 = composer4;
                    SurfaceKt.Surface-T9BRK9s(modifier2.then(draggable$default), 0, AppBarKt.SingleRowTopAppBar_cJHQLPU$lambda$10(SingleValueAnimationKt.animateColorAsState-euL9pac(obj2.containerColor-vNxB06k$material3_release(AppBarKt.SingleRowTopAppBar_cJHQLPU$lambda$9((State)derivedStateOf)), obj, (AnimationSpec)AnimationSpecKt.spring$default(0, 1137180672, rememberedValue2, 5, rememberedValue2), 0, rememberedValue2, composer6, 48)), obj7, 0, obj, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1943739546, true, anon3, composer4, 54), i4);
                    composer = i4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    appBarContainerColor$delegate = modifier2;
                    ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
                    if (endRestartGroup != null) {
                        draggable$default = new AppBarKt.SingleRowTopAppBar.4(appBarContainerColor$delegate, title, titleTextStyle, centeredTitle, navigationIcon, obj10, expandedHeight, windowInsets, colors, scrollBehavior, $changed, i13);
                        endRestartGroup.updateScope((Function2)draggable$default);
                    }
                }
            } else {
                restartGroup.skipToGroupEnd();
                $dirty = $dirty2;
                composer = restartGroup;
                appBarContainerColor$delegate = str;
            }
        } else {
        }
        int i30 = 0;
        IllegalArgumentException $i$a$RequireAppBarKt$SingleRowTopAppBar$1 = new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
        throw $i$a$RequireAppBarKt$SingleRowTopAppBar$1;
    }

    private static final long SingleRowTopAppBar_cJHQLPU$lambda$10(State<Color> $appBarContainerColor$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (Color)$appBarContainerColor$delegate.getValue().unbox-impl();
    }

    private static final float SingleRowTopAppBar_cJHQLPU$lambda$9(State<Float> $colorTransitionFraction$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (Number)$colorTransitionFraction$delegate.getValue().floatValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TopAppBar with expandedHeight parameter")
    public static final void TopAppBar(Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier4;
        int modifier2;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i;
        Object obj8;
        int windowInsets2;
        int windowInsets4;
        boolean traceInProgress;
        Object str;
        Object obj6;
        int i6;
        Object obj3;
        Object obj2;
        Object obj4;
        int i7;
        Object obj7;
        Object obj9;
        Object obj10;
        int modifier3;
        Object actions2;
        int i5;
        Object windowInsets3;
        int changed;
        Object colors2;
        int changed2;
        float topAppBarExpandedHeight-D9Ej5fM;
        Object obj5;
        int i3;
        Object i8;
        Object obj;
        Composer composer;
        int i2;
        int i4;
        final int i37 = $changed;
        restartGroup = $composer.startRestartGroup(1906353009);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(5,2,3!1,6)142@6819L12,143@6881L17,146@6960L306:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj9 = title;
        } else {
            if (i37 & 6 == 0) {
                i = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty2 |= i;
            } else {
                obj9 = title;
            }
        }
        windowInsets2 = i10 & 2;
        if (windowInsets2 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i37 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                str = modifier;
            }
        }
        int i34 = i10 & 4;
        if (i34 != 0) {
            $dirty2 |= 384;
            obj2 = navigationIcon;
        } else {
            if (i37 & 384 == 0) {
                i7 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i7;
            } else {
                obj2 = navigationIcon;
            }
        }
        int i36 = i10 & 8;
        if (i36 != 0) {
            $dirty2 |= 3072;
            obj10 = actions;
        } else {
            if (i37 & 3072 == 0) {
                i5 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                obj10 = actions;
            }
        }
        if (i37 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(windowInsets) ? 16384 : 8192;
            } else {
                windowInsets3 = windowInsets;
            }
            $dirty2 |= changed;
        } else {
            windowInsets3 = windowInsets;
        }
        if (i41 &= i37 == 0) {
            if (i10 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed2;
        } else {
            colors2 = colors;
        }
        topAppBarExpandedHeight-D9Ej5fM = i10 & 64;
        int i44 = 1572864;
        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
            $dirty2 |= i44;
            obj5 = scrollBehavior;
        } else {
            if (i44 &= i37 == 0) {
                i3 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty2 |= i3;
            } else {
                obj5 = scrollBehavior;
            }
        }
        if (i46 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i47 = -458753;
                int i48 = -57345;
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (windowInsets2 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = str;
                        }
                        if (i34 != 0) {
                            obj2 = windowInsets2;
                        }
                        if (i36 != 0) {
                            obj10 = windowInsets2;
                        }
                        str = 6;
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                            windowInsets3 = windowInsets4;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 &= i47;
                            colors2 = windowInsets2;
                        }
                        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
                            obj = windowInsets2;
                            obj5 = windowInsets3;
                            i8 = colors2;
                            windowInsets3 = obj2;
                            colors2 = obj10;
                            actions2 = modifier4;
                            modifier2 = 1906353009;
                        } else {
                            i8 = colors2;
                            obj = obj5;
                            colors2 = obj10;
                            obj5 = windowInsets3;
                            actions2 = modifier4;
                            windowInsets3 = obj2;
                            modifier2 = 1906353009;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 = i13;
                            i8 = colors2;
                            obj = obj5;
                            modifier2 = 1906353009;
                            colors2 = obj10;
                            obj5 = windowInsets3;
                            actions2 = str;
                            windowInsets3 = obj2;
                        } else {
                            i8 = colors2;
                            obj = obj5;
                            modifier2 = 1906353009;
                            colors2 = obj10;
                            obj5 = windowInsets3;
                            actions2 = str;
                            windowInsets3 = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty2, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:146)");
                }
                AppBarKt.TopAppBar-GHTll3U(obj9, actions2, windowInsets3, colors2, TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM(), obj5, i8, obj, restartGroup, i20 | i29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = $dirty2;
                $dirty = companion;
                obj8 = windowInsets3;
                obj6 = colors2;
                obj3 = obj5;
                obj4 = i8;
                obj7 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = $dirty2;
                $dirty = str;
                obj6 = obj12;
                composer = restartGroup;
                obj8 = obj2;
                obj3 = windowInsets3;
                obj4 = colors2;
                obj7 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.TopAppBar.1(title, $dirty, obj8, obj6, obj3, obj4, obj7, i37, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void TopAppBar-GHTll3U(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i11) {
        Object obj7;
        int $dirty5;
        int $dirty;
        int defaultsInvalid;
        Object modifier3;
        boolean traceInProgress2;
        int $dirty3;
        boolean topAppBarExpandedHeight-D9Ej5fM2;
        Object obj12;
        int i9;
        int i10;
        int topAppBarExpandedHeight-D9Ej5fM;
        int windowInsets2;
        int topAppBarColors;
        Object obj5;
        Object obj;
        int $dirty4;
        Object $dirty2;
        int i6;
        boolean traceInProgress;
        float f;
        Object str;
        Object obj6;
        int i3;
        Object obj11;
        Object obj9;
        int i4;
        int i5;
        Object obj10;
        int modifier2;
        Object obj2;
        float value;
        int i12;
        Object obj3;
        int changed2;
        Object colors2;
        int changed;
        int i13;
        int i;
        Object i7;
        Object obj8;
        int obj4;
        Composer composer;
        int i8;
        int i2;
        final int i50 = $changed;
        final int i51 = i11;
        traceInProgress2 = $composer.startRestartGroup(226148675);
        ComposerKt.sourceInformation(traceInProgress2, "C(TopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)204@9890L12,205@9952L17,211@10162L5,208@10031L579:AppBar.kt#uh7d8r");
        $dirty3 = $changed;
        if (i51 & 1 != 0) {
            $dirty3 |= 6;
            obj2 = title;
        } else {
            if (i50 & 6 == 0) {
                i9 = traceInProgress2.changedInstance(title) ? 4 : 2;
                $dirty3 |= i9;
            } else {
                obj2 = title;
            }
        }
        topAppBarExpandedHeight-D9Ej5fM = i51 & 2;
        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
            $dirty3 |= 48;
            obj = modifier;
        } else {
            if (i50 & 48 == 0) {
                i6 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty3 |= i6;
            } else {
                obj = modifier;
            }
        }
        int i41 = i51 & 4;
        if (i41 != 0) {
            $dirty3 |= 384;
            str = navigationIcon;
        } else {
            if (i50 & 384 == 0) {
                i3 = traceInProgress2.changedInstance(navigationIcon) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                str = navigationIcon;
            }
        }
        int i48 = i51 & 8;
        if (i48 != 0) {
            $dirty3 |= 3072;
            obj9 = actions;
        } else {
            if (i50 & 3072 == 0) {
                i5 = traceInProgress2.changedInstance(actions) ? 2048 : 1024;
                $dirty3 |= i5;
            } else {
                obj9 = actions;
            }
        }
        int i52 = i51 & 16;
        if (i52 != 0) {
            $dirty3 |= 24576;
            value = expandedHeight;
        } else {
            if (i50 & 24576 == 0) {
                i12 = traceInProgress2.changed(expandedHeight) ? 16384 : 8192;
                $dirty3 |= i12;
            } else {
                value = expandedHeight;
            }
        }
        if (i54 &= i50 == 0) {
            if (i51 & 32 == 0) {
                changed2 = traceInProgress2.changed(windowInsets) ? 131072 : 65536;
            } else {
                obj3 = windowInsets;
            }
            $dirty3 |= changed2;
        } else {
            obj3 = windowInsets;
        }
        if (i57 &= i50 == 0) {
            if (i51 & 64 == 0) {
                changed = traceInProgress2.changed(colors) ? 1048576 : 524288;
            } else {
                colors2 = colors;
            }
            $dirty3 |= changed;
        } else {
            colors2 = colors;
        }
        int i15 = i51 & 128;
        int i60 = 12582912;
        if (i15 != 0) {
            $dirty3 |= i60;
            i13 = i15;
            obj7 = scrollBehavior;
        } else {
            if (i50 & i60 == 0) {
                i13 = i15;
                i = traceInProgress2.changed(scrollBehavior) ? 8388608 : 4194304;
                $dirty3 |= i;
            } else {
                i13 = i15;
                obj7 = scrollBehavior;
            }
        }
        final int obj32 = $dirty3;
        if ($dirty3 & i7 == 4793490) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i62 = -458753;
                int i63 = -3670017;
                int i17 = 6;
                if (i50 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj;
                        }
                        if (i41 != 0) {
                            str = topAppBarExpandedHeight-D9Ej5fM;
                        }
                        if (i48 != 0) {
                            obj9 = topAppBarExpandedHeight-D9Ej5fM;
                        }
                        if (i52 != 0) {
                            value = topAppBarExpandedHeight-D9Ej5fM;
                        }
                        if (i51 & 32 != 0) {
                            $dirty4 = obj32 & i62;
                            obj3 = windowInsets2;
                        } else {
                            $dirty4 = obj32;
                        }
                        if (i51 & 64 != 0) {
                            $dirty4 &= i63;
                            colors2 = topAppBarColors;
                        }
                        if (i13 != 0) {
                            obj10 = modifier3;
                            obj4 = i39;
                            changed = obj9;
                            $dirty5 = value;
                            i7 = obj3;
                            obj8 = colors2;
                            i10 = 226148675;
                            colors2 = str;
                        } else {
                            obj4 = scrollBehavior;
                            obj10 = modifier3;
                            changed = obj9;
                            $dirty5 = value;
                            i7 = obj3;
                            obj8 = colors2;
                            i10 = 226148675;
                            colors2 = str;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty = i51 & 32 != 0 ? obj32 & i62 : obj32;
                        if (i51 & 64 != 0) {
                            $dirty &= i63;
                        }
                        obj4 = scrollBehavior;
                        obj10 = obj;
                        changed = obj9;
                        i7 = obj3;
                        obj8 = colors2;
                        i10 = 226148675;
                        $dirty4 = $dirty;
                        colors2 = str;
                        $dirty5 = value;
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, $dirty4, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:208)");
                }
                if (!Dp.equals-impl0($dirty5, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty5, Dp.Companion.getInfinity-D9Ej5fM())) {
                        i13 = topAppBarExpandedHeight-D9Ej5fM2;
                    } else {
                        i13 = $dirty5;
                    }
                } else {
                }
                AppBarKt.SingleRowTopAppBar-cJHQLPU(obj10, obj2, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress2, i17), false, colors2, changed, i13, i7, obj8, obj4, traceInProgress2, i25 | i38, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f = $dirty5;
                obj12 = obj10;
                obj5 = colors2;
                obj6 = i7;
                obj11 = obj8;
                i4 = obj4;
                modifier2 = $dirty4;
                $dirty2 = changed;
            } else {
                traceInProgress2.skipToGroupEnd();
                modifier2 = obj32;
                composer = traceInProgress2;
                obj12 = obj;
                obj5 = str;
                $dirty2 = obj9;
                f = value;
                obj6 = obj3;
                obj11 = colors2;
                i4 = scrollBehavior;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = new AppBarKt.TopAppBar.2(title, obj12, obj5, $dirty2, f, obj6, obj11, i4, i50, i51);
            endRestartGroup.updateScope((Function2)$dirty5);
        }
    }

    private static final void TopAppBarLayout-kXwM9vE(Modifier modifier, androidx.compose.material3.ScrolledOffset scrolledOffset, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Function2<? super Composer, ? super Integer, Unit> title, TextStyle titleTextStyle, float titleAlpha, Arrangement.Vertical titleVerticalArrangement, Arrangement.Horizontal titleHorizontalArrangement, int titleBottomPadding, boolean hideTitleSemantics, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function2<? super Composer, ? super Integer, Unit> actions, Composer $composer, int $changed, int $changed1) {
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        boolean traceInProgress2;
        Object endRestartGroup;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        int obj;
        Object materialized$iv$iv;
        Object obj6;
        Object obj4;
        float f;
        Object obj3;
        boolean currentCompositionLocalMap;
        Modifier clearAndSetSemantics;
        boolean maybeCachedBoxMeasurePolicy;
        boolean currentCompositionLocalMap2;
        int i31;
        Object it$iv;
        Composer composer3;
        Object valueOf2;
        int i38;
        int i8;
        Object obj2;
        int $dirty6;
        Object restartGroup;
        int $dirty;
        long $dirty5;
        long l;
        int i6;
        int i22;
        Composer composer6;
        float topAppBarHorizontalPadding;
        Composer composer5;
        Object currentCompositionLocalMap3;
        int valueOf;
        int skipping;
        boolean traceInProgress;
        int changedInstance;
        int i36;
        int i23;
        Composer composer7;
        Object maybeCachedBoxMeasurePolicy3;
        int i14;
        boolean changedInstance2;
        int i37;
        int $dirty1;
        int maybeCachedBoxMeasurePolicy2;
        int i25;
        long l2;
        long l3;
        int i5;
        int currentCompositeKeyHash;
        int $dirty4;
        int $dirty3;
        int companion;
        Object obj5;
        int i19;
        int i30;
        int i33;
        int i17;
        int i27;
        int i12;
        Modifier modifier2;
        int i24;
        int i39;
        int i18;
        kotlin.jvm.functions.Function0 function0;
        int i;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        Composer composer;
        Composer $composer2;
        Modifier modifier3;
        int i26;
        int i21;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        int i9;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map2;
        int i20;
        int i10;
        int i16;
        Composer composer4;
        int i2;
        int i15;
        int i11;
        int i4;
        int i13;
        int $dirty2;
        kotlin.jvm.functions.Function0 function02;
        int i34;
        int i3;
        int i28;
        Composer composer2;
        androidx.compose.material3.AppBarKt.TopAppBarLayout.2.1 measurePolicy$iv2;
        int i29;
        int i32;
        Modifier modifier4;
        int i7;
        int i35;
        androidx.compose.runtime.CompositionLocalMap map;
        ScopeUpdateScope scopeUpdateScope;
        int obj76;
        obj = modifier;
        materialized$iv$iv = scrolledOffset;
        final Object obj7 = navigationIcon;
        final int i117 = actions;
        final boolean z5 = $composer;
        traceInProgress2 = $changed;
        obj6 = $changed1;
        int i61 = obj77;
        i38 = obj78;
        restartGroup = obj76.startRestartGroup(-742442296);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBarLayout)P(3,6,5:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,2,4)2163@98873L5882,2135@97725L7030:AppBar.kt#uh7d8r");
        int i89 = obj78;
        if (i61 & 6 == 0) {
            i14 = restartGroup.changed(obj) ? 4 : 2;
            $dirty |= i14;
        }
        if (i61 & 48 == 0) {
            if (i61 & 64 == 0) {
                changedInstance2 = restartGroup.changed(materialized$iv$iv);
            } else {
                changedInstance2 = restartGroup.changedInstance(materialized$iv$iv);
            }
            i37 = changedInstance2 ? 32 : 16;
            $dirty |= i37;
        }
        if (i61 & 384 == 0) {
            currentCompositeKeyHash = restartGroup.changed(navigationIconContentColor) ? 256 : 128;
            $dirty |= currentCompositeKeyHash;
        } else {
            l2 = navigationIconContentColor;
        }
        if (i61 & 3072 == 0) {
            $dirty1 = i89;
            i19 = restartGroup.changed(actionIconContentColor) ? 2048 : 1024;
            i128 |= i19;
        } else {
            $dirty4 = $dirty;
            $dirty1 = i89;
            $dirty5 = actionIconContentColor;
        }
        if (i61 & 24576 == 0) {
            i8 = restartGroup.changed(titleTextStyle) ? 16384 : 8192;
            $dirty4 |= i8;
        } else {
            l = titleTextStyle;
        }
        if (i75 &= i61 == 0) {
            i30 = restartGroup.changedInstance(titleVerticalArrangement) ? 131072 : 65536;
            $dirty4 |= i30;
        } else {
            obj2 = titleVerticalArrangement;
        }
        if (i61 & i133 == 0) {
            i33 = restartGroup.changed(titleHorizontalArrangement) ? 1048576 : 524288;
            $dirty4 |= i33;
        } else {
            obj4 = titleHorizontalArrangement;
        }
        if (obj77 & i134 == 0) {
            i17 = restartGroup.changed(titleBottomPadding) ? 8388608 : 4194304;
            $dirty4 |= i17;
        } else {
            f = titleBottomPadding;
        }
        if (obj77 & i135 == 0) {
            i27 = restartGroup.changed(hideTitleSemantics) ? 67108864 : 33554432;
            $dirty4 |= i27;
        } else {
            obj3 = hideTitleSemantics;
        }
        if (obj77 & i136 == 0) {
            i12 = restartGroup.changed(obj7) ? 536870912 : 268435456;
            $dirty4 |= i12;
        }
        $dirty6 = $dirty4;
        if (i38 & 6 == 0) {
            $dirty3 = restartGroup.changed(i117) ? 4 : 2;
            $dirty1 |= $dirty3;
        }
        if (i38 & 48 == 0) {
            companion = restartGroup.changed(z5) ? 32 : 16;
            $dirty1 |= companion;
        }
        if (i38 & 384 == 0) {
            i6 = restartGroup.changedInstance(traceInProgress2) ? 256 : 128;
            $dirty1 |= i6;
        }
        if (i38 & 3072 == 0) {
            i22 = restartGroup.changedInstance(obj6) ? 2048 : 1024;
            $dirty1 |= i22;
        }
        valueOf = $dirty1;
        if (i90 &= $dirty6 == 306783378 && valueOf & 1171 == 1170) {
            if (valueOf & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-742442296, $dirty6, valueOf, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2134)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1539011656, "CC(remember):AppBar.kt#9igjgp");
                    if ($dirty6 & 112 != 32) {
                        if ($dirty6 & 64 != 0 && restartGroup.changedInstance(materialized$iv$iv)) {
                            if (restartGroup.changedInstance(materialized$iv$iv)) {
                                i36 = 1;
                            } else {
                                i36 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                    i31 = i104 &= $dirty6 == 536870912 ? 1 : 0;
                    i23 = i92 &= $dirty6 == 67108864 ? 1 : 0;
                    i25 = valueOf & 14 == 4 ? 1 : 0;
                    Composer composer10 = restartGroup;
                    int i108 = 0;
                    it$iv = composer10.rememberedValue();
                    int i120 = 0;
                    if (i72 |= i25 == 0) {
                        $dirty2 = $dirty6;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $dirty6 = 0;
                            obj5 = it$iv;
                            it$iv = new AppBarKt.TopAppBarLayout.2.1(materialized$iv$iv, obj7, obj3, i117);
                            composer10.updateRememberedValue((MeasurePolicy)it$iv);
                        } else {
                            obj5 = it$iv;
                        }
                    } else {
                        $dirty2 = $dirty6;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i77 &= 112;
                    String str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4 = restartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, obj);
                    kotlin.jvm.functions.Function0 function08 = constructor;
                    i34 = 0;
                    i28 = i78;
                    String $changed$iv5 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv5);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function08);
                    } else {
                        factory$iv$iv = function08;
                        restartGroup.useNode();
                    }
                    function02 = factory$iv$iv;
                    Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                    int i121 = 0;
                    composer2 = restartGroup;
                    Updater.set-impl(constructor-impl2, (MeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i129 = 0;
                    Composer composer11 = constructor-impl2;
                    int i141 = 0;
                    if (!composer11.getInserting()) {
                        measurePolicy$iv2 = it$iv;
                        i29 = valueOf;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer11;
                        }
                    } else {
                        measurePolicy$iv2 = it$iv;
                        i29 = valueOf;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    valueOf2 = composer2;
                    i32 = i56;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 9049318, "C2137@97755L280,2143@98048L502,2155@98563L264:AppBar.kt#uh7d8r");
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "navigationIcon"), AppBarKt.TopAppBarHorizontalPadding, 0, 0, 0, 14, 0);
                    int i122 = 0;
                    modifier4 = materializeModifier2;
                    i7 = i83;
                    String $i$a$LayoutAppBarKt$TopAppBarLayout$1 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, $i$a$LayoutAppBarKt$TopAppBarLayout$1);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    int i130 = i85;
                    int $changed$iv6 = 0;
                    i35 = i95;
                    maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, $changed$iv6);
                    int i143 = 0;
                    Alignment alignment = topStart;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf2, 0);
                    currentCompositionLocalMap = valueOf2.getCurrentCompositionLocalMap();
                    int i155 = $changed$iv6;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf2, padding-qDBjuR0$default2);
                    Modifier modifier6 = padding-qDBjuR0$default2;
                    kotlin.jvm.functions.Function0 function04 = constructor4;
                    int i159 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, $changed$iv5);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf2.startReusableNode();
                    if (valueOf2.getInserting()) {
                        valueOf2.createNode(function04);
                    } else {
                        factory$iv$iv$iv3 = function04;
                        valueOf2.useNode();
                    }
                    kotlin.jvm.functions.Function0 function05 = factory$iv$iv$iv3;
                    Composer constructor-impl3 = Updater.constructor-impl(valueOf2);
                    int i168 = 0;
                    map = currentCompositionLocalMap4;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i171 = 0;
                    Composer composer16 = constructor-impl3;
                    int i177 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy3;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer7 = composer16;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy3;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    Composer composer8 = valueOf2;
                    int i96 = 0;
                    int i169 = i60;
                    String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $changed$iv3);
                    BoxScopeInstance iNSTANCE3 = BoxScopeInstance.INSTANCE;
                    i174 |= 6;
                    int i182 = 0;
                    Modifier modifier8 = materializeModifier3;
                    Composer materialized$iv$iv2 = composer17;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 249765716, "C2138@97858L163:AppBar.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(l2)), traceInProgress2, materialized$iv$iv2, $stable2 |= i179);
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    valueOf2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    if (z5) {
                        clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics((Modifier)Modifier.Companion, (Function1)AppBarKt.TopAppBarLayout.1.2.INSTANCE);
                    }
                    Modifier graphicsLayer-Ap8cVGQ$default = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "title"), AppBarKt.TopAppBarHorizontalPadding, 0, 2, 0).then(clearAndSetSemantics), 0, 0, titleBottomPadding, 0, 0, 0, 0, 0, 0, 0, 0, localMap$iv$iv2, false, 0, 0, 0, obj38, 0, obj40);
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, $i$a$LayoutAppBarKt$TopAppBarLayout$1);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    int i115 = 0;
                    int i118 = i63;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i115);
                    int i161 = 0;
                    int i163 = i86;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf2, 0);
                    currentCompositionLocalMap3 = valueOf2.getCurrentCompositionLocalMap();
                    Alignment alignment2 = topStart2;
                    Modifier modifier7 = graphicsLayer-Ap8cVGQ$default;
                    kotlin.jvm.functions.Function0 function06 = constructor2;
                    i26 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, $changed$iv5);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf2.startReusableNode();
                    if (valueOf2.getInserting()) {
                        valueOf2.createNode(function06);
                    } else {
                        factory$iv$iv$iv2 = function06;
                        valueOf2.useNode();
                    }
                    kotlin.jvm.functions.Function0 function07 = factory$iv$iv$iv2;
                    Composer constructor-impl = Updater.constructor-impl(valueOf2);
                    int i125 = 0;
                    i9 = i115;
                    Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Composer composer12 = constructor-impl;
                    int i144 = 0;
                    if (!composer12.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map2 = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer5 = composer12;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map2 = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf2, graphicsLayer-Ap8cVGQ$default), ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = valueOf2;
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv3);
                    BoxScopeInstance iNSTANCE2 = BoxScopeInstance.INSTANCE;
                    i20 = i127 | 6;
                    Composer composer13 = composer9;
                    i10 = 0;
                    i16 = i44;
                    i2 = i88;
                    ComposerKt.sourceInformationMarkerStart(composer13, 250255454, "C2149@98351L185:AppBar.kt#uh7d8r");
                    ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(actionIconContentColor, 0, titleHorizontalArrangement, titleVerticalArrangement, composer13);
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    valueOf2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "actionIcons"), 0, 0, AppBarKt.TopAppBarHorizontalPadding, 0, 11, 0);
                    int i68 = 6;
                    valueOf = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, $i$a$LayoutAppBarKt$TopAppBarLayout$1);
                    companion = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str);
                    currentCompositionLocalMap2 = valueOf2.getCurrentCompositionLocalMap();
                    obj76 = currentCompositeKeyHash2;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(valueOf2, padding-qDBjuR0$default);
                    modifier2 = padding-qDBjuR0$default;
                    kotlin.jvm.functions.Function0 function03 = constructor3;
                    i12 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, $changed$iv5);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf2.startReusableNode();
                    if (valueOf2.getInserting()) {
                        valueOf2.createNode(function03);
                    } else {
                        factory$iv$iv$iv = function03;
                        valueOf2.useNode();
                    }
                    Composer constructor-impl4 = Updater.constructor-impl(valueOf2);
                    int i148 = 0;
                    function0 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i158 = 0;
                    Composer composer15 = constructor-impl4;
                    int i165 = 0;
                    if (!composer15.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap2;
                        composer = valueOf2;
                        if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(obj76))) {
                            composer15.updateRememberedValue(Integer.valueOf(obj76));
                            constructor-impl4.apply(Integer.valueOf(obj76), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer15;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap2;
                        composer = valueOf2;
                    }
                    Updater.set-impl(constructor-impl4, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    obj3 = composer;
                    i38 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj3, -2146769399, $changed$iv3);
                    i81 |= 6;
                    i18 = 0;
                    i = i51;
                    boxScopeInstance = iNSTANCE;
                    modifier3 = materializeModifier;
                    materialized$iv$iv = composer14;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 250561951, "C2156@98661L152:AppBar.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(titleTextStyle)), obj6, materialized$iv$iv, $stable |= i24);
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(obj3);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    $dirty2 = $dirty6;
                    composer2 = restartGroup;
                    i29 = valueOf;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = composer2;
            endRestartGroup = new AppBarKt.TopAppBarLayout.3(modifier, scrolledOffset, l2, obj3, actionIconContentColor, $dirty6, titleTextStyle, valueOf, titleVerticalArrangement, titleHorizontalArrangement, titleBottomPadding, hideTitleSemantics, obj7, i117, z5, $changed, obj6, obj77, obj78);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = composer2;
        }
    }

    private static final void TwoRowsTopAppBar-nS6u9G4(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, TextStyle titleTextStyle, float titleBottomPadding, Function2<? super Composer, ? super Integer, Unit> smallTitle, TextStyle smallTitleTextStyle, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int $changed1, int i17) {
        Object obj4;
        Object obj8;
        int i27;
        int i13;
        int i26;
        int colorTransitionFraction;
        Object endRestartGroup;
        int i19;
        Object it$iv2;
        int collapsedFraction;
        Object it$iv;
        Object modifier2;
        int skipping;
        int traceInProgress2;
        Object $i$f$cache;
        Object obj;
        Object obj7;
        int changed3;
        int changed2;
        int $dirty12;
        float empty2;
        Object rememberedValue;
        Object restartGroup;
        int $dirty;
        Object rememberComposableLambda;
        int i6;
        int i32;
        int $dirty1;
        int i25;
        boolean traceInProgress;
        int i21;
        float f3;
        float f;
        int i24;
        Object empty;
        Object obj3;
        Object obj2;
        Object expandedHeightPx;
        boolean naN2;
        int i34;
        int i35;
        int i15;
        float f2;
        Object obj5;
        int i7;
        int i14;
        int i12;
        int i;
        int i3;
        boolean naN;
        int i16;
        int i4;
        Composer composer;
        int i30;
        int i33;
        int companion;
        int i8;
        int i22;
        int i29;
        int i2;
        int changed;
        int i23;
        Ref.IntRef intRef;
        int i18;
        int i20;
        long containerColor-vNxB06k$material3_release;
        Object companion2;
        Object obj6;
        androidx.compose.foundation.gestures.DraggableState rememberDraggableState;
        Orientation vertical;
        int i5;
        int i36;
        int i11;
        int i37;
        androidx.compose.material3.AppBarKt.TwoRowsTopAppBar.appBarDragModifier.2.1 anon;
        int i28;
        int i9;
        int i31;
        float topTitleAlpha;
        int i10;
        ScopeUpdateScope scopeUpdateScope;
        Object obj43;
        int obj56;
        empty2 = titleBottomPadding;
        final Object obj9 = actions;
        f3 = collapsedHeight;
        f = expandedHeight;
        obj3 = colors;
        obj2 = scrollBehavior;
        int i38 = $changed;
        int i45 = $changed1;
        traceInProgress2 = i17;
        restartGroup = $composer.startRestartGroup(1169193376);
        ComposerKt.sourceInformation(restartGroup, "C(TwoRowsTopAppBar)P(4,9,11,10:c#ui.unit.Dp,7,8,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,12)*1984@90586L7,1992@90915L205,1992@90904L216,2008@91751L197,2042@93233L2309,2042@93149L2393:AppBar.kt#uh7d8r");
        $dirty = $changed;
        $dirty1 = $changed1;
        i24 = traceInProgress2 & 1;
        if (i24 != 0) {
            $dirty |= 6;
            expandedHeightPx = modifier;
        } else {
            if (i38 & 6 == 0) {
                i7 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i7;
            } else {
                expandedHeightPx = modifier;
            }
        }
        i16 = 16;
        if (traceInProgress2 & 2 != 0) {
            $dirty |= 48;
            obj5 = title;
        } else {
            if (i38 & 48 == 0) {
                i4 = restartGroup.changedInstance(title) ? i3 : i16;
                $dirty |= i4;
            } else {
                obj5 = title;
            }
        }
        if (traceInProgress2 & 4 != 0) {
            $dirty |= 384;
            obj = titleTextStyle;
        } else {
            if (i38 & 384 == 0) {
                i8 = restartGroup.changed(titleTextStyle) ? 256 : i33;
                $dirty |= i8;
            } else {
                obj = titleTextStyle;
            }
        }
        if (traceInProgress2 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i38 & 3072 == 0) {
                obj = restartGroup.changed(empty2) ? 2048 : 1024;
                $dirty |= obj;
            }
        }
        if (traceInProgress2 & 16 != 0) {
            $dirty |= 24576;
            obj7 = smallTitle;
        } else {
            if (i38 & 24576 == 0) {
                i22 = restartGroup.changedInstance(smallTitle) ? 16384 : 8192;
                $dirty |= i22;
            } else {
                obj7 = smallTitle;
            }
        }
        int i77 = 196608;
        if (traceInProgress2 & 32 != 0) {
            $dirty |= i77;
            obj4 = smallTitleTextStyle;
        } else {
            if (i38 & i77 == 0) {
                i29 = restartGroup.changed(smallTitleTextStyle) ? 131072 : 65536;
                $dirty |= i29;
            } else {
                obj4 = smallTitleTextStyle;
            }
        }
        i23 = 1572864;
        if (traceInProgress2 & 64 != 0) {
            $dirty |= i23;
            obj8 = navigationIcon;
        } else {
            if ($changed & i23 == 0) {
                i2 = restartGroup.changedInstance(navigationIcon) ? 1048576 : 524288;
                $dirty |= i2;
            } else {
                obj8 = navigationIcon;
            }
        }
        int i76 = 12582912;
        if (traceInProgress2 & 128 != 0) {
            $dirty |= i76;
        } else {
            if ($changed & i76 == 0) {
                i27 = restartGroup.changedInstance(obj9) ? 8388608 : 4194304;
                $dirty |= i27;
            }
        }
        changed = 100663296;
        if (traceInProgress2 & 256 != 0) {
            $dirty |= changed;
        } else {
            if ($changed & changed == 0) {
                i13 = restartGroup.changed(f3) ? 67108864 : 33554432;
                $dirty |= i13;
            }
        }
        if (traceInProgress2 & 512 != 0) {
            i26 = 805306368;
            $dirty |= i26;
        } else {
        }
        colorTransitionFraction = $dirty;
        if (traceInProgress2 & 1024 != 0) {
            $dirty1 |= 6;
            rememberComposableLambda = windowInsets;
        } else {
            if (i45 & 6 == 0) {
                i14 = restartGroup.changed(windowInsets) ? 4 : 2;
                $dirty1 |= i14;
            } else {
                rememberComposableLambda = windowInsets;
            }
        }
        if (traceInProgress2 & 2048 != 0) {
            $dirty1 |= 48;
        } else {
            if (i45 & 48 == 0) {
                if (restartGroup.changed(obj3)) {
                } else {
                    i3 = i16;
                }
                $dirty1 |= i3;
            }
        }
        if (traceInProgress2 & 4096 != 0) {
            $dirty1 |= 384;
        } else {
            if (i45 & 384 == 0 && restartGroup.changed(obj2)) {
                if (restartGroup.changed(obj2)) {
                    i33 = 256;
                }
                $dirty1 |= i33;
            }
        }
        $dirty12 = $dirty1;
        if ($dirty13 &= colorTransitionFraction == 306783378 && $dirty12 & 147 == 146) {
            if ($dirty12 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    if (i24 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = expandedHeightPx;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1169193376, colorTransitionFraction, $dirty12, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1971)");
                    }
                    int i68 = 0;
                    if (!Float.isNaN(collapsedHeight)) {
                        i14 = 0;
                        i3 = Float.compare(naN2, i72) == 0 ? 1 : 0;
                        i34 = i3 == 0 ? 1 : 0;
                    } else {
                    }
                    if (i34 == 0) {
                    } else {
                        i12 = 0;
                        if (!Float.isNaN(expandedHeight)) {
                            i12 = 0;
                            naN = Float.compare(f2, i73) == 0 ? 1 : 0;
                            i35 = naN == 0 ? 1 : 0;
                        } else {
                        }
                        if (i35 == 0) {
                        } else {
                            i15 = Dp.compareTo-0680j_4(f, f3) >= 0 ? 1 : 0;
                            if (i15 == 0) {
                            } else {
                                Ref.FloatRef floatRef = new Ref.FloatRef();
                                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                                Ref.IntRef intRef2 = new Ref.IntRef();
                                int i70 = 0;
                                int i74 = 0;
                                i20 = colorTransitionFraction;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                int i62 = 0;
                                floatRef.element = (Density)consume.toPx-0680j_4(f);
                                Ref.FloatRef num = obj43;
                                num.element = consume.toPx-0680j_4(f3);
                                obj43 = consume;
                                Ref.IntRef $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416 = obj56;
                                $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416.element = consume.roundToPx-0680j_4(empty2);
                                Unit $i$a$RunAppBarKt$TwoRowsTopAppBar$4 = Unit.INSTANCE;
                                empty = "CC(remember):AppBar.kt#9igjgp";
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 1641215730, empty);
                                i19 = $dirty12 & 896 == 256 ? 1 : 0;
                                Composer composer3 = restartGroup;
                                int i71 = 0;
                                it$iv2 = composer3.rememberedValue();
                                int i75 = 0;
                                if (i41 |= changed8 == 0) {
                                    if (it$iv2 == Composer.Companion.getEmpty()) {
                                        empty2 = 0;
                                        obj56 = it$iv2;
                                        it$iv2 = new AppBarKt.TwoRowsTopAppBar.5.1(obj2, num, floatRef);
                                        composer3.updateRememberedValue((Function0)it$iv2);
                                    } else {
                                        obj56 = it$iv2;
                                    }
                                } else {
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                EffectsKt.SideEffect((Function0)it$iv2, restartGroup, 0);
                                it$iv2 = obj2.getState();
                                if (obj2 != null && it$iv2 != null) {
                                    it$iv2 = obj2.getState();
                                    if (it$iv2 != null) {
                                        collapsedFraction = it$iv2.getCollapsedFraction();
                                    } else {
                                        collapsedFraction = 0;
                                    }
                                } else {
                                }
                                AppBarKt.TwoRowsTopAppBar.actionsRow.1 anon2 = new AppBarKt.TwoRowsTopAppBar.actionsRow.1(obj9);
                                obj43 = num;
                                i32 = 1;
                                androidx.compose.runtime.internal.ComposableLambda composableLambda = rememberComposableLambda2;
                                $i$f$cache = AppBarKt.TopTitleAlphaEasing.transform(collapsedFraction);
                                i = Float.compare(collapsedFraction, i54) < 0 ? i32 : 0;
                                i18 = i == 0 ? i32 : 0;
                                restartGroup.startReplaceGroup(1641266888);
                                ComposerKt.sourceInformation(restartGroup, "2028@92709L55,2028@92686L78,2029@92798L283");
                                if (obj2 != null && !obj2.isPinned()) {
                                    if (!obj2.isPinned()) {
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1641272988, empty);
                                        i6 = $dirty12 & 896 == 256 ? 1 : 0;
                                        Composer composer4 = restartGroup;
                                        companion = 0;
                                        obj56 = collapsedFraction;
                                        it$iv = composer4.rememberedValue();
                                        changed = 0;
                                        if (i6 == 0) {
                                            topTitleAlpha = $i$f$cache;
                                            if (it$iv == Composer.Companion.getEmpty()) {
                                                $i$f$cache = 0;
                                                obj6 = it$iv;
                                                it$iv = new AppBarKt.TwoRowsTopAppBar.appBarDragModifier.1.1(obj2);
                                                composer4.updateRememberedValue((Function1)it$iv);
                                            } else {
                                                obj6 = it$iv;
                                            }
                                        } else {
                                            topTitleAlpha = $i$f$cache;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        int i46 = 0;
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1641276064, empty);
                                        i21 = $dirty12 & 896 == 256 ? 1 : i46;
                                        Composer composer2 = restartGroup;
                                        int i47 = 0;
                                        rememberedValue = composer2.rememberedValue();
                                        i32 = 0;
                                        if (i21 == 0) {
                                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                                empty = 0;
                                                i30 = i47;
                                                i10 = $dirty12;
                                                $i$f$cache = new AppBarKt.TwoRowsTopAppBar.appBarDragModifier.2.1(obj2, 0);
                                                composer2.updateRememberedValue((Function3)$i$f$cache);
                                            } else {
                                                i30 = i47;
                                                i10 = $dirty12;
                                                $i$f$cache = rememberedValue;
                                            }
                                        } else {
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        colorTransitionFraction = DraggableKt.draggable$default((Modifier)Modifier.Companion, DraggableKt.rememberDraggableState((Function1)it$iv, restartGroup, i46), Orientation.Vertical, false, 0, false, 0, (Function3)$i$f$cache, false, 188, 0);
                                    } else {
                                        obj56 = collapsedFraction;
                                        topTitleAlpha = $i$f$cache;
                                        i10 = $dirty12;
                                        colorTransitionFraction = Modifier.Companion;
                                    }
                                } else {
                                }
                                restartGroup.endReplaceGroup();
                                $dirty12 = floatRef;
                                expandedHeightPx = smallTitleTextStyle;
                                AppBarKt.TwoRowsTopAppBar.6 anon3 = new AppBarKt.TwoRowsTopAppBar.6(windowInsets, collapsedHeight, obj3, smallTitle, expandedHeightPx, topTitleAlpha, i, navigationIcon, (Function2)composableLambda, f, obj2, obj5, titleTextStyle, i53 - collapsedFraction, $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416, i18);
                                i25 = i;
                                empty2 = composableLambda;
                                SurfaceKt.Surface-T9BRK9s(modifier2.then(colorTransitionFraction), 0, obj3.containerColor-vNxB06k$material3_release(collapsedFraction), obj3, 0, expandedHeightPx, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1350062619, true, anon3, restartGroup, 54), restartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                endRestartGroup = composer.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup = new AppBarKt.TwoRowsTopAppBar.7(modifier2, title, titleTextStyle, titleBottomPadding, smallTitle, smallTitleTextStyle, navigationIcon, obj9, collapsedHeight, expandedHeight, windowInsets, colors, scrollBehavior, $changed, $changed1, i17);
                                    endRestartGroup.updateScope((Function2)endRestartGroup);
                                }
                            }
                            int $dirty8 = colorTransitionFraction;
                            int $dirty3 = 0;
                            IllegalArgumentException $i$a$RequireAppBarKt$TwoRowsTopAppBar$3 = new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
                            throw $i$a$RequireAppBarKt$TwoRowsTopAppBar$3;
                        }
                        int $dirty9 = colorTransitionFraction;
                        int $dirty5 = 0;
                        IllegalArgumentException $i$a$RequireAppBarKt$TwoRowsTopAppBar$2 = new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
                        throw $i$a$RequireAppBarKt$TwoRowsTopAppBar$2;
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    i20 = colorTransitionFraction;
                    i10 = $dirty12;
                    composer = restartGroup;
                    modifier2 = expandedHeightPx;
                }
            } else {
            }
        } else {
        }
        int $dirty7 = colorTransitionFraction;
        int $dirty2 = 0;
        IllegalArgumentException $i$a$RequireAppBarKt$TwoRowsTopAppBar$1 = new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
        throw $i$a$RequireAppBarKt$TwoRowsTopAppBar$1;
    }

    public static final void access$SingleRowTopAppBar-cJHQLPU(Modifier modifier, Function2 title, TextStyle titleTextStyle, boolean centeredTitle, Function2 navigationIcon, Function3 actions, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int $default) {
        AppBarKt.SingleRowTopAppBar-cJHQLPU(modifier, title, titleTextStyle, centeredTitle, navigationIcon, actions, expandedHeight, windowInsets, colors, scrollBehavior, $composer, $changed, $default);
    }

    public static final void access$TopAppBarLayout-kXwM9vE(Modifier modifier, androidx.compose.material3.ScrolledOffset scrolledOffset, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Function2 title, TextStyle titleTextStyle, float titleAlpha, Arrangement.Vertical titleVerticalArrangement, Arrangement.Horizontal titleHorizontalArrangement, int titleBottomPadding, boolean hideTitleSemantics, Function2 navigationIcon, Function2 actions, Composer $composer, int $changed, int $changed1) {
        AppBarKt.TopAppBarLayout-kXwM9vE(modifier, scrolledOffset, navigationIconContentColor, titleContentColor, actionIconContentColor, title, titleTextStyle, titleAlpha, titleVerticalArrangement, titleHorizontalArrangement, titleBottomPadding, hideTitleSemantics, navigationIcon, actions, $composer, $changed, $changed1);
    }

    public static final void access$TwoRowsTopAppBar-nS6u9G4(Modifier modifier, Function2 title, TextStyle titleTextStyle, float titleBottomPadding, Function2 smallTitle, TextStyle smallTitleTextStyle, Function2 navigationIcon, Function3 actions, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int $changed1, int $default) {
        AppBarKt.TwoRowsTopAppBar-nS6u9G4(modifier, title, titleTextStyle, titleBottomPadding, smallTitle, smallTitleTextStyle, navigationIcon, actions, collapsedHeight, expandedHeight, windowInsets, colors, scrollBehavior, $composer, $changed, $changed1, $default);
    }

    public static final float access$getBottomAppBarHorizontalPadding$p() {
        return AppBarKt.BottomAppBarHorizontalPadding;
    }

    public static final float access$getFABHorizontalPadding$p() {
        return AppBarKt.FABHorizontalPadding;
    }

    public static final float access$getFABVerticalPadding$p() {
        return AppBarKt.FABVerticalPadding;
    }

    public static final float access$getTopAppBarTitleInset$p() {
        return AppBarKt.TopAppBarTitleInset;
    }

    public static final Object access$settleAppBar(androidx.compose.material3.TopAppBarState state, float velocity, DecayAnimationSpec flingAnimationSpec, AnimationSpec snapAnimationSpec, Continuation $completion) {
        return AppBarKt.settleAppBar(state, velocity, flingAnimationSpec, snapAnimationSpec, $completion);
    }

    public static final Object access$settleAppBarBottom(androidx.compose.material3.BottomAppBarState state, float velocity, DecayAnimationSpec flingAnimationSpec, AnimationSpec snapAnimationSpec, Continuation $completion) {
        return AppBarKt.settleAppBarBottom(state, velocity, flingAnimationSpec, snapAnimationSpec, $completion);
    }

    public static final float getBottomAppBarVerticalPadding() {
        return AppBarKt.BottomAppBarVerticalPadding;
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return AppBarKt.TopTitleAlphaEasing;
    }

    public static final androidx.compose.material3.BottomAppBarState rememberBottomAppBarState(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset, Composer $composer, int $changed, int i6) {
        boolean changed3;
        int i2;
        int changed2;
        int i;
        int changed;
        String str;
        Object empty;
        Object anon;
        int obj9;
        int obj10;
        int obj11;
        boolean obj14;
        int i3 = 1420874240;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberBottomAppBarState)P(2,1)1611@75546L102,1611@75496L152:AppBar.kt#uh7d8r");
        if (i6 & 1 != 0) {
            obj9 = -8388609;
        }
        if (i6 & 2 != 0) {
            obj10 = 0;
        }
        int i10 = 4;
        if (i6 &= i10 != 0) {
            obj11 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:1610)");
        }
        obj14 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -1399214710, "CC(remember):AppBar.kt#9igjgp");
        int i14 = 1;
        if (i5 ^= 6 > i10) {
            if (!$composer.changed(obj9)) {
                i2 = $changed & 6 == i10 ? i14 : obj14;
            } else {
            }
        } else {
        }
        int i16 = 32;
        if (i11 ^= 48 > i16) {
            if (!$composer.changed(obj10)) {
                i = $changed & 48 == i16 ? i14 : obj14;
            } else {
            }
        } else {
        }
        int i17 = 256;
        if (i12 ^= 384 > i17) {
            if (!$composer.changed(obj11)) {
                if ($changed & 384 == i17) {
                    obj14 = i14;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i13 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i18 = 0;
        if (obj14 |= i7 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new AppBarKt.rememberBottomAppBarState.1.1(obj9, obj10, obj11);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (BottomAppBarState)RememberSaveableKt.rememberSaveable(new Object[obj14], BottomAppBarState.Companion.getSaver(), 0, (Function0)anon, composer2, 0, 4);
    }

    public static final androidx.compose.material3.TopAppBarState rememberTopAppBarState(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset, Composer $composer, int $changed, int i6) {
        boolean changed3;
        int i2;
        int changed2;
        int i;
        int changed;
        String str;
        Object empty;
        Object anon;
        int obj9;
        int obj10;
        int obj11;
        boolean obj14;
        int i3 = 1801969826;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberTopAppBarState)P(2,1)1292@62790L99,1292@62743L146:AppBar.kt#uh7d8r");
        if (i6 & 1 != 0) {
            obj9 = -8388609;
        }
        if (i6 & 2 != 0) {
            obj10 = 0;
        }
        int i10 = 4;
        if (i6 &= i10 != 0) {
            obj11 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1291)");
        }
        obj14 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 1949255933, "CC(remember):AppBar.kt#9igjgp");
        int i14 = 1;
        if (i5 ^= 6 > i10) {
            if (!$composer.changed(obj9)) {
                i2 = $changed & 6 == i10 ? i14 : obj14;
            } else {
            }
        } else {
        }
        int i16 = 32;
        if (i11 ^= 48 > i16) {
            if (!$composer.changed(obj10)) {
                i = $changed & 48 == i16 ? i14 : obj14;
            } else {
            }
        } else {
        }
        int i17 = 256;
        if (i12 ^= 384 > i17) {
            if (!$composer.changed(obj11)) {
                if ($changed & 384 == i17) {
                    obj14 = i14;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i13 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i18 = 0;
        if (obj14 |= i7 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new AppBarKt.rememberTopAppBarState.1.1(obj9, obj10, obj11);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (TopAppBarState)RememberSaveableKt.rememberSaveable(new Object[obj14], TopAppBarState.Companion.getSaver(), 0, (Function0)anon, composer2, 0, 4);
    }

    private static final Object settleAppBar(androidx.compose.material3.TopAppBarState topAppBarState, float f2, DecayAnimationSpec<Float> decayAnimationSpec3, AnimationSpec<Float> animationSpec4, Continuation<? super Velocity> continuation5) {
        Object obj2;
        boolean anon3;
        Object cOROUTINE_SUSPENDED;
        int i4;
        float snapAnimationSpec2;
        Object snapAnimationSpec;
        int heightOffsetLimit2;
        int heightOffsetLimit;
        Object state;
        int cmp;
        Object l$0;
        int lastValue;
        androidx.compose.material3.AppBarKt.settleAppBar.1 anon;
        int remainingVelocity;
        int i8;
        androidx.compose.material3.TopAppBarState topAppBarState2;
        Object obj;
        Object velocity;
        Object heightOffset;
        long l;
        int i6;
        int i2;
        int i;
        int i7;
        int i5;
        int i3;
        androidx.compose.material3.AppBarKt.settleAppBar.2 anon2;
        obj2 = continuation5;
        anon3 = obj2;
        heightOffsetLimit2 = Integer.MIN_VALUE;
        if (obj2 instanceof AppBarKt.settleAppBar.1 && label2 &= heightOffsetLimit2 != 0) {
            anon3 = obj2;
            heightOffsetLimit2 = Integer.MIN_VALUE;
            if (label2 &= heightOffsetLimit2 != 0) {
                anon3.label = label -= heightOffsetLimit2;
            } else {
                anon3 = new AppBarKt.settleAppBar.1(obj2);
            }
        } else {
        }
        anon = anon3;
        Object result = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i12 = 0;
        switch (snapAnimationSpec2) {
            case 0:
                ResultKt.throwOnFailure(result);
                topAppBarState2 = topAppBarState;
                heightOffsetLimit2 = decayAnimationSpec3;
                float f = f2;
                snapAnimationSpec = animationSpec4;
                lastValue = 1065353216;
                remainingVelocity = 1;
                cmp = remainingVelocity;
                cmp = 0;
                Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = f;
                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                AppBarKt.settleAppBar.2 anon5 = new AppBarKt.settleAppBar.2(floatRef2, topAppBarState2, floatRef);
                anon.L$0 = topAppBarState2;
                anon.L$1 = snapAnimationSpec;
                anon.L$2 = floatRef;
                anon.label = remainingVelocity;
                obj = floatRef2;
                return cOROUTINE_SUSPENDED;
                l$0 = topAppBarState2;
                snapAnimationSpec2 = velocity;
                heightOffsetLimit2 = heightOffset;
                snapAnimationSpec2 = f;
                velocity = floatRef;
                obj = topAppBarState2;
                state = heightOffset;
                heightOffsetLimit = i12;
                heightOffsetLimit = obj.getHeightOffsetLimit();
                AppBarKt.settleAppBar.3 anon4 = new AppBarKt.settleAppBar.3(obj);
                anon.L$0 = velocity;
                int i10 = 0;
                anon.L$1 = i10;
                anon.L$2 = i10;
                anon.label = 2;
                remainingVelocity = anon;
                anon = remainingVelocity;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = velocity;
                velocity = cOROUTINE_SUSPENDED;
                return Velocity.box-impl(VelocityKt.Velocity(i12, velocity.element));
                heightOffset = snapAnimationSpec;
                snapAnimationSpec = f;
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
            case 1:
                snapAnimationSpec2 = anon.L$2;
                heightOffsetLimit2 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(result);
                break;
            case 2:
                cOROUTINE_SUSPENDED = anon.L$0;
                ResultKt.throwOnFailure(result);
                velocity = cOROUTINE_SUSPENDED;
                return Velocity.box-impl(VelocityKt.Velocity(i12, velocity.element));
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        velocity = snapAnimationSpec2;
        obj = l$0;
        state = heightOffsetLimit2;
    }

    private static final Object settleAppBarBottom(androidx.compose.material3.BottomAppBarState bottomAppBarState, float f2, DecayAnimationSpec<Float> decayAnimationSpec3, AnimationSpec<Float> animationSpec4, Continuation<? super Velocity> continuation5) {
        Object obj2;
        boolean anon;
        Object cOROUTINE_SUSPENDED;
        int i4;
        float snapAnimationSpec2;
        Object snapAnimationSpec;
        int heightOffsetLimit;
        int heightOffsetLimit2;
        Object state;
        int cmp;
        Object l$0;
        int lastValue;
        androidx.compose.material3.AppBarKt.settleAppBarBottom.1 anon3;
        int remainingVelocity;
        int i3;
        androidx.compose.material3.BottomAppBarState bottomAppBarState2;
        Object obj;
        Object velocity;
        Object heightOffset;
        long l;
        int i5;
        int i6;
        int i7;
        int i2;
        int i8;
        int i;
        androidx.compose.material3.AppBarKt.settleAppBarBottom.2 anon2;
        obj2 = continuation5;
        anon = obj2;
        heightOffsetLimit = Integer.MIN_VALUE;
        if (obj2 instanceof AppBarKt.settleAppBarBottom.1 && label2 &= heightOffsetLimit != 0) {
            anon = obj2;
            heightOffsetLimit = Integer.MIN_VALUE;
            if (label2 &= heightOffsetLimit != 0) {
                anon.label = label -= heightOffsetLimit;
            } else {
                anon = new AppBarKt.settleAppBarBottom.1(obj2);
            }
        } else {
        }
        anon3 = anon;
        Object result = anon3.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i12 = 0;
        switch (snapAnimationSpec2) {
            case 0:
                ResultKt.throwOnFailure(result);
                bottomAppBarState2 = bottomAppBarState;
                heightOffsetLimit = decayAnimationSpec3;
                float f = f2;
                snapAnimationSpec = animationSpec4;
                lastValue = 1065353216;
                remainingVelocity = 1;
                cmp = remainingVelocity;
                cmp = 0;
                Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = f;
                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                AppBarKt.settleAppBarBottom.2 anon5 = new AppBarKt.settleAppBarBottom.2(floatRef2, bottomAppBarState2, floatRef);
                anon3.L$0 = bottomAppBarState2;
                anon3.L$1 = snapAnimationSpec;
                anon3.L$2 = floatRef;
                anon3.label = remainingVelocity;
                obj = floatRef2;
                return cOROUTINE_SUSPENDED;
                l$0 = bottomAppBarState2;
                snapAnimationSpec2 = velocity;
                heightOffsetLimit = heightOffset;
                snapAnimationSpec2 = f;
                velocity = floatRef;
                obj = bottomAppBarState2;
                state = heightOffset;
                heightOffsetLimit2 = i12;
                heightOffsetLimit2 = obj.getHeightOffsetLimit();
                AppBarKt.settleAppBarBottom.3 anon4 = new AppBarKt.settleAppBarBottom.3(obj);
                anon3.L$0 = velocity;
                int i10 = 0;
                anon3.L$1 = i10;
                anon3.L$2 = i10;
                anon3.label = 2;
                remainingVelocity = anon3;
                anon3 = remainingVelocity;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = velocity;
                velocity = cOROUTINE_SUSPENDED;
                return Velocity.box-impl(VelocityKt.Velocity(i12, velocity.element));
                heightOffset = snapAnimationSpec;
                snapAnimationSpec = f;
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
            case 1:
                snapAnimationSpec2 = anon3.L$2;
                heightOffsetLimit = anon3.L$1;
                l$0 = anon3.L$0;
                ResultKt.throwOnFailure(result);
                break;
            case 2:
                cOROUTINE_SUSPENDED = anon3.L$0;
                ResultKt.throwOnFailure(result);
                velocity = cOROUTINE_SUSPENDED;
                return Velocity.box-impl(VelocityKt.Velocity(i12, velocity.element));
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        velocity = snapAnimationSpec2;
        obj = l$0;
        state = heightOffsetLimit;
    }
}
