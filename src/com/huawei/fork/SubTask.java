package com.huawei.fork;

import com.huawei._1_fw.fork.MsMapTask;

public class SubTask extends MsMapTask<String> {
	// #region Fields

	private static final long serialVersionUID = -7999298795162980055L;

	private int taskId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	// #endregion

	// #region Construction

	public SubTask(int iTaskId) {
		this.taskId = iTaskId;
	}

	// #endregion

	// #region compute

	@Override
	public String computeEx() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String strRes = "Task_" + this.taskId + ";";
		return strRes;
	}

	// #endregion
}
