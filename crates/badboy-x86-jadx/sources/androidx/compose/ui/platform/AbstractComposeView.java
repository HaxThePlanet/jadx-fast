package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.Recomposer.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.Owner;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008'\u0018\u00002\u00020\u0001B%\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\r\u0010*\u001a\u00020\u0012H'¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u00020\u00122\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001c\u0010,\u001a\u00020\u00122\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0008\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u0010,\u001a\u00020\u00122\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u0007H\u0016J$\u0010,\u001a\u00020\u00122\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\u0008\u0010/\u001a\u0004\u0018\u000100H\u0016J\"\u0010,\u001a\u00020\u00122\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J$\u00104\u001a\u00020\u000f2\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\u0008\u0010/\u001a\u0004\u0018\u000100H\u0014J,\u00104\u001a\u00020\u000f2\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\u0008\u0010/\u001a\u0004\u0018\u0001002\u0006\u00105\u001a\u00020\u000fH\u0014J\u0008\u00106\u001a\u00020\u0012H\u0002J\u0006\u00107\u001a\u00020\u0012J\u0006\u00108\u001a\u00020\u0012J\u0008\u00109\u001a\u00020\u0012H\u0002J5\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0010¢\u0006\u0002\u0008@J\u001d\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0010¢\u0006\u0002\u0008DJ\u0008\u0010E\u001a\u00020\u000fH\u0016J\u0008\u0010F\u001a\u00020\u0012H\u0014J0\u0010G\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0004J\u0018\u0010H\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0004J\u0010\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0007H\u0016J\u0008\u0010K\u001a\u00020\u000bH\u0002J\u0010\u0010L\u001a\u00020\u00122\u0008\u0010M\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010N\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u000fH\u0016J\u000e\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020QJ\u0008\u0010R\u001a\u00020\u000fH\u0016J\u000c\u0010S\u001a\u00020\u000b*\u00020\u000bH\u0002R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u000b@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001d@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u0017R,\u0010#\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f8F@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008$\u0010\u0014\u001a\u0004\u0008%\u0010\u0017\"\u0004\u0008&\u0010'R\u0018\u0010(\u001a\u00020\u000f*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010)¨\u0006T", d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "composition", "Landroidx/compose/runtime/Composition;", "creatingComposition", "", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "", "getDisposeViewCompositionStrategy$annotations", "()V", "hasComposition", "getHasComposition", "()Z", "isTransitionGroupSet", "value", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "addView", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "addViewInLayout", "preventRequestLayout", "checkAddView", "createComposition", "disposeComposition", "ensureCompositionCreated", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "isTransitionGroup", "onAttachedToWindow", "onLayout", "onMeasure", "onRtlPropertiesChanged", "layoutDirection", "resolveParentCompositionContext", "setParentCompositionContext", "parent", "setTransitionGroup", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldDelayChildPressedState", "cacheIfAlive", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractComposeView extends ViewGroup {

    public static final int $stable = 8;
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0<Unit> disposeViewCompositionStrategy;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;
    static {
        final int i = 8;
    }

    public AbstractComposeView(Context context) {
        super(context, 0, 0, 6, 0);
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0, 4, 0);
    }

    public AbstractComposeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int i = 0;
        setClipChildren(i);
        setClipToPadding(i);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.Companion.getDefault().installFor(this);
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(context, obj2, obj3);
    }

    private final CompositionContext cacheIfAlive(CompositionContext $this$cacheIfAlive) {
        int i2;
        int i;
        WeakReference weakReference;
        final CompositionContext context = $this$cacheIfAlive;
        final int i3 = 0;
        i = 0;
        i2 = isAlive(context) ? context : 0;
        if (i2 != 0) {
            i = 0;
            weakReference = new WeakReference(i2);
            this.cachedViewTreeCompositionContext = weakReference;
        }
        return $this$cacheIfAlive;
    }

    private final void checkAddView() {
        if (!this.creatingComposition) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.append("Cannot add views to ").append(getClass().getSimpleName()).append("; only Compose content is supported").toString());
        throw unsupportedOperationException;
    }

    private final void ensureCompositionCreated() {
        Composition composition;
        Object content;
        CompositionContext resolveParentCompositionContext;
        androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.1 anon;
        int i;
        if (this.composition == null) {
            int i2 = 1;
            this.creatingComposition = i2;
            anon = new AbstractComposeView.ensureCompositionCreated.1(this);
            this.composition = Wrapper_androidKt.setContent(this, resolveParentCompositionContext(), (Function2)ComposableLambdaKt.composableLambdaInstance(-656146368, i2, anon));
            this.creatingComposition = false;
        }
    }

    private static void getDisposeViewCompositionStrategy$annotations() {
    }

    public static void getShowLayoutBounds$annotations() {
    }

    private final boolean isAlive(CompositionContext $this$isAlive) {
        int i;
        boolean compareTo;
        Recomposer.State shuttingDown;
        if ($this$isAlive instanceof Recomposer) {
            if ((Recomposer.State)(Recomposer)$this$isAlive.getCurrentState().getValue().compareTo((Enum)Recomposer.State.ShuttingDown) > 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext parentContext;
        Object cachedViewTreeCompositionContext;
        int i;
        boolean it;
        int i2;
        if (this.parentContext == null) {
            CompositionContext viewTreeCompositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext((View)this);
            if (viewTreeCompositionContext != null) {
                parentContext = cacheIfAlive(viewTreeCompositionContext);
            } else {
                parentContext = i;
            }
            cachedViewTreeCompositionContext = this.cachedViewTreeCompositionContext;
            cachedViewTreeCompositionContext = cachedViewTreeCompositionContext.get();
            i2 = 0;
            if (parentContext == null && cachedViewTreeCompositionContext != null && cachedViewTreeCompositionContext != null && isAlive((CompositionContext)cachedViewTreeCompositionContext)) {
                cachedViewTreeCompositionContext = this.cachedViewTreeCompositionContext;
                if (cachedViewTreeCompositionContext != null) {
                    cachedViewTreeCompositionContext = cachedViewTreeCompositionContext.get();
                    if ((CompositionContext)cachedViewTreeCompositionContext != null) {
                        i2 = 0;
                        if (isAlive((CompositionContext)cachedViewTreeCompositionContext)) {
                            i = cachedViewTreeCompositionContext;
                        }
                    }
                }
                if (i == 0) {
                    parentContext = cacheIfAlive((CompositionContext)WindowRecomposer_androidKt.getWindowRecomposer((View)this));
                }
            }
        }
        return parentContext;
    }

    private final void setParentContext(CompositionContext value) {
        CompositionContext attachedToWindow;
        Composition composition;
        this.parentContext = value;
        attachedToWindow = 0;
        if (this.parentContext != value && value != null) {
            this.parentContext = value;
            attachedToWindow = 0;
            if (value != null) {
                this.cachedViewTreeCompositionContext = attachedToWindow;
            }
            composition = this.composition;
            composition.dispose();
            this.composition = attachedToWindow;
            if (composition != null && isAttachedToWindow()) {
                composition.dispose();
                this.composition = attachedToWindow;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder value) {
        IBinder previousAttachedWindowToken;
        if (this.previousAttachedWindowToken != value) {
            this.previousAttachedWindowToken = value;
            this.cachedViewTreeCompositionContext = 0;
        }
    }

    @Override // android.view.ViewGroup
    public abstract void Content(Composer composer, int i2);

    @Override // android.view.ViewGroup
    public void addView(View child) {
        checkAddView();
        super.addView(child);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        checkAddView();
        super.addView(child, index);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        checkAddView();
        super.addView(child, width, height);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, params);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        return super.addViewInLayout(child, index, params);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkAddView();
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    @Override // android.view.ViewGroup
    public final void createComposition() {
        int i;
        CompositionContext attachedToWindow;
        if (this.parentContext == null) {
            if (isAttachedToWindow()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i == 0) {
        } else {
            ensureCompositionCreated();
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
        throw illegalStateException;
    }

    @Override // android.view.ViewGroup
    public final void disposeComposition() {
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = 0;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final boolean getHasComposition() {
        int i;
        i = this.composition != null ? 1 : 0;
        return i;
    }

    @Override // android.view.ViewGroup
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return 1;
    }

    @Override // android.view.ViewGroup
    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // android.view.ViewGroup
    public void internalOnLayout$ui_release(boolean changed, int left, int top, int right, int bottom) {
        int paddingLeft;
        int paddingTop;
        int i;
        int i2;
        int paddingBottom;
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), i4 -= paddingRight, i5 -= paddingBottom);
        }
    }

    @Override // android.view.ViewGroup
    public void internalOnMeasure$ui_release(int widthMeasureSpec, int heightMeasureSpec) {
        int i = 0;
        final View childAt = getChildAt(i);
        if (childAt == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(i, i3 -= paddingRight), View.MeasureSpec.getMode(widthMeasureSpec)), View.MeasureSpec.makeMeasureSpec(Math.max(i, i6 -= paddingBottom), View.MeasureSpec.getMode(heightMeasureSpec)));
        setMeasuredDimension(i8 += paddingRight2, i10 += paddingBottom2);
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        int i;
        boolean isTransitionGroupSet;
        if (this.isTransitionGroupSet != null) {
            if (super.isTransitionGroup()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            ensureCompositionCreated();
        }
    }

    @Override // android.view.ViewGroup
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        internalOnLayout$ui_release(changed, left, top, right, bottom);
    }

    @Override // android.view.ViewGroup
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ensureCompositionCreated();
        internalOnMeasure$ui_release(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.ViewGroup
    public void onRtlPropertiesChanged(int layoutDirection) {
        View childAt = getChildAt(0);
        if (childAt == null) {
        } else {
            childAt.setLayoutDirection(layoutDirection);
        }
    }

    @Override // android.view.ViewGroup
    public final void setParentCompositionContext(CompositionContext parent) {
        setParentContext(parent);
    }

    @Override // android.view.ViewGroup
    public final void setShowLayoutBounds(boolean value) {
        int i;
        View view;
        this.showLayoutBounds = value;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = 0;
            (Owner)childAt.setShowLayoutBounds(value);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean isTransitionGroup) {
        super.setTransitionGroup(isTransitionGroup);
        this.isTransitionGroupSet = true;
    }

    @Override // android.view.ViewGroup
    public final void setViewCompositionStrategy(androidx.compose.ui.platform.ViewCompositionStrategy strategy) {
        Function0 disposeViewCompositionStrategy = this.disposeViewCompositionStrategy;
        if (disposeViewCompositionStrategy != null) {
            disposeViewCompositionStrategy.invoke();
        }
        this.disposeViewCompositionStrategy = strategy.installFor(this);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}
