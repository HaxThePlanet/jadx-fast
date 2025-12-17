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
        Object obj3;
        int traceInProgress;
        int $dirty2;
        int $dirty5;
        int defaultsInvalid;
        Object modifier2;
        Object $composer2;
        int $dirty;
        int flingBehavior2;
        int i7;
        Arrangement.Vertical bottom;
        Object $dirty3;
        int i6;
        int rememberLazyListState;
        Object obj;
        Object $dirty4;
        boolean traceInProgress2;
        boolean z;
        int i14;
        Object str;
        Object obj6;
        int changed;
        int i13;
        Object obj5;
        Object obj2;
        Object obj7;
        int i4;
        int i15;
        boolean z2;
        Object reverseLayout2;
        int modifier3;
        int i8;
        Object verticalArrangement2;
        int changed3;
        Object i;
        Object horizontalAlignment2;
        int i12;
        Object obj4;
        int changed2;
        Object i9;
        int i2;
        int i10;
        Function1 function1;
        Composer composer;
        int i5;
        int i3;
        int obj31;
        final int i52 = $changed;
        final int i53 = i11;
        Composer restartGroup = $composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation(restartGroup, "C(LazyColumn)P(4,6,1,5,7,3,2)385@18761L23,391@19115L15,394@19178L350:LazyDsl.kt#428nma");
        $dirty = $changed;
        int i28 = i53 & 1;
        if (i28 != 0) {
            $dirty |= 6;
            $dirty4 = modifier;
        } else {
            if (i52 & 6 == 0) {
                i14 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i14;
            } else {
                $dirty4 = modifier;
            }
        }
        if (i52 & 48 == 0) {
            if (i53 & 2 == 0) {
                changed = restartGroup.changed(state) ? 32 : 16;
            } else {
                str = state;
            }
            $dirty |= changed;
        } else {
            str = state;
        }
        i13 = i53 & 4;
        if (i13 != 0) {
            $dirty |= 384;
            obj2 = contentPadding;
        } else {
            if (i52 & 384 == 0) {
                i4 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty |= i4;
            } else {
                obj2 = contentPadding;
            }
        }
        i15 = i53 & 8;
        if (i15 != 0) {
            $dirty |= 3072;
            z2 = reverseLayout;
        } else {
            if (i52 & 3072 == 0) {
                i8 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                z2 = reverseLayout;
            }
        }
        if (i52 & 24576 == 0) {
            if (i53 & 16 == 0) {
                changed3 = restartGroup.changed(verticalArrangement) ? 16384 : 8192;
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            $dirty |= changed3;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        i = i53 & 32;
        int i57 = 196608;
        if (i != 0) {
            $dirty |= i57;
            horizontalAlignment2 = horizontalAlignment;
        } else {
            if (i57 &= i52 == 0) {
                i12 = restartGroup.changed(horizontalAlignment) ? 131072 : 65536;
                $dirty |= i12;
            } else {
                horizontalAlignment2 = horizontalAlignment;
            }
        }
        if (i59 &= i52 == 0) {
            if (i53 & 64 == 0) {
                changed2 = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                obj4 = flingBehavior;
            }
            $dirty |= changed2;
        } else {
            obj4 = flingBehavior;
        }
        i9 = 12582912;
        if (i53 & 128 != 0) {
            $dirty |= i9;
            obj3 = content;
        } else {
            if (i52 & i9 == 0) {
                i2 = restartGroup.changedInstance(content) ? 8388608 : 4194304;
                $dirty |= i2;
            } else {
                obj3 = content;
            }
        }
        obj31 = $dirty;
        if ($dirty & i10 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i7 = -3670017;
                int i62 = -57345;
                if (i52 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i28 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = $dirty4;
                        }
                        if (i53 & 2 != 0) {
                            int i45 = 0;
                            $dirty4 = obj31 & -113;
                            str = rememberLazyListState;
                        } else {
                            $dirty4 = obj31;
                        }
                        if (i13 != 0) {
                            i13 = 0;
                            obj31 = i7;
                            obj2 = i7;
                        } else {
                            obj31 = i7;
                        }
                        if (i15 != 0) {
                            z2 = i7;
                        }
                        if (i53 & 16 != 0) {
                            Arrangement iNSTANCE = Arrangement.INSTANCE;
                            if (!z2) {
                                bottom = iNSTANCE.getTop();
                            } else {
                                bottom = iNSTANCE.getBottom();
                            }
                            $dirty4 &= i62;
                            verticalArrangement2 = bottom;
                        }
                        if (i != 0) {
                            horizontalAlignment2 = bottom;
                        }
                        if (i53 & 64 != 0) {
                            i = obj2;
                            obj4 = verticalArrangement2;
                            changed2 = horizontalAlignment2;
                            verticalArrangement2 = str;
                            horizontalAlignment2 = z2;
                            reverseLayout2 = modifier2;
                            $dirty5 = i9;
                            i9 = flingBehavior3;
                            flingBehavior2 = i44;
                            i6 = -563353797;
                        } else {
                            flingBehavior2 = $dirty4;
                            i = obj2;
                            changed2 = horizontalAlignment2;
                            i6 = -563353797;
                            horizontalAlignment2 = z2;
                            reverseLayout2 = modifier2;
                            $dirty5 = i9;
                            i9 = obj4;
                            obj4 = verticalArrangement2;
                            verticalArrangement2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty2 = i53 & 2 != 0 ? obj31 & -113 : obj31;
                        if (i53 & 16 != 0) {
                            $dirty2 &= i62;
                        }
                        if (i53 & 64 != 0) {
                            $dirty2 &= i7;
                        }
                        flingBehavior2 = $dirty2;
                        i = obj2;
                        changed2 = horizontalAlignment2;
                        $dirty5 = i9;
                        i6 = -563353797;
                        horizontalAlignment2 = z2;
                        i9 = obj4;
                        reverseLayout2 = $dirty4;
                        obj4 = verticalArrangement2;
                        verticalArrangement2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, flingBehavior2, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:393)");
                }
                LazyDslKt.LazyColumn(reverseLayout2, verticalArrangement2, i, horizontalAlignment2, obj4, changed2, i9, true, content, restartGroup, i26 | i42, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = reverseLayout2;
                obj = i;
                z = horizontalAlignment2;
                obj6 = obj4;
                obj5 = changed2;
                obj7 = i9;
                modifier3 = flingBehavior2;
                $dirty3 = verticalArrangement2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = $dirty4;
                $dirty3 = str;
                obj = obj2;
                z = z2;
                obj6 = verticalArrangement2;
                obj5 = horizontalAlignment2;
                obj7 = obj4;
                modifier3 = obj31;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new LazyDslKt.LazyColumn.2($composer2, $dirty3, obj, z, obj6, obj5, obj7, content, i52, i53);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void LazyColumn(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.LazyListScope, Unit> content, Composer $composer, int $changed, int i12) {
        boolean z;
        Object obj3;
        boolean traceInProgress;
        int defaultsInvalid;
        int rememberLazyListState;
        Arrangement.Vertical bottom;
        int $dirty2;
        boolean traceInProgress2;
        Object $composer2;
        int $dirty;
        Object $dirty3;
        int i14;
        int i6;
        Object obj5;
        int $dirty4;
        Object obj9;
        boolean z2;
        int i10;
        Object obj2;
        Object obj8;
        int changed;
        Object obj10;
        int i13;
        Object obj6;
        Object obj7;
        int i15;
        int z4;
        boolean z3;
        int i4;
        Object obj11;
        int modifier2;
        Object verticalArrangement2;
        boolean changed3;
        int i16;
        Object horizontalAlignment2;
        int i17;
        Object flingBehavior2;
        int changed2;
        int i18;
        int i7;
        int i8;
        int i19;
        int i2;
        Object obj;
        Object obj4;
        int i9;
        int i3;
        Function1 function1;
        Composer composer;
        int i;
        int i5;
        int i11;
        int obj38;
        final int i61 = $changed;
        final int i62 = i12;
        Composer restartGroup = $composer.startRestartGroup(-740714857);
        ComposerKt.sourceInformation(restartGroup, "C(LazyColumn)P(4,6,1,5,8,3,2,7)357@17743L23,363@18097L15,367@18199L388:LazyDsl.kt#428nma");
        $dirty = $changed;
        int i37 = i62 & 1;
        if (i37 != 0) {
            $dirty |= 6;
            obj9 = modifier;
        } else {
            if (i61 & 6 == 0) {
                i10 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i10;
            } else {
                obj9 = modifier;
            }
        }
        if (i61 & 48 == 0) {
            if (i62 & 2 == 0) {
                changed = restartGroup.changed(state) ? 32 : 16;
            } else {
                obj2 = state;
            }
            $dirty |= changed;
        } else {
            obj2 = state;
        }
        i13 = i62 & 4;
        if (i13 != 0) {
            $dirty |= 384;
            obj6 = contentPadding;
        } else {
            if (i61 & 384 == 0) {
                i15 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty |= i15;
            } else {
                obj6 = contentPadding;
            }
        }
        int i59 = i62 & 8;
        if (i59 != 0) {
            $dirty |= 3072;
            z3 = reverseLayout;
        } else {
            if (i61 & 3072 == 0) {
                i4 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                z3 = reverseLayout;
            }
        }
        if (i61 & 24576 == 0) {
            if (i62 & 16 == 0) {
                changed3 = restartGroup.changed(verticalArrangement) ? 16384 : 8192;
            } else {
                obj11 = verticalArrangement;
            }
            $dirty |= changed3;
        } else {
            obj11 = verticalArrangement;
        }
        i16 = i62 & 32;
        int i65 = 196608;
        if (i16 != 0) {
            $dirty |= i65;
            horizontalAlignment2 = horizontalAlignment;
        } else {
            if (i65 &= i61 == 0) {
                i17 = restartGroup.changed(horizontalAlignment) ? 131072 : 65536;
                $dirty |= i17;
            } else {
                horizontalAlignment2 = horizontalAlignment;
            }
        }
        if (i67 &= i61 == 0) {
            if (i62 & 64 == 0) {
                changed2 = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                flingBehavior2 = flingBehavior;
            }
            $dirty |= changed2;
        } else {
            flingBehavior2 = flingBehavior;
        }
        int i21 = i62 & 128;
        int i70 = 12582912;
        if (i21 != 0) {
            $dirty |= i70;
            i18 = i21;
            z = userScrollEnabled;
        } else {
            if (i61 & i70 == 0) {
                i18 = i21;
                i7 = restartGroup.changed(userScrollEnabled) ? 8388608 : 4194304;
                $dirty |= i7;
            } else {
                i18 = i21;
                z = userScrollEnabled;
            }
        }
        i8 = 100663296;
        if (i62 & 256 != 0) {
            $dirty |= i8;
            obj3 = content;
        } else {
            if (i61 & i8 == 0) {
                i8 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
                $dirty |= i8;
            } else {
                obj3 = content;
            }
        }
        obj38 = $dirty;
        if ($dirty & i19 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i14 = -3670017;
                int i72 = -57345;
                if (i61 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i37 != 0) {
                            obj9 = defaultsInvalid;
                        }
                        if (i62 & 2 != 0) {
                            int i24 = 0;
                            $dirty4 = obj38 & -113;
                            obj2 = rememberLazyListState;
                        } else {
                            $dirty4 = obj38;
                        }
                        if (i13 != 0) {
                            i13 = 0;
                            obj38 = i14;
                            obj6 = rememberLazyListState;
                        } else {
                            obj38 = i14;
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
                            $dirty4 &= i72;
                            obj11 = bottom;
                        }
                        if (i16 != 0) {
                            horizontalAlignment2 = bottom;
                        }
                        if (i62 & 64 != 0) {
                            $dirty4 &= obj38;
                            flingBehavior2 = $dirty2;
                        }
                        if (i18 != 0) {
                            i19 = $dirty2;
                            i6 = $dirty4;
                            i16 = obj2;
                            obj4 = obj11;
                            obj = horizontalAlignment2;
                            i18 = flingBehavior2;
                            verticalArrangement2 = obj9;
                            horizontalAlignment2 = obj6;
                            flingBehavior2 = z3;
                        } else {
                            i19 = userScrollEnabled;
                            i6 = $dirty4;
                            i16 = obj2;
                            obj4 = obj11;
                            obj = horizontalAlignment2;
                            i18 = flingBehavior2;
                            verticalArrangement2 = obj9;
                            horizontalAlignment2 = obj6;
                            flingBehavior2 = z3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty2 = i62 & 2 != 0 ? obj38 & -113 : obj38;
                        if (i62 & 16 != 0) {
                            $dirty2 &= i72;
                        }
                        if (i62 & 64 != 0) {
                            $dirty2 &= i14;
                        }
                        i19 = userScrollEnabled;
                        i6 = $dirty2;
                        i16 = obj2;
                        obj4 = obj11;
                        obj = horizontalAlignment2;
                        i18 = flingBehavior2;
                        verticalArrangement2 = obj9;
                        horizontalAlignment2 = obj6;
                        flingBehavior2 = z3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i6, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                LazyListKt.LazyList(verticalArrangement2, i16, horizontalAlignment2, flingBehavior2, true, i18, i19, 0, obj, obj4, 0, 0, content, restartGroup, i32 | i49, i33 &= 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = verticalArrangement2;
                obj5 = horizontalAlignment2;
                z2 = flingBehavior2;
                obj7 = i18;
                z4 = i19;
                obj10 = obj;
                obj8 = obj4;
                modifier2 = i6;
                $dirty3 = i16;
            } else {
                restartGroup.skipToGroupEnd();
                z4 = userScrollEnabled;
                composer = restartGroup;
                $composer2 = obj9;
                $dirty3 = obj2;
                obj5 = obj6;
                z2 = z3;
                obj8 = obj11;
                obj10 = horizontalAlignment2;
                obj7 = flingBehavior2;
                modifier2 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new LazyDslKt.LazyColumn.1($composer2, $dirty3, obj5, z2, obj8, obj10, obj7, z4, content, i61, i62);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final void LazyRow(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, Function1 content, Composer $composer, int $changed, int i11) {
        Object obj5;
        int traceInProgress2;
        int $dirty2;
        int $dirty5;
        int defaultsInvalid;
        Object modifier2;
        Object $composer2;
        int $dirty;
        int flingBehavior2;
        int i7;
        Arrangement.Horizontal start;
        Object $dirty4;
        int i4;
        int rememberLazyListState;
        Object obj4;
        Object $dirty3;
        boolean traceInProgress;
        boolean z2;
        int i3;
        Object str;
        Object obj7;
        int changed;
        int i8;
        Object obj3;
        Object obj6;
        Object obj2;
        int i12;
        int i13;
        boolean z;
        Object reverseLayout2;
        int modifier3;
        int i;
        Object horizontalArrangement2;
        int changed2;
        Object i5;
        Object verticalAlignment2;
        int i9;
        Object obj;
        int changed3;
        Object i2;
        int i14;
        int i15;
        Function1 function1;
        Composer composer;
        int i10;
        int i6;
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
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i3;
            } else {
                $dirty3 = modifier;
            }
        }
        if (i52 & 48 == 0) {
            if (i53 & 2 == 0) {
                changed = restartGroup.changed(state) ? 32 : 16;
            } else {
                str = state;
            }
            $dirty |= changed;
        } else {
            str = state;
        }
        i8 = i53 & 4;
        if (i8 != 0) {
            $dirty |= 384;
            obj6 = contentPadding;
        } else {
            if (i52 & 384 == 0) {
                i12 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty |= i12;
            } else {
                obj6 = contentPadding;
            }
        }
        i13 = i53 & 8;
        if (i13 != 0) {
            $dirty |= 3072;
            z = reverseLayout;
        } else {
            if (i52 & 3072 == 0) {
                i = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty |= i;
            } else {
                z = reverseLayout;
            }
        }
        if (i52 & 24576 == 0) {
            if (i53 & 16 == 0) {
                changed2 = restartGroup.changed(horizontalArrangement) ? 16384 : 8192;
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            $dirty |= changed2;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        i5 = i53 & 32;
        int i57 = 196608;
        if (i5 != 0) {
            $dirty |= i57;
            verticalAlignment2 = verticalAlignment;
        } else {
            if (i57 &= i52 == 0) {
                i9 = restartGroup.changed(verticalAlignment) ? 131072 : 65536;
                $dirty |= i9;
            } else {
                verticalAlignment2 = verticalAlignment;
            }
        }
        if (i59 &= i52 == 0) {
            if (i53 & 64 == 0) {
                changed3 = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                obj = flingBehavior;
            }
            $dirty |= changed3;
        } else {
            obj = flingBehavior;
        }
        i2 = 12582912;
        if (i53 & 128 != 0) {
            $dirty |= i2;
            obj5 = content;
        } else {
            if (i52 & i2 == 0) {
                i14 = restartGroup.changedInstance(content) ? 8388608 : 4194304;
                $dirty |= i14;
            } else {
                obj5 = content;
            }
        }
        obj31 = $dirty;
        if ($dirty & i15 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i7 = -3670017;
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
                            obj31 = i7;
                            obj6 = i7;
                        } else {
                            obj31 = i7;
                        }
                        if (i13 != 0) {
                            z = i7;
                        }
                        if (i53 & 16 != 0) {
                            Arrangement iNSTANCE = Arrangement.INSTANCE;
                            if (!z) {
                                start = iNSTANCE.getStart();
                            } else {
                                start = iNSTANCE.getEnd();
                            }
                            $dirty3 &= i62;
                            horizontalArrangement2 = start;
                        }
                        if (i5 != 0) {
                            verticalAlignment2 = start;
                        }
                        if (i53 & 64 != 0) {
                            i5 = obj6;
                            obj = horizontalArrangement2;
                            changed3 = verticalAlignment2;
                            horizontalArrangement2 = str;
                            verticalAlignment2 = z;
                            reverseLayout2 = modifier2;
                            $dirty5 = i2;
                            i2 = flingBehavior3;
                            flingBehavior2 = i44;
                            i4 = 407929823;
                        } else {
                            flingBehavior2 = $dirty3;
                            i5 = obj6;
                            changed3 = verticalAlignment2;
                            i4 = 407929823;
                            verticalAlignment2 = z;
                            reverseLayout2 = modifier2;
                            $dirty5 = i2;
                            i2 = obj;
                            obj = horizontalArrangement2;
                            horizontalArrangement2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty2 = i53 & 2 != 0 ? obj31 & -113 : obj31;
                        if (i53 & 16 != 0) {
                            $dirty2 &= i62;
                        }
                        if (i53 & 64 != 0) {
                            $dirty2 &= i7;
                        }
                        flingBehavior2 = $dirty2;
                        i5 = obj6;
                        changed3 = verticalAlignment2;
                        $dirty5 = i2;
                        i4 = 407929823;
                        verticalAlignment2 = z;
                        i2 = obj;
                        reverseLayout2 = $dirty3;
                        obj = horizontalArrangement2;
                        horizontalArrangement2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i4, flingBehavior2, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:419)");
                }
                LazyDslKt.LazyRow(reverseLayout2, horizontalArrangement2, i5, verticalAlignment2, obj, changed3, i2, true, content, restartGroup, i26 | i42, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = reverseLayout2;
                obj4 = i5;
                z2 = verticalAlignment2;
                obj7 = obj;
                obj3 = changed3;
                obj2 = i2;
                modifier3 = flingBehavior2;
                $dirty4 = horizontalArrangement2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = $dirty3;
                $dirty4 = str;
                obj4 = obj6;
                z2 = z;
                obj7 = horizontalArrangement2;
                obj3 = verticalAlignment2;
                obj2 = obj;
                modifier3 = obj31;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LazyDslKt.LazyRow.2($composer2, $dirty4, obj4, z2, obj7, obj3, obj2, content, i52, i53);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void LazyRow(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.LazyListScope, Unit> content, Composer $composer, int $changed, int i12) {
        boolean z;
        Object obj9;
        boolean traceInProgress2;
        int defaultsInvalid;
        int rememberLazyListState;
        Arrangement.Horizontal start;
        int $dirty4;
        boolean traceInProgress;
        Object $composer2;
        int $dirty3;
        Object $dirty;
        int i19;
        int i6;
        Object obj10;
        int $dirty2;
        Object obj11;
        boolean z3;
        int i10;
        Object obj4;
        Object obj7;
        int changed3;
        Object obj8;
        int i11;
        Object obj6;
        Object obj5;
        int i13;
        int z2;
        boolean z4;
        int i9;
        Object obj2;
        int modifier2;
        Object horizontalArrangement2;
        boolean changed2;
        int i7;
        Object verticalAlignment2;
        int i;
        Object flingBehavior2;
        int changed;
        int i5;
        int i14;
        int i15;
        int i4;
        int i8;
        int i16;
        int i3;
        Object obj3;
        Object obj;
        Function1 function1;
        Composer composer;
        int i17;
        int i2;
        int i18;
        int obj38;
        final int i58 = $changed;
        final int i59 = i12;
        Composer restartGroup = $composer.startRestartGroup(-1724297413);
        ComposerKt.sourceInformation(restartGroup, "C(LazyRow)P(4,6,1,5,3,8,2,7)301@14811L23,307@15162L15,311@15264L389:LazyDsl.kt#428nma");
        $dirty3 = $changed;
        int i36 = i59 & 1;
        if (i36 != 0) {
            $dirty3 |= 6;
            obj11 = modifier;
        } else {
            if (i58 & 6 == 0) {
                i10 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i10;
            } else {
                obj11 = modifier;
            }
        }
        if (i58 & 48 == 0) {
            if (i59 & 2 == 0) {
                changed3 = restartGroup.changed(state) ? 32 : 16;
            } else {
                obj4 = state;
            }
            $dirty3 |= changed3;
        } else {
            obj4 = state;
        }
        i11 = i59 & 4;
        if (i11 != 0) {
            $dirty3 |= 384;
            obj6 = contentPadding;
        } else {
            if (i58 & 384 == 0) {
                i13 = restartGroup.changed(contentPadding) ? 256 : 128;
                $dirty3 |= i13;
            } else {
                obj6 = contentPadding;
            }
        }
        int i56 = i59 & 8;
        if (i56 != 0) {
            $dirty3 |= 3072;
            z4 = reverseLayout;
        } else {
            if (i58 & 3072 == 0) {
                i9 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty3 |= i9;
            } else {
                z4 = reverseLayout;
            }
        }
        if (i58 & 24576 == 0) {
            if (i59 & 16 == 0) {
                changed2 = restartGroup.changed(horizontalArrangement) ? 16384 : 8192;
            } else {
                obj2 = horizontalArrangement;
            }
            $dirty3 |= changed2;
        } else {
            obj2 = horizontalArrangement;
        }
        i7 = i59 & 32;
        int i62 = 196608;
        if (i7 != 0) {
            $dirty3 |= i62;
            verticalAlignment2 = verticalAlignment;
        } else {
            if (i62 &= i58 == 0) {
                i = restartGroup.changed(verticalAlignment) ? 131072 : 65536;
                $dirty3 |= i;
            } else {
                verticalAlignment2 = verticalAlignment;
            }
        }
        if (i64 &= i58 == 0) {
            if (i59 & 64 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                flingBehavior2 = flingBehavior;
            }
            $dirty3 |= changed;
        } else {
            flingBehavior2 = flingBehavior;
        }
        int i21 = i59 & 128;
        int i67 = 12582912;
        if (i21 != 0) {
            $dirty3 |= i67;
            i5 = i21;
            z = userScrollEnabled;
        } else {
            if (i58 & i67 == 0) {
                i5 = i21;
                i14 = restartGroup.changed(userScrollEnabled) ? 8388608 : 4194304;
                $dirty3 |= i14;
            } else {
                i5 = i21;
                z = userScrollEnabled;
            }
        }
        i15 = 100663296;
        if (i59 & 256 != 0) {
            $dirty3 |= i15;
            obj9 = content;
        } else {
            if (i58 & i15 == 0) {
                i15 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
                $dirty3 |= i15;
            } else {
                obj9 = content;
            }
        }
        obj38 = $dirty3;
        if ($dirty3 & i4 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i19 = -3670017;
                int i69 = -57345;
                if (i58 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i36 != 0) {
                            obj11 = defaultsInvalid;
                        }
                        if (i59 & 2 != 0) {
                            int i24 = 0;
                            $dirty2 = obj38 & -113;
                            obj4 = rememberLazyListState;
                        } else {
                            $dirty2 = obj38;
                        }
                        if (i11 != 0) {
                            i11 = 0;
                            obj38 = i19;
                            obj6 = rememberLazyListState;
                        } else {
                            obj38 = i19;
                        }
                        if (i56 != 0) {
                            z4 = rememberLazyListState;
                        }
                        if (i59 & 16 != 0) {
                            Arrangement iNSTANCE = Arrangement.INSTANCE;
                            if (!z4) {
                                start = iNSTANCE.getStart();
                            } else {
                                start = iNSTANCE.getEnd();
                            }
                            $dirty2 &= i69;
                            obj2 = start;
                        }
                        if (i7 != 0) {
                            verticalAlignment2 = start;
                        }
                        if (i59 & 64 != 0) {
                            $dirty2 &= obj38;
                            flingBehavior2 = $dirty4;
                        }
                        if (i5 != 0) {
                            i4 = $dirty4;
                            i6 = $dirty2;
                            i7 = obj4;
                            obj = obj2;
                            obj3 = verticalAlignment2;
                            i5 = flingBehavior2;
                            horizontalArrangement2 = obj11;
                            verticalAlignment2 = obj6;
                            flingBehavior2 = z4;
                        } else {
                            i4 = userScrollEnabled;
                            i6 = $dirty2;
                            i7 = obj4;
                            obj = obj2;
                            obj3 = verticalAlignment2;
                            i5 = flingBehavior2;
                            horizontalArrangement2 = obj11;
                            verticalAlignment2 = obj6;
                            flingBehavior2 = z4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty4 = i59 & 2 != 0 ? obj38 & -113 : obj38;
                        if (i59 & 16 != 0) {
                            $dirty4 &= i69;
                        }
                        if (i59 & 64 != 0) {
                            $dirty4 &= i19;
                        }
                        i4 = userScrollEnabled;
                        i6 = $dirty4;
                        i7 = obj4;
                        obj = obj2;
                        obj3 = verticalAlignment2;
                        i5 = flingBehavior2;
                        horizontalArrangement2 = obj11;
                        verticalAlignment2 = obj6;
                        flingBehavior2 = z4;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i6, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:310)");
                }
                LazyListKt.LazyList(horizontalArrangement2, i7, verticalAlignment2, flingBehavior2, false, i5, i4, 0, 0, 0, obj3, obj, content, restartGroup, i30 | i44, i33 | i48, 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = horizontalArrangement2;
                obj10 = verticalAlignment2;
                z3 = flingBehavior2;
                obj5 = i5;
                z2 = i4;
                obj8 = obj3;
                obj7 = obj;
                modifier2 = i6;
                $dirty = i7;
            } else {
                restartGroup.skipToGroupEnd();
                z2 = userScrollEnabled;
                composer = restartGroup;
                $composer2 = obj11;
                $dirty = obj4;
                obj10 = obj6;
                z3 = z4;
                obj7 = obj2;
                obj8 = verticalAlignment2;
                obj5 = flingBehavior2;
                modifier2 = obj38;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LazyDslKt.LazyRow.1($composer2, $dirty, obj10, z3, obj7, obj8, obj5, z2, content, i58, i59);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
