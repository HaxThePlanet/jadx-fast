package androidx.savedstate.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B'\u0008\u0002\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0012", d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "classDiscriminatorMode", "", "encodeDefaults", "", "<init>", "(Lkotlinx/serialization/modules/SerializersModule;IZ)V", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getClassDiscriminatorMode", "()I", "getEncodeDefaults", "()Z", "Builder", "Companion", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateConfiguration {

    public static final androidx.savedstate.serialization.SavedStateConfiguration.Companion Companion;
    public static final androidx.savedstate.serialization.SavedStateConfiguration DEFAULT;
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final SerializersModule serializersModule;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\u001b\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR \u0010\u000c\u001a\u00020\rX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R \u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0016\u0010\u000f\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006\u001d", d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "encodeDefaults", "", "getEncodeDefaults$annotations", "()V", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "classDiscriminatorMode", "", "getClassDiscriminatorMode$annotations", "getClassDiscriminatorMode", "()I", "setClassDiscriminatorMode", "(I)V", "build", "build$savedstate_release", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private SerializersModule serializersModule;
        public Builder(androidx.savedstate.serialization.SavedStateConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            super();
            this.serializersModule = configuration.getSerializersModule();
            this.encodeDefaults = configuration.getEncodeDefaults();
            this.classDiscriminatorMode = configuration.getClassDiscriminatorMode();
        }

        public static void getClassDiscriminatorMode$annotations() {
        }

        public static void getEncodeDefaults$annotations() {
        }

        public final androidx.savedstate.serialization.SavedStateConfiguration build$savedstate_release() {
            SavedStateConfiguration savedStateConfiguration = new SavedStateConfiguration(SerializersModuleKt.overwriteWith(SavedStateConfigurationKt.access$getDEFAULT_SERIALIZERS_MODULE$p(), this.serializersModule), this.classDiscriminatorMode, this.encodeDefaults, 0);
            return savedStateConfiguration;
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final SerializersModule getSerializersModule() {
            return this.serializersModule;
        }

        public final void setClassDiscriminatorMode(int <set-?>) {
            this.classDiscriminatorMode = <set-?>;
        }

        public final void setEncodeDefaults(boolean <set-?>) {
            this.encodeDefaults = <set-?>;
        }

        public final void setSerializersModule(SerializersModule <set-?>) {
            Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
            this.serializersModule = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration$Companion;", "", "<init>", "()V", "DEFAULT", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        SavedStateConfiguration.Companion companion = new SavedStateConfiguration.Companion(0);
        SavedStateConfiguration.Companion = companion;
        SavedStateConfiguration savedStateConfiguration = new SavedStateConfiguration(0, 0, 0, 7, 0);
        SavedStateConfiguration.DEFAULT = savedStateConfiguration;
    }

    private SavedStateConfiguration(SerializersModule serializersModule, int classDiscriminatorMode, boolean encodeDefaults) {
        super();
        this.serializersModule = serializersModule;
        this.classDiscriminatorMode = classDiscriminatorMode;
        this.encodeDefaults = encodeDefaults;
    }

    SavedStateConfiguration(SerializersModule serializersModule, int i2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        SerializersModule obj1;
        int obj2;
        int obj3;
        if (i4 & 1 != 0) {
            obj1 = SavedStateConfigurationKt.access$getDEFAULT_SERIALIZERS_MODULE$p();
        }
        obj2 = i4 & 2 != 0 ? 2 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(obj1, obj2, obj3);
    }

    public SavedStateConfiguration(SerializersModule serializersModule, int i2, boolean z3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(serializersModule, i2, z3);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
