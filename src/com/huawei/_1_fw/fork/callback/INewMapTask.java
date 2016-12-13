package com.huawei._1_fw.fork.callback;

import com.huawei._1_fw.fork.MsMapTask;

@FunctionalInterface
public interface INewMapTask<T> {
	MsMapTask<T> build();
}
