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
        int traceInProgress;
        int $dirty5;
        int $dirty2;
        int defaultsInvalid;
        int $dirty3;
        Object $composer2;
        int $dirty;
        int windowInsets2;
        int containerElevation-D9Ej5fM;
        long $dirty4;
        int i4;
        int i11;
        Object obj7;
        boolean traceInProgress2;
        long l;
        int i12;
        long containerColor3;
        float f;
        int changed3;
        long contentColorFor-ek8zF_U;
        Object obj3;
        Object obj2;
        int changed2;
        int i5;
        float tonalElevation2;
        int i9;
        long l2;
        int containerColor2;
        Object obj;
        int i2;
        Object obj5;
        int changed;
        Object obj4;
        float i7;
        int i8;
        Object i;
        int i13;
        Object obj6;
        int i6;
        Composer composer2;
        Composer composer;
        int i3;
        int i14;
        int obj33;
        final int i43 = obj34;
        Composer restartGroup = i10.startRestartGroup(-1391700845);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)807@39959L14,808@40001L31,811@40227L12,814@40294L302:AppBar.kt#uh7d8r");
        $dirty = obj34;
        i11 = obj35 & 1;
        if (i11 != 0) {
            $dirty |= 6;
            obj7 = modifier;
        } else {
            if (i43 & 6 == 0) {
                i12 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i12;
            } else {
                obj7 = modifier;
            }
        }
        if (i43 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed3 = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                containerColor3 = containerColor;
            }
            $dirty |= changed3;
        } else {
            containerColor3 = containerColor;
        }
        if (i43 & 384 == 0) {
            if (obj35 & 4 == 0) {
                changed2 = restartGroup.changed(tonalElevation) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty |= changed2;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        i5 = obj35 & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            tonalElevation2 = windowInsets;
        } else {
            if (i43 & 3072 == 0) {
                i9 = restartGroup.changed(windowInsets) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                tonalElevation2 = windowInsets;
            }
        }
        int i45 = obj35 & 16;
        if (i45 != 0) {
            $dirty |= 24576;
            obj = content;
        } else {
            if (i43 & 24576 == 0) {
                i2 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i2;
            } else {
                obj = content;
            }
        }
        if (i47 &= i43 == 0) {
            if (obj35 & 32 == 0) {
                changed = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj5 = $composer;
            }
            $dirty |= changed;
        } else {
            obj5 = $composer;
        }
        i7 = 1572864;
        if (obj35 & 64 != 0) {
            $dirty |= i7;
            obj4 = $changed;
        } else {
            if (i43 & i7 == 0) {
                i8 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                obj4 = $changed;
            }
        }
        obj33 = $dirty;
        if ($dirty & i == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                containerElevation-D9Ej5fM = -458753;
                if (i43 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        int i36 = 6;
                        if (obj35 & 2 != 0) {
                            containerColor3 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, i36);
                            $dirty3 = obj33 & -113;
                        } else {
                            $dirty3 = obj33;
                        }
                        if (obj35 & 4 != 0) {
                            obj33 = containerElevation-D9Ej5fM;
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor3, obj6, restartGroup);
                            $dirty3 &= -897;
                        } else {
                            obj33 = containerElevation-D9Ej5fM;
                        }
                        if (i5 != 0) {
                            tonalElevation2 = containerElevation-D9Ej5fM;
                        }
                        if (i45 != 0) {
                            obj = containerElevation-D9Ej5fM;
                        }
                        if (obj35 & 32 != 0) {
                            obj6 = windowInsets3;
                            obj5 = contentColorFor-ek8zF_U;
                            i = obj;
                            i4 = -1391700845;
                            windowInsets2 = $dirty7;
                            l2 = containerColor3;
                            $dirty2 = i7;
                            i7 = tonalElevation2;
                            tonalElevation2 = obj7;
                        } else {
                            windowInsets2 = $dirty3;
                            i = obj;
                            obj6 = obj5;
                            $dirty2 = i7;
                            i4 = -1391700845;
                            l2 = containerColor3;
                            obj5 = contentColorFor-ek8zF_U;
                            i7 = tonalElevation2;
                            tonalElevation2 = obj7;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty5 = obj35 & 2 != 0 ? obj33 & -113 : obj33;
                        if (obj35 & 4 != 0) {
                            $dirty5 &= -897;
                        }
                        if (obj35 & 32 != 0) {
                            windowInsets2 = $dirty6;
                            i = obj;
                            obj6 = obj5;
                            $dirty2 = i7;
                            i4 = -1391700845;
                            l2 = containerColor3;
                            obj5 = contentColorFor-ek8zF_U;
                            i7 = tonalElevation2;
                            tonalElevation2 = obj7;
                        } else {
                            windowInsets2 = $dirty5;
                            i = obj;
                            obj6 = obj5;
                            $dirty2 = i7;
                            i4 = -1391700845;
                            l2 = containerColor3;
                            obj5 = contentColorFor-ek8zF_U;
                            i7 = tonalElevation2;
                            tonalElevation2 = obj7;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i4, windowInsets2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:814)");
                }
                AppBarKt.BottomAppBar-e-3WI5M(tonalElevation2, l2, obj, obj5, obj4, i7, i, obj6, 0, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                containerColor2 = windowInsets2;
                $dirty4 = l3;
                $composer2 = tonalElevation2;
                l = obj5;
                f = i7;
                obj3 = i;
                obj2 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                containerColor2 = obj33;
                composer = restartGroup;
                $composer2 = obj7;
                $dirty4 = containerColor3;
                l = contentColorFor-ek8zF_U;
                f = tonalElevation2;
                obj3 = obj;
                obj2 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.BottomAppBar.4($composer2, $dirty4, i11, l, containerColor3, f, obj3, obj2, $changed, i43, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void BottomAppBar-Snr_uVM(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, Composer $composer, int $changed, int i11) {
        Object obj6;
        Object obj4;
        int traceInProgress;
        int contentPadding2;
        int defaultsInvalid;
        int iNSTANCE;
        int containerElevation-D9Ej5fM;
        Object contentPadding3;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i13;
        boolean traceInProgress2;
        Object obj5;
        Object str;
        long l2;
        int i7;
        int windowInsets3;
        Object obj3;
        long l;
        int i9;
        long containerColor2;
        float f2;
        int changed;
        long contentColorFor-ek8zF_U;
        PaddingValues paddingValues;
        WindowInsets windowInsets2;
        Object obj7;
        int i12;
        int changed2;
        Object i3;
        float tonalElevation2;
        int i2;
        long i6;
        int i10;
        int i14;
        int changed3;
        long i8;
        float f;
        Object obj;
        Object obj2;
        int i;
        Composer composer;
        int i4;
        int i5;
        final int i51 = obj38;
        final int i52 = obj39;
        restartGroup = i11.startRestartGroup(2141738945);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)678@33855L14,679@33897L31,682@34123L12,684@34145L355:AppBar.kt#uh7d8r");
        $dirty2 = obj38;
        if (i52 & 1 != 0) {
            $dirty2 |= 6;
            obj7 = actions;
        } else {
            if (i51 & 6 == 0) {
                i13 = restartGroup.changedInstance(actions) ? 4 : 2;
                $dirty2 |= i13;
            } else {
                obj7 = actions;
            }
        }
        int i30 = i52 & 2;
        if (i30 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i51 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i7;
            } else {
                str = modifier;
            }
        }
        windowInsets3 = i52 & 4;
        if (windowInsets3 != 0) {
            $dirty2 |= 384;
            obj3 = floatingActionButton;
        } else {
            if (i51 & 384 == 0) {
                i9 = restartGroup.changedInstance(floatingActionButton) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj3 = floatingActionButton;
            }
        }
        if (i51 & 3072 == 0) {
            if (i52 & 8 == 0) {
                changed = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= changed;
        } else {
            containerColor2 = containerColor;
        }
        if (i51 & 24576 == 0) {
            if (i52 & 16 == 0) {
                changed2 = restartGroup.changed(tonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty2 |= changed2;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        i3 = i52 & 32;
        int i54 = 196608;
        if (i3 != 0) {
            $dirty2 |= i54;
            tonalElevation2 = windowInsets;
        } else {
            if (i54 &= i51 == 0) {
                i2 = restartGroup.changed(windowInsets) ? 131072 : 65536;
                $dirty2 |= i2;
            } else {
                tonalElevation2 = windowInsets;
            }
        }
        i6 = i52 & 64;
        i10 = 1572864;
        if (i6 != 0) {
            $dirty2 |= i10;
            obj6 = $composer;
        } else {
            if (i51 & i10 == 0) {
                i14 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty2 |= i14;
            } else {
                obj6 = $composer;
            }
        }
        if (i51 & i56 == 0) {
            if (i52 & 128 == 0) {
                changed3 = restartGroup.changed($changed) ? 8388608 : 4194304;
            } else {
                obj4 = $changed;
            }
            $dirty2 |= changed3;
        } else {
            obj4 = $changed;
        }
        if ($dirty2 & i8 == 4793490) {
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
                            obj3 = defaultsInvalid;
                        }
                        windowInsets3 = 6;
                        if (i52 & 8 != 0) {
                            containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, windowInsets3);
                            $dirty2 &= -7169;
                        }
                        if (i52 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj8, restartGroup);
                            $dirty2 &= i57;
                        }
                        if (i3 != 0) {
                            tonalElevation2 = containerElevation-D9Ej5fM;
                        }
                        if (i6 != 0) {
                            contentPadding3 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding3 = $composer;
                        }
                        if (i52 & 128 != 0) {
                            $dirty2 &= i32;
                            obj = contentPadding3;
                            i3 = str;
                            obj2 = windowInsets3;
                            i6 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding2 = 2141738945;
                            tonalElevation2 = obj3;
                        } else {
                            obj2 = $changed;
                            obj = contentPadding3;
                            i3 = str;
                            i6 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding2 = 2141738945;
                            tonalElevation2 = obj3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i52 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i52 & 16 != 0) {
                            $dirty2 &= i57;
                        }
                        if (i52 & 128 != 0) {
                            obj = $composer;
                            obj2 = $changed;
                            $dirty2 = i19;
                            i3 = str;
                            i6 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding2 = 2141738945;
                            tonalElevation2 = obj3;
                        } else {
                            obj = $composer;
                            obj2 = $changed;
                            i3 = str;
                            i6 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                            f = tonalElevation2;
                            contentPadding2 = 2141738945;
                            tonalElevation2 = obj3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentPadding2, $dirty2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:684)");
                }
                AppBarKt.BottomAppBar-qhFBPw4(obj7, i3, tonalElevation2, i6, i10, i8, obj19, f, obj, obj2, 0, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i12 = $dirty2;
                $dirty = i3;
                obj5 = tonalElevation2;
                l2 = i6;
                l = i8;
                f2 = f;
                paddingValues = obj;
                windowInsets2 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                i12 = $dirty2;
                $dirty = str;
                obj5 = obj3;
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
            traceInProgress = new AppBarKt.BottomAppBar.1(actions, $dirty, obj5, l2, windowInsets3, l, containerColor2, f2, paddingValues, windowInsets2, i51, i52);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void BottomAppBar-e-3WI5M(Modifier modifier, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, androidx.compose.material3.BottomAppBarScrollBehavior scrollBehavior, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj3;
        Object obj;
        int i5;
        WindowInsets $dirty5;
        int $dirty3;
        int defaultsInvalid;
        int $dirty4;
        Object $composer2;
        int $dirty;
        long l;
        int empty2;
        Object anon2;
        int empty3;
        Modifier draggable$default;
        int tonalElevation3;
        int i16;
        float tonalElevation4;
        Object obj5;
        long modifier2;
        int i6;
        long containerColor2;
        int $dirty2;
        float f2;
        int i15;
        int i18;
        Object anon;
        Object empty;
        int changed;
        long contentColorFor-ek8zF_U;
        Object obj4;
        int contentColor2;
        Composer i21;
        WindowInsets windowInsets3;
        boolean traceInProgress;
        int changed3;
        int contentPadding2;
        Object contentPadding3;
        float windowInsets2;
        Object anon3;
        int i13;
        int i19;
        androidx.compose.ui.graphics.Shape rememberedValue;
        Object obj2;
        int i8;
        int i7;
        int changed2;
        long i3;
        int i20;
        int tonalElevation2;
        float f;
        int i;
        int companion2;
        int i17;
        Object rememberDraggableState;
        Composer composer;
        Orientation vertical;
        int companion;
        int i2;
        int i4;
        int i9;
        Object obj6;
        int i14;
        int i10;
        int i12;
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
            obj5 = modifier;
        } else {
            if (i59 & 6 == 0) {
                i6 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i6;
            } else {
                obj5 = modifier;
            }
        }
        if (i59 & 48 == 0) {
            if (i60 & 2 == 0) {
                changed = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= changed;
        } else {
            containerColor2 = containerColor;
        }
        if (i59 & 384 == 0) {
            if (i60 & 4 == 0) {
                changed3 = restartGroup.changed(tonalElevation) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty |= changed3;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        int i58 = i60 & 8;
        if (i58 != 0) {
            $dirty |= 3072;
            windowInsets2 = windowInsets;
        } else {
            if (i59 & 3072 == 0) {
                i19 = restartGroup.changed(windowInsets) ? 2048 : 1024;
                $dirty |= i19;
            } else {
                windowInsets2 = windowInsets;
            }
        }
        rememberedValue = i60 & 16;
        if (rememberedValue != 0) {
            $dirty |= 24576;
            obj2 = scrollBehavior;
        } else {
            if (i59 & 24576 == 0) {
                i8 = restartGroup.changed(scrollBehavior) ? 16384 : 8192;
                $dirty |= i8;
            } else {
                obj2 = scrollBehavior;
            }
        }
        if (i59 & i64 == 0) {
            if (i60 & 32 == 0) {
                changed2 = restartGroup.changed(content) ? 131072 : 65536;
            } else {
                obj3 = content;
            }
            $dirty |= changed2;
        } else {
            obj3 = content;
        }
        i3 = i60 & 64;
        i20 = 1572864;
        if (i3 != 0) {
            $dirty |= i20;
            obj = $composer;
        } else {
            if (i59 & i20 == 0) {
                i20 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty |= i20;
            } else {
                obj = $composer;
            }
        }
        int i65 = 12582912;
        if (i60 & 128 != 0) {
            $dirty |= i65;
        } else {
            if (i59 & i65 == 0) {
                i5 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i5;
            }
        }
        tonalElevation2 = $dirty;
        if (i23 &= $dirty == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                companion2 = -458753;
                empty2 = 6;
                if (i59 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (tonalElevation3 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (i60 & 2 != 0) {
                            containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, empty2);
                            $dirty4 = tonalElevation2 & -113;
                        } else {
                            $dirty4 = tonalElevation2;
                        }
                        if (i60 & 4 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj6, restartGroup);
                            $dirty4 &= -897;
                        }
                        if (i58 != 0) {
                            tonalElevation4 = BottomAppBarDefaults.INSTANCE.getContainerElevation-D9Ej5fM();
                        } else {
                            tonalElevation4 = windowInsets2;
                        }
                        if (rememberedValue != 0) {
                            contentPadding3 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding3 = obj2;
                        }
                        if (i60 & 32 != 0) {
                            windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(restartGroup, empty2);
                            $dirty4 &= companion2;
                        } else {
                            windowInsets2 = content;
                        }
                        if (i3 != 0) {
                            f = tonalElevation4;
                            obj2 = containerColor2;
                            tonalElevation3 = rememberedValue;
                            i15 = i65;
                            $dirty2 = $dirty4;
                            i3 = contentColorFor-ek8zF_U;
                            $dirty5 = windowInsets2;
                            contentColor2 = 422438773;
                        } else {
                            f = tonalElevation4;
                            obj2 = containerColor2;
                            i15 = i65;
                            tonalElevation3 = $composer;
                            $dirty2 = $dirty4;
                            i3 = contentColorFor-ek8zF_U;
                            $dirty5 = windowInsets2;
                            contentColor2 = 422438773;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty3 = i60 & 2 != 0 ? tonalElevation2 & -113 : tonalElevation2;
                        if (i60 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (i60 & 32 != 0) {
                            $dirty3 &= companion2;
                        }
                        tonalElevation3 = $composer;
                        f = windowInsets2;
                        contentPadding3 = obj2;
                        obj2 = containerColor2;
                        i15 = i65;
                        $dirty2 = $dirty3;
                        i3 = contentColorFor-ek8zF_U;
                        contentColor2 = 422438773;
                        $dirty5 = content;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentColor2, $dirty2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:867)");
                }
                restartGroup.startReplaceGroup(1393560009);
                ComposerKt.sourceInformation(restartGroup, "874@43358L55,874@43335L78,875@43447L289");
                i21 = 3670016;
                String str3 = "CC(remember):AppBar.kt#9igjgp";
                if (tonalElevation3 != 0 && !tonalElevation3.isPinned()) {
                    if (!tonalElevation3.isPinned()) {
                        obj32 = i15;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1393566103, str3);
                        i18 = $dirty2 & i21 == 1048576 ? 1 : 0;
                        Composer composer3 = restartGroup;
                        int i66 = 0;
                        Object rememberedValue3 = composer3.rememberedValue();
                        int i67 = 0;
                        if (i18 == 0) {
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                anon3 = new AppBarKt.BottomAppBar.appBarDragModifier.1.1(tonalElevation3);
                                composer3.updateRememberedValue((Function1)anon3);
                            } else {
                                anon3 = rememberedValue3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        empty3 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1393569185, str3);
                        i15 = $dirty2 & obj33 == 1048576 ? 1 : empty3;
                        i21 = restartGroup;
                        windowInsets2 = 0;
                        rememberedValue = i21.rememberedValue();
                        companion2 = 0;
                        if (i15 == 0) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                obj36 = i26;
                                obj37 = $dirty2;
                                anon2 = new AppBarKt.BottomAppBar.appBarDragModifier.2.1(tonalElevation3, 0);
                                i21.updateRememberedValue((Function3)anon2);
                            } else {
                                obj37 = $dirty2;
                                anon2 = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        draggable$default = DraggableKt.draggable$default((Modifier)Modifier.Companion, DraggableKt.rememberDraggableState((Function1)anon3, restartGroup, empty3), Orientation.Vertical, false, 0, false, 0, (Function3)anon2, false, 188, 0);
                    } else {
                        obj37 = $dirty2;
                        obj32 = i15;
                        obj33 = i21;
                        draggable$default = Modifier.Companion;
                    }
                } else {
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1393598804, str3);
                i13 = obj37 & obj33 == 1048576 ? 1 : 0;
                Composer composer2 = restartGroup;
                empty = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i56 = 0;
                if (i13 == 0) {
                    obj33 = empty;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        obj35 = $i$f$cache;
                        anon = new AppBarKt.BottomAppBar.5.1(tonalElevation3);
                        composer2.updateRememberedValue((Function3)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                    obj33 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AppBarKt.BottomAppBar.6 anon4 = new AppBarKt.BottomAppBar.6($dirty5, contentPadding3, obj8);
                SurfaceKt.Surface-T9BRK9s(LayoutModifierKt.layout(obj5, (Function3)anon).then(draggable$default), ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), restartGroup, 6), obj2, i7, i3, i65, f, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1243053520, true, anon4, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = $dirty5;
                $composer2 = obj5;
                obj4 = contentPadding3;
                modifier2 = i3;
                f2 = f;
                tonalElevation2 = obj37;
                contentPadding2 = tonalElevation3;
                l = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                contentPadding2 = $composer;
                composer = restartGroup;
                $composer2 = obj5;
                l = containerColor2;
                modifier2 = contentColorFor-ek8zF_U;
                f2 = windowInsets2;
                obj4 = obj2;
                windowInsets3 = content;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = new AppBarKt.BottomAppBar.7($composer2, l, tonalElevation3, modifier2, containerColor2, f2, obj4, windowInsets3, contentPadding2, obj8, i59, i60);
            endRestartGroup.updateScope((Function2)$dirty5);
        }
    }

    public static final void BottomAppBar-qhFBPw4(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, androidx.compose.material3.BottomAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i12) {
        Object obj3;
        Object obj;
        Object obj6;
        int traceInProgress2;
        int contentPadding3;
        int defaultsInvalid;
        int iNSTANCE2;
        int containerElevation-D9Ej5fM;
        Object contentPadding2;
        Object $composer2;
        int $dirty2;
        Object $dirty;
        int i3;
        int i14;
        long l2;
        Object obj5;
        boolean traceInProgress;
        int i2;
        WindowInsets windowInsets2;
        long l;
        Object obj2;
        int i7;
        long containerColor2;
        float f;
        PaddingValues paddingValues;
        int changed2;
        long contentColorFor-ek8zF_U;
        WindowInsets windowInsets3;
        int i5;
        int changed;
        Object obj4;
        int iNSTANCE;
        int modifier2;
        float tonalElevation2;
        int i11;
        int i8;
        int i15;
        int changed3;
        int i9;
        int i13;
        PaddingValues i;
        WindowInsets windowInsets4;
        int i4;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i6;
        int i10;
        final Object obj7 = actions;
        final int i60 = obj39;
        final int i61 = obj40;
        Composer restartGroup = i12.startRestartGroup(-1044837119);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)743@37109L14,744@37151L31,747@37377L12,758@37741L539,750@37455L825:AppBar.kt#uh7d8r");
        $dirty2 = obj39;
        if (i61 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i60 & 6 == 0) {
                i3 = restartGroup.changedInstance(obj7) ? 4 : 2;
                $dirty2 |= i3;
            }
        }
        int i30 = i61 & 2;
        if (i30 != 0) {
            $dirty2 |= 48;
            obj5 = modifier;
        } else {
            if (i60 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i2;
            } else {
                obj5 = modifier;
            }
        }
        windowInsets2 = i61 & 4;
        if (windowInsets2 != 0) {
            $dirty2 |= 384;
            obj2 = floatingActionButton;
        } else {
            if (i60 & 384 == 0) {
                i7 = restartGroup.changedInstance(floatingActionButton) ? 256 : 128;
                $dirty2 |= i7;
            } else {
                obj2 = floatingActionButton;
            }
        }
        if (i60 & 3072 == 0) {
            if (i61 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= changed2;
        } else {
            containerColor2 = containerColor;
        }
        if (i60 & 24576 == 0) {
            if (i61 & 16 == 0) {
                changed = restartGroup.changed(tonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = tonalElevation;
            }
            $dirty2 |= changed;
        } else {
            contentColorFor-ek8zF_U = tonalElevation;
        }
        int i62 = i61 & 32;
        int i63 = 196608;
        if (i62 != 0) {
            $dirty2 |= i63;
            tonalElevation2 = windowInsets;
        } else {
            if (i63 &= i60 == 0) {
                i11 = restartGroup.changed(windowInsets) ? 131072 : 65536;
                $dirty2 |= i11;
            } else {
                tonalElevation2 = windowInsets;
            }
        }
        int i65 = i61 & 64;
        i8 = 1572864;
        if (i65 != 0) {
            $dirty2 |= i8;
            obj3 = scrollBehavior;
        } else {
            if (i60 & i8 == 0) {
                i15 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty2 |= i15;
            } else {
                obj3 = scrollBehavior;
            }
        }
        int i66 = 12582912;
        if (i60 & i66 == 0) {
            if (i61 & 128 == 0) {
                changed3 = restartGroup.changed($composer) ? 8388608 : 4194304;
            } else {
                obj = $composer;
            }
            $dirty2 |= changed3;
        } else {
            obj = $composer;
        }
        int i18 = i61 & 256;
        int i67 = 100663296;
        if (i18 != 0) {
            $dirty2 |= i67;
            i9 = i18;
            obj6 = $changed;
        } else {
            if (i60 & i67 == 0) {
                i9 = i18;
                i13 = restartGroup.changed($changed) ? 67108864 : 33554432;
                $dirty2 |= i13;
            } else {
                i9 = i18;
                obj6 = $changed;
            }
        }
        if ($dirty2 & i == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i32 = -29360129;
                int i69 = -57345;
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (windowInsets2 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        int i53 = 6;
                        if (i61 & 8 != 0) {
                            containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor(restartGroup, i53);
                            $dirty2 &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj9, restartGroup);
                            $dirty2 &= i69;
                        }
                        if (i62 != 0) {
                            tonalElevation2 = containerElevation-D9Ej5fM;
                        }
                        if (i65 != 0) {
                            contentPadding2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = scrollBehavior;
                        }
                        if (i61 & 128 != 0) {
                            windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(restartGroup, i53);
                            $dirty2 &= i32;
                        } else {
                            windowInsets2 = $composer;
                        }
                        if (i9 != 0) {
                            i = contentPadding2;
                            i4 = i47;
                            obj4 = obj5;
                            windowInsets4 = windowInsets2;
                            i9 = tonalElevation2;
                            contentPadding3 = i66;
                            i14 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                        } else {
                            i4 = $changed;
                            i = contentPadding2;
                            obj4 = obj5;
                            windowInsets4 = windowInsets2;
                            i9 = tonalElevation2;
                            contentPadding3 = i66;
                            i14 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            $dirty2 &= i69;
                        }
                        if (i61 & 128 != 0) {
                            i = scrollBehavior;
                            windowInsets4 = $composer;
                            i4 = $changed;
                            $dirty2 = i29;
                            obj4 = obj5;
                            i9 = tonalElevation2;
                            contentPadding3 = i66;
                            i14 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                        } else {
                            i = scrollBehavior;
                            windowInsets4 = $composer;
                            i4 = $changed;
                            obj4 = obj5;
                            i9 = tonalElevation2;
                            contentPadding3 = i66;
                            i14 = -1044837119;
                            tonalElevation2 = containerColor2;
                            i8 = contentColorFor-ek8zF_U;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i14, $dirty2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:750)");
                }
                AppBarKt.BottomAppBar.2 anon = new AppBarKt.BottomAppBar.2(obj7, obj2);
                AppBarKt.BottomAppBar-e-3WI5M(obj4, tonalElevation2, i65, i8, i66, i9, i, windowInsets4, i4, (Function3)ComposableLambdaKt.rememberComposableLambda(1566394874, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj4;
                l2 = tonalElevation2;
                f = i9;
                paddingValues = i;
                windowInsets3 = windowInsets4;
                i5 = i4;
                modifier2 = $dirty2;
                $dirty = obj2;
                l = i8;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                modifier2 = $dirty2;
                $composer2 = obj5;
                $dirty = obj2;
                l2 = containerColor2;
                l = contentColorFor-ek8zF_U;
                f = tonalElevation2;
                paddingValues = scrollBehavior;
                windowInsets3 = $composer;
                i5 = $changed;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.BottomAppBar.3(obj7, $composer2, $dirty, l2, obj5, l, obj2, f, paddingValues, windowInsets3, i5, i60, i61);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final androidx.compose.material3.BottomAppBarState BottomAppBarState(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset) {
        BottomAppBarStateImpl bottomAppBarStateImpl = new BottomAppBarStateImpl(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
        return (BottomAppBarState)bottomAppBarStateImpl;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter")
    public static final void CenterAlignedTopAppBar(Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        int defaultsInvalid;
        Object modifier2;
        int modifier4;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i2;
        Object obj6;
        int windowInsets4;
        int windowInsets2;
        boolean traceInProgress2;
        Object str;
        Object obj7;
        int i3;
        Object obj3;
        Object obj10;
        Object obj9;
        int i7;
        Object obj8;
        Object obj;
        Object obj5;
        int modifier3;
        Object actions2;
        int i5;
        Object windowInsets3;
        int changed;
        Object colors2;
        int changed2;
        float topAppBarExpandedHeight-D9Ej5fM;
        Object obj2;
        int i4;
        Object i;
        Object obj4;
        Composer composer;
        int i6;
        int i8;
        final int i37 = $changed;
        restartGroup = $composer.startRestartGroup(-2139286460);
        ComposerKt.sourceInformation(restartGroup, "C(CenterAlignedTopAppBar)P(5,2,3!1,6)269@12968L12,270@13030L30,273@13122L319:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj = title;
        } else {
            if (i37 & 6 == 0) {
                i2 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                obj = title;
            }
        }
        windowInsets4 = i10 & 2;
        if (windowInsets4 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i37 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                str = modifier;
            }
        }
        int i34 = i10 & 4;
        if (i34 != 0) {
            $dirty2 |= 384;
            obj10 = navigationIcon;
        } else {
            if (i37 & 384 == 0) {
                i7 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i7;
            } else {
                obj10 = navigationIcon;
            }
        }
        int i36 = i10 & 8;
        if (i36 != 0) {
            $dirty2 |= 3072;
            obj5 = actions;
        } else {
            if (i37 & 3072 == 0) {
                i5 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                obj5 = actions;
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
            obj2 = scrollBehavior;
        } else {
            if (i44 &= i37 == 0) {
                i4 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                obj2 = scrollBehavior;
            }
        }
        if (i46 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i47 = -458753;
                int i48 = -57345;
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (windowInsets4 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = str;
                        }
                        if (i34 != 0) {
                            obj10 = windowInsets4;
                        }
                        if (i36 != 0) {
                            obj5 = windowInsets4;
                        }
                        str = 6;
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                            windowInsets3 = windowInsets2;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 &= i47;
                            colors2 = windowInsets4;
                        }
                        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
                            obj4 = windowInsets4;
                            obj2 = windowInsets3;
                            i = colors2;
                            windowInsets3 = obj10;
                            colors2 = obj5;
                            actions2 = modifier2;
                            modifier4 = -2139286460;
                        } else {
                            i = colors2;
                            obj4 = obj2;
                            colors2 = obj5;
                            obj2 = windowInsets3;
                            actions2 = modifier2;
                            windowInsets3 = obj10;
                            modifier4 = -2139286460;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 = i13;
                            i = colors2;
                            obj4 = obj2;
                            modifier4 = -2139286460;
                            colors2 = obj5;
                            obj2 = windowInsets3;
                            actions2 = str;
                            windowInsets3 = obj10;
                        } else {
                            i = colors2;
                            obj4 = obj2;
                            modifier4 = -2139286460;
                            colors2 = obj5;
                            obj2 = windowInsets3;
                            actions2 = str;
                            windowInsets3 = obj10;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier4, $dirty2, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:273)");
                }
                AppBarKt.CenterAlignedTopAppBar-GHTll3U(obj, actions2, windowInsets3, colors2, TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM(), obj2, i, obj4, restartGroup, i20 | i29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = $dirty2;
                $dirty = companion;
                obj6 = windowInsets3;
                obj7 = colors2;
                obj3 = obj2;
                obj9 = i;
                obj8 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = $dirty2;
                $dirty = str;
                obj7 = obj12;
                composer = restartGroup;
                obj6 = obj10;
                obj3 = windowInsets3;
                obj9 = colors2;
                obj8 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.CenterAlignedTopAppBar.1(title, $dirty, obj6, obj7, obj3, obj9, obj8, i37, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void CenterAlignedTopAppBar-GHTll3U(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i11) {
        Object obj4;
        int $dirty;
        int $dirty2;
        int defaultsInvalid;
        Object modifier3;
        boolean traceInProgress2;
        int $dirty4;
        boolean topAppBarExpandedHeight-D9Ej5fM2;
        Object obj;
        int i4;
        int i;
        int topAppBarExpandedHeight-D9Ej5fM;
        int windowInsets2;
        int centerAlignedTopAppBarColors;
        Object obj2;
        Object obj6;
        int $dirty3;
        Object $dirty5;
        int i2;
        boolean traceInProgress;
        float f;
        Object str;
        Object obj9;
        int i7;
        Object obj10;
        Object obj12;
        int i6;
        int i5;
        Object obj5;
        int modifier2;
        Object obj11;
        float value;
        int i13;
        Object obj3;
        int changed;
        Object colors2;
        int changed2;
        int i12;
        int i10;
        Object i8;
        Object obj7;
        int obj8;
        Composer composer;
        int i9;
        int i3;
        final int i50 = $changed;
        final int i51 = i11;
        traceInProgress2 = $composer.startRestartGroup(1952988048);
        ComposerKt.sourceInformation(traceInProgress2, "C(CenterAlignedTopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)328@16080L12,329@16142L30,335@16365L5,332@16234L578:AppBar.kt#uh7d8r");
        $dirty4 = $changed;
        if (i51 & 1 != 0) {
            $dirty4 |= 6;
            obj11 = title;
        } else {
            if (i50 & 6 == 0) {
                i4 = traceInProgress2.changedInstance(title) ? 4 : 2;
                $dirty4 |= i4;
            } else {
                obj11 = title;
            }
        }
        topAppBarExpandedHeight-D9Ej5fM = i51 & 2;
        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
            $dirty4 |= 48;
            obj6 = modifier;
        } else {
            if (i50 & 48 == 0) {
                i2 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty4 |= i2;
            } else {
                obj6 = modifier;
            }
        }
        int i41 = i51 & 4;
        if (i41 != 0) {
            $dirty4 |= 384;
            str = navigationIcon;
        } else {
            if (i50 & 384 == 0) {
                i7 = traceInProgress2.changedInstance(navigationIcon) ? 256 : 128;
                $dirty4 |= i7;
            } else {
                str = navigationIcon;
            }
        }
        int i48 = i51 & 8;
        if (i48 != 0) {
            $dirty4 |= 3072;
            obj12 = actions;
        } else {
            if (i50 & 3072 == 0) {
                i5 = traceInProgress2.changedInstance(actions) ? 2048 : 1024;
                $dirty4 |= i5;
            } else {
                obj12 = actions;
            }
        }
        int i52 = i51 & 16;
        if (i52 != 0) {
            $dirty4 |= 24576;
            value = expandedHeight;
        } else {
            if (i50 & 24576 == 0) {
                i13 = traceInProgress2.changed(expandedHeight) ? 16384 : 8192;
                $dirty4 |= i13;
            } else {
                value = expandedHeight;
            }
        }
        if (i54 &= i50 == 0) {
            if (i51 & 32 == 0) {
                changed = traceInProgress2.changed(windowInsets) ? 131072 : 65536;
            } else {
                obj3 = windowInsets;
            }
            $dirty4 |= changed;
        } else {
            obj3 = windowInsets;
        }
        if (i57 &= i50 == 0) {
            if (i51 & 64 == 0) {
                changed2 = traceInProgress2.changed(colors) ? 1048576 : 524288;
            } else {
                colors2 = colors;
            }
            $dirty4 |= changed2;
        } else {
            colors2 = colors;
        }
        int i15 = i51 & 128;
        int i60 = 12582912;
        if (i15 != 0) {
            $dirty4 |= i60;
            i12 = i15;
            obj4 = scrollBehavior;
        } else {
            if (i50 & i60 == 0) {
                i12 = i15;
                i10 = traceInProgress2.changed(scrollBehavior) ? 8388608 : 4194304;
                $dirty4 |= i10;
            } else {
                i12 = i15;
                obj4 = scrollBehavior;
            }
        }
        final int obj32 = $dirty4;
        if ($dirty4 & i8 == 4793490) {
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
                            modifier3 = obj6;
                        }
                        if (i41 != 0) {
                            str = topAppBarExpandedHeight-D9Ej5fM;
                        }
                        if (i48 != 0) {
                            obj12 = topAppBarExpandedHeight-D9Ej5fM;
                        }
                        if (i52 != 0) {
                            value = topAppBarExpandedHeight-D9Ej5fM;
                        }
                        if (i51 & 32 != 0) {
                            $dirty3 = obj32 & i62;
                            obj3 = windowInsets2;
                        } else {
                            $dirty3 = obj32;
                        }
                        if (i51 & 64 != 0) {
                            $dirty3 &= i63;
                            colors2 = centerAlignedTopAppBarColors;
                        }
                        if (i12 != 0) {
                            obj5 = modifier3;
                            obj8 = i39;
                            changed2 = obj12;
                            $dirty = value;
                            i8 = obj3;
                            obj7 = colors2;
                            i = 1952988048;
                            colors2 = str;
                        } else {
                            obj8 = scrollBehavior;
                            obj5 = modifier3;
                            changed2 = obj12;
                            $dirty = value;
                            i8 = obj3;
                            obj7 = colors2;
                            i = 1952988048;
                            colors2 = str;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty2 = i51 & 32 != 0 ? obj32 & i62 : obj32;
                        if (i51 & 64 != 0) {
                            $dirty2 &= i63;
                        }
                        obj8 = scrollBehavior;
                        obj5 = obj6;
                        changed2 = obj12;
                        i8 = obj3;
                        obj7 = colors2;
                        i = 1952988048;
                        $dirty3 = $dirty2;
                        colors2 = str;
                        $dirty = value;
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i, $dirty3, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:332)");
                }
                if (!Dp.equals-impl0($dirty, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty, Dp.Companion.getInfinity-D9Ej5fM())) {
                        i12 = topAppBarExpandedHeight-D9Ej5fM2;
                    } else {
                        i12 = $dirty;
                    }
                } else {
                }
                AppBarKt.SingleRowTopAppBar-cJHQLPU(obj5, obj11, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress2, i17), true, colors2, changed2, i12, i8, obj7, obj8, traceInProgress2, i25 | i38, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f = $dirty;
                obj = obj5;
                obj2 = colors2;
                obj9 = i8;
                obj10 = obj7;
                i6 = obj8;
                modifier2 = $dirty3;
                $dirty5 = changed2;
            } else {
                traceInProgress2.skipToGroupEnd();
                modifier2 = obj32;
                composer = traceInProgress2;
                obj = obj6;
                obj2 = str;
                $dirty5 = obj12;
                f = value;
                obj9 = obj3;
                obj10 = colors2;
                i6 = scrollBehavior;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new AppBarKt.CenterAlignedTopAppBar.2(title, obj, obj2, $dirty5, f, obj9, obj10, i6, i50, i51);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final void LargeTopAppBar(Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        int defaultsInvalid;
        Object modifier4;
        int modifier2;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i7;
        Object obj10;
        int windowInsets3;
        int windowInsets4;
        boolean traceInProgress2;
        Object str;
        Object obj;
        int i;
        Object obj4;
        Object obj6;
        Object obj5;
        int i6;
        Object obj2;
        Object obj7;
        Object obj8;
        int modifier3;
        Object actions2;
        int i3;
        Object windowInsets2;
        int changed;
        Object colors2;
        int changed2;
        float largeAppBarCollapsedHeight-D9Ej5fM;
        Object largeAppBarExpandedHeight-D9Ej5fM;
        int i4;
        Object i2;
        Object obj9;
        Object obj3;
        Composer composer;
        int i8;
        int i5;
        final int i38 = $changed;
        restartGroup = $composer.startRestartGroup(-474540752);
        ComposerKt.sourceInformation(restartGroup, "C(LargeTopAppBar)P(5,2,3!1,6)541@26855L12,542@26917L22,545@27001L385:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj7 = title;
        } else {
            if (i38 & 6 == 0) {
                i7 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                obj7 = title;
            }
        }
        windowInsets3 = i10 & 2;
        if (windowInsets3 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i38 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i;
            } else {
                str = modifier;
            }
        }
        int i35 = i10 & 4;
        if (i35 != 0) {
            $dirty2 |= 384;
            obj6 = navigationIcon;
        } else {
            if (i38 & 384 == 0) {
                i6 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i6;
            } else {
                obj6 = navigationIcon;
            }
        }
        int i37 = i10 & 8;
        if (i37 != 0) {
            $dirty2 |= 3072;
            obj8 = actions;
        } else {
            if (i38 & 3072 == 0) {
                i3 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                obj8 = actions;
            }
        }
        if (i38 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(windowInsets) ? 16384 : 8192;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= changed;
        } else {
            windowInsets2 = windowInsets;
        }
        if (i42 &= i38 == 0) {
            if (i10 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed2;
        } else {
            colors2 = colors;
        }
        largeAppBarCollapsedHeight-D9Ej5fM = i10 & 64;
        int i45 = 1572864;
        if (largeAppBarCollapsedHeight-D9Ej5fM != 0) {
            $dirty2 |= i45;
            largeAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
        } else {
            if (i45 &= i38 == 0) {
                i4 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                largeAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
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
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = str;
                        }
                        if (i35 != 0) {
                            obj6 = windowInsets3;
                        }
                        if (i37 != 0) {
                            obj8 = windowInsets3;
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
                        if (largeAppBarCollapsedHeight-D9Ej5fM != 0) {
                            obj3 = windowInsets3;
                            i2 = windowInsets2;
                            obj9 = colors2;
                            windowInsets2 = obj6;
                            colors2 = obj8;
                            actions2 = modifier4;
                            modifier2 = -474540752;
                        } else {
                            i2 = windowInsets2;
                            obj9 = colors2;
                            obj3 = largeAppBarExpandedHeight-D9Ej5fM;
                            windowInsets2 = obj6;
                            colors2 = obj8;
                            actions2 = modifier4;
                            modifier2 = -474540752;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i49;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 = i13;
                            i2 = windowInsets2;
                            obj9 = colors2;
                            obj3 = largeAppBarExpandedHeight-D9Ej5fM;
                            modifier2 = -474540752;
                            windowInsets2 = obj6;
                            colors2 = obj8;
                            actions2 = str;
                        } else {
                            i2 = windowInsets2;
                            obj9 = colors2;
                            obj3 = largeAppBarExpandedHeight-D9Ej5fM;
                            modifier2 = -474540752;
                            windowInsets2 = obj6;
                            colors2 = obj8;
                            actions2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty2, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:545)");
                }
                AppBarKt.LargeTopAppBar-oKE7A98(obj7, actions2, windowInsets2, colors2, TopAppBarDefaults.INSTANCE.getLargeAppBarCollapsedHeight-D9Ej5fM(), TopAppBarDefaults.INSTANCE.getLargeAppBarExpandedHeight-D9Ej5fM(), i2, obj9, obj3, restartGroup, i20 | i30, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = $dirty2;
                $dirty = companion;
                obj10 = windowInsets2;
                obj = colors2;
                obj4 = i2;
                obj5 = obj9;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = $dirty2;
                $dirty = str;
                obj = obj12;
                composer = restartGroup;
                obj10 = obj6;
                obj4 = windowInsets2;
                obj5 = colors2;
                obj2 = largeAppBarExpandedHeight-D9Ej5fM;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.LargeTopAppBar.1(title, $dirty, obj10, obj, obj4, obj5, obj2, i38, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void LargeTopAppBar-oKE7A98(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i12) {
        Object obj5;
        Object obj10;
        Object obj3;
        boolean windowInsets3;
        int largeAppBarExpandedHeight-D9Ej5fM2;
        Object windowInsets2;
        int $dirty3;
        Composer traceInProgress;
        int $dirty5;
        Object obj;
        float largeAppBarCollapsedHeight-D9Ej5fM;
        boolean largeAppBarExpandedHeight-D9Ej5fM;
        int i;
        Object expandedHeight2;
        int $dirty;
        float $dirty4;
        Object obj7;
        Object $dirty2;
        int modifier3;
        int i14;
        float f;
        Object colors2;
        boolean traceInProgress2;
        Object str;
        float f3;
        int i6;
        Object obj6;
        int i2;
        Object obj2;
        Object obj9;
        int i3;
        int obj4;
        float f2;
        int modifier2;
        Object collapsedHeight2;
        Object obj11;
        int i11;
        int value;
        float largeTitleBottomPadding;
        int i4;
        int i13;
        int changed2;
        int changed;
        int value2;
        int i7;
        int i15;
        Object obj8;
        float f4;
        float f5;
        WindowInsets windowInsets4;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i5;
        Composer composer;
        int i8;
        int i9;
        int i10;
        final int i53 = $changed;
        final int i54 = i12;
        traceInProgress = $composer.startRestartGroup(-630005584);
        ComposerKt.sourceInformation(traceInProgress, "C(LargeTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)610@30747L12,611@30809L22,616@30993L5,617@31064L5,614@30893L943:AppBar.kt#uh7d8r");
        $dirty5 = $changed;
        if (i54 & 1 != 0) {
            $dirty5 |= 6;
            obj11 = title;
        } else {
            if (i53 & 6 == 0) {
                i = traceInProgress.changedInstance(title) ? 4 : 2;
                $dirty5 |= i;
            } else {
                obj11 = title;
            }
        }
        int i31 = i54 & 2;
        if (i31 != 0) {
            $dirty5 |= 48;
            obj7 = modifier;
        } else {
            if (i53 & 48 == 0) {
                i14 = traceInProgress.changed(modifier) ? 32 : 16;
                $dirty5 |= i14;
            } else {
                obj7 = modifier;
            }
        }
        colors2 = i54 & 4;
        if (colors2 != 0) {
            $dirty5 |= 384;
            str = navigationIcon;
        } else {
            if (i53 & 384 == 0) {
                i6 = traceInProgress.changedInstance(navigationIcon) ? 256 : 128;
                $dirty5 |= i6;
            } else {
                str = navigationIcon;
            }
        }
        i2 = i54 & 8;
        if (i2 != 0) {
            $dirty5 |= 3072;
            obj2 = actions;
        } else {
            if (i53 & 3072 == 0) {
                i3 = traceInProgress.changedInstance(actions) ? 2048 : 1024;
                $dirty5 |= i3;
            } else {
                obj2 = actions;
            }
        }
        int i52 = i54 & 16;
        if (i52 != 0) {
            $dirty5 |= 24576;
            f2 = collapsedHeight;
        } else {
            if (i53 & 24576 == 0) {
                i11 = traceInProgress.changed(collapsedHeight) ? 16384 : 8192;
                $dirty5 |= i11;
            } else {
                f2 = collapsedHeight;
            }
        }
        value = i54 & 32;
        int i56 = 196608;
        if (value != null) {
            $dirty5 |= i56;
            largeTitleBottomPadding = expandedHeight;
        } else {
            if (i56 &= i53 == 0) {
                i4 = traceInProgress.changed(expandedHeight) ? 131072 : 65536;
                $dirty5 |= i4;
            } else {
                largeTitleBottomPadding = expandedHeight;
            }
        }
        if (i53 & i58 == 0) {
            if (i54 & 64 == 0) {
                changed2 = traceInProgress.changed(windowInsets) ? 1048576 : 524288;
            } else {
                obj5 = windowInsets;
            }
            $dirty5 |= changed2;
        } else {
            obj5 = windowInsets;
        }
        if (i53 & i59 == 0) {
            if (i54 & 128 == 0) {
                changed = traceInProgress.changed(colors) ? 8388608 : 4194304;
            } else {
                obj10 = colors;
            }
            $dirty5 |= changed;
        } else {
            obj10 = colors;
        }
        int i18 = i54 & 256;
        int i60 = 100663296;
        if (i18 != 0) {
            $dirty5 |= i60;
            value2 = i18;
            obj3 = scrollBehavior;
        } else {
            if (i53 & i60 == 0) {
                value2 = i18;
                i7 = traceInProgress.changed(scrollBehavior) ? 67108864 : 33554432;
                $dirty5 |= i7;
            } else {
                value2 = i18;
                obj3 = scrollBehavior;
            }
        }
        final int obj38 = $dirty5;
        if ($dirty5 & i15 == 38347922) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i62 = -3670017;
                int i63 = -29360129;
                int i21 = 6;
                if (i53 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            obj7 = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (colors2 != 0) {
                            str = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i2 != 0) {
                            obj2 = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i52 != 0) {
                            f2 = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (value != null) {
                            largeTitleBottomPadding = largeAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i54 & 64 != 0) {
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(traceInProgress, i21);
                            $dirty = obj38 & i62;
                        } else {
                            windowInsets2 = windowInsets;
                            $dirty = obj38;
                        }
                        if (i54 & 128 != 0) {
                            colors2 = TopAppBarDefaults.INSTANCE.largeTopAppBarColors(traceInProgress, i21);
                            $dirty &= i63;
                        } else {
                            colors2 = colors;
                        }
                        if (value2 != null) {
                            windowInsets4 = windowInsets2;
                            topAppBarColors = colors2;
                            i15 = str;
                            i5 = i2;
                            obj8 = obj2;
                            windowInsets3 = f2;
                            collapsedHeight2 = obj7;
                            modifier3 = $dirty;
                            $dirty4 = largeTitleBottomPadding;
                        } else {
                            i5 = scrollBehavior;
                            windowInsets4 = windowInsets2;
                            topAppBarColors = colors2;
                            i15 = str;
                            obj8 = obj2;
                            windowInsets3 = f2;
                            collapsedHeight2 = obj7;
                            modifier3 = $dirty;
                            $dirty4 = largeTitleBottomPadding;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        $dirty3 = i54 & 64 != 0 ? obj38 & i62 : obj38;
                        if (i54 & 128 != 0) {
                            $dirty3 &= i63;
                        }
                        modifier3 = $dirty3;
                        windowInsets3 = f2;
                        collapsedHeight2 = obj13;
                        windowInsets4 = windowInsets;
                        topAppBarColors = colors;
                        i5 = scrollBehavior;
                        i15 = str;
                        obj8 = obj2;
                        $dirty4 = largeTitleBottomPadding;
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-630005584, modifier3, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:614)");
                }
                if (!Dp.equals-impl0(windowInsets3, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0(windowInsets3, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f4 = largeAppBarCollapsedHeight-D9Ej5fM;
                    } else {
                        f4 = windowInsets3;
                    }
                } else {
                }
                if (!Dp.equals-impl0($dirty4, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty4, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f5 = largeAppBarExpandedHeight-D9Ej5fM;
                    } else {
                        f5 = $dirty4;
                    }
                } else {
                }
                AppBarKt.TwoRowsTopAppBar-nS6u9G4(collapsedHeight2, obj11, TypographyKt.getValue(TopAppBarLargeTokens.INSTANCE.getHeadlineFont(), traceInProgress, i21), AppBarKt.LargeTitleBottomPadding, title, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress, i21), i15, obj8, f4, f5, windowInsets4, topAppBarColors, i5, traceInProgress, i27 | i42, i30 | i46, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f = windowInsets3;
                f3 = $dirty4;
                obj = collapsedHeight2;
                expandedHeight2 = i15;
                obj6 = windowInsets4;
                obj9 = topAppBarColors;
                obj4 = i5;
                modifier2 = modifier3;
                $dirty2 = obj8;
            } else {
                traceInProgress.skipToGroupEnd();
                obj6 = windowInsets;
                obj4 = scrollBehavior;
                composer = traceInProgress;
                obj = obj7;
                expandedHeight2 = str;
                $dirty2 = obj2;
                f = f2;
                f3 = largeTitleBottomPadding;
                obj9 = colors;
                modifier2 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            windowInsets3 = new AppBarKt.LargeTopAppBar.2(title, obj, expandedHeight2, $dirty2, f, f3, obj6, obj9, obj4, i53, i54);
            endRestartGroup.updateScope((Function2)windowInsets3);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final void MediumTopAppBar(Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        int defaultsInvalid;
        Object modifier4;
        int modifier3;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int i5;
        Object obj4;
        int windowInsets3;
        int windowInsets4;
        boolean traceInProgress2;
        Object str;
        Object obj3;
        int i;
        Object obj7;
        Object obj8;
        Object obj9;
        int i6;
        Object obj5;
        Object obj6;
        Object obj10;
        int modifier2;
        Object actions2;
        int i7;
        Object windowInsets2;
        int changed;
        Object colors2;
        int changed2;
        float mediumAppBarCollapsedHeight-D9Ej5fM;
        Object mediumAppBarExpandedHeight-D9Ej5fM;
        int i8;
        Object i2;
        Object obj;
        Object obj2;
        Composer composer;
        int i3;
        int i4;
        final int i38 = $changed;
        restartGroup = $composer.startRestartGroup(1805417862);
        ComposerKt.sourceInformation(restartGroup, "C(MediumTopAppBar)P(5,2,3!1,6)396@19336L12,397@19398L23,400@19483L388:AppBar.kt#uh7d8r");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            obj6 = title;
        } else {
            if (i38 & 6 == 0) {
                i5 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj6 = title;
            }
        }
        windowInsets3 = i10 & 2;
        if (windowInsets3 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i38 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i;
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
                i6 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj8 = navigationIcon;
            }
        }
        int i37 = i10 & 8;
        if (i37 != 0) {
            $dirty |= 3072;
            obj10 = actions;
        } else {
            if (i38 & 3072 == 0) {
                i7 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty |= i7;
            } else {
                obj10 = actions;
            }
        }
        if (i38 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(windowInsets) ? 16384 : 8192;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= changed;
        } else {
            windowInsets2 = windowInsets;
        }
        if (i42 &= i38 == 0) {
            if (i10 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty |= changed2;
        } else {
            colors2 = colors;
        }
        mediumAppBarCollapsedHeight-D9Ej5fM = i10 & 64;
        int i45 = 1572864;
        if (mediumAppBarCollapsedHeight-D9Ej5fM != 0) {
            $dirty |= i45;
            mediumAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
        } else {
            if (i45 &= i38 == 0) {
                i8 = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                mediumAppBarExpandedHeight-D9Ej5fM = scrollBehavior;
            }
        }
        if (i47 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i48 = -458753;
                int i49 = -57345;
                if (i38 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (windowInsets3 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = str;
                        }
                        if (i35 != 0) {
                            obj8 = windowInsets3;
                        }
                        if (i37 != 0) {
                            obj10 = windowInsets3;
                        }
                        str = 6;
                        if (i10 & 16 != 0) {
                            $dirty &= i49;
                            windowInsets2 = windowInsets4;
                        }
                        if (i10 & 32 != 0) {
                            $dirty &= i48;
                            colors2 = windowInsets3;
                        }
                        if (mediumAppBarCollapsedHeight-D9Ej5fM != 0) {
                            obj2 = windowInsets3;
                            i2 = windowInsets2;
                            obj = colors2;
                            windowInsets2 = obj8;
                            colors2 = obj10;
                            actions2 = modifier4;
                            modifier3 = 1805417862;
                        } else {
                            i2 = windowInsets2;
                            obj = colors2;
                            obj2 = mediumAppBarExpandedHeight-D9Ej5fM;
                            windowInsets2 = obj8;
                            colors2 = obj10;
                            actions2 = modifier4;
                            modifier3 = 1805417862;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty &= i49;
                        }
                        if (i10 & 32 != 0) {
                            $dirty = i13;
                            i2 = windowInsets2;
                            obj = colors2;
                            obj2 = mediumAppBarExpandedHeight-D9Ej5fM;
                            modifier3 = 1805417862;
                            windowInsets2 = obj8;
                            colors2 = obj10;
                            actions2 = str;
                        } else {
                            i2 = windowInsets2;
                            obj = colors2;
                            obj2 = mediumAppBarExpandedHeight-D9Ej5fM;
                            modifier3 = 1805417862;
                            windowInsets2 = obj8;
                            colors2 = obj10;
                            actions2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier3, $dirty, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:400)");
                }
                AppBarKt.MediumTopAppBar-oKE7A98(obj6, actions2, windowInsets2, colors2, TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM(), TopAppBarDefaults.INSTANCE.getMediumAppBarExpandedHeight-D9Ej5fM(), i2, obj, obj2, restartGroup, i20 | i30, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = $dirty;
                $dirty2 = companion;
                obj4 = windowInsets2;
                obj3 = colors2;
                obj7 = i2;
                obj9 = obj;
                obj5 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = $dirty;
                $dirty2 = str;
                obj3 = obj12;
                composer = restartGroup;
                obj4 = obj8;
                obj7 = windowInsets2;
                obj9 = colors2;
                obj5 = mediumAppBarExpandedHeight-D9Ej5fM;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.MediumTopAppBar.1(title, $dirty2, obj4, obj3, obj7, obj9, obj5, i38, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void MediumTopAppBar-oKE7A98(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i12) {
        Object obj;
        Object obj7;
        Object obj6;
        boolean windowInsets3;
        int mediumAppBarExpandedHeight-D9Ej5fM2;
        Object windowInsets2;
        int $dirty3;
        Composer traceInProgress;
        int $dirty4;
        Object obj2;
        float mediumAppBarCollapsedHeight-D9Ej5fM;
        boolean mediumAppBarExpandedHeight-D9Ej5fM;
        int i;
        Object expandedHeight2;
        int $dirty5;
        float $dirty2;
        Object obj5;
        Object $dirty;
        int modifier2;
        int i11;
        float f5;
        Object colors2;
        boolean traceInProgress2;
        Object str;
        float f3;
        int i3;
        Object obj8;
        int i10;
        Object obj9;
        Object obj4;
        int i13;
        int obj11;
        float f4;
        int modifier3;
        Object collapsedHeight2;
        Object obj3;
        int i8;
        int value;
        float mediumTitleBottomPadding;
        int i4;
        int i7;
        int changed2;
        int changed;
        int value2;
        int i2;
        int i14;
        Object obj10;
        float f;
        float f2;
        WindowInsets windowInsets4;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i15;
        Composer composer;
        int i5;
        int i6;
        int i9;
        final int i53 = $changed;
        final int i54 = i12;
        traceInProgress = $composer.startRestartGroup(1879191686);
        ComposerKt.sourceInformation(traceInProgress, "C(MediumTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)465@23246L12,466@23308L23,472@23523L5,473@23594L5,469@23393L947:AppBar.kt#uh7d8r");
        $dirty4 = $changed;
        if (i54 & 1 != 0) {
            $dirty4 |= 6;
            obj3 = title;
        } else {
            if (i53 & 6 == 0) {
                i = traceInProgress.changedInstance(title) ? 4 : 2;
                $dirty4 |= i;
            } else {
                obj3 = title;
            }
        }
        int i31 = i54 & 2;
        if (i31 != 0) {
            $dirty4 |= 48;
            obj5 = modifier;
        } else {
            if (i53 & 48 == 0) {
                i11 = traceInProgress.changed(modifier) ? 32 : 16;
                $dirty4 |= i11;
            } else {
                obj5 = modifier;
            }
        }
        colors2 = i54 & 4;
        if (colors2 != 0) {
            $dirty4 |= 384;
            str = navigationIcon;
        } else {
            if (i53 & 384 == 0) {
                i3 = traceInProgress.changedInstance(navigationIcon) ? 256 : 128;
                $dirty4 |= i3;
            } else {
                str = navigationIcon;
            }
        }
        i10 = i54 & 8;
        if (i10 != 0) {
            $dirty4 |= 3072;
            obj9 = actions;
        } else {
            if (i53 & 3072 == 0) {
                i13 = traceInProgress.changedInstance(actions) ? 2048 : 1024;
                $dirty4 |= i13;
            } else {
                obj9 = actions;
            }
        }
        int i52 = i54 & 16;
        if (i52 != 0) {
            $dirty4 |= 24576;
            f4 = collapsedHeight;
        } else {
            if (i53 & 24576 == 0) {
                i8 = traceInProgress.changed(collapsedHeight) ? 16384 : 8192;
                $dirty4 |= i8;
            } else {
                f4 = collapsedHeight;
            }
        }
        value = i54 & 32;
        int i56 = 196608;
        if (value != null) {
            $dirty4 |= i56;
            mediumTitleBottomPadding = expandedHeight;
        } else {
            if (i56 &= i53 == 0) {
                i4 = traceInProgress.changed(expandedHeight) ? 131072 : 65536;
                $dirty4 |= i4;
            } else {
                mediumTitleBottomPadding = expandedHeight;
            }
        }
        if (i53 & i58 == 0) {
            if (i54 & 64 == 0) {
                changed2 = traceInProgress.changed(windowInsets) ? 1048576 : 524288;
            } else {
                obj = windowInsets;
            }
            $dirty4 |= changed2;
        } else {
            obj = windowInsets;
        }
        if (i53 & i59 == 0) {
            if (i54 & 128 == 0) {
                changed = traceInProgress.changed(colors) ? 8388608 : 4194304;
            } else {
                obj7 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj7 = colors;
        }
        int i18 = i54 & 256;
        int i60 = 100663296;
        if (i18 != 0) {
            $dirty4 |= i60;
            value2 = i18;
            obj6 = scrollBehavior;
        } else {
            if (i53 & i60 == 0) {
                value2 = i18;
                i2 = traceInProgress.changed(scrollBehavior) ? 67108864 : 33554432;
                $dirty4 |= i2;
            } else {
                value2 = i18;
                obj6 = scrollBehavior;
            }
        }
        final int obj38 = $dirty4;
        if ($dirty4 & i14 == 38347922) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i62 = -3670017;
                int i63 = -29360129;
                int i21 = 6;
                if (i53 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            obj5 = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (colors2 != 0) {
                            str = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i10 != 0) {
                            obj9 = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i52 != 0) {
                            f4 = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (value != null) {
                            mediumTitleBottomPadding = mediumAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i54 & 64 != 0) {
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(traceInProgress, i21);
                            $dirty5 = obj38 & i62;
                        } else {
                            windowInsets2 = windowInsets;
                            $dirty5 = obj38;
                        }
                        if (i54 & 128 != 0) {
                            colors2 = TopAppBarDefaults.INSTANCE.mediumTopAppBarColors(traceInProgress, i21);
                            $dirty5 &= i63;
                        } else {
                            colors2 = colors;
                        }
                        if (value2 != null) {
                            windowInsets4 = windowInsets2;
                            topAppBarColors = colors2;
                            i14 = str;
                            i15 = i10;
                            obj10 = obj9;
                            windowInsets3 = f4;
                            collapsedHeight2 = obj5;
                            modifier2 = $dirty5;
                            $dirty2 = mediumTitleBottomPadding;
                        } else {
                            i15 = scrollBehavior;
                            windowInsets4 = windowInsets2;
                            topAppBarColors = colors2;
                            i14 = str;
                            obj10 = obj9;
                            windowInsets3 = f4;
                            collapsedHeight2 = obj5;
                            modifier2 = $dirty5;
                            $dirty2 = mediumTitleBottomPadding;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        $dirty3 = i54 & 64 != 0 ? obj38 & i62 : obj38;
                        if (i54 & 128 != 0) {
                            $dirty3 &= i63;
                        }
                        modifier2 = $dirty3;
                        windowInsets3 = f4;
                        collapsedHeight2 = obj13;
                        windowInsets4 = windowInsets;
                        topAppBarColors = colors;
                        i15 = scrollBehavior;
                        i14 = str;
                        obj10 = obj9;
                        $dirty2 = mediumTitleBottomPadding;
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1879191686, modifier2, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:469)");
                }
                if (!Dp.equals-impl0(windowInsets3, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0(windowInsets3, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f = mediumAppBarCollapsedHeight-D9Ej5fM;
                    } else {
                        f = windowInsets3;
                    }
                } else {
                }
                if (!Dp.equals-impl0($dirty2, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty2, Dp.Companion.getInfinity-D9Ej5fM())) {
                        f2 = mediumAppBarExpandedHeight-D9Ej5fM;
                    } else {
                        f2 = $dirty2;
                    }
                } else {
                }
                AppBarKt.TwoRowsTopAppBar-nS6u9G4(collapsedHeight2, obj3, TypographyKt.getValue(TopAppBarMediumTokens.INSTANCE.getHeadlineFont(), traceInProgress, i21), AppBarKt.MediumTitleBottomPadding, title, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress, i21), i14, obj10, f, f2, windowInsets4, topAppBarColors, i15, traceInProgress, i27 | i42, i30 | i46, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = windowInsets3;
                f3 = $dirty2;
                obj2 = collapsedHeight2;
                expandedHeight2 = i14;
                obj8 = windowInsets4;
                obj4 = topAppBarColors;
                obj11 = i15;
                modifier3 = modifier2;
                $dirty = obj10;
            } else {
                traceInProgress.skipToGroupEnd();
                obj8 = windowInsets;
                obj11 = scrollBehavior;
                composer = traceInProgress;
                obj2 = obj5;
                expandedHeight2 = str;
                $dirty = obj9;
                f5 = f4;
                f3 = mediumTitleBottomPadding;
                obj4 = colors;
                modifier3 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            windowInsets3 = new AppBarKt.MediumTopAppBar.2(title, obj2, expandedHeight2, $dirty, f5, f3, obj8, obj4, obj11, i53, i54);
            endRestartGroup.updateScope((Function2)windowInsets3);
        }
    }

    private static final void SingleRowTopAppBar-cJHQLPU(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, TextStyle titleTextStyle, boolean centeredTitle, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i13) {
        Modifier draggable$default;
        Object derivedStateOf;
        float coerceAtLeast;
        Object appBarContainerColor$delegate;
        Object it$iv;
        int i18;
        int i19;
        boolean $dirty;
        int i3;
        Object restartGroup;
        int pinned;
        int $dirty3;
        Object modifier2;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        boolean traceInProgress;
        int i14;
        Object anon;
        int i22;
        Modifier f;
        Object str;
        Object rememberedValue;
        long obj5;
        Object obj6;
        int i12;
        Object obj7;
        int i27;
        int i8;
        int i2;
        Object obj4;
        Object empty2;
        int i10;
        boolean z;
        int empty;
        int i21;
        Object obj;
        int i25;
        int i23;
        int i11;
        boolean naN;
        int i28;
        int i29;
        int i26;
        Object obj8;
        Object rememberedValue2;
        int i4;
        Composer composer;
        Composer i20;
        int companion3;
        int i24;
        int companion2;
        Object obj2;
        int companion4;
        int i5;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int $dirty2;
        float expandedHeightPx;
        State state;
        androidx.compose.ui.Modifier.Companion companion;
        androidx.compose.foundation.gestures.DraggableState rememberDraggableState;
        Orientation vertical;
        int i6;
        int i15;
        int i9;
        int i16;
        Object obj3;
        int i;
        int i17;
        int i7;
        final Object obj10 = actions;
        f = expandedHeight;
        obj5 = colors;
        obj6 = scrollBehavior;
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
                i12 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i12;
            } else {
                str = modifier;
            }
        }
        if (i33 & 2 != 0) {
            $dirty3 |= 48;
            obj7 = title;
        } else {
            if (draggable$default & 48 == 0) {
                i2 = restartGroup.changedInstance(title) ? 32 : 16;
                $dirty3 |= i2;
            } else {
                obj7 = title;
            }
        }
        if (i33 & 4 != 0) {
            $dirty3 |= 384;
            obj4 = titleTextStyle;
        } else {
            if (draggable$default & 384 == 0) {
                i10 = restartGroup.changed(titleTextStyle) ? 256 : 128;
                $dirty3 |= i10;
            } else {
                obj4 = titleTextStyle;
            }
        }
        if (i33 & 8 != 0) {
            $dirty3 |= 3072;
            z = centeredTitle;
        } else {
            if (draggable$default & 3072 == 0) {
                i21 = restartGroup.changed(centeredTitle) ? 2048 : 1024;
                $dirty3 |= i21;
            } else {
                z = centeredTitle;
            }
        }
        if (i33 & 16 != 0) {
            $dirty3 |= 24576;
            obj = navigationIcon;
        } else {
            if (draggable$default & 24576 == 0) {
                i28 = restartGroup.changedInstance(navigationIcon) ? 16384 : 8192;
                $dirty3 |= i28;
            } else {
                obj = navigationIcon;
            }
        }
        int i71 = 196608;
        if (i33 & 32 != 0) {
            $dirty3 |= i71;
        } else {
            if (draggable$default & i71 == 0) {
                i29 = restartGroup.changedInstance(obj10) ? 131072 : 65536;
                $dirty3 |= i29;
            }
        }
        int i72 = 1572864;
        if (i33 & 64 != 0) {
            $dirty3 |= i72;
        } else {
            if (draggable$default & i72 == 0) {
                i26 = restartGroup.changed(f) ? 1048576 : 524288;
                $dirty3 |= i26;
            }
        }
        i4 = 12582912;
        if (i33 & 128 != 0) {
            $dirty3 |= i4;
            obj8 = windowInsets;
        } else {
            if (draggable$default & i4 == 0) {
                i4 = restartGroup.changed(windowInsets) ? 8388608 : 4194304;
                $dirty3 |= i4;
            } else {
                obj8 = windowInsets;
            }
        }
        i20 = 100663296;
        if (i33 & 256 != 0) {
            $dirty3 |= i20;
        } else {
            if (draggable$default & i20 == 0) {
                i18 = restartGroup.changed(obj5) ? 67108864 : 33554432;
                $dirty3 |= i18;
            }
        }
        if (i33 & 512 != 0) {
            i19 = 805306368;
            $dirty3 |= i19;
        } else {
        }
        $dirty = $dirty3;
        if ($dirty4 &= $dirty == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (rememberComposableLambda != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-342194911, $dirty, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1861)");
                }
                int i49 = 0;
                if (!Float.isNaN(expandedHeight)) {
                    i4 = 0;
                    i20 = Float.compare(naN, i76) == 0 ? 1 : 0;
                    i23 = i20 == 0 ? 1 : 0;
                } else {
                }
                if (i23 == 0) {
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
                    i14 = $dirty & i43 == 536870912 ? 1 : 0;
                    Composer composer5 = restartGroup;
                    int i74 = 0;
                    it$iv = composer5.rememberedValue();
                    companion3 = 0;
                    if (i14 |= changed5 == 0) {
                        $dirty2 = $dirty;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $dirty = 0;
                            obj2 = it$iv;
                            it$iv = new AppBarKt.SingleRowTopAppBar.2.1(obj6, coerceAtLeast);
                            composer5.updateRememberedValue((Function0)it$iv);
                        } else {
                            obj2 = it$iv;
                        }
                    } else {
                        $dirty2 = $dirty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.SideEffect((Function0)it$iv, restartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1193635911, rememberedValue);
                    i3 = $dirty2 & i78 == 536870912 ? 1 : 0;
                    Composer composer3 = restartGroup;
                    int i67 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    int i75 = 0;
                    if (i3 == 0) {
                        expandedHeightPx = coerceAtLeast;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            companion3 = expandedHeightPx2;
                            AppBarKt.SingleRowTopAppBar.colorTransitionFraction.2.1 anon2 = new AppBarKt.SingleRowTopAppBar.colorTransitionFraction.2.1(obj6);
                            composer3.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)anon2));
                        } else {
                            derivedStateOf = rememberedValue3;
                        }
                    } else {
                        expandedHeightPx = coerceAtLeast;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    state = derivedStateOf;
                    rememberedValue2 = 0;
                    i22 = rememberedValue2;
                    Composer composer6 = restartGroup;
                    int i32 = 536870912;
                    Composer composer4 = composer6;
                    AppBarKt.SingleRowTopAppBar.actionsRow.1 anon3 = new AppBarKt.SingleRowTopAppBar.actionsRow.1(obj10);
                    empty = 1;
                    androidx.compose.runtime.internal.ComposableLambda composableLambda2 = rememberComposableLambda2;
                    composer4.startReplaceGroup(-1193605157);
                    ComposerKt.sourceInformation(composer4, "1908@87542L55,1908@87519L78,1909@87631L283");
                    if (obj6 != null && !obj6.isPinned()) {
                        if (!obj6.isPinned()) {
                            ComposerKt.sourceInformationMarkerStart(composer4, -1193599057, rememberedValue);
                            i27 = $dirty2 & i78 == i32 ? empty : 0;
                            empty2 = composer4;
                            i11 = 0;
                            rememberedValue2 = empty2.rememberedValue();
                            i24 = 0;
                            if (i27 == 0) {
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    empty = 0;
                                    anon = new AppBarKt.SingleRowTopAppBar.appBarDragModifier.1.1(obj6);
                                    empty2.updateRememberedValue((Function1)anon);
                                } else {
                                    anon = rememberedValue2;
                                }
                            } else {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            int i59 = 0;
                            ComposerKt.sourceInformationMarkerStart(composer4, -1193595981, rememberedValue);
                            i22 = $dirty2 & i78 == i32 ? 1 : i59;
                            Composer composer2 = composer4;
                            pinned = 0;
                            rememberedValue = composer2.rememberedValue();
                            i8 = 0;
                            if (i22 == 0) {
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    empty2 = 0;
                                    empty = new AppBarKt.SingleRowTopAppBar.appBarDragModifier.2.1(obj6, 0);
                                    composer2.updateRememberedValue((Function3)empty);
                                } else {
                                    empty = rememberedValue;
                                }
                            } else {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            draggable$default = DraggableKt.draggable$default((Modifier)Modifier.Companion, DraggableKt.rememberDraggableState((Function1)anon, composer4, i59), Orientation.Vertical, false, 0, false, 0, (Function3)empty, false, 188, 0);
                        } else {
                            draggable$default = Modifier.Companion;
                        }
                    } else {
                    }
                    composer4.endReplaceGroup();
                    obj4 = title;
                    AppBarKt.SingleRowTopAppBar.3 anon4 = new AppBarKt.SingleRowTopAppBar.3(windowInsets, expandedHeight, obj6, obj5, obj4, titleTextStyle, centeredTitle, navigationIcon, (Function2)composableLambda2);
                    composableLambda = composableLambda2;
                    i20 = composer4;
                    SurfaceKt.Surface-T9BRK9s(modifier2.then(draggable$default), 0, AppBarKt.SingleRowTopAppBar_cJHQLPU$lambda$10(SingleValueAnimationKt.animateColorAsState-euL9pac(obj5.containerColor-vNxB06k$material3_release(AppBarKt.SingleRowTopAppBar_cJHQLPU$lambda$9((State)derivedStateOf)), obj4, (AnimationSpec)AnimationSpecKt.spring$default(0, 1137180672, rememberedValue2, 5, rememberedValue2), 0, rememberedValue2, composer6, 48)), obj6, 0, obj4, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1943739546, true, anon4, composer4, 54), i20);
                    composer = i20;
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
                $dirty2 = $dirty;
                composer = restartGroup;
                appBarContainerColor$delegate = str;
            }
        } else {
        }
        int i30 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
        throw illegalArgumentException;
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
        Object modifier3;
        int modifier4;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i6;
        Object obj;
        int windowInsets4;
        int windowInsets2;
        boolean traceInProgress;
        Object str;
        Object obj9;
        int i7;
        Object obj10;
        Object obj7;
        Object obj2;
        int i3;
        Object obj5;
        Object obj3;
        Object obj6;
        int modifier2;
        Object actions2;
        int i8;
        Object windowInsets3;
        int changed;
        Object colors2;
        int changed2;
        float topAppBarExpandedHeight-D9Ej5fM;
        Object obj4;
        int i;
        Object i4;
        Object obj8;
        Composer composer;
        int i2;
        int i5;
        final int i37 = $changed;
        restartGroup = $composer.startRestartGroup(1906353009);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(5,2,3!1,6)142@6819L12,143@6881L17,146@6960L306:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = title;
        } else {
            if (i37 & 6 == 0) {
                i6 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty2 |= i6;
            } else {
                obj3 = title;
            }
        }
        windowInsets4 = i10 & 2;
        if (windowInsets4 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i37 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i7;
            } else {
                str = modifier;
            }
        }
        int i34 = i10 & 4;
        if (i34 != 0) {
            $dirty2 |= 384;
            obj7 = navigationIcon;
        } else {
            if (i37 & 384 == 0) {
                i3 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                obj7 = navigationIcon;
            }
        }
        int i36 = i10 & 8;
        if (i36 != 0) {
            $dirty2 |= 3072;
            obj6 = actions;
        } else {
            if (i37 & 3072 == 0) {
                i8 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i8;
            } else {
                obj6 = actions;
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
            obj4 = scrollBehavior;
        } else {
            if (i44 &= i37 == 0) {
                i = restartGroup.changed(scrollBehavior) ? 1048576 : 524288;
                $dirty2 |= i;
            } else {
                obj4 = scrollBehavior;
            }
        }
        if (i46 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i47 = -458753;
                int i48 = -57345;
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (windowInsets4 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = str;
                        }
                        if (i34 != 0) {
                            obj7 = windowInsets4;
                        }
                        if (i36 != 0) {
                            obj6 = windowInsets4;
                        }
                        str = 6;
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                            windowInsets3 = windowInsets2;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 &= i47;
                            colors2 = windowInsets4;
                        }
                        if (topAppBarExpandedHeight-D9Ej5fM != 0) {
                            obj8 = windowInsets4;
                            obj4 = windowInsets3;
                            i4 = colors2;
                            windowInsets3 = obj7;
                            colors2 = obj6;
                            actions2 = modifier3;
                            modifier4 = 1906353009;
                        } else {
                            i4 = colors2;
                            obj8 = obj4;
                            colors2 = obj6;
                            obj4 = windowInsets3;
                            actions2 = modifier3;
                            windowInsets3 = obj7;
                            modifier4 = 1906353009;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i48;
                        }
                        if (i10 & 32 != 0) {
                            $dirty2 = i13;
                            i4 = colors2;
                            obj8 = obj4;
                            modifier4 = 1906353009;
                            colors2 = obj6;
                            obj4 = windowInsets3;
                            actions2 = str;
                            windowInsets3 = obj7;
                        } else {
                            i4 = colors2;
                            obj8 = obj4;
                            modifier4 = 1906353009;
                            colors2 = obj6;
                            obj4 = windowInsets3;
                            actions2 = str;
                            windowInsets3 = obj7;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier4, $dirty2, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:146)");
                }
                AppBarKt.TopAppBar-GHTll3U(obj3, actions2, windowInsets3, colors2, TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM(), obj4, i4, obj8, restartGroup, i20 | i29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = $dirty2;
                $dirty = companion;
                obj = windowInsets3;
                obj9 = colors2;
                obj10 = obj4;
                obj2 = i4;
                obj5 = obj8;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = $dirty2;
                $dirty = str;
                obj9 = obj12;
                composer = restartGroup;
                obj = obj7;
                obj10 = windowInsets3;
                obj2 = colors2;
                obj5 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.TopAppBar.1(title, $dirty, obj, obj9, obj10, obj2, obj5, i37, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void TopAppBar-GHTll3U(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int i11) {
        Object obj2;
        int $dirty4;
        int $dirty3;
        int defaultsInvalid;
        Object modifier3;
        boolean traceInProgress;
        int $dirty2;
        boolean topAppBarExpandedHeight-D9Ej5fM;
        Object obj;
        int i5;
        int i8;
        int topAppBarExpandedHeight-D9Ej5fM2;
        int windowInsets2;
        int topAppBarColors;
        Object obj9;
        Object obj6;
        int $dirty5;
        Object $dirty;
        int i;
        boolean traceInProgress2;
        float f;
        Object str;
        Object obj12;
        int i9;
        Object obj5;
        Object obj11;
        int i3;
        int i6;
        Object obj3;
        int modifier2;
        Object obj7;
        float value;
        int i10;
        Object obj4;
        int changed2;
        Object colors2;
        int changed;
        int i12;
        int i13;
        Object i4;
        Object obj8;
        int obj10;
        Composer composer;
        int i7;
        int i2;
        final int i50 = $changed;
        final int i51 = i11;
        traceInProgress = $composer.startRestartGroup(226148675);
        ComposerKt.sourceInformation(traceInProgress, "C(TopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)204@9890L12,205@9952L17,211@10162L5,208@10031L579:AppBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i51 & 1 != 0) {
            $dirty2 |= 6;
            obj7 = title;
        } else {
            if (i50 & 6 == 0) {
                i5 = traceInProgress.changedInstance(title) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                obj7 = title;
            }
        }
        topAppBarExpandedHeight-D9Ej5fM2 = i51 & 2;
        if (topAppBarExpandedHeight-D9Ej5fM2 != 0) {
            $dirty2 |= 48;
            obj6 = modifier;
        } else {
            if (i50 & 48 == 0) {
                i = traceInProgress.changed(modifier) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj6 = modifier;
            }
        }
        int i41 = i51 & 4;
        if (i41 != 0) {
            $dirty2 |= 384;
            str = navigationIcon;
        } else {
            if (i50 & 384 == 0) {
                i9 = traceInProgress.changedInstance(navigationIcon) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                str = navigationIcon;
            }
        }
        int i48 = i51 & 8;
        if (i48 != 0) {
            $dirty2 |= 3072;
            obj11 = actions;
        } else {
            if (i50 & 3072 == 0) {
                i6 = traceInProgress.changedInstance(actions) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                obj11 = actions;
            }
        }
        int i52 = i51 & 16;
        if (i52 != 0) {
            $dirty2 |= 24576;
            value = expandedHeight;
        } else {
            if (i50 & 24576 == 0) {
                i10 = traceInProgress.changed(expandedHeight) ? 16384 : 8192;
                $dirty2 |= i10;
            } else {
                value = expandedHeight;
            }
        }
        if (i54 &= i50 == 0) {
            if (i51 & 32 == 0) {
                changed2 = traceInProgress.changed(windowInsets) ? 131072 : 65536;
            } else {
                obj4 = windowInsets;
            }
            $dirty2 |= changed2;
        } else {
            obj4 = windowInsets;
        }
        if (i57 &= i50 == 0) {
            if (i51 & 64 == 0) {
                changed = traceInProgress.changed(colors) ? 1048576 : 524288;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed;
        } else {
            colors2 = colors;
        }
        int i15 = i51 & 128;
        int i60 = 12582912;
        if (i15 != 0) {
            $dirty2 |= i60;
            i12 = i15;
            obj2 = scrollBehavior;
        } else {
            if (i50 & i60 == 0) {
                i12 = i15;
                i13 = traceInProgress.changed(scrollBehavior) ? 8388608 : 4194304;
                $dirty2 |= i13;
            } else {
                i12 = i15;
                obj2 = scrollBehavior;
            }
        }
        final int obj32 = $dirty2;
        if ($dirty2 & i4 == 4793490) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i62 = -458753;
                int i63 = -3670017;
                int i17 = 6;
                if (i50 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (topAppBarExpandedHeight-D9Ej5fM2 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj6;
                        }
                        if (i41 != 0) {
                            str = topAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i48 != 0) {
                            obj11 = topAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i52 != 0) {
                            value = topAppBarExpandedHeight-D9Ej5fM2;
                        }
                        if (i51 & 32 != 0) {
                            $dirty5 = obj32 & i62;
                            obj4 = windowInsets2;
                        } else {
                            $dirty5 = obj32;
                        }
                        if (i51 & 64 != 0) {
                            $dirty5 &= i63;
                            colors2 = topAppBarColors;
                        }
                        if (i12 != 0) {
                            obj3 = modifier3;
                            obj10 = i39;
                            changed = obj11;
                            $dirty4 = value;
                            i4 = obj4;
                            obj8 = colors2;
                            i8 = 226148675;
                            colors2 = str;
                        } else {
                            obj10 = scrollBehavior;
                            obj3 = modifier3;
                            changed = obj11;
                            $dirty4 = value;
                            i4 = obj4;
                            obj8 = colors2;
                            i8 = 226148675;
                            colors2 = str;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        $dirty3 = i51 & 32 != 0 ? obj32 & i62 : obj32;
                        if (i51 & 64 != 0) {
                            $dirty3 &= i63;
                        }
                        obj10 = scrollBehavior;
                        obj3 = obj6;
                        changed = obj11;
                        i4 = obj4;
                        obj8 = colors2;
                        i8 = 226148675;
                        $dirty5 = $dirty3;
                        colors2 = str;
                        $dirty4 = value;
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, $dirty5, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:208)");
                }
                if (!Dp.equals-impl0($dirty4, Dp.Companion.getUnspecified-D9Ej5fM())) {
                    if (Dp.equals-impl0($dirty4, Dp.Companion.getInfinity-D9Ej5fM())) {
                        i12 = topAppBarExpandedHeight-D9Ej5fM;
                    } else {
                        i12 = $dirty4;
                    }
                } else {
                }
                AppBarKt.SingleRowTopAppBar-cJHQLPU(obj3, obj7, TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), traceInProgress, i17), false, colors2, changed, i12, i4, obj8, obj10, traceInProgress, i25 | i38, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f = $dirty4;
                obj = obj3;
                obj9 = colors2;
                obj12 = i4;
                obj5 = obj8;
                i3 = obj10;
                modifier2 = $dirty5;
                $dirty = changed;
            } else {
                traceInProgress.skipToGroupEnd();
                modifier2 = obj32;
                composer = traceInProgress;
                obj = obj6;
                obj9 = str;
                $dirty = obj11;
                f = value;
                obj12 = obj4;
                obj5 = colors2;
                i3 = scrollBehavior;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = new AppBarKt.TopAppBar.2(title, obj, obj9, $dirty, f, obj12, obj5, i3, i50, i51);
            endRestartGroup.updateScope((Function2)$dirty4);
        }
    }

    private static final void TopAppBarLayout-kXwM9vE(Modifier modifier, androidx.compose.material3.ScrolledOffset scrolledOffset, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Function2<? super Composer, ? super Integer, Unit> title, TextStyle titleTextStyle, float titleAlpha, Arrangement.Vertical titleVerticalArrangement, Arrangement.Horizontal titleHorizontalArrangement, int titleBottomPadding, boolean hideTitleSemantics, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function2<? super Composer, ? super Integer, Unit> actions, Composer $composer, int $changed, int $changed1) {
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        boolean traceInProgress2;
        Object endRestartGroup;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        int obj3;
        Object materialized$iv$iv;
        Object obj5;
        Object obj2;
        float f;
        Object obj;
        boolean currentCompositionLocalMap2;
        Modifier clearAndSetSemantics;
        boolean maybeCachedBoxMeasurePolicy2;
        boolean currentCompositionLocalMap;
        int i31;
        Object it$iv;
        Composer composer6;
        Object valueOf2;
        int i28;
        int i25;
        Object obj6;
        int $dirty3;
        Object restartGroup;
        int $dirty2;
        long $dirty4;
        long l;
        int i9;
        int i10;
        Composer composer5;
        float topAppBarHorizontalPadding;
        Composer composer;
        Object currentCompositionLocalMap3;
        int valueOf;
        int skipping;
        boolean traceInProgress;
        int changedInstance2;
        int i5;
        int i36;
        Composer composer3;
        Object maybeCachedBoxMeasurePolicy;
        int i2;
        boolean changedInstance;
        int i30;
        int $dirty1;
        int maybeCachedBoxMeasurePolicy3;
        int i29;
        long l3;
        long l2;
        int i15;
        int currentCompositeKeyHash;
        int $dirty6;
        int $dirty;
        int companion;
        Object obj4;
        int i6;
        int i27;
        int i38;
        int i26;
        int i21;
        int i19;
        Modifier modifier4;
        int i;
        int i32;
        int i8;
        kotlin.jvm.functions.Function0 function0;
        int i22;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        Composer composer4;
        Composer $composer2;
        Modifier modifier2;
        int i39;
        int i3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        int i35;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int i23;
        int i16;
        int i11;
        Composer composer7;
        int i17;
        int i37;
        int i12;
        int i20;
        int i18;
        int $dirty5;
        kotlin.jvm.functions.Function0 function02;
        int i33;
        int i24;
        int i13;
        Composer composer2;
        androidx.compose.material3.AppBarKt.TopAppBarLayout.2.1 measurePolicy$iv2;
        int i7;
        int i14;
        Modifier modifier3;
        int i4;
        int i34;
        androidx.compose.runtime.CompositionLocalMap map2;
        ScopeUpdateScope scopeUpdateScope;
        int obj76;
        obj3 = modifier;
        materialized$iv$iv = scrolledOffset;
        final Object obj7 = navigationIcon;
        final int i117 = actions;
        final boolean z5 = $composer;
        traceInProgress2 = $changed;
        obj5 = $changed1;
        int i61 = obj77;
        i28 = obj78;
        restartGroup = obj76.startRestartGroup(-742442296);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBarLayout)P(3,6,5:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,2,4)2163@98873L5882,2135@97725L7030:AppBar.kt#uh7d8r");
        int i89 = obj78;
        if (i61 & 6 == 0) {
            i2 = restartGroup.changed(obj3) ? 4 : 2;
            $dirty2 |= i2;
        }
        if (i61 & 48 == 0) {
            if (i61 & 64 == 0) {
                changedInstance = restartGroup.changed(materialized$iv$iv);
            } else {
                changedInstance = restartGroup.changedInstance(materialized$iv$iv);
            }
            i30 = changedInstance != null ? 32 : 16;
            $dirty2 |= i30;
        }
        if (i61 & 384 == 0) {
            currentCompositeKeyHash = restartGroup.changed(navigationIconContentColor) ? 256 : 128;
            $dirty2 |= currentCompositeKeyHash;
        } else {
            l3 = navigationIconContentColor;
        }
        if (i61 & 3072 == 0) {
            $dirty1 = i89;
            i6 = restartGroup.changed(actionIconContentColor) ? 2048 : 1024;
            i128 |= i6;
        } else {
            $dirty6 = $dirty2;
            $dirty1 = i89;
            $dirty4 = actionIconContentColor;
        }
        if (i61 & 24576 == 0) {
            i25 = restartGroup.changed(titleTextStyle) ? 16384 : 8192;
            $dirty6 |= i25;
        } else {
            l = titleTextStyle;
        }
        if (i75 &= i61 == 0) {
            i27 = restartGroup.changedInstance(titleVerticalArrangement) ? 131072 : 65536;
            $dirty6 |= i27;
        } else {
            obj6 = titleVerticalArrangement;
        }
        if (i61 & i133 == 0) {
            i38 = restartGroup.changed(titleHorizontalArrangement) ? 1048576 : 524288;
            $dirty6 |= i38;
        } else {
            obj2 = titleHorizontalArrangement;
        }
        if (obj77 & i134 == 0) {
            i26 = restartGroup.changed(titleBottomPadding) ? 8388608 : 4194304;
            $dirty6 |= i26;
        } else {
            f = titleBottomPadding;
        }
        if (obj77 & i135 == 0) {
            i21 = restartGroup.changed(hideTitleSemantics) ? 67108864 : 33554432;
            $dirty6 |= i21;
        } else {
            obj = hideTitleSemantics;
        }
        if (obj77 & i136 == 0) {
            i19 = restartGroup.changed(obj7) ? 536870912 : 268435456;
            $dirty6 |= i19;
        }
        $dirty3 = $dirty6;
        if (i28 & 6 == 0) {
            $dirty = restartGroup.changed(i117) ? 4 : 2;
            $dirty1 |= $dirty;
        }
        if (i28 & 48 == 0) {
            companion = restartGroup.changed(z5) ? 32 : 16;
            $dirty1 |= companion;
        }
        if (i28 & 384 == 0) {
            i9 = restartGroup.changedInstance(traceInProgress2) ? 256 : 128;
            $dirty1 |= i9;
        }
        if (i28 & 3072 == 0) {
            i10 = restartGroup.changedInstance(obj5) ? 2048 : 1024;
            $dirty1 |= i10;
        }
        valueOf = $dirty1;
        if (i90 &= $dirty3 == 306783378 && valueOf & 1171 == 1170) {
            if (valueOf & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-742442296, $dirty3, valueOf, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2134)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1539011656, "CC(remember):AppBar.kt#9igjgp");
                    if ($dirty3 & 112 != 32) {
                        if ($dirty3 & 64 != 0 && restartGroup.changedInstance(materialized$iv$iv)) {
                            if (restartGroup.changedInstance(materialized$iv$iv)) {
                                i5 = 1;
                            } else {
                                i5 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                    i31 = i104 &= $dirty3 == 536870912 ? 1 : 0;
                    i36 = i92 &= $dirty3 == 67108864 ? 1 : 0;
                    i29 = valueOf & 14 == 4 ? 1 : 0;
                    Composer composer11 = restartGroup;
                    int i108 = 0;
                    it$iv = composer11.rememberedValue();
                    int i120 = 0;
                    if (i72 |= i29 == 0) {
                        $dirty5 = $dirty3;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $dirty3 = 0;
                            obj4 = it$iv;
                            it$iv = new AppBarKt.TopAppBarLayout.2.1(materialized$iv$iv, obj7, obj, i117);
                            composer11.updateRememberedValue((MeasurePolicy)it$iv);
                        } else {
                            obj4 = it$iv;
                        }
                    } else {
                        $dirty5 = $dirty3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i77 &= 112;
                    String str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4 = restartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, obj3);
                    kotlin.jvm.functions.Function0 function08 = constructor;
                    i33 = 0;
                    i13 = i78;
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
                    Composer composer12 = constructor-impl2;
                    int i141 = 0;
                    if (!composer12.getInserting()) {
                        measurePolicy$iv2 = it$iv;
                        i7 = valueOf;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer5 = composer12;
                        }
                    } else {
                        measurePolicy$iv2 = it$iv;
                        i7 = valueOf;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    valueOf2 = composer2;
                    i14 = i56;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 9049318, "C2137@97755L280,2143@98048L502,2155@98563L264:AppBar.kt#uh7d8r");
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "navigationIcon"), AppBarKt.TopAppBarHorizontalPadding, 0, 0, 0, 14, 0);
                    int i122 = 0;
                    modifier3 = materializeModifier2;
                    i4 = i83;
                    String str3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, str3);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    int i130 = i85;
                    int $changed$iv6 = 0;
                    i34 = i95;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, $changed$iv6);
                    int i143 = 0;
                    Alignment alignment = topStart;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf2, 0);
                    currentCompositionLocalMap2 = valueOf2.getCurrentCompositionLocalMap();
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
                    map2 = currentCompositionLocalMap4;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i171 = 0;
                    Composer composer17 = constructor-impl3;
                    int i177 = 0;
                    if (!composer17.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap2;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer17;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap2;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
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
                    Composer materialized$iv$iv2 = composer18;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 249765716, "C2138@97858L163:AppBar.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(l3)), traceInProgress2, materialized$iv$iv2, $stable2 |= i179);
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
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, str3);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    int i115 = 0;
                    int i118 = i63;
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i115);
                    int i161 = 0;
                    int i163 = i86;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf2, 0);
                    currentCompositionLocalMap3 = valueOf2.getCurrentCompositionLocalMap();
                    Alignment alignment2 = topStart2;
                    Modifier modifier7 = graphicsLayer-Ap8cVGQ$default;
                    kotlin.jvm.functions.Function0 function06 = constructor2;
                    i39 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, $changed$iv5);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf2.startReusableNode();
                    if (valueOf2.getInserting()) {
                        valueOf2.createNode(function06);
                    } else {
                        factory$iv$iv$iv = function06;
                        valueOf2.useNode();
                    }
                    kotlin.jvm.functions.Function0 function07 = factory$iv$iv$iv;
                    Composer constructor-impl = Updater.constructor-impl(valueOf2);
                    int i125 = 0;
                    i35 = i115;
                    Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Composer composer13 = constructor-impl;
                    int i144 = 0;
                    if (!composer13.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                        map = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer13;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                        map = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf2, graphicsLayer-Ap8cVGQ$default), ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = valueOf2;
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv3);
                    BoxScopeInstance iNSTANCE2 = BoxScopeInstance.INSTANCE;
                    i23 = i127 | 6;
                    Composer composer14 = composer9;
                    i16 = 0;
                    i11 = i44;
                    i17 = i88;
                    ComposerKt.sourceInformationMarkerStart(composer14, 250255454, "C2149@98351L185:AppBar.kt#uh7d8r");
                    ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(actionIconContentColor, 0, titleHorizontalArrangement, titleVerticalArrangement, composer14);
                    ComposerKt.sourceInformationMarkerEnd(composer14);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    valueOf2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "actionIcons"), 0, 0, AppBarKt.TopAppBarHorizontalPadding, 0, 11, 0);
                    int i68 = 6;
                    valueOf = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, str3);
                    companion = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str);
                    currentCompositionLocalMap = valueOf2.getCurrentCompositionLocalMap();
                    obj76 = currentCompositeKeyHash2;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(valueOf2, padding-qDBjuR0$default);
                    modifier4 = padding-qDBjuR0$default;
                    kotlin.jvm.functions.Function0 function03 = constructor3;
                    i19 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, $changed$iv5);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf2.startReusableNode();
                    if (valueOf2.getInserting()) {
                        valueOf2.createNode(function03);
                    } else {
                        factory$iv$iv$iv2 = function03;
                        valueOf2.useNode();
                    }
                    Composer constructor-impl4 = Updater.constructor-impl(valueOf2);
                    int i148 = 0;
                    function0 = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i158 = 0;
                    Composer composer16 = constructor-impl4;
                    int i165 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap;
                        composer4 = valueOf2;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(obj76))) {
                            composer16.updateRememberedValue(Integer.valueOf(obj76));
                            constructor-impl4.apply(Integer.valueOf(obj76), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer16;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap;
                        composer4 = valueOf2;
                    }
                    Updater.set-impl(constructor-impl4, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    obj = composer4;
                    i28 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, -2146769399, $changed$iv3);
                    i81 |= 6;
                    i8 = 0;
                    i22 = i51;
                    boxScopeInstance = iNSTANCE;
                    modifier2 = materializeModifier;
                    materialized$iv$iv = composer15;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 250561951, "C2156@98661L152:AppBar.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(titleTextStyle)), obj5, materialized$iv$iv, $stable |= i);
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    $dirty5 = $dirty3;
                    composer2 = restartGroup;
                    i7 = valueOf;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = composer2;
            endRestartGroup = new AppBarKt.TopAppBarLayout.3(modifier, scrolledOffset, l3, obj, actionIconContentColor, $dirty3, titleTextStyle, valueOf, titleVerticalArrangement, titleHorizontalArrangement, titleBottomPadding, hideTitleSemantics, obj7, i117, z5, $changed, obj5, obj77, obj78);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = composer2;
        }
    }

    private static final void TwoRowsTopAppBar-nS6u9G4(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, TextStyle titleTextStyle, float titleBottomPadding, Function2<? super Composer, ? super Integer, Unit> smallTitle, TextStyle smallTitleTextStyle, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, androidx.compose.material3.TopAppBarColors colors, androidx.compose.material3.TopAppBarScrollBehavior scrollBehavior, Composer $composer, int $changed, int $changed1, int i17) {
        Object obj8;
        Object obj3;
        int i7;
        int i5;
        int i10;
        int colorTransitionFraction;
        Object endRestartGroup;
        int i20;
        Object it$iv2;
        int collapsedFraction;
        Object it$iv;
        Object modifier2;
        int skipping;
        int traceInProgress;
        Object $i$f$cache;
        Object obj2;
        Object obj6;
        int changed3;
        int changed;
        int $dirty1;
        float empty;
        Object rememberedValue;
        Object restartGroup;
        int $dirty;
        Object rememberComposableLambda;
        int i14;
        int i25;
        int $dirty12;
        int i2;
        boolean traceInProgress2;
        int i18;
        float f;
        float f2;
        int i23;
        Object empty2;
        Object obj4;
        Object obj;
        Object expandedHeightPx;
        boolean naN2;
        int i4;
        int i15;
        int i27;
        float f3;
        Object obj5;
        int i21;
        int i35;
        int i13;
        int i34;
        int i26;
        boolean naN;
        int i11;
        int i22;
        Composer composer;
        int i3;
        int i28;
        int companion;
        int i33;
        int i;
        int i6;
        int i32;
        int changed2;
        int i16;
        Ref.IntRef intRef;
        int i29;
        int i36;
        long containerColor-vNxB06k$material3_release;
        Object companion2;
        Object obj7;
        androidx.compose.foundation.gestures.DraggableState rememberDraggableState;
        Orientation vertical;
        int i8;
        int i12;
        int i19;
        int i24;
        androidx.compose.material3.AppBarKt.TwoRowsTopAppBar.appBarDragModifier.2.1 anon;
        int i9;
        int i31;
        int i30;
        float topTitleAlpha;
        int i37;
        ScopeUpdateScope scopeUpdateScope;
        Object obj43;
        int obj56;
        empty = titleBottomPadding;
        final Object obj9 = actions;
        f = collapsedHeight;
        f2 = expandedHeight;
        obj4 = colors;
        obj = scrollBehavior;
        int i38 = $changed;
        int i45 = $changed1;
        traceInProgress = i17;
        restartGroup = $composer.startRestartGroup(1169193376);
        ComposerKt.sourceInformation(restartGroup, "C(TwoRowsTopAppBar)P(4,9,11,10:c#ui.unit.Dp,7,8,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,12)*1984@90586L7,1992@90915L205,1992@90904L216,2008@91751L197,2042@93233L2309,2042@93149L2393:AppBar.kt#uh7d8r");
        $dirty = $changed;
        $dirty12 = $changed1;
        i23 = traceInProgress & 1;
        if (i23 != 0) {
            $dirty |= 6;
            expandedHeightPx = modifier;
        } else {
            if (i38 & 6 == 0) {
                i21 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i21;
            } else {
                expandedHeightPx = modifier;
            }
        }
        i11 = 16;
        if (traceInProgress & 2 != 0) {
            $dirty |= 48;
            obj5 = title;
        } else {
            if (i38 & 48 == 0) {
                i22 = restartGroup.changedInstance(title) ? i26 : i11;
                $dirty |= i22;
            } else {
                obj5 = title;
            }
        }
        if (traceInProgress & 4 != 0) {
            $dirty |= 384;
            obj2 = titleTextStyle;
        } else {
            if (i38 & 384 == 0) {
                i33 = restartGroup.changed(titleTextStyle) ? 256 : i28;
                $dirty |= i33;
            } else {
                obj2 = titleTextStyle;
            }
        }
        if (traceInProgress & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i38 & 3072 == 0) {
                obj2 = restartGroup.changed(empty) ? 2048 : 1024;
                $dirty |= obj2;
            }
        }
        if (traceInProgress & 16 != 0) {
            $dirty |= 24576;
            obj6 = smallTitle;
        } else {
            if (i38 & 24576 == 0) {
                i = restartGroup.changedInstance(smallTitle) ? 16384 : 8192;
                $dirty |= i;
            } else {
                obj6 = smallTitle;
            }
        }
        int i77 = 196608;
        if (traceInProgress & 32 != 0) {
            $dirty |= i77;
            obj8 = smallTitleTextStyle;
        } else {
            if (i38 & i77 == 0) {
                i6 = restartGroup.changed(smallTitleTextStyle) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                obj8 = smallTitleTextStyle;
            }
        }
        i16 = 1572864;
        if (traceInProgress & 64 != 0) {
            $dirty |= i16;
            obj3 = navigationIcon;
        } else {
            if ($changed & i16 == 0) {
                i32 = restartGroup.changedInstance(navigationIcon) ? 1048576 : 524288;
                $dirty |= i32;
            } else {
                obj3 = navigationIcon;
            }
        }
        int i76 = 12582912;
        if (traceInProgress & 128 != 0) {
            $dirty |= i76;
        } else {
            if ($changed & i76 == 0) {
                i7 = restartGroup.changedInstance(obj9) ? 8388608 : 4194304;
                $dirty |= i7;
            }
        }
        changed2 = 100663296;
        if (traceInProgress & 256 != 0) {
            $dirty |= changed2;
        } else {
            if ($changed & changed2 == 0) {
                i5 = restartGroup.changed(f) ? 67108864 : 33554432;
                $dirty |= i5;
            }
        }
        if (traceInProgress & 512 != 0) {
            i10 = 805306368;
            $dirty |= i10;
        } else {
        }
        colorTransitionFraction = $dirty;
        if (traceInProgress & 1024 != 0) {
            $dirty12 |= 6;
            rememberComposableLambda = windowInsets;
        } else {
            if (i45 & 6 == 0) {
                i35 = restartGroup.changed(windowInsets) ? 4 : 2;
                $dirty12 |= i35;
            } else {
                rememberComposableLambda = windowInsets;
            }
        }
        if (traceInProgress & 2048 != 0) {
            $dirty12 |= 48;
        } else {
            if (i45 & 48 == 0) {
                if (restartGroup.changed(obj4)) {
                } else {
                    i26 = i11;
                }
                $dirty12 |= i26;
            }
        }
        if (traceInProgress & 4096 != 0) {
            $dirty12 |= 384;
        } else {
            if (i45 & 384 == 0 && restartGroup.changed(obj)) {
                if (restartGroup.changed(obj)) {
                    i28 = 256;
                }
                $dirty12 |= i28;
            }
        }
        $dirty1 = $dirty12;
        if ($dirty13 &= colorTransitionFraction == 306783378 && $dirty1 & 147 == 146) {
            if ($dirty1 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = expandedHeightPx;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1169193376, colorTransitionFraction, $dirty1, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1971)");
                    }
                    int i68 = 0;
                    if (!Float.isNaN(collapsedHeight)) {
                        i35 = 0;
                        i26 = Float.compare(naN2, i72) == 0 ? 1 : 0;
                        i4 = i26 == 0 ? 1 : 0;
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                        i13 = 0;
                        if (!Float.isNaN(expandedHeight)) {
                            i13 = 0;
                            naN = Float.compare(f3, i73) == 0 ? 1 : 0;
                            i15 = naN == 0 ? 1 : 0;
                        } else {
                        }
                        if (i15 == 0) {
                        } else {
                            i27 = Dp.compareTo-0680j_4(f2, f) >= 0 ? 1 : 0;
                            if (i27 == 0) {
                            } else {
                                Ref.FloatRef floatRef = new Ref.FloatRef();
                                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                                Ref.IntRef intRef2 = new Ref.IntRef();
                                int i70 = 0;
                                int i74 = 0;
                                i36 = colorTransitionFraction;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                int i62 = 0;
                                floatRef.element = (Density)consume.toPx-0680j_4(f2);
                                Ref.FloatRef num = obj43;
                                num.element = consume.toPx-0680j_4(f);
                                obj43 = consume;
                                Ref.IntRef $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416 = obj56;
                                $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416.element = consume.roundToPx-0680j_4(empty);
                                Unit iNSTANCE = Unit.INSTANCE;
                                empty2 = "CC(remember):AppBar.kt#9igjgp";
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 1641215730, empty2);
                                i20 = $dirty1 & 896 == 256 ? 1 : 0;
                                Composer composer3 = restartGroup;
                                int i71 = 0;
                                it$iv2 = composer3.rememberedValue();
                                int i75 = 0;
                                if (i41 |= changed8 == 0) {
                                    if (it$iv2 == Composer.Companion.getEmpty()) {
                                        empty = 0;
                                        obj56 = it$iv2;
                                        it$iv2 = new AppBarKt.TwoRowsTopAppBar.5.1(obj, num, floatRef);
                                        composer3.updateRememberedValue((Function0)it$iv2);
                                    } else {
                                        obj56 = it$iv2;
                                    }
                                } else {
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                EffectsKt.SideEffect((Function0)it$iv2, restartGroup, 0);
                                it$iv2 = obj.getState();
                                if (obj != null && it$iv2 != null) {
                                    it$iv2 = obj.getState();
                                    if (it$iv2 != null) {
                                        collapsedFraction = it$iv2.getCollapsedFraction();
                                    } else {
                                        collapsedFraction = 0;
                                    }
                                } else {
                                }
                                AppBarKt.TwoRowsTopAppBar.actionsRow.1 anon2 = new AppBarKt.TwoRowsTopAppBar.actionsRow.1(obj9);
                                obj43 = num;
                                i25 = 1;
                                androidx.compose.runtime.internal.ComposableLambda composableLambda = rememberComposableLambda2;
                                $i$f$cache = AppBarKt.TopTitleAlphaEasing.transform(collapsedFraction);
                                i34 = Float.compare(collapsedFraction, i54) < 0 ? i25 : 0;
                                i29 = i34 == 0 ? i25 : 0;
                                restartGroup.startReplaceGroup(1641266888);
                                ComposerKt.sourceInformation(restartGroup, "2028@92709L55,2028@92686L78,2029@92798L283");
                                if (obj != null && !obj.isPinned()) {
                                    if (!obj.isPinned()) {
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1641272988, empty2);
                                        i14 = $dirty1 & 896 == 256 ? 1 : 0;
                                        Composer composer4 = restartGroup;
                                        companion = 0;
                                        obj56 = collapsedFraction;
                                        it$iv = composer4.rememberedValue();
                                        changed2 = 0;
                                        if (i14 == 0) {
                                            topTitleAlpha = $i$f$cache;
                                            if (it$iv == Composer.Companion.getEmpty()) {
                                                $i$f$cache = 0;
                                                obj7 = it$iv;
                                                it$iv = new AppBarKt.TwoRowsTopAppBar.appBarDragModifier.1.1(obj);
                                                composer4.updateRememberedValue((Function1)it$iv);
                                            } else {
                                                obj7 = it$iv;
                                            }
                                        } else {
                                            topTitleAlpha = $i$f$cache;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        int i46 = 0;
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1641276064, empty2);
                                        i18 = $dirty1 & 896 == 256 ? 1 : i46;
                                        Composer composer2 = restartGroup;
                                        int i47 = 0;
                                        rememberedValue = composer2.rememberedValue();
                                        i25 = 0;
                                        if (i18 == 0) {
                                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                                empty2 = 0;
                                                i3 = i47;
                                                i37 = $dirty1;
                                                $i$f$cache = new AppBarKt.TwoRowsTopAppBar.appBarDragModifier.2.1(obj, 0);
                                                composer2.updateRememberedValue((Function3)$i$f$cache);
                                            } else {
                                                i3 = i47;
                                                i37 = $dirty1;
                                                $i$f$cache = rememberedValue;
                                            }
                                        } else {
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        colorTransitionFraction = DraggableKt.draggable$default((Modifier)Modifier.Companion, DraggableKt.rememberDraggableState((Function1)it$iv, restartGroup, i46), Orientation.Vertical, false, 0, false, 0, (Function3)$i$f$cache, false, 188, 0);
                                    } else {
                                        obj56 = collapsedFraction;
                                        topTitleAlpha = $i$f$cache;
                                        i37 = $dirty1;
                                        colorTransitionFraction = Modifier.Companion;
                                    }
                                } else {
                                }
                                restartGroup.endReplaceGroup();
                                $dirty1 = floatRef;
                                expandedHeightPx = smallTitleTextStyle;
                                AppBarKt.TwoRowsTopAppBar.6 anon3 = new AppBarKt.TwoRowsTopAppBar.6(windowInsets, collapsedHeight, obj4, smallTitle, expandedHeightPx, topTitleAlpha, i34, navigationIcon, (Function2)composableLambda, f2, obj, obj5, titleTextStyle, i53 - collapsedFraction, $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416, i29);
                                i2 = i34;
                                empty = composableLambda;
                                SurfaceKt.Surface-T9BRK9s(modifier2.then(colorTransitionFraction), 0, obj4.containerColor-vNxB06k$material3_release(collapsedFraction), obj4, 0, expandedHeightPx, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1350062619, true, anon3, restartGroup, 54), restartGroup);
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
                            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
                            throw illegalArgumentException2;
                        }
                        int $dirty9 = colorTransitionFraction;
                        int $dirty5 = 0;
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
                        throw illegalArgumentException3;
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    i36 = colorTransitionFraction;
                    i37 = $dirty1;
                    composer = restartGroup;
                    modifier2 = expandedHeightPx;
                }
            } else {
            }
        } else {
        }
        int $dirty7 = colorTransitionFraction;
        int $dirty2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
        throw illegalArgumentException;
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
        int i;
        int changed2;
        int i2;
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
                i = $changed & 6 == i10 ? i14 : obj14;
            } else {
            }
        } else {
        }
        int i16 = 32;
        if (i11 ^= 48 > i16) {
            if (!$composer.changed(obj10)) {
                i2 = $changed & 48 == i16 ? i14 : obj14;
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
        boolean changed;
        int i;
        int changed2;
        int i2;
        int changed3;
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
                i = $changed & 6 == i10 ? i14 : obj14;
            } else {
            }
        } else {
        }
        int i16 = 32;
        if (i11 ^= 48 > i16) {
            if (!$composer.changed(obj10)) {
                i2 = $changed & 48 == i16 ? i14 : obj14;
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
        int i7;
        float snapAnimationSpec2;
        Object snapAnimationSpec;
        int heightOffsetLimit2;
        int heightOffsetLimit;
        Object state;
        int cmp;
        Object l$0;
        int lastValue;
        androidx.compose.material3.AppBarKt.settleAppBar.1 anon2;
        int remainingVelocity;
        int i;
        androidx.compose.material3.TopAppBarState topAppBarState2;
        Object obj;
        Object velocity;
        Object heightOffset;
        long l;
        int i3;
        int i6;
        int i8;
        int i2;
        int i5;
        int i4;
        androidx.compose.material3.AppBarKt.settleAppBar.2 anon;
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
        anon2 = anon3;
        Object result = anon2.result;
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
                anon2.L$0 = topAppBarState2;
                anon2.L$1 = snapAnimationSpec;
                anon2.L$2 = floatRef;
                anon2.label = remainingVelocity;
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
                anon2.L$0 = velocity;
                int i10 = 0;
                anon2.L$1 = i10;
                anon2.L$2 = i10;
                anon2.label = 2;
                remainingVelocity = anon2;
                anon2 = remainingVelocity;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = velocity;
                velocity = cOROUTINE_SUSPENDED;
                return Velocity.box-impl(VelocityKt.Velocity(i12, velocity.element));
                heightOffset = snapAnimationSpec;
                snapAnimationSpec = f;
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
            case 1:
                snapAnimationSpec2 = anon2.L$2;
                heightOffsetLimit2 = anon2.L$1;
                l$0 = anon2.L$0;
                ResultKt.throwOnFailure(result);
                break;
            case 2:
                cOROUTINE_SUSPENDED = anon2.L$0;
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
        int i8;
        float snapAnimationSpec;
        Object snapAnimationSpec2;
        int heightOffsetLimit2;
        int heightOffsetLimit;
        Object state;
        int cmp;
        Object l$0;
        int lastValue;
        androidx.compose.material3.AppBarKt.settleAppBarBottom.1 anon2;
        int remainingVelocity;
        int i;
        androidx.compose.material3.BottomAppBarState bottomAppBarState2;
        Object obj;
        Object velocity;
        Object heightOffset;
        long l;
        int i6;
        int i7;
        int i2;
        int i4;
        int i3;
        int i5;
        androidx.compose.material3.AppBarKt.settleAppBarBottom.2 anon3;
        obj2 = continuation5;
        anon = obj2;
        heightOffsetLimit2 = Integer.MIN_VALUE;
        if (obj2 instanceof AppBarKt.settleAppBarBottom.1 && label2 &= heightOffsetLimit2 != 0) {
            anon = obj2;
            heightOffsetLimit2 = Integer.MIN_VALUE;
            if (label2 &= heightOffsetLimit2 != 0) {
                anon.label = label -= heightOffsetLimit2;
            } else {
                anon = new AppBarKt.settleAppBarBottom.1(obj2);
            }
        } else {
        }
        anon2 = anon;
        Object result = anon2.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i12 = 0;
        switch (snapAnimationSpec) {
            case 0:
                ResultKt.throwOnFailure(result);
                bottomAppBarState2 = bottomAppBarState;
                heightOffsetLimit2 = decayAnimationSpec3;
                float f = f2;
                snapAnimationSpec2 = animationSpec4;
                lastValue = 1065353216;
                remainingVelocity = 1;
                cmp = remainingVelocity;
                cmp = 0;
                Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = f;
                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                AppBarKt.settleAppBarBottom.2 anon5 = new AppBarKt.settleAppBarBottom.2(floatRef2, bottomAppBarState2, floatRef);
                anon2.L$0 = bottomAppBarState2;
                anon2.L$1 = snapAnimationSpec2;
                anon2.L$2 = floatRef;
                anon2.label = remainingVelocity;
                obj = floatRef2;
                return cOROUTINE_SUSPENDED;
                l$0 = bottomAppBarState2;
                snapAnimationSpec = velocity;
                heightOffsetLimit2 = heightOffset;
                snapAnimationSpec = f;
                velocity = floatRef;
                obj = bottomAppBarState2;
                state = heightOffset;
                heightOffsetLimit = i12;
                heightOffsetLimit = obj.getHeightOffsetLimit();
                AppBarKt.settleAppBarBottom.3 anon4 = new AppBarKt.settleAppBarBottom.3(obj);
                anon2.L$0 = velocity;
                int i10 = 0;
                anon2.L$1 = i10;
                anon2.L$2 = i10;
                anon2.label = 2;
                remainingVelocity = anon2;
                anon2 = remainingVelocity;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = velocity;
                velocity = cOROUTINE_SUSPENDED;
                return Velocity.box-impl(VelocityKt.Velocity(i12, velocity.element));
                heightOffset = snapAnimationSpec2;
                snapAnimationSpec2 = f;
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
            case 1:
                snapAnimationSpec = anon2.L$2;
                heightOffsetLimit2 = anon2.L$1;
                l$0 = anon2.L$0;
                ResultKt.throwOnFailure(result);
                break;
            case 2:
                cOROUTINE_SUSPENDED = anon2.L$0;
                ResultKt.throwOnFailure(result);
                velocity = cOROUTINE_SUSPENDED;
                return Velocity.box-impl(VelocityKt.Velocity(i12, velocity.element));
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        velocity = snapAnimationSpec;
        obj = l$0;
        state = heightOffsetLimit2;
    }
}
