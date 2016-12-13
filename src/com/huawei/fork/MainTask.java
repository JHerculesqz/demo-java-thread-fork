package com.huawei.fork;

import java.util.ArrayList;
import java.util.List;

import com.huawei._1_fw.fork.MsMapTask;

public class MainTask extends MsMapTask<String> {
	// #region Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2135237580162083319L;

	// #endregion

	// #region computeEx

	@Override
	public String computeEx() {
		String strRes = "";

		// 1.map
		List<SubTask> lstSubTasks = new ArrayList<SubTask>();
		for (int i = 0; i < 10; i++) {
			SubTask oSubTask = new SubTask(i);
			lstSubTasks.add(oSubTask);
			oSubTask.fork();
		}

		// 2.reduce
		for (SubTask oSubTask : lstSubTasks) {
			strRes += oSubTask.join();
		}

		return strRes;
	}

	// #endregion
}
