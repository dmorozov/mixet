package com.google.gwt.user.client.ui;

public interface IndexedPanel
{
	/**
	 * Extends this interface with convenience methods to handle {@link IsWidget}.
	 */
	interface ForIsWidget extends IndexedPanel
	{
		int getWidgetIndex(IsWidget child);
	}

	/**
	 * Gets the child widget at the specified index.
	 * 
	 * @param index
	 *        the child widget's index
	 * @return the child widget
	 */
	Widget getWidget(int index);

	/**
	 * Gets the number of child widgets in this panel.
	 * 
	 * @return the number of children
	 */
	int getWidgetCount();

	/**
	 * Gets the index of the specified child widget.
	 * 
	 * @param child
	 *        the widget to be found
	 * @return the widget's index, or <code>-1</code> if it is not a child of this panel
	 */
	int getWidgetIndex(Widget child);

	/**
	 * Removes the widget at the specified index.
	 * 
	 * @param index
	 *        the index of the widget to be removed
	 * @return <code>false</code> if the widget is not present
	 */
	boolean remove(int index);
}
