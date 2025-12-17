package androidx.compose.material3.internal;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.ui.geometry.Offset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/material3/internal/MappedInteractionSource;", "Landroidx/compose/foundation/interaction/InteractionSource;", "underlyingInteractionSource", "delta", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/foundation/interaction/InteractionSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "interactions", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/foundation/interaction/Interaction;", "getInteractions", "()Lkotlinx/coroutines/flow/Flow;", "mappedPresses", "", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "mapPress", "press", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MappedInteractionSource implements InteractionSource {

    public static final int $stable;
    private final long delta;
    private final Flow<Interaction> interactions;
    private final Map<PressInteraction.Press, PressInteraction.Press> mappedPresses;
    static {
    }

    private MappedInteractionSource(InteractionSource underlyingInteractionSource, long delta) {
        super();
        this.delta = delta;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.mappedPresses = (Map)linkedHashMap;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        MappedInteractionSource.special$$inlined.map.1 anon = new MappedInteractionSource.special$$inlined.map.1(underlyingInteractionSource.getInteractions(), this);
        this.interactions = (Flow)anon;
    }

    public MappedInteractionSource(InteractionSource interactionSource, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(interactionSource, l2, defaultConstructorMarker3);
    }

    public static final Map access$getMappedPresses$p(androidx.compose.material3.internal.MappedInteractionSource $this) {
        return $this.mappedPresses;
    }

    public static final PressInteraction.Press access$mapPress(androidx.compose.material3.internal.MappedInteractionSource $this, PressInteraction.Press press) {
        return $this.mapPress(press);
    }

    private final PressInteraction.Press mapPress(PressInteraction.Press press) {
        PressInteraction.Press press2 = new PressInteraction.Press(Offset.minus-MK-Hz9U(press.getPressPosition-F1C5BW0(), obj2), obj2, 0);
        return press2;
    }

    public Flow<Interaction> getInteractions() {
        return this.interactions;
    }
}
