package androidx.compose.ui.contentcapture;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationRequest.Builder;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.ArraySet;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.util.LongSparseArrayKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002~\u007fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010>\u001a\u00020\u000eH\u0080@¢\u0006\u0004\u0008?\u0010@J\u001a\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020C2\u0008\u0010D\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010E\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CH\u0002J\u0016\u0010F\u001a\u00020\u000e2\u000c\u0010G\u001a\u0008\u0012\u0004\u0012\u00020!0 H\u0002J\u0008\u0010H\u001a\u00020\u000eH\u0002J\u0008\u0010I\u001a\u00020\u000eH\u0002J\u0008\u0010J\u001a\u00020\u000eH\u0002J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u000209H\u0002J\r\u0010M\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008NJ-\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u000e\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0UH\u0001¢\u0006\u0002\u0008WJ\r\u0010X\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008YJ\u0015\u0010Z\u001a\u00020\u000e2\u0006\u0010L\u001a\u000209H\u0000¢\u0006\u0002\u0008[J\r\u0010\\\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008]J\r\u0010^\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008_J\u0010\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010d\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020fH\u0016J%\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00002\u000e\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0kH\u0001¢\u0006\u0002\u0008mJ\u0018\u0010n\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u000205H\u0002J\u0018\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020C2\u0006\u0010t\u001a\u00020uH\u0002J\u0018\u0010v\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u000205H\u0002J\u0008\u0010w\u001a\u00020\u000eH\u0002J\u0010\u0010x\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\u0010\u0010z\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\u0008\u0010{\u001a\u00020\u000eH\u0002J\u0010\u0010|\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\u000e\u0010}\u001a\u0004\u0018\u00010\u0011*\u00020pH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u0004\u0018\u00010\u00088\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\"\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\u000e\u0010&\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u001a\u0010,\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008-\u0010\u001a\u001a\u0004\u0008.\u0010/R\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R\u0014\u00104\u001a\u0008\u0012\u0004\u0012\u0002050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0008\u0012\u0004\u0012\u00020908X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010=¨\u0006\u0080\u0001", d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "onContentCaptureSession", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function0;)V", "SendRecurringContentCaptureEventsIntervalMillis", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "bufferedAppearedNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "bufferedDisappearedNodes", "Landroidx/collection/MutableIntSet;", "checkingForSemanticsChanges", "", "contentCaptureChangeChecker", "Ljava/lang/Runnable;", "contentCaptureSession", "getContentCaptureSession$ui_release$annotations", "()V", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui_release", "()Landroidx/collection/IntObjectMap;", "setCurrentSemanticsNodes$ui_release", "(Landroidx/collection/IntObjectMap;)V", "currentSemanticsNodesInvalidated", "currentSemanticsNodesSnapshotTimestampMillis", "handler", "Landroid/os/Handler;", "getHandler$ui_release", "()Landroid/os/Handler;", "isEnabled", "isEnabled$ui_release$annotations", "isEnabled$ui_release", "()Z", "getOnContentCaptureSession", "()Lkotlin/jvm/functions/Function0;", "setOnContentCaptureSession", "(Lkotlin/jvm/functions/Function0;)V", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "translateStatus", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferContentCaptureViewAppeared", "virtualId", "", "viewStructure", "bufferContentCaptureViewDisappeared", "checkForContentCapturePropertyChanges", "newSemanticsNodes", "clearTranslatedText", "hideTranslatedText", "notifyContentCaptureChanges", "notifySubtreeStateChangeIfNeeded", "layoutNode", "onClearTranslation", "onClearTranslation$ui_release", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onCreateVirtualViewTranslationRequests$ui_release", "onHideTranslation", "onHideTranslation$ui_release", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "onShowTranslation", "onShowTranslation$ui_release", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "onVirtualViewTranslationResponses", "contentCaptureManager", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onVirtualViewTranslationResponses$ui_release", "sendContentCaptureStructureChangeEvents", "newNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "oldNode", "sendContentCaptureTextUpdateEvent", "id", "newText", "", "sendSemanticsStructureChangeEvents", "showTranslatedText", "updateBuffersOnAppeared", "node", "updateBuffersOnDisappeared", "updateSemanticsCopy", "updateTranslationOnAppeared", "toViewStructure", "TranslateStatus", "ViewTranslationHelperMethods", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidContentCaptureManager implements androidx.compose.ui.contentcapture.ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {

    public static final int $stable = 8;
    private long SendRecurringContentCaptureEventsIntervalMillis = 100;
    private final Channel<Unit> boundsUpdateChannel;
    private final MutableIntObjectMap<ViewStructureCompat> bufferedAppearedNodes;
    private final MutableIntSet bufferedDisappearedNodes;
    private boolean checkingForSemanticsChanges;
    private final Runnable contentCaptureChangeChecker;
    private ContentCaptureSessionCompat contentCaptureSession;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated = true;
    private long currentSemanticsNodesSnapshotTimestampMillis;
    private final Handler handler;
    private Function0<? extends ContentCaptureSessionCompat> onContentCaptureSession;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private androidx.compose.ui.contentcapture.AndroidContentCaptureManager.TranslateStatus translateStatus;
    private final AndroidComposeView view;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static enum TranslateStatus {

        SHOW_ORIGINAL,
        SHOW_TRANSLATED;
        private static final androidx.compose.ui.contentcapture.AndroidContentCaptureManager.TranslateStatus[] $values() {
            return /* result */;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008H\u0002J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0007J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008H\u0007¨\u0006\u0013", d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods;", "", "()V", "doTranslation", "", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ViewTranslationHelperMethods {

        public static final androidx.compose.ui.contentcapture.AndroidContentCaptureManager.ViewTranslationHelperMethods INSTANCE;
        public static void $r8$lambda$BtF4kanuJXIh7KaAYegAz0_J5nU(androidx.compose.ui.contentcapture.AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray2) {
            AndroidContentCaptureManager.ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$1(androidContentCaptureManager, longSparseArray2);
        }

        static {
            AndroidContentCaptureManager.ViewTranslationHelperMethods viewTranslationHelperMethods = new AndroidContentCaptureManager.ViewTranslationHelperMethods();
            AndroidContentCaptureManager.ViewTranslationHelperMethods.INSTANCE = viewTranslationHelperMethods;
        }

        private final void doTranslation(androidx.compose.ui.contentcapture.AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
            long nextLong;
            LongSparseArray longSparseArray;
            Object value;
            int str;
            SemanticsNode semanticsNode;
            int i;
            Object orNull;
            androidx.compose.ui.semantics.SemanticsPropertyKey setTextSubstitution;
            String string;
            int i2;
            int i4;
            int i3;
            int i5;
            final LongIterator keyIterator = LongSparseArrayKt.keyIterator(response);
            while (keyIterator.hasNext()) {
                nextLong = keyIterator.nextLong();
                value = response.get(nextLong);
                value = (ViewTranslationResponse)value.getValue("android:text");
                value = value.getText();
                if (value != null && value != null && value != null) {
                } else {
                }
                value = value.getValue("android:text");
                if (value != null) {
                } else {
                }
                value = value.getText();
                if (value != null) {
                } else {
                }
                str = 0;
                semanticsNode = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int)nextLong);
                semanticsNode = (SemanticsNodeWithAdjustedBounds)semanticsNode.getSemanticsNode();
                if (semanticsNode != null && semanticsNode != null) {
                } else {
                }
                semanticsNode = semanticsNode.getSemanticsNode();
                if (semanticsNode != null) {
                } else {
                }
                i = 0;
                orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetTextSubstitution());
                orNull = (AccessibilityAction)orNull.getAction();
                if (orNull != null && (Function1)orNull != null) {
                } else {
                }
                orNull = orNull.getAction();
                if ((Function1)(Function1)orNull != null) {
                } else {
                }
                setTextSubstitution = new AnnotatedString(value.toString(), 0, 0, 6, 0);
                orNull = (Function1)(Function1)orNull.invoke(setTextSubstitution);
            }
            LongSparseArray longSparseArray2 = response;
        }

        private static final void onVirtualViewTranslationResponses$lambda$1(androidx.compose.ui.contentcapture.AndroidContentCaptureManager $contentCaptureManager, LongSparseArray $response) {
            AndroidContentCaptureManager.ViewTranslationHelperMethods.INSTANCE.doTranslation($contentCaptureManager, $response);
        }

        public final void onCreateVirtualViewTranslationRequests(androidx.compose.ui.contentcapture.AndroidContentCaptureManager contentCaptureManager, long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
            int i;
            long l;
            long l2;
            int i11;
            SemanticsNode semanticsNode;
            ViewTranslationRequest.Builder builder;
            String orNull;
            Object obj;
            String str;
            int i12;
            int i8;
            int i10;
            int i13;
            int i9;
            int i3;
            int i5;
            AnnotatedString annotatedString;
            String fastJoinToString$default;
            int i7;
            int i4;
            int i6;
            int i2;
            final long[] lArr = virtualIds;
            final int i14 = 0;
            i = 0;
            while (i < lArr.length) {
                i11 = 0;
                semanticsNode = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int)l2);
                if ((SemanticsNodeWithAdjustedBounds)semanticsNode != null) {
                } else {
                }
                obj = requestsCollector;
                i++;
                semanticsNode = (SemanticsNodeWithAdjustedBounds)semanticsNode.getSemanticsNode();
                if (semanticsNode != null) {
                } else {
                }
                obj = requestsCollector;
                builder = new ViewTranslationRequest.Builder(contentCaptureManager.getView().getAutofillId(), (long)id, str);
                Object obj3 = orNull;
                if ((List)obj3 != null) {
                } else {
                }
                obj = requestsCollector;
                fastJoinToString$default = ListUtilsKt.fastJoinToString$default((List)obj3, (CharSequence)"\n", 0, 0, 0, 0, 0, 62, 0);
                if (fastJoinToString$default != null) {
                } else {
                }
                obj = requestsCollector;
                annotatedString = new AnnotatedString(fastJoinToString$default, 0, 0, 6, 0);
                builder.setValue("android:text", TranslationRequestValue.forText((CharSequence)annotatedString));
                requestsCollector.accept(builder.build());
            }
            Object obj2 = requestsCollector;
        }

        public final void onVirtualViewTranslationResponses(androidx.compose.ui.contentcapture.AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
            boolean equal;
            Object currentThread;
            if (Build.VERSION.SDK_INT < 31) {
            }
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                doTranslation(contentCaptureManager, response);
            } else {
                currentThread = new AndroidContentCaptureManager.ViewTranslationHelperMethods$$ExternalSyntheticLambda0(contentCaptureManager, response);
                contentCaptureManager.getView().post(currentThread);
            }
        }
    }
    public static void $r8$lambda$1XDFQ87DMU0Pr1CSBqiV4PdF6bM(androidx.compose.ui.contentcapture.AndroidContentCaptureManager androidContentCaptureManager) {
        AndroidContentCaptureManager.contentCaptureChangeChecker$lambda$0(androidContentCaptureManager);
    }

    static {
        final int i = 8;
    }

    public AndroidContentCaptureManager(AndroidComposeView view, Function0<? extends ContentCaptureSessionCompat> onContentCaptureSession) {
        super();
        this.view = view;
        this.onContentCaptureSession = onContentCaptureSession;
        int i2 = 0;
        int i3 = 1;
        final int i4 = 0;
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(i2, i3, i4);
        this.bufferedAppearedNodes = mutableIntObjectMap;
        MutableIntSet mutableIntSet = new MutableIntSet(i2, i3, i4);
        this.bufferedDisappearedNodes = mutableIntSet;
        final int i5 = 100;
        this.translateStatus = AndroidContentCaptureManager.TranslateStatus.SHOW_ORIGINAL;
        ArraySet arraySet = new ArraySet(i2, i3, i4);
        this.subtreeChangedLayoutNodes = arraySet;
        this.boundsUpdateChannel = ChannelKt.Channel$default(i3, i4, i4, 6, i4);
        Handler handler = new Handler(Looper.getMainLooper());
        this.handler = handler;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        SemanticsNodeCopy semanticsNodeCopy = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.previousSemanticsRoot = semanticsNodeCopy;
        AndroidContentCaptureManager$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new AndroidContentCaptureManager$$ExternalSyntheticLambda0(this);
        this.contentCaptureChangeChecker = externalSyntheticLambda0;
    }

    private final void bufferContentCaptureViewAppeared(int virtualId, ViewStructureCompat viewStructure) {
        Object bufferedDisappearedNodes;
        if (viewStructure == null) {
        }
        if (this.bufferedDisappearedNodes.contains(virtualId)) {
            this.bufferedDisappearedNodes.remove(virtualId);
        } else {
            this.bufferedAppearedNodes.set(virtualId, viewStructure);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int virtualId) {
        Object bufferedAppearedNodes;
        if (this.bufferedAppearedNodes.containsKey(virtualId)) {
            this.bufferedAppearedNodes.remove(virtualId);
        } else {
            this.bufferedDisappearedNodes.add(virtualId);
        }
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        int this_$iv2;
        int firstOrNull3;
        int firstOrNull2;
        int firstOrNull;
        int[] keys;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        int j$iv$iv;
        int i5;
        int i;
        long l;
        int i2;
        int i3;
        int i7;
        Object this_$iv;
        Object obj;
        SemanticsNode semanticsNode;
        int i6;
        int iNSTANCE;
        boolean next;
        Object iNSTANCE2;
        int $i$f$forEachKey;
        int[] k$iv;
        final Object obj2 = this;
        this_$iv2 = newSemanticsNodes;
        final int i9 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            this_$iv = this_$iv2;
            $i$f$forEachKey = firstOrNull;
            k$iv = keys;
        }
    }

    private final void clearTranslatedText() {
        int this_$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int unmergedConfig$ui_release;
        int j$iv$iv;
        int i5;
        int i2;
        long l;
        int i4;
        int i3;
        SemanticsProperties iNSTANCE;
        int i;
        IntObjectMap this_$iv2;
        this_$iv = getCurrentSemanticsNodes$ui_release();
        final int i6 = 0;
        final int i7 = 0;
        final long[] metadata = map.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
            this_$iv2 = this_$iv;
        }
    }

    private static final void contentCaptureChangeChecker$lambda$0(androidx.compose.ui.contentcapture.AndroidContentCaptureManager this$0) {
        if (!this$0.isEnabled$ui_release()) {
        }
        final int i3 = 0;
        Owner.measureAndLayout$default((Owner)this$0.view, i3, 1, 0);
        this$0.sendSemanticsStructureChangeEvents(this$0.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this$0.previousSemanticsRoot);
        this$0.sendContentCaptureStructureChangeEvents(this$0.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this$0.previousSemanticsRoot);
        this$0.checkForContentCapturePropertyChanges(this$0.getCurrentSemanticsNodes$ui_release());
        this$0.updateSemanticsCopy();
        this$0.checkingForSemanticsChanges = i3;
    }

    public static void getContentCaptureSession$ui_release$annotations() {
    }

    private final void hideTranslatedText() {
        int this_$iv2;
        int valueOf;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int unmergedConfig$ui_release;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i6;
        long l;
        int cmp;
        int i3;
        int i4;
        int i5;
        int i2;
        int i;
        IntObjectMap this_$iv;
        this_$iv2 = getCurrentSemanticsNodes$ui_release();
        final int i7 = 0;
        final long[] metadata = map.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
            this_$iv = this_$iv2;
            i2 = valueOf;
        }
    }

    public static void isEnabled$ui_release$annotations() {
    }

    private final void notifyContentCaptureChanges() {
        MutableIntObjectMap bufferedAppearedNodes;
        boolean bufferedDisappearedNodes;
        int i3;
        ArrayList arrayList;
        int j$iv$iv;
        ArrayList list;
        MutableIntSet $i$f$isFull2;
        int i4;
        int i$iv$iv;
        int index$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int $i$f$isFull;
        int i9;
        int valueOf;
        int metadata;
        int cmp;
        ArrayList i$iv$iv2;
        int it;
        MutableIntObjectMap bufferedAppearedNodes2;
        int cmp2;
        MutableIntObjectMap $i$a$ApplyAndroidContentCaptureManager$notifyContentCaptureChanges$3;
        int i5;
        int i2;
        int i;
        long slot$iv$iv;
        int i6;
        long l;
        int i10;
        int i7;
        long l2;
        int i8;
        final Object obj = this;
        final ContentCaptureSessionCompat contentCaptureSession = obj.contentCaptureSession;
        if (contentCaptureSession == null) {
        }
        if (obj.bufferedAppearedNodes.isNotEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            it = 0;
            bufferedAppearedNodes2 = obj.bufferedAppearedNodes;
            cmp2 = 0;
            i5 = 0;
            long[] metadata2 = map.metadata;
            length += -2;
            if (0 <= i19) {
            } else {
                i7 = 7;
                l2 = -9187201950435737472L;
            }
            i3 = 0;
            arrayList = new ArrayList(arrayList2.size());
            list = arrayList2;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                cmp = 0;
                bufferedAppearedNodes2 = null;
                (Collection)arrayList.add((ViewStructureCompat)list.get(index$iv$iv).toViewStructure());
                index$iv$iv++;
            }
            contentCaptureSession.notifyViewsAppeared((List)arrayList);
            obj.bufferedAppearedNodes.clear();
        } else {
            i2 = 128;
            i = 255;
            i7 = 7;
            l2 = -9187201950435737472L;
        }
        if (obj.bufferedDisappearedNodes.isNotEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            $i$f$isFull2 = obj.bufferedDisappearedNodes;
            int i20 = 0;
            $i$f$isFull = 0;
            metadata = set.metadata;
            length2 += -2;
            if (0 <= cmp) {
            } else {
                $i$a$ApplyAndroidContentCaptureManager$notifyContentCaptureChanges$3 = j$iv$iv;
                i5 = $i$f$isFull2;
                slot$iv$iv = metadata;
            }
            i3 = 0;
            arrayList = new ArrayList(arrayList3.size());
            list = arrayList3;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                metadata = 0;
                (Collection)arrayList.add(Long.valueOf((long)intValue));
                index$iv$iv++;
            }
            contentCaptureSession.notifyViewsDisappeared(CollectionsKt.toLongArray((Collection)(List)arrayList));
            obj.bufferedDisappearedNodes.clear();
        }
    }

    private final void notifySubtreeStateChangeIfNeeded(LayoutNode layoutNode) {
        boolean boundsUpdateChannel;
        Unit iNSTANCE;
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.trySend-JP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendContentCaptureStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        MutableIntObjectMap $this$fastForEach$iv;
        int index$iv;
        int index$iv2;
        Object obj2;
        int i7;
        Object obj;
        long[] metadata;
        int i6;
        int i8;
        boolean contains;
        int i$iv$iv;
        int slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i;
        int j$iv$iv;
        int i4;
        int i5;
        long l;
        int i2;
        int i9;
        int i3;
        MutableIntObjectMap this_$iv;
        final Object obj3 = this;
        List replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int i10 = 0;
        index$iv = 0;
        while (index$iv < replacedChildren$ui_release.size()) {
            obj = obj2;
            i6 = 0;
            if (obj3.getCurrentSemanticsNodes$ui_release().contains((SemanticsNode)obj.getId()) && !oldNode.getChildren().contains(obj.getId())) {
            }
            index$iv++;
            if (!oldNode.getChildren().contains(obj.getId())) {
            }
            obj3.updateBuffersOnAppeared(obj);
        }
        $this$fastForEach$iv = obj3.previousSemanticsNodes;
        int i11 = 0;
        i7 = 0;
        metadata = map.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
            this_$iv = $this$fastForEach$iv;
        }
        List replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int i12 = 0;
        index$iv2 = 0;
        while (index$iv2 < replacedChildren$ui_release2.size()) {
            metadata = i7;
            i8 = 0;
            index$iv2++;
            i$iv$iv = obj3.previousSemanticsNodes.get(metadata.getId());
            slot$iv$iv = 0;
            obj3.sendContentCaptureStructureChangeEvents(metadata, (SemanticsNodeCopy)i$iv$iv);
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int id, String newText) {
        final ContentCaptureSessionCompat contentCaptureSession = this.contentCaptureSession;
        if (contentCaptureSession == null) {
        }
        android.view.autofill.AutofillId autofillId = contentCaptureSession.newAutofillId((long)id);
        int i = 0;
        if (autofillId == null) {
        } else {
            contentCaptureSession.notifyViewTextChanged(autofillId, (CharSequence)newText);
        }
        int i2 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid content capture ID");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        int newChildren2;
        int cmp;
        int index$iv;
        int i6;
        int i3;
        int index$iv2;
        int[] elements;
        MutableIntSet set;
        Object obj2;
        int contains2;
        Object obj;
        long[] metadata;
        int i;
        boolean contains;
        int i$iv$iv;
        int slot$iv$iv;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i2;
        long l;
        int i4;
        int i5;
        MutableIntSet newChildren;
        final Object obj3 = this;
        newChildren2 = new MutableIntSet(0, 1, 0);
        List replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int i17 = 0;
        index$iv2 = 0;
        while (index$iv2 < replacedChildren$ui_release2.size()) {
            obj = obj2;
            i = 0;
            index$iv2++;
            newChildren2.add(obj.getId());
        }
        MutableIntSet children = oldNode.getChildren();
        i3 = 0;
        contains2 = 0;
        metadata = set.metadata;
        length += -2;
        if (0 <= i18) {
        } else {
            newChildren = newChildren2;
        }
        List replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int i8 = 0;
        index$iv = 0;
        while (index$iv < replacedChildren$ui_release.size()) {
            elements = i3;
            set = null;
            index$iv++;
            contains2 = obj3.previousSemanticsNodes.get(elements.getId());
            metadata = 0;
            obj3.sendSemanticsStructureChangeEvents(elements, (SemanticsNodeCopy)contains2);
        }
    }

    private final void showTranslatedText() {
        int this_$iv2;
        int valueOf;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int unmergedConfig$ui_release;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i4;
        long l;
        int cmp;
        int i;
        int i2;
        int i5;
        int i6;
        int i3;
        IntObjectMap this_$iv;
        this_$iv2 = getCurrentSemanticsNodes$ui_release();
        final int i7 = 0;
        final long[] metadata = map.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
            this_$iv = this_$iv2;
            i6 = valueOf;
        }
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode $this$toViewStructure) {
        Object orNull2;
        Object orNull;
        Object legacyClassName-V4PA4sw;
        android.view.autofill.AutofillId autofillId;
        String fastJoinToString$default;
        long currentSemanticsNodesSnapshotTimestampMillis;
        int fastJoinToString$default2;
        String str;
        int i2;
        int i6;
        int i3;
        int i;
        int i4;
        int i5;
        final Object obj = this;
        final ContentCaptureSessionCompat contentCaptureSession = obj.contentCaptureSession;
        int i7 = 0;
        if (contentCaptureSession == null) {
            return i7;
        }
        AutofillIdCompat autofillId2 = ViewCompatShims.getAutofillId((View)obj.view);
        if (autofillId2 == null) {
            return i7;
        }
        final SemanticsNode parent = $this$toViewStructure.getParent();
        if (parent != null) {
            if (contentCaptureSession.newAutofillId((long)id) == null) {
                return i7;
            }
        } else {
            autofillId = autofillId2.toAutofillId();
        }
        ViewStructureCompat virtualViewStructure = contentCaptureSession.newVirtualViewStructure(autofillId, (long)id2);
        if (virtualViewStructure == null) {
            return i7;
        }
        final ViewStructureCompat view2 = virtualViewStructure;
        SemanticsConfiguration unmergedConfig$ui_release = $this$toViewStructure.getUnmergedConfig$ui_release();
        if (unmergedConfig$ui_release.contains(SemanticsProperties.INSTANCE.getPassword())) {
            return i7;
        }
        Bundle extras = view2.getExtras();
        if (extras != null) {
            extras.putLong("android.view.contentcapture.EventTimestamp", obj.currentSemanticsNodesSnapshotTimestampMillis);
        }
        Object orNull4 = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getTestTag());
        if ((String)orNull4 != null) {
            currentSemanticsNodesSnapshotTimestampMillis = 0;
            view2.setId($this$toViewStructure.getId(), i7, i7, (String)orNull4);
        }
        orNull2 = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getText());
        fastJoinToString$default = "\n";
        if ((List)orNull2 != null) {
            orNull2 = 0;
            view2.setClassName("android.widget.TextView");
            view2.setText((CharSequence)ListUtilsKt.fastJoinToString$default((List)orNull2, (CharSequence)fastJoinToString$default, 0, 0, 0, 0, 0, 62, 0));
        }
        Object orNull3 = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getEditableText());
        if ((AnnotatedString)orNull3 != null) {
            currentSemanticsNodesSnapshotTimestampMillis = 0;
            view2.setClassName("android.widget.EditText");
            view2.setText((CharSequence)(AnnotatedString)orNull3);
        }
        orNull = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getContentDescription());
        if ((List)orNull != null) {
            orNull = 0;
            view2.setContentDescription((CharSequence)ListUtilsKt.fastJoinToString$default((List)orNull, (CharSequence)fastJoinToString$default, 0, 0, 0, 0, 0, 62, 0));
        }
        legacyClassName-V4PA4sw = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getRole());
        legacyClassName-V4PA4sw = SemanticsUtils_androidKt.toLegacyClassName-V4PA4sw((Role)legacyClassName-V4PA4sw.unbox-impl());
        if (legacyClassName-V4PA4sw != null && legacyClassName-V4PA4sw != null) {
            legacyClassName-V4PA4sw = SemanticsUtils_androidKt.toLegacyClassName-V4PA4sw(legacyClassName-V4PA4sw.unbox-impl());
            if (legacyClassName-V4PA4sw != null) {
                fastJoinToString$default = 0;
                view2.setClassName(legacyClassName-V4PA4sw);
            }
        }
        TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(unmergedConfig$ui_release);
        if (textLayoutResult != null) {
            fastJoinToString$default = 0;
            currentSemanticsNodesSnapshotTimestampMillis = textLayoutResult.getLayoutInput();
            str = 0;
            view2.setTextStyle(i10 *= fontScale, str, str, str);
        }
        Rect boundsInParent$ui_release = $this$toViewStructure.getBoundsInParent$ui_release();
        int i15 = 0;
        view2.setDimens((int)left, (int)top, 0, 0, (int)width, (int)height);
        return view2;
    }

    private final void updateBuffersOnAppeared(SemanticsNode node) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        if (!isEnabled$ui_release()) {
        }
        updateTranslationOnAppeared(node);
        bufferContentCaptureViewAppeared(node.getId(), toViewStructure(node));
        List replacedChildren$ui_release = node.getReplacedChildren$ui_release();
        int i2 = 0;
        index$iv = 0;
        while (index$iv < replacedChildren$ui_release.size()) {
            i = 0;
            updateBuffersOnAppeared((SemanticsNode)replacedChildren$ui_release.get(index$iv));
            index$iv++;
        }
    }

    private final void updateBuffersOnDisappeared(SemanticsNode node) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        if (!isEnabled$ui_release()) {
        }
        bufferContentCaptureViewDisappeared(node.getId());
        List replacedChildren$ui_release = node.getReplacedChildren$ui_release();
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < replacedChildren$ui_release.size()) {
            i = 0;
            updateBuffersOnDisappeared((SemanticsNode)replacedChildren$ui_release.get(index$iv));
            index$iv++;
        }
    }

    private final void updateSemanticsCopy() {
        int currentSemanticsNodes$ui_release2;
        int i2;
        int[] k$iv;
        Object[] v$iv;
        IntObjectMap semanticsNode;
        int currentSemanticsNodes$ui_release;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i8;
        int i3;
        IntObjectMap this_$iv;
        int i6;
        long l;
        int i5;
        int i7;
        Object obj;
        int i;
        int[] k$iv2;
        Object[] objArr;
        IntObjectMap map;
        int i4;
        final Object obj2 = this;
        obj2.previousSemanticsNodes.clear();
        currentSemanticsNodes$ui_release2 = obj2.getCurrentSemanticsNodes$ui_release();
        semanticsNode = currentSemanticsNodes$ui_release2;
        final long[] metadata = semanticsNode.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            this_$iv = currentSemanticsNodes$ui_release2;
            i6 = i2;
            k$iv2 = k$iv;
            objArr = v$iv;
            map = semanticsNode;
            i4 = currentSemanticsNodes$ui_release;
        }
        SemanticsNodeCopy semanticsNodeCopy = new SemanticsNodeCopy(obj2.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), obj2.getCurrentSemanticsNodes$ui_release());
        obj2.previousSemanticsRoot = semanticsNodeCopy;
    }

    private final void updateTranslationOnAppeared(SemanticsNode node) {
        androidx.compose.ui.contentcapture.AndroidContentCaptureManager.TranslateStatus translateStatus2;
        androidx.compose.ui.contentcapture.AndroidContentCaptureManager.TranslateStatus translateStatus;
        androidx.compose.ui.contentcapture.AndroidContentCaptureManager.TranslateStatus sHOW_TRANSLATED;
        final SemanticsConfiguration unmergedConfig$ui_release = node.getUnmergedConfig$ui_release();
        Object orNull = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        Boolean valueOf = false;
        Boolean valueOf2 = true;
        if (this.translateStatus == AndroidContentCaptureManager.TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual((Boolean)orNull, valueOf2)) {
            if (Intrinsics.areEqual(orNull, valueOf2)) {
                translateStatus2 = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution());
                translateStatus2 = (AccessibilityAction)translateStatus2.getAction();
                if (translateStatus2 != null && (Function1)translateStatus2 != null) {
                    translateStatus2 = translateStatus2.getAction();
                    if ((Function1)(Function1)translateStatus2 != null) {
                        translateStatus2 = (Function1)(Function1)translateStatus2.invoke(valueOf);
                    }
                }
            } else {
                translateStatus2 = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution());
                translateStatus2 = (AccessibilityAction)translateStatus2.getAction();
                if (this.translateStatus == AndroidContentCaptureManager.TranslateStatus.SHOW_TRANSLATED && Intrinsics.areEqual(orNull, valueOf) && translateStatus2 != null && (Function1)translateStatus2 != null) {
                    if (Intrinsics.areEqual(orNull, valueOf)) {
                        translateStatus2 = SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution());
                        if ((AccessibilityAction)translateStatus2 != null) {
                            translateStatus2 = (AccessibilityAction)translateStatus2.getAction();
                            if ((Function1)(Function1)translateStatus2 != null) {
                                translateStatus2 = (Function1)(Function1)translateStatus2.invoke(valueOf2);
                            }
                        }
                    }
                }
            }
        } else {
        }
    }

    public final Object boundsUpdatesEventLoop$ui_release(Continuation<? super Unit> continuation) {
        boolean $result;
        Object $continuation4;
        Object $continuation3;
        Object $continuation2;
        androidx.compose.ui.contentcapture.AndroidContentCaptureManager.boundsUpdatesEventLoop.1 anon2;
        int subtreeChangedLayoutNodes;
        Object iterator;
        Object obj;
        Object obj2;
        Object l$0;
        Object _this;
        Object obj3;
        long sendRecurringContentCaptureEventsIntervalMillis;
        androidx.compose.ui.contentcapture.AndroidContentCaptureManager.boundsUpdatesEventLoop.1 anon;
        Object obj10;
        $result = continuation;
        subtreeChangedLayoutNodes = Integer.MIN_VALUE;
        if (continuation instanceof AndroidContentCaptureManager.boundsUpdatesEventLoop.1 && label &= subtreeChangedLayoutNodes != 0) {
            $result = continuation;
            subtreeChangedLayoutNodes = Integer.MIN_VALUE;
            if (label &= subtreeChangedLayoutNodes != 0) {
                $result.label = obj10 -= subtreeChangedLayoutNodes;
            } else {
                $result = new AndroidContentCaptureManager.boundsUpdatesEventLoop.1(this, continuation);
            }
        } else {
        }
        obj10 = $result.result;
        final int i = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                iterator = l$0.boundsUpdateChannel.iterator();
                break;
            case 1:
                ResultKt.throwOnFailure(obj10);
                obj3 = l$02;
                _this = l$1;
                obj = $continuation2;
                anon2 = $result;
                $continuation4 = obj10;
                _this.next();
                obj3.notifyContentCaptureChanges();
                obj3.checkingForSemanticsChanges = i;
                obj3.handler.post(obj3.contentCaptureChangeChecker);
                obj3.subtreeChangedLayoutNodes.clear();
                anon2.L$0 = obj3;
                anon2.L$1 = _this;
                anon2.label = 2;
                return obj;
                obj10 = $continuation4;
                $result = anon2;
                $continuation2 = obj;
                iterator = _this;
                l$0 = obj3;
                obj3.subtreeChangedLayoutNodes.clear();
                return Unit.INSTANCE;
            case 2:
                iterator = $result.L$1;
                l$0 = $result.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        $result.L$0 = l$0;
        $result.L$1 = iterator;
        $result.label = i;
        Object next = iterator.hasNext($result);
        if (next == $continuation2) {
            return $continuation2;
        } else {
            $continuation4 = obj10;
            obj10 = next;
            obj3 = l$0;
            _this = iterator;
            obj = $continuation2;
            anon2 = anon;
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final ContentCaptureSessionCompat getContentCaptureSession$ui_release() {
        return this.contentCaptureSession;
    }

    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        boolean currentSemanticsNodesInvalidated;
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }
        return this.currentSemanticsNodes;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final Handler getHandler$ui_release() {
        return this.handler;
    }

    public final Function0<ContentCaptureSessionCompat> getOnContentCaptureSession() {
        return this.onContentCaptureSession;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final AndroidComposeView getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final boolean isEnabled$ui_release() {
        boolean contentCaptureSession;
        int i;
        if (ContentCaptureManager.Companion.isEnabled() && this.contentCaptureSession != null) {
            i = this.contentCaptureSession != null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final void onClearTranslation$ui_release() {
        this.translateStatus = AndroidContentCaptureManager.TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    public final void onCreateVirtualViewTranslationRequests$ui_release(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        AndroidContentCaptureManager.ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, virtualIds, supportedFormats, requestsCollector);
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final void onHideTranslation$ui_release() {
        this.translateStatus = AndroidContentCaptureManager.TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeStateChangeIfNeeded(layoutNode);
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final void onSemanticsChange$ui_release() {
        int handler;
        boolean checkingForSemanticsChanges;
        handler = 1;
        this.currentSemanticsNodesInvalidated = handler;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            if (!this.checkingForSemanticsChanges) {
                this.checkingForSemanticsChanges = handler;
                this.handler.post(this.contentCaptureChangeChecker);
            }
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final void onShowTranslation$ui_release() {
        this.translateStatus = AndroidContentCaptureManager.TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public void onStart(LifecycleOwner owner) {
        this.contentCaptureSession = (ContentCaptureSessionCompat)this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public void onStop(LifecycleOwner owner) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = 0;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public void onViewAttachedToWindow(View v) {
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public void onViewDetachedFromWindow(View v) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = 0;
    }

    public final void onVirtualViewTranslationResponses$ui_release(androidx.compose.ui.contentcapture.AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
        AndroidContentCaptureManager.ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(contentCaptureManager, response);
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureManager
    public final void setContentCaptureSession$ui_release(ContentCaptureSessionCompat <set-?>) {
        this.contentCaptureSession = <set-?>;
    }

    public final void setCurrentSemanticsNodes$ui_release(IntObjectMap<SemanticsNodeWithAdjustedBounds> <set-?>) {
        this.currentSemanticsNodes = <set-?>;
    }

    public final void setOnContentCaptureSession(Function0<? extends ContentCaptureSessionCompat> <set-?>) {
        this.onContentCaptureSession = <set-?>;
    }
}
