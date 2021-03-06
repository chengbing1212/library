package com.commonslibrary.commons.net;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.commonslibrary.commons.utils.DeviceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * date        :  2016-02-22  17:31
 * author      :  Mickaecle gizthon
 * description :
 */
public class BaseRemoteModel implements IRequestRemote {

    private Context mContext;

    public BaseRemoteModel() {

    }

    public BaseRemoteModel(Object object) {

        if (object instanceof android.app.Fragment) {
            android.app.Fragment fragment = (android.app.Fragment) object;
            mContext = fragment.getActivity();

        } else if (object instanceof android.support.v4.app.Fragment) {
            android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) object;
            mContext = fragment.getActivity();
        } else if (object instanceof Activity) {
            mContext = (Activity) object;
        } else if (object instanceof Application) {
            mContext = ((Application) object).getApplicationContext();
        }

    }
    public void setTag(Object tag){
        DefaultOkHttpIml.getInstance().setTag(tag);
    }

    public void cancelRquest(Object tag){
        DefaultOkHttpIml.getInstance().cancelTag(tag);
    }

    public void cancelAllRequest(){
        DefaultOkHttpIml.getInstance().cancelAllTag();
    }

    public Map<String, Object> getExtraParameter() {
        Map<String, Object> parameters = new HashMap<>();

        if (mContext != null) {
            parameters.put("app_version", DeviceUtils.getAppVersionName(mContext));
            parameters.put("app_code", DeviceUtils.getAppVersionCode(mContext));
        }
        return parameters;
    }




    @Override
    public <T> void doGet(String url, Map<String, Object> parameters, RequestCallBack<T> callBack) {
        parameters.putAll(getExtraParameter());
        DefaultOkHttpIml.getInstance().doGet(url, parameters, callBack);
    }

    @Override
    public <T> void doPost(String url, Map<String, Object> parameters, RequestCallBack<T> callBack) {
        parameters.putAll(getExtraParameter());
        DefaultOkHttpIml.getInstance().doPost(url, parameters, callBack);
    }

    @Override
    public <T> void doUpload(String url, Map<String, Object> parameters, Map<String, File> map, RequestCallBack<T> callBack) {
        parameters.putAll(getExtraParameter());
        DefaultOkHttpIml.getInstance().doUpload(url, parameters, map, callBack);
    }

    @Override
    public <T> void doDownLoad(String url, Map<String, Object> parameters, RequestCallBack<T> callBack) {
        parameters.putAll(getExtraParameter());
        DefaultOkHttpIml.getInstance().doDownLoad(url, parameters, callBack);
    }
}
