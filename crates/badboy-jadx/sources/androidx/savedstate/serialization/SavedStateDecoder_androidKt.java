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
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a$\u0010\u0006\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\t0\u00080\u00072\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0002¨\u0006\u000b", d2 = {"decodeFormatSpecificTypesOnPlatform", "T", "Landroidx/savedstate/serialization/SavedStateDecoder;", "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Landroidx/savedstate/serialization/SavedStateDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "getArrayKClass", "Lkotlin/reflect/KClass;", "", "", "referenceArraySerializer", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateDecoder_androidKt {
    public static final <T> T decodeFormatSpecificTypesOnPlatform(androidx.savedstate.serialization.SavedStateDecoder $this$decodeFormatSpecificTypesOnPlatform, DeserializationStrategy<? extends T> strategy) {
        kotlinx.serialization.descriptors.SerialDescriptor descriptor;
        android.os.Parcelable parcelableArr;
        boolean equal;
        boolean equal3;
        boolean nullablePolymorphicSparseParcelableArrayDescriptor;
        boolean equal2;
        int length;
        Class javaClass;
        Intrinsics.checkNotNullParameter($this$decodeFormatSpecificTypesOnPlatform, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        descriptor = strategy.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            parcelableArr = CharSequenceSerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
        } else {
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
                parcelableArr = DefaultParcelableSerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
            } else {
                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
                    parcelableArr = DefaultJavaSerializableSerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                } else {
                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
                        parcelableArr = IBinderSerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                    } else {
                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor())) {
                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
                                parcelableArr = CharSequenceArraySerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                            } else {
                                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor())) {
                                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
                                        parcelableArr = CharSequenceListSerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                                    } else {
                                        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
                                            android.os.Parcelable[] deserialize = ParcelableArraySerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                                            parcelableArr = Arrays.copyOf(deserialize, deserialize.length, JvmClassMappingKt.getJavaClass(SavedStateDecoder_androidKt.getArrayKClass(strategy)));
                                        } else {
                                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
                                                parcelableArr = ParcelableArraySerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                                            } else {
                                                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor())) {
                                                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
                                                        parcelableArr = ParcelableListSerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                                                    } else {
                                                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor())) {
                                                            if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor())) {
                                                                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
                                                                    parcelableArr = SparseParcelableArraySerializer.INSTANCE.deserialize((Decoder)$this$decodeFormatSpecificTypesOnPlatform);
                                                                } else {
                                                                    parcelableArr = 0;
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    }
                                                } else {
                                                }
                                            }
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
        return parcelableArr;
    }

    private static final KClass<Object[]> getArrayKClass(DeserializationStrategy<?> referenceArraySerializer) {
        Object deserialize = referenceArraySerializer.deserialize((Decoder)EmptyArrayDecoder.INSTANCE);
        Intrinsics.checkNotNull(deserialize);
        return Reflection.getOrCreateKotlinClass(deserialize.getClass());
    }
}
