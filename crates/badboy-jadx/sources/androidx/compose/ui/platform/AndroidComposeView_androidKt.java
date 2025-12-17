package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.input.PlatformTextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\u001a2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u0015H\u0002\u001a\u001e\u0010\u0019\u001a\u00020\u001a*\u00020\u000c2\u0006\u0010\u0016\u001a\u00020\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a.\u0010\u001d\u001a\u00020\u001a*\u00020\u000c2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"ONE_FRAME_120_HERTZ_IN_MILLISECONDS", "", "platformTextInputServiceInterceptor", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "getPlatformTextInputServiceInterceptor", "()Lkotlin/jvm/functions/Function1;", "setPlatformTextInputServiceInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "containsDescendant", "", "Landroid/view/View;", "other", "getContentCaptureSessionCompat", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "preTransform", "", "preTransform-JiSxe2E", "([F[F)V", "preTranslate", "x", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidComposeView_androidKt {

    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8L;
    private static Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> platformTextInputServiceInterceptor;
    static {
        AndroidComposeView_androidKt.platformTextInputServiceInterceptor = (Function1)AndroidComposeView_androidKt.platformTextInputServiceInterceptor.1.INSTANCE;
    }

    public static final boolean access$containsDescendant(View $receiver, View other) {
        return AndroidComposeView_androidKt.containsDescendant($receiver, other);
    }

    public static final ContentCaptureSessionCompat access$getContentCaptureSessionCompat(View $receiver) {
        return AndroidComposeView_androidKt.getContentCaptureSessionCompat($receiver);
    }

    public static final void access$preTransform-JiSxe2E(float[] $receiver, float[] other) {
        AndroidComposeView_androidKt.preTransform-JiSxe2E($receiver, other);
    }

    public static final void access$preTranslate-cG2Xzmc(float[] $receiver, float x, float y, float[] tmpMatrix) {
        AndroidComposeView_androidKt.preTranslate-cG2Xzmc($receiver, x, y, tmpMatrix);
    }

    private static final boolean containsDescendant(View $this$containsDescendant, View other) {
        ViewParent viewParent;
        int i = 0;
        if (Intrinsics.areEqual(other, $this$containsDescendant)) {
            return i;
        }
        viewParent = other.getParent();
        while (viewParent != null) {
            viewParent = viewParent.getParent();
        }
        return i;
    }

    private static final float dot-p89u6pk(float[] m1, int row, float[] m2, int column) {
        int i6 = 0;
        int i15 = 0;
        int i16 = 0;
        int i23 = 0;
        int i17 = 0;
        int i26 = 0;
        int i18 = 0;
        int i29 = 0;
        return i4 += i12;
    }

    private static final ContentCaptureSessionCompat getContentCaptureSessionCompat(View $this$getContentCaptureSessionCompat) {
        ViewCompatShims.setImportantForContentCapture($this$getContentCaptureSessionCompat, 1);
        return ViewCompatShims.getContentCaptureSession($this$getContentCaptureSessionCompat);
    }

    public static final Function1<PlatformTextInputService, PlatformTextInputService> getPlatformTextInputServiceInterceptor() {
        return AndroidComposeView_androidKt.platformTextInputServiceInterceptor;
    }

    private static final void preTransform-JiSxe2E(float[] $this$preTransform_u2dJiSxe2E, float[] other) {
        final float[] fArr = $this$preTransform_u2dJiSxe2E;
        final float[] fArr2 = other;
        int i = 0;
        int i2 = 1;
        int i3 = 2;
        int i4 = 3;
        int i22 = 0;
        fArr[i38 += i6] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i, fArr, i);
        int i23 = 0;
        fArr[i40 += i7] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i, fArr, i2);
        int i24 = 0;
        fArr[i42 += i8] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i, fArr, i3);
        int i25 = 0;
        fArr[i44 += i9] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i, fArr, i4);
        int i26 = 0;
        fArr[i46 += i10] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i2, fArr, i);
        int i27 = 0;
        fArr[i48 += i11] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i2, fArr, i2);
        int i28 = 0;
        fArr[i50 += i12] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i2, fArr, i3);
        int i29 = 0;
        fArr[i52 += i13] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i2, fArr, i4);
        int i30 = 0;
        fArr[i54 += i14] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i3, fArr, i);
        int i31 = 0;
        fArr[i56 += i15] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i3, fArr, i2);
        int i32 = 0;
        fArr[i58 += i16] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i3, fArr, i3);
        int i33 = 0;
        fArr[i60 += i17] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i3, fArr, i4);
        int i34 = 0;
        fArr[i62 += i18] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i4, fArr, i);
        int i35 = 0;
        fArr[i64 += i19] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i4, fArr, i2);
        int i36 = 0;
        fArr[i66 += i20] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i4, fArr, i3);
        int i37 = 0;
        fArr[i68 += i21] = AndroidComposeView_androidKt.dot-p89u6pk(fArr2, i4, fArr, i4);
    }

    private static final void preTranslate-cG2Xzmc(float[] $this$preTranslate_u2dcG2Xzmc, float x, float y, float[] tmpMatrix) {
        Matrix.reset-impl(tmpMatrix);
        final float[] fArr = tmpMatrix;
        Matrix.translate-impl$default(fArr, x, y, 0, 4, 0);
        AndroidComposeView_androidKt.preTransform-JiSxe2E($this$preTranslate_u2dcG2Xzmc, fArr);
    }

    public static final void setPlatformTextInputServiceInterceptor(Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> <set-?>) {
        AndroidComposeView_androidKt.platformTextInputServiceInterceptor = <set-?>;
    }
}
