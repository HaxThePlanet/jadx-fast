package androidx.compose.material.ripple;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.R.id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0014J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0014J\u0008\u0010\u0019\u001a\u00020\u000fH\u0016J\n\u0010\u001a\u001a\u00020\u000f*\u00020\u001bJ\n\u0010\u001c\u001a\u00020\u000c*\u00020\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Landroidx/compose/material/ripple/RippleContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MaxRippleHosts", "", "nextHostIndex", "rippleHostMap", "Landroidx/compose/material/ripple/RippleHostMap;", "rippleHosts", "", "Landroidx/compose/material/ripple/RippleHostView;", "unusedRippleHosts", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "disposeRippleIfNeeded", "Landroidx/compose/material/ripple/RippleHostKey;", "getRippleHostView", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RippleContainer extends ViewGroup {

    public static final int $stable = 8;
    private final int MaxRippleHosts = 5;
    private int nextHostIndex = 1;
    private final androidx.compose.material.ripple.RippleHostMap rippleHostMap;
    private final List<androidx.compose.material.ripple.RippleHostView> rippleHosts;
    private final List<androidx.compose.material.ripple.RippleHostView> unusedRippleHosts;
    static {
        final int i = 8;
    }

    public RippleContainer(Context context) {
        super(context);
        int i = 5;
        ArrayList arrayList = new ArrayList();
        this.rippleHosts = (List)arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.unusedRippleHosts = (List)arrayList2;
        RippleHostMap rippleHostMap = new RippleHostMap();
        this.rippleHostMap = rippleHostMap;
        setClipChildren(false);
        RippleHostView rippleHostView = new RippleHostView(context);
        int i4 = 0;
        addView((View)rippleHostView);
        this.rippleHosts.add(rippleHostView);
        this.unusedRippleHosts.add(rippleHostView);
        setTag(R.id.hide_in_inspector_tag, true);
    }

    @Override // android.view.ViewGroup
    public final void disposeRippleIfNeeded(androidx.compose.material.ripple.RippleHostKey $this$disposeRippleIfNeeded) {
        List unusedRippleHosts;
        $this$disposeRippleIfNeeded.onResetRippleHostView();
        androidx.compose.material.ripple.RippleHostView view = this.rippleHostMap.get($this$disposeRippleIfNeeded);
        if (view != null) {
            view.disposeRipple();
            this.rippleHostMap.remove($this$disposeRippleIfNeeded);
            this.unusedRippleHosts.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final androidx.compose.material.ripple.RippleHostView getRippleHostView(androidx.compose.material.ripple.RippleHostKey $this$getRippleHostView) {
        Object rippleHostView;
        Object rippleHostView2;
        int i2;
        Object rippleHostKey;
        int i;
        androidx.compose.material.ripple.RippleHostMap rippleHostMap;
        List rippleHosts;
        androidx.compose.material.ripple.RippleHostView view = this.rippleHostMap.get($this$getRippleHostView);
        if (view != null) {
            return view;
        }
        if ((RippleHostView)CollectionsKt.removeFirstOrNull(this.unusedRippleHosts) == null) {
            if (this.nextHostIndex > CollectionsKt.getLastIndex(this.rippleHosts)) {
                rippleHostView2 = new RippleHostView(getContext());
                rippleHostKey = rippleHostView2;
                rippleHostMap = 0;
                addView((View)rippleHostKey);
                (Collection)this.rippleHosts.add(rippleHostKey);
            } else {
                rippleHostView2 = this.rippleHosts.get(this.nextHostIndex);
                rippleHostKey = this.rippleHostMap.get((RippleHostView)rippleHostView2);
                if (rippleHostKey != null) {
                    rippleHostKey.onResetRippleHostView();
                    this.rippleHostMap.remove(rippleHostKey);
                    rippleHostView2.disposeRipple();
                }
            }
            rippleHostView = rippleHostView2;
            if (this.nextHostIndex < maxRippleHosts--) {
                this.nextHostIndex = nextHostIndex3++;
            } else {
                this.nextHostIndex = 0;
            }
        }
        this.rippleHostMap.set($this$getRippleHostView, rippleHostView);
        return rippleHostView;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int i = 0;
        setMeasuredDimension(i, i);
    }

    @Override // android.view.ViewGroup
    public void requestLayout() {
    }
}
