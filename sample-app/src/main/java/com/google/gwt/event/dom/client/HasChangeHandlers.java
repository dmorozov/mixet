package com.google.gwt.event.dom.client;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasChangeHandlers
{
	/**
	 * Adds a {@link ChangeEvent} handler.
	 * 
	 * @param handler
	 *        the change handler
	 * @return {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addChangeHandler(ChangeHandler handler);
}
