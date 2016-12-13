package com.huawei._1_fw.fork;

import java.util.concurrent.RecursiveTask;

public abstract class MsMapTask<T> extends RecursiveTask<T> {
	// #region Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -514215077475788235L;

	// #endregon

	// #region compute

	@Override
	protected T compute() {
		return computeEx();
	}

	public abstract T computeEx();

	// #endregion
}
