package com.huawei._1_fw.fork.callback;

import java.util.concurrent.TimeoutException;

@FunctionalInterface
public interface IGetResultTimeout {
	void timeout(TimeoutException oEx);
}
