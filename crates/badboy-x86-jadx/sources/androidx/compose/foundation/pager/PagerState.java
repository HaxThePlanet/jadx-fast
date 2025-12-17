package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008'\u0018\u00002\u00020\u0001B\u001b\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\u0008\u0000\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ7\u0010\u009f\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00032\t\u0008\u0003\u0010¢\u0001\u001a\u00020\u00052\u0010\u0008\u0002\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050¤\u0001H\u0086@¢\u0006\u0003\u0010¥\u0001J$\u0010¦\u0001\u001a\u00030 \u00012\u0007\u0010§\u0001\u001a\u00020b2\t\u0008\u0002\u0010¨\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0003\u0008©\u0001J\u0011\u0010ª\u0001\u001a\u00030 \u0001H\u0082@¢\u0006\u0003\u0010«\u0001J\u0013\u0010¬\u0001\u001a\u00030 \u00012\u0007\u0010­\u0001\u001a\u00020DH\u0002J\u0012\u0010®\u0001\u001a\u00020\u00052\u0007\u0010¯\u0001\u001a\u00020\u0005H\u0016J\u0010\u0010°\u0001\u001a\u00020\u00052\u0007\u0010¡\u0001\u001a\u00020\u0003J\u0012\u0010±\u0001\u001a\u00020\u00162\u0007\u0010²\u0001\u001a\u00020\u0005H\u0002J\t\u0010³\u0001\u001a\u00020\u0016H\u0002J#\u0010´\u0001\u001a\u00020\u00032\u0008\u0010µ\u0001\u001a\u00030¶\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0003\u0008·\u0001J\u001c\u0010¸\u0001\u001a\u00030 \u00012\u0007\u0010¯\u0001\u001a\u00020\u00052\u0007\u0010­\u0001\u001a\u00020DH\u0002J\u0012\u0010¹\u0001\u001a\u00020\u00052\u0007\u0010¯\u0001\u001a\u00020\u0005H\u0002J\u001e\u0010º\u0001\u001a\u00030 \u00012\t\u0008\u0001\u0010¡\u0001\u001a\u00020\u00032\t\u0008\u0003\u0010¢\u0001\u001a\u00020\u0005JK\u0010»\u0001\u001a\u00030 \u00012\u0008\u0010¼\u0001\u001a\u00030½\u00012.\u0010¾\u0001\u001a)\u0008\u0001\u0012\u0005\u0012\u00030À\u0001\u0012\u000c\u0012\n\u0012\u0005\u0012\u00030 \u00010Á\u0001\u0012\u0007\u0012\u0005\u0018\u00010Â\u00010¿\u0001¢\u0006\u0003\u0008Ã\u0001H\u0096@¢\u0006\u0003\u0010Ä\u0001J%\u0010Å\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00032\t\u0008\u0003\u0010¢\u0001\u001a\u00020\u0005H\u0086@¢\u0006\u0003\u0010Æ\u0001J+\u0010Ç\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00032\u0007\u0010È\u0001\u001a\u00020\u00052\u0007\u0010É\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0003\u0008Ê\u0001J\u0013\u0010Ë\u0001\u001a\u00030 \u00012\u0007\u0010§\u0001\u001a\u00020bH\u0002J\r\u0010Ì\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002J#\u0010Í\u0001\u001a\u00030 \u0001*\u00030À\u00012\u0007\u0010¡\u0001\u001a\u00020\u00032\t\u0008\u0003\u0010¢\u0001\u001a\u00020\u0005H\u0007J\u0018\u0010Î\u0001\u001a\u00030 \u0001*\u00030À\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u0003H\u0007R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR+\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008!\u0010\u001d\u001a\u0004\u0008\u001f\u0010\u0019\"\u0004\u0008 \u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010+\"\u0004\u0008,\u0010-R\u001e\u0010.\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010#R\u001e\u00100\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010#R\u000e\u00102\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00085\u00106R\u0014\u00107\u001a\u000208X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0014\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\u00160<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00160<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008>\u0010\u0019R\u0014\u0010?\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008@\u0010\u0019R\u0014\u0010A\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008B\u0010\u0019R\u0011\u0010C\u001a\u00020D8F¢\u0006\u0006\u001a\u0004\u0008E\u0010FR\u001e\u0010G\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u0010#R\u000e\u0010I\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u00020MX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008N\u0010OR\u000e\u0010P\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00020R8@X\u0080\u0084\u0002¢\u0006\u000c\u001a\u0004\u0008U\u0010V*\u0004\u0008S\u0010TR\u0014\u0010W\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008X\u0010#R\u0012\u0010Y\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008Z\u0010#R\u0014\u0010[\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\\\u0010#R\u0014\u0010]\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008^\u0010#R\u0014\u0010_\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008`\u0010#R\u0014\u0010a\u001a\u0008\u0012\u0004\u0012\u00020b0<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\u00020dX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008e\u0010fR\u001c\u0010g\u001a\u00020MX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008h\u0010OR\u0014\u0010i\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008j\u0010%R\u0014\u0010k\u001a\u00020lX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008m\u0010nR\u001a\u0010o\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008p\u0010\u0019\"\u0004\u0008q\u0010\u001bR\"\u0010r\u001a\u00020sX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010x\u001a\u0004\u0008t\u0010u\"\u0004\u0008v\u0010wR\u000e\u0010y\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010z\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008~\u0010\u007f\u001a\u0004\u0008{\u0010#\"\u0004\u0008|\u0010}R7\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\t\u0010\u0015\u001a\u0005\u0018\u00010\u0080\u00018@@BX\u0080\u008e\u0002¢\u0006\u0017\n\u0005\u0008\u0086\u0001\u0010\u001d\u001a\u0006\u0008\u0082\u0001\u0010\u0083\u0001\"\u0006\u0008\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008\u0089\u0001\u0010\u008a\u0001R\u0010\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u008e\u0001\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\u0008\u0090\u0001\u0010\u0091\u0001\u001a\u0005\u0008\u008f\u0001\u0010#R/\u0010\u0092\u0001\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0015\n\u0005\u0008\u0095\u0001\u0010\u007f\u001a\u0005\u0008\u0093\u0001\u0010#\"\u0005\u0008\u0094\u0001\u0010}R\u001f\u0010\u0096\u0001\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\u0008\u0098\u0001\u0010\u0091\u0001\u001a\u0005\u0008\u0097\u0001\u0010#R7\u0010\u009a\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0015\u001a\u00030\u0099\u00018@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0015\n\u0005\u0008\u009d\u0001\u0010\u001d\u001a\u0005\u0008\u009b\u0001\u0010u\"\u0005\u0008\u009c\u0001\u0010wR\u000f\u0010\u009e\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Ï\u0001", d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "currentPageOffsetFraction", "", "(IF)V", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(IFLandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "accumulator", "animatedScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "getCurrentPage", "()I", "getCurrentPageOffsetFraction", "()F", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "firstVisiblePage", "getFirstVisiblePage$foundation_release", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", "indexToPrefetch", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isLastScrollBackwardState", "Landroidx/compose/runtime/MutableState;", "isLastScrollForwardState", "isScrollInProgress", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "layoutWithMeasurement", "getLayoutWithMeasurement$foundation_release", "layoutWithoutMeasurement", "maxScrollOffset", "", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "minScrollOffset", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "pageCount", "getPageCount", "pageSize", "getPageSize$foundation_release", "pageSizeWithSpacing", "getPageSizeWithSpacing$foundation_release", "pageSpacing", "getPageSpacing$foundation_release", "pagerLayoutInfoState", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "positionThresholdFraction", "getPositionThresholdFraction$foundation_release", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation_release", "()J", "setPremeasureConstraints-BRTryo0$foundation_release", "(J)V", "J", "previousPassDelta", "programmaticScrollTargetPage", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "(I)V", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "scrollableState", "settledPage", "getSettledPage", "settledPage$delegate", "Landroidx/compose/runtime/State;", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "targetPage", "getTargetPage", "targetPage$delegate", "Landroidx/compose/ui/geometry/Offset;", "upDownDifference", "getUpDownDifference-F1C5BW0$foundation_release", "setUpDownDifference-k-4lQ0M$foundation_release", "upDownDifference$delegate", "wasPrefetchingForward", "animateScrollToPage", "", "page", "pageOffsetFraction", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "getOffsetDistanceInPages", "isGestureActionMatchesScroll", "scrollDelta", "isNotGestureAction", "matchScrollPositionWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "matchScrollPositionWithKey$foundation_release", "notifyPrefetch", "performScroll", "requestScrollToPage", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "offsetFraction", "forceRemeasure", "snapToItem$foundation_release", "tryRunPrefetch", "coerceInPageRange", "updateCurrentPage", "updateTargetPage", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PagerState implements ScrollableState {

    public static final int $stable;
    private float accumulator;
    private final LazyLayoutAnimateScrollScope animatedScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState<Boolean> isLastScrollBackwardState;
    private final MutableState<Boolean> isLastScrollForwardState;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState<Unit> measurementScopeInvalidator;
    private long minScrollOffset;
    private MutableState<androidx.compose.foundation.pager.PagerMeasureResult> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;
    private final MutableIntState programmaticScrollTargetPage$delegate;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final androidx.compose.foundation.pager.PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasPrefetchingForward;
    static {
    }

    public PagerState() {
        super(0, 0, 0, 7, 0);
    }

    public PagerState(int currentPage, float currentPageOffsetFraction) {
        super(currentPage, currentPageOffsetFraction, 0);
    }

    public PagerState(int i, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2);
    }

    public PagerState(int currentPage, float currentPageOffsetFraction, PrefetchScheduler prefetchScheduler) {
        double cmp;
        int i;
        long l;
        super();
        cmp = (double)currentPageOffsetFraction;
        final int i6 = 1;
        final Boolean valueOf = false;
        if (Double.compare(l2, cmp) <= 0 && Double.compare(cmp, l) <= 0) {
            i = Double.compare(cmp, l) <= 0 ? i6 : i;
        }
        if (i == 0) {
        } else {
            int i4 = 0;
            int i5 = 2;
            this.upDownDifference$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), i4, i5, i4);
            this.animatedScrollScope = PagerLazyAnimateScrollScopeKt.PagerLazyAnimateScrollScope(this);
            PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(currentPage, currentPageOffsetFraction, this);
            this.scrollPosition = pagerScrollPosition;
            this.firstVisiblePage = currentPage;
            this.maxScrollOffset = Long.MAX_VALUE;
            PagerState.scrollableState.1 anon = new PagerState.scrollableState.1(this);
            this.scrollableState = ScrollableStateKt.ScrollableState((Function1)anon);
            this.prefetchingEnabled = i6;
            int i3 = -1;
            this.indexToPrefetch = i3;
            this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
            this.density = (Density)PagerStateKt.access$getUnitDensity$p();
            this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
            this.programmaticScrollTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(i3);
            this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(currentPage);
            PagerState.settledPage.2 anon4 = new PagerState.settledPage.2(this);
            this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)anon4);
            PagerState.targetPage.2 anon5 = new PagerState.targetPage.2(this);
            this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)anon5);
            LazyLayoutPrefetchState lazyLayoutPrefetchState = new LazyLayoutPrefetchState(prefetchScheduler, i4, i5, i4);
            this.prefetchState = lazyLayoutPrefetchState;
            LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
            this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
            AwaitFirstLayoutModifier awaitFirstLayoutModifier = new AwaitFirstLayoutModifier();
            this.awaitLayoutModifier = awaitFirstLayoutModifier;
            this.remeasurement$delegate = SnapshotStateKt.mutableStateOf$default(i4, i4, i5, i4);
            PagerState.remeasurementModifier.1 anon2 = new PagerState.remeasurementModifier.1(this);
            this.remeasurementModifier = (RemeasurementModifier)anon2;
            this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
            LazyLayoutPinnedItemList lazyLayoutPinnedItemList = new LazyLayoutPinnedItemList();
            this.pinnedPages = lazyLayoutPinnedItemList;
            this.scrollPosition.getNearestRangeState();
            this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i4, i6, i4);
            this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i4, i6, i4);
            this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i4, i5, i4);
            this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i4, i5, i4);
            this.isLastScrollForwardState = SnapshotStateKt.mutableStateOf$default(valueOf, i4, i5, i4);
            this.isLastScrollBackwardState = SnapshotStateKt.mutableStateOf$default(valueOf, i4, i5, i4);
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("currentPageOffsetFraction ").append(currentPageOffsetFraction).append(" is not within the range -0.5 to 0.5").toString().toString());
        throw illegalArgumentException;
    }

    public PagerState(int i, float f2, PrefetchScheduler prefetchScheduler3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        int obj3;
        obj1 = i4 & 1 != 0 ? 0 : obj1;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(obj1, obj2, obj3);
    }

    public static final Object access$awaitScrollDependencies(androidx.compose.foundation.pager.PagerState $this, Continuation $completion) {
        return $this.awaitScrollDependencies($completion);
    }

    public static final int access$coerceInPageRange(androidx.compose.foundation.pager.PagerState $this, int $receiver) {
        return $this.coerceInPageRange($receiver);
    }

    public static final int access$getProgrammaticScrollTargetPage(androidx.compose.foundation.pager.PagerState $this) {
        return $this.getProgrammaticScrollTargetPage();
    }

    public static final int access$getSettledPageState(androidx.compose.foundation.pager.PagerState $this) {
        return $this.getSettledPageState();
    }

    public static final float access$performScroll(androidx.compose.foundation.pager.PagerState $this, float delta) {
        return $this.performScroll(delta);
    }

    public static final void access$setRemeasurement(androidx.compose.foundation.pager.PagerState $this, Remeasurement <set-?>) {
        $this.setRemeasurement(<set-?>);
    }

    public static Object animateScrollToPage$default(androidx.compose.foundation.pager.PagerState pagerState, int i2, float f3, AnimationSpec animationSpec4, Continuation continuation5, int i6, Object object7) {
        int obj3;
        androidx.compose.animation.core.SpringSpec obj4;
        int obj6;
        if (object7 != null) {
        } else {
            final int i = 0;
            if (i6 & 2 != 0) {
                obj3 = i;
            }
            if (i6 &= 4 != 0) {
                obj6 = 0;
                obj4 = AnimationSpecKt.spring$default(i, i, obj6, 7, obj6);
            }
            return pagerState.animateScrollToPage(i2, obj3, obj4, continuation5);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        throw obj1;
    }

    public static void applyMeasureResult$foundation_release$default(androidx.compose.foundation.pager.PagerState pagerState, androidx.compose.foundation.pager.PagerMeasureResult pagerMeasureResult2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            pagerState.applyMeasureResult$foundation_release(pagerMeasureResult2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
        throw obj0;
    }

    private final Object awaitScrollDependencies(Continuation<? super Unit> $completion) {
        Object waitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout($completion);
        if (waitForFirstLayout == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return waitForFirstLayout;
        }
        return Unit.INSTANCE;
    }

    private final void cancelPrefetchIfVisibleItemsChanged(androidx.compose.foundation.pager.PagerLayoutInfo info) {
        int indexToPrefetch2;
        int i;
        int indexToPrefetch;
        int beyondViewportPageCount;
        i = -1;
        if (this.indexToPrefetch != i && !(Collection)info.getVisiblePagesInfo().isEmpty()) {
            if (!(Collection)info.getVisiblePagesInfo().isEmpty()) {
                if (this.wasPrefetchingForward) {
                    i2++;
                } else {
                    i3--;
                }
                this.indexToPrefetch = i;
                LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle = this.currentPrefetchHandle;
                if (this.indexToPrefetch != indexToPrefetch2 && currentPrefetchHandle != null) {
                    this.indexToPrefetch = i;
                    currentPrefetchHandle = this.currentPrefetchHandle;
                    if (currentPrefetchHandle != null) {
                        currentPrefetchHandle.cancel();
                    }
                    this.currentPrefetchHandle = 0;
                }
            }
        }
    }

    private final int coerceInPageRange(int $this$coerceInPageRange) {
        int pageCount;
        int coerceIn;
        if (getPageCount() > 0) {
            coerceIn = RangesKt.coerceIn($this$coerceInPageRange, 0, pageCount2--);
        } else {
        }
        return coerceIn;
    }

    private static Object getNearestRange$foundation_release$delegate(androidx.compose.foundation.pager.PagerState <this>) {
        return <this>.scrollPosition.getNearestRangeState();
    }

    private final int getProgrammaticScrollTargetPage() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.programmaticScrollTargetPage$delegate.getIntValue();
    }

    private final int getSettledPageState() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.settledPageState$delegate.getIntValue();
    }

    private final boolean isGestureActionMatchesScroll(float scrollDelta) {
        int notGestureAction;
        float signum;
        int i;
        long upDownDifference-F1C5BW0$foundation_release;
        i = 1;
        final int i4 = 0;
        if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
            notGestureAction = Float.compare(signum2, signum) == 0 ? i : i4;
        } else {
            notGestureAction = Float.compare(signum3, signum) == 0 ? i : i4;
        }
        if (notGestureAction == 0) {
            if (isNotGestureAction()) {
            } else {
                i = i4;
            }
        } else {
        }
        return i;
    }

    private final boolean isNotGestureAction() {
        int i2;
        int i;
        if ((int)x-impl == 0 && (int)y-impl == 0) {
            i = (int)y-impl == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public static int matchScrollPositionWithKey$foundation_release$default(androidx.compose.foundation.pager.PagerState pagerState, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider2, int i3, int i4, Object object5) {
        kotlin.jvm.functions.Function1 readObserver;
        Snapshot currentNonObservable;
        int i;
        int currentPage;
        int obj6;
        int obj7;
        Snapshot obj8;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj6 = Snapshot.Companion;
                obj7 = 0;
                obj8 = obj6.getCurrentThreadSnapshot();
                if (obj8 != null) {
                    readObserver = obj8.getReadObserver();
                } else {
                    readObserver = 0;
                }
                i = 0;
                obj6.restoreNonObservable(obj8, obj6.makeCurrentNonObservable(obj8), readObserver);
                obj6 = currentPage;
            }
            return pagerState.matchScrollPositionWithKey$foundation_release(pagerLazyLayoutItemProvider2, obj6);
        }
        UnsupportedOperationException obj4 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchScrollPositionWithKey");
        throw obj4;
    }

    private final void notifyPrefetch(float delta, androidx.compose.foundation.pager.PagerLayoutInfo info) {
        int empty;
        int first;
        boolean wasPrefetchingForward;
        int schedulePrefetch-0kLqBqw;
        int i;
        int i2;
        int premeasureConstraints;
        int currentPrefetchHandle;
        if (!this.prefetchingEnabled) {
        }
        if (!(Collection)info.getVisiblePagesInfo().isEmpty()) {
            i = 1;
            empty = Float.compare(delta, i3) > 0 ? i : first;
            if (empty != 0) {
                i4 += i;
            } else {
                i5 -= i;
            }
            if (i2 >= 0 && i2 < getPageCount()) {
                if (i2 < getPageCount()) {
                    first = i;
                }
            }
            wasPrefetchingForward = this.currentPrefetchHandle;
            if (first != 0 && i2 != this.indexToPrefetch && this.wasPrefetchingForward != empty && wasPrefetchingForward != null) {
                if (i2 != this.indexToPrefetch) {
                    if (this.wasPrefetchingForward != empty) {
                        wasPrefetchingForward = this.currentPrefetchHandle;
                        if (wasPrefetchingForward != null) {
                            wasPrefetchingForward.cancel();
                        }
                    }
                    this.wasPrefetchingForward = empty;
                    this.indexToPrefetch = i2;
                    this.currentPrefetchHandle = this.prefetchState.schedulePrefetch-0kLqBqw(i2, this.premeasureConstraints);
                }
                if (empty != 0) {
                    currentPrefetchHandle = this.currentPrefetchHandle;
                    if (Float.compare(f2, delta) < 0 && currentPrefetchHandle != null) {
                        currentPrefetchHandle = this.currentPrefetchHandle;
                        if (currentPrefetchHandle != null) {
                            currentPrefetchHandle.markAsUrgent();
                        }
                    }
                } else {
                    premeasureConstraints = this.currentPrefetchHandle;
                    if (Float.compare(f, currentPrefetchHandle) < 0 && premeasureConstraints != null) {
                        premeasureConstraints = this.currentPrefetchHandle;
                        if (premeasureConstraints != null) {
                            premeasureConstraints.markAsUrgent();
                        }
                    }
                }
            }
        }
    }

    private final float performScroll(float delta) {
        int i3;
        int i;
        long isLastScrollBackwardState;
        int i5;
        Number valueOf2;
        int valueOf;
        int $i$f$debugLog;
        int i4;
        int i2;
        final androidx.compose.foundation.pager.PagerState pagerState = this;
        final long currentAbsoluteScrollOffset = PagerScrollPositionKt.currentAbsoluteScrollOffset(pagerState);
        int i6 = 0;
        $i$f$debugLog2 += delta;
        final long roundToLong = MathKt.roundToLong(i7);
        pagerState.accumulator = i7 - f;
        if (Float.compare(f2, i9) < 0) {
            return delta;
        }
        int i10 = currentAbsoluteScrollOffset + roundToLong;
        long coerceIn = RangesKt.coerceIn(i10, obj8, pagerState.minScrollOffset);
        i5 = 1;
        i3 = Long.compare(i10, coerceIn) != 0 ? i5 : 0;
        final int i12 = coerceIn - currentAbsoluteScrollOffset;
        pagerState.previousPassDelta = (float)i12;
        if (Long.compare(l, i2) != 0) {
            i2 = 0;
            i = Float.compare(f3, i2) > 0 ? i5 : 0;
            pagerState.isLastScrollForwardState.setValue(Boolean.valueOf(i));
            i4 = Float.compare(f5, i2) < 0 ? i5 : 0;
            pagerState.isLastScrollBackwardState.setValue(Boolean.valueOf(i4));
        }
        Object value = pagerState.pagerLayoutInfoState.getValue();
        if ((PagerMeasureResult)value.tryToApplyScrollWithoutRemeasure(-i13)) {
            int i15 = 0;
            pagerState.applyMeasureResult$foundation_release(value, i5);
            ObservableScopeInvalidator.invalidateScope-impl(pagerState.placementScopeInvalidator);
            pagerState.layoutWithoutMeasurement = layoutWithoutMeasurement += i5;
        } else {
            int i16 = 0;
            i4 = i5;
            pagerState.scrollPosition.applyScrollDelta((int)i12);
            Remeasurement remeasurement$foundation_release = pagerState.getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            pagerState.layoutWithMeasurement = layoutWithMeasurement++;
        }
        if (i3 != 0) {
            valueOf2 = Long.valueOf(i12);
        } else {
            valueOf2 = Float.valueOf(delta);
        }
        return (Number)valueOf2.floatValue();
    }

    public static void requestScrollToPage$default(androidx.compose.foundation.pager.PagerState pagerState, int i2, float f3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            pagerState.requestScrollToPage(i2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
        throw obj0;
    }

    static Object scroll$suspendImpl(androidx.compose.foundation.pager.PagerState pagerState, MutatePriority mutatePriority2, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function23, Continuation<? super Unit> continuation4) {
        boolean anon;
        int i2;
        int i;
        int awaitScrollDependencies;
        boolean scrollInProgress;
        int i3;
        Object obj;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        anon = continuation4;
        i = Integer.MIN_VALUE;
        if (continuation4 instanceof PagerState.scroll.1 && label &= i != 0) {
            anon = continuation4;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj8 -= i;
            } else {
                anon = new PagerState.scroll.1(pagerState, continuation4);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (awaitScrollDependencies) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                anon.L$0 = pagerState;
                anon.L$1 = mutatePriority2;
                anon.L$2 = function23;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj6 = anon.L$1;
                ResultKt.throwOnFailure(obj8);
                obj7 = obj5;
                obj5 = obj;
                break;
            case 2:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                obj5.setProgrammaticScrollTargetPage(-1);
                return Unit.INSTANCE;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        if (!obj5.isScrollInProgress()) {
            obj5.setSettledPageState(obj5.getCurrentPage());
        }
        anon.L$0 = obj5;
        int i5 = 0;
        anon.L$1 = i5;
        anon.L$2 = i5;
        anon.label = 2;
        if (obj5.scrollableState.scroll(obj6, obj7, anon) == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        }
    }

    public static Object scrollToPage$default(androidx.compose.foundation.pager.PagerState pagerState, int i2, float f3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (object6 != null) {
        } else {
            if (i5 &= 2 != 0) {
                obj2 = 0;
            }
            return pagerState.scrollToPage(i2, obj2, continuation4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        throw obj0;
    }

    private final void setCanScrollBackward(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setCanScrollForward(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.canScrollForward$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setProgrammaticScrollTargetPage(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.programmaticScrollTargetPage$delegate.setIntValue(<set-?>);
    }

    private final void setRemeasurement(Remeasurement <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.remeasurement$delegate.setValue(<set-?>);
    }

    private final void setSettledPageState(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.settledPageState$delegate.setIntValue(<set-?>);
    }

    private final void tryRunPrefetch(androidx.compose.foundation.pager.PagerMeasureResult result) {
        int readObserver;
        int gestureActionMatchesScroll;
        int i;
        final Snapshot.Companion companion = Snapshot.Companion;
        final int i2 = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        int i3 = 0;
        if (Float.compare(f, i) > 0 && this.prefetchingEnabled && isGestureActionMatchesScroll(this.previousPassDelta)) {
            if (this.prefetchingEnabled) {
                if (isGestureActionMatchesScroll(this.previousPassDelta)) {
                    notifyPrefetch(this.previousPassDelta, (PagerLayoutInfo)result);
                }
            }
        }
        Unit $i$a$WithoutReadObservationPagerState$tryRunPrefetch$1 = Unit.INSTANCE;
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
    }

    public static void updateCurrentPage$default(androidx.compose.foundation.pager.PagerState pagerState, ScrollScope scrollScope2, int i3, float f4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 2 != 0) {
                obj3 = 0;
            }
            pagerState.updateCurrentPage(scrollScope2, i3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentPage");
        throw obj0;
    }

    public final Object animateScrollToPage(int i, float f2, AnimationSpec<Float> animationSpec3, Continuation<? super Unit> continuation4) {
        boolean anon2;
        int i3;
        Object l$0;
        int cmp;
        int animatedScrollScope;
        int i4;
        int coerceInPageRange;
        int i2;
        Object obj;
        int currentPage;
        androidx.compose.foundation.pager.PagerState.animateScrollToPage.3 anon;
        double d;
        long l;
        float obj12;
        int obj13;
        Object obj14;
        Object obj15;
        anon2 = continuation4;
        i4 = Integer.MIN_VALUE;
        if (continuation4 instanceof PagerState.animateScrollToPage.1 && label &= i4 != 0) {
            anon2 = continuation4;
            i4 = Integer.MIN_VALUE;
            if (label &= i4 != 0) {
                anon2.label = obj15 -= i4;
            } else {
                anon2 = new PagerState.animateScrollToPage.1(this, continuation4);
            }
        } else {
        }
        final androidx.compose.foundation.pager.PagerState.animateScrollToPage.1 anon3 = anon2;
        obj15 = anon3.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = 1;
        switch (animatedScrollScope) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                l$0 = this;
                currentPage = i2;
                currentPage = coerceInPageRange;
                return Unit.INSTANCE;
                anon3.L$0 = l$0;
                anon3.L$1 = animationSpec3;
                anon3.I$0 = i;
                anon3.F$0 = f2;
                anon3.label = i2;
                return cOROUTINE_SUSPENDED;
                obj13 = i;
                obj12 = f;
                obj = animationSpec3;
                obj14 = l$0;
                break;
            case 1:
                obj12 = anon3.F$0;
                obj13 = anon3.I$0;
                ResultKt.throwOnFailure(obj15);
                obj = obj14;
                obj14 = l$0;
                break;
            case 2:
                ResultKt.throwOnFailure(obj15);
                return Unit.INSTANCE;
            default:
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
        }
        d = (double)obj12;
        if (Double.compare(l, d) <= 0 && Double.compare(d, l) <= 0) {
            if (Double.compare(d, l) <= 0) {
                coerceInPageRange = i2;
            }
        }
        if (coerceInPageRange == 0) {
        } else {
            obj12 = new PagerState.animateScrollToPage.3(obj14);
            obj12 = 0;
            anon3.L$0 = obj12;
            anon3.L$1 = obj12;
            anon3.label = 2;
            if (PagerStateKt.access$animateScrollToPage(obj14.animatedScrollScope, obj14.coerceInPageRange(obj13), obj12 * obj13, obj, (Function2)obj12, anon3) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            }
        }
        obj13 = 0;
        obj14 = new StringBuilder();
        obj13 = new IllegalArgumentException(obj14.append("pageOffsetFraction ").append(obj12).append(" is not within the range -0.5 to 0.5").toString().toString());
        throw obj13;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void applyMeasureResult$foundation_release(androidx.compose.foundation.pager.PagerMeasureResult result, boolean visibleItemsStayedTheSame) {
        Object scrollPosition;
        float currentPageOffsetFraction;
        int index;
        int i = 0;
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateCurrentPageOffsetFraction(result.getCurrentPageOffsetFraction());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            cancelPrefetchIfVisibleItemsChanged((PagerLayoutInfo)result);
        }
        this.pagerLayoutInfoState.setValue(result);
        setCanScrollForward(result.getCanScrollForward());
        setCanScrollBackward(result.getCanScrollBackward());
        androidx.compose.foundation.pager.MeasuredPage firstVisiblePage = result.getFirstVisiblePage();
        if (firstVisiblePage != null) {
            currentPageOffsetFraction = 0;
            this.firstVisiblePage = firstVisiblePage.getIndex();
        }
        this.firstVisiblePageOffset = result.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(result);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset((PagerLayoutInfo)result, getPageCount());
        this.minScrollOffset = PagerStateKt.access$calculateNewMinScrollOffset(result, getPageCount());
        int i2 = 0;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.canScrollBackward$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.canScrollForward$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Density getDensity$foundation_release() {
        return this.density;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getFirstVisiblePage$foundation_release() {
        return this.firstVisiblePage;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getFirstVisiblePageOffset$foundation_release() {
        return this.firstVisiblePageOffset;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final InteractionSource getInteractionSource() {
        return (InteractionSource)this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return (Boolean)this.isLastScrollBackwardState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return (Boolean)this.isLastScrollForwardState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final androidx.compose.foundation.pager.PagerLayoutInfo getLayoutInfo() {
        return (PagerLayoutInfo)this.pagerLayoutInfoState.getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getLayoutWithMeasurement$foundation_release() {
        return this.layoutWithMeasurement;
    }

    public final MutableState<Unit> getMeasurementScopeInvalidator-zYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final IntRange getNearestRange$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (IntRange)(State)this.scrollPosition.getNearestRangeState().getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getNumMeasurePasses$foundation_release() {
        return layoutWithMeasurement += layoutWithoutMeasurement;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float getOffsetDistanceInPages(int page) {
        int i;
        int pageCount;
        i = 0;
        if (page >= 0 && page <= getPageCount()) {
            if (page <= getPageCount()) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            return f -= currentPageOffsetFraction;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("page ").append(page).append(" is not within the range 0 to ").append(getPageCount()).toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public abstract int getPageCount();

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getPageSize$foundation_release() {
        return (PagerMeasureResult)this.pagerLayoutInfoState.getValue().getPageSize();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getPageSizeWithSpacing$foundation_release() {
        return pageSize$foundation_release += pageSpacing$foundation_release;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getPageSpacing$foundation_release() {
        return (PagerMeasureResult)this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final LazyLayoutPinnedItemList getPinnedPages$foundation_release() {
        return this.pinnedPages;
    }

    public final MutableState<Unit> getPlacementScopeInvalidator-zYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float getPositionThresholdFraction$foundation_release() {
        final int i = 0;
        return f /= f3;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final long getPremeasureConstraints-msEJaDk$foundation_release() {
        return this.premeasureConstraints;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Remeasurement getRemeasurement$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (Remeasurement)(State)this.remeasurement$delegate.getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getSettledPage() {
        final int i = 0;
        final int i2 = 0;
        return (Number)this.settledPage$delegate.getValue().intValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getTargetPage() {
        final int i = 0;
        final int i2 = 0;
        return (Number)this.targetPage$delegate.getValue().intValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final long getUpDownDifference-F1C5BW0$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.upDownDifference$delegate.getValue().unbox-impl();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int matchScrollPositionWithKey$foundation_release(androidx.compose.foundation.pager.PagerLazyLayoutItemProvider itemProvider, int currentPage) {
        return this.scrollPosition.matchPageWithKey(itemProvider, currentPage);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void requestScrollToPage(int page, float pageOffsetFraction) {
        boolean scrollInProgress;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i4;
        int i;
        androidx.compose.foundation.pager.PagerState.requestScrollToPage.1 anon;
        int i2;
        int i3;
        if (isScrollInProgress()) {
            i4 = 0;
            scrollInProgress = new PagerState.requestScrollToPage.1(this, i4);
            BuildersKt.launch$default((PagerMeasureResult)this.pagerLayoutInfoState.getValue().getCoroutineScope(), i4, 0, (Function2)scrollInProgress, 3, 0);
        }
        snapToItem$foundation_release(page, pageOffsetFraction, false);
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3) {
        return PagerState.scroll$suspendImpl(this, mutatePriority, function22, continuation3);
    }

    public final Object scrollToPage(int page, float pageOffsetFraction, Continuation<? super Unit> $completion) {
        PagerState.scrollToPage.2 anon = new PagerState.scrollToPage.2(this, pageOffsetFraction, page, 0);
        Object obj9 = ScrollableState.scroll$default((ScrollableState)this, 0, (Function2)anon, $completion, 1, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setDensity$foundation_release(Density <set-?>) {
        this.density = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setPrefetchingEnabled$foundation_release(boolean <set-?>) {
        this.prefetchingEnabled = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setPremeasureConstraints-BRTryo0$foundation_release(long <set-?>) {
        this.premeasureConstraints = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setUpDownDifference-k-4lQ0M$foundation_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.upDownDifference$delegate.setValue(Offset.box-impl(<set-?>));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void snapToItem$foundation_release(int page, float offsetFraction, boolean forceRemeasure) {
        Object measurementScopeInvalidator;
        this.scrollPosition.requestPositionAndForgetLastKnownKey(page, offsetFraction);
        if (forceRemeasure) {
            measurementScopeInvalidator = getRemeasurement$foundation_release();
            if (measurementScopeInvalidator != null) {
                measurementScopeInvalidator.forceRemeasure();
            }
        } else {
            ObservableScopeInvalidator.invalidateScope-impl(this.measurementScopeInvalidator);
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void updateCurrentPage(ScrollScope $this$updateCurrentPage, int page, float pageOffsetFraction) {
        final LazyLayoutAnimateScrollScope animatedScrollScope = this.animatedScrollScope;
        final int i = 0;
        snapToItem$foundation_release(page, pageOffsetFraction, true);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void updateTargetPage(ScrollScope $this$updateTargetPage, int targetPage) {
        setProgrammaticScrollTargetPage(coerceInPageRange(targetPage));
    }
}
