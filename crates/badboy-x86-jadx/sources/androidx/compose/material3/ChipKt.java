package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\u001a¨\u0001\u0010\u0010\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010&2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a»\u0001\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000c2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0003ø\u0001\u0000¢\u0006\u0004\u0008/\u00100\u001a\u0094\u0001\u00101\u001a\u00020\u00112\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\u00085\u00106\u001a¨\u0001\u00107\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u00107\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010&2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a°\u0001\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020:2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010<\u001a\u0091\u0001\u0010=\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010=\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010&2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a°\u0001\u0010A\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020:2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010<\u001aÇ\u0001\u0010B\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020:2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010C\u001aÐ\u0001\u0010D\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0006\u0010)\u001a\u00020*2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020:2\u0008\u0010\u001f\u001a\u0004\u0018\u00010;2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0003ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\u001a\u0091\u0001\u0010G\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010G\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010&2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a&\u0010H\u001a\u00020\u00012\u0008\u0008\u0002\u0010I\u001a\u00020\u00192\u0008\u0008\u0002\u0010J\u001a\u00020\u00192\u0008\u0008\u0002\u0010K\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000b\u001a\u00020\u000c*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006L", d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LabelLayoutId", "", "LeadingIconLayoutId", "SuggestionChipPadding", "TrailingIconLayoutId", "defaultSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChipKt {

    private static final PaddingValues AssistChipPadding = null;
    private static final PaddingValues FilterChipPadding = null;
    private static final float HorizontalElementsPadding = 0f;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding = null;
    private static final String TrailingIconLayoutId = "trailingIcon";
    static {
        int i2 = 0;
        ChipKt.HorizontalElementsPadding = Dp.constructor-impl((float)i);
        int i3 = 0;
        int i4 = 2;
        final int i5 = 0;
        ChipKt.AssistChipPadding = PaddingKt.PaddingValues-YgX7TsA$default(ChipKt.HorizontalElementsPadding, i3, i4, i5);
        ChipKt.FilterChipPadding = PaddingKt.PaddingValues-YgX7TsA$default(ChipKt.HorizontalElementsPadding, i3, i4, i5);
        ChipKt.SuggestionChipPadding = PaddingKt.PaddingValues-YgX7TsA$default(ChipKt.HorizontalElementsPadding, i3, i4, i5);
    }

    public static final void AssistChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj5;
        Object obj10;
        Object obj2;
        int $dirty16;
        int skipping;
        int $dirty7;
        int defaultsInvalid;
        Object modifier2;
        int $dirty;
        int $dirty2;
        Object endRestartGroup;
        int i7;
        int assistChipElevation-aqJV_2Y;
        Object assistChipBorder-h1eT-Ww;
        Object $dirty12;
        boolean traceInProgress;
        boolean enabled2;
        int $dirty1;
        int i21;
        int i8;
        Object obj7;
        int assistChipColors;
        boolean traceInProgress2;
        int i6;
        int shape2;
        Object $dirty4;
        boolean z;
        Object obj4;
        Object obj;
        Object obj6;
        Object obj8;
        int i19;
        Shape shape3;
        int i;
        Object $composer2;
        boolean z3;
        androidx.compose.material3.ChipElevation chipElevation;
        int i22;
        BorderStroke borderStroke;
        int i9;
        Object obj15;
        int i11;
        int i3;
        Object obj11;
        Object obj12;
        int $dirty3;
        Object leadingIcon2;
        int i4;
        Modifier i17;
        int i20;
        int i10;
        int changed4;
        Object i18;
        int i16;
        int changed3;
        int changed;
        int changed2;
        int $dirty14;
        TextStyle $dirty15;
        int i12;
        int labelColor-vNxB06k$material3_release;
        int i13;
        int $dirty13;
        Object obj13;
        boolean z2;
        Object colors2;
        Object obj3;
        Object $dirty6;
        int $dirty5;
        Object obj14;
        Object obj16;
        Object obj9;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        int i14;
        Composer composer;
        int i2;
        int i5;
        Object obj36;
        final int i77 = $changed;
        final int i78 = i15;
        Composer restartGroup = $composer.startRestartGroup(313450168);
        ComposerKt.sourceInformation(restartGroup, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)126@6277L5,127@6328L18,128@6399L21,129@6469L25,137@6729L5,132@6561L541:Chip.kt#uh7d8r");
        $dirty = $changed;
        if (i78 & 1 != 0) {
            $dirty |= 6;
            obj15 = onClick;
        } else {
            if (i77 & 6 == 0) {
                i21 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i21;
            } else {
                obj15 = onClick;
            }
        }
        if (i78 & 2 != 0) {
            $dirty |= 48;
            obj11 = label;
        } else {
            if (i77 & 48 == 0) {
                i8 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty |= i8;
            } else {
                obj11 = label;
            }
        }
        i6 = i78 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            obj6 = modifier;
        } else {
            if (i77 & 384 == 0) {
                i19 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i19;
            } else {
                obj6 = modifier;
            }
        }
        i = i78 & 8;
        if (i != 0) {
            $dirty |= 3072;
            z3 = enabled;
        } else {
            if (i77 & 3072 == 0) {
                i22 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i22;
            } else {
                z3 = enabled;
            }
        }
        i9 = i78 & 16;
        if (i9 != 0) {
            $dirty |= 24576;
            obj12 = leadingIcon;
        } else {
            if (i77 & 24576 == 0) {
                i4 = restartGroup.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                obj12 = leadingIcon;
            }
        }
        i17 = i78 & 32;
        i20 = 196608;
        if (i17 != 0) {
            $dirty |= i20;
            $dirty4 = trailingIcon;
        } else {
            if (i77 & i20 == 0) {
                i20 = restartGroup.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty |= i20;
            } else {
                $dirty4 = trailingIcon;
            }
        }
        if (i77 & i80 == 0) {
            if (i78 & 64 == 0) {
                changed4 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj5 = shape;
            }
            $dirty |= changed4;
        } else {
            obj5 = shape;
        }
        if (i77 & i81 == 0) {
            if (i78 & 128 == 0) {
                changed3 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj4 = colors;
            }
            $dirty |= changed3;
        } else {
            obj4 = colors;
        }
        if (i77 & i82 == 0) {
            if (i78 & 256 == 0) {
                changed = restartGroup.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj10 = elevation;
            }
            $dirty |= changed;
        } else {
            obj10 = elevation;
        }
        if (i77 & i83 == 0) {
            if (i78 & 512 == 0) {
                changed2 = restartGroup.changed(border) ? 536870912 : 268435456;
            } else {
                obj2 = border;
            }
            $dirty |= changed2;
        } else {
            obj2 = border;
        }
        $dirty14 = i30;
        $dirty12 = i78 & 1024;
        if ($dirty12 != 0) {
            $dirty14 |= 6;
            labelColor-vNxB06k$material3_release = $dirty12;
        } else {
            if ($changed1 & 6 == 0) {
                labelColor-vNxB06k$material3_release = $dirty12;
                i13 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty14 |= i13;
            } else {
                labelColor-vNxB06k$material3_release = $dirty12;
                $dirty12 = interactionSource;
            }
        }
        traceInProgress = $dirty14;
        final int obj45 = $dirty;
        if ($dirty & $dirty15 == 306783378 && traceInProgress & 3 == 2) {
            if (traceInProgress & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i16 = -234881025;
                    int i27 = -29360129;
                    i12 = -3670017;
                    i13 = traceInProgress;
                    $dirty1 = 6;
                    if (i77 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj6;
                            }
                            z2 = i != 0 ? i6 : z3;
                            if (i9 != 0) {
                                obj12 = i6;
                            }
                            i17 = i17 != 0 ? i6 : $dirty4;
                            if (i78 & 64 != 0) {
                                $dirty4 = obj45 & i12;
                                i12 = shape2;
                            } else {
                                i12 = shape;
                                $dirty4 = obj45;
                            }
                            if (i78 & 128 != 0) {
                                obj3 = assistChipColors;
                                $dirty5 = $dirty4;
                            } else {
                                obj3 = obj4;
                                $dirty5 = $dirty4;
                            }
                            if (i78 & 256 != 0) {
                                obj36 = modifier2;
                                $dirty16 = i13;
                                i3 = obj14;
                                $dirty5 &= i16;
                                i16 = assistChipElevation-aqJV_2Y;
                            } else {
                                obj36 = modifier2;
                                i3 = $dirty1;
                                $dirty16 = i13;
                                i16 = elevation;
                            }
                            if (i78 & 512 != 0) {
                                assistChipBorder-h1eT-Ww = AssistChipDefaults.INSTANCE.assistChipBorder-h1eT-Ww(z2, 0, $dirty4, 0, obj6, 0, restartGroup);
                                $dirty5 &= assistChipColors;
                            } else {
                                enabled2 = z2;
                                assistChipBorder-h1eT-Ww = border;
                            }
                            if (labelColor-vNxB06k$material3_release != 0) {
                                obj9 = assistChipBorder-h1eT-Ww;
                                i14 = assistChipColors;
                                obj13 = obj12;
                                obj16 = i16;
                                obj4 = obj3;
                                $dirty2 = $dirty5;
                                leadingIcon2 = obj36;
                                colors2 = i17;
                                $dirty6 = i12;
                            } else {
                                i14 = interactionSource;
                                obj9 = assistChipBorder-h1eT-Ww;
                                obj13 = obj12;
                                obj16 = i16;
                                obj4 = obj3;
                                $dirty2 = $dirty5;
                                leadingIcon2 = obj36;
                                colors2 = i17;
                                $dirty6 = i12;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty7 = i78 & 64 != 0 ? obj45 & i12 : obj45;
                            if (i78 & 128 != 0) {
                                $dirty7 &= i27;
                            }
                            if (i78 & 256 != 0) {
                                $dirty7 &= i16;
                            }
                            if (i78 & 512 != 0) {
                                $dirty7 &= i7;
                            }
                            $dirty6 = shape;
                            obj16 = elevation;
                            obj9 = border;
                            i14 = interactionSource;
                            $dirty2 = $dirty7;
                            i3 = $dirty1;
                            colors2 = $dirty4;
                            enabled2 = z3;
                            obj13 = obj12;
                            $dirty16 = i13;
                            leadingIcon2 = obj6;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(313450168, $dirty2, $dirty16, "androidx.compose.material3.AssistChip (Chip.kt:132)");
                    }
                    i10 = enabled2;
                    obj14 = obj4;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i10, obj11, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i3), obj4.labelColor-vNxB06k$material3_release(enabled2), i13, obj13, colors2, $dirty6, obj14, obj16, obj9, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, i14, restartGroup, i40 | i60);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj7 = leadingIcon2;
                    z = i10;
                    obj = obj13;
                    obj8 = colors2;
                    shape3 = $dirty6;
                    $composer2 = obj14;
                    chipElevation = obj16;
                    borderStroke = obj9;
                    i11 = i14;
                    $dirty3 = $dirty2;
                } else {
                    restartGroup.skipToGroupEnd();
                    shape3 = shape;
                    borderStroke = border;
                    i11 = interactionSource;
                    $dirty16 = traceInProgress;
                    obj7 = obj6;
                    composer = restartGroup;
                    obj8 = $dirty4;
                    $composer2 = obj4;
                    z = z3;
                    obj = obj12;
                    chipElevation = elevation;
                    $dirty3 = obj45;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty13 = $dirty16;
            obj36 = $dirty3;
            $dirty16 = new ChipKt.AssistChip.1(onClick, label, obj7, z, obj, obj8, shape3, $composer2, chipElevation, borderStroke, i11, i77, $changed1, i78);
            endRestartGroup.updateScope((Function2)$dirty16);
        } else {
            $dirty13 = $dirty16;
            obj36 = $dirty3;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void AssistChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 leadingIcon, Function2 trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj6;
        Object obj15;
        Object obj2;
        int $dirty12;
        int skipping;
        int $dirty2;
        int defaultsInvalid;
        Object modifier2;
        int $dirty6;
        androidx.compose.material3.ChipBorder $dirty7;
        Object endRestartGroup;
        int i10;
        int assistChipElevation-aqJV_2Y;
        Object $dirty13;
        int interactionSource2;
        int $dirty14;
        int i19;
        int i9;
        Object obj8;
        int assistChipColors;
        boolean traceInProgress;
        int borderStroke$material3_release;
        int value;
        int i5;
        int shape2;
        Object $dirty;
        boolean z3;
        Object obj3;
        Object obj;
        Object obj10;
        Object obj17;
        Shape $composer2;
        Composer $composer3;
        int i8;
        Object obj11;
        int i11;
        boolean z;
        androidx.compose.material3.ChipElevation chipElevation;
        int i14;
        androidx.compose.material3.ChipBorder chipBorder;
        int i3;
        Object obj16;
        Object obj12;
        int i16;
        Object obj5;
        Object obj13;
        int $dirty5;
        Object leadingIcon2;
        int i17;
        Modifier i6;
        int i20;
        int i13;
        int changed4;
        Object i4;
        int changed;
        int changed2;
        int changed3;
        int $dirty15;
        TextStyle $dirty16;
        int i18;
        int labelColor-vNxB06k$material3_release;
        int i;
        int $dirty1;
        Object enabled2;
        boolean z2;
        Object colors2;
        Object obj4;
        Object $dirty4;
        int $dirty3;
        Object obj7;
        Object obj14;
        int i2;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        Object obj9;
        Composer composer2;
        Composer composer;
        int i7;
        int i12;
        Object obj36;
        final int i79 = $changed;
        final int i80 = i15;
        $composer3 = $composer.startRestartGroup(-1932300596);
        ComposerKt.sourceInformation($composer3, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)213@10395L5,214@10446L18,215@10517L21,216@10585L18,217@10655L39,224@10872L5,219@10704L571:Chip.kt#uh7d8r");
        $dirty6 = $changed;
        if (i80 & 1 != 0) {
            $dirty6 |= 6;
            obj16 = onClick;
        } else {
            if (i79 & 6 == 0) {
                i19 = $composer3.changedInstance(onClick) ? 4 : 2;
                $dirty6 |= i19;
            } else {
                obj16 = onClick;
            }
        }
        if (i80 & 2 != 0) {
            $dirty6 |= 48;
            obj5 = label;
        } else {
            if (i79 & 48 == 0) {
                i9 = $composer3.changedInstance(label) ? 32 : 16;
                $dirty6 |= i9;
            } else {
                obj5 = label;
            }
        }
        i5 = i80 & 4;
        if (i5 != 0) {
            $dirty6 |= 384;
            obj10 = modifier;
        } else {
            if (i79 & 384 == 0) {
                i8 = $composer3.changed(modifier) ? 256 : 128;
                $dirty6 |= i8;
            } else {
                obj10 = modifier;
            }
        }
        i11 = i80 & 8;
        if (i11 != 0) {
            $dirty6 |= 3072;
            z = enabled;
        } else {
            if (i79 & 3072 == 0) {
                i14 = $composer3.changed(enabled) ? 2048 : 1024;
                $dirty6 |= i14;
            } else {
                z = enabled;
            }
        }
        i3 = i80 & 16;
        if (i3 != 0) {
            $dirty6 |= 24576;
            obj13 = leadingIcon;
        } else {
            if (i79 & 24576 == 0) {
                i17 = $composer3.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty6 |= i17;
            } else {
                obj13 = leadingIcon;
            }
        }
        i6 = i80 & 32;
        i20 = 196608;
        if (i6 != 0) {
            $dirty6 |= i20;
            $dirty = trailingIcon;
        } else {
            if (i79 & i20 == 0) {
                i20 = $composer3.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty6 |= i20;
            } else {
                $dirty = trailingIcon;
            }
        }
        if (i79 & i82 == 0) {
            if (i80 & 64 == 0) {
                changed4 = $composer3.changed(shape) ? 1048576 : 524288;
            } else {
                obj6 = shape;
            }
            $dirty6 |= changed4;
        } else {
            obj6 = shape;
        }
        if (i79 & i83 == 0) {
            if (i80 & 128 == 0) {
                changed = $composer3.changed(colors) ? 8388608 : 4194304;
            } else {
                obj3 = colors;
            }
            $dirty6 |= changed;
        } else {
            obj3 = colors;
        }
        if (i79 & i85 == 0) {
            if (i80 & 256 == 0) {
                changed2 = $composer3.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj15 = elevation;
            }
            $dirty6 |= changed2;
        } else {
            obj15 = elevation;
        }
        if (i79 & i86 == 0) {
            if (i80 & 512 == 0) {
                changed3 = $composer3.changed(border) ? 536870912 : 268435456;
            } else {
                obj2 = border;
            }
            $dirty6 |= changed3;
        } else {
            obj2 = border;
        }
        $dirty15 = i28;
        $dirty13 = i80 & 1024;
        if ($dirty13 != 0) {
            $dirty15 |= 6;
            labelColor-vNxB06k$material3_release = $dirty13;
        } else {
            if ($changed1 & 6 == 0) {
                labelColor-vNxB06k$material3_release = $dirty13;
                i = $composer3.changed(interactionSource) ? 4 : 2;
                $dirty15 |= i;
            } else {
                labelColor-vNxB06k$material3_release = $dirty13;
                $dirty13 = interactionSource;
            }
        }
        interactionSource2 = $dirty15;
        final int obj45 = $dirty6;
        if ($dirty6 & $dirty16 == 306783378 && interactionSource2 & 3 == 2) {
            if (interactionSource2 & 3 == 2) {
                if (!$composer3.getSkipping()) {
                    $composer3.startDefaults();
                    int i84 = -234881025;
                    int i25 = -29360129;
                    i18 = -3670017;
                    i = interactionSource2;
                    $dirty14 = 6;
                    if (i79 & 1 != 0) {
                        if ($composer3.getDefaultsInvalid()) {
                            if (i5 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj10;
                            }
                            z2 = i11 != 0 ? i5 : z;
                            if (i3 != 0) {
                                obj13 = i5;
                            }
                            i6 = i6 != 0 ? i5 : $dirty;
                            if (i80 & 64 != 0) {
                                $dirty = obj45 & i18;
                                i18 = shape2;
                            } else {
                                i18 = shape;
                                $dirty = obj45;
                            }
                            if (i80 & 128 != 0) {
                                obj4 = assistChipColors;
                                $dirty3 = $dirty;
                            } else {
                                obj4 = obj3;
                                $dirty3 = $dirty;
                            }
                            if (i80 & 256 != 0) {
                                obj36 = modifier2;
                                i16 = i75;
                                $dirty12 = i;
                                $dirty3 &= i84;
                                i3 = assistChipElevation-aqJV_2Y;
                            } else {
                                obj36 = modifier2;
                                i16 = $dirty14;
                                composer = $composer3;
                                $dirty12 = i;
                                i3 = elevation;
                            }
                            if (i80 & 512 != 0) {
                                $dirty7 = AssistChipDefaults.INSTANCE.assistChipBorder-d_3_b6Q(0, assistChipColors, 0, obj3, 0, composer);
                                $dirty3 &= $dirty14;
                            } else {
                                $composer3 = composer;
                                $dirty7 = border;
                            }
                            if (labelColor-vNxB06k$material3_release != 0) {
                                ComposerKt.sourceInformationMarkerStart($composer3, 267303551, "CC(remember):Chip.kt#9igjgp");
                                int i30 = 0;
                                assistChipColors = $composer3;
                                $dirty = 0;
                                Object rememberedValue = assistChipColors.rememberedValue();
                                obj10 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i76 = 0;
                                    assistChipColors.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    i11 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                obj9 = invalid$iv;
                                obj14 = i3;
                                z = z2;
                                obj3 = obj4;
                                interactionSource2 = $dirty3;
                                enabled2 = obj13;
                                colors2 = i6;
                                $dirty4 = i18;
                                leadingIcon2 = obj36;
                            } else {
                                obj9 = interactionSource;
                                obj14 = i3;
                                z = z2;
                                obj3 = obj4;
                                interactionSource2 = $dirty3;
                                enabled2 = obj13;
                                colors2 = i6;
                                $dirty4 = i18;
                                leadingIcon2 = obj36;
                            }
                        } else {
                            $composer3.skipToGroupEnd();
                            $dirty2 = i80 & 64 != 0 ? obj45 & i18 : obj45;
                            if (i80 & 128 != 0) {
                                $dirty2 &= i25;
                            }
                            if (i80 & 256 != 0) {
                                $dirty2 &= i84;
                            }
                            if (i80 & 512 != 0) {
                                $dirty2 &= i10;
                            }
                            $dirty4 = shape;
                            obj14 = elevation;
                            $dirty7 = border;
                            obj9 = interactionSource;
                            i16 = $dirty14;
                            colors2 = $dirty;
                            enabled2 = obj13;
                            interactionSource2 = $dirty2;
                            leadingIcon2 = obj10;
                            $dirty12 = i;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1932300596, interactionSource2, $dirty12, "androidx.compose.material3.AssistChip (Chip.kt:219)");
                    }
                    $composer3.startReplaceGroup(267317901);
                    ComposerKt.sourceInformation($composer3, "231@11104L21");
                    if ($dirty7 == null) {
                        borderStroke$material3_release = 0;
                    } else {
                        borderStroke$material3_release = $dirty7.borderStroke$material3_release(z, $composer3, i45 |= $dirty);
                    }
                    $composer3.endReplaceGroup();
                    if (borderStroke$material3_release != 0) {
                        value = borderStroke$material3_release.getValue();
                    } else {
                        value = 0;
                    }
                    obj7 = obj3;
                    i13 = z;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i13, obj5, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), $composer3, i16), obj3.labelColor-vNxB06k$material3_release(z), i, enabled2, colors2, $dirty4, obj7, obj14, value, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, obj9, $composer3, i40 | i61);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipBorder = $dirty7;
                    obj8 = leadingIcon2;
                    z3 = i13;
                    obj = enabled2;
                    obj17 = colors2;
                    $composer2 = $dirty4;
                    obj11 = obj7;
                    chipElevation = obj14;
                    obj12 = obj9;
                    $dirty5 = interactionSource2;
                } else {
                    $composer3.skipToGroupEnd();
                    chipBorder = border;
                    obj12 = interactionSource;
                    $dirty12 = interactionSource2;
                    obj11 = obj3;
                    obj8 = obj10;
                    composer2 = $composer3;
                    obj = obj13;
                    $composer2 = shape;
                    $dirty5 = obj45;
                    obj17 = $dirty;
                    z3 = z;
                    chipElevation = elevation;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty1 = $dirty12;
            obj36 = $dirty5;
            $dirty12 = new ChipKt.AssistChip.3(onClick, label, obj8, z3, obj, obj17, $composer2, obj11, chipElevation, chipBorder, obj12, i79, $changed1, i80);
            endRestartGroup.updateScope((Function2)$dirty12);
        } else {
            $dirty1 = $dirty12;
            obj36 = $dirty5;
        }
    }

    private static final void Chip-nkUnTEs(Modifier modifier, Function0<Unit> onClick, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, long labelColor, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        int $dirty3;
        Object traceInProgress;
        ScopeUpdateScope endRestartGroup;
        Object obj10;
        Object obj7;
        float f;
        Object obj3;
        int changed2;
        int rememberedValue;
        Object str;
        int unbox-impl;
        boolean z;
        Object restartGroup;
        int $dirty4;
        Object $dirty2;
        int i13;
        int $dirty12;
        boolean skipping;
        boolean traceInProgress2;
        int str2;
        int i12;
        Object obj11;
        int i4;
        State shadowElevation$material3_release;
        int i18;
        Object obj8;
        Object obj2;
        Object obj9;
        long l;
        Object obj4;
        Object obj5;
        Object obj;
        Object obj6;
        int i;
        int i2;
        int interactionSource2;
        int i3;
        int $dirty1;
        int i5;
        Composer composer;
        Composer.Companion companion;
        int i6;
        int changed;
        int $dirty;
        int i7;
        int i8;
        int i9;
        int i16;
        int i10;
        int i15;
        int i11;
        int i17;
        int i14;
        int changed3;
        ScopeUpdateScope scopeUpdateScope;
        int obj43;
        traceInProgress = modifier;
        z = enabled;
        obj2 = elevation;
        Object obj12 = border;
        obj5 = $composer;
        int i50 = $changed1;
        i = obj45;
        restartGroup = $changed.startRestartGroup(1400504719);
        ComposerKt.sourceInformation(restartGroup, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1975@97230L477,1966@96860L847:Chip.kt#uh7d8r");
        if (i50 & 6 == 0) {
            i12 = restartGroup.changed(traceInProgress) ? 4 : 2;
            $dirty4 |= i12;
        }
        if (i50 & 48 == 0) {
            i2 = restartGroup.changedInstance(onClick) ? 32 : 16;
            $dirty4 |= i2;
        } else {
            obj11 = onClick;
        }
        i3 = 128;
        if (i50 & 384 == 0) {
            i18 = restartGroup.changed(z) ? interactionSource2 : i3;
            $dirty4 |= i18;
        }
        companion = 1024;
        if (i50 & 3072 == 0) {
            i6 = restartGroup.changedInstance(label) ? i5 : companion;
            $dirty4 |= i6;
        } else {
            obj8 = label;
        }
        int i51 = 8192;
        if (i50 & 24576 == 0) {
            i9 = restartGroup.changed(labelTextStyle) ? i7 : i51;
            $dirty4 |= i9;
        } else {
            obj9 = labelTextStyle;
        }
        if (i50 & i52 == 0) {
            i10 = restartGroup.changed(labelColor) ? 131072 : 65536;
            $dirty4 |= i10;
        } else {
            l = labelColor;
        }
        if (i50 & i53 == 0) {
            i15 = restartGroup.changedInstance(trailingIcon) ? 1048576 : 524288;
            $dirty4 |= i15;
        } else {
            obj10 = trailingIcon;
        }
        if (i50 & i55 == 0) {
            i11 = restartGroup.changedInstance(shape) ? 8388608 : 4194304;
            $dirty4 |= i11;
        } else {
            obj7 = shape;
        }
        if (i50 & i56 == 0) {
            i17 = restartGroup.changed(colors) ? 67108864 : 33554432;
            $dirty4 |= i17;
        } else {
            obj = colors;
        }
        if ($changed1 & i57 == 0) {
            i14 = restartGroup.changed(obj2) ? 536870912 : 268435456;
            $dirty4 |= i14;
        }
        if (i & 6 == 0) {
            i6 = restartGroup.changed(obj12) ? 4 : 2;
            $dirty12 |= i6;
        }
        if (i & 48 == 0) {
            i16 = restartGroup.changed(minHeight) ? 32 : 16;
            $dirty12 |= i16;
        } else {
            obj6 = minHeight;
        }
        if (i & 384 == 0) {
            if (restartGroup.changed(paddingValues)) {
            } else {
                interactionSource2 = i3;
            }
            $dirty12 |= interactionSource2;
        } else {
            f = paddingValues;
        }
        if (i & 3072 == 0) {
            if (restartGroup.changed(interactionSource)) {
            } else {
                i5 = companion;
            }
            $dirty12 |= i5;
        } else {
            obj3 = interactionSource;
        }
        if (i & 24576 == 0) {
            if (restartGroup.changed(obj5)) {
            } else {
                i7 = i51;
            }
            $dirty12 |= i7;
        }
        rememberedValue = $dirty12;
        if ($dirty13 &= $dirty4 == 306783378 && rememberedValue & 9363 == 9362) {
            if (rememberedValue & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1400504719, $dirty4, rememberedValue, "androidx.compose.material3.Chip (Chip.kt:1963)");
                    }
                    restartGroup.startReplaceGroup(1985614987);
                    ComposerKt.sourceInformation(restartGroup, "1965@96816L39");
                    if (obj5 == null) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1985615638, "CC(remember):Chip.kt#9igjgp");
                        str2 = 0;
                        i4 = restartGroup;
                        interactionSource2 = 0;
                        $dirty1 = rememberedValue;
                        rememberedValue = i4.rememberedValue();
                        i5 = 0;
                        obj43 = $dirty4;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i39 = 0;
                            i4.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $dirty2 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        $dirty1 = rememberedValue;
                        obj43 = $dirty4;
                        $dirty2 = obj5;
                    }
                    restartGroup.endReplaceGroup();
                    MutableInteractionSource mutableInteractionSource = $dirty2;
                    int i44 = 1;
                    restartGroup.startReplaceGroup(1985624506);
                    ComposerKt.sourceInformation(restartGroup, "1972@97093L43");
                    if (obj12 == null) {
                    } else {
                        shadowElevation$material3_release = obj12.shadowElevation$material3_release(z, (InteractionSource)mutableInteractionSource, restartGroup, i41 |= i47);
                    }
                    restartGroup.endReplaceGroup();
                    if (shadowElevation$material3_release != null) {
                        i7 = unbox-impl;
                    } else {
                        i13 = 0;
                        i7 = shadowElevation$material3_release;
                    }
                    i4 = trailingIcon;
                    $dirty3 = obj43;
                    i = restartGroup;
                    ChipKt.Chip.2 anon = new ChipKt.Chip.2(obj8, obj9, l, i44, i4, shape, obj2, z, paddingValues, interactionSource);
                    SurfaceKt.Surface-o_FOJdg(onClick, SemanticsModifierKt.semantics$default(traceInProgress, false, (Function1)ChipKt.Chip.1.INSTANCE, i44, 0), enabled, colors, obj2.containerColor-vNxB06k$material3_release(z), i4, 0, obj2, 0, i7, obj6, mutableInteractionSource, (Function2)ComposableLambdaKt.rememberComposableLambda(-1985962652, i44, anon, i, 54), i, i27 |= i34);
                    composer = i;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    i8 = rememberedValue;
                    composer = restartGroup;
                    $dirty3 = $dirty4;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = i38;
            $dirty3 = new ChipKt.Chip.3(modifier, onClick, enabled, label, labelTextStyle, labelColor, i4, trailingIcon, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, $composer, $changed1, obj45);
            endRestartGroup.updateScope((Function2)$dirty3);
        } else {
            $dirty = $dirty3;
        }
    }

    private static final void ChipContent-fe0OD_I(Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, long labelColor, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, long leadingIconColor, long trailingIconColor, float minHeight, PaddingValues paddingValues, Composer $composer, int $changed) {
        Object obj4;
        boolean traceInProgress;
        Object endRestartGroup;
        boolean traceInProgress2;
        int $dirty2;
        Object obj5;
        int rememberComposableLambda;
        float f;
        int i;
        int i8;
        long l;
        long function2;
        int i11;
        Object obj9;
        int i3;
        Object obj3;
        int i5;
        Object obj;
        int i4;
        long l5;
        int i10;
        long l6;
        Object obj6;
        Object $composer2;
        int i9;
        int i6;
        int anon;
        int $dirty;
        int i7;
        int i2;
        PaddingValues paddingValues2;
        Object obj7;
        Object obj8;
        Object obj2;
        long l2;
        long l4;
        long l3;
        Composer obj40;
        final Object obj11 = labelTextStyle;
        final int i26 = obj41;
        $composer2 = obj40.startRestartGroup(-782878228);
        ComposerKt.sourceInformation($composer2, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)2055@99907L3519,2052@99781L3645:Chip.kt#uh7d8r");
        if (i26 & 6 == 0) {
            i = $composer2.changedInstance(label) ? 4 : 2;
            $dirty2 |= i;
        } else {
            obj5 = label;
        }
        if (i26 & 48 == 0) {
            i8 = $composer2.changed(obj11) ? 32 : 16;
            $dirty2 |= i8;
        }
        if (i26 & 384 == 0) {
            i11 = $composer2.changed(labelColor) ? 256 : 128;
            $dirty2 |= i11;
        } else {
            l = labelColor;
        }
        if (i26 & 3072 == 0) {
            i3 = $composer2.changedInstance(avatar) ? 2048 : 1024;
            $dirty2 |= i3;
        } else {
            obj9 = avatar;
        }
        if (i26 & 24576 == 0) {
            i5 = $composer2.changedInstance(trailingIcon) ? 16384 : 8192;
            $dirty2 |= i5;
        } else {
            obj3 = trailingIcon;
        }
        if (i20 &= i26 == 0) {
            i4 = $composer2.changedInstance(leadingIconColor) ? 131072 : 65536;
            $dirty2 |= i4;
        } else {
            obj = leadingIconColor;
        }
        if (i22 &= i26 == 0) {
            i10 = $composer2.changed(trailingIconColor) ? 1048576 : 524288;
            $dirty2 |= i10;
        } else {
            l5 = trailingIconColor;
        }
        if (i24 &= i26 == 0) {
            i9 = $composer2.changed(paddingValues) ? 8388608 : 4194304;
            $dirty2 |= i9;
        } else {
            l6 = paddingValues;
        }
        if (i26 & i27 == 0) {
            i6 = $composer2.changed($changed) ? 67108864 : 33554432;
            $dirty2 |= i6;
        } else {
            f = $changed;
        }
        if (i26 & i28 == 0) {
            i7 = $composer2.changed(obj39) ? 536870912 : 268435456;
            $dirty2 |= i7;
        } else {
            obj4 = obj39;
        }
        if ($dirty2 & i2 == 306783378) {
            if (!$composer2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-782878228, $dirty2, -1, "androidx.compose.material3.ChipContent (Chip.kt:2051)");
                }
                ProvidedValue[] arr = new ProvidedValue[2];
                int i16 = 1;
                arr[i16] = TextKt.getLocalTextStyle().provides(obj11);
                anon = new ChipKt.ChipContent.1($changed, obj39, obj3, obj9, obj, l5, obj23, label, l6, obj26);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(1748799148, i16, anon, $composer2, 54), $composer2, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            obj40 = $composer2;
            endRestartGroup = new ChipKt.ChipContent.2(label, obj11, l, f, avatar, trailingIcon, leadingIconColor, trailingIconColor, obj, paddingValues, obj11, $changed, obj39, i26);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty = $dirty2;
            obj40 = $composer2;
        }
    }

    public static final void ElevatedAssistChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj3;
        Object obj2;
        int $dirty12;
        int skipping;
        int $dirty;
        int defaultsInvalid;
        Object modifier2;
        int $dirty2;
        int $dirty5;
        Object endRestartGroup;
        Object elevatedAssistChipElevation-aqJV_2Y;
        Object obj5;
        Object i8;
        boolean traceInProgress;
        int $dirty1;
        boolean traceInProgress2;
        int i5;
        int i;
        Object obj9;
        int elevatedAssistChipColors;
        int i19;
        int shape3;
        Object $dirty3;
        boolean z3;
        Object obj8;
        Object obj12;
        Object obj7;
        Object obj;
        int i16;
        Shape shape2;
        int i21;
        Object $composer2;
        boolean z;
        androidx.compose.material3.ChipElevation chipElevation;
        int i6;
        int i12;
        int i23;
        Object obj10;
        int i13;
        int i10;
        Object obj6;
        Object obj13;
        int $dirty6;
        Object leadingIcon2;
        int i17;
        Modifier i20;
        int i3;
        int i2;
        int changed2;
        Object i9;
        int changed3;
        int changed;
        int $dirty14;
        TextStyle $dirty13;
        int i22;
        int labelColor-vNxB06k$material3_release;
        int i14;
        int i18;
        int $dirty15;
        int $dirty16;
        Object enabled2;
        boolean z2;
        Object colors2;
        Object obj4;
        Object $dirty4;
        Object obj11;
        int i7;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        int i24;
        Composer composer;
        int i11;
        int i4;
        Object obj36;
        final int i75 = $changed;
        final int i76 = i15;
        Composer restartGroup = $composer.startRestartGroup(1594789934);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)289@14186L5,290@14237L26,291@14316L29,300@14613L5,295@14445L541:Chip.kt#uh7d8r");
        $dirty2 = $changed;
        if (i76 & 1 != 0) {
            $dirty2 |= 6;
            obj10 = onClick;
        } else {
            if (i75 & 6 == 0) {
                i5 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                obj10 = onClick;
            }
        }
        if (i76 & 2 != 0) {
            $dirty2 |= 48;
            obj6 = label;
        } else {
            if (i75 & 48 == 0) {
                i = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj6 = label;
            }
        }
        i19 = i76 & 4;
        if (i19 != 0) {
            $dirty2 |= 384;
            obj7 = modifier;
        } else {
            if (i75 & 384 == 0) {
                i16 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i16;
            } else {
                obj7 = modifier;
            }
        }
        i21 = i76 & 8;
        if (i21 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else {
            if (i75 & 3072 == 0) {
                i6 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                z = enabled;
            }
        }
        i23 = i76 & 16;
        if (i23 != 0) {
            $dirty2 |= 24576;
            obj13 = leadingIcon;
        } else {
            if (i75 & 24576 == 0) {
                i17 = restartGroup.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty2 |= i17;
            } else {
                obj13 = leadingIcon;
            }
        }
        i20 = i76 & 32;
        i3 = 196608;
        if (i20 != 0) {
            $dirty2 |= i3;
            $dirty3 = trailingIcon;
        } else {
            if (i75 & i3 == 0) {
                i3 = restartGroup.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                $dirty3 = trailingIcon;
            }
        }
        if (i75 & i78 == 0) {
            if (i76 & 64 == 0) {
                changed2 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj3 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj3 = shape;
        }
        if (i75 & i79 == 0) {
            if (i76 & 128 == 0) {
                changed3 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj8 = colors;
            }
            $dirty2 |= changed3;
        } else {
            obj8 = colors;
        }
        if (i75 & i81 == 0) {
            if (i76 & 256 == 0) {
                changed = restartGroup.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj2 = elevation;
            }
            $dirty2 |= changed;
        } else {
            obj2 = elevation;
        }
        $dirty14 = i31;
        int $dirty17 = i76 & 512;
        int i82 = 805306368;
        if ($dirty17 != 0) {
            $dirty2 |= i82;
            labelColor-vNxB06k$material3_release = $dirty17;
            obj5 = border;
        } else {
            if (i75 & i82 == 0) {
                labelColor-vNxB06k$material3_release = $dirty17;
                i14 = restartGroup.changed(border) ? 536870912 : 268435456;
                $dirty2 |= i14;
            } else {
                labelColor-vNxB06k$material3_release = $dirty17;
                obj5 = border;
            }
        }
        i8 = i76 & 1024;
        if (i8 != 0) {
            $dirty14 |= 6;
            i18 = i8;
        } else {
            if ($changed1 & 6 == 0) {
                i18 = i8;
                $dirty15 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty14 |= $dirty15;
            } else {
                i18 = i8;
                i8 = interactionSource;
            }
        }
        traceInProgress = $dirty14;
        final int obj45 = $dirty2;
        if ($dirty2 & $dirty13 == 306783378 && traceInProgress & 3 == 2) {
            if (traceInProgress & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i80 = -234881025;
                    int i28 = -29360129;
                    i22 = -3670017;
                    int i85 = traceInProgress;
                    $dirty1 = 6;
                    if (i75 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i19 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj7;
                            }
                            z2 = i21 != 0 ? i19 : z;
                            if (i23 != 0) {
                                obj13 = i19;
                            }
                            i20 = i20 != 0 ? i19 : $dirty3;
                            if (i76 & 64 != 0) {
                                $dirty3 = obj45 & i22;
                                i22 = shape3;
                            } else {
                                i22 = shape;
                                $dirty3 = obj45;
                            }
                            if (i76 & 128 != 0) {
                                obj4 = elevatedAssistChipColors;
                                $dirty4 = $dirty3;
                            } else {
                                obj4 = obj8;
                                $dirty4 = $dirty3;
                            }
                            if (i76 & 256 != 0) {
                                obj36 = modifier2;
                                $dirty12 = i85;
                                i10 = obj11;
                                elevatedAssistChipElevation-aqJV_2Y = AssistChipDefaults.INSTANCE.elevatedAssistChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty4 &= i80;
                            } else {
                                obj36 = modifier2;
                                i10 = $dirty1;
                                $dirty12 = i85;
                                elevatedAssistChipElevation-aqJV_2Y = elevation;
                            }
                            $dirty1 = labelColor-vNxB06k$material3_release != 0 ? 0 : border;
                            if (i18 != 0) {
                                obj11 = elevatedAssistChipElevation-aqJV_2Y;
                                i7 = $dirty1;
                                i24 = elevatedAssistChipColors;
                                $dirty15 = obj13;
                                z = z2;
                                obj8 = obj4;
                                $dirty5 = $dirty4;
                                leadingIcon2 = obj36;
                                enabled2 = i20;
                                colors2 = i22;
                            } else {
                                i24 = interactionSource;
                                obj11 = elevatedAssistChipElevation-aqJV_2Y;
                                i7 = $dirty1;
                                $dirty15 = obj13;
                                z = z2;
                                obj8 = obj4;
                                $dirty5 = $dirty4;
                                leadingIcon2 = obj36;
                                enabled2 = i20;
                                colors2 = i22;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty = i76 & 64 != 0 ? obj45 & i22 : obj45;
                            if (i76 & 128 != 0) {
                                $dirty &= i28;
                            }
                            if (i76 & 256 != 0) {
                                $dirty &= i80;
                            }
                            colors2 = shape;
                            obj11 = elevation;
                            i7 = border;
                            i24 = interactionSource;
                            $dirty5 = $dirty;
                            i10 = $dirty1;
                            enabled2 = $dirty3;
                            $dirty12 = i85;
                            $dirty15 = obj13;
                            leadingIcon2 = obj7;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1594789934, $dirty5, $dirty12, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:295)");
                    }
                    $dirty4 = obj8;
                    i2 = z;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i2, obj6, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i10), obj8.labelColor-vNxB06k$material3_release(z), i18, $dirty15, enabled2, colors2, $dirty4, obj11, i7, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, i24, restartGroup, i39 | i57);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj9 = leadingIcon2;
                    z3 = i2;
                    obj12 = $dirty15;
                    obj = enabled2;
                    shape2 = colors2;
                    $composer2 = $dirty4;
                    chipElevation = obj11;
                    i12 = i7;
                    i13 = i24;
                    $dirty6 = $dirty5;
                } else {
                    restartGroup.skipToGroupEnd();
                    shape2 = shape;
                    i12 = border;
                    i13 = interactionSource;
                    $dirty12 = traceInProgress;
                    obj9 = obj7;
                    composer = restartGroup;
                    obj = $dirty3;
                    $composer2 = obj8;
                    z3 = z;
                    obj12 = obj13;
                    chipElevation = elevation;
                    $dirty6 = obj45;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty16 = $dirty12;
            obj36 = $dirty6;
            $dirty12 = new ChipKt.ElevatedAssistChip.1(onClick, label, obj9, z3, obj12, obj, shape2, $composer2, chipElevation, i12, i13, i75, $changed1, i76);
            endRestartGroup.updateScope((Function2)$dirty12);
        } else {
            $dirty16 = $dirty12;
            obj36 = $dirty6;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void ElevatedAssistChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 leadingIcon, Function2 trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj10;
        Object obj7;
        int $dirty1;
        int skipping;
        int $dirty5;
        int defaultsInvalid;
        Object modifier2;
        int $dirty4;
        int $dirty3;
        Object endRestartGroup;
        Object elevatedAssistChipElevation-aqJV_2Y;
        Object obj8;
        Object i18;
        int border2;
        int $dirty14;
        int i12;
        int i14;
        Object obj9;
        int invalid$iv;
        boolean traceInProgress;
        State borderStroke$material3_release;
        int value;
        int i16;
        int shape3;
        Object $dirty2;
        boolean z;
        Object obj5;
        Object obj3;
        Object rememberedValue;
        Object obj4;
        int i19;
        Shape shape2;
        int i11;
        Object $composer2;
        boolean z2;
        androidx.compose.material3.ChipElevation chipElevation;
        Object obj13;
        int i2;
        int i7;
        int i9;
        Object obj15;
        Object obj6;
        int i20;
        Object obj11;
        Object obj12;
        int $dirty6;
        Object leadingIcon2;
        int i21;
        Modifier i5;
        int i17;
        int i;
        int changed3;
        Object i3;
        int changed;
        int changed2;
        int $dirty15;
        TextStyle $dirty12;
        int i8;
        int labelColor-vNxB06k$material3_release;
        int i10;
        int i6;
        int $dirty13;
        int $dirty16;
        Object enabled2;
        boolean z3;
        Object colors2;
        Object obj14;
        Object $dirty;
        Object obj;
        int i13;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        Object obj2;
        Composer composer;
        int i22;
        int i4;
        Object obj36;
        final int i79 = $changed;
        final int i80 = i15;
        Composer restartGroup = $composer.startRestartGroup(1295844802);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)375@18287L5,376@18338L26,377@18417L29,379@18530L39,386@18746L5,381@18578L571:Chip.kt#uh7d8r");
        $dirty4 = $changed;
        if (i80 & 1 != 0) {
            $dirty4 |= 6;
            obj15 = onClick;
        } else {
            if (i79 & 6 == 0) {
                i12 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty4 |= i12;
            } else {
                obj15 = onClick;
            }
        }
        if (i80 & 2 != 0) {
            $dirty4 |= 48;
            obj11 = label;
        } else {
            if (i79 & 48 == 0) {
                i14 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty4 |= i14;
            } else {
                obj11 = label;
            }
        }
        i16 = i80 & 4;
        if (i16 != 0) {
            $dirty4 |= 384;
            rememberedValue = modifier;
        } else {
            if (i79 & 384 == 0) {
                i19 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty4 |= i19;
            } else {
                rememberedValue = modifier;
            }
        }
        i11 = i80 & 8;
        if (i11 != 0) {
            $dirty4 |= 3072;
            z2 = enabled;
        } else {
            if (i79 & 3072 == 0) {
                i2 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty4 |= i2;
            } else {
                z2 = enabled;
            }
        }
        i9 = i80 & 16;
        if (i9 != 0) {
            $dirty4 |= 24576;
            obj12 = leadingIcon;
        } else {
            if (i79 & 24576 == 0) {
                i21 = restartGroup.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty4 |= i21;
            } else {
                obj12 = leadingIcon;
            }
        }
        i5 = i80 & 32;
        i17 = 196608;
        if (i5 != 0) {
            $dirty4 |= i17;
            $dirty2 = trailingIcon;
        } else {
            if (i79 & i17 == 0) {
                i17 = restartGroup.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty4 |= i17;
            } else {
                $dirty2 = trailingIcon;
            }
        }
        if (i79 & i82 == 0) {
            if (i80 & 64 == 0) {
                changed3 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj10 = shape;
            }
            $dirty4 |= changed3;
        } else {
            obj10 = shape;
        }
        if (i79 & i83 == 0) {
            if (i80 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj5 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj5 = colors;
        }
        if (i79 & i85 == 0) {
            if (i80 & 256 == 0) {
                changed2 = restartGroup.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj7 = elevation;
            }
            $dirty4 |= changed2;
        } else {
            obj7 = elevation;
        }
        $dirty15 = i29;
        int $dirty17 = i80 & 512;
        int i86 = 805306368;
        if ($dirty17 != 0) {
            $dirty4 |= i86;
            labelColor-vNxB06k$material3_release = $dirty17;
            obj8 = border;
        } else {
            if (i79 & i86 == 0) {
                labelColor-vNxB06k$material3_release = $dirty17;
                i10 = restartGroup.changed(border) ? 536870912 : 268435456;
                $dirty4 |= i10;
            } else {
                labelColor-vNxB06k$material3_release = $dirty17;
                obj8 = border;
            }
        }
        i18 = i80 & 1024;
        if (i18 != 0) {
            $dirty15 |= 6;
            i6 = i18;
        } else {
            if ($changed1 & 6 == 0) {
                i6 = i18;
                $dirty13 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty15 |= $dirty13;
            } else {
                i6 = i18;
                i18 = interactionSource;
            }
        }
        border2 = $dirty15;
        final int obj45 = $dirty4;
        if ($dirty4 & $dirty12 == 306783378 && border2 & 3 == 2) {
            if (border2 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i84 = -234881025;
                    int i26 = -29360129;
                    i8 = -3670017;
                    int i89 = border2;
                    $dirty14 = 6;
                    if (i79 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = rememberedValue;
                            }
                            z3 = i11 != 0 ? i16 : z2;
                            if (i9 != 0) {
                                obj12 = i16;
                            }
                            i5 = i5 != 0 ? i16 : $dirty2;
                            if (i80 & 64 != 0) {
                                $dirty2 = obj45 & i8;
                                i8 = shape3;
                            } else {
                                i8 = shape;
                                $dirty2 = obj45;
                            }
                            if (i80 & 128 != 0) {
                                obj14 = invalid$iv;
                                $dirty = $dirty2;
                            } else {
                                obj14 = obj5;
                                $dirty = $dirty2;
                            }
                            if (i80 & 256 != 0) {
                                obj36 = modifier2;
                                $dirty1 = i89;
                                i20 = obj;
                                elevatedAssistChipElevation-aqJV_2Y = AssistChipDefaults.INSTANCE.elevatedAssistChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty &= i84;
                            } else {
                                obj36 = modifier2;
                                i20 = $dirty14;
                                $dirty1 = i89;
                                elevatedAssistChipElevation-aqJV_2Y = elevation;
                            }
                            border2 = labelColor-vNxB06k$material3_release != 0 ? 0 : border;
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 1551989929, "CC(remember):Chip.kt#9igjgp");
                                int i46 = 0;
                                $dirty2 = restartGroup;
                                int i67 = 0;
                                rememberedValue = $dirty2.rememberedValue();
                                i11 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i77 = 0;
                                    $dirty2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    obj13 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj = elevatedAssistChipElevation-aqJV_2Y;
                                obj2 = invalid$iv;
                                $dirty13 = obj12;
                                z2 = z3;
                                obj5 = obj14;
                                $dirty3 = $dirty;
                                leadingIcon2 = obj36;
                                enabled2 = i5;
                                colors2 = i8;
                            } else {
                                obj2 = interactionSource;
                                obj = elevatedAssistChipElevation-aqJV_2Y;
                                $dirty13 = obj12;
                                z2 = z3;
                                obj5 = obj14;
                                $dirty3 = $dirty;
                                leadingIcon2 = obj36;
                                enabled2 = i5;
                                colors2 = i8;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty5 = i80 & 64 != 0 ? obj45 & i8 : obj45;
                            if (i80 & 128 != 0) {
                                $dirty5 &= i26;
                            }
                            if (i80 & 256 != 0) {
                                $dirty5 &= i84;
                            }
                            colors2 = shape;
                            obj = elevation;
                            obj2 = interactionSource;
                            $dirty3 = $dirty5;
                            i20 = $dirty14;
                            enabled2 = $dirty2;
                            $dirty1 = i89;
                            border2 = border;
                            $dirty13 = obj12;
                            leadingIcon2 = rememberedValue;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1295844802, $dirty3, $dirty1, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:381)");
                    }
                    restartGroup.startReplaceGroup(1552007127);
                    ComposerKt.sourceInformation(restartGroup, "395@19068L21");
                    if (border2 == 0) {
                        borderStroke$material3_release = 0;
                    } else {
                        borderStroke$material3_release = border2.borderStroke$material3_release(z2, restartGroup, i43 |= $dirty2);
                    }
                    restartGroup.endReplaceGroup();
                    if (borderStroke$material3_release != null) {
                        value = borderStroke$material3_release.getValue();
                    } else {
                        value = 0;
                    }
                    $dirty = obj5;
                    i = z2;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i, obj11, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i20), obj5.labelColor-vNxB06k$material3_release(z2), i6, $dirty13, enabled2, colors2, $dirty, obj, value, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, obj2, restartGroup, i38 | i61);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i7 = border2;
                    obj9 = leadingIcon2;
                    z = i;
                    obj3 = $dirty13;
                    obj4 = enabled2;
                    shape2 = colors2;
                    $composer2 = $dirty;
                    chipElevation = obj;
                    obj6 = obj2;
                    $dirty6 = $dirty3;
                } else {
                    restartGroup.skipToGroupEnd();
                    shape2 = shape;
                    i7 = border;
                    obj6 = interactionSource;
                    $dirty1 = border2;
                    obj9 = rememberedValue;
                    composer = restartGroup;
                    obj4 = $dirty2;
                    $composer2 = obj5;
                    z = z2;
                    obj3 = obj12;
                    chipElevation = elevation;
                    $dirty6 = obj45;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty16 = $dirty1;
            obj36 = $dirty6;
            $dirty1 = new ChipKt.ElevatedAssistChip.3(onClick, label, obj9, z, obj3, obj4, shape2, $composer2, chipElevation, i7, obj6, i79, $changed1, i80);
            endRestartGroup.updateScope((Function2)$dirty1);
        } else {
            $dirty16 = $dirty1;
            obj36 = $dirty6;
        }
    }

    public static final void ElevatedFilterChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i16) {
        Object obj18;
        Object obj14;
        int $dirty13;
        int skipping;
        int defaultsInvalid;
        Object modifier2;
        int $dirty4;
        int $dirty2;
        int $dirty3;
        ScopeUpdateScope endRestartGroup;
        Object elevatedFilterChipElevation-aqJV_2Y;
        int i10;
        Object obj8;
        Object i;
        int traceInProgress2;
        int $dirty16;
        int border3;
        int border2;
        int i26;
        int i20;
        int i22;
        int i2;
        int shape2;
        int elevatedFilterChipColors;
        boolean traceInProgress;
        boolean $dirty5;
        Object obj7;
        Object obj3;
        boolean z;
        Object obj15;
        Object obj5;
        Object obj;
        Object obj2;
        Object $composer2;
        Object obj4;
        Object obj13;
        int i21;
        Object obj6;
        int i9;
        boolean z2;
        int obj11;
        int i11;
        Object obj9;
        int obj16;
        Object obj12;
        int i12;
        int i13;
        Object i14;
        int i8;
        int i25;
        int $dirty12;
        int $dirty1;
        Object obj17;
        int i5;
        int i6;
        int $dirty15;
        int $dirty14;
        int i3;
        int i15;
        int value;
        int changed3;
        int i23;
        int changed2;
        int changed;
        int i18;
        int i24;
        boolean colors2;
        Object obj10;
        androidx.compose.material3.SelectableChipColors $dirty6;
        int $dirty;
        androidx.compose.material3.SelectableChipElevation selectableChipElevation;
        int i17;
        float height-D9Ej5fM;
        PaddingValues filterChipPadding;
        int i4;
        Composer composer;
        int i19;
        int i7;
        ScopeUpdateScope scopeUpdateScope;
        Object obj39;
        final int i80 = $changed;
        final int i81 = i16;
        Composer restartGroup = $composer.startRestartGroup(-106647389);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)546@26622L5,547@26683L26,548@26772L29,558@27108L5,552@26901L554:Chip.kt#uh7d8r");
        $dirty2 = $changed;
        if (i81 & 1 != 0) {
            $dirty2 |= 6;
            z2 = selected;
        } else {
            if (i80 & 6 == 0) {
                i26 = restartGroup.changed(selected) ? 4 : 2;
                $dirty2 |= i26;
            } else {
                z2 = selected;
            }
        }
        if (i81 & 2 != 0) {
            $dirty2 |= 48;
            obj9 = onClick;
        } else {
            if (i80 & 48 == 0) {
                i20 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i20;
            } else {
                obj9 = onClick;
            }
        }
        if (i81 & 4 != 0) {
            $dirty2 |= 384;
            obj12 = label;
        } else {
            if (i80 & 384 == 0) {
                i22 = restartGroup.changedInstance(label) ? 256 : 128;
                $dirty2 |= i22;
            } else {
                obj12 = label;
            }
        }
        i2 = i81 & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            obj4 = modifier;
        } else {
            if (i80 & 3072 == 0) {
                i21 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i21;
            } else {
                obj4 = modifier;
            }
        }
        i9 = i81 & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            $dirty5 = enabled;
        } else {
            if (i80 & 24576 == 0) {
                i12 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty2 |= i12;
            } else {
                $dirty5 = enabled;
            }
        }
        i14 = i81 & 32;
        i8 = 196608;
        if (i14 != 0) {
            $dirty2 |= i8;
            obj3 = leadingIcon;
        } else {
            if (i80 & i8 == 0) {
                i5 = restartGroup.changedInstance(leadingIcon) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                obj3 = leadingIcon;
            }
        }
        i6 = i81 & 64;
        $dirty15 = 1572864;
        if (i6 != 0) {
            $dirty2 |= $dirty15;
            obj15 = trailingIcon;
        } else {
            if (i80 & $dirty15 == 0) {
                i3 = restartGroup.changedInstance(trailingIcon) ? 1048576 : 524288;
                $dirty2 |= i3;
            } else {
                obj15 = trailingIcon;
            }
        }
        i15 = 12582912;
        if (i80 & i15 == 0) {
            if (i81 & 128 == 0) {
                changed3 = restartGroup.changed(shape) ? 8388608 : 4194304;
            } else {
                obj = shape;
            }
            $dirty2 |= changed3;
        } else {
            obj = shape;
        }
        if (i80 & i84 == 0) {
            if (i81 & 256 == 0) {
                changed2 = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj18 = colors;
            }
            $dirty2 |= changed2;
        } else {
            obj18 = colors;
        }
        if (i80 & i85 == 0) {
            if (i81 & 512 == 0) {
                changed = restartGroup.changed(elevation) ? 536870912 : 268435456;
            } else {
                obj14 = elevation;
            }
            $dirty2 |= changed;
        } else {
            obj14 = elevation;
        }
        int i86 = i33;
        int $dirty17 = i81 & 1024;
        if ($dirty17 != 0) {
            $dirty12 = i86 | 6;
            i24 = $dirty17;
            obj8 = border;
        } else {
        }
        i = i81 & 2048;
        if (i != 0) {
            $dirty12 |= 48;
            i18 = i;
        } else {
            if ($changed1 & 48 == 0) {
                i18 = i;
                $dirty15 = restartGroup.changed(interactionSource) ? 32 : 16;
                $dirty12 |= $dirty15;
            } else {
                i18 = i;
                i = interactionSource;
            }
        }
        traceInProgress2 = $dirty12;
        final int obj48 = $dirty2;
        if ($dirty2 & $dirty1 == 306783378 && traceInProgress2 & 19 == 18) {
            if (traceInProgress2 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i31 = -234881025;
                    int i82 = -29360129;
                    int i83 = traceInProgress2;
                    $dirty16 = 6;
                    if (i80 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj4;
                            }
                            value = i9 != 0 ? i2 : $dirty5;
                            i14 = i14 != 0 ? i2 : obj3;
                            i6 = i6 != 0 ? i2 : obj15;
                            if (i81 & 128 != 0) {
                                $dirty5 = obj48 & i82;
                                obj17 = shape2;
                            } else {
                                $dirty5 = obj48;
                                obj17 = obj;
                            }
                            if (i81 & 256 != 0) {
                                obj10 = elevatedFilterChipColors;
                                $dirty = $dirty5;
                            } else {
                                obj10 = colors;
                                $dirty = $dirty5;
                            }
                            if (i81 & 512 != 0) {
                                obj39 = modifier2;
                                $dirty13 = i83;
                                i11 = selectableChipElevation;
                                elevatedFilterChipElevation-aqJV_2Y = FilterChipDefaults.INSTANCE.elevatedFilterChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty &= $dirty16;
                            } else {
                                obj39 = modifier2;
                                i11 = $dirty16;
                                $dirty13 = i83;
                                elevatedFilterChipElevation-aqJV_2Y = elevation;
                            }
                            border3 = i24 != 0 ? 0 : border;
                            if (i18 != 0) {
                                selectableChipElevation = elevatedFilterChipElevation-aqJV_2Y;
                                i17 = border3;
                                i4 = elevatedFilterChipColors;
                                i23 = i14;
                                i24 = i6;
                                $dirty15 = value;
                                $dirty3 = $dirty;
                                border2 = -106647389;
                                $dirty6 = obj10;
                                colors2 = obj17;
                                $dirty1 = obj39;
                            } else {
                                i4 = interactionSource;
                                selectableChipElevation = elevatedFilterChipElevation-aqJV_2Y;
                                i17 = border3;
                                i23 = i14;
                                i24 = i6;
                                $dirty15 = value;
                                $dirty3 = $dirty;
                                border2 = -106647389;
                                $dirty6 = obj10;
                                colors2 = obj17;
                                $dirty1 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = i81 & 128 != 0 ? obj48 & i82 : obj48;
                            if (i81 & 256 != 0) {
                                $dirty4 &= i31;
                            }
                            if (i81 & 512 != 0) {
                                $dirty4 &= i10;
                            }
                            $dirty6 = colors;
                            selectableChipElevation = elevation;
                            i17 = border;
                            i4 = interactionSource;
                            $dirty3 = $dirty4;
                            i11 = $dirty16;
                            i23 = obj3;
                            i24 = obj15;
                            colors2 = obj;
                            $dirty1 = obj4;
                            $dirty13 = i83;
                            border2 = -106647389;
                            $dirty15 = $dirty5;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(border2, $dirty3, $dirty13, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:552)");
                    }
                    ChipKt.SelectableChip-u0RnIRE(selected, $dirty1, obj9, $dirty15, obj12, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i11), i23, 0, i24, colors2, $dirty6, selectableChipElevation, i17, FilterChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.FilterChipPadding, i4, restartGroup, i42 | i62, i47 | i2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i13 = $dirty3;
                    obj7 = $dirty1;
                    z = $dirty15;
                    obj5 = i23;
                    obj2 = i24;
                    $composer2 = colors2;
                    obj13 = $dirty6;
                    obj6 = selectableChipElevation;
                    obj11 = i17;
                    obj16 = i4;
                } else {
                    restartGroup.skipToGroupEnd();
                    obj6 = elevation;
                    obj11 = border;
                    obj16 = interactionSource;
                    i13 = obj48;
                    $dirty13 = traceInProgress2;
                    composer = restartGroup;
                    $composer2 = obj;
                    obj2 = obj15;
                    obj5 = obj3;
                    z = $dirty5;
                    obj7 = obj4;
                    obj13 = colors;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty14 = $dirty13;
            $dirty13 = new ChipKt.ElevatedFilterChip.1(selected, onClick, label, obj7, z, obj5, obj2, $composer2, obj13, obj6, obj11, obj16, i80, $changed1, i81);
            endRestartGroup.updateScope((Function2)$dirty13);
        } else {
            $dirty14 = $dirty13;
        }
    }

    public static final void ElevatedSuggestionChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> icon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        boolean traceInProgress2;
        int i18;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        int $dirty4;
        int $dirty5;
        int elevatedSuggestionChipElevation-aqJV_2Y;
        int border2;
        int i12;
        int i11;
        Object obj11;
        Object obj;
        int i10;
        boolean traceInProgress;
        Object obj2;
        int shape2;
        int elevatedSuggestionChipColors;
        int i3;
        boolean z2;
        int $dirty3;
        boolean z;
        Object obj5;
        int i14;
        Object obj12;
        int i17;
        Object obj7;
        Object obj9;
        Object $composer2;
        int i4;
        Object obj8;
        int i7;
        int changed3;
        Object obj6;
        int i8;
        Object obj3;
        Object obj4;
        int changed;
        Object elevation2;
        int changed2;
        int value;
        int i16;
        int labelColor-vNxB06k$material3_release;
        int i19;
        int $dirty;
        Object i9;
        int i6;
        Object colors2;
        Object obj10;
        Object obj13;
        Object $dirty2;
        int $dirty6;
        int i15;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        int i;
        Composer composer;
        int i5;
        int i2;
        Object obj34;
        int obj42;
        final int i73 = $changed;
        final int i74 = i13;
        Composer restartGroup = $composer.startRestartGroup(-818834969);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)897@43055L5,898@43110L30,899@43197L33,908@43503L5,903@43331L538:Chip.kt#uh7d8r");
        $dirty4 = $changed;
        if (i74 & 1 != 0) {
            $dirty4 |= 6;
            obj4 = onClick;
        } else {
            if (i73 & 6 == 0) {
                i12 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty4 |= i12;
            } else {
                obj4 = onClick;
            }
        }
        if (i74 & 2 != 0) {
            $dirty4 |= 48;
            obj3 = label;
        } else {
            if (i73 & 48 == 0) {
                i11 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty4 |= i11;
            } else {
                obj3 = label;
            }
        }
        int i38 = i74 & 4;
        if (i38 != 0) {
            $dirty4 |= 384;
            obj2 = modifier;
        } else {
            if (i73 & 384 == 0) {
                i3 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty4 |= i3;
            } else {
                obj2 = modifier;
            }
        }
        $dirty3 = i74 & 8;
        if ($dirty3 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else {
            if (i73 & 3072 == 0) {
                i14 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty4 |= i14;
            } else {
                z = enabled;
            }
        }
        i17 = i74 & 16;
        if (i17 != 0) {
            $dirty4 |= 24576;
            obj7 = icon;
        } else {
            if (i73 & 24576 == 0) {
                i4 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty4 |= i4;
            } else {
                obj7 = icon;
            }
        }
        if (i67 &= i73 == 0) {
            if (i74 & 32 == 0) {
                changed3 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj8 = shape;
            }
            $dirty4 |= changed3;
        } else {
            obj8 = shape;
        }
        if (i70 &= i73 == 0) {
            if (i74 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj6 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj6 = colors;
        }
        int i75 = 12582912;
        if (i73 & i75 == 0) {
            obj42 = i75;
            if (i74 & 128 == 0) {
                changed2 = restartGroup.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty4 |= changed2;
        } else {
            obj42 = i75;
            elevation2 = elevation;
        }
        int i21 = i74 & 256;
        int i77 = 100663296;
        if (i21 != 0) {
            $dirty4 |= i77;
            value = i38;
            obj11 = border;
        } else {
            if (i73 & i77 == 0) {
                value = i38;
                i16 = restartGroup.changed(border) ? 67108864 : 33554432;
                $dirty4 |= i16;
            } else {
                value = i38;
                obj11 = border;
            }
        }
        int i39 = i74 & 512;
        int i79 = 805306368;
        if (i39 != 0) {
            $dirty4 |= i79;
            labelColor-vNxB06k$material3_release = i39;
            obj = interactionSource;
        } else {
            if (i73 & i79 == 0) {
                labelColor-vNxB06k$material3_release = i39;
                i19 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty4 |= i19;
            } else {
                labelColor-vNxB06k$material3_release = i39;
                obj = interactionSource;
            }
        }
        $dirty = $dirty4;
        if ($dirty4 & i81 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i82 = -29360129;
                int i37 = -3670017;
                int i83 = -458753;
                i10 = 6;
                if (i73 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (value != null) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj2;
                        }
                        value = $dirty3 != 0 ? obj2 : z;
                        obj13 = i17 != 0 ? obj2 : obj7;
                        if (i74 & 32 != 0) {
                            $dirty3 = $dirty & i83;
                            $dirty = shape2;
                        } else {
                            $dirty3 = $dirty;
                            $dirty = obj8;
                        }
                        if (i74 & 64 != 0) {
                            obj10 = elevatedSuggestionChipColors;
                            $dirty6 = $dirty3;
                        } else {
                            obj10 = obj6;
                            $dirty6 = $dirty3;
                        }
                        if (i74 & 128 != 0) {
                            obj34 = modifier3;
                            modifier2 = i15;
                            $dirty6 &= i82;
                            elevation2 = elevatedSuggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier3;
                            modifier2 = i10;
                        }
                        border2 = i21 != 0 ? 0 : border;
                        if (labelColor-vNxB06k$material3_release != 0) {
                            obj2 = obj34;
                            i15 = border2;
                            i = i10;
                            obj6 = obj10;
                            i9 = obj13;
                            $dirty5 = $dirty6;
                            $dirty2 = elevation2;
                            elevation2 = value;
                            colors2 = $dirty;
                        } else {
                            obj2 = obj34;
                            i = interactionSource;
                            i15 = border2;
                            obj6 = obj10;
                            i9 = obj13;
                            $dirty5 = $dirty6;
                            $dirty2 = elevation2;
                            elevation2 = value;
                            colors2 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i74 & 32 != 0) {
                            $dirty = i18;
                        }
                        if (i74 & 64 != 0) {
                            $dirty &= i37;
                        }
                        if (i74 & 128 != 0) {
                            i15 = border;
                            i = interactionSource;
                            $dirty5 = i24;
                            modifier2 = i10;
                            i9 = obj7;
                            colors2 = obj8;
                            $dirty2 = elevation2;
                            elevation2 = z;
                        } else {
                            i15 = border;
                            i = interactionSource;
                            modifier2 = i10;
                            i9 = obj7;
                            colors2 = obj8;
                            $dirty2 = elevation2;
                            $dirty5 = $dirty;
                            elevation2 = z;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-818834969, $dirty5, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:903)");
                }
                obj13 = obj6;
                obj3 = obj2;
                ChipKt.Chip-nkUnTEs(obj3, obj4, elevation2, obj3, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), restartGroup, modifier2), obj6.labelColor-vNxB06k$material3_release(elevation2), $dirty, i9, 0, colors2, obj13, $dirty2, i15, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, i, restartGroup, i32 | i51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = $dirty5;
                obj2 = obj3;
                z2 = elevation2;
                obj5 = i9;
                obj12 = colors2;
                obj9 = obj13;
                $composer2 = $dirty2;
                i7 = i15;
                i8 = i;
            } else {
                restartGroup.skipToGroupEnd();
                z2 = z;
                obj5 = obj7;
                composer = restartGroup;
                obj12 = obj8;
                obj9 = obj6;
                $composer2 = elevation2;
                i7 = border;
                i8 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ChipKt.ElevatedSuggestionChip.1(onClick, label, obj2, z2, obj5, obj12, obj9, $composer2, i7, i8, i73, i74);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void ElevatedSuggestionChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 icon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        int traceInProgress2;
        int i15;
        int modifier3;
        State borderStroke$material3_release;
        int value;
        int defaultsInvalid;
        Object modifier2;
        int $dirty4;
        int $dirty6;
        int elevatedSuggestionChipElevation-aqJV_2Y;
        int i14;
        int i6;
        Object obj2;
        Object interactionSource2;
        int i11;
        Object obj5;
        int shape2;
        int elevatedSuggestionChipColors;
        int i2;
        int $dirty;
        boolean traceInProgress;
        int labelTextFont;
        boolean z;
        boolean rememberedValue;
        Object obj4;
        int i3;
        int i7;
        Object obj12;
        Object obj13;
        Object obj;
        Object $composer2;
        int i8;
        Object obj11;
        int i4;
        int changed3;
        Object obj10;
        Object obj3;
        Object obj7;
        Object obj6;
        int changed;
        Object elevation2;
        int changed2;
        int value2;
        int i12;
        int labelColor-vNxB06k$material3_release;
        int i17;
        int $dirty2;
        Object i5;
        int i;
        Object colors2;
        Object obj9;
        Object obj14;
        Object $dirty5;
        int $dirty3;
        int i9;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        Object obj8;
        Composer composer;
        int i10;
        int i16;
        Object obj34;
        int obj42;
        final int i78 = $changed;
        final int i79 = i13;
        Composer restartGroup = $composer.startRestartGroup(1668751803);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)980@46960L5,981@47015L30,982@47102L33,984@47219L39,991@47440L5,986@47268L568:Chip.kt#uh7d8r");
        $dirty4 = $changed;
        if (i79 & 1 != 0) {
            $dirty4 |= 6;
            obj6 = onClick;
        } else {
            if (i78 & 6 == 0) {
                i14 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty4 |= i14;
            } else {
                obj6 = onClick;
            }
        }
        if (i79 & 2 != 0) {
            $dirty4 |= 48;
            obj7 = label;
        } else {
            if (i78 & 48 == 0) {
                i6 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty4 |= i6;
            } else {
                obj7 = label;
            }
        }
        int i40 = i79 & 4;
        if (i40 != 0) {
            $dirty4 |= 384;
            obj5 = modifier;
        } else {
            if (i78 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty4 |= i2;
            } else {
                obj5 = modifier;
            }
        }
        $dirty = i79 & 8;
        if ($dirty != 0) {
            $dirty4 |= 3072;
            rememberedValue = enabled;
        } else {
            if (i78 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty4 |= i3;
            } else {
                rememberedValue = enabled;
            }
        }
        i7 = i79 & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
            obj13 = icon;
        } else {
            if (i78 & 24576 == 0) {
                i8 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty4 |= i8;
            } else {
                obj13 = icon;
            }
        }
        if (i72 &= i78 == 0) {
            if (i79 & 32 == 0) {
                changed3 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj11 = shape;
            }
            $dirty4 |= changed3;
        } else {
            obj11 = shape;
        }
        if (i75 &= i78 == 0) {
            if (i79 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj10 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj10 = colors;
        }
        int i80 = 12582912;
        if (i78 & i80 == 0) {
            obj42 = i80;
            if (i79 & 128 == 0) {
                changed2 = restartGroup.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty4 |= changed2;
        } else {
            obj42 = i80;
            elevation2 = elevation;
        }
        int i19 = i79 & 256;
        int i82 = 100663296;
        if (i19 != 0) {
            $dirty4 |= i82;
            value2 = i40;
            obj2 = border;
        } else {
            if (i78 & i82 == 0) {
                value2 = i40;
                i12 = restartGroup.changed(border) ? 67108864 : 33554432;
                $dirty4 |= i12;
            } else {
                value2 = i40;
                obj2 = border;
            }
        }
        int i41 = i79 & 512;
        int i84 = 805306368;
        if (i41 != 0) {
            $dirty4 |= i84;
            labelColor-vNxB06k$material3_release = i41;
            interactionSource2 = interactionSource;
        } else {
            if (i78 & i84 == 0) {
                labelColor-vNxB06k$material3_release = i41;
                i17 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty4 |= i17;
            } else {
                labelColor-vNxB06k$material3_release = i41;
                interactionSource2 = interactionSource;
            }
        }
        $dirty2 = $dirty4;
        if ($dirty4 & i86 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i87 = -29360129;
                int i38 = -3670017;
                int i88 = -458753;
                i11 = 6;
                if (i78 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (value2 != null) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj5;
                        }
                        value2 = $dirty != 0 ? obj5 : rememberedValue;
                        obj14 = i7 != 0 ? obj5 : obj13;
                        if (i79 & 32 != 0) {
                            $dirty = $dirty2 & i88;
                            $dirty2 = shape2;
                        } else {
                            $dirty = $dirty2;
                            $dirty2 = obj11;
                        }
                        if (i79 & 64 != 0) {
                            obj9 = elevatedSuggestionChipColors;
                            $dirty3 = $dirty;
                        } else {
                            obj9 = obj10;
                            $dirty3 = $dirty;
                        }
                        if (i79 & 128 != 0) {
                            obj34 = modifier2;
                            modifier3 = i9;
                            $dirty3 &= i87;
                            elevation2 = elevatedSuggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier2;
                            modifier3 = i11;
                        }
                        $dirty6 = i19 != 0 ? 0 : border;
                        if (labelColor-vNxB06k$material3_release != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2121795492, "CC(remember):Chip.kt#9igjgp");
                            int i43 = 0;
                            Composer composer2 = restartGroup;
                            $dirty = 0;
                            rememberedValue = composer2.rememberedValue();
                            i7 = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i70 = 0;
                                composer2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                obj13 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj5 = obj34;
                            obj8 = invalid$iv;
                            obj10 = obj9;
                            i5 = obj14;
                            interactionSource2 = $dirty3;
                            $dirty5 = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty2;
                        } else {
                            obj5 = obj34;
                            obj8 = interactionSource;
                            obj10 = obj9;
                            i5 = obj14;
                            interactionSource2 = $dirty3;
                            $dirty5 = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i79 & 32 != 0) {
                            $dirty2 = i15;
                        }
                        if (i79 & 64 != 0) {
                            $dirty2 &= i38;
                        }
                        if (i79 & 128 != 0) {
                            interactionSource2 = i22;
                            modifier3 = i39;
                            $dirty6 = border;
                            obj8 = interactionSource;
                            i5 = obj13;
                            colors2 = obj11;
                            $dirty5 = elevation2;
                            elevation2 = rememberedValue;
                        } else {
                            $dirty6 = border;
                            obj8 = interactionSource;
                            modifier3 = i11;
                            i5 = obj13;
                            colors2 = obj11;
                            $dirty5 = elevation2;
                            interactionSource2 = $dirty2;
                            elevation2 = rememberedValue;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1668751803, interactionSource2, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:986)");
                }
                restartGroup.startReplaceGroup(2121812626);
                ComposerKt.sourceInformation(restartGroup, "1000@47755L21");
                if ($dirty6 == 0) {
                    borderStroke$material3_release = 0;
                } else {
                    borderStroke$material3_release = $dirty6.borderStroke$material3_release(elevation2, restartGroup, i25 |= labelTextFont);
                }
                restartGroup.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                    value = borderStroke$material3_release.getValue();
                } else {
                    value = 0;
                }
                obj14 = obj10;
                obj7 = obj5;
                ChipKt.Chip-nkUnTEs(obj7, obj6, elevation2, obj7, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), restartGroup, modifier3), obj10.labelColor-vNxB06k$material3_release(elevation2), $dirty2, i5, 0, colors2, obj14, $dirty5, value, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, obj8, restartGroup, i34 | i58);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty6;
                $dirty2 = interactionSource2;
                obj5 = obj7;
                z = elevation2;
                obj4 = i5;
                obj12 = colors2;
                obj = obj14;
                $composer2 = $dirty5;
                obj3 = obj8;
            } else {
                restartGroup.skipToGroupEnd();
                z = rememberedValue;
                obj4 = obj13;
                composer = restartGroup;
                obj12 = obj11;
                obj = obj10;
                $composer2 = elevation2;
                i4 = border;
                obj3 = interactionSource2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ChipKt.ElevatedSuggestionChip.3(onClick, label, obj5, z, obj4, obj12, obj, $composer2, i4, obj3, i78, i79);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void FilterChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i16) {
        Object obj4;
        Object obj10;
        Object obj23;
        boolean traceInProgress;
        Object endRestartGroup;
        int $dirty;
        int $dirty4;
        int defaultsInvalid;
        Object modifier2;
        int $dirty2;
        int $dirty5;
        Object filterChipElevation-aqJV_2Y;
        int $dirty1;
        Object obj22;
        boolean traceInProgress2;
        int i15;
        int i;
        int i19;
        int border2;
        int i12;
        int i7;
        int shape2;
        int filterChipColors;
        int i4;
        Object filterChipBorder-_7El2pE;
        boolean $dirty6;
        Object obj3;
        Object obj;
        boolean z;
        Object obj12;
        Object obj11;
        Object obj8;
        Object obj13;
        Object $composer2;
        Object obj19;
        Object obj2;
        int i18;
        Object obj5;
        int i3;
        boolean z2;
        Object obj20;
        Object obj14;
        Object obj9;
        Object obj16;
        int i23;
        int i8;
        int $dirty3;
        int i17;
        int enabled4;
        boolean enabled2;
        int i6;
        int i9;
        int i10;
        int i2;
        boolean enabled3;
        int i14;
        int i5;
        int i13;
        int changed2;
        int changed4;
        int changed3;
        int changed;
        long l;
        int i21;
        float f;
        Object obj15;
        int i22;
        androidx.compose.material3.SelectableChipElevation selectableChipElevation;
        BorderStroke borderStroke;
        float height-D9Ej5fM;
        PaddingValues filterChipPadding;
        Object obj7;
        Composer composer;
        int i11;
        int $dirty12;
        Object obj18;
        Object obj17;
        Object obj21;
        Object obj6;
        int i20;
        ScopeUpdateScope scopeUpdateScope;
        Object obj44;
        final int i86 = $changed;
        final int i87 = i16;
        Composer restartGroup = $composer.startRestartGroup(-1711985619);
        ComposerKt.sourceInformation(restartGroup, "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)462@22511L5,463@22572L18,464@22653L21,465@22723L35,474@23031L5,468@22824L554:Chip.kt#uh7d8r");
        $dirty2 = $changed;
        if (i87 & 1 != 0) {
            $dirty2 |= 6;
            z2 = selected;
        } else {
            if (i86 & 6 == 0) {
                i15 = restartGroup.changed(selected) ? 4 : 2;
                $dirty2 |= i15;
            } else {
                z2 = selected;
            }
        }
        if (i87 & 2 != 0) {
            $dirty2 |= 48;
            obj14 = onClick;
        } else {
            if (i86 & 48 == 0) {
                i = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj14 = onClick;
            }
        }
        if (i87 & 4 != 0) {
            $dirty2 |= 384;
            obj16 = label;
        } else {
            if (i86 & 384 == 0) {
                i19 = restartGroup.changedInstance(label) ? 256 : 128;
                $dirty2 |= i19;
            } else {
                obj16 = label;
            }
        }
        border2 = i87 & 8;
        if (border2 != 0) {
            $dirty2 |= 3072;
            obj19 = modifier;
        } else {
            if (i86 & 3072 == 0) {
                i18 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i18;
            } else {
                obj19 = modifier;
            }
        }
        i3 = i87 & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            $dirty6 = enabled;
        } else {
            if (i86 & 24576 == 0) {
                i23 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty2 |= i23;
            } else {
                $dirty6 = enabled;
            }
        }
        $dirty3 = i87 & 32;
        i17 = 196608;
        if ($dirty3 != 0) {
            $dirty2 |= i17;
            obj = leadingIcon;
        } else {
            if (i86 & i17 == 0) {
                i6 = restartGroup.changedInstance(leadingIcon) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                obj = leadingIcon;
            }
        }
        i9 = i87 & 64;
        i10 = 1572864;
        if (i9 != 0) {
            $dirty2 |= i10;
            obj12 = trailingIcon;
        } else {
            if (i86 & i10 == 0) {
                i5 = restartGroup.changedInstance(trailingIcon) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                obj12 = trailingIcon;
            }
        }
        int i92 = 12582912;
        i13 = i86 & i92;
        if (i13 == 0) {
            if (i87 & 128 == 0) {
                changed2 = restartGroup.changed(shape) ? 8388608 : 4194304;
            } else {
                obj8 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj8 = shape;
        }
        if (i86 & i90 == 0) {
            if (i87 & 256 == 0) {
                changed4 = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj4 = colors;
            }
            $dirty2 |= changed4;
        } else {
            obj4 = colors;
        }
        if (i86 & i91 == 0) {
            if (i87 & 512 == 0) {
                changed3 = restartGroup.changed(elevation) ? 536870912 : 268435456;
            } else {
                obj10 = elevation;
            }
            $dirty2 |= changed3;
        } else {
            obj10 = elevation;
        }
        if ($changed1 & 6 == 0) {
            if (i87 & 1024 == 0) {
                i17 = restartGroup.changed(border) ? 4 : 2;
            } else {
                obj23 = border;
            }
            $dirty1 |= i17;
        } else {
            obj23 = border;
        }
        int obj53 = $dirty1;
        int $dirty13 = i87 & 2048;
        if ($dirty13 != 0) {
            $dirty12 = i89;
            enabled4 = $dirty13;
            obj22 = interactionSource;
        } else {
            if ($changed1 & 48 == 0) {
                enabled4 = $dirty13;
                i14 = restartGroup.changed(interactionSource) ? 32 : 16;
                $dirty12 = i10;
            } else {
                enabled4 = $dirty13;
                obj22 = interactionSource;
                $dirty12 = obj53;
            }
        }
        obj53 = $dirty2;
        if ($dirty2 & i2 == 306783378 && $dirty12 & 19 == 18) {
            if ($dirty12 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i43 = 6;
                    if (i86 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (border2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj19;
                            }
                            enabled3 = i3 != 0 ? border2 : $dirty6;
                            obj18 = $dirty3 != 0 ? border2 : obj;
                            obj17 = i9 != 0 ? border2 : obj12;
                            if (i87 & 128 != 0) {
                                $dirty6 = obj53 & i80;
                                obj21 = shape2;
                            } else {
                                $dirty6 = obj53;
                                obj21 = obj8;
                            }
                            if (i87 & 256 != 0) {
                                obj6 = filterChipColors;
                                $dirty3 = $dirty6;
                            } else {
                                obj6 = colors;
                                $dirty3 = $dirty6;
                            }
                            if (i87 & 512 != 0) {
                                obj44 = modifier2;
                                i20 = enabled4;
                                $dirty = i9;
                                filterChipElevation-aqJV_2Y = FilterChipDefaults.INSTANCE.filterChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                obj22 = $dirty3;
                            } else {
                                obj44 = modifier2;
                                $dirty = i43;
                                i20 = enabled4;
                                filterChipElevation-aqJV_2Y = elevation;
                                obj22 = $dirty3;
                            }
                            if (i87 & 1024 != 0) {
                                filterChipBorder-_7El2pE = FilterChipDefaults.INSTANCE.filterChipBorder-_7El2pE(enabled3, z2, 0, i13, 0, obj22, 0, obj24, 0, obj26, 0);
                                $dirty12 &= -15;
                            } else {
                                enabled2 = enabled3;
                                filterChipBorder-_7El2pE = border;
                            }
                            if (i20 != 0) {
                                selectableChipElevation = filterChipElevation-aqJV_2Y;
                                $dirty5 = obj22;
                                borderStroke = filterChipBorder-_7El2pE;
                                obj7 = $dirty6;
                                i2 = enabled2;
                                border2 = $dirty12;
                                l = obj18;
                                f = obj17;
                                obj15 = obj21;
                                i22 = obj6;
                                enabled4 = obj44;
                            } else {
                                obj7 = interactionSource;
                                selectableChipElevation = filterChipElevation-aqJV_2Y;
                                $dirty5 = obj22;
                                borderStroke = filterChipBorder-_7El2pE;
                                i2 = enabled2;
                                border2 = $dirty12;
                                l = obj18;
                                f = obj17;
                                obj15 = obj21;
                                i22 = obj6;
                                enabled4 = obj44;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = i87 & 128 != 0 ? obj53 & i40 : obj53;
                            if (i87 & 256 != 0) {
                                $dirty4 &= i12;
                            }
                            if (i87 & 512 != 0) {
                                $dirty4 &= i7;
                            }
                            if (i87 & 1024 != 0) {
                                border2 = $dirty12 & -15;
                                $dirty5 = $dirty4;
                                $dirty = i88;
                                i22 = colors;
                                selectableChipElevation = elevation;
                                borderStroke = border;
                                obj7 = obj22;
                                i2 = $dirty6;
                                l = obj;
                                f = obj12;
                                obj15 = obj8;
                                enabled4 = obj19;
                            } else {
                                $dirty5 = $dirty4;
                                $dirty = $dirty14;
                                i22 = colors;
                                selectableChipElevation = elevation;
                                borderStroke = border;
                                obj7 = obj22;
                                i2 = $dirty6;
                                l = obj;
                                f = obj12;
                                obj15 = obj8;
                                enabled4 = obj19;
                                border2 = $dirty12;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1711985619, $dirty5, border2, "androidx.compose.material3.FilterChip (Chip.kt:468)");
                    }
                    ChipKt.SelectableChip-u0RnIRE(selected, enabled4, obj14, i2, obj16, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), restartGroup, $dirty), l, 0, f, obj15, i22, selectableChipElevation, borderStroke, FilterChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.FilterChipPadding, obj7, restartGroup, i33 | i57, i38 | obj22);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i8 = $dirty5;
                    $dirty12 = border2;
                    obj3 = enabled4;
                    z = i2;
                    obj11 = l;
                    obj13 = f;
                    $composer2 = obj15;
                    obj2 = i22;
                    obj5 = selectableChipElevation;
                    obj20 = borderStroke;
                    obj9 = obj7;
                } else {
                    restartGroup.skipToGroupEnd();
                    obj5 = elevation;
                    obj20 = border;
                    i8 = obj53;
                    obj9 = obj22;
                    composer = restartGroup;
                    $composer2 = obj8;
                    obj13 = obj12;
                    obj11 = obj;
                    z = $dirty6;
                    obj3 = obj19;
                    obj2 = colors;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ChipKt.FilterChip.1(selected, onClick, label, obj3, z, obj11, obj13, $composer2, obj2, obj5, obj20, obj9, i86, $changed1, i87);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void InputChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i17) {
        int anon;
        Object obj10;
        Object obj9;
        Object obj11;
        Object obj4;
        Object obj17;
        boolean traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        int $dirty;
        int defaultsInvalid;
        Object modifier2;
        int $dirty2;
        int $dirty3;
        int $dirty4;
        Object inputChipElevation-aqJV_2Y;
        int $dirty1;
        int i18;
        int i7;
        Object obj;
        Object obj16;
        int i9;
        int i12;
        Object border2;
        boolean traceInProgress;
        int shapedAvatar;
        int i5;
        Object obj12;
        boolean z3;
        Shape shape3;
        int inputChipColors;
        int i19;
        boolean $dirty12;
        Object obj7;
        int i22;
        Object value2;
        Object obj13;
        Object obj8;
        Object avatar2;
        Shape $composer2;
        androidx.compose.material3.SelectableChipColors selectableChipColors;
        int rememberComposableLambda;
        Object obj2;
        androidx.compose.material3.SelectableChipElevation selectableChipElevation;
        boolean z2;
        BorderStroke borderStroke;
        Object obj15;
        int i2;
        int i24;
        boolean iNSTANCE;
        int i21;
        int modifier3;
        boolean z;
        Object enabled2;
        int i3;
        int changed;
        int i10;
        int i6;
        int i16;
        boolean i27;
        int i26;
        int i23;
        TextStyle value;
        int i25;
        int i4;
        int i11;
        int i8;
        int changed4;
        int changed3;
        int changed2;
        androidx.compose.material3.SelectableChipColors selectableChipColors2;
        Object obj3;
        Object obj5;
        float height-D9Ej5fM;
        PaddingValues inputChipPadding;
        int i14;
        Composer composer;
        int i;
        int i13;
        Object obj6;
        Shape shape2;
        Object obj14;
        int i15;
        int i20;
        ScopeUpdateScope scopeUpdateScope;
        Object obj44;
        final int i92 = $changed;
        final int i93 = $changed1;
        anon = i17;
        Composer restartGroup = $composer.startRestartGroup(1658928131);
        ComposerKt.sourceInformation(restartGroup, "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)638@30882L5,639@30942L17,640@31021L20,641@31089L34,671@32220L5,665@32014L745:Chip.kt#uh7d8r");
        $dirty3 = $changed;
        if (anon & 1 != 0) {
            $dirty3 |= 6;
            z2 = selected;
        } else {
            if (i92 & 6 == 0) {
                i18 = restartGroup.changed(selected) ? 4 : 2;
                $dirty3 |= i18;
            } else {
                z2 = selected;
            }
        }
        if (anon & 2 != 0) {
            $dirty3 |= 48;
            obj15 = onClick;
        } else {
            if (i92 & 48 == 0) {
                i7 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty3 |= i7;
            } else {
                obj15 = onClick;
            }
        }
        if (anon & 4 != 0) {
            $dirty3 |= 384;
            obj = label;
        } else {
            if (i92 & 384 == 0) {
                i24 = restartGroup.changedInstance(label) ? 256 : 128;
                $dirty3 |= i24;
            } else {
                obj = label;
            }
        }
        iNSTANCE = anon & 8;
        if (iNSTANCE != null) {
            $dirty3 |= 3072;
            obj12 = modifier;
        } else {
            if (i92 & 3072 == 0) {
                i21 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty3 |= i21;
            } else {
                obj12 = modifier;
            }
        }
        int i94 = anon & 16;
        if (i94 != 0) {
            $dirty3 |= 24576;
            $dirty12 = enabled;
        } else {
            if (i92 & 24576 == 0) {
                i16 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty3 |= i16;
            } else {
                $dirty12 = enabled;
            }
        }
        i27 = anon & 32;
        i26 = 196608;
        if (i27 != 0) {
            $dirty3 |= i26;
            value2 = leadingIcon;
        } else {
            if (i92 & i26 == 0) {
                i23 = restartGroup.changedInstance(leadingIcon) ? 131072 : 65536;
                $dirty3 |= i23;
            } else {
                value2 = leadingIcon;
            }
        }
        value = anon & 64;
        i25 = 1572864;
        if (value != null) {
            $dirty3 |= i25;
            obj8 = avatar;
        } else {
            if (i92 & i25 == 0) {
                i4 = restartGroup.changedInstance(avatar) ? 1048576 : 524288;
                $dirty3 |= i4;
            } else {
                obj8 = avatar;
            }
        }
        rememberComposableLambda = anon & 128;
        i11 = 12582912;
        if (rememberComposableLambda != 0) {
            $dirty3 |= i11;
            obj2 = trailingIcon;
        } else {
            if (i92 & i11 == 0) {
                i8 = restartGroup.changedInstance(trailingIcon) ? 8388608 : 4194304;
                $dirty3 |= i8;
            } else {
                obj2 = trailingIcon;
            }
        }
        if (i92 & i96 == 0) {
            if (anon & 256 == 0) {
                changed4 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj10 = shape;
            }
            $dirty3 |= changed4;
        } else {
            obj10 = shape;
        }
        if (i92 & i97 == 0) {
            if (anon & 512 == 0) {
                changed3 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj9 = colors;
            }
            $dirty3 |= changed3;
        } else {
            obj9 = colors;
        }
        if (i93 & 6 == 0) {
            if (anon & 1024 == 0) {
                i3 = restartGroup.changed(elevation) ? 4 : 2;
            } else {
                obj11 = elevation;
            }
            $dirty1 |= i3;
        } else {
            obj11 = elevation;
        }
        if (i93 & 48 == 0) {
            if (anon & 2048 == 0) {
                i26 = restartGroup.changed(border) ? 32 : 16;
            } else {
                obj4 = border;
            }
            $dirty1 |= i26;
        } else {
            obj4 = border;
        }
        i12 = anon & 4096;
        if (i12 != 0) {
            $dirty1 |= 384;
            obj17 = interactionSource;
        } else {
            if (i93 & 384 == 0) {
                i4 = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= i4;
            } else {
                obj17 = interactionSource;
            }
        }
        final int obj54 = $dirty3;
        if ($dirty3 & i6 == 306783378 && $dirty1 & 147 == 146) {
            if ($dirty1 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i49 = 6;
                    if (i92 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (iNSTANCE != null) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj12;
                            }
                            z = i94 != 0 ? obj12 : $dirty12;
                            i = i27 != 0 ? obj12 : value2;
                            i13 = value != null ? obj12 : obj8;
                            obj6 = rememberComposableLambda != 0 ? obj12 : obj2;
                            if (anon & 256 != 0) {
                                $dirty12 = obj54 & i88;
                                shape2 = shape3;
                            } else {
                                shape2 = shape;
                                $dirty12 = obj54;
                            }
                            if (anon & 512 != 0) {
                                obj14 = inputChipColors;
                                i15 = $dirty12;
                            } else {
                                obj14 = colors;
                                i15 = $dirty12;
                            }
                            if (anon & 1024 != 0) {
                                obj44 = modifier2;
                                i20 = i6;
                                $dirty2 = i27;
                                inputChipElevation-aqJV_2Y = InputChipDefaults.INSTANCE.inputChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty1 = iNSTANCE & -15;
                            } else {
                                obj44 = modifier2;
                                $dirty2 = i49;
                                iNSTANCE = $dirty1;
                                i20 = i12;
                                inputChipElevation-aqJV_2Y = elevation;
                            }
                            if (anon & 2048 != 0) {
                                border2 = InputChipDefaults.INSTANCE.inputChipBorder-_7El2pE(z, z2, 0, i26, 0, i25, 0, i11, 0, obj26, 0);
                                $dirty1 &= -113;
                            } else {
                                border2 = border;
                            }
                            if (i20 != 0) {
                                obj3 = inputChipElevation-aqJV_2Y;
                                obj5 = border2;
                                i14 = obj12;
                                i27 = z;
                                i25 = i;
                                obj8 = i13;
                                i11 = obj6;
                                changed2 = shape2;
                                selectableChipColors2 = obj14;
                                $dirty4 = i15;
                                enabled2 = obj44;
                            } else {
                                i14 = interactionSource;
                                obj3 = inputChipElevation-aqJV_2Y;
                                obj5 = border2;
                                i27 = z;
                                i25 = i;
                                obj8 = i13;
                                i11 = obj6;
                                changed2 = shape2;
                                selectableChipColors2 = obj14;
                                $dirty4 = i15;
                                enabled2 = obj44;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty = anon & 256 != 0 ? obj54 & i32 : obj54;
                            if (anon & 512 != 0) {
                                $dirty &= i9;
                            }
                            if (anon & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            if (anon & 2048 != 0) {
                                $dirty1 &= -113;
                            }
                            $dirty4 = $dirty;
                            $dirty2 = i95;
                            changed2 = shape;
                            selectableChipColors2 = colors;
                            obj3 = elevation;
                            obj5 = border;
                            i14 = interactionSource;
                            enabled2 = obj12;
                            i27 = $dirty12;
                            i25 = value2;
                            i11 = obj2;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1658928131, $dirty4, $dirty1, "androidx.compose.material3.InputChip (Chip.kt:643)");
                    }
                    restartGroup.startReplaceGroup(417920884);
                    ComposerKt.sourceInformation(restartGroup, "649@31531L5,651@31584L419");
                    i19 = 1;
                    if (obj8 != null) {
                        $dirty12 = i27 ? 1065353216 : 1052938076;
                        ChipKt.InputChip.1 anon2 = new ChipKt.InputChip.1($dirty12, ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), restartGroup, $dirty2), obj8);
                        i4 = shapedAvatar;
                    } else {
                        i4 = shapedAvatar;
                    }
                    restartGroup.endReplaceGroup();
                    int i33 = 0;
                    i5 = i4 != 0 ? i19 : i33;
                    i22 = i25 != null ? i19 : i33;
                    if (i11 != null) {
                    } else {
                        i19 = i33;
                    }
                    ChipKt.SelectableChip-u0RnIRE(selected, enabled2, obj15, i27, label, TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), restartGroup, $dirty2), i25, i4, i11, changed2, selectableChipColors2, obj3, obj5, InputChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.inputChipPadding(i5, i22, i19), i14, restartGroup, i40 | i69, i45 | i75);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj13 = obj8;
                    obj16 = enabled2;
                    z3 = i27;
                    obj7 = i25;
                    avatar2 = i11;
                    $composer2 = changed2;
                    selectableChipColors = selectableChipColors2;
                    selectableChipElevation = obj3;
                    borderStroke = obj5;
                    i2 = i14;
                    modifier3 = $dirty4;
                    i10 = $dirty1;
                } else {
                    restartGroup.skipToGroupEnd();
                    selectableChipColors = colors;
                    borderStroke = border;
                    i2 = interactionSource;
                    modifier3 = obj54;
                    obj16 = obj12;
                    z3 = $dirty12;
                    obj7 = value2;
                    obj13 = obj8;
                    composer = restartGroup;
                    avatar2 = obj2;
                    $composer2 = shape;
                    selectableChipElevation = elevation;
                    i10 = $dirty1;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new ChipKt.InputChip.2(selected, onClick, label, obj16, z3, obj7, obj13, avatar2, $composer2, selectableChipColors, selectableChipElevation, borderStroke, i2, i92, i93, i17);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    private static final void SelectableChip-u0RnIRE(boolean selected, Modifier modifier, Function0<Unit> onClick, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        boolean traceInProgress2;
        Object endRestartGroup;
        boolean obj3;
        Modifier z;
        Object obj10;
        Object obj2;
        Object obj12;
        float f;
        Object obj7;
        Modifier skipping;
        boolean traceInProgress;
        Object rememberedValue;
        Object str;
        int unbox-impl;
        boolean restartGroup;
        int $dirty5;
        Object $dirty4;
        int i19;
        int $dirty1;
        State $dirty12;
        int i16;
        int i10;
        Object obj6;
        int i15;
        int i11;
        Object obj4;
        Object obj11;
        Object obj8;
        Object $dirty;
        Object obj;
        Object obj9;
        Object obj5;
        int i3;
        int changed;
        int changed3;
        int interactionSource2;
        int i12;
        float companion;
        int i8;
        int i9;
        int $dirty2;
        int $dirty3;
        int i7;
        int i13;
        Composer composer;
        int i18;
        int i;
        int changed2;
        int i2;
        int i4;
        int i5;
        int i6;
        int i14;
        int i17;
        int changed4;
        ScopeUpdateScope scopeUpdateScope;
        int obj47;
        traceInProgress2 = selected;
        $dirty = modifier;
        z = enabled;
        obj3 = colors;
        obj = elevation;
        obj9 = interactionSource;
        int i56 = $changed;
        i3 = $changed1;
        restartGroup = $composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation(restartGroup, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)2023@98879L525,2013@98468L936:Chip.kt#uh7d8r");
        if (i56 & 6 == 0) {
            i16 = restartGroup.changed(traceInProgress2) ? 4 : 2;
            $dirty5 |= i16;
        }
        if (i56 & 48 == 0) {
            i10 = restartGroup.changed($dirty) ? 32 : changed;
            $dirty5 |= i10;
        }
        companion = 128;
        if (i56 & 384 == 0) {
            i8 = restartGroup.changedInstance(onClick) ? i12 : companion;
            $dirty5 |= i8;
        } else {
            obj6 = onClick;
        }
        int i57 = 1024;
        if (i56 & 3072 == 0) {
            i11 = restartGroup.changed(z) ? i9 : i57;
            $dirty5 |= i11;
        }
        final int i58 = 8192;
        if (i56 & 24576 == 0) {
            i18 = restartGroup.changedInstance(label) ? i13 : i58;
            $dirty5 |= i18;
        } else {
            obj4 = label;
        }
        int i59 = 196608;
        final int i60 = 65536;
        if (i56 & i59 == 0) {
            i4 = restartGroup.changed(labelTextStyle) ? i2 : i60;
            $dirty5 |= i4;
        } else {
            obj11 = labelTextStyle;
        }
        if (i56 & i61 == 0) {
            i5 = restartGroup.changedInstance(leadingIcon) ? 1048576 : 524288;
            $dirty5 |= i5;
        } else {
            obj8 = leadingIcon;
        }
        if (i56 & i63 == 0) {
            i6 = restartGroup.changedInstance(avatar) ? 8388608 : 4194304;
            $dirty5 |= i6;
        } else {
            obj10 = avatar;
        }
        if (i56 & i65 == 0) {
            i14 = restartGroup.changedInstance(trailingIcon) ? 67108864 : 33554432;
            $dirty5 |= i14;
        } else {
            obj2 = trailingIcon;
        }
        if (i56 & i66 == 0) {
            i17 = restartGroup.changed(shape) ? 536870912 : 268435456;
            $dirty5 |= i17;
        } else {
            obj5 = shape;
        }
        if (i3 & 6 == 0) {
            i = restartGroup.changed(obj3) ? 4 : 2;
            $dirty1 |= i;
        }
        if (i3 & 48 == 0 && restartGroup.changed(obj)) {
            if (restartGroup.changed(obj)) {
                changed = 32;
            }
            $dirty1 |= changed;
        }
        if (i3 & 384 == 0) {
            if (restartGroup.changed(border)) {
            } else {
                i12 = companion;
            }
            $dirty1 |= i12;
        } else {
            obj12 = border;
        }
        if (i3 & 3072 == 0) {
            if (restartGroup.changed(minHeight)) {
            } else {
                i9 = i57;
            }
            $dirty1 |= i9;
        } else {
            f = minHeight;
        }
        if (i3 & 24576 == 0) {
            if (restartGroup.changed(paddingValues)) {
            } else {
                i13 = i58;
            }
            $dirty1 |= i13;
        } else {
            obj7 = paddingValues;
        }
        if (i3 & i59 == 0) {
            if (restartGroup.changed(obj9)) {
            } else {
                i2 = i60;
            }
            $dirty1 |= i2;
        }
        if ($dirty5 & interactionSource2 == 306783378 && i44 &= $dirty1 == 74898) {
            if (i44 &= $dirty1 == 74898) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(402951308, $dirty5, $dirty1, "androidx.compose.material3.SelectableChip (Chip.kt:2009)");
                    }
                    restartGroup.startReplaceGroup(2072749057);
                    ComposerKt.sourceInformation(restartGroup, "2011@98346L39");
                    if (obj9 == null) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2072749708, "CC(remember):Chip.kt#9igjgp");
                        i15 = restartGroup;
                        interactionSource2 = 0;
                        obj47 = i40;
                        rememberedValue = i15.rememberedValue();
                        i12 = 0;
                        $dirty3 = $dirty5;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i46 = 0;
                            i15.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $dirty4 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        $dirty3 = $dirty5;
                        $dirty4 = obj9;
                    }
                    restartGroup.endReplaceGroup();
                    Object obj14 = $dirty4;
                    int i52 = 1;
                    obj47 = $dirty1;
                    restartGroup.startReplaceGroup(2072762384);
                    ComposerKt.sourceInformation(restartGroup, "2020@98742L43");
                    if (obj == null) {
                    } else {
                        $dirty12 = obj.shadowElevation$material3_release(z, (InteractionSource)obj14, restartGroup, i48 |= i50);
                    }
                    restartGroup.endReplaceGroup();
                    if ($dirty12 != null) {
                        companion = unbox-impl;
                    } else {
                        i19 = 0;
                        companion = $dirty12;
                    }
                    obj5 = restartGroup;
                    $dirty1 = obj8;
                    int i54 = $dirty3;
                    obj4 = trailingIcon;
                    ChipKt.SelectableChip.2 anon = new ChipKt.SelectableChip.2(obj3, z, selected, obj4, obj11, $dirty1, avatar, obj4, minHeight, paddingValues);
                    i7 = i54;
                    SurfaceKt.Surface-d85dljk(selected, onClick, SemanticsModifierKt.semantics$default($dirty, false, (Function1)ChipKt.SelectableChip.1.INSTANCE, i52, 0), enabled, shape, obj3.containerColor-WaAFU9c$material3_release(z, traceInProgress2), $dirty1, 0, obj4, 0, companion, border, obj14, (Function2)ComposableLambdaKt.rememberComposableLambda(-577614814, i52, anon, obj5, 54), obj5, i24 |= i33);
                    composer = obj5;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    composer = restartGroup;
                    i7 = $dirty5;
                    $dirty2 = $dirty1;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ChipKt.SelectableChip.3(selected, modifier, onClick, enabled, label, labelTextStyle, leadingIcon, avatar, trailingIcon, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void SuggestionChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> icon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        Object obj12;
        boolean traceInProgress2;
        int i2;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int $dirty2;
        int $dirty6;
        int suggestionChipElevation-aqJV_2Y;
        Object suggestionChipBorder-h1eT-Ww;
        int i10;
        int i3;
        Object obj5;
        int enabled2;
        boolean traceInProgress;
        Object interactionSource2;
        int shape2;
        int suggestionChipColors;
        int i9;
        boolean z;
        int $dirty3;
        boolean z2;
        Object obj13;
        int i7;
        Object obj7;
        int i5;
        Object obj9;
        Object obj8;
        Object $composer2;
        int i11;
        Object obj10;
        BorderStroke borderStroke;
        int changed2;
        Object obj2;
        int i;
        Object obj3;
        Object obj4;
        int changed;
        Object elevation2;
        int changed3;
        Object i12;
        int changed4;
        TextStyle value;
        int labelColor-vNxB06k$material3_release;
        int i8;
        int $dirty;
        Object obj11;
        int i4;
        Object colors2;
        Object obj;
        Object obj6;
        Object $dirty4;
        int $dirty5;
        Object obj14;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        int i14;
        Composer composer;
        int i6;
        int i15;
        Object obj34;
        int obj42;
        final int i74 = $changed;
        final int i75 = i13;
        Composer restartGroup = $composer.startRestartGroup(-1700130831);
        ComposerKt.sourceInformation(restartGroup, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)740@35497L5,741@35552L22,742@35631L25,743@35709L29,751@35977L5,746@35805L538:Chip.kt#uh7d8r");
        $dirty2 = $changed;
        if (i75 & 1 != 0) {
            $dirty2 |= 6;
            obj4 = onClick;
        } else {
            if (i74 & 6 == 0) {
                i10 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i10;
            } else {
                obj4 = onClick;
            }
        }
        if (i75 & 2 != 0) {
            $dirty2 |= 48;
            obj3 = label;
        } else {
            if (i74 & 48 == 0) {
                i3 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                obj3 = label;
            }
        }
        int i36 = i75 & 4;
        if (i36 != 0) {
            $dirty2 |= 384;
            interactionSource2 = modifier;
        } else {
            if (i74 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                interactionSource2 = modifier;
            }
        }
        $dirty3 = i75 & 8;
        if ($dirty3 != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i74 & 3072 == 0) {
                i7 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i7;
            } else {
                z2 = enabled;
            }
        }
        i5 = i75 & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            obj9 = icon;
        } else {
            if (i74 & 24576 == 0) {
                i11 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty2 |= i11;
            } else {
                obj9 = icon;
            }
        }
        if (i68 &= i74 == 0) {
            if (i75 & 32 == 0) {
                changed2 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj10 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj10 = shape;
        }
        if (i71 &= i74 == 0) {
            if (i75 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj2 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj2 = colors;
        }
        int i76 = 12582912;
        if (i74 & i76 == 0) {
            obj42 = i76;
            if (i75 & 128 == 0) {
                changed3 = restartGroup.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty2 |= changed3;
        } else {
            obj42 = i76;
            elevation2 = elevation;
        }
        if (i74 & i78 == 0) {
            if (i75 & 256 == 0) {
                changed4 = restartGroup.changed(border) ? 67108864 : 33554432;
            } else {
                obj12 = border;
            }
            $dirty2 |= changed4;
        } else {
            obj12 = border;
        }
        int i37 = i75 & 512;
        int i79 = 805306368;
        if (i37 != 0) {
            $dirty2 |= i79;
            labelColor-vNxB06k$material3_release = i37;
            obj5 = interactionSource;
        } else {
            if (i74 & i79 == 0) {
                labelColor-vNxB06k$material3_release = i37;
                i8 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty2 |= i8;
            } else {
                labelColor-vNxB06k$material3_release = i37;
                obj5 = interactionSource;
            }
        }
        $dirty = $dirty2;
        if ($dirty2 & i81 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i82 = -234881025;
                int i83 = -29360129;
                int i34 = -3670017;
                int i84 = -458753;
                enabled2 = 6;
                if (i74 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = interactionSource2;
                        }
                        value = $dirty3 != 0 ? interactionSource2 : z2;
                        obj6 = i5 != 0 ? interactionSource2 : obj9;
                        if (i75 & 32 != 0) {
                            $dirty3 = $dirty & i84;
                            $dirty = shape2;
                        } else {
                            $dirty3 = $dirty;
                            $dirty = obj10;
                        }
                        if (i75 & 64 != 0) {
                            obj = suggestionChipColors;
                            $dirty5 = $dirty3;
                        } else {
                            obj = obj2;
                            $dirty5 = $dirty3;
                        }
                        if (i75 & 128 != 0) {
                            obj34 = modifier2;
                            modifier3 = obj14;
                            $dirty5 &= i83;
                            elevation2 = suggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier2;
                            modifier3 = enabled2;
                        }
                        if (i75 & 256 != 0) {
                            suggestionChipBorder-h1eT-Ww = SuggestionChipDefaults.INSTANCE.suggestionChipBorder-h1eT-Ww(value, 0, $dirty3, 0, i5, 0, restartGroup);
                            $dirty5 &= i82;
                        } else {
                            enabled2 = value;
                            suggestionChipBorder-h1eT-Ww = border;
                        }
                        if (labelColor-vNxB06k$material3_release != 0) {
                            obj14 = suggestionChipBorder-h1eT-Ww;
                            i14 = i56;
                            obj2 = obj;
                            obj11 = obj6;
                            $dirty6 = $dirty5;
                            interactionSource2 = obj34;
                            $dirty4 = elevation2;
                            colors2 = $dirty;
                            elevation2 = enabled2;
                        } else {
                            interactionSource2 = obj34;
                            i14 = interactionSource;
                            obj14 = suggestionChipBorder-h1eT-Ww;
                            obj2 = obj;
                            obj11 = obj6;
                            $dirty6 = $dirty5;
                            $dirty4 = elevation2;
                            colors2 = $dirty;
                            elevation2 = enabled2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i75 & 32 != 0) {
                            $dirty = i2;
                        }
                        if (i75 & 64 != 0) {
                            $dirty &= i34;
                        }
                        if (i75 & 128 != 0) {
                            $dirty &= i83;
                        }
                        if (i75 & 256 != 0) {
                            obj14 = border;
                            i14 = interactionSource;
                            $dirty6 = i20;
                            modifier3 = enabled2;
                            obj11 = obj9;
                            colors2 = obj10;
                            $dirty4 = elevation2;
                            elevation2 = z2;
                        } else {
                            obj14 = border;
                            i14 = interactionSource;
                            modifier3 = enabled2;
                            obj11 = obj9;
                            colors2 = obj10;
                            $dirty4 = elevation2;
                            $dirty6 = $dirty;
                            elevation2 = z2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1700130831, $dirty6, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:746)");
                }
                obj6 = obj2;
                obj3 = interactionSource2;
                ChipKt.Chip-nkUnTEs(obj3, obj4, elevation2, obj3, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), restartGroup, modifier3), obj2.labelColor-vNxB06k$material3_release(elevation2), $dirty, obj11, 0, colors2, obj6, $dirty4, obj14, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, i14, restartGroup, i28 | i51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = $dirty6;
                interactionSource2 = obj3;
                z = elevation2;
                obj13 = obj11;
                obj7 = colors2;
                obj8 = obj6;
                $composer2 = $dirty4;
                borderStroke = obj14;
                i = i14;
            } else {
                restartGroup.skipToGroupEnd();
                z = z2;
                obj13 = obj9;
                composer = restartGroup;
                obj7 = obj10;
                obj8 = obj2;
                $composer2 = elevation2;
                borderStroke = border;
                i = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ChipKt.SuggestionChip.1(onClick, label, interactionSource2, z, obj13, obj7, obj8, $composer2, borderStroke, i, i74, i75);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void SuggestionChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 icon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        Object obj;
        int traceInProgress;
        int modifier3;
        State borderStroke$material3_release;
        int value;
        int i3;
        int defaultsInvalid;
        Object modifier2;
        int $dirty5;
        androidx.compose.material3.ChipBorder $dirty4;
        int suggestionChipElevation-aqJV_2Y;
        int i;
        int i2;
        Object interactionSource2;
        int i11;
        Object obj14;
        int shape2;
        int suggestionChipColors;
        int i12;
        int $dirty6;
        boolean traceInProgress2;
        int labelTextFont;
        boolean z;
        boolean rememberedValue;
        Object obj7;
        int i8;
        int i9;
        Object obj11;
        Composer $composer3;
        Object $composer2;
        Object obj9;
        Object obj4;
        int i10;
        Object obj15;
        androidx.compose.material3.ChipBorder chipBorder;
        int changed3;
        Object obj5;
        Object obj6;
        Object obj2;
        Object obj10;
        int changed2;
        Object elevation2;
        int changed;
        Object i14;
        int changed4;
        int value2;
        int labelColor-vNxB06k$material3_release;
        int i4;
        int $dirty2;
        Object obj3;
        int i5;
        Object colors2;
        Object obj8;
        Object obj13;
        Object $dirty;
        int $dirty3;
        int i15;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        Object obj12;
        Composer composer2;
        Composer composer;
        int i6;
        int i7;
        Object obj34;
        int obj42;
        final int i78 = $changed;
        final int i79 = i13;
        $composer3 = $composer.startRestartGroup(170629701);
        ComposerKt.sourceInformation($composer3, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)824@39441L5,825@39496L22,826@39575L25,827@39651L22,828@39725L39,835@39946L5,830@39774L568:Chip.kt#uh7d8r");
        $dirty5 = $changed;
        if (i79 & 1 != 0) {
            $dirty5 |= 6;
            obj10 = onClick;
        } else {
            if (i78 & 6 == 0) {
                i = $composer3.changedInstance(onClick) ? 4 : 2;
                $dirty5 |= i;
            } else {
                obj10 = onClick;
            }
        }
        if (i79 & 2 != 0) {
            $dirty5 |= 48;
            obj2 = label;
        } else {
            if (i78 & 48 == 0) {
                i2 = $composer3.changedInstance(label) ? 32 : 16;
                $dirty5 |= i2;
            } else {
                obj2 = label;
            }
        }
        int i40 = i79 & 4;
        if (i40 != 0) {
            $dirty5 |= 384;
            obj14 = modifier;
        } else {
            if (i78 & 384 == 0) {
                i12 = $composer3.changed(modifier) ? 256 : 128;
                $dirty5 |= i12;
            } else {
                obj14 = modifier;
            }
        }
        $dirty6 = i79 & 8;
        if ($dirty6 != 0) {
            $dirty5 |= 3072;
            rememberedValue = enabled;
        } else {
            if (i78 & 3072 == 0) {
                i8 = $composer3.changed(enabled) ? 2048 : 1024;
                $dirty5 |= i8;
            } else {
                rememberedValue = enabled;
            }
        }
        i9 = i79 & 16;
        if (i9 != 0) {
            $dirty5 |= 24576;
            obj9 = icon;
        } else {
            if (i78 & 24576 == 0) {
                i10 = $composer3.changedInstance(icon) ? 16384 : 8192;
                $dirty5 |= i10;
            } else {
                obj9 = icon;
            }
        }
        if (i72 &= i78 == 0) {
            if (i79 & 32 == 0) {
                changed3 = $composer3.changed(shape) ? 131072 : 65536;
            } else {
                obj15 = shape;
            }
            $dirty5 |= changed3;
        } else {
            obj15 = shape;
        }
        if (i75 &= i78 == 0) {
            if (i79 & 64 == 0) {
                changed2 = $composer3.changed(colors) ? 1048576 : 524288;
            } else {
                obj5 = colors;
            }
            $dirty5 |= changed2;
        } else {
            obj5 = colors;
        }
        int i80 = 12582912;
        if (i78 & i80 == 0) {
            obj42 = i80;
            if (i79 & 128 == 0) {
                changed = $composer3.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty5 |= changed;
        } else {
            obj42 = i80;
            elevation2 = elevation;
        }
        if (i78 & i82 == 0) {
            if (i79 & 256 == 0) {
                changed4 = $composer3.changed(border) ? 67108864 : 33554432;
            } else {
                obj = border;
            }
            $dirty5 |= changed4;
        } else {
            obj = border;
        }
        int i41 = i79 & 512;
        int i83 = 805306368;
        if (i41 != 0) {
            $dirty5 |= i83;
            labelColor-vNxB06k$material3_release = i41;
            interactionSource2 = interactionSource;
        } else {
            if (i78 & i83 == 0) {
                labelColor-vNxB06k$material3_release = i41;
                i4 = $composer3.changed(interactionSource) ? 536870912 : 268435456;
                $dirty5 |= i4;
            } else {
                labelColor-vNxB06k$material3_release = i41;
                interactionSource2 = interactionSource;
            }
        }
        $dirty2 = $dirty5;
        if ($dirty5 & i85 == 306783378) {
            if (!$composer3.getSkipping()) {
                $composer3.startDefaults();
                int i86 = -234881025;
                int i87 = -29360129;
                int i37 = -3670017;
                int i88 = -458753;
                i11 = 6;
                if (i78 & 1 != 0) {
                    if ($composer3.getDefaultsInvalid()) {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj14;
                        }
                        value2 = $dirty6 != 0 ? obj14 : rememberedValue;
                        obj13 = i9 != 0 ? obj14 : obj9;
                        if (i79 & 32 != 0) {
                            $dirty6 = $dirty2 & i88;
                            $dirty2 = shape2;
                        } else {
                            $dirty6 = $dirty2;
                            $dirty2 = obj15;
                        }
                        if (i79 & 64 != 0) {
                            obj8 = suggestionChipColors;
                            $dirty3 = $dirty6;
                        } else {
                            obj8 = obj5;
                            $dirty3 = $dirty6;
                        }
                        if (i79 & 128 != 0) {
                            obj34 = modifier2;
                            modifier3 = i70;
                            $dirty3 &= i87;
                            elevation2 = suggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier2;
                            modifier3 = i11;
                            composer2 = $composer3;
                        }
                        if (i79 & 256 != 0) {
                            $dirty4 = SuggestionChipDefaults.INSTANCE.suggestionChipBorder-d_3_b6Q(0, suggestionChipColors, 0, rememberedValue, 0, composer2);
                            $dirty3 &= i86;
                        } else {
                            $composer3 = composer2;
                            $dirty4 = border;
                        }
                        if (labelColor-vNxB06k$material3_release != 0) {
                            ComposerKt.sourceInformationMarkerStart($composer3, 1248029210, "CC(remember):Chip.kt#9igjgp");
                            int i43 = 0;
                            Composer composer3 = $composer3;
                            $dirty6 = 0;
                            rememberedValue = composer3.rememberedValue();
                            i9 = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i71 = 0;
                                composer3.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                obj9 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            obj14 = obj34;
                            obj12 = invalid$iv;
                            obj5 = obj8;
                            obj3 = obj13;
                            interactionSource2 = $dirty3;
                            $dirty = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty2;
                        } else {
                            obj14 = obj34;
                            obj12 = interactionSource;
                            obj5 = obj8;
                            obj3 = obj13;
                            interactionSource2 = $dirty3;
                            $dirty = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty2;
                        }
                    } else {
                        $composer3.skipToGroupEnd();
                        if (i79 & 32 != 0) {
                            $dirty2 = i3;
                        }
                        if (i79 & 64 != 0) {
                            $dirty2 &= i37;
                        }
                        if (i79 & 128 != 0) {
                            $dirty2 &= i87;
                        }
                        if (i79 & 256 != 0) {
                            interactionSource2 = i35;
                            modifier3 = i38;
                            $dirty4 = border;
                            obj12 = interactionSource;
                            obj3 = obj9;
                            colors2 = obj15;
                            $dirty = elevation2;
                            elevation2 = rememberedValue;
                        } else {
                            $dirty4 = border;
                            obj12 = interactionSource;
                            modifier3 = i11;
                            obj3 = obj9;
                            colors2 = obj15;
                            $dirty = elevation2;
                            interactionSource2 = $dirty2;
                            elevation2 = rememberedValue;
                        }
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(170629701, interactionSource2, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:830)");
                }
                $composer3.startReplaceGroup(1248043208);
                ComposerKt.sourceInformation($composer3, "842@40163L21");
                if ($dirty4 == null) {
                    borderStroke$material3_release = 0;
                } else {
                    borderStroke$material3_release = $dirty4.borderStroke$material3_release(elevation2, $composer3, i30 |= labelTextFont);
                }
                $composer3.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                    value = borderStroke$material3_release.getValue();
                } else {
                    value = 0;
                }
                obj13 = obj5;
                obj2 = obj14;
                ChipKt.Chip-nkUnTEs(obj2, obj10, elevation2, obj2, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), $composer3, modifier3), obj5.labelColor-vNxB06k$material3_release(elevation2), $dirty2, obj3, 0, colors2, obj13, $dirty, value, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, obj12, $composer3, i25 | i57);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chipBorder = $dirty4;
                $dirty2 = interactionSource2;
                obj14 = obj2;
                z = elevation2;
                obj7 = obj3;
                obj11 = colors2;
                $composer2 = obj13;
                obj4 = $dirty;
                obj6 = obj12;
            } else {
                $composer3.skipToGroupEnd();
                z = rememberedValue;
                composer = $composer3;
                obj7 = obj9;
                obj11 = obj15;
                $composer2 = obj5;
                obj4 = elevation2;
                chipBorder = border;
                obj6 = interactionSource2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ChipKt.SuggestionChip.3(onClick, label, obj14, z, obj7, obj11, $composer2, obj4, chipBorder, obj6, i78, i79);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void access$Chip-nkUnTEs(Modifier modifier, Function0 onClick, boolean enabled, Function2 label, TextStyle labelTextStyle, long labelColor, Function2 leadingIcon, Function2 trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        ChipKt.Chip-nkUnTEs(modifier, onClick, enabled, label, labelTextStyle, labelColor, leadingIcon, trailingIcon, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, $composer, $changed, $changed1);
    }

    public static final void access$ChipContent-fe0OD_I(Function2 label, TextStyle labelTextStyle, long labelColor, Function2 leadingIcon, Function2 avatar, Function2 trailingIcon, long leadingIconColor, long trailingIconColor, float minHeight, PaddingValues paddingValues, Composer $composer, int $changed) {
        ChipKt.ChipContent-fe0OD_I(label, labelTextStyle, labelColor, leadingIcon, avatar, trailingIcon, leadingIconColor, trailingIconColor, minHeight, paddingValues, $composer, $changed);
    }

    public static final void access$SelectableChip-u0RnIRE(boolean selected, Modifier modifier, Function0 onClick, boolean enabled, Function2 label, TextStyle labelTextStyle, Function2 leadingIcon, Function2 avatar, Function2 trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        ChipKt.SelectableChip-u0RnIRE(selected, modifier, onClick, enabled, label, labelTextStyle, leadingIcon, avatar, trailingIcon, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, $composer, $changed, $changed1);
    }

    public static final float access$getHorizontalElementsPadding$p() {
        return ChipKt.HorizontalElementsPadding;
    }

    public static final androidx.compose.material3.ChipColors getDefaultSuggestionChipColors(androidx.compose.material3.ColorScheme $this$defaultSuggestionChipColors) {
        androidx.compose.material3.ChipColors defaultSuggestionChipColorsCached$material3_release;
        androidx.compose.material3.ChipColors chipColors;
        int i2;
        long token;
        long token2;
        long unspecified-0d7_KjU2;
        long transparent-0d7_KjU;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i6;
        long unspecified-0d7_KjU;
        int i5;
        int i4;
        int i3;
        int i7;
        int i;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultSuggestionChipColors;
        if (colorScheme.getDefaultSuggestionChipColorsCached$material3_release() == null) {
            i6 = 0;
            i5 = 0;
            chipColors = new ChipColors(Color.Companion.getTransparent-0d7_KjU(), obj4, ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), obj8, Color.Companion.getUnspecified-0d7_KjU(), obj10, Color.Companion.getTransparent-0d7_KjU(), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), obj14, SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), i6, 0, i5, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), i6, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), i5, 0, 0, 14), i6, Color.Companion.getUnspecified-0d7_KjU(), i5, 0);
            i2 = 0;
            colorScheme.setDefaultSuggestionChipColorsCached$material3_release(chipColors);
        }
        return defaultSuggestionChipColorsCached$material3_release;
    }

    private static final PaddingValues inputChipPadding(boolean hasAvatar, boolean hasLeadingIcon, boolean hasTrailingIcon) {
        int $this$dp$iv;
        int $this$dp$iv2;
        int i;
        int i2;
        float constructor-impl2;
        float constructor-impl;
        float f;
        if (!hasAvatar) {
            if (!hasLeadingIcon) {
                i = 0;
                constructor-impl2 = Dp.constructor-impl((float)$this$dp$iv);
            } else {
                i = 0;
                constructor-impl2 = Dp.constructor-impl((float)$this$dp$iv);
            }
        } else {
        }
        if (hasTrailingIcon) {
            i2 = 0;
            f = $this$dp$iv2;
        } else {
            i2 = 0;
            f = constructor-impl;
        }
        return PaddingKt.PaddingValues-a9UjIt4$default(constructor-impl2, 0, f, 0, 10, 0);
    }

    static PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i4, Object object5) {
        int obj1;
        int obj2;
        int obj3;
        final int i = 0;
        if (i4 & 1 != 0) {
            obj1 = i;
        }
        if (i4 & 2 != 0) {
            obj2 = i;
        }
        if (i4 &= 4 != 0) {
            obj3 = i;
        }
        return ChipKt.inputChipPadding(obj1, obj2, obj3);
    }
}
