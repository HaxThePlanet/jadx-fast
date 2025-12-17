package androidx.compose.ui.graphics.colorspace;

import androidx.collection.LongIntMap;
import androidx.compose.foundation.gestures.AnchoredDraggableNode.onDragStopped.1.1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0005\u0008&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/colorspace/Adaptation;", "", "transform", "", "([F)V", "getTransform$ui_graphics_release", "()[F", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Adaptation {

    private static final androidx.compose.ui.graphics.colorspace.Adaptation Bradford;
    private static final androidx.compose.ui.graphics.colorspace.Adaptation Ciecat02;
    public static final androidx.compose.ui.graphics.colorspace.Adaptation.Companion Companion;
    private static final androidx.compose.ui.graphics.colorspace.Adaptation VonKries;
    private final float[] transform;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006¨\u0006\u000b", d2 = {"Landroidx/compose/ui/graphics/colorspace/Adaptation$Companion;", "", "()V", "Bradford", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "getBradford", "()Landroidx/compose/ui/graphics/colorspace/Adaptation;", "Ciecat02", "getCiecat02", "VonKries", "getVonKries", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.graphics.colorspace.Adaptation getBradford() {
            return Adaptation.access$getBradford$cp();
        }

        public final androidx.compose.ui.graphics.colorspace.Adaptation getCiecat02() {
            return Adaptation.access$getCiecat02$cp();
        }

        public final androidx.compose.ui.graphics.colorspace.Adaptation getVonKries() {
            return Adaptation.access$getVonKries$cp();
        }
    }
    static {
        Adaptation.Companion companion = new Adaptation.Companion(0);
        Adaptation.Companion = companion;
        int i = 9;
        float[] fArr2 = new float[i];
        fArr2 = new int[]{1063593286, -1086321381, 1025463707, 1049126293, 1071338488, -1114879558, -1104853493, 1024873149, 1065601519};
        Adaptation.Companion.Bradford.1 anon2 = new Adaptation.Companion.Bradford.1(fArr2);
        Adaptation.Bradford = (Adaptation)anon2;
        float[] fArr3 = new float[i];
        fArr3 = new int[]{1053617218, -1100498128, 0, 1060447558, 1066740021, 0, -1113227337, 1027289068, 1063981175};
        Adaptation.Companion.VonKries.1 anon3 = new Adaptation.Companion.VonKries.1(fArr3);
        Adaptation.VonKries = (Adaptation)anon3;
        float[] fArr = new float[i];
        fArr = new int[]{1060870344, -1087103199, 994352038, 1054602376, 1071204270, 1012847241, -1104786384, 1002955394, 1065074714};
        Adaptation.Companion.Ciecat02.1 anon = new Adaptation.Companion.Ciecat02.1(fArr);
        Adaptation.Ciecat02 = (Adaptation)anon;
    }

    private Adaptation(float[] transform) {
        super();
        this.transform = transform;
    }

    public Adaptation(float[] fArr, DefaultConstructorMarker defaultConstructorMarker2) {
        super(fArr);
    }

    public static final androidx.compose.ui.graphics.colorspace.Adaptation access$getBradford$cp() {
        return Adaptation.Bradford;
    }

    public static final androidx.compose.ui.graphics.colorspace.Adaptation access$getCiecat02$cp() {
        return Adaptation.Ciecat02;
    }

    public static final androidx.compose.ui.graphics.colorspace.Adaptation access$getVonKries$cp() {
        return Adaptation.VonKries;
    }

    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }
}
