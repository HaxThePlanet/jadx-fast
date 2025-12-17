package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Connection implements Serializable {

    private static final long serialVersionUID = -840088720891343176L;
    public int extraTotal;
    public int mainTotal;
    public ArrayList<String> options;
    public int total;
    public String uri;
    public int viewableTotal;
}
