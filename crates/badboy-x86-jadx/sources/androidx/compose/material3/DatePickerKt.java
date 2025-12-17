package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u001a\u0084\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\u0008\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001ak\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010'\u001a\u00020(2\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010+\u001a\u008d\u0001\u0010,\u001a\u00020\u00142\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010=\u001aZ\u0010>\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\u0008\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\u0008C\u0010D\u001aT\u0010E\u001a\u00020&2\n\u0010F\u001a\u00060Gj\u0002`H2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\u0008\u0002\u0010J\u001a\u0004\u0018\u00010.2\u0008\u0008\u0002\u00109\u001a\u00020:2\u0008\u0008\u0002\u0010K\u001a\u00020L2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0004\u0008M\u0010N\u001an\u0010O\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\u000c\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\u0008\u0019H\u0003¢\u0006\u0002\u0010X\u001a6\u0010Y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020L2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001401H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010]\u001a\u008d\u0001\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2\u0008\u0010-\u001a\u0004\u0018\u00010.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010a\u001av\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020d2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(4\u0012\u0004\u0012\u00020\u0014012\u0006\u0010e\u001a\u00020.2\u0008\u0010f\u001a\u0004\u0018\u00010.2\u0008\u0010g\u001a\u0004\u0018\u00010.2\u0008\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010j\u001ag\u0010k\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020W2\u000c\u0010p\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00182\u000c\u0010q\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00182\u000c\u0010r\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010s\u001a\u009c\u0001\u0010t\u001a\u00020\u00142\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2\u0006\u0010Z\u001a\u00020L2#\u00100\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\u0008u\u0010v\u001a\u001d\u0010w\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u0010x\u001a^\u0010y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\u0006\u0010z\u001a\u00020*2\u000c\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010S\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\u0008\u0019H\u0003¢\u0006\u0002\u0010{\u001a`\u0010|\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u00020.2!\u0010}\u001a\u001d\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(~\u0012\u0004\u0012\u00020\u0014012\u0006\u0010;\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u007f\u001aC\u0010\u0080\u0001\u001a\u00020\u00142\u000c\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00182\u0007\u0010\u0081\u0001\u001a\u00020*2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\u0008\u0019H\u0003¢\u0006\u0003\u0010\u0082\u0001\u001a6\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00012\u0007\u0010%\u001a\u00030\u0086\u00012\u0008\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020W2\u0007\u0010\u008a\u0001\u001a\u00020WH\u0002\u001a>\u0010\u008b\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u008c\u0001\u001a\u00020*2\u0007\u0010\u008d\u0001\u001a\u00020*2\u0007\u0010\u008e\u0001\u001a\u00020*2\u0007\u0010\u008f\u0001\u001a\u00020*2\u0007\u0010\u0090\u0001\u001a\u00020*H\u0003¢\u0006\u0003\u0010\u0091\u0001\u001a\u0011\u0010\u0092\u0001\u001a\u00020\u000c2\u0006\u00109\u001a\u00020:H\u0000\u001aK\u0010\u0093\u0001\u001a\u00020&2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\u0008\u0002\u0010J\u001a\u0004\u0018\u00010.2\u0008\u0008\u0002\u00109\u001a\u00020:2\u0008\u0008\u0002\u0010K\u001a\u00020L2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u0094\u0001\u0010\u0095\u0001\u001aK\u0010\u0096\u0001\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\u000c\u00082\u0012\u0008\u00083\u0012\u0004\u0008\u0008(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0080@¢\u0006\u0003\u0010\u0097\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u000cX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0010\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\u000cX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0098\u0001²\u0006\n\u0010n\u001a\u00020*X\u008a\u008e\u0002", d2 = {"DatePickerHeadlinePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDatePickerHorizontalPadding", "()F", "F", "DatePickerModeTogglePadding", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "MaxCalendarRows", "", "MonthYearHeight", "getMonthYearHeight", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "YearsInRow", "YearsVerticalPadding", "DateEntryContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "modeToggleButton", "colors", "Landroidx/compose/material3/DatePickerColors;", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePicker", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "showModeToggle", "", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "selectedDateMillis", "", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "Day", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/internal/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "SwitchableDateEntryContent-d7iavvg", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/internal/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "scrollDownLabel", "dayContentDescription", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "numberOfMonthsInRange", "rememberDatePickerState", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DatePickerKt {

    private static final PaddingValues DatePickerHeadlinePadding = null;
    private static final float DatePickerHorizontalPadding = 0f;
    private static final PaddingValues DatePickerModeTogglePadding = null;
    private static final PaddingValues DatePickerTitlePadding = null;
    private static final int MaxCalendarRows = 6;
    private static final float MonthYearHeight = 0f;
    private static final float RecommendedSizeForAccessibility = 0f;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding;
    static {
        int i8 = 0;
        DatePickerKt.RecommendedSizeForAccessibility = Dp.constructor-impl((float)i);
        int i9 = 0;
        DatePickerKt.MonthYearHeight = Dp.constructor-impl((float)i2);
        int i10 = 0;
        DatePickerKt.DatePickerHorizontalPadding = Dp.constructor-impl((float)i3);
        int i11 = 0;
        int i12 = 0;
        final int i27 = 0;
        DatePickerKt.DatePickerModeTogglePadding = PaddingKt.PaddingValues-a9UjIt4$default(0, 0, Dp.constructor-impl((float)i4), Dp.constructor-impl((float)$this$dp$iv4), 3, i27);
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        DatePickerKt.DatePickerTitlePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl((float)i5), Dp.constructor-impl((float)$this$dp$iv6), Dp.constructor-impl((float)$this$dp$iv5), 0, 8, i27);
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        DatePickerKt.DatePickerHeadlinePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl((float)i6), 0, Dp.constructor-impl((float)$this$dp$iv7), Dp.constructor-impl((float)$this$dp$iv8), 2, i27);
        int i19 = 0;
        DatePickerKt.YearsVerticalPadding = Dp.constructor-impl((float)i7);
    }

    public static final void DateEntryContainer-au3_HiA(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> headline, Function2<? super Composer, ? super Integer, Unit> modeToggleButton, androidx.compose.material3.DatePickerColors colors, TextStyle headlineTextStyle, float headerMinHeight, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        Function0 factory$iv$iv$iv;
        int $dirty;
        int i14;
        Object $i$a$LayoutColumnKt$Column$1$iv;
        int i17;
        Object valueOf;
        Composer composer2;
        int i3;
        Object obj3;
        int i9;
        Object obj4;
        int i6;
        Object obj;
        int i12;
        float f2;
        Object obj2;
        int i;
        int i2;
        boolean skipping;
        boolean traceInProgress;
        int str;
        Function2 materialized$iv$iv;
        long l;
        Object obj5;
        float f;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer3;
        int i4;
        int i16;
        int i7;
        int i8;
        int i15;
        int currentCompositeKeyHash;
        Modifier modifier2;
        Function0 function0;
        int i5;
        int i19;
        int i13;
        int i18;
        int i11;
        ColumnScopeInstance columnScopeInstance;
        Composer composer;
        int i10;
        Modifier modifier3;
        androidx.compose.ui.Modifier.Companion obj45;
        final Object obj6 = content;
        final int i39 = $changed;
        traceInProgress2 = 1507356255;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DateEntryContainer)P(6,7,3,5!1,4,2:c#ui.unit.Dp)1303@60987L1775:DatePicker.kt#uh7d8r");
        if (i39 & 6 == 0) {
            i14 = restartGroup.changed(modifier) ? 4 : 2;
            $dirty |= i14;
        } else {
            obj2 = modifier;
        }
        if (i39 & 48 == 0) {
            i17 = restartGroup.changedInstance(title) ? 32 : 16;
            $dirty |= i17;
        } else {
            $i$a$LayoutColumnKt$Column$1$iv = title;
        }
        if (i39 & 384 == 0) {
            i3 = restartGroup.changedInstance(headline) ? 256 : 128;
            $dirty |= i3;
        } else {
            valueOf = headline;
        }
        if (i39 & 3072 == 0) {
            i9 = restartGroup.changedInstance(modeToggleButton) ? 2048 : 1024;
            $dirty |= i9;
        } else {
            obj3 = modeToggleButton;
        }
        if (i39 & 24576 == 0) {
            i6 = restartGroup.changed(colors) ? 16384 : 8192;
            $dirty |= i6;
        } else {
            obj4 = colors;
        }
        if (i35 &= i39 == 0) {
            i12 = restartGroup.changed(headlineTextStyle) ? 131072 : 65536;
            $dirty |= i12;
        } else {
            obj = headlineTextStyle;
        }
        if (i37 &= i39 == 0) {
            i = restartGroup.changed(headerMinHeight) ? 1048576 : 524288;
            $dirty |= i;
        } else {
            f2 = headerMinHeight;
        }
        if (i44 &= i39 == 0) {
            i2 = restartGroup.changedInstance(obj6) ? 8388608 : 4194304;
            $dirty |= i2;
        }
        if (i45 &= $dirty == 4793490) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1302)");
                }
                int i69 = 0;
                int i52 = 0;
                Modifier background-bw27NRU$default = BackgroundKt.background-bw27NRU$default(SemanticsModifierKt.semantics$default(SizeKt.sizeIn-qDBjuR0$default(obj2, DatePickerModalTokens.INSTANCE.getContainerWidth-D9Ej5fM(), 0, 0, 0, 14, i69), i52, (Function1)DatePickerKt.DateEntryContainer.1.INSTANCE, 1, 0), obj4.getContainerColor-0d7_KjU(), i69, 0, 2);
                i16 = i52;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                androidx.compose.foundation.layout.Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                androidx.compose.ui.layout.MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, start, restartGroup, i61 |= i65);
                i15 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, background-bw27NRU$default);
                modifier2 = background-bw27NRU$default;
                Function0 function02 = constructor;
                i5 = 0;
                i13 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i68 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i70 = 0;
                Composer composer5 = constructor-impl;
                int i73 = 0;
                if (!composer5.getInserting()) {
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer4 = restartGroup;
                i18 = i23;
                ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i32 |= 6;
                i11 = 0;
                columnScopeInstance = iNSTANCE2;
                i10 = i28;
                $i$a$LayoutColumnKt$Column$1$iv = composer6;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutColumnKt$Column$1$iv, 133224346, "C1319@61556L1182,1313@61306L1432,1345@62747L9:DatePicker.kt#uh7d8r");
                $dirty = top;
                obj4 = obj45;
                obj5 = obj;
                obj = currentCompositionLocalMap;
                modifier3 = materializeModifier;
                materialized$iv$iv = title;
                obj3 = start;
                DatePickerKt.DateEntryContainer.2.1 verticalArrangement$iv = new DatePickerKt.DateEntryContainer.2.1(headline, obj3, materialized$iv$iv, obj4, obj5);
                DatePickerKt.DatePickerHeader-pc5RIQQ((Modifier)Modifier.Companion, title, obj4.getTitleContentColor-0d7_KjU(), materialized$iv$iv, obj4.getHeadlineContentColor-0d7_KjU(), obj5, f2, (Function2)ComposableLambdaKt.rememberComposableLambda(-229007058, true, verticalArrangement$iv, $i$a$LayoutColumnKt$Column$1$iv, 54));
                obj6.invoke($i$a$LayoutColumnKt$Column$1$iv, Integer.valueOf(i25 &= 14));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutColumnKt$Column$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i13 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DatePickerKt.DateEntryContainer.3(modifier, title, headline, modeToggleButton, colors, headlineTextStyle, headerMinHeight, obj6, i39);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void DatePicker(androidx.compose.material3.DatePickerState state, Modifier modifier, androidx.compose.material3.DatePickerFormatter dateFormatter, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> headline, boolean showModeToggle, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        Object dateFormatter2;
        int obj5;
        Object obj7;
        int skipping;
        int defaultsInvalid;
        Object $i$a$CacheDatePickerKt$DatePicker$1;
        boolean colors2;
        Object $i$a$CacheDatePickerKt$DatePicker$calendarModel$1;
        Object $composer2;
        int $dirty3;
        Object $dirty2;
        int $dirty;
        int i3;
        Object obj6;
        int i8;
        boolean traceInProgress2;
        Object str;
        boolean z;
        int rememberComposableLambda;
        int i15;
        int i6;
        Object obj2;
        int i4;
        Composer composer;
        boolean changedInstance;
        Object title2;
        int i17;
        int title3;
        Object obj3;
        Object obj;
        int i;
        int i5;
        boolean showModeToggle2;
        int i16;
        Object value;
        Object rememberedValue;
        int changed;
        float headerContainerHeight-D9Ej5fM;
        androidx.compose.runtime.internal.ComposableLambda companion;
        Composer composer2;
        int i9;
        Object obj4;
        int i13;
        Object iNSTANCE;
        int i7;
        int i11;
        int i2;
        int i12;
        int i14;
        boolean obj28;
        int obj34;
        obj5 = state;
        traceInProgress = dateFormatter;
        final int i48 = $changed;
        Composer restartGroup = $composer.startRestartGroup(809701813);
        ComposerKt.sourceInformation(restartGroup, "C(DatePicker)P(5,3,1,6,2,4)171@8197L47,172@8285L170,178@8499L278,187@8865L8,189@8902L15,190@8942L62,207@9637L5,210@9746L655,191@9009L1392:DatePicker.kt#uh7d8r");
        $dirty3 = $changed;
        if (i10 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i48 & 6 == 0) {
                i3 = restartGroup.changed(obj5) ? 4 : 2;
                $dirty3 |= i3;
            }
        }
        i8 = i10 & 2;
        if (i8 != 0) {
            $dirty3 |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i15 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i15;
            } else {
                str = modifier;
            }
        }
        if (i48 & 384 == 0) {
            if (i10 & 4 == 0) {
                if (i48 & 512 == 0) {
                    changedInstance = restartGroup.changed(traceInProgress);
                } else {
                    changedInstance = restartGroup.changedInstance(traceInProgress);
                }
                i6 = changedInstance != null ? 256 : 128;
            } else {
            }
            $dirty3 |= i6;
        }
        i4 = i10 & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
            title2 = title;
        } else {
            if (i48 & 3072 == 0) {
                i17 = restartGroup.changedInstance(title) ? 2048 : 1024;
                $dirty3 |= i17;
            } else {
                title2 = title;
            }
        }
        int i50 = i10 & 16;
        if (i50 != 0) {
            $dirty3 |= 24576;
            obj = headline;
        } else {
            if (i48 & 24576 == 0) {
                i = restartGroup.changedInstance(headline) ? 16384 : 8192;
                $dirty3 |= i;
            } else {
                obj = headline;
            }
        }
        i5 = i10 & 32;
        int i54 = 196608;
        if (i5 != 0) {
            $dirty3 |= i54;
            showModeToggle2 = showModeToggle;
        } else {
            if (i54 &= i48 == 0) {
                i16 = restartGroup.changed(showModeToggle) ? 131072 : 65536;
                $dirty3 |= i16;
            } else {
                showModeToggle2 = showModeToggle;
            }
        }
        if (i56 &= i48 == 0) {
            if (i10 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                value = colors;
            }
            $dirty3 |= changed;
        } else {
            value = colors;
        }
        if (i59 &= $dirty3 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                obj34 = -3670017;
                String str4 = "CC(remember):DatePicker.kt#9igjgp";
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i10 & 4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 255556878, str4);
                            i8 = restartGroup;
                            obj4 = 0;
                            Object rememberedValue2 = i8.rememberedValue();
                            i13 = 0;
                            obj28 = i32;
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                int i33 = 0;
                                i8.updateRememberedValue(DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, 0, 0, 0, 7, 0));
                            } else {
                                $i$a$CacheDatePickerKt$DatePicker$1 = rememberedValue2;
                            }
                            dateFormatter2 = $i$a$CacheDatePickerKt$DatePicker$1;
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty3 &= -897;
                        } else {
                            dateFormatter2 = dateFormatter;
                        }
                        if (i4 != 0) {
                            DatePickerKt.DatePicker.2 anon2 = new DatePickerKt.DatePicker.2(obj5);
                            obj28 = $dirty3;
                            title2 = $i$a$CacheDatePickerKt$DatePicker$1;
                        } else {
                            obj28 = $dirty3;
                            $dirty = 1;
                            i4 = 54;
                        }
                        if (i50 != 0) {
                            DatePickerKt.DatePicker.3 anon = new DatePickerKt.DatePicker.3(obj5, dateFormatter2);
                            obj = $i$a$CacheDatePickerKt$DatePicker$1;
                        }
                        if (i5 != 0) {
                            showModeToggle2 = $i$a$CacheDatePickerKt$DatePicker$1;
                        }
                        if (i10 & 64 != 0) {
                            $dirty3 = obj28 & obj34;
                            showModeToggle2 = colors3;
                            colors2 = z2;
                            obj3 = title2;
                            title2 = str;
                        } else {
                            $dirty3 = obj28;
                            obj3 = title2;
                            colors2 = showModeToggle2;
                            showModeToggle2 = value;
                            title2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (i10 & 64 != 0) {
                            dateFormatter2 = dateFormatter;
                            $dirty3 = i37;
                            obj3 = title2;
                            colors2 = showModeToggle2;
                            showModeToggle2 = value;
                            title2 = str;
                        } else {
                            dateFormatter2 = dateFormatter;
                            obj3 = title2;
                            colors2 = showModeToggle2;
                            showModeToggle2 = value;
                            title2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(809701813, $dirty3, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:188)");
                }
                Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 255580733, str4);
                composer = restartGroup;
                int i52 = 0;
                rememberedValue = composer.rememberedValue();
                int i60 = 0;
                if (!restartGroup.changed(defaultLocale)) {
                    obj28 = colors2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int showModeToggle3 = 0;
                        composer.updateRememberedValue(CalendarModel_androidKt.createCalendarModel(defaultLocale));
                    } else {
                        $i$a$CacheDatePickerKt$DatePicker$calendarModel$1 = rememberedValue;
                    }
                } else {
                    obj28 = colors2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(255587712);
                ComposerKt.sourceInformation(restartGroup, "197@9187L323");
                if (obj28 != null) {
                    DatePickerKt.DatePicker.4 anon4 = new DatePickerKt.DatePicker.4(obj5);
                    i5 = rememberComposableLambda;
                } else {
                    i5 = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                DatePickerKt.DatePicker.5 anon3 = new DatePickerKt.DatePicker.5(obj5, (CalendarModel)$i$a$CacheDatePickerKt$DatePicker$calendarModel$1, dateFormatter2, showModeToggle2);
                DatePickerKt.DateEntryContainer-au3_HiA(title2, obj3, obj, i5, showModeToggle2, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), restartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderContainerHeight-D9Ej5fM(), (Function2)ComposableLambdaKt.rememberComposableLambda(-1840727866, true, anon3, restartGroup, 54), restartGroup, i22 | obj5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                title3 = $dirty3;
                $dirty2 = calendarModel;
                z = obj28;
                obj7 = title2;
                obj2 = showModeToggle2;
                $composer2 = obj4;
                obj6 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                title3 = $dirty3;
                obj7 = str;
                $dirty2 = title2;
                z = showModeToggle2;
                obj2 = value;
                $composer2 = traceInProgress;
                obj6 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DatePickerKt.DatePicker.6(state, obj7, $composer2, $dirty2, obj6, z, obj2, i48, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void DatePickerContent(Long selectedDateMillis, long displayedMonthMillis, Function1<? super Long, Unit> onDateSelectionChange, Function1<? super Long, Unit> onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        Object it$iv;
        boolean traceInProgress2;
        Object composer$iv2;
        Integer currentCompositionLocalMap;
        Object $composer3;
        int l;
        Object compositionCoroutineScope;
        int i27;
        Object empty3;
        boolean rememberSaveable;
        Integer padding-VpY3zN4$default;
        Object i19;
        int $dirty;
        Function0 factory$iv$iv$iv2;
        Composer composer5;
        Object obj5;
        String formatMonthYear;
        Object obj7;
        Object it$iv3;
        Object it$iv2;
        Object obj6;
        Composer composer7;
        Composer composer3;
        Composer composer4;
        Object currentCompositionLocalMap2;
        int empty2;
        Object empty;
        int skipping;
        boolean traceInProgress;
        Function0 factory$iv$iv$iv3;
        Object obj3;
        int i9;
        int i32;
        Object obj;
        int i2;
        Object obj4;
        Composer composer6;
        Object columnMeasurePolicy;
        int i8;
        int i40;
        int i14;
        boolean changedInstance;
        int i31;
        Object obj2;
        int i13;
        int i44;
        int str;
        int restartGroup;
        int i29;
        int i15;
        int i5;
        int i36;
        int i24;
        Composer composer$iv;
        int i4;
        int displayedMonth;
        Object obj8;
        int i22;
        int i35;
        int i28;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        int i10;
        int currentCompositeKeyHash;
        int i33;
        int i3;
        int i43;
        Modifier $dirty2;
        Composer factory$iv$iv$iv;
        int i42;
        int i34;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Locale measurePolicy$iv;
        ColumnScopeInstance columnScopeInstance;
        int i18;
        androidx.compose.ui.Modifier.Companion companion2;
        Composer composer8;
        Modifier modifier;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        androidx.compose.ui.Modifier.Companion companion;
        Function0 function04;
        Alignment alignment;
        int monthsListState;
        int i21;
        int currentCompositeKeyHash2;
        Object companion5;
        Object companion3;
        Object obj9;
        Composer.Companion companion4;
        int invalid$iv;
        Composer $composer2;
        int i6;
        int i11;
        int i7;
        CoroutineScope coroutineScope;
        int i25;
        int i26;
        Function0 function03;
        int i37;
        BoxScopeInstance boxScopeInstance;
        Object yearPickerVisible$delegate;
        androidx.compose.runtime.CompositionLocalMap map3;
        androidx.compose.ui.layout.MeasurePolicy localMap$iv$iv2;
        boolean z;
        Modifier clipToBounds;
        EnterTransition plus;
        ExitTransition plus2;
        int i23;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i41;
        int i12;
        int i20;
        androidx.compose.runtime.CompositionLocalMap map2;
        Modifier modifier$iv2;
        Modifier modifier$iv;
        Function0 function02;
        androidx.compose.ui.layout.MeasurePolicy factory$iv$iv$iv4;
        androidx.compose.runtime.CompositionLocalMap map;
        Function0 function0;
        Composer composer2;
        int i38;
        int i16;
        int i30;
        int i39;
        int i;
        int i17;
        CalendarMonth obj95;
        l = displayedMonthMillis;
        obj7 = yearRange;
        obj6 = dateFormatter;
        empty = selectableDates;
        traceInProgress2 = obj96;
        i19 = -434467002;
        restartGroup = $changed.startRestartGroup(i19);
        ComposerKt.sourceInformation(restartGroup, "C(DatePickerContent)P(7,3,4,5!1,8,2,6)1488@68600L87,1489@68713L24,1490@68767L42,1491@68834L15,1492@68854L5031:DatePicker.kt#uh7d8r");
        if (traceInProgress2 & 6 == 0) {
            i9 = restartGroup.changed(selectedDateMillis) ? 4 : 2;
            $dirty |= i9;
        } else {
            obj5 = selectedDateMillis;
        }
        if (traceInProgress2 & 48 == 0) {
            i32 = restartGroup.changed(l) ? 32 : 16;
            $dirty |= i32;
        }
        if (traceInProgress2 & 384 == 0) {
            i2 = restartGroup.changedInstance(onDisplayedMonthChange) ? 256 : 128;
            $dirty |= i2;
        } else {
            obj = onDisplayedMonthChange;
        }
        if (traceInProgress2 & 3072 == 0) {
            i8 = restartGroup.changedInstance(calendarModel) ? 2048 : 1024;
            $dirty |= i8;
        } else {
            obj4 = calendarModel;
        }
        if (traceInProgress2 & 24576 == 0) {
            i40 = restartGroup.changedInstance(obj7) ? 16384 : 8192;
            $dirty |= i40;
        }
        if (i132 &= traceInProgress2 == 0) {
            i14 = restartGroup.changedInstance(obj6) ? 131072 : 65536;
            $dirty |= i14;
        }
        if (i133 &= traceInProgress2 == 0) {
            if (i134 &= traceInProgress2 == 0) {
                changedInstance = restartGroup.changed(empty);
            } else {
                changedInstance = restartGroup.changedInstance(empty);
            }
            i31 = changedInstance != null ? 1048576 : 524288;
            $dirty |= i31;
        }
        if (i136 &= traceInProgress2 == 0) {
            i13 = restartGroup.changed(colors) ? 8388608 : 4194304;
            $dirty |= i13;
        } else {
            obj2 = colors;
        }
        if (i139 &= traceInProgress2 == 0) {
            i44 = restartGroup.changed($composer) ? 67108864 : 33554432;
            $dirty |= i44;
        }
        if (i140 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i19, $dirty, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1485)");
                }
                CalendarMonth month = obj7.getMonth(l);
                int i141 = 0;
                LazyListState list = rememberLazyListState;
                int i106 = i141;
                int i143 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                Composer composer9 = restartGroup;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                Composer composer15 = restartGroup;
                int i153 = 0;
                int i154 = i71;
                compositionCoroutineScope = composer15.rememberedValue();
                int i162 = 0;
                if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                    empty3 = 0;
                    int i163 = 0;
                    obj8 = compositionCoroutineScope;
                    composer$iv = composer9;
                    composer$iv2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer9));
                    composer15.updateRememberedValue(composer$iv2);
                } else {
                    composer$iv = composer9;
                    composer$iv2 = obj8;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CoroutineScope coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)composer$iv2.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int wrapper$iv = 0;
                rememberSaveable = RememberSaveableKt.rememberSaveable(new Object[wrapper$iv], 0, 0, (Function0)DatePickerKt.DatePickerContent.yearPickerVisible.2.INSTANCE, restartGroup, 3072, 6);
                Composer composer14 = restartGroup;
                Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(composer14, wrapper$iv);
                i24 = wrapper$iv;
                i4 = 0;
                String str13 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer14, -483455358, str13);
                androidx.compose.ui.Modifier.Companion companion19 = Modifier.Companion;
                androidx.compose.foundation.layout.Arrangement.Vertical top2 = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top2, start, composer14, i146 | i151);
                i28 = 0;
                horizontal = start;
                String str6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composer14, -1323940314, str6);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer14, 0);
                currentCompositionLocalMap = composer14.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer14, (Modifier)companion19);
                Function0 function06 = constructor;
                i43 = 0;
                int i166 = $dirty;
                String $dirty4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer14, -692256719, $dirty4);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer14.startReusableNode();
                if (composer14.getInserting()) {
                    composer14.createNode(function06);
                } else {
                    factory$iv$iv$iv3 = function06;
                    composer14.useNode();
                }
                Composer composer16 = composer14;
                Composer constructor-impl2 = Updater.constructor-impl(composer16);
                int i155 = 0;
                Updater.set-impl(constructor-impl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i165 = 0;
                Composer composer19 = constructor-impl2;
                int i167 = 0;
                if (!composer19.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy2 = columnMeasurePolicy;
                    if (!Intrinsics.areEqual(composer19.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer19.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer19;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy2 = columnMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                i33 = i53 & 14;
                $composer3 = composer16;
                i42 = 0;
                String str11 = "C87@4365L9:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer3, -384862393, str11);
                i34 = i157 | 6;
                Composer composer18 = $composer3;
                columnScopeInstance = iNSTANCE5;
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart($composer3, -1437690694, "C1503@69381L511,1515@69926L520,1527@70488L42,1493@68871L1698,1531@70579L3300:DatePicker.kt#uh7d8r");
                modifier = materializeModifier3;
                int i121 = 2;
                if (empty.formatMonthYear(Long.valueOf(displayedMonthMillis), defaultLocale) == null) {
                    formatMonthYear = "-";
                }
                String str7 = "CC(remember):DatePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, 230729368, str7);
                Composer composer20 = $composer3;
                int i172 = 0;
                it$iv3 = composer20.rememberedValue();
                int i175 = 0;
                if (changedInstance2 |= changed6 == 0) {
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        int i105 = 0;
                        companion5 = it$iv3;
                        it$iv3 = new DatePickerKt.DatePickerContent.1.1.1(coroutineScope2, list);
                        composer20.updateRememberedValue((Function0)it$iv3);
                    } else {
                        companion5 = it$iv3;
                        composer7 = composer20;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 230746817, str7);
                changedInstance3 |= changed7;
                Composer composer21 = $composer3;
                int i173 = 0;
                it$iv2 = composer21.rememberedValue();
                int i176 = 0;
                if (empty2 == 0) {
                    invalid$iv = empty2;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        int invalid$iv2 = 0;
                        companion3 = it$iv2;
                        it$iv2 = new DatePickerKt.DatePickerContent.1.2.1(coroutineScope2, list);
                        composer21.updateRememberedValue((Function0)it$iv2);
                    } else {
                        companion3 = it$iv2;
                        composer3 = composer21;
                    }
                } else {
                    invalid$iv = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 230764323, str7);
                Composer composer13 = $composer3;
                int i169 = 0;
                it$iv = composer13.rememberedValue();
                int i177 = 0;
                if (!$composer3.changed(rememberSaveable)) {
                    $composer2 = $composer3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        $composer3 = 0;
                        obj9 = it$iv;
                        it$iv = new DatePickerKt.DatePickerContent.1.3.1(rememberSaveable);
                        composer13.updateRememberedValue((Function0)it$iv);
                    } else {
                        obj9 = it$iv;
                    }
                } else {
                    $composer2 = $composer3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                int i54 = 234881024;
                companion2 = companion19;
                Composer composer17 = $composer2;
                int i55 = -692256719;
                int i97 = -483455358;
                int i89 = i168;
                measurePolicy = measurePolicy2;
                measurePolicy$iv = defaultLocale;
                vertical = top2;
                function04 = function07;
                factory$iv$iv$iv = composer16;
                androidx.compose.material3.DatePickerColors $composer4 = $composer;
                DatePickerKt.MonthsNavigation(PaddingKt.padding-VpY3zN4$default((Modifier)Modifier.Companion, DatePickerKt.DatePickerHorizontalPadding, 0, i121, 0), list.getCanScrollForward(), list.getCanScrollBackward(), DatePickerKt.DatePickerContent$lambda$8((MutableState)rememberSaveable), formatMonthYear, (Function0)it$iv3, (Function0)it$iv2, (Function0)it$iv, $composer4, composer17, i87 |= 6);
                androidx.compose.material3.DatePickerColors date2 = $composer4;
                str = composer17;
                restartGroup = i164;
                i29 = 0;
                ComposerKt.sourceInformationMarkerStart(str, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion15 = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                int i131 = 0;
                androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i131);
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(str, -1323940314, str6);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(str, 0);
                currentCompositionLocalMap2 = str.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(str, (Modifier)companion15);
                Function0 function05 = constructor3;
                i6 = 0;
                ComposerKt.sourceInformationMarkerStart(str, -692256719, $dirty4);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                str.startReusableNode();
                if (str.getInserting()) {
                    str.createNode(function05);
                } else {
                    str.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(str);
                int i179 = 0;
                function03 = function05;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i180 = 0;
                Composer composer22 = constructor-impl;
                int i181 = 0;
                if (!composer22.getInserting()) {
                    yearPickerVisible$delegate = rememberSaveable;
                    map3 = currentCompositionLocalMap2;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer22;
                    }
                } else {
                    yearPickerVisible$delegate = rememberSaveable;
                    map3 = currentCompositionLocalMap2;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                i25 = i59 & 14;
                Composer composer10 = str;
                i26 = 0;
                ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i37 = i78 | 6;
                boxScopeInstance = iNSTANCE2;
                Composer composer11 = composer10;
                i20 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, 2145148451, "C1532@70597L683,1551@71579L2290,1546@71320L2549:DatePicker.kt#uh7d8r");
                companion = companion15;
                padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default((Modifier)Modifier.Companion, DatePickerKt.DatePickerHorizontalPadding, 0, 2, 0);
                companion4 = i90;
                int i182 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -483455358, str13);
                androidx.compose.foundation.layout.Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start2 = Alignment.Companion.getStart();
                androidx.compose.ui.layout.MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top, start2, composer11, i102 |= i160);
                int i183 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -1323940314, str6);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3 = composer11.getCurrentCompositionLocalMap();
                i22 = currentCompositeKeyHash3;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer11, padding-VpY3zN4$default);
                Function0 function08 = constructor2;
                int i186 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -692256719, $dirty4);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer11.startReusableNode();
                if (composer11.getInserting()) {
                    composer11.createNode(function08);
                } else {
                    factory$iv$iv$iv2 = function08;
                    composer11.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(composer11);
                int i178 = 0;
                Composer composer25 = composer11;
                Updater.set-impl(constructor-impl3, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i184 = 0;
                Composer composer26 = constructor-impl3;
                int i187 = 0;
                if (!composer26.getInserting()) {
                    modifier$iv2 = padding-VpY3zN4$default;
                    function02 = factory$iv$iv$iv2;
                    if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(i22))) {
                        composer26.updateRememberedValue(Integer.valueOf(i22));
                        constructor-impl3.apply(Integer.valueOf(i22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer26;
                    }
                } else {
                    modifier$iv2 = padding-VpY3zN4$default;
                    function02 = factory$iv$iv$iv2;
                }
                Updater.set-impl(constructor-impl3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i73 &= 14;
                Composer composer12 = composer25;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(composer12, -384862393, str11);
                i21 = i83 | 6;
                Composer propagateMinConstraints$iv2 = composer12;
                int i185 = 0;
                ColumnScopeInstance columnScopeInstance2 = iNSTANCE;
                ComposerKt.sourceInformationMarkerStart(propagateMinConstraints$iv2, 454425903, "C1533@70693L31,1534@70741L525:DatePicker.kt#uh7d8r");
                CalendarModel calendar2 = yearRange;
                DatePickerKt.WeekDays(date2, calendar2, propagateMinConstraints$iv2, i47 |= i115);
                int i51 = i166;
                $dirty2 = materializeModifier;
                map = currentCompositionLocalMap3;
                androidx.compose.foundation.layout.Arrangement.Vertical vertical2 = top;
                androidx.compose.ui.Alignment.Horizontal horizontal2 = start2;
                alignment = topStart;
                LazyListState $composer$iv2 = list2;
                map2 = map3;
                function0 = function02;
                monthsListState = i84;
                factory$iv$iv$iv4 = columnMeasurePolicy2;
                localMap$iv$iv2 = maybeCachedBoxMeasurePolicy;
                Modifier modifier2 = modifier$iv2;
                modifier$iv = obj95;
                displayedMonth = i51;
                int $dirty3 = 0;
                DatePickerKt.HorizontalMonthsList($composer$iv2, selectedDateMillis, onDisplayedMonthChange, calendarModel, calendar2, dateFormatter, selectableDates, colors, date2, propagateMinConstraints$iv2, i68 |= i171);
                ComposerKt.sourceInformationMarkerEnd(propagateMinConstraints$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer25.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer25);
                ComposerKt.sourceInformationMarkerEnd(composer25);
                ComposerKt.sourceInformationMarkerEnd(composer25);
                obj = 1;
                int i76 = 3;
                obj2 = composer25;
                DatePickerKt.DatePickerContent.1.4.2 anon = new DatePickerKt.DatePickerContent.1.4.2(displayedMonthMillis, i76, yearPickerVisible$delegate, coroutineScope2, $composer$iv2, dateFormatter, month, colors, yearRange, $composer);
                composer = obj2;
                AnimatedVisibilityKt.AnimatedVisibility(DatePickerKt.DatePickerContent$lambda$8(yearPickerVisible$delegate), ClipKt.clipToBounds((Modifier)Modifier.Companion), EnterExitTransitionKt.expandVertically$default(0, 0, false, 0, 15, 0).plus(EnterExitTransitionKt.fadeIn$default($dirty3, 1058642330, obj, $dirty3)), EnterExitTransitionKt.shrinkVertically$default(0, 0, false, 0, 15, 0).plus(EnterExitTransitionKt.fadeOut$default($dirty3, 0, i76, $dirty3)), 0, (Function3)ComposableLambdaKt.rememberComposableLambda(1193716082, obj, anon, obj2, 54), composer, 200112, 16);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                str.endNode();
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                factory$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd(factory$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(factory$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(factory$iv$iv$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                displayedMonth = $dirty;
                factory$iv$iv$iv = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = factory$iv$iv$iv.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DatePickerKt.DatePickerContent.2(selectedDateMillis, displayedMonthMillis, i19, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, obj96);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final boolean DatePickerContent$lambda$8(MutableState<Boolean> $yearPickerVisible$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)(State)$yearPickerVisible$delegate.getValue().booleanValue();
    }

    private static final void DatePickerContent$lambda$9(MutableState<Boolean> $yearPickerVisible$delegate, boolean value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $yearPickerVisible$delegate.setValue(Boolean.valueOf(value));
    }

    public static final void DatePickerHeader-pc5RIQQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, long titleContentColor, long headlineContentColor, float minHeight, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        androidx.compose.ui.Modifier.Companion anon;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        boolean traceInProgress2;
        Object provides;
        int $dirty;
        boolean currentCompositionLocalMap;
        Composer $composer$iv2;
        int i;
        int i4;
        int i11;
        int i3;
        int i5;
        int i10;
        int skipping;
        boolean traceInProgress;
        long iNSTANCE;
        Composer composer;
        int i7;
        long l;
        int horizontalAlignment$iv;
        Modifier heightModifier;
        Composer measurePolicy$iv;
        int textStyle;
        int i6;
        int i12;
        int i8;
        int i13;
        int i9;
        int i17;
        Modifier modifier3;
        int i16;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i15;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical;
        int i14;
        Function0 function0;
        int i2;
        Modifier modifier2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        Composer $composer$iv;
        TextStyle textStyle2;
        traceInProgress2 = modifier;
        provides = title;
        final float f = $composer;
        final Object obj2 = $changed;
        final int i37 = obj44;
        anon = -996037719;
        final Composer restartGroup = obj43.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(DatePickerHeader)P(3,4,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.Dp)1609@74344L539:DatePicker.kt#uh7d8r");
        if (i37 & 6 == 0) {
            i = restartGroup.changed(traceInProgress2) ? 4 : 2;
            $dirty |= i;
        }
        if (i37 & 48 == 0) {
            i4 = restartGroup.changedInstance(provides) ? 32 : 16;
            $dirty |= i4;
        }
        if (i37 & 384 == 0) {
            i11 = restartGroup.changed(titleContentColor) ? 256 : 128;
            $dirty |= i11;
        } else {
            l = titleContentColor;
        }
        if (i37 & 3072 == 0) {
            i3 = restartGroup.changed(minHeight) ? 2048 : 1024;
            $dirty |= i3;
        } else {
            iNSTANCE = minHeight;
        }
        if (i37 & 24576 == 0) {
            i5 = restartGroup.changed(f) ? 16384 : 8192;
            $dirty |= i5;
        }
        if (i31 &= i37 == 0) {
            i10 = restartGroup.changedInstance(obj2) ? 131072 : 65536;
            $dirty |= i10;
        }
        if (i32 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, $dirty, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1601)");
                }
                int i18 = 0;
                int i33 = 0;
                int i39 = 1;
                if (provides != null) {
                    heightModifier = SizeKt.defaultMinSize-VpY3zN4$default((Modifier)Modifier.Companion, i33, f, i39, i18);
                } else {
                    heightModifier = Modifier.Companion;
                }
                Modifier then = SizeKt.fillMaxWidth$default(traceInProgress2, i33, i39, i18).then(heightModifier);
                androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                i6 = i40;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                horizontalAlignment$iv = Alignment.Companion.getStart();
                androidx.compose.ui.layout.MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)spaceBetween, horizontalAlignment$iv, restartGroup, i43 |= i46);
                i13 = 0;
                i9 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                i17 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, then);
                modifier3 = then;
                Function0 function02 = constructor;
                i15 = 0;
                horizontalOrVertical = spaceBetween;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i50 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i51 = 0;
                Composer composer2 = constructor-impl;
                int i52 = 0;
                if (!composer2.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(i17))) {
                        composer2.updateRememberedValue(Integer.valueOf(i17));
                        constructor-impl.apply(Integer.valueOf(i17), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer2;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                $composer$iv2 = restartGroup;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                iNSTANCE = ColumnScopeInstance.INSTANCE;
                i36 |= 6;
                measurePolicy = columnMeasurePolicy;
                measurePolicy$iv = $composer$iv2;
                i14 = 0;
                i2 = i23;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(measurePolicy$iv, 1243392968, "C1619@74785L92:DatePicker.kt#uh7d8r");
                measurePolicy$iv.startReplaceGroup(594298678);
                ComposerKt.sourceInformation(measurePolicy$iv, "1614@74573L5,1615@74677L89,1615@74591L175");
                if (provides != null) {
                    DatePickerKt.DatePickerHeader.1.1 anon2 = new DatePickerKt.DatePickerHeader.1.1(provides);
                    $composer$iv = $composer$iv2;
                    anon = companion7;
                    horizontal = horizontalAlignment$iv;
                    ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(l, obj12, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont(), measurePolicy$iv, 6), (Function2)ComposableLambdaKt.rememberComposableLambda(1936268514, true, anon2, measurePolicy$iv, 54), measurePolicy$iv);
                } else {
                    $composer$iv = $composer$iv2;
                    horizontal = horizontalAlignment$iv;
                    anon = heightModifier;
                }
                measurePolicy$iv.endReplaceGroup();
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(minHeight)), obj2, measurePolicy$iv, $stable |= l);
                ComposerKt.sourceInformationMarkerEnd(measurePolicy$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i9 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new DatePickerKt.DatePickerHeader.2(modifier, title, titleContentColor, skipping, minHeight, i7, f, obj2, i37);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    public static final androidx.compose.material3.DatePickerState DatePickerState-sHin3Bw(Locale locale, Long initialSelectedDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, androidx.compose.material3.SelectableDates selectableDates) {
        DatePickerStateImpl datePickerStateImpl = new DatePickerStateImpl(initialSelectedDateMillis, initialDisplayedMonthMillis, yearRange, initialDisplayMode, selectableDates, locale, 0);
        return (DatePickerState)datePickerStateImpl;
    }

    public static androidx.compose.material3.DatePickerState DatePickerState-sHin3Bw$default(Locale locale, Long long2, Long long3, IntRange intRange4, int i5, androidx.compose.material3.SelectableDates selectableDates6, int i7, Object object8) {
        int obj1;
        int obj2;
        IntRange obj3;
        int obj4;
        androidx.compose.material3.SelectableDates obj5;
        androidx.compose.material3.SelectableDates obj7;
        if (i7 & 2 != 0) {
            obj1 = 0;
        }
        if (i7 & 4 != 0) {
            obj2 = obj1;
        }
        if (i7 & 8 != 0) {
            obj3 = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if (i7 & 16 != 0) {
            obj4 = DisplayMode.Companion.getPicker-jFl-4v0();
        }
        if (i7 &= 32 != 0) {
            obj7 = obj5;
        } else {
            obj7 = selectableDates6;
        }
        return DatePickerKt.DatePickerState-sHin3Bw(locale, obj1, obj2, obj3, obj4, obj7);
    }

    private static final void Day(Modifier modifier, boolean selected, Function0<Unit> onClick, boolean animateChecked, boolean enabled, boolean today, boolean inRange, String description, androidx.compose.material3.DatePickerColors colors, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        boolean traceInProgress2;
        Object $i$a$CacheDatePickerKt$Day$1;
        boolean z2;
        int i12;
        int i15;
        int $dirty2;
        boolean skipping;
        boolean traceInProgress;
        int i9;
        int i2;
        int i5;
        int i3;
        boolean z;
        Object $composer2;
        int i13;
        boolean $composer3;
        Composer todayDateBorderColor-0d7_KjU;
        int i6;
        int i8;
        boolean z3;
        Object obj2;
        Object obj4;
        int i17;
        Object obj3;
        int i14;
        int i4;
        Object obj;
        int str;
        int i7;
        int i;
        int $dirty;
        Composer composer;
        int i16;
        int companion;
        int i11;
        int i10;
        final Object obj5 = modifier;
        z2 = selected;
        obj2 = description;
        obj4 = content;
        i17 = $changed;
        i12 = -1434777861;
        $composer2 = $composer.startRestartGroup(i12);
        ComposerKt.sourceInformation($composer2, "C(Day)P(6,8,7!1,4,9,5,3)1931@87580L114,1936@87780L5,1939@87839L83,1943@88006L190,1959@88508L319,1922@87151L1676:DatePicker.kt#uh7d8r");
        if (i17 & 6 == 0) {
            i2 = $composer2.changed(obj5) ? 4 : 2;
            $dirty2 |= i2;
        }
        if (i17 & 48 == 0) {
            i5 = $composer2.changed(z2) ? 32 : 16;
            $dirty2 |= i5;
        }
        if (i17 & 384 == 0) {
            i3 = $composer2.changedInstance(onClick) ? 256 : 128;
            $dirty2 |= i3;
        } else {
            obj3 = onClick;
        }
        if (i17 & 3072 == 0) {
            i13 = $composer2.changed(animateChecked) ? 2048 : 1024;
            $dirty2 |= i13;
        } else {
            z = animateChecked;
        }
        if (i17 & 24576 == 0) {
            i6 = $composer2.changed(enabled) ? 16384 : 8192;
            $dirty2 |= i6;
        } else {
            $composer3 = enabled;
        }
        if (i63 &= i17 == 0) {
            i8 = $composer2.changed(today) ? 131072 : 65536;
            $dirty2 |= i8;
        }
        if (i64 &= i17 == 0) {
            i14 = $composer2.changed(inRange) ? 1048576 : 524288;
            $dirty2 |= i14;
        } else {
            z3 = inRange;
        }
        if (i67 &= i17 == 0) {
            i4 = $composer2.changed(obj2) ? 8388608 : 4194304;
            $dirty2 |= i4;
        }
        if (i68 &= i17 == 0) {
            i7 = $composer2.changed(colors) ? 67108864 : 33554432;
            $dirty2 |= i7;
        } else {
            obj = colors;
        }
        if (i70 &= i17 == 0) {
            i = $composer2.changedInstance(obj4) ? 536870912 : 268435456;
            $dirty2 |= i;
        }
        $dirty = $dirty2;
        if ($dirty3 &= $dirty == 306783378) {
            if (!$composer2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, $dirty, -1, "androidx.compose.material3.Day (DatePicker.kt:1921)");
                }
                ComposerKt.sourceInformationMarkerStart($composer2, 67481739, "CC(remember):DatePicker.kt#9igjgp");
                i15 = i26 &= $dirty == 8388608 ? 1 : 0;
                Composer composer2 = $composer2;
                int i71 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i72 = 0;
                if (i15 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion = i18;
                        $i$a$CacheDatePickerKt$Day$1 = new DatePickerKt.Day.1.1(obj2);
                        composer2.updateRememberedValue((Function1)$i$a$CacheDatePickerKt$Day$1);
                    } else {
                        $i$a$CacheDatePickerKt$Day$1 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                todayDateBorderColor-0d7_KjU = $composer2;
                State dayContentColor$material3_release = colors.dayContentColor$material3_release(today, selected, z3, enabled, todayDateBorderColor-0d7_KjU, i23 |= i40);
                Composer composer3 = todayDateBorderColor-0d7_KjU;
                if (today && !selected) {
                    if (!selected) {
                        obj = i9;
                    } else {
                        obj = i9;
                    }
                } else {
                }
                DatePickerKt.Day.2 anon = new DatePickerKt.Day.2(obj4);
                z3 = 1;
                i10 = $dirty;
                SurfaceKt.Surface-d85dljk(selected, onClick, SemanticsModifierKt.semantics(obj5, true, (Function1)$i$a$CacheDatePickerKt$Day$1), enabled, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), $composer2, 6), (Color)obj.dayContainerColor$material3_release(z2, $composer3, z, $composer2, i32 |= i48).getValue().unbox-impl(), z3, (Color)dayContentColor$material3_release.getValue().unbox-impl(), obj4, 0, 0, obj, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-2031780827, z3, anon, composer3, 54), composer3, i54 |= i62);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                composer = $composer2;
                i10 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DatePickerKt.Day.3(obj5, selected, onClick, animateChecked, enabled, today, inRange, description, colors, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void DisplayModeToggleButton-tER2X8s(Modifier modifier, int displayMode, Function1<? super androidx.compose.material3.DisplayMode, Unit> onDisplayModeChange, Composer $composer, int $changed) {
        int anon;
        int i;
        int i6;
        int i8;
        boolean skipping;
        boolean traceInProgress;
        Object obj;
        int str;
        int i4;
        int i3;
        int i7;
        Object lambda-1$material3_release;
        int i5;
        Object anon3;
        Object anon2;
        int i2;
        Object obj10;
        int obj13;
        anon = 1393846115;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(DisplayModeToggleButton)P(1,0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i = restartGroup.changed(modifier) ? 4 : 2;
            obj13 |= i;
        }
        if ($changed & 48 == 0) {
            i6 = restartGroup.changed(displayMode) ? 32 : 16;
            obj13 |= i6;
        }
        int i20 = 256;
        if ($changed & 384 == 0) {
            i8 = restartGroup.changedInstance(onDisplayModeChange) ? i20 : 128;
            obj13 |= i8;
        }
        if (obj13 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, obj13, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1355)");
                }
                int i19 = 196608;
                i4 = 1;
                int i23 = 0;
                String str4 = "CC(remember):DatePicker.kt#9igjgp";
                if (DisplayMode.equals-impl0(displayMode, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    restartGroup.startReplaceGroup(-411460444);
                    ComposerKt.sourceInformation(restartGroup, "1357@63035L42,1357@63014L262");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -428914158, str4);
                    if (obj13 & 896 == i20) {
                    } else {
                        i4 = i23;
                    }
                    Composer composer = restartGroup;
                    int i21 = 0;
                    Object rememberedValue = composer.rememberedValue();
                    int i24 = 0;
                    if (i4 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            lambda-1$material3_release = 0;
                            anon3 = new DatePickerKt.DisplayModeToggleButton.1.1(onDisplayModeChange);
                            composer.updateRememberedValue((Function0)anon3);
                        } else {
                            anon3 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    IconButtonKt.IconButton((Function0)anon3, modifier, false, 0, 0, ComposableSingletons.DatePickerKt.INSTANCE.getLambda-1$material3_release(), restartGroup, i13 |= i19, 28);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-411178437);
                    ComposerKt.sourceInformation(restartGroup, "1364@63319L43,1364@63298L271");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -428905069, str4);
                    if (obj13 & 896 == i20) {
                    } else {
                        i4 = i23;
                    }
                    Composer composer2 = restartGroup;
                    int i22 = 0;
                    Object rememberedValue2 = composer2.rememberedValue();
                    int i25 = 0;
                    if (i4 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            lambda-1$material3_release = 0;
                            anon2 = new DatePickerKt.DisplayModeToggleButton.2.1(onDisplayModeChange);
                            composer2.updateRememberedValue((Function0)anon2);
                        } else {
                            anon2 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    IconButtonKt.IconButton((Function0)anon2, modifier, false, 0, 0, ComposableSingletons.DatePickerKt.INSTANCE.getLambda-2$material3_release(), restartGroup, i18 |= i19, 28);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj = modifier;
            }
        } else {
        }
        obj10 = restartGroup.endRestartGroup();
        if (obj10 != null) {
            anon = new DatePickerKt.DisplayModeToggleButton.3(obj, displayMode, onDisplayModeChange, $changed);
            obj10.updateScope((Function2)anon);
        }
    }

    private static final void HorizontalMonthsList(LazyListState lazyListState, Long selectedDateMillis, Function1<? super Long, Unit> onDateSelectionChange, Function1<? super Long, Unit> onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress;
        Object today;
        int i11;
        Object anon;
        int empty;
        Object obj8;
        Composer composer;
        int $dirty;
        Object i6;
        Object obj4;
        int i9;
        Object obj6;
        int i8;
        Object obj5;
        Object today2;
        Object obj7;
        int i5;
        int i13;
        int i7;
        int i;
        int i12;
        Object obj3;
        boolean changedInstance;
        int i16;
        Object obj;
        int i15;
        boolean skipping;
        boolean traceInProgress2;
        int rememberedValue;
        int i3;
        int i4;
        int str;
        Object obj2;
        int i2;
        int i14;
        int i10;
        Object companion;
        obj4 = calendarModel;
        today2 = yearRange;
        obj7 = dateFormatter;
        rememberedValue = $changed;
        traceInProgress = -1994757941;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(HorizontalMonthsList)P(3,7,4,5!1,8,2,6)1639@75443L158,1645@75663L5,1645@75670L1365,1645@75606L1429,1676@77071L228,1676@77041L258:DatePicker.kt#uh7d8r");
        if (rememberedValue & 6 == 0) {
            i9 = restartGroup.changed(lazyListState) ? 4 : 2;
            $dirty |= i9;
        }
        if (rememberedValue & 48 == 0) {
            i8 = restartGroup.changed(selectedDateMillis) ? 32 : 16;
            $dirty |= i8;
        } else {
            obj6 = selectedDateMillis;
        }
        if (rememberedValue & 384 == 0) {
            i5 = restartGroup.changedInstance(onDateSelectionChange) ? 256 : 128;
            $dirty |= i5;
        } else {
            obj5 = onDateSelectionChange;
        }
        if (rememberedValue & 3072 == 0) {
            i13 = restartGroup.changedInstance(onDisplayedMonthChange) ? 2048 : 1024;
            $dirty |= i13;
        } else {
            obj2 = onDisplayedMonthChange;
        }
        if (rememberedValue & 24576 == 0) {
            i7 = restartGroup.changedInstance(obj4) ? 16384 : 8192;
            $dirty |= i7;
        }
        if (i29 &= rememberedValue == 0) {
            i = restartGroup.changedInstance(today2) ? 131072 : 65536;
            $dirty |= i;
        }
        if (i30 &= rememberedValue == 0) {
            if (i33 &= rememberedValue == 0) {
                changedInstance = restartGroup.changed(obj7);
            } else {
                changedInstance = restartGroup.changedInstance(obj7);
            }
            i12 = changedInstance != null ? 1048576 : 524288;
            $dirty |= i12;
        }
        if (i31 &= rememberedValue == 0) {
            i16 = restartGroup.changed(selectableDates) ? 8388608 : 4194304;
            $dirty |= i16;
        } else {
            obj3 = selectableDates;
        }
        if (i35 &= rememberedValue == 0) {
            i15 = restartGroup.changed(colors) ? 67108864 : 33554432;
            $dirty |= i15;
        } else {
            obj = colors;
        }
        if (i37 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1636)");
                }
                androidx.compose.material3.internal.CalendarDate today3 = obj4.getToday();
                String str3 = "CC(remember):DatePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1217547306, str3);
                i2 = restartGroup;
                i14 = 0;
                Object rememberedValue2 = i2.rememberedValue();
                i10 = 0;
                if (!restartGroup.changed(today2)) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue = 0;
                        companion = today3;
                        i2.updateRememberedValue(obj4.getMonth(today2.getFirst(), 1));
                    } else {
                        companion = today3;
                        today = rememberedValue2;
                        composer = i2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object obj10 = today;
                i4 = $dirty;
                Object $dirty2 = today2;
                DatePickerKt.HorizontalMonthsList.1 firstMonth = new DatePickerKt.HorizontalMonthsList.1(lazyListState, $dirty2, obj4, obj10, obj5, companion, selectedDateMillis, obj7, obj3, obj);
                obj7 = obj10;
                today2 = $dirty2;
                obj6 = 1;
                TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), restartGroup, 6), (Function2)ComposableLambdaKt.rememberComposableLambda(1504086906, obj6, firstMonth, restartGroup, 54), restartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1217495140, str3);
                int i23 = 0;
                i11 = i4 & 14 == 4 ? obj6 : i23;
                i3 = i4 & 7168 == 2048 ? obj6 : i23;
                obj3 = restartGroup;
                skipping = 0;
                rememberedValue = obj3.rememberedValue();
                str = 0;
                if (i20 |= changedInstance3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i2 = 0;
                        anon = new DatePickerKt.HorizontalMonthsList.2.1(lazyListState, obj2, obj4, today2, 0);
                        obj3.updateRememberedValue((Function2)anon);
                    } else {
                        obj8 = lazyListState;
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(obj8, (Function2)anon, restartGroup, i4 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i4 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DatePickerKt.HorizontalMonthsList.3(obj8, selectedDateMillis, onDateSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Month(CalendarMonth month, Function1<? super Long, Unit> onDateSelectionChange, long todayMillis, Long startDateMillis, Long endDateMillis, androidx.compose.material3.SelectedRangeInfo rangeSelectionInfo, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        boolean traceInProgress2;
        Modifier drawWithContent;
        Integer currentCompositionLocalMap;
        int measurePolicy$iv;
        int measurePolicy$iv2;
        androidx.compose.ui.layout.MeasurePolicy dayIndex2;
        int i20;
        int i37;
        Composer i14;
        Object str5;
        Function0 factory$iv$iv$iv2;
        String $composer$iv;
        int $composer4;
        Composer cellIndex;
        Object obj5;
        Composer composer3;
        Object rememberedValue;
        int i55;
        boolean selectableYear;
        int i21;
        Locale verticalAlignment$iv2;
        int i46;
        Object $i$a$CacheDatePickerKt$Month$1$1$2;
        String string;
        int empty;
        androidx.compose.ui.Alignment.Vertical defaultLocale;
        Object verticalArrangement$iv;
        Integer currentCompositionLocalMap2;
        Composer dayContentDescription;
        Object mutableStateOf$default;
        int materialized$iv$iv;
        Modifier materializeModifier;
        Modifier cellIndex2;
        int requiredSize-VpY3zN4;
        int daysFromStartOfWeekToFirstOfMonth;
        Object str3;
        int factory$iv$iv$iv;
        int i19;
        int empty2;
        Composer str7;
        Function0 $composer5;
        int obj6;
        Composer composer6;
        int i22;
        int $changed2;
        String formatDate;
        int i43;
        Object rowMeasurePolicy;
        Object obj7;
        Object str6;
        int i24;
        Composer restartGroup;
        androidx.compose.ui.Modifier.Companion $composer6;
        Object valueOf;
        Composer composer8;
        int $dirty;
        androidx.compose.ui.Alignment.Vertical verticalAlignment$iv;
        Object obj4;
        Function0 factory$iv$iv$iv3;
        String skipping;
        boolean traceInProgress;
        int i5;
        int i26;
        int i6;
        int i27;
        int i28;
        int i33;
        boolean changedInstance;
        int i36;
        Object obj3;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv3;
        int i31;
        int i47;
        int $composer3;
        androidx.compose.material3.DatePickerColors date;
        int $dirty2;
        androidx.compose.ui.Modifier.Companion numberOfDays;
        int cmp;
        androidx.compose.ui.Modifier.Companion companion2;
        int i17;
        int i18;
        int i34;
        Composer composer5;
        Composer composer7;
        int dayIndex;
        int companion3;
        Modifier modifier4;
        int i8;
        int i13;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical2;
        int i10;
        int i45;
        int currentCompositeKeyHash;
        int i51;
        Modifier modifier3;
        int i9;
        Function0 function0;
        int i25;
        int i30;
        int i11;
        int i54;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i49;
        ColumnScopeInstance columnScopeInstance;
        Composer composer4;
        Modifier modifier;
        int i32;
        int i50;
        int i40;
        int i38;
        int i15;
        int i;
        int i7;
        int currentCompositeKeyHash2;
        String str4;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical;
        int i35;
        int i16;
        Modifier modifier5;
        int i41;
        String str2;
        int i2;
        RowScopeInstance rowScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i29;
        int i23;
        int isToday;
        int i3;
        String startDateSelected;
        int i4;
        long longValue2;
        long longValue3;
        int inRange;
        int i42;
        int cmp2;
        boolean z;
        Locale locale;
        Composer composer;
        Composer $composer2;
        int invalid$iv;
        Composer composer2;
        String str;
        Modifier modifier2;
        int i12;
        int i56;
        int i39;
        int i48;
        long longValue;
        int i44;
        Composer.Companion companion;
        Object obj;
        int invalid$iv2;
        int i52;
        Object obj2;
        int i53;
        boolean obj95;
        obj6 = dateFormatter;
        obj7 = selectableDates;
        valueOf = $composer;
        traceInProgress2 = obj96;
        i14 = -1912870997;
        restartGroup = $changed.startRestartGroup(i14);
        ComposerKt.sourceInformation(restartGroup, "C(Month)P(3,4,8,7,2,5,1,6)1773@80392L15,1775@80434L5256:DatePicker.kt#uh7d8r");
        if (traceInProgress2 & 6 == 0) {
            i5 = restartGroup.changed(month) ? 4 : 2;
            $dirty |= i5;
        } else {
            obj4 = month;
        }
        if (traceInProgress2 & 48 == 0) {
            i26 = restartGroup.changedInstance(onDateSelectionChange) ? 32 : 16;
            $dirty |= i26;
        }
        if (traceInProgress2 & 384 == 0) {
            i6 = restartGroup.changed(todayMillis) ? 256 : 128;
            $dirty |= i6;
        }
        if (traceInProgress2 & 3072 == 0) {
            i27 = restartGroup.changed(endDateMillis) ? 2048 : 1024;
            $dirty |= i27;
        }
        if (traceInProgress2 & 24576 == 0) {
            i28 = restartGroup.changed(rangeSelectionInfo) ? 16384 : 8192;
            $dirty |= i28;
        }
        if (i113 &= traceInProgress2 == 0) {
            i33 = restartGroup.changed(obj6) ? 131072 : 65536;
            $dirty |= i33;
        }
        if (i114 &= traceInProgress2 == 0) {
            if (i115 &= traceInProgress2 == 0) {
                changedInstance = restartGroup.changed(obj7);
            } else {
                changedInstance = restartGroup.changedInstance(obj7);
            }
            i36 = changedInstance != null ? 1048576 : 524288;
            $dirty |= i36;
        }
        if (i117 &= traceInProgress2 == 0) {
            i31 = restartGroup.changed(colors) ? 8388608 : 4194304;
            $dirty |= i31;
        } else {
            obj3 = colors;
        }
        if (traceInProgress2 & i126 == 0) {
            i47 = restartGroup.changed(valueOf) ? 67108864 : 33554432;
            $dirty |= i47;
        }
        if ($dirty & $composer3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i14, $dirty, -1, "androidx.compose.material3.Month (DatePicker.kt:1762)");
                }
                restartGroup.startReplaceGroup(1821406531);
                ComposerKt.sourceInformation(restartGroup, "1765@80175L143");
                i18 = 458752;
                i34 = 234881024;
                if (obj6 != null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1821408684, "CC(remember):DatePicker.kt#9igjgp");
                    i20 = $dirty & i18 == 131072 ? 1 : 0;
                    i37 = $dirty & i34 == 67108864 ? 1 : 0;
                    measurePolicy$iv3 = restartGroup;
                    $dirty2 = 0;
                    Object rememberedValue3 = measurePolicy$iv3.rememberedValue();
                    dayIndex = 0;
                    if (i135 | i37 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            verticalAlignment$iv2 = 0;
                            verticalArrangement$iv = new DatePickerKt.Month.rangeSelectionDrawModifier.1.1(obj6, valueOf);
                            measurePolicy$iv3.updateRememberedValue((Function1)verticalArrangement$iv);
                        } else {
                            verticalArrangement$iv = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    drawWithContent = DrawModifierKt.drawWithContent((Modifier)Modifier.Companion, (Function1)verticalArrangement$iv);
                } else {
                    drawWithContent = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                verticalAlignment$iv2 = CalendarLocale_androidKt.defaultLocale(restartGroup, 0);
                int other$iv2 = 0;
                dayIndex = i71;
                Modifier then = SizeKt.requiredHeight-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl(f *= recommendedSizeForAccessibility2)).then(drawWithContent);
                androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                int i83 = 48;
                companion3 = 0;
                modifier4 = drawWithContent;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                i13 = 0;
                horizontal = start;
                horizontalOrVertical2 = spaceEvenly;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                modifier3 = then;
                Function0 function02 = constructor;
                i25 = 0;
                i30 = i73;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv2 = function02;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv$iv2;
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                $dirty2 = 0;
                Updater.set-impl(constructor-impl2, ColumnKt.columnMeasurePolicy((Arrangement.Vertical)spaceEvenly, start, restartGroup, i121 |= i129), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i17 = 0;
                Composer composer12 = constructor-impl2;
                int i139 = 0;
                if (!composer12.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer12;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(restartGroup, then), ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = restartGroup;
                obj6 = 0;
                i11 = i59;
                ComposerKt.sourceInformationMarkerStart(composer9, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i54 = i102 | 6;
                valueOf = composer9;
                i49 = 0;
                columnScopeInstance = iNSTANCE;
                ComposerKt.sourceInformationMarkerStart(valueOf, 1402700144, "C:DatePicker.kt#uh7d8r");
                valueOf.startReplaceGroup(-647488269);
                ComposerKt.sourceInformation(valueOf, "*1782@80726L4948");
                measurePolicy$iv = 0;
                while (measurePolicy$iv < i30) {
                    $dirty2 = $dirty;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0);
                    androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
                    i40 = i17;
                    i38 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    rowMeasurePolicy = RowKt.rowMeasurePolicy((Arrangement.Horizontal)spaceEvenly2, Alignment.Companion.getCenterVertically(), valueOf, i91 |= i105);
                    i7 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, verticalArrangement$iv);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(valueOf, 0);
                    currentCompositionLocalMap2 = valueOf.getCurrentCompositionLocalMap();
                    horizontalOrVertical = spaceEvenly2;
                    int i137 = 6;
                    i16 = 0;
                    modifier5 = fillMaxWidth$default;
                    ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, str3);
                    if (!applier instanceof Applier) {
                    }
                    valueOf.startReusableNode();
                    if (valueOf.getInserting()) {
                    } else {
                    }
                    valueOf.useNode();
                    Composer constructor-impl = Updater.constructor-impl(valueOf);
                    numberOfDays = 0;
                    Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i140 = 0;
                    Composer composer13 = constructor-impl;
                    int i141 = 0;
                    if (!composer13.getInserting()) {
                    } else {
                    }
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = rowMeasurePolicy;
                    composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf, fillMaxWidth$default), ComposeUiNode.Companion.getSetModifier());
                    dayContentDescription = valueOf;
                    factory$iv$iv$iv = 0;
                    i41 = i62;
                    ComposerKt.sourceInformationMarkerStart(dayContentDescription, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    int i138 = 6;
                    i95 |= 6;
                    composer = dayContentDescription;
                    i2 = 0;
                    rowScopeInstance = iNSTANCE2;
                    ComposerKt.sourceInformationMarkerStart(dayContentDescription, 1553857275, $composer$iv);
                    dayContentDescription.startReplaceGroup(-88422904);
                    ComposerKt.sourceInformation(dayContentDescription, "");
                    measurePolicy$iv2 = 0;
                    $composer4 = dayIndex;
                    while (measurePolicy$iv2 < 7) {
                        if ($composer4 >= month.getDaysFromStartOfWeekToFirstOfMonth()) {
                        } else {
                        }
                        dayIndex = measurePolicy$iv2;
                        i12 = $composer4;
                        composer = verticalAlignment$iv2;
                        i56 = factory$iv$iv$iv;
                        i15 = i22;
                        composer7 = restartGroup;
                        cellIndex = valueOf;
                        defaultLocale = verticalAlignment$iv;
                        $composer5 = factory$iv$iv$iv3;
                        startDateSelected = skipping;
                        dayIndex2 = measurePolicy$iv3;
                        i45 = $dirty2;
                        i21 = 1;
                        i24 = -1323940314;
                        isToday = 2;
                        inRange = 0;
                        i39 = 131072;
                        i48 = 32;
                        dayContentDescription.startReplaceGroup(1554022070);
                        ComposerKt.sourceInformation(dayContentDescription, "1794@81308L315");
                        SpacerKt.Spacer(SizeKt.requiredSize-VpY3zN4((Modifier)Modifier.Companion, DatePickerKt.RecommendedSizeForAccessibility, DatePickerKt.RecommendedSizeForAccessibility), dayContentDescription, 6);
                        dayContentDescription.endReplaceGroup();
                        obj5 = onDateSelectionChange;
                        obj7 = selectableDates;
                        obj3 = colors;
                        measurePolicy$iv3 = dayIndex2;
                        valueOf = cellIndex;
                        verticalAlignment$iv = defaultLocale;
                        $composer4 = i85;
                        factory$iv$iv$iv3 = $composer5;
                        measurePolicy$iv2 = i99;
                        restartGroup = composer7;
                        $dirty2 = i45;
                        i22 = i15;
                        skipping = startDateSelected;
                        verticalAlignment$iv2 = composer;
                        cellIndex2 = modifier2;
                        factory$iv$iv$iv = i56;
                        if ($composer4 >= daysFromStartOfWeekToFirstOfMonth2 += numberOfDays) {
                        } else {
                        }
                        dayContentDescription.startReplaceGroup(1554536112);
                        ComposerKt.sourceInformation(dayContentDescription, "1822@82897L365,1838@83755L39,1844@84162L550,1862@85212L376,1835@83586L2002");
                        requiredSize-VpY3zN4 = $composer4 - daysFromStartOfWeekToFirstOfMonth3;
                        dayIndex = measurePolicy$iv2;
                        i12 = $composer4;
                        int i65 = i23;
                        if (Long.compare(i65, todayMillis) == 0) {
                        } else {
                        }
                        i3 = 0;
                        if (endDateMillis == null) {
                        } else {
                        }
                        if (Long.compare(i65, longValue2) == 0) {
                        } else {
                        }
                        i4 = 0;
                        if (rangeSelectionInfo == null) {
                        } else {
                        }
                        if (Long.compare(i65, longValue3) == 0) {
                        } else {
                        }
                        longValue3 = 0;
                        i56 = factory$iv$iv$iv;
                        dayContentDescription.startReplaceGroup(-88387804);
                        ComposerKt.sourceInformation(dayContentDescription, "1810@82233L435");
                        if (dateFormatter != null) {
                        } else {
                        }
                        $composer2 = dayContentDescription;
                        i15 = i22;
                        $changed2 = 0;
                        z = 0;
                        $composer2.endReplaceGroup();
                        if (dateFormatter != null) {
                        } else {
                        }
                        i29 = 0;
                        String dayContentDescription2 = DatePickerKt.dayContentDescription(i29, i3, i4, longValue3, z, $composer2, 0);
                        Composer composer10 = $composer2;
                        if (obj7.formatDate(Long.valueOf(i65), verticalAlignment$iv2, true) == null) {
                        }
                        androidx.compose.ui.Modifier.Companion companion14 = Modifier.Companion;
                        if (i4 == 0) {
                        } else {
                        }
                        companion2 = companion14;
                        valueOf = 1;
                        composer = verticalAlignment$iv2;
                        ComposerKt.sourceInformationMarkerStart(composer10, -88337598, skipping);
                        if ($dirty2 & 112 == 32) {
                        } else {
                        }
                        i46 = 0;
                        i46 |= changed10;
                        obj95 = composer10;
                        int i143 = 0;
                        Object rememberedValue5 = obj95.rememberedValue();
                        int i144 = 0;
                        if (empty == 0) {
                        } else {
                        }
                        invalid$iv2 = empty;
                        companion = invalid$iv3;
                        $i$a$CacheDatePickerKt$Month$1$1$2 = new DatePickerKt.Month.1.1.1.1(obj5, i65, $composer4);
                        obj95.updateRememberedValue((Function0)$i$a$CacheDatePickerKt$Month$1$1$2);
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        ComposerKt.sourceInformationMarkerStart(composer10, -88324063, skipping);
                        str6 = composer10;
                        invalid$iv = 0;
                        rememberedValue = str6.rememberedValue();
                        int i145 = 0;
                        if (!composer10.changed(i65)) {
                        } else {
                        }
                        obj = $i$a$CacheDatePickerKt$Month$1$1$2;
                        i52 = 0;
                        obj2 = rememberedValue;
                        i53 = i81;
                        $i$a$CacheDatePickerKt$Month$1$1$2 = companion;
                        if ($i$a$CacheDatePickerKt$Month$1$1$2.isSelectableYear(month.getYear()) && $i$a$CacheDatePickerKt$Month$1$1$2.isSelectableDate(i65)) {
                        } else {
                        }
                        i55 = 0;
                        str6.updateRememberedValue(Boolean.valueOf(i55));
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        if (dayContentDescription2 != null) {
                        } else {
                        }
                        string = formatDate;
                        DatePickerKt.Month.1.1.3 anon = new DatePickerKt.Month.1.1.3(requiredSize-VpY3zN4);
                        i44 = i65;
                        composer7 = restartGroup;
                        cellIndex = composer11;
                        i45 = $dirty2;
                        i24 = -1323940314;
                        isToday = 2;
                        i39 = 131072;
                        i48 = 32;
                        numberOfDays = composer10;
                        defaultLocale = verticalAlignment$iv;
                        $composer5 = factory$iv$iv$iv3;
                        dayIndex2 = measurePolicy$iv3;
                        inRange = 0;
                        startDateSelected = skipping;
                        DatePickerKt.Day(companion2, valueOf, obj, i4, (Boolean)rememberedValue.booleanValue(), i3, z, string, $composer, (Function2)ComposableLambdaKt.rememberComposableLambda(-2095706591, true, anon, composer10, 54), numberOfDays, i76 |= i97);
                        numberOfDays.endReplaceGroup();
                        i43 = 6;
                        StringBuilder stringBuilder = new StringBuilder();
                        string = stringBuilder.append(dayContentDescription2).append(", ").append(formatDate).toString();
                        if ($i$a$CacheDatePickerKt$Month$1$1$2.isSelectableDate(i65)) {
                        } else {
                        }
                        i55 = 1;
                        obj = $i$a$CacheDatePickerKt$Month$1$1$2;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                        } else {
                        }
                        obj2 = rememberedValue;
                        invalid$iv2 = empty;
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        } else {
                        }
                        composer3 = obj95;
                        $i$a$CacheDatePickerKt$Month$1$1$2 = rememberedValue5;
                        i46 = 1;
                        if (longValue3 != 0) {
                        } else {
                        }
                        companion2 = companion14;
                        valueOf = 0;
                        formatDate = "";
                        i29 = 1;
                        ComposerKt.sourceInformationMarkerStart(dayContentDescription, -88385906, skipping);
                        $composer2 = dayContentDescription;
                        if ($dirty2 & i18 == 131072) {
                        } else {
                        }
                        i19 = 0;
                        i19 |= changed7;
                        $composer3 = $composer2;
                        cmp = 0;
                        mutableStateOf$default = $composer3.rememberedValue();
                        i23 = 0;
                        if (empty2 == 0) {
                        } else {
                        }
                        invalid$iv = empty2;
                        if (endDateMillis != null) {
                        } else {
                        }
                        longValue = Long.MAX_VALUE;
                        if (Long.compare(i65, longValue) >= 0) {
                        } else {
                        }
                        i42 = 0;
                        i48 = mutableStateOf$default;
                        inRange = invalid$iv4;
                        i15 = i22;
                        $changed2 = 0;
                        $composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i42), $changed2, 2, $changed2));
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        z = dayContentDescription;
                        if (rangeSelectionInfo != null) {
                        } else {
                        }
                        longValue = Long.MIN_VALUE;
                        if (Long.compare(i65, longValue) <= 0) {
                        } else {
                        }
                        i42 = 1;
                        longValue = rangeSelectionInfo.longValue();
                        longValue = endDateMillis.longValue();
                        invalid$iv = empty2;
                        if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                        } else {
                        }
                        i48 = mutableStateOf$default;
                        i15 = i22;
                        str7 = $composer3;
                        $changed2 = 0;
                        i19 = 1;
                        longValue3 = 1;
                        i4 = 1;
                        i3 = 1;
                        dayIndex = measurePolicy$iv2;
                        i12 = $composer4;
                        composer = verticalAlignment$iv2;
                        i56 = factory$iv$iv$iv;
                        i15 = i22;
                        composer7 = restartGroup;
                        cellIndex = valueOf;
                        defaultLocale = verticalAlignment$iv;
                        $composer5 = factory$iv$iv$iv3;
                        startDateSelected = skipping;
                        dayIndex2 = measurePolicy$iv3;
                        i45 = $dirty2;
                        i21 = 1;
                        i24 = -1323940314;
                        isToday = 2;
                        inRange = 0;
                        i39 = 131072;
                        i48 = 32;
                    }
                    int i136 = measurePolicy$iv2;
                    i56 = factory$iv$iv$iv;
                    i15 = i22;
                    composer7 = restartGroup;
                    Composer cellIndex4 = valueOf;
                    androidx.compose.ui.Alignment.Vertical defaultLocale3 = verticalAlignment$iv;
                    Function0 $i$a$LayoutRowKt$Row$1$iv2 = factory$iv$iv$iv3;
                    startDateSelected = skipping;
                    androidx.compose.ui.layout.MeasurePolicy dayIndex4 = measurePolicy$iv3;
                    int i79 = 1;
                    int i98 = -1323940314;
                    isToday = 2;
                    inRange = 0;
                    i39 = 131072;
                    i48 = 32;
                    dayContentDescription.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(dayContentDescription);
                    ComposerKt.sourceInformationMarkerEnd(dayContentDescription);
                    cellIndex4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(cellIndex4);
                    ComposerKt.sourceInformationMarkerEnd(cellIndex4);
                    ComposerKt.sourceInformationMarkerEnd(cellIndex4);
                    obj4 = month;
                    obj5 = onDateSelectionChange;
                    obj7 = selectableDates;
                    obj3 = colors;
                    measurePolicy$iv = verticalAlignment$iv3;
                    i30 = $changed3;
                    $dirty = i45;
                    materializeModifier = modifier;
                    obj6 = i50;
                    verticalArrangement$iv = str4;
                    str3 = str2;
                    verticalAlignment$iv2 = locale;
                    $composer$iv = str;
                    dayIndex = i12;
                    if ($composer4 >= month.getDaysFromStartOfWeekToFirstOfMonth()) {
                    } else {
                    }
                    dayIndex = measurePolicy$iv2;
                    i12 = $composer4;
                    composer = verticalAlignment$iv2;
                    i56 = factory$iv$iv$iv;
                    i15 = i22;
                    composer7 = restartGroup;
                    cellIndex = valueOf;
                    defaultLocale = verticalAlignment$iv;
                    $composer5 = factory$iv$iv$iv3;
                    startDateSelected = skipping;
                    dayIndex2 = measurePolicy$iv3;
                    i45 = $dirty2;
                    i21 = 1;
                    i24 = -1323940314;
                    isToday = 2;
                    inRange = 0;
                    i39 = 131072;
                    i48 = 32;
                    dayContentDescription.startReplaceGroup(1554022070);
                    ComposerKt.sourceInformation(dayContentDescription, "1794@81308L315");
                    SpacerKt.Spacer(SizeKt.requiredSize-VpY3zN4((Modifier)Modifier.Companion, DatePickerKt.RecommendedSizeForAccessibility, DatePickerKt.RecommendedSizeForAccessibility), dayContentDescription, 6);
                    dayContentDescription.endReplaceGroup();
                    obj5 = onDateSelectionChange;
                    obj7 = selectableDates;
                    obj3 = colors;
                    measurePolicy$iv3 = dayIndex2;
                    valueOf = cellIndex;
                    verticalAlignment$iv = defaultLocale;
                    $composer4 = i85;
                    factory$iv$iv$iv3 = $composer5;
                    measurePolicy$iv2 = i99;
                    restartGroup = composer7;
                    $dirty2 = i45;
                    i22 = i15;
                    skipping = startDateSelected;
                    verticalAlignment$iv2 = composer;
                    cellIndex2 = modifier2;
                    factory$iv$iv$iv = i56;
                    if ($composer4 >= daysFromStartOfWeekToFirstOfMonth2 += numberOfDays) {
                    } else {
                    }
                    dayContentDescription.startReplaceGroup(1554536112);
                    ComposerKt.sourceInformation(dayContentDescription, "1822@82897L365,1838@83755L39,1844@84162L550,1862@85212L376,1835@83586L2002");
                    requiredSize-VpY3zN4 = $composer4 - daysFromStartOfWeekToFirstOfMonth3;
                    dayIndex = measurePolicy$iv2;
                    i12 = $composer4;
                    i65 = i23;
                    if (Long.compare(i65, todayMillis) == 0) {
                    } else {
                    }
                    i3 = 0;
                    if (endDateMillis == null) {
                    } else {
                    }
                    if (Long.compare(i65, longValue2) == 0) {
                    } else {
                    }
                    i4 = 0;
                    if (rangeSelectionInfo == null) {
                    } else {
                    }
                    if (Long.compare(i65, longValue3) == 0) {
                    } else {
                    }
                    longValue3 = 0;
                    i56 = factory$iv$iv$iv;
                    dayContentDescription.startReplaceGroup(-88387804);
                    ComposerKt.sourceInformation(dayContentDescription, "1810@82233L435");
                    if (dateFormatter != null) {
                    } else {
                    }
                    $composer2 = dayContentDescription;
                    i15 = i22;
                    $changed2 = 0;
                    z = 0;
                    $composer2.endReplaceGroup();
                    if (dateFormatter != null) {
                    } else {
                    }
                    i29 = 0;
                    dayContentDescription2 = DatePickerKt.dayContentDescription(i29, i3, i4, longValue3, z, $composer2, 0);
                    composer10 = $composer2;
                    if (obj7.formatDate(Long.valueOf(i65), verticalAlignment$iv2, true) == null) {
                    }
                    companion14 = Modifier.Companion;
                    if (i4 == 0) {
                    } else {
                    }
                    companion2 = companion14;
                    valueOf = 1;
                    composer = verticalAlignment$iv2;
                    ComposerKt.sourceInformationMarkerStart(composer10, -88337598, skipping);
                    if ($dirty2 & 112 == 32) {
                    } else {
                    }
                    i46 = 0;
                    i46 |= changed10;
                    obj95 = composer10;
                    i143 = 0;
                    rememberedValue5 = obj95.rememberedValue();
                    i144 = 0;
                    if (empty == 0) {
                    } else {
                    }
                    invalid$iv2 = empty;
                    companion = invalid$iv3;
                    $i$a$CacheDatePickerKt$Month$1$1$2 = new DatePickerKt.Month.1.1.1.1(obj5, i65, $composer4);
                    obj95.updateRememberedValue((Function0)$i$a$CacheDatePickerKt$Month$1$1$2);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    ComposerKt.sourceInformationMarkerStart(composer10, -88324063, skipping);
                    str6 = composer10;
                    invalid$iv = 0;
                    rememberedValue = str6.rememberedValue();
                    i145 = 0;
                    if (!composer10.changed(i65)) {
                    } else {
                    }
                    obj = $i$a$CacheDatePickerKt$Month$1$1$2;
                    i52 = 0;
                    obj2 = rememberedValue;
                    i53 = i81;
                    $i$a$CacheDatePickerKt$Month$1$1$2 = companion;
                    if ($i$a$CacheDatePickerKt$Month$1$1$2.isSelectableYear(month.getYear()) && $i$a$CacheDatePickerKt$Month$1$1$2.isSelectableDate(i65)) {
                    } else {
                    }
                    i55 = 0;
                    str6.updateRememberedValue(Boolean.valueOf(i55));
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    if (dayContentDescription2 != null) {
                    } else {
                    }
                    string = formatDate;
                    anon = new DatePickerKt.Month.1.1.3(requiredSize-VpY3zN4);
                    i44 = i65;
                    composer7 = restartGroup;
                    cellIndex = composer11;
                    i45 = $dirty2;
                    i24 = -1323940314;
                    isToday = 2;
                    i39 = 131072;
                    i48 = 32;
                    numberOfDays = composer10;
                    defaultLocale = verticalAlignment$iv;
                    $composer5 = factory$iv$iv$iv3;
                    dayIndex2 = measurePolicy$iv3;
                    inRange = 0;
                    startDateSelected = skipping;
                    DatePickerKt.Day(companion2, valueOf, obj, i4, (Boolean)rememberedValue.booleanValue(), i3, z, string, $composer, (Function2)ComposableLambdaKt.rememberComposableLambda(-2095706591, true, anon, composer10, 54), numberOfDays, i76 |= i97);
                    numberOfDays.endReplaceGroup();
                    i43 = 6;
                    stringBuilder = new StringBuilder();
                    string = stringBuilder.append(dayContentDescription2).append(", ").append(formatDate).toString();
                    if ($i$a$CacheDatePickerKt$Month$1$1$2.isSelectableDate(i65)) {
                    } else {
                    }
                    i55 = 1;
                    obj = $i$a$CacheDatePickerKt$Month$1$1$2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    } else {
                    }
                    obj2 = rememberedValue;
                    invalid$iv2 = empty;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    } else {
                    }
                    composer3 = obj95;
                    $i$a$CacheDatePickerKt$Month$1$1$2 = rememberedValue5;
                    i46 = 1;
                    if (longValue3 != 0) {
                    } else {
                    }
                    companion2 = companion14;
                    valueOf = 0;
                    formatDate = "";
                    i29 = 1;
                    ComposerKt.sourceInformationMarkerStart(dayContentDescription, -88385906, skipping);
                    $composer2 = dayContentDescription;
                    if ($dirty2 & i18 == 131072) {
                    } else {
                    }
                    i19 = 0;
                    i19 |= changed7;
                    $composer3 = $composer2;
                    cmp = 0;
                    mutableStateOf$default = $composer3.rememberedValue();
                    i23 = 0;
                    if (empty2 == 0) {
                    } else {
                    }
                    invalid$iv = empty2;
                    if (endDateMillis != null) {
                    } else {
                    }
                    longValue = Long.MAX_VALUE;
                    if (Long.compare(i65, longValue) >= 0) {
                    } else {
                    }
                    i42 = 0;
                    i48 = mutableStateOf$default;
                    inRange = invalid$iv4;
                    i15 = i22;
                    $changed2 = 0;
                    $composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i42), $changed2, 2, $changed2));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    z = dayContentDescription;
                    if (rangeSelectionInfo != null) {
                    } else {
                    }
                    longValue = Long.MIN_VALUE;
                    if (Long.compare(i65, longValue) <= 0) {
                    } else {
                    }
                    i42 = 1;
                    longValue = rangeSelectionInfo.longValue();
                    longValue = endDateMillis.longValue();
                    invalid$iv = empty2;
                    if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                    } else {
                    }
                    i48 = mutableStateOf$default;
                    i15 = i22;
                    str7 = $composer3;
                    $changed2 = 0;
                    i19 = 1;
                    longValue3 = 1;
                    i4 = 1;
                    i3 = 1;
                    dayIndex = measurePolicy$iv2;
                    i12 = $composer4;
                    composer = verticalAlignment$iv2;
                    i56 = factory$iv$iv$iv;
                    i15 = i22;
                    composer7 = restartGroup;
                    cellIndex = valueOf;
                    defaultLocale = verticalAlignment$iv;
                    $composer5 = factory$iv$iv$iv3;
                    startDateSelected = skipping;
                    dayIndex2 = measurePolicy$iv3;
                    i45 = $dirty2;
                    i21 = 1;
                    i24 = -1323940314;
                    isToday = 2;
                    inRange = 0;
                    i39 = 131072;
                    i48 = 32;
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = rowMeasurePolicy;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    } else {
                    }
                    composer6 = composer13;
                    valueOf.createNode(ComposeUiNode.Companion.getConstructor());
                    ComposablesKt.invalidApplier();
                }
                i32 = measurePolicy$iv;
                locale = verticalAlignment$iv2;
                i50 = obj6;
                composer5 = restartGroup;
                i14 = valueOf;
                i10 = $dirty;
                androidx.compose.ui.layout.MeasurePolicy weekIndex2 = measurePolicy$iv3;
                i14.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(i14);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer5 = restartGroup;
                i10 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DatePickerKt.Month.2(month, onDateSelectionChange, todayMillis, verticalArrangement$iv, endDateMillis, rangeSelectionInfo, dateFormatter, selectableDates, colors, $composer, obj96);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void MonthsNavigation(Modifier modifier, boolean nextAvailable, boolean previousAvailable, boolean yearPickerVisible, String yearPickerText, Function0<Unit> onNextClicked, Function0<Unit> onPreviousClicked, Function0<Unit> onYearPickerButtonClicked, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        boolean traceInProgress2;
        boolean rowMeasurePolicy;
        Object $composer$iv;
        int $dirty;
        int rememberComposableLambda;
        boolean traceInProgress;
        androidx.compose.foundation.layout.Arrangement.Horizontal spaceBetween;
        Composer composer;
        Object currentCompositionLocalMap;
        int i8;
        int i9;
        int i6;
        int i15;
        int i16;
        int i3;
        Object obj4;
        int z2;
        Object obj2;
        Object obj3;
        boolean z3;
        int i7;
        Object obj;
        boolean z;
        int i17;
        Object obj5;
        int i10;
        int str;
        androidx.compose.ui.Alignment.Vertical centerVertically;
        int i13;
        int i18;
        int i14;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical;
        int currentCompositeKeyHash;
        int i11;
        Modifier modifier3;
        int i4;
        int i5;
        int i;
        Function0 function0;
        RowScopeInstance rowScopeInstance;
        int i2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int i12;
        Modifier modifier2;
        Composer composer2;
        $composer$iv = modifier;
        z2 = yearPickerVisible;
        final int i39 = $changed;
        traceInProgress2 = -773929258;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(MonthsNavigation)P(1,2,6,8,7,3,4,5)2131@95632L2049:DatePicker.kt#uh7d8r");
        if (i39 & 6 == 0) {
            i8 = restartGroup.changed($composer$iv) ? 4 : 2;
            $dirty |= i8;
        }
        if (i39 & 48 == 0) {
            i9 = restartGroup.changed(nextAvailable) ? 32 : 16;
            $dirty |= i9;
        } else {
            z = nextAvailable;
        }
        if (i39 & 384 == 0) {
            i6 = restartGroup.changed(previousAvailable) ? 256 : 128;
            $dirty |= i6;
        } else {
            z3 = previousAvailable;
        }
        if (i39 & 3072 == 0) {
            i15 = restartGroup.changed(z2) ? 2048 : 1024;
            $dirty |= i15;
        }
        if (i39 & 24576 == 0) {
            i16 = restartGroup.changed(yearPickerText) ? 16384 : 8192;
            $dirty |= i16;
        } else {
            obj2 = yearPickerText;
        }
        if (i30 &= i39 == 0) {
            i3 = restartGroup.changedInstance(onNextClicked) ? 131072 : 65536;
            $dirty |= i3;
        } else {
            obj3 = onNextClicked;
        }
        if (i31 &= i39 == 0) {
            i7 = restartGroup.changedInstance(onPreviousClicked) ? 1048576 : 524288;
            $dirty |= i7;
        } else {
            obj4 = onPreviousClicked;
        }
        if (i37 &= i39 == 0) {
            i17 = restartGroup.changedInstance(onYearPickerButtonClicked) ? 8388608 : 4194304;
            $dirty |= i17;
        } else {
            obj = onYearPickerButtonClicked;
        }
        if (i40 &= i39 == 0) {
            i10 = restartGroup.changed(colors) ? 67108864 : 33554432;
            $dirty |= i10;
        } else {
            obj5 = colors;
        }
        int i42 = $dirty;
        if ($dirty2 &= i42 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i42, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2130)");
                }
                Modifier requiredHeight-3ABfNKs = SizeKt.requiredHeight-3ABfNKs(SizeKt.fillMaxWidth$default($composer$iv, 0, 1, 0), DatePickerKt.MonthYearHeight);
                if (z2) {
                    spaceBetween = Arrangement.INSTANCE.getStart();
                } else {
                    spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                }
                i13 = 384;
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.Companion.getCenterVertically(), restartGroup, i25 |= i46);
                i14 = 0;
                horizontalOrVertical = spaceBetween;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, requiredHeight-3ABfNKs);
                modifier3 = requiredHeight-3ABfNKs;
                Function0 function02 = constructor;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i48 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i49 = 0;
                Composer composer6 = constructor-impl;
                int i50 = 0;
                if (!composer6.getInserting()) {
                    measurePolicy$iv = rowMeasurePolicy;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer6;
                    }
                } else {
                    measurePolicy$iv = rowMeasurePolicy;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                i4 = 0;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i = i35 | 6;
                rowScopeInstance = iNSTANCE;
                Composer composer4 = composer3;
                i2 = 0;
                i12 = i23;
                ComposerKt.sourceInformationMarkerStart(composer4, -857484277, "C2141@96047L1628,2141@95964L1711:DatePicker.kt#uh7d8r");
                modifier2 = materializeModifier;
                $composer$iv = composer5;
                DatePickerKt.MonthsNavigation.1.1 $composer2 = new DatePickerKt.MonthsNavigation.1.1(obj, yearPickerVisible, obj2, onPreviousClicked, z3, obj3, z);
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(obj5.getNavigationContentColor-0d7_KjU())), (Function2)ComposableLambdaKt.rememberComposableLambda(-962805198, true, $composer2, $composer$iv, 54), $composer$iv, $stable |= 48);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DatePickerKt.MonthsNavigation.2(modifier, nextAvailable, previousAvailable, yearPickerVisible, yearPickerText, onNextClicked, onPreviousClicked, onYearPickerButtonClicked, obj5, i39);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void SwitchableDateEntryContent-d7iavvg(Long selectedDateMillis, long displayedMonthMillis, int displayMode, Function1<? super Long, Unit> onDateSelectionChange, Function1<? super Long, Unit> onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        boolean traceInProgress2;
        boolean traceInProgress;
        int $dirty;
        androidx.compose.material3.DisplayMode str;
        Object invalid$iv;
        Object obj5;
        int i5;
        long l;
        int i13;
        int i14;
        int i11;
        Object str2;
        int i8;
        Object obj7;
        int i;
        Object obj3;
        Object obj;
        int i6;
        Object obj6;
        int i9;
        int i10;
        Object obj4;
        boolean changedInstance;
        Composer restartGroup;
        Object i3;
        Object empty;
        int i2;
        int i12;
        Object obj2;
        int i4;
        Composer composer;
        Modifier semantics$default;
        int i7;
        boolean companion;
        int obj31;
        obj = selectableDates;
        i3 = obj32;
        restartGroup = $changed.startRestartGroup(-895379221);
        ComposerKt.sourceInformation(restartGroup, "C(SwitchableDateEntryContent)P(8,4,3:c#material3.DisplayMode,5,6!1,9,2,7)*1393@64365L7,1401@64621L2301,1445@66979L1081,1394@64401L3659:DatePicker.kt#uh7d8r");
        if (i3 & 6 == 0) {
            i5 = restartGroup.changed(selectedDateMillis) ? 4 : 2;
            $dirty |= i5;
        } else {
            obj5 = selectedDateMillis;
        }
        if (i3 & 48 == 0) {
            i14 = restartGroup.changed(displayedMonthMillis) ? 32 : 16;
            $dirty |= i14;
        } else {
            l = displayedMonthMillis;
        }
        if (i3 & 384 == 0) {
            i11 = restartGroup.changed(onDateSelectionChange) ? 256 : 128;
            $dirty |= i11;
        } else {
            i2 = onDateSelectionChange;
        }
        if (i3 & 3072 == 0) {
            i8 = restartGroup.changedInstance(onDisplayedMonthChange) ? 2048 : 1024;
            $dirty |= i8;
        } else {
            str2 = onDisplayedMonthChange;
        }
        if (i3 & 24576 == 0) {
            i = restartGroup.changedInstance(calendarModel) ? 16384 : 8192;
            $dirty |= i;
        } else {
            obj7 = calendarModel;
        }
        if (i36 &= i3 == 0) {
            i6 = restartGroup.changedInstance(yearRange) ? 131072 : 65536;
            $dirty |= i6;
        } else {
            obj3 = yearRange;
        }
        if (i38 &= i3 == 0) {
            i9 = restartGroup.changedInstance(dateFormatter) ? 1048576 : 524288;
            $dirty |= i9;
        } else {
            obj6 = dateFormatter;
        }
        if (i40 &= i3 == 0) {
            if (i43 &= i3 == 0) {
                changedInstance = restartGroup.changed(obj);
            } else {
                changedInstance = restartGroup.changedInstance(obj);
            }
            i10 = changedInstance != null ? 8388608 : 4194304;
            $dirty |= i10;
        }
        if (i41 &= i3 == 0) {
            i12 = restartGroup.changed(colors) ? 67108864 : 33554432;
            $dirty |= i12;
        } else {
            obj4 = colors;
        }
        if (i45 &= i3 == 0) {
            i4 = restartGroup.changed($composer) ? 536870912 : 268435456;
            $dirty |= i4;
        } else {
            obj2 = $composer;
        }
        int i47 = $dirty;
        if ($dirty2 &= i47 == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-895379221, i47, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1390)");
                }
                obj31 = i19;
                int i48 = i26;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i49 = 0;
                obj31 = i20;
                int $this$SwitchableDateEntryContent_d7iavvg_u24lambda_u246 = -roundToPx-0680j_4;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -742574493, "CC(remember):DatePicker.kt#9igjgp");
                boolean changed = restartGroup.changed($this$SwitchableDateEntryContent_d7iavvg_u24lambda_u246);
                Composer composer2 = restartGroup;
                Object rememberedValue = composer2.rememberedValue();
                i7 = 0;
                if (!changed) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        companion = changed;
                        invalid$iv = new DatePickerKt.SwitchableDateEntryContent.2.1($this$SwitchableDateEntryContent_d7iavvg_u24lambda_u246);
                        composer2.updateRememberedValue((Function1)invalid$iv);
                    } else {
                        companion = changed;
                        invalid$iv = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj2 = i22;
                DatePickerKt.SwitchableDateEntryContent.3 parallaxTarget = new DatePickerKt.SwitchableDateEntryContent.3(selectedDateMillis, displayedMonthMillis, 0, str2, obj7, obj3, obj6, obj, obj4, obj2);
                obj = restartGroup;
                AnimatedContentKt.AnimatedContent(DisplayMode.box-impl(i2), SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)DatePickerKt.SwitchableDateEntryContent.1.INSTANCE, 1, 0), (Function1)invalid$iv, 0, "DatePickerDisplayModeAnimation", 0, (Function4)ComposableLambdaKt.rememberComposableLambda(-459778869, true, parallaxTarget, restartGroup, 54), obj, i17 | i24, 40);
                composer = obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DatePickerKt.SwitchableDateEntryContent.4(selectedDateMillis, displayedMonthMillis, l, i2, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void WeekDays(androidx.compose.material3.DatePickerColors colors, CalendarModel calendarModel, Composer $composer, int $changed) {
        int traceInProgress;
        ArrayList verticalAlignment$iv;
        boolean currentCompositionLocalMap2;
        Object restartGroup;
        int measurePolicy$iv;
        Function0 factory$iv$iv$iv2;
        int $dirty;
        int i16;
        int i8;
        boolean $i$a$LayoutRowKt$Row$1$iv;
        boolean traceInProgress2;
        boolean weekdayNames;
        Object it$iv;
        Composer composer;
        Object valueOf;
        int str;
        Composer composer6;
        Object arrayList;
        Modifier modifier$iv2;
        int i23;
        int i15;
        Modifier materializeModifier;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical spaceEvenly;
        androidx.compose.ui.Alignment.Vertical centerVertically;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Composer factory$iv$iv$iv;
        String str4;
        int localMap$iv$iv;
        Function0 function03;
        int i19;
        int i27;
        Composer composer7;
        int $composer2;
        boolean inserting;
        Object obj3;
        int materialized$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap map;
        int factory$iv$iv$iv4;
        int i26;
        int horizontalArrangement$iv;
        int i28;
        int $composer3;
        TextStyle value;
        Composer composer3;
        int localMap$iv$iv3;
        int materialized$iv$iv;
        int factory$iv$iv$iv3;
        int i4;
        int i9;
        int i18;
        int i29;
        int currentCompositeKeyHash2;
        int i17;
        int i11;
        int i33;
        int i2;
        int i10;
        Composer composer2;
        List weekdays;
        ArrayList list;
        int i;
        int i31;
        int i22;
        RowScopeInstance rowScopeInstance;
        Composer composer8;
        int i34;
        Object obj;
        ArrayList $this$fastForEach$iv;
        int i24;
        int i35;
        int i32;
        int i12;
        Modifier modifier$iv;
        Object obj2;
        int i7;
        int i5;
        int i3;
        int i6;
        int currentCompositeKeyHash;
        Modifier modifier;
        Function0 function0;
        int i20;
        int i13;
        String str2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        Alignment alignment;
        int i21;
        int i25;
        BoxScopeInstance boxScopeInstance;
        Composer composer5;
        int i30;
        int i14;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical;
        String str3;
        Composer composer4;
        androidx.compose.runtime.CompositionLocalMap map2;
        Modifier modifier2;
        Function0 function02;
        androidx.compose.ui.Alignment.Vertical vertical;
        int obj89;
        final Object obj4 = colors;
        final Object obj5 = calendarModel;
        final int i36 = $changed;
        traceInProgress = -1849465391;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(WeekDays)P(1)1719@78602L5,1721@78613L974:DatePicker.kt#uh7d8r");
        if (i36 & 6 == 0) {
            i16 = restartGroup.changed(obj4) ? 4 : 2;
            $dirty |= i16;
        }
        if (i36 & 48 == 0) {
            i8 = restartGroup.changedInstance(obj5) ? 32 : 16;
            $dirty |= i8;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1708)");
                }
                int firstDayOfWeek = obj5.getFirstDayOfWeek();
                weekdayNames = obj5.getWeekdayNames();
                arrayList = new ArrayList();
                i23 = firstDayOfWeek + -1;
                while (i23 < weekdayNames.size()) {
                    arrayList.add(weekdayNames.get(i23));
                    i23++;
                }
                i15 = 0;
                while (i15 < firstDayOfWeek + -1) {
                    arrayList.add(weekdayNames.get(i15));
                    i15++;
                }
                int i62 = 6;
                int i64 = 0;
                int i65 = 1;
                int i71 = 0;
                i4 = i66;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i29 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj89 = i62;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                Function0 function04 = constructor;
                i33 = 0;
                i2 = firstDayOfWeek;
                i10 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function04);
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i81 = 0;
                composer2 = restartGroup;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy((Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceEvenly(), Alignment.Companion.getCenterVertically(), restartGroup, i69 |= i73), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i82 = 0;
                composer7 = constructor-impl;
                $composer2 = 0;
                if (!composer7.getInserting()) {
                    weekdays = weekdayNames;
                    list = arrayList;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer7;
                    }
                } else {
                    weekdays = weekdayNames;
                    list = arrayList;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, SizeKt.fillMaxWidth$default(SizeKt.defaultMinSize-VpY3zN4$default((Modifier)Modifier.Companion, i64, DatePickerKt.RecommendedSizeForAccessibility, i65, i71), i64, i65, i71)), ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = composer2;
                i = i38;
                ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i57 |= 6;
                i22 = 0;
                rowScopeInstance = iNSTANCE;
                function03 = function04;
                factory$iv$iv$iv = composer15;
                ComposerKt.sourceInformationMarkerStart(factory$iv$iv$iv, -603629529, "C:DatePicker.kt#uh7d8r");
                factory$iv$iv$iv.startReplaceGroup(396170355);
                ComposerKt.sourceInformation(factory$iv$iv$iv, "*1730@78979L33,1728@78897L674");
                i31 = i46;
                measurePolicy$iv = (List)list.size();
                i34 = i50;
                $i$a$LayoutRowKt$Row$1$iv = i27;
                while ($i$a$LayoutRowKt$Row$1$iv < measurePolicy$iv) {
                    Object $this$fastForEach$iv2 = obj;
                    i24 = 0;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv$iv, -1458727475, "CC(remember):DatePicker.kt#9igjgp");
                    Composer composer11 = factory$iv$iv$iv;
                    int i83 = 0;
                    it$iv = composer11.rememberedValue();
                    int i87 = 0;
                    if (!factory$iv$iv$iv.changed((Pair)$this$fastForEach$iv2)) {
                    } else {
                    }
                    modifier$iv = modifier$iv2;
                    modifier$iv2 = 0;
                    obj3 = it$iv;
                    it$iv = new DatePickerKt.WeekDays.1.1.1.1($this$fastForEach$iv2);
                    composer11.updateRememberedValue((Function1)it$iv);
                    ComposerKt.sourceInformationMarkerEnd(factory$iv$iv$iv);
                    Modifier size-VpY3zN4 = SizeKt.size-VpY3zN4(SemanticsModifierKt.clearAndSetSemantics((Modifier)Modifier.Companion, (Function1)it$iv), DatePickerKt.RecommendedSizeForAccessibility, DatePickerKt.RecommendedSizeForAccessibility);
                    valueOf = Alignment.Companion.getCenter();
                    int i60 = 0;
                    i7 = i58;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv$iv, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    int i40 = 0;
                    i3 = 0;
                    i6 = i40;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv$iv, -1323940314, str4);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(factory$iv$iv$iv, 0);
                    currentCompositionLocalMap2 = factory$iv$iv$iv.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(factory$iv$iv$iv, size-VpY3zN4);
                    modifier = size-VpY3zN4;
                    Function0 function07 = constructor2;
                    i20 = 0;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv$iv, -692256719, $dirty);
                    if (!applier2 instanceof Applier) {
                    }
                    factory$iv$iv$iv.startReusableNode();
                    if (factory$iv$iv$iv.getInserting()) {
                    } else {
                    }
                    factory$iv$iv$iv2 = function07;
                    factory$iv$iv$iv.useNode();
                    function0 = factory$iv$iv$iv2;
                    Composer constructor-impl2 = Updater.constructor-impl(factory$iv$iv$iv);
                    int i86 = 0;
                    Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(valueOf, i40), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i88 = 0;
                    Composer composer13 = constructor-impl2;
                    int i89 = 0;
                    if (!composer13.getInserting()) {
                    } else {
                    }
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    alignment = valueOf;
                    composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = factory$iv$iv$iv;
                    i21 = i43;
                    ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i53 |= 6;
                    composer3 = composer10;
                    i25 = 0;
                    boxScopeInstance = iNSTANCE2;
                    i30 = i49;
                    ComposerKt.sourceInformationMarkerStart(composer3, 87052400, "C1737@79293L264:DatePicker.kt#uh7d8r");
                    composer7 = second;
                    int $composer4 = 0;
                    int $composer5 = 0;
                    i17 = $composer5;
                    map = map3;
                    i14 = i90;
                    composer4 = composer14;
                    modifier2 = modifier4;
                    TextKt.Text--4IGK_g(composer7, SizeKt.wrapContentSize$default((Modifier)Modifier.Companion, $composer4, $composer5, 3, $composer4), obj4.getWeekdayContentColor-0d7_KjU(), currentCompositionLocalMap, 0, materializeModifier2, 0, 0, 0, 0, composer7, 0, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, map, 0, 0, 0, 0, 0, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont(), restartGroup, i62));
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    $i$a$LayoutRowKt$Row$1$iv = i32 + 1;
                    centerVertically = vertical2;
                    rowMeasurePolicy = measurePolicy;
                    verticalAlignment$iv = $this$fastForEach$iv;
                    measurePolicy$iv = i35;
                    str = i12;
                    modifier$iv2 = modifier$iv;
                    $dirty = str2;
                    spaceEvenly = horizontalOrVertical;
                    str4 = str3;
                    factory$iv$iv$iv = composer4;
                    currentCompositionLocalMap = map2;
                    function03 = function02;
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    alignment = valueOf;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    } else {
                    }
                    composer = composer13;
                    factory$iv$iv$iv.createNode(function07);
                    ComposablesKt.invalidApplier();
                    modifier$iv = modifier$iv2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                    } else {
                    }
                    obj3 = it$iv;
                }
                $this$fastForEach$iv = verticalAlignment$iv;
                i32 = $i$a$LayoutRowKt$Row$1$iv;
                i12 = str;
                modifier$iv = modifier$iv2;
                horizontalOrVertical = spaceEvenly;
                androidx.compose.ui.Alignment.Vertical $this$fastForEach$iv3 = centerVertically;
                restartGroup = rowMeasurePolicy;
                map2 = currentCompositionLocalMap;
                composer4 = factory$iv$iv$iv;
                function02 = function03;
                composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                i10 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new DatePickerKt.WeekDays.2(obj4, obj5, i36);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    private static final void Year(Modifier modifier, boolean selected, boolean currentYear, Function0<Unit> onClick, boolean enabled, String description, androidx.compose.material3.DatePickerColors colors, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object anon;
        boolean traceInProgress;
        boolean empty;
        Object $i$a$CacheDatePickerKt$Year$border$12;
        int i6;
        int i;
        boolean $dirty2;
        Object $composer2;
        Object obj3;
        Object obj2;
        int todayDateBorderColor-0d7_KjU;
        int $dirty;
        int i11;
        int i2;
        int i5;
        Object obj;
        int i8;
        int i4;
        Object empty2;
        int $i$f$cache;
        int i15;
        int i14;
        int i9;
        int i10;
        int i16;
        boolean skipping;
        boolean traceInProgress2;
        Object anon2;
        int str;
        int i3;
        Composer composer;
        int i17;
        int i13;
        int $dirty3;
        int i7;
        int i12;
        int $i$a$CacheDatePickerKt$Year$border$1;
        final Object obj4 = modifier;
        traceInProgress = selected;
        $dirty2 = enabled;
        anon = description;
        obj3 = colors;
        obj2 = content;
        todayDateBorderColor-0d7_KjU = $changed;
        i6 = 238547184;
        $composer2 = $composer.startRestartGroup(i6);
        ComposerKt.sourceInformation($composer2, "C(Year)P(5,7,2,6,4,3)2079@93760L393,2097@94528L102,2102@94726L5,2103@94756L58,2106@94881L83,2109@95020L106,2090@94158L968:DatePicker.kt#uh7d8r");
        if (todayDateBorderColor-0d7_KjU & 6 == 0) {
            i11 = $composer2.changed(obj4) ? 4 : 2;
            $dirty |= i11;
        }
        i8 = 32;
        if (todayDateBorderColor-0d7_KjU & 48 == 0) {
            i2 = $composer2.changed(traceInProgress) ? i8 : 16;
            $dirty |= i2;
        }
        $i$f$cache = 256;
        if (todayDateBorderColor-0d7_KjU & 384 == 0) {
            i5 = $composer2.changed(currentYear) ? $i$f$cache : 128;
            $dirty |= i5;
        }
        if (todayDateBorderColor-0d7_KjU & 3072 == 0) {
            i15 = $composer2.changedInstance(onClick) ? 2048 : 1024;
            $dirty |= i15;
        } else {
            obj = onClick;
        }
        if (todayDateBorderColor-0d7_KjU & 24576 == 0) {
            i14 = $composer2.changed($dirty2) ? 16384 : 8192;
            $dirty |= i14;
        }
        if (i63 &= todayDateBorderColor-0d7_KjU == 0) {
            i9 = $composer2.changed(anon) ? 131072 : 65536;
            $dirty |= i9;
        }
        if (i64 &= todayDateBorderColor-0d7_KjU == 0) {
            i10 = $composer2.changed(obj3) ? 1048576 : 524288;
            $dirty |= i10;
        }
        if (i65 &= todayDateBorderColor-0d7_KjU == 0) {
            i16 = $composer2.changedInstance(obj2) ? 8388608 : 4194304;
            $dirty |= i16;
        }
        if (i66 &= $dirty == 4793490) {
            if (!$composer2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, $dirty, -1, "androidx.compose.material3.Year (DatePicker.kt:2077)");
                }
                String str3 = "CC(remember):DatePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer2, -1682614743, str3);
                i = $dirty & 896 == $i$f$cache ? 1 : 0;
                i4 = $dirty & 112 == i8 ? 1 : 0;
                empty2 = $composer2;
                int i62 = 0;
                Object rememberedValue2 = empty2.rememberedValue();
                int i67 = 0;
                if (i |= i4 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        int i31 = 0;
                        if (currentYear && !traceInProgress) {
                            if (!traceInProgress) {
                                $i$a$CacheDatePickerKt$Year$border$1 = i31;
                                i7 = $dirty;
                                $i$a$CacheDatePickerKt$Year$border$12 = BorderStrokeKt.BorderStroke-cXLIe8U(DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineWidth-D9Ej5fM(), obj3.getTodayDateBorderColor-0d7_KjU());
                            } else {
                                $i$a$CacheDatePickerKt$Year$border$1 = i31;
                                i7 = $dirty;
                                $i$a$CacheDatePickerKt$Year$border$12 = 0;
                            }
                        } else {
                        }
                        empty2.updateRememberedValue($i$a$CacheDatePickerKt$Year$border$12);
                    } else {
                        i7 = $dirty;
                        $i$a$CacheDatePickerKt$Year$border$12 = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1682590458, str3);
                i3 = i7 & i19 == 131072 ? 1 : 0;
                Composer composer2 = $composer2;
                int i36 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i58 = 0;
                if (i3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        anon2 = new DatePickerKt.Year.1.1(anon);
                        composer2.updateRememberedValue((Function1)anon2);
                    } else {
                        anon2 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $dirty = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), $composer2, 6);
                DatePickerKt.Year.2 anon3 = new DatePickerKt.Year.2(obj2);
                i12 = i51;
                SurfaceKt.Surface-d85dljk(selected, onClick, SemanticsModifierKt.semantics(obj4, true, (Function1)anon2), enabled, $dirty, (Color)obj3.yearContainerColor$material3_release(traceInProgress, $dirty2, $composer2, i24 |= i41).getValue().unbox-impl(), obj2, (Color)obj3.yearContentColor$material3_release(currentYear, traceInProgress, $dirty2, $composer2, i29 |= i46).getValue().unbox-impl(), $dirty, 0, 0, (BorderStroke)$i$a$CacheDatePickerKt$Year$border$12, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1573188346, true, anon3, $composer2, 54), $composer2, i50 | i57);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                composer = $composer2;
                i12 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new DatePickerKt.Year.3(obj4, selected, currentYear, onClick, enabled, description, colors, content, $changed);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    private static final void YearPicker(Modifier modifier, long displayedMonthMillis, Function1<? super Integer, Unit> onYearSelected, androidx.compose.material3.SelectableDates selectableDates, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        Object rememberComposableLambda;
        int i4;
        int i6;
        int i2;
        int i3;
        int i;
        int i5;
        int i7;
        boolean skipping;
        boolean traceInProgress;
        Object obj11;
        Object obj7;
        Object obj10;
        Object obj;
        Object obj8;
        int anon;
        Object obj2;
        int $dirty2;
        long l;
        Object obj6;
        Object obj5;
        Object obj3;
        Object obj4;
        Object obj9;
        final int i15 = obj29;
        traceInProgress2 = -1286899812;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(YearPicker)P(3,2,4,5!1,6)1984@89212L5,1984@89219L4227,1984@89138L4308:DatePicker.kt#uh7d8r");
        if (i15 & 6 == 0) {
            i4 = restartGroup.changed(modifier) ? 4 : 2;
            $dirty |= i4;
        } else {
            rememberComposableLambda = modifier;
        }
        if (i15 & 48 == 0) {
            i6 = restartGroup.changed(displayedMonthMillis) ? 32 : 16;
            $dirty |= i6;
        } else {
            l = displayedMonthMillis;
        }
        if (i15 & 384 == 0) {
            i2 = restartGroup.changedInstance(selectableDates) ? 256 : 128;
            $dirty |= i2;
        } else {
            obj11 = selectableDates;
        }
        if (i15 & 3072 == 0) {
            i3 = restartGroup.changed(calendarModel) ? 2048 : 1024;
            $dirty |= i3;
        } else {
            obj7 = calendarModel;
        }
        if (i15 & 24576 == 0) {
            i = restartGroup.changedInstance(yearRange) ? 16384 : 8192;
            $dirty |= i;
        } else {
            obj10 = yearRange;
        }
        if (i10 &= i15 == 0) {
            i5 = restartGroup.changedInstance(colors) ? 131072 : 65536;
            $dirty |= i5;
        } else {
            obj = colors;
        }
        if (i11 &= i15 == 0) {
            i7 = restartGroup.changed($composer) ? 1048576 : 524288;
            $dirty |= i7;
        } else {
            obj8 = $composer;
        }
        if (i12 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1983)");
                }
                anon = new DatePickerKt.YearPicker.1(obj10, l, obj14, obj, obj8, rememberComposableLambda, obj11, obj7);
                TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont(), restartGroup, 6), (Function2)ComposableLambdaKt.rememberComposableLambda(1301915789, true, anon, restartGroup, 54), restartGroup, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            traceInProgress2 = new DatePickerKt.YearPicker.2(modifier, displayedMonthMillis, skipping, selectableDates, calendarModel, yearRange, colors, $composer, i15);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty2 = $dirty;
        }
    }

    private static final void YearPickerMenuButton(Function0<Unit> onClick, boolean expanded, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int $dirty;
        Object obj2;
        Object obj;
        int i3;
        int i11;
        int companion;
        boolean traceInProgress;
        Object str;
        int i9;
        int i5;
        int skipping;
        int $dirty2;
        int i6;
        androidx.compose.material3.ButtonColors buttonColors;
        int i;
        int i8;
        int i2;
        int i4;
        Composer restartGroup;
        Composer composer;
        int i10;
        Object obj3;
        int modifier2;
        final boolean z = expanded;
        final Object obj5 = content;
        final int i14 = $changed;
        traceInProgress2 = 409654418;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(YearPickerMenuButton)P(3,1,2)2192@98101L7,2192@98051L58,2195@98166L453,2188@97922L697:DatePicker.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
            obj2 = onClick;
        } else {
            if (i14 & 6 == 0) {
                i3 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj2 = onClick;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i14 & 48 == 0) {
                i11 = restartGroup.changed(z) ? 32 : 16;
                $dirty |= i11;
            }
        }
        companion = i7 & 4;
        if (companion != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i14 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i9;
            } else {
                str = modifier;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i14 & 3072 == 0) {
                i5 = restartGroup.changedInstance(obj5) ? 2048 : 1024;
                $dirty |= i5;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (companion != 0) {
                    obj3 = companion;
                } else {
                    obj3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2187)");
                }
                int i25 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = restartGroup.consume((CompositionLocal)ContentColorKt.getLocalContentColor());
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                DatePickerKt.YearPickerMenuButton.1 anon = new DatePickerKt.YearPickerMenuButton.1(obj5, z);
                str = obj3;
                composer = restartGroup;
                ButtonKt.TextButton(obj2, str, false, (Shape)RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0, 6, (Color)consume.unbox-impl(), consume, 0, obj12, 0), 0, 0, 0, 0, (Function3)ComposableLambdaKt.rememberComposableLambda(1899012021, true, anon, restartGroup, 54), composer, i19 | i24, 388);
                restartGroup = composer;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = str;
            } else {
                restartGroup.skipToGroupEnd();
                obj = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            traceInProgress2 = new DatePickerKt.YearPickerMenuButton.2(onClick, z, obj, obj5, i14, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty2 = $dirty;
        }
    }

    public static final void access$DatePickerContent(Long selectedDateMillis, long displayedMonthMillis, Function1 onDateSelectionChange, Function1 onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        DatePickerKt.DatePickerContent(selectedDateMillis, displayedMonthMillis, onDateSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, $changed);
    }

    public static final boolean access$DatePickerContent$lambda$8(MutableState $yearPickerVisible$delegate) {
        return DatePickerKt.DatePickerContent$lambda$8($yearPickerVisible$delegate);
    }

    public static final void access$DatePickerContent$lambda$9(MutableState $yearPickerVisible$delegate, boolean value) {
        DatePickerKt.DatePickerContent$lambda$9($yearPickerVisible$delegate, value);
    }

    public static final void access$Day(Modifier modifier, boolean selected, Function0 onClick, boolean animateChecked, boolean enabled, boolean today, boolean inRange, String description, androidx.compose.material3.DatePickerColors colors, Function2 content, Composer $composer, int $changed) {
        DatePickerKt.Day(modifier, selected, onClick, animateChecked, enabled, today, inRange, description, colors, content, $composer, $changed);
    }

    public static final void access$HorizontalMonthsList(LazyListState lazyListState, Long selectedDateMillis, Function1 onDateSelectionChange, Function1 onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        DatePickerKt.HorizontalMonthsList(lazyListState, selectedDateMillis, onDateSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, $changed);
    }

    public static final void access$MonthsNavigation(Modifier modifier, boolean nextAvailable, boolean previousAvailable, boolean yearPickerVisible, String yearPickerText, Function0 onNextClicked, Function0 onPreviousClicked, Function0 onYearPickerButtonClicked, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        DatePickerKt.MonthsNavigation(modifier, nextAvailable, previousAvailable, yearPickerVisible, yearPickerText, onNextClicked, onPreviousClicked, onYearPickerButtonClicked, colors, $composer, $changed);
    }

    public static final void access$SwitchableDateEntryContent-d7iavvg(Long selectedDateMillis, long displayedMonthMillis, int displayMode, Function1 onDateSelectionChange, Function1 onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        DatePickerKt.SwitchableDateEntryContent-d7iavvg(selectedDateMillis, displayedMonthMillis, displayMode, onDateSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, $changed);
    }

    public static final void access$Year(Modifier modifier, boolean selected, boolean currentYear, Function0 onClick, boolean enabled, String description, androidx.compose.material3.DatePickerColors colors, Function2 content, Composer $composer, int $changed) {
        DatePickerKt.Year(modifier, selected, currentYear, onClick, enabled, description, colors, content, $composer, $changed);
    }

    public static final void access$YearPicker(Modifier modifier, long displayedMonthMillis, Function1 onYearSelected, androidx.compose.material3.SelectableDates selectableDates, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        DatePickerKt.YearPicker(modifier, displayedMonthMillis, onYearSelected, selectableDates, calendarModel, yearRange, colors, $composer, $changed);
    }

    public static final void access$YearPickerMenuButton(Function0 onClick, boolean expanded, Modifier modifier, Function2 content, Composer $composer, int $changed, int $default) {
        DatePickerKt.YearPickerMenuButton(onClick, expanded, modifier, content, $composer, $changed, $default);
    }

    public static final List access$customScrollActions(LazyGridState state, CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        return DatePickerKt.customScrollActions(state, coroutineScope, scrollUpLabel, scrollDownLabel);
    }

    public static final PaddingValues access$getDatePickerHeadlinePadding$p() {
        return DatePickerKt.DatePickerHeadlinePadding;
    }

    public static final PaddingValues access$getDatePickerTitlePadding$p() {
        return DatePickerKt.DatePickerTitlePadding;
    }

    public static final float access$getYearsVerticalPadding$p() {
        return DatePickerKt.YearsVerticalPadding;
    }

    private static final List<CustomAccessibilityAction> customScrollActions(LazyGridState state, CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        DatePickerKt.customScrollActions.scrollUpAction.1 anon = new DatePickerKt.customScrollActions.scrollUpAction.1(state, coroutineScope);
        DatePickerKt.customScrollActions.scrollDownAction.1 anon2 = new DatePickerKt.customScrollActions.scrollDownAction.1(state, coroutineScope);
        CustomAccessibilityAction[] arr = new CustomAccessibilityAction[2];
        CustomAccessibilityAction customAccessibilityAction = new CustomAccessibilityAction(scrollUpLabel, (Function0)anon);
        CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction(scrollDownLabel, (Function0)anon2);
        return CollectionsKt.listOf(customAccessibilityAction, customAccessibilityAction2);
    }

    private static final String dayContentDescription(boolean rangeSelectionEnabled, boolean isToday, boolean isStartDate, boolean isEndDate, boolean isInRange, Composer $composer, int $changed) {
        boolean traceInProgress;
        int i;
        int string;
        String string-2EP1pXo2;
        int string-2EP1pXo;
        int str;
        int m3c_date_range_picker_start_headline;
        int m3c_date_picker_today_description;
        int i2 = 502032503;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(dayContentDescription)P(4,3,2):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1889)");
        }
        StringBuilder stringBuilder = new StringBuilder();
        $composer.startReplaceGroup(-647758197);
        ComposerKt.sourceInformation($composer, "");
        i = 0;
        if (rangeSelectionEnabled) {
            if (isStartDate) {
                $composer.startReplaceGroup(-647755172);
                ComposerKt.sourceInformation($composer, "1894@86219L56");
                androidx.compose.material3.internal.Strings.Companion companion = Strings.Companion;
                string-2EP1pXo = 0;
                stringBuilder.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_start_headline), $composer, i));
                $composer.endReplaceGroup();
            } else {
                if (isEndDate) {
                    $composer.startReplaceGroup(-647751174);
                    ComposerKt.sourceInformation($composer, "1896@86344L54");
                    androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                    string-2EP1pXo = 0;
                    stringBuilder.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_end_headline), $composer, i));
                    $composer.endReplaceGroup();
                } else {
                    if (isInRange) {
                        $composer.startReplaceGroup(-647747239);
                        ComposerKt.sourceInformation($composer, "1898@86467L53");
                        androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                        string-2EP1pXo = 0;
                        stringBuilder.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_day_in_range), $composer, i));
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(1394740614);
                        $composer.endReplaceGroup();
                    }
                }
            }
        }
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(-647744489);
        ComposerKt.sourceInformation($composer, "1903@86668L54");
        int i8 = 1;
        if (isToday) {
            str = (CharSequence)stringBuilder.length() > 0 ? i8 : i;
            if (str != null) {
                stringBuilder.append(", ");
            }
            androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
            m3c_date_range_picker_start_headline = 0;
            stringBuilder.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_today_description), $composer, i));
        }
        $composer.endReplaceGroup();
        if ((CharSequence)stringBuilder.length() == 0) {
            i = i8;
        }
        if (i != 0) {
            string = 0;
        } else {
            string = stringBuilder.toString();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return string;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerKt.DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerKt.DatePickerModeTogglePadding;
    }

    public static final float getMonthYearHeight() {
        return DatePickerKt.MonthYearHeight;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return DatePickerKt.RecommendedSizeForAccessibility;
    }

    public static final int numberOfMonthsInRange(IntRange yearRange) {
        return i2 *= 12;
    }

    public static final androidx.compose.material3.DatePickerState rememberDatePickerState-EU0dCGE(Long initialSelectedDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, androidx.compose.material3.SelectableDates selectableDates, Composer $composer, int $changed, int i8) {
        int i7;
        int i4;
        int yearRange2;
        int picker-jFl-4v0;
        int allDates;
        boolean traceInProgress;
        int i3;
        String str;
        int i6;
        boolean changed4;
        int changed2;
        int i9;
        boolean changed3;
        int i11;
        int changed;
        int empty;
        Object anon;
        int i5;
        int i;
        IntRange intRange;
        int i10;
        androidx.compose.material3.SelectableDates date;
        int i2;
        final Composer composer2 = $composer;
        final int i31 = $changed;
        int i12 = 2065763010;
        ComposerKt.sourceInformationMarkerStart(composer2, i12, "C(rememberDatePickerState)P(2,1,4,0:c#material3.DisplayMode)365@15667L15,366@15771L347,366@15694L424:DatePicker.kt#uh7d8r");
        i5 = i8 & 1 != 0 ? i7 : initialSelectedDateMillis;
        i = i8 & 2 != 0 ? i4 : initialDisplayedMonthMillis;
        if (i8 & 4 != 0) {
            intRange = yearRange2;
        } else {
            intRange = yearRange;
        }
        if (i8 & 8 != 0) {
            i10 = picker-jFl-4v0;
        } else {
            i10 = initialDisplayMode;
        }
        if (i8 & 16 != 0) {
            date = allDates;
        } else {
            date = selectableDates;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i12, i31, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:364)");
        }
        int i13 = 0;
        final Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(composer2, i13);
        i3 = i13;
        ComposerKt.sourceInformationMarkerStart(composer2, -390857696, "CC(remember):DatePicker.kt#9igjgp");
        int i22 = 4;
        int i29 = 1;
        if (i18 ^= 6 > i22) {
            if (!composer2.changed(i5)) {
                i6 = i31 & 6 == i22 ? i29 : i3;
            } else {
            }
        } else {
        }
        int i32 = 32;
        if (i23 ^= 48 > i32) {
            if (!composer2.changed(i)) {
                i9 = i31 & 48 == i32 ? i29 : i3;
            } else {
            }
        } else {
        }
        int i33 = 2048;
        if (i24 ^= 3072 > i33) {
            if (!composer2.changed(i10)) {
                i11 = i31 & 3072 == i33 ? i29 : i3;
            } else {
            }
        } else {
        }
        empty = 16384;
        if (i26 ^= 24576 > empty) {
            if (!composer2.changed(date)) {
                if (i31 & 24576 == empty) {
                    i3 = i29;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i27 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i34 = 0;
        if (i14 |= changedInstance == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i2 = 0;
                anon = new DatePickerKt.rememberDatePickerState.1.1(i5, i, intRange, i10, date, defaultLocale);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (DatePickerState)(DatePickerStateImpl)RememberSaveableKt.rememberSaveable(new Object[i3], DatePickerStateImpl.Companion.Saver(date, defaultLocale), 0, (Function0)anon, composer2, 0, 4);
    }

    public static final Object updateDisplayedMonth(LazyListState lazyListState, Function1<? super Long, Unit> onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, Continuation<? super Unit> $completion) {
        DatePickerKt.updateDisplayedMonth.2 anon = new DatePickerKt.updateDisplayedMonth.2(lazyListState);
        DatePickerKt.updateDisplayedMonth.3 anon2 = new DatePickerKt.updateDisplayedMonth.3(lazyListState, onDisplayedMonthChange, calendarModel, yearRange);
        Object collect = SnapshotStateKt.snapshotFlow((Function0)anon).collect((FlowCollector)anon2, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
