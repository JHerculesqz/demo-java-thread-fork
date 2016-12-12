package com.huawei.fork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ForkProvider {
	// #region test

	public static void test() {
		ForkJoinPool oForkJoinPool = new ForkJoinPool();
		MainTask<String> oMainTask = new MainTask<String>();
		ForkJoinTask<String> oRes = oForkJoinPool.submit(oMainTask);
		try {
			String strRes = oRes.get(2000, TimeUnit.MILLISECONDS);
			System.out.println(strRes);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("isAlive timeout...");
		}
	}

	// #endregion
}
