package com.vimeo.stag.generated;

import android.accounts.Account;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import com.google.android.exoplayer2.m2.l.f;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;
import com.google.android.play.core.splitinstall.w0;
import com.google.firebase.firestore.util.k;
import com.google.firebase.installations.interop.R.id;
import com.google.firebase.ktx.R.styleable;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.revenuecat.purchases.subscriberattributes.R.dimen;
import com.vimeo.networking.model.BaseResponseList;
import com.vimeo.networking.model.Category;
import com.vimeo.networking.model.CategoryList;
import com.vimeo.networking.model.Channel;
import com.vimeo.networking.model.ChannelList;
import com.vimeo.networking.model.Comment;
import com.vimeo.networking.model.CommentList;
import com.vimeo.networking.model.Connection;
import com.vimeo.networking.model.ConnectionCollection;
import com.vimeo.networking.model.Email;
import com.vimeo.networking.model.Embed;
import com.vimeo.networking.model.FeedItem;
import com.vimeo.networking.model.FeedList;
import com.vimeo.networking.model.Group;
import com.vimeo.networking.model.Interaction;
import com.vimeo.networking.model.InteractionCollection;
import com.vimeo.networking.model.Metadata;
import com.vimeo.networking.model.Paging;
import com.vimeo.networking.model.Picture;
import com.vimeo.networking.model.PictureCollection;
import com.vimeo.networking.model.PictureResource;
import com.vimeo.networking.model.PinCodeInfo;
import com.vimeo.networking.model.Preferences;
import com.vimeo.networking.model.Privacy;
import com.vimeo.networking.model.Quota;
import com.vimeo.networking.model.Recommendation;
import com.vimeo.networking.model.Space;
import com.vimeo.networking.model.StatsCollection;
import com.vimeo.networking.model.Tag;
import com.vimeo.networking.model.UploadQuota;
import com.vimeo.networking.model.User;
import com.vimeo.networking.model.UserBadge;
import com.vimeo.networking.model.UserList;
import com.vimeo.networking.model.Video;
import com.vimeo.networking.model.VideoFile;
import com.vimeo.networking.model.VideoList;
import com.vimeo.networking.model.VideosPreference;
import com.vimeo.networking.model.VimeoAccount;
import com.vimeo.networking.model.VodItem;
import com.vimeo.networking.model.VodItem.Publish;
import com.vimeo.networking.model.VodList;
import com.vimeo.networking.model.Website;
import com.vimeo.networking.model.playback.Drm;
import com.vimeo.networking.model.playback.Play;
import com.vimeo.networking.model.playback.PlayProgress;
import com.vimeo.networking.model.playback.VideoLog;
import com.vimeo.networking.model.search.FacetOption;
import com.vimeo.networking.model.search.SearchFacet;
import com.vimeo.networking.model.search.SearchFacetCollection;
import com.vimeo.networking.model.search.SearchResponse;
import com.vimeo.networking.model.search.SearchResult;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ParseUtils.java */
/* loaded from: classes2.dex */
final class a {
    public static Preferences A(Gson gson, JsonReader jsonReader) throws IOException {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Preferences preferences = new Preferences();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return preferences;
    }

