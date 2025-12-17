package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0008\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0008\u001a\u00020\tH\u0002J\u001e\u0010\u0016\u001a\u00020\t2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u0019H\u0002J$\u0010\u001a\u001a\u00028\u00002\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u0019H\u0096\u0002¢\u0006\u0002\u0010\u001bJ,\u0010\u001c\u001a\u00020\u00152\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u00192\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001e", d2 = {"Landroidx/savedstate/serialization/SavedStateRegistryOwnerDelegate;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "serializer", "Lkotlinx/serialization/KSerializer;", "key", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "init", "Lkotlin/Function0;", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlin/jvm/functions/Function0;)V", "value", "Ljava/lang/Object;", "loadValue", "(Ljava/lang/String;)Ljava/lang/Object;", "registerSave", "", "createDefaultKey", "thisRef", "property", "Lkotlin/reflect/KProperty;", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SavedStateRegistryOwnerDelegate<T>  implements ReadWriteProperty<Object, T> {

    private final androidx.savedstate.serialization.SavedStateConfiguration configuration;
    private final Function0<T> init;
    private final String key;
    private final SavedStateRegistry registry;
    private final KSerializer<T> serializer;
    private T value;
    public static Bundle $r8$lambda$EtjurH72ndQ_fM1SoZeyqbWaj80(androidx.savedstate.serialization.SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate) {
        return SavedStateRegistryOwnerDelegate.registerSave$lambda$1(savedStateRegistryOwnerDelegate);
    }

    public SavedStateRegistryOwnerDelegate(SavedStateRegistry registry, KSerializer<T> serializer, String key, androidx.savedstate.serialization.SavedStateConfiguration configuration, Function0<? extends T> init) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(init, "init");
        super();
        this.registry = registry;
        this.serializer = serializer;
        this.key = key;
        this.configuration = configuration;
        this.init = init;
    }

    private final String createDefaultKey(Object thisRef, KProperty<?> property) {
        String string;
        int i;
        if (thisRef != null) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append(Reflection.getOrCreateKotlinClass(thisRef.getClass()).getQualifiedName()).append('.').toString();
        } else {
            string = "";
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        return stringBuilder2.append(string).append(property.getName()).toString();
    }

    private final T loadValue(String key) {
        int i;
        Object decodeFromSavedState;
        androidx.savedstate.serialization.SavedStateConfiguration configuration;
        Bundle consumeRestoredStateForKey = this.registry.consumeRestoredStateForKey(key);
        if (consumeRestoredStateForKey != null) {
            i = 0;
            decodeFromSavedState = SavedStateDecoderKt.decodeFromSavedState((DeserializationStrategy)this.serializer, consumeRestoredStateForKey, this.configuration);
        } else {
            decodeFromSavedState = 0;
        }
        return decodeFromSavedState;
    }

    private final void registerSave(String key) {
        SavedStateRegistryOwnerDelegate$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SavedStateRegistryOwnerDelegate$$ExternalSyntheticLambda0(this);
        this.registry.registerSavedStateProvider(key, externalSyntheticLambda0);
    }

    private static final Bundle registerSave$lambda$1(androidx.savedstate.serialization.SavedStateRegistryOwnerDelegate this$0) {
        Object iNSTANCE;
        if (this$0.value == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
            iNSTANCE = Unit.INSTANCE;
        }
        return SavedStateEncoderKt.encodeToSavedState((SerializationStrategy)this$0.serializer, iNSTANCE, this$0.configuration);
    }

    public T getValue(Object thisRef, KProperty<?> property) {
        Object defaultKey;
        Object qualifiedKey;
        Object invoke;
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.value == null && this.key == null) {
            if (this.key == null) {
                defaultKey = createDefaultKey(thisRef, property);
            }
            registerSave(defaultKey);
            if (loadValue(defaultKey) == null) {
                invoke = this.init.invoke();
            }
            this.value = invoke;
        }
        if (this.value == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
            qualifiedKey = Unit.INSTANCE;
        }
        return qualifiedKey;
    }

    public void setValue(Object thisRef, KProperty<?> property, T value) {
        String defaultKey;
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.value == null && this.key == null) {
            if (this.key == null) {
                defaultKey = createDefaultKey(thisRef, property);
            }
            registerSave(defaultKey);
        }
        this.value = value;
    }
}
