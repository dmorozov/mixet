package com.google.gwt.user.client.ui;

import elemental.js.dom.JsElement;

public class Widget implements IsWidget
{
	private JsElement element;

	@Override
	public Widget asWidget()
	{
		return this;
	}

	public JsElement getElement()
	{
		return element;
	}

	public void setElement(JsElement element)
	{
		assert this.element == null : "the root element of a widget cannot be changed once set";
		this.element = element;
		setElementWidget(element, this);
	}

	protected static final native void setElementWidget(JsElement element, Widget widget)
	/*-{
		element.__widget = widget;
	}-*/;

	protected static final native Widget getElementWidget(JsElement element)
	/*-{
		return element.__widget || null;
	}-*/;
}