    public static void A0(Gson gson, JsonWriter jsonWriter, Tag tag) {
        jsonWriter.beginObject();
        if (tag == null) {
            return;
        }
        if (tag.canonical != null) {
            jsonWriter.name("canonical");
            jsonWriter.value(tag.canonical);
        }
        if (tag.name != null) {
            jsonWriter.name("name");
            jsonWriter.value(tag.name);
        }
        if (tag.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(tag.uri);
        }
        if (tag.tag != null) {
            jsonWriter.name("tag");
            jsonWriter.value(tag.tag);
        }
        if (tag.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, tag.metadata);
        }
        jsonWriter.endObject();
    }

    public static Privacy B(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        final Class<com.vimeo.networking.model.Privacy.PrivacyValue> obj = Privacy.PrivacyValue.class;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        Privacy privacy = new Privacy();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return privacy;
    }

    public static void B0(Gson gson, JsonWriter jsonWriter, UploadQuota uploadQuota) {
        jsonWriter.beginObject();
        if (uploadQuota == null) {
            return;
        }
        if (uploadQuota.space != null) {
            jsonWriter.name("space");
            a.y0(gson, jsonWriter, uploadQuota.space);
        }
        if (uploadQuota.quota != null) {
            jsonWriter.name("quota");
            a.w0(gson, jsonWriter, uploadQuota.quota);
        }
        jsonWriter.endObject();
    }

    public static VodItem.Publish C(Gson gson, JsonReader jsonReader) throws IOException {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        VodItem.Publish publish = new VodItem.Publish();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return publish;
    }

    public static void C0(Gson gson, JsonWriter jsonWriter, User user) {
        ArrayList websites22;
        jsonWriter.beginObject();
        if (user == null) {
            return;
        }
        if (user.preferences != null) {
            jsonWriter.name("preferences");
            a.u0(gson, jsonWriter, user.preferences);
        }
        if (user.emails != null) {
            jsonWriter.name("emails");
            emails2 = Email.class;
            a.X0(gson, jsonWriter, emails2, user.emails);
        }
        if (user.name != null) {
            jsonWriter.name("name");
            jsonWriter.value(user.name);
        }
        if (user.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, user.metadata);
        }
        if (user.websites != null) {
            jsonWriter.name("websites");
            websites2 = Website.class;
            a.X0(gson, jsonWriter, websites2, user.websites);
        }
        if (user.badge != null) {
            jsonWriter.name("badge");
            a.D0(gson, jsonWriter, user.badge);
        }
        if (user.createdTime != null) {
            jsonWriter.name("created_time");
            createdTime2 = Date.class;
            Stag.d(gson, createdTime2, jsonWriter, user.createdTime);
        }
        if (user.uploadQuota != null) {
            jsonWriter.name("upload_quota");
            a.B0(gson, jsonWriter, user.uploadQuota);
        }
        if (user.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(user.link);
        }
        if (user.pictures != null) {
            jsonWriter.name("pictures");
            a.r0(gson, jsonWriter, user.pictures);
        }
        if (user.account != null) {
            jsonWriter.name("account");
            jsonWriter.value(user.account);
        }
        if (user.location != null) {
            jsonWriter.name("location");
            jsonWriter.value(user.location);
        }
        if (user.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(user.uri);
        }
        if (user.bio != null) {
            jsonWriter.name("bio");
            jsonWriter.value(user.bio);
        }
        jsonWriter.endObject();
    }

    public static Quota D(Gson gson, JsonReader jsonReader) {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Quota quota = new Quota();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return quota;
    }

    public static void D0(Gson gson, JsonWriter jsonWriter, UserBadge userBadge) {
        jsonWriter.beginObject();
        if (userBadge == null) {
            return;
        }
        if (userBadge.mAlternateText != null) {
            jsonWriter.name("alt_text");
            jsonWriter.value(userBadge.mAlternateText);
        }
        if (userBadge.mUrl != null) {
            jsonWriter.name("url");
            jsonWriter.value(userBadge.mUrl);
        }
        if (userBadge.mText != null) {
            jsonWriter.name("text");
            jsonWriter.value(userBadge.mText);
        }
        if (userBadge.mBadgeType != null) {
            jsonWriter.name("type");
            jsonWriter.value(userBadge.mBadgeType);
        }
        jsonWriter.endObject();
    }

    public static Recommendation E(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 1;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Recommendation recommendation = new Recommendation();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return recommendation;
    }

    public static void E0(Gson gson, JsonWriter jsonWriter, UserList list) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.data != null) {
            jsonWriter.name("data");
            data2 = User.class;
            a.X0(gson, jsonWriter, data2, list.data);
        }
        jsonWriter.name("page");
        jsonWriter.value((long)list.page);
        if (list.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, list.paging);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)list.perPage);
        jsonWriter.name("total");
        jsonWriter.value((long)list.total);
        jsonWriter.endObject();
    }

    public static SearchFacet F(Gson gson, JsonReader jsonReader) {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        SearchFacet searchFacet = new SearchFacet();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return searchFacet;
    }

    public static void F0(Gson gson, JsonWriter jsonWriter, Video video) {
        com.vimeo.networking.model.Video.Status status22;
        jsonWriter.beginObject();
        if (video == null) {
            return;
        }
        jsonWriter.name("duration");
        jsonWriter.value((long)video.duration);
        if (video.status != null) {
            jsonWriter.name("status");
            status2 = Video.Status.class;
            Stag.d(gson, status2, jsonWriter, video.status);
        }
        if (video.privacy != null) {
            jsonWriter.name("privacy");
            a.v0(gson, jsonWriter, video.privacy);
        }
        if (video.modifiedTime != null) {
            jsonWriter.name("modified_time");
            modifiedTime2 = Date.class;
            Stag.d(gson, modifiedTime2, jsonWriter, video.modifiedTime);
        }
        if (video.password != null) {
            jsonWriter.name("password");
            jsonWriter.value(video.password);
        }
        if (video.files != null) {
            jsonWriter.name("files");
            files2 = VideoFile.class;
            a.X0(gson, jsonWriter, files2, video.files);
        }
        if (video.language != null) {
            jsonWriter.name("language");
            jsonWriter.value(video.language);
        }
        if (video.name != null) {
            jsonWriter.name("name");
            jsonWriter.value(video.name);
        }
        if (video.user != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, video.user);
        }
        if (video.createdTime != null) {
            jsonWriter.name("created_time");
            createdTime2 = Date.class;
            Stag.d(gson, createdTime2, jsonWriter, video.createdTime);
        }
        if (video.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(video.uri);
        }
        if (video.reviewLink != null) {
            jsonWriter.name("review_link");
            jsonWriter.value(video.reviewLink);
        }
        if (video.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(video.link);
        }
        if (video.embed != null) {
            jsonWriter.name("embed");
            a.i0(gson, jsonWriter, video.embed);
        }
        if (video.resourceKey != null) {
            jsonWriter.name("resource_key");
            jsonWriter.value(video.resourceKey);
        }
        if (video.stats != null) {
            jsonWriter.name("stats");
            a.z0(gson, jsonWriter, video.stats);
        }
        if (video.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, video.metadata);
        }
        if (video.pictures != null) {
            jsonWriter.name("pictures");
            a.r0(gson, jsonWriter, video.pictures);
        }
        if (video.releaseTime != null) {
            jsonWriter.name("release_time");
            releaseTime2 = Date.class;
            Stag.d(gson, releaseTime2, jsonWriter, video.releaseTime);
        }
        jsonWriter.name("height");
        jsonWriter.value((long)video.height);
        if (video.categories != null) {
            jsonWriter.name("categories");
            categories2 = Category.class;
            a.X0(gson, jsonWriter, categories2, video.categories);
        }
        if (video.description != null) {
            jsonWriter.name("description");
            jsonWriter.value(video.description);
        }
        jsonWriter.name("width");
        jsonWriter.value((long)video.width);
        if (video.license != null) {
            jsonWriter.name("license");
            jsonWriter.value(video.license);
        }
        if (video.contentRating != null) {
            jsonWriter.name("content_rating");
            contentRating2 = String.class;
            a.X0(gson, jsonWriter, contentRating2, video.contentRating);
        }
        if (video.tags != null) {
            jsonWriter.name("tags");
            tags2 = Tag.class;
            a.X0(gson, jsonWriter, tags2, video.tags);
        }
        if (video.play != null) {
            jsonWriter.name("play");
            a.P0(gson, jsonWriter, video.play);
        }
        if (video.download != null) {
            jsonWriter.name("download");
            download2 = VideoFile.class;
            a.X0(gson, jsonWriter, download2, video.download);
        }
        jsonWriter.endObject();
    }

    public static SearchFacetCollection G(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 1;
        String str;
        i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        SearchFacetCollection searchFacetCollection = new SearchFacetCollection();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return searchFacetCollection;
    }

    public static void G0(Gson gson, JsonWriter jsonWriter, VideoFile videoFile) {
        java.util.Date expires22;
        jsonWriter.beginObject();
        if (videoFile == null) {
            return;
        }
        if (videoFile.log != null) {
            jsonWriter.name("log");
            a.R0(gson, jsonWriter, videoFile.log);
        }
        if (videoFile.token != null) {
            jsonWriter.name("token");
            jsonWriter.value(videoFile.token);
        }
        jsonWriter.name("height");
        jsonWriter.value((long)videoFile.height);
        if (videoFile.expires != null) {
            jsonWriter.name("expires");
            expires2 = Date.class;
            Stag.d(gson, expires2, jsonWriter, videoFile.expires);
        }
        if (videoFile.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(videoFile.link);
        }
        jsonWriter.name("width");
        jsonWriter.value((long)videoFile.width);
        if (videoFile.linkExpirationTime != null) {
            jsonWriter.name("link_expiration_time");
            linkExpirationTime2 = Date.class;
            Stag.d(gson, linkExpirationTime2, jsonWriter, videoFile.linkExpirationTime);
        }
        jsonWriter.name("size");
        jsonWriter.value(videoFile.size);
        if (videoFile.quality != null) {
            jsonWriter.name("quality");
            quality2 = VideoFile.VideoQuality.class;
            Stag.d(gson, quality2, jsonWriter, videoFile.quality);
        }
        if (videoFile.licenseLink != null) {
            jsonWriter.name("license_link");
            jsonWriter.value(videoFile.licenseLink);
        }
        jsonWriter.name("fps");
        jsonWriter.value(videoFile.fps);
        if (videoFile.md5 != null) {
            jsonWriter.name("md5");
            jsonWriter.value(videoFile.md5);
        }
        if (videoFile.type != null) {
            jsonWriter.name("type");
            type2 = VideoFile.MimeType.class;
            Stag.d(gson, type2, jsonWriter, videoFile.type);
        }
        if (videoFile.createdTime != null) {
            jsonWriter.name("created_time");
            createdTime2 = Date.class;
            Stag.d(gson, createdTime2, jsonWriter, videoFile.createdTime);
        }
        jsonWriter.endObject();
    }

    public static SearchResponse H(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 2;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        SearchResponse searchResponse = new SearchResponse();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return searchResponse;
    }

    public static void H0(Gson gson, JsonWriter jsonWriter, VideoList list) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.data != null) {
            jsonWriter.name("data");
            data2 = Video.class;
            a.X0(gson, jsonWriter, data2, list.data);
        }
        jsonWriter.name("page");
        jsonWriter.value((long)list.page);
        if (list.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, list.paging);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)list.perPage);
        jsonWriter.name("total");
        jsonWriter.value((long)list.total);
        jsonWriter.endObject();
    }

    public static SearchResult I(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 3;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        SearchResult searchResult = new SearchResult();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return searchResult;
    }

    public static void I0(Gson gson, JsonWriter jsonWriter, VideosPreference videosPreference) {
        jsonWriter.beginObject();
        if (videosPreference == null) {
            return;
        }
        if (videosPreference.privacy != null) {
            jsonWriter.name("privacy");
            jsonWriter.value(videosPreference.privacy);
        }
        if (videosPreference.password != null) {
            jsonWriter.name("password");
            jsonWriter.value(videosPreference.password);
        }
        jsonWriter.endObject();
    }

    public static Space J(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Space space = new Space();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return space;
    }

    public static void J0(Gson gson, JsonWriter jsonWriter, VimeoAccount vimeoAccount) {
        jsonWriter.beginObject();
        if (vimeoAccount == null) {
            return;
        }
        if (vimeoAccount.accessToken != null) {
            jsonWriter.name("access_token");
            jsonWriter.value(vimeoAccount.accessToken);
        }
        if (vimeoAccount.scope != null) {
            jsonWriter.name("scope");
            jsonWriter.value(vimeoAccount.scope);
        }
        if (vimeoAccount.user != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, vimeoAccount.user);
        }
        if (vimeoAccount.tokenType != null) {
            jsonWriter.name("token_type");
            jsonWriter.value(vimeoAccount.tokenType);
        }
        jsonWriter.endObject();
    }

    public static StatsCollection K(Gson gson, JsonReader jsonReader) throws IOException {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        StatsCollection statsCollection = new StatsCollection();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return statsCollection;
    }

    public static void K0(Gson gson, JsonWriter jsonWriter, VodItem.Publish publish) {
        jsonWriter.beginObject();
        if (publish == null) {
            return;
        }
        if (publish.mTime != null) {
            jsonWriter.name("time");
            mTime2 = Date.class;
            Stag.d(gson, mTime2, jsonWriter, publish.mTime);
        }
        jsonWriter.endObject();
    }

    public static Tag L(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        Tag tag = new Tag();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return tag;
    }

    public static void L0(Gson gson, JsonWriter jsonWriter, VodItem vodItem) {
        jsonWriter.beginObject();
        if (vodItem == null) {
            return;
        }
        if (vodItem.mFilm != null) {
            jsonWriter.name("film");
            a.F0(gson, jsonWriter, vodItem.mFilm);
        }
        if (vodItem.mName != null) {
            jsonWriter.name("name");
            jsonWriter.value(vodItem.mName);
        }
        if (vodItem.mDescription != null) {
            jsonWriter.name("description");
            jsonWriter.value(vodItem.mDescription);
        }
        if (vodItem.mUser != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, vodItem.mUser);
        }
        if (vodItem.mTrailer != null) {
            jsonWriter.name("trailer");
            a.F0(gson, jsonWriter, vodItem.mTrailer);
        }
        if (vodItem.mType != null) {
            jsonWriter.name("type");
            mType2 = VodItem.VodType.class;
            Stag.d(gson, mType2, jsonWriter, vodItem.mType);
        }
        if (vodItem.mLink != null) {
            jsonWriter.name("link");
            jsonWriter.value(vodItem.mLink);
        }
        if (vodItem.mPublish != null) {
            jsonWriter.name("publish");
            a.K0(gson, jsonWriter, vodItem.mPublish);
        }
        if (vodItem.mPictures != null) {
            jsonWriter.name("pictures");
            a.r0(gson, jsonWriter, vodItem.mPictures);
        }
        if (vodItem.mMetadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, vodItem.mMetadata);
        }
        jsonWriter.endObject();
    }

    public static UploadQuota M(Gson gson, JsonReader jsonReader) throws IOException {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        UploadQuota uploadQuota = new UploadQuota();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return uploadQuota;
    }

    public static void M0(Gson gson, JsonWriter jsonWriter, VodList list) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.data != null) {
            jsonWriter.name("data");
            data2 = VodItem.class;
            a.X0(gson, jsonWriter, data2, list.data);
        }
        jsonWriter.name("page");
        jsonWriter.value((long)list.page);
        if (list.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, list.paging);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)list.perPage);
        jsonWriter.name("total");
        jsonWriter.value((long)list.total);
        jsonWriter.endObject();
    }

    public static User N(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 8;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        User user = new User();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return user;
    }

    public static void N0(Gson gson, JsonWriter jsonWriter, Website website) {
        jsonWriter.beginObject();
        if (website == null) {
            return;
        }
        if (website.description != null) {
            jsonWriter.name("description");
            jsonWriter.value(website.description);
        }
        if (website.name != null) {
            jsonWriter.name("name");
            jsonWriter.value(website.name);
        }
        if (website.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(website.link);
        }
        jsonWriter.endObject();
    }

    public static UserBadge O(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        UserBadge userBadge = new UserBadge();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return userBadge;
    }

    public static void O0(Gson gson, JsonWriter jsonWriter, Drm drm) {
        jsonWriter.beginObject();
        if (drm == null) {
            return;
        }
        if (drm.mPlayReady != null) {
            jsonWriter.name("playready");
            a.G0(gson, jsonWriter, drm.mPlayReady);
        }
        if (drm.mWidevine != null) {
            jsonWriter.name("widevine");
            a.G0(gson, jsonWriter, drm.mWidevine);
        }
        jsonWriter.endObject();
    }

    public static UserList P(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        UserList userList = new UserList();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return userList;
    }

    public static void P0(Gson gson, JsonWriter jsonWriter, Play play) {
        ArrayList mProgressive22;
        jsonWriter.beginObject();
        if (play == null) {
            return;
        }
        if (play.mProgressive != null) {
            jsonWriter.name("progressive");
            mProgressive2 = VideoFile.class;
            a.X0(gson, jsonWriter, mProgressive2, play.mProgressive);
        }
        if (play.mStatus != null) {
            jsonWriter.name("status");
            mStatus2 = Play.Status.class;
            Stag.d(gson, mStatus2, jsonWriter, play.mStatus);
        }
        if (play.mDash != null) {
            jsonWriter.name("dash");
            a.G0(gson, jsonWriter, play.mDash);
        }
        if (play.mEmbed != null) {
            jsonWriter.name("embed");
            mEmbed2 = Embed.class;
            Stag.d(gson, mEmbed2, jsonWriter, play.mEmbed);
        }
        if (play.mDrm != null) {
            jsonWriter.name("drm");
            a.O0(gson, jsonWriter, play.mDrm);
        }
        if (play.mProgress != null) {
            jsonWriter.name("progress");
            a.Q0(gson, jsonWriter, play.mProgress);
        }
        if (play.mHls != null) {
            jsonWriter.name("hls");
            a.G0(gson, jsonWriter, play.mHls);
        }
        jsonWriter.endObject();
    }

    public static Video Q(Gson gson, JsonReader jsonReader) throws IOException {
        android.os.Parcelable.Creator creator;
        JsonToken bEGIN_OBJECT2;
        int i2 = 1;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Video video = new Video();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return video;
    }

    public static void Q0(Gson gson, JsonWriter jsonWriter, PlayProgress playProgress) {
        jsonWriter.beginObject();
        if (playProgress == null) {
            return;
        }
        jsonWriter.name("seconds");
        jsonWriter.value((long)playProgress.mSeconds);
        jsonWriter.endObject();
    }

    public static VideoFile R(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 8;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        VideoFile videoFile = new VideoFile();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return videoFile;
    }

    public static void R0(Gson gson, JsonWriter jsonWriter, VideoLog videoLog) {
        jsonWriter.beginObject();
        if (videoLog == null) {
            return;
        }
        if (videoLog.mLoadLink != null) {
            jsonWriter.name("load_link");
            jsonWriter.value(videoLog.mLoadLink);
        }
        if (videoLog.mLikePressLink != null) {
            jsonWriter.name("like_press_link");
            jsonWriter.value(videoLog.mLikePressLink);
        }
        if (videoLog.mWatchLaterPressLink != null) {
            jsonWriter.name("watchlater_press_link");
            jsonWriter.value(videoLog.mWatchLaterPressLink);
        }
        if (videoLog.mExitLink != null) {
            jsonWriter.name("exit_link");
            jsonWriter.value(videoLog.mExitLink);
        }
        if (videoLog.mPlayLink != null) {
            jsonWriter.name("play_link");
            jsonWriter.value(videoLog.mPlayLink);
        }
        jsonWriter.endObject();
    }

    public static VideoList S(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        VideoList videoList = new VideoList();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return videoList;
    }

    public static void S0(Gson gson, JsonWriter jsonWriter, FacetOption facetOption) {
        jsonWriter.beginObject();
        if (facetOption == null) {
            return;
        }
        if (facetOption.mName != null) {
            jsonWriter.name("name");
            jsonWriter.value(facetOption.mName);
        }
        if (facetOption.mText != null) {
            jsonWriter.name("text");
            jsonWriter.value(facetOption.mText);
        }
        jsonWriter.name("total");
        jsonWriter.value((long)facetOption.mTotal);
        jsonWriter.endObject();
    }

    public static VideoLog T(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        VideoLog videoLog = new VideoLog();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return videoLog;
    }

    public static void T0(Gson gson, JsonWriter jsonWriter, SearchFacet searchFacet) {
        jsonWriter.beginObject();
        if (searchFacet == null) {
            return;
        }
        if (searchFacet.mName != null) {
            jsonWriter.name("name");
            jsonWriter.value(searchFacet.mName);
        }
        if (searchFacet.mOptions != null) {
            jsonWriter.name("options");
            mOptions2 = FacetOption.class;
            a.X0(gson, jsonWriter, mOptions2, searchFacet.mOptions);
        }
        jsonWriter.endObject();
    }

    public static VideosPreference U(Gson gson, JsonReader jsonReader) {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        VideosPreference videosPreference = new VideosPreference();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return videosPreference;
    }

    public static void U0(Gson gson, JsonWriter jsonWriter, SearchFacetCollection list) {
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.mDurationFacet != null) {
            jsonWriter.name("duration");
            a.T0(gson, jsonWriter, list.mDurationFacet);
        }
        if (list.mUserTypeFacet != null) {
            jsonWriter.name("user_type");
            a.T0(gson, jsonWriter, list.mUserTypeFacet);
        }
        if (list.mCategoryFacet != null) {
            jsonWriter.name("category");
            a.T0(gson, jsonWriter, list.mCategoryFacet);
        }
        if (list.mTypeFacet != null) {
            jsonWriter.name("type");
            a.T0(gson, jsonWriter, list.mTypeFacet);
        }
        if (list.mLicenseFacet != null) {
            jsonWriter.name("license");
            a.T0(gson, jsonWriter, list.mLicenseFacet);
        }
        if (list.mUploadedFacet != null) {
            jsonWriter.name("uploaded");
            a.T0(gson, jsonWriter, list.mUploadedFacet);
        }
        jsonWriter.endObject();
    }

    public static VimeoAccount V(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        VimeoAccount vimeoAccount = new VimeoAccount();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return vimeoAccount;
    }

    public static void V0(Gson gson, JsonWriter jsonWriter, SearchResponse searchResponse) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (searchResponse == null) {
            return;
        }
        if (searchResponse.data != null) {
            jsonWriter.name("data");
            data2 = SearchResult.class;
            a.X0(gson, jsonWriter, data2, searchResponse.data);
        }
        jsonWriter.name("mature_hidden_count");
        jsonWriter.value((long)searchResponse.mMatureHiddenCount);
        if (searchResponse.mFacetCollection != null) {
            jsonWriter.name("facets");
            a.U0(gson, jsonWriter, searchResponse.mFacetCollection);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)searchResponse.perPage);
        jsonWriter.name("page");
        jsonWriter.value((long)searchResponse.page);
        if (searchResponse.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, searchResponse.paging);
        }
        jsonWriter.name("total");
        jsonWriter.value((long)searchResponse.total);
        jsonWriter.endObject();
    }

    public static VodItem W(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 4;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        VodItem vodItem = new VodItem();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return vodItem;
    }

    public static void W0(Gson gson, JsonWriter jsonWriter, SearchResult searchResult) {
        jsonWriter.beginObject();
        if (searchResult == null) {
            return;
        }
        if (searchResult.mVideo != null) {
            jsonWriter.name("clip");
            a.F0(gson, jsonWriter, searchResult.mVideo);
        }
        if (searchResult.mChannel != null) {
            jsonWriter.name("channel");
            a.b0(gson, jsonWriter, searchResult.mChannel);
        }
        if (searchResult.mSearchType != null) {
            jsonWriter.name("type");
            mSearchType2 = SearchType.class;
            Stag.d(gson, mSearchType2, jsonWriter, searchResult.mSearchType);
        }
        if (searchResult.mGroup != null) {
            jsonWriter.name("group");
            a.l0(gson, jsonWriter, searchResult.mGroup);
        }
        jsonWriter.name("is_staffpick");
        jsonWriter.value(searchResult.mIsStaffPick);
        if (searchResult.mVod != null) {
            jsonWriter.name("ondemand");
            a.L0(gson, jsonWriter, searchResult.mVod);
        }
        jsonWriter.name("is_featured");
        jsonWriter.value(searchResult.mIsFeatured);
        if (searchResult.mUser != null) {
            jsonWriter.name("people");
            a.C0(gson, jsonWriter, searchResult.mUser);
        }
        jsonWriter.endObject();
    }

    public static VodList X(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        VodList vodList = new VodList();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return vodList;
    }

    public static <T> void X0(Gson gson, JsonWriter jsonWriter, Class cls, ArrayList<T> arrayList) {
        if (arrayList == null) {
            return;
        }
        jsonWriter.beginArray();
        Stag.c(gson, cls, jsonWriter, arrayList);
        jsonWriter.endArray();
    }

    public static Website Y(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Website website = new Website();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return website;
    }

    public static void Z(Gson gson, JsonWriter jsonWriter, Category category) {
        jsonWriter.beginObject();
        if (category == null) {
            return;
        }
        if (category.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, category.metadata);
        }
        if (category.parent != null) {
            jsonWriter.name("parent");
            a.Z(gson, jsonWriter, category.parent);
        }
        if (category.name != null) {
            jsonWriter.name("name");
            jsonWriter.value(category.name);
        }
        if (category.subcategories != null) {
            jsonWriter.name("subcategories");
            subcategories2 = Category.class;
            a.X0(gson, jsonWriter, subcategories2, category.subcategories);
        }
        if (category.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(category.link);
        }
        if (category.pictures != null) {
            jsonWriter.name("pictures");
            a.r0(gson, jsonWriter, category.pictures);
        }
        if (category.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(category.uri);
        }
        jsonWriter.name("top_level");
        jsonWriter.value(category.topLevel);
        jsonWriter.endObject();
    }

    public static <T> ArrayList<T> a(Gson gson, JsonReader jsonReader, Class<T> cls) {
        if (jsonReader.peek() != JsonToken.BEGIN_ARRAY) {
            jsonReader.skipValue();
            return null;
        }
        jsonReader.beginArray();
        jsonReader.endArray();
        return Stag.b(gson, cls, jsonReader);
    }

    public static void a0(Gson gson, JsonWriter jsonWriter, CategoryList list) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.data != null) {
            jsonWriter.name("data");
            data2 = Category.class;
            a.X0(gson, jsonWriter, data2, list.data);
        }
        jsonWriter.name("page");
        jsonWriter.value((long)list.page);
        if (list.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, list.paging);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)list.perPage);
        jsonWriter.name("total");
        jsonWriter.value((long)list.total);
        jsonWriter.endObject();
    }

    public static Category b(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 2;
        int i3;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Category category = new Category();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return category;
    }

    public static void b0(Gson gson, JsonWriter jsonWriter, Channel channel) {
        java.util.Date modifiedTime22;
        jsonWriter.beginObject();
        if (channel == null) {
            return;
        }
        if (channel.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, channel.metadata);
        }
        if (channel.user != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, channel.user);
        }
        if (channel.pictures != null) {
            jsonWriter.name("pictures");
            a.r0(gson, jsonWriter, channel.pictures);
        }
        if (channel.description != null) {
            jsonWriter.name("description");
            jsonWriter.value(channel.description);
        }
        if (channel.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(channel.link);
        }
        if (channel.createdTime != null) {
            jsonWriter.name("created_time");
            createdTime2 = Date.class;
            Stag.d(gson, createdTime2, jsonWriter, channel.createdTime);
        }
        if (channel.privacy != null) {
            jsonWriter.name("privacy");
            a.v0(gson, jsonWriter, channel.privacy);
        }
        if (channel.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(channel.uri);
        }
        if (channel.modifiedTime != null) {
            jsonWriter.name("modified_time");
            modifiedTime2 = Date.class;
            Stag.d(gson, modifiedTime2, jsonWriter, channel.modifiedTime);
        }
        if (channel.name != null) {
            jsonWriter.name("name");
            jsonWriter.value(channel.name);
        }
        if (channel.header != null) {
            jsonWriter.name("header");
            a.r0(gson, jsonWriter, channel.header);
        }
        jsonWriter.endObject();
    }

    public static CategoryList c(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        CategoryList categoryList = new CategoryList();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return categoryList;
    }

    public static void c0(Gson gson, JsonWriter jsonWriter, ChannelList list) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.data != null) {
            jsonWriter.name("data");
            data2 = Channel.class;
            a.X0(gson, jsonWriter, data2, list.data);
        }
        jsonWriter.name("page");
        jsonWriter.value((long)list.page);
        if (list.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, list.paging);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)list.perPage);
        jsonWriter.name("total");
        jsonWriter.value((long)list.total);
        jsonWriter.endObject();
    }

    public static Channel d(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 5;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Channel channel = new Channel();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return channel;
    }

    public static void d0(Gson gson, JsonWriter jsonWriter, Comment comment) {
        java.util.Date createdOn22;
        jsonWriter.beginObject();
        if (comment == null) {
            return;
        }
        if (comment.createdOn != null) {
            jsonWriter.name("created_on");
            createdOn2 = Date.class;
            Stag.d(gson, createdOn2, jsonWriter, comment.createdOn);
        }
        if (comment.user != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, comment.user);
        }
        if (comment.type != null) {
            jsonWriter.name("type");
            type2 = Comment.CommentType.class;
            Stag.d(gson, type2, jsonWriter, comment.type);
        }
        if (comment.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(comment.uri);
        }
        if (comment.text != null) {
            jsonWriter.name("text");
            jsonWriter.value(comment.text);
        }
        if (comment.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, comment.metadata);
        }
        jsonWriter.endObject();
    }

    public static ChannelList e(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        ChannelList channelList = new ChannelList();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return channelList;
    }

    public static void e0(Gson gson, JsonWriter jsonWriter, CommentList list) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.data != null) {
            jsonWriter.name("data");
            data2 = Comment.class;
            a.X0(gson, jsonWriter, data2, list.data);
        }
        jsonWriter.name("page");
        jsonWriter.value((long)list.page);
        if (list.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, list.paging);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)list.perPage);
        jsonWriter.name("total");
        jsonWriter.value((long)list.total);
        jsonWriter.endObject();
    }

    public static Comment f(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 1;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Comment comment = new Comment();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return comment;
    }

    public static void f0(Gson gson, JsonWriter jsonWriter, Connection connection) {
        ArrayList options22;
        jsonWriter.beginObject();
        if (connection == null) {
            return;
        }
        if (connection.options != null) {
            jsonWriter.name("options");
            options2 = String.class;
            a.X0(gson, jsonWriter, options2, connection.options);
        }
        jsonWriter.name("extra_total");
        jsonWriter.value((long)connection.extraTotal);
        jsonWriter.name("main_total");
        jsonWriter.value((long)connection.mainTotal);
        jsonWriter.name("total");
        jsonWriter.value((long)connection.total);
        jsonWriter.name("viewable_total");
        jsonWriter.value((long)connection.viewableTotal);
        if (connection.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(connection.uri);
        }
        jsonWriter.endObject();
    }

    public static CommentList g(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        CommentList commentList = new CommentList();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return commentList;
    }

    public static void g0(Gson gson, JsonWriter jsonWriter, ConnectionCollection list) {
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.ondemand != null) {
            jsonWriter.name("ondemand");
            a.f0(gson, jsonWriter, list.ondemand);
        }
        if (list.channels != null) {
            jsonWriter.name("channels");
            a.f0(gson, jsonWriter, list.channels);
        }
        if (list.comments != null) {
            jsonWriter.name("comments");
            a.f0(gson, jsonWriter, list.comments);
        }
        if (list.groups != null) {
            jsonWriter.name("groups");
            a.f0(gson, jsonWriter, list.groups);
        }
        if (list.portfolios != null) {
            jsonWriter.name("portfolios");
            a.f0(gson, jsonWriter, list.portfolios);
        }
        if (list.watchlater != null) {
            jsonWriter.name("watchlater");
            a.f0(gson, jsonWriter, list.watchlater);
        }
        if (list.playbackFailureReason != null) {
            jsonWriter.name("playback");
            a.f0(gson, jsonWriter, list.playbackFailureReason);
        }
        if (list.feed != null) {
            jsonWriter.name("feed");
            a.f0(gson, jsonWriter, list.feed);
        }
        if (list.trailer != null) {
            jsonWriter.name("trailer");
            a.f0(gson, jsonWriter, list.trailer);
        }
        if (list.texttracks != null) {
            jsonWriter.name("texttracks");
            a.f0(gson, jsonWriter, list.texttracks);
        }
        if (list.users != null) {
            jsonWriter.name("users");
            a.f0(gson, jsonWriter, list.users);
        }
        if (list.likes != null) {
            jsonWriter.name("likes");
            a.f0(gson, jsonWriter, list.likes);
        }
        if (list.related != null) {
            jsonWriter.name("related");
            a.f0(gson, jsonWriter, list.related);
        }
        if (list.videos != null) {
            jsonWriter.name("videos");
            a.f0(gson, jsonWriter, list.videos);
        }
        if (list.pictures != null) {
            jsonWriter.name("pictures");
            a.f0(gson, jsonWriter, list.pictures);
        }
        if (list.appearances != null) {
            jsonWriter.name("appearances");
            a.f0(gson, jsonWriter, list.appearances);
        }
        if (list.credits != null) {
            jsonWriter.name("credits");
            a.f0(gson, jsonWriter, list.credits);
        }
        if (list.followers != null) {
            jsonWriter.name("followers");
            a.f0(gson, jsonWriter, list.followers);
        }
        if (list.categories != null) {
            jsonWriter.name("categories");
            a.f0(gson, jsonWriter, list.categories);
        }
        if (list.albums != null) {
            jsonWriter.name("albums");
            a.f0(gson, jsonWriter, list.albums);
        }
        if (list.activities != null) {
            jsonWriter.name("activities");
            a.f0(gson, jsonWriter, list.activities);
        }
        if (list.replies != null) {
            jsonWriter.name("replies");
            a.f0(gson, jsonWriter, list.replies);
        }
        if (list.following != null) {
            jsonWriter.name("following");
            a.f0(gson, jsonWriter, list.following);
        }
        if (list.shared != null) {
            jsonWriter.name("shared");
            a.f0(gson, jsonWriter, list.shared);
        }
        if (list.recommendations != null) {
            jsonWriter.name("recommendations");
            a.f0(gson, jsonWriter, list.recommendations);
        }
        jsonWriter.endObject();
    }

    public static Connection h(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i3 = 1;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        Connection connection = new Connection();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return connection;
    }

    public static void h0(Gson gson, JsonWriter jsonWriter, Email email) {
        jsonWriter.beginObject();
        if (email == null) {
            return;
        }
        if (email.email != null) {
            jsonWriter.name("email");
            jsonWriter.value(email.email);
        }
        jsonWriter.endObject();
    }

    public static ConnectionCollection i(Gson gson, JsonReader jsonReader) throws IOException {
        int i2;
        JsonToken bEGIN_OBJECT2;
        int i = 19;
        String str;
        i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        ConnectionCollection connectionCollection = new ConnectionCollection();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return connectionCollection;
    }

    public static void i0(Gson gson, JsonWriter jsonWriter, Embed embed) {
        jsonWriter.beginObject();
        if (embed == null) {
            return;
        }
        if (embed.html != null) {
            jsonWriter.name("html");
            jsonWriter.value(embed.html);
        }
        jsonWriter.endObject();
    }

    public static Drm j(Gson gson, JsonReader jsonReader) throws IOException {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Drm drm = new Drm();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return drm;
    }

    public static void j0(Gson gson, JsonWriter jsonWriter, FeedItem feedItem) {
        jsonWriter.beginObject();
        if (feedItem == null) {
            return;
        }
        if (feedItem.channel != null) {
            jsonWriter.name("channel");
            a.b0(gson, jsonWriter, feedItem.channel);
        }
        if (feedItem.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(feedItem.uri);
        }
        if (feedItem.time != null) {
            jsonWriter.name("time");
            time2 = Date.class;
            Stag.d(gson, time2, jsonWriter, feedItem.time);
        }
        if (feedItem.tag != null) {
            jsonWriter.name("tag");
            a.A0(gson, jsonWriter, feedItem.tag);
        }
        if (feedItem.type != null) {
            jsonWriter.name("type");
            jsonWriter.value(feedItem.type);
        }
        if (feedItem.category != null) {
            jsonWriter.name("category");
            a.Z(gson, jsonWriter, feedItem.category);
        }
        if (feedItem.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, feedItem.metadata);
        }
        if (feedItem.user != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, feedItem.user);
        }
        if (feedItem.group != null) {
            jsonWriter.name("group");
            a.l0(gson, jsonWriter, feedItem.group);
        }
        if (feedItem.clip != null) {
            jsonWriter.name("clip");
            a.F0(gson, jsonWriter, feedItem.clip);
        }
        jsonWriter.endObject();
    }

    public static Email k(Gson gson, JsonReader jsonReader) {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Email email = new Email();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return email;
    }

    public static void k0(Gson gson, JsonWriter jsonWriter, FeedList list) {
        ArrayList data22;
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.data != null) {
            jsonWriter.name("data");
            data2 = FeedItem.class;
            a.X0(gson, jsonWriter, data2, list.data);
        }
        jsonWriter.name("page");
        jsonWriter.value((long)list.page);
        if (list.paging != null) {
            jsonWriter.name("paging");
            a.p0(gson, jsonWriter, list.paging);
        }
        jsonWriter.name("per_page");
        jsonWriter.value((long)list.perPage);
        jsonWriter.name("total");
        jsonWriter.value((long)list.total);
        jsonWriter.endObject();
    }

    public static Embed l(Gson gson, JsonReader jsonReader) {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Embed embed = new Embed();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return embed;
    }

    public static void l0(Gson gson, JsonWriter jsonWriter, Group group) {
        jsonWriter.beginObject();
        if (group == null) {
            return;
        }
        if (group.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(group.uri);
        }
        if (group.metadata != null) {
            jsonWriter.name("metadata");
            a.o0(gson, jsonWriter, group.metadata);
        }
        if (group.privacy != null) {
            jsonWriter.name("privacy");
            a.v0(gson, jsonWriter, group.privacy);
        }
        if (group.createdTime != null) {
            jsonWriter.name("created_time");
            createdTime2 = Date.class;
            Stag.d(gson, createdTime2, jsonWriter, group.createdTime);
        }
        if (group.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(group.link);
        }
        if (group.user != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, group.user);
        }
        if (group.groupDescription != null) {
            jsonWriter.name("group_description");
            jsonWriter.value(group.groupDescription);
        }
        if (group.pictureCollection != null) {
            jsonWriter.name("picture_collection");
            a.r0(gson, jsonWriter, group.pictureCollection);
        }
        if (group.name != null) {
            jsonWriter.name("name");
            jsonWriter.value(group.name);
        }
        jsonWriter.endObject();
    }

    public static FacetOption m(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        FacetOption facetOption = new FacetOption();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return facetOption;
    }

    public static void m0(Gson gson, JsonWriter jsonWriter, Interaction interaction) {
        java.util.Date expiration22;
        jsonWriter.beginObject();
        if (interaction == null) {
            return;
        }
        if (interaction.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(interaction.uri);
        }
        if (interaction.addedTime != null) {
            jsonWriter.name("added_time");
            addedTime2 = Date.class;
            Stag.d(gson, addedTime2, jsonWriter, interaction.addedTime);
        }
        if (interaction.expiration != null) {
            jsonWriter.name("expires_time");
            expiration2 = Date.class;
            Stag.d(gson, expiration2, jsonWriter, interaction.expiration);
        }
        if (interaction.stream != null) {
            jsonWriter.name("stream");
            stream2 = Interaction.Stream.class;
            Stag.d(gson, stream2, jsonWriter, interaction.stream);
        }
        jsonWriter.name("added");
        jsonWriter.value(interaction.added);
        jsonWriter.endObject();
    }

    public static FeedItem n(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        Gson gson2;
        int i2 = 4;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        FeedItem feedItem = new FeedItem();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return feedItem;
    }

    public static void n0(Gson gson, JsonWriter jsonWriter, InteractionCollection list) {
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.like != null) {
            jsonWriter.name("like");
            a.m0(gson, jsonWriter, list.like);
        }
        if (list.subscribe != null) {
            jsonWriter.name("subscribe");
            a.m0(gson, jsonWriter, list.subscribe);
        }
        if (list.follow != null) {
            jsonWriter.name("follow");
            a.m0(gson, jsonWriter, list.follow);
        }
        if (list.buy != null) {
            jsonWriter.name("buy");
            a.m0(gson, jsonWriter, list.buy);
        }
        if (list.rent != null) {
            jsonWriter.name("rent");
            a.m0(gson, jsonWriter, list.rent);
        }
        if (list.watchlater != null) {
            jsonWriter.name("watchlater");
            a.m0(gson, jsonWriter, list.watchlater);
        }
        jsonWriter.endObject();
    }

    public static FeedList o(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        FeedList feedList = new FeedList();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return feedList;
    }

    public static void o0(Gson gson, JsonWriter jsonWriter, Metadata metadata) {
        jsonWriter.beginObject();
        if (metadata == null) {
            return;
        }
        if (metadata.connections != null) {
            jsonWriter.name("connections");
            a.g0(gson, jsonWriter, metadata.connections);
        }
        if (metadata.interactions != null) {
            jsonWriter.name("interactions");
            a.n0(gson, jsonWriter, metadata.interactions);
        }
        jsonWriter.endObject();
    }

    public static Group p(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 3;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Group group = new Group();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return group;
    }

    public static void p0(Gson gson, JsonWriter jsonWriter, Paging paging) {
        jsonWriter.beginObject();
        if (paging == null) {
            return;
        }
        if (paging.next != null) {
            jsonWriter.name("next");
            jsonWriter.value(paging.next);
        }
        if (paging.last != null) {
            jsonWriter.name("last");
            jsonWriter.value(paging.last);
        }
        if (paging.previous != null) {
            jsonWriter.name("previous");
            jsonWriter.value(paging.previous);
        }
        if (paging.first != null) {
            jsonWriter.name("first");
            jsonWriter.value(paging.first);
        }
        jsonWriter.endObject();
    }

    public static Interaction q(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i3 = 0;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        Interaction interaction = new Interaction();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return interaction;
    }

    public static void q0(Gson gson, JsonWriter jsonWriter, Picture picture) {
        jsonWriter.beginObject();
        if (picture == null) {
            return;
        }
        jsonWriter.name("width");
        jsonWriter.value((long)picture.width);
        jsonWriter.name("height");
        jsonWriter.value((long)picture.height);
        if (picture.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(picture.link);
        }
        if (picture.linkWithPlayButton != null) {
            jsonWriter.name("link_with_play_button");
            jsonWriter.value(picture.linkWithPlayButton);
        }
        jsonWriter.endObject();
    }

    public static InteractionCollection r(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i = 1;
        String str;
        i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        InteractionCollection interactionCollection = new InteractionCollection();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return interactionCollection;
    }

    public static void r0(Gson gson, JsonWriter jsonWriter, PictureCollection list) {
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        jsonWriter.name("active");
        jsonWriter.value(list.active);
        jsonWriter.name("default");
        jsonWriter.value(list.isDefault);
        if (list.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(list.uri);
        }
        if (list.sizes != null) {
            jsonWriter.name("sizes");
            sizes2 = Picture.class;
            a.X0(gson, jsonWriter, sizes2, list.sizes);
        }
        jsonWriter.endObject();
    }

    public static Metadata s(Gson gson, JsonReader jsonReader) throws IOException {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Metadata metadata = new Metadata();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
        }
        jsonReader.endObject();
        return metadata;
    }

    public static void s0(Gson gson, JsonWriter jsonWriter, PictureResource pictureResource) {
        jsonWriter.beginObject();
        if (pictureResource == null) {
            return;
        }
        jsonWriter.name("active");
        jsonWriter.value(pictureResource.active);
        if (pictureResource.uri != null) {
            jsonWriter.name("uri");
            jsonWriter.value(pictureResource.uri);
        }
        if (pictureResource.link != null) {
            jsonWriter.name("link");
            jsonWriter.value(pictureResource.link);
        }
        jsonWriter.endObject();
    }

    public static Paging t(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Paging paging = new Paging();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return paging;
    }

    public static void t0(Gson gson, JsonWriter jsonWriter, PinCodeInfo pinCodeInfo) {
        jsonWriter.beginObject();
        if (pinCodeInfo == null) {
            return;
        }
        if (pinCodeInfo.mActivateLink != null) {
            jsonWriter.name("activate_link");
            jsonWriter.value(pinCodeInfo.mActivateLink);
        }
        if (pinCodeInfo.mDeviceCode != null) {
            jsonWriter.name("device_code");
            jsonWriter.value(pinCodeInfo.mDeviceCode);
        }
        jsonWriter.name("expires_in");
        jsonWriter.value((long)pinCodeInfo.expiresIn);
        jsonWriter.name("interval");
        jsonWriter.value((long)pinCodeInfo.interval);
        if (pinCodeInfo.mAuthorizeLink != null) {
            jsonWriter.name("authorize_link");
            jsonWriter.value(pinCodeInfo.mAuthorizeLink);
        }
        if (pinCodeInfo.mUserCode != null) {
            jsonWriter.name("user_code");
            jsonWriter.value(pinCodeInfo.mUserCode);
        }
        jsonWriter.endObject();
    }

    public static Picture u(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Picture picture = new Picture();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return picture;
    }

    public static void u0(Gson gson, JsonWriter jsonWriter, Preferences preferences) {
        jsonWriter.beginObject();
        if (preferences == null) {
            return;
        }
        if (preferences.videos != null) {
            jsonWriter.name("videos");
            a.I0(gson, jsonWriter, preferences.videos);
        }
        jsonWriter.endObject();
    }

    public static PictureCollection v(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        PictureCollection pictureCollection = new PictureCollection();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return pictureCollection;
    }

    public static void v0(Gson gson, JsonWriter jsonWriter, Privacy privacy) {
        final Class<com.vimeo.networking.model.Privacy.PrivacyValue> obj = Privacy.PrivacyValue.class;
        jsonWriter.beginObject();
        if (privacy == null) {
            return;
        }
        jsonWriter.name("download");
        jsonWriter.value(privacy.download);
        jsonWriter.name("add");
        jsonWriter.value(privacy.add);
        if (privacy.embed != null) {
            jsonWriter.name("embed");
            jsonWriter.value(privacy.embed);
        }
        if (privacy.view != null) {
            jsonWriter.name("view");
            Stag.d(gson, obj, jsonWriter, privacy.view);
        }
        if (privacy.comments != null) {
            jsonWriter.name("comments");
            Stag.d(gson, obj, jsonWriter, privacy.comments);
        }
        jsonWriter.endObject();
    }

    public static PictureResource w(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i2 = -1;
        int i3;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        PictureResource pictureResource = new PictureResource();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return pictureResource;
    }

    public static void w0(Gson gson, JsonWriter jsonWriter, Quota quota) {
        jsonWriter.beginObject();
        if (quota == null) {
            return;
        }
        jsonWriter.name("hd");
        jsonWriter.value(quota.hd);
        jsonWriter.name("sd");
        jsonWriter.value(quota.sd);
        jsonWriter.endObject();
    }

    public static PinCodeInfo x(Gson gson, JsonReader jsonReader) {
        JsonToken bEGIN_OBJECT2;
        int i3 = 1;
        String str;
        int i2 = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i2;
        }
        jsonReader.beginObject();
        PinCodeInfo pinCodeInfo = new PinCodeInfo();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return pinCodeInfo;
    }

    public static void x0(Gson gson, JsonWriter jsonWriter, Recommendation recommendation) {
        jsonWriter.beginObject();
        if (recommendation == null) {
            return;
        }
        if (recommendation.mCategory != null) {
            jsonWriter.name("category");
            a.Z(gson, jsonWriter, recommendation.mCategory);
        }
        if (recommendation.mChannel != null) {
            jsonWriter.name("channel");
            a.b0(gson, jsonWriter, recommendation.mChannel);
        }
        if (recommendation.mRecommendationType != null) {
            jsonWriter.name("type");
            jsonWriter.value(recommendation.mRecommendationType);
        }
        if (recommendation.mUser != null) {
            jsonWriter.name("user");
            a.C0(gson, jsonWriter, recommendation.mUser);
        }
        if (recommendation.mResourceKey != null) {
            jsonWriter.name("resource_key");
            jsonWriter.value(recommendation.mResourceKey);
        }
        if (recommendation.mDescription != null) {
            jsonWriter.name("description");
            jsonWriter.value(recommendation.mDescription);
        }
        jsonWriter.endObject();
    }

    public static Play y(Gson gson, JsonReader jsonReader) throws IOException {
        JsonToken bEGIN_OBJECT2;
        int i2 = 2;
        String str;
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        Play play = new Play();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek3 = jsonReader.peek();
        }
        jsonReader.endObject();
        return play;
    }

    public static void y0(Gson gson, JsonWriter jsonWriter, Space space) {
        jsonWriter.beginObject();
        if (space == null) {
            return;
        }
        jsonWriter.name("used");
        jsonWriter.value(space.used);
        jsonWriter.name("free");
        jsonWriter.value(space.free);
        jsonWriter.name("max");
        jsonWriter.value(space.max);
        jsonWriter.endObject();
    }

    public static PlayProgress z(Gson gson, JsonReader jsonReader) {
        int i = 0;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader.skipValue();
            return i;
        }
        jsonReader.beginObject();
        PlayProgress playProgress = new PlayProgress();
        while (jsonReader.hasNext()) {
            Object nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
        }
        jsonReader.endObject();
        return playProgress;
    }

    public static void z0(Gson gson, JsonWriter jsonWriter, StatsCollection list) {
        jsonWriter.beginObject();
        if (list == null) {
            return;
        }
        if (list.plays != null) {
            jsonWriter.name("plays");
            plays2 = Integer.class;
            Stag.d(gson, plays2, jsonWriter, list.plays);
        }
        jsonWriter.endObject();
    }
}
