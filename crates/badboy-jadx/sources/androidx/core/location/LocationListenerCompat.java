package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes5.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    public void onFlushComplete(int requestCode) {
    }

    public void onLocationChanged(List<Location> list) {
        int i;
        Object obj;
        i = 0;
        while (i < list.size()) {
            onLocationChanged((Location)list.get(i));
            i++;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String provider) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String provider) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}
