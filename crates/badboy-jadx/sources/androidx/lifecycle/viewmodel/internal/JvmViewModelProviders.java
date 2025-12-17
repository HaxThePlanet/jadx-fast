package androidx.lifecycle.viewmodel.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J#\u0010\u0004\u001a\u0002H\u0005\"\u0008\u0008\u0000\u0010\u0005*\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0008¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"Landroidx/lifecycle/viewmodel/internal/JvmViewModelProviders;", "", "<init>", "()V", "createViewModel", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JvmViewModelProviders {

    public static final androidx.lifecycle.viewmodel.internal.JvmViewModelProviders INSTANCE;
    static {
        JvmViewModelProviders jvmViewModelProviders = new JvmViewModelProviders();
        JvmViewModelProviders.INSTANCE = jvmViewModelProviders;
    }

    public final <T extends androidx.lifecycle.ViewModel> T createViewModel(Class<T> modelClass) {
        final String str = "Cannot create an instance of ";
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        int i = 0;
        Object instance = modelClass.getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
        Intrinsics.checkNotNull(instance);
        return (ViewModel)instance;
    }
}
