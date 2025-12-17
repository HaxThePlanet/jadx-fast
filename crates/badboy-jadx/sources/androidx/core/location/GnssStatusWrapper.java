package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build.VERSION;
import androidx.core.util.Preconditions;

/* loaded from: classes5.dex */
class GnssStatusWrapper extends androidx.core.location.GnssStatusCompat {

    private final GnssStatus mWrapped;

    static class Api26Impl {
        static float getCarrierFrequencyHz(GnssStatus gnssStatus, int satelliteIndex) {
            return gnssStatus.getCarrierFrequencyHz(satelliteIndex);
        }

        static boolean hasCarrierFrequencyHz(GnssStatus gnssStatus, int satelliteIndex) {
            return gnssStatus.hasCarrierFrequencyHz(satelliteIndex);
        }
    }

    static class Api30Impl {
        static float getBasebandCn0DbHz(GnssStatus gnssStatus, int satelliteIndex) {
            return gnssStatus.getBasebandCn0DbHz(satelliteIndex);
        }

        static boolean hasBasebandCn0DbHz(GnssStatus gnssStatus, int satelliteIndex) {
            return gnssStatus.hasBasebandCn0DbHz(satelliteIndex);
        }
    }
    GnssStatusWrapper(Object gnssStatus) {
        super();
        this.mWrapped = (GnssStatus)Preconditions.checkNotNull((GnssStatus)gnssStatus);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean equals(Object o) {
        if (this == o) {
            return 1;
        }
        if (!o instanceof GnssStatusWrapper) {
            return 0;
        }
        return this.mWrapped.equals(obj.mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int satelliteIndex) {
        return this.mWrapped.getAzimuthDegrees(satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int satelliteIndex) {
        if (Build.VERSION.SDK_INT < 30) {
        } else {
            return GnssStatusWrapper.Api30Impl.getBasebandCn0DbHz(this.mWrapped, satelliteIndex);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int satelliteIndex) {
        return GnssStatusWrapper.Api26Impl.getCarrierFrequencyHz(this.mWrapped, satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int satelliteIndex) {
        return this.mWrapped.getCn0DbHz(satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int satelliteIndex) {
        return this.mWrapped.getConstellationType(satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int satelliteIndex) {
        return this.mWrapped.getElevationDegrees(satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int satelliteIndex) {
        return this.mWrapped.getSvid(satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int satelliteIndex) {
        return this.mWrapped.hasAlmanacData(satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int satelliteIndex) {
        if (Build.VERSION.SDK_INT >= 30) {
            return GnssStatusWrapper.Api30Impl.hasBasebandCn0DbHz(this.mWrapped, satelliteIndex);
        }
        return 0;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int satelliteIndex) {
        return GnssStatusWrapper.Api26Impl.hasCarrierFrequencyHz(this.mWrapped, satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int satelliteIndex) {
        return this.mWrapped.hasEphemerisData(satelliteIndex);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int satelliteIndex) {
        return this.mWrapped.usedInFix(satelliteIndex);
    }
}
