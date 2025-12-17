package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\u0008¢\u0006\u0002\u0010\u0004\u001aN\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0003\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0003\u0010\r\u001a\u00020\u000c2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\u0008\u0011H\u0086\u0008\u001a8\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\u0008\u0008\u0001\u0010\u0012\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\u0008\u0011H\u0086\u0008¨\u0006\u0013", d2 = {"getSystemService", "T", "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextKt {
    public static final <T> T getSystemService(Context $this$getSystemService) {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> obj = Object.class;
        Class<Object> obj2 = obj;
        return ContextCompat.getSystemService($this$getSystemService, obj);
    }

    public static final void withStyledAttributes(Context $this$withStyledAttributes, int resourceId, int[] attrs, Function1<? super TypedArray, Unit> block) {
        final int i = 0;
        final TypedArray styledAttributes = $this$withStyledAttributes.obtainStyledAttributes(resourceId, attrs);
        block.invoke(styledAttributes);
        styledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context $this$withStyledAttributes, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, Function1<? super TypedArray, Unit> block) {
        final int i = 0;
        final TypedArray styledAttributes = $this$withStyledAttributes.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
        block.invoke(styledAttributes);
        styledAttributes.recycle();
    }

    public static void withStyledAttributes$default(Context $this$withStyledAttributes_u24default, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, Function1 block, int i7, Object object8) {
        int obj1;
        int obj3;
        int obj4;
        if (i7 & 1 != 0) {
            obj1 = 0;
        }
        if (i7 & 4 != 0) {
            obj3 = 0;
        }
        if (i7 &= 8 != 0) {
            obj4 = 0;
        }
        int obj6 = 0;
        TypedArray obj7 = $this$withStyledAttributes_u24default.obtainStyledAttributes(obj1, attrs, obj3, obj4);
        block.invoke(obj7);
        obj7.recycle();
    }
}
