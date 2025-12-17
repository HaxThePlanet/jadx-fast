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
        Object obj3;
        Object obj;
        Object obj14;
        int $dirty14;
        int skipping;
        int $dirty3;
        int defaultsInvalid;
        Object modifier2;
        int $dirty6;
        int $dirty7;
        Object endRestartGroup;
        int i10;
        int assistChipElevation-aqJV_2Y;
        Object assistChipBorder-h1eT-Ww;
        Object $dirty12;
        boolean traceInProgress2;
        boolean enabled2;
        int $dirty13;
        int i8;
        int i11;
        Object obj11;
        int assistChipColors;
        boolean traceInProgress;
        int i14;
        int shape2;
        Object $dirty5;
        boolean z;
        Object obj4;
        Object obj9;
        Object obj7;
        Object obj16;
        int i17;
        Shape shape3;
        int i9;
        Object $composer2;
        boolean z3;
        androidx.compose.material3.ChipElevation chipElevation;
        int i22;
        BorderStroke borderStroke;
        int i;
        Object obj2;
        int i3;
        int i2;
        Object obj12;
        Object obj13;
        int $dirty4;
        Object leadingIcon2;
        int i20;
        Modifier i7;
        int i21;
        int i16;
        int changed3;
        Object i12;
        int i13;
        int changed2;
        int changed4;
        int changed;
        int $dirty16;
        TextStyle $dirty15;
        int i4;
        int labelColor-vNxB06k$material3_release;
        int i18;
        int $dirty1;
        Object obj15;
        boolean z2;
        Object colors2;
        Object obj8;
        Object $dirty2;
        int $dirty;
        Object obj5;
        Object obj6;
        Object obj10;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        int i5;
        Composer composer;
        int i6;
        int i19;
        Object obj36;
        final int i77 = $changed;
        final int i78 = i15;
        Composer restartGroup = $composer.startRestartGroup(313450168);
        ComposerKt.sourceInformation(restartGroup, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)126@6277L5,127@6328L18,128@6399L21,129@6469L25,137@6729L5,132@6561L541:Chip.kt#uh7d8r");
        $dirty6 = $changed;
        if (i78 & 1 != 0) {
            $dirty6 |= 6;
            obj2 = onClick;
        } else {
            if (i77 & 6 == 0) {
                i8 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty6 |= i8;
            } else {
                obj2 = onClick;
            }
        }
        if (i78 & 2 != 0) {
            $dirty6 |= 48;
            obj12 = label;
        } else {
            if (i77 & 48 == 0) {
                i11 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty6 |= i11;
            } else {
                obj12 = label;
            }
        }
        i14 = i78 & 4;
        if (i14 != 0) {
            $dirty6 |= 384;
            obj7 = modifier;
        } else {
            if (i77 & 384 == 0) {
                i17 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty6 |= i17;
            } else {
                obj7 = modifier;
            }
        }
        i9 = i78 & 8;
        if (i9 != 0) {
            $dirty6 |= 3072;
            z3 = enabled;
        } else {
            if (i77 & 3072 == 0) {
                i22 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty6 |= i22;
            } else {
                z3 = enabled;
            }
        }
        i = i78 & 16;
        if (i != 0) {
            $dirty6 |= 24576;
            obj13 = leadingIcon;
        } else {
            if (i77 & 24576 == 0) {
                i20 = restartGroup.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty6 |= i20;
            } else {
                obj13 = leadingIcon;
            }
        }
        i7 = i78 & 32;
        i21 = 196608;
        if (i7 != 0) {
            $dirty6 |= i21;
            $dirty5 = trailingIcon;
        } else {
            if (i77 & i21 == 0) {
                i21 = restartGroup.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty6 |= i21;
            } else {
                $dirty5 = trailingIcon;
            }
        }
        if (i77 & i80 == 0) {
            if (i78 & 64 == 0) {
                changed3 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj3 = shape;
            }
            $dirty6 |= changed3;
        } else {
            obj3 = shape;
        }
        if (i77 & i81 == 0) {
            if (i78 & 128 == 0) {
                changed2 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj4 = colors;
            }
            $dirty6 |= changed2;
        } else {
            obj4 = colors;
        }
        if (i77 & i82 == 0) {
            if (i78 & 256 == 0) {
                changed4 = restartGroup.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj = elevation;
            }
            $dirty6 |= changed4;
        } else {
            obj = elevation;
        }
        if (i77 & i83 == 0) {
            if (i78 & 512 == 0) {
                changed = restartGroup.changed(border) ? 536870912 : 268435456;
            } else {
                obj14 = border;
            }
            $dirty6 |= changed;
        } else {
            obj14 = border;
        }
        $dirty16 = i30;
        $dirty12 = i78 & 1024;
        if ($dirty12 != 0) {
            $dirty16 |= 6;
            labelColor-vNxB06k$material3_release = $dirty12;
        } else {
            if ($changed1 & 6 == 0) {
                labelColor-vNxB06k$material3_release = $dirty12;
                i18 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty16 |= i18;
            } else {
                labelColor-vNxB06k$material3_release = $dirty12;
                $dirty12 = interactionSource;
            }
        }
        traceInProgress2 = $dirty16;
        final int obj45 = $dirty6;
        if ($dirty6 & $dirty15 == 306783378 && traceInProgress2 & 3 == 2) {
            if (traceInProgress2 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i13 = -234881025;
                    int i27 = -29360129;
                    i4 = -3670017;
                    i18 = traceInProgress2;
                    $dirty13 = 6;
                    if (i77 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj7;
                            }
                            z2 = i9 != 0 ? i14 : z3;
                            if (i != 0) {
                                obj13 = i14;
                            }
                            i7 = i7 != 0 ? i14 : $dirty5;
                            if (i78 & 64 != 0) {
                                $dirty5 = obj45 & i4;
                                i4 = shape2;
                            } else {
                                i4 = shape;
                                $dirty5 = obj45;
                            }
                            if (i78 & 128 != 0) {
                                obj8 = assistChipColors;
                                $dirty = $dirty5;
                            } else {
                                obj8 = obj4;
                                $dirty = $dirty5;
                            }
                            if (i78 & 256 != 0) {
                                obj36 = modifier2;
                                $dirty14 = i18;
                                i2 = obj5;
                                $dirty &= i13;
                                i13 = assistChipElevation-aqJV_2Y;
                            } else {
                                obj36 = modifier2;
                                i2 = $dirty13;
                                $dirty14 = i18;
                                i13 = elevation;
                            }
                            if (i78 & 512 != 0) {
                                assistChipBorder-h1eT-Ww = AssistChipDefaults.INSTANCE.assistChipBorder-h1eT-Ww(z2, 0, $dirty5, 0, obj7, 0, restartGroup);
                                $dirty &= assistChipColors;
                            } else {
                                enabled2 = z2;
                                assistChipBorder-h1eT-Ww = border;
                            }
                            if (labelColor-vNxB06k$material3_release != 0) {
                                obj10 = assistChipBorder-h1eT-Ww;
                                i5 = assistChipColors;
                                obj15 = obj13;
                                obj6 = i13;
                                obj4 = obj8;
                                $dirty7 = $dirty;
                                leadingIcon2 = obj36;
                                colors2 = i7;
                                $dirty2 = i4;
                            } else {
                                i5 = interactionSource;
                                obj10 = assistChipBorder-h1eT-Ww;
                                obj15 = obj13;
                                obj6 = i13;
                                obj4 = obj8;
                                $dirty7 = $dirty;
                                leadingIcon2 = obj36;
                                colors2 = i7;
                                $dirty2 = i4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty3 = i78 & 64 != 0 ? obj45 & i4 : obj45;
                            if (i78 & 128 != 0) {
                                $dirty3 &= i27;
                            }
                            if (i78 & 256 != 0) {
                                $dirty3 &= i13;
                            }
                            if (i78 & 512 != 0) {
                                $dirty3 &= i10;
                            }
                            $dirty2 = shape;
                            obj6 = elevation;
                            obj10 = border;
                            i5 = interactionSource;
                            $dirty7 = $dirty3;
                            i2 = $dirty13;
                            colors2 = $dirty5;
                            enabled2 = z3;
                            obj15 = obj13;
                            $dirty14 = i18;
                            leadingIcon2 = obj7;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(313450168, $dirty7, $dirty14, "androidx.compose.material3.AssistChip (Chip.kt:132)");
                    }
                    i16 = enabled2;
                    obj5 = obj4;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i16, obj12, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i2), obj4.labelColor-vNxB06k$material3_release(enabled2), i18, obj15, colors2, $dirty2, obj5, obj6, obj10, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, i5, restartGroup, i40 | i60);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj11 = leadingIcon2;
                    z = i16;
                    obj9 = obj15;
                    obj16 = colors2;
                    shape3 = $dirty2;
                    $composer2 = obj5;
                    chipElevation = obj6;
                    borderStroke = obj10;
                    i3 = i5;
                    $dirty4 = $dirty7;
                } else {
                    restartGroup.skipToGroupEnd();
                    shape3 = shape;
                    borderStroke = border;
                    i3 = interactionSource;
                    $dirty14 = traceInProgress2;
                    obj11 = obj7;
                    composer = restartGroup;
                    obj16 = $dirty5;
                    $composer2 = obj4;
                    z = z3;
                    obj9 = obj13;
                    chipElevation = elevation;
                    $dirty4 = obj45;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty1 = $dirty14;
            obj36 = $dirty4;
            $dirty14 = new ChipKt.AssistChip.1(onClick, label, obj11, z, obj9, obj16, shape3, $composer2, chipElevation, borderStroke, i3, i77, $changed1, i78);
            endRestartGroup.updateScope((Function2)$dirty14);
        } else {
            $dirty1 = $dirty14;
            obj36 = $dirty4;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void AssistChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 leadingIcon, Function2 trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj7;
        Object obj13;
        Object obj15;
        int $dirty12;
        int skipping;
        int $dirty3;
        int defaultsInvalid;
        Object modifier2;
        int $dirty;
        androidx.compose.material3.ChipBorder $dirty5;
        Object endRestartGroup;
        int i12;
        int assistChipElevation-aqJV_2Y;
        Object $dirty1;
        int interactionSource2;
        int $dirty13;
        int i8;
        int i9;
        Object obj3;
        int assistChipColors;
        boolean traceInProgress;
        int borderStroke$material3_release;
        int value;
        int i7;
        int shape2;
        Object $dirty6;
        boolean z3;
        Object obj4;
        Object obj2;
        Object obj8;
        Object obj5;
        Shape $composer3;
        Composer $composer2;
        int i11;
        Object obj10;
        int $i$a$CacheChipKt$AssistChip$2;
        boolean z;
        androidx.compose.material3.ChipElevation chipElevation;
        int i14;
        androidx.compose.material3.ChipBorder chipBorder;
        int i2;
        Object obj12;
        Object obj9;
        int i16;
        Object obj6;
        Object obj14;
        int $dirty4;
        Object leadingIcon2;
        int i;
        Modifier i3;
        int i17;
        int i4;
        int changed2;
        Object i13;
        int changed3;
        int changed;
        int changed4;
        int $dirty14;
        TextStyle $dirty16;
        int i19;
        int labelColor-vNxB06k$material3_release;
        int i5;
        int $dirty15;
        Object enabled2;
        boolean z2;
        Object colors2;
        Object obj16;
        Object $dirty2;
        int $dirty7;
        Object obj;
        Object obj17;
        int i6;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        Object obj11;
        Composer composer;
        Composer composer2;
        int i10;
        int i18;
        Object obj36;
        final int i78 = $changed;
        final int i79 = i15;
        $composer2 = $composer.startRestartGroup(-1932300596);
        ComposerKt.sourceInformation($composer2, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)213@10395L5,214@10446L18,215@10517L21,216@10585L18,217@10655L39,224@10872L5,219@10704L571:Chip.kt#uh7d8r");
        $dirty = $changed;
        if (i79 & 1 != 0) {
            $dirty |= 6;
            obj12 = onClick;
        } else {
            if (i78 & 6 == 0) {
                i8 = $composer2.changedInstance(onClick) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj12 = onClick;
            }
        }
        if (i79 & 2 != 0) {
            $dirty |= 48;
            obj6 = label;
        } else {
            if (i78 & 48 == 0) {
                i9 = $composer2.changedInstance(label) ? 32 : 16;
                $dirty |= i9;
            } else {
                obj6 = label;
            }
        }
        i7 = i79 & 4;
        if (i7 != 0) {
            $dirty |= 384;
            obj8 = modifier;
        } else {
            if (i78 & 384 == 0) {
                i11 = $composer2.changed(modifier) ? 256 : 128;
                $dirty |= i11;
            } else {
                obj8 = modifier;
            }
        }
        $i$a$CacheChipKt$AssistChip$2 = i79 & 8;
        if ($i$a$CacheChipKt$AssistChip$2 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else {
            if (i78 & 3072 == 0) {
                i14 = $composer2.changed(enabled) ? 2048 : 1024;
                $dirty |= i14;
            } else {
                z = enabled;
            }
        }
        i2 = i79 & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            obj14 = leadingIcon;
        } else {
            if (i78 & 24576 == 0) {
                i = $composer2.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty |= i;
            } else {
                obj14 = leadingIcon;
            }
        }
        i3 = i79 & 32;
        i17 = 196608;
        if (i3 != 0) {
            $dirty |= i17;
            $dirty6 = trailingIcon;
        } else {
            if (i78 & i17 == 0) {
                i17 = $composer2.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty |= i17;
            } else {
                $dirty6 = trailingIcon;
            }
        }
        if (i78 & i81 == 0) {
            if (i79 & 64 == 0) {
                changed2 = $composer2.changed(shape) ? 1048576 : 524288;
            } else {
                obj7 = shape;
            }
            $dirty |= changed2;
        } else {
            obj7 = shape;
        }
        if (i78 & i82 == 0) {
            if (i79 & 128 == 0) {
                changed3 = $composer2.changed(colors) ? 8388608 : 4194304;
            } else {
                obj4 = colors;
            }
            $dirty |= changed3;
        } else {
            obj4 = colors;
        }
        if (i78 & i84 == 0) {
            if (i79 & 256 == 0) {
                changed = $composer2.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj13 = elevation;
            }
            $dirty |= changed;
        } else {
            obj13 = elevation;
        }
        if (i78 & i85 == 0) {
            if (i79 & 512 == 0) {
                changed4 = $composer2.changed(border) ? 536870912 : 268435456;
            } else {
                obj15 = border;
            }
            $dirty |= changed4;
        } else {
            obj15 = border;
        }
        $dirty14 = i27;
        $dirty1 = i79 & 1024;
        if ($dirty1 != 0) {
            $dirty14 |= 6;
            labelColor-vNxB06k$material3_release = $dirty1;
        } else {
            if ($changed1 & 6 == 0) {
                labelColor-vNxB06k$material3_release = $dirty1;
                i5 = $composer2.changed(interactionSource) ? 4 : 2;
                $dirty14 |= i5;
            } else {
                labelColor-vNxB06k$material3_release = $dirty1;
                $dirty1 = interactionSource;
            }
        }
        interactionSource2 = $dirty14;
        final int obj45 = $dirty;
        if ($dirty & $dirty16 == 306783378 && interactionSource2 & 3 == 2) {
            if (interactionSource2 & 3 == 2) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    int i83 = -234881025;
                    int i24 = -29360129;
                    i19 = -3670017;
                    i5 = interactionSource2;
                    $dirty13 = 6;
                    if (i78 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj8;
                            }
                            z2 = $i$a$CacheChipKt$AssistChip$2 != 0 ? i7 : z;
                            if (i2 != 0) {
                                obj14 = i7;
                            }
                            i3 = i3 != 0 ? i7 : $dirty6;
                            if (i79 & 64 != 0) {
                                $dirty6 = obj45 & i19;
                                i19 = shape2;
                            } else {
                                i19 = shape;
                                $dirty6 = obj45;
                            }
                            if (i79 & 128 != 0) {
                                obj16 = assistChipColors;
                                $dirty7 = $dirty6;
                            } else {
                                obj16 = obj4;
                                $dirty7 = $dirty6;
                            }
                            if (i79 & 256 != 0) {
                                obj36 = modifier2;
                                i16 = i74;
                                $dirty12 = i5;
                                $dirty7 &= i83;
                                i2 = assistChipElevation-aqJV_2Y;
                            } else {
                                obj36 = modifier2;
                                i16 = $dirty13;
                                composer2 = $composer2;
                                $dirty12 = i5;
                                i2 = elevation;
                            }
                            if (i79 & 512 != 0) {
                                $dirty5 = AssistChipDefaults.INSTANCE.assistChipBorder-d_3_b6Q(0, assistChipColors, 0, obj4, 0, composer2);
                                $dirty7 &= $dirty13;
                            } else {
                                $composer2 = composer2;
                                $dirty5 = border;
                            }
                            if (labelColor-vNxB06k$material3_release != 0) {
                                ComposerKt.sourceInformationMarkerStart($composer2, 267303551, "CC(remember):Chip.kt#9igjgp");
                                int i29 = 0;
                                assistChipColors = $composer2;
                                $dirty6 = 0;
                                Object rememberedValue = assistChipColors.rememberedValue();
                                obj8 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i75 = 0;
                                    assistChipColors.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheChipKt$AssistChip$2 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj11 = invalid$iv;
                                obj17 = i2;
                                z = z2;
                                obj4 = obj16;
                                interactionSource2 = $dirty7;
                                enabled2 = obj14;
                                colors2 = i3;
                                $dirty2 = i19;
                                leadingIcon2 = obj36;
                            } else {
                                obj11 = interactionSource;
                                obj17 = i2;
                                z = z2;
                                obj4 = obj16;
                                interactionSource2 = $dirty7;
                                enabled2 = obj14;
                                colors2 = i3;
                                $dirty2 = i19;
                                leadingIcon2 = obj36;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            $dirty3 = i79 & 64 != 0 ? obj45 & i19 : obj45;
                            if (i79 & 128 != 0) {
                                $dirty3 &= i24;
                            }
                            if (i79 & 256 != 0) {
                                $dirty3 &= i83;
                            }
                            if (i79 & 512 != 0) {
                                $dirty3 &= i12;
                            }
                            $dirty2 = shape;
                            obj17 = elevation;
                            $dirty5 = border;
                            obj11 = interactionSource;
                            i16 = $dirty13;
                            colors2 = $dirty6;
                            enabled2 = obj14;
                            interactionSource2 = $dirty3;
                            leadingIcon2 = obj8;
                            $dirty12 = i5;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1932300596, interactionSource2, $dirty12, "androidx.compose.material3.AssistChip (Chip.kt:219)");
                    }
                    $composer2.startReplaceGroup(267317901);
                    ComposerKt.sourceInformation($composer2, "231@11104L21");
                    if ($dirty5 == null) {
                        borderStroke$material3_release = 0;
                    } else {
                        borderStroke$material3_release = $dirty5.borderStroke$material3_release(z, $composer2, i44 |= $dirty6);
                    }
                    $composer2.endReplaceGroup();
                    if (borderStroke$material3_release != 0) {
                        value = borderStroke$material3_release.getValue();
                    } else {
                        value = 0;
                    }
                    obj = obj4;
                    i4 = z;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i4, obj6, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), $composer2, i16), obj4.labelColor-vNxB06k$material3_release(z), i5, enabled2, colors2, $dirty2, obj, obj17, value, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, obj11, $composer2, i39 | i60);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipBorder = $dirty5;
                    obj3 = leadingIcon2;
                    z3 = i4;
                    obj2 = enabled2;
                    obj5 = colors2;
                    $composer3 = $dirty2;
                    obj10 = obj;
                    chipElevation = obj17;
                    obj9 = obj11;
                    $dirty4 = interactionSource2;
                } else {
                    $composer2.skipToGroupEnd();
                    chipBorder = border;
                    obj9 = interactionSource;
                    $dirty12 = interactionSource2;
                    obj10 = obj4;
                    obj3 = obj8;
                    composer = $composer2;
                    obj2 = obj14;
                    $composer3 = shape;
                    $dirty4 = obj45;
                    obj5 = $dirty6;
                    z3 = z;
                    chipElevation = elevation;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty15 = $dirty12;
            obj36 = $dirty4;
            $dirty12 = new ChipKt.AssistChip.3(onClick, label, obj3, z3, obj2, obj5, $composer3, obj10, chipElevation, chipBorder, obj9, i78, $changed1, i79);
            endRestartGroup.updateScope((Function2)$dirty12);
        } else {
            $dirty15 = $dirty12;
            obj36 = $dirty4;
        }
    }

    private static final void Chip-nkUnTEs(Modifier modifier, Function0<Unit> onClick, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, long labelColor, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        int $dirty3;
        Object traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        Object obj10;
        Object obj8;
        float f;
        Object obj4;
        int changed3;
        int rememberedValue;
        Object str;
        int unbox-impl;
        boolean z;
        Object restartGroup;
        int $dirty;
        Object $i$a$CacheChipKt$Chip$interactionSource$1;
        int i5;
        int $dirty1;
        boolean skipping;
        boolean traceInProgress;
        int str2;
        int i16;
        Object obj3;
        int i7;
        State shadowElevation$material3_release;
        int i6;
        Object obj7;
        Object obj5;
        Object obj2;
        long l;
        Object obj9;
        Object obj6;
        Object obj11;
        Object obj;
        int i12;
        int i10;
        int interactionSource2;
        int i17;
        int $dirty12;
        int i3;
        Composer composer;
        Composer.Companion companion;
        int i4;
        int changed2;
        int $dirty2;
        int i13;
        int i2;
        int i14;
        int i;
        int i11;
        int i15;
        int i8;
        int i18;
        int i9;
        int changed;
        ScopeUpdateScope scopeUpdateScope;
        int obj43;
        traceInProgress2 = modifier;
        z = enabled;
        obj5 = elevation;
        Object obj12 = border;
        obj6 = $composer;
        int i50 = $changed1;
        i12 = obj45;
        restartGroup = $changed.startRestartGroup(1400504719);
        ComposerKt.sourceInformation(restartGroup, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1975@97230L477,1966@96860L847:Chip.kt#uh7d8r");
        if (i50 & 6 == 0) {
            i16 = restartGroup.changed(traceInProgress2) ? 4 : 2;
            $dirty |= i16;
        }
        if (i50 & 48 == 0) {
            i10 = restartGroup.changedInstance(onClick) ? 32 : 16;
            $dirty |= i10;
        } else {
            obj3 = onClick;
        }
        i17 = 128;
        if (i50 & 384 == 0) {
            i6 = restartGroup.changed(z) ? interactionSource2 : i17;
            $dirty |= i6;
        }
        companion = 1024;
        if (i50 & 3072 == 0) {
            i4 = restartGroup.changedInstance(label) ? i3 : companion;
            $dirty |= i4;
        } else {
            obj7 = label;
        }
        int i51 = 8192;
        if (i50 & 24576 == 0) {
            i14 = restartGroup.changed(labelTextStyle) ? i13 : i51;
            $dirty |= i14;
        } else {
            obj2 = labelTextStyle;
        }
        if (i50 & i52 == 0) {
            i11 = restartGroup.changed(labelColor) ? 131072 : 65536;
            $dirty |= i11;
        } else {
            l = labelColor;
        }
        if (i50 & i53 == 0) {
            i15 = restartGroup.changedInstance(trailingIcon) ? 1048576 : 524288;
            $dirty |= i15;
        } else {
            obj10 = trailingIcon;
        }
        if (i50 & i55 == 0) {
            i8 = restartGroup.changedInstance(shape) ? 8388608 : 4194304;
            $dirty |= i8;
        } else {
            obj8 = shape;
        }
        if (i50 & i56 == 0) {
            i18 = restartGroup.changed(colors) ? 67108864 : 33554432;
            $dirty |= i18;
        } else {
            obj11 = colors;
        }
        if ($changed1 & i57 == 0) {
            i9 = restartGroup.changed(obj5) ? 536870912 : 268435456;
            $dirty |= i9;
        }
        if (i12 & 6 == 0) {
            i4 = restartGroup.changed(obj12) ? 4 : 2;
            $dirty1 |= i4;
        }
        if (i12 & 48 == 0) {
            i = restartGroup.changed(minHeight) ? 32 : 16;
            $dirty1 |= i;
        } else {
            obj = minHeight;
        }
        if (i12 & 384 == 0) {
            if (restartGroup.changed(paddingValues)) {
            } else {
                interactionSource2 = i17;
            }
            $dirty1 |= interactionSource2;
        } else {
            f = paddingValues;
        }
        if (i12 & 3072 == 0) {
            if (restartGroup.changed(interactionSource)) {
            } else {
                i3 = companion;
            }
            $dirty1 |= i3;
        } else {
            obj4 = interactionSource;
        }
        if (i12 & 24576 == 0) {
            if (restartGroup.changed(obj6)) {
            } else {
                i13 = i51;
            }
            $dirty1 |= i13;
        }
        rememberedValue = $dirty1;
        if ($dirty13 &= $dirty == 306783378 && rememberedValue & 9363 == 9362) {
            if (rememberedValue & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1400504719, $dirty, rememberedValue, "androidx.compose.material3.Chip (Chip.kt:1963)");
                    }
                    restartGroup.startReplaceGroup(1985614987);
                    ComposerKt.sourceInformation(restartGroup, "1965@96816L39");
                    if (obj6 == null) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1985615638, "CC(remember):Chip.kt#9igjgp");
                        str2 = 0;
                        i7 = restartGroup;
                        interactionSource2 = 0;
                        $dirty12 = rememberedValue;
                        rememberedValue = i7.rememberedValue();
                        i3 = 0;
                        obj43 = $dirty;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i39 = 0;
                            i7.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheChipKt$Chip$interactionSource$1 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        $dirty12 = rememberedValue;
                        obj43 = $dirty;
                        $i$a$CacheChipKt$Chip$interactionSource$1 = obj6;
                    }
                    restartGroup.endReplaceGroup();
                    MutableInteractionSource mutableInteractionSource = $i$a$CacheChipKt$Chip$interactionSource$1;
                    int i44 = 1;
                    restartGroup.startReplaceGroup(1985624506);
                    ComposerKt.sourceInformation(restartGroup, "1972@97093L43");
                    if (obj12 == null) {
                    } else {
                        shadowElevation$material3_release = obj12.shadowElevation$material3_release(z, (InteractionSource)mutableInteractionSource, restartGroup, i41 |= i47);
                    }
                    restartGroup.endReplaceGroup();
                    if (shadowElevation$material3_release != null) {
                        i13 = unbox-impl;
                    } else {
                        i5 = 0;
                        i13 = shadowElevation$material3_release;
                    }
                    i7 = trailingIcon;
                    $dirty3 = obj43;
                    i12 = restartGroup;
                    ChipKt.Chip.2 anon = new ChipKt.Chip.2(obj7, obj2, l, i44, i7, shape, obj5, z, paddingValues, interactionSource);
                    SurfaceKt.Surface-o_FOJdg(onClick, SemanticsModifierKt.semantics$default(traceInProgress2, false, (Function1)ChipKt.Chip.1.INSTANCE, i44, 0), enabled, colors, obj5.containerColor-vNxB06k$material3_release(z), i7, 0, obj5, 0, i13, obj, mutableInteractionSource, (Function2)ComposableLambdaKt.rememberComposableLambda(-1985962652, i44, anon, i12, 54), i12, i27 |= i34);
                    composer = i12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    i2 = rememberedValue;
                    composer = restartGroup;
                    $dirty3 = $dirty;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = i38;
            $dirty3 = new ChipKt.Chip.3(modifier, onClick, enabled, label, labelTextStyle, labelColor, i7, trailingIcon, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, $composer, $changed1, obj45);
            endRestartGroup.updateScope((Function2)$dirty3);
        } else {
            $dirty2 = $dirty3;
        }
    }

    private static final void ChipContent-fe0OD_I(Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, long labelColor, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, long leadingIconColor, long trailingIconColor, float minHeight, PaddingValues paddingValues, Composer $composer, int $changed) {
        Object obj;
        boolean traceInProgress;
        Object endRestartGroup;
        boolean traceInProgress2;
        int $dirty2;
        Object obj6;
        int rememberComposableLambda;
        float f;
        int i5;
        int i11;
        long l2;
        long function2;
        int i8;
        Object obj5;
        int i7;
        Object obj8;
        int i9;
        Object obj9;
        int i4;
        long l4;
        int i3;
        long l6;
        Object obj7;
        Object $composer2;
        int i2;
        int i10;
        int anon;
        int $dirty;
        int i6;
        int i;
        PaddingValues paddingValues2;
        Object obj2;
        Object obj4;
        Object obj3;
        long l;
        long l5;
        long l3;
        Composer obj40;
        final Object obj11 = labelTextStyle;
        final int i26 = obj41;
        $composer2 = obj40.startRestartGroup(-782878228);
        ComposerKt.sourceInformation($composer2, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)2055@99907L3519,2052@99781L3645:Chip.kt#uh7d8r");
        if (i26 & 6 == 0) {
            i5 = $composer2.changedInstance(label) ? 4 : 2;
            $dirty2 |= i5;
        } else {
            obj6 = label;
        }
        if (i26 & 48 == 0) {
            i11 = $composer2.changed(obj11) ? 32 : 16;
            $dirty2 |= i11;
        }
        if (i26 & 384 == 0) {
            i8 = $composer2.changed(labelColor) ? 256 : 128;
            $dirty2 |= i8;
        } else {
            l2 = labelColor;
        }
        if (i26 & 3072 == 0) {
            i7 = $composer2.changedInstance(avatar) ? 2048 : 1024;
            $dirty2 |= i7;
        } else {
            obj5 = avatar;
        }
        if (i26 & 24576 == 0) {
            i9 = $composer2.changedInstance(trailingIcon) ? 16384 : 8192;
            $dirty2 |= i9;
        } else {
            obj8 = trailingIcon;
        }
        if (i20 &= i26 == 0) {
            i4 = $composer2.changedInstance(leadingIconColor) ? 131072 : 65536;
            $dirty2 |= i4;
        } else {
            obj9 = leadingIconColor;
        }
        if (i22 &= i26 == 0) {
            i3 = $composer2.changed(trailingIconColor) ? 1048576 : 524288;
            $dirty2 |= i3;
        } else {
            l4 = trailingIconColor;
        }
        if (i24 &= i26 == 0) {
            i2 = $composer2.changed(paddingValues) ? 8388608 : 4194304;
            $dirty2 |= i2;
        } else {
            l6 = paddingValues;
        }
        if (i26 & i27 == 0) {
            i10 = $composer2.changed($changed) ? 67108864 : 33554432;
            $dirty2 |= i10;
        } else {
            f = $changed;
        }
        if (i26 & i28 == 0) {
            i6 = $composer2.changed(obj39) ? 536870912 : 268435456;
            $dirty2 |= i6;
        } else {
            obj = obj39;
        }
        if ($dirty2 & i == 306783378) {
            if (!$composer2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-782878228, $dirty2, -1, "androidx.compose.material3.ChipContent (Chip.kt:2051)");
                }
                ProvidedValue[] arr = new ProvidedValue[2];
                int i16 = 1;
                arr[i16] = TextKt.getLocalTextStyle().provides(obj11);
                anon = new ChipKt.ChipContent.1($changed, obj39, obj8, obj5, obj9, l4, obj23, label, l6, obj26);
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
            endRestartGroup = new ChipKt.ChipContent.2(label, obj11, l2, f, avatar, trailingIcon, leadingIconColor, trailingIconColor, obj9, paddingValues, obj11, $changed, obj39, i26);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty = $dirty2;
            obj40 = $composer2;
        }
    }

    public static final void ElevatedAssistChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj6;
        Object obj12;
        int $dirty15;
        int skipping;
        int $dirty2;
        int defaultsInvalid;
        Object modifier2;
        int $dirty4;
        int $dirty;
        Object endRestartGroup;
        Object elevatedAssistChipElevation-aqJV_2Y;
        Object obj10;
        Object i14;
        boolean traceInProgress;
        int $dirty13;
        boolean traceInProgress2;
        int i;
        int i17;
        Object obj7;
        int elevatedAssistChipColors;
        int i11;
        int shape3;
        Object $dirty6;
        boolean z3;
        Object obj2;
        Object obj4;
        Object obj13;
        Object obj9;
        int i16;
        Shape shape2;
        int i21;
        Object $composer2;
        boolean z2;
        androidx.compose.material3.ChipElevation chipElevation;
        int i18;
        int i10;
        int i6;
        Object obj;
        int i22;
        int i3;
        Object obj8;
        Object obj5;
        int $dirty5;
        Object leadingIcon2;
        int i24;
        Modifier i19;
        int i20;
        int i9;
        int changed2;
        Object i2;
        int changed;
        int changed3;
        int $dirty12;
        TextStyle $dirty14;
        int i7;
        int labelColor-vNxB06k$material3_release;
        int i13;
        int i5;
        int $dirty16;
        int $dirty1;
        Object enabled2;
        boolean z;
        Object colors2;
        Object obj11;
        Object $dirty3;
        Object obj3;
        int i12;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        int i4;
        Composer composer;
        int i8;
        int i23;
        Object obj36;
        final int i75 = $changed;
        final int i76 = i15;
        Composer restartGroup = $composer.startRestartGroup(1594789934);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)289@14186L5,290@14237L26,291@14316L29,300@14613L5,295@14445L541:Chip.kt#uh7d8r");
        $dirty4 = $changed;
        if (i76 & 1 != 0) {
            $dirty4 |= 6;
            obj = onClick;
        } else {
            if (i75 & 6 == 0) {
                i = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty4 |= i;
            } else {
                obj = onClick;
            }
        }
        if (i76 & 2 != 0) {
            $dirty4 |= 48;
            obj8 = label;
        } else {
            if (i75 & 48 == 0) {
                i17 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty4 |= i17;
            } else {
                obj8 = label;
            }
        }
        i11 = i76 & 4;
        if (i11 != 0) {
            $dirty4 |= 384;
            obj13 = modifier;
        } else {
            if (i75 & 384 == 0) {
                i16 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty4 |= i16;
            } else {
                obj13 = modifier;
            }
        }
        i21 = i76 & 8;
        if (i21 != 0) {
            $dirty4 |= 3072;
            z2 = enabled;
        } else {
            if (i75 & 3072 == 0) {
                i18 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty4 |= i18;
            } else {
                z2 = enabled;
            }
        }
        i6 = i76 & 16;
        if (i6 != 0) {
            $dirty4 |= 24576;
            obj5 = leadingIcon;
        } else {
            if (i75 & 24576 == 0) {
                i24 = restartGroup.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty4 |= i24;
            } else {
                obj5 = leadingIcon;
            }
        }
        i19 = i76 & 32;
        i20 = 196608;
        if (i19 != 0) {
            $dirty4 |= i20;
            $dirty6 = trailingIcon;
        } else {
            if (i75 & i20 == 0) {
                i20 = restartGroup.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty4 |= i20;
            } else {
                $dirty6 = trailingIcon;
            }
        }
        if (i75 & i78 == 0) {
            if (i76 & 64 == 0) {
                changed2 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj6 = shape;
            }
            $dirty4 |= changed2;
        } else {
            obj6 = shape;
        }
        if (i75 & i79 == 0) {
            if (i76 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj2 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj2 = colors;
        }
        if (i75 & i81 == 0) {
            if (i76 & 256 == 0) {
                changed3 = restartGroup.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj12 = elevation;
            }
            $dirty4 |= changed3;
        } else {
            obj12 = elevation;
        }
        $dirty12 = i31;
        int $dirty17 = i76 & 512;
        int i82 = 805306368;
        if ($dirty17 != 0) {
            $dirty4 |= i82;
            labelColor-vNxB06k$material3_release = $dirty17;
            obj10 = border;
        } else {
            if (i75 & i82 == 0) {
                labelColor-vNxB06k$material3_release = $dirty17;
                i13 = restartGroup.changed(border) ? 536870912 : 268435456;
                $dirty4 |= i13;
            } else {
                labelColor-vNxB06k$material3_release = $dirty17;
                obj10 = border;
            }
        }
        i14 = i76 & 1024;
        if (i14 != 0) {
            $dirty12 |= 6;
            i5 = i14;
        } else {
            if ($changed1 & 6 == 0) {
                i5 = i14;
                $dirty16 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty12 |= $dirty16;
            } else {
                i5 = i14;
                i14 = interactionSource;
            }
        }
        traceInProgress = $dirty12;
        final int obj45 = $dirty4;
        if ($dirty4 & $dirty14 == 306783378 && traceInProgress & 3 == 2) {
            if (traceInProgress & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i80 = -234881025;
                    int i28 = -29360129;
                    i7 = -3670017;
                    int i85 = traceInProgress;
                    $dirty13 = 6;
                    if (i75 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj13;
                            }
                            z = i21 != 0 ? i11 : z2;
                            if (i6 != 0) {
                                obj5 = i11;
                            }
                            i19 = i19 != 0 ? i11 : $dirty6;
                            if (i76 & 64 != 0) {
                                $dirty6 = obj45 & i7;
                                i7 = shape3;
                            } else {
                                i7 = shape;
                                $dirty6 = obj45;
                            }
                            if (i76 & 128 != 0) {
                                obj11 = elevatedAssistChipColors;
                                $dirty3 = $dirty6;
                            } else {
                                obj11 = obj2;
                                $dirty3 = $dirty6;
                            }
                            if (i76 & 256 != 0) {
                                obj36 = modifier2;
                                $dirty15 = i85;
                                i3 = obj3;
                                elevatedAssistChipElevation-aqJV_2Y = AssistChipDefaults.INSTANCE.elevatedAssistChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty3 &= i80;
                            } else {
                                obj36 = modifier2;
                                i3 = $dirty13;
                                $dirty15 = i85;
                                elevatedAssistChipElevation-aqJV_2Y = elevation;
                            }
                            $dirty13 = labelColor-vNxB06k$material3_release != 0 ? 0 : border;
                            if (i5 != 0) {
                                obj3 = elevatedAssistChipElevation-aqJV_2Y;
                                i12 = $dirty13;
                                i4 = elevatedAssistChipColors;
                                $dirty16 = obj5;
                                z2 = z;
                                obj2 = obj11;
                                $dirty = $dirty3;
                                leadingIcon2 = obj36;
                                enabled2 = i19;
                                colors2 = i7;
                            } else {
                                i4 = interactionSource;
                                obj3 = elevatedAssistChipElevation-aqJV_2Y;
                                i12 = $dirty13;
                                $dirty16 = obj5;
                                z2 = z;
                                obj2 = obj11;
                                $dirty = $dirty3;
                                leadingIcon2 = obj36;
                                enabled2 = i19;
                                colors2 = i7;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty2 = i76 & 64 != 0 ? obj45 & i7 : obj45;
                            if (i76 & 128 != 0) {
                                $dirty2 &= i28;
                            }
                            if (i76 & 256 != 0) {
                                $dirty2 &= i80;
                            }
                            colors2 = shape;
                            obj3 = elevation;
                            i12 = border;
                            i4 = interactionSource;
                            $dirty = $dirty2;
                            i3 = $dirty13;
                            enabled2 = $dirty6;
                            $dirty15 = i85;
                            $dirty16 = obj5;
                            leadingIcon2 = obj13;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1594789934, $dirty, $dirty15, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:295)");
                    }
                    $dirty3 = obj2;
                    i9 = z2;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i9, obj8, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i3), obj2.labelColor-vNxB06k$material3_release(z2), i5, $dirty16, enabled2, colors2, $dirty3, obj3, i12, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, i4, restartGroup, i39 | i57);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj7 = leadingIcon2;
                    z3 = i9;
                    obj4 = $dirty16;
                    obj9 = enabled2;
                    shape2 = colors2;
                    $composer2 = $dirty3;
                    chipElevation = obj3;
                    i10 = i12;
                    i22 = i4;
                    $dirty5 = $dirty;
                } else {
                    restartGroup.skipToGroupEnd();
                    shape2 = shape;
                    i10 = border;
                    i22 = interactionSource;
                    $dirty15 = traceInProgress;
                    obj7 = obj13;
                    composer = restartGroup;
                    obj9 = $dirty6;
                    $composer2 = obj2;
                    z3 = z2;
                    obj4 = obj5;
                    chipElevation = elevation;
                    $dirty5 = obj45;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty1 = $dirty15;
            obj36 = $dirty5;
            $dirty15 = new ChipKt.ElevatedAssistChip.1(onClick, label, obj7, z3, obj4, obj9, shape2, $composer2, chipElevation, i10, i22, i75, $changed1, i76);
            endRestartGroup.updateScope((Function2)$dirty15);
        } else {
            $dirty1 = $dirty15;
            obj36 = $dirty5;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void ElevatedAssistChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 leadingIcon, Function2 trailingIcon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj3;
        Object obj12;
        int $dirty16;
        int skipping;
        int $dirty2;
        int defaultsInvalid;
        Object modifier2;
        int $dirty5;
        int $dirty;
        Object endRestartGroup;
        Object elevatedAssistChipElevation-aqJV_2Y;
        Object obj9;
        Object i2;
        int border2;
        int $dirty15;
        int i5;
        int i3;
        Object obj6;
        int invalid$iv;
        boolean traceInProgress;
        State borderStroke$material3_release;
        int value;
        int i18;
        int shape3;
        Object $dirty4;
        boolean z;
        Object obj5;
        Object obj14;
        Object rememberedValue;
        Object obj11;
        int i4;
        Shape shape2;
        int i13;
        Object $composer2;
        boolean z3;
        androidx.compose.material3.ChipElevation chipElevation;
        Object $i$a$CacheChipKt$ElevatedAssistChip$2;
        int i17;
        int i10;
        int i19;
        Object obj4;
        Object obj10;
        int i14;
        Object obj13;
        Object obj8;
        int $dirty3;
        Object leadingIcon2;
        int i11;
        Modifier i22;
        int i21;
        int i6;
        int changed3;
        Object i9;
        int changed;
        int changed2;
        int $dirty12;
        TextStyle $dirty14;
        int i16;
        int labelColor-vNxB06k$material3_release;
        int i12;
        int i;
        int $dirty1;
        int $dirty13;
        Object enabled2;
        boolean z2;
        Object colors2;
        Object obj;
        Object $dirty6;
        Object obj2;
        int i8;
        float height-D9Ej5fM;
        PaddingValues assistChipPadding;
        Object obj7;
        Composer composer;
        int i7;
        int i20;
        Object obj36;
        final int i79 = $changed;
        final int i80 = i15;
        Composer restartGroup = $composer.startRestartGroup(1295844802);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)375@18287L5,376@18338L26,377@18417L29,379@18530L39,386@18746L5,381@18578L571:Chip.kt#uh7d8r");
        $dirty5 = $changed;
        if (i80 & 1 != 0) {
            $dirty5 |= 6;
            obj4 = onClick;
        } else {
            if (i79 & 6 == 0) {
                i5 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty5 |= i5;
            } else {
                obj4 = onClick;
            }
        }
        if (i80 & 2 != 0) {
            $dirty5 |= 48;
            obj13 = label;
        } else {
            if (i79 & 48 == 0) {
                i3 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty5 |= i3;
            } else {
                obj13 = label;
            }
        }
        i18 = i80 & 4;
        if (i18 != 0) {
            $dirty5 |= 384;
            rememberedValue = modifier;
        } else {
            if (i79 & 384 == 0) {
                i4 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty5 |= i4;
            } else {
                rememberedValue = modifier;
            }
        }
        i13 = i80 & 8;
        if (i13 != 0) {
            $dirty5 |= 3072;
            z3 = enabled;
        } else {
            if (i79 & 3072 == 0) {
                i17 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty5 |= i17;
            } else {
                z3 = enabled;
            }
        }
        i19 = i80 & 16;
        if (i19 != 0) {
            $dirty5 |= 24576;
            obj8 = leadingIcon;
        } else {
            if (i79 & 24576 == 0) {
                i11 = restartGroup.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty5 |= i11;
            } else {
                obj8 = leadingIcon;
            }
        }
        i22 = i80 & 32;
        i21 = 196608;
        if (i22 != 0) {
            $dirty5 |= i21;
            $dirty4 = trailingIcon;
        } else {
            if (i79 & i21 == 0) {
                i21 = restartGroup.changedInstance(trailingIcon) ? 131072 : 65536;
                $dirty5 |= i21;
            } else {
                $dirty4 = trailingIcon;
            }
        }
        if (i79 & i82 == 0) {
            if (i80 & 64 == 0) {
                changed3 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj3 = shape;
            }
            $dirty5 |= changed3;
        } else {
            obj3 = shape;
        }
        if (i79 & i83 == 0) {
            if (i80 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj5 = colors;
            }
            $dirty5 |= changed;
        } else {
            obj5 = colors;
        }
        if (i79 & i85 == 0) {
            if (i80 & 256 == 0) {
                changed2 = restartGroup.changed(elevation) ? 67108864 : 33554432;
            } else {
                obj12 = elevation;
            }
            $dirty5 |= changed2;
        } else {
            obj12 = elevation;
        }
        $dirty12 = i29;
        int $dirty17 = i80 & 512;
        int i86 = 805306368;
        if ($dirty17 != 0) {
            $dirty5 |= i86;
            labelColor-vNxB06k$material3_release = $dirty17;
            obj9 = border;
        } else {
            if (i79 & i86 == 0) {
                labelColor-vNxB06k$material3_release = $dirty17;
                i12 = restartGroup.changed(border) ? 536870912 : 268435456;
                $dirty5 |= i12;
            } else {
                labelColor-vNxB06k$material3_release = $dirty17;
                obj9 = border;
            }
        }
        i2 = i80 & 1024;
        if (i2 != 0) {
            $dirty12 |= 6;
            i = i2;
        } else {
            if ($changed1 & 6 == 0) {
                i = i2;
                $dirty1 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty12 |= $dirty1;
            } else {
                i = i2;
                i2 = interactionSource;
            }
        }
        border2 = $dirty12;
        final int obj45 = $dirty5;
        if ($dirty5 & $dirty14 == 306783378 && border2 & 3 == 2) {
            if (border2 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i84 = -234881025;
                    int i26 = -29360129;
                    i16 = -3670017;
                    int i89 = border2;
                    $dirty15 = 6;
                    if (i79 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = rememberedValue;
                            }
                            z2 = i13 != 0 ? i18 : z3;
                            if (i19 != 0) {
                                obj8 = i18;
                            }
                            i22 = i22 != 0 ? i18 : $dirty4;
                            if (i80 & 64 != 0) {
                                $dirty4 = obj45 & i16;
                                i16 = shape3;
                            } else {
                                i16 = shape;
                                $dirty4 = obj45;
                            }
                            if (i80 & 128 != 0) {
                                obj = invalid$iv;
                                $dirty6 = $dirty4;
                            } else {
                                obj = obj5;
                                $dirty6 = $dirty4;
                            }
                            if (i80 & 256 != 0) {
                                obj36 = modifier2;
                                $dirty16 = i89;
                                i14 = obj2;
                                elevatedAssistChipElevation-aqJV_2Y = AssistChipDefaults.INSTANCE.elevatedAssistChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty6 &= i84;
                            } else {
                                obj36 = modifier2;
                                i14 = $dirty15;
                                $dirty16 = i89;
                                elevatedAssistChipElevation-aqJV_2Y = elevation;
                            }
                            border2 = labelColor-vNxB06k$material3_release != 0 ? 0 : border;
                            if (i != 0) {
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 1551989929, "CC(remember):Chip.kt#9igjgp");
                                int i46 = 0;
                                $dirty4 = restartGroup;
                                int i67 = 0;
                                rememberedValue = $dirty4.rememberedValue();
                                i13 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i77 = 0;
                                    $dirty4.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheChipKt$ElevatedAssistChip$2 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj2 = elevatedAssistChipElevation-aqJV_2Y;
                                obj7 = invalid$iv;
                                $dirty1 = obj8;
                                z3 = z2;
                                obj5 = obj;
                                $dirty = $dirty6;
                                leadingIcon2 = obj36;
                                enabled2 = i22;
                                colors2 = i16;
                            } else {
                                obj7 = interactionSource;
                                obj2 = elevatedAssistChipElevation-aqJV_2Y;
                                $dirty1 = obj8;
                                z3 = z2;
                                obj5 = obj;
                                $dirty = $dirty6;
                                leadingIcon2 = obj36;
                                enabled2 = i22;
                                colors2 = i16;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty2 = i80 & 64 != 0 ? obj45 & i16 : obj45;
                            if (i80 & 128 != 0) {
                                $dirty2 &= i26;
                            }
                            if (i80 & 256 != 0) {
                                $dirty2 &= i84;
                            }
                            colors2 = shape;
                            obj2 = elevation;
                            obj7 = interactionSource;
                            $dirty = $dirty2;
                            i14 = $dirty15;
                            enabled2 = $dirty4;
                            $dirty16 = i89;
                            border2 = border;
                            $dirty1 = obj8;
                            leadingIcon2 = rememberedValue;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1295844802, $dirty, $dirty16, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:381)");
                    }
                    restartGroup.startReplaceGroup(1552007127);
                    ComposerKt.sourceInformation(restartGroup, "395@19068L21");
                    if (border2 == 0) {
                        borderStroke$material3_release = 0;
                    } else {
                        borderStroke$material3_release = border2.borderStroke$material3_release(z3, restartGroup, i43 |= $dirty4);
                    }
                    restartGroup.endReplaceGroup();
                    if (borderStroke$material3_release != null) {
                        value = borderStroke$material3_release.getValue();
                    } else {
                        value = 0;
                    }
                    $dirty6 = obj5;
                    i6 = z3;
                    ChipKt.Chip-nkUnTEs(leadingIcon2, onClick, i6, obj13, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i14), obj5.labelColor-vNxB06k$material3_release(z3), i, $dirty1, enabled2, colors2, $dirty6, obj2, value, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, obj7, restartGroup, i38 | i61);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i10 = border2;
                    obj6 = leadingIcon2;
                    z = i6;
                    obj14 = $dirty1;
                    obj11 = enabled2;
                    shape2 = colors2;
                    $composer2 = $dirty6;
                    chipElevation = obj2;
                    obj10 = obj7;
                    $dirty3 = $dirty;
                } else {
                    restartGroup.skipToGroupEnd();
                    shape2 = shape;
                    i10 = border;
                    obj10 = interactionSource;
                    $dirty16 = border2;
                    obj6 = rememberedValue;
                    composer = restartGroup;
                    obj11 = $dirty4;
                    $composer2 = obj5;
                    z = z3;
                    obj14 = obj8;
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
            $dirty16 = new ChipKt.ElevatedAssistChip.3(onClick, label, obj6, z, obj14, obj11, shape2, $composer2, chipElevation, i10, obj10, i79, $changed1, i80);
            endRestartGroup.updateScope((Function2)$dirty16);
        } else {
            $dirty13 = $dirty16;
            obj36 = $dirty3;
        }
    }

    public static final void ElevatedFilterChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i16) {
        Object obj2;
        Object obj13;
        int $dirty12;
        int skipping;
        int defaultsInvalid;
        Object modifier2;
        int $dirty6;
        int $dirty2;
        int $dirty5;
        ScopeUpdateScope endRestartGroup;
        Object elevatedFilterChipElevation-aqJV_2Y;
        int i13;
        Object obj3;
        Object i3;
        int traceInProgress2;
        int $dirty16;
        int border2;
        int border3;
        int i5;
        int i14;
        int i20;
        int i7;
        int shape2;
        int elevatedFilterChipColors;
        boolean traceInProgress;
        boolean $dirty;
        Object obj15;
        Object obj;
        boolean z2;
        Object obj18;
        Object obj5;
        Object obj6;
        Object obj16;
        Object $composer2;
        Object obj14;
        Object obj7;
        int i8;
        Object obj17;
        int i2;
        boolean z;
        int obj12;
        int i26;
        Object obj4;
        int obj10;
        Object obj9;
        int i21;
        int i18;
        Object i10;
        int i12;
        int i23;
        int $dirty13;
        int $dirty14;
        Object obj8;
        int i25;
        int i24;
        int $dirty1;
        int $dirty15;
        int i9;
        int i22;
        int value;
        int changed2;
        int i15;
        int changed;
        int changed3;
        int i6;
        int i;
        boolean colors2;
        Object obj11;
        androidx.compose.material3.SelectableChipColors $dirty4;
        int $dirty3;
        androidx.compose.material3.SelectableChipElevation selectableChipElevation;
        int i19;
        float height-D9Ej5fM;
        PaddingValues filterChipPadding;
        int i11;
        Composer composer;
        int i4;
        int i17;
        ScopeUpdateScope scopeUpdateScope;
        Object obj39;
        final int i80 = $changed;
        final int i81 = i16;
        Composer restartGroup = $composer.startRestartGroup(-106647389);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)546@26622L5,547@26683L26,548@26772L29,558@27108L5,552@26901L554:Chip.kt#uh7d8r");
        $dirty2 = $changed;
        if (i81 & 1 != 0) {
            $dirty2 |= 6;
            z = selected;
        } else {
            if (i80 & 6 == 0) {
                i5 = restartGroup.changed(selected) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                z = selected;
            }
        }
        if (i81 & 2 != 0) {
            $dirty2 |= 48;
            obj4 = onClick;
        } else {
            if (i80 & 48 == 0) {
                i14 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i14;
            } else {
                obj4 = onClick;
            }
        }
        if (i81 & 4 != 0) {
            $dirty2 |= 384;
            obj9 = label;
        } else {
            if (i80 & 384 == 0) {
                i20 = restartGroup.changedInstance(label) ? 256 : 128;
                $dirty2 |= i20;
            } else {
                obj9 = label;
            }
        }
        i7 = i81 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            obj14 = modifier;
        } else {
            if (i80 & 3072 == 0) {
                i8 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i8;
            } else {
                obj14 = modifier;
            }
        }
        i2 = i81 & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            $dirty = enabled;
        } else {
            if (i80 & 24576 == 0) {
                i21 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty2 |= i21;
            } else {
                $dirty = enabled;
            }
        }
        i10 = i81 & 32;
        i12 = 196608;
        if (i10 != 0) {
            $dirty2 |= i12;
            obj = leadingIcon;
        } else {
            if (i80 & i12 == 0) {
                i25 = restartGroup.changedInstance(leadingIcon) ? 131072 : 65536;
                $dirty2 |= i25;
            } else {
                obj = leadingIcon;
            }
        }
        i24 = i81 & 64;
        $dirty1 = 1572864;
        if (i24 != 0) {
            $dirty2 |= $dirty1;
            obj18 = trailingIcon;
        } else {
            if (i80 & $dirty1 == 0) {
                i9 = restartGroup.changedInstance(trailingIcon) ? 1048576 : 524288;
                $dirty2 |= i9;
            } else {
                obj18 = trailingIcon;
            }
        }
        i22 = 12582912;
        if (i80 & i22 == 0) {
            if (i81 & 128 == 0) {
                changed2 = restartGroup.changed(shape) ? 8388608 : 4194304;
            } else {
                obj6 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj6 = shape;
        }
        if (i80 & i84 == 0) {
            if (i81 & 256 == 0) {
                changed = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj2 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj2 = colors;
        }
        if (i80 & i85 == 0) {
            if (i81 & 512 == 0) {
                changed3 = restartGroup.changed(elevation) ? 536870912 : 268435456;
            } else {
                obj13 = elevation;
            }
            $dirty2 |= changed3;
        } else {
            obj13 = elevation;
        }
        int i86 = i33;
        int $dirty17 = i81 & 1024;
        if ($dirty17 != 0) {
            $dirty13 = i86 | 6;
            i = $dirty17;
            obj3 = border;
        } else {
        }
        i3 = i81 & 2048;
        if (i3 != 0) {
            $dirty13 |= 48;
            i6 = i3;
        } else {
            if ($changed1 & 48 == 0) {
                i6 = i3;
                $dirty1 = restartGroup.changed(interactionSource) ? 32 : 16;
                $dirty13 |= $dirty1;
            } else {
                i6 = i3;
                i3 = interactionSource;
            }
        }
        traceInProgress2 = $dirty13;
        final int obj48 = $dirty2;
        if ($dirty2 & $dirty14 == 306783378 && traceInProgress2 & 19 == 18) {
            if (traceInProgress2 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i31 = -234881025;
                    int i82 = -29360129;
                    int i83 = traceInProgress2;
                    $dirty16 = 6;
                    if (i80 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj14;
                            }
                            value = i2 != 0 ? i7 : $dirty;
                            i10 = i10 != 0 ? i7 : obj;
                            i24 = i24 != 0 ? i7 : obj18;
                            if (i81 & 128 != 0) {
                                $dirty = obj48 & i82;
                                obj8 = shape2;
                            } else {
                                $dirty = obj48;
                                obj8 = obj6;
                            }
                            if (i81 & 256 != 0) {
                                obj11 = elevatedFilterChipColors;
                                $dirty3 = $dirty;
                            } else {
                                obj11 = colors;
                                $dirty3 = $dirty;
                            }
                            if (i81 & 512 != 0) {
                                obj39 = modifier2;
                                $dirty12 = i83;
                                i26 = selectableChipElevation;
                                elevatedFilterChipElevation-aqJV_2Y = FilterChipDefaults.INSTANCE.elevatedFilterChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty3 &= $dirty16;
                            } else {
                                obj39 = modifier2;
                                i26 = $dirty16;
                                $dirty12 = i83;
                                elevatedFilterChipElevation-aqJV_2Y = elevation;
                            }
                            border2 = i != 0 ? 0 : border;
                            if (i6 != 0) {
                                selectableChipElevation = elevatedFilterChipElevation-aqJV_2Y;
                                i19 = border2;
                                i11 = elevatedFilterChipColors;
                                i15 = i10;
                                i = i24;
                                $dirty1 = value;
                                $dirty5 = $dirty3;
                                border3 = -106647389;
                                $dirty4 = obj11;
                                colors2 = obj8;
                                $dirty14 = obj39;
                            } else {
                                i11 = interactionSource;
                                selectableChipElevation = elevatedFilterChipElevation-aqJV_2Y;
                                i19 = border2;
                                i15 = i10;
                                i = i24;
                                $dirty1 = value;
                                $dirty5 = $dirty3;
                                border3 = -106647389;
                                $dirty4 = obj11;
                                colors2 = obj8;
                                $dirty14 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty6 = i81 & 128 != 0 ? obj48 & i82 : obj48;
                            if (i81 & 256 != 0) {
                                $dirty6 &= i31;
                            }
                            if (i81 & 512 != 0) {
                                $dirty6 &= i13;
                            }
                            $dirty4 = colors;
                            selectableChipElevation = elevation;
                            i19 = border;
                            i11 = interactionSource;
                            $dirty5 = $dirty6;
                            i26 = $dirty16;
                            i15 = obj;
                            i = obj18;
                            colors2 = obj6;
                            $dirty14 = obj14;
                            $dirty12 = i83;
                            border3 = -106647389;
                            $dirty1 = $dirty;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(border3, $dirty5, $dirty12, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:552)");
                    }
                    ChipKt.SelectableChip-u0RnIRE(selected, $dirty14, obj4, $dirty1, obj9, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), restartGroup, i26), i15, 0, i, colors2, $dirty4, selectableChipElevation, i19, FilterChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.FilterChipPadding, i11, restartGroup, i42 | i62, i47 | i7);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i18 = $dirty5;
                    obj15 = $dirty14;
                    z2 = $dirty1;
                    obj5 = i15;
                    obj16 = i;
                    $composer2 = colors2;
                    obj7 = $dirty4;
                    obj17 = selectableChipElevation;
                    obj12 = i19;
                    obj10 = i11;
                } else {
                    restartGroup.skipToGroupEnd();
                    obj17 = elevation;
                    obj12 = border;
                    obj10 = interactionSource;
                    i18 = obj48;
                    $dirty12 = traceInProgress2;
                    composer = restartGroup;
                    $composer2 = obj6;
                    obj16 = obj18;
                    obj5 = obj;
                    z2 = $dirty;
                    obj15 = obj14;
                    obj7 = colors;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty15 = $dirty12;
            $dirty12 = new ChipKt.ElevatedFilterChip.1(selected, onClick, label, obj15, z2, obj5, obj16, $composer2, obj7, obj17, obj12, obj10, i80, $changed1, i81);
            endRestartGroup.updateScope((Function2)$dirty12);
        } else {
            $dirty15 = $dirty12;
        }
    }

    public static final void ElevatedSuggestionChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> icon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        boolean traceInProgress;
        int i6;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        int $dirty;
        int $dirty3;
        int elevatedSuggestionChipElevation-aqJV_2Y;
        int border2;
        int i8;
        int i18;
        Object obj13;
        Object obj8;
        int i7;
        boolean traceInProgress2;
        Object obj5;
        int shape2;
        int elevatedSuggestionChipColors;
        int i14;
        boolean z;
        int $dirty5;
        boolean z2;
        Object obj4;
        int i17;
        Object obj3;
        int i4;
        Object obj9;
        Object obj12;
        Object $composer2;
        int i19;
        Object obj2;
        int i11;
        int changed2;
        Object obj11;
        int i;
        Object obj6;
        Object obj7;
        int changed;
        Object elevation2;
        int changed3;
        int value;
        int i12;
        int labelColor-vNxB06k$material3_release;
        int i3;
        int $dirty4;
        Object i16;
        int i15;
        Object colors2;
        Object obj10;
        Object obj;
        Object $dirty2;
        int $dirty6;
        int i10;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        int i5;
        Composer composer;
        int i9;
        int i2;
        Object obj34;
        int obj42;
        final int i73 = $changed;
        final int i74 = i13;
        Composer restartGroup = $composer.startRestartGroup(-818834969);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)897@43055L5,898@43110L30,899@43197L33,908@43503L5,903@43331L538:Chip.kt#uh7d8r");
        $dirty = $changed;
        if (i74 & 1 != 0) {
            $dirty |= 6;
            obj7 = onClick;
        } else {
            if (i73 & 6 == 0) {
                i8 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj7 = onClick;
            }
        }
        if (i74 & 2 != 0) {
            $dirty |= 48;
            obj6 = label;
        } else {
            if (i73 & 48 == 0) {
                i18 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty |= i18;
            } else {
                obj6 = label;
            }
        }
        int i38 = i74 & 4;
        if (i38 != 0) {
            $dirty |= 384;
            obj5 = modifier;
        } else {
            if (i73 & 384 == 0) {
                i14 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i14;
            } else {
                obj5 = modifier;
            }
        }
        $dirty5 = i74 & 8;
        if ($dirty5 != 0) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i73 & 3072 == 0) {
                i17 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i17;
            } else {
                z2 = enabled;
            }
        }
        i4 = i74 & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            obj9 = icon;
        } else {
            if (i73 & 24576 == 0) {
                i19 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty |= i19;
            } else {
                obj9 = icon;
            }
        }
        if (i67 &= i73 == 0) {
            if (i74 & 32 == 0) {
                changed2 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj2 = shape;
            }
            $dirty |= changed2;
        } else {
            obj2 = shape;
        }
        if (i70 &= i73 == 0) {
            if (i74 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj11 = colors;
            }
            $dirty |= changed;
        } else {
            obj11 = colors;
        }
        int i75 = 12582912;
        if (i73 & i75 == 0) {
            obj42 = i75;
            if (i74 & 128 == 0) {
                changed3 = restartGroup.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty |= changed3;
        } else {
            obj42 = i75;
            elevation2 = elevation;
        }
        int i21 = i74 & 256;
        int i77 = 100663296;
        if (i21 != 0) {
            $dirty |= i77;
            value = i38;
            obj13 = border;
        } else {
            if (i73 & i77 == 0) {
                value = i38;
                i12 = restartGroup.changed(border) ? 67108864 : 33554432;
                $dirty |= i12;
            } else {
                value = i38;
                obj13 = border;
            }
        }
        int i39 = i74 & 512;
        int i79 = 805306368;
        if (i39 != 0) {
            $dirty |= i79;
            labelColor-vNxB06k$material3_release = i39;
            obj8 = interactionSource;
        } else {
            if (i73 & i79 == 0) {
                labelColor-vNxB06k$material3_release = i39;
                i3 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty |= i3;
            } else {
                labelColor-vNxB06k$material3_release = i39;
                obj8 = interactionSource;
            }
        }
        $dirty4 = $dirty;
        if ($dirty & i81 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i82 = -29360129;
                int i37 = -3670017;
                int i83 = -458753;
                i7 = 6;
                if (i73 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (value != null) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj5;
                        }
                        value = $dirty5 != 0 ? obj5 : z2;
                        obj = i4 != 0 ? obj5 : obj9;
                        if (i74 & 32 != 0) {
                            $dirty5 = $dirty4 & i83;
                            $dirty4 = shape2;
                        } else {
                            $dirty5 = $dirty4;
                            $dirty4 = obj2;
                        }
                        if (i74 & 64 != 0) {
                            obj10 = elevatedSuggestionChipColors;
                            $dirty6 = $dirty5;
                        } else {
                            obj10 = obj11;
                            $dirty6 = $dirty5;
                        }
                        if (i74 & 128 != 0) {
                            obj34 = modifier3;
                            modifier2 = i10;
                            $dirty6 &= i82;
                            elevation2 = elevatedSuggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier3;
                            modifier2 = i7;
                        }
                        border2 = i21 != 0 ? 0 : border;
                        if (labelColor-vNxB06k$material3_release != 0) {
                            obj5 = obj34;
                            i10 = border2;
                            i5 = i7;
                            obj11 = obj10;
                            i16 = obj;
                            $dirty3 = $dirty6;
                            $dirty2 = elevation2;
                            elevation2 = value;
                            colors2 = $dirty4;
                        } else {
                            obj5 = obj34;
                            i5 = interactionSource;
                            i10 = border2;
                            obj11 = obj10;
                            i16 = obj;
                            $dirty3 = $dirty6;
                            $dirty2 = elevation2;
                            elevation2 = value;
                            colors2 = $dirty4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i74 & 32 != 0) {
                            $dirty4 = i6;
                        }
                        if (i74 & 64 != 0) {
                            $dirty4 &= i37;
                        }
                        if (i74 & 128 != 0) {
                            i10 = border;
                            i5 = interactionSource;
                            $dirty3 = i24;
                            modifier2 = i7;
                            i16 = obj9;
                            colors2 = obj2;
                            $dirty2 = elevation2;
                            elevation2 = z2;
                        } else {
                            i10 = border;
                            i5 = interactionSource;
                            modifier2 = i7;
                            i16 = obj9;
                            colors2 = obj2;
                            $dirty2 = elevation2;
                            $dirty3 = $dirty4;
                            elevation2 = z2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-818834969, $dirty3, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:903)");
                }
                obj = obj11;
                obj6 = obj5;
                ChipKt.Chip-nkUnTEs(obj6, obj7, elevation2, obj6, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), restartGroup, modifier2), obj11.labelColor-vNxB06k$material3_release(elevation2), $dirty4, i16, 0, colors2, obj, $dirty2, i10, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, i5, restartGroup, i32 | i51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty4 = $dirty3;
                obj5 = obj6;
                z = elevation2;
                obj4 = i16;
                obj3 = colors2;
                obj12 = obj;
                $composer2 = $dirty2;
                i11 = i10;
                i = i5;
            } else {
                restartGroup.skipToGroupEnd();
                z = z2;
                obj4 = obj9;
                composer = restartGroup;
                obj3 = obj2;
                obj12 = obj11;
                $composer2 = elevation2;
                i11 = border;
                i = obj8;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ChipKt.ElevatedSuggestionChip.1(onClick, label, obj5, z, obj4, obj3, obj12, $composer2, i11, i, i73, i74);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void ElevatedSuggestionChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 icon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        int traceInProgress;
        int i3;
        int modifier2;
        State borderStroke$material3_release;
        int value;
        int defaultsInvalid;
        Object modifier3;
        int $dirty;
        int $dirty5;
        int elevatedSuggestionChipElevation-aqJV_2Y;
        int i6;
        int i2;
        Object obj3;
        Object interactionSource2;
        int i10;
        Object obj4;
        int shape2;
        int elevatedSuggestionChipColors;
        int i14;
        int $dirty6;
        boolean traceInProgress2;
        int labelTextFont;
        boolean z;
        boolean rememberedValue;
        Object obj9;
        int i15;
        int i16;
        Object obj10;
        Object $i$a$CacheChipKt$ElevatedSuggestionChip$2;
        Object obj8;
        Object $composer2;
        int i5;
        Object obj11;
        int i;
        int changed2;
        Object obj12;
        Object obj13;
        Object obj7;
        Object obj6;
        int changed;
        Object elevation2;
        int changed3;
        int value2;
        int i7;
        int labelColor-vNxB06k$material3_release;
        int i4;
        int $dirty4;
        Object i12;
        int i8;
        Object colors2;
        Object obj;
        Object obj2;
        Object $dirty3;
        int $dirty2;
        int i11;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        Object obj5;
        Composer composer;
        int i17;
        int i9;
        Object obj34;
        int obj42;
        final int i78 = $changed;
        final int i79 = i13;
        Composer restartGroup = $composer.startRestartGroup(1668751803);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)980@46960L5,981@47015L30,982@47102L33,984@47219L39,991@47440L5,986@47268L568:Chip.kt#uh7d8r");
        $dirty = $changed;
        if (i79 & 1 != 0) {
            $dirty |= 6;
            obj6 = onClick;
        } else {
            if (i78 & 6 == 0) {
                i6 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i6;
            } else {
                obj6 = onClick;
            }
        }
        if (i79 & 2 != 0) {
            $dirty |= 48;
            obj7 = label;
        } else {
            if (i78 & 48 == 0) {
                i2 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty |= i2;
            } else {
                obj7 = label;
            }
        }
        int i40 = i79 & 4;
        if (i40 != 0) {
            $dirty |= 384;
            obj4 = modifier;
        } else {
            if (i78 & 384 == 0) {
                i14 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i14;
            } else {
                obj4 = modifier;
            }
        }
        $dirty6 = i79 & 8;
        if ($dirty6 != 0) {
            $dirty |= 3072;
            rememberedValue = enabled;
        } else {
            if (i78 & 3072 == 0) {
                i15 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i15;
            } else {
                rememberedValue = enabled;
            }
        }
        i16 = i79 & 16;
        if (i16 != 0) {
            $dirty |= 24576;
            $i$a$CacheChipKt$ElevatedSuggestionChip$2 = icon;
        } else {
            if (i78 & 24576 == 0) {
                i5 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                $i$a$CacheChipKt$ElevatedSuggestionChip$2 = icon;
            }
        }
        if (i72 &= i78 == 0) {
            if (i79 & 32 == 0) {
                changed2 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj11 = shape;
            }
            $dirty |= changed2;
        } else {
            obj11 = shape;
        }
        if (i75 &= i78 == 0) {
            if (i79 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj12 = colors;
            }
            $dirty |= changed;
        } else {
            obj12 = colors;
        }
        int i80 = 12582912;
        if (i78 & i80 == 0) {
            obj42 = i80;
            if (i79 & 128 == 0) {
                changed3 = restartGroup.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty |= changed3;
        } else {
            obj42 = i80;
            elevation2 = elevation;
        }
        int i19 = i79 & 256;
        int i82 = 100663296;
        if (i19 != 0) {
            $dirty |= i82;
            value2 = i40;
            obj3 = border;
        } else {
            if (i78 & i82 == 0) {
                value2 = i40;
                i7 = restartGroup.changed(border) ? 67108864 : 33554432;
                $dirty |= i7;
            } else {
                value2 = i40;
                obj3 = border;
            }
        }
        int i41 = i79 & 512;
        int i84 = 805306368;
        if (i41 != 0) {
            $dirty |= i84;
            labelColor-vNxB06k$material3_release = i41;
            interactionSource2 = interactionSource;
        } else {
            if (i78 & i84 == 0) {
                labelColor-vNxB06k$material3_release = i41;
                i4 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty |= i4;
            } else {
                labelColor-vNxB06k$material3_release = i41;
                interactionSource2 = interactionSource;
            }
        }
        $dirty4 = $dirty;
        if ($dirty & i86 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i87 = -29360129;
                int i38 = -3670017;
                int i88 = -458753;
                i10 = 6;
                if (i78 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (value2 != null) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj4;
                        }
                        value2 = $dirty6 != 0 ? obj4 : rememberedValue;
                        obj2 = i16 != 0 ? obj4 : $i$a$CacheChipKt$ElevatedSuggestionChip$2;
                        if (i79 & 32 != 0) {
                            $dirty6 = $dirty4 & i88;
                            $dirty4 = shape2;
                        } else {
                            $dirty6 = $dirty4;
                            $dirty4 = obj11;
                        }
                        if (i79 & 64 != 0) {
                            obj = elevatedSuggestionChipColors;
                            $dirty2 = $dirty6;
                        } else {
                            obj = obj12;
                            $dirty2 = $dirty6;
                        }
                        if (i79 & 128 != 0) {
                            obj34 = modifier3;
                            modifier2 = i11;
                            $dirty2 &= i87;
                            elevation2 = elevatedSuggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier3;
                            modifier2 = i10;
                        }
                        $dirty5 = i19 != 0 ? 0 : border;
                        if (labelColor-vNxB06k$material3_release != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2121795492, "CC(remember):Chip.kt#9igjgp");
                            int i43 = 0;
                            Composer composer2 = restartGroup;
                            $dirty6 = 0;
                            rememberedValue = composer2.rememberedValue();
                            i16 = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i70 = 0;
                                composer2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheChipKt$ElevatedSuggestionChip$2 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj4 = obj34;
                            obj5 = invalid$iv;
                            obj12 = obj;
                            i12 = obj2;
                            interactionSource2 = $dirty2;
                            $dirty3 = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty4;
                        } else {
                            obj4 = obj34;
                            obj5 = interactionSource;
                            obj12 = obj;
                            i12 = obj2;
                            interactionSource2 = $dirty2;
                            $dirty3 = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i79 & 32 != 0) {
                            $dirty4 = i3;
                        }
                        if (i79 & 64 != 0) {
                            $dirty4 &= i38;
                        }
                        if (i79 & 128 != 0) {
                            interactionSource2 = i22;
                            modifier2 = i39;
                            $dirty5 = border;
                            obj5 = interactionSource;
                            i12 = $i$a$CacheChipKt$ElevatedSuggestionChip$2;
                            colors2 = obj11;
                            $dirty3 = elevation2;
                            elevation2 = rememberedValue;
                        } else {
                            $dirty5 = border;
                            obj5 = interactionSource;
                            modifier2 = i10;
                            i12 = $i$a$CacheChipKt$ElevatedSuggestionChip$2;
                            colors2 = obj11;
                            $dirty3 = elevation2;
                            interactionSource2 = $dirty4;
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
                if ($dirty5 == 0) {
                    borderStroke$material3_release = 0;
                } else {
                    borderStroke$material3_release = $dirty5.borderStroke$material3_release(elevation2, restartGroup, i25 |= labelTextFont);
                }
                restartGroup.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                    value = borderStroke$material3_release.getValue();
                } else {
                    value = 0;
                }
                obj2 = obj12;
                obj7 = obj4;
                ChipKt.Chip-nkUnTEs(obj7, obj6, elevation2, obj7, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), restartGroup, modifier2), obj12.labelColor-vNxB06k$material3_release(elevation2), $dirty4, i12, 0, colors2, obj2, $dirty3, value, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, obj5, restartGroup, i34 | i58);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = $dirty5;
                $dirty4 = interactionSource2;
                obj4 = obj7;
                z = elevation2;
                obj9 = i12;
                obj10 = colors2;
                obj8 = obj2;
                $composer2 = $dirty3;
                obj13 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                z = rememberedValue;
                obj9 = $i$a$CacheChipKt$ElevatedSuggestionChip$2;
                composer = restartGroup;
                obj10 = obj11;
                obj8 = obj12;
                $composer2 = elevation2;
                i = border;
                obj13 = interactionSource2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ChipKt.ElevatedSuggestionChip.3(onClick, label, obj4, z, obj9, obj10, obj8, $composer2, i, obj13, i78, i79);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FilterChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i16) {
        Object obj9;
        Object obj13;
        Object obj7;
        boolean traceInProgress2;
        Object endRestartGroup;
        int $dirty4;
        int $dirty3;
        int defaultsInvalid;
        Object modifier2;
        int $dirty6;
        int $dirty2;
        Object filterChipElevation-aqJV_2Y;
        int $dirty1;
        Object obj23;
        boolean traceInProgress;
        int i15;
        int i11;
        int i5;
        int border2;
        int i9;
        int i7;
        int shape2;
        int filterChipColors;
        int i2;
        Object filterChipBorder-_7El2pE;
        boolean $dirty;
        Object obj;
        Object obj12;
        boolean z;
        Object obj10;
        Object obj20;
        Object obj11;
        Object obj22;
        Object $composer2;
        Object obj18;
        Object obj17;
        int i14;
        Object obj5;
        int i8;
        boolean z2;
        Object obj14;
        Object obj2;
        Object obj16;
        Object obj19;
        int i21;
        int i;
        int $dirty5;
        int i12;
        int enabled2;
        boolean enabled4;
        int i10;
        int i17;
        int i4;
        int i22;
        boolean enabled3;
        int i6;
        int i3;
        int i18;
        int changed3;
        int changed4;
        int changed;
        int changed2;
        long l;
        int i19;
        float f;
        Object obj21;
        int i13;
        androidx.compose.material3.SelectableChipElevation selectableChipElevation;
        BorderStroke borderStroke;
        float height-D9Ej5fM;
        PaddingValues filterChipPadding;
        Object obj6;
        Composer composer;
        int i20;
        int $dirty12;
        Object obj3;
        Object obj15;
        Object obj4;
        Object obj8;
        int i23;
        ScopeUpdateScope scopeUpdateScope;
        Object obj44;
        final int i86 = $changed;
        final int i87 = i16;
        Composer restartGroup = $composer.startRestartGroup(-1711985619);
        ComposerKt.sourceInformation(restartGroup, "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)462@22511L5,463@22572L18,464@22653L21,465@22723L35,474@23031L5,468@22824L554:Chip.kt#uh7d8r");
        $dirty6 = $changed;
        if (i87 & 1 != 0) {
            $dirty6 |= 6;
            z2 = selected;
        } else {
            if (i86 & 6 == 0) {
                i15 = restartGroup.changed(selected) ? 4 : 2;
                $dirty6 |= i15;
            } else {
                z2 = selected;
            }
        }
        if (i87 & 2 != 0) {
            $dirty6 |= 48;
            obj2 = onClick;
        } else {
            if (i86 & 48 == 0) {
                i11 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty6 |= i11;
            } else {
                obj2 = onClick;
            }
        }
        if (i87 & 4 != 0) {
            $dirty6 |= 384;
            obj19 = label;
        } else {
            if (i86 & 384 == 0) {
                i5 = restartGroup.changedInstance(label) ? 256 : 128;
                $dirty6 |= i5;
            } else {
                obj19 = label;
            }
        }
        border2 = i87 & 8;
        if (border2 != 0) {
            $dirty6 |= 3072;
            obj18 = modifier;
        } else {
            if (i86 & 3072 == 0) {
                i14 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty6 |= i14;
            } else {
                obj18 = modifier;
            }
        }
        i8 = i87 & 16;
        if (i8 != 0) {
            $dirty6 |= 24576;
            $dirty = enabled;
        } else {
            if (i86 & 24576 == 0) {
                i21 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty6 |= i21;
            } else {
                $dirty = enabled;
            }
        }
        $dirty5 = i87 & 32;
        i12 = 196608;
        if ($dirty5 != 0) {
            $dirty6 |= i12;
            obj12 = leadingIcon;
        } else {
            if (i86 & i12 == 0) {
                i10 = restartGroup.changedInstance(leadingIcon) ? 131072 : 65536;
                $dirty6 |= i10;
            } else {
                obj12 = leadingIcon;
            }
        }
        i17 = i87 & 64;
        i4 = 1572864;
        if (i17 != 0) {
            $dirty6 |= i4;
            obj10 = trailingIcon;
        } else {
            if (i86 & i4 == 0) {
                i3 = restartGroup.changedInstance(trailingIcon) ? 1048576 : 524288;
                $dirty6 |= i3;
            } else {
                obj10 = trailingIcon;
            }
        }
        int i92 = 12582912;
        i18 = i86 & i92;
        if (i18 == 0) {
            if (i87 & 128 == 0) {
                changed3 = restartGroup.changed(shape) ? 8388608 : 4194304;
            } else {
                obj11 = shape;
            }
            $dirty6 |= changed3;
        } else {
            obj11 = shape;
        }
        if (i86 & i90 == 0) {
            if (i87 & 256 == 0) {
                changed4 = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj9 = colors;
            }
            $dirty6 |= changed4;
        } else {
            obj9 = colors;
        }
        if (i86 & i91 == 0) {
            if (i87 & 512 == 0) {
                changed = restartGroup.changed(elevation) ? 536870912 : 268435456;
            } else {
                obj13 = elevation;
            }
            $dirty6 |= changed;
        } else {
            obj13 = elevation;
        }
        if ($changed1 & 6 == 0) {
            if (i87 & 1024 == 0) {
                i12 = restartGroup.changed(border) ? 4 : 2;
            } else {
                obj7 = border;
            }
            $dirty1 |= i12;
        } else {
            obj7 = border;
        }
        int obj53 = $dirty1;
        int $dirty13 = i87 & 2048;
        if ($dirty13 != 0) {
            $dirty12 = i89;
            enabled2 = $dirty13;
            obj23 = interactionSource;
        } else {
            if ($changed1 & 48 == 0) {
                enabled2 = $dirty13;
                i6 = restartGroup.changed(interactionSource) ? 32 : 16;
                $dirty12 = i4;
            } else {
                enabled2 = $dirty13;
                obj23 = interactionSource;
                $dirty12 = obj53;
            }
        }
        obj53 = $dirty6;
        if ($dirty6 & i22 == 306783378 && $dirty12 & 19 == 18) {
            if ($dirty12 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i43 = 6;
                    if (i86 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (border2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj18;
                            }
                            enabled3 = i8 != 0 ? border2 : $dirty;
                            obj3 = $dirty5 != 0 ? border2 : obj12;
                            obj15 = i17 != 0 ? border2 : obj10;
                            if (i87 & 128 != 0) {
                                $dirty = obj53 & i80;
                                obj4 = shape2;
                            } else {
                                $dirty = obj53;
                                obj4 = obj11;
                            }
                            if (i87 & 256 != 0) {
                                obj8 = filterChipColors;
                                $dirty5 = $dirty;
                            } else {
                                obj8 = colors;
                                $dirty5 = $dirty;
                            }
                            if (i87 & 512 != 0) {
                                obj44 = modifier2;
                                i23 = enabled2;
                                $dirty4 = i17;
                                filterChipElevation-aqJV_2Y = FilterChipDefaults.INSTANCE.filterChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                obj23 = $dirty5;
                            } else {
                                obj44 = modifier2;
                                $dirty4 = i43;
                                i23 = enabled2;
                                filterChipElevation-aqJV_2Y = elevation;
                                obj23 = $dirty5;
                            }
                            if (i87 & 1024 != 0) {
                                filterChipBorder-_7El2pE = FilterChipDefaults.INSTANCE.filterChipBorder-_7El2pE(enabled3, z2, 0, i18, 0, obj22, 0, obj24, 0, obj26, 0);
                                $dirty12 &= -15;
                            } else {
                                enabled4 = enabled3;
                                filterChipBorder-_7El2pE = border;
                            }
                            if (i23 != 0) {
                                selectableChipElevation = filterChipElevation-aqJV_2Y;
                                $dirty2 = obj23;
                                borderStroke = filterChipBorder-_7El2pE;
                                obj6 = $dirty;
                                i22 = enabled4;
                                border2 = $dirty12;
                                l = obj3;
                                f = obj15;
                                obj21 = obj4;
                                i13 = obj8;
                                enabled2 = obj44;
                            } else {
                                obj6 = interactionSource;
                                selectableChipElevation = filterChipElevation-aqJV_2Y;
                                $dirty2 = obj23;
                                borderStroke = filterChipBorder-_7El2pE;
                                i22 = enabled4;
                                border2 = $dirty12;
                                l = obj3;
                                f = obj15;
                                obj21 = obj4;
                                i13 = obj8;
                                enabled2 = obj44;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty3 = i87 & 128 != 0 ? obj53 & i40 : obj53;
                            if (i87 & 256 != 0) {
                                $dirty3 &= i9;
                            }
                            if (i87 & 512 != 0) {
                                $dirty3 &= i7;
                            }
                            if (i87 & 1024 != 0) {
                                border2 = $dirty12 & -15;
                                $dirty2 = $dirty3;
                                $dirty4 = i88;
                                i13 = colors;
                                selectableChipElevation = elevation;
                                borderStroke = border;
                                obj6 = obj23;
                                i22 = $dirty;
                                l = obj12;
                                f = obj10;
                                obj21 = obj11;
                                enabled2 = obj18;
                            } else {
                                $dirty2 = $dirty3;
                                $dirty4 = $dirty14;
                                i13 = colors;
                                selectableChipElevation = elevation;
                                borderStroke = border;
                                obj6 = obj23;
                                i22 = $dirty;
                                l = obj12;
                                f = obj10;
                                obj21 = obj11;
                                enabled2 = obj18;
                                border2 = $dirty12;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1711985619, $dirty2, border2, "androidx.compose.material3.FilterChip (Chip.kt:468)");
                    }
                    ChipKt.SelectableChip-u0RnIRE(selected, enabled2, obj2, i22, obj19, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), restartGroup, $dirty4), l, 0, f, obj21, i13, selectableChipElevation, borderStroke, FilterChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.FilterChipPadding, obj6, restartGroup, i33 | i57, i38 | obj23);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i = $dirty2;
                    $dirty12 = border2;
                    obj = enabled2;
                    z = i22;
                    obj20 = l;
                    obj22 = f;
                    $composer2 = obj21;
                    obj17 = i13;
                    obj5 = selectableChipElevation;
                    obj14 = borderStroke;
                    obj16 = obj6;
                } else {
                    restartGroup.skipToGroupEnd();
                    obj5 = elevation;
                    obj14 = border;
                    i = obj53;
                    obj16 = obj23;
                    composer = restartGroup;
                    $composer2 = obj11;
                    obj22 = obj10;
                    obj20 = obj12;
                    z = $dirty;
                    obj = obj18;
                    obj17 = colors;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ChipKt.FilterChip.1(selected, onClick, label, obj, z, obj20, obj22, $composer2, obj17, obj5, obj14, obj16, i86, $changed1, i87);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void InputChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i17) {
        int anon;
        Object obj15;
        Object obj5;
        Object obj3;
        Object obj10;
        Object obj;
        boolean traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        int $dirty;
        int defaultsInvalid;
        Object modifier2;
        int $dirty3;
        int $dirty4;
        int $dirty2;
        Object inputChipElevation-aqJV_2Y;
        int $dirty1;
        int i9;
        int i15;
        Object obj16;
        Object obj14;
        int i2;
        int i11;
        Object border2;
        boolean traceInProgress;
        int shapedAvatar;
        int i20;
        Object obj12;
        boolean z3;
        Shape shape2;
        int inputChipColors;
        int i25;
        boolean $dirty12;
        Object obj9;
        int i13;
        Object value2;
        Object obj13;
        Object obj6;
        Object avatar2;
        Shape $composer2;
        androidx.compose.material3.SelectableChipColors selectableChipColors;
        int rememberComposableLambda;
        Object obj2;
        androidx.compose.material3.SelectableChipElevation selectableChipElevation;
        boolean z;
        BorderStroke borderStroke;
        Object obj4;
        int i6;
        int i3;
        boolean iNSTANCE;
        int i23;
        int modifier3;
        boolean z2;
        Object enabled2;
        int i7;
        int changed3;
        int i;
        int i5;
        int i26;
        boolean i14;
        int i12;
        int i16;
        TextStyle value;
        int i27;
        int i4;
        int i24;
        int i18;
        int changed2;
        int changed;
        int changed4;
        androidx.compose.material3.SelectableChipColors selectableChipColors2;
        Object obj17;
        Object obj11;
        float height-D9Ej5fM;
        PaddingValues inputChipPadding;
        int i8;
        Composer composer;
        int i19;
        int i22;
        Object obj7;
        Shape shape3;
        Object obj8;
        int i21;
        int i10;
        ScopeUpdateScope scopeUpdateScope;
        Object obj44;
        final int i92 = $changed;
        final int i93 = $changed1;
        anon = i17;
        Composer restartGroup = $composer.startRestartGroup(1658928131);
        ComposerKt.sourceInformation(restartGroup, "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)638@30882L5,639@30942L17,640@31021L20,641@31089L34,671@32220L5,665@32014L745:Chip.kt#uh7d8r");
        $dirty4 = $changed;
        if (anon & 1 != 0) {
            $dirty4 |= 6;
            z = selected;
        } else {
            if (i92 & 6 == 0) {
                i9 = restartGroup.changed(selected) ? 4 : 2;
                $dirty4 |= i9;
            } else {
                z = selected;
            }
        }
        if (anon & 2 != 0) {
            $dirty4 |= 48;
            obj4 = onClick;
        } else {
            if (i92 & 48 == 0) {
                i15 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty4 |= i15;
            } else {
                obj4 = onClick;
            }
        }
        if (anon & 4 != 0) {
            $dirty4 |= 384;
            obj16 = label;
        } else {
            if (i92 & 384 == 0) {
                i3 = restartGroup.changedInstance(label) ? 256 : 128;
                $dirty4 |= i3;
            } else {
                obj16 = label;
            }
        }
        iNSTANCE = anon & 8;
        if (iNSTANCE != null) {
            $dirty4 |= 3072;
            obj12 = modifier;
        } else {
            if (i92 & 3072 == 0) {
                i23 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty4 |= i23;
            } else {
                obj12 = modifier;
            }
        }
        int i94 = anon & 16;
        if (i94 != 0) {
            $dirty4 |= 24576;
            $dirty12 = enabled;
        } else {
            if (i92 & 24576 == 0) {
                i26 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty4 |= i26;
            } else {
                $dirty12 = enabled;
            }
        }
        i14 = anon & 32;
        i12 = 196608;
        if (i14 != 0) {
            $dirty4 |= i12;
            value2 = leadingIcon;
        } else {
            if (i92 & i12 == 0) {
                i16 = restartGroup.changedInstance(leadingIcon) ? 131072 : 65536;
                $dirty4 |= i16;
            } else {
                value2 = leadingIcon;
            }
        }
        value = anon & 64;
        i27 = 1572864;
        if (value != null) {
            $dirty4 |= i27;
            obj6 = avatar;
        } else {
            if (i92 & i27 == 0) {
                i4 = restartGroup.changedInstance(avatar) ? 1048576 : 524288;
                $dirty4 |= i4;
            } else {
                obj6 = avatar;
            }
        }
        rememberComposableLambda = anon & 128;
        i24 = 12582912;
        if (rememberComposableLambda != 0) {
            $dirty4 |= i24;
            obj2 = trailingIcon;
        } else {
            if (i92 & i24 == 0) {
                i18 = restartGroup.changedInstance(trailingIcon) ? 8388608 : 4194304;
                $dirty4 |= i18;
            } else {
                obj2 = trailingIcon;
            }
        }
        if (i92 & i96 == 0) {
            if (anon & 256 == 0) {
                changed2 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj15 = shape;
            }
            $dirty4 |= changed2;
        } else {
            obj15 = shape;
        }
        if (i92 & i97 == 0) {
            if (anon & 512 == 0) {
                changed = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj5 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj5 = colors;
        }
        if (i93 & 6 == 0) {
            if (anon & 1024 == 0) {
                i7 = restartGroup.changed(elevation) ? 4 : 2;
            } else {
                obj3 = elevation;
            }
            $dirty1 |= i7;
        } else {
            obj3 = elevation;
        }
        if (i93 & 48 == 0) {
            if (anon & 2048 == 0) {
                i12 = restartGroup.changed(border) ? 32 : 16;
            } else {
                obj10 = border;
            }
            $dirty1 |= i12;
        } else {
            obj10 = border;
        }
        i11 = anon & 4096;
        if (i11 != 0) {
            $dirty1 |= 384;
            obj = interactionSource;
        } else {
            if (i93 & 384 == 0) {
                i4 = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= i4;
            } else {
                obj = interactionSource;
            }
        }
        final int obj54 = $dirty4;
        if ($dirty4 & i5 == 306783378 && $dirty1 & 147 == 146) {
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
                            z2 = i94 != 0 ? obj12 : $dirty12;
                            i19 = i14 != 0 ? obj12 : value2;
                            i22 = value != null ? obj12 : obj6;
                            obj7 = rememberComposableLambda != 0 ? obj12 : obj2;
                            if (anon & 256 != 0) {
                                $dirty12 = obj54 & i88;
                                shape3 = shape2;
                            } else {
                                shape3 = shape;
                                $dirty12 = obj54;
                            }
                            if (anon & 512 != 0) {
                                obj8 = inputChipColors;
                                i21 = $dirty12;
                            } else {
                                obj8 = colors;
                                i21 = $dirty12;
                            }
                            if (anon & 1024 != 0) {
                                obj44 = modifier2;
                                i10 = i5;
                                $dirty3 = i14;
                                inputChipElevation-aqJV_2Y = InputChipDefaults.INSTANCE.inputChipElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                                $dirty1 = iNSTANCE & -15;
                            } else {
                                obj44 = modifier2;
                                $dirty3 = i49;
                                iNSTANCE = $dirty1;
                                i10 = i11;
                                inputChipElevation-aqJV_2Y = elevation;
                            }
                            if (anon & 2048 != 0) {
                                border2 = InputChipDefaults.INSTANCE.inputChipBorder-_7El2pE(z2, z, 0, i12, 0, i27, 0, i24, 0, obj26, 0);
                                $dirty1 &= -113;
                            } else {
                                border2 = border;
                            }
                            if (i10 != 0) {
                                obj17 = inputChipElevation-aqJV_2Y;
                                obj11 = border2;
                                i8 = obj12;
                                i14 = z2;
                                i27 = i19;
                                obj6 = i22;
                                i24 = obj7;
                                changed4 = shape3;
                                selectableChipColors2 = obj8;
                                $dirty2 = i21;
                                enabled2 = obj44;
                            } else {
                                i8 = interactionSource;
                                obj17 = inputChipElevation-aqJV_2Y;
                                obj11 = border2;
                                i14 = z2;
                                i27 = i19;
                                obj6 = i22;
                                i24 = obj7;
                                changed4 = shape3;
                                selectableChipColors2 = obj8;
                                $dirty2 = i21;
                                enabled2 = obj44;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty = anon & 256 != 0 ? obj54 & i32 : obj54;
                            if (anon & 512 != 0) {
                                $dirty &= i2;
                            }
                            if (anon & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            if (anon & 2048 != 0) {
                                $dirty1 &= -113;
                            }
                            $dirty2 = $dirty;
                            $dirty3 = i95;
                            changed4 = shape;
                            selectableChipColors2 = colors;
                            obj17 = elevation;
                            obj11 = border;
                            i8 = interactionSource;
                            enabled2 = obj12;
                            i14 = $dirty12;
                            i27 = value2;
                            i24 = obj2;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1658928131, $dirty2, $dirty1, "androidx.compose.material3.InputChip (Chip.kt:643)");
                    }
                    restartGroup.startReplaceGroup(417920884);
                    ComposerKt.sourceInformation(restartGroup, "649@31531L5,651@31584L419");
                    i25 = 1;
                    if (obj6 != null) {
                        $dirty12 = i14 ? 1065353216 : 1052938076;
                        ChipKt.InputChip.1 anon2 = new ChipKt.InputChip.1($dirty12, ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), restartGroup, $dirty3), obj6);
                        i4 = shapedAvatar;
                    } else {
                        i4 = shapedAvatar;
                    }
                    restartGroup.endReplaceGroup();
                    int i33 = 0;
                    i20 = i4 != 0 ? i25 : i33;
                    i13 = i27 != null ? i25 : i33;
                    if (i24 != null) {
                    } else {
                        i25 = i33;
                    }
                    ChipKt.SelectableChip-u0RnIRE(selected, enabled2, obj4, i14, label, TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), restartGroup, $dirty3), i27, i4, i24, changed4, selectableChipColors2, obj17, obj11, InputChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.inputChipPadding(i20, i13, i25), i8, restartGroup, i40 | i69, i45 | i75);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj13 = obj6;
                    obj14 = enabled2;
                    z3 = i14;
                    obj9 = i27;
                    avatar2 = i24;
                    $composer2 = changed4;
                    selectableChipColors = selectableChipColors2;
                    selectableChipElevation = obj17;
                    borderStroke = obj11;
                    i6 = i8;
                    modifier3 = $dirty2;
                    i = $dirty1;
                } else {
                    restartGroup.skipToGroupEnd();
                    selectableChipColors = colors;
                    borderStroke = border;
                    i6 = interactionSource;
                    modifier3 = obj54;
                    obj14 = obj12;
                    z3 = $dirty12;
                    obj9 = value2;
                    obj13 = obj6;
                    composer = restartGroup;
                    avatar2 = obj2;
                    $composer2 = shape;
                    selectableChipElevation = elevation;
                    i = $dirty1;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new ChipKt.InputChip.2(selected, onClick, label, obj14, z3, obj9, obj13, avatar2, $composer2, selectableChipColors, selectableChipElevation, borderStroke, i6, i92, i93, i17);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    private static final void SelectableChip-u0RnIRE(boolean selected, Modifier modifier, Function0<Unit> onClick, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, androidx.compose.material3.SelectableChipColors colors, androidx.compose.material3.SelectableChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        boolean traceInProgress;
        Object endRestartGroup;
        boolean obj2;
        Modifier z;
        Object obj4;
        Object obj6;
        Object obj5;
        float f;
        Object obj;
        Modifier skipping;
        boolean traceInProgress2;
        Object rememberedValue;
        Object str;
        int unbox-impl;
        boolean restartGroup;
        int $dirty2;
        Object $i$a$CacheChipKt$SelectableChip$interactionSource$1;
        int i18;
        int $dirty12;
        State $dirty1;
        int i15;
        int i4;
        Object obj9;
        int i6;
        int i3;
        Object obj7;
        Object obj10;
        Object obj11;
        Object $dirty;
        Object obj8;
        Object obj3;
        Object obj12;
        int i;
        int changed2;
        int changed;
        int interactionSource2;
        int i14;
        float companion;
        int i7;
        int i8;
        int $dirty4;
        int $dirty3;
        int i2;
        int i5;
        Composer composer;
        int i17;
        int i9;
        int changed3;
        int i11;
        int i10;
        int i16;
        int i19;
        int i12;
        int i13;
        int changed4;
        ScopeUpdateScope scopeUpdateScope;
        int obj47;
        traceInProgress = selected;
        $dirty = modifier;
        z = enabled;
        obj2 = colors;
        obj8 = elevation;
        obj3 = interactionSource;
        int i56 = $changed;
        i = $changed1;
        restartGroup = $composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation(restartGroup, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)2023@98879L525,2013@98468L936:Chip.kt#uh7d8r");
        if (i56 & 6 == 0) {
            i15 = restartGroup.changed(traceInProgress) ? 4 : 2;
            $dirty2 |= i15;
        }
        if (i56 & 48 == 0) {
            i4 = restartGroup.changed($dirty) ? 32 : changed2;
            $dirty2 |= i4;
        }
        companion = 128;
        if (i56 & 384 == 0) {
            i7 = restartGroup.changedInstance(onClick) ? i14 : companion;
            $dirty2 |= i7;
        } else {
            obj9 = onClick;
        }
        int i57 = 1024;
        if (i56 & 3072 == 0) {
            i3 = restartGroup.changed(z) ? i8 : i57;
            $dirty2 |= i3;
        }
        final int i58 = 8192;
        if (i56 & 24576 == 0) {
            i17 = restartGroup.changedInstance(label) ? i5 : i58;
            $dirty2 |= i17;
        } else {
            obj7 = label;
        }
        int i59 = 196608;
        final int i60 = 65536;
        if (i56 & i59 == 0) {
            i10 = restartGroup.changed(labelTextStyle) ? i11 : i60;
            $dirty2 |= i10;
        } else {
            obj10 = labelTextStyle;
        }
        if (i56 & i61 == 0) {
            i16 = restartGroup.changedInstance(leadingIcon) ? 1048576 : 524288;
            $dirty2 |= i16;
        } else {
            obj11 = leadingIcon;
        }
        if (i56 & i63 == 0) {
            i19 = restartGroup.changedInstance(avatar) ? 8388608 : 4194304;
            $dirty2 |= i19;
        } else {
            obj4 = avatar;
        }
        if (i56 & i65 == 0) {
            i12 = restartGroup.changedInstance(trailingIcon) ? 67108864 : 33554432;
            $dirty2 |= i12;
        } else {
            obj6 = trailingIcon;
        }
        if (i56 & i66 == 0) {
            i13 = restartGroup.changed(shape) ? 536870912 : 268435456;
            $dirty2 |= i13;
        } else {
            obj12 = shape;
        }
        if (i & 6 == 0) {
            i9 = restartGroup.changed(obj2) ? 4 : 2;
            $dirty12 |= i9;
        }
        if (i & 48 == 0 && restartGroup.changed(obj8)) {
            if (restartGroup.changed(obj8)) {
                changed2 = 32;
            }
            $dirty12 |= changed2;
        }
        if (i & 384 == 0) {
            if (restartGroup.changed(border)) {
            } else {
                i14 = companion;
            }
            $dirty12 |= i14;
        } else {
            obj5 = border;
        }
        if (i & 3072 == 0) {
            if (restartGroup.changed(minHeight)) {
            } else {
                i8 = i57;
            }
            $dirty12 |= i8;
        } else {
            f = minHeight;
        }
        if (i & 24576 == 0) {
            if (restartGroup.changed(paddingValues)) {
            } else {
                i5 = i58;
            }
            $dirty12 |= i5;
        } else {
            obj = paddingValues;
        }
        if (i & i59 == 0) {
            if (restartGroup.changed(obj3)) {
            } else {
                i11 = i60;
            }
            $dirty12 |= i11;
        }
        if ($dirty2 & interactionSource2 == 306783378 && i44 &= $dirty12 == 74898) {
            if (i44 &= $dirty12 == 74898) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(402951308, $dirty2, $dirty12, "androidx.compose.material3.SelectableChip (Chip.kt:2009)");
                    }
                    restartGroup.startReplaceGroup(2072749057);
                    ComposerKt.sourceInformation(restartGroup, "2011@98346L39");
                    if (obj3 == null) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2072749708, "CC(remember):Chip.kt#9igjgp");
                        i6 = restartGroup;
                        interactionSource2 = 0;
                        obj47 = i40;
                        rememberedValue = i6.rememberedValue();
                        i14 = 0;
                        $dirty3 = $dirty2;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i46 = 0;
                            i6.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheChipKt$SelectableChip$interactionSource$1 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        $dirty3 = $dirty2;
                        $i$a$CacheChipKt$SelectableChip$interactionSource$1 = obj3;
                    }
                    restartGroup.endReplaceGroup();
                    Object obj14 = $i$a$CacheChipKt$SelectableChip$interactionSource$1;
                    int i52 = 1;
                    obj47 = $dirty12;
                    restartGroup.startReplaceGroup(2072762384);
                    ComposerKt.sourceInformation(restartGroup, "2020@98742L43");
                    if (obj8 == null) {
                    } else {
                        $dirty1 = obj8.shadowElevation$material3_release(z, (InteractionSource)obj14, restartGroup, i48 |= i50);
                    }
                    restartGroup.endReplaceGroup();
                    if ($dirty1 != null) {
                        companion = unbox-impl;
                    } else {
                        i18 = 0;
                        companion = $dirty1;
                    }
                    obj12 = restartGroup;
                    $dirty12 = obj11;
                    int i54 = $dirty3;
                    obj7 = trailingIcon;
                    ChipKt.SelectableChip.2 anon = new ChipKt.SelectableChip.2(obj2, z, selected, obj7, obj10, $dirty12, avatar, obj7, minHeight, paddingValues);
                    i2 = i54;
                    SurfaceKt.Surface-d85dljk(selected, onClick, SemanticsModifierKt.semantics$default($dirty, false, (Function1)ChipKt.SelectableChip.1.INSTANCE, i52, 0), enabled, shape, obj2.containerColor-WaAFU9c$material3_release(z, traceInProgress), $dirty12, 0, obj7, 0, companion, border, obj14, (Function2)ComposableLambdaKt.rememberComposableLambda(-577614814, i52, anon, obj12, 54), obj12, i24 |= i33);
                    composer = obj12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    composer = restartGroup;
                    i2 = $dirty2;
                    $dirty4 = $dirty12;
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
        Object obj4;
        boolean traceInProgress2;
        int i4;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int $dirty;
        int $dirty2;
        int suggestionChipElevation-aqJV_2Y;
        Object suggestionChipBorder-h1eT-Ww;
        int i8;
        int i6;
        Object obj6;
        int enabled2;
        boolean traceInProgress;
        Object interactionSource2;
        int shape2;
        int suggestionChipColors;
        int i14;
        boolean z;
        int $dirty3;
        boolean z2;
        Object obj2;
        int i15;
        Object obj10;
        int i2;
        Object obj11;
        Object obj9;
        Object $composer2;
        int i5;
        Object obj3;
        BorderStroke borderStroke;
        int changed2;
        Object obj5;
        int i7;
        Object obj8;
        Object obj7;
        int changed;
        Object elevation2;
        int changed4;
        Object i10;
        int changed3;
        TextStyle value;
        int labelColor-vNxB06k$material3_release;
        int i12;
        int $dirty6;
        Object obj14;
        int i11;
        Object colors2;
        Object obj13;
        Object obj;
        Object $dirty4;
        int $dirty5;
        Object obj12;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        int i9;
        Composer composer;
        int i;
        int i3;
        Object obj34;
        int obj42;
        final int i74 = $changed;
        final int i75 = i13;
        Composer restartGroup = $composer.startRestartGroup(-1700130831);
        ComposerKt.sourceInformation(restartGroup, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)740@35497L5,741@35552L22,742@35631L25,743@35709L29,751@35977L5,746@35805L538:Chip.kt#uh7d8r");
        $dirty = $changed;
        if (i75 & 1 != 0) {
            $dirty |= 6;
            obj7 = onClick;
        } else {
            if (i74 & 6 == 0) {
                i8 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj7 = onClick;
            }
        }
        if (i75 & 2 != 0) {
            $dirty |= 48;
            obj8 = label;
        } else {
            if (i74 & 48 == 0) {
                i6 = restartGroup.changedInstance(label) ? 32 : 16;
                $dirty |= i6;
            } else {
                obj8 = label;
            }
        }
        int i36 = i75 & 4;
        if (i36 != 0) {
            $dirty |= 384;
            interactionSource2 = modifier;
        } else {
            if (i74 & 384 == 0) {
                i14 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i14;
            } else {
                interactionSource2 = modifier;
            }
        }
        $dirty3 = i75 & 8;
        if ($dirty3 != 0) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i74 & 3072 == 0) {
                i15 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i15;
            } else {
                z2 = enabled;
            }
        }
        i2 = i75 & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            obj11 = icon;
        } else {
            if (i74 & 24576 == 0) {
                i5 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                obj11 = icon;
            }
        }
        if (i68 &= i74 == 0) {
            if (i75 & 32 == 0) {
                changed2 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj3 = shape;
            }
            $dirty |= changed2;
        } else {
            obj3 = shape;
        }
        if (i71 &= i74 == 0) {
            if (i75 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj5 = colors;
            }
            $dirty |= changed;
        } else {
            obj5 = colors;
        }
        int i76 = 12582912;
        if (i74 & i76 == 0) {
            obj42 = i76;
            if (i75 & 128 == 0) {
                changed4 = restartGroup.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty |= changed4;
        } else {
            obj42 = i76;
            elevation2 = elevation;
        }
        if (i74 & i78 == 0) {
            if (i75 & 256 == 0) {
                changed3 = restartGroup.changed(border) ? 67108864 : 33554432;
            } else {
                obj4 = border;
            }
            $dirty |= changed3;
        } else {
            obj4 = border;
        }
        int i37 = i75 & 512;
        int i79 = 805306368;
        if (i37 != 0) {
            $dirty |= i79;
            labelColor-vNxB06k$material3_release = i37;
            obj6 = interactionSource;
        } else {
            if (i74 & i79 == 0) {
                labelColor-vNxB06k$material3_release = i37;
                i12 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty |= i12;
            } else {
                labelColor-vNxB06k$material3_release = i37;
                obj6 = interactionSource;
            }
        }
        $dirty6 = $dirty;
        if ($dirty & i81 == 306783378) {
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
                        obj = i2 != 0 ? interactionSource2 : obj11;
                        if (i75 & 32 != 0) {
                            $dirty3 = $dirty6 & i84;
                            $dirty6 = shape2;
                        } else {
                            $dirty3 = $dirty6;
                            $dirty6 = obj3;
                        }
                        if (i75 & 64 != 0) {
                            obj13 = suggestionChipColors;
                            $dirty5 = $dirty3;
                        } else {
                            obj13 = obj5;
                            $dirty5 = $dirty3;
                        }
                        if (i75 & 128 != 0) {
                            obj34 = modifier2;
                            modifier3 = obj12;
                            $dirty5 &= i83;
                            elevation2 = suggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier2;
                            modifier3 = enabled2;
                        }
                        if (i75 & 256 != 0) {
                            suggestionChipBorder-h1eT-Ww = SuggestionChipDefaults.INSTANCE.suggestionChipBorder-h1eT-Ww(value, 0, $dirty3, 0, i2, 0, restartGroup);
                            $dirty5 &= i82;
                        } else {
                            enabled2 = value;
                            suggestionChipBorder-h1eT-Ww = border;
                        }
                        if (labelColor-vNxB06k$material3_release != 0) {
                            obj12 = suggestionChipBorder-h1eT-Ww;
                            i9 = i56;
                            obj5 = obj13;
                            obj14 = obj;
                            $dirty2 = $dirty5;
                            interactionSource2 = obj34;
                            $dirty4 = elevation2;
                            colors2 = $dirty6;
                            elevation2 = enabled2;
                        } else {
                            interactionSource2 = obj34;
                            i9 = interactionSource;
                            obj12 = suggestionChipBorder-h1eT-Ww;
                            obj5 = obj13;
                            obj14 = obj;
                            $dirty2 = $dirty5;
                            $dirty4 = elevation2;
                            colors2 = $dirty6;
                            elevation2 = enabled2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i75 & 32 != 0) {
                            $dirty6 = i4;
                        }
                        if (i75 & 64 != 0) {
                            $dirty6 &= i34;
                        }
                        if (i75 & 128 != 0) {
                            $dirty6 &= i83;
                        }
                        if (i75 & 256 != 0) {
                            obj12 = border;
                            i9 = interactionSource;
                            $dirty2 = i20;
                            modifier3 = enabled2;
                            obj14 = obj11;
                            colors2 = obj3;
                            $dirty4 = elevation2;
                            elevation2 = z2;
                        } else {
                            obj12 = border;
                            i9 = interactionSource;
                            modifier3 = enabled2;
                            obj14 = obj11;
                            colors2 = obj3;
                            $dirty4 = elevation2;
                            $dirty2 = $dirty6;
                            elevation2 = z2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1700130831, $dirty2, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:746)");
                }
                obj = obj5;
                obj8 = interactionSource2;
                ChipKt.Chip-nkUnTEs(obj8, obj7, elevation2, obj8, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), restartGroup, modifier3), obj5.labelColor-vNxB06k$material3_release(elevation2), $dirty6, obj14, 0, colors2, obj, $dirty4, obj12, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, i9, restartGroup, i28 | i51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty6 = $dirty2;
                interactionSource2 = obj8;
                z = elevation2;
                obj2 = obj14;
                obj10 = colors2;
                obj9 = obj;
                $composer2 = $dirty4;
                borderStroke = obj12;
                i7 = i9;
            } else {
                restartGroup.skipToGroupEnd();
                z = z2;
                obj2 = obj11;
                composer = restartGroup;
                obj10 = obj3;
                obj9 = obj5;
                $composer2 = elevation2;
                borderStroke = border;
                i7 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ChipKt.SuggestionChip.1(onClick, label, interactionSource2, z, obj2, obj10, obj9, $composer2, borderStroke, i7, i74, i75);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(...))
    public static final void SuggestionChip(Function0 onClick, Function2 label, Modifier modifier, boolean enabled, Function2 icon, Shape shape, androidx.compose.material3.ChipColors colors, androidx.compose.material3.ChipElevation elevation, androidx.compose.material3.ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        Object obj6;
        int traceInProgress2;
        int modifier2;
        State borderStroke$material3_release;
        int value;
        int i2;
        int defaultsInvalid;
        Object modifier3;
        int $dirty;
        androidx.compose.material3.ChipBorder $dirty5;
        int suggestionChipElevation-aqJV_2Y;
        int i7;
        int i12;
        Object interactionSource2;
        int i3;
        Object obj2;
        int shape2;
        int suggestionChipColors;
        int i;
        int $dirty3;
        boolean traceInProgress;
        int labelTextFont;
        boolean z;
        boolean rememberedValue;
        Object obj12;
        int i14;
        int i10;
        Object obj3;
        Composer $composer3;
        Object $composer2;
        Object $i$a$CacheChipKt$SuggestionChip$2;
        Object obj9;
        int i11;
        Object obj;
        androidx.compose.material3.ChipBorder chipBorder;
        int changed;
        Object obj11;
        Object obj13;
        Object obj5;
        Object obj14;
        int changed2;
        Object elevation2;
        int changed4;
        Object i4;
        int changed3;
        int value2;
        int labelColor-vNxB06k$material3_release;
        int i9;
        int $dirty2;
        Object obj7;
        int i8;
        Object colors2;
        Object obj4;
        Object obj10;
        Object $dirty6;
        int $dirty4;
        int i6;
        float height-D9Ej5fM;
        PaddingValues suggestionChipPadding;
        Object obj8;
        Composer composer2;
        Composer composer;
        int i5;
        int i15;
        Object obj34;
        int obj42;
        final int i78 = $changed;
        final int i79 = i13;
        $composer3 = $composer.startRestartGroup(170629701);
        ComposerKt.sourceInformation($composer3, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)824@39441L5,825@39496L22,826@39575L25,827@39651L22,828@39725L39,835@39946L5,830@39774L568:Chip.kt#uh7d8r");
        $dirty = $changed;
        if (i79 & 1 != 0) {
            $dirty |= 6;
            obj14 = onClick;
        } else {
            if (i78 & 6 == 0) {
                i7 = $composer3.changedInstance(onClick) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj14 = onClick;
            }
        }
        if (i79 & 2 != 0) {
            $dirty |= 48;
            obj5 = label;
        } else {
            if (i78 & 48 == 0) {
                i12 = $composer3.changedInstance(label) ? 32 : 16;
                $dirty |= i12;
            } else {
                obj5 = label;
            }
        }
        int i40 = i79 & 4;
        if (i40 != 0) {
            $dirty |= 384;
            obj2 = modifier;
        } else {
            if (i78 & 384 == 0) {
                i = $composer3.changed(modifier) ? 256 : 128;
                $dirty |= i;
            } else {
                obj2 = modifier;
            }
        }
        $dirty3 = i79 & 8;
        if ($dirty3 != 0) {
            $dirty |= 3072;
            rememberedValue = enabled;
        } else {
            if (i78 & 3072 == 0) {
                i14 = $composer3.changed(enabled) ? 2048 : 1024;
                $dirty |= i14;
            } else {
                rememberedValue = enabled;
            }
        }
        i10 = i79 & 16;
        if (i10 != 0) {
            $dirty |= 24576;
            $i$a$CacheChipKt$SuggestionChip$2 = icon;
        } else {
            if (i78 & 24576 == 0) {
                i11 = $composer3.changedInstance(icon) ? 16384 : 8192;
                $dirty |= i11;
            } else {
                $i$a$CacheChipKt$SuggestionChip$2 = icon;
            }
        }
        if (i72 &= i78 == 0) {
            if (i79 & 32 == 0) {
                changed = $composer3.changed(shape) ? 131072 : 65536;
            } else {
                obj = shape;
            }
            $dirty |= changed;
        } else {
            obj = shape;
        }
        if (i75 &= i78 == 0) {
            if (i79 & 64 == 0) {
                changed2 = $composer3.changed(colors) ? 1048576 : 524288;
            } else {
                obj11 = colors;
            }
            $dirty |= changed2;
        } else {
            obj11 = colors;
        }
        int i80 = 12582912;
        if (i78 & i80 == 0) {
            obj42 = i80;
            if (i79 & 128 == 0) {
                changed4 = $composer3.changed(elevation) ? 8388608 : 4194304;
            } else {
                elevation2 = elevation;
            }
            $dirty |= changed4;
        } else {
            obj42 = i80;
            elevation2 = elevation;
        }
        if (i78 & i82 == 0) {
            if (i79 & 256 == 0) {
                changed3 = $composer3.changed(border) ? 67108864 : 33554432;
            } else {
                obj6 = border;
            }
            $dirty |= changed3;
        } else {
            obj6 = border;
        }
        int i41 = i79 & 512;
        int i83 = 805306368;
        if (i41 != 0) {
            $dirty |= i83;
            labelColor-vNxB06k$material3_release = i41;
            interactionSource2 = interactionSource;
        } else {
            if (i78 & i83 == 0) {
                labelColor-vNxB06k$material3_release = i41;
                i9 = $composer3.changed(interactionSource) ? 536870912 : 268435456;
                $dirty |= i9;
            } else {
                labelColor-vNxB06k$material3_release = i41;
                interactionSource2 = interactionSource;
            }
        }
        $dirty2 = $dirty;
        if ($dirty & i85 == 306783378) {
            if (!$composer3.getSkipping()) {
                $composer3.startDefaults();
                int i86 = -234881025;
                int i87 = -29360129;
                int i37 = -3670017;
                int i88 = -458753;
                i3 = 6;
                if (i78 & 1 != 0) {
                    if ($composer3.getDefaultsInvalid()) {
                        if (i40 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj2;
                        }
                        value2 = $dirty3 != 0 ? obj2 : rememberedValue;
                        obj10 = i10 != 0 ? obj2 : $i$a$CacheChipKt$SuggestionChip$2;
                        if (i79 & 32 != 0) {
                            $dirty3 = $dirty2 & i88;
                            $dirty2 = shape2;
                        } else {
                            $dirty3 = $dirty2;
                            $dirty2 = obj;
                        }
                        if (i79 & 64 != 0) {
                            obj4 = suggestionChipColors;
                            $dirty4 = $dirty3;
                        } else {
                            obj4 = obj11;
                            $dirty4 = $dirty3;
                        }
                        if (i79 & 128 != 0) {
                            obj34 = modifier3;
                            modifier2 = i70;
                            $dirty4 &= i87;
                            elevation2 = suggestionChipElevation-aqJV_2Y;
                        } else {
                            obj34 = modifier3;
                            modifier2 = i3;
                            composer2 = $composer3;
                        }
                        if (i79 & 256 != 0) {
                            $dirty5 = SuggestionChipDefaults.INSTANCE.suggestionChipBorder-d_3_b6Q(0, suggestionChipColors, 0, rememberedValue, 0, composer2);
                            $dirty4 &= i86;
                        } else {
                            $composer3 = composer2;
                            $dirty5 = border;
                        }
                        if (labelColor-vNxB06k$material3_release != 0) {
                            ComposerKt.sourceInformationMarkerStart($composer3, 1248029210, "CC(remember):Chip.kt#9igjgp");
                            int i43 = 0;
                            Composer composer3 = $composer3;
                            $dirty3 = 0;
                            rememberedValue = composer3.rememberedValue();
                            i10 = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i71 = 0;
                                composer3.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheChipKt$SuggestionChip$2 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            obj2 = obj34;
                            obj8 = invalid$iv;
                            obj11 = obj4;
                            obj7 = obj10;
                            interactionSource2 = $dirty4;
                            $dirty6 = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty2;
                        } else {
                            obj2 = obj34;
                            obj8 = interactionSource;
                            obj11 = obj4;
                            obj7 = obj10;
                            interactionSource2 = $dirty4;
                            $dirty6 = elevation2;
                            elevation2 = value2;
                            colors2 = $dirty2;
                        }
                    } else {
                        $composer3.skipToGroupEnd();
                        if (i79 & 32 != 0) {
                            $dirty2 = i2;
                        }
                        if (i79 & 64 != 0) {
                            $dirty2 &= i37;
                        }
                        if (i79 & 128 != 0) {
                            $dirty2 &= i87;
                        }
                        if (i79 & 256 != 0) {
                            interactionSource2 = i35;
                            modifier2 = i38;
                            $dirty5 = border;
                            obj8 = interactionSource;
                            obj7 = $i$a$CacheChipKt$SuggestionChip$2;
                            colors2 = obj;
                            $dirty6 = elevation2;
                            elevation2 = rememberedValue;
                        } else {
                            $dirty5 = border;
                            obj8 = interactionSource;
                            modifier2 = i3;
                            obj7 = $i$a$CacheChipKt$SuggestionChip$2;
                            colors2 = obj;
                            $dirty6 = elevation2;
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
                if ($dirty5 == null) {
                    borderStroke$material3_release = 0;
                } else {
                    borderStroke$material3_release = $dirty5.borderStroke$material3_release(elevation2, $composer3, i30 |= labelTextFont);
                }
                $composer3.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                    value = borderStroke$material3_release.getValue();
                } else {
                    value = 0;
                }
                obj10 = obj11;
                obj5 = obj2;
                ChipKt.Chip-nkUnTEs(obj5, obj14, elevation2, obj5, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), $composer3, modifier2), obj11.labelColor-vNxB06k$material3_release(elevation2), $dirty2, obj7, 0, colors2, obj10, $dirty6, value, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, obj8, $composer3, i25 | i57);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chipBorder = $dirty5;
                $dirty2 = interactionSource2;
                obj2 = obj5;
                z = elevation2;
                obj12 = obj7;
                obj3 = colors2;
                $composer2 = obj10;
                obj9 = $dirty6;
                obj13 = obj8;
            } else {
                $composer3.skipToGroupEnd();
                z = rememberedValue;
                composer = $composer3;
                obj12 = $i$a$CacheChipKt$SuggestionChip$2;
                obj3 = obj;
                $composer2 = obj11;
                obj9 = elevation2;
                chipBorder = border;
                obj13 = interactionSource2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ChipKt.SuggestionChip.3(onClick, label, obj2, z, obj12, obj3, $composer2, obj9, chipBorder, obj13, i78, i79);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
        long token2;
        long token;
        long unspecified-0d7_KjU2;
        long transparent-0d7_KjU;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i;
        long unspecified-0d7_KjU;
        int i3;
        int i4;
        int i5;
        int i7;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultSuggestionChipColors;
        if (colorScheme.getDefaultSuggestionChipColorsCached$material3_release() == null) {
            i = 0;
            i3 = 0;
            chipColors = new ChipColors(Color.Companion.getTransparent-0d7_KjU(), obj4, ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), obj8, Color.Companion.getUnspecified-0d7_KjU(), obj10, Color.Companion.getTransparent-0d7_KjU(), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), obj14, SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), i, 0, i3, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), i, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), i3, 0, 0, 14), i, Color.Companion.getUnspecified-0d7_KjU(), i3, 0);
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
