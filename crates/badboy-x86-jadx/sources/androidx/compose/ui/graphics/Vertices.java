package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0017\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\n\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0005\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0010\u000cJ\u0016\u0010\u001a\u001a\u00020\r2\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0016\u0010\u001b\u001a\u00020\u00132\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0011\u0010\u0008\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001d", d2 = {"Landroidx/compose/ui/graphics/Vertices;", "", "vertexMode", "Landroidx/compose/ui/graphics/VertexMode;", "positions", "", "Landroidx/compose/ui/geometry/Offset;", "textureCoordinates", "colors", "Landroidx/compose/ui/graphics/Color;", "indices", "", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "getColors", "()[I", "", "getIndices", "()[S", "", "getPositions", "()[F", "getTextureCoordinates", "getVertexMode-c2xauaI", "()I", "I", "encodeColorList", "encodePointList", "points", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Vertices {

    private final int[] colors;
    private final short[] indices;
    private final float[] positions;
    private final float[] textureCoordinates;
    private final int vertexMode;
    private Vertices(int vertexMode, List<Offset> positions, List<Offset> textureCoordinates, List<androidx.compose.ui.graphics.Color> colors, List<Integer> indices) {
        int index$iv$iv;
        int i2;
        int i3;
        Object obj2;
        Object obj;
        int i;
        boolean booleanValue;
        super();
        this.vertexMode = vertexMode;
        Vertices.outOfBounds.1 anon = new Vertices.outOfBounds.1(positions);
        if (textureCoordinates.size() != positions.size()) {
        } else {
            if (colors.size() != positions.size()) {
            } else {
                int i5 = 0;
                int i6 = i4;
                int i7 = 0;
                index$iv$iv = 0;
                while (index$iv$iv < i6.size()) {
                    i = 0;
                    index$iv$iv++;
                }
                i2 = i3;
                if (i2 != 0) {
                } else {
                    this.positions = encodePointList(positions);
                    List list2 = textureCoordinates;
                    this.textureCoordinates = encodePointList(textureCoordinates);
                    this.colors = encodeColorList(colors);
                    int size5 = indices.size();
                    short[] sArr = new short[size5];
                    while (i3 < size5) {
                        sArr[i3] = (short)intValue;
                        i3++;
                    }
                    int i9 = indices;
                    this.indices = sArr;
                }
                List list3 = textureCoordinates;
                List list7 = colors;
                int i10 = indices;
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("indices values must be valid indices in the positions list.");
                throw illegalArgumentException2;
            }
            List list = textureCoordinates;
            List list5 = colors;
            int i8 = indices;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("positions and colors lengths must match.");
            throw illegalArgumentException;
        }
        List list4 = textureCoordinates;
        List list8 = colors;
        int i11 = indices;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("positions and textureCoordinates lengths must match.");
        throw illegalArgumentException3;
    }

    public Vertices(int i, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(i, list2, list3, list4, list5);
    }

    private final int[] encodeColorList(List<androidx.compose.ui.graphics.Color> colors) {
        int i;
        int argb-8_81llA;
        final int size = colors.size();
        final int[] iArr = new int[size];
        i = 0;
        while (i < size) {
            iArr[i] = ColorKt.toArgb-8_81llA((Color)colors.get(i).unbox-impl());
            i++;
        }
        return iArr;
    }

    private final float[] encodePointList(List<Offset> points) {
        int i;
        int i2;
        long unbox-impl;
        float x-impl;
        size *= 2;
        final float[] fArr = new float[i3];
        i = 0;
        while (i < i3) {
            unbox-impl = (Offset)points.get(i / 2).unbox-impl();
            if (i % 2 == 0) {
            } else {
            }
            x-impl = Offset.getY-impl(unbox-impl);
            fArr[i] = x-impl;
            i++;
            x-impl = Offset.getX-impl(unbox-impl);
        }
        return fArr;
    }

    public final int[] getColors() {
        return this.colors;
    }

    public final short[] getIndices() {
        return this.indices;
    }

    public final float[] getPositions() {
        return this.positions;
    }

    public final float[] getTextureCoordinates() {
        return this.textureCoordinates;
    }

    public final int getVertexMode-c2xauaI() {
        return this.vertexMode;
    }
}
