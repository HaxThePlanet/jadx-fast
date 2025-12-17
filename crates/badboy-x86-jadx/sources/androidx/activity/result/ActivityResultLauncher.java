package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008&\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u000f\u001a\u00020\tH'R\u001c\u0010\u0004\u001a\u000c\u0012\u0004\u0012\u00028\u0000\u0012\u0002\u0008\u00030\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0010", d2 = {"Landroidx/activity/result/ActivityResultLauncher;", "I", "", "()V", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "getContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "launch", "", "input", "(Ljava/lang/Object;)V", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ActivityResultLauncher<I>  {
    public abstract ActivityResultContract<I, ?> getContract();

    public void launch(I input) {
        launch(input, 0);
    }

    public abstract void launch(I i, ActivityOptionsCompat activityOptionsCompat2);

    public abstract void unregister();
}
