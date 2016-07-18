package com.geekandroid.sdk.pay.impl;

import com.commonslibrary.commons.net.RequestCallBack;
import com.geekandroid.sdk.pay.IPay;

import java.util.Map;


public abstract class CHCashPay extends IPay {
    @Override
    public void getPayParam(Map<String, Object> params, RequestCallBack<String> callBack) {
        throw  new IllegalStateException("不需要调用此方法");
    }
    @Override
    public void getPayResult(Map<String, Object> params, RequestCallBack<String> callBack) {
        throw  new IllegalStateException("不需要调用此方法");
    }

    @Override
    public void requestOrder(Map<String, Object> params, RequestCallBack<String> callBack) {

    }
}
