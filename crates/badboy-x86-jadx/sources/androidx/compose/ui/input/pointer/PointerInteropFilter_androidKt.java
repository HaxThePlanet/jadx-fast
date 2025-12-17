package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003H\u0007\u001a,\u0010\t\u001a\u00020\u0001*\u00020\u00012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003H\u0007\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¨\u0006\u0010", d2 = {"motionEventSpy", "Landroidx/compose/ui/Modifier;", "watcher", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "motionEvent", "", "pointerInteropFilter", "requestDisallowInterceptTouchEvent", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "onTouchEvent", "", "view", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointerInteropFilter_androidKt {
    public static final Modifier motionEventSpy(Modifier $this$motionEventSpy, Function1<? super MotionEvent, Unit> watcher) {
        PointerInteropFilter_androidKt.motionEventSpy.1 anon = new PointerInteropFilter_androidKt.motionEventSpy.1(watcher, 0);
        return SuspendingPointerInputFilterKt.pointerInput($this$motionEventSpy, watcher, (Function2)anon);
    }

    public static final Modifier pointerInteropFilter(Modifier $this$pointerInteropFilter, androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, Function1<? super MotionEvent, Boolean> onTouchEvent) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new PointerInteropFilter_androidKt.pointerInteropFilter$$inlined.debugInspectorInfo.1(requestDisallowInterceptTouchEvent, onTouchEvent);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        PointerInteropFilter_androidKt.pointerInteropFilter.2 $i$f$debugInspectorInfo = new PointerInteropFilter_androidKt.pointerInteropFilter.2(onTouchEvent, requestDisallowInterceptTouchEvent);
        return ComposedModifierKt.composed($this$pointerInteropFilter, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static final Modifier pointerInteropFilter(Modifier $this$pointerInteropFilter, AndroidViewHolder view) {
        PointerInteropFilter pointerInteropFilter = new PointerInteropFilter();
        PointerInteropFilter_androidKt.pointerInteropFilter.3 anon = new PointerInteropFilter_androidKt.pointerInteropFilter.3(view);
        pointerInteropFilter.setOnTouchEvent((Function1)anon);
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = new RequestDisallowInterceptTouchEvent();
        pointerInteropFilter.setRequestDisallowInterceptTouchEvent(requestDisallowInterceptTouchEvent);
        view.setOnRequestDisallowInterceptTouchEvent$ui_release((Function1)requestDisallowInterceptTouchEvent);
        return $this$pointerInteropFilter.then((Modifier)pointerInteropFilter);
    }

    public static Modifier pointerInteropFilter$default(Modifier modifier, androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        return PointerInteropFilter_androidKt.pointerInteropFilter(modifier, obj1, function13);
    }
}
