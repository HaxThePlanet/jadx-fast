package com.vimeo.networking.model.search;

import com.vimeo.networking.model.Channel;
import com.vimeo.networking.model.Group;
import com.vimeo.networking.model.User;
import com.vimeo.networking.model.Video;
import com.vimeo.networking.model.VodItem;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class SearchResult implements Serializable {

    private static final long serialVersionUID = -1607389617833091383L;
    public Channel mChannel;
    public Group mGroup;
    public boolean mIsFeatured;
    public boolean mIsStaffPick;
    public com.vimeo.networking.model.search.SearchType mSearchType;
    public User mUser;
    public Video mVideo;
    public VodItem mVod;
}
