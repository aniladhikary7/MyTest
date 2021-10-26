
package com.anil.mytest.userPayload;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class UserResponse {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("meta")
    private Meta mMeta;

    public UserResponse(
            List<Datum> mData,
            Meta mMeta
    ){
        this.mData = mData;
        this.mMeta = mMeta;
    }

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public Meta getMeta() {
        return mMeta;
    }

    public void setMeta(Meta meta) {
        mMeta = meta;
    }

}
