package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\u0008'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00060\u0007j\u0002`\u00082\u0006\u0010\u000b\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u0008X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "()V", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "createShader", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ShaderBrush extends androidx.compose.ui.graphics.Brush {

    private long createdSize;
    private Shader internalShader;
    public ShaderBrush() {
        super(0);
        this.createdSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    @Override // androidx.compose.ui.graphics.Brush
    public final void applyTo-Pq9zytI(long size, androidx.compose.ui.graphics.Paint p, float alpha) {
        Shader shader2;
        boolean unspecified-NH-jbRc;
        boolean black-0d7_KjU;
        int i2;
        long shader;
        int i;
        if (this.internalShader != null) {
            if (!Size.equals-impl0(this.createdSize, obj2)) {
                if (Size.isEmpty-impl(size)) {
                    shader2 = 0;
                    this.internalShader = 0;
                    this.createdSize = Size.Companion.getUnspecified-NH-jbRc();
                } else {
                    unspecified-NH-jbRc = createShader-uvyYCjk(size);
                    i = 0;
                    this.internalShader = unspecified-NH-jbRc;
                    shader2 = unspecified-NH-jbRc;
                    this.createdSize = size;
                }
            }
        } else {
        }
        if (!Color.equals-impl0(alpha.getColor-0d7_KjU(), shader)) {
            alpha.setColor-8_81llA(Color.Companion.getBlack-0d7_KjU());
        }
        if (!Intrinsics.areEqual(alpha.getShader(), shader2)) {
            alpha.setShader(shader2);
        }
        i2 = Float.compare(alpha2, obj9) == 0 ? 1 : 0;
        if (i2 == 0) {
            alpha.setAlpha(obj9);
        }
    }

    @Override // androidx.compose.ui.graphics.Brush
    public abstract Shader createShader-uvyYCjk(long l);
}
