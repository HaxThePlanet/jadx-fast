package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\u0006J\u0019\u0010\r\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Landroidx/compose/material/ripple/RippleHostMap;", "", "()V", "hostToIndicationMap", "", "Landroidx/compose/material/ripple/RippleHostView;", "Landroidx/compose/material/ripple/RippleHostKey;", "indicationToHostMap", "get", "indicationInstance", "rippleHostView", "remove", "", "set", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RippleHostMap {

    private final Map<androidx.compose.material.ripple.RippleHostView, androidx.compose.material.ripple.RippleHostKey> hostToIndicationMap;
    private final Map<androidx.compose.material.ripple.RippleHostKey, androidx.compose.material.ripple.RippleHostView> indicationToHostMap;
    public RippleHostMap() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.indicationToHostMap = (Map)linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.hostToIndicationMap = (Map)linkedHashMap2;
    }

    public final androidx.compose.material.ripple.RippleHostKey get(androidx.compose.material.ripple.RippleHostView rippleHostView) {
        return (RippleHostKey)this.hostToIndicationMap.get(rippleHostView);
    }

    public final androidx.compose.material.ripple.RippleHostView get(androidx.compose.material.ripple.RippleHostKey indicationInstance) {
        return (RippleHostView)this.indicationToHostMap.get(indicationInstance);
    }

    public final void remove(androidx.compose.material.ripple.RippleHostKey indicationInstance) {
        int i;
        Object remove;
        Object obj = this.indicationToHostMap.get(indicationInstance);
        if ((RippleHostView)obj != null) {
            i = 0;
            remove = this.hostToIndicationMap.remove((RippleHostView)obj);
        }
        this.indicationToHostMap.remove(indicationInstance);
    }

    public final void set(androidx.compose.material.ripple.RippleHostKey indicationInstance, androidx.compose.material.ripple.RippleHostView rippleHostView) {
        this.indicationToHostMap.put(indicationInstance, rippleHostView);
        this.hostToIndicationMap.put(rippleHostView, indicationInstance);
    }
}
