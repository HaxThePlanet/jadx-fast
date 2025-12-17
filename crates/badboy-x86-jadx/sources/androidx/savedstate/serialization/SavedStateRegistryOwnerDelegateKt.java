package androidx.savedstate.serialization;

import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aP\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\u0008\u0000\u0010\u0003\u0018\u0001*\u00020\u0002*\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000e\u0008\u0008\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\nH\u0086\u0008ø\u0001\u0000\u001aT\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0008\u0008\u0000\u0010\u0003*\u00020\u0002*\u00020\u00042\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u000c2\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\n\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\r", d2 = {"saved", "Lkotlin/properties/ReadWriteProperty;", "", "T", "Landroidx/savedstate/SavedStateRegistryOwner;", "key", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "init", "Lkotlin/Function0;", "serializer", "Lkotlinx/serialization/KSerializer;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateRegistryOwnerDelegateKt {
    public static final <T> ReadWriteProperty<Object, T> saved(SavedStateRegistryOwner $this$saved, String key, androidx.savedstate.serialization.SavedStateConfiguration configuration, Function0<? extends T> init) {
        Intrinsics.checkNotNullParameter($this$saved, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(init, "init");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateRegistryOwnerDelegateKt.saved($this$saved, SerializersKt.serializer(configuration.getSerializersModule(), 0), key, configuration, init);
    }

    public static final <T> ReadWriteProperty<Object, T> saved(SavedStateRegistryOwner $this$saved, KSerializer<T> serializer, String key, androidx.savedstate.serialization.SavedStateConfiguration configuration, Function0<? extends T> init) {
        Intrinsics.checkNotNullParameter($this$saved, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(init, "init");
        SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate = new SavedStateRegistryOwnerDelegate($this$saved.getSavedStateRegistry(), serializer, key, configuration, init);
        return (ReadWriteProperty)savedStateRegistryOwnerDelegate;
    }

    public static ReadWriteProperty saved$default(SavedStateRegistryOwner $this$saved_u24default, String key, androidx.savedstate.serialization.SavedStateConfiguration configuration, Function0 init, int i5, Object object6) {
        int obj3;
        androidx.savedstate.serialization.SavedStateConfiguration obj4;
        if (i5 & 1 != 0) {
            obj3 = 0;
        }
        if (i5 &= 2 != 0) {
            obj4 = SavedStateConfiguration.DEFAULT;
        }
        Intrinsics.checkNotNullParameter($this$saved_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj4, "configuration");
        Intrinsics.checkNotNullParameter(init, "init");
        int obj6 = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateRegistryOwnerDelegateKt.saved($this$saved_u24default, SerializersKt.serializer(obj4.getSerializersModule(), 0), obj3, obj4, init);
    }

    public static ReadWriteProperty saved$default(SavedStateRegistryOwner savedStateRegistryOwner, KSerializer kSerializer2, String string3, androidx.savedstate.serialization.SavedStateConfiguration savedStateConfiguration4, Function0 function05, int i6, Object object7) {
        int obj2;
        androidx.savedstate.serialization.SavedStateConfiguration obj3;
        if (i6 & 2 != 0) {
            obj2 = 0;
        }
        if (i6 &= 4 != 0) {
            obj3 = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateRegistryOwnerDelegateKt.saved(savedStateRegistryOwner, kSerializer2, obj2, obj3, function05);
    }
}
