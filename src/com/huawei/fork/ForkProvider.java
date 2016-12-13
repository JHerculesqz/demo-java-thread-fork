package com.huawei.fork;

import com.huawei._1_fw.fork.MsMapReduceUtils;

public class ForkProvider {
	// #region test

	public static void test() {
		MsMapReduceUtils.run(2000, () -> {
			return new MainTask();
		} , (strRes) -> {
			System.out.println(strRes);
		} , (oEx) -> {
			oEx.printStackTrace();
		} , (oTimeoutEx) -> {
			System.out.println("isAlive timeout...");
		});
	}

	// #endregion
}
