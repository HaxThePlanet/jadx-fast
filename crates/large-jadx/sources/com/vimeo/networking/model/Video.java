package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import com.vimeo.networking.model.playback.Play;
import com.vimeo.networking.model.playback.Play.Status;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* compiled from: Video.java */
/* loaded from: classes2.dex */
public class Video implements Serializable {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String STATUS_AVAILABLE = "available";
    private static final String STATUS_NONE = "N/A";
    private static final String STATUS_QUOTA_EXCEEDED = "quota_exceeded";
    private static final String STATUS_TRANSCODE_STARTING = "transcode_starting";
    private static final String STATUS_TRANSCODING = "transcoding";
    private static final String STATUS_TRANSCODING_ERROR = "transcoding_error";
    private static final String STATUS_UPLOADING = "uploading";
    private static final String STATUS_UPLOADING_ERROR = "uploading_error";
    private static final long serialVersionUID = -1282907783845240057L;
    public ArrayList<Category> categories;
    public ArrayList<String> contentRating;
    public Date createdTime;
    public String description;
    public ArrayList<VideoFile> download;
    public int duration;
    @Deprecated
    public Embed embed;
    @Deprecated
    public ArrayList<VideoFile> files;
    public int height;
    public String language;
    public String license;
    public String link;
    public Metadata metadata;
    public Date modifiedTime;
    public String name;
    public String password;
    public PictureCollection pictures;
    public Play play;
    public Privacy privacy;
    public Date releaseTime;
    public String resourceKey;
    public String reviewLink;
    public StatsCollection stats;
    public Video.Status status;
    public ArrayList<Tag> tags;
    public String uri;
    public User user;
    public int width;

    public enum ContentRating {

        DRUGS,
        LANGUAGE,
        NUDITY,
        SAFE,
        UNRATED,
        VIOLENCE;
    }

    public enum LicenseValue {

        ATTRIBUTION,
        ATTRIBUTION_NON_COMMERCIAL,
        ATTRIBUTION_NON_COMMERCIAL_NO_DERIVATIVES,
        ATTRIBUTION_NON_COMMERCIAL_SHARE_ALIKE,
        ATTRIBUTION_NO_DERIVATIVES,
        ATTRIBUTION_SHARE_ALIKE,
        PUBLIC_DOMAIN_DEDICATION;
    }

    public enum Status {

        AVAILABLE,
        NONE,
        QUOTA_EXCEEDED,
        TRANSCODE_STARTING,
        TRANSCODING,
        TRANSCODING_ERROR,
        UPLOADING,
        UPLOADING_ERROR;

        private final String mString;
        @Override // java.lang.Enum
        public String toString() {
            return this.mString;
        }
    }

    public enum VodVideoType {

        NONE,
        PURCHASE,
        RENTAL,
        SUBSCRIPTION,
        TRAILER,
        UNKNOWN;
    }

    private boolean isPossiblePurchase() {
        boolean z = true;
        int r0 = isVod() && !this.isTrailer() && this.metadata != null && metadata2.interactions != null ? 1 : 0;
        return (isVod() && !this.isTrailer() && this.metadata != null && metadata2.interactions != null ? 1 : 0);
    }

    private static boolean isPurchased(Interaction interaction) {
        com.vimeo.networking.model.Interaction.Stream pURCHASED2;
        boolean z = false;
        if (interaction != null) {
            interaction = interaction.stream == Interaction.Stream.PURCHASED ? 1 : 0;
        }
        return (interaction.stream == Interaction.Stream.PURCHASED ? 1 : 0);
    }

    public boolean canLike() {
        boolean z = true;
        int r0 = getLikeInteraction() != null ? 1 : 0;
        return (getLikeInteraction() != null ? 1 : 0);
    }

