package com.google.gwt.user.client.ui;

public class Composite extends Widget
{
	private IsWidget widget;

	protected Composite()
	{
	}

	protected void initWidget(IsWidget widget)
	{
		assert this.widget == null : "Composite's widget can only be set once";
		this.widget = widget;

		setElement(widget.asWidget().getElement());
	}

	protected Widget getWidget()
	{
		return widget.asWidget();
	}
}
