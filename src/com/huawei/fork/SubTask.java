package com.huawei.fork;

import java.util.concurrent.RecursiveTask;

public class SubTask<T> extends RecursiveTask<T> {
	// #region Const

	private static final long serialVersionUID = -7999298795162980055L;

	// #endregion

	// #region Fields

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

	@SuppressWarnings("unchecked")
	@Override
	protected T compute() {
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		String strRes = "Task_" + this.taskId + ";";
		return (T) strRes;
	}

	// #endregion
}
