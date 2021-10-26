
package com.anil.mytest.userPayload;

import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("pagination")
    private Pagination mPagination;

    public Pagination getPagination() {
        return mPagination;
    }

    public void setPagination(Pagination pagination) {
        mPagination = pagination;
    }

}
