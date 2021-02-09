package com.aindri.retrofitarrayjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonArray {

    @SerializedName("Success")
    @Expose
    private Model[] modelarray;

    public Model[] getModelarray() {
        return modelarray;
    }

    public void setModelarray(Model[] modelarray) {
        this.modelarray = modelarray;
    }




    //Alternative Method

//    private Model[] Success;
//
//    public Model[] getSuccess() {
//        return Success;
//    }
//
//    public void setSuccess(Model[] success) {
//        Success = success;
//    }


}
