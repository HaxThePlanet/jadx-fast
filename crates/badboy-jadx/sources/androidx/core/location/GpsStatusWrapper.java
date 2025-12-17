package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* loaded from: classes5.dex */
class GpsStatusWrapper extends androidx.core.location.GnssStatusCompat {

    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    private Iterator<GpsSatellite> mCachedIterator;
    private int mCachedIteratorPosition = -1;
    private GpsSatellite mCachedSatellite = null;
    private int mCachedSatelliteCount = -1;
    private final GpsStatus mWrapped;
    GpsStatusWrapper(GpsStatus gpsStatus) {
        super();
        this.mWrapped = (GpsStatus)Preconditions.checkNotNull(gpsStatus);
        int i = -1;
        this.mCachedIterator = this.mWrapped.getSatellites().iterator();
        int i2 = 0;
    }

    private static int getConstellationFromPrn(int prn) {
        int i;
        int i3;
        int i2;
        if (prn > 0 && prn <= 32) {
            if (prn <= 32) {
                return 1;
            }
        }
        i2 = 64;
        if (prn >= 33 && prn <= i2) {
            if (prn <= i2) {
                return 2;
            }
        }
        if (prn > i2 && prn <= 88) {
            if (prn <= 88) {
                return 3;
            }
        }
        int i4 = 200;
        if (prn > i4 && prn <= 235) {
            if (prn <= 235) {
                return 5;
            }
        }
        if (prn >= 193 && prn <= i4) {
            if (prn <= i4) {
                return 4;
            }
        }
        return 0;
    }

    private GpsSatellite getSatellite(int satelliteIndex) {
        int mCachedIteratorPosition;
        int mCachedIteratorPosition2;
        GpsStatus mWrapped = this.mWrapped;
        synchronized (mWrapped) {
            this.mCachedIterator = this.mWrapped.getSatellites().iterator();
            this.mCachedIteratorPosition = -1;
            while (this.mCachedIteratorPosition < satelliteIndex) {
                this.mCachedIteratorPosition = mCachedIteratorPosition3++;
                if (!this.mCachedIterator.hasNext()) {
                    break;
                } else {
                }
                this.mCachedSatellite = (GpsSatellite)this.mCachedIterator.next();
            }
            return (GpsSatellite)Preconditions.checkNotNull(this.mCachedSatellite);
        }
    }

    private static int getSvidFromPrn(int prn) {
        int obj1;
        switch (constellationFromPrn) {
            case 2:
                prn += 87;
                break;
            case 3:
                prn += -64;
                break;
            case 4:
                break;
            default:
                prn += -200;
        }
        return obj1;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean equals(Object o) {
        if (this == o) {
            return 1;
        }
        if (!o instanceof GpsStatusWrapper) {
            return 0;
        }
        return this.mWrapped.equals(obj.mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int satelliteIndex) {
        return getSatellite(satelliteIndex).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int satelliteIndex) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int satelliteIndex) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int satelliteIndex) {
        return getSatellite(satelliteIndex).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int satelliteIndex) {
        return GpsStatusWrapper.getConstellationFromPrn(getSatellite(satelliteIndex).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int satelliteIndex) {
        return getSatellite(satelliteIndex).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int mCachedSatelliteCount;
        int next;
        int i;
        final GpsStatus mWrapped = this.mWrapped;
        synchronized (mWrapped) {
            Iterator iterator = this.mWrapped.getSatellites().iterator();
            for (GpsSatellite next : iterator) {
                this.mCachedSatelliteCount = mCachedSatelliteCount4++;
            }
            this.mCachedSatelliteCount = mCachedSatelliteCount3++;
            return this.mCachedSatelliteCount;
        }
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int satelliteIndex) {
        return GpsStatusWrapper.getSvidFromPrn(getSatellite(satelliteIndex).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int satelliteIndex) {
        return getSatellite(satelliteIndex).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int satelliteIndex) {
        return 0;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int satelliteIndex) {
        return 0;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int satelliteIndex) {
        return getSatellite(satelliteIndex).hasEphemeris();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int satelliteIndex) {
        return getSatellite(satelliteIndex).usedInFix();
    }
}
