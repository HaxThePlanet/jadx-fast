package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind.CLASS;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J!\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020\u0016H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0018\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u00101\u001a\u00020\u001dH\u0016J\u0016\u00102\u001a\u00020\u001d2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u001a03H\u0002J\u0016\u00104\u001a\u00020\u001d2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r03H\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020@H\u0002J\u001b\u0010A\u001a\u00020\u001d2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0BH\u0002¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020E2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J)\u0010F\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0002\u0010GJ)\u0010H\u001a\u00020\u001d\"\u0004\u0008\u0000\u0010I2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002HI0K2\u0006\u0010\u000c\u001a\u0002HIH\u0016¢\u0006\u0002\u0010LJ)\u0010M\u001a\u00020\u0016\"\u0004\u0008\u0000\u0010I2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002HI0K2\u0006\u0010\u000c\u001a\u0002HIH\u0002¢\u0006\u0002\u0010NR\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006O", d2 = {"Landroidx/savedstate/serialization/SavedStateEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate_release", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate_release", "()Ljava/lang/String;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "shouldEncodeElementDefault", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "encodeElement", "checkDiscriminatorCollisions", "", "elementName", "(Landroid/os/Bundle;Ljava/lang/String;)V", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "encodeEnum", "enumDescriptor", "encodeNull", "encodeIntList", "", "encodeStringList", "encodeBooleanArray", "", "encodeCharArray", "", "encodeDoubleArray", "", "encodeFloatArray", "", "encodeIntArray", "", "encodeLongArray", "", "encodeStringArray", "", "([Ljava/lang/String;)V", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "putClassDiscriminatorIfRequired", "(Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlinx/serialization/descriptors/SerialDescriptor;Landroid/os/Bundle;)V", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeFormatSpecificTypes", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Z", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateEncoder extends AbstractEncoder {

    private final androidx.savedstate.serialization.SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;
    private final SerializersModule serializersModule;
    public SavedStateEncoder(Bundle savedState, androidx.savedstate.serialization.SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        super();
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
        this.serializersModule = this.configuration.getSerializersModule();
    }

    private final void checkDiscriminatorCollisions(Bundle savedState, String elementName) {
        int classDiscriminatorMode;
        int i;
        boolean $this$checkDiscriminatorCollisions_u24lambda_u240;
        int i2;
        String str;
        i = 0;
        i2 = 0;
        str = "type";
        if (this.configuration.getClassDiscriminatorMode() == 1 && SavedStateReader.contains-impl(SavedStateReader.constructor-impl(savedState), str)) {
            i = 0;
            i2 = 0;
            str = "type";
            if (SavedStateReader.contains-impl(SavedStateReader.constructor-impl(savedState), str)) {
                if (Intrinsics.areEqual(elementName, str)) {
                } else {
                }
                int i3 = 0;
                final int i4 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("SavedStateEncoder for ").append(SavedStateReader.getString-impl(SavedStateReader.constructor-impl(savedState), str)).append(" has property '").append(elementName).append("' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.").toString());
                throw illegalArgumentException;
            }
        }
    }

    private final void encodeBooleanArray(boolean[] value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putBooleanArray-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void encodeCharArray(char[] value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putCharArray-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void encodeDoubleArray(double[] value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putDoubleArray-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void encodeFloatArray(float[] value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putFloatArray-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final <T> boolean encodeFormatSpecificTypes(SerializationStrategy<? super T> serializer, T value) {
        Object obj;
        boolean stringArrayDescriptor;
        if (!SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, serializer, value)) {
            SerialDescriptor descriptor = serializer.getDescriptor();
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
                encodeIntList((List)value);
            } else {
                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    encodeStringList((List)value);
                } else {
                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.BooleanArray");
                        encodeBooleanArray((boolean[])value);
                    } else {
                        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.CharArray");
                            encodeCharArray((char[])value);
                        } else {
                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.DoubleArray");
                                encodeDoubleArray((double[])value);
                            } else {
                                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
                                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.FloatArray");
                                    encodeFloatArray((float[])value);
                                } else {
                                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.IntArray");
                                        encodeIntArray((int[])value);
                                    } else {
                                        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
                                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.LongArray");
                                            encodeLongArray((long[])value);
                                        } else {
                                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
                                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                                                encodeStringArray((String[])value);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    private final void encodeIntArray(int[] value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putIntArray-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void encodeIntList(List<Integer> value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putIntList-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void encodeLongArray(long[] value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putLongArray-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void encodeStringArray(String[] value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putStringArray-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void encodeStringList(List<String> value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putStringList-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    private final void putClassDiscriminatorIfRequired(androidx.savedstate.serialization.SavedStateConfiguration configuration, SerialDescriptor descriptor, Bundle savedState) {
        Bundle equal;
        int iNSTANCE;
        Bundle $this$putClassDiscriminatorIfRequired_u24lambda_u2423;
        int i;
        String serialName;
        if (configuration.getClassDiscriminatorMode() != 1) {
        }
        int i3 = 0;
        i = 0;
        final String str = "type";
        if (SavedStateReader.contains-impl(SavedStateReader.constructor-impl(savedState), str)) {
        }
        if (!Intrinsics.areEqual(descriptor.getKind(), StructureKind.CLASS.INSTANCE)) {
            if (Intrinsics.areEqual(descriptor.getKind(), StructureKind.OBJECT.INSTANCE)) {
                iNSTANCE = 0;
                i = 0;
                SavedStateWriter.putString-impl(SavedStateWriter.constructor-impl(savedState), str, descriptor.getSerialName());
            }
        } else {
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Object savedStateEncoder;
        Object savedState;
        kotlin.Pair[] $i$f$toTypedArray;
        Bundle constructor-impl2;
        int arr;
        Bundle bundleOf;
        ArrayList list;
        Object arrayList;
        Object obj;
        int i;
        Object constructor-impl;
        boolean next;
        kotlin.Pair $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv;
        Object key;
        Object value;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, descriptor, this.savedState);
            savedStateEncoder = this;
        } else {
            Map emptyMap = MapsKt.emptyMap();
            int i2 = 0;
            arr = 0;
            if (emptyMap.isEmpty()) {
                $i$f$toTypedArray = new Pair[arr];
            } else {
                Map map = emptyMap;
                int i5 = 0;
                arrayList = new ArrayList(map.size());
                i = 0;
                constructor-impl = map.entrySet().iterator();
                for (Map.Entry next : constructor-impl) {
                    int i7 = 0;
                    (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
                }
                int i4 = 0;
                $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Pair[arr]);
            }
            bundleOf = BundleKt.bundleOf((Pair[])Arrays.copyOf($i$f$toTypedArray, $i$f$toTypedArray.length));
            int i6 = 0;
            i = 0;
            constructor-impl = SavedStateWriter.constructor-impl(bundleOf);
            next = 0;
            int i3 = 0;
            list = 0;
            SavedStateWriter.putSavedState-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, bundleOf);
            putClassDiscriminatorIfRequired(this.configuration, descriptor, bundleOf);
            savedStateEncoder = new SavedStateEncoder(bundleOf, this.configuration);
        }
        return savedStateEncoder;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeBoolean(boolean value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putBoolean-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeByte(byte value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeChar(char value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putChar-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeDouble(double value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putDouble-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.key = descriptor.getElementName(index);
        checkDiscriminatorCollisions(this.savedState, this.key);
        return 1;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, index);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeFloat(float value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putFloat-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeInt(int value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeLong(long value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putLong-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeNull() {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putNull-impl(SavedStateWriter.constructor-impl(this.savedState), this.key);
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (!encodeFormatSpecificTypes(serializer, value)) {
            super.encodeSerializableValue(serializer, value);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeShort(short value) {
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        final int i = 0;
        final int i2 = 0;
        SavedStateWriter.putString-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public final String getKey$savedstate_release() {
        return this.key;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }
}
