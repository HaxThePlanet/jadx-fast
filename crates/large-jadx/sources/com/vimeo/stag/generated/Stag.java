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

/* loaded from: classes2.dex */
public final class Stag {

    public static class Factory implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
            Class obj3 = typeToken2.getRawType();
            if (obj3 == Connection.class) {
                obj3 = new Stag.g(gson);
                return obj3;
            }
            if (obj3 == VideoList.class) {
                obj3 = new Stag.r0(gson);
                return obj3;
            }
            if (obj3 == User.class) {
                obj3 = new Stag.m0(gson);
                return obj3;
            }
            if (obj3 == SearchFacetCollection.class) {
                obj3 = new Stag.f0(gson);
                return obj3;
            }
            if (obj3 == InteractionCollection.class) {
                obj3 = new Stag.q(gson);
                return obj3;
            }
            if (obj3 == Email.class) {
                obj3 = new Stag.j(gson);
                return obj3;
            }
            if (obj3 == PinCodeInfo.class) {
                obj3 = new Stag.w(gson);
                return obj3;
            }
            if (obj3 == Picture.class) {
                obj3 = new Stag.t(gson);
                return obj3;
            }
            if (obj3 == Paging.class) {
                obj3 = new Stag.s(gson);
                return obj3;
            }
            if (obj3 == Quota.class) {
                obj3 = new Stag.c0(gson);
                return obj3;
            }
            if (obj3 == CategoryList.class) {
                obj3 = new Stag.b(gson);
                return obj3;
            }
            if (obj3 == FeedList.class) {
                obj3 = new Stag.n(gson);
                return obj3;
            }
            if (obj3 == Video.class) {
                obj3 = new Stag.p0(gson);
                return obj3;
            }
            if (obj3 == SearchResult.class) {
                obj3 = new Stag.h0(gson);
                return obj3;
            }
            if (obj3 == Embed.class) {
                obj3 = new Stag.k(gson);
                return obj3;
            }
            if (obj3 == Category.class) {
                obj3 = new Stag.a(gson);
                return obj3;
            }
            if (obj3 == Channel.class) {
                obj3 = new Stag.c(gson);
                return obj3;
            }
            if (obj3 == VideoFile.class) {
                obj3 = new Stag.q0(gson);
                return obj3;
            }
            if (obj3 == Interaction.class) {
                obj3 = new Stag.p(gson);
                return obj3;
            }
            if (obj3 == UserList.class) {
                obj3 = new Stag.o0(gson);
                return obj3;
            }
            if (obj3 == Comment.class) {
                obj3 = new Stag.e(gson);
                return obj3;
            }
            if (obj3 == Tag.class) {
                obj3 = new Stag.k0(gson);
                return obj3;
            }
            if (obj3 == UserBadge.class) {
                obj3 = new Stag.n0(gson);
                return obj3;
            }
            if (obj3 == StatsCollection.class) {
                obj3 = new Stag.j0(gson);
                return obj3;
            }
            if (obj3 == Play.class) {
                obj3 = new Stag.x(gson);
                return obj3;
            }
            if (obj3 == Space.class) {
                obj3 = new Stag.i0(gson);
                return obj3;
            }
            if (obj3 == VimeoAccount.class) {
                obj3 = new Stag.u0(gson);
                return obj3;
            }
            if (obj3 == ConnectionCollection.class) {
                obj3 = new Stag.h(gson);
                return obj3;
            }
            if (obj3 == Recommendation.class) {
                obj3 = new Stag.d0(gson);
                return obj3;
            }
            if (obj3 == Website.class) {
                obj3 = new Stag.x0(gson);
                return obj3;
            }
            if (obj3 == Preferences.class) {
                obj3 = new Stag.z(gson);
                return obj3;
            }
            if (obj3 == VideoLog.class) {
                obj3 = new Stag.s0(gson);
                return obj3;
            }
            if (obj3 == UploadQuota.class) {
                obj3 = new Stag.l0(gson);
                return obj3;
            }
            if (obj3 == VodList.class) {
                obj3 = new Stag.w0(gson);
                return obj3;
            }
            if (obj3 == FacetOption.class) {
                obj3 = new Stag.l(gson);
                return obj3;
            }
            if (obj3 == Group.class) {
                obj3 = new Stag.o(gson);
                return obj3;
            }
            if (obj3 == Privacy.class) {
                obj3 = new Stag.a0(gson);
                return obj3;
            }
            if (obj3 == SearchFacet.class) {
                obj3 = new Stag.e0(gson);
                return obj3;
            }
            if (obj3 == SearchResponse.class) {
                obj3 = new Stag.g0(gson);
                return obj3;
            }
            if (obj3 == VodItem.class) {
                obj3 = new Stag.v0(gson);
                return obj3;
            }
            if (obj3 == VideosPreference.class) {
                obj3 = new Stag.t0(gson);
                return obj3;
            }
            if (obj3 == PictureResource.class) {
                obj3 = new Stag.v(gson);
                return obj3;
            }
            if (obj3 == FeedItem.class) {
                obj3 = new Stag.m(gson);
                return obj3;
            }
            if (obj3 == VodItem.Publish.class) {
                obj3 = new Stag.b0(gson);
                return obj3;
            }
            if (obj3 == PlayProgress.class) {
                obj3 = new Stag.y(gson);
                return obj3;
            }
            if (obj3 == ChannelList.class) {
                obj3 = new Stag.d(gson);
                return obj3;
            }
            if (obj3 == PictureCollection.class) {
                obj3 = new Stag.u(gson);
                return obj3;
            }
            if (obj3 == Metadata.class) {
                obj3 = new Stag.r(gson);
                return obj3;
            }
            if (obj3 == Drm.class) {
                obj3 = new Stag.i(gson);
                return obj3;
            }
            if (obj3 == CommentList.class) {
                obj3 = new Stag.f(gson);
                return obj3;
            }
            return 0;
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
        public void b(JsonWriter jsonWriter, Privacy privacy2) {
            a.v0(this.a, jsonWriter, privacy2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Privacy)object2);
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
        public void b(JsonWriter jsonWriter, Category category2) {
            a.Z(this.a, jsonWriter, category2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Category)object2);
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
        public void b(JsonWriter jsonWriter, VodItem.Publish vodItem$Publish2) {
            a.K0(this.a, jsonWriter, publish2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VodItem.Publish)object2);
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
        public void b(JsonWriter jsonWriter, CategoryList categoryList2) {
            a.a0(this.a, jsonWriter, categoryList2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (CategoryList)object2);
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
        public void b(JsonWriter jsonWriter, Quota quota2) {
            a.w0(this.a, jsonWriter, quota2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Quota)object2);
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
        public void b(JsonWriter jsonWriter, Channel channel2) {
            a.b0(this.a, jsonWriter, channel2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Channel)object2);
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
        public void b(JsonWriter jsonWriter, Recommendation recommendation2) {
            a.x0(this.a, jsonWriter, recommendation2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Recommendation)object2);
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
        public void b(JsonWriter jsonWriter, ChannelList channelList2) {
            a.c0(this.a, jsonWriter, channelList2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (ChannelList)object2);
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
        public void b(JsonWriter jsonWriter, SearchFacet searchFacet2) {
            a.T0(this.a, jsonWriter, searchFacet2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (SearchFacet)object2);
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
        public void b(JsonWriter jsonWriter, Comment comment2) {
            a.d0(this.a, jsonWriter, comment2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Comment)object2);
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
        public void b(JsonWriter jsonWriter, SearchFacetCollection searchFacetCollection2) {
            a.U0(this.a, jsonWriter, searchFacetCollection2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (SearchFacetCollection)object2);
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
        public void b(JsonWriter jsonWriter, CommentList commentList2) {
            a.e0(this.a, jsonWriter, commentList2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (CommentList)object2);
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
        public void b(JsonWriter jsonWriter, SearchResponse searchResponse2) {
            a.V0(this.a, jsonWriter, searchResponse2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (SearchResponse)object2);
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
        public void b(JsonWriter jsonWriter, Connection connection2) {
            a.f0(this.a, jsonWriter, connection2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Connection)object2);
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
        public void b(JsonWriter jsonWriter, SearchResult searchResult2) {
            a.W0(this.a, jsonWriter, searchResult2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (SearchResult)object2);
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
        public void b(JsonWriter jsonWriter, ConnectionCollection connectionCollection2) {
            a.g0(this.a, jsonWriter, connectionCollection2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (ConnectionCollection)object2);
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
        public void b(JsonWriter jsonWriter, Space space2) {
            a.y0(this.a, jsonWriter, space2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Space)object2);
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
        public void b(JsonWriter jsonWriter, Drm drm2) {
            a.O0(this.a, jsonWriter, drm2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Drm)object2);
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
        public void b(JsonWriter jsonWriter, StatsCollection statsCollection2) {
            a.z0(this.a, jsonWriter, statsCollection2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (StatsCollection)object2);
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
        public void b(JsonWriter jsonWriter, Email email2) {
            a.h0(this.a, jsonWriter, email2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Email)object2);
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
        public void b(JsonWriter jsonWriter, Tag tag2) {
            a.A0(this.a, jsonWriter, tag2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Tag)object2);
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
        public void b(JsonWriter jsonWriter, Embed embed2) {
            a.i0(this.a, jsonWriter, embed2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Embed)object2);
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
        public void b(JsonWriter jsonWriter, UploadQuota uploadQuota2) {
            a.B0(this.a, jsonWriter, uploadQuota2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (UploadQuota)object2);
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
        public void b(JsonWriter jsonWriter, FacetOption facetOption2) {
            a.S0(this.a, jsonWriter, facetOption2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (FacetOption)object2);
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
        public void b(JsonWriter jsonWriter, User user2) {
            a.C0(this.a, jsonWriter, user2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (User)object2);
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
        public void b(JsonWriter jsonWriter, FeedItem feedItem2) {
            a.j0(this.a, jsonWriter, feedItem2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (FeedItem)object2);
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
        public void b(JsonWriter jsonWriter, UserBadge userBadge2) {
            a.D0(this.a, jsonWriter, userBadge2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (UserBadge)object2);
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
        public void b(JsonWriter jsonWriter, FeedList feedList2) {
            a.k0(this.a, jsonWriter, feedList2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (FeedList)object2);
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
        public void b(JsonWriter jsonWriter, UserList userList2) {
            a.E0(this.a, jsonWriter, userList2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (UserList)object2);
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
        public void b(JsonWriter jsonWriter, Group group2) {
            a.l0(this.a, jsonWriter, group2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Group)object2);
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
        public void b(JsonWriter jsonWriter, Video video2) {
            a.F0(this.a, jsonWriter, video2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Video)object2);
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
        public void b(JsonWriter jsonWriter, Interaction interaction2) {
            a.m0(this.a, jsonWriter, interaction2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Interaction)object2);
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
        public void b(JsonWriter jsonWriter, VideoFile videoFile2) {
            a.G0(this.a, jsonWriter, videoFile2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VideoFile)object2);
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
        public void b(JsonWriter jsonWriter, InteractionCollection interactionCollection2) {
            a.n0(this.a, jsonWriter, interactionCollection2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (InteractionCollection)object2);
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
        public void b(JsonWriter jsonWriter, VideoList videoList2) {
            a.H0(this.a, jsonWriter, videoList2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VideoList)object2);
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
        public void b(JsonWriter jsonWriter, Metadata metadata2) {
            a.o0(this.a, jsonWriter, metadata2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Metadata)object2);
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
        public void b(JsonWriter jsonWriter, VideoLog videoLog2) {
            a.R0(this.a, jsonWriter, videoLog2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VideoLog)object2);
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
        public void b(JsonWriter jsonWriter, Paging paging2) {
            a.p0(this.a, jsonWriter, paging2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Paging)object2);
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
        public void b(JsonWriter jsonWriter, VideosPreference videosPreference2) {
            a.I0(this.a, jsonWriter, videosPreference2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VideosPreference)object2);
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
        public void b(JsonWriter jsonWriter, Picture picture2) {
            a.q0(this.a, jsonWriter, picture2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Picture)object2);
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
        public void b(JsonWriter jsonWriter, VimeoAccount vimeoAccount2) {
            a.J0(this.a, jsonWriter, vimeoAccount2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VimeoAccount)object2);
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
        public void b(JsonWriter jsonWriter, PictureCollection pictureCollection2) {
            a.r0(this.a, jsonWriter, pictureCollection2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (PictureCollection)object2);
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
        public void b(JsonWriter jsonWriter, VodItem vodItem2) {
            a.L0(this.a, jsonWriter, vodItem2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VodItem)object2);
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
        public void b(JsonWriter jsonWriter, PictureResource pictureResource2) {
            a.s0(this.a, jsonWriter, pictureResource2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (PictureResource)object2);
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
        public void b(JsonWriter jsonWriter, VodList vodList2) {
            a.M0(this.a, jsonWriter, vodList2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (VodList)object2);
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
        public void b(JsonWriter jsonWriter, PinCodeInfo pinCodeInfo2) {
            a.t0(this.a, jsonWriter, pinCodeInfo2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (PinCodeInfo)object2);
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
        public void b(JsonWriter jsonWriter, Website website2) {
            a.N0(this.a, jsonWriter, website2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Website)object2);
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
        public void b(JsonWriter jsonWriter, Play play2) {
            a.P0(this.a, jsonWriter, play2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Play)object2);
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
        public void b(JsonWriter jsonWriter, PlayProgress playProgress2) {
            a.Q0(this.a, jsonWriter, playProgress2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (PlayProgress)object2);
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
        public void b(JsonWriter jsonWriter, Preferences preferences2) {
            a.u0(this.a, jsonWriter, preferences2);
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            b(jsonWriter, (Preferences)object2);
        }
    }
    static <T> T a(Gson gson, Class<T> class2, JsonReader jsonReader3) {
        return gson.getAdapter(class2).read(jsonReader3);
    }

    static <T> ArrayList<T> b(Gson gson, Class<T> class2, JsonReader jsonReader3) {
        Class obj2;
        ArrayList arrayList = new ArrayList();
        while (jsonReader3.hasNext()) {
            arrayList.add(gson.getAdapter(class2).read(jsonReader3));
        }
        return arrayList;
    }

    static <T> void c(Gson gson, Class<T> class2, JsonWriter jsonWriter3, ArrayList<T> arrayList4) {
        Object obj3;
        final Iterator obj1 = arrayList4.iterator();
        for (Object obj3 : obj1) {
            gson.getAdapter(class2).write(jsonWriter3, obj3);
        }
    }

    static <T> void d(Gson gson, Class<T> class2, JsonWriter jsonWriter3, T t4) {
        gson.getAdapter(class2).write(jsonWriter3, t4);
    }
}
