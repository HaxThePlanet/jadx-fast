package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import com.vimeo.networking.model.playback.Play;
import com.vimeo.networking.model.playback.Play.Status;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Video implements Serializable {

    static final boolean $assertionsDisabled = false;
    private static final String STATUS_AVAILABLE = "available";
    private static final String STATUS_NONE = "N/A";
    private static final String STATUS_QUOTA_EXCEEDED = "quota_exceeded";
    private static final String STATUS_TRANSCODE_STARTING = "transcode_starting";
    private static final String STATUS_TRANSCODING = "transcoding";
    private static final String STATUS_TRANSCODING_ERROR = "transcoding_error";
    private static final String STATUS_UPLOADING = "uploading";
    private static final String STATUS_UPLOADING_ERROR = "uploading_error";
    private static final long serialVersionUID = -1282907783845240057L;
    public ArrayList<com.vimeo.networking.model.Category> categories;
    public ArrayList<String> contentRating;
    public Date createdTime;
    public String description;
    public ArrayList<com.vimeo.networking.model.VideoFile> download;
    public int duration;
    @Deprecated
    public com.vimeo.networking.model.Embed embed;
    @Deprecated
    public ArrayList<com.vimeo.networking.model.VideoFile> files;
    public int height;
    public String language;
    public String license;
    public String link;
    public com.vimeo.networking.model.Metadata metadata;
    public Date modifiedTime;
    public String name;
    public String password;
    public com.vimeo.networking.model.PictureCollection pictures;
    public Play play;
    public com.vimeo.networking.model.Privacy privacy;
    public Date releaseTime;
    public String resourceKey;
    public String reviewLink;
    public com.vimeo.networking.model.StatsCollection stats;
    public com.vimeo.networking.model.Video.Status status;
    public ArrayList<com.vimeo.networking.model.Tag> tags;
    public String uri;
    public com.vimeo.networking.model.User user;
    public int width;

    public static enum ContentRating {

        SAFE,
        UNRATED,
        NUDITY,
        LANGUAGE,
        DRUGS,
        VIOLENCE;
    }

    public static enum LicenseValue {

        ATTRIBUTION,
        ATTRIBUTION_SHARE_ALIKE,
        ATTRIBUTION_NO_DERIVATIVES,
        ATTRIBUTION_NON_COMMERCIAL,
        ATTRIBUTION_NON_COMMERCIAL_SHARE_ALIKE,
        ATTRIBUTION_NON_COMMERCIAL_NO_DERIVATIVES,
        PUBLIC_DOMAIN_DEDICATION;
    }

    public static enum Status {

        NONE("N/A"),
        AVAILABLE("available"),
        UPLOADING("uploading"),
        TRANSCODE_STARTING("transcode_starting"),
        TRANSCODING("transcoding"),
        UPLOADING_ERROR("uploading_error"),
        TRANSCODING_ERROR("transcoding_error"),
        QUOTA_EXCEEDED(5);

        private final String mString;
        @Override // java.lang.Enum
        public String toString() {
            return this.mString;
        }
    }

    public static enum VodVideoType {

        NONE,
        TRAILER,
        RENTAL,
        SUBSCRIPTION,
        PURCHASE,
        UNKNOWN;
    }
    static {
        final Class<com.vimeo.networking.model.Video> obj = Video.class;
    }

    private boolean isPossiblePurchase() {
        boolean interactions;
        int i;
        interactions = this.metadata;
        if (isVod() && !isTrailer() && interactions != null && interactions.interactions != null) {
            if (!isTrailer()) {
                interactions = this.metadata;
                if (interactions != null) {
                    i = interactions.interactions != null ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static boolean isPurchased(com.vimeo.networking.model.Interaction interaction) {
        com.vimeo.networking.model.Interaction.Stream pURCHASED;
        Object obj1;
        if (interaction != null && interaction.stream == Interaction.Stream.PURCHASED) {
            obj1 = interaction.stream == Interaction.Stream.PURCHASED ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // java.io.Serializable
    public boolean canLike() {
        int i;
        i = getLikeInteraction() != null ? 1 : 0;
        return i;
    }

    @Override // java.io.Serializable
    public boolean canWatchLater() {
        int i;
        i = getWatchLaterInteraction() != null ? 1 : 0;
        return i;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        boolean z;
        boolean obj4;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (!object instanceof Video) {
            } else {
                String resourceKey = this.resourceKey;
                obj4 = object.resourceKey;
                if (resourceKey != null && obj4 != null && resourceKey.equals(obj4)) {
                    obj4 = object.resourceKey;
                    if (obj4 != null) {
                        if (resourceKey.equals(obj4)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public ArrayList<com.vimeo.networking.model.VideoFile> getDownload() {
        return this.download;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Interaction getLikeInteraction() {
        Object interactions;
        interactions = this.metadata;
        interactions = interactions.interactions;
        interactions = interactions.like;
        if (interactions != null && interactions != null && interactions != null) {
            interactions = interactions.interactions;
            if (interactions != null) {
                interactions = interactions.like;
                if (interactions != null) {
                    return interactions;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getLikesConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.likes;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.likes;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public String getPassword() {
        return this.password;
    }

    @Override // java.io.Serializable
    public Play getPlay() {
        return this.play;
    }

    @Override // java.io.Serializable
    public Play.Status getPlayStatus() {
        Play play = this.play;
        if (play != null) {
            return play.getStatus();
        }
        return null;
    }

    @Override // java.io.Serializable
    public String getPlaybackFailureUri() {
        String uri;
        Object playbackFailureReason;
        playbackFailureReason = this.metadata;
        playbackFailureReason = playbackFailureReason.connections;
        playbackFailureReason = playbackFailureReason.playbackFailureReason;
        if (playbackFailureReason != null && playbackFailureReason != null && playbackFailureReason != null) {
            playbackFailureReason = playbackFailureReason.connections;
            if (playbackFailureReason != null) {
                playbackFailureReason = playbackFailureReason.playbackFailureReason;
                uri = playbackFailureReason != null ? playbackFailureReason.uri : 0;
            } else {
            }
        } else {
        }
        return uri;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Video.Status getRawStatus() {
        com.vimeo.networking.model.Video.Status nONE;
        if (this.status == null) {
            nONE = Video.Status.NONE;
        }
        return nONE;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getRelatedConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        if (connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                return connections.related;
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public Date getRentalExpiration() {
        if (isRental()) {
            return rent.expiration;
        }
        return null;
    }

    @Override // java.io.Serializable
    public String getResourceKey() {
        return this.resourceKey;
    }

    @Override // java.io.Serializable
    public String getReviewLink() {
        return this.reviewLink;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Video.Status getStatus() {
        if (this.status == Video.Status.TRANSCODE_STARTING) {
            return Video.Status.TRANSCODING;
        }
        return getRawStatus();
    }

    @Override // java.io.Serializable
    public Date getSubscriptionExpiration() {
        if (isSubscription()) {
            return subscribe.expiration;
        }
        return null;
    }

    @Override // java.io.Serializable
    public String getTrailerUri() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.trailer;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.trailer;
                if (connections != null) {
                    return connections.uri;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.VideoFile getVideoFileForMd5(String string) {
        Object progressiveVideoFiles;
        boolean next;
        String equals;
        progressiveVideoFiles = this.play;
        if (progressiveVideoFiles != null) {
            if (progressiveVideoFiles.getProgressiveVideoFiles() == null) {
            } else {
                progressiveVideoFiles = this.play.getProgressiveVideoFiles().iterator();
                for (VideoFile next : progressiveVideoFiles) {
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public Date getVodExpiration() {
        boolean rentalExpiration;
        Date subscriptionExpiration;
        rentalExpiration = getRentalExpiration();
        subscriptionExpiration = getSubscriptionExpiration();
        if (isVod() && rentalExpiration != null && subscriptionExpiration != null && rentalExpiration.after(subscriptionExpiration)) {
            rentalExpiration = getRentalExpiration();
            subscriptionExpiration = getSubscriptionExpiration();
            if (rentalExpiration != null) {
                if (subscriptionExpiration != null) {
                    if (rentalExpiration.after(subscriptionExpiration)) {
                        return rentalExpiration;
                    }
                    return subscriptionExpiration;
                }
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

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Video.VodVideoType getVodVideoType() {
        Date rentalExpiration;
        if (isVod() && isTrailer()) {
            if (isTrailer()) {
                return Video.VodVideoType.TRAILER;
            }
            if (isPurchase()) {
                return Video.VodVideoType.PURCHASE;
            }
            rentalExpiration = getRentalExpiration();
            final Date subscriptionExpiration = getSubscriptionExpiration();
            if (rentalExpiration != null && subscriptionExpiration != null && rentalExpiration.after(subscriptionExpiration)) {
                if (subscriptionExpiration != null) {
                    if (rentalExpiration.after(subscriptionExpiration)) {
                        return Video.VodVideoType.RENTAL;
                    }
                }
            }
            if (isSubscription()) {
                return Video.VodVideoType.SUBSCRIPTION;
            }
            if (isRental()) {
                return Video.VodVideoType.RENTAL;
            }
            return Video.VodVideoType.UNKNOWN;
        }
        return Video.VodVideoType.NONE;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getWatchLaterConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.watchlater;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.watchlater;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Interaction getWatchLaterInteraction() {
        Object interactions;
        interactions = this.metadata;
        interactions = interactions.interactions;
        interactions = interactions.watchlater;
        if (interactions != null && interactions != null && interactions != null) {
            interactions = interactions.interactions;
            if (interactions != null) {
                interactions = interactions.watchlater;
                if (interactions != null) {
                    return interactions;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        String resourceKey = this.resourceKey;
        if (resourceKey != null) {
            i = resourceKey.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isLiked() {
        com.vimeo.networking.model.Interaction likeInteraction;
        int i;
        if (getLikeInteraction() != null && likeInteraction2.added) {
            i = likeInteraction2.added ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isPurchase() {
        boolean possiblePurchase;
        int i;
        if (isPossiblePurchase() && Video.isPurchased(interactions.buy)) {
            i = Video.isPurchased(interactions.buy) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isRental() {
        boolean possiblePurchase;
        int i;
        if (isPossiblePurchase() && Video.isPurchased(interactions.rent)) {
            i = Video.isPurchased(interactions.rent) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isSubscription() {
        boolean possiblePurchase;
        int i;
        if (isPossiblePurchase() && Video.isPurchased(interactions.subscribe)) {
            i = Video.isPurchased(interactions.subscribe) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isTrailer() {
        boolean trailer;
        int i;
        if (isVod() && connections.trailer == null) {
            i = connections.trailer == null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isVod() {
        int i;
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        if (connections != null && connections != null && connections.ondemand != null) {
            connections = connections.connections;
            if (connections != null) {
                i = connections.ondemand != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isWatchLater() {
        com.vimeo.networking.model.Interaction watchLaterInteraction;
        int i;
        if (getWatchLaterInteraction() != null && watchLaterInteraction2.added) {
            i = watchLaterInteraction2.added ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public int likeCount() {
        if (getLikesConnection() != null) {
            return likesConnection2.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public Integer playCount() {
        com.vimeo.networking.model.StatsCollection stats = this.stats;
        if (stats != null) {
            return stats.plays;
        }
        return null;
    }

    @Override // java.io.Serializable
    public String recommendationsUri() {
        String string;
        Object recommendations;
        String str;
        recommendations = this.metadata;
        recommendations = recommendations.connections;
        recommendations = recommendations.recommendations;
        if (recommendations != null && recommendations != null && recommendations != null) {
            recommendations = recommendations.connections;
            if (recommendations != null) {
                recommendations = recommendations.recommendations;
                string = recommendations != null ? recommendations.uri : 0;
            } else {
            }
        } else {
        }
        if (string == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.uri);
            stringBuilder.append("/recommendations");
            string = stringBuilder.toString();
        }
        return string;
    }

    @Override // java.io.Serializable
    public void setResourceKey(String string) {
        this.resourceKey = string;
    }

    @Override // java.io.Serializable
    public void setStatus(com.vimeo.networking.model.Video.Status video$Status) {
        this.status = status;
    }
}
