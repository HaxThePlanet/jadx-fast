package com.google.firebase.database.connection;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class CompoundHash {

    private final List<String> hashes;
    private final List<List<String>> posts;
    public CompoundHash(List<List<String>> list, List<String> list2) {
        super();
        if (list.size() != size2--) {
        } else {
            this.posts = list;
            this.hashes = list2;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        throw obj3;
    }

    public List<String> getHashes() {
        return Collections.unmodifiableList(this.hashes);
    }

    public List<List<String>> getPosts() {
        return Collections.unmodifiableList(this.posts);
    }
}
