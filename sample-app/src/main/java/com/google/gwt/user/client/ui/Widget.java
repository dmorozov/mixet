package com.google.gwt.user.client.ui;

import elemental.js.dom.JsElement;

public interface Widget
{
	/**
	 * JsElement seems to replace dom.Element and user.Element
	 * 
	 * @return
	 */
	JsElement getElement();
}
