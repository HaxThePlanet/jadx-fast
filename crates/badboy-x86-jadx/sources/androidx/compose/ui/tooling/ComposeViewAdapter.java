package androidx.compose.ui.tooling;

import _COROUTINE.ArtificialStackFrames;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.NodeGroup;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import androidx.compose.ui.unit.IntRect;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008*\u0004\u000b\u000e\u0011\u0014\u0008\u0000\u0018\u00002\u00020\u0001B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ \u0010Q\u001a\u00020(2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\u0008)H\u0003¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020UH\u0014J\r\u0010V\u001a\u00020(H\u0000¢\u0006\u0002\u0008WJ\u0008\u0010X\u001a\u00020(H\u0002J\u0008\u0010Y\u001a\u00020(H\u0002J\u0006\u0010:\u001a\u00020.J\u0010\u0010Z\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u009d\u0001\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00172\u0016\u0008\u0002\u0010]\u001a\u0010\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030_\u0018\u00010^2\u0008\u0008\u0002\u0010`\u001a\u00020\u00082\u0008\u0008\u0002\u0010-\u001a\u00020.2\u0008\u0008\u0002\u0010/\u001a\u00020.2\u0008\u0008\u0002\u0010a\u001a\u00020b2\u0008\u0008\u0002\u00109\u001a\u00020.2\u0008\u0008\u0002\u0010;\u001a\u00020.2\n\u0008\u0002\u00108\u001a\u0004\u0018\u00010\u00172\u000e\u0008\u0002\u0010c\u001a\u0008\u0012\u0004\u0012\u00020(0'2\u000e\u0008\u0002\u0010<\u001a\u0008\u0012\u0004\u0012\u00020(0'H\u0001¢\u0006\u0002\u0008dJ\u0008\u0010e\u001a\u00020(H\u0002J\u0008\u0010f\u001a\u00020(H\u0014J0\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u00082\u0006\u0010j\u001a\u00020\u00082\u0006\u0010k\u001a\u00020\u00082\u0006\u0010l\u001a\u00020\u0008H\u0014J\u0008\u0010m\u001a\u00020(H\u0002J\u000e\u0010n\u001a\u0004\u0018\u00010o*\u00020pH\u0002J\u0016\u0010q\u001a\u0004\u0018\u00010\u0017*\u00020K2\u0006\u0010r\u001a\u00020sH\u0002J\u000c\u0010t\u001a\u00020.*\u00020KH\u0002J\u000c\u0010u\u001a\u00020.*\u00020KH\u0002J\u001e\u0010v\u001a\u0004\u0018\u00010\u0017*\u00020p2\u0006\u0010w\u001a\u00020\u00082\u0006\u0010x\u001a\u00020\u0008H\u0002J\u000c\u0010y\u001a\u00020.*\u00020KH\u0002J\u000c\u0010z\u001a\u00020G*\u00020KH\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000cR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010%\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\u0008)0&X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008*\u0010\u001bR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R \u00102\u001a\u0008\u0012\u0004\u0012\u00020\u001703X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u000e\u00108\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u0008\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\u0008)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010ER \u0010F\u001a\u0008\u0012\u0004\u0012\u00020G03X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008H\u00105\"\u0004\u0008I\u00107R\u0018\u0010J\u001a\u00020\u0017*\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008L\u0010MR\u0018\u0010N\u001a\u00020\u0008*\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008O\u0010P¨\u0006{", d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FakeActivityResultRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1;", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1;", "FakeViewModelStoreOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1;", "TAG", "", "clock", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "getClock$ui_tooling_release$annotations", "()V", "getClock$ui_tooling_release", "()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "setClock$ui_tooling_release", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "composableName", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "composition", "Landroidx/compose/runtime/Composition;", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent$annotations", "debugBoundsPaint", "Landroid/graphics/Paint;", "debugPaintBounds", "", "debugViewInfos", "delayedException", "Landroidx/compose/ui/tooling/ThreadSafeException;", "designInfoList", "", "getDesignInfoList$ui_tooling_release", "()Ljava/util/List;", "setDesignInfoList$ui_tooling_release", "(Ljava/util/List;)V", "designInfoProvidersArgument", "forceCompositionInvalidation", "hasAnimations", "lookForDesignInfoProviders", "onDraw", "previewComposition", "Lkotlin/jvm/functions/Function2;", "slotTableRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "stitchTrees", "getStitchTrees$ui_tooling_release", "()Z", "setStitchTrees$ui_tooling_release", "(Z)V", "viewInfos", "Landroidx/compose/ui/tooling/ViewInfo;", "getViewInfos$ui_tooling_release", "setViewInfos$ui_tooling_release", "fileName", "Landroidx/compose/ui/tooling/data/Group;", "getFileName", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "lineNumber", "getLineNumber", "(Landroidx/compose/ui/tooling/data/Group;)I", "WrapPreview", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispose", "dispose$ui_tooling_release", "findAndTrackAnimations", "findDesignInfoProviders", "init", "className", "methodName", "parameterProvider", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "animationClockStartTime", "", "onCommit", "init$ui_tooling_release", "invalidateComposition", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "processViewInfos", "getDesignInfoMethodOrNull", "Ljava/lang/reflect/Method;", "", "getDesignInfoOrNull", "box", "Landroidx/compose/ui/unit/IntRect;", "hasDesignInfo", "hasNullSourcePosition", "invokeGetDesignInfo", "x", "y", "isNullGroup", "toViewInfo", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposeViewAdapter extends FrameLayout {

    public static final int $stable = 8;
    private final androidx.compose.ui.tooling.ComposeViewAdapter.FakeActivityResultRegistryOwner.1 FakeActivityResultRegistryOwner;
    private final androidx.compose.ui.tooling.ComposeViewAdapter.FakeOnBackPressedDispatcherOwner.1 FakeOnBackPressedDispatcherOwner;
    private final androidx.compose.ui.tooling.ComposeViewAdapter.FakeSavedStateRegistryOwner.1 FakeSavedStateRegistryOwner;
    private final androidx.compose.ui.tooling.ComposeViewAdapter.FakeViewModelStoreOwner.1 FakeViewModelStoreOwner;
    private final String TAG;
    public PreviewAnimationClock clock;
    private String composableName;
    private final ComposeView composeView;
    private Composition composition;
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;
    private final androidx.compose.ui.tooling.ThreadSafeException delayedException;
    private List<String> designInfoList;
    private String designInfoProvidersArgument;
    private boolean forceCompositionInvalidation;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;
    private Function0<Unit> onDraw;
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;
    private final androidx.compose.ui.tooling.CompositionDataRecord slotTableRecord;
    private boolean stitchTrees = true;
    private List<androidx.compose.ui.tooling.ViewInfo> viewInfos;
    static {
        final int i = 8;
    }

    public ComposeViewAdapter(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.TAG = "ComposeViewAdapter";
        ComposeView composeView = new ComposeView(getContext(), 0, 0, 6, 0);
        this.composeView = composeView;
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        String str2 = "";
        this.composableName = str2;
        ThreadSafeException threadSafeException = new ThreadSafeException();
        this.delayedException = threadSafeException;
        this.previewComposition = ComposableSingletons.ComposeViewAdapter_androidKt.INSTANCE.getLambda-2$ui_tooling_release();
        int i3 = 0;
        this.content = SnapshotStateKt.mutableStateOf$default(ComposeViewAdapter_androidKt.access$getEmptyContent$p(), i3, 2, i3);
        this.designInfoProvidersArgument = str2;
        this.onDraw = (Function0)ComposeViewAdapter.onDraw.1.INSTANCE;
        int i2 = 1;
        Paint paint = new Paint();
        Paint paint2 = paint;
        int i4 = 0;
        int i7 = 0;
        float[] fArr = new float[4];
        fArr = new int[]{1084227584, 1092616192, 1097859072, 1101004800};
        DashPathEffect dashPathEffect = new DashPathEffect(fArr, 0);
        paint2.setPathEffect((PathEffect)dashPathEffect);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(ColorKt.toArgb-8_81llA(Color.Companion.getRed-0d7_KjU()));
        this.debugBoundsPaint = paint;
        ComposeViewAdapter.FakeSavedStateRegistryOwner.1 anon = new ComposeViewAdapter.FakeSavedStateRegistryOwner.1();
        this.FakeSavedStateRegistryOwner = anon;
        ComposeViewAdapter.FakeViewModelStoreOwner.1 anon2 = new ComposeViewAdapter.FakeViewModelStoreOwner.1();
        this.FakeViewModelStoreOwner = anon2;
        ComposeViewAdapter.FakeOnBackPressedDispatcherOwner.1 anon3 = new ComposeViewAdapter.FakeOnBackPressedDispatcherOwner.1(this);
        this.FakeOnBackPressedDispatcherOwner = anon3;
        ComposeViewAdapter.FakeActivityResultRegistryOwner.1 anon4 = new ComposeViewAdapter.FakeActivityResultRegistryOwner.1();
        this.FakeActivityResultRegistryOwner = anon4;
        init(attrs);
    }

    public ComposeViewAdapter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.TAG = "ComposeViewAdapter";
        ComposeView composeView = new ComposeView(getContext(), 0, 0, 6, 0);
        this.composeView = composeView;
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        String str2 = "";
        this.composableName = str2;
        ThreadSafeException threadSafeException = new ThreadSafeException();
        this.delayedException = threadSafeException;
        this.previewComposition = ComposableSingletons.ComposeViewAdapter_androidKt.INSTANCE.getLambda-2$ui_tooling_release();
        int i3 = 0;
        this.content = SnapshotStateKt.mutableStateOf$default(ComposeViewAdapter_androidKt.access$getEmptyContent$p(), i3, 2, i3);
        this.designInfoProvidersArgument = str2;
        this.onDraw = (Function0)ComposeViewAdapter.onDraw.1.INSTANCE;
        int i2 = 1;
        Paint paint = new Paint();
        Paint paint2 = paint;
        int i4 = 0;
        int i7 = 0;
        float[] fArr = new float[4];
        fArr = new int[]{1084227584, 1092616192, 1097859072, 1101004800};
        DashPathEffect dashPathEffect = new DashPathEffect(fArr, 0);
        paint2.setPathEffect((PathEffect)dashPathEffect);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(ColorKt.toArgb-8_81llA(Color.Companion.getRed-0d7_KjU()));
        this.debugBoundsPaint = paint;
        ComposeViewAdapter.FakeSavedStateRegistryOwner.1 anon = new ComposeViewAdapter.FakeSavedStateRegistryOwner.1();
        this.FakeSavedStateRegistryOwner = anon;
        ComposeViewAdapter.FakeViewModelStoreOwner.1 anon2 = new ComposeViewAdapter.FakeViewModelStoreOwner.1();
        this.FakeViewModelStoreOwner = anon2;
        ComposeViewAdapter.FakeOnBackPressedDispatcherOwner.1 anon3 = new ComposeViewAdapter.FakeOnBackPressedDispatcherOwner.1(this);
        this.FakeOnBackPressedDispatcherOwner = anon3;
        ComposeViewAdapter.FakeActivityResultRegistryOwner.1 anon4 = new ComposeViewAdapter.FakeActivityResultRegistryOwner.1();
        this.FakeActivityResultRegistryOwner = anon4;
        init(attrs);
    }

    private final void WrapPreview(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i3;
        int i2;
        int rememberComposableLambda;
        boolean traceInProgress;
        int i;
        int i4;
        int str;
        traceInProgress2 = 522143116;
        final Composer obj8 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj8, "C(WrapPreview)442@16450L61,437@16083L428:ComposeViewAdapter.android.kt#hevd2p");
        i = 4;
        i4 = 2;
        if ($changed & 6 == 0) {
            i3 = obj8.changedInstance(content) ? i : i4;
            $dirty |= i3;
        }
        if ($changed & 48 == 0) {
            i2 = obj8.changedInstance(this) ? 32 : 16;
            $dirty |= i2;
        }
        if ($dirty & 19 == 18) {
            if (!obj8.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.android.kt:432)");
                }
                ProvidedValue[] arr = new ProvidedValue[i];
                LayoutlibFontResourceLoader layoutlibFontResourceLoader = new LayoutlibFontResourceLoader(getContext());
                arr[0] = CompositionLocalsKt.getLocalFontLoader().provides(layoutlibFontResourceLoader);
                int i6 = 1;
                arr[i6] = CompositionLocalsKt.getLocalFontFamilyResolver().provides(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
                arr[i4] = LocalOnBackPressedDispatcherOwner.INSTANCE.provides((OnBackPressedDispatcherOwner)this.FakeOnBackPressedDispatcherOwner);
                arr[3] = LocalActivityResultRegistryOwner.INSTANCE.provides((ActivityResultRegistryOwner)this.FakeActivityResultRegistryOwner);
                ComposeViewAdapter.WrapPreview.1 anon = new ComposeViewAdapter.WrapPreview.1(this, content);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1475548980, i6, anon, obj8, 54), obj8, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj8.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj8.endRestartGroup();
        if (endRestartGroup != null) {
            rememberComposableLambda = new ComposeViewAdapter.WrapPreview.2(this, content, $changed);
            endRestartGroup.updateScope((Function2)rememberComposableLambda);
        }
    }

    public static final void access$WrapPreview(androidx.compose.ui.tooling.ComposeViewAdapter $this, Function2 content, Composer $composer, int $changed) {
        $this.WrapPreview(content, $composer, $changed);
    }

    public static final androidx.compose.ui.tooling.ThreadSafeException access$getDelayedException$p(androidx.compose.ui.tooling.ComposeViewAdapter $this) {
        return $this.delayedException;
    }

    public static final androidx.compose.ui.tooling.ComposeViewAdapter.FakeSavedStateRegistryOwner.1 access$getFakeSavedStateRegistryOwner$p(androidx.compose.ui.tooling.ComposeViewAdapter $this) {
        return $this.FakeSavedStateRegistryOwner;
    }

    public static final androidx.compose.ui.tooling.CompositionDataRecord access$getSlotTableRecord$p(androidx.compose.ui.tooling.ComposeViewAdapter $this) {
        return $this.slotTableRecord;
    }

    public static final boolean access$hasDesignInfo(androidx.compose.ui.tooling.ComposeViewAdapter $this, Group $receiver) {
        return $this.hasDesignInfo($receiver);
    }

    private final void findAndTrackAnimations() {
        int i2;
        boolean hasAnimations;
        Object next;
        Group it;
        int i;
        java.util.Set store = this.slotTableRecord.getStore();
        int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)store, 10));
        int i6 = 0;
        final Iterator iterator = store.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList.add(SlotTreeKt.asTree((CompositionData)next));
        }
        i2 = this.clock != null ? 1 : 0;
        ComposeViewAdapter.findAndTrackAnimations.1 anon = new ComposeViewAdapter.findAndTrackAnimations.1(this);
        ComposeViewAdapter.findAndTrackAnimations.2 anon2 = new ComposeViewAdapter.findAndTrackAnimations.2(this);
        AnimationSearch animationSearch = new AnimationSearch((Function0)anon, (Function0)anon2);
        int i5 = 0;
        this.hasAnimations = animationSearch.searchAny((Collection)(List)arrayList);
        if (i2 != 0 && this.hasAnimations) {
            if (this.hasAnimations) {
                animationSearch.attachAllAnimations((Collection)arrayList);
            }
        }
    }

    private final void findDesignInfoProviders() {
        ArrayList list$iv$iv;
        Object $this$flatMap$iv;
        int i5;
        String designInfoOrNull;
        Iterator iterator2;
        Object next;
        Group it2;
        int i6;
        int i3;
        List all;
        int i;
        ArrayList arrayList;
        List list2;
        int i9;
        List list;
        int i2;
        Iterator iterator;
        boolean next3;
        Object obj;
        int i7;
        ArrayList $this$flatMap$iv2;
        int i4;
        int i8;
        int next2;
        Object group;
        Iterator it;
        final Object obj2 = this;
        java.util.Set store = obj2.slotTableRecord.getStore();
        int i10 = 0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)store, 10));
        int i12 = 0;
        Iterator iterator3 = store.iterator();
        for (Object next : iterator3) {
            i6 = 0;
            (Collection)arrayList2.add(SlotTreeKt.asTree((CompositionData)next));
        }
        i5 = 0;
        ArrayList arrayList3 = new ArrayList();
        int i13 = 0;
        Iterator iterator4 = (Iterable)(List)arrayList2.iterator();
        for (Object it2 : iterator4) {
            i3 = 0;
            ComposeViewAdapter.findDesignInfoProviders.1.1 anon = new ComposeViewAdapter.findDesignInfoProviders.1.1(obj2);
            i = 0;
            arrayList = new ArrayList();
            i9 = 0;
            i2 = 0;
            iterator = (Iterable)PreviewUtils_androidKt.findAll((Group)it2, (Function1)anon).iterator();
            while (iterator.hasNext()) {
                i7 = 0;
                $this$flatMap$iv = obj;
                i4 = 0;
                if (obj2.getDesignInfoOrNull($this$flatMap$iv, (Group)$this$flatMap$iv.getBox()) == null) {
                } else {
                }
                group = $this$flatMap$iv;
                if (designInfoOrNull != null) {
                }
                list$iv$iv = $this$flatMap$iv2;
                i5 = i8;
                $this$flatMap$iv = 0;
                (Collection)arrayList.add(designInfoOrNull);
                iterator2 = (Iterable)$this$flatMap$iv.getChildren().iterator();
                for (Object next6 : iterator2) {
                    group = $this$flatMap$iv;
                    next2 = 0;
                    $this$flatMap$iv = group;
                    iterator2 = it;
                }
                group = $this$flatMap$iv;
                designInfoOrNull = 0;
                group = $this$flatMap$iv;
                next2 = 0;
                if (obj2.getDesignInfoOrNull((Group)iterator2.next(), group.getBox()) != null) {
                } else {
                }
                $this$flatMap$iv = group;
                iterator2 = it;
            }
            i8 = i5;
            CollectionsKt.addAll((Collection)arrayList3, (Iterable)(List)arrayList);
            list$iv$iv = $this$flatMap$iv2;
            i7 = 0;
            $this$flatMap$iv = obj;
            i4 = 0;
            if (obj2.getDesignInfoOrNull($this$flatMap$iv, (Group)$this$flatMap$iv.getBox()) == null) {
            } else {
            }
            group = $this$flatMap$iv;
            if (designInfoOrNull != null) {
            }
            list$iv$iv = $this$flatMap$iv2;
            i5 = i8;
            $this$flatMap$iv = 0;
            arrayList.add(designInfoOrNull);
            iterator2 = (Iterable)$this$flatMap$iv.getChildren().iterator();
            for (Object next6 : iterator2) {
                group = $this$flatMap$iv;
                next2 = 0;
                $this$flatMap$iv = group;
                iterator2 = it;
            }
            group = $this$flatMap$iv;
            designInfoOrNull = 0;
            group = $this$flatMap$iv;
            next2 = 0;
            if (obj2.getDesignInfoOrNull((Group)iterator2.next(), group.getBox()) != null) {
            } else {
            }
            $this$flatMap$iv = group;
            iterator2 = it;
        }
        ArrayList $this$flatMap$iv4 = list$iv$iv;
        obj2.designInfoList = (List)arrayList3;
    }

    public static void getClock$ui_tooling_release$annotations() {
    }

    private static void getContent$annotations() {
    }

    private final Method getDesignInfoMethodOrNull(Object $this$getDesignInfoMethodOrNull) {
        Method declaredMethod;
        String str;
        Class[] arr = new Class[3];
        declaredMethod = $this$getDesignInfoMethodOrNull.getClass().getDeclaredMethod("getDesignInfo", Integer.TYPE, Integer.TYPE, String.class);
        return declaredMethod;
    }

    private final String getDesignInfoOrNull(Group $this$getDesignInfoOrNull, IntRect box) {
        Object next;
        int getDesignInfo;
        int i;
        int right;
        Iterator iterator = (Iterable)$this$getDesignInfoOrNull.getData().iterator();
        getDesignInfo = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            i = 0;
            if (next != null) {
            }
            if (getDesignInfo == 0) {
            }
            getDesignInfo = 0;
            getDesignInfo = invokeGetDesignInfo(next, box.getLeft(), box.getRight());
        }
        return getDesignInfo;
    }

    private final String getFileName(Group $this$fileName) {
        String sourceFile;
        sourceFile = $this$fileName.getLocation();
        if (sourceFile != null) {
            if (sourceFile.getSourceFile() == null) {
                sourceFile = "";
            }
        } else {
        }
        return sourceFile;
    }

    private final int getLineNumber(Group $this$lineNumber) {
        int lineNumber;
        SourceLocation location = $this$lineNumber.getLocation();
        if (location != null) {
            lineNumber = location.getLineNumber();
        } else {
            lineNumber = -1;
        }
        return lineNumber;
    }

    private final boolean hasDesignInfo(Group $this$hasDesignInfo) {
        boolean iterator;
        int i;
        boolean next;
        int it;
        int i3;
        Method designInfoMethodOrNull;
        int i2;
        final Collection data = $this$hasDesignInfo.getData();
        final int i4 = 0;
        if (data instanceof Collection != null && (Collection)(Iterable)data.isEmpty()) {
            if ((Collection)data.isEmpty()) {
            } else {
                iterator = data.iterator();
                while (iterator.hasNext()) {
                    Object obj = next;
                    i3 = 0;
                    if (obj != null) {
                    } else {
                    }
                    designInfoMethodOrNull = 0;
                    i2 = 1;
                    if (designInfoMethodOrNull != null) {
                    } else {
                    }
                    it = i;
                    it = i2;
                    designInfoMethodOrNull = getDesignInfoMethodOrNull(obj);
                }
            }
        } else {
        }
        return i;
    }

    private final boolean hasNullSourcePosition(Group $this$hasNullSourcePosition) {
        int lineNumber;
        int i;
        int i2;
        final int i3 = 0;
        lineNumber = (CharSequence)getFileName($this$hasNullSourcePosition).length() == null ? i : i3;
        if (lineNumber != 0 && getLineNumber($this$hasNullSourcePosition) == -1) {
            if (getLineNumber($this$hasNullSourcePosition) == -1) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    private final void init(AttributeSet attrs) {
        String attributeValue;
        int previewProviderClass;
        long long;
        final Object obj3 = this;
        Object obj4 = attrs;
        ViewTreeLifecycleOwner.set((View)obj3, (LifecycleOwner)obj3.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set((View)obj3, (SavedStateRegistryOwner)obj3.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set((View)obj3, (ViewModelStoreOwner)obj3.FakeViewModelStoreOwner);
        obj3.addView((View)obj3.composeView);
        String str7 = "http://schemas.android.com/tools";
        String attributeValue2 = obj4.getAttributeValue(str7, "composableName");
        if (attributeValue2 == null) {
        }
        String str9 = attributeValue2;
        int i = 46;
        previewProviderClass = 0;
        int i2 = 2;
        int i3 = 0;
        final int attributeIntValue = obj4.getAttributeIntValue(str7, "parameterProviderIndex", i3);
        String attributeValue3 = obj4.getAttributeValue(str7, "parameterProviderClass");
        if (attributeValue3 != null) {
            previewProviderClass = PreviewUtils_androidKt.asPreviewProviderClass(attributeValue3);
        }
        long = Long.parseLong(obj4.getAttributeValue(str7, "animationClockStartTime"));
        final String str15 = animationClockStartTime;
        ComposeViewAdapter.init$ui_tooling_release$default(obj3, StringsKt.substringBeforeLast$default(str9, i, previewProviderClass, i2, previewProviderClass), StringsKt.substringAfterLast$default(str9, i, previewProviderClass, i2, previewProviderClass), previewProviderClass, attributeIntValue, obj4.getAttributeBooleanValue(str7, "paintBounds", obj3.debugPaintBounds), obj4.getAttributeBooleanValue(str7, "printViewInfos", obj3.debugViewInfos), long, attributeIntValue, obj4.getAttributeBooleanValue(str7, "forceCompositionInvalidation", i3), obj4.getAttributeBooleanValue(str7, "findDesignInfoProviders", obj3.lookForDesignInfoProviders), obj4.getAttributeValue(str7, "designInfoProvidersArgument"), 0, 0, 3072);
    }

    public static void init$ui_tooling_release$default(androidx.compose.ui.tooling.ComposeViewAdapter composeViewAdapter, String string2, String string3, Class class4, int i5, boolean z6, boolean z7, long l8, boolean z9, boolean z10, String string11, Function0 function012, Function0 function013, int i14, Object object15) {
        androidx.compose.ui.tooling.ComposeViewAdapter.init.2 iNSTANCE2;
        androidx.compose.ui.tooling.ComposeViewAdapter.init.1 iNSTANCE;
        int i6;
        int i3;
        int i;
        int i2;
        int i10;
        int i4;
        int i7;
        int i8;
        int i9;
        androidx.compose.ui.tooling.ComposeViewAdapter.init.1 view2;
        androidx.compose.ui.tooling.ComposeViewAdapter.init.2 view;
        int i11 = object15;
        final int i21 = 0;
        i3 = i11 & 4 != 0 ? i21 : class4;
        int i22 = 0;
        i = i11 & 8 != 0 ? i22 : i5;
        i2 = i11 & 16 != 0 ? i22 : z6;
        i10 = i11 & 32 != 0 ? i22 : z7;
        i4 = i11 & 64 != 0 ? i6 : l8;
        i7 = i11 & 128 != 0 ? i22 : z10;
        i8 = i11 & 256 != 0 ? i22 : string11;
        i9 = i11 & 512 != 0 ? i21 : function012;
        if (i11 & 1024 != 0) {
            view2 = iNSTANCE;
        } else {
            view2 = function013;
        }
        if (i11 &= 2048 != 0) {
            view = iNSTANCE2;
        } else {
            view = i14;
        }
        composeViewAdapter.init$ui_tooling_release(string2, string3, i3, i, i2, i10, i4, obj11, i7, i8, i9, view2);
    }

    private final void invalidateComposition() {
        this.content.setValue(ComposableSingletons.ComposeViewAdapter_androidKt.INSTANCE.getLambda-3$ui_tooling_release());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    private final String invokeGetDesignInfo(Object $this$invokeGetDesignInfo, int x, int y) {
        int i2;
        int i3;
        Object invoke;
        Object obj;
        int i;
        final Method designInfoMethodOrNull = getDesignInfoMethodOrNull($this$invokeGetDesignInfo);
        if (designInfoMethodOrNull != null) {
            i3 = 0;
            invoke = designInfoMethodOrNull.invoke($this$invokeGetDesignInfo, /* result */);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            i = (CharSequence)(String)invoke.length() == 0 ? 1 : 0;
            if (i != 0) {
                int i4 = 0;
                obj = i2;
            }
            i2 = obj;
        }
        return i2;
    }

    private final boolean isNullGroup(Group $this$isNullGroup) {
        int i;
        Group group;
        int nullSourcePosition;
        int i2;
        boolean z;
        if (hasNullSourcePosition($this$isNullGroup) && $this$isNullGroup.getChildren().isEmpty()) {
            if ($this$isNullGroup.getChildren().isEmpty()) {
                i2 = 0;
                if ($this$isNullGroup instanceof NodeGroup) {
                    group = $this$isNullGroup;
                } else {
                    group = i2;
                }
                if (group != null) {
                    nullSourcePosition = group.getNode();
                } else {
                    nullSourcePosition = i2;
                }
                if (nullSourcePosition instanceof LayoutInfo) {
                    i2 = nullSourcePosition;
                }
                i = i2 == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private final void processViewInfos() {
        List stitchTrees;
        boolean debugString$default;
        Object arrayList;
        java.util.Set set;
        int i2;
        Object next;
        androidx.compose.ui.tooling.ViewInfo it;
        int i;
        Group tree;
        java.util.Set store = this.slotTableRecord.getStore();
        int i3 = 0;
        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)store, 10));
        i2 = 0;
        final Iterator iterator = store.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList.add(toViewInfo(SlotTreeKt.asTree((CompositionData)next)));
        }
        List list = CollectionsKt.toList((Iterable)(List)arrayList);
        if (this.stitchTrees) {
            stitchTrees = ShadowViewInfo_androidKt.stitchTrees(list);
        } else {
            stitchTrees = list;
        }
        this.viewInfos = stitchTrees;
        if (this.debugViewInfos) {
            i2 = 0;
            Log.d(this.TAG, ViewInfoUtil_androidKt.toDebugString$default(this.viewInfos, 0, i2, 3, i2));
        }
    }

    private final androidx.compose.ui.tooling.ViewInfo toViewInfo(Group $this$toViewInfo) {
        Object obj;
        Object node;
        int nullSourcePosition;
        String sourceFile;
        int lineNumber;
        int i;
        Object next2;
        boolean next;
        Object it;
        int i2;
        boolean nullGroup;
        i = 0;
        if ($this$toViewInfo instanceof NodeGroup) {
            obj = $this$toViewInfo;
        } else {
            obj = i;
        }
        if (obj != null) {
            node = obj.getNode();
        } else {
            node = i;
        }
        if (node instanceof LayoutInfo) {
            i = node;
        }
        final int i10 = i;
        if ($this$toViewInfo.getChildren().size() == 1 && hasNullSourcePosition($this$toViewInfo) && i10 == 0) {
            if (hasNullSourcePosition($this$toViewInfo)) {
                if (i10 == 0) {
                    return toViewInfo((Group)CollectionsKt.single((Iterable)$this$toViewInfo.getChildren()));
                }
            }
        }
        int i5 = 0;
        ArrayList arrayList2 = new ArrayList();
        int i7 = 0;
        Iterator iterator = (Iterable)$this$toViewInfo.getChildren().iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            i2 = 0;
            if (!isNullGroup((Group)next2)) {
            }
            (Collection)arrayList2.add(next2);
        }
        int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)(List)arrayList2, 10));
        int i8 = 0;
        Iterator iterator2 = arrayList2.iterator();
        for (Object next : iterator2) {
            i2 = 0;
            (Collection)arrayList.add(toViewInfo((Group)next));
        }
        sourceFile = $this$toViewInfo.getLocation();
        if (sourceFile != null) {
            if (sourceFile.getSourceFile() == null) {
                sourceFile = "";
            }
        } else {
        }
        SourceLocation location = $this$toViewInfo.getLocation();
        if (location != null) {
            lineNumber = location.getLineNumber();
        } else {
            lineNumber = -1;
        }
        ViewInfo viewInfo2 = new ViewInfo(sourceFile, lineNumber, $this$toViewInfo.getBox(), $this$toViewInfo.getLocation(), (List)arrayList, i10);
        return viewInfo2;
    }

    @Override // android.widget.FrameLayout
    protected void dispatchDraw(Canvas canvas) {
        List next;
        int i;
        Iterator iterator;
        Object next2;
        boolean bounds;
        List it;
        int rect;
        List debugBoundsPaint;
        List allChildren;
        int right;
        int bottom;
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            invalidateComposition();
        }
        this.onDraw.invoke();
        if (!this.debugPaintBounds) {
        }
        int i3 = 0;
        ArrayList arrayList = new ArrayList();
        i = 0;
        iterator = (Iterable)this.viewInfos.iterator();
        for (Object next2 : iterator) {
            Object obj = next2;
            rect = 0;
            CollectionsKt.addAll((Collection)arrayList, (Iterable)CollectionsKt.plus((Collection)CollectionsKt.listOf((ViewInfo)obj), (Iterable)obj.allChildren()));
        }
        int i2 = 0;
        Iterator iterator2 = (Iterable)(List)arrayList.iterator();
        while (iterator2.hasNext()) {
            i = next;
            iterator = null;
            if ((ViewInfo)i.hasBounds()) {
            }
            it = 0;
            rect = new Rect(i.getBounds().getLeft(), i.getBounds().getTop(), i.getBounds().getRight(), i.getBounds().getBottom());
            canvas.drawRect(rect, this.debugBoundsPaint);
        }
    }

    @Override // android.widget.FrameLayout
    public final void dispose$ui_tooling_release() {
        PreviewAnimationClock clock$ui_tooling_release;
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock$ui_tooling_release().dispose();
        }
        this.FakeSavedStateRegistryOwner.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        this.FakeViewModelStoreOwner.getViewModelStore().clear();
    }

    @Override // android.widget.FrameLayout
    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock clock = this.clock;
        if (clock != null) {
            return clock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    @Override // android.widget.FrameLayout
    public final boolean getStitchTrees$ui_tooling_release() {
        return this.stitchTrees;
    }

    public final List<androidx.compose.ui.tooling.ViewInfo> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    @Override // android.widget.FrameLayout
    public final boolean hasAnimations() {
        return this.hasAnimations;
    }

    public final void init$ui_tooling_release(String className, String methodName, Class<? extends PreviewParameterProvider<?>> parameterProvider, int parameterProviderIndex, boolean debugPaintBounds, boolean debugViewInfos, long animationClockStartTime, boolean forceCompositionInvalidation, boolean lookForDesignInfoProviders, String designInfoProvidersArgument, Function0<Unit> onCommit, Function0<Unit> onDraw) {
        String str;
        this.debugPaintBounds = debugPaintBounds;
        this.debugViewInfos = debugViewInfos;
        final String str3 = methodName;
        this.composableName = str3;
        this.forceCompositionInvalidation = lookForDesignInfoProviders;
        this.lookForDesignInfoProviders = designInfoProvidersArgument;
        str = onCommit == null ? "" : onCommit;
        this.designInfoProvidersArgument = str;
        this.onDraw = obj27;
        ComposeViewAdapter.init.3 anon = new ComposeViewAdapter.init.3(onDraw, this, className, str3, parameterProvider, parameterProviderIndex, animationClockStartTime, obj10);
        this.previewComposition = (Function2)ComposableLambdaKt.composableLambdaInstance(-2046245106, true, anon);
        this.composeView.setContent(this.previewComposition);
        invalidate();
    }

    @Override // android.widget.FrameLayout
    protected void onAttachedToWindow() {
        ViewTreeLifecycleOwner.set(this.composeView.getRootView(), (LifecycleOwner)this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int lookForDesignInfoProviders;
        super.onLayout(changed, left, top, right, bottom);
        final int i = bottom;
        final int obj7 = right;
        final int obj6 = top;
        final int obj5 = left;
        final boolean obj4 = changed;
        final Object obj3 = this;
        obj3.delayedException.throwIfPresent();
        processViewInfos();
        lookForDesignInfoProviders = (CharSequence)obj3.composableName.length() > 0 ? 1 : 0;
        findAndTrackAnimations();
        if (lookForDesignInfoProviders != 0 && obj3.lookForDesignInfoProviders) {
            findAndTrackAnimations();
            if (obj3.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    @Override // android.widget.FrameLayout
    public final void setClock$ui_tooling_release(PreviewAnimationClock <set-?>) {
        this.clock = <set-?>;
    }

    public final void setDesignInfoList$ui_tooling_release(List<String> <set-?>) {
        this.designInfoList = <set-?>;
    }

    @Override // android.widget.FrameLayout
    public final void setStitchTrees$ui_tooling_release(boolean <set-?>) {
        this.stitchTrees = <set-?>;
    }

    public final void setViewInfos$ui_tooling_release(List<androidx.compose.ui.tooling.ViewInfo> <set-?>) {
        this.viewInfos = <set-?>;
    }
}
