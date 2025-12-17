package com.vimeo.stag.generated;

import android.accounts.Account;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;
import com.google.firebase.firestore.util.k;
import com.google.firebase.installations.interop.R.id;
import com.google.firebase.ktx.R.styleable;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
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

/* loaded from: classes2.dex */
final class a {
    public static Preferences A(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        JsonToken nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Preferences preferences = new Preferences();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("videos") == null) {
            } else {
            }
            preferences.videos = a.U(gson, jsonReader2);
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return preferences;
    }

    public static void A0(Gson gson, JsonWriter jsonWriter2, Tag tag3) {
        String canonical;
        String name;
        String uri;
        String tag;
        Object metadata;
        Object obj3;
        jsonWriter2.beginObject();
        if (tag3 == null) {
        }
        if (tag3.canonical != null) {
            jsonWriter2.name("canonical");
            jsonWriter2.value(tag3.canonical);
        }
        if (tag3.name != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(tag3.name);
        }
        if (tag3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(tag3.uri);
        }
        if (tag3.tag != null) {
            jsonWriter2.name("tag");
            jsonWriter2.value(tag3.tag);
        }
        if (tag3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, tag3.metadata);
        }
        jsonWriter2.endObject();
    }

    public static Privacy B(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        final Class<com.vimeo.networking.model.Privacy.PrivacyValue> obj = Privacy.PrivacyValue.class;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Privacy privacy = new Privacy();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            privacy.download = jsonReader2.nextBoolean();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            privacy.embed = jsonReader2.nextString();
            privacy.view = (Privacy.PrivacyValue)Stag.a(gson, obj, jsonReader2);
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            privacy.add = jsonReader2.nextBoolean();
            privacy.comments = (Privacy.PrivacyValue)Stag.a(gson, obj, jsonReader2);
            if (!bEGIN_OBJECT.equals("download")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("embed")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("view")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("add")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("comments")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return privacy;
    }

    public static void B0(Gson gson, JsonWriter jsonWriter2, UploadQuota uploadQuota3) {
        Space space;
        Object quota;
        Object obj3;
        jsonWriter2.beginObject();
        if (uploadQuota3 == null) {
        }
        if (uploadQuota3.space != null) {
            jsonWriter2.name("space");
            a.y0(gson, jsonWriter2, uploadQuota3.space);
        }
        if (uploadQuota3.quota != null) {
            jsonWriter2.name("quota");
            a.w0(gson, jsonWriter2, uploadQuota3.quota);
        }
        jsonWriter2.endObject();
    }

    public static VodItem.Publish C(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        JsonToken nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VodItem.Publish publish = new VodItem.Publish();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("time") == null) {
            } else {
            }
            publish.mTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return publish;
    }

    public static void C0(Gson gson, JsonWriter jsonWriter2, User user3) {
        Preferences preferences;
        ArrayList emails;
        String name;
        Metadata metadata;
        ArrayList websites;
        UserBadge badge;
        java.util.Date createdTime;
        UploadQuota uploadQuota;
        String link;
        PictureCollection pictures;
        ArrayList createdTime2;
        String obj2;
        jsonWriter2.beginObject();
        if (user3 == null) {
        }
        if (user3.preferences != null) {
            jsonWriter2.name("preferences");
            a.u0(gson, jsonWriter2, user3.preferences);
        }
        if (user3.emails != null) {
            jsonWriter2.name("emails");
            a.X0(gson, jsonWriter2, Email.class, user3.emails);
        }
        if (user3.name != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(user3.name);
        }
        if (user3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, user3.metadata);
        }
        if (user3.websites != null) {
            jsonWriter2.name("websites");
            a.X0(gson, jsonWriter2, Website.class, user3.websites);
        }
        if (user3.badge != null) {
            jsonWriter2.name("badge");
            a.D0(gson, jsonWriter2, user3.badge);
        }
        if (user3.createdTime != null) {
            jsonWriter2.name("created_time");
            Stag.d(gson, Date.class, jsonWriter2, user3.createdTime);
        }
        if (user3.uploadQuota != null) {
            jsonWriter2.name("upload_quota");
            a.B0(gson, jsonWriter2, user3.uploadQuota);
        }
        if (user3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(user3.link);
        }
        if (user3.pictures != null) {
            jsonWriter2.name("pictures");
            a.r0(gson, jsonWriter2, user3.pictures);
        }
        if (user3.account != null) {
            jsonWriter2.name("account");
            jsonWriter2.value(user3.account);
        }
        if (user3.location != null) {
            jsonWriter2.name("location");
            jsonWriter2.value(user3.location);
        }
        if (user3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(user3.uri);
        }
        if (user3.bio != null) {
            jsonWriter2.name("bio");
            jsonWriter2.value(user3.bio);
        }
        jsonWriter2.endObject();
    }

    public static Quota D(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        JsonToken nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Quota obj3 = new Quota();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (!bEGIN_OBJECT.equals("hd")) {
            } else {
            }
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            obj3.hd = jsonReader2.nextBoolean();
            if (bEGIN_OBJECT.equals("sd") == null) {
            } else {
            }
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            obj3.sd = jsonReader2.nextBoolean();
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj3;
    }

    public static void D0(Gson gson, JsonWriter jsonWriter2, UserBadge userBadge3) {
        String obj0;
        jsonWriter2.beginObject();
        if (userBadge3 == null) {
        }
        if (userBadge3.mAlternateText != null) {
            jsonWriter2.name("alt_text");
            jsonWriter2.value(userBadge3.mAlternateText);
        }
        if (userBadge3.mUrl != null) {
            jsonWriter2.name("url");
            jsonWriter2.value(userBadge3.mUrl);
        }
        if (userBadge3.mText != null) {
            jsonWriter2.name("text");
            jsonWriter2.value(userBadge3.mText);
        }
        if (userBadge3.mBadgeType != null) {
            jsonWriter2.name("type");
            jsonWriter2.value(userBadge3.mBadgeType);
        }
        jsonWriter2.endObject();
    }

    public static Recommendation E(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Recommendation recommendation = new Recommendation();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            recommendation.mChannel = a.d(gson, jsonReader2);
            recommendation.mCategory = a.b(gson, jsonReader2);
            recommendation.mUser = a.N(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            recommendation.mRecommendationType = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            recommendation.mResourceKey = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            recommendation.mDescription = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("channel")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("category")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("resource_key")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("description")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return recommendation;
    }

    public static void E0(Gson gson, JsonWriter jsonWriter2, UserList userList3) {
        ArrayList data;
        Paging paging;
        ArrayList data2;
        jsonWriter2.beginObject();
        if (userList3 == null) {
        }
        if (userList3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, User.class, userList3.data);
        }
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (userList3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, userList3.paging);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static SearchFacet F(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        JsonToken nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        SearchFacet searchFacet = new SearchFacet();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (!bEGIN_OBJECT.equals("options")) {
            } else {
            }
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            searchFacet.mOptions = a.a(gson, jsonReader2, FacetOption.class);
            if (bEGIN_OBJECT.equals("name") == null) {
            } else {
            }
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            searchFacet.mName = jsonReader2.nextString();
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return searchFacet;
    }

    public static void F0(Gson gson, JsonWriter jsonWriter2, Video video3) {
        com.vimeo.networking.model.Video.Status status;
        Privacy privacy;
        java.util.Date modifiedTime;
        String password;
        ArrayList files;
        String language;
        String name;
        User user;
        java.util.Date createdTime;
        String uri;
        String reviewLink;
        String link;
        Embed embed;
        String resourceKey;
        StatsCollection stats;
        Metadata metadata;
        PictureCollection pictures;
        java.util.Date releaseTime;
        ArrayList categories;
        String description;
        String license;
        ArrayList contentRating;
        ArrayList tags;
        Play play;
        ArrayList download;
        com.vimeo.networking.model.Video.Status contentRating2;
        Object obj4;
        jsonWriter2.beginObject();
        if (video3 == null) {
        }
        jsonWriter2.name("duration");
        jsonWriter2.value((long)duration);
        if (video3.status != null) {
            jsonWriter2.name("status");
            Stag.d(gson, Video.Status.class, jsonWriter2, video3.status);
        }
        if (video3.privacy != null) {
            jsonWriter2.name("privacy");
            a.v0(gson, jsonWriter2, video3.privacy);
        }
        if (video3.modifiedTime != null) {
            jsonWriter2.name("modified_time");
            Stag.d(gson, Date.class, jsonWriter2, video3.modifiedTime);
        }
        if (video3.password != null) {
            jsonWriter2.name("password");
            jsonWriter2.value(video3.password);
        }
        if (video3.files != null) {
            jsonWriter2.name("files");
            a.X0(gson, jsonWriter2, VideoFile.class, video3.files);
        }
        if (video3.language != null) {
            jsonWriter2.name("language");
            jsonWriter2.value(video3.language);
        }
        if (video3.name != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(video3.name);
        }
        if (video3.user != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, video3.user);
        }
        if (video3.createdTime != null) {
            jsonWriter2.name("created_time");
            Stag.d(gson, Date.class, jsonWriter2, video3.createdTime);
        }
        if (video3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(video3.uri);
        }
        if (video3.reviewLink != null) {
            jsonWriter2.name("review_link");
            jsonWriter2.value(video3.reviewLink);
        }
        if (video3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(video3.link);
        }
        if (video3.embed != null) {
            jsonWriter2.name("embed");
            a.i0(gson, jsonWriter2, video3.embed);
        }
        if (video3.resourceKey != null) {
            jsonWriter2.name("resource_key");
            jsonWriter2.value(video3.resourceKey);
        }
        if (video3.stats != null) {
            jsonWriter2.name("stats");
            a.z0(gson, jsonWriter2, video3.stats);
        }
        if (video3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, video3.metadata);
        }
        if (video3.pictures != null) {
            jsonWriter2.name("pictures");
            a.r0(gson, jsonWriter2, video3.pictures);
        }
        if (video3.releaseTime != null) {
            jsonWriter2.name("release_time");
            Stag.d(gson, Date.class, jsonWriter2, video3.releaseTime);
        }
        jsonWriter2.name("height");
        jsonWriter2.value((long)height);
        if (video3.categories != null) {
            jsonWriter2.name("categories");
            a.X0(gson, jsonWriter2, Category.class, video3.categories);
        }
        if (video3.description != null) {
            jsonWriter2.name("description");
            jsonWriter2.value(video3.description);
        }
        jsonWriter2.name("width");
        jsonWriter2.value((long)width);
        if (video3.license != null) {
            jsonWriter2.name("license");
            jsonWriter2.value(video3.license);
        }
        if (video3.contentRating != null) {
            jsonWriter2.name("content_rating");
            a.X0(gson, jsonWriter2, String.class, video3.contentRating);
        }
        if (video3.tags != null) {
            jsonWriter2.name("tags");
            a.X0(gson, jsonWriter2, Tag.class, video3.tags);
        }
        if (video3.play != null) {
            jsonWriter2.name("play");
            a.P0(gson, jsonWriter2, video3.play);
        }
        if (video3.download != null) {
            jsonWriter2.name("download");
            a.X0(gson, jsonWriter2, VideoFile.class, video3.download);
        }
        jsonWriter2.endObject();
    }

    public static SearchFacetCollection G(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        SearchFacetCollection searchFacetCollection = new SearchFacetCollection();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            peek = -1;
            jsonReader2.skipValue();
            searchFacetCollection.mUploadedFacet = a.F(gson, jsonReader2);
            searchFacetCollection.mUserTypeFacet = a.F(gson, jsonReader2);
            searchFacetCollection.mLicenseFacet = a.F(gson, jsonReader2);
            searchFacetCollection.mCategoryFacet = a.F(gson, jsonReader2);
            searchFacetCollection.mTypeFacet = a.F(gson, jsonReader2);
            searchFacetCollection.mDurationFacet = a.F(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("uploaded")) {
            } else {
            }
            peek = 5;
            if (!bEGIN_OBJECT.equals("user_type")) {
            } else {
            }
            peek = 4;
            if (!bEGIN_OBJECT.equals("license")) {
            } else {
            }
            peek = 3;
            if (!bEGIN_OBJECT.equals("category")) {
            } else {
            }
            peek = 2;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            peek = 1;
            if (!bEGIN_OBJECT.equals("duration")) {
            } else {
            }
            peek = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return searchFacetCollection;
    }

    public static void G0(Gson gson, JsonWriter jsonWriter2, VideoFile videoFile3) {
        VideoLog log;
        String token;
        java.util.Date expires;
        String link;
        java.util.Date linkExpirationTime2;
        com.vimeo.networking.model.VideoFile.VideoQuality quality;
        String licenseLink;
        String md5;
        com.vimeo.networking.model.VideoFile.MimeType type;
        java.util.Date createdTime;
        java.util.Date linkExpirationTime;
        Object obj4;
        jsonWriter2.beginObject();
        if (videoFile3 == null) {
        }
        if (videoFile3.log != null) {
            jsonWriter2.name("log");
            a.R0(gson, jsonWriter2, videoFile3.log);
        }
        if (videoFile3.token != null) {
            jsonWriter2.name("token");
            jsonWriter2.value(videoFile3.token);
        }
        jsonWriter2.name("height");
        jsonWriter2.value((long)height);
        if (videoFile3.expires != null) {
            jsonWriter2.name("expires");
            Stag.d(gson, Date.class, jsonWriter2, videoFile3.expires);
        }
        if (videoFile3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(videoFile3.link);
        }
        jsonWriter2.name("width");
        jsonWriter2.value((long)width);
        if (videoFile3.linkExpirationTime != null) {
            jsonWriter2.name("link_expiration_time");
            Stag.d(gson, Date.class, jsonWriter2, videoFile3.linkExpirationTime);
        }
        jsonWriter2.name("size");
        jsonWriter2.value(videoFile3.size);
        if (videoFile3.quality != null) {
            jsonWriter2.name("quality");
            Stag.d(gson, VideoFile.VideoQuality.class, jsonWriter2, videoFile3.quality);
        }
        if (videoFile3.licenseLink != null) {
            jsonWriter2.name("license_link");
            jsonWriter2.value(videoFile3.licenseLink);
        }
        jsonWriter2.name("fps");
        jsonWriter2.value(videoFile3.fps);
        if (videoFile3.md5 != null) {
            jsonWriter2.name("md5");
            jsonWriter2.value(videoFile3.md5);
        }
        if (videoFile3.type != null) {
            jsonWriter2.name("type");
            Stag.d(gson, VideoFile.MimeType.class, jsonWriter2, videoFile3.type);
        }
        if (videoFile3.createdTime != null) {
            jsonWriter2.name("created_time");
            Stag.d(gson, Date.class, jsonWriter2, videoFile3.createdTime);
        }
        jsonWriter2.endObject();
    }

    public static SearchResponse H(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        SearchResponse searchResponse = new SearchResponse();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            searchResponse.mMatureHiddenCount = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            searchResponse.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            searchResponse.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            searchResponse.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            searchResponse.data = a.a(gson, jsonReader2, SearchResult.class);
            searchResponse.paging = a.t(gson, jsonReader2);
            searchResponse.mFacetCollection = a.G(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("mature_hidden_count")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("facets")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return searchResponse;
    }

    public static void H0(Gson gson, JsonWriter jsonWriter2, VideoList videoList3) {
        ArrayList data;
        Paging paging;
        ArrayList data2;
        jsonWriter2.beginObject();
        if (videoList3 == null) {
        }
        if (videoList3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, Video.class, videoList3.data);
        }
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (videoList3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, videoList3.paging);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static SearchResult I(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        SearchResult searchResult = new SearchResult();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            searchResult.mVod = a.W(gson, jsonReader2);
            searchResult.mChannel = a.d(gson, jsonReader2);
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            searchResult.mIsStaffPick = jsonReader2.nextBoolean();
            searchResult.mGroup = a.p(gson, jsonReader2);
            searchResult.mSearchType = (SearchType)Stag.a(gson, SearchType.class, jsonReader2);
            searchResult.mVideo = a.Q(gson, jsonReader2);
            searchResult.mUser = a.N(gson, jsonReader2);
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            searchResult.mIsFeatured = jsonReader2.nextBoolean();
            if (!bEGIN_OBJECT.equals("ondemand")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("channel")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("is_staffpick")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("group")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("clip")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("people")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("is_featured")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return searchResult;
    }

    public static void I0(Gson gson, JsonWriter jsonWriter2, VideosPreference videosPreference3) {
        String obj0;
        jsonWriter2.beginObject();
        if (videosPreference3 == null) {
        }
        if (videosPreference3.privacy != null) {
            jsonWriter2.name("privacy");
            jsonWriter2.value(videosPreference3.privacy);
        }
        if (videosPreference3.password != null) {
            jsonWriter2.name("password");
            jsonWriter2.value(videosPreference3.password);
        }
        jsonWriter2.endObject();
    }

    public static Space J(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Space obj4 = new Space();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.used = jsonReader2.nextLong();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.free = jsonReader2.nextLong();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.max = jsonReader2.nextLong();
            if (!bEGIN_OBJECT.equals("used")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("free")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("max")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void J0(Gson gson, JsonWriter jsonWriter2, VimeoAccount vimeoAccount3) {
        String accessToken;
        String scope;
        User user;
        String obj1;
        jsonWriter2.beginObject();
        if (vimeoAccount3 == null) {
        }
        if (vimeoAccount3.accessToken != null) {
            jsonWriter2.name("access_token");
            jsonWriter2.value(vimeoAccount3.accessToken);
        }
        if (vimeoAccount3.scope != null) {
            jsonWriter2.name("scope");
            jsonWriter2.value(vimeoAccount3.scope);
        }
        if (vimeoAccount3.user != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, vimeoAccount3.user);
        }
        if (vimeoAccount3.tokenType != null) {
            jsonWriter2.name("token_type");
            jsonWriter2.value(vimeoAccount3.tokenType);
        }
        jsonWriter2.endObject();
    }

    public static StatsCollection K(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        JsonToken nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        StatsCollection statsCollection = new StatsCollection();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("plays") == null) {
            } else {
            }
            statsCollection.plays = (Integer)Stag.a(gson, Integer.class, jsonReader2);
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return statsCollection;
    }

    public static void K0(Gson gson, JsonWriter jsonWriter2, VodItem.Publish vodItem$Publish3) {
        java.util.Date mTime;
        Object obj3;
        jsonWriter2.beginObject();
        if (publish3 == null) {
        }
        if (publish3.mTime != null) {
            jsonWriter2.name("time");
            Stag.d(gson, Date.class, jsonWriter2, publish3.mTime);
        }
        jsonWriter2.endObject();
    }

    public static Tag L(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Tag tag = new Tag();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            tag.canonical = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            tag.name = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            tag.uri = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            tag.tag = jsonReader2.nextString();
            tag.metadata = a.s(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("canonical")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("tag")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return tag;
    }

    public static void L0(Gson gson, JsonWriter jsonWriter2, VodItem vodItem3) {
        Video mFilm;
        String mName;
        String mDescription;
        User mUser;
        Video mTrailer;
        com.vimeo.networking.model.VodItem.VodType mType2;
        String mLink;
        VodItem.Publish mPublish;
        PictureCollection mPictures;
        Object mMetadata;
        com.vimeo.networking.model.VodItem.VodType mType;
        Object obj4;
        jsonWriter2.beginObject();
        if (vodItem3 == null) {
        }
        if (vodItem3.mFilm != null) {
            jsonWriter2.name("film");
            a.F0(gson, jsonWriter2, vodItem3.mFilm);
        }
        if (vodItem3.mName != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(vodItem3.mName);
        }
        if (vodItem3.mDescription != null) {
            jsonWriter2.name("description");
            jsonWriter2.value(vodItem3.mDescription);
        }
        if (vodItem3.mUser != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, vodItem3.mUser);
        }
        if (vodItem3.mTrailer != null) {
            jsonWriter2.name("trailer");
            a.F0(gson, jsonWriter2, vodItem3.mTrailer);
        }
        if (vodItem3.mType != null) {
            jsonWriter2.name("type");
            Stag.d(gson, VodItem.VodType.class, jsonWriter2, vodItem3.mType);
        }
        if (vodItem3.mLink != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(vodItem3.mLink);
        }
        if (vodItem3.mPublish != null) {
            jsonWriter2.name("publish");
            a.K0(gson, jsonWriter2, vodItem3.mPublish);
        }
        if (vodItem3.mPictures != null) {
            jsonWriter2.name("pictures");
            a.r0(gson, jsonWriter2, vodItem3.mPictures);
        }
        if (vodItem3.mMetadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, vodItem3.mMetadata);
        }
        jsonWriter2.endObject();
    }

    public static UploadQuota M(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int equals;
        JsonToken nULL;
        equals = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return equals;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return equals;
        }
        jsonReader2.beginObject();
        UploadQuota uploadQuota = new UploadQuota();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("quota") == 0) {
            } else {
            }
            uploadQuota.quota = a.D(gson, jsonReader2);
            if (bEGIN_OBJECT.equals("space") == null) {
            } else {
            }
            uploadQuota.space = a.J(gson, jsonReader2);
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return uploadQuota;
    }

    public static void M0(Gson gson, JsonWriter jsonWriter2, VodList vodList3) {
        ArrayList data2;
        Paging paging;
        ArrayList data;
        jsonWriter2.beginObject();
        if (vodList3 == null) {
        }
        if (vodList3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, VodItem.class, vodList3.data);
        }
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (vodList3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, vodList3.paging);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static User N(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        User user = new User();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            user.createdTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            user.preferences = a.A(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            user.location = jsonReader2.nextString();
            user.badge = a.O(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            user.name = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            user.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            user.uri = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            user.bio = jsonReader2.nextString();
            user.metadata = a.s(gson, jsonReader2);
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            user.websites = a.a(gson, jsonReader2, Website.class);
            user.pictures = a.v(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            user.account = jsonReader2.nextString();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            user.emails = a.a(gson, jsonReader2, Email.class);
            user.uploadQuota = a.M(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("created_time")) {
            } else {
            }
            nULL = 13;
            if (!bEGIN_OBJECT.equals("preferences")) {
            } else {
            }
            nULL = 12;
            if (!bEGIN_OBJECT.equals("location")) {
            } else {
            }
            nULL = 11;
            if (!bEGIN_OBJECT.equals("badge")) {
            } else {
            }
            nULL = 10;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 9;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 8;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("bio")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("websites")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("pictures")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("account")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("emails")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("upload_quota")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return user;
    }

    public static void N0(Gson gson, JsonWriter jsonWriter2, Website website3) {
        String obj0;
        jsonWriter2.beginObject();
        if (website3 == null) {
        }
        if (website3.description != null) {
            jsonWriter2.name("description");
            jsonWriter2.value(website3.description);
        }
        if (website3.name != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(website3.name);
        }
        if (website3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(website3.link);
        }
        jsonWriter2.endObject();
    }

    public static UserBadge O(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        int str2;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        UserBadge obj4 = new UserBadge();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mAlternateText = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mBadgeType = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mText = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mUrl = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("alt_text")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("text")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("url")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void O0(Gson gson, JsonWriter jsonWriter2, Drm drm3) {
        VideoFile mPlayReady;
        Object mWidevine;
        Object obj3;
        jsonWriter2.beginObject();
        if (drm3 == null) {
        }
        if (drm3.mPlayReady != null) {
            jsonWriter2.name("playready");
            a.G0(gson, jsonWriter2, drm3.mPlayReady);
        }
        if (drm3.mWidevine != null) {
            jsonWriter2.name("widevine");
            a.G0(gson, jsonWriter2, drm3.mWidevine);
        }
        jsonWriter2.endObject();
    }

    public static UserList P(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        UserList userList = new UserList();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            userList.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            userList.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            userList.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            userList.data = a.a(gson, jsonReader2, User.class);
            userList.paging = a.t(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return userList;
    }

    public static void P0(Gson gson, JsonWriter jsonWriter2, Play play3) {
        ArrayList mProgressive2;
        com.vimeo.networking.model.playback.Play.Status mStatus;
        VideoFile mDash;
        com.vimeo.networking.model.playback.embed.Embed mEmbed;
        Drm mDrm;
        PlayProgress mProgress;
        Object mHls;
        ArrayList mProgressive;
        Object obj4;
        jsonWriter2.beginObject();
        if (play3 == null) {
        }
        if (play3.mProgressive != null) {
            jsonWriter2.name("progressive");
            a.X0(gson, jsonWriter2, VideoFile.class, play3.mProgressive);
        }
        if (play3.mStatus != null) {
            jsonWriter2.name("status");
            Stag.d(gson, Play.Status.class, jsonWriter2, play3.mStatus);
        }
        if (play3.mDash != null) {
            jsonWriter2.name("dash");
            a.G0(gson, jsonWriter2, play3.mDash);
        }
        if (play3.mEmbed != null) {
            jsonWriter2.name("embed");
            Stag.d(gson, Embed.class, jsonWriter2, play3.mEmbed);
        }
        if (play3.mDrm != null) {
            jsonWriter2.name("drm");
            a.O0(gson, jsonWriter2, play3.mDrm);
        }
        if (play3.mProgress != null) {
            jsonWriter2.name("progress");
            a.Q0(gson, jsonWriter2, play3.mProgress);
        }
        if (play3.mHls != null) {
            jsonWriter2.name("hls");
            a.G0(gson, jsonWriter2, play3.mHls);
        }
        jsonWriter2.endObject();
    }

    public static Video Q(Gson gson, JsonReader jsonReader2) {
        android.os.Parcelable.Creator creator;
        JsonToken bEGIN_OBJECT;
        int peek;
        long nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Video video = new Video();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            video.modifiedTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            video.createdTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            video.download = a.a(gson, jsonReader2, VideoFile.class);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.reviewLink = jsonReader2.nextString();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            video.categories = a.a(gson, jsonReader2, Category.class);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.password = jsonReader2.nextString();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            video.contentRating = a.a(gson, jsonReader2, String.class);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.license = jsonReader2.nextString();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            video.width = jsonReader2.nextInt();
            video.stats = a.K(gson, jsonReader2);
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            video.files = a.a(gson, jsonReader2, VideoFile.class);
            video.embed = a.l(gson, jsonReader2);
            video.user = a.N(gson, jsonReader2);
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            video.tags = a.a(gson, jsonReader2, Tag.class);
            video.play = a.y(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.name = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.uri = jsonReader2.nextString();
            video.privacy = a.B(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.resourceKey = jsonReader2.nextString();
            video.metadata = a.s(gson, jsonReader2);
            video.pictures = a.v(gson, jsonReader2);
            video.status = (Video.Status)Stag.a(gson, Video.Status.class, jsonReader2);
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            video.height = jsonReader2.nextInt();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.language = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            video.description = jsonReader2.nextString();
            video.releaseTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            video.duration = jsonReader2.nextInt();
            if (!bEGIN_OBJECT.equals("modified_time")) {
            } else {
            }
            nULL = 27;
            if (!bEGIN_OBJECT.equals("created_time")) {
            } else {
            }
            nULL = 26;
            if (!bEGIN_OBJECT.equals("download")) {
            } else {
            }
            nULL = 25;
            if (!bEGIN_OBJECT.equals("review_link")) {
            } else {
            }
            nULL = 24;
            if (!bEGIN_OBJECT.equals("categories")) {
            } else {
            }
            nULL = 23;
            if (!bEGIN_OBJECT.equals("password")) {
            } else {
            }
            nULL = 22;
            if (!bEGIN_OBJECT.equals("content_rating")) {
            } else {
            }
            nULL = 21;
            if (!bEGIN_OBJECT.equals("license")) {
            } else {
            }
            nULL = 20;
            if (!bEGIN_OBJECT.equals("width")) {
            } else {
            }
            nULL = 19;
            if (!bEGIN_OBJECT.equals("stats")) {
            } else {
            }
            nULL = 18;
            if (bEGIN_OBJECT.equals("files") == null) {
            } else {
            }
            nULL = 17;
            if (!bEGIN_OBJECT.equals("embed")) {
            } else {
            }
            nULL = 16;
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 15;
            if (!bEGIN_OBJECT.equals("tags")) {
            } else {
            }
            nULL = 14;
            if (!bEGIN_OBJECT.equals("play")) {
            } else {
            }
            nULL = 13;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 12;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 11;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 10;
            if (!bEGIN_OBJECT.equals("privacy")) {
            } else {
            }
            nULL = 9;
            if (!bEGIN_OBJECT.equals("resource_key")) {
            } else {
            }
            nULL = 8;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("pictures")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("status")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("height")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("language")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("description")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("release_time")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("duration")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return video;
    }

    public static void Q0(Gson gson, JsonWriter jsonWriter2, PlayProgress playProgress3) {
        jsonWriter2.beginObject();
        if (playProgress3 == null) {
        }
        jsonWriter2.name("seconds");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static VideoFile R(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VideoFile videoFile = new VideoFile();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            videoFile.createdTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.licenseLink = jsonReader2.nextString();
            videoFile.quality = (VideoFile.VideoQuality)Stag.a(gson, VideoFile.VideoQuality.class, jsonReader2);
            videoFile.linkExpirationTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.width = jsonReader2.nextInt();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.token = jsonReader2.nextString();
            videoFile.type = (VideoFile.MimeType)Stag.a(gson, VideoFile.MimeType.class, jsonReader2);
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.size = jsonReader2.nextLong();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.md5 = jsonReader2.nextString();
            videoFile.log = a.T(gson, jsonReader2);
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.fps = jsonReader2.nextDouble();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            videoFile.height = jsonReader2.nextInt();
            videoFile.expires = (Date)Stag.a(gson, Date.class, jsonReader2);
            if (!bEGIN_OBJECT.equals("created_time")) {
            } else {
            }
            nULL = 13;
            if (!bEGIN_OBJECT.equals("license_link")) {
            } else {
            }
            nULL = 12;
            if (!bEGIN_OBJECT.equals("quality")) {
            } else {
            }
            nULL = 11;
            if (!bEGIN_OBJECT.equals("link_expiration_time")) {
            } else {
            }
            nULL = 10;
            if (!bEGIN_OBJECT.equals("width")) {
            } else {
            }
            nULL = 9;
            if (!bEGIN_OBJECT.equals("token")) {
            } else {
            }
            nULL = 8;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("size")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("md5")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("log")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("fps")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("height")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("expires")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return videoFile;
    }

    public static void R0(Gson gson, JsonWriter jsonWriter2, VideoLog videoLog3) {
        String obj0;
        jsonWriter2.beginObject();
        if (videoLog3 == null) {
        }
        if (videoLog3.mLoadLink != null) {
            jsonWriter2.name("load_link");
            jsonWriter2.value(videoLog3.mLoadLink);
        }
        if (videoLog3.mLikePressLink != null) {
            jsonWriter2.name("like_press_link");
            jsonWriter2.value(videoLog3.mLikePressLink);
        }
        if (videoLog3.mWatchLaterPressLink != null) {
            jsonWriter2.name("watchlater_press_link");
            jsonWriter2.value(videoLog3.mWatchLaterPressLink);
        }
        if (videoLog3.mExitLink != null) {
            jsonWriter2.name("exit_link");
            jsonWriter2.value(videoLog3.mExitLink);
        }
        if (videoLog3.mPlayLink != null) {
            jsonWriter2.name("play_link");
            jsonWriter2.value(videoLog3.mPlayLink);
        }
        jsonWriter2.endObject();
    }

    public static VideoList S(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VideoList videoList = new VideoList();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            videoList.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            videoList.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            videoList.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            videoList.data = a.a(gson, jsonReader2, Video.class);
            videoList.paging = a.t(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return videoList;
    }

    public static void S0(Gson gson, JsonWriter jsonWriter2, FacetOption facetOption3) {
        String obj2;
        jsonWriter2.beginObject();
        if (facetOption3 == null) {
        }
        if (facetOption3.mName != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(facetOption3.mName);
        }
        if (facetOption3.mText != null) {
            jsonWriter2.name("text");
            jsonWriter2.value(facetOption3.mText);
        }
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static VideoLog T(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VideoLog obj4 = new VideoLog();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mWatchLaterPressLink = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mLoadLink = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mLikePressLink = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mExitLink = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mPlayLink = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("watchlater_press_link")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("load_link")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("like_press_link")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("exit_link")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("play_link")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void T0(Gson gson, JsonWriter jsonWriter2, SearchFacet searchFacet3) {
        String mName;
        ArrayList mOptions;
        Object obj3;
        jsonWriter2.beginObject();
        if (searchFacet3 == null) {
        }
        if (searchFacet3.mName != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(searchFacet3.mName);
        }
        if (searchFacet3.mOptions != null) {
            jsonWriter2.name("options");
            a.X0(gson, jsonWriter2, FacetOption.class, searchFacet3.mOptions);
        }
        jsonWriter2.endObject();
    }

    public static VideosPreference U(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        JsonToken nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VideosPreference obj3 = new VideosPreference();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (!bEGIN_OBJECT.equals("privacy")) {
            } else {
            }
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj3.privacy = jsonReader2.nextString();
            if (bEGIN_OBJECT.equals("password") == null) {
            } else {
            }
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj3.password = jsonReader2.nextString();
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj3;
    }

    public static void U0(Gson gson, JsonWriter jsonWriter2, SearchFacetCollection searchFacetCollection3) {
        SearchFacet mDurationFacet;
        SearchFacet mUserTypeFacet;
        SearchFacet mCategoryFacet;
        SearchFacet mTypeFacet;
        SearchFacet mLicenseFacet;
        Object mUploadedFacet;
        Object obj3;
        jsonWriter2.beginObject();
        if (searchFacetCollection3 == null) {
        }
        if (searchFacetCollection3.mDurationFacet != null) {
            jsonWriter2.name("duration");
            a.T0(gson, jsonWriter2, searchFacetCollection3.mDurationFacet);
        }
        if (searchFacetCollection3.mUserTypeFacet != null) {
            jsonWriter2.name("user_type");
            a.T0(gson, jsonWriter2, searchFacetCollection3.mUserTypeFacet);
        }
        if (searchFacetCollection3.mCategoryFacet != null) {
            jsonWriter2.name("category");
            a.T0(gson, jsonWriter2, searchFacetCollection3.mCategoryFacet);
        }
        if (searchFacetCollection3.mTypeFacet != null) {
            jsonWriter2.name("type");
            a.T0(gson, jsonWriter2, searchFacetCollection3.mTypeFacet);
        }
        if (searchFacetCollection3.mLicenseFacet != null) {
            jsonWriter2.name("license");
            a.T0(gson, jsonWriter2, searchFacetCollection3.mLicenseFacet);
        }
        if (searchFacetCollection3.mUploadedFacet != null) {
            jsonWriter2.name("uploaded");
            a.T0(gson, jsonWriter2, searchFacetCollection3.mUploadedFacet);
        }
        jsonWriter2.endObject();
    }

    public static VimeoAccount V(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VimeoAccount vimeoAccount = new VimeoAccount();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            vimeoAccount.scope = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            vimeoAccount.tokenType = jsonReader2.nextString();
            vimeoAccount.user = a.N(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            vimeoAccount.accessToken = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("scope")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("token_type")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("access_token")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return vimeoAccount;
    }

    public static void V0(Gson gson, JsonWriter jsonWriter2, SearchResponse searchResponse3) {
        ArrayList data2;
        SearchFacetCollection mFacetCollection;
        Paging paging;
        ArrayList data;
        jsonWriter2.beginObject();
        if (searchResponse3 == null) {
        }
        if (searchResponse3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, SearchResult.class, searchResponse3.data);
        }
        jsonWriter2.name("mature_hidden_count");
        jsonWriter2.value((long)mMatureHiddenCount);
        if (searchResponse3.mFacetCollection != null) {
            jsonWriter2.name("facets");
            a.U0(gson, jsonWriter2, searchResponse3.mFacetCollection);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)perPage);
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (searchResponse3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, searchResponse3.paging);
        }
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static VodItem W(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VodItem vodItem = new VodItem();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            vodItem.mUser = a.N(gson, jsonReader2);
            vodItem.mType = (VodItem.VodType)Stag.a(gson, VodItem.VodType.class, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            vodItem.mName = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            vodItem.mLink = jsonReader2.nextString();
            vodItem.mFilm = a.Q(gson, jsonReader2);
            vodItem.mPublish = a.C(gson, jsonReader2);
            vodItem.mMetadata = a.s(gson, jsonReader2);
            vodItem.mPictures = a.v(gson, jsonReader2);
            vodItem.mTrailer = a.Q(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            vodItem.mDescription = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 9;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            nULL = 8;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("film")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("publish")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("pictures")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("trailer")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("description")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return vodItem;
    }

    public static void W0(Gson gson, JsonWriter jsonWriter2, SearchResult searchResult3) {
        Video mVideo;
        Channel mChannel;
        com.vimeo.networking.model.search.SearchType mSearchType2;
        Group mGroup;
        VodItem mVod;
        Object mUser;
        com.vimeo.networking.model.search.SearchType mSearchType;
        Object obj4;
        jsonWriter2.beginObject();
        if (searchResult3 == null) {
        }
        if (searchResult3.mVideo != null) {
            jsonWriter2.name("clip");
            a.F0(gson, jsonWriter2, searchResult3.mVideo);
        }
        if (searchResult3.mChannel != null) {
            jsonWriter2.name("channel");
            a.b0(gson, jsonWriter2, searchResult3.mChannel);
        }
        if (searchResult3.mSearchType != null) {
            jsonWriter2.name("type");
            Stag.d(gson, SearchType.class, jsonWriter2, searchResult3.mSearchType);
        }
        if (searchResult3.mGroup != null) {
            jsonWriter2.name("group");
            a.l0(gson, jsonWriter2, searchResult3.mGroup);
        }
        jsonWriter2.name("is_staffpick");
        jsonWriter2.value(searchResult3.mIsStaffPick);
        if (searchResult3.mVod != null) {
            jsonWriter2.name("ondemand");
            a.L0(gson, jsonWriter2, searchResult3.mVod);
        }
        jsonWriter2.name("is_featured");
        jsonWriter2.value(searchResult3.mIsFeatured);
        if (searchResult3.mUser != null) {
            jsonWriter2.name("people");
            a.C0(gson, jsonWriter2, searchResult3.mUser);
        }
        jsonWriter2.endObject();
    }

    public static VodList X(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        VodList vodList = new VodList();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            vodList.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            vodList.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            vodList.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            vodList.data = a.a(gson, jsonReader2, VodItem.class);
            vodList.paging = a.t(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return vodList;
    }

    public static <T> void X0(Gson gson, JsonWriter jsonWriter2, Class class3, ArrayList<T> arrayList4) {
        if (arrayList4 == null) {
        }
        jsonWriter2.beginArray();
        Stag.c(gson, class3, jsonWriter2, arrayList4);
        jsonWriter2.endArray();
    }

    public static Website Y(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Website obj4 = new Website();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.name = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.description = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("description")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void Z(Gson gson, JsonWriter jsonWriter2, Category category3) {
        Metadata metadata;
        Category parent;
        String name;
        ArrayList subcategories2;
        String link;
        PictureCollection pictures;
        ArrayList subcategories;
        String obj2;
        jsonWriter2.beginObject();
        if (category3 == null) {
        }
        if (category3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, category3.metadata);
        }
        if (category3.parent != null) {
            jsonWriter2.name("parent");
            a.Z(gson, jsonWriter2, category3.parent);
        }
        if (category3.name != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(category3.name);
        }
        if (category3.subcategories != null) {
            jsonWriter2.name("subcategories");
            a.X0(gson, jsonWriter2, Category.class, category3.subcategories);
        }
        if (category3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(category3.link);
        }
        if (category3.pictures != null) {
            jsonWriter2.name("pictures");
            a.r0(gson, jsonWriter2, category3.pictures);
        }
        if (category3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(category3.uri);
        }
        jsonWriter2.name("top_level");
        jsonWriter2.value(category3.topLevel);
        jsonWriter2.endObject();
    }

    public static <T> ArrayList<T> a(Gson gson, JsonReader jsonReader2, Class<T> class3) {
        if (jsonReader2.peek() != JsonToken.BEGIN_ARRAY) {
            jsonReader2.skipValue();
            return 0;
        }
        jsonReader2.beginArray();
        jsonReader2.endArray();
        return Stag.b(gson, class3, jsonReader2);
    }

    public static void a0(Gson gson, JsonWriter jsonWriter2, CategoryList categoryList3) {
        ArrayList data;
        Paging paging;
        ArrayList data2;
        jsonWriter2.beginObject();
        if (categoryList3 == null) {
        }
        if (categoryList3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, Category.class, categoryList3.data);
        }
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (categoryList3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, categoryList3.paging);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static Category b(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Category category = new Category();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            category.topLevel = jsonReader2.nextBoolean();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            category.name = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            category.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            category.uri = jsonReader2.nextString();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            category.subcategories = a.a(gson, jsonReader2, Category.class);
            category.metadata = a.s(gson, jsonReader2);
            category.pictures = a.v(gson, jsonReader2);
            category.parent = a.b(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("top_level")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("subcategories")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("pictures")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("parent")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return category;
    }

    public static void b0(Gson gson, JsonWriter jsonWriter2, Channel channel3) {
        Metadata metadata;
        User user;
        PictureCollection pictures;
        String description;
        String link;
        java.util.Date createdTime;
        Privacy privacy;
        String uri;
        java.util.Date modifiedTime2;
        String name;
        Object header;
        java.util.Date modifiedTime;
        Object obj4;
        jsonWriter2.beginObject();
        if (channel3 == null) {
        }
        if (channel3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, channel3.metadata);
        }
        if (channel3.user != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, channel3.user);
        }
        if (channel3.pictures != null) {
            jsonWriter2.name("pictures");
            a.r0(gson, jsonWriter2, channel3.pictures);
        }
        if (channel3.description != null) {
            jsonWriter2.name("description");
            jsonWriter2.value(channel3.description);
        }
        if (channel3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(channel3.link);
        }
        if (channel3.createdTime != null) {
            jsonWriter2.name("created_time");
            Stag.d(gson, Date.class, jsonWriter2, channel3.createdTime);
        }
        if (channel3.privacy != null) {
            jsonWriter2.name("privacy");
            a.v0(gson, jsonWriter2, channel3.privacy);
        }
        if (channel3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(channel3.uri);
        }
        if (channel3.modifiedTime != null) {
            jsonWriter2.name("modified_time");
            Stag.d(gson, Date.class, jsonWriter2, channel3.modifiedTime);
        }
        if (channel3.name != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(channel3.name);
        }
        if (channel3.header != null) {
            jsonWriter2.name("header");
            a.r0(gson, jsonWriter2, channel3.header);
        }
        jsonWriter2.endObject();
    }

    public static CategoryList c(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        CategoryList categoryList = new CategoryList();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            categoryList.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            categoryList.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            categoryList.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            categoryList.data = a.a(gson, jsonReader2, Category.class);
            categoryList.paging = a.t(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return categoryList;
    }

    public static void c0(Gson gson, JsonWriter jsonWriter2, ChannelList channelList3) {
        ArrayList data;
        Paging paging;
        ArrayList data2;
        jsonWriter2.beginObject();
        if (channelList3 == null) {
        }
        if (channelList3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, Channel.class, channelList3.data);
        }
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (channelList3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, channelList3.paging);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static Channel d(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        long nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Channel channel = new Channel();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            channel.modifiedTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            channel.createdTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            channel.user = a.N(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            channel.name = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            channel.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            channel.uri = jsonReader2.nextString();
            channel.privacy = a.B(gson, jsonReader2);
            channel.metadata = a.s(gson, jsonReader2);
            channel.pictures = a.v(gson, jsonReader2);
            channel.header = a.v(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            channel.description = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("modified_time")) {
            } else {
            }
            nULL = 10;
            if (!bEGIN_OBJECT.equals("created_time")) {
            } else {
            }
            nULL = 9;
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 8;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("privacy")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("pictures")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("header")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("description")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return channel;
    }

    public static void d0(Gson gson, JsonWriter jsonWriter2, Comment comment3) {
        java.util.Date createdOn;
        User user;
        com.vimeo.networking.model.Comment.CommentType type;
        String uri;
        String text;
        Object metadata;
        java.util.Date createdOn2;
        Object obj4;
        jsonWriter2.beginObject();
        if (comment3 == null) {
        }
        if (comment3.createdOn != null) {
            jsonWriter2.name("created_on");
            Stag.d(gson, Date.class, jsonWriter2, comment3.createdOn);
        }
        if (comment3.user != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, comment3.user);
        }
        if (comment3.type != null) {
            jsonWriter2.name("type");
            Stag.d(gson, Comment.CommentType.class, jsonWriter2, comment3.type);
        }
        if (comment3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(comment3.uri);
        }
        if (comment3.text != null) {
            jsonWriter2.name("text");
            jsonWriter2.value(comment3.text);
        }
        if (comment3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, comment3.metadata);
        }
        jsonWriter2.endObject();
    }

    public static ChannelList e(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        ChannelList channelList = new ChannelList();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            channelList.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            channelList.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            channelList.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            channelList.data = a.a(gson, jsonReader2, Channel.class);
            channelList.paging = a.t(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return channelList;
    }

    public static void e0(Gson gson, JsonWriter jsonWriter2, CommentList commentList3) {
        ArrayList data2;
        Paging paging;
        ArrayList data;
        jsonWriter2.beginObject();
        if (commentList3 == null) {
        }
        if (commentList3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, Comment.class, commentList3.data);
        }
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (commentList3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, commentList3.paging);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static Comment f(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Comment comment = new Comment();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            comment.createdOn = (Date)Stag.a(gson, Date.class, jsonReader2);
            comment.user = a.N(gson, jsonReader2);
            comment.type = (Comment.CommentType)Stag.a(gson, Comment.CommentType.class, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            comment.text = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            comment.uri = jsonReader2.nextString();
            comment.metadata = a.s(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("created_on")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("text")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return comment;
    }

    public static void f0(Gson gson, JsonWriter jsonWriter2, Connection connection3) {
        ArrayList options;
        ArrayList options2;
        String obj2;
        jsonWriter2.beginObject();
        if (connection3 == null) {
        }
        if (connection3.options != null) {
            jsonWriter2.name("options");
            a.X0(gson, jsonWriter2, String.class, connection3.options);
        }
        jsonWriter2.name("extra_total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("main_total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("viewable_total");
        jsonWriter2.value((long)obj2);
        if (connection3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(connection3.uri);
        }
        jsonWriter2.endObject();
    }

    public static CommentList g(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        CommentList commentList = new CommentList();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            commentList.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            commentList.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            commentList.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            commentList.data = a.a(gson, jsonReader2, Comment.class);
            commentList.paging = a.t(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return commentList;
    }

    public static void g0(Gson gson, JsonWriter jsonWriter2, ConnectionCollection connectionCollection3) {
        Connection ondemand;
        Connection channels;
        Connection comments;
        Connection groups;
        Connection portfolios;
        Connection watchlater;
        Connection playbackFailureReason;
        Connection feed;
        Connection trailer;
        Connection texttracks;
        Connection users;
        Connection likes;
        Connection related;
        Connection videos;
        Connection pictures;
        Connection appearances;
        Connection credits;
        Connection followers;
        Connection categories;
        Connection albums;
        Connection activities;
        Connection replies;
        Connection following;
        Connection shared;
        Object recommendations;
        Object obj3;
        jsonWriter2.beginObject();
        if (connectionCollection3 == null) {
        }
        if (connectionCollection3.ondemand != null) {
            jsonWriter2.name("ondemand");
            a.f0(gson, jsonWriter2, connectionCollection3.ondemand);
        }
        if (connectionCollection3.channels != null) {
            jsonWriter2.name("channels");
            a.f0(gson, jsonWriter2, connectionCollection3.channels);
        }
        if (connectionCollection3.comments != null) {
            jsonWriter2.name("comments");
            a.f0(gson, jsonWriter2, connectionCollection3.comments);
        }
        if (connectionCollection3.groups != null) {
            jsonWriter2.name("groups");
            a.f0(gson, jsonWriter2, connectionCollection3.groups);
        }
        if (connectionCollection3.portfolios != null) {
            jsonWriter2.name("portfolios");
            a.f0(gson, jsonWriter2, connectionCollection3.portfolios);
        }
        if (connectionCollection3.watchlater != null) {
            jsonWriter2.name("watchlater");
            a.f0(gson, jsonWriter2, connectionCollection3.watchlater);
        }
        if (connectionCollection3.playbackFailureReason != null) {
            jsonWriter2.name("playback");
            a.f0(gson, jsonWriter2, connectionCollection3.playbackFailureReason);
        }
        if (connectionCollection3.feed != null) {
            jsonWriter2.name("feed");
            a.f0(gson, jsonWriter2, connectionCollection3.feed);
        }
        if (connectionCollection3.trailer != null) {
            jsonWriter2.name("trailer");
            a.f0(gson, jsonWriter2, connectionCollection3.trailer);
        }
        if (connectionCollection3.texttracks != null) {
            jsonWriter2.name("texttracks");
            a.f0(gson, jsonWriter2, connectionCollection3.texttracks);
        }
        if (connectionCollection3.users != null) {
            jsonWriter2.name("users");
            a.f0(gson, jsonWriter2, connectionCollection3.users);
        }
        if (connectionCollection3.likes != null) {
            jsonWriter2.name("likes");
            a.f0(gson, jsonWriter2, connectionCollection3.likes);
        }
        if (connectionCollection3.related != null) {
            jsonWriter2.name("related");
            a.f0(gson, jsonWriter2, connectionCollection3.related);
        }
        if (connectionCollection3.videos != null) {
            jsonWriter2.name("videos");
            a.f0(gson, jsonWriter2, connectionCollection3.videos);
        }
        if (connectionCollection3.pictures != null) {
            jsonWriter2.name("pictures");
            a.f0(gson, jsonWriter2, connectionCollection3.pictures);
        }
        if (connectionCollection3.appearances != null) {
            jsonWriter2.name("appearances");
            a.f0(gson, jsonWriter2, connectionCollection3.appearances);
        }
        if (connectionCollection3.credits != null) {
            jsonWriter2.name("credits");
            a.f0(gson, jsonWriter2, connectionCollection3.credits);
        }
        if (connectionCollection3.followers != null) {
            jsonWriter2.name("followers");
            a.f0(gson, jsonWriter2, connectionCollection3.followers);
        }
        if (connectionCollection3.categories != null) {
            jsonWriter2.name("categories");
            a.f0(gson, jsonWriter2, connectionCollection3.categories);
        }
        if (connectionCollection3.albums != null) {
            jsonWriter2.name("albums");
            a.f0(gson, jsonWriter2, connectionCollection3.albums);
        }
        if (connectionCollection3.activities != null) {
            jsonWriter2.name("activities");
            a.f0(gson, jsonWriter2, connectionCollection3.activities);
        }
        if (connectionCollection3.replies != null) {
            jsonWriter2.name("replies");
            a.f0(gson, jsonWriter2, connectionCollection3.replies);
        }
        if (connectionCollection3.following != null) {
            jsonWriter2.name("following");
            a.f0(gson, jsonWriter2, connectionCollection3.following);
        }
        if (connectionCollection3.shared != null) {
            jsonWriter2.name("shared");
            a.f0(gson, jsonWriter2, connectionCollection3.shared);
        }
        if (connectionCollection3.recommendations != null) {
            jsonWriter2.name("recommendations");
            a.f0(gson, jsonWriter2, connectionCollection3.recommendations);
        }
        jsonWriter2.endObject();
    }

    public static Connection h(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Connection connection = new Connection();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            connection.extraTotal = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            connection.mainTotal = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            connection.total = jsonReader2.nextInt();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            connection.uri = jsonReader2.nextString();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            connection.viewableTotal = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            connection.options = a.a(gson, jsonReader2, String.class);
            if (!bEGIN_OBJECT.equals("extra_total")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("main_total")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("viewable_total")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("options")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return connection;
    }

    public static void h0(Gson gson, JsonWriter jsonWriter2, Email email3) {
        String obj0;
        jsonWriter2.beginObject();
        if (email3 == null) {
        }
        if (email3.email != null) {
            jsonWriter2.name("email");
            jsonWriter2.value(email3.email);
        }
        jsonWriter2.endObject();
    }

    public static ConnectionCollection i(Gson gson, JsonReader jsonReader2) {
        int i;
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        ConnectionCollection connectionCollection = new ConnectionCollection();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            peek = -1;
            jsonReader2.skipValue();
            connectionCollection.activities = a.h(gson, jsonReader2);
            connectionCollection.ondemand = a.h(gson, jsonReader2);
            connectionCollection.playbackFailureReason = a.h(gson, jsonReader2);
            connectionCollection.channels = a.h(gson, jsonReader2);
            connectionCollection.categories = a.h(gson, jsonReader2);
            connectionCollection.replies = a.h(gson, jsonReader2);
            connectionCollection.related = a.h(gson, jsonReader2);
            connectionCollection.credits = a.h(gson, jsonReader2);
            connectionCollection.following = a.h(gson, jsonReader2);
            connectionCollection.followers = a.h(gson, jsonReader2);
            connectionCollection.portfolios = a.h(gson, jsonReader2);
            connectionCollection.users = a.h(gson, jsonReader2);
            connectionCollection.likes = a.h(gson, jsonReader2);
            connectionCollection.feed = a.h(gson, jsonReader2);
            connectionCollection.watchlater = a.h(gson, jsonReader2);
            connectionCollection.appearances = a.h(gson, jsonReader2);
            connectionCollection.comments = a.h(gson, jsonReader2);
            connectionCollection.pictures = a.h(gson, jsonReader2);
            connectionCollection.videos = a.h(gson, jsonReader2);
            connectionCollection.shared = a.h(gson, jsonReader2);
            connectionCollection.trailer = a.h(gson, jsonReader2);
            connectionCollection.groups = a.h(gson, jsonReader2);
            connectionCollection.albums = a.h(gson, jsonReader2);
            connectionCollection.texttracks = a.h(gson, jsonReader2);
            connectionCollection.recommendations = a.h(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("activities")) {
            } else {
            }
            peek = 24;
            if (!bEGIN_OBJECT.equals("ondemand")) {
            } else {
            }
            peek = 23;
            if (!bEGIN_OBJECT.equals("playback")) {
            } else {
            }
            peek = 22;
            if (!bEGIN_OBJECT.equals("channels")) {
            } else {
            }
            peek = 21;
            if (!bEGIN_OBJECT.equals("categories")) {
            } else {
            }
            peek = 20;
            if (!bEGIN_OBJECT.equals("replies")) {
            } else {
            }
            peek = 19;
            if (!bEGIN_OBJECT.equals("related")) {
            } else {
            }
            peek = 18;
            if (!bEGIN_OBJECT.equals("credits")) {
            } else {
            }
            peek = 17;
            if (!bEGIN_OBJECT.equals("following")) {
            } else {
            }
            peek = 16;
            if (!bEGIN_OBJECT.equals("followers")) {
            } else {
            }
            peek = 15;
            if (!bEGIN_OBJECT.equals("portfolios")) {
            } else {
            }
            peek = 14;
            if (!bEGIN_OBJECT.equals("users")) {
            } else {
            }
            peek = 13;
            if (!bEGIN_OBJECT.equals("likes")) {
            } else {
            }
            peek = 12;
            if (!bEGIN_OBJECT.equals("feed")) {
            } else {
            }
            peek = 11;
            if (!bEGIN_OBJECT.equals("watchlater")) {
            } else {
            }
            peek = 10;
            if (!bEGIN_OBJECT.equals("appearances")) {
            } else {
            }
            peek = 9;
            if (!bEGIN_OBJECT.equals("comments")) {
            } else {
            }
            peek = 8;
            if (!bEGIN_OBJECT.equals("pictures")) {
            } else {
            }
            peek = 7;
            if (!bEGIN_OBJECT.equals("videos")) {
            } else {
            }
            peek = 6;
            if (!bEGIN_OBJECT.equals("shared")) {
            } else {
            }
            peek = 5;
            if (!bEGIN_OBJECT.equals("trailer")) {
            } else {
            }
            peek = 4;
            if (!bEGIN_OBJECT.equals("groups")) {
            } else {
            }
            peek = 3;
            if (!bEGIN_OBJECT.equals("albums")) {
            } else {
            }
            peek = 2;
            if (!bEGIN_OBJECT.equals("texttracks")) {
            } else {
            }
            peek = 1;
            if (!bEGIN_OBJECT.equals("recommendations")) {
            } else {
            }
            peek = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return connectionCollection;
    }

    public static void i0(Gson gson, JsonWriter jsonWriter2, Embed embed3) {
        String obj0;
        jsonWriter2.beginObject();
        if (embed3 == null) {
        }
        if (embed3.html != null) {
            jsonWriter2.name("html");
            jsonWriter2.value(embed3.html);
        }
        jsonWriter2.endObject();
    }

    public static Drm j(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int equals;
        JsonToken nULL;
        equals = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return equals;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return equals;
        }
        jsonReader2.beginObject();
        Drm drm = new Drm();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("playready") == 0) {
            } else {
            }
            drm.mPlayReady = a.R(gson, jsonReader2);
            if (bEGIN_OBJECT.equals("widevine") == null) {
            } else {
            }
            drm.mWidevine = a.R(gson, jsonReader2);
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return drm;
    }

    public static void j0(Gson gson, JsonWriter jsonWriter2, FeedItem feedItem3) {
        Channel channel;
        String uri;
        java.util.Date time2;
        Tag tag;
        String type;
        Category category;
        Metadata metadata;
        User user;
        Group group;
        Object clip;
        java.util.Date time;
        Object obj4;
        jsonWriter2.beginObject();
        if (feedItem3 == null) {
        }
        if (feedItem3.channel != null) {
            jsonWriter2.name("channel");
            a.b0(gson, jsonWriter2, feedItem3.channel);
        }
        if (feedItem3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(feedItem3.uri);
        }
        if (feedItem3.time != null) {
            jsonWriter2.name("time");
            Stag.d(gson, Date.class, jsonWriter2, feedItem3.time);
        }
        if (feedItem3.tag != null) {
            jsonWriter2.name("tag");
            a.A0(gson, jsonWriter2, feedItem3.tag);
        }
        if (feedItem3.type != null) {
            jsonWriter2.name("type");
            jsonWriter2.value(feedItem3.type);
        }
        if (feedItem3.category != null) {
            jsonWriter2.name("category");
            a.Z(gson, jsonWriter2, feedItem3.category);
        }
        if (feedItem3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, feedItem3.metadata);
        }
        if (feedItem3.user != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, feedItem3.user);
        }
        if (feedItem3.group != null) {
            jsonWriter2.name("group");
            a.l0(gson, jsonWriter2, feedItem3.group);
        }
        if (feedItem3.clip != null) {
            jsonWriter2.name("clip");
            a.F0(gson, jsonWriter2, feedItem3.clip);
        }
        jsonWriter2.endObject();
    }

    public static Email k(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Email obj3 = new Email();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("email") == null) {
            } else {
            }
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj3.email = jsonReader2.nextString();
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj3;
    }

    public static void k0(Gson gson, JsonWriter jsonWriter2, FeedList feedList3) {
        ArrayList data2;
        Paging paging;
        ArrayList data;
        jsonWriter2.beginObject();
        if (feedList3 == null) {
        }
        if (feedList3.data != null) {
            jsonWriter2.name("data");
            a.X0(gson, jsonWriter2, FeedItem.class, feedList3.data);
        }
        jsonWriter2.name("page");
        jsonWriter2.value((long)page);
        if (feedList3.paging != null) {
            jsonWriter2.name("paging");
            a.p0(gson, jsonWriter2, feedList3.paging);
        }
        jsonWriter2.name("per_page");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("total");
        jsonWriter2.value((long)obj2);
        jsonWriter2.endObject();
    }

    public static Embed l(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Embed obj3 = new Embed();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("html") == null) {
            } else {
            }
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj3.html = jsonReader2.nextString();
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj3;
    }

    public static void l0(Gson gson, JsonWriter jsonWriter2, Group group3) {
        String uri;
        Metadata metadata;
        Privacy privacy;
        java.util.Date createdTime2;
        String link;
        User user;
        String groupDescription;
        PictureCollection pictureCollection;
        java.util.Date createdTime;
        String obj2;
        jsonWriter2.beginObject();
        if (group3 == null) {
        }
        if (group3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(group3.uri);
        }
        if (group3.metadata != null) {
            jsonWriter2.name("metadata");
            a.o0(gson, jsonWriter2, group3.metadata);
        }
        if (group3.privacy != null) {
            jsonWriter2.name("privacy");
            a.v0(gson, jsonWriter2, group3.privacy);
        }
        if (group3.createdTime != null) {
            jsonWriter2.name("created_time");
            Stag.d(gson, Date.class, jsonWriter2, group3.createdTime);
        }
        if (group3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(group3.link);
        }
        if (group3.user != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, group3.user);
        }
        if (group3.groupDescription != null) {
            jsonWriter2.name("group_description");
            jsonWriter2.value(group3.groupDescription);
        }
        if (group3.pictureCollection != null) {
            jsonWriter2.name("picture_collection");
            a.r0(gson, jsonWriter2, group3.pictureCollection);
        }
        if (group3.name != null) {
            jsonWriter2.name("name");
            jsonWriter2.value(group3.name);
        }
        jsonWriter2.endObject();
    }

    public static FacetOption m(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        FacetOption obj4 = new FacetOption();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mTotal = jsonReader2.nextInt();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mText = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mName = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("text")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void m0(Gson gson, JsonWriter jsonWriter2, Interaction interaction3) {
        String uri;
        java.util.Date addedTime;
        java.util.Date expiration;
        com.vimeo.networking.model.Interaction.Stream stream;
        java.util.Date addedTime2;
        jsonWriter2.beginObject();
        if (interaction3 == null) {
        }
        if (interaction3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(interaction3.uri);
        }
        if (interaction3.addedTime != null) {
            jsonWriter2.name("added_time");
            Stag.d(gson, Date.class, jsonWriter2, interaction3.addedTime);
        }
        if (interaction3.expiration != null) {
            jsonWriter2.name("expires_time");
            Stag.d(gson, Date.class, jsonWriter2, interaction3.expiration);
        }
        if (interaction3.stream != null) {
            jsonWriter2.name("stream");
            Stag.d(gson, Interaction.Stream.class, jsonWriter2, interaction3.stream);
        }
        jsonWriter2.name("added");
        jsonWriter2.value(interaction3.added);
        jsonWriter2.endObject();
    }

    public static FeedItem n(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Gson nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        FeedItem feedItem = new FeedItem();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            feedItem.channel = a.d(gson, jsonReader2);
            feedItem.group = a.p(gson, jsonReader2);
            feedItem.category = a.b(gson, jsonReader2);
            feedItem.user = a.N(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            feedItem.type = jsonReader2.nextString();
            feedItem.time = (Date)Stag.a(gson, Date.class, jsonReader2);
            feedItem.clip = a.Q(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            feedItem.uri = jsonReader2.nextString();
            feedItem.tag = a.L(gson, jsonReader2);
            feedItem.metadata = a.s(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("channel")) {
            } else {
            }
            nULL = 9;
            if (!bEGIN_OBJECT.equals("group")) {
            } else {
            }
            nULL = 8;
            if (!bEGIN_OBJECT.equals("category")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("type")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("time")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("clip")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("tag")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return feedItem;
    }

    public static void n0(Gson gson, JsonWriter jsonWriter2, InteractionCollection interactionCollection3) {
        Interaction like;
        Interaction subscribe;
        Interaction follow;
        Interaction buy;
        Interaction rent;
        Object watchlater;
        Object obj3;
        jsonWriter2.beginObject();
        if (interactionCollection3 == null) {
        }
        if (interactionCollection3.like != null) {
            jsonWriter2.name("like");
            a.m0(gson, jsonWriter2, interactionCollection3.like);
        }
        if (interactionCollection3.subscribe != null) {
            jsonWriter2.name("subscribe");
            a.m0(gson, jsonWriter2, interactionCollection3.subscribe);
        }
        if (interactionCollection3.follow != null) {
            jsonWriter2.name("follow");
            a.m0(gson, jsonWriter2, interactionCollection3.follow);
        }
        if (interactionCollection3.buy != null) {
            jsonWriter2.name("buy");
            a.m0(gson, jsonWriter2, interactionCollection3.buy);
        }
        if (interactionCollection3.rent != null) {
            jsonWriter2.name("rent");
            a.m0(gson, jsonWriter2, interactionCollection3.rent);
        }
        if (interactionCollection3.watchlater != null) {
            jsonWriter2.name("watchlater");
            a.m0(gson, jsonWriter2, interactionCollection3.watchlater);
        }
        jsonWriter2.endObject();
    }

    public static FeedList o(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        FeedList feedList = new FeedList();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            feedList.perPage = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            feedList.total = jsonReader2.nextInt();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            feedList.page = jsonReader2.nextInt();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            feedList.data = a.a(gson, jsonReader2, FeedItem.class);
            feedList.paging = a.t(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("per_page")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("total")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("page")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("data")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("paging")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return feedList;
    }

    public static void o0(Gson gson, JsonWriter jsonWriter2, Metadata metadata3) {
        ConnectionCollection connections;
        Object interactions;
        Object obj3;
        jsonWriter2.beginObject();
        if (metadata3 == null) {
        }
        if (metadata3.connections != null) {
            jsonWriter2.name("connections");
            a.g0(gson, jsonWriter2, metadata3.connections);
        }
        if (metadata3.interactions != null) {
            jsonWriter2.name("interactions");
            a.n0(gson, jsonWriter2, metadata3.interactions);
        }
        jsonWriter2.endObject();
    }

    public static Group p(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        long nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Group group = new Group();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            group.createdTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            group.pictureCollection = a.v(gson, jsonReader2);
            group.user = a.N(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            group.name = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            group.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            group.uri = jsonReader2.nextString();
            group.privacy = a.B(gson, jsonReader2);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            group.groupDescription = jsonReader2.nextString();
            group.metadata = a.s(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("created_time")) {
            } else {
            }
            nULL = 8;
            if (!bEGIN_OBJECT.equals("picture_collection")) {
            } else {
            }
            nULL = 7;
            if (!bEGIN_OBJECT.equals("user")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("name")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("privacy")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("group_description")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("metadata")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return group;
    }

    public static void p0(Gson gson, JsonWriter jsonWriter2, Paging paging3) {
        String obj0;
        jsonWriter2.beginObject();
        if (paging3 == null) {
        }
        if (paging3.next != null) {
            jsonWriter2.name("next");
            jsonWriter2.value(paging3.next);
        }
        if (paging3.last != null) {
            jsonWriter2.name("last");
            jsonWriter2.value(paging3.last);
        }
        if (paging3.previous != null) {
            jsonWriter2.name("previous");
            jsonWriter2.value(paging3.previous);
        }
        if (paging3.first != null) {
            jsonWriter2.name("first");
            jsonWriter2.value(paging3.first);
        }
        jsonWriter2.endObject();
    }

    public static Interaction q(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Interaction interaction = new Interaction();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            interaction.expiration = (Date)Stag.a(gson, Date.class, jsonReader2);
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            interaction.added = jsonReader2.nextBoolean();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            interaction.uri = jsonReader2.nextString();
            interaction.stream = (Interaction.Stream)Stag.a(gson, Interaction.Stream.class, jsonReader2);
            interaction.addedTime = (Date)Stag.a(gson, Date.class, jsonReader2);
            if (!bEGIN_OBJECT.equals("expires_time")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("added")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("stream")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("added_time")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return interaction;
    }

    public static void q0(Gson gson, JsonWriter jsonWriter2, Picture picture3) {
        String obj2;
        jsonWriter2.beginObject();
        if (picture3 == null) {
        }
        jsonWriter2.name("width");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("height");
        jsonWriter2.value((long)obj2);
        if (picture3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(picture3.link);
        }
        if (picture3.linkWithPlayButton != null) {
            jsonWriter2.name("link_with_play_button");
            jsonWriter2.value(picture3.linkWithPlayButton);
        }
        jsonWriter2.endObject();
    }

    public static InteractionCollection r(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        InteractionCollection interactionCollection = new InteractionCollection();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            peek = -1;
            jsonReader2.skipValue();
            interactionCollection.subscribe = a.q(gson, jsonReader2);
            interactionCollection.rent = a.q(gson, jsonReader2);
            interactionCollection.like = a.q(gson, jsonReader2);
            interactionCollection.buy = a.q(gson, jsonReader2);
            interactionCollection.watchlater = a.q(gson, jsonReader2);
            interactionCollection.follow = a.q(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("subscribe")) {
            } else {
            }
            peek = 5;
            if (!bEGIN_OBJECT.equals("rent")) {
            } else {
            }
            peek = 4;
            if (!bEGIN_OBJECT.equals("like")) {
            } else {
            }
            peek = 3;
            if (!bEGIN_OBJECT.equals("buy")) {
            } else {
            }
            peek = 2;
            if (!bEGIN_OBJECT.equals("watchlater")) {
            } else {
            }
            peek = 1;
            if (!bEGIN_OBJECT.equals("follow")) {
            } else {
            }
            peek = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return interactionCollection;
    }

    public static void r0(Gson gson, JsonWriter jsonWriter2, PictureCollection pictureCollection3) {
        String uri;
        ArrayList sizes;
        Object obj3;
        jsonWriter2.beginObject();
        if (pictureCollection3 == null) {
        }
        jsonWriter2.name("active");
        jsonWriter2.value(pictureCollection3.active);
        jsonWriter2.name("default");
        jsonWriter2.value(pictureCollection3.isDefault);
        if (pictureCollection3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(pictureCollection3.uri);
        }
        if (pictureCollection3.sizes != null) {
            jsonWriter2.name("sizes");
            a.X0(gson, jsonWriter2, Picture.class, pictureCollection3.sizes);
        }
        jsonWriter2.endObject();
    }

    public static Metadata s(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int equals;
        JsonToken nULL;
        equals = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return equals;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return equals;
        }
        jsonReader2.beginObject();
        Metadata metadata = new Metadata();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            if (jsonReader2.peek() == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("interactions") == 0) {
            } else {
            }
            metadata.interactions = a.r(gson, jsonReader2);
            if (bEGIN_OBJECT.equals("connections") == null) {
            } else {
            }
            metadata.connections = a.i(gson, jsonReader2);
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return metadata;
    }

    public static void s0(Gson gson, JsonWriter jsonWriter2, PictureResource pictureResource3) {
        String obj0;
        jsonWriter2.beginObject();
        if (pictureResource3 == null) {
        }
        jsonWriter2.name("active");
        jsonWriter2.value(pictureResource3.active);
        if (pictureResource3.uri != null) {
            jsonWriter2.name("uri");
            jsonWriter2.value(pictureResource3.uri);
        }
        if (pictureResource3.link != null) {
            jsonWriter2.name("link");
            jsonWriter2.value(pictureResource3.link);
        }
        jsonWriter2.endObject();
    }

    public static Paging t(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Paging obj4 = new Paging();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.first = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.next = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.last = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.previous = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("first")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("next")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("last")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("previous")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void t0(Gson gson, JsonWriter jsonWriter2, PinCodeInfo pinCodeInfo3) {
        String obj2;
        jsonWriter2.beginObject();
        if (pinCodeInfo3 == null) {
        }
        if (pinCodeInfo3.mActivateLink != null) {
            jsonWriter2.name("activate_link");
            jsonWriter2.value(pinCodeInfo3.mActivateLink);
        }
        if (pinCodeInfo3.mDeviceCode != null) {
            jsonWriter2.name("device_code");
            jsonWriter2.value(pinCodeInfo3.mDeviceCode);
        }
        jsonWriter2.name("expires_in");
        jsonWriter2.value((long)obj2);
        jsonWriter2.name("interval");
        jsonWriter2.value((long)obj2);
        if (pinCodeInfo3.mAuthorizeLink != null) {
            jsonWriter2.name("authorize_link");
            jsonWriter2.value(pinCodeInfo3.mAuthorizeLink);
        }
        if (pinCodeInfo3.mUserCode != null) {
            jsonWriter2.name("user_code");
            jsonWriter2.value(pinCodeInfo3.mUserCode);
        }
        jsonWriter2.endObject();
    }

    public static Picture u(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Picture obj4 = new Picture();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.linkWithPlayButton = jsonReader2.nextString();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.width = jsonReader2.nextInt();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.link = jsonReader2.nextString();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.height = jsonReader2.nextInt();
            if (!bEGIN_OBJECT.equals("link_with_play_button")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("width")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("height")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void u0(Gson gson, JsonWriter jsonWriter2, Preferences preferences3) {
        Object videos;
        Object obj3;
        jsonWriter2.beginObject();
        if (preferences3 == null) {
        }
        if (preferences3.videos != null) {
            jsonWriter2.name("videos");
            a.I0(gson, jsonWriter2, preferences3.videos);
        }
        jsonWriter2.endObject();
    }

    public static PictureCollection v(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str2;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        PictureCollection pictureCollection = new PictureCollection();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            pictureCollection.isDefault = jsonReader2.nextBoolean();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            pictureCollection.sizes = a.a(gson, jsonReader2, Picture.class);
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            pictureCollection.uri = jsonReader2.nextString();
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            pictureCollection.active = jsonReader2.nextBoolean();
            if (!bEGIN_OBJECT.equals("default")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("sizes")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("active")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return pictureCollection;
    }

    public static void v0(Gson gson, JsonWriter jsonWriter2, Privacy privacy3) {
        String embed;
        com.vimeo.networking.model.Privacy.PrivacyValue view;
        Object comments;
        Object obj4;
        final Class<com.vimeo.networking.model.Privacy.PrivacyValue> obj = Privacy.PrivacyValue.class;
        jsonWriter2.beginObject();
        if (privacy3 == null) {
        }
        jsonWriter2.name("download");
        jsonWriter2.value(privacy3.download);
        jsonWriter2.name("add");
        jsonWriter2.value(privacy3.add);
        if (privacy3.embed != null) {
            jsonWriter2.name("embed");
            jsonWriter2.value(privacy3.embed);
        }
        if (privacy3.view != null) {
            jsonWriter2.name("view");
            Stag.d(gson, obj, jsonWriter2, privacy3.view);
        }
        if (privacy3.comments != null) {
            jsonWriter2.name("comments");
            Stag.d(gson, obj, jsonWriter2, privacy3.comments);
        }
        jsonWriter2.endObject();
    }

    public static PictureResource w(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        int str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        PictureResource obj4 = new PictureResource();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.link = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.uri = jsonReader2.nextString();
            if (peek == JsonToken.BOOLEAN) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.active = jsonReader2.nextBoolean();
            if (!bEGIN_OBJECT.equals("link")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("uri")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("active")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void w0(Gson gson, JsonWriter jsonWriter2, Quota quota3) {
        jsonWriter2.beginObject();
        if (quota3 == null) {
        }
        jsonWriter2.name("hd");
        jsonWriter2.value(quota3.hd);
        jsonWriter2.name("sd");
        jsonWriter2.value(quota3.sd);
        jsonWriter2.endObject();
    }

    public static PinCodeInfo x(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        PinCodeInfo obj4 = new PinCodeInfo();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mActivateLink = jsonReader2.nextString();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.interval = jsonReader2.nextInt();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mUserCode = jsonReader2.nextString();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mAuthorizeLink = jsonReader2.nextString();
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.expiresIn = jsonReader2.nextInt();
            if (peek == JsonToken.STRING) {
            } else {
            }
            jsonReader2.skipValue();
            obj4.mDeviceCode = jsonReader2.nextString();
            if (!bEGIN_OBJECT.equals("activate_link")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("interval")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("user_code")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("authorize_link")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("expires_in")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("device_code")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj4;
    }

    public static void x0(Gson gson, JsonWriter jsonWriter2, Recommendation recommendation3) {
        Category mCategory;
        Channel mChannel;
        String mRecommendationType;
        User mUser;
        String obj1;
        jsonWriter2.beginObject();
        if (recommendation3 == null) {
        }
        if (recommendation3.mCategory != null) {
            jsonWriter2.name("category");
            a.Z(gson, jsonWriter2, recommendation3.mCategory);
        }
        if (recommendation3.mChannel != null) {
            jsonWriter2.name("channel");
            a.b0(gson, jsonWriter2, recommendation3.mChannel);
        }
        if (recommendation3.mRecommendationType != null) {
            jsonWriter2.name("type");
            jsonWriter2.value(recommendation3.mRecommendationType);
        }
        if (recommendation3.mUser != null) {
            jsonWriter2.name("user");
            a.C0(gson, jsonWriter2, recommendation3.mUser);
        }
        if (recommendation3.mResourceKey != null) {
            jsonWriter2.name("resource_key");
            jsonWriter2.value(recommendation3.mResourceKey);
        }
        if (recommendation3.mDescription != null) {
            jsonWriter2.name("description");
            jsonWriter2.value(recommendation3.mDescription);
        }
        jsonWriter2.endObject();
    }

    public static Play y(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        int nULL;
        String str;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        Play play = new Play();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            nULL = -1;
            jsonReader2.skipValue();
            if (peek == JsonToken.BEGIN_ARRAY) {
            } else {
            }
            jsonReader2.skipValue();
            play.mProgressive = a.a(gson, jsonReader2, VideoFile.class);
            play.mEmbed = (Embed)Stag.a(gson, Embed.class, jsonReader2);
            play.mDash = a.R(gson, jsonReader2);
            play.mHls = a.R(gson, jsonReader2);
            play.mDrm = a.j(gson, jsonReader2);
            play.mStatus = (Play.Status)Stag.a(gson, Play.Status.class, jsonReader2);
            play.mProgress = a.z(gson, jsonReader2);
            if (!bEGIN_OBJECT.equals("progressive")) {
            } else {
            }
            nULL = 6;
            if (!bEGIN_OBJECT.equals("embed")) {
            } else {
            }
            nULL = 5;
            if (!bEGIN_OBJECT.equals("dash")) {
            } else {
            }
            nULL = 4;
            if (!bEGIN_OBJECT.equals("hls")) {
            } else {
            }
            nULL = 3;
            if (!bEGIN_OBJECT.equals("drm")) {
            } else {
            }
            nULL = 2;
            if (!bEGIN_OBJECT.equals("status")) {
            } else {
            }
            nULL = 1;
            if (!bEGIN_OBJECT.equals("progress")) {
            } else {
            }
            nULL = 0;
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return play;
    }

    public static void y0(Gson gson, JsonWriter jsonWriter2, Space space3) {
        jsonWriter2.beginObject();
        if (space3 == null) {
        }
        jsonWriter2.name("used");
        jsonWriter2.value(space3.used);
        jsonWriter2.name("free");
        jsonWriter2.value(space3.free);
        jsonWriter2.name("max");
        jsonWriter2.value(space3.max);
        jsonWriter2.endObject();
    }

    public static PlayProgress z(Gson gson, JsonReader jsonReader2) {
        JsonToken bEGIN_OBJECT;
        int peek;
        Object nULL;
        peek = 0;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            return peek;
        }
        if (jsonReader2.peek() != JsonToken.BEGIN_OBJECT) {
            jsonReader2.skipValue();
            return peek;
        }
        jsonReader2.beginObject();
        PlayProgress obj3 = new PlayProgress();
        while (jsonReader2.hasNext()) {
            bEGIN_OBJECT = jsonReader2.nextName();
            peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
            } else {
            }
            bEGIN_OBJECT.hashCode();
            if (bEGIN_OBJECT.equals("seconds") == null) {
            } else {
            }
            if (peek == JsonToken.NUMBER) {
            } else {
            }
            jsonReader2.skipValue();
            obj3.mSeconds = jsonReader2.nextInt();
            jsonReader2.skipValue();
            jsonReader2.skipValue();
        }
        jsonReader2.endObject();
        return obj3;
    }

    public static void z0(Gson gson, JsonWriter jsonWriter2, StatsCollection statsCollection3) {
        Integer plays;
        Object obj3;
        jsonWriter2.beginObject();
        if (statsCollection3 == null) {
        }
        if (statsCollection3.plays != null) {
            jsonWriter2.name("plays");
            Stag.d(gson, Integer.class, jsonWriter2, statsCollection3.plays);
        }
        jsonWriter2.endObject();
    }
}