    public boolean canWatchLater() {
        boolean z = true;
        int r0 = getWatchLaterInteraction() != null ? 1 : 0;
        return (getWatchLaterInteraction() != null ? 1 : 0);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        String resourceKey2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            z2 = object instanceof Video;
            if (object instanceof Video) {
                if (this.resourceKey == null || object.resourceKey == null || !this.resourceKey.equals(object.resourceKey)) {
                }
            }
            return z;
        }
        return false;
    }

    public ArrayList<VideoFile> getDownload() {
        return this.download;
    }

    public Interaction getLikeInteraction() {
        if (this.metadata != null && metadata2.interactions != null && interactions2.like != null) {
            return interactions2.like;
        }
        return null;
    }

    public Connection getLikesConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.likes != null) {
            return connections2.likes;
        }
        return null;
    }

    public String getPassword() {
        return this.password;
    }

    public Play getPlay() {
        return this.play;
    }

    public Play.Status getPlayStatus() {
        if (this.play != null) {
            return this.play.getStatus();
        }
        return null;
    }

    public String getPlaybackFailureUri() {
        String uri2 = null;
        String r0 = this.metadata != null && metadata2.connections != null && connections2.playbackFailureReason != null ? playbackFailureReason2.uri : 0;
        return (this.metadata != null && metadata2.connections != null && connections2.playbackFailureReason != null ? playbackFailureReason2.uri : 0);
    }

    public Video.Status getRawStatus() {
        com.vimeo.networking.model.Video.Status status2;
        if (this.status == null) {
            status2 = Video.Status.NONE;
        }
        return status2;
    }

    public Connection getRelatedConnection() {
        if (this.metadata != null && metadata2.connections != null) {
            return connections2.related;
        }
        return null;
    }

    public Date getRentalExpiration() {
        if (isRental()) {
            return this.metadata.interactions.rent.expiration;
        }
        return null;
    }

    public String getResourceKey() {
        return this.resourceKey;
    }

    public String getReviewLink() {
        return this.reviewLink;
    }

    public Video.Status getStatus() {
        if (this.status == Video.Status.TRANSCODE_STARTING) {
            return Video.Status.TRANSCODING;
        }
        return getRawStatus();
    }

    public Date getSubscriptionExpiration() {
        if (isSubscription()) {
            return this.metadata.interactions.subscribe.expiration;
        }
        return null;
    }

    public String getTrailerUri() {
        if (this.metadata != null && metadata2.connections != null && connections2.trailer != null) {
            return trailer2.uri;
        }
        return null;
    }

    public VideoFile getVideoFileForMd5(String str) {
        String md5;
        return null;
    }

    public Date getVodExpiration() {
        if (isVod()) {
            Date rentalExpiration = getRentalExpiration();
            Date subscriptionExpiration = getSubscriptionExpiration();
            if (rentalExpiration != null && subscriptionExpiration != null) {
                return rentalExpiration.after(subscriptionExpiration) ? rentalExpiration : subscriptionExpiration;
            }
            if (rentalExpiration != null) {
                return rentalExpiration;
            }
            if (subscriptionExpiration != null) {
                return subscriptionExpiration;
            }
        }
        return null;
    }

    public Video.VodVideoType getVodVideoType() {
        if (isVod() && this.isTrailer()) {
            return Video.VodVideoType.TRAILER;
        }
        return Video.VodVideoType.NONE;
    }

    public Connection getWatchLaterConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.watchlater != null) {
            return connections2.watchlater;
        }
        return null;
    }

    public Interaction getWatchLaterInteraction() {
        if (this.metadata != null && metadata2.interactions != null && interactions2.watchlater != null) {
            return interactions2.watchlater;
        }
        return null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.resourceKey != null) {
            i = this.resourceKey.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isLiked() {
        boolean z = false;
        if (getLikeInteraction() != null) {
            int r0 = getLikeInteraction().added ? 1 : 0;
        }
        return (getLikeInteraction().added ? 1 : 0);
    }

    public boolean isPurchase() {
        boolean z = false;
        if (isPossiblePurchase()) {
            int r0 = Video.isPurchased(this.metadata.interactions.buy) ? 1 : 0;
        }
        return (Video.isPurchased(this.metadata.interactions.buy) ? 1 : 0);
    }

    public boolean isRental() {
        boolean z = false;
        if (isPossiblePurchase()) {
            int r0 = Video.isPurchased(this.metadata.interactions.rent) ? 1 : 0;
        }
        return (Video.isPurchased(this.metadata.interactions.rent) ? 1 : 0);
    }

    public boolean isSubscription() {
        boolean z = false;
        if (isPossiblePurchase()) {
            int r0 = Video.isPurchased(this.metadata.interactions.subscribe) ? 1 : 0;
        }
        return (Video.isPurchased(this.metadata.interactions.subscribe) ? 1 : 0);
    }

    public boolean isTrailer() {
        boolean z = false;
        if (isVod()) {
            int r0 = this.metadata.connections.trailer == null ? 1 : 0;
        }
        return (this.metadata.connections.trailer == null ? 1 : 0);
    }

    public boolean isVod() {
        boolean z = true;
        int r0 = this.metadata != null && metadata2.connections != null && connections2.ondemand != null ? 1 : 0;
        return (this.metadata != null && metadata2.connections != null && connections2.ondemand != null ? 1 : 0);
    }

    public boolean isWatchLater() {
        boolean z = false;
        if (getWatchLaterInteraction() != null) {
            int r0 = getWatchLaterInteraction().added ? 1 : 0;
        }
        return (getWatchLaterInteraction().added ? 1 : 0);
    }

    public int likeCount() {
        if (getLikesConnection() != null) {
            return getLikesConnection().total;
        }
        return 0;
    }

    public Integer playCount() {
        if (this.stats != null) {
            return stats2.plays;
        }
        return null;
    }

    public String recommendationsUri() {
        String uri2 = null;
        String r0 = this.metadata != null && metadata2.connections != null && connections2.recommendations != null ? recommendations2.uri : 0;
        if (connections2.recommendations == null) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "/recommendations";
            uri2 = this.uri + str;
        }
        return uri2;
    }

    public void setResourceKey(String str) {
        this.resourceKey = str;
    }

    public void setStatus(Video.Status status) {
        this.status = status;
    }
}
