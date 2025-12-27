package com.vimeo.stag.generated;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
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
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Stag.java */
/* loaded from: classes2.dex */
public final class Stag {

    public static class Factory implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == Connection.class) {
                return new Stag.g(gson);
            }
            if (rawType == VideoList.class) {
                return new Stag.r0(gson);
            }
            if (rawType == User.class) {
                return new Stag.m0(gson);
            }
            if (rawType == SearchFacetCollection.class) {
                return new Stag.f0(gson);
            }
            if (rawType == InteractionCollection.class) {
                return new Stag.q(gson);
            }
            if (rawType == Email.class) {
                return new Stag.j(gson);
            }
            if (rawType == PinCodeInfo.class) {
                return new Stag.w(gson);
            }
            if (rawType == Picture.class) {
                return new Stag.t(gson);
            }
            if (rawType == Paging.class) {
                return new Stag.s(gson);
            }
            if (rawType == Quota.class) {
                return new Stag.c0(gson);
            }
            if (rawType == CategoryList.class) {
                return new Stag.b(gson);
            }
            if (rawType == FeedList.class) {
                return new Stag.n(gson);
            }
            if (rawType == Video.class) {
                return new Stag.p0(gson);
            }
            if (rawType == SearchResult.class) {
                return new Stag.h0(gson);
            }
            if (rawType == Embed.class) {
                return new Stag.k(gson);
            }
            if (rawType == Category.class) {
                return new Stag.a(gson);
            }
            if (rawType == Channel.class) {
                return new Stag.c(gson);
            }
            if (rawType == VideoFile.class) {
                return new Stag.q0(gson);
            }
            if (rawType == Interaction.class) {
                return new Stag.p(gson);
            }
            if (rawType == UserList.class) {
                return new Stag.o0(gson);
            }
            if (rawType == Comment.class) {
                return new Stag.e(gson);
            }
            if (rawType == Tag.class) {
                return new Stag.k0(gson);
            }
            if (rawType == UserBadge.class) {
                return new Stag.n0(gson);
            }
            if (rawType == StatsCollection.class) {
                return new Stag.j0(gson);
            }
            if (rawType == Play.class) {
                return new Stag.x(gson);
            }
            if (rawType == Space.class) {
                return new Stag.i0(gson);
            }
            if (rawType == VimeoAccount.class) {
                return new Stag.u0(gson);
            }
            if (rawType == ConnectionCollection.class) {
                return new Stag.h(gson);
            }
            if (rawType == Recommendation.class) {
                return new Stag.d0(gson);
            }
            if (rawType == Website.class) {
                return new Stag.x0(gson);
            }
            if (rawType == Preferences.class) {
                return new Stag.z(gson);
            }
            if (rawType == VideoLog.class) {
                return new Stag.s0(gson);
            }
            if (rawType == UploadQuota.class) {
                return new Stag.l0(gson);
            }
            if (rawType == VodList.class) {
                return new Stag.w0(gson);
            }
            if (rawType == FacetOption.class) {
                return new Stag.l(gson);
            }
            if (rawType == Group.class) {
                return new Stag.o(gson);
            }
            if (rawType == Privacy.class) {
                return new Stag.a0(gson);
            }
            if (rawType == SearchFacet.class) {
                return new Stag.e0(gson);
            }
            if (rawType == SearchResponse.class) {
                return new Stag.g0(gson);
            }
            if (rawType == VodItem.class) {
                return new Stag.v0(gson);
            }
            if (rawType == VideosPreference.class) {
                return new Stag.t0(gson);
            }
            if (rawType == PictureResource.class) {
                return new Stag.v(gson);
            }
            if (rawType == FeedItem.class) {
                return new Stag.m(gson);
            }
            if (rawType == VodItem.Publish.class) {
                return new Stag.b0(gson);
            }
            if (rawType == PlayProgress.class) {
                return new Stag.y(gson);
            }
            if (rawType == ChannelList.class) {
                return new Stag.d(gson);
            }
            if (rawType == PictureCollection.class) {
                return new Stag.u(gson);
            }
            if (rawType == Metadata.class) {
                return new Stag.r(gson);
            }
            if (rawType == Drm.class) {
                return new Stag.i(gson);
            }
            if (rawType == CommentList.class) {
                return new Stag.f(gson);
            }
            return null;
        }
    }

    static class a0 extends TypeAdapter<Privacy> {

        private final Gson a;
        public a0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Privacy a(JsonReader jsonReader) {
            return a.B(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Privacy privacy) {
            a.v0(this.a, jsonWriter, privacy);
        }
    }

    static class a extends TypeAdapter<Category> {

        private final Gson a;
        public a(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Category a(JsonReader jsonReader) {
            return a.b(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Category category) {
            a.Z(this.a, jsonWriter, category);
        }
    }

    static class b0 extends TypeAdapter<VodItem.Publish> {

        private final Gson a;
        public b0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VodItem.Publish a(JsonReader jsonReader) {
            return a.C(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VodItem.Publish publish) {
            a.K0(this.a, jsonWriter, publish);
        }
    }

    static class b extends TypeAdapter<CategoryList> {

        private final Gson a;
        public b(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public CategoryList a(JsonReader jsonReader) {
            return a.c(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, CategoryList list) {
            a.a0(this.a, jsonWriter, list);
        }
    }

    static class c0 extends TypeAdapter<Quota> {

        private final Gson a;
        public c0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Quota a(JsonReader jsonReader) {
            return a.D(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Quota quota) {
            a.w0(this.a, jsonWriter, quota);
        }
    }

    static class c extends TypeAdapter<Channel> {

        private final Gson a;
        public c(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Channel a(JsonReader jsonReader) {
            return a.d(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Channel channel) {
            a.b0(this.a, jsonWriter, channel);
        }
    }

    static class d0 extends TypeAdapter<Recommendation> {

        private final Gson a;
        public d0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Recommendation a(JsonReader jsonReader) {
            return a.E(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Recommendation recommendation) {
            a.x0(this.a, jsonWriter, recommendation);
        }
    }

    static class d extends TypeAdapter<ChannelList> {

        private final Gson a;
        public d(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public ChannelList a(JsonReader jsonReader) {
            return a.e(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, ChannelList list) {
            a.c0(this.a, jsonWriter, list);
        }
    }

    static class e0 extends TypeAdapter<SearchFacet> {

        private final Gson a;
        public e0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public SearchFacet a(JsonReader jsonReader) {
            return a.F(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, SearchFacet searchFacet) {
            a.T0(this.a, jsonWriter, searchFacet);
        }
    }

    static class e extends TypeAdapter<Comment> {

        private final Gson a;
        public e(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Comment a(JsonReader jsonReader) {
            return a.f(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Comment comment) {
            a.d0(this.a, jsonWriter, comment);
        }
    }

    static class f0 extends TypeAdapter<SearchFacetCollection> {

        private final Gson a;
        public f0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public SearchFacetCollection a(JsonReader jsonReader) {
            return a.G(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, SearchFacetCollection list) {
            a.U0(this.a, jsonWriter, list);
        }
    }

    static class f extends TypeAdapter<CommentList> {

        private final Gson a;
        public f(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public CommentList a(JsonReader jsonReader) {
            return a.g(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, CommentList list) {
            a.e0(this.a, jsonWriter, list);
        }
    }

    static class g0 extends TypeAdapter<SearchResponse> {

        private final Gson a;
        public g0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public SearchResponse a(JsonReader jsonReader) {
            return a.H(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, SearchResponse searchResponse) {
            a.V0(this.a, jsonWriter, searchResponse);
        }
    }

    static class g extends TypeAdapter<Connection> {

        private final Gson a;
        public g(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Connection a(JsonReader jsonReader) {
            return a.h(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Connection connection) {
            a.f0(this.a, jsonWriter, connection);
        }
    }

    static class h0 extends TypeAdapter<SearchResult> {

        private final Gson a;
        public h0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public SearchResult a(JsonReader jsonReader) {
            return a.I(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, SearchResult searchResult) {
            a.W0(this.a, jsonWriter, searchResult);
        }
    }

    static class h extends TypeAdapter<ConnectionCollection> {

        private final Gson a;
        public h(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public ConnectionCollection a(JsonReader jsonReader) {
            return a.i(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, ConnectionCollection list) {
            a.g0(this.a, jsonWriter, list);
        }
    }

    static class i0 extends TypeAdapter<Space> {

        private final Gson a;
        public i0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Space a(JsonReader jsonReader) {
            return a.J(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Space space) {
            a.y0(this.a, jsonWriter, space);
        }
    }

    static class i extends TypeAdapter<Drm> {

        private final Gson a;
        public i(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Drm a(JsonReader jsonReader) {
            return a.j(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Drm drm) {
            a.O0(this.a, jsonWriter, drm);
        }
    }

    static class j0 extends TypeAdapter<StatsCollection> {

        private final Gson a;
        public j0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public StatsCollection a(JsonReader jsonReader) {
            return a.K(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, StatsCollection list) {
            a.z0(this.a, jsonWriter, list);
        }
    }

    static class j extends TypeAdapter<Email> {

        private final Gson a;
        public j(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Email a(JsonReader jsonReader) {
            return a.k(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Email email) {
            a.h0(this.a, jsonWriter, email);
        }
    }

    static class k0 extends TypeAdapter<Tag> {

        private final Gson a;
        public k0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Tag a(JsonReader jsonReader) {
            return a.L(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Tag tag) {
            a.A0(this.a, jsonWriter, tag);
        }
    }

    static class k extends TypeAdapter<Embed> {

        private final Gson a;
        public k(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Embed a(JsonReader jsonReader) {
            return a.l(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Embed embed) {
            a.i0(this.a, jsonWriter, embed);
        }
    }

    static class l0 extends TypeAdapter<UploadQuota> {

        private final Gson a;
        public l0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public UploadQuota a(JsonReader jsonReader) {
            return a.M(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, UploadQuota uploadQuota) {
            a.B0(this.a, jsonWriter, uploadQuota);
        }
    }

    static class l extends TypeAdapter<FacetOption> {

        private final Gson a;
        public l(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public FacetOption a(JsonReader jsonReader) {
            return a.m(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, FacetOption facetOption) {
            a.S0(this.a, jsonWriter, facetOption);
        }
    }

    static class m0 extends TypeAdapter<User> {

        private final Gson a;
        public m0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public User a(JsonReader jsonReader) {
            return a.N(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, User user) {
            a.C0(this.a, jsonWriter, user);
        }
    }

    static class m extends TypeAdapter<FeedItem> {

        private final Gson a;
        public m(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public FeedItem a(JsonReader jsonReader) {
            return a.n(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, FeedItem feedItem) {
            a.j0(this.a, jsonWriter, feedItem);
        }
    }

    static class n0 extends TypeAdapter<UserBadge> {

        private final Gson a;
        public n0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public UserBadge a(JsonReader jsonReader) {
            return a.O(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, UserBadge userBadge) {
            a.D0(this.a, jsonWriter, userBadge);
        }
    }

    static class n extends TypeAdapter<FeedList> {

        private final Gson a;
        public n(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public FeedList a(JsonReader jsonReader) {
            return a.o(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, FeedList list) {
            a.k0(this.a, jsonWriter, list);
        }
    }

    static class o0 extends TypeAdapter<UserList> {

        private final Gson a;
        public o0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public UserList a(JsonReader jsonReader) {
            return a.P(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, UserList list) {
            a.E0(this.a, jsonWriter, list);
        }
    }

    static class o extends TypeAdapter<Group> {

        private final Gson a;
        public o(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Group a(JsonReader jsonReader) {
            return a.p(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Group group) {
            a.l0(this.a, jsonWriter, group);
        }
    }

    static class p0 extends TypeAdapter<Video> {

        private final Gson a;
        public p0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Video a(JsonReader jsonReader) {
            return a.Q(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Video video) {
            a.F0(this.a, jsonWriter, video);
        }
    }

    static class p extends TypeAdapter<Interaction> {

        private final Gson a;
        public p(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Interaction a(JsonReader jsonReader) {
            return a.q(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Interaction interaction) {
            a.m0(this.a, jsonWriter, interaction);
        }
    }

    static class q0 extends TypeAdapter<VideoFile> {

        private final Gson a;
        public q0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VideoFile a(JsonReader jsonReader) {
            return a.R(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VideoFile videoFile) {
            a.G0(this.a, jsonWriter, videoFile);
        }
    }

    static class q extends TypeAdapter<InteractionCollection> {

        private final Gson a;
        public q(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public InteractionCollection a(JsonReader jsonReader) {
            return a.r(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, InteractionCollection list) {
            a.n0(this.a, jsonWriter, list);
        }
    }

    static class r0 extends TypeAdapter<VideoList> {

        private final Gson a;
        public r0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VideoList a(JsonReader jsonReader) {
            return a.S(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VideoList list) {
            a.H0(this.a, jsonWriter, list);
        }
    }

    static class r extends TypeAdapter<Metadata> {

        private final Gson a;
        public r(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Metadata a(JsonReader jsonReader) {
            return a.s(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Metadata metadata) {
            a.o0(this.a, jsonWriter, metadata);
        }
    }

    static class s0 extends TypeAdapter<VideoLog> {

        private final Gson a;
        public s0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VideoLog a(JsonReader jsonReader) {
            return a.T(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VideoLog videoLog) {
            a.R0(this.a, jsonWriter, videoLog);
        }
    }

    static class s extends TypeAdapter<Paging> {

        private final Gson a;
        public s(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Paging a(JsonReader jsonReader) {
            return a.t(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Paging paging) {
            a.p0(this.a, jsonWriter, paging);
        }
    }

    static class t0 extends TypeAdapter<VideosPreference> {

        private final Gson a;
        public t0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VideosPreference a(JsonReader jsonReader) {
            return a.U(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VideosPreference videosPreference) {
            a.I0(this.a, jsonWriter, videosPreference);
        }
    }

    static class t extends TypeAdapter<Picture> {

        private final Gson a;
        public t(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Picture a(JsonReader jsonReader) {
            return a.u(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Picture picture) {
            a.q0(this.a, jsonWriter, picture);
        }
    }

    static class u0 extends TypeAdapter<VimeoAccount> {

        private final Gson a;
        public u0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VimeoAccount a(JsonReader jsonReader) {
            return a.V(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VimeoAccount vimeoAccount) {
            a.J0(this.a, jsonWriter, vimeoAccount);
        }
    }

    static class u extends TypeAdapter<PictureCollection> {

        private final Gson a;
        public u(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public PictureCollection a(JsonReader jsonReader) {
            return a.v(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, PictureCollection list) {
            a.r0(this.a, jsonWriter, list);
        }
    }

    static class v0 extends TypeAdapter<VodItem> {

        private final Gson a;
        public v0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VodItem a(JsonReader jsonReader) {
            return a.W(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VodItem vodItem) {
            a.L0(this.a, jsonWriter, vodItem);
        }
    }

    static class v extends TypeAdapter<PictureResource> {

        private final Gson a;
        public v(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public PictureResource a(JsonReader jsonReader) {
            return a.w(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, PictureResource pictureResource) {
            a.s0(this.a, jsonWriter, pictureResource);
        }
    }

    static class w0 extends TypeAdapter<VodList> {

        private final Gson a;
        public w0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public VodList a(JsonReader jsonReader) {
            return a.X(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, VodList list) {
            a.M0(this.a, jsonWriter, list);
        }
    }

    static class w extends TypeAdapter<PinCodeInfo> {

        private final Gson a;
        public w(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public PinCodeInfo a(JsonReader jsonReader) {
            return a.x(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, PinCodeInfo pinCodeInfo) {
            a.t0(this.a, jsonWriter, pinCodeInfo);
        }
    }

    static class x0 extends TypeAdapter<Website> {

        private final Gson a;
        public x0(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Website a(JsonReader jsonReader) {
            return a.Y(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Website website) {
            a.N0(this.a, jsonWriter, website);
        }
    }

    static class x extends TypeAdapter<Play> {

        private final Gson a;
        public x(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Play a(JsonReader jsonReader) {
            return a.y(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Play play) {
            a.P0(this.a, jsonWriter, play);
        }
    }

    static class y extends TypeAdapter<PlayProgress> {

        private final Gson a;
        public y(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public PlayProgress a(JsonReader jsonReader) {
            return a.z(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, PlayProgress playProgress) {
            a.Q0(this.a, jsonWriter, playProgress);
        }
    }

    static class z extends TypeAdapter<Preferences> {

        private final Gson a;
        public z(Gson gson) {
            super();
            this.a = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public Preferences a(JsonReader jsonReader) {
            return a.A(this.a, jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void b(JsonWriter jsonWriter, Preferences preferences) {
            a.u0(this.a, jsonWriter, preferences);
        }
    }
    static <T> T a(Gson gson, Class<T> cls, JsonReader jsonReader) {
        return gson.getAdapter(cls).read(jsonReader);
    }

    static <T> ArrayList<T> b(Gson gson, Class<T> cls, JsonReader jsonReader) {
        final ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            arrayList.add(gson.getAdapter(cls).read(jsonReader));
        }
        return arrayList;
    }

    static <T> void c(Gson gson, Class<T> cls, JsonWriter jsonWriter, ArrayList<T> arrayList) {
        final Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            gson.getAdapter(cls).write(jsonWriter, it.next());
        }
    }

    static <T> void d(Gson gson, Class<T> cls, JsonWriter jsonWriter, T t) {
        gson.getAdapter(cls).write(jsonWriter, t);
    }
}
