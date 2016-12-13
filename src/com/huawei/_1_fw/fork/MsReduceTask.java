package com.huawei._1_fw.fork;

import java.util.concurrent.RecursiveTask;

public abstract class MsReduceTask<T> extends RecursiveTask<T> {
	// #region Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 685664509724744126L;

	// #endregon

	// #region compute

	@Override
	protected T compute() {
		return computeEx();
	}

	public abstract T computeEx();

	// #endregion
}
