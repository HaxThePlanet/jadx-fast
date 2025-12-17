package androidx.savedstate.serialization;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a0\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0086\u0008¢\u0006\u0002\u0010\u0008\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\n2\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u000c", d2 = {"decodeFromSavedState", "T", "", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateDecoderKt {
    public static final <T> T decodeFromSavedState(Bundle savedState, androidx.savedstate.serialization.SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateDecoderKt.decodeFromSavedState((DeserializationStrategy)SerializersKt.serializer(configuration.getSerializersModule(), 0), savedState, configuration);
    }

    public static final <T> T decodeFromSavedState(DeserializationStrategy<? extends T> deserializer, Bundle savedState) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        int i = 0;
        return SavedStateDecoderKt.decodeFromSavedState$default(deserializer, savedState, i, 4, i);
    }

    public static final <T> T decodeFromSavedState(DeserializationStrategy<? extends T> deserializer, Bundle savedState, androidx.savedstate.serialization.SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        SavedStateDecoder savedStateDecoder = new SavedStateDecoder(savedState, configuration);
        return savedStateDecoder.decodeSerializableValue(deserializer);
    }

    public static Object decodeFromSavedState$default(Bundle savedState, androidx.savedstate.serialization.SavedStateConfiguration configuration, int i3, Object object4) {
        androidx.savedstate.serialization.SavedStateConfiguration obj3;
        if (i3 &= 2 != 0) {
            obj3 = SavedStateConfiguration.DEFAULT;
        }
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(obj3, "configuration");
        int obj4 = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateDecoderKt.decodeFromSavedState((DeserializationStrategy)SerializersKt.serializer(obj3.getSerializersModule(), 0), savedState, obj3);
    }

    public static Object decodeFromSavedState$default(DeserializationStrategy deserializationStrategy, Bundle bundle2, androidx.savedstate.serialization.SavedStateConfiguration savedStateConfiguration3, int i4, Object object5) {
        androidx.savedstate.serialization.SavedStateConfiguration obj2;
        if (i4 &= 4 != 0) {
            obj2 = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateDecoderKt.decodeFromSavedState(deserializationStrategy, bundle2, obj2);
    }
}
