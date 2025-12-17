package androidx.savedstate.serialization;

import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"encodeFormatSpecificTypesOnPlatform", "", "T", "Landroidx/savedstate/serialization/SavedStateEncoder;", "strategy", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Landroidx/savedstate/serialization/SavedStateEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Z", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateEncoder_androidKt {
    public static final <T> boolean encodeFormatSpecificTypesOnPlatform(androidx.savedstate.serialization.SavedStateEncoder $this$encodeFormatSpecificTypesOnPlatform, SerializationStrategy<? super T> strategy, T value) {
        kotlinx.serialization.descriptors.SerialDescriptor descriptor;
        Object iNSTANCE;
        boolean equal4;
        boolean nullablePolymorphicSparseParcelableArrayDescriptor;
        boolean equal3;
        boolean equal;
        boolean equal2;
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$encodeFormatSpecificTypesOnPlatform, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        descriptor = strategy.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.CharSequence");
            CharSequenceSerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (CharSequence)value);
        } else {
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.os.Parcelable");
                DefaultParcelableSerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (Parcelable)value);
            } else {
                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.io.Serializable");
                    DefaultJavaSerializableSerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (Serializable)value);
                } else {
                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.os.IBinder");
                        IBinderSerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (IBinder)value);
                    } else {
                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor())) {
                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                                CharSequenceArraySerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (CharSequence[])value);
                            } else {
                                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor())) {
                                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.CharSequence>");
                                        CharSequenceListSerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (List)value);
                                    } else {
                                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
                                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
                                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                                                ParcelableArraySerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (Parcelable[])value);
                                            } else {
                                                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor())) {
                                                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
                                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<android.os.Parcelable>");
                                                        ParcelableListSerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (List)value);
                                                    } else {
                                                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) && Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
                                                            if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor())) {
                                                                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
                                                                }
                                                                return 0;
                                                            }
                                                        }
                                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.util.SparseArray<android.os.Parcelable>");
                                                        SparseParcelableArraySerializer.INSTANCE.serialize((Encoder)$this$encodeFormatSpecificTypesOnPlatform, (SparseArray)value);
                                                    }
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        }
        return 1;
    }
}
