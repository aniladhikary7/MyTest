
package com.anil.mytest.userPayload;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("current")
    private String mCurrent;
    @SerializedName("next")
    private String mNext;
    @SerializedName("previous")
    private Object mPrevious;

    public String getCurrent() {
        return mCurrent;
    }

    public void setCurrent(String current) {
        mCurrent = current;
    }

    public String getNext() {
        return mNext;
    }

    public void setNext(String next) {
        mNext = next;
    }

    public Object getPrevious() {
        return mPrevious;
    }

    public void setPrevious(Object previous) {
        mPrevious = previous;
    }

}
