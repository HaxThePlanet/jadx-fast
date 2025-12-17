package androidx.core.view;

import android.app.Activity;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* loaded from: classes5.dex */
public final class DragAndDropPermissionsCompat {

    private final DragAndDropPermissions mDragAndDropPermissions;

    static class Api24Impl {
        static void release(DragAndDropPermissions dragAndDropPermissions) {
            dragAndDropPermissions.release();
        }

        static DragAndDropPermissions requestDragAndDropPermissions(Activity activity, DragEvent event) {
            return activity.requestDragAndDropPermissions(event);
        }
    }
    private DragAndDropPermissionsCompat(DragAndDropPermissions dragAndDropPermissions) {
        super();
        this.mDragAndDropPermissions = dragAndDropPermissions;
    }

    public static androidx.core.view.DragAndDropPermissionsCompat request(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions requestDragAndDropPermissions = DragAndDropPermissionsCompat.Api24Impl.requestDragAndDropPermissions(activity, dragEvent);
        if (requestDragAndDropPermissions != null) {
            DragAndDropPermissionsCompat dragAndDropPermissionsCompat = new DragAndDropPermissionsCompat(requestDragAndDropPermissions);
            return dragAndDropPermissionsCompat;
        }
        return null;
    }

    public void release() {
        DragAndDropPermissionsCompat.Api24Impl.release(this.mDragAndDropPermissions);
    }
}
