package com.example.demo;

import java.io.Serializable;

public class Response  implements Serializable {

   String url;
   long size;

    public Response(String url, long size) {
        this.url = url;
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
