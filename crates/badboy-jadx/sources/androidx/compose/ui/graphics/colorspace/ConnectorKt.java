package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"Connectors", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "getConnectors", "()Landroidx/collection/MutableIntObjectMap;", "connectorKey", "", "src", "dst", "renderIntent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "connectorKey-YBCOT_4", "(III)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConnectorKt {

    private static final MutableIntObjectMap<androidx.compose.ui.graphics.colorspace.Connector> Connectors;
    static {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        Connector connector = new Connector((ColorSpace)ColorSpaces.INSTANCE.getSrgb(), ColorSpaces.INSTANCE.getOklab(), RenderIntent.Companion.getPerceptual-uksYyKA(), i3);
        int i8 = 0;
        Connector connector2 = new Connector(ColorSpaces.INSTANCE.getOklab(), (ColorSpace)ColorSpaces.INSTANCE.getSrgb(), RenderIntent.Companion.getPerceptual-uksYyKA(), i3);
        ConnectorKt.Connectors = IntObjectMapKt.mutableIntObjectMapOf(i5 | i9, Connector.Companion.identity$ui_graphics_release((ColorSpace)ColorSpaces.INSTANCE.getSrgb()), i7 | i10, connector, i15 |= i12, connector2);
    }

    public static final int connectorKey-YBCOT_4(int src, int dst, int renderIntent) {
        final int i = 0;
        return i3 |= i5;
    }

    public static final MutableIntObjectMap<androidx.compose.ui.graphics.colorspace.Connector> getConnectors() {
        return ConnectorKt.Connectors;
    }
}
