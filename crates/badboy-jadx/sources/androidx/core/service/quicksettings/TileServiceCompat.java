package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build.VERSION;
import android.service.quicksettings.TileService;

/* loaded from: classes5.dex */
public class TileServiceCompat {

    private static androidx.core.service.quicksettings.TileServiceCompat.TileServiceWrapper sTileServiceWrapper;

    private static class Api24Impl {
        static void startActivityAndCollapse(TileService service, Intent intent) {
            service.startActivityAndCollapse(intent);
        }
    }

    private static class Api34Impl {
        static void startActivityAndCollapse(TileService service, PendingIntent pendingIntent) {
            service.startActivityAndCollapse(pendingIntent);
        }
    }

    interface TileServiceWrapper {
        public abstract void startActivityAndCollapse(PendingIntent pendingIntent);

        public abstract void startActivityAndCollapse(Intent intent);
    }
    public static void clearTileServiceWrapper() {
        TileServiceCompat.sTileServiceWrapper = 0;
    }

    public static void setTileServiceWrapper(androidx.core.service.quicksettings.TileServiceCompat.TileServiceWrapper serviceWrapper) {
        TileServiceCompat.sTileServiceWrapper = serviceWrapper;
    }

    public static void startActivityAndCollapse(TileService tileService, androidx.core.service.quicksettings.PendingIntentActivityWrapper wrapper) {
        Object sTileServiceWrapper;
        int pendingIntent;
        if (Build.VERSION.SDK_INT >= 34) {
            if (TileServiceCompat.sTileServiceWrapper != null) {
                TileServiceCompat.sTileServiceWrapper.startActivityAndCollapse(wrapper.getPendingIntent());
            } else {
                TileServiceCompat.Api34Impl.startActivityAndCollapse(tileService, wrapper.getPendingIntent());
            }
        } else {
            if (TileServiceCompat.sTileServiceWrapper != null) {
                TileServiceCompat.sTileServiceWrapper.startActivityAndCollapse(wrapper.getIntent());
            } else {
                TileServiceCompat.Api24Impl.startActivityAndCollapse(tileService, wrapper.getIntent());
            }
        }
    }
}
