package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.target.TargetResult;

/**
 * @author Dante Wang
 */
public interface Action {

	String on(TargetResult targetResult) throws Exception;

}