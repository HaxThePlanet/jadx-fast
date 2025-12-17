package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001al\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\u0008\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\u0008\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001al\u0010\u0017\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\u0008\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001av\u0010\u0017\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\u0008\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0 2%\u0008\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\u0008\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\u0008\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0086\u0008¢\u0006\u0002\u0010+\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0 2%\u0008\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\u0008\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0087\u0008¢\u0006\u0002\u0010,\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0-2%\u0008\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\u0008\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\u0008\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0086\u0008¢\u0006\u0002\u0010.\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0-2%\u0008\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\u0008\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0087\u0008¢\u0006\u0002\u0010/\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0 2:\u0008\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\u0008\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\u0008\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0086\u0008¢\u0006\u0002\u00104\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0 2:\u0008\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\u0008\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0087\u0008¢\u0006\u0002\u00105\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0-2:\u0008\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\u0008\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\u0008\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0086\u0008¢\u0006\u0002\u00106\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u001f*\u00020\u00122\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u001f0-2:\u0008\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\u0008\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\u0008*¢\u0006\u0002\u0008\u0013H\u0087\u0008¢\u0006\u0002\u00107¨\u00068", d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyDslKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final void LazyColumn(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, Function1 content, Composer $composer, int $changed, int i11) {
        Object obj6;
        int traceInProgress2;
        int $dirty4;
        int $dirty3;
        int defaultsInvalid;
        Object modifier3;
        Object $composer2;
        int $dirty5;
        int flingBehavior2;
        int i;
        Arrangement.Vertical bottom;
        Object $dirty2;
        int i3;
        int rememberLazyListState;
        Object obj4;
        Object $dirty;
        boolean traceInProgress;
        boolean z;
        int i6;
        Object str;
        Object obj;
        int changed3;
        int i2;
        Object obj5;
        Object obj3;
        Object obj2;
        int i10;
        int i9;
        boolean z2;
        Object reverseLayout2;
        int modifier2;
        int i12;
        Object verticalArrangement2;
        int changed;
        Object i4;
        Object horizontalAlignment2;
        int i5;
        Object obj7;
        int changed2;
        Object i15;
        int i13;
        int i14;
        Function1 function1;
        Composer composer;
        int i7;
        int i8;
        int obj31;
        final int i52 = $changed;
        final int i53 = i11;
        Composer restartGroup = $composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation(restartGroup, "C(LazyColumn)P(4,6,1,5,7,3,2)385@18761L23,391@19115L15,394@19178L350:LazyDsl.kt#428nma");
        $dirty5 = $changed;
        int i28 = i53 & 1;
        if (i28 != 0) {
            $dirty5 |= 6;
            $dirty = modifier;
        } else {
            if (i52 & 6 == 0) {
                i6 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty5 |= i6;
            } else {
                $dirty = modifier;
            }
        }
        if (i52 & 48 == 0) {
            if (i53 & 2 == 0) {
                changed3 = restartGroup.changed(state) ? 32 : 16;
            } else {
                str = state;
            }
            $dirty5 |= changed3;
        } else {
            str = state;
        }
        i2 = i53 & 4;
        if (i2 != 0) {
            $dirty5 |= 384;
            obj3 = contentPadding;
        } else {
            if (i52 & 384 == 0) {
                i10 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty5 |= i10;
            } else {
                obj3 = contentPadding;
            }
        }
        i9 = i53 & 8;
        if (i9 != 0) {
            $dirty5 |= 3072;
            z2 = reverseLayout;
        } else {
            if (i52 & 3072 == 0) {
                i12 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty5 |= i12;
            } else {
                z2 = reverseLayout;
            }
        }
        if (i52 & 24576 == 0) {
            if (i53 & 16 == 0) {
                changed = restartGroup.changed(verticalArrangement) ? 16384 : 8192;
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            $dirty5 |= changed;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        i4 = i53 & 32;
        int i57 = 196608;
        if (i4 != 0) {
            $dirty5 |= i57;
            horizontalAlignment2 = horizontalAlignment;
        } else {
            if (i57 &= i52 == 0) {
                i5 = restartGroup.changed(horizontalAlignment) ? 131072 : 65536;
                $dirty5 |= i5;
            } else {
                horizontalAlignment2 = horizontalAlignment;
            }
        }
        if (i59 &= i52 == 0) {
            if (i53 & 64 == 0) {
                changed2 = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                obj7 = flingBehavior;
            }
            $dirty5 |= changed2;
        } else {
            obj7 = flingBehavior;
        }
        i15 = 12582912;
        if (i53 & 128 != 0) {
            $dirty5 |= i15;
            obj6 = content;
        } else {
            if (i52 & i15 == 0) {
                i13 = restartGroup.changedInstance(content) ? 8388608 : 4194304;
                $dirty5 |= i13;
            } else {
                obj6 = content;
            }
        }
        obj31 = $dirty5;
        if ($dirty5 & i14 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -3670017;
                int i62 = -57345;
                if (i52 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i28 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = $dirty;
                        }
                        if (i53 & 2 != 0) {
                            int i45 = 0;
                            $dirty = obj31 & -113;
                            str = rememberLazyListState;
                        } else {
                            $dirty = obj31;
                        }
                        if (i2 != 0) {
                            i2 = 0;
                            obj31 = i;
                            obj3 = i;
                        } else {
                            obj31 = i;
                        }
                        if (i9 != 0) {
                            z2 = i;
                        }
                        if (i53 & 16 != 0) {
                            Arrangement iNSTANCE = Arrangement.INSTANCE;
                            if (!z2) {
                                bottom = iNSTANCE.getTop();
                            } else {
                                bottom = iNSTANCE.getBottom();
                            }
                            $dirty &= i62;
                            verticalArrangement2 = bottom;
                        }
                        if (i4 != 0) {
                            horizontalAlignment2 = bottom;
                        }
                        if (i53 & 64 != 0) {
                            i4 = obj3;
                            obj7 = verticalArrangement2;
                            changed2 = horizontalAlignment2;
                            verticalArrangement2 = str;
                            horizontalAlignment2 = z2;
                            reverseLayout2 = modifier3;
                            $dirty3 = i15;
                            i15 = flingBehavior3;
                            flingBehavior2 = i44;
                            i3 = -563353797;
                        } else {
                            flingBehavior2 = $dirty;
                            i4 = obj3;
                            changed2 = horizontalAlignment2;
                            i3 = -563353797;
                            horizontalAlignment2 = z2;
                            reverseLayout2 = modifier3;
                            $dirty3 = i15;
                            i15 = obj7;
                            obj7 = verticalArrangement2;
                            verticalArrangement2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty4 = i53 & 2 != 0 ? obj31 & -113 : obj31;
                        if (i53 & 16 != 0) {
                            $dirty4 &= i62;
                        }
                        if (i53 & 64 != 0) {
                            $dirty4 &= i;
                        }
                        flingBehavior2 = $dirty4;
                        i4 = obj3;
                        changed2 = horizontalAlignment2;
                        $dirty3 = i15;
                        i3 = -563353797;
                        horizontalAlignment2 = z2;
                        i15 = obj7;
                        reverseLayout2 = $dirty;
                        obj7 = verticalArrangement2;
                        verticalArrangement2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i3, flingBehavior2, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:393)");
                }
                LazyDslKt.LazyColumn(reverseLayout2, verticalArrangement2, i4, horizontalAlignment2, obj7, changed2, i15, true, content, restartGroup, i26 | i42, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = reverseLayout2;
                obj4 = i4;
                z = horizontalAlignment2;
                obj = obj7;
                obj5 = changed2;
                obj2 = i15;
                modifier2 = flingBehavior2;
                $dirty2 = verticalArrangement2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = $dirty;
                $dirty2 = str;
                obj4 = obj3;
                z = z2;
                obj = verticalArrangement2;
                obj5 = horizontalAlignment2;
                obj2 = obj7;
                modifier2 = obj31;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LazyDslKt.LazyColumn.2($composer2, $dirty2, obj4, z, obj, obj5, obj2, content, i52, i53);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void LazyColumn(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.LazyListScope, Unit> content, Composer $composer, int $changed, int i12) {
        boolean z;
        Object obj9;
        boolean traceInProgress2;
        int defaultsInvalid;
        int rememberLazyListState;
        Arrangement.Vertical bottom;
        int $dirty3;
        boolean traceInProgress;
        Object $composer2;
        int $dirty4;
        Object $dirty2;
        int i10;
        int i7;
        Object obj10;
        int $dirty;
        Object obj8;
        boolean z2;
        int i11;
        Object obj2;
        Object obj5;
        int changed;
        Object obj;
        int i19;
        Object obj3;
        Object obj6;
        int i13;
        int z4;
        boolean z3;
        int i3;
        Object obj4;
        int modifier2;
        Object verticalArrangement2;
        boolean changed2;
        int i4;
        Object horizontalAlignment2;
        int i14;
        Object flingBehavior2;
        int changed3;
        int i17;
        int i15;
        int i16;
        int i6;
        int i5;
        Object obj7;
        Object obj11;
        int i9;
        int i18;
        Function1 function1;
        Composer composer;
        int i8;
        int i;
        int i2;
        int obj38;
        final int i61 = $changed;
        final int i62 = i12;
        Composer restartGroup = $composer.startRestartGroup(-740714857);
        ComposerKt.sourceInformation(restartGroup, "C(LazyColumn)P(4,6,1,5,8,3,2,7)357@17743L23,363@18097L15,367@18199L388:LazyDsl.kt#428nma");
        $dirty4 = $changed;
        int i37 = i62 & 1;
        if (i37 != 0) {
            $dirty4 |= 6;
            obj8 = modifier;
        } else {
            if (i61 & 6 == 0) {
                i11 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty4 |= i11;
            } else {
                obj8 = modifier;
            }
        }
        if (i61 & 48 == 0) {
            if (i62 & 2 == 0) {
                changed = restartGroup.changed(state) ? 32 : 16;
            } else {
                obj2 = state;
            }
            $dirty4 |= changed;
        } else {
            obj2 = state;
        }
        i19 = i62 & 4;
        if (i19 != 0) {
            $dirty4 |= 384;
            obj3 = contentPadding;
        } else {
            if (i61 & 384 == 0) {
                i13 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty4 |= i13;
            } else {
                obj3 = contentPadding;
            }
        }
        int i59 = i62 & 8;
        if (i59 != 0) {
            $dirty4 |= 3072;
            z3 = reverseLayout;
        } else {
            if (i61 & 3072 == 0) {
                i3 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty4 |= i3;
            } else {
                z3 = reverseLayout;
            }
        }
        if (i61 & 24576 == 0) {
            if (i62 & 16 == 0) {
                changed2 = restartGroup.changed(verticalArrangement) ? 16384 : 8192;
            } else {
                obj4 = verticalArrangement;
            }
            $dirty4 |= changed2;
        } else {
            obj4 = verticalArrangement;
        }
        i4 = i62 & 32;
        int i65 = 196608;
        if (i4 != 0) {
            $dirty4 |= i65;
            horizontalAlignment2 = horizontalAlignment;
        } else {
            if (i65 &= i61 == 0) {
                i14 = restartGroup.changed(horizontalAlignment) ? 131072 : 65536;
                $dirty4 |= i14;
            } else {
                horizontalAlignment2 = horizontalAlignment;
            }
        }
        if (i67 &= i61 == 0) {
            if (i62 & 64 == 0) {
                changed3 = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                flingBehavior2 = flingBehavior;
            }
            $dirty4 |= changed3;
        } else {
            flingBehavior2 = flingBehavior;
        }
        int i21 = i62 & 128;
        int i70 = 12582912;
        if (i21 != 0) {
            $dirty4 |= i70;
            i17 = i21;
            z = userScrollEnabled;
        } else {
            if (i61 & i70 == 0) {
                i17 = i21;
                i15 = restartGroup.changed(userScrollEnabled) ? 8388608 : 4194304;
                $dirty4 |= i15;
            } else {
                i17 = i21;
                z = userScrollEnabled;
            }
        }
        i16 = 100663296;
        if (i62 & 256 != 0) {
            $dirty4 |= i16;
            obj9 = content;
        } else {
            if (i61 & i16 == 0) {
                i16 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
                $dirty4 |= i16;
            } else {
                obj9 = content;
            }
        }
        obj38 = $dirty4;
        if ($dirty4 & i6 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i10 = -3670017;
                int i72 = -57345;
                if (i61 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i37 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (i62 & 2 != 0) {
                            int i24 = 0;
                            $dirty = obj38 & -113;
                            obj2 = rememberLazyListState;
                        } else {
                            $dirty = obj38;
                        }
                        if (i19 != 0) {
                            i19 = 0;
                            obj38 = i10;
                            obj3 = rememberLazyListState;
                        } else {
                            obj38 = i10;
                        }
                        if (i59 != 0) {
                            z3 = rememberLazyListState;
                        }
                        if (i62 & 16 != 0) {
                            Arrangement iNSTANCE = Arrangement.INSTANCE;
                            if (!z3) {
                                bottom = iNSTANCE.getTop();
                            } else {
                                bottom = iNSTANCE.getBottom();
                            }
                            $dirty &= i72;
                            obj4 = bottom;
                        }
                        if (i4 != 0) {
                            horizontalAlignment2 = bottom;
                        }
                        if (i62 & 64 != 0) {
                            $dirty &= obj38;
                            flingBehavior2 = $dirty3;
                        }
                        if (i17 != 0) {
                            i6 = $dirty3;
                            i7 = $dirty;
                            i4 = obj2;
                            obj11 = obj4;
                            obj7 = horizontalAlignment2;
                            i17 = flingBehavior2;
                            verticalArrangement2 = obj8;
                            horizontalAlignment2 = obj3;
                            flingBehavior2 = z3;
                        } else {
                            i6 = userScrollEnabled;
                            i7 = $dirty;
                            i4 = obj2;
                            obj11 = obj4;
                            obj7 = horizontalAlignment2;
                            i17 = flingBehavior2;
                            verticalArrangement2 = obj8;
                            horizontalAlignment2 = obj3;
                            flingBehavior2 = z3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty3 = i62 & 2 != 0 ? obj38 & -113 : obj38;
                        if (i62 & 16 != 0) {
                            $dirty3 &= i72;
                        }
                        if (i62 & 64 != 0) {
                            $dirty3 &= i10;
                        }
                        i6 = userScrollEnabled;
                        i7 = $dirty3;
                        i4 = obj2;
                        obj11 = obj4;
                        obj7 = horizontalAlignment2;
                        i17 = flingBehavior2;
                        verticalArrangement2 = obj8;
                        horizontalAlignment2 = obj3;
                        flingBehavior2 = z3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i7, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                LazyListKt.LazyList(verticalArrangement2, i4, horizontalAlignment2, flingBehavior2, true, i17, i6, 0, obj7, obj11, 0, 0, content, restartGroup, i32 | i49, i33 &= 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = verticalArrangement2;
                obj10 = horizontalAlignment2;
                z2 = flingBehavior2;
                obj6 = i17;
                z4 = i6;
                obj = obj7;
                obj5 = obj11;
                modifier2 = i7;
                $dirty2 = i4;
            } else {
                restartGroup.skipToGroupEnd();
                z4 = userScrollEnabled;
                composer = restartGroup;
                $composer2 = obj8;
                $dirty2 = obj2;
                obj10 = obj3;
                z2 = z3;
                obj5 = obj4;
                obj = horizontalAlignment2;
                obj6 = flingBehavior2;
                modifier2 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LazyDslKt.LazyColumn.1($composer2, $dirty2, obj10, z2, obj5, obj, obj6, z4, content, i61, i62);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final void LazyRow(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, Function1 content, Composer $composer, int $changed, int i11) {
        Object obj;
        int traceInProgress2;
        int $dirty5;
        int $dirty4;
        int defaultsInvalid;
        Object modifier2;
        Object $composer2;
        int $dirty;
        int flingBehavior2;
        int i3;
        Arrangement.Horizontal start;
        Object $dirty2;
        int i10;
        int rememberLazyListState;
        Object obj5;
        Object $dirty3;
        boolean traceInProgress;
        boolean z;
        int i14;
        Object str;
        Object obj3;
        int changed2;
        int i8;
        Object obj7;
        Object obj4;
        Object obj6;
        int i13;
        int i6;
        boolean z2;
        Object reverseLayout2;
        int modifier3;
        int i4;
        Object horizontalArrangement2;
        int changed3;
        Object i15;
        Object verticalAlignment2;
        int i7;
        Object obj2;
        int changed;
        Object i5;
        int i12;
        int i2;
        Function1 function1;
        Composer composer;
        int i9;
        int i;
        int obj31;
        final int i52 = $changed;
        final int i53 = i11;
        Composer restartGroup = $composer.startRestartGroup(407929823);
        ComposerKt.sourceInformation(restartGroup, "C(LazyRow)P(4,6,1,5,3,7,2)411@19699L23,417@20050L15,420@20113L347:LazyDsl.kt#428nma");
        $dirty = $changed;
        int i28 = i53 & 1;
        if (i28 != 0) {
            $dirty |= 6;
            $dirty3 = modifier;
        } else {
            if (i52 & 6 == 0) {
                i14 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i14;
            } else {
                $dirty3 = modifier;
            }
        }
        if (i52 & 48 == 0) {
            if (i53 & 2 == 0) {
                changed2 = restartGroup.changed(state) ? 32 : 16;
            } else {
                str = state;
            }
            $dirty |= changed2;
        } else {
            str = state;
        }
        i8 = i53 & 4;
        if (i8 != 0) {
            $dirty |= 384;
            obj4 = contentPadding;
        } else {
            if (i52 & 384 == 0) {
                i13 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty |= i13;
            } else {
                obj4 = contentPadding;
            }
        }
        i6 = i53 & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            z2 = reverseLayout;
        } else {
            if (i52 & 3072 == 0) {
                i4 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                z2 = reverseLayout;
            }
        }
        if (i52 & 24576 == 0) {
            if (i53 & 16 == 0) {
                changed3 = restartGroup.changed(horizontalArrangement) ? 16384 : 8192;
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            $dirty |= changed3;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        i15 = i53 & 32;
        int i57 = 196608;
        if (i15 != 0) {
            $dirty |= i57;
            verticalAlignment2 = verticalAlignment;
        } else {
            if (i57 &= i52 == 0) {
                i7 = restartGroup.changed(verticalAlignment) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                verticalAlignment2 = verticalAlignment;
            }
        }
        if (i59 &= i52 == 0) {
            if (i53 & 64 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                obj2 = flingBehavior;
            }
            $dirty |= changed;
        } else {
            obj2 = flingBehavior;
        }
        i5 = 12582912;
        if (i53 & 128 != 0) {
            $dirty |= i5;
            obj = content;
        } else {
            if (i52 & i5 == 0) {
                i12 = restartGroup.changedInstance(content) ? 8388608 : 4194304;
                $dirty |= i12;
            } else {
                obj = content;
            }
        }
        obj31 = $dirty;
        if ($dirty & i2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i3 = -3670017;
                int i62 = -57345;
                if (i52 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i28 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = $dirty3;
                        }
                        if (i53 & 2 != 0) {
                            int i45 = 0;
                            $dirty3 = obj31 & -113;
                            str = rememberLazyListState;
                        } else {
                            $dirty3 = obj31;
                        }
                        if (i8 != 0) {
                            i8 = 0;
                            obj31 = i3;
                            obj4 = i3;
                        } else {
                            obj31 = i3;
                        }
                        if (i6 != 0) {
                            z2 = i3;
                        }
                        if (i53 & 16 != 0) {
                            Arrangement iNSTANCE = Arrangement.INSTANCE;
                            if (!z2) {
                                start = iNSTANCE.getStart();
                            } else {
                                start = iNSTANCE.getEnd();
                            }
                            $dirty3 &= i62;
                            horizontalArrangement2 = start;
                        }
                        if (i15 != 0) {
                            verticalAlignment2 = start;
                        }
                        if (i53 & 64 != 0) {
                            i15 = obj4;
                            obj2 = horizontalArrangement2;
                            changed = verticalAlignment2;
                            horizontalArrangement2 = str;
                            verticalAlignment2 = z2;
                            reverseLayout2 = modifier2;
                            $dirty4 = i5;
                            i5 = flingBehavior3;
                            flingBehavior2 = i44;
                            i10 = 407929823;
                        } else {
                            flingBehavior2 = $dirty3;
                            i15 = obj4;
                            changed = verticalAlignment2;
                            i10 = 407929823;
                            verticalAlignment2 = z2;
                            reverseLayout2 = modifier2;
                            $dirty4 = i5;
                            i5 = obj2;
                            obj2 = horizontalArrangement2;
                            horizontalArrangement2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty5 = i53 & 2 != 0 ? obj31 & -113 : obj31;
                        if (i53 & 16 != 0) {
                            $dirty5 &= i62;
                        }
                        if (i53 & 64 != 0) {
                            $dirty5 &= i3;
                        }
                        flingBehavior2 = $dirty5;
                        i15 = obj4;
                        changed = verticalAlignment2;
                        $dirty4 = i5;
                        i10 = 407929823;
                        verticalAlignment2 = z2;
                        i5 = obj2;
                        reverseLayout2 = $dirty3;
                        obj2 = horizontalArrangement2;
                        horizontalArrangement2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, flingBehavior2, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:419)");
                }
                LazyDslKt.LazyRow(reverseLayout2, horizontalArrangement2, i15, verticalAlignment2, obj2, changed, i5, true, content, restartGroup, i26 | i42, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = reverseLayout2;
                obj5 = i15;
                z = verticalAlignment2;
                obj3 = obj2;
                obj7 = changed;
                obj6 = i5;
                modifier3 = flingBehavior2;
                $dirty2 = horizontalArrangement2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = $dirty3;
                $dirty2 = str;
                obj5 = obj4;
                z = z2;
                obj3 = horizontalArrangement2;
                obj7 = verticalAlignment2;
                obj6 = obj2;
                modifier3 = obj31;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LazyDslKt.LazyRow.2($composer2, $dirty2, obj5, z, obj3, obj7, obj6, content, i52, i53);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void LazyRow(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.LazyListScope, Unit> content, Composer $composer, int $changed, int i12) {
        boolean z4;
        Object obj4;
        boolean traceInProgress;
        int defaultsInvalid;
        int rememberLazyListState;
        Arrangement.Horizontal start;
        int $dirty3;
        boolean traceInProgress2;
        Object $composer2;
        int $dirty;
        Object $dirty4;
        int i16;
        int i7;
        Object obj10;
        int $dirty2;
        Object obj6;
        boolean z;
        int i3;
        Object obj11;
        Object obj7;
        int changed;
        Object obj;
        int i6;
        Object obj2;
        Object obj3;
        int i2;
        int z2;
        boolean z3;
        int i4;
        Object obj9;
        int modifier2;
        Object horizontalArrangement2;
        boolean changed2;
        int i;
        Object verticalAlignment2;
        int i15;
        Object flingBehavior2;
        int changed3;
        int i19;
        int i5;
        int i8;
        int i17;
        int i10;
        int i14;
        int i9;
        Object obj8;
        Object obj5;
        Function1 function1;
        Composer composer;
        int i18;
        int i11;
        int i13;
        int obj38;
        final int i58 = $changed;
        final int i59 = i12;
        Composer restartGroup = $composer.startRestartGroup(-1724297413);
        ComposerKt.sourceInformation(restartGroup, "C(LazyRow)P(4,6,1,5,3,8,2,7)301@14811L23,307@15162L15,311@15264L389:LazyDsl.kt#428nma");
        $dirty = $changed;
        int i36 = i59 & 1;
        if (i36 != 0) {
            $dirty |= 6;
            obj6 = modifier;
        } else {
            if (i58 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj6 = modifier;
            }
        }
        if (i58 & 48 == 0) {
            if (i59 & 2 == 0) {
                changed = restartGroup.changed(state) ? 32 : 16;
            } else {
                obj11 = state;
            }
            $dirty |= changed;
        } else {
            obj11 = state;
        }
        i6 = i59 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            obj2 = contentPadding;
        } else {
            if (i58 & 384 == 0) {
                i2 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj2 = contentPadding;
            }
        }
        int i56 = i59 & 8;
        if (i56 != 0) {
            $dirty |= 3072;
            z3 = reverseLayout;
        } else {
            if (i58 & 3072 == 0) {
                i4 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                z3 = reverseLayout;
            }
        }
        if (i58 & 24576 == 0) {
            if (i59 & 16 == 0) {
                changed2 = restartGroup.changed(horizontalArrangement) ? 16384 : 8192;
            } else {
                obj9 = horizontalArrangement;
            }
            $dirty |= changed2;
        } else {
            obj9 = horizontalArrangement;
        }
        i = i59 & 32;
        int i62 = 196608;
        if (i != 0) {
            $dirty |= i62;
            verticalAlignment2 = verticalAlignment;
        } else {
            if (i62 &= i58 == 0) {
                i15 = restartGroup.changed(verticalAlignment) ? 131072 : 65536;
                $dirty |= i15;
            } else {
                verticalAlignment2 = verticalAlignment;
            }
        }
        if (i64 &= i58 == 0) {
            if (i59 & 64 == 0) {
                changed3 = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                flingBehavior2 = flingBehavior;
            }
            $dirty |= changed3;
        } else {
            flingBehavior2 = flingBehavior;
        }
        int i21 = i59 & 128;
        int i67 = 12582912;
        if (i21 != 0) {
            $dirty |= i67;
            i19 = i21;
            z4 = userScrollEnabled;
        } else {
            if (i58 & i67 == 0) {
                i19 = i21;
                i5 = restartGroup.changed(userScrollEnabled) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                i19 = i21;
                z4 = userScrollEnabled;
            }
        }
        i8 = 100663296;
        if (i59 & 256 != 0) {
            $dirty |= i8;
            obj4 = content;
        } else {
            if (i58 & i8 == 0) {
                i8 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
                $dirty |= i8;
            } else {
                obj4 = content;
            }
        }
        obj38 = $dirty;
        if ($dirty & i17 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i16 = -3670017;
                int i69 = -57345;
                if (i58 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i36 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        if (i59 & 2 != 0) {
                            int i24 = 0;
                            $dirty2 = obj38 & -113;
                            obj11 = rememberLazyListState;
                        } else {
                            $dirty2 = obj38;
                        }
                        if (i6 != 0) {
                            i6 = 0;
                            obj38 = i16;
                            obj2 = rememberLazyListState;
                        } else {
                            obj38 = i16;
                        }
                        if (i56 != 0) {
                            z3 = rememberLazyListState;
                        }
                        if (i59 & 16 != 0) {
                            Arrangement iNSTANCE = Arrangement.INSTANCE;
                            if (!z3) {
                                start = iNSTANCE.getStart();
                            } else {
                                start = iNSTANCE.getEnd();
                            }
                            $dirty2 &= i69;
                            obj9 = start;
                        }
                        if (i != 0) {
                            verticalAlignment2 = start;
                        }
                        if (i59 & 64 != 0) {
                            $dirty2 &= obj38;
                            flingBehavior2 = $dirty3;
                        }
                        if (i19 != 0) {
                            i17 = $dirty3;
                            i7 = $dirty2;
                            i = obj11;
                            obj5 = obj9;
                            obj8 = verticalAlignment2;
                            i19 = flingBehavior2;
                            horizontalArrangement2 = obj6;
                            verticalAlignment2 = obj2;
                            flingBehavior2 = z3;
                        } else {
                            i17 = userScrollEnabled;
                            i7 = $dirty2;
                            i = obj11;
                            obj5 = obj9;
                            obj8 = verticalAlignment2;
                            i19 = flingBehavior2;
                            horizontalArrangement2 = obj6;
                            verticalAlignment2 = obj2;
                            flingBehavior2 = z3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty3 = i59 & 2 != 0 ? obj38 & -113 : obj38;
                        if (i59 & 16 != 0) {
                            $dirty3 &= i69;
                        }
                        if (i59 & 64 != 0) {
                            $dirty3 &= i16;
                        }
                        i17 = userScrollEnabled;
                        i7 = $dirty3;
                        i = obj11;
                        obj5 = obj9;
                        obj8 = verticalAlignment2;
                        i19 = flingBehavior2;
                        horizontalArrangement2 = obj6;
                        verticalAlignment2 = obj2;
                        flingBehavior2 = z3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i7, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:310)");
                }
                LazyListKt.LazyList(horizontalArrangement2, i, verticalAlignment2, flingBehavior2, false, i19, i17, 0, 0, 0, obj8, obj5, content, restartGroup, i30 | i44, i33 | i48, 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = horizontalArrangement2;
                obj10 = verticalAlignment2;
                z = flingBehavior2;
                obj3 = i19;
                z2 = i17;
                obj = obj8;
                obj7 = obj5;
                modifier2 = i7;
                $dirty4 = i;
            } else {
                restartGroup.skipToGroupEnd();
                z2 = userScrollEnabled;
                composer = restartGroup;
                $composer2 = obj6;
                $dirty4 = obj11;
                obj10 = obj2;
                z = z3;
                obj7 = obj9;
                obj = verticalAlignment2;
                obj3 = flingBehavior2;
                modifier2 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new LazyDslKt.LazyRow.1($composer2, $dirty4, obj10, z, obj7, obj, obj3, z2, content, i58, i59);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final <T> void items(androidx.compose.foundation.lazy.LazyListScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.items.2 anon;
        final int i = 0;
        if (key != null) {
            anon = new LazyDslKt.items.2(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.3 anon2 = new LazyDslKt.items.3(contentType, items);
        LazyDslKt.items.4 anon3 = new LazyDslKt.items.4(itemContent, items);
        $this$items.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, anon3));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final <T> void items(androidx.compose.foundation.lazy.LazyListScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function4<? super androidx.compose.foundation.lazy.LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.items.2 anon;
        final int i = 0;
        final int i2 = 0;
        if (key != null) {
            anon = new LazyDslKt.items.2(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.3 anon2 = new LazyDslKt.items.3((Function1)LazyDslKt.items.1.INSTANCE, items);
        LazyDslKt.items.4 anon3 = new LazyDslKt.items.4(itemContent, items);
        $this$items.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, anon3));
    }

    public static final <T> void items(androidx.compose.foundation.lazy.LazyListScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.items.6 anon;
        final int i = 0;
        if (key != null) {
            anon = new LazyDslKt.items.6(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.7 anon2 = new LazyDslKt.items.7(contentType, items);
        LazyDslKt.items.8 anon3 = new LazyDslKt.items.8(itemContent, items);
        $this$items.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1043393750, true, anon3));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final <T> void items(androidx.compose.foundation.lazy.LazyListScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function4<? super androidx.compose.foundation.lazy.LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.items.6 anon;
        final int i = 0;
        final int i2 = 0;
        if (key != null) {
            anon = new LazyDslKt.items.6(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.7 anon2 = new LazyDslKt.items.7((Function1)LazyDslKt.items.5.INSTANCE, items);
        LazyDslKt.items.8 anon3 = new LazyDslKt.items.8(itemContent, items);
        $this$items.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1043393750, true, anon3));
    }

    public static void items$default(androidx.compose.foundation.lazy.LazyListScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function4 itemContent, int i6, Object object7) {
        int anon;
        int obj7;
        androidx.compose.foundation.lazy.LazyDslKt.items.1 obj8;
        int obj10;
        if (i6 & 2 != 0) {
            obj7 = 0;
        }
        if (i6 &= 4 != 0) {
            obj8 = obj10;
        }
        obj10 = 0;
        if (obj7 != null) {
            anon = new LazyDslKt.items.2(obj7, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.3 anon2 = new LazyDslKt.items.3(obj8, items);
        LazyDslKt.items.4 anon3 = new LazyDslKt.items.4(itemContent, items);
        $this$items_u24default.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, anon3));
    }

    public static void items$default(androidx.compose.foundation.lazy.LazyListScope $this$items_u24default, List items, Function1 key, Function4 itemContent, int i5, Object object6) {
        androidx.compose.foundation.lazy.LazyDslKt.items.2 anon;
        int obj10;
        if (i5 &= 2 != 0) {
            obj10 = 0;
        }
        int obj12 = 0;
        final int i = 0;
        if (obj10 != null) {
            anon = new LazyDslKt.items.2(obj10, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.3 anon2 = new LazyDslKt.items.3((Function1)LazyDslKt.items.1.INSTANCE, items);
        LazyDslKt.items.4 anon3 = new LazyDslKt.items.4(itemContent, items);
        $this$items_u24default.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, anon3));
    }

    public static void items$default(androidx.compose.foundation.lazy.LazyListScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function4 itemContent, int i6, Object object7) {
        int anon;
        int obj7;
        androidx.compose.foundation.lazy.LazyDslKt.items.5 obj8;
        int obj10;
        if (i6 & 2 != 0) {
            obj7 = 0;
        }
        if (i6 &= 4 != 0) {
            obj8 = obj10;
        }
        obj10 = 0;
        if (obj7 != null) {
            anon = new LazyDslKt.items.6(obj7, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.7 anon2 = new LazyDslKt.items.7(obj8, items);
        LazyDslKt.items.8 anon3 = new LazyDslKt.items.8(itemContent, items);
        $this$items_u24default.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1043393750, true, anon3));
    }

    public static void items$default(androidx.compose.foundation.lazy.LazyListScope $this$items_u24default, Object[] items, Function1 key, Function4 itemContent, int i5, Object object6) {
        androidx.compose.foundation.lazy.LazyDslKt.items.6 anon;
        int obj10;
        if (i5 &= 2 != 0) {
            obj10 = 0;
        }
        int obj12 = 0;
        final int i = 0;
        if (obj10 != null) {
            anon = new LazyDslKt.items.6(obj10, items);
        } else {
            anon = 0;
        }
        LazyDslKt.items.7 anon2 = new LazyDslKt.items.7((Function1)LazyDslKt.items.5.INSTANCE, items);
        LazyDslKt.items.8 anon3 = new LazyDslKt.items.8(itemContent, items);
        $this$items_u24default.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1043393750, true, anon3));
    }

    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.2 anon;
        final int i = 0;
        if (key != null) {
            anon = new LazyDslKt.itemsIndexed.2(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed.3 anon2 = new LazyDslKt.itemsIndexed.3(contentType, items);
        LazyDslKt.itemsIndexed.4 anon3 = new LazyDslKt.itemsIndexed.4(itemContent, items);
        $this$itemsIndexed.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1091073711, true, anon3));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function5<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.2 anon;
        final int i = 0;
        final int i2 = 0;
        if (key != null) {
            anon = new LazyDslKt.itemsIndexed.2(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.1 anon2 = new LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.1(items);
        LazyDslKt.itemsIndexed.4 anon3 = new LazyDslKt.itemsIndexed.4(itemContent, items);
        $this$itemsIndexed.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1091073711, true, anon3));
    }

    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.6 anon;
        final int i = 0;
        if (key != null) {
            anon = new LazyDslKt.itemsIndexed.6(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed.7 anon2 = new LazyDslKt.itemsIndexed.7(contentType, items);
        LazyDslKt.itemsIndexed.8 anon3 = new LazyDslKt.itemsIndexed.8(itemContent, items);
        $this$itemsIndexed.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(1600639390, true, anon3));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function5<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.6 anon;
        final int i = 0;
        final int i2 = 0;
        if (key != null) {
            anon = new LazyDslKt.itemsIndexed.6(key, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.2 anon2 = new LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.2(items);
        LazyDslKt.itemsIndexed.8 anon3 = new LazyDslKt.itemsIndexed.8(itemContent, items);
        $this$itemsIndexed.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(1600639390, true, anon3));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function5 itemContent, int i6, Object object7) {
        int anon;
        int obj7;
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.1 obj8;
        int obj10;
        if (i6 & 2 != 0) {
            obj7 = 0;
        }
        if (i6 &= 4 != 0) {
            obj8 = obj10;
        }
        obj10 = 0;
        if (obj7 != null) {
            anon = new LazyDslKt.itemsIndexed.2(obj7, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed.3 anon2 = new LazyDslKt.itemsIndexed.3(obj8, items);
        LazyDslKt.itemsIndexed.4 anon3 = new LazyDslKt.itemsIndexed.4(itemContent, items);
        $this$itemsIndexed_u24default.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1091073711, true, anon3));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function5 itemContent, int i5, Object object6) {
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.2 anon;
        int obj9;
        if (i5 &= 2 != 0) {
            obj9 = 0;
        }
        int obj11 = 0;
        final int i = 0;
        if (obj9 != null) {
            anon = new LazyDslKt.itemsIndexed.2(obj9, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.1 anon2 = new LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.1(items);
        LazyDslKt.itemsIndexed.4 anon3 = new LazyDslKt.itemsIndexed.4(itemContent, items);
        $this$itemsIndexed_u24default.items(items.size(), anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1091073711, true, anon3));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function5 itemContent, int i6, Object object7) {
        int anon;
        int obj7;
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.5 obj8;
        int obj10;
        if (i6 & 2 != 0) {
            obj7 = 0;
        }
        if (i6 &= 4 != 0) {
            obj8 = obj10;
        }
        obj10 = 0;
        if (obj7 != null) {
            anon = new LazyDslKt.itemsIndexed.6(obj7, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed.7 anon2 = new LazyDslKt.itemsIndexed.7(obj8, items);
        LazyDslKt.itemsIndexed.8 anon3 = new LazyDslKt.itemsIndexed.8(itemContent, items);
        $this$itemsIndexed_u24default.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(1600639390, true, anon3));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function5 itemContent, int i5, Object object6) {
        androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.6 anon;
        int obj9;
        if (i5 &= 2 != 0) {
            obj9 = 0;
        }
        int obj11 = 0;
        final int i = 0;
        if (obj9 != null) {
            anon = new LazyDslKt.itemsIndexed.6(obj9, items);
        } else {
            anon = 0;
        }
        LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.2 anon2 = new LazyDslKt.itemsIndexed$$inlined.itemsIndexed.default.2(items);
        LazyDslKt.itemsIndexed.8 anon3 = new LazyDslKt.itemsIndexed.8(itemContent, items);
        $this$itemsIndexed_u24default.items(items.length, anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(1600639390, true, anon3));
    }
}
