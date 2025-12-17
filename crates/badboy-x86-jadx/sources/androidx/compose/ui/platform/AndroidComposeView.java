package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.MutableIntIntMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Companion;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.SessionMutex.Session;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusDirection.Companion;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputMode.Companion;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.Key.Companion;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode.UsageByParent;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.NestedVectorStack;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.Owner.OnLayoutCompletedListener;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009e\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u000b*\u0002¾\u0001\u0008\u0000\u0018\u0000 \u0088\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0088\u0004\u0089\u0004B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0097\u0002\u001a\u0002062\u0008\u0010þ\u0001\u001a\u00030\u0098\u00022\u0008\u0010\u0099\u0002\u001a\u00030Á\u0001J&\u0010\u009a\u0002\u001a\u0002062\u0007\u0010\u009b\u0002\u001a\u00020G2\u0008\u0010\u009c\u0002\u001a\u00030\u009d\u00022\u0008\u0010\u009e\u0002\u001a\u00030\u009f\u0002H\u0002J\u0015\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u0001H\u0016J!\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\n\u0010¢\u0002\u001a\u0005\u0018\u00010£\u0002H\u0016J\u001e\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¤\u0002\u001a\u00020GH\u0016J*\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¤\u0002\u001a\u00020G2\n\u0010¢\u0002\u001a\u0005\u0018\u00010£\u0002H\u0016J'\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¥\u0002\u001a\u00020G2\u0007\u0010¦\u0002\u001a\u00020GH\u0016J\u0019\u0010#\u001a\u0002062\u000f\u0010§\u0002\u001a\n\u0012\u0005\u0012\u00030©\u00020¨\u0002H\u0016J\t\u0010ª\u0002\u001a\u00020mH\u0002J\u0010\u0010«\u0002\u001a\u000206H\u0086@¢\u0006\u0003\u0010¬\u0002J\u0010\u0010­\u0002\u001a\u000206H\u0086@¢\u0006\u0003\u0010¬\u0002J \u0010®\u0002\u001a\u00030\u008b\u00012\u0008\u0010¯\u0002\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008°\u0002\u0010±\u0002J \u0010²\u0002\u001a\u00030\u008b\u00012\u0008\u0010³\u0002\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008´\u0002\u0010±\u0002J\u0012\u0010µ\u0002\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010·\u0002\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010¸\u0002\u001a\u0002062\u0007\u0010¹\u0002\u001a\u00020\u0001H\u0002J\"\u0010º\u0002\u001a\u00030»\u00022\u0007\u0010¼\u0002\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008½\u0002\u0010¾\u0002Jh\u0010¿\u0002\u001a\u00020Q2B\u0010À\u0002\u001a=\u0012\u0017\u0012\u00150Â\u0002¢\u0006\u000f\u0008Ã\u0002\u0012\n\u0008Ä\u0002\u0012\u0005\u0008\u0008(Å\u0002\u0012\u0019\u0012\u0017\u0018\u00010Æ\u0002¢\u0006\u000f\u0008Ã\u0002\u0012\n\u0008Ä\u0002\u0012\u0005\u0008\u0008(Ç\u0002\u0012\u0004\u0012\u0002060Á\u00022\r\u0010È\u0002\u001a\u0008\u0012\u0004\u0012\u0002060Z2\n\u0010É\u0002\u001a\u0005\u0018\u00010Æ\u0002H\u0016J\u0013\u0010Ê\u0002\u001a\u0002062\u0008\u0010Å\u0002\u001a\u00030Ë\u0002H\u0014J\u0013\u0010Ì\u0002\u001a\u00020m2\u0008\u0010Í\u0002\u001a\u00030º\u0001H\u0016J\u0013\u0010Î\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030º\u0001H\u0016J\u0013\u0010Ð\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030Ñ\u0002H\u0016J\u0013\u0010Ò\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030Ñ\u0002H\u0016J\t\u0010Ó\u0002\u001a\u000206H\u0002J\u0013\u0010Ô\u0002\u001a\u0002062\u0008\u0010Õ\u0002\u001a\u00030Ö\u0002H\u0016J\u0013\u0010×\u0002\u001a\u00020m2\u0008\u0010Í\u0002\u001a\u00030º\u0001H\u0016J\u001b\u0010Ø\u0002\u001a\u0002062\u0008\u0010þ\u0001\u001a\u00030\u0098\u00022\u0008\u0010Å\u0002\u001a\u00030Ë\u0002J\u0015\u0010Ù\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¶\u0002\u001a\u00020GH\u0002J\u001f\u0010Ú\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010Û\u0002\u001a\u00020G2\u0008\u0010Ü\u0002\u001a\u00030ÿ\u0001H\u0002J\u0013\u0010Ý\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010Û\u0002\u001a\u00020GJ!\u0010Þ\u0002\u001a\u0005\u0018\u00010ÿ\u00012\n\u0010ß\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010à\u0002\u001a\u0002062\u0007\u0010á\u0002\u001a\u00020mH\u0016J\u001c\u0010â\u0002\u001a\u0002062\u0008\u0010\u0099\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020mH\u0016J\"\u0010ä\u0002\u001a\u0005\u0018\u00010å\u00022\u0008\u0010æ\u0002\u001a\u00030ç\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\u0008è\u0002\u0010é\u0002J\u0013\u0010ê\u0002\u001a\u0002062\u0008\u0010ë\u0002\u001a\u00030ì\u0002H\u0016J#\u0010í\u0002\u001a\u00030î\u00022\u0008\u0010Í\u0002\u001a\u00030º\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008ï\u0002\u0010ð\u0002J\u0013\u0010ñ\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u001d\u0010ò\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030º\u00012\u0008\u0010ó\u0002\u001a\u00030º\u0001H\u0002J\t\u0010ô\u0002\u001a\u000206H\u0016J\u0013\u0010õ\u0002\u001a\u0002062\u0008\u0010ö\u0002\u001a\u00030Á\u0001H\u0002J\u0013\u0010÷\u0002\u001a\u0002062\u0008\u0010ö\u0002\u001a\u00030Á\u0001H\u0002J\u0013\u0010ø\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010ù\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010ú\u0002\u001a\u00020m2\u0008\u0010Í\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010û\u0002\u001a\u00020m2\u0008\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J \u0010ü\u0002\u001a\u00030\u008b\u00012\u0008\u0010³\u0002\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008ý\u0002\u0010±\u0002J\u001f\u0010ü\u0002\u001a\u0002062\u0008\u0010þ\u0002\u001a\u00030ø\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008ÿ\u0002\u0010\u0080\u0003J)\u0010\u0081\u0003\u001a\u0002062\u0008\u0010\u0099\u0002\u001a\u00030Á\u00012\u0008\u0010\u0082\u0003\u001a\u00030¬\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0083\u0003\u0010\u0084\u0003J\u0012\u0010\u0081\u0003\u001a\u0002062\u0007\u0010\u0085\u0003\u001a\u00020mH\u0016J\t\u0010\u0086\u0003\u001a\u000206H\u0016J!\u0010\u0087\u0003\u001a\u0002062\u0007\u0010\u0088\u0003\u001a\u00020Q2\u0007\u0010\u0089\u0003\u001a\u00020mH\u0000¢\u0006\u0003\u0008\u008a\u0003J\u0013\u0010\u008b\u0003\u001a\u0002062\u0008\u0010ö\u0002\u001a\u00030Á\u0001H\u0016J\t\u0010\u008c\u0003\u001a\u000206H\u0014J\t\u0010\u008d\u0003\u001a\u00020mH\u0016J\t\u0010\u008e\u0003\u001a\u000206H\u0002J\u0012\u0010\u008f\u0003\u001a\u0002062\u0007\u0010\u0090\u0003\u001a\u000205H\u0014J\u0016\u0010\u0091\u0003\u001a\u0005\u0018\u00010\u0092\u00032\u0008\u0010\u0093\u0003\u001a\u00030\u0094\u0003H\u0016J0\u0010\u0095\u0003\u001a\u0002062\u0008\u0010\u0096\u0003\u001a\u00030\u0097\u00032\u0008\u0010\u0098\u0003\u001a\u00030û\u00012\u0011\u0010\u0099\u0003\u001a\u000c\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u00030\u009a\u0003H\u0017J\u0013\u0010\u009c\u0003\u001a\u0002062\u0008\u0010ö\u0002\u001a\u00030Á\u0001H\u0016J\t\u0010\u009d\u0003\u001a\u000206H\u0014J\u0013\u0010\u009e\u0003\u001a\u0002062\u0008\u0010Å\u0002\u001a\u00030Ë\u0002H\u0014J\t\u0010\u009f\u0003\u001a\u000206H\u0016J\u000c\u0010 \u0003\u001a\u0005\u0018\u00010¡\u0003H\u0002J'\u0010¢\u0003\u001a\u0002062\u0007\u0010£\u0003\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020G2\n\u0010¤\u0003\u001a\u0005\u0018\u00010ì\u0002H\u0014J\u0018\u0010¥\u0003\u001a\u0002062\r\u0010þ\u0001\u001a\u00080ÿ\u0001j\u0003`¦\u0003H\u0016J6\u0010§\u0003\u001a\u0002062\u0007\u0010¨\u0003\u001a\u00020m2\u0007\u0010©\u0003\u001a\u00020G2\u0007\u0010ª\u0003\u001a\u00020G2\u0007\u0010«\u0003\u001a\u00020G2\u0007\u0010¬\u0003\u001a\u00020GH\u0014J\u0013\u0010­\u0003\u001a\u0002062\u0008\u0010\u0099\u0002\u001a\u00030Á\u0001H\u0016J\u001b\u0010®\u0003\u001a\u0002062\u0007\u0010¯\u0003\u001a\u00020G2\u0007\u0010°\u0003\u001a\u00020GH\u0014J\u001f\u0010±\u0003\u001a\u00020m2\u0008\u0010²\u0003\u001a\u00030å\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\u0008³\u0003\u0010´\u0003J\u001e\u0010µ\u0003\u001a\u0002062\n\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u00022\u0007\u0010¶\u0003\u001a\u00020GH\u0016J*\u0010·\u0003\u001a\u00020m2\n\u0010²\u0003\u001a\u0005\u0018\u00010å\u00022\n\u0010¤\u0003\u001a\u0005\u0018\u00010¡\u0003H\u0002ø\u0001\u0000¢\u0006\u0003\u0008¸\u0003J.\u0010¹\u0003\u001a\u0002062\u0008\u0010\u0099\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020m2\u0007\u0010º\u0003\u001a\u00020m2\u0007\u0010»\u0003\u001a\u00020mH\u0016J%\u0010¼\u0003\u001a\u0002062\u0008\u0010\u0099\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020m2\u0007\u0010º\u0003\u001a\u00020mH\u0016J\u0013\u0010½\u0003\u001a\u0002062\u0008\u0010¾\u0003\u001a\u00030¿\u0003H\u0016J\u0012\u0010À\u0003\u001a\u0002062\u0007\u0010\u0096\u0001\u001a\u00020GH\u0016J.\u0010Á\u0003\u001a\u0002062\u0008\u0010Â\u0003\u001a\u00030ì\u00022\u0008\u0010Ã\u0003\u001a\u00030Ä\u00032\u000f\u0010Å\u0003\u001a\n\u0012\u0005\u0012\u00030Æ\u00030\u009a\u0003H\u0016J\t\u0010Ç\u0003\u001a\u000206H\u0016J\u001c\u0010È\u0003\u001a\u0002062\u0011\u0010É\u0003\u001a\u000c\u0012\u0007\u0012\u0005\u0018\u00010Ë\u00030Ê\u0003H\u0017J\u0012\u0010Ì\u0003\u001a\u0002062\u0007\u0010Í\u0003\u001a\u00020mH\u0016J+\u0010Î\u0003\u001a\u00030»\u00022\u0007\u0010Ï\u0003\u001a\u00020G2\u0007\u0010¬\u0003\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008Ð\u0003\u0010Ñ\u0003J\t\u0010Ò\u0003\u001a\u000206H\u0002J\u0013\u0010Ò\u0003\u001a\u0002062\u0008\u0010Í\u0002\u001a\u00030º\u0001H\u0002J\t\u0010Ó\u0003\u001a\u000206H\u0002J\u0018\u0010Ô\u0003\u001a\u00020m2\u0007\u0010\u0088\u0003\u001a\u00020QH\u0000¢\u0006\u0003\u0008Õ\u0003J\u0018\u0010Ö\u0003\u001a\u0002062\r\u0010×\u0003\u001a\u0008\u0012\u0004\u0012\u0002060ZH\u0016J\u0013\u0010Ø\u0003\u001a\u0002062\u0008\u0010×\u0003\u001a\u00030Ù\u0003H\u0016J\u0011\u0010Ú\u0003\u001a\u0002062\u0008\u0010þ\u0001\u001a\u00030\u0098\u0002J\u0007\u0010Û\u0003\u001a\u000206J\u001e\u0010Ü\u0003\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020G2\n\u0010¤\u0003\u001a\u0005\u0018\u00010ì\u0002H\u0016J\u0013\u0010Ý\u0003\u001a\u0002062\u0008\u0010\u0099\u0002\u001a\u00030Á\u0001H\u0016J\u0017\u0010»\u0003\u001a\u0002062\u000c\u0008\u0002\u0010Þ\u0003\u001a\u0005\u0018\u00010Á\u0001H\u0002J \u0010ß\u0003\u001a\u00030\u008b\u00012\u0008\u0010à\u0003\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008á\u0003\u0010±\u0002J\u001f\u0010â\u0003\u001a\u00020m2\u0008\u0010æ\u0002\u001a\u00030ç\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\u0008ã\u0003\u0010ä\u0003J#\u0010å\u0003\u001a\u00030î\u00022\u0008\u0010Í\u0002\u001a\u00030º\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008æ\u0003\u0010ð\u0002J1\u0010ç\u0003\u001a\u0002062\u0008\u0010Í\u0002\u001a\u00030º\u00012\u0007\u0010è\u0003\u001a\u00020G2\u0008\u0010é\u0003\u001a\u00030\u008d\u00012\t\u0008\u0002\u0010ê\u0003\u001a\u00020mH\u0002J\u0013\u0010ë\u0003\u001a\u0002062\u0008\u0010ì\u0003\u001a\u00030\u008d\u0001H\u0016J\u001c\u0010í\u0003\u001a\u0002062\u0013\u0010î\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020604J\t\u0010ï\u0003\u001a\u00020mH\u0016JE\u0010ð\u0003\u001a\u00020m2\u0008\u0010ñ\u0003\u001a\u00030ò\u00032\u0008\u0010ó\u0003\u001a\u00030ô\u00032\u001a\u0010õ\u0003\u001a\u0015\u0012\u0005\u0012\u00030ö\u0003\u0012\u0004\u0012\u00020604¢\u0006\u0003\u0008÷\u0003H\u0002ø\u0001\u0000¢\u0006\u0006\u0008ø\u0003\u0010ù\u0003JA\u0010ú\u0003\u001a\u00030û\u00032.\u0010ü\u0003\u001a)\u0008\u0001\u0012\u0005\u0012\u00030ý\u0003\u0012\u000c\u0012\n\u0012\u0005\u0012\u00030û\u00030þ\u0003\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u00030Á\u0002¢\u0006\u0003\u0008÷\u0003H\u0096@¢\u0006\u0003\u0010\u0080\u0004J\t\u0010\u0081\u0004\u001a\u000206H\u0002J\u000e\u0010\u0082\u0004\u001a\u00020m*\u00030Á\u0001H\u0002J\u001b\u0010\u0083\u0004\u001a\u00020G*\u00030»\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\u0008\u0084\u0004\u0010\u0085\u0004J\u001b\u0010\u0086\u0004\u001a\u00020G*\u00030»\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\u0008\u0087\u0004\u0010\u0085\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00087\u00108\"\u0004\u00089\u0010:R\u001a\u0010;\u001a\u00020<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R$\u0010\u0008\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010ER\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u00020H2\u0006\u0010\u0011\u001a\u00020H8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008N\u0010\u0019\u001a\u0004\u0008J\u0010K\"\u0004\u0008L\u0010MR\u0014\u0010O\u001a\u0008\u0012\u0004\u0012\u00020Q0PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020SX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010UR\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010Z0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020\\X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008]\u0010^R+\u0010`\u001a\u00020_2\u0006\u0010\u0011\u001a\u00020_8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008e\u0010\u0019\u001a\u0004\u0008a\u0010b\"\u0004\u0008c\u0010dR\u001c\u0010f\u001a\u00020g8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008h\u0010i\u001a\u0004\u0008j\u0010kR\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\u00020qX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0014\u0010s\u001a\u00020tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008u\u0010vR\u0014\u0010w\u001a\u00020xX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008y\u0010zR\u0014\u0010{\u001a\u00020m8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008|\u0010}R\u000e\u0010~\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u007f\u001a\u00030\u0080\u00018VX\u0096\u0004¢\u0006\u0008\u001a\u0006\u0008\u0081\u0001\u0010\u0082\u0001R\u000f\u0010\u0083\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0084\u0001\u001a\u00020m8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\u0008\u0084\u0001\u0010}R\u000f\u0010\u0085\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR+\u0010\u008c\u0001\u001a\u00030\u008d\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\u0008\u008e\u0001\u0010i\u001a\u0006\u0008\u008f\u0001\u0010\u0090\u0001\"\u0006\u0008\u0091\u0001\u0010\u0092\u0001R\u0016\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u0094\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0011\u001a\u00030\u0095\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\u0008\u009b\u0001\u0010\u0019\u001a\u0006\u0008\u0097\u0001\u0010\u0098\u0001\"\u0006\u0008\u0099\u0001\u0010\u009a\u0001R\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u0001\u001a\u00030¡\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¢\u0001\u001a\u00030\u008d\u00018VX\u0096\u0004¢\u0006\u0008\u001a\u0006\u0008£\u0001\u0010\u0090\u0001R\u0018\u0010¤\u0001\u001a\u00030¥\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008¦\u0001\u0010§\u0001R\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001d\u0010­\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010®\u0001\u001a\u00030¯\u00018VX\u0096\u0004¢\u0006\u0008\u001a\u0006\u0008°\u0001\u0010±\u0001R\u0018\u0010²\u0001\u001a\u00030³\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008´\u0001\u0010µ\u0001R\u0010\u0010¶\u0001\u001a\u00030·\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010¸\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010»\u0001\u001a\u00030\u008d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010¼\u0001\u001a\u0008\u0012\u0004\u0012\u0002060ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010½\u0001\u001a\u00030¾\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¿\u0001R\u0018\u0010À\u0001\u001a\u00030Á\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008Â\u0001\u0010Ã\u0001R\u0018\u0010Ä\u0001\u001a\u00030Å\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008Æ\u0001\u0010Ç\u0001R\u0010\u0010È\u0001\u001a\u00030É\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ê\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Í\u0001\u001a\u00020m8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008Î\u0001\u0010}R\u0010\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ñ\u0001\u001a\u00030Ò\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ó\u0001\u001a\u00030Ô\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008Õ\u0001\u0010Ö\u0001R\u0010\u0010×\u0001\u001a\u00030Ø\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ù\u0001\u001a\u00030Ú\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008Û\u0001\u0010Ü\u0001R%\u0010Ý\u0001\u001a\u00020mX\u0096\u000e¢\u0006\u0018\n\u0000\u0012\u0005\u0008Þ\u0001\u0010i\u001a\u0005\u0008ß\u0001\u0010}\"\u0006\u0008à\u0001\u0010á\u0001R\u0018\u0010â\u0001\u001a\u00030ã\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008ä\u0001\u0010å\u0001R\u0018\u0010æ\u0001\u001a\u00030ç\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008è\u0001\u0010é\u0001R\u000f\u0010ê\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ë\u0001\u001a\u00030ì\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008í\u0001\u0010î\u0001R \u0010ï\u0001\u001a\n\u0012\u0005\u0012\u00030ñ\u00010ð\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ò\u0001R\u0018\u0010ó\u0001\u001a\u00030ô\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008õ\u0001\u0010ö\u0001R\u0019\u0010÷\u0001\u001a\u00030ø\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R\u0010\u0010ú\u0001\u001a\u00030û\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ü\u0001\u001a\u00030ý\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010þ\u0001\u001a\u00030ÿ\u00018VX\u0096\u0004¢\u0006\u0008\u001a\u0006\u0008\u0080\u0002\u0010\u0081\u0002R\u0018\u0010\u0082\u0002\u001a\u00030\u0083\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008\u0084\u0002\u0010\u0085\u0002R\u0012\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0088\u0002\u001a\u00030ø\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R!\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\u0008\u008b\u0002\u0010\u008c\u0002\u001a\u0005\u0008\u008a\u0002\u0010\u0015R\u000f\u0010\u008d\u0002\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u008e\u0002\u001a\u00030\u008f\u00028VX\u0096\u0004¢\u0006\u0008\u001a\u0006\u0008\u0090\u0002\u0010\u0091\u0002R\u0018\u0010\u0092\u0002\u001a\u00030\u008b\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0019\u0010\u0093\u0002\u001a\u00030ø\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R\u001b\u0010\u0094\u0002\u001a\u00020G*\u0002058BX\u0082\u0004¢\u0006\u0008\u001a\u0006\u0008\u0095\u0002\u0010\u0096\u0002\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u008a\u0004", d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "value", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isPendingInteropViewLayoutChangeDispatch", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "rotaryInputModifier", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCaptureInProgress", "getScrollCaptureInProgress$ui_release", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesAccessibilityEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesContentCaptureEventLoop", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "invalidateParentLayer", "explicitLayer", "dispatchDraw", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "motionEvent", "dispatchHoverEvent", "event", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchPendingInteropLayoutCallbacks", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "dispatchTouchEvent", "drawAndroidView", "findNextNonChildView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "focusSearch", "focused", "forceAccessibilityForTesting", "enable", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "localTransform", "localToScreen-58bKbWc", "([F)V", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onClearFocusForOwner", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFetchFocusRect", "Landroidx/compose/ui/geometry/Rect;", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onInteropViewLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMoveFocusInChildren", "focusDirection", "onMoveFocusInChildren-3ESFkO8", "(I)Z", "onProvideAutofillVirtualStructure", "flags", "onRequestFocusForOwner", "onRequestFocusForOwner-7o62pno", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Landroid/view/ScrollCaptureTarget;", "onSemanticsChange", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestFocus", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "textInputSession", "", "session", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidComposeView extends ViewGroup implements Owner, androidx.compose.ui.platform.ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {

    public static final int $stable = 8;
    public static final androidx.compose.ui.platform.AndroidComposeView.Companion Companion;
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private androidx.compose.ui.platform.AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill = null;
    private final InputModeManagerImpl _inputModeManager;
    private final MutableState _viewTreeOwners$delegate;
    private final androidx.compose.ui.platform.WindowInfoImpl _windowInfo;
    private final androidx.compose.ui.platform.AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final androidx.compose.ui.platform.AndroidClipboardManager clipboardManager;
    private final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;
    private final MutableState density$delegate;
    private final List<OwnedLayer> dirtyLayers;
    private final DragAndDropManager dragAndDropManager;
    private final androidx.compose.ui.platform.DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;
    private final MutableState fontFamilyResolver$delegate;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible = true;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime = -1;
    private final androidx.compose.ui.platform.WeakCache<OwnedLayer> layerCache;
    private final MutableState layoutDirection$delegate;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final androidx.compose.ui.platform.CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final androidx.compose.ui.platform.AndroidComposeView.resendMotionEventRunnable.1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final EmptySemanticsModifier rootSemanticsNode;
    private final Modifier rotaryInputModifier;
    private final ScrollCapture scrollCapture;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final androidx.compose.ui.platform.SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete = true;
    private final TextInputService textInputService;
    private final AtomicReference<SessionMutex.Session<T>> textInputSessionMutex;
    private final androidx.compose.ui.platform.TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final androidx.compose.ui.platform.ViewConfiguration viewConfiguration;
    private androidx.compose.ui.platform.DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;
    private final State viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final boolean access$getIsShowingLayoutBounds(androidx.compose.ui.platform.AndroidComposeView.Companion $this) {
            return $this.getIsShowingLayoutBounds();
        }

        private final boolean getIsShowingLayoutBounds() {
            int booleanValue;
            Class declaredMethod;
            int invoke;
            int i;
            String arr;
            Class[] valueOf;
            Class tYPE;
            int i2;
            booleanValue = 0;
            i = 0;
            if (AndroidComposeView.access$getSystemPropertiesClass$cp() == null) {
                AndroidComposeView.access$setSystemPropertiesClass$cp(Class.forName("android.os.SystemProperties"));
                Class cls = AndroidComposeView.access$getSystemPropertiesClass$cp();
                if (cls != null) {
                    try {
                        valueOf = new Class[2];
                        valueOf[booleanValue] = String.class;
                        valueOf[1] = Boolean.TYPE;
                        declaredMethod = cls.getDeclaredMethod("getBoolean", valueOf);
                        declaredMethod = i;
                        AndroidComposeView.access$setGetBooleanMethod$cp(declaredMethod);
                        Method method = AndroidComposeView.access$getGetBooleanMethod$cp();
                        if (method != null) {
                        } else {
                        }
                        invoke = method.invoke(i, /* result */);
                        invoke = i;
                        if (invoke instanceof Boolean) {
                        }
                        i = invoke;
                        if (i != 0) {
                        }
                        booleanValue = i.booleanValue();
                        return booleanValue;
                    }
                } else {
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ViewTreeOwners {

        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;
        static {
            final int i = 8;
        }

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            super();
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
    public static void $r8$lambda$4xAewo2xS0F8prtLn-2_aehzBiM(androidx.compose.ui.platform.AndroidComposeView androidComposeView, boolean z2) {
        AndroidComposeView.touchModeChangeListener$lambda$6(androidComposeView, z2);
    }

    public static void $r8$lambda$FBV0JS_objw2nHVZq2Ihi36_bec(androidx.compose.ui.platform.AndroidComposeView androidComposeView) {
        AndroidComposeView.sendHoverExitEvent$lambda$8(androidComposeView);
    }

    public static void $r8$lambda$anwi6KZVel1ywLqe205EWVcD-js(androidx.compose.ui.platform.AndroidComposeView androidComposeView) {
        AndroidComposeView.scrollChangedListener$lambda$5(androidComposeView);
    }

    public static void $r8$lambda$iCc8VFD3-LI1S3c-DXxniqLvvJA(androidx.compose.ui.platform.AndroidComposeView androidComposeView) {
        AndroidComposeView.globalLayoutListener$lambda$4(androidComposeView);
    }

    static {
        AndroidComposeView.Companion companion = new AndroidComposeView.Companion(0);
        AndroidComposeView.Companion = companion;
        int i = 8;
    }

    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        int scrollCapture;
        LayoutDirection layoutDirection;
        int keyboard-aOaMEAU;
        super(context);
        this.lastDownPointerPosition = Offset.Companion.getUnspecified-F1C5BW0();
        int i = 1;
        scrollCapture = 0;
        LayoutNodeDrawScope layoutNodeDrawScope = new LayoutNodeDrawScope(scrollCapture, i, scrollCapture);
        this.sharedDrawScope = layoutNodeDrawScope;
        this.density$delegate = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.rootSemanticsNode = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(this.rootSemanticsNode);
        this.semanticsModifier = emptySemanticsElement;
        AndroidComposeView.focusOwner.1 anon2 = new AndroidComposeView.focusOwner.1(this);
        AndroidComposeView.focusOwner.2 anon3 = new AndroidComposeView.focusOwner.2(this);
        AndroidComposeView.focusOwner.3 anon4 = new AndroidComposeView.focusOwner.3(this);
        AndroidComposeView.focusOwner.4 anon5 = new AndroidComposeView.focusOwner.4(this);
        AndroidComposeView.focusOwner.5 anon6 = new AndroidComposeView.focusOwner.5(this);
        AndroidComposeView.focusOwner.6 anon7 = new AndroidComposeView.focusOwner.6(this);
        FocusOwnerImpl focusOwnerImpl = new FocusOwnerImpl((Function1)anon2, (Function2)anon3, (Function1)anon4, (Function0)anon5, (Function0)anon6, (Function0)anon7);
        this.focusOwner = (FocusOwner)focusOwnerImpl;
        AndroidComposeView.dragAndDropModifierOnDragListener.1 anon10 = new AndroidComposeView.dragAndDropModifierOnDragListener.1(this);
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener2 = new DragAndDropModifierOnDragListener((Function3)anon10);
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener2;
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = (DragAndDropManager)this.dragAndDropModifierOnDragListener;
        WindowInfoImpl windowInfoImpl = new WindowInfoImpl();
        this._windowInfo = windowInfoImpl;
        AndroidComposeView.keyInputModifier.1 anon11 = new AndroidComposeView.keyInputModifier.1(this);
        this.keyInputModifier = KeyInputModifierKt.onKeyEvent((Modifier)Modifier.Companion, (Function1)anon11);
        this.rotaryInputModifier = RotaryInputModifierKt.onRotaryScrollEvent((Modifier)Modifier.Companion, (Function1)AndroidComposeView.rotaryInputModifier.1.INSTANCE);
        CanvasHolder canvasHolder = new CanvasHolder();
        this.canvasHolder = canvasHolder;
        int i9 = 0;
        LayoutNode layoutNode = new LayoutNode(i9, i9, 3, scrollCapture);
        LayoutNode layoutNode2 = layoutNode;
        int i10 = 0;
        layoutNode2.setMeasurePolicy((MeasurePolicy)RootMeasurePolicy.INSTANCE);
        layoutNode2.setDensity(getDensity());
        layoutNode2.setModifier(Modifier.Companion.then((Modifier)this.semanticsModifier).then(this.rotaryInputModifier).then(this.keyInputModifier).then(getFocusOwner().getModifier()).then(this.dragAndDropModifierOnDragListener.getModifier()));
        this.root = layoutNode;
        this.rootForTest = (RootForTest)this;
        SemanticsOwner semanticsOwner = new SemanticsOwner(getRoot(), this.rootSemanticsNode);
        this.semanticsOwner = semanticsOwner;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        AndroidComposeView.contentCaptureManager.1 anon12 = new AndroidComposeView.contentCaptureManager.1(this);
        AndroidContentCaptureManager androidContentCaptureManager = new AndroidContentCaptureManager(this, (Function0)anon12);
        this.contentCaptureManager = androidContentCaptureManager;
        AndroidAccessibilityManager androidAccessibilityManager = new AndroidAccessibilityManager(context);
        this.accessibilityManager = androidAccessibilityManager;
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext((ViewGroup)this);
        AutofillTree autofillTree = new AutofillTree();
        this.autofillTree = autofillTree;
        ArrayList arrayList = new ArrayList();
        this.dirtyLayers = (List)arrayList;
        MotionEventAdapter motionEventAdapter = new MotionEventAdapter();
        this.motionEventAdapter = motionEventAdapter;
        PointerInputEventProcessor pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.pointerInputEventProcessor = pointerInputEventProcessor;
        this.configurationChangeObserver = (Function1)AndroidComposeView.configurationChangeObserver.1.INSTANCE;
        if (autofillSupported()) {
            AndroidAutofill androidAutofill = new AndroidAutofill((View)this, getAutofillTree());
        }
        int i2 = scrollCapture;
        AndroidClipboardManager androidClipboardManager = new AndroidClipboardManager(context);
        this.clipboardManager = androidClipboardManager;
        AndroidComposeView.snapshotObserver.1 anon13 = new AndroidComposeView.snapshotObserver.1(this);
        OwnerSnapshotObserver ownerSnapshotObserver = new OwnerSnapshotObserver((Function1)anon13);
        this.snapshotObserver = ownerSnapshotObserver;
        MeasureAndLayoutDelegate measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.measureAndLayoutDelegate = measureAndLayoutDelegate;
        AndroidViewConfiguration androidViewConfiguration = new AndroidViewConfiguration(ViewConfiguration.get(context));
        this.viewConfiguration = (ViewConfiguration)androidViewConfiguration;
        int i3 = Integer.MAX_VALUE;
        this.globalPosition = IntOffsetKt.IntOffset(i3, i3);
        this.tmpPositionArray = /* result */;
        this.tmpMatrix = Matrix.constructor-impl$default(scrollCapture, i, scrollCapture);
        this.viewToWindowMatrix = Matrix.constructor-impl$default(scrollCapture, i, scrollCapture);
        this.windowToViewMatrix = Matrix.constructor-impl$default(scrollCapture, i, scrollCapture);
        int i11 = -1;
        this.windowPosition = Offset.Companion.getInfinite-F1C5BW0();
        int i4 = 2;
        this._viewTreeOwners$delegate = SnapshotStateKt.mutableStateOf$default(scrollCapture, scrollCapture, i4, scrollCapture);
        AndroidComposeView.viewTreeOwners.2 anon14 = new AndroidComposeView.viewTreeOwners.2(this);
        this.viewTreeOwners$delegate = SnapshotStateKt.derivedStateOf((Function0)anon14);
        AndroidComposeView$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new AndroidComposeView$$ExternalSyntheticLambda0(this);
        this.globalLayoutListener = externalSyntheticLambda0;
        AndroidComposeView$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new AndroidComposeView$$ExternalSyntheticLambda1(this);
        this.scrollChangedListener = externalSyntheticLambda1;
        AndroidComposeView$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new AndroidComposeView$$ExternalSyntheticLambda2(this);
        this.touchModeChangeListener = externalSyntheticLambda2;
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), (PositionCalculator)this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        TextInputService textInputService = new TextInputService((PlatformTextInputService)AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(this.legacyTextInputServiceAndroid));
        this.textInputService = textInputService;
        this.textInputSessionMutex = SessionMutex.constructor-impl();
        DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.softwareKeyboardController = (SoftwareKeyboardController)delegatingSoftwareKeyboardController;
        AndroidFontResourceLoader androidFontResourceLoader = new AndroidFontResourceLoader(context);
        this.fontLoader = (Font.ResourceLoader)androidFontResourceLoader;
        this.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection()) == null ? LayoutDirection.Ltr : layoutDirection;
        this.layoutDirection$delegate = SnapshotStateKt.mutableStateOf$default(layoutDirection, scrollCapture, i4, scrollCapture);
        PlatformHapticFeedback platformHapticFeedback = new PlatformHapticFeedback((View)this);
        this.hapticFeedBack = (HapticFeedback)platformHapticFeedback;
        if (isInTouchMode()) {
            keyboard-aOaMEAU = InputMode.Companion.getTouch-aOaMEAU();
        } else {
            keyboard-aOaMEAU = InputMode.Companion.getKeyboard-aOaMEAU();
        }
        AndroidComposeView._inputModeManager.1 anon15 = new AndroidComposeView._inputModeManager.1(this);
        InputModeManagerImpl inputModeManagerImpl = new InputModeManagerImpl(keyboard-aOaMEAU, (Function1)anon15, scrollCapture);
        this._inputModeManager = inputModeManagerImpl;
        ModifierLocalManager modifierLocalManager = new ModifierLocalManager((Owner)this);
        this.modifierLocalManager = modifierLocalManager;
        AndroidTextToolbar androidTextToolbar = new AndroidTextToolbar((View)this);
        this.textToolbar = (TextToolbar)androidTextToolbar;
        WeakCache weakCache = new WeakCache();
        this.layerCache = weakCache;
        int i5 = 0;
        int i12 = 0;
        MutableVector mutableVector = new MutableVector(new Function0[16], i9);
        this.endApplyChangesListeners = mutableVector;
        AndroidComposeView.resendMotionEventRunnable.1 anon8 = new AndroidComposeView.resendMotionEventRunnable.1(this);
        this.resendMotionEventRunnable = anon8;
        AndroidComposeView$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new AndroidComposeView$$ExternalSyntheticLambda3(this);
        this.sendHoverExitEvent = externalSyntheticLambda3;
        AndroidComposeView.resendMotionEventOnLayout.1 anon9 = new AndroidComposeView.resendMotionEventOnLayout.1(this);
        this.resendMotionEventOnLayout = (Function0)anon9;
        CalculateMatrixToWindowApi29 calculateMatrixToWindowApi29 = new CalculateMatrixToWindowApi29();
        this.matrixToWindow = (CalculateMatrixToWindow)calculateMatrixToWindowApi29;
        addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.contentCaptureManager);
        setWillNotDraw(i9);
        setFocusable(i);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable((View)this, i, i9);
        setFocusableInTouchMode(i);
        setClipChildren(i9);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)this.composeAccessibilityDelegate);
        Function1 onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener((View.OnDragListener)this.dragAndDropModifierOnDragListener);
        getRoot().attach$ui_release((Owner)this);
        AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark((View)this);
        if (Build.VERSION.SDK_INT >= 31) {
            scrollCapture = new ScrollCapture();
        }
        this.scrollCapture = scrollCapture;
        AndroidComposeView.pointerIconService.1 anon = new AndroidComposeView.pointerIconService.1(this);
        this.pointerIconService = (PointerIconService)anon;
    }

    public static final void access$addExtraDataToAccessibilityNodeInfoHelper(androidx.compose.ui.platform.AndroidComposeView $this, int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        $this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey);
    }

    public static final boolean access$dispatchKeyEvent$s408734394(androidx.compose.ui.platform.AndroidComposeView $this, KeyEvent p0) {
        return super.dispatchKeyEvent(p0);
    }

    public static final View access$findNextNonChildView(androidx.compose.ui.platform.AndroidComposeView $this, int direction) {
        return $this.findNextNonChildView(direction);
    }

    public static final androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat access$getComposeAccessibilityDelegate$p(androidx.compose.ui.platform.AndroidComposeView $this) {
        return $this.composeAccessibilityDelegate;
    }

    public static final Method access$getGetBooleanMethod$cp() {
        return AndroidComposeView.getBooleanMethod;
    }

    public static final MotionEvent access$getPreviousMotionEvent$p(androidx.compose.ui.platform.AndroidComposeView $this) {
        return $this.previousMotionEvent;
    }

    public static final long access$getRelayoutTime$p(androidx.compose.ui.platform.AndroidComposeView $this) {
        return $this.relayoutTime;
    }

    public static final androidx.compose.ui.platform.AndroidComposeView.resendMotionEventRunnable.1 access$getResendMotionEventRunnable$p(androidx.compose.ui.platform.AndroidComposeView $this) {
        return $this.resendMotionEventRunnable;
    }

    public static final Class access$getSystemPropertiesClass$cp() {
        return AndroidComposeView.systemPropertiesClass;
    }

    public static final androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners access$get_viewTreeOwners(androidx.compose.ui.platform.AndroidComposeView $this) {
        return $this.get_viewTreeOwners();
    }

    public static final void access$onClearFocusForOwner(androidx.compose.ui.platform.AndroidComposeView $this) {
        $this.onClearFocusForOwner();
    }

    public static final Rect access$onFetchFocusRect(androidx.compose.ui.platform.AndroidComposeView $this) {
        return $this.onFetchFocusRect();
    }

    public static final boolean access$onMoveFocusInChildren-3ESFkO8(androidx.compose.ui.platform.AndroidComposeView $this, int focusDirection) {
        return $this.onMoveFocusInChildren-3ESFkO8(focusDirection);
    }

    public static final boolean access$onRequestFocusForOwner-7o62pno(androidx.compose.ui.platform.AndroidComposeView $this, FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return $this.onRequestFocusForOwner-7o62pno(focusDirection, previouslyFocusedRect);
    }

    public static final void access$sendSimulatedEvent(androidx.compose.ui.platform.AndroidComposeView $this, MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        $this.sendSimulatedEvent(motionEvent, action, eventTime, forceHover);
    }

    public static final void access$setGetBooleanMethod$cp(Method <set-?>) {
        AndroidComposeView.getBooleanMethod = <set-?>;
    }

    public static final void access$setLayoutDirection(androidx.compose.ui.platform.AndroidComposeView $this, LayoutDirection <set-?>) {
        $this.setLayoutDirection(<set-?>);
    }

    public static final void access$setRelayoutTime$p(androidx.compose.ui.platform.AndroidComposeView $this, long <set-?>) {
        $this.relayoutTime = <set-?>;
    }

    public static final void access$setSystemPropertiesClass$cp(Class <set-?>) {
        AndroidComposeView.systemPropertiesClass = <set-?>;
    }

    public static final boolean access$startDrag-12SF9DM(androidx.compose.ui.platform.AndroidComposeView $this, DragAndDropTransferData transferData, long decorationSize, Function1 drawDragDecoration) {
        return $this.startDrag-12SF9DM(transferData, decorationSize, drawDragDecoration);
    }

    private final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        boolean orDefault;
        int extras;
        int i;
        extras = -1;
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal$ui_release())) {
            orDefault = this.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().getOrDefault(virtualViewId, extras);
            i = 0;
            if (orDefault != extras) {
                info.getExtras().putInt(extraDataKey, orDefault);
            }
        } else {
            orDefault = this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().getOrDefault(virtualViewId, extras);
            i = 0;
            if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal$ui_release()) && orDefault != extras) {
                orDefault = this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().getOrDefault(virtualViewId, extras);
                i = 0;
                if (orDefault != extras) {
                    info.getExtras().putInt(extraDataKey, orDefault);
                }
            }
        }
    }

    private final boolean autofillSupported() {
        return 1;
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode $this$childSizeCanAffectParentSize) {
        int wasMeasuredWithMultipleConstraints;
        LayoutNode hasFixedInnerContentConstraints$ui_release;
        int i2;
        int i;
        if (!this.wasMeasuredWithMultipleConstraints) {
            hasFixedInnerContentConstraints$ui_release = $this$childSizeCanAffectParentSize.getParent$ui_release();
            i = 0;
            if (hasFixedInnerContentConstraints$ui_release != null && !hasFixedInnerContentConstraints$ui_release.getHasFixedInnerContentConstraints$ui_release()) {
                wasMeasuredWithMultipleConstraints = !hasFixedInnerContentConstraints$ui_release.getHasFixedInnerContentConstraints$ui_release() ? i2 : i;
            } else {
            }
            if (wasMeasuredWithMultipleConstraints != 0) {
            } else {
                i2 = i;
            }
        } else {
        }
        return i2;
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int i;
        View childAt;
        View view;
        i = 0;
        while (i < viewGroup.getChildCount()) {
            childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView != null) {
            } else {
            }
            if (childAt instanceof ViewGroup) {
            }
            i++;
            clearChildInvalidObservations((ViewGroup)childAt);
            (AndroidComposeView)childAt.onEndApplyChanges();
        }
    }

    private final int component1-VKZWuLQ(long $this$component1_u2dVKZWuLQ) {
        final int i = 0;
        return (int)constructor-impl;
    }

    private final int component2-VKZWuLQ(long $this$component2_u2dVKZWuLQ) {
        final int i = 0;
        return (int)constructor-impl;
    }

    private final long convertMeasureSpec-I7RO_PI(int measureSpec) {
        long pack-ZIaKswc;
        int i;
        final int size = View.MeasureSpec.getSize(measureSpec);
        int i2 = 0;
        switch (mode2) {
            case -2147483648:
                pack-ZIaKswc = pack-ZIaKswc(i2, size);
                break;
            case 0:
                pack-ZIaKswc = pack-ZIaKswc(i2, Integer.MAX_VALUE);
                break;
            case 1073741824:
                pack-ZIaKswc = pack-ZIaKswc(size, size);
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
        }
        return pack-ZIaKswc;
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        boolean isPendingInteropViewLayoutChangeDispatch;
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    private final View findNextNonChildView(int direction) {
        View currentView;
        View nextFocus;
        View rootView;
        String str;
        currentView = this;
        while (currentView != null) {
            rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            currentView = nextFocus;
        }
        return null;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) {
        return null;
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(...))
    public static void getFontLoader$annotations() {
    }

    private final int getFontWeightAdjustmentCompat(Configuration $this$fontWeightAdjustmentCompat) {
        int fontWeightAdjustment;
        fontWeightAdjustment = Build.VERSION.SDK_INT >= 31 ? $this$fontWeightAdjustmentCompat.fontWeightAdjustment : 0;
        return fontWeightAdjustment;
    }

    public static void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static void getShowLayoutBounds$annotations() {
    }

    private final androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners get_viewTreeOwners() {
        final int i = 0;
        final int i2 = 0;
        return (AndroidComposeView.ViewTreeOwners)(State)this._viewTreeOwners$delegate.getValue();
    }

    private static final void globalLayoutListener$lambda$4(androidx.compose.ui.platform.AndroidComposeView this$0) {
        this$0.updatePositionCacheAndDispatch();
    }

    private final int handleMotionEvent-8iAsVTc(MotionEvent motionEvent) {
        int i9;
        int pointerId;
        Object obj2;
        int i8;
        Object obj;
        MotionEvent previousMotionEvent2;
        int previousMotionEvent;
        int i7;
        int i3;
        int toolType;
        int pointerInputEventProcessor;
        long l;
        int i4;
        int i6;
        int eventTime;
        int i2;
        int i5;
        int pointerInputEventProcessor2;
        MotionEvent lastEvent;
        int i;
        long eventTime2;
        Object obj3 = this;
        MotionEvent motionEvent2 = motionEvent;
        obj3.removeCallbacks((Runnable)obj3.resendMotionEventRunnable);
        final int i14 = 0;
        recalculateWindowPosition(motionEvent);
        int i10 = 1;
        obj3.forceUseMatrixCache = i10;
        obj3.measureAndLayout(i14);
        final int i15 = 0;
        Trace.beginSection("AndroidOwner:onTouch");
        final int i16 = 0;
        final int i17 = actionMasked;
        previousMotionEvent2 = obj3.previousMotionEvent;
        pointerInputEventProcessor2 = 3;
        if (previousMotionEvent2 != null && previousMotionEvent2.getToolType(i14) == pointerInputEventProcessor2) {
            i7 = previousMotionEvent2.getToolType(i14) == pointerInputEventProcessor2 ? i10 : i14;
        } else {
        }
        final int i18 = i7;
        i3 = 10;
        if (previousMotionEvent2 != null) {
            if (obj3.hasChangedDevices(motionEvent2, previousMotionEvent2)) {
                if (obj3.isDevicePressEvent(previousMotionEvent2)) {
                    obj3.pointerInputEventProcessor.processCancel();
                    lastEvent = previousMotionEvent2;
                    i9 = i3;
                } else {
                    if (previousMotionEvent2.getActionMasked() != i3 && i18 != 0) {
                        if (i18 != 0) {
                            i9 = i19;
                            AndroidComposeView.sendSimulatedEvent$default(obj3, previousMotionEvent2, 10, previousMotionEvent2.getEventTime(), obj5, 0, 8);
                            lastEvent = previousMotionEvent2;
                        } else {
                            lastEvent = previousMotionEvent2;
                            i9 = i3;
                        }
                    } else {
                    }
                }
            } else {
                lastEvent = previousMotionEvent2;
                i9 = i3;
            }
        } else {
            try {
                lastEvent = previousMotionEvent2;
                i9 = i3;
                if (motionEvent2.getToolType(i14) == pointerInputEventProcessor2) {
                } else {
                }
                i8 = 1;
                i8 = i14;
                int i11 = 9;
                if (i18 == 0) {
                } else {
                }
                if (i8 != 0) {
                } else {
                }
                if (i17 != pointerInputEventProcessor2) {
                } else {
                }
                if (i17 != i11) {
                } else {
                }
                if (isInBounds(motionEvent)) {
                } else {
                }
                i5 = i11;
                AndroidComposeView.sendSimulatedEvent$default(this, motionEvent2, 9, motionEvent2.getEventTime(), obj5, 0, 8);
                i5 = i11;
                obj = this;
                i5 = i11;
                obj = this;
                i5 = i11;
                obj = this;
                i5 = i11;
                obj = this;
                i5 = i11;
                obj = this;
            } catch (Throwable th) {
            }
            lastEvent.recycle();
            previousMotionEvent = obj.previousMotionEvent;
            if (previousMotionEvent != null && previousMotionEvent.getAction() == i9) {
                try {
                    if (previousMotionEvent.getAction() == i9) {
                    } else {
                    }
                    pointerId = 1;
                    pointerId = i14;
                    MotionEvent previousMotionEvent3 = obj.previousMotionEvent;
                    if (previousMotionEvent3 != null) {
                    } else {
                    }
                    pointerId = previousMotionEvent3.getPointerId(i14);
                    pointerId = -1;
                    if (pointerId >= 0) {
                    }
                    obj.motionEventAdapter.endStream(pointerId);
                    MotionEvent previousMotionEvent4 = obj.previousMotionEvent;
                }
                obj.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int sendMotionEvent-8iAsVTc = sendMotionEvent-8iAsVTc(motionEvent);
                Trace.endSection();
                obj.forceUseMatrixCache = i14;
                int i12 = sendMotionEvent-8iAsVTc;
                return sendMotionEvent-8iAsVTc;
            } else {
            }
        }
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        ViewConfiguration view = ViewConfiguration.get(getContext());
        int i2 = -axisValue;
        RotaryScrollEvent rotaryScrollEvent = new RotaryScrollEvent(scaledVerticalScrollFactor *= i2, scaledHorizontalScrollFactor *= i2, event.getEventTime(), obj6, event.getDeviceId());
        return getFocusOwner().dispatchRotaryEvent(rotaryScrollEvent);
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        int source;
        int toolType2;
        int toolType;
        if (lastEvent.getSource() == event.getSource()) {
            source = 0;
            if (lastEvent.getToolType(source) != event.getToolType(source)) {
                source = 1;
            }
        } else {
        }
        return source;
    }

    private final void invalidateLayers(LayoutNode node) {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        node.invalidateLayers$ui_release();
        final int i2 = 0;
        final MutableVector mutableVector = node.get_children$ui_release();
        final int i3 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            i = 0;
            invalidateLayers((LayoutNode)mutableVector.getContent()[i$iv$iv]);
            while (i$iv$iv++ >= size) {
                i = 0;
                invalidateLayers((LayoutNode)content[i$iv$iv]);
            }
        }
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, 0);
        int i3 = 0;
        MutableVector mutableVector = node.get_children$ui_release();
        int i6 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            i = 0;
            invalidateLayoutNodeMeasurement((LayoutNode)mutableVector.getContent()[i$iv$iv]);
            while (i$iv$iv++ >= size) {
                i = 0;
                invalidateLayoutNodeMeasurement((LayoutNode)content[i$iv$iv]);
            }
        }
    }

    private final boolean isBadMotionEvent(MotionEvent event) {
        float naN3;
        int i;
        float rawY;
        float rawX;
        float naN2;
        int eventInvalid;
        boolean index;
        int pointerCount;
        int i2;
        int validMotionEvent;
        float naN;
        float naN4;
        boolean infinite;
        naN3 = event.getX();
        final int i3 = 0;
        final int i4 = 1;
        if (!Float.isInfinite(naN3) && !Float.isNaN(naN3)) {
            i = !Float.isNaN(naN3) ? i4 : i3;
        } else {
        }
        if (i != 0) {
            naN2 = event.getY();
            if (!Float.isInfinite(naN2) && !Float.isNaN(naN2)) {
                i = !Float.isNaN(naN2) ? i4 : i3;
            } else {
            }
            if (i != 0) {
                rawX = event.getRawX();
                if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
                    i = !Float.isNaN(rawX) ? i4 : i3;
                } else {
                }
                if (i != 0) {
                    rawY = event.getRawY();
                    if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                        i = !Float.isNaN(rawY) ? i4 : i3;
                    } else {
                    }
                    if (i == 0) {
                        eventInvalid = i4;
                    } else {
                        eventInvalid = i3;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (eventInvalid == 0) {
            index = 1;
            while (index < event.getPointerCount()) {
                naN4 = event.getX(index);
                if (!Float.isInfinite(naN4) && !Float.isNaN(naN4)) {
                } else {
                }
                validMotionEvent = i3;
                if (validMotionEvent != 0) {
                } else {
                }
                i2 = i4;
                if (i2 == 0) {
                }
                index++;
                naN = event.getY(index);
                if (!Float.isInfinite(naN) && !Float.isNaN(naN)) {
                } else {
                }
                validMotionEvent = i3;
                if (validMotionEvent != 0) {
                } else {
                }
                if (!MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(event, index)) {
                } else {
                }
                i2 = i3;
                if (!Float.isNaN(naN)) {
                } else {
                }
                validMotionEvent = i4;
                if (!Float.isNaN(naN4)) {
                } else {
                }
                validMotionEvent = i4;
            }
        }
        return eventInvalid;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        int i;
        if (event.getButtonState() != 0) {
            return 1;
        }
        if (/* condition */) {
        } else {
            i = 0;
        }
        return i;
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        int i;
        int cmp;
        int cmp2;
        int i2;
        int i3;
        final float f = motionEvent.getX();
        final float f2 = motionEvent.getY();
        i = 0;
        i3 = 1;
        final int i4 = 0;
        if (Float.compare(i, f) <= 0 && Float.compare(f, f4) <= 0) {
            i2 = Float.compare(f, f4) <= 0 ? i3 : i4;
        } else {
        }
        if (i2 != 0) {
            if (Float.compare(i, f2) <= 0 && Float.compare(f2, f3) <= 0) {
                i = Float.compare(f2, f3) <= 0 ? i3 : i4;
            } else {
            }
            if (i != 0) {
            } else {
                i3 = i4;
            }
        } else {
        }
        return i3;
    }

    private final boolean isPositionChanged(MotionEvent event) {
        int i;
        int pointerCount2;
        int pointerCount;
        float rawY;
        i = 1;
        if (event.getPointerCount() != i) {
            return i;
        }
        MotionEvent previousMotionEvent = this.previousMotionEvent;
        if (previousMotionEvent != null && previousMotionEvent.getPointerCount() == event.getPointerCount()) {
            if (previousMotionEvent.getPointerCount() == event.getPointerCount()) {
                pointerCount = 0;
                pointerCount2 = Float.compare(rawX, rawX2) == 0 ? i : pointerCount;
                if (pointerCount2 != 0) {
                    pointerCount2 = Float.compare(rawY2, rawY) == 0 ? i : pointerCount;
                    if (pointerCount2 == 0) {
                    } else {
                        i = pointerCount;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final void onClearFocusForOwner() {
        boolean focused;
        if (!isFocused()) {
            if (hasFocus()) {
                super.clearFocus();
            }
        } else {
        }
    }

    private final Rect onFetchFocusRect() {
        Rect boundingRect;
        if (isFocused()) {
            boundingRect = getFocusOwner().getFocusRect();
        } else {
            View focus = findFocus();
            if (focus != null) {
                boundingRect = FocusInteropUtils_androidKt.calculateBoundingRect(focus);
            } else {
                boundingRect = 0;
            }
        }
        return boundingRect;
    }

    private final boolean onMoveFocusInChildren-3ESFkO8(int focusDirection) {
        boolean equals-impl0;
        int requestInteropFocus;
        int androidRect;
        View nextFocusFromRect;
        View focus;
        if (!FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getEnter-dhqQ-8s())) {
            if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getExit-dhqQ-8s())) {
            } else {
                Integer androidFocusDirection-3ESFkO8 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(focusDirection);
                if (androidFocusDirection-3ESFkO8 == null) {
                } else {
                    int intValue = (Number)androidFocusDirection-3ESFkO8.intValue();
                    Rect onFetchFocusRect = onFetchFocusRect();
                    if (onFetchFocusRect != null) {
                        androidRect = RectHelper_androidKt.toAndroidRect(onFetchFocusRect);
                    } else {
                        androidRect = 0;
                    }
                    final FocusFinder instance = FocusFinder.getInstance();
                    final int i = 0;
                    if (androidRect == 0) {
                        nextFocusFromRect = instance.findNextFocus((ViewGroup)this, findFocus(), intValue);
                    } else {
                        nextFocusFromRect = instance.findNextFocusFromRect((ViewGroup)this, androidRect, intValue);
                    }
                    if (nextFocusFromRect != null) {
                        requestInteropFocus = FocusInteropUtils_androidKt.requestInteropFocus(nextFocusFromRect, Integer.valueOf(intValue), androidRect);
                    }
                    return requestInteropFocus;
                }
            }
            int direction = 0;
            IllegalStateException $i$a$CheckNotNullAndroidComposeView$onMoveFocusInChildren$direction$1 = new IllegalStateException("Invalid focus direction".toString());
            throw $i$a$CheckNotNullAndroidComposeView$onMoveFocusInChildren$direction$1;
        }
        return 0;
    }

    private final boolean onRequestFocusForOwner-7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        boolean focused;
        int intValue;
        int androidRect;
        if (!isFocused()) {
            if (hasFocus()) {
            } else {
                focused = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(focusDirection.unbox-impl());
                if (focusDirection != null && focused != null) {
                    focused = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(focusDirection.unbox-impl());
                    if (focused != null) {
                        intValue = focused.intValue();
                    } else {
                        intValue = 130;
                    }
                } else {
                }
                if (previouslyFocusedRect != null) {
                    androidRect = RectHelper_androidKt.toAndroidRect(previouslyFocusedRect);
                } else {
                    androidRect = 0;
                }
            }
            return super.requestFocus(intValue, androidRect);
        }
        return 1;
    }

    private final long pack-ZIaKswc(int a, int b) {
        return ULong.constructor-impl(constructor-impl2 |= constructor-impl4);
    }

    private final void recalculateWindowPosition() {
        boolean currentAnimationTimeMillis;
        ViewParent viewParent;
        Object view;
        Object obj;
        float f3;
        float f;
        float f2;
        long l;
        int i;
        currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!this.forceUseMatrixCache && Long.compare(currentAnimationTimeMillis, lastMatrixRecalculationAnimationTime) != 0) {
            currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (Long.compare(currentAnimationTimeMillis, lastMatrixRecalculationAnimationTime) != 0) {
                this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
                recalculateWindowViewTransforms();
                viewParent = getParent();
                view = this;
                while (viewParent instanceof ViewGroup) {
                    viewParent = (ViewGroup)(View)viewParent.getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                int i3 = 0;
                int i6 = 1;
                view.getLocationInWindow(this.tmpPositionArray);
                this.windowPosition = OffsetKt.Offset(obj - f3, f - f2);
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        float f2 = motionEvent.getY();
        long l = OffsetKt.Offset(motionEvent.getX(), f2);
        long map-MK-Hz9U = Matrix.map-MK-Hz9U(this.viewToWindowMatrix, l);
        this.windowPosition = OffsetKt.Offset(rawX -= x-impl, rawY -= y-impl);
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.calculateMatrixToWindow-EL8BTi8((View)this, this.viewToWindowMatrix);
        InvertMatrixKt.invertTo-JiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        LayoutNode node;
        boolean measuredByParent$ui_release;
        LayoutNode.UsageByParent inMeasureBlock;
        if (!isLayoutRequested() && isAttachedToWindow() && nodeToRemeasure != null) {
            if (isAttachedToWindow()) {
                if (nodeToRemeasure != null) {
                    node = nodeToRemeasure;
                    while (node != null) {
                        if (node.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        }
                        if (childSizeCanAffectParentSize(node)) {
                        }
                        node = node.getParent$ui_release();
                    }
                    if (node == getRoot()) {
                        requestLayout();
                    }
                }
                if (getWidth() != 0) {
                    if (getHeight() == 0) {
                        requestLayout();
                    } else {
                        invalidate();
                    }
                } else {
                }
            }
        }
    }

    static void scheduleMeasureAndLayout$default(androidx.compose.ui.platform.AndroidComposeView androidComposeView, LayoutNode layoutNode2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        androidComposeView.scheduleMeasureAndLayout(obj1);
    }

    private static final void scrollChangedListener$lambda$5(androidx.compose.ui.platform.AndroidComposeView this$0) {
        this$0.updatePositionCacheAndDispatch();
    }

    private static final void sendHoverExitEvent$lambda$8(androidx.compose.ui.platform.AndroidComposeView this$0) {
        int i;
        this$0.hoverExitReceived = false;
        final MotionEvent previousMotionEvent = this$0.previousMotionEvent;
        Intrinsics.checkNotNull(previousMotionEvent);
        if (previousMotionEvent.getActionMasked() == 10) {
            i = 1;
        }
        if (i == 0) {
        } else {
            this$0.sendMotionEvent-8iAsVTc(previousMotionEvent);
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckAndroidComposeView$sendHoverExitEvent$1$1 = new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        throw $i$a$CheckAndroidComposeView$sendHoverExitEvent$1$1;
    }

    private final int sendMotionEvent-8iAsVTc(MotionEvent motionEvent) {
        boolean keyboardModifiersRequireUpdate;
        List pointers;
        int process-BIzXfog;
        int constructor-impl;
        int pointerInputEventProcessor;
        int i;
        int dispatchedToAPointerInputModifier-impl;
        int pointerId;
        Object obj;
        boolean it;
        int i2;
        int i3 = 0;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = i3;
            this._windowInfo.setKeyboardModifiers-5xRPYO0(PointerKeyboardModifiers.constructor-impl(motionEvent.getMetaState()));
        }
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, (PositionCalculator)this);
        if (convertToPointerInputEvent$ui_release != null) {
            pointers = convertToPointerInputEvent$ui_release.getPointers();
            int i4 = 0;
            if (size-- >= 0) {
            } else {
                obj = 0;
            }
            if ((PointerInputEventData)obj != null) {
                i = 0;
                this.lastDownPointerPosition = (PointerInputEventData)obj.getPosition-F1C5BW0();
            }
            pointerInputEventProcessor = motionEvent.getActionMasked();
            if (pointerInputEventProcessor != 0) {
                if (pointerInputEventProcessor == 5 && !ProcessResult.getDispatchedToAPointerInputModifier-impl(this.pointerInputEventProcessor.process-BIzXfog(convertToPointerInputEvent$ui_release, (PositionCalculator)this, isInBounds(motionEvent)))) {
                    if (!ProcessResult.getDispatchedToAPointerInputModifier-impl(process-BIzXfog)) {
                        this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    }
                }
            } else {
            }
        } else {
            this.pointerInputEventProcessor.processCancel();
            process-BIzXfog = PointerInputEventProcessorKt.ProcessResult(i3, i3);
        }
        return process-BIzXfog;
    }

    private final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int i3;
        int i4;
        int i2;
        int actionIndex;
        int buttonState;
        int pointerProperties;
        int i;
        long downTime;
        MotionEvent.PointerCoords pointerCoords;
        long l2;
        long l;
        float f;
        int localToScreen-MK-Hz9U;
        float y-impl;
        final Object obj = this;
        final float obj2 = motionEvent;
        actionIndex = -1;
        buttonState = 0;
        switch (actionMasked) {
            case 1:
                actionIndex = buttonState;
                break;
            case 6:
                actionIndex = obj2.getActionIndex();
                break;
            default:
        }
        final int i5 = 1;
        pointerProperties = actionIndex >= 0 ? i5 : buttonState;
        final int i7 = pointerCount - pointerProperties;
        if (i7 == 0) {
        }
        final MotionEvent.PointerProperties[] arr = new MotionEvent.PointerProperties[i7];
        i3 = buttonState;
        while (i3 < i7) {
            pointerProperties = new MotionEvent.PointerProperties();
            arr[i3] = pointerProperties;
            i3++;
        }
        final MotionEvent.PointerCoords[] arr2 = new MotionEvent.PointerCoords[i7];
        i4 = buttonState;
        while (i4 < i7) {
            pointerProperties = new MotionEvent.PointerCoords();
            arr2[i4] = pointerProperties;
            i4++;
        }
        i2 = 0;
        while (i2 < i7) {
            if (actionIndex >= 0) {
            } else {
            }
            i = buttonState;
            i += i2;
            obj2.getPointerProperties(pointerProperties, arr[i2]);
            pointerCoords = arr2[i2];
            obj2.getPointerCoords(pointerProperties, pointerCoords);
            f = pointerCoords.y;
            localToScreen-MK-Hz9U = obj.localToScreen-MK-Hz9U(OffsetKt.Offset(pointerCoords.x, f));
            pointerCoords.x = Offset.getX-impl(localToScreen-MK-Hz9U);
            pointerCoords.y = Offset.getY-impl(localToScreen-MK-Hz9U);
            i2++;
            if (i2 < actionIndex) {
            } else {
            }
            i = i5;
        }
        if (obj28 != null) {
        } else {
            buttonState = obj2.getButtonState();
        }
        long eventTime2 = obj2.getEventTime();
        if (Long.compare(downTime, eventTime2) == 0) {
            l2 = eventTime;
        } else {
            l2 = downTime;
        }
        MotionEvent obtain = MotionEvent.obtain(l2, eventTime2, eventTime, localToScreen-MK-Hz9U, action, i7, arr, arr2, obj2.getMetaState(), buttonState, obj2.getXPrecision(), obj2.getYPrecision(), obj2.getDeviceId(), obj2.getEdgeFlags());
        PointerInputEvent convertToPointerInputEvent$ui_release = obj.motionEventAdapter.convertToPointerInputEvent$ui_release(obtain, (PositionCalculator)obj);
        Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
        obj.pointerInputEventProcessor.process-BIzXfog(convertToPointerInputEvent$ui_release, (PositionCalculator)obj, i5);
        obtain.recycle();
    }

    static void sendSimulatedEvent$default(androidx.compose.ui.platform.AndroidComposeView androidComposeView, MotionEvent motionEvent2, int i3, long l4, boolean z5, int i6, Object object7) {
        int i;
        int obj11;
        i = object7 &= 8 != 0 ? obj11 : i6;
        androidComposeView.sendSimulatedEvent(motionEvent2, i3, l4, obj4);
    }

    private void setDensity(Density <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.density$delegate.setValue(<set-?>);
    }

    private void setFontFamilyResolver(FontFamily.Resolver <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.fontFamilyResolver$delegate.setValue(<set-?>);
    }

    private void setLayoutDirection(LayoutDirection <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.layoutDirection$delegate.setValue(<set-?>);
    }

    private final void set_viewTreeOwners(androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._viewTreeOwners$delegate.setValue(<set-?>);
    }

    private final boolean startDrag-12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources resources = getContext().getResources();
        int i = 0;
        ComposeDragShadowBuilder composeDragShadowBuilder = new ComposeDragShadowBuilder(DensityKt.Density(displayMetrics.density, configuration.fontScale), decorationSize, obj4, obj11, 0);
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop((View)this, transferData, composeDragShadowBuilder);
    }

    private static final void touchModeChangeListener$lambda$6(androidx.compose.ui.platform.AndroidComposeView this$0, boolean touchMode) {
        int keyboard-aOaMEAU;
        InputMode.Companion companion = InputMode.Companion;
        if (touchMode) {
            keyboard-aOaMEAU = companion.getTouch-aOaMEAU();
        } else {
            keyboard-aOaMEAU = companion.getKeyboard-aOaMEAU();
        }
        this$0._inputModeManager.setInputMode-iuPiT84(keyboard-aOaMEAU);
    }

    private final void updatePositionCacheAndDispatch() {
        int positionChanged;
        int measurePassDelegate$ui_release;
        int i;
        positionChanged = 0;
        getLocationOnScreen(this.tmpPositionArray);
        long globalPosition = this.globalPosition;
        int i3 = 0;
        int $i$f$component1Impl = IntOffset.getX-impl(globalPosition);
        int i4 = 0;
        int y-impl = IntOffset.getY-impl(globalPosition);
        i = 0;
        final int i6 = 1;
        if ($i$f$component1Impl == this.tmpPositionArray[i]) {
            this.globalPosition = IntOffsetKt.IntOffset(this.tmpPositionArray[i], this.tmpPositionArray[i6]);
            measurePassDelegate$ui_release = Integer.MAX_VALUE;
            if (y-impl != this.tmpPositionArray[i6] && $i$f$component1Impl != measurePassDelegate$ui_release && y-impl != measurePassDelegate$ui_release) {
                this.globalPosition = IntOffsetKt.IntOffset(this.tmpPositionArray[i], this.tmpPositionArray[i6]);
                measurePassDelegate$ui_release = Integer.MAX_VALUE;
                if ($i$f$component1Impl != measurePassDelegate$ui_release) {
                    if (y-impl != measurePassDelegate$ui_release) {
                        positionChanged = 1;
                        getRoot().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                }
            }
        } else {
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(positionChanged);
    }

    @Override // android.view.ViewGroup
    public final void addAndroidView(AndroidViewHolder view, LayoutNode layoutNode) {
        (Map)getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView((View)view);
        (Map)getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        AndroidComposeView.addAndroidView.1 anon = new AndroidComposeView.addAndroidView.1(this, layoutNode, this);
        ViewCompat.setAccessibilityDelegate((View)view, (AccessibilityDelegateCompat)anon);
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        addView(child, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        ViewGroup.LayoutParams defaultLayoutParams;
        Intrinsics.checkNotNull(child);
        if (child.getLayoutParams() == null) {
            defaultLayoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, defaultLayoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        final ViewGroup.LayoutParams defaultLayoutParams = generateDefaultLayoutParams();
        ViewGroup.LayoutParams view = defaultLayoutParams;
        final int i2 = 0;
        view.width = width;
        view.height = height;
        Unit it = Unit.INSTANCE;
        addView(child, -1, defaultLayoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    public void autofill(SparseArray<AutofillValue> values) {
        boolean autofillSupported;
        autofillSupported = this._autofill;
        if (autofillSupported() && autofillSupported != null) {
            autofillSupported = this._autofill;
            if (autofillSupported != null) {
                AndroidAutofill_androidKt.performAutofill(autofillSupported, values);
            }
        }
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> $completion) {
        Object boundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release($completion);
        if (boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return boundsUpdatesEventLoop$ui_release;
        }
        return Unit.INSTANCE;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> $completion) {
        Object boundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release($completion);
        if (boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return boundsUpdatesEventLoop$ui_release;
        }
        return Unit.INSTANCE;
    }

    @Override // android.view.ViewGroup
    public long calculateLocalPosition-MK-Hz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.map-MK-Hz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // android.view.ViewGroup
    public long calculatePositionInWindow-MK-Hz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.map-MK-Hz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.ViewGroup
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.canScroll-0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.ViewGroup
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.canScroll-0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    public OwnedLayer createLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer) {
        Throwable context;
        boolean obj11;
        int obj12;
        if (explicitLayer != 0) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = new GraphicsLayerOwnerLayer(explicitLayer, 0, this, drawBlock, invalidateParentLayer);
            return (OwnedLayer)graphicsLayerOwnerLayer;
        }
        Object obj = this;
        Function2 function22 = drawBlock;
        Function0 function02 = invalidateParentLayer;
        int i = explicitLayer;
        Object obj10 = obj.layerCache.pop();
        if ((OwnedLayer)obj10 != null) {
            (OwnedLayer)obj10.reuseLayer(function22, function02);
            return obj10;
        }
        if (isHardwareAccelerated()) {
            final Function0 function04 = function02;
            final androidx.compose.ui.platform.AndroidComposeView view3 = this;
            final Function2 function24 = function22;
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer2 = new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), view3, function24, function04);
            androidx.compose.ui.platform.AndroidComposeView view2 = view3;
            Function2 function23 = function24;
            Function0 function03 = function04;
            return (OwnedLayer)graphicsLayerOwnerLayer2;
        }
        if (isHardwareAccelerated() && obj.isRenderNodeCompatible) {
            if (obj.isRenderNodeCompatible) {
                obj11 = new RenderNodeLayer(this, function22, function02);
                return (OwnedLayer)obj11;
            }
        }
        if (obj.viewLayersContainer == null && !ViewLayer.Companion.getHasRetrievedMethod()) {
            if (!ViewLayer.Companion.getHasRetrievedMethod()) {
                obj12 = new View(getContext());
                ViewLayer.Companion.updateDisplayList(obj12);
            }
            if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
                obj11 = new DrawChildContainer(getContext());
            } else {
                obj11 = new ViewLayerContainer(getContext());
            }
            obj.viewLayersContainer = obj11;
            addView((View)obj.viewLayersContainer);
        }
        obj12 = obj.viewLayersContainer;
        Intrinsics.checkNotNull(obj12);
        obj11 = new ViewLayer(this, obj12, function22, function02);
        return (OwnedLayer)obj11;
    }

    @Override // android.view.ViewGroup
    protected void dispatchDraw(Canvas canvas) {
        boolean attachedToWindow;
        int i;
        boolean shouldUseDispatchDraw;
        List postponedDirtyLayers;
        int dirtyLayers;
        int size;
        AndroidCanvas androidCanvas;
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        dirtyLayers = 0;
        int i3 = 1;
        int i4 = 0;
        Owner.measureAndLayout$default((Owner)this, dirtyLayers, i3, i4);
        Snapshot.Companion.sendApplyNotifications();
        this.isDrawingContent = i3;
        CanvasHolder canvasHolder = this.canvasHolder;
        size = 0;
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        final int i5 = 0;
        getRoot().draw$ui_release((Canvas)canvasHolder.getAndroidCanvas(), i4);
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvasHolder.getAndroidCanvas().getInternalCanvas());
        if (!(Collection)this.dirtyLayers.isEmpty()) {
            i = 0;
            while (i < this.dirtyLayers.size()) {
                (OwnedLayer)this.dirtyLayers.get(i).updateDisplayList();
                i++;
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            size = 0;
            canvas.clipRect(size, size, size, size);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(canvas.save());
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = dirtyLayers;
        if (this.postponedDirtyLayers != null) {
            postponedDirtyLayers = this.postponedDirtyLayers;
            Intrinsics.checkNotNull(postponedDirtyLayers);
            this.dirtyLayers.addAll((Collection)postponedDirtyLayers);
            postponedDirtyLayers.clear();
        }
    }

    @Override // android.view.ViewGroup
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean sendHoverExitEvent;
        boolean dispatchGenericMotionEvent;
        boolean attachedToWindow;
        final int i2 = 8;
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == i2) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        if (motionEvent.getActionMasked() == i2) {
            if (!isBadMotionEvent(motionEvent)) {
                if (!isAttachedToWindow()) {
                    dispatchGenericMotionEvent = super.dispatchGenericMotionEvent(motionEvent);
                } else {
                    if (motionEvent.isFromSource(4194304)) {
                        dispatchGenericMotionEvent = handleRotaryEvent(motionEvent);
                    } else {
                        dispatchGenericMotionEvent = ProcessResult.getDispatchedToAPointerInputModifier-impl(handleMotionEvent-8iAsVTc(motionEvent));
                    }
                }
            } else {
            }
        } else {
            dispatchGenericMotionEvent = super.dispatchGenericMotionEvent(motionEvent);
        }
        return dispatchGenericMotionEvent;
    }

    @Override // android.view.ViewGroup
    public boolean dispatchHoverEvent(MotionEvent event) {
        boolean sendHoverExitEvent;
        int buttonState;
        boolean positionChanged;
        boolean attachedToWindow;
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        int i3 = 0;
        if (!isBadMotionEvent(event)) {
            if (!isAttachedToWindow()) {
            } else {
                this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
                switch (positionChanged) {
                    case 7:
                        return i3;
                    case 10:
                        return i3;
                        MotionEvent previousMotionEvent = this.previousMotionEvent;
                        previousMotionEvent.recycle();
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                        this.hoverExitReceived = true;
                        postDelayed(this.sendHoverExitEvent, 8);
                        return i3;
                    default:
                }
            }
            return ProcessResult.getDispatchedToAPointerInputModifier-impl(handleMotionEvent-8iAsVTc(event));
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean dispatchKeyEvent-YhN2O0w;
        boolean dispatchKeyEvent-YhN2O0w$default;
        KeyEvent constructor-impl;
        androidx.compose.ui.platform.AndroidComposeView.dispatchKeyEvent.1 anon;
        int i;
        if (isFocused()) {
            this._windowInfo.setKeyboardModifiers-5xRPYO0(PointerKeyboardModifiers.constructor-impl(event.getMetaState()));
            i = 0;
            if (!FocusOwner.dispatchKeyEvent-YhN2O0w$default(getFocusOwner(), KeyEvent.constructor-impl(event), i, 2, i)) {
                if (super.dispatchKeyEvent(event)) {
                    dispatchKeyEvent-YhN2O0w = 1;
                } else {
                    dispatchKeyEvent-YhN2O0w = 0;
                }
            } else {
            }
        } else {
            anon = new AndroidComposeView.dispatchKeyEvent.1(this, event);
            dispatchKeyEvent-YhN2O0w = getFocusOwner().dispatchKeyEvent-YhN2O0w(KeyEvent.constructor-impl(event), (Function0)anon);
        }
        return dispatchKeyEvent-YhN2O0w;
    }

    @Override // android.view.ViewGroup
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        boolean dispatchInterceptedSoftKeyboardEvent-ZmokQxo;
        int i;
        KeyEvent constructor-impl;
        if (isFocused()) {
            if (!getFocusOwner().dispatchInterceptedSoftKeyboardEvent-ZmokQxo(KeyEvent.constructor-impl(event))) {
                i = super.dispatchKeyEventPreIme(event) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public void dispatchProvideStructure(ViewStructure structure) {
        super.dispatchProvideStructure(structure);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean previousMotionEvent;
        boolean attachedToWindow;
        int positionChanged;
        boolean anyMovementConsumed-impl;
        boolean sendHoverExitEvent;
        int i;
        int i2 = 0;
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            previousMotionEvent = this.previousMotionEvent;
            Intrinsics.checkNotNull(previousMotionEvent);
            if (motionEvent.getActionMasked() == 0) {
                if (hasChangedDevices(motionEvent, previousMotionEvent)) {
                    this.sendHoverExitEvent.run();
                } else {
                    this.hoverExitReceived = i2;
                }
            } else {
            }
        }
        if (!isBadMotionEvent(motionEvent)) {
            if (!isAttachedToWindow()) {
            } else {
                if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
                    if (!isPositionChanged(motionEvent)) {
                        return i2;
                    }
                }
                int motionEvent-8iAsVTc = handleMotionEvent-8iAsVTc(motionEvent);
                if (ProcessResult.getAnyMovementConsumed-impl(motionEvent-8iAsVTc)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            return ProcessResult.getDispatchedToAPointerInputModifier-impl(motionEvent-8iAsVTc);
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    @Override // android.view.ViewGroup
    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        int i;
        i = 0;
        int i2 = 1;
        final Class[] arr2 = new Class[i2];
        arr2[0] = Integer.TYPE;
        Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("findViewByAccessibilityIdTraversal", arr2);
        declaredMethod.setAccessible(i2);
        Object invoke = declaredMethod.invoke(this, /* result */);
        if (invoke instanceof View != null) {
            i = invoke;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public View focusSearch(View focused, int direction) {
        Rect boundingRect;
        int down-dhqQ-8s;
        boolean equal;
        Boolean valueOf;
        if (focused != null) {
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
            if (focusDirection != null) {
                down-dhqQ-8s = focusDirection.unbox-impl();
            } else {
                down-dhqQ-8s = FocusDirection.Companion.getDown-dhqQ-8s();
            }
            if (Intrinsics.areEqual(getFocusOwner().focusSearch-ULY8qGw(down-dhqQ-8s, FocusInteropUtils_androidKt.calculateBoundingRect(focused), (Function1)AndroidComposeView.focusSearch.1.INSTANCE), true)) {
                return (View)this;
            }
        }
        return super.focusSearch(focused, direction);
    }

    @Override // android.view.ViewGroup
    public void forceAccessibilityForTesting(boolean enable) {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui_release(enable);
    }

    @Override // android.view.ViewGroup
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.AccessibilityManager getAccessibilityManager() {
        return (AccessibilityManager)getAccessibilityManager();
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // android.view.ViewGroup
    public final androidx.compose.ui.platform.AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        androidx.compose.ui.platform.AndroidViewsHandler _androidViewsHandler;
        Context context;
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView((View)this._androidViewsHandler);
            requestLayout();
        }
        androidx.compose.ui.platform.AndroidViewsHandler _androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(_androidViewsHandler2);
        return _androidViewsHandler2;
    }

    @Override // android.view.ViewGroup
    public Autofill getAutofill() {
        return (Autofill)this._autofill;
    }

    @Override // android.view.ViewGroup
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.ClipboardManager getClipboardManager() {
        return (ClipboardManager)getClipboardManager();
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    @Override // android.view.ViewGroup
    public final AndroidContentCaptureManager getContentCaptureManager$ui_release() {
        return this.contentCaptureManager;
    }

    @Override // android.view.ViewGroup
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // android.view.ViewGroup
    public Density getDensity() {
        final int i = 0;
        final int i2 = 0;
        return (Density)(State)this.density$delegate.getValue();
    }

    @Override // android.view.ViewGroup
    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // android.view.ViewGroup
    public FocusDirection getFocusDirection-P8AzH3I(KeyEvent keyEvent) {
        FocusDirection box-impl;
        int previous-dhqQ-8s;
        boolean escape-EK5gGoQ;
        boolean equals-impl0;
        int equals-impl02;
        long directionDown-EK5gGoQ;
        long key-ZmokQxo = KeyEvent_androidKt.getKey-ZmokQxo(keyEvent);
        if (Key.equals-impl0(key-ZmokQxo, obj1)) {
            if (KeyEvent_androidKt.isShiftPressed-ZmokQxo(keyEvent)) {
                previous-dhqQ-8s = FocusDirection.Companion.getPrevious-dhqQ-8s();
            } else {
                previous-dhqQ-8s = FocusDirection.Companion.getNext-dhqQ-8s();
            }
            box-impl = FocusDirection.box-impl(previous-dhqQ-8s);
        } else {
            if (Key.equals-impl0(key-ZmokQxo, obj1)) {
                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getRight-dhqQ-8s());
            } else {
                if (Key.equals-impl0(key-ZmokQxo, obj1)) {
                    box-impl = FocusDirection.box-impl(FocusDirection.Companion.getLeft-dhqQ-8s());
                } else {
                    equals-impl02 = 1;
                    if (Key.equals-impl0(key-ZmokQxo, obj1)) {
                        escape-EK5gGoQ = equals-impl02;
                    } else {
                        escape-EK5gGoQ = Key.equals-impl0(key-ZmokQxo, obj1);
                    }
                    if (escape-EK5gGoQ) {
                        box-impl = FocusDirection.box-impl(FocusDirection.Companion.getUp-dhqQ-8s());
                    } else {
                        if (Key.equals-impl0(key-ZmokQxo, obj1)) {
                            escape-EK5gGoQ = equals-impl02;
                        } else {
                            escape-EK5gGoQ = Key.equals-impl0(key-ZmokQxo, obj1);
                        }
                        if (escape-EK5gGoQ != 0) {
                            box-impl = FocusDirection.box-impl(FocusDirection.Companion.getDown-dhqQ-8s());
                        } else {
                            if (Key.equals-impl0(key-ZmokQxo, obj1)) {
                                equals-impl0 = equals-impl02;
                            } else {
                                equals-impl0 = Key.equals-impl0(key-ZmokQxo, obj1);
                            }
                            if (equals-impl0) {
                                escape-EK5gGoQ = equals-impl02;
                            } else {
                                escape-EK5gGoQ = Key.equals-impl0(key-ZmokQxo, obj1);
                            }
                            if (escape-EK5gGoQ) {
                                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getEnter-dhqQ-8s());
                            } else {
                                if (Key.equals-impl0(key-ZmokQxo, obj1)) {
                                } else {
                                    equals-impl02 = Key.equals-impl0(key-ZmokQxo, obj1);
                                }
                                if (equals-impl02 != 0) {
                                    box-impl = FocusDirection.box-impl(FocusDirection.Companion.getExit-dhqQ-8s());
                                } else {
                                    box-impl = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return box-impl;
    }

    @Override // android.view.ViewGroup
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.ViewGroup
    public void getFocusedRect(Rect rect) {
        Unit $this$getFocusedRect_u24lambda_u249;
        int i2;
        int $this$fastRoundToInt$iv;
        int i;
        Rect onFetchFocusRect = onFetchFocusRect();
        if (onFetchFocusRect != null) {
            i2 = 0;
            int i3 = 0;
            rect.left = Math.round(onFetchFocusRect.getLeft());
            int i4 = 0;
            rect.top = Math.round(onFetchFocusRect.getTop());
            int i5 = 0;
            rect.right = Math.round(onFetchFocusRect.getRight());
            i = 0;
            rect.bottom = Math.round(onFetchFocusRect.getBottom());
            $this$getFocusedRect_u24lambda_u249 = Unit.INSTANCE;
        } else {
            $this$getFocusedRect_u24lambda_u249 = 0;
        }
        if ($this$getFocusedRect_u24lambda_u249 == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // android.view.ViewGroup
    public FontFamily.Resolver getFontFamilyResolver() {
        final int i = 0;
        final int i2 = 0;
        return (FontFamily.Resolver)(State)this.fontFamilyResolver$delegate.getValue();
    }

    @Override // android.view.ViewGroup
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @Override // android.view.ViewGroup
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // android.view.ViewGroup
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // android.view.ViewGroup
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    @Override // android.view.ViewGroup
    public InputModeManager getInputModeManager() {
        return (InputModeManager)this._inputModeManager;
    }

    @Override // android.view.ViewGroup
    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    @Override // android.view.ViewGroup
    public LayoutDirection getLayoutDirection() {
        final int i = 0;
        final int i2 = 0;
        return (LayoutDirection)(State)this.layoutDirection$delegate.getValue();
    }

    @Override // android.view.ViewGroup
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // android.view.ViewGroup
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // android.view.ViewGroup
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope((Owner)this);
    }

    @Override // android.view.ViewGroup
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    @Override // android.view.ViewGroup
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // android.view.ViewGroup
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @Override // android.view.ViewGroup
    public final boolean getScrollCaptureInProgress$ui_release() {
        int scrollCapture;
        int scrollCaptureInProgress;
        scrollCaptureInProgress = 0;
        if (Build.VERSION.SDK_INT >= 31) {
            scrollCapture = this.scrollCapture;
            if (scrollCapture != null) {
                scrollCaptureInProgress = scrollCapture.getScrollCaptureInProgress();
            }
        } else {
        }
        return scrollCaptureInProgress;
    }

    @Override // android.view.ViewGroup
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // android.view.ViewGroup
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // android.view.ViewGroup
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // android.view.ViewGroup
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // android.view.ViewGroup
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @Override // android.view.ViewGroup
    public View getView() {
        return (View)this;
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // android.view.ViewGroup
    public final androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners getViewTreeOwners() {
        final int i = 0;
        final int i2 = 0;
        return (AndroidComposeView.ViewTreeOwners)this.viewTreeOwners$delegate.getValue();
    }

    @Override // android.view.ViewGroup
    public androidx.compose.ui.platform.WindowInfo getWindowInfo() {
        return (WindowInfo)this._windowInfo;
    }

    @Override // android.view.ViewGroup
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup
    public boolean isLifecycleInResumedState() {
        Lifecycle.State currentState;
        int i;
        Object viewTreeOwners;
        viewTreeOwners = getViewTreeOwners();
        viewTreeOwners = viewTreeOwners.getLifecycleOwner();
        viewTreeOwners = viewTreeOwners.getLifecycle();
        if (viewTreeOwners != null && viewTreeOwners != null && viewTreeOwners != null) {
            viewTreeOwners = viewTreeOwners.getLifecycleOwner();
            if (viewTreeOwners != null) {
                viewTreeOwners = viewTreeOwners.getLifecycle();
                if (viewTreeOwners != null) {
                    currentState = viewTreeOwners.getCurrentState();
                } else {
                    currentState = 0;
                }
            } else {
            }
        } else {
        }
        i = currentState == Lifecycle.State.RESUMED ? 1 : 0;
        return i;
    }

    @Override // android.view.ViewGroup
    public void localToScreen-58bKbWc(float[] localTransform) {
        recalculateWindowPosition();
        Matrix.timesAssign-58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.access$preTranslate-cG2Xzmc(localTransform, Offset.getX-impl(this.windowPosition), Offset.getY-impl(this.windowPosition), this.tmpMatrix);
    }

    @Override // android.view.ViewGroup
    public long localToScreen-MK-Hz9U(long localPosition) {
        recalculateWindowPosition();
        long map-MK-Hz9U = Matrix.map-MK-Hz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(x-impl += x-impl2, y-impl += y-impl2);
    }

    @Override // android.view.ViewGroup
    public void measureAndLayout(boolean sendPointerUpdate) {
        boolean hasPendingMeasureOrLayout;
        int i2;
        Object $i$a$TraceAndroidComposeView$measureAndLayout$1;
        int i3;
        Function0 resendMotionEventOnLayout;
        boolean measureAndLayout;
        MeasureAndLayoutDelegate measureAndLayoutDelegate;
        int i4;
        int i;
        if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
            if (this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
                i2 = 0;
                Trace.beginSection("AndroidOwner:measureAndLayout");
                int i5 = 0;
                i3 = 0;
                resendMotionEventOnLayout = sendPointerUpdate ? this.resendMotionEventOnLayout : i3;
                if (this.measureAndLayoutDelegate.measureAndLayout(resendMotionEventOnLayout)) {
                    requestLayout();
                }
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, i3);
                dispatchPendingInteropLayoutCallbacks();
                $i$a$TraceAndroidComposeView$measureAndLayout$1 = Unit.INSTANCE;
                Trace.endSection();
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public void measureAndLayout-0kLqBqw(LayoutNode layoutNode, long constraints) {
        boolean hasPendingMeasureOrLayout;
        int i;
        int i2;
        int i3;
        final int i4 = 0;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        int i5 = 0;
        this.measureAndLayoutDelegate.measureAndLayout-0kLqBqw(layoutNode, constraints);
        if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, 0);
            dispatchPendingInteropLayoutCallbacks();
        }
        Unit $i$a$TraceAndroidComposeView$measureAndLayout$2 = Unit.INSTANCE;
        Trace.endSection();
    }

    @Override // android.view.ViewGroup
    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default((Owner)this, false, 1, 0);
    }

    @Override // android.view.ViewGroup
    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        boolean postponedDirtyLayers;
        List list;
        int i;
        if (!isDirty) {
            this.dirtyLayers.remove(layer);
            postponedDirtyLayers = this.postponedDirtyLayers;
            if (!this.isDrawingContent && postponedDirtyLayers != null) {
                this.dirtyLayers.remove(layer);
                postponedDirtyLayers = this.postponedDirtyLayers;
                if (postponedDirtyLayers != null) {
                    postponedDirtyLayers.remove(layer);
                }
            }
        } else {
            if (!this.isDrawingContent) {
                (Collection)this.dirtyLayers.add(layer);
            } else {
                if (this.postponedDirtyLayers == null) {
                    postponedDirtyLayers = new ArrayList();
                    i = 0;
                    this.postponedDirtyLayers = (List)postponedDirtyLayers;
                }
                (Collection)postponedDirtyLayers.add(layer);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onAttach(LayoutNode node) {
    }

    @Override // android.view.ViewGroup
    protected void onAttachedToWindow() {
        boolean autofillSupported;
        int lifecycleOwner;
        int i2;
        AutofillCallback iNSTANCE;
        int lifecycle;
        Object lifecycleOwner2;
        Object viewTreeOwners;
        int iNSTANCE2;
        Object onViewTreeOwnersAvailable;
        int keyboard-aOaMEAU;
        int i;
        super.onAttachedToWindow();
        this._windowInfo.setWindowFocused(hasWindowFocus());
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        int i3 = 0;
        int i4 = 0;
        autofillSupported = this._autofill;
        if (autofillSupported() && autofillSupported != null) {
            autofillSupported = this._autofill;
            if (autofillSupported != null) {
                lifecycleOwner = 0;
                AutofillCallback.INSTANCE.register(autofillSupported);
            }
        }
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get((View)this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get((View)this);
        androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
        if (viewTreeOwners2 != null) {
            if (lifecycleOwner3 != null && savedStateRegistryOwner != null) {
                if (savedStateRegistryOwner != null) {
                    if (lifecycleOwner3 == viewTreeOwners2.getLifecycleOwner()) {
                        if (savedStateRegistryOwner != viewTreeOwners2.getLifecycleOwner()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i2 != 0) {
            if (lifecycleOwner3 == null) {
            } else {
                if (savedStateRegistryOwner == null) {
                } else {
                    lifecycleOwner2 = viewTreeOwners2.getLifecycleOwner();
                    lifecycleOwner2 = lifecycleOwner2.getLifecycle();
                    if (viewTreeOwners2 != null && lifecycleOwner2 != null && lifecycleOwner2 != null) {
                        lifecycleOwner2 = viewTreeOwners2.getLifecycleOwner();
                        if (lifecycleOwner2 != null) {
                            lifecycleOwner2 = lifecycleOwner2.getLifecycle();
                            if (lifecycleOwner2 != null) {
                                lifecycleOwner2.removeObserver((LifecycleObserver)this);
                            }
                        }
                    }
                    lifecycleOwner3.getLifecycle().addObserver((LifecycleObserver)this);
                    lifecycleOwner2 = new AndroidComposeView.ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
                    set_viewTreeOwners(lifecycleOwner2);
                    onViewTreeOwnersAvailable = this.onViewTreeOwnersAvailable;
                    if (onViewTreeOwnersAvailable != null) {
                        onViewTreeOwnersAvailable.invoke(lifecycleOwner2);
                    }
                    this.onViewTreeOwnersAvailable = 0;
                }
                IllegalStateException illegalStateException2 = new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
                throw illegalStateException2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            throw illegalStateException;
        }
        if (isInTouchMode()) {
            keyboard-aOaMEAU = InputMode.Companion.getTouch-aOaMEAU();
        } else {
            keyboard-aOaMEAU = InputMode.Companion.getKeyboard-aOaMEAU();
        }
        this._inputModeManager.setInputMode-iuPiT84(keyboard-aOaMEAU);
        viewTreeOwners = getViewTreeOwners();
        viewTreeOwners = viewTreeOwners.getLifecycleOwner();
        if (viewTreeOwners != null && viewTreeOwners != null) {
            viewTreeOwners = viewTreeOwners.getLifecycleOwner();
            if (viewTreeOwners != null) {
                lifecycle = viewTreeOwners.getLifecycle();
            }
        }
        int i5 = 0;
        if (lifecycle == 0) {
        } else {
            lifecycle.addObserver((LifecycleObserver)this);
            lifecycle.addObserver((LifecycleObserver)this.contentCaptureManager);
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback((View)this);
            }
        }
        int i6 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // android.view.ViewGroup
    public boolean onCheckIsTextEditor() {
        Object currentSession-impl = SessionMutex.getCurrentSession-impl(this.textInputSessionMutex);
        if ((AndroidPlatformTextInputSession)currentSession-impl == null) {
            return this.legacyTextInputServiceAndroid.isEditorFocused();
        }
        return (AndroidPlatformTextInputSession)currentSession-impl.isReadyForConnection();
    }

    @Override // android.view.ViewGroup
    protected void onConfigurationChanged(Configuration newConfig) {
        int fontWeightAdjustmentCompat;
        super.onConfigurationChanged(newConfig);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.ViewGroup
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Object currentSession-impl = SessionMutex.getCurrentSession-impl(this.textInputSessionMutex);
        if ((AndroidPlatformTextInputSession)currentSession-impl == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(outAttrs);
        }
        return (AndroidPlatformTextInputSession)currentSession-impl.createInputConnection(outAttrs);
    }

    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // android.view.ViewGroup
    public void onDetach(LayoutNode node) {
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    @Override // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        Object viewTreeOwners;
        int lifecycle;
        int iNSTANCE;
        int i2;
        boolean autofillSupported;
        int i;
        AutofillCallback iNSTANCE2;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        viewTreeOwners = getViewTreeOwners();
        viewTreeOwners = viewTreeOwners.getLifecycleOwner();
        if (viewTreeOwners != null && viewTreeOwners != null) {
            viewTreeOwners = viewTreeOwners.getLifecycleOwner();
            if (viewTreeOwners != null) {
                lifecycle = viewTreeOwners.getLifecycle();
            } else {
                lifecycle = 0;
            }
        } else {
        }
        int i3 = 0;
        if (lifecycle == 0) {
        } else {
            lifecycle.removeObserver((LifecycleObserver)this.contentCaptureManager);
            lifecycle.removeObserver((LifecycleObserver)this);
            int i4 = 0;
            int i6 = 0;
            autofillSupported = this._autofill;
            if (autofillSupported() && autofillSupported != null) {
                autofillSupported = this._autofill;
                if (autofillSupported != null) {
                    i = 0;
                    AutofillCallback.INSTANCE.unregister(autofillSupported);
                }
            }
            getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback((View)this);
            }
        }
        int i5 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // android.view.ViewGroup
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup
    public void onEndApplyChanges() {
        boolean observationClearRequested;
        androidx.compose.ui.platform.AndroidViewsHandler size;
        MutableVector i;
        int i3;
        Object this_$iv;
        MutableVector endApplyChangesListeners;
        int i2;
        final int i4 = 0;
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = i4;
        }
        androidx.compose.ui.platform.AndroidViewsHandler _androidViewsHandler = this._androidViewsHandler;
        if (_androidViewsHandler != null) {
            clearChildInvalidObservations((ViewGroup)_androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            size = this.endApplyChangesListeners.getSize();
            i3 = 0;
            while (i3 < size) {
                int i5 = 0;
                this_$iv = this.endApplyChangesListeners.getContent()[i3];
                this.endApplyChangesListeners.set(i3, 0);
                if ((Function0)this_$iv != null) {
                }
                i3++;
                (Function0)this_$iv.invoke();
            }
            this.endApplyChangesListeners.removeRange(i4, size);
            i5 = 0;
            this_$iv = this.endApplyChangesListeners.getContent()[i3];
            this.endApplyChangesListeners.set(i3, 0);
            if ((Function0)this_$iv != null) {
            }
            i3++;
            (Function0)this_$iv.invoke();
        }
    }

    @Override // android.view.ViewGroup
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        boolean focusOwner;
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (!gainFocus && !hasFocus()) {
            if (!hasFocus()) {
                getFocusOwner().releaseFocus();
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        androidx.compose.ui.platform.AndroidViewsHandler _androidViewsHandler;
        Function0 resendMotionEventOnLayout;
        int i2;
        int i;
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = 0;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            i = 0;
            getAndroidViewsHandler$ui_release().layout(i, i, r - l, b - t);
        }
    }

    @Override // android.view.ViewGroup
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release(layoutNode);
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        boolean attachedToWindow;
        Constraints onMeasureConstraints;
        androidx.compose.ui.platform.AndroidViewsHandler _androidViewsHandler;
        int equals-impl0;
        int measureSpec;
        long constructor-impl;
        long height;
        final Object obj = this;
        final int i3 = 0;
        Trace.beginSection("AndroidOwner:onMeasure");
        int i2 = 0;
        if (!obj.isAttachedToWindow()) {
            obj.invalidateLayoutNodeMeasurement(obj.getRoot());
        }
        long convertMeasureSpec-I7RO_PI = convertMeasureSpec-I7RO_PI(widthMeasureSpec);
        Object obj4 = this;
        int i7 = 0;
        int i9 = 32;
        long l3 = this;
        int i5 = 0;
        long l4 = 4294967295L;
        long convertMeasureSpec-I7RO_PI2 = obj.convertMeasureSpec-I7RO_PI(heightMeasureSpec);
        Object obj2 = this;
        final int i17 = 0;
        Object obj3 = this;
        int i8 = 0;
        long l = ConstraintsKt.Constraints((int)constructor-impl3, (int)constructor-impl4, (int)constructor-impl2, (int)constructor-impl);
        if (obj.onMeasureConstraints == null) {
            obj.onMeasureConstraints = Constraints.box-impl(l);
            obj.wasMeasuredWithMultipleConstraints = false;
        } else {
            onMeasureConstraints = obj.onMeasureConstraints;
            if (onMeasureConstraints != null) {
                equals-impl0 = Constraints.equals-impl0(onMeasureConstraints.unbox-impl(), obj14);
            }
            if (equals-impl0 == 0) {
                obj.wasMeasuredWithMultipleConstraints = true;
            }
        }
        obj.measureAndLayoutDelegate.updateRootConstraints-BRTryo0(l);
        obj.measureAndLayoutDelegate.measureOnly();
        obj.setMeasuredDimension(obj.getRoot().getWidth(), obj.getRoot().getHeight());
        if (obj._androidViewsHandler != null) {
            try {
                int i16 = 1073741824;
                obj.getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(obj.getRoot().getWidth(), i16), View.MeasureSpec.makeMeasureSpec(obj.getRoot().getHeight(), i16));
                Unit $i$a$TraceAndroidComposeView$onMeasure$1 = Unit.INSTANCE;
                Trace.endSection();
                i = heightMeasureSpec;
                Trace.endSection();
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        boolean autofillSupported;
        autofillSupported = this._autofill;
        if (autofillSupported() && structure != null && autofillSupported != null) {
            if (structure != null) {
                autofillSupported = this._autofill;
                if (autofillSupported != null) {
                    AndroidAutofill_androidKt.populateViewStructure(autofillSupported, structure);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        boolean requestLookaheadRemeasure;
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                if (scheduleMeasureAndLayout) {
                    scheduleMeasureAndLayout(layoutNode);
                }
            }
        } else {
            if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                if (scheduleMeasureAndLayout) {
                    scheduleMeasureAndLayout(layoutNode);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        boolean requestLookaheadRelayout;
        final int i = 1;
        final int i2 = 0;
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                AndroidComposeView.scheduleMeasureAndLayout$default(this, i2, i, i2);
            }
        } else {
            if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
                AndroidComposeView.scheduleMeasureAndLayout$default(this, i2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onResume(LifecycleOwner owner) {
        setShowLayoutBounds(AndroidComposeView.Companion.access$getIsShowingLayoutBounds(AndroidComposeView.Companion));
    }

    @Override // android.view.ViewGroup
    public void onRtlPropertiesChanged(int layoutDirection) {
        LayoutDirection superclassInitComplete;
        if (this.superclassInitComplete && FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection) == null) {
            if (FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection) == null) {
                superclassInitComplete = LayoutDirection.Ltr;
            }
            setLayoutDirection(superclassInitComplete);
        }
    }

    public void onScrollCaptureSearch(Rect localVisibleRect, Point windowOffset, Consumer<ScrollCaptureTarget> targets) {
        int scrollCapture;
        int i;
        SemanticsOwner semanticsOwner;
        CoroutineContext coroutineContext;
        scrollCapture = this.scrollCapture;
        if (Build.VERSION.SDK_INT >= 31 && scrollCapture != null) {
            scrollCapture = this.scrollCapture;
            if (scrollCapture != null) {
                scrollCapture.onScrollCaptureSearch((View)this, getSemanticsOwner(), getCoroutineContext(), targets);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        this.contentCaptureManager.onVirtualViewTranslationResponses$ui_release(this.contentCaptureManager, response);
    }

    @Override // android.view.ViewGroup
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        int i;
        int i2;
        boolean showLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        i = AndroidComposeView.Companion.access$getIsShowingLayoutBounds(AndroidComposeView.Companion);
        i2 = 0;
        if (hasWindowFocus && getShowLayoutBounds() != i) {
            i = AndroidComposeView.Companion.access$getIsShowingLayoutBounds(AndroidComposeView.Companion);
            i2 = 0;
            if (getShowLayoutBounds() != i) {
                setShowLayoutBounds(i);
                invalidateDescendants();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean recycle$ui_release(OwnedLayer layer) {
        androidx.compose.ui.platform.DrawChildContainer shouldUseDispatchDraw;
        androidx.compose.ui.platform.WeakCache layerCache;
        if (this.viewLayersContainer != null && !ViewLayer.Companion.getShouldUseDispatchDraw()) {
            if (!ViewLayer.Companion.getShouldUseDispatchDraw()) {
            }
        }
        int i = 1;
        if (i != 0) {
            this.layerCache.push(layer);
        }
        return i;
    }

    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        boolean endApplyChangesListeners;
        int i;
        if (!this.endApplyChangesListeners.contains(listener)) {
            i = 0;
            this.endApplyChangesListeners.add(listener);
        }
    }

    @Override // android.view.ViewGroup
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        int i = 0;
        AndroidComposeView.scheduleMeasureAndLayout$default(this, i, 1, i);
    }

    @Override // android.view.ViewGroup
    public final void removeAndroidView(AndroidViewHolder view) {
        AndroidComposeView.removeAndroidView.1 anon = new AndroidComposeView.removeAndroidView.1(this, view);
        registerOnEndApplyChangesListener((Function0)anon);
    }

    @Override // android.view.ViewGroup
    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // android.view.ViewGroup
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        int enter-dhqQ-8s;
        int booleanValue;
        int composeRect;
        if (isFocused()) {
            return 1;
        }
        if (getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        if (isInTouchMode()) {
            return 0;
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
        if (focusDirection != null) {
            enter-dhqQ-8s = focusDirection.unbox-impl();
        } else {
            enter-dhqQ-8s = FocusDirection.Companion.getEnter-dhqQ-8s();
        }
        if (previouslyFocusedRect != null) {
            composeRect = RectHelper_androidKt.toComposeRect(previouslyFocusedRect);
        } else {
            composeRect = 0;
        }
        AndroidComposeView.requestFocus.1 anon = new AndroidComposeView.requestFocus.1(enter-dhqQ-8s);
        Boolean focusSearch-ULY8qGw = getFocusOwner().focusSearch-ULY8qGw(enter-dhqQ-8s, composeRect, (Function1)anon);
        if (focusSearch-ULY8qGw != null) {
            booleanValue = focusSearch-ULY8qGw.booleanValue();
        } else {
        }
        return booleanValue;
    }

    @Override // android.view.ViewGroup
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        int i = 0;
        AndroidComposeView.scheduleMeasureAndLayout$default(this, i, 1, i);
    }

    @Override // android.view.ViewGroup
    public long screenToLocal-MK-Hz9U(long positionOnScreen) {
        recalculateWindowPosition();
        return Matrix.map-MK-Hz9U(this.windowToViewMatrix, OffsetKt.Offset(x-impl -= x-impl2, y-impl -= y-impl2));
    }

    @Override // android.view.ViewGroup
    public boolean sendKeyEvent-ZmokQxo(KeyEvent keyEvent) {
        int i;
        boolean dispatchInterceptedSoftKeyboardEvent-ZmokQxo;
        int i2;
        int i3;
        if (!getFocusOwner().dispatchInterceptedSoftKeyboardEvent-ZmokQxo(keyEvent)) {
            i3 = 0;
            if (FocusOwner.dispatchKeyEvent-YhN2O0w$default(getFocusOwner(), keyEvent, i3, 2, i3)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(intervalMillis);
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> <set-?>) {
        this.configurationChangeObserver = <set-?>;
    }

    @Override // android.view.ViewGroup
    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager <set-?>) {
        this.contentCaptureManager = <set-?>;
    }

    @Override // android.view.ViewGroup
    public void setCoroutineContext(CoroutineContext value) {
        Object stack$iv$iv;
        int node$iv$iv5;
        int i;
        CoroutineContext context;
        int this_$iv$iv$iv;
        Modifier.Node next$iv$iv;
        int capacity$iv$iv$iv$iv;
        Modifier.Node count$iv$iv;
        int count$iv$iv2;
        boolean z;
        Modifier.Node child$ui_release;
        int i8;
        LayoutNode layout$iv$iv;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtree$1$iv$iv;
        Modifier.Node node$iv$iv;
        int i3;
        Modifier.Node node2;
        int i7;
        int node$iv$iv3;
        int node$iv$iv4;
        Modifier.Node node$iv$iv2;
        Modifier.Node headModifierNode;
        Modifier.Node node;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i9;
        int this_$iv$iv$iv2;
        int i5;
        int i4;
        Modifier.Node node$iv$iv6;
        int i2;
        int i6;
        stack$iv$iv = this;
        stack$iv$iv.coroutineContext = value;
        count$iv$iv = stack$iv$iv.getRoot().getNodes$ui_release().getHead$ui_release();
        if (count$iv$iv instanceof SuspendingPointerInputModifierNode) {
            (SuspendingPointerInputModifierNode)count$iv$iv.resetPointerInputHandler();
        }
        int i12 = 0;
        int $i$f$getPointerInputOLwlOKw = NodeKind.constructor-impl(16);
        int i14 = 0;
        final int i15 = $i$f$getPointerInputOLwlOKw;
        final Modifier.Node node7 = node6;
        final int i16 = 0;
        int i17 = 0;
        if (!node7.getNode().isAttached()) {
            int i18 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        child$ui_release = node7.getNode().getChild$ui_release();
        layout$iv$iv = DelegatableNodeKt.requireLayoutNode(node7);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (layout$iv$iv != null) {
            if (child$ui_release == null) {
            } else {
            }
            node$iv$iv = child$ui_release;
            if (aggregateChildKindSet$ui_release &= i15 != 0) {
            } else {
            }
            headModifierNode = count$iv$iv;
            child$ui_release = null;
            nestedVectorStack.push(layout$iv$iv.get_children$ui_release());
            if (nestedVectorStack.isNotEmpty()) {
            } else {
            }
            i = 0;
            layout$iv$iv = i;
            stack$iv$iv = this;
            context = value;
            count$iv$iv = headModifierNode;
            i = nestedVectorStack.pop();
            while (node$iv$iv != null) {
                if (kindSet$ui_release &= i15 != 0) {
                } else {
                }
                headModifierNode = count$iv$iv;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                stack$iv$iv = this;
                context = value;
                count$iv$iv = headModifierNode;
                i3 = 0;
                i7 = 0;
                node$iv$iv3 = 0;
                int i19 = 0;
                stack$iv$iv = node$iv$iv2;
                while (stack$iv$iv != null) {
                    if (stack$iv$iv instanceof PointerInputModifierNode) {
                    } else {
                    }
                    Modifier.Node node4 = stack$iv$iv;
                    int i11 = 0;
                    node = node4;
                    if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv3);
                    context = value;
                    count$iv$iv = headModifierNode;
                    if (stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    node = 0;
                    node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i9 = 0;
                        i5 = 0;
                        if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv6 = stack$iv$iv;
                        next$iv$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv = 1;
                        count$iv$iv2++;
                        if (count$iv$iv2 == this_$iv$iv$iv) {
                        } else {
                        }
                        if (node$iv$iv3 == 0) {
                        } else {
                        }
                        node$iv$iv6 = stack$iv$iv;
                        i2 = count$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv5 = node$iv$iv3;
                        Modifier.Node node5 = node$iv$iv6;
                        if (node5 != null) {
                        } else {
                        }
                        node$iv$iv4 = node$iv$iv6;
                        if (node$iv$iv5 != 0) {
                        } else {
                        }
                        next$iv$iv = node3;
                        node$iv$iv3 = node$iv$iv5;
                        stack$iv$iv = theNode$iv$iv;
                        count$iv$iv2 = i2;
                        node$iv$iv5.add(node3);
                        if (node$iv$iv5 != 0) {
                        }
                        node$iv$iv4 = 0;
                        node$iv$iv5.add(node5);
                        this_$iv$iv$iv2 = 0;
                        int i10 = 16;
                        i4 = 0;
                        node$iv$iv6 = stack$iv$iv;
                        i2 = count$iv$iv2;
                        i6 = i10;
                        node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
                        stack$iv$iv = node3;
                        next$iv$iv = node3;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                    }
                    node$iv$iv6 = stack$iv$iv;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    stack$iv$iv = node$iv$iv6;
                    context = value;
                    count$iv$iv = headModifierNode;
                    stack$iv$iv = node$iv$iv6;
                    node3 = node$iv$iv$iv;
                    i9 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv6 = stack$iv$iv;
                    next$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv = 1;
                    count$iv$iv2++;
                    if (count$iv$iv2 == this_$iv$iv$iv) {
                    } else {
                    }
                    if (node$iv$iv3 == 0) {
                    } else {
                    }
                    node$iv$iv6 = stack$iv$iv;
                    i2 = count$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv5 = node$iv$iv3;
                    node5 = node$iv$iv6;
                    if (node5 != null) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv6;
                    if (node$iv$iv5 != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    node$iv$iv3 = node$iv$iv5;
                    stack$iv$iv = theNode$iv$iv;
                    count$iv$iv2 = i2;
                    node$iv$iv5.add(node3);
                    if (node$iv$iv5 != 0) {
                    }
                    node$iv$iv4 = 0;
                    node$iv$iv5.add(node5);
                    this_$iv$iv$iv2 = 0;
                    i10 = 16;
                    i4 = 0;
                    node$iv$iv6 = stack$iv$iv;
                    i2 = count$iv$iv2;
                    i6 = i10;
                    node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
                    stack$iv$iv = node3;
                    next$iv$iv = node3;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                    count$iv$iv2 = this_$iv$iv$iv;
                    this_$iv$iv$iv = stack$iv$iv;
                    node$iv$iv2 = 0;
                    headModifierNode = count$iv$iv;
                    if (this_$iv$iv$iv instanceof SuspendingPointerInputModifierNode) {
                    }
                    (SuspendingPointerInputModifierNode)(PointerInputModifierNode)this_$iv$iv$iv.resetPointerInputHandler();
                }
                headModifierNode = count$iv$iv;
                if (stack$iv$iv instanceof PointerInputModifierNode) {
                } else {
                }
                node4 = stack$iv$iv;
                i11 = 0;
                node = node4;
                if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                } else {
                }
                stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv3);
                context = value;
                count$iv$iv = headModifierNode;
                if (stack$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                node = 0;
                node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i9 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv6 = stack$iv$iv;
                    next$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv = 1;
                    count$iv$iv2++;
                    if (count$iv$iv2 == this_$iv$iv$iv) {
                    } else {
                    }
                    if (node$iv$iv3 == 0) {
                    } else {
                    }
                    node$iv$iv6 = stack$iv$iv;
                    i2 = count$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv5 = node$iv$iv3;
                    node5 = node$iv$iv6;
                    if (node5 != null) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv6;
                    if (node$iv$iv5 != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    node$iv$iv3 = node$iv$iv5;
                    stack$iv$iv = theNode$iv$iv;
                    count$iv$iv2 = i2;
                    node$iv$iv5.add(node3);
                    if (node$iv$iv5 != 0) {
                    }
                    node$iv$iv4 = 0;
                    node$iv$iv5.add(node5);
                    this_$iv$iv$iv2 = 0;
                    i10 = 16;
                    i4 = 0;
                    node$iv$iv6 = stack$iv$iv;
                    i2 = count$iv$iv2;
                    i6 = i10;
                    node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
                    stack$iv$iv = node3;
                    next$iv$iv = node3;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                }
                node$iv$iv6 = stack$iv$iv;
                if (count$iv$iv2 == 1) {
                } else {
                }
                stack$iv$iv = node$iv$iv6;
                context = value;
                count$iv$iv = headModifierNode;
                stack$iv$iv = node$iv$iv6;
                node3 = node$iv$iv$iv;
                i9 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                node$iv$iv6 = stack$iv$iv;
                next$iv$iv = node3;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv = 1;
                count$iv$iv2++;
                if (count$iv$iv2 == this_$iv$iv$iv) {
                } else {
                }
                if (node$iv$iv3 == 0) {
                } else {
                }
                node$iv$iv6 = stack$iv$iv;
                i2 = count$iv$iv2;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv5 = node$iv$iv3;
                node5 = node$iv$iv6;
                if (node5 != null) {
                } else {
                }
                node$iv$iv4 = node$iv$iv6;
                if (node$iv$iv5 != 0) {
                } else {
                }
                next$iv$iv = node3;
                node$iv$iv3 = node$iv$iv5;
                stack$iv$iv = theNode$iv$iv;
                count$iv$iv2 = i2;
                node$iv$iv5.add(node3);
                if (node$iv$iv5 != 0) {
                }
                node$iv$iv4 = 0;
                node$iv$iv5.add(node5);
                this_$iv$iv$iv2 = 0;
                i10 = 16;
                i4 = 0;
                node$iv$iv6 = stack$iv$iv;
                i2 = count$iv$iv2;
                i6 = i10;
                node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
                stack$iv$iv = node3;
                next$iv$iv = node3;
                this_$iv$iv$iv2 = this_$iv$iv$iv;
                count$iv$iv2 = this_$iv$iv$iv;
                this_$iv$iv$iv = stack$iv$iv;
                node$iv$iv2 = 0;
                headModifierNode = count$iv$iv;
                if (this_$iv$iv$iv instanceof SuspendingPointerInputModifierNode) {
                }
                (SuspendingPointerInputModifierNode)(PointerInputModifierNode)this_$iv$iv$iv.resetPointerInputHandler();
            }
            headModifierNode = count$iv$iv;
            if (kindSet$ui_release &= i15 != 0) {
            } else {
            }
            headModifierNode = count$iv$iv;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            stack$iv$iv = this;
            context = value;
            count$iv$iv = headModifierNode;
            i3 = 0;
            i7 = 0;
            node$iv$iv3 = 0;
            i19 = 0;
            stack$iv$iv = node$iv$iv2;
            while (stack$iv$iv != null) {
                if (stack$iv$iv instanceof PointerInputModifierNode) {
                } else {
                }
                node4 = stack$iv$iv;
                i11 = 0;
                node = node4;
                if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                } else {
                }
                stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv3);
                context = value;
                count$iv$iv = headModifierNode;
                if (stack$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                node = 0;
                node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i9 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv6 = stack$iv$iv;
                    next$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv = 1;
                    count$iv$iv2++;
                    if (count$iv$iv2 == this_$iv$iv$iv) {
                    } else {
                    }
                    if (node$iv$iv3 == 0) {
                    } else {
                    }
                    node$iv$iv6 = stack$iv$iv;
                    i2 = count$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv5 = node$iv$iv3;
                    node5 = node$iv$iv6;
                    if (node5 != null) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv6;
                    if (node$iv$iv5 != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    node$iv$iv3 = node$iv$iv5;
                    stack$iv$iv = theNode$iv$iv;
                    count$iv$iv2 = i2;
                    node$iv$iv5.add(node3);
                    if (node$iv$iv5 != 0) {
                    }
                    node$iv$iv4 = 0;
                    node$iv$iv5.add(node5);
                    this_$iv$iv$iv2 = 0;
                    i10 = 16;
                    i4 = 0;
                    node$iv$iv6 = stack$iv$iv;
                    i2 = count$iv$iv2;
                    i6 = i10;
                    node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
                    stack$iv$iv = node3;
                    next$iv$iv = node3;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                }
                node$iv$iv6 = stack$iv$iv;
                if (count$iv$iv2 == 1) {
                } else {
                }
                stack$iv$iv = node$iv$iv6;
                context = value;
                count$iv$iv = headModifierNode;
                stack$iv$iv = node$iv$iv6;
                node3 = node$iv$iv$iv;
                i9 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                node$iv$iv6 = stack$iv$iv;
                next$iv$iv = node3;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv = 1;
                count$iv$iv2++;
                if (count$iv$iv2 == this_$iv$iv$iv) {
                } else {
                }
                if (node$iv$iv3 == 0) {
                } else {
                }
                node$iv$iv6 = stack$iv$iv;
                i2 = count$iv$iv2;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv5 = node$iv$iv3;
                node5 = node$iv$iv6;
                if (node5 != null) {
                } else {
                }
                node$iv$iv4 = node$iv$iv6;
                if (node$iv$iv5 != 0) {
                } else {
                }
                next$iv$iv = node3;
                node$iv$iv3 = node$iv$iv5;
                stack$iv$iv = theNode$iv$iv;
                count$iv$iv2 = i2;
                node$iv$iv5.add(node3);
                if (node$iv$iv5 != 0) {
                }
                node$iv$iv4 = 0;
                node$iv$iv5.add(node5);
                this_$iv$iv$iv2 = 0;
                i10 = 16;
                i4 = 0;
                node$iv$iv6 = stack$iv$iv;
                i2 = count$iv$iv2;
                i6 = i10;
                node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
                stack$iv$iv = node3;
                next$iv$iv = node3;
                this_$iv$iv$iv2 = this_$iv$iv$iv;
                count$iv$iv2 = this_$iv$iv$iv;
                this_$iv$iv$iv = stack$iv$iv;
                node$iv$iv2 = 0;
                headModifierNode = count$iv$iv;
                if (this_$iv$iv$iv instanceof SuspendingPointerInputModifierNode) {
                }
                (SuspendingPointerInputModifierNode)(PointerInputModifierNode)this_$iv$iv$iv.resetPointerInputHandler();
            }
            headModifierNode = count$iv$iv;
            if (stack$iv$iv instanceof PointerInputModifierNode) {
            } else {
            }
            node4 = stack$iv$iv;
            i11 = 0;
            node = node4;
            if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
            } else {
            }
            count$iv$iv2 = 0;
            if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
            } else {
            }
            stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv3);
            context = value;
            count$iv$iv = headModifierNode;
            if (stack$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv2 = 0;
            node = 0;
            node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                node3 = node$iv$iv$iv;
                i9 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                node$iv$iv6 = stack$iv$iv;
                next$iv$iv = node3;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv = 1;
                count$iv$iv2++;
                if (count$iv$iv2 == this_$iv$iv$iv) {
                } else {
                }
                if (node$iv$iv3 == 0) {
                } else {
                }
                node$iv$iv6 = stack$iv$iv;
                i2 = count$iv$iv2;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv5 = node$iv$iv3;
                node5 = node$iv$iv6;
                if (node5 != null) {
                } else {
                }
                node$iv$iv4 = node$iv$iv6;
                if (node$iv$iv5 != 0) {
                } else {
                }
                next$iv$iv = node3;
                node$iv$iv3 = node$iv$iv5;
                stack$iv$iv = theNode$iv$iv;
                count$iv$iv2 = i2;
                node$iv$iv5.add(node3);
                if (node$iv$iv5 != 0) {
                }
                node$iv$iv4 = 0;
                node$iv$iv5.add(node5);
                this_$iv$iv$iv2 = 0;
                i10 = 16;
                i4 = 0;
                node$iv$iv6 = stack$iv$iv;
                i2 = count$iv$iv2;
                i6 = i10;
                node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
                stack$iv$iv = node3;
                next$iv$iv = node3;
                this_$iv$iv$iv2 = this_$iv$iv$iv;
            }
            node$iv$iv6 = stack$iv$iv;
            if (count$iv$iv2 == 1) {
            } else {
            }
            stack$iv$iv = node$iv$iv6;
            context = value;
            count$iv$iv = headModifierNode;
            stack$iv$iv = node$iv$iv6;
            node3 = node$iv$iv$iv;
            i9 = 0;
            i5 = 0;
            if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv$iv2 = 0;
            if (this_$iv$iv$iv2 != 0) {
            } else {
            }
            node$iv$iv6 = stack$iv$iv;
            next$iv$iv = node3;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            this_$iv$iv$iv = 1;
            count$iv$iv2++;
            if (count$iv$iv2 == this_$iv$iv$iv) {
            } else {
            }
            if (node$iv$iv3 == 0) {
            } else {
            }
            node$iv$iv6 = stack$iv$iv;
            i2 = count$iv$iv2;
            capacity$iv$iv$iv$iv = 0;
            node$iv$iv5 = node$iv$iv3;
            node5 = node$iv$iv6;
            if (node5 != null) {
            } else {
            }
            node$iv$iv4 = node$iv$iv6;
            if (node$iv$iv5 != 0) {
            } else {
            }
            next$iv$iv = node3;
            node$iv$iv3 = node$iv$iv5;
            stack$iv$iv = theNode$iv$iv;
            count$iv$iv2 = i2;
            node$iv$iv5.add(node3);
            if (node$iv$iv5 != 0) {
            }
            node$iv$iv4 = 0;
            node$iv$iv5.add(node5);
            this_$iv$iv$iv2 = 0;
            i10 = 16;
            i4 = 0;
            node$iv$iv6 = stack$iv$iv;
            i2 = count$iv$iv2;
            i6 = i10;
            node$iv$iv5 = new MutableVector(new Modifier.Node[i10], 0);
            stack$iv$iv = node3;
            next$iv$iv = node3;
            this_$iv$iv$iv2 = this_$iv$iv$iv;
            count$iv$iv2 = this_$iv$iv$iv;
            this_$iv$iv$iv = stack$iv$iv;
            node$iv$iv2 = 0;
            headModifierNode = count$iv$iv;
            if (this_$iv$iv$iv instanceof SuspendingPointerInputModifierNode) {
            }
            (SuspendingPointerInputModifierNode)(PointerInputModifierNode)this_$iv$iv$iv.resetPointerInputHandler();
            node$iv$iv = layout$iv$iv.getNodes$ui_release().getHead$ui_release();
        }
    }

    @Override // android.view.ViewGroup
    public final void setLastMatrixRecalculationAnimationTime$ui_release(long <set-?>) {
        this.lastMatrixRecalculationAnimationTime = <set-?>;
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners, Unit> callback) {
        final androidx.compose.ui.platform.AndroidComposeView.ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = callback;
        }
    }

    @Override // android.view.ViewGroup
    public void setShowLayoutBounds(boolean <set-?>) {
        this.showLayoutBounds = <set-?>;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return 0;
    }

    public Object textInputSession(Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation2) {
        boolean anon2;
        int i2;
        int i;
        int label;
        AtomicReference textInputSessionMutex;
        androidx.compose.ui.platform.AndroidComposeView.textInputSession.2 anon;
        Object obj6;
        Object obj7;
        anon2 = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof AndroidComposeView.textInputSession.1 && label2 &= i != 0) {
            anon2 = continuation2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon2.label = obj7 -= i;
            } else {
                anon2 = new AndroidComposeView.textInputSession.1(this, continuation2);
            }
        } else {
        }
        obj7 = anon2.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                androidx.compose.ui.platform.AndroidComposeView view = this;
                anon = new AndroidComposeView.textInputSession.2(view);
                anon2.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        obj6 = new KotlinNothingValueException();
        throw obj6;
    }
}
