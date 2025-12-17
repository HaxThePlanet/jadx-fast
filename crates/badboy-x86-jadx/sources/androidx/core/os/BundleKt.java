package androidx.core.os;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\u0008\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BundleKt {
    public static final Bundle bundleOf() {
        Bundle bundle = new Bundle(0);
        return bundle;
    }

    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairs) {
        int i;
        Object component2;
        Object component1;
        Object componentType;
        Object obj;
        String str;
        boolean assignableFrom;
        Bundle bundle = new Bundle(pairs.length);
        Bundle bundle2 = bundle;
        final int i2 = 0;
        i = 0;
        while (i < pairs.length) {
            Object obj2 = pairs[i];
            component1 = obj2.component1();
            component2 = obj2.component2();
            obj = 34;
            str = " for key \"";
            BundleApi21ImplKt.putSizeF(bundle2, (String)component1, (SizeF)component2);
            i++;
            BundleApi21ImplKt.putSize(bundle2, component1, (Size)component2);
            bundle2.putBinder(component1, (IBinder)component2);
            bundle2.putSerializable(component1, (Serializable)component2);
            componentType = component2.getClass().getComponentType();
            Intrinsics.checkNotNull(componentType);
            bundle2.putSerializable(component1, (Serializable)component2);
            Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
            bundle2.putCharSequenceArray(component1, (CharSequence[])component2);
            Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            bundle2.putStringArray(component1, (String[])component2);
            Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
            bundle2.putParcelableArray(component1, (Parcelable[])component2);
            bundle2.putShortArray(component1, (short[])component2);
            bundle2.putLongArray(component1, (long[])component2);
            bundle2.putIntArray(component1, (int[])component2);
            bundle2.putFloatArray(component1, (float[])component2);
            bundle2.putDoubleArray(component1, (double[])component2);
            bundle2.putCharArray(component1, (char[])component2);
            bundle2.putByteArray(component1, (byte[])component2);
            bundle2.putBooleanArray(component1, (boolean[])component2);
            bundle2.putParcelable(component1, (Parcelable)component2);
            bundle2.putCharSequence(component1, (CharSequence)component2);
            bundle2.putBundle(component1, (Bundle)component2);
            bundle2.putShort(component1, (Number)component2.shortValue());
            bundle2.putLong(component1, (Number)component2.longValue());
            bundle2.putInt(component1, (Number)component2.intValue());
            bundle2.putFloat(component1, (Number)component2.floatValue());
            bundle2.putDouble(component1, (Number)component2.doubleValue());
            bundle2.putChar(component1, (Character)component2.charValue());
            bundle2.putByte(component1, (Number)component2.byteValue());
            bundle2.putBoolean(component1, (Boolean)component2.booleanValue());
            bundle2.putString(component1, 0);
        }
        return bundle;
    }
}
