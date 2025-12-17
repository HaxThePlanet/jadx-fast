package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001:\u0002\u0008\tB\t\u0008\u0004¢\u0006\u0004\u0008\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0010\u0010\u0006\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u0007H¦\u0002\u0082\u0001\u0002\n\u000b¨\u0006\u000c", d2 = {"Lkotlinx/serialization/modules/ContextualProvider;", "", "<init>", "()V", "invoke", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", "", "Argless", "WithTypeArguments", "Lkotlinx/serialization/modules/ContextualProvider$Argless;", "Lkotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ContextualProvider {

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001f\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\u00032\u0010\u0010\t\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\nH\u0096\u0002J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0011", d2 = {"Lkotlinx/serialization/modules/ContextualProvider$Argless;", "Lkotlinx/serialization/modules/ContextualProvider;", "serializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "invoke", "typeArgumentsSerializers", "", "equals", "", "other", "", "hashCode", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Argless extends kotlinx.serialization.modules.ContextualProvider {

        private final KSerializer<?> serializer;
        public Argless(KSerializer<?> serializer) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            super(0);
            this.serializer = serializer;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public boolean equals(Object other) {
            boolean equal;
            int i;
            KSerializer serializer;
            if (other instanceof ContextualProvider.Argless && Intrinsics.areEqual(obj.serializer, this.serializer)) {
                i = Intrinsics.areEqual(obj.serializer, this.serializer) ? 1 : 0;
            } else {
            }
            return i;
        }

        public final KSerializer<?> getSerializer() {
            return this.serializer;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public int hashCode() {
            return this.serializer.hashCode();
        }

        public KSerializer<?> invoke(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.serializer;
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B8\u0012/\u0010\u0002\u001a+\u0012\u001d\u0012\u001b\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u0004¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u001f\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0010\u0010\u0008\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u0004H\u0096\u0002R:\u0010\u0002\u001a+\u0012\u001d\u0012\u001b\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u0004¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Lkotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "Lkotlinx/serialization/modules/ContextualProvider;", "provider", "Lkotlin/Function1;", "", "Lkotlinx/serialization/KSerializer;", "Lkotlin/ParameterName;", "name", "typeArgumentsSerializers", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getProvider", "()Lkotlin/jvm/functions/Function1;", "invoke", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WithTypeArguments extends kotlinx.serialization.modules.ContextualProvider {

        private final Function1<List<? extends KSerializer<?>>, KSerializer<?>> provider;
        public WithTypeArguments(Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            super(0);
            this.provider = provider;
        }

        public final Function1<List<? extends KSerializer<?>>, KSerializer<?>> getProvider() {
            return this.provider;
        }

        public KSerializer<?> invoke(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return (KSerializer)this.provider.invoke(typeArgumentsSerializers);
        }
    }
    public ContextualProvider(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract KSerializer<?> invoke(List<? extends KSerializer<?>> list);
}
