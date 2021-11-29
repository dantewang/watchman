package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.target.TargetResult;

/**
 * @author Dante Wang
 */
public interface Action {

	String onResult(TargetResult targetResult) throws Exception;

}