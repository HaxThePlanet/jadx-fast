package androidx.lifecycle;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u0002H\u0007\"\u0008\u0008\u0000\u0010\u0007*\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/lifecycle/AndroidViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getApplication", "T", "()Landroid/app/Application;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class AndroidViewModel extends androidx.lifecycle.ViewModel {

    private final Application application;
    public AndroidViewModel(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        super();
        this.application = application;
    }

    public <T extends Application> T getApplication() {
        final Application application = this.application;
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return application;
    }
}
