package com.huawei.fork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MainTask<T> extends RecursiveTask<T> {
	// #region Fields

	private static final long serialVersionUID = -7999298795162980055L;

	// #endregion

	// #region compute

	@SuppressWarnings("unchecked")
	@Override
	protected T compute() {
		String strRes = "";

		// 1.map
		List<SubTask<T>> lstSubTasks = new ArrayList<SubTask<T>>();
		for (int i = 0; i < 10; i++) {
			SubTask<T> oSubTask = new SubTask<T>(i);
			lstSubTasks.add(oSubTask);
			oSubTask.fork();
		}

		// 2.reduce
		for (SubTask<T> oSubTask : lstSubTasks) {
			strRes += oSubTask.join();
		}

		return (T) strRes;
	}

	// #endregion
}
