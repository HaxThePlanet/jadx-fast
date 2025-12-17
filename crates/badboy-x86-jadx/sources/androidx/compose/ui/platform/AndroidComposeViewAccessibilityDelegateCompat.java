package androidx.compose.ui.platform;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import androidx.collection.ArraySet;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R.id;
import androidx.compose.ui.R.string;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusDirection.Companion;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode.Companion;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.LiveRegionMode.Companion;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.ProgressBarRangeInfo.Companion;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\"\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u0000 ú\u00012\u00020\u0001:\u0010ø\u0001ù\u0001ú\u0001û\u0001ü\u0001ý\u0001þ\u0001ÿ\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010p\u001a\u00020!2\u0006\u0010q\u001a\u00020\u00122\u0006\u0010r\u001a\u00020*2\u0006\u0010s\u001a\u00020\u00062\u0008\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0010\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020%H\u0002J\u0010\u0010y\u001a\u00020!H\u0080@¢\u0006\u0004\u0008z\u0010{J;\u0010|\u001a\u00020\u00142\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020%0$2\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00122\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001J-\u0010|\u001a\u00020\u00142\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00122\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u0083\u0001\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020!H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u001a\u0010\u0087\u0001\u001a\u00020N2\u0006\u0010q\u001a\u00020\u00122\u0007\u0010\u0088\u0001\u001a\u00020\u0012H\u0003J\u0013\u0010\u0089\u0001\u001a\u0004\u0018\u00010*2\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0014\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002JC\u0010\u008c\u0001\u001a\u00020N2\u0006\u0010q\u001a\u00020\u00122\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0003\u0010\u0091\u0001J\u0019\u0010\u0092\u0001\u001a\u00020\u00142\u0008\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0000¢\u0006\u0003\u0008\u0095\u0001JF\u0010\u0096\u0001\u001a\u00020!2\u0008\u0010\u0097\u0001\u001a\u00030\u008b\u00012\u001b\u0010\u0098\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008b\u00010\u0099\u0001j\n\u0012\u0005\u0012\u00030\u008b\u0001`\u009a\u00012\u0014\u0010\u009b\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008b\u00010,0WH\u0002J\u0014\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0008\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0012\u0010 \u0001\u001a\u00020\u00122\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010¡\u0001\u001a\u00020\u00122\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010¢\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010£\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0015\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0016\u0010¦\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010x\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J \u0010§\u0001\u001a\u0005\u0018\u00010¨\u00012\t\u0010x\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010©\u0001\u001a\u00020\u0012H\u0002J#\u0010ª\u0001\u001a\u00020\u00122\u0008\u0010«\u0001\u001a\u00030¬\u00012\u0008\u0010­\u0001\u001a\u00030¬\u0001H\u0001¢\u0006\u0003\u0008®\u0001J\u0011\u0010¯\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0012\u0010°\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010±\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010²\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0002J\u0018\u0010´\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0000¢\u0006\u0003\u0008µ\u0001J\u000f\u0010¶\u0001\u001a\u00020!H\u0000¢\u0006\u0003\u0008·\u0001J$\u0010¸\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00122\u0007\u0010¹\u0001\u001a\u00020\u00122\u0008\u0010t\u001a\u0004\u0018\u00010uH\u0002J#\u0010º\u0001\u001a\u00020!2\u0006\u0010q\u001a\u00020\u00122\u0006\u0010r\u001a\u00020*2\u0008\u0010»\u0001\u001a\u00030\u008b\u0001H\u0002J!\u0010¼\u0001\u001a\u00020\u00142\u0007\u0010½\u0001\u001a\u00020\u00122\r\u0010¾\u0001\u001a\u0008\u0012\u0004\u0012\u00020b0/H\u0002J\u0011\u0010¿\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0012\u0010À\u0001\u001a\u00020!2\u0007\u0010Á\u0001\u001a\u00020bH\u0002J'\u0010Â\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008b\u00010Ã\u0001j\n\u0012\u0005\u0012\u00030\u008b\u0001`Ä\u00012\u0007\u0010Å\u0001\u001a\u00020\u0014H\u0082\u0008J\u0012\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010½\u0001\u001a\u00020\u0012H\u0002J\u001c\u0010Ç\u0001\u001a\u00020!2\u0008\u0010È\u0001\u001a\u00030\u008b\u00012\u0007\u0010É\u0001\u001a\u00020]H\u0002J\u0012\u0010Ê\u0001\u001a\u00020\u00142\u0007\u0010\u0093\u0001\u001a\u00020NH\u0002J@\u0010Ë\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00122\u0007\u0010\u0088\u0001\u001a\u00020\u00122\u000b\u0008\u0002\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00122\u0011\u0008\u0002\u0010Í\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/H\u0002¢\u0006\u0003\u0010Î\u0001J&\u0010Ï\u0001\u001a\u00020!2\u0007\u0010Ð\u0001\u001a\u00020\u00122\u0007\u0010Ì\u0001\u001a\u00020\u00122\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010Ò\u0001\u001a\u00020!2\u0007\u0010Ð\u0001\u001a\u00020\u0012H\u0002J\u0018\u0010Ó\u0001\u001a\u00020!2\r\u0010Ô\u0001\u001a\u0008\u0012\u0004\u0012\u00020%0$H\u0002J\u001b\u0010Õ\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020i2\u0007\u0010Ö\u0001\u001a\u00020UH\u0002J\u0012\u0010×\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0002J-\u0010Ø\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u00012\u0007\u0010Ù\u0001\u001a\u00020\u00122\u0007\u0010Ú\u0001\u001a\u00020\u00122\u0007\u0010Û\u0001\u001a\u00020\u0014H\u0002J\u001a\u0010Ü\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010Ý\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010Þ\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010ß\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\t\u0010à\u0001\u001a\u00020!H\u0002JN\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010,2\u0007\u0010Å\u0001\u001a\u00020\u00142\u001b\u0010â\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008b\u00010\u0099\u0001j\n\u0012\u0005\u0012\u00030\u008b\u0001`\u009a\u00012\u0016\u0008\u0002\u0010ã\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008b\u00010,0WH\u0002J)\u0010ä\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010,2\u0007\u0010Å\u0001\u001a\u00020\u00142\u000e\u0010å\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010,H\u0002J\"\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0008\u0010é\u0001\u001a\u00030ê\u0001H\u0002J-\u0010ë\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u00012\u0007\u0010©\u0001\u001a\u00020\u00122\u0007\u0010ì\u0001\u001a\u00020\u00142\u0007\u0010í\u0001\u001a\u00020\u0014H\u0002J4\u0010î\u0001\u001a\u0005\u0018\u0001Hï\u0001\"\t\u0008\u0000\u0010ï\u0001*\u00020\u001e2\n\u0010\u0090\u0001\u001a\u0005\u0018\u0001Hï\u00012\t\u0008\u0001\u0010ð\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0003\u0010ñ\u0001J\u0011\u0010ò\u0001\u001a\u00020!2\u0006\u0010q\u001a\u00020\u0012H\u0002J\t\u0010ó\u0001\u001a\u00020!H\u0002J\u0011\u0010ô\u0001\u001a\u0005\u0018\u00010¥\u0001*\u00030õ\u0001H\u0002J\u0011\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001*\u00030¥\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008R\u001a\u0010\u000b\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u001d0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020%0$8BX\u0082\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010+\u001a&\u0012\u000c\u0012\n .*\u0004\u0018\u00010-0- .*\u0012\u0012\u000c\u0012\n .*\u0004\u0018\u00010-0-\u0018\u00010/0,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u00086\u00107\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R\u001a\u0010<\u001a\u00020=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010?\"\u0004\u0008@\u0010AR\u001a\u0010B\u001a\u00020=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u0010?\"\u0004\u0008D\u0010AR\u0014\u0010E\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008F\u0010\u0017R\u0014\u0010G\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008G\u0010\u0017R\u001a\u0010H\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0I0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010J\u001a\u00060KR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010L\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00140M8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008O\u00107\u001a\u0004\u0008P\u0010Q\"\u0004\u0008R\u0010SR\u000e\u0010T\u001a\u00020UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u0008\u0012\u0004\u0012\u00020X0WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u0008\u0012\u0004\u0012\u00020X0WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020]0WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010_\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010`R\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020!0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\u0008\u0012\u0004\u0012\u00020b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010g\u001a\u0008\u0012\u0004\u0012\u00020i0hX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008n\u0010o\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0080\u0002", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "ExtraDataTestTraversalAfterVal", "", "getExtraDataTestTraversalAfterVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalBeforeVal", "getExtraDataTestTraversalBeforeVal$ui_release", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui_release", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui_release", "(J)V", "accessibilityCursorPosition", "", "value", "", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "currentSemanticsNodesInvalidated", "currentlyFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release$annotations", "()V", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Landroidx/collection/MutableIntIntMap;", "getIdToAfterMap$ui_release", "()Landroidx/collection/MutableIntIntMap;", "setIdToAfterMap$ui_release", "(Landroidx/collection/MutableIntIntMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabled$ui_release", "isTouchExplorationEnabled", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "getOnSendAccessibilityEvent$ui_release$annotations", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "pendingVerticalScrollEvents", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scheduleScrollEventIfNeededLambda", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scrollObservationScopes", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendingFocusAffectingEvent", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsInScreen", "Landroid/graphics/Rect;", "node", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "eventType", "createNodeInfo", "createStateDescriptionForTextField", "Landroidx/compose/ui/semantics/SemanticsNode;", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "geometryDepthFirstSearch", "currNode", "geometryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "containerMapToChildren", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "getAccessibilitySelectionStart", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroidx/compose/ui/text/AnnotatedString;", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "isScreenReaderFocusable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "scheduleScrollEventIfNeeded", "scrollObservationScope", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "sendTypeViewScrolledAccessibilityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setIsCheckable", "setStateDescription", "setText", "setTraversalValues", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "toSpannableString", "Landroid/text/SpannableString;", "Api24Impl", "Api29Impl", "Companion", "ComposeAccessibilityNodeProvider", "LtrBoundsComparator", "PendingTextTraversedEvent", "RtlBoundsComparator", "TopBottomBoundsComparator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {

    public static final int $stable = 0;
    private static final IntList AccessibilityActionsResourceIds = null;
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.Companion Companion = null;
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000L;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis = 100;
    private int accessibilityCursorPosition = -1;
    private boolean accessibilityForceEnabledForTesting;
    private final AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<java.lang.CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated = true;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId = Integer.MIN_VALUE;
    private final Handler handler;
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<java.lang.CharSequence>> labelToActionId;
    private androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.ComposeAccessibilityNodeProvider nodeProvider;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<androidx.compose.ui.platform.SemanticsNodeCopy> previousSemanticsNodes;
    private androidx.compose.ui.platform.SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final Function1<androidx.compose.ui.platform.ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<androidx.compose.ui.platform.ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final androidx.compose.ui.platform.AndroidComposeView view;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api24Impl {

        public static final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.Api24Impl INSTANCE;
        static {
            AndroidComposeViewAccessibilityDelegateCompat.Api24Impl api24Impl = new AndroidComposeViewAccessibilityDelegateCompat.Api24Impl();
            AndroidComposeViewAccessibilityDelegateCompat.Api24Impl.INSTANCE = api24Impl;
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean orNull;
            androidx.compose.ui.semantics.SemanticsPropertyKey setProgress;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
            String label;
            int i;
            orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress());
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode) && (AccessibilityAction)orNull != null) {
                orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress());
                if ((AccessibilityAction)(AccessibilityAction)orNull != null) {
                    setProgress = 0;
                    accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, (CharSequence)(AccessibilityAction)(AccessibilityAction)orNull.getLabel());
                    info.addAction(accessibilityActionCompat);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api29Impl {

        public static final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.Api29Impl INSTANCE;
        static {
            AndroidComposeViewAccessibilityDelegateCompat.Api29Impl api29Impl = new AndroidComposeViewAccessibilityDelegateCompat.Api29Impl();
            AndroidComposeViewAccessibilityDelegateCompat.Api29Impl.INSTANCE = api29Impl;
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean orNull;
            androidx.compose.ui.semantics.SemanticsPropertyKey pageRight;
            androidx.compose.ui.semantics.SemanticsPropertyKey pageUp;
            androidx.compose.ui.semantics.SemanticsPropertyKey pageDown;
            androidx.compose.ui.semantics.SemanticsPropertyKey pageLeft;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
            String label;
            int i;
            Object orNull2 = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode) && (AccessibilityAction)orNull2 != null) {
                orNull2 = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
                if ((AccessibilityAction)(AccessibilityAction)orNull2 != null) {
                    pageUp = 0;
                    accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, (CharSequence)(AccessibilityAction)(AccessibilityAction)orNull2.getLabel());
                    info.addAction(accessibilityActionCompat);
                }
                Object orNull3 = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageDown());
                if ((AccessibilityAction)orNull3 != null) {
                    pageDown = 0;
                    accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, (CharSequence)(AccessibilityAction)orNull3.getLabel());
                    info.addAction(accessibilityActionCompat);
                }
                Object orNull4 = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageLeft());
                if ((AccessibilityAction)orNull4 != null) {
                    pageLeft = 0;
                    accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908360, (CharSequence)(AccessibilityAction)orNull4.getLabel());
                    info.addAction(accessibilityActionCompat);
                }
                orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageRight());
                if ((AccessibilityAction)orNull != null) {
                    pageRight = 0;
                    accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908361, (CharSequence)(AccessibilityAction)orNull.getLabel());
                    info.addAction(accessibilityActionCompat);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "()V", "AccessibilityActionsResourceIds", "Landroidx/collection/IntList;", "AccessibilityCursorPositionUndefined", "", "AccessibilitySliderStepsCount", "ClassName", "", "ExtraDataIdKey", "ExtraDataTestTagKey", "InvalidId", "LogTag", "ParcelSafeTextLength", "TextClassName", "TextFieldClassName", "TextTraversedEventTimeoutMillis", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016¨\u0006\u0013", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "findFocus", "focus", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {

        final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat this$0;
        public ComposeAccessibilityNodeProvider(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
            AndroidComposeViewAccessibilityDelegateCompat.access$addExtraDataToAccessibilityNodeInfoHelper(this.this$0, virtualViewId, info, extraDataKey, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            boolean z;
            final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat this$0 = this.this$0;
            final int i = 0;
            Trace.beginSection("createAccessibilityNodeInfo");
            final int i2 = 0;
            final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AndroidComposeViewAccessibilityDelegateCompat.access$createNodeInfo(this$0, virtualViewId);
            final int i3 = 0;
            if (AndroidComposeViewAccessibilityDelegateCompat.access$getSendingFocusAffectingEvent$p(this$0) && virtualViewId == AndroidComposeViewAccessibilityDelegateCompat.access$getFocusedVirtualViewId$p(this$0)) {
                if (virtualViewId == AndroidComposeViewAccessibilityDelegateCompat.access$getFocusedVirtualViewId$p(this$0)) {
                    AndroidComposeViewAccessibilityDelegateCompat.access$setCurrentlyFocusedANI$p(this$0, accessibilityNodeInfoCompat);
                }
            }
            Trace.endSection();
            return accessibilityNodeInfoCompat;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int focus) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.access$getFocusedVirtualViewId$p(this.this$0));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.access$performActionHelper(this.this$0, virtualViewId, action, arguments);
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\u0008\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u0002H\u0016¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LtrBoundsComparator implements Comparator<SemanticsNode> {

        public static final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.LtrBoundsComparator INSTANCE;
        static {
            AndroidComposeViewAccessibilityDelegateCompat.LtrBoundsComparator ltrBoundsComparator = new AndroidComposeViewAccessibilityDelegateCompat.LtrBoundsComparator();
            AndroidComposeViewAccessibilityDelegateCompat.LtrBoundsComparator.INSTANCE = ltrBoundsComparator;
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a, SemanticsNode b) {
            final Rect boundsInWindow = a.getBoundsInWindow();
            final Rect boundsInWindow2 = b.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow.getLeft(), boundsInWindow2.getLeft());
            if (compare != 0) {
                return compare;
            }
            int r = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (r != 0) {
                return r;
            }
            int r2 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            if (r2 != 0) {
                return r2;
            }
            return Float.compare(boundsInWindow.getRight(), boundsInWindow2.getRight());
        }

        @Override // java.util.Comparator
        public int compare(Object p0, Object p1) {
            return compare((SemanticsNode)p0, (SemanticsNode)p1);
        }
    }

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u0015", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PendingTextTraversedEvent {

        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;
        public PendingTextTraversedEvent(SemanticsNode node, int action, int granularity, int fromIndex, int toIndex, long traverseTime) {
            super();
            this.node = node;
            this.action = action;
            this.granularity = granularity;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.traverseTime = traverseTime;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\u0008\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u0002H\u0016¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$RtlBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RtlBoundsComparator implements Comparator<SemanticsNode> {

        public static final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.RtlBoundsComparator INSTANCE;
        static {
            AndroidComposeViewAccessibilityDelegateCompat.RtlBoundsComparator rtlBoundsComparator = new AndroidComposeViewAccessibilityDelegateCompat.RtlBoundsComparator();
            AndroidComposeViewAccessibilityDelegateCompat.RtlBoundsComparator.INSTANCE = rtlBoundsComparator;
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a, SemanticsNode b) {
            final Rect boundsInWindow = a.getBoundsInWindow();
            final Rect boundsInWindow2 = b.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow2.getRight(), boundsInWindow.getRight());
            if (compare != 0) {
                return compare;
            }
            int r = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (r != 0) {
                return r;
            }
            int r2 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            if (r2 != 0) {
                return r2;
            }
            return Float.compare(boundsInWindow2.getLeft(), boundsInWindow.getLeft());
        }

        @Override // java.util.Comparator
        public int compare(Object p0, Object p1) {
            return compare((SemanticsNode)p0, (SemanticsNode)p1);
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0007J<\u0010\u0008\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TopBottomBoundsComparator implements Comparator<Pair<? extends Rect, ? extends List<SemanticsNode>>> {

        public static final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.TopBottomBoundsComparator INSTANCE;
        static {
            AndroidComposeViewAccessibilityDelegateCompat.TopBottomBoundsComparator topBottomBoundsComparator = new AndroidComposeViewAccessibilityDelegateCompat.TopBottomBoundsComparator();
            AndroidComposeViewAccessibilityDelegateCompat.TopBottomBoundsComparator.INSTANCE = topBottomBoundsComparator;
        }

        @Override // java.util.Comparator
        public int compare(Object p0, Object p1) {
            return compare((Pair)p0, (Pair)p1);
        }

        public int compare(Pair<Rect, ? extends List<SemanticsNode>> a, Pair<Rect, ? extends List<SemanticsNode>> b) {
            int compare = Float.compare((Rect)a.getFirst().getTop(), (Rect)b.getFirst().getTop());
            if (compare != 0) {
                return compare;
            }
            return Float.compare((Rect)a.getFirst().getBottom(), (Rect)b.getFirst().getBottom());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            AndroidComposeViewAccessibilityDelegateCompat.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static void $r8$lambda$Bjg8EVlp22_RmVyYwEP9YmwC-TM(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z2) {
        AndroidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener$lambda$1(androidComposeViewAccessibilityDelegateCompat, z2);
    }

    public static void $r8$lambda$ZvtfIYaAmMxVM15Q14y2sTXD1bk(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$60(androidComposeViewAccessibilityDelegateCompat);
    }

    public static int $r8$lambda$rA4f2K7xS121tETah-VfjYvxJ1I(Function2 function2, Object object2, Object object3) {
        return AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings$lambda$15(function2, object2, object3);
    }

    public static void $r8$lambda$z8GsJHrgsO9Qu7VKnO0pEHmsLYk(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z2) {
        AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(androidComposeViewAccessibilityDelegateCompat, z2);
    }

    static {
        AndroidComposeViewAccessibilityDelegateCompat.Companion companion = new AndroidComposeViewAccessibilityDelegateCompat.Companion(0);
        AndroidComposeViewAccessibilityDelegateCompat.Companion = companion;
        AndroidComposeViewAccessibilityDelegateCompat.$stable = 8;
        AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds = IntListKt.intListOf(/* result */);
    }

    public AndroidComposeViewAccessibilityDelegateCompat(androidx.compose.ui.platform.AndroidComposeView view) {
        super();
        this.view = view;
        int i = Integer.MIN_VALUE;
        AndroidComposeViewAccessibilityDelegateCompat.onSendAccessibilityEvent.1 anon2 = new AndroidComposeViewAccessibilityDelegateCompat.onSendAccessibilityEvent.1(this);
        this.onSendAccessibilityEvent = (Function1)anon2;
        Object systemService = this.view.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (AccessibilityManager)systemService;
        int i3 = 100;
        AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1(this);
        this.enabledStateListener = externalSyntheticLambda1;
        AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(this);
        this.touchExplorationStateListener = externalSyntheticLambda2;
        this.enabledServices = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        Handler handler = new Handler(Looper.getMainLooper());
        this.handler = handler;
        AndroidComposeViewAccessibilityDelegateCompat.ComposeAccessibilityNodeProvider composeAccessibilityNodeProvider = new AndroidComposeViewAccessibilityDelegateCompat.ComposeAccessibilityNodeProvider(this);
        this.nodeProvider = composeAccessibilityNodeProvider;
        int i4 = 0;
        int i6 = 1;
        final int i7 = 0;
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(i4, i6, i7);
        this.pendingHorizontalScrollEvents = mutableIntObjectMap;
        MutableIntObjectMap mutableIntObjectMap2 = new MutableIntObjectMap(i4, i6, i7);
        this.pendingVerticalScrollEvents = mutableIntObjectMap2;
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(i4, i6, i7);
        this.actionIdToLabel = sparseArrayCompat;
        SparseArrayCompat sparseArrayCompat2 = new SparseArrayCompat(i4, i6, i7);
        this.labelToActionId = sparseArrayCompat2;
        ArraySet arraySet = new ArraySet(i4, i6, i7);
        this.subtreeChangedLayoutNodes = arraySet;
        this.boundsUpdateChannel = ChannelKt.Channel$default(i6, i7, i7, 6, i7);
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        MutableIntSet mutableIntSet = new MutableIntSet(i4, i6, i7);
        this.paneDisplayed = mutableIntSet;
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(i4, i6, i7);
        this.idToBeforeMap = mutableIntIntMap;
        MutableIntIntMap mutableIntIntMap2 = new MutableIntIntMap(i4, i6, i7);
        this.idToAfterMap = mutableIntIntMap2;
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        URLSpanCache uRLSpanCache = new URLSpanCache();
        this.urlSpanCache = uRLSpanCache;
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        SemanticsNodeCopy semanticsNodeCopy = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.previousSemanticsRoot = semanticsNodeCopy;
        AndroidComposeViewAccessibilityDelegateCompat.1 anon3 = new AndroidComposeViewAccessibilityDelegateCompat.1(this);
        this.view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)anon3);
        AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3(this);
        this.semanticsChangeChecker = externalSyntheticLambda3;
        ArrayList arrayList = new ArrayList();
        this.scrollObservationScopes = (List)arrayList;
        AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeededLambda.1 anon = new AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeededLambda.1(this);
        this.scheduleScrollEventIfNeededLambda = (Function1)anon;
    }

    public static final void access$addExtraDataToAccessibilityNodeInfoHelper(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
        $this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
    }

    public static final Rect access$boundsInScreen(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds node) {
        return $this.boundsInScreen(node);
    }

    public static final AccessibilityNodeInfoCompat access$createNodeInfo(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, int virtualViewId) {
        return $this.createNodeInfo(virtualViewId);
    }

    public static final AccessibilityManager access$getAccessibilityManager$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.accessibilityManager;
    }

    public static final IntObjectMap access$getCurrentSemanticsNodes(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.getCurrentSemanticsNodes();
    }

    public static final AccessibilityNodeInfoCompat access$getCurrentlyFocusedANI$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.currentlyFocusedANI;
    }

    public static final AccessibilityManager.AccessibilityStateChangeListener access$getEnabledStateListener$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.enabledStateListener;
    }

    public static final int access$getFocusedVirtualViewId$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.focusedVirtualViewId;
    }

    public static final Handler access$getHandler$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.handler;
    }

    public static final MutableIntObjectMap access$getPendingHorizontalScrollEvents$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.pendingHorizontalScrollEvents;
    }

    public static final MutableIntObjectMap access$getPendingVerticalScrollEvents$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.pendingVerticalScrollEvents;
    }

    public static final Runnable access$getSemanticsChangeChecker$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.semanticsChangeChecker;
    }

    public static final boolean access$getSendingFocusAffectingEvent$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.sendingFocusAffectingEvent;
    }

    public static final AccessibilityManager.TouchExplorationStateChangeListener access$getTouchExplorationStateListener$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this) {
        return $this.touchExplorationStateListener;
    }

    public static final void access$notifySubtreeAccessibilityStateChangedIfNeeded(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, LayoutNode layoutNode) {
        $this.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
    }

    public static final boolean access$performActionHelper(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, int virtualViewId, int action, Bundle arguments) {
        return $this.performActionHelper(virtualViewId, action, arguments);
    }

    public static final void access$scheduleScrollEventIfNeeded(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, androidx.compose.ui.platform.ScrollObservationScope scrollObservationScope) {
        $this.scheduleScrollEventIfNeeded(scrollObservationScope);
    }

    public static final int access$semanticsNodeIdToAccessibilityVirtualNodeId(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, int id) {
        return $this.semanticsNodeIdToAccessibilityVirtualNodeId(id);
    }

    public static final void access$setCurrentlyFocusedANI$p(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat $this, AccessibilityNodeInfoCompat <set-?>) {
        $this.currentlyFocusedANI = <set-?>;
    }

    private final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
        Object semanticsNode;
        boolean contains;
        boolean contains2;
        boolean orDefault;
        androidx.compose.ui.semantics.SemanticsPropertyKey testTag;
        String length;
        androidx.compose.ui.semantics.SemanticsPropertyKey getTextLayoutResult;
        ArrayList arrayList;
        int i;
        Bundle extras;
        Object[] $this$toTypedArray$iv;
        int screenCoords;
        ArrayList list;
        RectF[] arr;
        semanticsNode = getCurrentSemanticsNodes().get(virtualViewId);
        if ((SemanticsNodeWithAdjustedBounds)semanticsNode != null) {
            semanticsNode = (SemanticsNodeWithAdjustedBounds)semanticsNode.getSemanticsNode();
            if (semanticsNode == null) {
            } else {
                final String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
                testTag = -1;
                if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalBeforeVal)) {
                    orDefault = this.idToBeforeMap.getOrDefault(virtualViewId, testTag);
                    getTextLayoutResult = 0;
                    if (orDefault != testTag) {
                        info.getExtras().putInt(extraDataKey, orDefault);
                    }
                } else {
                    if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalAfterVal)) {
                        orDefault = this.idToAfterMap.getOrDefault(virtualViewId, testTag);
                        getTextLayoutResult = 0;
                        if (orDefault != testTag) {
                            info.getExtras().putInt(extraDataKey, orDefault);
                        }
                    } else {
                        orDefault = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", testTag);
                        testTag = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", testTag);
                        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY") && testTag > 0 && orDefault >= 0) {
                            if (arguments != null) {
                                if (Intrinsics.areEqual(extraDataKey, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
                                    orDefault = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", testTag);
                                    testTag = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", testTag);
                                    if (testTag > 0) {
                                        if (orDefault >= 0) {
                                            if (iterableTextForAccessibility != null) {
                                                length = iterableTextForAccessibility.length();
                                            } else {
                                                length = Integer.MAX_VALUE;
                                            }
                                            if (orDefault >= length) {
                                            } else {
                                                getTextLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig$ui_release());
                                                if (getTextLayoutResult == null) {
                                                }
                                            }
                                            arrayList = new ArrayList();
                                            i = 0;
                                            while (i < testTag) {
                                                if (orDefault + i >= getTextLayoutResult.getLayoutInput().getText().length()) {
                                                } else {
                                                }
                                                (List)arrayList.add(toScreenCoords(semanticsNode, getTextLayoutResult.getBoundingBox(orDefault + i)));
                                                i++;
                                                arrayList.add(0);
                                            }
                                            screenCoords = 0;
                                            info.getExtras().putParcelableArray(extraDataKey, (Parcelable[])(Collection)arrayList.toArray(new RectF[0]));
                                        }
                                    }
                                    Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
                                }
                            }
                        }
                        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, "androidx.compose.ui.semantics.testTag")) {
                            if (arguments != null) {
                                if (Intrinsics.areEqual(extraDataKey, "androidx.compose.ui.semantics.testTag")) {
                                    orDefault = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
                                    if ((String)orDefault != null) {
                                        info.getExtras().putCharSequence(extraDataKey, (CharSequence)(String)orDefault);
                                    }
                                } else {
                                    if (Intrinsics.areEqual(extraDataKey, "androidx.compose.ui.semantics.id")) {
                                        info.getExtras().putInt(extraDataKey, semanticsNode.getId());
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                }
            }
        }
    }

    private final Rect boundsInScreen(androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds node) {
        final Rect adjustedBounds = node.getAdjustedBounds();
        float f2 = (float)top;
        long l = OffsetKt.Offset((float)left, f2);
        long localToScreen-MK-Hz9U = this.view.localToScreen-MK-Hz9U(l);
        float f4 = (float)bottom;
        long l2 = OffsetKt.Offset((float)right, f4);
        long localToScreen-MK-Hz9U2 = this.view.localToScreen-MK-Hz9U(l2);
        Rect rect = new Rect((int)f5, (int)f6, (int)f7, (int)f8);
        return rect;
    }

    private final boolean canScroll-moWRBKg(IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> currentSemanticsNodes, boolean vertical, int direction, long position) {
        int actualDirection;
        boolean valid-impl;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int contains-k-4lQ0M;
        androidx.compose.ui.semantics.SemanticsPropertyKey horizontalScrollAxisRange;
        int j$iv$iv;
        Object $i$f$isFull;
        int i$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv2;
        int foundNode;
        int cmp;
        int i2;
        int i4;
        long l;
        Object obj;
        int i3;
        Rect adjustedBounds;
        boolean reverseScrolling;
        int i;
        float floatValue;
        actualDirection = vertical;
        final int i5 = direction;
        final long l2 = position;
        if (!Offset.equals-impl0(l2, obj3)) {
            if (!Offset.isValid-impl(l2)) {
                i2 = 0;
                return i2;
            } else {
                if (actualDirection == 1) {
                    horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
                    j$iv$iv = 0;
                    $i$f$isFull = currentSemanticsNodes;
                    final int i13 = 0;
                    final int i14 = 0;
                    final long[] metadata = obj2.metadata;
                    length += -2;
                    if (0 <= i15) {
                    } else {
                        $this$maskEmptyOrDeleted$iv$iv$iv2 = $i$f$isFull;
                        foundNode = j$iv$iv;
                    }
                    return foundNode;
                } else {
                    if (actualDirection != 0) {
                    } else {
                        horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
                    }
                }
            }
            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            throw noWhenBranchMatchedException;
        }
        i2 = 0;
    }

    private final void checkForSemanticsChanges() {
        boolean unmergedRootSemanticsNode;
        androidx.compose.ui.platform.SemanticsNodeCopy previousSemanticsRoot;
        int i = 0;
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        int i4 = 0;
        if (isEnabled$ui_release()) {
            sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        }
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$checkForSemanticsChanges$1 = Unit.INSTANCE;
        Trace.endSection();
        int i2 = 0;
        Trace.beginSection("sendSemanticsPropertyChangeEvents");
        int i5 = 0;
        sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$checkForSemanticsChanges$2 = Unit.INSTANCE;
        Trace.endSection();
        int i3 = 0;
        Trace.beginSection("updateSemanticsNodesCopyAndPanes");
        int i6 = 0;
        updateSemanticsNodesCopyAndPanes();
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$checkForSemanticsChanges$3 = Unit.INSTANCE;
        Trace.endSection();
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (isAccessibilityFocused(virtualViewId)) {
            this.focusedVirtualViewId = Integer.MIN_VALUE;
            this.currentlyFocusedANI = 0;
            this.view.invalidate();
            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, virtualViewId, 65536, 0, 0, 12, 0);
            return 1;
        }
        int virtualViewId2 = virtualViewId;
        return 0;
    }

    private final AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        boolean enabled$ui_release;
        int i;
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$createEvent$2;
        Object password;
        int i3 = 0;
        Trace.beginSection("obtainAccessibilityEvent");
        int i5 = 0;
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(eventType);
        Trace.endSection();
        obtain.setEnabled(true);
        obtain.setClassName((CharSequence)"android.view.View");
        int i4 = 0;
        Trace.beginSection("event.packageName");
        int i6 = 0;
        obtain.setPackageName((CharSequence)this.view.getContext().getPackageName());
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$createEvent$1 = Unit.INSTANCE;
        Trace.endSection();
        i = 0;
        Trace.beginSection("event.setSource");
        int i7 = 0;
        obtain.setSource((View)this.view, virtualViewId);
        $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$createEvent$2 = Unit.INSTANCE;
        Trace.endSection();
        enabled$ui_release = getCurrentSemanticsNodes().get(virtualViewId);
        if (isEnabled$ui_release() && (SemanticsNodeWithAdjustedBounds)enabled$ui_release != null) {
            enabled$ui_release = getCurrentSemanticsNodes().get(virtualViewId);
            if ((SemanticsNodeWithAdjustedBounds)(SemanticsNodeWithAdjustedBounds)enabled$ui_release != null) {
                i = 0;
                obtain.setPassword((SemanticsNodeWithAdjustedBounds)(SemanticsNodeWithAdjustedBounds)enabled$ui_release.getSemanticsNode().getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getPassword()));
            }
        }
        return obtain;
    }

    private final AccessibilityNodeInfoCompat createNodeInfo(int virtualViewId) {
        Object viewTreeOwners;
        Lifecycle.State currentState;
        int parentId;
        Object parentForAccessibility;
        boolean z;
        int i = 0;
        Trace.beginSection("checkIfDestroyed");
        int i4 = 0;
        viewTreeOwners = this.view.getViewTreeOwners();
        parentId = 0;
        viewTreeOwners = viewTreeOwners.getLifecycleOwner();
        viewTreeOwners = viewTreeOwners.getLifecycle();
        if (viewTreeOwners != null && viewTreeOwners != null && viewTreeOwners != null) {
            viewTreeOwners = viewTreeOwners.getLifecycleOwner();
            if (viewTreeOwners != null) {
                viewTreeOwners = viewTreeOwners.getLifecycle();
                if (viewTreeOwners != null) {
                    currentState = viewTreeOwners.getCurrentState();
                } else {
                    currentState = parentId;
                }
            } else {
            }
        } else {
        }
        if (currentState == Lifecycle.State.DESTROYED) {
            Trace.endSection();
            return parentId;
        }
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$createNodeInfo$1 = Unit.INSTANCE;
        Trace.endSection();
        int i2 = 0;
        Trace.beginSection("createAccessibilityNodeInfoObject");
        int i5 = 0;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        Trace.endSection();
        int i3 = 0;
        Trace.beginSection("calculateNodeWithAdjustedBounds");
        int i6 = 0;
        Object obj = getCurrentSemanticsNodes().get(virtualViewId);
        Trace.endSection();
        if ((SemanticsNodeWithAdjustedBounds)obj == null) {
            try {
                return parentId;
                SemanticsNode semanticsNode = (SemanticsNodeWithAdjustedBounds)obj.getSemanticsNode();
                int i7 = 0;
                Trace.beginSection("setParentForAccessibility");
                int i12 = 0;
                if (virtualViewId == -1) {
                } else {
                }
                parentForAccessibility = this.view.getParentForAccessibility();
                if (parentForAccessibility instanceof View != null) {
                }
                parentId = parentForAccessibility;
                obtain.setParent(parentId);
                SemanticsNode parent = semanticsNode.getParent();
                if (parent != null) {
                }
                parentId = Integer.valueOf(parent.getId());
                int i14 = 0;
                if (parentId == 0) {
                } else {
                }
                if ((Number)parentId.intValue() == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                }
                parentId = -1;
                obtain.setParent((View)this.view, parentId);
                Unit iNSTANCE = Unit.INSTANCE;
                Trace.endSection();
                obtain.setSource((View)this.view, virtualViewId);
                int i8 = 0;
                Trace.beginSection("setBoundsInScreen");
                int i10 = 0;
                obtain.setBoundsInScreen(boundsInScreen(obj));
                Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$createNodeInfo$3 = Unit.INSTANCE;
                Trace.endSection();
                int i9 = 0;
                Trace.beginSection("populateAccessibilityNodeInfoProperties");
                int i11 = 0;
                populateAccessibilityNodeInfoProperties(virtualViewId, obtain, semanticsNode);
                Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$createNodeInfo$4 = Unit.INSTANCE;
                Trace.endSection();
                return obtain;
                Trace.endSection();
                throw value$iv;
                Trace.endSection();
                throw value$iv;
                int i15 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(stringBuilder.append("semanticsNode ").append(virtualViewId).append(" has null parent").toString());
                KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
                throw kotlinNothingValueException;
                Trace.endSection();
                throw value$iv;
                Trace.endSection();
                throw th;
                Trace.endSection();
                throw th;
                Trace.endSection();
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    private final String createStateDescriptionForTextField(SemanticsNode node) {
        Object orNull2;
        int i2;
        Object orNull;
        Object orNull3;
        int string;
        int i;
        int state_empty;
        SemanticsConfiguration config = node.copyWithMergingEnabled$ui_release().getConfig();
        orNull2 = SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getContentDescription());
        i = 0;
        state_empty = 1;
        if ((Collection)orNull2 != null) {
            if ((Collection)orNull2.isEmpty()) {
                i2 = state_empty;
            } else {
                i2 = i;
            }
        } else {
        }
        if (i2 != 0) {
            orNull3 = SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getText());
            if ((Collection)orNull3 != null) {
                if ((Collection)orNull3.isEmpty()) {
                    i2 = state_empty;
                } else {
                    i2 = i;
                }
            } else {
            }
            if (i2 != 0) {
                orNull = SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getEditableText());
                if ((CharSequence)orNull != null) {
                    if ((CharSequence)orNull.length() == 0) {
                        i2 = state_empty;
                    } else {
                        i2 = i;
                    }
                } else {
                }
                if (i2 != 0) {
                    i = state_empty;
                } else {
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
            string = this.view.getContext().getResources().getString(R.string.state_empty);
        } else {
            string = 0;
        }
        return string;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, java.lang.CharSequence text) {
        int intValue;
        int i;
        List text2;
        AccessibilityEvent event = createEvent(virtualViewId, 8192);
        final AccessibilityEvent accessibilityEvent = event;
        final int i3 = 0;
        if (fromIndex != null) {
            i = 0;
            accessibilityEvent.setFromIndex((Number)fromIndex.intValue());
        }
        if (toIndex != null) {
            i = 0;
            accessibilityEvent.setToIndex((Number)toIndex.intValue());
        }
        if (itemCount != null) {
            i = 0;
            accessibilityEvent.setItemCount((Number)itemCount.intValue());
        }
        if (text != null) {
            i = 0;
            accessibilityEvent.getText().add(text);
        }
        return event;
    }

    private static final void enabledStateListener$lambda$0(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat this$0, boolean enabled) {
        List enabledAccessibilityServiceList;
        int i;
        if (enabled) {
            enabledAccessibilityServiceList = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            enabledAccessibilityServiceList = CollectionsKt.emptyList();
        }
        this$0.enabledServices = enabledAccessibilityServiceList;
    }

    private final void geometryDepthFirstSearch(SemanticsNode currNode, ArrayList<SemanticsNode> geometryList, MutableIntObjectMap<List<SemanticsNode>> containerMapToChildren) {
        androidx.compose.ui.semantics.SemanticsPropertyKey screenReaderFocusable;
        List children;
        int iNSTANCE;
        int subtreeSortedByGeometryGrouping;
        int index$iv;
        int size;
        Object obj2;
        Object obj;
        int i;
        boolean booleanValue = (Boolean)currNode.getUnmergedConfig$ui_release().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), (Function0)AndroidComposeViewAccessibilityDelegateCompat.geometryDepthFirstSearch.isTraversalGroup.1.INSTANCE).booleanValue();
        if (!booleanValue) {
            if (isScreenReaderFocusable(currNode) && getCurrentSemanticsNodes().containsKey(currNode.getId())) {
                if (getCurrentSemanticsNodes().containsKey(currNode.getId())) {
                    geometryList.add(currNode);
                }
            }
        } else {
        }
        if (booleanValue) {
            containerMapToChildren.set(currNode.getId(), subtreeSortedByGeometryGrouping(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(currNode), CollectionsKt.toMutableList((Collection)currNode.getChildren())));
        } else {
            children = currNode.getChildren();
            subtreeSortedByGeometryGrouping = 0;
            index$iv = 0;
            while (index$iv < children.size()) {
                i = 0;
                geometryDepthFirstSearch((SemanticsNode)children.get(index$iv), geometryList, containerMapToChildren);
                index$iv++;
            }
        }
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        boolean contains;
        androidx.compose.ui.semantics.SemanticsPropertyKey contentDescription;
        if (!node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                androidx.compose.ui.semantics.SemanticsPropertyKey textSelectionRange = SemanticsProperties.INSTANCE.getTextSelectionRange();
                return TextRange.getEnd-impl((TextRange)node.getUnmergedConfig$ui_release().get(textSelectionRange).unbox-impl());
            }
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        boolean contains;
        androidx.compose.ui.semantics.SemanticsPropertyKey contentDescription;
        if (!node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                androidx.compose.ui.semantics.SemanticsPropertyKey textSelectionRange = SemanticsProperties.INSTANCE.getTextSelectionRange();
                return TextRange.getStart-impl((TextRange)node.getUnmergedConfig$ui_release().get(textSelectionRange).unbox-impl());
            }
        }
        return this.accessibilityCursorPosition;
    }

    private final IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        boolean currentSemanticsNodesInvalidated;
        int i;
        Throwable $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$currentSemanticsNodes$2;
        IntObjectMap allUncoveredSemanticsNodesToIntObjectMap;
        this.currentSemanticsNodesInvalidated = false;
        i = 0;
        Trace.beginSection("generateCurrentSemanticsNodes");
        $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$currentSemanticsNodes$2 = 0;
        Trace.endSection();
        this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
        if (this.currentSemanticsNodesInvalidated && isEnabled$ui_release()) {
            this.currentSemanticsNodesInvalidated = false;
            i = 0;
            Trace.beginSection("generateCurrentSemanticsNodes");
            $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$currentSemanticsNodes$2 = 0;
            Trace.endSection();
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            if (isEnabled$ui_release()) {
                i = 0;
                Trace.beginSection("setTraversalValues");
                int i3 = 0;
                setTraversalValues();
                $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$currentSemanticsNodes$2 = Unit.INSTANCE;
                Trace.endSection();
            }
        }
        return this.currentSemanticsNodes;
    }

    public static void getHoveredVirtualViewId$ui_release$annotations() {
    }

    private final boolean getInfoIsCheckable(SemanticsNode node) {
        int isCheckable;
        Object role;
        Object booleanValue;
        int i;
        androidx.compose.ui.semantics.SemanticsPropertyKey selected;
        boolean equals-impl0;
        int unbox-impl;
        isCheckable = 0;
        Object orNull = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Object orNull2 = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if ((ToggleableState)orNull != null) {
            role = orNull;
            i = 0;
            isCheckable = 1;
        }
        booleanValue = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if ((Boolean)booleanValue != null) {
            booleanValue = (Boolean)booleanValue.booleanValue();
            selected = 0;
            if ((Role)orNull2 == null) {
                equals-impl0 = 0;
            } else {
                equals-impl0 = Role.equals-impl0((Role)orNull2.unbox-impl(), Role.Companion.getTab-o7Vup1c());
            }
            if (!equals-impl0) {
                isCheckable = 1;
            }
        }
        return isCheckable;
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode node) {
        Object stateDescription;
        int coerceIn;
        Object obj;
        Object booleanValue;
        int i;
        androidx.compose.ui.semantics.SemanticsPropertyKey selected;
        Object progressBarRangeInfo;
        int resources;
        int indeterminate;
        String string;
        int i6;
        int i2;
        int $i$f$fastRoundToInt;
        int template_percent;
        Object[] arr;
        int i5;
        float floatValue;
        int i3;
        int $this$fastCoerceAtMost$iv$iv;
        int i4;
        int cmp;
        final Object obj2 = this;
        int i8 = 0;
        stateDescription = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getStateDescription());
        Object orNull = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Object orNull2 = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        coerceIn = 0;
        if ((ToggleableState)orNull != null) {
            i = 0;
            switch (resources) {
                case 1:
                    resources = coerceIn;
                    resources = Role.equals-impl0((Role)orNull2.unbox-impl(), Role.Companion.getSwitch-o7Vup1c());
                    stateDescription = obj2.view.getContext().getResources().getString(R.string.state_on);
                    break;
                case 2:
                    resources = coerceIn;
                    resources = Role.equals-impl0(orNull2.unbox-impl(), Role.Companion.getSwitch-o7Vup1c());
                    stateDescription = obj2.view.getContext().getResources().getString(R.string.state_off);
                    break;
                case 3:
                    stateDescription = resources;
                    break;
                default:
            }
        }
        booleanValue = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if ((Boolean)booleanValue != null) {
            selected = 0;
            if (orNull2 == null) {
                resources = coerceIn;
            } else {
                resources = Role.equals-impl0(orNull2.unbox-impl(), Role.Companion.getTab-o7Vup1c());
            }
            if (!resources && stateDescription == null) {
                if (stateDescription == null) {
                    if ((Boolean)booleanValue.booleanValue()) {
                        resources = obj2.view.getContext().getResources().getString(R.string.selected);
                    } else {
                        resources = obj2.view.getContext().getResources().getString(R.string.not_selected);
                    }
                    stateDescription = resources;
                }
            }
        }
        Object orNull3 = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if ((ProgressBarRangeInfo)orNull3 != null) {
            progressBarRangeInfo = orNull3;
            resources = 0;
            if ((ProgressBarRangeInfo)orNull3 != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                if (stateDescription == null) {
                    indeterminate = (ProgressBarRangeInfo)orNull3.getRange();
                    int i14 = 0;
                    int i15 = 1;
                    i6 = Float.compare(i10, i14) == 0 ? i15 : coerceIn;
                    if (i6 != 0) {
                        i2 = i14;
                    } else {
                        i11 /= i5;
                    }
                    i5 = 0;
                    floatValue = 1065353216;
                    i3 = 0;
                    int i16 = 0;
                    if (Float.compare($this$fastCoerceAtMost$iv$iv, i5) < 0) {
                        $this$fastCoerceAtMost$iv$iv = i5;
                    }
                    i4 = 0;
                    if (Float.compare($this$fastCoerceAtMost$iv$iv, floatValue) > 0) {
                        $this$fastCoerceAtMost$iv$iv = floatValue;
                    }
                    $i$f$fastRoundToInt = Float.compare($this$fastCoerceAtMost$iv$iv, i14) == 0 ? i15 : coerceIn;
                    if ($i$f$fastRoundToInt != 0) {
                    } else {
                        if (Float.compare($this$fastCoerceAtMost$iv$iv, i12) == 0) {
                            coerceIn = i15;
                        }
                        $i$f$fastRoundToInt = 100;
                        if (coerceIn != 0) {
                            coerceIn = $i$f$fastRoundToInt;
                        } else {
                            int i13 = 0;
                            coerceIn = RangesKt.coerceIn(Math.round(f *= $this$fastCoerceAtMost$iv$iv), i15, 99);
                        }
                    }
                    stateDescription = string;
                }
            } else {
                if (stateDescription == null) {
                    stateDescription = obj2.view.getContext().getResources().getString(R.string.in_progress);
                }
            }
        }
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            stateDescription = createStateDescriptionForTextField(node);
        }
        return (String)stateDescription;
    }

    private final AnnotatedString getInfoText(SemanticsNode node) {
        Object firstOrNull;
        Object str;
        AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig$ui_release());
        Object orNull = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if ((List)orNull != null) {
            firstOrNull = CollectionsKt.firstOrNull((List)orNull);
        } else {
            firstOrNull = 0;
        }
        str = textForTextField == null ? firstOrNull : textForTextField;
        return str;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        int text;
        Object firstOrNull;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List)node.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getContentDescription()), (CharSequence)",", 0, 0, 0, 0, 0, 62, 0);
        }
        AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig$ui_release());
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText()) && textForTextField != null) {
            textForTextField = getTextForTextField(node.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                text = textForTextField.getText();
            }
            return text;
        }
        firstOrNull = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        firstOrNull = CollectionsKt.firstOrNull((List)firstOrNull);
        if (firstOrNull != null && (AnnotatedString)firstOrNull != null) {
            firstOrNull = CollectionsKt.firstOrNull(firstOrNull);
            if ((AnnotatedString)(AnnotatedString)firstOrNull != null) {
                text = (AnnotatedString)(AnnotatedString)firstOrNull.getText();
            }
        }
        return text;
    }

    private final androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator instance;
        String length;
        int i;
        int iterator;
        Object textLayoutResult;
        androidx.compose.ui.semantics.SemanticsPropertyKey getTextLayoutResult;
        int i2 = 0;
        if (node == null) {
            return i2;
        }
        final String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        length = iterableTextForAccessibility;
        if ((CharSequence)length != null) {
            if ((CharSequence)length.length() == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0) {
            return i2;
        }
        iterator = 0;
        switch (granularity) {
            case 1:
                (AccessibilityIterators.AbstractTextSegmentIterator)AccessibilityIterators.CharacterTextSegmentIterator.Companion.getInstance(configuration.locale).initialize(iterableTextForAccessibility);
                break;
            case 2:
                (AccessibilityIterators.AbstractTextSegmentIterator)AccessibilityIterators.WordTextSegmentIterator.Companion.getInstance(configuration2.locale).initialize(iterableTextForAccessibility);
                break;
            case 4:
                return i2;
                textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(node.getUnmergedConfig$ui_release());
                return i2;
                (AccessibilityIterators.LineTextSegmentIterator)(AccessibilityIterators.AbstractTextSegmentIterator)AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance().initialize(iterableTextForAccessibility, textLayoutResult);
                (AccessibilityIterators.PageTextSegmentIterator)(AccessibilityIterators.AbstractTextSegmentIterator)AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance().initialize(iterableTextForAccessibility, textLayoutResult, node);
                break;
            case 8:
                (AccessibilityIterators.AbstractTextSegmentIterator)AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance().initialize(iterableTextForAccessibility);
                break;
            default:
                return i2;
        }
        return (AccessibilityIterators.TextSegmentIterator)instance;
    }

    public static void getOnSendAccessibilityEvent$ui_release$annotations() {
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration $this$getTextForTextField) {
        return (AnnotatedString)SemanticsConfigurationKt.getOrNull($this$getTextForTextField, SemanticsProperties.INSTANCE.getEditableText());
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        int i;
        i = this.focusedVirtualViewId == virtualViewId ? 1 : 0;
        return i;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        boolean contains;
        int i;
        androidx.compose.ui.semantics.SemanticsPropertyKey contentDescription;
        if (!node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            i = node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean isScreenReaderFocusable(SemanticsNode node) {
        Object firstOrNull;
        int i2;
        AnnotatedString infoStateDescriptionOrNull;
        int i;
        boolean mergingSemanticsOfDescendants;
        Object orNull = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
        if ((List)orNull != null) {
            firstOrNull = CollectionsKt.firstOrNull((List)orNull);
        } else {
            firstOrNull = 0;
        }
        final int i3 = 1;
        if (firstOrNull == null && getInfoText(node) == null && getInfoStateDescriptionOrNull(node) == null) {
            if (getInfoText(node) == null) {
                if (getInfoStateDescriptionOrNull(node) == null) {
                    if (getInfoIsCheckable(node)) {
                        i = i3;
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (!node.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
            if (node.isUnmergedLeafNode$ui_release() && i != 0) {
                if (i != 0) {
                    i2 = i3;
                }
            }
        } else {
        }
        return i2;
    }

    private final boolean isTouchExplorationEnabled() {
        boolean accessibilityForceEnabledForTesting;
        int i;
        if (!this.accessibilityForceEnabledForTesting) {
            if (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled()) {
                if (this.accessibilityManager.isTouchExplorationEnabled()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        boolean boundsUpdateChannel;
        Unit iNSTANCE;
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.trySend-JP2dKIU(Unit.INSTANCE);
        }
    }

    private final boolean performActionHelper(int virtualViewId, int action, Bundle arguments) {
        Object orNull9;
        Object action2;
        Object orNull15;
        Object orNull11;
        Object orNull2;
        Object orNull6;
        Object orNull;
        int booleanValue3;
        Object orNull5;
        int i15;
        int scrollForward2;
        int booleanValue15;
        Object booleanValue11;
        boolean contains2;
        kotlin.Function booleanValue8;
        Object orNull8;
        int i6;
        Object orNull3;
        int semanticsNodeIdToAccessibilityVirtualNodeId;
        int invoke;
        Object setText;
        float dy2;
        int pageRight2;
        androidx.compose.ui.semantics.SemanticsPropertyKey amountToScroll;
        int valueOf;
        Object orNull4;
        int i21;
        int str;
        int string;
        Object orNull12;
        int booleanValue;
        Object pageUp;
        Object pageDown;
        Object pageLeft;
        Object orNull10;
        Object pageRight;
        boolean focusOwner;
        int i10;
        Object obj;
        int aRTIFICIAL_FRAME_PACKAGE_NAME2;
        SemanticsNode scrollableAncestor;
        Boolean exit-dhqQ-8s;
        int i20;
        int unmergedConfig$ui_release;
        int scrollAction;
        int i16;
        int unmergedConfig$ui_release2;
        long positionInRoot;
        int i8;
        int aRTIFICIAL_FRAME_PACKAGE_NAME;
        int i4;
        int index$iv;
        int booleanValue5;
        boolean booleanValue9;
        int booleanValue12;
        int booleanValue13;
        int booleanValue4;
        int booleanValue10;
        int booleanValue7;
        int booleanValue14;
        int i5;
        int i9;
        int booleanValue2;
        int orNull14;
        int orNull13;
        int setProgress;
        int i12;
        float dx;
        androidx.compose.ui.semantics.SemanticsPropertyKey horizontalScrollAxisRange;
        boolean contains;
        Object orNull7;
        SemanticsConfiguration unmergedConfig$ui_release3;
        int amountToScroll2;
        int i19;
        int reverseScrolling;
        int reverseScrolling2;
        int increment;
        androidx.compose.ui.semantics.SemanticsPropertyKey booleanValue6;
        float dy;
        long steps;
        int i11;
        Object yScrollState;
        Object yScrollState2;
        int i17;
        int i;
        int i14;
        int i2;
        int scrollForward;
        int scrollForward3;
        int i3;
        int i22;
        int i13;
        int canPageHorizontally;
        int scrollBackward;
        int i7;
        long fallbackViewport;
        action2 = this;
        int i41 = virtualViewId;
        final int i42 = action;
        final Object obj4 = arguments;
        Object obj2 = action2.getCurrentSemanticsNodes().get(i41);
        booleanValue5 = 0;
        if ((SemanticsNodeWithAdjustedBounds)obj2 != null) {
            SemanticsNode semanticsNode = (SemanticsNodeWithAdjustedBounds)obj2.getSemanticsNode();
            if (semanticsNode == null) {
                i21 = i41;
                i2 = booleanValue5;
                return i2;
            } else {
                orNull14 = semanticsNode;
                invoke = 1;
                switch (i42) {
                    case 64:
                        return requestAccessibilityFocus(virtualViewId);
                    case 128:
                        return clearAccessibilityFocus(virtualViewId);
                    case 256:
                        booleanValue5 = invoke;
                        return action2.traverseAtGranularity(orNull14, obj4.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"), booleanValue5, obj4.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"));
                        return booleanValue5;
                    case 512:
                        orNull3 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCopyText());
                        orNull3 = (AccessibilityAction)orNull3.getAction();
                        booleanValue5 = (Boolean)(Function0)orNull3.invoke().booleanValue();
                        return booleanValue5;
                    case 16384:
                        semanticsNodeIdToAccessibilityVirtualNodeId = -1;
                        str = obj4.getInt("ACTION_ARGUMENT_SELECTION_START_INT", semanticsNodeIdToAccessibilityVirtualNodeId);
                        str = semanticsNodeIdToAccessibilityVirtualNodeId;
                        semanticsNodeIdToAccessibilityVirtualNodeId = obj4.getInt("ACTION_ARGUMENT_SELECTION_END_INT", semanticsNodeIdToAccessibilityVirtualNodeId);
                        boolean accessibilitySelection = action2.setAccessibilitySelection(orNull14, str, semanticsNodeIdToAccessibilityVirtualNodeId, booleanValue5);
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(action2, action2.semanticsNodeIdToAccessibilityVirtualNodeId(orNull14.getId()), 0, 0, 0, 12, 0);
                        return accessibilitySelection;
                    default:
                        return booleanValue5;
                }
                string = 0;
                switch (i42) {
                    case 1:
                        int i25 = i41;
                        orNull10 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getRequestFocus());
                        orNull10 = (AccessibilityAction)orNull10.getAction();
                        booleanValue7 = (Boolean)(Function0)orNull10.invoke().booleanValue();
                        booleanValue7 = 0;
                        return booleanValue7;
                    case 2:
                        int i27 = i41;
                        unmergedConfig$ui_release = 1;
                        action2.view.getFocusOwner().clearFocus-I7lrPNg(booleanValue5, unmergedConfig$ui_release, unmergedConfig$ui_release, FocusDirection.Companion.getExit-dhqQ-8s());
                        i5 = unmergedConfig$ui_release;
                        i5 = 0;
                        return i5;
                    case 16:
                        i17 = booleanValue5;
                        orNull9 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnClick());
                        orNull9 = (AccessibilityAction)orNull9.getAction();
                        string = orNull9;
                        int i43 = string;
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, i41, 1, 0, 0, 12, 0);
                        i17 = booleanValue;
                        return i17;
                    case 32:
                        orNull2 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnLongClick());
                        orNull2 = (AccessibilityAction)orNull2.getAction();
                        booleanValue13 = (Boolean)(Function0)orNull2.invoke().booleanValue();
                        booleanValue13 = i52;
                        return booleanValue13;
                    case 4096:
                        i = booleanValue5;
                        SemanticsNode semanticsNode12 = orNull14;
                        i15 = 1;
                        i15 = i;
                        pageRight2 = 1;
                        pageRight2 = i;
                        i10 = 1;
                        i10 = i;
                        i20 = 1;
                        i20 = i;
                        i16 = 1;
                        i16 = i;
                        i8 = 1;
                        i8 = i;
                        i4 = i;
                        i4 = 1;
                        i9 = i;
                        i9 = 1;
                        scrollForward3 = i15;
                        i7 = pageRight2;
                        orNull14 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                        orNull13 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress());
                        float coerceAtLeast = RangesKt.coerceAtLeast((Number)(ProgressBarRangeInfo)orNull14.getRange().getEndInclusive().floatValue(), (Number)orNull14.getRange().getStart().floatValue());
                        float coerceAtMost = RangesKt.coerceAtMost((Number)orNull14.getRange().getStart().floatValue(), (Number)orNull14.getRange().getEndInclusive().floatValue());
                        scrollForward = i15;
                        i22 = 1;
                        i48 /= scrollForward2;
                        scrollForward = i15;
                        increment = scrollForward2 / f;
                        increment = -increment;
                        kotlin.Function action3 = (AccessibilityAction)orNull13.getAction();
                        scrollBackward = pageRight2;
                        booleanValue15 = (Boolean)(Function1)action3.invoke(Float.valueOf(current += increment)).booleanValue();
                        scrollBackward = pageRight2;
                        booleanValue15 = i;
                        return booleanValue15;
                        scrollForward3 = i15;
                        i7 = pageRight2;
                        long size-NH-jbRc = LayoutCoordinatesKt.boundsInParent(semanticsNode12.getLayoutInfo().getCoordinates()).getSize-NH-jbRc();
                        Float scrollViewportLength = SemanticsUtils_androidKt.getScrollViewportLength(semanticsNode12.getUnmergedConfig$ui_release());
                        Object orNull23 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollBy());
                        return i;
                        Object orNull25 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                        amountToScroll2 = scrollViewportLength.floatValue();
                        amountToScroll2 = Size.getWidth-impl(size-NH-jbRc);
                        amountToScroll2 = -amountToScroll2;
                        amountToScroll2 = -amountToScroll2;
                        amountToScroll2 = -amountToScroll2;
                        int i49 = 0;
                        long l = size-NH-jbRc;
                        valueOf = i;
                        valueOf = 1;
                        booleanValue8 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageRight());
                        booleanValue8 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageLeft());
                        unmergedConfig$ui_release3 = booleanValue8.getAction();
                        canPageHorizontally = valueOf;
                        i = unmergedConfig$ui_release3;
                        canPageHorizontally = valueOf;
                        booleanValue8 = (AccessibilityAction)orNull23.getAction();
                        canPageHorizontally = valueOf;
                        i = booleanValue8;
                        canPageHorizontally = valueOf;
                        return i;
                        fallbackViewport = size-NH-jbRc;
                        i11 = 0;
                        fallbackViewport = size-NH-jbRc;
                        i11 = 0;
                        booleanValue11 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                        amountToScroll = scrollViewportLength.floatValue();
                        amountToScroll = Size.getHeight-impl(fallbackViewport);
                        amountToScroll = -amountToScroll;
                        amountToScroll = -amountToScroll;
                        i13 = i;
                        i13 = 1;
                        orNull7 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageDown());
                        orNull7 = SemanticsConfigurationKt.getOrNull(semanticsNode12.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
                        booleanValue6 = orNull7.getAction();
                        yScrollState2 = booleanValue11;
                        i = booleanValue6;
                        yScrollState2 = booleanValue11;
                        orNull7 = orNull23.getAction();
                        yScrollState2 = booleanValue11;
                        i = booleanValue11;
                        yScrollState2 = booleanValue11;
                        return i;
                        yScrollState = booleanValue11;
                        yScrollState = booleanValue11;
                        return i;
                    case 8192:
                        orNull8 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPasteText());
                        orNull8 = (AccessibilityAction)orNull8.getAction();
                        booleanValue2 = (Boolean)(Function0)orNull8.invoke().booleanValue();
                        booleanValue2 = i60;
                        return booleanValue2;
                    case 32768:
                        orNull11 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCutText());
                        orNull11 = (AccessibilityAction)orNull11.getAction();
                        booleanValue12 = (Boolean)(Function0)orNull11.invoke().booleanValue();
                        booleanValue12 = i51;
                        return booleanValue12;
                    case 65536:
                        orNull6 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getExpand());
                        orNull6 = (AccessibilityAction)orNull6.getAction();
                        booleanValue4 = (Boolean)(Function0)orNull6.invoke().booleanValue();
                        booleanValue4 = i53;
                        return booleanValue4;
                    case 262144:
                        orNull = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCollapse());
                        orNull = (AccessibilityAction)orNull.getAction();
                        booleanValue10 = (Boolean)(Function0)orNull.invoke().booleanValue();
                        booleanValue10 = i54;
                        return booleanValue10;
                    case 524288:
                        orNull5 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getDismiss());
                        orNull5 = (AccessibilityAction)orNull5.getAction();
                        booleanValue14 = (Boolean)(Function0)orNull5.invoke().booleanValue();
                        booleanValue14 = i56;
                        return booleanValue14;
                    case 1048576:
                        string = obj4.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
                        orNull15 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
                        orNull15 = (AccessibilityAction)orNull15.getAction();
                        orNull14 = setText;
                        orNull14 = string;
                        AnnotatedString annotatedString = new AnnotatedString(orNull14, 0, 0, 6, 0);
                        booleanValue9 = (Boolean)(Function1)orNull15.invoke(annotatedString).booleanValue();
                        booleanValue9 = i50;
                        return booleanValue9;
                    case 2097152:
                        scrollableAncestor = orNull14.getParent();
                        unmergedConfig$ui_release = scrollableAncestor.getUnmergedConfig$ui_release();
                        scrollAction = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getScrollBy());
                        scrollAction = string;
                        scrollableAncestor = scrollableAncestor.getParent();
                        unmergedConfig$ui_release2 = scrollableAncestor.getUnmergedConfig$ui_release();
                        unmergedConfig$ui_release2 = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release2, SemanticsActions.INSTANCE.getScrollBy());
                        unmergedConfig$ui_release2 = string;
                        scrollAction = unmergedConfig$ui_release2;
                        return booleanValue5;
                        LayoutCoordinates parentLayoutCoordinates = scrollableAncestor.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
                        positionInRoot = LayoutCoordinatesKt.positionInRoot(parentLayoutCoordinates);
                        positionInRoot = Offset.Companion.getZero-F1C5BW0();
                        Rect translate-k-4lQ0M = LayoutCoordinatesKt.boundsInParent(scrollableAncestor.getLayoutInfo().getCoordinates()).translate-k-4lQ0M(positionInRoot);
                        int i55 = booleanValue5;
                        Rect rect = RectKt.Rect-tz77jQw(orNull14.getPositionInRoot-F1C5BW0(), obj14);
                        Object orNull22 = SemanticsConfigurationKt.getOrNull(scrollableAncestor.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                        Object orNull24 = SemanticsConfigurationKt.getOrNull(scrollableAncestor.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                        i19 = invoke;
                        i19 = i55;
                        dx = -dx;
                        dx = -dx;
                        i3 = 1;
                        i3 = i55;
                        dy2 = -dy2;
                        action2 = scrollAction.getAction();
                        booleanValue3 = (Boolean)(Function2)action2.invoke(Float.valueOf(dx), Float.valueOf(dy2)).booleanValue();
                        dy = dy2;
                        booleanValue3 = i55;
                        return booleanValue3;
                    case 16908342:
                        invoke = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
                        orNull12 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress());
                        orNull12 = (AccessibilityAction)orNull12.getAction();
                        booleanValue5 = (Boolean)(Function1)orNull12.invoke(Float.valueOf(obj4.getFloat(invoke))).booleanValue();
                        return booleanValue5;
                        return booleanValue5;
                    case 16908344:
                        Object orNull16 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
                        pageUp = (AccessibilityAction)orNull16.getAction();
                        booleanValue5 = (Boolean)(Function0)pageUp.invoke().booleanValue();
                        return booleanValue5;
                    case 16908345:
                        Object orNull17 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageDown());
                        pageDown = (AccessibilityAction)orNull17.getAction();
                        booleanValue5 = (Boolean)(Function0)pageDown.invoke().booleanValue();
                        return booleanValue5;
                    case 16908346:
                        Object orNull18 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageLeft());
                        pageLeft = (AccessibilityAction)orNull18.getAction();
                        booleanValue5 = (Boolean)(Function0)pageLeft.invoke().booleanValue();
                        return booleanValue5;
                    case 16908347:
                        Object orNull19 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageRight());
                        pageRight = (AccessibilityAction)orNull19.getAction();
                        booleanValue5 = (Boolean)(Function0)pageRight.invoke().booleanValue();
                        return booleanValue5;
                    case 16908349:
                        orNull4 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnImeAction());
                        orNull4 = (AccessibilityAction)orNull4.getAction();
                        booleanValue5 = (Boolean)(Function0)orNull4.invoke().booleanValue();
                        return booleanValue5;
                    default:
                        obj = action2.actionIdToLabel.get(i41);
                        obj = (SparseArrayCompat)obj.get(i42);
                        i14 = 0;
                        Object orNull21 = SemanticsConfigurationKt.getOrNull(orNull14.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCustomActions());
                        return 0;
                        Object obj3 = orNull21;
                        int i39 = 0;
                        index$iv = 0;
                        orNull14 = booleanValue5;
                        orNull13 = 0;
                        return (Boolean)orNull14.getAction().invoke().booleanValue();
                        index$iv++;
                        return 0;
                        i14 = 0;
                        return i14;
                }
            }
        }
        i21 = i41;
        i2 = booleanValue5;
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange $this$performActionHelper_u24canScroll, float amount) {
        int i;
        int cmp;
        int floatValue;
        cmp = 0;
        if (Float.compare(amount, cmp) < 0) {
            if (Float.compare(floatValue3, cmp) <= 0) {
                if (Float.compare(amount, cmp) > 0 && Float.compare(floatValue2, floatValue) < 0) {
                    i = Float.compare(floatValue2, floatValue) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final float performActionHelper$scrollDelta(float a, float b) {
        int i;
        int i2;
        float signum;
        i = Float.compare(signum2, signum) == 0 ? 1 : 0;
        if (i != 0) {
            i2 = Float.compare(f, signum) < 0 ? a : b;
        } else {
            i2 = 0;
        }
        return i2;
    }

    private final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        boolean contains4;
        boolean contains2;
        Object labelToActionId;
        Object iNSTANCE5;
        Object iNSTANCE9;
        int content$iv;
        MutableIntList obj5;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat aCTION_ACCESSIBILITY_FOCUS;
        Object toggleState2;
        int semanticsIdToView2;
        int extraDataTestTraversalBeforeVal;
        int semanticsIdToView;
        androidx.compose.ui.semantics.SemanticsPropertyKey collapse;
        androidx.compose.ui.semantics.SemanticsPropertyKey dismiss;
        Object iNSTANCE2;
        int index$iv3;
        int extraDataTestTraversalAfterVal;
        int i4;
        Object toggleableState;
        Object iNSTANCE4;
        boolean mergingSemanticsOfDescendants;
        Object orNull3;
        int $i$a$ApplyAndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$availableIds$1;
        Object obj3;
        String legacyClassName-V4PA4sw;
        Object iNSTANCE10;
        Object iNSTANCE;
        boolean iNSTANCE8;
        String iterableTextForAccessibility;
        int size;
        boolean contains3;
        Object iNSTANCE3;
        Object iNSTANCE7;
        Object iNSTANCE11;
        boolean equals-impl0;
        int i2;
        String unmergedLeafNode$ui_release;
        androidx.compose.ui.semantics.SemanticsPropertyKey selected;
        androidx.compose.ui.semantics.SemanticsPropertyKey onLongClick;
        androidx.compose.ui.semantics.SemanticsPropertyKey pasteText;
        int orNull;
        Object index$iv2;
        String length2;
        androidx.compose.ui.semantics.SemanticsPropertyKey setText;
        androidx.compose.ui.semantics.SemanticsPropertyKey onImeAction;
        androidx.compose.ui.semantics.SemanticsPropertyKey cutText;
        int contentDescription;
        androidx.compose.ui.semantics.SemanticsPropertyKey testTagsAsResourceId;
        Object iNSTANCE12;
        int intValue;
        boolean focusable;
        Object iNSTANCE6;
        boolean accessibilityActionCompat;
        int contains5;
        boolean contains;
        String str;
        Object indeterminate;
        int aCTION_SCROLL_FORWARD;
        androidx.compose.ui.semantics.SemanticsPropertyKey progressBarRangeInfo;
        Object xScrollState;
        java.lang.CharSequence length;
        int current;
        androidx.compose.ui.semantics.SemanticsPropertyKey heading;
        int i5;
        int getTextLayoutResult;
        androidx.compose.ui.semantics.SemanticsPropertyKey setProgress;
        androidx.compose.ui.semantics.SemanticsPropertyKey coerceAtMost;
        Object booleanValue;
        androidx.compose.ui.semantics.SemanticsPropertyKey liveRegion;
        int label3;
        Object empty;
        boolean populateAccessibilityNodeInfoProperties$canScrollForward2;
        int populateAccessibilityNodeInfoProperties$canScrollBackward2;
        boolean orNull2;
        int populateAccessibilityNodeInfoProperties$canScrollBackward;
        boolean collectionInfo;
        boolean populateAccessibilityNodeInfoProperties$canScrollForward;
        boolean accessibilityActionCompat2;
        boolean collectionInfo2;
        androidx.compose.ui.semantics.SemanticsPropertyKey verticalScrollAxisRange;
        androidx.compose.ui.semantics.SemanticsPropertyKey index$iv;
        int tab-o7Vup1c;
        int i;
        String label2;
        Object obj2;
        Object role;
        String str2;
        Object customActions;
        Object toggleState;
        int $this$fastForEachIndexed$iv;
        ArrayList list;
        int index;
        Object $this$fastForEach$iv;
        int[] iArr;
        ArrayList list2;
        int i6;
        MutableIntList availableIds;
        Object obj4;
        Object rangeInfo;
        String label;
        Object obj;
        Object obj6;
        int i3;
        final Object obj7 = this;
        final int i7 = virtualViewId;
        final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = info;
        final SemanticsNode semanticsNode2 = semanticsNode;
        accessibilityNodeInfoCompat.setClassName((CharSequence)"android.view.View");
        String str4 = "android.widget.EditText";
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            accessibilityNodeInfoCompat.setClassName((CharSequence)str4);
        }
        String str5 = "android.widget.TextView";
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat.setClassName((CharSequence)str5);
        }
        labelToActionId = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if ((Role)labelToActionId != null) {
            int unbox-impl = (Role)labelToActionId.unbox-impl();
            i4 = 0;
            if (!semanticsNode2.isFake$ui_release()) {
                if (semanticsNode2.getReplacedChildren$ui_release().isEmpty()) {
                    if (Role.equals-impl0(labelToActionId.unbox-impl(), Role.Companion.getTab-o7Vup1c())) {
                        accessibilityNodeInfoCompat.setRoleDescription((CharSequence)obj7.view.getContext().getResources().getString(R.string.tab));
                    } else {
                        if (Role.equals-impl0(labelToActionId.unbox-impl(), Role.Companion.getSwitch-o7Vup1c())) {
                            accessibilityNodeInfoCompat.setRoleDescription((CharSequence)obj7.view.getContext().getResources().getString(R.string.switch_role));
                        } else {
                            if (Role.equals-impl0(labelToActionId.unbox-impl(), Role.Companion.getImage-o7Vup1c()) && !semanticsNode2.isUnmergedLeafNode$ui_release()) {
                                if (!semanticsNode2.isUnmergedLeafNode$ui_release()) {
                                    if (semanticsNode2.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                                        accessibilityNodeInfoCompat.setClassName((CharSequence)SemanticsUtils_androidKt.toLegacyClassName-V4PA4sw(labelToActionId.unbox-impl()));
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    }
                }
            } else {
            }
            Unit it3 = Unit.INSTANCE;
            iNSTANCE2 = Unit.INSTANCE;
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText())) {
            accessibilityNodeInfoCompat.setClassName((CharSequence)str4);
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat.setClassName((CharSequence)str5);
        }
        accessibilityNodeInfoCompat.setPackageName((CharSequence)obj7.view.getContext().getPackageName());
        accessibilityNodeInfoCompat.setImportantForAccessibility(SemanticsUtils_androidKt.isImportantForAccessibility(semanticsNode2));
        List replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
        int i10 = 0;
        index$iv3 = 0;
        legacyClassName-V4PA4sw = -1;
        while (index$iv3 < replacedChildren$ui_release.size()) {
            contentDescription = unmergedLeafNode$ui_release;
            current = 0;
            if (obj7.getCurrentSemanticsNodes().contains((SemanticsNode)contentDescription.getId())) {
            } else {
            }
            index$iv3++;
            legacyClassName-V4PA4sw = -1;
            booleanValue = obj7.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(contentDescription.getLayoutNode$ui_release());
            if (contentDescription.getId() == legacyClassName-V4PA4sw) {
            } else {
            }
            if ((AndroidViewHolder)booleanValue != null) {
            } else {
            }
            accessibilityNodeInfoCompat.addChild((View)obj7.view, contentDescription.getId());
            accessibilityNodeInfoCompat.addChild((View)(AndroidViewHolder)booleanValue);
        }
        extraDataTestTraversalBeforeVal = 0;
        extraDataTestTraversalAfterVal = 1;
        if (i7 == obj7.focusedVirtualViewId) {
            accessibilityNodeInfoCompat.setAccessibilityFocused(extraDataTestTraversalAfterVal);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat.setAccessibilityFocused(extraDataTestTraversalBeforeVal);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        obj7.setText(semanticsNode2, accessibilityNodeInfoCompat);
        obj7.setContentInvalid(semanticsNode2, accessibilityNodeInfoCompat);
        obj7.setStateDescription(semanticsNode2, accessibilityNodeInfoCompat);
        obj7.setIsCheckable(semanticsNode2, accessibilityNodeInfoCompat);
        toggleState2 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        if ((ToggleableState)toggleState2 != null) {
            Object obj8 = toggleState2;
            unmergedLeafNode$ui_release = 0;
            if ((ToggleableState)toggleState2 == ToggleableState.On) {
                accessibilityNodeInfoCompat.setChecked(extraDataTestTraversalAfterVal);
            } else {
                if ((ToggleableState)toggleState2 == ToggleableState.Off) {
                    accessibilityNodeInfoCompat.setChecked(extraDataTestTraversalBeforeVal);
                }
            }
            Unit it5 = Unit.INSTANCE;
            toggleableState = Unit.INSTANCE;
        }
        iNSTANCE4 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if ((Boolean)iNSTANCE4 != null) {
            boolean booleanValue2 = (Boolean)iNSTANCE4.booleanValue();
            selected = 0;
            if (labelToActionId == null) {
                contentDescription = extraDataTestTraversalBeforeVal;
            } else {
                contentDescription = Role.equals-impl0(labelToActionId.unbox-impl(), Role.Companion.getTab-o7Vup1c());
            }
            if (contentDescription) {
                accessibilityNodeInfoCompat.setSelected(booleanValue2);
            } else {
                accessibilityNodeInfoCompat.setChecked(booleanValue2);
            }
            Unit it4 = Unit.INSTANCE;
            iNSTANCE4 = Unit.INSTANCE;
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
            if (semanticsNode2.getReplacedChildren$ui_release().isEmpty()) {
                Object orNull4 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
                if ((List)orNull4 != null) {
                    mergingSemanticsOfDescendants = CollectionsKt.firstOrNull((List)orNull4);
                } else {
                    mergingSemanticsOfDescendants = 0;
                }
                accessibilityNodeInfoCompat.setContentDescription((CharSequence)mergingSemanticsOfDescendants);
            }
        } else {
        }
        orNull3 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
        if ((String)orNull3 != null) {
            testTagsAsResourceId = 0;
            current = semanticsNode;
            while (current != 0) {
                if (current.getUnmergedConfig$ui_release().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    break;
                } else {
                }
                current = current.getParent();
            }
            if (testTagsAsResourceId != 0) {
                accessibilityNodeInfoCompat.setViewIdResourceName((String)orNull3);
            }
        }
        if ((Unit)SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHeading()) != null) {
            heading = 0;
            accessibilityNodeInfoCompat.setHeading(extraDataTestTraversalAfterVal);
            Unit it13 = Unit.INSTANCE;
            iNSTANCE12 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setPassword(semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getPassword()));
        accessibilityNodeInfoCompat.setEditable(semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getIsEditable()));
        Object orNull5 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getMaxTextLength());
        if ((Integer)orNull5 != null) {
            intValue = (Integer)orNull5.intValue();
        } else {
            intValue = legacyClassName-V4PA4sw;
        }
        accessibilityNodeInfoCompat.setMaxTextLength(intValue);
        accessibilityNodeInfoCompat.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2));
        accessibilityNodeInfoCompat.setFocusable(semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getFocused()));
        if (accessibilityNodeInfoCompat.isFocusable()) {
            accessibilityNodeInfoCompat.setFocused((Boolean)semanticsNode2.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getFocused()).booleanValue());
            if (accessibilityNodeInfoCompat.isFocused()) {
                accessibilityNodeInfoCompat.addAction(2);
            } else {
                accessibilityNodeInfoCompat.addAction(extraDataTestTraversalAfterVal);
            }
        }
        accessibilityNodeInfoCompat.setVisibleToUser(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isVisible(semanticsNode2));
        iNSTANCE6 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getLiveRegion());
        if ((LiveRegionMode)iNSTANCE6 != null) {
            int unbox-impl6 = (LiveRegionMode)iNSTANCE6.unbox-impl();
            liveRegion = 0;
            if (LiveRegionMode.equals-impl0(unbox-impl6, LiveRegionMode.Companion.getPolite-0phEisY())) {
                i5 = extraDataTestTraversalAfterVal;
            } else {
                if (LiveRegionMode.equals-impl0(unbox-impl6, LiveRegionMode.Companion.getAssertive-0phEisY())) {
                } else {
                    i5 = extraDataTestTraversalAfterVal;
                }
            }
            accessibilityNodeInfoCompat.setLiveRegion(i5);
            Unit it12 = Unit.INSTANCE;
            iNSTANCE6 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setClickable(extraDataTestTraversalBeforeVal);
        accessibilityActionCompat = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnClick());
        getTextLayoutResult = 16;
        if ((AccessibilityAction)accessibilityActionCompat != null) {
            liveRegion = 0;
            if (labelToActionId == null) {
                equals-impl0 = extraDataTestTraversalBeforeVal;
            } else {
                equals-impl0 = Role.equals-impl0(labelToActionId.unbox-impl(), Role.Companion.getTab-o7Vup1c());
            }
            if (!equals-impl0) {
                if (labelToActionId == null) {
                    equals-impl0 = extraDataTestTraversalBeforeVal;
                } else {
                    equals-impl0 = Role.equals-impl0(labelToActionId.unbox-impl(), Role.Companion.getRadioButton-o7Vup1c());
                }
                if (equals-impl0) {
                    i2 = extraDataTestTraversalAfterVal;
                } else {
                    i2 = extraDataTestTraversalBeforeVal;
                }
            } else {
            }
            if (i2 != 0) {
                if (i2 != 0 && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected()), Boolean.valueOf(extraDataTestTraversalAfterVal))) {
                    if (!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected()), Boolean.valueOf(extraDataTestTraversalAfterVal))) {
                        i = extraDataTestTraversalAfterVal;
                    } else {
                        i = extraDataTestTraversalBeforeVal;
                    }
                } else {
                }
            } else {
            }
            accessibilityNodeInfoCompat.setClickable(i);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2) && accessibilityNodeInfoCompat.isClickable()) {
                if (accessibilityNodeInfoCompat.isClickable()) {
                    accessibilityActionCompat2 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(getTextLayoutResult, (CharSequence)(AccessibilityAction)accessibilityActionCompat.getLabel());
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                }
            }
            Unit isRadioButtonOrTab = Unit.INSTANCE;
            legacyClassName-V4PA4sw = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setLongClickable(extraDataTestTraversalBeforeVal);
        iNSTANCE10 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnLongClick());
        onLongClick = 0;
        accessibilityNodeInfoCompat.setLongClickable(extraDataTestTraversalAfterVal);
        if ((AccessibilityAction)iNSTANCE10 != null && AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2)) {
            onLongClick = 0;
            accessibilityNodeInfoCompat.setLongClickable(extraDataTestTraversalAfterVal);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2)) {
                accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, (CharSequence)(AccessibilityAction)iNSTANCE10.getLabel());
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
            }
            Unit it6 = Unit.INSTANCE;
            iNSTANCE10 = Unit.INSTANCE;
        }
        iNSTANCE = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCopyText());
        if ((AccessibilityAction)iNSTANCE != null) {
            pasteText = 0;
            accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, (CharSequence)(AccessibilityAction)iNSTANCE.getLabel());
            accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
            Unit it11 = Unit.INSTANCE;
            iNSTANCE = Unit.INSTANCE;
        }
        iNSTANCE3 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2) && (AccessibilityAction)iNSTANCE3 != null) {
            iNSTANCE3 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
            if ((AccessibilityAction)(AccessibilityAction)iNSTANCE3 != null) {
                setText = 0;
                accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, (CharSequence)(AccessibilityAction)(AccessibilityAction)iNSTANCE3.getLabel());
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                Unit it10 = Unit.INSTANCE;
                iNSTANCE3 = Unit.INSTANCE;
            }
            iNSTANCE7 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnImeAction());
            if ((AccessibilityAction)iNSTANCE7 != null) {
                onImeAction = 0;
                accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908372, (CharSequence)(AccessibilityAction)iNSTANCE7.getLabel());
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                Unit it9 = Unit.INSTANCE;
                iNSTANCE7 = Unit.INSTANCE;
            }
            iNSTANCE11 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCutText());
            if ((AccessibilityAction)iNSTANCE11 != null) {
                cutText = 0;
                accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, (CharSequence)(AccessibilityAction)iNSTANCE11.getLabel());
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                Unit it8 = Unit.INSTANCE;
                iNSTANCE11 = Unit.INSTANCE;
            }
            iNSTANCE8 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPasteText());
            pasteText = 0;
            if ((AccessibilityAction)iNSTANCE8 != null && accessibilityNodeInfoCompat.isFocused() && obj7.view.getClipboardManager().hasText()) {
                pasteText = 0;
                if (accessibilityNodeInfoCompat.isFocused()) {
                    if (obj7.view.getClipboardManager().hasText()) {
                        accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, (CharSequence)(AccessibilityAction)iNSTANCE8.getLabel());
                        accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                    }
                }
                Unit it7 = Unit.INSTANCE;
                iNSTANCE8 = Unit.INSTANCE;
            }
        }
        iterableTextForAccessibility = obj7.getIterableTextForAccessibility(semanticsNode2);
        length2 = iterableTextForAccessibility;
        if ((CharSequence)length2 != null) {
            if ((CharSequence)length2.length() == 0) {
                orNull = extraDataTestTraversalAfterVal;
            } else {
                orNull = extraDataTestTraversalBeforeVal;
            }
        } else {
        }
        if (orNull == 0) {
            accessibilityNodeInfoCompat.setTextSelection(obj7.getAccessibilitySelectionStart(semanticsNode2), obj7.getAccessibilitySelectionEnd(semanticsNode2));
            orNull = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetSelection());
            if ((AccessibilityAction)orNull != null) {
                label3 = (AccessibilityAction)orNull.getLabel();
            } else {
                label3 = 0;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat5 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, (CharSequence)label3);
            accessibilityNodeInfoCompat.addAction(accessibilityActionCompat5);
            accessibilityNodeInfoCompat.addAction(256);
            accessibilityNodeInfoCompat.addAction(512);
            accessibilityNodeInfoCompat.setMovementGranularities(11);
            empty = accessibilityActionCompat;
            if ((Collection)empty != null) {
                if ((Collection)empty.isEmpty()) {
                    liveRegion = extraDataTestTraversalAfterVal;
                } else {
                    liveRegion = extraDataTestTraversalBeforeVal;
                }
            } else {
            }
            if (liveRegion != 0 && semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$excludeLineAndPageGranularities(semanticsNode2)) {
                if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$excludeLineAndPageGranularities(semanticsNode2)) {
                        accessibilityNodeInfoCompat.setMovementGranularities(getTextLayoutResult |= liveRegion);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        (List)arrayList.add("androidx.compose.ui.semantics.id");
        length = accessibilityNodeInfoCompat.getText();
        if (length != null) {
            if (length.length() == 0) {
                contains5 = extraDataTestTraversalAfterVal;
            } else {
                contains5 = extraDataTestTraversalBeforeVal;
            }
        } else {
        }
        if (contains5 == 0 && semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
            if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag())) {
            arrayList.add("androidx.compose.ui.semantics.testTag");
        }
        accessibilityNodeInfoCompat.setAvailableExtraData(arrayList);
        index$iv2 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if ((ProgressBarRangeInfo)index$iv2 != null) {
            if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                accessibilityNodeInfoCompat.setClassName((CharSequence)"android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat.setClassName((CharSequence)"android.widget.ProgressBar");
            }
            if ((ProgressBarRangeInfo)index$iv2 != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(extraDataTestTraversalAfterVal, (Number)(ProgressBarRangeInfo)index$iv2.getRange().getStart().floatValue(), (Number)index$iv2.getRange().getEndInclusive().floatValue(), index$iv2.getCurrent()));
            }
            if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2) && Float.compare(current2, coerceAtLeast) < 0) {
                if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2)) {
                    if (Float.compare(current2, coerceAtLeast) < 0) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    }
                    if (Float.compare(current3, coerceAtMost) > 0) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    }
                }
            }
        }
        AndroidComposeViewAccessibilityDelegateCompat.Api24Impl.addSetProgressAction(info, semanticsNode);
        CollectionInfo_androidKt.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat);
        CollectionInfo_androidKt.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat);
        xScrollState = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        Object orNull6 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollBy());
        populateAccessibilityNodeInfoProperties$canScrollBackward2 = 0;
        if ((ScrollAxisRange)xScrollState != null && (AccessibilityAction)orNull6 != null && !CollectionInfo_androidKt.hasCollectionInfo(semanticsNode2)) {
            if ((AccessibilityAction)orNull6 != null) {
                if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode2)) {
                    accessibilityNodeInfoCompat.setClassName((CharSequence)"android.widget.HorizontalScrollView");
                }
                if (Float.compare(floatValue5, populateAccessibilityNodeInfoProperties$canScrollBackward2) > 0) {
                    accessibilityNodeInfoCompat.setScrollable(extraDataTestTraversalAfterVal);
                }
                if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2) && AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(xScrollState)) {
                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(xScrollState)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                        populateAccessibilityNodeInfoProperties$canScrollForward = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(semanticsNode2) ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                        accessibilityNodeInfoCompat.addAction(populateAccessibilityNodeInfoProperties$canScrollForward);
                    }
                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(xScrollState)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        populateAccessibilityNodeInfoProperties$canScrollBackward = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(semanticsNode2) ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                        accessibilityNodeInfoCompat.addAction(populateAccessibilityNodeInfoProperties$canScrollBackward);
                    }
                }
            }
        }
        Object orNull8 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if ((ScrollAxisRange)orNull8 != null && (AccessibilityAction)orNull6 != null && !CollectionInfo_androidKt.hasCollectionInfo(semanticsNode2)) {
            if ((AccessibilityAction)orNull6 != null) {
                if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode2)) {
                    accessibilityNodeInfoCompat.setClassName((CharSequence)"android.widget.ScrollView");
                }
                if (Float.compare(verticalScrollAxisRange, populateAccessibilityNodeInfoProperties$canScrollBackward2) > 0) {
                    accessibilityNodeInfoCompat.setScrollable(extraDataTestTraversalAfterVal);
                }
                if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2) && AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(orNull8)) {
                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(orNull8)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                    }
                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(orNull8)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                    }
                }
            }
        }
        AndroidComposeViewAccessibilityDelegateCompat.Api29Impl.addPageActions(info, semanticsNode);
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence)SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode2)) {
            orNull2 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getExpand());
            if ((AccessibilityAction)orNull2 != null) {
                index$iv = 0;
                role = labelToActionId;
                extraDataTestTraversalBeforeVal = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, (CharSequence)(AccessibilityAction)orNull2.getLabel());
                accessibilityNodeInfoCompat.addAction(extraDataTestTraversalBeforeVal);
                Unit iNSTANCE13 = Unit.INSTANCE;
                labelToActionId = Unit.INSTANCE;
            } else {
                role = labelToActionId;
            }
            iNSTANCE5 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCollapse());
            if ((AccessibilityAction)iNSTANCE5 != null) {
                collapse = 0;
                extraDataTestTraversalAfterVal = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, (CharSequence)(AccessibilityAction)iNSTANCE5.getLabel());
                accessibilityNodeInfoCompat.addAction(extraDataTestTraversalAfterVal);
                Unit it2 = Unit.INSTANCE;
                iNSTANCE5 = Unit.INSTANCE;
            }
            iNSTANCE9 = SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getDismiss());
            if ((AccessibilityAction)iNSTANCE9 != null) {
                dismiss = 0;
                extraDataTestTraversalAfterVal = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, (CharSequence)(AccessibilityAction)iNSTANCE9.getLabel());
                accessibilityNodeInfoCompat.addAction(extraDataTestTraversalAfterVal);
                Unit it = Unit.INSTANCE;
                iNSTANCE9 = Unit.INSTANCE;
            }
            if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                obj5 = semanticsNode2.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                if ((List)obj5.size() >= AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds.getSize()) {
                } else {
                    extraDataTestTraversalBeforeVal = new SparseArrayCompat(0, 1, 0);
                    extraDataTestTraversalAfterVal = ObjectIntMapKt.mutableObjectIntMapOf();
                    if (obj7.labelToActionId.containsKey(i7)) {
                        orNull2 = obj7.labelToActionId.get(i7);
                        int i19 = 0;
                        toggleState = toggleState2;
                        obj2 = orNull3;
                        str2 = iterableTextForAccessibility;
                        MutableIntList customActions2 = new MutableIntList(0, 1, 0);
                        IntList accessibilityActionsResourceIds3 = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
                        int i20 = 0;
                        content$iv = accessibilityActionsResourceIds3._size;
                        i6 = i12;
                        $i$a$ApplyAndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$availableIds$1 = index;
                        while ($i$a$ApplyAndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$availableIds$1 < content$iv) {
                            availableIds = 0;
                            customActions2.add(accessibilityActionsResourceIds3.content[$i$a$ApplyAndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$availableIds$1]);
                            $i$a$ApplyAndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$availableIds$1++;
                            content$iv = index;
                        }
                        toggleState2 = new ArrayList();
                        index$iv = 0;
                        $this$fastForEachIndexed$iv = i14;
                        size = obj5.size();
                        while (index$iv < size) {
                            int $this$fastForEach$iv3 = index;
                            i6 = 0;
                            Intrinsics.checkNotNull((MutableObjectIntMap)orNull2);
                            if (orNull2.contains((CustomAccessibilityAction)$this$fastForEach$iv3.getLabel())) {
                            } else {
                            }
                            rangeInfo = index$iv2;
                            obj6 = xScrollState;
                            (List)toggleState2.add($this$fastForEach$iv3);
                            index$iv++;
                            obj3 = iArr;
                            size = availableIds;
                            index$iv2 = rangeInfo;
                            xScrollState = obj6;
                            contains3 = orNull2.get($this$fastForEach$iv3.getLabel());
                            rangeInfo = index$iv2;
                            extraDataTestTraversalBeforeVal.put(contains3, $this$fastForEach$iv3.getLabel());
                            extraDataTestTraversalAfterVal.set($this$fastForEach$iv3.getLabel(), contains3);
                            customActions2.remove(contains3);
                            obj6 = xScrollState;
                            index$iv2 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(contains3, (CharSequence)$this$fastForEach$iv3.getLabel());
                            accessibilityNodeInfoCompat.addAction(index$iv2);
                        }
                        $this$fastForEach$iv = obj3;
                        obj4 = index$iv2;
                        obj = xScrollState;
                        iterableTextForAccessibility = 0;
                        index$iv2 = 0;
                        while (index$iv2 < toggleState2.size()) {
                            $this$fastForEachIndexed$iv = index$iv;
                            $this$fastForEach$iv = null;
                            int unassignedActions = i21;
                            int i13 = obj5.get(unassignedActions);
                            extraDataTestTraversalBeforeVal.put(i13, (CustomAccessibilityAction)$this$fastForEachIndexed$iv.getLabel());
                            extraDataTestTraversalAfterVal.set($this$fastForEachIndexed$iv.getLabel(), i13);
                            i3 = unassignedActions;
                            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat3 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i13, (CharSequence)$this$fastForEachIndexed$iv.getLabel());
                            accessibilityNodeInfoCompat.addAction(accessibilityActionCompat3);
                            index$iv2++;
                            orNull3 = index;
                            toggleState2 = i6;
                            obj5 = availableIds;
                        }
                        availableIds = obj5;
                        list2 = toggleState2;
                        list = orNull3;
                    } else {
                        customActions = obj5;
                        toggleState = toggleState2;
                        obj2 = orNull3;
                        str2 = iterableTextForAccessibility;
                        obj4 = index$iv2;
                        obj = xScrollState;
                        toggleState2 = 0;
                        orNull3 = 0;
                        while (orNull3 < obj5.size()) {
                            xScrollState = index$iv2;
                            index$iv = 0;
                            int i9 = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds.get(orNull3);
                            extraDataTestTraversalBeforeVal.put(i9, (CustomAccessibilityAction)xScrollState.getLabel());
                            extraDataTestTraversalAfterVal.set(xScrollState.getLabel(), i9);
                            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat4 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i9, (CharSequence)xScrollState.getLabel());
                            accessibilityNodeInfoCompat.addAction(accessibilityActionCompat4);
                            orNull3 = list2 + 1;
                            obj5 = $this$fastForEachIndexed$iv;
                            toggleState2 = list;
                        }
                        $this$fastForEachIndexed$iv = obj5;
                        list = toggleState2;
                        list2 = orNull3;
                    }
                    obj7.actionIdToLabel.put(i7, extraDataTestTraversalBeforeVal);
                    obj7.labelToActionId.put(i7, extraDataTestTraversalAfterVal);
                }
                Object customActions5 = obj5;
                Object obj11 = toggleState2;
                StringBuilder stringBuilder = new StringBuilder();
                IllegalStateException customActions3 = new IllegalStateException(stringBuilder.append("Can't have more than ").append(AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds.getSize()).append(" custom actions for one widget").toString());
                throw customActions3;
            }
            toggleState = toggleState2;
            obj2 = orNull3;
            str2 = iterableTextForAccessibility;
            obj4 = index$iv2;
            obj = xScrollState;
        } else {
            role = labelToActionId;
            toggleState = toggleState2;
            obj2 = orNull3;
            str2 = iterableTextForAccessibility;
            obj4 = index$iv2;
            obj = xScrollState;
        }
        accessibilityNodeInfoCompat.setScreenReaderFocusable(obj7.isScreenReaderFocusable(semanticsNode2));
        semanticsIdToView2 = -1;
        int orDefault = obj7.idToBeforeMap.getOrDefault(i7, semanticsIdToView2);
        if (orDefault != semanticsIdToView2) {
            semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(obj7.view.getAndroidViewsHandler$ui_release(), orDefault);
            if (semanticsIdToView2 != null) {
                accessibilityNodeInfoCompat.setTraversalBefore(semanticsIdToView2);
            } else {
                accessibilityNodeInfoCompat.setTraversalBefore((View)obj7.view, orDefault);
            }
            obj7.addExtraDataToAccessibilityNodeInfoHelper(i7, accessibilityNodeInfoCompat, obj7.ExtraDataTestTraversalBeforeVal, 0);
        }
        semanticsIdToView = -1;
        int orDefault2 = obj7.idToAfterMap.getOrDefault(i7, semanticsIdToView);
        semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(obj7.view.getAndroidViewsHandler$ui_release(), orDefault2);
        if (orDefault2 != semanticsIdToView && semanticsIdToView != null) {
            semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(obj7.view.getAndroidViewsHandler$ui_release(), orDefault2);
            if (semanticsIdToView != null) {
                accessibilityNodeInfoCompat.setTraversalAfter(semanticsIdToView);
                obj7.addExtraDataToAccessibilityNodeInfoHelper(i7, accessibilityNodeInfoCompat, obj7.ExtraDataTestTraversalAfterVal, 0);
            }
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward) {
        int i;
        boolean reverseScrolling;
        int floatValue;
        if (Float.compare(floatValue2, floatValue) > 0) {
            if ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) {
                if (Float.compare(floatValue3, floatValue) < 0 && $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) {
                    i = $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollForward) {
        int i;
        boolean reverseScrolling;
        float floatValue;
        if (Float.compare(floatValue2, floatValue) < 0) {
            if ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) {
                if (Float.compare(floatValue3, floatValue) > 0 && $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) {
                    i = $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean registerScrollingId(int id, List<androidx.compose.ui.platform.ScrollObservationScope> oldScrollObservationScopes) {
        int newlyObservingScroll;
        androidx.compose.ui.platform.ScrollObservationScope scrollObservationScope;
        int i2;
        List scrollObservationScopes;
        int i5;
        int i3;
        int i;
        int i4;
        newlyObservingScroll = 0;
        final androidx.compose.ui.platform.ScrollObservationScope byId = SemanticsUtils_androidKt.findById(oldScrollObservationScopes, id);
        if (byId != null) {
            i2 = id;
            scrollObservationScope = byId;
        } else {
            newlyObservingScroll = 1;
            scrollObservationScope = new ScrollObservationScope(id, this.scrollObservationScopes, 0, 0, 0, 0);
        }
        this.scrollObservationScopes.add(scrollObservationScope);
        return newlyObservingScroll;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        Object obj;
        int focusedVirtualViewId;
        int i;
        int i5;
        int i3;
        int i2;
        int i4;
        int i8 = 0;
        if (!isTouchExplorationEnabled()) {
            return i8;
        }
        if (!isAccessibilityFocused(virtualViewId) && this.focusedVirtualViewId != Integer.MIN_VALUE) {
            if (this.focusedVirtualViewId != Integer.MIN_VALUE) {
                AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, this.focusedVirtualViewId, 65536, 0, 0, 12, 0);
            }
            this.focusedVirtualViewId = virtualViewId;
            this.view.invalidate();
            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, virtualViewId, 32768, 0, 0, 12, 0);
            return 1;
        }
        return i8;
    }

    private final void scheduleScrollEventIfNeeded(androidx.compose.ui.platform.ScrollObservationScope scrollObservationScope) {
        if (!scrollObservationScope.isValidOwnerScope()) {
        }
        AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded.1 anon = new AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded.1(scrollObservationScope, this);
        this.view.getSnapshotObserver().observeReads$ui_release((OwnerScope)scrollObservationScope, this.scheduleScrollEventIfNeededLambda, (Function0)anon);
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean layoutIsRtl) {
        Object iNSTANCE;
        final int i = 0;
        iNSTANCE = layoutIsRtl ? AndroidComposeViewAccessibilityDelegateCompat.RtlBoundsComparator.INSTANCE : AndroidComposeViewAccessibilityDelegateCompat.LtrBoundsComparator.INSTANCE;
        AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.1 anon2 = new AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.1((Comparator)iNSTANCE, LayoutNode.Companion.getZComparator$ui_release());
        AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.2 anon = new AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.2((Comparator)anon2);
        return (Comparator)anon;
    }

    private static final void semanticsChangeChecker$lambda$60(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat this$0) {
        int i = 0;
        Trace.beginSection("measureAndLayout");
        int i3 = 0;
        final int i7 = 0;
        Owner.measureAndLayout$default((Owner)this$0.view, i7, 1, 0);
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$semanticsChangeChecker$1$1 = Unit.INSTANCE;
        Trace.endSection();
        int i2 = 0;
        Trace.beginSection("checkForSemanticsChanges");
        int i4 = 0;
        this$0.checkForSemanticsChanges();
        Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$semanticsChangeChecker$1$2 = Unit.INSTANCE;
        Trace.endSection();
        this$0.checkingForSemanticsChanges = i7;
    }

    private final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode newNode, androidx.compose.ui.platform.SemanticsNodeCopy oldNode) {
        int newChildren2;
        int children;
        int i3;
        int index$iv;
        int index$iv2;
        MutableIntSet set;
        Object obj2;
        int i4;
        Object obj;
        long[] metadata;
        int i2;
        int contains2;
        boolean contains;
        int i$iv$iv;
        int slot$iv$iv;
        int j$iv$iv;
        int i5;
        int i8;
        MutableIntSet set2;
        int i9;
        long l;
        int i6;
        int i7;
        int i;
        MutableIntSet newChildren;
        final Object obj3 = this;
        newChildren2 = IntSetKt.mutableIntSetOf();
        List replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int i17 = 0;
        index$iv2 = 0;
        while (index$iv2 < replacedChildren$ui_release2.size()) {
            obj = obj2;
            i2 = 0;
            index$iv2++;
            newChildren2.add(obj.getId());
        }
        children = oldNode.getChildren();
        i4 = 0;
        metadata = set.metadata;
        length += -2;
        if (0 <= contains2) {
        } else {
            newChildren = newChildren2;
            set2 = children;
            i9 = i3;
        }
        List replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int i10 = 0;
        index$iv = 0;
        while (index$iv < replacedChildren$ui_release.size()) {
            i4 = set;
            metadata = null;
            if (obj3.getCurrentSemanticsNodes().contains((SemanticsNode)i4.getId())) {
            }
            index$iv++;
            contains2 = obj3.previousSemanticsNodes.get(i4.getId());
            Intrinsics.checkNotNull(contains2);
            obj3.sendAccessibilitySemanticsStructureChangeEvents(i4, (SemanticsNodeCopy)contains2);
        }
    }

    private final boolean sendEvent(AccessibilityEvent event) {
        int eventType;
        int i;
        final int i2 = 0;
        if (!isEnabled$ui_release()) {
            return i2;
        }
        if (event.getEventType() != 2048) {
            if (event.getEventType() == 32768) {
                this.sendingFocusAffectingEvent = true;
            }
        } else {
        }
        this.sendingFocusAffectingEvent = i2;
        return (Boolean)this.onSendAccessibilityEvent.invoke(event).booleanValue();
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        int enabled$ui_release;
        List contentDescription3;
        List contentDescription2;
        String str;
        int i3;
        int i7;
        int i6;
        int i;
        int i4;
        int i5;
        int i2;
        Object obj15;
        if (virtualViewId != Integer.MIN_VALUE) {
            if (!isEnabled$ui_release()) {
                contentDescription3 = contentDescription;
                return 0;
            } else {
                final AccessibilityEvent event = createEvent(virtualViewId, eventType);
                if (contentChangeType != null) {
                    event.setContentChangeTypes(contentChangeType.intValue());
                }
                if (contentDescription != null) {
                    event.setContentDescription((CharSequence)ListUtilsKt.fastJoinToString$default(contentDescription, (CharSequence)",", 0, 0, 0, 0, 0, 62, 0));
                } else {
                    contentDescription2 = contentDescription;
                }
            }
            int i9 = 0;
            Trace.beginSection("sendEvent");
            int i8 = 0;
            Trace.endSection();
            return sendEvent(event);
        }
        contentDescription3 = contentDescription;
    }

    static boolean sendEventForVirtualView$default(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i2, int i3, Integer integer4, List list5, int i6, Object object7) {
        int obj4;
        int obj5;
        final int i = 0;
        if (i6 & 4 != 0) {
            obj4 = i;
        }
        if (i6 &= 8 != 0) {
            obj5 = i;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i2, i3, obj4, obj5);
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        int text;
        AccessibilityEvent event = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        event.setContentChangeTypes(contentChangeType);
        if (title != null) {
            event.getText().add(title);
        }
        sendEvent(event);
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        int i;
        int event;
        List text;
        int iterableTextForAccessibility;
        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        i = 0;
        if (pendingTextTraversedEvent != null && semanticsNodeId != pendingTextTraversedEvent.getNode().getId()) {
            i = 0;
            if (semanticsNodeId != pendingTextTraversedEvent.getNode().getId()) {
            }
            if (Long.compare(i3, iterableTextForAccessibility) <= 0) {
                event = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), 131072);
                event.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                event.setToIndex(pendingTextTraversedEvent.getToIndex());
                event.setAction(pendingTextTraversedEvent.getAction());
                event.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                event.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(event);
            }
        }
        this.pendingTextTraversedEvent = 0;
    }

    private final void sendSemanticsPropertyChangeEvents(IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        Object lastIndex$iv$iv;
        int oldLabels;
        ArrayList semanticsNodeIdToAccessibilityVirtualNodeId;
        boolean equals-impl0;
        Object textForTextField2;
        int i9;
        Object obj2;
        boolean booleanValue;
        Object textForTextField3;
        Object textForTextField;
        int i6;
        int i7;
        int j$iv$iv2;
        int slot$iv$iv;
        boolean equal;
        boolean equal2;
        Object customActions;
        boolean all;
        int i16;
        String str;
        int startCount;
        int labels;
        int key;
        int charAt2;
        int endCount2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int charAt;
        int newNode;
        int next;
        int index$iv;
        int index$iv2;
        int i$iv$iv2;
        int oldScrollObservationScopes2;
        int oldScrollObservationScopes;
        Object this_$iv;
        int this_$iv2;
        int newNode3;
        int[] k$iv;
        int newlyObservingScroll;
        boolean z;
        Object verticalScrollAxisRange;
        int i;
        int i17;
        int i12;
        long slot$iv$iv2;
        int i11;
        int i8;
        int i2;
        int i10;
        int i4;
        int i22;
        Object obj;
        int i13;
        Iterator iterator;
        int propertyChanged;
        Object obj3;
        ArrayList oldScrollObservationScopes3;
        Object iNSTANCE;
        Object i$iv$iv;
        int j$iv$iv;
        int newNode2;
        int mergedNode;
        SemanticsNode mergedNode2;
        int[] iArr;
        int endCount;
        int i15;
        int actions;
        int oldActions;
        int i21;
        int i19;
        int i14;
        int i18;
        boolean oldNodeIsTextfield;
        int i5;
        int i3;
        int i20;
        lastIndex$iv$iv = this;
        ArrayList arrayList = new ArrayList((Collection)lastIndex$iv$iv.scrollObservationScopes);
        lastIndex$iv$iv.scrollObservationScopes.clear();
        this_$iv = newSemanticsNodes;
        final int i43 = 0;
        final long[] metadata = obj9.metadata;
        newlyObservingScroll = 2;
        i = length + -2;
        if (0 <= i) {
        } else {
            oldScrollObservationScopes3 = i$iv$iv2;
            i$iv$iv = this_$iv;
            mergedNode = newNode3;
            iArr = k$iv;
            lastIndex$iv$iv = i;
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet subtreeChangedSemanticsNodesIds) {
        int potentialAncestor;
        boolean ancestorOf;
        Object layoutNode2;
        SemanticsConfiguration collapsedSemantics$ui_release;
        Object it;
        boolean mergingSemanticsOfDescendants;
        int constructor-impl;
        if (!layoutNode.isAttached()) {
        }
        if ((Map)this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
        }
        potentialAncestor = 0;
        while (potentialAncestor < this.subtreeChangedLayoutNodes.size()) {
            potentialAncestor++;
        }
        int i3 = 0;
        Trace.beginSection("GetSemanticsNode");
        int i = 0;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        it = 0;
        if (layoutNode.getNodes$ui_release().has-H91voCI$ui_release(NodeKind.constructor-impl(8))) {
            layoutNode2 = layoutNode;
        } else {
            layoutNode2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(layoutNode, (Function1)AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents.id.1.semanticsNode.1.INSTANCE);
        }
        objectRef.element = layoutNode2;
        collapsedSemantics$ui_release = objectRef.element;
        if ((LayoutNode)collapsedSemantics$ui_release != null) {
            collapsedSemantics$ui_release = (LayoutNode)collapsedSemantics$ui_release.getCollapsedSemantics$ui_release();
            if (collapsedSemantics$ui_release == null) {
            } else {
                mergingSemanticsOfDescendants = AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode((LayoutNode)objectRef.element, (Function1)AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents.id.1.1.INSTANCE);
                if (!collapsedSemantics$ui_release.isMergingSemanticsOfDescendants() && mergingSemanticsOfDescendants != null) {
                    mergingSemanticsOfDescendants = AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode((LayoutNode)objectRef.element, (Function1)AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents.id.1.1.INSTANCE);
                    if (mergingSemanticsOfDescendants != null) {
                        constructor-impl = 0;
                        objectRef.element = mergingSemanticsOfDescendants;
                    }
                }
                it = objectRef.element;
                int semanticsId = (LayoutNode)it.getSemanticsId();
                Trace.endSection();
                if (it != null && !subtreeChangedSemanticsNodesIds.add(semanticsId)) {
                    semanticsId = it.getSemanticsId();
                    Trace.endSection();
                    if (!subtreeChangedSemanticsNodesIds.add(semanticsId)) {
                    }
                    AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, 0, 8, 0);
                }
            }
        } else {
        }
        Trace.endSection();
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        Object obj;
        int i;
        int i2;
        if (!layoutNode.isAttached()) {
        }
        if ((Map)this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
        }
        int semanticsId = layoutNode.getSemanticsId();
        Object obj2 = this.pendingHorizontalScrollEvents.get(semanticsId);
        Object obj3 = this.pendingVerticalScrollEvents.get(semanticsId);
        if ((ScrollAxisRange)obj2 == null && (ScrollAxisRange)obj3 == null) {
            if ((ScrollAxisRange)obj3 == null) {
            }
        }
        AccessibilityEvent event = createEvent(semanticsId, 4096);
        if ((ScrollAxisRange)obj2 != null) {
            obj = obj2;
            i = 0;
            event.setScrollX((int)floatValue3);
            event.setMaxScrollX((int)floatValue4);
        }
        if ((ScrollAxisRange)obj3 != null) {
            obj = obj3;
            i = 0;
            event.setScrollY((int)floatValue);
            event.setMaxScrollY((int)floatValue2);
        }
        sendEvent(event);
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        boolean accessibilityCursorPosition;
        Object action;
        int booleanValue;
        int length;
        int i2;
        int valueOf;
        Object setSelection;
        Boolean valueOf2;
        Integer valueOf3;
        int i;
        Integer num;
        booleanValue = 0;
        if (node.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(node)) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(node)) {
                action = (AccessibilityAction)node.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getSetSelection()).getAction();
                if ((Function3)action != null) {
                    booleanValue = (Boolean)(Function3)action.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode)).booleanValue();
                } else {
                }
                return booleanValue;
            }
        }
        if (start == end && end == this.accessibilityCursorPosition) {
            if (end == this.accessibilityCursorPosition) {
                return booleanValue;
            }
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        if (iterableTextForAccessibility == null) {
            return booleanValue;
        }
        if (start >= 0 && start == end && end <= iterableTextForAccessibility.length()) {
            if (start == end) {
                i2 = end <= iterableTextForAccessibility.length() ? start : -1;
            } else {
            }
        } else {
        }
        this.accessibilityCursorPosition = i2;
        int i3 = 1;
        if ((CharSequence)iterableTextForAccessibility.length() > 0) {
            booleanValue = i3;
        }
        valueOf = 0;
        if (booleanValue != 0) {
            i = valueOf3;
        } else {
            i = valueOf;
        }
        if (booleanValue != 0) {
            num = valueOf3;
        } else {
            num = valueOf;
        }
        if (booleanValue != 0) {
            valueOf = Integer.valueOf(iterableTextForAccessibility.length());
        }
        sendEvent(this.createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), i, num, valueOf, (CharSequence)iterableTextForAccessibility));
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return i3;
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        boolean orNull;
        androidx.compose.ui.semantics.SemanticsPropertyKey error;
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence)SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final void setIsCheckable(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setCheckable(getInfoIsCheckable(node));
    }

    private final void setStateDescription(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setStateDescription((CharSequence)getInfoStateDescriptionOrNull(node));
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        SpannableString spannableString;
        AnnotatedString infoText = getInfoText(node);
        if (infoText != null) {
            spannableString = toSpannableString(infoText);
        } else {
            spannableString = 0;
        }
        info.setText((CharSequence)spannableString);
    }

    private final void setTraversalValues() {
        SemanticsNode semanticsNode;
        int i;
        int i3;
        int i2;
        MutableIntIntMap idToAfterMap;
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        Object obj = getCurrentSemanticsNodes().get(-1);
        if ((SemanticsNodeWithAdjustedBounds)obj != null) {
            semanticsNode = (SemanticsNodeWithAdjustedBounds)obj.getSemanticsNode();
        } else {
            semanticsNode = 0;
        }
        Intrinsics.checkNotNull(semanticsNode);
        SemanticsNode[] arr = new SemanticsNode[1];
        List subtreeSortedByGeometryGrouping = subtreeSortedByGeometryGrouping(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(semanticsNode), CollectionsKt.mutableListOf(semanticsNode));
        final int lastIndex = CollectionsKt.getLastIndex(subtreeSortedByGeometryGrouping);
        if (1 <= lastIndex) {
        }
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean layoutIsRtl, ArrayList<SemanticsNode> parentListToSort, MutableIntObjectMap<List<SemanticsNode>> containerChildrenMapping) {
        int entryIndex;
        int i3;
        Object obj;
        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2 iNSTANCE2;
        Rect sortByGeometryGroupings$placedEntryRowOverlaps;
        int index$iv;
        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0;
        Pair pair;
        int size2;
        List screenReaderFocusable;
        int i4;
        int size;
        Object second;
        int i2;
        int i;
        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.2 anon;
        Object iNSTANCE;
        Comparator zComparator$ui_release;
        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.1 anon2;
        final List list = parentListToSort;
        ArrayList arrayList = new ArrayList();
        int lastIndex = CollectionsKt.getLastIndex((List)list);
        if (0 <= lastIndex) {
        }
        CollectionsKt.sortWith((List)arrayList, (Comparator)AndroidComposeViewAccessibilityDelegateCompat.TopBottomBoundsComparator.INSTANCE);
        ArrayList arrayList2 = new ArrayList();
        ArrayList list3 = arrayList;
        int i5 = 0;
        index$iv = 0;
        while (index$iv < (List)list3.size()) {
            i4 = screenReaderFocusable;
            size = 0;
            i2 = this;
            i = 0;
            if (layoutIsRtl) {
            } else {
            }
            iNSTANCE = AndroidComposeViewAccessibilityDelegateCompat.LtrBoundsComparator.INSTANCE;
            anon2 = new AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.1((Comparator)iNSTANCE, LayoutNode.Companion.getZComparator$ui_release());
            anon = new AndroidComposeViewAccessibilityDelegateCompat.semanticComparator$$inlined.thenBy.2((Comparator)anon2);
            CollectionsKt.sortWith((List)(Pair)i4.getSecond(), (Comparator)anon);
            arrayList2.addAll((Collection)i4.getSecond());
            index$iv++;
            iNSTANCE = AndroidComposeViewAccessibilityDelegateCompat.RtlBoundsComparator.INSTANCE;
        }
        externalSyntheticLambda0 = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0((Function2)AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2.INSTANCE);
        CollectionsKt.sortWith((List)arrayList2, externalSyntheticLambda0);
        i3 = 0;
        while (i3 <= CollectionsKt.getLastIndex((List)arrayList2)) {
            size2 = containerChildrenMapping.get((SemanticsNode)arrayList2.get(i3).getId());
            if ((List)size2 != 0) {
            } else {
            }
            i4 = this;
            i3++;
            if (this.isScreenReaderFocusable((SemanticsNode)arrayList2.get(i3)) == null) {
            } else {
            }
            i3++;
            arrayList2.addAll(i3, (Collection)(List)size2);
            i3 += size;
            arrayList2.remove(i3);
        }
        int i7 = this;
        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 view = containerChildrenMapping;
        return (List)arrayList2;
    }

    static List sortByGeometryGroupings$default(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z2, ArrayList arrayList3, MutableIntObjectMap mutableIntObjectMap4, int i5, Object object6) {
        MutableIntObjectMap obj3;
        if (i5 &= 4 != 0) {
            obj3 = IntObjectMapKt.mutableIntObjectMapOf();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z2, arrayList3, obj3);
    }

    private static final int sortByGeometryGroupings$lambda$15(Function2 $tmp0, Object p0, Object p1) {
        return (Number)$tmp0.invoke(p0, p1).intValue();
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(ArrayList<Pair<Rect, List<SemanticsNode>>> rowGroupings, SemanticsNode node) {
        int i;
        int currIndex;
        Object first;
        int i2;
        int i3;
        float bottom;
        float f;
        float top = node.getBoundsInWindow().getTop();
        float bottom2 = node.getBoundsInWindow().getBottom();
        int i4 = 0;
        final int i6 = 1;
        i = Float.compare(top, bottom2) >= 0 ? i6 : i4;
        int lastIndex = CollectionsKt.getLastIndex((List)rowGroupings);
        if (0 <= lastIndex) {
        }
        return i4;
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean layoutIsRtl, List<SemanticsNode> listToSort) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        final MutableIntObjectMap mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        Object obj3 = listToSort;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            geometryDepthFirstSearch((SemanticsNode)obj3.get(index$iv), arrayList, mutableIntObjectMapOf);
            index$iv++;
        }
        return sortByGeometryGroupings(layoutIsRtl, arrayList, mutableIntObjectMapOf);
    }

    private final RectF toScreenCoords(SemanticsNode textNode, Rect bounds) {
        int rectF;
        Rect intersect;
        long localToScreen-MK-Hz9U2;
        float top;
        long localToScreen-MK-Hz9U;
        float bottom;
        float x-impl;
        float y-impl2;
        float x-impl2;
        float y-impl;
        rectF = 0;
        if (textNode == null) {
            return rectF;
        }
        Rect translate-k-4lQ0M = bounds.translate-k-4lQ0M(textNode.getPositionInRoot-F1C5BW0());
        final Rect boundsInRoot = textNode.getBoundsInRoot();
        if (translate-k-4lQ0M.overlaps(boundsInRoot)) {
            intersect = translate-k-4lQ0M.intersect(boundsInRoot);
        } else {
            intersect = rectF;
        }
        if (intersect != null) {
            top = intersect.getTop();
            localToScreen-MK-Hz9U2 = this.view.localToScreen-MK-Hz9U(OffsetKt.Offset(intersect.getLeft(), top));
            bottom = intersect.getBottom();
            localToScreen-MK-Hz9U = this.view.localToScreen-MK-Hz9U(OffsetKt.Offset(intersect.getRight(), bottom));
            rectF = new RectF(Offset.getX-impl(localToScreen-MK-Hz9U2), Offset.getY-impl(localToScreen-MK-Hz9U2), Offset.getX-impl(localToScreen-MK-Hz9U), Offset.getY-impl(localToScreen-MK-Hz9U));
        } else {
        }
        return rectF;
    }

    private final SpannableString toSpannableString(AnnotatedString $this$toSpannableString) {
        return (SpannableString)trimToSize((CharSequence)AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString($this$toSpannableString, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), 100000);
    }

    private static final void touchExplorationStateListener$lambda$1(androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat this$0, boolean it) {
        this$0.enabledServices = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        Integer valueOf;
        int previousTraversedNode;
        int i4;
        String length;
        int i5;
        int i;
        int selectionStart;
        int current;
        int length2;
        int[] preceding;
        int i2;
        boolean accessibilitySelectionExtendable;
        int i3;
        final Object obj = this;
        previousTraversedNode = obj.previousTraversedNode;
        i = -1;
        if (previousTraversedNode == null) {
            obj.accessibilityCursorPosition = i;
            obj.previousTraversedNode = Integer.valueOf(node.getId());
        } else {
            if (node.getId() != previousTraversedNode.intValue()) {
            }
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        length = iterableTextForAccessibility;
        final int i6 = 1;
        int i7 = 0;
        if ((CharSequence)length != null) {
            if ((CharSequence)length.length() == 0) {
                i4 = i6;
            } else {
                i4 = i7;
            }
        } else {
        }
        if (i4 != 0) {
            return i7;
        }
        androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator iteratorForGranularity = getIteratorForGranularity(node, granularity);
        if (iteratorForGranularity == null) {
            return i7;
        }
        if (getAccessibilitySelectionEnd(node) == i) {
            if (forward) {
                length2 = i7;
            } else {
                length2 = iterableTextForAccessibility.length();
            }
            current = length2;
        }
        if (forward) {
            preceding = iteratorForGranularity.following(current);
        } else {
            preceding = iteratorForGranularity.preceding(current);
        }
        if (preceding == null) {
            return i7;
        }
        final int i11 = preceding[i7];
        final int i12 = preceding[i6];
        int i8 = 0;
        int i9 = 0;
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            if (isAccessibilitySelectionExtendable(node)) {
                if (getAccessibilitySelectionStart(node) == i) {
                    i = forward ? i11 : i12;
                    selectionStart = i;
                }
                i5 = forward ? i12 : i11;
            } else {
                i5 = forward ? i12 : i11;
                selectionStart = i5;
            }
        } else {
        }
        i3 = forward ? i2 : i2;
        SemanticsNode semanticsNode = node;
        AndroidComposeViewAccessibilityDelegateCompat.PendingTextTraversedEvent pendingTextTraversedEvent = new AndroidComposeViewAccessibilityDelegateCompat.PendingTextTraversedEvent(semanticsNode, i3, granularity, i11, i12, SystemClock.uptimeMillis(), obj15);
        obj.pendingTextTraversedEvent = pendingTextTraversedEvent;
        obj.setAccessibilitySelection(semanticsNode, selectionStart, i5, i6);
        return i6;
    }

    private final <T extends java.lang.CharSequence> T trimToSize(T text, int size) {
        int length2;
        boolean highSurrogate;
        int i;
        int len;
        int length;
        int i2 = 0;
        i = size > 0 ? length2 : i2;
        if (i == 0) {
        } else {
            len = size;
            if (text != 0) {
                if (text.length() == 0) {
                } else {
                    length2 = i2;
                }
            }
            if (length2 == 0) {
                if (text.length() <= size) {
                } else {
                    if (Character.isHighSurrogate(text.charAt(size + -1)) && Character.isLowSurrogate(text.charAt(size))) {
                        if (Character.isLowSurrogate(text.charAt(size))) {
                            len = size + -1;
                        }
                    }
                }
                java.lang.CharSequence subSequence = text.subSequence(i2, len);
                Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
                return subSequence;
            }
            return text;
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireAndroidComposeViewAccessibilityDelegateCompat$trimToSize$1 = new IllegalArgumentException("size should be greater than 0".toString());
        throw $i$a$RequireAndroidComposeViewAccessibilityDelegateCompat$trimToSize$1;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        if (this.hoveredVirtualViewId == virtualViewId) {
        }
        this.hoveredVirtualViewId = virtualViewId;
        final int i8 = 0;
        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, virtualViewId, 128, 0, i8, 12, 0);
        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, this.hoveredVirtualViewId, 256, 0, 0, 12, i8);
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        int j$iv$iv;
        int j$iv$iv3;
        int semanticsNode2;
        IntObjectMap currentSemanticsNodes2;
        Object unmergedConfig;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int previousSemanticsNodes;
        boolean contains;
        int paneTitle;
        int[] semanticsNodeCopy;
        androidx.compose.ui.semantics.SemanticsPropertyKey paneTitle2;
        Object[] semanticsNode;
        IntObjectMap currentSemanticsNodes;
        int i$iv$iv;
        int slot$iv$iv;
        int i$iv$iv2;
        int value$iv$iv$iv;
        int i2;
        int i5;
        int toRemove;
        long slot$iv$iv2;
        int j$iv$iv2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        int i6;
        int i4;
        int i;
        SemanticsNode currentNode;
        SemanticsProperties $i$f$forEach;
        int i7;
        IntObjectMap map;
        final Object obj = this;
        j$iv$iv = new MutableIntSet(0, 1, 0);
        MutableIntSet paneDisplayed3 = obj.paneDisplayed;
        int i19 = 0;
        int i21 = 0;
        long[] metadata2 = set2.metadata;
        length2 += -2;
        final int i29 = 7;
        final long l2 = -9187201950435737472L;
        semanticsNode2 = 8;
        if (0 <= slot$iv$iv) {
        } else {
            i4 = i5;
            $this$maskEmptyOrDeleted$iv$iv$iv = 128;
        }
        obj.paneDisplayed.removeAll((IntSet)j$iv$iv);
        obj.previousSemanticsNodes.clear();
        currentSemanticsNodes2 = obj.getCurrentSemanticsNodes();
        currentSemanticsNodes = currentSemanticsNodes2;
        int i20 = 0;
        long[] metadata = currentSemanticsNodes.metadata;
        length += -2;
        if (0 <= i22) {
        } else {
            toRemove = j$iv$iv;
            slot$iv$iv2 = currentSemanticsNodes2;
            $i$f$forEach = previousSemanticsNodes;
            i7 = semanticsNodeCopy;
            currentNode = semanticsNode;
            map = currentSemanticsNodes;
        }
        SemanticsNodeCopy semanticsNodeCopy2 = new SemanticsNodeCopy(obj.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), obj.getCurrentSemanticsNodes());
        obj.previousSemanticsRoot = semanticsNodeCopy2;
    }

    public final Object boundsUpdatesEventLoop$ui_release(Continuation<? super Unit> continuation) {
        boolean $result;
        Object $continuation4;
        Throwable $continuation;
        Object $continuation2;
        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop.1 view;
        Throwable subtreeChangedLayoutNodes;
        int i3;
        Object $i$f$trace;
        Object subtreeChangedSemanticsNodesIds;
        int $i$f$trace2;
        Object iterator;
        Throwable th;
        Object _this;
        Object obj;
        Object l$1;
        Object l$0;
        Object delay;
        boolean checkingForSemanticsChanges;
        int i;
        int semanticsChangeChecker;
        int iNSTANCE;
        int i2;
        int i5;
        int i4;
        Object obj15;
        $result = continuation;
        subtreeChangedLayoutNodes = Integer.MIN_VALUE;
        if (continuation instanceof AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop.1 && label &= subtreeChangedLayoutNodes != 0) {
            $result = continuation;
            subtreeChangedLayoutNodes = Integer.MIN_VALUE;
            if (label &= subtreeChangedLayoutNodes != 0) {
                $result.label = obj15 -= subtreeChangedLayoutNodes;
            } else {
                $result = new AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop.1(this, continuation);
            }
        } else {
        }
        obj15 = $result.result;
        final int i6 = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                $i$f$trace = new MutableIntSet(0, i6, 0);
                iterator = obj.boundsUpdateChannel.iterator();
                break;
            case 1:
                ResultKt.throwOnFailure(obj15);
                l$1 = iterator;
                l$0 = l$02;
                _this = $i$f$trace3;
                subtreeChangedSemanticsNodesIds = $continuation2;
                view = $result;
                $continuation4 = obj15;
                _this.next();
                Trace.beginSection("AccessibilityLoopIteration");
                i = 0;
                Object valueAt = l$0.subtreeChangedLayoutNodes.valueAt(i);
                int i10 = 0;
                Trace.beginSection("sendSubtreeChangeAccessibilityEvents");
                int i9 = 0;
                l$0.sendSubtreeChangeAccessibilityEvents((LayoutNode)valueAt, l$1);
                Unit $i$a$TraceAndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$2$1 = Unit.INSTANCE;
                Trace.endSection();
                i5 = 0;
                Trace.beginSection("sendTypeViewScrolledAccessibilityEvent");
                i2 = 0;
                l$0.sendTypeViewScrolledAccessibilityEvent(valueAt);
                iNSTANCE = Unit.INSTANCE;
                Trace.endSection();
                i++;
                l$1.clear();
                l$0.checkingForSemanticsChanges = i6;
                l$0.handler.post(l$0.semanticsChangeChecker);
                l$0.subtreeChangedLayoutNodes.clear();
                l$0.pendingHorizontalScrollEvents.clear();
                l$0.pendingVerticalScrollEvents.clear();
                view.L$0 = l$0;
                view.L$1 = l$1;
                view.L$2 = _this;
                view.label = 2;
                return subtreeChangedSemanticsNodesIds;
                $i$f$trace2 = obj15;
                obj15 = $continuation4;
                $result = view;
                $continuation2 = subtreeChangedSemanticsNodesIds;
                i3 = i4;
                Unit $i$f$trace4 = Unit.INSTANCE;
                Trace.endSection();
                iterator = _this;
                $i$f$trace = l$1;
                obj = l$0;
                l$0.subtreeChangedLayoutNodes.clear();
                return Unit.INSTANCE;
            case 2:
                i3 = 0;
                $i$f$trace2 = 0;
                _this = $result.L$2;
                l$1 = $result.L$1;
                l$0 = $result.L$0;
                ResultKt.throwOnFailure(obj15);
                $i$f$trace4 = Unit.INSTANCE;
                Trace.endSection();
                iterator = _this;
                $i$f$trace = l$1;
                obj = l$0;
                break;
            default:
                obj15 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj15;
        }
        $result.L$0 = obj;
        $result.L$1 = $i$f$trace;
        $result.L$2 = iterator;
        $result.label = i6;
        Object next = iterator.hasNext($result);
        if (next == $continuation2) {
            return $continuation2;
        } else {
            $continuation4 = obj15;
            obj15 = next;
            l$1 = $i$f$trace;
            subtreeChangedSemanticsNodesIds = $continuation2;
            view = view2;
            l$0 = obj;
            _this = iterator;
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean canScroll-0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return 0;
        }
        return this.canScroll-moWRBKg(getCurrentSemanticsNodes(), vertical, direction, position);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean dispatchHoverEvent$ui_release(MotionEvent event) {
        androidx.compose.ui.platform.AndroidViewsHandler hoveredVirtualViewId;
        int dispatchGenericMotionEvent;
        int i = 0;
        if (!isTouchExplorationEnabled()) {
            return i;
        }
        dispatchGenericMotionEvent = 1;
        final int i2 = Integer.MIN_VALUE;
        switch (action) {
            case 7:
                int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
                updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
                dispatchGenericMotionEvent = dispatchGenericMotionEvent2;
                return dispatchGenericMotionEvent;
            case 8:
                return i;
            default:
                updateHoveredVirtualView(i2);
                dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                return dispatchGenericMotionEvent;
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return (AccessibilityNodeProviderCompat)this.nodeProvider;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final String getExtraDataTestTraversalAfterVal$ui_release() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final String getExtraDataTestTraversalBeforeVal$ui_release() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final MutableIntIntMap getIdToAfterMap$ui_release() {
        return this.idToAfterMap;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final MutableIntIntMap getIdToBeforeMap$ui_release() {
        return this.idToBeforeMap;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui_release() {
        return this.onSendAccessibilityEvent;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final long getSendRecurringAccessibilityEventsIntervalMillis$ui_release() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final androidx.compose.ui.platform.AndroidComposeView getView() {
        return this.view;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        int virtualViewId;
        int i;
        int i2;
        int requireLayoutNode;
        boolean semanticsId;
        int $i$f$getSemanticsOLwlOKw;
        int i3;
        i = 0;
        i2 = 1;
        Owner.measureAndLayout$default((Owner)this.view, i, i2, 0);
        HitTestResult hitTestResult = new HitTestResult();
        final HitTestResult hitTestResult3 = hitTestResult;
        LayoutNode.hitTestSemantics-M_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(x, y), obj6, hitTestResult3, false, 0, 12);
        Object lastOrNull = CollectionsKt.lastOrNull((List)hitTestResult3);
        if ((Modifier.Node)lastOrNull != null) {
            requireLayoutNode = DelegatableNodeKt.requireLayoutNode((DelegatableNode)(Modifier.Node)lastOrNull);
        }
        virtualViewId = Integer.MIN_VALUE;
        semanticsId = requireLayoutNode.getNodes$ui_release();
        int i4 = 0;
        if (requireLayoutNode != 0 && semanticsId != null && semanticsId.has-H91voCI$ui_release(NodeKind.constructor-impl(8)) == i2) {
            semanticsId = requireLayoutNode.getNodes$ui_release();
            if (semanticsId != null) {
                i4 = 0;
                if (semanticsId.has-H91voCI$ui_release(NodeKind.constructor-impl(8)) == i2) {
                } else {
                    i2 = i;
                }
            } else {
            }
        } else {
        }
        if (i2 != 0 && AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isVisible(SemanticsNodeKt.SemanticsNode(requireLayoutNode, i)) && (AndroidViewHolder)this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(requireLayoutNode) == null) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isVisible(SemanticsNodeKt.SemanticsNode(requireLayoutNode, i))) {
                if ((AndroidViewHolder)this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(requireLayoutNode) == null) {
                    virtualViewId = semanticsNodeIdToAccessibilityVirtualNodeId(requireLayoutNode.getSemanticsId());
                }
            }
        }
        return virtualViewId;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean isEnabled$ui_release() {
        boolean accessibilityForceEnabledForTesting;
        int i;
        if (!this.accessibilityForceEnabledForTesting) {
            if (this.accessibilityManager.isEnabled() && !(Collection)this.enabledServices.isEmpty()) {
                if (!(Collection)this.enabledServices.isEmpty()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release()) {
        }
        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onSemanticsChange$ui_release() {
        int handler;
        boolean checkingForSemanticsChanges;
        handler = 1;
        this.currentSemanticsNodesInvalidated = handler;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            if (!this.checkingForSemanticsChanges) {
                this.checkingForSemanticsChanges = handler;
                this.handler.post(this.semanticsChangeChecker);
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean value) {
        this.accessibilityForceEnabledForTesting = value;
        this.currentSemanticsNodesInvalidated = true;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void setHoveredVirtualViewId$ui_release(int <set-?>) {
        this.hoveredVirtualViewId = <set-?>;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void setIdToAfterMap$ui_release(MutableIntIntMap <set-?>) {
        this.idToAfterMap = <set-?>;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void setIdToBeforeMap$ui_release(MutableIntIntMap <set-?>) {
        this.idToBeforeMap = <set-?>;
    }

    public final void setOnSendAccessibilityEvent$ui_release(Function1<? super AccessibilityEvent, Boolean> <set-?>) {
        this.onSendAccessibilityEvent = <set-?>;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui_release(long <set-?>) {
        this.SendRecurringAccessibilityEventsIntervalMillis = <set-?>;
    }
}
