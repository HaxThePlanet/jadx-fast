package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ8\u0010&\u001a\u0004\u0018\u00010'2'\u0010(\u001a#\u0008\u0001\u0012\u0004\u0012\u00020*\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020,0+\u0012\u0006\u0012\u0004\u0018\u00010-0)¢\u0006\u0002\u0008.H\u0016¢\u0006\u0002\u0010/J\u0008\u00100\u001a\u000201H\u0016J\u0008\u00102\u001a\u000201H\u0016J\u0010\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\u000eH\u0016J\u000e\u00105\u001a\u0002012\u0006\u0010\u0006\u001a\u00020\u0007R/\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0008\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%¨\u00066", d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "serviceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setLegacyTextFieldState", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "setTextFieldSelectionManager", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "launchTextInputSession", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "onAttach", "", "onDetach", "onGloballyPositioned", "coordinates", "setServiceAdapter", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyAdaptingPlatformTextInputModifierNode extends Modifier.Node implements PlatformTextInputModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode {

    public static final int $stable = 8;
    private final MutableState layoutCoordinates$delegate;
    private LegacyTextFieldState legacyTextFieldState;
    private androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter serviceAdapter;
    private TextFieldSelectionManager textFieldSelectionManager;
    static {
        final int i = 8;
    }

    public LegacyAdaptingPlatformTextInputModifierNode(androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter serviceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        super();
        this.serviceAdapter = serviceAdapter;
        this.legacyTextFieldState = legacyTextFieldState;
        this.textFieldSelectionManager = textFieldSelectionManager;
        int i = 0;
        this.layoutCoordinates$delegate = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
    }

    private void setLayoutCoordinates(LayoutCoordinates <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.layoutCoordinates$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public LayoutCoordinates getLayoutCoordinates() {
        final int i = 0;
        final int i2 = 0;
        return (LayoutCoordinates)(State)this.layoutCoordinates$delegate.getValue();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public LegacyTextFieldState getLegacyTextFieldState() {
        return this.legacyTextFieldState;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return (SoftwareKeyboardController)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalSoftwareKeyboardController());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public TextFieldSelectionManager getTextFieldSelectionManager() {
        return this.textFieldSelectionManager;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public ViewConfiguration getViewConfiguration() {
        return (ViewConfiguration)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalViewConfiguration());
    }

    public Job launchTextInputSession(Function2<? super PlatformTextInputSession, ? super Continuation<?>, ? extends Object> block) {
        final int i = 0;
        if (!isAttached()) {
            return i;
        }
        LegacyAdaptingPlatformTextInputModifierNode.launchTextInputSession.1 anon = new LegacyAdaptingPlatformTextInputModifierNode.launchTextInputSession.1(this, block, i);
        return BuildersKt.launch$default(getCoroutineScope(), 0, CoroutineStart.UNDISPATCHED, (Function2)anon, 1, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        this.serviceAdapter.registerModifier((LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        this.serviceAdapter.unregisterModifier((LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        setLayoutCoordinates(coordinates);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void setLegacyTextFieldState(LegacyTextFieldState <set-?>) {
        this.legacyTextFieldState = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setServiceAdapter(androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter serviceAdapter) {
        boolean serviceAdapter3;
        boolean serviceAdapter2;
        Object obj;
        if (isAttached()) {
            this.serviceAdapter.stopInput();
            this.serviceAdapter.unregisterModifier((LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode)this);
        }
        this.serviceAdapter = serviceAdapter;
        if (isAttached()) {
            this.serviceAdapter.registerModifier((LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode)this);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void setTextFieldSelectionManager(TextFieldSelectionManager <set-?>) {
        this.textFieldSelectionManager = <set-?>;
    }
}
