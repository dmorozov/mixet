package com.google.gwt.user.client.ui;

import elemental.js.JsBrowser;
import elemental.js.dom.JsElement;
import elemental.js.dom.JsNode;
import elemental.js.html.JsDivElement;

public class VerticalPanel extends Widget implements InsertPanel.ForIsWidget
{
	public VerticalPanel()
	{
		JsDivElement div = JsBrowser.getDocument().createDivElement();
		div.getClassList().add("gwt-VerticalPanel");
		setElement(div);
	}

	@Override
	public void add(Widget w)
	{
		getElement().appendChild(w.getElement());
	}

	@Override
	public void insert(Widget w, int beforeIndex)
	{
		JsNode refChild = getElement().getChildNodes().item(beforeIndex);
		getElement().insertBefore(w.getElement(), refChild);
	}

	@Override
	public Widget getWidget(int index)
	{
		JsNode refChild = getElement().getChildren().item(index);
		return getElementWidget((JsElement)refChild);
	}

	@Override
	public int getWidgetCount()
	{
		return getElement().getChildElementCount();
	}

	@Override
	public int getWidgetIndex(Widget child)
	{
		int count = getWidgetCount();
		for (int i = 0; i < count; i++)
			if (getWidget(i) == child)
				return i;
		return 0;
	}

	@Override
	public boolean remove(int index)
	{
		getElement().removeChild(getElement().getChildren().item(index));
		return false;
	}

	@Override
	public int getWidgetIndex(IsWidget child)
	{
		return getWidgetIndex(child.asWidget());
	}

	@Override
	public void add(IsWidget w)
	{
		add(w.asWidget());
	}

	@Override
	public void insert(IsWidget w, int beforeIndex)
	{
		insert(w.asWidget(), beforeIndex);
	}
}
