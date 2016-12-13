package com.huawei._1_fw.fork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.huawei._1_fw.fork.callback.IGetResult;
import com.huawei._1_fw.fork.callback.IGetResultException;
import com.huawei._1_fw.fork.callback.IGetResultTimeout;
import com.huawei._1_fw.fork.callback.INewMapTask;

public class MsMapReduceUtils {
	// #region run

	public static <T> void run(long iTimeout, INewMapTask<T> oINewMapTask, IGetResult<T> oIGetResult,
			IGetResultException oIGetResultException, IGetResultTimeout oIGetResultTimeout) {
		// 1.get oForkJoinPool
		ForkJoinPool oForkJoinPool = new ForkJoinPool();

		// 2.generate oMsMapTask
		MsMapTask<T> oMsMapTask = oINewMapTask.build();

		// 3.submit oMsMapTask,then get oForkJoinTask
		ForkJoinTask<T> oForkJoinTask = oForkJoinPool.submit(oMsMapTask);

		// 4.oForkJoinTask.get
		try {
			T oRes = oForkJoinTask.get(iTimeout, TimeUnit.MILLISECONDS);
			// 4.1.when success
			oIGetResult.get(oRes);
		} catch (InterruptedException e) {
			// 4.2.when exception
			oIGetResultException.dead(e);
		} catch (ExecutionException e) {
			// 4.2.when exception
			oIGetResultException.dead(e);
		} catch (TimeoutException e) {
			// 4.3.when timeout
			oIGetResultTimeout.timeout(e);
		}
	}

	// #endregion
}
