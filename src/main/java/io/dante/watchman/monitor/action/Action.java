package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.Result;

/**
 * @author Dante Wang
 */
public interface Action {

	void execute(Result result) throws Exception;

}