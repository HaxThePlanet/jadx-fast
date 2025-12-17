package com.prototype.badboy;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0012\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/prototype/badboy/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {

    public static final int $stable = 8;
    private final ActivityResultLauncher<String[]> requestPermissionLauncher;
    public static void $r8$lambda$7u561eQ3s5AB_JPVcMzyblfPNWQ(Map map) {
        MainActivity.requestPermissionLauncher$lambda$0(map);
    }

    static {
        final int i = 8;
    }

    public MainActivity() {
        super();
        ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
        MainActivity$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new MainActivity$$ExternalSyntheticLambda0();
        this.requestPermissionLauncher = registerForActivityResult((ActivityResultContract)requestMultiplePermissions, externalSyntheticLambda0);
    }

    public static final ActivityResultLauncher access$getRequestPermissionLauncher$p(com.prototype.badboy.MainActivity $this) {
        return $this.requestPermissionLauncher;
    }

    private static final void requestPermissionLauncher$lambda$0(Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
    }

    @Override // androidx.activity.ComponentActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int i2 = 0;
        EdgeToEdge.enable$default((ComponentActivity)this, i2, i2, 3, i2);
        MainActivity.onCreate.1 anon = new MainActivity.onCreate.1(this);
        final int i4 = 1;
        ComponentActivityKt.setContent$default((ComponentActivity)this, i2, (Function2)ComposableLambdaKt.composableLambdaInstance(1736429986, i4, anon), i4, i2);
    }
}
